import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.animation.DecelerateInterpolator;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class bkhs
  extends bkhx
{
  private static int e = 30;
  private static int h = 30;
  private int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect(0, 0, 0, 0);
  private Typeface jdField_a_of_type_AndroidGraphicsTypeface;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString = "";
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private int d;
  private int i;
  private int j;
  private int k = 16;
  private int l = 16;
  
  public bkhs(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    a(this.jdField_a_of_type_JavaLangString);
    b();
    c();
  }
  
  public static String a(int paramInt, String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", paramInt);
      localJSONObject.put("iconpath", paramString1);
      localJSONObject.put("locationString", paramString2);
      paramString1 = localJSONObject.toString();
      if (QLog.isColorLevel()) {
        QLog.d("ExpandLocationStickerDrawable", 2, paramString1);
      }
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ExpandLocationStickerDrawable", 2, paramString1, new Object[0]);
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
    int i1 = e + 0;
    int m = h;
    int i2 = ((Integer)paramArrayList.get(this.jdField_c_of_type_Int)).intValue();
    m += (this.jdField_c_of_type_JavaLangString.length() - 1) * (this.k - i2) / 2;
    int n = ((Integer)paramArrayList.get(this.d)).intValue();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(n);
    this.jdField_a_of_type_AndroidTextTextPaint.setAlpha(n);
    bkid.a(n, this.jdField_a_of_type_AndroidTextTextPaint);
    paramArrayList = new Rect(m, a(1.0F, this.jdField_a_of_type_AndroidContentContext.getResources()) + i1, this.j + m, this.i + i1 + a(1.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsRect, paramArrayList, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    n = this.j;
    n = this.l + (n + m);
    m = 0;
    while (m < this.jdField_c_of_type_JavaLangString.length())
    {
      paramArrayList = this.jdField_c_of_type_JavaLangString.substring(m, m + 1);
      paramCanvas.drawText(paramArrayList, n, this.i + i1, this.jdField_a_of_type_AndroidTextTextPaint);
      n = n + (int)this.jdField_a_of_type_AndroidTextTextPaint.measureText(paramArrayList) + i2;
      m += 1;
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
        this.jdField_b_of_type_JavaLangString = paramString.optString("iconpath", "");
        this.jdField_c_of_type_JavaLangString = paramString.optString("locationString", "");
      }
      return new String[] { this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString };
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
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(true);
    e = a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    h = e;
    this.l = a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setDither(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(-1);
    this.k = a(9.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.jdField_c_of_type_JavaLangString = TroopBarPOI.b(this.jdField_c_of_type_JavaLangString);
    Paint.FontMetrics localFontMetrics;
    label312:
    int n;
    int m;
    if ((this.jdField_c_of_type_JavaLangString != null) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)))
    {
      this.jdField_c_of_type_JavaLangString = ChnToSpell.a(this.jdField_c_of_type_JavaLangString, 1);
      this.jdField_c_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString.toUpperCase();
      this.jdField_a_of_type_AndroidGraphicsTypeface = Typeface.createFromAsset(this.jdField_a_of_type_AndroidContentContext.getResources().getAssets(), "info_sticker_typeface/roboto-regular.ttf");
      this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(this.jdField_a_of_type_AndroidGraphicsTypeface);
      this.jdField_a_of_type_AndroidTextTextPaint.setFakeBoldText(true);
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localFontMetrics = this.jdField_a_of_type_AndroidTextTextPaint.getFontMetrics();
      if (Build.VERSION.SDK_INT >= 21) {
        this.jdField_a_of_type_AndroidTextTextPaint.setLetterSpacing(0.0F);
      }
      this.jdField_c_of_type_Int = this.jdField_a_of_type_Bkhl.a("X", 190L, 630L, 0, this.k, new DecelerateInterpolator());
      this.d = this.jdField_a_of_type_Bkhl.a("T", 190L, 2110L, 0, 255, new DecelerateInterpolator());
      if (!bbdx.a(this.jdField_b_of_type_JavaLangString)) {
        break label494;
      }
      this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeFile(this.jdField_b_of_type_JavaLangString);
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        break label506;
      }
      n = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
      m = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect(0, 0, n, m);
      this.i = (-(int)localFontMetrics.ascent - (int)localFontMetrics.descent + a(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      if (m != 0) {
        this.j = (n * this.i / m);
      }
      this.jdField_b_of_type_Int = (this.i + e * 2);
      float f = this.jdField_a_of_type_AndroidTextTextPaint.measureText(this.jdField_c_of_type_JavaLangString);
      m = this.j;
      n = h;
      int i1 = this.l;
      this.jdField_a_of_type_Int = ((int)f + (m + n * 2 + i1) + this.k * (this.jdField_c_of_type_JavaLangString.length() - 1) + a(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      return;
      this.jdField_c_of_type_JavaLangString = "YOUR CITY";
      break;
      label494:
      QLog.e("ExpandLocationStickerDrawable", 2, "mIconPath not exist");
      break label312;
      label506:
      m = 0;
      n = 0;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkhs
 * JD-Core Version:    0.7.0.1
 */