import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FMLocalFileActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.MobileQQ;

public class athn
  implements View.OnClickListener
{
  public athn(FMLocalFileActivity paramFMLocalFileActivity) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.a()) {
      if (QLog.isColorLevel()) {
        QLog.i(FMLocalFileActivity.f, 2, "click too fast , wait a minute.");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.e();
      Object localObject = (atza)paramView.getTag();
      if (((atza)localObject).a != 0)
      {
        int i = ((atza)localObject).a;
        localObject = this.a.app.getApplication().getSharedPreferences("aio_last_select_file", 0).edit();
        ((SharedPreferences.Editor)localObject).putBoolean("last_select_All", true);
        ((SharedPreferences.Editor)localObject).commit();
        FMLocalFileActivity.a(this.a, i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     athn
 * JD-Core Version:    0.7.0.1
 */