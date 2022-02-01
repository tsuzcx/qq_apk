package com.tencent.biz.pubaccount.readinjoy.drawable;

import java.io.File;
import java.io.FileFilter;

class ReadInJoyLottieDrawable$2
  implements FileFilter
{
  ReadInJoyLottieDrawable$2(ReadInJoyLottieDrawable paramReadInJoyLottieDrawable) {}
  
  public boolean accept(File paramFile)
  {
    return (!paramFile.getName().endsWith(".json")) && (!paramFile.getName().equalsIgnoreCase("__MACOSX"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.drawable.ReadInJoyLottieDrawable.2
 * JD-Core Version:    0.7.0.1
 */