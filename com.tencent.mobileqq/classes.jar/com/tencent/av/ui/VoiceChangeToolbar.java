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
    int i;
    if (arrayOfVoiceInfo == null) {
      i = 1;
    } else {
      i = arrayOfVoiceInfo.length + 1;
    }
    ArrayList localArrayList = new ArrayList(i);
    Object localObject = new QavListItemBase.ItemInfo();
    ((QavListItemBase.ItemInfo)localObject).jdField_a_of_type_JavaLangString = "-1";
    localArrayList.add(localObject);
    if (arrayOfVoiceInfo != null)
    {
      i = 0;
      while (i < arrayOfVoiceInfo.length)
      {
        localObject = arrayOfVoiceInfo[i];
        QavListItemBase.ItemInfo localItemInfo = new QavListItemBase.ItemInfo();
        localItemInfo.jdField_a_of_type_Int = 2;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(((VoiceChangeData.VoiceInfo)localObject).jdField_a_of_type_Int);
        localStringBuilder.append("");
        localItemInfo.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
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
    Object localObject = mToolbarInstance;
    if (localObject != null)
    {
      if (((VoiceChangeToolbar)localObject).isOutOfArray(paramString)) {
        return;
      }
      mToolbarInstance.setSelectedItem(paramString);
      localObject = new QavListItemBase.ItemInfo();
      ((QavListItemBase.ItemInfo)localObject).jdField_a_of_type_JavaLangString = paramString;
      mToolbarInstance.mVoiceClickCallback.a(paramLong, (QavListItemBase.ItemInfo)localObject);
    }
  }
  
  private void updateEarbackBtn()
  {
    int i;
    if (this.mApp.a().a().ar) {
      i = 2130842382;
    } else {
      i = 2130842381;
    }
    this.mEarbackBtn.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
  }
  
  protected BaseToolbar.UIInfo getUIInfo()
  {
    if (this.mUIInfo == null)
    {
      this.mUIInfo = new BaseToolbar.UIInfo();
      BaseToolbar.UIInfo localUIInfo = this.mUIInfo;
      localUIInfo.d = 5;
      localUIInfo.g = 2131559772;
      localUIInfo.f = 2130842363;
      localUIInfo.jdField_a_of_type_JavaLangString = this.mApp.getApp().getString(2131695928);
    }
    return this.mUIInfo;
  }
  
  public String getUnableInfo()
  {
    return "";
  }
  
  public boolean isOutOfArray(String paramString)
  {
    if ((this.mListView != null) && (this.mAdapter != null))
    {
      if (this.mItemInfo == null) {
        return true;
      }
      int i = 1;
      while (i < this.mItemInfo.size())
      {
        if (((QavListItemBase.ItemInfo)this.mItemInfo.get(i)).jdField_a_of_type_JavaLangString.equals(paramString)) {
          return false;
        }
        i += 1;
      }
    }
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131364449)
    {
      this.mApp.a().a().ar ^= true;
      if (this.mApp.a().a().ad != 0) {
        this.mApp.a().c(this.mApp.a().a().ar);
      }
      updateEarbackBtn();
      if (!this.mApp.a().a().ar)
      {
        TipsUtil.a(this.mApp, 1017);
        VoiceChangeDataReport.a("0X8007EF4", "");
      }
      else
      {
        VoiceChangeDataReport.a("0X8007EF3", "");
      }
      EffectSettingUi.a(this.mApp, -1010L);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onCreate(long paramLong, AVActivity paramAVActivity)
  {
    mToolbarInstance = this;
    this.mListView = ((HorizontalListView)this.toolbarView.findViewById(2131368321));
    this.mListView.setStayDisplayOffsetZero(true);
    this.mItemInfo = getList();
    this.mAdapter = new QAVPtvTemplateAdapter(this.mApp, paramAVActivity, this.mItemInfo, this.mListView);
    this.mAdapter.a(true);
    this.mAdapter.b(true);
    this.mAdapter.a(this.mVoiceClickCallback);
    this.mListView.setAdapter(this.mAdapter);
    this.mEarbackBtn = ((Button)this.toolbarView.findViewById(2131364449));
    this.mEarbackBtn.setTextSize(ViewUtils.e(AIOUtils.b(12.0F, paramAVActivity.getResources())));
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
    Object localObject = this.mItemInfo;
    if ((localObject == null) || (((ArrayList)localObject).size() == 1))
    {
      this.mItemInfo = getList();
      localObject = this.mItemInfo;
      if ((localObject != null) && (((ArrayList)localObject).size() > 1))
      {
        localObject = this.mAdapter;
        if (localObject != null)
        {
          ((QAVPtvTemplateAdapter)localObject).a(this.mItemInfo);
          this.mAdapter.notifyDataSetChanged();
        }
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.mApp.a().a().ad);
    ((StringBuilder)localObject).append("");
    setSelectedItem(((StringBuilder)localObject).toString());
    updateEarbackBtn();
  }
  
  public void setSelectedItem(String paramString)
  {
    if ((this.mListView != null) && (this.mAdapter != null))
    {
      if (this.mItemInfo == null) {
        return;
      }
      int k = -1;
      int i = 1;
      int j;
      for (;;)
      {
        j = k;
        if (i >= this.mItemInfo.size()) {
          break;
        }
        if (((QavListItemBase.ItemInfo)this.mItemInfo.get(i)).jdField_a_of_type_JavaLangString.equals(paramString))
        {
          j = i;
          break;
        }
        i += 1;
      }
      setSelectedListViewItemAndShow(this.mListView, this.mAdapter, j);
    }
  }
  
  public void update(Object[] paramArrayOfObject)
  {
    if (this.mListView != null)
    {
      if (this.mAdapter == null) {
        return;
      }
      this.mItemInfo = getList();
      this.mAdapter.a(this.mItemInfo);
      paramArrayOfObject = new StringBuilder();
      paramArrayOfObject.append(this.mApp.a().a().ad);
      paramArrayOfObject.append("");
      setSelectedItem(paramArrayOfObject.toString());
      this.mAdapter.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VoiceChangeToolbar
 * JD-Core Version:    0.7.0.1
 */