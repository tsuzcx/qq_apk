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
public class bmqg
  extends bmri
{
  public static final String a;
  public int a;
  public Paint a;
  public Drawable a;
  public TextPaint a;
  public bmqk a;
  public bmqn a;
  public bmyi a;
  public List<bmqk> a;
  public Map<String, List<String>> a;
  public boolean a;
  public Paint b;
  public List<bmqk> b;
  public Map<String, List<String>> b;
  public Paint c;
  public Paint d;
  public Paint e;
  public Paint f;
  public Paint g;
  
  static
  {
    jdField_a_of_type_JavaLangString = bmqg.class.getSimpleName();
  }
  
  public bmqg(DoodleView paramDoodleView)
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
      this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_Bmqk);
      this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_Bmqk);
    }
  }
  
  private void a(bmqk parambmqk, Canvas paramCanvas)
  {
    if (parambmqk == null) {
      return;
    }
    paramCanvas.save();
    paramCanvas.concat(this.jdField_a_of_type_Bmyi.a(parambmqk));
    parambmqk.a(paramCanvas, true);
    paramCanvas.restore();
  }
  
  private void a(bmqk parambmqk, Map<String, List<String>> paramMap)
  {
    List localList = (List)paramMap.get(parambmqk.jdField_d_of_type_JavaLangString);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      paramMap.put(parambmqk.jdField_d_of_type_JavaLangString, localObject);
    }
    ((List)localObject).add(parambmqk.jdField_e_of_type_JavaLangString);
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    int i = this.jdField_a_of_type_JavaUtilList.size() - 1;
    if (i >= 0)
    {
      bmqk localbmqk = (bmqk)this.jdField_a_of_type_JavaUtilList.get(i);
      if ((localbmqk.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper != null) && (localbmqk.d()) && (!localbmqk.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.isCurrentIn())) {}
      while (!this.jdField_a_of_type_Bmyi.a(localbmqk, paramFloat1, paramFloat2, false))
      {
        i -= 1;
        break;
      }
      this.jdField_a_of_type_Bmqk = localbmqk;
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
    if (this.jdField_a_of_type_Bmqk != null) {
      this.jdField_a_of_type_Bmqk.jdField_e_of_type_Boolean = false;
    }
    this.jdField_a_of_type_Bmqk = null;
    this.jdField_a_of_type_Bmyi.a();
    super.k();
    super.d(false);
    n();
  }
  
  private void b(bmqk parambmqk, Map<String, List<String>> paramMap)
  {
    List localList = (List)paramMap.get(parambmqk.jdField_d_of_type_JavaLangString);
    if (localList != null)
    {
      localList.remove(parambmqk.jdField_e_of_type_JavaLangString);
      if (localList.isEmpty()) {
        paramMap.remove(parambmqk.jdField_d_of_type_JavaLangString);
      }
    }
  }
  
  private void c(bmqk parambmqk)
  {
    boolean bool1 = this.jdField_a_of_type_Bmyi.a(parambmqk, StoryGuideLineView.jdField_a_of_type_Int, true);
    boolean bool2 = this.jdField_a_of_type_Bmyi.a(parambmqk, StoryGuideLineView.b, false);
    boolean bool3 = this.jdField_a_of_type_Bmyi.b(parambmqk, StoryGuideLineView.d, false);
    if (this.jdField_a_of_type_Bmqn != null) {
      this.jdField_a_of_type_Bmqn.a(bool1, bool2, false, bool3, parambmqk.jdField_l_of_type_Boolean);
    }
    if (parambmqk != null)
    {
      if (parambmqk.jdField_k_of_type_Boolean) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(parambmqk.jdField_l_of_type_Boolean, parambmqk.r, parambmqk.s, parambmqk.t, parambmqk.jdField_b_of_type_AndroidGraphicsPointF, parambmqk.jdField_m_of_type_Boolean, 2);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(parambmqk.jdField_l_of_type_Boolean, parambmqk.r, parambmqk.s, parambmqk.t, parambmqk.jdField_b_of_type_AndroidGraphicsPointF, parambmqk.jdField_m_of_type_Boolean, 1);
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846297);
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
    this.jdField_a_of_type_Bmyi = new bmyi();
    this.jdField_a_of_type_Bmyi.a(true);
    this.jdField_a_of_type_Bmyi.a(18.0F);
    this.jdField_a_of_type_Bmyi.b(0.2F);
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
    if ((this.jdField_a_of_type_Bmqn != null) && (this.jdField_a_of_type_Bmqk != null) && (this.jdField_a_of_type_Bmqn.a(this.jdField_a_of_type_Bmqk))) {
      this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_Bmqk);
    }
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_Bmqk != null) {
      this.jdField_a_of_type_Bmqk.c();
    }
  }
  
  private void i()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(false, 0.0F, 0.0F, 0.0F, null, false, 1);
  }
  
  public Rect a(Rect paramRect)
  {
    paramRect.setEmpty();
    if (this.jdField_a_of_type_Bmqk != null)
    {
      int i = (int)(this.jdField_a_of_type_Bmqk.u * this.jdField_a_of_type_Bmqk.q);
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
      localArrayList.add(new PasterParcelData((bmqk)this.jdField_a_of_type_JavaUtilList.get(i)));
      i += 1;
    }
    localBundle.putParcelableArrayList("StickerParcelDataList", localArrayList);
    return localBundle;
  }
  
  public bmyj a(bmyj parambmyj, String paramString1, String paramString2, Drawable paramDrawable, bmqo parambmqo, String paramString3, int paramInt1, boolean paramBoolean, String paramString4, String paramString5, int paramInt2)
  {
    if (paramDrawable == null)
    {
      wxe.e(jdField_a_of_type_JavaLangString, "Face drawable is null.");
      return null;
    }
    if (parambmqo == null)
    {
      wxe.e(jdField_a_of_type_JavaLangString, "ItemParams is null.");
      return null;
    }
    bmqo localbmqo = bmqo.a(parambmyj, parambmqo);
    bmqk localbmqk;
    if ((parambmyj instanceof bmqk))
    {
      localbmqk = (bmqk)parambmyj;
      if (localbmqk.jdField_b_of_type_Boolean)
      {
        this.jdField_b_of_type_JavaUtilList.remove(localbmqk);
        b(localbmqk, this.jdField_b_of_type_JavaUtilMap);
      }
    }
    else
    {
      if (!TextUtils.isEmpty(parambmqo.jdField_a_of_type_JavaLangString)) {
        break label321;
      }
      wxe.b(jdField_a_of_type_JavaLangString, "Create Normal FaceItem.");
      paramString2 = new bmqk(this, paramDrawable, localbmqo, paramString1, paramString2, paramString3, paramInt1, paramInt2);
      paramString2.a(paramBoolean);
      if ((paramDrawable instanceof bmxt)) {
        paramString2.b(bmwa.b(((bmxt)paramDrawable).a()));
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
    paramString2.b(bmwa.b(paramInt1));
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
    paramString1.a(parambmyj);
    if (paramString1.jdField_b_of_type_Boolean) {
      this.jdField_b_of_type_JavaUtilList.add(paramString1);
    }
    for (;;)
    {
      b(paramString1, this.jdField_b_of_type_JavaUtilMap);
      return paramString1;
      b(localbmqk, this.jdField_a_of_type_JavaUtilMap);
      break;
      label321:
      wxe.b(jdField_a_of_type_JavaLangString, "Create FaceAndTextItem with text:" + localbmqo.jdField_a_of_type_JavaLangString);
      paramString1 = new bmqh(this, paramDrawable, localbmqo, paramString1, paramString2, paramString3, paramInt1, paramInt2);
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
        bmqk localbmqk = (bmqk)localIterator.next();
        if ((localbmqk.c()) || (localbmqk.d()))
        {
          TrackerStickerParam localTrackerStickerParam = new TrackerStickerParam(localbmqk.jdField_b_of_type_AndroidGraphicsPointF.x, localbmqk.jdField_b_of_type_AndroidGraphicsPointF.y, localbmqk.q, localbmqk.r, localbmqk.s, localbmqk.t, localbmqk.u, localbmqk.v, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_Int, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.b, localbmqk.f, localbmqk.jdField_a_of_type_JavaUtilMap);
          localTrackerStickerParam.setSegmentList(localbmqk.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.getSegmentList());
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
    this.jdField_a_of_type_Bmqk = null;
    this.jdField_a_of_type_Bmyi.a();
    wxe.b(jdField_a_of_type_JavaLangString, "clear over.");
  }
  
  public void a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      bmqk localbmqk = (bmqk)localIterator.next();
      if (localbmqk.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper != null) {
        localbmqk.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.setMode(paramInt);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
      wxe.b(jdField_a_of_type_JavaLangString, "mFaceItems = null or size<=0");
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        bmqk localbmqk = (bmqk)localIterator.next();
        paramInt1 = (int)(localbmqk.u * localbmqk.q);
        paramInt2 = (int)(localbmqk.v * localbmqk.q);
        localbmqk.jdField_b_of_type_AndroidGraphicsPointF.x = a(localbmqk.jdField_b_of_type_AndroidGraphicsPointF.x, paramInt1, this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.right);
        localbmqk.jdField_b_of_type_AndroidGraphicsPointF.y = a(localbmqk.jdField_b_of_type_AndroidGraphicsPointF.y, paramInt2, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.bottom);
      }
    }
  }
  
  protected void a(Canvas paramCanvas)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      a((bmqk)localIterator.next(), paramCanvas);
    }
  }
  
  public void a(Canvas paramCanvas, float paramFloat, boolean paramBoolean)
  {
    paramCanvas.save();
    paramCanvas.scale(paramFloat, paramFloat);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      bmqk localbmqk = (bmqk)localIterator.next();
      if ((localbmqk.jdField_h_of_type_Int == 0) && ((paramBoolean) || ((!localbmqk.c()) && (!localbmqk.d()))))
      {
        paramCanvas.save();
        paramCanvas.concat(this.jdField_a_of_type_Bmyi.a(localbmqk));
        localbmqk.a(paramCanvas, false);
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
  
  public void a(bmqk parambmqk)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()) && (this.jdField_a_of_type_JavaUtilList.remove(parambmqk)))
    {
      if (!parambmqk.jdField_b_of_type_Boolean) {
        break label78;
      }
      DoodleLayout.a("delete_poi");
      wxk.a("0X80076D2");
      wxk.b("0X80075E7");
      this.jdField_b_of_type_JavaUtilList.remove(parambmqk);
    }
    for (;;)
    {
      b(parambmqk, this.jdField_b_of_type_JavaUtilMap);
      return;
      label78:
      DoodleLayout.a("delete_oneface");
      wxk.a("0X80076CB");
      wxk.b("0X80075E0");
      b(parambmqk, this.jdField_a_of_type_JavaUtilMap);
    }
  }
  
  public void a(bmqk parambmqk, TroopBarPOI paramTroopBarPOI)
  {
    if (parambmqk != null)
    {
      parambmqk.a(paramTroopBarPOI);
      parambmqk.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setCallback(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a);
      k();
    }
  }
  
  public void a(bmqn parambmqn)
  {
    this.jdField_a_of_type_Bmqn = parambmqn;
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        bmqk localbmqk = (bmqk)localIterator.next();
        if ((a(localbmqk.jdField_d_of_type_JavaLangString, paramString1)) && (a(localbmqk.jdField_e_of_type_JavaLangString, paramString2))) {
          a(localbmqk);
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
      if (((bmqk)localIterator.next()).jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.isSegmentChanged(paramLong)) {
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
      this.jdField_a_of_type_Bmyi.a(paramMotionEvent, false);
      if (this.jdField_a_of_type_Bmqk == null) {
        break;
      }
      c(this.jdField_a_of_type_Bmqk);
      return true;
      this.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_Boolean = false;
      a(paramMotionEvent);
      if (this.jdField_a_of_type_Bmqk != null) {
        this.jdField_a_of_type_Bmyi.a(this.jdField_a_of_type_Bmqk);
      }
      e();
      if (this.jdField_a_of_type_Bmqk != null)
      {
        this.jdField_a_of_type_Bmqk.b();
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
  
  public boolean a(String paramString1, String paramString2, Drawable paramDrawable, bmqo parambmqo, String paramString3, boolean paramBoolean, int paramInt1, int paramInt2, SegmentKeeper paramSegmentKeeper)
  {
    if (paramDrawable == null)
    {
      wxe.e(jdField_a_of_type_JavaLangString, "Face drawable is null.");
      return false;
    }
    if (parambmqo == null)
    {
      wxe.e(jdField_a_of_type_JavaLangString, "ItemParams is null.");
      return false;
    }
    if (b())
    {
      wxe.e(jdField_a_of_type_JavaLangString, "has max face count. add face failed.");
      if (this.jdField_a_of_type_Bmqn != null) {
        this.jdField_a_of_type_Bmqn.a(40);
      }
      return false;
    }
    if ((paramInt1 == 1) || (paramInt1 == 3)) {
      paramDrawable.setCallback(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView);
    }
    wxe.a(jdField_a_of_type_JavaLangString, "addFace before, category : %s , name : %s , LayerParams : %s", paramString1, paramString2, parambmqo);
    bmqo localbmqo = bmqo.a(parambmqo);
    int k = (int)(localbmqo.jdField_a_of_type_Int * localbmqo.jdField_a_of_type_Float);
    int j = (int)(localbmqo.b * localbmqo.jdField_a_of_type_Float);
    int i = j;
    if (this.jdField_a_of_type_AndroidGraphicsRect.height() < j)
    {
      f1 = localbmqo.jdField_a_of_type_Float;
      localbmqo.jdField_a_of_type_Float = (this.jdField_a_of_type_AndroidGraphicsRect.height() / j * f1);
      i = this.jdField_a_of_type_AndroidGraphicsRect.height();
    }
    float f1 = localbmqo.jdField_a_of_type_AndroidGraphicsPointF.x;
    float f2 = localbmqo.jdField_a_of_type_AndroidGraphicsPointF.y;
    localbmqo.jdField_a_of_type_AndroidGraphicsPointF.x = a(f1, k, this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.right);
    localbmqo.jdField_a_of_type_AndroidGraphicsPointF.y = a(f2, i, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.bottom);
    wxe.b(jdField_a_of_type_JavaLangString, "addFace after drawRect:" + this.jdField_a_of_type_AndroidGraphicsRect);
    wxe.a(jdField_a_of_type_JavaLangString, "addFace after, category : %s , name : %s , LayerParams : %s", paramString1, paramString2, parambmqo);
    if (TextUtils.isEmpty(localbmqo.jdField_a_of_type_JavaLangString))
    {
      wxe.b(jdField_a_of_type_JavaLangString, "Create Normal FaceItem.");
      paramString2 = new bmqk(this, paramDrawable, localbmqo, paramString1, paramString2, paramString3, paramInt1, paramInt2);
      paramString2.a(paramBoolean);
      paramString1 = paramString2;
      if ((paramDrawable instanceof bmxt))
      {
        paramString2.b(bmwa.b(((bmxt)paramDrawable).a()));
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
      wxe.b(jdField_a_of_type_JavaLangString, "Create FaceAndTextItem with text:" + localbmqo.jdField_a_of_type_JavaLangString);
      paramString1 = new bmqh(this, paramDrawable, localbmqo, paramString1, paramString2, paramString3, paramInt1, paramInt2);
      ((bmqh)paramString1).a();
      break;
      label521:
      a(paramString1, this.jdField_a_of_type_JavaUtilMap);
    }
  }
  
  public boolean a(String paramString1, String paramString2, Drawable paramDrawable, bmqo parambmqo, String paramString3, boolean paramBoolean, String paramString4, int paramInt1, String paramString5, int paramInt2, int paramInt3)
  {
    if (paramDrawable == null)
    {
      wxe.e(jdField_a_of_type_JavaLangString, "Face drawable is null.");
      return false;
    }
    if (parambmqo == null)
    {
      wxe.e(jdField_a_of_type_JavaLangString, "ItemParams is null.");
      return false;
    }
    if (b())
    {
      wxe.e(jdField_a_of_type_JavaLangString, "has max face count. add face failed.");
      if (this.jdField_a_of_type_Bmqn != null) {
        this.jdField_a_of_type_Bmqn.a(40);
      }
      return false;
    }
    if ((paramInt1 == 1) || (paramInt1 == 3)) {
      paramDrawable.setCallback(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView);
    }
    wxe.a(jdField_a_of_type_JavaLangString, "addFace before, category : %s , name : %s , LayerParams : %s", paramString1, paramString2, parambmqo);
    bmqo localbmqo = bmqo.a(parambmqo);
    int k = (int)(localbmqo.jdField_a_of_type_Int * localbmqo.jdField_a_of_type_Float);
    int j = (int)(localbmqo.b * localbmqo.jdField_a_of_type_Float);
    int i = j;
    if (this.jdField_a_of_type_AndroidGraphicsRect.height() < j)
    {
      f1 = localbmqo.jdField_a_of_type_Float;
      localbmqo.jdField_a_of_type_Float = (this.jdField_a_of_type_AndroidGraphicsRect.height() / j * f1);
      i = this.jdField_a_of_type_AndroidGraphicsRect.height();
    }
    float f1 = localbmqo.jdField_a_of_type_AndroidGraphicsPointF.x;
    float f2 = localbmqo.jdField_a_of_type_AndroidGraphicsPointF.y;
    localbmqo.jdField_a_of_type_AndroidGraphicsPointF.x = a(f1, k, this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.right);
    localbmqo.jdField_a_of_type_AndroidGraphicsPointF.y = a(f2, i, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.bottom);
    wxe.b(jdField_a_of_type_JavaLangString, "addFace after drawRect:" + this.jdField_a_of_type_AndroidGraphicsRect);
    wxe.a(jdField_a_of_type_JavaLangString, "addFace after, category : %s , name : %s , LayerParams : %s", paramString1, paramString2, parambmqo);
    i = -1;
    if (TextUtils.isEmpty(localbmqo.jdField_a_of_type_JavaLangString))
    {
      wxe.b(jdField_a_of_type_JavaLangString, "Create Normal FaceItem.");
      paramString2 = new bmqk(this, paramDrawable, localbmqo, paramString1, paramString2, paramString3, paramInt1, paramInt3);
      paramString2.jdField_g_of_type_JavaLangString = paramString5;
      paramString2.a(paramBoolean);
      if (!TextUtils.isEmpty(paramString4))
      {
        if ((paramString2 instanceof bmqh)) {
          paramString2.a(new TroopBarPOI("-1", "", paramString4, 0, "", 0, ""));
        }
      }
      else
      {
        if (!(paramDrawable instanceof bmxt)) {
          break label545;
        }
        paramInt1 = ((bmxt)paramDrawable).a();
        paramString2.b(bmwa.b(paramInt1));
        paramString1 = paramString2;
        label437:
        if (((paramDrawable instanceof bmxr)) || (12 == paramInt1)) {
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
          paramString2.b(bmwa.b(paramInt1));
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
      wxe.b(jdField_a_of_type_JavaLangString, "Create FaceAndTextItem with text:" + localbmqo.jdField_a_of_type_JavaLangString);
      paramString1 = new bmqh(this, paramDrawable, localbmqo, paramString1, paramString2, paramString3, paramInt1);
      ((bmqh)paramString1).a();
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
        Object localObject3 = (bmqk)((Iterator)localObject1).next();
        Object localObject2 = new PasterParcelData((bmqk)localObject3);
        JSONObject localJSONObject = ((PasterParcelData)localObject2).a();
        localJSONObject.put("trackingEnable", ((bmqk)localObject3).jdField_d_of_type_Boolean);
        if ((localObject2 != null) && (((bmqk)localObject3).jdField_g_of_type_Boolean) && (((bmqk)localObject3).jdField_h_of_type_Boolean))
        {
          localJSONObject.put("isAnchor", ((bmqk)localObject3).jdField_g_of_type_Boolean);
          localJSONObject.put("isInKiteMode", ((bmqk)localObject3).jdField_h_of_type_Boolean);
          localJSONObject.put("trackerTransX", ((bmqk)localObject3).j);
          localJSONObject.put("trackerTransY", ((bmqk)localObject3).jdField_k_of_type_Float);
          localJSONObject.put("trackerScreenX", ((bmqk)localObject3).jdField_l_of_type_Float);
          localJSONObject.put("trackerScreenY", ((bmqk)localObject3).jdField_m_of_type_Float);
          localJSONObject.put("touchDownInNail", ((bmqk)localObject3).jdField_e_of_type_Boolean);
          localJSONObject.put("trackerStartScale", ((bmqk)localObject3).o);
          localJSONObject.put("trackingState", ((bmqk)localObject3).i);
          localObject2 = new JSONArray();
          localObject3 = ((bmqk)localObject3).jdField_a_of_type_JavaUtilMap.entrySet().iterator();
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
      if (((bmqk)localIterator.next() instanceof bmqh)) {
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
      wxe.b(jdField_a_of_type_JavaLangString, "FaceLayer, DoodleCount:" + i);
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
  
  public void b(bmqk parambmqk)
  {
    if ((parambmqk.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) || (!(parambmqk.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof BitmapDrawable))) {}
    long l1;
    label95:
    long l2;
    do
    {
      return;
      l1 = System.currentTimeMillis();
      Object localObject = ((BitmapDrawable)parambmqk.jdField_a_of_type_AndroidGraphicsDrawableDrawable).getBitmap();
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
      int j = (int)parambmqk.u;
      parambmqk.jdField_a_of_type_ArrayOfInt = new int[j * 2];
      float f1 = k / parambmqk.u;
      float f2 = parambmqk.v / m;
      i = 0;
      while (i < j)
      {
        k = (int)(i * f1);
        parambmqk.jdField_a_of_type_ArrayOfInt[(i * 2)] = ((int)(localObject[(k * 2)] * f2));
        parambmqk.jdField_a_of_type_ArrayOfInt[(i * 2 + 1)] = ((int)(localObject[(k * 2 + 1)] * f2));
        if (localObject[(k * 2 + 1)] > 0)
        {
          if (parambmqk.jdField_l_of_type_Int == -1) {
            parambmqk.jdField_l_of_type_Int = i;
          }
          parambmqk.jdField_m_of_type_Int = Math.max(i, parambmqk.jdField_m_of_type_Int);
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
      bmqk localbmqk = (bmqk)this.jdField_a_of_type_JavaUtilList.get(i);
      if ((localbmqk.d()) && (!localbmqk.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.isCurrentIn())) {}
      while (!this.jdField_a_of_type_Bmyi.a(localbmqk, f1, f2, false))
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
      a((bmqk)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1));
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
    if ((this.jdField_a_of_type_Bmqk != null) && (!this.jdField_a_of_type_Bmqk.a()) && (!this.jdField_a_of_type_Bmqk.b())) {
      this.jdField_a_of_type_Bmqk.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmqg
 * JD-Core Version:    0.7.0.1
 */