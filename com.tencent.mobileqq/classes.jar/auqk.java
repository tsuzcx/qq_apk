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
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;
import mqq.manager.Manager;

public class auqk
  implements Manager
{
  private auqn jdField_a_of_type_Auqn;
  protected bdzi a;
  protected bdzm a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected String a;
  private HashMap<String, auqr> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  boolean jdField_a_of_type_Boolean = false;
  
  public auqk(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Bdzm = new auql(this, ThreadManager.getSubThreadLooper());
    this.jdField_a_of_type_Bdzi = paramQQAppInterface.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
  }
  
  private void b(auqo paramauqo, auqn paramauqn)
  {
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramauqn.jdField_b_of_type_JavaLangString, (BitmapFactory.Options)localObject);
    int j = ((BitmapFactory.Options)localObject).outWidth;
    int k = ((BitmapFactory.Options)localObject).outHeight;
    paramauqo = new File(paramauqn.jdField_b_of_type_JavaLangString);
    long l = paramauqo.length();
    int i;
    if (l < 6750000L)
    {
      paramauqn.jdField_a_of_type_Long = paramauqo.length();
      paramauqn.jdField_b_of_type_Int = ((BitmapFactory.Options)localObject).outWidth;
      paramauqn.jdField_c_of_type_Int = ((BitmapFactory.Options)localObject).outHeight;
      paramauqn.e = paramauqn.d;
      paramauqn.jdField_c_of_type_JavaLangString = paramauqn.jdField_b_of_type_JavaLangString;
      i = 0;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PicOcrManager", 2, "tryCompressIfNeeded:" + paramauqn.a() + ", oriLength:" + paramauqo.length() / 1024L + ", oriSize:[" + j + "*" + k + "]");
      }
      paramauqn = new HashMap();
      paramauqn.put("param_type", i + "");
      paramauqn.put("param_length", paramauqo.length() / 1024L + "");
      paramauqn.put("param_width", String.valueOf(j));
      paramauqn.put("param_height", String.valueOf(k));
      paramauqn.put("param_size", j * k + "");
      bctj.a(BaseApplication.getContext()).a("", "actPicOcrCompressType", true, 0L, 0L, paramauqn, "");
      return;
      if (l > 13500000L) {}
      for (i = 2;; i = 1)
      {
        ((BitmapFactory.Options)localObject).inSampleSize = i;
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
        localObject = auqs.a(paramauqn.jdField_b_of_type_JavaLangString, (BitmapFactory.Options)localObject, 1, 4);
        if (localObject == null) {
          break label671;
        }
        int[] arrayOfInt = new int[2];
        paramauqn.jdField_c_of_type_JavaLangString = auqs.a((Bitmap)localObject, paramauqn.jdField_b_of_type_JavaLangString, arrayOfInt);
        if (!bgmg.b(paramauqn.jdField_c_of_type_JavaLangString)) {
          break label671;
        }
        paramauqn.jdField_b_of_type_Int = arrayOfInt[0];
        paramauqn.jdField_c_of_type_Int = arrayOfInt[1];
        paramauqn.jdField_a_of_type_Long = new File(paramauqn.jdField_c_of_type_JavaLangString).length();
        paramauqn.e = auqs.a(paramauqn.jdField_c_of_type_JavaLangString);
        localObject = new HashMap();
        ((HashMap)localObject).put("param_length", paramauqo.length() / 1024L + "");
        ((HashMap)localObject).put("param_width", String.valueOf(j));
        ((HashMap)localObject).put("param_height", String.valueOf(k));
        ((HashMap)localObject).put("param_size", j * k + "");
        ((HashMap)localObject).put("param_complength", paramauqn.jdField_a_of_type_Long / 1024L + "");
        ((HashMap)localObject).put("param_compwidth", String.valueOf(paramauqn.jdField_b_of_type_Int));
        ((HashMap)localObject).put("param_compheight", String.valueOf(paramauqn.jdField_c_of_type_Int));
        ((HashMap)localObject).put("param_compsize", paramauqn.jdField_b_of_type_Int * paramauqn.jdField_c_of_type_Int + "");
        bctj.a(BaseApplication.getContext()).a("", "actPicOcrCompressInfo", true, 0L, 0L, (HashMap)localObject, "");
        i = 1;
        break;
      }
      label671:
      i = 0;
    }
  }
  
  public auqr a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))) {
      return (auqr)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    }
    return null;
  }
  
  public void a(auqn paramauqn, auqo paramauqo)
  {
    ThreadManager.excute(new PicOcrManager.3(this, paramauqn, paramauqo), 64, null, true);
  }
  
  public void a(auqo paramauqo, auqn paramauqn)
  {
    if (!bgnt.d(BaseApplication.getContext()))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PicOcrManager", 2, "uploadOcrPic NetWork exception!");
      }
      paramauqo.onUpdate(100, false, new auqr());
    }
    do
    {
      return;
      this.jdField_a_of_type_Auqn = paramauqn;
      if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Bdzm != null) && (this.jdField_a_of_type_Bdzi != null))
      {
        this.jdField_a_of_type_Bdzm.addFilter(new Class[] { bdsp.class });
        this.jdField_a_of_type_Bdzi.a(this.jdField_a_of_type_Bdzm);
        this.jdField_a_of_type_Boolean = true;
      }
      paramauqn.jdField_b_of_type_Long = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.i("PicOcrManager", 2, "uploadOcrPic:" + paramauqn.a());
      }
      auqm localauqm = new auqm(this, paramauqo, paramauqn);
      paramauqo = new bdzn();
      paramauqo.jdField_b_of_type_Int = 24;
      paramauqo.jdField_c_of_type_Int = 76;
      paramauqo.jdField_a_of_type_JavaLangString = "picorcupload";
      paramauqo.jdField_a_of_type_Ayyt = localauqm;
      paramauqo.i = paramauqn.jdField_c_of_type_JavaLangString;
      paramauqo.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      paramauqo.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      paramauqo.jdField_a_of_type_Long = paramauqn.jdField_b_of_type_Long;
      paramauqo.jdField_a_of_type_Boolean = true;
      paramauqn = new Bdh_extinfo.CommFileExtReq();
      paramauqn.uint32_action_type.set(0);
      paramauqn.bytes_uuid.set(ByteStringMicro.copyFromUtf8(UUID.randomUUID().toString()));
      paramauqo.jdField_a_of_type_ArrayOfByte = paramauqn.toByteArray();
    } while (this.jdField_a_of_type_Bdzi == null);
    this.jdField_a_of_type_Bdzi.a(paramauqo);
  }
  
  public void a(String paramString, auqr paramauqr)
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
      if ((TextUtils.isEmpty(paramString)) || (paramauqr == null)) {
        break;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramauqr);
      return;
      str = "";
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Bdzi != null)
    {
      this.jdField_a_of_type_Bdzi.b(this.jdField_a_of_type_Bdzm);
      this.jdField_a_of_type_Bdzm = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auqk
 * JD-Core Version:    0.7.0.1
 */