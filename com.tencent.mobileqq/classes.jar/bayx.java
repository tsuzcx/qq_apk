import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import java.util.Map;
import java.util.WeakHashMap;

public class bayx
{
  protected int a;
  private Context jdField_a_of_type_AndroidContentContext;
  private BitmapDrawable jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = new BitmapDrawable();
  private Handler jdField_a_of_type_AndroidOsHandler;
  private bayt jdField_a_of_type_Bayt;
  private Map<View, baza> jdField_a_of_type_JavaUtilMap = new WeakHashMap();
  private boolean jdField_a_of_type_Boolean;
  protected int b;
  private boolean b;
  
  public bayx(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bayt = new bayt(bbab.a(paramContext) / 8);
  }
  
  private bayz a(View paramView)
  {
    if (paramView != null)
    {
      baza localbaza = (baza)this.jdField_a_of_type_JavaUtilMap.get(paramView);
      if (localbaza != null) {
        paramView = localbaza.jdField_a_of_type_Bayy;
      }
      while ((paramView instanceof bayy))
      {
        return ((bayy)paramView).a();
        if ((paramView instanceof ImageView)) {
          paramView = ((ImageView)paramView).getDrawable();
        } else {
          paramView = paramView.getBackground();
        }
      }
    }
    return null;
  }
  
  private void a(boolean paramBoolean, View paramView, Drawable paramDrawable, baza parambaza)
  {
    Object localObject = paramDrawable;
    if (this.jdField_b_of_type_Boolean)
    {
      localObject = paramDrawable;
      if (paramBoolean)
      {
        localObject = paramDrawable;
        if (!(paramDrawable instanceof AnimationDrawable))
        {
          localObject = paramDrawable;
          if (paramDrawable != null)
          {
            localObject = new TransitionDrawable(new Drawable[] { new ColorDrawable(17170445), paramDrawable });
            ((TransitionDrawable)localObject).startTransition(200);
          }
        }
      }
    }
    paramDrawable = null;
    if (parambaza != null) {
      paramDrawable = parambaza.jdField_a_of_type_Bayw;
    }
    if (paramDrawable != null)
    {
      paramDrawable.a(paramView, (Drawable)localObject);
      return;
    }
    if ((paramView instanceof ImageView))
    {
      ((ImageView)paramView).setImageDrawable((Drawable)localObject);
      return;
    }
    paramView.setBackgroundDrawable((Drawable)localObject);
  }
  
  public bayt a()
  {
    return this.jdField_a_of_type_Bayt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bayx
 * JD-Core Version:    0.7.0.1
 */