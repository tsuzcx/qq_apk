package com.tencent.biz.qqcircle.publish.task;

import android.os.Handler;
import android.os.Looper;
import com.qq.jce.wup.UniAttribute;
import com.qq.taf.jce.JceStruct;
import com.tencent.biz.qqcircle.publish.common.IQZoneProtocolListener;
import com.tencent.biz.qqcircle.publish.common.IQZoneServiceListener;
import com.tencent.biz.qqcircle.publish.common.QCircleBusinessLooper;
import com.tencent.biz.qqcircle.publish.common.QCircleProtocolService;
import com.tencent.biz.qqcircle.publish.queue.util.NeedParcel;
import com.tencent.biz.qqcircle.publish.queue.util.SmartParcelable;
import com.tencent.biz.qqcircle.publish.request.QCircleRequest;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class QCircleTask
  implements IQZoneProtocolListener, SmartParcelable
{
  static final String al = "com.tencent.biz.qqcircle.publish.task.QCircleTask";
  public static boolean aq = false;
  protected static final QCircleProtocolService ar = QCircleProtocolService.a();
  private static Handler b = new Handler(Looper.getMainLooper());
  private WeakReference<Handler> a;
  public transient UniAttribute am;
  public transient IQZoneServiceListener an;
  @NeedParcel
  public transient String ao = "";
  @NeedParcel
  public int ap;
  @NeedParcel
  public QCircleRequest as;
  @NeedParcel
  public int at;
  @NeedParcel
  public HashMap<Object, Object> au = new HashMap();
  @NeedParcel
  public String av;
  @NeedParcel
  public int aw;
  public long ax;
  
  public QCircleTask()
  {
    this.ax = System.currentTimeMillis();
  }
  
  public QCircleTask(QCircleRequest paramQCircleRequest, Handler paramHandler, IQZoneServiceListener paramIQZoneServiceListener, int paramInt)
  {
    this.as = paramQCircleRequest;
    this.at = paramInt;
    this.an = paramIQZoneServiceListener;
    this.ax = System.currentTimeMillis();
    if (paramHandler != null) {
      this.a = new WeakReference(paramHandler);
    }
  }
  
  private String c(int paramInt)
  {
    switch (paramInt)
    {
    case 1000005: 
    case 1000007: 
    default: 
      return "";
    case 1000006: 
      String str = al;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(al);
      localStringBuilder.append("\t 网络无连接");
      QLog.i(str, 1, localStringBuilder.toString());
      return QCircleConfigHelper.a("QZoneTextSetting", "NetWorkNotConnect", "网络无连接");
    }
    return "";
  }
  
  public void E()
  {
    Object localObject = this.as;
    if (localObject != null)
    {
      ((QCircleRequest)localObject).a(this.aw);
      if (aq)
      {
        localObject = new StringBuilder();
        if (this.as.q != null) {
          this.as.q.display((StringBuilder)localObject, 0);
        }
      }
    }
    int i = ar.a(this.as, this);
    if (i != 0) {
      a(null, i, i, c(i), false);
    }
  }
  
  public boolean G()
  {
    int i = this.ap;
    return ((i == 0) || ((Math.abs(i) <= 19999) && (Math.abs(this.ap) >= 19000))) && (this.am != null);
  }
  
  public void a(UniAttribute paramUniAttribute, int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    this.am = paramUniAttribute;
    this.ap = paramInt1;
    this.ao = paramString;
    if (1000006 == paramInt1) {
      this.ao = QCircleConfigHelper.a("QZoneTextSetting", "NetWorkNotConnect", "网络无连接");
    }
    if (paramBoolean)
    {
      E();
      return;
    }
    QCircleBusinessLooper.a().b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.task.QCircleTask
 * JD-Core Version:    0.7.0.1
 */