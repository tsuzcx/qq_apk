import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.CommFileExtReq;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

public class bdwp
  extends bdtc
{
  public static int a;
  private Transaction a;
  public String a;
  public String b;
  public String n;
  public String o;
  
  public bdwp(bdsv parambdsv, bdzn parambdzn)
  {
    super(parambdsv, parambdzn);
    this.jdField_a_of_type_Bduk.jdField_a_of_type_Bdsx = this;
    this.jdField_a_of_type_Bduk.jdField_a_of_type_ArrayOfByte = parambdzn.jdField_a_of_type_ArrayOfByte;
    this.jdField_a_of_type_Bduk.jdField_a_of_type_JavaLangString = parambdzn.a();
  }
  
  private boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("NearbyPeoplePhotoUploadProcessor", 2, "personality_label start uniseq:" + this.jdField_a_of_type_Bdzn.jdField_a_of_type_Long + " src:" + this.jdField_a_of_type_Bdzn.i);
    }
    Object localObject = new CompressInfo(this.jdField_a_of_type_Bdzn.i, 0);
    ((CompressInfo)localObject).f = 0;
    ayyz.a((CompressInfo)localObject);
    if (TextUtils.isEmpty(((CompressInfo)localObject).e)) {
      d();
    }
    do
    {
      return true;
      if (QLog.isColorLevel()) {
        QLog.i("NearbyPeoplePhotoUploadProcessor", 2, "personality_label start compress dst:" + ((CompressInfo)localObject).e);
      }
      if (TextUtils.equals(((CompressInfo)localObject).e, ((CompressInfo)localObject).jdField_c_of_type_JavaLangString)) {
        break;
      }
      bduk localbduk = this.jdField_a_of_type_Bduk;
      bdzn localbdzn = this.jdField_a_of_type_Bdzn;
      localObject = ((CompressInfo)localObject).e;
      localbdzn.i = ((String)localObject);
      localbduk.jdField_c_of_type_JavaLangString = ((String)localObject);
    } while (c() != 0);
    return false;
  }
  
  private void g()
  {
    this.jdField_a_of_type_Bdsz.a();
    if (!e())
    {
      a(9366, "illegal app", null, this.jdField_a_of_type_Bdsz);
      d();
    }
    while (!f()) {
      return;
    }
    aL_();
  }
  
  protected long a(long paramLong)
  {
    paramLong = this.q - paramLong;
    if (!this.jdField_d_of_type_Boolean) {}
    for (paramLong = Math.min(paramLong, this.jdField_a_of_type_Bktt.a(BaseApplication.getContext(), this.q, this.s, -1));; paramLong = Math.min(paramLong, 14600L)) {
      return Math.min(paramLong, 131072L);
    }
  }
  
  protected void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    if (paramLong1 != 0L) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.countFlow(true, 1, this.jdField_a_of_type_Bduk.b, this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int, paramLong1);
    }
    if (paramLong2 != 0L) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.countFlow(true, 1, this.jdField_a_of_type_Bduk.b, this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int, paramLong2);
    }
    if (paramLong3 != 0L) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.countFlow(true, 0, this.jdField_a_of_type_Bduk.b, this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int, paramLong3);
    }
    if (paramLong4 != 0L) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.countFlow(true, 0, this.jdField_a_of_type_Bduk.b, this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int, paramLong4);
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if ((!paramBoolean) && (bdxr.a(this.jdField_j_of_type_Int))) {}
    while ((this.jdField_j_of_type_Boolean) || ((paramBoolean) && ((this.m & 0x2) > 0)) || ((!paramBoolean) && ((this.m & 0x1) > 0))) {
      return;
    }
    int j = this.m;
    int i;
    String str1;
    label98:
    long l;
    String str2;
    if (paramBoolean)
    {
      i = 2;
      this.m = (i | j);
      str1 = "";
      if ((this.jdField_a_of_type_Bduk.b != 8) && (this.jdField_a_of_type_Bduk.b != 64)) {
        break label185;
      }
      str1 = "actNearbyPeoplePicUpload";
      this.jdField_l_of_type_Long = System.currentTimeMillis();
      l = (System.nanoTime() - this.k) / 1000000L;
      HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
      if (this.jdField_c_of_type_ArrayOfByte != null) {
        break label430;
      }
      str2 = "null";
      label136:
      localHashMap.put("param_sessionKey", str2);
      if (!paramBoolean) {
        break label442;
      }
      bctj.a(BaseApplication.getContext()).a(null, str1, true, l, this.q, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
    for (;;)
    {
      m();
      return;
      i = 1;
      break;
      label185:
      if (this.jdField_a_of_type_Bduk.b == 21)
      {
        str1 = "actFreshNewsPicUpload";
        break label98;
      }
      if (this.jdField_a_of_type_Bduk.b == 22)
      {
        str1 = "actFriendAvatarUpload";
        break label98;
      }
      if (this.jdField_a_of_type_Bduk.b == 34)
      {
        str1 = "C2BUploadFile";
        break label98;
      }
      if (this.jdField_a_of_type_Bduk.b == 35)
      {
        str1 = "actProfileCoverPicUpload";
        break label98;
      }
      if ((this.jdField_a_of_type_Bduk.b == 36) || (this.jdField_a_of_type_Bduk.b == 37) || (this.jdField_a_of_type_Bduk.b == 38) || (this.jdField_a_of_type_Bduk.b == 48))
      {
        str1 = "actBaseDynamicAvatarUpload";
        break label98;
      }
      if ((this.jdField_a_of_type_Bduk.b == 39) || (this.jdField_a_of_type_Bduk.b == 40) || (this.jdField_a_of_type_Bduk.b == 41))
      {
        str1 = "actNearbyDynamicAvatarUpload";
        break label98;
      }
      if ((this.jdField_a_of_type_Bduk.b == 50) || (this.jdField_a_of_type_Bduk.b == 51))
      {
        str1 = "actHongbaoStarPhotoUpload";
        break label98;
      }
      if (this.jdField_a_of_type_Bduk.b == 56)
      {
        str1 = "actPersonalityLabelPhotoUpload";
        break label98;
      }
      if (this.jdField_a_of_type_Bduk.b != 23) {
        break label98;
      }
      str1 = "actExtendFriendSoundUpload";
      break label98;
      label430:
      str2 = bgva.a(this.jdField_c_of_type_ArrayOfByte);
      break label136;
      label442:
      if (this.jdField_j_of_type_Int != -9527) {
        this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.jdField_j_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.jdField_j_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_picSize", String.valueOf(this.q));
      bctj.a(BaseApplication.getContext()).a(null, str1, false, l, this.q, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
  }
  
  byte[] a(int paramInt1, int paramInt2)
  {
    return super.a(paramInt1, paramInt2);
  }
  
  public void aL_()
  {
    int i = 21;
    if (QLog.isColorLevel()) {
      QLog.i("NearbyPeoplePhotoUploadProcessor", 2, "NearbyPeoplePhotoUploadProcessor.sendFile()");
    }
    this.jdField_b_of_type_Bdsz.a();
    bdwq localbdwq = new bdwq(this, SystemClock.uptimeMillis());
    if ((this.jdField_a_of_type_Bduk.b == 8) || (this.jdField_a_of_type_Bduk.b == 64)) {
      i = 3;
    }
    for (;;)
    {
      this.jdField_a_of_type_Bduk.jdField_c_of_type_Int = i;
      try
      {
        if (SessionInfo.getInstance(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()).getHttpconn_sig_session() != null)
        {
          j = SessionInfo.getInstance(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()).getHttpconn_sig_session().length;
          this.jdField_d_of_type_ArrayOfByte = new byte[j];
          System.arraycopy(SessionInfo.getInstance(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()).getHttpconn_sig_session(), 0, this.jdField_d_of_type_ArrayOfByte, 0, j);
        }
        if (SessionInfo.getInstance(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()).getSessionKey() != null)
        {
          j = SessionInfo.getInstance(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()).getSessionKey().length;
          this.jdField_c_of_type_ArrayOfByte = new byte[j];
          System.arraycopy(SessionInfo.getInstance(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()).getSessionKey(), 0, this.jdField_c_of_type_ArrayOfByte, 0, j);
        }
        if (((this.jdField_d_of_type_ArrayOfByte == null) || (this.jdField_d_of_type_ArrayOfByte.length == 0) || (this.jdField_c_of_type_ArrayOfByte == null) || (this.jdField_c_of_type_ArrayOfByte.length == 0)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()))) {
          HwServlet.getConfig(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
        }
        this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), i, this.jdField_a_of_type_Bdzn.i, (int)this.r, this.jdField_b_of_type_ArrayOfByte, localbdwq, this.jdField_a_of_type_Bduk.jdField_a_of_type_ArrayOfByte, false);
        int j = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHwEngine().submitTransactionTask(this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction);
        if (QLog.isColorLevel()) {
          QLog.i("NearbyPeoplePhotoUploadProcessor", 2, "<BDH_LOG> Transaction submit RetCode:" + j + " T_ID:" + this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.getTransationId() + " UniSeq:" + this.jdField_a_of_type_Bdzn.jdField_a_of_type_Long + " MD5:" + this.jdField_c_of_type_JavaLangString + " uuid:" + this.jdField_l_of_type_JavaLangString + " Path:" + this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.filePath + " Cmd:" + i);
        }
        if (j != 0)
        {
          a(j, "SubmitError.", "", this.jdField_b_of_type_Bdsz);
          d();
        }
        return;
      }
      finally {}
      if (this.jdField_a_of_type_Bduk.b == 21) {
        i = 6;
      } else if (this.jdField_a_of_type_Bduk.b == 22) {
        i = 5;
      } else if (this.jdField_a_of_type_Bduk.b == 34) {
        i = 13;
      } else if (this.jdField_a_of_type_Bduk.b != 35) {
        if ((this.jdField_a_of_type_Bduk.b == 36) || (this.jdField_a_of_type_Bduk.b == 37) || (this.jdField_a_of_type_Bduk.b == 38))
        {
          i = 23;
        }
        else if ((this.jdField_a_of_type_Bduk.b == 39) || (this.jdField_a_of_type_Bduk.b == 40) || (this.jdField_a_of_type_Bduk.b == 41))
        {
          i = 22;
        }
        else if (this.jdField_a_of_type_Bduk.b == 48)
        {
          i = 24;
        }
        else if (this.jdField_a_of_type_Bduk.b == 23)
        {
          i = 59;
          Bdh_extinfo.CommFileExtReq localCommFileExtReq = new Bdh_extinfo.CommFileExtReq();
          localCommFileExtReq.uint32_action_type.set(0);
          localCommFileExtReq.bytes_uuid.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()));
          this.jdField_a_of_type_Bduk.jdField_a_of_type_ArrayOfByte = localCommFileExtReq.toByteArray();
        }
        else if ((this.jdField_a_of_type_Bduk.b == 50) || (this.jdField_a_of_type_Bduk.b == 51))
        {
          i = 35;
        }
        else if (this.jdField_a_of_type_Bduk.b == 56)
        {
          i = 39;
        }
        else
        {
          i = -1;
        }
      }
    }
  }
  
  public void aN_()
  {
    super.aN_();
    d(1001);
    if (QLog.isColorLevel()) {
      QLog.i("NearbyPeoplePhotoUploadProcessor", 2, "NearbyPeoplePhotoUploadProcessor.start()");
    }
    if ((this.jdField_a_of_type_Bduk.b == 56) && (a())) {
      return;
    }
    if ((this.jdField_b_of_type_ArrayOfByte == null) && (!h()))
    {
      d();
      return;
    }
    g();
  }
  
  public int b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("NearbyPeoplePhotoUploadProcessor", 2, "NearbyPeoplePhotoUploadProcessor.resume()");
    }
    f();
    g();
    return 0;
  }
  
  public int c()
  {
    String str = this.jdField_a_of_type_Bdzn.i;
    if (TextUtils.isEmpty(str))
    {
      b(9302, a(new Exception("filePath null")));
      d();
      return -1;
    }
    File localFile = new File(str);
    if (!localFile.exists())
    {
      b(9042, a(new Exception("sendFile not exist " + str)));
      d();
      return -1;
    }
    if (!localFile.canRead())
    {
      b(9070, a(new Exception("sendFile not readable " + this.jdField_a_of_type_Bduk.jdField_c_of_type_JavaLangString)));
      d();
      return -1;
    }
    long l = localFile.length();
    this.jdField_a_of_type_Bduk.jdField_a_of_type_Long = l;
    this.q = l;
    if (l <= 0L)
    {
      b(9071, a(new Exception("file size 0 " + str)));
      d();
      return -1;
    }
    return super.c();
  }
  
  void d()
  {
    super.d();
    d(1005);
    if (QLog.isColorLevel()) {
      QLog.i("NearbyPeoplePhotoUploadProcessor", 2, "onError()---- errCode: " + this.jdField_j_of_type_Int + ", errDesc:" + this.jdField_j_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_Bdzn.jdField_a_of_type_Ayyt != null)
    {
      ayyu localayyu = new ayyu();
      localayyu.jdField_a_of_type_Int = -1;
      localayyu.b = this.jdField_j_of_type_Int;
      localayyu.jdField_a_of_type_JavaLangString = this.jdField_j_of_type_JavaLangString;
      this.jdField_a_of_type_Bdzn.jdField_a_of_type_Ayyt.b(localayyu);
    }
  }
  
  protected void d(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NearbyPeoplePhotoUploadProcessor", 2, paramString);
    }
  }
  
  void e()
  {
    super.e();
    d(1003);
    if (QLog.isColorLevel()) {
      QLog.i("NearbyPeoplePhotoUploadProcessor", 2, "onSuccess().");
    }
    if (this.jdField_a_of_type_Bdzn.jdField_a_of_type_Ayyt != null)
    {
      ayyu localayyu = new ayyu();
      localayyu.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_Bdzn.jdField_a_of_type_Ayyt.b(localayyu);
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHwEngine().cancelTransactionTask(this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction);
    }
  }
  
  public void onResp(bdwt parambdwt)
  {
    super.onResp(parambdwt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdwp
 * JD-Core Version:    0.7.0.1
 */