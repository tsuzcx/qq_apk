package com.tencent.biz.pubaccount.readinjoy.video;

import ajtd;
import ajtg;
import android.os.Bundle;
import auko;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import nna;
import npt;
import npv;
import qru;

public class VideoFeedsAppInterface
  extends AppInterface
{
  public static String a;
  private HashMap<Integer, ajtd> jdField_a_of_type_JavaUtilHashMap = new HashMap(20);
  private List<ajtg> jdField_a_of_type_JavaUtilList = new Vector();
  private qru jdField_a_of_type_Qru;
  private List<ajtg> b = new Vector();
  private List<ajtg> c = new Vector();
  
  static
  {
    jdField_a_of_type_JavaLangString = "com.tencent.mobileqq:tool";
  }
  
  public VideoFeedsAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    super(paramBaseApplicationImpl, paramString);
  }
  
  public ajtd a(int paramInt)
  {
    ajtd localajtd = (ajtd)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    if (localajtd == null) {}
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        localajtd = (ajtd)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
        if (localajtd == null) {
          break label113;
        }
        return localajtd;
        if (localajtd != null) {
          this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localajtd);
        }
        return localajtd;
      }
      Object localObject2 = new npv(this);
      continue;
      localObject2 = new npt(this);
      continue;
      localObject2 = new nna(this);
      continue;
      return localObject2;
      label113:
      switch (paramInt)
      {
      }
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    this.jdField_a_of_type_Qru.a(paramFromServiceMsg.isSuccess(), paramToServiceMsg, paramFromServiceMsg, null);
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
    return null;
  }
  
  public String getModuleId()
  {
    return "module_videofeeds";
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Qru = new qru(this);
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
  
  public void sendToService(ToServiceMsg paramToServiceMsg)
  {
    this.jdField_a_of_type_Qru.a(paramToServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAppInterface
 * JD-Core Version:    0.7.0.1
 */