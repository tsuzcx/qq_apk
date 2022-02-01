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
import com.tencent.av.ui.effect.toolbar.oldversion.VoiceChangeToolbar;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.ar.ArConfigUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

@Deprecated
public class EffectOperateManager
  extends BusinessManager
{
  private int d;
  private long e;
  private long f;
  private String g;
  private int h;
  private int i;
  private int j;
  private int k = -1;
  private String l;
  private String m;
  private boolean n = true;
  private boolean o;
  private boolean p = false;
  
  public EffectOperateManager(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
  }
  
  private void b(String paramString)
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
          this.d = localJSONObject.getInt("versionCode");
        }
        if (localJSONObject.has("beginTime")) {
          this.e = ArConfigUtils.a(localJSONObject.getString("beginTime"));
        }
        if (localJSONObject.has("endTime")) {
          this.f = ArConfigUtils.a(localJSONObject.getString("endTime"));
        }
        if (localJSONObject.has("wording")) {
          this.g = localJSONObject.getString("wording");
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
            this.h = Color.parseColor(paramString);
          }
          catch (NumberFormatException paramString)
          {
            this.h = -1;
            paramString.printStackTrace();
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("parse|wording color is invalid!");
            ((StringBuilder)localObject).append(paramString.getMessage());
            AVLog.printColorLog("EffectOperateManager", ((StringBuilder)localObject).toString());
          }
        }
        else
        {
          this.h = -1;
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
            this.i = Color.parseColor(paramString);
          }
          catch (NumberFormatException paramString)
          {
            this.i = -16777216;
            paramString.printStackTrace();
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("parse|wording color is invalid!");
            ((StringBuilder)localObject).append(paramString.getMessage());
            AVLog.printColorLog("EffectOperateManager", ((StringBuilder)localObject).toString());
          }
        }
        else
        {
          this.i = -16777216;
        }
        if (localJSONObject.has("showTimes")) {
          this.j = localJSONObject.getInt("showTimes");
        }
        if (localJSONObject.has("effectType")) {
          this.k = localJSONObject.getInt("effectType");
        }
        if (localJSONObject.has("effectId")) {
          this.l = localJSONObject.getString("effectId");
        }
        if (localJSONObject.has("play")) {
          this.n = localJSONObject.getBoolean("play");
        }
        if (localJSONObject.has("showBeforeConnect"))
        {
          if (localJSONObject.getInt("showBeforeConnect") != 0) {
            break label919;
          }
          bool = false;
          this.o = bool;
        }
        if (localJSONObject.has("iconUrl")) {
          this.m = localJSONObject.getString("iconUrl");
        }
        if (TextUtils.isEmpty(this.m))
        {
          i1 = this.k;
          if (i1 == 1) {
            break label939;
          }
          if (i1 == 2) {
            break label934;
          }
          if (i1 == 4) {
            break label929;
          }
          if (i1 == 6) {
            break label924;
          }
          i1 = -1;
          if (i1 != -1)
          {
            paramString = ((EffectConfigBase)this.c.c(i1)).b(this.l);
            if (paramString != null) {
              this.m = paramString.getIconUrl();
            } else {
              AVLog.printColorLog("EffectOperateManager", "parse|cannot get item!");
            }
          }
          else
          {
            this.m = this.l;
          }
        }
        paramString = new StringBuilder();
        paramString.append("parse|versionCode: ");
        paramString.append(this.d);
        paramString.append(", beginTime: ");
        paramString.append(this.e);
        paramString.append(", endTime: ");
        paramString.append(this.f);
        paramString.append(", wording: ");
        paramString.append(this.g);
        paramString.append(", play: ");
        paramString.append(this.n);
        paramString.append(", wordingColor: 0x");
        paramString.append(Long.toString(this.h, 16).toUpperCase());
        paramString.append(", wordingBgColor: 0x");
        paramString.append(Long.toString(this.i, 16).toUpperCase());
        paramString.append(", showTimes: ");
        paramString.append(this.j);
        paramString.append(", showBeforeConnect: ");
        paramString.append(this.o);
        paramString.append(", effectType: ");
        paramString.append(this.k);
        paramString.append(", effectId: ");
        paramString.append(this.l);
        paramString.append(", iconUrl: ");
        paramString.append(this.m);
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
      int i1 = 0;
      continue;
      label929:
      i1 = 1;
      continue;
      label934:
      i1 = 3;
      continue;
      label939:
      i1 = 2;
    }
  }
  
  protected void a()
  {
    b(QAVConfig.b(263).b);
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
    this.c.a(new Object[] { paramInteger, paramObject1, paramObject2 });
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject1 = UITools.a(this.c);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("qav_effect_operate_config_show_times_");
    ((StringBuilder)localObject2).append(this.d);
    localObject2 = ((StringBuilder)localObject2).toString();
    int i1 = 0;
    if (!paramBoolean) {
      i1 = ((SharedPreferences)localObject1).getInt((String)localObject2, 0);
    }
    localObject1 = ((SharedPreferences)localObject1).edit();
    ((SharedPreferences.Editor)localObject1).putInt((String)localObject2, i1 + 1);
    ((SharedPreferences.Editor)localObject1).commit();
  }
  
  protected boolean a(String paramString)
  {
    return false;
  }
  
  public int b()
  {
    return this.k;
  }
  
  public void b(boolean paramBoolean)
  {
    Object localObject = this.c.b().k();
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
    localStringBuilder.append(((SessionInfo)localObject).T);
    localStringBuilder.append("->");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("], sessionInfo[");
    localStringBuilder.append(localObject);
    localStringBuilder.append("]");
    QLog.w("EffectOperateManager", 1, localStringBuilder.toString());
    ((SessionInfo)localObject).T = paramBoolean;
    if (paramBoolean) {
      a(false);
    }
  }
  
  public String c()
  {
    return this.l;
  }
  
  public void c(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
  
  void d()
  {
    long l1 = AudioHelper.c();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("gotoVoiceChangePendant, effectId[");
    localStringBuilder.append(this.l);
    localStringBuilder.append("], play[");
    localStringBuilder.append(this.n);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l1);
    localStringBuilder.append("]");
    QLog.w("EffectOperateManager", 1, localStringBuilder.toString());
    if (this.n) {
      VoiceChangeToolbar.setEffectConfigItem(l1, this.l);
    }
  }
  
  void e()
  {
    EffectPendantTools localEffectPendantTools = (EffectPendantTools)this.c.c(2);
    PendantItem localPendantItem = (PendantItem)localEffectPendantTools.b(this.l);
    if (localPendantItem != null)
    {
      long l1 = AudioHelper.c();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("gotoPendant, id[");
      localStringBuilder.append(localPendantItem.getId());
      localStringBuilder.append("], seq[");
      localStringBuilder.append(l1);
      localStringBuilder.append("], play[");
      localStringBuilder.append(this.n);
      localStringBuilder.append("], item[");
      localStringBuilder.append(localPendantItem);
      localStringBuilder.append("]");
      QLog.w("EffectOperateManager", 1, localStringBuilder.toString());
      if (this.n)
      {
        if (!localPendantItem.isUsable())
        {
          localEffectPendantTools.k = this.l;
          a(Integer.valueOf(171), null, null);
          localEffectPendantTools.b(l1, localPendantItem);
          return;
        }
        localEffectPendantTools.a(l1, localPendantItem);
      }
    }
  }
  
  void f()
  {
    String str = this.l;
    Object localObject1 = this.c;
    boolean bool = false;
    localObject1 = (EffectZimuManager)((VideoAppInterface)localObject1).c(0);
    Object localObject2 = (ZimuItem)((EffectZimuManager)localObject1).c();
    if (localObject2 == null) {}
    while (!str.equalsIgnoreCase(((ZimuItem)localObject2).getId()))
    {
      bool = true;
      break;
    }
    long l1 = AudioHelper.c();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("gotoZimu, id[");
    localStringBuilder.append(str);
    localStringBuilder.append("], isChanged[");
    localStringBuilder.append(bool);
    localStringBuilder.append("], play[");
    localStringBuilder.append(this.n);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l1);
    localStringBuilder.append("]");
    QLog.w("EffectOperateManager", 1, localStringBuilder.toString());
    if ((bool) && (this.n))
    {
      new ControlUIObserver.ZimuRequest(l1, "gotoZimu", 1, str).a(this.c);
      if (((AudioTransClientInfoHandler)this.c.getBusinessHandler(BusinessHandlerFactory.b)).a()) {
        AudioTransClientInfoHandlerExtend.a(this.c, "gotoZimu", l1, str, true);
      }
      if (localObject2 == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("gotoZimu_");
        ((StringBuilder)localObject2).append(str);
        ((EffectZimuManager)localObject1).a(((StringBuilder)localObject2).toString(), true, l1, null);
        return;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("gotoZimu_");
      ((StringBuilder)localObject2).append(str);
      ((EffectZimuManager)localObject1).b(((StringBuilder)localObject2).toString(), l1);
    }
  }
  
  void g()
  {
    String str = this.l;
    if (str.equals("0"))
    {
      a(Integer.valueOf(6101), null, Boolean.valueOf(true));
      return;
    }
    AudioHelper.a(str, false);
    if (this.n) {
      new ControlUIObserver.RequestPlayMagicFace(AudioHelper.c(), str, true, 5).a(this.c);
    }
  }
  
  public boolean h()
  {
    return this.p;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.EffectOperateManager
 * JD-Core Version:    0.7.0.1
 */