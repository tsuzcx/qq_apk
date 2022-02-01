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

public class avaq
  implements Manager
{
  private avat jdField_a_of_type_Avat;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected TransFileController a;
  protected TransProcessorHandler a;
  protected String a;
  private HashMap<String, avaw> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  boolean jdField_a_of_type_Boolean = false;
  
  public avaq(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new avar(this, ThreadManager.getSubThreadLooper());
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController = paramQQAppInterface.getTransFileController();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
  }
  
  private void b(avau paramavau, avat paramavat)
  {
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramavat.jdField_b_of_type_JavaLangString, (BitmapFactory.Options)localObject);
    int j = ((BitmapFactory.Options)localObject).outWidth;
    int k = ((BitmapFactory.Options)localObject).outHeight;
    paramavau = new File(paramavat.jdField_b_of_type_JavaLangString);
    long l = paramavau.length();
    int i;
    if (l < 6750000L)
    {
      paramavat.a = paramavau.length();
      paramavat.jdField_b_of_type_Int = ((BitmapFactory.Options)localObject).outWidth;
      paramavat.jdField_c_of_type_Int = ((BitmapFactory.Options)localObject).outHeight;
      paramavat.e = paramavat.d;
      paramavat.jdField_c_of_type_JavaLangString = paramavat.jdField_b_of_type_JavaLangString;
      i = 0;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PicOcrManager", 2, "tryCompressIfNeeded:" + paramavat.a() + ", oriLength:" + paramavau.length() / 1024L + ", oriSize:[" + j + "*" + k + "]");
      }
      paramavat = new HashMap();
      paramavat.put("param_type", i + "");
      paramavat.put("param_length", paramavau.length() / 1024L + "");
      paramavat.put("param_width", String.valueOf(j));
      paramavat.put("param_height", String.valueOf(k));
      paramavat.put("param_size", j * k + "");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "actPicOcrCompressType", true, 0L, 0L, paramavat, "");
      return;
      if (l > 13500000L) {}
      for (i = 2;; i = 1)
      {
        ((BitmapFactory.Options)localObject).inSampleSize = i;
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
        localObject = avax.a(paramavat.jdField_b_of_type_JavaLangString, (BitmapFactory.Options)localObject, 1, 4);
        if (localObject == null) {
          break label671;
        }
        int[] arrayOfInt = new int[2];
        paramavat.jdField_c_of_type_JavaLangString = avax.a((Bitmap)localObject, paramavat.jdField_b_of_type_JavaLangString, arrayOfInt);
        if (!FileUtils.fileExistsAndNotEmpty(paramavat.jdField_c_of_type_JavaLangString)) {
          break label671;
        }
        paramavat.jdField_b_of_type_Int = arrayOfInt[0];
        paramavat.jdField_c_of_type_Int = arrayOfInt[1];
        paramavat.a = new File(paramavat.jdField_c_of_type_JavaLangString).length();
        paramavat.e = avax.a(paramavat.jdField_c_of_type_JavaLangString);
        localObject = new HashMap();
        ((HashMap)localObject).put("param_length", paramavau.length() / 1024L + "");
        ((HashMap)localObject).put("param_width", String.valueOf(j));
        ((HashMap)localObject).put("param_height", String.valueOf(k));
        ((HashMap)localObject).put("param_size", j * k + "");
        ((HashMap)localObject).put("param_complength", paramavat.a / 1024L + "");
        ((HashMap)localObject).put("param_compwidth", String.valueOf(paramavat.jdField_b_of_type_Int));
        ((HashMap)localObject).put("param_compheight", String.valueOf(paramavat.jdField_c_of_type_Int));
        ((HashMap)localObject).put("param_compsize", paramavat.jdField_b_of_type_Int * paramavat.jdField_c_of_type_Int + "");
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "actPicOcrCompressInfo", true, 0L, 0L, (HashMap)localObject, "");
        i = 1;
        break;
      }
      label671:
      i = 0;
    }
  }
  
  public avaw a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))) {
      return (avaw)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    }
    return null;
  }
  
  public void a(avat paramavat, avau paramavau)
  {
    ThreadManager.excute(new PicOcrManager.3(this, paramavat, paramavau), 64, null, true);
  }
  
  public void a(avau paramavau, avat paramavat)
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PicOcrManager", 2, "uploadOcrPic NetWork exception!");
      }
      paramavau.onUpdate(100, false, new avaw());
    }
    do
    {
      return;
      this.jdField_a_of_type_Avat = paramavat;
      if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler != null) && (this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.addFilter(new Class[] { BDHCommonUploadProcessor.class });
        this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.addHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
        this.jdField_a_of_type_Boolean = true;
      }
      paramavat.jdField_b_of_type_Long = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.i("PicOcrManager", 2, "uploadOcrPic:" + paramavat.a());
      }
      avas localavas = new avas(this, paramavau, paramavat);
      paramavau = new TransferRequest();
      paramavau.mFileType = 24;
      paramavau.mCommandId = 76;
      paramavau.mRichTag = "picorcupload";
      paramavau.mUpCallBack = localavas;
      paramavau.mLocalPath = paramavat.jdField_c_of_type_JavaLangString;
      paramavau.mSelfUin = this.jdField_a_of_type_JavaLangString;
      paramavau.mPeerUin = this.jdField_a_of_type_JavaLangString;
      paramavau.mUniseq = paramavat.jdField_b_of_type_Long;
      paramavau.mIsUp = true;
      paramavat = new Bdh_extinfo.CommFileExtReq();
      paramavat.uint32_action_type.set(0);
      paramavat.bytes_uuid.set(ByteStringMicro.copyFromUtf8(UUID.randomUUID().toString()));
      paramavau.mExtentionInfo = paramavat.toByteArray();
    } while (this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController == null);
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.transferAsync(paramavau);
  }
  
  public void a(String paramString, avaw paramavaw)
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
      if ((TextUtils.isEmpty(paramString)) || (paramavaw == null)) {
        break;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramavaw);
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
 * Qualified Name:     avaq
 * JD-Core Version:    0.7.0.1
 */