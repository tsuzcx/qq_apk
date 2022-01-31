package com.tencent.biz.pubaccount.readinjoy.plugin;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.skin.CommonSkinRes;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoySkinManager;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;

public class ReadInJoySkinHelper
{
  private TroopMemberApiService jdField_a_of_type_ComTencentBizTroopTroopMemberApiService;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  
  public ReadInJoySkinHelper(AppRuntime paramAppRuntime, TroopMemberApiService paramTroopMemberApiService)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService = paramTroopMemberApiService;
  }
  
  public void a()
  {
    QLog.d("ReadInJoySkinHelper", 1, "onDestroy");
    ReadInJoySkinManager localReadInJoySkinManager = (ReadInJoySkinManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(260);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      localReadInJoySkinManager.b((DownloadListener)((Map.Entry)localIterator.next()).getValue());
    }
    this.jdField_a_of_type_MqqAppAppRuntime = null;
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService = null;
  }
  
  public void a(Bundle paramBundle)
  {
    if ((this.jdField_a_of_type_MqqAppAppRuntime == null) || (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService == null)) {}
    while (!(this.jdField_a_of_type_MqqAppAppRuntime instanceof AppInterface)) {
      return;
    }
    String str = ((ReadInJoySkinManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(260)).a();
    if (!CommonSkinRes.a(str)) {
      str = "";
    }
    for (;;)
    {
      boolean bool = SharedPreUtils.y(((AppInterface)this.jdField_a_of_type_MqqAppAppRuntime).getApp().getApplicationContext(), ((AppInterface)this.jdField_a_of_type_MqqAppAppRuntime).getCurrentAccountUin());
      Bundle localBundle = new Bundle();
      localBundle.putInt("seq", paramBundle.getInt("seq"));
      localBundle.putInt("retCode", 0);
      localBundle.putString("skinId", str);
      if (bool) {}
      for (int i = 1;; i = 0)
      {
        localBundle.putInt("volumeIsOn", i);
        this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(113, localBundle);
        return;
      }
    }
  }
  
  public void b(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("readinjoy", 4, "MessengerService receive set skin cmd");
    }
    if ((this.jdField_a_of_type_MqqAppAppRuntime == null) || (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService == null)) {
      return;
    }
    Object localObject1 = (ReadInJoySkinManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(260);
    String str1 = paramBundle.getString("skinId");
    long l1 = paramBundle.getLong("skinSeq");
    Object localObject2 = paramBundle.getString("skinName");
    String str2 = paramBundle.getString("skinUrl");
    long l2 = paramBundle.getLong("startTime");
    long l3 = paramBundle.getLong("endTime");
    boolean bool;
    if (paramBundle.getInt("volumeIsOn") == 1)
    {
      bool = true;
      if ((!TextUtils.isEmpty(str1)) && (!str1.equals("null"))) {
        break label208;
      }
      str1 = "";
    }
    label208:
    for (localObject1 = ((ReadInJoySkinManager)localObject1).a(0, "", l1, (String)localObject2, str2, l2, l3, bool);; localObject1 = ((ReadInJoySkinManager)localObject1).a(1, str1, l1, (String)localObject2, str2, l2, l3, bool))
    {
      localObject2 = new Bundle();
      ((Bundle)localObject2).putInt("seq", paramBundle.getInt("seq"));
      ((Bundle)localObject2).putInt("retCode", ((ErrorMessage)localObject1).errorCode);
      ((Bundle)localObject2).putString("skinId", str1);
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(112, (Bundle)localObject2);
      return;
      bool = false;
      break;
    }
  }
  
  public void c(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("readinjoy", 4, "MessengerService receive load skin cmd");
    }
    if ((this.jdField_a_of_type_MqqAppAppRuntime == null) || (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService == null)) {}
    String str1;
    long l1;
    String str2;
    String str3;
    long l2;
    long l3;
    ReadInJoySkinHelper.SkinDownloadListener localSkinDownloadListener;
    do
    {
      return;
      localObject = (ReadInJoySkinManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(260);
      str1 = paramBundle.getString("skinId");
      l1 = paramBundle.getLong("skinSeq");
      str2 = paramBundle.getString("skinName");
      str3 = paramBundle.getString("skinUrl");
      l2 = paramBundle.getLong("startTime");
      l3 = paramBundle.getLong("endTime");
      localSkinDownloadListener = new ReadInJoySkinHelper.SkinDownloadListener(this.jdField_a_of_type_MqqAppAppRuntime, str1, paramBundle, this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService);
      this.jdField_a_of_type_JavaUtilHashMap.put(str1, localSkinDownloadListener);
    } while (!((ReadInJoySkinManager)localObject).a(str1, str2, str3, l1, l2, l3, localSkinDownloadListener));
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("seq", paramBundle.getInt("seq"));
    ((Bundle)localObject).putInt("retCode", 0);
    ((Bundle)localObject).putInt("rate", 100);
    ((Bundle)localObject).putString("skinId", str1);
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(110, (Bundle)localObject);
  }
  
  public void d(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("readinjoy", 4, "MessengerService receive cancel load skin cmd");
    }
    if ((this.jdField_a_of_type_MqqAppAppRuntime == null) || (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService == null)) {
      return;
    }
    Object localObject = (ReadInJoySkinManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(260);
    String str = paramBundle.getString("skinId");
    paramBundle.getString("skinUrl");
    boolean bool = ((ReadInJoySkinManager)localObject).a(str);
    localObject = new Bundle();
    ((Bundle)localObject).putInt("seq", paramBundle.getInt("seq"));
    if (bool) {}
    for (int i = 0;; i = -1)
    {
      ((Bundle)localObject).putInt("retCode", i);
      ((Bundle)localObject).putString("skinId", str);
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(111, (Bundle)localObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.plugin.ReadInJoySkinHelper
 * JD-Core Version:    0.7.0.1
 */