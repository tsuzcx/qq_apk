import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.widget.SimpleTextView;

class amek
  extends bkov
{
  amek(ameh paramameh, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    super(paramInt1, paramInt2, paramArrayOfInt1, paramInt3, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4);
  }
  
  public View a(int paramInt, Object paramObject, bkou parambkou, View.OnClickListener paramOnClickListener)
  {
    parambkou = super.a(paramInt, paramObject, parambkou, paramOnClickListener);
    if ((parambkou instanceof SimpleTextView)) {
      parambkou.setTag(paramObject);
    }
    return parambkou;
  }
  
  public void a(int paramInt, Object paramObject, bkou[] paramArrayOfbkou)
  {
    paramInt = 0;
    if ((paramArrayOfbkou == null) || (paramArrayOfbkou.length <= 0)) {}
    for (;;)
    {
      return;
      if (paramArrayOfbkou.length < 0)
      {
        paramArrayOfbkou[0].b = 0;
        paramArrayOfbkou[0].a = 0;
        paramInt = 1;
      }
      while (paramInt < paramArrayOfbkou.length)
      {
        paramArrayOfbkou[paramInt].b = -1;
        paramArrayOfbkou[paramInt].a = -1;
        paramInt += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amek
 * JD-Core Version:    0.7.0.1
 */