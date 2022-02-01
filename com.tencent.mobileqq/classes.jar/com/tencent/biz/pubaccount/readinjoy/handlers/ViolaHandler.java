package com.tencent.biz.pubaccount.readinjoy.handlers;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaAccessHelper;
import com.tencent.biz.pubaccount.readinjoy.viola.wormhole.Wormhole;
import com.tencent.biz.pubaccount.readinjoy.viola.wormhole.WormholeView;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.core.ViolaDomManager;
import com.tencent.viola.core.ViolaSDKManager;
import com.tencent.widget.AbsListView;
import cooperation.readinjoy.ReadInJoyHelper;

public class ViolaHandler
  extends BaseHandler
{
  private Wormhole a = new Wormhole();
  
  private void a(BaseArticleInfo paramBaseArticleInfo)
  {
    ViolaSDKManager.getInstance().getDomManager().post(new ViolaHandler.1(this, paramBaseArticleInfo));
  }
  
  public int a()
  {
    return 4;
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560505, paramViewGroup, false);
      localView.setTag(new ViolaHandler.ViolaWormholeViewHolder(this.a, (WormholeView)localView, this));
    }
    paramView = (ViolaHandler.ViolaWormholeViewHolder)localView.getTag();
    paramViewGroup = a(paramInt);
    if ((paramViewGroup instanceof BaseArticleInfo))
    {
      paramViewGroup = (BaseArticleInfo)paramViewGroup;
      paramView.a(paramInt);
      paramView.a(paramViewGroup);
      paramView.a(paramViewGroup, paramInt);
    }
    return localView;
  }
  
  public void a(Context paramContext, ArticleInfo paramArticleInfo, String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString)) {
      if (Boolean.valueOf(ReadInJoyHelper.w(ReadInJoyUtils.a())).booleanValue()) {
        ViolaAccessHelper.a(paramContext, "", "https://viola.qq.com/js/kd_pic_detail.js?_rij_violaUrl=1&v_tid=15&v_bid=3811&v_bundleName=kd_pic_detail&hideNav=1&v_nav_immer=1&v_minVersion=8.0.8&v_from_native=1&album_source=" + paramInt + "&rowkey=" + paramString, null);
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        ReadInJoyLogicEngine.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
        a().notifyDataSetChanged();
        ReadinjoyReportUtils.a(paramArticleInfo);
        return;
        if (QLog.isColorLevel()) {
          QLog.e("ViolaHandler", 2, "jumpToGallery failed: isShowViolaPage is false");
        }
      }
    }
    QLog.e("ViolaHandler", 2, "rowKey is empty");
  }
  
  public void a(View paramView1, View paramView2, BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    a(paramBaseArticleInfo);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt) {}
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a != null) {
      this.a.a(paramAbsListView);
    }
  }
  
  public boolean a(int paramInt)
  {
    return paramInt == 136;
  }
  
  public void e()
  {
    if (this.a != null) {
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.handlers.ViolaHandler
 * JD-Core Version:    0.7.0.1
 */