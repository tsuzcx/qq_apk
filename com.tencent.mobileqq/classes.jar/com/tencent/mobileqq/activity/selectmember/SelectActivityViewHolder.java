package com.tencent.mobileqq.activity.selectmember;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopMemberListActivity.ViewHolder;
import com.tencent.mobileqq.adapter.CharDividedFacePreloadBaseAdapter;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.utils.ContactUtils;

public class SelectActivityViewHolder
  extends TroopMemberListActivity.ViewHolder
{
  public View a;
  public CheckBox a;
  public PhoneContact a;
  public boolean a;
  public TextView c;
  public TextView d;
  
  public static int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ("0".equals(paramString)) {
      return 11;
    }
    return 1;
  }
  
  public static View a(ViewGroup paramViewGroup, LayoutInflater paramLayoutInflater, int paramInt)
  {
    paramViewGroup = paramLayoutInflater.inflate(paramInt, paramViewGroup, false);
    paramLayoutInflater = new SelectActivityViewHolder();
    paramViewGroup.setTag(paramLayoutInflater);
    paramLayoutInflater.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131363915));
    paramLayoutInflater.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131363914));
    paramLayoutInflater.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramViewGroup.findViewById(2131363916));
    paramLayoutInflater.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131362701));
    paramLayoutInflater.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131363917));
    paramLayoutInflater.d = ((TextView)paramViewGroup.findViewById(2131363918));
    paramLayoutInflater.b = ((TextView)paramViewGroup.findViewById(2131362736));
    paramLayoutInflater.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131363919);
    return paramViewGroup;
  }
  
  public static void a(CharDividedFacePreloadBaseAdapter paramCharDividedFacePreloadBaseAdapter, SelectActivityViewHolder paramSelectActivityViewHolder, PhoneContact paramPhoneContact)
  {
    paramSelectActivityViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    paramSelectActivityViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    paramSelectActivityViewHolder.jdField_c_of_type_Int = a(paramPhoneContact.uin);
    if (TextUtils.isEmpty(paramPhoneContact.uin))
    {
      paramSelectActivityViewHolder.jdField_a_of_type_JavaLangString = ("pstn" + paramPhoneContact.mobileNo);
      paramSelectActivityViewHolder.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130840183);
      paramSelectActivityViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      paramSelectActivityViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(ContactUtils.a(paramPhoneContact.name));
      paramSelectActivityViewHolder.jdField_a_of_type_Boolean = true;
      return;
    }
    if (!"0".equals(paramPhoneContact.uin))
    {
      paramSelectActivityViewHolder.jdField_a_of_type_JavaLangString = paramPhoneContact.uin;
      paramSelectActivityViewHolder.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(paramCharDividedFacePreloadBaseAdapter.a(paramSelectActivityViewHolder.jdField_a_of_type_JavaLangString, 1, (byte)0));
      paramSelectActivityViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      paramSelectActivityViewHolder.jdField_a_of_type_Boolean = false;
      return;
    }
    paramSelectActivityViewHolder.jdField_a_of_type_JavaLangString = (paramPhoneContact.nationCode + paramPhoneContact.mobileCode);
    paramSelectActivityViewHolder.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(paramCharDividedFacePreloadBaseAdapter.a(paramSelectActivityViewHolder.jdField_a_of_type_JavaLangString, 11, (byte)0));
    paramSelectActivityViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    paramSelectActivityViewHolder.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.SelectActivityViewHolder
 * JD-Core Version:    0.7.0.1
 */