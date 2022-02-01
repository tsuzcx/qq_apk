package com.tencent.biz.qqstory.album.network;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.album.StoryScanManager;
import com.tencent.biz.qqstory.album.model.GeoHashPhotoGroup;
import com.tencent.biz.qqstory.album.tools.GeoHashUtils.Gps;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.GpsMsg;
import com.tencent.mobileqq.pb.PBInt32Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class CheckBlackGeoHashHandler
  implements CmdTaskManger.CommandCallback<CheckBlackPOIRequest, CheckBlackPOIRequest.GetBlackListResponse>
{
  private HashMap<String, GeoHashPhotoGroup> a;
  private CheckBlackGeoHashHandler.CheckBlackListener b;
  
  public void a()
  {
    Object localObject1 = this.a;
    if ((localObject1 != null) && (((HashMap)localObject1).size() != 0))
    {
      localObject1 = StoryScanManager.a(this.a);
      if (((List)localObject1).size() == 0)
      {
        localObject1 = this.b;
        if (localObject1 != null)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("CheckBlackGeoHashHandler gps error ");
          ((StringBuilder)localObject2).append(this.a.toString());
          ((CheckBlackGeoHashHandler.CheckBlackListener)localObject1).a(new ErrorMessage(-1, ((StringBuilder)localObject2).toString()), null);
        }
        return;
      }
      Object localObject2 = new CheckBlackPOIRequest();
      ((CheckBlackPOIRequest)localObject2).a((List)localObject1);
      CmdTaskManger.a().a((NetworkRequest)localObject2, this);
      return;
    }
    localObject1 = this.b;
    if (localObject1 != null) {
      ((CheckBlackGeoHashHandler.CheckBlackListener)localObject1).a(new ErrorMessage(-1, "CheckBlackGeoHashHandler no photo"), null);
    }
  }
  
  public void a(CheckBlackGeoHashHandler.CheckBlackListener paramCheckBlackListener)
  {
    this.b = paramCheckBlackListener;
  }
  
  public void a(@NonNull CheckBlackPOIRequest paramCheckBlackPOIRequest, @Nullable CheckBlackPOIRequest.GetBlackListResponse paramGetBlackListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramGetBlackListResponse != null) && (!paramErrorMessage.isFail()))
    {
      paramCheckBlackPOIRequest = new ArrayList();
      if ((paramGetBlackListResponse.a != null) && (paramGetBlackListResponse.a.size() > 0))
      {
        paramGetBlackListResponse = paramGetBlackListResponse.a.iterator();
        for (;;)
        {
          if (!paramGetBlackListResponse.hasNext()) {
            break label186;
          }
          qqstory_struct.GpsMsg localGpsMsg1 = (qqstory_struct.GpsMsg)paramGetBlackListResponse.next();
          Iterator localIterator = this.a.entrySet().iterator();
          if (localIterator.hasNext())
          {
            GeoHashPhotoGroup localGeoHashPhotoGroup = (GeoHashPhotoGroup)((Map.Entry)localIterator.next()).getValue();
            if (localGeoHashPhotoGroup.d == null) {
              break;
            }
            qqstory_struct.GpsMsg localGpsMsg2 = localGeoHashPhotoGroup.d.c();
            if ((localGpsMsg2.lat.get() != localGpsMsg1.lat.get()) || (localGpsMsg2.lng.get() != localGpsMsg1.lng.get())) {
              break;
            }
            paramCheckBlackPOIRequest.add(localGeoHashPhotoGroup.a);
          }
        }
      }
      label186:
      paramGetBlackListResponse = this.b;
      if (paramGetBlackListResponse != null) {
        paramGetBlackListResponse.a(paramErrorMessage, paramCheckBlackPOIRequest);
      }
      return;
    }
    paramCheckBlackPOIRequest = this.b;
    if (paramCheckBlackPOIRequest != null) {
      paramCheckBlackPOIRequest.a(paramErrorMessage, null);
    }
  }
  
  public void a(@NonNull HashMap<String, GeoHashPhotoGroup> paramHashMap)
  {
    this.a = paramHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.network.CheckBlackGeoHashHandler
 * JD-Core Version:    0.7.0.1
 */