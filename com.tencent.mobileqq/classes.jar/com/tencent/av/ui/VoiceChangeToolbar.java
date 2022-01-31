package com.tencent.av.ui;

import aepi;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import bdoo;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import lid;
import mdd;
import mej;
import mjk;
import mjp;
import mkj;
import mog;
import moh;
import moi;
import mok;

public class VoiceChangeToolbar
  extends BaseToolbar
  implements View.OnClickListener
{
  public static String TAG = "VoiceChangeToolbar";
  private static VoiceChangeToolbar mToolbarInstance;
  mjk mAdapter;
  Button mEarbackBtn = null;
  ArrayList<mkj> mItemInfo;
  HorizontalListView mListView;
  mej mUIInfo = null;
  mjp mVoiceClickCallback = new mok(this);
  
  public VoiceChangeToolbar(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity)
  {
    super(paramVideoAppInterface, paramAVActivity);
  }
  
  private ArrayList<mkj> getList()
  {
    moh[] arrayOfmoh = mog.a().a();
    if (arrayOfmoh == null) {}
    ArrayList localArrayList;
    for (int i = 1;; i = arrayOfmoh.length + 1)
    {
      localArrayList = new ArrayList(i);
      Object localObject = new mkj();
      ((mkj)localObject).jdField_a_of_type_JavaLangString = "-1";
      localArrayList.add(localObject);
      if (arrayOfmoh == null) {
        break;
      }
      i = 0;
      while (i < arrayOfmoh.length)
      {
        localObject = arrayOfmoh[i];
        mkj localmkj = new mkj();
        localmkj.jdField_a_of_type_Int = 2;
        localmkj.jdField_a_of_type_JavaLangString = (((moh)localObject).jdField_a_of_type_Int + "");
        localmkj.c = ((moh)localObject).jdField_a_of_type_JavaLangString;
        localmkj.jdField_b_of_type_JavaLangString = ((moh)localObject).c;
        localmkj.jdField_b_of_type_Int = ((moh)localObject).jdField_b_of_type_Int;
        localmkj.d = ((moh)localObject).jdField_a_of_type_JavaLangString;
        localmkj.jdField_a_of_type_Boolean = true;
        localmkj.jdField_a_of_type_JavaLangObject = localObject;
        localArrayList.add(localmkj);
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
    mkj localmkj = new mkj();
    localmkj.jdField_a_of_type_JavaLangString = paramString;
    mToolbarInstance.mVoiceClickCallback.a(paramLong, localmkj);
  }
  
  private void updateEarbackBtn()
  {
    int i = 2130841963;
    if (this.mApp.a().a().az) {
      i = 2130841964;
    }
    this.mEarbackBtn.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
  }
  
  protected mej getUIInfo()
  {
    if (this.mUIInfo == null)
    {
      this.mUIInfo = new mej();
      this.mUIInfo.d = 5;
      this.mUIInfo.f = 2131559643;
      this.mUIInfo.e = 2130841945;
      this.mUIInfo.jdField_a_of_type_JavaLangString = this.mApp.getApp().getString(2131696389);
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
        if (((mkj)this.mItemInfo.get(i)).jdField_a_of_type_JavaLangString.equals(paramString)) {
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
    if (!this.mApp.a().a().az)
    {
      bool = true;
      paramView.az = bool;
      if (this.mApp.a().a().T != 0) {
        this.mApp.a().c(this.mApp.a().a().az);
      }
      updateEarbackBtn();
      if (this.mApp.a().a().az) {
        break label153;
      }
      mdd.a(this.mApp, 1017);
      moi.a("0X8007EF4", "");
    }
    for (;;)
    {
      EffectSettingUi.a(this.mApp, -1010L);
      return;
      bool = false;
      break;
      label153:
      moi.a("0X8007EF3", "");
    }
  }
  
  protected void onCreate(long paramLong, AVActivity paramAVActivity)
  {
    mToolbarInstance = this;
    this.mListView = ((HorizontalListView)this.toolbarView.findViewById(2131367803));
    this.mListView.setStayDisplayOffsetZero(true);
    this.mItemInfo = getList();
    this.mAdapter = new mjk(this.mApp, paramAVActivity, this.mItemInfo, this.mListView);
    this.mAdapter.a(true);
    this.mAdapter.b(true);
    this.mAdapter.a(this.mVoiceClickCallback);
    this.mListView.setAdapter(this.mAdapter);
    this.mEarbackBtn = ((Button)this.toolbarView.findViewById(2131364103));
    this.mEarbackBtn.setTextSize(bdoo.e(aepi.a(12.0F, paramAVActivity.getResources())));
    this.mEarbackBtn.setOnClickListener(this);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.setMargins(mjk.a(paramAVActivity.getResources(), this.mAdapter.a(), 0.1666667F), 0, 0, 0);
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
    setSelectedItem(this.mApp.a().a().T + "");
    updateEarbackBtn();
  }
  
  public void setSelectedItem(String paramString)
  {
    if ((this.mListView == null) || (this.mAdapter == null) || (this.mItemInfo == null)) {
      return;
    }
    int i = 1;
    if (i < this.mItemInfo.size()) {
      if (!((mkj)this.mItemInfo.get(i)).jdField_a_of_type_JavaLangString.equals(paramString)) {}
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
    setSelectedItem(this.mApp.a().a().T + "");
    this.mAdapter.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.VoiceChangeToolbar
 * JD-Core Version:    0.7.0.1
 */