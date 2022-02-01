package com.tencent.biz.qqcircle.viewmodels;

import android.os.CountDownTimer;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.event.QCirclePublishButtonEvent;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.eevee.QCircleEeveeMananger;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import cooperation.qqcircle.report.QCirclePublishQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import feedcloud.FeedCloudCommon.Entry;
import java.util.Arrays;
import java.util.HashMap;
import qqcircle.QQCircleBase.StPublishButtonAnimationInfo;

public class QCirclePublishButtonViewModel
  extends QCircleBaseViewModel
{
  private final MutableLiveData<QCirclePublishButtonViewModel.PublishButtonEventInfo> a = new MutableLiveData();
  private boolean b;
  private QCirclePublishButtonViewModel.PublishButtonEventInfo c;
  private boolean d;
  private boolean e;
  private CountDownTimer f;
  private CountDownTimer g;
  private String h = "0";
  private String i;
  private long j = 0L;
  private boolean l = false;
  
  private QCircleLpReportDc05504.DataBuilder c(int paramInt1, int paramInt2)
  {
    QCircleLpReportDc05504.DataBuilder localDataBuilder = new QCircleLpReportDc05504.DataBuilder().setToUin(HostDataTransUtils.getAccount()).setActionType(14).setThrActionType(0).setExt1(String.valueOf(paramInt2)).setExt3(String.valueOf(System.currentTimeMillis())).setExt6("0").setPageId(paramInt1);
    if (this.e)
    {
      localDataBuilder.setExt6(this.h);
      if (this.i != null)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("YuhengChannelTransInfo", this.i);
        localDataBuilder.setExtras(localHashMap);
      }
    }
    return localDataBuilder;
  }
  
  public String a()
  {
    return "QCirclePublishButtonViewModel";
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.j > 0L)
    {
      QCircleLpReportDc05504.report(c(paramInt1, paramInt2).setSubActionType(1).setExt4(String.valueOf(System.currentTimeMillis() - this.j)));
      return;
    }
    QCircleLpReportDc05504.report(c(paramInt1, paramInt2).setSubActionType(1));
  }
  
  public void a(QCirclePublishButtonEvent paramQCirclePublishButtonEvent)
  {
    if (this.d) {
      return;
    }
    if (this.b) {
      return;
    }
    if (paramQCirclePublishButtonEvent != null)
    {
      if (paramQCirclePublishButtonEvent.mData == null) {
        return;
      }
      QQCircleBase.StPublishButtonAnimationInfo localStPublishButtonAnimationInfo = new QQCircleBase.StPublishButtonAnimationInfo();
      try
      {
        localStPublishButtonAnimationInfo.mergeFrom(paramQCirclePublishButtonEvent.mData);
        if (localStPublishButtonAnimationInfo.isShowAnimation.get() == 0) {
          return;
        }
        if (this.c != null) {
          return;
        }
        this.c = new QCirclePublishButtonViewModel.PublishButtonEventInfo();
        paramQCirclePublishButtonEvent = this.c;
        paramQCirclePublishButtonEvent.a = true;
        paramQCirclePublishButtonEvent.b = localStPublishButtonAnimationInfo.hashIcon.get();
        this.c.c = localStPublishButtonAnimationInfo.hashTag.get();
        this.c.d = localStPublishButtonAnimationInfo.words.get();
        this.c.g = localStPublishButtonAnimationInfo.jumpUrl.get();
        this.c.h = (localStPublishButtonAnimationInfo.animationStartupTime.get() * 1000L);
        this.c.i = (localStPublishButtonAnimationInfo.animationShowTime.get() * 1000L);
        this.i = localStPublishButtonAnimationInfo.reportExt.get();
        this.h = localStPublishButtonAnimationInfo.taskId.get();
        paramQCirclePublishButtonEvent = QCircleSkinHelper.getInstance().convertUrl(localStPublishButtonAnimationInfo.operatorIcon.get());
        if (!TextUtils.isEmpty(paramQCirclePublishButtonEvent))
        {
          paramQCirclePublishButtonEvent = URLDrawable.getDrawable(paramQCirclePublishButtonEvent, URLDrawable.URLDrawableOptions.obtain());
          paramQCirclePublishButtonEvent.setURLDrawableListener(new QCirclePublishButtonViewModel.1(this));
          paramQCirclePublishButtonEvent.startDownload();
        }
        paramQCirclePublishButtonEvent = QCircleSkinHelper.getInstance().convertUrl(localStPublishButtonAnimationInfo.backImg.get());
        if (!TextUtils.isEmpty(paramQCirclePublishButtonEvent))
        {
          paramQCirclePublishButtonEvent = URLDrawable.getDrawable(paramQCirclePublishButtonEvent, URLDrawable.URLDrawableOptions.obtain());
          paramQCirclePublishButtonEvent.setURLDrawableListener(new QCirclePublishButtonViewModel.2(this));
          paramQCirclePublishButtonEvent.startDownload();
        }
        return;
      }
      catch (Exception paramQCirclePublishButtonEvent)
      {
        QLog.e("QCirclePublishButtonViewModel", 1, "notifyPublishButtonEvent", paramQCirclePublishButtonEvent);
      }
    }
  }
  
  public void a(Boolean paramBoolean)
  {
    this.l = paramBoolean.booleanValue();
  }
  
  public void b()
  {
    this.b = true;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    QLog.d("QCirclePublishButtonViewModel", 1, "publish button click: actiontype:14,subActionType:2,thrActionType:0,report to dc05504");
    QCircleLpReportDc05504.report(c(paramInt1, paramInt2).setSubActionType(2));
    QCirclePublishQualityReporter.report(QCirclePublishQualityReporter.E_PUBLISH_CLICK, Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("ext1", "publish button click: actiontype:14,subActionType:2,thrActionType:0,report to dc05504") }));
  }
  
  public LiveData<QCirclePublishButtonViewModel.PublishButtonEventInfo> c()
  {
    return this.a;
  }
  
  public void d()
  {
    byte[] arrayOfByte = QCircleEeveeMananger.getInstance().getBizUndealMsgBuffer(107);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("loadLocalEvent ");
    boolean bool;
    if (arrayOfByte != null) {
      bool = true;
    } else {
      bool = false;
    }
    ((StringBuilder)localObject).append(bool);
    QLog.d("QCirclePublishButtonViewModel", 1, ((StringBuilder)localObject).toString());
    if (arrayOfByte == null) {
      return;
    }
    QCircleEeveeMananger.getInstance().deleteBizUndealMsgBuffer(107);
    try
    {
      localObject = new QQCircleBase.StPublishButtonAnimationInfo();
      ((QQCircleBase.StPublishButtonAnimationInfo)localObject).mergeFrom(arrayOfByte);
      a(new QCirclePublishButtonEvent(((QQCircleBase.StPublishButtonAnimationInfo)localObject).toByteArray()));
      return;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      QLog.e("QCirclePublishButtonViewModel", 1, "loadLocalEvent error: ", localInvalidProtocolBufferMicroException);
    }
  }
  
  public void e()
  {
    if (this.d) {
      return;
    }
    QCirclePublishButtonViewModel.PublishButtonEventInfo localPublishButtonEventInfo = this.c;
    if (localPublishButtonEventInfo != null)
    {
      if (localPublishButtonEventInfo.a() == -1) {
        return;
      }
      this.d = true;
      long l1 = this.c.h;
      this.f = new QCirclePublishButtonViewModel.3(this, l1, l1).start();
    }
  }
  
  public void f()
  {
    if ((this.c != null) && (this.d))
    {
      if (this.e) {
        return;
      }
      this.d = false;
      CountDownTimer localCountDownTimer = this.f;
      if (localCountDownTimer != null) {
        localCountDownTimer.cancel();
      }
      localCountDownTimer = this.g;
      if (localCountDownTimer != null) {
        localCountDownTimer.cancel();
      }
    }
  }
  
  public void g()
  {
    if (!this.d) {
      return;
    }
    if (this.c == null) {
      return;
    }
    this.j = System.currentTimeMillis();
    long l1 = this.c.i;
    this.g = new QCirclePublishButtonViewModel.4(this, l1, l1).start();
  }
  
  public void h()
  {
    this.c = null;
    this.j = 0L;
    this.h = "0";
    this.e = false;
  }
  
  public void i()
  {
    Object localObject = this.g;
    if (localObject != null) {
      ((CountDownTimer)localObject).cancel();
    }
    localObject = this.c;
    if (localObject != null)
    {
      ((QCirclePublishButtonViewModel.PublishButtonEventInfo)localObject).a = false;
      this.a.postValue(localObject);
    }
  }
  
  public boolean j()
  {
    return this.l;
  }
  
  protected void onCleared()
  {
    super.onCleared();
    QCircleEeveeMananger.getInstance().deleteBizUndealMsgBuffer(107);
    CountDownTimer localCountDownTimer = this.f;
    if (localCountDownTimer != null) {
      localCountDownTimer.cancel();
    }
    localCountDownTimer = this.g;
    if (localCountDownTimer != null) {
      localCountDownTimer.cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.viewmodels.QCirclePublishButtonViewModel
 * JD-Core Version:    0.7.0.1
 */