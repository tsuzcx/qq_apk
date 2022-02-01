package com.tencent.av.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo.TelInfo;
import com.tencent.av.utils.PstnUtils;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

class GAudioMemberListCtrl$GAudioMemberListAdapter
  extends BaseAdapter
{
  private GAudioMemberListCtrl$GAudioMemberListAdapter(GAudioMemberListCtrl paramGAudioMemberListCtrl) {}
  
  GAudioMemberListCtrl.ViewHolder a(View paramView, boolean paramBoolean)
  {
    GAudioMemberListCtrl.ViewHolder localViewHolder = new GAudioMemberListCtrl.ViewHolder(this.a, null);
    localViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131373409));
    localViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373425));
    localViewHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373411));
    localViewHolder.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131373398));
    localViewHolder.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373430));
    localViewHolder.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131373427));
    if (!GAudioMemberListCtrl.a(this.a))
    {
      localViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      localViewHolder.jdField_b_of_type_AndroidWidgetImageView.setEnabled(false);
      localViewHolder.jdField_b_of_type_AndroidWidgetImageView.setClickable(false);
    }
    localViewHolder.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this.a.b);
    localViewHolder.jdField_c_of_type_Boolean = paramBoolean;
    if (GAudioMemberListCtrl.b(this.a))
    {
      paramView.setBackgroundColor(-16777216);
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#A8A8A8"));
      localViewHolder.jdField_c_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#757575"));
      localViewHolder.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131373429);
      localViewHolder.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(UITools.a(10.4F, (Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()));
      paramView.findViewById(2131363751).setBackgroundColor(Color.parseColor("#0F0F0F"));
    }
    return localViewHolder;
  }
  
  public int getCount()
  {
    return this.a.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2 = paramView;
    GAudioMemberListCtrl.GAudioMemberInfo localGAudioMemberInfo = (GAudioMemberListCtrl.GAudioMemberInfo)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    Object localObject1;
    Object localObject3;
    if (localObject2 == null)
    {
      localObject1 = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559699, null);
      paramView = a((View)localObject1, localGAudioMemberInfo.e);
      ((View)localObject1).setTag(paramView);
    }
    else
    {
      localObject3 = (GAudioMemberListCtrl.ViewHolder)paramView.getTag();
      localObject1 = localObject2;
      paramView = (View)localObject3;
      if (localObject3 == null)
      {
        paramView = a((View)localObject2, localGAudioMemberInfo.e);
        ((View)localObject2).setTag(paramView);
        localObject1 = localObject2;
      }
    }
    paramView.jdField_b_of_type_AndroidWidgetImageView.setTag(localGAudioMemberInfo);
    paramView.jdField_a_of_type_AndroidWidgetImageView.setTag(localGAudioMemberInfo);
    if ((localGAudioMemberInfo.jdField_a_of_type_JavaLangString == null) || (localGAudioMemberInfo.jdField_a_of_type_AndroidGraphicsBitmap == null) || (!localGAudioMemberInfo.jdField_b_of_type_Boolean)) {
      if (localGAudioMemberInfo.jdField_a_of_type_Int == 0)
      {
        localObject2 = String.valueOf(localGAudioMemberInfo.jdField_a_of_type_Long);
        localGAudioMemberInfo.jdField_a_of_type_JavaLangString = this.a.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject2, String.valueOf(this.a.jdField_a_of_type_Long), this.a.jdField_a_of_type_Int);
        if (localGAudioMemberInfo.jdField_a_of_type_JavaLangString.compareTo((String)localObject2) != 0) {
          localGAudioMemberInfo.jdField_b_of_type_Boolean = true;
        } else {
          localGAudioMemberInfo.jdField_b_of_type_Boolean = false;
        }
        localObject3 = this.a.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject2, String.valueOf(this.a.jdField_a_of_type_Long), this.a.jdField_a_of_type_Int, false, true);
        if (localGAudioMemberInfo.e)
        {
          localObject2 = localObject3;
          if (!GAudioMemberListCtrl.b(this.a)) {}
        }
        else
        {
          localObject2 = localObject3;
          if (localObject3 != null) {
            localObject2 = ImageUtil.a((Bitmap)localObject3, true);
          }
        }
        if (localObject2 != null)
        {
          localGAudioMemberInfo.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject2);
        }
        else
        {
          localGAudioMemberInfo.jdField_a_of_type_AndroidGraphicsBitmap = null;
          localGAudioMemberInfo.jdField_b_of_type_Boolean = false;
        }
      }
      else
      {
        long l = localGAudioMemberInfo.jdField_a_of_type_Long;
        if (localGAudioMemberInfo.jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo != null) {
          localObject2 = localGAudioMemberInfo.jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo;
        } else {
          localObject2 = this.a.jdField_a_of_type_ComTencentAvVideoController.a(l, this.a.jdField_a_of_type_ComTencentAvVideoController.a().f);
        }
        if ((localObject2 != null) && (((AVPhoneUserInfo)localObject2).telInfo.mobile != null))
        {
          localGAudioMemberInfo.jdField_a_of_type_JavaLangString = ((AVPhoneUserInfo)localObject2).telInfo.mobile;
          localObject3 = this.a.jdField_a_of_type_ComTencentAvVideoController.a(((AVPhoneUserInfo)localObject2).telInfo.mobile);
          if (localObject3 != null)
          {
            localGAudioMemberInfo.jdField_b_of_type_JavaLangString = ContactUtils.a((String)localObject3);
            localGAudioMemberInfo.jdField_a_of_type_JavaLangString = ((String)localObject3);
          }
          else
          {
            localGAudioMemberInfo.jdField_b_of_type_JavaLangString = null;
            localGAudioMemberInfo.jdField_a_of_type_JavaLangString = PstnUtils.a(((AVPhoneUserInfo)localObject2).telInfo.mobile, 4);
          }
        }
        else
        {
          if ((localObject2 != null) && (QLog.isColorLevel()))
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("getView --> can not get Open Id. PhoneInfo = ");
            ((StringBuilder)localObject3).append(((AVPhoneUserInfo)localObject2).toString());
            QLog.d("GAudioMemberListCtrl", 2, ((StringBuilder)localObject3).toString());
          }
          localGAudioMemberInfo.jdField_b_of_type_JavaLangString = null;
          localGAudioMemberInfo.jdField_a_of_type_JavaLangString = ((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131693109);
        }
        localGAudioMemberInfo.jdField_a_of_type_AndroidGraphicsBitmap = ((BitmapDrawable)((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getDrawable(2130842202)).getBitmap();
        localGAudioMemberInfo.jdField_b_of_type_Boolean = true;
      }
    }
    paramView.jdField_b_of_type_Boolean = true;
    paramView.jdField_a_of_type_Long = localGAudioMemberInfo.jdField_a_of_type_Long;
    if (localGAudioMemberInfo.jdField_a_of_type_JavaLangString != null)
    {
      float f = paramView.jdField_a_of_type_AndroidWidgetTextView.getResources().getDimensionPixelSize(2131297162);
      localObject2 = UITools.a(paramView.jdField_a_of_type_AndroidWidgetTextView.getContext(), localGAudioMemberInfo.jdField_a_of_type_JavaLangString, paramView.jdField_a_of_type_AndroidWidgetTextView, f);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
    }
    else
    {
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(localGAudioMemberInfo.jdField_a_of_type_Long));
    }
    if (localGAudioMemberInfo.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      if ((localGAudioMemberInfo.jdField_a_of_type_Int != 0) && (localGAudioMemberInfo.jdField_b_of_type_JavaLangString != null))
      {
        paramView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        paramView.jdField_b_of_type_AndroidWidgetTextView.setText(localGAudioMemberInfo.jdField_b_of_type_JavaLangString);
        localObject2 = ((BitmapDrawable)((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getDrawable(2130842159)).getBitmap();
        paramView.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject2);
      }
      else
      {
        paramView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        paramView.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localGAudioMemberInfo.jdField_a_of_type_AndroidGraphicsBitmap);
        if (localGAudioMemberInfo.jdField_a_of_type_Int == 0) {
          paramView.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.a.jdField_a_of_type_AndroidViewView$OnClickListener);
        }
      }
    }
    else
    {
      paramView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840321);
    }
    if (localGAudioMemberInfo.jdField_c_of_type_Boolean)
    {
      if ((paramView.jdField_a_of_type_Int == -1) || (paramView.jdField_a_of_type_Int == 0))
      {
        this.a.a(paramView.jdField_b_of_type_AndroidWidgetImageView, localGAudioMemberInfo.jdField_c_of_type_Boolean);
        paramView.jdField_a_of_type_Int = 1;
      }
      localGAudioMemberInfo.jdField_a_of_type_Boolean = false;
    }
    else if ((paramView.jdField_a_of_type_Int == -1) || (paramView.jdField_a_of_type_Int == 1))
    {
      this.a.a(paramView.jdField_b_of_type_AndroidWidgetImageView, localGAudioMemberInfo.jdField_c_of_type_Boolean);
      paramView.jdField_a_of_type_Int = 0;
    }
    paramView.jdField_a_of_type_Boolean = localGAudioMemberInfo.jdField_a_of_type_Boolean;
    if (paramView.jdField_a_of_type_Boolean)
    {
      paramView.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      if (paramView.jdField_a_of_type_AndroidViewView != null) {
        paramView.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
    }
    else
    {
      paramView.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      if (paramView.jdField_a_of_type_AndroidViewView != null) {
        paramView.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
    }
    if (!localGAudioMemberInfo.e)
    {
      paramView.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    else
    {
      if (GAudioMemberListCtrl.a(this.a)) {
        paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      paramView.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.GAudioMemberListCtrl.GAudioMemberListAdapter
 * JD-Core Version:    0.7.0.1
 */