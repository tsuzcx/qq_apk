import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.text.SimpleDateFormat;
import java.util.Date;

class bppx
  extends bpps<bppv>
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368114);
  private ImageView b = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368115);
  private ImageView c = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371211);
  private ImageView d = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371212);
  
  private bppx(bppv parambppv, @NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramContext, paramViewGroup);
  }
  
  protected View a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramContext).inflate(2131561826, paramViewGroup, false);
  }
  
  void a(ImageView paramImageView, char paramChar)
  {
    switch (paramChar)
    {
    default: 
      return;
    case '0': 
      paramImageView.setImageResource(2130846674);
      return;
    case '1': 
      paramImageView.setImageResource(2130846675);
      return;
    case '2': 
      paramImageView.setImageResource(2130846676);
      return;
    case '3': 
      paramImageView.setImageResource(2130846677);
      return;
    case '4': 
      paramImageView.setImageResource(2130846678);
      return;
    case '5': 
      paramImageView.setImageResource(2130846679);
      return;
    case '6': 
      paramImageView.setImageResource(2130846680);
      return;
    case '7': 
      paramImageView.setImageResource(2130846681);
      return;
    case '8': 
      paramImageView.setImageResource(2130846682);
      return;
    }
    paramImageView.setImageResource(2130846683);
  }
  
  public void a(bppv parambppv, int paramInt)
  {
    super.a(parambppv, paramInt);
    parambppv = new SimpleDateFormat("HH:mm");
    ((bppv)this.jdField_a_of_type_Bppr).c = parambppv.format(new Date());
    yqp.b("TimeFilterData", "TimeFilterData time:" + ((bppv)this.jdField_a_of_type_Bppr).c);
    a(this.jdField_a_of_type_AndroidWidgetImageView, ((bppv)this.jdField_a_of_type_Bppr).c.charAt(0));
    a(this.b, ((bppv)this.jdField_a_of_type_Bppr).c.charAt(1));
    a(this.c, ((bppv)this.jdField_a_of_type_Bppr).c.charAt(3));
    a(this.d, ((bppv)this.jdField_a_of_type_Bppr).c.charAt(4));
    paramInt = zlx.d(this.jdField_a_of_type_AndroidViewView.getContext());
    this.jdField_a_of_type_AndroidViewView.setPadding(0, paramInt / 3 * 2, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bppx
 * JD-Core Version:    0.7.0.1
 */