package com.tencent.mobileqq.ar.arengine;

import com.tencent.biz.qrcode.activity.ScannerResult;
import com.tencent.mobileqq.ar.codeEngine.AIRect;
import com.tencent.mobileqq.ar.codeEngine.IRecogListener;
import java.util.List;

public abstract interface QRRecognizerListener
  extends IRecogListener
{
  public abstract void a(int paramInt);
  
  public abstract void a(ScannerResult paramScannerResult, byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public abstract void a(List<AIRect> paramList);
  
  public abstract void a(boolean paramBoolean, float paramFloat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.QRRecognizerListener
 * JD-Core Version:    0.7.0.1
 */