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
    localHolder.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131373840));
    localHolder.d = ((ImageView)paramView.findViewById(2131373837));
    localHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373853));
    localHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131373855));
    localHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373839));
    localHolder.e = ((ImageView)paramView.findViewById(2131373852));
    localHolder.f = ((ImageView)paramView.findViewById(2131373838));
    if ((this.a.jdField_b_of_type_Boolean) && (localHolder.jdField_a_of_type_AndroidWidgetTextView != null) && (localHolder.d != null))
    {
      float f = MultiMembersVideoUI.a(this.a).getDisplayMetrics().density;
      localHolder.jdField_a_of_type_AndroidWidgetTextView.setTextSize(12.0F);
      int i = (int)(f * 1.5D);
      localHolder.d.setPadding(i, i, i, i);
    }
    if (localHolder.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      if (this.a.jdField_a_of_type_Boolean) {
        localHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColor(2131166051));
      }
    }
    else if (localHolder.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      paramView = (RelativeLayout.LayoutParams)localHolder.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
      if (!this.a.jdField_a_of_type_Boolean) {
        break label312;
      }
      paramView.width = this.a.getResources().getDimensionPixelSize(2131297888);
    }
    for (paramView.height = this.a.getResources().getDimensionPixelSize(2131297887);; paramView.height = this.a.getResources().getDimensionPixelSize(2131297892))
    {
      localHolder.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(paramView);
      return localHolder;
      localHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColor(2131166051));
      break;
      label312:
      paramView.width = this.a.getResources().getDimensionPixelSize(2131297894);
    }
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
    Object localObject1;
    if ((paramInt == 0) && (paramView != null) && (paramViewGroup.getChildCount() != paramInt))
    {
      localObject1 = paramView;
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
    if (paramView == null)
    {
      paramView = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559857, null);
      localObject1 = a(paramView);
      paramView.setTag(localObject1);
    }
    label67:
    label458:
    label473:
    label495:
    label629:
    label1269:
    for (;;)
    {
      MultiMembersUI.MVMembersInfo localMVMembersInfo = (MultiMembersUI.MVMembersInfo)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      Object localObject2;
      if ((localMVMembersInfo.jdField_a_of_type_JavaLangString == null) || (localMVMembersInfo.jdField_a_of_type_AndroidGraphicsBitmap == null) || (!localMVMembersInfo.d))
      {
        if (localMVMembersInfo.jdField_b_of_type_Int != 0) {
          break label473;
        }
        localObject2 = String.valueOf(localMVMembersInfo.jdField_a_of_type_Long);
        localMVMembersInfo.jdField_a_of_type_JavaLangString = this.a.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject2, String.valueOf(this.a.jdField_a_of_type_Long), this.a.jdField_a_of_type_Int);
        if (localMVMembersInfo.jdField_a_of_type_JavaLangString.compareTo((String)localObject2) == 0) {
          break label449;
        }
        localMVMembersInfo.d = true;
        localObject2 = this.a.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject2, String.valueOf(this.a.jdField_a_of_type_Long), this.a.jdField_a_of_type_Int, false, true);
        if (localObject2 == null) {
          break label458;
        }
        localMVMembersInfo.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject2);
      }
      for (;;)
      {
        if (((this.a.jdField_a_of_type_Int != 1) && (this.a.jdField_a_of_type_Int != 2)) || (paramInt != 7) || (this.a.jdField_a_of_type_JavaUtilArrayList.size() <= 8)) {
          break label724;
        }
        ((MultiMembersUI.Holder)localObject1).jdField_b_of_type_Boolean = false;
        localObject2 = new GradientDrawable();
        ((GradientDrawable)localObject2).setShape(1);
        ((GradientDrawable)localObject2).setColor(Color.parseColor("#4C000000"));
        ((MultiMembersUI.Holder)localObject1).d.setImageDrawable((Drawable)localObject2);
        ((MultiMembersUI.Holder)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373839));
        localObject2 = new StringBuilder("");
        ((StringBuilder)localObject2).append(this.a.jdField_a_of_type_JavaUtilArrayList.size() - 8 + 1);
        ((StringBuilder)localObject2).append("+");
        ((MultiMembersUI.Holder)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(((StringBuilder)localObject2).toString());
        ((MultiMembersUI.Holder)localObject1).jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
        ((MultiMembersUI.Holder)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        ((MultiMembersUI.Holder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText("");
        paramView.setContentDescription(MultiMembersVideoUI.d(this.a).getString(2131693148));
        localObject1 = paramView;
        break;
        localObject1 = (MultiMembersUI.Holder)paramView.getTag();
        if (localObject1 != null) {
          break label1269;
        }
        localObject1 = a(paramView);
        break label67;
        localMVMembersInfo.d = false;
        break label178;
        localMVMembersInfo.jdField_a_of_type_AndroidGraphicsBitmap = null;
        localMVMembersInfo.d = false;
      }
      long l = localMVMembersInfo.jdField_a_of_type_Long;
      if (localMVMembersInfo.jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo != null)
      {
        localObject2 = localMVMembersInfo.jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo;
        if ((localObject2 == null) || (((AVPhoneUserInfo)localObject2).telInfo.mobile == null)) {
          break label655;
        }
        localMVMembersInfo.jdField_a_of_type_JavaLangString = ((AVPhoneUserInfo)localObject2).telInfo.mobile;
        String str = this.a.jdField_a_of_type_ComTencentAvVideoController.a(((AVPhoneUserInfo)localObject2).telInfo.mobile);
        if (str == null) {
          break label629;
        }
        localMVMembersInfo.jdField_b_of_type_JavaLangString = ContactUtils.a(str);
        localMVMembersInfo.jdField_a_of_type_JavaLangString = str;
      }
      for (;;)
      {
        localMVMembersInfo.jdField_a_of_type_AndroidGraphicsBitmap = ((BitmapDrawable)MultiMembersVideoUI.c(this.a).getDrawable(2130842304)).getBitmap();
        localMVMembersInfo.d = true;
        break;
        localObject2 = this.a.jdField_a_of_type_ComTencentAvVideoController.a(l, this.a.jdField_a_of_type_ComTencentAvVideoController.a().f);
        break label495;
        localMVMembersInfo.jdField_b_of_type_JavaLangString = null;
        localMVMembersInfo.jdField_a_of_type_JavaLangString = PstnUtils.a(((AVPhoneUserInfo)localObject2).telInfo.mobile, 4);
        continue;
        if ((localObject2 != null) && (QLog.isColorLevel())) {
          QLog.d("MultiMembersVideoUI", 2, "getView --> can not get Open Id. PhoneInfo = " + ((AVPhoneUserInfo)localObject2).toString());
        }
        localMVMembersInfo.jdField_b_of_type_JavaLangString = null;
        localMVMembersInfo.jdField_a_of_type_JavaLangString = MultiMembersVideoUI.b(this.a).getString(2131693149);
      }
      ((MultiMembersUI.Holder)localObject1).jdField_b_of_type_Boolean = true;
      ((MultiMembersUI.Holder)localObject1).jdField_a_of_type_Long = localMVMembersInfo.jdField_a_of_type_Long;
      if (localMVMembersInfo.jdField_a_of_type_JavaLangString != null)
      {
        ((MultiMembersUI.Holder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(localMVMembersInfo.jdField_a_of_type_JavaLangString);
        label761:
        if (localMVMembersInfo.jdField_a_of_type_AndroidGraphicsBitmap == null) {
          break label1147;
        }
        if ((localMVMembersInfo.jdField_b_of_type_Int == 0) || (localMVMembersInfo.jdField_b_of_type_JavaLangString == null)) {
          break label1121;
        }
        ((MultiMembersUI.Holder)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        ((MultiMembersUI.Holder)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(localMVMembersInfo.jdField_b_of_type_JavaLangString);
        localObject2 = ((BitmapDrawable)MultiMembersVideoUI.e(this.a).getDrawable(2130842261)).getBitmap();
        ((MultiMembersUI.Holder)localObject1).d.setImageBitmap((Bitmap)localObject2);
        if (((this.a.jdField_a_of_type_ComTencentAvVideoController.a().F == 1) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().D == 10)) || (this.a.jdField_a_of_type_ComTencentAvVideoController.a().F == 2))
        {
          if (!localMVMembersInfo.e) {
            break label1171;
          }
          if (((MultiMembersUI.Holder)localObject1).e.getVisibility() != 0) {
            ((MultiMembersUI.Holder)localObject1).e.setVisibility(0);
          }
          if (((MultiMembersUI.Holder)localObject1).jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0) {
            ((MultiMembersUI.Holder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          }
          localMVMembersInfo.jdField_a_of_type_Boolean = false;
        }
        ((MultiMembersUI.Holder)localObject1).jdField_a_of_type_Boolean = localMVMembersInfo.jdField_a_of_type_Boolean;
        if (!((MultiMembersUI.Holder)localObject1).jdField_a_of_type_Boolean) {
          break label1195;
        }
        ((MultiMembersUI.Holder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        if (localMVMembersInfo.jdField_a_of_type_Int != 2) {
          break label1208;
        }
        ((MultiMembersUI.Holder)localObject1).jdField_a_of_type_Int = 5;
      }
      for (;;)
      {
        if ((((MultiMembersUI.Holder)localObject1).d != null) && (((this.a.jdField_a_of_type_ComTencentAvVideoController.a().F == 1) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().D == 10)) || ((this.a.jdField_a_of_type_Int == 2) && (!localMVMembersInfo.f))))
        {
          localObject2 = ((MultiMembersUI.Holder)localObject1).d.getDrawable();
          if ((localObject2 != null) && ((localObject2 instanceof BitmapDrawable)))
          {
            localObject2 = ImageUtil.a(((BitmapDrawable)localObject2).getBitmap(), true);
            ((MultiMembersUI.Holder)localObject1).d.setImageBitmap((Bitmap)localObject2);
          }
        }
        localObject1 = paramView;
        break;
        ((MultiMembersUI.Holder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(localMVMembersInfo.jdField_a_of_type_Long));
        break label761;
        ((MultiMembersUI.Holder)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        ((MultiMembersUI.Holder)localObject1).d.setImageBitmap(localMVMembersInfo.jdField_a_of_type_AndroidGraphicsBitmap);
        break label838;
        label1147:
        ((MultiMembersUI.Holder)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        ((MultiMembersUI.Holder)localObject1).d.setImageResource(2130840452);
        break label838;
        if (((MultiMembersUI.Holder)localObject1).e.getVisibility() != 0) {
          break label945;
        }
        ((MultiMembersUI.Holder)localObject1).e.setVisibility(8);
        break label945;
        ((MultiMembersUI.Holder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        break label972;
        if (localMVMembersInfo.c) {
          ((MultiMembersUI.Holder)localObject1).jdField_a_of_type_Int = 3;
        } else if (localMVMembersInfo.jdField_a_of_type_Int == 1) {
          ((MultiMembersUI.Holder)localObject1).jdField_a_of_type_Int = 2;
        } else if (localMVMembersInfo.jdField_b_of_type_Boolean) {
          ((MultiMembersUI.Holder)localObject1).jdField_a_of_type_Int = 1;
        } else {
          ((MultiMembersUI.Holder)localObject1).jdField_a_of_type_Int = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.MultiMembersVideoUI.MVAdapter
 * JD-Core Version:    0.7.0.1
 */