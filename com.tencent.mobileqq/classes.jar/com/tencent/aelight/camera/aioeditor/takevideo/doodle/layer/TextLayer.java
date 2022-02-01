package com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextBuilder;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem;
import com.tencent.aelight.camera.aioeditor.capture.text.TextParcelData;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.base.BaseLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleView;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.ShapeEffect;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.widget.StoryGuideLineView;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.DisplayUtil;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.GestureHelper;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@TargetApi(14)
public class TextLayer
  extends BaseLayer
{
  public static int a = 0;
  public static final String a = "TextLayer";
  public static final int b;
  private static String jdField_b_of_type_JavaLangString = "TextLayer";
  public static final int c;
  public static int d;
  public static int e;
  public static volatile int f;
  public Paint a;
  PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF();
  DynamicTextBuilder jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextBuilder = new DynamicTextBuilder();
  public TextLayer.LayerListener a;
  public TextLayer.TextItem a;
  public GestureHelper a;
  public ArrayList<TextLayer.TextItem> a;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  TextLayer.TextItem jdField_b_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer$TextItem;
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
    jdField_b_of_type_Int = com.tencent.aelight.camera.struct.editor.HorizontalStroke.a[1];
    c = Color.parseColor("#80000000");
    e = 270;
    f = 5;
  }
  
  public TextLayer(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    n();
  }
  
  private void a(TextLayer.TextItem paramTextItem)
  {
    boolean bool1 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper.a(paramTextItem, StoryGuideLineView.jdField_a_of_type_Int, true);
    boolean bool2 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper.a(paramTextItem, StoryGuideLineView.jdField_b_of_type_Int, false);
    boolean bool3 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper.b(paramTextItem, StoryGuideLineView.d, false);
    TextLayer.LayerListener localLayerListener = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer$LayerListener;
    if (localLayerListener != null) {
      localLayerListener.a(bool1, bool2, false, bool3, paramTextItem.g);
    }
    if (paramTextItem != null)
    {
      if (paramTextItem.f)
      {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.a(paramTextItem.g, paramTextItem.k, paramTextItem.l, paramTextItem.m, paramTextItem.jdField_a_of_type_AndroidGraphicsPointF, paramTextItem.h, 2);
        return;
      }
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.a(paramTextItem.g, paramTextItem.k, paramTextItem.l, paramTextItem.m, paramTextItem.jdField_a_of_type_AndroidGraphicsPointF, paramTextItem.h, 1);
    }
  }
  
  public static void c(boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      f -= 1;
      break label26;
      f += 1;
      label26:
      f = Math.min(f, 5);
      f = Math.max(f, 4);
      return;
    }
    finally {}
  }
  
  private boolean d()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Build.MANUFACTURER);
    ((StringBuilder)localObject).append("-");
    ((StringBuilder)localObject).append(Build.MODEL);
    localObject = ((StringBuilder)localObject).toString();
    boolean bool;
    if ((!((String)localObject).equalsIgnoreCase("vivo-vivo X6Plus D")) && (!((String)localObject).equalsIgnoreCase("motorola-Nexus 6"))) {
      bool = false;
    } else {
      bool = true;
    }
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isRubbish:");
    localStringBuilder.append(bool);
    localStringBuilder.append(" brand:");
    localStringBuilder.append((String)localObject);
    SLog.b(str, localStringBuilder.toString());
    return bool;
  }
  
  private void n()
  {
    this.k = AIOUtils.b(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.i = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext);
    this.h = 1;
    this.g = 1;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper = new GestureHelper();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper.a(6.0F);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper.b(0.2F);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper.a(true);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(2.0F);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    d = ViewConfiguration.get(this.jdField_a_of_type_AndroidContentContext).getScaledTouchSlop();
    if ((e == 270) && (d())) {
      e = 540;
    }
  }
  
  private void o()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.a(false, 0.0F, 0.0F, 0.0F, null, false, 1);
  }
  
  public DynamicTextItem a()
  {
    TextLayer.TextItem localTextItem = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer$TextItem;
    if (localTextItem != null) {
      return localTextItem.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem;
    }
    return null;
  }
  
  public DynamicTextItem a(int paramInt)
  {
    return a(null, null, paramInt);
  }
  
  public DynamicTextItem a(TextLayer.LayerParams paramLayerParams, SegmentKeeper paramSegmentKeeper, int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() < f)
    {
      if (paramLayerParams != null) {
        paramLayerParams = new TextLayer.TextItem(this, paramLayerParams);
      } else {
        paramLayerParams = new TextLayer.TextItem(this);
      }
      paramLayerParams.jdField_a_of_type_Int = paramInt;
      paramLayerParams.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper = new SegmentKeeper(paramSegmentKeeper);
      paramLayerParams.jdField_a_of_type_AndroidGraphicsMatrix.set(this.jdField_a_of_type_AndroidGraphicsMatrix);
      this.jdField_a_of_type_JavaUtilArrayList.add(paramLayerParams);
      paramSegmentKeeper = paramLayerParams.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem;
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer$TextItem = paramLayerParams;
      return paramSegmentKeeper;
    }
    return null;
  }
  
  public TextLayer.TextItem a()
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localArrayList != null) && (localArrayList.size() > f))
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer$TextItem);
      return this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer$TextItem;
    }
    return null;
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
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer$TextItem = null;
    SLog.b(jdField_a_of_type_JavaLangString, "clear over");
  }
  
  public void a(int paramInt)
  {
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setMode:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(",preMode:");
    localStringBuilder.append(this.h);
    SLog.b(str, localStringBuilder.toString());
    this.h = this.g;
    this.g = paramInt;
    if (paramInt == 4) {
      m();
    }
    super.k();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    PointF localPointF = this.jdField_a_of_type_AndroidGraphicsPointF;
    localPointF.x = (paramInt1 / 2);
    localPointF.y = (paramInt2 * 0.42F);
    jdField_a_of_type_Int = (int)(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.b() * 0.04F);
  }
  
  protected void a(Canvas paramCanvas)
  {
    int i1 = this.g;
    Object localObject;
    TextLayer.TextItem localTextItem;
    if (i1 == 6)
    {
      localObject = this.jdField_b_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer$TextItem;
      if (localObject != null) {
        ((TextLayer.TextItem)localObject).a(paramCanvas);
      }
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localTextItem = (TextLayer.TextItem)((Iterator)localObject).next();
        if ((this.jdField_b_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer$TextItem != null) && (localTextItem.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem != this.jdField_b_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer$TextItem.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem)) {
          localTextItem.a(paramCanvas);
        }
      }
    }
    if ((i1 != 4) && (i1 != 3))
    {
      if (i1 == 5) {
        localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      }
    }
    else {
      while (((Iterator)localObject).hasNext())
      {
        localTextItem = (TextLayer.TextItem)((Iterator)localObject).next();
        if (localTextItem.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem != this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer$TextItem.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem)
        {
          localTextItem.a(paramCanvas);
          continue;
          localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (((Iterator)localObject).hasNext()) {
            ((TextLayer.TextItem)((Iterator)localObject).next()).a(paramCanvas);
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
    while (localIterator.hasNext()) {
      ((TextLayer.TextItem)localIterator.next()).b(paramCanvas);
    }
    paramCanvas.restore();
  }
  
  public void a(Matrix paramMatrix)
  {
    super.a(paramMatrix);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((TextLayer.TextItem)localIterator.next()).jdField_a_of_type_AndroidGraphicsMatrix.set(paramMatrix);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    super.a(paramBundle);
    a(paramBundle.getParcelableArrayList("TextParcelDataList"), paramBundle.getBoolean("edit_type_photo"));
  }
  
  public void a(DynamicTextItem paramDynamicTextItem)
  {
    if ((paramDynamicTextItem != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      Object localObject = null;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        TextLayer.TextItem localTextItem = (TextLayer.TextItem)localIterator.next();
        if (paramDynamicTextItem.equals(localTextItem.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem)) {
          localObject = localTextItem;
        }
      }
      this.jdField_a_of_type_JavaUtilArrayList.remove(localObject);
    }
  }
  
  public void a(DynamicTextItem paramDynamicTextItem, ShapeEffect paramShapeEffect, RectF paramRectF)
  {
    b(paramDynamicTextItem);
    paramDynamicTextItem = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer$TextItem;
    if (paramDynamicTextItem != null)
    {
      paramDynamicTextItem.jdField_a_of_type_AndroidGraphicsPointF.x = (paramRectF.left + this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer$TextItem.n / 2.0F);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer$TextItem.jdField_a_of_type_AndroidGraphicsPointF.y = (paramRectF.top + this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer$TextItem.o / 2.0F);
    }
  }
  
  public void a(TextLayer.LayerListener paramLayerListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer$LayerListener = paramLayerListener;
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
        TextLayer.TextItem localTextItem = ((TextParcelData)paramArrayList.next()).a(this);
        localTextItem.jdField_a_of_type_AndroidGraphicsMatrix.set(this.jdField_a_of_type_AndroidGraphicsMatrix);
        this.jdField_a_of_type_JavaUtilArrayList.add(localTextItem);
      } while (this.jdField_a_of_type_JavaUtilArrayList.size() <= f);
    }
    k();
  }
  
  public void a(boolean paramBoolean)
  {
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setKeyboardState:");
    localStringBuilder.append(paramBoolean);
    SLog.b(str, localStringBuilder.toString());
    if (!paramBoolean) {
      a(4);
    }
    super.k();
  }
  
  public boolean a()
  {
    return this.g == 1;
  }
  
  public boolean a(long paramLong)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      if (((TextLayer.TextItem)localIterator.next()).jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.isSegmentChanged(paramLong)) {
        return false;
      }
    }
    return true;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if (b())
    {
      int i1 = (int)paramMotionEvent.getY();
      int i2 = Math.abs(i1 - this.l);
      int i3 = paramMotionEvent.getAction() & 0xFF;
      if (i3 != 0)
      {
        if (i3 != 1)
        {
          if (i3 != 2)
          {
            if (i3 == 5) {
              this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer$TextItem.c();
            }
          }
          else
          {
            if (this.g == 3) {
              this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer$TextItem.c();
            }
            if (i2 > d) {
              a(3);
            }
          }
        }
        else
        {
          TextLayer.TextItem localTextItem = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer$TextItem;
          if (localTextItem != null) {
            localTextItem.c();
          }
          a(this, false);
          if (i2 < d) {
            d();
          } else if (this.g == 3) {
            a(4);
          }
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer$TextItem);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer$TextItem.b();
        this.l = i1;
      }
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper.a(paramMotionEvent, false);
      paramMotionEvent = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer$TextItem;
      if (paramMotionEvent == null)
      {
        o();
        return true;
      }
      a(paramMotionEvent);
      return true;
    }
    return false;
  }
  
  public int b()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void b(int paramInt)
  {
    if (paramInt < 0)
    {
      str = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("setTextTop:");
      localStringBuilder.append(paramInt);
      SLog.e(str, localStringBuilder.toString());
      return;
    }
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setTextTop:");
    localStringBuilder.append(paramInt);
    SLog.b(str, localStringBuilder.toString());
    this.m = paramInt;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 0) && (paramInt2 >= 0))
    {
      str = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("setTextTop:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("y=");
      localStringBuilder.append(paramInt2);
      SLog.b(str, localStringBuilder.toString());
      this.n = paramInt1;
      this.o = paramInt2;
      return;
    }
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setTextOffset x:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("y=");
    localStringBuilder.append(paramInt2);
    SLog.e(str, localStringBuilder.toString());
  }
  
  public void b(Canvas paramCanvas)
  {
    a(paramCanvas, this.jdField_a_of_type_Float, false);
  }
  
  public void b(DynamicTextItem paramDynamicTextItem)
  {
    TextLayer.TextItem localTextItem = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer$TextItem;
    if (localTextItem != null)
    {
      localTextItem.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem = paramDynamicTextItem;
      localTextItem.n = paramDynamicTextItem.a();
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer$TextItem.o = paramDynamicTextItem.b();
    }
    localTextItem = this.jdField_b_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer$TextItem;
    if (localTextItem != null)
    {
      localTextItem.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem = paramDynamicTextItem;
      paramDynamicTextItem = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer$TextItem;
      if (paramDynamicTextItem != null)
      {
        localTextItem.j = paramDynamicTextItem.j;
        this.jdField_b_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer$TextItem.b = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer$TextItem.j;
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    a(5);
    if (paramBoolean) {
      e();
    }
  }
  
  public boolean b()
  {
    int i1 = this.g;
    return (i1 == 4) || (i1 == 3);
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    boolean bool2 = b();
    boolean bool1 = true;
    if (bool2)
    {
      float f1 = paramMotionEvent.getX(0);
      float f2 = paramMotionEvent.getY(0);
      int i1 = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
      while (i1 >= 0)
      {
        paramMotionEvent = (TextLayer.TextItem)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
        if (((paramMotionEvent == null) || (paramMotionEvent.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper == null) || (!paramMotionEvent.a()) || (paramMotionEvent.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.isCurrentIn())) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper.a(paramMotionEvent, f1, f2, false)))
        {
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer$TextItem = paramMotionEvent;
          break label120;
        }
        i1 -= 1;
      }
    }
    bool1 = false;
    label120:
    if (bool1)
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer$TextItem);
      this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer$TextItem);
    }
    return bool1;
  }
  
  public boolean c()
  {
    return (this.n > 0) && (this.o > 0);
  }
  
  public void d()
  {
    TextLayer.LayerListener localLayerListener = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer$LayerListener;
    if (localLayerListener != null)
    {
      TextLayer.TextItem localTextItem = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer$TextItem;
      if (localTextItem != null)
      {
        if (localLayerListener.a(localTextItem))
        {
          this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer$TextItem);
          return;
        }
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer$LayerListener.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer$TextItem.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem);
      }
    }
  }
  
  public void e()
  {
    Object localObject;
    if (!a())
    {
      a(6);
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer$TextItem;
      if (localObject != null)
      {
        this.jdField_b_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer$TextItem = new TextLayer.TextItem(this, (TextLayer.TextItem)localObject);
        this.jdField_b_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer$TextItem.a();
        TextLayer.TextItem.a(this.jdField_b_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer$TextItem);
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer$LayerListener;
      if (localObject != null) {
        ((TextLayer.LayerListener)localObject).a(1.0F);
      }
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      localArrayList.remove(localArrayList.size() - 1);
    }
  }
  
  public void g()
  {
    Object localObject1 = new ArrayList();
    Object localObject2;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        TextLayer.TextItem localTextItem = (TextLayer.TextItem)((Iterator)localObject2).next();
        if ((localTextItem.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem != null) && (localTextItem.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem.e())) {
          ((List)localObject1).add(localTextItem);
        }
      }
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (TextLayer.TextItem)((Iterator)localObject1).next();
      this.jdField_a_of_type_JavaUtilArrayList.remove(localObject2);
    }
    localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer$TextItem;
    if ((localObject1 != null) && (((TextLayer.TextItem)localObject1).jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem != null) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer$TextItem.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem.e())) {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer$TextItem = null;
    }
  }
  
  public void h()
  {
    if (this.jdField_b_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer$TextItem != null)
    {
      a(6);
      TextLayer.TextItem.b(this.jdField_b_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer$TextItem);
    }
  }
  
  public void i()
  {
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer$TextItem;
    if (localObject != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(localObject);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer$TextItem.c();
      localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("delete ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer$TextItem);
      SLog.b((String)localObject, localStringBuilder.toString());
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer$TextItem = null;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
    {
      this.g = 1;
      this.h = 1;
    }
  }
  
  public void j()
  {
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer$TextItem;
    if ((localObject != null) && (((TextLayer.TextItem)localObject).jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem != null)) {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer$TextItem.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem.a(-1, false);
    }
    localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        TextLayer.TextItem localTextItem = (TextLayer.TextItem)((Iterator)localObject).next();
        if (localTextItem.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem != null) {
          localTextItem.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem.a(-1, false);
        }
      }
    }
    k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextLayer
 * JD-Core Version:    0.7.0.1
 */