import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class bnni
  extends bnmy
{
  private static int l = 30;
  private static int m = 30;
  private int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect(0, 0, 0, 0);
  private Typeface jdField_a_of_type_AndroidGraphicsTypeface;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
  private int jdField_b_of_type_Int;
  private Typeface jdField_b_of_type_AndroidGraphicsTypeface;
  private TextPaint jdField_b_of_type_AndroidTextTextPaint = new TextPaint();
  private String jdField_b_of_type_JavaLangString = "";
  private int jdField_c_of_type_Int;
  private Bitmap jdField_c_of_type_AndroidGraphicsBitmap;
  private String jdField_c_of_type_JavaLangString = "";
  private int jdField_d_of_type_Int;
  private Bitmap jdField_d_of_type_AndroidGraphicsBitmap;
  private String jdField_d_of_type_JavaLangString = amtj.a(2131714103);
  private int jdField_e_of_type_Int;
  private String jdField_e_of_type_JavaLangString = "SHENZHEN";
  private int h;
  private int i;
  private int j;
  private int k;
  private int n;
  private int o;
  private int p;
  private int q = 8;
  private int r = 4;
  private int s;
  private int t;
  private int u;
  private int v;
  
  public bnni(Context paramContext, String paramString)
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
      localJSONObject.put("iconpath", paramString1);
      localJSONObject.put("ttfpath", paramString2);
      localJSONObject.put("locationString", paramString3);
      paramString1 = localJSONObject.toString();
      if (QLog.isColorLevel()) {
        QLog.d("TriangleLocationStickerDrawble", 2, paramString1);
      }
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TriangleLocationStickerDrawble", 2, paramString1, new Object[0]);
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
    int i1 = 0;
    int i2 = ((Integer)paramArrayList.get(this.jdField_e_of_type_Int)).intValue();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(i2);
    i2 = ((Integer)paramArrayList.get(this.j)).intValue();
    if (i2 != 0)
    {
      i1 = (int)(i2 * this.jdField_d_of_type_Int / 100.0D);
      localRect1 = new Rect((this.jdField_d_of_type_Int - i1) / 2, 0, (this.jdField_d_of_type_Int + i1) / 2, this.v);
      Rect localRect2 = new Rect((this.jdField_a_of_type_Int - i1) / 2, l, (this.jdField_a_of_type_Int + i1) / 2, l + this.v);
      paramCanvas.drawBitmap(this.jdField_d_of_type_AndroidGraphicsBitmap, localRect1, localRect2, this.jdField_a_of_type_AndroidGraphicsPaint);
      i1 = ((Integer)paramArrayList.get(this.k)).intValue() + i1 / 2;
    }
    int i3 = ((Integer)paramArrayList.get(this.h)).intValue();
    i2 = i3;
    if (i3 == this.t) {
      i2 = ((Integer)paramArrayList.get(this.i)).intValue();
    }
    i2 = this.jdField_c_of_type_Int - i2 - this.n - a(1.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    i3 = this.jdField_a_of_type_Int / 2 - this.o - i1;
    i1 += this.jdField_a_of_type_Int / 2;
    paramArrayList = new Rect(i3, l + i2, this.o + i3, this.n + i2 + l);
    Rect localRect1 = new Rect(i1, l + i2, this.o + i1, i2 + this.n + l);
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsRect, paramArrayList, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    if (this.jdField_c_of_type_AndroidGraphicsBitmap != null) {
      paramCanvas.drawBitmap(this.jdField_c_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsRect, localRect1, this.jdField_a_of_type_AndroidGraphicsPaint);
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
        this.jdField_c_of_type_JavaLangString = paramString.optString("ttfpath", "");
        this.jdField_d_of_type_JavaLangString = paramString.optString("locationString", "");
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
    return this.jdField_c_of_type_JavaLangString;
  }
  
  protected void b()
  {
    int i3 = 0;
    this.jdField_d_of_type_JavaLangString = TroopBarPOI.b(this.jdField_d_of_type_JavaLangString);
    label129:
    label395:
    label440:
    int i1;
    int i2;
    Object localObject1;
    if ((this.jdField_d_of_type_JavaLangString == null) || (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)))
    {
      this.jdField_d_of_type_JavaLangString = amtj.a(2131714101);
      this.jdField_e_of_type_JavaLangString = "YOUR CITY";
      if ((this.jdField_e_of_type_JavaLangString == null) || (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))) {
        this.jdField_e_of_type_JavaLangString = "YOUR CITY";
      }
      l = a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      m = l;
      this.jdField_a_of_type_AndroidGraphicsTypeface = Typeface.createFromAsset(this.jdField_a_of_type_AndroidContentContext.getResources().getAssets(), "info_sticker_typeface/roboto-regular.ttf");
      if (!FileUtils.fileExists(this.jdField_c_of_type_JavaLangString)) {
        break label1272;
      }
      this.jdField_b_of_type_AndroidGraphicsTypeface = Typeface.createFromFile(this.jdField_c_of_type_JavaLangString);
      if (this.jdField_b_of_type_AndroidGraphicsTypeface == null) {
        this.jdField_b_of_type_AndroidGraphicsTypeface = Typeface.createFromAsset(this.jdField_a_of_type_AndroidContentContext.getResources().getAssets(), "info_sticker_typeface/roboto-regular.ttf");
      }
      this.p = a(24.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      this.r = a(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      this.q = a(4.5F, this.jdField_a_of_type_AndroidContentContext.getResources());
      this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
      this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      this.jdField_a_of_type_AndroidGraphicsPaint.setDither(true);
      this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
      this.jdField_a_of_type_AndroidTextTextPaint.setDither(true);
      this.jdField_a_of_type_AndroidTextTextPaint.setColor(-1);
      this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(this.jdField_b_of_type_AndroidGraphicsTypeface);
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(a(28.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      this.jdField_b_of_type_AndroidTextTextPaint.setAntiAlias(true);
      this.jdField_b_of_type_AndroidTextTextPaint.setDither(true);
      this.jdField_b_of_type_AndroidTextTextPaint.setColor(-1);
      this.jdField_b_of_type_AndroidTextTextPaint.setTypeface(this.jdField_a_of_type_AndroidGraphicsTypeface);
      this.jdField_b_of_type_AndroidTextTextPaint.setFakeBoldText(true);
      this.jdField_b_of_type_AndroidTextTextPaint.setTextSize(a(9.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      if (Build.VERSION.SDK_INT < 21) {
        break label1282;
      }
      this.jdField_a_of_type_AndroidTextTextPaint.setShadowLayer(bnmy.g, 0.0F, 0.0F, 1711276032);
      this.jdField_b_of_type_AndroidTextTextPaint.setShadowLayer(bnmy.g, 0.0F, 0.0F, 1711276032);
      if (Build.VERSION.SDK_INT >= 21)
      {
        this.jdField_a_of_type_AndroidTextTextPaint.setLetterSpacing(0.0F);
        this.jdField_b_of_type_AndroidTextTextPaint.setLetterSpacing(0.0F);
      }
      if (!FileUtils.fileExists(this.jdField_b_of_type_JavaLangString)) {
        break label1307;
      }
      this.jdField_c_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeFile(this.jdField_b_of_type_JavaLangString);
      if (this.jdField_c_of_type_AndroidGraphicsBitmap == null) {
        break label1408;
      }
      i1 = this.jdField_c_of_type_AndroidGraphicsBitmap.getWidth();
      i2 = this.jdField_c_of_type_AndroidGraphicsBitmap.getHeight();
      localObject1 = new Matrix();
      ((Matrix)localObject1).setRotate(180.0F, i1 / 2.0F, i2 / 2.0F);
      this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(this.jdField_c_of_type_AndroidGraphicsBitmap, 0, 0, i1, i2, (Matrix)localObject1, true);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect(0, 0, i1, i2);
      this.n = a(20.5F, this.jdField_a_of_type_AndroidContentContext.getResources());
      this.o = a(10.5F, this.jdField_a_of_type_AndroidContentContext.getResources());
      this.jdField_a_of_type_AndroidGraphicsRect.left = 0;
      this.jdField_a_of_type_AndroidGraphicsRect.top = 0;
      this.jdField_a_of_type_AndroidGraphicsRect.right = i1;
      this.jdField_a_of_type_AndroidGraphicsRect.bottom = i2;
      i1 = (int)this.jdField_a_of_type_AndroidTextTextPaint.measureText(this.jdField_d_of_type_JavaLangString) + this.r * (this.jdField_d_of_type_JavaLangString.length() - 1);
      int i4 = (int)this.jdField_b_of_type_AndroidTextTextPaint.measureText(this.jdField_e_of_type_JavaLangString) + this.q * (this.jdField_e_of_type_JavaLangString.length() - 1);
      if (i1 > i4) {}
      Object localObject2;
      for (this.jdField_d_of_type_Int = i1;; this.jdField_d_of_type_Int = i4)
      {
        this.jdField_a_of_type_Int = (this.jdField_d_of_type_Int + (this.o + this.p) * 2 + m * 2);
        localObject1 = this.jdField_a_of_type_AndroidTextTextPaint.getFontMetrics();
        localObject2 = this.jdField_b_of_type_AndroidTextTextPaint.getFontMetrics();
        this.s = (-(int)((Paint.FontMetrics)localObject1).top);
        i2 = -(int)((Paint.FontMetrics)localObject2).top;
        this.t = (a(33.0F, this.jdField_a_of_type_AndroidContentContext.getResources()) + a(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        this.u = (this.t - a(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        this.v = (this.s + i2 + a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        this.jdField_b_of_type_Int = (i2 + this.s + a(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources()) + l * 2);
        this.jdField_c_of_type_Int = (this.s + this.u + a(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        this.jdField_e_of_type_Int = this.jdField_a_of_type_Bnmo.a("T", 0L, 165L, 0, 255, new LinearInterpolator());
        this.h = this.jdField_a_of_type_Bnmo.a("X", 0L, 330L, 0, this.t, new DecelerateInterpolator());
        this.i = this.jdField_a_of_type_Bnmo.a("X", 330L, 340L, this.t, this.u, new AccelerateInterpolator());
        this.j = this.jdField_a_of_type_Bnmo.a("X", 825L, 200L, 0, 100, new DecelerateInterpolator());
        this.k = this.jdField_a_of_type_Bnmo.a("X", 825L, 355L, a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), a(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), new DecelerateInterpolator());
        if (this.jdField_d_of_type_AndroidGraphicsBitmap != null) {
          break label1407;
        }
        this.jdField_d_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(this.jdField_d_of_type_Int, this.v, Bitmap.Config.ARGB_8888);
        localObject1 = new Canvas(this.jdField_d_of_type_AndroidGraphicsBitmap);
        i2 = (this.jdField_d_of_type_Int - i1) / 2;
        i1 = 0;
        while (i1 < this.jdField_d_of_type_JavaLangString.length())
        {
          localObject2 = this.jdField_d_of_type_JavaLangString.substring(i1, i1 + 1);
          ((Canvas)localObject1).drawText((String)localObject2, i2, this.s, this.jdField_a_of_type_AndroidTextTextPaint);
          i2 = i2 + (int)this.jdField_a_of_type_AndroidTextTextPaint.measureText((String)localObject2) + this.r;
          i1 += 1;
        }
        this.jdField_e_of_type_JavaLangString = ChnToSpell.a(this.jdField_d_of_type_JavaLangString, 1);
        this.jdField_e_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString.toUpperCase();
        if ((this.jdField_d_of_type_JavaLangString == null) || (this.jdField_d_of_type_JavaLangString.contains(amtj.a(2131714105))) || (this.jdField_d_of_type_JavaLangString.contains(amtj.a(2131714104))) || (this.jdField_d_of_type_JavaLangString.endsWith(amtj.a(2131714099))) || (this.jdField_d_of_type_JavaLangString.endsWith(amtj.a(2131714100)))) {
          break;
        }
        this.jdField_d_of_type_JavaLangString += amtj.a(2131714102);
        break;
        label1272:
        this.jdField_b_of_type_AndroidGraphicsTypeface = Typeface.DEFAULT_BOLD;
        break label129;
        label1282:
        this.jdField_a_of_type_AndroidTextTextPaint.setShadowLayer(0.0F, 0.0F, 0.0F, -1);
        this.jdField_b_of_type_AndroidTextTextPaint.setShadowLayer(0.0F, 0.0F, 0.0F, -1);
        break label395;
        label1307:
        QLog.e("TriangleLocationStickerDrawble", 2, "mIconPath not exist");
        break label440;
      }
      i2 = (this.jdField_d_of_type_Int - i4) / 2;
      i1 = i3;
      while (i1 < this.jdField_e_of_type_JavaLangString.length())
      {
        localObject2 = this.jdField_e_of_type_JavaLangString.substring(i1, i1 + 1);
        ((Canvas)localObject1).drawText((String)localObject2, i2, this.v, this.jdField_b_of_type_AndroidTextTextPaint);
        i2 = i2 + (int)this.jdField_b_of_type_AndroidTextTextPaint.measureText((String)localObject2) + this.q;
        i1 += 1;
      }
      label1407:
      return;
      label1408:
      i2 = 0;
      i1 = 0;
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
 * Qualified Name:     bnni
 * JD-Core Version:    0.7.0.1
 */