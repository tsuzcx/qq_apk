package com.tencent.mobileqq.apollo.process.data;

import ainb;
import aing;
import aipe;
import aipj;
import aips;
import aiqs;
import ajam;
import ajfb;
import ajfe;
import android.content.Intent;
import atmq;
import axrr;
import axso;
import bato;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
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
  private atmq jdField_a_of_type_Atmq;
  private axso jdField_a_of_type_Axso;
  List<ajfe> jdField_a_of_type_JavaUtilList = new Vector();
  Map<Integer, Manager> jdField_a_of_type_JavaUtilMap = new HashMap(20);
  private ajfb[] jdField_a_of_type_ArrayOfAjfb = new ajfb[1];
  List<ajfe> b = new Vector();
  List<ajfe> c = new Vector();
  
  public CmGameAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    super(paramBaseApplicationImpl, paramString);
    QLog.i("cmgame_process.CmGameAppInterface", 1, "new CmGameAppInterface obj.");
    ainb.a();
    TVK_SDKMgr.initSdk(BaseApplicationImpl.getContext(), "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
    TVK_SDKMgr.installPlugin(BaseApplicationImpl.getContext(), new aipe(this));
  }
  
  private void a()
  {
    aipj localaipj = aing.a();
    if (localaipj != null) {
      aing.a(localaipj.a());
    }
  }
  
  private ajfb b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    }
    return new aiqs(this);
  }
  
  public ajfb a(int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ArrayOfAjfb[paramInt];
    if (localObject1 != null) {
      return localObject1;
    }
    synchronized (this.jdField_a_of_type_ArrayOfAjfb)
    {
      ajfb localajfb = this.jdField_a_of_type_ArrayOfAjfb[paramInt];
      localObject1 = localajfb;
      if (localajfb == null)
      {
        localajfb = b(paramInt);
        localObject1 = localajfb;
        if (localajfb != null)
        {
          this.jdField_a_of_type_ArrayOfAjfb[paramInt] = localajfb;
          localObject1 = localajfb;
        }
      }
      return localObject1;
    }
  }
  
  public void addObserver(ajfe paramajfe)
  {
    addObserver(paramajfe, false);
  }
  
  public void addObserver(ajfe paramajfe, boolean paramBoolean)
  {
    if (paramajfe == null) {
      return;
    }
    if (paramBoolean) {
      synchronized (this.b)
      {
        if (!this.b.contains(paramajfe)) {
          this.b.add(paramajfe);
        }
        return;
      }
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramajfe)) {
        this.jdField_a_of_type_JavaUtilList.add(paramajfe);
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
  
  public List<ajfe> getBusinessObserver(int paramInt)
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
  
  public atmq getEntityManagerFactory(String paramString)
  {
    if (this.jdField_a_of_type_Atmq == null) {
      this.jdField_a_of_type_Atmq = new QQEntityManagerFactory(getAccount());
    }
    return this.jdField_a_of_type_Atmq;
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
          localObject1 = new aips(this);
          break;
        case 256: 
          localObject4 = new axso();
        }
      }
      finally {}
      this.jdField_a_of_type_Axso = ((axso)localObject4);
      continue;
      Object localObject4 = new bato(this);
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
  
  public axrr getNetEngine(int paramInt)
  {
    if (this.jdField_a_of_type_Axso == null) {
      this.jdField_a_of_type_Axso = ((axso)getManager(256));
    }
    return this.jdField_a_of_type_Axso.a(this, paramInt);
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
    ajam.a();
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
    if (aing.a() != null)
    {
      QLog.i("cmgame_process.CmGameAppInterface", 1, "NOT kill tool process");
      return true;
    }
    return false;
  }
  
  public void removeObserver(ajfe paramajfe)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramajfe);
      synchronized (this.b)
      {
        this.b.remove(paramajfe);
      }
    }
    synchronized (this.c)
    {
      this.c.remove(paramajfe);
      return;
      paramajfe = finally;
      throw paramajfe;
      paramajfe = finally;
      throw paramajfe;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameAppInterface
 * JD-Core Version:    0.7.0.1
 */