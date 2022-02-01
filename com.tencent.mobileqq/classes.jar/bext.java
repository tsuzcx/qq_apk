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

public class bext
  extends beru
{
  public static String a;
  private long jdField_a_of_type_Long;
  private Transaction jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private long b;
  public String b;
  private byte[] e;
  public String n;
  public String o;
  private String p = "Q.qqstory.publish.upload";
  
  static
  {
    jdField_a_of_type_JavaLangString = "Q.qqstory.publish.upload.StoryUploadProcessor";
  }
  
  public bext(bern parambern, beyg parambeyg)
  {
    super(parambern, parambeyg);
    this.jdField_a_of_type_Bete.jdField_a_of_type_Berp = this;
    this.jdField_a_of_type_Bete.jdField_a_of_type_ArrayOfByte = parambeyg.jdField_a_of_type_ArrayOfByte;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    jdField_a_of_type_JavaLangString = this.p + ".StoryUploadProcessor";
  }
  
  public static int a(int paramInt)
  {
    return 95000000 + paramInt;
  }
  
  private int a(String paramString)
  {
    String str = zom.a(paramString);
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
        yuk.c(jdField_a_of_type_JavaLangString, "exception", localException);
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
    l2 = zom.b(win.e);
    yuk.e(jdField_a_of_type_JavaLangString, "orig file create time:%d, flag file create time:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
    if ((l2 == 0L) || ((l1 > 0L) && (l2 > l1)))
    {
      yuk.e(jdField_a_of_type_JavaLangString, "your file delete by software %s", new Object[] { paramString });
      return 940017;
    }
    label166:
    label173:
    return 9071;
  }
  
  private String a()
  {
    return String.format("sdcard free size:%d, upload dir exist:%b ", new Object[] { Long.valueOf(zom.a()), Boolean.valueOf(bhmi.a(win.e)) });
  }
  
  public static void g()
  {
    Bosses.get().postLightWeightJob(new StoryUploadProcessor.2(), 0);
  }
  
  protected long a(long paramLong)
  {
    paramLong = this.q - paramLong;
    if (!this.d) {}
    for (paramLong = Math.min(paramLong, this.jdField_a_of_type_Bluw.a(BaseApplication.getContext(), this.q, this.s, -1));; paramLong = Math.min(paramLong, 14600L)) {
      return Math.min(paramLong, 131072L);
    }
  }
  
  protected void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    if (paramLong1 != 0L) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.countFlow(true, 1, this.jdField_a_of_type_Bete.jdField_b_of_type_Int, this.jdField_a_of_type_Beyg.jdField_a_of_type_Int, paramLong1);
    }
    if (paramLong2 != 0L) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.countFlow(true, 1, this.jdField_a_of_type_Bete.jdField_b_of_type_Int, this.jdField_a_of_type_Beyg.jdField_a_of_type_Int, paramLong2);
    }
    if (paramLong3 != 0L) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.countFlow(true, 0, this.jdField_a_of_type_Bete.jdField_b_of_type_Int, this.jdField_a_of_type_Beyg.jdField_a_of_type_Int, paramLong3);
    }
    if (paramLong4 != 0L) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.countFlow(true, 0, this.jdField_a_of_type_Bete.jdField_b_of_type_Int, this.jdField_a_of_type_Beyg.jdField_a_of_type_Int, paramLong4);
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if ((!paramBoolean) && (bewk.a(this.jdField_k_of_type_Int))) {
      break label14;
    }
    label14:
    while ((this.jdField_j_of_type_Boolean) || ((paramBoolean) && ((this.jdField_n_of_type_Int & 0x2) > 0)) || ((!paramBoolean) && ((this.jdField_n_of_type_Int & 0x1) > 0))) {
      return;
    }
    int j = this.jdField_n_of_type_Int;
    int i;
    label59:
    String str;
    label82:
    long l;
    if (paramBoolean)
    {
      i = 2;
      this.jdField_n_of_type_Int = (i | j);
      if (this.jdField_a_of_type_Bete.jdField_b_of_type_Int != 196610) {
        break label225;
      }
      str = "actStoryPicUpload";
      this.jdField_l_of_type_Long = System.currentTimeMillis();
      l = (System.nanoTime() - this.jdField_k_of_type_Long) / 1000000L;
      this.jdField_a_of_type_JavaUtilHashMap.put("param_sessionKey", "null");
      if (!paramBoolean) {
        break label298;
      }
      bdmc.a(BaseApplication.getContext()).a(null, str, true, l, this.q, this.jdField_a_of_type_JavaUtilHashMap, "");
      if (this.jdField_a_of_type_Bete.jdField_b_of_type_Int != 196609) {
        break label246;
      }
      yup.b("publish_story", "publish_video", 0, 0, new String[] { String.valueOf(this.q), String.valueOf(this.jdField_l_of_type_Long - this.jdField_b_of_type_Long), yup.a(BaseApplication.getContext()), this.o });
    }
    for (;;)
    {
      m();
      return;
      i = 1;
      break label59;
      label225:
      if (this.jdField_a_of_type_Bete.jdField_b_of_type_Int != 196609) {
        break;
      }
      str = "actStoryVideoUpload";
      break label82;
      label246:
      yup.b("publish_story", "publish_thumbnail", 0, 0, new String[] { String.valueOf(this.q), String.valueOf(this.jdField_l_of_type_Long - this.jdField_b_of_type_Long), yup.a(BaseApplication.getContext()) });
      continue;
      label298:
      if (this.jdField_k_of_type_Int != -9527) {
        this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.jdField_k_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.jdField_j_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_picSize", String.valueOf(this.q));
      bdmc.a(BaseApplication.getContext()).a(null, str, false, l, this.q, this.jdField_a_of_type_JavaUtilHashMap, "");
      if (this.jdField_a_of_type_Bete.jdField_b_of_type_Int == 196609) {
        yup.b("publish_story", "publish_video", 0, a(this.jdField_k_of_type_Int), new String[] { String.valueOf(this.q), String.valueOf(this.jdField_l_of_type_Long - this.jdField_b_of_type_Long), yup.a(BaseApplication.getContext()), this.jdField_j_of_type_JavaLangString });
      } else {
        yup.b("publish_story", "publish_thumbnail", 0, a(this.jdField_k_of_type_Int), new String[] { String.valueOf(this.q), String.valueOf(this.jdField_l_of_type_Long - this.jdField_b_of_type_Long), yup.a(BaseApplication.getContext()), this.jdField_j_of_type_JavaLangString });
      }
    }
  }
  
  byte[] a(int paramInt1, int paramInt2)
  {
    return super.a(paramInt1, paramInt2);
  }
  
  public void aL_()
  {
    yuk.d(jdField_a_of_type_JavaLangString, "send file %s", new Object[] { this.jdField_a_of_type_Beyg.i });
    this.jdField_b_of_type_Berr.a();
    bexu localbexu = new bexu(this, SystemClock.uptimeMillis());
    int i = -1;
    if (this.jdField_a_of_type_Bete.jdField_b_of_type_Int == 196610)
    {
      i = 34;
      qqstory_bhd_upload_pic.ReqStoryPic localReqStoryPic = new qqstory_bhd_upload_pic.ReqStoryPic();
      localReqStoryPic.platform.set(2);
      localReqStoryPic.tojpg.set(0);
      localReqStoryPic.version.set(ByteStringMicro.copyFromUtf8("8.4.5"));
      this.jdField_a_of_type_Bete.jdField_a_of_type_ArrayOfByte = localReqStoryPic.toByteArray();
    }
    for (;;)
    {
      this.jdField_a_of_type_Bete.jdField_c_of_type_Int = i;
      try
      {
        if (SessionInfo.getInstance(this.jdField_a_of_type_Beyg.jdField_b_of_type_JavaLangString).getHttpconn_sig_session() != null)
        {
          j = SessionInfo.getInstance(this.jdField_a_of_type_Beyg.jdField_b_of_type_JavaLangString).getHttpconn_sig_session().length;
          this.e = new byte[j];
          System.arraycopy(SessionInfo.getInstance(this.jdField_a_of_type_Beyg.jdField_b_of_type_JavaLangString).getHttpconn_sig_session(), 0, this.e, 0, j);
        }
        if (SessionInfo.getInstance(this.jdField_a_of_type_Beyg.jdField_b_of_type_JavaLangString).getSessionKey() != null)
        {
          j = SessionInfo.getInstance(this.jdField_a_of_type_Beyg.jdField_b_of_type_JavaLangString).getSessionKey().length;
          this.jdField_a_of_type_ArrayOfByte = new byte[j];
          System.arraycopy(SessionInfo.getInstance(this.jdField_a_of_type_Beyg.jdField_b_of_type_JavaLangString).getSessionKey(), 0, this.jdField_a_of_type_ArrayOfByte, 0, j);
        }
        if ((this.e == null) || (this.e.length == 0) || (this.jdField_a_of_type_ArrayOfByte == null) || (this.jdField_a_of_type_ArrayOfByte.length == 0)) {
          HwServlet.getConfig(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_Beyg.jdField_b_of_type_JavaLangString);
        }
        this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), i, this.jdField_a_of_type_Beyg.i, (int)this.r, this.jdField_b_of_type_ArrayOfByte, localbexu, this.jdField_a_of_type_Bete.jdField_a_of_type_ArrayOfByte, false);
        this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.setVideoSegmentMode(true);
        int j = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHwEngine().submitTransactionTask(this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction);
        yuk.c(jdField_a_of_type_JavaLangString, "Transaction submit RetCode:" + j + " T_ID:" + this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.getTransationId() + " UniSeq:" + this.jdField_a_of_type_Beyg.jdField_a_of_type_Long + " MD5:" + this.jdField_c_of_type_JavaLangString + " uuid:" + this.jdField_l_of_type_JavaLangString + " Path:" + this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.filePath + " Cmd:" + i);
        if (j != 0)
        {
          a(j, "SubmitError.", "", this.jdField_b_of_type_Berr);
          d();
        }
        return;
      }
      finally {}
      if (this.jdField_a_of_type_Bete.jdField_b_of_type_Int == 196609) {
        i = 37;
      } else if (this.jdField_a_of_type_Bete.jdField_b_of_type_Int == 327681) {
        i = 57;
      }
    }
  }
  
  public void aN_()
  {
    super.aN_();
    yuk.d(jdField_a_of_type_JavaLangString, "start upload %s", new Object[] { this.jdField_a_of_type_Beyg.i });
    if ((this.jdField_b_of_type_ArrayOfByte == null) && (!h()))
    {
      b(940006, "make md5 fail");
      d();
      return;
    }
    if (!zot.a(QQStoryContext.a().a()))
    {
      b(880001, "no network");
      d();
      return;
    }
    aL_();
  }
  
  public int b()
  {
    f();
    return 0;
  }
  
  public int c()
  {
    String str = this.jdField_a_of_type_Beyg.i;
    if (TextUtils.isEmpty(str))
    {
      b(9302, a(new Exception("filePath null")));
      d();
      return -1;
    }
    File localFile = new File(str);
    if (!localFile.exists())
    {
      b(a(str), a() + "sendFile not exist " + str);
      d();
      return -1;
    }
    if (!localFile.canRead())
    {
      b(9070, a(new Exception("sendFile not readable " + this.jdField_a_of_type_Bete.jdField_c_of_type_JavaLangString)));
      d();
      return -1;
    }
    long l = localFile.length();
    this.jdField_a_of_type_Bete.jdField_a_of_type_Long = l;
    this.q = l;
    yuk.a(jdField_a_of_type_JavaLangString, "upload file size %d, file %s", Long.valueOf(this.q), str);
    if (l <= 0L)
    {
      b(a(str), a() + "sendFile size empty " + str);
      d();
      return -1;
    }
    return super.c();
  }
  
  void d()
  {
    super.d();
    d(1005);
    yuk.d(jdField_a_of_type_JavaLangString, "error errCode:%d,errDesc:%s, %s", new Object[] { Integer.valueOf(this.jdField_k_of_type_Int), this.jdField_j_of_type_JavaLangString, this.jdField_a_of_type_Beyg.i });
    if (this.jdField_a_of_type_Beyg.jdField_a_of_type_Azrg != null)
    {
      azrh localazrh = new azrh();
      localazrh.jdField_a_of_type_Int = -1;
      localazrh.jdField_b_of_type_Int = a(this.jdField_k_of_type_Int);
      localazrh.jdField_a_of_type_JavaLangString = this.jdField_j_of_type_JavaLangString;
      this.jdField_a_of_type_Beyg.jdField_a_of_type_Azrg.b(localazrh);
    }
  }
  
  void e()
  {
    super.e();
    d(1003);
    yuk.d(jdField_a_of_type_JavaLangString, "success path:%s", new Object[] { this.jdField_a_of_type_Beyg.i });
    azrh localazrh;
    if (this.jdField_a_of_type_Beyg.jdField_a_of_type_Azrg != null)
    {
      localazrh = new azrh();
      localazrh.jdField_a_of_type_Int = 0;
      if (this.jdField_a_of_type_Bete.jdField_b_of_type_Int != 196610) {
        break label91;
      }
    }
    for (localazrh.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;; localazrh.jdField_b_of_type_JavaLangString = this.o)
    {
      this.jdField_a_of_type_Beyg.jdField_a_of_type_Azrg.b(localazrh);
      return;
      label91:
      localazrh.jdField_c_of_type_JavaLangString = this.jdField_n_of_type_JavaLangString;
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHwEngine().cancelTransactionTask(this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction);
    }
  }
  
  public void onResp(bevm parambevm)
  {
    super.onResp(parambevm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bext
 * JD-Core Version:    0.7.0.1
 */