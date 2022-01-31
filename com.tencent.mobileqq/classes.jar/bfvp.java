import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.widget.SimpleTextView;

public abstract class bfvp
  extends bfvm
{
  protected final int a;
  protected final int[] b;
  protected final int[] c;
  protected final int[] d;
  protected final int[] e;
  
  public bfvp(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    super(paramInt1, paramInt2);
    this.e = paramArrayOfInt1;
    this.jdField_a_of_type_Int = paramInt3;
    this.b = paramArrayOfInt2;
    this.c = paramArrayOfInt3;
    this.d = paramArrayOfInt4;
  }
  
  public View a(int paramInt, Object paramObject, bfvo parambfvo, View.OnClickListener paramOnClickListener)
  {
    Object localObject2 = null;
    paramObject = null;
    Object localObject1 = paramObject;
    if (parambfvo != null)
    {
      localObject1 = paramObject;
      if (parambfvo.jdField_a_of_type_Int >= 0)
      {
        if (parambfvo.b >= 0) {
          break label35;
        }
        localObject1 = paramObject;
      }
    }
    label35:
    int i;
    int j;
    int k;
    do
    {
      return localObject1;
      paramObject = localObject2;
      if ((parambfvo.jdField_a_of_type_AndroidViewView instanceof SimpleTextView)) {
        paramObject = (SimpleTextView)parambfvo.jdField_a_of_type_AndroidViewView;
      }
      i = this.c[parambfvo.b];
      j = this.d[parambfvo.b];
      k = this.b[parambfvo.b];
      localObject1 = paramObject;
    } while (paramObject == null);
    paramObject.setVisibility(0);
    paramObject.setText(paramObject.getContext().getResources().getString(i));
    paramObject.setBackgroundResource(j);
    paramObject.setId(k);
    paramObject.setTag("tag_swip_icon_menu_item");
    paramObject.setTag(-2, Integer.valueOf(i));
    paramObject.setTag(-1, Integer.valueOf(paramInt));
    paramObject.setContentDescription(paramObject.getResources().getString(i));
    paramObject.setOnClickListener(paramOnClickListener);
    parambfvo.c = this.e[parambfvo.jdField_a_of_type_Int];
    parambfvo.d = this.jdField_a_of_type_Int;
    return paramObject;
  }
  
  public View a(Context paramContext, int paramInt)
  {
    paramContext = new SimpleTextView(paramContext);
    paramContext.setLayoutParams(new LinearLayout.LayoutParams(this.e[paramInt], this.jdField_a_of_type_Int));
    paramContext.setGravity(17);
    paramContext.setTextSize(16.0F);
    paramContext.setTextColor(-1);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bfvp
 * JD-Core Version:    0.7.0.1
 */