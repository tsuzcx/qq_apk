package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text;

import android.graphics.Paint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.qphone.base.util.QLog;

public abstract class TextBase
  extends ViewBase
{
  public int B = -16777216;
  public int C = Utils.b(20.0D);
  public int D = 0;
  protected int E = -1;
  protected int F = -1;
  protected int G = TextUtils.TruncateAt.END.ordinal();
  public String e = "";
  public String f;
  
  public TextBase(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.s |= 0x20;
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.equals(paramString, this.e))
    {
      this.e = paramString;
      f();
    }
  }
  
  public boolean a(int paramInt, String paramString)
  {
    boolean bool2 = super.a(paramInt, paramString);
    boolean bool1 = bool2;
    if (!bool2) {}
    Object localObject;
    switch (paramInt)
    {
    default: 
      bool1 = false;
      return bool1;
    case 16: 
      this.e = paramString;
      return bool2;
    case 17: 
      localObject = Utils.a(paramString);
      if (localObject != null)
      {
        this.C = Utils.a(((Double)localObject).doubleValue());
        return bool2;
      }
      QLog.d("TextBase", 2, "setAttribute: fail to parse - " + paramInt + ": " + paramString);
      return bool2;
    case 18: 
      this.B = Utils.a(paramString);
      return bool2;
    case 19: 
      localObject = Utils.a(paramString);
      if (localObject != null)
      {
        this.C = Utils.a(((Double)localObject).doubleValue());
        this.D = 1;
        return bool2;
      }
      QLog.d("TextBase", 2, "setAttribute: fail to parse - " + paramInt + ": " + paramString);
      return bool2;
    case 20: 
      localObject = Utils.a(paramString);
      if (localObject != null)
      {
        this.F = ((Integer)localObject).intValue();
        return bool2;
      }
      QLog.d("TextBase", 2, "setAttribute: fail to parse - " + paramInt + ": " + paramString);
      return bool2;
    case 39: 
      if ("CenterVerticle".equals(paramString))
      {
        this.s |= 0x20;
        return bool2;
      }
      this.s |= 0x4;
      this.s |= 0x20;
      return bool2;
    }
    this.f = paramString;
    c(this.f);
    return bool2;
  }
  
  public void c(int paramInt)
  {
    if (this.B != paramInt)
    {
      this.B = paramInt;
      this.a.setColor(this.B);
      f();
    }
  }
  
  public void c(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.TextBase
 * JD-Core Version:    0.7.0.1
 */