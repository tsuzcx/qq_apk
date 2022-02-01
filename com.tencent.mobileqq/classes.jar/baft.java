import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.bussiness.accountinfo.view.ProfileQQLevelView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class baft
  extends bafq
{
  public baft(baei parambaei, azxr paramazxr)
  {
    super(parambaei, paramazxr);
  }
  
  private void a(Card paramCard, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaLangObject != null)
    {
      paramBoolean = a(paramCard);
      boolean bool = this.jdField_a_of_type_Bjaz.a(12);
      if (QLog.isColorLevel()) {
        QLog.d("ProfileAccountLevelHeaderComponent", 2, String.format("refreshAccountLevel showAccountInfo=%s baseInfoABTestEnable=%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) }));
      }
      if ((!paramBoolean) || (!bool)) {
        ((View)this.jdField_a_of_type_JavaLangObject).setVisibility(8);
      }
    }
    else
    {
      return;
    }
    ((View)this.jdField_a_of_type_JavaLangObject).setVisibility(0);
    paramCard = (ProfileQQLevelView)((View)this.jdField_a_of_type_JavaLangObject).findViewById(2131374383);
    if (paramCard != null)
    {
      paramCard.a((azxr)this.b, this.jdField_a_of_type_Boolean);
      paramCard.setClickable(false);
    }
    a();
    ((View)this.jdField_a_of_type_JavaLangObject).setTag(new azvr(69, null));
    ((View)this.jdField_a_of_type_JavaLangObject).setOnClickListener(this);
    paramCard = (ImageView)((View)this.jdField_a_of_type_JavaLangObject).findViewById(2131362954);
    a((View)this.jdField_a_of_type_JavaLangObject, null, null, paramCard);
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_JavaLangObject != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getLayoutInflater().inflate(2131561425, (ViewGroup)this.jdField_a_of_type_JavaLangObject);
    }
  }
  
  public int a()
  {
    return 1022;
  }
  
  public String a()
  {
    return "ProfileAccountLevelHeaderComponent";
  }
  
  public void a(@NonNull BaseActivity paramBaseActivity, @Nullable Bundle paramBundle)
  {
    super.a(paramBaseActivity, paramBundle);
    k();
  }
  
  public boolean a(azxr paramazxr)
  {
    a(((azxr)this.b).jdField_a_of_type_ComTencentMobileqqDataCard, ((azxr)this.b).d);
    return true;
  }
  
  public void onClick(View paramView)
  {
    int i = 0;
    int k = 1;
    int j = 1;
    Object localObject = paramView.getTag();
    if ((localObject instanceof azvr)) {
      switch (((azvr)localObject).a)
      {
      }
    }
    label99:
    label125:
    do
    {
      do
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        j();
      } while (!bafb.a((azxr)this.b));
      if (((azxr)this.b).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0)
      {
        i = 1;
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (i == 0) {
          break label125;
        }
      }
      for (i = j;; i = 3)
      {
        bafu.b((QQAppInterface)localObject, i);
        break;
        i = 0;
        break label99;
      }
      i();
    } while (!bafb.a((azxr)this.b));
    if (((azxr)this.b).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0) {
      i = 1;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (i != 0) {}
    for (i = k;; i = 3)
    {
      bafu.a((QQAppInterface)localObject, i);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baft
 * JD-Core Version:    0.7.0.1
 */