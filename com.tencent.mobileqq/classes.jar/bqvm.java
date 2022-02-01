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

public class bqvm
  implements Manager
{
  private int jdField_a_of_type_Int = 0;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private aour jdField_a_of_type_Aour;
  private bqvc jdField_a_of_type_Bqvc;
  public volatile String a;
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap;
  private List<RecentUser> jdField_a_of_type_JavaUtilList = new ArrayList();
  private CopyOnWriteArrayList<bqvl> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  public volatile boolean a;
  private volatile String jdField_b_of_type_JavaLangString;
  private volatile boolean jdField_b_of_type_Boolean;
  private volatile boolean c;
  
  private bqvm()
  {
    a();
  }
  
  public static bqvm a()
  {
    return bqvn.a();
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
      str1 = this.jdField_a_of_type_Aour.a(paramRecentUser.uin);
      continue;
      bpxo.a(paramRecentUser.troopUin, paramRecentUser.uin);
      continue;
      str1 = this.jdField_a_of_type_Aour.a(paramRecentUser.troopUin, paramRecentUser.uin);
    }
  }
  
  private void a()
  {
    this.jdField_a_of_type_Aour = new aour();
    this.jdField_a_of_type_Aour.a();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    bpxu.a();
  }
  
  private void a(bqvl parambqvl, int paramInt1, int paramInt2)
  {
    int i = parambqvl.jdField_b_of_type_Int;
    if (i == 1) {
      if ((paramInt1 == 1003) || (paramInt1 == 1007))
      {
        parambqvl.jdField_b_of_type_Int = 3;
        parambqvl.jdField_c_of_type_Int = 100;
      }
    }
    while ((i != 0) || ((paramInt1 != 1003) && (paramInt1 != 1007)))
    {
      return;
      if ((paramInt1 == 1004) || (paramInt1 == 1005) || (paramInt1 == 1006))
      {
        parambqvl.jdField_b_of_type_Int = 2;
        return;
      }
      parambqvl.jdField_c_of_type_Int = paramInt2;
      return;
    }
    parambqvl.jdField_b_of_type_Int = 3;
    parambqvl.jdField_c_of_type_Int = 100;
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
    if (this.jdField_a_of_type_Bqvc != null) {
      this.jdField_a_of_type_Bqvc.c();
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
      while (this.jdField_a_of_type_Bqvc == null) {}
      if (QLog.isColorLevel()) {
        QLog.e("SendPanelManager", 2, "loadPanelData exception = " + localException.getMessage());
      }
      this.jdField_a_of_type_Int = 3;
      i();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      while (this.jdField_a_of_type_Bqvc == null) {}
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
    a(this.jdField_a_of_type_Aour.a(RecentUser.class, "select * from recent order by lastmsgtime desc", null));
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
        Collections.sort((List)localObject2, new bqve());
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (RecentUser)((Iterator)localObject2).next();
          this.jdField_a_of_type_JavaUtilList.add(localObject3);
        }
      }
      if (((List)localObject1).size() > 0)
      {
        Collections.sort((List)localObject1, new bqve());
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
    this.jdField_a_of_type_Aour.a(0, this.jdField_a_of_type_JavaUtilHashMap);
    this.jdField_a_of_type_Aour.b(1, this.jdField_a_of_type_JavaUtilHashMap);
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
        localbqvl = new bqvl();
        localbqvl.jdField_a_of_type_JavaLangString = localRecentUser.uin;
        localbqvl.jdField_b_of_type_JavaLangString = localRecentUser.troopUin;
        if (localRecentUser.getType() == 1000)
        {
          localbqvl.jdField_c_of_type_JavaLangString = localRecentUser.displayName;
          ((List)localObject).add(localRecentUser);
        }
        for (;;)
        {
          if (localRecentUser.getType() == 1)
          {
            localPair = bpxo.a(localRecentUser.uin);
            if (localPair != null)
            {
              if (((Boolean)localPair.first).booleanValue())
              {
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.e("SendPanelManager", 2, "conformAllData troop is disband");
                break;
                localbqvl.jdField_c_of_type_JavaLangString = a(localRecentUser);
                continue;
              }
              localbqvl.jdField_c_of_type_Boolean = ((Boolean)localPair.second).booleanValue();
            }
          }
        }
        localbqvl.jdField_a_of_type_Int = localRecentUser.getType();
        if ((localRecentUser.getType() == 0) && (!TextUtils.isEmpty(localbqvl.jdField_a_of_type_JavaLangString)) && ((TextUtils.isEmpty(localbqvl.jdField_c_of_type_JavaLangString)) || (localbqvl.jdField_a_of_type_JavaLangString.equals(localbqvl.jdField_c_of_type_JavaLangString)))) {
          localbqvl.jdField_c_of_type_JavaLangString = bpxo.a(localbqvl.jdField_a_of_type_JavaLangString);
        }
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localbqvl);
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
      if (this.jdField_a_of_type_Bqvc != null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SendPanelManager", 2, "conformAllData onLoadFinish");
        }
        this.jdField_a_of_type_Int = 2;
        i();
      }
    }
    label406:
    while (this.jdField_a_of_type_Bqvc == null)
    {
      Object localObject;
      Iterator localIterator;
      RecentUser localRecentUser;
      bqvl localbqvl;
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
    if (this.jdField_a_of_type_Bqvc != null) {
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
  
  public List<bqvl> a()
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) && (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() > 0)) {
      return this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
    }
    b();
    return null;
  }
  
  public void a(bqvc parambqvc)
  {
    this.jdField_a_of_type_Bqvc = parambqvc;
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
      if ((this.jdField_a_of_type_Bqvc != null) && (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) && (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() > 0))
      {
        int j = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size();
        int i = 0;
        while (i < j)
        {
          bqvl localbqvl = (bqvl)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i);
          if ((!TextUtils.isEmpty(localbqvl.jdField_a_of_type_JavaLangString)) && (localbqvl.jdField_a_of_type_JavaLangString.equals(paramString)) && (localbqvl.jdField_a_of_type_Int == paramInt1) && (localbqvl.jdField_b_of_type_Boolean))
          {
            a(localbqvl, paramInt2, paramInt3);
            if (localbqvl.jdField_a_of_type_Long <= 0L) {
              localbqvl.jdField_a_of_type_Long = paramLong;
            }
            if (QLog.isColorLevel()) {
              QLog.i("SendPanelManager", 2, "updateOperateStatus operateStatus = " + localbqvl.jdField_b_of_type_Int + " ,progress = " + localbqvl.jdField_c_of_type_Int + " ,position = " + i + ", uinseq:" + localbqvl.jdField_a_of_type_Long);
            }
            this.jdField_a_of_type_AndroidOsHandler.post(new SendPanelManager.6(this, i, localbqvl));
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
          ((bqvl)paramString1.next()).g = paramString2;
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
      if (this.jdField_a_of_type_Bqvc != null) {
        this.jdField_a_of_type_Bqvc.e();
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
          localObject2 = (bqvl)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(j);
          ((bqvl)localObject2).e = paramString2;
          ((bqvl)localObject2).f = paramString3;
          ((bqvl)localObject2).jdField_a_of_type_Boolean = paramBoolean;
          if ((TextUtils.isEmpty(((bqvl)localObject2).jdField_a_of_type_JavaLangString)) || (!((bqvl)localObject2).jdField_a_of_type_JavaLangString.equals(paramString1)) || (paramInt != ((bqvl)localObject2).jdField_a_of_type_Int)) {
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
        ((bqvl)localObject2).jdField_b_of_type_Int = 1;
        if (this.jdField_a_of_type_Bqvc != null) {
          this.jdField_a_of_type_AndroidOsHandler.post(new SendPanelManager.7(this, k, (bqvl)localObject2));
        }
        if (paramBoolean) {
          bpxo.a(((bqvl)localObject2).e, paramString3, (bqvl)localObject2, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
        }
        for (;;)
        {
          ((bqvl)localObject2).jdField_b_of_type_Boolean = true;
          bbgf.a((bqvl)localObject2);
          bozr.a().a(((bqvl)localObject2).g, ((bqvl)localObject2).jdField_a_of_type_Int);
          bpam.b("SendPanelManager", "【updateFilePath】messageType:" + ((bqvl)localObject2).jdField_a_of_type_Int);
          a(paramString1, paramInt, ((bqvl)localObject2).g);
          return;
          bpxo.a(paramString2, (bqvl)localObject2, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
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
        if ((this.jdField_a_of_type_Bqvc == null) || (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) || (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() <= 0)) {
          break;
        }
        int j = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size();
        int i = 0;
        while (i < j)
        {
          bqvl localbqvl = (bqvl)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i);
          if ((!TextUtils.isEmpty(localbqvl.jdField_a_of_type_JavaLangString)) && (localbqvl.jdField_a_of_type_JavaLangString.equals(paramString1)) && (localbqvl.jdField_a_of_type_Int == 1000))
          {
            localbqvl.jdField_c_of_type_JavaLangString = paramString2;
            if (QLog.isColorLevel()) {
              QLog.e("SendPanelManager", 2, "updateTroopMemberName");
            }
            this.jdField_a_of_type_AndroidOsHandler.post(new SendPanelManager.5(this, i, localbqvl));
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
    if (this.jdField_a_of_type_Bqvc != null)
    {
      this.jdField_a_of_type_Bqvc.d();
      this.jdField_a_of_type_Bqvc = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqvm
 * JD-Core Version:    0.7.0.1
 */