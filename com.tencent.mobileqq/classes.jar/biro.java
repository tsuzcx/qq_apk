import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.text.SimpleDateFormat;
import java.util.Date;

class biro
  extends bire<birm>
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302039);
  private ImageView b = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302040);
  private ImageView c = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131304679);
  private ImageView d = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131304680);
  
  private biro(birm parambirm, @NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramContext, paramViewGroup);
  }
  
  protected View a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramContext).inflate(2131495793, paramViewGroup, false);
  }
  
  void a(ImageView paramImageView, char paramChar)
  {
    switch (paramChar)
    {
    default: 
      return;
    case '0': 
      paramImageView.setImageResource(2130845594);
      return;
    case '1': 
      paramImageView.setImageResource(2130845595);
      return;
    case '2': 
      paramImageView.setImageResource(2130845596);
      return;
    case '3': 
      paramImageView.setImageResource(2130845597);
      return;
    case '4': 
      paramImageView.setImageResource(2130845598);
      return;
    case '5': 
      paramImageView.setImageResource(2130845599);
      return;
    case '6': 
      paramImageView.setImageResource(2130845600);
      return;
    case '7': 
      paramImageView.setImageResource(2130845601);
      return;
    case '8': 
      paramImageView.setImageResource(2130845602);
      return;
    }
    paramImageView.setImageResource(2130845603);
  }
  
  public void a(birm parambirm, int paramInt)
  {
    super.a(parambirm, paramInt);
    parambirm = new SimpleDateFormat("HH:mm");
    ((birm)this.jdField_a_of_type_Bird).c = parambirm.format(new Date());
    urk.b("TimeFilterData", "TimeFilterData time:" + ((birm)this.jdField_a_of_type_Bird).c);
    a(this.jdField_a_of_type_AndroidWidgetImageView, ((birm)this.jdField_a_of_type_Bird).c.charAt(0));
    a(this.b, ((birm)this.jdField_a_of_type_Bird).c.charAt(1));
    a(this.c, ((birm)this.jdField_a_of_type_Bird).c.charAt(3));
    a(this.d, ((birm)this.jdField_a_of_type_Bird).c.charAt(4));
    paramInt = vms.d(this.jdField_a_of_type_AndroidViewView.getContext());
    this.jdField_a_of_type_AndroidViewView.setPadding(0, paramInt / 3 * 2, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biro
 * JD-Core Version:    0.7.0.1
 */