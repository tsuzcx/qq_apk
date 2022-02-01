import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;

class bmbm
{
  private static final SharedPreferences a = ;
  
  static int a(@NonNull String paramString, int paramInt)
  {
    return a.getInt(paramString, paramInt);
  }
  
  static long a(@NonNull String paramString, long paramLong)
  {
    return a.getLong(paramString, paramLong);
  }
  
  @Nullable
  static String a(@NonNull String paramString1, String paramString2)
  {
    return a.getString(paramString1, paramString2);
  }
  
  static void a(@NonNull String paramString)
  {
    SharedPreferences.Editor localEditor = a.edit();
    localEditor.remove(paramString);
    localEditor.apply();
  }
  
  static void a(@NonNull String paramString, int paramInt)
  {
    SharedPreferences.Editor localEditor = a.edit();
    localEditor.putInt(paramString, paramInt);
    localEditor.apply();
  }
  
  static void a(@NonNull String paramString, long paramLong)
  {
    SharedPreferences.Editor localEditor = a.edit();
    localEditor.putLong(paramString, paramLong);
    localEditor.apply();
  }
  
  static void a(@NonNull String paramString1, String paramString2)
  {
    SharedPreferences.Editor localEditor = a.edit();
    localEditor.putString(paramString1, paramString2);
    localEditor.apply();
  }
  
  static void a(@NonNull String paramString, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = a.edit();
    localEditor.putBoolean(paramString, paramBoolean);
    localEditor.apply();
  }
  
  static boolean a(@NonNull String paramString)
  {
    return a.contains(paramString);
  }
  
  static boolean a(@NonNull String paramString, boolean paramBoolean)
  {
    return a.getBoolean(paramString, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmbm
 * JD-Core Version:    0.7.0.1
 */