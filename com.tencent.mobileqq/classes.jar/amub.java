import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatManager.HotChatStateWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.nearby.gift.TroopGiftPanelForNearby;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.hotchat.Common.WifiPOIInfo;

public class amub
  extends amua
{
  private final ahgz a;
  
  public amub(ahgz paramahgz)
  {
    this.a = paramahgz;
  }
  
  public void a(String paramString, HotChatManager.HotChatStateWrapper paramHotChatStateWrapper)
  {
    if (QLog.isColorLevel()) {
      awkj.a(this.a.tag, new Object[] { "onPushExitHotChat", paramString, paramHotChatStateWrapper });
    }
    if (!bftf.a(this.a.sessionInfo.curFriendUin, paramString)) {
      return;
    }
    int i = paramHotChatStateWrapper.targetState;
    amuc.a(this.a.app, this.a.sessionInfo.curFriendUin, i);
    amuc.a(this.a.app);
  }
  
  public void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.a.tag, 2, "TroopChatPie.onExitHotChat  troopUin=" + paramString1);
    }
    if ((paramBoolean) && (this.a.sessionInfo.curFriendUin.equals(paramString1)))
    {
      if (this.a.getActivity().getIntent().getBooleanExtra("is_from_web", false)) {
        this.a.getActivity().sendBroadcast(new Intent("com.tencent.mobileqq.refresh_hot_chat_list"));
      }
      amuc.a(this.a.app, this.a.sessionInfo.curFriendUin, 4);
      amuc.a(this.a.app);
      paramString1 = this.a.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a(this.a.sessionInfo.curFriendUin);
      this.a.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a(paramString1, HotChatManager.HotChatStateWrapper.STATE_LEFT_NORMAL_ACTION_DELETE_SHELL);
      this.a.finish(1);
    }
  }
  
  public void a(boolean paramBoolean, HotChatInfo paramHotChatInfo, Common.WifiPOIInfo paramWifiPOIInfo, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      awkj.a(this.a.tag, new Object[] { "onQuickJoinHotChat", Boolean.valueOf(paramBoolean), paramString, paramHotChatInfo });
    }
    if (!paramBoolean) {
      if ((bftf.a(this.a.e, paramString)) || ((this.a.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (bftf.a(this.a.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.uuid, paramString))))
      {
        paramHotChatInfo = awhn.a(paramInt);
        QQToast.a(this.a.mActivity, 1, paramHotChatInfo, 1).a();
      }
    }
    while ((!bftf.a(this.a.e, paramString)) || (paramHotChatInfo == null) || (bftf.a(paramHotChatInfo.troopUin, this.a.sessionInfo.curFriendUin))) {
      return;
    }
    if (QLog.isColorLevel()) {
      awkj.a(this.a.tag, new Object[] { "onQuickJoinHotChat_not_same_aio", String.format("uuid:%s, new:%s, old:%s", new Object[] { paramString, paramHotChatInfo.troopUin, this.a.sessionInfo.curFriendUin }) });
    }
    MediaPlayerManager.a(this.a.app).a(false);
    paramWifiPOIInfo = new Intent(this.a.mActivity, SplashActivity.class);
    paramWifiPOIInfo.putExtra("uin", paramHotChatInfo.troopUin);
    paramWifiPOIInfo.putExtra("uintype", 1);
    paramWifiPOIInfo.putExtra("troop_uin", paramHotChatInfo.troopCode);
    paramWifiPOIInfo.putExtra("uinname", paramHotChatInfo.name);
    paramWifiPOIInfo.addFlags(67108864);
    paramWifiPOIInfo.putExtra("hotnamecode", paramHotChatInfo.uuid);
    if (paramHotChatInfo.supportDemo) {}
    for (paramInt = 2;; paramInt = 0)
    {
      paramWifiPOIInfo.putExtra("HOTCHAT_EXTRA_FLAG", paramInt);
      paramHotChatInfo = AIOUtils.setOpenAIOIntent(paramWifiPOIInfo, new int[] { 2 });
      paramHotChatInfo.setAction("com.tencent.mobileqq.action.MAINACTIVITY");
      this.a.mActivity.startActivity(paramHotChatInfo);
      if (!(this.a.mActivity instanceof ChatActivity)) {
        break;
      }
      this.a.mActivity.finish();
      return;
    }
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((paramBoolean) && (paramInt == 0))
    {
      paramString = this.a.app.getHotChatMng(true);
      this.a.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo = paramString.a(this.a.sessionInfo.curFriendUin);
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2, Long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.tag, 2, "onGetUserCreateHotChatAnnounce  isSuccess= " + paramBoolean + ", result=" + paramInt + ", memo=" + paramString2 + ", troopOwner=" + paramLong);
    }
    long l2 = 100L;
    long l1 = l2;
    if (paramBoolean)
    {
      l1 = l2;
      if (paramInt == 0)
      {
        l1 = l2;
        if (this.a.a(paramString1, paramString2, null)) {
          l1 = 30000L;
        }
      }
    }
    if (this.a.jdField_a_of_type_Amuf != null) {
      this.a.jdField_a_of_type_Amuf.b(l1);
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    this.a.a(paramBoolean, paramString1, paramInt, paramString2, paramString3, "Q.hotchat.hotchat_kick_mem_by_admin");
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((paramBoolean) && (paramString1 != null) && (paramString1.equals(this.a.sessionInfo.curFriendUin)))
    {
      if (!TextUtils.isEmpty(paramString2))
      {
        this.a.a().a(paramString2, paramString2);
        return;
      }
      paramString2 = this.a.sessionInfo.curFriendUin;
      if ((this.a.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isBuLuoHotChat())) {}
      for (paramString1 = "507";; paramString1 = "503")
      {
        amxb.a("gift_store", "cancel_list", paramString2, paramString1, "", "");
        return;
      }
    }
    paramString2 = this.a.sessionInfo.curFriendUin;
    if ((this.a.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isBuLuoHotChat())) {}
    for (paramString1 = "507";; paramString1 = "503")
    {
      amxb.a("gift_store", "cancel_list", paramString2, paramString1, "", "");
      return;
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    if ((paramBoolean) && (paramString1 != null) && (paramString1.equals(this.a.sessionInfo.curFriendUin))) {
      this.a.a(paramString2, paramString3, true, 4);
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, byte[] paramArrayOfByte, int paramInt, String paramString2, String paramString3, List<Long> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.tag, 2, "onGetHotChatAnnounce  isSuccess= " + paramBoolean + ", result=" + paramInt + ", memo=" + paramString2 + ", jumpurl=" + paramString3);
    }
    long l2 = 100L;
    long l1 = l2;
    if (paramBoolean)
    {
      l1 = l2;
      if (paramInt == 0)
      {
        l1 = l2;
        if (this.a.a(paramString1, paramString2, paramString3)) {
          l1 = 30000L;
        }
      }
    }
    if (this.a.jdField_a_of_type_Amuf != null) {
      this.a.jdField_a_of_type_Amuf.b(l1);
    }
  }
  
  public void b(boolean paramBoolean, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    this.a.a(paramBoolean, paramString1, paramInt, paramString2, paramString3, "Q.hotchat.hotchat_kick_mem_by_global_admin");
  }
  
  public void b(boolean paramBoolean, String paramString1, String paramString2)
  {
    awhn.a(this.a.getActivity(), this.a.app, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amub
 * JD-Core Version:    0.7.0.1
 */