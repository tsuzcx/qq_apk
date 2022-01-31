package com.tencent.ark;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class EGLContextHolder$DeviceMatcher
{
  private Pattern mFingerprint;
  private Pattern mModel;
  private Pattern mRenderer;
  private Pattern mRom;
  private Pattern mVersion;
  
  public EGLContextHolder$DeviceMatcher(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (paramString1 != null) {
      this.mFingerprint = Pattern.compile(paramString1);
    }
    if (paramString2 != null) {
      this.mRom = Pattern.compile(paramString2);
    }
    if (paramString3 != null) {
      this.mModel = Pattern.compile(paramString3);
    }
    if (paramString4 != null) {
      this.mRenderer = Pattern.compile(paramString4);
    }
    if (paramString5 != null) {
      this.mVersion = Pattern.compile(paramString5);
    }
  }
  
  private static boolean matchImpl(Pattern paramPattern, String paramString)
  {
    if ((paramPattern != null) && (paramString != null))
    {
      paramPattern = paramPattern.matcher(paramString);
      if ((paramPattern == null) || (!paramPattern.matches())) {
        return false;
      }
    }
    return true;
  }
  
  public boolean matchGL(String paramString1, String paramString2)
  {
    if ((this.mRenderer == null) && (this.mVersion == null)) {}
    while ((!matchImpl(this.mRenderer, paramString1)) || (!matchImpl(this.mVersion, paramString2))) {
      return false;
    }
    return true;
  }
  
  public boolean matchOS(String paramString1, String paramString2, String paramString3)
  {
    if ((this.mFingerprint == null) && (this.mRom == null) && (this.mModel == null)) {}
    while ((!matchImpl(this.mFingerprint, paramString1)) || (!matchImpl(this.mRom, paramString2)) || (!matchImpl(this.mModel, paramString3))) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ark.EGLContextHolder.DeviceMatcher
 * JD-Core Version:    0.7.0.1
 */