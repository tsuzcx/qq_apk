import android.view.View;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite.HWReciteItem;

public class azbx
  extends azaz
{
  int jdField_a_of_type_Int;
  View jdField_a_of_type_AndroidViewView;
  public azbu a;
  azby jdField_a_of_type_Azby;
  public azca a;
  
  public azbx(View paramView)
  {
    super(paramView);
    View localView1 = paramView.findViewById(2131303350);
    View localView2 = paramView.findViewById(2131303296);
    View localView3 = paramView.findViewById(2131303349);
    this.jdField_a_of_type_Azca = new azca(localView1);
    this.jdField_a_of_type_Azbu = new azbu(localView2);
    this.jdField_a_of_type_Azby = new azby(localView3);
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void a(View paramView, HWReciteItem paramHWReciteItem)
  {
    switch (((azac)this.jdField_a_of_type_Azaa).jdField_a_of_type_Int)
    {
    default: 
      return;
    case 2: 
      if (this.jdField_a_of_type_Int == 2)
      {
        this.jdField_a_of_type_Azbu.a(paramView, paramHWReciteItem, this);
        return;
      }
      this.jdField_a_of_type_Azca.a(paramView, paramHWReciteItem, this);
      return;
    }
    this.jdField_a_of_type_Azby.a(paramView, paramHWReciteItem, this);
  }
  
  public void a(HWReciteItem paramHWReciteItem, azac paramazac, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    switch (paramazac.jdField_a_of_type_Int)
    {
    default: 
      this.jdField_a_of_type_Azca.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Azbu.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Azby.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    case 2: 
      if (paramInt == 2)
      {
        paramazac.g = 0;
        this.jdField_a_of_type_Azca.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_Azbu.a(paramHWReciteItem, this, paramazac, paramInt);
        this.jdField_a_of_type_Azby.jdField_a_of_type_AndroidViewView.setVisibility(8);
        return;
      }
      paramazac.g = 3;
      this.jdField_a_of_type_Azca.a(paramHWReciteItem, this, paramazac, paramInt);
      this.jdField_a_of_type_Azbu.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Azby.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_Azca.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_Azbu.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_Azby.a(paramHWReciteItem, this, paramazac, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azbx
 * JD-Core Version:    0.7.0.1
 */