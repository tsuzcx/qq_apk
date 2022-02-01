package com.tencent.mobileqq.apollo.aio.panel;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.aio.panel.viewbinder.Apollo3dActionViewBinder;
import com.tencent.mobileqq.apollo.aio.panel.viewbinder.ApolloBattleGameViewBinder;
import com.tencent.mobileqq.apollo.aio.panel.viewbinder.ApolloTagActionViewBinder;
import com.tencent.mobileqq.apollo.aio.panel.viewbinder.ApolloViewBinder;
import com.tencent.mobileqq.apollo.config.CmShowWnsUtils;
import com.tencent.mobileqq.apollo.model.ApolloActionPackage;
import com.tencent.mobileqq.apollo.script.SpriteActionScript;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.utils.ApolloPanelUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.cmshow.engine.CMShowPlatform;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class Panel3DStrategy
  extends PanelStrategy
{
  public Panel3DStrategy(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo);
  }
  
  public ApolloViewBinder a(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 302) {
      return new ApolloBattleGameViewBinder(this.a, this.b, this.c);
    }
    if ((paramInt2 != 0) && (paramInt2 != 1) && (paramInt2 != 9) && (paramInt2 != 303)) {
      return b(paramInt1);
    }
    return new ApolloTagActionViewBinder(this.b, this.a, this.c);
  }
  
  public void a(List<ApolloViewBinder> paramList, List<ApolloActionPackage> paramList1, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 0;
    int m = 0;
    while (i < paramList.size())
    {
      m += ((ApolloViewBinder)paramList.get(i)).c();
      i += 1;
    }
    Object localObject = this.a.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("apollo_sp");
    localStringBuilder.append(this.a.getCurrentUin());
    localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
    if (((SharedPreferences)localObject).contains("sp_key_apollo_current_page_index_3d"))
    {
      localObject = ((SharedPreferences)localObject).getString("sp_key_apollo_current_page_index_3d", null);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        try
        {
          i = Integer.parseInt((String)localObject);
          if (i >= m) {
            break label207;
          }
          try
          {
            if (QLog.isColorLevel()) {
              QLog.d("[cmshow]Panel3DStrategy", 2, new Object[] { "[setCurrentIndex] from previous saved for 3d, pagerIndex=", Integer.valueOf(i) });
            }
            j = 1;
          }
          catch (Exception localException1)
          {
            j = 1;
          }
          QLog.e("[cmshow]Panel3DStrategy", 1, "parse previousSavedPagerIndexStr error", localException2);
        }
        catch (Exception localException2)
        {
          j = 0;
          i = -1;
        }
        break label213;
      }
    }
    label207:
    int j = 0;
    i = -1;
    label213:
    if (j == 0)
    {
      int n = paramList1.size();
      int k = 0;
      while (k < n)
      {
        ApolloActionPackage localApolloActionPackage = (ApolloActionPackage)paramList1.get(k);
        if ((localApolloActionPackage != null) && (localApolloActionPackage.packageId == 300)) {
          break label280;
        }
        k += 1;
      }
      k = 0;
      if (k < paramList.size())
      {
        i = a(paramList, k);
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]Panel3DStrategy", 2, new Object[] { "[setCurrentIndex] default single action, pagerIndex=", Integer.valueOf(i) });
        }
        j = 1;
      }
    }
    label280:
    if (j == 0) {
      i = 1;
    }
    if (i < m)
    {
      ApolloPanel.a = i;
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]Panel3DStrategy", 2, new Object[] { "[setCurrentIndex] sCurrentIndex= ", Integer.valueOf(ApolloPanel.a) });
      }
    }
  }
  
  public boolean a(int paramInt)
  {
    boolean bool1 = CmShowWnsUtils.W();
    boolean bool2 = false;
    if (((!bool1) || (!CMShowPlatform.a.b(Scene.MEME_PLAYER))) && (paramInt == 303)) {
      return false;
    }
    bool1 = bool2;
    if (paramInt >= 100)
    {
      bool1 = bool2;
      if (paramInt != 400) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public ApolloViewBinder b(int paramInt)
  {
    return new Apollo3dActionViewBinder(this.b, this.a, this.c);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    QLog.d("[cmshow]Panel3DStrategy", 1, new Object[] { "saveCurrentIndex-3D, index:", Integer.valueOf(paramInt1), ", packageId:", Integer.valueOf(paramInt2) });
    ApolloPanelUtil.a(2, paramInt1, paramInt2);
    SpriteActionScript localSpriteActionScript = SpriteUtil.i(this.a);
    if (localSpriteActionScript != null) {
      localSpriteActionScript.a(String.valueOf(paramInt2), "tabStatusChange");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.Panel3DStrategy
 * JD-Core Version:    0.7.0.1
 */