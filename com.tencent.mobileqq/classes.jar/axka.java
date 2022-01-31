import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;

class axka
  extends axkc
{
  private axkk a;
  
  axka(@NonNull String paramString, int paramInt1, int paramInt2)
  {
    super(2, paramString);
    this.a = new axkk(paramInt1, paramInt2, 1);
  }
  
  float a(@NonNull Paint paramPaint)
  {
    float f = this.a.a().getBounds().width();
    if (QLog.isColorLevel()) {
      QLog.d("NickWrapper", 2, "getWidth normal span width " + f);
    }
    return f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axka
 * JD-Core Version:    0.7.0.1
 */