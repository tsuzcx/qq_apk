import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.EmoticonHandler.1;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.EmoticonResp;
import com.tencent.mobileqq.data.IPSiteModel.Book;
import com.tencent.mobileqq.data.IPSiteModel.Comic;
import com.tencent.mobileqq.data.IPSiteModel.ComicRich;
import com.tencent.mobileqq.data.IPSiteModel.Game;
import com.tencent.mobileqq.data.IPSiteModel.GameRich;
import com.tencent.mobileqq.data.IPSiteModel.Goods;
import com.tencent.mobileqq.data.IPSiteModel.Gxzb;
import com.tencent.mobileqq.data.IPSiteModel.Video;
import com.tencent.mobileqq.data.VipIPSiteInfo;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.pb.emosm.ComicIPSite.Book;
import com.tencent.pb.emosm.ComicIPSite.Comic;
import com.tencent.pb.emosm.ComicIPSite.ComicRich;
import com.tencent.pb.emosm.ComicIPSite.Game;
import com.tencent.pb.emosm.ComicIPSite.GameRich;
import com.tencent.pb.emosm.ComicIPSite.Goods;
import com.tencent.pb.emosm.ComicIPSite.Gxzb;
import com.tencent.pb.emosm.ComicIPSite.ModuleInfo;
import com.tencent.pb.emosm.ComicIPSite.ModuleReq;
import com.tencent.pb.emosm.ComicIPSite.ModuleRsp;
import com.tencent.pb.emosm.ComicIPSite.Video;
import com.tencent.pb.emosm.EmosmPb.ReqBody;
import com.tencent.pb.emosm.EmosmPb.RspBody;
import com.tencent.pb.emosm.EmosmPb.STRecommendTabInfo;
import com.tencent.pb.emosm.EmosmPb.SmallYellowItem;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x10MoveOrderReq;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x13Req;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x13Rsp;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x18Req;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x18Rsp;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x19Rsp;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x1ReqDelTab;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x1RspDelTab;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x2ReqFetchTab;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x2RspFetchTab;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x2RspFetchTab.TabInfo;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x3ReqFetchBq;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x3RspFetchBq;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x5ReqBQRecommend;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x5RspBQRecommend;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x6Req;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x6Rsp;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x7Req;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x7Rsp;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x8ReqAddTab;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x9BqAssocReq;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x9BqAssocRsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class anwx
  extends anud
{
  private ConcurrentHashMap<Integer, List<EmosmPb.SubCmd0x2RspFetchTab.TabInfo>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private CopyOnWriteArrayList<askk> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger();
  private ConcurrentHashMap<Integer, List<EmosmPb.SubCmd0x2RspFetchTab.TabInfo>> b = new ConcurrentHashMap();
  private ConcurrentHashMap<Integer, List<EmosmPb.SubCmd0x2RspFetchTab.TabInfo>> c = new ConcurrentHashMap();
  private ConcurrentHashMap<Integer, List<String>> d = new ConcurrentHashMap();
  
  public anwx(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, List<EmosmPb.SubCmd0x2RspFetchTab.TabInfo> paramList1, List<EmosmPb.SubCmd0x2RspFetchTab.TabInfo> paramList2, List<EmosmPb.SubCmd0x2RspFetchTab.TabInfo> paramList3, ArrayList<String> paramArrayList, int paramInt4)
  {
    if ((paramList1 == null) || (paramList2 == null)) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt2)) != null)
    {
      ((List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt2))).addAll(paramList1);
      if (this.b.get(Integer.valueOf(paramInt2)) == null) {
        break label181;
      }
      ((List)this.b.get(Integer.valueOf(paramInt2))).addAll(paramList2);
      label83:
      if (this.c.get(Integer.valueOf(paramInt2)) == null) {
        break label198;
      }
      ((List)this.c.get(Integer.valueOf(paramInt2))).addAll(paramList3);
    }
    for (;;)
    {
      paramList1 = new ArrayList();
      int i = paramArrayList.size() - 1;
      while (i >= 0)
      {
        paramList1.add(paramArrayList.get(i));
        i -= 1;
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt2), paramList1);
      break;
      label181:
      this.b.put(Integer.valueOf(paramInt2), paramList2);
      break label83;
      label198:
      this.c.put(Integer.valueOf(paramInt2), paramList3);
    }
    if (this.d.get(Integer.valueOf(paramInt2)) != null) {
      ((List)this.d.get(Integer.valueOf(paramInt2))).addAll(paramList1);
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("EmoticonHandler", 2, "--------secend fetch--------:");
        a(paramInt2, paramArrayList);
      }
      a(paramInt4, paramInt3, paramInt1, paramInt2);
      return;
      this.d.put(Integer.valueOf(paramInt2), paramList1);
    }
  }
  
  private void a(int paramInt1, EmoticonResp paramEmoticonResp, int paramInt2, List<EmosmPb.SubCmd0x2RspFetchTab.TabInfo> paramList)
  {
    if (paramList == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt2)) != null)
    {
      ((List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt2))).addAll(paramList);
      paramList = (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramInt2));
    }
    for (;;)
    {
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        EmosmPb.SubCmd0x2RspFetchTab.TabInfo localTabInfo = (EmosmPb.SubCmd0x2RspFetchTab.TabInfo)paramList.next();
        EmoticonPackage localEmoticonPackage = new EmoticonPackage();
        localEmoticonPackage.epId = String.valueOf(localTabInfo.uint32_tab_id.get());
        localEmoticonPackage.expiretime = localTabInfo.fixed32_expire_time.get();
        boolean bool;
        if (localTabInfo.uint32_flags.get() == 1)
        {
          bool = true;
          label152:
          localEmoticonPackage.valid = bool;
          localEmoticonPackage.wordingId = localTabInfo.int32_wording_id.get();
          localEmoticonPackage.name = localTabInfo.str_tab_name.get();
          if (paramInt1 != 0) {
            break label281;
          }
          localEmoticonPackage.aio = true;
        }
        for (;;)
        {
          localArrayList.add(localEmoticonPackage);
          if (!localEmoticonPackage.valid) {
            QLog.e("EmoticonHandler", 1, "TYPE_EMOSM_PS_FETCH: normal emotion ep not valid ; ep = " + localEmoticonPackage);
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("EmoticonHandler", 2, "TYPE_EMOSM_PS_FETCH: normal emotion ep = " + localEmoticonPackage);
          break;
          bool = false;
          break label152;
          label281:
          if (paramInt1 == 1) {
            localEmoticonPackage.kandian = true;
          }
        }
      }
      paramEmoticonResp.data = localArrayList;
      return;
    }
  }
  
  private void a(int paramInt1, EmoticonResp paramEmoticonResp, int paramInt2, List<EmosmPb.SubCmd0x2RspFetchTab.TabInfo> paramList, ArrayList<String> paramArrayList)
  {
    if (paramList == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    if (this.c.get(Integer.valueOf(paramInt2)) != null)
    {
      ((List)this.c.get(Integer.valueOf(paramInt2))).addAll(paramList);
      paramList = (List)this.c.remove(Integer.valueOf(paramInt2));
    }
    for (;;)
    {
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        EmosmPb.SubCmd0x2RspFetchTab.TabInfo localTabInfo = (EmosmPb.SubCmd0x2RspFetchTab.TabInfo)paramList.next();
        EmoticonPackage localEmoticonPackage = new EmoticonPackage();
        localEmoticonPackage.epId = String.valueOf(localTabInfo.uint32_tab_id.get());
        localEmoticonPackage.expiretime = localTabInfo.fixed32_expire_time.get();
        boolean bool;
        if (localTabInfo.uint32_flags.get() == 1)
        {
          bool = true;
          label152:
          localEmoticonPackage.valid = bool;
          localEmoticonPackage.wordingId = localTabInfo.int32_wording_id.get();
          localEmoticonPackage.name = localTabInfo.str_tab_name.get();
          localEmoticonPackage.jobType = 4;
          if (paramInt1 != 0) {
            break label287;
          }
          localEmoticonPackage.aio = true;
        }
        for (;;)
        {
          localArrayList.add(localEmoticonPackage);
          if (!localEmoticonPackage.valid) {
            QLog.e("EmoticonHandler", 1, "TYPE_EMOSM_PS_FETCH: small emotion ep not valid ; ep = " + localEmoticonPackage);
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("EmoticonHandler", 2, "TYPE_EMOSM_PS_FETCH: small emotion ep = " + localEmoticonPackage);
          break;
          bool = false;
          break label152;
          label287:
          if (paramInt1 == 1) {
            localEmoticonPackage.kandian = true;
          }
        }
      }
      paramEmoticonResp.smallEmoticonData = localArrayList;
      paramEmoticonResp.tabOrderList = ((List)this.d.remove(Integer.valueOf(paramInt2)));
      if (paramEmoticonResp.tabOrderList == null) {
        paramEmoticonResp.tabOrderList = new ArrayList();
      }
      paramInt1 = paramArrayList.size() - 1;
      while (paramInt1 >= 0)
      {
        paramEmoticonResp.tabOrderList.add(paramArrayList.get(paramInt1));
        paramInt1 -= 1;
      }
      break;
    }
  }
  
  private void a(int paramInt, EmoticonResp paramEmoticonResp, EmosmPb.RspBody paramRspBody)
  {
    ArrayList localArrayList = (ArrayList)paramEmoticonResp.data;
    paramEmoticonResp.epId = paramInt;
    paramRspBody = ((EmosmPb.SubCmd0x3RspFetchBq)paramRspBody.msg_subcmd0x3_rsp_fetchbq.get()).rpt_bytes_key.get();
    paramInt = 0;
    while (paramInt < paramRspBody.size())
    {
      ByteStringMicro localByteStringMicro = (ByteStringMicro)paramRspBody.get(paramInt);
      ((Emoticon)localArrayList.get(paramInt)).encryptKey = localByteStringMicro.toStringUtf8();
      paramInt += 1;
    }
    paramEmoticonResp.data = localArrayList;
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonHandler", 2, "emosm...fetch key 回包 sso 成功 ，server 成功");
    }
  }
  
  private void a(int paramInt, EmosmPb.RspBody paramRspBody)
  {
    EmosmPb.SubCmd0x19Rsp localSubCmd0x19Rsp;
    axfj localaxfj;
    EmoticonPackage localEmoticonPackage;
    if (paramRspBody.msg_subcmd0x19_rsp.has())
    {
      localSubCmd0x19Rsp = (EmosmPb.SubCmd0x19Rsp)paramRspBody.msg_subcmd0x19_rsp.get();
      int i = localSubCmd0x19Rsp.uint32_package_id.get();
      if (QLog.isColorLevel()) {
        QLog.i("EmoticonHandler", 2, "TYPE_EMOSM_IP_SITE_INFORMATION id = " + i);
      }
      localaxfj = (axfj)this.app.getManager(14);
      localEmoticonPackage = localaxfj.a(String.valueOf(i), paramInt);
      if (localEmoticonPackage != null)
      {
        localEmoticonPackage.ipUrl = localSubCmd0x19Rsp.str_ip_url.get();
        localEmoticonPackage.ipName = localSubCmd0x19Rsp.str_ip_name.get();
        localEmoticonPackage.ipDetail = localSubCmd0x19Rsp.str_ip_detail.get();
        String str = localSubCmd0x19Rsp.str_op_name.get();
        paramRspBody = str;
        if (TextUtils.isEmpty(str)) {
          paramRspBody = anzj.a(2131702982);
        }
        localEmoticonPackage.ipOpName = paramRspBody;
        localEmoticonPackage.ipJumpUrl = localSubCmd0x19Rsp.str_jump_url.get();
        if (localSubCmd0x19Rsp.fixed32_time.get() != 0) {
          break label211;
        }
      }
    }
    label211:
    for (long l = 86400L;; l = localSubCmd0x19Rsp.fixed32_time.get())
    {
      localEmoticonPackage.ipReqTime = l;
      localaxfj.a(localEmoticonPackage);
      return;
    }
  }
  
  private void a(int paramInt, EmosmPb.RspBody paramRspBody, axfj paramaxfj)
  {
    paramRspBody = (EmosmPb.SubCmd0x5RspBQRecommend)paramRspBody.msg_subcmd0x5_recommend.get();
    boolean bool1 = paramRspBody.bool_update_flag.get();
    if (bool1)
    {
      int i = paramRspBody.int32_last_recommend_version.get();
      SharedPreferences.Editor localEditor = this.app.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).edit();
      localEditor.putInt("recommendEmotion_sp_lastversion" + this.app.getCurrentAccountUin(), i);
      localEditor.putBoolean("isClickRecommendRedpoint", false);
      localEditor.putLong("recommendRedpointStartTime", System.currentTimeMillis());
      localEditor.putInt("recommendSeqinterval", paramRspBody.int32_req_frequency.get());
      localEditor.putInt("recommendRuleId", paramRspBody.int32_ruleid.get());
      localEditor.apply();
      boolean bool2 = paramRspBody.bool_recommend_show_flag.get();
      BaseApplication.getContext().getSharedPreferences("clubContentVersion", 0).edit().putBoolean("force_to_recommend_panel_sp", bool2).apply();
      paramaxfj.e();
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonHandler", 2, "recommend info : lastVersion = " + i + ";seqFrequncy = " + paramRspBody.int32_req_frequency.get() + ";isForceToRecommend = " + bool2);
      }
      paramaxfj.a(paramRspBody, paramInt);
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonHandler", 2, "recommend update flag = " + bool1);
    }
  }
  
  private void a(int paramInt, ArrayList<String> paramArrayList)
  {
    String str = "svr emoticon tab order list " + paramInt + " =";
    StringBuilder localStringBuilder = agej.a();
    localStringBuilder.append(str);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      localStringBuilder.append((String)paramArrayList.next());
      localStringBuilder.append(",");
      if (localStringBuilder.length() >= 500)
      {
        QLog.d("EmoticonHandler", 1, localStringBuilder.toString());
        localStringBuilder.setLength(str.length());
      }
    }
    QLog.d("EmoticonHandler", 1, localStringBuilder.toString());
  }
  
  private void a(EmosmPb.RspBody paramRspBody)
  {
    paramRspBody = ((EmosmPb.SubCmd0x13Rsp)paramRspBody.msg_subcmd0x13_rsp.get()).itemlist.get();
    if ((paramRspBody != null) && (paramRspBody.size() > 1))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        int i = 0;
        while (i < paramRspBody.size())
        {
          EmosmPb.SmallYellowItem localSmallYellowItem = (EmosmPb.SmallYellowItem)paramRspBody.get(i);
          if ((QLog.isColorLevel()) && (localSmallYellowItem != null)) {
            localStringBuilder.append("type = " + localSmallYellowItem.type.get() + ";id = " + localSmallYellowItem.id.get() + ";ts =" + localSmallYellowItem.ts.get());
          }
          i += 1;
        }
        QLog.d("EmoticonHandler", 2, "commonused systememoji item : " + localStringBuilder.toString());
      }
      QLog.d("EmoticonHandler", 1, "commonused back");
      ((asmn)this.app.getManager(172)).a(paramRspBody);
      return;
    }
    QLog.e("EmoticonHandler", 1, "handleCommonUseInfo ItemInfo = null");
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, boolean paramBoolean, int paramInt1, int paramInt2, EmoticonResp paramEmoticonResp)
  {
    axfj localaxfj = (axfj)this.app.getManager(14);
    if (paramInt1 == 2)
    {
      if (paramBoolean)
      {
        ThreadManagerV2.excute(new EmoticonHandler.1(this, localaxfj, paramEmoticonResp, paramInt2), 32, null, true);
        return;
      }
      QLog.e("EmoticonHandler", 1, "fetchEmoticonPackages failed: " + paramFromServiceMsg.getResultCode());
      notifyUI(paramInt1, paramBoolean, paramEmoticonResp);
      return;
    }
    if (paramInt1 == 3)
    {
      paramFromServiceMsg = (ArrayList)paramEmoticonResp.data;
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.size() > 0) && (paramBoolean)) {
        paramFromServiceMsg = paramFromServiceMsg.iterator();
      }
      while (paramFromServiceMsg.hasNext())
      {
        Emoticon localEmoticon = (Emoticon)paramFromServiceMsg.next();
        localaxfj.a(localEmoticon);
        if (QLog.isColorLevel())
        {
          QLog.d("EmoticonHandler", 2, "epId:" + localEmoticon.epId + ",eId:" + localEmoticon.eId + ",key:" + localEmoticon.encryptKey);
          continue;
          QLog.i("EmoticonHandler", 1, "fetch key error:" + paramEmoticonResp.resultcode);
        }
      }
      paramFromServiceMsg = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (paramFromServiceMsg.hasNext()) {
        ((askk)paramFromServiceMsg.next()).a(paramBoolean, paramInt1, paramEmoticonResp);
      }
    }
    notifyUI(paramInt1, paramBoolean, paramEmoticonResp);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, int paramInt, EmoticonResp paramEmoticonResp, axfj paramaxfj)
  {
    paramToServiceMsg = paramToServiceMsg.extraData.getIntegerArrayList("EmosmPackageIds");
    if ((paramToServiceMsg == null) || (paramToServiceMsg.size() == 0)) {}
    for (;;)
    {
      return;
      paramEmoticonResp.ids = paramToServiceMsg;
      paramToServiceMsg = paramToServiceMsg.iterator();
      while (paramToServiceMsg.hasNext())
      {
        paramEmoticonResp = String.valueOf((Integer)paramToServiceMsg.next());
        paramaxfj.g(paramEmoticonResp, paramInt);
        paramEmoticonResp = paramaxfj.a(paramEmoticonResp, paramInt);
        askc.a().b(paramEmoticonResp);
      }
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    label175:
    boolean bool;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      i = 1;
      if (i != 0)
      {
        try
        {
          paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
          paramToServiceMsg.mergeFrom((byte[])paramObject);
          if ((paramToServiceMsg.uint32_result.has()) && (QLog.isColorLevel())) {
            QLog.d("EmoticonHandler", 2, "CMD_EMOSM_CHECK_KANDIAN_OIDB uint32_result = " + paramToServiceMsg.uint32_result.get());
          }
          if ((!paramToServiceMsg.uint32_result.has()) || (paramToServiceMsg.uint32_result.get() != 0)) {
            break label489;
          }
          paramFromServiceMsg = new oidb_0x5eb.RspBody();
          paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          j = paramFromServiceMsg.rpt_msg_uin_data.size();
          if (!QLog.isColorLevel()) {
            break label459;
          }
          QLog.d("EmoticonHandler", 2, "CMD_EMOSM_CHECK_KANDIAN_OIDB infoNum = " + j);
        }
        catch (Exception paramToServiceMsg)
        {
          int j;
          label209:
          QLog.e("EmoticonHandler", 1, paramToServiceMsg.getMessage());
          return;
        }
        if (i < j)
        {
          if ((((oidb_0x5eb.UdcUinData)paramFromServiceMsg.rpt_msg_uin_data.get(i)).uint32_vas_emoticon_usage_info.get() & 0x1) != 1) {
            break label483;
          }
          bool = true;
          if (!bool) {
            break label468;
          }
          this.app.getApplication().getSharedPreferences("mobileQQ", 0).edit().putBoolean("emosm_has_download_emosmpackage_kandian_tag_" + this.app.getCurrentAccountUin(), bool).commit();
          break label468;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.w("EmoticonHandler", 2, "CMD_EMOSM_CHECK_KANDIAN_OIDB, needToFetchEmosmList = " + bool);
      }
      if (bool)
      {
        if (QLog.isColorLevel()) {
          QLog.w("EmoticonHandler", 2, "CMD_EMOSM_CHECK_KANDIAN_OIDB, initEmoticon");
        }
        a(0, 0, 1, 0);
      }
      do
      {
        return;
        i = paramToServiceMsg.extraData.getInt("EmoticonRetry");
        QLog.e("EmoticonHandler", 1, "CMD_EMOSM_CHECK_KANDIAN_OIDB, error:" + paramFromServiceMsg.getResultCode());
      } while ((paramFromServiceMsg.getResultCode() != 1002) || (i >= 2));
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonHandler", 2, "CMD_EMOSM_CHECK_KANDIAN_OIDB try index: " + i);
      }
      paramToServiceMsg.extraData.putInt("EmoticonRetry", i + 1);
      super.sendPbReq(paramToServiceMsg);
      return;
      label459:
      i = 0;
      bool = false;
      break label175;
      label468:
      i += 1;
      break label175;
      i = 0;
      break;
      label483:
      bool = false;
      break label209;
      label489:
      bool = false;
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    boolean bool1 = paramFromServiceMsg.isSuccess();
    int k = paramToServiceMsg.extraData.getInt("EmosmPackageId");
    int i = paramToServiceMsg.extraData.getInt("EmosmSubCmd");
    Object localObject = String.valueOf(paramToServiceMsg.getAttribute("_tag_LOGSTR"));
    ArrayList localArrayList = (ArrayList)paramToServiceMsg.extraData.getSerializable("EmosmEmos");
    EmoticonResp localEmoticonResp = new EmoticonResp();
    localEmoticonResp.resultcode = paramFromServiceMsg.getResultCode();
    localEmoticonResp.data = localArrayList;
    localEmoticonResp.epId = k;
    localEmoticonResp.keySeq = ((String)localObject);
    localEmoticonResp.timeoutReason = MessageHandler.a(paramFromServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonHandler", 2, "key_seq=" + (String)localObject + " isSuccess=" + bool1 + " resultCode=" + paramFromServiceMsg.getResultCode() + " timeout:" + localEmoticonResp.timeoutReason + ",subcmd = " + i);
    }
    if (bool1) {
      localObject = new EmosmPb.RspBody();
    }
    for (;;)
    {
      int j;
      try
      {
        paramArrayOfByte = (EmosmPb.RspBody)((EmosmPb.RspBody)localObject).mergeFrom(paramArrayOfByte);
        if (paramArrayOfByte == null) {
          break label861;
        }
        int m = paramArrayOfByte.int32_result.get();
        j = paramArrayOfByte.uint32_business_id.get();
        localEmoticonResp.resultcode = m;
        if (m != 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("EmoticonHandler", 2, "emosm...fetch key 回包 sso 成功 ，server 失败，result = " + m);
          }
          bool1 = false;
          a(paramFromServiceMsg, bool1, i, j, localEmoticonResp);
          return;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        localEmoticonResp.resultcode = -1;
        paramArrayOfByte = null;
        continue;
        localObject = (axfj)this.app.getManager(14);
        switch (i)
        {
        case 4: 
        case 8: 
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        case 14: 
        case 15: 
        case 16: 
        case 18: 
        case 19: 
        case 21: 
        case 22: 
        case 23: 
        default: 
          break;
        case 1: 
          localEmoticonResp.data = null;
          localEmoticonResp.delEpId = ((EmosmPb.SubCmd0x1RspDelTab)paramArrayOfByte.msg_subcmd0x1_rsp_deltab.get()).uint32_tab_id.get();
          paramToServiceMsg = String.valueOf(localEmoticonResp.delEpId);
          ((axfj)localObject).g(paramToServiceMsg, j);
          paramToServiceMsg = ((axfj)localObject).a(paramToServiceMsg, j);
          askc.a().b(paramToServiceMsg);
          break;
        case 17: 
          a(paramToServiceMsg, j, localEmoticonResp, (axfj)localObject);
          break;
        case 2: 
          if (!a(paramToServiceMsg, j, localEmoticonResp, paramArrayOfByte)) {
            continue;
          }
          return;
        }
      }
      a(k, localEmoticonResp, paramArrayOfByte);
      continue;
      localEmoticonResp.emoticonId = paramToServiceMsg.extraData.getString("EmoticonId");
      localEmoticonResp.delEpId = ((EmosmPb.SubCmd0x6Rsp)paramArrayOfByte.msg_subcmd0x6_collect_auth.get()).int32_auth_detail.get();
      localEmoticonResp.keySeq = ((EmosmPb.SubCmd0x6Rsp)paramArrayOfByte.msg_subcmd0x6_collect_auth.get()).str_auth_msg.get();
      continue;
      localEmoticonResp.emoticonId = paramToServiceMsg.extraData.getString("EmoticonId");
      localEmoticonResp.delEpId = ((EmosmPb.SubCmd0x7Rsp)paramArrayOfByte.msg_subcmd0x7_rsp.get()).int32_auth_detail.get();
      localEmoticonResp.keySeq = ((EmosmPb.SubCmd0x7Rsp)paramArrayOfByte.msg_subcmd0x7_rsp.get()).str_auth_msg.get();
      if (paramToServiceMsg.extraData.getBoolean("EmosmSubCmdFllow"))
      {
        i = 107;
        continue;
        localEmoticonResp.data = ((EmosmPb.SubCmd0x9BqAssocRsp)paramArrayOfByte.msg_subcmd0x9_rsp.get()).rpt_assoc_bqs.get();
        if (((EmosmPb.SubCmd0x9BqAssocRsp)paramArrayOfByte.msg_subcmd0x9_rsp.get()).i32_reset_exposure_flag.get() == 1) {}
        for (boolean bool2 = true;; bool2 = false)
        {
          localEmoticonResp.resetKeywordExpose = bool2;
          break;
        }
        a(j, paramArrayOfByte, (axfj)localObject);
        continue;
        a(paramArrayOfByte);
        continue;
        k = paramToServiceMsg.extraData.getInt("tabId");
        paramToServiceMsg = new asoo();
        paramToServiceMsg.jdField_a_of_type_Boolean = paramArrayOfByte.msg_subcmd0x18_rsp.bool_jump_flag.get();
        paramToServiceMsg.jdField_a_of_type_Int = paramArrayOfByte.msg_subcmd0x18_rsp.uint32_author_id.get();
        paramToServiceMsg.a(k);
        if (QLog.isColorLevel())
        {
          QLog.i("EmoticonHandler", 2, "fetchEmoticonRecommend return " + paramToServiceMsg.toString());
          continue;
          a(j, paramArrayOfByte);
          continue;
          label861:
          localEmoticonResp.resultcode = -1;
          if (QLog.isColorLevel()) {
            QLog.d("EmoticonHandler", 2, "emosm...fetch key 回包 异常 subcmd = " + i);
          }
          bool1 = false;
          j = 0;
          continue;
          if (!a(paramToServiceMsg, paramFromServiceMsg, i)) {
            j = 0;
          }
        }
      }
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, Object paramObject)
  {
    int i;
    for (;;)
    {
      try
      {
        paramObject = (ComicIPSite.ModuleRsp)new ComicIPSite.ModuleRsp().mergeFrom((byte[])paramObject);
        i = paramObject.result.get();
        switch (paramObject.sub_cmd.get())
        {
        case 1: 
          if (i != 0) {
            break label1472;
          }
          Object localObject1 = paramToServiceMsg.extraData.getString("epId");
          int k = paramObject.ipId.get();
          paramToServiceMsg = paramObject.ipName.get();
          String str1 = paramObject.ipDesc.get();
          String str2 = paramObject.ipUrl.get();
          int m = paramObject.itemSize.get();
          Object localObject2 = paramObject.strType.get();
          int n = paramObject.extId.get();
          Object localObject3 = paramObject.extStr.get();
          String str3 = paramObject.ipLogo.get();
          String str4 = paramObject.ipContent.get();
          long l;
          ArrayList localArrayList1;
          List localList1;
          Object localObject4;
          if (paramObject.requestInterval.get() == 0)
          {
            l = 86400L;
            if (QLog.isColorLevel()) {
              QLog.d("EmoticonHandler", 2, "onReceive richIPReqTime = " + l);
            }
            localArrayList1 = new ArrayList();
            if ("gxzb".equals(localObject2))
            {
              localList1 = paramObject.gxzbList.get();
              i = 0;
              if (i >= localList1.size()) {
                continue;
              }
              localObject4 = (ComicIPSite.Gxzb)localList1.get(i);
              localArrayList1.add(new IPSiteModel.Gxzb(((ComicIPSite.Gxzb)localObject4).appId.get(), ((ComicIPSite.Gxzb)localObject4).appName.get(), ((ComicIPSite.Gxzb)localObject4).cover.get(), ((ComicIPSite.Gxzb)localObject4).feeType.get(), ((ComicIPSite.Gxzb)localObject4).id.get(), ((ComicIPSite.Gxzb)localObject4).name.get()));
              i += 1;
              continue;
            }
          }
          else
          {
            l = paramObject.requestInterval.get();
            continue;
          }
          List localList2;
          ArrayList localArrayList2;
          int j;
          Object localObject5;
          if ("game".equals(localObject2))
          {
            localList1 = paramObject.gameList.get();
            i = 0;
            if (i < localList1.size())
            {
              localObject4 = (ComicIPSite.Game)localList1.get(i);
              localList2 = ((ComicIPSite.Game)localObject4).rich.get();
              localArrayList2 = new ArrayList();
              j = 0;
              if (j < localList2.size())
              {
                localObject5 = (ComicIPSite.GameRich)localList2.get(j);
                localArrayList2.add(new IPSiteModel.GameRich(((ComicIPSite.GameRich)localObject5).anchorFaceUrl.get(), ((ComicIPSite.GameRich)localObject5).anchorId.get(), ((ComicIPSite.GameRich)localObject5).anchorName.get(), ((ComicIPSite.GameRich)localObject5).coverUrl.get(), ((ComicIPSite.GameRich)localObject5).online.get(), ((ComicIPSite.GameRich)localObject5).title.get(), ((ComicIPSite.GameRich)localObject5).richJumpUrl.get()));
                j += 1;
                continue;
              }
              localArrayList1.add(new IPSiteModel.Game(((ComicIPSite.Game)localObject4).cover.get(), ((ComicIPSite.Game)localObject4).desc.get(), ((ComicIPSite.Game)localObject4).id.get(), ((ComicIPSite.Game)localObject4).jumpUrl.get(), ((ComicIPSite.Game)localObject4).name.get(), ((ComicIPSite.Game)localObject4).recommDesc.get(), localArrayList2));
              i += 1;
              continue;
            }
          }
          else if ("goods".equals(localObject2))
          {
            localList1 = paramObject.goodsList.get();
            i = 0;
            if (i < localList1.size())
            {
              localObject4 = (ComicIPSite.Goods)localList1.get(i);
              localArrayList1.add(new IPSiteModel.Goods(((ComicIPSite.Goods)localObject4).cover.get(), ((ComicIPSite.Goods)localObject4).goodsTags.get(), ((ComicIPSite.Goods)localObject4).id.get(), ((ComicIPSite.Goods)localObject4).name.get(), ((ComicIPSite.Goods)localObject4).price.get(), ((ComicIPSite.Goods)localObject4).saleTags.get(), ((ComicIPSite.Goods)localObject4).svipPrice.get(), ((ComicIPSite.Goods)localObject4).url.get(), ((ComicIPSite.Goods)localObject4).moreUrl.get(), ((ComicIPSite.Goods)localObject4).saleNum.get()));
              i += 1;
              continue;
            }
          }
          else if ("video".equals(localObject2))
          {
            localList1 = paramObject.videoList.get();
            i = 0;
            if (i < localList1.size())
            {
              localObject4 = (ComicIPSite.Video)localList1.get(i);
              localArrayList1.add(new IPSiteModel.Video(((ComicIPSite.Video)localObject4).id.get(), ((ComicIPSite.Video)localObject4).buttonDesc.get(), ((ComicIPSite.Video)localObject4).content.get(), ((ComicIPSite.Video)localObject4).cover.get(), ((ComicIPSite.Video)localObject4).desc.get(), ((ComicIPSite.Video)localObject4).name.get(), ((ComicIPSite.Video)localObject4).endTime.get(), ((ComicIPSite.Video)localObject4).isShow.get(), ((ComicIPSite.Video)localObject4).newStartTime.get(), ((ComicIPSite.Video)localObject4).newEndTime.get(), ((ComicIPSite.Video)localObject4).redirectUrl.get(), ((ComicIPSite.Video)localObject4).videoSource.get(), ((ComicIPSite.Video)localObject4).showDate.get()));
              i += 1;
              continue;
            }
          }
          else if ("book".equals(localObject2))
          {
            localList1 = paramObject.bookList.get();
            i = 0;
            if (i < localList1.size())
            {
              localObject4 = (ComicIPSite.Book)localList1.get(i);
              localArrayList1.add(new IPSiteModel.Book(((ComicIPSite.Book)localObject4).cover.get(), ((ComicIPSite.Book)localObject4).desc.get(), ((ComicIPSite.Book)localObject4).id.get(), ((ComicIPSite.Book)localObject4).jumpUrl.get(), ((ComicIPSite.Book)localObject4).name.get(), ((ComicIPSite.Book)localObject4).recommDesc.get(), ((ComicIPSite.Book)localObject4).authorName.get()));
              i += 1;
              continue;
            }
          }
          else if ("comic".equals(localObject2))
          {
            localList1 = paramObject.comicList.get();
            i = 0;
            if (i < localList1.size())
            {
              localObject4 = (ComicIPSite.Comic)localList1.get(i);
              localList2 = ((ComicIPSite.Comic)localObject4).rich.get();
              localArrayList2 = new ArrayList();
              j = 0;
              if (j < localList2.size())
              {
                localObject5 = (ComicIPSite.ComicRich)localList2.get(j);
                localArrayList2.add(new IPSiteModel.ComicRich(((ComicIPSite.ComicRich)localObject5).extCover.get(), ((ComicIPSite.ComicRich)localObject5).extName.get(), ((ComicIPSite.ComicRich)localObject5).extTitle.get(), ((ComicIPSite.ComicRich)localObject5).extUrl.get()));
                j += 1;
                continue;
              }
              localArrayList1.add(new IPSiteModel.Comic(((ComicIPSite.Comic)localObject4).comicType.get(), ((ComicIPSite.Comic)localObject4).cover.get(), ((ComicIPSite.Comic)localObject4).desc.get(), ((ComicIPSite.Comic)localObject4).id.get(), ((ComicIPSite.Comic)localObject4).jumpUrl.get(), ((ComicIPSite.Comic)localObject4).name.get(), ((ComicIPSite.Comic)localObject4).recommDesc.get(), ((ComicIPSite.Comic)localObject4).typeName.get(), localArrayList2));
              i += 1;
              continue;
            }
          }
          localObject2 = new VipIPSiteInfo(k, paramToServiceMsg, str1, str2, m, (String)localObject2, n, (String)localObject3, str3, str4, localArrayList1);
          if (this.app != null)
          {
            localObject3 = (axfj)this.app.getManager(14);
            if (localObject3 != null)
            {
              localObject1 = ((axfj)localObject3).a((String)localObject1);
              ((EmoticonPackage)localObject1).ipSiteInfo = ((VipIPSiteInfo)localObject2);
              ((EmoticonPackage)localObject1).ipSiteInfoBytes = ((axfj)localObject3).a((VipIPSiteInfo)localObject2);
              ((EmoticonPackage)localObject1).richIPReqTime = l;
              if (paramObject.goodsList.size() <= 0) {
                break label1466;
              }
              bool = true;
              ((EmoticonPackage)localObject1).hasIpProduct = bool;
              ((EmoticonPackage)localObject1).ipUrl = str3;
              ((EmoticonPackage)localObject1).ipName = paramToServiceMsg;
              ((EmoticonPackage)localObject1).ipDetail = str1;
              ((EmoticonPackage)localObject1).ipJumpUrl = str2;
              ((axfj)localObject3).a((EmoticonPackage)localObject1);
            }
          }
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d("EmoticonHandler", 2, "onReceive vipIPSiteInfo = " + localObject2);
          return;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.e("EmoticonHandler", 1, "onReceive error = ", paramToServiceMsg);
        return;
      }
      label1466:
      boolean bool = false;
    }
    label1472:
    QLog.e("EmoticonHandler", 1, "onReceive error result = " + i);
    return;
  }
  
  private boolean a(ToServiceMsg paramToServiceMsg, int paramInt, EmoticonResp paramEmoticonResp, EmosmPb.RspBody paramRspBody)
  {
    int i = paramToServiceMsg.extraData.getInt("EmosmFetchSeq");
    Object localObject = (EmosmPb.SubCmd0x2RspFetchTab)paramRspBody.msg_subcmd0x2_rsp_fetchtab.get();
    int j = ((EmosmPb.SubCmd0x2RspFetchTab)localObject).int32_segment_flag.get();
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonHandler", 2, "fetchSeq:" + i + " cur segement:" + j + " mapSize:" + this.d.size());
    }
    paramToServiceMsg = ((EmosmPb.SubCmd0x2RspFetchTab)localObject).rpt_msg_tabinfo.get();
    List localList1 = ((EmosmPb.SubCmd0x2RspFetchTab)localObject).rpt_magic_tabinfo.get();
    List localList2 = ((EmosmPb.SubCmd0x2RspFetchTab)localObject).rpt_smallbq_tabinfo.get();
    ArrayList localArrayList = new ArrayList();
    if (((EmosmPb.SubCmd0x2RspFetchTab)localObject).uint32_tab_id.has())
    {
      localObject = ((EmosmPb.SubCmd0x2RspFetchTab)localObject).uint32_tab_id.get().iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(String.valueOf((Integer)((Iterator)localObject).next()));
      }
    }
    int k = ((EmosmPb.SubCmd0x2RspFetchTab)paramRspBody.msg_subcmd0x2_rsp_fetchtab.get()).fixed32_timestamp.get();
    if ((j == 0) || (j == -1))
    {
      paramEmoticonResp.timestamp = k;
      a(paramInt, paramEmoticonResp, i, paramToServiceMsg);
      b(paramInt, paramEmoticonResp, i, localList1);
      a(paramInt, paramEmoticonResp, i, localList2, localArrayList);
      QLog.d("EmoticonHandler", 1, "svr big emoticon data size = " + paramEmoticonResp.data.size() + ", magic size = " + paramEmoticonResp.magicData.size() + ", small emotion size = " + paramEmoticonResp.smallEmoticonData.size() + ", tab size = " + paramEmoticonResp.tabOrderList.size());
      if (QLog.isColorLevel())
      {
        QLog.d("EmoticonHandler", 2, "svr big emoticon list=" + paramEmoticonResp.data + "svr magic emoticon list=" + paramEmoticonResp.magicData + "svr small emoticon list=" + paramEmoticonResp.smallEmoticonData);
        a(i, localArrayList);
      }
      return false;
    }
    a(paramInt, i, j, paramToServiceMsg, localList1, localList2, localArrayList, k);
    return true;
  }
  
  private boolean a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, int paramInt)
  {
    int i = paramToServiceMsg.extraData.getInt("EmoticonRetry");
    QLog.e("EmoticonHandler", 1, "error can not send cmd: " + paramInt);
    if ((paramFromServiceMsg.getResultCode() != 1000) && (i < 2) && (paramInt == 2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonHandler", 2, "try index: " + i);
      }
      paramToServiceMsg.extraData.putInt("EmoticonRetry", i + 1);
      super.sendPbReq(paramToServiceMsg);
      return true;
    }
    return false;
  }
  
  private void b(int paramInt1, EmoticonResp paramEmoticonResp, int paramInt2, List<EmosmPb.SubCmd0x2RspFetchTab.TabInfo> paramList)
  {
    if (paramList == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    if (this.b.get(Integer.valueOf(paramInt2)) != null)
    {
      ((List)this.b.get(Integer.valueOf(paramInt2))).addAll(paramList);
      paramList = (List)this.b.remove(Integer.valueOf(paramInt2));
    }
    for (;;)
    {
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        EmosmPb.SubCmd0x2RspFetchTab.TabInfo localTabInfo = (EmosmPb.SubCmd0x2RspFetchTab.TabInfo)paramList.next();
        EmoticonPackage localEmoticonPackage = new EmoticonPackage();
        localEmoticonPackage.epId = String.valueOf(localTabInfo.uint32_tab_id.get());
        localEmoticonPackage.expiretime = localTabInfo.fixed32_expire_time.get();
        boolean bool;
        if (localTabInfo.uint32_flags.get() == 1)
        {
          bool = true;
          label152:
          localEmoticonPackage.valid = bool;
          localEmoticonPackage.wordingId = localTabInfo.int32_wording_id.get();
          localEmoticonPackage.name = localTabInfo.str_tab_name.get();
          if (paramInt1 != 0) {
            break label325;
          }
          localEmoticonPackage.aio = true;
          label196:
          if (localTabInfo.int32_tab_type.has())
          {
            localEmoticonPackage.type = localTabInfo.int32_tab_type.get();
            if (localTabInfo.int32_tab_type.get() != 1) {
              break label339;
            }
            localEmoticonPackage.jobType = 3;
          }
        }
        for (;;)
        {
          if (!localEmoticonPackage.valid) {
            QLog.e("EmoticonHandler", 1, "TYPE_EMOSM_PS_FETCH: magic emotion ep not valid ; ep = " + localEmoticonPackage);
          }
          if (QLog.isColorLevel()) {
            QLog.d("EmoticonHandler", 2, "TYPE_EMOSM_PS_FETCH: magic emotion ep = " + localEmoticonPackage);
          }
          localArrayList.add(localEmoticonPackage);
          break;
          bool = false;
          break label152;
          label325:
          if (paramInt1 != 1) {
            break label196;
          }
          localEmoticonPackage.kandian = true;
          break label196;
          label339:
          if (localTabInfo.int32_tab_type.get() == 4) {
            localEmoticonPackage.jobType = 5;
          }
        }
      }
      paramEmoticonResp.magicData = localArrayList;
      return;
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = false;
    int i;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      i = 1;
      if (i == 0) {
        break label234;
      }
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg.uint32_result.get() == 0)
        {
          i = 1;
          if (i == 0) {
            break label344;
          }
          paramToServiceMsg = ByteBuffer.wrap(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          long l = paramToServiceMsg.getInt();
          if (paramToServiceMsg.get() == 1) {
            bool = true;
          }
          this.app.getApplication().getSharedPreferences("mobileQQ", 0).edit().putBoolean("emosm_has_download_emosmpackage_tag_" + this.app.getCurrentAccountUin(), bool).commit();
          if (QLog.isColorLevel()) {
            QLog.w("EmoticonHandler", 2, "CMD_EMOSM_CHECK_OIDB, needToFetchEmosmList = " + bool);
          }
          if (bool)
          {
            if (QLog.isColorLevel()) {
              QLog.w("EmoticonHandler", 2, "CMD_EMOSM_CHECK_OIDB, initEmoticon");
            }
            a(0, 0);
          }
          return;
          i = 0;
          break;
        }
        i = 0;
        continue;
        i = paramToServiceMsg.extraData.getInt("EmoticonRetry");
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.e("EmoticonHandler", 1, paramToServiceMsg.getMessage());
        return;
      }
      label234:
      QLog.e("EmoticonHandler", 1, "CMD_EMOSM_CHECK_OIDB, error:" + paramFromServiceMsg.getResultCode());
      if ((paramFromServiceMsg.getResultCode() == 1002) && (i < 2))
      {
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonHandler", 2, "CMD_EMOSM_CHECK_OIDB try index: " + i);
        }
        paramToServiceMsg.extraData.putInt("EmoticonRetry", i + 1);
        super.sendPbReq(paramToServiceMsg);
        return;
        label344:
        bool = true;
      }
    }
  }
  
  public void a()
  {
    c(0);
  }
  
  public void a(int paramInt)
  {
    b(paramInt, 0);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2, 0, 0);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonHandler", 2, "func fetchEmoticonsPackages, timestamp:" + paramInt1 + ",dividemask:" + paramInt2 + " businessType = " + paramInt3 + " fetchSeq:" + paramInt4);
    }
    Object localObject = new EmosmPb.SubCmd0x2ReqFetchTab();
    ((EmosmPb.SubCmd0x2ReqFetchTab)localObject).fixed32_timestamp.set(paramInt1);
    ((EmosmPb.SubCmd0x2ReqFetchTab)localObject).int32_segment_flag.set(paramInt2);
    EmosmPb.ReqBody localReqBody = new EmosmPb.ReqBody();
    localReqBody.uint32_sub_cmd.set(2);
    localReqBody.uint64_uin.set(Long.valueOf(this.app.getCurrentAccountUin()).longValue());
    localReqBody.msg_subcmd0x2_req_fetchtab.set((MessageMicro)localObject);
    localReqBody.int32_plat_id.set(109);
    localReqBody.str_app_version.set("8.4.5");
    localReqBody.uint32_business_id.set(paramInt3);
    if (paramInt4 == 0)
    {
      paramInt2 = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
      paramInt1 = paramInt2;
      if (paramInt2 == 0) {
        paramInt1 = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
      }
      this.d.remove(Integer.valueOf(paramInt1));
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramInt1));
      this.c.remove(Integer.valueOf(paramInt1));
      this.b.remove(Integer.valueOf(paramInt1));
    }
    for (;;)
    {
      localObject = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "BQMallSvc.TabOpReq");
      ((ToServiceMsg)localObject).extraData.putInt("EmosmSubCmd", 2);
      ((ToServiceMsg)localObject).extraData.putInt("EmosmFetchSeq", paramInt1);
      ((ToServiceMsg)localObject).putWupBuffer(localReqBody.toByteArray());
      super.sendPbReq((ToServiceMsg)localObject);
      return;
      paramInt1 = paramInt4;
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    EmosmPb.ReqBody localReqBody = new EmosmPb.ReqBody();
    localReqBody.uint64_uin.set(Long.valueOf(this.app.getCurrentAccountUin()).longValue());
    localReqBody.int32_plat_id.set(109);
    localReqBody.str_app_version.set("8.4.5");
    Object localObject;
    if (6 == paramInt1)
    {
      localReqBody.uint32_sub_cmd.set(paramInt1);
      localObject = new EmosmPb.SubCmd0x6Req();
      ((EmosmPb.SubCmd0x6Req)localObject).u32_tab_id.set(paramInt2);
      ((EmosmPb.SubCmd0x6Req)localObject).str_item_id.set(paramString);
      localReqBody.msg_subcmd0x6_req.set((MessageMicro)localObject);
    }
    for (;;)
    {
      localObject = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "BQMallSvc.TabOpReq");
      ((ToServiceMsg)localObject).extraData.putInt("EmosmPackageId", paramInt2);
      ((ToServiceMsg)localObject).extraData.putInt("EmosmSubCmd", paramInt1);
      ((ToServiceMsg)localObject).extraData.putString("EmoticonId", paramString);
      ((ToServiceMsg)localObject).extraData.putBoolean("EmosmSubCmdFllow", false);
      if (107 == paramInt1)
      {
        ((ToServiceMsg)localObject).extraData.putInt("EmosmSubCmd", 7);
        ((ToServiceMsg)localObject).extraData.putBoolean("EmosmSubCmdFllow", true);
      }
      ((ToServiceMsg)localObject).putWupBuffer(localReqBody.toByteArray());
      super.sendPbReq((ToServiceMsg)localObject);
      return;
      if ((7 == paramInt1) || (107 == paramInt1))
      {
        localReqBody.uint32_sub_cmd.set(7);
        localObject = new EmosmPb.SubCmd0x7Req();
        ((EmosmPb.SubCmd0x7Req)localObject).u32_tab_id.set(paramInt2);
        ((EmosmPb.SubCmd0x7Req)localObject).str_item_id.set(paramString);
        localReqBody.msg_subcmd0x7_req.set((MessageMicro)localObject);
      }
    }
  }
  
  public void a(int paramInt, ArrayList<Emoticon> paramArrayList, String paramString)
  {
    if (paramArrayList == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonHandler", 2, "emosm...fetch key count  = " + paramArrayList.size() + " epid = " + ((Emoticon)paramArrayList.get(0)).epId + "  eid.0 = " + ((Emoticon)paramArrayList.get(0)).eId);
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = paramArrayList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (Emoticon)((Iterator)localObject2).next();
      try
      {
        localObject3 = ByteStringMicro.copyFrom(asos.a(((Emoticon)localObject3).eId));
        ((List)localObject1).add(localObject3);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localNumberFormatException.printStackTrace();
      }
    }
    localObject2 = new EmosmPb.SubCmd0x3ReqFetchBq();
    ((EmosmPb.SubCmd0x3ReqFetchBq)localObject2).uint32_tab_id.set(paramInt);
    int i = 0;
    while (i < ((List)localObject1).size())
    {
      ((EmosmPb.SubCmd0x3ReqFetchBq)localObject2).rpt_bytes_bqid.get().add(((List)localObject1).get(i));
      i += 1;
    }
    localObject1 = new EmosmPb.ReqBody();
    ((EmosmPb.ReqBody)localObject1).uint32_sub_cmd.set(3);
    ((EmosmPb.ReqBody)localObject1).uint64_uin.set(Long.valueOf(this.app.getCurrentAccountUin()).longValue());
    ((EmosmPb.ReqBody)localObject1).msg_subcmd0x3_req_fetchbq.set((MessageMicro)localObject2);
    ((EmosmPb.ReqBody)localObject1).int32_plat_id.set(109);
    localObject2 = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "BQMallSvc.TabOpReq");
    ((ToServiceMsg)localObject2).extraData.putInt("EmosmPackageId", paramInt);
    ((ToServiceMsg)localObject2).extraData.putSerializable("EmosmEmos", paramArrayList);
    ((ToServiceMsg)localObject2).extraData.putInt("EmosmSubCmd", 3);
    ((ToServiceMsg)localObject2).addAttribute("_tag_LOGSTR", paramString);
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonHandler", 2, "getKeySeq reqlocalseq:" + paramString);
    }
    ((ToServiceMsg)localObject2).putWupBuffer(((EmosmPb.ReqBody)localObject1).toByteArray());
    super.sendPbReq((ToServiceMsg)localObject2);
  }
  
  public void a(askk paramaskk)
  {
    if (paramaskk != null) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.addIfAbsent(paramaskk);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonHandler", 2, "ReportAddEmoticonPkg, pkgId=" + paramString + " businessType = " + paramInt);
    }
    Object localObject = new EmosmPb.SubCmd0x8ReqAddTab();
    ((EmosmPb.SubCmd0x8ReqAddTab)localObject).uint32_tab_id.set(Integer.parseInt(paramString));
    paramString = new EmosmPb.ReqBody();
    paramString.uint32_sub_cmd.set(8);
    paramString.uint64_uin.set(Long.valueOf(this.app.getCurrentAccountUin()).longValue());
    paramString.int32_plat_id.set(109);
    paramString.str_app_version.set("8.4.5");
    paramString.msg_subcmd0x8_req_addtab.set((MessageMicro)localObject);
    paramString.uint32_business_id.set(paramInt);
    paramString.setHasFlag(true);
    localObject = createToServiceMsg("BQMallSvc.TabOpReq");
    ((ToServiceMsg)localObject).extraData.putInt("EmosmSubCmd", 8);
    ((ToServiceMsg)localObject).putWupBuffer(paramString.toByteArray());
    super.sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(String paramString, List<String> paramList1, List<String> paramList2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonHandler", 2, "getCloudEmoticonForKeyword");
    }
    Object localObject = paramList1;
    if (paramList1 == null) {
      localObject = new ArrayList();
    }
    paramList1 = paramList2;
    if (paramList2 == null) {
      paramList1 = new ArrayList();
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonHandler", 2, "notFullExposeList size = " + ((List)localObject).size() + ",fullExposeList size = " + paramList1.size());
    }
    paramList2 = new EmosmPb.ReqBody();
    paramList2.uint64_uin.set(Long.valueOf(this.app.getCurrentAccountUin()).longValue());
    paramList2.int32_plat_id.set(109);
    paramList2.uint32_sub_cmd.set(9);
    paramList2.str_app_version.set("8.4.5");
    EmosmPb.SubCmd0x9BqAssocReq localSubCmd0x9BqAssocReq = new EmosmPb.SubCmd0x9BqAssocReq();
    localSubCmd0x9BqAssocReq.str_key_word.set(paramString);
    localSubCmd0x9BqAssocReq.rpt_str_bq_item_id.set((List)localObject);
    localSubCmd0x9BqAssocReq.rpt_str_dead_bq_item_id.set(paramList1);
    paramList2.msg_subcmd0x9_req.set(localSubCmd0x9BqAssocReq);
    paramString = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "BQMallSvc.TabOpReq");
    paramString.extraData.putInt("EmosmSubCmd", 9);
    paramString.putWupBuffer(paramList2.toByteArray());
    super.sendPbReq(paramString);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonHandler", 2, "fetchEmoticonIPSiteInformationEx, tabId:" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("EmoticonHandler", 1, "fetchEmoticonIPSiteInformationEx error, id = " + paramString);
    }
    while (this.app == null) {
      return;
    }
    Object localObject = new ComicIPSite.ModuleInfo();
    ((ComicIPSite.ModuleInfo)localObject).appId.set(204);
    ((ComicIPSite.ModuleInfo)localObject).itemId.set("1_" + paramString);
    ((ComicIPSite.ModuleInfo)localObject).isRetSummary.set(paramBoolean);
    ComicIPSite.ModuleReq localModuleReq = new ComicIPSite.ModuleReq();
    localModuleReq.platform.set(109L);
    localModuleReq.mqqver.set("8.4.5");
    localModuleReq.uin.set(Long.valueOf(this.app.c()).longValue());
    localModuleReq.sub_cmd.set(1);
    localModuleReq.moduleInfo.set((MessageMicro)localObject);
    localObject = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "gxzbIpsit.ipsite");
    ((ToServiceMsg)localObject).extraData.putString("epId", paramString);
    ((ToServiceMsg)localObject).putWupBuffer(localModuleReq.toByteArray());
    super.sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(ArrayList<Integer> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    Object localObject = new EmosmPb.SubCmd0x1ReqDelTab();
    ((EmosmPb.SubCmd0x1ReqDelTab)localObject).rpt_tab_id.addAll(paramArrayList);
    EmosmPb.ReqBody localReqBody = new EmosmPb.ReqBody();
    localReqBody.uint32_sub_cmd.set(1);
    localReqBody.uint64_uin.set(Long.valueOf(this.app.getCurrentAccountUin()).longValue());
    localReqBody.msg_subcmd0x1_req_deltab.set((MessageMicro)localObject);
    localReqBody.int32_plat_id.set(109);
    localObject = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "BQMallSvc.TabOpReq");
    ((ToServiceMsg)localObject).extraData.putInt("EmosmPackageId", -1);
    ((ToServiceMsg)localObject).extraData.putInt("EmosmSubCmd", 17);
    ((ToServiceMsg)localObject).extraData.putIntegerArrayList("EmosmPackageIds", paramArrayList);
    ((ToServiceMsg)localObject).putWupBuffer(localReqBody.toByteArray());
    super.sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(List<String> paramList, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonHandler", 2, "reportEmoticonOrder, localList=" + paramList + ", shouldReverse=" + paramBoolean + ", businessType = " + paramInt);
    }
    if ((paramList == null) || (paramList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonHandler", 2, "reportEmoticonOrder, localList null, abort");
      }
      return;
    }
    Object localObject = new EmosmPb.SubCmd0x10MoveOrderReq();
    ArrayList localArrayList = new ArrayList(paramList.size());
    if (paramBoolean) {}
    for (;;)
    {
      int i;
      try
      {
        i = paramList.size() - 1;
        if (i < 0) {
          continue;
        }
        str = (String)paramList.get(i);
        if (TextUtils.isEmpty(str)) {
          break label380;
        }
        localArrayList.add(Integer.valueOf(Integer.parseInt(str)));
      }
      catch (Exception paramList)
      {
        String str;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("EmoticonHandler", 2, "reportEmoticonOrder, error=" + MsfSdkUtils.getStackTraceString(paramList));
        ((EmosmPb.SubCmd0x10MoveOrderReq)localObject).uint32_tab_id.set(localArrayList);
        paramList = new EmosmPb.ReqBody();
        paramList.uint32_sub_cmd.set(16);
        paramList.uint64_uin.set(Long.valueOf(this.app.getCurrentAccountUin()).longValue());
        paramList.int32_plat_id.set(109);
        paramList.str_app_version.set("8.4.5");
        paramList.msg_subcmd0x10_req.set((MessageMicro)localObject);
        paramList.uint32_business_id.set(paramInt);
        paramList.setHasFlag(true);
        localObject = createToServiceMsg("BQMallSvc.TabOpReq");
        ((ToServiceMsg)localObject).extraData.putInt("EmosmSubCmd", 16);
        ((ToServiceMsg)localObject).putWupBuffer(paramList.toByteArray());
        super.sendPbReq((ToServiceMsg)localObject);
        return;
      }
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        str = (String)paramList.next();
        if (!TextUtils.isEmpty(str)) {
          localArrayList.add(Integer.valueOf(Integer.parseInt(str)));
        }
      }
      else
      {
        label380:
        i -= 1;
      }
    }
  }
  
  public void b()
  {
    EmosmPb.ReqBody localReqBody = new EmosmPb.ReqBody();
    localReqBody.uint64_uin.set(Long.valueOf(this.app.getCurrentAccountUin()).longValue());
    localReqBody.int32_plat_id.set(109);
    localReqBody.uint32_sub_cmd.set(19);
    localReqBody.str_app_version.set("8.4.5");
    Object localObject1 = ((asmn)this.app.getManager(172)).c();
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonHandler", 2, "getCommonUsedSmallYellowEmoitonRequest list is null");
      }
      localObject1 = new ArrayList();
    }
    for (;;)
    {
      Object localObject2;
      if (QLog.isColorLevel())
      {
        if ((localObject1 == null) || (((List)localObject1).size() <= 1)) {
          break label377;
        }
        localObject2 = new StringBuilder();
        int i = 0;
        while (i < ((List)localObject1).size())
        {
          EmosmPb.SmallYellowItem localSmallYellowItem = (EmosmPb.SmallYellowItem)((List)localObject1).get(i);
          if (localSmallYellowItem != null) {
            ((StringBuilder)localObject2).append("type = " + localSmallYellowItem.type.get()).append(";id = " + localSmallYellowItem.id.get()).append(";ts = " + localSmallYellowItem.ts.get());
          }
          i += 1;
        }
        QLog.d("EmoticonHandler", 2, "getCommonUsedSmallYellowEmoitonRequest item " + ((StringBuilder)localObject2).toString());
      }
      for (;;)
      {
        localObject2 = new EmosmPb.SubCmd0x13Req();
        ((EmosmPb.SubCmd0x13Req)localObject2).itemlist.set((List)localObject1);
        localReqBody.msg_subcmd0x13_req.set((MessageMicro)localObject2);
        localObject1 = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "BQMallSvc.TabOpReq");
        ((ToServiceMsg)localObject1).extraData.putInt("EmosmSubCmd", 20);
        ((ToServiceMsg)localObject1).putWupBuffer(localReqBody.toByteArray());
        super.sendPbReq((ToServiceMsg)localObject1);
        if (QLog.isColorLevel()) {
          QLog.i("EmoticonHandler", 2, "getCommonUsedSmallYellowEmoitonRequest called.");
        }
        return;
        label377:
        QLog.d("EmoticonHandler", 2, "getCommonUsedSmallYellowEmoitonRequest infos = null");
      }
    }
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonHandler", 2, "fetchEmoticonRecommend, tabId:" + paramInt);
    }
    Object localObject = new EmosmPb.SubCmd0x18Req();
    ((EmosmPb.SubCmd0x18Req)localObject).uint32_tab_id.set(paramInt);
    EmosmPb.ReqBody localReqBody = new EmosmPb.ReqBody();
    localReqBody.uint32_sub_cmd.set(24);
    localReqBody.uint64_uin.set(Long.valueOf(this.app.getCurrentAccountUin()).longValue());
    localReqBody.msg_subcmd0x18_req.set((MessageMicro)localObject);
    localReqBody.int32_plat_id.set(109);
    localReqBody.str_app_version.set("8.4.5");
    localObject = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "BQMallSvc.TabOpReq");
    ((ToServiceMsg)localObject).extraData.putInt("EmosmSubCmd", 24);
    ((ToServiceMsg)localObject).extraData.putInt("tabId", paramInt);
    ((ToServiceMsg)localObject).putWupBuffer(localReqBody.toByteArray());
    super.sendPbReq((ToServiceMsg)localObject);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    Object localObject = new EmosmPb.SubCmd0x1ReqDelTab();
    ((EmosmPb.SubCmd0x1ReqDelTab)localObject).uint32_tab_id.set(paramInt1);
    EmosmPb.ReqBody localReqBody = new EmosmPb.ReqBody();
    localReqBody.uint32_sub_cmd.set(1);
    localReqBody.uint64_uin.set(Long.valueOf(this.app.getCurrentAccountUin()).longValue());
    localReqBody.msg_subcmd0x1_req_deltab.set((MessageMicro)localObject);
    localReqBody.int32_plat_id.set(109);
    localReqBody.uint32_business_id.set(paramInt2);
    localObject = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "BQMallSvc.TabOpReq");
    ((ToServiceMsg)localObject).extraData.putInt("EmosmPackageId", paramInt1);
    ((ToServiceMsg)localObject).extraData.putInt("EmosmSubCmd", 1);
    ((ToServiceMsg)localObject).putWupBuffer(localReqBody.toByteArray());
    super.sendPbReq((ToServiceMsg)localObject);
  }
  
  public void b(askk paramaskk)
  {
    if (paramaskk != null) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramaskk);
    }
  }
  
  public void c()
  {
    Object localObject1 = VasQuickUpdateManager.getJSONFromLocal(this.app, "watch_focus.json", true, null);
    if (localObject1 != null)
    {
      JSONArray localJSONArray = ((JSONObject)localObject1).optJSONArray("watchingFocusRecommendList");
      if ((localJSONArray != null) && (localJSONArray.length() > 0))
      {
        Object localObject2 = new ArrayList();
        int i = 0;
        if (i < localJSONArray.length())
        {
          localObject1 = localJSONArray.optJSONObject(i);
          int j = ((JSONObject)localObject1).optInt("itemId");
          String str1 = ((JSONObject)localObject1).optString("name");
          int k = ((JSONObject)localObject1).optInt("itemType");
          int m = ((JSONObject)localObject1).optInt("feeType");
          localObject1 = "";
          if (k == 3) {
            localObject1 = asos.k.replace("[epId]", String.valueOf(j)).replace("[mod]", String.valueOf(j % 10));
          }
          for (;;)
          {
            String str2 = bhyk.a(BaseApplicationImpl.context, "emojiDetail", String.valueOf(j), "") + "&sceneType=1";
            EmosmPb.STRecommendTabInfo localSTRecommendTabInfo = new EmosmPb.STRecommendTabInfo();
            localSTRecommendTabInfo.u32_tab_id.set(j);
            localSTRecommendTabInfo.str_tab_name.set(str1);
            localSTRecommendTabInfo.i32_tab_type.set(k);
            localSTRecommendTabInfo.i32_feetype.set(m);
            localSTRecommendTabInfo.str_thumb_nail_url.set((String)localObject1);
            localSTRecommendTabInfo.str_button_url.set(str2);
            ((List)localObject2).add(localSTRecommendTabInfo);
            i += 1;
            break;
            if (k == 6) {
              localObject1 = asos.l.replace("[epId]", String.valueOf(j));
            }
          }
        }
        localObject1 = new EmosmPb.SubCmd0x5RspBQRecommend();
        ((EmosmPb.SubCmd0x5RspBQRecommend)localObject1).st_new_tab_info.set((List)localObject2);
        localObject2 = (axfj)this.app.getManager(14);
        if (localObject2 != null) {
          ((axfj)localObject2).a((EmosmPb.SubCmd0x5RspBQRecommend)localObject1, 1);
        }
      }
    }
  }
  
  public void c(int paramInt)
  {
    int i = -1;
    EmosmPb.ReqBody localReqBody = new EmosmPb.ReqBody();
    localReqBody.uint64_uin.set(Long.valueOf(this.app.getCurrentAccountUin()).longValue());
    localReqBody.int32_plat_id.set(109);
    localReqBody.uint32_sub_cmd.set(5);
    localReqBody.str_app_version.set("8.4.5");
    localReqBody.uint32_business_id.set(paramInt);
    Object localObject = new EmosmPb.SubCmd0x5ReqBQRecommend();
    int j = this.app.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).getInt("recommendEmotion_sp_lastversion" + this.app.getCurrentAccountUin(), -1);
    if (!new File(this.app.getApplication().getFilesDir(), "recommemd_emotion_file__" + paramInt + this.app.getCurrentAccountUin()).exists()) {}
    for (paramInt = i;; paramInt = j)
    {
      ((EmosmPb.SubCmd0x5ReqBQRecommend)localObject).int32_last_recommend_version.set(paramInt);
      localReqBody.msg_subcmd0x5_req.set((MessageMicro)localObject);
      localObject = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "BQMallSvc.TabOpReq");
      ((ToServiceMsg)localObject).extraData.putInt("EmosmSubCmd", 5);
      ((ToServiceMsg)localObject).putWupBuffer(localReqBody.toByteArray());
      super.sendPbReq((ToServiceMsg)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonHandler", 2, "handle request to recommendEmotionInfo");
      }
      return;
    }
  }
  
  public void d(int paramInt)
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    if (paramInt == 0)
    {
      localOIDBSSOPkg.uint32_command.set(1168);
      localOIDBSSOPkg.uint32_service_type.set(92);
      localObject = ByteBuffer.allocate(4);
      ((ByteBuffer)localObject).putInt((int)Long.parseLong(this.app.getCurrentAccountUin()));
      localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
      localObject = createToServiceMsg("OidbSvc.0x490_92");
      ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
      super.sendPbReq((ToServiceMsg)localObject);
    }
    while (paramInt != 1) {
      return;
    }
    localOIDBSSOPkg.uint32_command.set(1515);
    localOIDBSSOPkg.uint32_service_type.set(99);
    Object localObject = new oidb_0x5eb.ReqBody();
    ((oidb_0x5eb.ReqBody)localObject).rpt_uint64_uins.add(Long.valueOf(Long.parseLong(this.app.getCurrentAccountUin())));
    ((oidb_0x5eb.ReqBody)localObject).uint32_vas_emoticon_usage_info.set(1);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x5eb.ReqBody)localObject).toByteArray()));
    localObject = createToServiceMsg("OidbSvc.0x5eb_99");
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    super.sendPbReq((ToServiceMsg)localObject);
  }
  
  protected Class<? extends anui> observerClass()
  {
    return anwy.class;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("BQMallSvc.TabOpReq")) {
      a(paramToServiceMsg, paramFromServiceMsg, (byte[])paramObject);
    }
    do
    {
      return;
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x490_92"))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x5eb_99"))
      {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("gxzbIpsit.ipsite"))
      {
        a(paramToServiceMsg, paramObject);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("EmoticonHandler", 2, "cmdfilter error=" + paramFromServiceMsg.getServiceCmd());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anwx
 * JD-Core Version:    0.7.0.1
 */