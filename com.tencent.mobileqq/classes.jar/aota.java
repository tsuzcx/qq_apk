import com.tencent.mobileqq.app.BaseActivity;
import java.util.ArrayList;
import java.util.List;

class aota
  implements aoqz
{
  aota(aosz paramaosz, BaseActivity paramBaseActivity) {}
  
  public aovk a()
  {
    Object localObject3 = null;
    int i = 0;
    Object localObject1;
    switch (this.jdField_a_of_type_Aosz.a())
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
          localObject2 = (aotf)((List)localObject1).get(i);
          j = ((aotf)localObject2).c();
          k = ((aotf)localObject2).b();
          if (j != 7) {
            break;
          }
          localObject2 = new aovq(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (List)localObject1, i);
        }
      }
      return localObject2;
      localObject1 = this.jdField_a_of_type_Aosz.a();
      i = this.jdField_a_of_type_Aosz.b();
      continue;
      localObject1 = this.jdField_a_of_type_Aosz.a();
      i = this.jdField_a_of_type_Aosz.b();
      continue;
      localObject1 = new ArrayList(1);
      ((List)localObject1).add(this.jdField_a_of_type_Aosz.a());
    }
    if (j == 9) {
      return new aovh(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (List)localObject1, i);
    }
    switch (k)
    {
    default: 
      return new aoug(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (List)localObject1, i);
    case 6000: 
      return new aoum(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (List)localObject1, i);
    }
    return new aovc(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (List)localObject1, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aota
 * JD-Core Version:    0.7.0.1
 */