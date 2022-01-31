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

public class arpj
  extends ajtd
{
  protected boolean a;
  
  public arpj(QQAppInterface paramQQAppInterface)
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
          break label398;
        }
        i = ((PluginConfig.BatchGetResourceResp)localObject4).errcode.get();
        if (i != 0) {
          break label404;
        }
        bool1 = true;
        label93:
        localObject1 = localObject2;
        try
        {
          if (!((PluginConfig.BatchGetResourceResp)localObject4).errmsg.has()) {
            break label410;
          }
          localObject1 = localObject2;
          paramObject = ((PluginConfig.BatchGetResourceResp)localObject4).errmsg.get();
          label121:
          if (!bool1) {
            break label450;
          }
          localObject1 = paramObject;
          if (!((PluginConfig.BatchGetResourceResp)localObject4).resp_list.has()) {
            break label465;
          }
          localObject1 = paramObject;
          localObject2 = ((PluginConfig.BatchGetResourceResp)localObject4).resp_list.get();
          label153:
          if (localObject2 == null) {
            break label416;
          }
          localObject1 = paramObject;
          if (((List)localObject2).isEmpty()) {
            break label416;
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
    label398:
    label404:
    label410:
    label416:
    label450:
    label465:
    label471:
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
        break label85;
        bool1 = false;
        break label93;
        paramObject = "";
        break label121;
        bool1 = false;
        localObject1 = paramObject;
        QLog.d("Q.lebatab.CommPluginHandler", 1, "handleBatchGetPluginList respInfoList is null");
        break label471;
      }
      break label471;
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
  
  private void a(boolean paramBoolean, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, PluginConfig.GetResourceResp paramGetResourceResp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.CommPluginHandler", 2, "handleGetLebaPluginList");
    }
    int i = -1;
    Object localObject = Collections.emptyList();
    paramToServiceMsg = Collections.emptyList();
    int j = -1;
    if (paramBoolean)
    {
      if (paramGetResourceResp != null) {}
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
            if (!paramFromServiceMsg.layout_type.has()) {
              continue;
            }
            j = paramFromServiceMsg.layout_type.get();
          }
        }
        catch (Exception paramFromServiceMsg)
        {
          ArrayList localArrayList;
          int n;
          int m;
          label426:
          j = -1;
          i = -1;
          continue;
          int k = -1;
          i = j;
          j = k;
          continue;
        }
        try
        {
          if (paramFromServiceMsg.plugin_layout_seq.has()) {
            i = paramFromServiceMsg.plugin_layout_seq.get();
          }
        }
        catch (Exception paramFromServiceMsg)
        {
          i = -1;
          continue;
        }
        try
        {
          if (paramFromServiceMsg.group_list.has())
          {
            paramFromServiceMsg = paramFromServiceMsg.group_list.get();
            if (paramFromServiceMsg == null) {
              continue;
            }
            localArrayList = new ArrayList();
            k = 0;
            n = 0;
          }
        }
        catch (Exception paramFromServiceMsg)
        {
          continue;
          k = i;
          i = j;
          j = k;
          continue;
        }
        try
        {
          if (n < paramFromServiceMsg.size())
          {
            paramToServiceMsg = (PluginConfig.PluginGroup)paramFromServiceMsg.get(n);
            m = k;
            if (paramToServiceMsg.has())
            {
              m = k;
              if (paramToServiceMsg.res_id.has())
              {
                paramToServiceMsg = paramToServiceMsg.res_id.get();
                int i1 = 0;
                m = k;
                if (i1 < paramToServiceMsg.size())
                {
                  ajzp localajzp = new ajzp();
                  localajzp.jdField_a_of_type_Long = ((Integer)paramToServiceMsg.get(i1)).intValue();
                  localajzp.jdField_a_of_type_Int = n;
                  k += 1;
                  localajzp.b = k;
                  localArrayList.add(localajzp);
                  i1 += 1;
                  continue;
                  paramFromServiceMsg = null;
                  continue;
                  j = -1;
                  continue;
                  i = -1;
                  continue;
                  paramFromServiceMsg = null;
                  continue;
                }
              }
            }
            n += 1;
            k = m;
          }
          else
          {
            k = j;
            paramToServiceMsg = localArrayList;
            j = i;
            i = k;
          }
        }
        catch (Exception paramFromServiceMsg)
        {
          paramToServiceMsg = localArrayList;
        }
      }
      try
      {
        paramGetResourceResp = paramGetResourceResp.respinfo_list.get();
        paramFromServiceMsg = new ArrayList();
        if (paramGetResourceResp == null) {
          break label554;
        }
        try
        {
          paramGetResourceResp = paramGetResourceResp.iterator();
          while (paramGetResourceResp.hasNext())
          {
            localObject = LebaPluginInfo.convToLocalPluginInfo((PluginConfig.GetResourceRespInfo)paramGetResourceResp.next());
            if (localObject != null) {
              paramFromServiceMsg.add(localObject);
            }
          }
          QLog.d("Q.lebatab.CommPluginHandler", 1, "handleGetLebaPluginList exp:" + paramFromServiceMsg.toString());
        }
        catch (Exception paramGetResourceResp)
        {
          k = j;
          j = i;
          localObject = paramFromServiceMsg;
          i = k;
          paramFromServiceMsg = paramGetResourceResp;
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        k = i;
        i = j;
        j = k;
        break label426;
      }
      paramBoolean = false;
    }
    for (;;)
    {
      if (localObject != null)
      {
        k = ((List)localObject).size();
        label471:
        if (paramToServiceMsg == null) {
          break label598;
        }
      }
      label554:
      label598:
      for (m = paramToServiceMsg.size();; m = 0)
      {
        QLog.d("Q.lebatab.CommPluginHandler", 1, new Object[] { "handleGetLebaPluginList isSuc:", Boolean.valueOf(paramBoolean), ", resultInfos.size=", Integer.valueOf(k), ", groupList.size=", Integer.valueOf(m) });
        this.app.a().a(paramBoolean, i, paramToServiceMsg, (List)localObject, j);
        return;
        k = i;
        i = j;
        j = k;
        for (;;)
        {
          localObject = paramFromServiceMsg;
          break;
          paramBoolean = false;
          QLog.d("Q.lebatab.CommPluginHandler", 1, "handleGetLebaPluginList respInfo is null");
          j = -1;
          paramFromServiceMsg = (FromServiceMsg)localObject;
        }
        k = 0;
        break label471;
      }
      j = -1;
      i = -1;
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
  
  protected boolean msgCmdFilter(String paramString)
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("PluginConfig.dynamic_plugin");
    }
    return !this.allowCmdSet.contains(paramString);
  }
  
  protected Class<? extends ajtg> observerClass()
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
 * Qualified Name:     arpj
 * JD-Core Version:    0.7.0.1
 */