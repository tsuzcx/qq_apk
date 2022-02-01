import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.widget.SimpleTextView;

public abstract class blpy
  extends blpv
{
  protected final int a;
  protected final int[] b;
  protected final int[] c;
  protected final int[] d;
  protected final int[] e;
  
  public blpy(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    super(paramInt1, paramInt2);
    this.e = paramArrayOfInt1;
    this.jdField_a_of_type_Int = paramInt3;
    this.b = paramArrayOfInt2;
    this.c = paramArrayOfInt3;
    this.d = paramArrayOfInt4;
  }
  
  public View a(int paramInt, Object paramObject, blpx paramblpx, View.OnClickListener paramOnClickListener)
  {
    Object localObject2 = null;
    paramObject = null;
    Object localObject1 = paramObject;
    if (paramblpx != null)
    {
      localObject1 = paramObject;
      if (paramblpx.jdField_a_of_type_Int >= 0)
      {
        if (paramblpx.b >= 0) {
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
      if ((paramblpx.jdField_a_of_type_AndroidViewView instanceof SimpleTextView)) {
        paramObject = (SimpleTextView)paramblpx.jdField_a_of_type_AndroidViewView;
      }
      i = this.c[paramblpx.b];
      j = this.d[paramblpx.b];
      k = this.b[paramblpx.b];
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
    paramblpx.c = this.e[paramblpx.jdField_a_of_type_Int];
    paramblpx.d = this.jdField_a_of_type_Int;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blpy
 * JD-Core Version:    0.7.0.1
 */