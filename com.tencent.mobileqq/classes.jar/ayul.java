import android.os.SystemClock;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

public class ayul
  extends aype
{
  akav jdField_a_of_type_Akav = new ayun(this);
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface;
  private Transaction jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction;
  private String jdField_a_of_type_JavaLangString = "";
  private byte[] d;
  private byte[] e;
  
  public ayul(ayox paramayox, aywa paramaywa)
  {
    super(paramayox, paramaywa);
    this.jdField_a_of_type_Ayqm.jdField_a_of_type_Ayoz = this;
    this.jdField_a_of_type_Ayqm.jdField_a_of_type_ArrayOfByte = paramaywa.jdField_a_of_type_ArrayOfByte;
  }
  
  private void a(MessageForScribble paramMessageForScribble)
  {
    if (paramMessageForScribble != null)
    {
      paramMessageForScribble.prewrite();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForScribble.frienduin, paramMessageForScribble.istroop, paramMessageForScribble.uniseq, paramMessageForScribble.msgData);
    }
  }
  
  private void g()
  {
    try
    {
      if (SessionInfo.getInstance(this.jdField_a_of_type_Aywa.b).getHttpconn_sig_session() != null)
      {
        int i = SessionInfo.getInstance(this.jdField_a_of_type_Aywa.b).getHttpconn_sig_session().length;
        this.jdField_d_of_type_ArrayOfByte = new byte[i];
        System.arraycopy(SessionInfo.getInstance(this.jdField_a_of_type_Aywa.b).getHttpconn_sig_session(), 0, this.jdField_d_of_type_ArrayOfByte, 0, i);
      }
      if (this.jdField_d_of_type_ArrayOfByte == null) {
        HwServlet.getConfig(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_Aywa.b);
      }
      return;
    }
    finally {}
  }
  
  private void h()
  {
    if (!f())
    {
      d("<BDH_LOG> sendMsg() do not send message, due to mIsCancel=true || mIsPause=true, current channel = " + this.w);
      return;
    }
    MessageForScribble localMessageForScribble = (MessageForScribble)this.jdField_a_of_type_Aywa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    if (localMessageForScribble != null)
    {
      localMessageForScribble.combineFileUrl = this.jdField_a_of_type_JavaLangString;
      if (QLog.isColorLevel())
      {
        QLog.d("ScribblePicUploadProcessor", 2, "mPicUrl: " + this.jdField_a_of_type_JavaLangString);
        QLog.d("ScribblePicUploadProcessor", 2, "TestPicSend finish upload,currentTime = " + System.currentTimeMillis() + ",processor = " + this);
      }
      this.c.a();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localMessageForScribble, this.jdField_a_of_type_Akav);
      QLog.i("SCRIBBLEMSG", 2, "!!!sendMessage uniseq:" + localMessageForScribble.uniseq);
      return;
    }
    a(-1, "MessageForScribble IS NULL", "", this.b);
    d();
  }
  
  protected long a(long paramLong)
  {
    paramLong = this.q - paramLong;
    if (!this.jdField_d_of_type_Boolean) {}
    for (paramLong = Math.min(paramLong, this.jdField_a_of_type_Bgam.a(BaseApplication.getContext(), this.q, this.s, -1));; paramLong = Math.min(paramLong, 14600L)) {
      return Math.min(paramLong, 131072L);
    }
  }
  
  protected void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    if (paramLong1 != 0L) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.countFlow(true, 1, this.jdField_a_of_type_Ayqm.b, this.jdField_a_of_type_Aywa.jdField_a_of_type_Int, paramLong1);
    }
    if (paramLong2 != 0L) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.countFlow(true, 1, this.jdField_a_of_type_Ayqm.b, this.jdField_a_of_type_Aywa.jdField_a_of_type_Int, paramLong2);
    }
    if (paramLong3 != 0L) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.countFlow(true, 0, this.jdField_a_of_type_Ayqm.b, this.jdField_a_of_type_Aywa.jdField_a_of_type_Int, paramLong3);
    }
    if (paramLong4 != 0L) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.countFlow(true, 0, this.jdField_a_of_type_Ayqm.b, this.jdField_a_of_type_Aywa.jdField_a_of_type_Int, paramLong4);
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if ((!paramBoolean) && (ayua.b(this.jdField_j_of_type_Int))) {}
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
      l = (System.nanoTime() - this.k) / 1000000L;
      HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
      if (this.jdField_d_of_type_ArrayOfByte != null) {
        break label156;
      }
      str = "null";
      label105:
      localHashMap.put("param_sessionKey", str);
      if (!paramBoolean) {
        break label168;
      }
      axrl.a(BaseApplication.getContext()).a(null, "scribble_upload", true, l, this.q, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
    for (;;)
    {
      l();
      return;
      i = 1;
      break;
      label156:
      str = bbmj.a(this.jdField_d_of_type_ArrayOfByte);
      break label105;
      label168:
      if (this.jdField_j_of_type_Int != -9527) {
        this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.jdField_j_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.jdField_j_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_picSize", String.valueOf(this.q));
      axrl.a(BaseApplication.getContext()).a(null, "scribble_upload", false, l, this.q, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
  }
  
  byte[] a(int paramInt1, int paramInt2)
  {
    return super.a(paramInt1, paramInt2);
  }
  
  public void aP_()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ScribblePicUploadProcessor", 2, "NearbyPeoplePhotoUploadProcessor.sendFile()");
    }
    this.b.a();
    Object localObject = new ayum(this, SystemClock.uptimeMillis());
    this.jdField_a_of_type_Ayqm.jdField_c_of_type_Int = 41;
    this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_Ayqm.jdField_c_of_type_Int, this.jdField_a_of_type_Aywa.i, (int)this.r, this.jdField_d_of_type_ArrayOfByte, this.jdField_a_of_type_ArrayOfByte, (ITransactionCallback)localObject, this.jdField_a_of_type_Ayqm.jdField_a_of_type_ArrayOfByte);
    int i = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHwEngine().submitTransactionTask(this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction);
    localObject = HexUtil.bytes2HexStr(this.jdField_a_of_type_ArrayOfByte);
    String str = HexUtil.bytes2HexStr(this.e);
    if (QLog.isColorLevel()) {
      QLog.i("ScribblePicUploadProcessor", 2, "<BDH_LOG> Transaction submit RetCode:" + i + " T_ID:" + this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.getTransationId() + " UniSeq:" + this.jdField_a_of_type_Aywa.jdField_a_of_type_Long + " MD51:" + (String)localObject + " MD52:" + str + " uuid:" + this.jdField_l_of_type_JavaLangString + " Path:" + this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.filePath + " Cmd:" + this.jdField_a_of_type_Ayqm.jdField_c_of_type_Int);
    }
    if (i != 0)
    {
      a(i, "SubmitError.", "", this.b);
      d();
    }
  }
  
  public void aR_()
  {
    this.jdField_a_of_type_JavaLangString = "";
    super.aR_();
    if (QLog.isColorLevel()) {
      QLog.i("ScribblePicUploadProcessor", 2, "ScriblePicUploadProcessor.start()");
    }
    g();
    MessageForScribble localMessageForScribble = (MessageForScribble)this.jdField_a_of_type_Aywa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    if (this.jdField_a_of_type_ArrayOfByte == null)
    {
      this.e = HexUtil.hexStr2Bytes(localMessageForScribble.combineFileMd5);
      if (!j())
      {
        d();
        return;
      }
      localMessageForScribble.combineFileMd5 = HexUtil.bytes2HexStr(this.jdField_a_of_type_ArrayOfByte);
    }
    if (this.jdField_d_of_type_ArrayOfByte != null)
    {
      aP_();
      return;
    }
    QLog.e("ScribblePicUploadProcessor", 2, "ScribblePicUploadProcessor get null BDHsession key.");
  }
  
  public int b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ScribblePicUploadProcessor", 2, "ScribblePicUploadProcessor.resume()");
    }
    f();
    aP_();
    return 0;
  }
  
  public int c()
  {
    String str = this.jdField_a_of_type_Aywa.i;
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
      b(9070, a(new Exception("sendFile not readable " + this.jdField_a_of_type_Ayqm.jdField_c_of_type_JavaLangString)));
      d();
      return -1;
    }
    long l = localFile.length();
    this.jdField_a_of_type_Ayqm.jdField_a_of_type_Long = l;
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
    Object localObject = (MessageForScribble)this.jdField_a_of_type_Aywa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    if (localObject != null) {
      ((MessageForScribble)localObject).fileUploadStatus = 2;
    }
    a((MessageForScribble)localObject);
    QLog.e("ScribblePicUploadProcessor", 2, "onError()---- errCode: " + this.jdField_j_of_type_Int + ", errDesc:" + this.jdField_j_of_type_JavaLangString);
    if (this.jdField_a_of_type_Aywa.jdField_a_of_type_Auoo != null)
    {
      localObject = new auop();
      ((auop)localObject).jdField_a_of_type_Int = -1;
      ((auop)localObject).b = this.jdField_j_of_type_Int;
      ((auop)localObject).jdField_a_of_type_JavaLangString = this.jdField_j_of_type_JavaLangString;
      this.jdField_a_of_type_Aywa.jdField_a_of_type_Auoo.b((auop)localObject);
    }
  }
  
  protected void d(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ScribblePicUploadProcessor", 2, paramString);
    }
  }
  
  void e()
  {
    super.e();
    d(1003);
    Object localObject = (MessageForScribble)this.jdField_a_of_type_Aywa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    if (localObject != null) {
      ((MessageForScribble)localObject).fileUploadStatus = 1;
    }
    a((MessageForScribble)localObject);
    if (QLog.isColorLevel()) {
      QLog.i("ScribblePicUploadProcessor", 2, "onSuccess().");
    }
    if (this.jdField_a_of_type_Aywa.jdField_a_of_type_Auoo != null)
    {
      localObject = new auop();
      ((auop)localObject).jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_Aywa.jdField_a_of_type_Auoo.b((auop)localObject);
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHwEngine().cancelTransactionTask(this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayul
 * JD-Core Version:    0.7.0.1
 */