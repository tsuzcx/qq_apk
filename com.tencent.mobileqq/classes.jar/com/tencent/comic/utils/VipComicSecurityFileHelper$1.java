package com.tencent.comic.utils;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class VipComicSecurityFileHelper$1
  implements FilenameFilter
{
  VipComicSecurityFileHelper$1(VipComicSecurityFileHelper paramVipComicSecurityFileHelper) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return (paramFile != null) && (paramFile.isDirectory()) && (VipComicSecurityFileHelper.a(this.a).matcher(paramString).matches());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.utils.VipComicSecurityFileHelper.1
 * JD-Core Version:    0.7.0.1
 */