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
  private CheckBlackGeoHashHandler.CheckBlackListener jdField_a_of_type_ComTencentBizQqstoryAlbumNetworkCheckBlackGeoHashHandler$CheckBlackListener;
  private HashMap<String, GeoHashPhotoGroup> jdField_a_of_type_JavaUtilHashMap;
  
  public void a()
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilHashMap;
    if ((localObject1 != null) && (((HashMap)localObject1).size() != 0))
    {
      localObject1 = StoryScanManager.a(this.jdField_a_of_type_JavaUtilHashMap);
      if (((List)localObject1).size() == 0)
      {
        localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryAlbumNetworkCheckBlackGeoHashHandler$CheckBlackListener;
        if (localObject1 != null)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("CheckBlackGeoHashHandler gps error ");
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaUtilHashMap.toString());
          ((CheckBlackGeoHashHandler.CheckBlackListener)localObject1).a(new ErrorMessage(-1, ((StringBuilder)localObject2).toString()), null);
        }
        return;
      }
      Object localObject2 = new CheckBlackPOIRequest();
      ((CheckBlackPOIRequest)localObject2).a((List)localObject1);
      CmdTaskManger.a().a((NetworkRequest)localObject2, this);
      return;
    }
    localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryAlbumNetworkCheckBlackGeoHashHandler$CheckBlackListener;
    if (localObject1 != null) {
      ((CheckBlackGeoHashHandler.CheckBlackListener)localObject1).a(new ErrorMessage(-1, "CheckBlackGeoHashHandler no photo"), null);
    }
  }
  
  public void a(CheckBlackGeoHashHandler.CheckBlackListener paramCheckBlackListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryAlbumNetworkCheckBlackGeoHashHandler$CheckBlackListener = paramCheckBlackListener;
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
          Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
          if (localIterator.hasNext())
          {
            GeoHashPhotoGroup localGeoHashPhotoGroup = (GeoHashPhotoGroup)((Map.Entry)localIterator.next()).getValue();
            if (localGeoHashPhotoGroup.jdField_a_of_type_ComTencentBizQqstoryAlbumToolsGeoHashUtils$Gps == null) {
              break;
            }
            qqstory_struct.GpsMsg localGpsMsg2 = localGeoHashPhotoGroup.jdField_a_of_type_ComTencentBizQqstoryAlbumToolsGeoHashUtils$Gps.a();
            if ((localGpsMsg2.lat.get() != localGpsMsg1.lat.get()) || (localGpsMsg2.lng.get() != localGpsMsg1.lng.get())) {
              break;
            }
            paramCheckBlackPOIRequest.add(localGeoHashPhotoGroup.jdField_a_of_type_JavaLangString);
          }
        }
      }
      label186:
      paramGetBlackListResponse = this.jdField_a_of_type_ComTencentBizQqstoryAlbumNetworkCheckBlackGeoHashHandler$CheckBlackListener;
      if (paramGetBlackListResponse != null) {
        paramGetBlackListResponse.a(paramErrorMessage, paramCheckBlackPOIRequest);
      }
      return;
    }
    paramCheckBlackPOIRequest = this.jdField_a_of_type_ComTencentBizQqstoryAlbumNetworkCheckBlackGeoHashHandler$CheckBlackListener;
    if (paramCheckBlackPOIRequest != null) {
      paramCheckBlackPOIRequest.a(paramErrorMessage, null);
    }
  }
  
  public void a(@NonNull HashMap<String, GeoHashPhotoGroup> paramHashMap)
  {
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.network.CheckBlackGeoHashHandler
 * JD-Core Version:    0.7.0.1
 */