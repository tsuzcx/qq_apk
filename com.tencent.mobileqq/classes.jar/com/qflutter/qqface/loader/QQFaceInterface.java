package com.qflutter.qqface.loader;

import com.qflutter.qqface.data.QQFaceNativeData;
import com.qflutter.qqface.data.QQFaceParam;

public abstract interface QQFaceInterface
{
  public abstract void clearCache();
  
  public abstract QQFaceNativeData getFaceData(QQFaceParam paramQQFaceParam);
  
  public abstract String getLibPath();
  
  public abstract void onDestroy();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.qflutter.qqface.loader.QQFaceInterface
 * JD-Core Version:    0.7.0.1
 */