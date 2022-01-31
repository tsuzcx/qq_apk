import com.tencent.widget.AbsListView;
import java.util.ArrayList;

class bjge
  implements bfos
{
  int jdField_a_of_type_Int = 0;
  
  bjge(bjgd parambjgd) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 1) {
      bfni.b(this.jdField_a_of_type_Bjgd.h);
    }
    while ((paramInt != 0) || (this.jdField_a_of_type_Bjgd.a == null) || (this.jdField_a_of_type_Int < this.jdField_a_of_type_Bjgd.a.size())) {
      return;
    }
    bjgd.a(this.jdField_a_of_type_Bjgd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjge
 * JD-Core Version:    0.7.0.1
 */