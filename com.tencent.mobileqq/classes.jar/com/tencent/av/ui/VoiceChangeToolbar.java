package com.tencent.av.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import lez;
import mak;
import mbq;
import mgr;
import mgx;
import mhr;
import mlp;
import mlq;
import mlr;
import mlt;

public class VoiceChangeToolbar
  extends BaseToolbar
  implements View.OnClickListener
{
  public static String TAG = "VoiceChangeToolbar";
  private static VoiceChangeToolbar mToolbarInstance;
  mgr mAdapter;
  Button mEarbackBtn = null;
  ArrayList<mhr> mItemInfo;
  HorizontalListView mListView;
  mbq mUIInfo = null;
  mgx mVoiceClickCallback = new mlt(this);
  
  public VoiceChangeToolbar(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity)
  {
    super(paramVideoAppInterface, paramAVActivity);
  }
  
  private ArrayList<mhr> getList()
  {
    mlq[] arrayOfmlq = mlp.a().a();
    if (arrayOfmlq == null) {}
    ArrayList localArrayList;
    for (int i = 1;; i = arrayOfmlq.length + 1)
    {
      localArrayList = new ArrayList(i);
      Object localObject = new mhr();
      ((mhr)localObject).jdField_a_of_type_JavaLangString = "-1";
      localArrayList.add(localObject);
      if (arrayOfmlq == null) {
        break;
      }
      i = 0;
      while (i < arrayOfmlq.length)
      {
        localObject = arrayOfmlq[i];
        mhr localmhr = new mhr();
        localmhr.jdField_a_of_type_Int = 2;
        localmhr.jdField_a_of_type_JavaLangString = (((mlq)localObject).jdField_a_of_type_Int + "");
        localmhr.c = ((mlq)localObject).jdField_a_of_type_JavaLangString;
        localmhr.jdField_b_of_type_JavaLangString = ((mlq)localObject).c;
        localmhr.jdField_b_of_type_Int = ((mlq)localObject).jdField_b_of_type_Int;
        localmhr.d = ((mlq)localObject).jdField_a_of_type_JavaLangString;
        localmhr.jdField_a_of_type_Boolean = true;
        localmhr.jdField_a_of_type_JavaLangObject = localObject;
        localArrayList.add(localmhr);
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
    mhr localmhr = new mhr();
    localmhr.jdField_a_of_type_JavaLangString = paramString;
    mToolbarInstance.mVoiceClickCallback.a(paramLong, localmhr);
  }
  
  private void updateEarbackBtn()
  {
    int i = 2130842325;
    if (this.mApp.a().a().aA) {
      i = 2130842326;
    }
    this.mEarbackBtn.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
  }
  
  protected mbq getUIInfo()
  {
    if (this.mUIInfo == null)
    {
      this.mUIInfo = new mbq();
      this.mUIInfo.d = 5;
      this.mUIInfo.f = 2131559788;
      this.mUIInfo.e = 2130842307;
      this.mUIInfo.jdField_a_of_type_JavaLangString = this.mApp.getApp().getString(2131695453);
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
        if (((mhr)this.mItemInfo.get(i)).jdField_a_of_type_JavaLangString.equals(paramString)) {
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
    lez locallez = this.mApp.a().a();
    boolean bool;
    if (!this.mApp.a().a().aA)
    {
      bool = true;
      label61:
      locallez.aA = bool;
      if (this.mApp.a().a().U != 0) {
        this.mApp.a().c(this.mApp.a().a().aA);
      }
      updateEarbackBtn();
      if (this.mApp.a().a().aA) {
        break label162;
      }
      mak.a(this.mApp, 1017);
      mlr.a("0X8007EF4", "");
    }
    for (;;)
    {
      EffectSettingUi.a(this.mApp, -1010L);
      break;
      bool = false;
      break label61;
      label162:
      mlr.a("0X8007EF3", "");
    }
  }
  
  protected void onCreate(long paramLong, AVActivity paramAVActivity)
  {
    mToolbarInstance = this;
    this.mListView = ((HorizontalListView)this.toolbarView.findViewById(2131368218));
    this.mListView.setStayDisplayOffsetZero(true);
    this.mItemInfo = getList();
    this.mAdapter = new mgr(this.mApp, paramAVActivity, this.mItemInfo, this.mListView);
    this.mAdapter.a(true);
    this.mAdapter.b(true);
    this.mAdapter.a(this.mVoiceClickCallback);
    this.mListView.setAdapter(this.mAdapter);
    this.mEarbackBtn = ((Button)this.toolbarView.findViewById(2131364373));
    this.mEarbackBtn.setTextSize(ViewUtils.pxTosp(AIOUtils.dp2px(12.0F, paramAVActivity.getResources())));
    this.mEarbackBtn.setOnClickListener(this);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.setMargins(mgr.a(paramAVActivity.getResources(), this.mAdapter.a(), 0.1666667F), 0, 0, 0);
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
      if (!((mhr)this.mItemInfo.get(i)).jdField_a_of_type_JavaLangString.equals(paramString)) {}
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