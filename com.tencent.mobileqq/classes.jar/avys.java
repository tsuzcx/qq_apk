import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;

class avys
  extends alsi
{
  avys(avyo paramavyo) {}
  
  public void a(boolean paramBoolean, String paramString, azyw paramazyw)
  {
    if (avyo.a(this.a, paramBoolean, paramString, paramazyw)) {}
    for (;;)
    {
      return;
      if (avyo.a(this.a))
      {
        if (paramBoolean) {
          avyo.c(this.a, true);
        }
        if (avyo.b(this.a) > 0) {
          avyo.c(this.a);
        }
        if (QLog.isColorLevel()) {
          QLog.d("AccountPanel", 2, "onSubAccountThirdQQUnreadMsgNum() mRequestNum = " + avyo.b(this.a));
        }
        if (avyo.b(this.a) == 0)
        {
          avyo.b(this.a, false);
          if (avyo.b(this.a)) {
            avyo.a(this.a);
          }
        }
      }
      else if ((paramBoolean) && (avyo.a(this.a) != null))
      {
        int j = avyo.a(this.a).getChildCount();
        int i = 0;
        while (i < j)
        {
          paramString = avyo.a(this.a).getChildAt(i);
          if ((!TextUtils.isEmpty((String)paramString.getTag(2131361879))) && ((paramString.getTag() instanceof avzd)))
          {
            paramString = (avzd)paramString.getTag();
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
    if ((TextUtils.isEmpty(paramString1)) || (avyo.a(this.a) == null)) {
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
      if (paramString1.equals(avyo.a(this.a).getUin())) {
        this.a.a(avyo.a(this.a));
      }
      avyo.a(this.a, null);
      return;
    }
  }
  
  public void b(boolean paramBoolean, String paramString, azyv paramazyv)
  {
    if (avyo.a(this.a, paramString, paramazyv)) {
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
            if (!avyo.a(this.a)) {
              break;
            }
            if (paramBoolean) {
              avyo.c(this.a, true);
            }
            if (avyo.b(this.a) > 0) {
              avyo.c(this.a);
            }
            if (QLog.isColorLevel()) {
              QLog.d("AccountPanel", 2, "onGetSubAccountMsg() mRequestNum=" + avyo.b(this.a));
            }
          } while (avyo.b(this.a) != 0);
          avyo.b(this.a, false);
        } while (!avyo.b(this.a));
        avyo.a(this.a);
        return;
      } while (!paramBoolean);
      paramazyv = avyo.a(this.a, paramString);
    } while (paramazyv == null);
    paramString = azyl.a(avyo.a(this.a), paramString);
    paramazyv.a(paramString.jdField_a_of_type_Int, paramString.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avys
 * JD-Core Version:    0.7.0.1
 */