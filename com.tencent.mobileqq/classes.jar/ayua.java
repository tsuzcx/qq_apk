import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class ayua
  extends ayub
{
  public ayua(aysx paramaysx, aymg paramaymg)
  {
    super(paramaysx, paramaymg);
  }
  
  private SpannableStringBuilder a(List<SpannableString> paramList)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      localSpannableStringBuilder.append((CharSequence)paramList.get(i));
      if (i != j - 1) {
        localSpannableStringBuilder.append(" ");
      }
      i += 1;
    }
    return localSpannableStringBuilder;
  }
  
  private List<SpannableString> a(QQAppInterface paramQQAppInterface, Context paramContext, aymg paramaymg)
  {
    ArrayList localArrayList = new ArrayList();
    int i = ayue.a(paramaymg);
    String str;
    if (i == 0)
    {
      localArrayList.add(new SpannableString(paramContext.getString(2131693568)));
      str = ayue.b(paramaymg);
      if (!TextUtils.isEmpty(str))
      {
        if (!paramaymg.jdField_a_of_type_ComTencentMobileqqDataCard.schoolVerifiedFlag) {
          break label335;
        }
        localArrayList.add(bfrj.a(str, true, 2130845065, 2131298182, 2131298181, paramContext, paramQQAppInterface));
      }
    }
    for (;;)
    {
      paramQQAppInterface = ayue.i(paramaymg);
      if (!TextUtils.isEmpty(paramQQAppInterface)) {
        localArrayList.add(new SpannableString(paramQQAppInterface));
      }
      paramQQAppInterface = ayue.c(paramaymg);
      paramContext = ayue.d(paramaymg);
      str = ayue.e(paramaymg);
      StringBuilder localStringBuilder = new StringBuilder();
      if ((!TextUtils.isEmpty(paramQQAppInterface)) && (!amtj.a(2131707564).equals(paramQQAppInterface))) {
        localStringBuilder.append(paramQQAppInterface);
      }
      if (!TextUtils.isEmpty(paramContext))
      {
        if (localStringBuilder.length() > 0) {
          localStringBuilder.append("-");
        }
        localStringBuilder.append(paramContext);
      }
      if (!TextUtils.isEmpty(str))
      {
        if (localStringBuilder.length() > 0) {
          localStringBuilder.append("-");
        }
        localStringBuilder.append(str);
      }
      if (localStringBuilder.length() > 0) {
        localArrayList.add(new SpannableString(localStringBuilder.toString()));
      }
      paramQQAppInterface = ayue.a(paramaymg);
      if (!TextUtils.isEmpty(paramQQAppInterface)) {
        localArrayList.add(new SpannableString(paramQQAppInterface));
      }
      if (localArrayList.size() < 4) {
        break label355;
      }
      return localArrayList.subList(0, 3);
      if (i != 1) {
        break;
      }
      localArrayList.add(new SpannableString(paramContext.getString(2131692108)));
      break;
      label335:
      localArrayList.add(new SpannableString(str));
    }
    label355:
    return localArrayList;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_JavaLangObject != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getLayoutInflater().inflate(2131561308, (ViewGroup)this.jdField_a_of_type_JavaLangObject);
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void a(Card paramCard, boolean paramBoolean)
  {
    boolean bool1;
    int i;
    if (this.jdField_a_of_type_JavaLangObject != null)
    {
      paramCard = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (aymg)this.b);
      bool1 = paramCard.isEmpty();
      if (((aymg)this.b).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a != 0) {
        break label165;
      }
      i = 1;
      if ((bool1) && (i != 0)) {
        paramCard.add(new SpannableString(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698460)));
      }
      if (paramCard.isEmpty()) {
        break label170;
      }
      paramBoolean = true;
      label96:
      boolean bool2 = this.jdField_a_of_type_Bhha.a(12);
      if (QLog.isColorLevel()) {
        QLog.d("ProfileAccountInfoHeaderComponent", 2, String.format("refreshAccountInfo showAccountInfo=%s baseInfoABTestEnable=%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool2) }));
      }
      if ((paramBoolean) && (!bool2)) {
        break label175;
      }
      ((View)this.jdField_a_of_type_JavaLangObject).setVisibility(8);
    }
    label165:
    label170:
    label175:
    TextView localTextView;
    do
    {
      do
      {
        return;
        i = 0;
        break;
        paramBoolean = false;
        break label96;
        ((View)this.jdField_a_of_type_JavaLangObject).setVisibility(0);
        localTextView = (TextView)((View)this.jdField_a_of_type_JavaLangObject).findViewById(2131378367);
      } while (localTextView == null);
      localTextView.setText(a(paramCard));
      localTextView.setOnTouchListener(mum.a);
      localTextView.setOnClickListener(this);
    } while (bool1);
    bfrj.a(localTextView, null, null);
  }
  
  public int a()
  {
    return 1024;
  }
  
  public String a()
  {
    return "ProfileAccountInfoHeaderComponent";
  }
  
  public void a(@NonNull BaseActivity paramBaseActivity, @Nullable Bundle paramBundle)
  {
    super.a(paramBaseActivity, paramBundle);
    a();
  }
  
  public boolean a(aymg paramaymg)
  {
    a(((aymg)this.b).jdField_a_of_type_ComTencentMobileqqDataCard, ((aymg)this.b).d);
    bgff.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (aymg)this.b, false);
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bfrj.a((aymg)this.b, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    } while (!aytq.a((aymg)this.b));
    label81:
    QQAppInterface localQQAppInterface;
    if (((aymg)this.b).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0)
    {
      i = 1;
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (i == 0) {
        break label105;
      }
    }
    label105:
    for (int i = 2;; i = 4)
    {
      ayud.a(localQQAppInterface, i);
      break;
      i = 0;
      break label81;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayua
 * JD-Core Version:    0.7.0.1
 */