package com.tencent.av.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.tips.TipsUtil;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;

public class VoiceChangeToolbar
  extends BaseToolbar
  implements View.OnClickListener
{
  public static String TAG = "VoiceChangeToolbar";
  private static VoiceChangeToolbar mToolbarInstance;
  QAVPtvTemplateAdapter mAdapter;
  Button mEarbackBtn = null;
  ArrayList<QavListItemBase.ItemInfo> mItemInfo;
  HorizontalListView mListView;
  BaseToolbar.UIInfo mUIInfo = null;
  QAVPtvTemplateAdapter.IEffectCallback mVoiceClickCallback = new VoiceChangeToolbar.1(this);
  
  public VoiceChangeToolbar(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity)
  {
    super(paramVideoAppInterface, paramAVActivity);
  }
  
  private ArrayList<QavListItemBase.ItemInfo> getList()
  {
    VoiceChangeData.VoiceInfo[] arrayOfVoiceInfo = VoiceChangeData.a().a();
    if (arrayOfVoiceInfo == null) {}
    ArrayList localArrayList;
    for (int i = 1;; i = arrayOfVoiceInfo.length + 1)
    {
      localArrayList = new ArrayList(i);
      Object localObject = new QavListItemBase.ItemInfo();
      ((QavListItemBase.ItemInfo)localObject).jdField_a_of_type_JavaLangString = "-1";
      localArrayList.add(localObject);
      if (arrayOfVoiceInfo == null) {
        break;
      }
      i = 0;
      while (i < arrayOfVoiceInfo.length)
      {
        localObject = arrayOfVoiceInfo[i];
        QavListItemBase.ItemInfo localItemInfo = new QavListItemBase.ItemInfo();
        localItemInfo.jdField_a_of_type_Int = 2;
        localItemInfo.jdField_a_of_type_JavaLangString = (((VoiceChangeData.VoiceInfo)localObject).jdField_a_of_type_Int + "");
        localItemInfo.c = ((VoiceChangeData.VoiceInfo)localObject).jdField_a_of_type_JavaLangString;
        localItemInfo.jdField_b_of_type_JavaLangString = ((VoiceChangeData.VoiceInfo)localObject).c;
        localItemInfo.jdField_b_of_type_Int = ((VoiceChangeData.VoiceInfo)localObject).jdField_b_of_type_Int;
        localItemInfo.d = ((VoiceChangeData.VoiceInfo)localObject).jdField_a_of_type_JavaLangString;
        localItemInfo.jdField_a_of_type_Boolean = true;
        localItemInfo.jdField_a_of_type_JavaLangObject = localObject;
        localArrayList.add(localItemInfo);
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public static void setEffectConfigItem(long paramLong, String paramString)
  {
    if ((mToolbarInstance == null) || (mToolbarInstance.isOutOfArray(paramString))) {
      return;
    }
    mToolbarInstance.setSelectedItem(paramString);
    QavListItemBase.ItemInfo localItemInfo = new QavListItemBase.ItemInfo();
    localItemInfo.jdField_a_of_type_JavaLangString = paramString;
    mToolbarInstance.mVoiceClickCallback.a(paramLong, localItemInfo);
  }
  
  private void updateEarbackBtn()
  {
    int i = 2130842482;
    if (this.mApp.a().a().aC) {
      i = 2130842483;
    }
    this.mEarbackBtn.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
  }
  
  protected BaseToolbar.UIInfo getUIInfo()
  {
    if (this.mUIInfo == null)
    {
      this.mUIInfo = new BaseToolbar.UIInfo();
      this.mUIInfo.d = 5;
      this.mUIInfo.g = 2131559901;
      this.mUIInfo.f = 2130842464;
      this.mUIInfo.jdField_a_of_type_JavaLangString = this.mApp.getApp().getString(2131695913);
    }
    return this.mUIInfo;
  }
  
  public String getUnableInfo()
  {
    return "";
  }
  
  public boolean isOutOfArray(String paramString)
  {
    if ((this.mListView == null) || (this.mAdapter == null) || (this.mItemInfo == null)) {}
    for (;;)
    {
      return true;
      int i = 1;
      while (i < this.mItemInfo.size())
      {
        if (((QavListItemBase.ItemInfo)this.mItemInfo.get(i)).jdField_a_of_type_JavaLangString.equals(paramString)) {
          return false;
        }
        i += 1;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    SessionInfo localSessionInfo = this.mApp.a().a();
    boolean bool;
    if (!this.mApp.a().a().aC)
    {
      bool = true;
      label61:
      localSessionInfo.aC = bool;
      if (this.mApp.a().a().U != 0) {
        this.mApp.a().c(this.mApp.a().a().aC);
      }
      updateEarbackBtn();
      if (this.mApp.a().a().aC) {
        break label162;
      }
      TipsUtil.a(this.mApp, 1017);
      VoiceChangeDataReport.a("0X8007EF4", "");
    }
    for (;;)
    {
      EffectSettingUi.a(this.mApp, -1010L);
      break;
      bool = false;
      break label61;
      label162:
      VoiceChangeDataReport.a("0X8007EF3", "");
    }
  }
  
  protected void onCreate(long paramLong, AVActivity paramAVActivity)
  {
    mToolbarInstance = this;
    this.mListView = ((HorizontalListView)this.toolbarView.findViewById(2131368580));
    this.mListView.setStayDisplayOffsetZero(true);
    this.mItemInfo = getList();
    this.mAdapter = new QAVPtvTemplateAdapter(this.mApp, paramAVActivity, this.mItemInfo, this.mListView);
    this.mAdapter.a(true);
    this.mAdapter.b(true);
    this.mAdapter.a(this.mVoiceClickCallback);
    this.mListView.setAdapter(this.mAdapter);
    this.mEarbackBtn = ((Button)this.toolbarView.findViewById(2131364562));
    this.mEarbackBtn.setTextSize(ViewUtils.e(AIOUtils.a(12.0F, paramAVActivity.getResources())));
    this.mEarbackBtn.setOnClickListener(this);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.setMargins(QAVPtvTemplateAdapter.a(paramAVActivity.getResources(), this.mAdapter.a(), 0.1666667F), 0, 0, 0);
    this.mEarbackBtn.setLayoutParams(localLayoutParams);
    updateEarbackBtn();
  }
  
  protected void onDestroy(long paramLong, VideoAppInterface paramVideoAppInterface)
  {
    mToolbarInstance = null;
  }
  
  protected void onShow(long paramLong, int paramInt, boolean paramBoolean)
  {
    if ((this.mItemInfo == null) || (this.mItemInfo.size() == 1))
    {
      this.mItemInfo = getList();
      if ((this.mItemInfo != null) && (this.mItemInfo.size() > 1) && (this.mAdapter != null))
      {
        this.mAdapter.a(this.mItemInfo);
        this.mAdapter.notifyDataSetChanged();
      }
    }
    setSelectedItem(this.mApp.a().a().U + "");
    updateEarbackBtn();
  }
  
  public void setSelectedItem(String paramString)
  {
    if ((this.mListView == null) || (this.mAdapter == null) || (this.mItemInfo == null)) {
      return;
    }
    int i = 1;
    if (i < this.mItemInfo.size()) {
      if (!((QavListItemBase.ItemInfo)this.mItemInfo.get(i)).jdField_a_of_type_JavaLangString.equals(paramString)) {}
    }
    for (;;)
    {
      setSelectedListViewItemAndShow(this.mListView, this.mAdapter, i);
      return;
      i += 1;
      break;
      i = -1;
    }
  }
  
  public void update(Object[] paramArrayOfObject)
  {
    if ((this.mListView == null) || (this.mAdapter == null)) {
      return;
    }
    this.mItemInfo = getList();
    this.mAdapter.a(this.mItemInfo);
    setSelectedItem(this.mApp.a().a().U + "");
    this.mAdapter.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.VoiceChangeToolbar
 * JD-Core Version:    0.7.0.1
 */