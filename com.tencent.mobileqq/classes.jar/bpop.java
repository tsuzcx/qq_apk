import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class bpop
  extends bpoz
{
  private static int jdField_c_of_type_Int;
  private static int jdField_d_of_type_Int = 1;
  private static int jdField_e_of_type_Int = 2;
  private static int jdField_h_of_type_Int = 3;
  private static int jdField_i_of_type_Int = 4;
  private static int j = 5;
  private int A;
  private int B;
  private int C;
  private int D = 4;
  private int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Canvas jdField_a_of_type_AndroidGraphicsCanvas;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private Typeface jdField_a_of_type_AndroidGraphicsTypeface;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
  private int[] jdField_a_of_type_ArrayOfInt;
  private int jdField_b_of_type_Int;
  private Canvas jdField_b_of_type_AndroidGraphicsCanvas;
  private String jdField_b_of_type_JavaLangString;
  private int[] jdField_b_of_type_ArrayOfInt;
  private Bitmap jdField_c_of_type_AndroidGraphicsBitmap;
  private Canvas jdField_c_of_type_AndroidGraphicsCanvas;
  private String jdField_c_of_type_JavaLangString;
  private int[] jdField_c_of_type_ArrayOfInt;
  private Bitmap jdField_d_of_type_AndroidGraphicsBitmap;
  private Canvas jdField_d_of_type_AndroidGraphicsCanvas;
  private String jdField_d_of_type_JavaLangString;
  private Bitmap jdField_e_of_type_AndroidGraphicsBitmap;
  private String jdField_e_of_type_JavaLangString;
  private Bitmap f;
  private Bitmap g;
  private Bitmap jdField_h_of_type_AndroidGraphicsBitmap;
  private Bitmap jdField_i_of_type_AndroidGraphicsBitmap;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  private int q = 4;
  private int r = 1;
  private int s = 4;
  private int t = 22;
  private int u = 2;
  private int v = 73;
  private int w = 62;
  private int x;
  private int y;
  private int z;
  
  public bpop(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    a(this.jdField_a_of_type_JavaLangString);
    b();
    c();
  }
  
  private Matrix a(int paramInt)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.setValues(new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F });
    float[] arrayOfFloat = new float[8];
    arrayOfFloat[0] = 0.0F;
    arrayOfFloat[1] = 0.0F;
    arrayOfFloat[2] = this.v;
    arrayOfFloat[3] = 0.0F;
    arrayOfFloat[4] = this.v;
    arrayOfFloat[5] = this.w;
    arrayOfFloat[6] = 0.0F;
    arrayOfFloat[7] = this.w;
    if (paramInt >= 0) {
      if (paramInt < 50)
      {
        f1 = paramInt / 50.0F;
        i2 = this.v + (int)((this.m - this.v) * f1);
        paramInt = (this.k - i2) / 2;
        i1 = this.k / 2;
        i2 /= 2;
        i3 = this.k / 2;
        i4 = this.v / 2;
        i5 = this.k / 2;
        i6 = this.v / 2;
        i7 = (int)((1.0F - f1) * this.w);
        i7 = this.w - i7;
        i8 = this.w;
        f1 = paramInt;
        f2 = i7;
        f3 = i1 + i2;
        f4 = i7;
        f5 = i6 + i5;
        f6 = i8;
        f7 = i3 - i4;
        f8 = i8;
        paramInt = arrayOfFloat.length / 2;
        localMatrix.setPolyToPoly(arrayOfFloat, 0, new float[] { f1, f2, f3, f4, f5, f6, f7, f8 }, 0, paramInt);
      }
    }
    while (paramInt <= -50)
    {
      return localMatrix;
      i1 = paramInt;
      if (paramInt > 100) {
        i1 = 100;
      }
      f1 = (i1 - 50) / 50.0F;
      i2 = this.v + (int)((this.m - this.v) * (1.0D - f1));
      paramInt = (this.k - i2) / 2;
      i1 = this.k / 2;
      i2 /= 2;
      i3 = this.k / 2;
      i4 = this.v / 2;
      i5 = this.k / 2;
      i6 = this.v / 2;
      i7 = (int)(f1 * this.w);
      f1 = i3 - i4;
      f2 = 0;
      f3 = i6 + i5;
      f4 = 0;
      f5 = i1 + i2;
      f6 = i7;
      f7 = paramInt;
      f8 = i7;
      paramInt = arrayOfFloat.length / 2;
      localMatrix.setPolyToPoly(arrayOfFloat, 0, new float[] { f1, f2, f3, f4, f5, f6, f7, f8 }, 0, paramInt);
      return localMatrix;
    }
    float f1 = (paramInt + 50) / 50.0F;
    int i2 = this.n + (int)((this.v - this.n) * f1);
    paramInt = (this.k - i2) / 2;
    int i1 = this.k / 2;
    i2 /= 2;
    int i3 = this.k / 2;
    int i4 = this.v / 2;
    int i5 = this.k / 2;
    int i6 = this.v / 2;
    int i7 = (int)(f1 * this.w);
    i7 = this.w - i7;
    int i8 = this.w;
    f1 = paramInt;
    float f2 = i7;
    float f3 = i1 + i2;
    float f4 = i7;
    float f5 = i6 + i5;
    float f6 = i8;
    float f7 = i3 - i4;
    float f8 = i8;
    paramInt = arrayOfFloat.length / 2;
    localMatrix.setPolyToPoly(arrayOfFloat, 0, new float[] { f1, f2, f3, f4, f5, f6, f7, f8 }, 0, paramInt);
    return localMatrix;
  }
  
  public static String a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", paramInt);
      localJSONObject.put("upFilePath", paramString1);
      localJSONObject.put("downFilePath", paramString2);
      localJSONObject.put("nowHhmm", paramString3);
      localJSONObject.put("lastHhmm", paramString4);
      paramString1 = localJSONObject.toString();
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("CalendarTimeStickerDrawable", 2, paramString1, new Object[0]);
      }
    }
    return null;
  }
  
  private void a(String paramString, Canvas paramCanvas)
  {
    int i3 = 0;
    if (paramString.length() != 4) {
      return;
    }
    Object localObject = this.jdField_a_of_type_AndroidTextTextPaint.getFontMetrics();
    int i4 = (int)((Paint.FontMetrics)localObject).descent;
    int i5 = (int)((Paint.FontMetrics)localObject).top;
    int i6 = a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    localObject = new Rect(0, 0, 0, this.w);
    Rect localRect1 = new Rect(0, this.w + this.u, 0, this.w * 2 + this.u);
    int i2;
    int i1;
    if (this.jdField_d_of_type_AndroidGraphicsBitmap != null)
    {
      i2 = this.jdField_d_of_type_AndroidGraphicsBitmap.getWidth();
      i1 = this.jdField_d_of_type_AndroidGraphicsBitmap.getHeight();
    }
    for (;;)
    {
      Rect localRect2 = new Rect(0, 0, i2, i1);
      i1 = i3;
      while (i1 < 4)
      {
        String str = paramString.substring(i1, i1 + 1);
        i3 = (int)this.jdField_a_of_type_AndroidTextTextPaint.measureText(str);
        i2 = this.v;
        i3 = (this.v - i3) / 2;
        int i7 = (this.w + (i4 - i5 - i6)) / 2;
        ((Rect)localObject).left = (this.v * i1);
        ((Rect)localObject).right = (((Rect)localObject).left + this.v);
        if (this.jdField_d_of_type_AndroidGraphicsBitmap != null) {
          paramCanvas.drawBitmap(this.jdField_d_of_type_AndroidGraphicsBitmap, localRect2, (Rect)localObject, this.jdField_a_of_type_AndroidGraphicsPaint);
        }
        localRect1.left = ((Rect)localObject).left;
        localRect1.right = ((Rect)localObject).right;
        if (this.jdField_e_of_type_AndroidGraphicsBitmap != null) {
          paramCanvas.drawBitmap(this.jdField_e_of_type_AndroidGraphicsBitmap, localRect2, localRect1, this.jdField_a_of_type_AndroidGraphicsPaint);
        }
        paramCanvas.drawText(str, i3 + i2 * i1, i7, this.jdField_a_of_type_AndroidTextTextPaint);
        i1 += 1;
      }
      break;
      i1 = 0;
      i2 = 0;
    }
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void a()
  {
    int i1 = 0;
    if (this.jdField_d_of_type_JavaLangString.length() != 4) {
      this.jdField_d_of_type_JavaLangString = "0000";
    }
    if (this.jdField_e_of_type_JavaLangString.length() != 4) {
      this.jdField_e_of_type_JavaLangString = "0000";
    }
    this.r = 0;
    while (i1 < 4)
    {
      if (!this.jdField_d_of_type_JavaLangString.substring(i1, i1 + 1).equals(this.jdField_e_of_type_JavaLangString.substring(i1, i1 + 1))) {
        this.r += 1;
      }
      i1 += 1;
    }
    if (this.r == 0) {
      this.r = 1;
    }
  }
  
  protected void a(Canvas paramCanvas, ArrayList<Integer> paramArrayList)
  {
    int i4 = ((Integer)paramArrayList.get(this.z)).intValue();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(i4);
    int i2;
    int i1;
    label52:
    Rect localRect1;
    Rect localRect2;
    Rect localRect3;
    Rect localRect4;
    int i3;
    if (((Integer)paramArrayList.get(this.A)).intValue() >= 1000)
    {
      i2 = j;
      i1 = 0;
      if (i1 >= 4) {
        break label665;
      }
      localRect1 = new Rect(0, 0, 0, 0);
      localRect2 = new Rect(0, 0, 0, 0);
      localRect3 = new Rect(0, 0, 0, this.w);
      localRect4 = new Rect(0, this.w + this.u, 0, this.w * 2 + this.u);
      localRect1.top = (this.s + this.D);
      localRect1.bottom = (localRect1.top + this.w);
      i3 = 0;
      if (i1 > 1) {
        i3 = this.t - this.s;
      }
      localRect1.left = (i3 + (this.v + this.s) * i1 + this.D);
      localRect1.right = (localRect1.left + this.v);
      localRect3.left = (this.v * i1);
      localRect3.right = (localRect3.left + this.v);
      localRect2.top = (this.s + this.w + this.u + this.D);
      localRect2.bottom = (localRect2.top + this.w);
      localRect2.left = localRect1.left;
      localRect2.right = localRect1.right;
      localRect4.left = localRect3.left;
      localRect4.right = localRect3.right;
      i3 = 3 - i1;
      if (i2 != j) {
        break label464;
      }
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, localRect3, localRect1, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, localRect4, localRect2, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    for (;;)
    {
      i1 += 1;
      break label52;
      if (i4 < 255)
      {
        i2 = jdField_c_of_type_Int;
        break;
      }
      i1 = 1;
      i3 = 0;
      for (;;)
      {
        i2 = i1;
        if (i3 >= this.r) {
          break;
        }
        i2 = i1;
        if (((Integer)paramArrayList.get(this.jdField_b_of_type_ArrayOfInt[i3])).intValue() == 100) {
          i2 = i1 + 1;
        }
        i1 = i2;
        if (i2 == this.r + 1) {
          i1 = j;
        }
        i3 += 1;
      }
      label464:
      if (i2 == jdField_c_of_type_Int)
      {
        paramCanvas.drawBitmap(this.jdField_c_of_type_AndroidGraphicsBitmap, localRect3, localRect1, this.jdField_a_of_type_AndroidGraphicsPaint);
        paramCanvas.drawBitmap(this.jdField_c_of_type_AndroidGraphicsBitmap, localRect4, localRect2, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      else if (i2 - 1 < i3)
      {
        paramCanvas.drawBitmap(this.jdField_c_of_type_AndroidGraphicsBitmap, localRect3, localRect1, this.jdField_a_of_type_AndroidGraphicsPaint);
        paramCanvas.drawBitmap(this.jdField_c_of_type_AndroidGraphicsBitmap, localRect4, localRect2, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      else if (i2 - 1 > i3)
      {
        paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, localRect3, localRect1, this.jdField_a_of_type_AndroidGraphicsPaint);
        paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, localRect4, localRect2, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      else if (i2 - 1 == i3)
      {
        i3 = ((Integer)paramArrayList.get(this.jdField_c_of_type_ArrayOfInt[i3])).intValue();
        if (i3 > 0)
        {
          this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(i3);
          paramCanvas.drawBitmap(this.jdField_c_of_type_AndroidGraphicsBitmap, localRect4, localRect2, this.jdField_a_of_type_AndroidGraphicsPaint);
          this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(i4);
        }
      }
    }
    label665:
    if ((i2 != jdField_c_of_type_Int) && (i2 != j))
    {
      i3 = i2 - 1;
      i2 = 3 - i3;
      i1 = ((Integer)paramArrayList.get(this.jdField_a_of_type_ArrayOfInt[i3])).intValue();
      i3 = ((Integer)paramArrayList.get(this.jdField_b_of_type_ArrayOfInt[i3])).intValue();
      if (i1 > -50)
      {
        paramArrayList = a(i1);
        localRect1 = new Rect(0, 0, 0, this.w);
        localRect1.left = (this.v * i2);
        localRect1.right = (localRect1.left + this.v);
        int i5 = (int)((i1 + 50) * 255.0D / 50.0D);
        this.jdField_a_of_type_AndroidGraphicsCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        this.jdField_b_of_type_AndroidGraphicsCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        this.jdField_a_of_type_AndroidGraphicsCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, localRect1, new Rect(0, 0, this.v, this.w), this.jdField_a_of_type_AndroidGraphicsPaint);
        this.jdField_b_of_type_AndroidGraphicsCanvas.drawBitmap(this.jdField_f_of_type_AndroidGraphicsBitmap, paramArrayList, this.jdField_a_of_type_AndroidGraphicsPaint);
        paramArrayList = new Rect(0, 0, 0, 0);
        paramArrayList.top = (this.s + this.D);
        paramArrayList.bottom = (paramArrayList.top + this.w);
        i1 = 0;
        if (i2 > 1) {
          i1 = this.t - this.s;
        }
        paramArrayList.left = (i1 + (this.v + this.s) * i2 + this.D - this.q);
        paramArrayList.right = (paramArrayList.left + this.m);
        this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(i5);
        paramCanvas.drawBitmap(this.g, new Rect(0, 0, this.m, this.o), paramArrayList, this.jdField_a_of_type_AndroidGraphicsPaint);
        this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(i4);
      }
      if (i3 < 50)
      {
        paramArrayList = a(i3);
        localRect1 = new Rect(0, 0, 0, this.w);
        localRect1.left = (this.v * i2);
        localRect1.right = (localRect1.left + this.v);
        this.jdField_c_of_type_AndroidGraphicsCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        this.jdField_d_of_type_AndroidGraphicsCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        this.jdField_c_of_type_AndroidGraphicsCanvas.drawBitmap(this.jdField_c_of_type_AndroidGraphicsBitmap, localRect1, new Rect(0, 0, this.v, this.w), this.jdField_a_of_type_AndroidGraphicsPaint);
        this.jdField_d_of_type_AndroidGraphicsCanvas.drawBitmap(this.jdField_h_of_type_AndroidGraphicsBitmap, paramArrayList, this.jdField_a_of_type_AndroidGraphicsPaint);
        paramArrayList = new Rect(0, 0, 0, 0);
        paramArrayList.top = (this.s + this.D);
        paramArrayList.bottom = (paramArrayList.top + this.w);
        i1 = 0;
        if (i2 > 1) {
          i1 = this.t - this.s;
        }
        paramArrayList.left = (i1 + (this.v + this.s) * i2 + this.D - this.q);
        paramArrayList.right = (paramArrayList.left + this.m);
        paramCanvas.drawBitmap(this.jdField_i_of_type_AndroidGraphicsBitmap, new Rect(0, 0, this.m, this.o), paramArrayList, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      if (i3 > 50)
      {
        paramArrayList = a(i3);
        localRect1 = new Rect(0, this.w + this.u, 0, this.w * 2 + this.u);
        localRect1.left = (this.v * i2);
        localRect1.right = (localRect1.left + this.v);
        this.jdField_c_of_type_AndroidGraphicsCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        this.jdField_d_of_type_AndroidGraphicsCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        this.jdField_c_of_type_AndroidGraphicsCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, localRect1, new Rect(0, 0, this.v, this.w), this.jdField_a_of_type_AndroidGraphicsPaint);
        this.jdField_d_of_type_AndroidGraphicsCanvas.drawBitmap(this.jdField_h_of_type_AndroidGraphicsBitmap, paramArrayList, this.jdField_a_of_type_AndroidGraphicsPaint);
        paramArrayList = new Rect(0, 0, 0, 0);
        paramArrayList.top = (this.s + this.w + this.u + this.D);
        paramArrayList.bottom = (paramArrayList.top + this.w);
        i1 = 0;
        if (i2 > 1) {
          i1 = this.t - this.s;
        }
        paramArrayList.left = (i1 + i2 * (this.v + this.s) + this.D - this.q);
        paramArrayList.right = (paramArrayList.left + this.m);
        paramCanvas.drawBitmap(this.jdField_i_of_type_AndroidGraphicsBitmap, new Rect(0, 0, this.m, this.o), paramArrayList, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
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
        this.jdField_b_of_type_JavaLangString = paramString.optString("upFilePath", "");
        this.jdField_c_of_type_JavaLangString = paramString.optString("downFilePath", "");
        this.jdField_d_of_type_JavaLangString = paramString.optString("nowHhmm", "");
        this.jdField_e_of_type_JavaLangString = paramString.optString("lastHhmm", "");
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
    a();
    this.z = this.jdField_a_of_type_Bpon.a("alpha", 165L, 500, 0, 255, new LinearInterpolator());
    this.jdField_a_of_type_ArrayOfInt = new int[this.r];
    this.jdField_b_of_type_ArrayOfInt = new int[this.r];
    this.jdField_c_of_type_ArrayOfInt = new int[this.r];
    int i1 = 500;
    int i2 = 0;
    while (i2 < this.r)
    {
      this.jdField_a_of_type_ArrayOfInt[i2] = this.jdField_a_of_type_Bpon.a("alpha", i1, 500, -40, 0, new LinearInterpolator());
      this.jdField_b_of_type_ArrayOfInt[i2] = this.jdField_a_of_type_Bpon.a("frontFlip", i1, 500, 0, 100, new LinearInterpolator());
      this.jdField_c_of_type_ArrayOfInt[i2] = this.jdField_a_of_type_Bpon.a("groundOldFlip", i1, 500, 255, 0, new LinearInterpolator());
      QLog.e("CalendarTimeStickerDrawable", 2, "groundOldFlip[i]: " + this.jdField_c_of_type_ArrayOfInt[i2]);
      i2 += 1;
      i1 += 500;
    }
    this.B = i1;
    this.A = this.jdField_a_of_type_Bpon.a("alpha", 0L, this.B, 0, 100, new LinearInterpolator());
    this.jdField_a_of_type_AndroidGraphicsTypeface = Typeface.createFromAsset(this.jdField_a_of_type_AndroidContentContext.getResources().getAssets(), "info_sticker_typeface/roboto-medium.ttf");
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(a(60.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setDither(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(-1);
    this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(this.jdField_a_of_type_AndroidGraphicsTypeface);
    this.jdField_a_of_type_AndroidTextTextPaint.setAlpha(255);
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.jdField_a_of_type_AndroidTextTextPaint.setShadowLayer(bpoz.g, 0.0F, 0.0F, 1711276032);
      this.D = a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      this.s = a(1.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      this.t = a(11.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      this.u = a(1.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      this.v = a(36.5F, this.jdField_a_of_type_AndroidContentContext.getResources());
      this.w = a(31.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      this.q = a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      this.m = (this.v + this.q * 2);
      this.n = ((int)(this.v * 2.0D / 3.0D));
      this.o = this.w;
      this.p = 0;
      this.jdField_a_of_type_Int = (this.s * 4 + this.t + this.v * 4 + this.D * 2);
      this.jdField_b_of_type_Int = (this.s * 2 + this.u + this.w * 2 + this.D * 2);
      this.k = this.m;
      this.l = this.w;
      this.jdField_f_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(this.v, this.w, Bitmap.Config.ARGB_8888);
      this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas(this.jdField_f_of_type_AndroidGraphicsBitmap);
      this.g = Bitmap.createBitmap(this.k, this.l, Bitmap.Config.ARGB_8888);
      this.jdField_b_of_type_AndroidGraphicsCanvas = new Canvas(this.g);
      this.jdField_h_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(this.v, this.w, Bitmap.Config.ARGB_8888);
      this.jdField_c_of_type_AndroidGraphicsCanvas = new Canvas(this.jdField_h_of_type_AndroidGraphicsBitmap);
      this.jdField_i_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(this.k, this.l, Bitmap.Config.ARGB_8888);
      this.jdField_d_of_type_AndroidGraphicsCanvas = new Canvas(this.jdField_i_of_type_AndroidGraphicsBitmap);
      if (!bgmg.a(this.jdField_b_of_type_JavaLangString)) {
        break label937;
      }
      this.jdField_d_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeFile(this.jdField_b_of_type_JavaLangString);
      label768:
      if (!bgmg.a(this.jdField_c_of_type_JavaLangString)) {
        break label949;
      }
      this.jdField_e_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeFile(this.jdField_c_of_type_JavaLangString);
    }
    for (;;)
    {
      this.x = (this.v * 4);
      this.y = (this.w * 2 + this.u);
      this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(this.x, this.y, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
      a(this.jdField_d_of_type_JavaLangString, localCanvas);
      this.jdField_c_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(this.x, this.y, Bitmap.Config.ARGB_8888);
      localCanvas = new Canvas(this.jdField_c_of_type_AndroidGraphicsBitmap);
      a(this.jdField_e_of_type_JavaLangString, localCanvas);
      this.C = this.jdField_a_of_type_Bpon.a("X", 825L, 1000L, 0, 100, new DecelerateInterpolator());
      return;
      this.jdField_a_of_type_AndroidTextTextPaint.setShadowLayer(0.0F, 0.0F, 0.0F, -1);
      break;
      label937:
      QLog.e("CalendarTimeStickerDrawable", 2, "mUpFilePath not exist");
      break label768;
      label949:
      QLog.e("CalendarTimeStickerDrawable", 2, "mUpFilePath not exist");
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
 * Qualified Name:     bpop
 * JD-Core Version:    0.7.0.1
 */