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

public class bcyf
{
  protected int a;
  private Context jdField_a_of_type_AndroidContentContext;
  private BitmapDrawable jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = new BitmapDrawable();
  private Handler jdField_a_of_type_AndroidOsHandler;
  private bcyb jdField_a_of_type_Bcyb;
  private Map<View, bcyi> jdField_a_of_type_JavaUtilMap = new WeakHashMap();
  private boolean jdField_a_of_type_Boolean;
  protected int b;
  private boolean b;
  
  public bcyf(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bcyb = new bcyb(bczj.a(paramContext) / 8);
  }
  
  private bcyh a(View paramView)
  {
    if (paramView != null)
    {
      bcyi localbcyi = (bcyi)this.jdField_a_of_type_JavaUtilMap.get(paramView);
      if (localbcyi != null) {
        paramView = localbcyi.jdField_a_of_type_Bcyg;
      }
      while ((paramView instanceof bcyg))
      {
        return ((bcyg)paramView).a();
        if ((paramView instanceof ImageView)) {
          paramView = ((ImageView)paramView).getDrawable();
        } else {
          paramView = paramView.getBackground();
        }
      }
    }
    return null;
  }
  
  private void a(boolean paramBoolean, View paramView, Drawable paramDrawable, bcyi parambcyi)
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
    if (parambcyi != null) {
      paramDrawable = parambcyi.jdField_a_of_type_Bcye;
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
  
  public bcyb a()
  {
    return this.jdField_a_of_type_Bcyb;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcyf
 * JD-Core Version:    0.7.0.1
 */