import com.tencent.widget.AbsListView;
import java.util.ArrayList;

class blwg
  implements bhtv
{
  int jdField_a_of_type_Int = 0;
  
  blwg(blwf paramblwf) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2 - 1 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (blwf.a(this.jdField_a_of_type_Blwf).a() != null) && (this.jdField_a_of_type_Int == blwf.a(this.jdField_a_of_type_Blwf).a().size() - 1)) {
      blwf.a(this.jdField_a_of_type_Blwf).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blwg
 * JD-Core Version:    0.7.0.1
 */