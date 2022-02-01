import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0xb67.oidb_0xb67.ReqBody;
import tencent.im.oidb.cmd0xb67.oidb_0xb67.RspBody;
import tencent.im.oidb.cmd0xbc3.oidb_0xbc3.ReqBody;
import tencent.im.oidb.cmd0xbc3.oidb_0xbc3.RspBody;

public class aqjj
  extends anii
{
  public aqjj(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    for (;;)
    {
      return;
      String str = paramToServiceMsg.extraData.getString("frdUin", "");
      int j = paramToServiceMsg.extraData.getInt("shieldHours", 0);
      int k = paramToServiceMsg.extraData.getInt("uinType", 0);
      int m = paramToServiceMsg.extraData.getInt("topicId", 0);
      oidb_0xb67.RspBody localRspBody = null;
      try
      {
        paramToServiceMsg = (ConfessInfo)paramToServiceMsg.extraData.getSerializable("confessInfo");
        localRspBody = new oidb_0xb67.RspBody();
        int n = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
        if (n == 0)
        {
          int i;
          if (localRspBody.uint32_result.has())
          {
            i = localRspBody.uint32_result.get();
            label118:
            if (!localRspBody.bytes_err_msg.has()) {
              break label274;
            }
            paramFromServiceMsg = localRspBody.bytes_err_msg.get().toStringUtf8();
            label141:
            if (i != 0) {
              break label297;
            }
            if (j != -1) {
              break label280;
            }
            aqjq.a(this.app, str, aqji.e, k, m, paramToServiceMsg);
            label169:
            notifyUI(3, true, new Object[] { str, Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j), null, paramToServiceMsg });
          }
          while (QLog.isColorLevel())
          {
            QLog.i("ConfessHandler", 2, String.format("handleSetShieldFlag result:%d rspResult:%d frdUin:%s hours:%d", new Object[] { Integer.valueOf(n), Integer.valueOf(i), str, Integer.valueOf(j) }));
            return;
            i = 0;
            break label118;
            label274:
            paramFromServiceMsg = "";
            break label141;
            label280:
            aqjq.a(this.app, str, k, m, paramToServiceMsg);
            break label169;
            label297:
            notifyUI(3, false, new Object[] { str, Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j), paramFromServiceMsg, null });
          }
        }
        paramFromServiceMsg = localRspBody.bytes_err_msg.get().toStringUtf8();
        if (QLog.isColorLevel()) {
          if (paramFromServiceMsg != null) {
            break label449;
          }
        }
        label449:
        for (paramToServiceMsg = "";; paramToServiceMsg = paramFromServiceMsg)
        {
          QLog.i("ConfessHandler", 2, String.format("handleSetShieldFlag failed result:%d msg:%s", new Object[] { Integer.valueOf(n), paramToServiceMsg }));
          notifyUI(3, false, new Object[] { str, Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j), paramFromServiceMsg, null });
          return;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        for (;;)
        {
          paramToServiceMsg = localRspBody;
        }
      }
    }
  }
  
  private void b(QQAppInterface paramQQAppInterface, aqji paramaqji)
  {
    long l1 = bbyp.a();
    long l2 = aqji.a(paramQQAppInterface, "redpoint_box_show");
    if (QLog.isColorLevel()) {
      QLog.i("ConfessHandler", 2, String.format("onNeedShowBoxRedPoint oldRedPointTs:%d", new Object[] { Long.valueOf(l2) }));
    }
    aqji.a(paramQQAppInterface, "redpoint_box_show", l1);
    aqjq.a(paramQQAppInterface, false, true);
    paramQQAppInterface.a().a().d(anhk.aM, 1032);
    aong localaong = paramQQAppInterface.a().a();
    paramQQAppInterface = (RecentUser)localaong.findRecentUser(anhk.aM, 1032);
    int i;
    if (paramQQAppInterface == null)
    {
      paramQQAppInterface = new RecentUser(anhk.aM, 1032);
      paramQQAppInterface.lastmsgtime = l1;
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        localaong.saveRecentUser(paramQQAppInterface);
        paramQQAppInterface = this.mApp.getHandler(Conversation.class);
        if (paramQQAppInterface != null) {
          paramQQAppInterface.sendEmptyMessage(1009);
        }
      }
      notifyUI(4, true, paramaqji);
      return;
      if (paramQQAppInterface.lastmsgtime < l1)
      {
        paramQQAppInterface.lastmsgtime = l1;
        i = 1;
      }
      else
      {
        i = 0;
      }
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    long l1 = paramToServiceMsg.extraData.getLong("fromUin", 0L);
    long l2 = paramToServiceMsg.extraData.getLong("toUin", 0L);
    int i = paramToServiceMsg.extraData.getInt("topicId", 0);
    int j = paramToServiceMsg.extraData.getInt("type", 0);
    boolean bool = paramToServiceMsg.extraData.getBoolean("isConfessor", false);
    if (QLog.isColorLevel()) {
      QLog.i("ConfessHandler", 2, "handleGetHolmesProgress fUin:" + l1 + " tUin:" + l2 + " topicid:" + i + " type:" + j + " isConfessor:" + bool);
    }
    paramToServiceMsg = new oidb_0xbc3.RspBody();
    int k = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
    if (k == 0)
    {
      if ((paramToServiceMsg.uint32_cur_count.has()) && (paramToServiceMsg.uint32_total_count.has()))
      {
        k = paramToServiceMsg.uint32_cur_count.get();
        int m = paramToServiceMsg.uint32_total_count.get();
        if (QLog.isColorLevel()) {
          QLog.i("ConfessHandler", 2, "handleGetHolmesProgress curCount:" + k + " totalCount:" + m);
        }
        notifyUI(8, true, new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Boolean.valueOf(bool) });
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ConfessHandler", 2, "handleGetHolmesProgress failed no msg");
      }
      notifyUI(8, false, new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(bool) });
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ConfessHandler", 2, "handleGetHolmesProgress failed result:" + k);
    }
    notifyUI(8, false, new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(bool) });
  }
  
  private void c(QQAppInterface paramQQAppInterface, aqji paramaqji)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ConfessHandler", 2, "onNeedShowLebaRedPoint");
    }
    aqji.a(paramQQAppInterface, "redpoint_leba_show", bbyp.a());
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ConfessHandler", 2, "getHolmesCurrentProgress fUin:" + paramLong1 + " tUin:" + paramLong2 + " topicid:" + paramInt1 + " isConfessor:" + paramBoolean);
    }
    Object localObject = new oidb_0xbc3.ReqBody();
    ((oidb_0xbc3.ReqBody)localObject).uint64_from.set(paramLong1);
    ((oidb_0xbc3.ReqBody)localObject).uint64_to.set(paramLong2);
    ((oidb_0xbc3.ReqBody)localObject).uint32_topic_id.set(paramInt1);
    PBUInt32Field localPBUInt32Field = ((oidb_0xbc3.ReqBody)localObject).uint32_is_confessor;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localPBUInt32Field.set(i);
      localObject = makeOIDBPkg("OidbSvc.cmd0xbc3", 3011, 0, ((oidb_0xbc3.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).extraData.putLong("fromUin", paramLong1);
      ((ToServiceMsg)localObject).extraData.putLong("toUin", paramLong2);
      ((ToServiceMsg)localObject).extraData.putInt("topicId", paramInt1);
      ((ToServiceMsg)localObject).extraData.putInt("type", paramInt2);
      ((ToServiceMsg)localObject).extraData.putBoolean("isConfessor", paramBoolean);
      super.sendPbReq((ToServiceMsg)localObject);
      return;
    }
  }
  
  public void a(aqjy paramaqjy)
  {
    if (this.app == null) {
      return;
    }
    if ((RecentUser)this.app.a().a().findRecentUser(anhk.aM, 1032) != null)
    {
      MqqHandler localMqqHandler = this.mApp.getHandler(Conversation.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendEmptyMessage(1009);
      }
    }
    notifyUI(2, true, paramaqjy);
  }
  
  public void a(QQAppInterface paramQQAppInterface, aqji paramaqji)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ConfessHandler", 2, String.format("onGetNewConfig boxEntry:%d contactEntry:%d", new Object[] { Integer.valueOf(paramaqji.h), Integer.valueOf(paramaqji.i) }));
    }
    if (paramaqji.h == 2) {
      b(paramQQAppInterface, paramaqji);
    }
    if (paramaqji.i == 2) {
      c(paramQQAppInterface, paramaqji);
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, ConfessInfo paramConfessInfo, int paramInt3)
  {
    if (paramConfessInfo == null) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("ConfessHandler", 2, String.format("setSetShieldFlag frdUin:%s uinType:%d topicId:%d hours:%d confessinfo:%s", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramConfessInfo.toString() }));
      }
      long l1 = 0L;
      try
      {
        l2 = Long.parseLong(paramString);
        l1 = l2;
        boolean bool = Friends.isValidUin(l2);
        if (!bool) {}
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject;
          if (QLog.isColorLevel()) {
            QLog.i("ConfessHandler", 2, "setSetShieldFlag parseUin error return");
          }
          long l2 = l1;
          continue;
          String str = "0X80091A2";
        }
      }
    }
    if (paramInt3 == -1)
    {
      localObject = "0X80091A3";
      bcst.b(this.app, "dc00898", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
      localObject = new oidb_0xb67.ReqBody();
      ((oidb_0xb67.ReqBody)localObject).uint64_shield_uin.set(l2);
      ((oidb_0xb67.ReqBody)localObject).int64_expire_time.set(paramInt3);
      localObject = makeOIDBPkg("OidbSvc.cmd0xb67", 2919, 1, ((oidb_0xb67.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).extraData.putString("frdUin", paramString);
      ((ToServiceMsg)localObject).extraData.putInt("uinType", paramInt1);
      ((ToServiceMsg)localObject).extraData.putInt("topicId", paramInt2);
      ((ToServiceMsg)localObject).extraData.putInt("shieldHours", paramInt3);
      ((ToServiceMsg)localObject).extraData.putSerializable("confessInfo", paramConfessInfo);
      super.sendPbReq((ToServiceMsg)localObject);
      return;
    }
  }
  
  public void b(aqjy paramaqjy)
  {
    if (this.app == null) {
      return;
    }
    aong localaong;
    RecentUser localRecentUser;
    int i;
    if ((paramaqjy != null) && (paramaqjy.a()))
    {
      localaong = this.app.a().a();
      localRecentUser = (RecentUser)localaong.findRecentUser(anhk.aM, 1032);
      if (localRecentUser != null) {
        break label124;
      }
      localRecentUser = new RecentUser();
      localRecentUser.uin = anhk.aM;
      localRecentUser.setType(1032);
      localRecentUser.lastmsgtime = paramaqjy.a;
      paramaqjy = localRecentUser;
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        localaong.saveRecentUser(paramaqjy);
        paramaqjy = this.mApp.getHandler(Conversation.class);
        if (paramaqjy != null) {
          paramaqjy.sendEmptyMessage(1009);
        }
      }
      notifyUI(1, true, null);
      return;
      label124:
      if (localRecentUser.lastmsgtime < paramaqjy.a)
      {
        localRecentUser.lastmsgtime = paramaqjy.a;
        paramaqjy = localRecentUser;
        i = 1;
      }
      else
      {
        paramaqjy = localRecentUser;
        i = 0;
      }
    }
  }
  
  protected boolean msgCmdFilter(String paramString)
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.cmd0xb67");
    }
    return !this.allowCmdSet.contains(paramString);
  }
  
  protected Class<? extends anil> observerClass()
  {
    return aqjr.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if ("OidbSvc.cmd0xb67".equals(str)) {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    while (!"OidbSvc.cmd0xbc3".equals(str)) {
      return;
    }
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqjj
 * JD-Core Version:    0.7.0.1
 */