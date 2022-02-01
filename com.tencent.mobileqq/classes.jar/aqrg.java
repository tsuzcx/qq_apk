import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.text.style.ImageSpan;
import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

public class aqrg
  extends ImageSpan
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Drawable.Callback jdField_a_of_type_AndroidGraphicsDrawableDrawable$Callback;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  public String a;
  
  public aqrg(Context paramContext, int paramInt, String paramString)
  {
    super(paramContext, paramInt, 1);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public aqrg(Context paramContext, int paramInt1, String paramString, int paramInt2)
  {
    super(paramContext, paramInt1, 1);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt2;
  }
  
  private void a(Drawable paramDrawable, int paramInt)
  {
    if ((!(paramDrawable instanceof URLDrawable)) || (((URLDrawable)paramDrawable).getStatus() != 1)) {
      return;
    }
    int i = paramDrawable.getIntrinsicWidth() / 2;
    int j = paramDrawable.getIntrinsicHeight() / 2;
    if (afhw.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord))
    {
      float f = paramInt * 1.0F / j;
      paramDrawable.setBounds(0, 0, (int)(i * f), paramInt);
      return;
    }
    paramDrawable.setBounds(0, 0, i, j);
  }
  
  public void a(Drawable.Callback paramCallback)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable$Callback = paramCallback;
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
  }
  
  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    paramCharSequence = getDrawable();
    if (paramCharSequence == null) {}
    do
    {
      do
      {
        return;
        paramPaint = paramPaint.getFontMetricsInt();
        a(paramCharSequence, paramPaint.bottom - paramPaint.top);
        paramCanvas.save();
        paramCanvas.translate(paramFloat, (paramInt5 - paramInt3 - paramCharSequence.getBounds().bottom) / 2 + paramInt3);
        paramCharSequence.draw(paramCanvas);
        paramCanvas.restore();
      } while ((this.jdField_a_of_type_JavaLangString == null) || ((!this.jdField_a_of_type_JavaLangString.endsWith(".gif")) && (!this.jdField_a_of_type_JavaLangString.endsWith(".apng"))));
      paramCanvas = paramCharSequence.getCallback();
    } while (!(paramCanvas instanceof View));
    ((View)paramCanvas).invalidate();
  }
  
  public Drawable getDrawable()
  {
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      if (this.jdField_a_of_type_ComTencentImageURLDrawable != null) {
        return this.jdField_a_of_type_ComTencentImageURLDrawable;
      }
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      if (this.jdField_a_of_type_Int > 0)
      {
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.jdField_a_of_type_Int;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.jdField_a_of_type_Int;
      }
      StringBuilder localStringBuilder;
      if (this.jdField_a_of_type_JavaLangString.endsWith(".gif"))
      {
        ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
        this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(this.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder().append("UrlCenterImageSpan.getDrawable. url:").append(this.jdField_a_of_type_JavaLangString).append(" drawable:");
          if (this.jdField_a_of_type_ComTencentImageURLDrawable == null) {
            break label204;
          }
        }
      }
      label204:
      for (localObject = this.jdField_a_of_type_ComTencentImageURLDrawable.getIntrinsicWidth() + "";; localObject = null)
      {
        QLog.e(".troop.send_gift", 2, (String)localObject);
        this.jdField_a_of_type_ComTencentImageURLDrawable.setCallback(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable$Callback);
        this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new aqrh(this));
        return this.jdField_a_of_type_ComTencentImageURLDrawable;
        if (!this.jdField_a_of_type_JavaLangString.endsWith(".apng")) {
          break;
        }
        ((URLDrawable.URLDrawableOptions)localObject).mUseApngImage = true;
        break;
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
    paramPaint = paramPaint.getFontMetricsInt();
    paramInt2 = paramPaint.bottom - paramPaint.top;
    a(paramCharSequence, paramInt2);
    paramPaint = paramCharSequence.getBounds();
    if (paramFontMetricsInt != null)
    {
      int i = paramPaint.bottom - paramPaint.top;
      paramInt1 = i / 2 - paramInt2 / 4;
      i /= 2;
      paramInt2 = paramInt2 / 4 + i;
      paramFontMetricsInt.ascent = (-paramInt2);
      paramFontMetricsInt.top = (-paramInt2);
      paramFontMetricsInt.bottom = paramInt1;
      paramFontMetricsInt.descent = paramInt1;
    }
    return paramPaint.right;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqrg
 * JD-Core Version:    0.7.0.1
 */