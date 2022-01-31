import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.text.SimpleDateFormat;
import java.util.Date;

class bmyr
  extends bmym<bmyp>
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367796);
  private ImageView b = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367797);
  private ImageView c = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370657);
  private ImageView d = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370658);
  
  private bmyr(bmyp parambmyp, @NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramContext, paramViewGroup);
  }
  
  protected View a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramContext).inflate(2131561591, paramViewGroup, false);
  }
  
  void a(ImageView paramImageView, char paramChar)
  {
    switch (paramChar)
    {
    default: 
      return;
    case '0': 
      paramImageView.setImageResource(2130846235);
      return;
    case '1': 
      paramImageView.setImageResource(2130846236);
      return;
    case '2': 
      paramImageView.setImageResource(2130846237);
      return;
    case '3': 
      paramImageView.setImageResource(2130846238);
      return;
    case '4': 
      paramImageView.setImageResource(2130846239);
      return;
    case '5': 
      paramImageView.setImageResource(2130846240);
      return;
    case '6': 
      paramImageView.setImageResource(2130846241);
      return;
    case '7': 
      paramImageView.setImageResource(2130846242);
      return;
    case '8': 
      paramImageView.setImageResource(2130846243);
      return;
    }
    paramImageView.setImageResource(2130846244);
  }
  
  public void a(bmyp parambmyp, int paramInt)
  {
    super.a(parambmyp, paramInt);
    parambmyp = new SimpleDateFormat("HH:mm");
    ((bmyp)this.jdField_a_of_type_Bmyl).c = parambmyp.format(new Date());
    wxe.b("TimeFilterData", "TimeFilterData time:" + ((bmyp)this.jdField_a_of_type_Bmyl).c);
    a(this.jdField_a_of_type_AndroidWidgetImageView, ((bmyp)this.jdField_a_of_type_Bmyl).c.charAt(0));
    a(this.b, ((bmyp)this.jdField_a_of_type_Bmyl).c.charAt(1));
    a(this.c, ((bmyp)this.jdField_a_of_type_Bmyl).c.charAt(3));
    a(this.d, ((bmyp)this.jdField_a_of_type_Bmyl).c.charAt(4));
    paramInt = xsm.d(this.jdField_a_of_type_AndroidViewView.getContext());
    this.jdField_a_of_type_AndroidViewView.setPadding(0, paramInt / 3 * 2, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmyr
 * JD-Core Version:    0.7.0.1
 */