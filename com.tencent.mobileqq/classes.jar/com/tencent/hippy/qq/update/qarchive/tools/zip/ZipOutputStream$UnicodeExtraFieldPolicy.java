package com.tencent.hippy.qq.update.qarchive.tools.zip;

public final class ZipOutputStream$UnicodeExtraFieldPolicy
{
  public static final UnicodeExtraFieldPolicy ALWAYS = new UnicodeExtraFieldPolicy("always");
  public static final UnicodeExtraFieldPolicy NEVER = new UnicodeExtraFieldPolicy("never");
  public static final UnicodeExtraFieldPolicy NOT_ENCODEABLE = new UnicodeExtraFieldPolicy("not encodeable");
  private final String name;
  
  private ZipOutputStream$UnicodeExtraFieldPolicy(String paramString)
  {
    this.name = paramString;
  }
  
  public String toString()
  {
    return this.name;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.update.qarchive.tools.zip.ZipOutputStream.UnicodeExtraFieldPolicy
 * JD-Core Version:    0.7.0.1
 */