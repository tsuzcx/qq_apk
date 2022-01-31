package com.qq.im.poi;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.armap.ARMapActivity;
import com.tencent.mobileqq.armap.ArMapHandler;
import com.tencent.mobileqq.armap.ArMapInterface;
import com.tencent.mobileqq.armap.ArMapUtil;
import com.tencent.mobileqq.armap.JNIPOIRequestParam;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.RspBody;
import tencent.im.oidb.lbspack.MqqLbsPack.LBSSig;
import tencent.im.oidb.lbspack.MqqLbsPack.LbsPackInfo;
import tencent.im.oidb.lbspack.MqqLbsPack.POIRPInfo;
import tencent.im.oidb.lbspack.MqqLbsPack.ReqGetLBSRPList;
import tencent.im.oidb.lbspack.MqqLbsPack.RspGetLBSRPList;
import tencent.im.oidb.lbspack.MqqLbsPack.RspHead;
import tencent.im.oidb.lbspack.MqqLbsPack.SelectedUinInfo;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class LbsPackMapPoiPackServlet
  extends MSFServlet
{
  private LbsPackMapInfo a(MqqLbsPack.RspGetLBSRPList paramRspGetLBSRPList)
  {
    LbsPackMapInfo localLbsPackMapInfo = new LbsPackMapInfo();
    Object localObject;
    int i;
    if (paramRspGetLBSRPList.msg_head.has())
    {
      localObject = (MqqLbsPack.RspHead)paramRspGetLBSRPList.msg_head.get();
      if (localObject != null)
      {
        if (!((MqqLbsPack.RspHead)localObject).uint32_result.has()) {
          break label1161;
        }
        i = ((MqqLbsPack.RspHead)localObject).uint32_result.get();
        label56:
        localLbsPackMapInfo.jdField_c_of_type_Int = i;
        if (!((MqqLbsPack.RspHead)localObject).bytes_err_msg.has()) {
          break label1166;
        }
        localObject = ((MqqLbsPack.RspHead)localObject).bytes_err_msg.get().toStringUtf8();
        label86:
        localLbsPackMapInfo.jdField_c_of_type_JavaLangString = ((String)localObject);
      }
      if (!paramRspGetLBSRPList.bytes_cookie.has()) {
        break label1172;
      }
      localObject = paramRspGetLBSRPList.bytes_cookie.get().toStringUtf8();
      label115:
      localLbsPackMapInfo.jdField_a_of_type_JavaLangString = ((String)localObject);
      if (!paramRspGetLBSRPList.bytes_page_cookie.has()) {
        break label1178;
      }
      localObject = paramRspGetLBSRPList.bytes_page_cookie.get().toStringUtf8();
      label144:
      localLbsPackMapInfo.jdField_b_of_type_JavaLangString = ((String)localObject);
      if (!paramRspGetLBSRPList.uint32_flush_dist.has()) {
        break label1184;
      }
      i = paramRspGetLBSRPList.uint32_flush_dist.get();
      label169:
      localLbsPackMapInfo.jdField_b_of_type_Int = i;
      if (!paramRspGetLBSRPList.uint32_flush_time.has()) {
        break label1189;
      }
      i = paramRspGetLBSRPList.uint32_flush_time.get();
      label193:
      localLbsPackMapInfo.jdField_a_of_type_Int = i;
      if (!paramRspGetLBSRPList.uint32_lbs_interval.has()) {
        break label1194;
      }
      i = paramRspGetLBSRPList.uint32_lbs_interval.get();
      label217:
      localLbsPackMapInfo.jdField_d_of_type_Int = i;
      if (!paramRspGetLBSRPList.uint32_show_map_grid.has()) {
        break label1199;
      }
      i = paramRspGetLBSRPList.uint32_show_map_grid.get();
      label241:
      localLbsPackMapInfo.e = i;
      if (!paramRspGetLBSRPList.uint32_patch_button_stat.has()) {
        break label1204;
      }
      i = paramRspGetLBSRPList.uint32_patch_button_stat.get();
      label265:
      localLbsPackMapInfo.f = i;
      if (!paramRspGetLBSRPList.uint32_get_award_range.has()) {
        break label1209;
      }
      i = paramRspGetLBSRPList.uint32_get_award_range.get();
      label289:
      localLbsPackMapInfo.g = i;
      if (QLog.isColorLevel()) {
        QLog.d("LbsPack", 2, "LbsMapInfo rc=" + localLbsPackMapInfo.jdField_c_of_type_Int + " m=" + localLbsPackMapInfo.jdField_c_of_type_JavaLangString + " fd" + localLbsPackMapInfo.jdField_b_of_type_Int + " ft" + localLbsPackMapInfo.jdField_a_of_type_Int + " gr=" + localLbsPackMapInfo.e + " bs=" + localLbsPackMapInfo.f + " dis=" + localLbsPackMapInfo.g);
      }
      if (!paramRspGetLBSRPList.rpt_poi_info_list.has()) {
        break label1216;
      }
      paramRspGetLBSRPList = paramRspGetLBSRPList.rpt_poi_info_list.get();
      label426:
      if (paramRspGetLBSRPList == null) {
        break label1414;
      }
      localObject = paramRspGetLBSRPList.iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject).hasNext()) {
        break label1414;
      }
      paramRspGetLBSRPList = (MqqLbsPack.POIRPInfo)((Iterator)localObject).next();
      LbsPackPoiInfo localLbsPackPoiInfo = new LbsPackPoiInfo();
      long l;
      label486:
      label510:
      LbsPackInfo localLbsPackInfo;
      if (paramRspGetLBSRPList.uint64_poi_id.has())
      {
        l = paramRspGetLBSRPList.uint64_poi_id.get();
        localLbsPackPoiInfo.jdField_a_of_type_Long = l;
        if (!paramRspGetLBSRPList.int32_lon.has()) {
          break label1228;
        }
        i = paramRspGetLBSRPList.int32_lon.get();
        localLbsPackPoiInfo.jdField_b_of_type_Int = i;
        if (!paramRspGetLBSRPList.int32_lat.has()) {
          break label1233;
        }
        i = paramRspGetLBSRPList.int32_lat.get();
        label534:
        localLbsPackPoiInfo.jdField_a_of_type_Int = i;
        if (!paramRspGetLBSRPList.uint32_total_num.has()) {
          break label1238;
        }
        i = paramRspGetLBSRPList.uint32_total_num.get();
        label558:
        localLbsPackPoiInfo.jdField_c_of_type_Int = i;
        if (!paramRspGetLBSRPList.lbs_pack_info.has()) {
          break label1243;
        }
        paramRspGetLBSRPList = paramRspGetLBSRPList.lbs_pack_info.get();
        label582:
        if (QLog.isColorLevel()) {
          QLog.d("LbsPack", 2, "PackPoi poiId=" + localLbsPackPoiInfo.jdField_a_of_type_Long + " lo=" + localLbsPackPoiInfo.jdField_b_of_type_Int + " la=" + localLbsPackPoiInfo.jdField_a_of_type_Int + " num=" + localLbsPackPoiInfo.jdField_c_of_type_Int);
        }
        if (paramRspGetLBSRPList == null) {
          break label1392;
        }
        Iterator localIterator = paramRspGetLBSRPList.iterator();
        label668:
        if (!localIterator.hasNext()) {
          break label1371;
        }
        MqqLbsPack.LbsPackInfo localLbsPackInfo1 = (MqqLbsPack.LbsPackInfo)localIterator.next();
        localLbsPackInfo = new LbsPackInfo();
        if (!localLbsPackInfo1.bytes_cft_pack_id.has()) {
          break label1248;
        }
        paramRspGetLBSRPList = localLbsPackInfo1.bytes_cft_pack_id.get().toStringUtf8();
        label722:
        localLbsPackInfo.jdField_a_of_type_JavaLangString = paramRspGetLBSRPList;
        if (!localLbsPackInfo1.uint64_uin.has()) {
          break label1253;
        }
        l = localLbsPackInfo1.uint64_uin.get();
        label748:
        localLbsPackInfo.jdField_a_of_type_Long = l;
        if (!localLbsPackInfo1.uint32_priority.has()) {
          break label1260;
        }
        i = localLbsPackInfo1.uint32_priority.get();
        label774:
        localLbsPackInfo.jdField_b_of_type_Int = i;
        if (!localLbsPackInfo1.uint32_status.has()) {
          break label1265;
        }
        i = localLbsPackInfo1.uint32_status.get();
        label800:
        localLbsPackInfo.jdField_a_of_type_Int = i;
        if (!localLbsPackInfo1.uint32_qa.has()) {
          break label1270;
        }
        i = localLbsPackInfo1.uint32_qa.get();
        label826:
        localLbsPackInfo.jdField_c_of_type_Int = i;
        localLbsPackInfo.jdField_b_of_type_Long = localLbsPackPoiInfo.jdField_a_of_type_Long;
        if (!localLbsPackInfo1.bytes_name.has()) {
          break label1275;
        }
        paramRspGetLBSRPList = localLbsPackInfo1.bytes_name.get().toStringUtf8();
        label865:
        localLbsPackInfo.jdField_d_of_type_JavaLangString = paramRspGetLBSRPList;
        if (!localLbsPackInfo1.bytes_addr.has()) {
          break label1280;
        }
        paramRspGetLBSRPList = localLbsPackInfo1.bytes_addr.get().toStringUtf8();
        label894:
        localLbsPackInfo.e = paramRspGetLBSRPList;
        if (!localLbsPackInfo1.bytes_auth_key.has()) {
          break label1285;
        }
        paramRspGetLBSRPList = localLbsPackInfo1.bytes_auth_key.get().toStringUtf8();
        label923:
        localLbsPackInfo.f = paramRspGetLBSRPList;
        if (!localLbsPackInfo1.bytes_pid.has()) {
          break label1290;
        }
        paramRspGetLBSRPList = localLbsPackInfo1.bytes_pid.get().toStringUtf8();
        label952:
        localLbsPackInfo.jdField_b_of_type_JavaLangString = paramRspGetLBSRPList;
        if (QLog.isColorLevel()) {
          QLog.d("LbsPack", 2, "PackInfo poiId=" + localLbsPackInfo.jdField_b_of_type_Long + " qa=" + localLbsPackInfo.jdField_c_of_type_Int + " pri=" + localLbsPackInfo.jdField_b_of_type_Int + " sta=" + localLbsPackInfo.jdField_a_of_type_Int + " pid=" + localLbsPackInfo.jdField_b_of_type_JavaLangString + " pn=" + localLbsPackInfo.jdField_d_of_type_JavaLangString);
        }
        if (!localLbsPackInfo1.uin_grp_dis_info.has()) {
          break label1295;
        }
        paramRspGetLBSRPList = (MqqLbsPack.SelectedUinInfo)localLbsPackInfo1.uin_grp_dis_info.get();
        label1087:
        if ((paramRspGetLBSRPList != null) && (paramRspGetLBSRPList.uint32_all_frd.has()))
        {
          i = paramRspGetLBSRPList.uint32_all_frd.get();
          if (i != 0) {
            break label1362;
          }
          if (!paramRspGetLBSRPList.uint64_group_code.has()) {
            break label1300;
          }
          localLbsPackInfo.jdField_d_of_type_Int = 3;
          localLbsPackInfo.jdField_c_of_type_Long = paramRspGetLBSRPList.uint64_group_code.get();
        }
      }
      for (;;)
      {
        localLbsPackPoiInfo.jdField_a_of_type_JavaUtilArrayList.add(localLbsPackInfo);
        break label668;
        localObject = null;
        break;
        label1161:
        i = -1;
        break label56;
        label1166:
        localObject = null;
        break label86;
        label1172:
        localObject = null;
        break label115;
        label1178:
        localObject = null;
        break label144;
        label1184:
        i = -1;
        break label169;
        label1189:
        i = -1;
        break label193;
        label1194:
        i = -1;
        break label217;
        label1199:
        i = 0;
        break label241;
        label1204:
        i = 0;
        break label265;
        label1209:
        i = ARMapActivity.jdField_a_of_type_Int;
        break label289;
        label1216:
        paramRspGetLBSRPList = null;
        break label426;
        l = -1L;
        break label486;
        label1228:
        i = -1;
        break label510;
        label1233:
        i = -1;
        break label534;
        label1238:
        i = -1;
        break label558;
        label1243:
        paramRspGetLBSRPList = null;
        break label582;
        label1248:
        paramRspGetLBSRPList = null;
        break label722;
        label1253:
        l = -1L;
        break label748;
        label1260:
        i = -1;
        break label774;
        label1265:
        i = -1;
        break label800;
        label1270:
        i = -1;
        break label826;
        label1275:
        paramRspGetLBSRPList = null;
        break label865;
        label1280:
        paramRspGetLBSRPList = null;
        break label894;
        label1285:
        paramRspGetLBSRPList = null;
        break label923;
        label1290:
        paramRspGetLBSRPList = null;
        break label952;
        label1295:
        paramRspGetLBSRPList = null;
        break label1087;
        label1300:
        if (paramRspGetLBSRPList.uint64_discuss_uin.has())
        {
          localLbsPackInfo.jdField_d_of_type_Int = 4;
          localLbsPackInfo.jdField_c_of_type_Long = paramRspGetLBSRPList.uint64_discuss_uin.get();
        }
        else if (paramRspGetLBSRPList.uint64_uin.has())
        {
          localLbsPackInfo.jdField_d_of_type_Int = 5;
          localLbsPackInfo.jdField_c_of_type_Long = paramRspGetLBSRPList.uint64_uin.get();
          continue;
          label1362:
          localLbsPackInfo.jdField_d_of_type_Int = i;
        }
      }
      label1371:
      ((LbsPackManager)getAppRuntime().getManager(214)).b(localLbsPackPoiInfo.jdField_a_of_type_JavaUtilArrayList);
      label1392:
      localLbsPackMapInfo.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(localLbsPackPoiInfo.jdField_a_of_type_Long), localLbsPackPoiInfo);
    }
    label1414:
    return localLbsPackMapInfo;
  }
  
  public static ByteStringMicro a(String paramString)
  {
    ByteStringMicro localByteStringMicro = null;
    if (!TextUtils.isEmpty(paramString)) {}
    for (paramString = paramString.getBytes();; paramString = null)
    {
      if (paramString != null) {
        localByteStringMicro = ByteStringMicro.copyFrom(paramString);
      }
      return localByteStringMicro;
    }
  }
  
  private void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool2 = paramFromServiceMsg.isSuccess();
    if (bool2) {}
    for (;;)
    {
      try
      {
        Object localObject = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
        paramFromServiceMsg = new byte[((ByteBuffer)localObject).getInt() - 4];
        ((ByteBuffer)localObject).get(paramFromServiceMsg);
        localObject = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject).mergeFrom(paramFromServiceMsg);
        int i = ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.get();
        if (QLog.isColorLevel()) {
          QLog.d("LbsPack", 2, "handleRespSenderNick | is success, and result=" + i);
        }
        bool1 = bool2;
        if (((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.has())
        {
          bool1 = bool2;
          if (((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.get() != null)
          {
            paramFromServiceMsg = ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.get().toByteArray();
            localObject = new oidb_0x5eb.RspBody();
            ((oidb_0x5eb.RspBody)localObject).mergeFrom(paramFromServiceMsg);
            paramFromServiceMsg = ((oidb_0x5eb.RspBody)localObject).rpt_msg_uin_data.get();
            localObject = (LbsPackManager)getAppRuntime().getManager(214);
            if ((paramFromServiceMsg != null) && (paramFromServiceMsg.size() > 0)) {
              notifyObserver(paramIntent, 2, bool2, ((LbsPackManager)localObject).a(paramFromServiceMsg), LbsPackObserver.class);
            }
            bool1 = false;
          }
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        QLog.w("LbsPack", 2, paramFromServiceMsg.getMessage());
        bool1 = false;
        continue;
      }
      if (!bool1) {
        notifyObserver(paramIntent, 2, false, null, LbsPackObserver.class);
      }
      return;
      boolean bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("LbsPack", 2, "handleRespSenderNick | success:" + bool2);
        bool1 = bool2;
      }
    }
  }
  
  private void a(Intent paramIntent, Packet paramPacket)
  {
    ArrayList localArrayList1 = paramIntent.getStringArrayListExtra("key_sender_uins");
    oidb_0x5eb.ReqBody localReqBody = new oidb_0x5eb.ReqBody();
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    while (i < localArrayList1.size())
    {
      localArrayList2.add(Long.valueOf(Long.parseLong((String)localArrayList1.get(i))));
      i += 1;
    }
    localReqBody.rpt_uint64_uins.set(localArrayList2);
    localReqBody.uint32_req_nick.set(1);
    a(localReqBody.toByteArray(), 1515, 55, "OidbSvc.0x5eb_55", paramPacket);
    if (QLog.isColorLevel()) {
      QLog.d("LbsPack", 2, "onSend req=" + paramIntent.toString());
    }
  }
  
  public static void a(ArMapInterface paramArMapInterface, double paramDouble1, double paramDouble2, String paramString, long paramLong1, JNIPOIRequestParam paramJNIPOIRequestParam, long paramLong2, long paramLong3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LbsPack", 2, "发起POI红包请求 pId=" + paramString + " adcode=" + paramLong3 + " lon=" + paramDouble1 + " lat=" + paramDouble2);
    }
    if (QLog.isColorLevel()) {
      QLog.d("LbsPack", 2, "sendMapPoiPackRequest jniParam=" + paramJNIPOIRequestParam);
    }
    if (paramJNIPOIRequestParam == null)
    {
      LbsPackStatsCollector.a("actLbsPoiListFailure", -10003);
      return;
    }
    NewIntent localNewIntent = new NewIntent(paramArMapInterface.getApp(), LbsPackMapPoiPackServlet.class);
    localNewIntent.putExtra("key_longitude", paramDouble1);
    localNewIntent.putExtra("key_latitude", paramDouble2);
    localNewIntent.putExtra("key_pid", paramString);
    localNewIntent.putExtra("key_native_handler", paramLong1);
    localNewIntent.putExtra("key_jni_param", paramJNIPOIRequestParam);
    localNewIntent.putExtra("key_req_type", 1);
    localNewIntent.putExtra("key_adcode", paramLong3);
    localNewIntent.putExtra("poi_req_nativeGLSurfaceViewContext", paramLong2);
    paramArMapInterface.startServlet(localNewIntent);
  }
  
  public static void a(ArMapInterface paramArMapInterface, long paramLong1, String paramString, boolean paramBoolean, long paramLong2)
  {
    NewIntent localNewIntent = new NewIntent(paramArMapInterface.getApp(), LbsPackMapPoiPackServlet.class);
    if (QLog.isColorLevel()) {
      QLog.d("LbsPack", 2, "红包分页请求 poiId=" + paramLong1 + " firstPage=" + paramBoolean + " adcode=" + paramLong2 + " pid=" + paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.d("LbsPack", 2, "sendLbsPackPageRequest");
    }
    localNewIntent.putExtra("key_pid_id", paramLong1);
    localNewIntent.putExtra("key_req_type", 2);
    if (paramBoolean) {
      localNewIntent.putExtra("key_pid", paramString);
    }
    localNewIntent.putExtra("key_page_first", paramBoolean);
    localNewIntent.putExtra("key_adcode", paramLong2);
    paramArMapInterface.startServlet(localNewIntent);
  }
  
  public static void a(ArMapInterface paramArMapInterface, long paramLong1, boolean paramBoolean, long paramLong2)
  {
    a(paramArMapInterface, paramLong1, "", paramBoolean, paramLong2);
  }
  
  public static void a(ArMapInterface paramArMapInterface, ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LbsPack", 2, "requestSenderNick uinList=" + paramArrayList);
    }
    NewIntent localNewIntent = new NewIntent(paramArMapInterface.getApp(), LbsPackMapPoiPackServlet.class);
    localNewIntent.putStringArrayListExtra("key_sender_uins", paramArrayList);
    localNewIntent.putExtra("key_req_type", 3);
    paramArMapInterface.startServlet(localNewIntent);
  }
  
  private void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, String paramString, Packet paramPacket)
  {
    Object localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(paramInt1);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(paramInt2);
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    paramArrayOfByte = ((oidb_sso.OIDBSSOPkg)localObject).toByteArray();
    localObject = ByteBuffer.allocate(paramArrayOfByte.length + 4);
    ((ByteBuffer)localObject).putInt(paramArrayOfByte.length + 4).put(paramArrayOfByte);
    paramPacket.setSSOCommand(paramString);
    paramPacket.putSendData(((ByteBuffer)localObject).array());
    paramPacket.setTimeout(30000L);
  }
  
  public void a(Intent paramIntent, LbsPackMapInfo paramLbsPackMapInfo, String paramString)
  {
    label11:
    Iterator localIterator1;
    if ((paramLbsPackMapInfo == null) || (TextUtils.isEmpty(paramString)))
    {
      return;
    }
    else
    {
      do
      {
        if (QLog.isColorLevel()) {
          QLog.d("LbsPack", 2, "handleChangeMapViewAngle= " + paramString);
        }
      } while (paramLbsPackMapInfo.jdField_a_of_type_JavaUtilHashMap.isEmpty());
      localIterator1 = paramLbsPackMapInfo.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    }
    LbsPackPoiInfo localLbsPackPoiInfo;
    label119:
    do
    {
      break label119;
      if (!localIterator1.hasNext()) {
        break label11;
      }
      localLbsPackPoiInfo = (LbsPackPoiInfo)((Map.Entry)localIterator1.next()).getValue();
      if (localLbsPackPoiInfo.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
        break;
      }
      Iterator localIterator2 = localLbsPackPoiInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (!localIterator2.hasNext()) {
        break;
      }
      paramLbsPackMapInfo = (LbsPackInfo)localIterator2.next();
    } while (!paramLbsPackMapInfo.jdField_b_of_type_JavaLangString.equals(paramString));
    double d1 = localLbsPackPoiInfo.jdField_a_of_type_Int / 1000000.0D;
    double d2 = localLbsPackPoiInfo.jdField_b_of_type_Int / 1000000.0D;
    paramString = new Bundle();
    paramString.putDouble("latitude", d1);
    paramString.putDouble("longitude", d2);
    if (QLog.isColorLevel()) {
      QLog.d("LbsPack", 2, "handleChangeMapViewAngle|info = " + paramLbsPackMapInfo.toString() + ",lat&Lon=" + d1 + "|" + d2);
    }
    notifyObserver(paramIntent, 6, true, paramString, LbsPackObserver.class);
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = new Bundle();
    boolean bool = paramFromServiceMsg.isSuccess();
    long l1 = paramIntent.getLongExtra("key_native_handler", 0L);
    int i = paramIntent.getIntExtra("key_req_type", 2);
    Object localObject1 = paramFromServiceMsg.getServiceCmd();
    if (QLog.isColorLevel()) {
      QLog.d("LbsPack", 2, "onReceive reqType=" + i + " cmd=" + (String)localObject1);
    }
    if (bool) {
      if ("OidbSvc.0x5eb_55".equals(localObject1)) {
        a(paramIntent, paramFromServiceMsg);
      }
    }
    label439:
    do
    {
      do
      {
        return;
        for (;;)
        {
          Object localObject2;
          try
          {
            localObject1 = new MqqLbsPack.RspGetLBSRPList();
            localObject2 = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
            paramFromServiceMsg = new byte[((ByteBuffer)localObject2).getInt() - 4];
            ((ByteBuffer)localObject2).get(paramFromServiceMsg);
            ((MqqLbsPack.RspGetLBSRPList)localObject1).mergeFrom(paramFromServiceMsg);
            localObject1 = a((MqqLbsPack.RspGetLBSRPList)localObject1);
            if (((LbsPackMapInfo)localObject1).jdField_c_of_type_Int != 0) {
              break label687;
            }
            l2 = paramIntent.getLongExtra("poi_req_nativeGLSurfaceViewContext", 0L);
            localObject2 = (LbsPackManager)getAppRuntime().getManager(214);
            if (i != 1) {
              break label439;
            }
            LbsPackStatsCollector.a("actLbsPoiListFailure");
            if ((((LbsPackMapInfo)localObject1).jdField_a_of_type_JavaUtilHashMap != null) && (QLog.isColorLevel())) {
              QLog.d("LbsPack", 2, "地图红包请求 size=" + ((LbsPackMapInfo)localObject1).jdField_a_of_type_JavaUtilHashMap.size());
            }
            ((LbsPackManager)localObject2).a((LbsPackMapInfo)localObject1);
            a(paramIntent, (LbsPackMapInfo)localObject1, paramIntent.getStringExtra("key_pid"));
            ((ArMapHandler)((ArMapInterface)getAppRuntime()).a(2)).a(19, bool, new Object[] { Integer.valueOf(-1), paramFromServiceMsg, Long.valueOf(paramFromServiceMsg.length), Long.valueOf(l1), Boolean.valueOf(false), Integer.valueOf(((LbsPackMapInfo)localObject1).jdField_d_of_type_Int), Long.valueOf(l2) });
            notifyObserver(paramIntent, 5, bool, localBundle, LbsPackObserver.class);
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("LbsPack", 2, "onReceive, isSuccess  = " + bool + ",result = " + -1 + ",nativeHandle = " + l1);
            return;
          }
          catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
          {
            paramFromServiceMsg.printStackTrace();
          }
          if (i != 2) {
            break;
          }
          notifyObserver(paramIntent, 4, false, null, LbsPackObserver.class);
          return;
          LbsPackStatsCollector.a("actLbsPackListFailure");
          if ((((LbsPackMapInfo)localObject1).jdField_a_of_type_JavaUtilHashMap != null) && (QLog.isColorLevel())) {
            QLog.d("LbsPack", 2, "PackPageRequest size=" + ((LbsPackMapInfo)localObject1).jdField_a_of_type_JavaUtilHashMap.size());
          }
          if (QLog.isColorLevel()) {
            QLog.d("LbsPack", 2, "红包分页请求 pageCookie=" + ((LbsPackManager)localObject2).jdField_b_of_type_JavaLangString);
          }
          ((LbsPackManager)localObject2).jdField_b_of_type_JavaLangString = ((LbsPackMapInfo)localObject1).jdField_b_of_type_JavaLangString;
          long l2 = paramIntent.getLongExtra("key_pid_id", 0L);
          paramFromServiceMsg = (LbsPackPoiInfo)((LbsPackMapInfo)localObject1).jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(l2));
          if (paramFromServiceMsg != null)
          {
            localBundle.putBoolean("firstPage", paramIntent.getBooleanExtra("key_page_first", false));
            localBundle.putLong("poiId", l2);
            localBundle.putInt("packTotalNumber", paramFromServiceMsg.jdField_c_of_type_Int);
            localBundle.putDouble("latitude", paramFromServiceMsg.jdField_a_of_type_Int);
            localBundle.putDouble("longitude", paramFromServiceMsg.jdField_b_of_type_Int);
            localBundle.putParcelableArrayList("packInfoList", paramFromServiceMsg.jdField_a_of_type_JavaUtilArrayList);
            localBundle.putString("pageCookie", ((LbsPackManager)localObject2).jdField_b_of_type_JavaLangString);
            localBundle.putInt("showMapFlag", ((LbsPackMapInfo)localObject1).e);
          }
          notifyObserver(paramIntent, 4, bool, localBundle, LbsPackObserver.class);
        }
        if (i == 2)
        {
          LbsPackStatsCollector.a("actLbsPackListFailure", ((LbsPackMapInfo)localObject1).jdField_c_of_type_Int);
          notifyObserver(paramIntent, 4, false, null, LbsPackObserver.class);
          return;
        }
      } while (i != 1);
      LbsPackStatsCollector.a("actLbsPoiListFailure", ((LbsPackMapInfo)localObject1).jdField_c_of_type_Int);
      return;
      if (i == 2)
      {
        LbsPackStatsCollector.a("actLbsPackListFailure", -10006);
        notifyObserver(paramIntent, 4, false, null, LbsPackObserver.class);
        return;
      }
    } while (i != 1);
    label687:
    LbsPackStatsCollector.a("actLbsPoiListFailure", -10006);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Object localObject = (LbsPackManager)getAppRuntime().getManager(214);
    MqqLbsPack.ReqGetLBSRPList localReqGetLBSRPList = new MqqLbsPack.ReqGetLBSRPList();
    int i = paramIntent.getIntExtra("key_req_type", 2);
    long l1 = paramIntent.getLongExtra("key_adcode", 0L);
    if (QLog.isColorLevel()) {
      QLog.d("LbsPack", 2, "onSend reqType=" + i + " adcode=" + l1);
    }
    if (i == 3)
    {
      a(paramIntent, paramPacket);
      return;
    }
    JNIPOIRequestParam localJNIPOIRequestParam;
    if (i == 1)
    {
      double d1 = paramIntent.getDoubleExtra("key_longitude", 0.0D);
      double d2 = paramIntent.getDoubleExtra("key_latitude", 0.0D);
      localReqGetLBSRPList.int32_lon.set((int)(d1 * 1000000.0D));
      localReqGetLBSRPList.int32_lat.set((int)(1000000.0D * d2));
      localJNIPOIRequestParam = (JNIPOIRequestParam)paramIntent.getSerializableExtra("key_jni_param");
      if (localJNIPOIRequestParam != null)
      {
        if (!StringUtil.a(localJNIPOIRequestParam.cookie)) {
          localReqGetLBSRPList.bytes_cookie.set(a(localJNIPOIRequestParam.cookie));
        }
        ((LbsPackManager)localObject).a(localJNIPOIRequestParam);
        MqqLbsPack.LBSSig localLBSSig = new MqqLbsPack.LBSSig();
        localLBSSig.int32_lon.set((int)ArMapUtil.a(localJNIPOIRequestParam.lbsSig_lon, 1000000.0D));
        localLBSSig.int32_lat.set((int)ArMapUtil.a(localJNIPOIRequestParam.lbsSig_lat, 1000000.0D));
        localLBSSig.uint32_time.set((int)(localJNIPOIRequestParam.lbsSig_locationTime / 1000.0D));
        if (!StringUtil.a(localJNIPOIRequestParam.lbsSig_verifyKey)) {
          localLBSSig.bytes_verify_key.set(a(localJNIPOIRequestParam.lbsSig_verifyKey));
        }
        localReqGetLBSRPList.msg_lbs_sig.set(localLBSSig);
        localReqGetLBSRPList.uint32_req_occasion.set(localJNIPOIRequestParam.req_occasion);
        if (QLog.isColorLevel()) {
          QLog.d("LbsPack", 2, "sendMapPoiPackRequest occasion=" + localJNIPOIRequestParam.req_occasion);
        }
        ((LbsPackManager)localObject).a = localJNIPOIRequestParam;
        ((LbsPackManager)localObject).a(localJNIPOIRequestParam.longitude, localJNIPOIRequestParam.latitude, localJNIPOIRequestParam.accuracy);
      }
    }
    for (;;)
    {
      paramIntent = paramIntent.getStringExtra("key_pid");
      if (!StringUtil.a(paramIntent)) {
        localReqGetLBSRPList.bytes_pid.set(ByteStringMicro.copyFrom(paramIntent.getBytes()));
      }
      localReqGetLBSRPList.uint64_adcode.set(l1);
      paramIntent = localReqGetLBSRPList.toByteArray();
      localObject = ByteBuffer.allocate(paramIntent.length + 4);
      ((ByteBuffer)localObject).putInt(paramIntent.length + 4).put(paramIntent);
      paramIntent = ((ByteBuffer)localObject).array();
      paramPacket.setSSOCommand("LBSRedPack.ReqGetLBSRPList");
      paramPacket.putSendData(paramIntent);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("LbsPack", 2, "onSend req=" + localReqGetLBSRPList.toString());
      return;
      if (i == 2)
      {
        localJNIPOIRequestParam = ((LbsPackManager)localObject).a;
        if (localJNIPOIRequestParam != null)
        {
          boolean bool = paramIntent.getBooleanExtra("key_page_first", true);
          if ((!bool) && (!StringUtil.a(((LbsPackManager)localObject).jdField_b_of_type_JavaLangString))) {
            localReqGetLBSRPList.bytes_page_cookie.set(a(((LbsPackManager)localObject).jdField_b_of_type_JavaLangString));
          }
          if (QLog.isColorLevel()) {
            QLog.d("LbsPack", 2, "sendPackPageRequest pageCookie=" + ((LbsPackManager)localObject).jdField_b_of_type_JavaLangString + " firstPage=" + bool);
          }
          long l2 = paramIntent.getLongExtra("key_pid_id", 0L);
          localReqGetLBSRPList.uint64_poi_id.set(l2);
          localReqGetLBSRPList.int32_lon.set((int)(localJNIPOIRequestParam.longitude * 1000000.0D));
          localReqGetLBSRPList.int32_lat.set((int)(localJNIPOIRequestParam.latitude * 1000000.0D));
          localObject = new MqqLbsPack.LBSSig();
          ((MqqLbsPack.LBSSig)localObject).int32_lon.set((int)ArMapUtil.a(localJNIPOIRequestParam.lbsSig_lon, 1000000.0D));
          ((MqqLbsPack.LBSSig)localObject).int32_lat.set((int)ArMapUtil.a(localJNIPOIRequestParam.lbsSig_lat, 1000000.0D));
          ((MqqLbsPack.LBSSig)localObject).uint32_time.set((int)(localJNIPOIRequestParam.lbsSig_locationTime / 1000.0D));
          if (!StringUtil.a(localJNIPOIRequestParam.lbsSig_verifyKey)) {
            ((MqqLbsPack.LBSSig)localObject).bytes_verify_key.set(a(localJNIPOIRequestParam.lbsSig_verifyKey));
          }
          localReqGetLBSRPList.msg_lbs_sig.set((MessageMicro)localObject);
          if (QLog.isColorLevel()) {
            QLog.d("LbsPack", 2, "onSend pid=" + localJNIPOIRequestParam.lbsPid);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.qq.im.poi.LbsPackMapPoiPackServlet
 * JD-Core Version:    0.7.0.1
 */