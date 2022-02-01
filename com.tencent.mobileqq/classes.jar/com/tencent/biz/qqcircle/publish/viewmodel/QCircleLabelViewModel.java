package com.tencent.biz.qqcircle.publish.viewmodel;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import circlesearch.CircleSearchExhibition.StExhTag;
import circlesearch.CircleSearchExhibition.StMoreDataReq;
import circlesearch.CircleSearchExhibition.StMoreDataRsp;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants._QAlbumConstants;
import com.tencent.biz.qcircleshadow.lib.QCircleHostLbsHelper;
import com.tencent.biz.qqcircle.publish.report.QCirclePublishReport;
import com.tencent.biz.qqcircle.publish.util.ExifUtil;
import com.tencent.biz.qqcircle.publish.util.ExtendExifInterface;
import com.tencent.biz.qqcircle.requests.QCircleGetAssociateTagRequest;
import com.tencent.biz.qqcircle.requests.QCircleGetRecommendTagRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.image.JpegExifReader;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qzone.LbsDataV2.GpsInfo;
import cooperation.qzone.model.LabelInfo;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StExifInfo;
import feedcloud.FeedCloudMeta.StGPSV2;
import feedcloud.FeedCloudMeta.StTagInfo;
import feedcloud.FeedCloudMeta.StTagMedalInfo;
import feedcloud.FeedCloudTagcategorysvr.PicRecomEntry;
import feedcloud.FeedCloudTagcategorysvr.StTagCategoryRecomRsp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class QCircleLabelViewModel
  extends BaseViewModel
{
  public static final int a = ;
  public MutableLiveData<ArrayList<LabelInfo>> b = new MutableLiveData();
  public MutableLiveData<QCircleLabelViewModel.UpdateLabelInfoOnChange> c = new MutableLiveData();
  public MutableLiveData<String> d = new MutableLiveData();
  public MutableLiveData<String> e = new MutableLiveData();
  public ArrayList<LabelInfo> f = new ArrayList();
  FeedCloudCommon.StCommonExt g;
  private ArrayList<FeedCloudMeta.StTagInfo> h;
  private ArrayList<String> i = new ArrayList();
  private boolean j = false;
  private String k = "";
  private String l;
  private MutableLiveData<UIStateData<List<FeedCloudMeta.StTagInfo>>> m = new MutableLiveData();
  
  private void a(BaseRequest paramBaseRequest, boolean paramBoolean1, boolean paramBoolean2, long paramLong, String paramString, CircleSearchExhibition.StMoreDataRsp paramStMoreDataRsp)
  {
    boolean bool = VSNetworkHelper.isProtocolCache(paramString);
    if ((paramBoolean2) && (paramLong == 0L) && (paramStMoreDataRsp != null))
    {
      this.g = paramStMoreDataRsp.ext_info;
      Object localObject = paramStMoreDataRsp.tags.get();
      paramString = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        CircleSearchExhibition.StExhTag localStExhTag = (CircleSearchExhibition.StExhTag)((Iterator)localObject).next();
        if ((localStExhTag != null) && (localStExhTag.tag.get() != null)) {
          paramString.add(localStExhTag.tag.get());
        }
      }
      if ((paramBaseRequest instanceof QCircleGetAssociateTagRequest)) {
        paramBaseRequest = ((QCircleGetAssociateTagRequest)paramBaseRequest).getmReq().query.get();
      } else {
        paramBaseRequest = "";
      }
      if (paramString.size() > 0)
      {
        localObject = this.m;
        paramString = UIStateData.a(bool).a(paramBoolean1, paramString);
        int n = paramStMoreDataRsp.is_end.get();
        paramBoolean1 = true;
        if (n != 1) {
          paramBoolean1 = false;
        }
        ((MutableLiveData)localObject).setValue(paramString.c(paramBoolean1).b(paramBaseRequest));
        return;
      }
      this.m.setValue(UIStateData.a().b(paramBoolean1).b(paramBaseRequest));
      return;
    }
    this.m.setValue(UIStateData.a(paramString).b(paramBoolean1));
  }
  
  private void a(ArrayList<FeedCloudTagcategorysvr.PicRecomEntry> paramArrayList, FeedCloudMeta.StGPSV2 paramStGPSV2)
  {
    paramArrayList = new QCircleGetRecommendTagRequest(paramStGPSV2, paramArrayList);
    VSNetworkHelper.getInstance().sendRequest(paramArrayList, new QCircleLabelViewModel.2(this));
  }
  
  private void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudTagcategorysvr.StTagCategoryRecomRsp paramStTagCategoryRecomRsp)
  {
    if (paramBoolean) {}
    label523:
    label528:
    label537:
    label550:
    for (;;)
    {
      int i2;
      int i1;
      try
      {
        if (paramStTagCategoryRecomRsp.tagList != null)
        {
          if (this.h == null) {
            this.h = new ArrayList();
          }
          this.h.clear();
          this.h.addAll(paramStTagCategoryRecomRsp.tagList.get());
          i2 = paramStTagCategoryRecomRsp.tagList.size();
          paramString = new ArrayList();
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append("hanldeCallbackForQcircleRecommendTag... rsp.tagList.size:");
          ((StringBuilder)localObject).append(i2);
          QLog.d("[QcirclePublish]QCircleLabelViewModel", 1, ((StringBuilder)localObject).toString());
          i1 = 0;
          n = 0;
          if (n < i2)
          {
            localObject = (FeedCloudMeta.StTagInfo)paramStTagCategoryRecomRsp.tagList.get(n);
            if ((localObject == null) || (((FeedCloudMeta.StTagInfo)localObject).tagId == null) || (((FeedCloudMeta.StTagInfo)localObject).tagName == null)) {
              break label528;
            }
            LabelInfo localLabelInfo = new LabelInfo();
            localLabelInfo.id = ((FeedCloudMeta.StTagInfo)localObject).tagId.get();
            localLabelInfo.name = ((FeedCloudMeta.StTagInfo)localObject).tagName.get();
            localLabelInfo.rank = String.valueOf(((FeedCloudMeta.StTagInfo)localObject).medal.rank.get());
            if (((FeedCloudMeta.StTagInfo)localObject).isSelected.get() != 1) {
              break label523;
            }
            paramBoolean = true;
            localLabelInfo.hasSelected = paramBoolean;
            QLog.d("[QcirclePublish]QCircleLabelViewModel", 1, new Object[] { "requestRecommendLabelCallback... i:", Integer.valueOf(n), " labelInfo:", localLabelInfo.toString() });
            paramString.add(localLabelInfo);
            break label528;
          }
          n = i1;
          if (!paramString.isEmpty())
          {
            i1 = 0;
            n = 0;
            if (i1 >= paramString.size()) {
              break label550;
            }
            i2 = n;
            if (this.f.contains(paramString.get(i1))) {
              break label537;
            }
            i2 = n;
            if (this.f.size() >= a) {
              break label537;
            }
            i2 = n;
            if (this.i.contains(((LabelInfo)paramString.get(i1)).name)) {
              break label537;
            }
            this.f.add(0, paramString.get(i1));
            i2 = n + 1;
            QCirclePublishReport.a(15, 24, 1, null, null, null, ((LabelInfo)paramString.get(i1)).name);
            break label537;
          }
          this.c.postValue(new QCircleLabelViewModel.UpdateLabelInfoOnChange(this.f, n));
          return;
        }
        QLog.w("[QcirclePublish]QCircleLabelViewModel", 1, "hanldeCallbackForQcircleRecommendTag... rsp.taglist == null");
        return;
      }
      catch (Exception paramString)
      {
        QLog.e("[QcirclePublish]QCircleLabelViewModel", 1, "parse response data failed!", paramString);
        return;
      }
      paramStTagCategoryRecomRsp = new StringBuilder();
      paramStTagCategoryRecomRsp.append("get recommend tag failed. retCode=");
      paramStTagCategoryRecomRsp.append(paramLong);
      paramStTagCategoryRecomRsp.append(" errMsg=");
      paramStTagCategoryRecomRsp.append(paramString);
      QLog.e("[QcirclePublish]QCircleLabelViewModel", 1, paramStTagCategoryRecomRsp.toString());
      return;
      paramBoolean = false;
      continue;
      n += 1;
      continue;
      i1 += 1;
      int n = i2;
    }
  }
  
  private ArrayList<FeedCloudTagcategorysvr.PicRecomEntry> b(HashMap<String, LocalMediaInfo> paramHashMap)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramHashMap != null) && (!paramHashMap.isEmpty()))
    {
      paramHashMap = paramHashMap.values().iterator();
      while (paramHashMap.hasNext())
      {
        Object localObject1 = (LocalMediaInfo)paramHashMap.next();
        FeedCloudTagcategorysvr.PicRecomEntry localPicRecomEntry = new FeedCloudTagcategorysvr.PicRecomEntry();
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("toPicRecomEntry... path:");
        ((StringBuilder)localObject2).append(((LocalMediaInfo)localObject1).path);
        ((StringBuilder)localObject2).append(" aiTextLabel:");
        ((StringBuilder)localObject2).append(((LocalMediaInfo)localObject1).aiTextLabel);
        QLog.d("[QcirclePublish]QCircleLabelViewModel", 1, ((StringBuilder)localObject2).toString());
        if (((LocalMediaInfo)localObject1).aiTextLabel != null) {
          localPicRecomEntry.recomTags.set(((LocalMediaInfo)localObject1).aiTextLabel);
        }
        if (!TextUtils.isEmpty(((LocalMediaInfo)localObject1).materialID)) {
          localPicRecomEntry.materialId.set(((LocalMediaInfo)localObject1).materialID);
        }
        try
        {
          if ((JpegExifReader.isCrashJpeg(((LocalMediaInfo)localObject1).path)) || (((LocalMediaInfo)localObject1).mMimeType == null) || (((LocalMediaInfo)localObject1).mMimeType.contains("video"))) {
            break label303;
          }
          localObject2 = ExifUtil.b(new ExtendExifInterface(((LocalMediaInfo)localObject1).path));
          localObject1 = new FeedCloudMeta.StExifInfo();
          if ((localObject2 == null) || (((HashMap)localObject2).size() <= 0)) {
            break label303;
          }
          localObject2 = ((HashMap)localObject2).entrySet().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
            ((FeedCloudMeta.StExifInfo)localObject1).kvs.add(QCircleReportHelper.newEntry(localEntry));
          }
          localPicRecomEntry.exifInfo.set((MessageMicro)localObject1);
        }
        catch (Exception localException)
        {
          label294:
          break label294;
        }
        QLog.e("[QcirclePublish]QCircleLabelViewModel", 1, "read pic exif error");
        label303:
        localArrayList.add(localPicRecomEntry);
      }
    }
    else
    {
      return localArrayList;
    }
  }
  
  private void b(Intent paramIntent)
  {
    if (this.j) {
      return;
    }
    Object localObject = (HashMap)paramIntent.getSerializableExtra(QCircleHostConstants._QAlbumConstants.SELECTED_MEDIA_INFO_HASH_MAP());
    if (localObject == null) {
      return;
    }
    paramIntent = new StringBuilder();
    localObject = ((HashMap)localObject).values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Iterator localIterator = ((LocalMediaInfo)((Iterator)localObject).next()).mHashTagList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ((!TextUtils.isEmpty(str)) && (!this.i.contains(str)))
        {
          paramIntent.append("#");
          paramIntent.append(str);
          paramIntent.append(" ");
          b(str);
        }
      }
    }
    if (paramIntent.length() > 0)
    {
      this.e.postValue(this.k);
      this.k = paramIntent.toString();
      this.d.postValue(paramIntent.toString());
    }
  }
  
  private void b(String paramString)
  {
    if (!this.i.contains(paramString)) {
      this.i.add(paramString);
    }
  }
  
  private FeedCloudMeta.StGPSV2 f()
  {
    LbsDataV2.GpsInfo localGpsInfo = QCircleHostLbsHelper.getCurrGps("qqcircle");
    FeedCloudMeta.StGPSV2 localStGPSV2 = new FeedCloudMeta.StGPSV2();
    if (localGpsInfo != null)
    {
      localStGPSV2.alt.set(localGpsInfo.alt);
      localStGPSV2.lat.set(localGpsInfo.lat);
      localStGPSV2.lon.set(localGpsInfo.lon);
      localStGPSV2.eType.set(localGpsInfo.gpsType);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getCurrentGps... gpsInfo.alt:");
      localStringBuilder.append(localGpsInfo.alt);
      localStringBuilder.append(" gpsInfo.lat:");
      localStringBuilder.append(localGpsInfo.lat);
      QLog.d("[QcirclePublish]QCircleLabelViewModel", 2, localStringBuilder.toString());
    }
    return localStGPSV2;
  }
  
  public String a()
  {
    return "[QcirclePublish]QCircleLabelViewModel";
  }
  
  public void a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.f.size()))
    {
      this.f.remove(paramInt);
      this.b.postValue(this.f);
    }
  }
  
  public void a(Activity paramActivity, Intent paramIntent)
  {
    b(paramIntent);
  }
  
  public void a(Intent paramIntent)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    String str = paramIntent.getStringExtra("key_qcircle_publish_default_tag_name");
    if ((!TextUtils.isEmpty(str)) && (!this.i.contains(str)))
    {
      localStringBuffer.append("#");
      localStringBuffer.append(str);
      localStringBuffer.append(" ");
      b(str);
      this.j = true;
    }
    paramIntent = (HashMap)paramIntent.getSerializableExtra("key_attrs");
    if ((paramIntent != null) && (paramIntent.containsKey("tag")))
    {
      paramIntent = ((String)paramIntent.get("tag")).split(";");
      int n = 0;
      while (n < paramIntent.length)
      {
        if ((!TextUtils.isEmpty(paramIntent[n])) && (!this.i.contains(paramIntent[n])))
        {
          localStringBuffer.append("#");
          localStringBuffer.append(paramIntent[n]);
          localStringBuffer.append(" ");
          b(paramIntent[n]);
          this.j = true;
        }
        n += 1;
      }
    }
    if (localStringBuffer.length() > 0) {
      this.d.postValue(localStringBuffer.toString());
    }
    QLog.d("[QcirclePublish]QCircleLabelViewModel", 1, new Object[] { "initData... taglist:", localStringBuffer.toString() });
  }
  
  public void a(String paramString)
  {
    this.l = paramString;
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.l = paramString;
      this.g = null;
    }
    paramString = new QCircleGetAssociateTagRequest(this.g, this.l);
    VSNetworkHelper.getInstance().sendRequest(paramString, new QCircleLabelViewModel.1(this, paramBoolean));
  }
  
  public void a(HashMap<String, LocalMediaInfo> paramHashMap)
  {
    a(b(paramHashMap), f());
  }
  
  public MutableLiveData<UIStateData<List<FeedCloudMeta.StTagInfo>>> b()
  {
    return this.m;
  }
  
  public String c()
  {
    return this.l;
  }
  
  public void d()
  {
    ArrayList localArrayList = this.h;
    if ((localArrayList != null) && (localArrayList.size() > 0)) {
      this.m.setValue(UIStateData.a(true).a(false, this.h).c(true));
    }
  }
  
  public void e()
  {
    ArrayList localArrayList = this.f;
    if (localArrayList != null) {
      localArrayList.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.viewmodel.QCircleLabelViewModel
 * JD-Core Version:    0.7.0.1
 */