package com.tencent.mobileqq.apollo.script;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.game.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil;
import com.tencent.mobileqq.apollo.statistics.product.DtReportParamsBuilder;
import com.tencent.mobileqq.apollo.utils.ApolloPanelUtil;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloActionHelperImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.cmshow.brickengine.BKScriptUtils;
import com.tencent.mobileqq.cmshow.engine.ICMShowEngine;
import com.tencent.mobileqq.cmshow.engine.render.ICMShowView;
import com.tencent.mobileqq.cmshow.engine.render.IRenderService;
import com.tencent.mobileqq.cmshow.engine.script.IScriptService;
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
    if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext == null)
    {
      QLog.w("[cmshow][scripted]SpriteActionScript", 1, "init error, mSpriteContext null");
      return;
    }
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a();
    if (localQQAppInterface == null)
    {
      QLog.w("[cmshow][scripted]SpriteActionScript", 1, "init error, appInterface null");
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a();
    if (localObject == null)
    {
      QLog.w("[cmshow][scripted]SpriteActionScript", 1, "init error, scriptService null");
      return;
    }
    try
    {
      localObject = (CommonInitTask)((IScriptService)localObject).a().a(ScriptTaskType.COMMON_INIT);
      ((CommonInitTask)localObject).a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_b_of_type_Boolean).a(ApolloGameUtil.a(localQQAppInterface, paramInt4, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_JavaLangString)).a(paramString).b(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_b_of_type_JavaLangString).a(paramBoolean);
      ((CommonInitTask)localObject).a(paramInt1).b(paramInt2).c(paramInt3).b(paramInt5);
      paramString = ((CommonInitTask)localObject).a();
      if (!TextUtils.isEmpty(paramString)) {
        this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(paramString);
      } else {
        QLog.e("[cmshow][scripted]SpriteActionScript", 1, "commonInitScript is null");
      }
      if (QLog.isColorLevel())
      {
        QLog.d("[cmshow][scripted]SpriteActionScript", 2, paramString);
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
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a() != null))
    {
      ICMShowView localICMShowView = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().a().a();
      int i = localICMShowView.getRenderWidth();
      int j = localICMShowView.getRenderHeight();
      a(i, localICMShowView.getInitHeight(), j, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.d, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.c);
      return;
    }
    QLog.e("[cmshow][scripted]SpriteActionScript", 1, "onLoadFinish mSpriteContext null error");
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.d != 0) {
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
      this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a("sc.script_panel_status_change.local", ((JSONObject)localObject).toString());
      if (1 != paramInt) {
        break label258;
      }
      localObject = "panel_close_clk";
    }
    catch (Throwable localThrowable)
    {
      Object localObject;
      QLog.e("[cmshow][scripted]SpriteActionScript", 1, "[notifyPanelStatusChanged],", localThrowable);
      return;
    }
    VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(), "cmshow", "Apollo", (String)localObject, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_Int), ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportUserResult(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_b_of_type_Int), new String[] { "", "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
    if (paramInt == 2) {
      localObject = "click";
    }
    for (;;)
    {
      ApolloDtReportUtil.a("aio", "sprite", (String)localObject, new DtReportParamsBuilder().a(ApolloDtReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a())).b(ApolloDtReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_Int)).b(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_JavaLangString).a());
      return;
      for (;;)
      {
        break;
        label258:
        if (2 != paramInt) {
          break label270;
        }
        str = "panel_open_clk";
      }
      label270:
      String str = "";
      break;
      str = "close";
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
      this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a("sc.script_draw_area_change.local", localJSONObject.toString());
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
      this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a("sc.script_on_sprite_single_clicked.local", ((JSONObject)localObject).toString());
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
      this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a("sc.script_user_dressOrStatus_changed.local", ((JSONObject)localObject).toString());
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
      this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a("sc.script_notify_screen_size_change.local", localJSONObject.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("[cmshow][scripted]SpriteActionScript", 1, "[notifyScreenSizeChange] ", localThrowable);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.c()) && (this.jdField_a_of_type_Boolean)) {
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
        paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a();
        if (paramQQAppInterface != null)
        {
          if (!this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.c)
          {
            paramArrayOfInt = paramQQAppInterface.a(paramString, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext, true);
            paramQQAppInterface = paramArrayOfInt;
            if (paramArrayOfInt == null) {
              paramQQAppInterface = new JSONObject();
            }
            ((JSONObject)localObject).put("pet", paramQQAppInterface);
            ((JSONObject)localObject).put("nameplate", SpriteRscBuilder.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(), paramString, paramInt1, true));
          }
          paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_b_of_type_JavaLangString;
          if ((!TextUtils.isEmpty(paramQQAppInterface)) && (paramQQAppInterface.equals(paramString))) {
            paramQQAppInterface = HardCodeUtil.a(2131714125);
          } else {
            paramQQAppInterface = SpriteUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(), this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_Int, paramString, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_JavaLangString, true);
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
        this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a("sc.script_notify_dress_ready.local", paramString.toString());
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
  
  public void a(String paramString1, String paramString2)
  {
    try
    {
      QLog.d("[cmshow][scripted]SpriteActionScript", 2, new Object[] { "[notifyPanelTabStatusChange], packageId:", paramString1 });
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("errCode", 0);
      localJSONObject.put("tabType", paramString1);
      localJSONObject.put("changeReason", paramString2);
      this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a("sc.script_panel_tab_status_change.local", localJSONObject.toString());
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
          if (a() != null) {
            str = a().getCurrentAccountUin();
          }
        }
        paramString1 = new JSONObject();
        paramString1.put("errCode", 0);
        paramString1.put("model", ApolloActionHelperImpl.getModelByUin(str, a()));
        paramString1.put("text", paramString2);
        if (!TextUtils.isEmpty(str)) {
          paramString1.put("uin", str);
        }
        QQAppInterface localQQAppInterface = a();
        if (localQQAppInterface != null)
        {
          i = ((IApolloManagerService)localQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getCmShowStatus(str);
          paramString1.put("bubble", SpriteRscBuilder.a(paramString2, 0, paramInt, i));
          this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a("sc.script_add_bubble.local", paramString1.toString());
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
      this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a("sc.script_set_sprite_visibility.local", localJSONObject.toString());
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
        Object localObject = a();
        if (localObject != null)
        {
          localObject = (IApolloManagerService)((QQAppInterface)localObject).getRuntimeService(IApolloManagerService.class, "all");
          j = ((IApolloManagerService)localObject).getCmShowStatus(paramString1);
          i = ((IApolloManagerService)localObject).getApolloUserStatus();
          boolean bool = TextUtils.isEmpty(paramString1);
          if (!bool)
          {
            localJSONObject.put("uin", paramString1);
            paramString1 = BKScriptUtils.a(paramString2, 0, j);
            if (TextUtils.isEmpty(paramString1))
            {
              QLog.e("[cmshow][scripted]SpriteActionScript", 1, "base role 0 is not exit, now check and download");
              ApolloActionHelperImpl.checkBasicActionExit(a());
            }
            localJSONObject.put("bubble", paramString1);
          }
          else
          {
            localObject = BKScriptUtils.a(paramString2, 0, 1);
            paramString2 = BKScriptUtils.a(paramString2, 0, 2);
            if (i != 1) {
              break label289;
            }
            paramString1 = (String)localObject;
            localJSONObject.put("bubble2D", localObject);
            localJSONObject.put("bubble3D", paramString2);
            localJSONObject.put("bubble", paramString1);
          }
          this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a("sc.script_add_bubble.local", localJSONObject.toString());
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
      label289:
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
      this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a("sc.script_notify_user_operation.local", localJSONObject.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("[cmshow][scripted]SpriteActionScript", 1, "[notifyUsrOperation],", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteActionScript
 * JD-Core Version:    0.7.0.1
 */