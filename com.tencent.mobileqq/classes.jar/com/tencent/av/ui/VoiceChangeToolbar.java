package com.tencent.av.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.HorizontalListView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kdh;

public class VoiceChangeToolbar
  extends BaseToolbar
  implements View.OnClickListener
{
  public static String TAG = "VoiceChangeToolbar";
  QAVPtvTemplateAdapter mAdapter;
  Button mEarbackBtn = null;
  ArrayList mItemInfo;
  HorizontalListView mListView;
  BaseToolbar.UIInfo mUIInfo = null;
  QAVPtvTemplateAdapter.IEffectCallback mVoiceClickCallback = new kdh(this);
  
  public VoiceChangeToolbar(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity)
  {
    super(paramVideoAppInterface, paramAVActivity);
  }
  
  private ArrayList getList()
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
        localArrayList.add(localItemInfo);
        i += 1;
      }
    }
    return localArrayList;
  }
  
  private void updateEarbackBtn()
  {
    int i = 2130840355;
    if (this.mApp.a().a().aC) {
      i = 2130840356;
    }
    this.mEarbackBtn.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
  }
  
  protected BaseToolbar.UIInfo getUIInfo()
  {
    if (this.mUIInfo == null)
    {
      this.mUIInfo = new BaseToolbar.UIInfo();
      this.mUIInfo.d = 5;
      this.mUIInfo.g = 2130969363;
      this.mUIInfo.e = 103416;
      this.mUIInfo.f = 2130840340;
      this.mUIInfo.jdField_a_of_type_JavaLangString = this.mApp.getApp().getResources().getString(2131428727);
    }
    return this.mUIInfo;
  }
  
  public String getUnableInfo()
  {
    return "";
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    paramView = this.mApp.a().a();
    boolean bool;
    if (!this.mApp.a().a().aC)
    {
      bool = true;
      paramView.aC = bool;
      if (this.mApp.a().a().S != 0) {
        this.mApp.a().b(this.mApp.a().a().aC);
      }
      updateEarbackBtn();
      if (this.mApp.a().a().aC) {
        break label152;
      }
      EffectToolbar.showCloseEarbackToast((Context)this.mActivity.get());
      VoiceChangeDataReport.a("0X8007EF4", "");
    }
    for (;;)
    {
      EffectSettingUi.a(this.mApp);
      return;
      bool = false;
      break;
      label152:
      VoiceChangeDataReport.a("0X8007EF3", "");
    }
  }
  
  protected void onCreate(AVActivity paramAVActivity)
  {
    this.mListView = ((HorizontalListView)this.toolbarView.findViewById(2131366248));
    this.mListView.setStayDisplayOffsetZero(true);
    this.mItemInfo = getList();
    this.mAdapter = new QAVPtvTemplateAdapter(this.mApp, paramAVActivity, this.mItemInfo, this.mListView);
    this.mAdapter.a(true);
    this.mAdapter.b(true);
    this.mAdapter.a(this.mVoiceClickCallback);
    this.mListView.setAdapter(this.mAdapter);
    this.mEarbackBtn = ((Button)this.toolbarView.findViewById(2131366255));
    this.mEarbackBtn.setOnClickListener(this);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.setMargins(QAVPtvTemplateAdapter.a(paramAVActivity.getResources(), QAVPtvTemplateAdapter.a(paramAVActivity), 0.1666667F), 0, 0, 0);
    this.mEarbackBtn.setLayoutParams(localLayoutParams);
    updateEarbackBtn();
  }
  
  protected void onShow(int paramInt, boolean paramBoolean)
  {
    setSelectedItem(this.mApp.a().a().S + "");
    updateEarbackBtn();
  }
  
  public void setSelectedItem(String paramString)
  {
    if ((this.mListView == null) || (this.mAdapter == null) || (this.mItemInfo == null)) {}
    label157:
    for (;;)
    {
      return;
      int i = 1;
      if (i < this.mItemInfo.size()) {
        if (!((QavListItemBase.ItemInfo)this.mItemInfo.get(i)).jdField_a_of_type_JavaLangString.equals(paramString)) {}
      }
      for (;;)
      {
        if ((!this.mAdapter.a(i)) || ((i >= this.mListView.getFirstVisiblePosition()) && (i <= this.mListView.getLastVisiblePosition()))) {
          break label157;
        }
        int k = 0;
        int j = k;
        if (i > 0)
        {
          j = k;
          if (i > QAVPtvTemplateAdapter.a(this.mAdapter.jdField_a_of_type_AndroidContentContext)) {
            j = this.mAdapter.jdField_b_of_type_Int + (i - 1) * this.mAdapter.jdField_a_of_type_Int;
          }
        }
        this.mListView.a(j);
        return;
        i += 1;
        break;
        i = -1;
      }
    }
  }
  
  public void update(Object[] paramArrayOfObject)
  {
    if ((this.mListView == null) || (this.mAdapter == null)) {
      return;
    }
    paramArrayOfObject = getList();
    this.mAdapter.a(paramArrayOfObject);
    setSelectedItem(this.mApp.a().a().S + "");
    this.mAdapter.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.VoiceChangeToolbar
 * JD-Core Version:    0.7.0.1
 */