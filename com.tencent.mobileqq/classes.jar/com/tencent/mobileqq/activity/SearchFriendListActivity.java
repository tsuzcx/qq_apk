package com.tencent.mobileqq.activity;

import acah;
import acai;
import acaj;
import ajxl;
import ajyc;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import baxt;
import com.tencent.mobileqq.activity.contact.addcontact.SearchResultItem;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import nbc;

public class SearchFriendListActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private acai jdField_a_of_type_Acai;
  private ajxl jdField_a_of_type_Ajxl = new acah(this);
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private ArrayList<SearchResultItem> jdField_a_of_type_JavaUtilArrayList;
  
  public void a(View paramView, int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size())) {}
    do
    {
      return;
      localObject2 = (SearchResultItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    } while (localObject2 == null);
    Object localObject1 = ((SearchResultItem)localObject2).jdField_a_of_type_JavaLangString;
    String str1 = String.valueOf(((SearchResultItem)localObject2).jdField_a_of_type_Long);
    String str2 = ((SearchResultItem)localObject2).b;
    int i = ((SearchResultItem)localObject2).jdField_a_of_type_Int;
    Object localObject2 = (acaj)paramView.getTag();
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      ((acaj)localObject2).jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      if (i != 1) {
        break label194;
      }
      ((acaj)localObject2).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(baxt.a(this.app, str1, (byte)3));
      ((acaj)localObject2).b.setText("QQ号码: " + str1);
    }
    for (;;)
    {
      ((acaj)localObject2).jdField_a_of_type_Int = paramInt;
      paramView.setContentDescription(((acaj)localObject2).jdField_a_of_type_AndroidWidgetTextView.getText());
      return;
      TextView localTextView = ((acaj)localObject2).jdField_a_of_type_AndroidWidgetTextView;
      if (i == 1) {}
      for (localObject1 = str1;; localObject1 = str2)
      {
        localTextView.setText((CharSequence)localObject1);
        break;
      }
      label194:
      ((acaj)localObject2).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(baxt.b(this.app, str2, (byte)3));
      ((acaj)localObject2).b.setText(ajyc.a(2131713625) + str2);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131562368);
    setContentBackgroundResource(2130838514);
    setTitle(ajyc.a(2131713624));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131375707));
    this.jdField_a_of_type_ComTencentWidgetXListView.setContentBackground(2130838514);
    addObserver(this.jdField_a_of_type_Ajxl);
    this.jdField_a_of_type_JavaUtilArrayList = getIntent().getParcelableArrayListExtra("param_search_result_item_list");
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.jdField_a_of_type_Acai = new acai(this, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Acai);
    return true;
  }
  
  public void doOnDestroy()
  {
    removeObserver(this.jdField_a_of_type_Ajxl);
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    int i;
    if ((paramView.getTag() instanceof acaj))
    {
      i = ((acaj)paramView.getTag()).jdField_a_of_type_Int;
      if ((i < 0) || (i >= this.jdField_a_of_type_JavaUtilArrayList.size())) {
        break label90;
      }
    }
    label90:
    for (paramView = (SearchResultItem)this.jdField_a_of_type_JavaUtilArrayList.get(i);; paramView = null)
    {
      if (paramView == null) {
        return;
      }
      if (paramView.c == 0)
      {
        AddFriendActivity.a(this, paramView, this.app, false, 1);
        return;
      }
      nbc.a(this, null, String.valueOf(paramView.jdField_a_of_type_Long), false, -1, true, -1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SearchFriendListActivity
 * JD-Core Version:    0.7.0.1
 */