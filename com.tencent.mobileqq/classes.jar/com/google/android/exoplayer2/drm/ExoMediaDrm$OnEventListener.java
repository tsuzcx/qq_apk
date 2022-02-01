package com.google.android.exoplayer2.drm;

public abstract interface ExoMediaDrm$OnEventListener<T extends ExoMediaCrypto>
{
  public abstract void onEvent(ExoMediaDrm<? extends T> paramExoMediaDrm, byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.drm.ExoMediaDrm.OnEventListener
 * JD-Core Version:    0.7.0.1
 */