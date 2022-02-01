package com.tencent.aelight.camera.aioeditor.capture.text;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.InputFilter;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomSizeTextItem
  extends DynamicTextItem
{
  private float jdField_a_of_type_Float;
  Context jdField_a_of_type_AndroidContentContext;
  RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private InputFilter jdField_a_of_type_AndroidTextInputFilter = null;
  StaticLayout jdField_a_of_type_AndroidTextStaticLayout;
  TextPaint jdField_a_of_type_AndroidTextTextPaint;
  private String jdField_a_of_type_JavaLangString = "";
  Random jdField_a_of_type_JavaUtilRandom = new Random();
  public int[] a;
  public int b;
  private RectF b;
  
  public RandomSizeTextItem(Context paramContext, int paramInt, List<String> paramList, Typeface paramTypeface)
  {
    super(paramInt, paramList);
    this.jdField_a_of_type_ArrayOfInt = new int[] { 12, 20, 24 };
    this.jdField_b_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_Int = a(paramContext, 235.0F);
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(paramTypeface);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(AIOUtils.b(28.0F, paramContext.getResources()));
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(-1);
    if (!paramList.isEmpty()) {
      a(0, (String)paramList.get(0));
    }
  }
  
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat * paramContext.getResources().getDisplayMetrics().scaledDensity + 0.5F);
  }
  
  public float a()
  {
    StaticLayout localStaticLayout = this.jdField_a_of_type_AndroidTextStaticLayout;
    if (localStaticLayout != null) {
      return localStaticLayout.getWidth();
    }
    return 0.0F;
  }
  
  public int a()
  {
    return 1;
  }
  
  public InputFilter a()
  {
    if (this.jdField_a_of_type_AndroidTextInputFilter == null) {
      this.jdField_a_of_type_AndroidTextInputFilter = new RandomSizeTextItem.2(this, 20);
    }
    return this.jdField_a_of_type_AndroidTextInputFilter;
  }
  
  public CharSequence a(String[] paramArrayOfString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("“");
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      ((StringBuilder)localObject).append(paramArrayOfString[i]);
      i += 1;
    }
    ((StringBuilder)localObject).append("”");
    paramArrayOfString = a(paramArrayOfString);
    paramArrayOfString.add(0, Integer.valueOf(48));
    paramArrayOfString.add(Integer.valueOf(48));
    localObject = new SpannableString(((StringBuilder)localObject).toString());
    int k = ((SpannableString)localObject).length();
    for (i = 1; i < k - 1; i = j)
    {
      AbsoluteSizeSpan localAbsoluteSizeSpan = new AbsoluteSizeSpan(AIOUtils.b(((Integer)paramArrayOfString.get(i)).intValue(), this.jdField_a_of_type_AndroidContentContext.getResources()));
      j = i + 1;
      ((SpannableString)localObject).setSpan(localAbsoluteSizeSpan, i, j, 33);
    }
    return localObject;
  }
  
  public ArrayList<Integer> a(String[] paramArrayOfString)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject = this.jdField_a_of_type_ArrayOfInt;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      localArrayList2.add(Integer.valueOf(localObject[i]));
      i += 1;
    }
    Collections.shuffle(localArrayList2);
    int m = paramArrayOfString.length;
    i = 0;
    j = 0;
    while (i < m)
    {
      localObject = paramArrayOfString[i];
      Integer localInteger = (Integer)localArrayList2.get(j % localArrayList2.size());
      int n = ((String)localObject).length();
      int k = 0;
      while (k < n)
      {
        int i1 = ((String)localObject).charAt(k);
        if ((i1 != 8220) && (i1 != 8221)) {
          localArrayList1.add(localInteger);
        } else {
          localArrayList1.add(Integer.valueOf(48));
        }
        k += 1;
      }
      j += 1;
      i += 1;
    }
    return localArrayList1;
  }
  
  @TargetApi(18)
  public void a(int paramInt, String paramString)
  {
    int i = 0;
    if ((TextUtils.equals(super.a(0), paramString)) && (this.jdField_a_of_type_AndroidTextStaticLayout != null)) {
      return;
    }
    super.a(paramInt, paramString);
    paramString = super.a(paramInt, new RandomSizeTextItem.1(this));
    this.jdField_a_of_type_JavaLangString = paramString;
    paramString = a(a(paramString));
    this.jdField_a_of_type_AndroidTextStaticLayout = StaticLayoutWithMaxLines.a(paramString, 0, paramString.length(), this.jdField_a_of_type_AndroidTextTextPaint, this.jdField_b_of_type_Int, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false, null, 0, 3);
    if (this.jdField_a_of_type_AndroidTextStaticLayout.getLineCount() >= 3)
    {
      paramInt = this.jdField_a_of_type_AndroidTextStaticLayout.getLineEnd(2);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString.subSequence(0, paramInt - 1));
      localStringBuilder.append("”");
      paramString = localStringBuilder.toString();
      this.jdField_a_of_type_AndroidTextStaticLayout = StaticLayoutWithMaxLines.a(paramString, 0, paramString.length(), this.jdField_a_of_type_AndroidTextTextPaint, this.jdField_b_of_type_Int, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false, null, 0, 3);
    }
    int j = this.jdField_a_of_type_AndroidTextStaticLayout.getLineCount();
    float f = 0.0F;
    paramInt = i;
    while (paramInt < j)
    {
      f = Math.max(f, this.jdField_a_of_type_AndroidTextStaticLayout.getLineWidth(paramInt));
      paramInt += 1;
    }
    this.jdField_a_of_type_Float = f;
  }
  
  protected void a(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_AndroidTextStaticLayout != null)
    {
      paramCanvas.save();
      paramCanvas.translate(0.0F, 0.0F);
      this.jdField_a_of_type_AndroidTextStaticLayout.draw(paramCanvas);
      if (super.b(0))
      {
        int i = AIOUtils.b(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        RectF localRectF = this.jdField_b_of_type_AndroidGraphicsRectF;
        float f = i;
        localRectF.left = f;
        localRectF.top = (-i);
        localRectF.right = (a() + f);
        this.jdField_b_of_type_AndroidGraphicsRectF.bottom = (b() + f);
        paramCanvas.drawRoundRect(this.jdField_b_of_type_AndroidGraphicsRectF, 6.0F, 6.0F, a());
      }
      paramCanvas.restore();
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public String[] a(String paramString)
  {
    int k = paramString.length();
    int i = 0;
    int j = 0;
    if (k <= 7)
    {
      String[] arrayOfString2 = new String[k];
      for (i = j;; i = j)
      {
        arrayOfString1 = arrayOfString2;
        if (i >= k) {
          break;
        }
        j = i + 1;
        arrayOfString2[i] = paramString.substring(i, j);
      }
    }
    String[] arrayOfString1 = new String[7];
    int m;
    for (j = 0; i < 7; j = m)
    {
      m = this.jdField_a_of_type_JavaUtilRandom.nextInt(k - (7 - i) + 1) + 1;
      k -= m;
      m += j;
      arrayOfString1[i] = paramString.substring(j, m);
      i += 1;
    }
    return arrayOfString1;
  }
  
  public float b()
  {
    StaticLayout localStaticLayout = this.jdField_a_of_type_AndroidTextStaticLayout;
    if (localStaticLayout != null) {
      return localStaticLayout.getHeight();
    }
    return 0.0F;
  }
  
  public int b()
  {
    return 0;
  }
  
  public boolean b()
  {
    return (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (super.b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.RandomSizeTextItem
 * JD-Core Version:    0.7.0.1
 */