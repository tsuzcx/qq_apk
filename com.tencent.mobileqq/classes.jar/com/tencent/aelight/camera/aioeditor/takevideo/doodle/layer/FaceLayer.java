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
  public int a;
  public Paint a;
  public Drawable a;
  public TextPaint a;
  public FaceLayer.FaceItem a;
  public FaceLayer.LayerEventListener a;
  public GestureHelper a;
  public List<FaceLayer.FaceItem> a;
  public Map<String, List<String>> a;
  public boolean a;
  public Paint b;
  public List<FaceLayer.FaceItem> b;
  public Map<String, List<String>> b;
  public Paint c;
  public Paint d;
  public Paint e;
  public Paint f;
  public Paint g;
  
  public FaceLayer(DoodleView paramDoodleView)
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
  
  private void a(MotionEvent paramMotionEvent)
  {
    if (a(paramMotionEvent.getX(0), paramMotionEvent.getY(0)))
    {
      this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerFaceLayer$FaceItem);
      this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerFaceLayer$FaceItem);
    }
  }
  
  private void a(FaceLayer.FaceItem paramFaceItem, Canvas paramCanvas)
  {
    if (paramFaceItem == null) {
      return;
    }
    paramCanvas.save();
    paramCanvas.concat(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper.a(paramFaceItem));
    paramFaceItem.a(paramCanvas, true);
    paramCanvas.restore();
  }
  
  private void a(FaceLayer.FaceItem paramFaceItem, Map<String, List<String>> paramMap)
  {
    List localList = (List)paramMap.get(paramFaceItem.d);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      paramMap.put(paramFaceItem.d, localObject);
    }
    ((List)localObject).add(paramFaceItem.e);
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    int i = this.jdField_a_of_type_JavaUtilList.size() - 1;
    while (i >= 0)
    {
      FaceLayer.FaceItem localFaceItem = (FaceLayer.FaceItem)this.jdField_a_of_type_JavaUtilList.get(i);
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper.a(localFaceItem, paramFloat1, paramFloat2, false))
      {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerFaceLayer$FaceItem = localFaceItem;
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
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerFaceLayer$FaceItem = null;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper.a();
    super.k();
    super.d(false);
  }
  
  private void b(FaceLayer.FaceItem paramFaceItem, Map<String, List<String>> paramMap)
  {
    List localList = (List)paramMap.get(paramFaceItem.d);
    if (localList != null)
    {
      localList.remove(paramFaceItem.e);
      if (localList.isEmpty()) {
        paramMap.remove(paramFaceItem.d);
      }
    }
  }
  
  private void c(FaceLayer.FaceItem paramFaceItem)
  {
    boolean bool1 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper.a(paramFaceItem, StoryGuideLineView.jdField_a_of_type_Int, true);
    boolean bool2 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper.a(paramFaceItem, StoryGuideLineView.b, false);
    boolean bool3 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper.b(paramFaceItem, StoryGuideLineView.d, false);
    FaceLayer.LayerEventListener localLayerEventListener = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerFaceLayer$LayerEventListener;
    if (localLayerEventListener != null) {
      localLayerEventListener.a(bool1, bool2, false, bool3, paramFaceItem.jdField_g_of_type_Boolean);
    }
    if (paramFaceItem != null)
    {
      if (paramFaceItem.f)
      {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.a(paramFaceItem.jdField_g_of_type_Boolean, paramFaceItem.jdField_k_of_type_Float, paramFaceItem.jdField_l_of_type_Float, paramFaceItem.m, paramFaceItem.jdField_a_of_type_AndroidGraphicsPointF, paramFaceItem.jdField_h_of_type_Boolean, 2);
        return;
      }
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.a(paramFaceItem.jdField_g_of_type_Boolean, paramFaceItem.jdField_k_of_type_Float, paramFaceItem.jdField_l_of_type_Float, paramFaceItem.m, paramFaceItem.jdField_a_of_type_AndroidGraphicsPointF, paramFaceItem.jdField_h_of_type_Boolean, 1);
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846976);
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
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper = new GestureHelper();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper.a(true);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper.a(18.0F);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper.b(0.2F);
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
    FaceLayer.LayerEventListener localLayerEventListener = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerFaceLayer$LayerEventListener;
    if (localLayerEventListener != null)
    {
      FaceLayer.FaceItem localFaceItem = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerFaceLayer$FaceItem;
      if ((localFaceItem != null) && (localLayerEventListener.a(localFaceItem))) {
        this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerFaceLayer$FaceItem);
      }
    }
  }
  
  private void g()
  {
    FaceLayer.FaceItem localFaceItem = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerFaceLayer$FaceItem;
    if (localFaceItem != null) {
      localFaceItem.c();
    }
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.a(false, 0.0F, 0.0F, 0.0F, null, false, 1);
  }
  
  public Rect a(Rect paramRect)
  {
    paramRect.setEmpty();
    FaceLayer.FaceItem localFaceItem = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerFaceLayer$FaceItem;
    if (localFaceItem != null)
    {
      int i = (int)(localFaceItem.n * this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerFaceLayer$FaceItem.j);
      paramRect.set(0, 0, i, i);
    }
    return paramRect;
  }
  
  public GestureHelper.ZoomItem a(GestureHelper.ZoomItem paramZoomItem, String paramString1, String paramString2, Drawable paramDrawable, FaceLayer.LayerParams paramLayerParams, String paramString3, int paramInt1, boolean paramBoolean, String paramString4, String paramString5, int paramInt2)
  {
    if (paramDrawable == null)
    {
      SLog.e(jdField_a_of_type_JavaLangString, "Face drawable is null.");
      return null;
    }
    if (paramLayerParams == null)
    {
      SLog.e(jdField_a_of_type_JavaLangString, "ItemParams is null.");
      return null;
    }
    FaceLayer.LayerParams localLayerParams = FaceLayer.LayerParams.a(paramZoomItem, paramLayerParams);
    if ((paramZoomItem instanceof FaceLayer.FaceItem))
    {
      paramZoomItem = (FaceLayer.FaceItem)paramZoomItem;
      if (paramZoomItem.b) {
        this.jdField_b_of_type_JavaUtilList.remove(paramZoomItem);
      } else {
        b(paramZoomItem, this.jdField_a_of_type_JavaUtilMap);
      }
      b(paramZoomItem, this.jdField_b_of_type_JavaUtilMap);
    }
    if (TextUtils.isEmpty(paramLayerParams.jdField_a_of_type_JavaLangString))
    {
      SLog.b(jdField_a_of_type_JavaLangString, "Create Normal FaceItem.");
      paramString1 = new FaceLayer.FaceItem(this, paramDrawable, localLayerParams, paramString1, paramString2, paramString3, paramInt1, paramInt2);
      paramString1.a(paramBoolean);
      if ((paramDrawable instanceof InfoStickerDrawable)) {
        paramString1.b(InformationFaceConstant.b(((InfoStickerDrawable)paramDrawable).a()));
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
      paramString1.jdField_a_of_type_ComTencentMobileqqTribeDataTroopBarPOI = new TroopBarPOI("-1", "", paramString4, 0, "", 0, "");
      paramString1.jdField_a_of_type_Long = System.currentTimeMillis();
      paramZoomItem = paramString1;
      break label328;
      paramZoomItem = jdField_a_of_type_JavaLangString;
      paramLayerParams = new StringBuilder();
      paramLayerParams.append("Create FaceAndTextItem with text:");
      paramLayerParams.append(localLayerParams.jdField_a_of_type_JavaLangString);
      SLog.b(paramZoomItem, paramLayerParams.toString());
      paramZoomItem = new FaceLayer.FaceAndTextItem(this, paramDrawable, localLayerParams, paramString1, paramString2, paramString3, paramInt1, paramInt2);
    }
    label328:
    paramZoomItem.b = paramBoolean;
    if (!TextUtils.isEmpty(paramString5)) {
      paramZoomItem.jdField_g_of_type_JavaLangString = paramString5;
    }
    if (paramZoomItem.b) {
      this.jdField_b_of_type_JavaUtilList.add(paramZoomItem);
    } else {
      b(paramZoomItem, this.jdField_a_of_type_JavaUtilMap);
    }
    b(paramZoomItem, this.jdField_b_of_type_JavaUtilMap);
    return paramZoomItem;
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
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerFaceLayer$FaceItem = null;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper.a();
    SLog.b(jdField_a_of_type_JavaLangString, "clear over.");
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        FaceLayer.FaceItem localFaceItem = (FaceLayer.FaceItem)((Iterator)localObject).next();
        paramInt1 = (int)(localFaceItem.n * localFaceItem.j);
        paramInt2 = (int)(localFaceItem.o * localFaceItem.j);
        localFaceItem.jdField_a_of_type_AndroidGraphicsPointF.x = a(localFaceItem.jdField_a_of_type_AndroidGraphicsPointF.x, paramInt1, this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.right);
        localFaceItem.jdField_a_of_type_AndroidGraphicsPointF.y = a(localFaceItem.jdField_a_of_type_AndroidGraphicsPointF.y, paramInt2, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.bottom);
      }
      return;
    }
    SLog.b(jdField_a_of_type_JavaLangString, "mFaceItems = null or size<=0");
  }
  
  protected void a(Canvas paramCanvas)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      a((FaceLayer.FaceItem)localIterator.next(), paramCanvas);
    }
  }
  
  public void a(Canvas paramCanvas, float paramFloat, boolean paramBoolean)
  {
    paramCanvas.save();
    paramCanvas.scale(paramFloat, paramFloat);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      FaceLayer.FaceItem localFaceItem = (FaceLayer.FaceItem)localIterator.next();
      if (localFaceItem.jdField_h_of_type_Int == 0)
      {
        paramCanvas.save();
        paramCanvas.concat(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper.a(localFaceItem, false));
        localFaceItem.a(paramCanvas, false);
        paramCanvas.restore();
      }
    }
    paramCanvas.restore();
  }
  
  public void a(Matrix paramMatrix)
  {
    super.a(paramMatrix);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((FaceLayer.FaceItem)localIterator.next()).jdField_a_of_type_AndroidGraphicsMatrix.set(paramMatrix);
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
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (!localList.isEmpty()) && (this.jdField_a_of_type_JavaUtilList.remove(paramFaceItem)))
    {
      if (paramFaceItem.b)
      {
        DoodleLayout.a("delete_poi");
        VideoEditReport.a("0X80076D2");
        VideoEditReport.b("0X80075E7");
        this.jdField_b_of_type_JavaUtilList.remove(paramFaceItem);
      }
      else
      {
        DoodleLayout.a("delete_oneface");
        VideoEditReport.a("0X80076CB");
        VideoEditReport.b("0X80075E0");
        b(paramFaceItem, this.jdField_a_of_type_JavaUtilMap);
      }
      b(paramFaceItem, this.jdField_b_of_type_JavaUtilMap);
    }
  }
  
  public void a(FaceLayer.FaceItem paramFaceItem, TroopBarPOI paramTroopBarPOI)
  {
    if (paramFaceItem != null)
    {
      paramFaceItem.a(paramTroopBarPOI);
      paramFaceItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setCallback(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.a.a);
      k();
    }
  }
  
  public void a(FaceLayer.LayerEventListener paramLayerEventListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerFaceLayer$LayerEventListener = paramLayerEventListener;
  }
  
  public void a(String paramString1, String paramString2)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        FaceLayer.FaceItem localFaceItem = (FaceLayer.FaceItem)((Iterator)localObject).next();
        if ((a(localFaceItem.d, paramString1)) && (a(localFaceItem.e, paramString2))) {
          a(localFaceItem);
        }
      }
    }
  }
  
  public void a(ArrayList<PasterParcelData> paramArrayList, boolean paramBoolean, JSONArray paramJSONArray)
  {
    if ((paramArrayList != null) && (!paramArrayList.isEmpty())) {
      ThreadManager.post(new FaceLayer.1(this, paramArrayList), 8, null, false);
    }
  }
  
  public boolean a()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    return (localList == null) || (localList.isEmpty());
  }
  
  public boolean a(long paramLong)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (((FaceLayer.FaceItem)localIterator.next()).jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.isSegmentChanged(paramLong)) {
        return false;
      }
    }
    return true;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getY();
    int j = Math.abs(i - this.jdField_a_of_type_Int);
    int k = paramMotionEvent.getAction() & 0xFF;
    if (k != 0)
    {
      if (k != 1)
      {
        if (k != 2)
        {
          if (k == 5) {
            g();
          }
        }
        else if (j > 5)
        {
          this.jdField_a_of_type_Boolean = true;
          g();
        }
      }
      else
      {
        g();
        if (!this.jdField_a_of_type_Boolean) {
          f();
        }
        b(paramMotionEvent);
      }
    }
    else
    {
      this.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_Boolean = false;
      a(paramMotionEvent);
      FaceLayer.FaceItem localFaceItem = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerFaceLayer$FaceItem;
      if (localFaceItem != null) {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper.a(localFaceItem);
      }
      localFaceItem = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerFaceLayer$FaceItem;
      if (localFaceItem != null) {
        localFaceItem.b();
      }
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper.a(paramMotionEvent, false);
    paramMotionEvent = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerFaceLayer$FaceItem;
    if (paramMotionEvent != null)
    {
      c(paramMotionEvent);
      return true;
    }
    h();
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
      SLog.e(jdField_a_of_type_JavaLangString, "Face drawable is null.");
      return false;
    }
    if (paramLayerParams == null)
    {
      SLog.e(jdField_a_of_type_JavaLangString, "ItemParams is null.");
      return false;
    }
    if (b())
    {
      SLog.e(jdField_a_of_type_JavaLangString, "has max face count. add face failed.");
      paramString1 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerFaceLayer$LayerEventListener;
      if (paramString1 != null) {
        paramString1.a(40);
      }
      return false;
    }
    if ((paramInt1 == 1) || (paramInt1 == 3)) {
      paramDrawable.setCallback(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView);
    }
    SLog.a(jdField_a_of_type_JavaLangString, "addFace before, category : %s , name : %s , LayerParams : %s", paramString1, paramString2, paramLayerParams);
    FaceLayer.LayerParams localLayerParams = FaceLayer.LayerParams.a(paramLayerParams);
    int k = (int)(localLayerParams.jdField_a_of_type_Int * localLayerParams.jdField_a_of_type_Float);
    int j = (int)(localLayerParams.b * localLayerParams.jdField_a_of_type_Float);
    int i = j;
    if (this.jdField_a_of_type_AndroidGraphicsRect.height() < j)
    {
      localLayerParams.jdField_a_of_type_Float *= this.jdField_a_of_type_AndroidGraphicsRect.height() / j;
      i = this.jdField_a_of_type_AndroidGraphicsRect.height();
    }
    float f1 = localLayerParams.jdField_a_of_type_AndroidGraphicsPointF.x;
    float f2 = localLayerParams.jdField_a_of_type_AndroidGraphicsPointF.y;
    localLayerParams.jdField_a_of_type_AndroidGraphicsPointF.x = a(f1, k, this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.right);
    localLayerParams.jdField_a_of_type_AndroidGraphicsPointF.y = a(f2, i, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.bottom);
    Object localObject = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("addFace after drawRect:");
    localStringBuilder.append(this.jdField_a_of_type_AndroidGraphicsRect);
    SLog.b((String)localObject, localStringBuilder.toString());
    SLog.a(jdField_a_of_type_JavaLangString, "addFace after, category : %s , name : %s , LayerParams : %s", paramString1, paramString2, paramLayerParams);
    if (TextUtils.isEmpty(localLayerParams.jdField_a_of_type_JavaLangString))
    {
      SLog.b(jdField_a_of_type_JavaLangString, "Create Normal FaceItem.");
      paramString2 = new FaceLayer.FaceItem(this, paramDrawable, localLayerParams, paramString1, paramString2, paramString3, paramInt1, paramInt2);
      paramString2.a(paramBoolean);
      paramString1 = paramString2;
      if ((paramDrawable instanceof InfoStickerDrawable))
      {
        paramString2.b(InformationFaceConstant.b(((InfoStickerDrawable)paramDrawable).a()));
        paramString1 = paramString2;
      }
    }
    else
    {
      paramLayerParams = jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Create FaceAndTextItem with text:");
      ((StringBuilder)localObject).append(localLayerParams.jdField_a_of_type_JavaLangString);
      SLog.b(paramLayerParams, ((StringBuilder)localObject).toString());
      paramString1 = new FaceLayer.FaceAndTextItem(this, paramDrawable, localLayerParams, paramString1, paramString2, paramString3, paramInt1, paramInt2);
      ((FaceLayer.FaceAndTextItem)paramString1).a();
    }
    paramString1.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper = new SegmentKeeper(paramSegmentKeeper);
    b(paramString1);
    paramString1.jdField_a_of_type_AndroidGraphicsMatrix.set(this.jdField_a_of_type_AndroidGraphicsMatrix);
    this.jdField_a_of_type_JavaUtilList.add(paramString1);
    super.k();
    if (paramString1.b) {
      this.jdField_b_of_type_JavaUtilList.add(paramString1);
    } else {
      a(paramString1, this.jdField_a_of_type_JavaUtilMap);
    }
    a(paramString1, this.jdField_b_of_type_JavaUtilMap);
    return true;
  }
  
  public boolean a(String paramString1, String paramString2, Drawable paramDrawable, FaceLayer.LayerParams paramLayerParams, String paramString3, boolean paramBoolean, String paramString4, int paramInt1, String paramString5, int paramInt2, int paramInt3)
  {
    if (paramDrawable == null)
    {
      SLog.e(jdField_a_of_type_JavaLangString, "Face drawable is null.");
      return false;
    }
    if (paramLayerParams == null)
    {
      SLog.e(jdField_a_of_type_JavaLangString, "ItemParams is null.");
      return false;
    }
    if (b())
    {
      SLog.e(jdField_a_of_type_JavaLangString, "has max face count. add face failed.");
      paramString1 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerFaceLayer$LayerEventListener;
      if (paramString1 != null) {
        paramString1.a(40);
      }
      return false;
    }
    if ((paramInt1 == 1) || (paramInt1 == 3)) {
      paramDrawable.setCallback(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView);
    }
    SLog.a(jdField_a_of_type_JavaLangString, "addFace before, category : %s , name : %s , LayerParams : %s", paramString1, paramString2, paramLayerParams);
    FaceLayer.LayerParams localLayerParams = FaceLayer.LayerParams.a(paramLayerParams);
    int k = (int)(localLayerParams.jdField_a_of_type_Int * localLayerParams.jdField_a_of_type_Float);
    int j = (int)(localLayerParams.b * localLayerParams.jdField_a_of_type_Float);
    int i = j;
    if (this.jdField_a_of_type_AndroidGraphicsRect.height() < j)
    {
      localLayerParams.jdField_a_of_type_Float *= this.jdField_a_of_type_AndroidGraphicsRect.height() / j;
      i = this.jdField_a_of_type_AndroidGraphicsRect.height();
    }
    float f1 = localLayerParams.jdField_a_of_type_AndroidGraphicsPointF.x;
    float f2 = localLayerParams.jdField_a_of_type_AndroidGraphicsPointF.y;
    localLayerParams.jdField_a_of_type_AndroidGraphicsPointF.x = a(f1, k, this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.right);
    localLayerParams.jdField_a_of_type_AndroidGraphicsPointF.y = a(f2, i, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.bottom);
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("addFace after drawRect:");
    localStringBuilder.append(this.jdField_a_of_type_AndroidGraphicsRect);
    SLog.b(str, localStringBuilder.toString());
    SLog.a(jdField_a_of_type_JavaLangString, "addFace after, category : %s , name : %s , LayerParams : %s", paramString1, paramString2, paramLayerParams);
    i = -1;
    if (TextUtils.isEmpty(localLayerParams.jdField_a_of_type_JavaLangString))
    {
      SLog.b(jdField_a_of_type_JavaLangString, "Create Normal FaceItem.");
      paramString2 = new FaceLayer.FaceItem(this, paramDrawable, localLayerParams, paramString1, paramString2, paramString3, paramInt1, paramInt3);
      paramString2.jdField_g_of_type_JavaLangString = paramString5;
      paramString2.a(paramBoolean);
      if (!TextUtils.isEmpty(paramString4)) {
        if ((paramString2 instanceof FaceLayer.FaceAndTextItem))
        {
          paramString2.a(new TroopBarPOI("-1", "", paramString4, 0, "", 0, ""));
        }
        else
        {
          paramString2.jdField_a_of_type_ComTencentMobileqqTribeDataTroopBarPOI = new TroopBarPOI("-1", "", paramString4, 0, "", 0, "");
          paramString2.jdField_a_of_type_Long = System.currentTimeMillis();
        }
      }
      if ((paramDrawable instanceof InfoStickerDrawable))
      {
        paramInt1 = ((InfoStickerDrawable)paramDrawable).a();
        paramString2.b(InformationFaceConstant.b(paramInt1));
        paramString1 = paramString2;
        break label618;
      }
      paramInt1 = i;
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
      paramLayerParams = jdField_a_of_type_JavaLangString;
      paramString4 = new StringBuilder();
      paramString4.append("Create FaceAndTextItem with text:");
      paramString4.append(localLayerParams.jdField_a_of_type_JavaLangString);
      SLog.b(paramLayerParams, paramString4.toString());
      paramString1 = new FaceLayer.FaceAndTextItem(this, paramDrawable, localLayerParams, paramString1, paramString2, paramString3, paramInt1);
      ((FaceLayer.FaceAndTextItem)paramString1).a();
      paramInt1 = i;
      label618:
      if (((paramDrawable instanceof FilmDigitInfoStickerDrawable)) || (12 == paramInt1)) {
        paramString1.jdField_k_of_type_Float = 90.0F;
      }
      paramString1.jdField_g_of_type_Int = paramInt2;
      paramString1.jdField_a_of_type_AndroidGraphicsMatrix.set(this.jdField_a_of_type_AndroidGraphicsMatrix);
      this.jdField_a_of_type_JavaUtilList.add(paramString1);
      super.k();
      if (paramString1.b) {
        this.jdField_b_of_type_JavaUtilList.add(paramString1);
      } else {
        a(paramString1, this.jdField_a_of_type_JavaUtilMap);
      }
      a(paramString1, this.jdField_b_of_type_JavaUtilMap);
      return true;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        paramInt1 = i;
      }
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
      if (((FaceLayer.FaceItem)localIterator.next() instanceof FaceLayer.FaceAndTextItem)) {
        arrayOfInt[1] += 1;
      } else {
        arrayOfInt[0] += 1;
      }
    }
    return arrayOfInt;
  }
  
  public int b()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = ((List)localObject).size();
    }
    localObject = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FaceLayer, DoodleCount:");
    localStringBuilder.append(i);
    SLog.b((String)localObject, localStringBuilder.toString());
    return i;
  }
  
  public void b(Canvas paramCanvas)
  {
    a(paramCanvas, this.jdField_a_of_type_Float, false);
  }
  
  public void b(FaceLayer.FaceItem paramFaceItem)
  {
    if (paramFaceItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      if (!(paramFaceItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof BitmapDrawable)) {
        return;
      }
      long l1 = System.currentTimeMillis();
      Object localObject = ((BitmapDrawable)paramFaceItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable).getBitmap();
      int k = ((Bitmap)localObject).getWidth();
      int m = ((Bitmap)localObject).getHeight();
      int[] arrayOfInt = new int[k * m];
      ((Bitmap)localObject).getPixels(arrayOfInt, 0, k, 0, 0, k, m);
      localObject = new int[k * 2];
      int i = 0;
      while (i < k)
      {
        j = 0;
        while (j < m)
        {
          if ((arrayOfInt[(j * k + i)] >> 24 & 0xFF) > 0)
          {
            localObject[(i * 2)] = j;
            break;
          }
          j += 1;
        }
        j = m - 1;
        while (j >= 0)
        {
          if ((arrayOfInt[(j * k + i)] >> 24 & 0xFF) > 0)
          {
            localObject[(i * 2 + 1)] = j;
            break;
          }
          j -= 1;
        }
        i += 1;
      }
      int j = (int)paramFaceItem.n;
      paramFaceItem.jdField_a_of_type_ArrayOfInt = new int[j * 2];
      float f1 = k / paramFaceItem.n;
      float f2 = paramFaceItem.o / m;
      i = 0;
      while (i < j)
      {
        m = (int)(i * f1);
        arrayOfInt = paramFaceItem.jdField_a_of_type_ArrayOfInt;
        k = i * 2;
        m *= 2;
        arrayOfInt[k] = ((int)(localObject[m] * f2));
        arrayOfInt = paramFaceItem.jdField_a_of_type_ArrayOfInt;
        m += 1;
        arrayOfInt[(k + 1)] = ((int)(localObject[m] * f2));
        if (localObject[m] > 0)
        {
          if (paramFaceItem.jdField_k_of_type_Int == -1) {
            paramFaceItem.jdField_k_of_type_Int = i;
          }
          paramFaceItem.jdField_l_of_type_Int = Math.max(i, paramFaceItem.jdField_l_of_type_Int);
        }
        i += 1;
      }
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "computePixelScope cost: ", Long.valueOf(l2 - l1) });
      }
    }
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
    Object localObject;
    StringBuilder localStringBuilder;
    while (i >= 0)
    {
      localObject = (FaceLayer.FaceItem)this.jdField_a_of_type_JavaUtilList.get(i);
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper.a((GestureHelper.ZoomItem)localObject, f1, f2, false))
      {
        if (QLog.isColorLevel())
        {
          localObject = jdField_a_of_type_JavaLangString;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("accept inside x:");
          localStringBuilder.append(paramMotionEvent.getX());
          localStringBuilder.append(" y:");
          localStringBuilder.append(paramMotionEvent.getY());
          QLog.d((String)localObject, 2, localStringBuilder.toString());
        }
        return true;
      }
      i -= 1;
    }
    if (QLog.isColorLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("accept outside x:");
      localStringBuilder.append(paramMotionEvent.getX());
      localStringBuilder.append(" y:");
      localStringBuilder.append(paramMotionEvent.getY());
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    return false;
  }
  
  public void d()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (!localList.isEmpty()))
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_b_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilMap.clear();
      this.jdField_b_of_type_JavaUtilMap.clear();
    }
  }
  
  public void x_()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (!localList.isEmpty()))
    {
      localList = this.jdField_a_of_type_JavaUtilList;
      a((FaceLayer.FaceItem)localList.get(localList.size() - 1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer
 * JD-Core Version:    0.7.0.1
 */