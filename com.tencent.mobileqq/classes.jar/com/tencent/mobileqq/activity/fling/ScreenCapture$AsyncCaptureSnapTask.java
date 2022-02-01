package com.tencent.mobileqq.activity.fling;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.AsyncTask;
import android.view.View;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.ref.WeakReference;

class ScreenCapture$AsyncCaptureSnapTask
  extends AsyncTask<String, Void, Boolean>
{
  private Bitmap mCache;
  private WeakReference<View> mWillCachedView;
  
  public ScreenCapture$AsyncCaptureSnapTask(View paramView)
  {
    if (paramView != null)
    {
      Context localContext = paramView.getContext();
      this.mWillCachedView = new WeakReference(paramView);
      paramView.setDrawingCacheEnabled(true);
      this.mCache = paramView.getDrawingCache();
      ScreenCapture.setSnapFile(localContext, false);
    }
  }
  
  protected Boolean doInBackground(String... paramVarArgs)
  {
    Boolean localBoolean = Boolean.FALSE;
    if (isCancelled()) {
      return localBoolean;
    }
    if (this.mWillCachedView.get() != null)
    {
      Bitmap localBitmap = this.mCache;
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        localBitmap = this.mCache;
        paramVarArgs = new File(paramVarArgs[0]);
        File localFile = paramVarArgs.getParentFile();
        if (!localFile.exists()) {
          localFile.mkdirs();
        }
        try
        {
          paramVarArgs = new FileOutputStream(paramVarArgs);
          localBitmap.compress(Bitmap.CompressFormat.JPEG, 90, paramVarArgs);
          paramVarArgs.flush();
          paramVarArgs.close();
          paramVarArgs = Boolean.TRUE;
          return paramVarArgs;
        }
        catch (IOException paramVarArgs)
        {
          paramVarArgs.printStackTrace();
        }
      }
    }
    return localBoolean;
  }
  
  protected void onCancelled() {}
  
  protected void onPostExecute(Boolean paramBoolean)
  {
    Object localObject = this.mWillCachedView;
    if (localObject != null)
    {
      localObject = (View)((WeakReference)localObject).get();
      if (localObject != null)
      {
        if (paramBoolean.booleanValue()) {
          ScreenCapture.setSnapFile(((View)localObject).getContext(), true);
        }
        this.mCache = null;
        ((View)localObject).setDrawingCacheEnabled(false);
        ((View)localObject).destroyDrawingCache();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.fling.ScreenCapture.AsyncCaptureSnapTask
 * JD-Core Version:    0.7.0.1
 */