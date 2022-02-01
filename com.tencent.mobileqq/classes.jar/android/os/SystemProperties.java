package android.os;

public class SystemProperties
{
  public static final int PROP_NAME_MAX = 31;
  public static final int PROP_VALUE_MAX = 255;
  
  public static String get(String paramString)
  {
    if (paramString.length() <= 31) {
      return native_get(paramString);
    }
    throw new IllegalArgumentException("key.length > 31");
  }
  
  public static String get(String paramString1, String paramString2)
  {
    if (paramString1.length() <= 31) {
      return native_get(paramString1, paramString2);
    }
    throw new IllegalArgumentException("key.length > 31");
  }
  
  public static boolean getBoolean(String paramString, boolean paramBoolean)
  {
    if (paramString.length() <= 31) {
      return native_get_boolean(paramString, paramBoolean);
    }
    throw new IllegalArgumentException("key.length > 31");
  }
  
  public static int getInt(String paramString, int paramInt)
  {
    if (paramString.length() <= 31) {
      return native_get_int(paramString, paramInt);
    }
    throw new IllegalArgumentException("key.length > 31");
  }
  
  public static long getLong(String paramString, long paramLong)
  {
    if (paramString.length() <= 31) {
      return native_get_long(paramString, paramLong);
    }
    throw new IllegalArgumentException("key.length > 31");
  }
  
  public static native String native_get(String paramString);
  
  public static native String native_get(String paramString1, String paramString2);
  
  public static native boolean native_get_boolean(String paramString, boolean paramBoolean);
  
  public static native int native_get_int(String paramString, int paramInt);
  
  public static native long native_get_long(String paramString, long paramLong);
  
  public static native void native_set(String paramString1, String paramString2);
  
  public static void set(String paramString1, String paramString2)
  {
    if (paramString1.length() <= 31)
    {
      if ((paramString2 != null) && (paramString2.length() > 255)) {
        throw new IllegalArgumentException("val.length > 255");
      }
      native_set(paramString1, paramString2);
      return;
    }
    throw new IllegalArgumentException("key.length > 31");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.os.SystemProperties
 * JD-Core Version:    0.7.0.1
 */