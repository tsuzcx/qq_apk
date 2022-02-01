package com.tencent.biz.qqstory.comment.lego;

import android.os.Bundle;
import com.tencent.mobileqq.pb.MessageMicro;

public abstract interface LegoResponseCallBack
{
  public abstract void a(int paramInt, Bundle paramBundle);
  
  public abstract void a(int paramInt, String paramString);
  
  public abstract void a(MessageMicro paramMessageMicro);
  
  public abstract void a(boolean paramBoolean, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.lego.LegoResponseCallBack
 * JD-Core Version:    0.7.0.1
 */