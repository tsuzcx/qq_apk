import android.view.View;
import java.util.List;

class bgqu
  implements bfoq
{
  bgqu(bgqs parambgqs) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((this.a.jdField_a_of_type_Boolean) || (this.a.jdField_a_of_type_Bgqv == null)) {
      return;
    }
    this.a.jdField_a_of_type_Boolean = true;
    if (paramInt < this.a.jdField_a_of_type_JavaUtilList.size())
    {
      paramInt = ((Integer)this.a.jdField_a_of_type_JavaUtilList.get(paramInt)).intValue();
      if (paramInt == 16) {
        this.a.jdField_a_of_type_Bgqv.h();
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Bfol.dismiss();
      return;
      if (paramInt == 32)
      {
        this.a.jdField_a_of_type_Bgqv.a();
      }
      else if (paramInt == 1)
      {
        this.a.jdField_a_of_type_Bgqv.f();
        bgqs.a(this.a);
      }
      else if (paramInt == 2)
      {
        this.a.jdField_a_of_type_Bgqv.i();
      }
      else if (paramInt == 4)
      {
        this.a.jdField_a_of_type_Bgqv.j();
      }
      else if (paramInt == 8)
      {
        this.a.jdField_a_of_type_Bgqv.g();
      }
      else if (paramInt == 64)
      {
        this.a.jdField_a_of_type_Bgqv.b();
      }
      else if (paramInt == 128)
      {
        this.a.jdField_a_of_type_Bgqv.c();
      }
      else if (paramInt == 256)
      {
        this.a.jdField_a_of_type_Bgqv.d();
        continue;
        paramInt -= this.a.jdField_a_of_type_JavaUtilList.size();
        if ((paramInt >= 0) && (paramInt < this.a.b.size())) {
          this.a.jdField_a_of_type_Bgqv.a((String)this.a.b.get(paramInt));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgqu
 * JD-Core Version:    0.7.0.1
 */