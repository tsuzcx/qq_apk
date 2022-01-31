package com.tencent.av.business.manager.zimu;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.handler.AudioTransClientInfoHandler;
import com.tencent.av.business.handler.AudioTransClientInterfaceHandler;
import com.tencent.av.business.manager.EffectConfigBase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class EffectZimuManager
  extends EffectConfigBase
{
  protected boolean a;
  boolean b = false;
  boolean c = false;
  
  public EffectZimuManager(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("qav_zimu_is_show", paramInt);
    paramContext.commit();
  }
  
  public static boolean a(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("qav_zimu_is_show", 0) == 1;
  }
  
  private boolean c(String paramString)
  {
    boolean bool = true;
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new JSONObject(paramString);
        if (!paramString.has("switch")) {
          return bool;
        }
        paramString = paramString.getString("switch");
        AVLog.c("EffectZimuManager", "parse ZIMU:" + paramString);
        if ((!TextUtils.isEmpty(paramString)) && (paramString.equalsIgnoreCase("off")))
        {
          a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), 0);
          return true;
        }
        a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), 1);
        return true;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    } else {
      bool = false;
    }
    return bool;
  }
  
  public int a()
  {
    return 216;
  }
  
  protected Class a()
  {
    return ZimuItem.class;
  }
  
  public List a(String paramString)
  {
    paramString = super.a(paramString);
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilList != null) {
      localArrayList.addAll(paramString);
    }
    return localArrayList;
  }
  
  protected void a(int paramInt, String paramString1, String paramString2)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    ((AudioTransClientInfoHandler)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(1)).b();
    a(Integer.valueOf(6007), null, Boolean.valueOf(false));
  }
  
  protected void a(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    AVLog.c("EffectZimuManager", "notifyEvent :" + paramInteger + "|" + paramObject1);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { paramInteger, paramObject1, paramObject2 });
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        ZimuItem localZimuItem = (ZimuItem)localIterator.next();
        if (ARZimuUtil.a(localZimuItem.getId())) {
          localZimuItem.setUsable(paramBoolean);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (!this.b)
    {
      AudioTransClientInfoHandler localAudioTransClientInfoHandler = (AudioTransClientInfoHandler)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(1);
      localAudioTransClientInfoHandler.a("TransInfoCreate.CreateSession", paramString);
      localAudioTransClientInfoHandler.a();
      this.c = paramBoolean;
    }
    this.b = true;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(ZimuItem paramZimuItem)
  {
    boolean bool = super.a(paramZimuItem);
    if (bool)
    {
      if (paramZimuItem == null)
      {
        paramZimuItem = null;
        EffectZimuManager.DataReport.a(paramZimuItem);
        b(false);
      }
    }
    else
    {
      paramZimuItem = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
      if (this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase$ItemBase != null) {
        break label74;
      }
    }
    label74:
    for (int i = 4;; i = 5)
    {
      paramZimuItem.a(new Object[] { Integer.valueOf(165), Integer.valueOf(i) });
      return bool;
      paramZimuItem = paramZimuItem.getId();
      break;
    }
  }
  
  protected boolean a(String paramString)
  {
    return c(a());
  }
  
  public int b()
  {
    ZimuItem localZimuItem = (ZimuItem)a();
    if (localZimuItem == null) {}
    while (!ARZimuUtil.a(localZimuItem.getId())) {
      return 4;
    }
    return 4;
  }
  
  protected List b(String paramString)
  {
    List localList = super.b(paramString);
    c(paramString);
    return localList;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    return this.c;
  }
  
  public void c()
  {
    if (this.b)
    {
      AudioTransClientInterfaceHandler localAudioTransClientInterfaceHandler = (AudioTransClientInterfaceHandler)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0);
      localAudioTransClientInterfaceHandler.a("TransInfo.ExitSession", null);
      localAudioTransClientInterfaceHandler.a();
      ((AudioTransClientInfoHandler)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(1)).b();
    }
    this.b = false;
  }
  
  public void d()
  {
    if (this.b)
    {
      AudioTransClientInterfaceHandler localAudioTransClientInterfaceHandler = (AudioTransClientInterfaceHandler)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0);
      localAudioTransClientInterfaceHandler.a("TransInfo.ChangeSession", null);
      localAudioTransClientInterfaceHandler.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.business.manager.zimu.EffectZimuManager
 * JD-Core Version:    0.7.0.1
 */