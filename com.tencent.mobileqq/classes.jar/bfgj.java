import android.view.View;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite.HWReciteItem;

public class bfgj
  extends bffl
{
  int jdField_a_of_type_Int;
  View jdField_a_of_type_AndroidViewView;
  public bfgg a;
  bfgk jdField_a_of_type_Bfgk;
  public bfgm a;
  
  public bfgj(View paramView)
  {
    super(paramView);
    View localView1 = paramView.findViewById(2131369655);
    View localView2 = paramView.findViewById(2131369602);
    View localView3 = paramView.findViewById(2131369654);
    this.jdField_a_of_type_Bfgm = new bfgm(localView1);
    this.jdField_a_of_type_Bfgg = new bfgg(localView2);
    this.jdField_a_of_type_Bfgk = new bfgk(localView3);
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void a(View paramView, HWReciteItem paramHWReciteItem)
  {
    switch (((bfeo)this.jdField_a_of_type_Bfem).jdField_a_of_type_Int)
    {
    default: 
      return;
    case 2: 
      if (this.jdField_a_of_type_Int == 2)
      {
        this.jdField_a_of_type_Bfgg.a(paramView, paramHWReciteItem, this);
        return;
      }
      this.jdField_a_of_type_Bfgm.a(paramView, paramHWReciteItem, this);
      return;
    }
    this.jdField_a_of_type_Bfgk.a(paramView, paramHWReciteItem, this);
  }
  
  public void a(HWReciteItem paramHWReciteItem, bfeo parambfeo, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    switch (parambfeo.jdField_a_of_type_Int)
    {
    default: 
      this.jdField_a_of_type_Bfgm.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Bfgg.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Bfgk.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    case 2: 
      if (paramInt == 2)
      {
        parambfeo.g = 0;
        this.jdField_a_of_type_Bfgm.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_Bfgg.a(paramHWReciteItem, this, parambfeo, paramInt);
        this.jdField_a_of_type_Bfgk.jdField_a_of_type_AndroidViewView.setVisibility(8);
        return;
      }
      parambfeo.g = 3;
      this.jdField_a_of_type_Bfgm.a(paramHWReciteItem, this, parambfeo, paramInt);
      this.jdField_a_of_type_Bfgg.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Bfgk.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_Bfgm.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_Bfgg.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_Bfgk.a(paramHWReciteItem, this, parambfeo, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfgj
 * JD-Core Version:    0.7.0.1
 */