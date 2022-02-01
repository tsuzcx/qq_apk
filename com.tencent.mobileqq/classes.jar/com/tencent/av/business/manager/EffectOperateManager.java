package com.tencent.av.business.manager;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.av.ManageConfig.QAVConfItem;
import com.tencent.av.ManageConfig.QAVConfig;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.handler.AudioTransClientInfoHandler;
import com.tencent.av.business.handler.AudioTransClientInfoHandlerExtend;
import com.tencent.av.business.handler.BusinessHandlerFactory;
import com.tencent.av.business.manager.pendant.EffectPendantTools;
import com.tencent.av.business.manager.pendant.ItemBase;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.av.business.manager.zimu.EffectZimuManager;
import com.tencent.av.business.manager.zimu.ZimuItem;
import com.tencent.av.ui.ControlUIObserver.RequestPlayMagicFace;
import com.tencent.av.ui.ControlUIObserver.ZimuRequest;
import com.tencent.av.ui.VoiceChangeToolbar;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.ar.ArConfigUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

@Deprecated
public class EffectOperateManager
  extends BusinessManager
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString;
  private int e = -1;
  
  public EffectOperateManager(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
  }
  
  private void a(String paramString)
  {
    Object localObject;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("parse config: ");
      ((StringBuilder)localObject).append(paramString);
      AVLog.printColorLog("EffectOperateManager", ((StringBuilder)localObject).toString());
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
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
          this.jdField_b_of_type_JavaLangString = localJSONObject.getString("wording");
        }
        bool = localJSONObject.has("wordingColor");
        if (bool)
        {
          localObject = localJSONObject.getString("wordingColor");
          try
          {
            if (((String)localObject).startsWith("0x"))
            {
              paramString = ((String)localObject).replace("0x", "#");
            }
            else
            {
              paramString = (String)localObject;
              if (((String)localObject).startsWith("0X")) {
                paramString = ((String)localObject).replace("0X", "#");
              }
            }
            this.jdField_b_of_type_Int = Color.parseColor(paramString);
          }
          catch (NumberFormatException paramString)
          {
            this.jdField_b_of_type_Int = -1;
            paramString.printStackTrace();
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("parse|wording color is invalid!");
            ((StringBuilder)localObject).append(paramString.getMessage());
            AVLog.printColorLog("EffectOperateManager", ((StringBuilder)localObject).toString());
          }
        }
        else
        {
          this.jdField_b_of_type_Int = -1;
        }
        if (localJSONObject.has("wordingBgColor"))
        {
          localObject = localJSONObject.getString("wordingBgColor");
          try
          {
            if (((String)localObject).startsWith("0x"))
            {
              paramString = ((String)localObject).replace("0x", "#");
            }
            else
            {
              paramString = (String)localObject;
              if (((String)localObject).startsWith("0X")) {
                paramString = ((String)localObject).replace("0X", "#");
              }
            }
            this.jdField_c_of_type_Int = Color.parseColor(paramString);
          }
          catch (NumberFormatException paramString)
          {
            this.jdField_c_of_type_Int = -16777216;
            paramString.printStackTrace();
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("parse|wording color is invalid!");
            ((StringBuilder)localObject).append(paramString.getMessage());
            AVLog.printColorLog("EffectOperateManager", ((StringBuilder)localObject).toString());
          }
        }
        else
        {
          this.jdField_c_of_type_Int = -16777216;
        }
        if (localJSONObject.has("showTimes")) {
          this.jdField_d_of_type_Int = localJSONObject.getInt("showTimes");
        }
        if (localJSONObject.has("effectType")) {
          this.e = localJSONObject.getInt("effectType");
        }
        if (localJSONObject.has("effectId")) {
          this.jdField_c_of_type_JavaLangString = localJSONObject.getString("effectId");
        }
        if (localJSONObject.has("play")) {
          this.jdField_a_of_type_Boolean = localJSONObject.getBoolean("play");
        }
        if (localJSONObject.has("showBeforeConnect"))
        {
          if (localJSONObject.getInt("showBeforeConnect") != 0) {
            break label919;
          }
          bool = false;
          this.jdField_b_of_type_Boolean = bool;
        }
        if (localJSONObject.has("iconUrl")) {
          this.jdField_d_of_type_JavaLangString = localJSONObject.getString("iconUrl");
        }
        if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))
        {
          i = this.e;
          if (i == 1) {
            break label939;
          }
          if (i == 2) {
            break label934;
          }
          if (i == 4) {
            break label929;
          }
          if (i == 6) {
            break label924;
          }
          i = -1;
          if (i != -1)
          {
            paramString = ((EffectConfigBase)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i)).a(this.jdField_c_of_type_JavaLangString);
            if (paramString != null) {
              this.jdField_d_of_type_JavaLangString = paramString.getIconUrl();
            } else {
              AVLog.printColorLog("EffectOperateManager", "parse|cannot get item!");
            }
          }
          else
          {
            this.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
          }
        }
        paramString = new StringBuilder();
        paramString.append("parse|versionCode: ");
        paramString.append(this.jdField_a_of_type_Int);
        paramString.append(", beginTime: ");
        paramString.append(this.jdField_a_of_type_Long);
        paramString.append(", endTime: ");
        paramString.append(this.jdField_b_of_type_Long);
        paramString.append(", wording: ");
        paramString.append(this.jdField_b_of_type_JavaLangString);
        paramString.append(", play: ");
        paramString.append(this.jdField_a_of_type_Boolean);
        paramString.append(", wordingColor: 0x");
        paramString.append(Long.toString(this.jdField_b_of_type_Int, 16).toUpperCase());
        paramString.append(", wordingBgColor: 0x");
        paramString.append(Long.toString(this.jdField_c_of_type_Int, 16).toUpperCase());
        paramString.append(", showTimes: ");
        paramString.append(this.jdField_d_of_type_Int);
        paramString.append(", showBeforeConnect: ");
        paramString.append(this.jdField_b_of_type_Boolean);
        paramString.append(", effectType: ");
        paramString.append(this.e);
        paramString.append(", effectId: ");
        paramString.append(this.jdField_c_of_type_JavaLangString);
        paramString.append(", iconUrl: ");
        paramString.append(this.jdField_d_of_type_JavaLangString);
        AVLog.printColorLog("EffectOperateManager", paramString.toString());
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("parse exception: ");
        ((StringBuilder)localObject).append(paramString.toString());
        AVLog.printColorLog("EffectOperateManager", ((StringBuilder)localObject).toString());
        return;
      }
      AVLog.printColorLog("EffectOperateManager", "parse|config is empty!");
      return;
      label919:
      boolean bool = true;
      continue;
      label924:
      int i = 0;
      continue;
      label929:
      i = 1;
      continue;
      label934:
      i = 3;
      continue;
      label939:
      i = 2;
    }
  }
  
  public int a()
  {
    return this.e;
  }
  
  public String a()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  protected void a()
  {
    a(QAVConfig.b(263).a);
  }
  
  protected void a(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("notifyEvent :");
    localStringBuilder.append(paramInteger);
    localStringBuilder.append("|");
    localStringBuilder.append(paramObject1);
    localStringBuilder.append("|");
    localStringBuilder.append(paramObject2);
    AVLog.printColorLog("EffectOperateManager", localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { paramInteger, paramObject1, paramObject2 });
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject1 = UITools.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("qav_effect_operate_config_show_times_");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_Int);
    localObject2 = ((StringBuilder)localObject2).toString();
    int i = 0;
    if (!paramBoolean) {
      i = ((SharedPreferences)localObject1).getInt((String)localObject2, 0);
    }
    localObject1 = ((SharedPreferences)localObject1).edit();
    ((SharedPreferences.Editor)localObject1).putInt((String)localObject2, i + 1);
    ((SharedPreferences.Editor)localObject1).commit();
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  protected boolean a(String paramString)
  {
    return false;
  }
  
  void b()
  {
    long l = AudioHelper.b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("gotoVoiceChangePendant, effectId[");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append("], play[");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l);
    localStringBuilder.append("]");
    QLog.w("EffectOperateManager", 1, localStringBuilder.toString());
    if (this.jdField_a_of_type_Boolean) {
      VoiceChangeToolbar.setEffectConfigItem(l, this.jdField_c_of_type_JavaLangString);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a();
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setEffectOperateShown, sessionInfo为null, show[");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("]");
      QLog.w("EffectOperateManager", 1, ((StringBuilder)localObject).toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setEffectOperateShown, hasShownEffectOperate[");
    localStringBuilder.append(((SessionInfo)localObject).u);
    localStringBuilder.append("->");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("], sessionInfo[");
    localStringBuilder.append(localObject);
    localStringBuilder.append("]");
    QLog.w("EffectOperateManager", 1, localStringBuilder.toString());
    ((SessionInfo)localObject).u = paramBoolean;
    if (paramBoolean) {
      a(false);
    }
  }
  
  void c()
  {
    EffectPendantTools localEffectPendantTools = (EffectPendantTools)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(2);
    PendantItem localPendantItem = (PendantItem)localEffectPendantTools.a(this.jdField_c_of_type_JavaLangString);
    if (localPendantItem != null)
    {
      long l = AudioHelper.b();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("gotoPendant, id[");
      localStringBuilder.append(localPendantItem.getId());
      localStringBuilder.append("], seq[");
      localStringBuilder.append(l);
      localStringBuilder.append("], play[");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      localStringBuilder.append("], item[");
      localStringBuilder.append(localPendantItem);
      localStringBuilder.append("]");
      QLog.w("EffectOperateManager", 1, localStringBuilder.toString());
      if (this.jdField_a_of_type_Boolean)
      {
        if (!localPendantItem.isUsable())
        {
          localEffectPendantTools.jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
          a(Integer.valueOf(171), null, null);
          localEffectPendantTools.a(l, localPendantItem);
          return;
        }
        localEffectPendantTools.a(l, localPendantItem);
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  void d()
  {
    String str = this.jdField_c_of_type_JavaLangString;
    Object localObject1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
    boolean bool = false;
    localObject1 = (EffectZimuManager)((VideoAppInterface)localObject1).a(0);
    Object localObject2 = (ZimuItem)((EffectZimuManager)localObject1).a();
    if (localObject2 == null) {}
    while (!str.equalsIgnoreCase(((ZimuItem)localObject2).getId()))
    {
      bool = true;
      break;
    }
    long l = AudioHelper.b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("gotoZimu, id[");
    localStringBuilder.append(str);
    localStringBuilder.append("], isChanged[");
    localStringBuilder.append(bool);
    localStringBuilder.append("], play[");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l);
    localStringBuilder.append("]");
    QLog.w("EffectOperateManager", 1, localStringBuilder.toString());
    if ((bool) && (this.jdField_a_of_type_Boolean))
    {
      new ControlUIObserver.ZimuRequest(l, "gotoZimu", 1, str).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      if (((AudioTransClientInfoHandler)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getBusinessHandler(BusinessHandlerFactory.jdField_b_of_type_JavaLangString)).a()) {
        AudioTransClientInfoHandlerExtend.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, "gotoZimu", l, str, true);
      }
      if (localObject2 == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("gotoZimu_");
        ((StringBuilder)localObject2).append(str);
        ((EffectZimuManager)localObject1).a(((StringBuilder)localObject2).toString(), true, l, null);
        return;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("gotoZimu_");
      ((StringBuilder)localObject2).append(str);
      ((EffectZimuManager)localObject1).b(((StringBuilder)localObject2).toString(), l);
    }
  }
  
  void e()
  {
    String str = this.jdField_c_of_type_JavaLangString;
    if (str.equals("0"))
    {
      a(Integer.valueOf(6101), null, Boolean.valueOf(true));
      return;
    }
    AudioHelper.a(str, false);
    if (this.jdField_a_of_type_Boolean) {
      new ControlUIObserver.RequestPlayMagicFace(AudioHelper.b(), str, true, 5).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.EffectOperateManager
 * JD-Core Version:    0.7.0.1
 */