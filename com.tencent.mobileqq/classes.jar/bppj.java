import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.capture.music.humrecognition.HummingActivity;

public class bppj
  implements View.OnClickListener
{
  public bppj(HummingActivity paramHummingActivity) {}
  
  public void onClick(View paramView)
  {
    if (bppc.b()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (QLog.isColorLevel()) {
        QLog.i("HUM_HummingActivity", 2, "onClick: play mHumMusicItemInfo = " + HummingActivity.a(this.a));
      }
      if (HummingActivity.a(this.a).b(HummingActivity.a(this.a)))
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("EXTRA_HUM_RECOGNITION_RESULT", HummingActivity.a(this.a));
        this.a.setResult(-1, localIntent);
        this.a.finish();
      }
      else
      {
        HummingActivity.a(this.a).a(HummingActivity.a(this.a), this.a.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bppj
 * JD-Core Version:    0.7.0.1
 */