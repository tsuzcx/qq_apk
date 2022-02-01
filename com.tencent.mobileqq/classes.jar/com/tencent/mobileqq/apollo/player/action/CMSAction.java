package com.tencent.mobileqq.apollo.player.action;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.model.ApolloDress;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.player.model.BusinessConfig;
import com.tencent.mobileqq.apollo.res.api.IApolloResDownloader;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.utils.api.IApolloActionHelper;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.apollo.utils.api.ICMShowWnsHelper;
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
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/player/action/CMSAction;", "", "needRecord", "", "playAmountTimes", "", "(ZI)V", "_recordKey", "", "get_recordKey", "()Ljava/lang/String;", "set_recordKey", "(Ljava/lang/String;)V", "config", "Lcom/tencent/mobileqq/apollo/player/model/BusinessConfig;", "getConfig", "()Lcom/tencent/mobileqq/apollo/player/model/BusinessConfig;", "setConfig", "(Lcom/tencent/mobileqq/apollo/player/model/BusinessConfig;)V", "desc", "getDesc", "desc$delegate", "Lkotlin/Lazy;", "id", "getId", "mode", "Lcom/tencent/mobileqq/apollo/player/action/MODE;", "getMode", "()Lcom/tencent/mobileqq/apollo/player/action/MODE;", "setMode", "(Lcom/tencent/mobileqq/apollo/player/action/MODE;)V", "name", "getName", "getNeedRecord", "()Z", "setNeedRecord", "(Z)V", "getPlayAmountTimes", "()I", "setPlayAmountTimes", "(I)V", "spriteTask", "Lcom/tencent/mobileqq/apollo/script/SpriteTaskParam;", "getSpriteTask", "()Lcom/tencent/mobileqq/apollo/script/SpriteTaskParam;", "genKey", "genKeyPerf", "genSpriteDesc", "uin", "model", "isMaster", "getIntId", "getKey", "priorityKey", "external", "playAgain", "Companion", "cmshow_api_release"}, k=1, mv={1, 1, 16})
public abstract class CMSAction
{
  public static final CMSAction.Companion a;
  private int jdField_a_of_type_Int;
  @NotNull
  private MODE jdField_a_of_type_ComTencentMobileqqApolloPlayerActionMODE;
  @NotNull
  private BusinessConfig jdField_a_of_type_ComTencentMobileqqApolloPlayerModelBusinessConfig;
  @Nullable
  private volatile String jdField_a_of_type_JavaLangString;
  @NotNull
  private final Lazy jdField_a_of_type_KotlinLazy;
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction$Companion = new CMSAction.Companion(null);
  }
  
  public CMSAction()
  {
    this(false, 0, 3, null);
  }
  
  public CMSAction(boolean paramBoolean, int paramInt)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_KotlinLazy = LazyKt.lazy((Function0)new CMSAction.desc.2(this));
    this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionMODE = MODE.ACTION_MODE_RECORD_APNG;
    this.jdField_a_of_type_ComTencentMobileqqApolloPlayerModelBusinessConfig = new BusinessConfig();
  }
  
  private final String a(String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject1 = QRoute.api(IApolloUtil.class);
    if (localObject1 == null) {
      Intrinsics.throwNpe();
    }
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "QRoute.api(IApolloUtil::class.java)!!");
    Object localObject2 = (IApolloUtil)localObject1;
    localObject1 = QRoute.api(IApolloActionHelper.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "QRoute.api(IApolloActionHelper::class.java)");
    IApolloActionHelper localIApolloActionHelper = (IApolloActionHelper)localObject1;
    Object localObject3 = ((IApolloUtil)localObject2).getAppInterface();
    StringBuilder localStringBuilder = null;
    localObject1 = null;
    if (localObject3 != null)
    {
      Object localObject4 = ((AppRuntime)localObject3).getRuntimeService(IApolloManagerService.class, "all");
      Intrinsics.checkExpressionValueIsNotNull(localObject4, "app.getRuntimeService(IA…ava, ProcessConstant.ALL)");
      Object localObject5 = (IApolloManagerService)localObject4;
      localObject4 = ((AppRuntime)localObject3).getRuntimeService(IApolloDaoManagerService.class, "all");
      Intrinsics.checkExpressionValueIsNotNull(localObject4, "app.getRuntimeService(IA…ava, ProcessConstant.ALL)");
      ApolloBaseInfo localApolloBaseInfo = ((IApolloDaoManagerService)localObject4).getApolloBaseInfo(paramString1);
      if (localApolloBaseInfo != null)
      {
        JSONObject localJSONObject = localApolloBaseInfo.getFaceModel(false, (AppRuntime)localObject3);
        localObject4 = localApolloBaseInfo.getDress3D(false, (AppRuntime)localObject3);
        int k = localApolloBaseInfo.getRole3D(false, (AppRuntime)localObject3);
        int m = ((IApolloManagerService)localObject5).getCmShowStatus(paramString1);
        int i;
        if (!localApolloBaseInfo.isApolloStatusOpen())
        {
          if (((IApolloUtil)localObject2).isFemale((AppRuntime)localObject3, paramString1)) {
            i = 2;
          } else {
            i = 1;
          }
          localObject2 = ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).readRoleDefaultDressIds(i);
          if (localObject2 != null)
          {
            localObject1 = (Collection)new ArrayList(localObject2.length);
            n = localObject2.length;
            j = 0;
            while (j < n)
            {
              int i1 = localObject2[j];
              ((Collection)localObject1).add(CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction$Companion, localIApolloActionHelper.getApolloResource(1, i1)));
              j += 1;
            }
            localObject1 = (List)localObject1;
          }
          localObject2 = new Object[2];
          localObject2[0] = Integer.valueOf(i);
          localObject2[1] = localObject1;
        }
        for (localObject1 = localObject2;; localObject1 = localObject3)
        {
          break;
          localObject1 = localApolloBaseInfo.getApolloDress(false);
          if (localObject1 != null) {
            localObject1 = localObject1[0];
          } else {
            localObject1 = null;
          }
          localObject3 = new Object[2];
          if (localObject1 != null) {
            localObject2 = Integer.valueOf(((ApolloDress)localObject1).roleId);
          } else {
            localObject2 = null;
          }
          localObject3[0] = localObject2;
          localObject2 = localStringBuilder;
          if (localObject1 != null)
          {
            localObject1 = ((ApolloDress)localObject1).getDressIds();
            localObject2 = localStringBuilder;
            if (localObject1 != null)
            {
              localObject2 = (Collection)new ArrayList(localObject1.length);
              j = localObject1.length;
              i = 0;
              while (i < j)
              {
                n = localObject1[i];
                ((Collection)localObject2).add(CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction$Companion, localIApolloActionHelper.getApolloResource(1, n)));
                i += 1;
              }
              localObject2 = (List)localObject2;
            }
          }
          localObject3[1] = localObject2;
        }
        localStringBuilder = localObject1[0];
        localObject3 = localObject1[1];
        int j = a().k;
        int n = a().f;
        if (Intrinsics.areEqual(paramString2, "3D")) {
          i = k;
        } else if ((localStringBuilder != null) && ((localStringBuilder instanceof Integer))) {
          i = ((Number)localStringBuilder).intValue();
        } else {
          i = -1;
        }
        localObject1 = localIApolloActionHelper.getActionResourcePath(j, n, i, paramBoolean, m)[0];
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("{");
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append(CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction$Companion, paramString1, "uin"));
        ((StringBuilder)localObject5).append(',');
        ((StringBuilder)localObject2).append(((StringBuilder)localObject5).toString());
        paramString1 = new StringBuilder();
        paramString1.append(CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction$Companion, paramString2, "model"));
        paramString1.append(',');
        ((StringBuilder)localObject2).append(paramString1.toString());
        paramString1 = new StringBuilder();
        paramString1.append(CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction$Companion, "3DObject"));
        paramString1.append(":{");
        ((StringBuilder)localObject2).append(paramString1.toString());
        if (localJSONObject != null)
        {
          paramString1 = new StringBuilder();
          paramString1.append(CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction$Companion, localJSONObject, "faceModel"));
          paramString1.append(',');
          ((StringBuilder)localObject2).append(paramString1.toString());
        }
        if ((localObject4 != null) && (k > 0))
        {
          paramString1 = new StringBuilder();
          paramString1.append(CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction$Companion, localObject4, "dress"));
          paramString1.append(',');
          ((StringBuilder)localObject2).append(paramString1.toString());
          ((StringBuilder)localObject2).append(String.valueOf(CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction$Companion, String.valueOf(k), "role")));
        }
        ((StringBuilder)localObject2).append("},");
        if (localObject3 != null)
        {
          paramString1 = new StringBuilder();
          paramString1.append(CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction$Companion, localObject3, "dress"));
          paramString1.append(',');
          ((StringBuilder)localObject2).append(paramString1.toString());
        }
        if ((localStringBuilder != null) && ((localStringBuilder instanceof Integer)))
        {
          paramString1 = new StringBuilder();
          paramString1.append(CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction$Companion, localIApolloActionHelper.getApolloResource(0, ((Number)localStringBuilder).intValue()), "role"));
          paramString1.append(',');
          ((StringBuilder)localObject2).append(paramString1.toString());
        }
        localStringBuilder = new StringBuilder();
        if (paramBoolean)
        {
          paramString1 = jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction$Companion;
          paramString2 = Integer.valueOf(1);
        }
        else
        {
          paramString1 = jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction$Companion;
          paramString2 = Integer.valueOf(0);
        }
        localStringBuilder.append(CMSAction.Companion.a(paramString1, paramString2, "isMaster"));
        localStringBuilder.append(',');
        ((StringBuilder)localObject2).append(localStringBuilder.toString());
        ((StringBuilder)localObject2).append(String.valueOf(CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction$Companion, localObject1, "action")));
        ((StringBuilder)localObject2).append("}");
        paramString1 = ((StringBuilder)localObject2).toString();
        Intrinsics.checkExpressionValueIsNotNull(paramString1, "StringBuilder().apply(builderAction).toString()");
        return paramString1;
      }
    }
    return null;
  }
  
  private final String e()
  {
    long l1 = System.currentTimeMillis();
    String str = f();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(d());
    ((StringBuilder)localObject1).append('_');
    Object localObject2 = MD5.a(str);
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
      QLog.w("CMSPlayer-Action", 1, ((StringBuilder)localObject2).toString());
      return localObject1;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  private final String f()
  {
    Object localObject2 = ApolloActionData.getModelString(a().f);
    String str1 = a().jdField_a_of_type_JavaLangString;
    Object localObject1 = null;
    if (str1 != null)
    {
      str1 = a().jdField_a_of_type_JavaLangString;
      Intrinsics.checkExpressionValueIsNotNull(str1, "spriteTask.mSenderUin");
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "model");
      str1 = a(str1, (String)localObject2, true);
    }
    else
    {
      str1 = null;
    }
    String str2;
    if ((a().e == 1) && (a().jdField_b_of_type_JavaLangString != null))
    {
      str2 = a().jdField_b_of_type_JavaLangString;
      Intrinsics.checkExpressionValueIsNotNull(str2, "spriteTask.mRecvUin");
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "model");
      str2 = a(str2, (String)localObject2, false);
    }
    else
    {
      str2 = null;
    }
    Object localObject3 = QRoute.api(IApolloUtil.class);
    if (localObject3 == null) {
      Intrinsics.throwNpe();
    }
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "QRoute.api(IApolloUtil::class.java)!!");
    localObject3 = (IApolloUtil)localObject3;
    if (((IApolloUtil)localObject3).getAppInterface() != null)
    {
      localObject3 = ((IApolloUtil)localObject3).getAppInterface().getRuntimeService(IApolloDaoManagerService.class, "all");
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "util.appInterface.getRun…ava, ProcessConstant.ALL)");
      localObject3 = ((IApolloDaoManagerService)localObject3).findActionById(a().f);
      if (localObject3 != null) {
        localObject1 = Long.valueOf(((ApolloActionData)localObject3).version);
      }
    }
    else
    {
      localObject1 = Long.valueOf(0L);
    }
    int i = ((ICMShowWnsHelper)QRoute.api(ICMShowWnsHelper.class)).getCmshowMemeCacheKey();
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("{");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction$Companion, Integer.valueOf(i), "wnsCacheKey"));
    localStringBuilder.append(',');
    ((StringBuilder)localObject3).append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction$Companion, localObject2, "model"));
    localStringBuilder.append(',');
    ((StringBuilder)localObject3).append(localStringBuilder.toString());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction$Companion, Integer.valueOf(a().f), "actionId"));
    ((StringBuilder)localObject2).append(',');
    ((StringBuilder)localObject3).append(((StringBuilder)localObject2).toString());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction$Companion, localObject1, "actionVersion"));
    ((StringBuilder)localObject2).append(',');
    ((StringBuilder)localObject3).append(((StringBuilder)localObject2).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction$Companion, Integer.valueOf(a().jdField_c_of_type_Int), "actionType"));
    ((StringBuilder)localObject1).append(',');
    ((StringBuilder)localObject3).append(((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction$Companion, Integer.valueOf(a().g), "from"));
    ((StringBuilder)localObject1).append(',');
    ((StringBuilder)localObject3).append(((StringBuilder)localObject1).toString());
    localObject2 = new StringBuilder();
    if (a().jdField_a_of_type_Boolean) {
      localObject1 = CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction$Companion, Integer.valueOf(1), "isSender");
    } else {
      localObject1 = CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction$Companion, Integer.valueOf(0), "isSender");
    }
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(',');
    ((StringBuilder)localObject3).append(((StringBuilder)localObject2).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction$Companion, "sprites"));
    ((StringBuilder)localObject1).append(":[");
    ((StringBuilder)localObject3).append(((StringBuilder)localObject1).toString());
    if (str1 != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(str1);
      ((StringBuilder)localObject1).append(',');
      ((StringBuilder)localObject3).append(((StringBuilder)localObject1).toString());
    }
    if (str2 != null) {
      ((StringBuilder)localObject3).append(String.valueOf(str2));
    }
    ((StringBuilder)localObject3).append("],");
    if (!TextUtils.isEmpty((CharSequence)a().d))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction$Companion, a().d, "extraMsg"));
      ((StringBuilder)localObject1).append(',');
      ((StringBuilder)localObject3).append(((StringBuilder)localObject1).toString());
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction$Companion, Boolean.valueOf(a().jdField_c_of_type_Boolean), "needRecordFrame"));
    ((StringBuilder)localObject1).append(',');
    ((StringBuilder)localObject3).append(((StringBuilder)localObject1).toString());
    ((StringBuilder)localObject3).append(String.valueOf(CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction$Companion, Float.valueOf(a().jdField_b_of_type_Float), "frameTime")));
    ((StringBuilder)localObject3).append("}");
    localObject1 = ((StringBuilder)localObject3).toString();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "StringBuilder().apply(builderAction).toString()");
    return localObject1;
  }
  
  @NotNull
  public final MODE a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionMODE;
  }
  
  @NotNull
  public final BusinessConfig a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloPlayerModelBusinessConfig;
  }
  
  @NotNull
  public abstract SpriteTaskParam a();
  
  @NotNull
  public abstract String a();
  
  @NotNull
  public final String a(@Nullable String paramString1, @Nullable String paramString2)
  {
    if (this.jdField_a_of_type_JavaLangString == null)
    {
      if (paramString1 == null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(e());
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
      this.jdField_a_of_type_JavaLangString = paramString1;
    }
    paramString1 = this.jdField_a_of_type_JavaLangString;
    if (paramString1 == null) {
      Intrinsics.throwNpe();
    }
    return paramString1;
  }
  
  public final void a(@NotNull MODE paramMODE)
  {
    Intrinsics.checkParameterIsNotNull(paramMODE, "<set-?>");
    this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionMODE = paramMODE;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @NotNull
  public abstract String b();
  
  public final int c()
  {
    return a().f;
  }
  
  @Nullable
  protected final String c()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public final int d()
  {
    return a().f;
  }
  
  @NotNull
  public final String d()
  {
    return (String)this.jdField_a_of_type_KotlinLazy.getValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.action.CMSAction
 * JD-Core Version:    0.7.0.1
 */