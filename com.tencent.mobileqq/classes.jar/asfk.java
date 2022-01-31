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

public class asfk
  implements Manager
{
  private asfn jdField_a_of_type_Asfn;
  protected batw a;
  protected baua a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected String a;
  private HashMap<String, asfr> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  boolean jdField_a_of_type_Boolean = false;
  
  public asfk(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Baua = new asfl(this, ThreadManager.getSubThreadLooper());
    this.jdField_a_of_type_Batw = paramQQAppInterface.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
  }
  
  private void b(asfo paramasfo, asfn paramasfn)
  {
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramasfn.jdField_b_of_type_JavaLangString, (BitmapFactory.Options)localObject);
    int j = ((BitmapFactory.Options)localObject).outWidth;
    int k = ((BitmapFactory.Options)localObject).outHeight;
    paramasfo = new File(paramasfn.jdField_b_of_type_JavaLangString);
    long l = paramasfo.length();
    int i;
    if (l < 6750000L)
    {
      paramasfn.jdField_a_of_type_Long = paramasfo.length();
      paramasfn.jdField_b_of_type_Int = ((BitmapFactory.Options)localObject).outWidth;
      paramasfn.jdField_c_of_type_Int = ((BitmapFactory.Options)localObject).outHeight;
      paramasfn.e = paramasfn.d;
      paramasfn.jdField_c_of_type_JavaLangString = paramasfn.jdField_b_of_type_JavaLangString;
      i = 0;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PicOcrManager", 2, "tryCompressIfNeeded:" + paramasfn.a() + ", oriLength:" + paramasfo.length() / 1024L + ", oriSize:[" + j + "*" + k + "]");
      }
      paramasfn = new HashMap();
      paramasfn.put("param_type", i + "");
      paramasfn.put("param_length", paramasfo.length() / 1024L + "");
      paramasfn.put("param_width", String.valueOf(j));
      paramasfn.put("param_height", String.valueOf(k));
      paramasfn.put("param_size", j * k + "");
      azmz.a(BaseApplication.getContext()).a("", "actPicOcrCompressType", true, 0L, 0L, paramasfn, "");
      return;
      if (l > 13500000L) {}
      for (i = 2;; i = 1)
      {
        ((BitmapFactory.Options)localObject).inSampleSize = i;
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
        localObject = asfs.a(paramasfn.jdField_b_of_type_JavaLangString, (BitmapFactory.Options)localObject, 1, 4);
        if (localObject == null) {
          break label671;
        }
        int[] arrayOfInt = new int[2];
        paramasfn.jdField_c_of_type_JavaLangString = asfs.a((Bitmap)localObject, paramasfn.jdField_b_of_type_JavaLangString, arrayOfInt);
        if (!bdcs.b(paramasfn.jdField_c_of_type_JavaLangString)) {
          break label671;
        }
        paramasfn.jdField_b_of_type_Int = arrayOfInt[0];
        paramasfn.jdField_c_of_type_Int = arrayOfInt[1];
        paramasfn.jdField_a_of_type_Long = new File(paramasfn.jdField_c_of_type_JavaLangString).length();
        paramasfn.e = asfs.a(paramasfn.jdField_c_of_type_JavaLangString);
        localObject = new HashMap();
        ((HashMap)localObject).put("param_length", paramasfo.length() / 1024L + "");
        ((HashMap)localObject).put("param_width", String.valueOf(j));
        ((HashMap)localObject).put("param_height", String.valueOf(k));
        ((HashMap)localObject).put("param_size", j * k + "");
        ((HashMap)localObject).put("param_complength", paramasfn.jdField_a_of_type_Long / 1024L + "");
        ((HashMap)localObject).put("param_compwidth", String.valueOf(paramasfn.jdField_b_of_type_Int));
        ((HashMap)localObject).put("param_compheight", String.valueOf(paramasfn.jdField_c_of_type_Int));
        ((HashMap)localObject).put("param_compsize", paramasfn.jdField_b_of_type_Int * paramasfn.jdField_c_of_type_Int + "");
        azmz.a(BaseApplication.getContext()).a("", "actPicOcrCompressInfo", true, 0L, 0L, (HashMap)localObject, "");
        i = 1;
        break;
      }
      label671:
      i = 0;
    }
  }
  
  public asfr a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))) {
      return (asfr)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    }
    return null;
  }
  
  public void a(asfn paramasfn, asfo paramasfo)
  {
    ThreadManager.excute(new PicOcrManager.3(this, paramasfn, paramasfo), 64, null, true);
  }
  
  public void a(asfo paramasfo, asfn paramasfn)
  {
    if (!bdee.d(BaseApplication.getContext()))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PicOcrManager", 2, "uploadOcrPic NetWork exception!");
      }
      paramasfo.onUpdate(100, false, new asfr());
    }
    do
    {
      return;
      this.jdField_a_of_type_Asfn = paramasfn;
      if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Baua != null) && (this.jdField_a_of_type_Batw != null))
      {
        this.jdField_a_of_type_Baua.addFilter(new Class[] { bamp.class });
        this.jdField_a_of_type_Batw.a(this.jdField_a_of_type_Baua);
        this.jdField_a_of_type_Boolean = true;
      }
      paramasfn.jdField_b_of_type_Long = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.i("PicOcrManager", 2, "uploadOcrPic:" + paramasfn.a());
      }
      asfm localasfm = new asfm(this, paramasfo, paramasfn);
      paramasfo = new baub();
      paramasfo.jdField_b_of_type_Int = 24;
      paramasfo.jdField_c_of_type_Int = 76;
      paramasfo.jdField_a_of_type_JavaLangString = "picorcupload";
      paramasfo.jdField_a_of_type_Awfy = localasfm;
      paramasfo.i = paramasfn.jdField_c_of_type_JavaLangString;
      paramasfo.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      paramasfo.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      paramasfo.jdField_a_of_type_Long = paramasfn.jdField_b_of_type_Long;
      paramasfo.jdField_a_of_type_Boolean = true;
      paramasfn = new Bdh_extinfo.CommFileExtReq();
      paramasfn.uint32_action_type.set(0);
      paramasfn.bytes_uuid.set(ByteStringMicro.copyFromUtf8(UUID.randomUUID().toString()));
      paramasfo.jdField_a_of_type_ArrayOfByte = paramasfn.toByteArray();
    } while (this.jdField_a_of_type_Batw == null);
    this.jdField_a_of_type_Batw.a(paramasfo);
  }
  
  public void a(String paramString, asfr paramasfr)
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
      if ((TextUtils.isEmpty(paramString)) || (paramasfr == null)) {
        break;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramasfr);
      return;
      str = "";
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Batw != null)
    {
      this.jdField_a_of_type_Batw.b(this.jdField_a_of_type_Baua);
      this.jdField_a_of_type_Baua = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asfk
 * JD-Core Version:    0.7.0.1
 */