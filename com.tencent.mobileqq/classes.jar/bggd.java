import android.view.View;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite.HWReciteItem;

public class bggd
  extends bgff
{
  int jdField_a_of_type_Int;
  View jdField_a_of_type_AndroidViewView;
  public bgga a;
  bgge jdField_a_of_type_Bgge;
  public bggg a;
  
  public bggd(View paramView)
  {
    super(paramView);
    View localView1 = paramView.findViewById(2131369749);
    View localView2 = paramView.findViewById(2131369696);
    View localView3 = paramView.findViewById(2131369748);
    this.jdField_a_of_type_Bggg = new bggg(localView1);
    this.jdField_a_of_type_Bgga = new bgga(localView2);
    this.jdField_a_of_type_Bgge = new bgge(localView3);
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void a(View paramView, HWReciteItem paramHWReciteItem)
  {
    switch (((bgei)this.jdField_a_of_type_Bgeg).jdField_a_of_type_Int)
    {
    default: 
      return;
    case 2: 
      if (this.jdField_a_of_type_Int == 2)
      {
        this.jdField_a_of_type_Bgga.a(paramView, paramHWReciteItem, this);
        return;
      }
      this.jdField_a_of_type_Bggg.a(paramView, paramHWReciteItem, this);
      return;
    }
    this.jdField_a_of_type_Bgge.a(paramView, paramHWReciteItem, this);
  }
  
  public void a(HWReciteItem paramHWReciteItem, bgei parambgei, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    switch (parambgei.jdField_a_of_type_Int)
    {
    default: 
      this.jdField_a_of_type_Bggg.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Bgga.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Bgge.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    case 2: 
      if (paramInt == 2)
      {
        parambgei.g = 0;
        this.jdField_a_of_type_Bggg.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_Bgga.a(paramHWReciteItem, this, parambgei, paramInt);
        this.jdField_a_of_type_Bgge.jdField_a_of_type_AndroidViewView.setVisibility(8);
        return;
      }
      parambgei.g = 3;
      this.jdField_a_of_type_Bggg.a(paramHWReciteItem, this, parambgei, paramInt);
      this.jdField_a_of_type_Bgga.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Bgge.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_Bggg.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_Bgga.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_Bgge.a(paramHWReciteItem, this, parambgei, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bggd
 * JD-Core Version:    0.7.0.1
 */