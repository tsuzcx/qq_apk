import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.widget.MaxHeightRelativelayout;

public abstract class aqdv
{
  protected Context a;
  protected View a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected bbgu a;
  protected MaxHeightRelativelayout a;
  
  public aqdv(bbgu parambbgu)
  {
    this.jdField_a_of_type_Bbgu = parambbgu;
    this.jdField_a_of_type_AndroidContentContext = parambbgu.getContext();
    a();
    this.jdField_a_of_type_ComTencentWidgetMaxHeightRelativelayout.setMaxHeight(Math.max(parambbgu.getRootViewHeight() - this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296975), actj.a(a(), this.jdField_a_of_type_AndroidContentContext.getResources())));
  }
  
  protected int a()
  {
    return 380;
  }
  
  protected abstract View a();
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558887, null);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378547));
    this.jdField_a_of_type_ComTencentWidgetMaxHeightRelativelayout = ((MaxHeightRelativelayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131375364));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368032));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131375397));
    View localView = a();
    if (localView != null) {
      this.jdField_a_of_type_ComTencentWidgetMaxHeightRelativelayout.addView(localView);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new aqdw(this));
    int i = bbll.a(15.0F);
    actj.a(this.jdField_a_of_type_AndroidWidgetImageView, i, i, i, i);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(ajya.a(2131704780));
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public View b()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void b()
  {
    c();
    this.jdField_a_of_type_Bbgu.removePreviewView();
  }
  
  protected void c() {}
  
  protected void d()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
  }
  
  public void e()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqdv
 * JD-Core Version:    0.7.0.1
 */