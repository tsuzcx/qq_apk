package com.tencent.av.business.manager;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.handler.AudioTransClientInfoHandler;
import com.tencent.av.business.handler.AudioTransClientInfoHandlerExtend;
import com.tencent.av.business.handler.AudioTransClientInfoHandlerExtend.ZimuCMD;
import com.tencent.av.business.manager.pendant.AVEffectPendantReport;
import com.tencent.av.business.manager.pendant.EffectPendantTools;
import com.tencent.av.business.manager.support.EffectSupportManager;
import com.tencent.av.business.manager.zimu.EffectZimuManager;
import com.tencent.av.business.manager.zimu.ZimuItem;
import com.tencent.av.doodle.DoodleLogic;
import com.tencent.av.doodle.DoodleUtils;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.av.ui.redbag.AVRedBagConfig.Info;
import com.tencent.av.ui.redbag.AVRedBagMgr;
import com.tencent.av.ui.redbag.RedBagUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.ArConfigUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import jfh;
import jfi;
import jfj;
import org.json.JSONObject;

public class EffectOperateManager
  extends BusinessManager
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private int e;
  
  public EffectOperateManager(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
  }
  
  public static String a(Context paramContext, int paramInt, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    try
    {
      File localFile = new File(EffectConfigBase.a(paramInt) + paramString + File.separator + "config.xml");
      localObject1 = localObject2;
      AVLog.c("EffectOperateManager", "getEffectOperateConfig:" + localFile.getPath() + "|" + localFile.exists());
      localObject1 = localObject2;
      if (localFile.exists())
      {
        localObject1 = localObject2;
        paramContext = FileUtils.b(localFile);
        localObject1 = paramContext;
        AVLog.c("EffectOperateManager", "getEffectOperateConfig:" + paramContext);
        return paramContext;
      }
      localObject1 = localObject2;
      SharedPreUtils.p(paramContext, 0, paramString);
      return null;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
      AVLog.c("EffectOperateManager", "getEffectOperateConfig exception:" + paramContext.toString());
    }
    return localObject1;
  }
  
  public static void a(Context paramContext, String paramString1, int paramInt, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.isEmpty())) {
      AVLog.c("EffectOperateManager", "updateEffectOperateConfig error ");
    }
    do
    {
      return;
      paramContext = EffectConfigBase.a(paramInt);
      if (paramInt == 263) {
        paramContext = EffectConfigBase.a(paramInt) + paramString2 + File.separator;
      }
      paramString2 = new File(paramContext);
      if ((paramString2.exists()) && (paramString2.isFile())) {
        FileUtils.d(paramContext);
      }
      EffectConfigBase.a(paramString1, paramContext, "config.xml");
    } while (paramInt != 106);
    AVEffectPendantReport.d();
  }
  
  private void a(String paramString)
  {
    String str;
    label178:
    label217:
    label225:
    boolean bool;
    if (!TextUtils.isEmpty(paramString))
    {
      AVLog.c("EffectOperateManager", "parse config: " + paramString);
      try
      {
        localJSONObject = new JSONObject(paramString);
        if (localJSONObject.has("versionCode")) {
          this.jdField_a_of_type_Int = localJSONObject.getInt("versionCode");
        }
        if (localJSONObject.has("beginTime")) {
          this.jdField_a_of_type_Long = ArConfigUtils.a(localJSONObject.getString("beginTime"));
        }
        if (localJSONObject.has("endTime")) {
          this.jdField_b_of_type_Long = ArConfigUtils.a(localJSONObject.getString("endTime"));
        }
        if (localJSONObject.has("wording")) {
          this.jdField_a_of_type_JavaLangString = localJSONObject.getString("wording");
        }
        if (localJSONObject.has("wordingColor"))
        {
          str = localJSONObject.getString("wordingColor");
          try
          {
            if (!str.startsWith("0x")) {
              break label590;
            }
            paramString = str.replace("0x", "#");
            this.jdField_b_of_type_Int = Color.parseColor(paramString);
          }
          catch (NumberFormatException paramString)
          {
            for (;;)
            {
              this.jdField_b_of_type_Int = -1;
              paramString.printStackTrace();
              AVLog.c("EffectOperateManager", "parse|wording color is invalid!" + paramString.getMessage());
            }
          }
          if (!localJSONObject.has("wordingBgColor")) {
            break label766;
          }
          str = localJSONObject.getString("wordingBgColor");
        }
      }
      catch (Exception paramString)
      {
        JSONObject localJSONObject;
        paramString.printStackTrace();
        AVLog.c("EffectOperateManager", "parse exception: " + paramString.toString());
        return;
      }
      try
      {
        if (!str.startsWith("0x")) {
          break label698;
        }
        paramString = str.replace("0x", "#");
        this.jdField_c_of_type_Int = Color.parseColor(paramString);
      }
      catch (NumberFormatException paramString)
      {
        this.jdField_c_of_type_Int = -16777216;
        paramString.printStackTrace();
        AVLog.c("EffectOperateManager", "parse|wording color is invalid!" + paramString.getMessage());
        break label225;
      }
      if (localJSONObject.has("showTimes")) {
        this.jdField_d_of_type_Int = localJSONObject.getInt("showTimes");
      }
      if (localJSONObject.has("effectType")) {
        this.e = localJSONObject.getInt("effectType");
      }
      if (localJSONObject.has("effectId")) {
        this.jdField_b_of_type_JavaLangString = localJSONObject.getString("effectId");
      }
      if (localJSONObject.has("showBeforeConnect"))
      {
        if (localJSONObject.getInt("showBeforeConnect") != 0) {
          break label812;
        }
        bool = false;
        label310:
        this.jdField_a_of_type_Boolean = bool;
      }
      if (localJSONObject.has("iconUrl")) {
        this.jdField_c_of_type_JavaLangString = localJSONObject.getString("iconUrl");
      }
      if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
        switch (this.e)
        {
        }
      }
    }
    for (;;)
    {
      if (i != -1)
      {
        paramString = ((EffectConfigBase)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i)).a(this.jdField_b_of_type_JavaLangString);
        if (paramString != null) {
          this.jdField_c_of_type_JavaLangString = paramString.getIconurl();
        }
      }
      for (;;)
      {
        AVLog.c("EffectOperateManager", "parse|versionCode: " + this.jdField_a_of_type_Int + ", beginTime: " + this.jdField_a_of_type_Long + ", endTime: " + this.jdField_b_of_type_Long + ", wording: " + this.jdField_a_of_type_JavaLangString + ", wordingColor: 0x" + Long.toString(this.jdField_b_of_type_Int, 16).toUpperCase() + ", wordingBgColor: 0x" + Long.toString(this.jdField_c_of_type_Int, 16).toUpperCase() + ", showTimes: " + this.jdField_d_of_type_Int + ", showBeforeConnect: " + this.jdField_a_of_type_Boolean + ", effectType: " + this.e + ", effectId: " + this.jdField_b_of_type_JavaLangString + ", iconUrl: " + this.jdField_c_of_type_JavaLangString);
        return;
        label590:
        paramString = str;
        if (!str.startsWith("0X")) {
          break;
        }
        paramString = str.replace("0X", "#");
        break;
        this.jdField_b_of_type_Int = -1;
        break label178;
        label698:
        paramString = str;
        if (!str.startsWith("0X")) {
          break label217;
        }
        paramString = str.replace("0X", "#");
        break label217;
        label766:
        this.jdField_c_of_type_Int = -16777216;
        break label225;
        AVLog.c("EffectOperateManager", "parse|cannot get item!");
        continue;
        this.jdField_c_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      }
      AVLog.c("EffectOperateManager", "parse|config is empty!");
      return;
      int i = -1;
      continue;
      label812:
      bool = true;
      break label310;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 1;
      continue;
      i = 0;
    }
  }
  
  public int a()
  {
    return this.e;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  protected void a()
  {
    a(a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp(), 263, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()));
  }
  
  protected void a(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    AVLog.c("EffectOperateManager", "notifyEvent :" + paramInteger + "|" + paramObject1 + "|" + paramObject2);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { paramInteger, paramObject1, paramObject2 });
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    if (QLog.isColorLevel()) {
      Log.i("EffectOperateManager", "setEffectOperateShown: " + paramBoolean, new RuntimeException());
    }
    if (paramBoolean)
    {
      String str = "qav_effect_operate_config_show_times_" + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
      Object localObject = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp());
      int i = ((SharedPreferences)localObject).getInt(str, 0);
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putInt(str, i + 1);
      ((SharedPreferences.Editor)localObject).commit();
    }
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  protected boolean a(String paramString)
  {
    return false;
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (this.jdField_c_of_type_Boolean)
    {
      AVLog.c("EffectOperateManager", "isShowOperateEntry isEffectOperateShown!");
      return false;
    }
    if (AudioHelper.a(8) == 1) {
      return true;
    }
    if (!EffectSettingUi.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, true))
    {
      AVLog.c("EffectOperateManager", "isShowOperateEntry is double video false! effectType: " + this.e);
      return false;
    }
    long l = NetConnInfoCenter.getServerTimeMillis();
    if ((l < this.jdField_a_of_type_Long) || (l > this.jdField_b_of_type_Long))
    {
      AVLog.c("EffectOperateManager", "isShowOperateEntry out of date!");
      return false;
    }
    int i = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp()).getInt("qav_effect_operate_config_show_times_" + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), 0);
    if (i >= this.jdField_d_of_type_Int)
    {
      AVLog.c("EffectOperateManager", "isShowOperateEntry show times: " + i);
      return false;
    }
    if ((1 > this.e) || (this.e > 7))
    {
      AVLog.c("EffectOperateManager", "isShowOperateEntry unknown effect type: " + this.e);
      return false;
    }
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
    {
      AVLog.c("EffectOperateManager", "isShowOperateEntry icon url is empty!");
      return false;
    }
    if ((!this.jdField_a_of_type_Boolean) && (!paramBoolean))
    {
      AVLog.c("EffectOperateManager", "isShowOperateEntry showBeforeConnect: " + this.jdField_a_of_type_Boolean + ", isConnected: " + paramBoolean);
      return false;
    }
    if ((this.e != 1) && (!paramBoolean))
    {
      AVLog.c("EffectOperateManager", "isShowOperateEntry do not support before connected!");
      return false;
    }
    if ((this.e == 1) && (!((EffectSupportManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(5)).a(2, "ptu_so")))
    {
      AVLog.c("EffectOperateManager", "isShowOperateEntry do not support pendant!");
      return false;
    }
    Object localObject;
    if ((this.e == 3) && (paramBoolean))
    {
      localObject = DoodleLogic.a();
      if ((DoodleUtils.a()) && (((DoodleLogic)localObject).jdField_b_of_type_Boolean) && (((DoodleLogic)localObject).a())) {}
      for (i = 1; i == 0; i = 0)
      {
        AVLog.c("EffectOperateManager", "isShowOperateEntry do not support doodle!");
        return false;
      }
    }
    if ((this.e == 6) && (!EffectZimuManager.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp())))
    {
      AVLog.c("EffectOperateManager", "isShowOperateEntry do not support zimu!");
      return false;
    }
    if (this.e == 7)
    {
      if (!EffectSettingUi.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, false))
      {
        AVLog.c("EffectOperateManager", "isShowOperateEntry do not support redbag because is not double chat!");
        return false;
      }
      if (!RedBagUtil.a())
      {
        AVLog.c("EffectOperateManager", "isShowOperateEntry do not support redbag because device not support!");
        return false;
      }
      localObject = RedBagUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface).a();
      if ((localObject == null) || (!((AVRedBagConfig.Info)localObject).jdField_a_of_type_Boolean))
      {
        AVLog.c("EffectOperateManager", "isShowOperateEntry do not support redbag because config switch!");
        return false;
      }
      i = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().j();
      if (i != VideoController.v)
      {
        AVLog.c("EffectOperateManager", "isShowOperateEntry do not support redbag because ptu so status!");
        paramBoolean = PtvFilterSoLoad.a(BaseApplicationImpl.getContext(), false);
        boolean bool = PtvFilterSoLoad.a();
        AVLog.c("EffectOperateManager", "isShowOperateEntry, ptu so load failed, loadPTuSoStatus[" + i + "], ptuSo[" + paramBoolean + "], ptuSoVersion[" + bool + "]");
        if (i == VideoController.u)
        {
          if ((!bool) || (!paramBoolean)) {
            return false;
          }
        }
        else {
          return false;
        }
      }
    }
    return true;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String b()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public void b()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    switch (this.e)
    {
    default: 
      localObject1 = localObject2;
    }
    for (;;)
    {
      if (localObject1 != null) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed((Runnable)localObject1, 200L);
      }
      this.jdField_d_of_type_Boolean = true;
      return;
      localObject1 = new jfi(this);
      continue;
      localObject1 = new jfh(this);
      continue;
      localObject1 = new jfj(this);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public int c()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public String c()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void c()
  {
    EffectPendantTools localEffectPendantTools = (EffectPendantTools)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(2);
    EffectConfigBase.ItemBase localItemBase = localEffectPendantTools.a(this.jdField_b_of_type_JavaLangString);
    if (localItemBase != null)
    {
      AVLog.c("EffectOperateManager", "gotoEffect item: " + localItemBase + ", id: " + localItemBase.getId());
      localEffectPendantTools.a(localItemBase);
      if (!localItemBase.isUsable()) {
        localEffectPendantTools.a(localItemBase);
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean c()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void d()
  {
    boolean bool = false;
    Object localObject = this.jdField_b_of_type_JavaLangString;
    EffectZimuManager localEffectZimuManager = (EffectZimuManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0);
    ZimuItem localZimuItem = (ZimuItem)localEffectZimuManager.a();
    if (localZimuItem == null) {
      bool = true;
    }
    for (;;)
    {
      AVLog.c("EffectOperateManager", "goto zimu id: " + (String)localObject + ", isChanged: " + bool);
      if (bool)
      {
        a(Integer.valueOf(6005), localObject, null);
        if (((AudioTransClientInfoHandler)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(1)).a())
        {
          localObject = AudioTransClientInfoHandlerExtend.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, (String)localObject);
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a(((AudioTransClientInfoHandlerExtend.ZimuCMD)localObject).jdField_a_of_type_Int, ((AudioTransClientInfoHandlerExtend.ZimuCMD)localObject).jdField_a_of_type_JavaLangString);
        }
        if (localZimuItem != null) {
          break;
        }
        localEffectZimuManager.a(true, null);
      }
      return;
      if (!((String)localObject).equalsIgnoreCase(localZimuItem.getId())) {
        bool = true;
      }
    }
    localEffectZimuManager.d();
  }
  
  public void e()
  {
    String str = this.jdField_b_of_type_JavaLangString;
    if (str.equals("0"))
    {
      a(Integer.valueOf(6101), null, Boolean.valueOf(true));
      return;
    }
    AudioHelper.a(str, false);
    a(Integer.valueOf(6100), str, Boolean.valueOf(true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.business.manager.EffectOperateManager
 * JD-Core Version:    0.7.0.1
 */