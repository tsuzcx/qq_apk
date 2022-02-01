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
    localViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131373837));
    localViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373853));
    localViewHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373839));
    localViewHolder.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131373826));
    localViewHolder.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373858));
    localViewHolder.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131373855));
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
      localViewHolder.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131373857);
      localViewHolder.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(UITools.a(10.4F, (Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()));
      paramView.findViewById(2131363823).setBackgroundColor(Color.parseColor("#0F0F0F"));
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
    GAudioMemberListCtrl.GAudioMemberInfo localGAudioMemberInfo = (GAudioMemberListCtrl.GAudioMemberInfo)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    Object localObject1;
    Object localObject2;
    label167:
    Object localObject3;
    if (paramView == null)
    {
      paramView = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559823, null);
      localObject1 = a(paramView, localGAudioMemberInfo.e);
      paramView.setTag(localObject1);
      ((GAudioMemberListCtrl.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.setTag(localGAudioMemberInfo);
      ((GAudioMemberListCtrl.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setTag(localGAudioMemberInfo);
      if ((localGAudioMemberInfo.jdField_a_of_type_JavaLangString == null) || (localGAudioMemberInfo.jdField_a_of_type_AndroidGraphicsBitmap == null) || (!localGAudioMemberInfo.jdField_b_of_type_Boolean))
      {
        if (localGAudioMemberInfo.jdField_a_of_type_Int != 0) {
          break label615;
        }
        localObject2 = String.valueOf(localGAudioMemberInfo.jdField_a_of_type_Long);
        localGAudioMemberInfo.jdField_a_of_type_JavaLangString = this.a.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject2, String.valueOf(this.a.jdField_a_of_type_Long), this.a.jdField_a_of_type_Int);
        if (localGAudioMemberInfo.jdField_a_of_type_JavaLangString.compareTo((String)localObject2) == 0) {
          break label591;
        }
        localGAudioMemberInfo.jdField_b_of_type_Boolean = true;
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
        if (localObject2 == null) {
          break label600;
        }
        localGAudioMemberInfo.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject2);
      }
      label251:
      ((GAudioMemberListCtrl.ViewHolder)localObject1).jdField_b_of_type_Boolean = true;
      ((GAudioMemberListCtrl.ViewHolder)localObject1).jdField_a_of_type_Long = localGAudioMemberInfo.jdField_a_of_type_Long;
      if (localGAudioMemberInfo.jdField_a_of_type_JavaLangString == null) {
        break label884;
      }
      float f = ((GAudioMemberListCtrl.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.getResources().getDimensionPixelSize(2131297180);
      localObject2 = UITools.a(((GAudioMemberListCtrl.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.getContext(), localGAudioMemberInfo.jdField_a_of_type_JavaLangString, ((GAudioMemberListCtrl.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView, f);
      ((GAudioMemberListCtrl.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      label326:
      if (localGAudioMemberInfo.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        break label952;
      }
      if ((localGAudioMemberInfo.jdField_a_of_type_Int == 0) || (localGAudioMemberInfo.jdField_b_of_type_JavaLangString == null)) {
        break label903;
      }
      ((GAudioMemberListCtrl.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      ((GAudioMemberListCtrl.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(localGAudioMemberInfo.jdField_b_of_type_JavaLangString);
      localObject2 = ((BitmapDrawable)((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getDrawable(2130842261)).getBitmap();
      ((GAudioMemberListCtrl.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject2);
      label411:
      if (!localGAudioMemberInfo.jdField_c_of_type_Boolean) {
        break label976;
      }
      if ((((GAudioMemberListCtrl.ViewHolder)localObject1).jdField_a_of_type_Int == -1) || (((GAudioMemberListCtrl.ViewHolder)localObject1).jdField_a_of_type_Int == 0))
      {
        this.a.a(((GAudioMemberListCtrl.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView, localGAudioMemberInfo.jdField_c_of_type_Boolean);
        ((GAudioMemberListCtrl.ViewHolder)localObject1).jdField_a_of_type_Int = 1;
      }
      localGAudioMemberInfo.jdField_a_of_type_Boolean = false;
      label465:
      ((GAudioMemberListCtrl.ViewHolder)localObject1).jdField_a_of_type_Boolean = localGAudioMemberInfo.jdField_a_of_type_Boolean;
      if (!((GAudioMemberListCtrl.ViewHolder)localObject1).jdField_a_of_type_Boolean) {
        break label1020;
      }
      ((GAudioMemberListCtrl.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      if (((GAudioMemberListCtrl.ViewHolder)localObject1).jdField_a_of_type_AndroidViewView != null) {
        ((GAudioMemberListCtrl.ViewHolder)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      label509:
      if (localGAudioMemberInfo.e) {
        break label1051;
      }
      ((GAudioMemberListCtrl.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      ((GAudioMemberListCtrl.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localObject2 = (GAudioMemberListCtrl.ViewHolder)paramView.getTag();
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = a(paramView, localGAudioMemberInfo.e);
        paramView.setTag(localObject1);
      }
      break;
      label591:
      localGAudioMemberInfo.jdField_b_of_type_Boolean = false;
      break label167;
      label600:
      localGAudioMemberInfo.jdField_a_of_type_AndroidGraphicsBitmap = null;
      localGAudioMemberInfo.jdField_b_of_type_Boolean = false;
      break label251;
      label615:
      long l = localGAudioMemberInfo.jdField_a_of_type_Long;
      if (localGAudioMemberInfo.jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo != null)
      {
        localObject2 = localGAudioMemberInfo.jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo;
        label637:
        if ((localObject2 == null) || (((AVPhoneUserInfo)localObject2).telInfo.mobile == null)) {
          break label806;
        }
        localGAudioMemberInfo.jdField_a_of_type_JavaLangString = ((AVPhoneUserInfo)localObject2).telInfo.mobile;
        localObject3 = this.a.jdField_a_of_type_ComTencentAvVideoController.a(((AVPhoneUserInfo)localObject2).telInfo.mobile);
        if (localObject3 == null) {
          break label780;
        }
        localGAudioMemberInfo.jdField_b_of_type_JavaLangString = ContactUtils.a((String)localObject3);
        localGAudioMemberInfo.jdField_a_of_type_JavaLangString = ((String)localObject3);
      }
      for (;;)
      {
        localGAudioMemberInfo.jdField_a_of_type_AndroidGraphicsBitmap = ((BitmapDrawable)((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getDrawable(2130842304)).getBitmap();
        localGAudioMemberInfo.jdField_b_of_type_Boolean = true;
        break;
        localObject2 = this.a.jdField_a_of_type_ComTencentAvVideoController.a(l, this.a.jdField_a_of_type_ComTencentAvVideoController.a().f);
        break label637;
        label780:
        localGAudioMemberInfo.jdField_b_of_type_JavaLangString = null;
        localGAudioMemberInfo.jdField_a_of_type_JavaLangString = PstnUtils.a(((AVPhoneUserInfo)localObject2).telInfo.mobile, 4);
        continue;
        label806:
        if ((localObject2 != null) && (QLog.isColorLevel())) {
          QLog.d("GAudioMemberListCtrl", 2, "getView --> can not get Open Id. PhoneInfo = " + ((AVPhoneUserInfo)localObject2).toString());
        }
        localGAudioMemberInfo.jdField_b_of_type_JavaLangString = null;
        localGAudioMemberInfo.jdField_a_of_type_JavaLangString = ((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131693149);
      }
      label884:
      ((GAudioMemberListCtrl.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(localGAudioMemberInfo.jdField_a_of_type_Long));
      break label326;
      label903:
      ((GAudioMemberListCtrl.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      ((GAudioMemberListCtrl.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localGAudioMemberInfo.jdField_a_of_type_AndroidGraphicsBitmap);
      if (localGAudioMemberInfo.jdField_a_of_type_Int != 0) {
        break label411;
      }
      ((GAudioMemberListCtrl.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.a.jdField_a_of_type_AndroidViewView$OnClickListener);
      break label411;
      label952:
      ((GAudioMemberListCtrl.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      ((GAudioMemberListCtrl.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840452);
      break label411;
      label976:
      if ((((GAudioMemberListCtrl.ViewHolder)localObject1).jdField_a_of_type_Int != -1) && (((GAudioMemberListCtrl.ViewHolder)localObject1).jdField_a_of_type_Int != 1)) {
        break label465;
      }
      this.a.a(((GAudioMemberListCtrl.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView, localGAudioMemberInfo.jdField_c_of_type_Boolean);
      ((GAudioMemberListCtrl.ViewHolder)localObject1).jdField_a_of_type_Int = 0;
      break label465;
      label1020:
      ((GAudioMemberListCtrl.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      if (((GAudioMemberListCtrl.ViewHolder)localObject1).jdField_a_of_type_AndroidViewView == null) {
        break label509;
      }
      ((GAudioMemberListCtrl.ViewHolder)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(8);
      break label509;
      label1051:
      if (GAudioMemberListCtrl.a(this.a)) {
        ((GAudioMemberListCtrl.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      ((GAudioMemberListCtrl.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.GAudioMemberListCtrl.GAudioMemberListAdapter
 * JD-Core Version:    0.7.0.1
 */