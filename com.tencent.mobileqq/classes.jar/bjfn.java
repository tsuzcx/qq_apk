import com.tencent.widget.AbsListView;
import java.util.ArrayList;

class bjfn
  implements bfob
{
  int jdField_a_of_type_Int = 0;
  
  bjfn(bjfm parambjfm) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 1) {
      bfmr.b(this.jdField_a_of_type_Bjfm.h);
    }
    while ((paramInt != 0) || (this.jdField_a_of_type_Bjfm.a == null) || (this.jdField_a_of_type_Int < this.jdField_a_of_type_Bjfm.a.size())) {
      return;
    }
    bjfm.a(this.jdField_a_of_type_Bjfm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjfn
 * JD-Core Version:    0.7.0.1
 */