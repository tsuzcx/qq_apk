import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilesetting.InterestSwitchEditActivity;
import com.tencent.mobileqq.profilesetting.ReqSetSettingItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class azrl
  extends azrj
{
  public azrl(InterestSwitchEditActivity paramInterestSwitchEditActivity) {}
  
  public void a(boolean paramBoolean, String paramString, Card paramCard)
  {
    if (QLog.isColorLevel()) {
      QLog.i("InterestSwitchEditActivity", 2, "onGetCardDisplaySetting isSuccess=" + paramBoolean + " uin=" + paramString);
    }
    if (!TextUtils.equals(this.a.app.getCurrentAccountUin(), paramString)) {
      return;
    }
    if (paramBoolean)
    {
      paramString = this.a;
      if (paramCard != null) {}
      for (;;)
      {
        InterestSwitchEditActivity.a(paramString, paramCard);
        azsm.a.a(this.a.app, InterestSwitchEditActivity.a(this.a), InterestSwitchEditActivity.a(this.a), InterestSwitchEditActivity.a(this.a));
        InterestSwitchEditActivity.a(this.a);
        return;
        paramCard = InterestSwitchEditActivity.a(this.a);
      }
    }
    QQToast.a(this.a, anni.a(2131704592), 0).b(this.a.getTitleBarHeight());
  }
  
  public void a(boolean paramBoolean, String paramString, Card paramCard, ArrayList<ReqSetSettingItem> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("InterestSwitchEditActivity", 2, "onSetCardDisplaySetting isSuccess=" + paramBoolean + " uin=" + paramString);
    }
    if (!TextUtils.equals(this.a.app.getCurrentAccountUin(), paramString)) {
      return;
    }
    if (!paramBoolean)
    {
      QQToast.a(BaseApplicationImpl.sApplication, 2131718381, 0).b(this.a.getTitleBarHeight());
      if (paramArrayList != null)
      {
        paramString = paramArrayList.iterator();
        while (paramString.hasNext())
        {
          paramCard = (ReqSetSettingItem)paramString.next();
          azsm.a.a(paramCard.a(), InterestSwitchEditActivity.a(this.a)).c(paramCard.b());
        }
      }
    }
    InterestSwitchEditActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azrl
 * JD-Core Version:    0.7.0.1
 */