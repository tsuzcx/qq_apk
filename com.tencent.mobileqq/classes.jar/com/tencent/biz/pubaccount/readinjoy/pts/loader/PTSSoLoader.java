package com.tencent.biz.pubaccount.readinjoy.pts.loader;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.pts.util.PTSReport;
import com.tencent.biz.pubaccount.readinjoy.pts.util.PTSReport.R5Builder;
import com.tencent.mobileqq.soload.SoLoadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class PTSSoLoader
{
  private static volatile PTSSoLoader jdField_a_of_type_ComTencentBizPubaccountReadinjoyPtsLoaderPTSSoLoader;
  private boolean jdField_a_of_type_Boolean = false;
  
  public static PTSSoLoader a()
  {
    if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyPtsLoaderPTSSoLoader == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyPtsLoaderPTSSoLoader == null) {
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyPtsLoaderPTSSoLoader = new PTSSoLoader();
      }
      return jdField_a_of_type_ComTencentBizPubaccountReadinjoyPtsLoaderPTSSoLoader;
    }
    finally {}
  }
  
  private List<Integer> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new ArrayList();
      return paramString;
    }
    String[] arrayOfString = paramString.split("\\.");
    ArrayList localArrayList = new ArrayList();
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      paramString = localArrayList;
      if (i >= j) {
        break;
      }
      paramString = arrayOfString[i];
      try
      {
        localArrayList.add(Integer.valueOf(Integer.parseInt(paramString)));
        i += 1;
      }
      catch (NumberFormatException paramString)
      {
        QLog.e("PTSSoLoader", 1, "[getVersionList] error, e = " + paramString);
      }
    }
    return new ArrayList();
  }
  
  private void a(String paramString1, int paramInt, String paramString2)
  {
    paramString1 = new PTSReport.R5Builder().a("name", paramString1).a("resCode", "" + paramInt).a("version", paramString2).a();
    if (paramInt == 0)
    {
      PTSReport.a("0X800A832", "", "", "", paramString1);
      return;
    }
    PTSReport.a("0X800A833", "", "", "", paramString1);
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    QLog.i("PTSSoLoader", 1, "[isVersionValid], currentVersion = " + paramString1 + ", supportMinVersion = " + paramString2);
    List localList = a(paramString1);
    paramString2 = a(paramString2);
    if (paramString1.length() <= 0)
    {
      QLog.i("PTSSoLoader", 1, "[isVersionValid] false, currentVersion = " + paramString1);
      return false;
    }
    int j = Math.min(localList.size(), paramString2.size());
    int i = 0;
    while (i < j)
    {
      if (((Integer)localList.get(i)).intValue() < ((Integer)paramString2.get(i)).intValue())
      {
        QLog.i("PTSSoLoader", 1, "[isVersionValid] = false");
        return false;
      }
      if (((Integer)localList.get(i)).intValue() > ((Integer)paramString2.get(i)).intValue())
      {
        QLog.i("PTSSoLoader", 1, "[isVersionValid] = true");
        return true;
      }
      i += 1;
    }
    if (localList.size() >= paramString2.size()) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.i("PTSSoLoader", 1, "[isVersionValid] = " + bool);
      return bool;
    }
  }
  
  public void a(String paramString)
  {
    QLog.i("PTSSoLoader", 1, "[load], name = " + paramString);
    SoLoadManager.a().a(paramString, new PTSSoLoader.1(this, paramString));
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSSoLoader
 * JD-Core Version:    0.7.0.1
 */