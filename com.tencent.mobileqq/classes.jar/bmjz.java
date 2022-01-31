import com.tencent.widget.AbsListView;
import java.util.List;

class bmjz
  implements bhpo
{
  int jdField_a_of_type_Int = 0;
  
  bmjz(bmjx parambmjx) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (this.jdField_a_of_type_Int == bmjx.a(this.jdField_a_of_type_Bmjx, bmjx.a(this.jdField_a_of_type_Bmjx)).a().size()) && (!bmjx.a(this.jdField_a_of_type_Bmjx, bmjx.a(this.jdField_a_of_type_Bmjx)).a()))
    {
      paramAbsListView = bmjx.a(this.jdField_a_of_type_Bmjx);
      bmjx.a(this.jdField_a_of_type_Bmjx, bmjx.a(this.jdField_a_of_type_Bmjx)).b(paramAbsListView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmjz
 * JD-Core Version:    0.7.0.1
 */