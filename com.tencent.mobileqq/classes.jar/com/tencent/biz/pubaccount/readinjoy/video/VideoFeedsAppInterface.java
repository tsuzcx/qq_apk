package com.tencent.biz.pubaccount.readinjoy.video;

import android.os.Bundle;
import anud;
import anui;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import oal;
import odn;
import odp;
import rsv;

public class VideoFeedsAppInterface
  extends AppInterface
{
  public static String a;
  private HashMap<Integer, anud> jdField_a_of_type_JavaUtilHashMap = new HashMap(20);
  private List<anui> jdField_a_of_type_JavaUtilList = new Vector();
  private rsv jdField_a_of_type_Rsv;
  private List<anui> b = new Vector();
  private List<anui> c = new Vector();
  
  static
  {
    jdField_a_of_type_JavaLangString = "com.tencent.mobileqq:tool";
  }
  
  public VideoFeedsAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    super(paramBaseApplicationImpl, paramString);
  }
  
  public anud a(int paramInt)
  {
    anud localanud = (anud)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    if (localanud == null) {}
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        localanud = (anud)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
        if (localanud == null) {
          break label113;
        }
        return localanud;
        if (localanud != null) {
          this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localanud);
        }
        return localanud;
      }
      Object localObject2 = new odp(this);
      continue;
      localObject2 = new odn(this);
      continue;
      localObject2 = new oal(this);
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
    this.jdField_a_of_type_Rsv.a(paramFromServiceMsg.isSuccess(), paramToServiceMsg, paramFromServiceMsg, null);
  }
  
  public void addObserver(anui paramanui)
  {
    addObserver(paramanui, false);
  }
  
  public void addObserver(anui paramanui, boolean paramBoolean)
  {
    if (paramanui == null) {
      return;
    }
    if (paramBoolean) {
      synchronized (this.b)
      {
        if (!this.b.contains(paramanui)) {
          this.b.add(paramanui);
        }
        return;
      }
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramanui)) {
        this.jdField_a_of_type_JavaUtilList.add(paramanui);
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
  
  public List<anui> getBusinessObserver(int paramInt)
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
  
  public EntityManagerFactory getEntityManagerFactory(String paramString)
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
    this.jdField_a_of_type_Rsv = new rsv(this);
  }
  
  public void removeObserver(anui paramanui)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramanui);
      synchronized (this.b)
      {
        this.b.remove(paramanui);
      }
    }
    synchronized (this.c)
    {
      this.c.remove(paramanui);
      return;
      paramanui = finally;
      throw paramanui;
      paramanui = finally;
      throw paramanui;
    }
  }
  
  public void sendToService(ToServiceMsg paramToServiceMsg)
  {
    this.jdField_a_of_type_Rsv.a(paramToServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAppInterface
 * JD-Core Version:    0.7.0.1
 */