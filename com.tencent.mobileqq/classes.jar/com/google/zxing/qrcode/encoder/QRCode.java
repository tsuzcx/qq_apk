package com.google.zxing.qrcode.encoder;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.Version;

public final class QRCode
{
  private Mode a;
  private ErrorCorrectionLevel b;
  private Version c;
  private int d = -1;
  private ByteMatrix e;
  
  public static boolean b(int paramInt)
  {
    return (paramInt >= 0) && (paramInt < 8);
  }
  
  public ByteMatrix a()
  {
    return this.e;
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void a(ErrorCorrectionLevel paramErrorCorrectionLevel)
  {
    this.b = paramErrorCorrectionLevel;
  }
  
  public void a(Mode paramMode)
  {
    this.a = paramMode;
  }
  
  public void a(Version paramVersion)
  {
    this.c = paramVersion;
  }
  
  public void a(ByteMatrix paramByteMatrix)
  {
    this.e = paramByteMatrix;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(200);
    localStringBuilder.append("<<\n");
    localStringBuilder.append(" mode: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append("\n ecLevel: ");
    localStringBuilder.append(this.b);
    localStringBuilder.append("\n version: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append("\n maskPattern: ");
    localStringBuilder.append(this.d);
    if (this.e == null)
    {
      localStringBuilder.append("\n matrix: null\n");
    }
    else
    {
      localStringBuilder.append("\n matrix:\n");
      localStringBuilder.append(this.e.toString());
    }
    localStringBuilder.append(">>\n");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.zxing.qrcode.encoder.QRCode
 * JD-Core Version:    0.7.0.1
 */