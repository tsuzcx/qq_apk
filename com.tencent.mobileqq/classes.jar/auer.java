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

public class auer
  implements bgbp
{
  private static volatile auer a;
  
  public static auer a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new auer();
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
          ahae.a().a(((Long)localObject).longValue(), 2783);
        }
      }
      paramMobileQbossAdvRsp = paramMobileQbossAdvRsp.mapAdv;
      if ((paramMobileQbossAdvRsp != null) && (paramQQAppInterface != null))
      {
        paramMobileQbossAdvRsp = (ArrayList)paramMobileQbossAdvRsp.get(Integer.valueOf(2783));
        auef.a().a(paramMobileQbossAdvRsp, paramQQAppInterface);
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
          ahae.a().a(paramString.longValue(), 2741);
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
  
  private void a(ahac paramahac)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localQQAppInterface == null) {}
    do
    {
      ahac localahac;
      do
      {
        return;
        localahac = ahae.a().a(localQQAppInterface.getAccount());
      } while ((paramahac == null) || (paramahac.a == null) || (localahac == null) || (localahac.a == null) || (paramahac.a.pattern_id == localahac.a.pattern_id));
      paramahac = localQQAppInterface.getHandler(Conversation.class);
    } while (paramahac == null);
    QLog.e("QzoneQbossHelper", 1, "checkIfNeedRemoveBanner remove");
    paramahac.sendEmptyMessage(1063);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    ArrayList localArrayList;
    HashMap localHashMap;
    try
    {
      Object localObject1 = auem.a(BaseApplicationImpl.getContext(), paramLong);
      localArrayList = new ArrayList();
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        if ((auem.a == null) || (auem.a.size() == 0))
        {
          localHashMap = auem.a(BaseApplicationImpl.getApplication(), paramLong + "");
          localObject1 = ((List)localObject1).iterator();
        }
      }
      else {
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (String)((Iterator)localObject1).next();
          if (localHashMap.containsKey(localObject2))
          {
            localObject2 = (auen)localHashMap.get(localObject2);
            if (((auen)localObject2).b())
            {
              localArrayList.add(localObject2);
              QLog.i("QSplash@QbossSplashNetService", 1, "checkNeedDowloadAndDowload aid =" + ((auen)localObject2).jdField_b_of_type_JavaLangString + "UIN" + paramLong % 10000L);
            }
            if ((((auen)localObject2).jdField_b_of_type_Int == 3) || (((auen)localObject2).jdField_b_of_type_Int == 2))
            {
              MiniAppPrePullManager.getInstance().prePullAppinfoByLink(((auen)localObject2).f, null);
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
      localHashMap = auem.a;
      break;
    } while ((localArrayList == null) || (localArrayList.size() <= 0));
    auej.a(paramQQAppInterface, localArrayList);
  }
  
  private void a(ArrayList<tAdvDesc> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = (tAdvDesc)paramArrayList.get(0);
      if (paramArrayList != null)
      {
        QLog.i("QzoneQbossHelper", 4, "handleQbossBannerData data = " + paramArrayList.res_data);
        paramArrayList = ahac.a(paramArrayList);
        a(paramArrayList);
        ahae.a().a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramArrayList);
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
            ahae.a().a(((Long)localObject).longValue(), 2742);
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
            auei.a(paramMobileQbossAdvRsp, paramQQAppInterface, (String)localObject);
            i = 1;
            if ((i == 0) && (paramQQAppInterface != null))
            {
              paramMobileQbossAdvRsp = paramQQAppInterface.getAccount();
              QLog.i("QSplash@QbossSplashNetService", 1, "handleQbossSplashRsp cleardata");
              auem.a(BaseApplicationImpl.getContext(), auem.a(paramMobileQbossAdvRsp), false);
              auem.b(BaseApplicationImpl.getContext(), auem.a(paramMobileQbossAdvRsp));
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
    bgbt.a().a(paramArrayList, this, paramString);
  }
  
  public void a(String paramString, MqqHandler paramMqqHandler)
  {
    try
    {
      QLog.i("QSplash@QbossSplashNetService", 1, "sendQbossRequest  minigame preload ");
      Object localObject = new ArrayList();
      boolean bool2 = ahae.a().a(2741);
      if ((bool2) && (!"qboss_banner_net_change".equals(paramString))) {
        ((ArrayList)localObject).add(Integer.valueOf(2741));
      }
      boolean bool1;
      if (bgmq.j(BaseApplicationImpl.getApplication().getRuntime()))
      {
        bool1 = ahae.a().a(2742);
        if (!bool1) {
          break label274;
        }
        ((ArrayList)localObject).add(Integer.valueOf(2742));
      }
      for (;;)
      {
        boolean bool3 = ahae.a().a(2783);
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
              a((QQAppInterface)localObject, auem.a(((QQAppInterface)localObject).getAccount()));
            }
            if (!bool3)
            {
              QLog.i("QSplash@QbossSplashNetService", 1, "sendQbossRequest QbossPreDownloadManager.checkPreDownloadResStatus ");
              auef.a().a((QQAppInterface)localObject);
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
 * Qualified Name:     auer
 * JD-Core Version:    0.7.0.1
 */