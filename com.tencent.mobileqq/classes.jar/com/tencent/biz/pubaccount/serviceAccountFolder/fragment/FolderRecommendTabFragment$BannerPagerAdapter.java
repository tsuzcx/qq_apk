package com.tencent.biz.pubaccount.serviceAccountFolder.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.together.TogetherControlManager.EntryBannerInfo;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

class FolderRecommendTabFragment$BannerPagerAdapter
  extends PagerAdapter
{
  private List<TogetherControlManager.EntryBannerInfo> a = new ArrayList();
  
  private void b()
  {
    ThreadManager.getUIHandler().post(new FolderRecommendTabFragment.BannerPagerAdapter.2(this));
  }
  
  public List<TogetherControlManager.EntryBannerInfo> a()
  {
    return this.a;
  }
  
  public void a(TogetherControlManager.EntryBannerInfo paramEntryBannerInfo, Context paramContext)
  {
    if (paramEntryBannerInfo != null)
    {
      Intent localIntent;
      if (("1".equals(paramEntryBannerInfo.a)) && (!TextUtils.isEmpty(paramEntryBannerInfo.b)))
      {
        localIntent = new Intent(paramContext, QQBrowserDelegationActivity.class);
        localIntent.putExtra("url", paramEntryBannerInfo.b);
        localIntent.putExtra("fromOneCLickCLose", true);
        paramContext.startActivity(localIntent);
        return;
      }
      if (("2".equals(paramEntryBannerInfo.a)) && (!TextUtils.isEmpty(paramEntryBannerInfo.b)))
      {
        localIntent = new Intent("android.intent.action.VIEW");
        localIntent.setData(Uri.parse(paramEntryBannerInfo.b));
        paramContext.startActivity(localIntent);
      }
    }
  }
  
  public void a(List<TogetherControlManager.EntryBannerInfo> paramList)
  {
    this.a.clear();
    if (paramList != null) {
      this.a.addAll(paramList);
    }
    b();
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if ((paramObject instanceof View)) {
      paramViewGroup.removeView((View)paramObject);
    }
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    View localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131625661, null);
    ImageView localImageView = (ImageView)localView.findViewById(2131429285);
    localImageView.setImageDrawable(URLDrawable.getDrawable(((TogetherControlManager.EntryBannerInfo)this.a.get(paramInt)).c));
    localImageView.setOnClickListener(new FolderRecommendTabFragment.BannerPagerAdapter.1(this, paramInt));
    paramViewGroup.addView(localView);
    return localView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment.BannerPagerAdapter
 * JD-Core Version:    0.7.0.1
 */