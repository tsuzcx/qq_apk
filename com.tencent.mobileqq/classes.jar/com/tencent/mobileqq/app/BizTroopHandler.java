package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.troop.data.TroopCreateLogic;
import com.tencent.mobileqq.troop.data.TroopCreateLogic.TroopCreateResult;
import com.tencent.mobileqq.troop.data.TroopMessageManager;
import com.tencent.mobileqq.troop.utils.HummerParser;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import com.tencent.mobileqq.troopinfo.GroupCatalogBean;
import com.tencent.mobileqq.troopinfo.GroupCatalogTool;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.troop.group_activity_info.RspBody;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import tencent.im.cs.modifyexamine.modifyexamine.ReqBody;
import tencent.im.cs.modifyexamine.modifyexamine.RspBody;
import tencent.im.lbs.member_lbs.Location;
import tencent.im.lbs.member_lbs.RspBody;
import tencent.im.oidb.cmd0x5d6.oidb_0x5d6.ReqBody;
import tencent.im.oidb.cmd0x5d6.oidb_0x5d6.RspBody;
import tencent.im.oidb.cmd0x5d6.oidb_0x5d6.SnsUpateBuffer;
import tencent.im.oidb.cmd0x5d6.oidb_0x5d6.SnsUpateResult;
import tencent.im.oidb.cmd0x5d6.oidb_0x5d6.SnsUpdateItem;
import tencent.im.oidb.cmd0x78f.oidb_0x78f.RspBody;
import tencent.im.oidb.cmd0x874.cmd0x874.ConvertToGroupReq;
import tencent.im.oidb.cmd0x874.cmd0x874.ConvertToGroupRsp;
import tencent.im.oidb.cmd0x874.cmd0x874.ReqBody;
import tencent.im.oidb.cmd0x874.cmd0x874.RspBody;
import tencent.im.oidb.cmd0x89a.oidb_0x89a.GroupGeoInfo;
import tencent.im.oidb.cmd0x89a.oidb_0x89a.ReqBody;
import tencent.im.oidb.cmd0x89a.oidb_0x89a.RspBody;
import tencent.im.oidb.cmd0x89a.oidb_0x89a.groupinfo;
import tencent.im.oidb.cmd0x8a1.cmd0x8a1.CreateGroupInfo;
import tencent.im.oidb.cmd0x8a1.cmd0x8a1.GroupGeoInfo;
import tencent.im.oidb.cmd0x8a1.cmd0x8a1.ReqBody;
import tencent.im.oidb.cmd0x8a1.cmd0x8a1.RspBody;
import tencent.im.oidb.cmd0x8b4.ReqBody;
import tencent.im.oidb.cmd0x8b4.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.video_url.video_url.RspBody;
import tencent.qun.group_activity.group_activity.RspBody;
import zhr;

public class BizTroopHandler
  extends BusinessHandler
{
  private String a;
  protected Map a;
  protected Map b;
  
  BizTroopHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_JavaLangString = "TroopFileHandler";
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
  }
  
  public static long a(String paramString)
  {
    try
    {
      long l = Long.valueOf(paramString).longValue();
      return l;
    }
    catch (Exception paramString) {}
    return 0L;
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    String str = paramToServiceMsg.extraData.getString("troopCode");
    boolean bool = paramToServiceMsg.extraData.getBoolean("isFromAIO");
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      if (bool) {
        this.jdField_a_of_type_JavaUtilMap.remove(str);
      }
      for (;;)
      {
        a(6, false, new Object[] { str, Boolean.valueOf(bool) });
        return;
        this.jdField_b_of_type_JavaUtilMap.remove(str);
      }
    }
    paramToServiceMsg = new group_activity_info.RspBody();
    try
    {
      paramToServiceMsg = (group_activity_info.RspBody)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramToServiceMsg != null) && (paramToServiceMsg.error_code.get() == 0)) {
        break label250;
      }
      if (!bool) {
        break label235;
      }
      this.jdField_a_of_type_JavaUtilMap.remove(str);
    }
    catch (Exception paramToServiceMsg)
    {
      for (;;)
      {
        if (bool) {
          this.jdField_a_of_type_JavaUtilMap.remove(str);
        }
        for (;;)
        {
          a(6, false, new Object[] { str, Boolean.valueOf(bool) });
          return;
          this.jdField_b_of_type_JavaUtilMap.remove(str);
        }
        this.jdField_b_of_type_JavaUtilMap.remove(str);
      }
    }
    a(6, false, new Object[] { str, Boolean.valueOf(bool) });
    return;
    label235:
    label250:
    if (bool) {
      this.jdField_a_of_type_JavaUtilMap.remove(str);
    }
    for (;;)
    {
      a(6, false, new Object[] { str, Boolean.valueOf(bool) });
      return;
      this.jdField_b_of_type_JavaUtilMap.remove(str);
    }
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    String str = paramToServiceMsg.extraData.getString("troopCode");
    long l = paramToServiceMsg.extraData.getLong("troopUin");
    int i = paramToServiceMsg.extraData.getInt("pageIndex");
    int j = paramToServiceMsg.extraData.getInt("pageCount");
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      a(12, false, new Object[] { str, Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramFromServiceMsg.getResultCode()) });
      return;
    }
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramObject = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      paramToServiceMsg = paramObject;
    }
    catch (InvalidProtocolBufferMicroException paramObject)
    {
      for (;;)
      {
        paramObject.printStackTrace();
      }
      k = paramToServiceMsg.uint32_result.get();
      if (k == 0) {
        break label275;
      }
      a(12, false, new Object[] { str, Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      return;
      label275:
      paramFromServiceMsg = new oidb_0x78f.RspBody();
    }
    if ((paramToServiceMsg == null) || (!paramToServiceMsg.uint32_result.has()))
    {
      a(12, false, new Object[] { str, Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramFromServiceMsg.getResultCode()) });
      return;
    }
    try
    {
      int k;
      paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
      try
      {
        paramToServiceMsg = HummerParser.a(l, paramFromServiceMsg.opt_msg_record.get().toByteArray(), paramFromServiceMsg.uint32_cur_cnt.get());
        a(12, true, new Object[] { Integer.valueOf(i), Integer.valueOf(paramFromServiceMsg.uint32_total_cnt.get()), Integer.valueOf(paramFromServiceMsg.uint32_cur_cnt.get()), paramToServiceMsg });
        return;
      }
      catch (IOException paramToServiceMsg)
      {
        a(12, false, new Object[] { str, Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(-1) });
        return;
      }
    }
    catch (Exception paramToServiceMsg)
    {
      for (;;)
      {
        a(12, false, new Object[] { str, Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(-1) });
      }
    }
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    paramToServiceMsg = (RecommendTroopManagerImp)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(21);
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      paramToServiceMsg.b(null);
      a(11, false, null);
      return;
    }
    paramFromServiceMsg = new group_activity.RspBody();
    try
    {
      paramFromServiceMsg = (group_activity.RspBody)paramFromServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramFromServiceMsg == null) || (paramFromServiceMsg.uint32_error_code.get() != 0))
      {
        paramToServiceMsg.b(null);
        a(11, false, null);
        return;
      }
    }
    catch (Exception paramFromServiceMsg)
    {
      paramToServiceMsg.b(null);
      a(11, false, null);
      return;
    }
    paramObject = paramFromServiceMsg.act_list.get();
    if (paramObject == null)
    {
      paramToServiceMsg.b(null);
      a(11, false, null);
      return;
    }
    paramToServiceMsg.b(paramObject);
    a(11, true, paramObject);
    if (NetworkUtil.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext()) == 1)
    {
      paramToServiceMsg = new String[3];
      paramToServiceMsg[0] = "param_WIFIRecommendTroopYunYingDownload";
      paramToServiceMsg[1] = "param_WIFIFlow";
      paramToServiceMsg[2] = "param_Flow";
    }
    for (;;)
    {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.sendAppDataIncerment(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramToServiceMsg, paramFromServiceMsg.getSerializedSize());
      return;
      paramToServiceMsg = new String[3];
      paramToServiceMsg[0] = "param_XGRecommendTroopYunYingDownload";
      paramToServiceMsg[1] = "param_XGFlow";
      paramToServiceMsg[2] = "param_Flow";
    }
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    Object localObject2 = paramToServiceMsg.extraData.getString("troopUin");
    int j = paramToServiceMsg.extraData.getInt("reqType");
    boolean bool = paramToServiceMsg.extraData.getBoolean("isList");
    Object localObject1 = paramToServiceMsg.extraData.getStringArrayList("key_commonly_used_troop_list");
    if (localObject1 != null) {
      a((List)localObject1, j);
    }
    if (bool)
    {
      localObject1 = new Object[] { Integer.valueOf(-1), Integer.valueOf(j), null, null };
      if (paramFromServiceMsg.getResultCode() == 1000) {
        break label169;
      }
      if (!bool) {
        break label162;
      }
    }
    label162:
    for (int i = 43;; i = 18)
    {
      a(i, false, localObject1);
      return;
      localObject1 = new Object[] { localObject2, Integer.valueOf(j), Integer.valueOf(-1), null };
      break;
    }
    label169:
    paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramObject = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramObject != null) && (paramObject.uint32_result.has()) && (paramObject.bytes_bodybuffer.has()) && (paramObject.bytes_bodybuffer.get() != null)) {
        break label279;
      }
      if (!bool) {
        break label272;
      }
      i = 43;
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      for (;;)
      {
        if (bool) {}
        for (i = 43;; i = 18)
        {
          a(i, false, localObject1);
          return;
        }
        i = 18;
      }
      Object localObject3 = new oidb_0x5d6.RspBody();
      try
      {
        ((oidb_0x5d6.RspBody)localObject3).mergeFrom(paramObject.bytes_bodybuffer.get().toByteArray());
        paramFromServiceMsg = ((oidb_0x5d6.RspBody)localObject3).str_wording.get();
        i = paramObject.uint32_result.get();
        paramObject = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
        if (!bool) {
          break label486;
        }
        localObject2 = ((oidb_0x5d6.RspBody)localObject3).rpt_msg_update_result.get();
        paramToServiceMsg = new HashMap();
        if (localObject2 == null) {
          break label450;
        }
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (oidb_0x5d6.SnsUpateResult)((Iterator)localObject2).next();
          paramToServiceMsg.put(paramObject.c(String.valueOf(((oidb_0x5d6.SnsUpateResult)localObject3).uint64_uin.get())), Integer.valueOf(((oidb_0x5d6.SnsUpateResult)localObject3).uint32_result.get()));
        }
        i = 43;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        if (!bool) {
          break label646;
        }
      }
    }
    a(i, false, localObject1);
    return;
    label272:
    label279:
    a(i, false, localObject1);
    return;
    label450:
    a(43, true, new Object[] { Integer.valueOf(i), Integer.valueOf(j), paramToServiceMsg, paramFromServiceMsg });
    return;
    label486:
    if ((i == 0) && (localObject2 != null)) {
      if (j == 0) {
        paramObject.a((String)localObject2, paramToServiceMsg.extraData.getLong("timestamp"));
      }
    }
    for (;;)
    {
      a(18, true, new Object[] { localObject2, Integer.valueOf(j), Integer.valueOf(i), paramFromServiceMsg });
      return;
      if (j == 1)
      {
        paramObject.c((String)localObject2);
        continue;
        if (i == 1224)
        {
          SharedPreUtils.k(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (String)localObject2);
          paramToServiceMsg = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
          long l = NetConnInfoCenter.getServerTime();
          if (j == 0)
          {
            paramToServiceMsg.a((String)localObject2, l);
            break label656;
          }
          paramToServiceMsg.c((String)localObject2);
          break label656;
          label646:
          i = 18;
          break;
        }
      }
      continue;
      label656:
      i = 0;
    }
  }
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    TroopCreateLogic.TroopCreateResult localTroopCreateResult = new TroopCreateLogic.TroopCreateResult();
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      a(28, false, localTroopCreateResult);
      return;
    }
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      a(28, false, localTroopCreateResult);
      return;
    }
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if (paramFromServiceMsg == null)
      {
        a(28, false, localTroopCreateResult);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      a(28, false, localTroopCreateResult);
      return;
    }
    int i = paramFromServiceMsg.uint32_result.get();
    if ((i != 0) && ((i != 129) || (i != 130)))
    {
      localTroopCreateResult.a = i;
      a(28, false, localTroopCreateResult);
      return;
    }
    paramToServiceMsg = new cmd0x8a1.RspBody();
    try
    {
      paramToServiceMsg.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
      if ((paramToServiceMsg == null) || (paramToServiceMsg.uint32_create_option.get() != 1))
      {
        a(28, false, localTroopCreateResult);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      a(28, false, localTroopCreateResult);
      return;
    }
    paramFromServiceMsg = new TroopInfo();
    paramFromServiceMsg.troopuin = String.valueOf(paramToServiceMsg.uint32_group_code.get());
    a(28, true, paramFromServiceMsg);
  }
  
  private void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      a(42, false, new Object[] { Integer.valueOf(2131429864) });
    }
    for (;;)
    {
      return;
      if (paramFromServiceMsg.getResultCode() != 1000)
      {
        a(42, false, new Object[] { Integer.valueOf(2131429864) });
        return;
      }
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramToServiceMsg == null) || (!paramToServiceMsg.uint32_result.has()) || (!paramToServiceMsg.bytes_bodybuffer.has()) || (paramToServiceMsg.bytes_bodybuffer.get() == null))
        {
          a(42, false, new Object[] { Integer.valueOf(2131429864) });
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        a(42, false, new Object[] { Integer.valueOf(2131429864) });
        return;
      }
      paramFromServiceMsg = new cmd0x874.RspBody();
      try
      {
        paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
        if (paramFromServiceMsg.uint32_code.get() != 0) {
          break label520;
        }
        paramToServiceMsg = String.valueOf(paramFromServiceMsg.msg_convert_group.uint64_conf_uin.get());
        paramFromServiceMsg = String.valueOf(paramFromServiceMsg.msg_convert_group.uint64_group_code.get());
        if (!TextUtils.isEmpty(paramFromServiceMsg)) {
          break label289;
        }
        if (QLog.isColorLevel())
        {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleTransferDiscussionToTroop, troopUin:" + paramFromServiceMsg);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        i = 2131429864;
      }
    }
    a(42, false, new Object[] { Integer.valueOf(i) });
    return;
    label289:
    paramObject = new TroopInfo();
    paramObject.troopuin = paramFromServiceMsg;
    paramObject.dwAdditionalFlag = 1L;
    Object localObject = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    if (localObject != null) {
      ((TroopManager)localObject).c(paramObject);
    }
    localObject = (TroopHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
    if (localObject != null) {
      ((TroopHandler)localObject).a(paramObject.troopuin, (byte)0, paramObject.dwTimeStamp, -1);
    }
    localObject = (TroopCreateLogic)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(31);
    if (localObject != null) {
      ((TroopCreateLogic)localObject).a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramObject.troopuin);
    }
    localObject = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    if (localObject != null) {
      ((TroopManager)localObject).d(((TroopManager)localObject).a(paramObject.troopuin));
    }
    paramObject = (DiscussionManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    paramObject.jdField_a_of_type_JavaUtilMap.put(paramToServiceMsg, new String[] { paramFromServiceMsg, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() });
    paramObject.jdField_a_of_type_JavaUtilSet.add(paramFromServiceMsg);
    a(42, true, new Object[] { Integer.valueOf(2131429863), paramToServiceMsg, paramFromServiceMsg, Boolean.valueOf(true) });
    return;
    label520:
    int i = paramFromServiceMsg.uint32_code.get();
    switch (i)
    {
    case 9: 
    default: 
      i = 2131429864;
    }
    for (;;)
    {
      try
      {
        a(42, false, new Object[] { Integer.valueOf(i) });
        return;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg) {}
      break;
      i = 2131429863;
      continue;
      i = 2131429865;
      continue;
      i = 2131429866;
      continue;
      i = 2131429867;
      continue;
      i = 2131429868;
      continue;
      i = 2131429869;
      continue;
      i = 2131429870;
      continue;
      i = 2131429871;
      continue;
      i = 2131429872;
      continue;
      i = 2131429873;
    }
  }
  
  private void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      a(29, false, null);
      return;
    }
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      a(29, false, null);
      return;
    }
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if (paramToServiceMsg == null)
      {
        a(29, false, null);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      a(29, false, null);
      return;
    }
    paramFromServiceMsg = new oidb_0x89a.RspBody();
    try
    {
      paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
      if (paramFromServiceMsg == null)
      {
        a(29, false, null);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      a(29, false, null);
      return;
    }
    int i = paramToServiceMsg.uint32_result.get();
    if (i != 0)
    {
      paramToServiceMsg = new String(paramFromServiceMsg.str_errorinfo.get().toByteArray());
      a(29, false, new Object[] { Long.valueOf(i), paramToServiceMsg });
      return;
    }
    a(29, true, new Object[] { Long.valueOf(paramFromServiceMsg.uint64_group_code.get()), "" });
  }
  
  private void l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      a(44, false, null);
      return;
    }
    String str1 = paramToServiceMsg.extraData.getString("name");
    String str2 = paramToServiceMsg.extraData.getString("troopUin");
    paramToServiceMsg = new Object[3];
    paramToServiceMsg[0] = str2;
    paramToServiceMsg[1] = str1;
    paramToServiceMsg[2] = null;
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      a(44, false, paramToServiceMsg);
      return;
    }
    paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
      if (paramFromServiceMsg == null)
      {
        a(44, false, paramToServiceMsg);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      a(44, false, paramToServiceMsg);
      return;
    }
    paramObject = new oidb_0x89a.RspBody();
    try
    {
      paramObject.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
      if (paramFromServiceMsg.uint32_result.get() != 0)
      {
        if (paramObject.str_errorinfo.has()) {
          paramToServiceMsg[2] = paramObject.str_errorinfo.get().toStringUtf8();
        }
        a(44, false, paramToServiceMsg);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      a(44, false, paramToServiceMsg);
      return;
    }
    long l = paramObject.uint64_group_code.get();
    a(44, true, new Object[] { "" + l, str1, null });
  }
  
  private void m(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = paramToServiceMsg.extraData.getString("pageUrl");
    ArrayList localArrayList = new ArrayList();
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      a(25, false, new Object[] { paramToServiceMsg, localArrayList, Integer.valueOf(-1) });
      return;
    }
    paramFromServiceMsg = new video_url.RspBody();
    try
    {
      paramFromServiceMsg.mergeFrom((byte[])paramObject);
      if (paramFromServiceMsg.int32_result.get() != 0)
      {
        a(25, false, new Object[] { paramToServiceMsg, localArrayList, Integer.valueOf(-1) });
        return;
      }
    }
    catch (Exception paramFromServiceMsg)
    {
      a(25, false, new Object[] { paramToServiceMsg, localArrayList, Integer.valueOf(-1) });
      return;
    }
    paramObject = paramFromServiceMsg.rpt_bytes_play_urls.get();
    int i = paramFromServiceMsg.uint32_total_time.get();
    paramFromServiceMsg = paramObject.iterator();
    while (paramFromServiceMsg.hasNext()) {
      localArrayList.add(new String(((ByteStringMicro)paramFromServiceMsg.next()).toByteArray()));
    }
    a(25, true, new Object[] { paramToServiceMsg, localArrayList, Integer.valueOf(i) });
  }
  
  private void n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      a(45, false, null);
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_a_of_type_JavaLangString, 2, "handleConfessTalkSwitch req or resp is null.");
      }
    }
    label150:
    label300:
    long l;
    do
    {
      do
      {
        for (;;)
        {
          return;
          if (paramFromServiceMsg.getResultCode() != 1000)
          {
            a(45, false, null);
            if (QLog.isColorLevel()) {
              QLog.i(this.jdField_a_of_type_JavaLangString, 2, "handleConfessTalkSwitch resp result code not ok.");
            }
          }
          else
          {
            paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
            try
            {
              paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
              if (paramToServiceMsg != null) {
                break label150;
              }
              a(45, false, null);
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.i(this.jdField_a_of_type_JavaLangString, 2, "handleConfessTalkSwitch sso pkg is null.");
              return;
            }
            catch (InvalidProtocolBufferMicroException paramToServiceMsg)
            {
              a(45, false, null);
            }
            if (QLog.isColorLevel())
            {
              QLog.i(this.jdField_a_of_type_JavaLangString, 2, "handleConfessTalkSwitch InvalidProtocolBufferMicroException");
              return;
              int i = paramToServiceMsg.uint32_result.get();
              if (i != 0)
              {
                a(45, false, new Object[] { Long.valueOf(i) });
                if (QLog.isColorLevel()) {
                  QLog.i(this.jdField_a_of_type_JavaLangString, 2, "handleConfessTalkSwitch result code != 0 resultCode : " + i);
                }
              }
              else
              {
                paramFromServiceMsg = new oidb_0x89a.RspBody();
                try
                {
                  paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
                  if (paramFromServiceMsg != null) {
                    break label300;
                  }
                  a(45, false, null);
                  if (QLog.isColorLevel())
                  {
                    QLog.i(this.jdField_a_of_type_JavaLangString, 2, "handleConfessTalkSwitch rspBody is null.");
                    return;
                  }
                }
                catch (InvalidProtocolBufferMicroException paramToServiceMsg)
                {
                  a(45, false, null);
                }
              }
            }
          }
        }
      } while (!QLog.isColorLevel());
      QLog.i(this.jdField_a_of_type_JavaLangString, 2, "handleConfessTalkSwitch InvalidProtocolBufferMicroException.");
      return;
      l = paramFromServiceMsg.uint64_group_code.get();
      a(45, true, new Object[] { Long.valueOf(l) });
    } while (!QLog.isColorLevel());
    QLog.i(this.jdField_a_of_type_JavaLangString, 2, "handleConfessTalkSwitch success, troopCode is: " + l);
  }
  
  private void o(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = paramToServiceMsg.extraData.getBoolean("hideTroopIsHide", false);
    if ((paramObject == null) || (!paramFromServiceMsg.isSuccess()))
    {
      a(26, false, Boolean.valueOf(bool));
      return;
    }
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramToServiceMsg == null) || (!paramToServiceMsg.uint32_result.has()) || (!paramToServiceMsg.bytes_bodybuffer.has()) || (paramToServiceMsg.bytes_bodybuffer.get() == null))
      {
        a(26, false, Boolean.valueOf(bool));
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      a(26, false, Boolean.valueOf(bool));
      return;
    }
    if (paramToServiceMsg.uint32_result.get() != 0)
    {
      a(26, false, Boolean.valueOf(bool));
      return;
    }
    a(26, true, Boolean.valueOf(bool));
  }
  
  private void p(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    String str = paramToServiceMsg.extraData.getString("troopUin");
    boolean bool = paramToServiceMsg.extraData.getBoolean("isShare");
    paramToServiceMsg = new Object[4];
    paramToServiceMsg[0] = str;
    paramToServiceMsg[1] = Boolean.valueOf(bool);
    paramToServiceMsg[2] = Integer.valueOf(-1);
    paramToServiceMsg[3] = null;
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      a(31, false, paramToServiceMsg);
      return;
    }
    paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.uint32_result.has()) || (!paramFromServiceMsg.bytes_bodybuffer.has()) || (paramFromServiceMsg.bytes_bodybuffer.get() == null))
      {
        a(31, false, paramToServiceMsg);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      a(31, false, paramToServiceMsg);
      return;
    }
    paramObject = new oidb_0x5d6.RspBody();
    for (;;)
    {
      try
      {
        paramObject.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
        paramObject = paramObject.str_wording.get();
        int i = paramFromServiceMsg.uint32_result.get();
        if (i != 0) {
          break;
        }
        paramFromServiceMsg = (TroopInfoManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
        if (bool)
        {
          paramFromServiceMsg.c(str);
          a(31, true, new Object[] { str, Boolean.valueOf(bool), Integer.valueOf(i), paramObject });
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        a(31, false, paramToServiceMsg);
        return;
      }
      paramFromServiceMsg.d(str);
      paramFromServiceMsg.a(str);
    }
    a(31, false, paramToServiceMsg);
  }
  
  private void q(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleShareLbsInTroopBeforeJoinedTroopResp");
    }
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    int i = paramToServiceMsg.extraData.getInt("servicetype");
    String str = paramToServiceMsg.extraData.getString("troopCode");
    paramToServiceMsg = new cmd0x8b4.RspBody();
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramObject = (oidb_sso.OIDBSSOPkg)localOIDBSSOPkg.mergeFrom((byte[])paramObject);
      if ((paramObject == null) || (!paramObject.uint32_result.has()) || (!paramObject.bytes_bodybuffer.has()) || (paramObject.bytes_bodybuffer.get() == null))
      {
        a(33, false, new Object[] { Integer.valueOf(paramToServiceMsg.uint32_result.get()), Integer.valueOf(i), Integer.valueOf(0) });
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      a(33, false, new Object[] { Integer.valueOf(paramToServiceMsg.uint32_result.get()), Integer.valueOf(i), Integer.valueOf(0) });
      return;
    }
    for (;;)
    {
      int j;
      try
      {
        paramToServiceMsg.mergeFrom(paramObject.bytes_bodybuffer.get().toByteArray());
        if (!paramFromServiceMsg.isSuccess()) {
          break;
        }
        if (i == 3)
        {
          j = paramToServiceMsg.uint32_flag.get();
          paramFromServiceMsg = (TroopInfoManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
          if (j == 1) {
            paramFromServiceMsg.c(str);
          }
        }
        else
        {
          a(33, true, new Object[] { Integer.valueOf(paramToServiceMsg.uint32_result.get()), Integer.valueOf(i), Integer.valueOf(paramToServiceMsg.uint32_flag.get()) });
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        a(33, false, new Object[] { Integer.valueOf(paramToServiceMsg.uint32_result.get()), Integer.valueOf(i), Integer.valueOf(0) });
        return;
      }
      if (j == 2) {
        paramFromServiceMsg.d(str);
      }
    }
    a(33, false, new Object[] { Integer.valueOf(paramToServiceMsg.uint32_result.get()), Integer.valueOf(i), Integer.valueOf(0) });
  }
  
  private void r(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    paramToServiceMsg = new Object[2];
    paramToServiceMsg[0] = Long.valueOf(0L);
    paramToServiceMsg[1] = Long.valueOf(0L);
    int i = paramFromServiceMsg.getResultCode();
    if (QLog.isColorLevel()) {
      QLog.d("Q.troopMemberDistance", 2, "BizTroopHandler->handleReportSelfLbs, resultCode=" + i);
    }
    if (i != 1000)
    {
      a(32, false, paramToServiceMsg);
      return;
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg = new member_lbs.RspBody();
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        i = -1;
        if (paramFromServiceMsg.uint32_result.has()) {
          i = paramFromServiceMsg.uint32_result.get();
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.troopMemberDistance", 2, "handleReportSelfLbs, rspBodyRet=" + i);
        }
        if (i != 0) {
          break label258;
        }
        paramFromServiceMsg = (member_lbs.Location)paramFromServiceMsg.msg_location.get();
        if (paramFromServiceMsg == null) {
          break label284;
        }
        l2 = (int)paramFromServiceMsg.int64_latitude.get();
        l1 = (int)paramFromServiceMsg.int64_longitude.get();
        a(32, true, new Object[] { Long.valueOf(l2), Long.valueOf(l1) });
        return;
      }
      catch (Exception paramFromServiceMsg)
      {
        a(32, false, paramToServiceMsg);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("Q.troopMemberDistance", 2, "handleReportSelfLbs exception:", paramFromServiceMsg);
      return;
      label258:
      a(32, false, new Object[] { Long.valueOf(0L), Long.valueOf(0L) });
      return;
      label284:
      long l1 = 0L;
      long l2 = 0L;
    }
  }
  
  protected Class a()
  {
    return BizTroopObserver.class;
  }
  
  public void a(long paramLong)
  {
    Object localObject1 = new cmd0x874.ReqBody();
    ((cmd0x874.ReqBody)localObject1).uint32_subcmd.set(1);
    Object localObject2 = new cmd0x874.ConvertToGroupReq();
    ((cmd0x874.ConvertToGroupReq)localObject2).uint64_conf_uin.set(paramLong);
    ((cmd0x874.ReqBody)localObject1).msg_convert_group.set((MessageMicro)localObject2);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2164);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(1);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0x874.ReqBody)localObject1).toByteArray()));
    localObject1 = a("OidbSvc.0x874_1");
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    b((ToServiceMsg)localObject1);
  }
  
  public void a(long paramLong1, int paramInt1, long paramLong2, int paramInt2, String paramString1, String paramString2, int paramInt3, int paramInt4, long paramLong3, long paramLong4, int paramInt5, String paramString3, byte[] paramArrayOfByte, int paramInt6)
  {
    cmd0x8a1.ReqBody localReqBody = new cmd0x8a1.ReqBody();
    localReqBody.uint32_create_option.set(1);
    cmd0x8a1.CreateGroupInfo localCreateGroupInfo = new cmd0x8a1.CreateGroupInfo();
    localCreateGroupInfo.uint32_group_code.set((int)paramLong1);
    localCreateGroupInfo.uint32_group_size.set(paramInt1);
    localCreateGroupInfo.uint64_owner_uin.set(paramLong2);
    localCreateGroupInfo.uint32_group_option.set(paramInt2);
    localCreateGroupInfo.string_group_name.set(ByteStringMicro.copyFromUtf8(paramString1));
    localCreateGroupInfo.string_group_finger_memo.set(ByteStringMicro.copyFromUtf8(paramString2));
    localCreateGroupInfo.string_group_rich_finger_memo.set(ByteStringMicro.copyFromUtf8(paramString2));
    localCreateGroupInfo.uint32_group_class.set(0);
    localCreateGroupInfo.uint32_group_class_ext.set(paramInt3);
    localCreateGroupInfo.uint32_group_type_flag.set(paramInt4);
    paramString1 = new cmd0x8a1.GroupGeoInfo();
    paramString1.uint32_city_id.set(paramInt5);
    paramString1.uint64_latitude.set(paramLong3);
    paramString1.uint64_longtitude.set(paramLong4);
    paramString1.string_geo_content.set(ByteStringMicro.copyFromUtf8(paramString3));
    localCreateGroupInfo.msg_group_geo_info.set(paramString1);
    localCreateGroupInfo.string_sign.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    localCreateGroupInfo.uint64_create_flag.set(16L);
    localCreateGroupInfo.uint32_group_face.set(0);
    localCreateGroupInfo.uint32_app_id.set(200000007);
    localReqBody.msg_create_group_info.set(localCreateGroupInfo);
    paramString1 = new oidb_sso.OIDBSSOPkg();
    paramString1.uint32_command.set(2209);
    paramString1.uint32_result.set(0);
    paramString1.uint32_service_type.set(7);
    paramString1.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
    paramString2 = a("OidbSvc.0x8a1_0");
    paramString2.putWupBuffer(paramString1.toByteArray());
    paramString2.extraData.putInt("type", 2);
    b(paramString2);
  }
  
  public void a(long paramLong1, int paramInt1, String paramString1, long paramLong2, List paramList, int paramInt2, long paramLong3, long paramLong4, long paramLong5, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString + ".troop.location_info", 2, "modifyTroopInfoBy0x89a==>cityId:" + paramInt2 + "|lat:" + paramLong3 + "|lon:" + paramLong4);
    }
    oidb_0x89a.ReqBody localReqBody = new oidb_0x89a.ReqBody();
    localReqBody.uint64_group_code.set(paramLong1);
    oidb_0x89a.groupinfo localgroupinfo = new oidb_0x89a.groupinfo();
    localgroupinfo.uint32_group_type_flag.set(paramInt1);
    if (!TextUtils.isEmpty(paramString1)) {
      localgroupinfo.string_group_name.set(ByteStringMicro.copyFromUtf8(paramString1));
    }
    localgroupinfo.uint32_group_class_ext.set((int)paramLong2);
    paramString1 = GroupCatalogTool.a(BaseApplicationImpl.getApplication()).a(BaseApplicationImpl.getApplication(), String.valueOf(localgroupinfo.uint32_group_class_ext.get()));
    if (paramString1 != null) {
      localgroupinfo.string_group_class_text.set(ByteStringMicro.copyFromUtf8(paramString1.jdField_a_of_type_JavaLangString));
    }
    paramString1 = new ArrayList();
    if (paramList != null)
    {
      paramInt1 = 0;
      while (paramInt1 < paramList.size())
      {
        if (!TextUtils.isEmpty((CharSequence)paramList.get(paramInt1))) {
          paramString1.add(ByteStringMicro.copyFromUtf8((String)paramList.get(paramInt1)));
        }
        paramInt1 += 1;
      }
    }
    if (paramString1.size() == 0) {
      paramString1.add(ByteStringMicro.copyFrom("".getBytes()));
    }
    localgroupinfo.rpt_string_group_tag.set(paramString1);
    if ((paramLong3 != 0L) || (paramLong4 != 0L))
    {
      paramString1 = new oidb_0x89a.GroupGeoInfo();
      paramString1.uint32_city_id.set(paramInt2);
      paramString1.uint64_latitude.set(paramLong3);
      paramString1.uint64_longtitude.set(paramLong4);
      if (paramString2 != null) {
        paramString1.string_geo_content.set(ByteStringMicro.copyFromUtf8(paramString2));
      }
      paramString1.uint64_poi_id.set(paramLong5);
      localgroupinfo.msg_group_geo_info.set(paramString1);
    }
    if (paramString3 != null)
    {
      localgroupinfo.string_group_finger_memo.set(ByteStringMicro.copyFromUtf8(paramString3));
      localgroupinfo.string_group_rich_finger_memo.set(ByteStringMicro.copyFromUtf8(paramString3));
    }
    localReqBody.st_group_info.set(localgroupinfo);
    paramString1 = new oidb_sso.OIDBSSOPkg();
    paramString1.uint32_command.set(2202);
    paramString1.uint32_result.set(0);
    paramString1.uint32_service_type.set(0);
    paramString1.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
    paramList = a("OidbSvc.0x89a_0");
    paramList.putWupBuffer(paramString1.toByteArray());
    paramList.extraData.putInt("key_subcmd", 1);
    b(paramList);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 4, "onReceive");
    }
    if (QLog.isDevelopLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 4, "res.getServiceCmd():" + paramFromServiceMsg.getServiceCmd());
    }
    String str = paramFromServiceMsg.getServiceCmd();
    if (a(str)) {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "cmdfilter error=" + str);
      }
    }
    do
    {
      do
      {
        long l1;
        long l2;
        int j;
        do
        {
          do
          {
            do
            {
              do
              {
                int k;
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            return;
                            if (!"OidbSvc.0x8a1_0".equals(str)) {
                              break;
                            }
                          } while (paramToServiceMsg.extraData.getInt("type", 0) != 2);
                          i(paramToServiceMsg, paramFromServiceMsg, paramObject);
                          return;
                          if ("OidbSvc.0x874_1".equals(str))
                          {
                            j(paramToServiceMsg, paramFromServiceMsg, paramObject);
                            return;
                          }
                          if ((!"OidbSvc.0x89a_0".equals(str)) && (!"OidbSvc.0x570_8".equals(str))) {
                            break;
                          }
                          i = paramToServiceMsg.extraData.getInt("key_subcmd", -1);
                          if (i == 1)
                          {
                            k(paramToServiceMsg, paramFromServiceMsg, paramObject);
                            return;
                          }
                          if (i == 2)
                          {
                            ((TroopGagMgr)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47)).a(paramToServiceMsg, paramFromServiceMsg, paramObject);
                            return;
                          }
                          if (i == 3)
                          {
                            c(paramToServiceMsg, paramFromServiceMsg, paramObject);
                            return;
                          }
                          if (i == 4)
                          {
                            l(paramToServiceMsg, paramFromServiceMsg, paramObject);
                            return;
                          }
                        } while (i != 9);
                        n(paramToServiceMsg, paramFromServiceMsg, paramObject);
                        return;
                        if (!"OidbSvc.0x89a_8".equals(str)) {
                          break;
                        }
                      } while (paramToServiceMsg.extraData.getInt("key_subcmd", -1) != 3);
                      c(paramToServiceMsg, paramFromServiceMsg, paramObject);
                      return;
                      if ("CommunityForum.GetLatestPost".equals(paramFromServiceMsg.getServiceCmd()))
                      {
                        if ((paramObject != null) && (paramFromServiceMsg.isSuccess())) {}
                        for (bool = true;; bool = false)
                        {
                          a(4, bool, paramObject);
                          return;
                        }
                      }
                      if ("OpenGroupSvc.GroupActivityInfo".equals(paramFromServiceMsg.getServiceCmd()))
                      {
                        e(paramToServiceMsg, paramFromServiceMsg, paramObject);
                        return;
                      }
                      if ("GroupActivity.GetList".equals(paramFromServiceMsg.getServiceCmd()))
                      {
                        g(paramToServiceMsg, paramFromServiceMsg, paramObject);
                        return;
                      }
                      if ("OidbSvc.0x78f_1".equals(paramFromServiceMsg.getServiceCmd()))
                      {
                        f(paramToServiceMsg, paramFromServiceMsg, paramObject);
                        return;
                      }
                      if ("OidbSvc.0x5d6_1".equals(paramFromServiceMsg.getServiceCmd()))
                      {
                        h(paramToServiceMsg, paramFromServiceMsg, paramObject);
                        return;
                      }
                    } while ("OidbSvc.0x88c_1".equals(paramFromServiceMsg.getServiceCmd()));
                    if (!"OidbSvc.0x580_1".equals(paramFromServiceMsg.getServiceCmd())) {
                      break;
                    }
                  } while (paramFromServiceMsg.getResultCode() != 1000);
                  i = paramToServiceMsg.extraData.getInt("appId");
                  l1 = paramToServiceMsg.extraData.getLong("troopUin");
                  l2 = paramToServiceMsg.extraData.getLong("troopCode");
                  l3 = paramToServiceMsg.extraData.getLong("userUin");
                  paramFromServiceMsg = paramToServiceMsg.extraData.getString("feedsId");
                  j = paramToServiceMsg.extraData.getInt("time");
                  str = paramToServiceMsg.extraData.getString("cmd");
                  k = paramToServiceMsg.extraData.getInt("feedType");
                  bool = paramToServiceMsg.extraData.getBoolean("aioRequest", false);
                  paramToServiceMsg = (byte[])paramObject;
                  paramToServiceMsg = TroopNotificationHelper.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, i, l1, l2, l3, paramFromServiceMsg, j, paramToServiceMsg);
                } while ((TextUtils.isEmpty(str)) || (paramToServiceMsg == null));
                short s = (short)paramToServiceMsg.length;
                if ("OidbSvc.0x852_35".equals(str))
                {
                  TroopNotificationHelper.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, i, l1, l2, s, paramToServiceMsg, l3, paramFromServiceMsg, j);
                  return;
                }
                if ("OidbSvc.0x852_48".equals(str))
                {
                  TroopNotificationHelper.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, i, l1, l2, s, paramToServiceMsg, (short)k, bool);
                  return;
                }
              } while (!"OidbSvc.0x8ca_2".equals(str));
              ((TroopHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "" + l1, paramToServiceMsg, i);
              return;
              if (!"OidbSvc.0x852_35".equals(paramFromServiceMsg.getServiceCmd())) {
                break;
              }
            } while (paramFromServiceMsg.getResultCode() != 1000);
            i = paramToServiceMsg.extraData.getInt("appId");
            l1 = paramToServiceMsg.extraData.getLong("troopUin");
            l2 = paramToServiceMsg.extraData.getLong("troopCode");
            long l3 = paramToServiceMsg.extraData.getLong("userUin");
            paramFromServiceMsg = paramToServiceMsg.extraData.getString("feedsId");
            j = paramToServiceMsg.extraData.getInt("time");
            paramToServiceMsg = (byte[])paramObject;
            TroopNotificationHelper.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, i, l1, l2, l3, paramFromServiceMsg, j, paramToServiceMsg);
            return;
            if (!"OidbSvc.0x852_48".equals(paramFromServiceMsg.getServiceCmd())) {
              break;
            }
          } while (paramFromServiceMsg.getResultCode() != 1000);
          i = paramToServiceMsg.extraData.getInt("appId");
          l1 = paramToServiceMsg.extraData.getLong("troopUin");
          l2 = paramToServiceMsg.extraData.getLong("troopCode");
          paramToServiceMsg.extraData.getLong("userUin");
          paramToServiceMsg.extraData.getString("feedsId");
          paramToServiceMsg.extraData.getInt("time");
          j = paramToServiceMsg.extraData.getInt("feedType");
          boolean bool = paramToServiceMsg.extraData.getBoolean("aioRequest", false);
          paramToServiceMsg = (byte[])paramObject;
          paramToServiceMsg = TroopNotificationHelper.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, l1, l2, paramToServiceMsg, j, i);
          if ((paramToServiceMsg != null) && (bool))
          {
            BaseApplicationImpl.getContext().getSharedPreferences("troop_new_guid", 0).edit().putBoolean(String.valueOf(l2), true).commit();
            a(24, true, Long.valueOf(l2));
            return;
          }
          if ((j == 23) && (paramToServiceMsg != null))
          {
            a(21, true, paramToServiceMsg);
            return;
          }
        } while ((j != 34) || (paramToServiceMsg == null));
        paramFromServiceMsg = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
        paramObject = new ArrayList();
        paramObject.add(paramToServiceMsg);
        int i = (int)MessageCache.a();
        paramFromServiceMsg.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(l1), String.valueOf(l2), paramObject, 34, i, 0);
        paramToServiceMsg = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
        if (paramToServiceMsg != null) {
          paramToServiceMsg.sendEmptyMessage(1009);
        }
        BaseApplicationImpl.getContext().getSharedPreferences("troop_new_guid", 4).edit().putBoolean(String.valueOf(l2), true).commit();
        return;
        if ("VideoShareSrv.get_video_src".equals(paramFromServiceMsg.getServiceCmd()))
        {
          m(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("OidbSvc.0x568_22".equals(paramFromServiceMsg.getServiceCmd()))
        {
          b(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("OidbSvc.0x568_21".equals(paramFromServiceMsg.getServiceCmd()))
        {
          o(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("GrpMemberLBS.ReportLBS".equals(paramFromServiceMsg.getServiceCmd()))
        {
          r(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("OidbSvc.0x8b4".equals(paramFromServiceMsg.getServiceCmd()))
        {
          q(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if (!"OidbSvc.0x5d6_3".equals(paramFromServiceMsg.getServiceCmd())) {
          break;
        }
        str = paramToServiceMsg.extraData.getString("bizname");
      } while ((str == null) || (!str.equals("shareSelfLbs")));
      p(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
      if ("ModifyExamine.GetModifyTimes".equals(paramFromServiceMsg.getServiceCmd()))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("GroupFileAppSvr.GetFileInfo".equals(str))
      {
        a(39, true, paramObject);
        return;
      }
    } while (!"GroupFileAppSvr.GetFileSearch".equals(str));
    a(41, true, paramObject);
  }
  
  public void a(Object paramObject)
  {
    a(9, true, paramObject);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString + ".troop.location_info", 2, "modifyTroopName==>name:" + paramString2);
    }
    Object localObject1 = new oidb_0x89a.ReqBody();
    try
    {
      long l = Long.parseLong(paramString1);
      ((oidb_0x89a.ReqBody)localObject1).uint64_group_code.set(l);
      Object localObject2 = new oidb_0x89a.groupinfo();
      if (!TextUtils.isEmpty(paramString2)) {
        ((oidb_0x89a.groupinfo)localObject2).string_group_name.set(ByteStringMicro.copyFromUtf8(paramString2));
      }
      ((oidb_0x89a.ReqBody)localObject1).st_group_info.set((MessageMicro)localObject2);
      localObject2 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2202);
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x89a.ReqBody)localObject1).toByteArray()));
      localObject1 = a("OidbSvc.0x89a_0");
      ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
      ((ToServiceMsg)localObject1).extraData.putInt("key_subcmd", 4);
      ((ToServiceMsg)localObject1).extraData.putString("troopUin", paramString1);
      ((ToServiceMsg)localObject1).extraData.putString("name", paramString2);
      b((ToServiceMsg)localObject1);
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    int i = 1;
    paramString1 = new cmd0x8b4.ReqBody();
    paramString1.uint64_gc.set(Long.parseLong(paramString2));
    Object localObject;
    if (paramInt == 3)
    {
      localObject = paramString1.uint32_flag;
      if (paramBoolean != true) {
        break label148;
      }
    }
    for (;;)
    {
      ((PBUInt32Field)localObject).set(i);
      localObject = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(2228);
      ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramString1.toByteArray()));
      ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(paramInt);
      paramString1 = a("OidbSvc.0x8b4");
      paramString1.putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject).toByteArray());
      paramString1.extraData.putLong("troop_code", Long.parseLong(paramString2));
      paramString1.extraData.putInt("servicetype", paramInt);
      paramString1.extraData.putString("troopCode", paramString2);
      b(paramString1);
      return;
      label148:
      i = 2;
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    Object localObject = new oidb_0x89a.ReqBody();
    ((oidb_0x89a.ReqBody)localObject).uint64_group_code.set(Long.valueOf(paramString).longValue());
    paramString = new oidb_0x89a.groupinfo();
    if (!paramBoolean) {}
    for (int i = 8192;; i = 0)
    {
      paramString.uint32_group_flagext3.set(i);
      paramString.uint32_group_flagext3_mask.set(8192);
      ((oidb_0x89a.ReqBody)localObject).st_group_info.set(paramString);
      paramString = new oidb_sso.OIDBSSOPkg();
      paramString.uint32_command.set(2202);
      paramString.uint32_result.set(0);
      paramString.uint32_service_type.set(0);
      paramString.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x89a.ReqBody)localObject).toByteArray()));
      localObject = a("OidbSvc.0x89a_0");
      ((ToServiceMsg)localObject).putWupBuffer(paramString.toByteArray());
      ((ToServiceMsg)localObject).extraData.putInt("key_subcmd", 9);
      b((ToServiceMsg)localObject);
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_a_of_type_JavaLangString, 2, "setConfessTalkSwitch isOn :" + paramBoolean);
      }
      return;
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    paramString = new ToServiceMsg("mobileqq.service", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString);
    paramString.putWupBuffer(paramArrayOfByte);
    if (paramBundle != null) {
      paramString.extraData = paramBundle;
    }
    b(paramString);
  }
  
  public void a(List paramList, int paramInt)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "setCommonlyUsedTroopList， troopUinList is null or empty ...");
      }
      return;
    }
    TroopManager localTroopManager = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    long l = NetConnInfoCenter.getServerTime();
    Object localObject1 = new ArrayList();
    ArrayList localArrayList1;
    if (paramList.size() > 20)
    {
      localArrayList1 = new ArrayList(paramList.subList(19, paramList.size()));
      paramList = paramList.subList(0, 19);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "troopUinList.size() > 20， troopUinListLeft size :" + localArrayList1.size());
      }
    }
    for (;;)
    {
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        String str = (String)paramList.next();
        Object localObject2 = new oidb_0x5d6.SnsUpdateItem();
        ((oidb_0x5d6.SnsUpdateItem)localObject2).uint32_update_sns_type.set(13569);
        if (paramInt == 0)
        {
          int i = (byte)(int)(l >> 24 & 0xFF);
          int j = (byte)(int)(l >> 16 & 0xFF);
          int k = (byte)(int)(l >> 8 & 0xFF);
          int m = (byte)(int)(0xFF & l);
          ((oidb_0x5d6.SnsUpdateItem)localObject2).bytes_value.set(ByteStringMicro.copyFrom(new byte[] { i, j, k, m }));
        }
        for (;;)
        {
          ArrayList localArrayList2 = new ArrayList();
          localArrayList2.add(localObject2);
          localObject2 = new oidb_0x5d6.SnsUpateBuffer();
          ((oidb_0x5d6.SnsUpateBuffer)localObject2).uint64_uin.set(a(localTroopManager.d(str)));
          ((oidb_0x5d6.SnsUpateBuffer)localObject2).rpt_msg_sns_update_item.set(localArrayList2);
          ((List)localObject1).add(localObject2);
          break;
          if (paramInt != 1) {}
        }
      }
      paramList = new oidb_0x5d6.ReqBody();
      paramList.uint32_domain.set(11);
      paramList.uint32_seq.set(0);
      paramList.rpt_msg_update_buffer.set((List)localObject1);
      localObject1 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1494);
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_result.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(11);
      ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramList.toByteArray()));
      paramList = a("OidbSvc.0x5d6_1");
      paramList.extraData.putBoolean("isList", true);
      paramList.extraData.putInt("reqType", paramInt);
      paramList.extraData.putLong("timestamp", l);
      paramList.extraData.putInt("update_sns_type", 13569);
      paramList.extraData.putStringArrayList("key_commonly_used_troop_list", localArrayList1);
      paramList.putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
      b(paramList);
      return;
      localArrayList1 = null;
    }
  }
  
  protected boolean a(String paramString)
  {
    if (this.jdField_b_of_type_JavaUtilSet == null)
    {
      this.jdField_b_of_type_JavaUtilSet = new HashSet();
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x89b_1");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x8a1_0");
      this.jdField_b_of_type_JavaUtilSet.add("GroupFileAppSvr.DelFile");
      this.jdField_b_of_type_JavaUtilSet.add("GroupFileAppSvr.GetFileList");
      this.jdField_b_of_type_JavaUtilSet.add("GroupFileAppSvr.GetFileListV2");
      this.jdField_b_of_type_JavaUtilSet.add("GroupFileAppSvr.GetFileInfo");
      this.jdField_b_of_type_JavaUtilSet.add("GroupFileAppSvr.GetFileSearch");
      this.jdField_b_of_type_JavaUtilSet.add("CommunityForum.GetLatestPost");
      this.jdField_b_of_type_JavaUtilSet.add("OpenGroupSvc.GroupActivityInfo");
      this.jdField_b_of_type_JavaUtilSet.add("GroupActivity.GetList");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x78f_1");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x5d6_3");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x5d6_1");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x8cf_6");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x8d3_1");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x852_35");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x580_1");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x88c_1");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x852_48");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x89a_0");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x89a_8");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x570_8");
      this.jdField_b_of_type_JavaUtilSet.add("VideoShareSrv.get_video_src");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x568_22");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x568_21");
      this.jdField_b_of_type_JavaUtilSet.add("GrpMemberLBS.ReportLBS");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x8b4");
      this.jdField_b_of_type_JavaUtilSet.add("ModifyExamine.GetModifyTimes");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x874_1");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x904_1");
    }
    return !this.jdField_b_of_type_JavaUtilSet.contains(paramString);
  }
  
  public boolean a(String paramString, int paramInt)
  {
    int i1 = HttpUtil.a();
    int n = i1;
    if (i1 == -1) {
      n = 2;
    }
    if (n == 0)
    {
      QQToast.a(BaseApplication.getContext(), 2131429835, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131558448));
      return false;
    }
    Object localObject1 = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    String str = ((TroopManager)localObject1).b(paramString);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "setCommonlyUsedTroop, troopCode = " + paramString + ", troopUin = " + str);
    }
    if (SharedPreUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).contains(str))
    {
      l = NetConnInfoCenter.getServerTime();
      if (paramInt == 0) {
        ((TroopManager)localObject1).a(str, l);
      }
      for (;;)
      {
        a(18, true, new Object[] { str, Integer.valueOf(paramInt), Integer.valueOf(0), null });
        return true;
        ((TroopManager)localObject1).c(str);
      }
    }
    Object localObject2 = new oidb_0x5d6.SnsUpdateItem();
    ((oidb_0x5d6.SnsUpdateItem)localObject2).uint32_update_sns_type.set(13569);
    long l = NetConnInfoCenter.getServerTime();
    if (paramInt == 0)
    {
      int i = (byte)(int)(l >> 24 & 0xFF);
      int j = (byte)(int)(l >> 16 & 0xFF);
      int k = (byte)(int)(l >> 8 & 0xFF);
      int m = (byte)(int)(l & 0xFF);
      ((oidb_0x5d6.SnsUpdateItem)localObject2).bytes_value.set(ByteStringMicro.copyFrom(new byte[] { i, j, k, m }));
    }
    for (;;)
    {
      localObject1 = new ArrayList();
      ((List)localObject1).add(localObject2);
      localObject2 = new oidb_0x5d6.SnsUpateBuffer();
      ((oidb_0x5d6.SnsUpateBuffer)localObject2).uint64_uin.set(a(paramString));
      ((oidb_0x5d6.SnsUpateBuffer)localObject2).rpt_msg_sns_update_item.set((List)localObject1);
      paramString = new ArrayList();
      paramString.add(localObject2);
      localObject1 = new oidb_0x5d6.ReqBody();
      ((oidb_0x5d6.ReqBody)localObject1).uint32_domain.set(11);
      ((oidb_0x5d6.ReqBody)localObject1).uint32_seq.set(0);
      ((oidb_0x5d6.ReqBody)localObject1).rpt_msg_update_buffer.set(paramString);
      paramString = new oidb_sso.OIDBSSOPkg();
      paramString.uint32_command.set(1494);
      paramString.uint32_result.set(0);
      paramString.uint32_service_type.set(11);
      paramString.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x5d6.ReqBody)localObject1).toByteArray()));
      localObject1 = a("OidbSvc.0x5d6_1");
      ((ToServiceMsg)localObject1).extraData.putString("troopUin", str);
      ((ToServiceMsg)localObject1).extraData.putInt("reqType", paramInt);
      ((ToServiceMsg)localObject1).extraData.putLong("timestamp", l);
      ((ToServiceMsg)localObject1).extraData.putInt("update_sns_type", 13569);
      ((ToServiceMsg)localObject1).putWupBuffer(paramString.toByteArray());
      b((ToServiceMsg)localObject1);
      return true;
      if (paramInt != 1) {}
    }
  }
  
  public void b()
  {
    SosoInterface.a(new zhr(this, 0, false, true, 180000L, false, false, this.jdField_a_of_type_JavaLangString));
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = paramToServiceMsg.extraData.getBoolean("isAllowAnonymousChat", false);
    if ((paramObject == null) || (!paramFromServiceMsg.isSuccess()))
    {
      a(30, false, Boolean.valueOf(bool));
      return;
    }
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramToServiceMsg == null) || (!paramToServiceMsg.uint32_result.has()) || (!paramToServiceMsg.bytes_bodybuffer.has()) || (paramToServiceMsg.bytes_bodybuffer.get() == null))
      {
        a(30, false, Boolean.valueOf(bool));
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      a(30, false, Boolean.valueOf(bool));
      return;
    }
    if (paramToServiceMsg.uint32_result.get() != 0)
    {
      a(30, false, Boolean.valueOf(bool));
      return;
    }
    a(30, true, Boolean.valueOf(bool));
  }
  
  public void b(Object paramObject)
  {
    a(13, true, paramObject);
  }
  
  public void b(String paramString1, String paramString2)
  {
    modifyexamine.ReqBody localReqBody = new modifyexamine.ReqBody();
    localReqBody.uint64_gc.set(Long.valueOf(paramString1).longValue());
    localReqBody.skey.set(paramString2);
    paramString1 = a("ModifyExamine.GetModifyTimes");
    paramString1.putWupBuffer(localReqBody.toByteArray());
    b(paramString1);
  }
  
  public void b(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = ByteBuffer.allocate(5);
    for (;;)
    {
      try
      {
        ((ByteBuffer)localObject).putInt(Integer.valueOf(paramString).intValue());
        if (!paramBoolean) {
          break label155;
        }
        ((ByteBuffer)localObject).put((byte)1);
        localObject = ((ByteBuffer)localObject).array();
        paramString = new oidb_sso.OIDBSSOPkg();
        paramString.uint32_command.set(1384);
        paramString.uint32_result.set(0);
        paramString.uint32_service_type.set(22);
        paramString.bytes_bodybuffer.set(ByteStringMicro.copyFrom((byte[])localObject));
        localObject = a("OidbSvc.0x568_22");
        ((ToServiceMsg)localObject).putWupBuffer(paramString.toByteArray());
        ((ToServiceMsg)localObject).extraData.putBoolean("isAllowAnonymousChat", paramBoolean);
        b((ToServiceMsg)localObject);
        return;
      }
      catch (NumberFormatException localNumberFormatException) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "setAnonymousChat failed because NumberFormatException, troopUin : " + paramString);
      return;
      label155:
      localNumberFormatException.put((byte)0);
    }
  }
  
  public void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      a(36, false, null);
      return;
    }
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      a(36, false, null);
      return;
    }
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if (paramToServiceMsg == null)
      {
        a(36, false, null);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      a(36, false, null);
      return;
    }
    int i = paramToServiceMsg.uint32_result.get();
    if (i != 0)
    {
      a(36, false, new Object[] { Long.valueOf(i) });
      return;
    }
    paramFromServiceMsg = new oidb_0x89a.RspBody();
    try
    {
      paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
      if (paramFromServiceMsg == null)
      {
        a(36, false, null);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      a(36, false, null);
      return;
    }
    a(36, true, new Object[] { Long.valueOf(paramFromServiceMsg.uint64_group_code.get()) });
  }
  
  public void c(Object paramObject)
  {
    a(20, true, paramObject);
  }
  
  public void c(String paramString, boolean paramBoolean)
  {
    int j = 2;
    if (QLog.isColorLevel()) {
      QLog.d("Q.troopMemberDistance", 2, "BizHandler, setShareSelfLbsInTroop:" + paramString + ", " + paramBoolean);
    }
    Object localObject2 = new oidb_0x5d6.SnsUpdateItem();
    ((oidb_0x5d6.SnsUpdateItem)localObject2).uint32_update_sns_type.set(13571);
    if (paramBoolean) {
      j = 1;
    }
    if (paramBoolean) {}
    for (int i = (byte)(j & 0x1);; i = (byte)(j & 0x2))
    {
      ((oidb_0x5d6.SnsUpdateItem)localObject2).bytes_value.set(ByteStringMicro.copyFrom(new byte[] { i }));
      ((oidb_0x5d6.SnsUpdateItem)localObject2).uint32_value_offset.set(0);
      Object localObject1 = new ArrayList();
      ((List)localObject1).add(localObject2);
      localObject2 = new oidb_0x5d6.SnsUpateBuffer();
      ((oidb_0x5d6.SnsUpateBuffer)localObject2).uint64_uin.set(a(paramString));
      ((oidb_0x5d6.SnsUpateBuffer)localObject2).rpt_msg_sns_update_item.set((List)localObject1);
      localObject1 = new ArrayList();
      ((List)localObject1).add(localObject2);
      localObject2 = new oidb_0x5d6.ReqBody();
      ((oidb_0x5d6.ReqBody)localObject2).uint32_domain.set(11);
      ((oidb_0x5d6.ReqBody)localObject2).uint32_seq.set(0);
      ((oidb_0x5d6.ReqBody)localObject2).rpt_msg_update_buffer.set((List)localObject1);
      localObject1 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1494);
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_result.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(3);
      ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x5d6.ReqBody)localObject2).toByteArray()));
      TroopManager localTroopManager = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      localObject2 = a("OidbSvc.0x5d6_3");
      paramString = localTroopManager.b(paramString);
      ((ToServiceMsg)localObject2).extraData.putString("troopUin", paramString);
      ((ToServiceMsg)localObject2).extraData.putString("bizname", "shareSelfLbs");
      ((ToServiceMsg)localObject2).extraData.putBoolean("isShare", paramBoolean);
      ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
      b((ToServiceMsg)localObject2);
      return;
    }
  }
  
  public void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l3 = -1L;
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      a(38, false, null);
      return;
    }
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      a(38, false, null);
      return;
    }
    if ((paramObject == null) || (!paramFromServiceMsg.isSuccess()))
    {
      a(38, false, null);
      return;
    }
    paramToServiceMsg = (byte[])paramObject;
    paramFromServiceMsg = new modifyexamine.RspBody();
    for (;;)
    {
      try
      {
        paramFromServiceMsg.mergeFrom(paramToServiceMsg);
        if (!paramFromServiceMsg.uint32_result.has()) {
          break label236;
        }
        l1 = paramFromServiceMsg.uint32_result.get();
        if (!paramFromServiceMsg.uint32_limit_times.has()) {
          break label228;
        }
        l2 = paramFromServiceMsg.uint32_limit_times.get();
        if (paramFromServiceMsg.uint32_modify_times.has()) {
          l3 = paramFromServiceMsg.uint32_modify_times.get();
        }
        paramToServiceMsg = "";
        if (paramFromServiceMsg.str_errmsg.has()) {
          paramToServiceMsg = paramFromServiceMsg.str_errmsg.get();
        }
        a(38, true, new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), paramToServiceMsg });
        return;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
      }
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.i(this.jdField_a_of_type_JavaLangString, 4, "onRspResend parsing error");
      return;
      label228:
      long l2 = -1L;
      continue;
      label236:
      long l1 = -1L;
    }
  }
  
  public void d(Object paramObject)
  {
    a(22, true, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.BizTroopHandler
 * JD-Core Version:    0.7.0.1
 */