package com.tencent.aelight.camera.aioeditor.capture.view;

import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProviderViewBuilder
{
  public static final int[] a = { 100, 2130851751, 2131442074 };
  public static final int[] b = { 101, 2130851753, 2131442076 };
  public static final int[] c = { 102, 2130851752, 2131442075 };
  private int d;
  private ArrayList<int[]> e = new ArrayList();
  
  public ProviderViewBuilder(int paramInt, List<Integer> paramList)
  {
    this.d = paramInt;
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        paramInt = ((Integer)paramList.next()).intValue();
        if (paramInt == 100) {
          this.e.add(a);
        } else if (paramInt == 101) {
          this.e.add(b);
        } else if (paramInt == 102) {
          this.e.add(c);
        }
      }
    }
  }
  
  public int a()
  {
    return this.e.size();
  }
  
  public int a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= this.e.size())) {
      return ((int[])this.e.get(paramInt))[1];
    }
    return 0;
  }
  
  public ProviderView a(Context paramContext, int paramInt)
  {
    if (paramInt != 100)
    {
      if (paramInt != 101)
      {
        if (QLog.isColorLevel())
        {
          paramContext = new StringBuilder();
          paramContext.append("bad id=");
          paramContext.append(paramInt);
          QLog.d("ProviderViewBuilder", 2, paramContext.toString());
        }
        paramContext = null;
      }
      else
      {
        paramContext = new StaticStickerProviderView(paramContext);
        paramContext.setId(2131430314);
      }
    }
    else
    {
      paramContext = new QIMFilterProviderView(paramContext);
      paramContext.setId(2131430308);
    }
    if (paramContext != null)
    {
      paramContext.setCaptureScene(this.d);
      paramContext.setTabBarPosition(2);
      paramContext.d(231);
    }
    return paramContext;
  }
  
  public int b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= this.e.size())) {
      return ((int[])this.e.get(paramInt))[2];
    }
    return 0;
  }
  
  public int c(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= this.e.size())) {
      return ((int[])this.e.get(paramInt))[0];
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.view.ProviderViewBuilder
 * JD-Core Version:    0.7.0.1
 */