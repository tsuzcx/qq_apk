import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class bizq
{
  public static void a(@NonNull String paramString1, @NonNull String paramString2)
  {
    QLog.d("MODULE_GY_AECAMERA :" + paramString1, 4, paramString2);
  }
  
  public static void a(@NonNull String paramString1, @NonNull String paramString2, @Nullable Throwable paramThrowable)
  {
    QLog.e("MODULE_GY_AECAMERA :" + paramString1, 1, paramString2, paramThrowable);
  }
  
  public static void b(@NonNull String paramString1, @NonNull String paramString2)
  {
    QLog.i("MODULE_GY_AECAMERA :" + paramString1, 1, paramString2);
  }
  
  public static void c(@NonNull String paramString1, @NonNull String paramString2)
  {
    QLog.w("MODULE_GY_AECAMERA :" + paramString1, 1, paramString2);
  }
  
  public static void d(@NonNull String paramString1, @NonNull String paramString2)
  {
    QLog.e("MODULE_GY_AECAMERA :" + paramString1, 1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bizq
 * JD-Core Version:    0.7.0.1
 */