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

public class asjt
  implements Manager
{
  private asjw jdField_a_of_type_Asjw;
  protected bayf a;
  protected bayj a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected String a;
  private HashMap<String, aska> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  boolean jdField_a_of_type_Boolean = false;
  
  public asjt(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Bayj = new asju(this, ThreadManager.getSubThreadLooper());
    this.jdField_a_of_type_Bayf = paramQQAppInterface.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
  }
  
  private void b(asjx paramasjx, asjw paramasjw)
  {
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramasjw.jdField_b_of_type_JavaLangString, (BitmapFactory.Options)localObject);
    int j = ((BitmapFactory.Options)localObject).outWidth;
    int k = ((BitmapFactory.Options)localObject).outHeight;
    paramasjx = new File(paramasjw.jdField_b_of_type_JavaLangString);
    long l = paramasjx.length();
    int i;
    if (l < 6750000L)
    {
      paramasjw.jdField_a_of_type_Long = paramasjx.length();
      paramasjw.jdField_b_of_type_Int = ((BitmapFactory.Options)localObject).outWidth;
      paramasjw.jdField_c_of_type_Int = ((BitmapFactory.Options)localObject).outHeight;
      paramasjw.e = paramasjw.d;
      paramasjw.jdField_c_of_type_JavaLangString = paramasjw.jdField_b_of_type_JavaLangString;
      i = 0;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PicOcrManager", 2, "tryCompressIfNeeded:" + paramasjw.a() + ", oriLength:" + paramasjx.length() / 1024L + ", oriSize:[" + j + "*" + k + "]");
      }
      paramasjw = new HashMap();
      paramasjw.put("param_type", i + "");
      paramasjw.put("param_length", paramasjx.length() / 1024L + "");
      paramasjw.put("param_width", String.valueOf(j));
      paramasjw.put("param_height", String.valueOf(k));
      paramasjw.put("param_size", j * k + "");
      azri.a(BaseApplication.getContext()).a("", "actPicOcrCompressType", true, 0L, 0L, paramasjw, "");
      return;
      if (l > 13500000L) {}
      for (i = 2;; i = 1)
      {
        ((BitmapFactory.Options)localObject).inSampleSize = i;
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
        localObject = askb.a(paramasjw.jdField_b_of_type_JavaLangString, (BitmapFactory.Options)localObject, 1, 4);
        if (localObject == null) {
          break label671;
        }
        int[] arrayOfInt = new int[2];
        paramasjw.jdField_c_of_type_JavaLangString = askb.a((Bitmap)localObject, paramasjw.jdField_b_of_type_JavaLangString, arrayOfInt);
        if (!bdhb.b(paramasjw.jdField_c_of_type_JavaLangString)) {
          break label671;
        }
        paramasjw.jdField_b_of_type_Int = arrayOfInt[0];
        paramasjw.jdField_c_of_type_Int = arrayOfInt[1];
        paramasjw.jdField_a_of_type_Long = new File(paramasjw.jdField_c_of_type_JavaLangString).length();
        paramasjw.e = askb.a(paramasjw.jdField_c_of_type_JavaLangString);
        localObject = new HashMap();
        ((HashMap)localObject).put("param_length", paramasjx.length() / 1024L + "");
        ((HashMap)localObject).put("param_width", String.valueOf(j));
        ((HashMap)localObject).put("param_height", String.valueOf(k));
        ((HashMap)localObject).put("param_size", j * k + "");
        ((HashMap)localObject).put("param_complength", paramasjw.jdField_a_of_type_Long / 1024L + "");
        ((HashMap)localObject).put("param_compwidth", String.valueOf(paramasjw.jdField_b_of_type_Int));
        ((HashMap)localObject).put("param_compheight", String.valueOf(paramasjw.jdField_c_of_type_Int));
        ((HashMap)localObject).put("param_compsize", paramasjw.jdField_b_of_type_Int * paramasjw.jdField_c_of_type_Int + "");
        azri.a(BaseApplication.getContext()).a("", "actPicOcrCompressInfo", true, 0L, 0L, (HashMap)localObject, "");
        i = 1;
        break;
      }
      label671:
      i = 0;
    }
  }
  
  public aska a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))) {
      return (aska)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    }
    return null;
  }
  
  public void a(asjw paramasjw, asjx paramasjx)
  {
    ThreadManager.excute(new PicOcrManager.3(this, paramasjw, paramasjx), 64, null, true);
  }
  
  public void a(asjx paramasjx, asjw paramasjw)
  {
    if (!bdin.d(BaseApplication.getContext()))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PicOcrManager", 2, "uploadOcrPic NetWork exception!");
      }
      paramasjx.onUpdate(100, false, new aska());
    }
    do
    {
      return;
      this.jdField_a_of_type_Asjw = paramasjw;
      if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Bayj != null) && (this.jdField_a_of_type_Bayf != null))
      {
        this.jdField_a_of_type_Bayj.addFilter(new Class[] { baqy.class });
        this.jdField_a_of_type_Bayf.a(this.jdField_a_of_type_Bayj);
        this.jdField_a_of_type_Boolean = true;
      }
      paramasjw.jdField_b_of_type_Long = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.i("PicOcrManager", 2, "uploadOcrPic:" + paramasjw.a());
      }
      asjv localasjv = new asjv(this, paramasjx, paramasjw);
      paramasjx = new bayk();
      paramasjx.jdField_b_of_type_Int = 24;
      paramasjx.jdField_c_of_type_Int = 76;
      paramasjx.jdField_a_of_type_JavaLangString = "picorcupload";
      paramasjx.jdField_a_of_type_Awkh = localasjv;
      paramasjx.i = paramasjw.jdField_c_of_type_JavaLangString;
      paramasjx.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      paramasjx.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      paramasjx.jdField_a_of_type_Long = paramasjw.jdField_b_of_type_Long;
      paramasjx.jdField_a_of_type_Boolean = true;
      paramasjw = new Bdh_extinfo.CommFileExtReq();
      paramasjw.uint32_action_type.set(0);
      paramasjw.bytes_uuid.set(ByteStringMicro.copyFromUtf8(UUID.randomUUID().toString()));
      paramasjx.jdField_a_of_type_ArrayOfByte = paramasjw.toByteArray();
    } while (this.jdField_a_of_type_Bayf == null);
    this.jdField_a_of_type_Bayf.a(paramasjx);
  }
  
  public void a(String paramString, aska paramaska)
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
      if ((TextUtils.isEmpty(paramString)) || (paramaska == null)) {
        break;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramaska);
      return;
      str = "";
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Bayf != null)
    {
      this.jdField_a_of_type_Bayf.b(this.jdField_a_of_type_Bayj);
      this.jdField_a_of_type_Bayj = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asjt
 * JD-Core Version:    0.7.0.1
 */