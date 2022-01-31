package com.tencent.kapalaiadapter;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.Notification.Builder;
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
import com.tencent.TMG.utils.QLog;
import com.tencent.kapalaiadapter.sdcardmountinforutil.SDCardMountInforUtil;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class KapalaiAdapterUtil
{
  public int editTextSetSelectionIndex = 0;
  
  public static KapalaiAdapterUtil getKAUInstance()
  {
    return KAUHolder.kauInstance;
  }
  
  private Camera tryCoolpadFrontCamera()
  {
    Object localObject2 = null;
    try
    {
      localObject1 = Camera.open();
      Camera.Parameters localParameters;
      if ((localObject1 != null) && (localObject1 == null)) {
        break label57;
      }
      ((Camera)localObject1).release();
    }
    catch (Exception localException1)
    {
      try
      {
        localParameters = ((Camera)localObject1).getParameters();
        if (localParameters != null)
        {
          localParameters.set("device", "/dev/video1");
          ((Camera)localObject1).setParameters(localParameters);
        }
        return localObject1;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Object localObject1;
        }
      }
      localException1 = localException1;
      localObject1 = null;
    }
    localObject1 = localObject2;
    localException1.printStackTrace();
    return localObject1;
  }
  
  private Camera tryHTCFrontCamera()
  {
    Object localObject2 = null;
    try
    {
      localObject1 = Camera.open();
      Camera.Parameters localParameters;
      if ((localObject1 != null) && (localObject1 == null)) {
        break label57;
      }
      ((Camera)localObject1).release();
    }
    catch (Exception localException1)
    {
      try
      {
        localParameters = ((Camera)localObject1).getParameters();
        if (localParameters != null)
        {
          localParameters.set("video_input", "secondary");
          ((Camera)localObject1).setParameters(localParameters);
        }
        return localObject1;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Object localObject1;
        }
      }
      localException1 = localException1;
      localObject1 = null;
    }
    localObject1 = localObject2;
    localException1.printStackTrace();
    return localObject1;
  }
  
  private Camera tryHisenseFrontCamera()
  {
    Object localObject2 = null;
    try
    {
      localObject1 = Camera.open();
      Method localMethod;
      if ((localObject1 != null) && (localObject1 == null)) {
        break label76;
      }
      ((Camera)localObject1).release();
    }
    catch (Exception localException1)
    {
      try
      {
        localMethod = localObject1.getClass().getMethod("setSensorID", new Class[] { Integer.TYPE });
        if (localMethod != null) {
          localMethod.invoke(localObject1, new Object[] { Integer.valueOf(1) });
        }
        return localObject1;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Object localObject1;
        }
      }
      localException1 = localException1;
      localObject1 = null;
    }
    localObject1 = localObject2;
    localException1.printStackTrace();
    return localObject1;
  }
  
  private Camera tryHuaweiFrontCamera()
  {
    Camera localCamera = null;
    try
    {
      Class localClass = Class.forName("android.hardware.Camera");
      Method localMethod = localClass.getMethod("setCurrentCamera", new Class[] { Integer.TYPE });
      if (localMethod != null)
      {
        localMethod.invoke(localClass, new Object[] { Integer.valueOf(1) });
        localCamera = Camera.open();
      }
      return localCamera;
    }
    catch (Exception localException)
    {
      if (0 != 0) {
        throw new NullPointerException();
      }
      localException.printStackTrace();
    }
    return null;
  }
  
  @TargetApi(9)
  private Camera tryLenovoFrontCamera()
  {
    Camera localCamera = null;
    try
    {
      if (Build.VERSION.SDK_INT >= 9) {
        localCamera = Camera.open();
      }
      return localCamera;
    }
    catch (Exception localException)
    {
      if (0 != 0) {
        throw new NullPointerException();
      }
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
    if ((localArrayList1 == null) || (localArrayList1.size() < 1)) {
      return null;
    }
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
  
  @TargetApi(16)
  public Notification newNotificationForMeizu(Context paramContext, int paramInt)
  {
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT < 11)
        {
          paramContext = new Notification(paramInt, null, System.currentTimeMillis());
          localObject = paramContext;
          if (paramContext == null) {
            localObject = new Notification(paramInt, null, System.currentTimeMillis());
          }
          return localObject;
        }
        paramContext = new Notification.Builder(paramContext);
        Object localObject = Class.forName("android.app.Notification$Builder").getDeclaredMethod("setInternalApp", new Class[] { Integer.TYPE });
        if (localObject != null)
        {
          ((Method)localObject).invoke(paramContext, new Object[] { Integer.valueOf(1) });
          if (Build.VERSION.SDK_INT >= 16)
          {
            paramContext = paramContext.build();
            continue;
          }
          if ((Build.VERSION.SDK_INT < 16) && (Build.VERSION.SDK_INT >= 11))
          {
            paramContext = paramContext.getNotification();
            continue;
            return null;
          }
        }
      }
      catch (Exception paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.e("newNotificationForMeizu", 0, paramContext.getMessage());
        }
        if (0 == 0) {
          return new Notification(paramInt, null, System.currentTimeMillis());
        }
      }
      finally
      {
        if (0 == 0) {
          new Notification(paramInt, null, System.currentTimeMillis());
        }
      }
      paramContext = null;
    }
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
    String str = "off";
    List localList = paramParameters.getSupportedFlashModes();
    if (localList.contains("torch")) {
      paramParameters = "torch";
    }
    do
    {
      return paramParameters;
      if (localList.contains("on")) {
        return "on";
      }
      paramParameters = str;
    } while (!localList.contains("auto"));
    return "auto";
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
    Camera localCamera = null;
    if (Build.MANUFACTURER.equalsIgnoreCase("HTC")) {
      localCamera = tryHTCFrontCamera();
    }
    do
    {
      return localCamera;
      if (Build.MANUFACTURER.equalsIgnoreCase("YuLong")) {
        return tryCoolpadFrontCamera();
      }
      if (Build.MANUFACTURER.equalsIgnoreCase("HISENSE")) {
        return tryHisenseFrontCamera();
      }
      if (Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) {
        return tryHuaweiFrontCamera();
      }
    } while (!Build.MANUFACTURER.equalsIgnoreCase("LENOVO"));
    return tryLenovoFrontCamera();
  }
  
  private static class KAUHolder
  {
    public static final KapalaiAdapterUtil kauInstance = new KapalaiAdapterUtil(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.kapalaiadapter.KapalaiAdapterUtil
 * JD-Core Version:    0.7.0.1
 */