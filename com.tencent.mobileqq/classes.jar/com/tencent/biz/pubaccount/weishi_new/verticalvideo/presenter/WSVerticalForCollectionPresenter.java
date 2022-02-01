package com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter;

import UserGrowth.stCollection;
import UserGrowth.stSimpleMetaFeed;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.View;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSCollectionDataManager;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import java.util.ArrayList;
import java.util.List;

public class WSVerticalForCollectionPresenter
  extends AbsWSVerticalPagePresenter
{
  private static final int b = ScreenUtil.dip2px(63.0F);
  private stSimpleMetaFeed a;
  
  public WSVerticalForCollectionPresenter(WSVerticalPageContract.View paramView)
  {
    super(paramView);
  }
  
  public List<WSVerticalItemData> a(ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0) && ((paramArrayList.get(0) instanceof stSimpleMetaFeed))) {
      this.a = ((stSimpleMetaFeed)paramArrayList.get(0));
    }
    return null;
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if ((this.a != null) && (this.a.collection != null) && (!TextUtils.isEmpty(this.a.collection.cid)))
    {
      WSCollectionDataManager.a().a(paramBoolean2, paramBoolean1, this.a.collection.cid, 2, this);
      return true;
    }
    return false;
  }
  
  public int b()
  {
    return b;
  }
  
  protected boolean b()
  {
    return true;
  }
  
  public void d()
  {
    super.d();
    WSCollectionDataManager.a().a();
  }
  
  public void e()
  {
    super.e();
    WSVerticalPageContract.View localView = a();
    if ((localView != null) && (this.a != null) && (this.a.collection != null)) {
      localView.b(this.a.collection);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.WSVerticalForCollectionPresenter
 * JD-Core Version:    0.7.0.1
 */