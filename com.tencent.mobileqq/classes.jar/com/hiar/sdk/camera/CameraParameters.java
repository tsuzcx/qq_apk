package com.hiar.sdk.camera;

import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.mobileqq.ar.ScanEntranceDPC;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CameraParameters
{
  private static Method a;
  private static Method b;
  
  static {}
  
  public static int a(List<Integer> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (((Integer)paramList.next()).intValue() == 17) {
        return 17;
      }
    }
    return -1;
  }
  
  public static Camera.Size a(List<Camera.Size> paramList, int paramInt1, int paramInt2)
  {
    Object localObject1 = null;
    if (paramList == null) {
      return null;
    }
    Object localObject2 = paramList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Camera.Size)((Iterator)localObject2).next();
      if ((((Camera.Size)localObject3).width == paramInt1) && (((Camera.Size)localObject3).height == paramInt2)) {
        return localObject3;
      }
    }
    double d1 = paramInt1;
    double d2 = paramInt2;
    Double.isNaN(d1);
    Double.isNaN(d2);
    double d5 = d1 / d2;
    Object localObject3 = paramList.iterator();
    double d4 = 1.7976931348623157E+308D;
    d1 = 1.7976931348623157E+308D;
    while (((Iterator)localObject3).hasNext())
    {
      localObject2 = (Camera.Size)((Iterator)localObject3).next();
      double d3;
      if (((paramInt1 > paramInt2) && (((Camera.Size)localObject2).width > ((Camera.Size)localObject2).height)) || ((paramInt1 < paramInt2) && (((Camera.Size)localObject2).width < ((Camera.Size)localObject2).height)))
      {
        d2 = ((Camera.Size)localObject2).width;
        d3 = ((Camera.Size)localObject2).height;
        Double.isNaN(d2);
        Double.isNaN(d3);
      }
      else
      {
        d2 = ((Camera.Size)localObject2).height;
        d3 = ((Camera.Size)localObject2).width;
        Double.isNaN(d2);
        Double.isNaN(d3);
      }
      if ((Math.abs(d2 / d3 - d5) <= 0.05D) && (Math.abs(((Camera.Size)localObject2).height - paramInt2) < d1))
      {
        d1 = Math.abs(((Camera.Size)localObject2).height - paramInt2);
        localObject1 = localObject2;
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject3 = paramList.iterator();
      d1 = d4;
      for (;;)
      {
        localObject2 = localObject1;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        paramList = (Camera.Size)((Iterator)localObject3).next();
        if (Math.abs(paramList.height - paramInt2) < d1)
        {
          d1 = Math.abs(paramList.height - paramInt2);
          localObject1 = paramList;
        }
      }
    }
    return localObject2;
  }
  
  private static void a()
  {
    try
    {
      b = Camera.Parameters.class.getMethod("getSupportedPreviewSizes", (Class[])null);
    }
    catch (NoSuchMethodException localNoSuchMethodException1)
    {
      for (;;)
      {
        try
        {
          a = Camera.Parameters.class.getMethod("getSupportedPreviewFormats", (Class[])null);
          return;
        }
        catch (NoSuchMethodException localNoSuchMethodException2) {}
        localNoSuchMethodException1 = localNoSuchMethodException1;
      }
    }
  }
  
  public static void a(Camera.Parameters paramParameters)
  {
    for (String str = "continuous-video";; str = null)
    {
      try
      {
        List localList = paramParameters.getSupportedFocusModes();
        boolean bool = localList.contains("continuous-video");
        if ((!bool) || (!ScanEntranceDPC.a().b))
        {
          if (!localList.contains("auto")) {
            continue;
          }
          str = "auto";
        }
        if (QLog.isColorLevel()) {
          QLog.d("CameraParameters", 2, String.format("setDefaultFocusMode focusMode=%s", new Object[] { str }));
        }
        if (!TextUtils.isEmpty(str))
        {
          paramParameters.setFocusMode(str);
          return;
        }
      }
      catch (RuntimeException paramParameters)
      {
        paramParameters.printStackTrace();
      }
      return;
    }
  }
  
  private static void a(Camera.Parameters paramParameters, int paramInt)
  {
    try
    {
      paramInt = Math.max(paramInt, 0);
      if (paramParameters.isZoomSupported()) {
        paramParameters.setZoom(Math.min(paramInt, paramParameters.getMaxZoom()));
      }
      return;
    }
    catch (Exception paramParameters) {}
  }
  
  public static void a(Camera paramCamera, int paramInt1, int paramInt2)
  {
    a(paramCamera, paramInt1, paramInt2, 2);
  }
  
  public static void a(Camera paramCamera, int paramInt1, int paramInt2, int paramInt3)
  {
    Camera.Parameters localParameters = paramCamera.getParameters();
    Object localObject1 = b;
    if (localObject1 != null) {
      try
      {
        localObject1 = ((Method)localObject1).invoke(localParameters, (Object[])null);
        if ((localObject1 instanceof List))
        {
          List localList = (List)localObject1;
          localObject1 = new ArrayList();
          Object localObject3 = localList.iterator();
          Camera.Size localSize;
          for (;;)
          {
            boolean bool = ((Iterator)localObject3).hasNext();
            if (!bool) {
              break;
            }
            localSize = (Camera.Size)((Iterator)localObject3).next();
            if (((localSize.width != 980) || (localSize.height != 800) || (!"samsung".equalsIgnoreCase(Build.MANUFACTURER)) || ((!"GT-I9220".equalsIgnoreCase(Build.MODEL)) && (!"GT-N7000".equalsIgnoreCase(Build.MODEL)))) && (((localSize.width == 1184) && (localSize.height == 666)) || (((localSize.width != 704) || (localSize.height != 576) || (!"samsung".equalsIgnoreCase(Build.MANUFACTURER)) || (!"GT-I9300".equalsIgnoreCase(Build.MODEL))) && ((localSize.width != 800) || (localSize.height != 450) || (!"samsung".equalsIgnoreCase(Build.MANUFACTURER)) || (!"GT-I9100".equalsIgnoreCase(Build.MODEL)))))) {
              ((List)localObject1).add(localSize);
            }
          }
          localObject3 = localParameters.getPreviewSize();
          if (("samsung".equalsIgnoreCase(Build.MANUFACTURER)) && ("GT-I9008L".equalsIgnoreCase(Build.MODEL)))
          {
            localObject1 = localObject3;
          }
          else if ((paramInt1 != 0) && (paramInt2 != 0))
          {
            localSize = a(localList, paramInt1, paramInt2);
            localObject1 = localSize;
            if (localSize == null) {
              localObject1 = a(localList, 640, 480);
            }
          }
          else
          {
            localObject1 = a((List)localObject1, 1280, 720);
          }
          if ((localObject1 != null) && ((((Camera.Size)localObject1).height != ((Camera.Size)localObject3).height) || (((Camera.Size)localObject1).width != ((Camera.Size)localObject3).width))) {
            localParameters.setPreviewSize(((Camera.Size)localObject1).width, ((Camera.Size)localObject1).height);
          }
        }
      }
      catch (InvocationTargetException localInvocationTargetException1)
      {
        localInvocationTargetException1.printStackTrace();
      }
      catch (IllegalAccessException localIllegalAccessException1)
      {
        localIllegalAccessException1.printStackTrace();
      }
      catch (IllegalArgumentException localIllegalArgumentException1)
      {
        localIllegalArgumentException1.printStackTrace();
      }
    }
    Object localObject2 = a;
    if (localObject2 != null) {
      try
      {
        localObject2 = (List)((Method)localObject2).invoke(localParameters, (Object[])null);
        if (localObject2 == null) {
          break label540;
        }
        paramInt1 = a((List)localObject2);
        if (paramInt1 == -1) {
          break label540;
        }
        localParameters.setPreviewFormat(paramInt1);
      }
      catch (InvocationTargetException localInvocationTargetException2)
      {
        localInvocationTargetException2.printStackTrace();
      }
      catch (IllegalAccessException localIllegalAccessException2)
      {
        localIllegalAccessException2.printStackTrace();
      }
      catch (IllegalArgumentException localIllegalArgumentException2)
      {
        localIllegalArgumentException2.printStackTrace();
      }
    } else if (localParameters.getPreviewFormat() != 17) {
      localParameters.setPreviewFormat(17);
    }
    try
    {
      label540:
      a(localParameters, paramInt3);
      a(localParameters);
      paramCamera.setParameters(localParameters);
      return;
    }
    catch (RuntimeException paramCamera)
    {
      paramCamera.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.hiar.sdk.camera.CameraParameters
 * JD-Core Version:    0.7.0.1
 */