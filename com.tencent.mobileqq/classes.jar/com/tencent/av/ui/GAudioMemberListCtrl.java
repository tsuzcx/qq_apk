package com.tencent.av.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class GAudioMemberListCtrl
{
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = 0L;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater = null;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new GAudioMemberListCtrl.1(this);
  VideoController jdField_a_of_type_ComTencentAvVideoController = null;
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
  private GAudioMemberListCtrl.GAudioMemberListAdapter jdField_a_of_type_ComTencentAvUiGAudioMemberListCtrl$GAudioMemberListAdapter = null;
  private PinnedDividerListView jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = null;
  WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference = null;
  ArrayList<GAudioMemberListCtrl.GAudioMemberInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new GAudioMemberListCtrl.2(this);
  private boolean jdField_b_of_type_Boolean = false;
  
  @TargetApi(9)
  public GAudioMemberListCtrl(Context paramContext, VideoAppInterface paramVideoAppInterface, PinnedDividerListView paramPinnedDividerListView, long paramLong, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = paramPinnedDividerListView;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("GAudioMemberListCtrl", 2, "MVMembersContolUI-->can not get videoControl");
      }
      return;
    }
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    this.jdField_a_of_type_ComTencentAvUiGAudioMemberListCtrl$GAudioMemberListAdapter = new GAudioMemberListCtrl.GAudioMemberListAdapter(this, null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_ComTencentAvUiGAudioMemberListCtrl$GAudioMemberListAdapter);
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_b_of_type_Boolean = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
  }
  
  private int a(long paramLong)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (((GAudioMemberListCtrl.GAudioMemberInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Long == paramLong) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private void b(ArrayList<VideoController.GAudioFriends> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GAudioMemberListCtrl", 2, "refreshDataSource");
    }
    if (paramArrayList == null) {
      if (QLog.isColorLevel()) {
        QLog.d("GAudioMemberListCtrl", 2, "refreshDataSource-->friends list is null");
      }
    }
    for (;;)
    {
      return;
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      int i = 0;
      while (i < paramArrayList.size())
      {
        VideoController.GAudioFriends localGAudioFriends = (VideoController.GAudioFriends)paramArrayList.get(i);
        GAudioMemberListCtrl.GAudioMemberInfo localGAudioMemberInfo = new GAudioMemberListCtrl.GAudioMemberInfo(this, null);
        localGAudioMemberInfo.jdField_a_of_type_Long = localGAudioFriends.jdField_a_of_type_Long;
        localGAudioMemberInfo.jdField_a_of_type_Boolean = localGAudioFriends.jdField_a_of_type_Boolean;
        localGAudioMemberInfo.jdField_a_of_type_Int = localGAudioFriends.d;
        localGAudioMemberInfo.jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo = localGAudioFriends.jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo;
        localGAudioMemberInfo.c = localGAudioFriends.e;
        localGAudioMemberInfo.d = localGAudioFriends.f;
        localGAudioMemberInfo.e = localGAudioFriends.h;
        this.jdField_a_of_type_JavaUtilArrayList.add(localGAudioMemberInfo);
        i += 1;
      }
    }
  }
  
  public void a()
  {
    boolean bool2 = false;
    int i = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getFirstVisiblePosition();
    if (i < 0) {
      i = 0;
    }
    for (;;)
    {
      int k = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getLastVisiblePosition();
      int j = i;
      for (;;)
      {
        boolean bool1 = bool2;
        if (j < k)
        {
          bool1 = bool2;
          if (j < this.jdField_a_of_type_JavaUtilArrayList.size())
          {
            GAudioMemberListCtrl.GAudioMemberInfo localGAudioMemberInfo = (GAudioMemberListCtrl.GAudioMemberInfo)this.jdField_a_of_type_JavaUtilArrayList.get(j);
            if ((localGAudioMemberInfo == null) || (localGAudioMemberInfo.jdField_b_of_type_Boolean)) {
              break label143;
            }
            bool1 = true;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("GAudioMemberListCtrl", 2, "refreshHeadbitmap-->minIndex=" + i + ",maxIndex=" + k + ",needRefresh=" + bool1);
        }
        if (bool1) {
          this.jdField_a_of_type_ComTencentAvUiGAudioMemberListCtrl$GAudioMemberListAdapter.notifyDataSetChanged();
        }
        return;
        label143:
        j += 1;
      }
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    paramInt2 = a(paramLong);
    if (paramInt2 == -1) {
      if (QLog.isColorLevel()) {
        QLog.e("GAudioMemberListCtrl", 2, "notifyDataSetChanged-->this member not in infoList.uin=" + paramLong + ",isMicOff=" + paramBoolean);
      }
    }
    GAudioMemberListCtrl.GAudioMemberInfo localGAudioMemberInfo;
    Object localObject;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                int i;
                do
                {
                  return;
                  localGAudioMemberInfo = (GAudioMemberListCtrl.GAudioMemberInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt2);
                  localGAudioMemberInfo.c = paramBoolean;
                  localGAudioMemberInfo.jdField_a_of_type_Int = paramInt1;
                  paramInt1 = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getFirstVisiblePosition();
                  i = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getLastVisiblePosition();
                } while ((paramInt2 < paramInt1) || (paramInt2 > i));
                paramInt1 = paramInt2 + 1 - paramInt1;
              } while (paramInt1 > this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getChildCount());
              localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getChildAt(paramInt1);
              if (localObject != null) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.e("GAudioMemberListCtrl", 2, "notifyDataSetChanged--> view == null , index = " + paramInt2);
            return;
            if (((View)localObject).getTag() != null) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.e("GAudioMemberListCtrl", 2, "notifyDataSetChanged-->can not get tag from uin-->index=" + paramInt2 + ",uin=" + paramLong + ",isMicOff=" + paramBoolean);
          return;
          localObject = (GAudioMemberListCtrl.ViewHolder)((View)localObject).getTag();
        } while (localObject == null);
        if (localGAudioMemberInfo.c)
        {
          ((GAudioMemberListCtrl.ViewHolder)localObject).c.setVisibility(8);
          if (((GAudioMemberListCtrl.ViewHolder)localObject).jdField_a_of_type_AndroidViewView != null) {
            ((GAudioMemberListCtrl.ViewHolder)localObject).jdField_a_of_type_AndroidViewView.setVisibility(8);
          }
        }
        if (!localGAudioMemberInfo.c) {
          break;
        }
      } while ((((GAudioMemberListCtrl.ViewHolder)localObject).jdField_a_of_type_Int != -1) && (((GAudioMemberListCtrl.ViewHolder)localObject).jdField_a_of_type_Int != 0));
      a(((GAudioMemberListCtrl.ViewHolder)localObject).jdField_b_of_type_AndroidWidgetImageView, localGAudioMemberInfo.c);
      ((GAudioMemberListCtrl.ViewHolder)localObject).jdField_a_of_type_Int = 1;
      return;
    } while ((((GAudioMemberListCtrl.ViewHolder)localObject).jdField_a_of_type_Int != -1) && (((GAudioMemberListCtrl.ViewHolder)localObject).jdField_a_of_type_Int != 1));
    a(((GAudioMemberListCtrl.ViewHolder)localObject).jdField_b_of_type_AndroidWidgetImageView, localGAudioMemberInfo.c);
    ((GAudioMemberListCtrl.ViewHolder)localObject).jdField_a_of_type_Int = 0;
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    int i = a(paramLong);
    if (i == -1) {
      if (QLog.isColorLevel()) {
        QLog.e("GAudioMemberListCtrl", 2, "notifyDataSetChanged-->this member not in infoList.uin=" + paramLong + ",bSpeak=" + paramBoolean);
      }
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              int j;
              do
              {
                do
                {
                  return;
                  localObject = (GAudioMemberListCtrl.GAudioMemberInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i);
                  ((GAudioMemberListCtrl.GAudioMemberInfo)localObject).jdField_a_of_type_Boolean = paramBoolean;
                  if (((GAudioMemberListCtrl.GAudioMemberInfo)localObject).c)
                  {
                    ((GAudioMemberListCtrl.GAudioMemberInfo)localObject).jdField_a_of_type_Boolean = false;
                    paramBoolean = false;
                  }
                  j = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getFirstVisiblePosition();
                  int k = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getLastVisiblePosition();
                  if ((i >= j) && (i <= k)) {
                    break;
                  }
                } while (!QLog.isColorLevel());
                QLog.e("GAudioMemberListCtrl", 2, "notifyDataSetChanged--> view is invisible uin =" + paramLong + " , index = " + i);
                return;
                j = i + 1 - j;
              } while (j > this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getChildCount());
              localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getChildAt(j);
              if (localObject != null) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.e("GAudioMemberListCtrl", 2, "notifyDataSetChanged--> view == null , index = " + i);
            return;
            if (((View)localObject).getTag() != null) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.e("GAudioMemberListCtrl", 2, "notifyDataSetChanged-->can not get tag from uin-->index=" + i + ",uin=" + paramLong + ",isSpeak=" + paramBoolean);
          return;
          localObject = (GAudioMemberListCtrl.ViewHolder)((View)localObject).getTag();
        } while (localObject == null);
        if ((!paramBoolean) || (!((GAudioMemberListCtrl.ViewHolder)localObject).jdField_b_of_type_Boolean)) {
          break;
        }
        ((GAudioMemberListCtrl.ViewHolder)localObject).c.setVisibility(0);
      } while (((GAudioMemberListCtrl.ViewHolder)localObject).jdField_a_of_type_AndroidViewView == null);
      ((GAudioMemberListCtrl.ViewHolder)localObject).jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
      ((GAudioMemberListCtrl.ViewHolder)localObject).c.setVisibility(8);
    } while (((GAudioMemberListCtrl.ViewHolder)localObject).jdField_a_of_type_AndroidViewView == null);
    ((GAudioMemberListCtrl.ViewHolder)localObject).jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  void a(ImageView paramImageView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_b_of_type_Boolean) {}
      for (i = 2130842143;; i = 2130842142)
      {
        paramImageView.setImageResource(i);
        paramImageView.setContentDescription(HardCodeUtil.a(2131705177));
        return;
      }
    }
    if (this.jdField_b_of_type_Boolean) {}
    for (int i = 2130842145;; i = 2130842144)
    {
      paramImageView.setImageResource(i);
      paramImageView.setContentDescription(HardCodeUtil.a(2131705179));
      return;
    }
  }
  
  public void a(ArrayList<VideoController.GAudioFriends> paramArrayList)
  {
    if (paramArrayList != null)
    {
      b(paramArrayList);
      this.jdField_a_of_type_ComTencentAvUiGAudioMemberListCtrl$GAudioMemberListAdapter.notifyDataSetChanged();
    }
  }
  
  public void b()
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getChildCount();
    int i = 0;
    while (i < j)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getChildAt(i).setTag(null);
      i += 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = null;
    this.jdField_a_of_type_ComTencentAvUiGAudioMemberListCtrl$GAudioMemberListAdapter = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_AndroidViewLayoutInflater = null;
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      this.jdField_a_of_type_JavaLangRefWeakReference.clear();
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
  }
  
  public void b(long paramLong, boolean paramBoolean)
  {
    int i = a(paramLong);
    if (i == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("GAudioMemberListCtrl", 2, "onSetMicBySelf uin=" + paramLong + ",isMicOffBySelf=" + paramBoolean);
      }
      return;
    }
    ((GAudioMemberListCtrl.GAudioMemberInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).d = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.GAudioMemberListCtrl
 * JD-Core Version:    0.7.0.1
 */