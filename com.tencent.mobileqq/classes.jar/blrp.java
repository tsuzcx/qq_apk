import com.tencent.widget.AbsListView;
import java.util.ArrayList;

class blrp
  implements bhpo
{
  int jdField_a_of_type_Int = 0;
  
  blrp(blro paramblro) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 1) {
      bhoc.b(this.jdField_a_of_type_Blro.h);
    }
    while ((paramInt != 0) || (this.jdField_a_of_type_Blro.a == null) || (this.jdField_a_of_type_Int < this.jdField_a_of_type_Blro.a.size())) {
      return;
    }
    blro.a(this.jdField_a_of_type_Blro);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blrp
 * JD-Core Version:    0.7.0.1
 */