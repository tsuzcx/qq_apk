package com.tencent.biz.qqstory.album.segment;

import android.text.TextUtils;
import com.tencent.biz.qqstory.album.StoryAlbumConfig;
import com.tencent.biz.qqstory.album.StoryScanManager;
import com.tencent.biz.qqstory.album.model.GeoHashPhotoGroup;
import com.tencent.biz.qqstory.album.model.StoryAlbum.PicInfo;
import com.tencent.biz.qqstory.album.network.BatchGetPoiListHandler;
import com.tencent.biz.qqstory.album.network.BatchGetPoiListHandler.BatchGetPOIListener;
import com.tencent.biz.qqstory.album.network.CheckBlackGeoHashHandler;
import com.tencent.biz.qqstory.album.network.CheckBlackGeoHashHandler.CheckBlackListener;
import com.tencent.biz.qqstory.album.tools.GeoHashUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.AddressItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class PreProcessSegment
  extends JobSegment<List<StoryAlbum.PicInfo>, List<StoryAlbum.PicInfo>>
  implements BatchGetPoiListHandler.BatchGetPOIListener, CheckBlackGeoHashHandler.CheckBlackListener
{
  private ScanInfo jdField_a_of_type_ComTencentBizQqstoryAlbumSegmentScanInfo;
  private HashMap<String, GeoHashPhotoGroup> jdField_a_of_type_JavaUtilHashMap;
  
  public PreProcessSegment(ScanInfo paramScanInfo)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryAlbumSegmentScanInfo = paramScanInfo;
  }
  
  public void a(ErrorMessage paramErrorMessage, HashMap<String, AddressItem> paramHashMap)
  {
    SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.PreProcessSegment", "handlePOIResult errorMessage=%s", new Object[] { paramErrorMessage.toString() });
    if (paramErrorMessage.isFail())
    {
      notifyError(new ErrorMessage(paramErrorMessage.errorCode, "request POI list error:" + paramErrorMessage.getErrorMessage()));
      return;
    }
    Object localObject;
    if ((paramHashMap != null) && (paramHashMap.size() > 0))
    {
      paramErrorMessage = paramHashMap.entrySet().iterator();
      while (paramErrorMessage.hasNext())
      {
        paramHashMap = (Map.Entry)paramErrorMessage.next();
        localObject = (String)paramHashMap.getKey();
        paramHashMap = (AddressItem)paramHashMap.getValue();
        localObject = (GeoHashPhotoGroup)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
        ((GeoHashPhotoGroup)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemAddressItem = paramHashMap;
        localObject = ((GeoHashPhotoGroup)localObject).jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((StoryAlbum.PicInfo)((Iterator)localObject).next()).jdField_a_of_type_ComTencentBizQqstoryModelItemAddressItem = paramHashMap;
        }
      }
    }
    paramErrorMessage = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      paramHashMap = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      while (paramHashMap.hasNext())
      {
        localObject = (GeoHashPhotoGroup)((Map.Entry)paramHashMap.next()).getValue();
        paramErrorMessage.addAll(((GeoHashPhotoGroup)localObject).jdField_a_of_type_JavaUtilList);
        if (((StoryAlbum.PicInfo)((GeoHashPhotoGroup)localObject).jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_ComTencentBizQqstoryModelItemAddressItem == null) {
          SLog.e("Q.qqstory.recommendAlbum.logic.StoryScanManager.PreProcessSegment", "后台返回的POI数据里缺少了 ：" + ((GeoHashPhotoGroup)localObject).jdField_a_of_type_ComTencentBizQqstoryAlbumToolsGeoHashUtils$Gps);
        }
      }
    }
    SLog.a("Q.qqstory.recommendAlbum.logic.StoryScanManager.PreProcessSegment", "this segment is finish  : result=%s", paramErrorMessage);
    notifyResult(paramErrorMessage);
  }
  
  public void a(ErrorMessage paramErrorMessage, List<String> paramList)
  {
    String str = paramErrorMessage.toString();
    if (paramList == null) {}
    for (int i = 0;; i = paramList.size())
    {
      SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.PreProcessSegment", "handleBlackResult errorMessage=%s, blackGeohash count=%d", new Object[] { str, Integer.valueOf(i) });
      if (!paramErrorMessage.isFail()) {
        break;
      }
      notifyError(new ErrorMessage(paramErrorMessage.errorCode, "request black list error:" + paramErrorMessage.getErrorMessage()));
      return;
    }
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramErrorMessage = paramList.iterator();
      while (paramErrorMessage.hasNext())
      {
        paramList = (String)paramErrorMessage.next();
        this.jdField_a_of_type_JavaUtilHashMap.remove(paramList);
      }
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.size() == 0)
    {
      notifyResult(new ArrayList());
      return;
    }
    if ((this.jdField_a_of_type_JavaUtilHashMap.size() == 1) && (this.jdField_a_of_type_JavaUtilHashMap.get("EMPTY") != null))
    {
      a(new ErrorMessage(), null);
      return;
    }
    paramErrorMessage = new BatchGetPoiListHandler();
    paramErrorMessage.a(this.jdField_a_of_type_JavaUtilHashMap);
    paramErrorMessage.a(this);
    paramErrorMessage.a();
    SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.PreProcessSegment", "sendPOIRequest total count:%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilHashMap.size()) });
  }
  
  protected void a(JobContext paramJobContext, List<StoryAlbum.PicInfo> paramList)
  {
    SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.PreProcessSegment", "start PreProcessSegment piccount=%d", new Object[] { Integer.valueOf(paramList.size()) });
    if (paramList.isEmpty())
    {
      notifyResult(paramList);
      return;
    }
    int i = ((StoryScanManager)SuperManager.a(30)).a().b();
    SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.PreProcessSegment", "PreProcessSegment geohashlevel=%d", new Object[] { Integer.valueOf(i) });
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    paramJobContext = paramList.iterator();
    while (paramJobContext.hasNext())
    {
      paramList = (StoryAlbum.PicInfo)paramJobContext.next();
      if ((paramList.jdField_a_of_type_Double == 0.0D) && (paramList.b == 0.0D)) {}
      for (paramList.c = "EMPTY";; paramList.c = GeoHashUtils.a(paramList.jdField_a_of_type_Double, paramList.b, i))
      {
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramList.c)) {
          break label192;
        }
        ((GeoHashPhotoGroup)this.jdField_a_of_type_JavaUtilHashMap.get(paramList.c)).jdField_a_of_type_JavaUtilList.add(paramList);
        break;
      }
      label192:
      GeoHashPhotoGroup localGeoHashPhotoGroup = new GeoHashPhotoGroup(paramList.c);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramList);
      localGeoHashPhotoGroup.jdField_a_of_type_JavaUtilList = localArrayList;
      if ((!TextUtils.isEmpty(localGeoHashPhotoGroup.jdField_a_of_type_JavaLangString)) && (!TextUtils.equals(localGeoHashPhotoGroup.jdField_a_of_type_JavaLangString, "EMPTY"))) {
        localGeoHashPhotoGroup.jdField_a_of_type_ComTencentBizQqstoryAlbumToolsGeoHashUtils$Gps = GeoHashUtils.a(localGeoHashPhotoGroup.jdField_a_of_type_JavaLangString);
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(paramList.c, localGeoHashPhotoGroup);
    }
    SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.PreProcessSegment", "group by geohash count:%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilHashMap.size()) });
    if ((this.jdField_a_of_type_JavaUtilHashMap.size() == 1) && (this.jdField_a_of_type_JavaUtilHashMap.get("EMPTY") != null))
    {
      a(new ErrorMessage(), null);
      return;
    }
    paramJobContext = new CheckBlackGeoHashHandler();
    paramJobContext.a(this.jdField_a_of_type_JavaUtilHashMap);
    paramJobContext.a(this);
    paramJobContext.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.segment.PreProcessSegment
 * JD-Core Version:    0.7.0.1
 */