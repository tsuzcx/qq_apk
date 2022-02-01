import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.text.style.ImageSpan;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class axab
  extends ImageSpan
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<Drawable.Callback> jdField_a_of_type_MqqUtilWeakReference;
  
  public axab(Context paramContext, int paramInt1, String paramString, int paramInt2, Drawable.Callback paramCallback)
  {
    super(paramContext, paramInt1, 0);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt2;
    if (paramCallback != null) {
      this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramCallback);
    }
  }
  
  public axab(Context paramContext, int paramInt, String paramString, Drawable.Callback paramCallback)
  {
    this(paramContext, paramInt, paramString, 0, paramCallback);
  }
  
  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    paramCharSequence = getDrawable();
    if (paramCharSequence == null) {
      return;
    }
    if ((paramCharSequence instanceof URLDrawable))
    {
      paramInt2 = 0;
      paramInt1 = 0;
      if (((URLDrawable)paramCharSequence).getStatus() == 1)
      {
        paramInt4 = paramCharSequence.getIntrinsicWidth();
        i = paramCharSequence.getIntrinsicHeight();
        paramInt1 = i;
        paramInt2 = paramInt4;
        if (i > this.jdField_a_of_type_Int)
        {
          paramInt1 = i;
          paramInt2 = paramInt4;
          if (this.jdField_a_of_type_Int > 0)
          {
            paramInt2 = paramInt4 * this.jdField_a_of_type_Int / i;
            paramInt1 = this.jdField_a_of_type_Int;
          }
        }
        paramPaint = this.jdField_a_of_type_ComTencentImageURLDrawable;
        if (paramInt2 <= 0) {
          break label221;
        }
        paramInt4 = paramInt2;
        if (paramInt1 <= 0) {
          break label227;
        }
      }
    }
    label221:
    label227:
    for (int i = paramInt1;; i = 0)
    {
      paramPaint.setBounds(0, 0, paramInt4, i);
      if (QLog.isColorLevel()) {
        QLog.i("UrlBottomImageSpan", 2, "draw status:" + ((URLDrawable)paramCharSequence).getStatus() + " width:" + paramInt2 + " height:" + paramInt1);
      }
      paramCanvas.save();
      paramCanvas.translate(paramFloat, (paramInt5 - paramInt3 - paramCharSequence.getBounds().bottom) / 2 + paramInt3);
      paramCharSequence.draw(paramCanvas);
      paramCanvas.restore();
      return;
      paramInt4 = 0;
      break;
    }
  }
  
  public Drawable getDrawable()
  {
    if (this.jdField_a_of_type_ComTencentImageURLDrawable != null) {
      return this.jdField_a_of_type_ComTencentImageURLDrawable;
    }
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(this.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject1);
          if (this.jdField_a_of_type_MqqUtilWeakReference != null)
          {
            localObject1 = (Drawable.Callback)this.jdField_a_of_type_MqqUtilWeakReference.get();
            if (localObject1 != null) {
              this.jdField_a_of_type_ComTencentImageURLDrawable.setCallback((Drawable.Callback)localObject1);
            }
            this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new axac(this));
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder().append("getDrawable. first get url:").append(this.jdField_a_of_type_JavaLangString).append("  cb:");
              if (localObject1 == null) {
                break label180;
              }
              bool = true;
              QLog.i("UrlBottomImageSpan", 2, bool);
            }
            return this.jdField_a_of_type_ComTencentImageURLDrawable;
          }
        }
        catch (Throwable localThrowable)
        {
          this.jdField_a_of_type_ComTencentImageURLDrawable = null;
          QLog.e("UrlBottomImageSpan", 2, "getDrawable error: " + localThrowable.getMessage());
          return super.getDrawable();
        }
        Object localObject2 = null;
        continue;
        label180:
        boolean bool = false;
      }
    }
    return super.getDrawable();
  }
  
  public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    paramInt2 = 0;
    paramCharSequence = getDrawable();
    if (paramCharSequence == null) {
      return 0;
    }
    int i;
    int j;
    if (((paramCharSequence instanceof URLDrawable)) && (((URLDrawable)paramCharSequence).getStatus() == 1))
    {
      i = paramCharSequence.getIntrinsicWidth();
      j = paramCharSequence.getIntrinsicHeight();
      paramInt2 = j;
      paramInt1 = i;
      if (j > this.jdField_a_of_type_Int)
      {
        paramInt2 = j;
        paramInt1 = i;
        if (this.jdField_a_of_type_Int > 0)
        {
          paramInt1 = i * this.jdField_a_of_type_Int / j;
          paramInt2 = this.jdField_a_of_type_Int;
        }
      }
      URLDrawable localURLDrawable = this.jdField_a_of_type_ComTencentImageURLDrawable;
      if (paramInt1 > 0)
      {
        i = paramInt1;
        if (paramInt2 <= 0) {
          break label293;
        }
        j = paramInt2;
        label113:
        localURLDrawable.setBounds(0, 0, i, j);
      }
    }
    for (;;)
    {
      paramCharSequence = paramCharSequence.getBounds();
      if (paramFontMetricsInt != null)
      {
        paramPaint = paramPaint.getFontMetricsInt();
        j = paramPaint.bottom - paramPaint.top;
        int k = paramCharSequence.bottom - paramCharSequence.top;
        i = k / 2 - j / 4;
        k /= 2;
        j = j / 4 + k;
        paramFontMetricsInt.ascent = (-j);
        paramFontMetricsInt.top = (-j);
        paramFontMetricsInt.bottom = i;
        paramFontMetricsInt.descent = i;
      }
      if (QLog.isColorLevel()) {
        QLog.i("UrlBottomImageSpan", 2, "getSize size:" + paramCharSequence.right + " width:" + paramInt1 + " height:" + paramInt2 + " imageUrl:" + this.jdField_a_of_type_JavaLangString);
      }
      return paramCharSequence.right;
      i = 0;
      break;
      label293:
      j = 0;
      break label113;
      paramInt1 = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axab
 * JD-Core Version:    0.7.0.1
 */