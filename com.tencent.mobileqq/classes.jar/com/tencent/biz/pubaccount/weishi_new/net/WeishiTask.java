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
  private static Handler jdField_a_of_type_AndroidOsHandler;
  protected static final WeishiProtocolService a;
  public static boolean a;
  public int a;
  public long a;
  public transient UniAttribute a;
  public transient IWeishiServiceListener a;
  public RspHeaderBean a;
  public WeishiRequest a;
  public Object a;
  public transient String a;
  private WeakReference<Handler> jdField_a_of_type_JavaLangRefWeakReference;
  public HashMap<Object, Object> a;
  public int b;
  public int c;
  public int d;
  
  static
  {
    jdField_a_of_type_Boolean = false;
    jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWeishiProtocolService = WeishiProtocolService.a();
  }
  
  public WeishiTask()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public WeishiTask(WeishiRequest paramWeishiRequest, Handler paramHandler, IWeishiServiceListener paramIWeishiServiceListener, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWeishiRequest = paramWeishiRequest;
    this.c = paramInt;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetIWeishiServiceListener = paramIWeishiServiceListener;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    if (paramHandler != null) {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramHandler);
    }
  }
  
  private String a(int paramInt)
  {
    switch (paramInt)
    {
    case 1000005: 
    default: 
      return "";
    case 1000006: 
      QZLog.i("QZLog", 1, "WeishiTask\t 网络无连接");
      return QzoneConfig.getInstance().getConfig("QZoneTextSetting", "NetWorkNotConnect", "网络无连接");
    case 1000004: 
      return "";
    }
    return "";
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWeishiRequest != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWeishiRequest.a(this.d);
      if (jdField_a_of_type_Boolean)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWeishiRequest.a != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWeishiRequest.a.display(localStringBuilder, 0);
        }
      }
      WSLog.a("WeishiTask", "startRunTask: " + this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWeishiRequest.getCmdString() + ", " + this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWeishiRequest.toString());
    }
    int i = jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWeishiProtocolService.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWeishiRequest, this);
    if (i != 0) {
      a(null, i, i, a(i), false, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetRspHeaderBean);
    }
  }
  
  public void a(Object paramObject, int paramInt1, int paramInt2, String paramString, boolean paramBoolean, RspHeaderBean paramRspHeaderBean)
  {
    if ((paramObject instanceof UniAttribute)) {
      this.jdField_a_of_type_ComQqJceWupUniAttribute = ((UniAttribute)paramObject);
    }
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.b = paramInt1;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetRspHeaderBean = paramRspHeaderBean;
    if (1000006 == paramInt1) {
      this.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131716747);
    }
    WeishiBusinessLooper.a().b(this);
  }
  
  public boolean a()
  {
    return (this.b == 0) || (this.b == 1000) || ((Math.abs(this.b) <= 19999) && (Math.abs(this.b) >= 19000));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.net.WeishiTask
 * JD-Core Version:    0.7.0.1
 */