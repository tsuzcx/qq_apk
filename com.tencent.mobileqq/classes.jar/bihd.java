import com.tencent.widget.AbsListView;
import java.util.List;

class bihd
  implements begh
{
  int jdField_a_of_type_Int = 0;
  
  bihd(bihb parambihb) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (this.jdField_a_of_type_Int == bihb.a(this.jdField_a_of_type_Bihb, bihb.a(this.jdField_a_of_type_Bihb)).a().size()) && (!bihb.a(this.jdField_a_of_type_Bihb, bihb.a(this.jdField_a_of_type_Bihb)).a()))
    {
      paramAbsListView = bihb.a(this.jdField_a_of_type_Bihb);
      bihb.a(this.jdField_a_of_type_Bihb, bihb.a(this.jdField_a_of_type_Bihb)).b(paramAbsListView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bihd
 * JD-Core Version:    0.7.0.1
 */