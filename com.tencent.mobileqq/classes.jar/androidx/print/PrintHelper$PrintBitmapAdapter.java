package androidx.print;

import android.graphics.Bitmap;
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
class PrintHelper$PrintBitmapAdapter
  extends PrintDocumentAdapter
{
  private final int jdField_a_of_type_Int;
  private final Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private PrintAttributes jdField_a_of_type_AndroidPrintPrintAttributes;
  private final PrintHelper.OnPrintFinishCallback jdField_a_of_type_AndroidxPrintPrintHelper$OnPrintFinishCallback;
  private final String jdField_a_of_type_JavaLangString;
  
  public void onFinish()
  {
    if (this.jdField_a_of_type_AndroidxPrintPrintHelper$OnPrintFinishCallback != null) {
      this.jdField_a_of_type_AndroidxPrintPrintHelper$OnPrintFinishCallback.a();
    }
  }
  
  public void onLayout(PrintAttributes paramPrintAttributes1, PrintAttributes paramPrintAttributes2, CancellationSignal paramCancellationSignal, PrintDocumentAdapter.LayoutResultCallback paramLayoutResultCallback, Bundle paramBundle)
  {
    boolean bool = true;
    this.jdField_a_of_type_AndroidPrintPrintAttributes = paramPrintAttributes2;
    paramCancellationSignal = new PrintDocumentInfo.Builder(this.jdField_a_of_type_JavaLangString).setContentType(1).setPageCount(1).build();
    if (!paramPrintAttributes2.equals(paramPrintAttributes1)) {}
    for (;;)
    {
      paramLayoutResultCallback.onLayoutFinished(paramCancellationSignal, bool);
      return;
      bool = false;
    }
  }
  
  public void onWrite(PageRange[] paramArrayOfPageRange, ParcelFileDescriptor paramParcelFileDescriptor, CancellationSignal paramCancellationSignal, PrintDocumentAdapter.WriteResultCallback paramWriteResultCallback)
  {
    this.jdField_a_of_type_AndroidxPrintPrintHelper.a(this.jdField_a_of_type_AndroidPrintPrintAttributes, this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidGraphicsBitmap, paramParcelFileDescriptor, paramCancellationSignal, paramWriteResultCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.print.PrintHelper.PrintBitmapAdapter
 * JD-Core Version:    0.7.0.1
 */