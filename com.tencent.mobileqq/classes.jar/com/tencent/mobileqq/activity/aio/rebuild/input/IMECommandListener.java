package com.tencent.mobileqq.activity.aio.rebuild.input;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseAIOContext;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.coreui.input.EditTextUI;
import com.tencent.mobileqq.activity.aio.coreui.input.InputUIContainer;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticon.ISogouEmoji;
import com.tencent.mobileqq.emoticon.api.ISogouEmojiService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XEditTextEx.OnPrivateIMECommandListener;
import mqq.os.MqqHandler;

public class IMECommandListener
  implements XEditTextEx.OnPrivateIMECommandListener
{
  private AIOContext a;
  private ISogouEmoji b;
  
  public IMECommandListener(AIOContext paramAIOContext)
  {
    this.a = paramAIOContext;
  }
  
  private void a(Bundle paramBundle)
  {
    int i = paramBundle.getInt("PACKAGE_ID");
    String str = paramBundle.getString("EXP_ID");
    paramBundle = paramBundle.getString("EXP_PATH");
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPrivateIMECommand(), packId:");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(",exprId:");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(",ePath:");
      ((StringBuilder)localObject).append(paramBundle);
      QLog.d("IMECommandListener", 2, ((StringBuilder)localObject).toString());
    }
    if (this.b == null)
    {
      paramBundle = (ISogouEmojiService)QRoute.api(ISogouEmojiService.class);
      localObject = this.a;
      this.b = paramBundle.createSogouEmoji((BaseAIOContext)localObject, ((AIOContext)localObject).b(), this.a.a());
    }
    this.b.trySend(i, str);
  }
  
  private void a(String paramString, Bundle paramBundle, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    int i;
    if ("com.sogou.inputmethod.expression".equals(paramString))
    {
      paramString = paramBundle.getString("SOGOU_EXP_PATH");
      i = 1034;
    }
    else
    {
      paramString = paramBundle.getString("QQINPUT_EXP_PATH");
      i = 1038;
    }
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onPrivateIMECommand(), path:");
      paramBundle.append(paramString);
      paramBundle.append(", busiType = ");
      paramBundle.append(i);
      QLog.d("IMECommandListener", 2, paramBundle.toString());
    }
    if (!TextUtils.isEmpty(paramString)) {
      ChatActivityFacade.a(paramQQAppInterface, paramContext, this.a.O(), paramString, i);
    }
  }
  
  private boolean a(Bundle paramBundle, QQAppInterface paramQQAppInterface, Context paramContext, View paramView)
  {
    String str = paramBundle.getString("PCMFilePath");
    int i = paramBundle.getInt("SampleRate");
    int j = paramBundle.getInt("Channels");
    RecordParams.RecorderParam localRecorderParam = (RecordParams.RecorderParam)this.a.p().d().f().i();
    paramBundle = paramBundle.getString("InputMethodName");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("recv args from sogou, pcmPath = ");
      localStringBuilder.append(str);
      localStringBuilder.append(" sampleRate = ");
      localStringBuilder.append(i);
      localStringBuilder.append(" channels = ");
      localStringBuilder.append(j);
      localStringBuilder.append(" inputName = ");
      localStringBuilder.append(paramBundle);
      localStringBuilder.append(" my sampleRate = ");
      localStringBuilder.append(localRecorderParam.a);
      QLog.d("sougouptt", 2, localStringBuilder.toString());
    }
    if ((i == localRecorderParam.a) && (!StringUtil.isEmpty(str)))
    {
      ThreadManager.getSubThreadHandler().post(new IMECommandListener.1(this, paramQQAppInterface, str, i, paramBundle, paramContext, paramView));
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("sougouptt", 2, "invalid datas from sougou ");
    }
    return true;
  }
  
  private void b(Bundle paramBundle, QQAppInterface paramQQAppInterface, Context paramContext, View paramView)
  {
    Object localObject = paramBundle.getString("SOGOU_APP_ID");
    String str2 = paramQQAppInterface.getCurrentAccountUin();
    String str1 = AuthorityUtil.b(paramQQAppInterface.getApp(), str2, (String)localObject);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPrivateIMECommand(), appId:");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("selfUin:");
      localStringBuilder.append(str2);
      localStringBuilder.append("openId:");
      localStringBuilder.append(str1);
      QLog.d("IMECommandListener", 2, localStringBuilder.toString());
    }
    paramContext = (InputMethodManager)paramContext.getSystemService("input_method");
    if (paramContext != null)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("SOGOU_OPENID", str1);
      paramContext.sendAppPrivateCommand(paramView, "com.tencent.mobileqq.sogou.openid", (Bundle)localObject);
    }
    paramBundle = paramBundle.getStringArrayList("EXP_ALL_PACKID");
    if (this.b == null)
    {
      paramContext = (ISogouEmojiService)QRoute.api(ISogouEmojiService.class);
      paramView = this.a;
      this.b = paramContext.createSogouEmoji(paramView, paramView.b(), paramQQAppInterface);
    }
    this.b.pullMultipleEmojiKey(paramBundle);
  }
  
  public void a()
  {
    ISogouEmoji localISogouEmoji = this.b;
    if (localISogouEmoji != null) {
      localISogouEmoji.onDestroy();
    }
  }
  
  public boolean a(String paramString, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPrivateIMECommand(), action:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("IMECommandListener", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.a.a();
    BaseActivity localBaseActivity = this.a.b();
    XEditTextEx localXEditTextEx = this.a.p().d().f().b();
    if ((!TextUtils.isEmpty(paramString)) && (paramBundle != null) && (InputMethodUtil.a(localBaseActivity))) {
      if ((!"com.sogou.inputmethod.expression".equals(paramString)) && (!"com.tencent.qqpinyin.expression".equals(paramString)))
      {
        if ("com.sogou.inputmethod.appid".equals(paramString))
        {
          b(paramBundle, (QQAppInterface)localObject, localBaseActivity, localXEditTextEx);
          return true;
        }
        if ((!"com.sogou.inputmethod.qqexp".equals(paramString)) && (!"com.tencent.qqpinyin.qqexp".equals(paramString)))
        {
          if (("com.tencent.mobileqq_audioArgs".equals(paramString)) && (a(paramBundle, (QQAppInterface)localObject, localBaseActivity, localXEditTextEx))) {
            return true;
          }
        }
        else
        {
          a(paramBundle);
          return true;
        }
      }
      else
      {
        a(paramString, paramBundle, (QQAppInterface)localObject, localBaseActivity);
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.IMECommandListener
 * JD-Core Version:    0.7.0.1
 */