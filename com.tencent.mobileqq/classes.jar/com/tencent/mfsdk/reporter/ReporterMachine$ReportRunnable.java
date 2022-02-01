package com.tencent.mfsdk.reporter;

import achh;
import achi;
import acjc;
import android.content.SharedPreferences.Editor;
import android.util.SparseArray;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mfsdk.collector.ResultObject;
import com.tencent.mfsdk.config.Config;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import mqq.os.MqqHandler;

class ReporterMachine$ReportRunnable
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private List<ResultObject> jdField_a_of_type_JavaUtilList;
  
  private ReporterMachine$ReportRunnable(ReporterMachine paramReporterMachine) {}
  
  public void run()
  {
    int i = 0;
    if (achh.jdField_a_of_type_Int > Config.MAX_REPORT_NUM)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Magnifier_ReporterMachine", 2, "[YunYingReport]:End, reported " + achh.jdField_a_of_type_Int + " max_report_num " + Config.MAX_REPORT_NUM);
      }
      if (MagnifierSDK.jdField_a_of_type_Acjc != null) {
        MagnifierSDK.jdField_a_of_type_Acjc.a();
      }
      if (MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences$Editor != null) {
        MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("count_today_reported", achh.jdField_a_of_type_Int).apply();
      }
    }
    int j;
    do
    {
      return;
      if ((MagnifierSDK.jdField_a_of_type_Acjc == null) || (1 != NetworkCenter.getInstance().getNetType()))
      {
        if (QLog.isColorLevel()) {
          QLog.i("Magnifier_ReporterMachine", 2, "[YunYingReport]:Next try, because MagnifierSDK.dbHandler == null || NetType.WIFI != NetworkCenter.getInstance().getNetType()");
        }
        ReporterMachine.a().postDelayed(this, 1800000L);
        return;
      }
      if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {
        break;
      }
      try
      {
        ReporterMachine.b((ResultObject)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int));
        this.jdField_a_of_type_Int += 1;
        if (this.jdField_a_of_type_Int < this.jdField_a_of_type_JavaUtilList.size())
        {
          ReporterMachine.a().postDelayed(this, 500L);
          return;
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Magnifier_ReporterMachine", 2, localException1, new Object[0]);
          }
        }
        MagnifierSDK.jdField_a_of_type_Acjc.a("result_objects", true);
        if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Magnifier_ReporterMachine", 2, "clear all data from roList");
          }
          this.jdField_a_of_type_JavaUtilList.clear();
        }
        if (QLog.isColorLevel()) {
          QLog.d("Magnifier_ReporterMachine", 2, "clear and set listIndex's value to 0");
        }
        this.jdField_a_of_type_Int = 0;
        ReporterMachine.a().postDelayed(this, 1800000L);
        j = achh.jdField_a_of_type_AndroidUtilSparseArray.size();
      }
    } while (MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences$Editor == null);
    Object localObject1;
    if (i < j)
    {
      int k = achh.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i);
      if (k > 100)
      {
        localObject1 = (achi)achh.jdField_a_of_type_AndroidUtilSparseArray.get(k);
        if (localObject1 != null) {
          break label372;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label372:
        MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("count_plugin_" + String.valueOf(k), ((achi)localObject1).jdField_a_of_type_Int);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Magnifier_ReporterMachine", 2, "MagnifierSDKApply 22 ");
    }
    MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences$Editor.apply();
    return;
    this.jdField_a_of_type_JavaUtilList = MagnifierSDK.jdField_a_of_type_Acjc.a(true);
    if ((ReporterMachine.a() != null) && (!ReporterMachine.a().isEmpty())) {}
    try
    {
      this.jdField_a_of_type_JavaUtilList.addAll(ReporterMachine.a());
      ReporterMachine.a().clear();
      if (QLog.isColorLevel()) {
        QLog.d("Magnifier_ReporterMachine", 2, "getAllResultObjects and set listIndex = 0");
      }
      this.jdField_a_of_type_Int = 0;
      if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty())) {
        break label625;
      }
      localObject1 = ReporterMachine.a().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject3 = (String)((Iterator)localObject1).next();
        try
        {
          localObject3 = new File((String)localObject3);
          if ((localObject3 != null) && (((File)localObject3).isFile())) {
            ((File)localObject3).delete();
          }
        }
        catch (Exception localException2) {}
      }
      ReporterMachine.a().clear();
    }
    finally {}
    ReporterMachine.a().postDelayed(this, 1800000L);
    return;
    label625:
    ReporterMachine.a().postDelayed(this, 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mfsdk.reporter.ReporterMachine.ReportRunnable
 * JD-Core Version:    0.7.0.1
 */