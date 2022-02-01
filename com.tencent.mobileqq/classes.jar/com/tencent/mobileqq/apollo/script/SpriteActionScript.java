package com.tencent.mobileqq.apollo.script;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.game.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil;
import com.tencent.mobileqq.apollo.statistics.product.DtReportParamsBuilder;
import com.tencent.mobileqq.apollo.utils.ApolloPanelUtil;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloActionHelperImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.cmshow.engine.ICMShowEngine;
import com.tencent.mobileqq.cmshow.engine.render.ICMShowView;
import com.tencent.mobileqq.cmshow.engine.render.IRenderService;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager;
import com.tencent.mobileqq.cmshow.engine.script.IScriptService;
import com.tencent.mobileqq.cmshow.engine.script.ScriptUtils;
import com.tencent.mobileqq.cmshow.engine.script.task.AbsScriptTask;
import com.tencent.mobileqq.cmshow.engine.script.task.CommonInitTask;
import com.tencent.mobileqq.cmshow.engine.script.task.IScriptTaskBuilder;
import com.tencent.mobileqq.cmshow.engine.script.task.ScriptTaskType;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class SpriteActionScript
  extends SpriteAioScript
  implements ISpriteActionScript
{
  public SpriteActionScript(int paramInt, SpriteContext paramSpriteContext)
  {
    super(paramInt, paramSpriteContext);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, int paramInt5, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow][scripted]SpriteActionScript", 2, new Object[] { "[init], width:", Integer.valueOf(paramInt1), ",height:", Integer.valueOf(paramInt2), ",vHeight:", Integer.valueOf(paramInt3), ",aioType:", Integer.valueOf(paramInt4), "friendUin:", paramString, ",spriteFrom:", Integer.valueOf(paramInt5), ", isBubbleMeme:", Boolean.valueOf(paramBoolean) });
    }
    if (this.f == null)
    {
      QLog.w("[cmshow][scripted]SpriteActionScript", 1, "init error, mSpriteContext null");
      return;
    }
    QQAppInterface localQQAppInterface = this.f.l();
    if (localQQAppInterface == null)
    {
      QLog.w("[cmshow][scripted]SpriteActionScript", 1, "init error, appInterface null");
      return;
    }
    Object localObject = this.f.o();
    if (localObject == null)
    {
      QLog.w("[cmshow][scripted]SpriteActionScript", 1, "init error, scriptService null");
      return;
    }
    try
    {
      localObject = (CommonInitTask)((IScriptService)localObject).b().a(ScriptTaskType.COMMON_INIT);
      ((CommonInitTask)localObject).c(this.f.j).a(ApolloGameUtil.a(localQQAppInterface, paramInt4, this.f.b)).a(paramString).b(this.f.c).a(paramBoolean);
      ((CommonInitTask)localObject).c(paramInt1).d(paramInt2).e(paramInt3).b(paramInt5);
      paramString = ((CommonInitTask)localObject).a();
      this.f.a(paramString);
      if (QLog.isColorLevel())
      {
        QLog.d("[cmshow][scripted]SpriteActionScript", 2, new Object[] { paramString });
        return;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("[cmshow][scripted]SpriteActionScript", 1, "[getCommonInit], errInfo->", paramString);
    }
  }
  
  public void a()
  {
    if ((this.f != null) && (this.f.n() != null))
    {
      ICMShowView localICMShowView = this.f.n().c().a();
      int i = localICMShowView.getRenderWidth();
      int j = localICMShowView.getRenderHeight();
      a(i, localICMShowView.getInitHeight(), j, this.f.a, this.f.b, this.f.i, this.f.l);
      return;
    }
    QLog.e("[cmshow][scripted]SpriteActionScript", 1, "onLoadFinish mSpriteContext null error");
  }
  
  public void a(int paramInt)
  {
    if (this.f.i != 0) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow][scripted]SpriteActionScript", 2, new Object[] { "[notifyPanelStatusChanged], status:", Integer.valueOf(paramInt) });
    }
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("errCode", 0);
      ((JSONObject)localObject).put("status", paramInt);
      this.f.a("sc.script_panel_status_change.local", ((JSONObject)localObject).toString());
      if (1 != paramInt) {
        break label372;
      }
      localObject = "panel_close_clk";
    }
    catch (Throwable localThrowable)
    {
      Object localObject;
      int i;
      int j;
      long l;
      DtReportParamsBuilder localDtReportParamsBuilder;
      QLog.e("[cmshow][scripted]SpriteActionScript", 1, "[notifyPanelStatusChanged],", localThrowable);
      return;
    }
    VipUtils.a(this.f.l(), "cmshow", "Apollo", (String)localObject, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionType(this.f.a), ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportUserResult(this.f.d), new String[] { "", "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
    localObject = BaseApplicationImpl.getApplication().getSharedPreferences("CmshowIntimateAction_sp", 4);
    i = ((SharedPreferences)localObject).getInt("relationType", 0);
    j = ((SharedPreferences)localObject).getInt("actionId", 0);
    l = ((SharedPreferences)localObject).getLong("timestamp", 0L);
    localDtReportParamsBuilder = new DtReportParamsBuilder().a(ApolloDtReportUtil.a(this.f.l())).b(ApolloDtReportUtil.a(this.f.a)).c(this.f.b);
    if ((i > 0) && (j > 0) && (l > 0L))
    {
      l /= 1000L;
      localDtReportParamsBuilder.f(String.valueOf(j)).b(Integer.valueOf(i)).a(Long.valueOf(l));
    }
    else
    {
      localDtReportParamsBuilder.b(Integer.valueOf(0));
    }
    for (;;)
    {
      ApolloDtReportUtil.a("aio", "sprite", (String)localObject, localDtReportParamsBuilder.a());
      return;
      for (;;)
      {
        break;
        label372:
        if (2 != paramInt) {
          break label385;
        }
        str = "panel_open_clk";
      }
      label385:
      String str = "";
      break;
      if (paramInt == 2) {
        str = "click";
      } else {
        str = "close";
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow][scripted]SpriteActionScript", 2, new Object[] { "[notifyDrawRectChanged], width:", Integer.valueOf(paramInt1), ",height:", Integer.valueOf(paramInt2) });
      }
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("errCode", 0);
      localJSONObject.put("width", paramInt1);
      localJSONObject.put("height", paramInt2);
      this.f.a("sc.script_draw_area_change.local", localJSONObject.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("[cmshow][scripted]SpriteActionScript", 1, "[notifySpriteVisibility],", localThrowable);
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    try
    {
      String str = ApolloPanelUtil.a();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(", tabType(packageId):");
      ((StringBuilder)localObject).append(str);
      QLog.d("[cmshow][scripted]SpriteActionScript", 2, new Object[] { "[notifySpriteClicked], clickPart:", Integer.valueOf(paramInt), ", url:", paramString1, ((StringBuilder)localObject).toString() });
      localObject = new JSONObject();
      ((JSONObject)localObject).put("errCode", 0);
      ((JSONObject)localObject).put("clickPart", paramInt);
      if (!TextUtils.isEmpty(paramString1)) {
        ((JSONObject)localObject).put("url", paramString1);
      }
      if (!TextUtils.isEmpty(paramString2)) {
        ((JSONObject)localObject).put("apolloId", paramString2);
      }
      if (!TextUtils.isEmpty(str)) {
        ((JSONObject)localObject).put("tabType", Integer.valueOf(str));
      }
      this.f.a("sc.script_on_sprite_single_clicked.local", ((JSONObject)localObject).toString());
      return;
    }
    catch (Throwable paramString1)
    {
      QLog.e("[cmshow][scripted]SpriteActionScript", 1, "[notifySpriteClicked],", paramString1);
    }
  }
  
  public void a(int paramInt, ArrayList<String> paramArrayList)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[notifyStatusOrDressChanged], type:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("[cmshow][scripted]SpriteActionScript", 1, ((StringBuilder)localObject).toString());
      localObject = new JSONObject();
      ((JSONObject)localObject).put("errCode", 0);
      ((JSONObject)localObject).put("type", paramInt);
      JSONArray localJSONArray = new JSONArray();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        if (!TextUtils.isEmpty(str)) {
          localJSONArray.put(str);
        }
      }
      ((JSONObject)localObject).put("uinList", localJSONArray);
      this.f.a("sc.script_user_dressOrStatus_changed.local", ((JSONObject)localObject).toString());
      return;
    }
    catch (Throwable paramArrayList)
    {
      QLog.e("[cmshow][scripted]SpriteActionScript", 1, "[notifyStatusOrDressChanged],", paramArrayList);
    }
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow][scripted]SpriteActionScript", 2, new Object[] { "[notifyScreenSizeChange] screenWidth:", Long.valueOf(paramLong1), ",screenHeight:", Long.valueOf(paramLong2), ",width:", Integer.valueOf(paramInt1), ",height:", Integer.valueOf(paramInt2) });
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("errCode", 0);
      if ((paramLong1 > 0L) && (paramLong2 > 0L))
      {
        localJSONObject.put("screenWidth", paramLong1);
        localJSONObject.put("screenHeight", paramLong2);
      }
      if ((paramInt1 > 0) && (paramInt2 > 0))
      {
        localJSONObject.put("width", paramInt1);
        localJSONObject.put("height", paramInt2);
      }
      this.f.a("sc.script_notify_screen_size_change.local", localJSONObject.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("[cmshow][scripted]SpriteActionScript", 1, "[notifyScreenSizeChange] ", localThrowable);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if ((this.f.c()) && (this.d)) {
      try
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[");
        int i = paramArrayOfInt.length;
        paramInt2 = 0;
        while (paramInt2 < i)
        {
          ((StringBuilder)localObject).append(Integer.valueOf(paramArrayOfInt[paramInt2]));
          ((StringBuilder)localObject).append(",");
          paramInt2 += 1;
        }
        ((StringBuilder)localObject).append("]");
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow][scripted]SpriteActionScript", 2, new Object[] { "[notifyDressReady], uin:", paramString, "dress:", localObject });
        }
        localObject = new JSONObject();
        ((JSONObject)localObject).put("uin", paramString);
        JSONArray localJSONArray = new JSONArray();
        i = paramArrayOfInt.length;
        paramInt2 = 0;
        while (paramInt2 < i)
        {
          localJSONArray.put(ApolloActionHelperImpl.getApolloRsc(1, Integer.valueOf(paramArrayOfInt[paramInt2]).intValue()));
          paramInt2 += 1;
        }
        ApolloActionHelperImpl.attach3DInfoToJson(paramString, paramQQAppInterface, (JSONObject)localObject, null);
        ((JSONObject)localObject).put("dress", localJSONArray);
        ((JSONObject)localObject).put("role", ApolloActionHelperImpl.getApolloRsc(0, paramInt1));
        paramQQAppInterface = this.f.v();
        if (paramQQAppInterface != null)
        {
          if (!this.f.l)
          {
            paramArrayOfInt = paramQQAppInterface.a(paramString, this.f, true);
            paramQQAppInterface = paramArrayOfInt;
            if (paramArrayOfInt == null) {
              paramQQAppInterface = new JSONObject();
            }
            ((JSONObject)localObject).put("pet", paramQQAppInterface);
            ((JSONObject)localObject).put("nameplate", SpriteRscBuilder.a(this.f.l(), paramString, paramInt1, true));
          }
          paramQQAppInterface = this.f.c;
          if ((!TextUtils.isEmpty(paramQQAppInterface)) && (paramQQAppInterface.equals(paramString))) {
            paramQQAppInterface = HardCodeUtil.a(2131911655);
          } else {
            paramQQAppInterface = SpriteUtil.a(this.f.l(), this.f.a, paramString, this.f.b, true);
          }
          if (!TextUtils.isEmpty(paramQQAppInterface)) {
            ((JSONObject)localObject).put("nickname", SpriteUtil.a(Base64Util.encodeToString(paramQQAppInterface.getBytes("utf-8"), 0)));
          }
        }
        paramQQAppInterface = new JSONArray();
        paramQQAppInterface.put(localObject);
        paramString = new JSONObject();
        paramString.put("errCode", 0);
        paramString.put("dressInfo", paramQQAppInterface);
        this.f.a("sc.script_notify_dress_ready.local", paramString.toString());
        return;
      }
      catch (Throwable paramQQAppInterface)
      {
        QLog.e("[cmshow][scripted]SpriteActionScript", 1, "[notifyDressReady],", paramQQAppInterface);
        return;
      }
    }
    QLog.w("[cmshow][scripted]SpriteActionScript", 1, "[notifyDressReady], surfaceView is destroyed. return");
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow][scripted]SpriteActionScript", 2, "[notifyRemoveBubble] ");
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("errCode", 0);
      b();
      if (!TextUtils.isEmpty(paramString))
      {
        localJSONObject.put("uin", paramString);
        this.f.a("sc.script_remove_bubble.local", localJSONObject.toString());
        return;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("[cmshow][scripted]SpriteActionScript", 1, "[notifyAddBubble] ", paramString);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    try
    {
      QLog.d("[cmshow][scripted]SpriteActionScript", 2, new Object[] { "[notifyPanelTabStatusChange], packageId:", paramString1 });
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("errCode", 0);
      localJSONObject.put("tabType", paramString1);
      localJSONObject.put("changeReason", paramString2);
      this.f.a("sc.script_panel_tab_status_change.local", localJSONObject.toString());
      return;
    }
    catch (Throwable paramString1)
    {
      QLog.e("[cmshow][scripted]SpriteActionScript", 1, "[notifyPanelTabStatusChange] exception:", paramString1);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow][scripted]SpriteActionScript", 2, new Object[] { "[notifyAddBubble],text:", paramString2 });
    }
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    String str = paramString1;
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString1))
        {
          str = paramString1;
          if (b() != null) {
            str = b().getCurrentAccountUin();
          }
        }
        paramString1 = new JSONObject();
        paramString1.put("errCode", 0);
        paramString1.put("model", ApolloActionHelperImpl.getModelByUin(str, b()));
        paramString1.put("text", paramString2);
        if (!TextUtils.isEmpty(str)) {
          paramString1.put("uin", str);
        }
        QQAppInterface localQQAppInterface = b();
        if (localQQAppInterface != null)
        {
          i = ((IApolloManagerService)localQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getCmShowStatus(str);
          paramString1.put("bubble", SpriteRscBuilder.a(paramString2, 0, paramInt, i));
          this.f.a("sc.script_add_bubble.local", paramString1.toString());
          return;
        }
      }
      catch (Throwable paramString1)
      {
        QLog.e("[cmshow][scripted]SpriteActionScript", 1, "[notifyAddBubble] ", paramString1);
        return;
      }
      int i = 0;
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow][scripted]SpriteActionScript", 2, new Object[] { "[notifyAddBubble],imagePath:", paramString2 });
    }
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("errCode", 0);
      localJSONObject.put("text", new String(SpriteUtil.a(Base64Util.encodeToString("a".getBytes("utf-8"), 0))));
      Object localObject = b();
      if (localObject != null)
      {
        localObject = (IApolloManagerService)((QQAppInterface)localObject).getRuntimeService(IApolloManagerService.class, "all");
        ((IApolloManagerService)localObject).getCmShowStatus(paramString1);
        ((IApolloManagerService)localObject).getApolloUserStatus();
      }
      localJSONObject.put("bubble", SpriteRscBuilder.a(0, paramInt1, 1));
      localJSONObject.put("bubbleImage", paramString2);
      localJSONObject.put("duration", paramInt2);
      this.f.a("sc.script_add_bubble.local", localJSONObject.toString());
      return;
    }
    catch (Throwable paramString1)
    {
      QLog.e("[cmshow][scripted]SpriteActionScript", 1, "[notifyAddBubble] ", paramString1);
    }
  }
  
  public void b(int paramInt)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow][scripted]SpriteActionScript", 2, new Object[] { "[notifySpriteVisibility], status:", Integer.valueOf(paramInt) });
      }
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("errCode", 0);
      localJSONObject.put("isShow", paramInt);
      this.f.a("sc.script_set_sprite_visibility.local", localJSONObject.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("[cmshow][scripted]SpriteActionScript", 1, "[notifySpriteVisibility],", localThrowable);
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow][scripted]SpriteActionScript", 2, new Object[] { "[notifyAddBubble],text:", paramString2 });
    }
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("errCode", 0);
        localJSONObject.put("text", new String(SpriteUtil.a(Base64Util.encodeToString(paramString2.getBytes("utf-8"), 0))));
        Object localObject = b();
        if (localObject != null)
        {
          localObject = (IApolloManagerService)((QQAppInterface)localObject).getRuntimeService(IApolloManagerService.class, "all");
          j = ((IApolloManagerService)localObject).getCmShowStatus(paramString1);
          i = ((IApolloManagerService)localObject).getApolloUserStatus();
          boolean bool = TextUtils.isEmpty(paramString1);
          if (!bool)
          {
            localJSONObject.put("uin", paramString1);
            paramString1 = ScriptUtils.a(paramString2, 0, j);
            if (TextUtils.isEmpty(paramString1))
            {
              QLog.e("[cmshow][scripted]SpriteActionScript", 1, "base role 0 is not exit, now check and download");
              paramString2 = j();
              if (paramString2 != null) {
                paramString2.a(b());
              } else {
                QLog.e("[cmshow][scripted]SpriteActionScript", 1, "base role 0 is not exit, now check and download failed. apolloResManager is null!");
              }
            }
            localJSONObject.put("bubble", paramString1);
          }
          else
          {
            localObject = ScriptUtils.a(paramString2, 0, 1);
            paramString2 = ScriptUtils.a(paramString2, 0, 2);
            if (i != 1) {
              break label313;
            }
            paramString1 = (String)localObject;
            localJSONObject.put("bubble2D", localObject);
            localJSONObject.put("bubble3D", paramString2);
            localJSONObject.put("bubble", paramString1);
          }
          this.f.a("sc.script_add_bubble.local", localJSONObject.toString());
          return;
        }
      }
      catch (Throwable paramString1)
      {
        QLog.e("[cmshow][scripted]SpriteActionScript", 1, "[notifyAddBubble] ", paramString1);
        return;
      }
      int i = 0;
      int j = 0;
      continue;
      label313:
      paramString1 = paramString2;
    }
  }
  
  public void c(int paramInt)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow][scripted]SpriteActionScript", 2, new Object[] { "[notifyUsrOperation], status:", Integer.valueOf(paramInt) });
      }
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("errCode", 0);
      localJSONObject.put("status", paramInt);
      this.f.a("sc.script_notify_user_operation.local", localJSONObject.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("[cmshow][scripted]SpriteActionScript", 1, "[notifyUsrOperation],", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteActionScript
 * JD-Core Version:    0.7.0.1
 */