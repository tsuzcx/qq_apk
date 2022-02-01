package com.android.dx.command.dexer;

import com.android.dx.cf.direct.ClassPathOpener.FileNameFilter;

class Main$NotFilter
  implements ClassPathOpener.FileNameFilter
{
  private final ClassPathOpener.FileNameFilter filter;
  
  private Main$NotFilter(ClassPathOpener.FileNameFilter paramFileNameFilter)
  {
    this.filter = paramFileNameFilter;
  }
  
  public boolean accept(String paramString)
  {
    return !this.filter.accept(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.command.dexer.Main.NotFilter
 * JD-Core Version:    0.7.0.1
 */