import com.tencent.widget.AbsListView;
import java.util.List;

class bmol
  implements bhtv
{
  int jdField_a_of_type_Int = 0;
  
  bmol(bmoj parambmoj) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (this.jdField_a_of_type_Int == bmoj.a(this.jdField_a_of_type_Bmoj, bmoj.a(this.jdField_a_of_type_Bmoj)).a().size()) && (!bmoj.a(this.jdField_a_of_type_Bmoj, bmoj.a(this.jdField_a_of_type_Bmoj)).a()))
    {
      paramAbsListView = bmoj.a(this.jdField_a_of_type_Bmoj);
      bmoj.a(this.jdField_a_of_type_Bmoj, bmoj.a(this.jdField_a_of_type_Bmoj)).b(paramAbsListView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmol
 * JD-Core Version:    0.7.0.1
 */