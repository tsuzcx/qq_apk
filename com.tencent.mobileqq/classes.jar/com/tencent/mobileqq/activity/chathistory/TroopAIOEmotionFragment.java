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
  private RelativeLayout a;
  private ImageView b;
  private ImageView c;
  private View d;
  private ChatHistoryEmotionView e;
  private boolean f = false;
  private List<EmotionPreviewData> g;
  private SeparateForward h;
  
  private void d()
  {
    this.f = false;
    this.d.setVisibility(8);
    setRightButton(2131886578, this);
    this.e.h();
    Object localObject = this.g;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = this.g.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((EmotionPreviewData)((Iterator)localObject).next()).b = false;
      }
      this.g.clear();
    }
  }
  
  public void a(long paramLong)
  {
    ChatHistoryEmotionView localChatHistoryEmotionView = this.e;
    if (localChatHistoryEmotionView != null) {
      localChatHistoryEmotionView.a(paramLong);
    }
  }
  
  public void a(EmotionPreviewData paramEmotionPreviewData)
  {
    if (this.g == null) {
      this.g = new ArrayList();
    }
    this.g.add(paramEmotionPreviewData);
    if (this.g.size() == 1)
    {
      this.b.setEnabled(true);
      this.c.setEnabled(true);
    }
  }
  
  public boolean a()
  {
    List localList = this.g;
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
      FMToastUtil.a(2131889426);
    }
    return bool;
  }
  
  public void b() {}
  
  public void b(EmotionPreviewData paramEmotionPreviewData)
  {
    List localList = this.g;
    if (localList == null) {
      return;
    }
    localList.remove(paramEmotionPreviewData);
    if (this.g.isEmpty())
    {
      this.b.setImageResource(2130839548);
      this.c.setImageResource(2130839519);
    }
  }
  
  public void c()
  {
    ThreadManager.excute(new TroopAIOEmotionFragment.2(this), 32, null, true);
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    setTitle(this.mContentView.getContext().getResources().getString(2131888911));
    setRightButton(2131886578, this);
    this.a = ((RelativeLayout)this.mContentView.findViewById(2131437901));
    this.b = ((ImageView)this.mContentView.findViewById(2131433639));
    this.c = ((ImageView)this.mContentView.findViewById(2131431689));
    this.d = this.mContentView.findViewById(2131435063);
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    paramLayoutInflater = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    this.e = new ChatHistoryEmotionView();
    this.e.a(getBaseActivity().getIntent(), paramLayoutInflater, getBaseActivity());
    this.e.b = this;
    paramLayoutInflater = new ViewGroup.LayoutParams(-1, -1);
    this.a.addView(this.e.a(), 0, paramLayoutInflater);
    this.h = new SeparateForward(getBaseActivity(), 1);
    this.h.a();
    AIOGalleryMsgRevokeMgr.a().a(this);
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.f))
    {
      d();
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  protected int getContentLayoutId()
  {
    return 2131624410;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 1)) {
      this.h.a(paramIntent);
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject;
    if (i != 2131431689)
    {
      if (i != 2131433639)
      {
        if (i == 2131436211) {
          if (!this.f)
          {
            this.f = true;
            this.b.setEnabled(false);
            this.c.setEnabled(false);
            this.d.setVisibility(0);
            setRightButton(2131887648, this);
            this.e.g();
          }
          else
          {
            d();
          }
        }
      }
      else
      {
        localObject = this.g;
        if ((localObject != null) && (!((List)localObject).isEmpty()))
        {
          if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
          {
            QQToast.makeText(getBaseActivity(), 2131892157, 1).show(getResources().getDimensionPixelSize(2131299920));
          }
          else
          {
            localObject = new ArrayList();
            Iterator localIterator = this.g.iterator();
            while (localIterator.hasNext()) {
              ((List)localObject).add((ChatMessage)((EmotionPreviewData)localIterator.next()).a);
            }
            this.h.a((List)localObject);
            d();
          }
        }
        else {
          FMToastUtil.c(2131889423);
        }
      }
    }
    else
    {
      localObject = this.g;
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        localObject = (ActionSheet)ActionSheetHelper.b(getBaseActivity(), null);
        ((ActionSheet)localObject).setMainTitle(2131893858);
        ((ActionSheet)localObject).addButton(getBaseActivity().getString(2131889261), 3);
        ((ActionSheet)localObject).addCancelButton(2131887648);
        ((ActionSheet)localObject).setOnButtonClickListener(new TroopAIOEmotionFragment.1(this, (ActionSheet)localObject));
        ((ActionSheet)localObject).show();
      }
      else
      {
        FMToastUtil.c(2131889423);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.e.f();
    this.h.b();
    AIOGalleryMsgRevokeMgr.a().b(this);
  }
  
  public void onPause()
  {
    super.onPause();
    this.e.e();
  }
  
  public void onResume()
  {
    super.onResume();
    this.e.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.TroopAIOEmotionFragment
 * JD-Core Version:    0.7.0.1
 */