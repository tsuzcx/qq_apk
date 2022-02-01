package com.tencent.mobileqq.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.richstatus.ExtensionRichStatus;
import com.tencent.mobileqq.richstatus.HistorySignItem;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.RichStatus.SigZanInfo;
import com.tencent.mobileqq.richstatus.comment.bean.CommentItem;
import com.tencent.mobileqq.richstatus.comment.bean.LikeItem;
import com.tencent.mobileqq.richstatus.comment.bean.User;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.pb.signature.SigActPb.RspBody;
import com.tencent.pb.signature.SigActPb.SigactRsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.NewIntent;
import tencent.im.oidb.cmd0x792.oidb_0x792.ReqBody;
import tencent.im.oidb.cmd0x792.oidb_0x792.RspBody;
import tencent.im.oidb.cmd0x793.oidb_0x793.ReqBody;
import tencent.im.oidb.cmd0x793.oidb_0x793.RspBody;
import tencent.im.oidb.cmd0x793.oidb_0x793.UinListInfo;
import tencent.im.oidb.cmd0x795.oidb_0x795.ReqBody;
import tencent.im.oidb.cmd0x795.oidb_0x795.RspBody;
import tencent.im.oidb.cmd0x796.oidb_0x796.ItemInfo;
import tencent.im.oidb.cmd0x796.oidb_0x796.ReqBody;
import tencent.im.oidb.cmd0x796.oidb_0x796.RspBody;
import tencent.im.oidb.cmd0x798.oidb_0x798.Info;
import tencent.im.oidb.cmd0x798.oidb_0x798.ReqBody;
import tencent.im.oidb.cmd0x798.oidb_0x798.RspBody;
import tencent.im.oidb.cmd0x799.oidb_0x799.LongNickInfo;
import tencent.im.oidb.cmd0x799.oidb_0x799.ReqBody;
import tencent.im.oidb.cmd0x799.oidb_0x799.RspBody;
import tencent.im.oidb.oidb_0xd9e.oidb_0xd9e.ReqBody;
import tencent.im.oidb.oidb_0xd9e.oidb_0xd9e.RspBody;
import tencent.im.oidb.oidb_0xd9e.oidb_0xd9e.UserTopicItem;
import tencent.im.oidb.oidb_0xda6.oidb_0xda6.ReqBody;
import tencent.im.oidb.oidb_0xda6.oidb_0xda6.RspBody;
import tencent.im.oidb.oidb_0xda6.oidb_0xda6.UserTopicItem;
import tencent.im.oidb.oidb_0xdd6.oidb_0xdd6.ReqBody;
import tencent.im.oidb.oidb_0xdd6.oidb_0xdd6.RspBody;
import tencent.im.oidb.oidb_0xde5.oidb_0xde5.ReqBody;
import tencent.im.oidb.oidb_0xde5.oidb_0xde5.RspBody;
import tencent.im.oidb.oidb_0xde7.oidb_0xde7.ReqBody;
import tencent.im.oidb.oidb_0xde7.oidb_0xde7.RspBody;
import tencent.im.oidb.oidb_0xde8.oidb_0xde8.CommentItem;
import tencent.im.oidb.oidb_0xde8.oidb_0xde8.NickInfo;
import tencent.im.oidb.oidb_0xde8.oidb_0xde8.ReqBody;
import tencent.im.oidb.oidb_0xde8.oidb_0xde8.RspBody;
import tencent.im.oidb.oidb_0xde8.oidb_0xde8.lightCommentInfo;
import tencent.im.oidb.oidb_0xde8.oidb_0xde8.lightCommentItem;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class SignatureHandler
  extends BusinessHandler
{
  private int jdField_a_of_type_Int = 0;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  protected SignatureHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private boolean a(String[] paramArrayOfString, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length != 0))
    {
      if (paramArrayOfByte == null) {
        return false;
      }
      Object localObject = new ArrayList(paramArrayOfString.length);
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        ((List)localObject).add(ByteStringMicro.copyFrom(paramArrayOfString[i].getBytes()));
        i += 1;
      }
      paramArrayOfString = new oidb_0x799.ReqBody();
      paramArrayOfString.StrTopicIdList.set((List)localObject);
      localObject = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(1945);
      ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramArrayOfString.toByteArray()));
      paramArrayOfString = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), SignatureServlet.class);
      if (paramArrayOfByte != null) {
        paramArrayOfString.putExtra("reqData", paramArrayOfByte);
      }
      paramArrayOfString.putExtra("cmd", "OidbSvc.0x799_0");
      paramArrayOfString.putExtra("data", ((oidb_sso.OIDBSSOPkg)localObject).toByteArray());
      paramArrayOfString.putExtra("timeout", 10000L);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(paramArrayOfString);
      return true;
    }
    return false;
  }
  
  private void b(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    paramIntent = new SigActPb.RspBody();
    paramIntent.mergeFrom(paramArrayOfByte);
    if (paramIntent.ret.get() == 0)
    {
      notifyUI(7, true, Integer.valueOf(((SigActPb.SigactRsp)paramIntent.rsp.get()).rank.get()));
      return;
    }
    notifyUI(7, false, Integer.valueOf(paramIntent.ret.get()));
  }
  
  private void c(Intent paramIntent, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    Object localObject = new oidb_0x798.RspBody();
    ((oidb_0x798.RspBody)localObject).mergeFrom(paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
    int i = ((oidb_0x798.RspBody)localObject).uint32_result.get();
    if (i == 0)
    {
      if ((((oidb_0x798.RspBody)localObject).stInfos.has()) && (((oidb_0x798.RspBody)localObject).stInfos.get().size() > 0))
      {
        String str1 = paramIntent.getStringExtra("uin");
        String str2 = paramIntent.getStringExtra("feedsid");
        paramOIDBSSOPkg = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(str1);
        paramIntent = null;
        if (paramOIDBSSOPkg != null)
        {
          paramOIDBSSOPkg = ExtensionRichStatus.a(paramOIDBSSOPkg);
          paramIntent = paramOIDBSSOPkg;
          if (paramOIDBSSOPkg == null) {
            return;
          }
        }
        if ((paramIntent != null) && (!TextUtils.isEmpty(paramIntent.feedsId)) && (paramIntent.feedsId.equals(str2)) && (paramIntent.sigZanInfo == null)) {
          paramIntent.sigZanInfo = new HashMap(((oidb_0x798.RspBody)localObject).stInfos.get().size());
        }
        paramOIDBSSOPkg = ((oidb_0x798.RspBody)localObject).stInfos.get();
        i = 0;
        while (i < paramOIDBSSOPkg.size())
        {
          RichStatus.SigZanInfo localSigZanInfo = new RichStatus.SigZanInfo();
          oidb_0x798.Info localInfo = (oidb_0x798.Info)paramOIDBSSOPkg.get(i);
          localSigZanInfo.jdField_a_of_type_JavaLangString = str2;
          localSigZanInfo.b = localInfo.uint32_count.get();
          localSigZanInfo.jdField_a_of_type_Int = localInfo.uint32_type.get();
          localSigZanInfo.c = localInfo.uint32_flag.get();
          if (paramIntent != null) {
            paramIntent.sigZanInfo.put(Integer.valueOf(localSigZanInfo.jdField_a_of_type_Int), localSigZanInfo);
          }
          i += 1;
        }
        long l1 = ((oidb_0x798.RspBody)localObject).uint64_sleeptime.get();
        long l2 = System.currentTimeMillis();
        paramOIDBSSOPkg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("sigCommentUpdateTimeStamp_");
        ((StringBuilder)localObject).append(str1);
        paramOIDBSSOPkg.putLong(((StringBuilder)localObject).toString(), l1 * 1000L + l2).commit();
        if ((paramIntent != null) && (paramIntent.sigZanInfo.get(Integer.valueOf(255)) != null))
        {
          this.jdField_a_of_type_Int = 92;
          notifyUI(this.jdField_a_of_type_Int, true, paramIntent.sigZanInfo.get(Integer.valueOf(255)));
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("handleGetSigZanInfo fail ret=");
      paramIntent.append(i);
      QLog.d("SignatureHandler", 2, paramIntent.toString());
    }
  }
  
  private void d(Intent paramIntent, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    oidb_0x795.RspBody localRspBody = new oidb_0x795.RspBody();
    localRspBody.mergeFrom(paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
    String str1 = paramIntent.getStringExtra("feedid");
    String str2 = paramIntent.getStringExtra("uin");
    boolean bool = false;
    int j = paramIntent.getIntExtra("action", 0);
    int k = paramIntent.getIntExtra("type", 0);
    paramIntent = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(str2);
    this.jdField_a_of_type_Int = 92;
    paramOIDBSSOPkg = ExtensionRichStatus.a(paramIntent);
    if ((paramIntent != null) && (str1.equals(paramOIDBSSOPkg.feedsId)) && (paramOIDBSSOPkg.sigZanInfo != null))
    {
      paramOIDBSSOPkg = (RichStatus.SigZanInfo)paramOIDBSSOPkg.sigZanInfo.get(Integer.valueOf(255));
      paramIntent = paramOIDBSSOPkg;
      if (localRspBody.uint32_result.get() == 0) {
        if (1 == j)
        {
          paramOIDBSSOPkg.b += 1;
          paramOIDBSSOPkg.c = 1;
          paramIntent = paramOIDBSSOPkg;
        }
        else
        {
          i = paramOIDBSSOPkg.b - 1;
          paramOIDBSSOPkg.b = i;
          if (i > 0) {
            i = paramOIDBSSOPkg.b;
          } else {
            i = 0;
          }
          paramOIDBSSOPkg.b = i;
          paramOIDBSSOPkg.c = 0;
          paramIntent = paramOIDBSSOPkg;
        }
      }
    }
    else
    {
      paramIntent = null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("SignatureHandler", 2, String.format("handleInteractiveSigature[%s %s %d %d]", new Object[] { StringUtil.e(str2), str1, Integer.valueOf(k), Integer.valueOf(j) }));
    }
    int i = this.jdField_a_of_type_Int;
    if (localRspBody.uint32_result.get() == 0) {
      bool = true;
    }
    notifyUI(i, bool, paramIntent);
  }
  
  private void e(Intent paramIntent, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    Object localObject1 = new oidb_0x796.RspBody();
    ((oidb_0x796.RspBody)localObject1).mergeFrom(paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
    paramOIDBSSOPkg = paramIntent.getStringExtra("feedid");
    boolean bool2 = paramIntent.getBooleanExtra("firstFlag", true);
    int i = ((oidb_0x796.RspBody)localObject1).uint32_result.get();
    boolean bool1 = false;
    if (i == 0)
    {
      if (((oidb_0x796.RspBody)localObject1).uint32_flag.get() == 0) {
        bool1 = true;
      }
      ((oidb_0x796.RspBody)localObject1).uint32_rsp_seq.get();
      ((oidb_0x796.RspBody)localObject1).uint32_need_update.get();
      paramIntent = (oidb_0x796.ItemInfo)((oidb_0x796.RspBody)localObject1).stPagePointItem.get();
      Object localObject2;
      StringBuilder localStringBuilder;
      if (!bool1)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("sigCommentDetailUin_");
        localStringBuilder.append(paramOIDBSSOPkg);
        localObject2 = ((SharedPreferences.Editor)localObject2).putLong(localStringBuilder.toString(), paramIntent.uint64_uin.get());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("sigCommentDetailTime_");
        localStringBuilder.append(paramOIDBSSOPkg);
        ((SharedPreferences.Editor)localObject2).putLong(localStringBuilder.toString(), paramIntent.uint64_time.get()).commit();
      }
      if ((((oidb_0x796.RspBody)localObject1).rpt_items != null) && (((oidb_0x796.RspBody)localObject1).rpt_items.size() > 0))
      {
        paramIntent = new ArrayList(((oidb_0x796.RspBody)localObject1).rpt_items.get().size());
        localObject1 = ((oidb_0x796.RspBody)localObject1).rpt_items.get().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (oidb_0x796.ItemInfo)((Iterator)localObject1).next();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(((oidb_0x796.ItemInfo)localObject2).uint64_uin.get());
          localStringBuilder.append("");
          localObject2 = localStringBuilder.toString();
          if (!paramIntent.contains(localObject2)) {
            paramIntent.add(localObject2);
          }
        }
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("feedid", paramOIDBSSOPkg);
        ((Bundle)localObject1).putBoolean("overFlag", bool1);
        ((Bundle)localObject1).putBoolean("firstFlag", bool2);
        ((Bundle)localObject1).putStringArrayList("uins", paramIntent);
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("oidb796cmd feedid=");
          ((StringBuilder)localObject2).append(paramOIDBSSOPkg);
          ((StringBuilder)localObject2).append(", firstFlag=");
          ((StringBuilder)localObject2).append(bool2);
          ((StringBuilder)localObject2).append(", overFlag=");
          ((StringBuilder)localObject2).append(bool1);
          ((StringBuilder)localObject2).append(",num:");
          ((StringBuilder)localObject2).append(paramIntent.size());
          QLog.d("SignatureHandler", 2, ((StringBuilder)localObject2).toString());
        }
        notifyUI(3, true, localObject1);
      }
    }
    else
    {
      notifyUI(3, false, Integer.valueOf(i));
    }
  }
  
  private void f(Intent paramIntent, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    paramIntent = new oidb_0x792.RspBody();
    byte[] arrayOfByte = paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray();
    if (paramOIDBSSOPkg.uint32_result.get() == 0)
    {
      paramIntent.mergeFrom(arrayOfByte);
      if (paramIntent.uint32_result.get() == 0)
      {
        int i = paramIntent.uint32_newnum.get();
        int j = paramIntent.uint32_sleeptime.get();
        long l = paramIntent.uint64_lastuin.get();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putLong("sigNewCommentLastFetchTime", System.currentTimeMillis() + j * 1000);
        if ((i != 0) && (0L != l))
        {
          paramIntent = new Bundle();
          paramIntent.putInt("unReadNum", i);
          paramIntent.putLong("lastUin", l);
          notifyUI(5, true, paramIntent);
        }
      }
      else if (QLog.isColorLevel())
      {
        paramOIDBSSOPkg = new StringBuilder();
        paramOIDBSSOPkg.append("handleGetNewCommentNum fial retcode:");
        paramOIDBSSOPkg.append(paramIntent.uint32_result.get());
        QLog.d("SignatureHandler", 2, paramOIDBSSOPkg.toString());
      }
    }
  }
  
  private void g(Intent paramIntent, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    oidb_0x793.RspBody localRspBody;
    byte[] arrayOfByte;
    if (paramOIDBSSOPkg.uint32_result.get() == 0)
    {
      localRspBody = new oidb_0x793.RspBody();
      arrayOfByte = paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray();
      localRspBody.mergeFrom(arrayOfByte);
    }
    for (;;)
    {
      try
      {
        if (localRspBody.uint32_result.get() == 0)
        {
          SignatureManager localSignatureManager = (SignatureManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SIGNATURE_MANAGER);
          paramIntent = null;
          ArrayList localArrayList = new ArrayList();
          paramOIDBSSOPkg = new ArrayList();
          Iterator localIterator = localRspBody.rpt_uinlist.get().iterator();
          if (localIterator.hasNext())
          {
            Object localObject = (oidb_0x793.UinListInfo)localIterator.next();
            paramIntent = new SignatureManager.SigCommentInfo();
            paramIntent.feedsid = new String(((oidb_0x793.UinListInfo)localObject).feedsid.get().toByteArray());
            paramIntent.type = ((oidb_0x793.UinListInfo)localObject).uint32_type.get();
            paramIntent.time = ((oidb_0x793.UinListInfo)localObject).uint64_time.get();
            paramIntent.uin = ((oidb_0x793.UinListInfo)localObject).uint64_uin.get();
            if (localSignatureManager != null)
            {
              localObject = localSignatureManager.a(paramIntent.feedsid);
              if (localObject != null)
              {
                paramIntent.rs = ((RichStatus)localObject);
                paramOIDBSSOPkg.add(paramIntent);
                break label598;
              }
            }
            localArrayList.add(paramIntent.feedsid);
            break label598;
          }
          int i = localRspBody.uint32_flag.get();
          if ((i == 0) && (paramIntent != null)) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putLong("sigNewCommentLastUin_", paramIntent.uin).putLong("sigNewCommentLastFetchTime", paramIntent.time).putString("sigNewCommentLastFeedsId_", paramIntent.feedsid).commit();
          }
          if (localArrayList.size() > 0)
          {
            if (a((String[])localArrayList.toArray(new String[localArrayList.size()]), arrayOfByte)) {
              break label597;
            }
            notifyUI(6, false, Integer.valueOf(-1000));
            return;
          }
          paramIntent = new SignatureManager.SigComments();
          if (i != 1) {
            break label601;
          }
          bool = true;
          paramIntent.isOver = bool;
          paramIntent.mlist = paramOIDBSSOPkg;
          paramOIDBSSOPkg = new Bundle();
          paramOIDBSSOPkg.putSerializable("data", paramIntent);
          notifyUI(6, true, paramOIDBSSOPkg);
          return;
        }
        if (QLog.isColorLevel())
        {
          paramIntent = new StringBuilder();
          paramIntent.append("handleGetNewComment fail ret=");
          paramIntent.append(localRspBody.uint32_result.get());
          paramIntent.append(",msg=");
          paramIntent.append(localRspBody.errMsg.get());
          QLog.d("SignatureHandler", 2, paramIntent.toString());
        }
        notifyUI(6, false, Integer.valueOf(localRspBody.uint32_result.get()));
        return;
      }
      catch (Exception paramIntent)
      {
        notifyUI(6, false, Integer.valueOf(-1));
        if (!QLog.isColorLevel()) {
          break label597;
        }
      }
      paramOIDBSSOPkg = new StringBuilder();
      paramOIDBSSOPkg.append("handleGetNewComment fail retcode=");
      paramOIDBSSOPkg.append(localRspBody.uint32_result.get());
      paramOIDBSSOPkg.append(",msg=");
      paramOIDBSSOPkg.append(paramIntent.getMessage());
      QLog.d("SignatureHandler", 2, paramOIDBSSOPkg.toString());
      return;
      notifyUI(6, false, Integer.valueOf(paramOIDBSSOPkg.uint32_result.get()));
      label597:
      return;
      label598:
      continue;
      label601:
      boolean bool = false;
    }
  }
  
  private void h(Intent paramIntent, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    int i = paramOIDBSSOPkg.uint32_result.get();
    boolean bool = false;
    if (i == 0)
    {
      Object localObject1 = new oidb_0x799.RspBody();
      ((oidb_0x799.RspBody)localObject1).mergeFrom(paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
      if (((oidb_0x799.RspBody)localObject1).uint32_result.get() == 0)
      {
        paramOIDBSSOPkg = ((oidb_0x799.RspBody)localObject1).astLongNickInfoList.get();
        localObject1 = new ArrayList(paramOIDBSSOPkg.size());
        paramOIDBSSOPkg = paramOIDBSSOPkg.iterator();
        Object localObject3;
        while (paramOIDBSSOPkg.hasNext())
        {
          localObject3 = (oidb_0x799.LongNickInfo)paramOIDBSSOPkg.next();
          localObject2 = ((oidb_0x799.LongNickInfo)localObject3).StrNick.get().toByteArray();
          localObject3 = new String(((oidb_0x799.LongNickInfo)localObject3).StrTopicId.get().toByteArray());
          localObject2 = RichStatus.parseStatus((byte[])localObject2);
          ((RichStatus)localObject2).feedsId = ((String)localObject3);
          ((List)localObject1).add(localObject2);
        }
        paramOIDBSSOPkg = (SignatureManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SIGNATURE_MANAGER);
        if (paramOIDBSSOPkg != null) {
          paramOIDBSSOPkg.a((List)localObject1);
        }
        localObject1 = paramIntent.getByteArrayExtra("reqData");
        paramIntent = new oidb_0x793.RspBody();
        paramIntent.mergeFrom((byte[])localObject1);
        localObject1 = new ArrayList(paramIntent.rpt_uinlist.size());
        Object localObject2 = paramIntent.rpt_uinlist.get().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject4 = (oidb_0x793.UinListInfo)((Iterator)localObject2).next();
          localObject3 = new SignatureManager.SigCommentInfo();
          ((SignatureManager.SigCommentInfo)localObject3).feedsid = new String(((oidb_0x793.UinListInfo)localObject4).feedsid.get().toByteArray());
          ((SignatureManager.SigCommentInfo)localObject3).type = ((oidb_0x793.UinListInfo)localObject4).uint32_type.get();
          ((SignatureManager.SigCommentInfo)localObject3).time = ((oidb_0x793.UinListInfo)localObject4).uint64_time.get();
          ((SignatureManager.SigCommentInfo)localObject3).uin = ((oidb_0x793.UinListInfo)localObject4).uint64_uin.get();
          if (paramOIDBSSOPkg != null)
          {
            localObject4 = paramOIDBSSOPkg.a(((SignatureManager.SigCommentInfo)localObject3).feedsid);
            if (localObject4 != null)
            {
              ((SignatureManager.SigCommentInfo)localObject3).rs = ((RichStatus)localObject4);
              ((List)localObject1).add(localObject3);
            }
          }
        }
        i = paramIntent.uint32_flag.get();
        paramIntent = new SignatureManager.SigComments();
        if (i == 1) {
          bool = true;
        }
        paramIntent.isOver = bool;
        paramIntent.mlist = ((List)localObject1);
        paramOIDBSSOPkg = new Bundle();
        paramOIDBSSOPkg.putSerializable("data", paramIntent);
        notifyUI(6, true, paramOIDBSSOPkg);
        return;
      }
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("handleGetRichStatusByFeedsId fail ret=");
        paramIntent.append(((oidb_0x799.RspBody)localObject1).uint32_result.get());
        QLog.d("SignatureHandler", 2, paramIntent.toString());
      }
      notifyUI(6, false, Integer.valueOf(((oidb_0x799.RspBody)localObject1).uint32_result.get()));
      return;
    }
    notifyUI(6, false, Integer.valueOf(paramOIDBSSOPkg.uint32_result.get()));
  }
  
  private void i(Intent paramIntent, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    int j = paramOIDBSSOPkg.uint32_result.get();
    int i = 0;
    if (j == 0)
    {
      Object localObject = new oidb_0xd9e.RspBody();
      ((oidb_0xd9e.RspBody)localObject).mergeFrom(paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
      paramIntent = new ArrayList();
      if (((oidb_0xd9e.RspBody)localObject).rpt_topic_item.get() != null) {
        paramIntent = ((oidb_0xd9e.RspBody)localObject).rpt_topic_item.get();
      }
      localObject = new ArrayList();
      while (i < paramIntent.size())
      {
        SignatureManager.TopicInfo localTopicInfo = new SignatureManager.TopicInfo();
        localTopicInfo.topicId = ((oidb_0xd9e.UserTopicItem)paramIntent.get(i)).uint32_topic_id.get();
        localTopicInfo.topicStr = ((oidb_0xd9e.UserTopicItem)paramIntent.get(i)).str_topic.get();
        localTopicInfo.totalNum = ((oidb_0xd9e.UserTopicItem)paramIntent.get(i)).uint32_total_num.get();
        localTopicInfo.friendNum = ((oidb_0xd9e.UserTopicItem)paramIntent.get(i)).uint32_frd_num.get();
        ((ArrayList)localObject).add(localTopicInfo);
        i += 1;
      }
      paramIntent = new Bundle();
      paramIntent.putSerializable("param_topicInfoList", (Serializable)localObject);
      paramIntent.putInt("param_searchResult", paramOIDBSSOPkg.uint32_result.get());
      notifyUI(8, true, paramIntent);
      return;
    }
    paramIntent = new Bundle();
    paramIntent.putSerializable("param_topicInfoList", null);
    paramIntent.putInt("param_searchResult", paramOIDBSSOPkg.uint32_result.get());
    notifyUI(8, false, paramIntent);
  }
  
  private void j(Intent paramIntent, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    if (paramOIDBSSOPkg.uint32_result.get() == 0)
    {
      paramIntent = new oidb_0xde5.RspBody();
      paramIntent.mergeFrom(paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
      notifyUI(11, true, Long.valueOf(paramIntent.uint64_comment_id.get()));
      return;
    }
    notifyUI(11, false, Long.valueOf(-1L));
  }
  
  private void k(Intent paramIntent, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    if (paramOIDBSSOPkg.uint32_result.get() == 0)
    {
      new oidb_0xde7.RspBody().mergeFrom(paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
      notifyUI(12, true, Integer.valueOf(0));
      return;
    }
    notifyUI(12, false, Integer.valueOf(-1));
  }
  
  private void l(Intent paramIntent, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    int i = paramOIDBSSOPkg.uint32_result.get();
    boolean bool = false;
    if (i == 0)
    {
      paramIntent = new oidb_0xde8.RspBody();
      paramIntent.mergeFrom(paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
      paramOIDBSSOPkg = new SignatureHandler.RspGetHistorySig();
      if (paramIntent.uint32_is_over.get() != 0) {
        bool = true;
      }
      paramOIDBSSOPkg.over = bool;
      paramOIDBSSOPkg.historySignItems = a(paramIntent.rpt_info.get());
      notifyUI(13, true, paramOIDBSSOPkg);
      return;
    }
    notifyUI(13, false, null);
  }
  
  public String a(long paramLong)
  {
    Friends localFriends = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(String.valueOf(paramLong));
    if (localFriends != null) {
      return localFriends.getFriendNickWithAlias();
    }
    return String.valueOf(paramLong);
  }
  
  public List<HistorySignItem> a(List<oidb_0xde8.NickInfo> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (oidb_0xde8.NickInfo)paramList.next();
        HistorySignItem localHistorySignItem = new HistorySignItem();
        localHistorySignItem.richStatus = RichStatus.parseStatus(((oidb_0xde8.NickInfo)localObject).bytes_nick.get().toByteArray());
        if (localHistorySignItem.richStatus != null)
        {
          localHistorySignItem.richStatus.feedsId = new String(((oidb_0xde8.NickInfo)localObject).bytes_feedid.get().toByteArray());
          localHistorySignItem.richStatus.time = ((oidb_0xde8.NickInfo)localObject).uint32_create_time.get();
          if (((oidb_0xde8.NickInfo)localObject).rpt_item.get() != null) {
            localHistorySignItem.commentItemList = a(((oidb_0xde8.NickInfo)localObject).rpt_item.get(), localHistorySignItem.richStatus.feedsId);
          }
          localObject = (oidb_0xde8.lightCommentInfo)((oidb_0xde8.NickInfo)localObject).msg_light_comment.get();
          if (localObject != null)
          {
            localHistorySignItem.totalLikeNum = ((oidb_0xde8.lightCommentInfo)localObject).uint64_total_num.get();
            localHistorySignItem.likeItemList = b(((oidb_0xde8.lightCommentInfo)localObject).rpt_items.get());
          }
          localArrayList.add(localHistorySignItem);
        }
      }
      return localArrayList;
    }
    return new ArrayList();
  }
  
  public List<CommentItem> a(List<oidb_0xde8.CommentItem> paramList, String paramString)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        oidb_0xde8.CommentItem localCommentItem = (oidb_0xde8.CommentItem)paramList.next();
        CommentItem localCommentItem1 = new CommentItem();
        localCommentItem1.feedId = paramString;
        localCommentItem1.id = localCommentItem.uint64_comment_id.get();
        localCommentItem1.targetId = localCommentItem.uint64_target_comment_id.get();
        localCommentItem1.timeStamp = localCommentItem.uint64_time.get();
        localCommentItem1.content = localCommentItem.str_comment.get();
        long l = localCommentItem.uint64_comment_uin.get();
        localCommentItem1.user = new User(String.valueOf(l), a(l));
        if (localCommentItem1.targetId != 0L)
        {
          l = localCommentItem.uint64_target_uin.get();
          localCommentItem1.toReplyUser = new User(String.valueOf(l), a(l));
        }
        else
        {
          localCommentItem1.toReplyUser = null;
        }
        localArrayList.add(localCommentItem1);
      }
      return localArrayList;
    }
    return new ArrayList();
  }
  
  public void a()
  {
    long l = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("sigNewCommentLastFetchTime", 0L);
    if (System.currentTimeMillis() < Long.valueOf(l).longValue())
    {
      if (QLog.isColorLevel()) {
        QLog.d("SignatureHandler", 2, "getNewCommentNum freq limit");
      }
      return;
    }
    Object localObject = new oidb_0x792.ReqBody();
    ((oidb_0x792.ReqBody)localObject).uint64_uin.set(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).longValue());
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1938);
    localOIDBSSOPkg.uint32_service_type.set(0);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x792.ReqBody)localObject).toByteArray()));
    localObject = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), SignatureServlet.class);
    ((NewIntent)localObject).putExtra("cmd", "OidbSvc.0x792_0");
    ((NewIntent)localObject).putExtra("data", localOIDBSSOPkg.toByteArray());
    ((NewIntent)localObject).putExtra("timeout", 30000L);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
  }
  
  public void a(long paramLong)
  {
    Object localObject = new oidb_0xdd6.ReqBody();
    ((oidb_0xdd6.ReqBody)localObject).uint64_uin.set(paramLong);
    ((oidb_0xdd6.ReqBody)localObject).uint64_start_time.set(0L);
    ((oidb_0xdd6.ReqBody)localObject).uint64_end_time.set(NetConnInfoCenter.getServerTimeMillis() / 1000L);
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(3542);
    localOIDBSSOPkg.uint32_service_type.set(1);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0xdd6.ReqBody)localObject).toByteArray()));
    localObject = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), SignatureServlet.class);
    ((NewIntent)localObject).putExtra("cmd", "OidbSvc.0xdd6_1");
    ((NewIntent)localObject).putExtra("data", localOIDBSSOPkg.toByteArray());
    ((NewIntent)localObject).putExtra("timeout", 10000L);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    Object localObject = new oidb_0xde8.ReqBody();
    ((oidb_0xde8.ReqBody)localObject).uint64_to_uin.set(paramLong);
    ((oidb_0xde8.ReqBody)localObject).uint32_check_fri_type.set(2);
    ((oidb_0xde8.ReqBody)localObject).uint32_start_time.set(paramInt1);
    ((oidb_0xde8.ReqBody)localObject).uint32_end_time.set(paramInt2);
    ((oidb_0xde8.ReqBody)localObject).uint32_start.set(0);
    ((oidb_0xde8.ReqBody)localObject).uint32_type.set(0);
    ((oidb_0xde8.ReqBody)localObject).uint32_num.set(6);
    ((oidb_0xde8.ReqBody)localObject).uint32_comment_size.set(60);
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(3560);
    localOIDBSSOPkg.uint32_service_type.set(1);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0xde8.ReqBody)localObject).toByteArray()));
    localObject = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), SignatureServlet.class);
    ((NewIntent)localObject).putExtra("cmd", "OidbSvc.0xde8_1");
    ((NewIntent)localObject).putExtra("data", localOIDBSSOPkg.toByteArray());
    ((NewIntent)localObject).putExtra("timeout", 10000L);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
  }
  
  public void a(long paramLong1, String paramString, long paramLong2, long paramLong3)
  {
    Object localObject = new oidb_0xde7.ReqBody();
    ((oidb_0xde7.ReqBody)localObject).uint64_longnick_uin.set(paramLong1);
    ((oidb_0xde7.ReqBody)localObject).str_longnick_id.set(paramString);
    ((oidb_0xde7.ReqBody)localObject).uint64_comment_id.set(paramLong3);
    ((oidb_0xde7.ReqBody)localObject).uint64_from_uin.set(paramLong2);
    paramString = new oidb_sso.OIDBSSOPkg();
    paramString.uint32_command.set(3559);
    paramString.uint32_service_type.set(1);
    paramString.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0xde7.ReqBody)localObject).toByteArray()));
    localObject = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), SignatureServlet.class);
    ((NewIntent)localObject).putExtra("cmd", "OidbSvc.0xde7_1");
    ((NewIntent)localObject).putExtra("data", paramString.toByteArray());
    ((NewIntent)localObject).putExtra("timeout", 10000L);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
  }
  
  public void a(long paramLong1, String paramString1, long paramLong2, long paramLong3, String paramString2)
  {
    oidb_0xde5.ReqBody localReqBody = new oidb_0xde5.ReqBody();
    localReqBody.uint64_longnick_uin.set(paramLong1);
    localReqBody.str_longnick_id.set(paramString1);
    localReqBody.uint64_target_comment_id.set(paramLong2);
    localReqBody.uint64_from_uin.set(paramLong3);
    localReqBody.str_comment.set(paramString2);
    paramString1 = new oidb_sso.OIDBSSOPkg();
    paramString1.uint32_command.set(3557);
    paramString1.uint32_service_type.set(1);
    paramString1.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
    paramString2 = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), SignatureServlet.class);
    paramString2.putExtra("cmd", "OidbSvc.0xde5_1");
    paramString2.putExtra("data", paramString1.toByteArray());
    paramString2.putExtra("timeout", 10000L);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(paramString2);
  }
  
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    String str = paramIntent.getStringExtra("cmd");
    try
    {
      this.jdField_a_of_type_Int = 0;
      if ("Signature.act".equals(str))
      {
        b(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramArrayOfByte);
      int i = paramFromServiceMsg.uint32_result.get();
      int j = paramFromServiceMsg.uint32_command.get();
      if (j != 1938)
      {
        if (j != 1939)
        {
          if (j != 1941)
          {
            if (j != 1942)
            {
              if (j != 1944)
              {
                if (j != 1945)
                {
                  if (j != 3486)
                  {
                    if (j != 3494)
                    {
                      if (j != 3542)
                      {
                        if (j != 3557)
                        {
                          if (j != 3559)
                          {
                            if (j == 3560)
                            {
                              l(paramIntent, paramFromServiceMsg);
                            }
                            else
                            {
                              paramIntent = new StringBuilder();
                              paramIntent.append("Unknow oidb cmd");
                              paramIntent.append(j);
                              throw new Exception(paramIntent.toString());
                            }
                          }
                          else {
                            k(paramIntent, paramFromServiceMsg);
                          }
                        }
                        else {
                          j(paramIntent, paramFromServiceMsg);
                        }
                      }
                      else {
                        b(paramIntent, paramFromServiceMsg);
                      }
                    }
                    else {
                      a(paramIntent, paramFromServiceMsg);
                    }
                  }
                  else {
                    i(paramIntent, paramFromServiceMsg);
                  }
                }
                else {
                  h(paramIntent, paramFromServiceMsg);
                }
              }
              else {
                c(paramIntent, paramFromServiceMsg);
              }
            }
            else {
              e(paramIntent, paramFromServiceMsg);
            }
          }
          else {
            d(paramIntent, paramFromServiceMsg);
          }
        }
        else {
          g(paramIntent, paramFromServiceMsg);
        }
      }
      else {
        f(paramIntent, paramFromServiceMsg);
      }
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("oidb_0x792|OIDBSSOPkg.result ");
        paramIntent.append(i);
        QLog.d("SignatureHandler", 2, paramIntent.toString());
        return;
      }
    }
    catch (Exception paramIntent)
    {
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("sign handler onRecive fail err:");
        paramFromServiceMsg.append(paramIntent.getMessage());
        QLog.e("SignatureHandler", 2, paramFromServiceMsg.toString());
      }
    }
  }
  
  public void a(Intent paramIntent, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    if (paramOIDBSSOPkg.uint32_result.get() == 0)
    {
      localObject1 = new oidb_0xda6.RspBody();
      ((oidb_0xda6.RspBody)localObject1).mergeFrom(paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
      paramOIDBSSOPkg = new ArrayList();
      if (((oidb_0xda6.RspBody)localObject1).rpt_topic_item.get() != null) {
        paramOIDBSSOPkg = ((oidb_0xda6.RspBody)localObject1).rpt_topic_item.get();
      }
      localObject1 = new ArrayList();
      i = 0;
      while (i < paramOIDBSSOPkg.size())
      {
        localObject2 = new SignatureManager.TopicInfo();
        ((SignatureManager.TopicInfo)localObject2).topicId = ((oidb_0xda6.UserTopicItem)paramOIDBSSOPkg.get(i)).uint32_topic_id.get();
        ((SignatureManager.TopicInfo)localObject2).topicStr = ((oidb_0xda6.UserTopicItem)paramOIDBSSOPkg.get(i)).str_topic.get();
        ((SignatureManager.TopicInfo)localObject2).totalNum = ((oidb_0xda6.UserTopicItem)paramOIDBSSOPkg.get(i)).uint32_total_num.get();
        ((SignatureManager.TopicInfo)localObject2).friendNum = ((oidb_0xda6.UserTopicItem)paramOIDBSSOPkg.get(i)).uint32_frd_num.get();
        ((ArrayList)localObject1).add(localObject2);
        i += 1;
      }
      paramOIDBSSOPkg = new Bundle();
      paramOIDBSSOPkg.putSerializable("param_topicInfoList", (Serializable)localObject1);
      i = paramIntent.getIntExtra("param_atIndex", 0);
      j = paramIntent.getIntExtra("param_atKeyLen", 0);
      localObject1 = paramIntent.getStringExtra("param_atKey");
      l = paramIntent.getLongExtra("param_reqTs", 0L);
      paramOIDBSSOPkg.putInt("param_atIndex", i);
      paramOIDBSSOPkg.putInt("param_atKeyLen", j);
      paramOIDBSSOPkg.putString("param_atKey", (String)localObject1);
      paramOIDBSSOPkg.putLong("param_reqTs", l);
      notifyUI(9, true, paramOIDBSSOPkg);
      return;
    }
    Object localObject1 = new Bundle();
    int i = paramIntent.getIntExtra("param_atIndex", 0);
    int j = paramIntent.getIntExtra("param_atKeyLen", 0);
    Object localObject2 = paramIntent.getStringExtra("param_atKey");
    long l = paramIntent.getLongExtra("param_reqTs", 0L);
    ((Bundle)localObject1).putInt("param_atIndex", i);
    ((Bundle)localObject1).putInt("param_atKeyLen", j);
    ((Bundle)localObject1).putString("param_atKey", (String)localObject2);
    ((Bundle)localObject1).putLong("param_reqTs", l);
    ((Bundle)localObject1).putInt("param_searchResult", paramOIDBSSOPkg.uint32_result.get());
    notifyUI(9, false, localObject1);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SignatureHandler", 2, String.format("getTopicListWithKey key=[%s] [atIndex=%d, keyLen=%d] reqTs=%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong) }));
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = new oidb_0xda6.ReqBody();
    ((oidb_0xda6.ReqBody)localObject).keyword.set(paramString);
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(3494);
    localOIDBSSOPkg.uint32_service_type.set(4);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0xda6.ReqBody)localObject).toByteArray()));
    localObject = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), SignatureServlet.class);
    ((NewIntent)localObject).putExtra("cmd", "OidbSvc.0xda6_4");
    ((NewIntent)localObject).putExtra("data", localOIDBSSOPkg.toByteArray());
    ((NewIntent)localObject).putExtra("timeout", 10000L);
    ((NewIntent)localObject).putExtra("param_atIndex", paramInt1);
    ((NewIntent)localObject).putExtra("param_atKeyLen", paramInt2);
    ((NewIntent)localObject).putExtra("param_atKey", paramString);
    ((NewIntent)localObject).putExtra("param_reqTs", paramLong);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("sigCommentUpdateTimeStamp_");
      ((StringBuilder)localObject2).append(paramString1);
      long l = ((SharedPreferences)localObject1).getLong(((StringBuilder)localObject2).toString(), 0L);
      if (System.currentTimeMillis() < l)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SignatureHandler", 2, "getSigZanInfo freq limit");
        }
        return;
      }
      localObject2 = new oidb_0x798.ReqBody();
      ((oidb_0x798.ReqBody)localObject2).feedsid.set(ByteStringMicro.copyFrom(paramString2.getBytes()));
      ((oidb_0x798.ReqBody)localObject2).uint64_time.set(l);
      ((oidb_0x798.ReqBody)localObject2).uint64_uin.set(Long.parseLong(paramString1));
      ((oidb_0x798.ReqBody)localObject2).uint32_type.set(Arrays.asList(new Integer[] { Integer.valueOf(255) }));
      localObject1 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1944);
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x798.ReqBody)localObject2).toByteArray()));
      localObject2 = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), SignatureServlet.class);
      ((NewIntent)localObject2).putExtra("uin", paramString1);
      ((NewIntent)localObject2).putExtra("feedsid", paramString2);
      ((NewIntent)localObject2).putExtra("cmd", "OidbSvc.0x798_0");
      ((NewIntent)localObject2).putExtra("data", ((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
      ((NewIntent)localObject2).putExtra("timeout", 10000L);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject2);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SignatureHandler", 2, String.format("InteractiveSignature[%s %s %d %d]", new Object[] { StringUtil.e(paramString1), paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      if (TextUtils.isEmpty(paramString1)) {
        return;
      }
      Object localObject1 = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(paramString1);
      if (localObject1 == null) {
        return;
      }
      Object localObject2 = ExtensionRichStatus.a((ExtensionInfo)localObject1);
      localObject1 = new oidb_0x795.ReqBody();
      ((oidb_0x795.ReqBody)localObject1).feedsid.set(ByteStringMicro.copyFrom(paramString2.getBytes()));
      ((oidb_0x795.ReqBody)localObject1).uint64_time.set(((RichStatus)localObject2).time);
      ((oidb_0x795.ReqBody)localObject1).uint64_uin.set(Long.valueOf(paramString1).longValue());
      ((oidb_0x795.ReqBody)localObject1).uint32_type.set(paramInt1);
      ((oidb_0x795.ReqBody)localObject1).uint32_action.set(paramInt2);
      localObject2 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(1941);
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x795.ReqBody)localObject1).toByteArray()));
      localObject1 = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), SignatureServlet.class);
      ((NewIntent)localObject1).putExtra("uin", paramString1);
      ((NewIntent)localObject1).putExtra("feedid", paramString2);
      ((NewIntent)localObject1).putExtra("type", paramInt1);
      ((NewIntent)localObject1).putExtra("action", paramInt2);
      ((NewIntent)localObject1).putExtra("cmd", "OidbSvc.0x795_0");
      ((NewIntent)localObject1).putExtra("data", ((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
      ((NewIntent)localObject1).putExtra("timeout", 10000L);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject1);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      Object localObject1 = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(paramString1);
      if (localObject1 == null) {
        return;
      }
      localObject1 = ExtensionRichStatus.a((ExtensionInfo)localObject1);
      oidb_0x796.ReqBody localReqBody = new oidb_0x796.ReqBody();
      localReqBody.feedsid.set(ByteStringMicro.copyFrom(paramString2.getBytes()));
      localReqBody.uint64_time.set(((RichStatus)localObject1).time);
      localReqBody.uint64_uin.set(Long.valueOf(paramString1).longValue());
      localReqBody.uint32_type.set(paramInt);
      if (!paramBoolean)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("sigCommentDetailUin_");
        ((StringBuilder)localObject1).append(paramString2);
        localObject1 = Long.valueOf(((SharedPreferences)localObject2).getLong(((StringBuilder)localObject1).toString(), 0L));
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("sigCommentDetailTime_");
        ((StringBuilder)localObject3).append(paramString2);
        localObject2 = Long.valueOf(((SharedPreferences)localObject2).getLong(((StringBuilder)localObject3).toString(), 0L));
      }
      else
      {
        localObject1 = Long.valueOf(0L);
        localObject2 = Long.valueOf(0L);
      }
      Object localObject3 = new oidb_0x796.ItemInfo();
      ((oidb_0x796.ItemInfo)localObject3).uint64_time.set(((Long)localObject2).longValue());
      ((oidb_0x796.ItemInfo)localObject3).uint64_uin.set(((Long)localObject1).longValue());
      localReqBody.stLastInfo.set((MessageMicro)localObject3);
      localReqBody.uint32_seq.set(0);
      localObject1 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1942);
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
      Object localObject2 = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), SignatureServlet.class);
      ((NewIntent)localObject2).putExtra("uin", paramString1);
      ((NewIntent)localObject2).putExtra("feedid", paramString2);
      ((NewIntent)localObject2).putExtra("firstFlag", paramBoolean);
      ((NewIntent)localObject2).putExtra("cmd", "OidbSvc.0x796_0");
      ((NewIntent)localObject2).putExtra("data", ((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
      ((NewIntent)localObject2).putExtra("timeout", 10000L);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject2);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject2 = Long.valueOf(0L);
    Object localObject3 = "0";
    if (!paramBoolean)
    {
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
      localObject2 = Long.valueOf(((SharedPreferences)localObject3).getLong("sigNewCommentLastUin_", 0L));
      localObject1 = Long.valueOf(((SharedPreferences)localObject3).getLong("sigNewCommentLastFetchTime", 0L));
      localObject3 = ((SharedPreferences)localObject3).getString("sigNewCommentLastFeedsId_", "0");
    }
    else
    {
      localObject1 = localObject2;
    }
    oidb_0x793.ReqBody localReqBody = new oidb_0x793.ReqBody();
    localReqBody.feedsid.set(ByteStringMicro.copyFrom(((String)localObject3).getBytes()));
    localReqBody.uint64_uin.set(((Long)localObject2).longValue());
    localReqBody.uint64_time.set(((Long)localObject1).longValue());
    localReqBody.uint32_getnum.set(100);
    Object localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1939);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
    localObject2 = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), SignatureServlet.class);
    ((NewIntent)localObject2).putExtra("feedsId", "OidbSvc.0x793_0");
    ((NewIntent)localObject2).putExtra("cmd", "OidbSvc.0x793_0");
    ((NewIntent)localObject2).putExtra("data", ((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
    ((NewIntent)localObject2).putExtra("timeout", 10000L);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject2);
  }
  
  public List<LikeItem> b(List<oidb_0xde8.lightCommentItem> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        oidb_0xde8.lightCommentItem locallightCommentItem = (oidb_0xde8.lightCommentItem)paramList.next();
        LikeItem localLikeItem = new LikeItem();
        localLikeItem.jdField_a_of_type_Long = locallightCommentItem.uint64_time.get();
        long l = locallightCommentItem.uint64_uin.get();
        localLikeItem.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanUser = new User(String.valueOf(l), a(l));
        localArrayList.add(localLikeItem);
      }
      return localArrayList;
    }
    return new ArrayList();
  }
  
  public void b()
  {
    Object localObject = new oidb_0xd9e.ReqBody();
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(3486);
    localOIDBSSOPkg.uint32_service_type.set(3);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0xd9e.ReqBody)localObject).toByteArray()));
    localObject = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), SignatureServlet.class);
    ((NewIntent)localObject).putExtra("cmd", "OidbSvc.0xd9e_3");
    ((NewIntent)localObject).putExtra("data", localOIDBSSOPkg.toByteArray());
    ((NewIntent)localObject).putExtra("timeout", 10000L);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
  }
  
  public void b(Intent paramIntent, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    if (paramOIDBSSOPkg.uint32_result.get() == 0)
    {
      paramIntent = new oidb_0xdd6.RspBody();
      paramIntent.mergeFrom(paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
      notifyUI(10, true, Integer.valueOf(paramIntent.uint32_num.get()));
      return;
    }
    notifyUI(10, false, Integer.valueOf(-1));
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    if (this.jdField_a_of_type_Int == 92) {
      return FriendListObserver.class;
    }
    return SignatureObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.SignatureHandler
 * JD-Core Version:    0.7.0.1
 */