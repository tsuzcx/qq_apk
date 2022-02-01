import com.tencent.widget.AbsListView;
import java.util.ArrayList;

class bprf
  implements blih
{
  int jdField_a_of_type_Int = 0;
  
  bprf(bpre parambpre) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2 - 1 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (bpre.a(this.jdField_a_of_type_Bpre).a() != null) && (this.jdField_a_of_type_Int == bpre.a(this.jdField_a_of_type_Bpre).a().size() - 1)) {
      bpre.a(this.jdField_a_of_type_Bpre).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bprf
 * JD-Core Version:    0.7.0.1
 */