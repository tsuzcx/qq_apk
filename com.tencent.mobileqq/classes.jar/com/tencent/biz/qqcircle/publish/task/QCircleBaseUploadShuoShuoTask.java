package com.tencent.biz.qqcircle.publish.task;

import FileUpload.UploadVideoInfoRsp;
import NS_MOBILE_OPERATION.LbsInfo;
import NS_MOBILE_OPERATION.MediaInfo;
import NS_MOBILE_OPERATION.PicInfo;
import NS_MOBILE_PHOTO.shuoshuo_privacy;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Pair;
import com.qq.jce.wup.UniAttribute;
import com.qq.taf.jce.JceStruct;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants.QzoneLbsConstant;
import com.tencent.biz.qcircleshadow.lib.QCircleHostLbsHelper;
import com.tencent.biz.qqcircle.publish.model.GifInfo;
import com.tencent.biz.qqcircle.publish.model.ImageInfo;
import com.tencent.biz.qqcircle.publish.model.MediaWrapper;
import com.tencent.biz.qqcircle.publish.model.PublishEventTag;
import com.tencent.biz.qqcircle.publish.model.QZonePreUploadInfo;
import com.tencent.biz.qqcircle.publish.model.QzoneShuoShuoParams;
import com.tencent.biz.qqcircle.publish.model.ShuoshuoVideoInfo;
import com.tencent.biz.qqcircle.publish.queue.util.NeedParcel;
import com.tencent.biz.qqcircle.publish.request.QCircleMediaUploadRequest;
import com.tencent.biz.qqcircle.publish.request.QCircleMediaUploadRequest.IMediaUploadListener;
import com.tencent.biz.qqcircle.publish.request.result.UploadFileResponse;
import com.tencent.biz.qqcircle.publish.task.compress.VideoCompressTask;
import com.tencent.biz.qqcircle.publish.task.report.TaskReportInfo.MediaReportInfo;
import com.tencent.biz.qqcircle.publish.util.BatchIDGenerator;
import com.tencent.biz.qqcircle.publish.util.PublishUtils;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.uinterface.AbstractUploadTask;
import cooperation.qzone.LbsDataV2.GpsInfo;
import cooperation.qzone.LbsDataV2.PoiInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QCircleBaseUploadShuoShuoTask
  extends QCircleQueueTask
  implements QCircleMediaUploadRequest.IMediaUploadListener
{
  @NeedParcel
  public Map<String, byte[]> A;
  @NeedParcel
  public boolean B;
  @NeedParcel
  public ArrayList<GifInfo> C;
  @NeedParcel
  public Map<String, byte[]> D;
  @NeedParcel
  public HashMap<String, String> E;
  @NeedParcel
  public Map<String, String> F;
  @NeedParcel
  protected boolean G;
  @NeedParcel
  public String H;
  @NeedParcel
  public boolean I;
  @NeedParcel
  public String J;
  @NeedParcel
  public String K;
  @NeedParcel
  public boolean L;
  @NeedParcel
  public String M;
  public boolean N = false;
  String O = QCircleConfigHelper.a("QZoneTextSetting", "BoxTaskInfoUploadDynamicPic", "上传动图：");
  String P = QCircleConfigHelper.a("QZoneTextSetting", "BoxTaskInfoPublishMood", "发表说说：");
  String Q = QCircleConfigHelper.a("QZoneTextSetting", "BoxTaskInfoPublishCertifiedAccount", "发表作品：");
  String R = QCircleConfigHelper.a("QZoneTextSetting", "BoxTaskInfoPublishVideo", "上传视频：");
  String S = QCircleConfigHelper.a("QZoneTextSetting", "BoxTaskInfoPublishing", "发表中...");
  String T = QCircleConfigHelper.a("QZoneTextSetting", "BoxTaskInfoUploadVideo", "上传视频");
  String U = QCircleConfigHelper.a("QZoneTextSetting", "BoxTaskInfoPublishSignMood", "发表签到：");
  @NeedParcel
  protected String a;
  @NeedParcel
  private shuoshuo_privacy aA;
  @NeedParcel
  private HashMap<String, Integer> aB;
  @NeedParcel
  private boolean aC;
  @NeedParcel
  private boolean aD;
  private PublishEventTag aE;
  @NeedParcel
  private String aF = null;
  @NeedParcel
  private int aG;
  @NeedParcel
  private int aH = 1;
  @NeedParcel
  private ArrayList<String> aI = null;
  @NeedParcel
  private String aJ;
  @NeedParcel
  private String aK;
  @NeedParcel
  private Map<String, String> aL;
  @NeedParcel
  private Map<String, byte[]> aM;
  @NeedParcel
  private Map<String, String> aN;
  @NeedParcel
  private HashMap<String, PicInfo> aO;
  @NeedParcel
  private int aP = 2;
  @NeedParcel
  private boolean aQ;
  private boolean aR;
  private VideoCompressTask aS;
  private ArrayList<Integer> aT = new ArrayList();
  private boolean aU = false;
  private Runnable aV = new QCircleBaseUploadShuoShuoTask.1(this);
  @NeedParcel
  private int ay = 0;
  @NeedParcel
  private HashMap<String, String> az;
  @NeedParcel
  protected List<String> b;
  @NeedParcel
  protected List<String> c;
  @NeedParcel
  protected int d;
  @NeedParcel
  public MediaInfo e = new MediaInfo();
  @NeedParcel
  public String f;
  protected LbsInfo g;
  @NeedParcel
  protected LbsDataV2.PoiInfo h;
  @NeedParcel
  public long i;
  @NeedParcel
  public long j;
  @NeedParcel
  protected ShuoshuoVideoInfo k;
  @NeedParcel
  protected List<ShuoshuoVideoInfo> l = new ArrayList();
  @NeedParcel
  protected List<ShuoshuoVideoInfo> m = new ArrayList();
  @NeedParcel
  protected List<ShuoshuoVideoInfo> n = new ArrayList();
  @NeedParcel
  protected Map<Integer, String> o = new HashMap();
  @NeedParcel
  protected List<MediaWrapper> p = new ArrayList();
  @NeedParcel
  public boolean q = false;
  @NeedParcel
  protected int r = 0;
  @NeedParcel
  public Map<String, String> s;
  @NeedParcel
  public volatile int t = 0;
  protected QZonePreUploadInfo u;
  @NeedParcel
  protected int v = 0;
  @NeedParcel
  protected ArrayList<Pair<Integer, PicInfo>> w;
  @NeedParcel
  public LbsInfo x;
  @NeedParcel
  public int y;
  @NeedParcel
  public String z;
  
  public QCircleBaseUploadShuoShuoTask() {}
  
  public QCircleBaseUploadShuoShuoTask(int paramInt1, int paramInt2, QzoneShuoShuoParams paramQzoneShuoShuoParams)
  {
    super(paramInt1);
    if (paramInt2 != 0)
    {
      if (paramInt2 != 1) {
        return;
      }
      b(paramQzoneShuoShuoParams);
      return;
    }
    a(paramQzoneShuoShuoParams);
  }
  
  private void H()
  {
    if (this.b == null) {
      return;
    }
    if (this.aB == null) {
      this.aB = new HashMap();
    }
    int i1 = 0;
    while (i1 < this.b.size())
    {
      this.aB.put(this.b.get(i1), Integer.valueOf(a((int)this.Z, (String)this.b.get(i1))));
      i1 += 1;
    }
  }
  
  private int I()
  {
    return this.aT.size();
  }
  
  private void a(QzoneShuoShuoParams paramQzoneShuoShuoParams)
  {
    this.a = paramQzoneShuoShuoParams.b;
    this.az = paramQzoneShuoShuoParams.e;
    this.aA = paramQzoneShuoShuoParams.f;
    this.k = paramQzoneShuoShuoParams.g;
    this.aD = paramQzoneShuoShuoParams.l;
    this.aC = paramQzoneShuoShuoParams.k;
    this.I = paramQzoneShuoShuoParams.Q;
    this.Z = BatchIDGenerator.a();
    this.v = paramQzoneShuoShuoParams.r;
    this.i = paramQzoneShuoShuoParams.s;
    this.j = paramQzoneShuoShuoParams.t;
    this.aH = paramQzoneShuoShuoParams.u;
    this.aI = paramQzoneShuoShuoParams.v;
    this.aJ = paramQzoneShuoShuoParams.w;
    this.aK = paramQzoneShuoShuoParams.y;
    this.h = paramQzoneShuoShuoParams.i;
    this.aG = paramQzoneShuoShuoParams.n;
    this.u = paramQzoneShuoShuoParams.o;
    this.aL = paramQzoneShuoShuoParams.p;
    this.aM = paramQzoneShuoShuoParams.a();
    this.aO = paramQzoneShuoShuoParams.h;
    this.A = paramQzoneShuoShuoParams.C;
    this.aF = null;
    this.C = paramQzoneShuoShuoParams.A;
    this.aE = paramQzoneShuoShuoParams.B;
    this.D = paramQzoneShuoShuoParams.E;
    this.E = paramQzoneShuoShuoParams.J;
    this.F = paramQzoneShuoShuoParams.F;
    this.aP = paramQzoneShuoShuoParams.G;
    this.aQ = paramQzoneShuoShuoParams.I;
    this.G = paramQzoneShuoShuoParams.M;
    this.L = paramQzoneShuoShuoParams.S;
    this.M = paramQzoneShuoShuoParams.T;
    this.K = paramQzoneShuoShuoParams.a;
    a(paramQzoneShuoShuoParams.c);
    H();
    a(paramQzoneShuoShuoParams.i, paramQzoneShuoShuoParams.x);
    a(this.aC);
    if (this.aN == null) {
      this.aN = new HashMap();
    }
    if (paramQzoneShuoShuoParams.D != null) {
      this.aN.putAll(paramQzoneShuoShuoParams.D);
    }
    if (paramQzoneShuoShuoParams.V != null) {
      this.aN.putAll(paramQzoneShuoShuoParams.V);
    }
    if (paramQzoneShuoShuoParams.L != null)
    {
      if (this.e.picinfolist == null) {
        this.e.picinfolist = new ArrayList();
      }
      this.e.picinfolist.add(paramQzoneShuoShuoParams.L);
    }
    u();
    paramQzoneShuoShuoParams = new StringBuilder();
    paramQzoneShuoShuoParams.append("initNormal, ");
    paramQzoneShuoShuoParams.append(C());
    QLog.i("[upload2_QZoneUploadShuoShuoTask]", 1, paramQzoneShuoShuoParams.toString());
  }
  
  private void a(LbsDataV2.PoiInfo paramPoiInfo, LbsDataV2.GpsInfo paramGpsInfo)
  {
    double d1;
    if (paramPoiInfo != null)
    {
      this.g = new LbsInfo();
      if (paramPoiInfo.gpsInfo != null)
      {
        LbsInfo localLbsInfo = this.g;
        d1 = paramPoiInfo.gpsInfo.lon;
        Double.isNaN(d1);
        localLbsInfo.lbs_x = String.valueOf(d1 / 1000000.0D);
        localLbsInfo = this.g;
        d1 = paramPoiInfo.gpsInfo.lat;
        Double.isNaN(d1);
        localLbsInfo.lbs_y = String.valueOf(d1 / 1000000.0D);
      }
      if (!TextUtils.isEmpty(paramPoiInfo.poiDefaultName))
      {
        this.g.lbs_idnm = paramPoiInfo.poiDefaultName;
        this.g.lbs_nm = paramPoiInfo.poiDefaultName;
      }
      else if (!TextUtils.isEmpty(paramPoiInfo.poiName))
      {
        this.g.lbs_idnm = paramPoiInfo.poiName;
        this.g.lbs_nm = paramPoiInfo.poiName;
      }
      else
      {
        this.g.lbs_idnm = paramPoiInfo.address;
        this.g.lbs_nm = paramPoiInfo.address;
      }
      this.g.i_poi_order_type = paramPoiInfo.poiOrderType;
      this.g.i_poi_num = paramPoiInfo.poiNum;
      this.g.i_poi_type = paramPoiInfo.poiType;
    }
    try
    {
      this.g.lbs_id = Integer.parseInt(paramPoiInfo.poiId);
    }
    catch (Exception paramPoiInfo)
    {
      label230:
      break label230;
    }
    if (paramGpsInfo != null)
    {
      this.x = new LbsInfo();
      paramPoiInfo = this.x;
      d1 = paramGpsInfo.lon;
      Double.isNaN(d1);
      paramPoiInfo.lbs_x = String.valueOf(d1 / 1000000.0D);
      paramPoiInfo = this.x;
      d1 = paramGpsInfo.lat;
      Double.isNaN(d1);
      paramPoiInfo.lbs_y = String.valueOf(d1 / 1000000.0D);
      return;
    }
    paramPoiInfo = QCircleHostLbsHelper.getCurrGps(QCircleHostConstants.QzoneLbsConstant.BUSINESS_ID_QZONE_SAY());
    if ((paramPoiInfo != null) && (paramPoiInfo.isValid()))
    {
      this.x = new LbsInfo();
      paramGpsInfo = this.x;
      d1 = paramPoiInfo.lon;
      Double.isNaN(d1);
      paramGpsInfo.lbs_x = String.valueOf(d1 / 1000000.0D);
      paramGpsInfo = this.x;
      d1 = paramPoiInfo.lat;
      Double.isNaN(d1);
      paramGpsInfo.lbs_y = String.valueOf(d1 / 1000000.0D);
    }
  }
  
  private void a(List<String> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.b = new ArrayList();
    this.w = new ArrayList();
    this.p = new ArrayList();
    int i2 = paramList.size();
    int i1 = 0;
    while (i1 < i2)
    {
      Object localObject = (String)paramList.get(i1);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if ((!((String)localObject).startsWith("http://")) && (!((String)localObject).startsWith("https://")))
        {
          this.b.add(paramList.get(i1));
        }
        else
        {
          HashMap localHashMap = this.aO;
          if (localHashMap != null) {
            localObject = (PicInfo)localHashMap.get(localObject);
          } else {
            localObject = null;
          }
          this.w.add(new Pair(Integer.valueOf(i1), localObject));
        }
        localObject = new MediaWrapper(ImageInfo.a((String)paramList.get(i1)));
        this.p.add(localObject);
      }
      i1 += 1;
    }
    this.r = this.p.size();
  }
  
  private void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    if (n())
    {
      ShuoshuoVideoInfo localShuoshuoVideoInfo = this.k;
      localShuoshuoVideoInfo.e |= 0x1;
    }
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = TextUtils.isEmpty(paramString2);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if (TextUtils.isEmpty(paramString1)) {
      return true;
    }
    paramString1 = new File(paramString1);
    if ((!paramString1.exists()) || (paramString1.isDirectory())) {
      bool1 = true;
    }
    return bool1;
  }
  
  private void b(QzoneShuoShuoParams paramQzoneShuoShuoParams)
  {
    this.a = paramQzoneShuoShuoParams.b;
    this.az = paramQzoneShuoShuoParams.e;
    this.aA = paramQzoneShuoShuoParams.f;
    this.aD = paramQzoneShuoShuoParams.l;
    this.aC = paramQzoneShuoShuoParams.k;
    this.H = paramQzoneShuoShuoParams.O;
    this.J = paramQzoneShuoShuoParams.P;
    this.I = paramQzoneShuoShuoParams.Q;
    this.Z = BatchIDGenerator.a();
    this.v = paramQzoneShuoShuoParams.r;
    this.i = paramQzoneShuoShuoParams.s;
    this.j = paramQzoneShuoShuoParams.t;
    this.aH = paramQzoneShuoShuoParams.u;
    this.aI = paramQzoneShuoShuoParams.v;
    this.aJ = paramQzoneShuoShuoParams.w;
    this.aK = paramQzoneShuoShuoParams.y;
    this.h = paramQzoneShuoShuoParams.i;
    this.aG = paramQzoneShuoShuoParams.n;
    this.u = paramQzoneShuoShuoParams.o;
    this.aL = paramQzoneShuoShuoParams.p;
    this.aM = paramQzoneShuoShuoParams.a();
    this.aO = paramQzoneShuoShuoParams.h;
    this.A = paramQzoneShuoShuoParams.C;
    this.C = paramQzoneShuoShuoParams.A;
    this.aE = paramQzoneShuoShuoParams.B;
    this.D = paramQzoneShuoShuoParams.E;
    this.E = paramQzoneShuoShuoParams.J;
    this.F = paramQzoneShuoShuoParams.F;
    this.aP = paramQzoneShuoShuoParams.G;
    this.aQ = paramQzoneShuoShuoParams.I;
    this.G = paramQzoneShuoShuoParams.M;
    this.L = paramQzoneShuoShuoParams.S;
    this.M = paramQzoneShuoShuoParams.T;
    this.K = paramQzoneShuoShuoParams.a;
    this.aU = paramQzoneShuoShuoParams.U;
    b(paramQzoneShuoShuoParams.K);
    H();
    a(paramQzoneShuoShuoParams.i, paramQzoneShuoShuoParams.x);
    a(this.aC);
    this.q = v();
    if (this.aN == null) {
      this.aN = new HashMap();
    }
    if (paramQzoneShuoShuoParams.D != null) {
      this.aN.putAll(paramQzoneShuoShuoParams.D);
    }
    if (paramQzoneShuoShuoParams.V != null) {
      this.aN.putAll(paramQzoneShuoShuoParams.V);
    }
    u();
    paramQzoneShuoShuoParams = new StringBuilder();
    paramQzoneShuoShuoParams.append("initMixUpload, ");
    paramQzoneShuoShuoParams.append(C());
    QLog.i("[upload2_QZoneUploadShuoShuoTask]", 1, paramQzoneShuoShuoParams.toString());
  }
  
  private void b(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      if (this.s == null) {
        this.s = new HashMap();
      }
      this.s.put(paramString1, paramString2);
    }
  }
  
  public List<String> A()
  {
    return this.b;
  }
  
  public String B()
  {
    if (!n()) {
      return null;
    }
    return this.k.h;
  }
  
  protected String C()
  {
    return "";
  }
  
  protected void D()
  {
    if ((this.as != null) && ((this.as instanceof QCircleMediaUploadRequest)))
    {
      ((QCircleMediaUploadRequest)this.as).a();
      this.Z = BatchIDGenerator.a();
      if (I() > 0) {
        this.aT.clear();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(C());
      localStringBuilder.append(", checkRequestReentrant, cancel old request, reGenerateBatchId:");
      localStringBuilder.append(this.Z);
      QLog.w("[upload2_QZoneUploadShuoShuoTask]", 1, localStringBuilder.toString());
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onMediaUploadFailed mediaIndex:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", errCode:");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", errMsg:");
    localStringBuilder.append(paramString);
    QLog.w("[upload2_QZoneUploadShuoShuoTask]", 1, localStringBuilder.toString());
    a(this);
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (paramInt < 0) {
      return;
    }
    c(paramInt);
  }
  
  public void a(long paramLong1, long paramLong2) {}
  
  protected void a(UploadVideoInfoRsp paramUploadVideoInfoRsp, AbstractUploadTask paramAbstractUploadTask, int paramInt)
  {
    if (paramUploadVideoInfoRsp == null) {
      return;
    }
    if (this.am == null) {
      this.am = new UniAttribute();
    }
    this.am.put("response", paramUploadVideoInfoRsp);
    if (this.L)
    {
      paramAbstractUploadTask = this.k;
      if (paramAbstractUploadTask != null) {
        paramAbstractUploadTask.x = paramUploadVideoInfoRsp.sVid;
      }
    }
  }
  
  public void a(JceStruct paramJceStruct, AbstractUploadTask paramAbstractUploadTask, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if (paramJceStruct != null)
    {
      if (paramInt < 0) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onMediaUploadSuccess mediaIndex:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", id:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", srcPath:");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", uploadPath:");
      localStringBuilder.append(paramString3);
      QLog.i("[upload2_QZoneUploadShuoShuoTask]", 1, localStringBuilder.toString());
      if (!this.aT.contains(Integer.valueOf(paramInt))) {
        this.aT.add(Integer.valueOf(paramInt));
      }
      if ((paramJceStruct instanceof UploadVideoInfoRsp))
      {
        QLog.i("[upload2_QZoneUploadShuoShuoTask]", 1, "response is UploadVideoInfoRsp");
        a((UploadVideoInfoRsp)paramJceStruct, paramAbstractUploadTask, paramInt);
        paramJceStruct = paramString2;
        if (a(paramString2, paramString3)) {
          paramJceStruct = paramString3;
        }
        if ((!TextUtils.isEmpty(paramJceStruct)) && (new File(paramJceStruct).exists()))
        {
          b(paramString1, paramJceStruct);
          paramAbstractUploadTask = new StringBuilder();
          paramAbstractUploadTask.append("addUploadVideoToUrlMap, id:");
          paramAbstractUploadTask.append(paramString1);
          paramAbstractUploadTask.append(", path:");
          paramAbstractUploadTask.append(paramJceStruct);
          QLog.i("[upload2_QZoneUploadShuoShuoTask]", 1, paramAbstractUploadTask.toString());
        }
      }
      else if ((paramJceStruct instanceof UploadFileResponse))
      {
        QLog.i("[upload2_QZoneUploadShuoShuoTask]", 1, "response is UploadFileResponse");
        a((UploadFileResponse)paramJceStruct, paramAbstractUploadTask, paramInt);
      }
    }
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
        int i1 = 0;
        while (i1 < this.p.size())
        {
          this.e.picinfolist.add(null);
          i1 += 1;
        }
      }
      paramAbstractUploadTask = this.f;
      if ((paramAbstractUploadTask == null) || (paramAbstractUploadTask.equals(""))) {
        this.f = paramUploadFileResponse.url;
      }
      paramAbstractUploadTask = new PicInfo();
      paramAbstractUploadTask.picheight = paramUploadFileResponse.height;
      paramAbstractUploadTask.picwidth = paramUploadFileResponse.width;
      paramAbstractUploadTask.hdheight = paramUploadFileResponse.oheight;
      paramAbstractUploadTask.hdwidth = paramUploadFileResponse.owidth;
      paramAbstractUploadTask.pictype = paramUploadFileResponse.picType;
      paramAbstractUploadTask.albumid = paramUploadFileResponse.albumId;
      paramAbstractUploadTask.pictureid = paramUploadFileResponse.photoId;
      paramAbstractUploadTask.sloc = paramUploadFileResponse.slocId;
      paramAbstractUploadTask.hdid = paramUploadFileResponse.originId;
      if (this.L) {
        paramAbstractUploadTask.pic_url = paramUploadFileResponse.url;
      }
      if (paramInt < this.e.picinfolist.size())
      {
        this.e.picinfolist.set(paramInt, paramAbstractUploadTask);
        return;
      }
      this.e.picinfolist.add(paramAbstractUploadTask);
    }
  }
  
  protected void a(IQueueTask paramIQueueTask) {}
  
  protected void a(IQueueTask paramIQueueTask, boolean paramBoolean) {}
  
  public void a(QCircleTask paramQCircleTask) {}
  
  public void a(TaskReportInfo.MediaReportInfo paramMediaReportInfo)
  {
    b(paramMediaReportInfo);
  }
  
  public void a(String paramString, int paramInt, double paramDouble)
  {
    a(this);
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    a(this);
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if ((this.t == 2) && (this.B))
    {
      if (this.b == null) {
        this.b = new ArrayList();
      }
      this.b.add(paramString2);
      this.t = 6;
    }
    a(this);
  }
  
  protected void b(List<MediaWrapper> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      this.p = paramList;
      this.b = new ArrayList();
      this.c = new ArrayList();
      this.w = new ArrayList();
      this.l = new ArrayList();
      int i1 = 0;
      while (i1 < paramList.size())
      {
        Object localObject = (MediaWrapper)paramList.get(i1);
        if (((MediaWrapper)localObject).b())
        {
          this.r += 1;
          String str = ((MediaWrapper)localObject).d().a;
          if ((!str.startsWith("http://")) && (!str.startsWith("https://")))
          {
            this.b.add(str);
          }
          else
          {
            localObject = this.aO;
            if (localObject != null) {
              localObject = (PicInfo)((HashMap)localObject).get(str);
            } else {
              localObject = null;
            }
            if (localObject == null) {
              break label378;
            }
            this.w.add(new Pair(Integer.valueOf(i1), localObject));
          }
          this.c.add(str);
        }
        else if (((MediaWrapper)localObject).a())
        {
          this.r += 1;
          this.b.add(((MediaWrapper)localObject).c().b);
          this.c.add(((MediaWrapper)localObject).c().b);
          this.l.add(((MediaWrapper)localObject).c());
          this.o.put(Integer.valueOf(i1), new String(((MediaWrapper)localObject).c().b));
          if ((((MediaWrapper)localObject).c() != null) && (((MediaWrapper)localObject).c().n)) {
            this.m.add(((MediaWrapper)localObject).c());
          } else if (((MediaWrapper)localObject).c() != null) {
            this.n.add(((MediaWrapper)localObject).c());
          }
          if (this.k == null) {
            this.k = ((MediaWrapper)localObject).c();
          }
        }
        label378:
        i1 += 1;
      }
    }
  }
  
  public void c(int paramInt)
  {
    this.ay = paramInt;
  }
  
  public void d()
  {
    super.d();
    VideoCompressTask localVideoCompressTask = this.aS;
    if (localVideoCompressTask != null) {
      localVideoCompressTask.w();
    }
    g();
  }
  
  public void e()
  {
    super.e();
    if (this.N)
    {
      this.Z = BatchIDGenerator.a();
      this.N = false;
    }
  }
  
  public void f()
  {
    super.f();
    this.N = true;
  }
  
  public boolean g()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(C());
    localStringBuilder.append("cancel task");
    QLog.i("[upload2_QZoneUploadShuoShuoTask]", 1, localStringBuilder.toString());
    if ((this.as != null) && ((this.as instanceof QCircleMediaUploadRequest))) {
      return ((QCircleMediaUploadRequest)this.as).a();
    }
    RFThreadManager.getSerialThreadHandler().removeCallbacks(this.aV);
    return true;
  }
  
  public void h()
  {
    super.h();
    if ((this.as != null) && ((this.as instanceof QCircleMediaUploadRequest))) {
      ((QCircleMediaUploadRequest)this.as).b();
    }
  }
  
  public String i()
  {
    return this.av;
  }
  
  public int k()
  {
    return 1;
  }
  
  public QCircleQueueTaskInfo m()
  {
    QCircleQueueTaskInfo localQCircleQueueTaskInfo = super.m();
    Object localObject1 = this.a;
    if ((localObject1 != null) && (((String)localObject1).length() > 320)) {
      localObject1 = this.a.substring(0, 320);
    } else {
      localObject1 = this.a;
    }
    Object localObject2 = localObject1;
    if (this.aD)
    {
      localObject2 = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = localObject1;
        if (((String)localObject1).startsWith("qm")) {
          localObject2 = ((String)localObject1).substring(2);
        }
      }
    }
    if (this.L)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.Q);
      ((StringBuilder)localObject1).append(this.K);
      localQCircleQueueTaskInfo.a = ((StringBuilder)localObject1).toString();
    }
    else if (this.B)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.O);
      ((StringBuilder)localObject1).append((String)localObject2);
      localQCircleQueueTaskInfo.a = ((StringBuilder)localObject1).toString();
    }
    else if (this.aU)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.U);
      ((StringBuilder)localObject1).append((String)localObject2);
      localQCircleQueueTaskInfo.a = ((StringBuilder)localObject1).toString();
    }
    else if (this.q)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.P);
      ((StringBuilder)localObject1).append((String)localObject2);
      localQCircleQueueTaskInfo.a = ((StringBuilder)localObject1).toString();
    }
    else if (n())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.R);
      ((StringBuilder)localObject1).append((String)localObject2);
      localQCircleQueueTaskInfo.a = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.P);
      ((StringBuilder)localObject1).append((String)localObject2);
      localQCircleQueueTaskInfo.a = ((StringBuilder)localObject1).toString();
    }
    if (bn_() == 1)
    {
      if ((this.X > 0L) && (this.Y > 0L))
      {
        localQCircleQueueTaskInfo.f = Math.max((int)(this.X * 100L / this.Y), 1);
        if ((this.ay >= 0) && (z() > 0))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(this.X);
          ((StringBuilder)localObject1).append("k/");
          ((StringBuilder)localObject1).append(this.Y);
          ((StringBuilder)localObject1).append("k");
          localQCircleQueueTaskInfo.b = ((StringBuilder)localObject1).toString();
        }
        else if (n())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(this.T);
          ((StringBuilder)localObject1).append(this.X);
          ((StringBuilder)localObject1).append("/");
          ((StringBuilder)localObject1).append(this.Y);
          ((StringBuilder)localObject1).append("k");
          localQCircleQueueTaskInfo.b = ((StringBuilder)localObject1).toString();
        }
      }
      if ((!this.q) && (!n()))
      {
        if (z() != 0)
        {
          localObject1 = localQCircleQueueTaskInfo;
          if (this.ay != z()) {}
        }
        else
        {
          localQCircleQueueTaskInfo.b = this.S;
          localObject1 = localQCircleQueueTaskInfo;
        }
      }
      else
      {
        localObject1 = localQCircleQueueTaskInfo;
        if ((this.as instanceof QCircleMediaUploadRequest)) {
          localObject1 = ((QCircleMediaUploadRequest)this.as).a(localQCircleQueueTaskInfo);
        }
      }
    }
    else
    {
      localObject1 = localQCircleQueueTaskInfo;
      if (bn_() == 3)
      {
        localObject1 = localQCircleQueueTaskInfo;
        if (z() != 0)
        {
          localQCircleQueueTaskInfo.h = ((String)A().get(z() - 1));
          localObject1 = localQCircleQueueTaskInfo;
        }
      }
    }
    int i3 = z();
    int i2 = I();
    if ((i2 >= 0) && (i3 > i2))
    {
      ((QCircleQueueTaskInfo)localObject1).j = (i3 - i2);
      if (TextUtils.isEmpty(((QCircleQueueTaskInfo)localObject1).h))
      {
        int i1 = i2;
        if (i2 == i3) {
          i1 = i2 - 1;
        }
        if ((i1 >= 0) && (i1 < i3)) {
          ((QCircleQueueTaskInfo)localObject1).h = ((String)A().get(i1));
        }
        if (!TextUtils.isEmpty(((QCircleQueueTaskInfo)localObject1).h))
        {
          if (PublishUtils.b(((QCircleQueueTaskInfo)localObject1).h) == 1) {
            ((QCircleQueueTaskInfo)localObject1).i = true;
          }
          localObject2 = new File(((QCircleQueueTaskInfo)localObject1).h);
          if ((((File)localObject2).exists()) && (((File)localObject2).isDirectory()) && (n()))
          {
            ((QCircleQueueTaskInfo)localObject1).h = B();
            return localObject1;
          }
        }
      }
    }
    else if (n())
    {
      ((QCircleQueueTaskInfo)localObject1).h = B();
      if (!this.B) {
        ((QCircleQueueTaskInfo)localObject1).i = true;
      }
      ((QCircleQueueTaskInfo)localObject1).j = 1;
    }
    return localObject1;
  }
  
  public boolean n()
  {
    return this.k != null;
  }
  
  protected void u() {}
  
  public boolean v()
  {
    List localList = this.l;
    return (localList != null) && (localList.size() >= 1);
  }
  
  public boolean w()
  {
    List localList = this.b;
    return (localList != null) && (localList.size() > 0);
  }
  
  public void x()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(C());
    localStringBuilder.append(", onRun batchId:");
    localStringBuilder.append(this.Z);
    QLog.i("[upload2_QZoneUploadShuoShuoTask]", 1, localStringBuilder.toString());
  }
  
  public String y()
  {
    return this.a;
  }
  
  public int z()
  {
    List localList = this.b;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.task.QCircleBaseUploadShuoShuoTask
 * JD-Core Version:    0.7.0.1
 */