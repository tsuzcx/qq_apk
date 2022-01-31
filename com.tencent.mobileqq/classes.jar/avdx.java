import BOSSStrategyCenter.tAdvDesc;
import NS_MOBILE_QBOSS_PROTO.MobileQbossAdvRsp;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.entry.MiniAppPrePullManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class avdx
  implements bhkb
{
  private static volatile avdx a;
  
  public static avdx a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new avdx();
      }
      return a;
    }
    finally {}
  }
  
  private void a(MobileQbossAdvRsp paramMobileQbossAdvRsp, QQAppInterface paramQQAppInterface)
  {
    if (paramMobileQbossAdvRsp != null) {}
    try
    {
      Object localObject = paramMobileQbossAdvRsp.map_next_query_ts;
      if (localObject != null)
      {
        localObject = (Long)((Map)localObject).get(Integer.valueOf(2783));
        if (localObject != null) {
          ahmt.a().a(((Long)localObject).longValue(), 2783);
        }
      }
      paramMobileQbossAdvRsp = paramMobileQbossAdvRsp.mapAdv;
      if ((paramMobileQbossAdvRsp != null) && (paramQQAppInterface != null))
      {
        paramMobileQbossAdvRsp = (ArrayList)paramMobileQbossAdvRsp.get(Integer.valueOf(2783));
        avdl.a().a(paramMobileQbossAdvRsp, paramQQAppInterface);
      }
      return;
    }
    catch (Exception paramMobileQbossAdvRsp)
    {
      QLog.e("QSplash@QbossSplashNetService", 1, "handleQbossPreDownloadRsp exception", paramMobileQbossAdvRsp);
    }
  }
  
  private void a(MobileQbossAdvRsp paramMobileQbossAdvRsp, String paramString, QQAppInterface paramQQAppInterface)
  {
    QLog.i("QzoneQbossHelper", 1, "coversation getQbossSuccess requestType = " + paramString);
    if (paramMobileQbossAdvRsp != null)
    {
      paramString = paramMobileQbossAdvRsp.map_next_query_ts;
      if (paramString != null)
      {
        paramString = (Long)paramString.get(Integer.valueOf(2741));
        if (paramString != null) {
          ahmt.a().a(paramString.longValue(), 2741);
        }
      }
      paramMobileQbossAdvRsp = paramMobileQbossAdvRsp.mapAdv;
      if (paramMobileQbossAdvRsp != null)
      {
        paramMobileQbossAdvRsp = (ArrayList)paramMobileQbossAdvRsp.get(Integer.valueOf(2741));
        if ((paramMobileQbossAdvRsp != null) && (paramMobileQbossAdvRsp.size() > 0)) {
          a(paramMobileQbossAdvRsp);
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (paramQQAppInterface != null))
      {
        paramMobileQbossAdvRsp = paramQQAppInterface.getHandler(Conversation.class);
        if (paramMobileQbossAdvRsp != null) {
          paramMobileQbossAdvRsp.sendEmptyMessage(1063);
        }
      }
      return;
    }
  }
  
  private void a(ahmr paramahmr)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localQQAppInterface == null) {}
    do
    {
      ahmr localahmr;
      do
      {
        return;
        localahmr = ahmt.a().a(localQQAppInterface.getAccount());
      } while ((paramahmr == null) || (paramahmr.a == null) || (localahmr == null) || (localahmr.a == null) || (paramahmr.a.pattern_id == localahmr.a.pattern_id));
      paramahmr = localQQAppInterface.getHandler(Conversation.class);
    } while (paramahmr == null);
    QLog.e("QzoneQbossHelper", 1, "checkIfNeedRemoveBanner remove");
    paramahmr.sendEmptyMessage(1063);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    ArrayList localArrayList;
    HashMap localHashMap;
    try
    {
      Object localObject1 = avds.a(BaseApplicationImpl.getContext(), paramLong);
      localArrayList = new ArrayList();
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        if ((avds.a == null) || (avds.a.size() == 0))
        {
          localHashMap = avds.a(BaseApplicationImpl.getApplication(), paramLong + "");
          localObject1 = ((List)localObject1).iterator();
        }
      }
      else {
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (String)((Iterator)localObject1).next();
          if (localHashMap.containsKey(localObject2))
          {
            localObject2 = (avdt)localHashMap.get(localObject2);
            if (((avdt)localObject2).b())
            {
              localArrayList.add(localObject2);
              QLog.i("QSplash@QbossSplashNetService", 1, "checkNeedDowloadAndDowload aid =" + ((avdt)localObject2).jdField_b_of_type_JavaLangString + "UIN" + paramLong % 10000L);
            }
            if ((((avdt)localObject2).jdField_b_of_type_Int == 3) || (((avdt)localObject2).jdField_b_of_type_Int == 2))
            {
              MiniAppPrePullManager.getInstance().prePullAppinfoByLink(((avdt)localObject2).f, null);
              continue;
              return;
            }
          }
        }
      }
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("QSplash@QbossSplashNetService", 1, paramQQAppInterface, new Object[0]);
    }
    do
    {
      localHashMap = avds.a;
      break;
    } while ((localArrayList == null) || (localArrayList.size() <= 0));
    avdp.a(paramQQAppInterface, localArrayList);
  }
  
  private void a(ArrayList<tAdvDesc> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = (tAdvDesc)paramArrayList.get(0);
      if (paramArrayList != null)
      {
        QLog.i("QzoneQbossHelper", 4, "handleQbossBannerData data = " + paramArrayList.res_data);
        paramArrayList = ahmr.a(paramArrayList);
        a(paramArrayList);
        ahmt.a().a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramArrayList);
      }
    }
    else
    {
      return;
    }
    QLog.e("QzoneQbossHelper", 1, "handleQbossBannerData data = null");
  }
  
  private void b(MobileQbossAdvRsp paramMobileQbossAdvRsp, QQAppInterface paramQQAppInterface)
  {
    if (paramMobileQbossAdvRsp != null) {}
    for (;;)
    {
      try
      {
        Object localObject = paramMobileQbossAdvRsp.map_next_query_ts;
        if (localObject != null)
        {
          localObject = (Long)((Map)localObject).get(Integer.valueOf(2742));
          if (localObject != null) {
            ahmt.a().a(((Long)localObject).longValue(), 2742);
          }
        }
        paramMobileQbossAdvRsp = paramMobileQbossAdvRsp.mapAdv;
        if ((paramMobileQbossAdvRsp != null) && (paramQQAppInterface != null))
        {
          paramMobileQbossAdvRsp = (ArrayList)paramMobileQbossAdvRsp.get(Integer.valueOf(2742));
          localObject = paramQQAppInterface.getAccount();
          if ((paramMobileQbossAdvRsp != null) && (paramMobileQbossAdvRsp.size() > 0))
          {
            QLog.i("QSplash@QbossSplashNetService", 1, "handleQbossSplashRsp appid =2742");
            avdo.a(paramMobileQbossAdvRsp, paramQQAppInterface, (String)localObject);
            i = 1;
            if ((i == 0) && (paramQQAppInterface != null))
            {
              paramMobileQbossAdvRsp = paramQQAppInterface.getAccount();
              QLog.i("QSplash@QbossSplashNetService", 1, "handleQbossSplashRsp cleardata");
              avds.a(BaseApplicationImpl.getContext(), avds.a(paramMobileQbossAdvRsp), false);
              avds.b(BaseApplicationImpl.getContext(), avds.a(paramMobileQbossAdvRsp));
            }
            return;
          }
        }
      }
      catch (Exception paramMobileQbossAdvRsp)
      {
        QLog.e("QSplash@QbossSplashNetService", 1, "handleQbossSplashRsp exception" + paramMobileQbossAdvRsp.toString());
        return;
      }
      int i = 0;
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2, ArrayList<Integer> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (!paramArrayList.contains(Integer.valueOf(2741)));
        QLog.i("QzoneQbossHelper", 1, "getQbossFail msg = " + paramString1 + " requestType = " + paramString2);
        paramString1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      } while (paramString1 == null);
      paramString1 = paramString1.getHandler(Conversation.class);
    } while (paramString1 == null);
    paramString1.sendEmptyMessage(1063);
  }
  
  public void a(Bundle paramBundle, String paramString, QQAppInterface paramQQAppInterface)
  {
    QLog.i("QSplash@QbossSplashNetService", 1, "getQbossSuccess requestType = " + paramString);
    try
    {
      ArrayList localArrayList = paramBundle.getIntegerArrayList("appid");
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        paramBundle = paramBundle.getSerializable("data");
        if ((paramBundle != null) && ((paramBundle instanceof MobileQbossAdvRsp)))
        {
          paramBundle = (MobileQbossAdvRsp)paramBundle;
          if (localArrayList.contains(Integer.valueOf(2741))) {
            a(paramBundle, paramString, paramQQAppInterface);
          }
          if (localArrayList.contains(Integer.valueOf(2742))) {
            b(paramBundle, paramQQAppInterface);
          }
          if (localArrayList.contains(Integer.valueOf(2783))) {
            a(paramBundle, paramQQAppInterface);
          }
        }
        else
        {
          a(-1, "rsp is not MobileQbossAdvRsp", paramString, localArrayList);
          return;
        }
      }
    }
    catch (Exception paramBundle)
    {
      QLog.e("QzoneQbossHelper", 1, paramBundle, new Object[0]);
    }
  }
  
  public void a(String paramString, ArrayList<Integer> paramArrayList)
  {
    if (paramArrayList != null) {
      QLog.i("QSplash@QbossSplashNetService", 1, "sendRequestQboss requestType = " + paramString + " contain id = " + paramArrayList.toString());
    }
    bhkf.a().a(paramArrayList, this, paramString);
  }
  
  public void a(String paramString, MqqHandler paramMqqHandler)
  {
    try
    {
      QLog.i("QSplash@QbossSplashNetService", 1, "sendQbossRequest  minigame preload ");
      Object localObject = new ArrayList();
      boolean bool2 = ahmt.a().a(2741);
      if ((bool2) && (!"qboss_banner_net_change".equals(paramString))) {
        ((ArrayList)localObject).add(Integer.valueOf(2741));
      }
      boolean bool1;
      if (bhvh.k(BaseApplicationImpl.getApplication().getRuntime()))
      {
        bool1 = ahmt.a().a(2742);
        if (!bool1) {
          break label274;
        }
        ((ArrayList)localObject).add(Integer.valueOf(2742));
      }
      for (;;)
      {
        boolean bool3 = ahmt.a().a(2783);
        if (bool3) {
          ((ArrayList)localObject).add(Integer.valueOf(2783));
        }
        if (((ArrayList)localObject).size() != 0) {
          a(paramString, (ArrayList)localObject);
        }
        if ("qboss_banner_login".equals(paramString))
        {
          localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          if (localObject != null)
          {
            if (!bool1)
            {
              QLog.i("QSplash@QbossSplashNetService", 1, "sendQbossRequest checkNeedDowloadAndDowload ");
              a((QQAppInterface)localObject, avds.a(((QQAppInterface)localObject).getAccount()));
            }
            if (!bool3)
            {
              QLog.i("QSplash@QbossSplashNetService", 1, "sendQbossRequest QbossPreDownloadManager.checkPreDownloadResStatus ");
              avdl.a().a((QQAppInterface)localObject);
            }
          }
        }
        if ((bool2) || (!"qboss_banner_pull_refresh".equals(paramString))) {
          break;
        }
        paramMqqHandler.sendEmptyMessage(1063);
        return;
        QLog.i("QSplash@QbossSplashNetService", 1, "关闭了频控");
        ((ArrayList)localObject).add(Integer.valueOf(2742));
        bool1 = false;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("QzoneQbossHelper", 1, paramString, new Object[0]);
      return;
    }
    label274:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     avdx
 * JD-Core Version:    0.7.0.1
 */