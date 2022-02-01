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
  private long jdField_a_of_type_Long = 0L;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private QEffectView jdField_a_of_type_ComTencentQqEffectQEffectView;
  
  public QEffectBgProvider(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = ChatBackgroundUtil.a(paramContext, paramString1, paramString2);
    if (paramContext.contains("aioImage")) {
      return paramContext.replace("aioImage", "aio_bg.mp4");
    }
    return null;
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = a(paramContext, paramString1, paramString2);
    if (!TextUtils.isEmpty(paramContext)) {
      return new File(paramContext).exists();
    }
    return false;
  }
  
  public void a()
  {
    QEffectView localQEffectView = this.jdField_a_of_type_ComTencentQqEffectQEffectView;
    if (localQEffectView != null) {
      localQEffectView.pause();
    }
  }
  
  public void a(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if ((paramSessionInfo != null) && (paramSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground != null))
    {
      String str1 = paramSessionInfo.jdField_a_of_type_JavaLangString;
      if (this.jdField_a_of_type_ComTencentQqEffectQEffectView == null)
      {
        this.jdField_a_of_type_ComTencentQqEffectQEffectView = new QEffectView(paramContext);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.d.addView(this.jdField_a_of_type_ComTencentQqEffectQEffectView, 0, new ViewGroup.LayoutParams(-1, -1));
      }
      if (paramSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.a != null)
      {
        if ((paramSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.a instanceof ChatBackgroundDrawable))
        {
          ThemeBackground.a.a();
          paramSessionInfo = "aio-bg-static";
          break label129;
        }
        if ((paramSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.a instanceof URLDrawable))
        {
          ThemeBackground.a.c();
          paramSessionInfo = "aio-bg-dynamic";
          break label129;
        }
      }
      else
      {
        ThemeBackground.a.a();
      }
      paramSessionInfo = "aio-bg-default";
      label129:
      this.jdField_a_of_type_ComTencentQqEffectQEffectView.setExtOptions(2, QEffectApngImageView.a(new int[] { 0 }, "-chatBg-"));
      String str2 = paramQQAppInterface.getCurrentUin();
      int i = ChatBackgroundManager.a(paramContext, str2, str1);
      if ((i > 0) && (ChatBackgroundManager.a()))
      {
        paramContext = new QEffectBgProvider.1(this, i);
        VasUtil.a(paramQQAppInterface).getColorScreen().a(i, paramContext);
        paramContext = new StringBuilder();
        paramContext.append(paramSessionInfo);
        paramContext.append("-effect");
        paramContext = paramContext.toString();
        ThemeBackground.a.b();
      }
      else if ((ChatBackgroundManager.a(paramContext, str2, str1)) && (ChatBackgroundManager.a()))
      {
        paramContext = ChatBackgroundUtil.a(paramContext, str2, str1);
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        this.jdField_a_of_type_ComTencentQqEffectQEffectView.setSrc(paramContext.replace("aioImage", ""), "zip");
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("set qeffect for custom background aioImageID:");
        paramQQAppInterface.append(ChatBackgroundUtil.b(paramContext));
        QLog.i("QEffectBgProvider", 1, paramQQAppInterface.toString());
        paramContext = new StringBuilder();
        paramContext.append(paramSessionInfo);
        paramContext.append("-3d");
        paramContext = paramContext.toString();
        ThemeBackground.a.e();
      }
      else if (a(paramContext, str2, str1))
      {
        paramQQAppInterface = ThemeBackground.a(a(paramContext, str2, str1), 2130839075);
        if ((paramQQAppInterface instanceof IGLDrawable)) {
          ((IGLDrawable)paramQQAppInterface).setLockWH(true);
        }
        paramContext = paramSessionInfo;
        if (paramQQAppInterface != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.d.setBackgroundDrawable(paramQQAppInterface);
          paramContext = new StringBuilder();
          paramContext.append(paramSessionInfo);
          paramContext.append("-video");
          paramContext = paramContext.toString();
          ThemeBackground.a.d();
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentQqEffectQEffectView.clear();
        paramContext = paramSessionInfo;
      }
      AbProxy.setAbFactor("AIO背景", paramContext, AbFactorAIODynamicBg.class);
      return;
    }
    paramContext = this.jdField_a_of_type_ComTencentQqEffectQEffectView;
    if (paramContext != null) {
      paramContext.clear();
    }
  }
  
  public void b()
  {
    QEffectView localQEffectView = this.jdField_a_of_type_ComTencentQqEffectQEffectView;
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
        if (this.jdField_a_of_type_ComTencentQqEffectQEffectView != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("destroy qeffect, duration:");
          long l = this.jdField_a_of_type_Long;
          if (l != 0L) {
            l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
          }
          localStringBuilder.append(l);
          QLog.i("QEffectBgProvider", 1, localStringBuilder.toString());
          if (this.jdField_a_of_type_ComTencentQqEffectQEffectView.getQEffectImpl() != null) {
            ((View)this.jdField_a_of_type_ComTencentQqEffectQEffectView.getQEffectImpl()).destroyDrawingCache();
          }
          this.jdField_a_of_type_ComTencentQqEffectQEffectView.clear();
        }
      }
      else
      {
        b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QEffectBgProvider
 * JD-Core Version:    0.7.0.1
 */