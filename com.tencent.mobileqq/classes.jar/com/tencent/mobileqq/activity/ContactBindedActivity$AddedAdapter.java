package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class ContactBindedActivity$AddedAdapter
  extends BaseAdapter
  implements DecodeTaskCompletionListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private final Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private boolean jdField_a_of_type_Boolean = false;
  
  public ContactBindedActivity$AddedAdapter(ContactBindedActivity paramContactBindedActivity, Context paramContext)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130844953);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public PhoneContact a(int paramInt)
  {
    return (PhoneContact)ContactBindedActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactBindedActivity).get(paramInt);
  }
  
  void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if ((ContactBindedActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactBindedActivity) != null) && (ContactBindedActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactBindedActivity).size() > 0))
      {
        PhoneContact localPhoneContact = (PhoneContact)ContactBindedActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactBindedActivity).get(ContactBindedActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactBindedActivity).size() - 1);
        ContactBindedActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactBindedActivity, localPhoneContact, false);
      }
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    super.notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return ContactBindedActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactBindedActivity).size();
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    PhoneContact localPhoneContact = a(paramInt);
    Bitmap localBitmap = null;
    View localView = paramView;
    if (paramView == null) {
      localView = this.jdField_a_of_type_ComTencentMobileqqActivityContactBindedActivity.getLayoutInflater().inflate(2131559277, null);
    }
    localView.setTag(localPhoneContact);
    ImageView localImageView = (ImageView)localView.findViewById(2131366401);
    paramView = localBitmap;
    if (paramInt == getCount() - 1)
    {
      paramView = localBitmap;
      if (this.jdField_a_of_type_Boolean) {
        paramView = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      }
    }
    localImageView.setImageDrawable(paramView);
    localBitmap = ContactBindedActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactBindedActivity).getBitmapFromCache(11, localPhoneContact.unifiedCode);
    paramView = localBitmap;
    if (localBitmap == null)
    {
      ContactBindedActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactBindedActivity).requestDecodeFace(localPhoneContact.unifiedCode, 11, true, (byte)0);
      paramView = ContactBindedActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactBindedActivity);
    }
    localImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramView));
    if (AppSetting.d) {
      localImageView.setContentDescription(localPhoneContact.name);
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public void notifyDataSetChanged()
  {
    this.jdField_a_of_type_Boolean = false;
    super.notifyDataSetChanged();
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (ContactBindedActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactBindedActivity) == null) {
      return;
    }
    paramInt1 = 0;
    while (paramInt1 < ContactBindedActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactBindedActivity).getChildCount())
    {
      View localView = ContactBindedActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactBindedActivity).getChildAt(paramInt1);
      Object localObject = localView.getTag();
      if ((localObject != null) && ((localObject instanceof PhoneContact)) && (paramString.equals(((PhoneContact)localObject).unifiedCode))) {
        ((ImageView)localView.findViewById(2131366401)).setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
      }
      paramInt1 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ContactBindedActivity.AddedAdapter
 * JD-Core Version:    0.7.0.1
 */