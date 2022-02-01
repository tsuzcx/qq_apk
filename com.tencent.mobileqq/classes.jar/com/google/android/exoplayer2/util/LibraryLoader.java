package com.google.android.exoplayer2.util;

import android.util.Log;

public final class LibraryLoader
{
  private boolean isAvailable;
  private boolean loadAttempted;
  private String[] nativeLibraries;
  
  public LibraryLoader(String... paramVarArgs)
  {
    this.nativeLibraries = paramVarArgs;
  }
  
  public boolean isAvailable()
  {
    try
    {
      if (this.loadAttempted)
      {
        bool = this.isAvailable;
        return bool;
      }
      this.loadAttempted = true;
      try
      {
        String[] arrayOfString = this.nativeLibraries;
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          System.loadLibrary(arrayOfString[i]);
          i += 1;
        }
        this.isAvailable = true;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        String str = LibraryLoader.class.getSimpleName();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("loadLibrary failed with exception ");
        localStringBuilder.append(localUnsatisfiedLinkError.toString());
        Log.w(str, localStringBuilder.toString());
      }
      boolean bool = this.isAvailable;
      return bool;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void setLibraries(String... paramVarArgs)
  {
    for (;;)
    {
      try
      {
        if (!this.loadAttempted)
        {
          bool = true;
          Assertions.checkState(bool, "Cannot set libraries after loading");
          this.nativeLibraries = paramVarArgs;
          return;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.util.LibraryLoader
 * JD-Core Version:    0.7.0.1
 */