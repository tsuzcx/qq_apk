import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.animation.AlphaAnimation;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.gallery.view.page.GalleryPageView.3;
import com.tencent.widget.AdapterView;

public class aqoq
  extends aqop
{
  public int a;
  AlphaAnimation jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
  public TextView a;
  aqok jdField_a_of_type_Aqok;
  Runnable jdField_a_of_type_JavaLangRunnable = new GalleryPageView.3(this);
  private boolean jdField_a_of_type_Boolean = true;
  public AlphaAnimation b = new AlphaAnimation(1.0F, 0.0F);
  
  public aqoq()
  {
    this.jdField_a_of_type_Int = 3;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(paramInt);
  }
  
  public void a(Context paramContext, aqok paramaqok, int paramInt)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)paramaqok.a();
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(paramContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.addRule(14, -1);
    localLayoutParams.bottomMargin = ((int)TypedValue.applyDimension(1, this.jdField_a_of_type_Int, paramContext.getResources().getDisplayMetrics()) + paramInt);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#e6e9e9e9"));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 15.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setId(2131366903);
    localRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setDuration(300L);
    this.b.setDuration(300L);
    this.jdField_a_of_type_Aqok = paramaqok;
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(new aqor(this));
    this.b.setAnimationListener(new aqos(this));
  }
  
  public void a(AdapterView paramAdapterView, int paramInt)
  {
    if (paramAdapterView.getCount() > 1)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt + 1 + "/" + paramAdapterView.getCount());
      if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 4)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation);
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
          this.jdField_a_of_type_Boolean = false;
          return;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 2000L);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_AndroidWidgetTextView.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetTextView.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 2000L);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqoq
 * JD-Core Version:    0.7.0.1
 */