import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.text.SimpleDateFormat;
import java.util.Date;

class bmuf
  extends bmua<bmud>
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367786);
  private ImageView b = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367787);
  private ImageView c = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370638);
  private ImageView d = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370639);
  
  private bmuf(bmud parambmud, @NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramContext, paramViewGroup);
  }
  
  protected View a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramContext).inflate(2131561573, paramViewGroup, false);
  }
  
  void a(ImageView paramImageView, char paramChar)
  {
    switch (paramChar)
    {
    default: 
      return;
    case '0': 
      paramImageView.setImageResource(2130846162);
      return;
    case '1': 
      paramImageView.setImageResource(2130846163);
      return;
    case '2': 
      paramImageView.setImageResource(2130846164);
      return;
    case '3': 
      paramImageView.setImageResource(2130846165);
      return;
    case '4': 
      paramImageView.setImageResource(2130846166);
      return;
    case '5': 
      paramImageView.setImageResource(2130846167);
      return;
    case '6': 
      paramImageView.setImageResource(2130846168);
      return;
    case '7': 
      paramImageView.setImageResource(2130846169);
      return;
    case '8': 
      paramImageView.setImageResource(2130846170);
      return;
    }
    paramImageView.setImageResource(2130846171);
  }
  
  public void a(bmud parambmud, int paramInt)
  {
    super.a(parambmud, paramInt);
    parambmud = new SimpleDateFormat("HH:mm");
    ((bmud)this.jdField_a_of_type_Bmtz).c = parambmud.format(new Date());
    wsv.b("TimeFilterData", "TimeFilterData time:" + ((bmud)this.jdField_a_of_type_Bmtz).c);
    a(this.jdField_a_of_type_AndroidWidgetImageView, ((bmud)this.jdField_a_of_type_Bmtz).c.charAt(0));
    a(this.b, ((bmud)this.jdField_a_of_type_Bmtz).c.charAt(1));
    a(this.c, ((bmud)this.jdField_a_of_type_Bmtz).c.charAt(3));
    a(this.d, ((bmud)this.jdField_a_of_type_Bmtz).c.charAt(4));
    paramInt = xod.d(this.jdField_a_of_type_AndroidViewView.getContext());
    this.jdField_a_of_type_AndroidViewView.setPadding(0, paramInt / 3 * 2, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmuf
 * JD-Core Version:    0.7.0.1
 */