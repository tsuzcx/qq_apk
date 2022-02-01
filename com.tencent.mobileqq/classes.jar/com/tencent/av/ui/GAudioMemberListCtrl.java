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
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
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
    if (paramArrayList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GAudioMemberListCtrl", 2, "refreshDataSource-->friends list is null");
      }
      return;
    }
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
  
  public void a()
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getFirstVisiblePosition();
    boolean bool2 = false;
    int i = j;
    if (j < 0) {
      i = 0;
    }
    int k = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getLastVisiblePosition();
    j = i;
    boolean bool1;
    Object localObject;
    for (;;)
    {
      bool1 = bool2;
      if (j >= k) {
        break;
      }
      bool1 = bool2;
      if (j >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
        break;
      }
      localObject = (GAudioMemberListCtrl.GAudioMemberInfo)this.jdField_a_of_type_JavaUtilArrayList.get(j);
      if ((localObject != null) && (!((GAudioMemberListCtrl.GAudioMemberInfo)localObject).jdField_b_of_type_Boolean))
      {
        bool1 = true;
        break;
      }
      j += 1;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("refreshHeadbitmap-->minIndex=");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(",maxIndex=");
      ((StringBuilder)localObject).append(k);
      ((StringBuilder)localObject).append(",needRefresh=");
      ((StringBuilder)localObject).append(bool1);
      QLog.d("GAudioMemberListCtrl", 2, ((StringBuilder)localObject).toString());
    }
    if (bool1) {
      this.jdField_a_of_type_ComTencentAvUiGAudioMemberListCtrl$GAudioMemberListAdapter.notifyDataSetChanged();
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    paramInt2 = a(paramLong);
    if (paramInt2 == -1)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("notifyDataSetChanged-->this member not in infoList.uin=");
        ((StringBuilder)localObject1).append(paramLong);
        ((StringBuilder)localObject1).append(",isMicOff=");
        ((StringBuilder)localObject1).append(paramBoolean);
        QLog.e("GAudioMemberListCtrl", 2, ((StringBuilder)localObject1).toString());
      }
      return;
    }
    Object localObject1 = (GAudioMemberListCtrl.GAudioMemberInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt2);
    ((GAudioMemberListCtrl.GAudioMemberInfo)localObject1).c = paramBoolean;
    ((GAudioMemberListCtrl.GAudioMemberInfo)localObject1).jdField_a_of_type_Int = paramInt1;
    paramInt1 = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getFirstVisiblePosition();
    int i = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getLastVisiblePosition();
    if (paramInt2 >= paramInt1)
    {
      if (paramInt2 > i) {
        return;
      }
      paramInt1 = paramInt2 + 1 - paramInt1;
      if (paramInt1 > this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getChildCount()) {
        return;
      }
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getChildAt(paramInt1);
      if (localObject2 == null)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("notifyDataSetChanged--> view == null , index = ");
          ((StringBuilder)localObject1).append(paramInt2);
          QLog.e("GAudioMemberListCtrl", 2, ((StringBuilder)localObject1).toString());
        }
        return;
      }
      if (((View)localObject2).getTag() == null)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("notifyDataSetChanged-->can not get tag from uin-->index=");
          ((StringBuilder)localObject1).append(paramInt2);
          ((StringBuilder)localObject1).append(",uin=");
          ((StringBuilder)localObject1).append(paramLong);
          ((StringBuilder)localObject1).append(",isMicOff=");
          ((StringBuilder)localObject1).append(paramBoolean);
          QLog.e("GAudioMemberListCtrl", 2, ((StringBuilder)localObject1).toString());
        }
        return;
      }
      localObject2 = (GAudioMemberListCtrl.ViewHolder)((View)localObject2).getTag();
      if (localObject2 == null) {
        return;
      }
      if (((GAudioMemberListCtrl.GAudioMemberInfo)localObject1).c)
      {
        ((GAudioMemberListCtrl.ViewHolder)localObject2).c.setVisibility(8);
        if (((GAudioMemberListCtrl.ViewHolder)localObject2).jdField_a_of_type_AndroidViewView != null) {
          ((GAudioMemberListCtrl.ViewHolder)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
        }
      }
      if (((GAudioMemberListCtrl.GAudioMemberInfo)localObject1).c)
      {
        if ((((GAudioMemberListCtrl.ViewHolder)localObject2).jdField_a_of_type_Int == -1) || (((GAudioMemberListCtrl.ViewHolder)localObject2).jdField_a_of_type_Int == 0))
        {
          a(((GAudioMemberListCtrl.ViewHolder)localObject2).jdField_b_of_type_AndroidWidgetImageView, ((GAudioMemberListCtrl.GAudioMemberInfo)localObject1).c);
          ((GAudioMemberListCtrl.ViewHolder)localObject2).jdField_a_of_type_Int = 1;
        }
      }
      else if ((((GAudioMemberListCtrl.ViewHolder)localObject2).jdField_a_of_type_Int == -1) || (((GAudioMemberListCtrl.ViewHolder)localObject2).jdField_a_of_type_Int == 1))
      {
        a(((GAudioMemberListCtrl.ViewHolder)localObject2).jdField_b_of_type_AndroidWidgetImageView, ((GAudioMemberListCtrl.GAudioMemberInfo)localObject1).c);
        ((GAudioMemberListCtrl.ViewHolder)localObject2).jdField_a_of_type_Int = 0;
      }
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    int i = a(paramLong);
    if (i == -1)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("notifyDataSetChanged-->this member not in infoList.uin=");
        ((StringBuilder)localObject).append(paramLong);
        ((StringBuilder)localObject).append(",bSpeak=");
        ((StringBuilder)localObject).append(paramBoolean);
        QLog.e("GAudioMemberListCtrl", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    Object localObject = (GAudioMemberListCtrl.GAudioMemberInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i);
    ((GAudioMemberListCtrl.GAudioMemberInfo)localObject).jdField_a_of_type_Boolean = paramBoolean;
    if (((GAudioMemberListCtrl.GAudioMemberInfo)localObject).c)
    {
      ((GAudioMemberListCtrl.GAudioMemberInfo)localObject).jdField_a_of_type_Boolean = false;
      paramBoolean = false;
    }
    int j = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getFirstVisiblePosition();
    int k = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getLastVisiblePosition();
    if ((i >= j) && (i <= k))
    {
      j = i + 1 - j;
      if (j > this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getChildCount()) {
        return;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getChildAt(j);
      if (localObject == null)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("notifyDataSetChanged--> view == null , index = ");
          ((StringBuilder)localObject).append(i);
          QLog.e("GAudioMemberListCtrl", 2, ((StringBuilder)localObject).toString());
        }
        return;
      }
      if (((View)localObject).getTag() == null)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("notifyDataSetChanged-->can not get tag from uin-->index=");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(",uin=");
          ((StringBuilder)localObject).append(paramLong);
          ((StringBuilder)localObject).append(",isSpeak=");
          ((StringBuilder)localObject).append(paramBoolean);
          QLog.e("GAudioMemberListCtrl", 2, ((StringBuilder)localObject).toString());
        }
        return;
      }
      localObject = (GAudioMemberListCtrl.ViewHolder)((View)localObject).getTag();
      if (localObject == null) {
        return;
      }
      if ((paramBoolean) && (((GAudioMemberListCtrl.ViewHolder)localObject).jdField_b_of_type_Boolean))
      {
        ((GAudioMemberListCtrl.ViewHolder)localObject).c.setVisibility(0);
        if (((GAudioMemberListCtrl.ViewHolder)localObject).jdField_a_of_type_AndroidViewView != null) {
          ((GAudioMemberListCtrl.ViewHolder)localObject).jdField_a_of_type_AndroidViewView.setVisibility(0);
        }
      }
      else
      {
        ((GAudioMemberListCtrl.ViewHolder)localObject).c.setVisibility(8);
        if (((GAudioMemberListCtrl.ViewHolder)localObject).jdField_a_of_type_AndroidViewView != null) {
          ((GAudioMemberListCtrl.ViewHolder)localObject).jdField_a_of_type_AndroidViewView.setVisibility(8);
        }
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("notifyDataSetChanged--> view is invisible uin =");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(" , index = ");
      ((StringBuilder)localObject).append(i);
      QLog.e("GAudioMemberListCtrl", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  void a(ImageView paramImageView, boolean paramBoolean)
  {
    int i;
    if (paramBoolean)
    {
      if (this.jdField_b_of_type_Boolean) {
        i = 2130842041;
      } else {
        i = 2130842040;
      }
      paramImageView.setImageResource(i);
      paramImageView.setContentDescription(HardCodeUtil.a(2131705254));
      return;
    }
    if (this.jdField_b_of_type_Boolean) {
      i = 2130842043;
    } else {
      i = 2130842042;
    }
    paramImageView.setImageResource(i);
    paramImageView.setContentDescription(HardCodeUtil.a(2131705256));
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
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if (localObject != null) {
      ((ArrayList)localObject).clear();
    }
    localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject != null) {
      ((WeakReference)localObject).clear();
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
  }
  
  public void b(long paramLong, boolean paramBoolean)
  {
    int i = a(paramLong);
    if (i == -1)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onSetMicBySelf uin=");
        localStringBuilder.append(paramLong);
        localStringBuilder.append(",isMicOffBySelf=");
        localStringBuilder.append(paramBoolean);
        QLog.e("GAudioMemberListCtrl", 2, localStringBuilder.toString());
      }
      return;
    }
    ((GAudioMemberListCtrl.GAudioMemberInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).d = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.GAudioMemberListCtrl
 * JD-Core Version:    0.7.0.1
 */