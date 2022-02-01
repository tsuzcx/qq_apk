package com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter;

import UserGrowth.stCollection;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.View;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSCollectionDataManager;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import java.util.ArrayList;
import java.util.List;

public class WSVerticalForCollectionFromCardPresenter
  extends AbsWSVerticalPagePresenter
{
  private static final int b = ScreenUtil.dip2px(63.0F);
  private stCollection a;
  
  public WSVerticalForCollectionFromCardPresenter(WSVerticalPageContract.View paramView)
  {
    super(paramView);
  }
  
  public List<WSVerticalItemData> a(ArrayList paramArrayList)
  {
    return null;
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (paramBundle == null) {
      return;
    }
    this.a = ((stCollection)paramBundle.getSerializable("key_collection"));
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if ((this.a != null) && (!TextUtils.isEmpty(this.a.cid)))
    {
      WSCollectionDataManager.a().a(paramBoolean2, paramBoolean1, this.a.cid, 2, this);
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
    WSReportUtils.b();
    WSVerticalBeaconReport.b("");
  }
  
  public void e()
  {
    super.e();
    WSVerticalPageContract.View localView = a();
    if ((localView != null) && (this.a != null)) {
      localView.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.WSVerticalForCollectionFromCardPresenter
 * JD-Core Version:    0.7.0.1
 */