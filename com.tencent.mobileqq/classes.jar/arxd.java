import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.widget.MaxHeightRelativelayout;

public abstract class arxd
{
  protected Context a;
  protected View a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected bdfq a;
  protected MaxHeightRelativelayout a;
  
  public arxd(bdfq parambdfq)
  {
    this.jdField_a_of_type_Bdfq = parambdfq;
    this.jdField_a_of_type_AndroidContentContext = parambdfq.getContext();
    a();
    this.jdField_a_of_type_ComTencentWidgetMaxHeightRelativelayout.setMaxHeight(Math.max(parambdfq.getRootViewHeight() - this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296991), aekt.a(a(), this.jdField_a_of_type_AndroidContentContext.getResources())));
  }
  
  protected int a()
  {
    return 380;
  }
  
  protected abstract View a();
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558924, null);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379159));
    this.jdField_a_of_type_ComTencentWidgetMaxHeightRelativelayout = ((MaxHeightRelativelayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131375849));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368170));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131375882));
    View localView = a();
    if (localView != null) {
      this.jdField_a_of_type_ComTencentWidgetMaxHeightRelativelayout.addView(localView);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new arxe(this));
    int i = bdkf.a(15.0F);
    aekt.a(this.jdField_a_of_type_AndroidWidgetImageView, i, i, i, i);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(alpo.a(2131705152));
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
    this.jdField_a_of_type_Bdfq.removePreviewView();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arxd
 * JD-Core Version:    0.7.0.1
 */