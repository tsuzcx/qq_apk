import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.view.animation.LinearInterpolator;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class bpor
  extends bpoz
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private Path jdField_a_of_type_AndroidGraphicsPath = new Path();
  private PorterDuffXfermode jdField_a_of_type_AndroidGraphicsPorterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private Typeface jdField_a_of_type_AndroidGraphicsTypeface;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private Typeface jdField_b_of_type_AndroidGraphicsTypeface;
  private String jdField_b_of_type_JavaLangString = "27";
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString = "OCT";
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString = "2017";
  private int e;
  private int h;
  private int i;
  private int j;
  
  public bpor(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    a(this.jdField_a_of_type_JavaLangString);
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
      localJSONObject.put("third_line", paramString3);
      paramString1 = localJSONObject.toString();
      if (QLog.isColorLevel()) {
        QLog.d("EaseInInfoStickerDrawable", 2, paramString1);
      }
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("EaseInInfoStickerDrawable", 2, paramString1, new Object[0]);
        }
        paramString1 = null;
      }
    }
  }
  
  protected void a(Canvas paramCanvas, ArrayList<Integer> paramArrayList)
  {
    int k = 0 + a(8.5F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(this.jdField_a_of_type_AndroidGraphicsTypeface);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(a(49.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    float f = Math.abs(this.jdField_a_of_type_AndroidTextTextPaint.getFontMetrics().ascent);
    if (Build.VERSION.SDK_INT >= 21) {
      this.jdField_a_of_type_AndroidTextTextPaint.setLetterSpacing(0.0F);
    }
    this.jdField_b_of_type_Float = this.jdField_a_of_type_AndroidTextTextPaint.measureText(this.jdField_b_of_type_JavaLangString, 0, this.jdField_b_of_type_JavaLangString.length());
    this.jdField_a_of_type_AndroidTextTextPaint.setAlpha(((Integer)paramArrayList.get(this.jdField_c_of_type_Int)).intValue());
    bppf.a(((Integer)paramArrayList.get(this.jdField_c_of_type_Int)).intValue(), this.jdField_a_of_type_AndroidTextTextPaint);
    paramCanvas.drawText(this.jdField_b_of_type_JavaLangString, 0, this.jdField_b_of_type_JavaLangString.length(), (this.jdField_a_of_type_AndroidGraphicsRect.width() - this.jdField_b_of_type_Float) / 2.0F, f + k, this.jdField_a_of_type_AndroidTextTextPaint);
    int m = a(49.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    k = a(12.5F, this.jdField_a_of_type_AndroidContentContext.getResources()) + (m + k);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    paramCanvas.drawLine(this.jdField_a_of_type_Float, k, this.jdField_a_of_type_Float + ((Integer)paramArrayList.get(this.jdField_d_of_type_Int)).intValue(), k, this.jdField_a_of_type_AndroidGraphicsPaint);
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (((Integer)paramArrayList.get(this.jdField_d_of_type_Int)).intValue() == (int)(this.jdField_a_of_type_AndroidGraphicsRect.width() - this.jdField_a_of_type_Float * 2.0F)) {
        this.jdField_a_of_type_AndroidGraphicsPaint.setShadowLayer(1.0F, 1.0F, 1.0F, -1728053248);
      }
    }
    else
    {
      k += a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(a(19.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      f = Math.abs(this.jdField_a_of_type_AndroidTextTextPaint.getFontMetrics().ascent);
      if (Build.VERSION.SDK_INT >= 21) {
        this.jdField_a_of_type_AndroidTextTextPaint.setLetterSpacing(0.1F);
      }
      this.jdField_b_of_type_Float = this.jdField_a_of_type_AndroidTextTextPaint.measureText(this.jdField_c_of_type_JavaLangString, 0, this.jdField_c_of_type_JavaLangString.length());
      this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(this.jdField_b_of_type_AndroidGraphicsTypeface);
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(a(19.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      this.jdField_a_of_type_AndroidTextTextPaint.setAlpha(((Integer)paramArrayList.get(this.e)).intValue());
      bppf.a(((Integer)paramArrayList.get(this.e)).intValue(), this.jdField_a_of_type_AndroidTextTextPaint);
      paramCanvas.drawText(this.jdField_c_of_type_JavaLangString, 0, this.jdField_c_of_type_JavaLangString.length(), (this.jdField_a_of_type_AndroidGraphicsRect.width() - this.jdField_b_of_type_Float) / 2.0F, f + k, this.jdField_a_of_type_AndroidTextTextPaint);
      m = a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      int n = a(9.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(this.jdField_b_of_type_AndroidGraphicsTypeface);
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(a(19.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      f = Math.abs(this.jdField_a_of_type_AndroidTextTextPaint.getFontMetrics().ascent);
      if (Build.VERSION.SDK_INT >= 21) {
        this.jdField_a_of_type_AndroidTextTextPaint.setLetterSpacing(0.0F);
      }
      this.jdField_b_of_type_Float = this.jdField_a_of_type_AndroidTextTextPaint.measureText(this.jdField_d_of_type_JavaLangString, 0, this.jdField_d_of_type_JavaLangString.length());
      this.jdField_a_of_type_AndroidTextTextPaint.setAlpha(((Integer)paramArrayList.get(this.h)).intValue());
      bppf.a(((Integer)paramArrayList.get(this.h)).intValue(), this.jdField_a_of_type_AndroidTextTextPaint);
      paramCanvas.drawText(this.jdField_d_of_type_JavaLangString, 0, this.jdField_d_of_type_JavaLangString.length(), (this.jdField_a_of_type_AndroidGraphicsRect.width() - this.jdField_b_of_type_Float) / 2.0F, m + k + n + f, this.jdField_a_of_type_AndroidTextTextPaint);
      k = paramCanvas.saveLayer(0.0F, 0.0F, this.jdField_a_of_type_AndroidGraphicsRect.width(), this.jdField_a_of_type_AndroidGraphicsRect.height(), this.jdField_a_of_type_AndroidGraphicsPaint, 31);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(a(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(this.jdField_a_of_type_AndroidGraphicsPorterDuffXfermode);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-65536);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(a(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL_AND_STROKE);
      this.jdField_a_of_type_AndroidGraphicsPath.reset();
      this.jdField_a_of_type_AndroidGraphicsPath.moveTo(this.jdField_a_of_type_AndroidGraphicsRect.width(), this.jdField_a_of_type_AndroidGraphicsRect.height());
      this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.jdField_a_of_type_AndroidGraphicsRect.width(), ((Integer)paramArrayList.get(this.j)).intValue());
      this.jdField_a_of_type_AndroidGraphicsPath.lineTo(((Integer)paramArrayList.get(this.i)).intValue(), this.jdField_a_of_type_AndroidGraphicsRect.height());
      this.jdField_a_of_type_AndroidGraphicsPath.close();
      if (Build.VERSION.SDK_INT >= 21)
      {
        if ((this.jdField_a_of_type_AndroidGraphicsRect.width() != this.i) || (this.jdField_a_of_type_AndroidGraphicsRect.height() != this.j)) {
          break label1064;
        }
        this.jdField_a_of_type_AndroidGraphicsPaint.setShadowLayer(1.0F, 1.0F, 1.0F, -1728053248);
      }
    }
    for (;;)
    {
      paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(null);
      paramCanvas.restoreToCount(k);
      return;
      this.jdField_a_of_type_AndroidGraphicsPaint.setShadowLayer(0.0F, 0.0F, 0.0F, -1);
      break;
      label1064:
      this.jdField_a_of_type_AndroidGraphicsPaint.setShadowLayer(0.0F, 0.0F, 0.0F, -1);
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
        this.jdField_d_of_type_JavaLangString = paramString.optString("third_line", "");
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
  
  protected void b()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setDither(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(-1);
    this.jdField_a_of_type_Int = a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.jdField_b_of_type_Int = a(130.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect(0, 0, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    try
    {
      this.jdField_a_of_type_AndroidGraphicsTypeface = Typeface.createFromAsset(this.jdField_a_of_type_AndroidContentContext.getResources().getAssets(), "info_sticker_typeface/roboto-medium.ttf");
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          this.jdField_b_of_type_AndroidGraphicsTypeface = Typeface.createFromAsset(this.jdField_a_of_type_AndroidContentContext.getResources().getAssets(), "info_sticker_typeface/roboto-regular.ttf");
          this.i = this.jdField_a_of_type_Bpon.a("X", 0L, 700L, -this.jdField_a_of_type_AndroidGraphicsRect.width(), this.jdField_a_of_type_AndroidGraphicsRect.width(), new LinearInterpolator());
          this.j = this.jdField_a_of_type_Bpon.a("Y", 0L, 700L, -this.jdField_a_of_type_AndroidGraphicsRect.height(), this.jdField_a_of_type_AndroidGraphicsRect.height(), new LinearInterpolator());
          this.jdField_c_of_type_Int = this.jdField_a_of_type_Bpon.a("firstFont", 500L, 200L, 0, 255, new LinearInterpolator());
          this.jdField_a_of_type_Float = a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          this.jdField_d_of_type_Int = this.jdField_a_of_type_Bpon.a("secondLine", 600L, 400L, 0, (int)(this.jdField_a_of_type_AndroidGraphicsRect.width() - 2.0F * this.jdField_a_of_type_Float), new LinearInterpolator());
          this.e = this.jdField_a_of_type_Bpon.a("thirdFont", 800L, 500L, 0, 255, new LinearInterpolator());
          this.h = this.jdField_a_of_type_Bpon.a("fourthFont", 900L, 500L, 0, 255, new LinearInterpolator());
          return;
          localException1 = localException1;
          this.jdField_a_of_type_AndroidGraphicsTypeface = Typeface.DEFAULT;
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          this.jdField_b_of_type_AndroidGraphicsTypeface = Typeface.DEFAULT;
        }
      }
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
 * Qualified Name:     bpor
 * JD-Core Version:    0.7.0.1
 */