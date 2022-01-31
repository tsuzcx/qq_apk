import android.content.Context;
import android.os.Looper;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

public class amoy
{
  private Context jdField_a_of_type_AndroidContentContext;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private volatile boolean jdField_a_of_type_Boolean;
  
  public amoy(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560817, null));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131380230));
  }
  
  public void a(RelativeLayout paramRelativeLayout)
  {
    QLog.d("ARTransferPromotionUIContainer", 2, "attachToRootViewGroup");
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(12);
    localLayoutParams.bottomMargin = aekt.a(57.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    paramRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetFrameLayout, localLayoutParams);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void b(RelativeLayout paramRelativeLayout)
  {
    QLog.d("ARTransferPromotionUIContainer", 2, "disattachFromRootViewGroup");
    if (!this.jdField_a_of_type_Boolean) {}
    while (Thread.currentThread() != Looper.getMainLooper().getThread()) {
      return;
    }
    paramRelativeLayout.removeView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amoy
 * JD-Core Version:    0.7.0.1
 */