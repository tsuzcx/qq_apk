package com.tencent.mobileqq.activity;

import adrl;
import adrm;
import adrn;
import alox;
import alpo;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import bcxb;
import com.tencent.mobileqq.activity.contact.addcontact.SearchResultItem;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import ndv;

public class SearchFriendListActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private adrm jdField_a_of_type_Adrm;
  private alox jdField_a_of_type_Alox = new adrl(this);
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
    Object localObject2 = (adrn)paramView.getTag();
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      ((adrn)localObject2).jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      if (i != 1) {
        break label194;
      }
      ((adrn)localObject2).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(bcxb.a(this.app, str1, (byte)3));
      ((adrn)localObject2).b.setText("QQ号码: " + str1);
    }
    for (;;)
    {
      ((adrn)localObject2).jdField_a_of_type_Int = paramInt;
      paramView.setContentDescription(((adrn)localObject2).jdField_a_of_type_AndroidWidgetTextView.getText());
      return;
      TextView localTextView = ((adrn)localObject2).jdField_a_of_type_AndroidWidgetTextView;
      if (i == 1) {}
      for (localObject1 = str1;; localObject1 = str2)
      {
        localTextView.setText((CharSequence)localObject1);
        break;
      }
      label194:
      ((adrn)localObject2).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(bcxb.b(this.app, str2, (byte)3));
      ((adrn)localObject2).b.setText(alpo.a(2131714008) + str2);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131562571);
    setContentBackgroundResource(2130838591);
    setTitle(alpo.a(2131714007));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131376203));
    this.jdField_a_of_type_ComTencentWidgetXListView.setContentBackground(2130838591);
    addObserver(this.jdField_a_of_type_Alox);
    this.jdField_a_of_type_JavaUtilArrayList = getIntent().getParcelableArrayListExtra("param_search_result_item_list");
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.jdField_a_of_type_Adrm = new adrm(this, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Adrm);
    return true;
  }
  
  public void doOnDestroy()
  {
    removeObserver(this.jdField_a_of_type_Alox);
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    int i;
    if ((paramView.getTag() instanceof adrn))
    {
      i = ((adrn)paramView.getTag()).jdField_a_of_type_Int;
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