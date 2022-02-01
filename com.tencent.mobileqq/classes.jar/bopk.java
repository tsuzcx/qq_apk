import com.tencent.widget.AbsListView;
import java.util.ArrayList;

class bopk
  implements bkhe
{
  int jdField_a_of_type_Int = 0;
  
  bopk(bopj parambopj) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2 - 1 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (bopj.a(this.jdField_a_of_type_Bopj).a() != null) && (this.jdField_a_of_type_Int == bopj.a(this.jdField_a_of_type_Bopj).a().size() - 1)) {
      bopj.a(this.jdField_a_of_type_Bopj).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bopk
 * JD-Core Version:    0.7.0.1
 */