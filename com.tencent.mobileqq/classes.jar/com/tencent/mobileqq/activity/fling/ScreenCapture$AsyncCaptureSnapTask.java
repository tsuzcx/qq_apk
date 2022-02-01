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
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  
  public ScreenCapture$AsyncCaptureSnapTask(View paramView)
  {
    if (paramView != null)
    {
      Context localContext = paramView.getContext();
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
      paramView.setDrawingCacheEnabled(true);
      this.jdField_a_of_type_AndroidGraphicsBitmap = paramView.getDrawingCache();
      ScreenCapture.setSnapFile(localContext, false);
    }
  }
  
  protected Boolean a(String... paramVarArgs)
  {
    Boolean localBoolean = Boolean.FALSE;
    if (isCancelled()) {
      return localBoolean;
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
    {
      Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
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
  
  protected void a(Boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject != null)
    {
      localObject = (View)((WeakReference)localObject).get();
      if (localObject != null)
      {
        if (paramBoolean.booleanValue()) {
          ScreenCapture.setSnapFile(((View)localObject).getContext(), true);
        }
        this.jdField_a_of_type_AndroidGraphicsBitmap = null;
        ((View)localObject).setDrawingCacheEnabled(false);
        ((View)localObject).destroyDrawingCache();
      }
    }
  }
  
  protected void onCancelled() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.fling.ScreenCapture.AsyncCaptureSnapTask
 * JD-Core Version:    0.7.0.1
 */