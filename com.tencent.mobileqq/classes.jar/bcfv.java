import android.view.View;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite.HWReciteItem;

public class bcfv
  extends bcex
{
  int jdField_a_of_type_Int;
  View jdField_a_of_type_AndroidViewView;
  public bcfs a;
  bcfw jdField_a_of_type_Bcfw;
  public bcfy a;
  
  public bcfv(View paramView)
  {
    super(paramView);
    View localView1 = paramView.findViewById(2131369265);
    View localView2 = paramView.findViewById(2131369211);
    View localView3 = paramView.findViewById(2131369264);
    this.jdField_a_of_type_Bcfy = new bcfy(localView1);
    this.jdField_a_of_type_Bcfs = new bcfs(localView2);
    this.jdField_a_of_type_Bcfw = new bcfw(localView3);
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void a(View paramView, HWReciteItem paramHWReciteItem)
  {
    switch (((bcea)this.jdField_a_of_type_Bcdy).jdField_a_of_type_Int)
    {
    default: 
      return;
    case 2: 
      if (this.jdField_a_of_type_Int == 2)
      {
        this.jdField_a_of_type_Bcfs.a(paramView, paramHWReciteItem, this);
        return;
      }
      this.jdField_a_of_type_Bcfy.a(paramView, paramHWReciteItem, this);
      return;
    }
    this.jdField_a_of_type_Bcfw.a(paramView, paramHWReciteItem, this);
  }
  
  public void a(HWReciteItem paramHWReciteItem, bcea parambcea, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    switch (parambcea.jdField_a_of_type_Int)
    {
    default: 
      this.jdField_a_of_type_Bcfy.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Bcfs.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Bcfw.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    case 2: 
      if (paramInt == 2)
      {
        parambcea.g = 0;
        this.jdField_a_of_type_Bcfy.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_Bcfs.a(paramHWReciteItem, this, parambcea, paramInt);
        this.jdField_a_of_type_Bcfw.jdField_a_of_type_AndroidViewView.setVisibility(8);
        return;
      }
      parambcea.g = 3;
      this.jdField_a_of_type_Bcfy.a(paramHWReciteItem, this, parambcea, paramInt);
      this.jdField_a_of_type_Bcfs.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Bcfw.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_Bcfy.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_Bcfs.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_Bcfw.a(paramHWReciteItem, this, parambcea, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcfv
 * JD-Core Version:    0.7.0.1
 */