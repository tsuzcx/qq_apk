package com.tencent.aelight.camera.aioeditor.doodle.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.view.animation.LinearInterpolator;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class LunaInfoStickerDrawable
  extends InfoStickerDrawable
{
  private float jdField_a_of_type_Float = 0.0F;
  int jdField_a_of_type_Int = 0;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private PorterDuffXfermode jdField_a_of_type_AndroidGraphicsPorterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
  private Rect jdField_a_of_type_AndroidGraphicsRect = null;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = null;
  private Typeface jdField_a_of_type_AndroidGraphicsTypeface = null;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
  PerLineFontBitmapsInfo jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiWidgetPerLineFontBitmapsInfo;
  int jdField_b_of_type_Int = 0;
  private Paint jdField_b_of_type_AndroidGraphicsPaint = new Paint();
  private PorterDuffXfermode jdField_b_of_type_AndroidGraphicsPorterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
  private Rect jdField_b_of_type_AndroidGraphicsRect = null;
  private RectF jdField_b_of_type_AndroidGraphicsRectF = null;
  PerLineFontBitmapsInfo jdField_b_of_type_ComTencentAelightCameraAioeditorDoodleUiWidgetPerLineFontBitmapsInfo;
  private String jdField_b_of_type_JavaLangString = HardCodeUtil.a(2064515397);
  private int jdField_c_of_type_Int;
  private Bitmap jdField_c_of_type_AndroidGraphicsBitmap;
  private Rect jdField_c_of_type_AndroidGraphicsRect = null;
  private String jdField_c_of_type_JavaLangString = HardCodeUtil.a(2064515400);
  private int jdField_d_of_type_Int;
  private Rect jdField_d_of_type_AndroidGraphicsRect = null;
  private String jdField_d_of_type_JavaLangString = HardCodeUtil.a(2064515398);
  private int jdField_e_of_type_Int = 0;
  private String jdField_e_of_type_JavaLangString = HardCodeUtil.a(2064515399);
  private String f;
  private String g = null;
  private int jdField_h_of_type_Int = 0;
  private String jdField_h_of_type_JavaLangString = null;
  private int i = 0;
  
  public LunaInfoStickerDrawable(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    this.jdField_f_of_type_JavaLangString = null;
    a(paramString);
    b();
    c();
  }
  
  public static String a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", paramInt);
      localJSONObject.put("first_line", paramString1);
      localJSONObject.put("second_line", paramString2);
      localJSONObject.put("third_line", paramString3);
      localJSONObject.put("fourth_line", paramString4);
      localJSONObject.put("font_file_name", paramString5);
      localJSONObject.put("out_side_border", paramString6);
      localJSONObject.put("in_side_border", paramString7);
      paramString1 = localJSONObject.toString();
    }
    catch (JSONException paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LunaInfoStickerDrawable", 2, paramString1, new Object[0]);
      }
      paramString1 = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LunaInfoStickerDrawable", 2, paramString1);
    }
    return paramString1;
  }
  
  protected void a(Canvas paramCanvas, ArrayList<Integer> paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    try
    {
      int j = a(8.5F, this.jdField_a_of_type_AndroidContentContext.getResources()) + 0;
      this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(this.jdField_a_of_type_AndroidGraphicsTypeface);
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(a(45.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      float f1 = Math.abs(this.jdField_a_of_type_AndroidTextTextPaint.getFontMetrics().ascent);
      this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidTextTextPaint.measureText(this.jdField_b_of_type_JavaLangString, 0, this.jdField_b_of_type_JavaLangString.length());
      this.jdField_a_of_type_AndroidTextTextPaint.setAlpha(((Integer)paramArrayList.get(this.jdField_e_of_type_Int)).intValue());
      PerLineFontBitmapsInfo.a(((Integer)paramArrayList.get(this.jdField_e_of_type_Int)).intValue(), this.jdField_a_of_type_AndroidTextTextPaint);
      paramCanvas.drawText(this.jdField_b_of_type_JavaLangString, 0, this.jdField_b_of_type_JavaLangString.length(), (this.jdField_a_of_type_AndroidGraphicsRectF.width() - this.jdField_a_of_type_Float) / 2.0F, j + f1, this.jdField_a_of_type_AndroidTextTextPaint);
      j = j + a(45.0F, this.jdField_a_of_type_AndroidContentContext.getResources()) + a(8.5F, this.jdField_a_of_type_AndroidContentContext.getResources());
      this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(this.jdField_a_of_type_AndroidGraphicsTypeface);
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(a(45.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      if (Build.VERSION.SDK_INT >= 21) {
        this.jdField_a_of_type_AndroidTextTextPaint.setShadowLayer(1.0F, 1.0F, 1.0F, -1728053248);
      }
      f1 = Math.abs(this.jdField_a_of_type_AndroidTextTextPaint.getFontMetrics().ascent);
      this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidTextTextPaint.measureText(this.jdField_c_of_type_JavaLangString, 0, this.jdField_c_of_type_JavaLangString.length());
      this.jdField_a_of_type_AndroidTextTextPaint.setAlpha(((Integer)paramArrayList.get(this.jdField_h_of_type_Int)).intValue());
      PerLineFontBitmapsInfo.a(((Integer)paramArrayList.get(this.jdField_h_of_type_Int)).intValue(), this.jdField_a_of_type_AndroidTextTextPaint);
      paramCanvas.drawText(this.jdField_c_of_type_JavaLangString, 0, this.jdField_c_of_type_JavaLangString.length(), (this.jdField_a_of_type_AndroidGraphicsRectF.width() - this.jdField_a_of_type_Float) / 2.0F, j + f1, this.jdField_a_of_type_AndroidTextTextPaint);
      j = j + a(45.0F, this.jdField_a_of_type_AndroidContentContext.getResources()) + a(8.5F, this.jdField_a_of_type_AndroidContentContext.getResources());
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL_AND_STROKE);
      int k = (int)((this.jdField_a_of_type_AndroidGraphicsRectF.width() - this.jdField_a_of_type_Float) / 2.0F);
      PerLineFontBitmapsInfo.a(((Integer)paramArrayList.get(this.i)).intValue(), this.jdField_a_of_type_AndroidGraphicsPaint);
      if (((Integer)paramArrayList.get(this.i)).intValue() == a(45.0F, this.jdField_a_of_type_AndroidContentContext.getResources())) {
        this.jdField_a_of_type_AndroidGraphicsPaint.setShadowLayer(1.0F, 1.0F, 1.0F, -1728053248);
      } else {
        this.jdField_a_of_type_AndroidGraphicsPaint.setShadowLayer(0.0F, 0.0F, 0.0F, -1);
      }
      f1 = k;
      float f2 = j;
      paramCanvas.drawLine(f1, f2, k + ((Integer)paramArrayList.get(this.i)).intValue(), f2, this.jdField_a_of_type_AndroidGraphicsPaint);
      j += a(8.5F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiWidgetPerLineFontBitmapsInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
      FontBitmapInfo localFontBitmapInfo;
      Bitmap localBitmap;
      TextPaint localTextPaint;
      while (((Iterator)localObject).hasNext())
      {
        localFontBitmapInfo = (FontBitmapInfo)((Iterator)localObject).next();
        localBitmap = localFontBitmapInfo.jdField_a_of_type_AndroidGraphicsBitmap;
        localTextPaint = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiWidgetPerLineFontBitmapsInfo.jdField_a_of_type_AndroidTextTextPaint;
        localTextPaint.setAlpha(((Integer)paramArrayList.get(localFontBitmapInfo.jdField_b_of_type_Int)).intValue());
        this.jdField_a_of_type_Float = localTextPaint.measureText(this.jdField_d_of_type_JavaLangString, 0, this.jdField_d_of_type_JavaLangString.length());
        paramCanvas.drawBitmap(localBitmap, (this.jdField_a_of_type_AndroidGraphicsRectF.width() - this.jdField_a_of_type_Float) / 2.0F + this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiWidgetPerLineFontBitmapsInfo.jdField_a_of_type_Int + localFontBitmapInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiWidgetPerLineFontBitmapsInfo.jdField_b_of_type_Int + j, localTextPaint);
      }
      k = a(14.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      int m = a(8.5F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localObject = this.jdField_b_of_type_ComTencentAelightCameraAioeditorDoodleUiWidgetPerLineFontBitmapsInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localFontBitmapInfo = (FontBitmapInfo)((Iterator)localObject).next();
        localBitmap = localFontBitmapInfo.jdField_a_of_type_AndroidGraphicsBitmap;
        localTextPaint = this.jdField_b_of_type_ComTencentAelightCameraAioeditorDoodleUiWidgetPerLineFontBitmapsInfo.jdField_a_of_type_AndroidTextTextPaint;
        localTextPaint.setAlpha(((Integer)paramArrayList.get(localFontBitmapInfo.jdField_b_of_type_Int)).intValue());
        this.jdField_a_of_type_Float = localTextPaint.measureText(this.jdField_e_of_type_JavaLangString, 0, this.jdField_e_of_type_JavaLangString.length());
        paramCanvas.drawBitmap(localBitmap, (this.jdField_a_of_type_AndroidGraphicsRectF.width() - this.jdField_a_of_type_Float) / 2.0F + this.jdField_b_of_type_ComTencentAelightCameraAioeditorDoodleUiWidgetPerLineFontBitmapsInfo.jdField_a_of_type_Int + localFontBitmapInfo.jdField_a_of_type_Int, this.jdField_b_of_type_ComTencentAelightCameraAioeditorDoodleUiWidgetPerLineFontBitmapsInfo.jdField_b_of_type_Int + (j + k + m), localTextPaint);
      }
      if (paramArrayList != null)
      {
        j = paramCanvas.saveLayer(0.0F, 0.0F, getIntrinsicWidth(), getIntrinsicHeight(), this.jdField_a_of_type_AndroidGraphicsPaint, 31);
        if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
          paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
        }
        this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(this.jdField_a_of_type_AndroidGraphicsPorterDuffXfermode);
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-65536);
        this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.jdField_b_of_type_AndroidGraphicsRect.set(0, ((Integer)paramArrayList.get(this.jdField_a_of_type_Int)).intValue(), a(88.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), a(180.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        paramCanvas.drawRect(this.jdField_b_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
        this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(null);
        paramCanvas.restoreToCount(j);
        j = paramCanvas.saveLayer(0.0F, 0.0F, getIntrinsicWidth(), getIntrinsicHeight(), this.jdField_b_of_type_AndroidGraphicsPaint, 31);
        if (this.jdField_c_of_type_AndroidGraphicsBitmap != null) {
          paramCanvas.drawBitmap(this.jdField_c_of_type_AndroidGraphicsBitmap, this.jdField_c_of_type_AndroidGraphicsRect, this.jdField_b_of_type_AndroidGraphicsRectF, this.jdField_b_of_type_AndroidGraphicsPaint);
        }
        this.jdField_b_of_type_AndroidGraphicsPaint.setXfermode(this.jdField_b_of_type_AndroidGraphicsPorterDuffXfermode);
        this.jdField_b_of_type_AndroidGraphicsPaint.setColor(-65536);
        this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.jdField_d_of_type_AndroidGraphicsRect.set(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.jdField_c_of_type_Int + a(77.5F, this.jdField_a_of_type_AndroidContentContext.getResources()), this.jdField_d_of_type_Int + ((Integer)paramArrayList.get(this.jdField_b_of_type_Int)).intValue());
        paramCanvas.drawRect(this.jdField_d_of_type_AndroidGraphicsRect, this.jdField_b_of_type_AndroidGraphicsPaint);
        this.jdField_b_of_type_AndroidGraphicsPaint.setXfermode(null);
        paramCanvas.restoreToCount(j);
        return;
      }
    }
    catch (Exception paramCanvas)
    {
      Object localObject = new StringBuilder(128);
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        ((StringBuilder)localObject).append((Integer)paramArrayList.next());
        ((StringBuilder)localObject).append(" ");
      }
      paramArrayList = new StringBuilder();
      paramArrayList.append("mFourthLineInfo draw fail, ");
      paramArrayList.append(((StringBuilder)localObject).toString());
      QLog.e("LunaInfoStickerDrawable", 1, paramArrayList.toString(), paramCanvas);
    }
  }
  
  public String[] a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      paramString = null;
    }
    if (paramString != null)
    {
      this.jdField_f_of_type_Int = paramString.optInt("type", 0);
      this.jdField_b_of_type_JavaLangString = paramString.optString("first_line", "");
      this.jdField_c_of_type_JavaLangString = paramString.optString("second_line", "");
      this.jdField_d_of_type_JavaLangString = paramString.optString("third_line", "");
      this.jdField_e_of_type_JavaLangString = paramString.optString("fourth_line", "");
      this.jdField_f_of_type_JavaLangString = paramString.optString("font_file_name", "");
      this.g = paramString.optString("out_side_border", "");
      this.jdField_h_of_type_JavaLangString = paramString.optString("in_side_border", "");
    }
    return new String[] { this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, this.g, this.jdField_h_of_type_JavaLangString };
  }
  
  protected void b()
  {
    if (new File(this.g).exists()) {
      this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeFile(this.g);
    }
    Object localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (localObject != null) {
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect(0, 0, ((Bitmap)localObject).getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
    }
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF(0.0F, 0.0F, a(88.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), a(180.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    if (new File(this.jdField_h_of_type_JavaLangString).exists()) {
      this.jdField_c_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeFile(this.jdField_h_of_type_JavaLangString);
    }
    localObject = this.jdField_c_of_type_AndroidGraphicsBitmap;
    if (localObject != null) {
      this.jdField_c_of_type_AndroidGraphicsRect = new Rect(0, 0, ((Bitmap)localObject).getWidth(), this.jdField_c_of_type_AndroidGraphicsBitmap.getHeight());
    }
    this.jdField_b_of_type_AndroidGraphicsRectF = new RectF(0.0F, 0.0F, a(77.5F, this.jdField_a_of_type_AndroidContentContext.getResources()), a(169.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    this.jdField_b_of_type_AndroidGraphicsRect = new Rect(0, 0, a(88.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), a(180.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiWidgetAnimStateTypeEvaluator.a("out", 0L, 500L, 0, a(180.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), new LinearInterpolator());
    this.jdField_c_of_type_Int = ((int)((this.jdField_a_of_type_AndroidGraphicsRectF.width() - this.jdField_b_of_type_AndroidGraphicsRectF.width()) / 2.0F));
    this.jdField_d_of_type_Int = ((int)((this.jdField_a_of_type_AndroidGraphicsRectF.height() - this.jdField_b_of_type_AndroidGraphicsRectF.height()) / 2.0F));
    int j = this.jdField_c_of_type_Int;
    this.jdField_b_of_type_AndroidGraphicsRectF = new RectF(j, this.jdField_d_of_type_Int, j + a(77.5F, this.jdField_a_of_type_AndroidContentContext.getResources()), this.jdField_d_of_type_Int + a(169.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    j = this.jdField_c_of_type_Int;
    this.jdField_d_of_type_AndroidGraphicsRect = new Rect(j, this.jdField_d_of_type_Int, a(77.5F, this.jdField_a_of_type_AndroidContentContext.getResources()) + j, this.jdField_d_of_type_Int + a(169.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiWidgetAnimStateTypeEvaluator.a("in", 150L, 700L, a(180.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, new LinearInterpolator());
    this.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiWidgetAnimStateTypeEvaluator.a("firstFont", 500L, 200L, 0, 255, new LinearInterpolator());
    this.jdField_h_of_type_Int = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiWidgetAnimStateTypeEvaluator.a("SecondFont", 600L, 200L, 0, 255, new LinearInterpolator());
    this.i = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiWidgetAnimStateTypeEvaluator.a("thirdLine", 700L, 200L, 0, a(45.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), new LinearInterpolator());
    if (new File(this.jdField_f_of_type_JavaLangString).exists()) {}
    try
    {
      this.jdField_a_of_type_AndroidGraphicsTypeface = Typeface.createFromFile(this.jdField_f_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(this.jdField_a_of_type_AndroidGraphicsTypeface);
      localObject = this.jdField_a_of_type_AndroidTextTextPaint.getFontMetrics();
      if ((int)(((Paint.FontMetrics)localObject).bottom - ((Paint.FontMetrics)localObject).top) <= 0) {
        this.jdField_a_of_type_AndroidGraphicsTypeface = Typeface.DEFAULT;
      }
      this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(Typeface.DEFAULT);
    }
    catch (Exception localException)
    {
      label663:
      break label663;
    }
    this.jdField_a_of_type_AndroidGraphicsTypeface = Typeface.DEFAULT;
    break label680;
    this.jdField_a_of_type_AndroidGraphicsTypeface = Typeface.DEFAULT;
    label680:
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiWidgetPerLineFontBitmapsInfo = PerLineFontBitmapsInfo.a(this.jdField_d_of_type_JavaLangString, a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), -1, 0, 0, 700, 500, this.jdField_a_of_type_AndroidGraphicsTypeface, this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiWidgetAnimStateTypeEvaluator);
    this.jdField_b_of_type_ComTencentAelightCameraAioeditorDoodleUiWidgetPerLineFontBitmapsInfo = PerLineFontBitmapsInfo.a(this.jdField_e_of_type_JavaLangString, a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), -1, 0, 0, 1100, 300, this.jdField_a_of_type_AndroidGraphicsTypeface, this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiWidgetAnimStateTypeEvaluator);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setDither(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(-1);
  }
  
  public int getIntrinsicHeight()
  {
    return a(180.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
  }
  
  public int getIntrinsicWidth()
  {
    return a(88.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.doodle.ui.widget.LunaInfoStickerDrawable
 * JD-Core Version:    0.7.0.1
 */