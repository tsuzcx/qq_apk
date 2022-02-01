package com.tencent.biz.qqcircle.report;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.qcircleshadow.lib.variation.HostForwardUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostForwardUtils.ForwardInfoEntity;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.flutter.QQCircleMethodMine;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.beans.QCircleForwardInfoReportBean;
import cooperation.qqcircle.beans.QCircleForwardInfoReportBean.QCircleForwardExtraTypeInfo;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleLpReportDc05507.DataBuilder;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;

public class QCircleRecentlyChatReportHelper
{
  private QCircleExtraTypeInfo a;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private String g;
  
  private QCircleRecentlyChatReportHelper() {}
  
  private QCircleRecentlyChatReportHelper(int paramInt1, int paramInt2)
  {
    this.d = paramInt1;
    this.e = paramInt2;
  }
  
  private int a(int paramInt)
  {
    if (paramInt == 0) {
      return 1;
    }
    if (paramInt == 1) {
      return 2;
    }
    return 1;
  }
  
  private static QCircleExtraTypeInfo a(QCircleForwardInfoReportBean.QCircleForwardExtraTypeInfo paramQCircleForwardExtraTypeInfo)
  {
    if (paramQCircleForwardExtraTypeInfo == null) {
      return null;
    }
    QCircleExtraTypeInfo localQCircleExtraTypeInfo = new QCircleExtraTypeInfo();
    localQCircleExtraTypeInfo.mPlayScene = paramQCircleForwardExtraTypeInfo.mPlayScene;
    localQCircleExtraTypeInfo.mDataPosition = paramQCircleForwardExtraTypeInfo.mDataPosition;
    String str = paramQCircleForwardExtraTypeInfo.feedId;
    FeedCloudMeta.StFeed localStFeed = QQCircleMethodMine.getCurrentFeed();
    if (a(str, localStFeed))
    {
      localQCircleExtraTypeInfo.mFeed = localStFeed;
    }
    else
    {
      localStFeed = QQCircleMethodMine.findIdForFeed(str);
      if (a(str, localStFeed)) {
        localQCircleExtraTypeInfo.mFeed = localStFeed;
      }
    }
    localQCircleExtraTypeInfo.pageType = paramQCircleForwardExtraTypeInfo.pageType;
    localQCircleExtraTypeInfo.sourceType = paramQCircleForwardExtraTypeInfo.sourceType;
    localQCircleExtraTypeInfo.mCurrentPersonalUin = paramQCircleForwardExtraTypeInfo.mCurrentPersonalUin;
    localQCircleExtraTypeInfo.mGlobalViewModelKey = paramQCircleForwardExtraTypeInfo.mGlobalViewModelKey;
    localQCircleExtraTypeInfo.title = paramQCircleForwardExtraTypeInfo.title;
    return localQCircleExtraTypeInfo;
  }
  
  public static QCircleRecentlyChatReportHelper a(int paramInt1, int paramInt2)
  {
    return new QCircleRecentlyChatReportHelper(paramInt1, paramInt2);
  }
  
  public static QCircleForwardInfoReportBean.QCircleForwardExtraTypeInfo a(QCircleExtraTypeInfo paramQCircleExtraTypeInfo)
  {
    if (paramQCircleExtraTypeInfo == null) {
      return null;
    }
    QCircleForwardInfoReportBean.QCircleForwardExtraTypeInfo localQCircleForwardExtraTypeInfo = new QCircleForwardInfoReportBean.QCircleForwardExtraTypeInfo();
    localQCircleForwardExtraTypeInfo.mPlayScene = paramQCircleExtraTypeInfo.mPlayScene;
    localQCircleForwardExtraTypeInfo.mDataPosition = paramQCircleExtraTypeInfo.mDataPosition;
    String str;
    if (paramQCircleExtraTypeInfo.mFeed == null) {
      str = "";
    } else {
      str = paramQCircleExtraTypeInfo.mFeed.id.get();
    }
    localQCircleForwardExtraTypeInfo.feedId = str;
    localQCircleForwardExtraTypeInfo.pageType = paramQCircleExtraTypeInfo.pageType;
    localQCircleForwardExtraTypeInfo.sourceType = paramQCircleExtraTypeInfo.sourceType;
    localQCircleForwardExtraTypeInfo.mCurrentPersonalUin = paramQCircleExtraTypeInfo.mCurrentPersonalUin;
    localQCircleForwardExtraTypeInfo.mGlobalViewModelKey = paramQCircleExtraTypeInfo.mGlobalViewModelKey;
    localQCircleForwardExtraTypeInfo.title = paramQCircleExtraTypeInfo.title;
    return localQCircleForwardExtraTypeInfo;
  }
  
  private void a()
  {
    if (this.d == 57)
    {
      c();
      return;
    }
    b();
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, QCircleExtraTypeInfo paramQCircleExtraTypeInfo, HostForwardUtils.ForwardInfoEntity paramForwardInfoEntity)
  {
    if (paramQCircleExtraTypeInfo == null) {
      return;
    }
    if (paramForwardInfoEntity == null) {
      return;
    }
    if (TextUtils.equals(paramString, HostForwardUtils.HOST_FORWARD_DIALOG_RECENTLY_FLAG()))
    {
      a(paramInt1, paramInt2).b(paramQCircleExtraTypeInfo, paramForwardInfoEntity);
      return;
    }
    if (TextUtils.equals(paramString, HostForwardUtils.HOST_FORWARD_RECENTLY_CHAT_FLAG())) {
      a(paramInt1, paramInt2).d(paramQCircleExtraTypeInfo, paramForwardInfoEntity);
    }
  }
  
  public static void a(String paramString, @NonNull QCircleForwardInfoReportBean paramQCircleForwardInfoReportBean)
  {
    QCircleForwardInfoReportBean.QCircleForwardExtraTypeInfo localQCircleForwardExtraTypeInfo = paramQCircleForwardInfoReportBean.getReportExtra();
    a(paramString, paramQCircleForwardInfoReportBean.getPageId(), paramQCircleForwardInfoReportBean.getParentPageId(), a(localQCircleForwardExtraTypeInfo), paramQCircleForwardInfoReportBean.getForwardEntity());
  }
  
  private static boolean a(String paramString, FeedCloudMeta.StFeed paramStFeed)
  {
    return (paramStFeed != null) && (TextUtils.equals(paramString, paramStFeed.id.get()));
  }
  
  private void b()
  {
    FeedCloudMeta.StFeed localStFeed = f();
    if (localStFeed == null)
    {
      QLog.d("RHF-QCircleShareReportHelper", 1, "[reportToLpDc05501] feed should be not null.");
      return;
    }
    String str = d();
    QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(QCirclePluginReportUtil.b(localStFeed).setActionType(this.b).setSubActionType(this.c).setToUin(str).setPageId(this.d).setfPageId(this.e).setExt3(String.valueOf(this.f)).setExt4(String.valueOf(this.g)).setExt5(String.valueOf(1))));
  }
  
  public static void b(String paramString, int paramInt1, int paramInt2, @NonNull QCircleExtraTypeInfo paramQCircleExtraTypeInfo, @NonNull HostForwardUtils.ForwardInfoEntity paramForwardInfoEntity)
  {
    if (TextUtils.equals(paramString, HostForwardUtils.HOST_FORWARD_RECENTLY_CHAT_FLAG())) {
      a(paramInt1, paramInt2).c(paramQCircleExtraTypeInfo, paramForwardInfoEntity);
    }
  }
  
  public static void b(String paramString, @NonNull QCircleForwardInfoReportBean paramQCircleForwardInfoReportBean)
  {
    QCircleForwardInfoReportBean.QCircleForwardExtraTypeInfo localQCircleForwardExtraTypeInfo = paramQCircleForwardInfoReportBean.getReportExtra();
    b(paramString, paramQCircleForwardInfoReportBean.getPageId(), paramQCircleForwardInfoReportBean.getParentPageId(), a(localQCircleForwardExtraTypeInfo), paramQCircleForwardInfoReportBean.getForwardEntity());
  }
  
  private void c()
  {
    FeedCloudMeta.StFeed localStFeed = f();
    if (localStFeed == null)
    {
      QLog.d("RHF-QCircleShareReportHelper", 1, "[reportToLpDc05507] feed should be not null.");
      return;
    }
    String str = d();
    int i = e();
    int j = g();
    QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder(QCirclePluginReportUtil.d(localStFeed).setActionType(this.b).setSubActionType(this.c).setToUin(str).setPosition(i).setPlayScene(j).setPageId(this.d).setfpageid(this.e).setExt3(String.valueOf(this.f)).setExt4(String.valueOf(this.g)).setExt5(String.valueOf(1))));
  }
  
  private String d()
  {
    FeedCloudMeta.StFeed localStFeed = f();
    if (localStFeed == null) {
      return null;
    }
    return localStFeed.poster.id.get();
  }
  
  private int e()
  {
    Object localObject = this.a;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = Integer.valueOf(((QCircleExtraTypeInfo)localObject).mDataPosition);
    }
    return ((Integer)localObject).intValue();
  }
  
  private void e(QCircleExtraTypeInfo paramQCircleExtraTypeInfo, HostForwardUtils.ForwardInfoEntity paramForwardInfoEntity)
  {
    if (paramForwardInfoEntity != null)
    {
      this.f = a(paramForwardInfoEntity.getForwardUinType());
      this.g = paramForwardInfoEntity.getForwardUin();
    }
    this.a = paramQCircleExtraTypeInfo;
  }
  
  private FeedCloudMeta.StFeed f()
  {
    QCircleExtraTypeInfo localQCircleExtraTypeInfo = this.a;
    if (localQCircleExtraTypeInfo == null) {
      return null;
    }
    return localQCircleExtraTypeInfo.mFeed;
  }
  
  private int g()
  {
    Object localObject = this.a;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = Integer.valueOf(((QCircleExtraTypeInfo)localObject).mPlayScene);
    }
    return ((Integer)localObject).intValue();
  }
  
  public void a(QCircleExtraTypeInfo paramQCircleExtraTypeInfo, HostForwardUtils.ForwardInfoEntity paramForwardInfoEntity)
  {
    this.b = 124;
    this.c = 2;
    QLog.d("RHF-QCircleShareReportHelper", 1, new Object[] { "[reportDialogRecentlyClick] ", toString() });
    e(paramQCircleExtraTypeInfo, paramForwardInfoEntity);
    a();
  }
  
  public void b(QCircleExtraTypeInfo paramQCircleExtraTypeInfo)
  {
    this.b = 124;
    this.c = 1;
    QLog.d("RHF-QCircleShareReportHelper", 1, new Object[] { "[reportDialogRecentlyExport] ", toString() });
    e(paramQCircleExtraTypeInfo, null);
    a();
  }
  
  public void b(QCircleExtraTypeInfo paramQCircleExtraTypeInfo, HostForwardUtils.ForwardInfoEntity paramForwardInfoEntity)
  {
    this.b = 124;
    this.c = 3;
    QLog.d("RHF-QCircleShareReportHelper", 1, new Object[] { "[reportDialogRecentlySend] ", toString() });
    e(paramQCircleExtraTypeInfo, paramForwardInfoEntity);
    a();
  }
  
  public void c(QCircleExtraTypeInfo paramQCircleExtraTypeInfo)
  {
    this.b = 125;
    this.c = 1;
    QLog.d("RHF-QCircleShareReportHelper", 1, new Object[] { "[reportFriendSwitchExport] ", toString() });
    e(paramQCircleExtraTypeInfo, null);
    a();
  }
  
  public void c(QCircleExtraTypeInfo paramQCircleExtraTypeInfo, HostForwardUtils.ForwardInfoEntity paramForwardInfoEntity)
  {
    this.b = 125;
    this.c = 2;
    QLog.d("RHF-QCircleShareReportHelper", 1, new Object[] { "[reportFriendSwitchClick] ", toString() });
    e(paramQCircleExtraTypeInfo, paramForwardInfoEntity);
    a();
  }
  
  public void d(QCircleExtraTypeInfo paramQCircleExtraTypeInfo, HostForwardUtils.ForwardInfoEntity paramForwardInfoEntity)
  {
    this.b = 125;
    this.c = 3;
    QLog.d("RHF-QCircleShareReportHelper", 1, new Object[] { "[reportFriendSwitchSend] ", toString() });
    e(paramQCircleExtraTypeInfo, paramForwardInfoEntity);
    a();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QCircleRecentlyChatReportHelper{mActionType=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", mSubActionType=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", mPageId=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", mParentPageId=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", mChatType=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", mChatUin='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mShareBtnType=");
    localStringBuilder.append(1);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.report.QCircleRecentlyChatReportHelper
 * JD-Core Version:    0.7.0.1
 */