import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;

public class biax
  extends StaticLayout
{
  public biax(CharSequence paramCharSequence, int paramInt1, int paramInt2, TextPaint paramTextPaint, int paramInt3, Layout.Alignment paramAlignment, float paramFloat1, float paramFloat2, boolean paramBoolean, TextUtils.TruncateAt paramTruncateAt, int paramInt4)
  {
    super(paramCharSequence, paramInt1, paramInt2, paramTextPaint, paramInt3, paramAlignment, paramFloat1, paramFloat2, paramBoolean, paramTruncateAt, paramInt4);
  }
  
  public int getParagraphDirection(int paramInt)
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     biax
 * JD-Core Version:    0.7.0.1
 */