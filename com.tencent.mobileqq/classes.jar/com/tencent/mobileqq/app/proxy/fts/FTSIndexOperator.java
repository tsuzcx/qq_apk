package com.tencent.mobileqq.app.proxy.fts;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Message;
import com.tencent.mobileqq.app.FTSConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.WVPreloadPskeyConfBean;
import com.tencent.mobileqq.fts.FTSDatabase;
import com.tencent.mobileqq.persistence.fts.FTSDatatbase;
import com.tencent.mobileqq.persistence.fts.FTSEntity;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.fts.SQLiteFTSUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

public abstract class FTSIndexOperator
  extends Observable
  implements FTSConstants
{
  protected int a;
  protected long a;
  protected QQAppInterface a;
  protected FTSSyncHandler a;
  protected FTSUpgrader a;
  protected FTSDatabase a;
  protected FTSDatatbase a;
  protected boolean a;
  protected int b;
  protected boolean b;
  protected int c;
  protected boolean c;
  private boolean d = false;
  
  public FTSIndexOperator(QQAppInterface paramQQAppInterface, FTSSyncHandler paramFTSSyncHandler)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppProxyFtsFTSSyncHandler = paramFTSSyncHandler;
  }
  
  public long a(QQAppInterface paramQQAppInterface)
  {
    long l = paramQQAppInterface.getApp().getSharedPreferences("fts_sp_file", 0).getLong(b() + paramQQAppInterface.getAccount(), 0L);
    if (QLog.isColorLevel()) {
      QLog.d("Q.fts", 2, new Object[] { "getLastMergeCommandTime ", b(), " time:", Long.valueOf(l) });
    }
    return l;
  }
  
  public String a()
  {
    StringBuilder localStringBuilder1 = new StringBuilder(50);
    StringBuilder localStringBuilder2 = localStringBuilder1.append(" ").append(getClass().getSimpleName()).append(" transCount:").append(this.jdField_c_of_type_Int).append(" transCost:").append(this.jdField_a_of_type_Long).append(" transAvg:");
    if (this.jdField_c_of_type_Int != 0) {}
    for (float f = (float)this.jdField_a_of_type_Long * 1.0F / this.jdField_c_of_type_Int;; f = 0.0F)
    {
      localStringBuilder2.append(f);
      this.jdField_a_of_type_Long = 0L;
      this.jdField_c_of_type_Int = 0;
      return localStringBuilder1.toString();
    }
  }
  
  public ArrayList<FTSEntity> a(String paramString, Class<? extends FTSEntity> paramClass, boolean paramBoolean1, boolean paramBoolean2)
  {
    return null;
  }
  
  public ArrayList<FTSEntity> a(String paramString, Class<? extends FTSEntity> paramClass, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    return null;
  }
  
  public void a()
  {
    this.jdField_c_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqAppProxyFtsFTSUpgrader != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyFtsFTSUpgrader.a();
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    paramQQAppInterface.getApp().getSharedPreferences("fts_sp_file", 0).edit().putLong(b() + paramQQAppInterface.getAccount(), paramLong).commit();
    if (QLog.isColorLevel()) {
      QLog.d("Q.fts", 2, new Object[] { "setLastMergeCommandTime ", b(), " time:", Long.valueOf(paramLong) });
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
  
  public abstract String b();
  
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
    if (!this.d) {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.mAutomator.a();
        if (i == 0)
        {
          this.d = true;
          bool1 = false;
          label39:
          bool2 = bool1;
          if (i == 1) {
            this.d = true;
          }
        }
      }
    }
    for (boolean bool2 = bool1;; bool2 = true)
    {
      if ((bool2) && (e()) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackgroundStop)) {}
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
  
  protected boolean e()
  {
    return false;
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    long l = System.currentTimeMillis();
    int i = this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase.a(b(), 200, 8);
    if (i == 101) {
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, System.currentTimeMillis());
    }
    l = System.currentTimeMillis() - l;
    if (QLog.isColorLevel()) {
      QLog.d("Q.fts", 2, new Object[] { "mergeCommand ", b(), " cost:", Long.valueOf(l) });
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("table_name", b());
    localHashMap.put("merge_ret", String.valueOf(i));
    localHashMap.put("merge_cost", String.valueOf(l));
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actFTSMerge", true, l, 0L, localHashMap, null, false);
  }
  
  public boolean f()
  {
    return false;
  }
  
  public boolean g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    do
    {
      return false;
      WVPreloadPskeyConfBean localWVPreloadPskeyConfBean = (WVPreloadPskeyConfBean)QConfigManager.a().a(585);
      if ((localWVPreloadPskeyConfBean == null) || (localWVPreloadPskeyConfBean.jdField_b_of_type_Int != 0)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.fts", 2, "needRunMergeCommand disableFTSMerge ");
    return false;
    if (System.currentTimeMillis() - a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) > 21600000L) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.fts", 2, new Object[] { "needRunMergeCommand ", b(), " need:", Boolean.valueOf(bool) });
      }
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.fts.FTSIndexOperator
 * JD-Core Version:    0.7.0.1
 */