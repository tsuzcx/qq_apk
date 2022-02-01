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
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo.TelInfo;
import com.tencent.av.utils.PstnUtils;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
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
    ArrayList localArrayList = this.a.jdField_a_of_type_JavaUtilArrayList;
    int i = 0;
    if (localArrayList == null) {
      return 0;
    }
    int j = this.a.jdField_b_of_type_Int / 8;
    if (this.a.jdField_b_of_type_Int % 8 != 0) {
      i = 1;
    }
    return j + i;
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  @TargetApi(11)
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    QLog.isColorLevel();
    if ((this.a.jdField_a_of_type_JavaUtilArrayList != null) && (this.a.jdField_b_of_type_Int != 0))
    {
      View localView1 = View.inflate(paramViewGroup.getContext(), 2131559730, null);
      if (QQAudioHelper.a(0) == 1)
      {
        localView1.setBackgroundColor(2130706687);
        localView1.addOnLayoutChangeListener(new MultiMembersAudioUI.MemberPagerAdapter.1(this));
        if (paramViewGroup.getTag(2131368560) == null)
        {
          paramViewGroup.setBackgroundColor(-553615360);
          localObject1 = new MultiMembersAudioUI.MemberPagerAdapter.2(this);
          paramViewGroup.addOnLayoutChangeListener((View.OnLayoutChangeListener)localObject1);
          paramViewGroup.setTag(2131368560, localObject1);
        }
      }
      int i;
      if (paramInt == getCount() - 1) {
        i = this.a.jdField_b_of_type_Int - paramInt * 8;
      } else {
        i = 8;
      }
      this.a.a(localView1, i);
      int j = 0;
      while (j < i)
      {
        int k = paramInt * 8 + j;
        if (k > this.a.jdField_b_of_type_Int - 1) {
          break;
        }
        MultiMembersUI.MVMembersInfo localMVMembersInfo = (MultiMembersUI.MVMembersInfo)this.a.jdField_a_of_type_JavaUtilArrayList.get(k);
        if (localMVMembersInfo != null)
        {
          MultiMembersUI.Holder localHolder;
          for (;;)
          {
            int m = this.a.a(i, j);
            View localView2;
            Object localObject2;
            if (m != -1)
            {
              localView2 = localView1.findViewById(m);
              if (localView2 != null)
              {
                localHolder = this.a.a(localView2);
                localHolder.jdField_d_of_type_Boolean = localMVMembersInfo.f;
                localView2.setTag(localHolder);
                if (this.a.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
                  localView2.setOnClickListener(this.a.jdField_a_of_type_AndroidViewView$OnClickListener);
                }
                if ((localMVMembersInfo.jdField_a_of_type_JavaLangString != null) && (localMVMembersInfo.jdField_a_of_type_AndroidGraphicsBitmap != null) && (localMVMembersInfo.jdField_d_of_type_Boolean)) {
                  break label958;
                }
                if (localMVMembersInfo.jdField_b_of_type_Int == 0)
                {
                  localObject1 = String.valueOf(localMVMembersInfo.jdField_a_of_type_Long);
                  if (this.a.jdField_a_of_type_Int == 7)
                  {
                    localObject2 = this.a.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject1);
                    if (localObject2 != null)
                    {
                      if (this.a.jdField_a_of_type_Boolean) {
                        localMVMembersInfo.jdField_a_of_type_JavaLangString = ((VideoController.GAudioFriends)localObject2).jdField_b_of_type_JavaLangString;
                      } else {
                        localMVMembersInfo.jdField_a_of_type_JavaLangString = ((VideoController.GAudioFriends)localObject2).jdField_a_of_type_JavaLangString;
                      }
                      if ((((String)localObject1).equals(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())) && (localMVMembersInfo.jdField_a_of_type_JavaLangString != null))
                      {
                        localObject2 = new StringBuilder();
                        ((StringBuilder)localObject2).append(localMVMembersInfo.jdField_a_of_type_JavaLangString);
                        ((StringBuilder)localObject2).append(this.a.getResources().getString(2131695734));
                        localMVMembersInfo.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject2).toString();
                      }
                    }
                  }
                  else
                  {
                    localMVMembersInfo.jdField_a_of_type_JavaLangString = this.a.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject1, String.valueOf(this.a.jdField_a_of_type_Long), this.a.jdField_a_of_type_Int);
                  }
                  if (localMVMembersInfo.jdField_a_of_type_JavaLangString == null) {
                    localMVMembersInfo.jdField_a_of_type_JavaLangString = ((String)localObject1);
                  }
                  if (localMVMembersInfo.jdField_a_of_type_JavaLangString.compareTo((String)localObject1) != 0) {
                    localMVMembersInfo.jdField_d_of_type_Boolean = true;
                  } else {
                    localMVMembersInfo.jdField_d_of_type_Boolean = false;
                  }
                  if (this.a.jdField_a_of_type_Int == 7)
                  {
                    localObject2 = new BitmapFactory.Options();
                    ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
                    localObject1 = BitmapFactory.decodeResource(this.a.getResources(), 2130842293, (BitmapFactory.Options)localObject2);
                    ((BitmapFactory.Options)localObject2).inJustDecodeBounds = false;
                  }
                }
              }
            }
            try
            {
              localObject2 = BitmapFactory.decodeResource(this.a.getResources(), 2130842293, (BitmapFactory.Options)localObject2);
              localObject1 = localObject2;
            }
            catch (OutOfMemoryError localOutOfMemoryError)
            {
              label628:
              long l;
              break label628;
            }
            localMVMembersInfo.jdField_d_of_type_Boolean = false;
            break label670;
            localObject1 = this.a.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject1, String.valueOf(this.a.jdField_a_of_type_Long), this.a.jdField_a_of_type_Int, false, true);
            label670:
            if (localObject1 != null)
            {
              localMVMembersInfo.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject1);
            }
            else
            {
              localMVMembersInfo.jdField_a_of_type_AndroidGraphicsBitmap = null;
              localMVMembersInfo.jdField_d_of_type_Boolean = false;
              break label958;
              l = localMVMembersInfo.jdField_a_of_type_Long;
              if (localMVMembersInfo.jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo != null) {
                localObject1 = localMVMembersInfo.jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo;
              } else {
                localObject1 = this.a.jdField_a_of_type_ComTencentAvVideoController.a(l, this.a.jdField_a_of_type_ComTencentAvVideoController.a().f);
              }
              if ((localObject1 != null) && (((AVPhoneUserInfo)localObject1).telInfo.mobile != null))
              {
                localMVMembersInfo.jdField_a_of_type_JavaLangString = ((AVPhoneUserInfo)localObject1).telInfo.mobile;
                localObject2 = this.a.jdField_a_of_type_ComTencentAvVideoController.a(((AVPhoneUserInfo)localObject1).telInfo.mobile);
                if (localObject2 != null)
                {
                  localMVMembersInfo.jdField_b_of_type_JavaLangString = ContactUtils.a((String)localObject2);
                  localMVMembersInfo.jdField_a_of_type_JavaLangString = ((String)localObject2);
                }
                else
                {
                  localMVMembersInfo.jdField_b_of_type_JavaLangString = null;
                  localMVMembersInfo.jdField_a_of_type_JavaLangString = PstnUtils.a(((AVPhoneUserInfo)localObject1).telInfo.mobile, 4);
                }
              }
              else
              {
                if ((localObject1 != null) && (QLog.isColorLevel()))
                {
                  localObject2 = new StringBuilder();
                  ((StringBuilder)localObject2).append("getView --> can not get Open Id. PhoneInfo = ");
                  ((StringBuilder)localObject2).append(((AVPhoneUserInfo)localObject1).toString());
                  QLog.d("MemberPagerAdapter", 2, ((StringBuilder)localObject2).toString());
                }
                localMVMembersInfo.jdField_b_of_type_JavaLangString = null;
                localMVMembersInfo.jdField_a_of_type_JavaLangString = this.a.getResources().getString(2131693109);
              }
              localMVMembersInfo.jdField_a_of_type_AndroidGraphicsBitmap = ((BitmapDrawable)this.a.getResources().getDrawable(2130842202)).getBitmap();
              localMVMembersInfo.jdField_d_of_type_Boolean = true;
            }
            label958:
            if ((this.a.jdField_a_of_type_Int != 1) && (this.a.jdField_a_of_type_Int != 2)) {
              if (this.a.jdField_a_of_type_Int != 7) {
                break;
              }
            }
            if ((k != 7) || (this.a.jdField_a_of_type_JavaUtilArrayList.size() <= 8)) {
              break;
            }
            localHolder.jdField_b_of_type_Boolean = false;
            localObject1 = new GradientDrawable();
            ((GradientDrawable)localObject1).setShape(1);
            ((GradientDrawable)localObject1).setColor(Color.parseColor("#4C000000"));
            localHolder.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
            localHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView2.findViewById(2131373411));
            localObject1 = new StringBuilder("");
            ((StringBuilder)localObject1).append(this.a.jdField_a_of_type_JavaUtilArrayList.size() - 8 + 1);
            ((StringBuilder)localObject1).append("+");
            localHolder.jdField_b_of_type_AndroidWidgetTextView.setText(((StringBuilder)localObject1).toString());
            localHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
            localHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
            localHolder.jdField_a_of_type_AndroidWidgetTextView.setText("");
            localHolder.jdField_c_of_type_Boolean = true;
            localView2.setContentDescription(this.a.getResources().getString(2131693108));
          }
          if (this.a.jdField_a_of_type_Int == 7)
          {
            localHolder.jdField_b_of_type_Int = localMVMembersInfo.jdField_d_of_type_Int;
            k = localHolder.jdField_b_of_type_Int;
            if (k != 1)
            {
              if (k != 2)
              {
                if (k == 4) {
                  localHolder.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841980);
                }
              }
              else {
                localHolder.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841978);
              }
            }
            else {
              localHolder.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841982);
            }
            if (localHolder.jdField_b_of_type_Int != 0) {
              localHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
            }
            if (String.valueOf(localMVMembersInfo.jdField_a_of_type_Long).endsWith(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())) {
              localHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColor(2131165410));
            } else {
              localHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColor(2131167394));
            }
          }
          localHolder.jdField_b_of_type_Boolean = true;
          localHolder.jdField_a_of_type_Long = localMVMembersInfo.jdField_a_of_type_Long;
          l = localMVMembersInfo.jdField_a_of_type_Long;
          if (localMVMembersInfo.jdField_a_of_type_JavaLangString != null)
          {
            localHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localMVMembersInfo.jdField_a_of_type_JavaLangString);
            if ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().E == 7) && (!localHolder.jdField_a_of_type_AndroidWidgetTextView.isShown()) && (!localMVMembersInfo.jdField_a_of_type_JavaLangString.equals(String.valueOf(l)))) {
              localHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
            }
          }
          else
          {
            if ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().E == 7) && (localHolder.jdField_a_of_type_AndroidWidgetTextView.isShown())) {
              localHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
            }
            localHolder.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(localMVMembersInfo.jdField_a_of_type_Long));
          }
          if (localMVMembersInfo.jdField_a_of_type_AndroidGraphicsBitmap != null)
          {
            if ((localMVMembersInfo.jdField_b_of_type_Int != 0) && (localMVMembersInfo.jdField_b_of_type_JavaLangString != null))
            {
              localHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
              localHolder.jdField_b_of_type_AndroidWidgetTextView.setText(localMVMembersInfo.jdField_b_of_type_JavaLangString);
              localObject1 = ((BitmapDrawable)this.a.getResources().getDrawable(2130842159)).getBitmap();
              localHolder.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject1);
            }
            else
            {
              localHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
              localHolder.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(localMVMembersInfo.jdField_a_of_type_AndroidGraphicsBitmap);
            }
          }
          else
          {
            localHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
            localHolder.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130840321);
          }
          if (((this.a.jdField_a_of_type_ComTencentAvVideoController.a().E == 1) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().j == 10)) || (this.a.jdField_a_of_type_ComTencentAvVideoController.a().E == 2) || (this.a.jdField_a_of_type_ComTencentAvVideoController.a().E == 7)) {
            if (localMVMembersInfo.e)
            {
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
            else if (localHolder.e.getVisibility() == 0)
            {
              localHolder.e.setVisibility(8);
            }
          }
          localHolder.jdField_a_of_type_Boolean = localMVMembersInfo.jdField_a_of_type_Boolean;
          if (localHolder.jdField_a_of_type_Boolean)
          {
            localHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            MultiMembersAudioUI.a(this.a, localHolder.jdField_b_of_type_AndroidWidgetImageView, 0);
          }
          else
          {
            localHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
            MultiMembersAudioUI.a(this.a, localHolder.jdField_b_of_type_AndroidWidgetImageView, 8);
          }
          if (localMVMembersInfo.jdField_a_of_type_Int == 2) {
            localHolder.jdField_a_of_type_Int = 5;
          }
          for (;;)
          {
            break;
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
          if ((this.a.jdField_b_of_type_Boolean) && (ThemeUtil.isInNightMode(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface)) && (localHolder.jdField_d_of_type_AndroidWidgetImageView != null))
          {
            localObject1 = localHolder.jdField_d_of_type_AndroidWidgetImageView.getDrawable();
            if ((localObject1 != null) && ((localObject1 instanceof BitmapDrawable)))
            {
              localObject1 = UITools.a(((BitmapDrawable)localObject1).getBitmap(), "#4C000000", true);
              localHolder.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject1);
            }
          }
          if ((localHolder.jdField_d_of_type_AndroidWidgetImageView != null) && (((this.a.jdField_a_of_type_ComTencentAvVideoController.a().E == 1) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().j == 10)) || ((this.a.jdField_a_of_type_Int == 2) && (!localHolder.jdField_d_of_type_Boolean))))
          {
            localObject1 = localHolder.jdField_d_of_type_AndroidWidgetImageView.getDrawable();
            if ((localObject1 != null) && ((localObject1 instanceof BitmapDrawable)))
            {
              localObject1 = ImageUtil.a(((BitmapDrawable)localObject1).getBitmap(), true);
              localHolder.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject1);
            }
          }
        }
        j += 1;
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("MemberPagerAdapter_");
      ((StringBuilder)localObject1).append(paramInt);
      localView1.setTag(((StringBuilder)localObject1).toString());
      paramViewGroup.addView(localView1);
      return localView1;
    }
    QLog.isColorLevel();
    return null;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiMembersAudioUI.MemberPagerAdapter
 * JD-Core Version:    0.7.0.1
 */