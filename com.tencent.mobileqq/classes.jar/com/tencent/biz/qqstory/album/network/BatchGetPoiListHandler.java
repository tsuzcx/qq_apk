package com.tencent.biz.qqstory.album.network;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.album.StoryScanManager;
import com.tencent.biz.qqstory.album.model.GeoHashPhotoGroup;
import com.tencent.biz.qqstory.album.tools.GeoHashUtils.Gps;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.item.AddressItem;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.GpsMsg;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.PBInt32Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class BatchGetPoiListHandler
  implements CmdTaskManger.CommandCallback<BatchGetPoiListRequest, BatchGetPoiListRequest.BatchGetPoiListResponse>
{
  private HashMap<String, GeoHashPhotoGroup> a;
  private BatchGetPoiListHandler.BatchGetPOIListener b;
  private List<BatchGetPoiListRequest> c = new ArrayList();
  private long d;
  private ErrorMessage e;
  private HashMap<String, AddressItem> f = new HashMap();
  
  private void b()
  {
    if (this.c.size() == 0)
    {
      SLog.d("Q.qqstory.recommendAlbum.logic.BatchGetPoiListHandler", "handleResult. all request has finish timecost=%s, errorInfo=%s", new Object[] { Long.valueOf(SystemClock.uptimeMillis() - this.d), this.e });
      BatchGetPoiListHandler.BatchGetPOIListener localBatchGetPOIListener = this.b;
      if (localBatchGetPOIListener != null) {
        localBatchGetPOIListener.a(this.e, this.f);
      }
    }
  }
  
  public void a()
  {
    Object localObject1 = this.a;
    if ((localObject1 != null) && (((HashMap)localObject1).size() != 0)) {}
    for (;;)
    {
      int j;
      int i;
      try
      {
        this.d = SystemClock.uptimeMillis();
        localObject1 = StoryScanManager.a(this.a);
        if (((List)localObject1).size() == 0)
        {
          if (this.b != null) {
            this.b.a(new ErrorMessage(-1, "BatchGetPoiListHandler gps error"), null);
          }
          return;
        }
        j = ((List)localObject1).size() / 100;
        i = j;
        if (((List)localObject1).size() % 100 <= 0) {
          break label300;
        }
        i = j + 1;
      }
      finally {}
      if (j < i)
      {
        int m = j * 100;
        int k = m + 100;
        if (k > ((List)localObject1).size()) {
          k = ((List)localObject1).size();
        }
        SLog.d("Q.qqstory.recommendAlbum.logic.BatchGetPoiListHandler", "send last batch length=%d", new Object[] { Integer.valueOf(k - m) });
        List localList = ((List)localObject1).subList(m, k);
        BatchGetPoiListRequest localBatchGetPoiListRequest = new BatchGetPoiListRequest();
        localBatchGetPoiListRequest.a(localList);
        this.c.add(localBatchGetPoiListRequest);
        CmdTaskManger.a().a(localBatchGetPoiListRequest, this);
        j += 1;
      }
      else
      {
        SLog.d("Q.qqstory.recommendAlbum.logic.BatchGetPoiListHandler", "sendRequest total=%d, batch count=%d", new Object[] { Integer.valueOf(((List)localObject1).size()), Integer.valueOf(i) });
        return;
        BatchGetPoiListHandler.BatchGetPOIListener localBatchGetPOIListener = this.b;
        if (localBatchGetPOIListener != null) {
          localBatchGetPOIListener.a(new ErrorMessage(-1, "BatchGetPoiListHandler no photo"), null);
        }
        return;
        label300:
        j = 0;
      }
    }
  }
  
  public void a(BatchGetPoiListHandler.BatchGetPOIListener paramBatchGetPOIListener)
  {
    this.b = paramBatchGetPOIListener;
  }
  
  public void a(@NonNull BatchGetPoiListRequest paramBatchGetPoiListRequest, @Nullable BatchGetPoiListRequest.BatchGetPoiListResponse paramBatchGetPoiListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    try
    {
      this.c.remove(paramBatchGetPoiListRequest);
      if ((this.e != null) && (this.e.isFail()))
      {
        b();
        return;
      }
      this.e = paramErrorMessage;
      if ((paramBatchGetPoiListResponse != null) && (!paramErrorMessage.isFail()))
      {
        paramErrorMessage = new HashMap(this.a.size());
        if (paramBatchGetPoiListResponse.a.size() > 0)
        {
          Iterator localIterator1 = paramBatchGetPoiListResponse.a.iterator();
          for (;;)
          {
            if (!localIterator1.hasNext()) {
              break label225;
            }
            AddressItem localAddressItem = (AddressItem)localIterator1.next();
            Iterator localIterator2 = this.a.entrySet().iterator();
            if (localIterator2.hasNext())
            {
              GeoHashPhotoGroup localGeoHashPhotoGroup = (GeoHashPhotoGroup)((Map.Entry)localIterator2.next()).getValue();
              if (localGeoHashPhotoGroup.d == null) {
                break;
              }
              qqstory_struct.GpsMsg localGpsMsg = localGeoHashPhotoGroup.d.c();
              if ((localGpsMsg.lat.get() != localAddressItem.latitude) || (localGpsMsg.lng.get() != localAddressItem.longitude)) {
                break;
              }
              paramErrorMessage.put(localGeoHashPhotoGroup.a, localAddressItem);
            }
          }
        }
        label225:
        if (paramBatchGetPoiListResponse.a.size() != paramBatchGetPoiListRequest.b()) {
          SLog.e("Q.qqstory.recommendAlbum.logic.BatchGetPoiListHandler", "handle poi request. request length=%d, rsp length=%d", new Object[] { Integer.valueOf(paramBatchGetPoiListRequest.b()), Integer.valueOf(paramBatchGetPoiListResponse.a.size()) });
        }
        this.f.putAll(paramErrorMessage);
        b();
        return;
      }
      b();
      return;
    }
    finally {}
    for (;;)
    {
      throw paramBatchGetPoiListRequest;
    }
  }
  
  public void a(@NonNull HashMap<String, GeoHashPhotoGroup> paramHashMap)
  {
    this.a = paramHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.network.BatchGetPoiListHandler
 * JD-Core Version:    0.7.0.1
 */