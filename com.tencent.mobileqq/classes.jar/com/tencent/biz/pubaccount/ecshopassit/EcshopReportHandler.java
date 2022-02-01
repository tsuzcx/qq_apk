package com.tencent.biz.pubaccount.ecshopassit;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.ecshop.report.api.IEcshopReportApi;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQDeviceInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.oidb.qqshop.qqshop_report.SQQSHPCliLogInfo;
import tencent.im.oidb.qqshop.qqshop_report.SQQSHPCliLogReq;
import tencent.im.oidb.qqshop.qqshop_richmsg.SQQSHPFolderAdMsg;
import tencent.im.oidb.qqshop.qqshop_richmsg.SQQSHPRichMsg;
import tencent.im.oidb.qqshop.qqshop_richmsg.SQQSHPRichMsgReq;
import tencent.im.oidb.qqshop.qqshop_richmsg.SQQSHPRichMsgRsp;

public class EcshopReportHandler
  extends BusinessHandler
{
  static String jdField_a_of_type_JavaLangString;
  static final String b;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  public MessageObserver a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplication.getContext().getFilesDir());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("qqshp_client_log_wl_conf.json");
    b = localStringBuilder.toString();
  }
  
  public EcshopReportHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new EcshopReportHandler.1(this);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    if ((paramAppInterface instanceof QQAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramAppInterface);
    }
  }
  
  public void a()
  {
    Object localObject = new File(b);
    if ((((File)localObject).exists()) && (((File)localObject).isFile())) {
      localObject = FileUtils.readFileContent((File)localObject);
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject((String)localObject);
        JSONArray localJSONArray1 = ((JSONObject)localObject).optJSONArray("report_list");
        JSONArray localJSONArray2 = ((JSONObject)localObject).optJSONArray("gtk_list");
        ArrayList localArrayList = new ArrayList();
        EcShopAssistantManager.c = new ArrayList();
        bool = true;
        if (((JSONObject)localObject).optInt("aio_auto_play", 1) != 1) {
          break label239;
        }
        EcShopAssistantManager.a = bool;
        int i;
        if ((localJSONArray1 != null) && (localJSONArray1.length() > 0))
        {
          i = 0;
          if (i < localJSONArray1.length())
          {
            localArrayList.add(String.valueOf(localJSONArray1.getLong(i)));
            i += 1;
            continue;
          }
        }
        EcShopAssistantManager.b = localArrayList;
        if ((localJSONArray2 != null) && (localJSONArray2.length() > 0))
        {
          i = 0;
          if (i < localJSONArray2.length())
          {
            EcShopAssistantManager.c.add(String.valueOf(localJSONArray2.getLong(i)));
            i += 1;
            continue;
          }
        }
        if (EcShopAssistantManager.b != null) {
          break label222;
        }
      }
      catch (Exception localException)
      {
        QLog.e("EcshopReportHandler", 2, localException, new Object[0]);
      }
      EcShopAssistantManager.b = new ArrayList();
      label222:
      if (EcShopAssistantManager.c == null) {
        EcShopAssistantManager.c = new ArrayList();
      }
      return;
      label239:
      boolean bool = false;
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2, long paramLong3, long paramLong4, boolean paramBoolean)
  {
    a(paramInt, paramString1, paramString2, paramString3, paramString4, null, paramLong1, paramLong2, paramLong3, paramLong4, paramBoolean);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, boolean paramBoolean)
  {
    a(paramInt, paramString1, paramString2, paramString3, paramString4, paramLong, 0L, 0L, 0L, paramBoolean);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong1, long paramLong2, long paramLong3, long paramLong4, boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("real time report:[");
    ((StringBuilder)localObject).append(Integer.toHexString(paramInt));
    ((StringBuilder)localObject).append(",");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(",");
    String str4 = paramString2;
    ((StringBuilder)localObject).append(str4);
    ((StringBuilder)localObject).append(",");
    String str3 = paramString3;
    ((StringBuilder)localObject).append(str3);
    ((StringBuilder)localObject).append(",");
    String str2 = paramString4;
    ((StringBuilder)localObject).append(str2);
    ((StringBuilder)localObject).append(",");
    String str1 = paramString5;
    ((StringBuilder)localObject).append(str1);
    ((StringBuilder)localObject).append(",");
    ((StringBuilder)localObject).append(paramLong1);
    ((StringBuilder)localObject).append(",");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append("]");
    QLog.i("EcshopReportHandler", 2, ((StringBuilder)localObject).toString());
    int i;
    long l;
    try
    {
      i = NetworkUtil.getSystemNetwork(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext());
      l = Long.parseLong(paramString1);
    }
    catch (Exception paramString1)
    {
      QLog.e("EcshopReportHandler", 2, "doReport error:", paramString1);
      l = 0L;
      i = 0;
    }
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (paramString1 == null) {
      paramString1 = "";
    } else {
      paramString1 = paramString1.getCurrentAccountUin();
    }
    localObject = new qqshop_report.SQQSHPCliLogReq();
    qqshop_report.SQQSHPCliLogInfo localSQQSHPCliLogInfo = new qqshop_report.SQQSHPCliLogInfo();
    localSQQSHPCliLogInfo.puin.set(l);
    localSQQSHPCliLogInfo.network.set(i);
    localSQQSHPCliLogInfo.cnt.set(1);
    PBStringField localPBStringField = localSQQSHPCliLogInfo.strp1;
    if (TextUtils.isEmpty(paramString2)) {
      str4 = "";
    }
    localPBStringField.set(str4);
    paramString2 = localSQQSHPCliLogInfo.strp2;
    if (TextUtils.isEmpty(paramString3)) {
      str3 = "";
    }
    paramString2.set(str3);
    paramString2 = localSQQSHPCliLogInfo.strp3;
    if (TextUtils.isEmpty(paramString4)) {
      str2 = "";
    }
    paramString2.set(str2);
    paramString2 = localSQQSHPCliLogInfo.strp4;
    if (TextUtils.isEmpty(paramString5)) {
      str1 = "";
    }
    paramString2.set(str1);
    localSQQSHPCliLogInfo.tvalue.set(paramInt);
    localSQQSHPCliLogInfo.uintp1.set(paramLong1);
    localSQQSHPCliLogInfo.uintp2.set(paramLong2);
    localSQQSHPCliLogInfo.uintp3.set(paramLong3);
    localSQQSHPCliLogInfo.uintp4.set(paramLong4);
    if (paramBoolean)
    {
      if (jdField_a_of_type_JavaLangString == null) {
        jdField_a_of_type_JavaLangString = QQDeviceInfo.getMAC("5076bf");
      }
      if (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
        localSQQSHPCliLogInfo.wifimac.set(jdField_a_of_type_JavaLangString);
      }
    }
    ((qqshop_report.SQQSHPCliLogReq)localObject).logs.add(localSQQSHPCliLogInfo);
    paramString1 = new ToServiceMsg("mobileqq.service", paramString1, "SQQShopCliLog.RtReport");
    paramString1.putWupBuffer(((qqshop_report.SQQSHPCliLogReq)localObject).toByteArray());
    super.sendPbReq(paramString1);
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord != null)
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (localObject1 == null) {
        return;
      }
      EcShopAssistantManager localEcShopAssistantManager = (EcShopAssistantManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
      localObject1 = new qqshop_richmsg.SQQSHPRichMsgReq();
      ArrayList localArrayList = new ArrayList();
      String str = paramMessageRecord.getExtInfoFromExtStr("public_account_msg_id");
      Object localObject2 = new qqshop_richmsg.SQQSHPRichMsg();
      ((qqshop_richmsg.SQQSHPRichMsg)localObject2).msg_id.set(Long.parseLong(str));
      ((qqshop_richmsg.SQQSHPRichMsg)localObject2).puin.set(Long.parseLong(paramMessageRecord.senderuin));
      ((qqshop_richmsg.SQQSHPRichMsg)localObject2).sendtime.set(paramMessageRecord.time);
      localArrayList.add(localObject2);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("get rich msg:");
      ((StringBuilder)localObject2).append(str);
      ((StringBuilder)localObject2).append(",");
      ((StringBuilder)localObject2).append(paramMessageRecord.senderuin);
      ((StringBuilder)localObject2).append(",");
      ((StringBuilder)localObject2).append(paramMessageRecord.time);
      QLog.i("EcshopReportHandler", 2, ((StringBuilder)localObject2).toString());
      localObject2 = localEcShopAssistantManager.a(paramMessageRecord.senderuin);
      ((EcShopData)localObject2).mLastMsgTime = paramMessageRecord.time;
      paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getLastMessage(((EcShopData)localObject2).mUin, 1008);
      if (paramMessageRecord != null)
      {
        long l = paramMessageRecord.time;
        if (l > ((EcShopData)localObject2).mLastMsgTime) {
          ((EcShopData)localObject2).mLastMsgTime = l;
        }
      }
      ((EcShopData)localObject2).msgId = str;
      ((EcShopData)localObject2).mImgInfo = "";
      localEcShopAssistantManager.a((EcShopData)localObject2);
      if (localArrayList.isEmpty()) {
        return;
      }
      ((qqshop_richmsg.SQQSHPRichMsgReq)localObject1).rich_msgs.addAll(localArrayList);
      paramMessageRecord = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "SQQShopMsgSvc.GetRichMsgInfo");
      paramMessageRecord.putWupBuffer(((qqshop_richmsg.SQQSHPRichMsgReq)localObject1).toByteArray());
      super.sendPbReq(paramMessageRecord);
    }
  }
  
  public void a(boolean paramBoolean, MessageRecord paramMessageRecord, int paramInt, String paramString)
  {
    try
    {
      String str = paramMessageRecord.getExtInfoFromExtStr("public_account_msg_id");
      if ("1".equals(paramMessageRecord.getExtInfoFromExtStr("is_AdArrive_Msg")))
      {
        ((IEcshopReportApi)QRoute.api(IEcshopReportApi.class)).doClickReport(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord, paramInt);
        return;
      }
      if (paramBoolean)
      {
        a(134243864, paramMessageRecord.senderuin, str, paramString, null, paramInt, false);
        return;
      }
      a(134243858, paramMessageRecord.senderuin, str, paramString, null, paramInt, false);
      return;
    }
    catch (Throwable paramMessageRecord) {}
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doArrivalReport ");
    ((StringBuilder)localObject).append(paramMessageRecord);
    QLog.d("EcshopReportHandler", 1, ((StringBuilder)localObject).toString());
    try
    {
      localObject = paramMessageRecord.getExtInfoFromExtStr("public_account_msg_id");
      String str = paramMessageRecord.getExtInfoFromExtStr("is_AdArrive_Msg");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doArrivalReport hasAdver: ");
      localStringBuilder.append(str);
      QLog.i("EcshopReportHandler", 1, localStringBuilder.toString());
      if ("1".equals(str))
      {
        ((IEcshopReportApi)QRoute.api(IEcshopReportApi.class)).doArrivalReport(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord);
        return;
      }
      if ((paramMessageRecord instanceof MessageForArkApp))
      {
        ((IEcshopReportApi)QRoute.api(IEcshopReportApi.class)).doArrivalArkReport(paramMessageRecord);
        a(134243862, paramMessageRecord.senderuin, (String)localObject, null, null, 0L, false);
        return;
      }
      a(134243856, paramMessageRecord.senderuin, (String)localObject, null, null, 0L, false);
      return;
    }
    catch (Throwable paramMessageRecord)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doArrivalReport occur an error: ");
      ((StringBuilder)localObject).append(paramMessageRecord);
      QLog.e("EcshopReportHandler", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return EcShopObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramFromServiceMsg = new StringBuilder();
    paramFromServiceMsg.append("on receive:");
    paramFromServiceMsg.append(paramToServiceMsg.getServiceCmd());
    QLog.i("EcshopReportHandler", 2, paramFromServiceMsg.toString());
    if (("SQQShopMsgSvc.GetRichMsgInfo".equals(paramToServiceMsg.getServiceCmd())) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      if (paramObject == null) {
        return;
      }
      paramFromServiceMsg = new qqshop_richmsg.SQQSHPRichMsgRsp();
      paramToServiceMsg = (EcShopAssistantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
      Object localObject1 = paramToServiceMsg.a();
      Object localObject2;
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
      }
      catch (Exception paramObject)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("merge exception:");
        ((StringBuilder)localObject2).append(paramObject);
        QLog.e("EcshopReportHandler", 2, ((StringBuilder)localObject2).toString());
      }
      paramObject = paramFromServiceMsg.rich_msgs.get();
      int j = paramObject.size();
      int i = 0;
      Object localObject3;
      while (i < j)
      {
        Object localObject4 = (qqshop_richmsg.SQQSHPRichMsg)paramObject.get(i);
        if ((((qqshop_richmsg.SQQSHPRichMsg)localObject4).img_url.has()) && (((qqshop_richmsg.SQQSHPRichMsg)localObject4).msg_id.has()) && (((qqshop_richmsg.SQQSHPRichMsg)localObject4).puin.has()))
        {
          localObject2 = String.valueOf(((qqshop_richmsg.SQQSHPRichMsg)localObject4).msg_id.get());
          localObject3 = String.valueOf(((qqshop_richmsg.SQQSHPRichMsg)localObject4).puin.get());
          Object localObject5 = ((qqshop_richmsg.SQQSHPRichMsg)localObject4).img_url.get();
          localObject4 = new StringBuilder();
          Object localObject6 = ((List)localObject5).iterator();
          while (((Iterator)localObject6).hasNext())
          {
            ((StringBuilder)localObject4).append((String)((Iterator)localObject6).next());
            ((StringBuilder)localObject4).append(",");
          }
          localObject6 = new StringBuilder();
          ((StringBuilder)localObject6).append("recv rich msg:");
          ((StringBuilder)localObject6).append((String)localObject2);
          ((StringBuilder)localObject6).append(",");
          ((StringBuilder)localObject6).append((String)localObject3);
          ((StringBuilder)localObject6).append(",");
          ((StringBuilder)localObject6).append(localObject5.toString());
          QLog.i("EcshopReportHandler", 2, ((StringBuilder)localObject6).toString());
          localObject5 = ((List)localObject1).iterator();
          while (((Iterator)localObject5).hasNext())
          {
            localObject6 = (EcShopData)((Iterator)localObject5).next();
            if ((((String)localObject2).equals(((EcShopData)localObject6).msgId)) && (((String)localObject3).equals(((EcShopData)localObject6).mUin)))
            {
              ((EcShopData)localObject6).mImgInfo = ((StringBuilder)localObject4).substring(0, ((StringBuilder)localObject4).length() - 1).toString();
              paramToServiceMsg.a((EcShopData)localObject6);
            }
          }
        }
        i += 1;
      }
      if (j > 0) {
        super.notifyUI(6, true, null);
      }
      if (paramFromServiceMsg.ad_msgs.has())
      {
        paramFromServiceMsg = (qqshop_richmsg.SQQSHPFolderAdMsg)paramFromServiceMsg.ad_msgs.get(0);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        if (paramFromServiceMsg == null) {
          return;
        }
        paramObject = paramFromServiceMsg.pic_url.get();
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (paramObject != null))
        {
          if (paramObject.isEmpty()) {
            return;
          }
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("ecshop_sp");
          ((StringBuilder)localObject3).append((String)localObject1);
          localObject1 = ((BaseApplication)localObject2).getSharedPreferences(((StringBuilder)localObject3).toString(), 0);
          long l = ((SharedPreferences)localObject1).getLong("ad_puin", 0L);
          EcShopAssistantManager.g = String.valueOf(l);
          localObject1 = ((SharedPreferences)localObject1).edit();
          if (l != 0L) {
            paramToServiceMsg.b(String.valueOf(l));
          }
          ((SharedPreferences.Editor)localObject1).putBoolean("is_ad_added", false);
          ((SharedPreferences.Editor)localObject1).putInt("ad_start", paramFromServiceMsg.begin_time.get());
          ((SharedPreferences.Editor)localObject1).putInt("ad_end", paramFromServiceMsg.end_time.get());
          ((SharedPreferences.Editor)localObject1).putLong("ad_id", paramFromServiceMsg.ad_id.get());
          ((SharedPreferences.Editor)localObject1).putLong("ad_puin", paramFromServiceMsg.puin.get());
          ((SharedPreferences.Editor)localObject1).putString("ad_icon_url", paramFromServiceMsg.ad_url.get());
          ((SharedPreferences.Editor)localObject1).putString("ad_title", paramFromServiceMsg.title.get());
          ((SharedPreferences.Editor)localObject1).putString("ad_nick", paramFromServiceMsg.name.get());
          ((SharedPreferences.Editor)localObject1).putString("ad_url", paramFromServiceMsg.ad_content_url.get());
          boolean bool;
          if (paramFromServiceMsg.verify_flag.get() == 1) {
            bool = true;
          } else {
            bool = false;
          }
          ((SharedPreferences.Editor)localObject1).putBoolean("ad_cert", bool);
          paramToServiceMsg = new StringBuilder();
          paramObject = paramObject.iterator();
          while (paramObject.hasNext())
          {
            paramToServiceMsg.append((String)paramObject.next());
            paramToServiceMsg.append(",");
          }
          paramToServiceMsg = paramToServiceMsg.substring(0, paramToServiceMsg.length() - 1).toString();
          paramObject = new StringBuilder();
          paramObject.append("v_flag");
          paramObject.append(paramFromServiceMsg.verify_flag.get());
          paramObject.append(",puin:");
          paramObject.append(paramFromServiceMsg.puin.get());
          paramObject.append(",ad pics:");
          paramObject.append(paramToServiceMsg);
          QLog.i("EcshopReportHandler", 2, paramObject.toString());
          ((SharedPreferences.Editor)localObject1).putString("ad_pics", paramToServiceMsg);
          ((SharedPreferences.Editor)localObject1).commit();
          a(134246435, null, null, null, null, paramFromServiceMsg.ad_id.get(), false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.EcshopReportHandler
 * JD-Core Version:    0.7.0.1
 */