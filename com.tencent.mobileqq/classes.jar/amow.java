import android.text.TextUtils;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class amow
{
  public int a;
  public String a;
  public int b;
  public String b;
  public String c;
  
  public String a()
  {
    if (this.jdField_a_of_type_Int == 6) {
      return this.jdField_a_of_type_JavaLangString;
    }
    if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      if (this.jdField_b_of_type_JavaLangString.endsWith("/")) {
        return this.jdField_b_of_type_JavaLangString + this.jdField_b_of_type_Int + "/" + this.jdField_a_of_type_JavaLangString;
      }
      return this.jdField_b_of_type_JavaLangString + "/" + this.jdField_b_of_type_Int + "/" + this.jdField_a_of_type_JavaLangString;
    }
    return "";
  }
  
  public boolean a()
  {
    return (new File(b()).exists()) && (b());
  }
  
  public String b()
  {
    if (8 == this.jdField_a_of_type_Int) {
      return "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/room/" + this.jdField_b_of_type_Int + File.separator + this.jdField_a_of_type_JavaLangString;
    }
    return "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo" + this.jdField_b_of_type_Int + File.separator + this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean b()
  {
    if ((ApolloUtil.c(b())) && (this.jdField_a_of_type_Int == 8)) {
      return ApolloUtil.c("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/room/" + this.jdField_b_of_type_Int + File.separator + "room.bin");
    }
    return false;
  }
  
  public String c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IdolRscItem", 2, "getFaceDataJson this:" + this);
    }
    if (this.jdField_a_of_type_Int == 6)
    {
      Object localObject1 = MD5Utils.toMD5(this.jdField_a_of_type_JavaLangString);
      localObject1 = new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/dress//face/" + (String)localObject1 + File.separator + "face.json");
      if (((File)localObject1).exists()) {
        try
        {
          localObject1 = FileUtils.readFileToString((File)localObject1);
          return localObject1;
        }
        catch (Exception localException1)
        {
          QLog.e("IdolRscItem", 1, "getFaceDataJson " + localException1);
        }
      }
    }
    for (;;)
    {
      return "";
      Object localObject2 = new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/dress/" + this.jdField_b_of_type_Int + File.separator + "blendshape.json");
      if (((File)localObject2).exists())
      {
        try
        {
          localObject2 = FileUtils.readFileToString((File)localObject2);
          return localObject2;
        }
        catch (Exception localException2)
        {
          QLog.e("IdolRscItem", 1, "getFaceDataJson " + localException2);
        }
        continue;
        Object localObject3 = new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/dress/" + this.jdField_b_of_type_Int + File.separator + "face.json");
        if (((File)localObject3).exists())
        {
          try
          {
            localObject3 = FileUtils.readFileToString((File)localObject3);
            return localObject3;
          }
          catch (Exception localException3)
          {
            QLog.e("IdolRscItem", 1, "getFaceDataJson " + localException3);
          }
        }
        else
        {
          Object localObject4 = new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/dress/" + this.jdField_b_of_type_Int + File.separator + "blendshape.json");
          if (((File)localObject4).exists()) {
            try
            {
              localObject4 = FileUtils.readFileToString((File)localObject4);
              return localObject4;
            }
            catch (Exception localException4)
            {
              QLog.e("IdolRscItem", 1, "getFaceDataJson " + localException4);
            }
          }
        }
      }
    }
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("IdolRscItem{");
    localStringBuffer.append("mResType=").append(this.jdField_a_of_type_Int);
    localStringBuffer.append(", mDownFileName='").append(this.jdField_a_of_type_JavaLangString).append('\'');
    localStringBuffer.append(", mId=").append(this.jdField_b_of_type_Int);
    localStringBuffer.append(", mDownPrefixxUrl='").append(this.jdField_b_of_type_JavaLangString).append('\'');
    localStringBuffer.append(", mCacheJsonName='").append(this.c).append('\'');
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amow
 * JD-Core Version:    0.7.0.1
 */