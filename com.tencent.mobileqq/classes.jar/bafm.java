import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class bafm
  extends badd
  implements View.OnClickListener
{
  public bafm(baei parambaei, azxr paramazxr)
  {
    super(parambaei, paramazxr);
  }
  
  private SpannableStringBuilder a(List<String> paramList, TextView paramTextView)
  {
    Object localObject = new StringBuilder();
    if ((paramList != null) && (!paramList.isEmpty()) && (paramTextView != null))
    {
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        ((StringBuilder)localObject).append((String)paramList.get(i));
        if (i != j - 1) {
          ((StringBuilder)localObject).append(" | ");
        }
        i += 1;
      }
    }
    paramTextView = a(((StringBuilder)localObject).toString(), paramTextView);
    if (QLog.isColorLevel()) {
      QLog.d("ProfileAccountInfoV2Component", 2, String.format("combineAccountInfo accountInfo=%s", new Object[] { paramTextView }));
    }
    paramList = new SpannableStringBuilder(paramTextView);
    localObject = Pattern.compile("\\|").matcher(paramTextView);
    while (((Matcher)localObject).find()) {
      paramList.setSpan(a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity), ((Matcher)localObject).start(), ((Matcher)localObject).end(), 33);
    }
    paramTextView = Pattern.compile(" ").matcher(paramTextView);
    while (paramTextView.find()) {
      paramList.setSpan(b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity), paramTextView.start(), paramTextView.end(), 33);
    }
    return paramList;
  }
  
  private ImageSpan a(Context paramContext)
  {
    return new bafn(paramContext, 2130845738, 2);
  }
  
  private String a(String paramString, TextView paramTextView)
  {
    Object localObject;
    TextPaint localTextPaint;
    int i;
    int j;
    int n;
    int i1;
    if ((paramString != null) && (paramString.length() > 0) && (paramTextView != null))
    {
      localObject = paramTextView.getResources();
      localTextPaint = paramTextView.getPaint();
      i = paramTextView.getPaddingLeft();
      j = paramTextView.getPaddingRight();
      n = paramTextView.getWidth() - i - j;
      if (n > 0)
      {
        i1 = paramString.length();
        j = 0;
      }
    }
    int m;
    label222:
    for (int k = 0;; k = m)
    {
      m = paramString.offsetByCodePoints(k, 1);
      paramTextView = paramString.substring(k, m);
      if ("|".equals(paramTextView)) {
        i = agej.a(1.0F, (Resources)localObject);
      }
      while (j + i <= n)
      {
        j += i;
        if (m < i1 - 1) {
          break label222;
        }
        return paramString;
        if (" ".equals(paramTextView)) {
          i = agej.a(8.0F, (Resources)localObject);
        } else {
          i = (int)localTextPaint.measureText(paramTextView);
        }
      }
      paramTextView = paramString.substring(0, k).trim();
      paramString = paramString.substring(k).trim();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramTextView);
      if (!TextUtils.isEmpty(paramString))
      {
        ((StringBuilder)localObject).append('\n');
        ((StringBuilder)localObject).append(paramString);
      }
      return ((StringBuilder)localObject).toString();
    }
  }
  
  private List<String> a(Card paramCard)
  {
    Resources localResources = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
    ArrayList localArrayList = new ArrayList();
    if (paramCard != null)
    {
      a(localArrayList, (azxr)this.b, localResources);
      b(localArrayList, (azxr)this.b, localResources);
      c(localArrayList, (azxr)this.b, localResources);
      d(localArrayList, (azxr)this.b, localResources);
      e(localArrayList, (azxr)this.b, localResources);
      f(localArrayList, (azxr)this.b, localResources);
      g(localArrayList, (azxr)this.b, localResources);
      h(localArrayList, (azxr)this.b, localResources);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ProfileAccountInfoV2Component", 2, String.format("makeAccountInfo list=%s", new Object[] { Arrays.toString(localArrayList.toArray()) }));
    }
    return localArrayList;
  }
  
  private void a(List<String> paramList, azxr paramazxr, Resources paramResources)
  {
    Object localObject = null;
    int i = bafp.a(paramazxr);
    String str;
    if (i == 0) {
      str = paramResources.getString(2131693473);
    }
    for (;;)
    {
      i = bafp.b(paramazxr);
      paramazxr = localObject;
      if (i > 0) {
        paramazxr = i + paramResources.getString(2131718495);
      }
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramazxr))) {
        paramList.add(str + " " + paramazxr);
      }
      do
      {
        return;
        if (i != 1) {
          break label159;
        }
        str = paramResources.getString(2131692060);
        break;
        if (!TextUtils.isEmpty(str))
        {
          paramList.add(str);
          return;
        }
      } while (TextUtils.isEmpty(paramazxr));
      paramList.add(paramazxr);
      return;
      label159:
      str = null;
    }
  }
  
  private boolean a(Card paramCard, boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    Object localObject = a(paramCard);
    int i;
    int j;
    if (((azxr)this.b).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0)
    {
      i = 1;
      paramBoolean = ProfileActivity.AllInOne.a(((azxr)this.b).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      if (((List)localObject).isEmpty()) {
        break label171;
      }
      j = 1;
      label58:
      if ((!bafb.a((azxr)this.b)) || (paramCard == null) || ((i == 0) && ((!paramBoolean) || (j == 0)))) {
        break label352;
      }
    }
    label171:
    label314:
    label352:
    for (paramBoolean = true;; paramBoolean = false)
    {
      boolean bool3 = this.jdField_a_of_type_Bjaz.a(12);
      if (QLog.isColorLevel()) {
        QLog.d("ProfileAccountInfoV2Component", 2, String.format("makeOrRefreshAccountInfo showAccountInfo=%s baseInfoABTestEnable=%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool3) }));
      }
      if ((!paramBoolean) || (!bool3))
      {
        paramBoolean = bool1;
        if (this.jdField_a_of_type_JavaLangObject != null)
        {
          this.jdField_a_of_type_JavaLangObject = null;
          paramBoolean = true;
        }
        return paramBoolean;
        i = 0;
        break;
        j = 0;
        break label58;
      }
      paramBoolean = bool2;
      if (this.jdField_a_of_type_JavaLangObject == null)
      {
        this.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getLayoutInflater().inflate(2131561445, null);
        ((View)this.jdField_a_of_type_JavaLangObject).setOnClickListener(this);
        paramBoolean = true;
      }
      paramCard = (TextView)((View)this.jdField_a_of_type_JavaLangObject).findViewById(2131378603);
      ImageView localImageView = (ImageView)((View)this.jdField_a_of_type_JavaLangObject).findViewById(2131362954);
      if (paramCard != null)
      {
        if ((i == 0) || (j != 0)) {
          break label314;
        }
        paramCard.setText(2131698280);
        localObject = new azvr(81, null);
        ((View)this.jdField_a_of_type_JavaLangObject).setTag(localObject);
      }
      for (;;)
      {
        a((View)this.jdField_a_of_type_JavaLangObject, paramCard, null, localImageView);
        return paramBoolean;
        paramCard.setText(a((List)localObject, paramCard));
        localObject = new azvr(103, null);
        ((View)this.jdField_a_of_type_JavaLangObject).setTag(localObject);
      }
    }
  }
  
  private ImageSpan b(Context paramContext)
  {
    paramContext = paramContext.getResources();
    ColorDrawable localColorDrawable = new ColorDrawable();
    localColorDrawable.setBounds(0, 0, agej.a(8.0F, paramContext), 0);
    return new ImageSpan(localColorDrawable);
  }
  
  private void b(List<String> paramList, azxr paramazxr, Resources paramResources)
  {
    Object localObject = null;
    String str = bafp.a(paramazxr);
    long l = bafp.a(paramazxr);
    paramazxr = localObject;
    if (l > 0L)
    {
      int i = (int)(0xFF00 & l) >> 8;
      int j = (int)(l & 0xFF);
      paramazxr = localObject;
      if (i > 0)
      {
        paramazxr = localObject;
        if (j > 0)
        {
          paramazxr = new StringBuilder();
          paramazxr.append(i);
          paramazxr.append(paramResources.getString(2131693745));
          paramazxr.append(j);
          paramazxr.append(paramResources.getString(2131691294));
          paramazxr = paramazxr.toString();
        }
      }
    }
    if ((!TextUtils.isEmpty(paramazxr)) && (!TextUtils.isEmpty(str))) {
      paramList.add(paramazxr + " " + str);
    }
    do
    {
      return;
      if (!TextUtils.isEmpty(paramazxr))
      {
        paramList.add(paramazxr);
        return;
      }
    } while (TextUtils.isEmpty(str));
    paramList.add(str);
  }
  
  private void c(List<String> paramList, azxr paramazxr, Resources paramResources)
  {
    paramazxr = bafp.b(paramazxr);
    if (!TextUtils.isEmpty(paramazxr)) {
      paramList.add(paramazxr);
    }
  }
  
  private void d(List<String> paramList, azxr paramazxr, Resources paramResources)
  {
    String str = bafp.d(paramazxr);
    paramazxr = bafp.e(paramazxr);
    if ((!TextUtils.isEmpty(str)) || (!TextUtils.isEmpty(paramazxr)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramResources.getString(2131698279));
      if (!TextUtils.isEmpty(str)) {
        localStringBuilder.append(str);
      }
      if (!TextUtils.isEmpty(paramazxr)) {
        localStringBuilder.append(paramazxr);
      }
      paramList.add(localStringBuilder.toString());
    }
  }
  
  private void e(List<String> paramList, azxr paramazxr, Resources paramResources)
  {
    String str = bafp.g(paramazxr);
    paramazxr = bafp.h(paramazxr);
    if ((!TextUtils.isEmpty(str)) || (!TextUtils.isEmpty(paramazxr)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramResources.getString(2131698278));
      if (!TextUtils.isEmpty(str)) {
        localStringBuilder.append(str);
      }
      if (!TextUtils.isEmpty(paramazxr)) {
        localStringBuilder.append(paramazxr);
      }
      paramList.add(localStringBuilder.toString());
    }
  }
  
  private void f(List<String> paramList, azxr paramazxr, Resources paramResources)
  {
    paramazxr = bafp.i(paramazxr);
    if (!TextUtils.isEmpty(paramazxr)) {
      paramList.add(paramazxr);
    }
  }
  
  private void g(List<String> paramList, azxr paramazxr, Resources paramResources)
  {
    paramazxr = bafp.j(paramazxr);
    if (!TextUtils.isEmpty(paramazxr)) {
      paramList.add(paramazxr);
    }
  }
  
  private void h(List<String> paramList, azxr paramazxr, Resources paramResources)
  {
    paramazxr = bafp.k(paramazxr);
    if (!TextUtils.isEmpty(paramazxr)) {
      paramList.add(paramazxr);
    }
  }
  
  public int a()
  {
    return 1023;
  }
  
  public String a()
  {
    return "ProfileAccountInfoV2Component";
  }
  
  public boolean a(azxr paramazxr)
  {
    boolean bool = super.a(paramazxr);
    return a(((azxr)this.b).jdField_a_of_type_ComTencentMobileqqDataCard, ((azxr)this.b).d) | bool;
  }
  
  public String a_()
  {
    return "map_key_account_info_v2";
  }
  
  public void onClick(View paramView)
  {
    int j = 1;
    Object localObject = paramView.getTag();
    if ((localObject instanceof azvr)) {
      switch (((azvr)localObject).a)
      {
      }
    }
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        bafb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (azxr)this.b);
      }
      bhhz.a((azxr)this.b, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    } while (!bafb.a((azxr)this.b));
    if (((azxr)this.b).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0)
    {
      i = 1;
      label130:
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (i == 0) {
        break label156;
      }
    }
    label156:
    for (int i = j;; i = 3)
    {
      bafo.a((QQAppInterface)localObject, i);
      break;
      i = 0;
      break label130;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bafm
 * JD-Core Version:    0.7.0.1
 */