package com.tencent.biz.qqstory.playvideo.entrance;

import java.io.Serializable;
import java.util.ArrayList;

public class MemorySelectVideoPlayInfo
  implements Serializable
{
  public MemoriesFeedPlayInfo childPlayInfo;
  
  public MemorySelectVideoPlayInfo(String paramString1, String paramString2, String paramString3, String paramString4, ArrayList<String> paramArrayList, boolean paramBoolean, int paramInt)
  {
    this.childPlayInfo = new MemoriesFeedPlayInfo(paramString1, paramString2, paramString3, paramString4, paramArrayList, paramBoolean, paramInt);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MemorySelectVideoPlayInfo{childPlayInfo=");
    localStringBuilder.append(this.childPlayInfo);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.entrance.MemorySelectVideoPlayInfo
 * JD-Core Version:    0.7.0.1
 */