package androidx.print;

import android.os.CancellationSignal.OnCancelListener;

class PrintHelper$PrintUriAdapter$1$1
  implements CancellationSignal.OnCancelListener
{
  PrintHelper$PrintUriAdapter$1$1(PrintHelper.PrintUriAdapter.1 param1) {}
  
  public void onCancel()
  {
    this.this$2.this$1.cancelLoad();
    this.this$2.cancel(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.print.PrintHelper.PrintUriAdapter.1.1
 * JD-Core Version:    0.7.0.1
 */