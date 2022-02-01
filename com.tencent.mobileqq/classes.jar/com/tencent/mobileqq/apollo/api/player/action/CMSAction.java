package com.tencent.mobileqq.apollo.api.player.action;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.apollo.api.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.api.model.ApolloDress;
import com.tencent.mobileqq.apollo.api.player.model.BusinessConfig;
import com.tencent.mobileqq.apollo.api.res.IApolloResDownloader;
import com.tencent.mobileqq.apollo.api.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloActionHelperImpl;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.QQAppInterface;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/api/player/action/CMSAction;", "", "needRecord", "", "priority", "", "playAmountTimes", "(ZII)V", "_recordKey", "", "get_recordKey", "()Ljava/lang/String;", "set_recordKey", "(Ljava/lang/String;)V", "config", "Lcom/tencent/mobileqq/apollo/api/player/model/BusinessConfig;", "getConfig", "()Lcom/tencent/mobileqq/apollo/api/player/model/BusinessConfig;", "setConfig", "(Lcom/tencent/mobileqq/apollo/api/player/model/BusinessConfig;)V", "desc", "getDesc$AQQLiteApp_release", "desc$delegate", "Lkotlin/Lazy;", "id", "getId$AQQLiteApp_release", "mode", "Lcom/tencent/mobileqq/apollo/api/player/action/MODE;", "getMode", "()Lcom/tencent/mobileqq/apollo/api/player/action/MODE;", "setMode", "(Lcom/tencent/mobileqq/apollo/api/player/action/MODE;)V", "name", "getName$AQQLiteApp_release", "getNeedRecord", "()Z", "setNeedRecord", "(Z)V", "getPlayAmountTimes", "()I", "setPlayAmountTimes", "(I)V", "getPriority", "spriteTask", "Lcom/tencent/mobileqq/apollo/api/script/SpriteTaskParam;", "getSpriteTask$AQQLiteApp_release", "()Lcom/tencent/mobileqq/apollo/api/script/SpriteTaskParam;", "genKey", "genKeyPerf", "genSpriteDesc", "uin", "model", "isMaster", "getId", "getKey", "priorityKey", "external", "playAgain", "playAgain$AQQLiteApp_release", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract class CMSAction
{
  public static final CMSAction.Companion a;
  private final int jdField_a_of_type_Int;
  @NotNull
  private MODE jdField_a_of_type_ComTencentMobileqqApolloApiPlayerActionMODE;
  @NotNull
  private BusinessConfig jdField_a_of_type_ComTencentMobileqqApolloApiPlayerModelBusinessConfig;
  @Nullable
  private volatile String jdField_a_of_type_JavaLangString;
  @NotNull
  private final Lazy jdField_a_of_type_KotlinLazy;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqApolloApiPlayerActionCMSAction$Companion = new CMSAction.Companion(null);
  }
  
  public CMSAction()
  {
    this(false, 0, 0, 7, null);
  }
  
  public CMSAction(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_KotlinLazy = LazyKt.lazy((Function0)new CMSAction.desc.2(this));
    this.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerActionMODE = MODE.ACTION_MODE_PLAY;
    this.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerModelBusinessConfig = new BusinessConfig();
  }
  
  private final String a(String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject1 = QRoute.api(IApolloUtil.class);
    if (localObject1 == null) {
      Intrinsics.throwNpe();
    }
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "QRoute.api(IApolloUtil::class.java)!!");
    localObject1 = (IApolloUtil)localObject1;
    Object localObject2 = ((IApolloUtil)localObject1).getQQApp();
    JSONObject localJSONObject;
    JSONArray localJSONArray;
    int k;
    int m;
    if (localObject2 != null)
    {
      localObject3 = ((QQAppInterface)localObject2).getRuntimeService(IApolloManagerService.class, "all");
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "app.getRuntimeService(IA…ava, ProcessConstant.ALL)");
      localObject3 = (IApolloManagerService)localObject3;
      localApolloBaseInfo = ((IApolloManagerService)localObject3).getApolloBaseInfo(paramString1);
      if (localApolloBaseInfo == null) {
        break label239;
      }
      localJSONObject = localApolloBaseInfo.getFaceModel(false, (QQAppInterface)localObject2);
      localJSONArray = localApolloBaseInfo.getDress3D(false, (QQAppInterface)localObject2);
      k = localApolloBaseInfo.getRole3D(false, (QQAppInterface)localObject2);
      m = ((IApolloManagerService)localObject3).getCmShowStatus((QQAppInterface)localObject2, paramString1);
      if (ApolloUtilImpl.isApolloStatusOpen(localApolloBaseInfo)) {
        break label765;
      }
      if (!((IApolloUtil)localObject1).isFemale((QQAppInterface)localObject2, paramString1)) {
        break label241;
      }
    }
    label239:
    label241:
    for (int i = 2;; i = 1)
    {
      localObject1 = ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).readRoleDefaultDressIds(i);
      if (localObject1 == null) {
        break label759;
      }
      localObject2 = (Collection)new ArrayList(localObject1.length);
      n = localObject1.length;
      j = 0;
      while (j < n)
      {
        int i1 = localObject1[j];
        ((Collection)localObject2).add(CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloApiPlayerActionCMSAction$Companion, ApolloActionHelperImpl.getApolloRsc(1, i1)));
        j += 1;
      }
      return null;
      return null;
    }
    localObject1 = (List)localObject2;
    localObject2 = new Object[2];
    localObject2[0] = Integer.valueOf(i);
    localObject2[1] = localObject1;
    Object localObject3 = localObject2[0];
    ApolloBaseInfo localApolloBaseInfo = localObject2[1];
    int j = a().k;
    int n = a().f;
    if (Intrinsics.areEqual(paramString2, "3D"))
    {
      i = k;
      label319:
      localObject1 = ApolloActionHelperImpl.getActionRscPath(j, n, i, paramBoolean, m)[0];
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("{");
      ((StringBuilder)localObject2).append(CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloApiPlayerActionCMSAction$Companion, paramString1, "uin") + ',');
      ((StringBuilder)localObject2).append(CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloApiPlayerActionCMSAction$Companion, paramString2, "model") + ',');
      ((StringBuilder)localObject2).append(CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloApiPlayerActionCMSAction$Companion, "3DObject") + ":{");
      if (localJSONObject != null) {
        ((StringBuilder)localObject2).append(CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloApiPlayerActionCMSAction$Companion, localJSONObject, "faceModel") + ',');
      }
      if ((localJSONArray != null) && (k > 0))
      {
        ((StringBuilder)localObject2).append(CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloApiPlayerActionCMSAction$Companion, localJSONArray, "dress") + ',');
        ((StringBuilder)localObject2).append(String.valueOf(CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloApiPlayerActionCMSAction$Companion, String.valueOf(k), "role")));
      }
      ((StringBuilder)localObject2).append("},");
      if (localApolloBaseInfo != null) {
        ((StringBuilder)localObject2).append(CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloApiPlayerActionCMSAction$Companion, localApolloBaseInfo, "dress") + ',');
      }
      if ((localObject3 != null) && ((localObject3 instanceof Integer))) {
        ((StringBuilder)localObject2).append(CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloApiPlayerActionCMSAction$Companion, ApolloActionHelperImpl.getApolloRsc(0, ((Number)localObject3).intValue()), "role") + ',');
      }
      paramString2 = new StringBuilder();
      if (!paramBoolean) {
        break label964;
      }
    }
    label900:
    label926:
    label964:
    for (paramString1 = CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloApiPlayerActionCMSAction$Companion, Integer.valueOf(1), "isMaster");; paramString1 = CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloApiPlayerActionCMSAction$Companion, Integer.valueOf(0), "isMaster"))
    {
      ((StringBuilder)localObject2).append(paramString1 + ',');
      ((StringBuilder)localObject2).append(String.valueOf(CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloApiPlayerActionCMSAction$Companion, localObject1, "action")));
      ((StringBuilder)localObject2).append("}");
      paramString1 = ((StringBuilder)localObject2).toString();
      Intrinsics.checkExpressionValueIsNotNull(paramString1, "StringBuilder().apply(builderAction).toString()");
      return paramString1;
      label759:
      localObject1 = null;
      break;
      label765:
      localObject1 = localApolloBaseInfo.getApolloDress(false);
      if (localObject1 != null)
      {
        localObject1 = localObject1[0];
        localObject3 = new Object[2];
        if (localObject1 == null) {
          break label900;
        }
      }
      for (localObject2 = Integer.valueOf(((ApolloDress)localObject1).roleId);; localObject2 = null)
      {
        localObject3[0] = localObject2;
        if (localObject1 == null) {
          break label926;
        }
        localObject1 = ((ApolloDress)localObject1).getDressIds();
        if (localObject1 == null) {
          break label926;
        }
        localObject2 = (Collection)new ArrayList(localObject1.length);
        j = localObject1.length;
        i = 0;
        while (i < j)
        {
          n = localObject1[i];
          ((Collection)localObject2).add(CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloApiPlayerActionCMSAction$Companion, ApolloActionHelperImpl.getApolloRsc(1, n)));
          i += 1;
        }
        localObject1 = null;
        break;
      }
      for (localObject1 = (List)localObject2;; localObject1 = null)
      {
        localObject2 = localObject3;
        localObject3[1] = localObject1;
        break;
      }
      if ((localObject3 != null) && ((localObject3 instanceof Integer)))
      {
        i = ((Number)localObject3).intValue();
        break label319;
      }
      i = -1;
      break label319;
    }
  }
  
  private final String e()
  {
    long l1 = System.currentTimeMillis();
    String str1 = f();
    Object localObject = new StringBuilder().append(d()).append('_');
    String str2 = MD5.a(str1);
    Intrinsics.checkExpressionValueIsNotNull(str2, "MD5.toMD5(actionStr)");
    if (str2 == null) {
      throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
    str2 = str2.toLowerCase();
    Intrinsics.checkExpressionValueIsNotNull(str2, "(this as java.lang.String).toLowerCase()");
    localObject = str2;
    long l2 = System.currentTimeMillis();
    QLog.w("CMSPlayer-Action", 1, "genKey key:" + (String)localObject + ", costTime:" + (l2 - l1) + ", detail:" + str1);
    return localObject;
  }
  
  private final String f()
  {
    String str3 = null;
    Object localObject = ApolloActionData.getModelString(a().f);
    String str1;
    String str2;
    StringBuilder localStringBuilder;
    if (a().jdField_a_of_type_JavaLangString != null)
    {
      str1 = a().jdField_a_of_type_JavaLangString;
      Intrinsics.checkExpressionValueIsNotNull(str1, "spriteTask.mSenderUin");
      Intrinsics.checkExpressionValueIsNotNull(localObject, "model");
      str1 = a(str1, (String)localObject, true);
      str2 = str3;
      if (a().e == 1)
      {
        str2 = str3;
        if (a().jdField_b_of_type_JavaLangString != null)
        {
          str2 = a().jdField_b_of_type_JavaLangString;
          Intrinsics.checkExpressionValueIsNotNull(str2, "spriteTask.mRecvUin");
          Intrinsics.checkExpressionValueIsNotNull(localObject, "model");
          str2 = a(str2, (String)localObject, false);
        }
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("{");
      localStringBuilder.append(CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloApiPlayerActionCMSAction$Companion, localObject, "model") + ',');
      localStringBuilder.append(CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloApiPlayerActionCMSAction$Companion, Integer.valueOf(a().f), "actionId") + ',');
      localStringBuilder.append(CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloApiPlayerActionCMSAction$Companion, Integer.valueOf(a().jdField_c_of_type_Int), "actionType") + ',');
      localStringBuilder.append(CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloApiPlayerActionCMSAction$Companion, Integer.valueOf(a().g), "from") + ',');
      localObject = new StringBuilder();
      if (!a().jdField_a_of_type_Boolean) {
        break label590;
      }
    }
    label590:
    for (str3 = CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloApiPlayerActionCMSAction$Companion, Integer.valueOf(1), "isSender");; str3 = CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloApiPlayerActionCMSAction$Companion, Integer.valueOf(0), "isSender"))
    {
      localStringBuilder.append(str3 + ',');
      localStringBuilder.append(CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloApiPlayerActionCMSAction$Companion, "sprites") + ":[");
      if (str1 != null) {
        localStringBuilder.append(str1 + ',');
      }
      if (str2 != null) {
        localStringBuilder.append(String.valueOf(str2));
      }
      localStringBuilder.append("],");
      if (!TextUtils.isEmpty((CharSequence)a().d)) {
        localStringBuilder.append(CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloApiPlayerActionCMSAction$Companion, a().d, "extraMsg") + ',');
      }
      localStringBuilder.append(CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloApiPlayerActionCMSAction$Companion, Boolean.valueOf(a().jdField_c_of_type_Boolean), "needRecordFrame") + ',');
      localStringBuilder.append(String.valueOf(CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloApiPlayerActionCMSAction$Companion, Float.valueOf(a().jdField_b_of_type_Float), "frameTime")));
      localStringBuilder.append("}");
      str1 = localStringBuilder.toString();
      Intrinsics.checkExpressionValueIsNotNull(str1, "StringBuilder().apply(builderAction).toString()");
      return str1;
      str1 = null;
      break;
    }
  }
  
  @NotNull
  public MODE a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerActionMODE;
  }
  
  @NotNull
  public final BusinessConfig a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerModelBusinessConfig;
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
      if (paramString1 != null) {
        this.jdField_a_of_type_JavaLangString = paramString1;
      }
    }
    else
    {
      paramString1 = this.jdField_a_of_type_JavaLangString;
      if (paramString1 == null) {
        Intrinsics.throwNpe();
      }
      return paramString1;
    }
    StringBuilder localStringBuilder = new StringBuilder().append(e());
    if (paramString2 != null) {}
    for (paramString1 = '_' + paramString2;; paramString1 = "")
    {
      paramString1 = paramString1;
      break;
    }
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(@NotNull MODE paramMODE)
  {
    Intrinsics.checkParameterIsNotNull(paramMODE, "<set-?>");
    this.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerActionMODE = paramMODE;
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
  
  public final boolean b()
  {
    if (c() == -1) {}
    do
    {
      return true;
      a(c() - 1);
    } while (c() >= 0);
    return false;
  }
  
  public int c()
  {
    return this.b;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.player.action.CMSAction
 * JD-Core Version:    0.7.0.1
 */