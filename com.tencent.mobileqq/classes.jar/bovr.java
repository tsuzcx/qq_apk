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
public class bovr
  extends bown
{
  public static final String a;
  public int a;
  public Paint a;
  public Drawable a;
  public TextPaint a;
  public bovv a;
  public bovy a;
  public bpdf a;
  public List<bovv> a;
  public Map<String, List<String>> a;
  public boolean a;
  public Paint b;
  public List<bovv> b;
  public Map<String, List<String>> b;
  public Paint c;
  public Paint d;
  public Paint e;
  public Paint f;
  public Paint g;
  
  static
  {
    jdField_a_of_type_JavaLangString = bovr.class.getSimpleName();
  }
  
  public bovr(DoodleView paramDoodleView)
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
      this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_Bovv);
      this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_Bovv);
    }
  }
  
  private void a(bovv parambovv, Canvas paramCanvas)
  {
    if (parambovv == null) {
      return;
    }
    paramCanvas.save();
    paramCanvas.concat(this.jdField_a_of_type_Bpdf.a(parambovv));
    parambovv.a(paramCanvas, true);
    paramCanvas.restore();
  }
  
  private void a(bovv parambovv, Map<String, List<String>> paramMap)
  {
    List localList = (List)paramMap.get(parambovv.d);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      paramMap.put(parambovv.d, localObject);
    }
    ((List)localObject).add(parambovv.jdField_e_of_type_JavaLangString);
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    int i = this.jdField_a_of_type_JavaUtilList.size() - 1;
    while (i >= 0)
    {
      bovv localbovv = (bovv)this.jdField_a_of_type_JavaUtilList.get(i);
      if (this.jdField_a_of_type_Bpdf.a(localbovv, paramFloat1, paramFloat2, false))
      {
        this.jdField_a_of_type_Bovv = localbovv;
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
    if (this.jdField_a_of_type_Bovv != null) {
      this.jdField_a_of_type_Bovv.jdField_e_of_type_Boolean = false;
    }
    this.jdField_a_of_type_Bovv = null;
    this.jdField_a_of_type_Bpdf.a();
    super.k();
    super.d(false);
    n();
  }
  
  private void b(bovv parambovv, Map<String, List<String>> paramMap)
  {
    List localList = (List)paramMap.get(parambovv.d);
    if (localList != null)
    {
      localList.remove(parambovv.jdField_e_of_type_JavaLangString);
      if (localList.isEmpty()) {
        paramMap.remove(parambovv.d);
      }
    }
  }
  
  private void c(bovv parambovv)
  {
    boolean bool1 = this.jdField_a_of_type_Bpdf.a(parambovv, StoryGuideLineView.jdField_a_of_type_Int, true);
    boolean bool2 = this.jdField_a_of_type_Bpdf.a(parambovv, StoryGuideLineView.b, false);
    boolean bool3 = this.jdField_a_of_type_Bpdf.b(parambovv, StoryGuideLineView.d, false);
    if (this.jdField_a_of_type_Bovy != null) {
      this.jdField_a_of_type_Bovy.a(bool1, bool2, false, bool3, parambovv.jdField_l_of_type_Boolean);
    }
    if (parambovv != null)
    {
      if (parambovv.k) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(parambovv.jdField_l_of_type_Boolean, parambovv.r, parambovv.s, parambovv.t, parambovv.jdField_a_of_type_AndroidGraphicsPointF, parambovv.jdField_m_of_type_Boolean, 2);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(parambovv.jdField_l_of_type_Boolean, parambovv.r, parambovv.s, parambovv.t, parambovv.jdField_a_of_type_AndroidGraphicsPointF, parambovv.jdField_m_of_type_Boolean, 1);
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846757);
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
    this.jdField_a_of_type_Bpdf = new bpdf();
    this.jdField_a_of_type_Bpdf.a(true);
    this.jdField_a_of_type_Bpdf.a(18.0F);
    this.jdField_a_of_type_Bpdf.b(0.2F);
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
    if ((this.jdField_a_of_type_Bovy != null) && (this.jdField_a_of_type_Bovv != null) && (this.jdField_a_of_type_Bovy.a(this.jdField_a_of_type_Bovv))) {
      this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_Bovv);
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_Bovv != null) {
      this.jdField_a_of_type_Bovv.c();
    }
  }
  
  private void h()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(false, 0.0F, 0.0F, 0.0F, null, false, 1);
  }
  
  public Rect a(Rect paramRect)
  {
    paramRect.setEmpty();
    if (this.jdField_a_of_type_Bovv != null)
    {
      int i = (int)(this.jdField_a_of_type_Bovv.u * this.jdField_a_of_type_Bovv.q);
      paramRect.set(0, 0, i, i);
    }
    return paramRect;
  }
  
  public bpdg a(bpdg parambpdg, String paramString1, String paramString2, Drawable paramDrawable, bovz parambovz, String paramString3, int paramInt1, boolean paramBoolean, String paramString4, String paramString5, int paramInt2)
  {
    if (paramDrawable == null)
    {
      ykq.e(jdField_a_of_type_JavaLangString, "Face drawable is null.");
      return null;
    }
    if (parambovz == null)
    {
      ykq.e(jdField_a_of_type_JavaLangString, "ItemParams is null.");
      return null;
    }
    bovz localbovz = bovz.a(parambpdg, parambovz);
    bovv localbovv;
    if ((parambpdg instanceof bovv))
    {
      localbovv = (bovv)parambpdg;
      if (localbovv.b)
      {
        this.jdField_b_of_type_JavaUtilList.remove(localbovv);
        b(localbovv, this.jdField_b_of_type_JavaUtilMap);
      }
    }
    else
    {
      if (!TextUtils.isEmpty(parambovz.jdField_a_of_type_JavaLangString)) {
        break label321;
      }
      ykq.b(jdField_a_of_type_JavaLangString, "Create Normal FaceItem.");
      paramString2 = new bovv(this, paramDrawable, localbovz, paramString1, paramString2, paramString3, paramInt1, paramInt2);
      paramString2.a(paramBoolean);
      if ((paramDrawable instanceof bpcq)) {
        paramString2.b(bpbb.b(((bpcq)paramDrawable).a()));
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
    paramString2.b(bpbb.b(paramInt1));
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
    paramString1.a(parambpdg);
    if (paramString1.b) {
      this.jdField_b_of_type_JavaUtilList.add(paramString1);
    }
    for (;;)
    {
      b(paramString1, this.jdField_b_of_type_JavaUtilMap);
      return paramString1;
      b(localbovv, this.jdField_a_of_type_JavaUtilMap);
      break;
      label321:
      ykq.b(jdField_a_of_type_JavaLangString, "Create FaceAndTextItem with text:" + localbovz.jdField_a_of_type_JavaLangString);
      paramString1 = new bovs(this, paramDrawable, localbovz, paramString1, paramString2, paramString3, paramInt1, paramInt2);
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
    this.jdField_a_of_type_Bovv = null;
    this.jdField_a_of_type_Bpdf.a();
    ykq.b(jdField_a_of_type_JavaLangString, "clear over.");
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
      ykq.b(jdField_a_of_type_JavaLangString, "mFaceItems = null or size<=0");
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        bovv localbovv = (bovv)localIterator.next();
        paramInt1 = (int)(localbovv.u * localbovv.q);
        paramInt2 = (int)(localbovv.v * localbovv.q);
        localbovv.jdField_a_of_type_AndroidGraphicsPointF.x = a(localbovv.jdField_a_of_type_AndroidGraphicsPointF.x, paramInt1, this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.right);
        localbovv.jdField_a_of_type_AndroidGraphicsPointF.y = a(localbovv.jdField_a_of_type_AndroidGraphicsPointF.y, paramInt2, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.bottom);
      }
    }
  }
  
  protected void a(Canvas paramCanvas)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      a((bovv)localIterator.next(), paramCanvas);
    }
  }
  
  public void a(Canvas paramCanvas, float paramFloat, boolean paramBoolean)
  {
    paramCanvas.save();
    paramCanvas.scale(paramFloat, paramFloat);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      bovv localbovv = (bovv)localIterator.next();
      if ((localbovv.h == 0) && ((paramBoolean) || ((!localbovv.b()) && (!localbovv.c()))))
      {
        paramCanvas.save();
        paramCanvas.concat(this.jdField_a_of_type_Bpdf.a(localbovv));
        localbovv.a(paramCanvas, false);
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
  
  public void a(bovv parambovv)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()) && (this.jdField_a_of_type_JavaUtilList.remove(parambovv)))
    {
      if (!parambovv.b) {
        break label78;
      }
      DoodleLayout.a("delete_poi");
      ykw.a("0X80076D2");
      ykw.b("0X80075E7");
      this.jdField_b_of_type_JavaUtilList.remove(parambovv);
    }
    for (;;)
    {
      b(parambovv, this.jdField_b_of_type_JavaUtilMap);
      return;
      label78:
      DoodleLayout.a("delete_oneface");
      ykw.a("0X80076CB");
      ykw.b("0X80075E0");
      b(parambovv, this.jdField_a_of_type_JavaUtilMap);
    }
  }
  
  public void a(bovv parambovv, TroopBarPOI paramTroopBarPOI)
  {
    if (parambovv != null)
    {
      parambovv.a(paramTroopBarPOI);
      parambovv.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setCallback(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a.a);
      k();
    }
  }
  
  public void a(bovy parambovy)
  {
    this.jdField_a_of_type_Bovy = parambovy;
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        bovv localbovv = (bovv)localIterator.next();
        if ((a(localbovv.d, paramString1)) && (a(localbovv.jdField_e_of_type_JavaLangString, paramString2))) {
          a(localbovv);
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
      if (((bovv)localIterator.next()).jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.isSegmentChanged(paramLong)) {
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
      this.jdField_a_of_type_Bpdf.a(paramMotionEvent, false);
      if (this.jdField_a_of_type_Bovv == null) {
        break;
      }
      c(this.jdField_a_of_type_Bovv);
      return true;
      this.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_Boolean = false;
      a(paramMotionEvent);
      if (this.jdField_a_of_type_Bovv != null) {
        this.jdField_a_of_type_Bpdf.a(this.jdField_a_of_type_Bovv);
      }
      if (this.jdField_a_of_type_Bovv != null)
      {
        this.jdField_a_of_type_Bovv.b();
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
  
  public boolean a(String paramString1, String paramString2, Drawable paramDrawable, bovz parambovz, String paramString3, boolean paramBoolean, int paramInt1, int paramInt2, SegmentKeeper paramSegmentKeeper)
  {
    if (paramDrawable == null)
    {
      ykq.e(jdField_a_of_type_JavaLangString, "Face drawable is null.");
      return false;
    }
    if (parambovz == null)
    {
      ykq.e(jdField_a_of_type_JavaLangString, "ItemParams is null.");
      return false;
    }
    if (b())
    {
      ykq.e(jdField_a_of_type_JavaLangString, "has max face count. add face failed.");
      if (this.jdField_a_of_type_Bovy != null) {
        this.jdField_a_of_type_Bovy.a(40);
      }
      return false;
    }
    if ((paramInt1 == 1) || (paramInt1 == 3)) {
      paramDrawable.setCallback(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView);
    }
    ykq.a(jdField_a_of_type_JavaLangString, "addFace before, category : %s , name : %s , LayerParams : %s", paramString1, paramString2, parambovz);
    bovz localbovz = bovz.a(parambovz);
    int k = (int)(localbovz.jdField_a_of_type_Int * localbovz.jdField_a_of_type_Float);
    int j = (int)(localbovz.b * localbovz.jdField_a_of_type_Float);
    int i = j;
    if (this.jdField_a_of_type_AndroidGraphicsRect.height() < j)
    {
      f1 = localbovz.jdField_a_of_type_Float;
      localbovz.jdField_a_of_type_Float = (this.jdField_a_of_type_AndroidGraphicsRect.height() / j * f1);
      i = this.jdField_a_of_type_AndroidGraphicsRect.height();
    }
    float f1 = localbovz.jdField_a_of_type_AndroidGraphicsPointF.x;
    float f2 = localbovz.jdField_a_of_type_AndroidGraphicsPointF.y;
    localbovz.jdField_a_of_type_AndroidGraphicsPointF.x = a(f1, k, this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.right);
    localbovz.jdField_a_of_type_AndroidGraphicsPointF.y = a(f2, i, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.bottom);
    ykq.b(jdField_a_of_type_JavaLangString, "addFace after drawRect:" + this.jdField_a_of_type_AndroidGraphicsRect);
    ykq.a(jdField_a_of_type_JavaLangString, "addFace after, category : %s , name : %s , LayerParams : %s", paramString1, paramString2, parambovz);
    if (TextUtils.isEmpty(localbovz.jdField_a_of_type_JavaLangString))
    {
      ykq.b(jdField_a_of_type_JavaLangString, "Create Normal FaceItem.");
      paramString2 = new bovv(this, paramDrawable, localbovz, paramString1, paramString2, paramString3, paramInt1, paramInt2);
      paramString2.a(paramBoolean);
      paramString1 = paramString2;
      if ((paramDrawable instanceof bpcq))
      {
        paramString2.b(bpbb.b(((bpcq)paramDrawable).a()));
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
      ykq.b(jdField_a_of_type_JavaLangString, "Create FaceAndTextItem with text:" + localbovz.jdField_a_of_type_JavaLangString);
      paramString1 = new bovs(this, paramDrawable, localbovz, paramString1, paramString2, paramString3, paramInt1, paramInt2);
      ((bovs)paramString1).a();
      break;
      label506:
      a(paramString1, this.jdField_a_of_type_JavaUtilMap);
    }
  }
  
  public boolean a(String paramString1, String paramString2, Drawable paramDrawable, bovz parambovz, String paramString3, boolean paramBoolean, String paramString4, int paramInt1, String paramString5, int paramInt2, int paramInt3)
  {
    if (paramDrawable == null)
    {
      ykq.e(jdField_a_of_type_JavaLangString, "Face drawable is null.");
      return false;
    }
    if (parambovz == null)
    {
      ykq.e(jdField_a_of_type_JavaLangString, "ItemParams is null.");
      return false;
    }
    if (b())
    {
      ykq.e(jdField_a_of_type_JavaLangString, "has max face count. add face failed.");
      if (this.jdField_a_of_type_Bovy != null) {
        this.jdField_a_of_type_Bovy.a(40);
      }
      return false;
    }
    if ((paramInt1 == 1) || (paramInt1 == 3)) {
      paramDrawable.setCallback(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView);
    }
    ykq.a(jdField_a_of_type_JavaLangString, "addFace before, category : %s , name : %s , LayerParams : %s", paramString1, paramString2, parambovz);
    bovz localbovz = bovz.a(parambovz);
    int k = (int)(localbovz.jdField_a_of_type_Int * localbovz.jdField_a_of_type_Float);
    int j = (int)(localbovz.b * localbovz.jdField_a_of_type_Float);
    int i = j;
    if (this.jdField_a_of_type_AndroidGraphicsRect.height() < j)
    {
      f1 = localbovz.jdField_a_of_type_Float;
      localbovz.jdField_a_of_type_Float = (this.jdField_a_of_type_AndroidGraphicsRect.height() / j * f1);
      i = this.jdField_a_of_type_AndroidGraphicsRect.height();
    }
    float f1 = localbovz.jdField_a_of_type_AndroidGraphicsPointF.x;
    float f2 = localbovz.jdField_a_of_type_AndroidGraphicsPointF.y;
    localbovz.jdField_a_of_type_AndroidGraphicsPointF.x = a(f1, k, this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.right);
    localbovz.jdField_a_of_type_AndroidGraphicsPointF.y = a(f2, i, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.bottom);
    ykq.b(jdField_a_of_type_JavaLangString, "addFace after drawRect:" + this.jdField_a_of_type_AndroidGraphicsRect);
    ykq.a(jdField_a_of_type_JavaLangString, "addFace after, category : %s , name : %s , LayerParams : %s", paramString1, paramString2, parambovz);
    i = -1;
    if (TextUtils.isEmpty(localbovz.jdField_a_of_type_JavaLangString))
    {
      ykq.b(jdField_a_of_type_JavaLangString, "Create Normal FaceItem.");
      paramString2 = new bovv(this, paramDrawable, localbovz, paramString1, paramString2, paramString3, paramInt1, paramInt3);
      paramString2.jdField_g_of_type_JavaLangString = paramString5;
      paramString2.a(paramBoolean);
      if (!TextUtils.isEmpty(paramString4))
      {
        if ((paramString2 instanceof bovs)) {
          paramString2.a(new TroopBarPOI("-1", "", paramString4, 0, "", 0, ""));
        }
      }
      else
      {
        if (!(paramDrawable instanceof bpcq)) {
          break label545;
        }
        paramInt1 = ((bpcq)paramDrawable).a();
        paramString2.b(bpbb.b(paramInt1));
        paramString1 = paramString2;
        label437:
        if (((paramDrawable instanceof bpco)) || (12 == paramInt1)) {
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
          paramString2.b(bpbb.b(paramInt1));
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
      ykq.b(jdField_a_of_type_JavaLangString, "Create FaceAndTextItem with text:" + localbovz.jdField_a_of_type_JavaLangString);
      paramString1 = new bovs(this, paramDrawable, localbovz, paramString1, paramString2, paramString3, paramInt1);
      ((bovs)paramString1).a();
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
      if (((bovv)localIterator.next() instanceof bovs)) {
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
      ykq.b(jdField_a_of_type_JavaLangString, "FaceLayer, DoodleCount:" + i);
      return i;
    }
  }
  
  public void b(Canvas paramCanvas)
  {
    a(paramCanvas, this.jdField_a_of_type_Float, false);
  }
  
  public void b(bovv parambovv)
  {
    if ((parambovv.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) || (!(parambovv.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof BitmapDrawable))) {}
    long l1;
    label95:
    long l2;
    do
    {
      return;
      l1 = System.currentTimeMillis();
      Object localObject = ((BitmapDrawable)parambovv.jdField_a_of_type_AndroidGraphicsDrawableDrawable).getBitmap();
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
      int j = (int)parambovv.u;
      parambovv.jdField_a_of_type_ArrayOfInt = new int[j * 2];
      float f1 = k / parambovv.u;
      float f2 = parambovv.v / m;
      i = 0;
      while (i < j)
      {
        k = (int)(i * f1);
        parambovv.jdField_a_of_type_ArrayOfInt[(i * 2)] = ((int)(localObject[(k * 2)] * f2));
        parambovv.jdField_a_of_type_ArrayOfInt[(i * 2 + 1)] = ((int)(localObject[(k * 2 + 1)] * f2));
        if (localObject[(k * 2 + 1)] > 0)
        {
          if (parambovv.jdField_l_of_type_Int == -1) {
            parambovv.jdField_l_of_type_Int = i;
          }
          parambovv.jdField_m_of_type_Int = Math.max(i, parambovv.jdField_m_of_type_Int);
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
      bovv localbovv = (bovv)this.jdField_a_of_type_JavaUtilList.get(i);
      if (this.jdField_a_of_type_Bpdf.a(localbovv, f1, f2, false))
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
      a((bovv)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1));
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
 * Qualified Name:     bovr
 * JD-Core Version:    0.7.0.1
 */