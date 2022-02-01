package com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter;

import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.data.FetcherParams;
import com.tencent.biz.pubaccount.weishi_new.data.IFetchDataRspListener;
import com.tencent.biz.pubaccount.weishi_new.profile.data.WSIShareDataFetcher;
import com.tencent.biz.pubaccount.weishi_new.profile.data.WSProfileFeedsRequestParams;
import com.tencent.biz.pubaccount.weishi_new.profile.data.WSShareFeedDataManager;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.View;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.mobileqq.app.QBaseActivity;
import java.util.ArrayList;
import java.util.List;

public class WSVerticalForProfilePresenter
  extends AbsWSVerticalPagePresenter
{
  private IFetchDataRspListener<WSVerticalItemData> a;
  private int b;
  private String i;
  
  public WSVerticalForProfilePresenter(WSVerticalPageContract.View paramView)
  {
    super(paramView);
  }
  
  private IFetchDataRspListener<WSVerticalItemData> a(IFetchDataRspListener<WSVerticalItemData> paramIFetchDataRspListener)
  {
    IFetchDataRspListener localIFetchDataRspListener = this.a;
    if (localIFetchDataRspListener != null) {
      return localIFetchDataRspListener;
    }
    this.a = new WSVerticalForProfilePresenter.1(this, paramIFetchDataRspListener);
    return this.a;
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = new ArrayList();
    localObject = new WSProfileFeedsRequestParams(paramBoolean2, paramBoolean1, this.i, (ArrayList)localObject, 10014, this.b);
    WSShareFeedDataManager.a().a(v(), u()).a((FetcherParams)localObject);
  }
  
  private String u()
  {
    WSVerticalPageContract.View localView = z();
    if (localView != null) {
      return localView.p();
    }
    return "";
  }
  
  private String v()
  {
    WSVerticalPageContract.View localView = z();
    boolean bool = localView instanceof WSVerticalPageFragment;
    String str = "works_in_profile";
    if (bool)
    {
      this.b = ((WSVerticalPageFragment)localView).getArguments().getInt("page_type", 1);
      if (this.b == 1) {
        return "works_in_profile";
      }
      str = "praise_in_profile";
    }
    return str;
  }
  
  public int a(int paramInt)
  {
    return paramInt + 1;
  }
  
  public List<WSVerticalItemData> a(ArrayList paramArrayList)
  {
    return WSShareFeedDataManager.a().a(v(), u()).a();
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (paramBundle == null) {
      return;
    }
    this.b = paramBundle.getInt("page_type", 1);
    this.i = paramBundle.getString("person_id");
  }
  
  protected void b(String paramString, WSVerticalPageFragment paramWSVerticalPageFragment, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (!TextUtils.equals(this.i, paramstSimpleMetaFeed.poster.id))
    {
      super.b(paramString, paramWSVerticalPageFragment, paramstSimpleMetaFeed);
      return;
    }
    if ((paramWSVerticalPageFragment != null) && (paramWSVerticalPageFragment.getQBaseActivity() != null))
    {
      paramWSVerticalPageFragment.getQBaseActivity().doOnBackPressed();
      a(paramString, paramWSVerticalPageFragment, paramstSimpleMetaFeed, 2);
    }
  }
  
  public boolean b(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (paramBoolean2) {
      return false;
    }
    a(paramBoolean1, false);
    return true;
  }
  
  public void d()
  {
    super.d();
    WSShareFeedDataManager.a().a(v(), u()).a(a(this));
  }
  
  public void h()
  {
    super.h();
    WSShareFeedDataManager.a().a(v(), u()).b(a(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.WSVerticalForProfilePresenter
 * JD-Core Version:    0.7.0.1
 */