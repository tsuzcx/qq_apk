package com.tencent.biz.pubaccount.weishi_new.verticalvideo.data;

import UserGrowth.stGetCollectionRsp;
import UserGrowth.stSimpleMetaFeed;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.data.IDataFetcher;
import com.tencent.biz.pubaccount.weishi_new.data.IFetchDataRspListener;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSNetService;
import com.tencent.biz.pubaccount.weishi_new.request.newreq.WSCollectionRequest;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class WSCollectionDataFetcher
  implements IDataFetcher<WSCollectionRequestParams, WSVerticalItemData>
{
  public boolean a;
  public boolean b;
  public String c;
  public String d;
  private final HashSet<String> e = new HashSet();
  
  private int a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      return 1;
    }
    if (paramBoolean2) {
      return 3;
    }
    return 2;
  }
  
  private WSCollectionDataFetcher.ResponseModel a(stGetCollectionRsp paramstGetCollectionRsp, WSCollectionRequestParams paramWSCollectionRequestParams)
  {
    boolean bool2 = paramstGetCollectionRsp.isFinished;
    boolean bool1;
    if (paramWSCollectionRequestParams.e == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    a(paramstGetCollectionRsp, paramWSCollectionRequestParams, bool2, bool1);
    Object localObject = paramstGetCollectionRsp.feedList;
    ArrayList localArrayList = new ArrayList();
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)((Iterator)localObject).next();
        if (!this.e.contains(localstSimpleMetaFeed.id))
        {
          this.e.add(localstSimpleMetaFeed.id);
          WSVerticalItemData localWSVerticalItemData = WSVerticalDataUtil.a(localstSimpleMetaFeed);
          localWSVerticalItemData.a(paramstGetCollectionRsp.collection);
          if (paramWSCollectionRequestParams.a) {
            localWSVerticalItemData.a(TextUtils.equals(localstSimpleMetaFeed.id, paramWSCollectionRequestParams.d));
          }
          localArrayList.add(localWSVerticalItemData);
        }
      }
      if (paramWSCollectionRequestParams.a) {
        ((WSVerticalItemData)localArrayList.get(0)).a(true);
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[WSCollectionDataManager.java][handleRspOnSubThread] itemDataList size:");
    ((StringBuilder)localObject).append(localArrayList.size());
    ((StringBuilder)localObject).append(", mIsFinished:");
    ((StringBuilder)localObject).append(bool2);
    WSLog.e("WSCollectionDataFetcher", ((StringBuilder)localObject).toString());
    return new WSCollectionDataFetcher.ResponseModel(localArrayList, paramWSCollectionRequestParams.a, bool1, paramstGetCollectionRsp.attachInfo, bool2);
  }
  
  private void a(stGetCollectionRsp paramstGetCollectionRsp, WSCollectionRequestParams paramWSCollectionRequestParams, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      this.b = paramBoolean1;
      this.d = paramstGetCollectionRsp.attachInfo;
    }
    else
    {
      this.a = paramBoolean1;
      this.c = paramstGetCollectionRsp.attachInfo;
    }
    if (paramWSCollectionRequestParams.a)
    {
      this.d = paramstGetCollectionRsp.attachInfo;
      this.c = paramstGetCollectionRsp.attachInfo;
    }
  }
  
  private boolean a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.b;
    }
    return this.a;
  }
  
  private String b(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.d;
    }
    return this.c;
  }
  
  public boolean a(WSCollectionRequestParams paramWSCollectionRequestParams, IFetchDataRspListener<WSVerticalItemData> paramIFetchDataRspListener)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[WSCollectionDataManager.java][fetchData] params:");
    ((StringBuilder)localObject).append(paramWSCollectionRequestParams.toString());
    WSLog.a("WSCollectionDataFetcher", ((StringBuilder)localObject).toString());
    boolean bool;
    if (paramWSCollectionRequestParams.e == 0) {
      bool = true;
    } else {
      bool = false;
    }
    if (a(bool))
    {
      paramIFetchDataRspListener = new StringBuilder();
      paramIFetchDataRspListener.append("[WSCollectionDataManager.java][fetchData] is finished. isLoadMoreDown = ");
      paramIFetchDataRspListener.append(paramWSCollectionRequestParams.e);
      WSLog.a("WSCollectionDataFetcher", paramIFetchDataRspListener.toString());
      return false;
    }
    localObject = b(bool);
    WSNetService.a(new WSCollectionRequest(paramWSCollectionRequestParams.c, paramWSCollectionRequestParams.d, (String)localObject, 4011, paramWSCollectionRequestParams.e)).a(new WSCollectionDataFetcher.1(this, paramWSCollectionRequestParams, paramIFetchDataRspListener));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSCollectionDataFetcher
 * JD-Core Version:    0.7.0.1
 */