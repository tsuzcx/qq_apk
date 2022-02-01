package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.content.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class QLoaderManager
{
  public static void enableDebugLogging(boolean paramBoolean)
  {
    QLoaderManagerImpl.DEBUG = paramBoolean;
  }
  
  public abstract void destroyLoader(int paramInt);
  
  public abstract void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString);
  
  public abstract <D> Loader<D> getLoader(int paramInt);
  
  public boolean hasRunningLoaders()
  {
    return false;
  }
  
  public abstract <D> Loader<D> initLoader(int paramInt, Bundle paramBundle, QLoaderManager.LoaderCallbacks<D> paramLoaderCallbacks);
  
  public abstract <D> Loader<D> restartLoader(int paramInt, Bundle paramBundle, QLoaderManager.LoaderCallbacks<D> paramLoaderCallbacks);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     android.support.v4.app.QLoaderManager
 * JD-Core Version:    0.7.0.1
 */