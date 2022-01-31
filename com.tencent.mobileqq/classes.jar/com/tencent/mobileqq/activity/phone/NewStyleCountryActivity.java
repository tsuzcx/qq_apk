package com.tencent.mobileqq.activity.phone;

import afyf;
import afyg;
import afyh;
import afyi;
import afyj;
import afyk;
import afym;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import azve;
import azzz;
import bacc;
import bbjs;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.RegisterNewBaseActivity;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public class NewStyleCountryActivity
  extends RegisterNewBaseActivity
  implements View.OnClickListener, bbjs
{
  private afyi jdField_a_of_type_Afyi;
  public afym a;
  public View a;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  public IndexView a;
  private PinnedDividerListView jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
  public ArrayList<afyj> a;
  public LinkedHashMap<String, Integer> a;
  public View b;
  private View c;
  private String d;
  
  public NewStyleCountryActivity()
  {
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  }
  
  private View a(ViewGroup paramViewGroup, LayoutInflater paramLayoutInflater, boolean paramBoolean)
  {
    paramViewGroup = paramLayoutInflater.inflate(2131496751, paramViewGroup, false);
    if (paramBoolean) {
      paramViewGroup.setPadding(paramViewGroup.getPaddingLeft(), paramViewGroup.getPaddingTop(), (int)bacc.a(BaseApplicationImpl.sApplication, 40.0F), paramViewGroup.getPaddingBottom());
    }
    paramLayoutInflater = new afyk(null);
    paramLayoutInflater.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131299234));
    paramLayoutInflater.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131298631));
    paramViewGroup.setTag(paramLayoutInflater);
    return paramViewGroup;
  }
  
  public void a(View paramView)
  {
    paramView = (afyk)paramView.getTag();
    if (paramView.jdField_a_of_type_Afyj != null)
    {
      if ((this.jdField_a_of_type_Afym != null) && (this.jdField_a_of_type_Afym.isShowing()) && (!super.isFinishing())) {
        this.jdField_a_of_type_Afym.dismiss();
      }
      this.jdField_b_of_type_JavaLangString = paramView.jdField_a_of_type_Afyj.c;
      Intent localIntent = new Intent();
      localIntent.putExtra("k_name", paramView.jdField_a_of_type_Afyj.jdField_b_of_type_JavaLangString);
      localIntent.putExtra("k_code", paramView.jdField_a_of_type_Afyj.c);
      setResult(-1, localIntent);
      finish();
    }
  }
  
  public void a(View paramView, afyj paramafyj)
  {
    int j = 0;
    paramView = (afyk)paramView.getTag();
    paramView.jdField_a_of_type_AndroidWidgetTextView.setText(paramafyj.jdField_b_of_type_JavaLangString);
    if ((azzz.a(paramafyj.c, this.jdField_b_of_type_JavaLangString)) && (azzz.a(paramafyj.jdField_b_of_type_JavaLangString, this.d)))
    {
      i = 1;
      if (i == 0) {
        break label89;
      }
    }
    label89:
    for (int i = j;; i = 8)
    {
      if (paramView.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != i) {
        paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(i);
      }
      paramView.jdField_a_of_type_Afyj = paramafyj;
      return;
      i = 0;
      break;
    }
  }
  
  public void a(String paramString)
  {
    if ("$".equals(paramString))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(0);
      return;
    }
    PinnedDividerListView localPinnedDividerListView = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
    int i = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getHeaderViewsCount();
    localPinnedDividerListView.setSelection(((Integer)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramString)).intValue() + i);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131496749);
    getWindow().setBackgroundDrawableResource(2131100110);
    c(2131651367);
    b();
    a(false);
    this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("k_code");
    this.d = getIntent().getStringExtra("k_name");
    String[] arrayOfString1 = getResources().getStringArray(2130903115);
    Object localObject1 = getResources().getStringArray(2130903114);
    String[] arrayOfString2 = getResources().getStringArray(2130903085);
    Object localObject2 = getResources().getStringArray(2130903084);
    paramBundle = new String[arrayOfString1.length + arrayOfString2.length];
    System.arraycopy(arrayOfString2, 0, paramBundle, 0, arrayOfString2.length);
    System.arraycopy(arrayOfString1, 0, paramBundle, arrayOfString2.length, arrayOfString1.length);
    arrayOfString2 = new String[localObject1.length + localObject2.length];
    System.arraycopy(localObject2, 0, arrayOfString2, 0, localObject2.length);
    System.arraycopy(localObject1, 0, arrayOfString2, localObject2.length, localObject1.length);
    int j = paramBundle.length;
    int i = 0;
    while (i < j)
    {
      localObject1 = paramBundle[i];
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(localObject1, Integer.valueOf(0));
      i += 1;
    }
    localObject2 = new ArrayList(paramBundle.length);
    paramBundle = "#";
    j = arrayOfString2.length;
    i = 0;
    afyj localafyj;
    if (i < j)
    {
      localafyj = new afyj(arrayOfString2[i]);
      localObject1 = localafyj.a;
      if (paramBundle.equals(localObject1)) {
        break label628;
      }
      ((ArrayList)localObject2).add(new afyj((String)localObject1));
      paramBundle = (Bundle)localObject1;
    }
    label623:
    label628:
    for (;;)
    {
      ((ArrayList)localObject2).add(localafyj);
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(localObject1, Integer.valueOf(((Integer)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject1)).intValue() + 1));
      i += 1;
      break;
      paramBundle = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
      i = 0;
      if (paramBundle.hasNext())
      {
        localObject1 = (String)paramBundle.next();
        j = ((Integer)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject1)).intValue();
        if (j == 0) {
          break label623;
        }
      }
      for (j = j + i + 1;; j = i)
      {
        this.jdField_a_of_type_JavaUtilLinkedHashMap.put(localObject1, Integer.valueOf(i));
        i = j;
        break;
        this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject2);
        this.jdField_a_of_type_AndroidViewView = findViewById(2131311610);
        this.jdField_b_of_type_AndroidViewView = ((View)this.jdField_a_of_type_AndroidViewView.getParent());
        this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)findViewById(2131299235));
        this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setDivider(null);
        this.c = ((LayoutInflater)getSystemService("layout_inflater")).inflate(2131495458, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false);
        this.c.findViewById(2131297934).setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.c.findViewById(2131300167));
        this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
        this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
        this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(this);
        azve.b(this.c);
        this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.addHeaderView(this.c);
        this.jdField_a_of_type_Afyi = new afyi(this, null);
        this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_Afyi);
        this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131302453));
        this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(arrayOfString1, true);
        this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
        return true;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetEditText)
    {
      this.jdField_a_of_type_Afym = new afym(this, this);
      this.jdField_a_of_type_Afym.setCanceledOnTouchOutside(true);
      int i = this.jdField_a_of_type_AndroidViewView.getHeight();
      paramView = new TranslateAnimation(0.0F, 0.0F, 0.0F, -i);
      paramView.setDuration(300L);
      paramView.setFillAfter(true);
      paramView.setAnimationListener(new afyf(this));
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, -i, 0.0F);
      localTranslateAnimation.setDuration(300L);
      localTranslateAnimation.setAnimationListener(new afyg(this, i));
      this.jdField_a_of_type_Afym.setOnDismissListener(new afyh(this, i, localTranslateAnimation));
      this.jdField_b_of_type_AndroidViewView.startAnimation(paramView);
      return;
    }
    a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.NewStyleCountryActivity
 * JD-Core Version:    0.7.0.1
 */