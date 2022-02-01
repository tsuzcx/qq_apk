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
  private IWSPlayerUIDelegate jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerIWSPlayerUIDelegate;
  private WSPlayerParam jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam;
  
  public AbsWSDramaVideoHolder(ViewGroup paramViewGroup, int paramInt1, int paramInt2, WSDramaPageContract.View paramView)
  {
    super(paramViewGroup, paramInt1, paramInt2, paramView);
  }
  
  private int a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    return b(paramstSimpleMetaFeed);
  }
  
  private ImageView a()
  {
    WSDramaItemVideoAreaController localWSDramaItemVideoAreaController = a();
    if (localWSDramaItemVideoAreaController != null) {
      return localWSDramaItemVideoAreaController.a();
    }
    return null;
  }
  
  private WSDramaItemVideoAreaController a()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiIWSItemView instanceof AbsWSDramaVideoItemView)) {
      return ((AbsWSDramaVideoItemView)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiIWSItemView).a();
    }
    return null;
  }
  
  private int b(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    return WSPlayerUtils.b(new WSPlayerUtils.PlayerLayoutParams(a(), a(), paramstSimpleMetaFeed.video.width, paramstSimpleMetaFeed.video.height, a(), b()));
  }
  
  public int a()
  {
    return 0;
  }
  
  public ViewGroup a()
  {
    WSDramaItemVideoAreaController localWSDramaItemVideoAreaController = a();
    if (localWSDramaItemVideoAreaController != null) {
      return localWSDramaItemVideoAreaController.a();
    }
    return null;
  }
  
  public WSPlayerParam a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    WSDramaPageContract.View localView = a();
    if ((localView != null) && (localView.a() != null))
    {
      localView.a().f(a());
      localView.a().e(a());
    }
  }
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt, String paramString)
  {
    if (paramstSimpleMetaFeed == null)
    {
      a(null);
      return;
    }
    if (a() == null) {
      paramString = new WSPlayerParam();
    } else {
      paramString = a();
    }
    IWSPlayerUIDelegate localIWSPlayerUIDelegate = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerIWSPlayerUIDelegate;
    Object localObject = localIWSPlayerUIDelegate;
    if (localIWSPlayerUIDelegate == null) {
      localObject = new WSDramaPlayerUIDelegate(this);
    }
    paramString.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerIWSPlayerUIDelegate = ((IWSPlayerUIDelegate)localObject);
    paramString.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo = WSPlayerUtils.a(paramstSimpleMetaFeed);
    paramString.jdField_a_of_type_AndroidViewViewGroup = a();
    paramString.jdField_a_of_type_Int = a(paramstSimpleMetaFeed);
    paramString.jdField_a_of_type_Long = 0L;
    paramString.jdField_b_of_type_Boolean = true;
    paramString.jdField_b_of_type_Int = paramInt;
    paramString.jdField_a_of_type_JavaLangString = "drama_preview";
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerIWSPlayerUIDelegate = paramString.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerIWSPlayerUIDelegate;
    a(paramString);
  }
  
  public void a(WSDramaItemData paramWSDramaItemData)
  {
    super.a(paramWSDramaItemData);
    WSDramaPageContract.View localView = a();
    if (localView != null) {
      a(paramWSDramaItemData.a(), getLayoutPosition() - 1, localView.a());
    }
  }
  
  public void a(WSPlayerParam paramWSPlayerParam)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam = paramWSPlayerParam;
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public int b()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.holder.AbsWSDramaVideoHolder
 * JD-Core Version:    0.7.0.1
 */