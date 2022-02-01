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
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private BannerInfo jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<AdModuleBase> jdField_a_of_type_JavaUtilArrayList;
  private String b;
  private String c;
  
  public AdModuleAdapter(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, BannerInfo paramBannerInfo, ArrayList<AdModuleBase> paramArrayList)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo = paramBannerInfo;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    localObject = (AdModuleBase)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
    DownloadManager.a().b((DownloadListener)localObject);
    if (((AdModuleBase)localObject).jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler != null) {
      AppNetConnInfo.unregisterNetInfoHandler(((AdModuleBase)localObject).jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    }
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramObject = (AdModuleBase)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    paramViewGroup.removeView(paramObject.jdField_a_of_type_AndroidViewView);
    paramObject.c();
  }
  
  public int getCount()
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (localArrayList != null) {
      return localArrayList.size();
    }
    return 0;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    AdModuleBase localAdModuleBase = (AdModuleBase)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    String str1 = this.jdField_a_of_type_JavaLangString;
    String str2 = this.b;
    String str3 = this.c;
    int i = this.jdField_a_of_type_Int;
    BannerInfo localBannerInfo = this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo;
    int j = getCount();
    boolean bool = true;
    if (paramInt != j - 1) {
      bool = false;
    }
    localAdModuleBase.jdField_a_of_type_AndroidViewView = localAdModuleBase.a(localContext, str1, str2, str3, i, localBannerInfo, bool);
    paramViewGroup.addView(localAdModuleBase.jdField_a_of_type_AndroidViewView);
    return localAdModuleBase.jdField_a_of_type_AndroidViewView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.adapter.AdModuleAdapter
 * JD-Core Version:    0.7.0.1
 */