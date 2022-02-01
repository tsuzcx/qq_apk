package com.tencent.aelight.camera.aioeditor.capture.text;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.text.InputFilter;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.DisplayUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FoldOverTextItem
  extends DynamicTextItem
{
  private static Method jdField_a_of_type_JavaLangReflectMethod;
  private static final int[] jdField_a_of_type_ArrayOfInt = { 5, 5, 5, 5 };
  private static final int jdField_e_of_type_Int;
  private static final float f;
  private float jdField_a_of_type_Float = 0.0F;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private Shader jdField_a_of_type_AndroidGraphicsShader;
  private InputFilter jdField_a_of_type_AndroidTextInputFilter = null;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint;
  private String jdField_a_of_type_JavaLangString = "";
  private List<Float> jdField_a_of_type_JavaUtilList;
  private float jdField_b_of_type_Float = 0.0F;
  private int jdField_b_of_type_Int = Color.parseColor("#ffa414");
  private float jdField_c_of_type_Float = 0.0F;
  private int jdField_c_of_type_Int = Color.parseColor("#ff1a14");
  private float jdField_d_of_type_Float = 0.0F;
  private int jdField_d_of_type_Int = Color.parseColor("#1f14ff");
  private float jdField_e_of_type_Float = 0.0F;
  
  static
  {
    Resources localResources = BaseApplicationImpl.getContext().getResources();
    f = AIOUtils.b(2.0F, localResources);
    int i = DisplayUtil.a();
    jdField_e_of_type_Int = localResources.getDisplayMetrics().widthPixels - TextLayer.a - i * 2;
  }
  
  public FoldOverTextItem(int paramInt, @NonNull List<String> paramList, Typeface paramTypeface, Bitmap paramBitmap)
  {
    super(paramInt, paramList);
    a(paramTypeface, paramBitmap);
    if (!paramList.isEmpty()) {
      a(0, (String)paramList.get(0));
    }
  }
  
  private CharSequence a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int m = 0;
    int j = 0;
    int i = 0;
    int k = 0;
    while (j < paramString.length())
    {
      if ((paramString.charAt(j) != '\n') && (paramString.charAt(j) != '\r') && (i < jdField_a_of_type_ArrayOfInt[k]))
      {
        localStringBuilder.append(paramString.charAt(j));
        i += 1;
      }
      else
      {
        localStringBuilder.append('\n');
        if ((paramString.charAt(j) != '\n') && (paramString.charAt(j) != '\r'))
        {
          localStringBuilder.append(paramString.charAt(j));
          i = 1;
        }
        else
        {
          i = 0;
        }
        int n = k + 1;
        k = n;
        if (n >= jdField_a_of_type_ArrayOfInt.length) {
          break;
        }
      }
      j += 1;
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    paramString = new SpannableString(localStringBuilder.toString());
    float f1 = 0.0F;
    j = 0;
    i = m;
    while (i < paramString.length())
    {
      if ((paramString.charAt(i) != '\n') && (paramString.charAt(i) != '\r'))
      {
        float f2 = (int)(this.jdField_a_of_type_Float + j * this.jdField_b_of_type_Float);
        paramString.setSpan(new AbsoluteSizeAndLineSpaceSpan(f2, 0.85F), i, i + 1, 17);
        f1 += f2;
        j += 1;
      }
      else
      {
        this.jdField_a_of_type_JavaUtilList.add(Float.valueOf(f1));
        f1 = 0.0F;
      }
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilList.add(Float.valueOf(f1));
    return paramString;
  }
  
  private void a(Typeface paramTypeface, Bitmap paramBitmap)
  {
    Resources localResources = BaseApplicationImpl.getContext().getResources();
    this.jdField_e_of_type_Float = (localResources.getDisplayMetrics().density * 2.0F);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Float = AIOUtils.b(25.0F, localResources);
    this.jdField_b_of_type_Float = AIOUtils.b(3.0F, localResources);
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_a_of_type_Float);
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    if (paramTypeface != null) {
      this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(paramTypeface);
    }
    if (Build.VERSION.SDK_INT >= 21) {}
    try
    {
      if (jdField_a_of_type_JavaLangReflectMethod == null) {
        jdField_a_of_type_JavaLangReflectMethod = Paint.class.getDeclaredMethod("setLetterSpacing", new Class[] { Float.TYPE });
      }
      if (jdField_a_of_type_JavaLangReflectMethod != null) {
        jdField_a_of_type_JavaLangReflectMethod.invoke(this.jdField_a_of_type_AndroidTextTextPaint, new Object[] { Float.valueOf(-0.09F) });
      }
    }
    catch (Exception paramTypeface)
    {
      label162:
      break label162;
    }
    if (paramBitmap != null)
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
      this.jdField_a_of_type_AndroidGraphicsShader = new BitmapShader(this.jdField_a_of_type_AndroidGraphicsBitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
    }
  }
  
  public float a()
  {
    return this.jdField_b_of_type_AndroidTextStaticLayout.getWidth() + this.jdField_e_of_type_Float * 3.0F;
  }
  
  public int a()
  {
    return 1;
  }
  
  public InputFilter a()
  {
    if (this.jdField_a_of_type_AndroidTextInputFilter == null) {
      this.jdField_a_of_type_AndroidTextInputFilter = new FoldOverTextItem.2(this, 20);
    }
    return this.jdField_a_of_type_AndroidTextInputFilter;
  }
  
  public void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    Object localObject1 = a(paramInt, new FoldOverTextItem.1(this));
    this.jdField_a_of_type_JavaLangString = ((String)localObject1);
    paramString = jdField_a_of_type_ArrayOfInt;
    int k = paramString.length;
    int j = 0;
    paramInt = 0;
    int i = 0;
    while (paramInt < k)
    {
      i += paramString[paramInt];
      paramInt += 1;
    }
    paramString = (String)localObject1;
    if (((String)localObject1).length() > i) {
      paramString = ((String)localObject1).substring(0, i);
    }
    localObject1 = a(paramString);
    Object localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
    for (float f1 = 0.0F; ((Iterator)localObject2).hasNext(); f1 = Math.max(((Float)((Iterator)localObject2).next()).floatValue(), f1)) {}
    f1 = Math.min(jdField_e_of_type_Int, f1);
    i = ((CharSequence)localObject1).length();
    localObject2 = this.jdField_a_of_type_AndroidTextTextPaint;
    paramInt = (int)f1;
    this.jdField_b_of_type_AndroidTextStaticLayout = StaticLayoutWithMaxLines.a((CharSequence)localObject1, 0, i, (TextPaint)localObject2, paramInt, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false, null, 0, jdField_a_of_type_ArrayOfInt.length);
    localObject1 = paramString;
    if (this.jdField_b_of_type_AndroidTextStaticLayout.getLineCount() == 4)
    {
      i = this.jdField_b_of_type_AndroidTextStaticLayout.getLineEnd(3);
      localObject1 = paramString;
      if (i > 0)
      {
        i = Math.min(i, paramString.length());
        localObject1 = paramString.substring(0, i);
        if ((!((String)localObject1).endsWith("\n")) && (!((String)localObject1).endsWith("\r"))) {
          localObject1 = paramString.substring(0, i);
        } else {
          localObject1 = paramString.substring(0, i - 1);
        }
      }
    }
    paramString = a((String)localObject1);
    this.jdField_b_of_type_AndroidTextStaticLayout = StaticLayoutWithMaxLines.a(paramString, 0, paramString.length(), this.jdField_a_of_type_AndroidTextTextPaint, paramInt, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false, null, 0, jdField_a_of_type_ArrayOfInt.length);
    this.jdField_c_of_type_Float = 0.0F;
    i = this.jdField_b_of_type_AndroidTextStaticLayout.getLineCount();
    paramInt = j;
    while (paramInt < i)
    {
      this.jdField_c_of_type_Float = Math.max(this.jdField_b_of_type_AndroidTextStaticLayout.getLineWidth(paramInt), this.jdField_c_of_type_Float);
      paramInt += 1;
    }
    f1 = this.jdField_b_of_type_AndroidTextStaticLayout.getHeight();
    float f2 = this.jdField_e_of_type_Float;
    this.jdField_d_of_type_Float = (f1 + 3.0F * f2);
    this.jdField_c_of_type_Float += f2 * 2.0F;
  }
  
  protected void a(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.translate(this.jdField_e_of_type_Float * 2.0F, 0.0F);
    paramCanvas.save();
    this.jdField_a_of_type_AndroidTextTextPaint.setStyle(Paint.Style.FILL);
    float f1 = this.jdField_e_of_type_Float;
    paramCanvas.translate(f1 * -2.0F, f1 * 3.0F);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(this.jdField_d_of_type_Int);
    this.jdField_b_of_type_AndroidTextStaticLayout.draw(paramCanvas);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(-16777216);
    this.jdField_a_of_type_AndroidTextTextPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidTextTextPaint.setStrokeWidth(2.0F);
    this.jdField_b_of_type_AndroidTextStaticLayout.draw(paramCanvas);
    paramCanvas.restore();
    paramCanvas.save();
    this.jdField_a_of_type_AndroidTextTextPaint.setStyle(Paint.Style.FILL);
    f1 = this.jdField_e_of_type_Float;
    paramCanvas.translate(-f1, f1 * 1.5F);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(this.jdField_c_of_type_Int);
    this.jdField_b_of_type_AndroidTextStaticLayout.draw(paramCanvas);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(-16777216);
    this.jdField_a_of_type_AndroidTextTextPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidTextTextPaint.setStrokeWidth(2.0F);
    this.jdField_b_of_type_AndroidTextStaticLayout.draw(paramCanvas);
    paramCanvas.restore();
    paramCanvas.save();
    this.jdField_a_of_type_AndroidTextTextPaint.setStyle(Paint.Style.FILL);
    paramCanvas.translate(0.0F, 0.0F);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(this.jdField_b_of_type_Int);
    this.jdField_b_of_type_AndroidTextStaticLayout.draw(paramCanvas);
    Object localObject = this.jdField_a_of_type_AndroidGraphicsShader;
    if (localObject != null)
    {
      this.jdField_a_of_type_AndroidTextTextPaint.setShader((Shader)localObject);
      this.jdField_b_of_type_AndroidTextStaticLayout.draw(paramCanvas);
      this.jdField_a_of_type_AndroidTextTextPaint.setShader(null);
    }
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(-16777216);
    this.jdField_a_of_type_AndroidTextTextPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidTextTextPaint.setStrokeWidth(2.0F);
    this.jdField_b_of_type_AndroidTextStaticLayout.draw(paramCanvas);
    int i = 0;
    if (b(0))
    {
      int j = this.jdField_b_of_type_AndroidTextStaticLayout.getLineCount();
      f1 = 0.0F;
      while (i < j)
      {
        f1 = Math.max(f1, this.jdField_b_of_type_AndroidTextStaticLayout.getLineWidth(i));
        i += 1;
      }
      float f4 = this.jdField_c_of_type_Float;
      f1 = this.jdField_b_of_type_AndroidTextStaticLayout.getHeight();
      float f2 = this.jdField_b_of_type_AndroidTextStaticLayout.getWidth() / 2.0F;
      localObject = this.jdField_a_of_type_AndroidGraphicsRectF;
      float f3 = this.jdField_e_of_type_Float;
      f4 /= 2.0F;
      float f5 = f;
      ((RectF)localObject).left = (-2.0F * f3 + f2 - f4 - f5);
      ((RectF)localObject).top = (0.0F - f5 * 3.0F);
      ((RectF)localObject).right = (f2 + f4 + f5 * 2.0F);
      ((RectF)localObject).bottom = (f1 + f3 * 3.0F + f5 * 2.0F);
      paramCanvas.drawRoundRect((RectF)localObject, 6.0F, 6.0F, a());
    }
    paramCanvas.restore();
    paramCanvas.restore();
  }
  
  public boolean a()
  {
    return true;
  }
  
  public float b()
  {
    return this.jdField_d_of_type_Float;
  }
  
  public boolean b()
  {
    return (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (super.b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.FoldOverTextItem
 * JD-Core Version:    0.7.0.1
 */