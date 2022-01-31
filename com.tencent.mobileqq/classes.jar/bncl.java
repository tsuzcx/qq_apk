import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import dov.com.tencent.biz.qqstory.takevideo.sendpanel.SendPanelManager.1;
import dov.com.tencent.biz.qqstory.takevideo.sendpanel.SendPanelManager.2;
import dov.com.tencent.biz.qqstory.takevideo.sendpanel.SendPanelManager.3;
import dov.com.tencent.biz.qqstory.takevideo.sendpanel.SendPanelManager.4;
import dov.com.tencent.biz.qqstory.takevideo.sendpanel.SendPanelManager.5;
import dov.com.tencent.biz.qqstory.takevideo.sendpanel.SendPanelManager.6;
import dov.com.tencent.biz.qqstory.takevideo.sendpanel.SendPanelManager.7;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class bncl
  implements Manager
{
  private int jdField_a_of_type_Int = 0;
  private ammo jdField_a_of_type_Ammo;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private bncb jdField_a_of_type_Bncb;
  public volatile String a;
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap;
  private List<RecentUser> jdField_a_of_type_JavaUtilList = new ArrayList();
  private CopyOnWriteArrayList<bnck> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  public volatile boolean a;
  private volatile String jdField_b_of_type_JavaLangString;
  private volatile boolean jdField_b_of_type_Boolean;
  private volatile boolean c;
  
  private bncl()
  {
    a();
  }
  
  public static bncl a()
  {
    return bncm.a();
  }
  
  private String a(RecentUser paramRecentUser)
  {
    String str1 = "";
    String str2;
    if ((paramRecentUser == null) || (this.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilHashMap.isEmpty()))
    {
      str2 = "";
      return str2;
    }
    switch (paramRecentUser.getType())
    {
    }
    for (;;)
    {
      str2 = str1;
      if (!TextUtils.isEmpty(str1)) {
        break;
      }
      return paramRecentUser.displayName;
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get(paramRecentUser.uin + 0);
      continue;
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get(paramRecentUser.uin + 1);
      continue;
      str1 = this.jdField_a_of_type_Ammo.a(paramRecentUser.uin);
      continue;
      bmcp.a(paramRecentUser.troopUin, paramRecentUser.uin);
      continue;
      str1 = this.jdField_a_of_type_Ammo.a(paramRecentUser.troopUin, paramRecentUser.uin);
    }
  }
  
  private void a()
  {
    this.jdField_a_of_type_Ammo = new ammo();
    this.jdField_a_of_type_Ammo.a();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    bmcv.a();
  }
  
  private void a(bnck parambnck, int paramInt1, int paramInt2)
  {
    int i = parambnck.jdField_b_of_type_Int;
    if (i == 1) {
      if ((paramInt1 == 1003) || (paramInt1 == 1007))
      {
        parambnck.jdField_b_of_type_Int = 3;
        parambnck.jdField_c_of_type_Int = 100;
      }
    }
    while ((i != 0) || ((paramInt1 != 1003) && (paramInt1 != 1007)))
    {
      return;
      if ((paramInt1 == 1004) || (paramInt1 == 1005) || (paramInt1 == 1006))
      {
        parambnck.jdField_b_of_type_Int = 2;
        return;
      }
      parambnck.jdField_c_of_type_Int = paramInt2;
      return;
    }
    parambnck.jdField_b_of_type_Int = 3;
    parambnck.jdField_c_of_type_Int = 100;
  }
  
  private void a(List<RecentUser> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        RecentUser localRecentUser = (RecentUser)paramList.next();
        if (a(localRecentUser.getType())) {
          this.jdField_a_of_type_JavaUtilList.add(localRecentUser);
        }
      }
    }
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1) || (paramInt == 3000);
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.e("SendPanelManager", 2, "loadPanelData");
    }
    if (this.jdField_a_of_type_Bncb != null) {
      this.jdField_a_of_type_Bncb.c();
    }
    j();
    d();
    this.jdField_a_of_type_Int = 1;
    try
    {
      ThreadManager.getFileThreadHandler().post(new SendPanelManager.1(this));
      ThreadManager.getSubThreadHandler().post(new SendPanelManager.2(this));
      ThreadManager.getFileThreadHandler().post(new SendPanelManager.3(this));
      return;
    }
    catch (Exception localException)
    {
      while (this.jdField_a_of_type_Bncb == null) {}
      if (QLog.isColorLevel()) {
        QLog.e("SendPanelManager", 2, "loadPanelData exception = " + localException.getMessage());
      }
      this.jdField_a_of_type_Int = 3;
      i();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      while (this.jdField_a_of_type_Bncb == null) {}
      if (QLog.isColorLevel()) {
        QLog.e("SendPanelManager", 2, "loadPanelData OutOfMemoryError");
      }
      this.jdField_a_of_type_Int = 3;
      i();
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_Boolean = BaseApplicationImpl.getApplication().getSharedPreferences("file_short_send_panel", 0).getBoolean("send_panel_animation_" + BaseApplicationImpl.getApplication().getRuntime().getAccount(), true);
  }
  
  private void d()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  private void e()
  {
    a(this.jdField_a_of_type_Ammo.a(RecentUser.class, "select * from recent order by lastmsgtime desc", null));
    f();
    this.jdField_b_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.e("SendPanelManager", 2, "loadRecentUserList finish");
    }
    h();
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      Object localObject2 = new ArrayList();
      Object localObject1 = new ArrayList();
      Object localObject3 = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        RecentUser localRecentUser = (RecentUser)((Iterator)localObject3).next();
        if (localRecentUser.showUpTime > 0L) {
          ((List)localObject2).add(localRecentUser);
        } else {
          ((List)localObject1).add(localRecentUser);
        }
      }
      this.jdField_a_of_type_JavaUtilList.clear();
      if (((List)localObject2).size() > 0)
      {
        Collections.sort((List)localObject2, new bncd());
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (RecentUser)((Iterator)localObject2).next();
          this.jdField_a_of_type_JavaUtilList.add(localObject3);
        }
      }
      if (((List)localObject1).size() > 0)
      {
        Collections.sort((List)localObject1, new bncd());
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (RecentUser)((Iterator)localObject1).next();
          this.jdField_a_of_type_JavaUtilList.add(localObject2);
        }
      }
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_Ammo.a(0, this.jdField_a_of_type_JavaUtilHashMap);
    this.jdField_a_of_type_Ammo.b(1, this.jdField_a_of_type_JavaUtilHashMap);
    this.jdField_c_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.e("SendPanelManager", 2, "loadNameList finish");
    }
    h();
  }
  
  private void h()
  {
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_c_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.e("SendPanelManager", 2, "conformAllData");
      }
      if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
        break label406;
      }
      localObject = new ArrayList();
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localRecentUser = (RecentUser)localIterator.next();
        localbnck = new bnck();
        localbnck.jdField_a_of_type_JavaLangString = localRecentUser.uin;
        localbnck.jdField_b_of_type_JavaLangString = localRecentUser.troopUin;
        if (localRecentUser.getType() == 1000)
        {
          localbnck.jdField_c_of_type_JavaLangString = localRecentUser.displayName;
          ((List)localObject).add(localRecentUser);
        }
        for (;;)
        {
          if (localRecentUser.getType() == 1)
          {
            localPair = bmcp.a(localRecentUser.uin);
            if (localPair != null)
            {
              if (((Boolean)localPair.first).booleanValue())
              {
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.e("SendPanelManager", 2, "conformAllData troop is disband");
                break;
                localbnck.jdField_c_of_type_JavaLangString = a(localRecentUser);
                continue;
              }
              localbnck.jdField_c_of_type_Boolean = ((Boolean)localPair.second).booleanValue();
            }
          }
        }
        localbnck.jdField_a_of_type_Int = localRecentUser.getType();
        if ((localRecentUser.getType() == 0) && (!TextUtils.isEmpty(localbnck.jdField_a_of_type_JavaLangString)) && ((TextUtils.isEmpty(localbnck.jdField_c_of_type_JavaLangString)) || (localbnck.jdField_a_of_type_JavaLangString.equals(localbnck.jdField_c_of_type_JavaLangString)))) {
          localbnck.jdField_c_of_type_JavaLangString = bmcp.a(localbnck.jdField_a_of_type_JavaLangString);
        }
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localbnck);
      }
      if (((List)localObject).size() > 0)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          a((RecentUser)((Iterator)localObject).next());
        }
      }
      if (this.jdField_a_of_type_JavaUtilList != null) {
        this.jdField_a_of_type_JavaUtilList.clear();
      }
      if (this.jdField_a_of_type_JavaUtilHashMap != null) {
        this.jdField_a_of_type_JavaUtilHashMap.clear();
      }
      if (this.jdField_a_of_type_Bncb != null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SendPanelManager", 2, "conformAllData onLoadFinish");
        }
        this.jdField_a_of_type_Int = 2;
        i();
      }
    }
    label406:
    while (this.jdField_a_of_type_Bncb == null)
    {
      Object localObject;
      Iterator localIterator;
      RecentUser localRecentUser;
      bnck localbnck;
      Pair localPair;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("SendPanelManager", 2, "conformAllData onLoadFinish recentUserList is empty");
    }
    this.jdField_a_of_type_Int = 2;
    i();
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_Bncb != null) {
      this.jdField_a_of_type_AndroidOsHandler.post(new SendPanelManager.4(this));
    }
  }
  
  private void j()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      this.jdField_a_of_type_JavaUtilHashMap = null;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    }
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public List<bnck> a()
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) && (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() > 0)) {
      return this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
    }
    b();
    return null;
  }
  
  public void a(bncb parambncb)
  {
    this.jdField_a_of_type_Bncb = parambncb;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    if (TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.e("SendPanelManager", 2, "updateOperateStatus uin is null");
      }
    }
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_Bncb != null) && (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) && (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() > 0))
      {
        int j = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size();
        int i = 0;
        while (i < j)
        {
          bnck localbnck = (bnck)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i);
          if ((!TextUtils.isEmpty(localbnck.jdField_a_of_type_JavaLangString)) && (localbnck.jdField_a_of_type_JavaLangString.equals(paramString)) && (localbnck.jdField_a_of_type_Int == paramInt1) && (localbnck.jdField_b_of_type_Boolean))
          {
            a(localbnck, paramInt2, paramInt3);
            if (localbnck.jdField_a_of_type_Long <= 0L) {
              localbnck.jdField_a_of_type_Long = paramLong;
            }
            if (QLog.isColorLevel()) {
              QLog.i("SendPanelManager", 2, "updateOperateStatus operateStatus = " + localbnck.jdField_b_of_type_Int + " ,progress = " + localbnck.jdField_c_of_type_Int + " ,position = " + i + ", uinseq:" + localbnck.jdField_a_of_type_Long);
            }
            this.jdField_a_of_type_AndroidOsHandler.post(new SendPanelManager.6(this, i, localbnck));
            return;
          }
          i += 1;
        }
      }
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      if (QLog.isColorLevel()) {
        QLog.e("SendPanelManager", 2, "updateFilePath fileMd5 is null");
      }
    }
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) && (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() > 0))
      {
        paramString1 = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
        while (paramString1.hasNext()) {
          ((bnck)paramString1.next()).g = paramString2;
        }
      }
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("SendPanelManager", 2, "updateFilePath fail uin = " + paramString1 + " ,filePath = " + paramString2);
      }
      if (this.jdField_a_of_type_Bncb != null) {
        this.jdField_a_of_type_Bncb.e();
      }
      return;
    }
    Object localObject3 = null;
    Object localObject1 = null;
    int i = -1;
    int k = i;
    Object localObject2 = localObject3;
    int j;
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null)
    {
      k = i;
      localObject2 = localObject3;
      if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() > 0)
      {
        int m = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size();
        j = 0;
        label127:
        k = i;
        localObject2 = localObject1;
        if (j < m)
        {
          localObject2 = (bnck)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(j);
          ((bnck)localObject2).e = paramString2;
          ((bnck)localObject2).f = paramString3;
          ((bnck)localObject2).jdField_a_of_type_Boolean = paramBoolean;
          if ((TextUtils.isEmpty(((bnck)localObject2).jdField_a_of_type_JavaLangString)) || (!((bnck)localObject2).jdField_a_of_type_JavaLangString.equals(paramString1)) || (paramInt != ((bnck)localObject2).jdField_a_of_type_Int)) {
            break label389;
          }
          localObject1 = localObject2;
          i = j;
        }
      }
    }
    label389:
    for (;;)
    {
      j += 1;
      break label127;
      if (localObject2 != null)
      {
        ((bnck)localObject2).jdField_b_of_type_Int = 1;
        if (this.jdField_a_of_type_Bncb != null) {
          this.jdField_a_of_type_AndroidOsHandler.post(new SendPanelManager.7(this, k, (bnck)localObject2));
        }
        if (paramBoolean) {
          bmcp.a(((bnck)localObject2).e, paramString3, (bnck)localObject2, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
        }
        for (;;)
        {
          ((bnck)localObject2).jdField_b_of_type_Boolean = true;
          axpl.a((bnck)localObject2);
          bliu.a().a(((bnck)localObject2).g, ((bnck)localObject2).jdField_a_of_type_Int);
          bljn.b("SendPanelManager", "【updateFilePath】messageType:" + ((bnck)localObject2).jdField_a_of_type_Int);
          a(paramString1, paramInt, ((bnck)localObject2).g);
          return;
          bmcp.a(paramString2, (bnck)localObject2, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
        }
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("SendPanelManager", 2, "updateFilePath can not find sendItemInfo");
      return;
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      if (QLog.isColorLevel()) {
        QLog.e("SendPanelManager", 2, "updateTroopMemberName uin = " + paramString1 + " ,name = " + paramString2);
      }
    }
    do
    {
      for (;;)
      {
        return;
        if ((this.jdField_a_of_type_Bncb == null) || (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) || (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() <= 0)) {
          break;
        }
        int j = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size();
        int i = 0;
        while (i < j)
        {
          bnck localbnck = (bnck)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i);
          if ((!TextUtils.isEmpty(localbnck.jdField_a_of_type_JavaLangString)) && (localbnck.jdField_a_of_type_JavaLangString.equals(paramString1)) && (localbnck.jdField_a_of_type_Int == 1000))
          {
            localbnck.jdField_c_of_type_JavaLangString = paramString2;
            if (QLog.isColorLevel()) {
              QLog.e("SendPanelManager", 2, "updateTroopMemberName");
            }
            this.jdField_a_of_type_AndroidOsHandler.post(new SendPanelManager.5(this, i, localbnck));
            return;
          }
          i += 1;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e("SendPanelManager", 2, "updateTroopMemberName exception uin = " + paramString1 + " ,name = " + paramString2);
  }
  
  public void a(boolean paramBoolean)
  {
    BaseApplicationImpl.getApplication().getSharedPreferences("file_short_send_panel", 0).edit().putBoolean("send_panel_animation_" + BaseApplicationImpl.getApplication().getRuntime().getAccount(), paramBoolean).apply();
  }
  
  public void b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.e("SendPanelManager", 2, "onDestroy()");
    }
    j();
    if (this.jdField_a_of_type_Bncb != null)
    {
      this.jdField_a_of_type_Bncb.d();
      this.jdField_a_of_type_Bncb = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bncl
 * JD-Core Version:    0.7.0.1
 */