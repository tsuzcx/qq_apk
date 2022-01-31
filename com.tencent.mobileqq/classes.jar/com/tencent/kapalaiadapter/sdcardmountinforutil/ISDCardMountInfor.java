package com.tencent.kapalaiadapter.sdcardmountinforutil;

import java.util.ArrayList;

public abstract interface ISDCardMountInfor
{
  public abstract ArrayList<String> getAllPath();
  
  public abstract boolean isExSdcard(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.kapalaiadapter.sdcardmountinforutil.ISDCardMountInfor
 * JD-Core Version:    0.7.0.1
 */