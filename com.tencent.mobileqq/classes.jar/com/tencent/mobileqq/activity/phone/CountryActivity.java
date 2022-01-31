package com.tencent.mobileqq.activity.phone;

import agjm;
import agjn;
import agjo;
import agjp;
import agjq;
import agjr;
import agjt;
import ajya;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.TextView;
import baww;
import bbdv;
import bcnf;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public class CountryActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, bcnf
{
  private agjp jdField_a_of_type_Agjp;
  public agjt a;
  public View a;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  public IndexView a;
  private PinnedDividerListView jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
  public ArrayList<agjq> a;
  public LinkedHashMap<String, Integer> a;
  public View b;
  private View c;
  
  public CountryActivity()
  {
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  }
  
  public static void a(View paramView, agjq paramagjq)
  {
    paramView = (agjr)paramView.getTag();
    paramView.jdField_a_of_type_AndroidWidgetTextView.setText(paramagjq.b);
    paramView.b.setText("+" + paramagjq.c);
    paramView.jdField_a_of_type_Agjq = paramagjq;
  }
  
  private static View b(ViewGroup paramViewGroup, LayoutInflater paramLayoutInflater, boolean paramBoolean)
  {
    paramViewGroup = paramLayoutInflater.inflate(2131559372, paramViewGroup, false);
    if (paramBoolean) {
      paramViewGroup.setPadding(paramViewGroup.getPaddingLeft(), paramViewGroup.getPaddingTop(), (int)bbdv.a(BaseApplicationImpl.sApplication, 40.0F), paramViewGroup.getPaddingBottom());
    }
    paramLayoutInflater = new agjr(null);
    paramLayoutInflater.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131364796));
    paramLayoutInflater.b = ((TextView)paramViewGroup.findViewById(2131364795));
    paramViewGroup.setTag(paramLayoutInflater);
    return paramViewGroup;
  }
  
  public void a(View paramView)
  {
    paramView = (agjr)paramView.getTag();
    if (paramView.jdField_a_of_type_Agjq != null)
    {
      if ((this.jdField_a_of_type_Agjt != null) && (this.jdField_a_of_type_Agjt.isShowing()) && (!super.isFinishing())) {
        this.jdField_a_of_type_Agjt.dismiss();
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("k_name", paramView.jdField_a_of_type_Agjq.b);
      localIntent.putExtra("k_code", paramView.jdField_a_of_type_Agjq.c);
      setResult(-1, localIntent);
      finish();
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
    setContentView(2131559370);
    String[] arrayOfString1 = getResources().getStringArray(2130968651);
    Object localObject1 = getResources().getStringArray(2130968650);
    String[] arrayOfString2 = getResources().getStringArray(2130968621);
    Object localObject2 = getResources().getStringArray(2130968620);
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
    agjq localagjq;
    if (i < j)
    {
      localagjq = new agjq(arrayOfString2[i]);
      localObject1 = localagjq.a;
      if (paramBundle.equals(localObject1)) {
        break label600;
      }
      ((ArrayList)localObject2).add(new agjq((String)localObject1));
      paramBundle = (Bundle)localObject1;
    }
    label595:
    label600:
    for (;;)
    {
      ((ArrayList)localObject2).add(localagjq);
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
          break label595;
        }
      }
      for (j = j + i + 1;; j = i)
      {
        this.jdField_a_of_type_JavaUtilLinkedHashMap.put(localObject1, Integer.valueOf(i));
        i = j;
        break;
        this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject2);
        setTitle(ajya.a(2131702615));
        this.leftView.setText(2131690572);
        this.jdField_a_of_type_AndroidViewView = findViewById(2131375329);
        this.b = ((View)this.jdField_a_of_type_AndroidViewView.getParent());
        this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)findViewById(2131364797));
        this.c = ((LayoutInflater)getSystemService("layout_inflater")).inflate(2131562360, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false);
        this.c.setPadding(0, 0, 40, 0);
        this.c.findViewById(2131363479).setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.c.findViewById(2131365763));
        this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
        this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
        this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(this);
        baww.b(this.c);
        this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.addHeaderView(this.c);
        this.jdField_a_of_type_Agjp = new agjp(this, null);
        this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_Agjp);
        this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131368073));
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
      this.jdField_a_of_type_Agjt = new agjt(this, this);
      this.jdField_a_of_type_Agjt.setCanceledOnTouchOutside(true);
      int i = this.jdField_a_of_type_AndroidViewView.getHeight();
      paramView = new TranslateAnimation(0.0F, 0.0F, 0.0F, -i);
      paramView.setDuration(300L);
      paramView.setFillAfter(true);
      paramView.setAnimationListener(new agjm(this));
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, -i, 0.0F);
      localTranslateAnimation.setDuration(300L);
      localTranslateAnimation.setAnimationListener(new agjn(this, i));
      this.jdField_a_of_type_Agjt.setOnDismissListener(new agjo(this, i, localTranslateAnimation));
      this.b.startAnimation(paramView);
      return;
    }
    a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.CountryActivity
 * JD-Core Version:    0.7.0.1
 */