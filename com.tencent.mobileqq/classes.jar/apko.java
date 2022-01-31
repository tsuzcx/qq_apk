import com.tencent.mobileqq.app.BaseActivity;
import java.util.ArrayList;
import java.util.List;

class apko
  implements apim
{
  apko(apkn paramapkn, BaseActivity paramBaseActivity) {}
  
  public apnb a()
  {
    Object localObject3 = null;
    int i = 0;
    Object localObject1;
    switch (this.jdField_a_of_type_Apkn.a())
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
          localObject2 = (apkt)((List)localObject1).get(i);
          j = ((apkt)localObject2).c();
          k = ((apkt)localObject2).b();
          if (j != 7) {
            break;
          }
          localObject2 = new apnh(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (List)localObject1, i);
        }
      }
      return localObject2;
      localObject1 = this.jdField_a_of_type_Apkn.a();
      i = this.jdField_a_of_type_Apkn.b();
      continue;
      localObject1 = this.jdField_a_of_type_Apkn.a();
      i = this.jdField_a_of_type_Apkn.b();
      continue;
      localObject1 = new ArrayList(1);
      ((List)localObject1).add(this.jdField_a_of_type_Apkn.a());
    }
    if (j == 9) {
      return new apmy(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (List)localObject1, i);
    }
    switch (k)
    {
    default: 
      return new aplw(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (List)localObject1, i);
    case 6000: 
      return new apmc(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (List)localObject1, i);
    }
    return new apmt(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (List)localObject1, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apko
 * JD-Core Version:    0.7.0.1
 */