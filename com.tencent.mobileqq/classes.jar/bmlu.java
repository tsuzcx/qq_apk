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
import com.tencent.mobileqq.richmedia.capture.data.TrackerStickerParam;
import com.tencent.mobileqq.richmedia.capture.data.TrackerStickerParam.MotionInfo;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.paster.PasterParcelData;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer.1;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.StoryGuideLineView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

@TargetApi(11)
public class bmlu
  extends bmmw
{
  public static final String a;
  public int a;
  public Paint a;
  public Drawable a;
  public TextPaint a;
  public bmly a;
  public bmmb a;
  public bmtw a;
  public List<bmly> a;
  public Map<String, List<String>> a;
  public boolean a;
  public Paint b;
  public List<bmly> b;
  public Map<String, List<String>> b;
  public Paint c;
  public Paint d;
  public Paint e;
  public Paint f;
  public Paint g;
  
  static
  {
    jdField_a_of_type_JavaLangString = bmlu.class.getSimpleName();
  }
  
  public bmlu(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
    f();
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
      this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_Bmly);
      this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_Bmly);
    }
  }
  
  private void a(bmly parambmly, Canvas paramCanvas)
  {
    if (parambmly == null) {
      return;
    }
    paramCanvas.save();
    paramCanvas.concat(this.jdField_a_of_type_Bmtw.a(parambmly));
    parambmly.a(paramCanvas, true);
    paramCanvas.restore();
  }
  
  private void a(bmly parambmly, Map<String, List<String>> paramMap)
  {
    List localList = (List)paramMap.get(parambmly.jdField_d_of_type_JavaLangString);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      paramMap.put(parambmly.jdField_d_of_type_JavaLangString, localObject);
    }
    ((List)localObject).add(parambmly.jdField_e_of_type_JavaLangString);
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    int i = this.jdField_a_of_type_JavaUtilList.size() - 1;
    if (i >= 0)
    {
      bmly localbmly = (bmly)this.jdField_a_of_type_JavaUtilList.get(i);
      if ((localbmly.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper != null) && (localbmly.d()) && (!localbmly.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.isCurrentIn())) {}
      while (!this.jdField_a_of_type_Bmtw.a(localbmly, paramFloat1, paramFloat2, false))
      {
        i -= 1;
        break;
      }
      this.jdField_a_of_type_Bmly = localbmly;
      return true;
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
    if (this.jdField_a_of_type_Bmly != null) {
      this.jdField_a_of_type_Bmly.jdField_e_of_type_Boolean = false;
    }
    this.jdField_a_of_type_Bmly = null;
    this.jdField_a_of_type_Bmtw.a();
    super.k();
    super.d(false);
    n();
  }
  
  private void b(bmly parambmly, Map<String, List<String>> paramMap)
  {
    List localList = (List)paramMap.get(parambmly.jdField_d_of_type_JavaLangString);
    if (localList != null)
    {
      localList.remove(parambmly.jdField_e_of_type_JavaLangString);
      if (localList.isEmpty()) {
        paramMap.remove(parambmly.jdField_d_of_type_JavaLangString);
      }
    }
  }
  
  private void c(bmly parambmly)
  {
    boolean bool1 = this.jdField_a_of_type_Bmtw.a(parambmly, StoryGuideLineView.jdField_a_of_type_Int, true);
    boolean bool2 = this.jdField_a_of_type_Bmtw.a(parambmly, StoryGuideLineView.b, false);
    boolean bool3 = this.jdField_a_of_type_Bmtw.b(parambmly, StoryGuideLineView.d, false);
    if (this.jdField_a_of_type_Bmmb != null) {
      this.jdField_a_of_type_Bmmb.a(bool1, bool2, false, bool3, parambmly.jdField_l_of_type_Boolean);
    }
    if (parambmly != null)
    {
      if (parambmly.jdField_k_of_type_Boolean) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(parambmly.jdField_l_of_type_Boolean, parambmly.r, parambmly.s, parambmly.t, parambmly.jdField_b_of_type_AndroidGraphicsPointF, parambmly.jdField_m_of_type_Boolean, 2);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(parambmly.jdField_l_of_type_Boolean, parambmly.r, parambmly.s, parambmly.t, parambmly.jdField_b_of_type_AndroidGraphicsPointF, parambmly.jdField_m_of_type_Boolean, 1);
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846224);
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
    this.jdField_a_of_type_Bmtw = new bmtw();
    this.jdField_a_of_type_Bmtw.a(true);
    this.jdField_a_of_type_Bmtw.a(18.0F);
    this.jdField_a_of_type_Bmtw.b(0.2F);
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
  
  private void g()
  {
    if ((this.jdField_a_of_type_Bmmb != null) && (this.jdField_a_of_type_Bmly != null) && (this.jdField_a_of_type_Bmmb.a(this.jdField_a_of_type_Bmly))) {
      this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_Bmly);
    }
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_Bmly != null) {
      this.jdField_a_of_type_Bmly.c();
    }
  }
  
  private void i()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(false, 0.0F, 0.0F, 0.0F, null, false, 1);
  }
  
  public Rect a(Rect paramRect)
  {
    paramRect.setEmpty();
    if (this.jdField_a_of_type_Bmly != null)
    {
      int i = (int)(this.jdField_a_of_type_Bmly.u * this.jdField_a_of_type_Bmly.q);
      paramRect.set(0, 0, i, i);
    }
    return paramRect;
  }
  
  public Bundle a()
  {
    Bundle localBundle = super.a();
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilList.size());
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      localArrayList.add(new PasterParcelData((bmly)this.jdField_a_of_type_JavaUtilList.get(i)));
      i += 1;
    }
    localBundle.putParcelableArrayList("StickerParcelDataList", localArrayList);
    return localBundle;
  }
  
  public bmtx a(bmtx parambmtx, String paramString1, String paramString2, Drawable paramDrawable, bmmc parambmmc, String paramString3, int paramInt1, boolean paramBoolean, String paramString4, String paramString5, int paramInt2)
  {
    if (paramDrawable == null)
    {
      wsv.e(jdField_a_of_type_JavaLangString, "Face drawable is null.");
      return null;
    }
    if (parambmmc == null)
    {
      wsv.e(jdField_a_of_type_JavaLangString, "ItemParams is null.");
      return null;
    }
    bmmc localbmmc = bmmc.a(parambmtx, parambmmc);
    bmly localbmly;
    if ((parambmtx instanceof bmly))
    {
      localbmly = (bmly)parambmtx;
      if (localbmly.jdField_b_of_type_Boolean)
      {
        this.jdField_b_of_type_JavaUtilList.remove(localbmly);
        b(localbmly, this.jdField_b_of_type_JavaUtilMap);
      }
    }
    else
    {
      if (!TextUtils.isEmpty(parambmmc.jdField_a_of_type_JavaLangString)) {
        break label321;
      }
      wsv.b(jdField_a_of_type_JavaLangString, "Create Normal FaceItem.");
      paramString2 = new bmly(this, paramDrawable, localbmmc, paramString1, paramString2, paramString3, paramInt1, paramInt2);
      paramString2.a(paramBoolean);
      if ((paramDrawable instanceof bmth)) {
        paramString2.b(bmro.b(((bmth)paramDrawable).a()));
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
    paramString2.b(bmro.b(paramInt1));
    paramString1 = paramString2;
    if (!TextUtils.isEmpty(paramString4))
    {
      paramString2.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = new TroopBarPOI("-1", "", paramString4, 0, "", 0, "");
      paramString2.jdField_a_of_type_Long = System.currentTimeMillis();
      paramString1 = paramString2;
    }
    label254:
    paramString1.jdField_b_of_type_Boolean = paramBoolean;
    if (!TextUtils.isEmpty(paramString5)) {
      paramString1.jdField_g_of_type_JavaLangString = paramString5;
    }
    paramString1.a(parambmtx);
    if (paramString1.jdField_b_of_type_Boolean) {
      this.jdField_b_of_type_JavaUtilList.add(paramString1);
    }
    for (;;)
    {
      b(paramString1, this.jdField_b_of_type_JavaUtilMap);
      return paramString1;
      b(localbmly, this.jdField_a_of_type_JavaUtilMap);
      break;
      label321:
      wsv.b(jdField_a_of_type_JavaLangString, "Create FaceAndTextItem with text:" + localbmmc.jdField_a_of_type_JavaLangString);
      paramString1 = new bmlv(this, paramDrawable, localbmmc, paramString1, paramString2, paramString3, paramInt1, paramInt2);
      break label254;
      b(paramString1, this.jdField_a_of_type_JavaUtilMap);
    }
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public ArrayList<TrackerStickerParam> a()
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        bmly localbmly = (bmly)localIterator.next();
        if ((localbmly.c()) || (localbmly.d()))
        {
          TrackerStickerParam localTrackerStickerParam = new TrackerStickerParam(localbmly.jdField_b_of_type_AndroidGraphicsPointF.x, localbmly.jdField_b_of_type_AndroidGraphicsPointF.y, localbmly.q, localbmly.r, localbmly.s, localbmly.t, localbmly.u, localbmly.v, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_Int, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.b, localbmly.f, localbmly.jdField_a_of_type_JavaUtilMap);
          localTrackerStickerParam.setSegmentList(localbmly.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.getSegmentList());
          localArrayList.add(localTrackerStickerParam);
        }
      }
    }
    return localArrayList;
  }
  
  public Map<String, List<String>> a()
  {
    return this.jdField_b_of_type_JavaUtilMap;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Bmly = null;
    this.jdField_a_of_type_Bmtw.a();
    wsv.b(jdField_a_of_type_JavaLangString, "clear over.");
  }
  
  public void a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      bmly localbmly = (bmly)localIterator.next();
      if (localbmly.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper != null) {
        localbmly.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.setMode(paramInt);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
      wsv.b(jdField_a_of_type_JavaLangString, "mFaceItems = null or size<=0");
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        bmly localbmly = (bmly)localIterator.next();
        paramInt1 = (int)(localbmly.u * localbmly.q);
        paramInt2 = (int)(localbmly.v * localbmly.q);
        localbmly.jdField_b_of_type_AndroidGraphicsPointF.x = a(localbmly.jdField_b_of_type_AndroidGraphicsPointF.x, paramInt1, this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.right);
        localbmly.jdField_b_of_type_AndroidGraphicsPointF.y = a(localbmly.jdField_b_of_type_AndroidGraphicsPointF.y, paramInt2, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.bottom);
      }
    }
  }
  
  protected void a(Canvas paramCanvas)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      a((bmly)localIterator.next(), paramCanvas);
    }
  }
  
  public void a(Canvas paramCanvas, float paramFloat, boolean paramBoolean)
  {
    paramCanvas.save();
    paramCanvas.scale(paramFloat, paramFloat);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      bmly localbmly = (bmly)localIterator.next();
      if ((localbmly.jdField_h_of_type_Int == 0) && ((paramBoolean) || ((!localbmly.c()) && (!localbmly.d()))))
      {
        paramCanvas.save();
        paramCanvas.concat(this.jdField_a_of_type_Bmtw.a(localbmly));
        localbmly.a(paramCanvas, false);
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
  
  public void a(bmly parambmly)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()) && (this.jdField_a_of_type_JavaUtilList.remove(parambmly)))
    {
      if (!parambmly.jdField_b_of_type_Boolean) {
        break label78;
      }
      DoodleLayout.a("delete_poi");
      wtb.a("0X80076D2");
      wtb.b("0X80075E7");
      this.jdField_b_of_type_JavaUtilList.remove(parambmly);
    }
    for (;;)
    {
      b(parambmly, this.jdField_b_of_type_JavaUtilMap);
      return;
      label78:
      DoodleLayout.a("delete_oneface");
      wtb.a("0X80076CB");
      wtb.b("0X80075E0");
      b(parambmly, this.jdField_a_of_type_JavaUtilMap);
    }
  }
  
  public void a(bmly parambmly, TroopBarPOI paramTroopBarPOI)
  {
    if (parambmly != null)
    {
      parambmly.a(paramTroopBarPOI);
      parambmly.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setCallback(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a);
      k();
    }
  }
  
  public void a(bmmb parambmmb)
  {
    this.jdField_a_of_type_Bmmb = parambmmb;
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        bmly localbmly = (bmly)localIterator.next();
        if ((a(localbmly.jdField_d_of_type_JavaLangString, paramString1)) && (a(localbmly.jdField_e_of_type_JavaLangString, paramString2))) {
          a(localbmly);
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
      if (((bmly)localIterator.next()).jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.isSegmentChanged(paramLong)) {
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
      this.jdField_a_of_type_Bmtw.a(paramMotionEvent, false);
      if (this.jdField_a_of_type_Bmly == null) {
        break;
      }
      c(this.jdField_a_of_type_Bmly);
      return true;
      this.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_Boolean = false;
      a(paramMotionEvent);
      if (this.jdField_a_of_type_Bmly != null) {
        this.jdField_a_of_type_Bmtw.a(this.jdField_a_of_type_Bmly);
      }
      e();
      if (this.jdField_a_of_type_Bmly != null)
      {
        this.jdField_a_of_type_Bmly.b();
        continue;
        h();
        continue;
        if (j > 5)
        {
          this.jdField_a_of_type_Boolean = true;
          h();
          continue;
          h();
          if (!this.jdField_a_of_type_Boolean) {
            g();
          }
          b(paramMotionEvent);
        }
      }
    }
    i();
    return true;
  }
  
  public boolean a(String paramString1, String paramString2, Drawable paramDrawable, bmmc parambmmc, String paramString3, boolean paramBoolean, int paramInt1, int paramInt2, SegmentKeeper paramSegmentKeeper)
  {
    if (paramDrawable == null)
    {
      wsv.e(jdField_a_of_type_JavaLangString, "Face drawable is null.");
      return false;
    }
    if (parambmmc == null)
    {
      wsv.e(jdField_a_of_type_JavaLangString, "ItemParams is null.");
      return false;
    }
    if (b())
    {
      wsv.e(jdField_a_of_type_JavaLangString, "has max face count. add face failed.");
      if (this.jdField_a_of_type_Bmmb != null) {
        this.jdField_a_of_type_Bmmb.a(40);
      }
      return false;
    }
    if ((paramInt1 == 1) || (paramInt1 == 3)) {
      paramDrawable.setCallback(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView);
    }
    wsv.a(jdField_a_of_type_JavaLangString, "addFace before, category : %s , name : %s , LayerParams : %s", paramString1, paramString2, parambmmc);
    bmmc localbmmc = bmmc.a(parambmmc);
    int k = (int)(localbmmc.jdField_a_of_type_Int * localbmmc.jdField_a_of_type_Float);
    int j = (int)(localbmmc.b * localbmmc.jdField_a_of_type_Float);
    int i = j;
    if (this.jdField_a_of_type_AndroidGraphicsRect.height() < j)
    {
      f1 = localbmmc.jdField_a_of_type_Float;
      localbmmc.jdField_a_of_type_Float = (this.jdField_a_of_type_AndroidGraphicsRect.height() / j * f1);
      i = this.jdField_a_of_type_AndroidGraphicsRect.height();
    }
    float f1 = localbmmc.jdField_a_of_type_AndroidGraphicsPointF.x;
    float f2 = localbmmc.jdField_a_of_type_AndroidGraphicsPointF.y;
    localbmmc.jdField_a_of_type_AndroidGraphicsPointF.x = a(f1, k, this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.right);
    localbmmc.jdField_a_of_type_AndroidGraphicsPointF.y = a(f2, i, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.bottom);
    wsv.b(jdField_a_of_type_JavaLangString, "addFace after drawRect:" + this.jdField_a_of_type_AndroidGraphicsRect);
    wsv.a(jdField_a_of_type_JavaLangString, "addFace after, category : %s , name : %s , LayerParams : %s", paramString1, paramString2, parambmmc);
    if (TextUtils.isEmpty(localbmmc.jdField_a_of_type_JavaLangString))
    {
      wsv.b(jdField_a_of_type_JavaLangString, "Create Normal FaceItem.");
      paramString2 = new bmly(this, paramDrawable, localbmmc, paramString1, paramString2, paramString3, paramInt1, paramInt2);
      paramString2.a(paramBoolean);
      paramString1 = paramString2;
      if ((paramDrawable instanceof bmth))
      {
        paramString2.b(bmro.b(((bmth)paramDrawable).a()));
        paramString1 = paramString2;
      }
      paramString1.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper = new SegmentKeeper(paramSegmentKeeper);
      b(paramString1);
      if (paramInt2 == 0) {
        SegmentKeeper.adjustTime(-1L * System.currentTimeMillis());
      }
      this.jdField_a_of_type_JavaUtilList.add(paramString1);
      super.k();
      if (!paramString1.jdField_b_of_type_Boolean) {
        break label521;
      }
      this.jdField_b_of_type_JavaUtilList.add(paramString1);
    }
    for (;;)
    {
      a(paramString1, this.jdField_b_of_type_JavaUtilMap);
      return true;
      wsv.b(jdField_a_of_type_JavaLangString, "Create FaceAndTextItem with text:" + localbmmc.jdField_a_of_type_JavaLangString);
      paramString1 = new bmlv(this, paramDrawable, localbmmc, paramString1, paramString2, paramString3, paramInt1, paramInt2);
      ((bmlv)paramString1).a();
      break;
      label521:
      a(paramString1, this.jdField_a_of_type_JavaUtilMap);
    }
  }
  
  public boolean a(String paramString1, String paramString2, Drawable paramDrawable, bmmc parambmmc, String paramString3, boolean paramBoolean, String paramString4, int paramInt1, String paramString5, int paramInt2, int paramInt3)
  {
    if (paramDrawable == null)
    {
      wsv.e(jdField_a_of_type_JavaLangString, "Face drawable is null.");
      return false;
    }
    if (parambmmc == null)
    {
      wsv.e(jdField_a_of_type_JavaLangString, "ItemParams is null.");
      return false;
    }
    if (b())
    {
      wsv.e(jdField_a_of_type_JavaLangString, "has max face count. add face failed.");
      if (this.jdField_a_of_type_Bmmb != null) {
        this.jdField_a_of_type_Bmmb.a(40);
      }
      return false;
    }
    if ((paramInt1 == 1) || (paramInt1 == 3)) {
      paramDrawable.setCallback(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView);
    }
    wsv.a(jdField_a_of_type_JavaLangString, "addFace before, category : %s , name : %s , LayerParams : %s", paramString1, paramString2, parambmmc);
    bmmc localbmmc = bmmc.a(parambmmc);
    int k = (int)(localbmmc.jdField_a_of_type_Int * localbmmc.jdField_a_of_type_Float);
    int j = (int)(localbmmc.b * localbmmc.jdField_a_of_type_Float);
    int i = j;
    if (this.jdField_a_of_type_AndroidGraphicsRect.height() < j)
    {
      f1 = localbmmc.jdField_a_of_type_Float;
      localbmmc.jdField_a_of_type_Float = (this.jdField_a_of_type_AndroidGraphicsRect.height() / j * f1);
      i = this.jdField_a_of_type_AndroidGraphicsRect.height();
    }
    float f1 = localbmmc.jdField_a_of_type_AndroidGraphicsPointF.x;
    float f2 = localbmmc.jdField_a_of_type_AndroidGraphicsPointF.y;
    localbmmc.jdField_a_of_type_AndroidGraphicsPointF.x = a(f1, k, this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.right);
    localbmmc.jdField_a_of_type_AndroidGraphicsPointF.y = a(f2, i, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.bottom);
    wsv.b(jdField_a_of_type_JavaLangString, "addFace after drawRect:" + this.jdField_a_of_type_AndroidGraphicsRect);
    wsv.a(jdField_a_of_type_JavaLangString, "addFace after, category : %s , name : %s , LayerParams : %s", paramString1, paramString2, parambmmc);
    i = -1;
    if (TextUtils.isEmpty(localbmmc.jdField_a_of_type_JavaLangString))
    {
      wsv.b(jdField_a_of_type_JavaLangString, "Create Normal FaceItem.");
      paramString2 = new bmly(this, paramDrawable, localbmmc, paramString1, paramString2, paramString3, paramInt1, paramInt3);
      paramString2.jdField_g_of_type_JavaLangString = paramString5;
      paramString2.a(paramBoolean);
      if (!TextUtils.isEmpty(paramString4))
      {
        if ((paramString2 instanceof bmlv)) {
          paramString2.a(new TroopBarPOI("-1", "", paramString4, 0, "", 0, ""));
        }
      }
      else
      {
        if (!(paramDrawable instanceof bmth)) {
          break label545;
        }
        paramInt1 = ((bmth)paramDrawable).a();
        paramString2.b(bmro.b(paramInt1));
        paramString1 = paramString2;
        label437:
        if (((paramDrawable instanceof bmtf)) || (12 == paramInt1)) {
          paramString1.r = 90.0F;
        }
        paramString1.jdField_g_of_type_Int = paramInt2;
        this.jdField_a_of_type_JavaUtilList.add(paramString1);
        super.k();
        if (!paramString1.jdField_b_of_type_Boolean) {
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
          paramString2.b(bmro.b(paramInt1));
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
      wsv.b(jdField_a_of_type_JavaLangString, "Create FaceAndTextItem with text:" + localbmmc.jdField_a_of_type_JavaLangString);
      paramString1 = new bmlv(this, paramDrawable, localbmmc, paramString1, paramString2, paramString3, paramInt1);
      ((bmlv)paramString1).a();
      paramInt1 = i;
      break label437;
      label673:
      a(paramString1, this.jdField_a_of_type_JavaUtilMap);
    }
  }
  
  public boolean a(JSONObject paramJSONObject)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      return false;
    }
    try
    {
      JSONArray localJSONArray = new JSONArray();
      Object localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject3 = (bmly)((Iterator)localObject1).next();
        Object localObject2 = new PasterParcelData((bmly)localObject3);
        JSONObject localJSONObject = ((PasterParcelData)localObject2).a();
        localJSONObject.put("trackingEnable", ((bmly)localObject3).jdField_d_of_type_Boolean);
        if ((localObject2 != null) && (((bmly)localObject3).jdField_g_of_type_Boolean) && (((bmly)localObject3).jdField_h_of_type_Boolean))
        {
          localJSONObject.put("isAnchor", ((bmly)localObject3).jdField_g_of_type_Boolean);
          localJSONObject.put("isInKiteMode", ((bmly)localObject3).jdField_h_of_type_Boolean);
          localJSONObject.put("trackerTransX", ((bmly)localObject3).j);
          localJSONObject.put("trackerTransY", ((bmly)localObject3).jdField_k_of_type_Float);
          localJSONObject.put("trackerScreenX", ((bmly)localObject3).jdField_l_of_type_Float);
          localJSONObject.put("trackerScreenY", ((bmly)localObject3).jdField_m_of_type_Float);
          localJSONObject.put("touchDownInNail", ((bmly)localObject3).jdField_e_of_type_Boolean);
          localJSONObject.put("trackerStartScale", ((bmly)localObject3).o);
          localJSONObject.put("trackingState", ((bmly)localObject3).i);
          localObject2 = new JSONArray();
          localObject3 = ((bmly)localObject3).jdField_a_of_type_JavaUtilMap.entrySet().iterator();
          while (((Iterator)localObject3).hasNext())
          {
            Map.Entry localEntry = (Map.Entry)((Iterator)localObject3).next();
            ((JSONArray)localObject2).put(localEntry.getKey());
            ((JSONArray)localObject2).put(((TrackerStickerParam.MotionInfo)localEntry.getValue()).convertToJSON());
          }
          localJSONObject.put("motionInfo", localObject2);
        }
        localJSONArray.put(localJSONObject);
      }
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("topLevelWeight", this.t);
      ((JSONObject)localObject1).put("isEditPic", this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a());
      ((JSONObject)localObject1).put("faceItems", localJSONArray);
      paramJSONObject.put(b(), localObject1);
      return true;
    }
    catch (Exception paramJSONObject) {}
    return false;
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
      if (((bmly)localIterator.next() instanceof bmlv)) {
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
      wsv.b(jdField_a_of_type_JavaLangString, "FaceLayer, DoodleCount:" + i);
      return i;
    }
  }
  
  public String b()
  {
    return "FaceLayer";
  }
  
  public void b(Canvas paramCanvas)
  {
    a(paramCanvas, this.jdField_a_of_type_Float, false);
  }
  
  public void b(bmly parambmly)
  {
    if ((parambmly.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) || (!(parambmly.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof BitmapDrawable))) {}
    long l1;
    label95:
    long l2;
    do
    {
      return;
      l1 = System.currentTimeMillis();
      Object localObject = ((BitmapDrawable)parambmly.jdField_a_of_type_AndroidGraphicsDrawableDrawable).getBitmap();
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
      int j = (int)parambmly.u;
      parambmly.jdField_a_of_type_ArrayOfInt = new int[j * 2];
      float f1 = k / parambmly.u;
      float f2 = parambmly.v / m;
      i = 0;
      while (i < j)
      {
        k = (int)(i * f1);
        parambmly.jdField_a_of_type_ArrayOfInt[(i * 2)] = ((int)(localObject[(k * 2)] * f2));
        parambmly.jdField_a_of_type_ArrayOfInt[(i * 2 + 1)] = ((int)(localObject[(k * 2 + 1)] * f2));
        if (localObject[(k * 2 + 1)] > 0)
        {
          if (parambmly.jdField_l_of_type_Int == -1) {
            parambmly.jdField_l_of_type_Int = i;
          }
          parambmly.jdField_m_of_type_Int = Math.max(i, parambmly.jdField_m_of_type_Int);
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
    if (i >= 0)
    {
      bmly localbmly = (bmly)this.jdField_a_of_type_JavaUtilList.get(i);
      if ((localbmly.d()) && (!localbmly.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.isCurrentIn())) {}
      while (!this.jdField_a_of_type_Bmtw.a(localbmly, f1, f2, false))
      {
        i -= 1;
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "accept inside x:" + paramMotionEvent.getX() + " y:" + paramMotionEvent.getY());
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "accept outside x:" + paramMotionEvent.getX() + " y:" + paramMotionEvent.getY());
    }
    return false;
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      a((bmly)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1));
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
  
  public void e()
  {
    if ((this.jdField_a_of_type_Bmly != null) && (!this.jdField_a_of_type_Bmly.a()) && (!this.jdField_a_of_type_Bmly.b())) {
      this.jdField_a_of_type_Bmly.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmlu
 * JD-Core Version:    0.7.0.1
 */