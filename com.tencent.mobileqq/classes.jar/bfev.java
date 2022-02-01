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
import com.tencent.biz.qqstory.utils.UIUtils;
import java.util.ArrayList;

public class bfev
{
  protected final Context a;
  protected final View.OnClickListener a;
  protected View a;
  protected final ViewStub a;
  protected bfdh a;
  protected bfet a;
  protected final bfez a;
  protected boolean a;
  
  public bfev(ViewStub paramViewStub, Context paramContext, View.OnClickListener paramOnClickListener, bfez parambfez)
  {
    this.jdField_a_of_type_AndroidViewViewStub = paramViewStub;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_Bfez = parambfez;
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, Interpolator paramInterpolator, boolean paramBoolean)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { paramInt1, paramInt2 });
    localValueAnimator.setDuration(200L);
    localValueAnimator.setInterpolator(paramInterpolator);
    localValueAnimator.addUpdateListener(new bfew(this, paramView));
    localValueAnimator.addListener(new bfex(this, paramBoolean, paramView, paramInt2));
    localValueAnimator.start();
  }
  
  private void a(bfdh parambfdh, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, 100 });; localValueAnimator = ValueAnimator.ofInt(new int[] { 100, 0 }))
    {
      localValueAnimator.setDuration(200L);
      localValueAnimator.setInterpolator(new LinearInterpolator());
      localValueAnimator.addUpdateListener(new bfey(this, parambfdh));
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
    GridView localGridView = (GridView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378207);
    this.jdField_a_of_type_Bfet = new bfet(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewView$OnClickListener);
    localGridView.setAdapter(this.jdField_a_of_type_Bfet);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bfdh = null;
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public boolean a(bfdh parambfdh, bffb parambffb)
  {
    b();
    int i;
    if (this.jdField_a_of_type_Bfdh != null)
    {
      i = ((LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams()).height;
      if (this.jdField_a_of_type_Bfdh == parambfdh)
      {
        a(parambfdh, false);
        a(this.jdField_a_of_type_AndroidViewView, i, 0, new DecelerateInterpolator(), true);
        this.jdField_a_of_type_Bfdh = null;
        return false;
      }
      a(this.jdField_a_of_type_Bfdh, false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bfet.a(parambffb);
      this.jdField_a_of_type_Bfdh = parambfdh;
      int[] arrayOfInt = new int[2];
      parambfdh.a.getLocationInWindow(arrayOfInt);
      int j = (int)Math.ceil(parambffb.a.size() / 3.0F);
      j = UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, j * 56 - 13 + 30);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      a(parambfdh, true);
      a(this.jdField_a_of_type_AndroidViewView, i, j, new AccelerateInterpolator(), false);
      return true;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfev
 * JD-Core Version:    0.7.0.1
 */