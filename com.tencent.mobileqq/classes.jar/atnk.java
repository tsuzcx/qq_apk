import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqstory.view.AnimationPoint;

public class atnk
  extends Dialog
{
  protected TextView a;
  protected AnimationPoint a;
  
  public atnk(Context paramContext)
  {
    super(paramContext, 2131755014);
    paramContext = LayoutInflater.from(paramContext).inflate(2131561308, null);
    paramContext.setOnTouchListener(new atnl(this));
    super.setContentView(paramContext);
    this.jdField_a_of_type_ComTencentBizQqstoryViewAnimationPoint = ((AnimationPoint)super.findViewById(2131362546));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131367281));
    this.jdField_a_of_type_ComTencentBizQqstoryViewAnimationPoint.setDuration(-1L);
    this.jdField_a_of_type_ComTencentBizQqstoryViewAnimationPoint.setOnAnimationListener(new atnm(this));
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void dismiss()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewAnimationPoint.b();
    super.dismiss();
  }
  
  public void show()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewAnimationPoint.a();
    super.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atnk
 * JD-Core Version:    0.7.0.1
 */