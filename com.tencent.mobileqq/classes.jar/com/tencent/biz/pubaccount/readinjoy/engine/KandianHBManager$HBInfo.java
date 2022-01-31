package com.tencent.biz.pubaccount.readinjoy.engine;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import mqq.os.MqqHandler;

public class KandianHBManager$HBInfo
  implements Serializable, Runnable
{
  public int accumlatedDay;
  public long endTime;
  public String introductionUrl;
  public String popIntroUrl;
  public long startTime;
  public String toastUrl;
  public int totalDay;
  public String turntableUrl;
  
  public static HBInfo buildFromSp(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = new ObjectInputStream(new ByteArrayInputStream(PkgTools.a(paramString))).readObject();
      if ((paramString != null) && ((paramString instanceof HBInfo)))
      {
        paramString = (HBInfo)paramString;
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public void run()
  {
    try
    {
      Object localObject1 = new ByteArrayOutputStream();
      Object localObject2 = new ObjectOutputStream((OutputStream)localObject1);
      ((ObjectOutputStream)localObject2).writeObject(this);
      ((ObjectOutputStream)localObject2).flush();
      ((ObjectOutputStream)localObject2).close();
      localObject1 = PkgTools.a(((ByteArrayOutputStream)localObject1).toByteArray());
      localObject2 = ReadInJoyHelper.a(ReadInJoyUtils.a(), true, true);
      if (localObject2 != null)
      {
        localObject2 = ((SharedPreferences)localObject2).edit();
        ((SharedPreferences.Editor)localObject2).putString("kandian_hb", (String)localObject1);
        ((SharedPreferences.Editor)localObject2).commit();
      }
      QLog.d("kandianhb.KandianHBManager", 2, "write hb info to storage successful ! " + this);
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      QLog.d("kandianhb.KandianHBManager", 2, "write hb info to storage , error : " + localIOException.toString());
    }
  }
  
  public String toString()
  {
    return "day : " + this.accumlatedDay + "/" + this.totalDay + ", startTime : " + this.startTime + ", endTime : " + this.endTime;
  }
  
  public void writeToStorage()
  {
    ThreadManager.getSubThreadHandler().post(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianHBManager.HBInfo
 * JD-Core Version:    0.7.0.1
 */