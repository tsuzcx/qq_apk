import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class aoad
  implements aoah
{
  public String a()
  {
    return ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getApp().getResources().getString(2131692446);
  }
  
  public void a(View paramView, int paramInt)
  {
    boolean bool2 = true;
    Context localContext = paramView.getContext();
    boolean bool1;
    if (!((BaseActivity)paramView.getContext()).isInMultiWindow())
    {
      bool1 = true;
      if (!(localContext instanceof BaseActivity)) {
        break label121;
      }
      if (((BaseActivity)localContext).isInMultiWindow()) {
        break label116;
      }
      bool1 = bool2;
    }
    label116:
    label121:
    for (;;)
    {
      paramView = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      biqv.a((Activity)localContext, paramView.getAccount(), null, -1, bool1);
      birh.b(paramView, 6, 0);
      birl.a(paramView.getCurrentAccountUin());
      azmj.b(null, "dc00898", "", "", "0X800AA81", "0X800AA81", 2, 0, "", "", "", "");
      return;
      bool1 = false;
      break;
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoad
 * JD-Core Version:    0.7.0.1
 */