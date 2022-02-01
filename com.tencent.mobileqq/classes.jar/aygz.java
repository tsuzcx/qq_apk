import android.util.SparseArray;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.qphone.base.util.QLog;

public class aygz
{
  private final SparseArray<Class<? extends aygw>> a = new SparseArray();
  
  public aygz()
  {
    a();
  }
  
  private aygw a(BaseChatPie paramBaseChatPie)
  {
    QQAppInterface localQQAppInterface = paramBaseChatPie.app;
    paramBaseChatPie = paramBaseChatPie.sessionInfo;
    HotChatManager localHotChatManager = (HotChatManager)localQQAppInterface.getManager(60);
    if ((localHotChatManager != null) && (localHotChatManager.b(paramBaseChatPie.curFriendUin))) {
      return new ayhr();
    }
    if (nmy.a().a(paramBaseChatPie.curFriendUin)) {
      return new ayhp();
    }
    if (TroopInfo.isQidianPrivateTroop(localQQAppInterface, paramBaseChatPie.curFriendUin)) {
      return new ayhs();
    }
    return new ayhq();
  }
  
  private void a()
  {
    this.a.put(1000, ayhl.class);
    this.a.put(1004, ayhl.class);
    this.a.put(1008, ayha.class);
    this.a.put(1024, ayha.class);
    this.a.put(1020, aygp.class);
    this.a.put(1005, aygp.class);
    this.a.put(1003, aygp.class);
    this.a.put(1022, aygp.class);
    this.a.put(1009, aygp.class);
    this.a.put(1023, aygp.class);
    this.a.put(3000, aygt.class);
    this.a.put(10004, ayhm.class);
    this.a.put(1006, ayhj.class);
    this.a.put(1025, ayhh.class);
    this.a.put(1001, ayhn.class);
    this.a.put(10002, ayho.class);
    this.a.put(1010, ayhk.class);
    this.a.put(1021, ayhi.class);
    this.a.put(6000, aygq.class);
    this.a.put(9501, aygs.class);
  }
  
  private aygw b(BaseChatPie paramBaseChatPie, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = paramBaseChatPie.app;
    paramBaseChatPie = paramBaseChatPie.sessionInfo;
    if (bezm.b(localQQAppInterface, paramBaseChatPie.curFriendUin)) {
      return new ayhf();
    }
    if (nns.b(paramBaseChatPie.curFriendUin)) {
      return new ayhb();
    }
    if (paramBoolean) {
      return new ayhe();
    }
    if (localQQAppInterface.getCurrentUin().equals(paramBaseChatPie.curFriendUin)) {
      return new ayhg();
    }
    return new ayhd();
  }
  
  public aygw a(BaseChatPie paramBaseChatPie, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = paramBaseChatPie.app;
    int i = paramBaseChatPie.sessionInfo.curType;
    if ((i == 0) || (ChatActivityUtils.a(localQQAppInterface, paramBaseChatPie.sessionInfo.curFriendUin))) {
      return b(paramBaseChatPie, paramBoolean);
    }
    if (i == 1) {
      return a(paramBaseChatPie);
    }
    try
    {
      paramBaseChatPie = (Class)this.a.get(i);
      if (paramBaseChatPie != null)
      {
        paramBaseChatPie = (aygw)paramBaseChatPie.newInstance();
        return paramBaseChatPie;
      }
    }
    catch (Throwable paramBaseChatPie)
    {
      QLog.d("PlusPanelLoaderFactory", 1, paramBaseChatPie, new Object[0]);
    }
    return new aygr();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aygz
 * JD-Core Version:    0.7.0.1
 */