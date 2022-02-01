package com.tencent.biz.pubaccount.NativeAd.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.biz.pubaccount.NativeAd.data.BannerInfo;
import com.tencent.biz.pubaccount.NativeAd.module.AdModuleBase;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.open.downloadnew.DownloadManager;
import java.util.ArrayList;

public class AdModuleAdapter
  extends PagerAdapter
{
  private Context a;
  private String b;
  private String c;
  private String d;
  private int e;
  private BannerInfo f;
  private ArrayList<AdModuleBase> g;
  
  public AdModuleAdapter(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, BannerInfo paramBannerInfo, ArrayList<AdModuleBase> paramArrayList)
  {
    this.a = paramContext;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
    this.e = paramInt;
    this.f = paramBannerInfo;
    this.g = paramArrayList;
  }
  
  public void a()
  {
    Object localObject = this.g;
    localObject = (AdModuleBase)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
    DownloadManager.b().b((DownloadListener)localObject);
    if (((AdModuleBase)localObject).o != null) {
      AppNetConnInfo.unregisterNetInfoHandler(((AdModuleBase)localObject).o);
    }
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramObject = (AdModuleBase)this.g.get(paramInt);
    paramViewGroup.removeView(paramObject.a);
    paramObject.c();
  }
  
  public int getCount()
  {
    ArrayList localArrayList = this.g;
    if (localArrayList != null) {
      return localArrayList.size();
    }
    return 0;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    AdModuleBase localAdModuleBase = (AdModuleBase)this.g.get(paramInt);
    Context localContext = this.a;
    String str1 = this.b;
    String str2 = this.c;
    String str3 = this.d;
    int i = this.e;
    BannerInfo localBannerInfo = this.f;
    int j = getCount();
    boolean bool = true;
    if (paramInt != j - 1) {
      bool = false;
    }
    localAdModuleBase.a = localAdModuleBase.a(localContext, str1, str2, str3, i, localBannerInfo, bool);
    paramViewGroup.addView(localAdModuleBase.a);
    return localAdModuleBase.a;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.adapter.AdModuleAdapter
 * JD-Core Version:    0.7.0.1
 */