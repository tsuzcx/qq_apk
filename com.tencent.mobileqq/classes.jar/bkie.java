import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.text.SimpleDateFormat;
import java.util.Date;

class bkie
  extends bkhz<bkic>
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367657);
  private ImageView b = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367658);
  private ImageView c = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370335);
  private ImageView d = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370336);
  
  private bkie(bkic parambkic, @NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramContext, paramViewGroup);
  }
  
  protected View a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramContext).inflate(2131561384, paramViewGroup, false);
  }
  
  void a(ImageView paramImageView, char paramChar)
  {
    switch (paramChar)
    {
    default: 
      return;
    case '0': 
      paramImageView.setImageResource(2130845777);
      return;
    case '1': 
      paramImageView.setImageResource(2130845778);
      return;
    case '2': 
      paramImageView.setImageResource(2130845779);
      return;
    case '3': 
      paramImageView.setImageResource(2130845780);
      return;
    case '4': 
      paramImageView.setImageResource(2130845781);
      return;
    case '5': 
      paramImageView.setImageResource(2130845782);
      return;
    case '6': 
      paramImageView.setImageResource(2130845783);
      return;
    case '7': 
      paramImageView.setImageResource(2130845784);
      return;
    case '8': 
      paramImageView.setImageResource(2130845785);
      return;
    }
    paramImageView.setImageResource(2130845786);
  }
  
  public void a(bkic parambkic, int paramInt)
  {
    super.a(parambkic, paramInt);
    parambkic = new SimpleDateFormat("HH:mm");
    ((bkic)this.jdField_a_of_type_Bkhy).c = parambkic.format(new Date());
    veg.b("TimeFilterData", "TimeFilterData time:" + ((bkic)this.jdField_a_of_type_Bkhy).c);
    a(this.jdField_a_of_type_AndroidWidgetImageView, ((bkic)this.jdField_a_of_type_Bkhy).c.charAt(0));
    a(this.b, ((bkic)this.jdField_a_of_type_Bkhy).c.charAt(1));
    a(this.c, ((bkic)this.jdField_a_of_type_Bkhy).c.charAt(3));
    a(this.d, ((bkic)this.jdField_a_of_type_Bkhy).c.charAt(4));
    paramInt = vzo.d(this.jdField_a_of_type_AndroidViewView.getContext());
    this.jdField_a_of_type_AndroidViewView.setPadding(0, paramInt / 3 * 2, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkie
 * JD-Core Version:    0.7.0.1
 */