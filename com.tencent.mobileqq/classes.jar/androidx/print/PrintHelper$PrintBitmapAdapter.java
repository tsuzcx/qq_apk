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
  private PrintAttributes mAttributes;
  private final Bitmap mBitmap;
  private final PrintHelper.OnPrintFinishCallback mCallback;
  private final int mFittingMode;
  private final String mJobName;
  
  PrintHelper$PrintBitmapAdapter(PrintHelper paramPrintHelper, String paramString, int paramInt, Bitmap paramBitmap, PrintHelper.OnPrintFinishCallback paramOnPrintFinishCallback)
  {
    this.mJobName = paramString;
    this.mFittingMode = paramInt;
    this.mBitmap = paramBitmap;
    this.mCallback = paramOnPrintFinishCallback;
  }
  
  public void onFinish()
  {
    PrintHelper.OnPrintFinishCallback localOnPrintFinishCallback = this.mCallback;
    if (localOnPrintFinishCallback != null) {
      localOnPrintFinishCallback.onFinish();
    }
  }
  
  public void onLayout(PrintAttributes paramPrintAttributes1, PrintAttributes paramPrintAttributes2, CancellationSignal paramCancellationSignal, PrintDocumentAdapter.LayoutResultCallback paramLayoutResultCallback, Bundle paramBundle)
  {
    this.mAttributes = paramPrintAttributes2;
    paramLayoutResultCallback.onLayoutFinished(new PrintDocumentInfo.Builder(this.mJobName).setContentType(1).setPageCount(1).build(), paramPrintAttributes2.equals(paramPrintAttributes1) ^ true);
  }
  
  public void onWrite(PageRange[] paramArrayOfPageRange, ParcelFileDescriptor paramParcelFileDescriptor, CancellationSignal paramCancellationSignal, PrintDocumentAdapter.WriteResultCallback paramWriteResultCallback)
  {
    this.this$0.writeBitmap(this.mAttributes, this.mFittingMode, this.mBitmap, paramParcelFileDescriptor, paramCancellationSignal, paramWriteResultCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.print.PrintHelper.PrintBitmapAdapter
 * JD-Core Version:    0.7.0.1
 */