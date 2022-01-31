import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.limitchat.ExtendFriendLimitChatMatchFragment;
import com.tencent.mobileqq.extendfriend.wiget.horseRaceLamp.HorseRaceLampVew;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class aqfv
  extends aqbl
{
  public aqfv(ExtendFriendLimitChatMatchFragment paramExtendFriendLimitChatMatchFragment) {}
  
  protected void a(int paramInt)
  {
    auau.a(this.a.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch, ExtendFriendLimitChatMatchFragment.a(this.a).app);
  }
  
  protected void a(boolean paramBoolean1, ArrayList<aqda> paramArrayList, boolean paramBoolean2, int paramInt, ArrayList<String> paramArrayList1)
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
          if (this.a.jdField_a_of_type_Aqio == null) {
            break label255;
          }
          this.a.jdField_a_of_type_Aqio.a(paramArrayList1);
        }
      }
      for (;;)
      {
        if ((paramArrayList == null) || (paramArrayList.size() <= 0) || (ExtendFriendLimitChatMatchFragment.a(this.a) == null)) {
          break label468;
        }
        paramInt = 0;
        while (paramInt < paramArrayList.size())
        {
          paramArrayList1 = (aqda)paramArrayList.get(paramInt);
          if (!TextUtils.isEmpty(paramArrayList1.jdField_a_of_type_JavaLangString)) {
            ExtendFriendLimitChatMatchFragment.a(this.a, ExtendFriendLimitChatMatchFragment.a(this.a) + paramArrayList1.jdField_a_of_type_JavaLangString + ";");
          }
          paramInt += 1;
        }
        String str = paramInt + BaseApplication.getContext().getResources().getString(2131699334);
        if (ExtendFriendLimitChatMatchFragment.a(this.a) != null)
        {
          ExtendFriendLimitChatMatchFragment.a(this.a).setText(str);
          break;
        }
        QLog.e("ExtendFriendLimitChatMatchFragment", 2, "mMatchCountTxt is null");
        break;
        label255:
        QLog.e("ExtendFriendLimitChatMatchFragment", 2, "mHeadsPanleView is null");
      }
      paramBoolean2 = false;
      paramBoolean1 = paramBoolean2;
      if (ExtendFriendLimitChatMatchFragment.a(this.a).app != null)
      {
        paramArrayList1 = (aqbg)ExtendFriendLimitChatMatchFragment.a(this.a).app.getManager(264);
        paramBoolean1 = paramBoolean2;
        if (paramArrayList1 != null) {
          paramBoolean1 = paramArrayList1.g();
        }
      }
      paramInt = paramArrayList.size() - 1;
      while (paramInt >= 0)
      {
        if ((((aqda)paramArrayList.get(paramInt)).jdField_a_of_type_Int == 10000) && (!paramBoolean1))
        {
          QLog.e("ExtendFriendLimitChatMatchFragment", 2, "MATCH_CHAT_TAG_ID_FOR_VOICE_MATCH REMOVE by flag");
          paramArrayList.remove(paramInt);
        }
        paramInt -= 1;
      }
      paramArrayList1 = new aqjd();
      paramArrayList1.a(paramArrayList);
      if (paramArrayList.size() <= 0) {
        break label459;
      }
      if (ExtendFriendLimitChatMatchFragment.a(this.a) != null)
      {
        ExtendFriendLimitChatMatchFragment.a(this.a).setAdapter(paramArrayList1);
        azqs.b(ExtendFriendLimitChatMatchFragment.a(this.a).app, "dc00898", "", "", "qq_kuolie", "0X800AA94", 0, 0, "", "", ExtendFriendLimitChatMatchFragment.a(this.a), "");
      }
    }
    return;
    label459:
    QLog.e("ExtendFriendLimitChatMatchFragment", 2, "TaginfoInfo size 0");
    return;
    label468:
    QLog.e("ExtendFriendLimitChatMatchFragment", 2, "TagInfo size 0");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqfv
 * JD-Core Version:    0.7.0.1
 */