import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.dingdong.DingdongPluginRemoteCmdHandler;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import mqq.util.WeakReference;

public class amso
  implements Runnable
{
  public volatile long a;
  private volatile WeakReference a;
  public volatile boolean a;
  private volatile WeakReference b;
  
  public amso(DingdongPluginRemoteCmdHandler paramDingdongPluginRemoteCmdHandler)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramDingdongPluginRemoteCmdHandler);
  }
  
  private long a()
  {
    Object localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (this.b != null) {}
    for (Object localObject1 = (ArrayList)this.b.get();; localObject1 = null)
    {
      long l;
      int i;
      if ((localObject2 != null) && (localObject1 != null))
      {
        Object localObject3 = (DiscussionManager)((QQAppInterface)localObject2).getManager(52);
        if (localObject3 == null) {
          break label311;
        }
        Object localObject4 = ((DiscussionManager)localObject3).a();
        if ((localObject4 == null) || (((ArrayList)localObject4).size() == 0)) {
          return 0L;
        }
        ArrayList localArrayList1 = new ArrayList();
        localObject4 = ((ArrayList)localObject4).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          DiscussionInfo localDiscussionInfo = (DiscussionInfo)((Iterator)localObject4).next();
          ArrayList localArrayList2 = ((DiscussionManager)localObject3).a(localDiscussionInfo.uin);
          if ((localArrayList2 != null) && (a(localArrayList2, (ArrayList)localObject1))) {
            localArrayList1.add(localDiscussionInfo.uin);
          }
        }
        int j = localArrayList1.size();
        if (j == 1)
        {
          l = Long.valueOf((String)localArrayList1.get(0)).longValue();
          return l;
        }
        if (j <= 1) {
          break label311;
        }
        localObject1 = (String)localArrayList1.get(0);
        localObject3 = ((QQAppInterface)localObject2).a();
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          l = 0L;
          i = 0;
          label224:
          localObject2 = localObject1;
          if (i < j)
          {
            localObject2 = ((QQMessageFacade)localObject3).a((String)localArrayList1.get(i), 3000);
            if ((localObject2 == null) || (((QQMessageFacade.Message)localObject2).time <= l)) {
              break label316;
            }
            localObject1 = (String)localArrayList1.get(i);
            l = ((QQMessageFacade.Message)localObject2).time;
          }
        }
      }
      label311:
      label316:
      for (;;)
      {
        i += 1;
        break label224;
        l = Long.valueOf((String)localObject2).longValue();
        break;
        QLog.d("DingdongPluginRemoteCmdHandler", 4, "if (app != null && rr != null) { ... } else { ... }");
        l = 0L;
        break;
      }
    }
  }
  
  private boolean a(ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    if (paramArrayList1.size() != paramArrayList2.size() + 1) {
      return false;
    }
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localObject != null) {}
    for (localObject = ((QQAppInterface)localObject).getCurrentAccountUin();; localObject = null)
    {
      HashSet localHashSet = new HashSet();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localHashSet.add(localObject);
        paramArrayList2 = paramArrayList2.iterator();
        while (paramArrayList2.hasNext()) {
          localHashSet.add(((ResultRecord)paramArrayList2.next()).a);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("DingdongPluginRemoteCmdHandler", 2, "checkEqualList, something error when get self uin");
      }
      return false;
      int i = localHashSet.size();
      paramArrayList1 = paramArrayList1.iterator();
      while (paramArrayList1.hasNext()) {
        localHashSet.add(((DiscussionMemberInfo)paramArrayList1.next()).memberUin);
      }
      return i == localHashSet.size();
    }
  }
  
  public boolean a(ArrayList paramArrayList)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Long = 0L;
      this.b = new WeakReference(paramArrayList);
      ThreadManager.post(this, 8, null, true);
      return true;
    }
    return false;
  }
  
  public void run()
  {
    DingdongPluginRemoteCmdHandler localDingdongPluginRemoteCmdHandler = (DingdongPluginRemoteCmdHandler)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localDingdongPluginRemoteCmdHandler != null)
    {
      this.jdField_a_of_type_Long = a();
      if (this.jdField_a_of_type_Long <= 0L) {
        break label43;
      }
      DingdongPluginRemoteCmdHandler.a(localDingdongPluginRemoteCmdHandler, 0);
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      return;
      label43:
      DingdongPluginRemoteCmdHandler.a(localDingdongPluginRemoteCmdHandler, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amso
 * JD-Core Version:    0.7.0.1
 */