import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint.FontMetrics;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.view.animation.LinearInterpolator;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class bkhv
  extends bkhx
{
  int jdField_a_of_type_Int = 0;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
  int jdField_b_of_type_Int = 0;
  private String jdField_b_of_type_JavaLangString = "15:29";
  int c = 0;
  int d = 0;
  int e;
  
  public bkhv(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    a(paramString);
    b();
    c();
  }
  
  public static String a(int paramInt, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", paramInt);
      localJSONObject.put("first_line", paramString);
      paramString = localJSONObject.toString();
      if (QLog.isColorLevel()) {
        QLog.d("FilmDigitInfoStickerDrawable", 2, paramString);
      }
      return paramString;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FilmDigitInfoStickerDrawable", 2, paramString, new Object[0]);
        }
        paramString = null;
      }
    }
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  protected void a(Canvas paramCanvas, ArrayList<Integer> paramArrayList)
  {
    int i = paramCanvas.saveLayer(0.0F, 0.0F, getIntrinsicWidth(), getIntrinsicWidth(), this.jdField_a_of_type_AndroidTextTextPaint, 31);
    int j = a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    float f1 = Math.abs(this.jdField_a_of_type_AndroidTextTextPaint.getFontMetrics().ascent);
    float f2 = ((Integer)paramArrayList.get(this.e)).intValue() % 100 * 1.0F / 99.0F;
    this.jdField_a_of_type_AndroidTextTextPaint.setShadowLayer(f2 * 20.0F, 0.0F, 0.0F, this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165570));
    paramCanvas.drawText(this.jdField_b_of_type_JavaLangString, a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), j + f1, this.jdField_a_of_type_AndroidTextTextPaint);
    paramCanvas.restoreToCount(i);
  }
  
  public String[] a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString != null)
      {
        this.f = paramString.optInt("type", 0);
        String str = paramString.optString("first_line", "");
        paramString = str;
        if (str.contains("·")) {
          paramString = str.substring(0, str.indexOf("·"));
        }
        this.jdField_b_of_type_JavaLangString = ChnToSpell.a(paramString, 1);
      }
      return new String[] { this.jdField_b_of_type_JavaLangString };
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
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setDither(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165569));
    Object localObject = Typeface.createFromAsset(this.jdField_a_of_type_AndroidContentContext.getResources().getAssets(), "info_sticker_typeface/dov_digital.ttf");
    this.jdField_a_of_type_AndroidTextTextPaint.setTypeface((Typeface)localObject);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(a(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    localObject = this.jdField_a_of_type_AndroidTextTextPaint.getFontMetrics();
    this.d = ((int)(((Paint.FontMetrics)localObject).bottom - ((Paint.FontMetrics)localObject).top));
    this.c = ((int)this.jdField_a_of_type_AndroidTextTextPaint.measureText(this.jdField_b_of_type_JavaLangString, 0, this.jdField_b_of_type_JavaLangString.length()));
    this.jdField_a_of_type_Int = (this.c + a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    this.jdField_b_of_type_Int = (a(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources()) + a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    this.e = this.jdField_a_of_type_Bkhl.a("anim", 0L, 1000L, 0, 999, new LinearInterpolator());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkhv
 * JD-Core Version:    0.7.0.1
 */