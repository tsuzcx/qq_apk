import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gallery.picocr.PicOcrManager.3;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.CommFileExtReq;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;
import mqq.manager.Manager;

public class atvq
  implements Manager
{
  private atvt jdField_a_of_type_Atvt;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected TransFileController a;
  protected TransProcessorHandler a;
  protected String a;
  private HashMap<String, atvx> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  boolean jdField_a_of_type_Boolean = false;
  
  public atvq(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new atvr(this, ThreadManager.getSubThreadLooper());
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController = paramQQAppInterface.getTransFileController();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
  }
  
  private void b(atvu paramatvu, atvt paramatvt)
  {
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramatvt.jdField_b_of_type_JavaLangString, (BitmapFactory.Options)localObject);
    int j = ((BitmapFactory.Options)localObject).outWidth;
    int k = ((BitmapFactory.Options)localObject).outHeight;
    paramatvu = new File(paramatvt.jdField_b_of_type_JavaLangString);
    long l = paramatvu.length();
    int i;
    if (l < 6750000L)
    {
      paramatvt.a = paramatvu.length();
      paramatvt.jdField_b_of_type_Int = ((BitmapFactory.Options)localObject).outWidth;
      paramatvt.jdField_c_of_type_Int = ((BitmapFactory.Options)localObject).outHeight;
      paramatvt.e = paramatvt.d;
      paramatvt.jdField_c_of_type_JavaLangString = paramatvt.jdField_b_of_type_JavaLangString;
      i = 0;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PicOcrManager", 2, "tryCompressIfNeeded:" + paramatvt.a() + ", oriLength:" + paramatvu.length() / 1024L + ", oriSize:[" + j + "*" + k + "]");
      }
      paramatvt = new HashMap();
      paramatvt.put("param_type", i + "");
      paramatvt.put("param_length", paramatvu.length() / 1024L + "");
      paramatvt.put("param_width", String.valueOf(j));
      paramatvt.put("param_height", String.valueOf(k));
      paramatvt.put("param_size", j * k + "");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "actPicOcrCompressType", true, 0L, 0L, paramatvt, "");
      return;
      if (l > 13500000L) {}
      for (i = 2;; i = 1)
      {
        ((BitmapFactory.Options)localObject).inSampleSize = i;
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
        localObject = atvy.a(paramatvt.jdField_b_of_type_JavaLangString, (BitmapFactory.Options)localObject, 1, 4);
        if (localObject == null) {
          break label671;
        }
        int[] arrayOfInt = new int[2];
        paramatvt.jdField_c_of_type_JavaLangString = atvy.a((Bitmap)localObject, paramatvt.jdField_b_of_type_JavaLangString, arrayOfInt);
        if (!FileUtils.fileExistsAndNotEmpty(paramatvt.jdField_c_of_type_JavaLangString)) {
          break label671;
        }
        paramatvt.jdField_b_of_type_Int = arrayOfInt[0];
        paramatvt.jdField_c_of_type_Int = arrayOfInt[1];
        paramatvt.a = new File(paramatvt.jdField_c_of_type_JavaLangString).length();
        paramatvt.e = atvy.a(paramatvt.jdField_c_of_type_JavaLangString);
        localObject = new HashMap();
        ((HashMap)localObject).put("param_length", paramatvu.length() / 1024L + "");
        ((HashMap)localObject).put("param_width", String.valueOf(j));
        ((HashMap)localObject).put("param_height", String.valueOf(k));
        ((HashMap)localObject).put("param_size", j * k + "");
        ((HashMap)localObject).put("param_complength", paramatvt.a / 1024L + "");
        ((HashMap)localObject).put("param_compwidth", String.valueOf(paramatvt.jdField_b_of_type_Int));
        ((HashMap)localObject).put("param_compheight", String.valueOf(paramatvt.jdField_c_of_type_Int));
        ((HashMap)localObject).put("param_compsize", paramatvt.jdField_b_of_type_Int * paramatvt.jdField_c_of_type_Int + "");
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "actPicOcrCompressInfo", true, 0L, 0L, (HashMap)localObject, "");
        i = 1;
        break;
      }
      label671:
      i = 0;
    }
  }
  
  public atvx a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))) {
      return (atvx)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    }
    return null;
  }
  
  public void a(atvt paramatvt, atvu paramatvu)
  {
    ThreadManager.excute(new PicOcrManager.3(this, paramatvt, paramatvu), 64, null, true);
  }
  
  public void a(atvu paramatvu, atvt paramatvt)
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PicOcrManager", 2, "uploadOcrPic NetWork exception!");
      }
      paramatvu.onUpdate(100, false, new atvx());
    }
    do
    {
      return;
      this.jdField_a_of_type_Atvt = paramatvt;
      if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler != null) && (this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.addFilter(new Class[] { BDHCommonUploadProcessor.class });
        this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.addHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
        this.jdField_a_of_type_Boolean = true;
      }
      paramatvt.jdField_b_of_type_Long = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.i("PicOcrManager", 2, "uploadOcrPic:" + paramatvt.a());
      }
      atvs localatvs = new atvs(this, paramatvu, paramatvt);
      paramatvu = new TransferRequest();
      paramatvu.mFileType = 24;
      paramatvu.mCommandId = 76;
      paramatvu.mRichTag = "picorcupload";
      paramatvu.mUpCallBack = localatvs;
      paramatvu.mLocalPath = paramatvt.jdField_c_of_type_JavaLangString;
      paramatvu.mSelfUin = this.jdField_a_of_type_JavaLangString;
      paramatvu.mPeerUin = this.jdField_a_of_type_JavaLangString;
      paramatvu.mUniseq = paramatvt.jdField_b_of_type_Long;
      paramatvu.mIsUp = true;
      paramatvt = new Bdh_extinfo.CommFileExtReq();
      paramatvt.uint32_action_type.set(0);
      paramatvt.bytes_uuid.set(ByteStringMicro.copyFromUtf8(UUID.randomUUID().toString()));
      paramatvu.mExtentionInfo = paramatvt.toByteArray();
    } while (this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController == null);
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.transferAsync(paramatvu);
  }
  
  public void a(String paramString, atvx paramatvx)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    String str;
    if (this.jdField_a_of_type_JavaUtilHashMap.size() >= 10)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        str = (String)localIterator.next();
      } while (str.equals(paramString));
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilHashMap.remove(str);
      if ((TextUtils.isEmpty(paramString)) || (paramatvx == null)) {
        break;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramatvx);
      return;
      str = "";
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.removeHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atvq
 * JD-Core Version:    0.7.0.1
 */