import android.content.Context;

public class bhlp
{
  public static int a(String paramString, Object paramObject)
  {
    paramString = (Integer)bhiw.a(paramObject, "startDumpAudioData", false, bhiw.a(new Class[] { String.class }), new Object[] { paramString });
    if (paramString != null) {
      return paramString.intValue();
    }
    return -10;
  }
  
  public static Object a(Context paramContext)
  {
    return bhiw.a("com.tencent.rtmp.WXLivePusher", bhiw.a(new Class[] { Context.class }), new Object[] { paramContext });
  }
  
  public static void a(float paramFloat, Object paramObject)
  {
    bhiw.a(paramObject, "setMicVolume", false, bhiw.a(new Class[] { Float.TYPE }), new Object[] { Float.valueOf(paramFloat) });
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Object paramObject)
  {
    bhiw.a(paramObject, "setBeautyFilter", false, bhiw.a(new Class[] { Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE }), new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
  }
  
  public static void a(int paramInt, Object paramObject)
  {
    bhiw.a(paramObject, "setBGMPosition", false, bhiw.a(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, Object paramObject)
  {
    bhiw.a(paramObject, "setVideoQuality", false, bhiw.a(new Class[] { Integer.TYPE, Boolean.TYPE, Boolean.TYPE }), new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
  }
  
  public static void a(Object paramObject)
  {
    bhiw.a(paramObject, "stopPusher", false, null, new Object[0]);
  }
  
  public static void a(Object paramObject1, Object paramObject2)
  {
    try
    {
      bhiw.a(paramObject2, "setConfig", false, bhiw.a(new Class[] { Class.forName("com.tencent.rtmp.WXLivePushConfig") }), new Object[] { paramObject1 });
      return;
    }
    catch (ClassNotFoundException paramObject1)
    {
      paramObject1.printStackTrace();
    }
  }
  
  public static void a(String paramString, Object paramObject)
  {
    bhiw.a(paramObject, "setPusherUrl", false, bhiw.a(new Class[] { String.class }), new Object[] { paramString });
  }
  
  public static void a(boolean paramBoolean, Object paramObject)
  {
    bhiw.a(paramObject, "setMute", false, bhiw.a(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public static boolean a(float paramFloat, Object paramObject)
  {
    paramObject = bhiw.a(paramObject, "setBGMVolume", false, bhiw.a(new Class[] { Float.TYPE }), new Object[] { Float.valueOf(paramFloat) });
    return ((paramObject instanceof Boolean)) && (((Boolean)paramObject).booleanValue());
  }
  
  public static boolean a(Object paramObject)
  {
    paramObject = bhiw.a(paramObject, "stopBGM", false, null, new Object[0]);
    return ((paramObject instanceof Boolean)) && (((Boolean)paramObject).booleanValue());
  }
  
  public static boolean a(String paramString, Object paramObject)
  {
    paramString = bhiw.a(paramObject, "startPusher", false, bhiw.a(new Class[] { String.class }), new Object[] { paramString });
    return ((paramString instanceof Integer)) && (((Integer)paramString).intValue() == 0);
  }
  
  public static boolean a(boolean paramBoolean, Object paramObject)
  {
    paramObject = (Boolean)bhiw.a(paramObject, "turnOnFlashLight", false, bhiw.a(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramObject != null) {
      return paramObject.booleanValue();
    }
    return false;
  }
  
  public static boolean a(byte[] paramArrayOfByte, Object paramObject)
  {
    paramArrayOfByte = (Boolean)bhiw.a(paramObject, "sendMessageEx", false, bhiw.a(new Class[] { [B.class }), new Object[] { paramArrayOfByte });
    if (paramArrayOfByte != null) {
      return paramArrayOfByte.booleanValue();
    }
    return false;
  }
  
  public static void b(int paramInt, Object paramObject)
  {
    bhiw.a(paramObject, "setRenderRotation", false, bhiw.a(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static void b(Object paramObject)
  {
    bhiw.a(paramObject, "resumePusher", false, null, new Object[0]);
  }
  
  public static void b(Object paramObject1, Object paramObject2)
  {
    bhiw.a(paramObject2, "startCameraPreview", false, bhiw.a(new Class[] { paramObject1.getClass() }), new Object[] { paramObject1 });
  }
  
  public static void b(boolean paramBoolean, Object paramObject)
  {
    bhiw.a(paramObject, "setMirror", false, bhiw.a(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public static boolean b(Object paramObject)
  {
    paramObject = bhiw.a(paramObject, "pauseBGM", false, null, new Object[0]);
    return ((paramObject instanceof Boolean)) && (((Boolean)paramObject).booleanValue());
  }
  
  public static boolean b(String paramString, Object paramObject)
  {
    paramString = bhiw.a(paramObject, "playBGM", false, bhiw.a(new Class[] { String.class }), new Object[] { paramString });
    return ((paramString instanceof Boolean)) && (((Boolean)paramString).booleanValue());
  }
  
  public static void c(int paramInt, Object paramObject)
  {
    bhiw.a(paramObject, "setLocalVideoMirrorType", false, bhiw.a(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static void c(Object paramObject)
  {
    bhiw.a(paramObject, "pausePusher", false, null, new Object[0]);
  }
  
  public static void c(Object paramObject1, Object paramObject2)
  {
    try
    {
      bhiw.a(paramObject2, "snapshot", false, bhiw.a(new Class[] { Class.forName("com.tencent.rtmp.TXLivePusher$ITXSnapshotListener") }), new Object[] { paramObject1 });
      return;
    }
    catch (ClassNotFoundException paramObject1)
    {
      paramObject1.printStackTrace();
    }
  }
  
  public static void c(boolean paramBoolean, Object paramObject)
  {
    bhiw.a(paramObject, "stopCameraPreview", false, bhiw.a(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public static boolean c(Object paramObject)
  {
    paramObject = bhiw.a(paramObject, "resumeBGM", false, null, new Object[0]);
    return ((paramObject instanceof Boolean)) && (((Boolean)paramObject).booleanValue());
  }
  
  public static void d(int paramInt, Object paramObject)
  {
    bhiw.a(paramObject, "setReverb", false, bhiw.a(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static void d(Object paramObject)
  {
    bhiw.a(paramObject, "switchCamera", false, null, new Object[0]);
  }
  
  public static void d(Object paramObject1, Object paramObject2)
  {
    try
    {
      bhiw.a(paramObject2, "setPushListener", false, bhiw.a(new Class[] { Class.forName("com.tencent.rtmp.ITXLivePushListener") }), new Object[] { paramObject1 });
      return;
    }
    catch (ClassNotFoundException paramObject1)
    {
      paramObject1.printStackTrace();
    }
  }
  
  public static void d(boolean paramBoolean, Object paramObject)
  {
    bhiw.a(paramObject, "showDebugLog", false, bhiw.a(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public static boolean d(Object paramObject)
  {
    paramObject = (Boolean)bhiw.a(paramObject, "isPushing", false, null, new Object[0]);
    if (paramObject != null) {
      return paramObject.booleanValue();
    }
    return false;
  }
  
  public static void e(Object paramObject)
  {
    bhiw.a(paramObject, "stopDumpAudioData", false, null, new Object[0]);
  }
  
  public static void e(Object paramObject1, Object paramObject2)
  {
    try
    {
      bhiw.a(paramObject2, "setBGMNofify", false, bhiw.a(new Class[] { Class.forName("com.tencent.rtmp.TXLivePusher$OnBGMNotify") }), new Object[] { paramObject1 });
      return;
    }
    catch (ClassNotFoundException paramObject1)
    {
      paramObject1.printStackTrace();
    }
  }
  
  public static void f(Object paramObject)
  {
    bhiw.a(paramObject, "startAudioRecord", false, null, new Object[0]);
  }
  
  public static void g(Object paramObject)
  {
    bhiw.a(paramObject, "stopAudioRecord", false, null, new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhlp
 * JD-Core Version:    0.7.0.1
 */