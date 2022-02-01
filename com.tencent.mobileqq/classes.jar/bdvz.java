import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.GuardProcessExitListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.studyroom.ui.StudyRoomLoadingFragment;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.dynamic.host.DynamicPluginManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;
import mqq.manager.Manager;
import tencent.im.oidb.cmd0x857.TroopTips0x857.StudyRoomMemberChangePush;

public class bdvz
  implements Manager
{
  private volatile long jdField_a_of_type_Long;
  private final BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new bdwb(this);
  private bdwf jdField_a_of_type_Bdwf;
  private final GuardProcessExitListener jdField_a_of_type_ComTencentMobileqqAppGuardProcessExitListener = new bdwa(this);
  private volatile QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private DynamicPluginManager jdField_a_of_type_ComTencentShadowDynamicHostDynamicPluginManager;
  private HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<bdwd> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public bdvz(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    a();
    b();
    this.jdField_a_of_type_Bdwf = new bdwc(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Bdwf);
  }
  
  private void a()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.process.exit");
    BaseApplicationImpl.getApplication().registerReceiver(this.jdField_a_of_type_ComTencentMobileqqAppGuardProcessExitListener, localIntentFilter);
  }
  
  private void a(String paramString, int paramInt)
  {
    QLog.i("studyroom.StudyRoomManager", 1, "handleMemberChangedEvent troopUin " + paramString + " newMemberCount:" + paramInt);
    this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Integer.valueOf(paramInt));
    b(paramString, paramInt);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((bdwd)localIterator.next()).a(paramString, paramInt);
    }
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
  
  private void b(String paramString, int paramInt)
  {
    Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    TroopInfo localTroopInfo = ((TroopManager)localObject).a(paramString);
    if (localTroopInfo != null)
    {
      if ((localTroopInfo.getStudyRoomOpen()) && (paramInt <= 0))
      {
        localTroopInfo.setStudyRoomOpen(false);
        ((TroopManager)localObject).b(localTroopInfo);
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
        ((QQMessageFacade)localObject).setChangeAndNotify(((QQMessageFacade)localObject).getLastMessage(paramString, 1));
      }
      while ((localTroopInfo.getStudyRoomOpen()) || (paramInt <= 0)) {
        return;
      }
      localTroopInfo.setStudyRoomOpen(true);
      ((TroopManager)localObject).b(localTroopInfo);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
      ((QQMessageFacade)localObject).setChangeAndNotify(((QQMessageFacade)localObject).getLastMessage(paramString, 1));
      return;
    }
    QLog.i("studyroom.StudyRoomManager", 1, "can't find troopinfo");
  }
  
  public int a(String paramString)
  {
    paramString = (Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (paramString != null) {
      return paramString.intValue();
    }
    return 0;
  }
  
  public void a(Context paramContext)
  {
    bdwg localbdwg = bdwh.a();
    if ((localbdwg != null) && (localbdwg.a()) && (NetworkUtil.isWifiEnabled(paramContext)))
    {
      long l = System.currentTimeMillis();
      if (l - this.jdField_a_of_type_Long > 1800000L)
      {
        QLog.d("studyroom.StudyRoomManager", 4, "preDownload");
        this.jdField_a_of_type_Long = l;
        bdxc.a(paramContext, new Bundle(), true, new bdxe());
      }
    }
    else
    {
      return;
    }
    QLog.w("studyroom.StudyRoomManager", 4, "preDownload too fast");
  }
  
  public void a(Context paramContext, String paramString, HashMap<String, String> paramHashMap)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isVideoChatting()) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().b()))
    {
      QLog.d("studyroom.StudyRoomManager", 4, "block because isVideoChatting() && isAvChating()");
      QQToast.a(paramContext, 2131695634, 1).b(paramContext.getResources().getDimensionPixelSize(2131299080));
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().b() > 0L)
    {
      QLog.d("studyroom.StudyRoomManager", 4, "block because getChatingRelationId()>0");
      QQToast.a(paramContext, 2131695634, 1).b(paramContext.getResources().getDimensionPixelSize(2131299080));
      return;
    }
    Object localObject1 = (HashMap)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a();
    int j;
    if (localObject1 != null)
    {
      localObject1 = ((HashMap)localObject1).entrySet().iterator();
      int i = 0;
      j = i;
      if (!((Iterator)localObject1).hasNext()) {
        break label343;
      }
      Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
      if ((localObject2 == null) || (((Map.Entry)localObject2).getKey() == null) || (((Map.Entry)localObject2).getValue() == null)) {
        break label386;
      }
      long l = ((Long)((Map.Entry)localObject2).getKey()).longValue();
      j = ((Integer)((Map.Entry)localObject2).getValue()).intValue();
      if ((j != 2) && (j != 12)) {
        break label386;
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a(l, j);
      if ((localObject2 == null) || (((lne)localObject2).a <= 0)) {
        break label386;
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a(l);
      if (localObject2 == null) {
        break label386;
      }
      localObject2 = ((Vector)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        lnd locallnd = (lnd)((Iterator)localObject2).next();
        if ((locallnd != null) && (TextUtils.equals(String.valueOf(locallnd.jdField_a_of_type_Long), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()))) {
          i = 1;
        }
      }
    }
    label386:
    for (;;)
    {
      break;
      j = 0;
      label343:
      if (j != 0)
      {
        QLog.d("studyroom.StudyRoomManager", 4, "block because group video");
        QQToast.a(paramContext, 2131695635, 1).b(paramContext.getResources().getDimensionPixelSize(2131299080));
        return;
      }
      StudyRoomLoadingFragment.a(paramString, paramHashMap);
      return;
    }
  }
  
  public void a(bdwd parambdwd)
  {
    this.jdField_a_of_type_JavaUtilList.add(parambdwd);
  }
  
  public void a(DynamicPluginManager paramDynamicPluginManager)
  {
    this.jdField_a_of_type_ComTencentShadowDynamicHostDynamicPluginManager = paramDynamicPluginManager;
  }
  
  public void a(String paramString)
  {
    QLog.i("studyroom.StudyRoomManager", 1, "getStudyMemberCountFromServer " + paramString);
    TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).a(paramString);
    if ((localTroopInfo != null) && (localTroopInfo.getStudyRoomOpen()))
    {
      QLog.i("studyroom.StudyRoomManager", 1, "start getStudyMember " + paramString);
      ((bdwe)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.STUDY_ROOM_HANDLER)).a(paramString);
    }
  }
  
  public void a(byte[] paramArrayOfByte, String paramString)
  {
    TroopTips0x857.StudyRoomMemberChangePush localStudyRoomMemberChangePush = new TroopTips0x857.StudyRoomMemberChangePush();
    try
    {
      localStudyRoomMemberChangePush.mergeFrom(paramArrayOfByte);
      a(paramString, localStudyRoomMemberChangePush.member_count.get());
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      QLog.i("studyroom.StudyRoomManager", 1, "handleRoomMemberChangePush decode error, e=" + paramArrayOfByte.toString());
    }
  }
  
  public void b(bdwd parambdwd)
  {
    this.jdField_a_of_type_JavaUtilList.remove(parambdwd);
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
        label20:
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Bdwf);
        return;
      }
      catch (Exception localException1)
      {
        break label20;
      }
    }
    catch (Exception localException2)
    {
      break label10;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdvz
 * JD-Core Version:    0.7.0.1
 */