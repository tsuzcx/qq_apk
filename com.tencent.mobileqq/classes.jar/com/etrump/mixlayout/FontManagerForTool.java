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
  private static FontManagerForTool b;
  public HandlerThread a = ThreadManager.newFreeHandlerThread("VasFont", 0);
  private AtomicBoolean c = new AtomicBoolean(false);
  private AtomicBoolean d = new AtomicBoolean(false);
  private AtomicBoolean e = new AtomicBoolean(false);
  private AtomicBoolean f = new AtomicBoolean(false);
  private ConcurrentHashMap<Integer, FontInfo> g = new ConcurrentHashMap();
  private Handler h = new Handler(Looper.getMainLooper());
  private ETEngine i;
  private ETEngine j;
  private EIPCResultCallback k = new FontManagerForTool.1(this);
  private EIPCResultCallback l = new FontManagerForTool.2(this);
  
  private FontManagerForTool()
  {
    this.a.start();
  }
  
  public static FontManagerForTool a()
  {
    try
    {
      if (b == null) {
        b = new FontManagerForTool();
      }
      FontManagerForTool localFontManagerForTool = b;
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
        QIPCClientHelper.getInstance().callServer("VasFontIPCModule", str1, null, this.l);
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
      this.i = ETEngine.getInstance();
      this.j = ETEngine.getInstanceForAnimation();
      ETEngine.isSOLoaded.set(true);
      bool1 = paramBoolean;
      try
      {
        bool3 = this.i.initEngine(5, 2097152);
        paramBoolean = bool2;
        if (bool3) {
          try
          {
            bool1 = this.j.initEngine(3, 1048576);
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
        this.c.set(paramBoolean);
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
      FastColorFontHelper.a().b().a();
      this.e.set(true);
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
      this.h.post(new FontManagerForTool.3(this, paramBoolean));
      return false;
    }
    return a(paramBoolean, false);
  }
  
  public FontInfo a(int paramInt1, int paramInt2)
  {
    FontInfo localFontInfo = (FontInfo)this.g.get(Integer.valueOf(paramInt1));
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
        QIPCClientHelper.getInstance().callServer("VasFontIPCModule", VasFontIPCModule.c, (Bundle)localObject, this.k);
      }
      int n = 0;
      if (paramInt2 != 1)
      {
        if (paramInt2 != 2)
        {
          if ((paramInt2 != 3) && (paramInt2 != 4)) {
            return localFontInfo;
          }
          if (this.f.compareAndSet(false, true)) {
            b(true);
          }
          localObject = localFontInfo;
          if (this.e.get())
          {
            localObject = localFontInfo;
            if (bool)
            {
              FastColorFontHelper.a().a(paramInt1, str);
              localObject = new FontInfo(paramInt1, 4, str);
              this.g.put(Integer.valueOf(paramInt1), localObject);
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
            ((FontInfo)localObject).d = Typeface.createFromFile(str);
            this.g.put(Integer.valueOf(paramInt1), localObject);
            return localObject;
          }
        }
      }
      else
      {
        if (this.d.compareAndSet(false, true)) {
          a(true);
        }
        localObject = localFontInfo;
        if (this.c.get())
        {
          localObject = localFontInfo;
          if (bool)
          {
            int m = n;
            if (this.i.native_loadFont(str, paramInt1, false))
            {
              m = n;
              if (this.j.native_loadFont(str, paramInt1, false)) {
                m = 1;
              }
            }
            localObject = localFontInfo;
            if (m != 0)
            {
              localObject = new FontInfo(paramInt1, paramInt2, str);
              this.g.put(Integer.valueOf(paramInt1), localObject);
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