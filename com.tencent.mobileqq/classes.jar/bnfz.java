import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.paster.PasterParcelData;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer.1;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.StoryGuideLineView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;

@TargetApi(11)
public class bnfz
  extends bngv
{
  public static final String a;
  public int a;
  public Paint a;
  public Drawable a;
  public TextPaint a;
  public bngd a;
  public bngg a;
  public bnnn a;
  public List<bngd> a;
  public Map<String, List<String>> a;
  public boolean a;
  public Paint b;
  public List<bngd> b;
  public Map<String, List<String>> b;
  public Paint c;
  public Paint d;
  public Paint e;
  public Paint f;
  public Paint g;
  
  static
  {
    jdField_a_of_type_JavaLangString = bnfz.class.getSimpleName();
  }
  
  public bnfz(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
    e();
  }
  
  private int a(float paramFloat, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = (int)paramFloat;
    if (paramInt3 == 0) {
      return i;
    }
    float f1 = paramFloat;
    if (paramFloat - paramInt1 / 2 < paramInt2) {
      f1 = paramInt1 / 2 + paramInt2;
    }
    paramFloat = f1;
    if (paramInt1 / 2 + f1 > paramInt3) {
      paramFloat = paramInt3 - paramInt1 / 2;
    }
    return (int)paramFloat;
  }
  
  public static Bitmap a(Drawable paramDrawable)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
    paramDrawable.draw(localCanvas);
    return localBitmap;
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    if (a(paramMotionEvent.getX(0), paramMotionEvent.getY(0)))
    {
      this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_Bngd);
      this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_Bngd);
    }
  }
  
  private void a(bngd parambngd, Canvas paramCanvas)
  {
    if (parambngd == null) {
      return;
    }
    paramCanvas.save();
    paramCanvas.concat(this.jdField_a_of_type_Bnnn.a(parambngd));
    parambngd.a(paramCanvas, true);
    paramCanvas.restore();
  }
  
  private void a(bngd parambngd, Map<String, List<String>> paramMap)
  {
    List localList = (List)paramMap.get(parambngd.d);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      paramMap.put(parambngd.d, localObject);
    }
    ((List)localObject).add(parambngd.jdField_e_of_type_JavaLangString);
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    int i = this.jdField_a_of_type_JavaUtilList.size() - 1;
    while (i >= 0)
    {
      bngd localbngd = (bngd)this.jdField_a_of_type_JavaUtilList.get(i);
      if (this.jdField_a_of_type_Bnnn.a(localbngd, paramFloat1, paramFloat2, false))
      {
        this.jdField_a_of_type_Bngd = localbngd;
        return true;
      }
      i -= 1;
    }
    return false;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if (paramString1 == paramString2) {
      return true;
    }
    if (paramString1 != null) {
      return paramString1.equals(paramString2);
    }
    return false;
  }
  
  private void b(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Bngd != null) {
      this.jdField_a_of_type_Bngd.jdField_e_of_type_Boolean = false;
    }
    this.jdField_a_of_type_Bngd = null;
    this.jdField_a_of_type_Bnnn.a();
    super.k();
    super.d(false);
    n();
  }
  
  private void b(bngd parambngd, Map<String, List<String>> paramMap)
  {
    List localList = (List)paramMap.get(parambngd.d);
    if (localList != null)
    {
      localList.remove(parambngd.jdField_e_of_type_JavaLangString);
      if (localList.isEmpty()) {
        paramMap.remove(parambngd.d);
      }
    }
  }
  
  private void c(bngd parambngd)
  {
    boolean bool1 = this.jdField_a_of_type_Bnnn.a(parambngd, StoryGuideLineView.jdField_a_of_type_Int, true);
    boolean bool2 = this.jdField_a_of_type_Bnnn.a(parambngd, StoryGuideLineView.b, false);
    boolean bool3 = this.jdField_a_of_type_Bnnn.b(parambngd, StoryGuideLineView.d, false);
    if (this.jdField_a_of_type_Bngg != null) {
      this.jdField_a_of_type_Bngg.a(bool1, bool2, false, bool3, parambngd.jdField_l_of_type_Boolean);
    }
    if (parambngd != null)
    {
      if (parambngd.k) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(parambngd.jdField_l_of_type_Boolean, parambngd.r, parambngd.s, parambngd.t, parambngd.jdField_a_of_type_AndroidGraphicsPointF, parambngd.jdField_m_of_type_Boolean, 2);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(parambngd.jdField_l_of_type_Boolean, parambngd.r, parambngd.s, parambngd.t, parambngd.jdField_a_of_type_AndroidGraphicsPointF, parambngd.jdField_m_of_type_Boolean, 1);
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846661);
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.LEFT);
    this.jdField_a_of_type_AndroidTextTextPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(Typeface.DEFAULT);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(-65536);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(2.0F);
    this.c = new Paint();
    this.c.setAntiAlias(true);
    this.c.setStyle(Paint.Style.STROKE);
    this.c.setColor(-16711936);
    this.c.setStrokeWidth(2.0F);
    this.i.setStrokeWidth(2.0F);
    this.d = new Paint();
    this.d.setStrokeWidth(1.0F);
    this.d.setColor(-1);
    this.d.setStyle(Paint.Style.STROKE);
    this.d.setPathEffect(new DashPathEffect(new float[] { 8.0F, 6.0F }, 0.0F));
    this.jdField_a_of_type_Bnnn = new bnnn();
    this.jdField_a_of_type_Bnnn.a(true);
    this.jdField_a_of_type_Bnnn.a(18.0F);
    this.jdField_a_of_type_Bnnn.b(0.2F);
    this.e = new Paint();
    this.e.setAntiAlias(true);
    this.e.setStyle(Paint.Style.STROKE);
    this.e.setColor(-1);
    this.e.setStrokeWidth(2.0F);
    this.g = new Paint();
    this.g.setAntiAlias(true);
    this.g.setColor(-1);
    this.g.setStyle(Paint.Style.FILL);
    this.f = new Paint();
    this.f.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    this.f.setStyle(Paint.Style.FILL);
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_Bngg != null) && (this.jdField_a_of_type_Bngd != null) && (this.jdField_a_of_type_Bngg.a(this.jdField_a_of_type_Bngd))) {
      this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_Bngd);
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_Bngd != null) {
      this.jdField_a_of_type_Bngd.c();
    }
  }
  
  private void h()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(false, 0.0F, 0.0F, 0.0F, null, false, 1);
  }
  
  public Rect a(Rect paramRect)
  {
    paramRect.setEmpty();
    if (this.jdField_a_of_type_Bngd != null)
    {
      int i = (int)(this.jdField_a_of_type_Bngd.u * this.jdField_a_of_type_Bngd.q);
      paramRect.set(0, 0, i, i);
    }
    return paramRect;
  }
  
  public bnno a(bnno parambnno, String paramString1, String paramString2, Drawable paramDrawable, bngh parambngh, String paramString3, int paramInt1, boolean paramBoolean, String paramString4, String paramString5, int paramInt2)
  {
    if (paramDrawable == null)
    {
      xvv.e(jdField_a_of_type_JavaLangString, "Face drawable is null.");
      return null;
    }
    if (parambngh == null)
    {
      xvv.e(jdField_a_of_type_JavaLangString, "ItemParams is null.");
      return null;
    }
    bngh localbngh = bngh.a(parambnno, parambngh);
    bngd localbngd;
    if ((parambnno instanceof bngd))
    {
      localbngd = (bngd)parambnno;
      if (localbngd.b)
      {
        this.jdField_b_of_type_JavaUtilList.remove(localbngd);
        b(localbngd, this.jdField_b_of_type_JavaUtilMap);
      }
    }
    else
    {
      if (!TextUtils.isEmpty(parambngh.jdField_a_of_type_JavaLangString)) {
        break label321;
      }
      xvv.b(jdField_a_of_type_JavaLangString, "Create Normal FaceItem.");
      paramString2 = new bngd(this, paramDrawable, localbngh, paramString1, paramString2, paramString3, paramInt1, paramInt2);
      paramString2.a(paramBoolean);
      if ((paramDrawable instanceof bnmy)) {
        paramString2.b(bnlj.b(((bnmy)paramDrawable).a()));
      }
      if (!TextUtils.isEmpty(paramString5)) {
        paramInt1 = -1;
      }
    }
    try
    {
      paramInt2 = Integer.valueOf(paramString5.substring(paramString5.indexOf(":") + 1, paramString5.indexOf(","))).intValue();
      paramInt1 = paramInt2;
    }
    catch (Exception paramString1)
    {
      label199:
      break label199;
    }
    paramString2.b(bnlj.b(paramInt1));
    paramString1 = paramString2;
    if (!TextUtils.isEmpty(paramString4))
    {
      paramString2.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = new TroopBarPOI("-1", "", paramString4, 0, "", 0, "");
      paramString2.jdField_a_of_type_Long = System.currentTimeMillis();
      paramString1 = paramString2;
    }
    label254:
    paramString1.b = paramBoolean;
    if (!TextUtils.isEmpty(paramString5)) {
      paramString1.jdField_g_of_type_JavaLangString = paramString5;
    }
    paramString1.a(parambnno);
    if (paramString1.b) {
      this.jdField_b_of_type_JavaUtilList.add(paramString1);
    }
    for (;;)
    {
      b(paramString1, this.jdField_b_of_type_JavaUtilMap);
      return paramString1;
      b(localbngd, this.jdField_a_of_type_JavaUtilMap);
      break;
      label321:
      xvv.b(jdField_a_of_type_JavaLangString, "Create FaceAndTextItem with text:" + localbngh.jdField_a_of_type_JavaLangString);
      paramString1 = new bnga(this, paramDrawable, localbngh, paramString1, paramString2, paramString3, paramInt1, paramInt2);
      break label254;
      b(paramString1, this.jdField_a_of_type_JavaUtilMap);
    }
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public Map<String, List<String>> a()
  {
    return this.jdField_b_of_type_JavaUtilMap;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Bngd = null;
    this.jdField_a_of_type_Bnnn.a();
    xvv.b(jdField_a_of_type_JavaLangString, "clear over.");
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
      xvv.b(jdField_a_of_type_JavaLangString, "mFaceItems = null or size<=0");
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        bngd localbngd = (bngd)localIterator.next();
        paramInt1 = (int)(localbngd.u * localbngd.q);
        paramInt2 = (int)(localbngd.v * localbngd.q);
        localbngd.jdField_a_of_type_AndroidGraphicsPointF.x = a(localbngd.jdField_a_of_type_AndroidGraphicsPointF.x, paramInt1, this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.right);
        localbngd.jdField_a_of_type_AndroidGraphicsPointF.y = a(localbngd.jdField_a_of_type_AndroidGraphicsPointF.y, paramInt2, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.bottom);
      }
    }
  }
  
  protected void a(Canvas paramCanvas)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      a((bngd)localIterator.next(), paramCanvas);
    }
  }
  
  public void a(Canvas paramCanvas, float paramFloat, boolean paramBoolean)
  {
    paramCanvas.save();
    paramCanvas.scale(paramFloat, paramFloat);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      bngd localbngd = (bngd)localIterator.next();
      if ((localbngd.h == 0) && ((paramBoolean) || ((!localbngd.b()) && (!localbngd.c()))))
      {
        paramCanvas.save();
        paramCanvas.concat(this.jdField_a_of_type_Bnnn.a(localbngd));
        localbngd.a(paramCanvas, false);
        paramCanvas.restore();
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
    a(paramBundle.getParcelableArrayList("StickerParcelDataList"), paramBundle.getBoolean("edit_type_photo"), null);
  }
  
  public void a(bngd parambngd)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()) && (this.jdField_a_of_type_JavaUtilList.remove(parambngd)))
    {
      if (!parambngd.b) {
        break label78;
      }
      DoodleLayout.a("delete_poi");
      xwb.a("0X80076D2");
      xwb.b("0X80075E7");
      this.jdField_b_of_type_JavaUtilList.remove(parambngd);
    }
    for (;;)
    {
      b(parambngd, this.jdField_b_of_type_JavaUtilMap);
      return;
      label78:
      DoodleLayout.a("delete_oneface");
      xwb.a("0X80076CB");
      xwb.b("0X80075E0");
      b(parambngd, this.jdField_a_of_type_JavaUtilMap);
    }
  }
  
  public void a(bngd parambngd, TroopBarPOI paramTroopBarPOI)
  {
    if (parambngd != null)
    {
      parambngd.a(paramTroopBarPOI);
      parambngd.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setCallback(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a.a);
      k();
    }
  }
  
  public void a(bngg parambngg)
  {
    this.jdField_a_of_type_Bngg = parambngg;
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        bngd localbngd = (bngd)localIterator.next();
        if ((a(localbngd.d, paramString1)) && (a(localbngd.jdField_e_of_type_JavaLangString, paramString2))) {
          a(localbngd);
        }
      }
    }
  }
  
  public void a(ArrayList<PasterParcelData> paramArrayList, boolean paramBoolean, JSONArray paramJSONArray)
  {
    if ((paramArrayList != null) && (!paramArrayList.isEmpty())) {
      ThreadManager.post(new FaceLayer.1(this, paramArrayList, paramJSONArray, paramBoolean), 8, null, false);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty());
  }
  
  public boolean a(long paramLong)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (((bngd)localIterator.next()).jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.isSegmentChanged(paramLong)) {
        return false;
      }
    }
    return true;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getY();
    int j = Math.abs(i - this.jdField_a_of_type_Int);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Bnnn.a(paramMotionEvent, false);
      if (this.jdField_a_of_type_Bngd == null) {
        break;
      }
      c(this.jdField_a_of_type_Bngd);
      return true;
      this.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_Boolean = false;
      a(paramMotionEvent);
      if (this.jdField_a_of_type_Bngd != null) {
        this.jdField_a_of_type_Bnnn.a(this.jdField_a_of_type_Bngd);
      }
      if (this.jdField_a_of_type_Bngd != null)
      {
        this.jdField_a_of_type_Bngd.b();
        continue;
        g();
        continue;
        if (j > 5)
        {
          this.jdField_a_of_type_Boolean = true;
          g();
          continue;
          g();
          if (!this.jdField_a_of_type_Boolean) {
            f();
          }
          b(paramMotionEvent);
        }
      }
    }
    h();
    return true;
  }
  
  public boolean a(String paramString1, String paramString2, Drawable paramDrawable, bngh parambngh, String paramString3, boolean paramBoolean, int paramInt1, int paramInt2, SegmentKeeper paramSegmentKeeper)
  {
    if (paramDrawable == null)
    {
      xvv.e(jdField_a_of_type_JavaLangString, "Face drawable is null.");
      return false;
    }
    if (parambngh == null)
    {
      xvv.e(jdField_a_of_type_JavaLangString, "ItemParams is null.");
      return false;
    }
    if (b())
    {
      xvv.e(jdField_a_of_type_JavaLangString, "has max face count. add face failed.");
      if (this.jdField_a_of_type_Bngg != null) {
        this.jdField_a_of_type_Bngg.a(40);
      }
      return false;
    }
    if ((paramInt1 == 1) || (paramInt1 == 3)) {
      paramDrawable.setCallback(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView);
    }
    xvv.a(jdField_a_of_type_JavaLangString, "addFace before, category : %s , name : %s , LayerParams : %s", paramString1, paramString2, parambngh);
    bngh localbngh = bngh.a(parambngh);
    int k = (int)(localbngh.jdField_a_of_type_Int * localbngh.jdField_a_of_type_Float);
    int j = (int)(localbngh.b * localbngh.jdField_a_of_type_Float);
    int i = j;
    if (this.jdField_a_of_type_AndroidGraphicsRect.height() < j)
    {
      f1 = localbngh.jdField_a_of_type_Float;
      localbngh.jdField_a_of_type_Float = (this.jdField_a_of_type_AndroidGraphicsRect.height() / j * f1);
      i = this.jdField_a_of_type_AndroidGraphicsRect.height();
    }
    float f1 = localbngh.jdField_a_of_type_AndroidGraphicsPointF.x;
    float f2 = localbngh.jdField_a_of_type_AndroidGraphicsPointF.y;
    localbngh.jdField_a_of_type_AndroidGraphicsPointF.x = a(f1, k, this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.right);
    localbngh.jdField_a_of_type_AndroidGraphicsPointF.y = a(f2, i, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.bottom);
    xvv.b(jdField_a_of_type_JavaLangString, "addFace after drawRect:" + this.jdField_a_of_type_AndroidGraphicsRect);
    xvv.a(jdField_a_of_type_JavaLangString, "addFace after, category : %s , name : %s , LayerParams : %s", paramString1, paramString2, parambngh);
    if (TextUtils.isEmpty(localbngh.jdField_a_of_type_JavaLangString))
    {
      xvv.b(jdField_a_of_type_JavaLangString, "Create Normal FaceItem.");
      paramString2 = new bngd(this, paramDrawable, localbngh, paramString1, paramString2, paramString3, paramInt1, paramInt2);
      paramString2.a(paramBoolean);
      paramString1 = paramString2;
      if ((paramDrawable instanceof bnmy))
      {
        paramString2.b(bnlj.b(((bnmy)paramDrawable).a()));
        paramString1 = paramString2;
      }
      paramString1.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper = new SegmentKeeper(paramSegmentKeeper);
      b(paramString1);
      this.jdField_a_of_type_JavaUtilList.add(paramString1);
      super.k();
      if (!paramString1.b) {
        break label506;
      }
      this.jdField_b_of_type_JavaUtilList.add(paramString1);
    }
    for (;;)
    {
      a(paramString1, this.jdField_b_of_type_JavaUtilMap);
      return true;
      xvv.b(jdField_a_of_type_JavaLangString, "Create FaceAndTextItem with text:" + localbngh.jdField_a_of_type_JavaLangString);
      paramString1 = new bnga(this, paramDrawable, localbngh, paramString1, paramString2, paramString3, paramInt1, paramInt2);
      ((bnga)paramString1).a();
      break;
      label506:
      a(paramString1, this.jdField_a_of_type_JavaUtilMap);
    }
  }
  
  public boolean a(String paramString1, String paramString2, Drawable paramDrawable, bngh parambngh, String paramString3, boolean paramBoolean, String paramString4, int paramInt1, String paramString5, int paramInt2, int paramInt3)
  {
    if (paramDrawable == null)
    {
      xvv.e(jdField_a_of_type_JavaLangString, "Face drawable is null.");
      return false;
    }
    if (parambngh == null)
    {
      xvv.e(jdField_a_of_type_JavaLangString, "ItemParams is null.");
      return false;
    }
    if (b())
    {
      xvv.e(jdField_a_of_type_JavaLangString, "has max face count. add face failed.");
      if (this.jdField_a_of_type_Bngg != null) {
        this.jdField_a_of_type_Bngg.a(40);
      }
      return false;
    }
    if ((paramInt1 == 1) || (paramInt1 == 3)) {
      paramDrawable.setCallback(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView);
    }
    xvv.a(jdField_a_of_type_JavaLangString, "addFace before, category : %s , name : %s , LayerParams : %s", paramString1, paramString2, parambngh);
    bngh localbngh = bngh.a(parambngh);
    int k = (int)(localbngh.jdField_a_of_type_Int * localbngh.jdField_a_of_type_Float);
    int j = (int)(localbngh.b * localbngh.jdField_a_of_type_Float);
    int i = j;
    if (this.jdField_a_of_type_AndroidGraphicsRect.height() < j)
    {
      f1 = localbngh.jdField_a_of_type_Float;
      localbngh.jdField_a_of_type_Float = (this.jdField_a_of_type_AndroidGraphicsRect.height() / j * f1);
      i = this.jdField_a_of_type_AndroidGraphicsRect.height();
    }
    float f1 = localbngh.jdField_a_of_type_AndroidGraphicsPointF.x;
    float f2 = localbngh.jdField_a_of_type_AndroidGraphicsPointF.y;
    localbngh.jdField_a_of_type_AndroidGraphicsPointF.x = a(f1, k, this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.right);
    localbngh.jdField_a_of_type_AndroidGraphicsPointF.y = a(f2, i, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.bottom);
    xvv.b(jdField_a_of_type_JavaLangString, "addFace after drawRect:" + this.jdField_a_of_type_AndroidGraphicsRect);
    xvv.a(jdField_a_of_type_JavaLangString, "addFace after, category : %s , name : %s , LayerParams : %s", paramString1, paramString2, parambngh);
    i = -1;
    if (TextUtils.isEmpty(localbngh.jdField_a_of_type_JavaLangString))
    {
      xvv.b(jdField_a_of_type_JavaLangString, "Create Normal FaceItem.");
      paramString2 = new bngd(this, paramDrawable, localbngh, paramString1, paramString2, paramString3, paramInt1, paramInt3);
      paramString2.jdField_g_of_type_JavaLangString = paramString5;
      paramString2.a(paramBoolean);
      if (!TextUtils.isEmpty(paramString4))
      {
        if ((paramString2 instanceof bnga)) {
          paramString2.a(new TroopBarPOI("-1", "", paramString4, 0, "", 0, ""));
        }
      }
      else
      {
        if (!(paramDrawable instanceof bnmy)) {
          break label545;
        }
        paramInt1 = ((bnmy)paramDrawable).a();
        paramString2.b(bnlj.b(paramInt1));
        paramString1 = paramString2;
        label437:
        if (((paramDrawable instanceof bnmw)) || (12 == paramInt1)) {
          paramString1.r = 90.0F;
        }
        paramString1.jdField_g_of_type_Int = paramInt2;
        this.jdField_a_of_type_JavaUtilList.add(paramString1);
        super.k();
        if (!paramString1.b) {
          break label673;
        }
        this.jdField_b_of_type_JavaUtilList.add(paramString1);
      }
    }
    for (;;)
    {
      for (;;)
      {
        a(paramString1, this.jdField_b_of_type_JavaUtilMap);
        return true;
        paramString2.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = new TroopBarPOI("-1", "", paramString4, 0, "", 0, "");
        paramString2.jdField_a_of_type_Long = System.currentTimeMillis();
        break;
        label545:
        paramString1 = paramString2;
        paramInt1 = i;
        if (TextUtils.isEmpty(paramString5)) {
          break label437;
        }
        try
        {
          paramInt1 = Integer.valueOf(paramString5.substring(paramString5.indexOf(":") + 1, paramString5.indexOf(","))).intValue();
          paramString2.b(bnlj.b(paramInt1));
          paramString1 = paramString2;
        }
        catch (Exception paramString1)
        {
          for (;;)
          {
            paramInt1 = -1;
          }
        }
      }
      xvv.b(jdField_a_of_type_JavaLangString, "Create FaceAndTextItem with text:" + localbngh.jdField_a_of_type_JavaLangString);
      paramString1 = new bnga(this, paramDrawable, localbngh, paramString1, paramString2, paramString3, paramInt1);
      ((bnga)paramString1).a();
      paramInt1 = i;
      break label437;
      label673:
      a(paramString1, this.jdField_a_of_type_JavaUtilMap);
    }
  }
  
  public int[] a()
  {
    int[] arrayOfInt = new int[2];
    int[] tmp5_4 = arrayOfInt;
    tmp5_4[0] = 0;
    int[] tmp9_5 = tmp5_4;
    tmp9_5[1] = 0;
    tmp9_5;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (((bngd)localIterator.next() instanceof bnga)) {
        arrayOfInt[1] += 1;
      } else {
        arrayOfInt[0] += 1;
      }
    }
    return arrayOfInt;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (int i = 0;; i = this.jdField_a_of_type_JavaUtilList.size())
    {
      xvv.b(jdField_a_of_type_JavaLangString, "FaceLayer, DoodleCount:" + i);
      return i;
    }
  }
  
  public void b(Canvas paramCanvas)
  {
    a(paramCanvas, this.jdField_a_of_type_Float, false);
  }
  
  public void b(bngd parambngd)
  {
    if ((parambngd.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) || (!(parambngd.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof BitmapDrawable))) {}
    long l1;
    label95:
    long l2;
    do
    {
      return;
      l1 = System.currentTimeMillis();
      Object localObject = ((BitmapDrawable)parambngd.jdField_a_of_type_AndroidGraphicsDrawableDrawable).getBitmap();
      int k = ((Bitmap)localObject).getWidth();
      int m = ((Bitmap)localObject).getHeight();
      int[] arrayOfInt = new int[k * m];
      ((Bitmap)localObject).getPixels(arrayOfInt, 0, k, 0, 0, k, m);
      localObject = new int[k * 2];
      int i = 0;
      if (i < k)
      {
        j = 0;
        if (j < m)
        {
          if ((arrayOfInt[(j * k + i)] >> 24 & 0xFF) > 0) {
            localObject[(i * 2)] = j;
          }
        }
        else {
          j = m - 1;
        }
        for (;;)
        {
          if (j >= 0)
          {
            if ((arrayOfInt[(j * k + i)] >> 24 & 0xFF) > 0) {
              localObject[(i * 2 + 1)] = j;
            }
          }
          else
          {
            i += 1;
            break;
            j += 1;
            break label95;
          }
          j -= 1;
        }
      }
      int j = (int)parambngd.u;
      parambngd.jdField_a_of_type_ArrayOfInt = new int[j * 2];
      float f1 = k / parambngd.u;
      float f2 = parambngd.v / m;
      i = 0;
      while (i < j)
      {
        k = (int)(i * f1);
        parambngd.jdField_a_of_type_ArrayOfInt[(i * 2)] = ((int)(localObject[(k * 2)] * f2));
        parambngd.jdField_a_of_type_ArrayOfInt[(i * 2 + 1)] = ((int)(localObject[(k * 2 + 1)] * f2));
        if (localObject[(k * 2 + 1)] > 0)
        {
          if (parambngd.jdField_l_of_type_Int == -1) {
            parambngd.jdField_l_of_type_Int = i;
          }
          parambngd.jdField_m_of_type_Int = Math.max(i, parambngd.jdField_m_of_type_Int);
        }
        i += 1;
      }
      l2 = System.currentTimeMillis();
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "computePixelScope cost: ", Long.valueOf(l2 - l1) });
  }
  
  protected boolean b()
  {
    return b() >= 40;
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int i = this.jdField_a_of_type_JavaUtilList.size() - 1;
    while (i >= 0)
    {
      bngd localbngd = (bngd)this.jdField_a_of_type_JavaUtilList.get(i);
      if (this.jdField_a_of_type_Bnnn.a(localbngd, f1, f2, false))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "accept inside x:" + paramMotionEvent.getX() + " y:" + paramMotionEvent.getY());
        }
        return true;
      }
      i -= 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "accept outside x:" + paramMotionEvent.getX() + " y:" + paramMotionEvent.getY());
    }
    return false;
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      a((bngd)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1));
    }
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_b_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilMap.clear();
      this.jdField_b_of_type_JavaUtilMap.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnfz
 * JD-Core Version:    0.7.0.1
 */