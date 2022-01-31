import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.qphone.base.util.QLog;

class auhn
  extends akav
{
  auhn(auhi paramauhi) {}
  
  public void a(boolean paramBoolean, String paramString, ayax paramayax)
  {
    if ((auhi.a(this.a) == null) || (auhi.a(this.a).isFinishing()) || (auhi.a(this.a) == null) || (paramayax == null) || (TextUtils.isEmpty(paramString))) {
      QLog.d("AccountPanel", 1, String.format("onGetSubAccountMsg return, isSuccess: %s, mainAccount: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
    }
    for (;;)
    {
      return;
      if (!TextUtils.equals(paramString, auhi.a(this.a).getCurrentAccountUin()))
      {
        QLog.d("AccountPanel", 1, String.format("onGetSubAccountMsg return, mainAccount: %s not equal", new Object[] { paramString }));
        return;
      }
      if (auhi.a(this.a))
      {
        if (paramBoolean) {
          auhi.c(this.a, true);
        }
        if (auhi.b(this.a) > 0) {
          auhi.c(this.a);
        }
        if (QLog.isColorLevel()) {
          QLog.d("AccountPanel", 2, "onSubAccountThirdQQUnreadMsgNum() mRequestNum = " + auhi.b(this.a));
        }
        if (auhi.b(this.a) == 0)
        {
          auhi.b(this.a, false);
          if (auhi.b(this.a)) {
            auhi.a(this.a);
          }
        }
      }
      else if ((paramBoolean) && (auhi.a(this.a) != null))
      {
        int j = auhi.a(this.a).getChildCount();
        int i = 0;
        while (i < j)
        {
          paramayax = auhi.a(this.a).getChildAt(i);
          paramString = (String)paramayax.getTag(2131361880);
          if ((!TextUtils.isEmpty(paramString)) && ((paramayax.getTag() instanceof auhy)))
          {
            paramayax = (auhy)paramayax.getTag();
            if (paramayax.a == 1) {
              paramayax.b(ayao.a(auhi.a(this.a), paramString));
            }
          }
          i += 1;
        }
      }
    }
  }
  
  public void b(boolean paramBoolean, String paramString, ayaw paramayaw)
  {
    if ((auhi.a(this.a) == null) || (auhi.a(this.a).isFinishing()) || (auhi.a(this.a) == null) || (paramayaw == null) || (TextUtils.isEmpty(paramString))) {
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
            if (!auhi.a(this.a)) {
              break;
            }
            if (paramBoolean) {
              auhi.c(this.a, true);
            }
            if (auhi.b(this.a) > 0) {
              auhi.c(this.a);
            }
            if (QLog.isColorLevel()) {
              QLog.d("AccountPanel", 2, "onGetSubAccountMsg() mRequestNum=" + auhi.b(this.a));
            }
          } while (auhi.b(this.a) != 0);
          auhi.b(this.a, false);
        } while (!auhi.b(this.a));
        auhi.a(this.a);
        return;
      } while (!paramBoolean);
      paramayaw = auhi.a(this.a, paramString);
    } while (paramayaw == null);
    paramayaw.b(auhi.a(this.a).a().a().a(paramString, 7000));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     auhn
 * JD-Core Version:    0.7.0.1
 */