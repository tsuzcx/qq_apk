import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.mobileqq.pic.PicShareToWX;
import com.tencent.mobileqq.screendetect.ScreenShotFragment;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;

public class awgm
  implements bfpc
{
  public awgm(ScreenShotFragment paramScreenShotFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotFragment", 2, "OnItemClickListener : position = " + paramInt + ", view = " + paramView + ", id = " + paramLong);
    }
    paramAdapterView = paramView.getTag();
    if (paramAdapterView == null) {
      return;
    }
    int i = ((awgp)paramAdapterView).a.c;
    paramAdapterView = null;
    switch (i)
    {
    default: 
      if ((ScreenShotFragment.a(this.a)) && (paramAdapterView != null)) {
        awgq.a("0X800A9A9", paramAdapterView, "1");
      }
      if ((i != 9) && (i != 10)) {
        break label300;
      }
      paramInt = -1;
      if (!WXShareHelper.a().a()) {
        paramInt = 2131720906;
      }
      break;
    }
    for (;;)
    {
      if (paramInt == -1) {
        break label300;
      }
      bcpw.a(this.a.getActivity(), this.a.getActivity().getString(paramInt), 0).b(this.a.getActivity().getResources().getDimensionPixelSize(2131298865));
      return;
      awgq.a("0X8009FF0", 0);
      paramAdapterView = "1";
      break;
      awgq.a("0X8009FF1", 0);
      paramAdapterView = "2";
      break;
      awgq.a("0X8009FF2", 0);
      paramAdapterView = "3";
      break;
      awgq.a("0X8009FF3", 0);
      paramAdapterView = "4";
      break;
      awgq.a("0X800A77D", 0);
      paramAdapterView = "5";
      break;
      if (!WXShareHelper.a().b()) {
        paramInt = 2131720907;
      }
    }
    switch (i)
    {
    default: 
      return;
    case 2: 
      ScreenShotFragment.a(this.a.getActivity(), ScreenShotFragment.a(this.a));
      return;
    case 3: 
      ScreenShotFragment.a(this.a, this.a.getActivity(), ScreenShotFragment.a(this.a));
      return;
    case 9: 
      if ((PicShareToWX.a().a()) && (PicShareToWX.a().a(ScreenShotFragment.a(this.a))))
      {
        PicShareToWX.a().a(this.a.getActivity(), ScreenShotFragment.a(this.a), ScreenShotFragment.a(this.a), 3);
        axqw.b(null, "dc00898", "", "", "0X800A505", "0X800A505", 0, 0, "", "", "", "");
        return;
      }
      ScreenShotFragment.a(this.a, ScreenShotFragment.a(this.a), ScreenShotFragment.a(this.a));
      return;
    case 10: 
      label300:
      ScreenShotFragment.b(this.a, ScreenShotFragment.a(this.a), ScreenShotFragment.a(this.a));
      return;
    }
    ScreenShotFragment.a(this.a, ScreenShotFragment.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     awgm
 * JD-Core Version:    0.7.0.1
 */