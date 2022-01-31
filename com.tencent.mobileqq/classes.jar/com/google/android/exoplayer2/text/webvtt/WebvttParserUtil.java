package com.google.android.exoplayer2.text.webvtt;

import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class WebvttParserUtil
{
  private static final Pattern COMMENT = Pattern.compile("^NOTE(( |\t).*)?$");
  private static final Pattern HEADER = Pattern.compile("^﻿?WEBVTT(( |\t).*)?$");
  
  public static Matcher findNextCueHeader(ParsableByteArray paramParsableByteArray)
  {
    Object localObject;
    do
    {
      localObject = paramParsableByteArray.readLine();
      if (localObject == null) {
        break;
      }
      if (COMMENT.matcher((CharSequence)localObject).matches()) {
        for (;;)
        {
          localObject = paramParsableByteArray.readLine();
          if ((localObject == null) || (((String)localObject).isEmpty())) {
            break;
          }
        }
      }
      localObject = WebvttCueParser.CUE_HEADER_PATTERN.matcher((CharSequence)localObject);
    } while (!((Matcher)localObject).matches());
    return localObject;
    return null;
  }
  
  public static float parsePercentage(String paramString)
  {
    if (!paramString.endsWith("%")) {
      throw new NumberFormatException("Percentages must end with %");
    }
    return Float.parseFloat(paramString.substring(0, paramString.length() - 1)) / 100.0F;
  }
  
  public static long parseTimestampUs(String paramString)
  {
    int i = 0;
    long l1 = 0L;
    paramString = paramString.split("\\.", 2);
    String[] arrayOfString = paramString[0].split(":");
    int j = arrayOfString.length;
    while (i < j)
    {
      l1 = l1 * 60L + Long.parseLong(arrayOfString[i]);
      i += 1;
    }
    long l2 = l1 * 1000L;
    l1 = l2;
    if (paramString.length == 2) {
      l1 = l2 + Long.parseLong(paramString[1]);
    }
    return l1 * 1000L;
  }
  
  public static void validateWebvttHeaderLine(ParsableByteArray paramParsableByteArray)
  {
    paramParsableByteArray = paramParsableByteArray.readLine();
    if ((paramParsableByteArray == null) || (!HEADER.matcher(paramParsableByteArray).matches())) {
      throw new SubtitleDecoderException("Expected WEBVTT. Got " + paramParsableByteArray);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.text.webvtt.WebvttParserUtil
 * JD-Core Version:    0.7.0.1
 */