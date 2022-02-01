package com.tencent.biz.qqcircle.bizparts.danmaku.text;

import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import com.etrump.mixlayout.api.IETEngine;
import com.etrump.mixlayout.api.IETFont;
import com.tencent.biz.qcircleshadow.lib.QCircleHostFontHelper;
import com.tencent.biz.qcircleshadow.lib.QCirclePluginInitHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class ETSpace
{
  private static Object h = new Object();
  private static volatile ETSpace i = null;
  public AtomicBoolean a = new AtomicBoolean(false);
  public AtomicBoolean b = new AtomicBoolean(false);
  public AtomicBoolean c = new AtomicBoolean(false);
  public AtomicBoolean d = new AtomicBoolean(false);
  private IETEngine e;
  private IETEngine f;
  private IETEngine g;
  
  public static ETSpace a()
  {
    if (i == null) {
      try
      {
        if (i == null) {
          i = new ETSpace();
        }
      }
      finally {}
    }
    return i;
  }
  
  private IETEngine h()
  {
    if (i()) {
      return QCircleHostFontHelper.getETEngineInstance();
    }
    return null;
  }
  
  private boolean i()
  {
    if ((!QCircleHostFontHelper.isVipFontSoLoaded()) && (QCircleHostFontHelper.isVipFontSoDownloaded())) {
      return QCircleHostFontHelper.loadSoLib();
    }
    if (!QCircleHostFontHelper.isVipFontSoDownloaded())
    {
      QCirclePluginInitHelper.startFontSoDownload();
      QLog.d("ETSpace", 1, "initEngine but libvipfont.so didn't download, start download.");
      return false;
    }
    return true;
  }
  
  public float a(String paramString, int paramInt1, int paramInt2, IETFont paramIETFont, Paint paramPaint)
  {
    try
    {
      if (this.e != null)
      {
        paramInt1 = this.e.nativeSpaceMeasureText(paramString, paramInt1, paramInt2, paramIETFont, paramPaint);
        float f1 = paramInt1;
        return f1;
      }
      return 0.0F;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public int a(String paramString, int paramInt1, int paramInt2, IETFont paramIETFont, Paint paramPaint, float[] paramArrayOfFloat, boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      IETEngine localIETEngine = this.f;
      break label22;
      localIETEngine = this.e;
      label22:
      int j = 0;
      if (localIETEngine != null)
      {
        int[] arrayOfInt = new int[paramArrayOfFloat.length];
        paramInt2 = localIETEngine.nativeSpaceGetTextWidths(paramString, paramInt1, paramInt2, paramIETFont, paramPaint, arrayOfInt);
        paramInt1 = j;
        while (paramInt1 < paramInt2)
        {
          paramArrayOfFloat[paramInt1] = arrayOfInt[paramInt1];
          paramInt1 += 1;
        }
        return paramInt2;
      }
      return 0;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public Paint.FontMetrics a(IETFont paramIETFont)
  {
    try
    {
      if ((this.e != null) && (paramIETFont != null))
      {
        Paint.FontMetrics localFontMetrics = new Paint.FontMetrics();
        boolean bool = this.e.nativeGetFontMetrics(localFontMetrics, paramIETFont);
        if (bool) {
          return localFontMetrics;
        }
      }
      return null;
    }
    finally {}
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if ((this.e != null) && (this.a.get())) {
      return true;
    }
    synchronized (h)
    {
      if (this.e == null) {
        this.e = h();
      }
      Object localObject2 = this.e;
      if (localObject2 != null)
      {
        try
        {
          boolean bool = this.e.initEngine(paramInt1, paramInt2);
          if (bool)
          {
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("start init font engine,num=");
              ((StringBuilder)localObject2).append(paramInt1);
              ((StringBuilder)localObject2).append(",cache=");
              ((StringBuilder)localObject2).append(paramInt2);
              QLog.d("ETSpace", 2, ((StringBuilder)localObject2).toString());
            }
            this.a.set(true);
          }
          return true;
        }
        catch (Throwable localThrowable) {}catch (Error localError)
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("init font engine fail ");
            localStringBuilder.append(localError.getMessage());
            QLog.e("ETSpace", 2, localStringBuilder.toString());
          }
          return false;
        }
        localError.printStackTrace();
        return false;
      }
      return false;
    }
  }
  
  public IETEngine b()
  {
    return this.e;
  }
  
  public IETEngine c()
  {
    f();
    return this.f;
  }
  
  public IETEngine d()
  {
    g();
    return this.g;
  }
  
  public boolean e()
  {
    return (f()) && (g());
  }
  
  public boolean f()
  {
    if ((this.f != null) && (this.b.get())) {
      return true;
    }
    for (;;)
    {
      synchronized (h)
      {
        IETEngine localIETEngine;
        if (this.f == null)
        {
          if (i())
          {
            localIETEngine = QCircleHostFontHelper.getInstanceForSpace();
            this.f = localIETEngine;
          }
        }
        else
        {
          localIETEngine = this.f;
          if (localIETEngine != null) {
            try
            {
              boolean bool = this.f.initEngine(8, 10485760);
              if (bool)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("ETSpace", 2, "start init xuandong space engine succ");
                }
                this.b.set(true);
              }
              return bool;
            }
            catch (Throwable localThrowable)
            {
              if (QLog.isColorLevel())
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("init xuandong space engine fail ");
                localStringBuilder.append(localThrowable.getMessage());
                QLog.e("ETSpace", 2, localStringBuilder.toString());
              }
              return false;
            }
          }
          return false;
        }
      }
      Object localObject2 = null;
    }
  }
  
  public boolean g()
  {
    if ((this.g != null) && (this.c.get())) {
      return true;
    }
    for (;;)
    {
      synchronized (h)
      {
        IETEngine localIETEngine;
        if (this.g == null)
        {
          if (i())
          {
            localIETEngine = QCircleHostFontHelper.getInstanceForAnimation();
            this.g = localIETEngine;
          }
        }
        else
        {
          localIETEngine = this.g;
          if (localIETEngine != null) {
            try
            {
              boolean bool = this.g.initEngine(8, 10485760);
              if (bool)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("ETSpace", 2, "start init xuandong Animation engine succ");
                }
                this.c.set(true);
              }
              return bool;
            }
            catch (Throwable localThrowable)
            {
              if (QLog.isColorLevel())
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("init xuandong Animation engine fail ");
                localStringBuilder.append(localThrowable.getMessage());
                QLog.e("ETSpace", 2, localStringBuilder.toString());
              }
              return false;
            }
          }
          return false;
        }
      }
      Object localObject2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.text.ETSpace
 * JD-Core Version:    0.7.0.1
 */