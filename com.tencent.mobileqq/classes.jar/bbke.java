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

public class bbke
{
  protected final Context a;
  protected final View.OnClickListener a;
  protected View a;
  protected final ViewStub a;
  protected bbiq a;
  protected bbkc a;
  protected final bbki a;
  protected boolean a;
  
  public bbke(ViewStub paramViewStub, Context paramContext, View.OnClickListener paramOnClickListener, bbki parambbki)
  {
    this.jdField_a_of_type_AndroidViewViewStub = paramViewStub;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_Bbki = parambbki;
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, Interpolator paramInterpolator, boolean paramBoolean)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { paramInt1, paramInt2 });
    localValueAnimator.setDuration(200L);
    localValueAnimator.setInterpolator(paramInterpolator);
    localValueAnimator.addUpdateListener(new bbkf(this, paramView));
    localValueAnimator.addListener(new bbkg(this, paramBoolean, paramView, paramInt2));
    localValueAnimator.start();
  }
  
  private void a(bbiq parambbiq, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, 100 });; localValueAnimator = ValueAnimator.ofInt(new int[] { 100, 0 }))
    {
      localValueAnimator.setDuration(200L);
      localValueAnimator.setInterpolator(new LinearInterpolator());
      localValueAnimator.addUpdateListener(new bbkh(this, parambbiq));
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
    GridView localGridView = (GridView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377135);
    this.jdField_a_of_type_Bbkc = new bbkc(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewView$OnClickListener);
    localGridView.setAdapter(this.jdField_a_of_type_Bbkc);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bbiq = null;
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public boolean a(bbiq parambbiq, bbkk parambbkk)
  {
    b();
    int i;
    if (this.jdField_a_of_type_Bbiq != null)
    {
      i = ((LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams()).height;
      if (this.jdField_a_of_type_Bbiq == parambbiq)
      {
        a(parambbiq, false);
        a(this.jdField_a_of_type_AndroidViewView, i, 0, new DecelerateInterpolator(), true);
        this.jdField_a_of_type_Bbiq = null;
        return false;
      }
      a(this.jdField_a_of_type_Bbiq, false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bbkc.a(parambbkk);
      this.jdField_a_of_type_Bbiq = parambbiq;
      int[] arrayOfInt = new int[2];
      parambbiq.a.getLocationInWindow(arrayOfInt);
      int j = (int)Math.ceil(parambbkk.a.size() / 3.0F);
      j = xod.a(this.jdField_a_of_type_AndroidContentContext, j * 56 - 13 + 30);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      a(parambbiq, true);
      a(this.jdField_a_of_type_AndroidViewView, i, j, new AccelerateInterpolator(), false);
      return true;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbke
 * JD-Core Version:    0.7.0.1
 */