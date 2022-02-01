import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLImageView;

public class bbvo
  extends bbvn
{
  public RelativeLayout a;
  public TextView a;
  public URLImageView a;
  public TextView b;
  public TextView c;
  public TextView d;
  
  public bbvo(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  protected void a()
  {
    super.a();
    View localView = a(this.jdField_c_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131369536));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131363394));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131368138));
    this.b = ((TextView)localView.findViewById(2131366640));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131377088));
    this.d = ((TextView)localView.findViewById(2131362008));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbvo
 * JD-Core Version:    0.7.0.1
 */