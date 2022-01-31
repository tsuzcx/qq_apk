package com.tencent.mobileqq.arcard;

import aalu;
import aalv;
import aalw;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;
import mqq.os.MqqHandler;

public class ARCardHeadIconManager
{
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new aalv(this);
  private final Context jdField_a_of_type_AndroidContentContext;
  private Runnable jdField_a_of_type_JavaLangRunnable = new aalu(this);
  private final ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private final Hashtable jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  private boolean jdField_a_of_type_Boolean = true;
  
  public ARCardHeadIconManager(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(String paramString)
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramString))
    {
      aalw localaalw = (aalw)this.jdField_a_of_type_JavaUtilHashtable.get(paramString);
      localaalw.jdField_a_of_type_Boolean = true;
      localaalw.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
      if (1 == this.jdField_a_of_type_JavaUtilArrayList.size()) {
        ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 200L);
      }
      if (QLog.isColorLevel()) {
        QLog.i("DingdongHeadManager", 2, "RequestContactHeadPathByIpc:uin=[" + paramString + "],request_time=[" + localaalw.jdField_a_of_type_Long + "].");
      }
    }
  }
  
  private boolean a(String paramString)
  {
    if (paramString != null) {
      return new File(paramString).exists();
    }
    return false;
  }
  
  private String c(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(256);
    if (SystemUtil.a()) {
      localStringBuilder.append(AppConstants.bm);
    }
    for (;;)
    {
      String str = MD5.toMD5(paramString);
      str = MD5.toMD5(str + paramString);
      localStringBuilder.append(MD5.toMD5(str + paramString));
      localStringBuilder.append(".png");
      return localStringBuilder.toString();
      localStringBuilder.append("/data/data/com.tencent.mobileqq/files/head/_hd/");
    }
  }
  
  public String a(String paramString)
  {
    aalw localaalw2 = (aalw)this.jdField_a_of_type_JavaUtilHashtable.get(paramString);
    aalw localaalw1 = localaalw2;
    if (localaalw2 == null)
    {
      localaalw1 = new aalw(this);
      this.jdField_a_of_type_JavaUtilHashtable.put(paramString, localaalw1);
    }
    if (localaalw1.jdField_a_of_type_Boolean)
    {
      long l = System.currentTimeMillis();
      if (localaalw1.jdField_a_of_type_Long + 1500L < l) {
        return null;
      }
      localaalw1.jdField_a_of_type_Boolean = false;
    }
    if (TextUtils.isEmpty(localaalw1.jdField_a_of_type_JavaLangString)) {
      localaalw1.jdField_a_of_type_JavaLangString = b(paramString);
    }
    if ((localaalw1.jdField_a_of_type_JavaLangString != null) && (!a(localaalw1.jdField_a_of_type_JavaLangString))) {
      localaalw1.jdField_a_of_type_JavaLangString = null;
    }
    if ((localaalw1.jdField_a_of_type_JavaLangString == null) && (!localaalw1.jdField_a_of_type_Boolean)) {
      a(paramString);
    }
    return localaalw1.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.qqhead.getheadresp");
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter, "com.tencent.qqhead.permission.getheadresp", null);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public String b(String paramString)
  {
    paramString = c(paramString);
    if (paramString != null)
    {
      if (new File(paramString).exists()) {
        return paramString;
      }
      return null;
    }
    return null;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.arcard.ARCardHeadIconManager
 * JD-Core Version:    0.7.0.1
 */