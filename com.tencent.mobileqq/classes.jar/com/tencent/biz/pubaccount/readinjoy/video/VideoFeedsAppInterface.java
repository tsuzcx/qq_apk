package com.tencent.biz.pubaccount.readinjoy.video;

import ajtb;
import ajte;
import android.os.Bundle;
import aukq;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import nmx;
import npq;
import nps;
import qrr;

public class VideoFeedsAppInterface
  extends AppInterface
{
  public static String a;
  private HashMap<Integer, ajtb> jdField_a_of_type_JavaUtilHashMap = new HashMap(20);
  private List<ajte> jdField_a_of_type_JavaUtilList = new Vector();
  private qrr jdField_a_of_type_Qrr;
  private List<ajte> b = new Vector();
  private List<ajte> c = new Vector();
  
  static
  {
    jdField_a_of_type_JavaLangString = "com.tencent.mobileqq:tool";
  }
  
  public VideoFeedsAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    super(paramBaseApplicationImpl, paramString);
  }
  
  public ajtb a(int paramInt)
  {
    ajtb localajtb = (ajtb)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    if (localajtb == null) {}
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        localajtb = (ajtb)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
        if (localajtb == null) {
          break label113;
        }
        return localajtb;
        if (localajtb != null) {
          this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localajtb);
        }
        return localajtb;
      }
      Object localObject2 = new nps(this);
      continue;
      localObject2 = new npq(this);
      continue;
      localObject2 = new nmx(this);
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
    this.jdField_a_of_type_Qrr.a(paramFromServiceMsg.isSuccess(), paramToServiceMsg, paramFromServiceMsg, null);
  }
  
  public void addObserver(ajte paramajte)
  {
    addObserver(paramajte, false);
  }
  
  public void addObserver(ajte paramajte, boolean paramBoolean)
  {
    if (paramajte == null) {
      return;
    }
    if (paramBoolean) {
      synchronized (this.b)
      {
        if (!this.b.contains(paramajte)) {
          this.b.add(paramajte);
        }
        return;
      }
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramajte)) {
        this.jdField_a_of_type_JavaUtilList.add(paramajte);
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
  
  public List<ajte> getBusinessObserver(int paramInt)
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
  
  public aukq getEntityManagerFactory(String paramString)
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
    this.jdField_a_of_type_Qrr = new qrr(this);
  }
  
  public void removeObserver(ajte paramajte)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramajte);
      synchronized (this.b)
      {
        this.b.remove(paramajte);
      }
    }
    synchronized (this.c)
    {
      this.c.remove(paramajte);
      return;
      paramajte = finally;
      throw paramajte;
      paramajte = finally;
      throw paramajte;
    }
  }
  
  public void sendToService(ToServiceMsg paramToServiceMsg)
  {
    this.jdField_a_of_type_Qrr.a(paramToServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAppInterface
 * JD-Core Version:    0.7.0.1
 */