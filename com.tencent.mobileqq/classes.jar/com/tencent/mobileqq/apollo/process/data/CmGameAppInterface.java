package com.tencent.mobileqq.apollo.process.data;

import anat;
import anbd;
import ancz;
import ande;
import andn;
import android.content.Intent;
import anen;
import anpq;
import anud;
import anui;
import beuo;
import bevk;
import bihw;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import mqq.app.IToolProcEventListener;
import mqq.manager.Manager;

public class CmGameAppInterface
  extends AppInterface
  implements IToolProcEventListener
{
  private bevk jdField_a_of_type_Bevk;
  private EntityManagerFactory jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
  List<anui> jdField_a_of_type_JavaUtilList = new Vector();
  Map<Integer, Manager> jdField_a_of_type_JavaUtilMap = new HashMap(20);
  private anud[] jdField_a_of_type_ArrayOfAnud = new anud[1];
  List<anui> b = new Vector();
  List<anui> c = new Vector();
  
  public CmGameAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    super(paramBaseApplicationImpl, paramString);
    QLog.i("cmgame_process.CmGameAppInterface", 1, "new CmGameAppInterface obj.");
    anat.a();
    TVK_SDKMgr.initSdk(BaseApplicationImpl.getContext(), "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
    TVK_SDKMgr.installPlugin(BaseApplicationImpl.getContext(), new ancz(this));
  }
  
  private void a()
  {
    ande localande = anbd.a();
    if (localande != null) {
      anbd.a(localande.a());
    }
  }
  
  private anud b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    }
    return new anen(this);
  }
  
  public anud a(int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ArrayOfAnud[paramInt];
    if (localObject1 != null) {
      return localObject1;
    }
    synchronized (this.jdField_a_of_type_ArrayOfAnud)
    {
      anud localanud = this.jdField_a_of_type_ArrayOfAnud[paramInt];
      localObject1 = localanud;
      if (localanud == null)
      {
        localanud = b(paramInt);
        localObject1 = localanud;
        if (localanud != null)
        {
          this.jdField_a_of_type_ArrayOfAnud[paramInt] = localanud;
          localObject1 = localanud;
        }
      }
      return localObject1;
    }
  }
  
  public void addObserver(anui paramanui)
  {
    addObserver(paramanui, false);
  }
  
  public void addObserver(anui paramanui, boolean paramBoolean)
  {
    if (paramanui == null) {
      return;
    }
    if (paramBoolean) {
      synchronized (this.b)
      {
        if (!this.b.contains(paramanui)) {
          this.b.add(paramanui);
        }
        return;
      }
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramanui)) {
        this.jdField_a_of_type_JavaUtilList.add(paramanui);
      }
      return;
    }
  }
  
  public BaseApplication getApp()
  {
    return this.app;
  }
  
  public int getAppid()
  {
    return AppSetting.a();
  }
  
  public List<anui> getBusinessObserver(int paramInt)
  {
    if (paramInt == 1) {
      return this.jdField_a_of_type_JavaUtilList;
    }
    if (paramInt == 2) {
      return this.b;
    }
    if (paramInt == 0) {
      return this.c;
    }
    return this.c;
  }
  
  public String getCurrentAccountUin()
  {
    return getAccount();
  }
  
  public EntityManagerFactory getEntityManagerFactory(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory == null) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory = new QQEntityManagerFactory(getAccount());
    }
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
  }
  
  public Manager getManager(int paramInt)
  {
    for (;;)
    {
      try
      {
        Object localObject1 = (Manager)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
        localObject5 = localObject1;
        Map localMap;
        if (localObject1 == null) {
          localMap = this.jdField_a_of_type_JavaUtilMap;
        }
        switch (paramInt)
        {
        default: 
        case 255: 
          try
          {
            if (this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt)) == null) {
              break;
            }
            localObject5 = (Manager)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
            localObject1 = localObject5;
            if (localObject5 == null) {
              localObject1 = super.getManager(paramInt);
            }
            return localObject1;
          }
          finally {}
          localObject1 = new andn(this);
          break;
        case 256: 
          localObject4 = new bevk();
        }
      }
      finally {}
      this.jdField_a_of_type_Bevk = ((bevk)localObject4);
      continue;
      Object localObject4 = new bihw(this);
      continue;
      Object localObject5 = localObject4;
      if (localObject4 != null)
      {
        this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), localObject4);
        localObject5 = localObject4;
      }
    }
  }
  
  public String getModuleId()
  {
    return "cmshowgame_module";
  }
  
  public beuo getNetEngine(int paramInt)
  {
    if (this.jdField_a_of_type_Bevk == null) {
      this.jdField_a_of_type_Bevk = ((bevk)getManager(256));
    }
    return this.jdField_a_of_type_Bevk.a(this, paramInt);
  }
  
  public void onBeforeExitProc()
  {
    QLog.i("cmgame_process.CmGameAppInterface", 1, "[onBeforeExitProc]");
    a();
  }
  
  public void onDestroy()
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      Object localObject1 = this.jdField_a_of_type_JavaUtilMap.keySet();
      if ((localObject1 != null) && (((Set)localObject1).size() > 0))
      {
        localObject1 = ((Set)localObject1).iterator();
        do
        {
          for (;;)
          {
            boolean bool = ((Iterator)localObject1).hasNext();
            if (!bool) {
              break label114;
            }
            try
            {
              Manager localManager = (Manager)this.jdField_a_of_type_JavaUtilMap.get(((Iterator)localObject1).next());
              if (localManager != null) {
                localManager.onDestroy();
              }
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
            }
          }
        } while (!QLog.isColorLevel());
        QLog.e("cmgame_process.CmGameAppInterface", 2, "onDesotry", localException);
      }
    }
    label114:
    this.jdField_a_of_type_JavaUtilMap.clear();
    anpq.a();
  }
  
  public boolean onReceiveAccountAction(String paramString, Intent paramIntent)
  {
    QLog.i("cmgame_process.CmGameAppInterface", 1, "[onReceiveAccountAction]");
    a();
    return false;
  }
  
  public boolean onReceiveLegalExitProcAction(Intent paramIntent)
  {
    QLog.i("cmgame_process.CmGameAppInterface", 1, "[onReceiveLegalExitProcAction]");
    if (anbd.a() != null)
    {
      QLog.i("cmgame_process.CmGameAppInterface", 1, "NOT kill tool process");
      return true;
    }
    return false;
  }
  
  public void removeObserver(anui paramanui)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramanui);
      synchronized (this.b)
      {
        this.b.remove(paramanui);
      }
    }
    synchronized (this.c)
    {
      this.c.remove(paramanui);
      return;
      paramanui = finally;
      throw paramanui;
      paramanui = finally;
      throw paramanui;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameAppInterface
 * JD-Core Version:    0.7.0.1
 */