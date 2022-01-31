import android.view.View;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite.HWReciteItem;

public class badd
  extends bacf
{
  int jdField_a_of_type_Int;
  View jdField_a_of_type_AndroidViewView;
  public bada a;
  bade jdField_a_of_type_Bade;
  public badg a;
  
  public badd(View paramView)
  {
    super(paramView);
    View localView1 = paramView.findViewById(2131369017);
    View localView2 = paramView.findViewById(2131368963);
    View localView3 = paramView.findViewById(2131369016);
    this.jdField_a_of_type_Badg = new badg(localView1);
    this.jdField_a_of_type_Bada = new bada(localView2);
    this.jdField_a_of_type_Bade = new bade(localView3);
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void a(View paramView, HWReciteItem paramHWReciteItem)
  {
    switch (((babi)this.jdField_a_of_type_Babg).jdField_a_of_type_Int)
    {
    default: 
      return;
    case 2: 
      if (this.jdField_a_of_type_Int == 2)
      {
        this.jdField_a_of_type_Bada.a(paramView, paramHWReciteItem, this);
        return;
      }
      this.jdField_a_of_type_Badg.a(paramView, paramHWReciteItem, this);
      return;
    }
    this.jdField_a_of_type_Bade.a(paramView, paramHWReciteItem, this);
  }
  
  public void a(HWReciteItem paramHWReciteItem, babi parambabi, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    switch (parambabi.jdField_a_of_type_Int)
    {
    default: 
      this.jdField_a_of_type_Badg.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Bada.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Bade.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    case 2: 
      if (paramInt == 2)
      {
        parambabi.g = 0;
        this.jdField_a_of_type_Badg.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_Bada.a(paramHWReciteItem, this, parambabi, paramInt);
        this.jdField_a_of_type_Bade.jdField_a_of_type_AndroidViewView.setVisibility(8);
        return;
      }
      parambabi.g = 3;
      this.jdField_a_of_type_Badg.a(paramHWReciteItem, this, parambabi, paramInt);
      this.jdField_a_of_type_Bada.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Bade.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_Badg.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_Bada.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_Bade.a(paramHWReciteItem, this, parambabi, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     badd
 * JD-Core Version:    0.7.0.1
 */