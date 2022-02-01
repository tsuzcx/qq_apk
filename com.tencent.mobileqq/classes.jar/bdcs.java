import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.GuardProcessExitListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.studyroom.ui.StudyRoomLoadingFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.dynamic.host.DynamicPluginManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;
import mqq.manager.Manager;

public class bdcs
  implements Manager
{
  private volatile long jdField_a_of_type_Long;
  private final BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new bdcu(this);
  private final GuardProcessExitListener jdField_a_of_type_ComTencentMobileqqAppGuardProcessExitListener = new bdct(this);
  private volatile QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private DynamicPluginManager jdField_a_of_type_ComTencentShadowDynamicHostDynamicPluginManager;
  
  public bdcs(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    a();
    b();
  }
  
  private void a()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.process.exit");
    BaseApplicationImpl.getApplication().registerReceiver(this.jdField_a_of_type_ComTencentMobileqqAppGuardProcessExitListener, localIntentFilter);
  }
  
  private void b()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_KICKED");
    localIntentFilter.addAction("mqq.intent.action.EXIT_" + BaseApplicationImpl.getApplication().getPackageName());
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_CHANGED");
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_EXPIRED");
    localIntentFilter.addAction("mqq.intent.action.LOGOUT");
    localIntentFilter.addAction("mqq.intent.action.LOGIN");
    BaseApplicationImpl.getApplication().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  public void a(Context paramContext)
  {
    bdcv localbdcv = bdcw.a();
    if ((localbdcv != null) && (localbdcv.a()) && (bgnt.a(paramContext)))
    {
      long l = System.currentTimeMillis();
      if (l - this.jdField_a_of_type_Long > 1800000L)
      {
        QLog.d("studyroom.StudyRoomManager", 4, "preDownload");
        this.jdField_a_of_type_Long = l;
        bddr.a(paramContext, new Bundle(), true, new bddt());
      }
    }
    else
    {
      return;
    }
    QLog.w("studyroom.StudyRoomManager", 4, "preDownload too fast");
  }
  
  public void a(Context paramContext, HashMap<String, String> paramHashMap)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d()) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b()))
    {
      QLog.d("studyroom.StudyRoomManager", 4, "block because isVideoChatting() && isAvChating()");
      QQToast.a(paramContext, 2131695235, 1).b(paramContext.getResources().getDimensionPixelSize(2131298998));
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b() > 0L)
    {
      QLog.d("studyroom.StudyRoomManager", 4, "block because getChatingRelationId()>0");
      QQToast.a(paramContext, 2131695235, 1).b(paramContext.getResources().getDimensionPixelSize(2131298998));
      return;
    }
    Object localObject1 = (HashMap)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    int j;
    if (localObject1 != null)
    {
      localObject1 = ((HashMap)localObject1).entrySet().iterator();
      int i = 0;
      j = i;
      if (!((Iterator)localObject1).hasNext()) {
        break label334;
      }
      Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
      if ((localObject2 == null) || (((Map.Entry)localObject2).getKey() == null) || (((Map.Entry)localObject2).getValue() == null)) {
        break label375;
      }
      long l = ((Long)((Map.Entry)localObject2).getKey()).longValue();
      j = ((Integer)((Map.Entry)localObject2).getValue()).intValue();
      if ((j != 2) && (j != 12)) {
        break label375;
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l, j);
      if ((localObject2 == null) || (((lmm)localObject2).a <= 0)) {
        break label375;
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l);
      if (localObject2 == null) {
        break label375;
      }
      localObject2 = ((Vector)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        lml locallml = (lml)((Iterator)localObject2).next();
        if ((locallml != null) && (TextUtils.equals(String.valueOf(locallml.jdField_a_of_type_Long), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()))) {
          i = 1;
        }
      }
    }
    label334:
    label375:
    for (;;)
    {
      break;
      j = 0;
      if (j != 0)
      {
        QLog.d("studyroom.StudyRoomManager", 4, "block because group video");
        QQToast.a(paramContext, 2131695236, 1).b(paramContext.getResources().getDimensionPixelSize(2131298998));
        return;
      }
      StudyRoomLoadingFragment.a(paramHashMap);
      return;
    }
  }
  
  public void a(DynamicPluginManager paramDynamicPluginManager)
  {
    this.jdField_a_of_type_ComTencentShadowDynamicHostDynamicPluginManager = paramDynamicPluginManager;
  }
  
  public void onDestroy()
  {
    try
    {
      BaseApplicationImpl.getApplication().unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqAppGuardProcessExitListener);
      try
      {
        label10:
        BaseApplicationImpl.getApplication().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        return;
      }
      catch (Exception localException1) {}
    }
    catch (Exception localException2)
    {
      break label10;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdcs
 * JD-Core Version:    0.7.0.1
 */