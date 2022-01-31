package com.facebook.soloader;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class DirectorySoSource
  extends SoSource
{
  public static final int ON_LD_LIBRARY_PATH = 2;
  public static final int RESOLVE_DEPENDENCIES = 1;
  protected final int flags;
  protected final File soDirectory;
  
  public DirectorySoSource(File paramFile, int paramInt)
  {
    this.soDirectory = paramFile;
    this.flags = paramInt;
  }
  
  private static String[] getDependencies(File paramFile)
    throws IOException
  {
    if (SoLoader.SYSTRACE_LIBRARY_LOADING) {
      Api18TraceUtils.beginTraceSection("SoLoader.getElfDependencies[" + paramFile.getName() + "]");
    }
    try
    {
      paramFile = MinElf.extract_DT_NEEDED(paramFile);
      return paramFile;
    }
    finally
    {
      if (SoLoader.SYSTRACE_LIBRARY_LOADING) {
        Api18TraceUtils.endSection();
      }
    }
  }
  
  public void addToLdLibraryPath(Collection<String> paramCollection)
  {
    paramCollection.add(this.soDirectory.getAbsolutePath());
  }
  
  public int loadLibrary(String paramString, int paramInt)
    throws IOException
  {
    return loadLibraryFrom(paramString, paramInt, this.soDirectory);
  }
  
  protected int loadLibraryFrom(String paramString, int paramInt, File paramFile)
    throws IOException
  {
    paramString = new File(paramFile, paramString);
    if (!paramString.exists()) {
      return 0;
    }
    if (((paramInt & 0x1) != 0) && ((this.flags & 0x2) != 0)) {
      return 2;
    }
    if ((this.flags & 0x1) != 0)
    {
      paramFile = getDependencies(paramString);
      int i = 0;
      if (i < paramFile.length)
      {
        String str = paramFile[i];
        if (str.startsWith("/")) {}
        for (;;)
        {
          i += 1;
          break;
          SoLoader.loadLibraryBySoName(str, paramInt | 0x1);
        }
      }
    }
    SoLoader.sSoFileLoader.load(paramString.getAbsolutePath(), paramInt);
    return 1;
  }
  
  public File unpackLibrary(String paramString)
    throws IOException
  {
    paramString = new File(this.soDirectory, paramString);
    if (paramString.exists()) {
      return paramString;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.facebook.soloader.DirectorySoSource
 * JD-Core Version:    0.7.0.1
 */