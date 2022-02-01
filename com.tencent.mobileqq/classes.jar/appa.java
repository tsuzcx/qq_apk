import android.os.Bundle;
import com.tencent.mobileqq.comment.DanmuItemBean;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class appa
  extends QIPCModule
  implements appi
{
  private static volatile appa jdField_a_of_type_Appa;
  public static boolean a;
  private List<appc> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  private appa()
  {
    super("DanmuDataIPCClient");
  }
  
  public static appa a()
  {
    if (jdField_a_of_type_Appa == null) {}
    try
    {
      if (jdField_a_of_type_Appa == null) {
        jdField_a_of_type_Appa = new appa();
      }
      return jdField_a_of_type_Appa;
    }
    finally {}
  }
  
  public static void a()
  {
    appa localappa = a();
    if (!jdField_a_of_type_Boolean)
    {
      QIPCClientHelper.getInstance().register(localappa);
      jdField_a_of_type_Boolean = true;
      QLog.d("DanmuDataIPCClient", 1, "registerModule");
    }
  }
  
  public Bundle a(String paramString, Bundle paramBundle)
  {
    long l1;
    long l2;
    int i;
    Object localObject;
    if ("qipc_action_get_barrage".equals(paramString))
    {
      l1 = paramBundle.getLong("key_barrage_msg_seq");
      l2 = paramBundle.getLong("key_barrage_grp_uin");
      i = paramBundle.getInt("key_barrage_topic_type");
      localObject = apoy.a().a(l2, l1);
      localObject = apoy.a().a((String)localObject);
      if (localObject == null) {
        break label243;
      }
    }
    label243:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("DanmuDataIPCClient", 2, new Object[] { "get barrage list, msgSeq:", Long.valueOf(l1), " groupUin:", Long.valueOf(l2), " topicType:", Integer.valueOf(i), " peakCached:", Boolean.valueOf(bool) });
      if (bool) {
        QLog.d("DanmuDataIPCClient", 2, new Object[] { "peak listSize:", Integer.valueOf(((apoz)localObject).d.size()), ", fullList:", ((apoz)localObject).d.toString() });
      }
      paramBundle.putBoolean("key_barrage_is_update", bool);
      paramBundle.putLong("key_barrage_req_time", System.currentTimeMillis());
      QIPCClientHelper.getInstance().getClient().callServer("DanmuDataIPCServer", "qipc_action_get_barrage", paramBundle, new appb(this));
      if ("qipc_action_clear_cache".equals(paramString)) {
        QIPCClientHelper.getInstance().getClient().callServer("DanmuDataIPCServer", "qipc_action_clear_cache", null);
      }
      return null;
    }
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt)
  {
    QLog.d("DanmuDataIPCClient", 1, "getDanmuList start");
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putLong("key_barrage_msg_seq", paramLong1);
      localBundle.putLong("key_barrage_grp_uin", paramLong2);
      localBundle.putInt("key_barrage_topic_type", paramInt);
      a().a("qipc_action_get_barrage", localBundle);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("DanmuDataIPCClient", 1, "getDanmuList fail, ", localException);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    paramBundle.setClassLoader(DanmuItemBean.class.getClassLoader());
    long l1 = paramBundle.getLong("key_barrage_msg_seq");
    long l2 = paramBundle.getLong("key_barrage_grp_uin");
    int k = paramBundle.getInt("key_barrage_topic_type");
    boolean bool = paramBundle.getBoolean("key_barrage_is_success");
    int m = paramBundle.getInt("key_barrage_interval_time");
    if (QLog.isColorLevel()) {
      QLog.d("DanmuDataIPCClient", 2, new Object[] { "handleGetBarrageEIPCResult, topicSeq:", Long.valueOf(l1), " groupUin:", Long.valueOf(l2), " topicType:", Integer.valueOf(k), " isSuccess:", Boolean.valueOf(bool) });
    }
    if (paramBundle.containsKey("key_barrage_req_time"))
    {
      long l4 = paramBundle.getLong("key_barrage_req_time");
      long l5 = paramBundle.getLong("key_barrage_net_req_time");
      long l3 = paramBundle.getLong("key_barrage_net_response_time");
      l4 = l5 - l4;
      l5 = l3 - l5;
      l3 = System.currentTimeMillis() - l3;
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("ipcReqCost", String.valueOf(l4));
      ((HashMap)localObject1).put("netReqCost", String.valueOf(l5));
      ((HashMap)localObject1).put("ipcRspCost", String.valueOf(l3));
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "DanmuPullCost", false, 0L, 0L, (HashMap)localObject1, null);
      if (QLog.isColorLevel()) {
        QLog.d("DanmuDataIPCClient", 2, new Object[] { "handleGetBarrageEIPCResult, ipcReqCost:", Long.valueOf(l4), " netReqCost:", Long.valueOf(l5), " ipcRspCost:", Long.valueOf(l3) });
      }
    }
    Object localObject1 = paramBundle.getParcelableArrayList("key_barrage_danmu_list");
    Object localObject2 = paramBundle.getLongArray("key_barrage_del_seq_list");
    int i;
    int j;
    label347:
    Object localObject3;
    if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()))
    {
      i = 1;
      if ((localObject2 == null) || (localObject2.length <= 0)) {
        break label506;
      }
      j = 1;
      localObject3 = apoy.a().a(l2, l1);
      paramBundle = apoy.a().a((String)localObject3);
      if (paramBundle != null) {
        break label649;
      }
      paramBundle = apoy.a().b((String)localObject3);
    }
    label516:
    label649:
    for (;;)
    {
      if ((bool) && ((i != 0) || (j != 0)))
      {
        if (QLog.isColorLevel())
        {
          if (localObject1 == null) {
            break label511;
          }
          i = ((ArrayList)localObject1).size();
          label411:
          if (localObject2 == null) {
            break label516;
          }
        }
        for (j = localObject2.length;; j = 0)
        {
          QLog.d("DanmuDataIPCClient", 2, new Object[] { "handleGetBarrageEIPCResult, danmuItemList size:", Integer.valueOf(i), " delSeqArr size:", Integer.valueOf(j) });
          localObject3 = new ArrayList(localObject2.length);
          j = localObject2.length;
          i = 0;
          while (i < j)
          {
            ((List)localObject3).add(Long.valueOf(localObject2[i]));
            i += 1;
          }
          i = 0;
          break;
          label506:
          j = 0;
          break label347;
          label511:
          i = 0;
          break label411;
        }
        localObject2 = new apox(l2, l1, k, true);
        paramBundle.a((List)localObject1).b((List)localObject3).a((apox)localObject2).a(null).a();
      }
      if ((bool) && (paramBundle != null) && (!paramBundle.d.isEmpty()))
      {
        localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((appc)((Iterator)localObject1).next()).a(l1, String.valueOf(l2), m, paramBundle.d);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("DanmuDataIPCClient", 2, "handleGetBarrageEIPCResult end");
      }
      return;
    }
  }
  
  public void a(appc paramappc)
  {
    if ((paramappc != null) && (!this.jdField_a_of_type_JavaUtilList.contains(paramappc))) {
      this.jdField_a_of_type_JavaUtilList.add(paramappc);
    }
  }
  
  public void b()
  {
    apoy.a().a();
    a("qipc_action_clear_cache", null);
  }
  
  public void b(appc paramappc)
  {
    if ((paramappc != null) && (this.jdField_a_of_type_JavaUtilList.contains(paramappc))) {
      this.jdField_a_of_type_JavaUtilList.remove(paramappc);
    }
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if ("qipc_action_get_barrage_result".equals(paramString)) {
      a(paramBundle);
    }
    for (;;)
    {
      return null;
      if ("qipc_action_send_barrage".equals(paramString))
      {
        paramBundle.setClassLoader(DanmuItemBean.class.getClassLoader());
        paramString = (DanmuItemBean)paramBundle.getParcelable("key_barrage_danmu_msg");
        long l = paramBundle.getLong("key_barrage_msg_seq");
        paramBundle = paramBundle.getString("key_barrage_grp_uin");
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext()) {
          ((appc)localIterator.next()).a(l, paramBundle, paramString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     appa
 * JD-Core Version:    0.7.0.1
 */