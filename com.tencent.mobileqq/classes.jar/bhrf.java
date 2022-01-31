import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.cropvideo.CropVideoActivity;

public class bhrf
  extends Handler
{
  public bhrf(CropVideoActivity paramCropVideoActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 1: 
    case 2: 
      do
      {
        return;
        postDelayed(this.a.a, 1000L);
        CropVideoActivity.a(this.a).setProgress(paramMessage.arg1);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("CropVideoActivity", 2, "crop video begin");
        }
        if ((CropVideoActivity.a(this.a) >= CropVideoActivity.b(this.a)) && (CropVideoActivity.b(this.a) >= 0L))
        {
          if (QLog.isColorLevel()) {
            QLog.e("CropVideoActivity", 2, "startCropVideo illegal time!");
          }
          bbmy.a(this.a.getApplicationContext(), ajjy.a(2131636840), 1).a();
          return;
        }
      } while (CropVideoActivity.a(this.a, CropVideoActivity.a(this.a)) != 0);
      if (Build.VERSION.SDK_INT >= 18) {
        bhri.a(CropVideoActivity.a(this.a), CropVideoActivity.b(this.a), CropVideoActivity.a(this.a), CropVideoActivity.b(this.a), CropVideoActivity.c(this.a), CropVideoActivity.d(this.a), CropVideoActivity.e(this.a), CropVideoActivity.f(this.a), CropVideoActivity.a(this.a), CropVideoActivity.b(this.a), new bhrg(this));
      }
      for (;;)
      {
        this.a.a();
        return;
        CropVideoActivity.a(this.a, CropVideoActivity.a(this.a), CropVideoActivity.b(this.a), CropVideoActivity.a(this.a), CropVideoActivity.b(this.a), CropVideoActivity.c(this.a), CropVideoActivity.d(this.a), CropVideoActivity.a(this.a), CropVideoActivity.b(this.a));
      }
    case 3: 
      if (QLog.isColorLevel()) {
        QLog.d("CropVideoActivity", 2, "crop video success");
      }
      this.a.finish();
      return;
    case 4: 
      if (QLog.isColorLevel()) {
        QLog.d("CropVideoActivity", 2, "crop video fail");
      }
      bbmy.a(this.a.getApplicationContext(), 1, ajjy.a(2131636838), 1).a();
      this.a.finish();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CropVideoActivity", 2, "crop video with ffmpeg");
    }
    CropVideoActivity.a(this.a, CropVideoActivity.a(this.a), CropVideoActivity.b(this.a), CropVideoActivity.a(this.a), CropVideoActivity.b(this.a), CropVideoActivity.c(this.a), CropVideoActivity.d(this.a), CropVideoActivity.a(this.a), CropVideoActivity.b(this.a));
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhrf
 * JD-Core Version:    0.7.0.1
 */