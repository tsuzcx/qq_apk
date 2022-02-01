import com.tencent.widget.AbsListView;
import java.util.ArrayList;

class bpra
  implements blih
{
  int jdField_a_of_type_Int = 0;
  
  bpra(bpqz parambpqz) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 1) {
      blgx.b(this.jdField_a_of_type_Bpqz.h);
    }
    while ((paramInt != 0) || (this.jdField_a_of_type_Bpqz.a == null) || (this.jdField_a_of_type_Int < this.jdField_a_of_type_Bpqz.a.size())) {
      return;
    }
    bpqz.a(this.jdField_a_of_type_Bpqz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpra
 * JD-Core Version:    0.7.0.1
 */