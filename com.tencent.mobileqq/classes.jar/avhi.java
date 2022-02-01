import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.widget.ThemeImageView;

public class avhi
  extends RecyclerView.ViewHolder
{
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private ThemeImageView jdField_a_of_type_ComTencentWidgetThemeImageView;
  private TextView b;
  private TextView c;
  
  avhi(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131368785));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368787));
    this.b = ((TextView)paramView.findViewById(2131368790));
    this.jdField_a_of_type_ComTencentWidgetThemeImageView = ((ThemeImageView)paramView.findViewById(2131368783));
    this.c = ((TextView)paramView.findViewById(2131368789));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131368788));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131368784);
  }
  
  View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  Button a()
  {
    return this.jdField_a_of_type_AndroidWidgetButton;
  }
  
  TextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  URLImageView a()
  {
    return this.jdField_a_of_type_ComTencentImageURLImageView;
  }
  
  public ThemeImageView a()
  {
    return this.jdField_a_of_type_ComTencentWidgetThemeImageView;
  }
  
  TextView b()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avhi
 * JD-Core Version:    0.7.0.1
 */