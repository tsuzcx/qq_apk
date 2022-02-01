package com.etrump.mixlayout;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.Vas.ColorFont.FastColorFontHelper;
import com.Vas.ColorFont.FreeTypeLib;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.vas.font.api.FontManagerConstants;
import com.tencent.mobileqq.vas.util.VasSoUtils;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResultCallback;
import java.util.Observable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class FontManagerForTool
  extends Observable
{
  private static FontManagerForTool jdField_a_of_type_ComEtrumpMixlayoutFontManagerForTool;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  public HandlerThread a;
  private ETEngine jdField_a_of_type_ComEtrumpMixlayoutETEngine;
  private EIPCResultCallback jdField_a_of_type_EipcEIPCResultCallback = new FontManagerForTool.1(this);
  private ConcurrentHashMap<Integer, FontInfo> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private ETEngine jdField_b_of_type_ComEtrumpMixlayoutETEngine;
  private EIPCResultCallback jdField_b_of_type_EipcEIPCResultCallback = new FontManagerForTool.2(this);
  private AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private AtomicBoolean c = new AtomicBoolean(false);
  private AtomicBoolean d = new AtomicBoolean(false);
  
  private FontManagerForTool()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread("VasFont", 0);
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
  }
  
  public static FontManagerForTool a()
  {
    try
    {
      if (jdField_a_of_type_ComEtrumpMixlayoutFontManagerForTool == null) {
        jdField_a_of_type_ComEtrumpMixlayoutFontManagerForTool = new FontManagerForTool();
      }
      FontManagerForTool localFontManagerForTool = jdField_a_of_type_ComEtrumpMixlayoutFontManagerForTool;
      return localFontManagerForTool;
    }
    finally {}
  }
  
  private boolean a(int paramInt, boolean paramBoolean)
  {
    String str1 = "";
    boolean bool = true;
    String str2;
    if (paramInt != 1)
    {
      if (paramInt != 4)
      {
        str2 = "";
      }
      else
      {
        str1 = VasFontIPCModule.b;
        str2 = "libFounderColorFont_818.so";
      }
    }
    else
    {
      str1 = VasFontIPCModule.a;
      str2 = "libvipfont8417.so";
    }
    paramInt = VasSoUtils.a(VasSoUtils.a(), str2);
    if (paramInt != 0)
    {
      if (((paramInt == 1) || (paramInt == 2)) && (paramBoolean)) {
        QIPCClientHelper.getInstance().callServer("VasFontIPCModule", str1, null, this.jdField_b_of_type_EipcEIPCResultCallback);
      }
      bool = false;
    }
    return bool;
  }
  
  private boolean a(boolean paramBoolean)
  {
    boolean bool3 = a(1, paramBoolean);
    paramBoolean = false;
    boolean bool1 = false;
    boolean bool2 = false;
    if (bool3)
    {
      this.jdField_a_of_type_ComEtrumpMixlayoutETEngine = ETEngine.getInstance();
      this.jdField_b_of_type_ComEtrumpMixlayoutETEngine = ETEngine.getInstanceForAnimation();
      ETEngine.isSOLoaded.set(true);
      bool1 = paramBoolean;
      try
      {
        bool3 = this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.initEngine(5, 2097152);
        paramBoolean = bool2;
        if (bool3) {
          try
          {
            bool1 = this.jdField_b_of_type_ComEtrumpMixlayoutETEngine.initEngine(3, 1048576);
            paramBoolean = bool2;
            if (bool1) {
              paramBoolean = true;
            }
          }
          catch (Exception localException1)
          {
            bool1 = bool3;
            break label105;
          }
        }
        bool1 = paramBoolean;
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(paramBoolean);
        return paramBoolean;
      }
      catch (Exception localException2)
      {
        label105:
        QLog.e("FontManagerConstants.TOOL", 1, "initHYEngine error: ", localException2);
      }
    }
    return bool1;
  }
  
  private boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    paramBoolean1 = a(4, paramBoolean1);
    if (paramBoolean1)
    {
      FastColorFontHelper.a().a().a();
      this.c.set(true);
      if (paramBoolean2)
      {
        setChanged();
        notifyObservers(Integer.valueOf(1));
      }
    }
    return paramBoolean1;
  }
  
  private boolean b(boolean paramBoolean)
  {
    if (Thread.currentThread() != Looper.getMainLooper().getThread())
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new FontManagerForTool.3(this, paramBoolean));
      return false;
    }
    return a(paramBoolean, false);
  }
  
  public FontInfo a(int paramInt1, int paramInt2)
  {
    FontInfo localFontInfo = (FontInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt1));
    Object localObject = localFontInfo;
    if (localFontInfo == null)
    {
      boolean bool = FontManagerConstants.checkFontExist(paramInt1, paramInt2);
      String str = FontManagerConstants.getTTFPath(paramInt1, paramInt2);
      if (!bool)
      {
        localObject = new Bundle();
        ((Bundle)localObject).putInt("id", paramInt1);
        ((Bundle)localObject).putInt("font_type", paramInt2);
        QIPCClientHelper.getInstance().callServer("VasFontIPCModule", VasFontIPCModule.c, (Bundle)localObject, this.jdField_a_of_type_EipcEIPCResultCallback);
      }
      int j = 0;
      if (paramInt2 != 1)
      {
        if (paramInt2 != 2)
        {
          if ((paramInt2 != 3) && (paramInt2 != 4)) {
            return localFontInfo;
          }
          if (this.d.compareAndSet(false, true)) {
            b(true);
          }
          localObject = localFontInfo;
          if (this.c.get())
          {
            localObject = localFontInfo;
            if (bool)
            {
              FastColorFontHelper.a().a(paramInt1, str);
              localObject = new FontInfo(paramInt1, 4, str);
              this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt1), localObject);
              return localObject;
            }
          }
        }
        else
        {
          localObject = localFontInfo;
          if (bool)
          {
            localObject = new FontInfo(paramInt1, paramInt2, str);
            ((FontInfo)localObject).a = Typeface.createFromFile(str);
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt1), localObject);
            return localObject;
          }
        }
      }
      else
      {
        if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {
          a(true);
        }
        localObject = localFontInfo;
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
        {
          localObject = localFontInfo;
          if (bool)
          {
            int i = j;
            if (this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_loadFont(str, paramInt1, false))
            {
              i = j;
              if (this.jdField_b_of_type_ComEtrumpMixlayoutETEngine.native_loadFont(str, paramInt1, false)) {
                i = 1;
              }
            }
            localObject = localFontInfo;
            if (i != 0)
            {
              localObject = new FontInfo(paramInt1, paramInt2, str);
              this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt1), localObject);
            }
          }
        }
      }
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.etrump.mixlayout.FontManagerForTool
 * JD-Core Version:    0.7.0.1
 */