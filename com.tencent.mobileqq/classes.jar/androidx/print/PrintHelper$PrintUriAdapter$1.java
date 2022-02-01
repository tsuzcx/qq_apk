package androidx.print;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.CancellationSignal;
import android.print.PrintAttributes;
import android.print.PrintAttributes.MediaSize;
import android.print.PrintDocumentAdapter.LayoutResultCallback;
import android.print.PrintDocumentInfo.Builder;
import java.io.FileNotFoundException;

class PrintHelper$PrintUriAdapter$1
  extends AsyncTask<Uri, Boolean, Bitmap>
{
  PrintHelper$PrintUriAdapter$1(PrintHelper.PrintUriAdapter paramPrintUriAdapter, CancellationSignal paramCancellationSignal, PrintAttributes paramPrintAttributes1, PrintAttributes paramPrintAttributes2, PrintDocumentAdapter.LayoutResultCallback paramLayoutResultCallback) {}
  
  protected Bitmap doInBackground(Uri... paramVarArgs)
  {
    try
    {
      paramVarArgs = this.this$1.this$0.loadConstrainedBitmap(this.this$1.mImageFile);
      return paramVarArgs;
    }
    catch (FileNotFoundException paramVarArgs)
    {
      label20:
      break label20;
    }
    return null;
  }
  
  protected void onCancelled(Bitmap paramBitmap)
  {
    this.val$layoutResultCallback.onLayoutCancelled();
    this.this$1.mLoadBitmap = null;
  }
  
  protected void onPostExecute(Bitmap paramBitmap)
  {
    super.onPostExecute(paramBitmap);
    Object localObject = paramBitmap;
    if (paramBitmap != null) {
      if (PrintHelper.PRINT_ACTIVITY_RESPECTS_ORIENTATION)
      {
        localObject = paramBitmap;
        if (this.this$1.this$0.mOrientation != 0) {}
      }
      else
      {
        try
        {
          PrintAttributes.MediaSize localMediaSize = this.this$1.mAttributes.getMediaSize();
          localObject = paramBitmap;
          if (localMediaSize != null)
          {
            localObject = paramBitmap;
            if (localMediaSize.isPortrait() != PrintHelper.isPortrait(paramBitmap))
            {
              localObject = new Matrix();
              ((Matrix)localObject).postRotate(90.0F);
              localObject = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
            }
          }
        }
        finally {}
      }
    }
    paramBitmap = this.this$1;
    paramBitmap.mBitmap = ((Bitmap)localObject);
    if (localObject != null)
    {
      paramBitmap = new PrintDocumentInfo.Builder(paramBitmap.mJobName).setContentType(1).setPageCount(1).build();
      boolean bool = this.val$newPrintAttributes.equals(this.val$oldPrintAttributes);
      this.val$layoutResultCallback.onLayoutFinished(paramBitmap, true ^ bool);
    }
    else
    {
      this.val$layoutResultCallback.onLayoutFailed(null);
    }
    this.this$1.mLoadBitmap = null;
  }
  
  protected void onPreExecute()
  {
    this.val$cancellationSignal.setOnCancelListener(new PrintHelper.PrintUriAdapter.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.print.PrintHelper.PrintUriAdapter.1
 * JD-Core Version:    0.7.0.1
 */