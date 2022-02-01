package com.tencent.aelight.camera.aioeditor.capture.util;

import android.content.Context;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools;
import com.tencent.aelight.camera.aioeditor.capture.view.ComboProviderView;
import com.tencent.aelight.camera.aioeditor.capture.view.MusicProviderView;
import com.tencent.aelight.camera.aioeditor.capture.view.ProviderView;
import com.tencent.aelight.camera.aioeditor.capture.view.QIMFilterProviderView;
import com.tencent.aelight.camera.aioeditor.capture.view.StaticStickerProviderView;
import com.tencent.aelight.camera.aioeditor.capture.view.TransitionProviderView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class QIMProviderViewBuilder
{
  public static final int[] a = { 106, 2130851746, 2130851746, 2131442047 };
  public static final int[] b = { 101, 2130851747, 2130851747, 2131442048 };
  public static final int[] c = { 103, 2130851749, 2130851749, 2131442050 };
  public static final int[] d = { 104, 2130851748, 2130851748, 2131442049 };
  public static final int[] e = { 108, 2063925640, 2063925640, 2131442052 };
  public static final int[] l = { 104 };
  public boolean f = true;
  public boolean g = true;
  public boolean h = true;
  public boolean i = true;
  public boolean j = true;
  public boolean k = true;
  private int m = 0;
  private ArrayList<int[]> n = new ArrayList();
  
  public QIMProviderViewBuilder(int paramInt)
  {
    this.m = paramInt;
  }
  
  public int a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= this.n.size())) {
      return ((int[])this.n.get(paramInt))[1];
    }
    return 0;
  }
  
  public ProviderView a(Context paramContext, int paramInt)
  {
    if (paramInt != 101)
    {
      if (paramInt != 106)
      {
        if (paramInt != 108)
        {
          if (paramInt != 103)
          {
            if (paramInt != 104)
            {
              if (QLog.isColorLevel())
              {
                paramContext = new StringBuilder();
                paramContext.append("bad id=");
                paramContext.append(paramInt);
                QLog.d("ProviderViewBuilder", 2, paramContext.toString());
              }
            }
            else if (this.k)
            {
              paramContext = new MusicProviderView(paramContext);
              paramContext.setId(2131430313);
              break label177;
            }
          }
          else
          {
            paramContext = new StaticStickerProviderView(paramContext);
            paramContext.setId(2131430314);
            break label177;
          }
        }
        else
        {
          paramContext = new TransitionProviderView(paramContext);
          break label177;
        }
      }
      else if (this.j)
      {
        paramContext = new ComboProviderView(paramContext);
        paramContext.setId(2131430307);
        break label177;
      }
    }
    else if (this.h)
    {
      paramContext = new QIMFilterProviderView(paramContext);
      paramContext.setId(2131430308);
      break label177;
    }
    paramContext = null;
    label177:
    if (paramContext != null)
    {
      paramContext.setCaptureScene(this.m);
      if (this.m == 0)
      {
        paramContext.setTabBarPosition(2);
        paramContext.d(206);
        return paramContext;
      }
      paramContext.setTabBarPosition(1);
      if (paramContext.getNeedTabBar())
      {
        paramContext.d(213);
        return paramContext;
      }
      paramContext.d(249);
    }
    return paramContext;
  }
  
  public void a()
  {
    this.n.clear();
    int i1 = this.m;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 == 3) {
            break label100;
          }
          if (i1 != 4) {
            return;
          }
        }
        if (this.f)
        {
          this.n.add(a);
          this.n.add(b);
          this.n.add(c);
        }
        this.n.add(d);
        this.n.add(e);
        return;
      }
      label100:
      if (this.f)
      {
        this.n.add(a);
        this.n.add(b);
        this.n.add(c);
      }
    }
    else if (this.f)
    {
      if (this.h) {
        this.n.add(b);
      }
      if (this.k) {
        this.n.add(d);
      }
      if (this.j) {
        this.n.add(a);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public int b()
  {
    return this.n.size();
  }
  
  public int b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= this.n.size())) {
      return ((int[])this.n.get(paramInt))[2];
    }
    return 0;
  }
  
  public void b(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void c(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public boolean c(int paramInt)
  {
    if (paramInt >= 0)
    {
      if (paramInt > this.n.size()) {
        return false;
      }
      paramInt = ((int[])this.n.get(paramInt))[0];
      if (paramInt == 101) {
        return VideoFilterTools.a(1, 0, "");
      }
      if (paramInt == 106) {
        return VideoFilterTools.a(6, 0, "");
      }
    }
    return false;
  }
  
  public void d(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.n.size()))
    {
      paramInt = ((int[])this.n.get(paramInt))[0];
      if (paramInt == 101)
      {
        VideoFilterTools.a().b(1, 0, "");
        return;
      }
      if (paramInt == 106) {
        VideoFilterTools.a().b(6, 0, "");
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateRedDotHasShow failed out bounds");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" size:");
      localStringBuilder.append(this.n.size());
      QLog.e("ProviderViewBuilder", 2, localStringBuilder.toString());
    }
  }
  
  public void d(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public int e(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= this.n.size())) {
      return ((int[])this.n.get(paramInt))[0];
    }
    return -1;
  }
  
  public void e(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public void f(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public boolean f(int paramInt)
  {
    int[] arrayOfInt = l;
    int i2 = arrayOfInt.length;
    int i1 = 0;
    while (i1 < i2)
    {
      if (arrayOfInt[i1] == paramInt) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.util.QIMProviderViewBuilder
 * JD-Core Version:    0.7.0.1
 */