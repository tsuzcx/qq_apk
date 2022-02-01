import BOSSStrategyCenter.tAdvDesc;
import NS_MOBILE_QBOSS_PROTO.MobileQbossAdvRsp;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
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
import java.util.Set;
import mqq.os.MqqHandler;

public class baoa
  implements bnfv
{
  private static volatile baoa a;
  
  public static baoa a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new baoa();
      }
      return a;
    }
    finally {}
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
          almo.a().a(paramString.longValue(), 2741);
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
        if ((paramMobileQbossAdvRsp != null) && (!a(paramQQAppInterface))) {
          paramMobileQbossAdvRsp.sendEmptyMessage(1063);
        }
      }
      return;
    }
  }
  
  private void a(almm paramalmm)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localQQAppInterface == null) {}
    label141:
    for (;;)
    {
      return;
      almm localalmm = almo.a().a(localQQAppInterface.getAccount());
      if ((paramalmm != null) && (localalmm != null))
      {
        int j = 0;
        int i;
        if ((paramalmm.a != null) && (localalmm.a != null) && (paramalmm.a.pattern_id != localalmm.a.pattern_id)) {
          i = 1;
        }
        for (;;)
        {
          if (i == 0) {
            break label141;
          }
          paramalmm = localQQAppInterface.getHandler(Conversation.class);
          if (paramalmm == null) {
            break;
          }
          QLog.e("QzoneQbossHelper", 1, "checkIfNeedRemoveBanner remove");
          paramalmm.sendEmptyMessage(1063);
          return;
          i = j;
          if (!TextUtils.isEmpty(paramalmm.c))
          {
            i = j;
            if (!paramalmm.c.equals(localalmm.c)) {
              i = 1;
            }
          }
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    ArrayList localArrayList;
    Object localObject1;
    try
    {
      Object localObject2 = banv.a(BaseApplicationImpl.getContext(), paramLong);
      localArrayList = new ArrayList();
      Object localObject3;
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        localObject1 = banv.a(BaseApplicationImpl.getContext(), paramLong + "");
        localObject3 = bnua.a(BaseApplicationImpl.getContext(), paramLong + "");
        Set localSet1 = banv.a(BaseApplicationImpl.getContext(), paramLong + "");
        Set localSet2 = bnua.a(BaseApplicationImpl.getContext(), paramLong + "");
        localObject3 = banv.a(paramLong + "", (SharedPreferences)localObject3, localSet2);
        if ((banv.a == null) || (banv.a.size() == 0))
        {
          localObject1 = banv.a(paramLong + "", (SharedPreferences)localObject1, localSet1);
          ((HashMap)localObject1).putAll((Map)localObject3);
          localObject2 = ((List)localObject2).iterator();
        }
      }
      else
      {
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          if (((HashMap)localObject1).containsKey(localObject3))
          {
            localObject3 = (banw)((HashMap)localObject1).get(localObject3);
            if (((banw)localObject3).b())
            {
              localArrayList.add(localObject3);
              QLog.i("QSplash@QbossSplashNetService", 1, "checkNeedDowloadAndDowload aid =" + ((banw)localObject3).jdField_b_of_type_JavaLangString + "UIN" + paramLong % 10000L);
            }
            if ((((banw)localObject3).jdField_b_of_type_Int == 3) || (((banw)localObject3).jdField_b_of_type_Int == 2))
            {
              MiniAppPrePullManager.getInstance().prePullAppinfoByLink(((banw)localObject3).f, false, null);
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
      localObject1 = banv.a;
      break;
    } while ((localArrayList == null) || (localArrayList.size() <= 0));
    bans.a(paramQQAppInterface, localArrayList);
  }
  
  private void a(ArrayList<tAdvDesc> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = (tAdvDesc)paramArrayList.get(0);
      if (paramArrayList != null)
      {
        QLog.i("QzoneQbossHelper", 4, "handleQbossBannerData data = " + paramArrayList.res_data);
        paramArrayList = almm.a(paramArrayList);
        a(paramArrayList);
        almo.a().a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramArrayList);
      }
    }
    else
    {
      return;
    }
    QLog.e("QzoneQbossHelper", 1, "handleQbossBannerData data = null");
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = almo.a().a(paramQQAppInterface.getAccount());
      bool1 = bool2;
      if (paramQQAppInterface != null) {
        if (!"1".equals(paramQQAppInterface.c))
        {
          bool1 = bool2;
          if (!"2".equals(paramQQAppInterface.c)) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void b(MobileQbossAdvRsp paramMobileQbossAdvRsp, QQAppInterface paramQQAppInterface)
  {
    if (paramMobileQbossAdvRsp != null) {}
    try
    {
      Object localObject = paramMobileQbossAdvRsp.map_next_query_ts;
      if (localObject != null)
      {
        localObject = (Long)((Map)localObject).get(Integer.valueOf(2783));
        if (localObject != null) {
          almo.a().a(((Long)localObject).longValue(), 2783);
        }
      }
      paramMobileQbossAdvRsp = paramMobileQbossAdvRsp.mapAdv;
      if ((paramMobileQbossAdvRsp != null) && (paramQQAppInterface != null))
      {
        paramMobileQbossAdvRsp = (ArrayList)paramMobileQbossAdvRsp.get(Integer.valueOf(2783));
        bano.a().a(paramMobileQbossAdvRsp, paramQQAppInterface);
      }
      return;
    }
    catch (Exception paramMobileQbossAdvRsp)
    {
      QLog.e("QSplash@QbossSplashNetService", 1, "handleQbossPreDownloadRsp exception", paramMobileQbossAdvRsp);
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
      paramString2 = paramString1.getHandler(Conversation.class);
    } while ((paramString2 == null) || (a(paramString1)));
    paramString2.sendEmptyMessage(1063);
  }
  
  public void a(MobileQbossAdvRsp paramMobileQbossAdvRsp, QQAppInterface paramQQAppInterface)
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
            almo.a().a(((Long)localObject).longValue(), 2742);
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
            banr.a(paramMobileQbossAdvRsp, paramQQAppInterface, (String)localObject);
            i = 1;
            if ((i == 0) && (paramQQAppInterface != null))
            {
              paramMobileQbossAdvRsp = paramQQAppInterface.getAccount();
              QLog.i("QSplash@QbossSplashNetService", 1, "handleQbossSplashRsp cleardata");
              banv.a(BaseApplicationImpl.getContext(), banv.a(paramMobileQbossAdvRsp), false);
              banv.b(BaseApplicationImpl.getContext(), banv.a(paramMobileQbossAdvRsp));
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
            a(paramBundle, paramQQAppInterface);
          }
          if (localArrayList.contains(Integer.valueOf(2783))) {
            b(paramBundle, paramQQAppInterface);
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
    bnfz.a().a(paramArrayList, this, paramString);
  }
  
  public void a(String paramString, MqqHandler paramMqqHandler)
  {
    try
    {
      QLog.i("QSplash@QbossSplashNetService", 1, "sendQbossRequest  minigame preload ");
      Object localObject = new ArrayList();
      boolean bool2 = almo.a().a(2741);
      if ((bool2) && (!"qboss_banner_net_change".equals(paramString))) {
        ((ArrayList)localObject).add(Integer.valueOf(2741));
      }
      boolean bool1;
      if (bnrf.m(BaseApplicationImpl.getApplication().getRuntime()))
      {
        bool1 = almo.a().a(2742);
        if (!bool1) {
          break label274;
        }
        ((ArrayList)localObject).add(Integer.valueOf(2742));
      }
      for (;;)
      {
        boolean bool3 = almo.a().a(2783);
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
              a((QQAppInterface)localObject, banv.a(((QQAppInterface)localObject).getAccount()));
            }
            if (!bool3)
            {
              QLog.i("QSplash@QbossSplashNetService", 1, "sendQbossRequest QbossPreDownloadManager.checkPreDownloadResStatus ");
              bano.a().a((QQAppInterface)localObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baoa
 * JD-Core Version:    0.7.0.1
 */