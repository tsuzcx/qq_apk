import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import java.util.ArrayList;

public class azlv
{
  protected final Context a;
  protected final View.OnClickListener a;
  protected View a;
  protected final ViewStub a;
  protected azkh a;
  protected azlt a;
  protected final azlz a;
  protected boolean a;
  
  public azlv(ViewStub paramViewStub, Context paramContext, View.OnClickListener paramOnClickListener, azlz paramazlz)
  {
    this.jdField_a_of_type_AndroidViewViewStub = paramViewStub;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_Azlz = paramazlz;
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, Interpolator paramInterpolator, boolean paramBoolean)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { paramInt1, paramInt2 });
    localValueAnimator.setDuration(200L);
    localValueAnimator.setInterpolator(paramInterpolator);
    localValueAnimator.addUpdateListener(new azlw(this, paramView));
    localValueAnimator.addListener(new azlx(this, paramBoolean, paramView, paramInt2));
    localValueAnimator.start();
  }
  
  private void a(azkh paramazkh, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, 100 });; localValueAnimator = ValueAnimator.ofInt(new int[] { 100, 0 }))
    {
      localValueAnimator.setDuration(200L);
      localValueAnimator.setInterpolator(new LinearInterpolator());
      localValueAnimator.addUpdateListener(new azly(this, paramazkh));
      localValueAnimator.start();
      return;
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
    GridView localGridView = (GridView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376628);
    this.jdField_a_of_type_Azlt = new azlt(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewView$OnClickListener);
    localGridView.setAdapter(this.jdField_a_of_type_Azlt);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Azkh = null;
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public boolean a(azkh paramazkh, azmb paramazmb)
  {
    b();
    int i;
    if (this.jdField_a_of_type_Azkh != null)
    {
      i = ((LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams()).height;
      if (this.jdField_a_of_type_Azkh == paramazkh)
      {
        a(paramazkh, false);
        a(this.jdField_a_of_type_AndroidViewView, i, 0, new DecelerateInterpolator(), true);
        this.jdField_a_of_type_Azkh = null;
        return false;
      }
      a(this.jdField_a_of_type_Azkh, false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Azlt.a(paramazmb);
      this.jdField_a_of_type_Azkh = paramazkh;
      int[] arrayOfInt = new int[2];
      paramazkh.a.getLocationInWindow(arrayOfInt);
      int j = (int)Math.ceil(paramazmb.a.size() / 3.0F);
      j = vzl.a(this.jdField_a_of_type_AndroidContentContext, j * 56 - 13 + 30);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      a(paramazkh, true);
      a(this.jdField_a_of_type_AndroidViewView, i, j, new AccelerateInterpolator(), false);
      return true;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azlv
 * JD-Core Version:    0.7.0.1
 */