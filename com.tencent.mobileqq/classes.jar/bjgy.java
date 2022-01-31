import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.tencent.common.app.BaseApplicationImpl;

public class bjgy
{
  int a;
  public Bitmap a;
  public Typeface a;
  int b = 0;
  int c = 0;
  int d = 0;
  public int e;
  public int f;
  public int g;
  public int h;
  public int i = 2;
  
  public bjgy()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  public int a(float paramFloat)
  {
    return actj.a(paramFloat, BaseApplicationImpl.getApplication().getResources());
  }
  
  public int a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = 0;
    while (j < paramInt)
    {
      localStringBuilder.append("我");
      j += 1;
    }
    TextPaint localTextPaint = new TextPaint();
    if (this.jdField_a_of_type_AndroidGraphicsTypeface != null) {
      localTextPaint.setTypeface(this.jdField_a_of_type_AndroidGraphicsTypeface);
    }
    localTextPaint.setShadowLayer(a(3.0F), a(5.0F), a(5.0F), -1);
    paramInt = actj.a(100.0F, BaseApplicationImpl.getApplication().getResources());
    for (;;)
    {
      localTextPaint.setTextSize(paramInt);
      StaticLayout localStaticLayout = bjix.a(localStringBuilder, 0, localStringBuilder.length(), localTextPaint, this.c, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false, null, 0, 1);
      if (localTextPaint.measureText(localStringBuilder.toString()) > this.c)
      {
        paramInt -= 1;
      }
      else
      {
        if (localStaticLayout.getHeight() <= this.d) {
          break;
        }
        paramInt -= 1;
      }
    }
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjgy
 * JD-Core Version:    0.7.0.1
 */