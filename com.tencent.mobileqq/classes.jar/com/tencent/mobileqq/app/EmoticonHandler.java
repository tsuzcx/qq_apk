package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.core.util.EmoticonPanelUtils;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.EmoticonResp;
import com.tencent.mobileqq.emosm.IEmoticonHandler;
import com.tencent.mobileqq.emosm.api.ICommonUsedSystemEmojiManagerService;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticon.EmojiListenerManager;
import com.tencent.mobileqq.emoticon.api.impl.EmojiManagerServiceImpl.SyncFetchEmoticonKeyObserver;
import com.tencent.mobileqq.emoticonview.EmoticonRecDressup;
import com.tencent.mobileqq.emoticonview.EmotionPanelConstans;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
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
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.pb.emosm.ComicIPSite.ModuleInfo;
import com.tencent.pb.emosm.ComicIPSite.ModuleReq;
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

public class EmoticonHandler
  extends BusinessHandler
  implements IEmoticonHandler
{
  public static final String a = "com.tencent.mobileqq.app.EmoticonHandler";
  private AtomicInteger b = new AtomicInteger();
  private ConcurrentHashMap<Integer, List<EmosmPb.SubCmd0x2RspFetchTab.TabInfo>> c = new ConcurrentHashMap();
  private ConcurrentHashMap<Integer, List<EmosmPb.SubCmd0x2RspFetchTab.TabInfo>> d = new ConcurrentHashMap();
  private ConcurrentHashMap<Integer, List<EmosmPb.SubCmd0x2RspFetchTab.TabInfo>> e = new ConcurrentHashMap();
  private ConcurrentHashMap<Integer, List<String>> f = new ConcurrentHashMap();
  private CopyOnWriteArrayList<EmojiManagerServiceImpl.SyncFetchEmoticonKeyObserver> g = new CopyOnWriteArrayList();
  private AppInterface h;
  
  public EmoticonHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.h = paramAppInterface;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, List<EmosmPb.SubCmd0x2RspFetchTab.TabInfo> paramList1, List<EmosmPb.SubCmd0x2RspFetchTab.TabInfo> paramList2, List<EmosmPb.SubCmd0x2RspFetchTab.TabInfo> paramList3, ArrayList<String> paramArrayList, int paramInt4)
  {
    if (paramList1 != null)
    {
      if (paramList2 == null) {
        return;
      }
      if (this.c.get(Integer.valueOf(paramInt2)) != null) {
        ((List)this.c.get(Integer.valueOf(paramInt2))).addAll(paramList1);
      } else {
        this.c.put(Integer.valueOf(paramInt2), paramList1);
      }
      if (this.d.get(Integer.valueOf(paramInt2)) != null) {
        ((List)this.d.get(Integer.valueOf(paramInt2))).addAll(paramList2);
      } else {
        this.d.put(Integer.valueOf(paramInt2), paramList2);
      }
      if (this.e.get(Integer.valueOf(paramInt2)) != null) {
        ((List)this.e.get(Integer.valueOf(paramInt2))).addAll(paramList3);
      } else {
        this.e.put(Integer.valueOf(paramInt2), paramList3);
      }
      paramList1 = new ArrayList();
      int i = paramArrayList.size() - 1;
      while (i >= 0)
      {
        paramList1.add(paramArrayList.get(i));
        i -= 1;
      }
      if (this.f.get(Integer.valueOf(paramInt2)) != null) {
        ((List)this.f.get(Integer.valueOf(paramInt2))).addAll(paramList1);
      } else {
        this.f.put(Integer.valueOf(paramInt2), paramList1);
      }
      if (QLog.isColorLevel())
      {
        QLog.d("EmoticonHandler", 2, "--------secend fetch--------:");
        a(paramInt2, paramArrayList);
      }
      a(paramInt4, paramInt3, paramInt1, paramInt2);
    }
  }
  
  private void a(int paramInt1, EmoticonResp paramEmoticonResp, int paramInt2, List<EmosmPb.SubCmd0x2RspFetchTab.TabInfo> paramList)
  {
    if (paramList == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = paramList;
    if (this.c.get(Integer.valueOf(paramInt2)) != null)
    {
      ((List)this.c.get(Integer.valueOf(paramInt2))).addAll(paramList);
      localObject1 = (List)this.c.remove(Integer.valueOf(paramInt2));
    }
    paramList = ((List)localObject1).iterator();
    while (paramList.hasNext())
    {
      Object localObject2 = (EmosmPb.SubCmd0x2RspFetchTab.TabInfo)paramList.next();
      localObject1 = new EmoticonPackage();
      ((EmoticonPackage)localObject1).epId = String.valueOf(((EmosmPb.SubCmd0x2RspFetchTab.TabInfo)localObject2).uint32_tab_id.get());
      ((EmoticonPackage)localObject1).expiretime = ((EmosmPb.SubCmd0x2RspFetchTab.TabInfo)localObject2).fixed32_expire_time.get();
      boolean bool;
      if (((EmosmPb.SubCmd0x2RspFetchTab.TabInfo)localObject2).uint32_flags.get() == 1) {
        bool = true;
      } else {
        bool = false;
      }
      ((EmoticonPackage)localObject1).valid = bool;
      ((EmoticonPackage)localObject1).wordingId = ((EmosmPb.SubCmd0x2RspFetchTab.TabInfo)localObject2).int32_wording_id.get();
      ((EmoticonPackage)localObject1).name = ((EmosmPb.SubCmd0x2RspFetchTab.TabInfo)localObject2).str_tab_name.get();
      if (paramInt1 == 0) {
        ((EmoticonPackage)localObject1).aio = true;
      } else if (paramInt1 == 1) {
        ((EmoticonPackage)localObject1).kandian = true;
      }
      localArrayList.add(localObject1);
      if (!((EmoticonPackage)localObject1).valid)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("TYPE_EMOSM_PS_FETCH: normal emotion ep not valid ; ep = ");
        ((StringBuilder)localObject2).append(localObject1);
        QLog.e("EmoticonHandler", 1, ((StringBuilder)localObject2).toString());
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("TYPE_EMOSM_PS_FETCH: normal emotion ep = ");
        ((StringBuilder)localObject2).append(localObject1);
        QLog.d("EmoticonHandler", 2, ((StringBuilder)localObject2).toString());
      }
    }
    paramEmoticonResp.data = localArrayList;
  }
  
  private void a(int paramInt1, EmoticonResp paramEmoticonResp, int paramInt2, List<EmosmPb.SubCmd0x2RspFetchTab.TabInfo> paramList, ArrayList<String> paramArrayList)
  {
    if (paramList == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = paramList;
    if (this.e.get(Integer.valueOf(paramInt2)) != null)
    {
      ((List)this.e.get(Integer.valueOf(paramInt2))).addAll(paramList);
      localObject1 = (List)this.e.remove(Integer.valueOf(paramInt2));
    }
    paramList = ((List)localObject1).iterator();
    while (paramList.hasNext())
    {
      Object localObject2 = (EmosmPb.SubCmd0x2RspFetchTab.TabInfo)paramList.next();
      localObject1 = new EmoticonPackage();
      ((EmoticonPackage)localObject1).epId = String.valueOf(((EmosmPb.SubCmd0x2RspFetchTab.TabInfo)localObject2).uint32_tab_id.get());
      ((EmoticonPackage)localObject1).expiretime = ((EmosmPb.SubCmd0x2RspFetchTab.TabInfo)localObject2).fixed32_expire_time.get();
      boolean bool;
      if (((EmosmPb.SubCmd0x2RspFetchTab.TabInfo)localObject2).uint32_flags.get() == 1) {
        bool = true;
      } else {
        bool = false;
      }
      ((EmoticonPackage)localObject1).valid = bool;
      ((EmoticonPackage)localObject1).wordingId = ((EmosmPb.SubCmd0x2RspFetchTab.TabInfo)localObject2).int32_wording_id.get();
      ((EmoticonPackage)localObject1).name = ((EmosmPb.SubCmd0x2RspFetchTab.TabInfo)localObject2).str_tab_name.get();
      ((EmoticonPackage)localObject1).jobType = 4;
      if (paramInt1 == 0) {
        ((EmoticonPackage)localObject1).aio = true;
      } else if (paramInt1 == 1) {
        ((EmoticonPackage)localObject1).kandian = true;
      }
      localArrayList.add(localObject1);
      if (!((EmoticonPackage)localObject1).valid)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("TYPE_EMOSM_PS_FETCH: small emotion ep not valid ; ep = ");
        ((StringBuilder)localObject2).append(localObject1);
        QLog.e("EmoticonHandler", 1, ((StringBuilder)localObject2).toString());
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("TYPE_EMOSM_PS_FETCH: small emotion ep = ");
        ((StringBuilder)localObject2).append(localObject1);
        QLog.d("EmoticonHandler", 2, ((StringBuilder)localObject2).toString());
      }
    }
    paramEmoticonResp.smallEmoticonData = localArrayList;
    paramEmoticonResp.tabOrderList = ((List)this.f.remove(Integer.valueOf(paramInt2)));
    if (paramEmoticonResp.tabOrderList == null) {
      paramEmoticonResp.tabOrderList = new ArrayList();
    }
    paramInt1 = paramArrayList.size() - 1;
    while (paramInt1 >= 0)
    {
      paramEmoticonResp.tabOrderList.add(paramArrayList.get(paramInt1));
      paramInt1 -= 1;
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
    if (paramRspBody.msg_subcmd0x19_rsp.has())
    {
      EmosmPb.SubCmd0x19Rsp localSubCmd0x19Rsp = (EmosmPb.SubCmd0x19Rsp)paramRspBody.msg_subcmd0x19_rsp.get();
      int i = localSubCmd0x19Rsp.uint32_package_id.get();
      if (QLog.isColorLevel())
      {
        paramRspBody = new StringBuilder();
        paramRspBody.append("TYPE_EMOSM_IP_SITE_INFORMATION id = ");
        paramRspBody.append(i);
        QLog.i("EmoticonHandler", 2, paramRspBody.toString());
      }
      IEmoticonManagerService localIEmoticonManagerService = (IEmoticonManagerService)this.h.getRuntimeService(IEmoticonManagerService.class, "");
      EmoticonPackage localEmoticonPackage = localIEmoticonManagerService.syncFindEmoticonPackageById(String.valueOf(i), paramInt);
      if (localEmoticonPackage != null)
      {
        localEmoticonPackage.ipUrl = localSubCmd0x19Rsp.str_ip_url.get();
        localEmoticonPackage.ipName = localSubCmd0x19Rsp.str_ip_name.get();
        localEmoticonPackage.ipDetail = localSubCmd0x19Rsp.str_ip_detail.get();
        String str = localSubCmd0x19Rsp.str_op_name.get();
        paramRspBody = str;
        if (TextUtils.isEmpty(str)) {
          paramRspBody = HardCodeUtil.a(2131897791);
        }
        localEmoticonPackage.ipOpName = paramRspBody;
        localEmoticonPackage.ipJumpUrl = localSubCmd0x19Rsp.str_jump_url.get();
        long l;
        if (localSubCmd0x19Rsp.fixed32_time.get() == 0) {
          l = 86400L;
        } else {
          l = localSubCmd0x19Rsp.fixed32_time.get();
        }
        localEmoticonPackage.ipReqTime = l;
        localIEmoticonManagerService.saveEmoticonPackage(localEmoticonPackage);
      }
    }
  }
  
  private void a(int paramInt, EmosmPb.RspBody paramRspBody, IEmoticonManagerService paramIEmoticonManagerService)
  {
    paramRspBody = (EmosmPb.SubCmd0x5RspBQRecommend)paramRspBody.msg_subcmd0x5_recommend.get();
    boolean bool1 = paramRspBody.bool_update_flag.get();
    if (bool1)
    {
      int i = paramRspBody.int32_last_recommend_version.get();
      Object localObject = this.h.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("recommendEmotion_sp_lastversion");
      localStringBuilder.append(this.h.getCurrentAccountUin());
      ((SharedPreferences.Editor)localObject).putInt(localStringBuilder.toString(), i);
      ((SharedPreferences.Editor)localObject).putBoolean("isClickRecommendRedpoint", false);
      ((SharedPreferences.Editor)localObject).putLong("recommendRedpointStartTime", System.currentTimeMillis());
      ((SharedPreferences.Editor)localObject).putInt("recommendSeqinterval", paramRspBody.int32_req_frequency.get());
      ((SharedPreferences.Editor)localObject).putInt("recommendRuleId", paramRspBody.int32_ruleid.get());
      ((SharedPreferences.Editor)localObject).apply();
      boolean bool2 = paramRspBody.bool_recommend_show_flag.get();
      BaseApplication.getContext().getSharedPreferences("clubContentVersion", 0).edit().putBoolean("force_to_recommend_panel_sp", bool2).apply();
      paramIEmoticonManagerService.clearAllRecommendExposeNum();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("recommend info : lastVersion = ");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(";seqFrequncy = ");
        ((StringBuilder)localObject).append(paramRspBody.int32_req_frequency.get());
        ((StringBuilder)localObject).append(";isForceToRecommend = ");
        ((StringBuilder)localObject).append(bool2);
        QLog.d("EmoticonHandler", 2, ((StringBuilder)localObject).toString());
      }
      paramIEmoticonManagerService.saveAndUpdateRecommendEmosInfo(paramRspBody, paramInt);
    }
    if (QLog.isColorLevel())
    {
      paramRspBody = new StringBuilder();
      paramRspBody.append("recommend update flag = ");
      paramRspBody.append(bool1);
      QLog.d("EmoticonHandler", 2, paramRspBody.toString());
    }
  }
  
  private void a(int paramInt, ArrayList<String> paramArrayList)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("svr emoticon tab order list ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" =");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = ((IEmosmService)QRoute.api(IEmosmService.class)).obtainStringBuilder();
    localStringBuilder.append((String)localObject);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      localStringBuilder.append((String)paramArrayList.next());
      localStringBuilder.append(",");
      if (localStringBuilder.length() >= 500)
      {
        QLog.d("EmoticonHandler", 1, localStringBuilder.toString());
        localStringBuilder.setLength(((String)localObject).length());
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
        StringBuilder localStringBuilder1 = new StringBuilder();
        int i = 0;
        while (i < paramRspBody.size())
        {
          localObject = (EmosmPb.SmallYellowItem)paramRspBody.get(i);
          if ((QLog.isColorLevel()) && (localObject != null))
          {
            StringBuilder localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("type = ");
            localStringBuilder2.append(((EmosmPb.SmallYellowItem)localObject).type.get());
            localStringBuilder2.append(";id = ");
            localStringBuilder2.append(((EmosmPb.SmallYellowItem)localObject).id.get());
            localStringBuilder2.append(";ts =");
            localStringBuilder2.append(((EmosmPb.SmallYellowItem)localObject).ts.get());
            localStringBuilder1.append(localStringBuilder2.toString());
          }
          i += 1;
        }
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("commonused systememoji item : ");
        ((StringBuilder)localObject).append(localStringBuilder1.toString());
        QLog.d("EmoticonHandler", 2, ((StringBuilder)localObject).toString());
      }
      QLog.d("EmoticonHandler", 1, "commonused back");
      ((ICommonUsedSystemEmojiManagerService)this.h.getRuntimeService(ICommonUsedSystemEmojiManagerService.class, "")).updateItemInfo(paramRspBody);
      return;
    }
    QLog.e("EmoticonHandler", 1, "handleCommonUseInfo ItemInfo = null");
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, boolean paramBoolean, int paramInt1, int paramInt2, EmoticonResp paramEmoticonResp)
  {
    Object localObject = (IEmoticonManagerService)this.h.getRuntimeService(IEmoticonManagerService.class, "");
    if (paramInt1 == 2)
    {
      if (paramBoolean)
      {
        ThreadManagerV2.excute(new EmoticonHandler.1(this, (IEmoticonManagerService)localObject, paramEmoticonResp, paramInt2), 32, null, true);
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("fetchEmoticonPackages failed: ");
      ((StringBuilder)localObject).append(paramFromServiceMsg.getResultCode());
      QLog.e("EmoticonHandler", 1, ((StringBuilder)localObject).toString());
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
        ((IEmoticonManagerService)localObject).saveEmoticon(localEmoticon);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("epId:");
          localStringBuilder.append(localEmoticon.epId);
          localStringBuilder.append(",eId:");
          localStringBuilder.append(localEmoticon.eId);
          localStringBuilder.append(",key:");
          localStringBuilder.append(localEmoticon.encryptKey);
          QLog.d("EmoticonHandler", 2, localStringBuilder.toString());
          continue;
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("fetch key error:");
          paramFromServiceMsg.append(paramEmoticonResp.resultcode);
          QLog.i("EmoticonHandler", 1, paramFromServiceMsg.toString());
        }
      }
      paramFromServiceMsg = this.g.iterator();
      while (paramFromServiceMsg.hasNext()) {
        ((EmojiManagerServiceImpl.SyncFetchEmoticonKeyObserver)paramFromServiceMsg.next()).a(paramBoolean, paramInt1, paramEmoticonResp);
      }
    }
    notifyUI(paramInt1, paramBoolean, paramEmoticonResp);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, int paramInt, EmoticonResp paramEmoticonResp, IEmoticonManagerService paramIEmoticonManagerService)
  {
    paramToServiceMsg = paramToServiceMsg.extraData.getIntegerArrayList("EmosmPackageIds");
    if (paramToServiceMsg != null)
    {
      if (paramToServiceMsg.size() == 0) {
        return;
      }
      paramEmoticonResp.ids = paramToServiceMsg;
      paramToServiceMsg = paramToServiceMsg.iterator();
      while (paramToServiceMsg.hasNext())
      {
        paramEmoticonResp = String.valueOf((Integer)paramToServiceMsg.next());
        paramIEmoticonManagerService.removeTabEmoticonPackage(paramEmoticonResp, paramInt);
        paramEmoticonResp = paramIEmoticonManagerService.syncFindEmoticonPackageById(paramEmoticonResp, paramInt);
        EmojiListenerManager.a().a(paramEmoticonResp);
      }
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      i = 1;
    } else {
      i = 0;
    }
    boolean bool;
    if (i != 0)
    {
      try
      {
        paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramFromServiceMsg.uint32_result.has()) && (QLog.isColorLevel()))
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("CMD_EMOSM_CHECK_KANDIAN_OIDB uint32_result = ");
          paramToServiceMsg.append(paramFromServiceMsg.uint32_result.get());
          QLog.d("EmoticonHandler", 2, paramToServiceMsg.toString());
        }
        if ((!paramFromServiceMsg.uint32_result.has()) || (paramFromServiceMsg.uint32_result.get() != 0)) {
          break label530;
        }
        paramToServiceMsg = new oidb_0x5eb.RspBody();
        paramToServiceMsg.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
        j = paramToServiceMsg.rpt_msg_uin_data.size();
        if (!QLog.isColorLevel()) {
          break label506;
        }
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("CMD_EMOSM_CHECK_KANDIAN_OIDB infoNum = ");
        paramFromServiceMsg.append(j);
        QLog.d("EmoticonHandler", 2, paramFromServiceMsg.toString());
      }
      catch (Exception paramToServiceMsg)
      {
        int j;
        label230:
        QLog.e("EmoticonHandler", 1, paramToServiceMsg.getMessage());
        return;
      }
      if (i < j)
      {
        if ((((oidb_0x5eb.UdcUinData)paramToServiceMsg.rpt_msg_uin_data.get(i)).uint32_vas_emoticon_usage_info.get() & 0x1) != 1) {
          break label515;
        }
        bool = true;
        if (!bool) {
          break label521;
        }
        paramFromServiceMsg = this.h.getApplication().getSharedPreferences("mobileQQ", 0).edit();
        paramObject = new StringBuilder();
        paramObject.append("emosm_has_download_emosmpackage_kandian_tag_");
        paramObject.append(this.h.getCurrentAccountUin());
        paramFromServiceMsg.putBoolean(paramObject.toString(), bool).commit();
        break label521;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("CMD_EMOSM_CHECK_KANDIAN_OIDB, needToFetchEmosmList = ");
        paramToServiceMsg.append(bool);
        QLog.w("EmoticonHandler", 2, paramToServiceMsg.toString());
      }
      if (bool)
      {
        if (QLog.isColorLevel()) {
          QLog.w("EmoticonHandler", 2, "CMD_EMOSM_CHECK_KANDIAN_OIDB, initEmoticon");
        }
        a(0, 0, 1, 0);
        return;
        i = paramToServiceMsg.extraData.getInt("EmoticonRetry");
        paramObject = new StringBuilder();
        paramObject.append("CMD_EMOSM_CHECK_KANDIAN_OIDB, error:");
        paramObject.append(paramFromServiceMsg.getResultCode());
        QLog.e("EmoticonHandler", 1, paramObject.toString());
        if ((paramFromServiceMsg.getResultCode() == 1002) && (i < 2))
        {
          if (QLog.isColorLevel())
          {
            paramFromServiceMsg = new StringBuilder();
            paramFromServiceMsg.append("CMD_EMOSM_CHECK_KANDIAN_OIDB try index: ");
            paramFromServiceMsg.append(i);
            QLog.d("EmoticonHandler", 2, paramFromServiceMsg.toString());
          }
          paramToServiceMsg.extraData.putInt("EmoticonRetry", i + 1);
          super.sendPbReq(paramToServiceMsg);
        }
      }
      return;
      label506:
      i = 0;
      bool = false;
      break;
      label515:
      bool = false;
      break label230;
      label521:
      i += 1;
      break;
      label530:
      bool = false;
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    boolean bool2 = paramFromServiceMsg.isSuccess();
    int m = paramToServiceMsg.extraData.getInt("EmosmPackageId");
    int i = paramToServiceMsg.extraData.getInt("EmosmSubCmd");
    Object localObject1 = String.valueOf(paramToServiceMsg.getAttribute("_tag_LOGSTR"));
    Object localObject2 = (ArrayList)paramToServiceMsg.extraData.getSerializable("EmosmEmos");
    EmoticonResp localEmoticonResp = new EmoticonResp();
    localEmoticonResp.resultcode = paramFromServiceMsg.getResultCode();
    localEmoticonResp.data = ((List)localObject2);
    localEmoticonResp.epId = m;
    localEmoticonResp.keySeq = ((String)localObject1);
    localEmoticonResp.timeoutReason = BaseMessageHandler.a(paramFromServiceMsg);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("key_seq=");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(" isSuccess=");
      ((StringBuilder)localObject2).append(bool2);
      ((StringBuilder)localObject2).append(" resultCode=");
      ((StringBuilder)localObject2).append(paramFromServiceMsg.getResultCode());
      ((StringBuilder)localObject2).append(" timeout:");
      ((StringBuilder)localObject2).append(localEmoticonResp.timeoutReason);
      ((StringBuilder)localObject2).append(",subcmd = ");
      ((StringBuilder)localObject2).append(i);
      QLog.d("EmoticonHandler", 2, ((StringBuilder)localObject2).toString());
    }
    int j = 0;
    boolean bool1 = false;
    if (bool2) {
      localObject1 = new EmosmPb.RspBody();
    }
    try
    {
      paramArrayOfByte = (EmosmPb.RspBody)((EmosmPb.RspBody)localObject1).mergeFrom(paramArrayOfByte);
    }
    catch (Exception paramArrayOfByte)
    {
      label254:
      int k;
      break label254;
    }
    localEmoticonResp.resultcode = -1;
    paramArrayOfByte = null;
    if (paramArrayOfByte != null)
    {
      j = paramArrayOfByte.int32_result.get();
      k = paramArrayOfByte.uint32_business_id.get();
      localEmoticonResp.resultcode = j;
      if (j != 0)
      {
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("emosm...fetch key 回包 sso 成功 ，server 失败，result = ");
          paramToServiceMsg.append(j);
          QLog.d("EmoticonHandler", 2, paramToServiceMsg.toString());
        }
        bool1 = false;
        j = i;
      }
      else
      {
        localObject1 = (IEmoticonManagerService)this.h.getRuntimeService(IEmoticonManagerService.class, "");
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              if (i != 5)
              {
                if (i != 6)
                {
                  if (i != 7)
                  {
                    if (i != 9)
                    {
                      if (i != 17)
                      {
                        if (i != 20)
                        {
                          if (i != 24)
                          {
                            if (i != 25)
                            {
                              bool1 = bool2;
                              j = i;
                            }
                            else
                            {
                              a(k, paramArrayOfByte);
                              bool1 = bool2;
                              j = i;
                            }
                          }
                          else
                          {
                            j = paramToServiceMsg.extraData.getInt("tabId");
                            paramToServiceMsg = new EmoticonRecDressup();
                            paramToServiceMsg.hasRecommendDressup = paramArrayOfByte.msg_subcmd0x18_rsp.bool_jump_flag.get();
                            paramToServiceMsg.authorId = paramArrayOfByte.msg_subcmd0x18_rsp.uint32_author_id.get();
                            paramToServiceMsg.saveEmotionRecommend(j);
                            bool1 = bool2;
                            j = i;
                            if (QLog.isColorLevel())
                            {
                              paramArrayOfByte = new StringBuilder();
                              paramArrayOfByte.append("fetchEmoticonRecommend return ");
                              paramArrayOfByte.append(paramToServiceMsg.toString());
                              QLog.i("EmoticonHandler", 2, paramArrayOfByte.toString());
                              bool1 = bool2;
                              j = i;
                            }
                          }
                        }
                        else
                        {
                          a(paramArrayOfByte);
                          bool1 = bool2;
                          j = i;
                        }
                      }
                      else
                      {
                        a(paramToServiceMsg, k, localEmoticonResp, (IEmoticonManagerService)localObject1);
                        bool1 = bool2;
                        j = i;
                      }
                    }
                    else
                    {
                      localEmoticonResp.data = ((EmosmPb.SubCmd0x9BqAssocRsp)paramArrayOfByte.msg_subcmd0x9_rsp.get()).rpt_assoc_bqs.get();
                      if (((EmosmPb.SubCmd0x9BqAssocRsp)paramArrayOfByte.msg_subcmd0x9_rsp.get()).i32_reset_exposure_flag.get() == 1) {
                        bool1 = true;
                      }
                      localEmoticonResp.resetKeywordExpose = bool1;
                      bool1 = bool2;
                      j = i;
                    }
                  }
                  else
                  {
                    localEmoticonResp.emoticonId = paramToServiceMsg.extraData.getString("EmoticonId");
                    localEmoticonResp.delEpId = ((EmosmPb.SubCmd0x7Rsp)paramArrayOfByte.msg_subcmd0x7_rsp.get()).int32_auth_detail.get();
                    localEmoticonResp.keySeq = ((EmosmPb.SubCmd0x7Rsp)paramArrayOfByte.msg_subcmd0x7_rsp.get()).str_auth_msg.get();
                    bool1 = bool2;
                    j = i;
                    if (paramToServiceMsg.extraData.getBoolean("EmosmSubCmdFllow"))
                    {
                      j = 107;
                      bool1 = bool2;
                    }
                  }
                }
                else
                {
                  localEmoticonResp.emoticonId = paramToServiceMsg.extraData.getString("EmoticonId");
                  localEmoticonResp.delEpId = ((EmosmPb.SubCmd0x6Rsp)paramArrayOfByte.msg_subcmd0x6_collect_auth.get()).int32_auth_detail.get();
                  localEmoticonResp.keySeq = ((EmosmPb.SubCmd0x6Rsp)paramArrayOfByte.msg_subcmd0x6_collect_auth.get()).str_auth_msg.get();
                  bool1 = bool2;
                  j = i;
                }
              }
              else
              {
                a(k, paramArrayOfByte, (IEmoticonManagerService)localObject1);
                bool1 = bool2;
                j = i;
              }
            }
            else
            {
              a(m, localEmoticonResp, paramArrayOfByte);
              bool1 = bool2;
              j = i;
            }
          }
          else
          {
            bool1 = bool2;
            j = i;
            if (!a(paramToServiceMsg, k, localEmoticonResp, paramArrayOfByte)) {}
          }
        }
        else
        {
          localEmoticonResp.data = null;
          localEmoticonResp.delEpId = ((EmosmPb.SubCmd0x1RspDelTab)paramArrayOfByte.msg_subcmd0x1_rsp_deltab.get()).uint32_tab_id.get();
          paramToServiceMsg = String.valueOf(localEmoticonResp.delEpId);
          ((IEmoticonManagerService)localObject1).removeTabEmoticonPackage(paramToServiceMsg, k);
          paramToServiceMsg = ((IEmoticonManagerService)localObject1).syncFindEmoticonPackageById(paramToServiceMsg, k);
          EmojiListenerManager.a().a(paramToServiceMsg);
          j = i;
          bool1 = bool2;
        }
      }
      i = j;
      j = k;
    }
    else
    {
      localEmoticonResp.resultcode = -1;
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("emosm...fetch key 回包 异常 subcmd = ");
        paramToServiceMsg.append(i);
        QLog.d("EmoticonHandler", 2, paramToServiceMsg.toString());
      }
      bool1 = false;
    }
    break label1051;
    if (a(paramToServiceMsg, paramFromServiceMsg, i)) {
      return;
    }
    j = 0;
    bool1 = bool2;
    label1051:
    a(paramFromServiceMsg, bool1, i, j, localEmoticonResp);
  }
  
  /* Error */
  private void a(ToServiceMsg paramToServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: ldc 98
    //   2: astore 12
    //   4: new 885	com/tencent/pb/emosm/ComicIPSite$ModuleRsp
    //   7: dup
    //   8: invokespecial 886	com/tencent/pb/emosm/ComicIPSite$ModuleRsp:<init>	()V
    //   11: aload_2
    //   12: checkcast 646	[B
    //   15: checkcast 646	[B
    //   18: invokevirtual 887	com/tencent/pb/emosm/ComicIPSite$ModuleRsp:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   21: checkcast 885	com/tencent/pb/emosm/ComicIPSite$ModuleRsp
    //   24: astore 11
    //   26: aload 11
    //   28: getfield 890	com/tencent/pb/emosm/ComicIPSite$ModuleRsp:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   31: invokevirtual 174	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   34: istore_3
    //   35: aload 11
    //   37: getfield 893	com/tencent/pb/emosm/ComicIPSite$ModuleRsp:sub_cmd	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   40: invokevirtual 174	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   43: iconst_1
    //   44: if_icmpeq +4 -> 48
    //   47: return
    //   48: iload_3
    //   49: ifne +1660 -> 1709
    //   52: aload_1
    //   53: getfield 610	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   56: ldc_w 894
    //   59: invokevirtual 826	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   62: astore_1
    //   63: aload 11
    //   65: getfield 897	com/tencent/pb/emosm/ComicIPSite$ModuleRsp:ipId	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   68: invokevirtual 174	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   71: istore 6
    //   73: aload 11
    //   75: getfield 899	com/tencent/pb/emosm/ComicIPSite$ModuleRsp:ipName	Lcom/tencent/mobileqq/pb/PBStringField;
    //   78: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   81: astore 19
    //   83: aload 11
    //   85: getfield 902	com/tencent/pb/emosm/ComicIPSite$ModuleRsp:ipDesc	Lcom/tencent/mobileqq/pb/PBStringField;
    //   88: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   91: astore 20
    //   93: aload 11
    //   95: getfield 904	com/tencent/pb/emosm/ComicIPSite$ModuleRsp:ipUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   98: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   101: astore 21
    //   103: aload 11
    //   105: getfield 907	com/tencent/pb/emosm/ComicIPSite$ModuleRsp:itemSize	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   108: invokevirtual 174	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   111: istore 7
    //   113: aload 11
    //   115: getfield 910	com/tencent/pb/emosm/ComicIPSite$ModuleRsp:strType	Lcom/tencent/mobileqq/pb/PBStringField;
    //   118: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   121: astore 22
    //   123: aload 11
    //   125: getfield 913	com/tencent/pb/emosm/ComicIPSite$ModuleRsp:extId	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   128: invokevirtual 174	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   131: istore_3
    //   132: aload 11
    //   134: getfield 916	com/tencent/pb/emosm/ComicIPSite$ModuleRsp:extStr	Lcom/tencent/mobileqq/pb/PBStringField;
    //   137: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   140: astore 23
    //   142: aload 11
    //   144: getfield 919	com/tencent/pb/emosm/ComicIPSite$ModuleRsp:ipLogo	Lcom/tencent/mobileqq/pb/PBStringField;
    //   147: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   150: astore_2
    //   151: aload 11
    //   153: getfield 922	com/tencent/pb/emosm/ComicIPSite$ModuleRsp:ipContent	Lcom/tencent/mobileqq/pb/PBStringField;
    //   156: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   159: astore 24
    //   161: aload 11
    //   163: getfield 925	com/tencent/pb/emosm/ComicIPSite$ModuleRsp:requestInterval	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   166: invokevirtual 174	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   169: ifne +11 -> 180
    //   172: ldc2_w 356
    //   175: lstore 8
    //   177: goto +14 -> 191
    //   180: aload 11
    //   182: getfield 925	com/tencent/pb/emosm/ComicIPSite$ModuleRsp:requestInterval	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   185: invokevirtual 174	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   188: i2l
    //   189: lstore 8
    //   191: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   194: ifeq +40 -> 234
    //   197: new 198	java/lang/StringBuilder
    //   200: dup
    //   201: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   204: astore 13
    //   206: aload 13
    //   208: ldc_w 927
    //   211: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: pop
    //   215: aload 13
    //   217: lload 8
    //   219: invokevirtual 543	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: ldc 98
    //   225: iconst_2
    //   226: aload 13
    //   228: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   234: new 78	java/util/ArrayList
    //   237: dup
    //   238: invokespecial 79	java/util/ArrayList:<init>	()V
    //   241: astore 25
    //   243: ldc_w 929
    //   246: aload 22
    //   248: invokevirtual 932	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   251: ifeq +114 -> 365
    //   254: aload 11
    //   256: getfield 935	com/tencent/pb/emosm/ComicIPSite$ModuleRsp:gxzbList	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   259: invokevirtual 518	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   262: astore 13
    //   264: iconst_0
    //   265: istore 4
    //   267: iload 4
    //   269: aload 13
    //   271: invokeinterface 262 1 0
    //   276: if_icmpge +1507 -> 1783
    //   279: aload 13
    //   281: iload 4
    //   283: invokeinterface 263 2 0
    //   288: checkcast 937	com/tencent/pb/emosm/ComicIPSite$Gxzb
    //   291: astore 14
    //   293: aload 25
    //   295: new 939	com/tencent/mobileqq/data/IPSiteModel$Gxzb
    //   298: dup
    //   299: aload 14
    //   301: getfield 942	com/tencent/pb/emosm/ComicIPSite$Gxzb:appId	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   304: invokevirtual 174	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   307: aload 14
    //   309: getfield 945	com/tencent/pb/emosm/ComicIPSite$Gxzb:appName	Lcom/tencent/mobileqq/pb/PBStringField;
    //   312: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   315: aload 14
    //   317: getfield 948	com/tencent/pb/emosm/ComicIPSite$Gxzb:cover	Lcom/tencent/mobileqq/pb/PBStringField;
    //   320: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   323: aload 14
    //   325: getfield 951	com/tencent/pb/emosm/ComicIPSite$Gxzb:feeType	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   328: invokevirtual 174	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   331: aload 14
    //   333: getfield 953	com/tencent/pb/emosm/ComicIPSite$Gxzb:id	Lcom/tencent/mobileqq/pb/PBStringField;
    //   336: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   339: aload 14
    //   341: getfield 955	com/tencent/pb/emosm/ComicIPSite$Gxzb:name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   344: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   347: invokespecial 958	com/tencent/mobileqq/data/IPSiteModel$Gxzb:<init>	(ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   350: invokeinterface 196 2 0
    //   355: pop
    //   356: iload 4
    //   358: iconst_1
    //   359: iadd
    //   360: istore 4
    //   362: goto -95 -> 267
    //   365: aload_2
    //   366: astore 16
    //   368: ldc_w 960
    //   371: aload 22
    //   373: invokevirtual 932	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   376: istore 10
    //   378: iload 10
    //   380: ifeq +269 -> 649
    //   383: aload 12
    //   385: astore_2
    //   386: aload 11
    //   388: getfield 963	com/tencent/pb/emosm/ComicIPSite$ModuleRsp:gameList	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   391: invokevirtual 518	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   394: astore 14
    //   396: iconst_0
    //   397: istore 4
    //   399: aload_1
    //   400: astore 13
    //   402: aload 12
    //   404: astore_1
    //   405: aload_1
    //   406: astore_2
    //   407: iload 4
    //   409: aload 14
    //   411: invokeinterface 262 1 0
    //   416: if_icmpge +1383 -> 1799
    //   419: aload_1
    //   420: astore_2
    //   421: aload 14
    //   423: iload 4
    //   425: invokeinterface 263 2 0
    //   430: checkcast 965	com/tencent/pb/emosm/ComicIPSite$Game
    //   433: astore 15
    //   435: aload_1
    //   436: astore_2
    //   437: aload 15
    //   439: getfield 968	com/tencent/pb/emosm/ComicIPSite$Game:rich	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   442: invokevirtual 518	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   445: astore 12
    //   447: aload_1
    //   448: astore_2
    //   449: new 78	java/util/ArrayList
    //   452: dup
    //   453: invokespecial 79	java/util/ArrayList:<init>	()V
    //   456: astore 17
    //   458: iconst_0
    //   459: istore 5
    //   461: aload_1
    //   462: astore_2
    //   463: iload 5
    //   465: aload 12
    //   467: invokeinterface 262 1 0
    //   472: if_icmpge +101 -> 573
    //   475: aload_1
    //   476: astore_2
    //   477: aload 12
    //   479: iload 5
    //   481: invokeinterface 263 2 0
    //   486: checkcast 970	com/tencent/pb/emosm/ComicIPSite$GameRich
    //   489: astore 18
    //   491: aload_1
    //   492: astore_2
    //   493: aload 17
    //   495: new 972	com/tencent/mobileqq/data/IPSiteModel$GameRich
    //   498: dup
    //   499: aload 18
    //   501: getfield 975	com/tencent/pb/emosm/ComicIPSite$GameRich:anchorFaceUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   504: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   507: aload 18
    //   509: getfield 978	com/tencent/pb/emosm/ComicIPSite$GameRich:anchorId	Lcom/tencent/mobileqq/pb/PBStringField;
    //   512: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   515: aload 18
    //   517: getfield 981	com/tencent/pb/emosm/ComicIPSite$GameRich:anchorName	Lcom/tencent/mobileqq/pb/PBStringField;
    //   520: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   523: aload 18
    //   525: getfield 984	com/tencent/pb/emosm/ComicIPSite$GameRich:coverUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   528: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   531: aload 18
    //   533: getfield 987	com/tencent/pb/emosm/ComicIPSite$GameRich:online	Lcom/tencent/mobileqq/pb/PBStringField;
    //   536: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   539: aload 18
    //   541: getfield 990	com/tencent/pb/emosm/ComicIPSite$GameRich:title	Lcom/tencent/mobileqq/pb/PBStringField;
    //   544: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   547: aload 18
    //   549: getfield 993	com/tencent/pb/emosm/ComicIPSite$GameRich:richJumpUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   552: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   555: invokespecial 996	com/tencent/mobileqq/data/IPSiteModel$GameRich:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   558: invokeinterface 196 2 0
    //   563: pop
    //   564: iload 5
    //   566: iconst_1
    //   567: iadd
    //   568: istore 5
    //   570: goto -109 -> 461
    //   573: aload_1
    //   574: astore_2
    //   575: aload 25
    //   577: new 998	com/tencent/mobileqq/data/IPSiteModel$Game
    //   580: dup
    //   581: aload 15
    //   583: getfield 999	com/tencent/pb/emosm/ComicIPSite$Game:cover	Lcom/tencent/mobileqq/pb/PBStringField;
    //   586: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   589: aload 15
    //   591: getfield 1002	com/tencent/pb/emosm/ComicIPSite$Game:desc	Lcom/tencent/mobileqq/pb/PBStringField;
    //   594: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   597: aload 15
    //   599: getfield 1003	com/tencent/pb/emosm/ComicIPSite$Game:id	Lcom/tencent/mobileqq/pb/PBStringField;
    //   602: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   605: aload 15
    //   607: getfield 1006	com/tencent/pb/emosm/ComicIPSite$Game:jumpUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   610: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   613: aload 15
    //   615: getfield 1007	com/tencent/pb/emosm/ComicIPSite$Game:name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   618: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   621: aload 15
    //   623: getfield 1010	com/tencent/pb/emosm/ComicIPSite$Game:recommDesc	Lcom/tencent/mobileqq/pb/PBStringField;
    //   626: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   629: aload 17
    //   631: invokespecial 1013	com/tencent/mobileqq/data/IPSiteModel$Game:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V
    //   634: invokeinterface 196 2 0
    //   639: pop
    //   640: iload 4
    //   642: iconst_1
    //   643: iadd
    //   644: istore 4
    //   646: goto -241 -> 405
    //   649: ldc 98
    //   651: astore 17
    //   653: aload_1
    //   654: astore 18
    //   656: aload 17
    //   658: astore_2
    //   659: ldc_w 1015
    //   662: aload 22
    //   664: invokevirtual 932	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   667: ifeq +170 -> 837
    //   670: aload 17
    //   672: astore_2
    //   673: aload 11
    //   675: getfield 1018	com/tencent/pb/emosm/ComicIPSite$ModuleRsp:goodsList	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   678: invokevirtual 518	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   681: astore_1
    //   682: iconst_0
    //   683: istore 5
    //   685: aload 11
    //   687: astore 15
    //   689: iload_3
    //   690: istore 4
    //   692: aload 17
    //   694: astore 14
    //   696: aload 18
    //   698: astore 12
    //   700: aload 17
    //   702: astore_2
    //   703: iload 5
    //   705: aload_1
    //   706: invokeinterface 262 1 0
    //   711: if_icmpge +1102 -> 1813
    //   714: aload 17
    //   716: astore_2
    //   717: aload_1
    //   718: iload 5
    //   720: invokeinterface 263 2 0
    //   725: checkcast 1020	com/tencent/pb/emosm/ComicIPSite$Goods
    //   728: astore 12
    //   730: aload 17
    //   732: astore_2
    //   733: aload 25
    //   735: new 1022	com/tencent/mobileqq/data/IPSiteModel$Goods
    //   738: dup
    //   739: aload 12
    //   741: getfield 1023	com/tencent/pb/emosm/ComicIPSite$Goods:cover	Lcom/tencent/mobileqq/pb/PBStringField;
    //   744: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   747: aload 12
    //   749: getfield 1026	com/tencent/pb/emosm/ComicIPSite$Goods:goodsTags	Lcom/tencent/mobileqq/pb/PBStringField;
    //   752: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   755: aload 12
    //   757: getfield 1027	com/tencent/pb/emosm/ComicIPSite$Goods:id	Lcom/tencent/mobileqq/pb/PBStringField;
    //   760: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   763: aload 12
    //   765: getfield 1028	com/tencent/pb/emosm/ComicIPSite$Goods:name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   768: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   771: aload 12
    //   773: getfield 1031	com/tencent/pb/emosm/ComicIPSite$Goods:price	Lcom/tencent/mobileqq/pb/PBStringField;
    //   776: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   779: aload 12
    //   781: getfield 1034	com/tencent/pb/emosm/ComicIPSite$Goods:saleTags	Lcom/tencent/mobileqq/pb/PBStringField;
    //   784: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   787: aload 12
    //   789: getfield 1037	com/tencent/pb/emosm/ComicIPSite$Goods:svipPrice	Lcom/tencent/mobileqq/pb/PBStringField;
    //   792: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   795: aload 12
    //   797: getfield 1040	com/tencent/pb/emosm/ComicIPSite$Goods:url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   800: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   803: aload 12
    //   805: getfield 1043	com/tencent/pb/emosm/ComicIPSite$Goods:moreUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   808: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   811: aload 12
    //   813: getfield 1046	com/tencent/pb/emosm/ComicIPSite$Goods:saleNum	Lcom/tencent/mobileqq/pb/PBStringField;
    //   816: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   819: invokespecial 1049	com/tencent/mobileqq/data/IPSiteModel$Goods:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   822: invokeinterface 196 2 0
    //   827: pop
    //   828: iload 5
    //   830: iconst_1
    //   831: iadd
    //   832: istore 5
    //   834: goto -149 -> 685
    //   837: aload 17
    //   839: astore_2
    //   840: ldc_w 1051
    //   843: aload 22
    //   845: invokevirtual 932	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   848: ifeq +194 -> 1042
    //   851: aload 17
    //   853: astore_2
    //   854: aload 11
    //   856: getfield 1054	com/tencent/pb/emosm/ComicIPSite$ModuleRsp:videoList	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   859: invokevirtual 518	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   862: astore_1
    //   863: iconst_0
    //   864: istore 5
    //   866: aload 11
    //   868: astore 15
    //   870: iload_3
    //   871: istore 4
    //   873: aload 17
    //   875: astore 14
    //   877: aload 18
    //   879: astore 12
    //   881: aload 17
    //   883: astore_2
    //   884: iload 5
    //   886: aload_1
    //   887: invokeinterface 262 1 0
    //   892: if_icmpge +921 -> 1813
    //   895: aload 17
    //   897: astore_2
    //   898: aload_1
    //   899: iload 5
    //   901: invokeinterface 263 2 0
    //   906: checkcast 1056	com/tencent/pb/emosm/ComicIPSite$Video
    //   909: astore 12
    //   911: aload 17
    //   913: astore_2
    //   914: aload 25
    //   916: new 1058	com/tencent/mobileqq/data/IPSiteModel$Video
    //   919: dup
    //   920: aload 12
    //   922: getfield 1059	com/tencent/pb/emosm/ComicIPSite$Video:id	Lcom/tencent/mobileqq/pb/PBStringField;
    //   925: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   928: aload 12
    //   930: getfield 1062	com/tencent/pb/emosm/ComicIPSite$Video:buttonDesc	Lcom/tencent/mobileqq/pb/PBStringField;
    //   933: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   936: aload 12
    //   938: getfield 1065	com/tencent/pb/emosm/ComicIPSite$Video:content	Lcom/tencent/mobileqq/pb/PBStringField;
    //   941: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   944: aload 12
    //   946: getfield 1066	com/tencent/pb/emosm/ComicIPSite$Video:cover	Lcom/tencent/mobileqq/pb/PBStringField;
    //   949: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   952: aload 12
    //   954: getfield 1067	com/tencent/pb/emosm/ComicIPSite$Video:desc	Lcom/tencent/mobileqq/pb/PBStringField;
    //   957: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   960: aload 12
    //   962: getfield 1068	com/tencent/pb/emosm/ComicIPSite$Video:name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   965: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   968: aload 12
    //   970: getfield 1071	com/tencent/pb/emosm/ComicIPSite$Video:endTime	Lcom/tencent/mobileqq/pb/PBStringField;
    //   973: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   976: aload 12
    //   978: getfield 1074	com/tencent/pb/emosm/ComicIPSite$Video:isShow	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   981: invokevirtual 174	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   984: aload 12
    //   986: getfield 1078	com/tencent/pb/emosm/ComicIPSite$Video:newStartTime	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   989: invokevirtual 1081	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   992: aload 12
    //   994: getfield 1084	com/tencent/pb/emosm/ComicIPSite$Video:newEndTime	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   997: invokevirtual 1081	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   1000: aload 12
    //   1002: getfield 1087	com/tencent/pb/emosm/ComicIPSite$Video:redirectUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1005: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1008: aload 12
    //   1010: getfield 1090	com/tencent/pb/emosm/ComicIPSite$Video:videoSource	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1013: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1016: aload 12
    //   1018: getfield 1093	com/tencent/pb/emosm/ComicIPSite$Video:showDate	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1021: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1024: invokespecial 1096	com/tencent/mobileqq/data/IPSiteModel$Video:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1027: invokeinterface 196 2 0
    //   1032: pop
    //   1033: iload 5
    //   1035: iconst_1
    //   1036: iadd
    //   1037: istore 5
    //   1039: goto -173 -> 866
    //   1042: aload 17
    //   1044: astore_2
    //   1045: ldc_w 1098
    //   1048: aload 22
    //   1050: invokevirtual 932	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1053: ifeq +146 -> 1199
    //   1056: aload 17
    //   1058: astore_2
    //   1059: aload 11
    //   1061: getfield 1101	com/tencent/pb/emosm/ComicIPSite$ModuleRsp:bookList	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1064: invokevirtual 518	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   1067: astore_1
    //   1068: iconst_0
    //   1069: istore 5
    //   1071: aload 11
    //   1073: astore 15
    //   1075: iload_3
    //   1076: istore 4
    //   1078: aload 17
    //   1080: astore 14
    //   1082: aload 18
    //   1084: astore 12
    //   1086: aload 17
    //   1088: astore_2
    //   1089: iload 5
    //   1091: aload_1
    //   1092: invokeinterface 262 1 0
    //   1097: if_icmpge +716 -> 1813
    //   1100: aload 17
    //   1102: astore_2
    //   1103: aload_1
    //   1104: iload 5
    //   1106: invokeinterface 263 2 0
    //   1111: checkcast 1103	com/tencent/pb/emosm/ComicIPSite$Book
    //   1114: astore 12
    //   1116: aload 17
    //   1118: astore_2
    //   1119: aload 25
    //   1121: new 1105	com/tencent/mobileqq/data/IPSiteModel$Book
    //   1124: dup
    //   1125: aload 12
    //   1127: getfield 1106	com/tencent/pb/emosm/ComicIPSite$Book:cover	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1130: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1133: aload 12
    //   1135: getfield 1107	com/tencent/pb/emosm/ComicIPSite$Book:desc	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1138: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1141: aload 12
    //   1143: getfield 1108	com/tencent/pb/emosm/ComicIPSite$Book:id	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1146: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1149: aload 12
    //   1151: getfield 1109	com/tencent/pb/emosm/ComicIPSite$Book:jumpUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1154: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1157: aload 12
    //   1159: getfield 1110	com/tencent/pb/emosm/ComicIPSite$Book:name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1162: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1165: aload 12
    //   1167: getfield 1111	com/tencent/pb/emosm/ComicIPSite$Book:recommDesc	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1170: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1173: aload 12
    //   1175: getfield 1114	com/tencent/pb/emosm/ComicIPSite$Book:authorName	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1178: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1181: invokespecial 1115	com/tencent/mobileqq/data/IPSiteModel$Book:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1184: invokeinterface 196 2 0
    //   1189: pop
    //   1190: iload 5
    //   1192: iconst_1
    //   1193: iadd
    //   1194: istore 5
    //   1196: goto -125 -> 1071
    //   1199: aload 11
    //   1201: astore 15
    //   1203: iload_3
    //   1204: istore 4
    //   1206: aload 17
    //   1208: astore 14
    //   1210: aload 18
    //   1212: astore 12
    //   1214: aload 17
    //   1216: astore_2
    //   1217: ldc_w 1117
    //   1220: aload 22
    //   1222: invokevirtual 932	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1225: ifeq +588 -> 1813
    //   1228: aload 17
    //   1230: astore_2
    //   1231: aload 11
    //   1233: getfield 1120	com/tencent/pb/emosm/ComicIPSite$ModuleRsp:comicList	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1236: invokevirtual 518	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   1239: astore 13
    //   1241: iconst_0
    //   1242: istore 5
    //   1244: aload 11
    //   1246: astore_1
    //   1247: aload_1
    //   1248: astore 15
    //   1250: iload_3
    //   1251: istore 4
    //   1253: aload 17
    //   1255: astore 14
    //   1257: aload 18
    //   1259: astore 12
    //   1261: aload 17
    //   1263: astore_2
    //   1264: iload 5
    //   1266: aload 13
    //   1268: invokeinterface 262 1 0
    //   1273: if_icmpge +540 -> 1813
    //   1276: aload 17
    //   1278: astore_2
    //   1279: aload 13
    //   1281: iload 5
    //   1283: invokeinterface 263 2 0
    //   1288: checkcast 1122	com/tencent/pb/emosm/ComicIPSite$Comic
    //   1291: astore 12
    //   1293: aload 17
    //   1295: astore_2
    //   1296: aload 12
    //   1298: getfield 1123	com/tencent/pb/emosm/ComicIPSite$Comic:rich	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1301: invokevirtual 518	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   1304: astore 11
    //   1306: aload 17
    //   1308: astore_2
    //   1309: new 78	java/util/ArrayList
    //   1312: dup
    //   1313: invokespecial 79	java/util/ArrayList:<init>	()V
    //   1316: astore 14
    //   1318: iconst_0
    //   1319: istore 4
    //   1321: aload 17
    //   1323: astore_2
    //   1324: iload 4
    //   1326: aload 11
    //   1328: invokeinterface 262 1 0
    //   1333: if_icmpge +79 -> 1412
    //   1336: aload 17
    //   1338: astore_2
    //   1339: aload 11
    //   1341: iload 4
    //   1343: invokeinterface 263 2 0
    //   1348: checkcast 1125	com/tencent/pb/emosm/ComicIPSite$ComicRich
    //   1351: astore 15
    //   1353: aload 17
    //   1355: astore_2
    //   1356: aload 14
    //   1358: new 1127	com/tencent/mobileqq/data/IPSiteModel$ComicRich
    //   1361: dup
    //   1362: aload 15
    //   1364: getfield 1130	com/tencent/pb/emosm/ComicIPSite$ComicRich:extCover	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1367: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1370: aload 15
    //   1372: getfield 1133	com/tencent/pb/emosm/ComicIPSite$ComicRich:extName	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1375: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1378: aload 15
    //   1380: getfield 1136	com/tencent/pb/emosm/ComicIPSite$ComicRich:extTitle	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1383: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1386: aload 15
    //   1388: getfield 1139	com/tencent/pb/emosm/ComicIPSite$ComicRich:extUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1391: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1394: invokespecial 1142	com/tencent/mobileqq/data/IPSiteModel$ComicRich:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1397: invokeinterface 196 2 0
    //   1402: pop
    //   1403: iload 4
    //   1405: iconst_1
    //   1406: iadd
    //   1407: istore 4
    //   1409: goto -88 -> 1321
    //   1412: aload 17
    //   1414: astore_2
    //   1415: aload 25
    //   1417: new 1144	com/tencent/mobileqq/data/IPSiteModel$Comic
    //   1420: dup
    //   1421: aload 12
    //   1423: getfield 1147	com/tencent/pb/emosm/ComicIPSite$Comic:comicType	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1426: invokevirtual 174	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1429: aload 12
    //   1431: getfield 1148	com/tencent/pb/emosm/ComicIPSite$Comic:cover	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1434: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1437: aload 12
    //   1439: getfield 1149	com/tencent/pb/emosm/ComicIPSite$Comic:desc	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1442: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1445: aload 12
    //   1447: getfield 1150	com/tencent/pb/emosm/ComicIPSite$Comic:id	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1450: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1453: aload 12
    //   1455: getfield 1151	com/tencent/pb/emosm/ComicIPSite$Comic:jumpUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1458: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1461: aload 12
    //   1463: getfield 1152	com/tencent/pb/emosm/ComicIPSite$Comic:name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1466: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1469: aload 12
    //   1471: getfield 1153	com/tencent/pb/emosm/ComicIPSite$Comic:recommDesc	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1474: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1477: aload 12
    //   1479: getfield 1156	com/tencent/pb/emosm/ComicIPSite$Comic:typeName	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1482: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1485: aload 14
    //   1487: invokespecial 1159	com/tencent/mobileqq/data/IPSiteModel$Comic:<init>	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V
    //   1490: invokeinterface 196 2 0
    //   1495: pop
    //   1496: iload 5
    //   1498: iconst_1
    //   1499: iadd
    //   1500: istore 5
    //   1502: goto -255 -> 1247
    //   1505: aload_1
    //   1506: astore_2
    //   1507: new 1161	com/tencent/mobileqq/data/VipIPSiteInfo
    //   1510: dup
    //   1511: iload 6
    //   1513: aload 19
    //   1515: aload 20
    //   1517: aload 21
    //   1519: iload 7
    //   1521: aload 22
    //   1523: iload_3
    //   1524: aload 23
    //   1526: aload 16
    //   1528: aload 24
    //   1530: aload 25
    //   1532: invokespecial 1164	com/tencent/mobileqq/data/VipIPSiteInfo:<init>	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V
    //   1535: astore 13
    //   1537: aload_0
    //   1538: getfield 55	com/tencent/mobileqq/app/EmoticonHandler:h	Lcom/tencent/common/app/AppInterface;
    //   1541: ifnull +121 -> 1662
    //   1544: aload_0
    //   1545: getfield 55	com/tencent/mobileqq/app/EmoticonHandler:h	Lcom/tencent/common/app/AppInterface;
    //   1548: ldc_w 299
    //   1551: ldc_w 301
    //   1554: invokevirtual 307	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   1557: checkcast 299	com/tencent/mobileqq/emosm/api/IEmoticonManagerService
    //   1560: astore_2
    //   1561: aload_2
    //   1562: ifnull +100 -> 1662
    //   1565: aload_2
    //   1566: aload 12
    //   1568: invokeinterface 1167 2 0
    //   1573: astore 12
    //   1575: aload 12
    //   1577: aload 13
    //   1579: putfield 1171	com/tencent/mobileqq/data/EmoticonPackage:ipSiteInfo	Lcom/tencent/mobileqq/data/VipIPSiteInfo;
    //   1582: aload 12
    //   1584: aload_2
    //   1585: aload 13
    //   1587: invokeinterface 1175 2 0
    //   1592: putfield 1178	com/tencent/mobileqq/data/EmoticonPackage:ipSiteInfoBytes	[B
    //   1595: aload 12
    //   1597: lload 8
    //   1599: putfield 1181	com/tencent/mobileqq/data/EmoticonPackage:richIPReqTime	J
    //   1602: aload 11
    //   1604: getfield 1018	com/tencent/pb/emosm/ComicIPSite$ModuleRsp:goodsList	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1607: invokevirtual 677	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   1610: ifle +220 -> 1830
    //   1613: iconst_1
    //   1614: istore 10
    //   1616: goto +3 -> 1619
    //   1619: aload 12
    //   1621: iload 10
    //   1623: putfield 1184	com/tencent/mobileqq/data/EmoticonPackage:hasIpProduct	Z
    //   1626: aload 12
    //   1628: aload 16
    //   1630: putfield 317	com/tencent/mobileqq/data/EmoticonPackage:ipUrl	Ljava/lang/String;
    //   1633: aload 12
    //   1635: aload 19
    //   1637: putfield 323	com/tencent/mobileqq/data/EmoticonPackage:ipName	Ljava/lang/String;
    //   1640: aload 12
    //   1642: aload 20
    //   1644: putfield 329	com/tencent/mobileqq/data/EmoticonPackage:ipDetail	Ljava/lang/String;
    //   1647: aload 12
    //   1649: aload 21
    //   1651: putfield 352	com/tencent/mobileqq/data/EmoticonPackage:ipJumpUrl	Ljava/lang/String;
    //   1654: aload_2
    //   1655: aload 12
    //   1657: invokeinterface 364 2 0
    //   1662: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1665: ifeq +117 -> 1782
    //   1668: new 198	java/lang/StringBuilder
    //   1671: dup
    //   1672: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   1675: astore_2
    //   1676: aload_2
    //   1677: ldc_w 1186
    //   1680: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1683: pop
    //   1684: aload_2
    //   1685: aload 13
    //   1687: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1690: pop
    //   1691: aload_2
    //   1692: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1695: astore 11
    //   1697: aload_1
    //   1698: astore_2
    //   1699: aload_2
    //   1700: astore_1
    //   1701: aload_2
    //   1702: iconst_2
    //   1703: aload 11
    //   1705: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1708: return
    //   1709: ldc 98
    //   1711: astore_2
    //   1712: aload_2
    //   1713: astore_1
    //   1714: new 198	java/lang/StringBuilder
    //   1717: dup
    //   1718: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   1721: astore 11
    //   1723: aload_2
    //   1724: astore_1
    //   1725: aload 11
    //   1727: ldc_w 1188
    //   1730: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1733: pop
    //   1734: aload_2
    //   1735: astore_1
    //   1736: aload 11
    //   1738: iload_3
    //   1739: invokevirtual 294	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1742: pop
    //   1743: aload_2
    //   1744: astore_1
    //   1745: aload_2
    //   1746: iconst_1
    //   1747: aload 11
    //   1749: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1752: invokestatic 213	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1755: return
    //   1756: astore_2
    //   1757: aload_1
    //   1758: astore 11
    //   1760: goto +12 -> 1772
    //   1763: astore_1
    //   1764: aload 12
    //   1766: astore_2
    //   1767: aload_2
    //   1768: astore 11
    //   1770: aload_1
    //   1771: astore_2
    //   1772: aload 11
    //   1774: iconst_1
    //   1775: ldc_w 1190
    //   1778: aload_2
    //   1779: invokestatic 1193	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1782: return
    //   1783: ldc 98
    //   1785: astore 13
    //   1787: aload_2
    //   1788: astore 16
    //   1790: aload_1
    //   1791: astore 12
    //   1793: aload 13
    //   1795: astore_1
    //   1796: goto -291 -> 1505
    //   1799: aload 13
    //   1801: astore 12
    //   1803: aload_1
    //   1804: astore 14
    //   1806: iload_3
    //   1807: istore 4
    //   1809: aload 11
    //   1811: astore 15
    //   1813: aload 15
    //   1815: astore 11
    //   1817: iload 4
    //   1819: istore_3
    //   1820: aload 14
    //   1822: astore_1
    //   1823: goto -27 -> 1796
    //   1826: astore_1
    //   1827: goto -60 -> 1767
    //   1830: iconst_0
    //   1831: istore 10
    //   1833: goto -214 -> 1619
    //   1836: astore_2
    //   1837: goto +10 -> 1847
    //   1840: astore 11
    //   1842: aload_2
    //   1843: astore_1
    //   1844: aload 11
    //   1846: astore_2
    //   1847: aload_1
    //   1848: astore 11
    //   1850: goto -78 -> 1772
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1853	0	this	EmoticonHandler
    //   0	1853	1	paramToServiceMsg	ToServiceMsg
    //   0	1853	2	paramObject	Object
    //   34	1786	3	i	int
    //   265	1553	4	j	int
    //   459	1042	5	k	int
    //   71	1441	6	m	int
    //   111	1409	7	n	int
    //   175	1423	8	l	long
    //   376	1456	10	bool	boolean
    //   24	1792	11	localObject1	Object
    //   1840	5	11	localException	Exception
    //   1848	1	11	localToServiceMsg	ToServiceMsg
    //   2	1800	12	localObject2	Object
    //   204	1596	13	localObject3	Object
    //   291	1530	14	localObject4	Object
    //   433	1381	15	localObject5	Object
    //   366	1423	16	localObject6	Object
    //   456	957	17	localObject7	Object
    //   489	769	18	localObject8	Object
    //   81	1555	19	str1	String
    //   91	1552	20	str2	String
    //   101	1549	21	str3	String
    //   121	1401	22	str4	String
    //   140	1385	23	str5	String
    //   159	1370	24	str6	String
    //   241	1290	25	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   1701	1708	1756	java/lang/Exception
    //   1714	1723	1756	java/lang/Exception
    //   1725	1734	1756	java/lang/Exception
    //   1736	1743	1756	java/lang/Exception
    //   1745	1755	1756	java/lang/Exception
    //   4	47	1763	java/lang/Exception
    //   52	172	1763	java/lang/Exception
    //   180	191	1763	java/lang/Exception
    //   191	234	1763	java/lang/Exception
    //   234	264	1763	java/lang/Exception
    //   267	356	1763	java/lang/Exception
    //   368	378	1763	java/lang/Exception
    //   386	396	1826	java/lang/Exception
    //   407	419	1826	java/lang/Exception
    //   421	435	1826	java/lang/Exception
    //   437	447	1826	java/lang/Exception
    //   449	458	1826	java/lang/Exception
    //   1537	1561	1836	java/lang/Exception
    //   1565	1613	1836	java/lang/Exception
    //   1619	1662	1836	java/lang/Exception
    //   1662	1697	1836	java/lang/Exception
    //   463	475	1840	java/lang/Exception
    //   477	491	1840	java/lang/Exception
    //   493	564	1840	java/lang/Exception
    //   575	640	1840	java/lang/Exception
    //   659	670	1840	java/lang/Exception
    //   673	682	1840	java/lang/Exception
    //   703	714	1840	java/lang/Exception
    //   717	730	1840	java/lang/Exception
    //   733	828	1840	java/lang/Exception
    //   840	851	1840	java/lang/Exception
    //   854	863	1840	java/lang/Exception
    //   884	895	1840	java/lang/Exception
    //   898	911	1840	java/lang/Exception
    //   914	1033	1840	java/lang/Exception
    //   1045	1056	1840	java/lang/Exception
    //   1059	1068	1840	java/lang/Exception
    //   1089	1100	1840	java/lang/Exception
    //   1103	1116	1840	java/lang/Exception
    //   1119	1190	1840	java/lang/Exception
    //   1217	1228	1840	java/lang/Exception
    //   1231	1241	1840	java/lang/Exception
    //   1264	1276	1840	java/lang/Exception
    //   1279	1293	1840	java/lang/Exception
    //   1296	1306	1840	java/lang/Exception
    //   1309	1318	1840	java/lang/Exception
    //   1324	1336	1840	java/lang/Exception
    //   1339	1353	1840	java/lang/Exception
    //   1356	1403	1840	java/lang/Exception
    //   1415	1496	1840	java/lang/Exception
    //   1507	1537	1840	java/lang/Exception
  }
  
  private boolean a(ToServiceMsg paramToServiceMsg, int paramInt, EmoticonResp paramEmoticonResp, EmosmPb.RspBody paramRspBody)
  {
    int i = paramToServiceMsg.extraData.getInt("EmosmFetchSeq");
    Object localObject = (EmosmPb.SubCmd0x2RspFetchTab)paramRspBody.msg_subcmd0x2_rsp_fetchtab.get();
    int j = ((EmosmPb.SubCmd0x2RspFetchTab)localObject).int32_segment_flag.get();
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("fetchSeq:");
      paramToServiceMsg.append(i);
      paramToServiceMsg.append(" cur segement:");
      paramToServiceMsg.append(j);
      paramToServiceMsg.append(" mapSize:");
      paramToServiceMsg.append(this.f.size());
      QLog.d("EmoticonHandler", 2, paramToServiceMsg.toString());
    }
    List localList1 = ((EmosmPb.SubCmd0x2RspFetchTab)localObject).rpt_msg_tabinfo.get();
    List localList2 = ((EmosmPb.SubCmd0x2RspFetchTab)localObject).rpt_magic_tabinfo.get();
    List localList3 = ((EmosmPb.SubCmd0x2RspFetchTab)localObject).rpt_smallbq_tabinfo.get();
    paramToServiceMsg = new ArrayList();
    if (((EmosmPb.SubCmd0x2RspFetchTab)localObject).uint32_tab_id.has())
    {
      localObject = ((EmosmPb.SubCmd0x2RspFetchTab)localObject).uint32_tab_id.get().iterator();
      while (((Iterator)localObject).hasNext()) {
        paramToServiceMsg.add(String.valueOf((Integer)((Iterator)localObject).next()));
      }
    }
    int k = ((EmosmPb.SubCmd0x2RspFetchTab)paramRspBody.msg_subcmd0x2_rsp_fetchtab.get()).fixed32_timestamp.get();
    if ((j != 0) && (j != -1))
    {
      a(paramInt, i, j, localList1, localList2, localList3, paramToServiceMsg, k);
      return true;
    }
    paramEmoticonResp.timestamp = k;
    a(paramInt, paramEmoticonResp, i, localList1);
    b(paramInt, paramEmoticonResp, i, localList2);
    a(paramInt, paramEmoticonResp, i, localList3, paramToServiceMsg);
    paramRspBody = new StringBuilder();
    paramRspBody.append("svr big emoticon data size = ");
    paramRspBody.append(paramEmoticonResp.data.size());
    paramRspBody.append(", magic size = ");
    paramRspBody.append(paramEmoticonResp.magicData.size());
    paramRspBody.append(", small emotion size = ");
    paramRspBody.append(paramEmoticonResp.smallEmoticonData.size());
    paramRspBody.append(", tab size = ");
    paramRspBody.append(paramEmoticonResp.tabOrderList.size());
    QLog.d("EmoticonHandler", 1, paramRspBody.toString());
    if (QLog.isColorLevel())
    {
      paramRspBody = new StringBuilder();
      paramRspBody.append("svr big emoticon list=");
      paramRspBody.append(paramEmoticonResp.data);
      paramRspBody.append("svr magic emoticon list=");
      paramRspBody.append(paramEmoticonResp.magicData);
      paramRspBody.append("svr small emoticon list=");
      paramRspBody.append(paramEmoticonResp.smallEmoticonData);
      QLog.d("EmoticonHandler", 2, paramRspBody.toString());
      a(i, paramToServiceMsg);
    }
    return false;
  }
  
  private boolean a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, int paramInt)
  {
    int i = paramToServiceMsg.extraData.getInt("EmoticonRetry");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("error can not send cmd: ");
    localStringBuilder.append(paramInt);
    QLog.e("EmoticonHandler", 1, localStringBuilder.toString());
    if ((paramFromServiceMsg.getResultCode() != 1000) && (i < 2) && (paramInt == 2))
    {
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("try index: ");
        paramFromServiceMsg.append(i);
        QLog.d("EmoticonHandler", 2, paramFromServiceMsg.toString());
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
    Object localObject1 = paramList;
    if (this.d.get(Integer.valueOf(paramInt2)) != null)
    {
      ((List)this.d.get(Integer.valueOf(paramInt2))).addAll(paramList);
      localObject1 = (List)this.d.remove(Integer.valueOf(paramInt2));
    }
    paramList = ((List)localObject1).iterator();
    while (paramList.hasNext())
    {
      Object localObject2 = (EmosmPb.SubCmd0x2RspFetchTab.TabInfo)paramList.next();
      localObject1 = new EmoticonPackage();
      ((EmoticonPackage)localObject1).epId = String.valueOf(((EmosmPb.SubCmd0x2RspFetchTab.TabInfo)localObject2).uint32_tab_id.get());
      ((EmoticonPackage)localObject1).expiretime = ((EmosmPb.SubCmd0x2RspFetchTab.TabInfo)localObject2).fixed32_expire_time.get();
      boolean bool;
      if (((EmosmPb.SubCmd0x2RspFetchTab.TabInfo)localObject2).uint32_flags.get() == 1) {
        bool = true;
      } else {
        bool = false;
      }
      ((EmoticonPackage)localObject1).valid = bool;
      ((EmoticonPackage)localObject1).wordingId = ((EmosmPb.SubCmd0x2RspFetchTab.TabInfo)localObject2).int32_wording_id.get();
      ((EmoticonPackage)localObject1).name = ((EmosmPb.SubCmd0x2RspFetchTab.TabInfo)localObject2).str_tab_name.get();
      if (paramInt1 == 0) {
        ((EmoticonPackage)localObject1).aio = true;
      } else if (paramInt1 == 1) {
        ((EmoticonPackage)localObject1).kandian = true;
      }
      if (((EmosmPb.SubCmd0x2RspFetchTab.TabInfo)localObject2).int32_tab_type.has())
      {
        ((EmoticonPackage)localObject1).type = ((EmosmPb.SubCmd0x2RspFetchTab.TabInfo)localObject2).int32_tab_type.get();
        if (((EmosmPb.SubCmd0x2RspFetchTab.TabInfo)localObject2).int32_tab_type.get() == 1) {
          ((EmoticonPackage)localObject1).jobType = 3;
        } else if (((EmosmPb.SubCmd0x2RspFetchTab.TabInfo)localObject2).int32_tab_type.get() == 4) {
          ((EmoticonPackage)localObject1).jobType = 5;
        }
      }
      if (!((EmoticonPackage)localObject1).valid)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("TYPE_EMOSM_PS_FETCH: magic emotion ep not valid ; ep = ");
        ((StringBuilder)localObject2).append(localObject1);
        QLog.e("EmoticonHandler", 1, ((StringBuilder)localObject2).toString());
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("TYPE_EMOSM_PS_FETCH: magic emotion ep = ");
        ((StringBuilder)localObject2).append(localObject1);
        QLog.d("EmoticonHandler", 2, ((StringBuilder)localObject2).toString());
      }
      localArrayList.add(localObject1);
    }
    paramEmoticonResp.magicData = localArrayList;
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {}
    for (;;)
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg.uint32_result.get() != 0) {
          break label368;
        }
        i = 1;
        if (i == 0) {
          break label380;
        }
        paramToServiceMsg = ByteBuffer.wrap(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
        paramToServiceMsg.getInt();
        if (paramToServiceMsg.get() != 1) {
          break label374;
        }
        bool = true;
        paramToServiceMsg = this.h.getApplication().getSharedPreferences("mobileQQ", 0).edit();
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("emosm_has_download_emosmpackage_tag_");
        paramFromServiceMsg.append(this.h.getCurrentAccountUin());
        paramToServiceMsg.putBoolean(paramFromServiceMsg.toString(), bool).commit();
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("CMD_EMOSM_CHECK_OIDB, needToFetchEmosmList = ");
          paramToServiceMsg.append(bool);
          QLog.w("EmoticonHandler", 2, paramToServiceMsg.toString());
        }
        if (!bool) {
          break label367;
        }
        if (QLog.isColorLevel()) {
          QLog.w("EmoticonHandler", 2, "CMD_EMOSM_CHECK_OIDB, initEmoticon");
        }
        a(0, 0);
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.e("EmoticonHandler", 1, paramToServiceMsg.getMessage());
        return;
      }
      i = paramToServiceMsg.extraData.getInt("EmoticonRetry");
      paramObject = new StringBuilder();
      paramObject.append("CMD_EMOSM_CHECK_OIDB, error:");
      paramObject.append(paramFromServiceMsg.getResultCode());
      QLog.e("EmoticonHandler", 1, paramObject.toString());
      if ((paramFromServiceMsg.getResultCode() == 1002) && (i < 2))
      {
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("CMD_EMOSM_CHECK_OIDB try index: ");
          paramFromServiceMsg.append(i);
          QLog.d("EmoticonHandler", 2, paramFromServiceMsg.toString());
        }
        paramToServiceMsg.extraData.putInt("EmoticonRetry", i + 1);
        super.sendPbReq(paramToServiceMsg);
      }
      label367:
      return;
      label368:
      i = 0;
      continue;
      label374:
      boolean bool = false;
      continue;
      label380:
      bool = true;
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
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("func fetchEmoticonsPackages, timestamp:");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(",dividemask:");
      ((StringBuilder)localObject1).append(paramInt2);
      ((StringBuilder)localObject1).append(" businessType = ");
      ((StringBuilder)localObject1).append(paramInt3);
      ((StringBuilder)localObject1).append(" fetchSeq:");
      ((StringBuilder)localObject1).append(paramInt4);
      QLog.d("EmoticonHandler", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = new EmosmPb.SubCmd0x2ReqFetchTab();
    ((EmosmPb.SubCmd0x2ReqFetchTab)localObject2).fixed32_timestamp.set(paramInt1);
    ((EmosmPb.SubCmd0x2ReqFetchTab)localObject2).int32_segment_flag.set(paramInt2);
    Object localObject1 = new EmosmPb.ReqBody();
    ((EmosmPb.ReqBody)localObject1).uint32_sub_cmd.set(2);
    ((EmosmPb.ReqBody)localObject1).uint64_uin.set(Long.valueOf(this.h.getCurrentAccountUin()).longValue());
    ((EmosmPb.ReqBody)localObject1).msg_subcmd0x2_req_fetchtab.set((MessageMicro)localObject2);
    ((EmosmPb.ReqBody)localObject1).int32_plat_id.set(109);
    ((EmosmPb.ReqBody)localObject1).str_app_version.set("8.8.17");
    ((EmosmPb.ReqBody)localObject1).uint32_business_id.set(paramInt3);
    paramInt1 = paramInt4;
    if (paramInt4 == 0)
    {
      paramInt2 = this.b.incrementAndGet();
      paramInt1 = paramInt2;
      if (paramInt2 == 0) {
        paramInt1 = this.b.incrementAndGet();
      }
      this.f.remove(Integer.valueOf(paramInt1));
      this.c.remove(Integer.valueOf(paramInt1));
      this.e.remove(Integer.valueOf(paramInt1));
      this.d.remove(Integer.valueOf(paramInt1));
    }
    localObject2 = new ToServiceMsg("mobileqq.service", this.h.getCurrentAccountUin(), "BQMallSvc.TabOpReq");
    ((ToServiceMsg)localObject2).extraData.putInt("EmosmSubCmd", 2);
    ((ToServiceMsg)localObject2).extraData.putInt("EmosmFetchSeq", paramInt1);
    ((ToServiceMsg)localObject2).putWupBuffer(((EmosmPb.ReqBody)localObject1).toByteArray());
    super.sendPbReq((ToServiceMsg)localObject2);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    EmosmPb.ReqBody localReqBody = new EmosmPb.ReqBody();
    localReqBody.uint64_uin.set(Long.valueOf(this.h.getCurrentAccountUin()).longValue());
    localReqBody.int32_plat_id.set(109);
    localReqBody.str_app_version.set("8.8.17");
    if (6 == paramInt1)
    {
      localReqBody.uint32_sub_cmd.set(paramInt1);
      localObject = new EmosmPb.SubCmd0x6Req();
      ((EmosmPb.SubCmd0x6Req)localObject).u32_tab_id.set(paramInt2);
      ((EmosmPb.SubCmd0x6Req)localObject).str_item_id.set(paramString);
      localReqBody.msg_subcmd0x6_req.set((MessageMicro)localObject);
    }
    else if ((7 == paramInt1) || (107 == paramInt1))
    {
      localReqBody.uint32_sub_cmd.set(7);
      localObject = new EmosmPb.SubCmd0x7Req();
      ((EmosmPb.SubCmd0x7Req)localObject).u32_tab_id.set(paramInt2);
      ((EmosmPb.SubCmd0x7Req)localObject).str_item_id.set(paramString);
      localReqBody.msg_subcmd0x7_req.set((MessageMicro)localObject);
    }
    Object localObject = new ToServiceMsg("mobileqq.service", this.h.getCurrentAccountUin(), "BQMallSvc.TabOpReq");
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
  }
  
  public void a(int paramInt, ArrayList<Emoticon> paramArrayList, String paramString)
  {
    if (paramArrayList == null) {
      return;
    }
    boolean bool = QLog.isColorLevel();
    int i = 0;
    if (bool)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("emosm...fetch key count  = ");
      ((StringBuilder)localObject1).append(paramArrayList.size());
      ((StringBuilder)localObject1).append(" epid = ");
      ((StringBuilder)localObject1).append(((Emoticon)paramArrayList.get(0)).epId);
      ((StringBuilder)localObject1).append("  eid.0 = ");
      ((StringBuilder)localObject1).append(((Emoticon)paramArrayList.get(0)).eId);
      QLog.d("EmoticonHandler", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = paramArrayList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (Emoticon)((Iterator)localObject2).next();
      try
      {
        localObject3 = ByteStringMicro.copyFrom(EmoticonPanelUtils.a(((Emoticon)localObject3).eId));
        ((List)localObject1).add(localObject3);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localNumberFormatException.printStackTrace();
      }
    }
    localObject2 = new EmosmPb.SubCmd0x3ReqFetchBq();
    ((EmosmPb.SubCmd0x3ReqFetchBq)localObject2).uint32_tab_id.set(paramInt);
    while (i < ((List)localObject1).size())
    {
      ((EmosmPb.SubCmd0x3ReqFetchBq)localObject2).rpt_bytes_bqid.get().add(((List)localObject1).get(i));
      i += 1;
    }
    localObject1 = new EmosmPb.ReqBody();
    ((EmosmPb.ReqBody)localObject1).uint32_sub_cmd.set(3);
    ((EmosmPb.ReqBody)localObject1).uint64_uin.set(Long.valueOf(this.h.getCurrentAccountUin()).longValue());
    ((EmosmPb.ReqBody)localObject1).msg_subcmd0x3_req_fetchbq.set((MessageMicro)localObject2);
    ((EmosmPb.ReqBody)localObject1).int32_plat_id.set(109);
    localObject2 = new ToServiceMsg("mobileqq.service", this.h.getCurrentAccountUin(), "BQMallSvc.TabOpReq");
    ((ToServiceMsg)localObject2).extraData.putInt("EmosmPackageId", paramInt);
    ((ToServiceMsg)localObject2).extraData.putSerializable("EmosmEmos", paramArrayList);
    ((ToServiceMsg)localObject2).extraData.putInt("EmosmSubCmd", 3);
    ((ToServiceMsg)localObject2).addAttribute("_tag_LOGSTR", paramString);
    if (QLog.isColorLevel())
    {
      paramArrayList = new StringBuilder();
      paramArrayList.append("getKeySeq reqlocalseq:");
      paramArrayList.append(paramString);
      QLog.d("EmoticonHandler", 2, paramArrayList.toString());
    }
    ((ToServiceMsg)localObject2).putWupBuffer(((EmosmPb.ReqBody)localObject1).toByteArray());
    super.sendPbReq((ToServiceMsg)localObject2);
  }
  
  public void a(EmojiManagerServiceImpl.SyncFetchEmoticonKeyObserver paramSyncFetchEmoticonKeyObserver)
  {
    if (paramSyncFetchEmoticonKeyObserver != null) {
      this.g.addIfAbsent(paramSyncFetchEmoticonKeyObserver);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ReportAddEmoticonPkg, pkgId=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" businessType = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("EmoticonHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new EmosmPb.SubCmd0x8ReqAddTab();
    ((EmosmPb.SubCmd0x8ReqAddTab)localObject).uint32_tab_id.set(Integer.parseInt(paramString));
    paramString = new EmosmPb.ReqBody();
    paramString.uint32_sub_cmd.set(8);
    paramString.uint64_uin.set(Long.valueOf(this.h.getCurrentAccountUin()).longValue());
    paramString.int32_plat_id.set(109);
    paramString.str_app_version.set("8.8.17");
    paramString.msg_subcmd0x8_req_addtab.set((MessageMicro)localObject);
    paramString.uint32_business_id.set(paramInt);
    paramString.setHasFlag(true);
    localObject = createToServiceMsg("BQMallSvc.TabOpReq");
    ((ToServiceMsg)localObject).extraData.putInt("EmosmSubCmd", 8);
    ((ToServiceMsg)localObject).putWupBuffer(paramString.toByteArray());
    super.sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("fetchEmoticonIPSiteInformationEx, tabId:");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("EmoticonHandler", 2, ((StringBuilder)localObject1).toString());
    }
    if (TextUtils.isEmpty(paramString))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("fetchEmoticonIPSiteInformationEx error, id = ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.e("EmoticonHandler", 1, ((StringBuilder)localObject1).toString());
      return;
    }
    if (this.h != null)
    {
      localObject1 = new ComicIPSite.ModuleInfo();
      ((ComicIPSite.ModuleInfo)localObject1).appId.set(204);
      Object localObject2 = ((ComicIPSite.ModuleInfo)localObject1).itemId;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("1_");
      localStringBuilder.append(paramString);
      ((PBStringField)localObject2).set(localStringBuilder.toString());
      ((ComicIPSite.ModuleInfo)localObject1).isRetSummary.set(paramBoolean);
      localObject2 = new ComicIPSite.ModuleReq();
      ((ComicIPSite.ModuleReq)localObject2).platform.set(109L);
      ((ComicIPSite.ModuleReq)localObject2).mqqver.set("8.8.17");
      ((ComicIPSite.ModuleReq)localObject2).uin.set(Long.valueOf(this.h.getCurrentUin()).longValue());
      ((ComicIPSite.ModuleReq)localObject2).sub_cmd.set(1);
      ((ComicIPSite.ModuleReq)localObject2).moduleInfo.set((MessageMicro)localObject1);
      localObject1 = new ToServiceMsg("mobileqq.service", this.h.getCurrentAccountUin(), "gxzbIpsit.ipsite");
      ((ToServiceMsg)localObject1).extraData.putString("epId", paramString);
      ((ToServiceMsg)localObject1).putWupBuffer(((ComicIPSite.ModuleReq)localObject2).toByteArray());
      super.sendPbReq((ToServiceMsg)localObject1);
    }
  }
  
  public void a(ArrayList<Integer> paramArrayList)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return;
      }
      Object localObject = new EmosmPb.SubCmd0x1ReqDelTab();
      ((EmosmPb.SubCmd0x1ReqDelTab)localObject).rpt_tab_id.addAll(paramArrayList);
      EmosmPb.ReqBody localReqBody = new EmosmPb.ReqBody();
      localReqBody.uint32_sub_cmd.set(1);
      localReqBody.uint64_uin.set(Long.valueOf(this.h.getCurrentAccountUin()).longValue());
      localReqBody.msg_subcmd0x1_req_deltab.set((MessageMicro)localObject);
      localReqBody.int32_plat_id.set(109);
      localObject = new ToServiceMsg("mobileqq.service", this.h.getCurrentAccountUin(), "BQMallSvc.TabOpReq");
      ((ToServiceMsg)localObject).extraData.putInt("EmosmPackageId", -1);
      ((ToServiceMsg)localObject).extraData.putInt("EmosmSubCmd", 17);
      ((ToServiceMsg)localObject).extraData.putIntegerArrayList("EmosmPackageIds", paramArrayList);
      ((ToServiceMsg)localObject).putWupBuffer(localReqBody.toByteArray());
      super.sendPbReq((ToServiceMsg)localObject);
    }
  }
  
  public void a(List<String> paramList, boolean paramBoolean, int paramInt)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("reportEmoticonOrder, localList=");
      ((StringBuilder)localObject1).append(paramList);
      ((StringBuilder)localObject1).append(", shouldReverse=");
      ((StringBuilder)localObject1).append(paramBoolean);
      ((StringBuilder)localObject1).append(", businessType = ");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("EmoticonHandler", 2, ((StringBuilder)localObject1).toString());
    }
    ArrayList localArrayList;
    if ((paramList != null) && (paramList.size() != 0))
    {
      localObject1 = new EmosmPb.SubCmd0x10MoveOrderReq();
      localArrayList = new ArrayList(paramList.size());
      if (!paramBoolean) {}
    }
    for (;;)
    {
      int i;
      try
      {
        i = paramList.size() - 1;
        if (i < 0) {
          continue;
        }
        localObject2 = (String)paramList.get(i);
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label415;
        }
        localArrayList.add(Integer.valueOf(Integer.parseInt((String)localObject2)));
      }
      catch (Exception paramList)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("reportEmoticonOrder, error=");
        ((StringBuilder)localObject2).append(MsfSdkUtils.getStackTraceString(paramList));
        QLog.e("EmoticonHandler", 2, ((StringBuilder)localObject2).toString());
        ((EmosmPb.SubCmd0x10MoveOrderReq)localObject1).uint32_tab_id.set(localArrayList);
        paramList = new EmosmPb.ReqBody();
        paramList.uint32_sub_cmd.set(16);
        paramList.uint64_uin.set(Long.valueOf(this.h.getCurrentAccountUin()).longValue());
        paramList.int32_plat_id.set(109);
        paramList.str_app_version.set("8.8.17");
        paramList.msg_subcmd0x10_req.set((MessageMicro)localObject1);
        paramList.uint32_business_id.set(paramInt);
        paramList.setHasFlag(true);
        localObject1 = createToServiceMsg("BQMallSvc.TabOpReq");
        ((ToServiceMsg)localObject1).extraData.putInt("EmosmSubCmd", 16);
        ((ToServiceMsg)localObject1).putWupBuffer(paramList.toByteArray());
        super.sendPbReq((ToServiceMsg)localObject1);
        return;
      }
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        localObject2 = (String)paramList.next();
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          localArrayList.add(Integer.valueOf(Integer.parseInt((String)localObject2)));
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonHandler", 2, "reportEmoticonOrder, localList null, abort");
        }
        return;
        label415:
        i -= 1;
      }
    }
  }
  
  public void b()
  {
    EmosmPb.ReqBody localReqBody = new EmosmPb.ReqBody();
    localReqBody.uint64_uin.set(Long.valueOf(this.h.getCurrentAccountUin()).longValue());
    localReqBody.int32_plat_id.set(109);
    localReqBody.uint32_sub_cmd.set(19);
    localReqBody.str_app_version.set("8.8.17");
    Object localObject2 = ((ICommonUsedSystemEmojiManagerService)this.h.getRuntimeService(ICommonUsedSystemEmojiManagerService.class, "")).getLocalSystemEmojiInfoFromFile();
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonHandler", 2, "getCommonUsedSmallYellowEmoitonRequest list is null");
      }
      localObject1 = new ArrayList();
    }
    if (QLog.isColorLevel()) {
      if ((localObject1 != null) && (((List)localObject1).size() > 1))
      {
        localObject2 = new StringBuilder();
        int i = 0;
        while (i < ((List)localObject1).size())
        {
          localObject3 = (EmosmPb.SmallYellowItem)((List)localObject1).get(i);
          if (localObject3 != null)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("type = ");
            localStringBuilder.append(((EmosmPb.SmallYellowItem)localObject3).type.get());
            ((StringBuilder)localObject2).append(localStringBuilder.toString());
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(";id = ");
            localStringBuilder.append(((EmosmPb.SmallYellowItem)localObject3).id.get());
            ((StringBuilder)localObject2).append(localStringBuilder.toString());
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(";ts = ");
            localStringBuilder.append(((EmosmPb.SmallYellowItem)localObject3).ts.get());
            ((StringBuilder)localObject2).append(localStringBuilder.toString());
          }
          i += 1;
        }
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("getCommonUsedSmallYellowEmoitonRequest item ");
        ((StringBuilder)localObject3).append(((StringBuilder)localObject2).toString());
        QLog.d("EmoticonHandler", 2, ((StringBuilder)localObject3).toString());
      }
      else
      {
        QLog.d("EmoticonHandler", 2, "getCommonUsedSmallYellowEmoitonRequest infos = null");
      }
    }
    localObject2 = new EmosmPb.SubCmd0x13Req();
    ((EmosmPb.SubCmd0x13Req)localObject2).itemlist.set((List)localObject1);
    localReqBody.msg_subcmd0x13_req.set((MessageMicro)localObject2);
    localObject1 = new ToServiceMsg("mobileqq.service", this.h.getCurrentAccountUin(), "BQMallSvc.TabOpReq");
    ((ToServiceMsg)localObject1).extraData.putInt("EmosmSubCmd", 20);
    ((ToServiceMsg)localObject1).putWupBuffer(localReqBody.toByteArray());
    super.sendPbReq((ToServiceMsg)localObject1);
    if (QLog.isColorLevel()) {
      QLog.i("EmoticonHandler", 2, "getCommonUsedSmallYellowEmoitonRequest called.");
    }
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("fetchEmoticonRecommend, tabId:");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("EmoticonHandler", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = new EmosmPb.SubCmd0x18Req();
    ((EmosmPb.SubCmd0x18Req)localObject2).uint32_tab_id.set(paramInt);
    Object localObject1 = new EmosmPb.ReqBody();
    ((EmosmPb.ReqBody)localObject1).uint32_sub_cmd.set(24);
    ((EmosmPb.ReqBody)localObject1).uint64_uin.set(Long.valueOf(this.h.getCurrentAccountUin()).longValue());
    ((EmosmPb.ReqBody)localObject1).msg_subcmd0x18_req.set((MessageMicro)localObject2);
    ((EmosmPb.ReqBody)localObject1).int32_plat_id.set(109);
    ((EmosmPb.ReqBody)localObject1).str_app_version.set("8.8.17");
    localObject2 = new ToServiceMsg("mobileqq.service", this.h.getCurrentAccountUin(), "BQMallSvc.TabOpReq");
    ((ToServiceMsg)localObject2).extraData.putInt("EmosmSubCmd", 24);
    ((ToServiceMsg)localObject2).extraData.putInt("tabId", paramInt);
    ((ToServiceMsg)localObject2).putWupBuffer(((EmosmPb.ReqBody)localObject1).toByteArray());
    super.sendPbReq((ToServiceMsg)localObject2);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    Object localObject = new EmosmPb.SubCmd0x1ReqDelTab();
    ((EmosmPb.SubCmd0x1ReqDelTab)localObject).uint32_tab_id.set(paramInt1);
    EmosmPb.ReqBody localReqBody = new EmosmPb.ReqBody();
    localReqBody.uint32_sub_cmd.set(1);
    localReqBody.uint64_uin.set(Long.valueOf(this.h.getCurrentAccountUin()).longValue());
    localReqBody.msg_subcmd0x1_req_deltab.set((MessageMicro)localObject);
    localReqBody.int32_plat_id.set(109);
    localReqBody.uint32_business_id.set(paramInt2);
    localObject = new ToServiceMsg("mobileqq.service", this.h.getCurrentAccountUin(), "BQMallSvc.TabOpReq");
    ((ToServiceMsg)localObject).extraData.putInt("EmosmPackageId", paramInt1);
    ((ToServiceMsg)localObject).extraData.putInt("EmosmSubCmd", 1);
    ((ToServiceMsg)localObject).putWupBuffer(localReqBody.toByteArray());
    super.sendPbReq((ToServiceMsg)localObject);
  }
  
  public void b(EmojiManagerServiceImpl.SyncFetchEmoticonKeyObserver paramSyncFetchEmoticonKeyObserver)
  {
    if (paramSyncFetchEmoticonKeyObserver != null) {
      this.g.remove(paramSyncFetchEmoticonKeyObserver);
    }
  }
  
  public void c()
  {
    Object localObject1 = VasUpdateUtil.a(this.h, "watch_focus.json", true, null);
    if (localObject1 != null)
    {
      JSONArray localJSONArray = ((JSONObject)localObject1).optJSONArray("watchingFocusRecommendList");
      if ((localJSONArray != null) && (localJSONArray.length() > 0))
      {
        Object localObject2 = new ArrayList();
        int i = 0;
        while (i < localJSONArray.length())
        {
          localObject1 = localJSONArray.optJSONObject(i);
          int j = ((JSONObject)localObject1).optInt("itemId");
          String str = ((JSONObject)localObject1).optString("name");
          int k = ((JSONObject)localObject1).optInt("itemType");
          int m = ((JSONObject)localObject1).optInt("feeType");
          if (k == 3) {
            localObject1 = EmotionPanelConstans.emoticonRecommendUrl.replace("[epId]", String.valueOf(j)).replace("[mod]", String.valueOf(j % 10));
          } else if (k == 6) {
            localObject1 = EmotionPanelConstans.smallRecommendUrl.replace("[epId]", String.valueOf(j));
          } else {
            localObject1 = "";
          }
          Object localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(IndividuationUrlHelper.a(MobileQQ.getContext(), "emojiDetail", String.valueOf(j), ""));
          ((StringBuilder)localObject3).append("&sceneType=1");
          localObject3 = ((StringBuilder)localObject3).toString();
          EmosmPb.STRecommendTabInfo localSTRecommendTabInfo = new EmosmPb.STRecommendTabInfo();
          localSTRecommendTabInfo.u32_tab_id.set(j);
          localSTRecommendTabInfo.str_tab_name.set(str);
          localSTRecommendTabInfo.i32_tab_type.set(k);
          localSTRecommendTabInfo.i32_feetype.set(m);
          localSTRecommendTabInfo.str_thumb_nail_url.set((String)localObject1);
          localSTRecommendTabInfo.str_button_url.set((String)localObject3);
          ((List)localObject2).add(localSTRecommendTabInfo);
          i += 1;
        }
        localObject1 = new EmosmPb.SubCmd0x5RspBQRecommend();
        ((EmosmPb.SubCmd0x5RspBQRecommend)localObject1).st_new_tab_info.set((List)localObject2);
        localObject2 = (IEmoticonManagerService)this.h.getRuntimeService(IEmoticonManagerService.class, "");
        if (localObject2 != null) {
          ((IEmoticonManagerService)localObject2).saveAndUpdateRecommendEmosInfo((EmosmPb.SubCmd0x5RspBQRecommend)localObject1, 1);
        }
      }
    }
  }
  
  public void c(int paramInt)
  {
    EmosmPb.ReqBody localReqBody = new EmosmPb.ReqBody();
    localReqBody.uint64_uin.set(Long.valueOf(this.h.getCurrentAccountUin()).longValue());
    localReqBody.int32_plat_id.set(109);
    localReqBody.uint32_sub_cmd.set(5);
    localReqBody.str_app_version.set("8.8.17");
    localReqBody.uint32_business_id.set(paramInt);
    Object localObject1 = new EmosmPb.SubCmd0x5ReqBQRecommend();
    Object localObject2 = this.h.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("recommendEmotion_sp_lastversion");
    localStringBuilder.append(this.h.getCurrentAccountUin());
    int i = ((SharedPreferences)localObject2).getInt(localStringBuilder.toString(), -1);
    localObject2 = this.h.getApplication().getFilesDir();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("recommemd_emotion_file__");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(this.h.getCurrentAccountUin());
    paramInt = i;
    if (!new File((File)localObject2, localStringBuilder.toString()).exists()) {
      paramInt = -1;
    }
    ((EmosmPb.SubCmd0x5ReqBQRecommend)localObject1).int32_last_recommend_version.set(paramInt);
    localReqBody.msg_subcmd0x5_req.set((MessageMicro)localObject1);
    localObject1 = new ToServiceMsg("mobileqq.service", this.h.getCurrentAccountUin(), "BQMallSvc.TabOpReq");
    ((ToServiceMsg)localObject1).extraData.putInt("EmosmSubCmd", 5);
    ((ToServiceMsg)localObject1).putWupBuffer(localReqBody.toByteArray());
    super.sendPbReq((ToServiceMsg)localObject1);
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonHandler", 2, "handle request to recommendEmotionInfo");
    }
  }
  
  public void d(int paramInt)
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    Object localObject;
    if (paramInt == 0)
    {
      localOIDBSSOPkg.uint32_command.set(1168);
      localOIDBSSOPkg.uint32_service_type.set(92);
      localObject = ByteBuffer.allocate(4);
      ((ByteBuffer)localObject).putInt((int)Long.parseLong(this.h.getCurrentAccountUin()));
      localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
      localObject = createToServiceMsg("OidbSvc.0x490_92");
      ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
      super.sendPbReq((ToServiceMsg)localObject);
      return;
    }
    if (paramInt == 1)
    {
      localOIDBSSOPkg.uint32_command.set(1515);
      localOIDBSSOPkg.uint32_service_type.set(99);
      localObject = new oidb_0x5eb.ReqBody();
      ((oidb_0x5eb.ReqBody)localObject).rpt_uint64_uins.add(Long.valueOf(Long.parseLong(this.h.getCurrentAccountUin())));
      ((oidb_0x5eb.ReqBody)localObject).uint32_vas_emoticon_usage_info.set(1);
      localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x5eb.ReqBody)localObject).toByteArray()));
      localObject = createToServiceMsg("OidbSvc.0x5eb_99");
      ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
      super.sendPbReq((ToServiceMsg)localObject);
    }
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return EmoticonObserver.class;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.g.clear();
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("BQMallSvc.TabOpReq"))
    {
      a(paramToServiceMsg, paramFromServiceMsg, (byte[])paramObject);
      return;
    }
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
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("cmdfilter error=");
      paramToServiceMsg.append(paramFromServiceMsg.getServiceCmd());
      QLog.d("EmoticonHandler", 2, paramToServiceMsg.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.EmoticonHandler
 * JD-Core Version:    0.7.0.1
 */