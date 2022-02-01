import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.text.SimpleDateFormat;
import java.util.Date;

class bqrs
  extends bqrn<bqrq>
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368186);
  private ImageView b = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368187);
  private ImageView c = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371318);
  private ImageView d = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371319);
  
  private bqrs(bqrq parambqrq, @NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramContext, paramViewGroup);
  }
  
  protected View a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramContext).inflate(2131561867, paramViewGroup, false);
  }
  
  void a(ImageView paramImageView, char paramChar)
  {
    switch (paramChar)
    {
    default: 
      return;
    case '0': 
      paramImageView.setImageResource(2130846691);
      return;
    case '1': 
      paramImageView.setImageResource(2130846692);
      return;
    case '2': 
      paramImageView.setImageResource(2130846693);
      return;
    case '3': 
      paramImageView.setImageResource(2130846694);
      return;
    case '4': 
      paramImageView.setImageResource(2130846695);
      return;
    case '5': 
      paramImageView.setImageResource(2130846696);
      return;
    case '6': 
      paramImageView.setImageResource(2130846697);
      return;
    case '7': 
      paramImageView.setImageResource(2130846698);
      return;
    case '8': 
      paramImageView.setImageResource(2130846699);
      return;
    }
    paramImageView.setImageResource(2130846700);
  }
  
  public void a(bqrq parambqrq, int paramInt)
  {
    super.a(parambqrq, paramInt);
    parambqrq = new SimpleDateFormat("HH:mm");
    ((bqrq)this.jdField_a_of_type_Bqrm).c = parambqrq.format(new Date());
    yuk.b("TimeFilterData", "TimeFilterData time:" + ((bqrq)this.jdField_a_of_type_Bqrm).c);
    a(this.jdField_a_of_type_AndroidWidgetImageView, ((bqrq)this.jdField_a_of_type_Bqrm).c.charAt(0));
    a(this.b, ((bqrq)this.jdField_a_of_type_Bqrm).c.charAt(1));
    a(this.c, ((bqrq)this.jdField_a_of_type_Bqrm).c.charAt(3));
    a(this.d, ((bqrq)this.jdField_a_of_type_Bqrm).c.charAt(4));
    paramInt = zps.d(this.jdField_a_of_type_AndroidViewView.getContext());
    this.jdField_a_of_type_AndroidViewView.setPadding(0, paramInt / 3 * 2, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqrs
 * JD-Core Version:    0.7.0.1
 */