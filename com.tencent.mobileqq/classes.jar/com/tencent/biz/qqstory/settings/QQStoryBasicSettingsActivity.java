package com.tencent.biz.qqstory.settings;

import actj;
import ajya;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import bbfj;
import bcqi;
import bcql;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import ssf;
import sss;
import sst;
import ssv;
import ujt;

public class QQStoryBasicSettingsActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public int a;
  View jdField_a_of_type_AndroidViewView;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public bcqi a;
  public sss a;
  public sst a;
  ssv jdField_a_of_type_Ssv = new ujt(this);
  View[] jdField_a_of_type_ArrayOfAndroidViewView = new View[3];
  public int b = this.jdField_a_of_type_Int;
  
  public QQStoryBasicSettingsActivity()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  int a(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    case 1001: 
    default: 
      return 0;
    case 3: 
      return 2;
    }
    return 1;
  }
  
  protected View a(int paramInt, String paramString)
  {
    View localView = View.inflate(this, 2131561161, null);
    ((TextView)localView.findViewById(2131377350)).setText(paramString);
    ((TextView)localView.findViewById(2131368086)).setText("");
    paramString = (ImageView)localView.findViewById(2131362791);
    paramString.setVisibility(4);
    paramString.setBackgroundResource(2130839025);
    localView.setTag(Integer.valueOf(paramInt));
    localView.setOnClickListener(this);
    return localView;
  }
  
  void a()
  {
    Object localObject = new LinearLayout(this);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    ((LinearLayout)localObject).setBackgroundResource(2130838514);
    ((LinearLayout)localObject).setLayoutParams(localLayoutParams);
    ((LinearLayout)localObject).setOrientation(1);
    ((LinearLayout)localObject).setPadding(0, actj.a(20.0F, getResources()), 0, 0);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localObject);
    localObject = new TextView(this);
    ((TextView)localObject).setText(ssf.a + ajya.a(2131710813));
    ((TextView)localObject).setPadding(getResources().getDimensionPixelSize(2131298255), 0, getResources().getDimensionPixelSize(2131298255), getResources().getDimensionPixelSize(2131298252));
    ((TextView)localObject).setTextSize(14.0F);
    ((TextView)localObject).setTextColor(getResources().getColor(2131165479));
    this.jdField_a_of_type_AndroidViewViewGroup.addView((View)localObject);
    localObject = a(0, "移动流量和WiFi");
    this.jdField_a_of_type_AndroidViewViewGroup.addView((View)localObject);
    this.jdField_a_of_type_ArrayOfAndroidViewView[0] = localObject;
    ((View)localObject).setBackgroundResource(2130839185);
    this.jdField_a_of_type_AndroidViewView = ((View)localObject);
    localObject = a(1, "仅WiFi");
    this.jdField_a_of_type_ArrayOfAndroidViewView[1] = localObject;
    this.jdField_a_of_type_AndroidViewViewGroup.addView((View)localObject);
    ((View)localObject).setBackgroundResource(2130839179);
    this.jdField_a_of_type_AndroidViewView = ((View)localObject);
    localObject = a(2, ajya.a(2131710811));
    this.jdField_a_of_type_ArrayOfAndroidViewView[2] = localObject;
    this.jdField_a_of_type_AndroidViewViewGroup.addView((View)localObject);
    ((View)localObject).setBackgroundResource(2130839176);
    this.jdField_a_of_type_AndroidViewView = ((View)localObject);
    super.setContentView(this.jdField_a_of_type_AndroidViewViewGroup);
    this.jdField_a_of_type_Bcqi = new bcqi(this, 2131561032);
  }
  
  public void a(int paramInt)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_ArrayOfAndroidViewView.length)
    {
      View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[i];
      ImageView localImageView = (ImageView)localView.findViewById(2131362791);
      TextView localTextView = (TextView)localView.findViewById(2131377350);
      if (i != paramInt)
      {
        localImageView.setVisibility(4);
        localView.setContentDescription(localTextView.getText() + ajya.a(2131710809));
      }
      for (;;)
      {
        i += 1;
        break;
        localImageView.setVisibility(0);
        localView.setContentDescription(localTextView.getText() + ajya.a(2131710814));
      }
    }
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 1001;
    case 2: 
      return 3;
    case 0: 
      return 1;
    }
    return 2;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Sst = ((sst)this.app.getManager(181));
    this.jdField_a_of_type_Sss = ((sss)this.app.a(98));
    a();
    int i = a(this.jdField_a_of_type_Sst.a());
    this.b = i;
    this.jdField_a_of_type_Int = i;
    a(this.jdField_a_of_type_Int);
    super.setTitle(ssf.a + ajya.a(2131710818));
    this.app.addObserver(this.jdField_a_of_type_Ssv);
    if (!bbfj.g(this))
    {
      bcql.a(this, 1, 2131692321, 0).b(getTitleBarHeight());
      super.startTitleProgress();
      return true;
    }
    this.jdField_a_of_type_Sss.d();
    super.startTitleProgress();
    return true;
  }
  
  public void doOnDestroy()
  {
    this.app.removeObserver(this.jdField_a_of_type_Ssv);
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    if (!bbfj.g(this))
    {
      bcql.a(this, 1, 2131692321, 0).b(getTitleBarHeight());
      return;
    }
    int i = ((Integer)paramView.getTag()).intValue();
    this.b = this.jdField_a_of_type_Int;
    switch (i)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Bcqi.b(0, 2131718679, 0);
      a(i);
      return;
      this.jdField_a_of_type_Sss.d(3);
      continue;
      this.jdField_a_of_type_Sss.d(1);
      continue;
      this.jdField_a_of_type_Sss.d(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.settings.QQStoryBasicSettingsActivity
 * JD-Core Version:    0.7.0.1
 */