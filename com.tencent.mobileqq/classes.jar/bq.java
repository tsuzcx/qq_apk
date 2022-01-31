import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;

public final class bq
  implements bt
{
  public bq(IphoneTitleBarActivity paramIphoneTitleBarActivity, String paramString, ViewGroup paramViewGroup) {}
  
  public void a(Bitmap paramBitmap, boolean paramBoolean)
  {
    if ((paramBitmap != null) || (paramBoolean)) {
      new Handler(Looper.getMainLooper()).post(new br(this, paramBoolean, paramBitmap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bq
 * JD-Core Version:    0.7.0.1
 */