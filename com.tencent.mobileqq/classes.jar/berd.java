import android.os.Bundle;
import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.biz.qqstory.takevideo.EditVideoArtFilter;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.IRequestCallback;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.C2CCommonExtendinfo;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.FilterExtendinfo;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.FilterStyle;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.ImageFilterRequest;
import com.tencent.mobileqq.highway.segment.RequestAck;
import com.tencent.mobileqq.highway.segment.RequestFilter;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class berd
  extends beru
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long = 0L;
  String jdField_a_of_type_JavaLangString;
  public zae a;
  zag jdField_a_of_type_Zag;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int;
  long jdField_b_of_type_Long = 0L;
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean;
  public int c;
  long c;
  long d;
  long e = 0L;
  long f = 0L;
  long g = 0L;
  long h = 0L;
  long i = 0L;
  long j = 0L;
  private int x;
  
  public berd(bern parambern, beyg parambeyg, String paramString)
  {
    super(parambern, parambeyg);
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_a_of_type_Zae = zae.a();
    this.m = paramString;
  }
  
  public int a()
  {
    this.jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("ArtFilterUploadProcessor", 2, "cancelTask taskId:" + this.jdField_c_of_type_Int + " mRichProtoReq:" + this.jdField_a_of_type_Bfau + " mTrans:" + this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction + " mNetReq:" + this.jdField_a_of_type_Bevl);
    }
    if (this.jdField_a_of_type_Bfau != null)
    {
      bfca.b(this.jdField_a_of_type_Bfau);
      this.jdField_a_of_type_Bfau = null;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.cancelTransaction();
      this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction = null;
    }
    if (this.jdField_a_of_type_Bevl != null)
    {
      this.jdField_a_of_type_Beuo.b(this.jdField_a_of_type_Bevl);
      this.jdField_a_of_type_Bevl = null;
    }
    return 0;
  }
  
  public void a()
  {
    bfau localbfau = new bfau();
    bfbd localbfbd = new bfbd();
    localbfbd.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
    localbfbd.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Beyg.jdField_c_of_type_JavaLangString;
    localbfbd.e = "";
    localbfbd.f = this.jdField_a_of_type_Beyg.jdField_a_of_type_Int;
    localbfbd.jdField_a_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    localbfbd.jdField_a_of_type_Long = this.jdField_q_of_type_Long;
    localbfbd.jdField_a_of_type_ArrayOfByte = this.jdField_b_of_type_ArrayOfByte;
    localbfbd.jdField_c_of_type_Int = this.jdField_d_of_type_Int;
    localbfbd.jdField_d_of_type_Int = this.jdField_q_of_type_Int;
    if (this.jdField_a_of_type_Beyg.jdField_a_of_type_Int == 1006) {}
    for (boolean bool = true;; bool = false)
    {
      localbfbd.jdField_c_of_type_Boolean = bool;
      localbfbd.jdField_b_of_type_Boolean = this.n;
      localbfau.jdField_a_of_type_Bfcb = this;
      localbfau.jdField_a_of_type_JavaLangString = "art_filter_up";
      localbfau.jdField_a_of_type_JavaUtilList.add(localbfbd);
      localbfau.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getProtoReqManager();
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHwEngine().preConnect();
      this.jdField_a_of_type_Berr.a();
      if (QLog.isColorLevel()) {
        QLog.d("ArtFilterUploadProcessor", 2, "sendTransferRequest:" + localbfau);
      }
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      this.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_Bfau = localbfau;
      bfca.a(localbfau);
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, int paramInt3, zag paramzag, boolean paramBoolean)
  {
    this.x = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_c_of_type_Int = paramInt3;
    this.jdField_a_of_type_Zag = paramzag;
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d("ArtFilterUploadProcessor", 2, "FilterUploadInfo:" + paramzag);
    }
    if (paramzag == null) {
      return;
    }
    this.jdField_q_of_type_Long = paramzag.jdField_a_of_type_Long;
    this.jdField_b_of_type_ArrayOfByte = paramzag.jdField_a_of_type_ArrayOfByte;
    this.jdField_d_of_type_JavaLangString = paramzag.jdField_b_of_type_JavaLangString;
    this.jdField_a_of_type_JavaLangString = (EditVideoArtFilter.jdField_a_of_type_JavaLangString + paramzag.jdField_b_of_type_Long + "_" + paramInt2 + ".png");
    this.jdField_q_of_type_Int = paramzag.jdField_a_of_type_Int;
    this.jdField_d_of_type_Int = paramzag.jdField_b_of_type_Int;
    this.i = SystemClock.uptimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("ArtFilterUploadProcessor", 2, "start()  needUploadImg:" + paramBoolean + " mUky:" + this.m);
    }
    if ((!paramBoolean) && (this.m != null))
    {
      aM_();
      return;
    }
    a();
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    boolean bool;
    Object localObject;
    if (paramInt == 0)
    {
      bool = true;
      this.j = SystemClock.uptimeMillis();
      localObject = new Bundle();
      ((Bundle)localObject).putInt("param_art_filter_task_id", this.jdField_c_of_type_Int);
      ((Bundle)localObject).putInt("param_art_filter_task_result", paramInt);
      ((Bundle)localObject).putInt("param_art_filter_style_id", this.jdField_b_of_type_Int);
      ((Bundle)localObject).putString("param_art_filter_resource_path", this.jdField_a_of_type_Zag.jdField_a_of_type_JavaLangString);
      ((Bundle)localObject).putString("param_art_filter_output_path", this.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("ArtFilterUploadProcessor", 2, "ReturnFilterResult  callbackId:" + this.x + " taskId:" + this.jdField_b_of_type_Int + " styleId:" + this.jdField_c_of_type_Int + " errorCode:" + paramInt + " errorFrom:" + paramString + " bundle:" + localObject);
      }
      this.jdField_a_of_type_Zae.callbackResult(this.x, EIPCResult.createSuccessResult((Bundle)localObject));
      this.jdField_a_of_type_Zae.jdField_a_of_type_AndroidUtilSparseArray.remove(this.jdField_b_of_type_Int);
      this.jdField_a_of_type_JavaUtilHashMap.put("uploadFileSize", String.valueOf(this.jdField_q_of_type_Long));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(paramInt));
      this.jdField_a_of_type_JavaUtilHashMap.put("step", String.valueOf(this.jdField_a_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("filterId", String.valueOf(this.jdField_b_of_type_Int));
      localObject = this.jdField_a_of_type_JavaUtilHashMap;
      if (this.jdField_b_of_type_Boolean != true) {
        break label587;
      }
    }
    label587:
    for (paramString = "1";; paramString = "0")
    {
      ((HashMap)localObject).put("isuploadOriginalPic", paramString);
      long l1 = 0L;
      long l2 = 0L;
      long l3 = 0L;
      long l4 = 0L;
      if (this.jdField_b_of_type_Long > this.jdField_a_of_type_Long) {
        l1 = this.jdField_b_of_type_Long - this.jdField_a_of_type_Long;
      }
      if (this.jdField_d_of_type_Long > this.jdField_c_of_type_Long) {
        l2 = this.jdField_d_of_type_Long - this.jdField_c_of_type_Long;
      }
      if (this.f > this.e) {
        l3 = this.f - this.e;
      }
      if (this.h > this.g) {
        l4 = this.h - this.g;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("wup_Costtime", String.valueOf(l1));
      this.jdField_a_of_type_JavaUtilHashMap.put("original_Costtime", String.valueOf(l2));
      this.jdField_a_of_type_JavaUtilHashMap.put("filter_Costtime", String.valueOf(l3));
      this.jdField_a_of_type_JavaUtilHashMap.put("download_Costtime", String.valueOf(l4));
      if (!QLog.isColorLevel()) {
        break label604;
      }
      paramString = new StringBuilder();
      localObject = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (this.jdField_a_of_type_JavaUtilHashMap.get(str) != null)
        {
          paramString.append("&");
          paramString.append(str);
          paramString.append("=");
          paramString.append((String)this.jdField_a_of_type_JavaUtilHashMap.get(str));
        }
      }
      bool = false;
      break;
    }
    QLog.d("ArtFilterUploadProcessor", 2, paramString.toString());
    label604:
    bdmc.a(BaseApplication.getContext()).a(null, "afCosttimeAndFlowReport", bool, this.j - this.i, this.jdField_q_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
  }
  
  public void a(bfau parambfau, bfbj parambfbj)
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_a_of_type_Bfau = null;
      this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
    } while (parambfbj == null);
    int k = 0;
    label26:
    if (k < parambfbj.jdField_a_of_type_JavaUtilList.size())
    {
      parambfau = (bfbl)parambfbj.jdField_a_of_type_JavaUtilList.get(k);
      if (QLog.isColorLevel()) {
        QLog.d("ArtFilterUploadProcessor", 2, "getTransferResp:" + parambfau);
      }
      if (parambfau.jdField_c_of_type_Int != 0) {
        break label142;
      }
      this.m = parambfau.jdField_c_of_type_JavaLangString;
      if (this.jdField_a_of_type_Zae.jdField_b_of_type_JavaLangString.equals(this.jdField_a_of_type_Zag.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_Zae.jdField_a_of_type_JavaLangString = parambfau.jdField_c_of_type_JavaLangString;
        aL_();
      }
    }
    for (;;)
    {
      k += 1;
      break label26;
      break;
      label142:
      a(parambfau.jdField_c_of_type_Int, "getTransferError");
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, paramString2);
  }
  
  public final void aL_()
  {
    if (this.jdField_a_of_type_Boolean) {}
    int k;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ArtFilterUploadProcessor", 2, "ArtFilterUploadProcessor.sendFile()");
      }
      bere localbere = new bere(this);
      byte[] arrayOfByte = bhml.a(this.m);
      Object localObject = new CSDataHighwayHead.FilterExtendinfo();
      ((CSDataHighwayHead.FilterExtendinfo)localObject).uint32_filter_flag.set(1);
      CSDataHighwayHead.C2CCommonExtendinfo localC2CCommonExtendinfo = new CSDataHighwayHead.C2CCommonExtendinfo();
      localC2CCommonExtendinfo.uint32_info_id.set(1);
      localC2CCommonExtendinfo.msg_filter_extendinfo.set((MessageMicro)localObject);
      localObject = localC2CCommonExtendinfo.toByteArray();
      this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), 1, this.jdField_a_of_type_Zag.jdField_a_of_type_JavaLangString, (int)this.r, arrayOfByte, this.jdField_b_of_type_ArrayOfByte, localbere, (byte[])localObject);
      k = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHwEngine().submitTransactionTask(this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction);
      this.jdField_c_of_type_Long = SystemClock.uptimeMillis();
      this.jdField_a_of_type_Int = 2;
      if (QLog.isColorLevel()) {
        QLog.d("ArtFilterUploadProcessor", 2, "<BDH_LOG> Transaction submit RetCode:" + k + " T_ID:" + this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.getTransationId() + " MD5:" + this.jdField_a_of_type_Zag.jdField_a_of_type_ArrayOfByte + " uuid:" + this.l + " Path:" + this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.filePath);
      }
    } while (k == 0);
    a(k, "submit transaction error");
  }
  
  void aM_()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    Object localObject1 = new berf(this);
    Object localObject2 = new CSDataHighwayHead.FilterExtendinfo();
    ((CSDataHighwayHead.FilterExtendinfo)localObject2).uint32_filter_flag.set(2);
    CSDataHighwayHead.C2CCommonExtendinfo localC2CCommonExtendinfo = new CSDataHighwayHead.C2CCommonExtendinfo();
    localC2CCommonExtendinfo.uint32_info_id.set(1);
    CSDataHighwayHead.FilterStyle localFilterStyle = new CSDataHighwayHead.FilterStyle();
    localFilterStyle.style_id.set(this.jdField_b_of_type_Int);
    localFilterStyle.style_name.set(ByteStringMicro.copyFrom(bhml.a(this.jdField_b_of_type_JavaLangString)));
    CSDataHighwayHead.ImageFilterRequest localImageFilterRequest = new CSDataHighwayHead.ImageFilterRequest();
    String str = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin() + this.jdField_b_of_type_Int + this.jdField_b_of_type_JavaLangString + this.jdField_d_of_type_JavaLangString + SystemClock.uptimeMillis();
    localImageFilterRequest.session_id.set(ByteStringMicro.copyFromUtf8(str));
    if (QLog.isColorLevel()) {
      QLog.d("ArtFilterUploadProcessor", 2, "SendFilterFilter sessionId:" + str);
    }
    localImageFilterRequest.uin.set(Long.valueOf(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()).longValue());
    localImageFilterRequest.style.set(localFilterStyle);
    localImageFilterRequest.width.set(this.jdField_d_of_type_Int);
    localImageFilterRequest.height.set(this.jdField_q_of_type_Int);
    ((CSDataHighwayHead.FilterExtendinfo)localObject2).msg_image_filter_request.set(localImageFilterRequest);
    localC2CCommonExtendinfo.msg_filter_extendinfo.set((MessageMicro)localObject2);
    localObject2 = localC2CCommonExtendinfo.toByteArray();
    localObject1 = new RequestFilter(String.valueOf(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()), 1, this.m.getBytes(), 15000L, (IRequestCallback)localObject1, (byte[])localObject2, null, 0);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHwEngine().SubmitAckRequest((RequestAck)localObject1);
    this.e = SystemClock.uptimeMillis();
    this.jdField_a_of_type_Int = 3;
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    beum localbeum = new beum();
    localbeum.jdField_a_of_type_Beuq = this;
    localbeum.jdField_a_of_type_JavaLangString = paramString;
    localbeum.jdField_a_of_type_Int = 0;
    localbeum.jdField_a_of_type_Boolean = true;
    localbeum.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localbeum.jdField_d_of_type_Int = 0;
    localbeum.jdField_a_of_type_Beup = jdField_a_of_type_Beup;
    if (QLog.isColorLevel()) {
      QLog.d("ArtFilterUploadProcessor", 2, "sendDownLoadRequest req:" + localbeum);
    }
    this.g = SystemClock.uptimeMillis();
    this.jdField_a_of_type_Int = 4;
    this.jdField_a_of_type_Beuo.a(localbeum);
    this.jdField_a_of_type_Bevl = localbeum;
  }
  
  public void onResp(bevm parambevm)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    super.onResp(parambevm);
    this.h = SystemClock.uptimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("ArtFilterUploadProcessor", 2, "getDownLoadResponse: " + parambevm);
    }
    this.jdField_a_of_type_JavaUtilHashMap.put("downloadFileSize", String.valueOf(parambevm.jdField_a_of_type_Long));
    if (parambevm.jdField_a_of_type_Int == 0)
    {
      this.jdField_a_of_type_Int = 5;
      a(0, null);
      return;
    }
    if (parambevm.jdField_a_of_type_JavaLangString != null) {
      QLog.d("ArtFilterUploadProcessor", 1, "download dailed, mErrCode" + parambevm.jdField_b_of_type_Int + "mErrDesc:" + parambevm.jdField_a_of_type_JavaLangString);
    }
    a(parambevm.jdField_b_of_type_Int, parambevm.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     berd
 * JD-Core Version:    0.7.0.1
 */