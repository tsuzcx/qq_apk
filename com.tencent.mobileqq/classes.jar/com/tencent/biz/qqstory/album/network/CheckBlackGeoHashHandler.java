package com.tencent.biz.qqstory.album.network;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.album.StoryScanManager;
import com.tencent.biz.qqstory.album.model.GeoHashPhotoGroup;
import com.tencent.biz.qqstory.album.tools.GeoHashUtils.Gps;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
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
    if ((this.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilHashMap.size() == 0)) {
      if (this.jdField_a_of_type_ComTencentBizQqstoryAlbumNetworkCheckBlackGeoHashHandler$CheckBlackListener != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryAlbumNetworkCheckBlackGeoHashHandler$CheckBlackListener.a(new ErrorMessage(-1, "CheckBlackGeoHashHandler no photo"), null);
      }
    }
    List localList;
    do
    {
      return;
      localList = StoryScanManager.a(this.jdField_a_of_type_JavaUtilHashMap);
      if (localList.size() != 0) {
        break;
      }
    } while (this.jdField_a_of_type_ComTencentBizQqstoryAlbumNetworkCheckBlackGeoHashHandler$CheckBlackListener == null);
    this.jdField_a_of_type_ComTencentBizQqstoryAlbumNetworkCheckBlackGeoHashHandler$CheckBlackListener.a(new ErrorMessage(-1, "CheckBlackGeoHashHandler gps error " + this.jdField_a_of_type_JavaUtilHashMap.toString()), null);
    return;
    CheckBlackPOIRequest localCheckBlackPOIRequest = new CheckBlackPOIRequest();
    localCheckBlackPOIRequest.a(localList);
    CmdTaskManger.a().a(localCheckBlackPOIRequest, this);
  }
  
  public void a(CheckBlackGeoHashHandler.CheckBlackListener paramCheckBlackListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryAlbumNetworkCheckBlackGeoHashHandler$CheckBlackListener = paramCheckBlackListener;
  }
  
  public void a(@NonNull CheckBlackPOIRequest paramCheckBlackPOIRequest, @Nullable CheckBlackPOIRequest.GetBlackListResponse paramGetBlackListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramGetBlackListResponse == null) || (paramErrorMessage.isFail())) {
      if (this.jdField_a_of_type_ComTencentBizQqstoryAlbumNetworkCheckBlackGeoHashHandler$CheckBlackListener != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryAlbumNetworkCheckBlackGeoHashHandler$CheckBlackListener.a(paramErrorMessage, null);
      }
    }
    label202:
    do
    {
      return;
      paramCheckBlackPOIRequest = new ArrayList();
      if ((paramGetBlackListResponse.a != null) && (paramGetBlackListResponse.a.size() > 0))
      {
        paramGetBlackListResponse = paramGetBlackListResponse.a.iterator();
        for (;;)
        {
          if (!paramGetBlackListResponse.hasNext()) {
            break label202;
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
    } while (this.jdField_a_of_type_ComTencentBizQqstoryAlbumNetworkCheckBlackGeoHashHandler$CheckBlackListener == null);
    this.jdField_a_of_type_ComTencentBizQqstoryAlbumNetworkCheckBlackGeoHashHandler$CheckBlackListener.a(paramErrorMessage, paramCheckBlackPOIRequest);
  }
  
  public void a(@NonNull HashMap<String, GeoHashPhotoGroup> paramHashMap)
  {
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.network.CheckBlackGeoHashHandler
 * JD-Core Version:    0.7.0.1
 */