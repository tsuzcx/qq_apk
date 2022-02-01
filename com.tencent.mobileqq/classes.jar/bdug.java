import android.os.Bundle;
import com.tencent.mobileqq.studymode.KidModeAdvanceSettingFragment;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.FormMultiLineSwitchItem;
import com.tencent.mobileqq.widget.QQToast;

public class bdug
  extends bdut
{
  public bdug(KidModeAdvanceSettingFragment paramKidModeAdvanceSettingFragment) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    int i = 0;
    KidModeAdvanceSettingFragment localKidModeAdvanceSettingFragment;
    switch (paramInt)
    {
    default: 
    case 8: 
    case 16: 
    case 32: 
      do
      {
        return;
        bool = bdvn.b(paramInt);
        KidModeAdvanceSettingFragment.a(this.a, paramInt, bool);
      } while (paramBoolean);
      localKidModeAdvanceSettingFragment = this.a;
      if (!bool) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        KidModeAdvanceSettingFragment.a(localKidModeAdvanceSettingFragment, paramInt, paramBoolean);
        QQToast.a(this.a.getActivity(), 1, 2131719155, 0).a();
        return;
      }
    }
    if (paramBoolean)
    {
      paramInt = i;
      if (KidModeAdvanceSettingFragment.a(this.a).a()) {
        paramInt = 1;
      }
      bdvn.a(paramInt);
    }
    for (;;)
    {
      KidModeAdvanceSettingFragment.a(this.a).setEnabled(true);
      return;
      localKidModeAdvanceSettingFragment = this.a;
      FormMultiLineSwitchItem localFormMultiLineSwitchItem = KidModeAdvanceSettingFragment.a(this.a);
      paramBoolean = bool;
      if (!KidModeAdvanceSettingFragment.a(this.a).a()) {
        paramBoolean = true;
      }
      KidModeAdvanceSettingFragment.a(localKidModeAdvanceSettingFragment, localFormMultiLineSwitchItem, paramBoolean, KidModeAdvanceSettingFragment.a(this.a));
      bduv.a(this.a.getActivity(), anvx.a(2131719155), 1);
    }
  }
  
  public void b(boolean paramBoolean, Bundle paramBundle)
  {
    KidModeAdvanceSettingFragment.a(this.a);
  }
  
  public void c(boolean paramBoolean, Bundle paramBundle)
  {
    String str = paramBundle.getString("phone");
    paramBundle = paramBundle.getString("mibao_set_url");
    if (StringUtil.isEmpty(str)) {}
    for (int i = 1;; i = 0)
    {
      bdvn.a(i, str, paramBundle);
      KidModeAdvanceSettingFragment.a(this.a, StringUtil.isEmpty(str));
      KidModeAdvanceSettingFragment.a(this.a, 4);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdug
 * JD-Core Version:    0.7.0.1
 */