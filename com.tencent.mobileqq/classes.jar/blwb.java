import com.tencent.widget.AbsListView;
import java.util.ArrayList;

class blwb
  implements bhtv
{
  int jdField_a_of_type_Int = 0;
  
  blwb(blwa paramblwa) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 1) {
      bhsj.b(this.jdField_a_of_type_Blwa.h);
    }
    while ((paramInt != 0) || (this.jdField_a_of_type_Blwa.a == null) || (this.jdField_a_of_type_Int < this.jdField_a_of_type_Blwa.a.size())) {
      return;
    }
    blwa.a(this.jdField_a_of_type_Blwa);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blwb
 * JD-Core Version:    0.7.0.1
 */