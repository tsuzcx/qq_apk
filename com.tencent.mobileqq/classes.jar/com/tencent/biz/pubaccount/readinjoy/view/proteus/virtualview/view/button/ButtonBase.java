package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.TextBase;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;

public abstract class ButtonBase
  extends TextBase
{
  public int A;
  public final Drawable a;
  private SparseArray a;
  public final Drawable b = new ColorDrawable(0);
  public boolean b;
  private String g;
  private String h;
  private String i;
  private String j;
  private String k;
  protected int z;
  
  public ButtonBase(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(Color.parseColor("#E9E9E9"));
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(4);
  }
  
  private void d(String paramString)
  {
    int m = 0;
    if (paramString == null) {}
    while (paramString.equals(this.g)) {
      return;
    }
    this.g = paramString;
    try
    {
      JSONArray localJSONArray2 = new JSONArray(paramString);
      if (localJSONArray2.length() >= 2)
      {
        JSONArray localJSONArray1 = localJSONArray2.getJSONArray(0);
        localJSONArray2 = localJSONArray2.getJSONArray(1);
        while (m < localJSONArray2.length())
        {
          int n = Integer.valueOf(localJSONArray2.getString(m)).intValue();
          if (m < localJSONArray1.length())
          {
            String str = localJSONArray1.getString(m);
            a(n).b = str;
          }
          m += 1;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      Log.e("ButtonBase", "setStatusBackground: setStatusBackground :" + paramString);
      b();
    }
  }
  
  private void e(String paramString)
  {
    int m = 0;
    if (paramString == null) {}
    while (paramString.equals(this.h)) {
      return;
    }
    this.h = paramString;
    try
    {
      JSONArray localJSONArray2 = new JSONArray(paramString);
      if (localJSONArray2.length() >= 2)
      {
        JSONArray localJSONArray1 = localJSONArray2.getJSONArray(0);
        localJSONArray2 = localJSONArray2.getJSONArray(1);
        while (m < localJSONArray2.length())
        {
          int n = Integer.valueOf(localJSONArray2.getString(m)).intValue();
          if (m < localJSONArray1.length())
          {
            String str = localJSONArray1.getString(m);
            a(n).c = str;
          }
          m += 1;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      Log.e("ButtonBase", "setStatusBackgroud: setStatusBackgroud :" + paramString);
      c();
    }
  }
  
  private void f(String paramString)
  {
    int m = 0;
    if (paramString == null) {}
    while (paramString.equals(this.j)) {
      return;
    }
    this.j = paramString;
    try
    {
      JSONArray localJSONArray2 = new JSONArray(paramString);
      if (localJSONArray2.length() >= 2)
      {
        JSONArray localJSONArray1 = localJSONArray2.getJSONArray(0);
        localJSONArray2 = localJSONArray2.getJSONArray(1);
        while (m < localJSONArray2.length())
        {
          int n = Integer.valueOf(localJSONArray2.getString(m)).intValue();
          if (m < localJSONArray1.length())
          {
            String str = localJSONArray1.getString(m);
            a(n).d = str;
          }
          m += 1;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      Log.e("ButtonBase", "setStatusBackgroud: setStatusBackgroud :" + paramString);
      e();
    }
  }
  
  private void g(String paramString)
  {
    int m = 0;
    if (paramString == null) {}
    while (paramString.equals(this.i)) {
      return;
    }
    this.i = paramString;
    try
    {
      JSONArray localJSONArray2 = new JSONArray(paramString);
      if (localJSONArray2.length() >= 2)
      {
        JSONArray localJSONArray1 = localJSONArray2.getJSONArray(0);
        localJSONArray2 = localJSONArray2.getJSONArray(1);
        while (m < localJSONArray2.length())
        {
          int n = Integer.valueOf(localJSONArray2.getString(m)).intValue();
          if (m < localJSONArray1.length())
          {
            String str = localJSONArray1.getString(m);
            a(n).jdField_a_of_type_JavaLangString = str;
          }
          m += 1;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      Log.e("ButtonBase", "setStatusBackgroud: setStatusBackgroud :" + paramString);
      d();
    }
  }
  
  private void h(String paramString)
  {
    int m = 0;
    if (paramString == null) {}
    while (paramString.equals(this.k)) {
      return;
    }
    this.k = paramString;
    try
    {
      JSONArray localJSONArray3 = new JSONArray(paramString);
      if (localJSONArray3.length() >= 4)
      {
        paramString = localJSONArray3.getJSONArray(0);
        JSONArray localJSONArray1 = localJSONArray3.getJSONArray(1);
        JSONArray localJSONArray2 = localJSONArray3.getJSONArray(2);
        localJSONArray3 = localJSONArray3.getJSONArray(3);
        while (m < localJSONArray3.length())
        {
          ButtonBase.ClickStatus localClickStatus = a(Integer.valueOf(localJSONArray3.getString(m)).intValue());
          if (m < paramString.length()) {
            localClickStatus.jdField_a_of_type_JavaLangString = paramString.getString(m);
          }
          if (m < localJSONArray1.length()) {
            localClickStatus.d = localJSONArray1.getString(m);
          }
          if (m < localJSONArray2.length()) {
            localClickStatus.jdField_a_of_type_Int = Integer.valueOf(localJSONArray2.getString(m)).intValue();
          }
          m += 1;
        }
      }
      return;
    }
    catch (Exception paramString)
    {
      Log.e("ButtonBase", "setClickStatus :", paramString);
      d();
      e();
    }
  }
  
  public ButtonBase.ClickStatus a(int paramInt)
  {
    ButtonBase.ClickStatus localClickStatus2 = (ButtonBase.ClickStatus)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    ButtonBase.ClickStatus localClickStatus1 = localClickStatus2;
    if (localClickStatus2 == null)
    {
      localClickStatus1 = new ButtonBase.ClickStatus();
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localClickStatus1);
    }
    return localClickStatus1;
  }
  
  public void a()
  {
    super.a();
    if (this.z == 4) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.z = 4;
      return;
    }
    this.z = 0;
  }
  
  protected boolean a(int paramInt, String paramString)
  {
    int m = 0;
    boolean bool = super.a(paramInt, paramString);
    if (!bool)
    {
      switch (paramInt)
      {
      default: 
        return false;
      case 37: 
        d(paramString);
        return true;
      case 40: 
        h(paramString);
        return true;
      case 41: 
        g(paramString);
        return true;
      case 11: 
        Double localDouble = Utils.a(paramString);
        if (localDouble != null)
        {
          this.A = Utils.a(localDouble.doubleValue());
          return true;
        }
        QLog.d("ButtonBase", 2, "setAttribute: fail to parse - " + paramInt + ": " + paramString);
        return true;
      case 42: 
        f(paramString);
        return true;
      case 43: 
        paramString = Utils.a(paramString);
        if (paramString != null) {}
        for (paramInt = paramString.intValue();; paramInt = 0)
        {
          if (paramInt == 1) {
            m = 4;
          }
          this.z = m;
          return true;
        }
      }
      e(paramString);
      return true;
    }
    return bool;
  }
  
  public abstract void b();
  
  public abstract void c();
  
  public abstract void d();
  
  public abstract void e();
  
  public boolean g()
  {
    return this.z == 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.ButtonBase
 * JD-Core Version:    0.7.0.1
 */