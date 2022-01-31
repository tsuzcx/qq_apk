import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.widget.SimpleTextView;

public abstract class baoy
  extends bfwd
{
  protected final int a;
  protected final int[] a;
  protected final int[] b;
  protected final int[] c;
  protected final int[] d;
  
  public baoy(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    super(paramInt1, paramInt2);
    this.d = paramArrayOfInt1;
    this.jdField_a_of_type_Int = paramInt3;
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt2;
    this.b = paramArrayOfInt3;
    this.c = paramArrayOfInt4;
  }
  
  public View a(int paramInt, Object paramObject, bfwf parambfwf, View.OnClickListener paramOnClickListener)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      if ((paramObject.length != 2) || (!(paramObject[1] instanceof azpi))) {
        break label229;
      }
    }
    label90:
    label229:
    for (azpi localazpi = (azpi)paramObject[1];; localazpi = null)
    {
      localObject1 = localObject2;
      if (parambfwf != null)
      {
        localObject1 = localObject2;
        if (parambfwf.jdField_a_of_type_Int >= 0)
        {
          localObject1 = localObject2;
          if (parambfwf.b >= 0)
          {
            if (localazpi != null) {
              break label90;
            }
            localObject1 = localObject2;
          }
        }
      }
      do
      {
        return localObject1;
        paramObject = localObject3;
        if ((parambfwf.jdField_a_of_type_AndroidViewView instanceof SimpleTextView)) {
          paramObject = (SimpleTextView)parambfwf.jdField_a_of_type_AndroidViewView;
        }
        localObject1 = paramObject;
      } while (paramObject == null);
      paramInt = this.b[parambfwf.b];
      int i = this.c[parambfwf.b];
      int j = this.jdField_a_of_type_ArrayOfInt[parambfwf.b];
      paramObject.setVisibility(0);
      paramObject.setText(paramObject.getContext().getResources().getString(paramInt));
      paramObject.setBackgroundResource(i);
      paramObject.setId(j);
      paramObject.setTag(localazpi);
      paramObject.setContentDescription(paramObject.getResources().getString(paramInt));
      paramObject.setOnClickListener(paramOnClickListener);
      parambfwf.c = this.d[parambfwf.jdField_a_of_type_Int];
      parambfwf.d = this.jdField_a_of_type_Int;
      return paramObject;
    }
  }
  
  public View a(Context paramContext, int paramInt)
  {
    paramContext = new SimpleTextView(paramContext);
    paramContext.setLayoutParams(new LinearLayout.LayoutParams(this.d[paramInt], this.jdField_a_of_type_Int));
    paramContext.setGravity(17);
    paramContext.setTextSize(16.0F);
    paramContext.setTextColor(-1);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     baoy
 * JD-Core Version:    0.7.0.1
 */