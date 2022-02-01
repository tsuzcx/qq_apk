package com.tencent.biz.qqcircle.publish.task;

import FileUpload.UploadVideoInfoRsp;
import NS_MOBILE_OPERATION.MediaInfo;
import NS_MOBILE_OPERATION.PicInfo;
import android.media.ExifInterface;
import android.os.Handler;
import android.text.TextUtils;
import com.qq.jce.wup.UniAttribute;
import com.tencent.biz.qcircleshadow.lib.HostStaticInvokeHelper;
import com.tencent.biz.qcircleshadow.lib.QCircleHostAEHelper;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.adapter.QCircleFakeAdapter;
import com.tencent.biz.qqcircle.publish.account.LoginData;
import com.tencent.biz.qqcircle.publish.model.ImageInfo;
import com.tencent.biz.qqcircle.publish.model.MediaWrapper;
import com.tencent.biz.qqcircle.publish.model.QzoneMediaUploadParams;
import com.tencent.biz.qqcircle.publish.model.QzoneShuoShuoParams;
import com.tencent.biz.qqcircle.publish.model.ShuoshuoVideoInfo;
import com.tencent.biz.qqcircle.publish.queue.QCircleTaskQueue;
import com.tencent.biz.qqcircle.publish.queue.util.NeedParcel;
import com.tencent.biz.qqcircle.publish.report.QCirclePublishReport;
import com.tencent.biz.qqcircle.publish.request.QCircleMediaUploadRequest.IMediaUploadTaskInfoListener;
import com.tencent.biz.qqcircle.publish.request.QCircleUploadRequest;
import com.tencent.biz.qqcircle.publish.request.result.UploadFileResponse;
import com.tencent.biz.qqcircle.publish.util.DateUtil;
import com.tencent.biz.qqcircle.publish.util.PublishUtils;
import com.tencent.biz.qqcircle.publish.util.UploadTaskBatchUtil;
import com.tencent.biz.qqcircle.requests.QCircleGetFeedDetailRequest;
import com.tencent.biz.qqcircle.requests.QCirclePublishFeedRequest;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.image.JpegExifReader;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleConstants;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadConfig.UploadImageSize;
import cooperation.qqcircle.beans.QCircleFakeFeed;
import cooperation.qqcircle.beans.QCircleFakeFeed.Builder;
import cooperation.qqcircle.report.QCircleLpReportDc05494;
import cooperation.qqcircle.report.QCirclePublishQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qqcircle.report.QCircleTaskReportInfo;
import cooperation.qzone.LbsDataV2.GpsInfo;
import cooperation.qzone.LbsDataV2.PoiInfo;
import cooperation.qzone.model.LabelInfo;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StClientInfo;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StGPSV2;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StPoiInfoV2;
import feedcloud.FeedCloudMeta.StTagInfo;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudMeta.StVideo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import qqcircle.QQCircleFeedBase.StImageBusiData;
import qqcircle.QQCircleFeedBase.StKuoliePasterData;
import qqcircle.QQCircleFeedBase.StMaterialData;
import qqcircle.QQCircleFeedBase.StSimulateData;
import qqcircle.QQCircleFeedBase.StVideoBusiData;

public class QCircleUploadShuoShuoTask
  extends QCircleBaseUploadShuoShuoTask
  implements QCircleMediaUploadRequest.IMediaUploadTaskInfoListener
{
  String aA;
  @NeedParcel
  private ArrayList<LabelInfo> aB;
  @NeedParcel
  private boolean aC;
  @NeedParcel
  private String aD;
  @NeedParcel
  private boolean aE;
  @NeedParcel
  private boolean aF;
  @NeedParcel
  private HashMap<String, String> aG;
  @NeedParcel
  private String aH;
  private ArrayList<QCircleTaskReportInfo> aI;
  private Runnable aJ;
  @NeedParcel
  public int ay;
  String az;
  
  public QCircleUploadShuoShuoTask()
  {
    this.ay = 0;
    this.aB = new ArrayList();
    this.aC = false;
    this.aF = false;
    this.aG = new HashMap();
    this.aI = new ArrayList();
    this.az = QCircleConfigHelper.a("QZoneTextSetting", "BoxTaskInfoPublishQCircle", "发表：");
    this.aA = QCircleConfigHelper.a("QZoneTextSetting", "BoxTaskQcircleVideoQueueing", "合成中...");
    this.aJ = new QCircleUploadShuoShuoTask.2(this);
  }
  
  public QCircleUploadShuoShuoTask(int paramInt1, int paramInt2, QzoneShuoShuoParams paramQzoneShuoShuoParams)
  {
    super(paramInt1, paramInt2, paramQzoneShuoShuoParams);
    paramInt1 = 0;
    this.ay = 0;
    this.aB = new ArrayList();
    this.aC = false;
    this.aF = false;
    this.aG = new HashMap();
    this.aI = new ArrayList();
    this.az = QCircleConfigHelper.a("QZoneTextSetting", "BoxTaskInfoPublishQCircle", "发表：");
    this.aA = QCircleConfigHelper.a("QZoneTextSetting", "BoxTaskQcircleVideoQueueing", "合成中...");
    this.aJ = new QCircleUploadShuoShuoTask.2(this);
    QLog.d("[upload2_QCircleUploadShuoShuoTask]", 1, new Object[] { "QCircleUploadShuoShuoTask... syncToQzone:", Boolean.valueOf(paramQzoneShuoShuoParams.m), " missionID:", paramQzoneShuoShuoParams.X });
    this.aC = paramQzoneShuoShuoParams.W;
    if (paramQzoneShuoShuoParams.m) {
      paramInt1 = 3;
    }
    this.ay = paramInt1;
    this.aB = paramQzoneShuoShuoParams.ab;
    this.aD = paramQzoneShuoShuoParams.X;
    this.aE = paramQzoneShuoShuoParams.aa;
    this.aF = paramQzoneShuoShuoParams.ac;
    this.aH = paramQzoneShuoShuoParams.ad;
    if ((!this.aC) && (!TextUtils.isEmpty(this.aD))) {
      QCircleHostAEHelper.saveMission(this.aD);
    }
    try
    {
      a(paramQzoneShuoShuoParams);
    }
    catch (Exception localException)
    {
      QLog.e("[upload2_QCircleUploadShuoShuoTask]", 1, "QCircleUploadShuoShuoTask... exception:", localException);
    }
    this.aG.put("up_type", String.valueOf(paramQzoneShuoShuoParams.Z));
    this.aG.put("up_source", String.valueOf(paramQzoneShuoShuoParams.Y));
  }
  
  private void J()
  {
    QLog.i("[upload2_QCircleUploadShuoShuoTask]", 1, C());
    D();
    QzoneMediaUploadParams localQzoneMediaUploadParams = new QzoneMediaUploadParams();
    localQzoneMediaUploadParams.a(4).b(this.z).a(this.Z).c(this.av).b(this.y).b(UploadTaskBatchUtil.a(this.Z)).c(this.v).d(113).a(this.u).a(this.E).a(this.g).a(this.h).c(this.G).d(this.aC).d(this.aD).e(this.aE).f(this.aF).a(this.aH);
    localQzoneMediaUploadParams.e(0);
    this.as = new QCircleUploadRequest(this.p, localQzoneMediaUploadParams, this, this, this);
  }
  
  private QQCircleFeedBase.StVideoBusiData K()
  {
    QQCircleFeedBase.StVideoBusiData localStVideoBusiData = new QQCircleFeedBase.StVideoBusiData();
    ArrayList localArrayList = new ArrayList();
    if (this.p != null)
    {
      if (this.p.get(0) == null) {
        return localStVideoBusiData;
      }
      MediaWrapper localMediaWrapper = (MediaWrapper)this.p.get(0);
      if (!TextUtils.isEmpty(localMediaWrapper.d))
      {
        localObject = new QQCircleFeedBase.StSimulateData();
        if (!TextUtils.isEmpty(localMediaWrapper.a)) {
          ((QQCircleFeedBase.StSimulateData)localObject).material_id.set(localMediaWrapper.a);
        }
        if (!TextUtils.isEmpty(localMediaWrapper.b)) {
          ((QQCircleFeedBase.StSimulateData)localObject).filter_id.set(localMediaWrapper.b);
        }
        if (!TextUtils.isEmpty(localMediaWrapper.c)) {
          ((QQCircleFeedBase.StSimulateData)localObject).simulate_name.set(localMediaWrapper.c);
        } else {
          ((QQCircleFeedBase.StSimulateData)localObject).simulate_name.set("拍同款");
        }
        if (!TextUtils.isEmpty(localMediaWrapper.d)) {
          ((QQCircleFeedBase.StSimulateData)localObject).simulate_schema.set(localMediaWrapper.d);
        }
        ((QQCircleFeedBase.StSimulateData)localObject).is_show_button.set(1);
        localStMaterialData = new QQCircleFeedBase.StMaterialData();
        if (!TextUtils.isEmpty(localMediaWrapper.a))
        {
          localStMaterialData.material_id.set(localMediaWrapper.a);
          localStMaterialData.interactive_type.set(1);
        }
        localStMaterialData.simulate_date.set((MessageMicro)localObject);
        localArrayList.add(localStMaterialData);
        QLog.d("[upload2_QCircleUploadShuoShuoTask]", 1, new Object[] { "onStepPublishQCircleFeed... index:", Integer.valueOf(0), " localmedia:", localMediaWrapper.toString() });
      }
      Object localObject = new QQCircleFeedBase.StKuoliePasterData();
      ((QQCircleFeedBase.StKuoliePasterData)localObject).kuolie_id.set(localMediaWrapper.k);
      ((QQCircleFeedBase.StKuoliePasterData)localObject).center_x.set(localMediaWrapper.l);
      ((QQCircleFeedBase.StKuoliePasterData)localObject).center_y.set(localMediaWrapper.m);
      ((QQCircleFeedBase.StKuoliePasterData)localObject).width.set(localMediaWrapper.o);
      ((QQCircleFeedBase.StKuoliePasterData)localObject).height.set(localMediaWrapper.p);
      ((QQCircleFeedBase.StKuoliePasterData)localObject).rotation.set(localMediaWrapper.n);
      QQCircleFeedBase.StMaterialData localStMaterialData = new QQCircleFeedBase.StMaterialData();
      localStMaterialData.material_id.set(((QQCircleFeedBase.StKuoliePasterData)localObject).kuolie_id.get());
      localStMaterialData.kuolie_data.set((MessageMicro)localObject);
      if (!TextUtils.isEmpty(localStMaterialData.material_id.get())) {
        localStMaterialData.interactive_type.set(2);
      }
      localArrayList.add(localStMaterialData);
      localObject = new QQCircleFeedBase.StMaterialData();
      ((QQCircleFeedBase.StMaterialData)localObject).material_id.set(localMediaWrapper.q);
      ((QQCircleFeedBase.StMaterialData)localObject).material_type.set("template");
      localArrayList.add(localObject);
      localObject = new QQCircleFeedBase.StMaterialData();
      ((QQCircleFeedBase.StMaterialData)localObject).material_id.set(localMediaWrapper.r);
      ((QQCircleFeedBase.StMaterialData)localObject).material_type.set("filter");
      localArrayList.add(localObject);
      localObject = new QQCircleFeedBase.StMaterialData();
      ((QQCircleFeedBase.StMaterialData)localObject).material_id.set(localMediaWrapper.s);
      ((QQCircleFeedBase.StMaterialData)localObject).material_type.set("sticker");
      localArrayList.add(localObject);
      localObject = new QQCircleFeedBase.StMaterialData();
      ((QQCircleFeedBase.StMaterialData)localObject).material_id.set(localMediaWrapper.t);
      ((QQCircleFeedBase.StMaterialData)localObject).material_type.set("text");
      localArrayList.add(localObject);
      localStVideoBusiData.material_datas.addAll(localArrayList);
    }
    return localStVideoBusiData;
  }
  
  private void L()
  {
    QLog.d("[upload2_QCircleUploadShuoShuoTask]", 1, "onStepPublishQCircleFeed... ");
    this.as = null;
    FeedCloudMeta.StFeed localStFeed = new FeedCloudMeta.StFeed();
    Object localObject1 = new FeedCloudMeta.StUser();
    ((FeedCloudMeta.StUser)localObject1).id.set(LoginData.a().c());
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onStepPublishPublicAccountFeed  syncToQzone: ");
      ((StringBuilder)localObject2).append(this.ay);
      QLog.d("[upload2_QCircleUploadShuoShuoTask]", 2, ((StringBuilder)localObject2).toString());
    }
    localStFeed.syncStatus.set(this.ay);
    localStFeed.poster.set((MessageMicro)localObject1);
    localObject1 = this.k;
    int m = 0;
    int i;
    Object localObject3;
    Object localObject4;
    if (localObject1 != null)
    {
      localObject1 = new FeedCloudMeta.StVideo();
      if (this.k.x != null)
      {
        QLog.d("[upload2_QCircleUploadShuoShuoTask]", 1, new Object[] { "onStepPublishQCircleFeed... videoInfo svid:", this.k.x });
        ((FeedCloudMeta.StVideo)localObject1).fileId.set(this.k.x);
      }
      ((FeedCloudMeta.StVideo)localObject1).width.set(this.k.j);
      ((FeedCloudMeta.StVideo)localObject1).height.set(this.k.k);
      ((FeedCloudMeta.StVideo)localObject1).fileSize.set((int)this.k.g);
      ((FeedCloudMeta.StVideo)localObject1).duration.set((int)this.k.f);
      ((FeedCloudMeta.StVideo)localObject1).transStatus.set(2);
      if (!TextUtils.isEmpty(this.k.z)) {
        ((FeedCloudMeta.StVideo)localObject1).videoMD5.set(this.k.z);
      }
      localObject2 = K();
      ((FeedCloudMeta.StVideo)localObject1).busiData.set(ByteStringMicro.copyFrom(((QQCircleFeedBase.StVideoBusiData)localObject2).toByteArray()));
      localStFeed.video.set((MessageMicro)localObject1);
      if ((this.e != null) && (this.e.picinfolist != null) && (this.e.picinfolist.size() > 0))
      {
        localObject1 = (PicInfo)this.e.picinfolist.get(0);
        localObject2 = new FeedCloudMeta.StImage();
        if (((PicInfo)localObject1).pic_url != null) {
          ((FeedCloudMeta.StImage)localObject2).picUrl.set(((PicInfo)localObject1).pic_url);
        }
        ((FeedCloudMeta.StImage)localObject2).width.set(((PicInfo)localObject1).picwidth);
        ((FeedCloudMeta.StImage)localObject2).height.set(((PicInfo)localObject1).picheight);
        localStFeed.cover.set((MessageMicro)localObject2);
      }
      localStFeed.type.set(3);
    }
    else
    {
      if ((this.e != null) && (this.e.picinfolist != null))
      {
        localObject1 = this.e.picinfolist.iterator();
        i = 0;
        int j = 0;
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (PicInfo)((Iterator)localObject1).next();
          int k;
          if (localObject2 == null) {
            k = j;
          }
          for (;;)
          {
            i += 1;
            j = k;
            break;
            QLog.d("[upload2_QCircleUploadShuoShuoTask]", 1, new Object[] { "onStepPublishQCircleFeed... picInfo pic_url:", ((PicInfo)localObject2).pic_url });
            localObject3 = new FeedCloudMeta.StImage();
            if (((PicInfo)localObject2).pic_url != null) {
              ((FeedCloudMeta.StImage)localObject3).picUrl.set(((PicInfo)localObject2).pic_url);
            }
            ((FeedCloudMeta.StImage)localObject3).width.set(((PicInfo)localObject2).picwidth);
            ((FeedCloudMeta.StImage)localObject3).height.set(((PicInfo)localObject2).picheight);
            if (!TextUtils.isEmpty(((PicInfo)localObject2).picmd5)) {
              ((FeedCloudMeta.StImage)localObject3).imageMD5.set(((PicInfo)localObject2).picmd5);
            }
            localObject4 = e(i);
            ((FeedCloudMeta.StImage)localObject3).busiData.set(ByteStringMicro.copyFrom(((QQCircleFeedBase.StImageBusiData)localObject4).toByteArray()));
            localStFeed.images.add((MessageMicro)localObject3);
            k = j;
            if (j == 0)
            {
              localObject3 = new FeedCloudMeta.StImage();
              if (((PicInfo)localObject2).pic_url != null) {
                ((FeedCloudMeta.StImage)localObject3).picUrl.set(((PicInfo)localObject2).pic_url);
              }
              ((FeedCloudMeta.StImage)localObject3).width.set(((PicInfo)localObject2).picwidth);
              ((FeedCloudMeta.StImage)localObject3).height.set(((PicInfo)localObject2).picheight);
              localStFeed.cover.set((MessageMicro)localObject3);
              k = 1;
            }
          }
        }
      }
      localStFeed.type.set(2);
    }
    if (this.K != null) {
      localStFeed.title.set(this.K);
    }
    if (this.a != null) {
      localStFeed.content.set(this.a);
    }
    localObject1 = this.h;
    if (localObject1 != null)
    {
      localObject2 = new FeedCloudMeta.StPoiInfoV2();
      if (((LbsDataV2.PoiInfo)localObject1).poiId != null) {
        ((FeedCloudMeta.StPoiInfoV2)localObject2).poiId.set(((LbsDataV2.PoiInfo)localObject1).poiId);
      }
      if (((LbsDataV2.PoiInfo)localObject1).poiName != null) {
        ((FeedCloudMeta.StPoiInfoV2)localObject2).name.set(((LbsDataV2.PoiInfo)localObject1).poiName);
      }
      if (((LbsDataV2.PoiInfo)localObject1).poiTypeName != null) {
        ((FeedCloudMeta.StPoiInfoV2)localObject2).typeName.set(((LbsDataV2.PoiInfo)localObject1).poiTypeName);
      }
      if (((LbsDataV2.PoiInfo)localObject1).poiTypeName != null) {
        ((FeedCloudMeta.StPoiInfoV2)localObject2).address.set(((LbsDataV2.PoiInfo)localObject1).address);
      }
      if (((LbsDataV2.PoiInfo)localObject1).poiTypeName != null) {
        ((FeedCloudMeta.StPoiInfoV2)localObject2).districtCode.set(((LbsDataV2.PoiInfo)localObject1).districtCode);
      }
      localObject3 = ((LbsDataV2.PoiInfo)localObject1).gpsInfo;
      if (localObject3 != null)
      {
        localObject4 = new FeedCloudMeta.StGPSV2();
        ((FeedCloudMeta.StGPSV2)localObject4).lat.set(((LbsDataV2.GpsInfo)localObject3).lat);
        ((FeedCloudMeta.StGPSV2)localObject4).lon.set(((LbsDataV2.GpsInfo)localObject3).lon);
        ((FeedCloudMeta.StGPSV2)localObject4).eType.set(((LbsDataV2.GpsInfo)localObject3).gpsType);
        ((FeedCloudMeta.StGPSV2)localObject4).alt.set(((LbsDataV2.GpsInfo)localObject3).alt);
        ((FeedCloudMeta.StPoiInfoV2)localObject2).gps.set((MessageMicro)localObject4);
      }
      ((FeedCloudMeta.StPoiInfoV2)localObject2).distance.set(((LbsDataV2.PoiInfo)localObject1).distance);
      ((FeedCloudMeta.StPoiInfoV2)localObject2).hotValue.set(((LbsDataV2.PoiInfo)localObject1).hotValue);
      if (((LbsDataV2.PoiInfo)localObject1).phoneNumber != null) {
        ((FeedCloudMeta.StPoiInfoV2)localObject2).phone.set(((LbsDataV2.PoiInfo)localObject1).phoneNumber);
      }
      if (((LbsDataV2.PoiInfo)localObject1).country != null) {
        ((FeedCloudMeta.StPoiInfoV2)localObject2).country.set(((LbsDataV2.PoiInfo)localObject1).country);
      }
      if (((LbsDataV2.PoiInfo)localObject1).province != null) {
        ((FeedCloudMeta.StPoiInfoV2)localObject2).province.set(((LbsDataV2.PoiInfo)localObject1).province);
      }
      if (((LbsDataV2.PoiInfo)localObject1).city != null) {
        ((FeedCloudMeta.StPoiInfoV2)localObject2).city.set(((LbsDataV2.PoiInfo)localObject1).city);
      }
      ((FeedCloudMeta.StPoiInfoV2)localObject2).poiNum.set(((LbsDataV2.PoiInfo)localObject1).poiNum);
      ((FeedCloudMeta.StPoiInfoV2)localObject2).poiOrderType.set(((LbsDataV2.PoiInfo)localObject1).poiOrderType);
      if (((LbsDataV2.PoiInfo)localObject1).poiDefaultName != null) {
        ((FeedCloudMeta.StPoiInfoV2)localObject2).defaultName.set(((LbsDataV2.PoiInfo)localObject1).poiDefaultName);
      }
      if (((LbsDataV2.PoiInfo)localObject1).district != null) {
        ((FeedCloudMeta.StPoiInfoV2)localObject2).district.set(((LbsDataV2.PoiInfo)localObject1).district);
      }
      if (((LbsDataV2.PoiInfo)localObject1).dianPingId != null) {
        ((FeedCloudMeta.StPoiInfoV2)localObject2).dianPingId.set(((LbsDataV2.PoiInfo)localObject1).dianPingId);
      }
      localStFeed.poiInfo.set((MessageMicro)localObject2);
    }
    localObject1 = this.aB;
    if ((localObject1 != null) && (((ArrayList)localObject1).size() != 0))
    {
      i = m;
      while (i < this.aB.size())
      {
        localObject1 = new FeedCloudMeta.StTagInfo();
        ((FeedCloudMeta.StTagInfo)localObject1).tagName.set(((LabelInfo)this.aB.get(i)).name);
        localStFeed.tagInfos.add((MessageMicro)localObject1);
        i += 1;
      }
    }
    this.aG.put("clientkey", this.av);
    localObject1 = new FeedCloudMeta.StClientInfo();
    ((FeedCloudMeta.StClientInfo)localObject1).feedclientkey.set(this.av);
    localStFeed.clientInfo.set((MessageMicro)localObject1);
    a(localStFeed, this.aG);
  }
  
  private void M()
  {
    QCircleTaskQueue.a().b(this, true);
  }
  
  private void N()
  {
    QCircleTaskQueue.a().a(this, true);
  }
  
  /* Error */
  private void a(QzoneShuoShuoParams paramQzoneShuoShuoParams)
  {
    // Byte code:
    //   0: new 479	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   7: astore_3
    //   8: aload_0
    //   9: getfield 39	com/tencent/biz/qqcircle/publish/task/QCircleUploadShuoShuoTask:aB	Ljava/util/ArrayList;
    //   12: ifnull +85 -> 97
    //   15: iconst_0
    //   16: istore_2
    //   17: iload_2
    //   18: aload_0
    //   19: getfield 39	com/tencent/biz/qqcircle/publish/task/QCircleUploadShuoShuoTask:aB	Ljava/util/ArrayList;
    //   22: invokevirtual 578	java/util/ArrayList:size	()I
    //   25: if_icmpge +72 -> 97
    //   28: iload_2
    //   29: aload_0
    //   30: getfield 39	com/tencent/biz/qqcircle/publish/task/QCircleUploadShuoShuoTask:aB	Ljava/util/ArrayList;
    //   33: invokevirtual 578	java/util/ArrayList:size	()I
    //   36: iconst_1
    //   37: isub
    //   38: if_icmpeq +33 -> 71
    //   41: aload_3
    //   42: aload_0
    //   43: getfield 39	com/tencent/biz/qqcircle/publish/task/QCircleUploadShuoShuoTask:aB	Ljava/util/ArrayList;
    //   46: iload_2
    //   47: invokevirtual 579	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   50: checkcast 795	cooperation/qzone/model/LabelInfo
    //   53: getfield 797	cooperation/qzone/model/LabelInfo:name	Ljava/lang/String;
    //   56: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload_3
    //   61: ldc_w 830
    //   64: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: goto +22 -> 90
    //   71: aload_3
    //   72: aload_0
    //   73: getfield 39	com/tencent/biz/qqcircle/publish/task/QCircleUploadShuoShuoTask:aB	Ljava/util/ArrayList;
    //   76: iload_2
    //   77: invokevirtual 579	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   80: checkcast 795	cooperation/qzone/model/LabelInfo
    //   83: getfield 797	cooperation/qzone/model/LabelInfo:name	Ljava/lang/String;
    //   86: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: iload_2
    //   91: iconst_1
    //   92: iadd
    //   93: istore_2
    //   94: goto -77 -> 17
    //   97: iconst_0
    //   98: istore_2
    //   99: iload_2
    //   100: aload_0
    //   101: getfield 278	com/tencent/biz/qqcircle/publish/task/QCircleUploadShuoShuoTask:p	Ljava/util/List;
    //   104: invokeinterface 831 1 0
    //   109: if_icmpge +690 -> 799
    //   112: new 833	cooperation/qqcircle/report/QCircleTaskReportInfo
    //   115: dup
    //   116: invokespecial 834	cooperation/qqcircle/report/QCircleTaskReportInfo:<init>	()V
    //   119: astore 4
    //   121: aload 4
    //   123: invokestatic 471	com/tencent/biz/qqcircle/publish/account/LoginData:a	()Lcom/tencent/biz/qqcircle/publish/account/LoginData;
    //   126: invokevirtual 837	com/tencent/biz/qqcircle/publish/account/LoginData:b	()J
    //   129: putfield 840	cooperation/qqcircle/report/QCircleTaskReportInfo:author_uin	J
    //   132: aload 4
    //   134: aload_3
    //   135: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: putfield 843	cooperation/qqcircle/report/QCircleTaskReportInfo:feed_tag	Ljava/lang/String;
    //   141: aload 4
    //   143: aload_1
    //   144: getfield 844	com/tencent/biz/qqcircle/publish/model/QzoneShuoShuoParams:b	Ljava/lang/String;
    //   147: putfield 847	cooperation/qqcircle/report/QCircleTaskReportInfo:txtinfo	Ljava/lang/String;
    //   150: aload 4
    //   152: aload_0
    //   153: getfield 278	com/tencent/biz/qqcircle/publish/task/QCircleUploadShuoShuoTask:p	Ljava/util/List;
    //   156: invokeinterface 831 1 0
    //   161: putfield 850	cooperation/qqcircle/report/QCircleTaskReportInfo:total_upload_num	I
    //   164: aload 4
    //   166: aload_1
    //   167: getfield 171	com/tencent/biz/qqcircle/publish/model/QzoneShuoShuoParams:Y	I
    //   170: putfield 852	cooperation/qqcircle/report/QCircleTaskReportInfo:up_source	I
    //   173: aload 4
    //   175: aload_1
    //   176: getfield 157	com/tencent/biz/qqcircle/publish/model/QzoneShuoShuoParams:Z	I
    //   179: putfield 854	cooperation/qqcircle/report/QCircleTaskReportInfo:up_type	I
    //   182: aload_0
    //   183: getfield 856	com/tencent/biz/qqcircle/publish/task/QCircleUploadShuoShuoTask:x	LNS_MOBILE_OPERATION/LbsInfo;
    //   186: ifnull +119 -> 305
    //   189: new 479	java/lang/StringBuilder
    //   192: dup
    //   193: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   196: astore 5
    //   198: aload 5
    //   200: aload_0
    //   201: getfield 856	com/tencent/biz/qqcircle/publish/task/QCircleUploadShuoShuoTask:x	LNS_MOBILE_OPERATION/LbsInfo;
    //   204: getfield 861	NS_MOBILE_OPERATION/LbsInfo:lbs_x	Ljava/lang/String;
    //   207: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: aload 5
    //   213: ldc_w 830
    //   216: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: pop
    //   220: aload 5
    //   222: aload_0
    //   223: getfield 856	com/tencent/biz/qqcircle/publish/task/QCircleUploadShuoShuoTask:x	LNS_MOBILE_OPERATION/LbsInfo;
    //   226: getfield 864	NS_MOBILE_OPERATION/LbsInfo:lbs_y	Ljava/lang/String;
    //   229: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: aload 4
    //   235: aload 5
    //   237: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: putfield 867	cooperation/qqcircle/report/QCircleTaskReportInfo:up_place	Ljava/lang/String;
    //   243: aload_1
    //   244: getfield 157	com/tencent/biz/qqcircle/publish/model/QzoneShuoShuoParams:Z	I
    //   247: iconst_1
    //   248: if_icmpne +57 -> 305
    //   251: new 479	java/lang/StringBuilder
    //   254: dup
    //   255: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   258: astore 5
    //   260: aload 5
    //   262: aload_0
    //   263: getfield 856	com/tencent/biz/qqcircle/publish/task/QCircleUploadShuoShuoTask:x	LNS_MOBILE_OPERATION/LbsInfo;
    //   266: getfield 861	NS_MOBILE_OPERATION/LbsInfo:lbs_x	Ljava/lang/String;
    //   269: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: pop
    //   273: aload 5
    //   275: ldc_w 830
    //   278: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: pop
    //   282: aload 5
    //   284: aload_0
    //   285: getfield 856	com/tencent/biz/qqcircle/publish/task/QCircleUploadShuoShuoTask:x	LNS_MOBILE_OPERATION/LbsInfo;
    //   288: getfield 864	NS_MOBILE_OPERATION/LbsInfo:lbs_y	Ljava/lang/String;
    //   291: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: pop
    //   295: aload 4
    //   297: aload 5
    //   299: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   302: putfield 870	cooperation/qqcircle/report/QCircleTaskReportInfo:shoot_place	Ljava/lang/String;
    //   305: aload_0
    //   306: getfield 278	com/tencent/biz/qqcircle/publish/task/QCircleUploadShuoShuoTask:p	Ljava/util/List;
    //   309: iload_2
    //   310: invokeinterface 296 2 0
    //   315: checkcast 298	com/tencent/biz/qqcircle/publish/model/MediaWrapper
    //   318: astore 6
    //   320: aload 6
    //   322: invokevirtual 872	com/tencent/biz/qqcircle/publish/model/MediaWrapper:b	()Z
    //   325: ifeq +155 -> 480
    //   328: aload 4
    //   330: aload 6
    //   332: invokevirtual 875	com/tencent/biz/qqcircle/publish/model/MediaWrapper:d	()Lcom/tencent/biz/qqcircle/publish/model/ImageInfo;
    //   335: getfield 879	com/tencent/biz/qqcircle/publish/model/ImageInfo:o	I
    //   338: putfield 882	cooperation/qqcircle/report/QCircleTaskReportInfo:origPicWidth	I
    //   341: aload 4
    //   343: aload 6
    //   345: invokevirtual 875	com/tencent/biz/qqcircle/publish/model/MediaWrapper:d	()Lcom/tencent/biz/qqcircle/publish/model/ImageInfo;
    //   348: getfield 884	com/tencent/biz/qqcircle/publish/model/ImageInfo:p	I
    //   351: putfield 887	cooperation/qqcircle/report/QCircleTaskReportInfo:origPicHeight	I
    //   354: aload 4
    //   356: aload 6
    //   358: invokevirtual 875	com/tencent/biz/qqcircle/publish/model/MediaWrapper:d	()Lcom/tencent/biz/qqcircle/publish/model/ImageInfo;
    //   361: getfield 889	com/tencent/biz/qqcircle/publish/model/ImageInfo:q	J
    //   364: ldc2_w 890
    //   367: ldiv
    //   368: putfield 894	cooperation/qqcircle/report/QCircleTaskReportInfo:origPicSize	J
    //   371: aload 4
    //   373: aload 6
    //   375: invokevirtual 875	com/tencent/biz/qqcircle/publish/model/MediaWrapper:d	()Lcom/tencent/biz/qqcircle/publish/model/ImageInfo;
    //   378: getfield 896	com/tencent/biz/qqcircle/publish/model/ImageInfo:n	I
    //   381: putfield 899	cooperation/qqcircle/report/QCircleTaskReportInfo:editedPicHeight	I
    //   384: aload 4
    //   386: aload 6
    //   388: invokevirtual 875	com/tencent/biz/qqcircle/publish/model/MediaWrapper:d	()Lcom/tencent/biz/qqcircle/publish/model/ImageInfo;
    //   391: getfield 901	com/tencent/biz/qqcircle/publish/model/ImageInfo:m	I
    //   394: putfield 904	cooperation/qqcircle/report/QCircleTaskReportInfo:editedPicWidth	I
    //   397: aload 4
    //   399: aload 6
    //   401: invokevirtual 875	com/tencent/biz/qqcircle/publish/model/MediaWrapper:d	()Lcom/tencent/biz/qqcircle/publish/model/ImageInfo;
    //   404: getfield 906	com/tencent/biz/qqcircle/publish/model/ImageInfo:c	J
    //   407: ldc2_w 890
    //   410: ldiv
    //   411: putfield 909	cooperation/qqcircle/report/QCircleTaskReportInfo:editedPicSize	J
    //   414: aload 6
    //   416: invokevirtual 875	com/tencent/biz/qqcircle/publish/model/MediaWrapper:d	()Lcom/tencent/biz/qqcircle/publish/model/ImageInfo;
    //   419: getfield 910	com/tencent/biz/qqcircle/publish/model/ImageInfo:r	Ljava/lang/String;
    //   422: ifnonnull +14 -> 436
    //   425: aload 4
    //   427: ldc_w 912
    //   430: putfield 915	cooperation/qqcircle/report/QCircleTaskReportInfo:picture_format	Ljava/lang/String;
    //   433: goto +24 -> 457
    //   436: aload 4
    //   438: aload 6
    //   440: invokevirtual 875	com/tencent/biz/qqcircle/publish/model/MediaWrapper:d	()Lcom/tencent/biz/qqcircle/publish/model/ImageInfo;
    //   443: getfield 910	com/tencent/biz/qqcircle/publish/model/ImageInfo:r	Ljava/lang/String;
    //   446: ldc_w 917
    //   449: invokevirtual 921	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   452: iconst_1
    //   453: aaload
    //   454: putfield 915	cooperation/qqcircle/report/QCircleTaskReportInfo:picture_format	Ljava/lang/String;
    //   457: aload 4
    //   459: iconst_0
    //   460: putfield 924	cooperation/qqcircle/report/QCircleTaskReportInfo:is_video	I
    //   463: aload_0
    //   464: aload 4
    //   466: aload 6
    //   468: invokevirtual 875	com/tencent/biz/qqcircle/publish/model/MediaWrapper:d	()Lcom/tencent/biz/qqcircle/publish/model/ImageInfo;
    //   471: getfield 925	com/tencent/biz/qqcircle/publish/model/ImageInfo:a	Ljava/lang/String;
    //   474: invokespecial 928	com/tencent/biz/qqcircle/publish/task/QCircleUploadShuoShuoTask:a	(Lcooperation/qqcircle/report/QCircleTaskReportInfo;Ljava/lang/String;)V
    //   477: goto +305 -> 782
    //   480: aload 6
    //   482: invokevirtual 930	com/tencent/biz/qqcircle/publish/model/MediaWrapper:a	()Z
    //   485: ifeq +297 -> 782
    //   488: aload 4
    //   490: aload 6
    //   492: getfield 932	com/tencent/biz/qqcircle/publish/model/MediaWrapper:f	I
    //   495: putfield 882	cooperation/qqcircle/report/QCircleTaskReportInfo:origPicWidth	I
    //   498: aload 4
    //   500: aload 6
    //   502: getfield 934	com/tencent/biz/qqcircle/publish/model/MediaWrapper:g	I
    //   505: putfield 887	cooperation/qqcircle/report/QCircleTaskReportInfo:origPicHeight	I
    //   508: aload 4
    //   510: aload 6
    //   512: getfield 936	com/tencent/biz/qqcircle/publish/model/MediaWrapper:h	J
    //   515: ldc2_w 890
    //   518: ldiv
    //   519: putfield 894	cooperation/qqcircle/report/QCircleTaskReportInfo:origPicSize	J
    //   522: aload 4
    //   524: aload 6
    //   526: getfield 938	com/tencent/biz/qqcircle/publish/model/MediaWrapper:i	J
    //   529: putfield 941	cooperation/qqcircle/report/QCircleTaskReportInfo:mediaOriginBitrate	J
    //   532: aload 4
    //   534: aload 6
    //   536: invokevirtual 944	com/tencent/biz/qqcircle/publish/model/MediaWrapper:c	()Lcom/tencent/biz/qqcircle/publish/model/ShuoshuoVideoInfo;
    //   539: getfield 523	com/tencent/biz/qqcircle/publish/model/ShuoshuoVideoInfo:k	I
    //   542: putfield 899	cooperation/qqcircle/report/QCircleTaskReportInfo:editedPicHeight	I
    //   545: aload 4
    //   547: aload 6
    //   549: invokevirtual 944	com/tencent/biz/qqcircle/publish/model/MediaWrapper:c	()Lcom/tencent/biz/qqcircle/publish/model/ShuoshuoVideoInfo;
    //   552: getfield 519	com/tencent/biz/qqcircle/publish/model/ShuoshuoVideoInfo:j	I
    //   555: putfield 904	cooperation/qqcircle/report/QCircleTaskReportInfo:editedPicWidth	I
    //   558: aload 4
    //   560: aload 6
    //   562: invokevirtual 944	com/tencent/biz/qqcircle/publish/model/MediaWrapper:c	()Lcom/tencent/biz/qqcircle/publish/model/ShuoshuoVideoInfo;
    //   565: getfield 528	com/tencent/biz/qqcircle/publish/model/ShuoshuoVideoInfo:g	J
    //   568: ldc2_w 890
    //   571: ldiv
    //   572: putfield 909	cooperation/qqcircle/report/QCircleTaskReportInfo:editedPicSize	J
    //   575: aload 4
    //   577: aload 6
    //   579: getfield 946	com/tencent/biz/qqcircle/publish/model/MediaWrapper:j	J
    //   582: putfield 949	cooperation/qqcircle/report/QCircleTaskReportInfo:editedVideoMediaBitrate	J
    //   585: aload 4
    //   587: ldc_w 951
    //   590: putfield 915	cooperation/qqcircle/report/QCircleTaskReportInfo:picture_format	Ljava/lang/String;
    //   593: aload 4
    //   595: iconst_1
    //   596: putfield 924	cooperation/qqcircle/report/QCircleTaskReportInfo:is_video	I
    //   599: aload 6
    //   601: invokevirtual 944	com/tencent/biz/qqcircle/publish/model/MediaWrapper:c	()Lcom/tencent/biz/qqcircle/publish/model/ShuoshuoVideoInfo;
    //   604: getfield 953	com/tencent/biz/qqcircle/publish/model/ShuoshuoVideoInfo:y	Ljava/util/ArrayList;
    //   607: ifnull +175 -> 782
    //   610: aload 6
    //   612: invokevirtual 944	com/tencent/biz/qqcircle/publish/model/MediaWrapper:c	()Lcom/tencent/biz/qqcircle/publish/model/ShuoshuoVideoInfo;
    //   615: getfield 953	com/tencent/biz/qqcircle/publish/model/ShuoshuoVideoInfo:y	Ljava/util/ArrayList;
    //   618: invokevirtual 578	java/util/ArrayList:size	()I
    //   621: ifle +161 -> 782
    //   624: new 955	android/media/MediaMetadataRetriever
    //   627: dup
    //   628: invokespecial 956	android/media/MediaMetadataRetriever:<init>	()V
    //   631: astore 5
    //   633: aload 6
    //   635: invokevirtual 944	com/tencent/biz/qqcircle/publish/model/MediaWrapper:c	()Lcom/tencent/biz/qqcircle/publish/model/ShuoshuoVideoInfo;
    //   638: getfield 953	com/tencent/biz/qqcircle/publish/model/ShuoshuoVideoInfo:y	Ljava/util/ArrayList;
    //   641: iconst_0
    //   642: invokevirtual 579	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   645: checkcast 159	java/lang/String
    //   648: ldc_w 951
    //   651: invokevirtual 960	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   654: ifeq +73 -> 727
    //   657: aload 5
    //   659: aload 6
    //   661: invokevirtual 944	com/tencent/biz/qqcircle/publish/model/MediaWrapper:c	()Lcom/tencent/biz/qqcircle/publish/model/ShuoshuoVideoInfo;
    //   664: getfield 953	com/tencent/biz/qqcircle/publish/model/ShuoshuoVideoInfo:y	Ljava/util/ArrayList;
    //   667: iconst_0
    //   668: invokevirtual 579	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   671: checkcast 159	java/lang/String
    //   674: invokevirtual 963	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   677: ldc 85
    //   679: iconst_1
    //   680: iconst_4
    //   681: anewarray 87	java/lang/Object
    //   684: dup
    //   685: iconst_0
    //   686: ldc_w 965
    //   689: aastore
    //   690: dup
    //   691: iconst_1
    //   692: aload 5
    //   694: bipush 23
    //   696: invokevirtual 968	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   699: aastore
    //   700: dup
    //   701: iconst_2
    //   702: ldc_w 970
    //   705: aastore
    //   706: dup
    //   707: iconst_3
    //   708: aload 6
    //   710: invokevirtual 944	com/tencent/biz/qqcircle/publish/model/MediaWrapper:c	()Lcom/tencent/biz/qqcircle/publish/model/ShuoshuoVideoInfo;
    //   713: getfield 953	com/tencent/biz/qqcircle/publish/model/ShuoshuoVideoInfo:y	Ljava/util/ArrayList;
    //   716: iconst_0
    //   717: invokevirtual 579	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   720: aastore
    //   721: invokestatic 111	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   724: goto +43 -> 767
    //   727: aload_0
    //   728: aload 4
    //   730: aload 6
    //   732: invokevirtual 944	com/tencent/biz/qqcircle/publish/model/MediaWrapper:c	()Lcom/tencent/biz/qqcircle/publish/model/ShuoshuoVideoInfo;
    //   735: getfield 953	com/tencent/biz/qqcircle/publish/model/ShuoshuoVideoInfo:y	Ljava/util/ArrayList;
    //   738: iconst_0
    //   739: invokevirtual 579	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   742: checkcast 159	java/lang/String
    //   745: invokespecial 928	com/tencent/biz/qqcircle/publish/task/QCircleUploadShuoShuoTask:a	(Lcooperation/qqcircle/report/QCircleTaskReportInfo;Ljava/lang/String;)V
    //   748: goto +19 -> 767
    //   751: astore_1
    //   752: goto +23 -> 775
    //   755: astore 6
    //   757: ldc 85
    //   759: iconst_1
    //   760: ldc 149
    //   762: aload 6
    //   764: invokestatic 153	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   767: aload 5
    //   769: invokevirtual 973	android/media/MediaMetadataRetriever:release	()V
    //   772: goto +10 -> 782
    //   775: aload 5
    //   777: invokevirtual 973	android/media/MediaMetadataRetriever:release	()V
    //   780: aload_1
    //   781: athrow
    //   782: aload_0
    //   783: getfield 50	com/tencent/biz/qqcircle/publish/task/QCircleUploadShuoShuoTask:aI	Ljava/util/ArrayList;
    //   786: aload 4
    //   788: invokevirtual 974	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   791: pop
    //   792: iload_2
    //   793: iconst_1
    //   794: iadd
    //   795: istore_2
    //   796: goto -697 -> 99
    //   799: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	800	0	this	QCircleUploadShuoShuoTask
    //   0	800	1	paramQzoneShuoShuoParams	QzoneShuoShuoParams
    //   16	780	2	i	int
    //   7	128	3	localStringBuilder	StringBuilder
    //   119	668	4	localQCircleTaskReportInfo	QCircleTaskReportInfo
    //   196	580	5	localObject	Object
    //   318	413	6	localMediaWrapper	MediaWrapper
    //   755	8	6	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   633	724	751	finally
    //   727	748	751	finally
    //   757	767	751	finally
    //   633	724	755	java/lang/Exception
    //   727	748	755	java/lang/Exception
  }
  
  private void a(QCircleUploadShuoShuoTask.ResultParmas paramResultParmas)
  {
    QLog.d("[upload2_QCircleUploadShuoShuoTask]", 1, "processPublishData...");
    RFThreadManager.getSerialThreadHandler().removeCallbacks(this.aJ);
    long l = paramResultParmas.a;
    String str1 = paramResultParmas.b;
    String str2 = paramResultParmas.c;
    paramResultParmas = paramResultParmas.e;
    d((int)l);
    a(str1);
    int i = 0;
    while (i < this.aI.size())
    {
      ((QCircleTaskReportInfo)this.aI.get(i)).feedid = str2;
      ((QCircleTaskReportInfo)this.aI.get(i)).traceId = paramResultParmas;
      ((QCircleTaskReportInfo)this.aI.get(i)).retCode = l;
      QLog.d("[upload2_QCircleUploadShuoShuoTask]", 1, new Object[] { "PublishFeedResultCallback onCallback... i:", Integer.valueOf(i), " report:", ((QCircleTaskReportInfo)this.aI.get(i)).toString() });
      i += 1;
    }
    QCircleLpReportDc05494.report(this.aI);
    QCirclePublishReport.a(this.aI);
    if (l == 0L)
    {
      QCircleTaskQueue.a().a(this, true);
      return;
    }
    if (l == 10027L)
    {
      QCircleTaskQueue.a().a(this, true);
      return;
    }
    QCircleTaskQueue.a().a(this, false);
  }
  
  private void a(QCircleFakeFeed.Builder paramBuilder, int paramInt)
  {
    QCircleUploadShuoShuoTask localQCircleUploadShuoShuoTask = this;
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    ArrayList localArrayList5 = new ArrayList();
    ArrayList localArrayList6 = new ArrayList();
    ArrayList localArrayList7 = new ArrayList();
    ArrayList localArrayList8 = new ArrayList();
    ArrayList localArrayList9 = new ArrayList();
    ArrayList localArrayList10 = new ArrayList();
    ArrayList localArrayList11 = new ArrayList();
    int i = 0;
    while ((i < localQCircleUploadShuoShuoTask.p.size()) && (i < paramInt))
    {
      QQCircleFeedBase.StSimulateData localStSimulateData = new QQCircleFeedBase.StSimulateData();
      MediaWrapper localMediaWrapper = (MediaWrapper)localQCircleUploadShuoShuoTask.p.get(i);
      if (localMediaWrapper != null)
      {
        localStSimulateData.material_id.set(localMediaWrapper.a);
        localStSimulateData.filter_id.set(localMediaWrapper.b);
        if (!TextUtils.isEmpty(localMediaWrapper.c)) {
          localStSimulateData.simulate_name.set(localMediaWrapper.c);
        } else {
          localStSimulateData.simulate_name.set("拍同款");
        }
        if (!TextUtils.isEmpty(localMediaWrapper.d)) {
          localStSimulateData.is_show_button.set(1);
        }
        localStSimulateData.simulate_schema.set(localMediaWrapper.d);
        localArrayList1.add(localStSimulateData.material_id.get());
        localArrayList2.add(localStSimulateData.filter_id.get());
        localArrayList3.add(localStSimulateData.simulate_name.get());
        localArrayList4.add(localStSimulateData.simulate_schema.get());
        localArrayList5.add(Integer.valueOf(localMediaWrapper.e));
        localArrayList6.add(localMediaWrapper.k);
        localArrayList7.add(Float.valueOf(localMediaWrapper.l));
        localArrayList8.add(Float.valueOf(localMediaWrapper.m));
        localArrayList9.add(Float.valueOf(localMediaWrapper.o));
        localArrayList10.add(Float.valueOf(localMediaWrapper.p));
        localArrayList11.add(Float.valueOf(localMediaWrapper.n));
        localQCircleUploadShuoShuoTask = this;
        QLog.d("[upload2_QCircleUploadShuoShuoTask]", 1, new Object[] { "createQCircleFakeFeed... index:", Integer.valueOf(i), " localmedia:", ((MediaWrapper)localQCircleUploadShuoShuoTask.p.get(i)).toString(), " stSimulateData:", localStSimulateData.toString() });
      }
      i += 1;
    }
    paramBuilder.setMaterialId(localArrayList1).setFilterId(localArrayList2).setSimulateName(localArrayList3).setSimulateSchema(localArrayList4).setShowCircleTakeSame(localArrayList5).setKuolieId(localArrayList6).setKuolieCentreX(localArrayList7).setKuolieCentreY(localArrayList8).setKuolieWidthScale(localArrayList9).setKuolieHeightScale(localArrayList10).setKuolieRotate(localArrayList11);
  }
  
  private void a(QCircleTaskReportInfo paramQCircleTaskReportInfo, String paramString)
  {
    try
    {
      if (JpegExifReader.isCrashJpeg(paramString)) {
        break label165;
      }
      Object localObject = new ExifInterface(paramString);
      String str1 = ((ExifInterface)localObject).getAttribute("Model");
      String str2 = ((ExifInterface)localObject).getAttribute("Make");
      String str3 = ((ExifInterface)localObject).getAttribute("DateTime");
      paramString = new float[2];
      boolean bool = ((ExifInterface)localObject).getLatLong(paramString);
      if (!TextUtils.isEmpty(str3)) {
        paramQCircleTaskReportInfo.shooting_time = String.valueOf(DateUtil.a(str3));
      }
      if (!TextUtils.isEmpty(str2)) {
        paramQCircleTaskReportInfo.shoot_product = str2;
      }
      if (!TextUtils.isEmpty(str1)) {
        paramQCircleTaskReportInfo.shoot_model = str1;
      }
      if (!bool) {
        break label165;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString[1]);
      ((StringBuilder)localObject).append("|");
      ((StringBuilder)localObject).append(paramString[0]);
      paramQCircleTaskReportInfo.place = ((StringBuilder)localObject).toString();
      return;
    }
    catch (Exception paramQCircleTaskReportInfo)
    {
      label156:
      label165:
      break label156;
    }
    QLog.e("[upload2_QCircleUploadShuoShuoTask]", 1, "read pic exif error");
  }
  
  private void b(QCircleFakeFeed paramQCircleFakeFeed, int paramInt, QCircleUploadShuoShuoTask.ResultParmas paramResultParmas)
  {
    VSNetworkHelper.getInstance().sendRequest(new QCircleGetFeedDetailRequest(paramQCircleFakeFeed.getFeedId(), HostDataTransUtils.getAccount(), paramQCircleFakeFeed.getCreateTime(), true), new QCircleUploadShuoShuoTask.3(this, paramQCircleFakeFeed, paramResultParmas, paramInt));
  }
  
  private QQCircleFeedBase.StImageBusiData e(int paramInt)
  {
    QQCircleFeedBase.StImageBusiData localStImageBusiData = new QQCircleFeedBase.StImageBusiData();
    ArrayList localArrayList = new ArrayList();
    if (paramInt < this.p.size())
    {
      Object localObject = new QQCircleFeedBase.StSimulateData();
      if (!TextUtils.isEmpty(((MediaWrapper)this.p.get(paramInt)).a)) {
        ((QQCircleFeedBase.StSimulateData)localObject).material_id.set(((MediaWrapper)this.p.get(paramInt)).a);
      }
      if (!TextUtils.isEmpty(((MediaWrapper)this.p.get(paramInt)).b)) {
        ((QQCircleFeedBase.StSimulateData)localObject).filter_id.set(((MediaWrapper)this.p.get(paramInt)).b);
      }
      if (!TextUtils.isEmpty(((MediaWrapper)this.p.get(paramInt)).c)) {
        ((QQCircleFeedBase.StSimulateData)localObject).simulate_name.set(((MediaWrapper)this.p.get(paramInt)).c);
      } else {
        ((QQCircleFeedBase.StSimulateData)localObject).simulate_name.set("拍同款");
      }
      if (!TextUtils.isEmpty(((MediaWrapper)this.p.get(paramInt)).d))
      {
        ((QQCircleFeedBase.StSimulateData)localObject).simulate_schema.set(((MediaWrapper)this.p.get(paramInt)).d);
        ((QQCircleFeedBase.StSimulateData)localObject).is_show_button.set(1);
      }
      QQCircleFeedBase.StMaterialData localStMaterialData = new QQCircleFeedBase.StMaterialData();
      if (!TextUtils.isEmpty(((MediaWrapper)this.p.get(paramInt)).a))
      {
        localStMaterialData.material_id.set(((MediaWrapper)this.p.get(paramInt)).a);
        localStMaterialData.interactive_type.set(1);
      }
      localStMaterialData.simulate_date.set((MessageMicro)localObject);
      localArrayList.add(localStMaterialData);
      QLog.d("[upload2_QCircleUploadShuoShuoTask]", 1, new Object[] { "onStepPublishQCircleFeed... index:", Integer.valueOf(paramInt), " localmedia:", ((MediaWrapper)this.p.get(paramInt)).toString() });
      localObject = new QQCircleFeedBase.StKuoliePasterData();
      ((QQCircleFeedBase.StKuoliePasterData)localObject).kuolie_id.set(((MediaWrapper)this.p.get(paramInt)).k);
      ((QQCircleFeedBase.StKuoliePasterData)localObject).center_x.set(((MediaWrapper)this.p.get(paramInt)).l);
      ((QQCircleFeedBase.StKuoliePasterData)localObject).center_y.set(((MediaWrapper)this.p.get(paramInt)).m);
      ((QQCircleFeedBase.StKuoliePasterData)localObject).width.set(((MediaWrapper)this.p.get(paramInt)).o);
      ((QQCircleFeedBase.StKuoliePasterData)localObject).height.set(((MediaWrapper)this.p.get(paramInt)).p);
      ((QQCircleFeedBase.StKuoliePasterData)localObject).rotation.set(((MediaWrapper)this.p.get(paramInt)).n);
      localStMaterialData = new QQCircleFeedBase.StMaterialData();
      localStMaterialData.kuolie_data.set((MessageMicro)localObject);
      localStMaterialData.material_id.set(((QQCircleFeedBase.StKuoliePasterData)localObject).kuolie_id.get());
      if (!TextUtils.isEmpty(localStMaterialData.material_id.get())) {
        localStMaterialData.interactive_type.set(2);
      }
      localArrayList.add(localStMaterialData);
      if (paramInt == 0)
      {
        localObject = new QQCircleFeedBase.StMaterialData();
        ((QQCircleFeedBase.StMaterialData)localObject).material_id.set(((MediaWrapper)this.p.get(paramInt)).q);
        ((QQCircleFeedBase.StMaterialData)localObject).material_type.set("template");
        localArrayList.add(localObject);
        localObject = new QQCircleFeedBase.StMaterialData();
        ((QQCircleFeedBase.StMaterialData)localObject).material_id.set(((MediaWrapper)this.p.get(paramInt)).r);
        ((QQCircleFeedBase.StMaterialData)localObject).material_type.set("filter");
        localArrayList.add(localObject);
        localObject = new QQCircleFeedBase.StMaterialData();
        ((QQCircleFeedBase.StMaterialData)localObject).material_id.set(((MediaWrapper)this.p.get(paramInt)).s);
        ((QQCircleFeedBase.StMaterialData)localObject).material_type.set("sticker");
        localArrayList.add(localObject);
        localObject = new QQCircleFeedBase.StMaterialData();
        ((QQCircleFeedBase.StMaterialData)localObject).material_id.set(((MediaWrapper)this.p.get(paramInt)).t);
        ((QQCircleFeedBase.StMaterialData)localObject).material_type.set("text");
        localArrayList.add(localObject);
        localObject = new QQCircleFeedBase.StMaterialData();
        ((QQCircleFeedBase.StMaterialData)localObject).material_id.set(((MediaWrapper)this.p.get(paramInt)).u);
        ((QQCircleFeedBase.StMaterialData)localObject).material_type.set("frame");
        localArrayList.add(localObject);
        localObject = new QQCircleFeedBase.StMaterialData();
        ((QQCircleFeedBase.StMaterialData)localObject).material_id.set(((MediaWrapper)this.p.get(paramInt)).v);
        ((QQCircleFeedBase.StMaterialData)localObject).material_type.set("crop");
        localArrayList.add(localObject);
      }
    }
    localStImageBusiData.material_datas.addAll(localArrayList);
    return localStImageBusiData;
  }
  
  protected String C()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("id:");
    ((StringBuilder)localObject).append(c());
    ((StringBuilder)localObject).append(", fakeKey:");
    ((StringBuilder)localObject).append(i());
    localObject = ((StringBuilder)localObject).toString();
    int i = this.t;
    if (i != 0)
    {
      if (i != 9)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(i());
        ((StringBuilder)localObject).append(", step: unknown step");
        return ((StringBuilder)localObject).toString();
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(", STEP_UPLOAD_MIX_VIDEO_PIC_TASK");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(", STEP_UPLOAD_TASK");
    return localStringBuilder.toString();
  }
  
  protected void H()
  {
    D();
    long l2 = UploadTaskBatchUtil.a(this.Z);
    long l1 = l2;
    if (l2 == 0L)
    {
      l1 = HostStaticInvokeHelper.getServerTimeMillis() / 1000L;
      UploadTaskBatchUtil.a(this.Z, l1);
    }
    QzoneMediaUploadParams localQzoneMediaUploadParams = new QzoneMediaUploadParams();
    localQzoneMediaUploadParams.a(4).b(this.z).a(this.Z).c(this.av).b(this.y).b(l1).c(this.v).a(this.u).a(this.E).b(this.D).c(this.F).a(false).a(this.aH).f(32);
    localQzoneMediaUploadParams.e(0);
    this.as = new QCircleUploadRequest(PublishUtils.a(this.b), localQzoneMediaUploadParams, this, this);
    if (this.ac != null) {
      this.ac.e = 1;
    }
  }
  
  public QCircleFakeFeed I()
  {
    Object localObject2 = this.p;
    Object localObject1 = null;
    if (localObject2 != null)
    {
      if (this.p.size() == 0) {
        return null;
      }
      localObject2 = this.p;
      int j = 0;
      Object localObject3 = (MediaWrapper)((List)localObject2).get(0);
      localObject2 = ((MediaWrapper)localObject3).d();
      localObject3 = ((MediaWrapper)localObject3).c();
      QCircleFakeFeed.Builder localBuilder = new QCircleFakeFeed.Builder();
      if (localObject3 != null)
      {
        a(localBuilder, 1);
        return localBuilder.setClientKey(this.av).setTitle(this.K).setContent(this.a).setFeedType(3).setCoverPath(((ShuoshuoVideoInfo)localObject3).h).setWidth(((ShuoshuoVideoInfo)localObject3).j).setHeight(((ShuoshuoVideoInfo)localObject3).k).setDuration(new Long(((ShuoshuoVideoInfo)localObject3).f).intValue()).setPuin(this.M).setVideoPath(((ShuoshuoVideoInfo)localObject3).b).setLabelInfos(this.aB).setPoiInfo(this.h).build();
      }
      a(localBuilder, this.p.size());
      localObject3 = new ArrayList();
      int i = 0;
      while (i < this.p.size())
      {
        MediaWrapper localMediaWrapper = (MediaWrapper)this.p.get(i);
        if ((localMediaWrapper != null) && (localMediaWrapper.d() != null)) {
          ((ArrayList)localObject3).add(localMediaWrapper.d().a);
        }
        i += 1;
      }
      localBuilder = localBuilder.setClientKey(this.av).setTitle(this.K).setContent(y()).setFeedType(2);
      if (localObject2 != null) {
        localObject1 = ((ImageInfo)localObject2).a;
      }
      localObject1 = localBuilder.setCoverPath((String)localObject1);
      if (localObject2 != null) {
        i = ((ImageInfo)localObject2).m;
      } else {
        i = 0;
      }
      localObject1 = ((QCircleFakeFeed.Builder)localObject1).setWidth(i);
      i = j;
      if (localObject2 != null) {
        i = ((ImageInfo)localObject2).n;
      }
      return ((QCircleFakeFeed.Builder)localObject1).setHeight(i).setPuin(this.M).setImgLists((ArrayList)localObject3).setLabelInfos(this.aB).setPoiInfo(this.h).build();
    }
    return null;
  }
  
  public List<MediaWrapper> a()
  {
    return this.p;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    String str = QCirclePublishQualityReporter.E_UPLOAD_RESULT;
    FeedCloudCommon.Entry localEntry1 = QCircleReportHelper.newEntry("traceid", this.aH);
    FeedCloudCommon.Entry localEntry2 = QCircleReportHelper.newEntry("ret_code", String.valueOf(paramInt2));
    FeedCloudCommon.Entry localEntry3 = QCircleReportHelper.newEntry("desc", paramString);
    if (paramBoolean) {
      paramString = QCircleConstants.y;
    } else {
      paramString = QCircleConstants.x;
    }
    QCirclePublishQualityReporter.report(str, Arrays.asList(new FeedCloudCommon.Entry[] { localEntry1, localEntry2, localEntry3, QCircleReportHelper.newEntry("ext1", paramString), QCircleReportHelper.newEntry("ext2", String.valueOf(paramInt1)) }));
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.X = paramLong1;
    this.Y = paramLong2;
    QCircleTaskQueue.a().f(this);
  }
  
  protected void a(UploadVideoInfoRsp paramUploadVideoInfoRsp, AbstractUploadTask paramAbstractUploadTask, int paramInt)
  {
    if (paramUploadVideoInfoRsp == null) {
      return;
    }
    if (this.am == null) {
      this.am = new UniAttribute();
    }
    this.am.put("response", paramUploadVideoInfoRsp);
    if (this.k != null)
    {
      this.k.x = paramUploadVideoInfoRsp.sVid;
      this.k.z = paramAbstractUploadTask.md5;
    }
    if (paramInt < this.aI.size()) {
      ((QCircleTaskReportInfo)this.aI.get(paramInt)).vid = paramUploadVideoInfoRsp.sVid;
    }
    QCirclePublishQualityReporter.report(QCirclePublishQualityReporter.E_UPLOAD_RESULT, Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("traceid", this.aH), QCircleReportHelper.newEntry("ret_code", "0"), QCircleReportHelper.newEntry("ext1", QCircleConstants.x), QCircleReportHelper.newEntry("ext2", String.valueOf(paramInt)), QCircleReportHelper.newEntry("ext3", paramUploadVideoInfoRsp.sVid) }));
  }
  
  protected void a(UploadFileResponse paramUploadFileResponse, AbstractUploadTask paramAbstractUploadTask, int paramInt)
  {
    if (paramUploadFileResponse != null)
    {
      if (paramInt < 0) {
        return;
      }
      if (this.e == null) {
        this.e = new MediaInfo();
      }
      if (this.e.picinfolist == null)
      {
        this.e.picinfolist = new ArrayList();
        int i = 0;
        while (i < this.p.size())
        {
          this.e.picinfolist.add(null);
          i += 1;
        }
      }
      if ((this.f == null) || (this.f.equals(""))) {
        this.f = paramUploadFileResponse.url;
      }
      PicInfo localPicInfo = new PicInfo();
      localPicInfo.picheight = paramUploadFileResponse.height;
      localPicInfo.picwidth = paramUploadFileResponse.width;
      localPicInfo.hdheight = paramUploadFileResponse.oheight;
      localPicInfo.hdwidth = paramUploadFileResponse.owidth;
      localPicInfo.pictype = paramUploadFileResponse.picType;
      localPicInfo.albumid = paramUploadFileResponse.albumId;
      localPicInfo.pictureid = paramUploadFileResponse.photoId;
      localPicInfo.sloc = paramUploadFileResponse.slocId;
      localPicInfo.hdid = paramUploadFileResponse.originId;
      localPicInfo.pic_url = paramUploadFileResponse.url;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onMediaPhotoUploadSuccess... pic_url:");
      localStringBuilder.append(paramUploadFileResponse.url);
      QLog.d("[upload2_QCircleUploadShuoShuoTask]", 1, localStringBuilder.toString());
      localPicInfo.picmd5 = paramUploadFileResponse.md5;
      if (((this.as instanceof QCircleUploadRequest)) && (!((QCircleUploadRequest)this.as).c.q) && (paramInt < this.aI.size()))
      {
        ((QCircleTaskReportInfo)this.aI.get(paramInt)).albumId = paramUploadFileResponse.albumId;
        ((QCircleTaskReportInfo)this.aI.get(paramInt)).lloc = paramUploadFileResponse.photoId;
        ((QCircleTaskReportInfo)this.aI.get(paramInt)).backendPicWidth = paramUploadFileResponse.width;
        ((QCircleTaskReportInfo)this.aI.get(paramInt)).backendPicHeight = paramUploadFileResponse.height;
        if (paramAbstractUploadTask != null)
        {
          ((QCircleTaskReportInfo)this.aI.get(paramInt)).hasCompress = paramAbstractUploadTask.needCompress;
          if (paramAbstractUploadTask.mTargetSize != null)
          {
            ((QCircleTaskReportInfo)this.aI.get(paramInt)).clientCompressPicWidth = paramAbstractUploadTask.mTargetSize.width;
            ((QCircleTaskReportInfo)this.aI.get(paramInt)).clientCompressPicHeight = paramAbstractUploadTask.mTargetSize.height;
            ((QCircleTaskReportInfo)this.aI.get(paramInt)).clientCompressPicSize = (paramAbstractUploadTask.getFileLength() / 1024L);
          }
        }
      }
      QCirclePublishQualityReporter.report(QCirclePublishQualityReporter.E_UPLOAD_RESULT, Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("traceid", this.aH), QCircleReportHelper.newEntry("ret_code", "0"), QCircleReportHelper.newEntry("ext1", QCircleConstants.y), QCircleReportHelper.newEntry("ext2", String.valueOf(paramInt)), QCircleReportHelper.newEntry("ext3", paramUploadFileResponse.url) }));
      if (paramInt < this.e.picinfolist.size())
      {
        this.e.picinfolist.set(paramInt, localPicInfo);
        return;
      }
      this.e.picinfolist.add(localPicInfo);
    }
  }
  
  protected void a(IQueueTask paramIQueueTask)
  {
    QCircleTaskQueue.a().f(paramIQueueTask);
  }
  
  protected void a(IQueueTask paramIQueueTask, boolean paramBoolean)
  {
    QCircleTaskQueue.a().a(paramIQueueTask, paramBoolean);
  }
  
  public void a(QCircleTask paramQCircleTask)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(C());
    localStringBuilder.append(" onTaskResponse succeed:");
    localStringBuilder.append(paramQCircleTask.G());
    localStringBuilder.append(", batchId:");
    localStringBuilder.append(this.Z);
    QLog.i("[upload2_QCircleUploadShuoShuoTask]", 1, localStringBuilder.toString());
    if (!paramQCircleTask.G())
    {
      a(this, false);
      return;
    }
    int i = this.t;
    if ((i != 0) && (i != 9))
    {
      paramQCircleTask = new StringBuilder();
      paramQCircleTask.append("onRun step:");
      paramQCircleTask.append(this.t);
      QLog.w("[upload2_QCircleUploadShuoShuoTask]", 1, paramQCircleTask.toString());
      return;
    }
    L();
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, HashMap<String, String> paramHashMap)
  {
    try
    {
      Object localObject = new FeedCloudCommon.StCommonExt();
      if (paramHashMap != null)
      {
        paramHashMap = paramHashMap.entrySet().iterator();
        while (paramHashMap.hasNext()) {
          ((FeedCloudCommon.StCommonExt)localObject).mapInfo.add(QCircleReportHelper.newEntry((Map.Entry)paramHashMap.next()));
        }
      }
      paramHashMap = new QCirclePublishFeedRequest((FeedCloudCommon.StCommonExt)localObject, paramStFeed);
      paramHashMap.overrideTraceId(this.aH);
      paramHashMap.setRetryCount(2);
      QCirclePublishQualityReporter.report(QCirclePublishQualityReporter.E_PUBLISH_FEEDS_START, Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("traceid", this.aH), QCircleReportHelper.newEntry("ret_code", "0"), QCircleReportHelper.newEntry("ext1", paramHashMap.getTraceId()), QCircleReportHelper.newEntry("ext2", String.valueOf(paramHashMap.getSsoSeq())) }));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ACTION_QCIRCLE_PULISH_FEED publishFeed id:");
      ((StringBuilder)localObject).append(paramStFeed.id.get());
      QLog.d("[upload2_QCircleUploadShuoShuoTask]", 1, ((StringBuilder)localObject).toString());
      VSNetworkHelper.getInstance().sendRequest(paramHashMap, new QCircleUploadShuoShuoTask.1(this));
      return;
    }
    catch (Exception paramStFeed)
    {
      paramHashMap = new StringBuilder();
      paramHashMap.append("ACTION_QCIRCLE_PULISH_FEED error");
      paramHashMap.append(paramStFeed);
      QLog.e("[upload2_QCircleUploadShuoShuoTask]", 1, new Object[] { Integer.valueOf(1), paramHashMap.toString() });
    }
  }
  
  /* Error */
  public void a(String paramString1, String paramString2, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: iload_3
    //   4: invokespecial 1562	com/tencent/biz/qqcircle/publish/task/QCircleBaseUploadShuoShuoTask:a	(Ljava/lang/String;Ljava/lang/String;I)V
    //   7: new 955	android/media/MediaMetadataRetriever
    //   10: dup
    //   11: invokespecial 956	android/media/MediaMetadataRetriever:<init>	()V
    //   14: astore_1
    //   15: aload_1
    //   16: aload_2
    //   17: invokevirtual 963	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   20: aload_1
    //   21: bipush 19
    //   23: invokevirtual 968	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   26: astore_2
    //   27: aload_1
    //   28: bipush 18
    //   30: invokevirtual 968	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   33: astore 4
    //   35: aload_2
    //   36: ifnull +131 -> 167
    //   39: aload 4
    //   41: ifnonnull +6 -> 47
    //   44: goto +123 -> 167
    //   47: iload_3
    //   48: aload_0
    //   49: getfield 50	com/tencent/biz/qqcircle/publish/task/QCircleUploadShuoShuoTask:aI	Ljava/util/ArrayList;
    //   52: invokevirtual 578	java/util/ArrayList:size	()I
    //   55: if_icmpge +155 -> 210
    //   58: aload_0
    //   59: getfield 50	com/tencent/biz/qqcircle/publish/task/QCircleUploadShuoShuoTask:aI	Ljava/util/ArrayList;
    //   62: iload_3
    //   63: invokevirtual 579	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   66: checkcast 833	cooperation/qqcircle/report/QCircleTaskReportInfo
    //   69: aload_2
    //   70: invokestatic 1565	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   73: putfield 1478	cooperation/qqcircle/report/QCircleTaskReportInfo:clientCompressPicHeight	I
    //   76: aload_0
    //   77: getfield 50	com/tencent/biz/qqcircle/publish/task/QCircleUploadShuoShuoTask:aI	Ljava/util/ArrayList;
    //   80: iload_3
    //   81: invokevirtual 579	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   84: checkcast 833	cooperation/qqcircle/report/QCircleTaskReportInfo
    //   87: aload 4
    //   89: invokestatic 1565	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   92: putfield 1474	cooperation/qqcircle/report/QCircleTaskReportInfo:clientCompressPicWidth	I
    //   95: new 1567	java/io/File
    //   98: dup
    //   99: aload_0
    //   100: getfield 501	com/tencent/biz/qqcircle/publish/task/QCircleUploadShuoShuoTask:k	Lcom/tencent/biz/qqcircle/publish/model/ShuoshuoVideoInfo;
    //   103: getfield 1283	com/tencent/biz/qqcircle/publish/model/ShuoshuoVideoInfo:b	Ljava/lang/String;
    //   106: invokespecial 1568	java/io/File:<init>	(Ljava/lang/String;)V
    //   109: astore_2
    //   110: aload_2
    //   111: invokevirtual 1571	java/io/File:exists	()Z
    //   114: ifeq +96 -> 210
    //   117: aload_0
    //   118: getfield 50	com/tencent/biz/qqcircle/publish/task/QCircleUploadShuoShuoTask:aI	Ljava/util/ArrayList;
    //   121: iload_3
    //   122: invokevirtual 579	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   125: checkcast 833	cooperation/qqcircle/report/QCircleTaskReportInfo
    //   128: aload_2
    //   129: invokevirtual 1574	java/io/File:length	()J
    //   132: ldc2_w 890
    //   135: ldiv
    //   136: putfield 1484	cooperation/qqcircle/report/QCircleTaskReportInfo:clientCompressPicSize	J
    //   139: aload_1
    //   140: bipush 20
    //   142: invokevirtual 968	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   145: astore_2
    //   146: aload_0
    //   147: getfield 50	com/tencent/biz/qqcircle/publish/task/QCircleUploadShuoShuoTask:aI	Ljava/util/ArrayList;
    //   150: iload_3
    //   151: invokevirtual 579	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   154: checkcast 833	cooperation/qqcircle/report/QCircleTaskReportInfo
    //   157: aload_2
    //   158: invokestatic 1578	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   161: putfield 1581	cooperation/qqcircle/report/QCircleTaskReportInfo:clientCompressMediaBitrate	J
    //   164: goto +46 -> 210
    //   167: ldc 85
    //   169: iconst_1
    //   170: iconst_2
    //   171: anewarray 87	java/lang/Object
    //   174: dup
    //   175: iconst_0
    //   176: iconst_1
    //   177: invokestatic 363	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   180: aastore
    //   181: dup
    //   182: iconst_1
    //   183: ldc_w 1583
    //   186: aastore
    //   187: invokestatic 1558	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   190: aload_1
    //   191: invokevirtual 973	android/media/MediaMetadataRetriever:release	()V
    //   194: return
    //   195: astore_2
    //   196: goto +19 -> 215
    //   199: astore_2
    //   200: ldc 85
    //   202: iconst_1
    //   203: ldc_w 1585
    //   206: aload_2
    //   207: invokestatic 153	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   210: aload_1
    //   211: invokevirtual 973	android/media/MediaMetadataRetriever:release	()V
    //   214: return
    //   215: aload_1
    //   216: invokevirtual 973	android/media/MediaMetadataRetriever:release	()V
    //   219: aload_2
    //   220: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	221	0	this	QCircleUploadShuoShuoTask
    //   0	221	1	paramString1	String
    //   0	221	2	paramString2	String
    //   0	221	3	paramInt	int
    //   33	55	4	str	String
    // Exception table:
    //   from	to	target	type
    //   15	35	195	finally
    //   47	164	195	finally
    //   167	190	195	finally
    //   200	210	195	finally
    //   15	35	199	java/lang/Exception
    //   47	164	199	java/lang/Exception
    //   167	190	199	java/lang/Exception
  }
  
  public void a(List<MediaWrapper> paramList)
  {
    QLog.d("[upload2_QCircleUploadShuoShuoTask]", 1, "onGenerateComplete...");
    this.r = 0;
    this.k = null;
    this.aC = true;
    b(paramList);
    int i = 0;
    while (i < paramList.size())
    {
      if (i < this.aI.size())
      {
        ((QCircleTaskReportInfo)this.aI.get(i)).editedPicSize = (((MediaWrapper)paramList.get(i)).c().g / 1024L);
        ((QCircleTaskReportInfo)this.aI.get(i)).editedVideoMediaBitrate = ((MediaWrapper)paramList.get(i)).j;
        QLog.d("[upload2_QCircleUploadShuoShuoTask]", 1, new Object[] { "onGenerateComplete... mSize:", Long.valueOf(((MediaWrapper)paramList.get(i)).c().g), " edited_video_mediaBitrate:", Long.valueOf(((QCircleTaskReportInfo)this.aI.get(i)).editedVideoMediaBitrate) });
      }
      i += 1;
    }
    QCircleTaskQueue.a().b(this);
  }
  
  protected boolean a(QCircleFakeFeed paramQCircleFakeFeed, int paramInt, QCircleUploadShuoShuoTask.ResultParmas paramResultParmas)
  {
    if (paramInt >= QCircleFakeAdapter.e)
    {
      QLog.e("[upload2_QCircleUploadShuoShuoTask]", 1, new Object[] { Integer.valueOf(1), "retryCount >= QCircleFakeAdapter.MAX_RETYR_COUNT" });
      return false;
    }
    paramQCircleFakeFeed = new QCircleUploadShuoShuoTask.RetryRequestFeed(this, paramQCircleFakeFeed, paramInt + 1, paramResultParmas);
    RFThreadManager.getSerialThreadHandler().postDelayed(paramQCircleFakeFeed, paramInt * 2000);
    return true;
  }
  
  public void d()
  {
    super.d();
    QLog.d("[upload2_QCircleUploadShuoShuoTask]", 1, new Object[] { "onRemove... missionId:", this.aD });
    QCircleHostAEHelper.cancelMission(this.aD);
  }
  
  public void e()
  {
    super.e();
    QLog.d("[upload2_QCircleUploadShuoShuoTask]", 1, new Object[] { "onResume... missionId:", this.aD, " isVideoReady:", Boolean.valueOf(this.aC) });
    if ((!this.aC) && (!TextUtils.isEmpty(this.aD)))
    {
      QCircleHostAEHelper.initAEEditorManagerForQzone();
      QCircleHostAEHelper.retryMission(this.aD);
    }
  }
  
  public String i()
  {
    return this.av;
  }
  
  public QCircleQueueTaskInfo m()
  {
    QCircleQueueTaskInfo localQCircleQueueTaskInfo = super.m();
    String str;
    if ((this.a != null) && (this.a.length() > 320)) {
      str = this.a.substring(0, 320);
    } else if (this.a == null) {
      str = "";
    } else {
      str = this.a;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.az);
    localStringBuilder.append(str);
    localQCircleQueueTaskInfo.a = localStringBuilder.toString();
    if ((n()) && (!this.aC) && (bn_() == 1)) {
      localQCircleQueueTaskInfo.b = this.aA;
    }
    return localQCircleQueueTaskInfo;
  }
  
  protected void u()
  {
    if (n())
    {
      this.t = 9;
      return;
    }
    if (w())
    {
      if (this.b.size() >= 1) {
        this.t = 0;
      }
      this.d = 1;
    }
  }
  
  public void x()
  {
    int i = this.t;
    if (i != 0)
    {
      if (i != 9)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onRun step:");
        localStringBuilder.append(this.t);
        QLog.w("[upload2_QCircleUploadShuoShuoTask]", 1, localStringBuilder.toString());
        return;
      }
      J();
      return;
    }
    H();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.task.QCircleUploadShuoShuoTask
 * JD-Core Version:    0.7.0.1
 */