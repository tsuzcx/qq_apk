import com.tencent.widget.AbsListView;
import java.util.ArrayList;

class bjfs
  implements bfob
{
  int jdField_a_of_type_Int = 0;
  
  bjfs(bjfr parambjfr) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2 - 1 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (bjfr.a(this.jdField_a_of_type_Bjfr).a() != null) && (this.jdField_a_of_type_Int == bjfr.a(this.jdField_a_of_type_Bjfr).a().size() - 1)) {
      bjfr.a(this.jdField_a_of_type_Bjfr).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjfs
 * JD-Core Version:    0.7.0.1
 */