package androidx.loader.content;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.DebugUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class Loader<D>
{
  boolean mAbandoned = false;
  boolean mContentChanged = false;
  Context mContext;
  int mId;
  Loader.OnLoadCompleteListener<D> mListener;
  Loader.OnLoadCanceledListener<D> mOnLoadCanceledListener;
  boolean mProcessingChange = false;
  boolean mReset = true;
  boolean mStarted = false;
  
  public Loader(@NonNull Context paramContext)
  {
    this.mContext = paramContext.getApplicationContext();
  }
  
  @MainThread
  public void abandon()
  {
    this.mAbandoned = true;
    onAbandon();
  }
  
  @MainThread
  public boolean cancelLoad()
  {
    return onCancelLoad();
  }
  
  public void commitContentChanged()
  {
    this.mProcessingChange = false;
  }
  
  @NonNull
  public String dataToString(@Nullable D paramD)
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    DebugUtils.buildShortClassTag(paramD, localStringBuilder);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  @MainThread
  public void deliverCancellation()
  {
    Loader.OnLoadCanceledListener localOnLoadCanceledListener = this.mOnLoadCanceledListener;
    if (localOnLoadCanceledListener != null) {
      localOnLoadCanceledListener.onLoadCanceled(this);
    }
  }
  
  @MainThread
  public void deliverResult(@Nullable D paramD)
  {
    Loader.OnLoadCompleteListener localOnLoadCompleteListener = this.mListener;
    if (localOnLoadCompleteListener != null) {
      localOnLoadCompleteListener.onLoadComplete(this, paramD);
    }
  }
  
  @Deprecated
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mId=");
    paramPrintWriter.print(this.mId);
    paramPrintWriter.print(" mListener=");
    paramPrintWriter.println(this.mListener);
    if ((this.mStarted) || (this.mContentChanged) || (this.mProcessingChange))
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mStarted=");
      paramPrintWriter.print(this.mStarted);
      paramPrintWriter.print(" mContentChanged=");
      paramPrintWriter.print(this.mContentChanged);
      paramPrintWriter.print(" mProcessingChange=");
      paramPrintWriter.println(this.mProcessingChange);
    }
    if ((this.mAbandoned) || (this.mReset))
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mAbandoned=");
      paramPrintWriter.print(this.mAbandoned);
      paramPrintWriter.print(" mReset=");
      paramPrintWriter.println(this.mReset);
    }
  }
  
  @MainThread
  public void forceLoad()
  {
    onForceLoad();
  }
  
  @NonNull
  public Context getContext()
  {
    return this.mContext;
  }
  
  public int getId()
  {
    return this.mId;
  }
  
  public boolean isAbandoned()
  {
    return this.mAbandoned;
  }
  
  public boolean isReset()
  {
    return this.mReset;
  }
  
  public boolean isStarted()
  {
    return this.mStarted;
  }
  
  @MainThread
  protected void onAbandon() {}
  
  @MainThread
  protected boolean onCancelLoad()
  {
    return false;
  }
  
  @MainThread
  public void onContentChanged()
  {
    if (this.mStarted)
    {
      forceLoad();
      return;
    }
    this.mContentChanged = true;
  }
  
  @MainThread
  protected void onForceLoad() {}
  
  @MainThread
  protected void onReset() {}
  
  @MainThread
  protected void onStartLoading() {}
  
  @MainThread
  protected void onStopLoading() {}
  
  @MainThread
  public void registerListener(int paramInt, @NonNull Loader.OnLoadCompleteListener<D> paramOnLoadCompleteListener)
  {
    if (this.mListener == null)
    {
      this.mListener = paramOnLoadCompleteListener;
      this.mId = paramInt;
      return;
    }
    throw new IllegalStateException("There is already a listener registered");
  }
  
  @MainThread
  public void registerOnLoadCanceledListener(@NonNull Loader.OnLoadCanceledListener<D> paramOnLoadCanceledListener)
  {
    if (this.mOnLoadCanceledListener == null)
    {
      this.mOnLoadCanceledListener = paramOnLoadCanceledListener;
      return;
    }
    throw new IllegalStateException("There is already a listener registered");
  }
  
  @MainThread
  public void reset()
  {
    onReset();
    this.mReset = true;
    this.mStarted = false;
    this.mAbandoned = false;
    this.mContentChanged = false;
    this.mProcessingChange = false;
  }
  
  public void rollbackContentChanged()
  {
    if (this.mProcessingChange) {
      onContentChanged();
    }
  }
  
  @MainThread
  public final void startLoading()
  {
    this.mStarted = true;
    this.mReset = false;
    this.mAbandoned = false;
    onStartLoading();
  }
  
  @MainThread
  public void stopLoading()
  {
    this.mStarted = false;
    onStopLoading();
  }
  
  public boolean takeContentChanged()
  {
    boolean bool = this.mContentChanged;
    this.mContentChanged = false;
    this.mProcessingChange |= bool;
    return bool;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    DebugUtils.buildShortClassTag(this, localStringBuilder);
    localStringBuilder.append(" id=");
    localStringBuilder.append(this.mId);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  @MainThread
  public void unregisterListener(@NonNull Loader.OnLoadCompleteListener<D> paramOnLoadCompleteListener)
  {
    Loader.OnLoadCompleteListener localOnLoadCompleteListener = this.mListener;
    if (localOnLoadCompleteListener != null)
    {
      if (localOnLoadCompleteListener == paramOnLoadCompleteListener)
      {
        this.mListener = null;
        return;
      }
      throw new IllegalArgumentException("Attempting to unregister the wrong listener");
    }
    throw new IllegalStateException("No listener register");
  }
  
  @MainThread
  public void unregisterOnLoadCanceledListener(@NonNull Loader.OnLoadCanceledListener<D> paramOnLoadCanceledListener)
  {
    Loader.OnLoadCanceledListener localOnLoadCanceledListener = this.mOnLoadCanceledListener;
    if (localOnLoadCanceledListener != null)
    {
      if (localOnLoadCanceledListener == paramOnLoadCanceledListener)
      {
        this.mOnLoadCanceledListener = null;
        return;
      }
      throw new IllegalArgumentException("Attempting to unregister the wrong listener");
    }
    throw new IllegalStateException("No listener register");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.loader.content.Loader
 * JD-Core Version:    0.7.0.1
 */