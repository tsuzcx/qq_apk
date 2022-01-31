import android.content.Context;

public class bhhi
{
  public static int a(String paramString, Object paramObject)
  {
    paramString = (Integer)bhep.a(paramObject, "startDumpAudioData", false, bhep.a(new Class[] { String.class }), new Object[] { paramString });
    if (paramString != null) {
      return paramString.intValue();
    }
    return -10;
  }
  
  public static Object a(Context paramContext)
  {
    return bhep.a("com.tencent.rtmp.WXLivePusher", bhep.a(new Class[] { Context.class }), new Object[] { paramContext });
  }
  
  public static void a(float paramFloat, Object paramObject)
  {
    bhep.a(paramObject, "setMicVolume", false, bhep.a(new Class[] { Float.TYPE }), new Object[] { Float.valueOf(paramFloat) });
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Object paramObject)
  {
    bhep.a(paramObject, "setBeautyFilter", false, bhep.a(new Class[] { Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE }), new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
  }
  
  public static void a(int paramInt, Object paramObject)
  {
    bhep.a(paramObject, "setBGMPosition", false, bhep.a(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, Object paramObject)
  {
    bhep.a(paramObject, "setVideoQuality", false, bhep.a(new Class[] { Integer.TYPE, Boolean.TYPE, Boolean.TYPE }), new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
  }
  
  public static void a(Object paramObject)
  {
    bhep.a(paramObject, "stopPusher", false, null, new Object[0]);
  }
  
  public static void a(Object paramObject1, Object paramObject2)
  {
    try
    {
      bhep.a(paramObject2, "setConfig", false, bhep.a(new Class[] { Class.forName("com.tencent.rtmp.WXLivePushConfig") }), new Object[] { paramObject1 });
      return;
    }
    catch (ClassNotFoundException paramObject1)
    {
      paramObject1.printStackTrace();
    }
  }
  
  public static void a(String paramString, Object paramObject)
  {
    bhep.a(paramObject, "setPusherUrl", false, bhep.a(new Class[] { String.class }), new Object[] { paramString });
  }
  
  public static void a(boolean paramBoolean, Object paramObject)
  {
    bhep.a(paramObject, "setMute", false, bhep.a(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public static boolean a(float paramFloat, Object paramObject)
  {
    paramObject = bhep.a(paramObject, "setBGMVolume", false, bhep.a(new Class[] { Float.TYPE }), new Object[] { Float.valueOf(paramFloat) });
    return ((paramObject instanceof Boolean)) && (((Boolean)paramObject).booleanValue());
  }
  
  public static boolean a(Object paramObject)
  {
    paramObject = bhep.a(paramObject, "stopBGM", false, null, new Object[0]);
    return ((paramObject instanceof Boolean)) && (((Boolean)paramObject).booleanValue());
  }
  
  public static boolean a(String paramString, Object paramObject)
  {
    paramString = bhep.a(paramObject, "startPusher", false, bhep.a(new Class[] { String.class }), new Object[] { paramString });
    return ((paramString instanceof Integer)) && (((Integer)paramString).intValue() == 0);
  }
  
  public static boolean a(boolean paramBoolean, Object paramObject)
  {
    paramObject = (Boolean)bhep.a(paramObject, "turnOnFlashLight", false, bhep.a(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramObject != null) {
      return paramObject.booleanValue();
    }
    return false;
  }
  
  public static boolean a(byte[] paramArrayOfByte, Object paramObject)
  {
    paramArrayOfByte = (Boolean)bhep.a(paramObject, "sendMessageEx", false, bhep.a(new Class[] { [B.class }), new Object[] { paramArrayOfByte });
    if (paramArrayOfByte != null) {
      return paramArrayOfByte.booleanValue();
    }
    return false;
  }
  
  public static void b(int paramInt, Object paramObject)
  {
    bhep.a(paramObject, "setRenderRotation", false, bhep.a(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static void b(Object paramObject)
  {
    bhep.a(paramObject, "resumePusher", false, null, new Object[0]);
  }
  
  public static void b(Object paramObject1, Object paramObject2)
  {
    bhep.a(paramObject2, "startCameraPreview", false, bhep.a(new Class[] { paramObject1.getClass() }), new Object[] { paramObject1 });
  }
  
  public static void b(boolean paramBoolean, Object paramObject)
  {
    bhep.a(paramObject, "setMirror", false, bhep.a(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public static boolean b(Object paramObject)
  {
    paramObject = bhep.a(paramObject, "pauseBGM", false, null, new Object[0]);
    return ((paramObject instanceof Boolean)) && (((Boolean)paramObject).booleanValue());
  }
  
  public static boolean b(String paramString, Object paramObject)
  {
    paramString = bhep.a(paramObject, "playBGM", false, bhep.a(new Class[] { String.class }), new Object[] { paramString });
    return ((paramString instanceof Boolean)) && (((Boolean)paramString).booleanValue());
  }
  
  public static void c(int paramInt, Object paramObject)
  {
    bhep.a(paramObject, "setLocalVideoMirrorType", false, bhep.a(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static void c(Object paramObject)
  {
    bhep.a(paramObject, "pausePusher", false, null, new Object[0]);
  }
  
  public static void c(Object paramObject1, Object paramObject2)
  {
    try
    {
      bhep.a(paramObject2, "snapshot", false, bhep.a(new Class[] { Class.forName("com.tencent.rtmp.TXLivePusher$ITXSnapshotListener") }), new Object[] { paramObject1 });
      return;
    }
    catch (ClassNotFoundException paramObject1)
    {
      paramObject1.printStackTrace();
    }
  }
  
  public static void c(boolean paramBoolean, Object paramObject)
  {
    bhep.a(paramObject, "stopCameraPreview", false, bhep.a(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public static boolean c(Object paramObject)
  {
    paramObject = bhep.a(paramObject, "resumeBGM", false, null, new Object[0]);
    return ((paramObject instanceof Boolean)) && (((Boolean)paramObject).booleanValue());
  }
  
  public static void d(int paramInt, Object paramObject)
  {
    bhep.a(paramObject, "setReverb", false, bhep.a(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static void d(Object paramObject)
  {
    bhep.a(paramObject, "switchCamera", false, null, new Object[0]);
  }
  
  public static void d(Object paramObject1, Object paramObject2)
  {
    try
    {
      bhep.a(paramObject2, "setPushListener", false, bhep.a(new Class[] { Class.forName("com.tencent.rtmp.ITXLivePushListener") }), new Object[] { paramObject1 });
      return;
    }
    catch (ClassNotFoundException paramObject1)
    {
      paramObject1.printStackTrace();
    }
  }
  
  public static void d(boolean paramBoolean, Object paramObject)
  {
    bhep.a(paramObject, "showDebugLog", false, bhep.a(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public static boolean d(Object paramObject)
  {
    paramObject = (Boolean)bhep.a(paramObject, "isPushing", false, null, new Object[0]);
    if (paramObject != null) {
      return paramObject.booleanValue();
    }
    return false;
  }
  
  public static void e(Object paramObject)
  {
    bhep.a(paramObject, "stopDumpAudioData", false, null, new Object[0]);
  }
  
  public static void e(Object paramObject1, Object paramObject2)
  {
    try
    {
      bhep.a(paramObject2, "setBGMNofify", false, bhep.a(new Class[] { Class.forName("com.tencent.rtmp.TXLivePusher$OnBGMNotify") }), new Object[] { paramObject1 });
      return;
    }
    catch (ClassNotFoundException paramObject1)
    {
      paramObject1.printStackTrace();
    }
  }
  
  public static void f(Object paramObject)
  {
    bhep.a(paramObject, "startAudioRecord", false, null, new Object[0]);
  }
  
  public static void g(Object paramObject)
  {
    bhep.a(paramObject, "stopAudioRecord", false, null, new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhhi
 * JD-Core Version:    0.7.0.1
 */