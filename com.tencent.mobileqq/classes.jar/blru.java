import com.tencent.widget.AbsListView;
import java.util.ArrayList;

class blru
  implements bhpo
{
  int jdField_a_of_type_Int = 0;
  
  blru(blrt paramblrt) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2 - 1 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (blrt.a(this.jdField_a_of_type_Blrt).a() != null) && (this.jdField_a_of_type_Int == blrt.a(this.jdField_a_of_type_Blrt).a().size() - 1)) {
      blrt.a(this.jdField_a_of_type_Blrt).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blru
 * JD-Core Version:    0.7.0.1
 */