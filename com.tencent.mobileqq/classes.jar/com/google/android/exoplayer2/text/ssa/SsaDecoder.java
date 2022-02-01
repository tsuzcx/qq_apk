package com.google.android.exoplayer2.text.ssa;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.LongArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class SsaDecoder
  extends SimpleSubtitleDecoder
{
  private static final String DIALOGUE_LINE_PREFIX = "Dialogue: ";
  private static final String FORMAT_LINE_PREFIX = "Format: ";
  private static final Pattern SSA_TIMECODE_PATTERN = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)(?::|\\.)(\\d+)");
  private static final String TAG = "SsaDecoder";
  private int formatEndIndex;
  private int formatKeyCount;
  private int formatStartIndex;
  private int formatTextIndex;
  private final boolean haveInitializationData;
  
  public SsaDecoder()
  {
    this(null);
  }
  
  public SsaDecoder(List<byte[]> paramList)
  {
    super("SsaDecoder");
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.haveInitializationData = true;
      String str = new String((byte[])paramList.get(0));
      Assertions.checkArgument(str.startsWith("Format: "));
      parseFormatLine(str);
      parseHeader(new ParsableByteArray((byte[])paramList.get(1)));
      return;
    }
    this.haveInitializationData = false;
  }
  
  private void parseDialogueLine(String paramString, List<Cue> paramList, LongArray paramLongArray)
  {
    if (this.formatKeyCount == 0) {
      Log.w("SsaDecoder", "Skipping dialogue line before complete format: " + paramString);
    }
    long l1;
    do
    {
      return;
      String[] arrayOfString = paramString.substring("Dialogue: ".length()).split(",", this.formatKeyCount);
      if (arrayOfString.length != this.formatKeyCount)
      {
        Log.w("SsaDecoder", "Skipping dialogue line with fewer columns than format: " + paramString);
        return;
      }
      long l3 = parseTimecodeUs(arrayOfString[this.formatStartIndex]);
      if (l3 == -9223372036854775807L)
      {
        Log.w("SsaDecoder", "Skipping invalid timing: " + paramString);
        return;
      }
      String str = arrayOfString[this.formatEndIndex];
      if (!str.trim().isEmpty())
      {
        long l2 = parseTimecodeUs(str);
        l1 = l2;
        if (l2 == -9223372036854775807L) {
          Log.w("SsaDecoder", "Skipping invalid timing: " + paramString);
        }
      }
      else
      {
        l1 = -9223372036854775807L;
      }
      paramList.add(new Cue(arrayOfString[this.formatTextIndex].replaceAll("\\{.*?\\}", "").replaceAll("\\\\N", "\n").replaceAll("\\\\n", "\n")));
      paramLongArray.add(l3);
    } while (l1 == -9223372036854775807L);
    paramList.add(null);
    paramLongArray.add(l1);
  }
  
  private void parseEventBody(ParsableByteArray paramParsableByteArray, List<Cue> paramList, LongArray paramLongArray)
  {
    for (;;)
    {
      String str = paramParsableByteArray.readLine();
      if (str == null) {
        break;
      }
      if ((!this.haveInitializationData) && (str.startsWith("Format: "))) {
        parseFormatLine(str);
      } else if (str.startsWith("Dialogue: ")) {
        parseDialogueLine(str, paramList, paramLongArray);
      }
    }
  }
  
  private void parseFormatLine(String paramString)
  {
    paramString = TextUtils.split(paramString.substring("Format: ".length()), ",");
    this.formatKeyCount = paramString.length;
    this.formatStartIndex = -1;
    this.formatEndIndex = -1;
    this.formatTextIndex = -1;
    int j = 0;
    if (j < this.formatKeyCount)
    {
      String str = Util.toLowerInvariant(paramString[j].trim());
      label96:
      int i;
      switch (str.hashCode())
      {
      default: 
        i = -1;
        label98:
        switch (i)
        {
        }
        break;
      }
      for (;;)
      {
        j += 1;
        break;
        if (!str.equals("start")) {
          break label96;
        }
        i = 0;
        break label98;
        if (!str.equals("end")) {
          break label96;
        }
        i = 1;
        break label98;
        if (!str.equals("text")) {
          break label96;
        }
        i = 2;
        break label98;
        this.formatStartIndex = j;
        continue;
        this.formatEndIndex = j;
        continue;
        this.formatTextIndex = j;
      }
    }
    if ((this.formatStartIndex == -1) || (this.formatEndIndex == -1) || (this.formatTextIndex == -1)) {
      this.formatKeyCount = 0;
    }
  }
  
  private void parseHeader(ParsableByteArray paramParsableByteArray)
  {
    String str;
    do
    {
      str = paramParsableByteArray.readLine();
    } while ((str != null) && (!str.startsWith("[Events]")));
  }
  
  public static long parseTimecodeUs(String paramString)
  {
    paramString = SSA_TIMECODE_PATTERN.matcher(paramString);
    if (!paramString.matches()) {
      return -9223372036854775807L;
    }
    long l1 = Long.parseLong(paramString.group(1));
    long l2 = Long.parseLong(paramString.group(2));
    long l3 = Long.parseLong(paramString.group(3));
    return Long.parseLong(paramString.group(4)) * 10000L + (l1 * 60L * 60L * 1000000L + l2 * 60L * 1000000L + l3 * 1000000L);
  }
  
  protected SsaSubtitle decode(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    LongArray localLongArray = new LongArray();
    paramArrayOfByte = new ParsableByteArray(paramArrayOfByte, paramInt);
    if (!this.haveInitializationData) {
      parseHeader(paramArrayOfByte);
    }
    parseEventBody(paramArrayOfByte, localArrayList, localLongArray);
    paramArrayOfByte = new Cue[localArrayList.size()];
    localArrayList.toArray(paramArrayOfByte);
    return new SsaSubtitle(paramArrayOfByte, localLongArray.toArray());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.text.ssa.SsaDecoder
 * JD-Core Version:    0.7.0.1
 */