package com.tencent.kapalaiadapter;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Build;
import android.os.Build.VERSION;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.EditText;
import com.tencent.kapalaiadapter.sdcardmountinforutil.SDCardMountInforUtil;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class KapalaiAdapterUtil
{
  public int editTextSetSelectionIndex = 0;
  
  public static KapalaiAdapterUtil getKAUInstance()
  {
    return KapalaiAdapterUtil.KAUHolder.kauInstance;
  }
  
  private Camera tryCoolpadFrontCamera()
  {
    Camera localCamera1;
    Camera localCamera2;
    try
    {
      localCamera1 = Camera.open();
      localCamera2 = localCamera1;
      if (localCamera1 == null) {
        return localCamera2;
      }
      try
      {
        Camera.Parameters localParameters = localCamera1.getParameters();
        localCamera2 = localCamera1;
        if (localParameters == null) {
          return localCamera2;
        }
        localParameters.set("device", "/dev/video1");
        localCamera1.setParameters(localParameters);
        return localCamera1;
      }
      catch (Exception localException1) {}
      localCamera2 = localCamera1;
    }
    catch (Exception localException2)
    {
      localCamera1 = null;
    }
    if (localCamera1 != null)
    {
      localCamera1.release();
      localCamera2 = null;
    }
    localException2.printStackTrace();
    return localCamera2;
  }
  
  private Camera tryHTCFrontCamera()
  {
    Camera localCamera1;
    Camera localCamera2;
    try
    {
      localCamera1 = Camera.open();
      localCamera2 = localCamera1;
      if (localCamera1 == null) {
        return localCamera2;
      }
      try
      {
        Camera.Parameters localParameters = localCamera1.getParameters();
        localCamera2 = localCamera1;
        if (localParameters == null) {
          return localCamera2;
        }
        localParameters.set("video_input", "secondary");
        localCamera1.setParameters(localParameters);
        return localCamera1;
      }
      catch (Exception localException1) {}
      localCamera2 = localCamera1;
    }
    catch (Exception localException2)
    {
      localCamera1 = null;
    }
    if (localCamera1 != null)
    {
      localCamera1.release();
      localCamera2 = null;
    }
    localException2.printStackTrace();
    return localCamera2;
  }
  
  private Camera tryHisenseFrontCamera()
  {
    Camera localCamera1;
    Camera localCamera2;
    try
    {
      localCamera1 = Camera.open();
      localCamera2 = localCamera1;
      if (localCamera1 == null) {
        return localCamera2;
      }
      try
      {
        Method localMethod = localCamera1.getClass().getMethod("setSensorID", new Class[] { Integer.TYPE });
        localCamera2 = localCamera1;
        if (localMethod == null) {
          return localCamera2;
        }
        localMethod.invoke(localCamera1, new Object[] { Integer.valueOf(1) });
        return localCamera1;
      }
      catch (Exception localException1) {}
      localCamera2 = localCamera1;
    }
    catch (Exception localException2)
    {
      localCamera1 = null;
    }
    if (localCamera1 != null)
    {
      localCamera1.release();
      localCamera2 = null;
    }
    localException2.printStackTrace();
    return localCamera2;
  }
  
  private Camera tryHuaweiFrontCamera()
  {
    try
    {
      Object localObject = Class.forName("android.hardware.Camera");
      Method localMethod = ((Class)localObject).getMethod("setCurrentCamera", new Class[] { Integer.TYPE });
      if (localMethod != null)
      {
        localMethod.invoke(localObject, new Object[] { Integer.valueOf(1) });
        localObject = Camera.open();
        return localObject;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  @TargetApi(9)
  private Camera tryLenovoFrontCamera()
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 9)
      {
        Camera localCamera = Camera.open();
        return localCamera;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public Bitmap createScaledBitmapByConfig(Bitmap paramBitmap, int paramInt)
  {
    if (paramBitmap != null) {
      return Bitmap.createScaledBitmap(paramBitmap, paramInt, paramInt, true);
    }
    return null;
  }
  
  public ArrayList<String> getAllExSDCardMountPaths(Context paramContext)
  {
    ArrayList localArrayList1 = getAllPath(paramContext);
    if ((localArrayList1 != null) && (localArrayList1.size() >= 1))
    {
      ArrayList localArrayList2 = new ArrayList();
      int i = 0;
      while (i < localArrayList1.size())
      {
        String str = (String)localArrayList1.get(i);
        if (SDCardMountInforUtil.getSelf(paramContext).isExSdcard(str)) {
          localArrayList2.add(str);
        }
        i += 1;
      }
      return localArrayList2;
    }
    return null;
  }
  
  public ArrayList<String> getAllPath(Context paramContext)
  {
    return SDCardMountInforUtil.getSelf(paramContext).getAllPath();
  }
  
  public int getEditTextSetSelectionIndex()
  {
    return this.editTextSetSelectionIndex;
  }
  
  public int getNumberOfCamera()
  {
    return 1;
  }
  
  public boolean isExSDCardPath(Context paramContext, String paramString)
  {
    return SDCardMountInforUtil.getSelf(paramContext).isExSdcard(paramString);
  }
  
  public boolean isSupportedFlashModesByKapalai(Camera.Parameters paramParameters, Context paramContext)
  {
    return (paramParameters.getSupportedFlashModes() != null) && (paramContext.getPackageManager().hasSystemFeature("android.hardware.camera.flash")) && (paramParameters.getSupportedFlashModes().size() > 1);
  }
  
  /* Error */
  @TargetApi(16)
  public android.app.Notification newNotificationForMeizu(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: getstatic 108	android/os/Build$VERSION:SDK_INT	I
    //   3: bipush 11
    //   5: if_icmpge +19 -> 24
    //   8: new 185	android/app/Notification
    //   11: dup
    //   12: iload_2
    //   13: aconst_null
    //   14: invokestatic 191	java/lang/System:currentTimeMillis	()J
    //   17: invokespecial 194	android/app/Notification:<init>	(ILjava/lang/CharSequence;J)V
    //   20: astore_1
    //   21: goto +96 -> 117
    //   24: new 196	android/app/Notification$Builder
    //   27: dup
    //   28: aload_1
    //   29: invokespecial 199	android/app/Notification$Builder:<init>	(Landroid/content/Context;)V
    //   32: astore_1
    //   33: ldc 201
    //   35: invokestatic 97	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   38: ldc 203
    //   40: iconst_1
    //   41: anewarray 70	java/lang/Class
    //   44: dup
    //   45: iconst_0
    //   46: getstatic 76	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   49: aastore
    //   50: invokevirtual 206	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   53: astore_3
    //   54: aload_3
    //   55: ifnull +60 -> 115
    //   58: aload_3
    //   59: aload_1
    //   60: iconst_1
    //   61: anewarray 4	java/lang/Object
    //   64: dup
    //   65: iconst_0
    //   66: iconst_1
    //   67: invokestatic 84	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   70: aastore
    //   71: invokevirtual 90	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   74: pop
    //   75: getstatic 108	android/os/Build$VERSION:SDK_INT	I
    //   78: bipush 16
    //   80: if_icmplt +11 -> 91
    //   83: aload_1
    //   84: invokevirtual 210	android/app/Notification$Builder:build	()Landroid/app/Notification;
    //   87: astore_1
    //   88: goto +29 -> 117
    //   91: getstatic 108	android/os/Build$VERSION:SDK_INT	I
    //   94: bipush 16
    //   96: if_icmpge +19 -> 115
    //   99: getstatic 108	android/os/Build$VERSION:SDK_INT	I
    //   102: bipush 11
    //   104: if_icmplt +11 -> 115
    //   107: aload_1
    //   108: invokevirtual 213	android/app/Notification$Builder:getNotification	()Landroid/app/Notification;
    //   111: astore_1
    //   112: goto +5 -> 117
    //   115: aconst_null
    //   116: astore_1
    //   117: aload_1
    //   118: astore_3
    //   119: aload_1
    //   120: ifnonnull +50 -> 170
    //   123: new 185	android/app/Notification
    //   126: dup
    //   127: iload_2
    //   128: aconst_null
    //   129: invokestatic 191	java/lang/System:currentTimeMillis	()J
    //   132: invokespecial 194	android/app/Notification:<init>	(ILjava/lang/CharSequence;J)V
    //   135: areturn
    //   136: astore_1
    //   137: goto +35 -> 172
    //   140: astore_1
    //   141: invokestatic 219	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   144: ifeq +13 -> 157
    //   147: ldc 220
    //   149: iconst_0
    //   150: aload_1
    //   151: invokevirtual 224	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   154: invokestatic 228	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   157: new 185	android/app/Notification
    //   160: dup
    //   161: iload_2
    //   162: aconst_null
    //   163: invokestatic 191	java/lang/System:currentTimeMillis	()J
    //   166: invokespecial 194	android/app/Notification:<init>	(ILjava/lang/CharSequence;J)V
    //   169: astore_3
    //   170: aload_3
    //   171: areturn
    //   172: new 185	android/app/Notification
    //   175: dup
    //   176: iload_2
    //   177: aconst_null
    //   178: invokestatic 191	java/lang/System:currentTimeMillis	()J
    //   181: invokespecial 194	android/app/Notification:<init>	(ILjava/lang/CharSequence;J)V
    //   184: pop
    //   185: aload_1
    //   186: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	187	0	this	KapalaiAdapterUtil
    //   0	187	1	paramContext	Context
    //   0	187	2	paramInt	int
    //   53	118	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	21	136	finally
    //   24	54	136	finally
    //   58	88	136	finally
    //   91	112	136	finally
    //   141	157	136	finally
    //   0	21	140	java/lang/Exception
    //   24	54	140	java/lang/Exception
    //   58	88	140	java/lang/Exception
    //   91	112	140	java/lang/Exception
  }
  
  public void setActivityWindowType_TYPE_APPLICATION(Window paramWindow)
  {
    paramWindow.setType(2);
  }
  
  public void setActivityWindowType_TYPE_KEYGUARD(Window paramWindow)
  {
    paramWindow.setType(2004);
  }
  
  public void setEditTextSetSelection(EditText paramEditText)
  {
    if (paramEditText != null) {
      paramEditText.setSelection(this.editTextSetSelectionIndex);
    }
  }
  
  public void setEditTextSetSelectionIndex(int paramInt)
  {
    this.editTextSetSelectionIndex = paramInt;
  }
  
  public String setFlashMode_TORCH(Camera.Parameters paramParameters)
  {
    paramParameters = paramParameters.getSupportedFlashModes();
    if (paramParameters.contains("torch")) {
      return "torch";
    }
    if (paramParameters.contains("on")) {
      return "on";
    }
    if (paramParameters.contains("auto")) {
      return "auto";
    }
    return "off";
  }
  
  public void setScreenBrightness(WindowManager.LayoutParams paramLayoutParams)
  {
    paramLayoutParams.screenBrightness = 0.035F;
  }
  
  public void setShortcutIntentFlag(Intent paramIntent)
  {
    paramIntent.setFlags(337641472);
  }
  
  public Camera tryGetFrontCamera()
  {
    if (Build.MANUFACTURER.equalsIgnoreCase("HTC")) {
      return tryHTCFrontCamera();
    }
    if (Build.MANUFACTURER.equalsIgnoreCase("YuLong")) {
      return tryCoolpadFrontCamera();
    }
    if (Build.MANUFACTURER.equalsIgnoreCase("HISENSE")) {
      return tryHisenseFrontCamera();
    }
    if (Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) {
      return tryHuaweiFrontCamera();
    }
    if (Build.MANUFACTURER.equalsIgnoreCase("LENOVO")) {
      return tryLenovoFrontCamera();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.kapalaiadapter.KapalaiAdapterUtil
 * JD-Core Version:    0.7.0.1
 */