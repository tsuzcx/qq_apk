import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.widget.SimpleTextView;

class amqe
  extends blpy
{
  amqe(amqb paramamqb, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    super(paramInt1, paramInt2, paramArrayOfInt1, paramInt3, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4);
  }
  
  public View a(int paramInt, Object paramObject, blpx paramblpx, View.OnClickListener paramOnClickListener)
  {
    paramblpx = super.a(paramInt, paramObject, paramblpx, paramOnClickListener);
    if ((paramblpx instanceof SimpleTextView)) {
      paramblpx.setTag(paramObject);
    }
    return paramblpx;
  }
  
  public void a(int paramInt, Object paramObject, blpx[] paramArrayOfblpx)
  {
    paramInt = 0;
    if ((paramArrayOfblpx == null) || (paramArrayOfblpx.length <= 0)) {}
    for (;;)
    {
      return;
      if (paramArrayOfblpx.length < 0)
      {
        paramArrayOfblpx[0].b = 0;
        paramArrayOfblpx[0].a = 0;
        paramInt = 1;
      }
      while (paramInt < paramArrayOfblpx.length)
      {
        paramArrayOfblpx[paramInt].b = -1;
        paramArrayOfblpx[paramInt].a = -1;
        paramInt += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amqe
 * JD-Core Version:    0.7.0.1
 */