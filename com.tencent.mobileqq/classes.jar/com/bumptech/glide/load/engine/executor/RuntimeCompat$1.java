package com.bumptech.glide.load.engine.executor;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class RuntimeCompat$1
  implements FilenameFilter
{
  RuntimeCompat$1(Pattern paramPattern) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return this.a.matcher(paramString).matches();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.executor.RuntimeCompat.1
 * JD-Core Version:    0.7.0.1
 */