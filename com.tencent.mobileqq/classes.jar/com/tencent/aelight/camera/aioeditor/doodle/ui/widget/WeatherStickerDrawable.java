package com.tencent.aelight.camera.aioeditor.doodle.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.Typeface;
import com.tencent.aelight.camera.aioeditor.capture.paster.ApngDecodeWrapper;
import com.tencent.aelight.camera.util.EaseCubicInterpolator;
import com.tencent.mobileqq.richmedia.capture.data.GifDecoder;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Calendar;
import org.json.JSONException;
import org.json.JSONObject;

public class WeatherStickerDrawable
  extends InfoStickerDrawable
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private WeatherStickerDrawable.ApngHandler jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiWidgetWeatherStickerDrawable$ApngHandler;
  private GifDecoder jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataGifDecoder;
  private boolean jdField_a_of_type_Boolean;
  private String[] jdField_a_of_type_ArrayOfJavaLangString = { "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC" };
  private int jdField_b_of_type_Int;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  private Rect jdField_b_of_type_AndroidGraphicsRect;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private Bitmap jdField_c_of_type_AndroidGraphicsBitmap;
  private Paint jdField_c_of_type_AndroidGraphicsPaint;
  private Rect jdField_c_of_type_AndroidGraphicsRect;
  private String jdField_c_of_type_JavaLangString;
  private int jdField_d_of_type_Int;
  private Bitmap jdField_d_of_type_AndroidGraphicsBitmap;
  private Rect jdField_d_of_type_AndroidGraphicsRect = new Rect();
  private String jdField_d_of_type_JavaLangString;
  private int jdField_e_of_type_Int;
  private String jdField_e_of_type_JavaLangString;
  private String f;
  private String g;
  private int jdField_h_of_type_Int;
  private String jdField_h_of_type_JavaLangString;
  private int jdField_i_of_type_Int;
  private String jdField_i_of_type_JavaLangString;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  private int q;
  private int r;
  private int s;
  
  public WeatherStickerDrawable(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    a(paramString);
    b();
    c();
  }
  
  public static String a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", paramInt1);
      localJSONObject.put("temperature", paramInt2);
      localJSONObject.put("weather_icon_path", paramString1);
      localJSONObject.put("weather_desc", paramString2);
      localJSONObject.put("weather_symbol_icon_path", paramString3);
      localJSONObject.put("weather_font_path", paramString4);
      localJSONObject.put("weather_line_path", paramString5);
      localJSONObject.put("weather_line_path", paramString5);
      localJSONObject.put("dynamic", paramBoolean);
      paramString1 = localJSONObject.toString();
    }
    catch (JSONException paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WeatherStickerDrawable", 2, paramString1, new Object[0]);
      }
      paramString1 = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("WeatherStickerDrawable", 2, paramString1);
    }
    return paramString1;
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    long l1 = System.currentTimeMillis();
    if (this.jdField_a_of_type_Long == 0L) {
      this.jdField_a_of_type_Long = l1;
    }
    long l2 = this.jdField_a_of_type_Long;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiWidgetWeatherStickerDrawable$ApngHandler.sendEmptyMessageDelayed(0, 40L);
    Bitmap localBitmap = null;
    GifDecoder localGifDecoder = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataGifDecoder;
    if (localGifDecoder != null) {
      localBitmap = localGifDecoder.getNextGifFrame((l1 - l2) * 1000L * 1000L);
    }
    if (localBitmap != this.jdField_a_of_type_AndroidGraphicsBitmap)
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = localBitmap;
      invalidateSelf();
    }
  }
  
  public Bitmap a()
  {
    Bitmap localBitmap = b();
    Canvas localCanvas = new Canvas(localBitmap);
    ArrayList localArrayList = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiWidgetAnimStateTypeEvaluator.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiWidgetAnimStateTypeEvaluator.a());
    if (this.jdField_b_of_type_JavaLangString != null)
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inPreferredConfig = Bitmap.Config.ARGB_4444;
      this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeFile(this.jdField_b_of_type_JavaLangString.replace(".apng", ".bpng"), localOptions);
    }
    a(localCanvas, localArrayList);
    return localBitmap;
  }
  
  public Bitmap a(long paramLong)
  {
    Bitmap localBitmap = b();
    Canvas localCanvas = new Canvas(localBitmap);
    ArrayList localArrayList = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiWidgetAnimStateTypeEvaluator.a(paramLong);
    GifDecoder localGifDecoder = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataGifDecoder;
    if (localGifDecoder != null) {
      this.jdField_a_of_type_AndroidGraphicsBitmap = localGifDecoder.getNextGifFrame(paramLong * 1000L * 1000L);
    }
    a(localCanvas, localArrayList);
    return localBitmap;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    WeatherStickerDrawable.ApngHandler localApngHandler = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiWidgetWeatherStickerDrawable$ApngHandler;
    if (localApngHandler != null) {
      localApngHandler.removeCallbacksAndMessages(null);
    }
  }
  
  protected void a(Canvas paramCanvas, ArrayList<Integer> paramArrayList)
  {
    int i2 = 255;
    int i3;
    int i4;
    int i1;
    int i5;
    int i6;
    if (paramArrayList != null)
    {
      i3 = a(paramArrayList, this.k, 0);
      i4 = a(paramArrayList, this.l, 0);
      i1 = a(paramArrayList, this.m, 0);
      i2 = a(paramArrayList, this.n, 255);
      i5 = a(paramArrayList, this.o, 255);
      i6 = a(paramArrayList, this.p, 255);
    }
    else
    {
      i6 = 255;
      i3 = 0;
      i4 = 0;
      i1 = 0;
      i5 = 255;
    }
    paramArrayList = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (paramArrayList != null) {
      paramCanvas.drawBitmap(paramArrayList, null, this.jdField_a_of_type_AndroidGraphicsRect, null);
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(i2);
    paramArrayList = this.jdField_i_of_type_JavaLangString;
    if (paramArrayList != null) {
      paramCanvas.drawText(paramArrayList, this.jdField_b_of_type_Int + i3, this.jdField_a_of_type_Float, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    this.jdField_c_of_type_AndroidGraphicsPaint.setAlpha(i2);
    if (this.jdField_c_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_d_of_type_AndroidGraphicsRect.set(this.jdField_b_of_type_AndroidGraphicsRect);
      this.jdField_d_of_type_AndroidGraphicsRect.offset(i3, 0);
      paramCanvas.drawBitmap(this.jdField_c_of_type_AndroidGraphicsBitmap, null, this.jdField_d_of_type_AndroidGraphicsRect, this.jdField_c_of_type_AndroidGraphicsPaint);
    }
    this.jdField_c_of_type_AndroidGraphicsPaint.setAlpha(i5);
    if (this.jdField_d_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_d_of_type_AndroidGraphicsRect.set(this.jdField_c_of_type_AndroidGraphicsRect);
      this.jdField_d_of_type_AndroidGraphicsRect.offset(i4, 0);
      paramCanvas.drawBitmap(this.jdField_d_of_type_AndroidGraphicsBitmap, null, this.jdField_d_of_type_AndroidGraphicsRect, this.jdField_c_of_type_AndroidGraphicsPaint);
    }
    this.jdField_b_of_type_AndroidGraphicsPaint.setAlpha(i6);
    this.jdField_b_of_type_AndroidGraphicsPaint.setTextSize(this.s);
    paramArrayList = this.g;
    if (paramArrayList != null) {
      paramCanvas.drawText(paramArrayList, this.jdField_c_of_type_Int + i1, this.jdField_d_of_type_Int, this.jdField_b_of_type_AndroidGraphicsPaint);
    }
    paramArrayList = this.jdField_h_of_type_JavaLangString;
    if (paramArrayList != null) {
      paramCanvas.drawText(paramArrayList, this.jdField_i_of_type_Int + i1, this.jdField_d_of_type_Int, this.jdField_b_of_type_AndroidGraphicsPaint);
    }
    if (this.jdField_c_of_type_JavaLangString != null)
    {
      i2 = this.r;
      if (i2 != 0) {
        this.jdField_b_of_type_AndroidGraphicsPaint.setTextSize(i2);
      }
      paramCanvas.drawText(this.jdField_c_of_type_JavaLangString, this.j + i1, this.jdField_d_of_type_Int, this.jdField_b_of_type_AndroidGraphicsPaint);
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
      this.jdField_a_of_type_Int = paramString.optInt("temperature");
      this.jdField_b_of_type_JavaLangString = paramString.optString("weather_icon_path", "");
      this.jdField_c_of_type_JavaLangString = paramString.optString("weather_desc", "");
      this.jdField_d_of_type_JavaLangString = paramString.optString("weather_symbol_icon_path", "");
      this.jdField_e_of_type_JavaLangString = paramString.optString("weather_font_path", "");
      this.jdField_f_of_type_JavaLangString = paramString.optString("weather_line_path", "");
      this.jdField_b_of_type_Boolean = paramString.optBoolean("dynamic", true);
    }
    return new String[] { this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString };
  }
  
  protected void b()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiWidgetWeatherStickerDrawable$ApngHandler = new WeatherStickerDrawable.ApngHandler(new WeakReference(this));
    if (new File(this.jdField_e_of_type_JavaLangString).exists()) {}
    try
    {
      localObject = Typeface.createFromFile(this.jdField_e_of_type_JavaLangString);
    }
    catch (Exception localException)
    {
      Object localObject;
      label48:
      int i1;
      Paint.FontMetrics localFontMetrics;
      int i5;
      Calendar localCalendar;
      int i2;
      String[] arrayOfString;
      float f1;
      int i6;
      int i4;
      int i7;
      int i8;
      int i3;
      int i9;
      int i11;
      int i10;
      int i12;
      int i13;
      double d1;
      double d2;
      break label48;
    }
    localObject = Typeface.DEFAULT;
    break label61;
    localObject = Typeface.DEFAULT;
    label61:
    i1 = this.jdField_a_of_type_Int;
    if (i1 == -999) {
      this.jdField_i_of_type_JavaLangString = "--";
    } else {
      this.jdField_i_of_type_JavaLangString = String.format("%02d", new Object[] { Integer.valueOf(i1) });
    }
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(a(40.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    this.jdField_a_of_type_AndroidGraphicsPaint.setFakeBoldText(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTypeface((Typeface)localObject);
    localFontMetrics = this.jdField_a_of_type_AndroidGraphicsPaint.getFontMetrics();
    i5 = (int)(localFontMetrics.bottom - localFontMetrics.top);
    i1 = (int)this.jdField_a_of_type_AndroidGraphicsPaint.measureText(this.jdField_i_of_type_JavaLangString);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_b_of_type_AndroidGraphicsPaint.setTypeface((Typeface)localObject);
    this.s = a(11.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    localObject = this.jdField_c_of_type_JavaLangString;
    if ((localObject != null) && (((String)localObject).length() > 2)) {
      this.r = a(9.5F, this.jdField_a_of_type_AndroidContentContext.getResources());
    }
    this.jdField_b_of_type_AndroidGraphicsPaint.setTextSize(this.s);
    this.jdField_b_of_type_AndroidGraphicsPaint.setFakeBoldText(true);
    localObject = this.jdField_b_of_type_AndroidGraphicsPaint.getFontMetrics();
    this.jdField_c_of_type_AndroidGraphicsPaint = new Paint(1);
    localCalendar = Calendar.getInstance();
    i2 = localCalendar.get(2);
    arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
    if (i2 < arrayOfString.length) {
      this.g = arrayOfString[i2];
    } else {
      this.g = "";
    }
    this.jdField_h_of_type_JavaLangString = String.format("%02d", new Object[] { Integer.valueOf(localCalendar.get(5)) });
    if (new File(this.jdField_d_of_type_JavaLangString).exists())
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataGifDecoder = new ApngDecodeWrapper(this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataGifDecoder.init();
    }
    if (new File(this.jdField_d_of_type_JavaLangString).exists()) {
      this.jdField_c_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeFile(this.jdField_d_of_type_JavaLangString);
    }
    if (new File(this.jdField_f_of_type_JavaLangString).exists()) {
      this.jdField_d_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeFile(this.jdField_f_of_type_JavaLangString);
    }
    this.q = a(90.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    i2 = this.q;
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect(0, 0, i2, i2);
    f1 = a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.jdField_a_of_type_Float = (f1 - localFontMetrics.top);
    i6 = a(1.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    i4 = a(1.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    i7 = Math.round(i4 * 0.5F);
    i8 = i4 * 4;
    i2 = this.q;
    this.jdField_b_of_type_Int = (i2 + i4);
    this.jdField_c_of_type_Int = (i2 + i4 * 3);
    i3 = a(55.5F, this.jdField_a_of_type_AndroidContentContext.getResources());
    i2 = a(22.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    i9 = this.jdField_b_of_type_Int + i1 + i8;
    i11 = a(31.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    i10 = a(23.5F, this.jdField_a_of_type_AndroidContentContext.getResources());
    i12 = i2 + i9;
    i13 = this.jdField_b_of_type_Int;
    i2 = i4 * 2;
    i1 = i3;
    if (i3 < i12 - i13) {
      i1 = i12 - i13;
    }
    i3 = i11 + i10;
    this.jdField_b_of_type_AndroidGraphicsRect = new Rect(i9, i10, i12, i3);
    i3 += i8;
    i8 = this.jdField_b_of_type_Int + i4;
    this.jdField_c_of_type_AndroidGraphicsRect = new Rect(i8, i3, i8 + i1, i6 + i3);
    this.jdField_d_of_type_Int = ((int)((int)(f1 + i5 + i7) - ((Paint.FontMetrics)localObject).top));
    i3 = (int)this.jdField_b_of_type_AndroidGraphicsPaint.measureText(this.g);
    i5 = (int)this.jdField_b_of_type_AndroidGraphicsPaint.measureText(this.jdField_h_of_type_JavaLangString);
    i6 = this.r;
    if (i6 != 0) {
      this.jdField_b_of_type_AndroidGraphicsPaint.setTextSize(i6);
    } else {
      i2 = i4 * 5;
    }
    this.jdField_i_of_type_Int = (this.jdField_c_of_type_Int + i3 + i2);
    this.j = (this.jdField_i_of_type_Int + i5 + i2);
    d1 = this.q;
    d2 = i1;
    Double.isNaN(d2);
    Double.isNaN(d1);
    this.jdField_h_of_type_Int = ((int)(d1 + d2 * 1.2D));
    this.jdField_e_of_type_Int = this.jdField_a_of_type_AndroidGraphicsRect.bottom;
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiWidgetAnimStateTypeEvaluator;
    d1 = -i1;
    Double.isNaN(d1);
    i1 = (int)(d1 * 0.3D);
    this.k = ((AnimStateTypeEvaluator)localObject).a("offsetX", 0L, 650L, i1, 0, new SpringInterpolator());
    this.l = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiWidgetAnimStateTypeEvaluator.a("offsetX", 100L, 650L, i1, 0, new SpringInterpolator());
    this.m = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiWidgetAnimStateTypeEvaluator.a("offsetX", 200L, 650L, i1, 0, new SpringInterpolator());
    this.n = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiWidgetAnimStateTypeEvaluator.a("alpha", 0L, 370L, 0, 255, new EaseCubicInterpolator(0.33F, 0.0F, 0.67F, 1.0F));
    this.o = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiWidgetAnimStateTypeEvaluator.a("alpha", 100L, 370L, 0, 255, new EaseCubicInterpolator(0.33F, 0.0F, 0.67F, 1.0F));
    this.p = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiWidgetAnimStateTypeEvaluator.a("alpha", 200L, 370L, 0, 255, new EaseCubicInterpolator(0.33F, 0.0F, 0.67F, 1.0F));
  }
  
  protected void c()
  {
    super.c();
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataGifDecoder != null) && (this.jdField_b_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiWidgetWeatherStickerDrawable$ApngHandler.sendEmptyMessage(0);
    }
  }
  
  public int getIntrinsicHeight()
  {
    return this.jdField_e_of_type_Int;
  }
  
  public int getIntrinsicWidth()
  {
    return this.jdField_h_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.doodle.ui.widget.WeatherStickerDrawable
 * JD-Core Version:    0.7.0.1
 */