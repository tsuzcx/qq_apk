package androidx.print;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentAdapter.LayoutResultCallback;
import android.print.PrintDocumentAdapter.WriteResultCallback;
import android.print.PrintDocumentInfo.Builder;
import androidx.annotation.RequiresApi;

@RequiresApi(19)
class PrintHelper$PrintUriAdapter
  extends PrintDocumentAdapter
{
  PrintAttributes mAttributes;
  Bitmap mBitmap;
  final PrintHelper.OnPrintFinishCallback mCallback;
  final int mFittingMode;
  final Uri mImageFile;
  final String mJobName;
  AsyncTask<Uri, Boolean, Bitmap> mLoadBitmap;
  
  PrintHelper$PrintUriAdapter(PrintHelper paramPrintHelper, String paramString, Uri paramUri, PrintHelper.OnPrintFinishCallback paramOnPrintFinishCallback, int paramInt)
  {
    this.mJobName = paramString;
    this.mImageFile = paramUri;
    this.mCallback = paramOnPrintFinishCallback;
    this.mFittingMode = paramInt;
    this.mBitmap = null;
  }
  
  void cancelLoad()
  {
    synchronized (this.this$0.mLock)
    {
      if (this.this$0.mDecodeOptions != null)
      {
        if (Build.VERSION.SDK_INT < 24) {
          this.this$0.mDecodeOptions.requestCancelDecode();
        }
        this.this$0.mDecodeOptions = null;
      }
      return;
    }
  }
  
  public void onFinish()
  {
    super.onFinish();
    cancelLoad();
    Object localObject = this.mLoadBitmap;
    if (localObject != null) {
      ((AsyncTask)localObject).cancel(true);
    }
    localObject = this.mCallback;
    if (localObject != null) {
      ((PrintHelper.OnPrintFinishCallback)localObject).onFinish();
    }
    localObject = this.mBitmap;
    if (localObject != null)
    {
      ((Bitmap)localObject).recycle();
      this.mBitmap = null;
    }
  }
  
  public void onLayout(PrintAttributes paramPrintAttributes1, PrintAttributes paramPrintAttributes2, CancellationSignal paramCancellationSignal, PrintDocumentAdapter.LayoutResultCallback paramLayoutResultCallback, Bundle paramBundle)
  {
    try
    {
      this.mAttributes = paramPrintAttributes2;
      if (paramCancellationSignal.isCanceled())
      {
        paramLayoutResultCallback.onLayoutCancelled();
        return;
      }
      if (this.mBitmap != null)
      {
        paramLayoutResultCallback.onLayoutFinished(new PrintDocumentInfo.Builder(this.mJobName).setContentType(1).setPageCount(1).build(), paramPrintAttributes2.equals(paramPrintAttributes1) ^ true);
        return;
      }
      this.mLoadBitmap = new PrintHelper.PrintUriAdapter.1(this, paramCancellationSignal, paramPrintAttributes2, paramPrintAttributes1, paramLayoutResultCallback).execute(new Uri[0]);
      return;
    }
    finally {}
  }
  
  public void onWrite(PageRange[] paramArrayOfPageRange, ParcelFileDescriptor paramParcelFileDescriptor, CancellationSignal paramCancellationSignal, PrintDocumentAdapter.WriteResultCallback paramWriteResultCallback)
  {
    this.this$0.writeBitmap(this.mAttributes, this.mFittingMode, this.mBitmap, paramParcelFileDescriptor, paramCancellationSignal, paramWriteResultCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.print.PrintHelper.PrintUriAdapter
 * JD-Core Version:    0.7.0.1
 */