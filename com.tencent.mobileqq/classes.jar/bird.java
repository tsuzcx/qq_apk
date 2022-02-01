import android.animation.ValueAnimator;
import android.content.Context;
import android.os.IBinder;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.PopupWindow;

public class bird
  extends PopupWindow
{
  protected Context a;
  private View jdField_a_of_type_AndroidViewView;
  private WindowManager jdField_a_of_type_AndroidViewWindowManager;
  
  public bird(Context paramContext)
  {
    super(paramContext, null, 2131755914);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)paramContext.getSystemService("window"));
    setOutsideTouchable(true);
    setFocusable(true);
    setTouchable(true);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      localValueAnimator.setDuration(400L);
      localValueAnimator.addUpdateListener(new birg(this));
      localValueAnimator.addListener(new birh(this));
      localValueAnimator.start();
    }
  }
  
  private void a(IBinder paramIBinder)
  {
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    localLayoutParams.format = -3;
    localLayoutParams.type = 1000;
    localLayoutParams.token = paramIBinder;
    this.jdField_a_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(855638016);
    this.jdField_a_of_type_AndroidViewView.setFitsSystemWindows(false);
    this.jdField_a_of_type_AndroidViewView.setOnKeyListener(new bire(this));
    this.jdField_a_of_type_AndroidViewWindowManager.addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
    paramIBinder = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    paramIBinder.setDuration(400L);
    paramIBinder.addUpdateListener(new birf(this));
    paramIBinder.start();
  }
  
  public void dismiss()
  {
    a();
    super.dismiss();
  }
  
  public void showAsDropDown(View paramView)
  {
    a(paramView.getWindowToken());
    super.showAsDropDown(paramView);
  }
  
  public void showAsDropDown(View paramView, int paramInt1, int paramInt2)
  {
    a(paramView.getWindowToken());
    super.showAsDropDown(paramView, paramInt1, paramInt2);
  }
  
  public void showAtLocation(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramView.getWindowToken());
    super.showAtLocation(paramView, paramInt1, paramInt2, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bird
 * JD-Core Version:    0.7.0.1
 */