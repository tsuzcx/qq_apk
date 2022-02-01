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
  private long jdField_a_of_type_Long;
  private BatchGetPoiListHandler.BatchGetPOIListener jdField_a_of_type_ComTencentBizQqstoryAlbumNetworkBatchGetPoiListHandler$BatchGetPOIListener;
  private ErrorMessage jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage;
  private HashMap<String, GeoHashPhotoGroup> jdField_a_of_type_JavaUtilHashMap;
  private List<BatchGetPoiListRequest> jdField_a_of_type_JavaUtilList = new ArrayList();
  private HashMap<String, AddressItem> b = new HashMap();
  
  private void b()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() == 0)
    {
      SLog.d("Q.qqstory.recommendAlbum.logic.BatchGetPoiListHandler", "handleResult. all request has finish timecost=%s, errorInfo=%s", new Object[] { Long.valueOf(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long), this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage });
      if (this.jdField_a_of_type_ComTencentBizQqstoryAlbumNetworkBatchGetPoiListHandler$BatchGetPOIListener != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryAlbumNetworkBatchGetPoiListHandler$BatchGetPOIListener.a(this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage, this.b);
      }
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilHashMap.size() == 0))
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryAlbumNetworkBatchGetPoiListHandler$BatchGetPOIListener != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryAlbumNetworkBatchGetPoiListHandler$BatchGetPOIListener.a(new ErrorMessage(-1, "BatchGetPoiListHandler no photo"), null);
      }
      return;
    }
    try
    {
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      List localList1 = StoryScanManager.a(this.jdField_a_of_type_JavaUtilHashMap);
      if (localList1.size() == 0)
      {
        if (this.jdField_a_of_type_ComTencentBizQqstoryAlbumNetworkBatchGetPoiListHandler$BatchGetPOIListener != null) {
          this.jdField_a_of_type_ComTencentBizQqstoryAlbumNetworkBatchGetPoiListHandler$BatchGetPOIListener.a(new ErrorMessage(-1, "BatchGetPoiListHandler gps error"), null);
        }
        return;
      }
    }
    finally {}
    int j = localObject.size() / 100;
    int i = j;
    if (localObject.size() % 100 > 0) {
      i = j + 1;
    }
    for (;;)
    {
      if (j < i)
      {
        int m = j * 100;
        if (m + 100 <= localObject.size()) {}
        for (int k = m + 100;; k = localObject.size())
        {
          SLog.d("Q.qqstory.recommendAlbum.logic.BatchGetPoiListHandler", "send last batch length=%d", new Object[] { Integer.valueOf(k - m) });
          List localList2 = localObject.subList(m, k);
          BatchGetPoiListRequest localBatchGetPoiListRequest = new BatchGetPoiListRequest();
          localBatchGetPoiListRequest.a(localList2);
          this.jdField_a_of_type_JavaUtilList.add(localBatchGetPoiListRequest);
          CmdTaskManger.a().a(localBatchGetPoiListRequest, this);
          j += 1;
          break;
        }
      }
      SLog.d("Q.qqstory.recommendAlbum.logic.BatchGetPoiListHandler", "sendRequest total=%d, batch count=%d", new Object[] { Integer.valueOf(localObject.size()), Integer.valueOf(i) });
      return;
      j = 0;
    }
  }
  
  public void a(BatchGetPoiListHandler.BatchGetPOIListener paramBatchGetPOIListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryAlbumNetworkBatchGetPoiListHandler$BatchGetPOIListener = paramBatchGetPOIListener;
  }
  
  public void a(@NonNull BatchGetPoiListRequest paramBatchGetPoiListRequest, @Nullable BatchGetPoiListRequest.BatchGetPoiListResponse paramBatchGetPoiListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramBatchGetPoiListRequest);
      if ((this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage != null) && (this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()))
      {
        b();
        return;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
      if ((paramBatchGetPoiListResponse == null) || (paramErrorMessage.isFail()))
      {
        b();
        return;
      }
    }
    finally {}
    paramErrorMessage = new HashMap(this.jdField_a_of_type_JavaUtilHashMap.size());
    if (paramBatchGetPoiListResponse.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      Iterator localIterator1 = paramBatchGetPoiListResponse.jdField_a_of_type_JavaUtilList.iterator();
      for (;;)
      {
        if (!localIterator1.hasNext()) {
          break label234;
        }
        AddressItem localAddressItem = (AddressItem)localIterator1.next();
        Iterator localIterator2 = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
        if (localIterator2.hasNext())
        {
          GeoHashPhotoGroup localGeoHashPhotoGroup = (GeoHashPhotoGroup)((Map.Entry)localIterator2.next()).getValue();
          if (localGeoHashPhotoGroup.jdField_a_of_type_ComTencentBizQqstoryAlbumToolsGeoHashUtils$Gps == null) {
            break;
          }
          qqstory_struct.GpsMsg localGpsMsg = localGeoHashPhotoGroup.jdField_a_of_type_ComTencentBizQqstoryAlbumToolsGeoHashUtils$Gps.a();
          if ((localGpsMsg.lat.get() != localAddressItem.latitude) || (localGpsMsg.lng.get() != localAddressItem.longitude)) {
            break;
          }
          paramErrorMessage.put(localGeoHashPhotoGroup.jdField_a_of_type_JavaLangString, localAddressItem);
        }
      }
    }
    label234:
    if (paramBatchGetPoiListResponse.jdField_a_of_type_JavaUtilList.size() != paramBatchGetPoiListRequest.a()) {
      SLog.e("Q.qqstory.recommendAlbum.logic.BatchGetPoiListHandler", "handle poi request. request length=%d, rsp length=%d", new Object[] { Integer.valueOf(paramBatchGetPoiListRequest.a()), Integer.valueOf(paramBatchGetPoiListResponse.jdField_a_of_type_JavaUtilList.size()) });
    }
    this.b.putAll(paramErrorMessage);
    b();
  }
  
  public void a(@NonNull HashMap<String, GeoHashPhotoGroup> paramHashMap)
  {
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.network.BatchGetPoiListHandler
 * JD-Core Version:    0.7.0.1
 */