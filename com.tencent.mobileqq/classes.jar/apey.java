import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;

public class apey
  extends ImageSpan
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  public String a;
  
  public apey(Context paramContext, int paramInt, String paramString)
  {
    super(paramContext, paramInt, 1);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public apey(Context paramContext, int paramInt1, String paramString, int paramInt2)
  {
    super(paramContext, paramInt1, 1);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt2;
  }
  
  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    paramCharSequence = getDrawable();
    if (paramCharSequence == null) {
      return;
    }
    if (((paramCharSequence instanceof URLDrawable)) && (((URLDrawable)paramCharSequence).getStatus() == 1)) {
      paramCharSequence.setBounds(0, 0, paramCharSequence.getIntrinsicWidth() / 2, paramCharSequence.getIntrinsicHeight() / 2);
    }
    paramCanvas.save();
    paramCanvas.translate(paramFloat, (paramInt5 - paramInt3 - paramCharSequence.getBounds().bottom) / 2 + paramInt3);
    paramCharSequence.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  public Drawable getDrawable()
  {
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      if (this.jdField_a_of_type_Int > 0)
      {
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.jdField_a_of_type_Int;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.jdField_a_of_type_Int;
      }
      URLDrawable localURLDrawable = URLDrawable.getDrawable(this.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("UrlCenterImageSpan.getDrawable. url:").append(this.jdField_a_of_type_JavaLangString).append(" drawable:");
        if (localURLDrawable == null) {
          break label117;
        }
      }
      label117:
      for (localObject = localURLDrawable.getIntrinsicWidth() + "";; localObject = null)
      {
        QLog.e(".troop.send_gift", 2, (String)localObject);
        return localURLDrawable;
      }
    }
    return super.getDrawable();
  }
  
  public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    paramCharSequence = getDrawable();
    if (paramCharSequence == null) {
      return 0;
    }
    if (((paramCharSequence instanceof URLDrawable)) && (((URLDrawable)paramCharSequence).getStatus() == 1)) {
      paramCharSequence.setBounds(0, 0, paramCharSequence.getIntrinsicWidth() / 2, paramCharSequence.getIntrinsicHeight() / 2);
    }
    paramCharSequence = paramCharSequence.getBounds();
    if (paramFontMetricsInt != null)
    {
      paramPaint = paramPaint.getFontMetricsInt();
      paramInt2 = paramPaint.bottom - paramPaint.top;
      int i = paramCharSequence.bottom - paramCharSequence.top;
      paramInt1 = i / 2 - paramInt2 / 4;
      i /= 2;
      paramInt2 = paramInt2 / 4 + i;
      paramFontMetricsInt.ascent = (-paramInt2);
      paramFontMetricsInt.top = (-paramInt2);
      paramFontMetricsInt.bottom = paramInt1;
      paramFontMetricsInt.descent = paramInt1;
    }
    return paramCharSequence.right;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apey
 * JD-Core Version:    0.7.0.1
 */