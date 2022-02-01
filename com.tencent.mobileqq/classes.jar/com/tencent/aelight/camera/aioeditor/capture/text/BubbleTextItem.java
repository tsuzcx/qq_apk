package com.tencent.aelight.camera.aioeditor.capture.text;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;

public class BubbleTextItem
  extends DynamicTextItem
{
  private static final int jdField_b_of_type_Int = AIOUtils.b(20.0F, BaseApplicationImpl.getContext().getResources());
  private static final int c = AIOUtils.b(12.0F, BaseApplicationImpl.getContext().getResources());
  float jdField_a_of_type_Float;
  private NinePatch jdField_a_of_type_AndroidGraphicsNinePatch;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private StaticLayout jdField_a_of_type_AndroidTextStaticLayout;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
  float jdField_b_of_type_Float;
  private RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  
  public BubbleTextItem(int paramInt, List<String> paramList, Typeface paramTypeface, Bitmap paramBitmap)
  {
    super(paramInt, paramList);
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(paramTypeface);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(AIOUtils.b(20.0F, BaseApplicationImpl.getContext().getResources()));
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(-16777216);
    this.jdField_a_of_type_AndroidGraphicsNinePatch = new NinePatch(paramBitmap, paramBitmap.getNinePatchChunk(), null);
    if (!paramList.isEmpty()) {
      a(0, (String)paramList.get(0));
    }
  }
  
  public float a()
  {
    return this.jdField_a_of_type_AndroidGraphicsRectF.width() + 20.0F;
  }
  
  public int a()
  {
    return 1;
  }
  
  public void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    Object localObject = super.b(paramInt);
    paramString = (String)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramString = "　　";
    }
    int i = (int)this.jdField_a_of_type_AndroidTextTextPaint.measureText(HardCodeUtil.a(2131701434));
    paramInt = 0;
    this.jdField_a_of_type_AndroidTextStaticLayout = StaticLayoutWithMaxLines.a(paramString, 0, paramString.length(), this.jdField_a_of_type_AndroidTextTextPaint, i, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false, null, 0, 3);
    int j = this.jdField_a_of_type_AndroidTextStaticLayout.getLineCount();
    float f1 = 0.0F;
    while (paramInt < j)
    {
      f1 = Math.max(f1, this.jdField_a_of_type_AndroidTextStaticLayout.getLineWidth(paramInt));
      paramInt += 1;
    }
    float f2 = this.jdField_a_of_type_AndroidTextStaticLayout.getHeight();
    float f3 = Math.max(this.jdField_a_of_type_AndroidGraphicsNinePatch.getWidth(), c + jdField_b_of_type_Int + f1);
    float f4 = this.jdField_a_of_type_AndroidGraphicsNinePatch.getHeight();
    this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, f3, f4 * 0.7F + f2);
    this.jdField_a_of_type_Float = f1;
    this.jdField_b_of_type_Float = f2;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("set text ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" max ");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(" tw ");
    ((StringBuilder)localObject).append(f1);
    ((StringBuilder)localObject).append(" th ");
    ((StringBuilder)localObject).append(f2);
    SLog.b("BubbleTextItem", ((StringBuilder)localObject).toString());
  }
  
  public void a(Canvas paramCanvas)
  {
    paramCanvas.translate(10.0F, 10.0F);
    this.jdField_a_of_type_AndroidGraphicsNinePatch.draw(paramCanvas, this.jdField_a_of_type_AndroidGraphicsRectF);
    paramCanvas.translate(jdField_b_of_type_Int, this.jdField_a_of_type_AndroidGraphicsNinePatch.getHeight() * 0.4F);
    this.jdField_a_of_type_AndroidTextStaticLayout.draw(paramCanvas);
    if (super.b(0))
    {
      float f1 = this.jdField_a_of_type_AndroidTextStaticLayout.getHeight();
      float f2 = super.a(this.jdField_a_of_type_AndroidTextStaticLayout);
      RectF localRectF = this.jdField_b_of_type_AndroidGraphicsRectF;
      localRectF.left = 0.0F;
      localRectF.top = 0.0F;
      localRectF.right = f2;
      localRectF.bottom = f1;
      paramCanvas.drawRoundRect(localRectF, 6.0F, 6.0F, a());
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public float b()
  {
    return this.jdField_a_of_type_AndroidGraphicsRectF.height() + 20.0F;
  }
  
  public int b()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.BubbleTextItem
 * JD-Core Version:    0.7.0.1
 */