import android.view.View;
import java.util.List;

class biwr
  implements bhuk
{
  biwr(biwp parambiwp) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((this.a.jdField_a_of_type_Boolean) || (this.a.jdField_a_of_type_Biws == null)) {
      return;
    }
    this.a.jdField_a_of_type_Boolean = true;
    if (paramInt < this.a.jdField_a_of_type_JavaUtilList.size())
    {
      paramInt = ((Integer)this.a.jdField_a_of_type_JavaUtilList.get(paramInt)).intValue();
      if (paramInt == 16) {
        this.a.jdField_a_of_type_Biws.h();
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Bhuf.dismiss();
      return;
      if (paramInt == 32)
      {
        this.a.jdField_a_of_type_Biws.a();
      }
      else if (paramInt == 1)
      {
        this.a.jdField_a_of_type_Biws.f();
        biwp.a(this.a);
      }
      else if (paramInt == 2)
      {
        this.a.jdField_a_of_type_Biws.i();
      }
      else if (paramInt == 4)
      {
        this.a.jdField_a_of_type_Biws.j();
      }
      else if (paramInt == 8)
      {
        this.a.jdField_a_of_type_Biws.g();
      }
      else if (paramInt == 64)
      {
        this.a.jdField_a_of_type_Biws.b();
      }
      else if (paramInt == 128)
      {
        this.a.jdField_a_of_type_Biws.c();
      }
      else if (paramInt == 256)
      {
        this.a.jdField_a_of_type_Biws.d();
        continue;
        paramInt -= this.a.jdField_a_of_type_JavaUtilList.size();
        if ((paramInt >= 0) && (paramInt < this.a.b.size())) {
          this.a.jdField_a_of_type_Biws.a((String)this.a.b.get(paramInt));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     biwr
 * JD-Core Version:    0.7.0.1
 */