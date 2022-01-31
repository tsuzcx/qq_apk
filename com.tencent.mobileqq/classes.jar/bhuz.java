import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.util.LruCache;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.widget.FastAnimationDrawable;
import java.lang.ref.SoftReference;
import java.util.Set;

public class bhuz
  extends LruCache<Integer, BitmapDrawable>
{
  public bhuz(FastAnimationDrawable paramFastAnimationDrawable, int paramInt)
  {
    super(paramInt);
  }
  
  protected void a(boolean paramBoolean, Integer paramInteger, BitmapDrawable paramBitmapDrawable1, BitmapDrawable paramBitmapDrawable2)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      FastAnimationDrawable.a(this.a).add(new SoftReference(paramBitmapDrawable1.getBitmap()));
      if (QLog.isColorLevel()) {
        QLog.d("FastAnimationDrawable", 2, "remove key:" + paramInteger + " bitmap:" + paramBitmapDrawable1.getBitmap());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhuz
 * JD-Core Version:    0.7.0.1
 */