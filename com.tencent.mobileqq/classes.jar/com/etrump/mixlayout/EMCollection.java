package com.etrump.mixlayout;

import com.etrump.mixlayout.api.IEMCollection;
import com.etrump.mixlayout.api.IETFont;

public class EMCollection
  implements IEMCollection
{
  private int[] mEmoticonIndexArray = null;
  private ETEngine mEngine = null;
  
  public EMCollection(ETEngine paramETEngine)
  {
    this.mEngine = paramETEngine;
  }
  
  private int getStringCount(String paramString)
  {
    int m = paramString.length();
    int i = 0;
    int j = 0;
    while (i < m)
    {
      if (Character.isHighSurrogate(paramString.charAt(i)))
      {
        int k = i + 1;
        if ((k < m) && (Character.isLowSurrogate(paramString.charAt(k))))
        {
          j += 1;
          i = k;
          break label65;
        }
      }
      j += 1;
      label65:
      i += 1;
    }
    return j;
  }
  
  public int getEmoticonCount()
  {
    int[] arrayOfInt = this.mEmoticonIndexArray;
    if (arrayOfInt != null) {
      return arrayOfInt.length;
    }
    return 0;
  }
  
  public EMImage getEmoticonImage(String paramString, int paramInt, ETFont paramETFont)
  {
    ETEngine localETEngine = this.mEngine;
    if (localETEngine != null)
    {
      int[] arrayOfInt = this.mEmoticonIndexArray;
      if (arrayOfInt != null) {
        return localETEngine.native_emoticonCreateImage(paramString, arrayOfInt[paramInt], paramETFont);
      }
    }
    return null;
  }
  
  public int getEmoticonIndex(int paramInt)
  {
    int[] arrayOfInt = this.mEmoticonIndexArray;
    if ((arrayOfInt != null) && (paramInt >= 0) && (paramInt < arrayOfInt.length)) {
      return arrayOfInt[paramInt];
    }
    return -1;
  }
  
  public boolean retrieve(String paramString, IETFont paramIETFont)
  {
    if ((this.mEngine != null) && (paramString != null) && (paramIETFont != null))
    {
      int i = getStringCount(paramString);
      this.mEmoticonIndexArray = this.mEngine.native_emoticonRetrieveCollection(paramString, i, (ETFont)paramIETFont);
    }
    return this.mEmoticonIndexArray != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.etrump.mixlayout.EMCollection
 * JD-Core Version:    0.7.0.1
 */