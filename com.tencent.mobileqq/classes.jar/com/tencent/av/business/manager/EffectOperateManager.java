package com.tencent.av.business.manager;

import amxa;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.av.business.manager.zimu.ZimuItem;
import com.tencent.av.ui.VoiceChangeToolbar;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import lek;
import lew;
import lex;
import lid;
import liv;
import liw;
import ljg;
import ljo;
import lkt;
import lls;
import mez;
import mfa;
import mww;
import org.json.JSONObject;

@Deprecated
public class EffectOperateManager
  extends ljg
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
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString;
  private int e = -1;
  
  public EffectOperateManager(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
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
      lek.c("EffectOperateManager", "parse config: " + paramString);
      try
      {
        localJSONObject = new JSONObject(paramString);
        if (localJSONObject.has("versionCode")) {
          this.jdField_a_of_type_Int = localJSONObject.getInt("versionCode");
        }
        if (localJSONObject.has("beginTime")) {
          this.jdField_a_of_type_Long = amxa.a(localJSONObject.getString("beginTime"));
        }
        if (localJSONObject.has("endTime")) {
          this.jdField_b_of_type_Long = amxa.a(localJSONObject.getString("endTime"));
        }
        if (localJSONObject.has("wording")) {
          this.jdField_b_of_type_JavaLangString = localJSONObject.getString("wording");
        }
        if (localJSONObject.has("wordingColor"))
        {
          str = localJSONObject.getString("wordingColor");
          try
          {
            if (!str.startsWith("0x")) {
              break label622;
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
              lek.c("EffectOperateManager", "parse|wording color is invalid!" + paramString.getMessage());
            }
          }
          if (!localJSONObject.has("wordingBgColor")) {
            break label796;
          }
          str = localJSONObject.getString("wordingBgColor");
        }
      }
      catch (Exception paramString)
      {
        JSONObject localJSONObject;
        paramString.printStackTrace();
        lek.c("EffectOperateManager", "parse exception: " + paramString.toString());
        return;
      }
      try
      {
        if (!str.startsWith("0x")) {
          break label729;
        }
        paramString = str.replace("0x", "#");
        this.jdField_c_of_type_Int = Color.parseColor(paramString);
      }
      catch (NumberFormatException paramString)
      {
        this.jdField_c_of_type_Int = -16777216;
        paramString.printStackTrace();
        lek.c("EffectOperateManager", "parse|wording color is invalid!" + paramString.getMessage());
        break label225;
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
          break label839;
        }
        bool = false;
        label331:
        this.jdField_b_of_type_Boolean = bool;
      }
      if (localJSONObject.has("iconUrl")) {
        this.jdField_d_of_type_JavaLangString = localJSONObject.getString("iconUrl");
      }
      if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
        switch (this.e)
        {
        }
      }
    }
    for (;;)
    {
      if (i != -1)
      {
        paramString = ((EffectConfigBase)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i)).a(this.jdField_c_of_type_JavaLangString);
        if (paramString != null) {
          this.jdField_d_of_type_JavaLangString = paramString.getIconurl();
        }
      }
      for (;;)
      {
        lek.c("EffectOperateManager", "parse|versionCode: " + this.jdField_a_of_type_Int + ", beginTime: " + this.jdField_a_of_type_Long + ", endTime: " + this.jdField_b_of_type_Long + ", wording: " + this.jdField_b_of_type_JavaLangString + ", play: " + this.jdField_a_of_type_Boolean + ", wordingColor: 0x" + Long.toString(this.jdField_b_of_type_Int, 16).toUpperCase() + ", wordingBgColor: 0x" + Long.toString(this.jdField_c_of_type_Int, 16).toUpperCase() + ", showTimes: " + this.jdField_d_of_type_Int + ", showBeforeConnect: " + this.jdField_b_of_type_Boolean + ", effectType: " + this.e + ", effectId: " + this.jdField_c_of_type_JavaLangString + ", iconUrl: " + this.jdField_d_of_type_JavaLangString);
        return;
        label622:
        paramString = str;
        if (!str.startsWith("0X")) {
          break;
        }
        paramString = str.replace("0X", "#");
        break;
        this.jdField_b_of_type_Int = -1;
        break label178;
        label729:
        paramString = str;
        if (!str.startsWith("0X")) {
          break label217;
        }
        paramString = str.replace("0X", "#");
        break label217;
        label796:
        this.jdField_c_of_type_Int = -16777216;
        break label225;
        lek.c("EffectOperateManager", "parse|cannot get item!");
        continue;
        this.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      }
      lek.c("EffectOperateManager", "parse|config is empty!");
      return;
      int i = -1;
      continue;
      label839:
      bool = true;
      break label331;
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
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public void a()
  {
    a(lex.b(263).a);
  }
  
  protected void a(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    lek.c("EffectOperateManager", "notifyEvent :" + paramInteger + "|" + paramObject1 + "|" + paramObject2);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { paramInteger, paramObject1, paramObject2 });
  }
  
  public void a(boolean paramBoolean)
  {
    int i = 0;
    Object localObject = mww.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    String str = "qav_effect_operate_config_show_times_" + this.jdField_a_of_type_Int;
    if (!paramBoolean) {
      i = ((SharedPreferences)localObject).getInt(str, 0);
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putInt(str, i + 1);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public boolean a(String paramString)
  {
    return false;
  }
  
  void b()
  {
    long l = AudioHelper.b();
    QLog.w("EffectOperateManager", 1, "gotoVoiceChangePendant, effectId[" + this.jdField_c_of_type_JavaLangString + "], play[" + this.jdField_a_of_type_Boolean + "], seq[" + l + "]");
    if (this.jdField_a_of_type_Boolean) {
      VoiceChangeToolbar.setEffectConfigItem(l, this.jdField_c_of_type_JavaLangString);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    lid locallid = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a();
    if (locallid == null) {
      QLog.w("EffectOperateManager", 1, "setEffectOperateShown, sessionInfo为null, show[" + paramBoolean + "]");
    }
    do
    {
      return;
      QLog.w("EffectOperateManager", 1, "setEffectOperateShown, hasShownEffectOperate[" + locallid.v + "->" + paramBoolean + "], sessionInfo[" + locallid + "]");
      locallid.v = paramBoolean;
    } while (!paramBoolean);
    a(false);
  }
  
  void c()
  {
    lkt locallkt = (lkt)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(2);
    PendantItem localPendantItem = (PendantItem)locallkt.a(this.jdField_c_of_type_JavaLangString);
    long l;
    if (localPendantItem != null)
    {
      l = AudioHelper.b();
      QLog.w("EffectOperateManager", 1, "gotoPendant, id[" + localPendantItem.getId() + "], seq[" + l + "], play[" + this.jdField_a_of_type_Boolean + "], item[" + localPendantItem + "]");
      if (this.jdField_a_of_type_Boolean)
      {
        if (localPendantItem.isUsable()) {
          break label147;
        }
        locallkt.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
        a(Integer.valueOf(171), null, null);
        locallkt.a(l, localPendantItem);
      }
    }
    return;
    label147:
    locallkt.a(l, localPendantItem);
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  void d()
  {
    String str = this.jdField_c_of_type_JavaLangString;
    lls locallls = (lls)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0);
    ZimuItem localZimuItem = (ZimuItem)locallls.a();
    boolean bool;
    if (localZimuItem == null) {
      bool = true;
    }
    long l;
    for (;;)
    {
      l = AudioHelper.b();
      QLog.w("EffectOperateManager", 1, "gotoZimu, id[" + str + "], isChanged[" + bool + "], play[" + this.jdField_a_of_type_Boolean + "], seq[" + l + "]");
      if ((bool) && (this.jdField_a_of_type_Boolean))
      {
        new mfa(l, "gotoZimu", 1, str).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        if (((liv)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(1)).a()) {
          liw.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, "gotoZimu", l, str, true);
        }
        if (localZimuItem != null) {
          break;
        }
        locallls.a("gotoZimu_" + str, true, l, null);
      }
      return;
      if (!str.equalsIgnoreCase(localZimuItem.getId())) {
        bool = true;
      } else {
        bool = false;
      }
    }
    locallls.b("gotoZimu_" + str, l);
  }
  
  void e()
  {
    String str = this.jdField_c_of_type_JavaLangString;
    if (str.equals("0")) {
      a(Integer.valueOf(6101), null, Boolean.valueOf(true));
    }
    do
    {
      return;
      AudioHelper.a(str, false);
    } while (!this.jdField_a_of_type_Boolean);
    new mez(AudioHelper.b(), str, true, 5).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.business.manager.EffectOperateManager
 * JD-Core Version:    0.7.0.1
 */