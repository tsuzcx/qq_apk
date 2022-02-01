package com.tencent.mobileqq.activity.chathistory;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.MsgRevokeListener;
import com.tencent.mobileqq.activity.ChatHistoryEmotionView;
import com.tencent.mobileqq.activity.ChatHistoryEmotionView.OperateCallBack;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryMsgRevokeMgr;
import com.tencent.mobileqq.app.BaseActivity;
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
  implements View.OnClickListener, MsgRevokeListener, ChatHistoryEmotionView.OperateCallBack
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
    setRightButton(2131689937, this);
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView.f();
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((EmotionPreviewData)((Iterator)localObject).next()).jdField_a_of_type_Boolean = false;
      }
      this.jdField_a_of_type_JavaUtilList.clear();
    }
  }
  
  public void a() {}
  
  public void a(long paramLong)
  {
    ChatHistoryEmotionView localChatHistoryEmotionView = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView;
    if (localChatHistoryEmotionView != null) {
      localChatHistoryEmotionView.a(paramLong);
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
    List localList = this.jdField_a_of_type_JavaUtilList;
    boolean bool = false;
    int i;
    if (localList != null) {
      i = localList.size() + 0;
    } else {
      i = 0;
    }
    if (i >= 20) {
      bool = true;
    }
    if (bool)
    {
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarFragment", 2, "isOverLimit");
      }
      FMToastUtil.a(2131692438);
    }
    return bool;
  }
  
  public void b()
  {
    ThreadManager.excute(new TroopAIOEmotionFragment.2(this), 32, null, true);
  }
  
  public void b(EmotionPreviewData paramEmotionPreviewData)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList == null) {
      return;
    }
    localList.remove(paramEmotionPreviewData);
    if (this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839366);
      this.b.setImageResource(2130839337);
    }
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    setTitle(this.mContentView.getContext().getResources().getString(2131691944));
    setRightButton(2131689937, this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.mContentView.findViewById(2131370627));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131367183));
    this.b = ((ImageView)this.mContentView.findViewById(2131365474));
    this.jdField_a_of_type_AndroidViewView = this.mContentView.findViewById(2131368198);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.b.setOnClickListener(this);
    paramLayoutInflater = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView = new ChatHistoryEmotionView();
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView.a(getBaseActivity().getIntent(), paramLayoutInflater, getBaseActivity());
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView.a = this;
    paramLayoutInflater = new ViewGroup.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView.a(), 0, paramLayoutInflater);
    this.jdField_a_of_type_ComTencentMobileqqActivityChathistorySeparateForward = new SeparateForward(getBaseActivity(), 1);
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
  
  protected int getContentLayoutId()
  {
    return 2131558790;
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
    int i = paramView.getId();
    Object localObject;
    if (i != 2131365474)
    {
      if (i != 2131367183)
      {
        if (i == 2131369233) {
          if (!this.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_Boolean = true;
            this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
            this.b.setEnabled(false);
            this.jdField_a_of_type_AndroidViewView.setVisibility(0);
            setRightButton(2131690728, this);
            this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView.e();
          }
          else
          {
            c();
          }
        }
      }
      else
      {
        localObject = this.jdField_a_of_type_JavaUtilList;
        if ((localObject != null) && (!((List)localObject).isEmpty()))
        {
          if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
          {
            QQToast.a(getBaseActivity(), 2131694475, 1).b(getResources().getDimensionPixelSize(2131299168));
          }
          else
          {
            localObject = new ArrayList();
            Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
            while (localIterator.hasNext()) {
              ((List)localObject).add((ChatMessage)((EmotionPreviewData)localIterator.next()).jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityChathistorySeparateForward.a((List)localObject);
            c();
          }
        }
        else {
          FMToastUtil.c(2131692435);
        }
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_JavaUtilList;
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        localObject = (ActionSheet)ActionSheetHelper.a(getBaseActivity(), null);
        ((ActionSheet)localObject).setMainTitle(2131696093);
        ((ActionSheet)localObject).addButton(getBaseActivity().getString(2131692273), 3);
        ((ActionSheet)localObject).addCancelButton(2131690728);
        ((ActionSheet)localObject).setOnButtonClickListener(new TroopAIOEmotionFragment.1(this, (ActionSheet)localObject));
        ((ActionSheet)localObject).show();
      }
      else
      {
        FMToastUtil.c(2131692435);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.TroopAIOEmotionFragment
 * JD-Core Version:    0.7.0.1
 */