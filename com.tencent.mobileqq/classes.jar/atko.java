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

public class atko
  extends alpd
{
  protected boolean a;
  
  public atko(QQAppInterface paramQQAppInterface)
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
          break label415;
        }
        i = ((PluginConfig.BatchGetResourceResp)localObject4).errcode.get();
        if (i != 0) {
          break label421;
        }
        bool1 = true;
        label93:
        localObject1 = localObject2;
        try
        {
          if (!((PluginConfig.BatchGetResourceResp)localObject4).errmsg.has()) {
            break label427;
          }
          localObject1 = localObject2;
          paramObject = ((PluginConfig.BatchGetResourceResp)localObject4).errmsg.get();
          label121:
          if (!bool1) {
            break label467;
          }
          localObject1 = paramObject;
          if (!((PluginConfig.BatchGetResourceResp)localObject4).resp_list.has()) {
            break label482;
          }
          localObject1 = paramObject;
          localObject2 = ((PluginConfig.BatchGetResourceResp)localObject4).resp_list.get();
          label153:
          if (localObject2 == null) {
            break label433;
          }
          localObject1 = paramObject;
          if (((List)localObject2).isEmpty()) {
            break label433;
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
    label415:
    label421:
    label427:
    label433:
    label467:
    label482:
    label488:
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
        break label488;
      }
      break label488;
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
                    alvq localalvq = new alvq();
                    localalvq.jdField_a_of_type_Long = ((Integer)paramFromServiceMsg.get(i2)).intValue();
                    localalvq.jdField_a_of_type_Int = i1;
                    m += 1;
                    localalvq.b = m;
                    ((List)localObject).add(localalvq);
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
          break label572;
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
        label488:
        if (paramFromServiceMsg == null) {
          break label629;
        }
      }
      label572:
      label629:
      for (n = paramFromServiceMsg.size();; n = 0)
      {
        QLog.d("Q.lebatab.CommPluginHandler", 1, new Object[] { "handleGetLebaPluginList isSuc:", Boolean.valueOf(paramBoolean), ", resultInfos.size=", Integer.valueOf(m), ", groupList.size=", Integer.valueOf(n) });
        this.app.a().a(paramBoolean, j, paramFromServiceMsg, paramToServiceMsg, i, k);
        return;
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
        break label488;
      }
      FromServiceMsg localFromServiceMsg;
      k = -1;
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
  
  protected Class<? extends alpg> observerClass()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atko
 * JD-Core Version:    0.7.0.1
 */