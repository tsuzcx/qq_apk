package com.tencent.mobileqq.ar.arengine;

public class ARCloudMarkerRecogResult$ImageTag
{
  public String a = "";
  public String b = "";
  public int c = 0;
  public float d = 0.0F;
  public int e = 0;
  public int f = -1;
  public byte[] g = null;
  
  public String toString()
  {
    try
    {
      str = new String(this.g, "utf-8");
    }
    catch (Exception localException)
    {
      String str;
      label17:
      StringBuilder localStringBuilder;
      break label17;
    }
    str = "";
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("ImageTag{imageId = ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", tagName = ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", tagConfidence = ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", tagConfidence_f = ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", need_check_lbs = ");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", cdbRetCode = ");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", cdbRes = ");
    localStringBuilder.append(str);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudMarkerRecogResult.ImageTag
 * JD-Core Version:    0.7.0.1
 */