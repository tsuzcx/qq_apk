import android.view.View;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite.HWReciteItem;

public class bepl
  extends beon
{
  int jdField_a_of_type_Int;
  View jdField_a_of_type_AndroidViewView;
  public bepi a;
  bepm jdField_a_of_type_Bepm;
  public bepo a;
  
  public bepl(View paramView)
  {
    super(paramView);
    View localView1 = paramView.findViewById(2131369738);
    View localView2 = paramView.findViewById(2131369684);
    View localView3 = paramView.findViewById(2131369737);
    this.jdField_a_of_type_Bepo = new bepo(localView1);
    this.jdField_a_of_type_Bepi = new bepi(localView2);
    this.jdField_a_of_type_Bepm = new bepm(localView3);
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void a(View paramView, HWReciteItem paramHWReciteItem)
  {
    switch (((benq)this.jdField_a_of_type_Beno).jdField_a_of_type_Int)
    {
    default: 
      return;
    case 2: 
      if (this.jdField_a_of_type_Int == 2)
      {
        this.jdField_a_of_type_Bepi.a(paramView, paramHWReciteItem, this);
        return;
      }
      this.jdField_a_of_type_Bepo.a(paramView, paramHWReciteItem, this);
      return;
    }
    this.jdField_a_of_type_Bepm.a(paramView, paramHWReciteItem, this);
  }
  
  public void a(HWReciteItem paramHWReciteItem, benq parambenq, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    switch (parambenq.jdField_a_of_type_Int)
    {
    default: 
      this.jdField_a_of_type_Bepo.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Bepi.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Bepm.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    case 2: 
      if (paramInt == 2)
      {
        parambenq.g = 0;
        this.jdField_a_of_type_Bepo.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_Bepi.a(paramHWReciteItem, this, parambenq, paramInt);
        this.jdField_a_of_type_Bepm.jdField_a_of_type_AndroidViewView.setVisibility(8);
        return;
      }
      parambenq.g = 3;
      this.jdField_a_of_type_Bepo.a(paramHWReciteItem, this, parambenq, paramInt);
      this.jdField_a_of_type_Bepi.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Bepm.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_Bepo.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_Bepi.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_Bepm.a(paramHWReciteItem, this, parambenq, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bepl
 * JD-Core Version:    0.7.0.1
 */