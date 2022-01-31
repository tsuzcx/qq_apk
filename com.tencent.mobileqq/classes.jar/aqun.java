import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
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

public class aqun
  extends ajfb
{
  protected boolean a;
  
  public aqun(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.CommPluginHandler", 2, "handleBatchGetPluginList");
    }
    Object localObject2 = "";
    boolean bool2;
    Object localObject1;
    int i;
    label85:
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
          break label393;
        }
        i = ((PluginConfig.BatchGetResourceResp)localObject4).errcode.get();
        if (i != 0) {
          break label399;
        }
        bool1 = true;
        label93:
        localObject1 = localObject2;
        try
        {
          if (!((PluginConfig.BatchGetResourceResp)localObject4).errmsg.has()) {
            break label405;
          }
          localObject1 = localObject2;
          paramObject = ((PluginConfig.BatchGetResourceResp)localObject4).errmsg.get();
          label121:
          if (!bool1) {
            break label445;
          }
          localObject1 = paramObject;
          if (!((PluginConfig.BatchGetResourceResp)localObject4).resp_list.has()) {
            break label460;
          }
          localObject1 = paramObject;
          localObject2 = ((PluginConfig.BatchGetResourceResp)localObject4).resp_list.get();
          label153:
          if (localObject2 == null) {
            break label411;
          }
          localObject1 = paramObject;
          if (((List)localObject2).isEmpty()) {
            break label411;
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
              if (((PluginConfig.GetResourceResp)localObject4).plugin_type.get() == 4000)
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
    label393:
    label399:
    label405:
    label411:
    label445:
    label460:
    label466:
    for (;;)
    {
      if ((bool1) && (bool2)) {}
      for (boolean bool3 = true;; bool3 = false)
      {
        if (!bool3) {
          a(false, paramToServiceMsg, paramFromServiceMsg, null);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.lebatab.CommPluginHandler", 2, "handleBatchGetPluginList finalResult:" + bool3 + ",ssoSuc=" + bool2 + ",busiSuc=" + bool1 + ",busiErrCode=" + i + ",errMsg=" + paramObject);
        }
        return;
        bool2 = false;
        break;
        i = -1;
        break label85;
        bool1 = false;
        break label93;
        paramObject = "";
        break label121;
        bool1 = false;
        localObject1 = paramObject;
        QLog.d("Q.lebatab.CommPluginHandler", 1, "handleBatchGetPluginList respInfoList is null");
        break label466;
      }
      break label466;
      i = -1;
      bool1 = false;
      paramObject = localException2;
      continue;
      Object localObject3 = null;
      break label153;
    }
  }
  
  private void a(List<PluginConfig.GetResourceReq> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.CommPluginHandler", 2, "batchGetPluginList");
    }
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "PluginConfig.dynamic_plugin");
    PluginConfig.BatchGetResourceReq localBatchGetResourceReq = new PluginConfig.BatchGetResourceReq();
    localBatchGetResourceReq.req_list.set(paramList);
    localToServiceMsg.putWupBuffer(localBatchGetResourceReq.toByteArray());
    localToServiceMsg.extraData.putString("uin", this.app.getCurrentAccountUin());
    sendPbReq(localToServiceMsg);
  }
  
  private void a(boolean paramBoolean, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, PluginConfig.GetResourceResp paramGetResourceResp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.CommPluginHandler", 2, "handleGetLebaPluginList");
    }
    i = -1;
    paramToServiceMsg = Collections.emptyList();
    Object localObject = Collections.emptyList();
    boolean bool = paramBoolean;
    if ((!paramBoolean) || (paramGetResourceResp != null)) {}
    for (;;)
    {
      try
      {
        if (paramGetResourceResp.plugin_layout.has())
        {
          paramFromServiceMsg = (PluginConfig.PluginLayout)paramGetResourceResp.plugin_layout.get();
          if (paramFromServiceMsg == null) {
            continue;
          }
          if (!paramFromServiceMsg.plugin_layout_seq.has()) {
            continue;
          }
          j = paramFromServiceMsg.plugin_layout_seq.get();
          i = j;
        }
      }
      catch (Exception paramGetResourceResp)
      {
        List localList;
        int m;
        label405:
        label485:
        paramFromServiceMsg = paramToServiceMsg;
        paramToServiceMsg = localException1;
        continue;
        int j = -1;
        paramFromServiceMsg = localException3;
        continue;
      }
      try
      {
        if (paramFromServiceMsg.group_list.has())
        {
          localList = paramFromServiceMsg.group_list.get();
          paramFromServiceMsg = (FromServiceMsg)localObject;
          j = i;
          if (localList == null) {
            continue;
          }
          paramFromServiceMsg = new ArrayList();
          j = 0;
          m = 0;
        }
      }
      catch (Exception paramGetResourceResp)
      {
        paramFromServiceMsg = paramToServiceMsg;
        paramToServiceMsg = localException1;
        continue;
      }
      try
      {
        if (m < localList.size())
        {
          localObject = (PluginConfig.PluginGroup)localList.get(m);
          int k = j;
          if (((PluginConfig.PluginGroup)localObject).has())
          {
            k = j;
            if (((PluginConfig.PluginGroup)localObject).res_id.has())
            {
              localObject = ((PluginConfig.PluginGroup)localObject).res_id.get();
              int n = 0;
              k = j;
              if (n < ((List)localObject).size())
              {
                ajli localajli = new ajli();
                localajli.jdField_a_of_type_Long = ((Integer)((List)localObject).get(n)).intValue();
                localajli.jdField_a_of_type_Int = m;
                j += 1;
                localajli.b = j;
                paramFromServiceMsg.add(localajli);
                n += 1;
                continue;
                paramFromServiceMsg = null;
                continue;
                i = -1;
                continue;
                localList = null;
                continue;
              }
            }
          }
          m += 1;
          j = k;
        }
        else
        {
          j = i;
        }
      }
      catch (Exception localException2)
      {
        paramGetResourceResp = paramToServiceMsg;
        paramToServiceMsg = paramFromServiceMsg;
        paramFromServiceMsg = paramGetResourceResp;
        paramGetResourceResp = localException2;
      }
    }
    try
    {
      localObject = paramGetResourceResp.respinfo_list.get();
      paramGetResourceResp = new ArrayList();
      if (localObject == null) {
        break label485;
      }
      try
      {
        paramToServiceMsg = ((List)localObject).iterator();
        while (paramToServiceMsg.hasNext())
        {
          localObject = LebaPluginInfo.convToLocalPluginInfo((PluginConfig.GetResourceRespInfo)paramToServiceMsg.next());
          if (localObject != null) {
            paramGetResourceResp.add(localObject);
          }
        }
        paramBoolean = false;
      }
      catch (Exception localException1)
      {
        paramToServiceMsg = paramFromServiceMsg;
        paramFromServiceMsg = paramGetResourceResp;
        i = j;
        paramGetResourceResp = localException1;
      }
    }
    catch (Exception localException3)
    {
      i = j;
      paramGetResourceResp = paramToServiceMsg;
      paramToServiceMsg = paramFromServiceMsg;
      paramFromServiceMsg = paramGetResourceResp;
      paramGetResourceResp = localException3;
      break label405;
    }
    QLog.d("Q.lebatab.CommPluginHandler", 1, "handleGetLebaPluginList exp:" + paramGetResourceResp.toString());
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.lebatab.CommPluginHandler", 2, "handleGetLebaPluginList isSuc:" + paramBoolean);
      }
      this.app.a().a(paramBoolean, i, paramToServiceMsg, paramFromServiceMsg);
      return;
      paramToServiceMsg = paramFromServiceMsg;
      paramFromServiceMsg = paramGetResourceResp;
      i = j;
      continue;
      bool = false;
      QLog.d("Q.lebatab.CommPluginHandler", 1, "handleGetLebaPluginList respInfo is null");
      paramFromServiceMsg = paramToServiceMsg;
      paramToServiceMsg = localException1;
      paramBoolean = bool;
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.CommPluginHandler", 2, "getAllPluginList");
    }
    PluginConfig.GetResourceReq localGetResourceReq = this.app.a().a();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localGetResourceReq);
    a(localArrayList);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.CommPluginHandler", 2, "getLebaPluginList");
    }
    PluginConfig.GetResourceReq localGetResourceReq = this.app.a().a();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localGetResourceReq);
    a(localArrayList);
  }
  
  protected boolean msgCmdFilter(String paramString)
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("PluginConfig.dynamic_plugin");
    }
    return !this.allowCmdSet.contains(paramString);
  }
  
  protected Class<? extends ajfe> observerClass()
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
    while (!"PluginConfig.dynamic_plugin".equals(paramFromServiceMsg.getServiceCmd())) {
      return;
    }
    a(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     aqun
 * JD-Core Version:    0.7.0.1
 */