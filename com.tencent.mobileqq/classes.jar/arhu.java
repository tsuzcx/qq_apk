import com.tencent.mobileqq.app.BaseActivity;
import java.util.ArrayList;
import java.util.List;

class arhu
  implements arfs
{
  arhu(arht paramarht, BaseActivity paramBaseActivity) {}
  
  public arki a()
  {
    Object localObject3 = null;
    int i = 0;
    Object localObject1;
    switch (this.jdField_a_of_type_Arht.a())
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
          localObject2 = (arhz)((List)localObject1).get(i);
          j = ((arhz)localObject2).c();
          k = ((arhz)localObject2).b();
          if (j != 7) {
            break;
          }
          localObject2 = new arkq(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (List)localObject1, i);
        }
      }
      return localObject2;
      localObject1 = this.jdField_a_of_type_Arht.a();
      i = this.jdField_a_of_type_Arht.b();
      continue;
      localObject1 = this.jdField_a_of_type_Arht.a();
      i = this.jdField_a_of_type_Arht.b();
      continue;
      localObject1 = new ArrayList(1);
      ((List)localObject1).add(this.jdField_a_of_type_Arht.a());
    }
    if (j == 9) {
      return new arkf(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (List)localObject1, i);
    }
    switch (k)
    {
    default: 
      return new arje(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (List)localObject1, i);
    case 6000: 
      return new arjk(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (List)localObject1, i);
    }
    return new arka(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (List)localObject1, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arhu
 * JD-Core Version:    0.7.0.1
 */