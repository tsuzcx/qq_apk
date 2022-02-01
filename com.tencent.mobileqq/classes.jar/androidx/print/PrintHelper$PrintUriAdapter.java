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
  final int jdField_a_of_type_Int;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  final Uri jdField_a_of_type_AndroidNetUri;
  AsyncTask<Uri, Boolean, Bitmap> jdField_a_of_type_AndroidOsAsyncTask;
  PrintAttributes jdField_a_of_type_AndroidPrintPrintAttributes;
  final PrintHelper.OnPrintFinishCallback jdField_a_of_type_AndroidxPrintPrintHelper$OnPrintFinishCallback;
  final String jdField_a_of_type_JavaLangString;
  
  void a()
  {
    synchronized (this.jdField_a_of_type_AndroidxPrintPrintHelper.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_AndroidxPrintPrintHelper.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options != null)
      {
        if (Build.VERSION.SDK_INT < 24) {
          this.jdField_a_of_type_AndroidxPrintPrintHelper.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.requestCancelDecode();
        }
        this.jdField_a_of_type_AndroidxPrintPrintHelper.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options = null;
      }
      return;
    }
  }
  
  public void onFinish()
  {
    super.onFinish();
    a();
    if (this.jdField_a_of_type_AndroidOsAsyncTask != null) {
      this.jdField_a_of_type_AndroidOsAsyncTask.cancel(true);
    }
    if (this.jdField_a_of_type_AndroidxPrintPrintHelper$OnPrintFinishCallback != null) {
      this.jdField_a_of_type_AndroidxPrintPrintHelper$OnPrintFinishCallback.a();
    }
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
  }
  
  public void onLayout(PrintAttributes paramPrintAttributes1, PrintAttributes paramPrintAttributes2, CancellationSignal paramCancellationSignal, PrintDocumentAdapter.LayoutResultCallback paramLayoutResultCallback, Bundle paramBundle)
  {
    boolean bool = true;
    try
    {
      this.jdField_a_of_type_AndroidPrintPrintAttributes = paramPrintAttributes2;
      if (paramCancellationSignal.isCanceled())
      {
        paramLayoutResultCallback.onLayoutCancelled();
        return;
      }
    }
    finally {}
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      paramCancellationSignal = new PrintDocumentInfo.Builder(this.jdField_a_of_type_JavaLangString).setContentType(1).setPageCount(1).build();
      if (!paramPrintAttributes2.equals(paramPrintAttributes1)) {}
      for (;;)
      {
        paramLayoutResultCallback.onLayoutFinished(paramCancellationSignal, bool);
        return;
        bool = false;
      }
    }
    this.jdField_a_of_type_AndroidOsAsyncTask = new PrintHelper.PrintUriAdapter.1(this, paramCancellationSignal, paramPrintAttributes2, paramPrintAttributes1, paramLayoutResultCallback).execute(new Uri[0]);
  }
  
  public void onWrite(PageRange[] paramArrayOfPageRange, ParcelFileDescriptor paramParcelFileDescriptor, CancellationSignal paramCancellationSignal, PrintDocumentAdapter.WriteResultCallback paramWriteResultCallback)
  {
    this.jdField_a_of_type_AndroidxPrintPrintHelper.a(this.jdField_a_of_type_AndroidPrintPrintAttributes, this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidGraphicsBitmap, paramParcelFileDescriptor, paramCancellationSignal, paramWriteResultCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.print.PrintHelper.PrintUriAdapter
 * JD-Core Version:    0.7.0.1
 */