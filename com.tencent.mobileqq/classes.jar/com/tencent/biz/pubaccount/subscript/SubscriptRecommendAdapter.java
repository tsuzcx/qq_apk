package com.tencent.biz.pubaccount.subscript;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class SubscriptRecommendAdapter
  extends BaseAdapter
  implements DecodeTaskCompletionListener
{
  Activity a;
  public IFaceDecoder b;
  protected List<SubscriptRecommendAccountInfo> c = null;
  QQAppInterface d = null;
  boolean e = false;
  boolean f = false;
  private SubscriptPicManager g;
  
  public SubscriptRecommendAdapter(Activity paramActivity, QQAppInterface paramQQAppInterface, SubscriptPicManager paramSubscriptPicManager)
  {
    this.a = paramActivity;
    this.c = new ArrayList(11);
    this.b = ((IQQAvatarService)paramQQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(paramQQAppInterface);
    this.b.setDecodeTaskCompletionListener(this);
    this.d = paramQQAppInterface;
    this.g = paramSubscriptPicManager;
    this.e = ThemeUtil.isInNightMode(paramQQAppInterface);
    if (Build.MANUFACTURER.toUpperCase().equals("XIAOMI")) {
      this.f = true;
    }
  }
  
  public void a()
  {
    this.c.clear();
  }
  
  public void a(SubscriptRecommendAccountInfo paramSubscriptRecommendAccountInfo)
  {
    if (paramSubscriptRecommendAccountInfo != null) {
      this.c.add(paramSubscriptRecommendAccountInfo);
    }
  }
  
  public void a(List<SubscriptRecommendAccountInfo> paramList)
  {
    if (paramList != null)
    {
      int j = paramList.size();
      int i = 10;
      if (j < 10) {
        i = paramList.size();
      }
      j = 0;
      while (j < i)
      {
        a((SubscriptRecommendAccountInfo)paramList.get(j));
        j += 1;
      }
      paramList = new SubscriptRecommendAccountInfo();
      paramList.a = -1L;
      a(paramList);
    }
  }
  
  public void b()
  {
    this.b.setDecodeTaskCompletionListener(null);
  }
  
  public int getCount()
  {
    List localList = this.c;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.c != null) && (paramInt <= getCount()) && (paramInt >= 0)) {
      return this.c.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = this.a.getLayoutInflater().inflate(2131626448, null);
      paramView = new SubscriptRecommendAdapter.RecommendItem(this, localView, this.e);
      localView.setVisibility(0);
      localView.setFocusable(false);
      localView.setTag(paramView);
    }
    else
    {
      SubscriptRecommendAdapter.RecommendItem localRecommendItem = (SubscriptRecommendAdapter.RecommendItem)paramView.getTag();
      localView = paramView;
      paramView = localRecommendItem;
    }
    paramView.a((SubscriptRecommendAccountInfo)this.c.get(paramInt), paramInt);
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptRecommendAdapter
 * JD-Core Version:    0.7.0.1
 */