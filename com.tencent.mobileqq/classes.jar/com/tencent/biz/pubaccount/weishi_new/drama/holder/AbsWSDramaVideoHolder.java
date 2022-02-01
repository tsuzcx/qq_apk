package com.tencent.biz.pubaccount.weishi_new.drama.holder;

import NS_KING_SOCIALIZE_META.stMetaUgcVideoSeg;
import UserGrowth.stSimpleMetaFeed;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.weishi_new.drama.WSDramaPageContract.View;
import com.tencent.biz.pubaccount.weishi_new.drama.WSDramaPlayerUIDelegate;
import com.tencent.biz.pubaccount.weishi_new.drama.data.WSDramaItemData;
import com.tencent.biz.pubaccount.weishi_new.drama.holder.controller.WSDramaItemVideoAreaController;
import com.tencent.biz.pubaccount.weishi_new.player.IWSPlayerUIDelegate;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerParam;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerUtils;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerUtils.PlayerLayoutParams;

public abstract class AbsWSDramaVideoHolder
  extends AbsWSDramaHolder
{
  private WSPlayerParam d;
  private IWSPlayerUIDelegate e;
  
  public AbsWSDramaVideoHolder(ViewGroup paramViewGroup, int paramInt1, int paramInt2, WSDramaPageContract.View paramView)
  {
    super(paramViewGroup, paramInt1, paramInt2, paramView);
  }
  
  private int a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    return b(paramstSimpleMetaFeed);
  }
  
  private int b(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    return WSPlayerUtils.b(new WSPlayerUtils.PlayerLayoutParams(f(), g(), paramstSimpleMetaFeed.video.width, paramstSimpleMetaFeed.video.height, c(), d()));
  }
  
  private ImageView g()
  {
    WSDramaItemVideoAreaController localWSDramaItemVideoAreaController = h();
    if (localWSDramaItemVideoAreaController != null) {
      return localWSDramaItemVideoAreaController.m();
    }
    return null;
  }
  
  private WSDramaItemVideoAreaController h()
  {
    if ((this.b instanceof AbsWSDramaVideoItemView)) {
      return ((AbsWSDramaVideoItemView)this.b).e();
    }
    return null;
  }
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt, String paramString)
  {
    if (paramstSimpleMetaFeed == null)
    {
      a(null);
      return;
    }
    if (e() == null) {
      paramString = new WSPlayerParam();
    } else {
      paramString = e();
    }
    IWSPlayerUIDelegate localIWSPlayerUIDelegate = this.e;
    Object localObject = localIWSPlayerUIDelegate;
    if (localIWSPlayerUIDelegate == null) {
      localObject = new WSDramaPlayerUIDelegate(this);
    }
    paramString.k = ((IWSPlayerUIDelegate)localObject);
    paramString.c = WSPlayerUtils.a(paramstSimpleMetaFeed);
    paramString.a = f();
    paramString.e = a(paramstSimpleMetaFeed);
    paramString.g = 0L;
    paramString.i = true;
    paramString.f = paramInt;
    paramString.j = "drama_preview";
    this.e = paramString.k;
    a(paramString);
  }
  
  public void a(WSDramaItemData paramWSDramaItemData)
  {
    super.a(paramWSDramaItemData);
    WSDramaPageContract.View localView = a();
    if (localView != null) {
      a(paramWSDramaItemData.i(), getLayoutPosition() - 1, localView.b());
    }
  }
  
  public void a(WSPlayerParam paramWSPlayerParam)
  {
    this.d = paramWSPlayerParam;
  }
  
  public void b(int paramInt)
  {
    super.b(paramInt);
    WSDramaPageContract.View localView = a();
    if ((localView != null) && (localView.aK_() != null))
    {
      localView.aK_().f(b());
      localView.aK_().e(b());
    }
  }
  
  protected boolean b()
  {
    return false;
  }
  
  public int c()
  {
    return 0;
  }
  
  public int d()
  {
    return 0;
  }
  
  public WSPlayerParam e()
  {
    return this.d;
  }
  
  public ViewGroup f()
  {
    WSDramaItemVideoAreaController localWSDramaItemVideoAreaController = h();
    if (localWSDramaItemVideoAreaController != null) {
      return localWSDramaItemVideoAreaController.l();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.holder.AbsWSDramaVideoHolder
 * JD-Core Version:    0.7.0.1
 */