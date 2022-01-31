import com.tencent.mobileqq.matchchat.MatchChatSettingFragment;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class asfm
  extends aoez
{
  public asfm(MatchChatSettingFragment paramMatchChatSettingFragment) {}
  
  protected void a(boolean paramBoolean1, ArrayList<aogn> paramArrayList, boolean paramBoolean2, int paramInt, ArrayList<String> paramArrayList1)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MatchChatSettingFragment", 2, "onGetUnLimitBaseInfo suc:" + paramBoolean1 + " chatSwitchOpen:" + paramBoolean2);
    }
    if (paramBoolean1) {
      MatchChatSettingFragment.a(this.a, paramBoolean2);
    }
  }
  
  protected void f(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MatchChatSettingFragment", 2, "onGetUnLimitBaseInfo suc:" + paramBoolean);
    }
    MatchChatSettingFragment localMatchChatSettingFragment;
    if (!paramBoolean)
    {
      localMatchChatSettingFragment = this.a;
      if (MatchChatSettingFragment.a(this.a).a()) {
        break label61;
      }
    }
    label61:
    for (paramBoolean = true;; paramBoolean = false)
    {
      MatchChatSettingFragment.a(localMatchChatSettingFragment, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asfm
 * JD-Core Version:    0.7.0.1
 */