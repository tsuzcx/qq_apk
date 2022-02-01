import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import cooperation.vip.jsoninflate.model.AlumBasicData;
import cooperation.vip.manager.GdtGeneralManager.2;
import cooperation.vip.manager.GdtGeneralManager.3;
import cooperation.vip.manager.GdtGeneralManager.5;
import cooperation.vip.pb.vac_adv_get.VacAdvMetaMsg;
import cooperation.vip.pb.vac_adv_get.VacAdvRsp;
import cooperation.vip.pb.vac_adv_get.VacFeedsAdvMetaReq;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;

public class bnvx
{
  private static final bnhx<bnvx, Void> jdField_a_of_type_Bnhx = new bnvy();
  public WeakReference<bnvz> a;
  public HashMap<Long, qq_ad_get.QQAdGetRsp.AdInfo> a;
  public HashSet<String> a;
  private qq_ad_get.QQAdGet.DeviceInfo jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo;
  
  public bnvx()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
  }
  
  public static bnvx a()
  {
    return (bnvx)jdField_a_of_type_Bnhx.b(null);
  }
  
  public HashSet<String> a()
  {
    return this.jdField_a_of_type_JavaUtilHashSet;
  }
  
  public qq_ad_get.QQAdGet.DeviceInfo a()
  {
    for (;;)
    {
      try
      {
        localObject = new acwc();
        ((acwc)localObject).a = "1018ec";
        localObject = acwb.a(BaseApplicationImpl.getApplication(), (acwc)localObject);
        if (localObject == null) {
          continue;
        }
        localObject = ((acwd)localObject).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo;
        this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo = ((qq_ad_get.QQAdGet.DeviceInfo)localObject);
        if ((QZLog.isColorLevel()) && (this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.taid_ticket.get()))) {
          QZLog.i("GdtGeneralManager", "@gdttaid  is not null");
        }
      }
      catch (Exception localException)
      {
        Object localObject;
        QZLog.e("GdtGeneralManager", 2, new Object[] { localException.toString() });
        continue;
      }
      return this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo;
      localObject = null;
    }
  }
  
  public void a()
  {
    ThreadManager.executeOnSubThread(new GdtGeneralManager.5(this));
  }
  
  public void a(int paramInt, vac_adv_get.VacAdvRsp paramVacAdvRsp)
  {
    switch (paramInt)
    {
    default: 
      QZLog.e("GdtGeneralManager", "onGdtInfoResponse erro businessType =" + paramInt);
      return;
    }
    a(paramVacAdvRsp);
  }
  
  public void a(long paramLong, int paramInt1, String paramString, int paramInt2, bnvz parambnvz)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambnvz);
    QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").post(new GdtGeneralManager.2(this, paramLong, paramInt1, paramInt2, paramString));
  }
  
  public void a(bnvc parambnvc)
  {
    if (parambnvc == null) {
      return;
    }
    if (this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo == null)
    {
      QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").post(new GdtGeneralManager.3(this, parambnvc));
      return;
    }
    bnwa.a(parambnvc, this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo);
    QZLog.i("GdtGeneralManager", " @getGdtInfo sendAdvInfoExposeOrClickReport");
  }
  
  public void a(vac_adv_get.VacAdvRsp paramVacAdvRsp)
  {
    if (paramVacAdvRsp == null) {
      return;
    }
    ArrayList localArrayList;
    try
    {
      localArrayList = new ArrayList();
      paramVacAdvRsp = paramVacAdvRsp.vac_adv_msgs.get();
      if ((paramVacAdvRsp == null) || (paramVacAdvRsp.size() <= 0)) {
        break label209;
      }
      paramVacAdvRsp = paramVacAdvRsp.iterator();
      while (paramVacAdvRsp.hasNext())
      {
        vac_adv_get.VacAdvMetaMsg localVacAdvMetaMsg = (vac_adv_get.VacAdvMetaMsg)paramVacAdvRsp.next();
        localArrayList.add(AlumBasicData.a(localVacAdvMetaMsg));
        if ((localVacAdvMetaMsg != null) && (localVacAdvMetaMsg.adv_rsp != null) && (localVacAdvMetaMsg.adv_rsp.report_info != null) && (localVacAdvMetaMsg.adv_rsp.report_info.trace_info != null)) {
          this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(localVacAdvMetaMsg.adv_rsp.report_info.trace_info.aid.get()), localVacAdvMetaMsg.adv_rsp);
        }
      }
      if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
        break label200;
      }
    }
    catch (Exception paramVacAdvRsp)
    {
      QZLog.e("GdtGeneralManager", "handleAlumFloatViewData erro");
      return;
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
    {
      ((bnvz)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a((AlumBasicData)localArrayList.get(0));
      QZLog.i("GdtGeneralManager", " @getGdtInfo handleAlumFloatViewData success");
      return;
    }
    label200:
    QZLog.i("GdtGeneralManager", " @getGdtInfo handleAlumFloatViewData alumBasicDataList is null");
    return;
    label209:
    QZLog.i("GdtGeneralManager", " @getGdtInfo handleAlumFloatViewData advMetaMsg is null");
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilHashSet.add(paramString);
  }
  
  public void a(URL paramURL)
  {
    if (paramURL == null) {
      return;
    }
    for (;;)
    {
      try
      {
        paramURL = (HttpURLConnection)paramURL.openConnection();
        paramURL.setRequestMethod("POST");
        paramURL.setConnectTimeout(10000);
        paramURL.setReadTimeout(10000);
        paramURL.setUseCaches(false);
        paramURL.connect();
        int i = paramURL.getResponseCode();
        if (i != 200) {
          break label124;
        }
        bool = true;
        if (!QZLog.isColorLevel()) {
          break;
        }
        QZLog.i("GdtGeneralManager", "@getGdtInfo exporsure rspCode " + i + "， request gdt" + bool);
        return;
      }
      catch (Exception paramURL) {}
      if (!QZLog.isColorLevel()) {
        break;
      }
      QZLog.w("GdtGeneralManager", 2, new Object[] { paramURL.toString() });
      return;
      label124:
      boolean bool = false;
    }
  }
  
  public byte[] a()
  {
    vac_adv_get.VacFeedsAdvMetaReq localVacFeedsAdvMetaReq = new vac_adv_get.VacFeedsAdvMetaReq();
    try
    {
      if (this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo != null) {
        localVacFeedsAdvMetaReq.device_info.set(this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo);
      }
      return localVacFeedsAdvMetaReq.toByteArray();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QZLog.e("GdtGeneralManager", 2, new Object[] { localException.toString() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnvx
 * JD-Core Version:    0.7.0.1
 */