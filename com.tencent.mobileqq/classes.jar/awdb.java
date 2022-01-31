import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;

class awdb
  extends alwx
{
  awdb(awcx paramawcx) {}
  
  public void a(boolean paramBoolean, String paramString, badf parambadf)
  {
    if (awcx.a(this.a, paramBoolean, paramString, parambadf)) {}
    for (;;)
    {
      return;
      if (awcx.a(this.a))
      {
        if (paramBoolean) {
          awcx.c(this.a, true);
        }
        if (awcx.b(this.a) > 0) {
          awcx.c(this.a);
        }
        if (QLog.isColorLevel()) {
          QLog.d("AccountPanel", 2, "onSubAccountThirdQQUnreadMsgNum() mRequestNum = " + awcx.b(this.a));
        }
        if (awcx.b(this.a) == 0)
        {
          awcx.b(this.a, false);
          if (awcx.b(this.a)) {
            awcx.a(this.a);
          }
        }
      }
      else if ((paramBoolean) && (awcx.a(this.a) != null))
      {
        int j = awcx.a(this.a).getChildCount();
        int i = 0;
        while (i < j)
        {
          paramString = awcx.a(this.a).getChildAt(i);
          if ((!TextUtils.isEmpty((String)paramString.getTag(2131361879))) && ((paramString.getTag() instanceof awdm)))
          {
            paramString = (awdm)paramString.getTag();
            if (paramString.jdField_a_of_type_Int == 1) {
              paramString.a(0, false);
            }
          }
          i += 1;
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (awcx.a(this.a) == null)) {
      return;
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("AccountPanel onSubAccountMsgNumConfirm isSuccess=").append(paramBoolean).append(" subUin=").append(paramString1).append(" set need2ConfirmMsgNum=");
      if (paramBoolean) {
        break label127;
      }
    }
    label127:
    for (paramBoolean = true;; paramBoolean = false)
    {
      QLog.d("AccountPanel", 2, paramBoolean + " nextAction=" + paramString2);
      if (paramString1.equals(awcx.a(this.a).getUin())) {
        this.a.a(awcx.a(this.a));
      }
      awcx.a(this.a, null);
      return;
    }
  }
  
  public void b(boolean paramBoolean, String paramString, bade parambade)
  {
    if (awcx.a(this.a, paramString, parambade)) {
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
            if (!awcx.a(this.a)) {
              break;
            }
            if (paramBoolean) {
              awcx.c(this.a, true);
            }
            if (awcx.b(this.a) > 0) {
              awcx.c(this.a);
            }
            if (QLog.isColorLevel()) {
              QLog.d("AccountPanel", 2, "onGetSubAccountMsg() mRequestNum=" + awcx.b(this.a));
            }
          } while (awcx.b(this.a) != 0);
          awcx.b(this.a, false);
        } while (!awcx.b(this.a));
        awcx.a(this.a);
        return;
      } while (!paramBoolean);
      parambade = awcx.a(this.a, paramString);
    } while (parambade == null);
    paramString = bacu.a(awcx.a(this.a), paramString);
    parambade.a(paramString.jdField_a_of_type_Int, paramString.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awdb
 * JD-Core Version:    0.7.0.1
 */