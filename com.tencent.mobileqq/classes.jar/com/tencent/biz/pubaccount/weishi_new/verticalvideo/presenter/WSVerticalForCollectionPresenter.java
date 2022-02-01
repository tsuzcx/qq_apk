package com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter;

import UserGrowth.stCollection;
import UserGrowth.stSimpleMetaFeed;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageAdapter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.View;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSCollectionDataFetcher;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSCollectionRequestParams;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataUtil;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.view.VideoFeedsRecyclerView;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WSVerticalForCollectionPresenter
  extends AbsWSVerticalChoiceVideoPresenter
{
  private static final int jdField_b_of_type_Int = ScreenUtil.dip2px(63.0F);
  private final WSCollectionDataFetcher jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSCollectionDataFetcher = new WSCollectionDataFetcher();
  private String jdField_a_of_type_JavaLangString;
  private String jdField_b_of_type_JavaLangString;
  
  public WSVerticalForCollectionPresenter(WSVerticalPageContract.View paramView)
  {
    super(paramView);
  }
  
  private int a(@Nullable String paramString, @NonNull WSVerticalPageAdapter paramWSVerticalPageAdapter)
  {
    if (paramString == null) {
      return -1;
    }
    paramWSVerticalPageAdapter = paramWSVerticalPageAdapter.getDataList();
    if (paramWSVerticalPageAdapter == null) {
      return -1;
    }
    int i = 0;
    while (i < paramWSVerticalPageAdapter.size())
    {
      WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)paramWSVerticalPageAdapter.get(i);
      if (localWSVerticalItemData != null)
      {
        stSimpleMetaFeed localstSimpleMetaFeed = localWSVerticalItemData.a();
        if ((localstSimpleMetaFeed != null) && (paramString.equals(localstSimpleMetaFeed.id)))
        {
          localWSVerticalItemData.a(true);
          return i;
        }
      }
      i += 1;
    }
    return -1;
  }
  
  private String a(int paramInt)
  {
    if ((paramInt >= 0) && (a() != null))
    {
      WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)a().getItem(paramInt);
      if (localWSVerticalItemData != null) {
        return localWSVerticalItemData.a().id;
      }
    }
    return this.jdField_b_of_type_JavaLangString;
  }
  
  @NonNull
  private Map<String, String> c()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("collection_id", this.jdField_a_of_type_JavaLangString);
    localHashMap.put("ref_feedid", c());
    stCollection localstCollection = WSVerticalDataUtil.a(a(0));
    if (localstCollection == null) {
      return localHashMap;
    }
    localHashMap.put("collection_id", localstCollection.cid);
    localHashMap.put("collection_type", String.valueOf(localstCollection.collectionType));
    return localHashMap;
  }
  
  public String a()
  {
    if ((a() != null) && (a().a() != null))
    {
      if (a().getItem(0) == null) {
        return "";
      }
      WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)a().a().getItem(0);
      if (localWSVerticalItemData.a() == null) {
        return "";
      }
      return localWSVerticalItemData.a().name;
    }
    return "";
  }
  
  public List<WSVerticalItemData> a(ArrayList paramArrayList)
  {
    return null;
  }
  
  public Map<String, String> a(WSVerticalItemData paramWSVerticalItemData)
  {
    Map localMap = super.a(paramWSVerticalItemData);
    localMap.put("cover_feedid", paramWSVerticalItemData.a().id);
    return localMap;
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (paramBundle == null) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("key_collection_id", "");
    this.jdField_b_of_type_JavaLangString = paramBundle.getString("key_feed_id", "");
  }
  
  protected boolean a(String paramString)
  {
    boolean bool = false;
    paramString = a(0);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      WSCollectionRequestParams localWSCollectionRequestParams = new WSCollectionRequestParams();
      localWSCollectionRequestParams.jdField_a_of_type_Int = 1;
      localWSCollectionRequestParams.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      localWSCollectionRequestParams.jdField_a_of_type_Boolean = false;
      localWSCollectionRequestParams.jdField_b_of_type_Boolean = true;
      localWSCollectionRequestParams.jdField_b_of_type_JavaLangString = paramString;
      bool = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSCollectionDataFetcher.a(localWSCollectionRequestParams, this);
    }
    return bool;
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    paramString = a(a().getItemCount() - 1);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      WSCollectionRequestParams localWSCollectionRequestParams = new WSCollectionRequestParams();
      localWSCollectionRequestParams.jdField_b_of_type_Boolean = paramBoolean1;
      localWSCollectionRequestParams.jdField_a_of_type_Boolean = paramBoolean2;
      localWSCollectionRequestParams.jdField_a_of_type_Int = 0;
      localWSCollectionRequestParams.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      localWSCollectionRequestParams.jdField_b_of_type_JavaLangString = paramString;
      return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSCollectionDataFetcher.a(localWSCollectionRequestParams, this);
    }
    return false;
  }
  
  public int b()
  {
    return jdField_b_of_type_Int;
  }
  
  public Map<String, String> b()
  {
    Map localMap = super.b();
    localMap.putAll(c());
    return localMap;
  }
  
  public String c()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void c()
  {
    super.c();
  }
  
  protected void c(List<WSVerticalItemData> paramList, boolean paramBoolean1, boolean paramBoolean2, Object paramObject)
  {
    super.c(paramList, paramBoolean1, paramBoolean2, paramObject);
    if (paramBoolean2)
    {
      int i = a(this.jdField_b_of_type_JavaLangString, a());
      if ((i != -1) && (a() != null) && (a().a() != null)) {
        a().a().scrollToPosition(i);
      }
    }
  }
  
  public boolean e()
  {
    WSCollectionDataFetcher localWSCollectionDataFetcher = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSCollectionDataFetcher;
    return (localWSCollectionDataFetcher == null) || (localWSCollectionDataFetcher.jdField_b_of_type_Boolean);
  }
  
  public boolean f()
  {
    WSCollectionDataFetcher localWSCollectionDataFetcher = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSCollectionDataFetcher;
    return (localWSCollectionDataFetcher == null) || (localWSCollectionDataFetcher.jdField_a_of_type_Boolean);
  }
  
  protected boolean g()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.WSVerticalForCollectionPresenter
 * JD-Core Version:    0.7.0.1
 */