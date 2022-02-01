package com.tencent.mobileqq.apollo.drawer;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.activity.qqsettingme.QQSettingMeApolloProcessor;
import com.tencent.mobileqq.activity.qqsettingme.QQSettingMeViewModel;
import com.tencent.mobileqq.apollo.CmShowLauncher;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.script.drawerinfo.SpriteDrawerInfoManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class ExploreDrawerStrategy
  extends ApolloDrawerStrategy
{
  public int e;
  public long f;
  public String g = "";
  public String h = "";
  public int i;
  public String j;
  public int k;
  public int l;
  public String m;
  public int n;
  public WeakReference<QQSettingMe> o;
  private int p = 0;
  private int q = 0;
  private int r;
  
  public ExploreDrawerStrategy(QQAppInterface paramQQAppInterface, JSONObject paramJSONObject, QQSettingMe paramQQSettingMe)
  {
    super(paramQQAppInterface);
    this.a = 98;
    this.e = paramJSONObject.optInt("entry_id", 1);
    this.f = paramJSONObject.optLong("seq", 0L);
    this.g = paramJSONObject.optString("wording");
    this.h = paramJSONObject.optString("jump_url");
    this.i = paramJSONObject.optInt("is_red", 0);
    this.j = paramJSONObject.optString("icon_url");
    this.k = paramJSONObject.optInt("action_id", 0);
    this.l = paramJSONObject.optInt("bubble_id", 0);
    this.m = paramJSONObject.optString("scheme");
    this.n = paramJSONObject.optInt("show_sum", 1);
    this.q = paramJSONObject.optInt("msg_id", 0);
    this.r = paramJSONObject.optInt("cmshow_module", 1);
    this.o = new WeakReference(paramQQSettingMe);
  }
  
  public void a(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, Context paramContext, QQAppInterface paramQQAppInterface)
  {
    paramSpriteDrawerInfoManager = new StringBuilder();
    paramSpriteDrawerInfoManager.append("[onBubbleClick] ");
    paramSpriteDrawerInfoManager.append(this.m);
    paramSpriteDrawerInfoManager.append("|");
    paramSpriteDrawerInfoManager.append(this.h);
    QLog.d("[cmshow]ExploreDrawerStrategy", 1, paramSpriteDrawerInfoManager.toString());
    int i1;
    if (2 == this.r) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    paramSpriteDrawerInfoManager = new StringBuilder();
    paramSpriteDrawerInfoManager.append(this.l);
    paramSpriteDrawerInfoManager.append("");
    VipUtils.a(null, "cmshow", "Apollo", "DrawerBubble_clk", 0, i1, new String[] { paramSpriteDrawerInfoManager.toString(), String.valueOf(this.q) });
    CmShowLauncher.a(paramQQAppInterface, paramContext, this.m, this.h, "drawer");
  }
  
  public void a(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    paramContext = new StringBuilder();
    paramContext.append("[onBubbleShow] showCount： ");
    paramContext.append(this.p);
    paramContext.append(", showSum: ");
    paramContext.append(this.n);
    paramContext.append(", content: ");
    paramContext.append(this.g);
    QLog.d("[cmshow]ExploreDrawerStrategy", 1, paramContext.toString());
    paramInt = this.p;
    if (paramInt >= this.n) {
      return;
    }
    this.p = (paramInt + 1);
    if (!TextUtils.isEmpty(this.g))
    {
      SpriteUtil.a(paramSpriteDrawerInfoManager, this.g, 9, this.l);
      if (2 == this.r) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
      paramSpriteDrawerInfoManager = new StringBuilder();
      paramSpriteDrawerInfoManager.append(this.l);
      paramSpriteDrawerInfoManager.append("");
      VipUtils.a(null, "cmshow", "Apollo", "DrawerBubble_show", 0, paramInt, new String[] { paramSpriteDrawerInfoManager.toString(), String.valueOf(this.q) });
    }
    if (!TextUtils.isEmpty(this.j))
    {
      paramSpriteDrawerInfoManager = this.o;
      if (paramSpriteDrawerInfoManager != null)
      {
        paramSpriteDrawerInfoManager = (QQSettingMe)paramSpriteDrawerInfoManager.get();
        if (paramSpriteDrawerInfoManager != null)
        {
          if (QLog.isColorLevel())
          {
            paramContext = new StringBuilder();
            paramContext.append("[showExploreBox] url:");
            paramContext.append(this.j);
            QLog.d("QQSettingRedesign", 2, paramContext.toString());
          }
          ((QQSettingMeApolloProcessor)paramSpriteDrawerInfoManager.a().a("d_apollo")).b(this.j);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.drawer.ExploreDrawerStrategy
 * JD-Core Version:    0.7.0.1
 */