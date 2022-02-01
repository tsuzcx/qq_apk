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
  private HashMap<String, GeoHashPhotoGroup> a;
  
  public void a(ErrorMessage paramErrorMessage, HashMap<String, AddressItem> paramHashMap)
  {
    SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.PreProcessSegment", "handlePOIResult errorMessage=%s", new Object[] { paramErrorMessage.toString() });
    if (paramErrorMessage.isFail())
    {
      int i = paramErrorMessage.errorCode;
      paramHashMap = new StringBuilder();
      paramHashMap.append("request POI list error:");
      paramHashMap.append(paramErrorMessage.getErrorMessage());
      notifyError(new ErrorMessage(i, paramHashMap.toString()));
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
        localObject = (GeoHashPhotoGroup)this.a.get(localObject);
        ((GeoHashPhotoGroup)localObject).c = paramHashMap;
        localObject = ((GeoHashPhotoGroup)localObject).b.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((StoryAlbum.PicInfo)((Iterator)localObject).next()).o = paramHashMap;
        }
      }
    }
    paramErrorMessage = new ArrayList();
    paramHashMap = this.a;
    if (paramHashMap != null)
    {
      paramHashMap = paramHashMap.entrySet().iterator();
      while (paramHashMap.hasNext())
      {
        localObject = (GeoHashPhotoGroup)((Map.Entry)paramHashMap.next()).getValue();
        paramErrorMessage.addAll(((GeoHashPhotoGroup)localObject).b);
        if (((StoryAlbum.PicInfo)((GeoHashPhotoGroup)localObject).b.get(0)).o == null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("后台返回的POI数据里缺少了 ：");
          localStringBuilder.append(((GeoHashPhotoGroup)localObject).d);
          SLog.e("Q.qqstory.recommendAlbum.logic.StoryScanManager.PreProcessSegment", localStringBuilder.toString());
        }
      }
    }
    SLog.a("Q.qqstory.recommendAlbum.logic.StoryScanManager.PreProcessSegment", "this segment is finish  : result=%s", paramErrorMessage);
    notifyResult(paramErrorMessage);
  }
  
  public void a(ErrorMessage paramErrorMessage, List<String> paramList)
  {
    String str = paramErrorMessage.toString();
    int i;
    if (paramList == null) {
      i = 0;
    } else {
      i = paramList.size();
    }
    SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.PreProcessSegment", "handleBlackResult errorMessage=%s, blackGeohash count=%d", new Object[] { str, Integer.valueOf(i) });
    if (paramErrorMessage.isFail())
    {
      i = paramErrorMessage.errorCode;
      paramList = new StringBuilder();
      paramList.append("request black list error:");
      paramList.append(paramErrorMessage.getErrorMessage());
      notifyError(new ErrorMessage(i, paramList.toString()));
      return;
    }
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramErrorMessage = paramList.iterator();
      while (paramErrorMessage.hasNext())
      {
        paramList = (String)paramErrorMessage.next();
        this.a.remove(paramList);
      }
    }
    if (this.a.size() == 0)
    {
      notifyResult(new ArrayList());
      return;
    }
    if ((this.a.size() == 1) && (this.a.get("EMPTY") != null))
    {
      a(new ErrorMessage(), null);
      return;
    }
    paramErrorMessage = new BatchGetPoiListHandler();
    paramErrorMessage.a(this.a);
    paramErrorMessage.a(this);
    paramErrorMessage.a();
    SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.PreProcessSegment", "sendPOIRequest total count:%d", new Object[] { Integer.valueOf(this.a.size()) });
  }
  
  protected void a(JobContext paramJobContext, List<StoryAlbum.PicInfo> paramList)
  {
    SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.PreProcessSegment", "start PreProcessSegment piccount=%d", new Object[] { Integer.valueOf(paramList.size()) });
    if (paramList.isEmpty())
    {
      notifyResult(paramList);
      return;
    }
    int i = ((StoryScanManager)SuperManager.a(30)).g().h();
    SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.PreProcessSegment", "PreProcessSegment geohashlevel=%d", new Object[] { Integer.valueOf(i) });
    this.a = new HashMap();
    paramJobContext = paramList.iterator();
    while (paramJobContext.hasNext())
    {
      paramList = (StoryAlbum.PicInfo)paramJobContext.next();
      if ((paramList.j == 0.0D) && (paramList.k == 0.0D)) {
        paramList.l = "EMPTY";
      } else {
        paramList.l = GeoHashUtils.a(paramList.j, paramList.k, i);
      }
      if (this.a.containsKey(paramList.l))
      {
        ((GeoHashPhotoGroup)this.a.get(paramList.l)).b.add(paramList);
      }
      else
      {
        GeoHashPhotoGroup localGeoHashPhotoGroup = new GeoHashPhotoGroup(paramList.l);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(paramList);
        localGeoHashPhotoGroup.b = localArrayList;
        if ((!TextUtils.isEmpty(localGeoHashPhotoGroup.a)) && (!TextUtils.equals(localGeoHashPhotoGroup.a, "EMPTY"))) {
          localGeoHashPhotoGroup.d = GeoHashUtils.a(localGeoHashPhotoGroup.a);
        }
        this.a.put(paramList.l, localGeoHashPhotoGroup);
      }
    }
    SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.PreProcessSegment", "group by geohash count:%d", new Object[] { Integer.valueOf(this.a.size()) });
    if ((this.a.size() == 1) && (this.a.get("EMPTY") != null))
    {
      a(new ErrorMessage(), null);
      return;
    }
    paramJobContext = new CheckBlackGeoHashHandler();
    paramJobContext.a(this.a);
    paramJobContext.a(this);
    paramJobContext.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.segment.PreProcessSegment
 * JD-Core Version:    0.7.0.1
 */