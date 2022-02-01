package com.tencent.mobileqq.apollo.meme.action;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.meme.model.BusinessConfig;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.model.ApolloDress;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.res.api.IApolloResHelper;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.utils.api.IApolloActionHelper;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.apollo.utils.api.ICMShowWnsHelper;
import com.tencent.mobileqq.cmshow.engine.action.ActionStatus;
import com.tencent.mobileqq.cmshow.engine.action.INIT;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.open.base.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/meme/action/MemeAction;", "", "needRecord", "", "(Z)V", "_recordKey", "", "get_recordKey", "()Ljava/lang/String;", "set_recordKey", "(Ljava/lang/String;)V", "<set-?>", "Lcom/tencent/mobileqq/cmshow/engine/action/ActionStatus;", "actionStatus", "getActionStatus", "()Lcom/tencent/mobileqq/cmshow/engine/action/ActionStatus;", "setActionStatus", "(Lcom/tencent/mobileqq/cmshow/engine/action/ActionStatus;)V", "actionStatus$delegate", "Lkotlin/properties/ReadWriteProperty;", "config", "Lcom/tencent/mobileqq/apollo/meme/model/BusinessConfig;", "getConfig", "()Lcom/tencent/mobileqq/apollo/meme/model/BusinessConfig;", "setConfig", "(Lcom/tencent/mobileqq/apollo/meme/model/BusinessConfig;)V", "desc", "getDesc", "desc$delegate", "Lkotlin/Lazy;", "id", "getId", "mode", "Lcom/tencent/mobileqq/apollo/meme/action/MODE;", "getMode", "()Lcom/tencent/mobileqq/apollo/meme/action/MODE;", "setMode", "(Lcom/tencent/mobileqq/apollo/meme/action/MODE;)V", "name", "getName", "getNeedRecord", "()Z", "setNeedRecord", "spriteTask", "Lcom/tencent/mobileqq/apollo/script/SpriteTaskParam;", "getSpriteTask", "()Lcom/tencent/mobileqq/apollo/script/SpriteTaskParam;", "genKey", "genKeyPerf", "genSpriteDesc", "uin", "model", "isMaster", "", "getIntId", "getKey", "priorityKey", "external", "Companion", "cmshow_api_release"}, k=1, mv={1, 1, 16})
public abstract class MemeAction
{
  public static final MemeAction.Companion b = new MemeAction.Companion(null);
  @Nullable
  private volatile String c;
  @NotNull
  private final Lazy d;
  @NotNull
  private MODE e;
  @NotNull
  private BusinessConfig f;
  @NotNull
  private final ReadWriteProperty g;
  private boolean h;
  
  public MemeAction()
  {
    this(false, 1, null);
  }
  
  public MemeAction(boolean paramBoolean)
  {
    this.h = paramBoolean;
    this.d = LazyKt.lazy((Function0)new MemeAction.desc.2(this));
    this.e = MODE.ACTION_MODE_RECORD_APNG;
    this.f = new BusinessConfig();
    Object localObject = Delegates.INSTANCE;
    localObject = INIT.a;
    this.g = ((ReadWriteProperty)new MemeAction..special..inlined.observable.1(localObject, localObject, this));
  }
  
  private final String a(String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject1 = QRoute.api(IApolloUtil.class);
    if (localObject1 == null) {
      Intrinsics.throwNpe();
    }
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "QRoute.api(IApolloUtil::class.java)!!");
    IApolloUtil localIApolloUtil = (IApolloUtil)localObject1;
    localObject1 = QRoute.api(IApolloActionHelper.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "QRoute.api(IApolloActionHelper::class.java)");
    IApolloActionHelper localIApolloActionHelper = (IApolloActionHelper)localObject1;
    AppRuntime localAppRuntime = localIApolloUtil.getAppInterface();
    if (localAppRuntime != null)
    {
      localObject1 = localAppRuntime.getRuntimeService(IApolloManagerService.class, "all");
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "app.getRuntimeService(IA…ava, ProcessConstant.ALL)");
      Object localObject5 = (IApolloManagerService)localObject1;
      localObject1 = localAppRuntime.getRuntimeService(IApolloDaoManagerService.class, "all");
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "app.getRuntimeService(IA…ava, ProcessConstant.ALL)");
      localObject1 = ((IApolloDaoManagerService)localObject1).getApolloBaseInfo(paramString1);
      if (localObject1 != null)
      {
        JSONObject localJSONObject = ((ApolloBaseInfo)localObject1).getFaceModel(false, localAppRuntime);
        JSONArray localJSONArray = ((ApolloBaseInfo)localObject1).getDress3D(false, localAppRuntime);
        int k = ((ApolloBaseInfo)localObject1).getRole3D(false, localAppRuntime);
        Object localObject2 = ((ApolloBaseInfo)localObject1).getApolloDress();
        if (localObject2 != null) {
          localObject1 = Integer.valueOf(((ApolloDress)localObject2).roleId);
        } else {
          localObject1 = null;
        }
        int i;
        if (localObject2 != null)
        {
          localObject2 = ((ApolloDress)localObject2).getDressIds();
          if (localObject2 != null)
          {
            localObject3 = (Collection)new ArrayList(localObject2.length);
            j = localObject2.length;
            i = 0;
            while (i < j)
            {
              m = localObject2[i];
              ((Collection)localObject3).add(MemeAction.Companion.a(b, localIApolloActionHelper.getApolloResource(1, m)));
              i += 1;
            }
            localObject2 = (List)localObject3;
            break label283;
          }
        }
        localObject2 = null;
        label283:
        Object localObject4 = localObject2;
        Object localObject3 = localObject1;
        if (localObject2 == null)
        {
          if (localIApolloUtil.isFemale(localAppRuntime, paramString1)) {
            i = 2;
          } else {
            i = 1;
          }
          localObject1 = ((IApolloResHelper)QRoute.api(IApolloResHelper.class)).readRoleDefaultDressIds(i);
          if (localObject1 != null)
          {
            localObject2 = (Collection)new ArrayList(localObject1.length);
            m = localObject1.length;
            j = 0;
            while (j < m)
            {
              n = localObject1[j];
              ((Collection)localObject2).add(MemeAction.Companion.a(b, localIApolloActionHelper.getApolloResource(1, n)));
              j += 1;
            }
            localObject1 = (List)localObject2;
          }
          else
          {
            localObject1 = null;
          }
          localObject3 = Integer.valueOf(i);
          localObject4 = localObject1;
        }
        int j = ((IApolloManagerService)localObject5).getCmShowStatus(paramString1);
        int m = c().v;
        int n = c().f;
        if (Intrinsics.areEqual(paramString2, "3D")) {
          i = k;
        } else if ((localObject3 != null) && ((localObject3 instanceof Integer))) {
          i = ((Integer)localObject3).intValue();
        } else {
          i = -1;
        }
        localObject1 = localIApolloActionHelper.getActionResourcePath(m, n, i, paramBoolean, j)[0];
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("{");
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append(MemeAction.Companion.a(b, paramString1, "uin"));
        ((StringBuilder)localObject5).append(',');
        ((StringBuilder)localObject2).append(((StringBuilder)localObject5).toString());
        paramString1 = new StringBuilder();
        paramString1.append(MemeAction.Companion.a(b, paramString2, "model"));
        paramString1.append(',');
        ((StringBuilder)localObject2).append(paramString1.toString());
        paramString1 = new StringBuilder();
        paramString1.append(MemeAction.Companion.a(b, "3DObject"));
        paramString1.append(":{");
        ((StringBuilder)localObject2).append(paramString1.toString());
        if (localJSONObject != null)
        {
          paramString1 = new StringBuilder();
          paramString1.append(MemeAction.Companion.a(b, localJSONObject, "faceModel"));
          paramString1.append(',');
          ((StringBuilder)localObject2).append(paramString1.toString());
        }
        if ((localJSONArray != null) && (k > 0))
        {
          paramString1 = new StringBuilder();
          paramString1.append(MemeAction.Companion.a(b, localJSONArray, "dress"));
          paramString1.append(',');
          ((StringBuilder)localObject2).append(paramString1.toString());
          ((StringBuilder)localObject2).append(String.valueOf(MemeAction.Companion.a(b, String.valueOf(k), "role")));
        }
        ((StringBuilder)localObject2).append("},");
        if (localObject4 != null)
        {
          paramString1 = new StringBuilder();
          paramString1.append(MemeAction.Companion.a(b, localObject4, "dress"));
          paramString1.append(',');
          ((StringBuilder)localObject2).append(paramString1.toString());
        }
        if ((localObject3 != null) && ((localObject3 instanceof Integer)))
        {
          paramString1 = new StringBuilder();
          paramString1.append(MemeAction.Companion.a(b, localIApolloActionHelper.getApolloResource(0, ((Integer)localObject3).intValue()), "role"));
          paramString1.append(',');
          ((StringBuilder)localObject2).append(paramString1.toString());
        }
        localObject3 = new StringBuilder();
        if (paramBoolean)
        {
          paramString1 = b;
          paramString2 = Integer.valueOf(1);
        }
        else
        {
          paramString1 = b;
          paramString2 = Integer.valueOf(0);
        }
        ((StringBuilder)localObject3).append(MemeAction.Companion.a(paramString1, paramString2, "isMaster"));
        ((StringBuilder)localObject3).append(',');
        ((StringBuilder)localObject2).append(((StringBuilder)localObject3).toString());
        ((StringBuilder)localObject2).append(String.valueOf(MemeAction.Companion.a(b, localObject1, "action")));
        ((StringBuilder)localObject2).append("}");
        paramString1 = ((StringBuilder)localObject2).toString();
        Intrinsics.checkExpressionValueIsNotNull(paramString1, "StringBuilder().apply(builderAction).toString()");
        return paramString1;
      }
      return null;
    }
    return null;
  }
  
  private final String d()
  {
    long l1 = System.currentTimeMillis();
    String str = e();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(m());
    ((StringBuilder)localObject1).append('_');
    Object localObject2 = MD5.b(str);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "MD5.toMD5(actionStr)");
    if (localObject2 != null)
    {
      localObject2 = ((String)localObject2).toLowerCase();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "(this as java.lang.String).toLowerCase()");
      ((StringBuilder)localObject1).append((String)localObject2);
      localObject1 = ((StringBuilder)localObject1).toString();
      long l2 = System.currentTimeMillis();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("genKey key:");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(", costTime:");
      ((StringBuilder)localObject2).append(l2 - l1);
      ((StringBuilder)localObject2).append(", detail:");
      ((StringBuilder)localObject2).append(str);
      QLog.w("[cmshow][MemePlayer-Action]", 1, ((StringBuilder)localObject2).toString());
      return localObject1;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  private final String e()
  {
    Object localObject3 = ApolloActionData.getModelString(c().f);
    String str = c().j;
    Object localObject1 = null;
    if (str != null)
    {
      str = c().j;
      Intrinsics.checkExpressionValueIsNotNull(str, "spriteTask.mSenderUin");
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "model");
      str = a(str, (String)localObject3, true);
    }
    else
    {
      str = null;
    }
    Object localObject2 = c().a();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "spriteTask.isDoubleSpriteTask");
    if ((((Boolean)localObject2).booleanValue()) && (c().k != null))
    {
      localObject2 = c().k;
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "spriteTask.mRecvUin");
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "model");
      localObject2 = a((String)localObject2, (String)localObject3, false);
    }
    else
    {
      localObject2 = null;
    }
    Object localObject4 = QRoute.api(IApolloUtil.class);
    if (localObject4 == null) {
      Intrinsics.throwNpe();
    }
    Intrinsics.checkExpressionValueIsNotNull(localObject4, "QRoute.api(IApolloUtil::class.java)!!");
    localObject4 = (IApolloUtil)localObject4;
    if (((IApolloUtil)localObject4).getAppInterface() != null)
    {
      localObject4 = ((IApolloUtil)localObject4).getAppInterface().getRuntimeService(IApolloDaoManagerService.class, "all");
      Intrinsics.checkExpressionValueIsNotNull(localObject4, "util.appInterface.getRun…ava, ProcessConstant.ALL)");
      localObject4 = ((IApolloDaoManagerService)localObject4).findActionById(c().f);
      if (localObject4 != null) {
        localObject1 = Long.valueOf(((ApolloActionData)localObject4).version);
      }
    }
    else
    {
      localObject1 = Long.valueOf(0L);
    }
    int i = ((ICMShowWnsHelper)QRoute.api(ICMShowWnsHelper.class)).getCmshowMemeCacheKey();
    localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("{");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(MemeAction.Companion.a(b, Integer.valueOf(i), "wnsCacheKey"));
    localStringBuilder.append(',');
    ((StringBuilder)localObject4).append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(MemeAction.Companion.a(b, localObject3, "model"));
    localStringBuilder.append(',');
    ((StringBuilder)localObject4).append(localStringBuilder.toString());
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(MemeAction.Companion.a(b, Integer.valueOf(c().f), "actionId"));
    ((StringBuilder)localObject3).append(',');
    ((StringBuilder)localObject4).append(((StringBuilder)localObject3).toString());
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(MemeAction.Companion.a(b, localObject1, "actionVersion"));
    ((StringBuilder)localObject3).append(',');
    ((StringBuilder)localObject4).append(((StringBuilder)localObject3).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(MemeAction.Companion.a(b, Integer.valueOf(c().c), "actionType"));
    ((StringBuilder)localObject1).append(',');
    ((StringBuilder)localObject4).append(((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(MemeAction.Companion.a(b, Integer.valueOf(c().g), "from"));
    ((StringBuilder)localObject1).append(',');
    ((StringBuilder)localObject4).append(((StringBuilder)localObject1).toString());
    localObject3 = new StringBuilder();
    if (c().l) {
      localObject1 = MemeAction.Companion.a(b, Integer.valueOf(1), "isSender");
    } else {
      localObject1 = MemeAction.Companion.a(b, Integer.valueOf(0), "isSender");
    }
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append(',');
    ((StringBuilder)localObject4).append(((StringBuilder)localObject3).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(MemeAction.Companion.a(b, "sprites"));
    ((StringBuilder)localObject1).append(":[");
    ((StringBuilder)localObject4).append(((StringBuilder)localObject1).toString());
    if (str != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append(',');
      ((StringBuilder)localObject4).append(((StringBuilder)localObject1).toString());
    }
    if (localObject2 != null) {
      ((StringBuilder)localObject4).append(String.valueOf(localObject2));
    }
    ((StringBuilder)localObject4).append("],");
    if (!TextUtils.isEmpty((CharSequence)c().t))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(MemeAction.Companion.a(b, c().t, "extraMsg"));
      ((StringBuilder)localObject1).append(',');
      ((StringBuilder)localObject4).append(((StringBuilder)localObject1).toString());
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(MemeAction.Companion.a(b, Boolean.valueOf(c().A), "needRecordFrame"));
    ((StringBuilder)localObject1).append(',');
    ((StringBuilder)localObject4).append(((StringBuilder)localObject1).toString());
    ((StringBuilder)localObject4).append(String.valueOf(MemeAction.Companion.a(b, Float.valueOf(c().B), "frameTime")));
    ((StringBuilder)localObject4).append("}");
    localObject1 = ((StringBuilder)localObject4).toString();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "StringBuilder().apply(builderAction).toString()");
    return localObject1;
  }
  
  @NotNull
  public abstract String a();
  
  @NotNull
  public final String a(@Nullable String paramString1, @Nullable String paramString2)
  {
    if (this.c == null)
    {
      if (paramString1 == null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(d());
        if (paramString2 != null)
        {
          paramString1 = new StringBuilder();
          paramString1.append('_');
          paramString1.append(paramString2);
          paramString1 = paramString1.toString();
        }
        else
        {
          paramString1 = "";
        }
        localStringBuilder.append(paramString1);
        paramString1 = localStringBuilder.toString();
      }
      this.c = paramString1;
    }
    paramString1 = this.c;
    if (paramString1 == null) {
      Intrinsics.throwNpe();
    }
    return paramString1;
  }
  
  public final void a(@NotNull MODE paramMODE)
  {
    Intrinsics.checkParameterIsNotNull(paramMODE, "<set-?>");
    this.e = paramMODE;
  }
  
  public final void a(@NotNull ActionStatus paramActionStatus)
  {
    Intrinsics.checkParameterIsNotNull(paramActionStatus, "<set-?>");
    this.g.setValue(this, a[0], paramActionStatus);
  }
  
  @NotNull
  public abstract String b();
  
  @NotNull
  public abstract SpriteTaskParam c();
  
  public boolean f()
  {
    return this.h;
  }
  
  @Nullable
  protected final String g()
  {
    return this.c;
  }
  
  @NotNull
  public final String h()
  {
    return (String)this.d.getValue();
  }
  
  @NotNull
  public final MODE i()
  {
    return this.e;
  }
  
  @NotNull
  public final BusinessConfig j()
  {
    return this.f;
  }
  
  @NotNull
  public final ActionStatus k()
  {
    return (ActionStatus)this.g.getValue(this, a[0]);
  }
  
  public final int l()
  {
    return c().f;
  }
  
  public final int m()
  {
    return c().f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.meme.action.MemeAction
 * JD-Core Version:    0.7.0.1
 */