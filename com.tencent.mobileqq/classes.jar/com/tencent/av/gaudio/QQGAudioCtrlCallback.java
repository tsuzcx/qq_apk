package com.tencent.av.gaudio;

import com.tencent.avcore.engine.mav.IMavEventListener;
import com.tencent.avcore.jni.data.AVUserInfo;
import java.util.ArrayList;

public abstract interface QQGAudioCtrlCallback
  extends IMavEventListener
{
  public abstract long a(int paramInt1, int paramInt2, long paramLong);
  
  public abstract void a(long paramLong1, long paramLong2, String paramString);
  
  public abstract void a(long paramLong1, long paramLong2, ArrayList<Memberinfo> paramArrayList);
  
  public abstract void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract boolean a(long paramLong, int paramInt);
  
  public abstract void b(long paramLong, ArrayList<AVUserInfo> paramArrayList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.gaudio.QQGAudioCtrlCallback
 * JD-Core Version:    0.7.0.1
 */