import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class bezh
{
  public static long a = -1L;
  public static long b = -1L;
  
  public static long a()
  {
    if (a < 0L)
    {
      a = a("SP_KEY_C2C_PIC_SIZE_LIMIT", 16777216L);
      if (QLog.isColorLevel()) {
        QLog.d("PicUploadFileSizeLimit", 2, "getLimitC2C:" + a);
      }
    }
    return a;
  }
  
  private static long a(String paramString, long paramLong)
  {
    long l = -1L;
    SharedPreferences localSharedPreferences = BaseApplicationImpl.sApplication.getSharedPreferences("SP_KEY_PIC_SIZE_LIMIT", 4);
    if (localSharedPreferences != null) {
      l = localSharedPreferences.getLong(paramString, -1L);
    }
    if (l < 0L) {
      return paramLong;
    }
    return l;
  }
  
  public static void a(long paramLong)
  {
    a("SP_KEY_C2C_PIC_SIZE_LIMIT", paramLong);
    if (paramLong > 0L) {
      a = paramLong;
    }
  }
  
  private static void a(String paramString, long paramLong)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.sApplication.getSharedPreferences("SP_KEY_PIC_SIZE_LIMIT", 4).edit();
    localEditor.putLong(paramString, paramLong);
    localEditor.commit();
    if (QLog.isColorLevel()) {
      QLog.d("PicUploadFileSizeLimit", 2, "setLimit:" + paramString + " size:" + paramLong);
    }
  }
  
  public static long b()
  {
    if (b < 0L)
    {
      b = a("SP_KEY_GROUP_PIC_SIZE_LIMIT", 16777216L);
      if (QLog.isColorLevel()) {
        QLog.d("PicUploadFileSizeLimit", 2, "getLimitGroup:" + b);
      }
    }
    return b;
  }
  
  public static void b(long paramLong)
  {
    a("SP_KEY_GROUP_PIC_SIZE_LIMIT", paramLong);
    if (paramLong > 0L) {
      b = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bezh
 * JD-Core Version:    0.7.0.1
 */