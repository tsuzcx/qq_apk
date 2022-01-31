package com.tencent.mobileqq.activity.phone;

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
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.RegisterNewBaseActivity;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import wur;
import wus;
import wut;
import wuu;
import wuv;
import wuw;
import wuy;

public class NewStyleCountryActivity
  extends RegisterNewBaseActivity
  implements View.OnClickListener, IndexView.OnIndexChangedListener
{
  public View a;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  public IndexView a;
  private PinnedDividerListView jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
  public ArrayList a;
  public LinkedHashMap a;
  private wuu jdField_a_of_type_Wuu;
  public wuy a;
  public View b;
  private View c;
  
  public NewStyleCountryActivity()
  {
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  }
  
  public static void a(View paramView, wuv paramwuv)
  {
    paramView = (wuw)paramView.getTag();
    paramView.jdField_a_of_type_AndroidWidgetTextView.setText(paramwuv.b);
    paramView.jdField_a_of_type_Wuv = paramwuv;
  }
  
  private static View b(ViewGroup paramViewGroup, LayoutInflater paramLayoutInflater, boolean paramBoolean)
  {
    paramViewGroup = paramLayoutInflater.inflate(2130971504, paramViewGroup, false);
    if (paramBoolean) {
      paramViewGroup.setPadding(paramViewGroup.getPaddingLeft(), paramViewGroup.getPaddingTop(), (int)DisplayUtils.a(BaseApplicationImpl.sApplication, 40.0F), paramViewGroup.getPaddingBottom());
    }
    paramLayoutInflater = new wuw(null);
    paramLayoutInflater.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131365476));
    paramViewGroup.setTag(paramLayoutInflater);
    return paramViewGroup;
  }
  
  public void a(View paramView)
  {
    paramView = (wuw)paramView.getTag();
    if (paramView.jdField_a_of_type_Wuv != null)
    {
      if ((this.jdField_a_of_type_Wuy != null) && (this.jdField_a_of_type_Wuy.isShowing()) && (!super.isFinishing())) {
        this.jdField_a_of_type_Wuy.dismiss();
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("k_name", paramView.jdField_a_of_type_Wuv.b);
      localIntent.putExtra("k_code", paramView.jdField_a_of_type_Wuv.c);
      setResult(-1, localIntent);
      finish();
    }
  }
  
  public void b(String paramString)
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
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130971502);
    getWindow().setBackgroundDrawableResource(2131493046);
    c(2131434332);
    b();
    a(false);
    String[] arrayOfString1 = getResources().getStringArray(2131296344);
    Object localObject1 = getResources().getStringArray(2131296343);
    String[] arrayOfString2 = getResources().getStringArray(2131296342);
    Object localObject2 = getResources().getStringArray(2131296341);
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
    wuv localwuv;
    if (i < j)
    {
      localwuv = new wuv(arrayOfString2[i]);
      localObject1 = localwuv.a;
      if (paramBundle.equals(localObject1)) {
        break label601;
      }
      ((ArrayList)localObject2).add(new wuv((String)localObject1));
      paramBundle = (Bundle)localObject1;
    }
    label596:
    label601:
    for (;;)
    {
      ((ArrayList)localObject2).add(localwuv);
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
          break label596;
        }
      }
      for (j = j + i + 1;; j = i)
      {
        this.jdField_a_of_type_JavaUtilLinkedHashMap.put(localObject1, Integer.valueOf(i));
        i = j;
        break;
        this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject2);
        this.jdField_a_of_type_AndroidViewView = findViewById(2131374944);
        this.b = ((View)this.jdField_a_of_type_AndroidViewView.getParent());
        this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)findViewById(2131365475));
        this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setDivider(null);
        this.c = ((LayoutInflater)getSystemService("layout_inflater")).inflate(2130970587, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false);
        this.c.findViewById(2131368321).setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.c.findViewById(2131368322));
        this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
        this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
        this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(this);
        AccessibilityUtil.b(this.c);
        this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.addHeaderView(this.c);
        this.jdField_a_of_type_Wuu = new wuu(this, null);
        this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_Wuu);
        this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131365446));
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
      this.jdField_a_of_type_Wuy = new wuy(this, this);
      this.jdField_a_of_type_Wuy.setCanceledOnTouchOutside(true);
      int i = this.jdField_a_of_type_AndroidViewView.getHeight();
      paramView = new TranslateAnimation(0.0F, 0.0F, 0.0F, -i);
      paramView.setDuration(300L);
      paramView.setFillAfter(true);
      paramView.setAnimationListener(new wur(this));
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, -i, 0.0F);
      localTranslateAnimation.setDuration(300L);
      localTranslateAnimation.setAnimationListener(new wus(this, i));
      this.jdField_a_of_type_Wuy.setOnDismissListener(new wut(this, i, localTranslateAnimation));
      this.b.startAnimation(paramView);
      return;
    }
    a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.NewStyleCountryActivity
 * JD-Core Version:    0.7.0.1
 */