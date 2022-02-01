package com.tencent.mobileqq.apollo.aio.item.api.impl;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseAIOContext;
import com.tencent.mobileqq.apollo.aio.item.api.IApolloIceBreakShow;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.meme.ApolloPlayerParams;
import com.tencent.mobileqq.apollo.meme.action.MemeAction;
import com.tencent.mobileqq.apollo.meme.action.MemeCommonAction;
import com.tencent.mobileqq.apollo.meme.api.IApolloBrickPlayer;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.statistics.product.DtReportParamsBuilder;
import com.tencent.mobileqq.apollo.statistics.product.api.IApolloDtReportHelper;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/aio/item/api/impl/ApolloIceBreakShowImpl;", "Lcom/tencent/mobileqq/apollo/aio/item/api/IApolloIceBreakShow;", "()V", "mApp", "Lcom/tencent/common/app/AppInterface;", "mBrickPlayer", "Lcom/tencent/mobileqq/apollo/meme/api/IApolloBrickPlayer;", "mCMSAction", "Lcom/tencent/mobileqq/apollo/meme/action/MemeAction;", "mContext", "Landroid/content/Context;", "mHeight", "", "Ljava/lang/Integer;", "mIsPlaying", "", "mSessionInfo", "Lcom/tencent/mobileqq/activity/aio/BaseSessionInfo;", "mType", "mWidth", "name", "", "apolloDtReport", "", "mode", "actionId", "event", "getView", "Landroid/view/View;", "init", "context", "width", "height", "app", "isPlaying", "isReady", "onSend", "baseAIOContext", "Lcom/tencent/mobileqq/activity/aio/core/BaseAIOContext;", "pause", "play", "resume", "setJson", "jsonObject", "Lorg/json/JSONObject;", "sessionInfo", "stop", "Companion", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class ApolloIceBreakShowImpl
  implements IApolloIceBreakShow
{
  public static final ApolloIceBreakShowImpl.Companion Companion = new ApolloIceBreakShowImpl.Companion(null);
  private static final String KEY_ACTION_ID = "actionId";
  private static final String KEY_ACTION_TYPE = "actionType";
  private static final String KEY_EXT_JSON = "extJson";
  private static final String KEY_ID = "id";
  private static final String KEY_NAME = "name";
  private static final String KEY_TYPE = "type";
  private static final String TAG = "[cmshow]ApolloIceBreakShow";
  private AppInterface mApp;
  private IApolloBrickPlayer mBrickPlayer;
  private MemeAction mCMSAction;
  private Context mContext;
  private Integer mHeight;
  private boolean mIsPlaying;
  private BaseSessionInfo mSessionInfo;
  private int mType;
  private Integer mWidth;
  private String name;
  
  static
  {
    KEY_ACTION_ID = "actionId";
    KEY_ID = "id";
    KEY_ACTION_TYPE = "actionType";
    KEY_EXT_JSON = "extJson";
    KEY_TYPE = "type";
  }
  
  public ApolloIceBreakShowImpl()
  {
    Integer localInteger = Integer.valueOf(0);
    this.mWidth = localInteger;
    this.mHeight = localInteger;
    this.name = "";
  }
  
  private final void apolloDtReport(int paramInt1, int paramInt2, String paramString)
  {
    Object localObject = QRoute.api(IApolloDtReportHelper.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "QRoute.api(IApolloDtReportHelper::class.java)");
    localObject = (IApolloDtReportHelper)localObject;
    DtReportParamsBuilder localDtReportParamsBuilder = new DtReportParamsBuilder().a(paramInt1);
    BaseSessionInfo localBaseSessionInfo = this.mSessionInfo;
    if (localBaseSessionInfo == null) {
      Intrinsics.throwNpe();
    }
    localDtReportParamsBuilder = localDtReportParamsBuilder.b(((IApolloDtReportHelper)localObject).getReportSessionType(localBaseSessionInfo.a)).f(String.valueOf(paramInt2)).e(this.mType).a(this.name);
    localBaseSessionInfo = this.mSessionInfo;
    if (localBaseSessionInfo == null) {
      Intrinsics.throwNpe();
    }
    ((IApolloDtReportHelper)localObject).report("aio", "aio_keywords", paramString, (Map)localDtReportParamsBuilder.c(localBaseSessionInfo.b.toString()).a());
  }
  
  @Nullable
  public View getView()
  {
    IApolloBrickPlayer localIApolloBrickPlayer = this.mBrickPlayer;
    if (localIApolloBrickPlayer != null) {
      return localIApolloBrickPlayer.getView();
    }
    return null;
  }
  
  public void init(@NotNull Context paramContext, int paramInt1, int paramInt2, @NotNull AppInterface paramAppInterface)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramAppInterface, "app");
    this.mContext = paramContext;
    this.mWidth = Integer.valueOf(paramInt1);
    this.mHeight = Integer.valueOf(paramInt2);
    this.mApp = paramAppInterface;
    paramAppInterface = (IApolloBrickPlayer)QRoute.api(IApolloBrickPlayer.class);
    paramAppInterface.setParams(new ApolloPlayerParams(paramContext, paramInt1, paramInt2));
    this.mBrickPlayer = paramAppInterface;
  }
  
  public boolean isPlaying()
  {
    return this.mIsPlaying;
  }
  
  public boolean isReady()
  {
    return this.mCMSAction != null;
  }
  
  public void onSend(@NotNull AppInterface paramAppInterface, @Nullable BaseAIOContext paramBaseAIOContext)
  {
    Intrinsics.checkParameterIsNotNull(paramAppInterface, "app");
    QLog.d(TAG, 1, "onSend");
    try
    {
      if (this.mCMSAction != null)
      {
        Object localObject1 = this.mCMSAction;
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        int j = ((MemeAction)localObject1).c().f;
        localObject1 = this.mCMSAction;
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        Object localObject2 = ((MemeAction)localObject1).c().k;
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = "0";
        }
        localObject2 = (IApolloUtil)QRoute.api(IApolloUtil.class);
        BaseSessionInfo localBaseSessionInfo = this.mSessionInfo;
        if (localBaseSessionInfo == null) {
          Intrinsics.throwNpe();
        }
        int k = ((IApolloUtil)localObject2).getReportSessionType(localBaseSessionInfo.a);
        int m = this.mType;
        int i = 0;
        VipUtils.a(paramAppInterface, "cmshow", "Apollo", "y_gjcbq_click", "", k, 0, new String[] { String.valueOf(m), String.valueOf(j), this.name });
        if (j > ApolloConstant.f) {
          i = 1;
        }
        apolloDtReport(i, j, "click");
        paramAppInterface = (IApolloManagerService)paramAppInterface.getRuntimeService(IApolloManagerService.class, "all");
        if (paramAppInterface != null)
        {
          paramAppInterface.sendActionMessage(paramBaseAIOContext, j, 0, (String)localObject1, this.mType, 3);
          return;
        }
      }
    }
    catch (Exception paramAppInterface)
    {
      QLog.e(TAG, 1, "onSend error", (Throwable)paramAppInterface);
    }
  }
  
  public void pause()
  {
    if (!isReady())
    {
      QLog.w(TAG, 1, "pause not ready");
      return;
    }
    IApolloBrickPlayer localIApolloBrickPlayer = this.mBrickPlayer;
    if (localIApolloBrickPlayer != null) {
      localIApolloBrickPlayer.pause();
    }
    this.mIsPlaying = false;
  }
  
  public void play()
  {
    if (!isReady())
    {
      QLog.w(TAG, 1, "play not ready");
      return;
    }
    Object localObject = this.mCMSAction;
    if (localObject != null)
    {
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      int j = ((MemeAction)localObject).c().f;
      localObject = this.mApp;
      IApolloUtil localIApolloUtil = (IApolloUtil)QRoute.api(IApolloUtil.class);
      BaseSessionInfo localBaseSessionInfo = this.mSessionInfo;
      if (localBaseSessionInfo == null) {
        Intrinsics.throwNpe();
      }
      int k = localIApolloUtil.getReportSessionType(localBaseSessionInfo.a);
      int m = this.mType;
      int i = 0;
      VipUtils.a((AppInterface)localObject, "cmshow", "Apollo", "gjcbq_expose", "", k, 0, new String[] { String.valueOf(m), String.valueOf(j), this.name });
      if (j > ApolloConstant.f) {
        i = 1;
      }
      apolloDtReport(i, j, "expose");
    }
    localObject = this.mBrickPlayer;
    if (localObject != null) {
      ((IApolloBrickPlayer)localObject).start();
    }
    this.mIsPlaying = true;
  }
  
  public void resume()
  {
    if (!isReady())
    {
      QLog.w(TAG, 1, "resume not ready");
      return;
    }
    IApolloBrickPlayer localIApolloBrickPlayer = this.mBrickPlayer;
    if (localIApolloBrickPlayer != null) {
      localIApolloBrickPlayer.resume();
    }
    this.mIsPlaying = true;
  }
  
  public void setJson(@Nullable JSONObject paramJSONObject, @Nullable BaseSessionInfo paramBaseSessionInfo)
  {
    if (paramJSONObject != null)
    {
      if (paramBaseSessionInfo == null) {
        return;
      }
      Object localObject1 = TAG;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("setJson: json = ");
      ((StringBuilder)localObject2).append(paramJSONObject);
      QLog.d((String)localObject1, 4, ((StringBuilder)localObject2).toString());
      this.mSessionInfo = paramBaseSessionInfo;
      try
      {
        boolean bool = paramJSONObject.has(KEY_ACTION_ID);
        if (bool)
        {
          localObject1 = paramJSONObject.get(KEY_ACTION_ID);
          if (localObject1 != null) {
            i = ((Integer)localObject1).intValue();
          } else {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
          }
        }
        else if (paramJSONObject.has(KEY_ID))
        {
          localObject1 = paramJSONObject.get(KEY_ID);
          if (localObject1 != null) {
            i = ((Integer)localObject1).intValue();
          } else {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
          }
        }
        else
        {
          i = -1;
        }
        if (i == -1) {
          return;
        }
        k = 0;
      }
      catch (Throwable paramJSONObject)
      {
        int i;
        int k;
        int j;
        label202:
        label240:
        label243:
        int m;
        BaseSessionInfo localBaseSessionInfo;
        label434:
        label479:
        QLog.e(TAG, 1, "setJson error", paramJSONObject);
      }
    }
    try
    {
      localObject1 = paramJSONObject.get(KEY_ACTION_TYPE);
      if (localObject1 != null) {
        j = ((Integer)localObject1).intValue();
      } else {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
      }
    }
    catch (Exception localException1)
    {
      break label202;
    }
    try
    {
      localObject1 = paramJSONObject.get(KEY_ACTION_TYPE);
      if (localObject1 != null)
      {
        j = Integer.parseInt((String)localObject1);
        break label243;
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
    }
    catch (Exception localException2)
    {
      break label240;
      paramBaseSessionInfo = "";
      break label434;
      String str = "";
      break label479;
    }
    j = 0;
    if (paramJSONObject.has(KEY_TYPE))
    {
      localObject1 = paramJSONObject.get(KEY_TYPE);
      if (localObject1 != null) {
        this.mType = ((Integer)localObject1).intValue();
      } else {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
      }
    }
    if (paramBaseSessionInfo.c != null) {
      k = 1;
    }
    paramBaseSessionInfo = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(paramBaseSessionInfo, "BaseApplicationImpl.getApplication()");
    paramBaseSessionInfo = paramBaseSessionInfo.getRuntime();
    Intrinsics.checkExpressionValueIsNotNull(paramBaseSessionInfo, "BaseApplicationImpl.getApplication().runtime");
    localObject2 = paramBaseSessionInfo.getAccount();
    m = this.mType;
    localObject1 = null;
    paramBaseSessionInfo = null;
    if ((m == 1) && (k == 0))
    {
      localObject1 = this.mSessionInfo;
      if (localObject1 != null) {
        paramBaseSessionInfo = ((BaseSessionInfo)localObject1).b;
      }
      if (paramBaseSessionInfo == null) {
        Intrinsics.throwNpe();
      }
      paramBaseSessionInfo = paramBaseSessionInfo.toString();
    }
    else
    {
      if ((this.mType != 1) || (k == 0)) {
        break label634;
      }
      localBaseSessionInfo = this.mSessionInfo;
      paramBaseSessionInfo = (BaseSessionInfo)localObject1;
      if (localBaseSessionInfo != null) {
        paramBaseSessionInfo = localBaseSessionInfo.c;
      }
      if (paramBaseSessionInfo == null) {
        Intrinsics.throwNpe();
      }
      paramBaseSessionInfo = paramBaseSessionInfo.toString();
    }
    if (paramJSONObject.has(KEY_EXT_JSON))
    {
      localObject1 = paramJSONObject.get(KEY_EXT_JSON);
      if (localObject1 != null) {
        localObject1 = (String)localObject1;
      } else {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
      }
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "senderUin");
      this.mCMSAction = ((MemeAction)new MemeCommonAction(i, j, (String)localObject2, paramBaseSessionInfo, (String)localObject1));
      if (paramJSONObject.has(KEY_NAME))
      {
        paramJSONObject = paramJSONObject.get(KEY_NAME);
        if (paramJSONObject != null) {
          this.name = ((String)paramJSONObject);
        } else {
          throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
        }
      }
      paramJSONObject = this.mBrickPlayer;
      if (paramJSONObject != null) {
        paramJSONObject.setAction(this.mCMSAction);
      }
      paramJSONObject = TAG;
      paramBaseSessionInfo = new StringBuilder();
      paramBaseSessionInfo.append("setJson: CMSCommonAction = ");
      paramBaseSessionInfo.append(this.mCMSAction);
      QLog.d(paramJSONObject, 4, paramBaseSessionInfo.toString());
      return;
      return;
    }
  }
  
  public void stop()
  {
    if (!isReady())
    {
      QLog.w(TAG, 1, "stop not ready");
      return;
    }
    IApolloBrickPlayer localIApolloBrickPlayer = this.mBrickPlayer;
    if (localIApolloBrickPlayer != null) {
      localIApolloBrickPlayer.destroy();
    }
    this.mCMSAction = ((MemeAction)null);
    this.mIsPlaying = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.item.api.impl.ApolloIceBreakShowImpl
 * JD-Core Version:    0.7.0.1
 */