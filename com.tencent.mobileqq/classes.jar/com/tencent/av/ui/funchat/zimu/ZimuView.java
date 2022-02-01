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
import com.tencent.av.business.manager.pendant.ItemBase;
import com.tencent.av.business.manager.zimu.EffectZimuManager;
import com.tencent.av.business.manager.zimu.ZimuItem;
import com.tencent.av.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
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
  protected final List<ZimuItemView> a;
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
    setId(2131373660);
    this.jdField_a_of_type_ComTencentAvBusinessManagerZimuEffectZimuManager = ((EffectZimuManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0));
    paramVideoAppInterface = a();
    this.jdField_a_of_type_ComTencentAvBusinessManagerZimuEffectZimuManager.a(paramLong, paramVideoAppInterface);
  }
  
  private long a(long paramLong)
  {
    long l3 = this.jdField_b_of_type_Long;
    long l1 = 0L;
    long l2 = l1;
    if (l3 != 0L)
    {
      l2 = paramLong - l3;
      if (l2 <= 500L) {
        l1 = l2;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" Render Interval: ");
      localStringBuilder.append(l1);
      localStringBuilder.append("|");
      localStringBuilder.append(paramLong - this.jdField_b_of_type_Long);
      AVLog.printColorLog("ZimuView", localStringBuilder.toString());
      l2 = l1;
    }
    this.jdField_b_of_type_Long = paramLong;
    return l2;
  }
  
  public abstract int a();
  
  public abstract String a();
  
  protected abstract List<ZimuItemView> a(SentenceInfo paramSentenceInfo, boolean paramBoolean);
  
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
    if ((paramSentenceInfo != null) && (!TextUtils.isEmpty(paramSentenceInfo.jdField_a_of_type_JavaLangCharSequence)) && (!TextUtils.isEmpty(paramSentenceInfo.jdField_a_of_type_JavaLangString)))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateText :");
      localStringBuilder.append(paramSentenceInfo.toString());
      AVLog.printErrorLog("ZimuView", localStringBuilder.toString());
      if (!this.jdField_a_of_type_ComTencentAvBusinessManagerZimuEffectZimuManager.b())
      {
        g();
        this.jdField_a_of_type_ComTencentAvBusinessManagerZimuEffectZimuManager.b("updateText2", true);
      }
      a(paramSentenceInfo, false);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateText error:");
    if (paramSentenceInfo == null) {
      paramSentenceInfo = null;
    } else {
      paramSentenceInfo = paramSentenceInfo.toString();
    }
    localStringBuilder.append(paramSentenceInfo);
    AVLog.printErrorLog("ZimuView", localStringBuilder.toString());
  }
  
  protected void a(SentenceInfo paramSentenceInfo, boolean paramBoolean)
  {
    setContentDescription(paramSentenceInfo.jdField_a_of_type_JavaLangCharSequence);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      ZimuItemView localZimuItemView = (ZimuItemView)localIterator.next();
      if ((!localZimuItemView.a.a()) && (localZimuItemView.a.jdField_a_of_type_JavaLangString.equals(paramSentenceInfo.jdField_a_of_type_JavaLangString)))
      {
        i = 1;
        localZimuItemView.a(paramSentenceInfo);
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
    return 2131695483;
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_ComTencentAvBusinessManagerZimuEffectZimuManager.b()) {
      f();
    }
  }
  
  protected void b(ZimuItemView paramZimuItemView)
  {
    paramZimuItemView.c();
  }
  
  protected void c()
  {
    if ((this.jdField_a_of_type_AndroidGraphicsTypeface == null) && (this.jdField_a_of_type_ComTencentAvBusinessManagerZimuEffectZimuManager != null))
    {
      String str = a();
      Object localObject = (ZimuItem)this.jdField_a_of_type_ComTencentAvBusinessManagerZimuEffectZimuManager.a(str);
      if (localObject != null)
      {
        localObject = this.jdField_a_of_type_ComTencentAvBusinessManagerZimuEffectZimuManager.b((ItemBase)localObject);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject);
          localStringBuilder.append("font.ttf");
          localObject = new File(localStringBuilder.toString());
          if (((File)localObject).exists())
          {
            try
            {
              this.jdField_a_of_type_AndroidGraphicsTypeface = Typeface.createFromFile((File)localObject);
              return;
            }
            catch (Exception localException)
            {
              if (!AudioHelper.b()) {
                return;
              }
            }
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("createTypeface, Exception, id[");
            localStringBuilder.append(str);
            localStringBuilder.append("]");
            QLog.w("ZimuView", 1, localStringBuilder.toString(), localException);
          }
          else if (AudioHelper.b())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("createTypeface, 不存在, file[");
            localStringBuilder.append(localException.getAbsolutePath());
            localStringBuilder.append("], id[");
            localStringBuilder.append(str);
            localStringBuilder.append("]");
            QLog.w("ZimuView", 1, localStringBuilder.toString());
          }
        }
      }
    }
  }
  
  abstract void d();
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    long l1 = System.currentTimeMillis();
    long l2 = a(l1);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    boolean bool = false;
    while (localIterator.hasNext())
    {
      ZimuItemView localZimuItemView = (ZimuItemView)localIterator.next();
      localZimuItemView.a(l2);
      Object localObject;
      if (!localZimuItemView.a()) {
        if (localZimuItemView.b())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("recycle barrage:");
          ((StringBuilder)localObject).append(localZimuItemView);
          AVLog.printColorLog("ZimuView", ((StringBuilder)localObject).toString());
          localZimuItemView.c();
          b(localZimuItemView);
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("remove barrage:");
          ((StringBuilder)localObject).append(localZimuItemView);
          AVLog.printColorLog("ZimuView", ((StringBuilder)localObject).toString());
          localIterator.remove();
          a(localZimuItemView);
          localZimuItemView.b();
          continue;
        }
      }
      if (localZimuItemView.c())
      {
        localObject = localZimuItemView.a();
        if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
        {
          paramCanvas.save();
          int i = localZimuItemView.a();
          int j = localZimuItemView.b();
          int k = ((Bitmap)localObject).getWidth();
          int m = ((Bitmap)localObject).getHeight();
          paramCanvas.clipRect(i, j, i + k, j + m);
          paramCanvas.translate(i, j);
          this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, k, m);
          this.jdField_b_of_type_AndroidGraphicsRect.set(0, 0, k, m);
          paramCanvas.drawBitmap((Bitmap)localObject, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_b_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
          paramCanvas.restore();
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onDraw: ");
        ((StringBuilder)localObject).append(localZimuItemView.toString());
        AVLog.printColorLog("ZimuView", ((StringBuilder)localObject).toString());
      }
      bool = true;
    }
    l2 = System.currentTimeMillis();
    paramCanvas = new StringBuilder();
    paramCanvas.append("onDraw needRefresh: ");
    paramCanvas.append(bool);
    paramCanvas.append("|");
    paramCanvas.append(l2 - l1);
    AVLog.printColorLog("ZimuView", paramCanvas.toString());
    if (bool) {
      d();
    }
  }
  
  void e()
  {
    super.invalidate();
    long l = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Refresh interval:");
    localStringBuilder.append(l - this.jdField_a_of_type_Long);
    AVLog.printColorLog("ZimuView", localStringBuilder.toString());
    this.jdField_a_of_type_Long = l;
  }
  
  void f()
  {
    String str1 = getContext().getResources().getString(b());
    String str2 = getContext().getResources().getString(2131695484);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.funchat.zimu.ZimuView
 * JD-Core Version:    0.7.0.1
 */