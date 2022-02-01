import android.content.SharedPreferences;
import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppSetting;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.BatchSetSettingReqBody;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.BatchSetSettingRspBody;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import dynamic_plugin_interface.UserDynamicPlugin.ReqGetUserDynamicPlugin;
import dynamic_plugin_interface.UserDynamicPlugin.ReqSetUserDynamicPlugin;
import dynamic_plugin_interface.UserDynamicPlugin.RspGetUserDynamicPlugin;
import dynamic_plugin_interface.UserDynamicPlugin.RspSetUserDynamicPlugin;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.PluginConfig.PluginConfig.BatchGetResourceReq;
import tencent.im.PluginConfig.PluginConfig.BatchGetResourceResp;
import tencent.im.PluginConfig.PluginConfig.GetResourceReq;
import tencent.im.PluginConfig.PluginConfig.GetResourceResp;
import tencent.im.PluginConfig.PluginConfig.GetResourceRespInfo;
import tencent.im.PluginConfig.PluginConfig.PluginGroup;
import tencent.im.PluginConfig.PluginConfig.PluginLayout;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class awcz
  extends BusinessHandler
{
  protected boolean a;
  
  public awcz(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(boolean paramBoolean, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, PluginConfig.GetResourceResp paramGetResourceResp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.CommPluginHandler", 2, "handleGetLebaPluginList");
    }
    int i = -1;
    paramToServiceMsg = Collections.emptyList();
    paramFromServiceMsg = Collections.emptyList();
    int k = -1;
    int j = -1;
    label100:
    label121:
    int m;
    if (paramBoolean)
    {
      if (paramGetResourceResp != null) {}
      for (;;)
      {
        try
        {
          i = paramGetResourceResp.plugin_type.get();
        }
        catch (Exception localException1)
        {
          Object localObject;
          List localList;
          label142:
          int i1;
          label162:
          int n;
          label312:
          label355:
          m = -1;
          label430:
          i = j;
          j = m;
          paramGetResourceResp = paramFromServiceMsg;
          paramFromServiceMsg = localException1;
          continue;
        }
        for (;;)
        {
          try
          {
            if (paramGetResourceResp.plugin_layout.has())
            {
              localObject = (PluginConfig.PluginLayout)paramGetResourceResp.plugin_layout.get();
              if (localObject == null) {
                continue;
              }
              if (!((PluginConfig.PluginLayout)localObject).layout_type.has()) {
                break label312;
              }
              j = ((PluginConfig.PluginLayout)localObject).layout_type.get();
            }
          }
          catch (Exception localException2)
          {
            j = -1;
            paramGetResourceResp = paramFromServiceMsg;
            paramFromServiceMsg = localException2;
            break label430;
            j = -1;
            localFromServiceMsg = paramFromServiceMsg;
            break label355;
          }
          try
          {
            if (((PluginConfig.PluginLayout)localObject).plugin_layout_seq.has()) {
              k = ((PluginConfig.PluginLayout)localObject).plugin_layout_seq.get();
            }
          }
          catch (Exception localException3)
          {
            m = -1;
            k = j;
            j = m;
            paramGetResourceResp = paramFromServiceMsg;
            paramFromServiceMsg = localException3;
            break label430;
          }
        }
        for (;;)
        {
          try
          {
            if (((PluginConfig.PluginLayout)localObject).group_list.has())
            {
              localList = ((PluginConfig.PluginLayout)localObject).group_list.get();
              if (localList == null) {
                continue;
              }
              localObject = new ArrayList();
              m = 0;
              i1 = 0;
            }
          }
          catch (Exception localException4)
          {
            m = k;
            k = j;
            j = m;
            paramGetResourceResp = paramFromServiceMsg;
            paramFromServiceMsg = localException4;
            break label430;
            m = k;
            k = j;
            localFromServiceMsg = paramFromServiceMsg;
            j = m;
            break label355;
          }
          try
          {
            if (i1 < localList.size())
            {
              paramFromServiceMsg = (PluginConfig.PluginGroup)localList.get(i1);
              n = m;
              if (paramFromServiceMsg.has())
              {
                n = m;
                if (paramFromServiceMsg.res_id.has())
                {
                  paramFromServiceMsg = paramFromServiceMsg.res_id.get();
                  int i2 = 0;
                  for (;;)
                  {
                    n = m;
                    if (i2 >= paramFromServiceMsg.size()) {
                      break;
                    }
                    anxm localanxm = new anxm();
                    localanxm.jdField_a_of_type_Long = ((Integer)paramFromServiceMsg.get(i2)).intValue();
                    localanxm.jdField_a_of_type_Int = i1;
                    m += 1;
                    localanxm.b = m;
                    ((List)localObject).add(localanxm);
                    i2 += 1;
                  }
                  localObject = null;
                  break;
                  j = -1;
                  break label100;
                  k = -1;
                  break label121;
                  localList = null;
                  break label142;
                }
              }
              i1 += 1;
              m = n;
              break label162;
            }
            m = j;
            j = k;
            k = m;
          }
          catch (Exception paramFromServiceMsg)
          {
            paramGetResourceResp = localException4;
            m = k;
            k = j;
            j = m;
            break label430;
          }
        }
      }
      try
      {
        paramFromServiceMsg = paramGetResourceResp.respinfo_list.get();
        paramGetResourceResp = new ArrayList();
        if (paramFromServiceMsg == null) {
          break label586;
        }
        try
        {
          paramToServiceMsg = paramFromServiceMsg.iterator();
          while (paramToServiceMsg.hasNext())
          {
            paramFromServiceMsg = LebaPluginInfo.convToLocalPluginInfo((PluginConfig.GetResourceRespInfo)paramToServiceMsg.next());
            if (paramFromServiceMsg != null) {
              paramGetResourceResp.add(paramFromServiceMsg);
            }
          }
          QLog.d("Q.lebatab.CommPluginHandler", 1, "handleGetLebaPluginList exp:" + paramFromServiceMsg.toString());
        }
        catch (Exception paramFromServiceMsg)
        {
          paramToServiceMsg = paramGetResourceResp;
          paramGetResourceResp = (PluginConfig.GetResourceResp)localObject;
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        paramGetResourceResp = localException4;
        break label430;
      }
      m = k;
      paramBoolean = false;
      k = i;
      i = m;
      paramFromServiceMsg = paramGetResourceResp;
    }
    for (;;)
    {
      if (paramToServiceMsg != null)
      {
        m = paramToServiceMsg.size();
        label487:
        if (paramFromServiceMsg == null) {
          break label642;
        }
      }
      label642:
      for (n = paramFromServiceMsg.size();; n = 0)
      {
        QLog.d("Q.lebatab.CommPluginHandler", 1, new Object[] { "handleGetLebaPluginList isSuc:", Boolean.valueOf(paramBoolean), ", resultInfos.size=", Integer.valueOf(m), ", groupList.size=", Integer.valueOf(n) });
        this.app.getLebaHelper().a(paramBoolean, j, paramFromServiceMsg, paramToServiceMsg, i, k);
        this.app.getLebaHelper().a(this.app, paramBoolean, k);
        return;
        label586:
        m = i;
        paramFromServiceMsg = (FromServiceMsg)localObject;
        paramToServiceMsg = paramGetResourceResp;
        i = j;
        j = m;
        for (;;)
        {
          m = j;
          j = i;
          i = k;
          k = m;
          break;
          paramBoolean = false;
          QLog.d("Q.lebatab.CommPluginHandler", 1, "handleGetLebaPluginList respInfo is null");
        }
        m = 0;
        break label487;
      }
      FromServiceMsg localFromServiceMsg;
      k = -1;
      j = -1;
      i = -1;
    }
  }
  
  public void a()
  {
    PluginConfig.GetResourceReq localGetResourceReq = this.app.getLebaHelper().a();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localGetResourceReq);
    a(localArrayList);
    b();
    boolean bool = anxo.a(this.app);
    QLog.i("Q.lebatab.CommPluginHandler", 1, "getAllPluginList isNeedReqHasClosedFlag" + bool);
    if (bool) {
      a(true);
    }
  }
  
  public void a(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = null;
    int i = 0;
    boolean bool2 = false;
    boolean bool1 = false;
    StringBuilder localStringBuilder = new StringBuilder("handleGetPluginUserSort ");
    if ((paramFromServiceMsg == null) || (paramObject == null)) {
      localStringBuilder.append("res == null || data == null");
    }
    for (;;)
    {
      localStringBuilder.append(", isSuc=").append(bool1);
      QLog.i("leba_sort", 1, localStringBuilder.toString());
      if (this.app == null) {
        break label322;
      }
      this.app.getLebaHelper().a(bool1);
      return;
      if (paramFromServiceMsg.isSuccess()) {
        break;
      }
      localStringBuilder.append(paramFromServiceMsg.getResultCode()).append("|").append(paramFromServiceMsg.getRequestSsoSeq());
    }
    label322:
    label339:
    for (paramFromServiceMsg = new UserDynamicPlugin.RspGetUserDynamicPlugin();; paramFromServiceMsg = null) {
      for (;;)
      {
        for (;;)
        {
          try
          {
            paramObject = (UserDynamicPlugin.RspGetUserDynamicPlugin)paramFromServiceMsg.mergeFrom((byte[])paramObject);
            if (!paramObject.ret.has()) {
              break label339;
            }
            paramFromServiceMsg = Integer.valueOf(paramObject.ret.get());
            if (paramFromServiceMsg != null)
            {
              int j = paramFromServiceMsg.intValue();
              if (j == 0)
              {
                l = 0L;
                paramFromServiceMsg = localObject;
              }
            }
          }
          catch (Exception paramFromServiceMsg)
          {
            long l;
            bool1 = bool2;
          }
          try
          {
            if (paramObject.plugin_id.has()) {
              paramFromServiceMsg = paramObject.plugin_id.get();
            }
            if (paramObject.last_time.has()) {
              l = paramObject.last_time.get();
            }
            if (paramObject.plugin_type.has()) {
              i = paramObject.plugin_type.get();
            }
            a(paramFromServiceMsg, l, i, localStringBuilder);
            localStringBuilder.append(" info = ").append(paramFromServiceMsg).append(" lastTime = ").append(l).append(" pluginType = ").append(i);
            bool1 = true;
          }
          catch (Exception paramFromServiceMsg)
          {
            for (;;)
            {
              bool1 = true;
            }
          }
        }
        localStringBuilder.append("ret = ").append(paramFromServiceMsg);
        bool1 = false;
        continue;
        QLog.i("leba_sort", 1, "handleGetPluginUserSort", paramFromServiceMsg);
        break;
        QLog.i("leba_sort", 1, "handleGetPluginUserSort app == null");
        return;
      }
    }
  }
  
  protected void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.CommPluginHandler", 2, "handleBatchGetPluginList");
    }
    Object localObject2 = "";
    boolean bool2;
    Object localObject1;
    int i;
    label87:
    boolean bool1;
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null) && (paramObject != null))
    {
      bool2 = true;
      if (bool2) {
        localObject1 = new PluginConfig.BatchGetResourceResp();
      }
    }
    else
    {
      try
      {
        Object localObject4 = (PluginConfig.BatchGetResourceResp)((PluginConfig.BatchGetResourceResp)localObject1).mergeFrom((byte[])paramObject);
        if (!((PluginConfig.BatchGetResourceResp)localObject4).errcode.has()) {
          break label423;
        }
        i = ((PluginConfig.BatchGetResourceResp)localObject4).errcode.get();
        if (i != 0) {
          break label429;
        }
        bool1 = true;
        label95:
        localObject1 = localObject2;
        try
        {
          if (!((PluginConfig.BatchGetResourceResp)localObject4).errmsg.has()) {
            break label435;
          }
          localObject1 = localObject2;
          paramObject = ((PluginConfig.BatchGetResourceResp)localObject4).errmsg.get();
          label123:
          if (!bool1) {
            break label478;
          }
          localObject1 = paramObject;
          if (!((PluginConfig.BatchGetResourceResp)localObject4).resp_list.has()) {
            break label493;
          }
          localObject1 = paramObject;
          localObject2 = ((PluginConfig.BatchGetResourceResp)localObject4).resp_list.get();
          label155:
          if (localObject2 == null) {
            break label442;
          }
          localObject1 = paramObject;
          if (((List)localObject2).isEmpty()) {
            break label442;
          }
          localObject1 = paramObject;
          localObject2 = ((List)localObject2).iterator();
          for (;;)
          {
            localObject1 = paramObject;
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            localObject1 = paramObject;
            localObject4 = (PluginConfig.GetResourceResp)((Iterator)localObject2).next();
            if (localObject4 != null)
            {
              localObject1 = paramObject;
              if (((PluginConfig.GetResourceResp)localObject4).plugin_type.get() != 4000)
              {
                localObject1 = paramObject;
                if (((PluginConfig.GetResourceResp)localObject4).plugin_type.get() != 4026) {}
              }
              else
              {
                localObject1 = paramObject;
                a(true, paramToServiceMsg, paramFromServiceMsg, (PluginConfig.GetResourceResp)localObject4);
              }
            }
          }
          QLog.d("Q.lebatab.CommPluginHandler", 1, "handleBatchGetPluginList exp:" + ((Exception)localObject1).toString());
        }
        catch (Exception localException2)
        {
          paramObject = localObject1;
          localObject1 = localException2;
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          i = -1;
          paramObject = "";
        }
      }
      bool1 = false;
    }
    label423:
    label429:
    label435:
    label442:
    label478:
    label493:
    label499:
    for (;;)
    {
      if ((bool1) && (bool2)) {}
      for (boolean bool3 = true;; bool3 = false)
      {
        if (!bool3) {
          a(false, paramToServiceMsg, paramFromServiceMsg, null);
        }
        QLog.d("Q.lebatab.CommPluginHandler", 1, new Object[] { "handleBatchGetPluginList finalResult:", Boolean.valueOf(bool3), ",ssoSuc=", Boolean.valueOf(bool2), ",busiSuc=", Boolean.valueOf(bool1), ",busiErrCode=", Integer.valueOf(i), ",errMsg=", paramObject });
        return;
        bool2 = false;
        break;
        i = -1;
        break label87;
        bool1 = false;
        break label95;
        paramObject = "";
        break label123;
        bool1 = false;
        localObject1 = paramObject;
        QLog.d("Q.lebatab.CommPluginHandler", 1, "handleBatchGetPluginList respInfoList is null");
        break label499;
      }
      break label499;
      i = -1;
      bool1 = false;
      paramObject = localException2;
      continue;
      Object localObject3 = null;
      break label155;
    }
  }
  
  public void a(ArrayList<BusinessInfoCheckUpdate.AppSetting> paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    BusinessInfoCheckUpdate.BatchSetSettingReqBody localBatchSetSettingReqBody = new BusinessInfoCheckUpdate.BatchSetSettingReqBody();
    StringBuilder localStringBuilder = new StringBuilder("batchClosePlugin ");
    if (this.app == null) {
      localStringBuilder.append(",app == null");
    }
    for (;;)
    {
      localBatchSetSettingReqBody.uiClientPlatID.set(109);
      localBatchSetSettingReqBody.sClientVer.set("8.4.10.4875");
      localBatchSetSettingReqBody.rptSetting.addAll(paramArrayList);
      paramArrayList = createToServiceMsg("RedTouchSvc.BatchSetSetting");
      paramArrayList.putWupBuffer(localBatchSetSettingReqBody.toByteArray());
      sendPbReq(paramArrayList);
      QLog.i("leba_study", 1, localStringBuilder.toString());
      return;
      String str = this.app.getCurrentAccountUin();
      try
      {
        localBatchSetSettingReqBody.uiUin.set(Long.parseLong(str));
      }
      catch (Exception localException)
      {
        QLog.e("Q.lebatab.CommPluginHandler", 1, localException, new Object[0]);
      }
    }
  }
  
  protected void a(List<PluginConfig.GetResourceReq> paramList)
  {
    QLog.i("Q.lebatab.CommPluginHandler", 1, "batchGetPluginList");
    if ((paramList == null) || (paramList.isEmpty()))
    {
      QLog.i("Q.lebatab.CommPluginHandler", 1, "batchGetPluginList return for req_list is empty");
      return;
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "PluginConfig.dynamic_plugin");
    PluginConfig.BatchGetResourceReq localBatchGetResourceReq = new PluginConfig.BatchGetResourceReq();
    localBatchGetResourceReq.req_list.set(paramList);
    localToServiceMsg.putWupBuffer(localBatchGetResourceReq.toByteArray());
    localToServiceMsg.extraData.putString("uin", this.app.getCurrentAccountUin());
    sendPbReq(localToServiceMsg);
  }
  
  public void a(List<Integer> paramList, long paramLong, int paramInt)
  {
    String str = "";
    Object localObject = new StringBuilder("setPluginUserSort data= ").append(paramList).append(",time=").append(paramLong).append(",type=").append(paramInt);
    if (this.app == null) {
      ((StringBuilder)localObject).append(" app == null");
    }
    for (;;)
    {
      QLog.i("leba_sort", 1, ((StringBuilder)localObject).toString());
      localObject = new ToServiceMsg("mobileqq.service", str, "DynamicPluginSvc.SetList");
      UserDynamicPlugin.ReqSetUserDynamicPlugin localReqSetUserDynamicPlugin = new UserDynamicPlugin.ReqSetUserDynamicPlugin();
      localReqSetUserDynamicPlugin.plugin_id.set(paramList);
      localReqSetUserDynamicPlugin.last_time.set((int)paramLong);
      localReqSetUserDynamicPlugin.plugin_type.set(paramInt);
      ((ToServiceMsg)localObject).putWupBuffer(localReqSetUserDynamicPlugin.toByteArray());
      ((ToServiceMsg)localObject).extraData.putString("uin", str);
      sendPbReq((ToServiceMsg)localObject);
      return;
      str = this.app.getCurrentAccountUin();
    }
  }
  
  public void a(List<Integer> paramList, long paramLong, int paramInt, StringBuilder paramStringBuilder)
  {
    if (this.app == null) {
      paramStringBuilder.append(" app == null");
    }
    long l;
    do
    {
      return;
      l = anxo.a(this.app, paramInt);
      paramStringBuilder.append(" localTime = ").append(l);
      if (paramLong >= l)
      {
        SharedPreferences localSharedPreferences = this.app.getPreferences();
        Object localObject = paramList;
        if (paramList == null) {
          localObject = new ArrayList();
        }
        anxo.a(localSharedPreferences, (List)localObject, Long.valueOf(paramLong), paramInt);
        paramStringBuilder.append(" saveUserSortInfo");
        return;
      }
      paramList = anxo.a(this.app, paramInt);
    } while ((paramList == null) || (paramList.isEmpty()));
    a(paramList, l, paramInt);
    paramStringBuilder.append(" setPluginUserSort, localSort = ").append(paramList);
  }
  
  public void a(boolean paramBoolean)
  {
    long l1 = 0L;
    Object localObject1 = new StringBuilder("setHasClosePluginFlag hasClose").append(paramBoolean);
    Object localObject2;
    if (this.app == null)
    {
      ((StringBuilder)localObject1).append(" app == null");
      QLog.i("leba_study", 1, ((StringBuilder)localObject1).toString());
      localObject1 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1279);
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(9);
      localObject2 = ByteBuffer.allocate(13);
      if (!paramBoolean) {
        break label206;
      }
    }
    label206:
    for (short s = 1;; s = 0)
    {
      for (;;)
      {
        ((ByteBuffer)localObject2).putInt(bhbx.a(l1)).put((byte)0).putShort((short)1).putShort((short)-23054).putShort((short)2).putShort(s);
        ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject2).array()));
        localObject2 = createToServiceMsg("OidbSvc.0x4ff_42482");
        ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
        ((ToServiceMsg)localObject2).setTimeout(30000L);
        sendPbReq((ToServiceMsg)localObject2);
        return;
        try
        {
          long l2 = Long.parseLong(this.app.getCurrentAccountUin());
          l1 = l2;
        }
        catch (Exception localException)
        {
          QLog.i("leba_study", 1, "setHasClosePluginFlag", localException);
        }
      }
      break;
    }
  }
  
  public boolean a(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = false;
    StringBuilder localStringBuilder = new StringBuilder("handleSetPluginUserSort ");
    if ((paramFromServiceMsg == null) || (paramObject == null)) {
      localStringBuilder.append("res == null || data == null");
    }
    for (;;)
    {
      localStringBuilder.append(", isSuc=").append(bool);
      QLog.i("leba_sort", 1, localStringBuilder.toString());
      return bool;
      if (!paramFromServiceMsg.isSuccess()) {
        localStringBuilder.append(paramFromServiceMsg.getResultCode()).append("|").append(paramFromServiceMsg.getRequestSsoSeq());
      } else {
        for (paramFromServiceMsg = new UserDynamicPlugin.RspSetUserDynamicPlugin();; paramFromServiceMsg = null)
        {
          try
          {
            paramFromServiceMsg = (UserDynamicPlugin.RspSetUserDynamicPlugin)paramFromServiceMsg.mergeFrom((byte[])paramObject);
            if (!paramFromServiceMsg.ret.has()) {
              continue;
            }
            paramFromServiceMsg = Integer.valueOf(paramFromServiceMsg.ret.get());
            if ((paramFromServiceMsg != null) && (paramFromServiceMsg.intValue() == 0))
            {
              bool = true;
            }
            else
            {
              localStringBuilder.append("ret = ").append(paramFromServiceMsg);
              bool = false;
            }
          }
          catch (Exception paramFromServiceMsg)
          {
            QLog.i("leba_sort", 1, "handleGetPluginUserSort", paramFromServiceMsg);
          }
          break;
        }
      }
    }
  }
  
  public void b()
  {
    int i;
    String str;
    Object localObject;
    if (bdvn.a())
    {
      i = 4026;
      str = "";
      localObject = new StringBuilder("getPluginUserSort pluginType = ").append(i);
      if (this.app != null) {
        break label129;
      }
      ((StringBuilder)localObject).append(" app == null");
    }
    for (;;)
    {
      QLog.i("leba_sort", 1, ((StringBuilder)localObject).toString());
      localObject = new ToServiceMsg("mobileqq.service", str, "DynamicPluginSvc.GetList");
      UserDynamicPlugin.ReqGetUserDynamicPlugin localReqGetUserDynamicPlugin = new UserDynamicPlugin.ReqGetUserDynamicPlugin();
      localReqGetUserDynamicPlugin.platform.set(2);
      localReqGetUserDynamicPlugin.plugin_type.set(i);
      ((ToServiceMsg)localObject).putWupBuffer(localReqGetUserDynamicPlugin.toByteArray());
      ((ToServiceMsg)localObject).extraData.putString("uin", str);
      sendPbReq((ToServiceMsg)localObject);
      return;
      i = 4000;
      break;
      label129:
      str = this.app.getCurrentAccountUin();
    }
  }
  
  public boolean b(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder("handleGetHasClosePluginFlag ");
    if ((paramFromServiceMsg == null) || (paramObject == null))
    {
      localStringBuilder.append("res == null || data == null");
      QLog.i("leba_study", 1, localStringBuilder.toString());
      return false;
    }
    localStringBuilder.append("resCode = ").append(paramFromServiceMsg.getResultCode()).append(",resSso = ").append(paramFromServiceMsg.getRequestSsoSeq());
    if (!paramFromServiceMsg.isSuccess())
    {
      localStringBuilder.append("|res failed");
      QLog.i("leba_study", 1, localStringBuilder.toString());
      return false;
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if (paramFromServiceMsg.uint32_result.get() == 0)
        {
          i = 1;
          paramObject = paramFromServiceMsg.str_error_msg.get();
          localStringBuilder.append(",ssoResult = ").append(paramFromServiceMsg.uint32_result.get()).append(",resError = ").append(paramObject);
          if ((i == 0) || (!paramFromServiceMsg.bytes_bodybuffer.has()) || (paramFromServiceMsg.bytes_bodybuffer.get() == null))
          {
            localStringBuilder.append(",sso failed");
            QLog.i("leba_study", 1, localStringBuilder.toString());
            return false;
          }
          paramObject = new oidb_0x5eb.RspBody();
          paramObject.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
          if (paramObject.rpt_msg_uin_data.size() <= 0)
          {
            localStringBuilder.append(",sso failed rpt_msg_uin_data erroe");
            QLog.i("leba_study", 1, localStringBuilder.toString());
            return false;
          }
          if (this.app == null)
          {
            localStringBuilder.append(",sso failed app == null");
            QLog.i("leba_study", 1, localStringBuilder.toString());
            return false;
          }
          i = ((oidb_0x5eb.UdcUinData)paramObject.rpt_msg_uin_data.get(0)).uint32_has_close_leba_youth_mode_plugin.get();
          localStringBuilder.append(",sso success");
          localStringBuilder.append(",flag=").append(i);
          boolean bool1;
          if (i == 1)
          {
            bool1 = true;
            paramFromServiceMsg = this.app;
            if (bool1)
            {
              i = 2;
              anxo.b(paramFromServiceMsg, i);
              boolean bool3 = anxo.a(anxo.d(this.app));
              paramFromServiceMsg = this.app.getLebaHelper();
              paramObject = localStringBuilder.append(",hasClose=").append(bool1).append(",isStudyModel=").append(bool3).append(",helper=");
              if (paramFromServiceMsg == null) {
                continue;
              }
              bool2 = true;
              paramObject.append(bool2);
              if ((!bool1) && (bool3) && (paramFromServiceMsg != null)) {
                paramFromServiceMsg.a(this.app);
              }
              QLog.i("leba_study", 1, localStringBuilder.toString());
              return true;
            }
          }
          else
          {
            bool1 = false;
            continue;
          }
          i = 1;
          continue;
          boolean bool2 = false;
          continue;
        }
        int i = 0;
      }
      catch (Exception paramFromServiceMsg)
      {
        QLog.i("leba_study", 1, "handleGetPluginUserSort", paramFromServiceMsg);
        return false;
      }
    }
  }
  
  public void c()
  {
    Object localObject = new oidb_0x5eb.ReqBody();
    String str = "";
    StringBuilder localStringBuilder = new StringBuilder("getHasClosePluginFlag");
    if (this.app == null) {
      localStringBuilder.append(" app == null");
    }
    for (;;)
    {
      ((oidb_0x5eb.ReqBody)localObject).uint32_has_close_leba_youth_mode_plugin.set(1);
      QLog.i("leba_study", 1, localStringBuilder.toString());
      localObject = makeOIDBPkg("OidbSvc.0x5eb_42482", 1515, 22, ((oidb_0x5eb.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).addAttribute("uin", str);
      sendPbReq((ToServiceMsg)localObject);
      return;
      str = this.app.getCurrentAccountUin();
      try
      {
        long l = Long.parseLong(str);
        ((oidb_0x5eb.ReqBody)localObject).rpt_uint64_uins.add(Long.valueOf(l));
      }
      catch (Exception localException)
      {
        QLog.i("leba_study", 1, "getHasClosePluginFlag", localException);
      }
    }
  }
  
  public boolean c(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder("handleSetHasClosePluginFlag ");
    if ((paramFromServiceMsg == null) || (paramObject == null))
    {
      localStringBuilder.append("res == null || data == null");
      QLog.i("leba_study", 1, localStringBuilder.toString());
      return false;
    }
    localStringBuilder.append(",resCode = ").append(paramFromServiceMsg.getResultCode()).append(",resSso = ").append(paramFromServiceMsg.getRequestSsoSeq());
    if (!paramFromServiceMsg.isSuccess())
    {
      localStringBuilder.append(",res failed");
      QLog.i("leba_study", 1, localStringBuilder.toString());
      return false;
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if (paramFromServiceMsg.uint32_result.get() == 0)
        {
          i = 1;
          paramObject = paramFromServiceMsg.str_error_msg.get();
          localStringBuilder.append("ssoResult = ").append(paramFromServiceMsg.uint32_result.get()).append(",resError = ").append(paramObject);
          if ((i == 0) || (!paramFromServiceMsg.bytes_bodybuffer.has()) || (paramFromServiceMsg.bytes_bodybuffer.get() == null))
          {
            localStringBuilder.append(",sso failed");
            QLog.i("leba_study", 1, localStringBuilder.toString());
            return false;
          }
          anxo.a(this.app, false);
          localStringBuilder.append(",sso success");
          QLog.i("leba_study", 1, localStringBuilder.toString());
          return true;
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        QLog.i("leba_study", 1, "handleSetHasClosePluginFlag", paramFromServiceMsg);
        return false;
      }
      int i = 0;
    }
  }
  
  public boolean d(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder("handleBatchClosePlugin ");
    if ((paramFromServiceMsg == null) || (paramObject == null))
    {
      localStringBuilder.append("res == null || data == null");
      QLog.i("leba_study", 1, localStringBuilder.toString());
      return false;
    }
    localStringBuilder.append(",resCode = ").append(paramFromServiceMsg.getResultCode());
    if (!paramFromServiceMsg.isSuccess())
    {
      localStringBuilder.append(",res failed");
      QLog.i("leba_study", 1, localStringBuilder.toString());
      return false;
    }
    try
    {
      paramFromServiceMsg = (BusinessInfoCheckUpdate.BatchSetSettingRspBody)new BusinessInfoCheckUpdate.BatchSetSettingRspBody().mergeFrom((byte[])paramObject);
      int i = paramFromServiceMsg.iResult.get();
      paramFromServiceMsg = paramFromServiceMsg.sErrMsg.get();
      localStringBuilder.append(",resultCode = ").append(i).append(",resError = ").append(paramFromServiceMsg);
      if (i != 0)
      {
        localStringBuilder.append(",rspBody failed");
        QLog.i("leba_study", 1, localStringBuilder.toString());
        return false;
      }
      if (this.app == null) {
        localStringBuilder.append(",app == null");
      }
      for (;;)
      {
        localStringBuilder.append(",rspBody success");
        QLog.i("leba_study", 1, localStringBuilder.toString());
        return true;
        this.app.getLebaHelper().b(this.app);
      }
      return false;
    }
    catch (Exception paramFromServiceMsg)
    {
      QLog.i("leba_study", 1, "handleBatchClosePlugin", paramFromServiceMsg);
    }
  }
  
  public boolean msgCmdFilter(String paramString)
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("PluginConfig.dynamic_plugin");
      this.allowCmdSet.add("DynamicPluginSvc.GetList");
      this.allowCmdSet.add("DynamicPluginSvc.SetList");
      this.allowCmdSet.add("OidbSvc.0x5eb_42482");
      this.allowCmdSet.add("OidbSvc.0x4ff_42482");
      this.allowCmdSet.add("RedTouchSvc.BatchSetSetting");
    }
    return !this.allowCmdSet.contains(paramString);
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return null;
  }
  
  public void onDestroy()
  {
    this.a = true;
    super.onDestroy();
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null) || (msgCmdFilter(paramFromServiceMsg.getServiceCmd()))) {
      QLog.d("Q.lebatab.CommPluginHandler", 1, "req or res is null");
    }
    String str;
    do
    {
      return;
      str = paramFromServiceMsg.getServiceCmd();
      if ("PluginConfig.dynamic_plugin".equals(str))
      {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("DynamicPluginSvc.GetList".equals(str))
      {
        a(paramFromServiceMsg, paramObject);
        return;
      }
      if ("DynamicPluginSvc.SetList".equals(str))
      {
        a(paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x5eb_42482".equals(str))
      {
        b(paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x4ff_42482".equals(str))
      {
        c(paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"RedTouchSvc.BatchSetSetting".equals(str));
    d(paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awcz
 * JD-Core Version:    0.7.0.1
 */