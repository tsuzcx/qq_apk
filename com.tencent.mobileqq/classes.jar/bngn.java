import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.qq.im.capture.text.TextParcelData;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.StoryGuideLineView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@TargetApi(14)
public class bngn
  extends bngv
{
  public static int a;
  public static final String a;
  public static final int b;
  private static String jdField_b_of_type_JavaLangString = "TextLayer";
  public static final int c;
  public static int d;
  public static int e;
  public static volatile int f;
  public Paint a;
  PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF();
  bmvk jdField_a_of_type_Bmvk = new bmvk();
  public bngo a;
  public bngq a;
  public bnnn a;
  public ArrayList<bngq> a;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  bngq jdField_b_of_type_Bngq;
  public int g;
  public int h;
  public int i;
  public int j = c;
  public int k;
  public int l;
  public int m;
  public int n;
  public int o;
  
  static
  {
    jdField_a_of_type_JavaLangString = bngn.class.getSimpleName();
    jdField_b_of_type_Int = bnsf.a[1];
    c = Color.parseColor("#80000000");
    e = 270;
    f = 5;
  }
  
  public bngn(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    o();
  }
  
  private void a(bngq parambngq)
  {
    boolean bool1 = this.jdField_a_of_type_Bnnn.a(parambngq, StoryGuideLineView.jdField_a_of_type_Int, true);
    boolean bool2 = this.jdField_a_of_type_Bnnn.a(parambngq, StoryGuideLineView.jdField_b_of_type_Int, false);
    boolean bool3 = this.jdField_a_of_type_Bnnn.b(parambngq, StoryGuideLineView.d, false);
    if (this.jdField_a_of_type_Bngo != null) {
      this.jdField_a_of_type_Bngo.a(bool1, bool2, false, bool3, parambngq.l);
    }
    if (parambngq != null)
    {
      if (parambngq.k) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(parambngq.l, parambngq.r, parambngq.s, parambngq.t, parambngq.jdField_a_of_type_AndroidGraphicsPointF, parambngq.m, 2);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(parambngq.l, parambngq.r, parambngq.s, parambngq.t, parambngq.jdField_a_of_type_AndroidGraphicsPointF, parambngq.m, 1);
  }
  
  public static void c(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        f -= 1;
        f = Math.min(f, 5);
        f = Math.max(f, 4);
        return;
      }
      finally {}
      f += 1;
    }
  }
  
  private boolean e()
  {
    boolean bool = false;
    String str = Build.MANUFACTURER + "-" + Build.MODEL;
    if ((str.equalsIgnoreCase("vivo-vivo X6Plus D")) || (str.equalsIgnoreCase("motorola-Nexus 6"))) {
      bool = true;
    }
    xvv.b(jdField_a_of_type_JavaLangString, "isRubbish:" + bool + " brand:" + str);
    return bool;
  }
  
  private void o()
  {
    this.k = AIOUtils.dp2px(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.i = bnnl.a(this.jdField_a_of_type_AndroidContentContext);
    this.h = 1;
    this.g = 1;
    this.jdField_a_of_type_Bnnn = new bnnn();
    this.jdField_a_of_type_Bnnn.a(6.0F);
    this.jdField_a_of_type_Bnnn.b(0.2F);
    this.jdField_a_of_type_Bnnn.a(true);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(2.0F);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    d = ViewConfiguration.get(this.jdField_a_of_type_AndroidContentContext).getScaledTouchSlop();
    if ((e == 270) && (e())) {
      e = 540;
    }
  }
  
  private void p()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(false, 0.0F, 0.0F, 0.0F, null, false, 1);
  }
  
  public bngq a()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > f))
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_Bngq);
      return this.jdField_a_of_type_Bngq;
    }
    return null;
  }
  
  public DynamicTextItem a()
  {
    if (this.jdField_a_of_type_Bngq != null) {
      return this.jdField_a_of_type_Bngq.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem;
    }
    return null;
  }
  
  public DynamicTextItem a(int paramInt)
  {
    return a(null, null, paramInt);
  }
  
  public DynamicTextItem a(bngp parambngp, SegmentKeeper paramSegmentKeeper, int paramInt)
  {
    DynamicTextItem localDynamicTextItem = null;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() < f) {
      if (parambngp == null) {
        break label70;
      }
    }
    label70:
    for (parambngp = new bngq(this, parambngp);; parambngp = new bngq(this))
    {
      parambngp.jdField_a_of_type_Int = paramInt;
      parambngp.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper = new SegmentKeeper(paramSegmentKeeper);
      this.jdField_a_of_type_JavaUtilArrayList.add(parambngp);
      localDynamicTextItem = parambngp.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem;
      this.jdField_a_of_type_Bngq = parambngp;
      return localDynamicTextItem;
    }
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    this.g = 1;
    this.h = 1;
    this.j = c;
    this.m = 0;
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_Bngq = null;
    xvv.b(jdField_a_of_type_JavaLangString, "clear over");
  }
  
  public void a(int paramInt)
  {
    xvv.b(jdField_a_of_type_JavaLangString, "setMode:" + paramInt + ",preMode:" + this.h);
    this.h = this.g;
    this.g = paramInt;
    if (paramInt == 4) {
      n();
    }
    super.k();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    this.jdField_a_of_type_AndroidGraphicsPointF.x = (paramInt1 / 2);
    this.jdField_a_of_type_AndroidGraphicsPointF.y = (0.42F * paramInt2);
    jdField_a_of_type_Int = (int)(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.b() * 0.04F);
  }
  
  protected void a(Canvas paramCanvas)
  {
    Iterator localIterator;
    bngq localbngq;
    if (this.g == 6)
    {
      if (this.jdField_b_of_type_Bngq != null) {
        this.jdField_b_of_type_Bngq.a(paramCanvas);
      }
      localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        localbngq = (bngq)localIterator.next();
        if ((this.jdField_b_of_type_Bngq != null) && (localbngq.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem != this.jdField_b_of_type_Bngq.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem)) {
          localbngq.a(paramCanvas);
        }
      }
    }
    if ((this.g == 4) || (this.g == 3)) {
      localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    }
    while (localIterator.hasNext())
    {
      ((bngq)localIterator.next()).a(paramCanvas);
      continue;
      if (this.g == 5)
      {
        localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          localbngq = (bngq)localIterator.next();
          if (localbngq.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem != this.jdField_a_of_type_Bngq.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem) {
            localbngq.a(paramCanvas);
          }
        }
      }
    }
  }
  
  public void a(Canvas paramCanvas, float paramFloat, boolean paramBoolean)
  {
    paramCanvas.save();
    paramCanvas.scale(paramFloat, paramFloat);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      bngq localbngq = (bngq)localIterator.next();
      if (((!localbngq.b()) && (!localbngq.c())) || (paramBoolean)) {
        localbngq.a(paramCanvas);
      }
    }
    paramCanvas.restore();
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    super.a(paramBundle);
    a(paramBundle.getParcelableArrayList("TextParcelDataList"), paramBundle.getBoolean("edit_type_photo"));
  }
  
  public void a(bngo parambngo)
  {
    this.jdField_a_of_type_Bngo = parambngo;
  }
  
  public void a(DynamicTextItem paramDynamicTextItem)
  {
    Object localObject;
    if ((paramDynamicTextItem != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      localObject = null;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (localIterator.hasNext())
      {
        bngq localbngq = (bngq)localIterator.next();
        if (!paramDynamicTextItem.equals(localbngq.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem)) {
          break label72;
        }
        localObject = localbngq;
      }
    }
    label72:
    for (;;)
    {
      break;
      this.jdField_a_of_type_JavaUtilArrayList.remove(localObject);
      return;
    }
  }
  
  public void a(ArrayList<TextParcelData> paramArrayList, boolean paramBoolean)
  {
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      a(4);
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      paramArrayList = paramArrayList.iterator();
      do
      {
        if (!paramArrayList.hasNext()) {
          break;
        }
        bngq localbngq = ((TextParcelData)paramArrayList.next()).a(this);
        if (!paramBoolean)
        {
          localbngq.c(true);
          localbngq.jdField_a_of_type_Int = 1;
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(localbngq);
      } while (this.jdField_a_of_type_JavaUtilArrayList.size() <= f);
    }
    k();
  }
  
  public void a(boolean paramBoolean)
  {
    xvv.b(jdField_a_of_type_JavaLangString, "setKeyboardState:" + paramBoolean);
    if (paramBoolean) {}
    for (;;)
    {
      super.k();
      return;
      a(4);
    }
  }
  
  public boolean a()
  {
    return this.g == 1;
  }
  
  public boolean a(long paramLong)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      if (((bngq)localIterator.next()).jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.isSegmentChanged(paramLong)) {
        return false;
      }
    }
    return true;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    int i1;
    int i2;
    if (b())
    {
      i1 = (int)paramMotionEvent.getY();
      i2 = Math.abs(i1 - this.l);
      switch (paramMotionEvent.getAction() & 0xFF)
      {
      case 3: 
      case 4: 
      default: 
        this.jdField_a_of_type_Bnnn.a(paramMotionEvent, false);
        if (this.jdField_a_of_type_Bngq == null) {
          p();
        }
        break;
      }
    }
    for (;;)
    {
      bool = true;
      return bool;
      this.jdField_a_of_type_Bnnn.a(this.jdField_a_of_type_Bngq);
      j();
      this.jdField_a_of_type_Bngq.b();
      this.l = i1;
      break;
      this.jdField_a_of_type_Bngq.c();
      break;
      if (this.g == 3) {
        this.jdField_a_of_type_Bngq.c();
      }
      if (i2 <= d) {
        break;
      }
      a(3);
      break;
      if (this.jdField_a_of_type_Bngq != null) {
        this.jdField_a_of_type_Bngq.c();
      }
      a(this, false);
      n();
      if (i2 < d)
      {
        c();
        break;
      }
      if (this.g != 3) {
        break;
      }
      a(4);
      break;
      a(this.jdField_a_of_type_Bngq);
    }
  }
  
  public int b()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
      return this.jdField_a_of_type_JavaUtilArrayList.size();
    }
    if (b()) {
      return 1;
    }
    return 0;
  }
  
  public void b(int paramInt)
  {
    if (paramInt < 0)
    {
      xvv.e(jdField_a_of_type_JavaLangString, "setTextTop:" + paramInt);
      return;
    }
    xvv.b(jdField_a_of_type_JavaLangString, "setTextTop:" + paramInt);
    this.m = paramInt;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt2 < 0))
    {
      xvv.e(jdField_a_of_type_JavaLangString, "setTextOffset x:" + paramInt1 + "y=" + paramInt2);
      return;
    }
    xvv.b(jdField_a_of_type_JavaLangString, "setTextTop:" + paramInt1 + "y=" + paramInt2);
    this.n = paramInt1;
    this.o = paramInt2;
  }
  
  public void b(Canvas paramCanvas)
  {
    a(paramCanvas, this.jdField_a_of_type_Float, false);
  }
  
  public void b(DynamicTextItem paramDynamicTextItem)
  {
    if (this.jdField_a_of_type_Bngq != null)
    {
      this.jdField_a_of_type_Bngq.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem = paramDynamicTextItem;
      this.jdField_a_of_type_Bngq.u = paramDynamicTextItem.a();
      this.jdField_a_of_type_Bngq.v = paramDynamicTextItem.b();
    }
    if (this.jdField_b_of_type_Bngq != null)
    {
      this.jdField_b_of_type_Bngq.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem = paramDynamicTextItem;
      if (this.jdField_a_of_type_Bngq != null)
      {
        this.jdField_b_of_type_Bngq.q = this.jdField_a_of_type_Bngq.q;
        this.jdField_b_of_type_Bngq.b = this.jdField_a_of_type_Bngq.q;
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    a(5);
    if (paramBoolean) {
      d();
    }
  }
  
  public boolean b()
  {
    return (this.g == 4) || (this.g == 3);
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    if (b())
    {
      float f1 = paramMotionEvent.getX(0);
      float f2 = paramMotionEvent.getY(0);
      int i1 = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
      if (i1 >= 0)
      {
        paramMotionEvent = (bngq)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
        if ((paramMotionEvent != null) && (paramMotionEvent.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper != null) && (paramMotionEvent.c()) && (!paramMotionEvent.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.isCurrentIn())) {}
        while (!this.jdField_a_of_type_Bnnn.a(paramMotionEvent, f1, f2, false))
        {
          i1 -= 1;
          break;
        }
        this.jdField_a_of_type_Bngq = paramMotionEvent;
      }
    }
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_Bngq);
        this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_Bngq);
      }
      return bool;
    }
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_Bngo != null) && (this.jdField_a_of_type_Bngq != null))
    {
      if (this.jdField_a_of_type_Bngo.a(this.jdField_a_of_type_Bngq)) {
        this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_Bngq);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Bngo.a(this.jdField_a_of_type_Bngq.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem);
  }
  
  public boolean c()
  {
    return (this.n > 0) && (this.o > 0);
  }
  
  public void d()
  {
    if (!a())
    {
      a(6);
      if (this.jdField_a_of_type_Bngq != null)
      {
        this.jdField_b_of_type_Bngq = new bngq(this, this.jdField_a_of_type_Bngq);
        this.jdField_b_of_type_Bngq.a();
        bngq.a(this.jdField_b_of_type_Bngq);
      }
    }
    while (this.jdField_a_of_type_Bngo == null) {
      return;
    }
    this.jdField_a_of_type_Bngo.a(1.0F);
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
      this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
    }
  }
  
  public void f()
  {
    Object localObject1 = new ArrayList();
    Object localObject2;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        bngq localbngq = (bngq)((Iterator)localObject2).next();
        if ((localbngq.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem != null) && (localbngq.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.e())) {
          ((List)localObject1).add(localbngq);
        }
      }
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (bngq)((Iterator)localObject1).next();
      this.jdField_a_of_type_JavaUtilArrayList.remove(localObject2);
    }
    if ((this.jdField_a_of_type_Bngq != null) && (this.jdField_a_of_type_Bngq.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem != null) && (this.jdField_a_of_type_Bngq.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.e())) {
      this.jdField_a_of_type_Bngq = null;
    }
  }
  
  public void g()
  {
    if (this.jdField_b_of_type_Bngq != null)
    {
      a(6);
      bngq.b(this.jdField_b_of_type_Bngq);
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Bngq != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_Bngq);
      this.jdField_a_of_type_Bngq.c();
      xvv.b(jdField_a_of_type_JavaLangString, "delete " + this.jdField_a_of_type_Bngq);
      this.jdField_a_of_type_Bngq = null;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
    {
      this.g = 1;
      this.h = 1;
    }
  }
  
  public void i()
  {
    if ((this.jdField_a_of_type_Bngq != null) && (this.jdField_a_of_type_Bngq.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem != null)) {
      this.jdField_a_of_type_Bngq.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a(-1, false);
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        bngq localbngq = (bngq)localIterator.next();
        if (localbngq.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem != null) {
          localbngq.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a(-1, false);
        }
      }
    }
    k();
  }
  
  public void j()
  {
    if ((this.jdField_a_of_type_Bngq != null) && (!this.jdField_a_of_type_Bngq.a())) {
      this.jdField_a_of_type_Bngq.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bngn
 * JD-Core Version:    0.7.0.1
 */