package com.android.dx.command.dexer;

import com.android.dx.cf.direct.ClassPathOpener.FileNameFilter;
import java.util.Set;

class Main$MainDexListFilter
  implements ClassPathOpener.FileNameFilter
{
  public boolean accept(String paramString)
  {
    if (paramString.endsWith(".class"))
    {
      paramString = Main.access$900(paramString);
      return Main.access$1000().contains(paramString);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.command.dexer.Main.MainDexListFilter
 * JD-Core Version:    0.7.0.1
 */