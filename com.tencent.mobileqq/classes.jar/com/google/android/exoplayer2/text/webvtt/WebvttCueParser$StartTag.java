package com.google.android.exoplayer2.text.webvtt;

import java.util.Arrays;

final class WebvttCueParser$StartTag
{
  private static final String[] NO_CLASSES = new String[0];
  public final String[] classes;
  public final String name;
  public final int position;
  public final String voice;
  
  private WebvttCueParser$StartTag(String paramString1, int paramInt, String paramString2, String[] paramArrayOfString)
  {
    this.position = paramInt;
    this.name = paramString1;
    this.voice = paramString2;
    this.classes = paramArrayOfString;
  }
  
  public static StartTag buildStartTag(String paramString, int paramInt)
  {
    Object localObject = paramString.trim();
    if (((String)localObject).isEmpty()) {
      return null;
    }
    int i = ((String)localObject).indexOf(" ");
    String str;
    if (i == -1)
    {
      paramString = "";
      localObject = ((String)localObject).split("\\.");
      str = localObject[0];
      if (localObject.length <= 1) {
        break label90;
      }
    }
    label90:
    for (localObject = (String[])Arrays.copyOfRange((Object[])localObject, 1, localObject.length);; localObject = NO_CLASSES)
    {
      return new StartTag(str, paramInt, paramString, (String[])localObject);
      paramString = ((String)localObject).substring(i).trim();
      localObject = ((String)localObject).substring(0, i);
      break;
    }
  }
  
  public static StartTag buildWholeCueVirtualTag()
  {
    return new StartTag("", 0, "", new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.text.webvtt.WebvttCueParser.StartTag
 * JD-Core Version:    0.7.0.1
 */