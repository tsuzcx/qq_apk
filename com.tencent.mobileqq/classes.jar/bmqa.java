import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.MotionEvent;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

public class bmqa
  extends bmri
{
  public static final String a;
  public int a;
  public Paint a;
  public TextPaint a;
  public bmqb a;
  private bmqc jdField_a_of_type_Bmqc;
  private bmyi jdField_a_of_type_Bmyi;
  public List<bmqb> a;
  public boolean a;
  public int b;
  public Paint b;
  private String b;
  public boolean b;
  private boolean d = true;
  
  static
  {
    jdField_a_of_type_JavaLangString = bmqa.class.getSimpleName();
  }
  
  public bmqa(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaLangString = jdField_a_of_type_JavaLangString;
    c();
  }
  
  public bmqa(DoodleView paramDoodleView, String paramString)
  {
    this(paramDoodleView);
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    if (a(paramMotionEvent.getX(0), paramMotionEvent.getY(0)))
    {
      this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_Bmqb);
      this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_Bmqb);
    }
  }
  
  private void a(bmqb parambmqb, Canvas paramCanvas)
  {
    wxe.c(jdField_a_of_type_JavaLangString, "drawItem start.");
    if (parambmqb == null) {
      return;
    }
    paramCanvas.save();
    paramCanvas.concat(this.jdField_a_of_type_Bmyi.a(parambmqb));
    parambmqb.a(paramCanvas, true);
    paramCanvas.restore();
    wxe.c(jdField_a_of_type_JavaLangString, "drawItem end.");
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    int i = this.jdField_a_of_type_JavaUtilList.size() - 1;
    while (i >= 0)
    {
      bmqb localbmqb = (bmqb)this.jdField_a_of_type_JavaUtilList.get(i);
      if (this.jdField_a_of_type_Bmyi.a(localbmqb, paramFloat1, paramFloat2, false))
      {
        this.jdField_a_of_type_Bmqb = localbmqb;
        return true;
      }
      i -= 1;
    }
    return false;
  }
  
  private void b(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_Bmqb = null;
    this.jdField_a_of_type_Bmyi.a();
    k();
    d(false);
  }
  
  private boolean b()
  {
    return a() == 10;
  }
  
  private void c()
  {
    this.jdField_a_of_type_Bmyi = new bmyi();
    this.jdField_a_of_type_Bmyi.a(true);
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.LEFT);
    this.jdField_a_of_type_AndroidTextTextPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(Typeface.DEFAULT);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-16711936);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(2.0F);
    this.i.setStrokeWidth(2.0F);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(-65536);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(2.0F);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Bmqb == null) {
      return;
    }
    wxe.b(jdField_a_of_type_JavaLangString, "before limit translate value. translateXValue = %f, translateYValue = %f.", Float.valueOf(this.jdField_a_of_type_Bmqb.s), Float.valueOf(this.jdField_a_of_type_Bmqb.t));
    float f5 = this.jdField_a_of_type_Bmqb.b.x + this.jdField_a_of_type_Bmqb.s;
    float f4 = this.jdField_a_of_type_Bmqb.b.y + this.jdField_a_of_type_Bmqb.t;
    float f1 = this.jdField_a_of_type_Bmqb.s;
    float f3 = this.jdField_a_of_type_Bmqb.t;
    if (f5 - this.jdField_a_of_type_Bmqb.u / 2.0F < this.jdField_a_of_type_AndroidGraphicsRect.left) {
      f1 = this.jdField_a_of_type_Bmqb.u / 2.0F - this.jdField_a_of_type_Bmqb.b.x;
    }
    float f2 = f1;
    if (f5 + this.jdField_a_of_type_Bmqb.u / 2.0F > this.jdField_a_of_type_AndroidGraphicsRect.right) {
      f2 = this.jdField_a_of_type_AndroidGraphicsRect.right - this.jdField_a_of_type_Bmqb.u / 2.0F - this.jdField_a_of_type_Bmqb.b.x;
    }
    f1 = f3;
    if (f4 - this.jdField_a_of_type_Bmqb.v / 2.0F < this.jdField_a_of_type_AndroidGraphicsRect.top) {
      f1 = this.jdField_a_of_type_Bmqb.v / 2.0F - this.jdField_a_of_type_Bmqb.b.y;
    }
    if (this.jdField_a_of_type_Bmqb.v / 2.0F + f4 > this.jdField_a_of_type_AndroidGraphicsRect.bottom) {
      f1 = this.jdField_a_of_type_AndroidGraphicsRect.bottom - this.jdField_a_of_type_Bmqb.v / 2.0F - this.jdField_a_of_type_Bmqb.b.y;
    }
    this.jdField_a_of_type_Bmqb.s = f2;
    this.jdField_a_of_type_Bmqb.t = f1;
    wxe.b(jdField_a_of_type_JavaLangString, "after limit translate value. translateXValue = %f, translateYValue = %f.", Float.valueOf(this.jdField_a_of_type_Bmqb.s), Float.valueOf(this.jdField_a_of_type_Bmqb.t));
  }
  
  private void e()
  {
    wxe.b(jdField_a_of_type_JavaLangString, "click the item:" + this.jdField_a_of_type_Bmqb);
    if ((this.jdField_a_of_type_Bmqc != null) && (this.jdField_a_of_type_Bmqb != null)) {
      this.jdField_a_of_type_Bmqc.a(this.jdField_a_of_type_Bmqb);
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (int i = 0;; i = this.jdField_a_of_type_JavaUtilList.size())
    {
      wxe.b(jdField_a_of_type_JavaLangString, "getDoodleCount:" + i);
      return i;
    }
  }
  
  public PointF a()
  {
    PointF localPointF = new PointF();
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      localPointF.x = (this.jdField_a_of_type_AndroidGraphicsRect.width() / 2);
      localPointF.y = (this.jdField_a_of_type_AndroidGraphicsRect.height() / 2);
      wxe.b(jdField_a_of_type_JavaLangString, "get default center pointer in doodle center. x = %f, y = %f.", Float.valueOf(localPointF.x), Float.valueOf(localPointF.y));
      wxe.b(jdField_a_of_type_JavaLangString, "get default center pointer. x = %f, y = %f.", Float.valueOf(localPointF.x), Float.valueOf(localPointF.y));
      return localPointF;
    }
    float f = this.jdField_a_of_type_AndroidGraphicsRect.height();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    label122:
    if (localIterator.hasNext())
    {
      bmqb localbmqb = (bmqb)localIterator.next();
      if ((localbmqb.s != 0.0F) || (localbmqb.t != 0.0F) || (localbmqb.b.y > f)) {
        break label253;
      }
      f = localbmqb.b.y;
    }
    label253:
    for (;;)
    {
      break label122;
      if (f == this.jdField_a_of_type_AndroidGraphicsRect.height()) {}
      for (f = this.jdField_a_of_type_AndroidGraphicsRect.height() / 2;; f -= aepi.a(40.0F, this.jdField_a_of_type_AndroidContentContext.getResources()))
      {
        localPointF.x = (this.jdField_a_of_type_AndroidGraphicsRect.width() / 2);
        localPointF.y = f;
        break;
      }
    }
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  @NonNull
  public List<String> a()
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      return localArrayList;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((bmqb)localIterator.next()).jdField_a_of_type_JavaLangString);
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Bmqb = null;
    this.jdField_a_of_type_Bmyi.a();
    wxe.b(jdField_a_of_type_JavaLangString, "clear over.");
  }
  
  public void a(int paramInt, float paramFloat)
  {
    if (this.jdField_a_of_type_Bmqb == null) {
      return;
    }
    this.jdField_a_of_type_Bmqb.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Bmqb.s = paramFloat;
    k();
  }
  
  protected void a(Canvas paramCanvas)
  {
    if (this.d)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        a((bmqb)localIterator.next(), paramCanvas);
      }
    }
  }
  
  public void a(Canvas paramCanvas, float paramFloat)
  {
    paramCanvas.save();
    paramCanvas.scale(paramFloat, paramFloat);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      bmqb localbmqb = (bmqb)localIterator.next();
      paramCanvas.save();
      paramCanvas.concat(this.jdField_a_of_type_Bmyi.a(localbmqb));
      localbmqb.a(paramCanvas, false);
      paramCanvas.restore();
    }
    paramCanvas.restore();
  }
  
  public void a(bmqc parambmqc)
  {
    this.jdField_a_of_type_Bmqc = parambmqc;
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public boolean a()
  {
    return a() == 0;
  }
  
  public boolean a(long paramLong)
  {
    return true;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getY();
    int k = (int)paramMotionEvent.getX();
    int j = Math.abs(k - this.jdField_b_of_type_Int);
    int m = Math.abs(i - this.jdField_a_of_type_Int);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Bmyi.a(paramMotionEvent, false);
      d();
      return true;
      this.jdField_b_of_type_Int = k;
      this.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_Boolean = false;
      a(paramMotionEvent);
      if (this.jdField_a_of_type_Bmqb != null)
      {
        this.jdField_a_of_type_Bmyi.a(this.jdField_a_of_type_Bmqb);
        continue;
        if (m > 5)
        {
          i = 1;
          label133:
          if (j <= 5) {
            break label159;
          }
        }
        label159:
        for (j = 1; (j | i) != 0; j = 0)
        {
          this.jdField_a_of_type_Boolean = true;
          break;
          i = 0;
          break label133;
        }
        if ((!this.jdField_a_of_type_Boolean) && ((this.jdField_a_of_type_Bmqb instanceof bmqb))) {
          e();
        }
        b(paramMotionEvent);
      }
    }
  }
  
  public boolean a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return false;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (TextUtils.equals(((bmqb)localIterator.next()).jdField_a_of_type_JavaLangString, paramString))
      {
        wxe.e(jdField_a_of_type_JavaLangString, "add repeated uin.");
        return true;
      }
    }
    return false;
  }
  
  public boolean a(String paramString1, Drawable paramDrawable, String paramString2, String paramString3, bmqd parambmqd, PointF paramPointF)
  {
    if (paramDrawable == null) {
      wxe.e(jdField_a_of_type_JavaLangString, "addAtItem faceDrawable is null.");
    }
    do
    {
      return false;
      if (parambmqd == null)
      {
        wxe.e(jdField_a_of_type_JavaLangString, "addAtItem params is null.");
        return false;
      }
      if (!b()) {
        break;
      }
      wxe.e(jdField_a_of_type_JavaLangString, "has max at count. add at failed.");
    } while (this.jdField_a_of_type_Bmqc == null);
    this.jdField_a_of_type_Bmqc.a(10);
    return false;
    wxe.b(jdField_a_of_type_JavaLangString, "addAtItem before, faceDrawable : %s , remark : %s , LayerParams : %s", paramDrawable, paramString2, parambmqd);
    bmqd localbmqd = bmqd.a(parambmqd);
    PointF localPointF = paramPointF;
    if (paramPointF == null) {
      localPointF = a();
    }
    localbmqd.jdField_a_of_type_AndroidGraphicsPointF = localPointF;
    int i = (int)(localbmqd.jdField_a_of_type_Int * localbmqd.jdField_a_of_type_Float);
    int j = (int)(localbmqd.jdField_b_of_type_Int * localbmqd.jdField_a_of_type_Float);
    float f2 = localbmqd.jdField_a_of_type_AndroidGraphicsPointF.x;
    float f3 = localbmqd.jdField_a_of_type_AndroidGraphicsPointF.y;
    float f1 = f2;
    if (f2 - i / 2 < this.jdField_a_of_type_AndroidGraphicsRect.left) {
      f1 = this.jdField_a_of_type_AndroidGraphicsRect.left + i / 2;
    }
    f2 = f1;
    if (i / 2 + f1 > this.jdField_a_of_type_AndroidGraphicsRect.right) {
      f2 = this.jdField_a_of_type_AndroidGraphicsRect.right - i / 2;
    }
    f1 = f3;
    if (f3 - j / 2 < this.jdField_a_of_type_AndroidGraphicsRect.top) {
      f1 = this.jdField_a_of_type_AndroidGraphicsRect.top + j / 2;
    }
    f3 = f1;
    if (j / 2 + f1 > this.jdField_a_of_type_AndroidGraphicsRect.bottom) {
      f3 = this.jdField_a_of_type_AndroidGraphicsRect.bottom - j / 2;
    }
    localbmqd.jdField_a_of_type_AndroidGraphicsPointF.x = f2;
    localbmqd.jdField_a_of_type_AndroidGraphicsPointF.y = f3;
    wxe.b(jdField_a_of_type_JavaLangString, "addAtItem after, faceDrawable : %s , remark : %s , LayerParams : %s", paramDrawable, paramString2, parambmqd);
    wxe.c(jdField_a_of_type_JavaLangString, "Create AtItem.");
    paramString1 = new bmqb(this, paramString1, paramDrawable, paramString2, paramString3, localbmqd);
    wxe.b(jdField_a_of_type_JavaLangString, "before add item to list. size = %d.", Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()));
    this.jdField_a_of_type_JavaUtilList.add(paramString1);
    wxe.b(jdField_a_of_type_JavaLangString, "after add item to list. size = %d.", Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()));
    k();
    return true;
  }
  
  public void aZ_()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      wxe.b(jdField_a_of_type_JavaLangString, "before remove item from list. size = %d.", Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()));
      this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_JavaUtilList.size() - 1);
      wxe.b(jdField_a_of_type_JavaLangString, "after remove item from list. size = %d.", Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()));
      k();
    }
  }
  
  public String b()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      return null;
    }
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      localJSONArray.put(((bmqb)localIterator.next()).a());
    }
    wxe.c(jdField_a_of_type_JavaLangString, "AtLayer getAtJsonArray:" + localJSONArray.toString());
    return localJSONArray.toString();
  }
  
  public void b(Canvas paramCanvas)
  {
    a(paramCanvas, this.jdField_a_of_type_Float);
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    if (this.jdField_b_of_type_Boolean) {
      return false;
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int i = this.jdField_a_of_type_JavaUtilList.size() - 1;
    while (i >= 0)
    {
      paramMotionEvent = (bmqb)this.jdField_a_of_type_JavaUtilList.get(i);
      if (this.jdField_a_of_type_Bmyi.a(paramMotionEvent, f1, f2, false)) {
        return true;
      }
      i -= 1;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmqa
 * JD-Core Version:    0.7.0.1
 */