import android.graphics.Bitmap;

public class bhlo
{
  public static Object a()
  {
    return bhiw.a("com.tencent.rtmp.WXLivePushConfig", null, new Object[0]);
  }
  
  public static void a(int paramInt1, int paramInt2, Object paramObject)
  {
    bhiw.a(paramObject, "setVideoResolution", false, bhiw.a(new Class[] { Integer.TYPE, Integer.TYPE }), new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public static void a(int paramInt, Object paramObject)
  {
    bhiw.a(paramObject, "setHomeOrientation", false, bhiw.a(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static void a(Bitmap paramBitmap, float paramFloat1, float paramFloat2, float paramFloat3, Object paramObject)
  {
    bhiw.a(paramObject, "setWatermark", false, bhiw.a(new Class[] { Bitmap.class, Float.TYPE, Float.TYPE, Float.TYPE }), new Object[] { paramBitmap, Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3) });
  }
  
  public static void a(Bitmap paramBitmap, Object paramObject)
  {
    if (paramBitmap != null) {
      bhiw.a(paramObject, "setPauseImg", false, bhiw.a(new Class[] { Bitmap.class }), new Object[] { paramBitmap });
    }
  }
  
  public static void a(boolean paramBoolean, Object paramObject)
  {
    bhiw.a(paramObject, "setEnableZoom", false, bhiw.a(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public static void b(int paramInt, Object paramObject)
  {
    bhiw.a(paramObject, "setMinVideoBitrate", false, bhiw.a(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static void b(boolean paramBoolean, Object paramObject)
  {
    bhiw.a(paramObject, "enablePureAudioPush", false, bhiw.a(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public static void c(int paramInt, Object paramObject)
  {
    bhiw.a(paramObject, "setMaxVideoBitrate", false, bhiw.a(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static void c(boolean paramBoolean, Object paramObject)
  {
    bhiw.a(paramObject, "setFrontCamera", false, bhiw.a(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public static void d(int paramInt, Object paramObject)
  {
    bhiw.a(paramObject, "setPauseFlag", false, bhiw.a(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static void d(boolean paramBoolean, Object paramObject)
  {
    bhiw.a(paramObject, "setTouchFocus", false, bhiw.a(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public static void e(int paramInt, Object paramObject)
  {
    bhiw.a(paramObject, "setVideoResolution", false, bhiw.a(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static void e(boolean paramBoolean, Object paramObject)
  {
    bhiw.a(paramObject, "enableAGC", false, bhiw.a(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public static void f(int paramInt, Object paramObject)
  {
    bhiw.a(paramObject, "setVideoEncodeGop", false, bhiw.a(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static void f(boolean paramBoolean, Object paramObject)
  {
    bhiw.a(paramObject, "enableANS", false, bhiw.a(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public static void g(int paramInt, Object paramObject)
  {
    bhiw.a(paramObject, "setAudioSampleRate", false, bhiw.a(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static void g(boolean paramBoolean, Object paramObject)
  {
    bhiw.a(paramObject, "enableAudioEarMonitoring", false, bhiw.a(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public static void h(int paramInt, Object paramObject)
  {
    bhiw.a(paramObject, "setVolumeType", false, bhiw.a(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhlo
 * JD-Core Version:    0.7.0.1
 */