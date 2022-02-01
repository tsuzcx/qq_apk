import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.limitchat.ExtendFriendLimitChatMatchFragment;
import com.tencent.mobileqq.extendfriend.wiget.horseRaceLamp.HorseRaceLampVew;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class armu
  extends arht
{
  public armu(ExtendFriendLimitChatMatchFragment paramExtendFriendLimitChatMatchFragment) {}
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    arhi localarhi = (arhi)ExtendFriendLimitChatMatchFragment.a(this.a).app.getManager(264);
    int j;
    int i;
    if (localarhi != null)
    {
      j = (int)localarhi.a();
      i = (int)localarhi.b();
    }
    for (int k = (int)localarhi.c();; k = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendLimitChatMatchFragment", 2, "onUpdateCampusCertificateStatus,isSuccess = " + paramBoolean + ",maxMatchCount = " + j + ",matchedCount = " + i + ",leftMatchCount = " + k + ",scene = " + paramInt);
      }
      if ((paramBoolean) && (paramInt == 1))
      {
        ExtendFriendLimitChatMatchFragment.b(this.a).setVisibility(0);
        ExtendFriendLimitChatMatchFragment.f(this.a);
        if ((ExtendFriendLimitChatMatchFragment.a(this.a).isShowing()) && (localarhi != null)) {
          ExtendFriendLimitChatMatchFragment.a(this.a).b(j, k, localarhi.a());
        }
      }
      return;
      i = 0;
      j = 0;
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendLimitChatMatchFragment", 2, "onUpdateSignalBombPush " + paramBoolean + " " + paramString);
    }
    if ((ExtendFriendLimitChatMatchFragment.a(this.a) == 1) && (ExtendFriendLimitChatMatchFragment.a(this.a) != null) && (ExtendFriendLimitChatMatchFragment.a(this.a).isResume()) && (ExtendFriendLimitChatMatchFragment.a(this.a).a() != 2) && (!ExtendFriendLimitChatMatchFragment.a(this.a))) {
      ExtendFriendLimitChatMatchFragment.a(this.a, arno.a(ExtendFriendLimitChatMatchFragment.a(this.a), ExtendFriendLimitChatMatchFragment.a(this.a).app, ExtendFriendLimitChatMatchFragment.a(this.a)));
    }
  }
  
  protected void a(boolean paramBoolean1, ArrayList<arjn> paramArrayList, boolean paramBoolean2, int paramInt, ArrayList<String> paramArrayList1, boolean paramBoolean3)
  {
    paramBoolean2 = false;
    if (QLog.isColorLevel()) {
      QLog.i("ExtendFriendLimitChatMatchFragment", 2, "onGetUnLimitBaseInfo suc:" + paramBoolean1);
    }
    if (paramBoolean1)
    {
      if (paramInt > 0) {
        break label130;
      }
      QLog.e("ExtendFriendLimitChatMatchFragment", 2, "onlineCount  wrong");
      if ((paramArrayList1 != null) && (paramArrayList1.size() > 0))
      {
        if (this.a.jdField_a_of_type_Arqt == null) {
          break label197;
        }
        this.a.jdField_a_of_type_Arqt.a(paramArrayList1);
      }
      label85:
      if ((ExtendFriendLimitChatMatchFragment.a(this.a) != null) && (!ExtendFriendLimitChatMatchFragment.a(this.a).isFinishing()) && (ExtendFriendLimitChatMatchFragment.a(this.a).app != null)) {
        break label208;
      }
      QLog.e("ExtendFriendLimitChatMatchFragment", 2, "mActivity finish ");
    }
    label130:
    label197:
    label208:
    do
    {
      return;
      Object localObject = paramInt + BaseApplication.getContext().getResources().getString(2131698217);
      if (ExtendFriendLimitChatMatchFragment.a(this.a) != null)
      {
        ExtendFriendLimitChatMatchFragment.a(this.a).setText((CharSequence)localObject);
        break;
      }
      QLog.e("ExtendFriendLimitChatMatchFragment", 2, "mMatchCountTxt is null");
      break;
      QLog.e("ExtendFriendLimitChatMatchFragment", 2, "mHeadsPanleView is null");
      break label85;
      paramArrayList1 = (arhi)ExtendFriendLimitChatMatchFragment.a(this.a).app.getManager(264);
      if ((paramArrayList1 != null) && (paramArrayList1.i()))
      {
        ExtendFriendLimitChatMatchFragment.a(this.a).setVisibility(0);
        QLog.d("ExtendFriendLimitChatMatchFragment", 2, "signalBtn VISIBLE with controlbit");
        if (!paramBoolean3) {
          break label459;
        }
        if (paramArrayList1 != null)
        {
          if (paramArrayList1.i()) {
            break label423;
          }
          ExtendFriendLimitChatMatchFragment.b(this.a, true);
          QLog.e("ExtendFriendLimitChatMatchFragment", 2, "bSignalBombOpen FALSE BUG signaflag open NEED PB CLOSE");
        }
      }
      for (;;)
      {
        if ((paramArrayList == null) || (paramArrayList.size() <= 0) || (ExtendFriendLimitChatMatchFragment.a(this.a) == null)) {
          break label598;
        }
        paramInt = 0;
        while (paramInt < paramArrayList.size())
        {
          localObject = (arjn)paramArrayList.get(paramInt);
          if (!TextUtils.isEmpty(((arjn)localObject).jdField_a_of_type_JavaLangString)) {
            ExtendFriendLimitChatMatchFragment.a(this.a, ExtendFriendLimitChatMatchFragment.a(this.a) + ((arjn)localObject).jdField_a_of_type_JavaLangString + ";");
          }
          paramInt += 1;
        }
        ExtendFriendLimitChatMatchFragment.a(this.a).setVisibility(8);
        QLog.d("ExtendFriendLimitChatMatchFragment", 2, "signalBtn GONE with controlbit");
        break;
        if (!arno.a())
        {
          ExtendFriendLimitChatMatchFragment.b(this.a, true);
          ExtendFriendLimitChatMatchFragment.e(this.a);
        }
        else
        {
          ExtendFriendLimitChatMatchFragment.a(this.a, true, true);
          continue;
          ExtendFriendLimitChatMatchFragment.a(this.a, false, true);
        }
      }
      paramBoolean1 = paramBoolean2;
      if (paramArrayList1 != null) {
        paramBoolean1 = paramArrayList1.h();
      }
      paramInt = paramArrayList.size() - 1;
      while (paramInt >= 0)
      {
        if ((((arjn)paramArrayList.get(paramInt)).jdField_a_of_type_Int == 10000) && (!paramBoolean1))
        {
          QLog.e("ExtendFriendLimitChatMatchFragment", 2, "MATCH_CHAT_TAG_ID_FOR_VOICE_MATCH REMOVE by flag");
          paramArrayList.remove(paramInt);
        }
        paramInt -= 1;
      }
      paramArrayList1 = new arrp();
      paramArrayList1.a(paramArrayList);
      if (paramArrayList.size() <= 0) {
        break label588;
      }
    } while (ExtendFriendLimitChatMatchFragment.a(this.a) == null);
    label423:
    label459:
    ExtendFriendLimitChatMatchFragment.a(this.a).setAdapter(paramArrayList1);
    return;
    label588:
    QLog.e("ExtendFriendLimitChatMatchFragment", 2, "TaginfoInfo size 0");
    return;
    label598:
    QLog.e("ExtendFriendLimitChatMatchFragment", 2, "TagInfo size 0");
  }
  
  protected void l_(int paramInt)
  {
    avod.a(this.a.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch, ExtendFriendLimitChatMatchFragment.a(this.a).app);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     armu
 * JD-Core Version:    0.7.0.1
 */