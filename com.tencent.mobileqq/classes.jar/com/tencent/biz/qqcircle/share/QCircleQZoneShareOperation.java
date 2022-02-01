package com.tencent.biz.qqcircle.share;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants.AppConstants.Key;
import com.tencent.biz.qcircleshadow.lib.QCircleHostQzoneHelper;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qcircle.cooperation.config.SharePreferenceUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.picload.avatar.AvatarOption;
import cooperation.qqcircle.picload.avatar.QCircleAvatarLoader;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StIconInfo;
import feedcloud.FeedCloudMeta.StShare;
import feedcloud.FeedCloudMeta.StShareQzoneInfo;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class QCircleQZoneShareOperation
  extends QCircleBaseShareOperation
{
  private final Bundle a = new Bundle();
  private String b;
  private String c;
  private String d;
  private String e;
  
  public QCircleQZoneShareOperation(QCircleBaseShareOperation.Builder paramBuilder)
  {
    super(paramBuilder);
  }
  
  private void A()
  {
    Object localObject = f().b.share.shareQzoneInfo.entrys.get();
    HashMap localHashMap = new HashMap();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        FeedCloudCommon.Entry localEntry = (FeedCloudCommon.Entry)((Iterator)localObject).next();
        localHashMap.put(localEntry.key.get(), localEntry.value.get());
      }
      if (f().d == 1) {
        this.b = f().b.poster.icon.iconUrl.get();
      } else {
        this.b = ((String)localHashMap.get("COVERURL"));
      }
      this.c = ((String)localHashMap.get("title"));
      this.d = ((String)localHashMap.get("summary"));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append((String)localHashMap.get("actionurl"));
      ((StringBuilder)localObject).append("&from=7");
      this.e = ((StringBuilder)localObject).toString();
    }
    this.a.putSerializable(QCircleHostConstants.AppConstants.Key.SHARE_REQ_SHARE_QZONE_INFO(), HostDataTransUtils.wrapSerializableMap(localHashMap));
    this.a.putString(QCircleHostConstants.AppConstants.Key.SHARE_REQ_TITLE(), this.c);
    this.a.putString(QCircleHostConstants.AppConstants.Key.SHARE_REQ_DESC(), this.d);
    this.a.putString(QCircleHostConstants.AppConstants.Key.SHARE_REQ_DETAIL_URL(), this.e);
    this.a.putLong(QCircleHostConstants.AppConstants.Key.SHARE_REQ_ID(), 0L);
  }
  
  private void b(String paramString)
  {
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(paramString);
    this.a.putStringArrayList(QCircleHostConstants.AppConstants.Key.SHARE_REQ_IMAGE_URL(), localArrayList);
    a(true);
    QCircleHostQzoneHelper.jumpToQzoneShare(HostDataTransUtils.getAccount(), i(), this.a, null, -1);
    if (QLog.isColorLevel()) {
      QLog.d("QCircleQZoneShare", 1, "shareToQZone  success");
    }
  }
  
  private long c(String paramString)
  {
    long l1;
    if ((TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(f().b.poster.id.get()))) {
      try
      {
        l1 = Long.parseLong(f().b.poster.id.get());
      }
      catch (NumberFormatException localNumberFormatException)
      {
        QLog.d("QCircleQZoneShare", 1, "[shareToQZone] parse poster#id error!", localNumberFormatException);
      }
    } else {
      l1 = 0L;
    }
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("avatar://"))) {
      try
      {
        long l2 = Long.parseLong(paramString.substring(9));
        return l2;
      }
      catch (NumberFormatException paramString)
      {
        QLog.e("QCircleQZoneShare", 1, "[shareToQZone] parse uin error!", paramString);
      }
    }
    return l1;
  }
  
  private void u()
  {
    if ((!a(57)) && (!QCircleConfigHelper.bg()))
    {
      if (a(32))
      {
        y();
        return;
      }
      if (a(31))
      {
        x();
        return;
      }
      if (c())
      {
        w();
        return;
      }
      v();
      return;
    }
    z();
  }
  
  private void v()
  {
    if (f().c != null) {
      localObject = f().c.mFeed;
    } else {
      localObject = null;
    }
    QCircleLpReportDc05501.DataBuilder localDataBuilder = QCirclePluginReportUtil.b((FeedCloudMeta.StFeed)localObject).setActionType(26).setSubActionType(2);
    if ((f().c != null) && (f().c.mFeed != null)) {
      localObject = f().c.mFeed.poster.id.get();
    } else {
      localObject = "";
    }
    Object localObject = localDataBuilder.setToUin((String)localObject);
    int i;
    if (f().c != null) {
      i = f().c.mDataPosition;
    } else {
      i = -1;
    }
    QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(((QCircleLpReportDc05501.DataBuilder)localObject).setIndex(i).setPageId(g())));
  }
  
  private void w()
  {
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(d()).setSubActionType(3).setThrActionType(2).setExt6(String.valueOf(f().f)).setPageId(g()));
  }
  
  private void x()
  {
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(f().b.poster.id.get()).setActionType(6).setSubActionType(4).setThrActionType(2).setPageId(g()));
  }
  
  private void y()
  {
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(f().b.poster.id.get()).setActionType(11).setSubActionType(9).setThrActionType(2).setExt9(k()).setFeedReportInfo(l()).setPageId(g()));
  }
  
  private void z()
  {
    a(26, 2, f().c, "");
    a("share", "qzone");
  }
  
  public void a()
  {
    if ((f() != null) && (f().b != null) && (f().b.poster != null) && (f().b.share != null) && (i() != null))
    {
      A();
      u();
      long l = c(this.b);
      if (l > 0L)
      {
        AvatarOption localAvatarOption = new AvatarOption().setUin(String.valueOf(l)).setUrlListener(new QCircleQZoneShareOperation.1(this));
        QCircleAvatarLoader.g().loadAvatar(localAvatarOption);
      }
      else
      {
        b(this.b);
      }
      SharePreferenceUtils.a(i(), "share_lately_type_key", "share_type_qzone");
      return;
    }
    a("QCircleQZoneShare");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.share.QCircleQZoneShareOperation
 * JD-Core Version:    0.7.0.1
 */