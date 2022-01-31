package com.tencent.mobileqq.armap;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.kingkong.DataReport;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.armap.config.ARMapConfig;
import com.tencent.mobileqq.armap.wealthgod.WealthGodInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import tencent.im.oidb.cmd0x7b4.cmd0x7b4.LBSSig;
import tencent.im.oidb.cmd0x7b4.cmd0x7b4.POIInfo;
import tencent.im.oidb.cmd0x7b4.cmd0x7b4.ReqBody;
import tencent.im.oidb.cmd0x7b4.cmd0x7b4.RspBody;
import tencent.im.oidb.cmd0x7b4.cmd0x7b4.TaskCommonInfo;
import tencent.im.oidb.cmd0x7b4.cmd0x7b4.TaskStatusInfo;
import tencent.im.oidb.cmd0x7bb.oidb_0x7bb.DeductItemRsp;
import tencent.im.oidb.cmd0x7bb.oidb_0x7bb.HistoryInfo;
import tencent.im.oidb.cmd0x7bb.oidb_0x7bb.ItemInfo;
import tencent.im.oidb.cmd0x7bb.oidb_0x7bb.LBSSig;
import tencent.im.oidb.cmd0x7bb.oidb_0x7bb.OpenPoiReq;
import tencent.im.oidb.cmd0x7bb.oidb_0x7bb.OpenPoiRsp;
import tencent.im.oidb.cmd0x7bb.oidb_0x7bb.PageHistoryRsp;
import tencent.im.oidb.cmd0x7bb.oidb_0x7bb.PageItemRsp;
import tencent.im.oidb.cmd0x7bb.oidb_0x7bb.PoiInfo;
import tencent.im.oidb.cmd0x7bb.oidb_0x7bb.QueryItemRsp;
import tencent.im.oidb.cmd0x7bb.oidb_0x7bb.QueryPoiReq;
import tencent.im.oidb.cmd0x7bb.oidb_0x7bb.QueryPoiRsp;
import tencent.im.oidb.cmd0x7bb.oidb_0x7bb.QueryTaskRsp;
import tencent.im.oidb.cmd0x7bb.oidb_0x7bb.ReportInfo;
import tencent.im.oidb.cmd0x7bb.oidb_0x7bb.ReportReq;
import tencent.im.oidb.cmd0x7bb.oidb_0x7bb.ReportRsp;
import tencent.im.oidb.cmd0x7bb.oidb_0x7bb.ReqBody;
import tencent.im.oidb.cmd0x7bb.oidb_0x7bb.RspBody;
import tencent.im.oidb.cmd0x7bb.oidb_0x7bb.TaskInfo;
import tencent.im.oidb.cmd0x84c.oidb_0x84c.CAdcodeInfo;
import tencent.im.oidb.cmd0x84c.oidb_0x84c.QueryCountReq;
import tencent.im.oidb.cmd0x84c.oidb_0x84c.QueryCountRsp;
import tencent.im.oidb.cmd0x84c.oidb_0x84c.ReqBody;
import tencent.im.oidb.cmd0x84c.oidb_0x84c.RspBody;
import tencent.im.oidb.cmd0x95a.cmd0x95a.GetArActivityRedReq;
import tencent.im.oidb.cmd0x95a.cmd0x95a.GetArActivityRedRsp;
import tencent.im.oidb.cmd0x95a.cmd0x95a.JoinWorldCupReq;
import tencent.im.oidb.cmd0x95a.cmd0x95a.JoinWorldCupRsp;
import tencent.im.oidb.cmd0x95a.cmd0x95a.ReqBody;
import tencent.im.oidb.cmd0x95a.cmd0x95a.RspBody;
import tencent.im.oidb.cmd0x95a.cmd0x95a.SetWorldCupInfoReq;
import tencent.im.oidb.cmd0x95a.cmd0x95a.SetWorldCupInfoRsp;
import tencent.im.oidb.cmd0x95a.cmd0x95a.UpdateArCountRsp;
import tencent.im.oidb.cmd0x95a.cmd0x95a.WorldCupInfo;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.oidb.olympic.MqqLbs.CheatApp;
import tencent.im.oidb.olympic.MqqLbs.LBSCheckInfo;
import tencent.im.oidb.olympic.MqqLbs.LBSFakeInfo;

public class ArMapHandler
  extends BusinessHandler
{
  public static final Object a;
  public static final Object b;
  private double jdField_a_of_type_Double;
  private int jdField_a_of_type_Int;
  public volatile long a;
  private JNIPOIRequestParam jdField_a_of_type_ComTencentMobileqqArmapJNIPOIRequestParam;
  public String a;
  private MqqLbs.LBSCheckInfo jdField_a_of_type_TencentImOidbOlympicMqqLbs$LBSCheckInfo;
  boolean jdField_a_of_type_Boolean = false;
  private double jdField_b_of_type_Double;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private double jdField_c_of_type_Double;
  private String jdField_c_of_type_JavaLangString;
  
  static
  {
    jdField_a_of_type_JavaLangObject = Integer.valueOf(1);
    jdField_b_of_type_JavaLangObject = Integer.valueOf(2);
  }
  
  public ArMapHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.jdField_a_of_type_JavaLangString = "神秘好友";
  }
  
  private void a(ToServiceMsg paramToServiceMsg, boolean paramBoolean, int paramInt, oidb_0x7bb.DeductItemRsp paramDeductItemRsp)
  {
    int j = 0;
    int i = j;
    if (paramBoolean)
    {
      i = j;
      if (paramInt == 0)
      {
        i = j;
        if (paramDeductItemRsp != null) {
          i = paramDeductItemRsp.count.get();
        }
      }
    }
    a(10, paramBoolean, Integer.valueOf(i));
  }
  
  private void a(ToServiceMsg paramToServiceMsg, boolean paramBoolean1, int paramInt, oidb_0x7bb.OpenPoiRsp paramOpenPoiRsp, boolean paramBoolean2)
  {
    Object localObject;
    boolean bool;
    if ((paramBoolean1) && (paramInt == 0) && (paramOpenPoiRsp != null))
    {
      localObject = ItemInfo.a((oidb_0x7bb.ItemInfo)paramOpenPoiRsp.item.get());
      if (paramOpenPoiRsp.holder.has()) {
        bool = paramOpenPoiRsp.holder.get();
      }
    }
    for (paramOpenPoiRsp = (oidb_0x7bb.OpenPoiRsp)localObject;; paramOpenPoiRsp = null)
    {
      localObject = (String)paramToServiceMsg.getAttribute("businessType", "-1");
      String str = (String)paramToServiceMsg.getAttribute("distance", "-1");
      paramToServiceMsg = (String)paramToServiceMsg.getAttribute("mode", "-1");
      if (QLog.isColorLevel()) {
        QLog.d("ArMapHandler", 2, "handleOpenPoiRsp, isSuc: " + paramBoolean1 + ", resultCode: " + paramInt + ", holder: " + bool + ", mode: " + paramToServiceMsg + ", businessType: " + (String)localObject + ", distance: " + str + ", isServerSuccess: " + paramBoolean2 + ", itemInfo: " + paramOpenPoiRsp);
      }
      a(5, paramBoolean1, new Object[] { String.valueOf(paramInt), paramOpenPoiRsp, Boolean.valueOf(bool), localObject, paramToServiceMsg, Boolean.valueOf(paramBoolean2) });
      return;
      bool = false;
      break;
      bool = false;
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, boolean paramBoolean, int paramInt, oidb_0x7bb.PageHistoryRsp paramPageHistoryRsp)
  {
    int i = -1;
    boolean bool;
    if ((paramBoolean) && (paramInt == 0) && (paramPageHistoryRsp != null))
    {
      List localList = paramPageHistoryRsp.historys.get();
      bool = paramPageHistoryRsp.over.get();
      paramInt = paramPageHistoryRsp.next_start.get();
      if ((localList != null) && (!localList.isEmpty()))
      {
        paramToServiceMsg = new ArrayList();
        paramPageHistoryRsp = localList.iterator();
        while (paramPageHistoryRsp.hasNext()) {
          paramToServiceMsg.add(HistoryInfo.a((oidb_0x7bb.HistoryInfo)paramPageHistoryRsp.next()));
        }
      }
    }
    for (;;)
    {
      a(9, paramBoolean, new Object[] { paramToServiceMsg, Boolean.valueOf(bool), Integer.valueOf(paramInt) });
      return;
      paramToServiceMsg = null;
      continue;
      bool = false;
      paramToServiceMsg = null;
      paramInt = i;
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, boolean paramBoolean, int paramInt, oidb_0x7bb.PageItemRsp paramPageItemRsp)
  {
    int i = -1;
    boolean bool;
    if ((paramBoolean) && (paramInt == 0) && (paramPageItemRsp != null))
    {
      List localList = paramPageItemRsp.items.get();
      bool = paramPageItemRsp.over.get();
      paramInt = paramPageItemRsp.next_start.get();
      if ((localList != null) && (!localList.isEmpty()))
      {
        paramToServiceMsg = new ArrayList();
        paramPageItemRsp = localList.iterator();
        while (paramPageItemRsp.hasNext()) {
          paramToServiceMsg.add(ItemInfo.a((oidb_0x7bb.ItemInfo)paramPageItemRsp.next()));
        }
      }
    }
    for (;;)
    {
      a(8, paramBoolean, new Object[] { paramToServiceMsg, Boolean.valueOf(bool), Integer.valueOf(paramInt) });
      return;
      paramToServiceMsg = null;
      continue;
      bool = false;
      paramToServiceMsg = null;
      paramInt = i;
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, boolean paramBoolean, int paramInt, oidb_0x7bb.QueryItemRsp paramQueryItemRsp)
  {
    Object localObject = null;
    paramToServiceMsg = localObject;
    if (paramBoolean)
    {
      paramToServiceMsg = localObject;
      if (paramInt == 0)
      {
        paramToServiceMsg = localObject;
        if (paramQueryItemRsp != null)
        {
          paramQueryItemRsp = paramQueryItemRsp.item.get();
          paramToServiceMsg = localObject;
          if (paramQueryItemRsp != null)
          {
            paramToServiceMsg = localObject;
            if (!paramQueryItemRsp.isEmpty())
            {
              paramToServiceMsg = new ArrayList();
              paramQueryItemRsp = paramQueryItemRsp.iterator();
              while (paramQueryItemRsp.hasNext()) {
                paramToServiceMsg.add(ItemInfo.a((oidb_0x7bb.ItemInfo)paramQueryItemRsp.next()));
              }
            }
          }
        }
      }
    }
    a(7, paramBoolean, paramToServiceMsg);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, boolean paramBoolean, int paramInt, oidb_0x7bb.QueryPoiRsp paramQueryPoiRsp)
  {
    ArrayList localArrayList = null;
    int j = -1;
    long l = ((Long)paramToServiceMsg.getAttribute("poiId", Long.valueOf(-1L))).longValue();
    int i;
    if ((paramBoolean) && (paramInt == 0) && (paramQueryPoiRsp != null))
    {
      paramToServiceMsg = (oidb_0x7bb.PoiInfo)paramQueryPoiRsp.poi.get();
      if (paramQueryPoiRsp.status.has())
      {
        i = paramQueryPoiRsp.status.get();
        if (!paramQueryPoiRsp.style.has()) {
          break label181;
        }
      }
      label181:
      for (j = paramQueryPoiRsp.style.get();; j = 0)
      {
        paramToServiceMsg = POIInfo.a(paramToServiceMsg);
        paramQueryPoiRsp = paramQueryPoiRsp.items.get();
        if ((paramQueryPoiRsp == null) || (paramQueryPoiRsp.isEmpty())) {
          break label334;
        }
        localArrayList = new ArrayList();
        paramQueryPoiRsp = paramQueryPoiRsp.iterator();
        while (paramQueryPoiRsp.hasNext()) {
          localArrayList.add(ItemInfo.a((oidb_0x7bb.ItemInfo)paramQueryPoiRsp.next()));
        }
        i = 0;
        break;
      }
      paramQueryPoiRsp = paramToServiceMsg;
      paramToServiceMsg = localArrayList;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArMapHandler", 2, "handleQueryPoiRsp, isSuc:" + paramBoolean + ", resultCode:" + paramInt + " taskStatus:" + i + "\npoiInfo:" + paramQueryPoiRsp + "\nitemInfo:" + paramToServiceMsg + ",loadMapFlag:" + j + ",poiid:" + l);
      }
      a(6, paramBoolean, new Object[] { paramQueryPoiRsp, paramToServiceMsg, Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l) });
      return;
      label334:
      localArrayList = null;
      paramQueryPoiRsp = paramToServiceMsg;
      paramToServiceMsg = localArrayList;
      continue;
      i = -1;
      paramToServiceMsg = null;
      paramQueryPoiRsp = localArrayList;
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, boolean paramBoolean, int paramInt, oidb_0x7bb.QueryTaskRsp paramQueryTaskRsp)
  {
    Object localObject = null;
    paramToServiceMsg = localObject;
    if (paramBoolean)
    {
      paramToServiceMsg = localObject;
      if (paramInt == 0)
      {
        paramToServiceMsg = localObject;
        if (paramQueryTaskRsp != null)
        {
          paramQueryTaskRsp = paramQueryTaskRsp.tasks.get();
          paramToServiceMsg = localObject;
          if (paramQueryTaskRsp != null)
          {
            paramToServiceMsg = localObject;
            if (!paramQueryTaskRsp.isEmpty())
            {
              paramToServiceMsg = new ArrayList();
              paramQueryTaskRsp = paramQueryTaskRsp.iterator();
              while (paramQueryTaskRsp.hasNext()) {
                paramToServiceMsg.add(POITaskInfo.a((oidb_0x7bb.TaskInfo)paramQueryTaskRsp.next()));
              }
            }
          }
        }
      }
    }
    a(11, paramBoolean, paramToServiceMsg);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, boolean paramBoolean1, int paramInt, oidb_0x7bb.ReportRsp paramReportRsp, boolean paramBoolean2)
  {
    a(12, paramBoolean1, new Object[] { Boolean.valueOf(paramBoolean2) });
  }
  
  public static byte[] a(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = null;
    if (QLog.isColorLevel()) {
      QLog.d("ArMapHandler", 2, "getOIDBData ");
    }
    int i = paramFromServiceMsg.getResultCode();
    if (QLog.isDevelopLevel()) {}
    for (StringBuilder localStringBuilder = new StringBuilder();; localStringBuilder = null)
    {
      if (i == 1000) {
        if (paramObject == null) {}
      }
      for (;;)
      {
        try
        {
          paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
        }
        catch (Exception paramObject)
        {
          paramFromServiceMsg = null;
        }
        try
        {
          paramObject = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
          paramFromServiceMsg = paramObject;
          if ((paramFromServiceMsg != null) && (paramFromServiceMsg.uint32_result.get() != 0))
          {
            paramObject = paramFromServiceMsg.str_error_msg.get();
            if (localStringBuilder != null) {
              localStringBuilder.append("getOIDBData, errMsg: ").append(paramObject);
            }
          }
          if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.bytes_bodybuffer.has()) || (paramFromServiceMsg.bytes_bodybuffer.get() == null)) {
            break;
          }
          paramFromServiceMsg = paramFromServiceMsg.bytes_bodybuffer.get().toByteArray();
        }
        catch (Exception paramObject)
        {
          break label178;
          paramFromServiceMsg = null;
          continue;
        }
        if ((localStringBuilder != null) && (localStringBuilder.length() > 0) && (QLog.isDevelopLevel())) {
          QLog.i("ArMapHandler", 2, localStringBuilder.toString());
        }
        return paramFromServiceMsg;
        label178:
        if (localStringBuilder != null) {
          localStringBuilder.append("getOIDBData, oidb_sso, parseFrom byte ").append(paramObject.toString());
        }
        paramObject.printStackTrace();
        continue;
        if (localStringBuilder != null) {
          localStringBuilder.append("getOIDBData, data is null");
        }
        paramFromServiceMsg = null;
        continue;
        paramFromServiceMsg = localObject;
        if (localStringBuilder != null)
        {
          localStringBuilder.append("getOIDBData, sso result: ").append(i);
          paramFromServiceMsg = localObject;
        }
      }
    }
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2;
    Object localObject3;
    long l2;
    long l8;
    if (paramFromServiceMsg == null)
    {
      bool2 = false;
      localObject3 = null;
      if (paramToServiceMsg == null) {
        break label1515;
      }
      l2 = paramToServiceMsg.extraData.getLong("poi_req_native_handle");
      l8 = paramToServiceMsg.extraData.getLong("poi_req_nativeGLSurfaceViewContext");
    }
    for (;;)
    {
      long l3 = -1L;
      long l4 = -1L;
      Object localObject1 = "";
      Object localObject2 = "";
      long l1 = -1L;
      boolean bool1 = false;
      int n;
      label115:
      int i;
      label136:
      label157:
      int j;
      long l9;
      label300:
      long l5;
      long l6;
      if (bool2)
      {
        Object localObject5 = new cmd0x7b4.RspBody();
        n = a(paramFromServiceMsg, paramObject, (MessageMicro)localObject5);
        if (n == 0)
        {
          Object localObject4;
          if (((cmd0x7b4.RspBody)localObject5).rpt_poi_info.has())
          {
            localObject3 = ((cmd0x7b4.RspBody)localObject5).rpt_poi_info.get();
            if (!((cmd0x7b4.RspBody)localObject5).rpt_taskcommon_info.has()) {
              break label648;
            }
            localObject4 = ((cmd0x7b4.RspBody)localObject5).rpt_taskcommon_info.get();
            if (!((cmd0x7b4.RspBody)localObject5).uint32_get_award_range.has()) {
              break label654;
            }
            i = ((cmd0x7b4.RspBody)localObject5).uint32_get_award_range.get();
            if (!((cmd0x7b4.RspBody)localObject5).uint32_lbs_interval.has()) {
              break label660;
            }
          }
          label648:
          label654:
          label660:
          for (j = ((cmd0x7b4.RspBody)localObject5).uint32_lbs_interval.get();; j = 2)
          {
            if (i > 0) {
              ARMapActivity.jdField_a_of_type_Int = i;
            }
            localObject5 = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
            if ((localObject5 instanceof ArMapInterface)) {
              ((PoiExtraMng)((ArMapInterface)localObject5).getManager(212)).a((List)localObject3, (List)localObject4);
            }
            l9 = paramToServiceMsg.extraData.getLong("poi_req_native_handle");
            if (l9 == 0L) {
              break label1500;
            }
            localObject5 = a((List)localObject3);
            Object localObject6 = b((List)localObject4);
            a((ArrayList)localObject6, (ArrayList)localObject5);
            if ((localObject5 == null) || (((ArrayList)localObject5).isEmpty())) {
              break label1494;
            }
            bool1 = true;
            localObject4 = a(paramFromServiceMsg, paramObject);
            if (localObject4 == null) {
              break label1488;
            }
            l2 = localObject4.length;
            if ((this.jdField_a_of_type_Boolean) && (localObject4 != null) && (localObject4.length > 0))
            {
              if (QLog.isColorLevel()) {
                QLog.d("ArMapHandler", 2, "handleGetPOIList,call new update  isSuccess  = " + bool2 + ",result = " + n + ",nativeHandle = " + l9);
              }
              this.jdField_a_of_type_Boolean = false;
              a((byte[])localObject4);
            }
            l5 = l1;
            paramObject = localObject2;
            localObject3 = localObject1;
            l6 = l4;
            l7 = l3;
            if (localObject6 == null) {
              break label682;
            }
            l5 = l1;
            paramObject = localObject2;
            localObject3 = localObject1;
            l6 = l4;
            l7 = l3;
            if (((ArrayList)localObject6).isEmpty()) {
              break label682;
            }
            localObject6 = ((ArrayList)localObject6).iterator();
            paramObject = "";
            l3 = -1L;
            localObject1 = "";
            l4 = -1L;
            while (((Iterator)localObject6).hasNext())
            {
              POITaskInfo localPOITaskInfo = (POITaskInfo)((Iterator)localObject6).next();
              l6 = l1;
              localObject2 = localObject1;
              l5 = l4;
              if (!TextUtils.isEmpty(localPOITaskInfo.d))
              {
                localObject2 = localPOITaskInfo.d;
                l5 = localPOITaskInfo.jdField_a_of_type_Long;
                l6 = localPOITaskInfo.jdField_b_of_type_Long;
              }
              localObject3 = paramObject;
              l7 = l3;
              if (!TextUtils.isEmpty(localPOITaskInfo.f))
              {
                localObject3 = localPOITaskInfo.f;
                l7 = localPOITaskInfo.jdField_a_of_type_Long;
              }
              paramObject = localObject3;
              l3 = l7;
              l1 = l6;
              localObject1 = localObject2;
              l4 = l5;
              if (QLog.isColorLevel())
              {
                QLog.d("ArMapHandler", 2, "handleGetPOIList POITaskInfo:" + localPOITaskInfo);
                paramObject = localObject3;
                l3 = l7;
                l1 = l6;
                localObject1 = localObject2;
                l4 = l5;
              }
            }
            bool2 = paramFromServiceMsg.isSuccess();
            break;
            localObject3 = null;
            break label115;
            localObject4 = null;
            break label136;
            i = 0;
            break label157;
          }
          long l7 = l4;
          l6 = l3;
          localObject3 = localObject1;
          l5 = l1;
          label682:
          if ((QLog.isColorLevel()) && (localObject5 != null) && (!((ArrayList)localObject5).isEmpty()))
          {
            localObject1 = ((ArrayList)localObject5).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (POIInfo)((Iterator)localObject1).next();
              QLog.d("ArMapHandler", 2, "handleGetPOIList POIInfo:" + localObject2);
            }
          }
          localObject2 = localObject4;
          l3 = l7;
          l4 = l6;
          localObject1 = localObject3;
          l1 = l5;
          localObject3 = localObject2;
        }
      }
      for (;;)
      {
        l5 = l9;
        int i1 = 0;
        int m = j;
        int k = i;
        j = i1;
        i = m;
        l6 = l2;
        localObject2 = localObject3;
        m = j;
        l2 = l4;
        l4 = l6;
        j = i;
        i = n;
        label835:
        label856:
        boolean bool3;
        if (m != 0) {
          if ((paramFromServiceMsg != null) && (i == -1))
          {
            i = paramFromServiceMsg.getResultCode();
            paramFromServiceMsg = new HashMap();
            paramFromServiceMsg.put("failedType", String.valueOf(m));
            paramFromServiceMsg.put("result", String.valueOf(i));
            paramFromServiceMsg.put("hasPoiList", String.valueOf(bool1));
            if (paramToServiceMsg != null)
            {
              paramFromServiceMsg.put("lbsSig_verifyKey", paramToServiceMsg.extraData.getString("lbsSig_verifyKey"));
              paramFromServiceMsg.put("lbsSig_lon", paramToServiceMsg.extraData.getString("lbsSig_lon"));
              paramFromServiceMsg.put("lbsSig_lat", paramToServiceMsg.extraData.getString("lbsSig_lat"));
              paramFromServiceMsg.put("lbsSig_locationTime", paramToServiceMsg.extraData.getString("lbsSig_locationTime"));
              paramFromServiceMsg.put("accuracy", paramToServiceMsg.extraData.getString("accuracy"));
              paramFromServiceMsg.put("req_occasion", paramToServiceMsg.extraData.getString("req_occasion"));
              paramFromServiceMsg.put("imei", paramToServiceMsg.extraData.getString("imei"));
              paramFromServiceMsg.put("uin", paramToServiceMsg.getUin());
              paramFromServiceMsg.put("useJavaCache", paramToServiceMsg.extraData.getString("useJavaCache"));
            }
            paramToServiceMsg = StatisticCollector.a(BaseApplication.getContext());
            if (m == 0)
            {
              bool3 = true;
              label1078:
              paramToServiceMsg.a(null, "actARMapReqPOIListFailed", bool3, 0L, 0L, paramFromServiceMsg, "", false);
            }
          }
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ArMapHandler", 2, "handleGetPOIList, isSuccess  = " + bool2 + ",result = " + i + ",nativeHandle = " + l5 + ",awardRange = " + k);
          }
          for (;;)
          {
            a(0, bool2, new Object[] { Integer.valueOf(i), localObject2, Long.valueOf(l4), Long.valueOf(l5), Boolean.valueOf(bool1), Integer.valueOf(j), Long.valueOf(l8) });
            if ((!TextUtils.isEmpty((CharSequence)localObject1)) || (!TextUtils.isEmpty(paramObject))) {
              a(16, bool2, new Object[] { localObject1, paramObject, Long.valueOf(l3), Long.valueOf(l2), Long.valueOf(l1) });
            }
            if (QLog.isColorLevel()) {
              QLog.d("ArMapHandler", 2, "handleGetPOIList, isSuccess  = " + bool2 + ",result = " + i + ", AnimationId=" + (String)localObject1 + ", InsertScreen=" + paramObject);
            }
            return;
            k = 0;
            l6 = 0L;
            j = 2;
            i = 2;
            l5 = l2;
            paramObject = localObject2;
            l2 = l6;
            break;
            m = 1;
            l6 = -1L;
            l3 = -1L;
            k = 0;
            l5 = l2;
            l4 = 0L;
            localObject2 = null;
            bool1 = false;
            l1 = -1L;
            paramObject = "";
            j = 2;
            i = -1;
            localObject1 = "";
            l2 = l6;
            break label835;
            bool3 = false;
            break label1078;
            QLog.d("ArMapHandler", 1, "handleGetPOIList, isSuccess  = " + bool2 + ",result = " + i);
          }
          break label856;
        }
        label1488:
        l2 = 0L;
        break label300;
        label1494:
        bool1 = false;
        break;
        label1500:
        bool1 = false;
        localObject3 = null;
        l2 = 0L;
        paramObject = localObject2;
      }
      label1515:
      l8 = 0L;
      l2 = 0L;
    }
  }
  
  protected Class a()
  {
    return ArMapObserver.class;
  }
  
  ArrayList a(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArMapHandler", 2, "convertcmd0x7b4_POIInfo2POIInfo list is empty!");
      }
      return null;
    }
    paramList.size();
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (cmd0x7b4.POIInfo)paramList.next();
      double d1 = ((cmd0x7b4.POIInfo)localObject).int32_lon.get() * 1.0D / 1000000.0D;
      double d2 = ((cmd0x7b4.POIInfo)localObject).int32_lat.get() * 1.0D / 1000000.0D;
      POIInfo localPOIInfo = new POIInfo(((cmd0x7b4.POIInfo)localObject).uint64_poi_id.get(), d1, d2);
      localObject = ((cmd0x7b4.POIInfo)localObject).rpt_taskstatus_info.get();
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          cmd0x7b4.TaskStatusInfo localTaskStatusInfo = (cmd0x7b4.TaskStatusInfo)((Iterator)localObject).next();
          long l = localTaskStatusInfo.uint64_task_id.get();
          int i = localTaskStatusInfo.uint32_status.get();
          localPOIInfo.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(l), Integer.valueOf(i));
        }
      }
      localArrayList.add(localPOIInfo);
    }
    return localArrayList;
  }
  
  public void a(double paramDouble1, double paramDouble2, int paramInt, String paramString, long paramLong, JNIPOIRequestParam paramJNIPOIRequestParam)
  {
    cmd0x7b4.ReqBody localReqBody;
    boolean bool1;
    cmd0x7b4.LBSSig localLBSSig;
    MqqLbs.LBSCheckInfo localLBSCheckInfo;
    if (QLog.isColorLevel())
    {
      QLog.d("ArMapHandler", 2, "getPOIList, longitude = " + paramDouble1 + ",latitude = " + paramDouble2 + ",busiID = " + paramInt + ",cookie = " + paramString + ",adCode = " + this.jdField_a_of_type_Long);
      ArMapUtil.a("get poi list req 0x7b4...");
      localReqBody = new cmd0x7b4.ReqBody();
      localReqBody.int32_lon.set((int)ArMapUtil.a(paramDouble1, 1000000.0D));
      localReqBody.int32_lat.set((int)ArMapUtil.a(paramDouble2, 1000000.0D));
      if (this.jdField_a_of_type_Long > 0L) {
        localReqBody.uint64_adcode.set(this.jdField_a_of_type_Long);
      }
      localReqBody.uint32_app_id.set(paramInt);
      if (paramJNIPOIRequestParam == null) {
        break label1545;
      }
      localReqBody.uint32_req_occasion.set(paramJNIPOIRequestParam.req_occasion);
      paramString = null;
      if (!TextUtils.isEmpty(paramJNIPOIRequestParam.cookie)) {
        paramString = paramJNIPOIRequestParam.cookie.getBytes();
      }
      if (paramString != null) {
        localReqBody.bytes_cookie.set(ByteStringMicro.copyFrom(paramString));
      }
      if ((!TextUtils.isEmpty(paramJNIPOIRequestParam.lbsSig_verifyKey)) || (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))) {
        break label1539;
      }
      paramJNIPOIRequestParam.lbsSig_verifyKey = this.jdField_b_of_type_JavaLangString;
      paramJNIPOIRequestParam.lbsSig_lon = this.jdField_a_of_type_Double;
      paramJNIPOIRequestParam.lbsSig_lat = this.jdField_b_of_type_Double;
      paramJNIPOIRequestParam.lbsSig_locationTime = this.jdField_c_of_type_Double;
      paramJNIPOIRequestParam.accuracy = this.jdField_a_of_type_Int;
      bool1 = true;
      localLBSSig = new cmd0x7b4.LBSSig();
      localLBSSig.int32_lon.set((int)ArMapUtil.a(paramJNIPOIRequestParam.lbsSig_lon, 1000000.0D));
      localLBSSig.int32_lat.set((int)ArMapUtil.a(paramJNIPOIRequestParam.lbsSig_lat, 1000000.0D));
      localLBSSig.uint32_time.set((int)(paramJNIPOIRequestParam.lbsSig_locationTime / 1000.0D));
      localLBSCheckInfo = null;
      if (TextUtils.isEmpty(paramJNIPOIRequestParam.lbsSig_verifyKey)) {
        break label669;
      }
      paramString = paramJNIPOIRequestParam.lbsSig_verifyKey.getBytes();
    }
    Object localObject2;
    Object localObject3;
    for (;;)
    {
      if (paramString != null) {
        localLBSSig.bytes_verify_key.set(ByteStringMicro.copyFrom(paramString));
      }
      localReqBody.msg_lbs_sig.set(localLBSSig);
      localLBSCheckInfo = new MqqLbs.LBSCheckInfo();
      localLBSCheckInfo.uint32_fake_period.set(paramJNIPOIRequestParam.fakePeriod);
      localLBSCheckInfo.uint32_fake_times.set(paramJNIPOIRequestParam.fakeTimes);
      if (QLog.isColorLevel()) {
        QLog.d("ArMapHandler", 2, "getPOIList jniParam.fakePeriod:" + paramJNIPOIRequestParam.fakePeriod + ",jniParam.fakeTimes :" + paramJNIPOIRequestParam.fakeTimes);
      }
      if ((paramJNIPOIRequestParam.fakeReason == null) || (paramJNIPOIRequestParam.fakeReason.size() <= 0)) {
        break label705;
      }
      paramString = new ArrayList();
      localObject1 = paramJNIPOIRequestParam.fakeReason.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        localObject3 = new MqqLbs.LBSFakeInfo();
        ((MqqLbs.LBSFakeInfo)localObject3).uint32_fake_type.set(((Integer)((Map.Entry)localObject2).getKey()).intValue());
        ((MqqLbs.LBSFakeInfo)localObject3).uint32_fake_times.set(((Integer)((Map.Entry)localObject2).getValue()).intValue());
        paramString.add(localObject3);
      }
      QLog.d("ArMapHandler", 1, "getPOIList, longitude = " + paramDouble1 + ",latitude = " + paramDouble2 + ",adCode = " + this.jdField_a_of_type_Long);
      break;
      label669:
      paramString = localLBSCheckInfo;
      if (QLog.isColorLevel())
      {
        QLog.d("ArMapHandler", 2, "getPOIList ------v--- lbsSig_verifyKey is null ");
        paramString = localLBSCheckInfo;
      }
    }
    localLBSCheckInfo.rpt_msg_lbs_fake_info.set(paramString);
    label705:
    Object localObject1 = ((ARMapManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(209)).a(false);
    if ((localObject1 != null) && (((ARMapConfig)localObject1).cheatApps != null) && (((ARMapConfig)localObject1).cheatApps.size() > 0))
    {
      paramString = new ArrayList();
      localObject1 = ((ARMapConfig)localObject1).cheatApps.iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        boolean bool2 = ArMapUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), (String)localObject2);
        boolean bool3 = ArMapUtil.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), (String)localObject2);
        PBUInt32Field localPBUInt32Field;
        if (bool2)
        {
          localObject3 = new MqqLbs.CheatApp();
          ((MqqLbs.CheatApp)localObject3).bytes_app_name.set(ByteStringMicro.copyFrom(((String)localObject2).getBytes()));
          localPBUInt32Field = ((MqqLbs.CheatApp)localObject3).uint32_run_status;
          if (!bool3) {
            break label941;
          }
        }
        label941:
        for (paramInt = 1;; paramInt = 0)
        {
          localPBUInt32Field.set(paramInt);
          paramString.add(localObject3);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("ArMapHandler", 2, "getPOIList cheatApp:" + (String)localObject2 + ",isInstalled :" + bool2 + ",isRunning :" + bool3);
          break;
        }
      }
      localLBSCheckInfo.rpt_msg_cheat_app.set(paramString);
    }
    paramString = localLBSCheckInfo.uint32_root_jailbreak;
    if (DataReport.a())
    {
      paramInt = 1;
      label973:
      paramString.set(paramInt);
      localReqBody.msg_lbs_check_info.set(localLBSCheckInfo);
      localReqBody.uint32_lbs_accuracy.set(paramJNIPOIRequestParam.accuracy);
      paramString = null;
      if (!TextUtils.isEmpty(paramJNIPOIRequestParam.encrypt_sig)) {
        paramString = paramJNIPOIRequestParam.encrypt_sig.getBytes();
      }
      if (paramString != null) {
        localReqBody.bytes_encrypt_sig.set(ByteStringMicro.copyFrom(paramString));
      }
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("lbsSig{lat:").append(localLBSSig.int32_lat.get()).append(", lng:").append(localLBSSig.int32_lon.get()).append(", verify_key:").append(paramJNIPOIRequestParam.lbsSig_verifyKey).append(", time:").append(localLBSSig.uint32_time.get()).append("} ").append(", check_info:{fake_period:").append(localLBSCheckInfo.uint32_fake_period.get()).append(", fake_times:").append(localLBSCheckInfo.uint32_fake_times.get()).append(", fake_info.size=").append(localLBSCheckInfo.rpt_msg_lbs_fake_info.get().size()).append(", cheat_app.size=").append(localLBSCheckInfo.rpt_msg_cheat_app.get().size()).append("} lbs_accuracy:").append(localReqBody.uint32_lbs_accuracy.get()).append(", uint32_req_occasion:").append(localReqBody.uint32_req_occasion.get()).append(", bytes_cookie:").append(paramJNIPOIRequestParam.cookie).append(", bytes_encrypt_sig:").append(localReqBody.bytes_encrypt_sig.get());
        QLog.d("ArMapHandler", 2, "getPOIList ------v--- params = " + paramString.toString());
        QLog.d("ArMapHandler", 2, "getPOIList cache jniparm & lbs checkinfo for openPoi");
      }
      this.jdField_a_of_type_ComTencentMobileqqArmapJNIPOIRequestParam = paramJNIPOIRequestParam;
      this.jdField_a_of_type_TencentImOidbOlympicMqqLbs$LBSCheckInfo = localLBSCheckInfo;
    }
    for (;;)
    {
      paramString = a("OidbSvc.0x7b4", 1972, 0, localReqBody.toByteArray());
      paramString.extraData.putLong("poi_req_native_handle", paramLong);
      if (paramJNIPOIRequestParam != null) {
        paramString.extraData.putLong("poi_req_nativeGLSurfaceViewContext", paramJNIPOIRequestParam.nativeGLSurfaceViewContext);
      }
      if (paramJNIPOIRequestParam != null)
      {
        paramString.extraData.putString("lbsSig_verifyKey", paramJNIPOIRequestParam.lbsSig_verifyKey);
        paramString.extraData.putString("lbsSig_lon", String.valueOf(paramJNIPOIRequestParam.lbsSig_lon));
        paramString.extraData.putString("lbsSig_lat", String.valueOf(paramJNIPOIRequestParam.lbsSig_lat));
        paramString.extraData.putString("lbsSig_locationTime", String.valueOf(paramJNIPOIRequestParam.lbsSig_locationTime));
        paramString.extraData.putString("accuracy", String.valueOf(paramJNIPOIRequestParam.accuracy));
        paramString.extraData.putString("req_occasion", String.valueOf(paramJNIPOIRequestParam.req_occasion));
        paramString.extraData.putString("imei", DeviceInfoUtil.a());
        paramString.extraData.putString("useJavaCache", String.valueOf(bool1));
      }
      b(paramString);
      return;
      paramInt = 0;
      break label973;
      label1539:
      bool1 = false;
      break;
      label1545:
      bool1 = false;
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArMapHandler", 2, "reqActRedDotInfo,uin :" + paramLong1 + ",actID :" + paramLong2);
    }
    Object localObject = new cmd0x95a.GetArActivityRedReq();
    ((cmd0x95a.GetArActivityRedReq)localObject).uint64_uin.set(paramLong1);
    ((cmd0x95a.GetArActivityRedReq)localObject).uint64_client_activity_id.set(paramLong2);
    cmd0x95a.ReqBody localReqBody = new cmd0x95a.ReqBody();
    localReqBody.msg_get_ar_activity_red_req.set((MessageMicro)localObject);
    localObject = a("OidbSvc.0x95a", 2394, 5, localReqBody.toByteArray());
    ((ToServiceMsg)localObject).extraData.putInt("subcmd", 5);
    b((ToServiceMsg)localObject);
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArMapHandler", 2, "reqOpenPoi, taskId:" + paramLong1 + ", poiId:" + paramLong2 + ", mode: " + paramInt1 + ", businessType:" + paramInt2 + ", distance:" + paramInt3);
    }
    oidb_0x7bb.OpenPoiReq localOpenPoiReq = new oidb_0x7bb.OpenPoiReq();
    localOpenPoiReq.mode.set(paramInt1);
    localOpenPoiReq.task_id.set(paramLong1);
    localOpenPoiReq.poi_id.set(paramLong2);
    oidb_0x7bb.LBSSig localLBSSig;
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqArmapJNIPOIRequestParam != null)
    {
      localLBSSig = new oidb_0x7bb.LBSSig();
      localLBSSig.int32_lon.set((int)ArMapUtil.a(this.jdField_a_of_type_ComTencentMobileqqArmapJNIPOIRequestParam.lbsSig_lon, 1000000.0D));
      localLBSSig.int32_lat.set((int)ArMapUtil.a(this.jdField_a_of_type_ComTencentMobileqqArmapJNIPOIRequestParam.lbsSig_lat, 1000000.0D));
      localLBSSig.uint64_time.set((int)(this.jdField_a_of_type_ComTencentMobileqqArmapJNIPOIRequestParam.lbsSig_locationTime / 1000.0D));
      localObject = null;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqArmapJNIPOIRequestParam.lbsSig_verifyKey)) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqArmapJNIPOIRequestParam.lbsSig_verifyKey.getBytes();
      }
      if (localObject != null) {
        localLBSSig.bytes_verify_key.set(ByteStringMicro.copyFrom((byte[])localObject));
      }
      localOpenPoiReq.msg_lbs_sig.set(localLBSSig);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("lbsSig{lat:").append(localLBSSig.int32_lat.get()).append(", lng:").append(localLBSSig.int32_lon.get()).append(", verify_key:").append(this.jdField_a_of_type_ComTencentMobileqqArmapJNIPOIRequestParam.lbsSig_verifyKey).append(", time:").append(localLBSSig.uint64_time.get()).append("} ").append(", check_info:{fake_period:").append(this.jdField_a_of_type_TencentImOidbOlympicMqqLbs$LBSCheckInfo.uint32_fake_period.get()).append(", fake_times:").append(this.jdField_a_of_type_TencentImOidbOlympicMqqLbs$LBSCheckInfo.uint32_fake_times.get()).append(", fake_info.size=").append(this.jdField_a_of_type_TencentImOidbOlympicMqqLbs$LBSCheckInfo.rpt_msg_lbs_fake_info.get().size()).append(", cheat_app.size=").append(this.jdField_a_of_type_TencentImOidbOlympicMqqLbs$LBSCheckInfo.rpt_msg_cheat_app.get().size());
        QLog.d("ArMapHandler", 2, "reqOpenPoi has params, ----------- params = " + ((StringBuilder)localObject).toString());
      }
    }
    for (;;)
    {
      localObject = new oidb_0x7bb.ReqBody();
      ((oidb_0x7bb.ReqBody)localObject).open_poi_req.set(localOpenPoiReq);
      localObject = a("OidbSvc.0x7bb", 1979, 1, ((oidb_0x7bb.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).addAttribute("subCmd", Integer.valueOf(1));
      ((ToServiceMsg)localObject).addAttribute("businessType", String.valueOf(paramInt2));
      ((ToServiceMsg)localObject).addAttribute("distance", String.valueOf(paramInt3));
      ((ToServiceMsg)localObject).addAttribute("mode", String.valueOf(paramInt1));
      b((ToServiceMsg)localObject);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ArMapHandler", 2, "reqOpenPoi cacheJniParam is null, use stored lbs sig");
      }
      localLBSSig = new oidb_0x7bb.LBSSig();
      localLBSSig.int32_lon.set((int)ArMapUtil.a(this.jdField_a_of_type_Double, 1000000.0D));
      localLBSSig.int32_lat.set((int)ArMapUtil.a(this.jdField_b_of_type_Double, 1000000.0D));
      localLBSSig.uint64_time.set((int)(this.jdField_c_of_type_Double / 1000.0D));
      localObject = null;
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        localObject = this.jdField_b_of_type_JavaLangString.getBytes();
      }
      if (localObject != null) {
        localLBSSig.bytes_verify_key.set(ByteStringMicro.copyFrom((byte[])localObject));
      }
      localOpenPoiReq.msg_lbs_sig.set(localLBSSig);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("lbsSig{lat:").append(localLBSSig.int32_lat.get()).append(", lng:").append(localLBSSig.int32_lon.get()).append(", verify_key:").append(this.jdField_b_of_type_JavaLangString).append(", time:").append(localLBSSig.uint64_time.get()).append("}");
        QLog.d("ArMapHandler", 2, "reqOpenPoi has params, ----------- params = " + ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void a(long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    oidb_0x7bb.QueryPoiReq localQueryPoiReq = new oidb_0x7bb.QueryPoiReq();
    localQueryPoiReq.task_id.set(paramLong1);
    localQueryPoiReq.poi_id.set(paramLong2);
    if (paramArrayOfByte != null) {
      localQueryPoiReq.map_sig.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    }
    paramArrayOfByte = new oidb_0x7bb.ReqBody();
    paramArrayOfByte.query_poi_req.set(localQueryPoiReq);
    paramArrayOfByte = a("OidbSvc.0x7bb", 1979, 2, paramArrayOfByte.toByteArray());
    paramArrayOfByte.addAttribute("subCmd", Integer.valueOf(2));
    paramArrayOfByte.addAttribute("poiId", Long.valueOf(paramLong2));
    b(paramArrayOfByte);
  }
  
  public void a(long paramLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArMapHandler", 2, "reqReport id: " + paramLong + ", json: " + paramString);
    }
    Object localObject = new oidb_0x7bb.ReportInfo();
    ((oidb_0x7bb.ReportInfo)localObject).id.set(paramLong);
    ((oidb_0x7bb.ReportInfo)localObject).value.set(ByteStringMicro.copyFrom(paramString.getBytes()));
    paramString = new oidb_0x7bb.ReportReq();
    paramString.infos.add((MessageMicro)localObject);
    localObject = new oidb_0x7bb.ReqBody();
    ((oidb_0x7bb.ReqBody)localObject).report_req.set(paramString);
    paramString = a("OidbSvc.0x7bb", 1979, 9, ((oidb_0x7bb.ReqBody)localObject).toByteArray());
    paramString.addAttribute("subCmd", Integer.valueOf(9));
    b(paramString);
  }
  
  public void a(long paramLong, boolean paramBoolean, int paramInt, List paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArMapHandler", 2, "reqWealthGodInfo,adcode :" + paramLong + ",needEmptyTasks :" + paramBoolean + ",status :" + paramInt);
    }
    if (paramInt == 1) {
      ArMapUtil.a("msgtab req 0x8c4...");
    }
    for (;;)
    {
      oidb_0x84c.QueryCountReq localQueryCountReq = new oidb_0x84c.QueryCountReq();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Long.valueOf(paramLong));
      localQueryCountReq.adcodes.set(localArrayList);
      localQueryCountReq.want_empty.set(paramBoolean);
      localQueryCountReq.status.set(paramInt);
      if (paramList != null) {
        localQueryCountReq.check_task_ids.set(paramList);
      }
      paramList = new oidb_0x84c.ReqBody();
      paramList.query_count_req.set(localQueryCountReq);
      paramList = a("OidbSvc.0x84c", 2124, 4, paramList.toByteArray());
      paramList.extraData.putInt("subcmd", 4);
      paramList.extraData.putInt("status", paramInt);
      b(paramList);
      return;
      ArMapUtil.a("armap req 0x8c4...");
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    String str;
    do
    {
      long l;
      do
      {
        do
        {
          return;
          str = paramFromServiceMsg.getServiceCmd();
          if (!a(str)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("ArMapHandler", 2, "onReceive, msgCmdFilter is true,cmd  = " + str);
        return;
        if (!"OidbSvc.0x7b4".equals(str)) {
          break;
        }
        l = System.currentTimeMillis();
        e(paramToServiceMsg, paramFromServiceMsg, paramObject);
      } while (!QLog.isColorLevel());
      QLog.d("ArMapHandler", 2, "onReceive, handleGetPOIList in java, need time = " + (System.currentTimeMillis() - l));
      return;
      if ("OidbSvc.0x7bb".equals(str))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x84c".equals(str))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.0x95a".equals(str));
    c(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, boolean paramBoolean, int paramInt, oidb_0x84c.QueryCountRsp paramQueryCountRsp)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramToServiceMsg.extraData.getInt("status");
    long l;
    label87:
    label107:
    boolean bool1;
    label128:
    label149:
    boolean bool2;
    label170:
    boolean bool3;
    if ((paramBoolean) && (paramInt == 0) && (paramQueryCountRsp != null))
    {
      if (!paramQueryCountRsp.infos.has()) {
        break label525;
      }
      int i;
      List localList;
      if (paramQueryCountRsp.interval.has())
      {
        l = paramQueryCountRsp.interval.get();
        if (!paramQueryCountRsp.empty_task_ids.has()) {
          break label272;
        }
        paramToServiceMsg = paramQueryCountRsp.empty_task_ids.get();
        if (!paramQueryCountRsp.admission.has()) {
          break label277;
        }
        paramInt = paramQueryCountRsp.admission.get();
        if (!paramQueryCountRsp.countdown.has()) {
          break label282;
        }
        i = paramQueryCountRsp.countdown.get();
        if (!paramQueryCountRsp.display_led.has()) {
          break label288;
        }
        bool1 = paramQueryCountRsp.display_led.get();
        if (!paramQueryCountRsp.display_pendant.has()) {
          break label294;
        }
        bool2 = paramQueryCountRsp.display_pendant.get();
        localList = paramQueryCountRsp.infos.get();
        if (!paramQueryCountRsp.display_cloud.has()) {
          break label300;
        }
      }
      label272:
      label277:
      label282:
      label288:
      label294:
      label300:
      for (bool3 = paramQueryCountRsp.display_cloud.get();; bool3 = false)
      {
        if ((localList == null) || (localList.isEmpty())) {
          break label306;
        }
        paramQueryCountRsp = localList.iterator();
        while (paramQueryCountRsp.hasNext()) {
          localArrayList.add(new WealthGodInfo((oidb_0x84c.CAdcodeInfo)paramQueryCountRsp.next(), paramInt, i));
        }
        l = 0L;
        break;
        paramToServiceMsg = null;
        break label87;
        paramInt = 0;
        break label107;
        i = 0;
        break label128;
        bool1 = false;
        break label149;
        bool2 = false;
        break label170;
      }
    }
    for (;;)
    {
      label306:
      paramQueryCountRsp = new ArMapHandler.RespWealthGodInfo();
      paramQueryCountRsp.jdField_a_of_type_JavaUtilList = localArrayList;
      paramQueryCountRsp.jdField_a_of_type_Long = l;
      paramQueryCountRsp.jdField_b_of_type_JavaUtilList = paramToServiceMsg;
      paramQueryCountRsp.jdField_a_of_type_Int = j;
      paramQueryCountRsp.jdField_a_of_type_Boolean = bool3;
      paramQueryCountRsp.jdField_b_of_type_Boolean = bool1;
      paramQueryCountRsp.c = bool2;
      a(18, paramBoolean, paramQueryCountRsp);
      if (QLog.isColorLevel()) {
        QLog.d("ArMapHandler", 2, "handleReqWealthGodInfo:" + localArrayList + ",interval:" + l + ",emptyTaskid:" + paramToServiceMsg + ",status:" + j + ",displayLED:" + bool1 + ",displayPendant:" + bool2 + "  displayCloud:" + bool3);
      }
      return;
      paramToServiceMsg = new HashMap();
      paramToServiceMsg.put("result", String.valueOf(paramInt));
      paramToServiceMsg.put("status", String.valueOf(j));
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actARMapReqWealthGodInfoFailed", false, 0L, 0L, paramToServiceMsg, "", false);
      label525:
      bool3 = false;
      bool2 = false;
      bool1 = false;
      paramToServiceMsg = null;
      l = 0L;
    }
  }
  
  void a(ToServiceMsg paramToServiceMsg, boolean paramBoolean, int paramInt, cmd0x95a.RspBody paramRspBody)
  {
    long l2 = 0L;
    long l1;
    if ((paramBoolean) && (paramInt == 0) && (paramRspBody != null))
    {
      if (!paramRspBody.msg_get_ar_activity_red_rsp.has()) {
        break label180;
      }
      paramToServiceMsg = (cmd0x95a.GetArActivityRedRsp)paramRspBody.msg_get_ar_activity_red_rsp.get();
      if (paramToServiceMsg != null)
      {
        if (!paramToServiceMsg.uint64_uin.has()) {
          break label185;
        }
        l1 = paramToServiceMsg.uint64_uin.get();
        label62:
        if (!paramToServiceMsg.uint32_red_switch.has()) {
          break label191;
        }
      }
    }
    label180:
    label185:
    label191:
    for (paramInt = paramToServiceMsg.uint32_red_switch.get();; paramInt = 0)
    {
      if (paramToServiceMsg.uint64_server_activity_id.has()) {
        l2 = paramToServiceMsg.uint64_server_activity_id.get();
      }
      if (QLog.isColorLevel()) {
        QLog.d("ArMapHandler", 2, "handleGetARActRedDotInfo uin:" + l1 + ",redSwitch:" + paramInt + ",actId:" + l2);
      }
      a(20, paramBoolean, new Object[] { Integer.valueOf(paramInt), Long.valueOf(l2) });
      return;
      paramToServiceMsg = null;
      break;
      l1 = 0L;
      break label62;
    }
  }
  
  public void a(String paramString1, double paramDouble1, double paramDouble2, double paramDouble3, int paramInt1, String paramString2, int paramInt2)
  {
    this.jdField_b_of_type_Double = paramDouble2;
    this.jdField_a_of_type_Double = paramDouble1;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_c_of_type_Double = paramDouble3;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_c_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public void a(String paramString, double paramDouble1, double paramDouble2, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArMapHandler", 2, "reqOpenPoi, picId: " + paramString + ", longitude: " + paramDouble1 + ", latitude: " + paramDouble2 + ", mode: " + paramInt1 + ", businessType:" + paramInt2 + ", distance:" + paramInt3);
    }
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("ArMapHandler", 1, "reqOpenPoi picId is empty!");
      return;
    }
    oidb_0x7bb.OpenPoiReq localOpenPoiReq = new oidb_0x7bb.OpenPoiReq();
    localOpenPoiReq.mode.set(paramInt1);
    localOpenPoiReq.pic_id.set(ByteStringMicro.copyFrom(paramString.getBytes()));
    localOpenPoiReq.lng.set((int)ArMapUtil.a(paramDouble1, 1000000.0D));
    localOpenPoiReq.lat.set((int)ArMapUtil.a(paramDouble2, 1000000.0D));
    oidb_0x7bb.LBSSig localLBSSig;
    if (this.jdField_a_of_type_ComTencentMobileqqArmapJNIPOIRequestParam != null)
    {
      localLBSSig = new oidb_0x7bb.LBSSig();
      localLBSSig.int32_lon.set((int)ArMapUtil.a(this.jdField_a_of_type_ComTencentMobileqqArmapJNIPOIRequestParam.lbsSig_lon, 1000000.0D));
      localLBSSig.int32_lat.set((int)ArMapUtil.a(this.jdField_a_of_type_ComTencentMobileqqArmapJNIPOIRequestParam.lbsSig_lat, 1000000.0D));
      localLBSSig.uint64_time.set((int)(this.jdField_a_of_type_ComTencentMobileqqArmapJNIPOIRequestParam.lbsSig_locationTime / 1000.0D));
      paramString = null;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqArmapJNIPOIRequestParam.lbsSig_verifyKey)) {
        paramString = this.jdField_a_of_type_ComTencentMobileqqArmapJNIPOIRequestParam.lbsSig_verifyKey.getBytes();
      }
      if (paramString != null) {
        localLBSSig.bytes_verify_key.set(ByteStringMicro.copyFrom(paramString));
      }
      localOpenPoiReq.msg_lbs_sig.set(localLBSSig);
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("lbsSig{lat:").append(localLBSSig.int32_lat.get()).append(", lng:").append(localLBSSig.int32_lon.get()).append(", verify_key:").append(this.jdField_a_of_type_ComTencentMobileqqArmapJNIPOIRequestParam.lbsSig_verifyKey).append(", time:").append(localLBSSig.uint64_time.get()).append("} ").append(", check_info:{fake_period:").append(this.jdField_a_of_type_TencentImOidbOlympicMqqLbs$LBSCheckInfo.uint32_fake_period.get()).append(", fake_times:").append(this.jdField_a_of_type_TencentImOidbOlympicMqqLbs$LBSCheckInfo.uint32_fake_times.get()).append(", fake_info.size=").append(this.jdField_a_of_type_TencentImOidbOlympicMqqLbs$LBSCheckInfo.rpt_msg_lbs_fake_info.get().size()).append(", cheat_app.size=").append(this.jdField_a_of_type_TencentImOidbOlympicMqqLbs$LBSCheckInfo.rpt_msg_cheat_app.get().size());
        QLog.d("ArMapHandler", 2, "reqOpenPoi has params, ----------- params = " + paramString.toString());
      }
    }
    for (;;)
    {
      paramString = new oidb_0x7bb.ReqBody();
      paramString.open_poi_req.set(localOpenPoiReq);
      paramString = a("OidbSvc.0x7bb", 1979, 1, paramString.toByteArray());
      paramString.addAttribute("subCmd", Integer.valueOf(1));
      paramString.addAttribute("businessType", String.valueOf(paramInt2));
      paramString.addAttribute("distance", String.valueOf(paramInt3));
      paramString.addAttribute("mode", String.valueOf(paramInt1));
      b(paramString);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ArMapHandler", 2, "reqOpenPoi cacheJniParam is null, use stored lbs sig");
      }
      localLBSSig = new oidb_0x7bb.LBSSig();
      localLBSSig.int32_lon.set((int)ArMapUtil.a(this.jdField_a_of_type_Double, 1000000.0D));
      localLBSSig.int32_lat.set((int)ArMapUtil.a(this.jdField_b_of_type_Double, 1000000.0D));
      localLBSSig.uint64_time.set((int)(this.jdField_c_of_type_Double / 1000.0D));
      paramString = null;
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        paramString = this.jdField_b_of_type_JavaLangString.getBytes();
      }
      if (paramString != null) {
        localLBSSig.bytes_verify_key.set(ByteStringMicro.copyFrom(paramString));
      }
      localOpenPoiReq.msg_lbs_sig.set(localLBSSig);
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("lbsSig{lat:").append(localLBSSig.int32_lat.get()).append(", lng:").append(localLBSSig.int32_lon.get()).append(", verify_key:").append(this.jdField_b_of_type_JavaLangString).append(", time:").append(localLBSSig.uint64_time.get()).append("}");
        QLog.d("ArMapHandler", 2, "reqOpenPoi has params, ----------- params = " + paramString.toString());
      }
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    cmd0x95a.SetWorldCupInfoReq localSetWorldCupInfoReq = new cmd0x95a.SetWorldCupInfoReq();
    cmd0x95a.WorldCupInfo localWorldCupInfo = new cmd0x95a.WorldCupInfo();
    localWorldCupInfo.str_nick.set(paramString1);
    if (paramString2 != null) {
      localWorldCupInfo.str_video_url.set(paramString2);
    }
    localWorldCupInfo.str_config.set(paramString3);
    localSetWorldCupInfoReq.msg_worldcup_info.set(localWorldCupInfo);
    paramString1 = new cmd0x95a.ReqBody();
    paramString1.msg_set_world_cup_info_req.set(localSetWorldCupInfoReq);
    paramString1 = a("OidbSvc.0x95a", 2394, 102, paramString1.toByteArray());
    paramString1.extraData.putInt("subcmd", 102);
    b(paramString1);
  }
  
  void a(ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    if ((paramArrayList1 == null) || (paramArrayList1.size() == 0)) {}
    do
    {
      do
      {
        return;
      } while ((paramArrayList2 == null) || (paramArrayList2.size() == 0));
      Iterator localIterator1 = paramArrayList2.iterator();
      while (localIterator1.hasNext())
      {
        POIInfo localPOIInfo = (POIInfo)localIterator1.next();
        localPOIInfo.jdField_a_of_type_JavaUtilArrayList.clear();
        if ((localPOIInfo.jdField_a_of_type_JavaUtilHashMap != null) && (localPOIInfo.jdField_a_of_type_JavaUtilHashMap.size() > 0))
        {
          Iterator localIterator2 = paramArrayList1.iterator();
          while (localIterator2.hasNext())
          {
            POITaskInfo localPOITaskInfo = (POITaskInfo)localIterator2.next();
            if (localPOIInfo.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(localPOITaskInfo.jdField_a_of_type_Long))) {
              localPOIInfo.jdField_a_of_type_JavaUtilArrayList.add(localPOITaskInfo);
            }
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("ArMapHandler", 2, "assignTaskInfo2POI task.size=" + paramArrayList1.size() + ", poilist.size=" + paramArrayList2.size());
  }
  
  /* Error */
  void a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: invokestatic 1210	com/tencent/mobileqq/armap/map/MapEngineCallback:getRootPath	()Ljava/lang/String;
    //   8: astore_2
    //   9: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12: ifeq +12 -> 24
    //   15: ldc 106
    //   17: iconst_2
    //   18: ldc_w 1212
    //   21: invokestatic 147	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   24: new 1214	java/io/File
    //   27: dup
    //   28: aload_2
    //   29: invokespecial 1216	java/io/File:<init>	(Ljava/lang/String;)V
    //   32: astore 5
    //   34: aload 5
    //   36: invokevirtual 1219	java/io/File:exists	()Z
    //   39: ifne +17 -> 56
    //   42: aload 5
    //   44: invokevirtual 1222	java/io/File:isDirectory	()Z
    //   47: ifeq +9 -> 56
    //   50: aload 5
    //   52: invokevirtual 1225	java/io/File:mkdirs	()Z
    //   55: pop
    //   56: new 1214	java/io/File
    //   59: dup
    //   60: new 108	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   67: aload_2
    //   68: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: ldc_w 1227
    //   74: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokespecial 1216	java/io/File:<init>	(Ljava/lang/String;)V
    //   83: astore_2
    //   84: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   87: ifeq +32 -> 119
    //   90: ldc 106
    //   92: iconst_2
    //   93: new 108	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   100: ldc_w 1229
    //   103: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: aload_2
    //   107: invokevirtual 1232	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   110: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: invokestatic 147	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   119: new 1234	java/io/FileOutputStream
    //   122: dup
    //   123: aload_2
    //   124: invokespecial 1237	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   127: astore_2
    //   128: new 1239	java/io/BufferedOutputStream
    //   131: dup
    //   132: aload_2
    //   133: invokespecial 1242	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   136: astore_3
    //   137: aload_3
    //   138: aload_1
    //   139: invokevirtual 1245	java/io/BufferedOutputStream:write	([B)V
    //   142: aload_3
    //   143: ifnull +7 -> 150
    //   146: aload_3
    //   147: invokevirtual 1248	java/io/BufferedOutputStream:close	()V
    //   150: aload_2
    //   151: ifnull +7 -> 158
    //   154: aload_2
    //   155: invokevirtual 1249	java/io/FileOutputStream:close	()V
    //   158: return
    //   159: astore_1
    //   160: aload_1
    //   161: invokevirtual 1250	java/io/IOException:printStackTrace	()V
    //   164: goto -14 -> 150
    //   167: astore_1
    //   168: aload_1
    //   169: invokevirtual 1250	java/io/IOException:printStackTrace	()V
    //   172: return
    //   173: astore 4
    //   175: aconst_null
    //   176: astore_1
    //   177: aload_3
    //   178: astore_2
    //   179: aload 4
    //   181: astore_3
    //   182: aload_3
    //   183: invokevirtual 350	java/lang/Exception:printStackTrace	()V
    //   186: aload_1
    //   187: ifnull +7 -> 194
    //   190: aload_1
    //   191: invokevirtual 1248	java/io/BufferedOutputStream:close	()V
    //   194: aload_2
    //   195: ifnull -37 -> 158
    //   198: aload_2
    //   199: invokevirtual 1249	java/io/FileOutputStream:close	()V
    //   202: return
    //   203: astore_1
    //   204: aload_1
    //   205: invokevirtual 1250	java/io/IOException:printStackTrace	()V
    //   208: return
    //   209: astore_1
    //   210: aload_1
    //   211: invokevirtual 1250	java/io/IOException:printStackTrace	()V
    //   214: goto -20 -> 194
    //   217: astore_1
    //   218: aconst_null
    //   219: astore_3
    //   220: aload 4
    //   222: astore_2
    //   223: aload_3
    //   224: ifnull +7 -> 231
    //   227: aload_3
    //   228: invokevirtual 1248	java/io/BufferedOutputStream:close	()V
    //   231: aload_2
    //   232: ifnull +7 -> 239
    //   235: aload_2
    //   236: invokevirtual 1249	java/io/FileOutputStream:close	()V
    //   239: aload_1
    //   240: athrow
    //   241: astore_3
    //   242: aload_3
    //   243: invokevirtual 1250	java/io/IOException:printStackTrace	()V
    //   246: goto -15 -> 231
    //   249: astore_2
    //   250: aload_2
    //   251: invokevirtual 1250	java/io/IOException:printStackTrace	()V
    //   254: goto -15 -> 239
    //   257: astore_1
    //   258: aconst_null
    //   259: astore_3
    //   260: goto -37 -> 223
    //   263: astore_1
    //   264: goto -41 -> 223
    //   267: astore 4
    //   269: aload_1
    //   270: astore_3
    //   271: aload 4
    //   273: astore_1
    //   274: goto -51 -> 223
    //   277: astore_3
    //   278: aconst_null
    //   279: astore_1
    //   280: goto -98 -> 182
    //   283: astore 4
    //   285: aload_3
    //   286: astore_1
    //   287: aload 4
    //   289: astore_3
    //   290: goto -108 -> 182
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	293	0	this	ArMapHandler
    //   0	293	1	paramArrayOfByte	byte[]
    //   8	228	2	localObject1	Object
    //   249	2	2	localIOException1	java.io.IOException
    //   4	224	3	localObject2	Object
    //   241	2	3	localIOException2	java.io.IOException
    //   259	12	3	arrayOfByte	byte[]
    //   277	9	3	localException1	Exception
    //   289	1	3	localException2	Exception
    //   1	1	4	localObject3	Object
    //   173	48	4	localException3	Exception
    //   267	5	4	localObject4	Object
    //   283	5	4	localException4	Exception
    //   32	19	5	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   146	150	159	java/io/IOException
    //   154	158	167	java/io/IOException
    //   24	56	173	java/lang/Exception
    //   56	119	173	java/lang/Exception
    //   119	128	173	java/lang/Exception
    //   198	202	203	java/io/IOException
    //   190	194	209	java/io/IOException
    //   24	56	217	finally
    //   56	119	217	finally
    //   119	128	217	finally
    //   227	231	241	java/io/IOException
    //   235	239	249	java/io/IOException
    //   128	137	257	finally
    //   137	142	263	finally
    //   182	186	267	finally
    //   128	137	277	java/lang/Exception
    //   137	142	283	java/lang/Exception
  }
  
  protected boolean a(String paramString)
  {
    if (this.jdField_b_of_type_JavaUtilSet == null)
    {
      this.jdField_b_of_type_JavaUtilSet = new HashSet();
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x7b4");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x7bb");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x84c");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x95a");
    }
    return !this.jdField_b_of_type_JavaUtilSet.contains(paramString);
  }
  
  ArrayList b(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArMapHandler", 2, "convertcmd0x7b4_TaskCommonInfo2POITaskInfo list is empty!");
      }
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (cmd0x7b4.TaskCommonInfo)paramList.next();
      long l = ((cmd0x7b4.TaskCommonInfo)localObject).uint64_task_id.get();
      int i = ((cmd0x7b4.TaskCommonInfo)localObject).uint32_priority.get();
      int j = ((cmd0x7b4.TaskCommonInfo)localObject).uint32_treasure_type.get();
      String str1 = ((cmd0x7b4.TaskCommonInfo)localObject).str_logo_url.get();
      int k = ((cmd0x7b4.TaskCommonInfo)localObject).uint32_cooldown.get();
      String str2 = ((cmd0x7b4.TaskCommonInfo)localObject).bytes_animation.get().toStringUtf8();
      String str3 = ((cmd0x7b4.TaskCommonInfo)localObject).bytes_jump_url.get().toStringUtf8();
      String str4 = ((cmd0x7b4.TaskCommonInfo)localObject).bytes_screen_info.get().toStringUtf8();
      String str5 = ((cmd0x7b4.TaskCommonInfo)localObject).bytes_config.get().toStringUtf8();
      int m = ((cmd0x7b4.TaskCommonInfo)localObject).uint32_begtime.get();
      int n = ((cmd0x7b4.TaskCommonInfo)localObject).uint32_endtime.get();
      localObject = new POITaskInfo();
      ((POITaskInfo)localObject).jdField_a_of_type_Long = l;
      ((POITaskInfo)localObject).q = j;
      ((POITaskInfo)localObject).r = i;
      ((POITaskInfo)localObject).jdField_b_of_type_JavaLangString = str1;
      ((POITaskInfo)localObject).d = str2;
      ((POITaskInfo)localObject).f = str4;
      ((POITaskInfo)localObject).e = str3;
      ((POITaskInfo)localObject).jdField_b_of_type_Long = m;
      ((POITaskInfo)localObject).c = n;
      ((POITaskInfo)localObject).u = k;
      ((POITaskInfo)localObject).g = str5;
      if (QLog.isColorLevel()) {
        QLog.d("ArMapHandler", 2, "poiTaskInfo = " + ((POITaskInfo)localObject).toString());
      }
      localArrayList.add(localObject);
    }
    return localArrayList;
  }
  
  public void b()
  {
    Object localObject = new cmd0x95a.JoinWorldCupReq();
    ((cmd0x95a.JoinWorldCupReq)localObject).uint32_t_req_recommend_nick.set(1);
    cmd0x95a.ReqBody localReqBody = new cmd0x95a.ReqBody();
    localReqBody.msg_join_world_cup_req.set((MessageMicro)localObject);
    localObject = a("OidbSvc.0x95a", 2394, 103, localReqBody.toByteArray());
    ((ToServiceMsg)localObject).extraData.putInt("subcmd", 103);
    b((ToServiceMsg)localObject);
  }
  
  protected void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    int j;
    oidb_0x7bb.PageHistoryRsp localPageHistoryRsp;
    Object localObject;
    int i;
    String str;
    oidb_0x7bb.OpenPoiRsp localOpenPoiRsp;
    oidb_0x7bb.QueryPoiRsp localQueryPoiRsp;
    oidb_0x7bb.QueryItemRsp localQueryItemRsp;
    oidb_0x7bb.PageItemRsp localPageItemRsp;
    oidb_0x7bb.ReportRsp localReportRsp;
    if (paramFromServiceMsg == null)
    {
      bool1 = false;
      j = ((Integer)paramToServiceMsg.getAttribute("subCmd", Integer.valueOf(-1))).intValue();
      localPageHistoryRsp = null;
      if (!bool1) {
        break label656;
      }
      localObject = new oidb_0x7bb.RspBody();
      i = a(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
      str = paramFromServiceMsg.getBusinessFailMsg();
      switch (j)
      {
      case 7: 
      default: 
        paramObject = null;
        localOpenPoiRsp = null;
        localQueryPoiRsp = null;
        localQueryItemRsp = null;
        localPageItemRsp = null;
        localReportRsp = null;
        localObject = null;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArMapHandler", 2, "handle0x7bb isSuc: " + bool1 + ", resultCode: " + i + ", subCmd: " + j + ", errMsg: " + str);
      }
      boolean bool2;
      switch (j)
      {
      case 7: 
      default: 
        return;
        bool1 = paramFromServiceMsg.isSuccess();
        break;
        localOpenPoiRsp = (oidb_0x7bb.OpenPoiRsp)((oidb_0x7bb.RspBody)localObject).open_poi_rsp.get();
        localQueryPoiRsp = null;
        localQueryItemRsp = null;
        localPageItemRsp = null;
        localReportRsp = null;
        localObject = null;
        paramObject = null;
        continue;
        localQueryPoiRsp = (oidb_0x7bb.QueryPoiRsp)((oidb_0x7bb.RspBody)localObject).query_poi_rsp.get();
        localQueryItemRsp = null;
        localPageItemRsp = null;
        localReportRsp = null;
        localObject = null;
        localOpenPoiRsp = null;
        paramObject = null;
        continue;
        localQueryItemRsp = (oidb_0x7bb.QueryItemRsp)((oidb_0x7bb.RspBody)localObject).query_item_rsp.get();
        localPageItemRsp = null;
        localReportRsp = null;
        localObject = null;
        localOpenPoiRsp = null;
        localQueryPoiRsp = null;
        paramObject = null;
        continue;
        localPageItemRsp = (oidb_0x7bb.PageItemRsp)((oidb_0x7bb.RspBody)localObject).page_item_rsp.get();
        localReportRsp = null;
        localObject = null;
        localOpenPoiRsp = null;
        localQueryPoiRsp = null;
        localQueryItemRsp = null;
        paramObject = null;
        continue;
        localPageHistoryRsp = (oidb_0x7bb.PageHistoryRsp)((oidb_0x7bb.RspBody)localObject).page_history_rsp.get();
        paramObject = null;
        localObject = null;
        localOpenPoiRsp = null;
        localQueryPoiRsp = null;
        localQueryItemRsp = null;
        localPageItemRsp = null;
        localReportRsp = null;
        continue;
        localObject = (oidb_0x7bb.DeductItemRsp)((oidb_0x7bb.RspBody)localObject).deduct_item_rsp.get();
        localOpenPoiRsp = null;
        localQueryPoiRsp = null;
        localQueryItemRsp = null;
        localPageItemRsp = null;
        localReportRsp = null;
        paramObject = null;
        continue;
        paramObject = (oidb_0x7bb.QueryTaskRsp)((oidb_0x7bb.RspBody)localObject).query_task_rsp.get();
        localOpenPoiRsp = null;
        localQueryPoiRsp = null;
        localQueryItemRsp = null;
        localPageItemRsp = null;
        localReportRsp = null;
        localObject = null;
        continue;
        localReportRsp = (oidb_0x7bb.ReportRsp)((oidb_0x7bb.RspBody)localObject).report_rsp.get();
        localObject = null;
        localOpenPoiRsp = null;
        localQueryPoiRsp = null;
        localQueryItemRsp = null;
        localPageItemRsp = null;
        paramObject = null;
        break;
      case 1: 
        if (paramFromServiceMsg == null) {}
        for (bool2 = false;; bool2 = paramFromServiceMsg.isSuccess())
        {
          a(paramToServiceMsg, bool1, i, localOpenPoiRsp, bool2);
          return;
        }
      case 2: 
        a(paramToServiceMsg, bool1, i, localQueryPoiRsp);
        return;
      case 3: 
        a(paramToServiceMsg, bool1, i, localQueryItemRsp);
        return;
      case 4: 
        a(paramToServiceMsg, bool1, i, localPageItemRsp);
        return;
      case 5: 
        a(paramToServiceMsg, bool1, i, localPageHistoryRsp);
        return;
      case 6: 
        a(paramToServiceMsg, bool1, i, (oidb_0x7bb.DeductItemRsp)localObject);
        return;
      case 8: 
        a(paramToServiceMsg, bool1, i, paramObject);
        return;
      case 9: 
        if (paramFromServiceMsg == null) {}
        for (bool2 = false;; bool2 = paramFromServiceMsg.isSuccess())
        {
          a(paramToServiceMsg, bool1, i, localReportRsp, bool2);
          return;
        }
        label656:
        localObject = null;
        localOpenPoiRsp = null;
        localQueryPoiRsp = null;
        localQueryItemRsp = null;
        localPageItemRsp = null;
        localReportRsp = null;
        i = -1;
        str = "";
        paramObject = null;
      }
    }
  }
  
  void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool;
    int j;
    Object localObject;
    int i;
    if (paramFromServiceMsg == null)
    {
      bool = false;
      j = paramToServiceMsg.extraData.getInt("subcmd", -1);
      localObject = "";
      if (!bool) {
        break label545;
      }
      localObject = new cmd0x95a.RspBody();
      i = a(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
      paramFromServiceMsg = paramFromServiceMsg.extraData.getString("str_error_msg");
      if (i != 0) {
        break label458;
      }
      switch (j)
      {
      default: 
        label108:
        paramToServiceMsg = paramFromServiceMsg;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArMapHandler", 2, "handle0x95a errMsg:" + paramToServiceMsg + ",result:" + i + ",isSuc:" + bool);
      }
      return;
      bool = paramFromServiceMsg.isSuccess();
      break;
      if (!((cmd0x95a.RspBody)localObject).msg_update_ar_count_rsp.has()) {
        break label108;
      }
      paramToServiceMsg = (cmd0x95a.UpdateArCountRsp)((cmd0x95a.RspBody)localObject).msg_update_ar_count_rsp.get();
      if (paramToServiceMsg.uint64_uin.has()) {}
      for (long l = paramToServiceMsg.uint64_uin.get(); QLog.isColorLevel(); l = -1L)
      {
        QLog.d("ArMapHandler", 2, "handle0x95a report scanQRCode result,uin = " + l);
        break;
      }
      a(paramToServiceMsg, bool, i, (cmd0x95a.RspBody)localObject);
      break label108;
      if (!((cmd0x95a.RspBody)localObject).msg_set_world_cup_info_rsp.has()) {
        break label108;
      }
      paramToServiceMsg = ((cmd0x95a.SetWorldCupInfoRsp)((cmd0x95a.RspBody)localObject).msg_set_world_cup_info_rsp.get()).str_share_id.get();
      a(21, bool, new Object[] { paramToServiceMsg, Integer.valueOf(i) });
      if (!QLog.isColorLevel()) {
        break label108;
      }
      QLog.d("ArMapHandler", 2, "handle0x95a SetWorldCupInfo shareId = " + paramToServiceMsg);
      break label108;
      if (!((cmd0x95a.RspBody)localObject).msg_join_world_cup_rsp.has()) {
        break label108;
      }
      paramToServiceMsg = (cmd0x95a.JoinWorldCupRsp)((cmd0x95a.RspBody)localObject).msg_join_world_cup_rsp.get();
      paramObject = paramToServiceMsg.str_recommend_nick.get();
      if ((paramObject != null) && (paramObject.length() > 0)) {
        this.jdField_a_of_type_JavaLangString = paramObject;
      }
      l = paramToServiceMsg.uint64_recommend_uin.get();
      QLog.d("ArMapHandler", 1, "handle0x95a JoinWorldCup recommendNick = " + paramObject + ", recommendUin = " + l);
      break label108;
      label458:
      switch (j)
      {
      }
      for (;;)
      {
        paramToServiceMsg = paramFromServiceMsg;
        break;
        a(21, bool, new Object[] { null, Integer.valueOf(i) });
        if (QLog.isColorLevel()) {
          QLog.d("ArMapHandler", 2, "handle0x95a SetWorldCupInfo fail result = " + i);
        }
      }
      label545:
      i = -1;
      paramToServiceMsg = (ToServiceMsg)localObject;
    }
  }
  
  protected void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = -1;
    boolean bool;
    Object localObject;
    if (paramFromServiceMsg == null)
    {
      bool = false;
      int j = paramToServiceMsg.extraData.getInt("subcmd", -1);
      localObject = "";
      if (bool)
      {
        localObject = new oidb_0x84c.RspBody();
        i = a(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
        paramObject = paramFromServiceMsg.extraData.getString("str_error_msg");
        if (i == 0) {}
        switch (j)
        {
        default: 
          paramFromServiceMsg = null;
          label102:
          switch (j)
          {
          }
          break;
        }
      }
    }
    for (;;)
    {
      localObject = paramObject;
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ArMapHandler", 2, "handleGe0x84c errMsg:" + (String)localObject + ",result:" + i + ",isSuc:" + bool);
        }
        return;
        bool = paramFromServiceMsg.isSuccess();
        break;
        paramFromServiceMsg = null;
        break label102;
        paramFromServiceMsg = null;
        break label102;
        paramFromServiceMsg = null;
        break label102;
        paramFromServiceMsg = (oidb_0x84c.QueryCountRsp)((oidb_0x84c.RspBody)localObject).query_count_rsp.get();
        break label102;
        localObject = paramObject;
        continue;
        localObject = paramObject;
        continue;
        localObject = paramObject;
      }
      a(paramToServiceMsg, bool, i, paramFromServiceMsg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ArMapHandler
 * JD-Core Version:    0.7.0.1
 */