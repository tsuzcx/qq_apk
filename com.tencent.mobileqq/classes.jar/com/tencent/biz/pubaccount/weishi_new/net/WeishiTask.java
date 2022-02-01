package com.tencent.biz.pubaccount.weishi_new.net;

import android.os.Handler;
import android.os.Looper;
import com.qq.jce.wup.UniAttribute;
import com.qq.taf.jce.JceStruct;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.mobileqq.app.HardCodeUtil;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;

@Deprecated
public class WeishiTask
  implements IWeishiProtocolListener
{
  public static boolean f = false;
  protected static final WeishiProtocolService l = WeishiProtocolService.a();
  private static Handler p = new Handler(Looper.getMainLooper());
  public transient UniAttribute a;
  public transient IWeishiServiceListener b;
  public transient String c = "";
  public int d = 0;
  public int e;
  public WeishiRequest g;
  public int h;
  public HashMap<Object, Object> i = new HashMap();
  public int j;
  public long k;
  public Object m;
  public RspHeaderBean n;
  private WeakReference<Handler> o;
  
  public WeishiTask()
  {
    this.k = System.currentTimeMillis();
  }
  
  public WeishiTask(WeishiRequest paramWeishiRequest, Handler paramHandler, IWeishiServiceListener paramIWeishiServiceListener, int paramInt)
  {
    this.g = paramWeishiRequest;
    this.h = paramInt;
    this.b = paramIWeishiServiceListener;
    this.k = System.currentTimeMillis();
    if (paramHandler != null) {
      this.o = new WeakReference(paramHandler);
    }
  }
  
  private String a(int paramInt)
  {
    switch (paramInt)
    {
    case 1000005: 
    case 1000007: 
    default: 
      return "";
    case 1000006: 
      QZLog.i("QZLog", 1, "WeishiTask\t 网络无连接");
      return QzoneConfig.getInstance().getConfig("QZoneTextSetting", "NetWorkNotConnect", "网络无连接");
    }
    return "";
  }
  
  public void a()
  {
    Object localObject = this.g;
    if (localObject != null)
    {
      ((WeishiRequest)localObject).b(this.j);
      if (f)
      {
        localObject = new StringBuilder();
        if (this.g.c != null) {
          this.g.c.display((StringBuilder)localObject, 0);
        }
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startRunTask: ");
      ((StringBuilder)localObject).append(this.g.getCmdString());
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(this.g.toString());
      WSLog.a("WeishiTask", ((StringBuilder)localObject).toString());
    }
    int i1 = l.a(this.g, this);
    if (i1 != 0) {
      a(null, i1, i1, a(i1), false, this.n);
    }
  }
  
  public void a(Object paramObject, int paramInt1, int paramInt2, String paramString, boolean paramBoolean, RspHeaderBean paramRspHeaderBean)
  {
    if ((paramObject instanceof UniAttribute)) {
      this.a = ((UniAttribute)paramObject);
    }
    this.m = paramObject;
    this.e = paramInt1;
    this.d = paramInt2;
    this.c = paramString;
    this.n = paramRspHeaderBean;
    if (1000006 == paramInt1) {
      this.c = HardCodeUtil.a(2131913837);
    }
    WeishiBusinessLooper.a().b(this);
  }
  
  public boolean b()
  {
    int i1 = this.e;
    return (i1 == 0) || (i1 == 1000) || ((Math.abs(i1) <= 19999) && (Math.abs(this.e) >= 19000));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.net.WeishiTask
 * JD-Core Version:    0.7.0.1
 */