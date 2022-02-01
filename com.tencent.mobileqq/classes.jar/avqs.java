import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.data.RecentItemImaxADData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.imaxad.ImaxAdRecentUserManager.1;
import com.tencent.mobileqq.imaxad.ImaxAdRecentUserManager.2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class avqs
{
  private static avqs jdField_a_of_type_Avqs;
  private ConcurrentHashMap<String, oeq> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public static avqs a()
  {
    try
    {
      if (jdField_a_of_type_Avqs == null) {
        jdField_a_of_type_Avqs = new avqs();
      }
      avqs localavqs = jdField_a_of_type_Avqs;
      return localavqs;
    }
    finally {}
  }
  
  private void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, int paramInt, oeq paramoeq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ImaxAdvertisement", 2, "jumpToImaxDisplayActivity item :" + paramString);
    }
    Intent localIntent = new Intent(paramContext, PublicAccountAdvertisementActivity.class);
    localIntent.putExtra("arg_ad_json", paramoeq.a());
    localIntent.putExtra("USR_CLICK_TIME", SystemClock.uptimeMillis());
    localIntent.putExtra("is_first_open_imax_ad", alik.c);
    alik.c = false;
    paramContext.startActivity(localIntent);
    ThreadManager.post(new ImaxAdRecentUserManager.2(this, paramQQAppInterface, paramString, paramInt, paramoeq), 5, null, false);
    oez.a().a(paramQQAppInterface, 2, paramoeq);
  }
  
  public List<oeq> a(String paramString)
  {
    ArrayList localArrayList1 = new ArrayList(2);
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values() != null))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        oeq localoeq = (oeq)localIterator.next();
        ArrayList localArrayList2 = localoeq.jdField_a_of_type_JavaUtilArrayList;
        if ((localArrayList2 != null) && (localArrayList2.size() > 0) && (paramString.equals(((oer)localArrayList2.get(0)).b)) && (localoeq.jdField_a_of_type_Int == 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ImaxAdvertisement", 2, "getAdvertisementItembyVid:" + paramString + " item:" + localoeq.jdField_a_of_type_JavaLangString);
          }
          localArrayList1.add(localoeq);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ImaxAdvertisement", 2, "getAdvertisementItem disPlayitemList:" + localArrayList1.size());
    }
    return localArrayList1;
  }
  
  public oeq a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (oeq)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  public void a(QQAppInterface paramQQAppInterface, algc paramalgc, AbsListView paramAbsListView)
  {
    int i;
    if ((paramAbsListView != null) && (paramalgc != null) && (paramQQAppInterface != null))
    {
      i = paramAbsListView.getFirstVisiblePosition();
      if (i <= 0) {
        break label369;
      }
      i -= 1;
    }
    label239:
    label369:
    for (;;)
    {
      int k = paramAbsListView.getLastVisiblePosition();
      int j = i;
      for (;;)
      {
        Object localObject1;
        if (j < k + 1)
        {
          localObject1 = paramalgc.getItem(j);
          if ((localObject1 == null) || (!(localObject1 instanceof RecentItemImaxADData))) {
            break label360;
          }
          localObject1 = (RecentItemImaxADData)localObject1;
          localObject2 = paramQQAppInterface.getConversationFacade().a(((RecentItemImaxADData)localObject1).mUser.uin, ((RecentItemImaxADData)localObject1).mUser.getType());
          if (localObject2 != null) {
            ((ConversationInfo)localObject2).isImax = true;
          }
          if (!avqu.a(paramAbsListView.getChildAt(j - i))) {
            break label360;
          }
          localObject3 = ((RecentItemImaxADData)localObject1).mUser.uin;
          localObject2 = b((String)localObject3);
          localObject1 = localObject2;
          if (localObject2 != null) {
            break label245;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ImaxAdvertisement", 2, "isShowImaxAdItem item recreated " + (String)localObject3);
          }
          localObject1 = oeq.a(avqu.b(paramQQAppInterface.getCurrentUin(), (String)localObject3));
          if (localObject1 != null) {
            break label239;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ImaxAdvertisement", 2, "isShowImaxAdItem item false " + (String)localObject3);
          }
        }
        return;
        a((oeq)localObject1);
        label245:
        Object localObject2 = Message.obtain();
        Object localObject3 = new HashMap();
        ((HashMap)localObject3).put("key_app", new WeakReference(paramQQAppInterface));
        ((HashMap)localObject3).put("key_adapter", new WeakReference(paramalgc));
        ((HashMap)localObject3).put("key_listview", new WeakReference(paramAbsListView));
        ((Message)localObject2).obj = localObject3;
        localObject3 = new Bundle();
        ((Bundle)localObject3).putString("key_ad_id", ((oeq)localObject1).c);
        ((Message)localObject2).setData((Bundle)localObject3);
        ((Message)localObject2).what = 2;
        avqq.a().a((Message)localObject2);
        j += 1;
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser)
  {
    oeq localoeq;
    if ((paramRecentUser != null) && (paramRecentUser.uin != null))
    {
      localoeq = b(paramRecentUser.uin);
      if ((localoeq != null) && (NetConnInfoCenter.getServerTimeMillis() >= localoeq.b))
      {
        localObject = (ProxyManager)paramQQAppInterface.getManager(QQManagerFactory.PROXY_MANAGER);
        if (localObject != null) {
          break label137;
        }
      }
    }
    label137:
    for (Object localObject = null;; localObject = ((ProxyManager)localObject).a())
    {
      if (localObject != null)
      {
        algs.a().a(paramRecentUser.uin + "-" + paramRecentUser.getType());
        ((aoxz)localObject).delRecentUser(paramRecentUser);
        alik.b(paramQQAppInterface, localoeq.jdField_a_of_type_JavaLangString, 10005);
        paramQQAppInterface.getMessageFacade().setReaded(localoeq.jdField_a_of_type_JavaLangString, 10005);
      }
      a(paramQQAppInterface, paramRecentUser, localoeq, false);
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser, oeq paramoeq, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ImaxAdvertisement", 2, "dodelete ExpireItem uin:" + paramRecentUser.uin);
    }
    ThreadManager.executeOnFileThread(new ImaxAdRecentUserManager.1(this, paramBoolean, paramQQAppInterface, paramoeq, paramRecentUser));
    a(paramRecentUser.uin);
  }
  
  public void a(oeq paramoeq)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramoeq.jdField_a_of_type_JavaLangString, paramoeq);
  }
  
  public boolean a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      if (paramQQAppInterface != null) {
        break label55;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImaxAdvertisement", 2, "openImaxAdvertisement result " + bool1);
      }
      return bool1;
      label55:
      if (TextUtils.isEmpty(paramString))
      {
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("ImaxAdvertisement", 2, "openImaxAdvertisement empty uin!");
          bool1 = bool2;
        }
      }
      else
      {
        oeq localoeq = b(paramString);
        if (localoeq == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ImaxAdvertisement", 2, "openAdvertisement item recreated :" + paramString);
          }
          localoeq = oeq.a(avqu.b(paramQQAppInterface.getCurrentUin(), paramString));
          bool1 = bool2;
          if (localoeq != null)
          {
            a(localoeq);
            a(paramContext, paramQQAppInterface, paramString, paramInt, localoeq);
            bool1 = true;
          }
        }
        else
        {
          a(paramContext, paramQQAppInterface, paramString, paramInt, localoeq);
          bool1 = true;
        }
      }
    }
  }
  
  public oeq b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return (oeq)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    }
    return null;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values() != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
      while (localIterator.hasNext()) {
        ((oeq)localIterator.next()).jdField_a_of_type_Boolean = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avqs
 * JD-Core Version:    0.7.0.1
 */