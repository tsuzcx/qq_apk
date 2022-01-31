package com.tencent.biz.pubaccount.readinjoy.video;

import ajfb;
import ajfe;
import android.os.Bundle;
import atmq;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import nbz;
import nes;
import neu;
import qfw;

public class VideoFeedsAppInterface
  extends AppInterface
{
  public static String a;
  private HashMap<Integer, ajfb> jdField_a_of_type_JavaUtilHashMap = new HashMap(20);
  private List<ajfe> jdField_a_of_type_JavaUtilList = new Vector();
  private qfw jdField_a_of_type_Qfw;
  private List<ajfe> b = new Vector();
  private List<ajfe> c = new Vector();
  
  static
  {
    jdField_a_of_type_JavaLangString = "com.tencent.mobileqq:tool";
  }
  
  public VideoFeedsAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    super(paramBaseApplicationImpl, paramString);
  }
  
  public ajfb a(int paramInt)
  {
    ajfb localajfb = (ajfb)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    if (localajfb == null) {}
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        localajfb = (ajfb)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
        if (localajfb == null) {
          break label113;
        }
        return localajfb;
        if (localajfb != null) {
          this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localajfb);
        }
        return localajfb;
      }
      Object localObject2 = new neu(this);
      continue;
      localObject2 = new nes(this);
      continue;
      localObject2 = new nbz(this);
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
    this.jdField_a_of_type_Qfw.a(paramFromServiceMsg.isSuccess(), paramToServiceMsg, paramFromServiceMsg, null);
  }
  
  public void addObserver(ajfe paramajfe)
  {
    addObserver(paramajfe, false);
  }
  
  public void addObserver(ajfe paramajfe, boolean paramBoolean)
  {
    if (paramajfe == null) {
      return;
    }
    if (paramBoolean) {
      synchronized (this.b)
      {
        if (!this.b.contains(paramajfe)) {
          this.b.add(paramajfe);
        }
        return;
      }
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramajfe)) {
        this.jdField_a_of_type_JavaUtilList.add(paramajfe);
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
  
  public List<ajfe> getBusinessObserver(int paramInt)
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
  
  public atmq getEntityManagerFactory(String paramString)
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
    this.jdField_a_of_type_Qfw = new qfw(this);
  }
  
  public void removeObserver(ajfe paramajfe)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramajfe);
      synchronized (this.b)
      {
        this.b.remove(paramajfe);
      }
    }
    synchronized (this.c)
    {
      this.c.remove(paramajfe);
      return;
      paramajfe = finally;
      throw paramajfe;
      paramajfe = finally;
      throw paramajfe;
    }
  }
  
  public void sendToService(ToServiceMsg paramToServiceMsg)
  {
    this.jdField_a_of_type_Qfw.a(paramToServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAppInterface
 * JD-Core Version:    0.7.0.1
 */