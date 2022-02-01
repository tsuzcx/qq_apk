import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.NotificationReportController;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class bkgr
  implements Handler.Callback, NotificationReportController
{
  Handler jdField_a_of_type_AndroidOsHandler = null;
  private List<bkgs> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Set<Integer> jdField_a_of_type_JavaUtilSet;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public bkgr()
  {
    HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("NotificationReportControllerImpl", 0);
    localHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(localHandlerThread.getLooper(), this);
  }
  
  private String a()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext()) {
      localStringBuffer.append((Integer)localIterator.next()).append(",");
    }
    return localStringBuffer.substring(0, localStringBuffer.length() - 1);
  }
  
  private void a()
  {
    Object localObject;
    if ((0 == 0) && (BaseApplicationImpl.sProcessId == 1))
    {
      localObject = BaseApplicationImpl.getApplication().peekAppRuntime();
      if ((localObject == null) || (!(localObject instanceof QQAppInterface))) {}
    }
    for (QQAppInterface localQQAppInterface = (QQAppInterface)localObject;; localQQAppInterface = null)
    {
      if ((localQQAppInterface != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        if (localIterator.hasNext())
        {
          bkgs localbkgs = (bkgs)localIterator.next();
          boolean bool = a(localQQAppInterface, localbkgs.b);
          localObject = "";
          switch (localbkgs.jdField_a_of_type_Int)
          {
          default: 
            label132:
            if ((localbkgs.c == 7200) || (localbkgs.c == 1008) || (localbkgs.c == 7220)) {
              bcst.a(localQQAppInterface, bool, "tech_push", "push", (String)localObject, "", 0, "", "", localbkgs.jdField_a_of_type_JavaLangString, localbkgs.b + "", "" + localbkgs.c, "", "", "", "");
            }
            break;
          }
          while (QLog.isDevelopLevel())
          {
            QLog.d("NotificationReportControllerImpl", 2, "report real msgType:" + localbkgs.jdField_a_of_type_Int + "    frienduin:" + localbkgs.jdField_a_of_type_JavaLangString + "   uinType:" + localbkgs.c + "    nId:" + localbkgs.b);
            break;
            localObject = "info_arr";
            break label132;
            localObject = "clk";
            break label132;
            localObject = "lock_arr";
            break label132;
            localObject = "lock_clk";
            break label132;
            bcst.a(localQQAppInterface, bool, "tech_push", "push", (String)localObject, "", 0, "", "", "", localbkgs.b + "", "", "", "", "", "");
          }
        }
        this.jdField_a_of_type_JavaUtilList.clear();
      }
      return;
    }
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (!this.b)
    {
      Object localObject = paramQQAppInterface.getAccount();
      SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext());
      long l1 = localSharedPreferences.getLong("key_begintime_" + (String)localObject, 0L);
      long l2 = bkgo.a().longValue();
      this.jdField_a_of_type_JavaUtilSet = new HashSet();
      if (l1 == l2)
      {
        localObject = localSharedPreferences.getString("kay_reported_notify_ids_" + (String)localObject, "");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = ((String)localObject).split(",");
          int j = localObject.length;
          int i = 0;
          while (i < j)
          {
            localSharedPreferences = localObject[i];
            this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(localSharedPreferences));
            i += 1;
          }
        }
      }
      else
      {
        localSharedPreferences.edit().putLong("key_begintime_" + (String)localObject, l2).apply();
      }
      this.b = true;
    }
    if (!this.jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(paramInt)))
    {
      this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(paramInt));
      PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit().putString("kay_reported_notify_ids_" + paramQQAppInterface.getAccount(), a()).apply();
      return true;
    }
    return false;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 1: 
    case 2: 
    case 3: 
    case 4: 
      paramMessage = (bkgs)paramMessage.obj;
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_JavaUtilList.add(paramMessage);
        a();
        return true;
      }
      this.jdField_a_of_type_JavaUtilList.add(paramMessage);
      return true;
    }
    this.jdField_a_of_type_Boolean = true;
    a();
    return true;
  }
  
  public void report(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("NotificationReportControllerImpl", 2, "msgType:" + paramInt1 + "frienduin:" + paramString + "   uinType:" + paramInt3 + "    nId:" + paramInt2);
    }
    Message localMessage = Message.obtain();
    localMessage.what = paramInt1;
    localMessage.obj = new bkgs(paramInt1, paramInt2, paramString, paramInt3);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void reportAll()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 5;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bkgr
 * JD-Core Version:    0.7.0.1
 */