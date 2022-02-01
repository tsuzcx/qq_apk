package com.tencent.mobileqq.activity.chathistory;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatHistoryEmotionView;
import com.tencent.mobileqq.activity.ChatHistoryEmotionView.OperateCallBack;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryMsgRevokeMgr;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryMsgRevokeMgr.MsgRevokeListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.emotionintegrate.EmotionPreviewData;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TroopAIOEmotionFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener, ChatHistoryEmotionView.OperateCallBack, AIOGalleryMsgRevokeMgr.MsgRevokeListener
{
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private ChatHistoryEmotionView jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView;
  private SeparateForward jdField_a_of_type_ComTencentMobileqqActivityChathistorySeparateForward;
  private List<EmotionPreviewData> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean = false;
  private ImageView b;
  
  private void c()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    setRightButton(2131690022, this);
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView.f();
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((EmotionPreviewData)localIterator.next()).jdField_a_of_type_Boolean = false;
      }
      this.jdField_a_of_type_JavaUtilList.clear();
    }
  }
  
  public void a() {}
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView.a(paramLong);
    }
  }
  
  public void a(EmotionPreviewData paramEmotionPreviewData)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramEmotionPreviewData);
    if (this.jdField_a_of_type_JavaUtilList.size() == 1)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(true);
      this.b.setEnabled(true);
    }
  }
  
  public boolean a()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_JavaUtilList != null) {}
    for (int i = this.jdField_a_of_type_JavaUtilList.size() + 0;; i = 0)
    {
      if (i >= 20) {
        bool = true;
      }
      if (bool)
      {
        if (QLog.isColorLevel()) {
          QLog.d("IphoneTitleBarFragment", 2, "isOverLimit");
        }
        FMToastUtil.a(2131692502);
      }
      return bool;
    }
  }
  
  public void b()
  {
    ThreadManager.excute(new TroopAIOEmotionFragment.2(this), 32, null, true);
  }
  
  public void b(EmotionPreviewData paramEmotionPreviewData)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    do
    {
      return;
      this.jdField_a_of_type_JavaUtilList.remove(paramEmotionPreviewData);
    } while (!this.jdField_a_of_type_JavaUtilList.isEmpty());
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839510);
    this.b.setImageResource(2130839481);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    setTitle(this.mContentView.getContext().getResources().getString(2131692025));
    setRightButton(2131690022, this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.mContentView.findViewById(2131370993));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131367401));
    this.b = ((ImageView)this.mContentView.findViewById(2131365630));
    this.jdField_a_of_type_AndroidViewView = this.mContentView.findViewById(2131368449);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.b.setOnClickListener(this);
    paramLayoutInflater = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView = new ChatHistoryEmotionView();
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView.a(getActivity().getIntent(), paramLayoutInflater, getActivity());
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView.a = this;
    paramLayoutInflater = new ViewGroup.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView.a(), 0, paramLayoutInflater);
    this.jdField_a_of_type_ComTencentMobileqqActivityChathistorySeparateForward = new SeparateForward(getActivity(), 1);
    this.jdField_a_of_type_ComTencentMobileqqActivityChathistorySeparateForward.a();
    AIOGalleryMsgRevokeMgr.a().a(this);
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.jdField_a_of_type_Boolean))
    {
      c();
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public int getContentLayoutId()
  {
    return 2131558892;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 1)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChathistorySeparateForward.a(paramIntent);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
        this.b.setEnabled(false);
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        setRightButton(2131690800, this);
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView.e();
      }
      else
      {
        c();
        continue;
        if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty()))
        {
          FMToastUtil.c(2131692499);
        }
        else if (!NetworkUtil.d(BaseApplication.getContext()))
        {
          QQToast.a(getActivity(), 2131694510, 1).b(getResources().getDimensionPixelSize(2131299166));
        }
        else
        {
          Object localObject = new ArrayList();
          Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
          while (localIterator.hasNext()) {
            ((List)localObject).add((ChatMessage)((EmotionPreviewData)localIterator.next()).jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityChathistorySeparateForward.a((List)localObject);
          c();
          continue;
          if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty()))
          {
            FMToastUtil.c(2131692499);
          }
          else
          {
            localObject = (ActionSheet)ActionSheetHelper.a(getActivity(), null);
            ((ActionSheet)localObject).setMainTitle(2131696078);
            ((ActionSheet)localObject).addButton(getActivity().getString(2131692345), 3);
            ((ActionSheet)localObject).addCancelButton(2131690800);
            ((ActionSheet)localObject).setOnButtonClickListener(new TroopAIOEmotionFragment.1(this, (ActionSheet)localObject));
            ((ActionSheet)localObject).show();
          }
        }
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView.d();
    this.jdField_a_of_type_ComTencentMobileqqActivityChathistorySeparateForward.b();
    AIOGalleryMsgRevokeMgr.a().b(this);
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView.c();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.TroopAIOEmotionFragment
 * JD-Core Version:    0.7.0.1
 */