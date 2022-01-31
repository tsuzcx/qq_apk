import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.text.SimpleDateFormat;
import java.util.Date;

class bkiv
  extends bkiq<bkit>
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367657);
  private ImageView b = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367658);
  private ImageView c = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370334);
  private ImageView d = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370335);
  
  private bkiv(bkit parambkit, @NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramContext, paramViewGroup);
  }
  
  protected View a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramContext).inflate(2131561383, paramViewGroup, false);
  }
  
  void a(ImageView paramImageView, char paramChar)
  {
    switch (paramChar)
    {
    default: 
      return;
    case '0': 
      paramImageView.setImageResource(2130845783);
      return;
    case '1': 
      paramImageView.setImageResource(2130845784);
      return;
    case '2': 
      paramImageView.setImageResource(2130845785);
      return;
    case '3': 
      paramImageView.setImageResource(2130845786);
      return;
    case '4': 
      paramImageView.setImageResource(2130845787);
      return;
    case '5': 
      paramImageView.setImageResource(2130845788);
      return;
    case '6': 
      paramImageView.setImageResource(2130845789);
      return;
    case '7': 
      paramImageView.setImageResource(2130845790);
      return;
    case '8': 
      paramImageView.setImageResource(2130845791);
      return;
    }
    paramImageView.setImageResource(2130845792);
  }
  
  public void a(bkit parambkit, int paramInt)
  {
    super.a(parambkit, paramInt);
    parambkit = new SimpleDateFormat("HH:mm");
    ((bkit)this.jdField_a_of_type_Bkip).c = parambkit.format(new Date());
    ved.b("TimeFilterData", "TimeFilterData time:" + ((bkit)this.jdField_a_of_type_Bkip).c);
    a(this.jdField_a_of_type_AndroidWidgetImageView, ((bkit)this.jdField_a_of_type_Bkip).c.charAt(0));
    a(this.b, ((bkit)this.jdField_a_of_type_Bkip).c.charAt(1));
    a(this.c, ((bkit)this.jdField_a_of_type_Bkip).c.charAt(3));
    a(this.d, ((bkit)this.jdField_a_of_type_Bkip).c.charAt(4));
    paramInt = vzl.d(this.jdField_a_of_type_AndroidViewView.getContext());
    this.jdField_a_of_type_AndroidViewView.setPadding(0, paramInt / 3 * 2, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkiv
 * JD-Core Version:    0.7.0.1
 */