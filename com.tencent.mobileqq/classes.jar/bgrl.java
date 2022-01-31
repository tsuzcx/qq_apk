import android.view.View;
import java.util.List;

class bgrl
  implements bfph
{
  bgrl(bgrj parambgrj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((this.a.jdField_a_of_type_Boolean) || (this.a.jdField_a_of_type_Bgrm == null)) {
      return;
    }
    this.a.jdField_a_of_type_Boolean = true;
    if (paramInt < this.a.jdField_a_of_type_JavaUtilList.size())
    {
      paramInt = ((Integer)this.a.jdField_a_of_type_JavaUtilList.get(paramInt)).intValue();
      if (paramInt == 16) {
        this.a.jdField_a_of_type_Bgrm.h();
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Bfpc.dismiss();
      return;
      if (paramInt == 32)
      {
        this.a.jdField_a_of_type_Bgrm.a();
      }
      else if (paramInt == 1)
      {
        this.a.jdField_a_of_type_Bgrm.f();
        bgrj.a(this.a);
      }
      else if (paramInt == 2)
      {
        this.a.jdField_a_of_type_Bgrm.i();
      }
      else if (paramInt == 4)
      {
        this.a.jdField_a_of_type_Bgrm.j();
      }
      else if (paramInt == 8)
      {
        this.a.jdField_a_of_type_Bgrm.g();
      }
      else if (paramInt == 64)
      {
        this.a.jdField_a_of_type_Bgrm.b();
      }
      else if (paramInt == 128)
      {
        this.a.jdField_a_of_type_Bgrm.c();
      }
      else if (paramInt == 256)
      {
        this.a.jdField_a_of_type_Bgrm.d();
        continue;
        paramInt -= this.a.jdField_a_of_type_JavaUtilList.size();
        if ((paramInt >= 0) && (paramInt < this.a.b.size())) {
          this.a.jdField_a_of_type_Bgrm.a((String)this.a.b.get(paramInt));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgrl
 * JD-Core Version:    0.7.0.1
 */