package com.tencent.mobileqq.apollo.ipc.business;

import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.config.CmShowWnsUtils;
import com.tencent.mobileqq.apollo.meme.GetFrameCallback;
import com.tencent.mobileqq.apollo.meme.ICMSRecordCallback;
import com.tencent.mobileqq.apollo.meme.IMemePlayerListener;
import com.tencent.mobileqq.apollo.meme.MemeHelper;
import com.tencent.mobileqq.apollo.meme.action.MODE;
import com.tencent.mobileqq.apollo.meme.action.MemeAction;
import com.tencent.mobileqq.apollo.meme.action.MemeCommonAction;
import com.tencent.mobileqq.apollo.meme.action.MemePanelAction;
import com.tencent.mobileqq.apollo.meme.model.BusinessConfig;
import com.tencent.mobileqq.apollo.meme.model.BusinessConfig.FrameType;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.screenshot.api.IApolloAvatarVideoProcessor;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.api.IApolloAvatarFileManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class CmShowAvatarImpl
  implements ICmShowAvatar
{
  public static final float a = ;
  private HashMap<MemeAction, GetFrameCallback> b = new HashMap();
  private HashMap<MemeAction, IMemePlayerListener> c = new HashMap();
  
  private void a(ICmShowAvatar.IAvatarInterface paramIAvatarInterface, int paramInt1, int paramInt2, String paramString)
  {
    ((IApolloAvatarFileManager)QRoute.api(IApolloAvatarFileManager.class)).getSingleFrameFile(paramInt1, paramInt2, paramString, new CmShowAvatarImpl.3(this, paramInt2, paramIAvatarInterface));
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, ICMSRecordCallback paramICMSRecordCallback)
  {
    ApolloActionData localApolloActionData = new ApolloActionData();
    localApolloActionData.actionId = paramInt1;
    localApolloActionData.actionType = paramInt2;
    localApolloActionData.personNum = 0;
    localApolloActionData.actionName = "avatar";
    paramString = new MemePanelAction(localApolloActionData, paramString);
    paramString.j().a(ApolloConstant.l);
    paramString.j().a(BusinessConfig.FrameType.JPEG);
    paramICMSRecordCallback = new CmShowAvatarImpl.4(this, paramInt1, paramICMSRecordCallback);
    this.b.put(paramString, paramICMSRecordCallback);
    MemeHelper.a.a(paramString, a, paramICMSRecordCallback);
  }
  
  private void b(String paramString, int paramInt1, int paramInt2, ICMSRecordCallback paramICMSRecordCallback)
  {
    paramString = new MemeCommonAction(paramInt1, paramInt2, paramString, null, null);
    paramString.a(MODE.ACTION_MODE_RECORD_GIF);
    paramString.j().b(ApolloConstant.l);
    paramICMSRecordCallback = new CmShowAvatarImpl.5(this, paramInt1, paramICMSRecordCallback);
    this.c.put(paramString, paramICMSRecordCallback);
    MemeHelper.a.a(null, paramString, paramICMSRecordCallback);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, ICMSRecordCallback paramICMSRecordCallback)
  {
    if (paramInt3 == 1)
    {
      b(paramString, paramInt1, paramInt2, paramICMSRecordCallback);
      return;
    }
    if (paramInt3 == 0) {
      a(paramString, paramInt1, paramInt2, paramICMSRecordCallback);
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3, ICmShowAvatar.IAvatarInterface paramIAvatarInterface)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (!(localObject instanceof QQAppInterface))
    {
      QLog.i("[cmshow]CmShowAvatarImpl", 2, "onRemoteInvoke cannot get QQAppInterface");
      return;
    }
    localObject = (QQAppInterface)localObject;
    if (paramInt3 == 1)
    {
      IApolloAvatarVideoProcessor localIApolloAvatarVideoProcessor = (IApolloAvatarVideoProcessor)QRoute.api(IApolloAvatarVideoProcessor.class);
      localIApolloAvatarVideoProcessor.init((AppInterface)localObject);
      localIApolloAvatarVideoProcessor.setProcessFinishListener(new CmShowAvatarImpl.1(this, paramInt3, paramIAvatarInterface, paramInt2, paramString));
      localIApolloAvatarVideoProcessor.process(paramInt1, paramInt2);
      return;
    }
    if (paramInt3 == 0) {
      ((IApolloAvatarFileManager)QRoute.api(IApolloAvatarFileManager.class)).getSingleFrameFile(paramInt1, paramInt2, paramString, new CmShowAvatarImpl.2(this, (QQAppInterface)localObject, paramInt3, paramIAvatarInterface));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ipc.business.CmShowAvatarImpl
 * JD-Core Version:    0.7.0.1
 */