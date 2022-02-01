package com.etrump.mixlayout;

public class EMCollection
{
  private int[] mEmoticonIndexArray;
  private ETEngine mEngine;
  
  public EMCollection(ETEngine paramETEngine)
  {
    this.mEngine = paramETEngine;
  }
  
  private int getStringCount(String paramString)
  {
    int i = 0;
    int k = paramString.length();
    int j = 0;
    if (i < k)
    {
      if ((Character.isHighSurrogate(paramString.charAt(i))) && (i + 1 < k) && (Character.isLowSurrogate(paramString.charAt(i + 1))))
      {
        j += 1;
        i += 1;
      }
      for (;;)
      {
        i += 1;
        break;
        j += 1;
      }
    }
    return j;
  }
  
  public int getEmoticonCount()
  {
    if (this.mEmoticonIndexArray != null) {
      return this.mEmoticonIndexArray.length;
    }
    return 0;
  }
  
  public EMImage getEmoticonImage(String paramString, int paramInt, ETFont paramETFont)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.mEngine != null)
    {
      localObject1 = localObject2;
      if (this.mEmoticonIndexArray != null) {
        localObject1 = this.mEngine.native_emoticonCreateImage(paramString, this.mEmoticonIndexArray[paramInt], paramETFont);
      }
    }
    return localObject1;
  }
  
  public int getEmoticonIndex(int paramInt)
  {
    if ((this.mEmoticonIndexArray != null) && (paramInt >= 0) && (paramInt < this.mEmoticonIndexArray.length)) {
      return this.mEmoticonIndexArray[paramInt];
    }
    return -1;
  }
  
  public boolean retrieve(String paramString, ETFont paramETFont)
  {
    if ((this.mEngine != null) && (paramString != null) && (paramETFont != null))
    {
      int i = getStringCount(paramString);
      this.mEmoticonIndexArray = this.mEngine.native_emoticonRetrieveCollection(paramString, i, paramETFont);
    }
    return this.mEmoticonIndexArray != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.etrump.mixlayout.EMCollection
 * JD-Core Version:    0.7.0.1
 */