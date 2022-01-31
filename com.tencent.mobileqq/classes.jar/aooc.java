import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FMLocalFileActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class aooc
  implements View.OnClickListener
{
  public aooc(FMLocalFileActivity paramFMLocalFileActivity) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.a()) {
      if (QLog.isColorLevel()) {
        QLog.i(FMLocalFileActivity.g, 2, "click too fast , wait a minute.");
      }
    }
    do
    {
      return;
      this.a.e();
      paramView = (apeo)paramView.getTag();
    } while (paramView.a == 0);
    int i = paramView.a;
    paramView = this.a.app.getApplication().getSharedPreferences("aio_last_select_file", 0).edit();
    paramView.putBoolean("last_select_All", true);
    paramView.commit();
    FMLocalFileActivity.a(this.a, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aooc
 * JD-Core Version:    0.7.0.1
 */