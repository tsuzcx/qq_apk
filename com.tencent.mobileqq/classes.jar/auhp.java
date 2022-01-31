import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.qphone.base.util.QLog;

class auhp
  extends akat
{
  auhp(auhk paramauhk) {}
  
  public void a(boolean paramBoolean, String paramString, ayaz paramayaz)
  {
    if ((auhk.a(this.a) == null) || (auhk.a(this.a).isFinishing()) || (auhk.a(this.a) == null) || (paramayaz == null) || (TextUtils.isEmpty(paramString))) {
      QLog.d("AccountPanel", 1, String.format("onGetSubAccountMsg return, isSuccess: %s, mainAccount: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
    }
    for (;;)
    {
      return;
      if (!TextUtils.equals(paramString, auhk.a(this.a).getCurrentAccountUin()))
      {
        QLog.d("AccountPanel", 1, String.format("onGetSubAccountMsg return, mainAccount: %s not equal", new Object[] { paramString }));
        return;
      }
      if (auhk.a(this.a))
      {
        if (paramBoolean) {
          auhk.c(this.a, true);
        }
        if (auhk.b(this.a) > 0) {
          auhk.c(this.a);
        }
        if (QLog.isColorLevel()) {
          QLog.d("AccountPanel", 2, "onSubAccountThirdQQUnreadMsgNum() mRequestNum = " + auhk.b(this.a));
        }
        if (auhk.b(this.a) == 0)
        {
          auhk.b(this.a, false);
          if (auhk.b(this.a)) {
            auhk.a(this.a);
          }
        }
      }
      else if ((paramBoolean) && (auhk.a(this.a) != null))
      {
        int j = auhk.a(this.a).getChildCount();
        int i = 0;
        while (i < j)
        {
          paramayaz = auhk.a(this.a).getChildAt(i);
          paramString = (String)paramayaz.getTag(2131361879);
          if ((!TextUtils.isEmpty(paramString)) && ((paramayaz.getTag() instanceof auia)))
          {
            paramayaz = (auia)paramayaz.getTag();
            if (paramayaz.a == 1) {
              paramayaz.b(ayaq.a(auhk.a(this.a), paramString));
            }
          }
          i += 1;
        }
      }
    }
  }
  
  public void b(boolean paramBoolean, String paramString, ayay paramayay)
  {
    if ((auhk.a(this.a) == null) || (auhk.a(this.a).isFinishing()) || (auhk.a(this.a) == null) || (paramayay == null) || (TextUtils.isEmpty(paramString))) {
      QLog.d("AccountPanel", 1, String.format("onGetSubAccountMsg return, isSuccess: %s, subAccount: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (!auhk.a(this.a)) {
              break;
            }
            if (paramBoolean) {
              auhk.c(this.a, true);
            }
            if (auhk.b(this.a) > 0) {
              auhk.c(this.a);
            }
            if (QLog.isColorLevel()) {
              QLog.d("AccountPanel", 2, "onGetSubAccountMsg() mRequestNum=" + auhk.b(this.a));
            }
          } while (auhk.b(this.a) != 0);
          auhk.b(this.a, false);
        } while (!auhk.b(this.a));
        auhk.a(this.a);
        return;
      } while (!paramBoolean);
      paramayay = auhk.a(this.a, paramString);
    } while (paramayay == null);
    paramayay.b(auhk.a(this.a).a().a().a(paramString, 7000));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     auhp
 * JD-Core Version:    0.7.0.1
 */