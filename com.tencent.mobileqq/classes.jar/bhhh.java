import android.graphics.Bitmap;

public class bhhh
{
  public static Object a()
  {
    return bhep.a("com.tencent.rtmp.WXLivePushConfig", null, new Object[0]);
  }
  
  public static void a(int paramInt1, int paramInt2, Object paramObject)
  {
    bhep.a(paramObject, "setVideoResolution", false, bhep.a(new Class[] { Integer.TYPE, Integer.TYPE }), new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public static void a(int paramInt, Object paramObject)
  {
    bhep.a(paramObject, "setHomeOrientation", false, bhep.a(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static void a(Bitmap paramBitmap, float paramFloat1, float paramFloat2, float paramFloat3, Object paramObject)
  {
    bhep.a(paramObject, "setWatermark", false, bhep.a(new Class[] { Bitmap.class, Float.TYPE, Float.TYPE, Float.TYPE }), new Object[] { paramBitmap, Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3) });
  }
  
  public static void a(Bitmap paramBitmap, Object paramObject)
  {
    if (paramBitmap != null) {
      bhep.a(paramObject, "setPauseImg", false, bhep.a(new Class[] { Bitmap.class }), new Object[] { paramBitmap });
    }
  }
  
  public static void a(boolean paramBoolean, Object paramObject)
  {
    bhep.a(paramObject, "setEnableZoom", false, bhep.a(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public static void b(int paramInt, Object paramObject)
  {
    bhep.a(paramObject, "setMinVideoBitrate", false, bhep.a(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static void b(boolean paramBoolean, Object paramObject)
  {
    bhep.a(paramObject, "enablePureAudioPush", false, bhep.a(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public static void c(int paramInt, Object paramObject)
  {
    bhep.a(paramObject, "setMaxVideoBitrate", false, bhep.a(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static void c(boolean paramBoolean, Object paramObject)
  {
    bhep.a(paramObject, "setFrontCamera", false, bhep.a(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public static void d(int paramInt, Object paramObject)
  {
    bhep.a(paramObject, "setPauseFlag", false, bhep.a(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static void d(boolean paramBoolean, Object paramObject)
  {
    bhep.a(paramObject, "setTouchFocus", false, bhep.a(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public static void e(int paramInt, Object paramObject)
  {
    bhep.a(paramObject, "setVideoResolution", false, bhep.a(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static void e(boolean paramBoolean, Object paramObject)
  {
    bhep.a(paramObject, "enableAGC", false, bhep.a(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public static void f(int paramInt, Object paramObject)
  {
    bhep.a(paramObject, "setVideoEncodeGop", false, bhep.a(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static void f(boolean paramBoolean, Object paramObject)
  {
    bhep.a(paramObject, "enableANS", false, bhep.a(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public static void g(int paramInt, Object paramObject)
  {
    bhep.a(paramObject, "setAudioSampleRate", false, bhep.a(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static void g(boolean paramBoolean, Object paramObject)
  {
    bhep.a(paramObject, "enableAudioEarMonitoring", false, bhep.a(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public static void h(int paramInt, Object paramObject)
  {
    bhep.a(paramObject, "setVolumeType", false, bhep.a(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhhh
 * JD-Core Version:    0.7.0.1
 */