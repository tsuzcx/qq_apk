package com.tencent.mobileqq.activity.springfestival.config;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.biz.ProtoServlet;
import com.tencent.mobileqq.activity.springfestival.report.SpringHbMonitorReporter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.DeviceInfo;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.PageReqInfo;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.PageRespInfo;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ReqGetConfigByPage;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.RespGetConfigByPage;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Screen;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.portal.PortalUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.InflaterInputStream;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.app.Packet;
import org.apache.http.util.ByteArrayBuffer;

public class SpringFestivalRedpacketConfigServlet
  extends ProtoServlet
{
  private void a(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      int i = paramIntent.getIntExtra("k_req_occasion", 0);
      int j = paramIntent.getIntExtra("k_version", -1);
      int k = paramIntent.getIntExtra("k_peak_version", -1);
      QLog.e("shua2021_SpringFestivalRedpacketConfigServlet", 1, String.format("handleGetConfigFail reqOccasion=%s reqVersion=%s reqPeakVersion=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) }));
      ((SpringFestivalRedpacketConfigManager)((QQAppInterface)getAppRuntime()).getManager(QQManagerFactory.SPRING_FESTIVAL_RED_PACKET_MANAGER)).a(false, false, j, k, 0, null, null, i, false, 0L);
    }
  }
  
  private byte[] a(byte[] paramArrayOfByte)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      paramArrayOfByte = new InflaterInputStream(new ByteArrayInputStream(paramArrayOfByte));
      byte[] arrayOfByte = new byte[256];
      for (;;)
      {
        int i = paramArrayOfByte.read(arrayOfByte);
        if (-1 == i) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
    }
    catch (Throwable paramArrayOfByte)
    {
      QLog.e("shua2021_SpringFestivalRedpacketConfigServlet", 1, "inflate fail.", paramArrayOfByte);
      return null;
    }
    return paramArrayOfByte;
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("shua2021_SpringFestivalRedpacketConfigServlet", 2, "-->入口配置请求回包 response.isSuccess() = " + paramFromServiceMsg.isSuccess());
    }
    m = 1;
    int i5 = 1;
    i4 = 1;
    i9 = 1;
    int i6 = 1;
    i = 1;
    n = 1;
    int i7 = 1;
    i1 = 1;
    i8 = 1;
    int i10 = 1;
    bool2 = false;
    boolean bool4 = false;
    bool3 = false;
    bool5 = false;
    bool1 = false;
    i3 = 0;
    i2 = 0;
    int i11 = paramIntent.getIntExtra("k_cmd", -1);
    j = paramIntent.getIntExtra("k_id", 0);
    k = paramIntent.getIntExtra("k_version", -1);
    paramIntent.getIntExtra("k_peak_version", -1);
    long l = paramIntent.getLongExtra("key_req_adcode", 0L);
    Object localObject1 = "";
    if (paramFromServiceMsg.isSuccess()) {}
    try
    {
      paramFromServiceMsg = WupUtil.b(paramFromServiceMsg.getWupBuffer());
      switch (i11)
      {
      default: 
        i3 = 0;
        i1 = i10;
        paramFromServiceMsg = (FromServiceMsg)localObject1;
        m = i;
        i2 = k;
        n = j;
        i = i3;
      }
    }
    catch (Throwable paramFromServiceMsg)
    {
      for (;;)
      {
        Object localObject4;
        int i14;
        int i12;
        int i15;
        int i13;
        i = j;
        j = i4;
        bool1 = bool3;
        n = i1;
        i1 = i3;
        continue;
        Object localObject3;
        continue;
        j = 1;
        continue;
        i4 = 0;
        i1 = 0;
        if (i12 != i13)
        {
          bool3 = true;
        }
        else
        {
          for (;;)
          {
            n = i;
            i = 0;
            m = k;
            i1 = j;
            break;
            bool3 = false;
            break label815;
            if ((i15 == 0) && (i14 != i2)) {
              break label963;
            }
            k = i9;
            paramFromServiceMsg = localObject3;
            bool1 = bool5;
            j = i8;
            if (i15 != 0)
            {
              k = i9;
              paramFromServiceMsg = localObject3;
              bool1 = bool5;
              j = i8;
              if (i14 == i2) {
                break label963;
              }
            }
          }
          j = 0;
        }
      }
    }
    k = i2;
    j = i;
    i = n;
    n = i1;
    localObject1 = paramFromServiceMsg;
    label213:
    if ((i11 == 1) && (n != 0))
    {
      paramFromServiceMsg = (QQAppInterface)getAppRuntime();
      if (m == 0) {
        break label1986;
      }
    }
    for (m = 0;; m = 1)
    {
      for (;;)
      {
        SpringHbMonitorReporter.a(paramFromServiceMsg, 1, m, 1011, i, k, true, MD5.toMD5((String)localObject1));
        if ((j != 0) || (bool1))
        {
          bool3 = false;
          bool2 = bool3;
          if (j == 0) {}
        }
        for (;;)
        {
          try
          {
            i = paramIntent.getIntExtra("k_retry", 0);
            bool2 = bool3;
            if (i < 1)
            {
              paramIntent.putExtra("k_retry", i + 1);
              getAppRuntime().startServlet((NewIntent)paramIntent);
              bool2 = true;
            }
            QLog.d("shua2021_SpringFestivalRedpacketConfigServlet", 1, String.format("onReceive CMD_GET_CONFIG doRetry=%b isFallbackFail=%b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) }));
            if ((!bool2) && (bool1)) {
              a(paramIntent);
            }
            return;
          }
          catch (Exception paramIntent)
          {
            SpringFestivalRedpacketConfigManager localSpringFestivalRedpacketConfigManager;
            ConfigurationService.RespGetConfigByPage localRespGetConfigByPage;
            ConfigurationService.PageRespInfo localPageRespInfo;
            Object localObject5;
            SpringHbMonitorReporter.a(304, paramIntent, new String[0]);
            QLog.e("shua2021_SpringFestivalRedpacketConfigServlet", 1, "onReceive fail." + paramIntent.getMessage(), paramIntent);
            return;
          }
          localObject4 = (QQAppInterface)getAppRuntime();
          if (localObject4 != null)
          {
            localSpringFestivalRedpacketConfigManager = (SpringFestivalRedpacketConfigManager)((QQAppInterface)localObject4).getManager(QQManagerFactory.SPRING_FESTIVAL_RED_PACKET_MANAGER);
            localRespGetConfigByPage = new ConfigurationService.RespGetConfigByPage();
            localRespGetConfigByPage.mergeFrom(paramFromServiceMsg);
            i = localRespGetConfigByPage.result.get();
            m = localRespGetConfigByPage.type.get();
            QLog.i("shua2021_SpringFestivalRedpacketConfigServlet", 1, String.format("onReceive CMD_GET_CONFIG result=%s type=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(m) }));
            if (i != 0)
            {
              m = 0;
              bool1 = true;
            }
          }
        }
        try
        {
          SpringHbMonitorReporter.a(2, 2, 1011, j, k, true, new String[] { i + "" });
          i = 1;
          n = j;
          i2 = k;
          paramFromServiceMsg = (FromServiceMsg)localObject1;
          i1 = i10;
        }
        catch (Throwable paramFromServiceMsg)
        {
          for (;;)
          {
            label815:
            label963:
            bool1 = true;
            label1986:
            m = 0;
            paramFromServiceMsg = paramFromServiceMsg;
            i = j;
            i2 = 1;
            j = m;
            n = i1;
            i1 = i2;
          }
        }
      }
      if (m != 1011)
      {
        m = 0;
        bool1 = true;
        SpringHbMonitorReporter.a(2, 2, 1011, j, k, true, new String[] { "type is not 1011" });
        i = 1;
        n = j;
        i2 = k;
        paramFromServiceMsg = (FromServiceMsg)localObject1;
        i1 = i10;
        break;
      }
      i10 = paramIntent.getIntExtra("k_req_occasion", 0);
      i14 = paramIntent.getIntExtra("k_version", -1);
      i12 = paramIntent.getIntExtra("k_peak_version", -1);
      i15 = paramIntent.getIntExtra("k_offset", 0);
      i2 = ((ConfigurationService.PageRespInfo)localRespGetConfigByPage.page_info.get()).version.get();
      i = ((ConfigurationService.PageRespInfo)localRespGetConfigByPage.page_info.get()).task_id.get();
      i13 = localRespGetConfigByPage.stagger_version.get();
      m = i5;
      bool2 = bool4;
      n = i7;
      try
      {
        QLog.i("shua2021_SpringFestivalRedpacketConfigServlet", 1, String.format("onReceive CMD_GET_CONFIG reqOccasion=%s reqVersion=%s reqPeakVersion=%s reqOffset=%s, rspVersion=%s, rspPeakVersion=%s, rspTaskId=%s reqAdcode=%d", new Object[] { Integer.valueOf(i10), Integer.valueOf(i14), Integer.valueOf(i12), Integer.valueOf(i15), Integer.valueOf(i2), Integer.valueOf(i13), Integer.valueOf(i), Long.valueOf(l) }));
        if ((i15 != 0) || (i14 != i2)) {
          break label2238;
        }
        m = i5;
        bool2 = bool4;
        n = i7;
        if (!QLog.isColorLevel()) {
          break label2197;
        }
        m = i5;
        bool2 = bool4;
        n = i7;
        QLog.i("shua2021_SpringFestivalRedpacketConfigServlet", 2, "onReceive CMD_GET_CONFIG no config need update.");
      }
      catch (Throwable paramFromServiceMsg)
      {
        i1 = i3;
        bool1 = bool2;
        j = m;
        k = i2;
      }
      localObject4 = null;
      m = i5;
      bool2 = bool4;
      n = i1;
      if (localRespGetConfigByPage.delay_time.has())
      {
        m = i5;
        bool2 = bool4;
        n = i1;
        localObject4 = (ArrayList)localRespGetConfigByPage.delay_time.get();
      }
      m = i5;
      bool2 = bool4;
      n = i1;
      k = i9;
      paramFromServiceMsg = (FromServiceMsg)localObject1;
      bool1 = bool5;
      j = i4;
      if (localSpringFestivalRedpacketConfigManager.a(false, bool3, i2, i13, i, null, (List)localObject4, i10, true, l)) {
        break label2216;
      }
      m = i5;
      bool2 = bool4;
      n = i1;
      SpringHbMonitorReporter.a(2, 4, 1011, i, i2, true, new String[0]);
      k = i9;
      paramFromServiceMsg = (FromServiceMsg)localObject1;
      bool1 = bool5;
      j = i4;
      break label2216;
      m = i5;
      bool2 = bool4;
      n = i7;
      localPageRespInfo = (ConfigurationService.PageRespInfo)localRespGetConfigByPage.page_info.get();
      m = i5;
      bool2 = bool4;
      n = i7;
      paramFromServiceMsg = paramIntent.getByteArrayExtra("k_buff");
      m = i5;
      bool2 = bool4;
      n = i7;
      localObject4 = localRespGetConfigByPage.content.get().toByteArray();
      if (paramFromServiceMsg == null) {
        break label2298;
      }
      m = i5;
      bool2 = bool4;
      n = i7;
      j = paramFromServiceMsg.length;
      m = i5;
      bool2 = bool4;
      n = i7;
      localObject5 = new ByteArrayBuffer(j + localObject4.length);
      if (paramFromServiceMsg != null)
      {
        m = i5;
        bool2 = bool4;
        n = i7;
        ((ByteArrayBuffer)localObject5).append(paramFromServiceMsg, 0, paramFromServiceMsg.length);
      }
      m = i5;
      bool2 = bool4;
      n = i7;
      ((ByteArrayBuffer)localObject5).append((byte[])localObject4, 0, localObject4.length);
      m = i5;
      bool2 = bool4;
      n = i7;
      localObject4 = ((ByteArrayBuffer)localObject5).buffer();
      m = i5;
      bool2 = bool4;
      n = i7;
      j = localPageRespInfo.next_offset.get();
      if (j == -1)
      {
        m = i5;
        bool2 = bool4;
        n = i7;
        QLog.i("shua2021_SpringFestivalRedpacketConfigServlet", 1, "onReceive CMD_GET_CONFIG no more config to request.");
        m = i5;
        bool2 = bool4;
        n = i7;
        paramFromServiceMsg = localPageRespInfo.md5.get();
        m = i5;
        bool2 = bool4;
        n = i7;
        localObject5 = PortalUtils.a((byte[])localObject4);
        m = i5;
        bool2 = bool4;
        n = i7;
        j = localPageRespInfo.total_size.get();
        if (localObject4 != null)
        {
          m = i5;
          bool2 = bool4;
          n = i7;
          if ((localObject4.length != 0) && (j != 0)) {}
        }
        else
        {
          m = i5;
          bool2 = bool4;
          n = i7;
          QLog.i("shua2021_SpringFestivalRedpacketConfigServlet", 1, "onReceive CMD_GET_CONFIG remote config was cleaned.");
          m = i5;
          bool2 = bool4;
          n = i7;
          localSpringFestivalRedpacketConfigManager.a(true, true, i2, i13, i, null, null, i10, true, l);
          paramFromServiceMsg = "";
          j = 0;
          bool1 = false;
          k = i6;
          break label2295;
        }
        if (j > 0)
        {
          m = i5;
          bool2 = bool4;
          n = i7;
          if (TextUtils.equals((CharSequence)localObject5, paramFromServiceMsg))
          {
            m = i5;
            bool2 = bool4;
            n = i7;
            QLog.i("shua2021_SpringFestivalRedpacketConfigServlet", 1, "onReceive CMD_GET_CONFIG get new config.");
            paramFromServiceMsg = (FromServiceMsg)localObject4;
            m = i5;
            bool2 = bool4;
            n = i7;
            if (localPageRespInfo.compress.get() == 1)
            {
              m = i5;
              bool2 = bool4;
              n = i7;
              paramFromServiceMsg = a((byte[])localObject4);
            }
            if (paramFromServiceMsg != null)
            {
              localObject4 = null;
              m = i5;
              bool2 = bool4;
              n = i7;
              if (localRespGetConfigByPage.delay_time.has())
              {
                m = i5;
                bool2 = bool4;
                n = i7;
                localObject4 = (ArrayList)localRespGetConfigByPage.delay_time.get();
              }
              m = i5;
              bool2 = bool4;
              n = i7;
              paramFromServiceMsg = new String(paramFromServiceMsg, "utf-8");
              if (i12 != i13) {}
              for (bool1 = true;; bool1 = false)
              {
                try
                {
                  bool1 = localSpringFestivalRedpacketConfigManager.a(true, bool1, i2, i13, i, paramFromServiceMsg, (List)localObject4, i10, true, l);
                  if (bool1) {
                    break label2191;
                  }
                  j = 0;
                }
                catch (Throwable localThrowable1)
                {
                  for (;;)
                  {
                    localObject4 = paramFromServiceMsg;
                    paramFromServiceMsg = localThrowable1;
                    k = i2;
                    j = i4;
                    Object localObject2 = localObject4;
                    bool1 = bool3;
                    n = i1;
                    i1 = i3;
                  }
                }
                try
                {
                  SpringHbMonitorReporter.a(2, 4, 1011, i, i2, true, new String[0]);
                  m = 1;
                  k = j;
                  bool1 = false;
                  j = m;
                }
                catch (Throwable localThrowable2)
                {
                  localObject4 = paramFromServiceMsg;
                  j = 0;
                  paramFromServiceMsg = localThrowable2;
                  k = i2;
                  localObject3 = localObject4;
                  bool1 = bool3;
                  n = i1;
                  i1 = i3;
                  break;
                }
              }
            }
            k = 0;
            bool1 = true;
          }
        }
      }
      try
      {
        QLog.e("shua2021_SpringFestivalRedpacketConfigServlet", 1, "onReceive CMD_GET_CONFIG config inflate fail.");
        SpringHbMonitorReporter.a(2, 3, 1011, i, i2, true, new String[0]);
        paramFromServiceMsg = "";
        j = 1;
      }
      catch (Throwable paramFromServiceMsg)
      {
        for (;;)
        {
          j = 0;
          paramFromServiceMsg = paramFromServiceMsg;
          bool1 = true;
          k = i2;
          n = i1;
          i1 = i3;
        }
        i = j;
        bool1 = bool2;
        j = i2;
      }
      k = 0;
      bool1 = true;
      QLog.e("shua2021_SpringFestivalRedpacketConfigServlet", 1, "onReceive CMD_GET_CONFIG config in package invalid?");
      SpringHbMonitorReporter.a(2, 2, 1011, i, i2, true, new String[] { "config in package invalid" });
      paramFromServiceMsg = "";
      j = 1;
      break label2295;
      if (j != 0)
      {
        m = i5;
        bool2 = bool4;
        n = i7;
        QLog.i("shua2021_SpringFestivalRedpacketConfigServlet", 1, "onReceive CMD_GET_CONFIG request more config.");
        m = i5;
        bool2 = bool4;
        n = i7;
        localSpringFestivalRedpacketConfigManager.a(i10, i2, i12, j, localPageRespInfo.task_id.get(), localPageRespInfo.cookies.get().toByteArray(), (byte[])localObject4, l, false);
        return;
        SpringHbMonitorReporter.a(303, paramFromServiceMsg, new String[] { Log.getStackTraceString(paramFromServiceMsg) });
        QLog.e("shua2021_SpringFestivalRedpacketConfigServlet", 1, "onReceive fail " + paramFromServiceMsg.getMessage(), paramFromServiceMsg);
        SpringHbMonitorReporter.a(2, 6, 1011, paramIntent.getIntExtra("k_id", 0), paramIntent.getIntExtra("k_version", 0), true, new String[] { QLog.getStackTraceString(paramFromServiceMsg) });
        m = j;
        j = i1;
        break label213;
      }
      k = 0;
      j = 0;
      bool3 = true;
      bool1 = true;
      m = j;
      bool2 = bool1;
      n = i7;
      QLog.e("shua2021_SpringFestivalRedpacketConfigServlet", 1, "onReceive CMD_GET_CONFIG some thing wrong?");
      m = j;
      bool2 = bool1;
      n = i7;
      SpringHbMonitorReporter.a(2, 2, 1011, i, i2, true, new String[] { "onReceive CMD_GET_CONFIG some thing wrong" });
      paramFromServiceMsg = (FromServiceMsg)localObject1;
      bool1 = bool3;
      j = i8;
      break label2216;
      if (i11 != 1) {
        break label2177;
      }
      i1 = 1;
      bool1 = true;
      n = 0;
      i = j;
      j = i1;
      break label213;
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    int i = paramIntent.getIntExtra("k_cmd", -1);
    int j = paramIntent.getIntExtra("k_retry", 0);
    boolean bool = paramIntent.getBooleanExtra("k_new_page", false);
    QLog.i("shua2021_SpringFestivalRedpacketConfigServlet", 1, String.format("onSend cmd=%s retry=%s newPage=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool) }));
    Object localObject2 = null;
    Object localObject1 = null;
    Object localObject3;
    Object localObject4;
    if ((j == 0) || (bool)) {
      switch (i)
      {
      default: 
        localObject3 = localObject1;
        localObject4 = localObject2;
        if (localObject2 != null)
        {
          localObject3 = localObject1;
          localObject4 = localObject2;
          if (!bool)
          {
            paramIntent.putExtra("k_sso_id", (String)localObject2);
            paramIntent.putExtra("k_sso_data", (byte[])localObject1);
            localObject4 = localObject2;
            localObject3 = localObject1;
          }
        }
        break;
      }
    }
    for (;;)
    {
      if ((localObject4 != null) && (localObject3 != null))
      {
        paramPacket.setSSOCommand((String)localObject4);
        paramPacket.putSendData((byte[])localObject3);
      }
      return;
      i = paramIntent.getIntExtra("k_id", 0);
      j = paramIntent.getIntExtra("k_offset", 0);
      int k = paramIntent.getIntExtra("k_version", 0);
      int m = paramIntent.getIntExtra("k_peak_version", 0);
      long l = paramIntent.getLongExtra("key_req_adcode", 0L);
      localObject2 = paramIntent.getByteArrayExtra("k_cookie");
      QLog.i("shua2021_SpringFestivalRedpacketConfigServlet", 1, String.format("onSend CMD_GET_CONFIG taskId=%s offset=%s version=%s peakVersion=%s cookie=%s adCode=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Arrays.toString((byte[])localObject2), Long.valueOf(l) }));
      localObject1 = new ConfigurationService.PageReqInfo();
      ((ConfigurationService.PageReqInfo)localObject1).task_id.set(i);
      ((ConfigurationService.PageReqInfo)localObject1).offset.set(j);
      ((ConfigurationService.PageReqInfo)localObject1).version.set(k);
      if (localObject2 != null) {
        ((ConfigurationService.PageReqInfo)localObject1).cookies.set(ByteStringMicro.copyFrom((byte[])localObject2));
      }
      localObject3 = new ConfigurationService.Screen();
      ((ConfigurationService.Screen)localObject3).setHasFlag(true);
      ((ConfigurationService.Screen)localObject3).model.set("");
      ((ConfigurationService.Screen)localObject3).width.set((int)DeviceInfoUtil.g());
      ((ConfigurationService.Screen)localObject3).height.set((int)DeviceInfoUtil.h());
      ((ConfigurationService.Screen)localObject3).dpi.set(DeviceInfoUtil.e());
      ((ConfigurationService.Screen)localObject3).multi_touch.set(DeviceInfoUtil.c());
      localObject2 = new ConfigurationService.DeviceInfo();
      ((ConfigurationService.DeviceInfo)localObject2).setHasFlag(true);
      ((ConfigurationService.DeviceInfo)localObject2).screen = ((ConfigurationService.Screen)localObject3);
      localObject3 = new ConfigurationService.ReqGetConfigByPage();
      ((ConfigurationService.ReqGetConfigByPage)localObject3).page_info.set((MessageMicro)localObject1);
      ((ConfigurationService.ReqGetConfigByPage)localObject3).device_info.set((MessageMicro)localObject2);
      ((ConfigurationService.ReqGetConfigByPage)localObject3).type.set(1011);
      ((ConfigurationService.ReqGetConfigByPage)localObject3).adcode.set(l);
      ((ConfigurationService.ReqGetConfigByPage)localObject3).stagger_version.set(m);
      localObject2 = "ConfigurationService.ReqGetConfigByPage";
      localObject1 = WupUtil.a(((ConfigurationService.ReqGetConfigByPage)localObject3).toByteArray());
      break;
      localObject4 = paramIntent.getStringExtra("k_sso_id");
      localObject3 = paramIntent.getByteArrayExtra("k_sso_data");
      paramIntent.putExtra("k_new_page", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.config.SpringFestivalRedpacketConfigServlet
 * JD-Core Version:    0.7.0.1
 */