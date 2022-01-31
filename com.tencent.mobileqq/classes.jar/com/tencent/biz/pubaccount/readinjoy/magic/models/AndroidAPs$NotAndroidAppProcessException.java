package com.tencent.biz.pubaccount.readinjoy.magic.models;

public final class AndroidAPs$NotAndroidAppProcessException
  extends Exception
{
  public AndroidAPs$NotAndroidAppProcessException(int paramInt)
  {
    super(String.format("The process %d does not belong to any application", new Object[] { Integer.valueOf(paramInt) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.magic.models.AndroidAPs.NotAndroidAppProcessException
 * JD-Core Version:    0.7.0.1
 */