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

public class aqmu
  implements Manager
{
  private aqmx jdField_a_of_type_Aqmx;
  protected ayvv a;
  protected ayvz a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected String a;
  private HashMap<String, aqnb> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  boolean jdField_a_of_type_Boolean = false;
  
  public aqmu(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Ayvz = new aqmv(this, ThreadManager.getSubThreadLooper());
    this.jdField_a_of_type_Ayvv = paramQQAppInterface.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
  }
  
  private void b(aqmy paramaqmy, aqmx paramaqmx)
  {
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramaqmx.jdField_b_of_type_JavaLangString, (BitmapFactory.Options)localObject);
    int j = ((BitmapFactory.Options)localObject).outWidth;
    int k = ((BitmapFactory.Options)localObject).outHeight;
    paramaqmy = new File(paramaqmx.jdField_b_of_type_JavaLangString);
    long l = paramaqmy.length();
    int i;
    if (l < 6750000L)
    {
      paramaqmx.jdField_a_of_type_Long = paramaqmy.length();
      paramaqmx.jdField_b_of_type_Int = ((BitmapFactory.Options)localObject).outWidth;
      paramaqmx.jdField_c_of_type_Int = ((BitmapFactory.Options)localObject).outHeight;
      paramaqmx.e = paramaqmx.d;
      paramaqmx.jdField_c_of_type_JavaLangString = paramaqmx.jdField_b_of_type_JavaLangString;
      i = 0;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PicOcrManager", 2, "tryCompressIfNeeded:" + paramaqmx.a() + ", oriLength:" + paramaqmy.length() / 1024L + ", oriSize:[" + j + "*" + k + "]");
      }
      paramaqmx = new HashMap();
      paramaqmx.put("param_type", i + "");
      paramaqmx.put("param_length", paramaqmy.length() / 1024L + "");
      paramaqmx.put("param_width", String.valueOf(j));
      paramaqmx.put("param_height", String.valueOf(k));
      paramaqmx.put("param_size", j * k + "");
      axrl.a(BaseApplication.getContext()).a("", "actPicOcrCompressType", true, 0L, 0L, paramaqmx, "");
      return;
      if (l > 13500000L) {}
      for (i = 2;; i = 1)
      {
        ((BitmapFactory.Options)localObject).inSampleSize = i;
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
        localObject = aqnc.a(paramaqmx.jdField_b_of_type_JavaLangString, (BitmapFactory.Options)localObject, 1, 4);
        if (localObject == null) {
          break label671;
        }
        int[] arrayOfInt = new int[2];
        paramaqmx.jdField_c_of_type_JavaLangString = aqnc.a((Bitmap)localObject, paramaqmx.jdField_b_of_type_JavaLangString, arrayOfInt);
        if (!bbdj.b(paramaqmx.jdField_c_of_type_JavaLangString)) {
          break label671;
        }
        paramaqmx.jdField_b_of_type_Int = arrayOfInt[0];
        paramaqmx.jdField_c_of_type_Int = arrayOfInt[1];
        paramaqmx.jdField_a_of_type_Long = new File(paramaqmx.jdField_c_of_type_JavaLangString).length();
        paramaqmx.e = aqnc.a(paramaqmx.jdField_c_of_type_JavaLangString);
        localObject = new HashMap();
        ((HashMap)localObject).put("param_length", paramaqmy.length() / 1024L + "");
        ((HashMap)localObject).put("param_width", String.valueOf(j));
        ((HashMap)localObject).put("param_height", String.valueOf(k));
        ((HashMap)localObject).put("param_size", j * k + "");
        ((HashMap)localObject).put("param_complength", paramaqmx.jdField_a_of_type_Long / 1024L + "");
        ((HashMap)localObject).put("param_compwidth", String.valueOf(paramaqmx.jdField_b_of_type_Int));
        ((HashMap)localObject).put("param_compheight", String.valueOf(paramaqmx.jdField_c_of_type_Int));
        ((HashMap)localObject).put("param_compsize", paramaqmx.jdField_b_of_type_Int * paramaqmx.jdField_c_of_type_Int + "");
        axrl.a(BaseApplication.getContext()).a("", "actPicOcrCompressInfo", true, 0L, 0L, (HashMap)localObject, "");
        i = 1;
        break;
      }
      label671:
      i = 0;
    }
  }
  
  public aqnb a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))) {
      return (aqnb)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    }
    return null;
  }
  
  public void a(aqmx paramaqmx, aqmy paramaqmy)
  {
    ThreadManager.excute(new PicOcrManager.3(this, paramaqmx, paramaqmy), 64, null, true);
  }
  
  public void a(aqmy paramaqmy, aqmx paramaqmx)
  {
    if (!bbev.d(BaseApplication.getContext()))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PicOcrManager", 2, "uploadOcrPic NetWork exception!");
      }
      paramaqmy.onUpdate(100, false, new aqnb());
    }
    do
    {
      return;
      this.jdField_a_of_type_Aqmx = paramaqmx;
      if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Ayvz != null) && (this.jdField_a_of_type_Ayvv != null))
      {
        this.jdField_a_of_type_Ayvz.addFilter(new Class[] { ayos.class });
        this.jdField_a_of_type_Ayvv.a(this.jdField_a_of_type_Ayvz);
        this.jdField_a_of_type_Boolean = true;
      }
      paramaqmx.jdField_b_of_type_Long = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.i("PicOcrManager", 2, "uploadOcrPic:" + paramaqmx.a());
      }
      aqmw localaqmw = new aqmw(this, paramaqmy, paramaqmx);
      paramaqmy = new aywa();
      paramaqmy.jdField_b_of_type_Int = 24;
      paramaqmy.jdField_c_of_type_Int = 76;
      paramaqmy.jdField_a_of_type_JavaLangString = "picorcupload";
      paramaqmy.jdField_a_of_type_Auoo = localaqmw;
      paramaqmy.i = paramaqmx.jdField_c_of_type_JavaLangString;
      paramaqmy.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      paramaqmy.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      paramaqmy.jdField_a_of_type_Long = paramaqmx.jdField_b_of_type_Long;
      paramaqmy.jdField_a_of_type_Boolean = true;
      paramaqmx = new Bdh_extinfo.CommFileExtReq();
      paramaqmx.uint32_action_type.set(0);
      paramaqmx.bytes_uuid.set(ByteStringMicro.copyFromUtf8(UUID.randomUUID().toString()));
      paramaqmy.jdField_a_of_type_ArrayOfByte = paramaqmx.toByteArray();
    } while (this.jdField_a_of_type_Ayvv == null);
    this.jdField_a_of_type_Ayvv.a(paramaqmy);
  }
  
  public void a(String paramString, aqnb paramaqnb)
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
      if ((TextUtils.isEmpty(paramString)) || (paramaqnb == null)) {
        break;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramaqnb);
      return;
      str = "";
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Ayvv != null)
    {
      this.jdField_a_of_type_Ayvv.b(this.jdField_a_of_type_Ayvz);
      this.jdField_a_of_type_Ayvz = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqmu
 * JD-Core Version:    0.7.0.1
 */