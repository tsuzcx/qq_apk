import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.comic.VipComicJumpActivity;

public class aqtz
  implements aque
{
  public String a()
  {
    return ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getApp().getResources().getString(2131690548);
  }
  
  public void a(View paramView, int paramInt)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Object localObject = new Intent("android.intent.action.MAIN");
    paramView = paramView.getContext();
    localObject = VipComicJumpActivity.a((Intent)localObject);
    if (VipComicJumpActivity.a(localQQAppInterface, (Activity)paramView, (bmbn)localObject)) {
      VipComicJumpActivity.a(localQQAppInterface, true);
    }
    bdll.b(null, "dc00898", "", "", "0X800AA81", "0X800AA81", aqsd.b(paramInt), 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqtz
 * JD-Core Version:    0.7.0.1
 */