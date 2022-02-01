package com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
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
import com.tencent.aelight.camera.aioeditor.capture.paster.PasterParcelData;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.InformationFaceConstant;
import com.tencent.aelight.camera.aioeditor.doodle.ui.widget.FilmDigitInfoStickerDrawable;
import com.tencent.aelight.camera.aioeditor.doodle.ui.widget.InfoStickerDrawable;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.base.BaseLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleView;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.widget.StoryGuideLineView;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.GestureHelper;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.GestureHelper.ZoomItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.mobileqq.tribe.data.TroopBarPOI;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;

@TargetApi(11)
public class FaceLayer
  extends BaseLayer
{
  public static final String a = "FaceLayer";
  public List<FaceLayer.FaceItem> b = new CopyOnWriteArrayList();
  public FaceLayer.FaceItem c;
  public Paint d;
  public TextPaint e;
  public Paint f;
  public Paint g;
  public Paint h;
  public Paint i;
  public Paint j;
  public Paint k;
  public Drawable l;
  public GestureHelper m;
  public int n;
  public boolean o;
  public FaceLayer.LayerEventListener p;
  public Map<String, List<String>> q = new HashMap();
  public List<FaceLayer.FaceItem> r = new ArrayList();
  public Map<String, List<String>> s = new HashMap();
  
  public FaceLayer(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
    l();
  }
  
  private int a(float paramFloat, int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = (int)paramFloat;
    if (paramInt3 == 0) {
      return i1;
    }
    paramInt1 /= 2;
    float f2 = paramInt1;
    float f1 = paramFloat;
    if (paramFloat - f2 < paramInt2) {
      f1 = paramInt2 + paramInt1;
    }
    paramFloat = f1;
    if (f2 + f1 > paramInt3) {
      paramFloat = paramInt3 - paramInt1;
    }
    return (int)paramFloat;
  }
  
  private void a(FaceLayer.FaceItem paramFaceItem, Canvas paramCanvas)
  {
    if (paramFaceItem == null) {
      return;
    }
    paramCanvas.save();
    paramCanvas.concat(this.m.b(paramFaceItem));
    paramFaceItem.a(paramCanvas, true);
    paramCanvas.restore();
  }
  
  private void a(FaceLayer.FaceItem paramFaceItem, Map<String, List<String>> paramMap)
  {
    List localList = (List)paramMap.get(paramFaceItem.n);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      paramMap.put(paramFaceItem.n, localObject);
    }
    ((List)localObject).add(paramFaceItem.o);
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    int i1 = this.b.size() - 1;
    while (i1 >= 0)
    {
      FaceLayer.FaceItem localFaceItem = (FaceLayer.FaceItem)this.b.get(i1);
      if (this.m.a(localFaceItem, paramFloat1, paramFloat2, false))
      {
        this.c = localFaceItem;
        return true;
      }
      i1 -= 1;
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
  
  private void b(FaceLayer.FaceItem paramFaceItem, Map<String, List<String>> paramMap)
  {
    List localList = (List)paramMap.get(paramFaceItem.n);
    if (localList != null)
    {
      localList.remove(paramFaceItem.o);
      if (localList.isEmpty()) {
        paramMap.remove(paramFaceItem.n);
      }
    }
  }
  
  private void c(MotionEvent paramMotionEvent)
  {
    if (a(paramMotionEvent.getX(0), paramMotionEvent.getY(0)))
    {
      this.b.remove(this.c);
      this.b.add(this.c);
    }
  }
  
  private void c(FaceLayer.FaceItem paramFaceItem)
  {
    boolean bool1 = this.m.a(paramFaceItem, StoryGuideLineView.a, true);
    boolean bool2 = this.m.a(paramFaceItem, StoryGuideLineView.b, false);
    boolean bool3 = this.m.b(paramFaceItem, StoryGuideLineView.d, false);
    FaceLayer.LayerEventListener localLayerEventListener = this.p;
    if (localLayerEventListener != null) {
      localLayerEventListener.a(bool1, bool2, false, bool3, paramFaceItem.S);
    }
    if (paramFaceItem != null)
    {
      if (paramFaceItem.M)
      {
        this.z.a(paramFaceItem.S, paramFaceItem.C, paramFaceItem.D, paramFaceItem.E, paramFaceItem.A, paramFaceItem.T, 2);
        return;
      }
      this.z.a(paramFaceItem.S, paramFaceItem.C, paramFaceItem.D, paramFaceItem.E, paramFaceItem.A, paramFaceItem.T, 1);
    }
  }
  
  private void e(MotionEvent paramMotionEvent)
  {
    this.c = null;
    this.m.a();
    super.u();
    super.d(false);
  }
  
  private void l()
  {
    this.d = new Paint();
    this.l = this.y.getResources().getDrawable(2130848528);
    this.e = new TextPaint();
    this.e.setAntiAlias(true);
    this.e.setTextAlign(Paint.Align.LEFT);
    this.e.setStyle(Paint.Style.FILL);
    this.e.setTypeface(Typeface.DEFAULT);
    this.f = new Paint();
    this.f.setAntiAlias(true);
    this.f.setStyle(Paint.Style.STROKE);
    this.f.setColor(-65536);
    this.f.setStrokeWidth(2.0F);
    this.g = new Paint();
    this.g.setAntiAlias(true);
    this.g.setStyle(Paint.Style.STROKE);
    this.g.setColor(-16711936);
    this.g.setStrokeWidth(2.0F);
    this.C.setStrokeWidth(2.0F);
    this.h = new Paint();
    this.h.setStrokeWidth(1.0F);
    this.h.setColor(-1);
    this.h.setStyle(Paint.Style.STROKE);
    this.h.setPathEffect(new DashPathEffect(new float[] { 8.0F, 6.0F }, 0.0F));
    this.m = new GestureHelper();
    this.m.a(true);
    this.m.a(18.0F);
    this.m.b(0.2F);
    this.i = new Paint();
    this.i.setAntiAlias(true);
    this.i.setStyle(Paint.Style.STROKE);
    this.i.setColor(-1);
    this.i.setStrokeWidth(2.0F);
    this.k = new Paint();
    this.k.setAntiAlias(true);
    this.k.setColor(-1);
    this.k.setStyle(Paint.Style.FILL);
    this.j = new Paint();
    this.j.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    this.j.setStyle(Paint.Style.FILL);
  }
  
  private void m()
  {
    FaceLayer.LayerEventListener localLayerEventListener = this.p;
    if (localLayerEventListener != null)
    {
      FaceLayer.FaceItem localFaceItem = this.c;
      if ((localFaceItem != null) && (localLayerEventListener.a(localFaceItem))) {
        this.b.remove(this.c);
      }
    }
  }
  
  private void n()
  {
    FaceLayer.FaceItem localFaceItem = this.c;
    if (localFaceItem != null) {
      localFaceItem.c();
    }
  }
  
  private void o()
  {
    this.z.a(false, 0.0F, 0.0F, 0.0F, null, false, 1);
  }
  
  public Rect a(Rect paramRect)
  {
    paramRect.setEmpty();
    FaceLayer.FaceItem localFaceItem = this.c;
    if (localFaceItem != null)
    {
      int i1 = (int)(localFaceItem.G * this.c.B);
      paramRect.set(0, 0, i1, i1);
    }
    return paramRect;
  }
  
  public GestureHelper.ZoomItem a(GestureHelper.ZoomItem paramZoomItem, String paramString1, String paramString2, Drawable paramDrawable, FaceLayer.LayerParams paramLayerParams, String paramString3, int paramInt1, boolean paramBoolean, String paramString4, String paramString5, int paramInt2)
  {
    if (paramDrawable == null)
    {
      SLog.e(a, "Face drawable is null.");
      return null;
    }
    if (paramLayerParams == null)
    {
      SLog.e(a, "ItemParams is null.");
      return null;
    }
    FaceLayer.LayerParams localLayerParams = FaceLayer.LayerParams.a(paramZoomItem, paramLayerParams);
    if ((paramZoomItem instanceof FaceLayer.FaceItem))
    {
      paramZoomItem = (FaceLayer.FaceItem)paramZoomItem;
      if (paramZoomItem.s) {
        this.r.remove(paramZoomItem);
      } else {
        b(paramZoomItem, this.q);
      }
      b(paramZoomItem, this.s);
    }
    if (TextUtils.isEmpty(paramLayerParams.h))
    {
      SLog.b(a, "Create Normal FaceItem.");
      paramString1 = new FaceLayer.FaceItem(this, paramDrawable, localLayerParams, paramString1, paramString2, paramString3, paramInt1, paramInt2);
      paramString1.a(paramBoolean);
      if ((paramDrawable instanceof InfoStickerDrawable)) {
        paramString1.b(InformationFaceConstant.b(((InfoStickerDrawable)paramDrawable).f()));
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
    catch (Exception paramZoomItem)
    {
      label207:
      break label207;
    }
    paramString1.b(InformationFaceConstant.b(paramInt1));
    paramZoomItem = paramString1;
    if (!TextUtils.isEmpty(paramString4))
    {
      paramString1.u = new TroopBarPOI("-1", "", paramString4, 0, "", 0, "");
      paramString1.v = System.currentTimeMillis();
      paramZoomItem = paramString1;
      break label328;
      paramZoomItem = a;
      paramLayerParams = new StringBuilder();
      paramLayerParams.append("Create FaceAndTextItem with text:");
      paramLayerParams.append(localLayerParams.h);
      SLog.b(paramZoomItem, paramLayerParams.toString());
      paramZoomItem = new FaceLayer.FaceAndTextItem(this, paramDrawable, localLayerParams, paramString1, paramString2, paramString3, paramInt1, paramInt2);
    }
    label328:
    paramZoomItem.s = paramBoolean;
    if (!TextUtils.isEmpty(paramString5)) {
      paramZoomItem.w = paramString5;
    }
    if (paramZoomItem.s) {
      this.r.add(paramZoomItem);
    } else {
      b(paramZoomItem, this.q);
    }
    b(paramZoomItem, this.s);
    return paramZoomItem;
  }
  
  public String a()
  {
    return a;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    Object localObject = this.b;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = this.b.iterator();
      while (((Iterator)localObject).hasNext())
      {
        FaceLayer.FaceItem localFaceItem = (FaceLayer.FaceItem)((Iterator)localObject).next();
        paramInt1 = (int)(localFaceItem.G * localFaceItem.B);
        paramInt2 = (int)(localFaceItem.H * localFaceItem.B);
        localFaceItem.A.x = a(localFaceItem.A.x, paramInt1, this.B.left, this.B.right);
        localFaceItem.A.y = a(localFaceItem.A.y, paramInt2, this.B.top, this.B.bottom);
      }
      return;
    }
    SLog.b(a, "mFaceItems = null or size<=0");
  }
  
  protected void a(Canvas paramCanvas)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      a((FaceLayer.FaceItem)localIterator.next(), paramCanvas);
    }
  }
  
  public void a(Canvas paramCanvas, float paramFloat, boolean paramBoolean)
  {
    paramCanvas.save();
    paramCanvas.scale(paramFloat, paramFloat);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      FaceLayer.FaceItem localFaceItem = (FaceLayer.FaceItem)localIterator.next();
      if (localFaceItem.y == 0)
      {
        paramCanvas.save();
        paramCanvas.concat(this.m.a(localFaceItem, false));
        localFaceItem.a(paramCanvas, false);
        paramCanvas.restore();
      }
    }
    paramCanvas.restore();
  }
  
  public void a(Matrix paramMatrix)
  {
    super.a(paramMatrix);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((FaceLayer.FaceItem)localIterator.next()).F.set(paramMatrix);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    super.a(paramBundle);
    a(paramBundle.getParcelableArrayList("StickerParcelDataList"), paramBundle.getBoolean("edit_type_photo"), null);
  }
  
  public void a(FaceLayer.FaceItem paramFaceItem)
  {
    List localList = this.b;
    if ((localList != null) && (!localList.isEmpty()) && (this.b.remove(paramFaceItem)))
    {
      if (paramFaceItem.s)
      {
        DoodleLayout.a("delete_poi");
        VideoEditReport.a("0X80076D2");
        VideoEditReport.b("0X80075E7");
        this.r.remove(paramFaceItem);
      }
      else
      {
        DoodleLayout.a("delete_oneface");
        VideoEditReport.a("0X80076CB");
        VideoEditReport.b("0X80075E0");
        b(paramFaceItem, this.q);
      }
      b(paramFaceItem, this.s);
    }
  }
  
  public void a(FaceLayer.FaceItem paramFaceItem, TroopBarPOI paramTroopBarPOI)
  {
    if (paramFaceItem != null)
    {
      paramFaceItem.a(paramTroopBarPOI);
      paramFaceItem.l.setCallback(this.z.l.w);
      u();
    }
  }
  
  public void a(FaceLayer.LayerEventListener paramLayerEventListener)
  {
    this.p = paramLayerEventListener;
  }
  
  public void a(ArrayList<PasterParcelData> paramArrayList, boolean paramBoolean, JSONArray paramJSONArray)
  {
    if ((paramArrayList != null) && (!paramArrayList.isEmpty())) {
      ThreadManager.post(new FaceLayer.1(this, paramArrayList), 8, null, false);
    }
  }
  
  public boolean a(long paramLong)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      if (((FaceLayer.FaceItem)localIterator.next()).U.isSegmentChanged(paramLong)) {
        return false;
      }
    }
    return true;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    int i1 = (int)paramMotionEvent.getY();
    int i2 = Math.abs(i1 - this.n);
    int i3 = paramMotionEvent.getAction() & 0xFF;
    if (i3 != 0)
    {
      if (i3 != 1)
      {
        if (i3 != 2)
        {
          if (i3 == 5) {
            n();
          }
        }
        else if (i2 > 5)
        {
          this.o = true;
          n();
        }
      }
      else
      {
        n();
        if (!this.o) {
          m();
        }
        e(paramMotionEvent);
      }
    }
    else
    {
      this.n = i1;
      this.o = false;
      c(paramMotionEvent);
      FaceLayer.FaceItem localFaceItem = this.c;
      if (localFaceItem != null) {
        this.m.a(localFaceItem);
      }
      localFaceItem = this.c;
      if (localFaceItem != null) {
        localFaceItem.b();
      }
    }
    this.m.a(paramMotionEvent, false);
    paramMotionEvent = this.c;
    if (paramMotionEvent != null)
    {
      c(paramMotionEvent);
      return true;
    }
    o();
    return true;
  }
  
  public boolean a(String paramString1, String paramString2, Drawable paramDrawable, FaceLayer.LayerParams paramLayerParams, String paramString3, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    return a(paramString1, paramString2, paramDrawable, paramLayerParams, paramString3, paramBoolean, paramInt1, paramInt2, null);
  }
  
  public boolean a(String paramString1, String paramString2, Drawable paramDrawable, FaceLayer.LayerParams paramLayerParams, String paramString3, boolean paramBoolean, int paramInt1, int paramInt2, SegmentKeeper paramSegmentKeeper)
  {
    if (paramDrawable == null)
    {
      SLog.e(a, "Face drawable is null.");
      return false;
    }
    if (paramLayerParams == null)
    {
      SLog.e(a, "ItemParams is null.");
      return false;
    }
    if (d())
    {
      SLog.e(a, "has max face count. add face failed.");
      paramString1 = this.p;
      if (paramString1 != null) {
        paramString1.a(40);
      }
      return false;
    }
    if ((paramInt1 == 1) || (paramInt1 == 3)) {
      paramDrawable.setCallback(this.z);
    }
    SLog.a(a, "addFace before, category : %s , name : %s , LayerParams : %s", paramString1, paramString2, paramLayerParams);
    FaceLayer.LayerParams localLayerParams = FaceLayer.LayerParams.a(paramLayerParams);
    int i3 = (int)(localLayerParams.f * localLayerParams.b);
    int i2 = (int)(localLayerParams.g * localLayerParams.b);
    int i1 = i2;
    if (this.B.height() < i2)
    {
      localLayerParams.b *= this.B.height() / i2;
      i1 = this.B.height();
    }
    float f1 = localLayerParams.a.x;
    float f2 = localLayerParams.a.y;
    localLayerParams.a.x = a(f1, i3, this.B.left, this.B.right);
    localLayerParams.a.y = a(f2, i1, this.B.top, this.B.bottom);
    Object localObject = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("addFace after drawRect:");
    localStringBuilder.append(this.B);
    SLog.b((String)localObject, localStringBuilder.toString());
    SLog.a(a, "addFace after, category : %s , name : %s , LayerParams : %s", paramString1, paramString2, paramLayerParams);
    if (TextUtils.isEmpty(localLayerParams.h))
    {
      SLog.b(a, "Create Normal FaceItem.");
      paramString2 = new FaceLayer.FaceItem(this, paramDrawable, localLayerParams, paramString1, paramString2, paramString3, paramInt1, paramInt2);
      paramString2.a(paramBoolean);
      paramString1 = paramString2;
      if ((paramDrawable instanceof InfoStickerDrawable))
      {
        paramString2.b(InformationFaceConstant.b(((InfoStickerDrawable)paramDrawable).f()));
        paramString1 = paramString2;
      }
    }
    else
    {
      paramLayerParams = a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Create FaceAndTextItem with text:");
      ((StringBuilder)localObject).append(localLayerParams.h);
      SLog.b(paramLayerParams, ((StringBuilder)localObject).toString());
      paramString1 = new FaceLayer.FaceAndTextItem(this, paramDrawable, localLayerParams, paramString1, paramString2, paramString3, paramInt1, paramInt2);
      ((FaceLayer.FaceAndTextItem)paramString1).a();
    }
    paramString1.U = new SegmentKeeper(paramSegmentKeeper);
    b(paramString1);
    paramString1.F.set(this.L);
    this.b.add(paramString1);
    super.u();
    if (paramString1.s) {
      this.r.add(paramString1);
    } else {
      a(paramString1, this.q);
    }
    a(paramString1, this.s);
    return true;
  }
  
  public boolean a(String paramString1, String paramString2, Drawable paramDrawable, FaceLayer.LayerParams paramLayerParams, String paramString3, boolean paramBoolean, String paramString4, int paramInt1, String paramString5, int paramInt2, int paramInt3)
  {
    if (paramDrawable == null)
    {
      SLog.e(a, "Face drawable is null.");
      return false;
    }
    if (paramLayerParams == null)
    {
      SLog.e(a, "ItemParams is null.");
      return false;
    }
    if (d())
    {
      SLog.e(a, "has max face count. add face failed.");
      paramString1 = this.p;
      if (paramString1 != null) {
        paramString1.a(40);
      }
      return false;
    }
    if ((paramInt1 == 1) || (paramInt1 == 3)) {
      paramDrawable.setCallback(this.z);
    }
    SLog.a(a, "addFace before, category : %s , name : %s , LayerParams : %s", paramString1, paramString2, paramLayerParams);
    FaceLayer.LayerParams localLayerParams = FaceLayer.LayerParams.a(paramLayerParams);
    int i3 = (int)(localLayerParams.f * localLayerParams.b);
    int i2 = (int)(localLayerParams.g * localLayerParams.b);
    int i1 = i2;
    if (this.B.height() < i2)
    {
      localLayerParams.b *= this.B.height() / i2;
      i1 = this.B.height();
    }
    float f1 = localLayerParams.a.x;
    float f2 = localLayerParams.a.y;
    localLayerParams.a.x = a(f1, i3, this.B.left, this.B.right);
    localLayerParams.a.y = a(f2, i1, this.B.top, this.B.bottom);
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("addFace after drawRect:");
    localStringBuilder.append(this.B);
    SLog.b(str, localStringBuilder.toString());
    SLog.a(a, "addFace after, category : %s , name : %s , LayerParams : %s", paramString1, paramString2, paramLayerParams);
    i1 = -1;
    if (TextUtils.isEmpty(localLayerParams.h))
    {
      SLog.b(a, "Create Normal FaceItem.");
      paramString2 = new FaceLayer.FaceItem(this, paramDrawable, localLayerParams, paramString1, paramString2, paramString3, paramInt1, paramInt3);
      paramString2.w = paramString5;
      paramString2.a(paramBoolean);
      if (!TextUtils.isEmpty(paramString4)) {
        if ((paramString2 instanceof FaceLayer.FaceAndTextItem))
        {
          paramString2.a(new TroopBarPOI("-1", "", paramString4, 0, "", 0, ""));
        }
        else
        {
          paramString2.u = new TroopBarPOI("-1", "", paramString4, 0, "", 0, "");
          paramString2.v = System.currentTimeMillis();
        }
      }
      if ((paramDrawable instanceof InfoStickerDrawable))
      {
        paramInt1 = ((InfoStickerDrawable)paramDrawable).f();
        paramString2.b(InformationFaceConstant.b(paramInt1));
        paramString1 = paramString2;
        break label618;
      }
      paramInt1 = i1;
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString5)) {
        break label618;
      }
    }
    try
    {
      paramInt1 = Integer.valueOf(paramString5.substring(paramString5.indexOf(":") + 1, paramString5.indexOf(","))).intValue();
      paramString2.b(InformationFaceConstant.b(paramInt1));
      paramString1 = paramString2;
      break label618;
      paramLayerParams = a;
      paramString4 = new StringBuilder();
      paramString4.append("Create FaceAndTextItem with text:");
      paramString4.append(localLayerParams.h);
      SLog.b(paramLayerParams, paramString4.toString());
      paramString1 = new FaceLayer.FaceAndTextItem(this, paramDrawable, localLayerParams, paramString1, paramString2, paramString3, paramInt1);
      ((FaceLayer.FaceAndTextItem)paramString1).a();
      paramInt1 = i1;
      label618:
      if (((paramDrawable instanceof FilmDigitInfoStickerDrawable)) || (12 == paramInt1)) {
        paramString1.C = 90.0F;
      }
      paramString1.x = paramInt2;
      paramString1.F.set(this.L);
      this.b.add(paramString1);
      super.u();
      if (paramString1.s) {
        this.r.add(paramString1);
      } else {
        a(paramString1, this.q);
      }
      a(paramString1, this.s);
      return true;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        paramInt1 = i1;
      }
    }
  }
  
  public void b()
  {
    this.b.clear();
    this.c = null;
    this.m.a();
    SLog.b(a, "clear over.");
  }
  
  public void b(Canvas paramCanvas)
  {
    a(paramCanvas, this.J, false);
  }
  
  public void b(FaceLayer.FaceItem paramFaceItem)
  {
    if (paramFaceItem.l != null)
    {
      if (!(paramFaceItem.l instanceof BitmapDrawable)) {
        return;
      }
      long l1 = System.currentTimeMillis();
      Object localObject = ((BitmapDrawable)paramFaceItem.l).getBitmap();
      int i3 = ((Bitmap)localObject).getWidth();
      int i4 = ((Bitmap)localObject).getHeight();
      int[] arrayOfInt = new int[i3 * i4];
      ((Bitmap)localObject).getPixels(arrayOfInt, 0, i3, 0, 0, i3, i4);
      localObject = new int[i3 * 2];
      int i1 = 0;
      while (i1 < i3)
      {
        i2 = 0;
        while (i2 < i4)
        {
          if ((arrayOfInt[(i2 * i3 + i1)] >> 24 & 0xFF) > 0)
          {
            localObject[(i1 * 2)] = i2;
            break;
          }
          i2 += 1;
        }
        i2 = i4 - 1;
        while (i2 >= 0)
        {
          if ((arrayOfInt[(i2 * i3 + i1)] >> 24 & 0xFF) > 0)
          {
            localObject[(i1 * 2 + 1)] = i2;
            break;
          }
          i2 -= 1;
        }
        i1 += 1;
      }
      int i2 = (int)paramFaceItem.G;
      paramFaceItem.P = new int[i2 * 2];
      float f1 = i3 / paramFaceItem.G;
      float f2 = paramFaceItem.H / i4;
      i1 = 0;
      while (i1 < i2)
      {
        i4 = (int)(i1 * f1);
        arrayOfInt = paramFaceItem.P;
        i3 = i1 * 2;
        i4 *= 2;
        arrayOfInt[i3] = ((int)(localObject[i4] * f2));
        arrayOfInt = paramFaceItem.P;
        i4 += 1;
        arrayOfInt[(i3 + 1)] = ((int)(localObject[i4] * f2));
        if (localObject[i4] > 0)
        {
          if (paramFaceItem.Q == -1) {
            paramFaceItem.Q = i1;
          }
          paramFaceItem.R = Math.max(i1, paramFaceItem.R);
        }
        i1 += 1;
      }
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, new Object[] { "computePixelScope cost: ", Long.valueOf(l2 - l1) });
      }
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    Object localObject = this.b;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = this.b.iterator();
      while (((Iterator)localObject).hasNext())
      {
        FaceLayer.FaceItem localFaceItem = (FaceLayer.FaceItem)((Iterator)localObject).next();
        if ((a(localFaceItem.n, paramString1)) && (a(localFaceItem.o, paramString2))) {
          a(localFaceItem);
        }
      }
    }
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int i1 = this.b.size() - 1;
    Object localObject;
    StringBuilder localStringBuilder;
    while (i1 >= 0)
    {
      localObject = (FaceLayer.FaceItem)this.b.get(i1);
      if (this.m.a((GestureHelper.ZoomItem)localObject, f1, f2, false))
      {
        if (QLog.isColorLevel())
        {
          localObject = a;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("accept inside x:");
          localStringBuilder.append(paramMotionEvent.getX());
          localStringBuilder.append(" y:");
          localStringBuilder.append(paramMotionEvent.getY());
          QLog.d((String)localObject, 2, localStringBuilder.toString());
        }
        return true;
      }
      i1 -= 1;
    }
    if (QLog.isColorLevel())
    {
      localObject = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("accept outside x:");
      localStringBuilder.append(paramMotionEvent.getX());
      localStringBuilder.append(" y:");
      localStringBuilder.append(paramMotionEvent.getY());
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    return false;
  }
  
  public boolean c()
  {
    List localList = this.b;
    return (localList == null) || (localList.isEmpty());
  }
  
  protected boolean d()
  {
    return g() >= 40;
  }
  
  public int g()
  {
    Object localObject = this.b;
    int i1;
    if (localObject == null) {
      i1 = 0;
    } else {
      i1 = ((List)localObject).size();
    }
    localObject = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FaceLayer, DoodleCount:");
    localStringBuilder.append(i1);
    SLog.b((String)localObject, localStringBuilder.toString());
    return i1;
  }
  
  public int[] h()
  {
    int[] arrayOfInt = new int[2];
    int[] tmp5_4 = arrayOfInt;
    tmp5_4[0] = 0;
    int[] tmp9_5 = tmp5_4;
    tmp9_5[1] = 0;
    tmp9_5;
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      if (((FaceLayer.FaceItem)localIterator.next() instanceof FaceLayer.FaceAndTextItem)) {
        arrayOfInt[1] += 1;
      } else {
        arrayOfInt[0] += 1;
      }
    }
    return arrayOfInt;
  }
  
  public void i()
  {
    List localList = this.b;
    if ((localList != null) && (!localList.isEmpty()))
    {
      localList = this.b;
      a((FaceLayer.FaceItem)localList.get(localList.size() - 1));
    }
  }
  
  public void j()
  {
    List localList = this.b;
    if ((localList != null) && (!localList.isEmpty()))
    {
      this.b.clear();
      this.r.clear();
      this.q.clear();
      this.s.clear();
    }
  }
  
  public Map<String, List<String>> k()
  {
    return this.s;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer
 * JD-Core Version:    0.7.0.1
 */