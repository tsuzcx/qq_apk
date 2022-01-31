package com.tencent.biz.pubaccount.readinjoy.video;

import alpd;
import alpg;
import android.os.Bundle;
import awgg;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import npt;
import nsz;
import ntb;
import rhd;

public class VideoFeedsAppInterface
  extends AppInterface
{
  public static String a;
  private HashMap<Integer, alpd> jdField_a_of_type_JavaUtilHashMap = new HashMap(20);
  private List<alpg> jdField_a_of_type_JavaUtilList = new Vector();
  private rhd jdField_a_of_type_Rhd;
  private List<alpg> b = new Vector();
  private List<alpg> c = new Vector();
  
  static
  {
    jdField_a_of_type_JavaLangString = "com.tencent.mobileqq:tool";
  }
  
  public VideoFeedsAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    super(paramBaseApplicationImpl, paramString);
  }
  
  public alpd a(int paramInt)
  {
    alpd localalpd = (alpd)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    if (localalpd == null) {}
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        localalpd = (alpd)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
        if (localalpd == null) {
          break label113;
        }
        return localalpd;
        if (localalpd != null) {
          this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localalpd);
        }
        return localalpd;
      }
      Object localObject2 = new ntb(this);
      continue;
      localObject2 = new nsz(this);
      continue;
      localObject2 = new npt(this);
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
    this.jdField_a_of_type_Rhd.a(paramFromServiceMsg.isSuccess(), paramToServiceMsg, paramFromServiceMsg, null);
  }
  
  public void addObserver(alpg paramalpg)
  {
    addObserver(paramalpg, false);
  }
  
  public void addObserver(alpg paramalpg, boolean paramBoolean)
  {
    if (paramalpg == null) {
      return;
    }
    if (paramBoolean) {
      synchronized (this.b)
      {
        if (!this.b.contains(paramalpg)) {
          this.b.add(paramalpg);
        }
        return;
      }
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramalpg)) {
        this.jdField_a_of_type_JavaUtilList.add(paramalpg);
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
  
  public List<alpg> getBusinessObserver(int paramInt)
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
  
  public awgg getEntityManagerFactory(String paramString)
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
    this.jdField_a_of_type_Rhd = new rhd(this);
  }
  
  public void removeObserver(alpg paramalpg)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramalpg);
      synchronized (this.b)
      {
        this.b.remove(paramalpg);
      }
    }
    synchronized (this.c)
    {
      this.c.remove(paramalpg);
      return;
      paramalpg = finally;
      throw paramalpg;
      paramalpg = finally;
      throw paramalpg;
    }
  }
  
  public void sendToService(ToServiceMsg paramToServiceMsg)
  {
    this.jdField_a_of_type_Rhd.a(paramToServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAppInterface
 * JD-Core Version:    0.7.0.1
 */