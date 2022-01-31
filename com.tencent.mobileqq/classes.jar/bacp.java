import android.view.View;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite.HWReciteItem;

public class bacp
  extends babr
{
  int jdField_a_of_type_Int;
  View jdField_a_of_type_AndroidViewView;
  public bacm a;
  bacq jdField_a_of_type_Bacq;
  public bacs a;
  
  public bacp(View paramView)
  {
    super(paramView);
    View localView1 = paramView.findViewById(2131369017);
    View localView2 = paramView.findViewById(2131368963);
    View localView3 = paramView.findViewById(2131369016);
    this.jdField_a_of_type_Bacs = new bacs(localView1);
    this.jdField_a_of_type_Bacm = new bacm(localView2);
    this.jdField_a_of_type_Bacq = new bacq(localView3);
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void a(View paramView, HWReciteItem paramHWReciteItem)
  {
    switch (((baau)this.jdField_a_of_type_Baas).jdField_a_of_type_Int)
    {
    default: 
      return;
    case 2: 
      if (this.jdField_a_of_type_Int == 2)
      {
        this.jdField_a_of_type_Bacm.a(paramView, paramHWReciteItem, this);
        return;
      }
      this.jdField_a_of_type_Bacs.a(paramView, paramHWReciteItem, this);
      return;
    }
    this.jdField_a_of_type_Bacq.a(paramView, paramHWReciteItem, this);
  }
  
  public void a(HWReciteItem paramHWReciteItem, baau parambaau, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    switch (parambaau.jdField_a_of_type_Int)
    {
    default: 
      this.jdField_a_of_type_Bacs.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Bacm.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Bacq.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    case 2: 
      if (paramInt == 2)
      {
        parambaau.g = 0;
        this.jdField_a_of_type_Bacs.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_Bacm.a(paramHWReciteItem, this, parambaau, paramInt);
        this.jdField_a_of_type_Bacq.jdField_a_of_type_AndroidViewView.setVisibility(8);
        return;
      }
      parambaau.g = 3;
      this.jdField_a_of_type_Bacs.a(paramHWReciteItem, this, parambaau, paramInt);
      this.jdField_a_of_type_Bacm.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Bacq.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_Bacs.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_Bacm.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_Bacq.a(paramHWReciteItem, this, parambaau, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bacp
 * JD-Core Version:    0.7.0.1
 */