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

public class bdsl
  extends bdtc
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long = 0L;
  String jdField_a_of_type_JavaLangString;
  public ywj a;
  ywl jdField_a_of_type_Ywl;
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
  
  public bdsl(bdsv parambdsv, bdzn parambdzn, String paramString)
  {
    super(parambdsv, parambdzn);
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_a_of_type_Ywj = ywj.a();
    this.m = paramString;
  }
  
  public int a()
  {
    this.jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("ArtFilterUploadProcessor", 2, "cancelTask taskId:" + this.jdField_c_of_type_Int + " mRichProtoReq:" + this.jdField_a_of_type_Bebv + " mTrans:" + this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction + " mNetReq:" + this.jdField_a_of_type_Bdws);
    }
    if (this.jdField_a_of_type_Bebv != null)
    {
      bedb.b(this.jdField_a_of_type_Bebv);
      this.jdField_a_of_type_Bebv = null;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.cancelTransaction();
      this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction = null;
    }
    if (this.jdField_a_of_type_Bdws != null)
    {
      this.jdField_a_of_type_Bdvu.b(this.jdField_a_of_type_Bdws);
      this.jdField_a_of_type_Bdws = null;
    }
    return 0;
  }
  
  public void a()
  {
    bebv localbebv = new bebv();
    bece localbece = new bece();
    localbece.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
    localbece.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Bdzn.jdField_c_of_type_JavaLangString;
    localbece.e = "";
    localbece.f = this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int;
    localbece.jdField_a_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    localbece.jdField_a_of_type_Long = this.jdField_q_of_type_Long;
    localbece.jdField_a_of_type_ArrayOfByte = this.jdField_b_of_type_ArrayOfByte;
    localbece.jdField_c_of_type_Int = this.p;
    localbece.jdField_d_of_type_Int = this.jdField_q_of_type_Int;
    if (this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int == 1006) {}
    for (boolean bool = true;; bool = false)
    {
      localbece.jdField_c_of_type_Boolean = bool;
      localbece.jdField_b_of_type_Boolean = this.n;
      localbebv.jdField_a_of_type_Bedc = this;
      localbebv.jdField_a_of_type_JavaLangString = "art_filter_up";
      localbebv.jdField_a_of_type_JavaUtilList.add(localbece);
      localbebv.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getProtoReqManager();
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHwEngine().preConnect();
      this.jdField_a_of_type_Bdsz.a();
      if (QLog.isColorLevel()) {
        QLog.d("ArtFilterUploadProcessor", 2, "sendTransferRequest:" + localbebv);
      }
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      this.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_Bebv = localbebv;
      bedb.a(localbebv);
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, int paramInt3, ywl paramywl, boolean paramBoolean)
  {
    this.x = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_c_of_type_Int = paramInt3;
    this.jdField_a_of_type_Ywl = paramywl;
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d("ArtFilterUploadProcessor", 2, "FilterUploadInfo:" + paramywl);
    }
    if (paramywl == null) {
      return;
    }
    this.jdField_q_of_type_Long = paramywl.jdField_a_of_type_Long;
    this.jdField_b_of_type_ArrayOfByte = paramywl.jdField_a_of_type_ArrayOfByte;
    this.jdField_d_of_type_JavaLangString = paramywl.jdField_b_of_type_JavaLangString;
    this.jdField_a_of_type_JavaLangString = (EditVideoArtFilter.jdField_a_of_type_JavaLangString + paramywl.jdField_b_of_type_Long + "_" + paramInt2 + ".png");
    this.jdField_q_of_type_Int = paramywl.jdField_a_of_type_Int;
    this.p = paramywl.jdField_b_of_type_Int;
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
      ((Bundle)localObject).putString("param_art_filter_resource_path", this.jdField_a_of_type_Ywl.jdField_a_of_type_JavaLangString);
      ((Bundle)localObject).putString("param_art_filter_output_path", this.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("ArtFilterUploadProcessor", 2, "ReturnFilterResult  callbackId:" + this.x + " taskId:" + this.jdField_b_of_type_Int + " styleId:" + this.jdField_c_of_type_Int + " errorCode:" + paramInt + " errorFrom:" + paramString + " bundle:" + localObject);
      }
      this.jdField_a_of_type_Ywj.callbackResult(this.x, EIPCResult.createSuccessResult((Bundle)localObject));
      this.jdField_a_of_type_Ywj.jdField_a_of_type_AndroidUtilSparseArray.remove(this.jdField_b_of_type_Int);
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
    bctj.a(BaseApplication.getContext()).a(null, "afCosttimeAndFlowReport", bool, this.j - this.i, this.jdField_q_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
  }
  
  public void a(bebv parambebv, beck parambeck)
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_a_of_type_Bebv = null;
      this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
    } while (parambeck == null);
    int k = 0;
    label26:
    if (k < parambeck.jdField_a_of_type_JavaUtilList.size())
    {
      parambebv = (becm)parambeck.jdField_a_of_type_JavaUtilList.get(k);
      if (QLog.isColorLevel()) {
        QLog.d("ArtFilterUploadProcessor", 2, "getTransferResp:" + parambebv);
      }
      if (parambebv.jdField_c_of_type_Int != 0) {
        break label142;
      }
      this.m = parambebv.jdField_c_of_type_JavaLangString;
      if (this.jdField_a_of_type_Ywj.jdField_b_of_type_JavaLangString.equals(this.jdField_a_of_type_Ywl.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_Ywj.jdField_a_of_type_JavaLangString = parambebv.jdField_c_of_type_JavaLangString;
        aL_();
      }
    }
    for (;;)
    {
      k += 1;
      break label26;
      break;
      label142:
      a(parambebv.jdField_c_of_type_Int, "getTransferError");
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
      bdsm localbdsm = new bdsm(this);
      byte[] arrayOfByte = bgmj.a(this.m);
      Object localObject = new CSDataHighwayHead.FilterExtendinfo();
      ((CSDataHighwayHead.FilterExtendinfo)localObject).uint32_filter_flag.set(1);
      CSDataHighwayHead.C2CCommonExtendinfo localC2CCommonExtendinfo = new CSDataHighwayHead.C2CCommonExtendinfo();
      localC2CCommonExtendinfo.uint32_info_id.set(1);
      localC2CCommonExtendinfo.msg_filter_extendinfo.set((MessageMicro)localObject);
      localObject = localC2CCommonExtendinfo.toByteArray();
      this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), 1, this.jdField_a_of_type_Ywl.jdField_a_of_type_JavaLangString, (int)this.r, arrayOfByte, this.jdField_b_of_type_ArrayOfByte, localbdsm, (byte[])localObject);
      k = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHwEngine().submitTransactionTask(this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction);
      this.jdField_c_of_type_Long = SystemClock.uptimeMillis();
      this.jdField_a_of_type_Int = 2;
      if (QLog.isColorLevel()) {
        QLog.d("ArtFilterUploadProcessor", 2, "<BDH_LOG> Transaction submit RetCode:" + k + " T_ID:" + this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.getTransationId() + " MD5:" + this.jdField_a_of_type_Ywl.jdField_a_of_type_ArrayOfByte + " uuid:" + this.l + " Path:" + this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.filePath);
      }
    } while (k == 0);
    a(k, "submit transaction error");
  }
  
  void aM_()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    Object localObject1 = new bdsn(this);
    Object localObject2 = new CSDataHighwayHead.FilterExtendinfo();
    ((CSDataHighwayHead.FilterExtendinfo)localObject2).uint32_filter_flag.set(2);
    CSDataHighwayHead.C2CCommonExtendinfo localC2CCommonExtendinfo = new CSDataHighwayHead.C2CCommonExtendinfo();
    localC2CCommonExtendinfo.uint32_info_id.set(1);
    CSDataHighwayHead.FilterStyle localFilterStyle = new CSDataHighwayHead.FilterStyle();
    localFilterStyle.style_id.set(this.jdField_b_of_type_Int);
    localFilterStyle.style_name.set(ByteStringMicro.copyFrom(bgmj.a(this.jdField_b_of_type_JavaLangString)));
    CSDataHighwayHead.ImageFilterRequest localImageFilterRequest = new CSDataHighwayHead.ImageFilterRequest();
    String str = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin() + this.jdField_b_of_type_Int + this.jdField_b_of_type_JavaLangString + this.jdField_d_of_type_JavaLangString + SystemClock.uptimeMillis();
    localImageFilterRequest.session_id.set(ByteStringMicro.copyFromUtf8(str));
    if (QLog.isColorLevel()) {
      QLog.d("ArtFilterUploadProcessor", 2, "SendFilterFilter sessionId:" + str);
    }
    localImageFilterRequest.uin.set(Long.valueOf(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()).longValue());
    localImageFilterRequest.style.set(localFilterStyle);
    localImageFilterRequest.width.set(this.p);
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
    bdvs localbdvs = new bdvs();
    localbdvs.jdField_a_of_type_Bdvw = this;
    localbdvs.jdField_a_of_type_JavaLangString = paramString;
    localbdvs.jdField_a_of_type_Int = 0;
    localbdvs.jdField_a_of_type_Boolean = true;
    localbdvs.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localbdvs.jdField_d_of_type_Int = 0;
    localbdvs.jdField_a_of_type_Bdvv = jdField_a_of_type_Bdvv;
    if (QLog.isColorLevel()) {
      QLog.d("ArtFilterUploadProcessor", 2, "sendDownLoadRequest req:" + localbdvs);
    }
    this.g = SystemClock.uptimeMillis();
    this.jdField_a_of_type_Int = 4;
    this.jdField_a_of_type_Bdvu.a(localbdvs);
    this.jdField_a_of_type_Bdws = localbdvs;
  }
  
  public void onResp(bdwt parambdwt)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    super.onResp(parambdwt);
    this.h = SystemClock.uptimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("ArtFilterUploadProcessor", 2, "getDownLoadResponse: " + parambdwt);
    }
    this.jdField_a_of_type_JavaUtilHashMap.put("downloadFileSize", String.valueOf(parambdwt.jdField_a_of_type_Long));
    if (parambdwt.jdField_a_of_type_Int == 0)
    {
      this.jdField_a_of_type_Int = 5;
      a(0, null);
      return;
    }
    if (parambdwt.jdField_a_of_type_JavaLangString != null) {
      QLog.d("ArtFilterUploadProcessor", 1, "download dailed, mErrCode" + parambdwt.jdField_b_of_type_Int + "mErrDesc:" + parambdwt.jdField_a_of_type_JavaLangString);
    }
    a(parambdwt.jdField_b_of_type_Int, parambdwt.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdsl
 * JD-Core Version:    0.7.0.1
 */