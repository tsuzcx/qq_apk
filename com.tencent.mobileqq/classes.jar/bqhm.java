import com.tencent.widget.AbsListView;
import java.util.List;

class bqhm
  implements blih
{
  int jdField_a_of_type_Int = 0;
  
  bqhm(bqhk parambqhk) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (this.jdField_a_of_type_Int == bqhk.a(this.jdField_a_of_type_Bqhk, bqhk.a(this.jdField_a_of_type_Bqhk)).a().size()) && (!bqhk.a(this.jdField_a_of_type_Bqhk, bqhk.a(this.jdField_a_of_type_Bqhk)).a()))
    {
      paramAbsListView = bqhk.a(this.jdField_a_of_type_Bqhk);
      bqhk.a(this.jdField_a_of_type_Bqhk, bqhk.a(this.jdField_a_of_type_Bqhk)).b(paramAbsListView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqhm
 * JD-Core Version:    0.7.0.1
 */