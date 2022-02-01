import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.base.http.AvatarUpdateService.1;
import com.tencent.qphone.base.util.QLog;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class bjuj
  implements bjuv
{
  private static bjuj a;
  public SharedPreferences a;
  public HashMap<String, bjuk> a;
  
  protected bjuj()
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("uin_avatarurl", 0);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static bjuj a()
  {
    try
    {
      if (jdField_a_of_type_Bjuj == null) {
        jdField_a_of_type_Bjuj = new bjuj();
      }
      return jdField_a_of_type_Bjuj;
    }
    finally {}
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, String paramString3, bjuv parambjuv)
  {
    QLog.d("AvatarUpdateService", 1, "-->updateAvatar--uin = " + bjqq.a(paramString1));
    String str2 = "https://openmobile.qq.com/getface?appid=716027609&imgtype=3&encrytype=0&devtype=0&keytype=0&uin=" + paramString1;
    for (String str1 = paramString1; str1.length() < 10; str1 = "0" + str1) {}
    str1 = "o" + str1;
    ThreadManager.post(new AvatarUpdateService.1(this, str2, "uin=" + str1 + "; skey=" + paramString2, paramString1, paramString3, paramContext, parambjuv), 5, null, true);
  }
  
  protected void a(Bitmap paramBitmap, String paramString)
  {
    if (paramBitmap == null) {}
    do
    {
      return;
      paramString = bhmq.a(paramString);
    } while (paramString == null);
    paramString = new FileOutputStream(paramString);
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, paramString);
    paramString.flush();
    paramString.close();
  }
  
  public void a(String paramString, Bitmap arg2)
  {
    boolean bool2 = true;
    Object localObject1;
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        localObject1 = (bjuk)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder().append("-->onTaskCompleted--identifier = ").append(paramString).append(", bitmap = null ? ");
          if (??? == null)
          {
            bool1 = true;
            ??? = ((StringBuilder)???).append(bool1).append(", task = null ? ");
            if (localObject1 != null) {
              break label116;
            }
            bool1 = bool2;
            QLog.d("AvatarUpdateService", 2, bool1);
          }
        }
        else
        {
          if (localObject1 != null) {
            break;
          }
          return;
        }
      }
      boolean bool1 = false;
      continue;
      label116:
      bool1 = false;
    }
    ??? = (Context)((bjuk)localObject1).jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((??? != null) && (??? != null))
    {
      ??? = bjqq.a((Context)???, ???, 63, 63);
      if (??? == null) {}
    }
    try
    {
      a(???, ((bjuk)localObject1).jdField_b_of_type_JavaLangString);
      ??? = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
      ((SharedPreferences.Editor)???).putString(((bjuk)localObject1).jdField_a_of_type_JavaLangString, ((bjuk)localObject1).c);
      ((SharedPreferences.Editor)???).commit();
      label205:
      localObject1 = (bjuv)((bjuk)localObject1).jdField_b_of_type_JavaLangRefWeakReference.get();
      if (localObject1 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AvatarUpdateService", 2, "-->onTaskCompleted--callback not null, invoke it");
        }
        ((bjuv)localObject1).a(paramString, ???);
      }
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
        return;
      }
    }
    catch (IOException localIOException)
    {
      break label205;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjuj
 * JD-Core Version:    0.7.0.1
 */