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
import com.tencent.mobileqq.richmedia.capture.data.GifDecoder;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Calendar;
import org.json.JSONException;
import org.json.JSONObject;

public class bmts
  extends bmth
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private bmtt jdField_a_of_type_Bmtt;
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
  
  public bmts(Context paramContext, String paramString)
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
      if (QLog.isColorLevel()) {
        QLog.d("WeatherStickerDrawable", 2, paramString1);
      }
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("WeatherStickerDrawable", 2, paramString1, new Object[0]);
        }
        paramString1 = null;
      }
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Boolean) {}
    Bitmap localBitmap;
    do
    {
      return;
      long l1 = System.currentTimeMillis();
      if (this.jdField_a_of_type_Long == 0L) {
        this.jdField_a_of_type_Long = l1;
      }
      long l2 = this.jdField_a_of_type_Long;
      this.jdField_a_of_type_Bmtt.sendEmptyMessageDelayed(0, 40L);
      localBitmap = null;
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataGifDecoder != null) {
        localBitmap = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataGifDecoder.getNextGifFrame((l1 - l2) * 1000L * 1000L);
      }
    } while (localBitmap == this.jdField_a_of_type_AndroidGraphicsBitmap);
    this.jdField_a_of_type_AndroidGraphicsBitmap = localBitmap;
    invalidateSelf();
  }
  
  public Bitmap a()
  {
    Bitmap localBitmap = b();
    Canvas localCanvas = new Canvas(localBitmap);
    ArrayList localArrayList = this.jdField_a_of_type_Bmsv.a(this.jdField_a_of_type_Bmsv.a());
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
    ArrayList localArrayList = this.jdField_a_of_type_Bmsv.a(paramLong);
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataGifDecoder != null) {
      this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataGifDecoder.getNextGifFrame(paramLong * 1000L * 1000L);
    }
    a(localCanvas, localArrayList);
    return localBitmap;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Bmtt != null) {
      this.jdField_a_of_type_Bmtt.removeCallbacksAndMessages(null);
    }
  }
  
  protected void a(Canvas paramCanvas, ArrayList<Integer> paramArrayList)
  {
    int i1 = 255;
    int i6;
    int i5;
    int i4;
    int i3;
    int i2;
    if (paramArrayList != null)
    {
      i6 = a(paramArrayList, this.k, 0);
      i5 = a(paramArrayList, this.l, 0);
      i4 = a(paramArrayList, this.m, 0);
      i3 = a(paramArrayList, this.n, 255);
      i2 = a(paramArrayList, this.o, 255);
      i1 = a(paramArrayList, this.p, 255);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
        paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, null, this.jdField_a_of_type_AndroidGraphicsRect, null);
      }
      this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(i3);
      if (this.jdField_i_of_type_JavaLangString != null) {
        paramCanvas.drawText(this.jdField_i_of_type_JavaLangString, this.jdField_b_of_type_Int + i6, this.jdField_a_of_type_Float, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      this.jdField_c_of_type_AndroidGraphicsPaint.setAlpha(i3);
      if (this.jdField_c_of_type_AndroidGraphicsBitmap != null)
      {
        this.jdField_d_of_type_AndroidGraphicsRect.set(this.jdField_b_of_type_AndroidGraphicsRect);
        this.jdField_d_of_type_AndroidGraphicsRect.offset(i6, 0);
        paramCanvas.drawBitmap(this.jdField_c_of_type_AndroidGraphicsBitmap, null, this.jdField_d_of_type_AndroidGraphicsRect, this.jdField_c_of_type_AndroidGraphicsPaint);
      }
      this.jdField_c_of_type_AndroidGraphicsPaint.setAlpha(i2);
      if (this.jdField_d_of_type_AndroidGraphicsBitmap != null)
      {
        this.jdField_d_of_type_AndroidGraphicsRect.set(this.jdField_c_of_type_AndroidGraphicsRect);
        this.jdField_d_of_type_AndroidGraphicsRect.offset(i5, 0);
        paramCanvas.drawBitmap(this.jdField_d_of_type_AndroidGraphicsBitmap, null, this.jdField_d_of_type_AndroidGraphicsRect, this.jdField_c_of_type_AndroidGraphicsPaint);
      }
      this.jdField_b_of_type_AndroidGraphicsPaint.setAlpha(i1);
      this.jdField_b_of_type_AndroidGraphicsPaint.setTextSize(this.s);
      if (this.g != null) {
        paramCanvas.drawText(this.g, this.jdField_c_of_type_Int + i4, this.jdField_d_of_type_Int, this.jdField_b_of_type_AndroidGraphicsPaint);
      }
      if (this.jdField_h_of_type_JavaLangString != null) {
        paramCanvas.drawText(this.jdField_h_of_type_JavaLangString, this.jdField_i_of_type_Int + i4, this.jdField_d_of_type_Int, this.jdField_b_of_type_AndroidGraphicsPaint);
      }
      if (this.jdField_c_of_type_JavaLangString != null)
      {
        if (this.r != 0) {
          this.jdField_b_of_type_AndroidGraphicsPaint.setTextSize(this.r);
        }
        paramCanvas.drawText(this.jdField_c_of_type_JavaLangString, this.j + i4, this.jdField_d_of_type_Int, this.jdField_b_of_type_AndroidGraphicsPaint);
      }
      return;
      i2 = 255;
      i3 = 255;
      i4 = 0;
      i5 = 0;
      i6 = 0;
    }
  }
  
  public String[] a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
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
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = null;
      }
    }
  }
  
  protected void b()
  {
    this.jdField_a_of_type_Bmtt = new bmtt(new WeakReference(this));
    if (new File(this.jdField_e_of_type_JavaLangString).exists()) {}
    label1159:
    label1166:
    for (;;)
    {
      int i2;
      try
      {
        Object localObject = Typeface.createFromFile(this.jdField_e_of_type_JavaLangString);
        if (this.jdField_a_of_type_Int != -999) {
          break label1122;
        }
        this.jdField_i_of_type_JavaLangString = "--";
        this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
        this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
        this.jdField_a_of_type_AndroidGraphicsPaint.setDither(true);
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
        this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(a(40.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        this.jdField_a_of_type_AndroidGraphicsPaint.setFakeBoldText(true);
        this.jdField_a_of_type_AndroidGraphicsPaint.setTypeface((Typeface)localObject);
        Paint.FontMetrics localFontMetrics = this.jdField_a_of_type_AndroidGraphicsPaint.getFontMetrics();
        int i3 = (int)(localFontMetrics.bottom - localFontMetrics.top);
        int i8 = (int)this.jdField_a_of_type_AndroidGraphicsPaint.measureText(this.jdField_i_of_type_JavaLangString);
        this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
        this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
        this.jdField_b_of_type_AndroidGraphicsPaint.setDither(true);
        this.jdField_b_of_type_AndroidGraphicsPaint.setColor(-1);
        this.jdField_b_of_type_AndroidGraphicsPaint.setTypeface((Typeface)localObject);
        this.s = a(11.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        if ((this.jdField_c_of_type_JavaLangString != null) && (this.jdField_c_of_type_JavaLangString.length() > 2)) {
          this.r = a(9.5F, this.jdField_a_of_type_AndroidContentContext.getResources());
        }
        this.jdField_b_of_type_AndroidGraphicsPaint.setTextSize(this.s);
        this.jdField_b_of_type_AndroidGraphicsPaint.setFakeBoldText(true);
        localObject = this.jdField_b_of_type_AndroidGraphicsPaint.getFontMetrics();
        this.jdField_c_of_type_AndroidGraphicsPaint = new Paint(1);
        Calendar localCalendar = Calendar.getInstance();
        int i1 = localCalendar.get(2);
        if (i1 >= this.jdField_a_of_type_ArrayOfJavaLangString.length) {
          break label1149;
        }
        this.g = this.jdField_a_of_type_ArrayOfJavaLangString[i1];
        this.jdField_h_of_type_JavaLangString = String.format("%02d", new Object[] { Integer.valueOf(localCalendar.get(5)) });
        if (new File(this.jdField_d_of_type_JavaLangString).exists())
        {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataGifDecoder = new blqk(this.jdField_b_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataGifDecoder.init();
        }
        if (new File(this.jdField_d_of_type_JavaLangString).exists()) {
          this.jdField_c_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeFile(this.jdField_d_of_type_JavaLangString);
        }
        if (new File(this.jdField_f_of_type_JavaLangString).exists()) {
          this.jdField_d_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeFile(this.jdField_f_of_type_JavaLangString);
        }
        this.q = a(90.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        this.jdField_a_of_type_AndroidGraphicsRect = new Rect(0, 0, this.q, this.q);
        float f1 = a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        this.jdField_a_of_type_Float = (f1 - localFontMetrics.top);
        int i4 = a(1.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        i2 = a(1.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        int i5 = Math.round(i2 * 0.5F);
        int i6 = i2 * 4;
        this.jdField_b_of_type_Int = (this.q + i2);
        this.jdField_c_of_type_Int = (i2 * 3 + this.q);
        i1 = a(55.5F, this.jdField_a_of_type_AndroidContentContext.getResources());
        int i7 = a(22.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        i8 = i8 + this.jdField_b_of_type_Int + i6;
        int i9 = a(31.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        int i10 = a(23.5F, this.jdField_a_of_type_AndroidContentContext.getResources());
        if (i1 >= i8 + i7 - this.jdField_b_of_type_Int) {
          break label1166;
        }
        i1 = i8 + i7 - this.jdField_b_of_type_Int;
        this.jdField_b_of_type_AndroidGraphicsRect = new Rect(i8, i10, i7 + i8, i10 + i9);
        i6 = i10 + i9 + i6;
        i7 = this.jdField_b_of_type_Int + i2;
        this.jdField_c_of_type_AndroidGraphicsRect = new Rect(i7, i6, i7 + i1, i4 + i6);
        this.jdField_d_of_type_Int = ((int)((int)(i3 + f1 + i5) - ((Paint.FontMetrics)localObject).top));
        i3 = (int)this.jdField_b_of_type_AndroidGraphicsPaint.measureText(this.g);
        i4 = (int)this.jdField_b_of_type_AndroidGraphicsPaint.measureText(this.jdField_h_of_type_JavaLangString);
        if (this.r == 0) {
          break label1159;
        }
        this.jdField_b_of_type_AndroidGraphicsPaint.setTextSize(this.r);
        i2 *= 2;
        this.jdField_i_of_type_Int = (this.jdField_c_of_type_Int + i3 + i2);
        this.j = (i2 + (this.jdField_i_of_type_Int + i4));
        this.jdField_h_of_type_Int = ((int)(this.q + i1 * 1.2D));
        this.jdField_e_of_type_Int = this.jdField_a_of_type_AndroidGraphicsRect.bottom;
        this.k = this.jdField_a_of_type_Bmsv.a("offsetX", 0L, 650L, (int)(-i1 * 0.3D), 0, new bmtq());
        this.l = this.jdField_a_of_type_Bmsv.a("offsetX", 100L, 650L, (int)(-i1 * 0.3D), 0, new bmtq());
        this.m = this.jdField_a_of_type_Bmsv.a("offsetX", 200L, 650L, (int)(-i1 * 0.3D), 0, new bmtq());
        this.n = this.jdField_a_of_type_Bmsv.a("alpha", 0L, 370L, 0, 255, new xia(0.33F, 0.0F, 0.67F, 1.0F));
        this.o = this.jdField_a_of_type_Bmsv.a("alpha", 100L, 370L, 0, 255, new xia(0.33F, 0.0F, 0.67F, 1.0F));
        this.p = this.jdField_a_of_type_Bmsv.a("alpha", 200L, 370L, 0, 255, new xia(0.33F, 0.0F, 0.67F, 1.0F));
        return;
      }
      catch (Exception localException)
      {
        localTypeface = Typeface.DEFAULT;
        continue;
      }
      Typeface localTypeface = Typeface.DEFAULT;
      continue;
      label1122:
      this.jdField_i_of_type_JavaLangString = String.format("%02d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
      continue;
      label1149:
      this.g = "";
      continue;
      i2 *= 5;
    }
  }
  
  protected void c()
  {
    super.c();
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataGifDecoder != null) && (this.jdField_b_of_type_Boolean)) {
      this.jdField_a_of_type_Bmtt.sendEmptyMessage(0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmts
 * JD-Core Version:    0.7.0.1
 */