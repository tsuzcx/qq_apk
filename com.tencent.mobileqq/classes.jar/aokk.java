import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import mqq.os.MqqHandler;

public class aokk
  implements SurfaceHolder.Callback
{
  public aokk(ShortVideoPreviewActivity paramShortVideoPreviewActivity) {}
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "surfaceCreated: mSavedCurPosition:" + this.a.h + ",mSavedPlayState : " + this.a.a(this.a.i));
    }
    if ((this.a.i == 1) && (this.a.h > 0))
    {
      this.a.a(this.a.h);
      this.a.h = 0;
      this.a.i = 0;
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "surfaceDestroyed ");
    }
    this.a.b();
    if (this.a.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.a.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aokk
 * JD-Core Version:    0.7.0.1
 */