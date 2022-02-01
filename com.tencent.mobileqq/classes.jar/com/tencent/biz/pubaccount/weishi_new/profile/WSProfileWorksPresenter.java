package com.tencent.biz.pubaccount.weishi_new.profile;

import com.tencent.biz.pubaccount.weishi_new.data.IFetchDataRspListener;
import com.tencent.biz.pubaccount.weishi_new.presenter.WSBasePresenter;
import com.tencent.biz.pubaccount.weishi_new.profile.data.WSIShareDataFetcher;
import com.tencent.biz.pubaccount.weishi_new.profile.data.WSProfileFeedsRequestParams;
import com.tencent.biz.pubaccount.weishi_new.profile.data.WSShareFeedDataManager;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import java.util.ArrayList;

public class WSProfileWorksPresenter
  extends WSBasePresenter<WSProfileWorksContract.View>
{
  private IFetchDataRspListener<WSVerticalItemData> a;
  private boolean b;
  private String c;
  
  private String c()
  {
    WSProfileWorksContract.View localView = (WSProfileWorksContract.View)getView();
    if (localView == null) {
      return "works_in_profile";
    }
    if (localView.b() == 1) {
      return "works_in_profile";
    }
    return "praise_in_profile";
  }
  
  private IFetchDataRspListener<WSVerticalItemData> d()
  {
    IFetchDataRspListener localIFetchDataRspListener = this.a;
    if (localIFetchDataRspListener != null) {
      return localIFetchDataRspListener;
    }
    this.a = new WSProfileWorksPresenter.1(this);
    return this.a;
  }
  
  public String a()
  {
    return String.valueOf(hashCode());
  }
  
  public void a(WSProfileWorksContract.View paramView)
  {
    super.attachView(paramView);
    WSShareFeedDataManager.a().a(c(), a()).a(d());
  }
  
  public void a(String paramString)
  {
    this.c = paramString;
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      ((WSProfileWorksContract.View)getView()).r();
    }
    this.c = paramString;
    paramString = new WSProfileFeedsRequestParams(paramBoolean1, paramBoolean2, paramString, new ArrayList(), 10019, paramInt);
    WSShareFeedDataManager.a().a(c(), a()).a(paramString);
  }
  
  public void b()
  {
    WSShareFeedDataManager.a().a(c(), a()).b();
  }
  
  public void detachView()
  {
    super.detachView();
    WSShareFeedDataManager.a().a(c(), a()).b(d());
    WSShareFeedDataManager.a().b(c(), a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.profile.WSProfileWorksPresenter
 * JD-Core Version:    0.7.0.1
 */