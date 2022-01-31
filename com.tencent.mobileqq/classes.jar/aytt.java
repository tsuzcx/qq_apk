import android.os.SystemClock;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import tencent.im.qim.trans.QIMVideoUpload.QIMVideoUpload.ReqBody;

public class aytt
{
  public int a;
  private long jdField_a_of_type_Long;
  private aytv jdField_a_of_type_Aytv;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private Transaction jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction;
  private RandomAccessFile jdField_a_of_type_JavaIoRandomAccessFile;
  private String jdField_a_of_type_JavaLangString;
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public boolean a;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private volatile boolean jdField_b_of_type_Boolean;
  private String c;
  private String d;
  private String e;
  
  public aytt(AppInterface paramAppInterface, aytv paramaytv, String paramString, byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Aytv = paramaytv;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private void a(boolean paramBoolean)
  {
    long l = (System.nanoTime() - this.jdField_a_of_type_Long) / 1000000L;
    this.jdField_a_of_type_JavaUtilHashMap.put("param_uuid", this.d);
    this.jdField_a_of_type_JavaUtilHashMap.put("param_fileMd5", HexUtil.bytes2HexStr(this.jdField_a_of_type_ArrayOfByte));
    this.jdField_a_of_type_JavaUtilHashMap.put("param_BDH_Cache_Diff", String.valueOf(this.jdField_b_of_type_Boolean));
    if (paramBoolean) {
      axrn.a(BaseApplication.getContext()).a(null, "QIMWebVideoUploader", true, l, 0L, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
    while (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (this.jdField_a_of_type_JavaUtilHashMap.get(str) != null)
        {
          localStringBuilder.append("&");
          localStringBuilder.append(str);
          localStringBuilder.append("=");
          localStringBuilder.append((String)this.jdField_a_of_type_JavaUtilHashMap.get(str));
        }
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.jdField_b_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.e);
      axrn.a(BaseApplication.getContext()).a(null, "QIMWebVideoUploader", false, l, 0L, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction != null) {
      this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.cancelTransaction();
    }
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMWebVideoUploader", 2, "<BDH_LOG> doUpload " + this.jdField_a_of_type_Boolean);
    }
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    if (this.jdField_a_of_type_JavaIoRandomAccessFile == null) {
      try
      {
        this.jdField_a_of_type_JavaIoRandomAccessFile = new RandomAccessFile(this.jdField_a_of_type_JavaLangString, "r");
        if (this.jdField_a_of_type_JavaIoRandomAccessFile == null)
        {
          this.jdField_b_of_type_Int = 9303;
          this.e = "read video file error";
          this.jdField_a_of_type_Aytv.a(this.jdField_b_of_type_Int, this.e);
          a(false);
          return false;
        }
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        for (;;)
        {
          localFileNotFoundException.printStackTrace();
          this.jdField_a_of_type_JavaIoRandomAccessFile = null;
        }
      }
    }
    Object localObject1 = new QIMVideoUpload.ReqBody();
    ((QIMVideoUpload.ReqBody)localObject1).uint64_uin.set(Long.parseLong(this.jdField_b_of_type_JavaLangString));
    ((QIMVideoUpload.ReqBody)localObject1).uint64_service_type.set(this.jdField_a_of_type_Int);
    ((QIMVideoUpload.ReqBody)localObject1).uint64_data_type.set(2L);
    ((QIMVideoUpload.ReqBody)localObject1).bytes_md5.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_ArrayOfByte));
    Object localObject2 = ((QIMVideoUpload.ReqBody)localObject1).uint64_not_notify_story_flag;
    if (this.jdField_a_of_type_Boolean) {}
    for (long l = 0L;; l = 1L)
    {
      ((PBUInt64Field)localObject2).set(l);
      localObject1 = ((QIMVideoUpload.ReqBody)localObject1).toByteArray();
      if (QLog.isColorLevel()) {
        QLog.d("QIMWebVideoUploader", 2, "doUpload|mVideoFileMd5= " + HexUtil.bytes2HexStr(this.jdField_a_of_type_ArrayOfByte));
      }
      localObject2 = new aytu(this);
      this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(this.jdField_b_of_type_JavaLangString, 52, this.jdField_a_of_type_JavaLangString, 0, this.jdField_a_of_type_ArrayOfByte, (ITransactionCallback)localObject2, (byte[])localObject1, false);
      int i = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHwEngine().submitTransactionTask(this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction);
      if (QLog.isColorLevel()) {
        QLog.d("QIMWebVideoUploader", 2, "<BDH_LOG>sendFileByBDH Transaction submit RetCode:" + i + " T_ID:" + this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.getTransationId() + " MD5:" + HexUtil.bytes2HexStr(this.jdField_a_of_type_ArrayOfByte) + " Path:" + this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.filePath + " Cmd:" + 52);
      }
      if (i == 0) {
        break;
      }
      this.jdField_b_of_type_Int = i;
      this.e = "SubmitError";
      this.jdField_a_of_type_Aytv.a(this.jdField_b_of_type_Int, this.e);
      a(false);
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aytt
 * JD-Core Version:    0.7.0.1
 */