package com.facebook.soloader;

import android.util.Log;
import java.util.Iterator;
import java.util.List;

public abstract class NativeLibrary
{
  private static final String TAG = NativeLibrary.class.getName();
  private boolean mLibrariesLoaded = false;
  private List<String> mLibraryNames;
  private volatile UnsatisfiedLinkError mLinkError = null;
  private Boolean mLoadLibraries = Boolean.valueOf(true);
  private final Object mLock = new Object();
  
  protected NativeLibrary(List<String> paramList)
  {
    this.mLibraryNames = paramList;
  }
  
  public void ensureLoaded()
    throws UnsatisfiedLinkError
  {
    if (!loadLibraries()) {
      throw this.mLinkError;
    }
  }
  
  public UnsatisfiedLinkError getError()
  {
    return this.mLinkError;
  }
  
  protected void initialNativeCheck()
    throws UnsatisfiedLinkError
  {}
  
  public boolean loadLibraries()
  {
    for (;;)
    {
      synchronized (this.mLock)
      {
        if (!this.mLoadLibraries.booleanValue())
        {
          bool = this.mLibrariesLoaded;
          return bool;
        }
        try
        {
          Iterator localIterator = this.mLibraryNames.iterator();
          if (!localIterator.hasNext()) {
            break label103;
          }
          SoLoader.loadLibrary((String)localIterator.next());
          continue;
          this.mLoadLibraries = Boolean.valueOf(false);
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
        {
          Log.e(TAG, "Failed to load native lib: ", localUnsatisfiedLinkError);
          this.mLinkError = localUnsatisfiedLinkError;
          this.mLibrariesLoaded = false;
        }
        boolean bool = this.mLibrariesLoaded;
        return bool;
      }
      label103:
      initialNativeCheck();
      this.mLibrariesLoaded = true;
      this.mLibraryNames = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.facebook.soloader.NativeLibrary
 * JD-Core Version:    0.7.0.1
 */