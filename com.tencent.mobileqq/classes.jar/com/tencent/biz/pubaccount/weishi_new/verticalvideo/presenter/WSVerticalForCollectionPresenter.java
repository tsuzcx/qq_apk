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
  private static final int a = ScreenUtil.dip2px(63.0F);
  private String b;
  private String i;
  private final WSCollectionDataFetcher j = new WSCollectionDataFetcher();
  
  public WSVerticalForCollectionPresenter(WSVerticalPageContract.View paramView)
  {
    super(paramView);
  }
  
  @NonNull
  private Map<String, String> O()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("collection_id", this.b);
    localHashMap.put("ref_feedid", y());
    stCollection localstCollection = WSVerticalDataUtil.b(b(0));
    if (localstCollection == null) {
      return localHashMap;
    }
    localHashMap.put("collection_id", localstCollection.cid);
    localHashMap.put("collection_type", String.valueOf(localstCollection.collectionType));
    return localHashMap;
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
    int k = 0;
    while (k < paramWSVerticalPageAdapter.size())
    {
      WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)paramWSVerticalPageAdapter.get(k);
      if (localWSVerticalItemData != null)
      {
        stSimpleMetaFeed localstSimpleMetaFeed = localWSVerticalItemData.b();
        if ((localstSimpleMetaFeed != null) && (paramString.equals(localstSimpleMetaFeed.id)))
        {
          localWSVerticalItemData.a(true);
          return k;
        }
      }
      k += 1;
    }
    return -1;
  }
  
  private String d(int paramInt)
  {
    if ((paramInt >= 0) && (J() != null))
    {
      WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)J().getItem(paramInt);
      if (localWSVerticalItemData != null) {
        return localWSVerticalItemData.b().id;
      }
    }
    return this.i;
  }
  
  protected boolean B()
  {
    return true;
  }
  
  public List<WSVerticalItemData> a(ArrayList paramArrayList)
  {
    return null;
  }
  
  public Map<String, String> a(WSVerticalItemData paramWSVerticalItemData)
  {
    Map localMap = super.a(paramWSVerticalItemData);
    localMap.put("cover_feedid", paramWSVerticalItemData.b().id);
    return localMap;
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (paramBundle == null) {
      return;
    }
    this.b = paramBundle.getString("key_collection_id", "");
    this.i = paramBundle.getString("key_feed_id", "");
  }
  
  public boolean b(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    paramString = d(J().getItemCount() - 1);
    if (!TextUtils.isEmpty(this.b))
    {
      WSCollectionRequestParams localWSCollectionRequestParams = new WSCollectionRequestParams();
      localWSCollectionRequestParams.b = paramBoolean1;
      localWSCollectionRequestParams.a = paramBoolean2;
      localWSCollectionRequestParams.e = 0;
      localWSCollectionRequestParams.c = this.b;
      localWSCollectionRequestParams.d = paramString;
      return this.j.a(localWSCollectionRequestParams, this);
    }
    return false;
  }
  
  public int c()
  {
    return a;
  }
  
  protected void c(List<WSVerticalItemData> paramList, boolean paramBoolean1, boolean paramBoolean2, Object paramObject)
  {
    super.c(paramList, paramBoolean1, paramBoolean2, paramObject);
    if (paramBoolean2)
    {
      int k = a(this.i, J());
      if ((k != -1) && (z() != null) && (z().c() != null)) {
        z().c().scrollToPosition(k);
      }
    }
  }
  
  protected boolean c(String paramString)
  {
    boolean bool = false;
    paramString = d(0);
    if (!TextUtils.isEmpty(this.b))
    {
      WSCollectionRequestParams localWSCollectionRequestParams = new WSCollectionRequestParams();
      localWSCollectionRequestParams.e = 1;
      localWSCollectionRequestParams.c = this.b;
      localWSCollectionRequestParams.a = false;
      localWSCollectionRequestParams.b = true;
      localWSCollectionRequestParams.d = paramString;
      bool = this.j.a(localWSCollectionRequestParams, this);
    }
    return bool;
  }
  
  public Map<String, String> n()
  {
    Map localMap = super.n();
    localMap.putAll(O());
    return localMap;
  }
  
  public boolean u()
  {
    WSCollectionDataFetcher localWSCollectionDataFetcher = this.j;
    return (localWSCollectionDataFetcher == null) || (localWSCollectionDataFetcher.b);
  }
  
  public boolean v()
  {
    WSCollectionDataFetcher localWSCollectionDataFetcher = this.j;
    return (localWSCollectionDataFetcher == null) || (localWSCollectionDataFetcher.a);
  }
  
  public String w()
  {
    if ((z() != null) && (z().b() != null))
    {
      if (J().getItem(0) == null) {
        return "";
      }
      WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)z().b().getItem(0);
      if (localWSVerticalItemData.h() == null) {
        return "";
      }
      return localWSVerticalItemData.h().name;
    }
    return "";
  }
  
  public String y()
  {
    return this.i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.WSVerticalForCollectionPresenter
 * JD-Core Version:    0.7.0.1
 */