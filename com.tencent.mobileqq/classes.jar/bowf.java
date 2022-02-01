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
public class bowf
  extends bown
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
  bolc jdField_a_of_type_Bolc = new bolc();
  public bowg a;
  public bowi a;
  public bpdf a;
  public ArrayList<bowi> a;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  bowi jdField_b_of_type_Bowi;
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
    jdField_a_of_type_JavaLangString = bowf.class.getSimpleName();
    jdField_b_of_type_Int = bphx.a[1];
    c = Color.parseColor("#80000000");
    e = 270;
    f = 5;
  }
  
  public bowf(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    o();
  }
  
  private void a(bowi parambowi)
  {
    boolean bool1 = this.jdField_a_of_type_Bpdf.a(parambowi, StoryGuideLineView.jdField_a_of_type_Int, true);
    boolean bool2 = this.jdField_a_of_type_Bpdf.a(parambowi, StoryGuideLineView.jdField_b_of_type_Int, false);
    boolean bool3 = this.jdField_a_of_type_Bpdf.b(parambowi, StoryGuideLineView.d, false);
    if (this.jdField_a_of_type_Bowg != null) {
      this.jdField_a_of_type_Bowg.a(bool1, bool2, false, bool3, parambowi.l);
    }
    if (parambowi != null)
    {
      if (parambowi.k) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(parambowi.l, parambowi.r, parambowi.s, parambowi.t, parambowi.jdField_a_of_type_AndroidGraphicsPointF, parambowi.m, 2);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(parambowi.l, parambowi.r, parambowi.s, parambowi.t, parambowi.jdField_a_of_type_AndroidGraphicsPointF, parambowi.m, 1);
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
    ykq.b(jdField_a_of_type_JavaLangString, "isRubbish:" + bool + " brand:" + str);
    return bool;
  }
  
  private void o()
  {
    this.k = AIOUtils.dp2px(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.i = bpdd.a(this.jdField_a_of_type_AndroidContentContext);
    this.h = 1;
    this.g = 1;
    this.jdField_a_of_type_Bpdf = new bpdf();
    this.jdField_a_of_type_Bpdf.a(6.0F);
    this.jdField_a_of_type_Bpdf.b(0.2F);
    this.jdField_a_of_type_Bpdf.a(true);
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
  
  public bowi a()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > f))
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_Bowi);
      return this.jdField_a_of_type_Bowi;
    }
    return null;
  }
  
  public DynamicTextItem a()
  {
    if (this.jdField_a_of_type_Bowi != null) {
      return this.jdField_a_of_type_Bowi.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem;
    }
    return null;
  }
  
  public DynamicTextItem a(int paramInt)
  {
    return a(null, null, paramInt);
  }
  
  public DynamicTextItem a(bowh parambowh, SegmentKeeper paramSegmentKeeper, int paramInt)
  {
    DynamicTextItem localDynamicTextItem = null;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() < f) {
      if (parambowh == null) {
        break label70;
      }
    }
    label70:
    for (parambowh = new bowi(this, parambowh);; parambowh = new bowi(this))
    {
      parambowh.jdField_a_of_type_Int = paramInt;
      parambowh.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper = new SegmentKeeper(paramSegmentKeeper);
      this.jdField_a_of_type_JavaUtilArrayList.add(parambowh);
      localDynamicTextItem = parambowh.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem;
      this.jdField_a_of_type_Bowi = parambowh;
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
    this.jdField_a_of_type_Bowi = null;
    ykq.b(jdField_a_of_type_JavaLangString, "clear over");
  }
  
  public void a(int paramInt)
  {
    ykq.b(jdField_a_of_type_JavaLangString, "setMode:" + paramInt + ",preMode:" + this.h);
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
    bowi localbowi;
    if (this.g == 6)
    {
      if (this.jdField_b_of_type_Bowi != null) {
        this.jdField_b_of_type_Bowi.a(paramCanvas);
      }
      localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        localbowi = (bowi)localIterator.next();
        if ((this.jdField_b_of_type_Bowi != null) && (localbowi.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem != this.jdField_b_of_type_Bowi.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem)) {
          localbowi.a(paramCanvas);
        }
      }
    }
    if ((this.g == 4) || (this.g == 3)) {
      localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    }
    while (localIterator.hasNext())
    {
      ((bowi)localIterator.next()).a(paramCanvas);
      continue;
      if (this.g == 5)
      {
        localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          localbowi = (bowi)localIterator.next();
          if (localbowi.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem != this.jdField_a_of_type_Bowi.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem) {
            localbowi.a(paramCanvas);
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
      bowi localbowi = (bowi)localIterator.next();
      if (((!localbowi.b()) && (!localbowi.c())) || (paramBoolean)) {
        localbowi.a(paramCanvas);
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
  
  public void a(bowg parambowg)
  {
    this.jdField_a_of_type_Bowg = parambowg;
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
        bowi localbowi = (bowi)localIterator.next();
        if (!paramDynamicTextItem.equals(localbowi.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem)) {
          break label72;
        }
        localObject = localbowi;
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
        bowi localbowi = ((TextParcelData)paramArrayList.next()).a(this);
        if (!paramBoolean)
        {
          localbowi.c(true);
          localbowi.jdField_a_of_type_Int = 1;
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(localbowi);
      } while (this.jdField_a_of_type_JavaUtilArrayList.size() <= f);
    }
    k();
  }
  
  public void a(boolean paramBoolean)
  {
    ykq.b(jdField_a_of_type_JavaLangString, "setKeyboardState:" + paramBoolean);
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
      if (((bowi)localIterator.next()).jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.isSegmentChanged(paramLong)) {
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
        this.jdField_a_of_type_Bpdf.a(paramMotionEvent, false);
        if (this.jdField_a_of_type_Bowi == null) {
          p();
        }
        break;
      }
    }
    for (;;)
    {
      bool = true;
      return bool;
      this.jdField_a_of_type_Bpdf.a(this.jdField_a_of_type_Bowi);
      j();
      this.jdField_a_of_type_Bowi.b();
      this.l = i1;
      break;
      this.jdField_a_of_type_Bowi.c();
      break;
      if (this.g == 3) {
        this.jdField_a_of_type_Bowi.c();
      }
      if (i2 <= d) {
        break;
      }
      a(3);
      break;
      if (this.jdField_a_of_type_Bowi != null) {
        this.jdField_a_of_type_Bowi.c();
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
      a(this.jdField_a_of_type_Bowi);
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
      ykq.e(jdField_a_of_type_JavaLangString, "setTextTop:" + paramInt);
      return;
    }
    ykq.b(jdField_a_of_type_JavaLangString, "setTextTop:" + paramInt);
    this.m = paramInt;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt2 < 0))
    {
      ykq.e(jdField_a_of_type_JavaLangString, "setTextOffset x:" + paramInt1 + "y=" + paramInt2);
      return;
    }
    ykq.b(jdField_a_of_type_JavaLangString, "setTextTop:" + paramInt1 + "y=" + paramInt2);
    this.n = paramInt1;
    this.o = paramInt2;
  }
  
  public void b(Canvas paramCanvas)
  {
    a(paramCanvas, this.jdField_a_of_type_Float, false);
  }
  
  public void b(DynamicTextItem paramDynamicTextItem)
  {
    if (this.jdField_a_of_type_Bowi != null)
    {
      this.jdField_a_of_type_Bowi.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem = paramDynamicTextItem;
      this.jdField_a_of_type_Bowi.u = paramDynamicTextItem.a();
      this.jdField_a_of_type_Bowi.v = paramDynamicTextItem.b();
    }
    if (this.jdField_b_of_type_Bowi != null)
    {
      this.jdField_b_of_type_Bowi.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem = paramDynamicTextItem;
      if (this.jdField_a_of_type_Bowi != null)
      {
        this.jdField_b_of_type_Bowi.q = this.jdField_a_of_type_Bowi.q;
        this.jdField_b_of_type_Bowi.b = this.jdField_a_of_type_Bowi.q;
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
        paramMotionEvent = (bowi)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
        if ((paramMotionEvent != null) && (paramMotionEvent.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper != null) && (paramMotionEvent.c()) && (!paramMotionEvent.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.isCurrentIn())) {}
        while (!this.jdField_a_of_type_Bpdf.a(paramMotionEvent, f1, f2, false))
        {
          i1 -= 1;
          break;
        }
        this.jdField_a_of_type_Bowi = paramMotionEvent;
      }
    }
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_Bowi);
        this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_Bowi);
      }
      return bool;
    }
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_Bowg != null) && (this.jdField_a_of_type_Bowi != null))
    {
      if (this.jdField_a_of_type_Bowg.a(this.jdField_a_of_type_Bowi)) {
        this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_Bowi);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Bowg.a(this.jdField_a_of_type_Bowi.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem);
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
      if (this.jdField_a_of_type_Bowi != null)
      {
        this.jdField_b_of_type_Bowi = new bowi(this, this.jdField_a_of_type_Bowi);
        this.jdField_b_of_type_Bowi.a();
        bowi.a(this.jdField_b_of_type_Bowi);
      }
    }
    while (this.jdField_a_of_type_Bowg == null) {
      return;
    }
    this.jdField_a_of_type_Bowg.a(1.0F);
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
        bowi localbowi = (bowi)((Iterator)localObject2).next();
        if ((localbowi.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem != null) && (localbowi.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.e())) {
          ((List)localObject1).add(localbowi);
        }
      }
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (bowi)((Iterator)localObject1).next();
      this.jdField_a_of_type_JavaUtilArrayList.remove(localObject2);
    }
    if ((this.jdField_a_of_type_Bowi != null) && (this.jdField_a_of_type_Bowi.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem != null) && (this.jdField_a_of_type_Bowi.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.e())) {
      this.jdField_a_of_type_Bowi = null;
    }
  }
  
  public void g()
  {
    if (this.jdField_b_of_type_Bowi != null)
    {
      a(6);
      bowi.b(this.jdField_b_of_type_Bowi);
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Bowi != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_Bowi);
      this.jdField_a_of_type_Bowi.c();
      ykq.b(jdField_a_of_type_JavaLangString, "delete " + this.jdField_a_of_type_Bowi);
      this.jdField_a_of_type_Bowi = null;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
    {
      this.g = 1;
      this.h = 1;
    }
  }
  
  public void i()
  {
    if ((this.jdField_a_of_type_Bowi != null) && (this.jdField_a_of_type_Bowi.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem != null)) {
      this.jdField_a_of_type_Bowi.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a(-1, false);
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        bowi localbowi = (bowi)localIterator.next();
        if (localbowi.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem != null) {
          localbowi.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a(-1, false);
        }
      }
    }
    k();
  }
  
  public void j()
  {
    if ((this.jdField_a_of_type_Bowi != null) && (!this.jdField_a_of_type_Bowi.a())) {
      this.jdField_a_of_type_Bowi.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bowf
 * JD-Core Version:    0.7.0.1
 */