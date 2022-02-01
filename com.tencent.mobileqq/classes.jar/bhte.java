import KQQ.ProfSmpInfoRes;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatManager.HotChatStateWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.DateNickNameInfo;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.MobileQQ;
import tencent.im.oidb.cmd0x857.TroopTips0x857.WereWolfPush;
import tencent.im.oidb.cmd0x8e4.oidb_0x8e4.ReqBody;
import tencent.im.oidb.cmd0x8e4.oidb_0x8e4.RspBody;
import tencent.im.oidb.cmd0x8ed.oidb_0x8ed.ReqBody;
import tencent.im.oidb.cmd0x8ed.oidb_0x8ed.RspBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xdd.submsgtype0xdd.MsgBody;

public class bhte
  extends anii
{
  protected static HashMap<String, WeakReference<TextView>> a;
  protected BroadcastReceiver a;
  protected LruCache<String, String> a;
  protected bhtm a;
  bhtu a;
  public String a;
  public boolean a;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public bhte(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(100);
    this.jdField_a_of_type_Bhtm = new bhtm();
    this.jdField_a_of_type_Bhtu = null;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new bhtk(this);
    this.jdField_a_of_type_JavaLangString = paramQQAppInterface.getApp().getSharedPreferences("werewolves_sp", 0).getString("judgeUin", "");
    IntentFilter localIntentFilter = new IntentFilter("tencent.video.v2q.memberSpeaking");
    paramQQAppInterface.getApplication().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  public bhtu a(String paramString)
  {
    if (this.jdField_a_of_type_Bhtu == null) {
      this.jdField_a_of_type_Bhtu = new bhtu(paramString);
    }
    if (!TextUtils.isEmpty(paramString)) {
      this.jdField_a_of_type_Bhtu.jdField_a_of_type_JavaLangString = paramString;
    }
    return this.jdField_a_of_type_Bhtu;
  }
  
  protected niv a(bhtl<oidb_0x8e4.RspBody> parambhtl)
  {
    return new bhti(this, parambhtl);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bhtu = null;
  }
  
  public void a(int paramInt1, int paramInt2, bhtl<oidb_0x8e4.RspBody> parambhtl)
  {
    oidb_0x8e4.ReqBody localReqBody = new oidb_0x8e4.ReqBody();
    localReqBody.uint32_max_member_num.set(paramInt1, true);
    localReqBody.uint32_zone_id.set(paramInt2);
    nir.a(this.app, a(parambhtl), localReqBody.toByteArray(), "OidbSvc.0x8e4_1", 2276, 1, new Bundle(), 5000L);
  }
  
  public void a(TextView paramTextView, String paramString1, String paramString2)
  {
    if (this.app.getCurrentAccountUin().equals(paramString1)) {}
    do
    {
      try
      {
        paramTextView.setText(String.format(paramString2, new Object[] { this.app.getCurrentNickname() }));
        return;
      }
      catch (Exception paramString1)
      {
        paramTextView.setText(this.app.getCurrentNickname());
        return;
      }
      Object localObject = (anmw)this.app.getManager(51);
      if (((anmw)localObject).b(paramString1))
      {
        paramString1 = bglf.j(this.app, paramString1);
        try
        {
          paramTextView.setText(String.format(paramString2, new Object[] { paramString1 }));
          return;
        }
        catch (Exception paramString2)
        {
          paramTextView.setText(paramString1);
          return;
        }
      }
      localObject = ((anmw)localObject).a(paramString1);
      if ((localObject != null) && (((DateNickNameInfo)localObject).nickName != null) && (!((DateNickNameInfo)localObject).nickName.equals(paramString1))) {
        try
        {
          paramTextView.setText(String.format(paramString2, new Object[] { ((DateNickNameInfo)localObject).nickName }));
          return;
        }
        catch (Exception paramString1)
        {
          paramTextView.setText(((DateNickNameInfo)localObject).nickName);
          return;
        }
      }
      paramTextView.setText(paramString1);
      paramTextView.setTag(new String[] { paramString1, paramString2 });
      if (jdField_a_of_type_JavaUtilHashMap.containsKey(paramString1))
      {
        jdField_a_of_type_JavaUtilHashMap.remove(paramString1);
        jdField_a_of_type_JavaUtilHashMap.put(paramString1, new WeakReference(paramTextView));
        return;
      }
      jdField_a_of_type_JavaUtilHashMap.put(paramString1, new WeakReference(paramTextView));
      paramTextView = createToServiceMsg("ProfileService.GetSimpleInfo");
      paramString2 = new ArrayList();
      paramString2.add(paramString1);
      paramTextView.extraData.putStringArrayList("uinList", paramString2);
      paramTextView.extraData.putBoolean("reqDateNick", true);
      send(paramTextView);
    } while (!QLog.isColorLevel());
    QLog.d("WerewolvesHandler", 2, "WerewolvesHandler: setNickname->sendToServiceMsg, uin = " + paramString1);
  }
  
  public void a(bhtl<oidb_0x8e4.RspBody> parambhtl)
  {
    if (QLog.isColorLevel()) {
      QLog.e("WerewolvesHandler", 2, "reqInviteId");
    }
    oidb_0x8e4.ReqBody localReqBody = new oidb_0x8e4.ReqBody();
    nir.a(this.app, a(parambhtl), localReqBody.toByteArray(), "OidbSvc.0x8e4_6", 2276, 6, new Bundle(), 5000L);
  }
  
  public void a(HotChatInfo paramHotChatInfo)
  {
    try
    {
      long l = Long.parseLong(paramHotChatInfo.troopUin);
      axey.a().a(l);
      axdz.a(this.app.getCurrentAccountUin(), "game_room_last_time", Long.valueOf(bbyp.a()));
      if ((paramHotChatInfo.troopUin != null) && (!paramHotChatInfo.troopUin.equals("0"))) {
        this.app.a().a(paramHotChatInfo.troopUin, 1);
      }
      if (this.jdField_a_of_type_Bhtu != null) {
        this.jdField_a_of_type_Bhtu.b();
      }
      HotChatManager localHotChatManager = (HotChatManager)this.app.getManager(60);
      List localList = localHotChatManager.a();
      if (localList != null) {
        localList.remove(paramHotChatInfo);
      }
      localHotChatManager.a(paramHotChatInfo, HotChatManager.HotChatStateWrapper.STATE_HOT_CHAT_IS_DISBANDED);
      return;
    }
    catch (Exception paramHotChatInfo)
    {
      paramHotChatInfo.printStackTrace();
    }
  }
  
  public void a(HotChatInfo paramHotChatInfo, int paramInt1, int paramInt2, bhtl<oidb_0x8e4.RspBody> parambhtl)
  {
    if (QLog.isColorLevel()) {
      QLog.e("WerewolvesHandler", 2, "exitRoom");
    }
    oidb_0x8ed.ReqBody localReqBody = new oidb_0x8ed.ReqBody();
    bhtg localbhtg = new bhtg(this, parambhtl);
    try
    {
      long l = Long.parseLong(paramHotChatInfo.troopUin);
      localReqBody.uint64_room_id.set(l, true);
      localReqBody.rpt_uint64_uins.add(Long.valueOf(this.app.getLongAccountUin()));
      nir.a(this.app, b(new bhth(this, localbhtg, paramHotChatInfo, l, paramInt2, paramInt1, parambhtl)), localReqBody.toByteArray(), "OidbSvc.0x8ed_2", 2285, 2, new Bundle(), 5000L);
      return;
    }
    catch (Exception paramHotChatInfo)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("WerewolvesHandler", 2, "hotChatInfo.troopUin is wrong");
    }
  }
  
  public void a(HotChatInfo paramHotChatInfo, bhtl<oidb_0x8ed.RspBody> parambhtl)
  {
    if (QLog.isColorLevel()) {
      QLog.e("WerewolvesHandler", 2, "exitRoom");
    }
    oidb_0x8ed.ReqBody localReqBody = new oidb_0x8ed.ReqBody();
    try
    {
      long l = Long.parseLong(paramHotChatInfo.troopUin);
      localReqBody.uint64_room_id.set(l, true);
      localReqBody.rpt_uint64_uins.add(Long.valueOf(this.app.getLongAccountUin()));
      nir.a(this.app, b(new bhtf(this, parambhtl, paramHotChatInfo)), localReqBody.toByteArray(), "OidbSvc.0x8ed_2", 2285, 2, new Bundle(), 5000L);
      axey.a().a(l);
      axdz.a(this.app.getCurrentAccountUin(), "game_room_last_time", Long.valueOf(bbyp.a()));
      try
      {
        if ((paramHotChatInfo.troopUin != null) && (!paramHotChatInfo.troopUin.equals("0"))) {
          this.app.a().a(paramHotChatInfo.troopUin, 1);
        }
        if (this.jdField_a_of_type_Bhtu != null)
        {
          this.jdField_a_of_type_Bhtu.b();
          return;
        }
      }
      catch (Exception paramHotChatInfo)
      {
        for (;;)
        {
          paramHotChatInfo.printStackTrace();
        }
      }
      return;
    }
    catch (Exception paramHotChatInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.e("WerewolvesHandler", 2, "hotChatInfo.troopUin is wrong");
      }
    }
  }
  
  public void a(String paramString, long paramLong, bhtl<oidb_0x8e4.RspBody> parambhtl)
  {
    if (QLog.isColorLevel()) {
      QLog.e("WerewolvesHandler", 2, "kickInviteUser");
    }
    oidb_0x8e4.ReqBody localReqBody = new oidb_0x8e4.ReqBody();
    localReqBody.string_invite_id.set(ByteStringMicro.copyFromUtf8(paramString), true);
    localReqBody.uint64_kick_uin.set(paramLong, true);
    nir.a(this.app, a(parambhtl), localReqBody.toByteArray(), "OidbSvc.0x8e4_5", 2276, 5, new Bundle(), 5000L);
  }
  
  public void a(String paramString, bhtl<oidb_0x8e4.RspBody> parambhtl)
  {
    oidb_0x8e4.ReqBody localReqBody = new oidb_0x8e4.ReqBody();
    localReqBody.string_invite_id.set(ByteStringMicro.copyFromUtf8(paramString), true);
    nir.a(this.app, a(parambhtl), localReqBody.toByteArray(), "OidbSvc.0x8e4_3", 2276, 3, new Bundle(), 5000L);
  }
  
  public void a(String paramString, boolean paramBoolean, bhtl<oidb_0x8e4.RspBody> parambhtl)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("WerewolvesHandler", 2, "acceptInvite failed, invitedId null; isAccept = " + paramBoolean);
      return;
    }
    oidb_0x8e4.ReqBody localReqBody = new oidb_0x8e4.ReqBody();
    localReqBody.string_invite_id.set(ByteStringMicro.copyFromUtf8(paramString), true);
    paramString = localReqBody.uint32_accept_invite;
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      paramString.set(i, true);
      localReqBody.uint32_ready_state.set(2);
      nir.a(this.app, a(parambhtl), localReqBody.toByteArray(), "OidbSvc.0x8e4_2", 2276, 2, new Bundle(), 5000L);
      return;
    }
  }
  
  public void a(TroopTips0x857.WereWolfPush paramWereWolfPush, byte[] paramArrayOfByte)
  {
    if (paramWereWolfPush == null) {}
    String str2;
    long l;
    String str1;
    do
    {
      do
      {
        return;
        if ((!paramWereWolfPush.uint64_game_room.has()) || (!paramWereWolfPush.bytes_judge_words.has()) || (!paramWereWolfPush.uint64_judge_uin.has())) {
          break label505;
        }
        str2 = paramWereWolfPush.uint64_game_room.get() + "";
        l = bbyp.a();
        str1 = paramWereWolfPush.bytes_judge_words.get().toStringUtf8();
        if (!TextUtils.isEmpty(str1)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.werewolf.WereWolfPush", 2, "uint64_game_room:" + str2 + ", msg is empty");
      return;
      localObject = this.app.a(false);
    } while (localObject == null);
    Object localObject = ((HotChatManager)localObject).a(str2);
    if ((localObject == null) || (!((HotChatInfo)localObject).isGameRoom))
    {
      ((anno)this.app.a(35)).a(2);
      return;
    }
    localObject = this.app.a().a(str2, 1);
    MessageRecord localMessageRecord = bbzh.a(-1000);
    localMessageRecord.init(this.app.getCurrentAccountUin(), str2, this.app.getCurrentAccountUin(), str1, l, -1000, 1, l);
    if (localObject != null) {
      localMessageRecord.shmsgseq = ((QQMessageFacade.Message)localObject).shmsgseq;
    }
    localMessageRecord.senderuin = (paramWereWolfPush.uint64_judge_uin.get() + "");
    this.jdField_a_of_type_JavaLangString = localMessageRecord.senderuin;
    localObject = "";
    if (paramWereWolfPush.bytes_judge_nickname.has())
    {
      localObject = paramWereWolfPush.bytes_judge_nickname.get().toStringUtf8();
      ((TroopManager)this.app.getManager(52)).a(str2, paramWereWolfPush.uint64_judge_uin.get() + "", (String)localObject, 0, null, null, 0, 0, 0, 0L, (byte)0, 0L, 0.0D);
    }
    localMessageRecord.isread = true;
    localMessageRecord.issend = 0;
    localMessageRecord.saveExtInfoToExtStr("isJudgeMsg", "true");
    this.app.a().a(localMessageRecord, this.app.getCurrentAccountUin());
    paramWereWolfPush = this.app.a().a();
    paramWereWolfPush.delRecentUser((RecentUser)paramWereWolfPush.findRecentUserByUin(str2, 1));
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("uint64_game_room:").append(str2).append("|judge_nickname:").append((String)localObject).append("|msg:");
      if (!TextUtils.isEmpty(str1)) {
        break label524;
      }
    }
    label524:
    for (paramWereWolfPush = "";; paramWereWolfPush = str1.substring(0, 1) + "***" + str1.substring(str1.length() - 1) + "|msg len:" + str1.length())
    {
      QLog.d("Q.werewolf.WereWolfPush", 2, paramWereWolfPush);
      label505:
      if (this.jdField_a_of_type_Bhtu == null) {
        break;
      }
      this.jdField_a_of_type_Bhtu.a("WereWolfPush", paramArrayOfByte);
      return;
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    submsgtype0xdd.MsgBody localMsgBody = new submsgtype0xdd.MsgBody();
    try
    {
      localMsgBody.mergeFrom(paramArrayOfByte);
      notifyUI(1, true, localMsgBody);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("WerewolvesHandler", 2, QLog.getStackTraceString(paramArrayOfByte));
    }
  }
  
  protected niv b(bhtl<oidb_0x8ed.RspBody> parambhtl)
  {
    return new bhtj(this, parambhtl);
  }
  
  public void b(int paramInt1, int paramInt2, bhtl<oidb_0x8e4.RspBody> parambhtl)
  {
    if (QLog.isColorLevel()) {
      QLog.e("WerewolvesHandler", 2, "quickStartGame");
    }
    oidb_0x8e4.ReqBody localReqBody = new oidb_0x8e4.ReqBody();
    localReqBody.uint32_play_way.set(1, true);
    localReqBody.uint32_max_member_num.set(paramInt1);
    localReqBody.uint32_zone_id.set(paramInt2);
    nir.a(this.app, a(parambhtl), localReqBody.toByteArray(), "OidbSvc.0x8e4_4", 2276, 4, new Bundle(), 5000L);
  }
  
  public void b(String paramString, bhtl<oidb_0x8e4.RspBody> parambhtl)
  {
    if (QLog.isColorLevel()) {
      QLog.e("WerewolvesHandler", 2, "startGame");
    }
    oidb_0x8e4.ReqBody localReqBody = new oidb_0x8e4.ReqBody();
    localReqBody.string_invite_id.set(ByteStringMicro.copyFromUtf8(paramString), true);
    localReqBody.uint32_play_way.set(2, true);
    nir.a(this.app, a(parambhtl), localReqBody.toByteArray(), "OidbSvc.0x8e4_4", 2276, 4, new Bundle(), 5000L);
  }
  
  public void b(String paramString, boolean paramBoolean, bhtl<oidb_0x8e4.RspBody> parambhtl)
  {
    oidb_0x8e4.ReqBody localReqBody = new oidb_0x8e4.ReqBody();
    localReqBody.string_invite_id.set(ByteStringMicro.copyFromUtf8(paramString));
    paramString = localReqBody.uint32_ready_state;
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      paramString.set(i);
      nir.a(this.app, a(parambhtl), localReqBody.toByteArray(), "OidbSvc.0x8e4_7", 2276, 7, new Bundle(), 5000L);
      return;
    }
  }
  
  protected Class<? extends anil> observerClass()
  {
    return bhts.class;
  }
  
  public void onDestroy()
  {
    axey localaxey = axey.a();
    this.app.getApplication().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    localaxey.d();
    localaxey.a();
    if (this.jdField_a_of_type_Bhtu != null) {
      this.jdField_a_of_type_Bhtu.b();
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.app.getApp().getSharedPreferences("werewolves_sp", 0).edit().putString("judgeUin", this.jdField_a_of_type_JavaLangString).commit();
    }
    this.jdField_a_of_type_Bhtm.removeCallbacksAndMessages(null);
    super.onDestroy();
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = paramFromServiceMsg.getServiceCmd();
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.protocol", 2, "WereWolevsHandler onReceive. cmd=" + (String)localObject);
    }
    if ("ProfileService.GetSimpleInfo".equals(localObject))
    {
      paramToServiceMsg = paramToServiceMsg.extraData.getStringArrayList("uinList");
      if (paramFromServiceMsg.isSuccess())
      {
        localObject = (ArrayList)paramObject;
        if ((localObject != null) && (paramToServiceMsg != null) && (((ArrayList)localObject).size() > 0) && (paramToServiceMsg.size() > 0))
        {
          paramObject = (String)paramToServiceMsg.get(0);
          paramFromServiceMsg = ((ProfSmpInfoRes)((ArrayList)localObject).get(0)).sDateNick;
          paramToServiceMsg = paramFromServiceMsg;
          if (TextUtils.isEmpty(paramFromServiceMsg)) {
            paramToServiceMsg = ((ProfSmpInfoRes)((ArrayList)localObject).get(0)).strNick;
          }
          paramFromServiceMsg = new Message();
          paramFromServiceMsg.obj = new String[] { paramObject, paramToServiceMsg };
          this.jdField_a_of_type_Bhtm.sendMessage(paramFromServiceMsg);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhte
 * JD-Core Version:    0.7.0.1
 */