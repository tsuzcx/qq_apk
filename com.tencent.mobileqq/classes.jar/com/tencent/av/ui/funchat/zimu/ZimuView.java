package com.tencent.av.ui.funchat.zimu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.zimu.ZimuItem;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lcg;
import lhc;
import lhl;
import ljp;
import mnx;

public abstract class ZimuView
  extends RelativeLayout
{
  protected float a;
  protected int a;
  protected long a;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  protected Typeface a;
  protected VideoAppInterface a;
  protected final List<mnx> a;
  protected ljp a;
  protected int b;
  protected long b;
  private Rect b;
  
  public ZimuView(long paramLong, VideoAppInterface paramVideoAppInterface, Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_Long = (System.currentTimeMillis() - 100L);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(2);
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_b_of_type_AndroidGraphicsRect = new Rect();
    paramVideoAppInterface = (WindowManager)paramContext.getSystemService("window");
    this.jdField_a_of_type_Int = paramVideoAppInterface.getDefaultDisplay().getWidth();
    this.jdField_b_of_type_Int = paramVideoAppInterface.getDefaultDisplay().getHeight();
    paramContext = new DisplayMetrics();
    paramVideoAppInterface.getDefaultDisplay().getMetrics(paramContext);
    this.jdField_a_of_type_Float = paramContext.density;
    setId(2131372534);
    this.jdField_a_of_type_Ljp = ((ljp)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0));
    paramVideoAppInterface = a();
    this.jdField_a_of_type_Ljp.a(paramLong, paramVideoAppInterface);
  }
  
  private long a(long paramLong)
  {
    long l1 = 0L;
    long l2 = l1;
    if (this.jdField_b_of_type_Long != 0L)
    {
      l2 = paramLong - this.jdField_b_of_type_Long;
      if (l2 <= 500L) {
        break label80;
      }
    }
    for (;;)
    {
      lcg.c("ZimuView", " Render Interval: " + l1 + "|" + (paramLong - this.jdField_b_of_type_Long));
      l2 = l1;
      this.jdField_b_of_type_Long = paramLong;
      return l2;
      label80:
      l1 = l2;
    }
  }
  
  public abstract int a();
  
  public abstract String a();
  
  protected abstract List<mnx> a(lhc paramlhc, boolean paramBoolean);
  
  void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      mnx localmnx = (mnx)localIterator.next();
      localIterator.remove();
      localmnx.b();
    }
  }
  
  public void a(lhc paramlhc)
  {
    if ((paramlhc == null) || (TextUtils.isEmpty(paramlhc.jdField_a_of_type_JavaLangCharSequence)) || (TextUtils.isEmpty(paramlhc.jdField_a_of_type_JavaLangString)))
    {
      StringBuilder localStringBuilder = new StringBuilder().append("updateText error:");
      if (paramlhc == null) {}
      for (paramlhc = null;; paramlhc = paramlhc.toString())
      {
        lcg.e("ZimuView", paramlhc);
        return;
      }
    }
    lcg.e("ZimuView", "updateText :" + paramlhc.toString());
    if (!this.jdField_a_of_type_Ljp.a())
    {
      g();
      this.jdField_a_of_type_Ljp.b("updateText2", true);
    }
    a(paramlhc, false);
  }
  
  protected void a(lhc paramlhc, boolean paramBoolean)
  {
    setContentDescription(paramlhc.jdField_a_of_type_JavaLangCharSequence);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int j;
    for (int i = 0; localIterator.hasNext(); i = j)
    {
      mnx localmnx = (mnx)localIterator.next();
      j = i;
      if (!localmnx.a.a())
      {
        j = i;
        if (localmnx.a.jdField_a_of_type_JavaLangString.equals(paramlhc.jdField_a_of_type_JavaLangString))
        {
          j = 1;
          localmnx.a(paramlhc);
        }
      }
    }
    if (i == 0)
    {
      paramlhc = a(paramlhc, paramBoolean);
      if (paramlhc != null) {
        this.jdField_a_of_type_JavaUtilList.addAll(paramlhc);
      }
    }
    e();
  }
  
  protected void a(mnx parammnx) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      h();
    }
  }
  
  protected int b()
  {
    return 2131695794;
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_Ljp.a()) {
      f();
    }
  }
  
  protected void b(mnx parammnx)
  {
    parammnx.c();
  }
  
  protected void c()
  {
    String str;
    Object localObject;
    if ((this.jdField_a_of_type_AndroidGraphicsTypeface == null) && (this.jdField_a_of_type_Ljp != null))
    {
      str = a();
      localObject = (ZimuItem)this.jdField_a_of_type_Ljp.a(str);
      if (localObject != null)
      {
        localObject = this.jdField_a_of_type_Ljp.b((lhl)localObject);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = new File((String)localObject + "font.ttf");
          if (!((File)localObject).exists()) {
            break label135;
          }
        }
      }
    }
    label135:
    while (!AudioHelper.e()) {
      try
      {
        this.jdField_a_of_type_AndroidGraphicsTypeface = Typeface.createFromFile((File)localObject);
        return;
      }
      catch (Exception localException)
      {
        while (!AudioHelper.e()) {}
        QLog.w("ZimuView", 1, "createTypeface, Exception, id[" + str + "]", localException);
        return;
      }
    }
    QLog.w("ZimuView", 1, "createTypeface, 不存在, file[" + localException.getAbsolutePath() + "], id[" + str + "]");
  }
  
  abstract void d();
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    long l1 = System.currentTimeMillis();
    long l2 = a(l1);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    boolean bool1 = false;
    while (localIterator.hasNext())
    {
      mnx localmnx = (mnx)localIterator.next();
      localmnx.a(l2);
      if (!localmnx.a())
      {
        if (localmnx.b())
        {
          lcg.c("ZimuView", "recycle barrage:" + localmnx);
          localmnx.c();
          b(localmnx);
        }
      }
      else
      {
        boolean bool2 = true;
        bool1 = bool2;
        if (!localmnx.c()) {
          continue;
        }
        Bitmap localBitmap = localmnx.a();
        if ((localBitmap != null) && (!localBitmap.isRecycled()))
        {
          paramCanvas.save();
          int i = localmnx.a();
          int j = localmnx.b();
          int k = localBitmap.getWidth();
          int m = localBitmap.getHeight();
          paramCanvas.clipRect(i, j, i + k, j + m);
          paramCanvas.translate(i, j);
          this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, k, m);
          this.jdField_b_of_type_AndroidGraphicsRect.set(0, 0, k, m);
          paramCanvas.drawBitmap(localBitmap, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_b_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
          paramCanvas.restore();
        }
        lcg.c("ZimuView", "onDraw: " + localmnx.toString());
        bool1 = bool2;
        continue;
      }
      lcg.c("ZimuView", "remove barrage:" + localmnx);
      localIterator.remove();
      a(localmnx);
      localmnx.b();
    }
    l2 = System.currentTimeMillis();
    lcg.c("ZimuView", "onDraw needRefresh: " + bool1 + "|" + (l2 - l1));
    if (bool1) {
      d();
    }
  }
  
  public void e()
  {
    super.invalidate();
    long l = System.currentTimeMillis();
    lcg.c("ZimuView", "Refresh interval:" + (l - this.jdField_a_of_type_Long));
    this.jdField_a_of_type_Long = l;
  }
  
  void f()
  {
    String str1 = getContext().getResources().getString(b());
    String str2 = getContext().getResources().getString(2131695795);
    a(new lhc(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getAccount(), str1, str2, 2), true);
  }
  
  void g()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((mnx)localIterator.next()).a(false);
    }
  }
  
  public void h() {}
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    a();
    this.jdField_a_of_type_AndroidGraphicsTypeface = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.funchat.zimu.ZimuView
 * JD-Core Version:    0.7.0.1
 */