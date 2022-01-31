package com.tencent.mobileqq.app.proxy.fts;

import android.os.Message;
import com.tencent.mobileqq.app.FTSConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.fts.FTSDatabase;
import com.tencent.mobileqq.persistence.fts.FTSDatatbase;
import com.tencent.mobileqq.utils.fts.SQLiteFTSUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public abstract class FTSIndexOperator
  extends Observable
  implements FTSConstants
{
  protected int a;
  public QQAppInterface a;
  public FTSSyncHandler a;
  protected FTSUpgrader a;
  public FTSDatabase a;
  protected FTSDatatbase a;
  protected boolean a;
  protected boolean b;
  private boolean c;
  
  public FTSIndexOperator(QQAppInterface paramQQAppInterface, FTSSyncHandler paramFTSSyncHandler)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppProxyFtsFTSSyncHandler = paramFTSSyncHandler;
  }
  
  public ArrayList a(String paramString, Class paramClass, boolean paramBoolean1, boolean paramBoolean2)
  {
    return null;
  }
  
  public ArrayList a(String paramString, Class paramClass, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    return null;
  }
  
  public void a()
  {
    this.b = true;
    if (this.jdField_a_of_type_ComTencentMobileqqAppProxyFtsFTSUpgrader != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyFtsFTSUpgrader.a();
    }
  }
  
  public void a(Observer paramObserver)
  {
    if (paramObserver != null) {
      addObserver(paramObserver);
    }
  }
  
  public boolean a()
  {
    if (SQLiteFTSUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != 1) {}
    while (this.jdField_a_of_type_ComTencentMobileqqAppProxyFtsFTSUpgrader == null) {
      return false;
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppProxyFtsFTSUpgrader.a();
  }
  
  public boolean a(FTSDatatbase paramFTSDatatbase, FTSDatabase paramFTSDatabase)
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase = paramFTSDatatbase;
    this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase = paramFTSDatabase;
    return true;
  }
  
  public void b()
  {
    if (a()) {
      b();
    }
  }
  
  public void b(Observer paramObserver)
  {
    if (paramObserver != null) {
      deleteObserver(paramObserver);
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppProxyFtsFTSUpgrader != null) {
      return this.jdField_a_of_type_ComTencentMobileqqAppProxyFtsFTSUpgrader.b();
    }
    return true;
  }
  
  public void c()
  {
    setChanged();
    notifyObservers();
  }
  
  public boolean c()
  {
    return true;
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppProxyFtsFTSSyncHandler.obtainMessage(2, this).sendToTarget();
  }
  
  protected boolean d()
  {
    boolean bool3 = false;
    int i;
    boolean bool1;
    if (!this.c) {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.a();
        if (i == 0)
        {
          this.c = true;
          bool1 = false;
          label39:
          bool2 = bool1;
          if (i == 1) {
            this.c = true;
          }
        }
      }
    }
    for (boolean bool2 = bool1;; bool2 = true)
    {
      if ((bool2) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Stop)) {}
      for (bool1 = bool3;; bool1 = bool2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.fts.sync_worker", 2, "isSaveDBAtOnce unActionLoginB atOnce:" + bool1);
        }
        return bool1;
      }
      bool1 = true;
      break label39;
      i = 0;
      break;
    }
  }
  
  public abstract void e();
  
  public boolean e()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.fts.FTSIndexOperator
 * JD-Core Version:    0.7.0.1
 */