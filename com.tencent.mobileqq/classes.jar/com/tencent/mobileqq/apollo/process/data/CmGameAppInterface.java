package com.tencent.mobileqq.apollo.process.data;

import aizu;
import ajae;
import ajcc;
import ajch;
import ajcq;
import ajdq;
import ajoo;
import ajtd;
import ajtg;
import android.content.Intent;
import auko;
import ayry;
import aysv;
import bbwi;
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
  private auko jdField_a_of_type_Auko;
  private aysv jdField_a_of_type_Aysv;
  List<ajtg> jdField_a_of_type_JavaUtilList = new Vector();
  Map<Integer, Manager> jdField_a_of_type_JavaUtilMap = new HashMap(20);
  private ajtd[] jdField_a_of_type_ArrayOfAjtd = new ajtd[1];
  List<ajtg> b = new Vector();
  List<ajtg> c = new Vector();
  
  public CmGameAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    super(paramBaseApplicationImpl, paramString);
    QLog.i("cmgame_process.CmGameAppInterface", 1, "new CmGameAppInterface obj.");
    aizu.a();
    TVK_SDKMgr.initSdk(BaseApplicationImpl.getContext(), "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
    TVK_SDKMgr.installPlugin(BaseApplicationImpl.getContext(), new ajcc(this));
  }
  
  private void a()
  {
    ajch localajch = ajae.a();
    if (localajch != null) {
      ajae.a(localajch.a());
    }
  }
  
  private ajtd b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    }
    return new ajdq(this);
  }
  
  public ajtd a(int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ArrayOfAjtd[paramInt];
    if (localObject1 != null) {
      return localObject1;
    }
    synchronized (this.jdField_a_of_type_ArrayOfAjtd)
    {
      ajtd localajtd = this.jdField_a_of_type_ArrayOfAjtd[paramInt];
      localObject1 = localajtd;
      if (localajtd == null)
      {
        localajtd = b(paramInt);
        localObject1 = localajtd;
        if (localajtd != null)
        {
          this.jdField_a_of_type_ArrayOfAjtd[paramInt] = localajtd;
          localObject1 = localajtd;
        }
      }
      return localObject1;
    }
  }
  
  public void addObserver(ajtg paramajtg)
  {
    addObserver(paramajtg, false);
  }
  
  public void addObserver(ajtg paramajtg, boolean paramBoolean)
  {
    if (paramajtg == null) {
      return;
    }
    if (paramBoolean) {
      synchronized (this.b)
      {
        if (!this.b.contains(paramajtg)) {
          this.b.add(paramajtg);
        }
        return;
      }
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramajtg)) {
        this.jdField_a_of_type_JavaUtilList.add(paramajtg);
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
  
  public List<ajtg> getBusinessObserver(int paramInt)
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
  
  public auko getEntityManagerFactory(String paramString)
  {
    if (this.jdField_a_of_type_Auko == null) {
      this.jdField_a_of_type_Auko = new QQEntityManagerFactory(getAccount());
    }
    return this.jdField_a_of_type_Auko;
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
          localObject1 = new ajcq(this);
          break;
        case 256: 
          localObject4 = new aysv();
        }
      }
      finally {}
      this.jdField_a_of_type_Aysv = ((aysv)localObject4);
      continue;
      Object localObject4 = new bbwi(this);
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
  
  public ayry getNetEngine(int paramInt)
  {
    if (this.jdField_a_of_type_Aysv == null) {
      this.jdField_a_of_type_Aysv = ((aysv)getManager(256));
    }
    return this.jdField_a_of_type_Aysv.a(this, paramInt);
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
    ajoo.a();
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
    if (ajae.a() != null)
    {
      QLog.i("cmgame_process.CmGameAppInterface", 1, "NOT kill tool process");
      return true;
    }
    return false;
  }
  
  public void removeObserver(ajtg paramajtg)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramajtg);
      synchronized (this.b)
      {
        this.b.remove(paramajtg);
      }
    }
    synchronized (this.c)
    {
      this.c.remove(paramajtg);
      return;
      paramajtg = finally;
      throw paramajtg;
      paramajtg = finally;
      throw paramajtg;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameAppInterface
 * JD-Core Version:    0.7.0.1
 */