import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqstory.view.AnimationPoint;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class ayix
  extends ReportDialog
{
  protected TextView a;
  protected AnimationPoint a;
  
  public ayix(Context paramContext)
  {
    super(paramContext, 2131755017);
    paramContext = LayoutInflater.from(paramContext).inflate(2131561792, null);
    paramContext.setOnTouchListener(new ayiy(this));
    super.setContentView(paramContext);
    this.jdField_a_of_type_ComTencentBizQqstoryViewAnimationPoint = ((AnimationPoint)super.findViewById(2131362692));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131367800));
    this.jdField_a_of_type_ComTencentBizQqstoryViewAnimationPoint.setDuration(-1L);
    this.jdField_a_of_type_ComTencentBizQqstoryViewAnimationPoint.setOnAnimationListener(new ayiz(this));
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
 * Qualified Name:     ayix
 * JD-Core Version:    0.7.0.1
 */