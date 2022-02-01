import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.widget.SimpleTextView;

public abstract class bgoh
  extends blfk
{
  protected final int a;
  protected final int[] a;
  protected final int[] b;
  protected final int[] c;
  protected final int[] d;
  
  public bgoh(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    super(paramInt1, paramInt2);
    this.d = paramArrayOfInt1;
    this.jdField_a_of_type_Int = paramInt3;
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt2;
    this.b = paramArrayOfInt3;
    this.c = paramArrayOfInt4;
  }
  
  public View a(int paramInt, Object paramObject, blfm paramblfm, View.OnClickListener paramOnClickListener)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      if ((paramObject.length != 2) || (!(paramObject[1] instanceof bfif))) {
        break label229;
      }
    }
    label90:
    label229:
    for (bfif localbfif = (bfif)paramObject[1];; localbfif = null)
    {
      localObject1 = localObject2;
      if (paramblfm != null)
      {
        localObject1 = localObject2;
        if (paramblfm.jdField_a_of_type_Int >= 0)
        {
          localObject1 = localObject2;
          if (paramblfm.b >= 0)
          {
            if (localbfif != null) {
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
        if ((paramblfm.jdField_a_of_type_AndroidViewView instanceof SimpleTextView)) {
          paramObject = (SimpleTextView)paramblfm.jdField_a_of_type_AndroidViewView;
        }
        localObject1 = paramObject;
      } while (paramObject == null);
      paramInt = this.b[paramblfm.b];
      int i = this.c[paramblfm.b];
      int j = this.jdField_a_of_type_ArrayOfInt[paramblfm.b];
      paramObject.setVisibility(0);
      paramObject.setText(paramObject.getContext().getResources().getString(paramInt));
      paramObject.setBackgroundResource(i);
      paramObject.setId(j);
      paramObject.setTag(localbfif);
      paramObject.setContentDescription(paramObject.getResources().getString(paramInt));
      paramObject.setOnClickListener(paramOnClickListener);
      paramblfm.c = this.d[paramblfm.jdField_a_of_type_Int];
      paramblfm.d = this.jdField_a_of_type_Int;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgoh
 * JD-Core Version:    0.7.0.1
 */