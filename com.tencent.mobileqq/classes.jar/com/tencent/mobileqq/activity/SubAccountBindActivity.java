package com.tencent.mobileqq.activity;

import abtg;
import abth;
import abtj;
import abtl;
import abtm;
import ajjh;
import ajss;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import axat;
import azwp;
import babh;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormItemRelativeLayout;
import com.tencent.qphone.base.remote.SimpleAccount;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class SubAccountBindActivity
  extends SubAccountBaseActivity
{
  ajjh jdField_a_of_type_Ajjh = new abtm(this);
  ajss jdField_a_of_type_Ajss = new abth(this);
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new abtj(this);
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private List<SimpleAccount> jdField_a_of_type_JavaUtilList;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new abtg(this);
  View.OnClickListener b;
  
  public SubAccountBindActivity()
  {
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new abtl(this);
  }
  
  private SimpleAccount a(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      SimpleAccount localSimpleAccount = (SimpleAccount)localIterator.next();
      if (paramString.equals(localSimpleAccount.getUin())) {
        return localSimpleAccount;
      }
    }
    return null;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    for (;;)
    {
      Object localObject = getAppRuntime().getApplication().getAllAccounts();
      if (localObject == null) {
        break;
      }
      this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject);
      localObject = a(this.app.getAccount());
      this.jdField_a_of_type_JavaUtilList.remove(localObject);
      localObject = ((axat)this.app.getManager(61)).a();
      if (localObject == null) {
        break;
      }
      int j = ((List)localObject).size();
      int i = 0;
      while (i < j)
      {
        SimpleAccount localSimpleAccount = a((String)((List)localObject).get(i));
        this.jdField_a_of_type_JavaUtilList.remove(localSimpleAccount);
        i += 1;
      }
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.add(null);
    }
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() <= 0)) {}
    label265:
    for (;;)
    {
      return;
      int j = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label265;
        }
        Object localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
        Object localObject2 = ((View)localObject1).getTag();
        if (localObject2 == null) {
          break;
        }
        int k = ((Integer)localObject2).intValue();
        SimpleAccount localSimpleAccount = (SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(k);
        if (localSimpleAccount == null) {
          break;
        }
        ImageView localImageView = (ImageView)((View)localObject1).findViewById(2131302061);
        TextView localTextView1 = (TextView)((View)localObject1).findViewById(2131304981);
        TextView localTextView2 = (TextView)((View)localObject1).findViewById(2131296287);
        localObject1 = (ImageView)((View)localObject1).findViewById(2131298618);
        localObject2 = babh.h(this.app, localSimpleAccount.getUin());
        localObject1 = localObject2;
        if (localSimpleAccount.isLogined()) {
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject1 = localObject2;
            if (!((String)localObject2).equals(localSimpleAccount.getUin())) {}
          }
          else
          {
            localObject1 = babh.i(this.app, localSimpleAccount.getUin());
          }
        }
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = localSimpleAccount.getUin();
        }
        localTextView1.setText((CharSequence)localObject2);
        localTextView2.setText(localSimpleAccount.getUin());
        localObject1 = azwp.a(this.app, 1, localSimpleAccount.getUin());
        if (localObject1 != null) {
          localImageView.setBackgroundDrawable((Drawable)localObject1);
        }
        i += 1;
      }
    }
  }
  
  protected boolean a(boolean paramBoolean)
  {
    a();
    Object localObject;
    if ((paramBoolean) && (this.jdField_a_of_type_JavaUtilList.size() == 1) && (this.jdField_a_of_type_JavaUtilList.get(0) == null))
    {
      localObject = new Intent();
      ((Intent)localObject).setClass(this, SubLoginActivity.class);
      ((Intent)localObject).putExtra("fromWhere", this.jdField_b_of_type_JavaLangString);
      startActivity((Intent)localObject);
      finish();
      return false;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      if (this.jdField_a_of_type_JavaUtilList.get(i) == null)
      {
        localObject = getLayoutInflater().inflate(2131492877, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
        ((TextView)((View)localObject).findViewById(2131305066)).setText(2131653959);
        ((View)localObject).setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        ((View)localObject).setTag(null);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
      }
      for (;;)
      {
        i += 1;
        break;
        localObject = getLayoutInflater().inflate(2131492878, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
        if ((localObject instanceof FormItemRelativeLayout))
        {
          ((FormItemRelativeLayout)localObject).setNeedFocusBg(true);
          ((FormItemRelativeLayout)localObject).setBGType(2);
        }
        ((View)localObject).setTag(Integer.valueOf(i));
        ((ImageView)((View)localObject).findViewById(2131302061)).setScaleType(ImageView.ScaleType.FIT_CENTER);
        ((View)localObject).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
      }
    }
    b();
    return true;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131496874);
    setTitle(2131653969);
    setContentBackgroundResource(2130838503);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131296290));
    if (!a(true)) {
      return false;
    }
    this.app.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    addObserver(this.jdField_a_of_type_Ajjh);
    addObserver(this.jdField_a_of_type_Ajss);
    return true;
  }
  
  public void doOnDestroy()
  {
    removeObserver(this.jdField_a_of_type_Ajss);
    removeObserver(this.jdField_a_of_type_Ajjh);
    this.app.removeHandler(getClass());
    super.doOnDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubAccountBindActivity
 * JD-Core Version:    0.7.0.1
 */