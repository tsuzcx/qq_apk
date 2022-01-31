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
import com.tencent.av.AVLog;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.handler.SentenceInfo;
import com.tencent.av.business.manager.EffectConfigBase.ItemBase;
import com.tencent.av.business.manager.zimu.EffectZimuManager;
import com.tencent.av.business.manager.zimu.ZimuItem;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
  protected EffectZimuManager a;
  protected final List a;
  protected int b;
  protected long b;
  private Rect b;
  
  public ZimuView(VideoAppInterface paramVideoAppInterface, Context paramContext, AttributeSet paramAttributeSet)
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
    setId(2131362516);
    this.jdField_a_of_type_ComTencentAvBusinessManagerZimuEffectZimuManager = ((EffectZimuManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0));
    paramVideoAppInterface = a();
    this.jdField_a_of_type_ComTencentAvBusinessManagerZimuEffectZimuManager.b(paramVideoAppInterface);
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
      AVLog.c("ZimuView", " Render Interval: " + l1 + "|" + (paramLong - this.jdField_b_of_type_Long));
      l2 = l1;
      this.jdField_b_of_type_Long = paramLong;
      return l2;
      label80:
      l1 = l2;
    }
  }
  
  public abstract int a();
  
  public abstract String a();
  
  protected abstract List a(SentenceInfo paramSentenceInfo, boolean paramBoolean);
  
  void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      ZimuItemView localZimuItemView = (ZimuItemView)localIterator.next();
      localIterator.remove();
      localZimuItemView.b();
    }
  }
  
  public void a(SentenceInfo paramSentenceInfo)
  {
    if ((paramSentenceInfo == null) || (TextUtils.isEmpty(paramSentenceInfo.jdField_a_of_type_JavaLangCharSequence)) || (TextUtils.isEmpty(paramSentenceInfo.jdField_a_of_type_JavaLangString)))
    {
      StringBuilder localStringBuilder = new StringBuilder().append("updateText error:");
      if (paramSentenceInfo == null) {}
      for (paramSentenceInfo = null;; paramSentenceInfo = paramSentenceInfo.toString())
      {
        AVLog.e("ZimuView", paramSentenceInfo);
        return;
      }
    }
    AVLog.e("ZimuView", "updateText :" + paramSentenceInfo.toString());
    if (!this.jdField_a_of_type_ComTencentAvBusinessManagerZimuEffectZimuManager.a())
    {
      g();
      this.jdField_a_of_type_ComTencentAvBusinessManagerZimuEffectZimuManager.b(true);
    }
    a(paramSentenceInfo, false);
  }
  
  protected void a(SentenceInfo paramSentenceInfo, boolean paramBoolean)
  {
    setContentDescription(paramSentenceInfo.jdField_a_of_type_JavaLangCharSequence);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int j;
    for (int i = 0; localIterator.hasNext(); i = j)
    {
      ZimuItemView localZimuItemView = (ZimuItemView)localIterator.next();
      j = i;
      if (!localZimuItemView.a.a())
      {
        j = i;
        if (localZimuItemView.a.jdField_a_of_type_JavaLangString.equals(paramSentenceInfo.jdField_a_of_type_JavaLangString))
        {
          j = 1;
          localZimuItemView.a(paramSentenceInfo);
        }
      }
    }
    if (i == 0)
    {
      paramSentenceInfo = a(paramSentenceInfo, paramBoolean);
      if (paramSentenceInfo != null) {
        this.jdField_a_of_type_JavaUtilList.addAll(paramSentenceInfo);
      }
    }
    e();
  }
  
  protected void a(ZimuItemView paramZimuItemView) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      h();
    }
  }
  
  protected int b()
  {
    return 2131429583;
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_ComTencentAvBusinessManagerZimuEffectZimuManager.a()) {
      f();
    }
  }
  
  protected void b(ZimuItemView paramZimuItemView)
  {
    paramZimuItemView.c();
  }
  
  protected void c()
  {
    Object localObject;
    if ((this.jdField_a_of_type_AndroidGraphicsTypeface == null) && (this.jdField_a_of_type_ComTencentAvBusinessManagerZimuEffectZimuManager != null))
    {
      localObject = a();
      localObject = (ZimuItem)this.jdField_a_of_type_ComTencentAvBusinessManagerZimuEffectZimuManager.a((String)localObject);
      if (localObject != null)
      {
        localObject = this.jdField_a_of_type_ComTencentAvBusinessManagerZimuEffectZimuManager.b((EffectConfigBase.ItemBase)localObject);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = new File((String)localObject + "font.ttf");
          if (!((File)localObject).exists()) {
            break label100;
          }
        }
      }
    }
    try
    {
      this.jdField_a_of_type_AndroidGraphicsTypeface = Typeface.createFromFile((File)localObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    label100:
    AVLog.c("ZimuView", "createTypeface error, font is not found");
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
      ZimuItemView localZimuItemView = (ZimuItemView)localIterator.next();
      localZimuItemView.a(l2);
      if (!localZimuItemView.a())
      {
        if (localZimuItemView.b())
        {
          AVLog.c("ZimuView", "recycle barrage:" + localZimuItemView);
          localZimuItemView.c();
          b(localZimuItemView);
        }
      }
      else
      {
        boolean bool2 = true;
        bool1 = bool2;
        if (!localZimuItemView.c()) {
          continue;
        }
        Bitmap localBitmap = localZimuItemView.a();
        if ((localBitmap != null) && (!localBitmap.isRecycled()))
        {
          paramCanvas.save();
          int i = localZimuItemView.a();
          int j = localZimuItemView.b();
          int k = localBitmap.getWidth();
          int m = localBitmap.getHeight();
          paramCanvas.clipRect(i, j, i + k, j + m);
          paramCanvas.translate(i, j);
          this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, k, m);
          this.jdField_b_of_type_AndroidGraphicsRect.set(0, 0, k, m);
          paramCanvas.drawBitmap(localBitmap, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_b_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
          paramCanvas.restore();
        }
        AVLog.c("ZimuView", "onDraw: " + localZimuItemView.toString());
        bool1 = bool2;
        continue;
      }
      AVLog.c("ZimuView", "remove barrage:" + localZimuItemView);
      localIterator.remove();
      a(localZimuItemView);
      localZimuItemView.b();
    }
    l2 = System.currentTimeMillis();
    AVLog.c("ZimuView", "onDraw needRefresh: " + bool1 + "|" + (l2 - l1));
    if (bool1) {
      d();
    }
  }
  
  public void e()
  {
    super.invalidate();
    long l = System.currentTimeMillis();
    AVLog.c("ZimuView", "Refresh interval:" + (l - this.jdField_a_of_type_Long));
    this.jdField_a_of_type_Long = l;
  }
  
  void f()
  {
    String str1 = getContext().getResources().getString(b());
    String str2 = getContext().getResources().getString(2131429584);
    a(new SentenceInfo(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getAccount(), str1, str2, 2), true);
  }
  
  void g()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((ZimuItemView)localIterator.next()).a(false);
    }
  }
  
  public void h() {}
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    a();
    this.jdField_a_of_type_AndroidGraphicsTypeface = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.funchat.zimu.ZimuView
 * JD-Core Version:    0.7.0.1
 */