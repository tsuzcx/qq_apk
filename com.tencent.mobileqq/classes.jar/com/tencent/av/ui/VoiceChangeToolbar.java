package com.tencent.av.ui;

import aciy;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import bajq;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import kvq;
import lqb;
import lrg;
import lwf;
import lwk;
import lxf;
import may;
import maz;
import mba;
import mbc;

public class VoiceChangeToolbar
  extends BaseToolbar
  implements View.OnClickListener
{
  public static String TAG = "VoiceChangeToolbar";
  private static VoiceChangeToolbar mToolbarInstance;
  lwf mAdapter;
  Button mEarbackBtn = null;
  ArrayList<lxf> mItemInfo;
  HorizontalListView mListView;
  lrg mUIInfo = null;
  lwk mVoiceClickCallback = new mbc(this);
  
  public VoiceChangeToolbar(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity)
  {
    super(paramVideoAppInterface, paramAVActivity);
  }
  
  private ArrayList<lxf> getList()
  {
    maz[] arrayOfmaz = may.a().a();
    if (arrayOfmaz == null) {}
    ArrayList localArrayList;
    for (int i = 1;; i = arrayOfmaz.length + 1)
    {
      localArrayList = new ArrayList(i);
      Object localObject = new lxf();
      ((lxf)localObject).jdField_a_of_type_JavaLangString = "-1";
      localArrayList.add(localObject);
      if (arrayOfmaz == null) {
        break;
      }
      i = 0;
      while (i < arrayOfmaz.length)
      {
        localObject = arrayOfmaz[i];
        lxf locallxf = new lxf();
        locallxf.jdField_a_of_type_Int = 2;
        locallxf.jdField_a_of_type_JavaLangString = (((maz)localObject).jdField_a_of_type_Int + "");
        locallxf.c = ((maz)localObject).jdField_a_of_type_JavaLangString;
        locallxf.jdField_b_of_type_JavaLangString = ((maz)localObject).c;
        locallxf.jdField_b_of_type_Int = ((maz)localObject).jdField_b_of_type_Int;
        locallxf.d = ((maz)localObject).jdField_a_of_type_JavaLangString;
        locallxf.jdField_a_of_type_Boolean = true;
        locallxf.jdField_a_of_type_JavaLangObject = localObject;
        localArrayList.add(locallxf);
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
    lxf locallxf = new lxf();
    locallxf.jdField_a_of_type_JavaLangString = paramString;
    mToolbarInstance.mVoiceClickCallback.a(paramLong, locallxf);
  }
  
  private void updateEarbackBtn()
  {
    int i = 2130841702;
    if (this.mApp.a().a().ay) {
      i = 2130841703;
    }
    this.mEarbackBtn.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
  }
  
  protected lrg getUIInfo()
  {
    if (this.mUIInfo == null)
    {
      this.mUIInfo = new lrg();
      this.mUIInfo.d = 5;
      this.mUIInfo.f = 2131494020;
      this.mUIInfo.e = 2130841685;
      this.mUIInfo.jdField_a_of_type_JavaLangString = this.mApp.getApp().getString(2131630511);
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
        if (((lxf)this.mItemInfo.get(i)).jdField_a_of_type_JavaLangString.equals(paramString)) {
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
      return;
    }
    paramView = this.mApp.a().a();
    boolean bool;
    if (!this.mApp.a().a().ay)
    {
      bool = true;
      paramView.ay = bool;
      if (this.mApp.a().a().R != 0) {
        this.mApp.a().c(this.mApp.a().a().ay);
      }
      updateEarbackBtn();
      if (this.mApp.a().a().ay) {
        break label153;
      }
      lqb.a(this.mApp, 1017);
      mba.a("0X8007EF4", "");
    }
    for (;;)
    {
      EffectSettingUi.a(this.mApp, -1010L);
      return;
      bool = false;
      break;
      label153:
      mba.a("0X8007EF3", "");
    }
  }
  
  protected void onCreate(long paramLong, AVActivity paramAVActivity)
  {
    mToolbarInstance = this;
    this.mListView = ((HorizontalListView)this.toolbarView.findViewById(2131302046));
    this.mListView.setStayDisplayOffsetZero(true);
    this.mItemInfo = getList();
    this.mAdapter = new lwf(this.mApp, paramAVActivity, this.mItemInfo, this.mListView);
    this.mAdapter.a(true);
    this.mAdapter.b(true);
    this.mAdapter.a(this.mVoiceClickCallback);
    this.mListView.setAdapter(this.mAdapter);
    this.mEarbackBtn = ((Button)this.toolbarView.findViewById(2131298482));
    this.mEarbackBtn.setTextSize(bajq.e(aciy.a(12.0F, paramAVActivity.getResources())));
    this.mEarbackBtn.setOnClickListener(this);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.setMargins(lwf.a(paramAVActivity.getResources(), lwf.a(paramAVActivity), 0.1666667F), 0, 0, 0);
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
    setSelectedItem(this.mApp.a().a().R + "");
    updateEarbackBtn();
  }
  
  public void setSelectedItem(String paramString)
  {
    if ((this.mListView == null) || (this.mAdapter == null) || (this.mItemInfo == null)) {
      return;
    }
    int i = 1;
    if (i < this.mItemInfo.size()) {
      if (!((lxf)this.mItemInfo.get(i)).jdField_a_of_type_JavaLangString.equals(paramString)) {}
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
    setSelectedItem(this.mApp.a().a().R + "");
    this.mAdapter.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.VoiceChangeToolbar
 * JD-Core Version:    0.7.0.1
 */