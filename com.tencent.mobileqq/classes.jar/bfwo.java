import android.view.View;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite.HWReciteItem;

public class bfwo
  extends bfvq
{
  int jdField_a_of_type_Int;
  View jdField_a_of_type_AndroidViewView;
  public bfwl a;
  bfwp jdField_a_of_type_Bfwp;
  public bfwr a;
  
  public bfwo(View paramView)
  {
    super(paramView);
    View localView1 = paramView.findViewById(2131369907);
    View localView2 = paramView.findViewById(2131369853);
    View localView3 = paramView.findViewById(2131369906);
    this.jdField_a_of_type_Bfwr = new bfwr(localView1);
    this.jdField_a_of_type_Bfwl = new bfwl(localView2);
    this.jdField_a_of_type_Bfwp = new bfwp(localView3);
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void a(View paramView, HWReciteItem paramHWReciteItem)
  {
    switch (((bfut)this.jdField_a_of_type_Bfur).jdField_a_of_type_Int)
    {
    default: 
      return;
    case 2: 
      if (this.jdField_a_of_type_Int == 2)
      {
        this.jdField_a_of_type_Bfwl.a(paramView, paramHWReciteItem, this);
        return;
      }
      this.jdField_a_of_type_Bfwr.a(paramView, paramHWReciteItem, this);
      return;
    }
    this.jdField_a_of_type_Bfwp.a(paramView, paramHWReciteItem, this);
  }
  
  public void a(HWReciteItem paramHWReciteItem, bfut parambfut, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    switch (parambfut.jdField_a_of_type_Int)
    {
    default: 
      this.jdField_a_of_type_Bfwr.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Bfwl.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Bfwp.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    case 2: 
      if (paramInt == 2)
      {
        parambfut.g = 0;
        this.jdField_a_of_type_Bfwr.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_Bfwl.a(paramHWReciteItem, this, parambfut, paramInt);
        this.jdField_a_of_type_Bfwp.jdField_a_of_type_AndroidViewView.setVisibility(8);
        return;
      }
      parambfut.g = 3;
      this.jdField_a_of_type_Bfwr.a(paramHWReciteItem, this, parambfut, paramInt);
      this.jdField_a_of_type_Bfwl.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Bfwp.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_Bfwr.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_Bfwl.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_Bfwp.a(paramHWReciteItem, this, parambfut, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfwo
 * JD-Core Version:    0.7.0.1
 */