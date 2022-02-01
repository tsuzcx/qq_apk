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
  
  protected Bitmap a(Uri... paramVarArgs)
  {
    try
    {
      paramVarArgs = this.jdField_a_of_type_AndroidxPrintPrintHelper$PrintUriAdapter.jdField_a_of_type_AndroidxPrintPrintHelper.a(this.jdField_a_of_type_AndroidxPrintPrintHelper$PrintUriAdapter.jdField_a_of_type_AndroidNetUri);
      return paramVarArgs;
    }
    catch (FileNotFoundException paramVarArgs) {}
    return null;
  }
  
  protected void a(Bitmap paramBitmap)
  {
    boolean bool = true;
    super.onPostExecute(paramBitmap);
    Object localObject = paramBitmap;
    if (paramBitmap != null) {
      if (PrintHelper.jdField_a_of_type_Boolean)
      {
        localObject = paramBitmap;
        if (this.jdField_a_of_type_AndroidxPrintPrintHelper$PrintUriAdapter.jdField_a_of_type_AndroidxPrintPrintHelper.jdField_a_of_type_Int != 0) {
          break label103;
        }
      }
    }
    for (;;)
    {
      try
      {
        PrintAttributes.MediaSize localMediaSize = this.jdField_a_of_type_AndroidxPrintPrintHelper$PrintUriAdapter.jdField_a_of_type_AndroidPrintPrintAttributes.getMediaSize();
        localObject = paramBitmap;
        if (localMediaSize != null)
        {
          localObject = paramBitmap;
          if (localMediaSize.isPortrait() != PrintHelper.a(paramBitmap))
          {
            localObject = new Matrix();
            ((Matrix)localObject).postRotate(90.0F);
            localObject = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
          }
        }
        label103:
        this.jdField_a_of_type_AndroidxPrintPrintHelper$PrintUriAdapter.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject);
        if (localObject == null) {
          break label183;
        }
        paramBitmap = new PrintDocumentInfo.Builder(this.jdField_a_of_type_AndroidxPrintPrintHelper$PrintUriAdapter.jdField_a_of_type_JavaLangString).setContentType(1).setPageCount(1).build();
        if (!this.jdField_a_of_type_AndroidPrintPrintAttributes.equals(this.b))
        {
          this.jdField_a_of_type_AndroidPrintPrintDocumentAdapter$LayoutResultCallback.onLayoutFinished(paramBitmap, bool);
          this.jdField_a_of_type_AndroidxPrintPrintHelper$PrintUriAdapter.jdField_a_of_type_AndroidOsAsyncTask = null;
          return;
        }
      }
      finally {}
      bool = false;
      continue;
      label183:
      this.jdField_a_of_type_AndroidPrintPrintDocumentAdapter$LayoutResultCallback.onLayoutFailed(null);
    }
  }
  
  protected void b(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidPrintPrintDocumentAdapter$LayoutResultCallback.onLayoutCancelled();
    this.jdField_a_of_type_AndroidxPrintPrintHelper$PrintUriAdapter.jdField_a_of_type_AndroidOsAsyncTask = null;
  }
  
  protected void onPreExecute()
  {
    this.jdField_a_of_type_AndroidOsCancellationSignal.setOnCancelListener(new PrintHelper.PrintUriAdapter.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.print.PrintHelper.PrintUriAdapter.1
 * JD-Core Version:    0.7.0.1
 */