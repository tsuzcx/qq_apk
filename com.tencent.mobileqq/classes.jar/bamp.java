import android.graphics.BitmapFactory.Options;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferHostInfo;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.config.ConfigManager;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.UploadPicExtInfo;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadReq;
import tencent.im.cs.cmd0x346.cmd0x346.ExtensionReq;
import tencent.im.cs.cmd0x346.cmd0x346.ReqBody;
import tencent.im.cs.cmd0x388.cmd0x388.ExpRoamExtendInfo;

public class bamp
  extends banb
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = (QQAppInterface)this.a;
  private Bdh_extinfo.UploadPicExtInfo jdField_a_of_type_ComTencentMobileqqHighwayProtocolBdh_extinfo$UploadPicExtInfo = new Bdh_extinfo.UploadPicExtInfo();
  Transaction jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction = null;
  private String jdField_a_of_type_JavaLangString;
  private cmd0x388.ExpRoamExtendInfo jdField_a_of_type_TencentImCsCmd0x388Cmd0x388$ExpRoamExtendInfo = new cmd0x388.ExpRoamExtendInfo();
  private String b;
  private byte[] d;
  
  public bamp(batw parambatw, baub parambaub)
  {
    super(parambatw, parambaub);
    this.jdField_a_of_type_Int = parambaub.jdField_c_of_type_Int;
    this.jdField_a_of_type_Baoj.jdField_c_of_type_Int = parambaub.jdField_c_of_type_Int;
    this.jdField_b_of_type_JavaLangString = parambaub.jdField_a_of_type_JavaLangString;
    this.jdField_d_of_type_ArrayOfByte = parambaub.jdField_a_of_type_ArrayOfByte;
  }
  
  public static List<ExcitingTransferHostInfo> a(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (BaseApplicationImpl.sProcessId == 1)
    {
      Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      Object localObject2 = ConfigManager.getInstance(BaseApplication.getContext(), ((QQAppInterface)localObject1).getHwEngine());
      if (localObject2 != null)
      {
        localObject2 = ((ConfigManager)localObject2).getOtherTypeIp(((QQAppInterface)localObject1).getApp().getBaseContext(), 21, paramBoolean);
        if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
          localObject1 = ((List)localObject2).iterator();
        }
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (EndPoint)((Iterator)localObject1).next();
          if ((localObject2 != null) && (!TextUtils.isEmpty(((EndPoint)localObject2).host)))
          {
            localArrayList.add(new ExcitingTransferHostInfo(((EndPoint)localObject2).host, ((EndPoint)localObject2).port, true));
            continue;
            HwServlet.getConfig((AppRuntime)localObject1, ((QQAppInterface)localObject1).c());
          }
        }
      }
    }
    return localArrayList;
  }
  
  public static byte[] b()
  {
    return SessionInfo.getInstance(BaseApplicationImpl.getApplication().getRuntime().getAccount()).getSessionKey();
  }
  
  public static byte[] c()
  {
    return SessionInfo.getInstance(BaseApplicationImpl.getApplication().getRuntime().getAccount()).getHttpconn_sig_session();
  }
  
  private final void f()
  {
    this.jdField_a_of_type_Bamy.a();
    bawo localbawo = a();
    if (!e())
    {
      a(9366, "illegal app", null, this.jdField_a_of_type_Bamy);
      d();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        b("requestStart", localbawo.toString());
      }
    } while ((!f()) || (localbawo == null));
    this.jdField_a_of_type_Bawo = localbawo;
    QLog.i("BDHCommonUploadProcessor", 1, "BDHCommonUploadProcessor commonId: " + this.jdField_a_of_type_Int);
    baxu.a(localbawo);
  }
  
  public final int a()
  {
    super.a();
    if (this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().cancelTransactionTask(this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction);
    }
    return 0;
  }
  
  protected final long a(long paramLong)
  {
    paramLong = this.jdField_q_of_type_Long - paramLong;
    if (!this.jdField_d_of_type_Boolean) {}
    for (paramLong = Math.min(paramLong, this.jdField_a_of_type_Bica.a(BaseApplication.getContext(), this.jdField_q_of_type_Long, this.s, -1));; paramLong = Math.min(paramLong, 14600L)) {
      return Math.min(paramLong, 131072L);
    }
  }
  
  protected bawo a()
  {
    bawo localbawo = new bawo();
    bawx localbawx = new bawx();
    localbawx.jdField_a_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    localbawx.jdField_a_of_type_Long = this.jdField_q_of_type_Long;
    localbawx.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    localbawx.jdField_c_of_type_Int = this.p;
    localbawx.jdField_d_of_type_Int = this.jdField_q_of_type_Int;
    localbawx.b = this.jdField_l_of_type_Boolean;
    localbawx.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localbawx.jdField_a_of_type_Boolean = this.jdField_a_of_type_Baub.jdField_k_of_type_Boolean;
    localbawx.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Baub.jdField_c_of_type_JavaLangString;
    localbawo.jdField_a_of_type_Baxv = this;
    localbawo.jdField_a_of_type_JavaLangString = "bdh_common_up";
    localbawo.jdField_a_of_type_JavaUtilList.add(localbawx);
    localbawo.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
    localbawo.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localbawo.jdField_a_of_type_ArrayOfByte = this.jdField_d_of_type_ArrayOfByte;
    return localbawo;
  }
  
  protected final void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    if (paramLong1 != 0L) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.countFlow(true, 1, this.jdField_a_of_type_Baub.jdField_b_of_type_Int, this.jdField_a_of_type_Baub.jdField_a_of_type_Int, paramLong1);
    }
    if (paramLong2 != 0L) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.countFlow(true, 1, this.jdField_a_of_type_Baub.jdField_b_of_type_Int, this.jdField_a_of_type_Baub.jdField_a_of_type_Int, paramLong2);
    }
    if (paramLong3 != 0L) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.countFlow(true, 0, this.jdField_a_of_type_Baub.jdField_b_of_type_Int, this.jdField_a_of_type_Baub.jdField_a_of_type_Int, paramLong3);
    }
    if (paramLong4 != 0L) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.countFlow(true, 0, this.jdField_a_of_type_Baub.jdField_b_of_type_Int, this.jdField_a_of_type_Baub.jdField_a_of_type_Int, paramLong4);
    }
  }
  
  public final void a(bawo parambawo, baxd parambaxd)
  {
    if (parambaxd != null)
    {
      int i = 0;
      if (i < parambaxd.jdField_a_of_type_JavaUtilList.size())
      {
        parambawo = (baxe)parambaxd.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          b("procUrl", parambawo.toString());
        }
        a(this.jdField_a_of_type_Bamy, parambawo);
        if (QLog.isColorLevel()) {
          QLog.d("BDHCommonUploadProcessor", 2, "onBusiProtoResp()------response.result = " + parambawo.jdField_c_of_type_Int);
        }
        if (parambawo.jdField_c_of_type_Int == 0)
        {
          this.jdField_a_of_type_JavaLangString = parambawo.jdField_a_of_type_JavaLangString;
          this.s = this.jdField_q_of_type_Long;
          if (QLog.isColorLevel()) {
            QLog.d("BDHCommonUploadProcessor", 2, "onBusiProtoResp()---- sessionKey: " + this.jdField_a_of_type_JavaLangString);
          }
          this.jdField_a_of_type_Baoj.jdField_l_of_type_JavaLangString = parambawo.jdField_b_of_type_JavaLangString;
          this.jdField_a_of_type_Baoj.jdField_m_of_type_JavaLangString = parambawo.e;
          this.jdField_a_of_type_Baoj.n = parambawo.jdField_c_of_type_JavaLangString;
          this.jdField_a_of_type_Baoj.o = parambawo.jdField_d_of_type_JavaLangString;
          this.jdField_a_of_type_Baoj.i = ("http://" + parambawo.jdField_b_of_type_JavaLangString + parambawo.e);
          this.jdField_a_of_type_Baoj.jdField_j_of_type_JavaLangString = ("http://" + parambawo.jdField_b_of_type_JavaLangString + parambawo.jdField_c_of_type_JavaLangString);
          this.jdField_a_of_type_Baoj.k = ("http://" + parambawo.jdField_b_of_type_JavaLangString + parambawo.jdField_d_of_type_JavaLangString);
          this.jdField_a_of_type_Baoj.g = parambawo.f;
          if (parambawo.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_Baoj.a();
            e();
            if (QLog.isColorLevel()) {
              QLog.d("BDHCommonUploadProcessor", 2, "onBusiProtoResp()---- file is Exsit! " + this.jdField_a_of_type_Baub.i);
            }
            label374:
            this.jdField_a_of_type_Long = parambawo.jdField_a_of_type_Long;
            this.jdField_a_of_type_Baoj.d = this.jdField_a_of_type_Long;
            if (QLog.isColorLevel()) {
              QLog.d("BDHCommonUploadProcessor", 2, "mFileID->" + this.jdField_a_of_type_Long + " groupUin->" + this.jdField_a_of_type_Baub.jdField_c_of_type_JavaLangString);
            }
          }
        }
        for (;;)
        {
          i += 1;
          break;
          if ((this.jdField_a_of_type_Int == 9) && (parambawo.f != null)) {
            this.jdField_a_of_type_TencentImCsCmd0x388Cmd0x388$ExpRoamExtendInfo.bytes_resid.set(ByteStringMicro.copyFrom(parambawo.f.getBytes()));
          }
          if ((this.jdField_a_of_type_Int == 20) && (parambawo.f != null)) {
            this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolBdh_extinfo$UploadPicExtInfo.bytes_file_resid.set(ByteStringMicro.copyFrom(parambawo.f.getBytes()));
          }
          this.jdField_m_of_type_JavaLangString = parambawo.jdField_a_of_type_JavaLangString;
          this.s = parambawo.jdField_b_of_type_Int;
          this.r = parambawo.jdField_b_of_type_Long;
          aQ_();
          break label374;
          d();
        }
      }
    }
  }
  
  protected final void a(HashMap<String, String> paramHashMap)
  {
    long l2 = 0L;
    long l3 = 0L;
    long l4 = 0L;
    long l5 = 0L;
    try
    {
      l1 = Long.valueOf((String)paramHashMap.get("upFlow_WiFi")).longValue();
    }
    catch (Exception localException3)
    {
      try
      {
        l2 = Long.valueOf((String)paramHashMap.get("dwFlow_WiFi")).longValue();
      }
      catch (Exception localException3)
      {
        try
        {
          l3 = Long.valueOf((String)paramHashMap.get("upFlow_Xg")).longValue();
        }
        catch (Exception localException3)
        {
          try
          {
            for (;;)
            {
              l4 = Long.valueOf((String)paramHashMap.get("dwFlow_Xg")).longValue();
              String str1 = (String)paramHashMap.get("tc_p:");
              String str2 = (String)paramHashMap.get("rep_bdhTrans");
              String str3 = (String)paramHashMap.get("segspercnt");
              String str4 = (String)paramHashMap.get("param_conf_segSize");
              String str5 = (String)paramHashMap.get("param_conf_segNum");
              String str6 = (String)paramHashMap.get("param_conf_connNum");
              paramHashMap = (String)paramHashMap.get("param_fin_lost");
              if (str1 != null) {
                this.jdField_a_of_type_JavaUtilHashMap.put("X-piccachetime", str1);
              }
              if (paramHashMap != null) {
                this.jdField_a_of_type_JavaUtilHashMap.put("param_fin_lost", paramHashMap);
              }
              this.jdField_a_of_type_JavaUtilHashMap.put("param_BdhTrans", str2);
              this.jdField_a_of_type_JavaUtilHashMap.put("param_segspercnt", str3);
              this.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segSize", str4);
              this.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segNum", str5);
              this.jdField_a_of_type_JavaUtilHashMap.put("param_conf_connNum", str6);
              a(l1, l2, l3, l4);
              return;
              localException1 = localException1;
              long l1 = l2;
              if (QLog.isColorLevel())
              {
                QLog.w("BDHCommonUploadProcessor", 2, "upFlow_Wifi : number format exception !");
                l1 = l2;
                continue;
                localException2 = localException2;
                l2 = l3;
                if (QLog.isColorLevel())
                {
                  QLog.w("BDHCommonUploadProcessor", 2, "dwFlow_Wifi : number format exception !");
                  l2 = l3;
                  continue;
                  localException3 = localException3;
                  l3 = l4;
                  if (QLog.isColorLevel())
                  {
                    QLog.w("BDHCommonUploadProcessor", 2, "upFlow_Xg : number format exception !");
                    l3 = l4;
                  }
                }
              }
            }
          }
          catch (Exception localException4)
          {
            for (;;)
            {
              l4 = l5;
              if (QLog.isColorLevel())
              {
                QLog.w("BDHCommonUploadProcessor", 2, "dwFlow_Xg : number format exception !");
                l4 = l5;
              }
            }
          }
        }
      }
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if ((!paramBoolean) && (basb.b(this.jdField_j_of_type_Int))) {}
    while ((this.h) || ((paramBoolean) && ((this.jdField_m_of_type_Int & 0x2) > 0)) || ((!paramBoolean) && ((this.jdField_m_of_type_Int & 0x1) > 0))) {
      return;
    }
    int j = this.jdField_m_of_type_Int;
    int i;
    long l;
    String str;
    if (paramBoolean)
    {
      i = 2;
      this.jdField_m_of_type_Int = (i | j);
      this.jdField_l_of_type_Long = System.currentTimeMillis();
      l = (System.nanoTime() - this.jdField_k_of_type_Long) / 1000000L;
      HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
      if (this.jdField_a_of_type_JavaLangString != null) {
        break label158;
      }
      str = "null";
      label105:
      localHashMap.put("param_sessionKey", str);
      if (!paramBoolean) {
        break label167;
      }
      azmz.a(BaseApplication.getContext()).a(null, this.jdField_b_of_type_JavaLangString, true, l, this.jdField_q_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
    for (;;)
    {
      l();
      return;
      i = 1;
      break;
      label158:
      str = this.jdField_a_of_type_JavaLangString;
      break label105;
      label167:
      if (this.jdField_j_of_type_Int != -9527) {
        this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.jdField_j_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.jdField_j_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_picSize", String.valueOf(this.jdField_q_of_type_Long));
      azmz.a(BaseApplication.getContext()).a(null, this.jdField_b_of_type_JavaLangString, false, l, this.jdField_q_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
  }
  
  byte[] a()
  {
    cmd0x346.ReqBody localReqBody = new cmd0x346.ReqBody();
    localReqBody.uint32_cmd.set(500);
    localReqBody.uint32_business_id.set(3);
    localReqBody.uint32_client_type.set(104);
    cmd0x346.ApplyUploadReq localApplyUploadReq = new cmd0x346.ApplyUploadReq();
    localApplyUploadReq.uint64_sender_uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()));
    try
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
      localObject = str;
      if (str.startsWith("+")) {
        localObject = str.substring(1);
      }
      long l = Long.valueOf((String)localObject).longValue();
      localApplyUploadReq.uint64_recver_uin.set(l);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        int i;
        localException.printStackTrace();
      }
    }
    localApplyUploadReq.uint32_file_type.set(2);
    localApplyUploadReq.str_file_name.set(this.jdField_d_of_type_JavaLangString);
    localApplyUploadReq.uint64_file_size.set(this.jdField_q_of_type_Long);
    localApplyUploadReq.bytes_10m_md5.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_ArrayOfByte));
    localReqBody.msg_apply_upload_req.set(localApplyUploadReq);
    localObject = new cmd0x346.ExtensionReq();
    ((cmd0x346.ExtensionReq)localObject).uint64_id.set(3L);
    ((cmd0x346.ExtensionReq)localObject).uint32_ptt_format.set(0);
    ((cmd0x346.ExtensionReq)localObject).uint32_ptt_time.set(this.jdField_a_of_type_Baub.jdField_j_of_type_Int);
    i = bawa.a();
    ((cmd0x346.ExtensionReq)localObject).uint32_net_type.set(i);
    ((cmd0x346.ExtensionReq)localObject).uint32_voice_type.set(2);
    ((cmd0x346.ExtensionReq)localObject).uint64_type.set(0);
    localReqBody.msg_extension_req.set((MessageMicro)localObject);
    return localReqBody.toByteArray();
  }
  
  public final void aQ_()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BDHCommonUploadProcessor", 2, "BDHNormalUploadProcessor.sendFile()");
    }
    this.jdField_b_of_type_Bamy.a();
    bamq localbamq = new bamq(this, SystemClock.uptimeMillis());
    if (this.jdField_a_of_type_Int == 9) {
      this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_Int, this.jdField_a_of_type_Baub.i, (int)this.r, bdlr.a(this.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_ArrayOfByte, localbamq, this.jdField_a_of_type_TencentImCsCmd0x388Cmd0x388$ExpRoamExtendInfo.toByteArray());
    }
    for (;;)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().submitTransactionTask(this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction);
      if (QLog.isColorLevel()) {
        QLog.d("BDHCommonUploadProcessor", 2, "<BDH_LOG> Transaction submit RetCode:" + i + " T_ID:" + this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.getTransationId() + " UniSeq:" + this.jdField_a_of_type_Baub.jdField_a_of_type_Long + " MD5:" + this.jdField_c_of_type_JavaLangString + " uuid:" + this.jdField_l_of_type_JavaLangString + " Path:" + this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.filePath + " Cmd:" + 3);
      }
      if (i != 0)
      {
        a(i, "SubmitError.", "", this.jdField_b_of_type_Bamy);
        d();
      }
      return;
      if (this.jdField_a_of_type_Int == 20) {
        this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_Int, this.jdField_a_of_type_Baub.i, (int)this.r, bdlr.a(this.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_ArrayOfByte, localbamq, this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolBdh_extinfo$UploadPicExtInfo.toByteArray());
      } else if (this.jdField_a_of_type_Int == 36) {
        this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_Int, this.jdField_a_of_type_Baub.i, (int)this.r, this.jdField_a_of_type_ArrayOfByte, localbamq, a(), false);
      } else if (this.jdField_a_of_type_Int == 40) {
        this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_Int, this.jdField_a_of_type_Baub.i, (int)this.r, this.jdField_a_of_type_ArrayOfByte, localbamq, this.jdField_a_of_type_Baub.jdField_a_of_type_ArrayOfByte, true);
      } else if (this.jdField_a_of_type_Int == 54) {
        this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_Int, this.jdField_a_of_type_Baub.i, (int)this.r, this.jdField_a_of_type_ArrayOfByte, localbamq, this.jdField_a_of_type_Baub.jdField_a_of_type_ArrayOfByte, false);
      } else if ((this.jdField_a_of_type_Int == 51) || (this.jdField_a_of_type_Int == 58) || (this.jdField_a_of_type_Int == 62) || (this.jdField_a_of_type_Int == 65) || (this.jdField_a_of_type_Int == 70) || (this.jdField_a_of_type_Int == 76)) {
        this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_Int, this.jdField_a_of_type_Baub.i, (int)this.r, this.jdField_a_of_type_ArrayOfByte, localbamq, this.jdField_a_of_type_Baub.jdField_a_of_type_ArrayOfByte, false);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_Int, this.jdField_a_of_type_Baub.i, (int)this.r, bdlr.a(this.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_ArrayOfByte, localbamq);
      }
    }
  }
  
  public final void aS_()
  {
    super.aS_();
    if (QLog.isColorLevel()) {
      QLog.d("BDHCommonUploadProcessor", 2, "BDHCommonUploadProcessor.start()");
    }
    if ((this.jdField_a_of_type_ArrayOfByte == null) && (!h()))
    {
      d();
      return;
    }
    if (36 == this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_JavaLangString = "null";
      this.jdField_a_of_type_Baoj.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Baub.i;
      aQ_();
    }
    for (;;)
    {
      d(1001);
      return;
      if (18 == this.jdField_a_of_type_Int)
      {
        this.jdField_a_of_type_JavaLangString = "null";
        aQ_();
      }
      else if (40 == this.jdField_a_of_type_Int)
      {
        aQ_();
      }
      else if (54 == this.jdField_a_of_type_Int)
      {
        aQ_();
      }
      else if ((51 == this.jdField_a_of_type_Int) || (62 == this.jdField_a_of_type_Int))
      {
        aQ_();
      }
      else if (58 == this.jdField_a_of_type_Int)
      {
        aQ_();
      }
      else if (65 == this.jdField_a_of_type_Int)
      {
        aQ_();
      }
      else if (70 == this.jdField_a_of_type_Int)
      {
        aQ_();
      }
      else if (76 == this.jdField_a_of_type_Int)
      {
        aQ_();
      }
      else
      {
        f();
      }
    }
  }
  
  public final int b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BDHCommonUploadProcessor", 2, "BDHCommonUploadProcessor.resume()");
    }
    if (this.jdField_a_of_type_Int == 54)
    {
      if (this.jdField_k_of_type_Boolean)
      {
        this.jdField_k_of_type_Boolean = false;
        if (QLog.isColorLevel()) {
          b("resume", "");
        }
        if (this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().resumeTransactionTask(this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction);
        }
      }
      return super.b();
    }
    a();
    f();
    return 0;
  }
  
  public final int c()
  {
    b("uiParam", this.jdField_a_of_type_Baub.toString());
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Baub.i))
    {
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      ((BitmapFactory.Options)localObject).inSampleSize = 1;
      bdda.a(this.jdField_a_of_type_Baub.i, (BitmapFactory.Options)localObject);
      this.jdField_q_of_type_Int = ((BitmapFactory.Options)localObject).outHeight;
      this.p = ((BitmapFactory.Options)localObject).outWidth;
    }
    Object localObject = this.jdField_a_of_type_Baub.i;
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      b(9302, a(new Exception("filePath null")));
      d();
      return -1;
    }
    File localFile = new File((String)localObject);
    if (!localFile.exists())
    {
      b(9042, a(new Exception("sendFile not exist " + (String)localObject)));
      d();
      return -1;
    }
    if (!localFile.canRead())
    {
      b(9070, a(new Exception("sendFile not readable " + this.jdField_a_of_type_Baoj.jdField_c_of_type_JavaLangString)));
      d();
      return -1;
    }
    long l = localFile.length();
    this.jdField_a_of_type_Baoj.jdField_a_of_type_Long = l;
    this.jdField_q_of_type_Long = l;
    if (l <= 0L)
    {
      b(9071, a(new Exception("file size 0 " + (String)localObject)));
      d();
      return -1;
    }
    localObject = bdcs.b((String)localObject);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.e = ((String)localObject);
    }
    if ((this.jdField_a_of_type_Int != 54) && (l >= bavd.a()))
    {
      a(9063, (String)localObject, d((String)localObject), null);
      d();
      return -1;
    }
    if ((this.jdField_a_of_type_Baub.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_Baub.jdField_a_of_type_JavaLangObject instanceof bauf))) {
      this.jdField_l_of_type_Boolean = ((bauf)this.jdField_a_of_type_Baub.jdField_a_of_type_JavaLangObject).jdField_a_of_type_Boolean;
    }
    return 0;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BDHCommonUploadProcessor", 2, "BDHCommonUploadProcessor.pause()");
    }
    if (this.jdField_a_of_type_Int == 54)
    {
      if (!this.jdField_k_of_type_Boolean)
      {
        this.jdField_k_of_type_Boolean = true;
        if (QLog.isColorLevel()) {
          b("pause", "");
        }
        d(1006);
        if (this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().stopTransactionTask(this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction);
        }
      }
      return;
    }
    super.c();
  }
  
  final void d()
  {
    super.d();
    if (QLog.isColorLevel()) {
      QLog.d("BDHCommonUploadProcessor", 2, "uploadCustomEmoticon resultError");
    }
    d(1005);
    if (QLog.isColorLevel()) {
      QLog.d("BDHCommonUploadProcessor", 2, "uploadCustomEmoticon resultError ---- errCode: " + this.jdField_j_of_type_Int + ", errDesc:" + this.jdField_j_of_type_JavaLangString);
    }
    awfz localawfz;
    String str;
    if (this.jdField_a_of_type_Baub.jdField_a_of_type_Awfy != null)
    {
      localawfz = new awfz();
      localawfz.jdField_a_of_type_Int = -1;
      localawfz.jdField_b_of_type_Int = this.jdField_j_of_type_Int;
      localawfz.jdField_a_of_type_JavaLangString = this.jdField_j_of_type_JavaLangString;
      if ((this.jdField_a_of_type_Int == 20) && (bamw.a(120509L).equals(this.jdField_a_of_type_JavaUtilHashMap.get("param_reason")))) {
        localawfz.jdField_b_of_type_Int = 120509;
      }
      if (this.jdField_a_of_type_Int == 9)
      {
        str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("param_reason");
        if (!bamw.a(400010L).equals(str)) {
          break label208;
        }
        localawfz.jdField_b_of_type_Int = 400010;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Baub.jdField_a_of_type_Awfy.b(localawfz);
      return;
      label208:
      if (bamw.a(400011L).equals(str)) {
        localawfz.jdField_b_of_type_Int = 400011;
      }
    }
  }
  
  final void e()
  {
    super.e();
    if (QLog.isColorLevel()) {
      QLog.d("BDHCommonUploadProcessor", 2, "uploadCustomEmoticon resultOk");
    }
    d(1003);
    if (QLog.isColorLevel()) {
      QLog.d("BDHCommonUploadProcessor", 2, "onSuccess().");
    }
    if (this.jdField_a_of_type_Baub.jdField_a_of_type_Awfy != null)
    {
      awfz localawfz = new awfz();
      localawfz.jdField_a_of_type_Int = 0;
      if (this.jdField_a_of_type_Int == 20) {
        localawfz.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Baoj.g;
      }
      this.jdField_a_of_type_Baub.jdField_a_of_type_Awfy.b(localawfz);
    }
    if ((this.jdField_a_of_type_Int == 9) || (this.jdField_a_of_type_Int == 76)) {
      d(1008);
    }
  }
  
  public final void onResp(baqw parambaqw)
  {
    super.onResp(parambaqw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bamp
 * JD-Core Version:    0.7.0.1
 */