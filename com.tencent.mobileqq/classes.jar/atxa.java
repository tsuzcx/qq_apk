import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.medalwall.MedalWallMng;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItemExtMsg;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;
import org.json.JSONObject;
import tencent.im.oidb.redInfo.RedInfo;

public class atxa
  implements atxf
{
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  WeakReference<atxb> jdField_a_of_type_MqqUtilWeakReference;
  
  public atxa(QQAppInterface paramQQAppInterface, atxb paramatxb)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramatxb);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static String a(int paramInt)
  {
    return "file_redpoint_handler_" + BaseApplicationImpl.getApplication().getRuntime().getAccount() + "_" + paramInt;
  }
  
  public atxb a()
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference == null) {
      return null;
    }
    return (atxb)this.jdField_a_of_type_MqqUtilWeakReference.get();
  }
  
  public void a(RedTouchItem paramRedTouchItem, int paramInt)
  {
    RedTouchItemExtMsg localRedTouchItemExtMsg = null;
    boolean bool = true;
    if ((paramInt == 10016) || (paramInt == 10015)) {
      if (!atxi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
      {
        bool = true;
        paramRedTouchItem.isClosed = bool;
      }
    }
    do
    {
      return;
      bool = false;
      break;
      if (paramInt == 100601)
      {
        if (!atxi.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {}
        for (;;)
        {
          paramRedTouchItem.isClosed = bool;
          return;
          bool = false;
        }
      }
    } while (!atxd.a(paramInt));
    if (paramRedTouchItem.extMsgs.size() > 0)
    {
      localRedTouchItemExtMsg = (RedTouchItemExtMsg)paramRedTouchItem.extMsgs.get(0);
      if ((localRedTouchItemExtMsg.bytesData == null) || (localRedTouchItemExtMsg.bytesData.length <= 0)) {}
    }
    label275:
    label288:
    for (;;)
    {
      Object localObject1;
      try
      {
        localObject1 = new redInfo.RedInfo();
        localObject2 = localObject1;
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          ((redInfo.RedInfo)localObject1).mergeFrom(localRedTouchItemExtMsg.bytesData);
          localObject2 = localObject1;
          if ((localObject2 == null) || (!localObject2.uint64_from_uin.has())) {
            break label288;
          }
          localObject1 = localObject2.uint64_from_uin.get() + "";
          bool = true;
          if (!bool) {
            break label275;
          }
          bbdj.a(a(-4), localRedTouchItemExtMsg);
          QLog.d("DefaultRedPointPrePostHandler", 1, new Object[] { "isQQSettingMeBubbleMsg show=", Boolean.valueOf(bool), " uin=", bbjw.e((String)localObject1) });
          return;
        }
        catch (Throwable localThrowable2)
        {
          Object localObject2;
          break label245;
        }
        localThrowable1 = localThrowable1;
        localObject1 = null;
      }
      label245:
      if (QLog.isColorLevel())
      {
        QLog.i("DefaultRedPointPrePostHandler", 2, localThrowable1.getMessage(), localThrowable1);
        localObject2 = localObject1;
        continue;
        paramRedTouchItem.count = 0;
        continue;
        bool = false;
        localObject1 = "";
        continue;
        localObject1 = "";
        bool = false;
      }
    }
  }
  
  public void a(List<RedTouchItem> paramList)
  {
    atxb localatxb = a();
    if ((paramList == null) || (localatxb == null)) {
      return;
    }
    Object localObject2 = null;
    Object localObject3 = paramList.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject1 = localObject2;
      if (((RedTouchItem)((Iterator)localObject3).next()).taskId == 10005) {
        localObject1 = "0X800761B";
      }
      localObject2 = localObject1;
      if (localObject1 != null)
      {
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", (String)localObject1, (String)localObject1, 0, 0, "", "", "", "");
        localObject2 = localObject1;
      }
    }
    localObject3 = localatxb.a(10015);
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject1 = localObject2;
      if (paramList.contains(localObject3))
      {
        localObject1 = "0X8007391";
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007391", "0X8007391", 0, 0, "", "", "", "");
        ((MedalWallMng)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(250)).b();
      }
    }
    localObject2 = localatxb.a(10016);
    if ((localObject2 != null) && (paramList.contains(localObject2)) && (((RedTouchItem)localObject2).bytes != null) && (((RedTouchItem)localObject2).bytes.length > 0)) {}
    for (;;)
    {
      try
      {
        int i = new JSONObject(new String(((RedTouchItem)localObject2).bytes, "utf-8")).optInt("type", 1);
        switch (i)
        {
        default: 
          localObject2 = localObject1;
        }
      }
      catch (Exception localException)
      {
        localObject2 = localObject1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("DefaultRedPointPrePostHandler", 2, localException, new Object[0]);
        localObject2 = localObject1;
        continue;
        paramList.a((RedTouchItem)localObject1);
      }
      if (localObject2 != null) {
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", (String)localObject2, (String)localObject2, 0, 0, "", "", "", "");
      }
      localObject1 = localatxb.a(10018);
      if ((localObject1 == null) || (!paramList.contains(localObject1)) || (((RedTouchItem)localObject1).extMsgs == null) || (((RedTouchItem)localObject1).extMsgs.size() <= 0) || (!((RedTouchItem)localObject1).unReadFlag)) {
        break;
      }
      paramList = (amno)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(269);
      localObject2 = paramList.a();
      if ((localObject2 != null) && (((amnk)localObject2).c())) {
        continue;
      }
      ((RedTouchItem)localObject1).unReadFlag = false;
      localatxb.c();
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("DefaultRedPointPrePostHandler", 2, "onPostDealReachedRedPoints frdRecMsgSwitch is off");
      return;
      localObject2 = "0X8007396";
      continue;
      localObject2 = "0X80073B5";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atxa
 * JD-Core Version:    0.7.0.1
 */