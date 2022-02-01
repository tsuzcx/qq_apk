import com.tencent.widget.AbsListView;
import java.util.List;

class bpfr
  implements bkhe
{
  int jdField_a_of_type_Int = 0;
  
  bpfr(bpfp parambpfp) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (this.jdField_a_of_type_Int == bpfp.a(this.jdField_a_of_type_Bpfp, bpfp.a(this.jdField_a_of_type_Bpfp)).a().size()) && (!bpfp.a(this.jdField_a_of_type_Bpfp, bpfp.a(this.jdField_a_of_type_Bpfp)).a()))
    {
      paramAbsListView = bpfp.a(this.jdField_a_of_type_Bpfp);
      bpfp.a(this.jdField_a_of_type_Bpfp, bpfp.a(this.jdField_a_of_type_Bpfp)).b(paramAbsListView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpfr
 * JD-Core Version:    0.7.0.1
 */