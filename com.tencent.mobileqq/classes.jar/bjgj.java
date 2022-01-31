import com.tencent.widget.AbsListView;
import java.util.ArrayList;

class bjgj
  implements bfos
{
  int jdField_a_of_type_Int = 0;
  
  bjgj(bjgi parambjgi) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2 - 1 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (bjgi.a(this.jdField_a_of_type_Bjgi).a() != null) && (this.jdField_a_of_type_Int == bjgi.a(this.jdField_a_of_type_Bjgi).a().size() - 1)) {
      bjgi.a(this.jdField_a_of_type_Bjgi).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjgj
 * JD-Core Version:    0.7.0.1
 */