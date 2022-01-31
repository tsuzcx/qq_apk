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
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatManager.HotChatStateWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.DateNickNameInfo;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageRecord;
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

public class bcic
  extends ajtd
{
  protected static HashMap<String, WeakReference<TextView>> a;
  protected BroadcastReceiver a;
  protected LruCache<String, String> a;
  protected bcik a;
  bcis a;
  public String a;
  public boolean a;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public bcic(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(100);
    this.jdField_a_of_type_Bcik = new bcik();
    this.jdField_a_of_type_Bcis = null;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new bcii(this);
    this.jdField_a_of_type_JavaLangString = paramQQAppInterface.getApp().getSharedPreferences("werewolves_sp", 0).getString("judgeUin", "");
    IntentFilter localIntentFilter = new IntentFilter("tencent.video.v2q.memberSpeaking");
    paramQQAppInterface.getApplication().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  public bcis a(String paramString)
  {
    if (this.jdField_a_of_type_Bcis == null) {
      this.jdField_a_of_type_Bcis = new bcis(paramString);
    }
    if (!TextUtils.isEmpty(paramString)) {
      this.jdField_a_of_type_Bcis.jdField_a_of_type_JavaLangString = paramString;
    }
    return this.jdField_a_of_type_Bcis;
  }
  
  protected mxm a(bcij<oidb_0x8e4.RspBody> parambcij)
  {
    return new bcig(this, parambcij);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bcis = null;
  }
  
  public void a(int paramInt1, int paramInt2, bcij<oidb_0x8e4.RspBody> parambcij)
  {
    oidb_0x8e4.ReqBody localReqBody = new oidb_0x8e4.ReqBody();
    localReqBody.uint32_max_member_num.set(paramInt1, true);
    localReqBody.uint32_zone_id.set(paramInt2);
    mxi.a(this.app, a(parambcij), localReqBody.toByteArray(), "OidbSvc.0x8e4_1", 2276, 1, new Bundle(), 5000L);
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
      Object localObject = (ajxn)this.app.getManager(51);
      if (((ajxn)localObject).b(paramString1))
      {
        paramString1 = bbcl.j(this.app, paramString1);
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
      localObject = ((ajxn)localObject).a(paramString1);
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
  
  public void a(bcij<oidb_0x8e4.RspBody> parambcij)
  {
    if (QLog.isColorLevel()) {
      QLog.e("WerewolvesHandler", 2, "reqInviteId");
    }
    oidb_0x8e4.ReqBody localReqBody = new oidb_0x8e4.ReqBody();
    mxi.a(this.app, a(parambcij), localReqBody.toByteArray(), "OidbSvc.0x8e4_6", 2276, 6, new Bundle(), 5000L);
  }
  
  public void a(HotChatInfo paramHotChatInfo)
  {
    try
    {
      long l = Long.parseLong(paramHotChatInfo.troopUin);
      atcf.a().a(l);
      atbg.a(this.app.getCurrentAccountUin(), "game_room_last_time", Long.valueOf(awzw.a()));
      if ((paramHotChatInfo.troopUin != null) && (!paramHotChatInfo.troopUin.equals("0"))) {
        this.app.a().a(paramHotChatInfo.troopUin, 1);
      }
      if (this.jdField_a_of_type_Bcis != null) {
        this.jdField_a_of_type_Bcis.b();
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
  
  public void a(HotChatInfo paramHotChatInfo, int paramInt1, int paramInt2, bcij<oidb_0x8e4.RspBody> parambcij)
  {
    if (QLog.isColorLevel()) {
      QLog.e("WerewolvesHandler", 2, "exitRoom");
    }
    oidb_0x8ed.ReqBody localReqBody = new oidb_0x8ed.ReqBody();
    bcie localbcie = new bcie(this, parambcij);
    try
    {
      long l = Long.parseLong(paramHotChatInfo.troopUin);
      localReqBody.uint64_room_id.set(l, true);
      localReqBody.rpt_uint64_uins.add(Long.valueOf(this.app.getLongAccountUin()));
      mxi.a(this.app, b(new bcif(this, localbcie, paramHotChatInfo, l, paramInt2, paramInt1, parambcij)), localReqBody.toByteArray(), "OidbSvc.0x8ed_2", 2285, 2, new Bundle(), 5000L);
      return;
    }
    catch (Exception paramHotChatInfo)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("WerewolvesHandler", 2, "hotChatInfo.troopUin is wrong");
    }
  }
  
  public void a(HotChatInfo paramHotChatInfo, bcij<oidb_0x8ed.RspBody> parambcij)
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
      mxi.a(this.app, b(new bcid(this, parambcij, paramHotChatInfo)), localReqBody.toByteArray(), "OidbSvc.0x8ed_2", 2285, 2, new Bundle(), 5000L);
      atcf.a().a(l);
      atbg.a(this.app.getCurrentAccountUin(), "game_room_last_time", Long.valueOf(awzw.a()));
      try
      {
        if ((paramHotChatInfo.troopUin != null) && (!paramHotChatInfo.troopUin.equals("0"))) {
          this.app.a().a(paramHotChatInfo.troopUin, 1);
        }
        if (this.jdField_a_of_type_Bcis != null)
        {
          this.jdField_a_of_type_Bcis.b();
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
  
  public void a(String paramString, long paramLong, bcij<oidb_0x8e4.RspBody> parambcij)
  {
    if (QLog.isColorLevel()) {
      QLog.e("WerewolvesHandler", 2, "kickInviteUser");
    }
    oidb_0x8e4.ReqBody localReqBody = new oidb_0x8e4.ReqBody();
    localReqBody.string_invite_id.set(ByteStringMicro.copyFromUtf8(paramString), true);
    localReqBody.uint64_kick_uin.set(paramLong, true);
    mxi.a(this.app, a(parambcij), localReqBody.toByteArray(), "OidbSvc.0x8e4_5", 2276, 5, new Bundle(), 5000L);
  }
  
  public void a(String paramString, bcij<oidb_0x8e4.RspBody> parambcij)
  {
    oidb_0x8e4.ReqBody localReqBody = new oidb_0x8e4.ReqBody();
    localReqBody.string_invite_id.set(ByteStringMicro.copyFromUtf8(paramString), true);
    mxi.a(this.app, a(parambcij), localReqBody.toByteArray(), "OidbSvc.0x8e4_3", 2276, 3, new Bundle(), 5000L);
  }
  
  public void a(String paramString, boolean paramBoolean, bcij<oidb_0x8e4.RspBody> parambcij)
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
      mxi.a(this.app, a(parambcij), localReqBody.toByteArray(), "OidbSvc.0x8e4_2", 2276, 2, new Bundle(), 5000L);
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
          break label502;
        }
        str2 = paramWereWolfPush.uint64_game_room.get() + "";
        l = awzw.a();
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
      ((ajyi)this.app.a(35)).a(2);
      return;
    }
    localObject = this.app.a().a(str2, 1);
    MessageRecord localMessageRecord = axaq.a(-1000);
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
    paramWereWolfPush.b(paramWereWolfPush.a(str2, 1));
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("uint64_game_room:").append(str2).append("|judge_nickname:").append((String)localObject).append("|msg:");
      if (!TextUtils.isEmpty(str1)) {
        break label521;
      }
    }
    label521:
    for (paramWereWolfPush = "";; paramWereWolfPush = str1.substring(0, 1) + "***" + str1.substring(str1.length() - 1) + "|msg len:" + str1.length())
    {
      QLog.d("Q.werewolf.WereWolfPush", 2, paramWereWolfPush);
      label502:
      if (this.jdField_a_of_type_Bcis == null) {
        break;
      }
      this.jdField_a_of_type_Bcis.a("WereWolfPush", paramArrayOfByte);
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
  
  protected mxm b(bcij<oidb_0x8ed.RspBody> parambcij)
  {
    return new bcih(this, parambcij);
  }
  
  public void b(int paramInt1, int paramInt2, bcij<oidb_0x8e4.RspBody> parambcij)
  {
    if (QLog.isColorLevel()) {
      QLog.e("WerewolvesHandler", 2, "quickStartGame");
    }
    oidb_0x8e4.ReqBody localReqBody = new oidb_0x8e4.ReqBody();
    localReqBody.uint32_play_way.set(1, true);
    localReqBody.uint32_max_member_num.set(paramInt1);
    localReqBody.uint32_zone_id.set(paramInt2);
    mxi.a(this.app, a(parambcij), localReqBody.toByteArray(), "OidbSvc.0x8e4_4", 2276, 4, new Bundle(), 5000L);
  }
  
  public void b(String paramString, bcij<oidb_0x8e4.RspBody> parambcij)
  {
    if (QLog.isColorLevel()) {
      QLog.e("WerewolvesHandler", 2, "startGame");
    }
    oidb_0x8e4.ReqBody localReqBody = new oidb_0x8e4.ReqBody();
    localReqBody.string_invite_id.set(ByteStringMicro.copyFromUtf8(paramString), true);
    localReqBody.uint32_play_way.set(2, true);
    mxi.a(this.app, a(parambcij), localReqBody.toByteArray(), "OidbSvc.0x8e4_4", 2276, 4, new Bundle(), 5000L);
  }
  
  public void b(String paramString, boolean paramBoolean, bcij<oidb_0x8e4.RspBody> parambcij)
  {
    oidb_0x8e4.ReqBody localReqBody = new oidb_0x8e4.ReqBody();
    localReqBody.string_invite_id.set(ByteStringMicro.copyFromUtf8(paramString));
    paramString = localReqBody.uint32_ready_state;
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      paramString.set(i);
      mxi.a(this.app, a(parambcij), localReqBody.toByteArray(), "OidbSvc.0x8e4_7", 2276, 7, new Bundle(), 5000L);
      return;
    }
  }
  
  protected Class<? extends ajtg> observerClass()
  {
    return bciq.class;
  }
  
  public void onDestroy()
  {
    atcf localatcf = atcf.a();
    this.app.getApplication().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    localatcf.d();
    localatcf.a();
    if (this.jdField_a_of_type_Bcis != null) {
      this.jdField_a_of_type_Bcis.b();
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.app.getApp().getSharedPreferences("werewolves_sp", 0).edit().putString("judgeUin", this.jdField_a_of_type_JavaLangString).commit();
    }
    this.jdField_a_of_type_Bcik.removeCallbacksAndMessages(null);
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
          this.jdField_a_of_type_Bcik.sendMessage(paramFromServiceMsg);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bcic
 * JD-Core Version:    0.7.0.1
 */