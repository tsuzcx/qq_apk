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
  protected VideoAppInterface a;
  protected Typeface b;
  protected long c;
  protected long d;
  protected int e;
  protected int f;
  protected float g;
  protected final List<ZimuItemView> h = new ArrayList();
  protected EffectZimuManager i;
  private Paint j;
  private Rect k;
  private Rect l;
  
  public ZimuView(long paramLong, VideoAppInterface paramVideoAppInterface, Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramVideoAppInterface;
    this.c = (System.currentTimeMillis() - 100L);
    this.j = new Paint(2);
    this.k = new Rect();
    this.l = new Rect();
    paramVideoAppInterface = (WindowManager)paramContext.getSystemService("window");
    this.e = paramVideoAppInterface.getDefaultDisplay().getWidth();
    this.f = paramVideoAppInterface.getDefaultDisplay().getHeight();
    paramContext = new DisplayMetrics();
    paramVideoAppInterface.getDefaultDisplay().getMetrics(paramContext);
    this.g = paramContext.density;
    setId(2131441334);
    this.i = ((EffectZimuManager)this.a.c(0));
    paramVideoAppInterface = getID();
    this.i.a(paramLong, paramVideoAppInterface);
  }
  
  private long a(long paramLong)
  {
    long l3 = this.d;
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
      localStringBuilder.append(paramLong - this.d);
      AVLog.printColorLog("ZimuView", localStringBuilder.toString());
      l2 = l1;
    }
    this.d = paramLong;
    return l2;
  }
  
  void a()
  {
    Iterator localIterator = this.h.iterator();
    while (localIterator.hasNext())
    {
      ZimuItemView localZimuItemView = (ZimuItemView)localIterator.next();
      localIterator.remove();
      localZimuItemView.c();
    }
  }
  
  public void a(SentenceInfo paramSentenceInfo)
  {
    if ((paramSentenceInfo != null) && (!TextUtils.isEmpty(paramSentenceInfo.b)) && (!TextUtils.isEmpty(paramSentenceInfo.a)))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateText :");
      localStringBuilder.append(paramSentenceInfo.toString());
      AVLog.printErrorLog("ZimuView", localStringBuilder.toString());
      if (!this.i.j())
      {
        g();
        this.i.b("updateText2", true);
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
    setContentDescription(paramSentenceInfo.b);
    Iterator localIterator = this.h.iterator();
    int m = 0;
    while (localIterator.hasNext())
    {
      ZimuItemView localZimuItemView = (ZimuItemView)localIterator.next();
      if ((!localZimuItemView.l.a()) && (localZimuItemView.l.a.equals(paramSentenceInfo.a)))
      {
        m = 1;
        localZimuItemView.a(paramSentenceInfo);
      }
    }
    if (m == 0)
    {
      paramSentenceInfo = b(paramSentenceInfo, paramBoolean);
      if (paramSentenceInfo != null) {
        this.h.addAll(paramSentenceInfo);
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
  
  protected abstract List<ZimuItemView> b(SentenceInfo paramSentenceInfo, boolean paramBoolean);
  
  public void b()
  {
    if (!this.i.j()) {
      f();
    }
  }
  
  protected void b(ZimuItemView paramZimuItemView)
  {
    paramZimuItemView.e();
  }
  
  protected void c()
  {
    if ((this.b == null) && (this.i != null))
    {
      String str = getID();
      Object localObject = (ZimuItem)this.i.b(str);
      if (localObject != null)
      {
        localObject = this.i.b((ItemBase)localObject);
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
              this.b = Typeface.createFromFile((File)localObject);
              return;
            }
            catch (Exception localException)
            {
              if (!AudioHelper.e()) {
                return;
              }
            }
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("createTypeface, Exception, id[");
            localStringBuilder.append(str);
            localStringBuilder.append("]");
            QLog.w("ZimuView", 1, localStringBuilder.toString(), localException);
          }
          else if (AudioHelper.e())
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
    Iterator localIterator = this.h.iterator();
    boolean bool = false;
    while (localIterator.hasNext())
    {
      ZimuItemView localZimuItemView = (ZimuItemView)localIterator.next();
      localZimuItemView.a(l2);
      Object localObject;
      if (!localZimuItemView.a()) {
        if (localZimuItemView.d())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("recycle barrage:");
          ((StringBuilder)localObject).append(localZimuItemView);
          AVLog.printColorLog("ZimuView", ((StringBuilder)localObject).toString());
          localZimuItemView.e();
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
          localZimuItemView.c();
          continue;
        }
      }
      if (localZimuItemView.j())
      {
        localObject = localZimuItemView.k();
        if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
        {
          paramCanvas.save();
          int m = localZimuItemView.f();
          int n = localZimuItemView.g();
          int i1 = ((Bitmap)localObject).getWidth();
          int i2 = ((Bitmap)localObject).getHeight();
          paramCanvas.clipRect(m, n, m + i1, n + i2);
          paramCanvas.translate(m, n);
          this.k.set(0, 0, i1, i2);
          this.l.set(0, 0, i1, i2);
          paramCanvas.drawBitmap((Bitmap)localObject, this.k, this.l, this.j);
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
    long l1 = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Refresh interval:");
    localStringBuilder.append(l1 - this.c);
    AVLog.printColorLog("ZimuView", localStringBuilder.toString());
    this.c = l1;
  }
  
  void f()
  {
    String str1 = getContext().getResources().getString(getGuideChId());
    String str2 = getContext().getResources().getString(2131893243);
    a(new SentenceInfo(this.a.getAccount(), str1, str2, 2), true);
  }
  
  void g()
  {
    Iterator localIterator = this.h.iterator();
    while (localIterator.hasNext()) {
      ((ZimuItemView)localIterator.next()).a(false);
    }
  }
  
  protected int getGuideChId()
  {
    return 2131893242;
  }
  
  public abstract String getID();
  
  public abstract int getViewHeight();
  
  public void h() {}
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    a();
    this.b = null;
    this.a.e(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.funchat.zimu.ZimuView
 * JD-Core Version:    0.7.0.1
 */