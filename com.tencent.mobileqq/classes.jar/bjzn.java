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

public class bjzn
  extends bkav
{
  public static final String a;
  public int a;
  public Paint a;
  public TextPaint a;
  public bjzo a;
  private bjzp jdField_a_of_type_Bjzp;
  private bkhv jdField_a_of_type_Bkhv;
  public List<bjzo> a;
  public boolean a;
  public int b;
  public Paint b;
  private String b;
  public boolean b;
  private boolean d = true;
  
  static
  {
    jdField_a_of_type_JavaLangString = bjzn.class.getSimpleName();
  }
  
  public bjzn(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaLangString = jdField_a_of_type_JavaLangString;
    c();
  }
  
  public bjzn(DoodleView paramDoodleView, String paramString)
  {
    this(paramDoodleView);
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    if (a(paramMotionEvent.getX(0), paramMotionEvent.getY(0)))
    {
      this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_Bjzo);
      this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_Bjzo);
    }
  }
  
  private void a(bjzo parambjzo, Canvas paramCanvas)
  {
    veg.c(jdField_a_of_type_JavaLangString, "drawItem start.");
    if (parambjzo == null) {
      return;
    }
    paramCanvas.save();
    paramCanvas.concat(this.jdField_a_of_type_Bkhv.a(parambjzo));
    parambjzo.a(paramCanvas, true);
    paramCanvas.restore();
    veg.c(jdField_a_of_type_JavaLangString, "drawItem end.");
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    int i = this.jdField_a_of_type_JavaUtilList.size() - 1;
    while (i >= 0)
    {
      bjzo localbjzo = (bjzo)this.jdField_a_of_type_JavaUtilList.get(i);
      if (this.jdField_a_of_type_Bkhv.a(localbjzo, paramFloat1, paramFloat2, false))
      {
        this.jdField_a_of_type_Bjzo = localbjzo;
        return true;
      }
      i -= 1;
    }
    return false;
  }
  
  private void b(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_Bjzo = null;
    this.jdField_a_of_type_Bkhv.a();
    k();
    d(false);
  }
  
  private boolean b()
  {
    return a() == 10;
  }
  
  private void c()
  {
    this.jdField_a_of_type_Bkhv = new bkhv();
    this.jdField_a_of_type_Bkhv.a(true);
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
    if (this.jdField_a_of_type_Bjzo == null) {
      return;
    }
    veg.b(jdField_a_of_type_JavaLangString, "before limit translate value. translateXValue = %f, translateYValue = %f.", Float.valueOf(this.jdField_a_of_type_Bjzo.s), Float.valueOf(this.jdField_a_of_type_Bjzo.t));
    float f5 = this.jdField_a_of_type_Bjzo.b.x + this.jdField_a_of_type_Bjzo.s;
    float f4 = this.jdField_a_of_type_Bjzo.b.y + this.jdField_a_of_type_Bjzo.t;
    float f1 = this.jdField_a_of_type_Bjzo.s;
    float f3 = this.jdField_a_of_type_Bjzo.t;
    if (f5 - this.jdField_a_of_type_Bjzo.u / 2.0F < this.jdField_a_of_type_AndroidGraphicsRect.left) {
      f1 = this.jdField_a_of_type_Bjzo.u / 2.0F - this.jdField_a_of_type_Bjzo.b.x;
    }
    float f2 = f1;
    if (f5 + this.jdField_a_of_type_Bjzo.u / 2.0F > this.jdField_a_of_type_AndroidGraphicsRect.right) {
      f2 = this.jdField_a_of_type_AndroidGraphicsRect.right - this.jdField_a_of_type_Bjzo.u / 2.0F - this.jdField_a_of_type_Bjzo.b.x;
    }
    f1 = f3;
    if (f4 - this.jdField_a_of_type_Bjzo.v / 2.0F < this.jdField_a_of_type_AndroidGraphicsRect.top) {
      f1 = this.jdField_a_of_type_Bjzo.v / 2.0F - this.jdField_a_of_type_Bjzo.b.y;
    }
    if (this.jdField_a_of_type_Bjzo.v / 2.0F + f4 > this.jdField_a_of_type_AndroidGraphicsRect.bottom) {
      f1 = this.jdField_a_of_type_AndroidGraphicsRect.bottom - this.jdField_a_of_type_Bjzo.v / 2.0F - this.jdField_a_of_type_Bjzo.b.y;
    }
    this.jdField_a_of_type_Bjzo.s = f2;
    this.jdField_a_of_type_Bjzo.t = f1;
    veg.b(jdField_a_of_type_JavaLangString, "after limit translate value. translateXValue = %f, translateYValue = %f.", Float.valueOf(this.jdField_a_of_type_Bjzo.s), Float.valueOf(this.jdField_a_of_type_Bjzo.t));
  }
  
  private void e()
  {
    veg.b(jdField_a_of_type_JavaLangString, "click the item:" + this.jdField_a_of_type_Bjzo);
    if ((this.jdField_a_of_type_Bjzp != null) && (this.jdField_a_of_type_Bjzo != null)) {
      this.jdField_a_of_type_Bjzp.a(this.jdField_a_of_type_Bjzo);
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (int i = 0;; i = this.jdField_a_of_type_JavaUtilList.size())
    {
      veg.b(jdField_a_of_type_JavaLangString, "getDoodleCount:" + i);
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
      veg.b(jdField_a_of_type_JavaLangString, "get default center pointer in doodle center. x = %f, y = %f.", Float.valueOf(localPointF.x), Float.valueOf(localPointF.y));
      veg.b(jdField_a_of_type_JavaLangString, "get default center pointer. x = %f, y = %f.", Float.valueOf(localPointF.x), Float.valueOf(localPointF.y));
      return localPointF;
    }
    float f = this.jdField_a_of_type_AndroidGraphicsRect.height();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    label122:
    if (localIterator.hasNext())
    {
      bjzo localbjzo = (bjzo)localIterator.next();
      if ((localbjzo.s != 0.0F) || (localbjzo.t != 0.0F) || (localbjzo.b.y > f)) {
        break label253;
      }
      f = localbjzo.b.y;
    }
    label253:
    for (;;)
    {
      break label122;
      if (f == this.jdField_a_of_type_AndroidGraphicsRect.height()) {}
      for (f = this.jdField_a_of_type_AndroidGraphicsRect.height() / 2;; f -= actn.a(40.0F, this.jdField_a_of_type_AndroidContentContext.getResources()))
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
      localArrayList.add(((bjzo)localIterator.next()).jdField_a_of_type_JavaLangString);
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Bjzo = null;
    this.jdField_a_of_type_Bkhv.a();
    veg.b(jdField_a_of_type_JavaLangString, "clear over.");
  }
  
  public void a(int paramInt, float paramFloat)
  {
    if (this.jdField_a_of_type_Bjzo == null) {
      return;
    }
    this.jdField_a_of_type_Bjzo.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Bjzo.s = paramFloat;
    k();
  }
  
  protected void a(Canvas paramCanvas)
  {
    if (this.d)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        a((bjzo)localIterator.next(), paramCanvas);
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
      bjzo localbjzo = (bjzo)localIterator.next();
      paramCanvas.save();
      paramCanvas.concat(this.jdField_a_of_type_Bkhv.a(localbjzo));
      localbjzo.a(paramCanvas, false);
      paramCanvas.restore();
    }
    paramCanvas.restore();
  }
  
  public void a(bjzp parambjzp)
  {
    this.jdField_a_of_type_Bjzp = parambjzp;
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
      this.jdField_a_of_type_Bkhv.a(paramMotionEvent, false);
      d();
      return true;
      this.jdField_b_of_type_Int = k;
      this.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_Boolean = false;
      a(paramMotionEvent);
      if (this.jdField_a_of_type_Bjzo != null)
      {
        this.jdField_a_of_type_Bkhv.a(this.jdField_a_of_type_Bjzo);
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
        if ((!this.jdField_a_of_type_Boolean) && ((this.jdField_a_of_type_Bjzo instanceof bjzo))) {
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
      if (TextUtils.equals(((bjzo)localIterator.next()).jdField_a_of_type_JavaLangString, paramString))
      {
        veg.e(jdField_a_of_type_JavaLangString, "add repeated uin.");
        return true;
      }
    }
    return false;
  }
  
  public boolean a(String paramString1, Drawable paramDrawable, String paramString2, String paramString3, bjzq parambjzq, PointF paramPointF)
  {
    if (paramDrawable == null) {
      veg.e(jdField_a_of_type_JavaLangString, "addAtItem faceDrawable is null.");
    }
    do
    {
      return false;
      if (parambjzq == null)
      {
        veg.e(jdField_a_of_type_JavaLangString, "addAtItem params is null.");
        return false;
      }
      if (!b()) {
        break;
      }
      veg.e(jdField_a_of_type_JavaLangString, "has max at count. add at failed.");
    } while (this.jdField_a_of_type_Bjzp == null);
    this.jdField_a_of_type_Bjzp.a(10);
    return false;
    veg.b(jdField_a_of_type_JavaLangString, "addAtItem before, faceDrawable : %s , remark : %s , LayerParams : %s", paramDrawable, paramString2, parambjzq);
    bjzq localbjzq = bjzq.a(parambjzq);
    PointF localPointF = paramPointF;
    if (paramPointF == null) {
      localPointF = a();
    }
    localbjzq.jdField_a_of_type_AndroidGraphicsPointF = localPointF;
    int i = (int)(localbjzq.jdField_a_of_type_Int * localbjzq.jdField_a_of_type_Float);
    int j = (int)(localbjzq.jdField_b_of_type_Int * localbjzq.jdField_a_of_type_Float);
    float f2 = localbjzq.jdField_a_of_type_AndroidGraphicsPointF.x;
    float f3 = localbjzq.jdField_a_of_type_AndroidGraphicsPointF.y;
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
    localbjzq.jdField_a_of_type_AndroidGraphicsPointF.x = f2;
    localbjzq.jdField_a_of_type_AndroidGraphicsPointF.y = f3;
    veg.b(jdField_a_of_type_JavaLangString, "addAtItem after, faceDrawable : %s , remark : %s , LayerParams : %s", paramDrawable, paramString2, parambjzq);
    veg.c(jdField_a_of_type_JavaLangString, "Create AtItem.");
    paramString1 = new bjzo(this, paramString1, paramDrawable, paramString2, paramString3, localbjzq);
    veg.b(jdField_a_of_type_JavaLangString, "before add item to list. size = %d.", Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()));
    this.jdField_a_of_type_JavaUtilList.add(paramString1);
    veg.b(jdField_a_of_type_JavaLangString, "after add item to list. size = %d.", Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()));
    k();
    return true;
  }
  
  public void aY_()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      veg.b(jdField_a_of_type_JavaLangString, "before remove item from list. size = %d.", Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()));
      this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_JavaUtilList.size() - 1);
      veg.b(jdField_a_of_type_JavaLangString, "after remove item from list. size = %d.", Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()));
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
      localJSONArray.put(((bjzo)localIterator.next()).a());
    }
    veg.c(jdField_a_of_type_JavaLangString, "AtLayer getAtJsonArray:" + localJSONArray.toString());
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
      paramMotionEvent = (bjzo)this.jdField_a_of_type_JavaUtilList.get(i);
      if (this.jdField_a_of_type_Bkhv.a(paramMotionEvent, f1, f2, false)) {
        return true;
      }
      i -= 1;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjzn
 * JD-Core Version:    0.7.0.1
 */