package com.tencent.av.ui;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo.TelInfo;
import com.tencent.av.utils.PstnUtils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class MultiMembersVideoUI$MVAdapter
  extends BaseAdapter
{
  MultiMembersVideoUI$MVAdapter(MultiMembersVideoUI paramMultiMembersVideoUI) {}
  
  MultiMembersUI.Holder a(View paramView)
  {
    MultiMembersUI.Holder localHolder = new MultiMembersUI.Holder();
    localHolder.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131373412));
    localHolder.d = ((ImageView)paramView.findViewById(2131373409));
    localHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373425));
    localHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131373427));
    localHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373411));
    localHolder.e = ((ImageView)paramView.findViewById(2131373424));
    localHolder.f = ((ImageView)paramView.findViewById(2131373410));
    if ((this.a.jdField_b_of_type_Boolean) && (localHolder.jdField_a_of_type_AndroidWidgetTextView != null) && (localHolder.d != null))
    {
      float f = MultiMembersVideoUI.a(this.a).getDisplayMetrics().density;
      localHolder.jdField_a_of_type_AndroidWidgetTextView.setTextSize(12.0F);
      double d = f;
      Double.isNaN(d);
      int i = (int)(d * 1.5D);
      localHolder.d.setPadding(i, i, i, i);
    }
    if (localHolder.jdField_a_of_type_AndroidWidgetTextView != null) {
      if (this.a.jdField_a_of_type_Boolean) {
        localHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColor(2131166062));
      } else {
        localHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColor(2131166062));
      }
    }
    if (localHolder.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      paramView = (RelativeLayout.LayoutParams)localHolder.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
      if (this.a.jdField_a_of_type_Boolean)
      {
        paramView.width = this.a.getResources().getDimensionPixelSize(2131297882);
        paramView.height = this.a.getResources().getDimensionPixelSize(2131297881);
      }
      else
      {
        paramView.width = this.a.getResources().getDimensionPixelSize(2131297888);
        paramView.height = this.a.getResources().getDimensionPixelSize(2131297886);
      }
      localHolder.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(paramView);
    }
    return localHolder;
  }
  
  public int getCount()
  {
    if (((this.a.jdField_a_of_type_Int == 1) || (this.a.jdField_a_of_type_Int == 2)) && (this.a.jdField_a_of_type_JavaUtilArrayList.size() > 8)) {
      return 8;
    }
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
    if ((paramInt != 0) || (localObject2 == null) || (paramViewGroup.getChildCount() == paramInt)) {
      for (;;)
      {
        Object localObject1;
        if (localObject2 == null)
        {
          paramView = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559733, null);
          localObject1 = a(paramView);
          paramView.setTag(localObject1);
        }
        else
        {
          localObject3 = (MultiMembersUI.Holder)paramView.getTag();
          paramView = (View)localObject2;
          localObject1 = localObject3;
          if (localObject3 == null)
          {
            localObject1 = a((View)localObject2);
            paramView = (View)localObject2;
          }
        }
        Object localObject3 = (MultiMembersUI.MVMembersInfo)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        if ((((MultiMembersUI.MVMembersInfo)localObject3).jdField_a_of_type_JavaLangString == null) || (((MultiMembersUI.MVMembersInfo)localObject3).jdField_a_of_type_AndroidGraphicsBitmap == null) || (!((MultiMembersUI.MVMembersInfo)localObject3).d)) {
          if (((MultiMembersUI.MVMembersInfo)localObject3).jdField_b_of_type_Int == 0)
          {
            localObject2 = String.valueOf(((MultiMembersUI.MVMembersInfo)localObject3).jdField_a_of_type_Long);
            ((MultiMembersUI.MVMembersInfo)localObject3).jdField_a_of_type_JavaLangString = this.a.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject2, String.valueOf(this.a.jdField_a_of_type_Long), this.a.jdField_a_of_type_Int);
            if (((MultiMembersUI.MVMembersInfo)localObject3).jdField_a_of_type_JavaLangString.compareTo((String)localObject2) != 0) {
              ((MultiMembersUI.MVMembersInfo)localObject3).d = true;
            } else {
              ((MultiMembersUI.MVMembersInfo)localObject3).d = false;
            }
            localObject2 = this.a.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject2, String.valueOf(this.a.jdField_a_of_type_Long), this.a.jdField_a_of_type_Int, false, true);
            if (localObject2 != null)
            {
              ((MultiMembersUI.MVMembersInfo)localObject3).jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject2);
            }
            else
            {
              ((MultiMembersUI.MVMembersInfo)localObject3).jdField_a_of_type_AndroidGraphicsBitmap = null;
              ((MultiMembersUI.MVMembersInfo)localObject3).d = false;
            }
          }
          else
          {
            long l = ((MultiMembersUI.MVMembersInfo)localObject3).jdField_a_of_type_Long;
            if (((MultiMembersUI.MVMembersInfo)localObject3).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo != null) {
              localObject2 = ((MultiMembersUI.MVMembersInfo)localObject3).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo;
            } else {
              localObject2 = this.a.jdField_a_of_type_ComTencentAvVideoController.a(l, this.a.jdField_a_of_type_ComTencentAvVideoController.a().f);
            }
            Object localObject4;
            if ((localObject2 != null) && (((AVPhoneUserInfo)localObject2).telInfo.mobile != null))
            {
              ((MultiMembersUI.MVMembersInfo)localObject3).jdField_a_of_type_JavaLangString = ((AVPhoneUserInfo)localObject2).telInfo.mobile;
              localObject4 = this.a.jdField_a_of_type_ComTencentAvVideoController.a(((AVPhoneUserInfo)localObject2).telInfo.mobile);
              if (localObject4 != null)
              {
                ((MultiMembersUI.MVMembersInfo)localObject3).jdField_b_of_type_JavaLangString = ContactUtils.a((String)localObject4);
                ((MultiMembersUI.MVMembersInfo)localObject3).jdField_a_of_type_JavaLangString = ((String)localObject4);
              }
              else
              {
                ((MultiMembersUI.MVMembersInfo)localObject3).jdField_b_of_type_JavaLangString = null;
                ((MultiMembersUI.MVMembersInfo)localObject3).jdField_a_of_type_JavaLangString = PstnUtils.a(((AVPhoneUserInfo)localObject2).telInfo.mobile, 4);
              }
            }
            else
            {
              if ((localObject2 != null) && (QLog.isColorLevel()))
              {
                localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append("getView --> can not get Open Id. PhoneInfo = ");
                ((StringBuilder)localObject4).append(((AVPhoneUserInfo)localObject2).toString());
                QLog.d("MultiMembersVideoUI", 2, ((StringBuilder)localObject4).toString());
              }
              ((MultiMembersUI.MVMembersInfo)localObject3).jdField_b_of_type_JavaLangString = null;
              ((MultiMembersUI.MVMembersInfo)localObject3).jdField_a_of_type_JavaLangString = MultiMembersVideoUI.b(this.a).getString(2131693109);
            }
            ((MultiMembersUI.MVMembersInfo)localObject3).jdField_a_of_type_AndroidGraphicsBitmap = ((BitmapDrawable)MultiMembersVideoUI.c(this.a).getDrawable(2130842202)).getBitmap();
            ((MultiMembersUI.MVMembersInfo)localObject3).d = true;
          }
        }
        if (((this.a.jdField_a_of_type_Int == 1) || (this.a.jdField_a_of_type_Int == 2)) && (paramInt == 7) && (this.a.jdField_a_of_type_JavaUtilArrayList.size() > 8))
        {
          ((MultiMembersUI.Holder)localObject1).jdField_b_of_type_Boolean = false;
          localObject2 = new GradientDrawable();
          ((GradientDrawable)localObject2).setShape(1);
          ((GradientDrawable)localObject2).setColor(Color.parseColor("#4C000000"));
          ((MultiMembersUI.Holder)localObject1).d.setImageDrawable((Drawable)localObject2);
          ((MultiMembersUI.Holder)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373411));
          localObject2 = new StringBuilder("");
          ((StringBuilder)localObject2).append(this.a.jdField_a_of_type_JavaUtilArrayList.size() - 8 + 1);
          ((StringBuilder)localObject2).append("+");
          ((MultiMembersUI.Holder)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(((StringBuilder)localObject2).toString());
          ((MultiMembersUI.Holder)localObject1).jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
          ((MultiMembersUI.Holder)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          ((MultiMembersUI.Holder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText("");
          paramView.setContentDescription(MultiMembersVideoUI.d(this.a).getString(2131693108));
          localObject2 = paramView;
        }
        else
        {
          ((MultiMembersUI.Holder)localObject1).jdField_b_of_type_Boolean = true;
          ((MultiMembersUI.Holder)localObject1).jdField_a_of_type_Long = ((MultiMembersUI.MVMembersInfo)localObject3).jdField_a_of_type_Long;
          if (((MultiMembersUI.MVMembersInfo)localObject3).jdField_a_of_type_JavaLangString != null) {
            ((MultiMembersUI.Holder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(((MultiMembersUI.MVMembersInfo)localObject3).jdField_a_of_type_JavaLangString);
          } else {
            ((MultiMembersUI.Holder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(((MultiMembersUI.MVMembersInfo)localObject3).jdField_a_of_type_Long));
          }
          if (((MultiMembersUI.MVMembersInfo)localObject3).jdField_a_of_type_AndroidGraphicsBitmap != null)
          {
            if ((((MultiMembersUI.MVMembersInfo)localObject3).jdField_b_of_type_Int != 0) && (((MultiMembersUI.MVMembersInfo)localObject3).jdField_b_of_type_JavaLangString != null))
            {
              ((MultiMembersUI.Holder)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
              ((MultiMembersUI.Holder)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(((MultiMembersUI.MVMembersInfo)localObject3).jdField_b_of_type_JavaLangString);
              localObject2 = ((BitmapDrawable)MultiMembersVideoUI.e(this.a).getDrawable(2130842159)).getBitmap();
              ((MultiMembersUI.Holder)localObject1).d.setImageBitmap((Bitmap)localObject2);
            }
            else
            {
              ((MultiMembersUI.Holder)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
              ((MultiMembersUI.Holder)localObject1).d.setImageBitmap(((MultiMembersUI.MVMembersInfo)localObject3).jdField_a_of_type_AndroidGraphicsBitmap);
            }
          }
          else
          {
            ((MultiMembersUI.Holder)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
            ((MultiMembersUI.Holder)localObject1).d.setImageResource(2130840321);
          }
          if (((this.a.jdField_a_of_type_ComTencentAvVideoController.a().E == 1) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().j == 10)) || (this.a.jdField_a_of_type_ComTencentAvVideoController.a().E == 2)) {
            if (((MultiMembersUI.MVMembersInfo)localObject3).e)
            {
              if (((MultiMembersUI.Holder)localObject1).e.getVisibility() != 0) {
                ((MultiMembersUI.Holder)localObject1).e.setVisibility(0);
              }
              if (((MultiMembersUI.Holder)localObject1).jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0) {
                ((MultiMembersUI.Holder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
              }
              ((MultiMembersUI.MVMembersInfo)localObject3).jdField_a_of_type_Boolean = false;
            }
            else if (((MultiMembersUI.Holder)localObject1).e.getVisibility() == 0)
            {
              ((MultiMembersUI.Holder)localObject1).e.setVisibility(8);
            }
          }
          ((MultiMembersUI.Holder)localObject1).jdField_a_of_type_Boolean = ((MultiMembersUI.MVMembersInfo)localObject3).jdField_a_of_type_Boolean;
          if (((MultiMembersUI.Holder)localObject1).jdField_a_of_type_Boolean) {
            ((MultiMembersUI.Holder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          } else {
            ((MultiMembersUI.Holder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          }
          if (((MultiMembersUI.MVMembersInfo)localObject3).jdField_a_of_type_Int == 2) {
            ((MultiMembersUI.Holder)localObject1).jdField_a_of_type_Int = 5;
          } else if (((MultiMembersUI.MVMembersInfo)localObject3).c) {
            ((MultiMembersUI.Holder)localObject1).jdField_a_of_type_Int = 3;
          } else if (((MultiMembersUI.MVMembersInfo)localObject3).jdField_a_of_type_Int == 1) {
            ((MultiMembersUI.Holder)localObject1).jdField_a_of_type_Int = 2;
          } else if (((MultiMembersUI.MVMembersInfo)localObject3).jdField_b_of_type_Boolean) {
            ((MultiMembersUI.Holder)localObject1).jdField_a_of_type_Int = 1;
          } else {
            ((MultiMembersUI.Holder)localObject1).jdField_a_of_type_Int = 0;
          }
          localObject2 = paramView;
          if (((MultiMembersUI.Holder)localObject1).d != null) {
            if ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().E != 1) || (this.a.jdField_a_of_type_ComTencentAvVideoController.a().j != 10))
            {
              localObject2 = paramView;
              if (this.a.jdField_a_of_type_Int != 2) {}
            }
            else
            {
              localObject2 = paramView;
              if (!((MultiMembersUI.MVMembersInfo)localObject3).f)
              {
                localObject3 = ((MultiMembersUI.Holder)localObject1).d.getDrawable();
                localObject2 = paramView;
                if (localObject3 != null)
                {
                  localObject2 = paramView;
                  if ((localObject3 instanceof BitmapDrawable))
                  {
                    localObject2 = ImageUtil.a(((BitmapDrawable)localObject3).getBitmap(), true);
                    ((MultiMembersUI.Holder)localObject1).d.setImageBitmap((Bitmap)localObject2);
                    localObject2 = paramView;
                  }
                }
              }
            }
          }
        }
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject2, paramViewGroup, getItemId(paramInt));
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiMembersVideoUI.MVAdapter
 * JD-Core Version:    0.7.0.1
 */