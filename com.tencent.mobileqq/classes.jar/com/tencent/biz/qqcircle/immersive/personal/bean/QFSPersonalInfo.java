package com.tencent.biz.qqcircle.immersive.personal.bean;

import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.immersive.utils.QFSJsUrlUtils;
import com.tencent.biz.qqcircle.immersive.utils.QFSThreadUtils;
import com.tencent.biz.qqcircle.utils.QCircleTextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StExternalMedalWallInfo;
import feedcloud.FeedCloudMeta.StFollowRecomInfo;
import feedcloud.FeedCloudMeta.StShare;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudRead.StGetMainPageRsp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleBase.CircleAchievement;
import qqcircle.QQCircleBase.CircleRankingData;
import qqcircle.QQCircleBase.StUserBusiData;
import qqcircle.QQCircleBase.UserCircleInfo;
import qqcircle.QQCircleFeedBase.StMainPageBusiRspData;
import qqcircle.QQCircleProfile.StProfileBizData;

public class QFSPersonalInfo
{
  public int A;
  public int B;
  public int C;
  public String D;
  public FeedCloudMeta.StFollowRecomInfo E;
  public FeedCloudMeta.StExternalMedalWallInfo F;
  public FeedCloudMeta.StShare G;
  public String H;
  public String I;
  public String J;
  public String K;
  public int L = 0;
  public List<Integer> M;
  public String N;
  public QQCircleProfile.StProfileBizData O;
  public boolean P;
  public boolean Q = true;
  private boolean R = false;
  private List<QFSPersonalInfo.OnParseFinishListener> S;
  public final FeedCloudMeta.StUser a = new FeedCloudMeta.StUser();
  public QQCircleBase.StUserBusiData b;
  public String c = "";
  public String d = "";
  public String e;
  public String f = "";
  public String g = "";
  public int h = 0;
  public String i;
  public long j = 0L;
  public String k;
  public int l = 0;
  public int m = 0;
  public QQCircleBase.CircleAchievement n;
  public List<QQCircleBase.CircleRankingData> o;
  public List<QQCircleBase.UserCircleInfo> p;
  public List<QQCircleBase.UserCircleInfo> q;
  public String r;
  public int s = 0;
  public String t;
  public boolean u = false;
  public boolean v = false;
  public boolean w = false;
  public boolean x = false;
  public boolean y = false;
  public QQCircleFeedBase.StMainPageBusiRspData z;
  
  private QFSPersonalInfo(FeedCloudMeta.StUser paramStUser)
  {
    c(paramStUser);
    if (!QFSThreadUtils.b())
    {
      b(paramStUser.busiData.get().toByteArray());
      return;
    }
    QFSThreadUtils.a(new QFSPersonalInfo.2(this, paramStUser));
  }
  
  private QFSPersonalInfo(FeedCloudRead.StGetMainPageRsp paramStGetMainPageRsp)
  {
    b(paramStGetMainPageRsp);
    c(paramStGetMainPageRsp.user);
    if (!QFSThreadUtils.b())
    {
      a(paramStGetMainPageRsp.busiRspData.get().toByteArray());
      b(paramStGetMainPageRsp.user.busiData.get().toByteArray());
      return;
    }
    QFSThreadUtils.a(new QFSPersonalInfo.1(this, paramStGetMainPageRsp));
  }
  
  public static QFSPersonalInfo a(FeedCloudRead.StGetMainPageRsp paramStGetMainPageRsp)
  {
    return new QFSPersonalInfo(paramStGetMainPageRsp);
  }
  
  private void a(QQCircleBase.StUserBusiData paramStUserBusiData)
  {
    this.p = paramStUserBusiData.schoolInfos.get();
    List localList = this.p;
    if ((localList != null) && (!localList.isEmpty())) {
      this.r = ((QQCircleBase.UserCircleInfo)this.p.get(0)).circleJumpUrl.get();
    }
    this.q = paramStUserBusiData.companyInfos.get();
  }
  
  private void a(QQCircleFeedBase.StMainPageBusiRspData paramStMainPageBusiRspData)
  {
    paramStMainPageBusiRspData = paramStMainPageBusiRspData.urlInfo.get();
    this.H = QFSJsUrlUtils.a(paramStMainPageBusiRspData, "followListUrl");
    this.I = QFSJsUrlUtils.a(paramStMainPageBusiRspData, "fansListUrl");
    this.J = QFSJsUrlUtils.a(paramStMainPageBusiRspData, "TaskCenterUrl");
    this.K = QFSJsUrlUtils.a(paramStMainPageBusiRspData, "personalInviteUrl");
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    QQCircleFeedBase.StMainPageBusiRspData localStMainPageBusiRspData = new QQCircleFeedBase.StMainPageBusiRspData();
    for (;;)
    {
      try
      {
        localStMainPageBusiRspData.mergeFrom(paramArrayOfByte);
        this.z = localStMainPageBusiRspData;
        a(localStMainPageBusiRspData);
        b(localStMainPageBusiRspData);
        this.L = localStMainPageBusiRspData.giftCnt.get();
        if (!localStMainPageBusiRspData.giftJumpUrl.has()) {
          break label128;
        }
        paramArrayOfByte = localStMainPageBusiRspData.giftJumpUrl.get();
        this.N = paramArrayOfByte;
        if (this.z.profileBusiData.has())
        {
          this.O = new QQCircleProfile.StProfileBizData();
          this.O.mergeFrom(this.z.profileBusiData.get().toByteArray());
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        QLog.e("FSPersonalInfo", 1, "mergeFrom StMainPageBusiRspData error");
        paramArrayOfByte.printStackTrace();
      }
      return;
      label128:
      paramArrayOfByte = null;
    }
  }
  
  public static QFSPersonalInfo b(FeedCloudMeta.StUser paramStUser)
  {
    return new QFSPersonalInfo(paramStUser);
  }
  
  private void b(FeedCloudRead.StGetMainPageRsp paramStGetMainPageRsp)
  {
    this.l = paramStGetMainPageRsp.feedCount.get();
    this.m = paramStGetMainPageRsp.pushRocketCount.get();
    this.A = paramStGetMainPageRsp.fansCount.get();
    this.B = paramStGetMainPageRsp.followCount.get();
    this.C = paramStGetMainPageRsp.likedFeedCount.get();
    boolean bool = paramStGetMainPageRsp.pmBeginShow.has();
    Object localObject2 = null;
    if (bool) {
      localObject1 = paramStGetMainPageRsp.pmBeginShow.get();
    } else {
      localObject1 = null;
    }
    this.D = ((String)localObject1);
    if (paramStGetMainPageRsp.followRecomInfo.has()) {
      localObject1 = (FeedCloudMeta.StFollowRecomInfo)paramStGetMainPageRsp.followRecomInfo.get();
    } else {
      localObject1 = null;
    }
    this.E = ((FeedCloudMeta.StFollowRecomInfo)localObject1);
    if (paramStGetMainPageRsp.medalWall.has()) {
      localObject1 = (FeedCloudMeta.StExternalMedalWallInfo)paramStGetMainPageRsp.medalWall.get();
    } else {
      localObject1 = null;
    }
    this.F = ((FeedCloudMeta.StExternalMedalWallInfo)localObject1);
    Object localObject1 = localObject2;
    if (paramStGetMainPageRsp.share.has()) {
      localObject1 = (FeedCloudMeta.StShare)paramStGetMainPageRsp.share.get();
    }
    this.G = ((FeedCloudMeta.StShare)localObject1);
    int i1 = paramStGetMainPageRsp.isPenguinUser.get();
    bool = true;
    if (i1 != 1) {
      bool = false;
    }
    this.R = bool;
  }
  
  private void b(QQCircleBase.StUserBusiData paramStUserBusiData)
  {
    boolean bool;
    if (paramStUserBusiData.certification.get() > 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.x = bool;
    if (this.x)
    {
      this.s = paramStUserBusiData.certification.get();
      if (this.s == 2) {
        paramStUserBusiData = paramStUserBusiData.blueCertifiDesc;
      } else {
        paramStUserBusiData = paramStUserBusiData.certificationDesc;
      }
      this.t = paramStUserBusiData.get();
      this.t = this.t.trim();
    }
  }
  
  private void b(QQCircleFeedBase.StMainPageBusiRspData paramStMainPageBusiRspData)
  {
    if (paramStMainPageBusiRspData.opMask.has()) {
      paramStMainPageBusiRspData = paramStMainPageBusiRspData.opMask.get();
    } else {
      paramStMainPageBusiRspData = null;
    }
    this.M = paramStMainPageBusiRspData;
    paramStMainPageBusiRspData = this.M;
    if (paramStMainPageBusiRspData == null)
    {
      this.P = false;
      return;
    }
    this.P = paramStMainPageBusiRspData.contains(Integer.valueOf(1));
    this.Q = this.M.contains(Integer.valueOf(6));
  }
  
  private void b(byte[] paramArrayOfByte)
  {
    this.b = new QQCircleBase.StUserBusiData();
    try
    {
      this.b.mergeFrom(paramArrayOfByte);
      b(this.b);
      a(this.b);
      this.j = this.b.fuelValue.get();
      this.k = this.b.fuelValueJumpUrl.get();
      this.i = this.b.completionDesc.get();
      boolean bool = this.b.achievement.has();
      Object localObject = null;
      if (bool) {
        paramArrayOfByte = (QQCircleBase.CircleAchievement)this.b.achievement.get();
      } else {
        paramArrayOfByte = null;
      }
      this.n = paramArrayOfByte;
      paramArrayOfByte = localObject;
      if (this.b.rankData.has()) {
        paramArrayOfByte = this.b.rankData.get();
      }
      this.o = paramArrayOfByte;
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      QLog.e("FSPersonalInfo", 1, "mergeFrom StUserBusiData error");
      paramArrayOfByte.printStackTrace();
    }
  }
  
  private void c()
  {
    Object localObject = this.S;
    if (localObject == null) {
      return;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((QFSPersonalInfo.OnParseFinishListener)((Iterator)localObject).next()).a(this);
    }
    this.S.clear();
  }
  
  private void c(FeedCloudMeta.StUser paramStUser)
  {
    if (paramStUser == null) {
      return;
    }
    this.a.set(paramStUser);
    this.c = paramStUser.id.get();
    this.d = paramStUser.nick.get();
    this.e = paramStUser.desc.get();
    String str;
    if (paramStUser.constellation.get() > 0) {
      str = com.tencent.biz.qqcircle.QCirclePluginInnerConstant.a[(paramStUser.constellation.get() - 1)];
    } else {
      str = "";
    }
    this.f = str;
    this.g = QCircleTextUtils.a(paramStUser.location.get());
    this.h = paramStUser.blackState.get();
    this.v = QCirclePluginUtil.d(this.c);
    int i1 = this.h;
    boolean bool2 = false;
    if (i1 != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.w = bool1;
    boolean bool1 = bool2;
    if (!this.v)
    {
      bool1 = bool2;
      if (this.R) {
        bool1 = true;
      }
    }
    this.y = bool1;
  }
  
  public void a(QFSPersonalInfo.OnParseFinishListener paramOnParseFinishListener)
  {
    List localList = this.S;
    if (localList == null) {
      this.S = new ArrayList();
    } else if (localList.contains(paramOnParseFinishListener)) {
      return;
    }
    this.S.add(paramOnParseFinishListener);
  }
  
  public void a(FeedCloudMeta.StUser paramStUser)
  {
    c(paramStUser);
    if (!QFSThreadUtils.b())
    {
      b(paramStUser.busiData.get().toByteArray());
      return;
    }
    QFSThreadUtils.a(new QFSPersonalInfo.3(this, paramStUser));
  }
  
  public boolean a()
  {
    return QCirclePluginUtil.c(this.a);
  }
  
  public String b()
  {
    return this.a.id.get();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (getClass() == paramObject.getClass()))
    {
      paramObject = (QFSPersonalInfo)paramObject;
      return this.c.equals(paramObject.c);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.personal.bean.QFSPersonalInfo
 * JD-Core Version:    0.7.0.1
 */