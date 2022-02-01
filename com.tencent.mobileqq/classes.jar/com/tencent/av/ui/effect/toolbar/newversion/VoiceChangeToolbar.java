package com.tencent.av.ui.effect.toolbar.newversion;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.material.EffectMaterialManager;
import com.tencent.av.tips.TipsUtil;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.QavListItemBase.ItemInfo;
import com.tencent.av.ui.VoiceChangeData;
import com.tencent.av.ui.VoiceChangeData.VoiceInfo;
import com.tencent.av.ui.VoiceChangeDataReport;
import com.tencent.av.ui.effect.adapter.MaterialAdapter;
import com.tencent.av.ui.effect.interfaces.IEffectCallback;
import com.tencent.av.ui.effect.toolbar.BaseToolbar;
import com.tencent.av.ui.effect.toolbar.BaseToolbar.UIInfo;
import com.tencent.av.ui.effect.view.MaterialRecyclerView;
import com.tencent.av.utils.AVUtil;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class VoiceChangeToolbar
  extends BaseToolbarNewVersion
  implements View.OnClickListener
{
  public static final String TAG = "VoiceChangeToolbar";
  MaterialAdapter mAdapter;
  ArrayList<QavListItemBase.ItemInfo> mItemInfo;
  private EffectMaterialManager mMaterialManager;
  MaterialRecyclerView mRecyclerView;
  private BaseToolbar.UIInfo mUIInfo;
  Button mVoiceChangeBtn = null;
  IEffectCallback mVoiceClickCallback = new VoiceChangeToolbar.1(this);
  
  public VoiceChangeToolbar(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity)
  {
    super(paramVideoAppInterface, paramAVActivity);
  }
  
  private ArrayList<QavListItemBase.ItemInfo> getList()
  {
    VoiceChangeData.VoiceInfo[] arrayOfVoiceInfo = VoiceChangeData.a().b();
    int j = 0;
    int i;
    if (arrayOfVoiceInfo == null) {
      i = 0;
    } else {
      i = arrayOfVoiceInfo.length;
    }
    ArrayList localArrayList = new ArrayList(i);
    if (arrayOfVoiceInfo != null)
    {
      i = j;
      while (i < arrayOfVoiceInfo.length)
      {
        VoiceChangeData.VoiceInfo localVoiceInfo = arrayOfVoiceInfo[i];
        QavListItemBase.ItemInfo localItemInfo = new QavListItemBase.ItemInfo();
        localItemInfo.f = 2;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localVoiceInfo.d);
        localStringBuilder.append("");
        localItemInfo.a = localStringBuilder.toString();
        localItemInfo.c = localVoiceInfo.a;
        localItemInfo.b = localVoiceInfo.b;
        localItemInfo.g = localVoiceInfo.e;
        localItemInfo.k = localVoiceInfo.a;
        localItemInfo.d = true;
        localItemInfo.m = localVoiceInfo;
        localItemInfo.n = ("0".equals(localItemInfo.a) ^ true);
        localArrayList.add(localItemInfo);
        i += 1;
      }
    }
    return localArrayList;
  }
  
  private void setLastItem()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.mApp.b().k().cr);
    ((StringBuilder)localObject).append("");
    localObject = ((StringBuilder)localObject).toString();
    this.mMaterialManager.g((String)localObject);
    this.mMaterialManager.n();
  }
  
  private void updateVoiceChangeBtn()
  {
    int i;
    if (this.mApp.b().k().bX) {
      i = 2130843329;
    } else {
      i = 2130843328;
    }
    this.mVoiceChangeBtn.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
  }
  
  protected BaseToolbar.UIInfo getUIInfo()
  {
    if (this.mUIInfo == null)
    {
      this.mUIInfo = new BaseToolbar.UIInfo();
      BaseToolbar.UIInfo localUIInfo = this.mUIInfo;
      localUIInfo.d = 5;
      localUIInfo.h = 2131625733;
      localUIInfo.f = 2130843308;
      localUIInfo.g = this.mApp.getApp().getString(2131893690);
    }
    return this.mUIInfo;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131430484)
    {
      this.mApp.b().k().bX ^= true;
      if (this.mApp.b().k().cr != 0) {
        this.mApp.b().k(this.mApp.b().k().bX);
      }
      updateVoiceChangeBtn();
      if (!this.mApp.b().k().bX)
      {
        TipsUtil.a(this.mApp, 1017);
        VoiceChangeDataReport.a("0X8007EF4", "");
      }
      else
      {
        VoiceChangeDataReport.a("0X8007EF3", "");
        ReportController.b(null, "dc00898", "", "", "0X800BC15", "0X800BC15", AVUtil.c(), 0, "", "", "", "");
      }
      BaseToolbar.keepInToolbar(this.mApp, -1010L);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onCreate(long paramLong, AVActivity paramAVActivity)
  {
    this.mMaterialManager = ((EffectMaterialManager)this.mApp.c(15));
    this.mRecyclerView = ((MaterialRecyclerView)this.toolbarView.findViewById(2131438907));
    this.mItemInfo = getList();
    this.mAdapter = new MaterialAdapter(this.mApp, paramAVActivity, this.mItemInfo, this.mRecyclerView, 4, false);
    this.mRecyclerView.setAdapter(this.mAdapter);
    this.mAdapter.a(this.mVoiceClickCallback);
    this.mVoiceChangeBtn = ((Button)this.toolbarView.findViewById(2131430484));
    this.mVoiceChangeBtn.setTextSize(ViewUtils.pxTosp(AIOUtils.b(12.0F, paramAVActivity.getResources())));
    this.mVoiceChangeBtn.setOnClickListener(this);
    this.mMaterialManager.g(null);
  }
  
  protected void onDestroy(long paramLong, VideoAppInterface paramVideoAppInterface)
  {
    this.mMaterialManager.g(null);
  }
  
  protected void onShow(long paramLong, int paramInt, boolean paramBoolean)
  {
    updateVoiceChangeBtn();
    setLastItem();
    AVUtil.f(102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.effect.toolbar.newversion.VoiceChangeToolbar
 * JD-Core Version:    0.7.0.1
 */