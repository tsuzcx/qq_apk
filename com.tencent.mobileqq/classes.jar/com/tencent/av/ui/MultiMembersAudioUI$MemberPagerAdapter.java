package com.tencent.av.ui;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo.TelInfo;
import com.tencent.av.utils.PstnUtils;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class MultiMembersAudioUI$MemberPagerAdapter
  extends PagerAdapter
{
  MultiMembersAudioUI$MemberPagerAdapter(MultiMembersAudioUI paramMultiMembersAudioUI) {}
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    int i = 0;
    if (this.a.jdField_a_of_type_JavaUtilArrayList == null) {
      return 0;
    }
    int j = this.a.jdField_b_of_type_Int / 8;
    if (this.a.jdField_b_of_type_Int % 8 == 0) {}
    for (;;)
    {
      return i + j;
      i = 1;
    }
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  @TargetApi(11)
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if ((!QLog.isColorLevel()) || ((this.a.jdField_a_of_type_JavaUtilArrayList == null) || (this.a.jdField_b_of_type_Int == 0)))
    {
      if (QLog.isColorLevel()) {}
      return null;
    }
    View localView1 = View.inflate(paramViewGroup.getContext(), 2131559854, null);
    Object localObject1;
    if (AudioHelper.a(0) == 1)
    {
      localView1.setBackgroundColor(2130706687);
      localView1.addOnLayoutChangeListener(new MultiMembersAudioUI.MemberPagerAdapter.1(this));
      if (paramViewGroup.getTag(2131368832) == null)
      {
        paramViewGroup.setBackgroundColor(-553615360);
        localObject1 = new MultiMembersAudioUI.MemberPagerAdapter.2(this);
        paramViewGroup.addOnLayoutChangeListener((View.OnLayoutChangeListener)localObject1);
        paramViewGroup.setTag(2131368832, localObject1);
      }
    }
    if (paramInt == getCount() - 1) {}
    for (int i = this.a.jdField_b_of_type_Int - paramInt * 8;; i = 8)
    {
      this.a.a(localView1, i);
      int j = 0;
      int k;
      if (j < i)
      {
        k = paramInt * 8 + j;
        if (k <= this.a.jdField_b_of_type_Int - 1) {}
      }
      else
      {
        localView1.setTag("MemberPagerAdapter_" + paramInt);
        paramViewGroup.addView(localView1);
        return localView1;
      }
      MultiMembersUI.MVMembersInfo localMVMembersInfo = (MultiMembersUI.MVMembersInfo)this.a.jdField_a_of_type_JavaUtilArrayList.get(k);
      if (localMVMembersInfo == null) {}
      View localView2;
      do
      {
        int m;
        do
        {
          j += 1;
          break;
          m = this.a.a(i, j);
        } while (m == -1);
        localView2 = localView1.findViewById(m);
      } while (localView2 == null);
      MultiMembersUI.Holder localHolder = this.a.a(localView2);
      localHolder.jdField_d_of_type_Boolean = localMVMembersInfo.f;
      localView2.setTag(localHolder);
      if (this.a.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
        localView2.setOnClickListener(this.a.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      Object localObject2;
      if ((localMVMembersInfo.jdField_a_of_type_JavaLangString == null) || (localMVMembersInfo.jdField_a_of_type_AndroidGraphicsBitmap == null) || (!localMVMembersInfo.jdField_d_of_type_Boolean))
      {
        if (localMVMembersInfo.jdField_b_of_type_Int != 0) {
          break label966;
        }
        localObject1 = String.valueOf(localMVMembersInfo.jdField_a_of_type_Long);
        if (this.a.jdField_a_of_type_Int != 7) {
          break label869;
        }
        localObject2 = this.a.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject1);
        if (localObject2 != null)
        {
          if (!this.a.jdField_a_of_type_Boolean) {
            break label856;
          }
          localMVMembersInfo.jdField_a_of_type_JavaLangString = ((VideoController.GAudioFriends)localObject2).jdField_b_of_type_JavaLangString;
          label417:
          if ((((String)localObject1).equals(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())) && (localMVMembersInfo.jdField_a_of_type_JavaLangString != null)) {
            localMVMembersInfo.jdField_a_of_type_JavaLangString += this.a.getResources().getString(2131695720);
          }
        }
        label481:
        if (localMVMembersInfo.jdField_a_of_type_JavaLangString == null) {
          localMVMembersInfo.jdField_a_of_type_JavaLangString = ((String)localObject1);
        }
        if (localMVMembersInfo.jdField_a_of_type_JavaLangString.compareTo((String)localObject1) == 0) {
          break label906;
        }
        localMVMembersInfo.jdField_d_of_type_Boolean = true;
        label515:
        if (this.a.jdField_a_of_type_Int != 7) {
          break label915;
        }
        localObject2 = this.a.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject1, this.a.jdField_a_of_type_Boolean);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
          localObject1 = BitmapFactory.decodeResource(this.a.getResources(), 2130842395, (BitmapFactory.Options)localObject2);
          ((BitmapFactory.Options)localObject2).inJustDecodeBounds = false;
        }
      }
      try
      {
        localObject2 = BitmapFactory.decodeResource(this.a.getResources(), 2130842395, (BitmapFactory.Options)localObject2);
        localObject1 = localObject2;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        label614:
        label620:
        long l;
        break label614;
      }
      localMVMembersInfo.jdField_d_of_type_Boolean = false;
      if (localObject1 != null) {
        localMVMembersInfo.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject1);
      }
      for (;;)
      {
        if (((this.a.jdField_a_of_type_Int != 1) && (this.a.jdField_a_of_type_Int != 2) && (this.a.jdField_a_of_type_Int != 7)) || (k != 7) || (this.a.jdField_a_of_type_JavaUtilArrayList.size() <= 8)) {
          break label1217;
        }
        localHolder.jdField_b_of_type_Boolean = false;
        localObject1 = new GradientDrawable();
        ((GradientDrawable)localObject1).setShape(1);
        ((GradientDrawable)localObject1).setColor(Color.parseColor("#4C000000"));
        localHolder.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
        localHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView2.findViewById(2131373839));
        localObject1 = new StringBuilder("");
        ((StringBuilder)localObject1).append(this.a.jdField_a_of_type_JavaUtilArrayList.size() - 8 + 1);
        ((StringBuilder)localObject1).append("+");
        localHolder.jdField_b_of_type_AndroidWidgetTextView.setText(((StringBuilder)localObject1).toString());
        localHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
        localHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        localHolder.jdField_a_of_type_AndroidWidgetTextView.setText("");
        localHolder.jdField_c_of_type_Boolean = true;
        localView2.setContentDescription(this.a.getResources().getString(2131693148));
        break;
        label856:
        localMVMembersInfo.jdField_a_of_type_JavaLangString = ((VideoController.GAudioFriends)localObject2).jdField_a_of_type_JavaLangString;
        break label417;
        label869:
        localMVMembersInfo.jdField_a_of_type_JavaLangString = this.a.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject1, String.valueOf(this.a.jdField_a_of_type_Long), this.a.jdField_a_of_type_Int);
        break label481;
        label906:
        localMVMembersInfo.jdField_d_of_type_Boolean = false;
        break label515;
        label915:
        localObject1 = this.a.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject1, String.valueOf(this.a.jdField_a_of_type_Long), this.a.jdField_a_of_type_Int, false, true);
        break label620;
        localMVMembersInfo.jdField_a_of_type_AndroidGraphicsBitmap = null;
        localMVMembersInfo.jdField_d_of_type_Boolean = false;
      }
      label966:
      l = localMVMembersInfo.jdField_a_of_type_Long;
      if (localMVMembersInfo.jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo != null)
      {
        localObject1 = localMVMembersInfo.jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo;
        label988:
        if ((localObject1 == null) || (((AVPhoneUserInfo)localObject1).telInfo.mobile == null)) {
          break label1148;
        }
        localMVMembersInfo.jdField_a_of_type_JavaLangString = ((AVPhoneUserInfo)localObject1).telInfo.mobile;
        localObject2 = this.a.jdField_a_of_type_ComTencentAvVideoController.a(((AVPhoneUserInfo)localObject1).telInfo.mobile);
        if (localObject2 == null) {
          break label1122;
        }
        localMVMembersInfo.jdField_b_of_type_JavaLangString = ContactUtils.a((String)localObject2);
        localMVMembersInfo.jdField_a_of_type_JavaLangString = ((String)localObject2);
      }
      for (;;)
      {
        localMVMembersInfo.jdField_a_of_type_AndroidGraphicsBitmap = ((BitmapDrawable)this.a.getResources().getDrawable(2130842304)).getBitmap();
        localMVMembersInfo.jdField_d_of_type_Boolean = true;
        break;
        localObject1 = this.a.jdField_a_of_type_ComTencentAvVideoController.a(l, this.a.jdField_a_of_type_ComTencentAvVideoController.a().f);
        break label988;
        label1122:
        localMVMembersInfo.jdField_b_of_type_JavaLangString = null;
        localMVMembersInfo.jdField_a_of_type_JavaLangString = PstnUtils.a(((AVPhoneUserInfo)localObject1).telInfo.mobile, 4);
        continue;
        label1148:
        if ((localObject1 != null) && (QLog.isColorLevel())) {
          QLog.d("MemberPagerAdapter", 2, "getView --> can not get Open Id. PhoneInfo = " + ((AVPhoneUserInfo)localObject1).toString());
        }
        localMVMembersInfo.jdField_b_of_type_JavaLangString = null;
        localMVMembersInfo.jdField_a_of_type_JavaLangString = this.a.getResources().getString(2131693149);
      }
      label1217:
      if (this.a.jdField_a_of_type_Int == 7) {
        localHolder.jdField_b_of_type_Int = localMVMembersInfo.jdField_d_of_type_Int;
      }
      switch (localHolder.jdField_b_of_type_Int)
      {
      case 3: 
      default: 
        label1276:
        if (localHolder.jdField_b_of_type_Int != 0) {
          localHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        }
        if (String.valueOf(localMVMembersInfo.jdField_a_of_type_Long).endsWith(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()))
        {
          localHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColor(2131165434));
          label1338:
          localHolder.jdField_b_of_type_Boolean = true;
          localHolder.jdField_a_of_type_Long = localMVMembersInfo.jdField_a_of_type_Long;
          l = localMVMembersInfo.jdField_a_of_type_Long;
          if (localMVMembersInfo.jdField_a_of_type_JavaLangString == null) {
            break label1965;
          }
          localHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localMVMembersInfo.jdField_a_of_type_JavaLangString);
          if ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().F == 7) && (!localHolder.jdField_a_of_type_AndroidWidgetTextView.isShown()) && (!localMVMembersInfo.jdField_a_of_type_JavaLangString.equals(String.valueOf(l)))) {
            localHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          }
          label1436:
          if (localMVMembersInfo.jdField_a_of_type_AndroidGraphicsBitmap == null) {
            break label2048;
          }
          if ((localMVMembersInfo.jdField_b_of_type_Int == 0) || (localMVMembersInfo.jdField_b_of_type_JavaLangString == null)) {
            break label2022;
          }
          localHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          localHolder.jdField_b_of_type_AndroidWidgetTextView.setText(localMVMembersInfo.jdField_b_of_type_JavaLangString);
          localObject1 = ((BitmapDrawable)this.a.getResources().getDrawable(2130842261)).getBitmap();
          localHolder.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject1);
          label1513:
          if (((this.a.jdField_a_of_type_ComTencentAvVideoController.a().F == 1) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().D == 10)) || (this.a.jdField_a_of_type_ComTencentAvVideoController.a().F == 2) || (this.a.jdField_a_of_type_ComTencentAvVideoController.a().F == 7))
          {
            if (!localMVMembersInfo.e) {
              break label2072;
            }
            if (localHolder.e.getVisibility() != 0) {
              localHolder.e.setVisibility(0);
            }
            if (localHolder.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0)
            {
              localHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
              MultiMembersAudioUI.a(this.a, localHolder.jdField_b_of_type_AndroidWidgetImageView, 8);
            }
            localMVMembersInfo.jdField_a_of_type_Boolean = false;
          }
          label1652:
          localHolder.jdField_a_of_type_Boolean = localMVMembersInfo.jdField_a_of_type_Boolean;
          if (!localHolder.jdField_a_of_type_Boolean) {
            break label2096;
          }
          localHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          MultiMembersAudioUI.a(this.a, localHolder.jdField_b_of_type_AndroidWidgetImageView, 0);
          label1692:
          if (localMVMembersInfo.jdField_a_of_type_Int != 2) {
            break label2123;
          }
          localHolder.jdField_a_of_type_Int = 5;
        }
        break;
      }
      for (;;)
      {
        if ((this.a.jdField_b_of_type_Boolean) && (ThemeUtil.isInNightMode(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface)) && (localHolder.jdField_d_of_type_AndroidWidgetImageView != null))
        {
          localObject1 = localHolder.jdField_d_of_type_AndroidWidgetImageView.getDrawable();
          if ((localObject1 != null) && ((localObject1 instanceof BitmapDrawable)))
          {
            localObject1 = UITools.a(((BitmapDrawable)localObject1).getBitmap(), "#4C000000", true);
            localHolder.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject1);
          }
        }
        if ((localHolder.jdField_d_of_type_AndroidWidgetImageView == null) || (((this.a.jdField_a_of_type_ComTencentAvVideoController.a().F != 1) || (this.a.jdField_a_of_type_ComTencentAvVideoController.a().D != 10)) && ((this.a.jdField_a_of_type_Int != 2) || (localHolder.jdField_d_of_type_Boolean)))) {
          break;
        }
        localObject1 = localHolder.jdField_d_of_type_AndroidWidgetImageView.getDrawable();
        if ((localObject1 == null) || (!(localObject1 instanceof BitmapDrawable))) {
          break;
        }
        localObject1 = ImageUtil.a(((BitmapDrawable)localObject1).getBitmap(), true);
        localHolder.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject1);
        break;
        localHolder.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130842081);
        break label1276;
        localHolder.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130842085);
        break label1276;
        localHolder.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130842083);
        break label1276;
        localHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColor(2131167374));
        break label1338;
        label1965:
        if ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().F == 7) && (localHolder.jdField_a_of_type_AndroidWidgetTextView.isShown())) {
          localHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        }
        localHolder.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(localMVMembersInfo.jdField_a_of_type_Long));
        break label1436;
        label2022:
        localHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        localHolder.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(localMVMembersInfo.jdField_a_of_type_AndroidGraphicsBitmap);
        break label1513;
        label2048:
        localHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        localHolder.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130840452);
        break label1513;
        label2072:
        if (localHolder.e.getVisibility() != 0) {
          break label1652;
        }
        localHolder.e.setVisibility(8);
        break label1652;
        label2096:
        localHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        MultiMembersAudioUI.a(this.a, localHolder.jdField_b_of_type_AndroidWidgetImageView, 8);
        break label1692;
        label2123:
        if (localMVMembersInfo.jdField_c_of_type_Boolean) {
          localHolder.jdField_a_of_type_Int = 3;
        } else if (localMVMembersInfo.jdField_a_of_type_Int == 1) {
          localHolder.jdField_a_of_type_Int = 2;
        } else if (localMVMembersInfo.jdField_b_of_type_Boolean) {
          localHolder.jdField_a_of_type_Int = 1;
        } else {
          localHolder.jdField_a_of_type_Int = 0;
        }
      }
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.MultiMembersAudioUI.MemberPagerAdapter
 * JD-Core Version:    0.7.0.1
 */