package com.tencent.hippy.qq.update.qarchive.tools.zip;

import java.util.zip.ZipException;

public class UnsupportedZipFeatureException
  extends ZipException
{
  private static final long serialVersionUID = 4430521921766595597L;
  private final ZipEntry entry;
  private final UnsupportedZipFeatureException.Feature reason;
  
  public UnsupportedZipFeatureException(UnsupportedZipFeatureException.Feature paramFeature, ZipEntry paramZipEntry)
  {
    super(localStringBuilder.toString());
    this.reason = paramFeature;
    this.entry = paramZipEntry;
  }
  
  public ZipEntry getEntry()
  {
    return this.entry;
  }
  
  public UnsupportedZipFeatureException.Feature getFeature()
  {
    return this.reason;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.update.qarchive.tools.zip.UnsupportedZipFeatureException
 * JD-Core Version:    0.7.0.1
 */