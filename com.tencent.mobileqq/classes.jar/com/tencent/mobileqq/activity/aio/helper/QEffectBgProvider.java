package com.tencent.mobileqq.activity.aio.helper;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.android.gldrawable.api.IGLDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.floatscr.IColorScreenManager;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.vas.api.IVasSingedApi;
import com.tencent.mobileqq.vas.theme.chatbg.ChatBackgroundDrawable;
import com.tencent.mobileqq.vas.theme.diy.ThemeBackground;
import com.tencent.mobileqq.vas.theme.diy.ThemeBackground.BusinessFlag;
import com.tencent.mobileqq.vas.theme.effect.QEffectApngImageView;
import com.tencent.mobileqq.vas.util.ChatBackgroundUtil;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qapmsdk.base.reporter.ab.AbProxy;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.effect.QEffectView;
import com.tencent.qqperf.abfactor.AbFactorAIODynamicBg;
import java.io.File;

public class QEffectBgProvider
  implements ILifeCycleHelper
{
  private QEffectView a;
  private BaseChatPie b;
  private long c = 0L;
  
  public QEffectBgProvider(BaseChatPie paramBaseChatPie)
  {
    this.b = paramBaseChatPie;
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = b(paramContext, paramString1, paramString2);
    if (!TextUtils.isEmpty(paramContext)) {
      return new File(paramContext).exists();
    }
    return false;
  }
  
  public static String b(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = ChatBackgroundUtil.a(paramContext, paramString1, paramString2);
    if (paramContext.contains("aioImage")) {
      return paramContext.replace("aioImage", "aio_bg.mp4");
    }
    return null;
  }
  
  public void a()
  {
    QEffectView localQEffectView = this.a;
    if (localQEffectView != null) {
      localQEffectView.pause();
    }
  }
  
  public void a(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if ((paramSessionInfo != null) && (paramSessionInfo.H != null))
    {
      String str1 = paramSessionInfo.b;
      if (this.a == null)
      {
        this.a = new QEffectView(paramContext);
        this.b.ba.addView(this.a, 0, new ViewGroup.LayoutParams(-1, -1));
      }
      if (paramSessionInfo.H.c != null)
      {
        if ((paramSessionInfo.H.c instanceof ChatBackgroundDrawable))
        {
          ThemeBackground.h.a();
          paramSessionInfo = "aio-bg-static";
          break label129;
        }
        if ((paramSessionInfo.H.c instanceof URLDrawable))
        {
          ThemeBackground.h.c();
          paramSessionInfo = "aio-bg-dynamic";
          break label129;
        }
      }
      else
      {
        ThemeBackground.h.a();
      }
      paramSessionInfo = "aio-bg-default";
      label129:
      this.a.setExtOptions(2, QEffectApngImageView.a(new int[] { 0 }, "-chatBg-"));
      String str2 = paramQQAppInterface.getCurrentUin();
      int i = ChatBackgroundManager.b(paramContext, str2, str1);
      if ((i > 0) && (ChatBackgroundManager.b()))
      {
        paramContext = new QEffectBgProvider.1(this, i);
        VasUtil.b(paramQQAppInterface).getColorScreen().a(i, paramContext);
        paramContext = new StringBuilder();
        paramContext.append(paramSessionInfo);
        paramContext.append("-effect");
        paramContext = paramContext.toString();
        ThemeBackground.h.b();
      }
      else if ((ChatBackgroundManager.a(paramContext, str2, str1)) && (ChatBackgroundManager.b()))
      {
        paramContext = ChatBackgroundUtil.a(paramContext, str2, str1);
        this.c = System.currentTimeMillis();
        this.a.setSrc(paramContext.replace("aioImage", ""), "zip");
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("set qeffect for custom background aioImageID:");
        paramQQAppInterface.append(ChatBackgroundUtil.b(paramContext));
        QLog.i("QEffectBgProvider", 1, paramQQAppInterface.toString());
        paramContext = new StringBuilder();
        paramContext.append(paramSessionInfo);
        paramContext.append("-3d");
        paramContext = paramContext.toString();
        ThemeBackground.h.e();
      }
      else if (a(paramContext, str2, str1))
      {
        paramQQAppInterface = ThemeBackground.a(b(paramContext, str2, str1), 2130839229);
        if ((paramQQAppInterface instanceof IGLDrawable)) {
          ((IGLDrawable)paramQQAppInterface).setLockWH(true);
        }
        paramContext = paramSessionInfo;
        if (paramQQAppInterface != null)
        {
          this.b.ba.setBackgroundDrawable(paramQQAppInterface);
          paramContext = new StringBuilder();
          paramContext.append(paramSessionInfo);
          paramContext.append("-video");
          paramContext = paramContext.toString();
          ThemeBackground.h.d();
        }
      }
      else
      {
        this.a.clear();
        paramContext = paramSessionInfo;
      }
      AbProxy.setAbFactor("AIO背景", paramContext, AbFactorAIODynamicBg.class);
      return;
    }
    paramContext = this.a;
    if (paramContext != null) {
      paramContext.clear();
    }
  }
  
  public void b()
  {
    QEffectView localQEffectView = this.a;
    if (localQEffectView != null) {
      localQEffectView.resume();
    }
  }
  
  public String getTag()
  {
    return "QEffectBgProvider";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 15, 16, 17, 18 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 4) {
      if (paramInt != 18)
      {
        if (paramInt != 15)
        {
          if (paramInt != 16) {
            return;
          }
          a();
          return;
        }
        if (this.a != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("destroy qeffect, duration:");
          long l = this.c;
          if (l != 0L) {
            l = System.currentTimeMillis() - this.c;
          }
          localStringBuilder.append(l);
          QLog.i("QEffectBgProvider", 1, localStringBuilder.toString());
          if (this.a.getQEffectImpl() != null) {
            ((View)this.a.getQEffectImpl()).destroyDrawingCache();
          }
          this.a.clear();
        }
      }
      else
      {
        b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QEffectBgProvider
 * JD-Core Version:    0.7.0.1
 */