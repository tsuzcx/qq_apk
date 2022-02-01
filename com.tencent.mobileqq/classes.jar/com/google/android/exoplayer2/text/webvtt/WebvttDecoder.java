package com.google.android.exoplayer2.text.webvtt;

import android.text.TextUtils;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.List;

public final class WebvttDecoder
  extends SimpleSubtitleDecoder
{
  private static final String COMMENT_START = "NOTE";
  private static final int EVENT_COMMENT = 1;
  private static final int EVENT_CUE = 3;
  private static final int EVENT_END_OF_FILE = 0;
  private static final int EVENT_NONE = -1;
  private static final int EVENT_STYLE_BLOCK = 2;
  private static final String STYLE_START = "STYLE";
  private final CssParser cssParser = new CssParser();
  private final WebvttCueParser cueParser = new WebvttCueParser();
  private final List<WebvttCssStyle> definedStyles = new ArrayList();
  private final ParsableByteArray parsableWebvttData = new ParsableByteArray();
  private final WebvttCue.Builder webvttCueBuilder = new WebvttCue.Builder();
  
  public WebvttDecoder()
  {
    super("WebvttDecoder");
  }
  
  private static int getNextEvent(ParsableByteArray paramParsableByteArray)
  {
    int j = 0;
    int i = -1;
    if (i == -1)
    {
      j = paramParsableByteArray.getPosition();
      String str = paramParsableByteArray.readLine();
      if (str == null) {
        i = 0;
      }
      for (;;)
      {
        break;
        if ("STYLE".equals(str)) {
          i = 2;
        } else if ("NOTE".startsWith(str)) {
          i = 1;
        } else {
          i = 3;
        }
      }
    }
    paramParsableByteArray.setPosition(j);
    return i;
  }
  
  private static void skipComment(ParsableByteArray paramParsableByteArray)
  {
    while (!TextUtils.isEmpty(paramParsableByteArray.readLine())) {}
  }
  
  protected WebvttSubtitle decode(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    this.parsableWebvttData.reset(paramArrayOfByte, paramInt);
    this.webvttCueBuilder.reset();
    this.definedStyles.clear();
    WebvttParserUtil.validateWebvttHeaderLine(this.parsableWebvttData);
    while (!TextUtils.isEmpty(this.parsableWebvttData.readLine())) {}
    paramArrayOfByte = new ArrayList();
    for (;;)
    {
      paramInt = getNextEvent(this.parsableWebvttData);
      if (paramInt == 0) {
        break;
      }
      if (paramInt == 1)
      {
        skipComment(this.parsableWebvttData);
      }
      else if (paramInt == 2)
      {
        if (!paramArrayOfByte.isEmpty()) {
          throw new SubtitleDecoderException("A style block was found after the first cue.");
        }
        this.parsableWebvttData.readLine();
        WebvttCssStyle localWebvttCssStyle = this.cssParser.parseBlock(this.parsableWebvttData);
        if (localWebvttCssStyle != null) {
          this.definedStyles.add(localWebvttCssStyle);
        }
      }
      else if ((paramInt == 3) && (this.cueParser.parseCue(this.parsableWebvttData, this.webvttCueBuilder, this.definedStyles)))
      {
        paramArrayOfByte.add(this.webvttCueBuilder.build());
        this.webvttCueBuilder.reset();
      }
    }
    return new WebvttSubtitle(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.text.webvtt.WebvttDecoder
 * JD-Core Version:    0.7.0.1
 */