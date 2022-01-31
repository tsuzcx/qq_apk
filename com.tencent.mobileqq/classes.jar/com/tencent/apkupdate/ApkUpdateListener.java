package com.tencent.apkupdate;

import java.util.ArrayList;

public abstract interface ApkUpdateListener
{
  public abstract void onCheckUpdateFailed(String paramString);
  
  public abstract void onCheckUpdateSucceed(ArrayList paramArrayList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.apkupdate.ApkUpdateListener
 * JD-Core Version:    0.7.0.1
 */