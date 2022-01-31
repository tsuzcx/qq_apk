package com.tencent.mobileqq.activity;

import adwa;
import adwb;
import adwc;
import altm;
import alud;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import bdbk;
import com.tencent.mobileqq.activity.contact.addcontact.SearchResultItem;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import ndv;

public class SearchFriendListActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private adwb jdField_a_of_type_Adwb;
  private altm jdField_a_of_type_Altm = new adwa(this);
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
    Object localObject2 = (adwc)paramView.getTag();
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      ((adwc)localObject2).jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      if (i != 1) {
        break label194;
      }
      ((adwc)localObject2).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(bdbk.a(this.app, str1, (byte)3));
      ((adwc)localObject2).b.setText("QQ号码: " + str1);
    }
    for (;;)
    {
      ((adwc)localObject2).jdField_a_of_type_Int = paramInt;
      paramView.setContentDescription(((adwc)localObject2).jdField_a_of_type_AndroidWidgetTextView.getText());
      return;
      TextView localTextView = ((adwc)localObject2).jdField_a_of_type_AndroidWidgetTextView;
      if (i == 1) {}
      for (localObject1 = str1;; localObject1 = str2)
      {
        localTextView.setText((CharSequence)localObject1);
        break;
      }
      label194:
      ((adwc)localObject2).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(bdbk.b(this.app, str2, (byte)3));
      ((adwc)localObject2).b.setText(alud.a(2131714020) + str2);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131562589);
    setContentBackgroundResource(2130838592);
    setTitle(alud.a(2131714019));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131376257));
    this.jdField_a_of_type_ComTencentWidgetXListView.setContentBackground(2130838592);
    addObserver(this.jdField_a_of_type_Altm);
    this.jdField_a_of_type_JavaUtilArrayList = getIntent().getParcelableArrayListExtra("param_search_result_item_list");
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.jdField_a_of_type_Adwb = new adwb(this, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Adwb);
    return true;
  }
  
  public void doOnDestroy()
  {
    removeObserver(this.jdField_a_of_type_Altm);
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    int i;
    if ((paramView.getTag() instanceof adwc))
    {
      i = ((adwc)paramView.getTag()).jdField_a_of_type_Int;
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
      ndv.a(this, null, String.valueOf(paramView.jdField_a_of_type_Long), false, -1, true, -1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SearchFriendListActivity
 * JD-Core Version:    0.7.0.1
 */