import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity;
import com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity.7.1;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class anyy
  implements begw
{
  public anyy(UniformDownloadActivity paramUniformDownloadActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.a.jdField_a_of_type_Begr == null) {
      return;
    }
    if (paramView != null)
    {
      paramView = this.a.jdField_a_of_type_Begr.a(paramInt);
      if (!TextUtils.isEmpty(paramView))
      {
        if ((!paramView.equals(this.a.getResources().getString(2131626340))) && (!paramView.equals(this.a.getResources().getString(2131626341)))) {
          break label270;
        }
        awqx.b(null, "dc00898", "", "", "0X8008F87", "0X8008F87", 1, 0, "", "", "", "");
        if (!UniformDownloadActivity.a(this.a)) {
          break label241;
        }
        if (!bcgg.g()) {
          break label231;
        }
        bcfn.a().a(UniformDownloadActivity.a(this.a), "1", "ANDROIDQQ.POPUP.YYBDOWNAPP", "3007", false);
        paramView = UniformDownloadActivity.a(this.a);
        UniformDownloadActivity.a(this.a, paramView);
        paramView = UniformDownloadActivity.a(this.a, paramView);
        if (QLog.isColorLevel()) {
          QLog.d(UniformDownloadActivity.jdField_a_of_type_JavaLangString, 2, "tmastUrl=" + paramView);
        }
        UniformDownloadActivity.a(this.a, paramView);
        UniformDownloadActivity.b(this.a);
        this.a.finish();
        this.a.overridePendingTransition(0, 0);
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Begr.dismiss();
      return;
      label231:
      UniformDownloadActivity.c(this.a);
      continue;
      label241:
      UniformDownloadActivity.b(this.a).setVisibility(0);
      ThreadManager.getSubThreadHandler().post(new UniformDownloadActivity.7.1(this));
      continue;
      label270:
      if ((paramView.equals(this.a.getResources().getString(2131626339))) || (paramView.equals(this.a.getResources().getString(2131624587))) || (paramView.equals(this.a.getResources().getString(2131624586)))) {
        UniformDownloadActivity.c(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anyy
 * JD-Core Version:    0.7.0.1
 */