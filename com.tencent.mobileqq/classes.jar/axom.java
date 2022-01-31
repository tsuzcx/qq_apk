import android.graphics.BitmapFactory.Options;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.UploadPicExtInfo;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadReq;
import tencent.im.cs.cmd0x346.cmd0x346.ExtensionReq;
import tencent.im.cs.cmd0x346.cmd0x346.ReqBody;
import tencent.im.cs.cmd0x388.cmd0x388.ExpRoamExtendInfo;

public class axom
  extends axox
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
  
  public axom(axvo paramaxvo, axvt paramaxvt)
  {
    super(paramaxvo, paramaxvt);
    this.jdField_a_of_type_Int = paramaxvt.jdField_c_of_type_Int;
    this.jdField_a_of_type_Axqf.jdField_c_of_type_Int = paramaxvt.jdField_c_of_type_Int;
    this.jdField_b_of_type_JavaLangString = paramaxvt.jdField_a_of_type_JavaLangString;
    this.jdField_d_of_type_ArrayOfByte = paramaxvt.jdField_a_of_type_ArrayOfByte;
  }
  
  private final void f()
  {
    this.jdField_a_of_type_Axow.a();
    axyg localaxyg = a();
    if (!e())
    {
      a(9366, "illegal app", null, this.jdField_a_of_type_Axow);
      d();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        b("requestStart", localaxyg.toString());
      }
    } while ((!f()) || (localaxyg == null));
    this.jdField_a_of_type_Axyg = localaxyg;
    QLog.i("BDHCommonUploadProcessor", 1, "BDHCommonUploadProcessor commonId: " + this.jdField_a_of_type_Int);
    axzm.a(localaxyg);
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
    for (paramLong = Math.min(paramLong, this.jdField_a_of_type_Bess.a(BaseApplication.getContext(), this.jdField_q_of_type_Long, this.s, -1));; paramLong = Math.min(paramLong, 14600L)) {
      return Math.min(paramLong, 131072L);
    }
  }
  
  protected axyg a()
  {
    axyg localaxyg = new axyg();
    axyp localaxyp = new axyp();
    localaxyp.jdField_a_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    localaxyp.jdField_a_of_type_Long = this.jdField_q_of_type_Long;
    localaxyp.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    localaxyp.jdField_c_of_type_Int = this.p;
    localaxyp.jdField_d_of_type_Int = this.jdField_q_of_type_Int;
    localaxyp.b = this.jdField_l_of_type_Boolean;
    localaxyp.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localaxyp.jdField_a_of_type_Boolean = this.jdField_a_of_type_Axvt.jdField_k_of_type_Boolean;
    localaxyp.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Axvt.jdField_c_of_type_JavaLangString;
    localaxyg.jdField_a_of_type_Axzn = this;
    localaxyg.jdField_a_of_type_JavaLangString = "bdh_common_up";
    localaxyg.jdField_a_of_type_JavaUtilList.add(localaxyp);
    localaxyg.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
    localaxyg.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localaxyg.jdField_a_of_type_ArrayOfByte = this.jdField_d_of_type_ArrayOfByte;
    return localaxyg;
  }
  
  protected final void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    if (paramLong1 != 0L) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.countFlow(true, 1, this.jdField_a_of_type_Axvt.jdField_b_of_type_Int, this.jdField_a_of_type_Axvt.jdField_a_of_type_Int, paramLong1);
    }
    if (paramLong2 != 0L) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.countFlow(true, 1, this.jdField_a_of_type_Axvt.jdField_b_of_type_Int, this.jdField_a_of_type_Axvt.jdField_a_of_type_Int, paramLong2);
    }
    if (paramLong3 != 0L) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.countFlow(true, 0, this.jdField_a_of_type_Axvt.jdField_b_of_type_Int, this.jdField_a_of_type_Axvt.jdField_a_of_type_Int, paramLong3);
    }
    if (paramLong4 != 0L) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.countFlow(true, 0, this.jdField_a_of_type_Axvt.jdField_b_of_type_Int, this.jdField_a_of_type_Axvt.jdField_a_of_type_Int, paramLong4);
    }
  }
  
  public final void a(axyg paramaxyg, axyv paramaxyv)
  {
    if (paramaxyv != null)
    {
      int i = 0;
      if (i < paramaxyv.jdField_a_of_type_JavaUtilList.size())
      {
        paramaxyg = (axyw)paramaxyv.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          b("procUrl", paramaxyg.toString());
        }
        a(this.jdField_a_of_type_Axow, paramaxyg);
        if (QLog.isColorLevel()) {
          QLog.d("BDHCommonUploadProcessor", 2, "onBusiProtoResp()------response.result = " + paramaxyg.jdField_c_of_type_Int);
        }
        if (paramaxyg.jdField_c_of_type_Int == 0)
        {
          this.jdField_a_of_type_JavaLangString = paramaxyg.jdField_a_of_type_JavaLangString;
          this.s = this.jdField_q_of_type_Long;
          if (QLog.isColorLevel()) {
            QLog.d("BDHCommonUploadProcessor", 2, "onBusiProtoResp()---- sessionKey: " + this.jdField_a_of_type_JavaLangString);
          }
          this.jdField_a_of_type_Axqf.jdField_l_of_type_JavaLangString = paramaxyg.jdField_b_of_type_JavaLangString;
          this.jdField_a_of_type_Axqf.m = paramaxyg.e;
          this.jdField_a_of_type_Axqf.n = paramaxyg.jdField_c_of_type_JavaLangString;
          this.jdField_a_of_type_Axqf.o = paramaxyg.jdField_d_of_type_JavaLangString;
          this.jdField_a_of_type_Axqf.i = ("http://" + paramaxyg.jdField_b_of_type_JavaLangString + paramaxyg.e);
          this.jdField_a_of_type_Axqf.j = ("http://" + paramaxyg.jdField_b_of_type_JavaLangString + paramaxyg.jdField_c_of_type_JavaLangString);
          this.jdField_a_of_type_Axqf.jdField_k_of_type_JavaLangString = ("http://" + paramaxyg.jdField_b_of_type_JavaLangString + paramaxyg.jdField_d_of_type_JavaLangString);
          this.jdField_a_of_type_Axqf.g = paramaxyg.f;
          if (paramaxyg.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_Axqf.a();
            e();
            if (QLog.isColorLevel()) {
              QLog.d("BDHCommonUploadProcessor", 2, "onBusiProtoResp()---- file is Exsit! " + this.jdField_a_of_type_Axvt.i);
            }
            label374:
            this.jdField_a_of_type_Long = paramaxyg.jdField_a_of_type_Long;
            this.jdField_a_of_type_Axqf.d = this.jdField_a_of_type_Long;
            if (QLog.isColorLevel()) {
              QLog.d("BDHCommonUploadProcessor", 2, "mFileID->" + this.jdField_a_of_type_Long + " groupUin->" + this.jdField_a_of_type_Axvt.jdField_c_of_type_JavaLangString);
            }
          }
        }
        for (;;)
        {
          i += 1;
          break;
          if ((this.jdField_a_of_type_Int == 9) && (paramaxyg.f != null)) {
            this.jdField_a_of_type_TencentImCsCmd0x388Cmd0x388$ExpRoamExtendInfo.bytes_resid.set(ByteStringMicro.copyFrom(paramaxyg.f.getBytes()));
          }
          if ((this.jdField_a_of_type_Int == 20) && (paramaxyg.f != null)) {
            this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolBdh_extinfo$UploadPicExtInfo.bytes_file_resid.set(ByteStringMicro.copyFrom(paramaxyg.f.getBytes()));
          }
          this.jdField_l_of_type_JavaLangString = paramaxyg.jdField_a_of_type_JavaLangString;
          this.s = paramaxyg.jdField_b_of_type_Int;
          this.r = paramaxyg.jdField_b_of_type_Long;
          aS_();
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
    if ((!paramBoolean) && (axtt.b(this.j))) {}
    while ((this.h) || ((paramBoolean) && ((this.m & 0x2) > 0)) || ((!paramBoolean) && ((this.m & 0x1) > 0))) {
      return;
    }
    int j = this.m;
    int i;
    long l;
    String str;
    if (paramBoolean)
    {
      i = 2;
      this.m = (i | j);
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
      awrn.a(BaseApplication.getContext()).a(null, this.jdField_b_of_type_JavaLangString, true, l, this.jdField_q_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
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
      if (this.j != -9527) {
        this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.j));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.i);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_picSize", String.valueOf(this.jdField_q_of_type_Long));
      awrn.a(BaseApplication.getContext()).a(null, this.jdField_b_of_type_JavaLangString, false, l, this.jdField_q_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
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
    ((cmd0x346.ExtensionReq)localObject).uint32_ptt_time.set(this.jdField_a_of_type_Axvt.j);
    i = axxs.a();
    ((cmd0x346.ExtensionReq)localObject).uint32_net_type.set(i);
    ((cmd0x346.ExtensionReq)localObject).uint32_voice_type.set(2);
    ((cmd0x346.ExtensionReq)localObject).uint64_type.set(0);
    localReqBody.msg_extension_req.set((MessageMicro)localObject);
    return localReqBody.toByteArray();
  }
  
  public final void aS_()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BDHCommonUploadProcessor", 2, "BDHNormalUploadProcessor.sendFile()");
    }
    this.jdField_b_of_type_Axow.a();
    axon localaxon = new axon(this, SystemClock.uptimeMillis());
    if (this.jdField_a_of_type_Int == 9) {
      this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_Int, this.jdField_a_of_type_Axvt.i, (int)this.r, bakz.a(this.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_ArrayOfByte, localaxon, this.jdField_a_of_type_TencentImCsCmd0x388Cmd0x388$ExpRoamExtendInfo.toByteArray());
    }
    for (;;)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().submitTransactionTask(this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction);
      if (QLog.isColorLevel()) {
        QLog.d("BDHCommonUploadProcessor", 2, "<BDH_LOG> Transaction submit RetCode:" + i + " T_ID:" + this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.getTransationId() + " UniSeq:" + this.jdField_a_of_type_Axvt.jdField_a_of_type_Long + " MD5:" + this.jdField_c_of_type_JavaLangString + " uuid:" + this.jdField_k_of_type_JavaLangString + " Path:" + this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.filePath + " Cmd:" + 3);
      }
      if (i != 0)
      {
        a(i, "SubmitError.", "", this.jdField_b_of_type_Axow);
        d();
      }
      return;
      if (this.jdField_a_of_type_Int == 20) {
        this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_Int, this.jdField_a_of_type_Axvt.i, (int)this.r, bakz.a(this.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_ArrayOfByte, localaxon, this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolBdh_extinfo$UploadPicExtInfo.toByteArray());
      } else if (this.jdField_a_of_type_Int == 36) {
        this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_Int, this.jdField_a_of_type_Axvt.i, (int)this.r, this.jdField_a_of_type_ArrayOfByte, localaxon, a(), false);
      } else if (this.jdField_a_of_type_Int == 40) {
        this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_Int, this.jdField_a_of_type_Axvt.i, (int)this.r, this.jdField_a_of_type_ArrayOfByte, localaxon, this.jdField_a_of_type_Axvt.jdField_a_of_type_ArrayOfByte, true);
      } else if (this.jdField_a_of_type_Int == 54) {
        this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_Int, this.jdField_a_of_type_Axvt.i, (int)this.r, this.jdField_a_of_type_ArrayOfByte, localaxon, this.jdField_a_of_type_Axvt.jdField_a_of_type_ArrayOfByte, false);
      } else if ((this.jdField_a_of_type_Int == 51) || (this.jdField_a_of_type_Int == 58) || (this.jdField_a_of_type_Int == 62) || (this.jdField_a_of_type_Int == 65) || (this.jdField_a_of_type_Int == 70)) {
        this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_Int, this.jdField_a_of_type_Axvt.i, (int)this.r, this.jdField_a_of_type_ArrayOfByte, localaxon, this.jdField_a_of_type_Axvt.jdField_a_of_type_ArrayOfByte, false);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_Int, this.jdField_a_of_type_Axvt.i, (int)this.r, bakz.a(this.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_ArrayOfByte, localaxon);
      }
    }
  }
  
  public final void aU_()
  {
    super.aU_();
    if (QLog.isColorLevel()) {
      QLog.d("BDHCommonUploadProcessor", 2, "BDHCommonUploadProcessor.start()");
    }
    if ((this.jdField_a_of_type_ArrayOfByte == null) && (!j()))
    {
      d();
      return;
    }
    if (36 == this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_JavaLangString = "null";
      this.jdField_a_of_type_Axqf.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Axvt.i;
      aS_();
    }
    for (;;)
    {
      d(1001);
      return;
      if (18 == this.jdField_a_of_type_Int)
      {
        this.jdField_a_of_type_JavaLangString = "null";
        aS_();
      }
      else if (40 == this.jdField_a_of_type_Int)
      {
        aS_();
      }
      else if (54 == this.jdField_a_of_type_Int)
      {
        aS_();
      }
      else if ((51 == this.jdField_a_of_type_Int) || (62 == this.jdField_a_of_type_Int))
      {
        aS_();
      }
      else if (58 == this.jdField_a_of_type_Int)
      {
        aS_();
      }
      else if (65 == this.jdField_a_of_type_Int)
      {
        aS_();
      }
      else if (70 == this.jdField_a_of_type_Int)
      {
        aS_();
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
    b("uiParam", this.jdField_a_of_type_Axvt.toString());
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Axvt.i))
    {
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      ((BitmapFactory.Options)localObject).inSampleSize = 1;
      bacm.a(this.jdField_a_of_type_Axvt.i, (BitmapFactory.Options)localObject);
      this.jdField_q_of_type_Int = ((BitmapFactory.Options)localObject).outHeight;
      this.p = ((BitmapFactory.Options)localObject).outWidth;
    }
    Object localObject = this.jdField_a_of_type_Axvt.i;
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
      b(9070, a(new Exception("sendFile not readable " + this.jdField_a_of_type_Axqf.jdField_c_of_type_JavaLangString)));
      d();
      return -1;
    }
    long l = localFile.length();
    this.jdField_a_of_type_Axqf.jdField_a_of_type_Long = l;
    this.jdField_q_of_type_Long = l;
    if (l <= 0L)
    {
      b(9071, a(new Exception("file size 0 " + (String)localObject)));
      d();
      return -1;
    }
    localObject = bace.b((String)localObject);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.e = ((String)localObject);
    }
    if ((this.jdField_a_of_type_Int != 54) && (l >= axwv.a()))
    {
      a(9063, (String)localObject, c((String)localObject), null);
      d();
      return -1;
    }
    if ((this.jdField_a_of_type_Axvt.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_Axvt.jdField_a_of_type_JavaLangObject instanceof axvx))) {
      this.jdField_l_of_type_Boolean = ((axvx)this.jdField_a_of_type_Axvt.jdField_a_of_type_JavaLangObject).jdField_a_of_type_Boolean;
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
      QLog.d("BDHCommonUploadProcessor", 2, "uploadCustomEmoticon resultError ---- errCode: " + this.j + ", errDesc:" + this.i);
    }
    atqr localatqr;
    String str;
    if (this.jdField_a_of_type_Axvt.jdField_a_of_type_Atqq != null)
    {
      localatqr = new atqr();
      localatqr.jdField_a_of_type_Int = -1;
      localatqr.jdField_b_of_type_Int = this.j;
      localatqr.jdField_a_of_type_JavaLangString = this.i;
      if ((this.jdField_a_of_type_Int == 20) && (axou.a(120509L).equals(this.jdField_a_of_type_JavaUtilHashMap.get("param_reason")))) {
        localatqr.jdField_b_of_type_Int = 120509;
      }
      if (this.jdField_a_of_type_Int == 9)
      {
        str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("param_reason");
        if (!axou.a(400010L).equals(str)) {
          break label208;
        }
        localatqr.jdField_b_of_type_Int = 400010;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Axvt.jdField_a_of_type_Atqq.b(localatqr);
      return;
      label208:
      if (axou.a(400011L).equals(str)) {
        localatqr.jdField_b_of_type_Int = 400011;
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
    if (this.jdField_a_of_type_Axvt.jdField_a_of_type_Atqq != null)
    {
      atqr localatqr = new atqr();
      localatqr.jdField_a_of_type_Int = 0;
      if (this.jdField_a_of_type_Int == 20) {
        localatqr.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Axqf.g;
      }
      this.jdField_a_of_type_Axvt.jdField_a_of_type_Atqq.b(localatqr);
    }
    if (this.jdField_a_of_type_Int == 9) {
      d(1008);
    }
  }
  
  public final void onResp(axsq paramaxsq)
  {
    super.onResp(paramaxsq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axom
 * JD-Core Version:    0.7.0.1
 */