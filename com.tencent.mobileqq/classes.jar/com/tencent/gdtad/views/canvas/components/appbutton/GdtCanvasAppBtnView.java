package com.tencent.gdtad.views.canvas.components.appbutton;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.gdtad.views.xijing.GdtButtonData;
import com.tencent.gdtad.views.xijing.GdtTextData;
import yny;
import ypk;

public class GdtCanvasAppBtnView
  extends TextView
{
  protected float a;
  protected int a;
  protected Paint a;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private String jdField_a_of_type_JavaLangString = " ";
  private boolean jdField_a_of_type_Boolean;
  protected float b;
  private int jdField_b_of_type_Int;
  protected Paint b;
  private Rect jdField_b_of_type_AndroidGraphicsRect = new Rect();
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  
  public GdtCanvasAppBtnView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 100;
  }
  
  public GdtCanvasAppBtnView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 100;
  }
  
  public float a()
  {
    return this.jdField_b_of_type_Float;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    setTextColor(this.jdField_b_of_type_Int);
    setBackgroundColor(this.c);
  }
  
  @TargetApi(16)
  void a(Context paramContext, GdtCanvasAppBtnComponentData paramGdtCanvasAppBtnComponentData)
  {
    if ((paramGdtCanvasAppBtnComponentData == null) || (!paramGdtCanvasAppBtnComponentData.isValid()))
    {
      yny.d("GdtAppBtnUIPresenter", "init error");
      return;
    }
    try
    {
      this.jdField_a_of_type_JavaLangString = paramGdtCanvasAppBtnComponentData.button.text.text;
      this.d = paramGdtCanvasAppBtnComponentData.button.text.size;
      this.c = paramGdtCanvasAppBtnComponentData.button.backgroundColor;
      this.jdField_b_of_type_Int = paramGdtCanvasAppBtnComponentData.button.text.color;
      this.e = paramGdtCanvasAppBtnComponentData.width;
      int i = paramGdtCanvasAppBtnComponentData.height;
      setSingleLine(false);
      setLines(1);
      setGravity(17);
      setEllipsize(TextUtils.TruncateAt.END);
      int j = ypk.a(5.0F, paramContext.getResources());
      setPadding(j, 0, j, 0);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        setText(this.jdField_a_of_type_JavaLangString);
      }
      if (this.d > 0) {
        setTextSize(0, this.d);
      }
      a();
      this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
      this.jdField_b_of_type_AndroidGraphicsPaint.setTextSize(this.d);
      this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(2.0F);
      this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.jdField_b_of_type_Int);
      this.jdField_b_of_type_AndroidGraphicsPaint.setTextAlign(Paint.Align.LEFT);
      this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(2.0F);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.c);
      this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(this.d);
      this.jdField_a_of_type_AndroidGraphicsPaint.setTextAlign(Paint.Align.LEFT);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      paramContext = this.jdField_a_of_type_AndroidGraphicsPaint.getFontMetricsInt();
      this.f = ((i - paramContext.bottom + paramContext.top) / 2 - paramContext.top);
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_Float == 0.0F) {
        this.jdField_a_of_type_Float = (getWidth() / this.jdField_a_of_type_Int);
      }
      this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, (int)(this.jdField_a_of_type_Float * this.jdField_b_of_type_Float), getHeight());
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, this.g, this.f, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.save();
      paramCanvas.clipRect(this.jdField_a_of_type_AndroidGraphicsRect);
      paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, this.g, this.f, this.jdField_b_of_type_AndroidGraphicsPaint);
      paramCanvas.restore();
      this.jdField_a_of_type_AndroidGraphicsRect.set(2, 2, getWidth() - 2, getHeight() - 2);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    super.onDraw(paramCanvas);
  }
  
  public void setDownloadingUI(String paramString)
  {
    this.jdField_a_of_type_Boolean = true;
    setText("");
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      this.jdField_a_of_type_JavaLangString = paramString;
      setBackgroundColor(this.jdField_b_of_type_Int);
      this.jdField_a_of_type_AndroidGraphicsPaint.getTextBounds(paramString, 0, paramString.length(), this.jdField_b_of_type_AndroidGraphicsRect);
      this.g = (this.e / 2 - this.jdField_b_of_type_AndroidGraphicsRect.width() / 2);
      if (this.g < 0) {
        this.g = 0;
      }
      float f1 = this.jdField_b_of_type_AndroidGraphicsRect.width();
      if ((this.e > 0) && (f1 > this.e))
      {
        int i = this.jdField_a_of_type_AndroidGraphicsPaint.breakText(paramString, 0, paramString.length(), true, this.e, null);
        if (i >= 3) {
          this.jdField_a_of_type_JavaLangString = (paramString.substring(0, i - 3) + "...");
        }
      }
      return;
    }
    catch (Exception paramString)
    {
      yny.d("GdtAppBtnUIPresenter", "setDownloadingUI error", paramString);
    }
  }
  
  public void setProgress(int paramInt)
  {
    this.jdField_b_of_type_Float = paramInt;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.appbutton.GdtCanvasAppBtnView
 * JD-Core Version:    0.7.0.1
 */