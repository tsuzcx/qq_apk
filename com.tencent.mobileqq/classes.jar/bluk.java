import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.music.humrecognition.HummingActivity;

public class bluk
  implements View.OnClickListener
{
  public bluk(HummingActivity paramHummingActivity) {}
  
  public void onClick(View paramView)
  {
    if (blud.b()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("HUM_HummingActivity", 2, "onClick: play mHumMusicItemInfo = " + HummingActivity.a(this.a));
    }
    if (HummingActivity.a(this.a).b(HummingActivity.a(this.a)))
    {
      paramView = new Intent();
      paramView.putExtra("EXTRA_HUM_RECOGNITION_RESULT", HummingActivity.a(this.a));
      this.a.setResult(-1, paramView);
      this.a.finish();
      return;
    }
    HummingActivity.a(this.a).a(HummingActivity.a(this.a), this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bluk
 * JD-Core Version:    0.7.0.1
 */