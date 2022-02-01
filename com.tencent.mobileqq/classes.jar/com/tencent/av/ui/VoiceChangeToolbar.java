package com.tencent.av.ui;

import agej;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import bhtq;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import lff;
import mbb;
import mch;
import mhi;
import mho;
import mii;
import mmg;
import mmh;
import mmi;
import mmk;

public class VoiceChangeToolbar
  extends BaseToolbar
  implements View.OnClickListener
{
  public static String TAG = "VoiceChangeToolbar";
  private static VoiceChangeToolbar mToolbarInstance;
  mhi mAdapter;
  Button mEarbackBtn = null;
  ArrayList<mii> mItemInfo;
  HorizontalListView mListView;
  mch mUIInfo = null;
  mho mVoiceClickCallback = new mmk(this);
  
  public VoiceChangeToolbar(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity)
  {
    super(paramVideoAppInterface, paramAVActivity);
  }
  
  private ArrayList<mii> getList()
  {
    mmh[] arrayOfmmh = mmg.a().a();
    if (arrayOfmmh == null) {}
    ArrayList localArrayList;
    for (int i = 1;; i = arrayOfmmh.length + 1)
    {
      localArrayList = new ArrayList(i);
      Object localObject = new mii();
      ((mii)localObject).jdField_a_of_type_JavaLangString = "-1";
      localArrayList.add(localObject);
      if (arrayOfmmh == null) {
        break;
      }
      i = 0;
      while (i < arrayOfmmh.length)
      {
        localObject = arrayOfmmh[i];
        mii localmii = new mii();
        localmii.jdField_a_of_type_Int = 2;
        localmii.jdField_a_of_type_JavaLangString = (((mmh)localObject).jdField_a_of_type_Int + "");
        localmii.c = ((mmh)localObject).jdField_a_of_type_JavaLangString;
        localmii.jdField_b_of_type_JavaLangString = ((mmh)localObject).c;
        localmii.jdField_b_of_type_Int = ((mmh)localObject).jdField_b_of_type_Int;
        localmii.d = ((mmh)localObject).jdField_a_of_type_JavaLangString;
        localmii.jdField_a_of_type_Boolean = true;
        localmii.jdField_a_of_type_JavaLangObject = localObject;
        localArrayList.add(localmii);
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
    mii localmii = new mii();
    localmii.jdField_a_of_type_JavaLangString = paramString;
    mToolbarInstance.mVoiceClickCallback.a(paramLong, localmii);
  }
  
  private void updateEarbackBtn()
  {
    int i = 2130842283;
    if (this.mApp.a().a().aA) {
      i = 2130842284;
    }
    this.mEarbackBtn.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
  }
  
  protected mch getUIInfo()
  {
    if (this.mUIInfo == null)
    {
      this.mUIInfo = new mch();
      this.mUIInfo.d = 5;
      this.mUIInfo.f = 2131559786;
      this.mUIInfo.e = 2130842265;
      this.mUIInfo.jdField_a_of_type_JavaLangString = this.mApp.getApp().getString(2131695314);
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
        if (((mii)this.mItemInfo.get(i)).jdField_a_of_type_JavaLangString.equals(paramString)) {
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
    lff locallff = this.mApp.a().a();
    boolean bool;
    if (!this.mApp.a().a().aA)
    {
      bool = true;
      label61:
      locallff.aA = bool;
      if (this.mApp.a().a().U != 0) {
        this.mApp.a().c(this.mApp.a().a().aA);
      }
      updateEarbackBtn();
      if (this.mApp.a().a().aA) {
        break label162;
      }
      mbb.a(this.mApp, 1017);
      mmi.a("0X8007EF4", "");
    }
    for (;;)
    {
      EffectSettingUi.a(this.mApp, -1010L);
      break;
      bool = false;
      break label61;
      label162:
      mmi.a("0X8007EF3", "");
    }
  }
  
  protected void onCreate(long paramLong, AVActivity paramAVActivity)
  {
    mToolbarInstance = this;
    this.mListView = ((HorizontalListView)this.toolbarView.findViewById(2131368193));
    this.mListView.setStayDisplayOffsetZero(true);
    this.mItemInfo = getList();
    this.mAdapter = new mhi(this.mApp, paramAVActivity, this.mItemInfo, this.mListView);
    this.mAdapter.a(true);
    this.mAdapter.b(true);
    this.mAdapter.a(this.mVoiceClickCallback);
    this.mListView.setAdapter(this.mAdapter);
    this.mEarbackBtn = ((Button)this.toolbarView.findViewById(2131364355));
    this.mEarbackBtn.setTextSize(bhtq.e(agej.a(12.0F, paramAVActivity.getResources())));
    this.mEarbackBtn.setOnClickListener(this);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.setMargins(mhi.a(paramAVActivity.getResources(), this.mAdapter.a(), 0.1666667F), 0, 0, 0);
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
      if (!((mii)this.mItemInfo.get(i)).jdField_a_of_type_JavaLangString.equals(paramString)) {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.VoiceChangeToolbar
 * JD-Core Version:    0.7.0.1
 */