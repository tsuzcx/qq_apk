import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.network.pb.qqstory_bhd_upload_pic.ReqStoryPic;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.StoryUploadProcessor.2;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.io.File;
import java.util.HashMap;

public class bato
  extends banb
{
  public static String a;
  private long jdField_a_of_type_Long;
  private Transaction jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction;
  private long b;
  public String b;
  private byte[] d;
  private byte[] e;
  public String n;
  public String o;
  private String p = "Q.qqstory.publish.upload";
  
  static
  {
    jdField_a_of_type_JavaLangString = "Q.qqstory.publish.upload.StoryUploadProcessor";
  }
  
  public bato(bamu parambamu, baub parambaub)
  {
    super(parambamu, parambaub);
    this.jdField_a_of_type_Baoj.jdField_a_of_type_Bamw = this;
    this.jdField_a_of_type_Baoj.jdField_a_of_type_ArrayOfByte = parambaub.jdField_a_of_type_ArrayOfByte;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    jdField_a_of_type_JavaLangString = this.p + ".StoryUploadProcessor";
  }
  
  public static int a(int paramInt)
  {
    return 95000000 + paramInt;
  }
  
  private int a(String paramString)
  {
    String str = xmx.a(paramString);
    long l1 = 0L;
    try
    {
      l2 = Long.valueOf(str.substring(0, str.indexOf("_"))).longValue();
      l1 = l2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        wsv.c(jdField_a_of_type_JavaLangString, "exception", localException);
      }
      if (l1 <= 0L) {
        break label173;
      }
      long l2 = (System.currentTimeMillis() - l1) / 24L / 60L / 60L / 1000L;
      l1 = l2;
      if (l2 <= 30L) {
        break label166;
      }
      l1 = 30L;
      return (int)(l1 + 999000L);
    }
    l2 = xmx.b(ugx.e);
    wsv.e(jdField_a_of_type_JavaLangString, "orig file create time:%d, flag file create time:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
    if ((l2 == 0L) || ((l1 > 0L) && (l2 > l1)))
    {
      wsv.e(jdField_a_of_type_JavaLangString, "your file delete by software %s", new Object[] { paramString });
      return 940017;
    }
    label166:
    label173:
    return 9071;
  }
  
  private String c()
  {
    return String.format("sdcard free size:%d, upload dir exist:%b ", new Object[] { Long.valueOf(xmx.a()), Boolean.valueOf(bdcs.a(ugx.e)) });
  }
  
  public static void g()
  {
    Bosses.get().postLightWeightJob(new StoryUploadProcessor.2(), 0);
  }
  
  protected long a(long paramLong)
  {
    paramLong = this.q - paramLong;
    if (!this.jdField_d_of_type_Boolean) {}
    for (paramLong = Math.min(paramLong, this.jdField_a_of_type_Bica.a(BaseApplication.getContext(), this.q, this.s, -1));; paramLong = Math.min(paramLong, 14600L)) {
      return Math.min(paramLong, 131072L);
    }
  }
  
  protected void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    if (paramLong1 != 0L) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.countFlow(true, 1, this.jdField_a_of_type_Baoj.jdField_b_of_type_Int, this.jdField_a_of_type_Baub.jdField_a_of_type_Int, paramLong1);
    }
    if (paramLong2 != 0L) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.countFlow(true, 1, this.jdField_a_of_type_Baoj.jdField_b_of_type_Int, this.jdField_a_of_type_Baub.jdField_a_of_type_Int, paramLong2);
    }
    if (paramLong3 != 0L) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.countFlow(true, 0, this.jdField_a_of_type_Baoj.jdField_b_of_type_Int, this.jdField_a_of_type_Baub.jdField_a_of_type_Int, paramLong3);
    }
    if (paramLong4 != 0L) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.countFlow(true, 0, this.jdField_a_of_type_Baoj.jdField_b_of_type_Int, this.jdField_a_of_type_Baub.jdField_a_of_type_Int, paramLong4);
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if ((!paramBoolean) && (basb.b(this.jdField_j_of_type_Int))) {
      break label14;
    }
    label14:
    while ((this.h) || ((paramBoolean) && ((this.m & 0x2) > 0)) || ((!paramBoolean) && ((this.m & 0x1) > 0))) {
      return;
    }
    int j = this.m;
    int i;
    label59:
    String str;
    label82:
    long l;
    if (paramBoolean)
    {
      i = 2;
      this.m = (i | j);
      if (this.jdField_a_of_type_Baoj.jdField_b_of_type_Int != 196610) {
        break label226;
      }
      str = "actStoryPicUpload";
      this.jdField_l_of_type_Long = System.currentTimeMillis();
      l = (System.nanoTime() - this.k) / 1000000L;
      this.jdField_a_of_type_JavaUtilHashMap.put("param_sessionKey", "null");
      if (!paramBoolean) {
        break label299;
      }
      azmz.a(BaseApplication.getContext()).a(null, str, true, l, this.q, this.jdField_a_of_type_JavaUtilHashMap, "");
      if (this.jdField_a_of_type_Baoj.jdField_b_of_type_Int != 196609) {
        break label247;
      }
      wta.b("publish_story", "publish_video", 0, 0, new String[] { String.valueOf(this.q), String.valueOf(this.jdField_l_of_type_Long - this.jdField_b_of_type_Long), wta.a(BaseApplication.getContext()), this.o });
    }
    for (;;)
    {
      l();
      return;
      i = 1;
      break label59;
      label226:
      if (this.jdField_a_of_type_Baoj.jdField_b_of_type_Int != 196609) {
        break;
      }
      str = "actStoryVideoUpload";
      break label82;
      label247:
      wta.b("publish_story", "publish_thumbnail", 0, 0, new String[] { String.valueOf(this.q), String.valueOf(this.jdField_l_of_type_Long - this.jdField_b_of_type_Long), wta.a(BaseApplication.getContext()) });
      continue;
      label299:
      if (this.jdField_j_of_type_Int != -9527) {
        this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.jdField_j_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.jdField_j_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_picSize", String.valueOf(this.q));
      azmz.a(BaseApplication.getContext()).a(null, str, false, l, this.q, this.jdField_a_of_type_JavaUtilHashMap, "");
      if (this.jdField_a_of_type_Baoj.jdField_b_of_type_Int == 196609) {
        wta.b("publish_story", "publish_video", 0, a(this.jdField_j_of_type_Int), new String[] { String.valueOf(this.q), String.valueOf(this.jdField_l_of_type_Long - this.jdField_b_of_type_Long), wta.a(BaseApplication.getContext()), this.jdField_j_of_type_JavaLangString });
      } else {
        wta.b("publish_story", "publish_thumbnail", 0, a(this.jdField_j_of_type_Int), new String[] { String.valueOf(this.q), String.valueOf(this.jdField_l_of_type_Long - this.jdField_b_of_type_Long), wta.a(BaseApplication.getContext()), this.jdField_j_of_type_JavaLangString });
      }
    }
  }
  
  byte[] a(int paramInt1, int paramInt2)
  {
    return super.a(paramInt1, paramInt2);
  }
  
  public void aQ_()
  {
    wsv.d(jdField_a_of_type_JavaLangString, "send file %s", new Object[] { this.jdField_a_of_type_Baub.i });
    this.jdField_b_of_type_Bamy.a();
    batp localbatp = new batp(this, SystemClock.uptimeMillis());
    int i = -1;
    if (this.jdField_a_of_type_Baoj.jdField_b_of_type_Int == 196610)
    {
      i = 34;
      qqstory_bhd_upload_pic.ReqStoryPic localReqStoryPic = new qqstory_bhd_upload_pic.ReqStoryPic();
      localReqStoryPic.platform.set(2);
      localReqStoryPic.tojpg.set(0);
      localReqStoryPic.version.set(ByteStringMicro.copyFromUtf8("8.3.3"));
      this.jdField_a_of_type_Baoj.jdField_a_of_type_ArrayOfByte = localReqStoryPic.toByteArray();
    }
    for (;;)
    {
      this.jdField_a_of_type_Baoj.jdField_c_of_type_Int = i;
      try
      {
        if (SessionInfo.getInstance(this.jdField_a_of_type_Baub.jdField_b_of_type_JavaLangString).getHttpconn_sig_session() != null)
        {
          j = SessionInfo.getInstance(this.jdField_a_of_type_Baub.jdField_b_of_type_JavaLangString).getHttpconn_sig_session().length;
          this.e = new byte[j];
          System.arraycopy(SessionInfo.getInstance(this.jdField_a_of_type_Baub.jdField_b_of_type_JavaLangString).getHttpconn_sig_session(), 0, this.e, 0, j);
        }
        if (SessionInfo.getInstance(this.jdField_a_of_type_Baub.jdField_b_of_type_JavaLangString).getSessionKey() != null)
        {
          j = SessionInfo.getInstance(this.jdField_a_of_type_Baub.jdField_b_of_type_JavaLangString).getSessionKey().length;
          this.jdField_d_of_type_ArrayOfByte = new byte[j];
          System.arraycopy(SessionInfo.getInstance(this.jdField_a_of_type_Baub.jdField_b_of_type_JavaLangString).getSessionKey(), 0, this.jdField_d_of_type_ArrayOfByte, 0, j);
        }
        if ((this.e == null) || (this.e.length == 0) || (this.jdField_d_of_type_ArrayOfByte == null) || (this.jdField_d_of_type_ArrayOfByte.length == 0)) {
          HwServlet.getConfig(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_Baub.jdField_b_of_type_JavaLangString);
        }
        this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), i, this.jdField_a_of_type_Baub.i, (int)this.r, this.jdField_a_of_type_ArrayOfByte, localbatp, this.jdField_a_of_type_Baoj.jdField_a_of_type_ArrayOfByte, false);
        this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.setVideoSegmentMode(true);
        int j = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHwEngine().submitTransactionTask(this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction);
        wsv.c(jdField_a_of_type_JavaLangString, "Transaction submit RetCode:" + j + " T_ID:" + this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.getTransationId() + " UniSeq:" + this.jdField_a_of_type_Baub.jdField_a_of_type_Long + " MD5:" + this.jdField_c_of_type_JavaLangString + " uuid:" + this.jdField_l_of_type_JavaLangString + " Path:" + this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.filePath + " Cmd:" + i);
        if (j != 0)
        {
          a(j, "SubmitError.", "", this.jdField_b_of_type_Bamy);
          d();
        }
        return;
      }
      finally {}
      if (this.jdField_a_of_type_Baoj.jdField_b_of_type_Int == 196609) {
        i = 37;
      } else if (this.jdField_a_of_type_Baoj.jdField_b_of_type_Int == 327681) {
        i = 57;
      }
    }
  }
  
  public void aS_()
  {
    super.aS_();
    wsv.d(jdField_a_of_type_JavaLangString, "start upload %s", new Object[] { this.jdField_a_of_type_Baub.i });
    if ((this.jdField_a_of_type_ArrayOfByte == null) && (!h()))
    {
      b(940006, "make md5 fail");
      d();
      return;
    }
    if (!xne.a(QQStoryContext.a().a()))
    {
      b(880001, "no network");
      d();
      return;
    }
    aQ_();
  }
  
  public int b()
  {
    f();
    return 0;
  }
  
  public int c()
  {
    String str = this.jdField_a_of_type_Baub.i;
    if (TextUtils.isEmpty(str))
    {
      b(9302, a(new Exception("filePath null")));
      d();
      return -1;
    }
    File localFile = new File(str);
    if (!localFile.exists())
    {
      b(a(str), c() + "sendFile not exist " + str);
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
    this.q = l;
    wsv.a(jdField_a_of_type_JavaLangString, "upload file size %d, file %s", Long.valueOf(this.q), str);
    if (l <= 0L)
    {
      b(a(str), c() + "sendFile size empty " + str);
      d();
      return -1;
    }
    return super.c();
  }
  
  void d()
  {
    super.d();
    d(1005);
    wsv.d(jdField_a_of_type_JavaLangString, "error errCode:%d,errDesc:%s, %s", new Object[] { Integer.valueOf(this.jdField_j_of_type_Int), this.jdField_j_of_type_JavaLangString, this.jdField_a_of_type_Baub.i });
    if (this.jdField_a_of_type_Baub.jdField_a_of_type_Awfy != null)
    {
      awfz localawfz = new awfz();
      localawfz.jdField_a_of_type_Int = -1;
      localawfz.jdField_b_of_type_Int = a(this.jdField_j_of_type_Int);
      localawfz.jdField_a_of_type_JavaLangString = this.jdField_j_of_type_JavaLangString;
      this.jdField_a_of_type_Baub.jdField_a_of_type_Awfy.b(localawfz);
    }
  }
  
  void e()
  {
    super.e();
    d(1003);
    wsv.d(jdField_a_of_type_JavaLangString, "success path:%s", new Object[] { this.jdField_a_of_type_Baub.i });
    awfz localawfz;
    if (this.jdField_a_of_type_Baub.jdField_a_of_type_Awfy != null)
    {
      localawfz = new awfz();
      localawfz.jdField_a_of_type_Int = 0;
      if (this.jdField_a_of_type_Baoj.jdField_b_of_type_Int != 196610) {
        break label91;
      }
    }
    for (localawfz.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;; localawfz.jdField_b_of_type_JavaLangString = this.o)
    {
      this.jdField_a_of_type_Baub.jdField_a_of_type_Awfy.b(localawfz);
      return;
      label91:
      localawfz.jdField_c_of_type_JavaLangString = this.n;
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHwEngine().cancelTransactionTask(this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction);
    }
  }
  
  public void onResp(baqw parambaqw)
  {
    super.onResp(parambaqw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bato
 * JD-Core Version:    0.7.0.1
 */