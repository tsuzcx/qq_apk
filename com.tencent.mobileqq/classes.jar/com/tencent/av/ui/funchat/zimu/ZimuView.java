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
import lbj;
import lgi;
import lgr;
import lix;
import mot;

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
  protected final List<mot> a;
  protected lix a;
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
    setId(2131373658);
    this.jdField_a_of_type_Lix = ((lix)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0));
    paramVideoAppInterface = a();
    this.jdField_a_of_type_Lix.a(paramLong, paramVideoAppInterface);
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
      lbj.c("ZimuView", " Render Interval: " + l1 + "|" + (paramLong - this.jdField_b_of_type_Long));
      l2 = l1;
      this.jdField_b_of_type_Long = paramLong;
      return l2;
      label80:
      l1 = l2;
    }
  }
  
  public abstract int a();
  
  public abstract String a();
  
  protected abstract List<mot> a(lgi paramlgi, boolean paramBoolean);
  
  void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      mot localmot = (mot)localIterator.next();
      localIterator.remove();
      localmot.b();
    }
  }
  
  public void a(lgi paramlgi)
  {
    if ((paramlgi == null) || (TextUtils.isEmpty(paramlgi.jdField_a_of_type_JavaLangCharSequence)) || (TextUtils.isEmpty(paramlgi.jdField_a_of_type_JavaLangString)))
    {
      StringBuilder localStringBuilder = new StringBuilder().append("updateText error:");
      if (paramlgi == null) {}
      for (paramlgi = null;; paramlgi = paramlgi.toString())
      {
        lbj.e("ZimuView", paramlgi);
        return;
      }
    }
    lbj.e("ZimuView", "updateText :" + paramlgi.toString());
    if (!this.jdField_a_of_type_Lix.a())
    {
      g();
      this.jdField_a_of_type_Lix.b("updateText2", true);
    }
    a(paramlgi, false);
  }
  
  protected void a(lgi paramlgi, boolean paramBoolean)
  {
    setContentDescription(paramlgi.jdField_a_of_type_JavaLangCharSequence);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int j;
    for (int i = 0; localIterator.hasNext(); i = j)
    {
      mot localmot = (mot)localIterator.next();
      j = i;
      if (!localmot.a.a())
      {
        j = i;
        if (localmot.a.jdField_a_of_type_JavaLangString.equals(paramlgi.jdField_a_of_type_JavaLangString))
        {
          j = 1;
          localmot.a(paramlgi);
        }
      }
    }
    if (i == 0)
    {
      paramlgi = a(paramlgi, paramBoolean);
      if (paramlgi != null) {
        this.jdField_a_of_type_JavaUtilList.addAll(paramlgi);
      }
    }
    e();
  }
  
  protected void a(mot parammot) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      h();
    }
  }
  
  protected int b()
  {
    return 2131694878;
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_Lix.a()) {
      f();
    }
  }
  
  protected void b(mot parammot)
  {
    parammot.c();
  }
  
  protected void c()
  {
    String str;
    Object localObject;
    if ((this.jdField_a_of_type_AndroidGraphicsTypeface == null) && (this.jdField_a_of_type_Lix != null))
    {
      str = a();
      localObject = (ZimuItem)this.jdField_a_of_type_Lix.a(str);
      if (localObject != null)
      {
        localObject = this.jdField_a_of_type_Lix.b((lgr)localObject);
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
    while (!AudioHelper.f()) {
      try
      {
        this.jdField_a_of_type_AndroidGraphicsTypeface = Typeface.createFromFile((File)localObject);
        return;
      }
      catch (Exception localException)
      {
        while (!AudioHelper.f()) {}
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
      mot localmot = (mot)localIterator.next();
      localmot.a(l2);
      if (!localmot.a())
      {
        if (localmot.b())
        {
          lbj.c("ZimuView", "recycle barrage:" + localmot);
          localmot.c();
          b(localmot);
        }
      }
      else
      {
        boolean bool2 = true;
        bool1 = bool2;
        if (!localmot.c()) {
          continue;
        }
        Bitmap localBitmap = localmot.a();
        if ((localBitmap != null) && (!localBitmap.isRecycled()))
        {
          paramCanvas.save();
          int i = localmot.a();
          int j = localmot.b();
          int k = localBitmap.getWidth();
          int m = localBitmap.getHeight();
          paramCanvas.clipRect(i, j, i + k, j + m);
          paramCanvas.translate(i, j);
          this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, k, m);
          this.jdField_b_of_type_AndroidGraphicsRect.set(0, 0, k, m);
          paramCanvas.drawBitmap(localBitmap, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_b_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
          paramCanvas.restore();
        }
        lbj.c("ZimuView", "onDraw: " + localmot.toString());
        bool1 = bool2;
        continue;
      }
      lbj.c("ZimuView", "remove barrage:" + localmot);
      localIterator.remove();
      a(localmot);
      localmot.b();
    }
    l2 = System.currentTimeMillis();
    lbj.c("ZimuView", "onDraw needRefresh: " + bool1 + "|" + (l2 - l1));
    if (bool1) {
      d();
    }
  }
  
  public void e()
  {
    super.invalidate();
    long l = System.currentTimeMillis();
    lbj.c("ZimuView", "Refresh interval:" + (l - this.jdField_a_of_type_Long));
    this.jdField_a_of_type_Long = l;
  }
  
  void f()
  {
    String str1 = getContext().getResources().getString(b());
    String str2 = getContext().getResources().getString(2131694879);
    a(new lgi(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getAccount(), str1, str2, 2), true);
  }
  
  void g()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((mot)localIterator.next()).a(false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.funchat.zimu.ZimuView
 * JD-Core Version:    0.7.0.1
 */