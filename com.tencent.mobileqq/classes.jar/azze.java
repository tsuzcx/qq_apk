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

public class azze
  extends azzb
{
  private azrb a;
  private boolean b;
  
  public azze(azxt paramazxt, azrb paramazrb)
  {
    super(paramazxt, paramazrb);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Azrb = paramazrb;
  }
  
  private void a(Card paramCard, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaLangObject != null)
    {
      paramBoolean = a(paramCard);
      boolean bool = this.jdField_a_of_type_Birs.a(12);
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
    if (this.jdField_b_of_type_Boolean) {
      azzf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Azrb);
    }
    this.jdField_b_of_type_Boolean = false;
    ((View)this.jdField_a_of_type_JavaLangObject).setVisibility(0);
    paramCard = (ProfileQQLevelView)((View)this.jdField_a_of_type_JavaLangObject).findViewById(2131374385);
    if (paramCard != null)
    {
      paramCard.a((azrb)this.jdField_b_of_type_JavaLangObject, this.jdField_a_of_type_Boolean);
      paramCard.setClickable(false);
    }
    a();
    i();
    ((View)this.jdField_a_of_type_JavaLangObject).setTag(new azpb(69, null));
    ((View)this.jdField_a_of_type_JavaLangObject).setOnClickListener(this);
    paramCard = (ImageView)((View)this.jdField_a_of_type_JavaLangObject).findViewById(2131362985);
    a((View)this.jdField_a_of_type_JavaLangObject, null, null, paramCard);
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_JavaLangObject != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getLayoutInflater().inflate(2131561370, (ViewGroup)this.jdField_a_of_type_JavaLangObject);
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
    l();
  }
  
  public boolean a(azrb paramazrb)
  {
    this.jdField_a_of_type_Azrb = paramazrb;
    a(((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard, ((azrb)this.jdField_b_of_type_JavaLangObject).d);
    return true;
  }
  
  public void onClick(View paramView)
  {
    int i = 0;
    int k = 1;
    int j = 1;
    Object localObject = paramView.getTag();
    if ((localObject instanceof azpb)) {
      switch (((azpb)localObject).a)
      {
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      k();
      if (azym.a((azrb)this.jdField_b_of_type_JavaLangObject))
      {
        if (((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0)
        {
          i = 1;
          label107:
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          if (i == 0) {
            break label133;
          }
        }
        label133:
        for (i = j;; i = 3)
        {
          azzf.b((QQAppInterface)localObject, i);
          break;
          i = 0;
          break label107;
        }
        j();
        if (azym.a((azrb)this.jdField_b_of_type_JavaLangObject))
        {
          if (((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0) {
            i = 1;
          }
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          if (i != 0) {}
          for (i = k;; i = 3)
          {
            azzf.a((QQAppInterface)localObject, i);
            break;
          }
          if ((this.jdField_a_of_type_Azrb != null) && (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqDataCard != null))
          {
            localObject = this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqDataCard.uin;
            a(paramView.getContext(), (String)localObject);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azze
 * JD-Core Version:    0.7.0.1
 */