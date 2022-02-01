package com.tencent.biz.qqstory.playvideo.entrance;

import java.io.Serializable;

public class TroopAIOPlayInfo
  implements Serializable
{
  public final String frienduin;
  public final String selfuin;
  public final long shmsgseq;
  public final String storyId;
  
  public TroopAIOPlayInfo(String paramString1, String paramString2, String paramString3, long paramLong)
  {
    this.selfuin = paramString1;
    this.frienduin = paramString2;
    this.storyId = paramString3;
    this.shmsgseq = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.entrance.TroopAIOPlayInfo
 * JD-Core Version:    0.7.0.1
 */