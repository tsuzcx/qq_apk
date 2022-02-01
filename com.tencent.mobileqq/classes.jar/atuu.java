import com.tencent.mobileqq.app.BaseActivity;
import java.util.ArrayList;
import java.util.List;

class atuu
  implements attg
{
  atuu(atut paramatut, BaseActivity paramBaseActivity) {}
  
  public atxa a()
  {
    Object localObject3 = null;
    int i = 0;
    Object localObject1;
    switch (this.jdField_a_of_type_Atut.a())
    {
    default: 
      localObject1 = null;
    }
    int j;
    int k;
    for (;;)
    {
      Object localObject2 = localObject3;
      if (localObject1 != null)
      {
        localObject2 = localObject3;
        if (((List)localObject1).size() > 0)
        {
          localObject2 = (atuz)((List)localObject1).get(i);
          j = ((atuz)localObject2).c();
          k = ((atuz)localObject2).b();
          if (j != 7) {
            break;
          }
          localObject2 = new atxi(atut.a(this.jdField_a_of_type_Atut), this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (List)localObject1, i);
        }
      }
      return localObject2;
      localObject1 = this.jdField_a_of_type_Atut.a();
      i = this.jdField_a_of_type_Atut.b();
      continue;
      localObject1 = this.jdField_a_of_type_Atut.a();
      i = this.jdField_a_of_type_Atut.b();
      continue;
      localObject1 = new ArrayList(1);
      ((List)localObject1).add(this.jdField_a_of_type_Atut.a());
    }
    if (j == 9) {
      return new auka(atut.a(this.jdField_a_of_type_Atut), this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (List)localObject1, i);
    }
    switch (k)
    {
    default: 
      return new atwe(atut.a(this.jdField_a_of_type_Atut), this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (List)localObject1, i);
    case 6000: 
      return new atwk(atut.a(this.jdField_a_of_type_Atut), this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (List)localObject1, i);
    }
    return new aujv(atut.a(this.jdField_a_of_type_Atut), this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (List)localObject1, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atuu
 * JD-Core Version:    0.7.0.1
 */