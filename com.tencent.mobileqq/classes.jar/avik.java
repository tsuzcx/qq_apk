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

public class avik
  implements Manager
{
  private avin jdField_a_of_type_Avin;
  protected beyb a;
  protected beyf a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected String a;
  private HashMap<String, avir> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  boolean jdField_a_of_type_Boolean = false;
  
  public avik(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Beyf = new avil(this, ThreadManager.getSubThreadLooper());
    this.jdField_a_of_type_Beyb = paramQQAppInterface.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
  }
  
  private void b(avio paramavio, avin paramavin)
  {
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramavin.jdField_b_of_type_JavaLangString, (BitmapFactory.Options)localObject);
    int j = ((BitmapFactory.Options)localObject).outWidth;
    int k = ((BitmapFactory.Options)localObject).outHeight;
    paramavio = new File(paramavin.jdField_b_of_type_JavaLangString);
    long l = paramavio.length();
    int i;
    if (l < 6750000L)
    {
      paramavin.jdField_a_of_type_Long = paramavio.length();
      paramavin.jdField_b_of_type_Int = ((BitmapFactory.Options)localObject).outWidth;
      paramavin.jdField_c_of_type_Int = ((BitmapFactory.Options)localObject).outHeight;
      paramavin.e = paramavin.d;
      paramavin.jdField_c_of_type_JavaLangString = paramavin.jdField_b_of_type_JavaLangString;
      i = 0;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PicOcrManager", 2, "tryCompressIfNeeded:" + paramavin.a() + ", oriLength:" + paramavio.length() / 1024L + ", oriSize:[" + j + "*" + k + "]");
      }
      paramavin = new HashMap();
      paramavin.put("param_type", i + "");
      paramavin.put("param_length", paramavio.length() / 1024L + "");
      paramavin.put("param_width", String.valueOf(j));
      paramavin.put("param_height", String.valueOf(k));
      paramavin.put("param_size", j * k + "");
      bdmc.a(BaseApplication.getContext()).a("", "actPicOcrCompressType", true, 0L, 0L, paramavin, "");
      return;
      if (l > 13500000L) {}
      for (i = 2;; i = 1)
      {
        ((BitmapFactory.Options)localObject).inSampleSize = i;
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
        localObject = avis.a(paramavin.jdField_b_of_type_JavaLangString, (BitmapFactory.Options)localObject, 1, 4);
        if (localObject == null) {
          break label671;
        }
        int[] arrayOfInt = new int[2];
        paramavin.jdField_c_of_type_JavaLangString = avis.a((Bitmap)localObject, paramavin.jdField_b_of_type_JavaLangString, arrayOfInt);
        if (!bhmi.b(paramavin.jdField_c_of_type_JavaLangString)) {
          break label671;
        }
        paramavin.jdField_b_of_type_Int = arrayOfInt[0];
        paramavin.jdField_c_of_type_Int = arrayOfInt[1];
        paramavin.jdField_a_of_type_Long = new File(paramavin.jdField_c_of_type_JavaLangString).length();
        paramavin.e = avis.a(paramavin.jdField_c_of_type_JavaLangString);
        localObject = new HashMap();
        ((HashMap)localObject).put("param_length", paramavio.length() / 1024L + "");
        ((HashMap)localObject).put("param_width", String.valueOf(j));
        ((HashMap)localObject).put("param_height", String.valueOf(k));
        ((HashMap)localObject).put("param_size", j * k + "");
        ((HashMap)localObject).put("param_complength", paramavin.jdField_a_of_type_Long / 1024L + "");
        ((HashMap)localObject).put("param_compwidth", String.valueOf(paramavin.jdField_b_of_type_Int));
        ((HashMap)localObject).put("param_compheight", String.valueOf(paramavin.jdField_c_of_type_Int));
        ((HashMap)localObject).put("param_compsize", paramavin.jdField_b_of_type_Int * paramavin.jdField_c_of_type_Int + "");
        bdmc.a(BaseApplication.getContext()).a("", "actPicOcrCompressInfo", true, 0L, 0L, (HashMap)localObject, "");
        i = 1;
        break;
      }
      label671:
      i = 0;
    }
  }
  
  public avir a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))) {
      return (avir)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    }
    return null;
  }
  
  public void a(avin paramavin, avio paramavio)
  {
    ThreadManager.excute(new PicOcrManager.3(this, paramavin, paramavio), 64, null, true);
  }
  
  public void a(avio paramavio, avin paramavin)
  {
    if (!bhnv.d(BaseApplication.getContext()))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PicOcrManager", 2, "uploadOcrPic NetWork exception!");
      }
      paramavio.onUpdate(100, false, new avir());
    }
    do
    {
      return;
      this.jdField_a_of_type_Avin = paramavin;
      if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Beyf != null) && (this.jdField_a_of_type_Beyb != null))
      {
        this.jdField_a_of_type_Beyf.addFilter(new Class[] { berh.class });
        this.jdField_a_of_type_Beyb.a(this.jdField_a_of_type_Beyf);
        this.jdField_a_of_type_Boolean = true;
      }
      paramavin.jdField_b_of_type_Long = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.i("PicOcrManager", 2, "uploadOcrPic:" + paramavin.a());
      }
      avim localavim = new avim(this, paramavio, paramavin);
      paramavio = new beyg();
      paramavio.jdField_b_of_type_Int = 24;
      paramavio.jdField_c_of_type_Int = 76;
      paramavio.jdField_a_of_type_JavaLangString = "picorcupload";
      paramavio.jdField_a_of_type_Azrg = localavim;
      paramavio.i = paramavin.jdField_c_of_type_JavaLangString;
      paramavio.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      paramavio.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      paramavio.jdField_a_of_type_Long = paramavin.jdField_b_of_type_Long;
      paramavio.jdField_a_of_type_Boolean = true;
      paramavin = new Bdh_extinfo.CommFileExtReq();
      paramavin.uint32_action_type.set(0);
      paramavin.bytes_uuid.set(ByteStringMicro.copyFromUtf8(UUID.randomUUID().toString()));
      paramavio.jdField_a_of_type_ArrayOfByte = paramavin.toByteArray();
    } while (this.jdField_a_of_type_Beyb == null);
    this.jdField_a_of_type_Beyb.a(paramavio);
  }
  
  public void a(String paramString, avir paramavir)
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
      if ((TextUtils.isEmpty(paramString)) || (paramavir == null)) {
        break;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramavir);
      return;
      str = "";
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Beyb != null)
    {
      this.jdField_a_of_type_Beyb.b(this.jdField_a_of_type_Beyf);
      this.jdField_a_of_type_Beyf = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avik
 * JD-Core Version:    0.7.0.1
 */