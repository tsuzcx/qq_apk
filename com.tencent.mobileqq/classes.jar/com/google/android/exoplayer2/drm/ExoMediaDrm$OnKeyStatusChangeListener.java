package com.google.android.exoplayer2.drm;

import java.util.List;

public abstract interface ExoMediaDrm$OnKeyStatusChangeListener<T extends ExoMediaCrypto>
{
  public abstract void onKeyStatusChange(ExoMediaDrm<? extends T> paramExoMediaDrm, byte[] paramArrayOfByte, List<ExoMediaDrm.KeyStatus> paramList, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.drm.ExoMediaDrm.OnKeyStatusChangeListener
 * JD-Core Version:    0.7.0.1
 */