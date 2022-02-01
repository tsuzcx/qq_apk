package com.tencent.hippy.qq.update.qarchive.tools.zip;

public class UnsupportedZipFeatureException$Feature
{
  public static final Feature DATA_DESCRIPTOR = new Feature("data descriptor");
  public static final Feature ENCRYPTION = new Feature("encryption");
  public static final Feature METHOD = new Feature("compression method");
  private final String name;
  
  private UnsupportedZipFeatureException$Feature(String paramString)
  {
    this.name = paramString;
  }
  
  public String toString()
  {
    return this.name;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.update.qarchive.tools.zip.UnsupportedZipFeatureException.Feature
 * JD-Core Version:    0.7.0.1
 */