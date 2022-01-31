import com.tencent.mobileqq.app.BaseActivity;
import java.util.ArrayList;
import java.util.List;

class ardl
  implements arbj
{
  ardl(ardk paramardk, BaseActivity paramBaseActivity) {}
  
  public arfz a()
  {
    Object localObject3 = null;
    int i = 0;
    Object localObject1;
    switch (this.jdField_a_of_type_Ardk.a())
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
          localObject2 = (ardq)((List)localObject1).get(i);
          j = ((ardq)localObject2).c();
          k = ((ardq)localObject2).b();
          if (j != 7) {
            break;
          }
          localObject2 = new argh(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (List)localObject1, i);
        }
      }
      return localObject2;
      localObject1 = this.jdField_a_of_type_Ardk.a();
      i = this.jdField_a_of_type_Ardk.b();
      continue;
      localObject1 = this.jdField_a_of_type_Ardk.a();
      i = this.jdField_a_of_type_Ardk.b();
      continue;
      localObject1 = new ArrayList(1);
      ((List)localObject1).add(this.jdField_a_of_type_Ardk.a());
    }
    if (j == 9) {
      return new arfw(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (List)localObject1, i);
    }
    switch (k)
    {
    default: 
      return new arev(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (List)localObject1, i);
    case 6000: 
      return new arfb(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (List)localObject1, i);
    }
    return new arfr(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (List)localObject1, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ardl
 * JD-Core Version:    0.7.0.1
 */