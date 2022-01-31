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

public class aqmw
  implements Manager
{
  private aqmz jdField_a_of_type_Aqmz;
  protected ayvx a;
  protected aywb a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected String a;
  private HashMap<String, aqnd> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  boolean jdField_a_of_type_Boolean = false;
  
  public aqmw(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Aywb = new aqmx(this, ThreadManager.getSubThreadLooper());
    this.jdField_a_of_type_Ayvx = paramQQAppInterface.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
  }
  
  private void b(aqna paramaqna, aqmz paramaqmz)
  {
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramaqmz.jdField_b_of_type_JavaLangString, (BitmapFactory.Options)localObject);
    int j = ((BitmapFactory.Options)localObject).outWidth;
    int k = ((BitmapFactory.Options)localObject).outHeight;
    paramaqna = new File(paramaqmz.jdField_b_of_type_JavaLangString);
    long l = paramaqna.length();
    int i;
    if (l < 6750000L)
    {
      paramaqmz.jdField_a_of_type_Long = paramaqna.length();
      paramaqmz.jdField_b_of_type_Int = ((BitmapFactory.Options)localObject).outWidth;
      paramaqmz.jdField_c_of_type_Int = ((BitmapFactory.Options)localObject).outHeight;
      paramaqmz.e = paramaqmz.d;
      paramaqmz.jdField_c_of_type_JavaLangString = paramaqmz.jdField_b_of_type_JavaLangString;
      i = 0;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PicOcrManager", 2, "tryCompressIfNeeded:" + paramaqmz.a() + ", oriLength:" + paramaqna.length() / 1024L + ", oriSize:[" + j + "*" + k + "]");
      }
      paramaqmz = new HashMap();
      paramaqmz.put("param_type", i + "");
      paramaqmz.put("param_length", paramaqna.length() / 1024L + "");
      paramaqmz.put("param_width", String.valueOf(j));
      paramaqmz.put("param_height", String.valueOf(k));
      paramaqmz.put("param_size", j * k + "");
      axrn.a(BaseApplication.getContext()).a("", "actPicOcrCompressType", true, 0L, 0L, paramaqmz, "");
      return;
      if (l > 13500000L) {}
      for (i = 2;; i = 1)
      {
        ((BitmapFactory.Options)localObject).inSampleSize = i;
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
        localObject = aqne.a(paramaqmz.jdField_b_of_type_JavaLangString, (BitmapFactory.Options)localObject, 1, 4);
        if (localObject == null) {
          break label671;
        }
        int[] arrayOfInt = new int[2];
        paramaqmz.jdField_c_of_type_JavaLangString = aqne.a((Bitmap)localObject, paramaqmz.jdField_b_of_type_JavaLangString, arrayOfInt);
        if (!bbdx.b(paramaqmz.jdField_c_of_type_JavaLangString)) {
          break label671;
        }
        paramaqmz.jdField_b_of_type_Int = arrayOfInt[0];
        paramaqmz.jdField_c_of_type_Int = arrayOfInt[1];
        paramaqmz.jdField_a_of_type_Long = new File(paramaqmz.jdField_c_of_type_JavaLangString).length();
        paramaqmz.e = aqne.a(paramaqmz.jdField_c_of_type_JavaLangString);
        localObject = new HashMap();
        ((HashMap)localObject).put("param_length", paramaqna.length() / 1024L + "");
        ((HashMap)localObject).put("param_width", String.valueOf(j));
        ((HashMap)localObject).put("param_height", String.valueOf(k));
        ((HashMap)localObject).put("param_size", j * k + "");
        ((HashMap)localObject).put("param_complength", paramaqmz.jdField_a_of_type_Long / 1024L + "");
        ((HashMap)localObject).put("param_compwidth", String.valueOf(paramaqmz.jdField_b_of_type_Int));
        ((HashMap)localObject).put("param_compheight", String.valueOf(paramaqmz.jdField_c_of_type_Int));
        ((HashMap)localObject).put("param_compsize", paramaqmz.jdField_b_of_type_Int * paramaqmz.jdField_c_of_type_Int + "");
        axrn.a(BaseApplication.getContext()).a("", "actPicOcrCompressInfo", true, 0L, 0L, (HashMap)localObject, "");
        i = 1;
        break;
      }
      label671:
      i = 0;
    }
  }
  
  public aqnd a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))) {
      return (aqnd)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    }
    return null;
  }
  
  public void a(aqmz paramaqmz, aqna paramaqna)
  {
    ThreadManager.excute(new PicOcrManager.3(this, paramaqmz, paramaqna), 64, null, true);
  }
  
  public void a(aqna paramaqna, aqmz paramaqmz)
  {
    if (!bbfj.d(BaseApplication.getContext()))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PicOcrManager", 2, "uploadOcrPic NetWork exception!");
      }
      paramaqna.onUpdate(100, false, new aqnd());
    }
    do
    {
      return;
      this.jdField_a_of_type_Aqmz = paramaqmz;
      if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Aywb != null) && (this.jdField_a_of_type_Ayvx != null))
      {
        this.jdField_a_of_type_Aywb.addFilter(new Class[] { ayou.class });
        this.jdField_a_of_type_Ayvx.a(this.jdField_a_of_type_Aywb);
        this.jdField_a_of_type_Boolean = true;
      }
      paramaqmz.jdField_b_of_type_Long = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.i("PicOcrManager", 2, "uploadOcrPic:" + paramaqmz.a());
      }
      aqmy localaqmy = new aqmy(this, paramaqna, paramaqmz);
      paramaqna = new aywc();
      paramaqna.jdField_b_of_type_Int = 24;
      paramaqna.jdField_c_of_type_Int = 76;
      paramaqna.jdField_a_of_type_JavaLangString = "picorcupload";
      paramaqna.jdField_a_of_type_Auoq = localaqmy;
      paramaqna.i = paramaqmz.jdField_c_of_type_JavaLangString;
      paramaqna.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      paramaqna.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      paramaqna.jdField_a_of_type_Long = paramaqmz.jdField_b_of_type_Long;
      paramaqna.jdField_a_of_type_Boolean = true;
      paramaqmz = new Bdh_extinfo.CommFileExtReq();
      paramaqmz.uint32_action_type.set(0);
      paramaqmz.bytes_uuid.set(ByteStringMicro.copyFromUtf8(UUID.randomUUID().toString()));
      paramaqna.jdField_a_of_type_ArrayOfByte = paramaqmz.toByteArray();
    } while (this.jdField_a_of_type_Ayvx == null);
    this.jdField_a_of_type_Ayvx.a(paramaqna);
  }
  
  public void a(String paramString, aqnd paramaqnd)
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
      if ((TextUtils.isEmpty(paramString)) || (paramaqnd == null)) {
        break;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramaqnd);
      return;
      str = "";
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Ayvx != null)
    {
      this.jdField_a_of_type_Ayvx.b(this.jdField_a_of_type_Aywb);
      this.jdField_a_of_type_Aywb = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqmw
 * JD-Core Version:    0.7.0.1
 */