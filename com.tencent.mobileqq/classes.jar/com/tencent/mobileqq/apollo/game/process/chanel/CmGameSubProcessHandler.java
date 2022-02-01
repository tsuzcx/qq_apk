package com.tencent.mobileqq.apollo.game.process.chanel;

import android.app.Activity;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.channel.HandleResult;
import com.tencent.mobileqq.apollo.channel.IRequestHandler;
import com.tencent.mobileqq.apollo.game.process.CmGameUtil;
import com.tencent.mobileqq.apollo.game.process.data.CmGameLauncher;
import com.tencent.mobileqq.apollo.game.process.data.CmGameManager;
import com.tencent.mobileqq.apollo.game.process.download.CmGameSubRscHandler;
import com.tencent.mobileqq.apollo.game.process.sso.CmGameSSoHandler;
import com.tencent.mobileqq.apollo.game.utils.ApolloGameBasicEventUtil;
import com.tencent.mobileqq.apollo.model.StartCheckParam;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloCmdChannel;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRender;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ChannelConst;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class CmGameSubProcessHandler
  implements IRequestHandler
{
  private int a;
  private WeakReference<Activity> b;
  private Pattern c;
  private HashMap<String, Bitmap> d = new HashMap();
  
  public CmGameSubProcessHandler(int paramInt, Activity paramActivity)
  {
    this.a = paramInt;
    this.b = new WeakReference(paramActivity);
  }
  
  private void a(long paramLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameSubProcessHandler", 2, new Object[] { "[handleReportEvent] reqData=", paramString });
    }
    int i = -1;
    try
    {
      Object localObject;
      int j;
      int k;
      if (!TextUtils.isEmpty(paramString))
      {
        localObject = new JSONObject(paramString);
        if ((((JSONObject)localObject).has("mid")) && (((JSONObject)localObject).has("value")))
        {
          i = ((JSONObject)localObject).optInt("mid");
          j = ((JSONObject)localObject).optInt("value");
          k = ((JSONObject)localObject).optInt("failCode", 0);
          paramString = ((JSONObject)localObject).optJSONObject("extInfo");
          localObject = CmGameUtil.b();
        }
      }
      label159:
      try
      {
        CmGameUtil.a((AppInterface)localObject, i, j, this.a, k, paramString);
        i = 0;
        break label159;
        QLog.e("cmgame_process.CmGameSubProcessHandler", 1, new Object[] { "[handleReportEvent] reqData invalid, reqData=", paramString });
        break label159;
        QLog.e("cmgame_process.CmGameSubProcessHandler", 1, "[handleReportEvent] reqData null");
      }
      catch (Exception paramString) {}
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, "[handleReportEvent] e=", paramString);
    }
    catch (Exception paramString) {}
    i = -1;
    ApolloCmdChannel.getInstance().callbackFromRequest(paramLong, i, "cs.report_event.local", "{}");
  }
  
  private boolean a(String paramString1, String paramString2, long paramLong)
  {
    if ((!paramString1.startsWith("cs.")) && (!paramString1.endsWith(".local")) && (!ChannelConst.a(paramString1)) && (c(paramString1)))
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("ssoCmdRule, [game],cmd:");
        ((StringBuilder)localObject).append(paramString1);
        QLog.d("cmgame_process.CmGameSubProcessHandler", 2, ((StringBuilder)localObject).toString());
      }
      try
      {
        paramString2 = new JSONObject(paramString2);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("cmshow_game_");
        try
        {
          ((StringBuilder)localObject).append(this.a);
          paramString2.put("from", ((StringBuilder)localObject).toString());
          paramString2 = paramString2.toString();
          localObject = CmGameUtil.d();
          if (localObject == null) {
            break label167;
          }
          ((CmGameSSoHandler)localObject).a(paramString1, paramString2, paramLong, 4, false, null);
          return true;
        }
        catch (Throwable paramString1) {}
        QLog.e("cmgame_process.CmGameSubProcessHandler", 1, "errInfo->", paramString1);
      }
      catch (Throwable paramString1) {}
      label167:
      return true;
    }
    return false;
  }
  
  private void b(long paramLong, String paramString)
  {
    Object localObject = CmGameUtil.a(this.a);
    if (localObject == null)
    {
      paramString = new StringBuilder();
      paramString.append("[checkFileCorrectness], launcher is null, mGameId:");
      paramString.append(this.a);
      QLog.w("cmgame_process.CmGameSubProcessHandler", 1, paramString.toString());
      return;
    }
    localObject = ((CmGameLauncher)localObject).a();
    if (localObject == null) {
      return;
    }
    ((CmGameSubRscHandler)localObject).b(paramLong, paramString);
  }
  
  private void b(String paramString)
  {
    AppInterface localAppInterface = CmGameUtil.b();
    if (localAppInterface != null) {
      ApolloGameBasicEventUtil.a(localAppInterface, paramString);
    }
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameSubProcessHandler", 2, "[onFirstFrameDrawn]");
    }
    Object localObject = CmGameUtil.a(this.a);
    if (localObject == null) {
      return;
    }
    localObject = ((CmGameLauncher)localObject).c();
    if (localObject != null)
    {
      long l2 = ((StartCheckParam)localObject).startT;
      if (l2 > 0L)
      {
        long l1 = System.currentTimeMillis();
        l2 = l1 - l2;
        l1 -= ((StartCheckParam)localObject).startCallEngine;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("startApolloGame initGameCost: ");
        localStringBuilder.append(l1);
        localStringBuilder.append(", totalCost:");
        localStringBuilder.append(l2);
        QLog.i("cmgame_process.CmGameSubProcessHandler", 1, localStringBuilder.toString());
        if (l2 > 20000L)
        {
          QLog.w("cmgame_process.CmGameSubProcessHandler", 1, "sth must be wrong because it's too long.");
          return;
        }
        int i = this.a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(l1);
        localStringBuilder.append("");
        VipUtils.a(null, "cmshow", "Apollo", "start_game_time_cost", 0, 0, new String[] { String.valueOf(i), String.valueOf(l2), localStringBuilder.toString() });
        ((StartCheckParam)localObject).startT = -1L;
      }
    }
  }
  
  private void c(long paramLong, String paramString)
  {
    Object localObject = CmGameUtil.a(this.a);
    if (localObject == null)
    {
      paramString = new StringBuilder();
      paramString.append("[handleLoadSubpack], launcher is null, mGameId:");
      paramString.append(this.a);
      QLog.w("cmgame_process.CmGameSubProcessHandler", 1, paramString.toString());
      return;
    }
    localObject = ((CmGameLauncher)localObject).a();
    if (localObject == null) {
      return;
    }
    ((CmGameSubRscHandler)localObject).a(paramLong, paramString);
  }
  
  private boolean c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (this.c == null)
    {
      localObject = CmGameUtil.c();
      if (localObject != null)
      {
        localObject = ((CmGameManager)localObject).b(this.a);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("isValidSsoCmd cmd:");
          localStringBuilder.append(paramString);
          localStringBuilder.append(", rule: ");
          localStringBuilder.append((String)localObject);
          QLog.w("cmgame_process.CmGameSubProcessHandler", 1, localStringBuilder.toString());
        }
        this.c = Pattern.compile((String)localObject);
      }
    }
    Object localObject = this.c;
    if (localObject == null) {
      return false;
    }
    boolean bool = ((Pattern)localObject).matcher(paramString).matches();
    if (!bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ssoCmdRule,fail to match sso cmd, cmd:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", gameId: ");
      ((StringBuilder)localObject).append(this.a);
      QLog.w("cmgame_process.CmGameSubProcessHandler", 1, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  private void d()
  {
    Activity localActivity = b();
    if (localActivity != null) {
      localActivity.finish();
    }
  }
  
  private void d(long paramLong, String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).optJSONArray("pattern");
      int j = ((JSONObject)localObject).getInt("repeate");
      localObject = new long[paramString.length()];
      int i = 0;
      while (i < paramString.length())
      {
        localObject[i] = paramString.getLong(i);
        i += 1;
      }
      ApolloRender.vibrate(this.a, paramLong, (long[])localObject, j);
      return;
    }
    catch (Exception paramString)
    {
      ApolloCmdChannel.getInstance().callbackFromRequest(paramLong, 6, "cs.xy_device_vibrate.local", "{}");
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, paramString, new Object[0]);
    }
  }
  
  private void e()
  {
    try
    {
      ApolloRender.cancelVibrate(this.a);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, localException, new Object[0]);
    }
  }
  
  public int a()
  {
    return 0;
  }
  
  public HandleResult a(long paramLong, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameSubProcessHandler", 2, new Object[] { "[handleCmd], cmd:", paramString1 });
    }
    CmGameLauncher localCmGameLauncher = CmGameUtil.a(this.a);
    if (localCmGameLauncher == null) {
      return null;
    }
    if (!localCmGameLauncher.m())
    {
      if (paramLong != localCmGameLauncher.g()) {
        return null;
      }
    }
    else
    {
      if (localCmGameLauncher.e() == null) {
        return null;
      }
      if (localCmGameLauncher.e().getLuaState() != paramLong)
      {
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.CmGameSubProcessHandler", 2, "abandon it, not the same jsState.");
        }
        return null;
      }
    }
    if (a(paramString1, paramString2, paramLong)) {
      return new HandleResult();
    }
    if ("cs.close_room.local".equals(paramString1))
    {
      d();
      return null;
    }
    if ("cs.report_data_2_compass.local".equals(paramString1))
    {
      b(paramString2);
      return null;
    }
    if ("cs.first_frame_drawn.local".equals(paramString1))
    {
      c();
      return null;
    }
    if ("cs.apolloGameWebMessage.local".equals(paramString1))
    {
      ApolloGameBasicEventUtil.a(paramString2);
      return null;
    }
    if ("cs.closeWebview.local".equals(paramString1))
    {
      a(paramString2);
      return null;
    }
    if ("cs.load_subpackage.local".equals(paramString1))
    {
      c(paramLong, paramString2);
      return null;
    }
    if ("cs.file_correctness_check.local".equals(paramString1))
    {
      b(paramLong, paramString2);
      return null;
    }
    if ("cs.xy_device_vibrate.local".equals(paramString1))
    {
      d(paramLong, paramString2);
      return null;
    }
    if ("cs.xy_device_vibrate_cancel.local".equals(paramString1))
    {
      e();
      return null;
    }
    if ("cs.report_event.local".equals(paramString1)) {
      a(paramLong, paramString2);
    }
    return null;
  }
  
  public void a(String paramString)
  {
    try
    {
      int i = new JSONObject(paramString).optInt("taskId");
      paramString = CmGameUtil.a(this.a);
      if (paramString != null)
      {
        paramString.a(i);
        return;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, paramString, new Object[0]);
    }
  }
  
  public Activity b()
  {
    WeakReference localWeakReference = this.b;
    if (localWeakReference != null) {
      return (Activity)localWeakReference.get();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.chanel.CmGameSubProcessHandler
 * JD-Core Version:    0.7.0.1
 */