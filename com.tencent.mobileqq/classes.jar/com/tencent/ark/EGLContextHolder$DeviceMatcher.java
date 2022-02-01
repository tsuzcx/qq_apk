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
    Pattern localPattern = this.mRenderer;
    boolean bool2 = false;
    if ((localPattern == null) && (this.mVersion == null)) {
      return false;
    }
    boolean bool1 = bool2;
    if (matchImpl(this.mRenderer, paramString1))
    {
      bool1 = bool2;
      if (matchImpl(this.mVersion, paramString2)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean matchOS(String paramString1, String paramString2, String paramString3)
  {
    Pattern localPattern = this.mFingerprint;
    boolean bool2 = false;
    if ((localPattern == null) && (this.mRom == null) && (this.mModel == null)) {
      return false;
    }
    boolean bool1 = bool2;
    if (matchImpl(this.mFingerprint, paramString1))
    {
      bool1 = bool2;
      if (matchImpl(this.mRom, paramString2))
      {
        bool1 = bool2;
        if (matchImpl(this.mModel, paramString3)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.EGLContextHolder.DeviceMatcher
 * JD-Core Version:    0.7.0.1
 */