import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.qphone.base.util.QLog;

class atjo
  extends ajmm
{
  atjo(atjj paramatjj) {}
  
  public void a(boolean paramBoolean, String paramString, axav paramaxav)
  {
    if ((atjj.a(this.a) == null) || (atjj.a(this.a).isFinishing()) || (atjj.a(this.a) == null) || (paramaxav == null) || (TextUtils.isEmpty(paramString))) {
      QLog.d("AccountPanel", 1, String.format("onGetSubAccountMsg return, isSuccess: %s, mainAccount: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
    }
    for (;;)
    {
      return;
      if (!TextUtils.equals(paramString, atjj.a(this.a).getCurrentAccountUin()))
      {
        QLog.d("AccountPanel", 1, String.format("onGetSubAccountMsg return, mainAccount: %s not equal", new Object[] { paramString }));
        return;
      }
      if (atjj.a(this.a))
      {
        if (paramBoolean) {
          atjj.c(this.a, true);
        }
        if (atjj.b(this.a) > 0) {
          atjj.c(this.a);
        }
        if (QLog.isColorLevel()) {
          QLog.d("AccountPanel", 2, "onSubAccountThirdQQUnreadMsgNum() mRequestNum = " + atjj.b(this.a));
        }
        if (atjj.b(this.a) == 0)
        {
          atjj.b(this.a, false);
          if (atjj.b(this.a)) {
            atjj.a(this.a);
          }
        }
      }
      else if ((paramBoolean) && (atjj.a(this.a) != null))
      {
        int j = atjj.a(this.a).getChildCount();
        int i = 0;
        while (i < j)
        {
          paramaxav = atjj.a(this.a).getChildAt(i);
          paramString = (String)paramaxav.getTag(2131296344);
          if ((!TextUtils.isEmpty(paramString)) && ((paramaxav.getTag() instanceof atjz)))
          {
            paramaxav = (atjz)paramaxav.getTag();
            if (paramaxav.a == 1) {
              paramaxav.b(axam.a(atjj.a(this.a), paramString));
            }
          }
          i += 1;
        }
      }
    }
  }
  
  public void b(boolean paramBoolean, String paramString, axau paramaxau)
  {
    if ((atjj.a(this.a) == null) || (atjj.a(this.a).isFinishing()) || (atjj.a(this.a) == null) || (paramaxau == null) || (TextUtils.isEmpty(paramString))) {
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
            if (!atjj.a(this.a)) {
              break;
            }
            if (paramBoolean) {
              atjj.c(this.a, true);
            }
            if (atjj.b(this.a) > 0) {
              atjj.c(this.a);
            }
            if (QLog.isColorLevel()) {
              QLog.d("AccountPanel", 2, "onGetSubAccountMsg() mRequestNum=" + atjj.b(this.a));
            }
          } while (atjj.b(this.a) != 0);
          atjj.b(this.a, false);
        } while (!atjj.b(this.a));
        atjj.a(this.a);
        return;
      } while (!paramBoolean);
      paramaxau = atjj.a(this.a, paramString);
    } while (paramaxau == null);
    paramaxau.b(atjj.a(this.a).a().a().a(paramString, 7000));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     atjo
 * JD-Core Version:    0.7.0.1
 */