package com.google.android.exoplayer2.text;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.Collections;
import java.util.List;

public final class TextRenderer
  extends BaseRenderer
  implements Handler.Callback
{
  private static final int MSG_UPDATE_OUTPUT = 0;
  private static final int REPLACEMENT_STATE_NONE = 0;
  private static final int REPLACEMENT_STATE_SIGNAL_END_OF_STREAM = 1;
  private static final int REPLACEMENT_STATE_WAIT_END_OF_STREAM = 2;
  private SubtitleDecoder decoder;
  private final SubtitleDecoderFactory decoderFactory;
  private int decoderReplacementState;
  private final FormatHolder formatHolder;
  private boolean inputStreamEnded;
  private SubtitleInputBuffer nextInputBuffer;
  private SubtitleOutputBuffer nextSubtitle;
  private int nextSubtitleEventIndex;
  private final TextOutput output;
  private final Handler outputHandler;
  private boolean outputStreamEnded;
  private Format streamFormat;
  private SubtitleOutputBuffer subtitle;
  
  public TextRenderer(TextOutput paramTextOutput, Looper paramLooper)
  {
    this(paramTextOutput, paramLooper, SubtitleDecoderFactory.DEFAULT);
  }
  
  public TextRenderer(TextOutput paramTextOutput, Looper paramLooper, SubtitleDecoderFactory paramSubtitleDecoderFactory)
  {
    super(3);
    this.output = ((TextOutput)Assertions.checkNotNull(paramTextOutput));
    if (paramLooper == null) {
      paramTextOutput = null;
    } else {
      paramTextOutput = new Handler(paramLooper, this);
    }
    this.outputHandler = paramTextOutput;
    this.decoderFactory = paramSubtitleDecoderFactory;
    this.formatHolder = new FormatHolder();
  }
  
  private void clearOutput()
  {
    updateOutput(Collections.emptyList());
  }
  
  private long getNextEventTime()
  {
    int i = this.nextSubtitleEventIndex;
    if ((i != -1) && (i < this.subtitle.getEventTimeCount())) {
      return this.subtitle.getEventTime(this.nextSubtitleEventIndex);
    }
    return 9223372036854775807L;
  }
  
  private void invokeUpdateOutputInternal(List<Cue> paramList)
  {
    this.output.onCues(paramList);
  }
  
  private void releaseBuffers()
  {
    this.nextInputBuffer = null;
    this.nextSubtitleEventIndex = -1;
    SubtitleOutputBuffer localSubtitleOutputBuffer = this.subtitle;
    if (localSubtitleOutputBuffer != null)
    {
      localSubtitleOutputBuffer.release();
      this.subtitle = null;
    }
    localSubtitleOutputBuffer = this.nextSubtitle;
    if (localSubtitleOutputBuffer != null)
    {
      localSubtitleOutputBuffer.release();
      this.nextSubtitle = null;
    }
  }
  
  private void releaseDecoder()
  {
    releaseBuffers();
    this.decoder.release();
    this.decoder = null;
    this.decoderReplacementState = 0;
  }
  
  private void replaceDecoder()
  {
    releaseDecoder();
    this.decoder = this.decoderFactory.createDecoder(this.streamFormat);
  }
  
  private void updateOutput(List<Cue> paramList)
  {
    Handler localHandler = this.outputHandler;
    if (localHandler != null)
    {
      localHandler.obtainMessage(0, paramList).sendToTarget();
      return;
    }
    invokeUpdateOutputInternal(paramList);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0)
    {
      invokeUpdateOutputInternal((List)paramMessage.obj);
      return true;
    }
    throw new IllegalStateException();
  }
  
  public boolean isEnded()
  {
    return this.outputStreamEnded;
  }
  
  public boolean isReady()
  {
    return true;
  }
  
  protected void onDisabled()
  {
    this.streamFormat = null;
    clearOutput();
    releaseDecoder();
  }
  
  protected void onPositionReset(long paramLong, boolean paramBoolean)
  {
    clearOutput();
    this.inputStreamEnded = false;
    this.outputStreamEnded = false;
    if (this.decoderReplacementState != 0)
    {
      replaceDecoder();
      return;
    }
    releaseBuffers();
    this.decoder.flush();
  }
  
  protected void onStreamChanged(Format[] paramArrayOfFormat, long paramLong)
  {
    this.streamFormat = paramArrayOfFormat[0];
    if (this.decoder != null)
    {
      this.decoderReplacementState = 1;
      return;
    }
    this.decoder = this.decoderFactory.createDecoder(this.streamFormat);
  }
  
  public void render(long paramLong1, long paramLong2)
  {
    if (this.outputStreamEnded) {
      return;
    }
    if (this.nextSubtitle == null)
    {
      this.decoder.setPositionUs(paramLong1);
      try
      {
        this.nextSubtitle = ((SubtitleOutputBuffer)this.decoder.dequeueOutputBuffer());
      }
      catch (SubtitleDecoderException localSubtitleDecoderException1)
      {
        throw ExoPlaybackException.createForRenderer(localSubtitleDecoderException1, getIndex());
      }
    }
    if (getState() != 2) {
      return;
    }
    if (this.subtitle != null)
    {
      paramLong2 = getNextEventTime();
      for (i = 0; paramLong2 <= paramLong1; i = 1)
      {
        this.nextSubtitleEventIndex += 1;
        paramLong2 = getNextEventTime();
      }
    }
    int i = 0;
    SubtitleOutputBuffer localSubtitleOutputBuffer = this.nextSubtitle;
    int j = i;
    if (localSubtitleOutputBuffer != null) {
      if (localSubtitleOutputBuffer.isEndOfStream())
      {
        j = i;
        if (i == 0)
        {
          j = i;
          if (getNextEventTime() == 9223372036854775807L) {
            if (this.decoderReplacementState == 2)
            {
              replaceDecoder();
              j = i;
            }
            else
            {
              releaseBuffers();
              this.outputStreamEnded = true;
              j = i;
            }
          }
        }
      }
      else
      {
        j = i;
        if (this.nextSubtitle.timeUs <= paramLong1)
        {
          localSubtitleOutputBuffer = this.subtitle;
          if (localSubtitleOutputBuffer != null) {
            localSubtitleOutputBuffer.release();
          }
          this.subtitle = this.nextSubtitle;
          this.nextSubtitle = null;
          this.nextSubtitleEventIndex = this.subtitle.getNextEventTimeIndex(paramLong1);
          j = 1;
        }
      }
    }
    if (j != 0) {
      updateOutput(this.subtitle.getCues(paramLong1));
    }
    if (this.decoderReplacementState == 2) {
      return;
    }
    label448:
    ExoPlaybackException localExoPlaybackException;
    try
    {
      do
      {
        for (;;)
        {
          if (this.inputStreamEnded) {
            break label448;
          }
          if (this.nextInputBuffer == null)
          {
            this.nextInputBuffer = ((SubtitleInputBuffer)this.decoder.dequeueInputBuffer());
            if (this.nextInputBuffer == null) {
              return;
            }
          }
          if (this.decoderReplacementState == 1)
          {
            this.nextInputBuffer.setFlags(4);
            this.decoder.queueInputBuffer(this.nextInputBuffer);
            this.nextInputBuffer = null;
            this.decoderReplacementState = 2;
            return;
          }
          i = readSource(this.formatHolder, this.nextInputBuffer, false);
          if (i != -4) {
            break;
          }
          if (this.nextInputBuffer.isEndOfStream())
          {
            this.inputStreamEnded = true;
          }
          else
          {
            this.nextInputBuffer.subsampleOffsetUs = this.formatHolder.format.subsampleOffsetUs;
            this.nextInputBuffer.flip();
          }
          this.decoder.queueInputBuffer(this.nextInputBuffer);
          this.nextInputBuffer = null;
        }
      } while (i != -3);
      return;
    }
    catch (SubtitleDecoderException localSubtitleDecoderException2)
    {
      localExoPlaybackException = ExoPlaybackException.createForRenderer(localSubtitleDecoderException2, getIndex());
    }
    for (;;)
    {
      throw localExoPlaybackException;
    }
  }
  
  public int supportsFormat(Format paramFormat)
  {
    if (this.decoderFactory.supportsFormat(paramFormat))
    {
      if (supportsFormatDrm(null, paramFormat.drmInitData)) {
        return 4;
      }
      return 2;
    }
    if (MimeTypes.isText(paramFormat.sampleMimeType)) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.text.TextRenderer
 * JD-Core Version:    0.7.0.1
 */