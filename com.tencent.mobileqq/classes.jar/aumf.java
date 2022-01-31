import android.content.Context;
import android.widget.OverScroller;
import com.tencent.qphone.base.util.QLog;

public class aumf
  extends OverScroller
{
  private aumg a;
  
  public aumf(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(aumg paramaumg)
  {
    this.a = paramaumg;
  }
  
  public void fling(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAioOverScroller", 2, "fling() called with: startX = [" + paramInt1 + "], startY = [" + paramInt2 + "], velocityX = [" + paramInt3 + "], velocityY = [" + paramInt4 + "], minX = [" + paramInt5 + "], maxX = [" + paramInt6 + "], minY = [" + paramInt7 + "], maxY = [" + paramInt8 + "], overX = [" + paramInt9 + "], overY = [" + paramInt10 + "]");
    }
    super.fling(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10);
  }
  
  public boolean springBack(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAioOverScroller", 2, "springBack() called with: startX = [" + paramInt1 + "], startY = [" + paramInt2 + "], minX = [" + paramInt3 + "], maxX = [" + paramInt4 + "], minY = [" + paramInt5 + "], maxY = [" + paramInt6 + "]");
    }
    if (this.a != null) {
      this.a.a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    }
    return super.springBack(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aumf
 * JD-Core Version:    0.7.0.1
 */