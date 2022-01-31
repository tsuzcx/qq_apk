package com.tencent.av.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import jue;
import juf;
import jug;
import juh;

public class GAudioMemberListCtrl
{
  public int a;
  public long a;
  public Drawable a;
  public LayoutInflater a;
  public View.OnClickListener a;
  public VideoController a;
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private PinnedDividerListView jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
  public WeakReference a;
  public ArrayList a;
  private jug jdField_a_of_type_Jug;
  
  @TargetApi(9)
  public GAudioMemberListCtrl(Context paramContext, VideoAppInterface paramVideoAppInterface, PinnedDividerListView paramPinnedDividerListView, long paramLong, int paramInt)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_AndroidViewLayoutInflater = null;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new jue(this);
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
    this.jdField_a_of_type_Jug = new jug(this, null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_Jug);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130840249);
  }
  
  private int a(long paramLong)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (((juf)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Long == paramLong) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private void b(ArrayList paramArrayList)
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
        juf localjuf = new juf(this, null);
        localjuf.jdField_a_of_type_Long = localGAudioFriends.jdField_a_of_type_Long;
        localjuf.jdField_a_of_type_Boolean = localGAudioFriends.jdField_a_of_type_Boolean;
        localjuf.jdField_a_of_type_Int = localGAudioFriends.c;
        localjuf.jdField_b_of_type_Int = localGAudioFriends.d;
        localjuf.jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo = localGAudioFriends.jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo;
        localjuf.c = localGAudioFriends.e;
        localjuf.d = localGAudioFriends.f;
        this.jdField_a_of_type_JavaUtilArrayList.add(localjuf);
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
          juf localjuf = (juf)this.jdField_a_of_type_JavaUtilArrayList.get(j);
          if ((localjuf != null) && (!localjuf.jdField_b_of_type_Boolean)) {
            bool1 = true;
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("GAudioMemberListCtrl", 2, "refreshHeadbitmap-->minIndex=" + i + ",maxIndex=" + k + ",needRefresh=" + bool1);
          }
          if (bool1) {
            this.jdField_a_of_type_Jug.notifyDataSetChanged();
          }
          return;
        }
        j += 1;
      }
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i = a(paramLong);
    if (i == -1) {
      if (QLog.isColorLevel()) {
        QLog.e("GAudioMemberListCtrl", 2, "notifyDataSetChanged-->this member not in infoList.uin=" + paramLong + ",isMicOff=" + paramBoolean);
      }
    }
    juf localjuf;
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
                do
                {
                  return;
                  localjuf = (juf)this.jdField_a_of_type_JavaUtilArrayList.get(i);
                  localjuf.c = paramBoolean;
                  localjuf.jdField_a_of_type_Int = paramInt1;
                  localjuf.jdField_b_of_type_Int = paramInt2;
                  paramInt1 = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getFirstVisiblePosition();
                  paramInt2 = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getLastVisiblePosition();
                } while ((i < paramInt1) || (i > paramInt2));
                paramInt1 = i + 1 - paramInt1;
              } while (paramInt1 > this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getChildCount());
              localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getChildAt(paramInt1);
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
          QLog.e("GAudioMemberListCtrl", 2, "notifyDataSetChanged-->can not get tag from uin-->index=" + i + ",uin=" + paramLong + ",isMicOff=" + paramBoolean);
          return;
          localObject = (juh)((View)localObject).getTag();
        } while (localObject == null);
        if (localjuf.c) {
          ((juh)localObject).jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        }
        if (!localjuf.c) {
          break;
        }
      } while ((((juh)localObject).jdField_a_of_type_Int != -1) && (((juh)localObject).jdField_a_of_type_Int != 0));
      a(((juh)localObject).jdField_b_of_type_AndroidWidgetImageView, localjuf.c);
      ((juh)localObject).jdField_a_of_type_Int = 1;
      return;
    } while ((((juh)localObject).jdField_a_of_type_Int != -1) && (((juh)localObject).jdField_a_of_type_Int != 1));
    a(((juh)localObject).jdField_b_of_type_AndroidWidgetImageView, localjuf.c);
    ((juh)localObject).jdField_a_of_type_Int = 0;
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
          int j;
          do
          {
            do
            {
              return;
              localObject = (juf)this.jdField_a_of_type_JavaUtilArrayList.get(i);
              ((juf)localObject).jdField_a_of_type_Boolean = paramBoolean;
              if (((juf)localObject).c)
              {
                ((juf)localObject).jdField_a_of_type_Boolean = false;
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
      localObject = (juh)((View)localObject).getTag();
    } while (localObject == null);
    if ((paramBoolean) && (((juh)localObject).jdField_b_of_type_Boolean))
    {
      ((juh)localObject).jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null);
      return;
    }
    ((juh)localObject).jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
  }
  
  public void a(ImageView paramImageView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramImageView.setImageResource(2130840115);
      paramImageView.setContentDescription("取消静音");
      return;
    }
    paramImageView.setImageResource(2130840116);
    paramImageView.setContentDescription("静音");
  }
  
  public void a(ArrayList paramArrayList)
  {
    if (paramArrayList != null)
    {
      b(paramArrayList);
      this.jdField_a_of_type_Jug.notifyDataSetChanged();
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
    this.jdField_a_of_type_Jug = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_AndroidViewLayoutInflater = null;
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    this.jdField_a_of_type_JavaUtilArrayList = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      this.jdField_a_of_type_JavaLangRefWeakReference.clear();
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
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
    ((juf)this.jdField_a_of_type_JavaUtilArrayList.get(i)).d = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.GAudioMemberListCtrl
 * JD-Core Version:    0.7.0.1
 */