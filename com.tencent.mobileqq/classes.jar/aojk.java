import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.extendfriend.limitchat.ExtendFriendLimitChatMatchFragment;
import com.tencent.mobileqq.extendfriend.wiget.horseRaceLamp.HorseRaceLampVew;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class aojk
  extends aoez
{
  public aojk(ExtendFriendLimitChatMatchFragment paramExtendFriendLimitChatMatchFragment) {}
  
  protected void a(int paramInt)
  {
    asfl.a(this.a.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch, ExtendFriendLimitChatMatchFragment.a(this.a).app);
  }
  
  protected void a(boolean paramBoolean1, ArrayList<aogn> paramArrayList, boolean paramBoolean2, int paramInt, ArrayList<String> paramArrayList1)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ExtendFriendLimitChatMatchFragment", 2, "onGetUnLimitBaseInfo suc:" + paramBoolean1);
    }
    if (paramBoolean1)
    {
      if (paramInt <= 0)
      {
        QLog.e("ExtendFriendLimitChatMatchFragment", 2, "onlineCount  wrong");
        if ((paramArrayList1 != null) && (paramArrayList1.size() > 0))
        {
          if (this.a.jdField_a_of_type_Aolh == null) {
            break label260;
          }
          this.a.jdField_a_of_type_Aolh.a(paramArrayList1);
        }
      }
      for (;;)
      {
        if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
          break label294;
        }
        paramArrayList1 = new aolw();
        paramArrayList1.a(paramArrayList);
        paramInt = 0;
        while (paramInt < paramArrayList.size())
        {
          localObject = (aogn)paramArrayList.get(paramInt);
          if (!TextUtils.isEmpty(((aogn)localObject).a)) {
            ExtendFriendLimitChatMatchFragment.a(this.a, ExtendFriendLimitChatMatchFragment.a(this.a) + ((aogn)localObject).a + ";");
          }
          paramInt += 1;
        }
        Object localObject = paramInt + BaseApplication.getContext().getResources().getString(2131698997);
        if (ExtendFriendLimitChatMatchFragment.a(this.a) != null)
        {
          ExtendFriendLimitChatMatchFragment.a(this.a).setText((CharSequence)localObject);
          break;
        }
        QLog.e("ExtendFriendLimitChatMatchFragment", 2, "mMatchCountTxt is null");
        break;
        label260:
        QLog.e("ExtendFriendLimitChatMatchFragment", 2, "mHeadsPanleView is null");
      }
      if (ExtendFriendLimitChatMatchFragment.a(this.a) != null) {
        ExtendFriendLimitChatMatchFragment.a(this.a).setAdapter(paramArrayList1);
      }
    }
    return;
    label294:
    QLog.e("ExtendFriendLimitChatMatchFragment", 2, "TagInfo size 0");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aojk
 * JD-Core Version:    0.7.0.1
 */