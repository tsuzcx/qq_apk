import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;
import com.tencent.mobileqq.extendfriend.limitchat.ExtendFriendLimitChatMatchFragment;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class anst
  extends anoj
{
  public anst(ExtendFriendLimitChatMatchFragment paramExtendFriendLimitChatMatchFragment) {}
  
  protected void a(int paramInt)
  {
    arjg.a(this.a.a, ExtendFriendLimitChatMatchFragment.a(this.a).app);
  }
  
  protected void a(boolean paramBoolean1, ArrayList<anpw> paramArrayList, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ExtendFriendLimitChatMatchFragment", 2, "onGetUnLimitBaseInfo suc:" + paramBoolean1);
    }
    int i;
    if (paramBoolean1)
    {
      if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
        break label205;
      }
      paramArrayList = (anpw)paramArrayList.get(0);
      if (paramArrayList == null) {
        break label196;
      }
      i = paramArrayList.b;
      if (i > 0) {
        break label120;
      }
      QLog.e("ExtendFriendLimitChatMatchFragment", 2, "TagInfo count wrong");
    }
    for (;;)
    {
      if ((paramArrayList.a != null) && (paramArrayList.a.size() > 0))
      {
        if (ExtendFriendLimitChatMatchFragment.a(this.a) == null) {
          break;
        }
        ExtendFriendLimitChatMatchFragment.a(this.a).a(paramArrayList.a);
      }
      return;
      label120:
      String str = i + BaseApplication.getContext().getResources().getString(2131633248);
      if (ExtendFriendLimitChatMatchFragment.a(this.a) != null) {
        ExtendFriendLimitChatMatchFragment.a(this.a).setText(str);
      } else {
        QLog.e("ExtendFriendLimitChatMatchFragment", 2, "mMatchCountTxt is null");
      }
    }
    QLog.e("ExtendFriendLimitChatMatchFragment", 2, "mHeadsPanleView is null");
    return;
    label196:
    QLog.e("ExtendFriendLimitChatMatchFragment", 2, "TagInfo null");
    return;
    label205:
    QLog.e("ExtendFriendLimitChatMatchFragment", 2, "TagInfo size 0");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anst
 * JD-Core Version:    0.7.0.1
 */