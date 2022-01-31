import android.view.View;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite.HWReciteItem;

public class bcbm
  extends bcao
{
  int jdField_a_of_type_Int;
  View jdField_a_of_type_AndroidViewView;
  public bcbj a;
  bcbn jdField_a_of_type_Bcbn;
  public bcbp a;
  
  public bcbm(View paramView)
  {
    super(paramView);
    View localView1 = paramView.findViewById(2131369247);
    View localView2 = paramView.findViewById(2131369193);
    View localView3 = paramView.findViewById(2131369246);
    this.jdField_a_of_type_Bcbp = new bcbp(localView1);
    this.jdField_a_of_type_Bcbj = new bcbj(localView2);
    this.jdField_a_of_type_Bcbn = new bcbn(localView3);
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void a(View paramView, HWReciteItem paramHWReciteItem)
  {
    switch (((bbzr)this.jdField_a_of_type_Bbzp).jdField_a_of_type_Int)
    {
    default: 
      return;
    case 2: 
      if (this.jdField_a_of_type_Int == 2)
      {
        this.jdField_a_of_type_Bcbj.a(paramView, paramHWReciteItem, this);
        return;
      }
      this.jdField_a_of_type_Bcbp.a(paramView, paramHWReciteItem, this);
      return;
    }
    this.jdField_a_of_type_Bcbn.a(paramView, paramHWReciteItem, this);
  }
  
  public void a(HWReciteItem paramHWReciteItem, bbzr parambbzr, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    switch (parambbzr.jdField_a_of_type_Int)
    {
    default: 
      this.jdField_a_of_type_Bcbp.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Bcbj.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Bcbn.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    case 2: 
      if (paramInt == 2)
      {
        parambbzr.g = 0;
        this.jdField_a_of_type_Bcbp.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_Bcbj.a(paramHWReciteItem, this, parambbzr, paramInt);
        this.jdField_a_of_type_Bcbn.jdField_a_of_type_AndroidViewView.setVisibility(8);
        return;
      }
      parambbzr.g = 3;
      this.jdField_a_of_type_Bcbp.a(paramHWReciteItem, this, parambbzr, paramInt);
      this.jdField_a_of_type_Bcbj.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Bcbn.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_Bcbp.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_Bcbj.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_Bcbn.a(paramHWReciteItem, this, parambbzr, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcbm
 * JD-Core Version:    0.7.0.1
 */