import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Typeface;
import android.graphics.Xfermode;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.view.animation.LinearInterpolator;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class bpcu
  extends bpcq
{
  int jdField_a_of_type_Int = 0;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private Typeface jdField_a_of_type_AndroidGraphicsTypeface;
  private Xfermode jdField_a_of_type_AndroidGraphicsXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
  private TextPaint jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
  int jdField_b_of_type_Int = 0;
  private Typeface jdField_b_of_type_AndroidGraphicsTypeface;
  private String jdField_b_of_type_JavaLangString = "15:29";
  int jdField_c_of_type_Int = 0;
  private String jdField_c_of_type_JavaLangString = anvx.a(2131705509);
  int jdField_d_of_type_Int = 0;
  private String jdField_d_of_type_JavaLangString;
  int e = 0;
  int h = 0;
  int i = 0;
  int j = 0;
  
  public bpcu(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    a(paramString);
    b();
    c();
  }
  
  public static String a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", paramInt);
      localJSONObject.put("first_line", paramString1);
      localJSONObject.put("second_line", paramString2);
      localJSONObject.put("font_path", paramString3);
      paramString1 = localJSONObject.toString();
      if (QLog.isColorLevel()) {
        QLog.d("Left2RightInfoStickerDrawable", 2, paramString1);
      }
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Left2RightInfoStickerDrawable", 2, paramString1, new Object[0]);
        }
        paramString1 = null;
      }
    }
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  protected void a(Canvas paramCanvas, ArrayList<Integer> paramArrayList)
  {
    int m = paramCanvas.saveLayer(0.0F, 0.0F, getIntrinsicWidth(), getIntrinsicHeight(), this.jdField_a_of_type_AndroidGraphicsPaint, 31);
    int n = a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(-1);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(a(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(this.jdField_a_of_type_AndroidGraphicsTypeface);
    float f1 = Math.abs(this.jdField_a_of_type_AndroidTextTextPaint.getFontMetrics().ascent);
    int k = 0;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > this.j) {
      k = ((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(this.j)).intValue();
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (k != 0) {
        break label434;
      }
      this.jdField_a_of_type_AndroidTextTextPaint.setShadowLayer(1.0F, 1.0F, 1.0F, -1728053248);
    }
    for (;;)
    {
      paramCanvas.drawText(this.jdField_b_of_type_JavaLangString, a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()) + k, n + f1, this.jdField_a_of_type_AndroidTextTextPaint);
      int i1 = a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(this.jdField_b_of_type_AndroidGraphicsTypeface);
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      float f2 = Math.abs(this.jdField_a_of_type_AndroidTextTextPaint.getFontMetrics().ascent);
      paramCanvas.drawText(this.jdField_c_of_type_JavaLangString, a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()) + k, n + i1 + (f1 + f2), this.jdField_a_of_type_AndroidTextTextPaint);
      this.jdField_a_of_type_AndroidTextTextPaint.setXfermode(this.jdField_a_of_type_AndroidGraphicsXfermode);
      this.jdField_a_of_type_AndroidTextTextPaint.setColor(-1);
      this.jdField_a_of_type_AndroidTextTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
      paramCanvas.drawRect(k, 0.0F, a(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), this.jdField_b_of_type_Int, this.jdField_a_of_type_AndroidTextTextPaint);
      this.jdField_a_of_type_AndroidTextTextPaint.setXfermode(null);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-15322);
      paramCanvas.drawLine(a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), ((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(this.i)).intValue(), this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.restoreToCount(m);
      return;
      label434:
      this.jdField_a_of_type_AndroidTextTextPaint.setShadowLayer(0.0F, 0.0F, 0.0F, -1);
    }
  }
  
  public String[] a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString != null)
      {
        this.f = paramString.optInt("type", 0);
        this.jdField_b_of_type_JavaLangString = paramString.optString("first_line", "");
        this.jdField_c_of_type_JavaLangString = paramString.optString("second_line", "");
        this.jdField_d_of_type_JavaLangString = paramString.optString("font_path", "");
      }
      return new String[] { this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString };
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
  
  public String b()
  {
    return this.jdField_d_of_type_JavaLangString;
  }
  
  protected void b()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.ROUND);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-15322);
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setDither(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(-1);
    this.jdField_b_of_type_AndroidGraphicsTypeface = Typeface.createFromAsset(this.jdField_a_of_type_AndroidContentContext.getResources().getAssets(), "info_sticker_typeface/roboto-regular.ttf");
    if (new File(this.jdField_d_of_type_JavaLangString).exists()) {}
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_AndroidGraphicsTypeface = Typeface.createFromFile(this.jdField_d_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(a(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        Paint.FontMetrics localFontMetrics = this.jdField_a_of_type_AndroidTextTextPaint.getFontMetrics();
        this.jdField_d_of_type_Int = ((int)(localFontMetrics.bottom - localFontMetrics.top));
        this.jdField_c_of_type_Int = ((int)this.jdField_a_of_type_AndroidTextTextPaint.measureText(this.jdField_b_of_type_JavaLangString, 0, this.jdField_b_of_type_JavaLangString.length()));
        this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        localFontMetrics = this.jdField_a_of_type_AndroidTextTextPaint.getFontMetrics();
        this.h = ((int)(localFontMetrics.bottom - localFontMetrics.top));
        this.h = ((int)this.jdField_a_of_type_AndroidTextTextPaint.measureText(this.jdField_c_of_type_JavaLangString, 0, this.jdField_c_of_type_JavaLangString.length()));
        this.jdField_a_of_type_Int = (Math.max(this.jdField_c_of_type_Int, this.h) + a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        this.jdField_b_of_type_Int = (a(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources()) + a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()) + a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        this.i = this.jdField_a_of_type_Bpcg.a("lineHeight", 20L, 200L, 0, this.jdField_b_of_type_Int - a(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), new LinearInterpolator());
        this.j = this.jdField_a_of_type_Bpcg.a("offsetX", 180L, 330L, -this.jdField_a_of_type_Int, 0, new LinearInterpolator());
        return;
      }
      catch (Exception localException)
      {
        this.jdField_a_of_type_AndroidGraphicsTypeface = Typeface.DEFAULT_BOLD;
        continue;
      }
      this.jdField_a_of_type_AndroidGraphicsTypeface = Typeface.DEFAULT_BOLD;
    }
  }
  
  public int getIntrinsicHeight()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public int getIntrinsicWidth()
  {
    return this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpcu
 * JD-Core Version:    0.7.0.1
 */