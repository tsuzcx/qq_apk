package com.tencent.biz.pubaccount.readinjoy.struct;

import awbv;

public class ChannelTopCookie
  extends awbv
  implements Cloneable
{
  public static final String TABLE_NAME = ArticleInfo.class.getSimpleName();
  public int mChannelID = -1;
  public byte[] mSetTopCookie;
  
  public ChannelTopCookie clone()
  {
    try
    {
      ChannelTopCookie localChannelTopCookie = (ChannelTopCookie)super.clone();
      return localChannelTopCookie;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.ChannelTopCookie
 * JD-Core Version:    0.7.0.1
 */