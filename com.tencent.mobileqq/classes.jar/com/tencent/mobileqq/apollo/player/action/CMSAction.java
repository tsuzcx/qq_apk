package com.tencent.mobileqq.apollo.player.action;

import amme;
import amve;
import ancd;
import android.text.TextUtils;
import anex;
import anhm;
import bjkp;
import com.tencent.mobileqq.apollo.data.ApolloDress;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloBaseInfo;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/player/action/CMSAction;", "", "needRecord", "", "priority", "", "playAmountTimes", "(ZII)V", "_recordKey", "", "get_recordKey", "()Ljava/lang/String;", "set_recordKey", "(Ljava/lang/String;)V", "desc", "getDesc$AQQLiteApp_release", "desc$delegate", "Lkotlin/Lazy;", "id", "getId$AQQLiteApp_release", "mode", "Lcom/tencent/mobileqq/apollo/player/action/CMSAction$Companion$MODE;", "getMode$AQQLiteApp_release", "()Lcom/tencent/mobileqq/apollo/player/action/CMSAction$Companion$MODE;", "setMode$AQQLiteApp_release", "(Lcom/tencent/mobileqq/apollo/player/action/CMSAction$Companion$MODE;)V", "name", "getName$AQQLiteApp_release", "getNeedRecord", "()Z", "setNeedRecord", "(Z)V", "getPlayAmountTimes", "()I", "setPlayAmountTimes", "(I)V", "getPriority", "spriteTask", "Lcom/tencent/mobileqq/apollo/script/SpriteTaskParam;", "getSpriteTask$AQQLiteApp_release", "()Lcom/tencent/mobileqq/apollo/script/SpriteTaskParam;", "genKey", "genKeyPerf", "genSpriteDesc", "uin", "model", "isMaster", "getId", "getKey", "priorityKey", "external", "playAgain", "playAgain$AQQLiteApp_release", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract class CMSAction
{
  public static final CMSAction.Companion a;
  private final int jdField_a_of_type_Int;
  @NotNull
  private CMSAction.Companion.MODE jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction$Companion$MODE;
  @Nullable
  private volatile String jdField_a_of_type_JavaLangString;
  @NotNull
  private final Lazy jdField_a_of_type_KotlinLazy;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction$Companion = new CMSAction.Companion(null);
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
    this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction$Companion$MODE = CMSAction.Companion.MODE.ACTION_MODE_PLAY;
  }
  
  private final String a(String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject1 = amve.a.a();
    if (localObject1 != null)
    {
      localObject2 = ((QQAppInterface)localObject1).getManager(QQManagerFactory.APOLLO_MANAGER);
      if (localObject2 == null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.apollo.ApolloManager");
      }
    }
    else
    {
      return null;
    }
    Object localObject2 = ((amme)localObject2).b(paramString1);
    JSONObject localJSONObject;
    JSONArray localJSONArray;
    int k;
    int m;
    if (localObject2 != null)
    {
      localJSONObject = ((ApolloBaseInfo)localObject2).getFaceModel(false, (QQAppInterface)localObject1);
      localJSONArray = ((ApolloBaseInfo)localObject2).getDress3D(false, (QQAppInterface)localObject1);
      k = ((ApolloBaseInfo)localObject2).getRole3D(false, (QQAppInterface)localObject1);
      m = amme.a((QQAppInterface)localObject1, paramString1);
      if (amme.a((ApolloBaseInfo)localObject2)) {
        break label715;
      }
      if (!ancd.b((QQAppInterface)localObject1, paramString1)) {
        break label194;
      }
    }
    label194:
    for (int i = 2;; i = 1)
    {
      localObject1 = anex.a(i);
      if (localObject1 == null) {
        break label709;
      }
      localObject2 = (Collection)new ArrayList(localObject1.length);
      n = localObject1.length;
      j = 0;
      while (j < n)
      {
        int i1 = localObject1[j];
        ((Collection)localObject2).add(CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction$Companion, anhm.a(1, i1)));
        j += 1;
      }
      return null;
    }
    localObject1 = (List)localObject2;
    localObject2 = new Object[2];
    localObject2[0] = Integer.valueOf(i);
    localObject2[1] = localObject1;
    Object[] arrayOfObject = localObject2[0];
    Object localObject3 = localObject2[1];
    int j = a().k;
    int n = a().f;
    if (Intrinsics.areEqual(paramString2, "3D"))
    {
      i = k;
      label271:
      localObject1 = anhm.a(j, n, i, paramBoolean, m)[0];
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("{");
      ((StringBuilder)localObject2).append(CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction$Companion, paramString1, "uin") + ',');
      ((StringBuilder)localObject2).append(CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction$Companion, paramString2, "model") + ',');
      ((StringBuilder)localObject2).append(CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction$Companion, "3DObject") + ":{");
      if (localJSONObject != null) {
        ((StringBuilder)localObject2).append(CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction$Companion, localJSONObject, "faceModel") + ',');
      }
      if ((localJSONArray != null) && (k > 0))
      {
        ((StringBuilder)localObject2).append(CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction$Companion, localJSONArray, "dress") + ',');
        ((StringBuilder)localObject2).append(String.valueOf(CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction$Companion, String.valueOf(k), "role")));
      }
      ((StringBuilder)localObject2).append("},");
      if (localObject3 != null) {
        ((StringBuilder)localObject2).append(CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction$Companion, localObject3, "dress") + ',');
      }
      if ((arrayOfObject != null) && ((arrayOfObject instanceof Integer))) {
        ((StringBuilder)localObject2).append(CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction$Companion, anhm.a(0, ((Number)arrayOfObject).intValue()), "role") + ',');
      }
      paramString2 = new StringBuilder();
      if (!paramBoolean) {
        break label914;
      }
    }
    label914:
    for (paramString1 = CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction$Companion, Integer.valueOf(1), "isMaster");; paramString1 = CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction$Companion, Integer.valueOf(0), "isMaster"))
    {
      ((StringBuilder)localObject2).append(paramString1 + ',');
      ((StringBuilder)localObject2).append(String.valueOf(CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction$Companion, localObject1, "action")));
      ((StringBuilder)localObject2).append("}");
      paramString1 = ((StringBuilder)localObject2).toString();
      Intrinsics.checkExpressionValueIsNotNull(paramString1, "StringBuilder().apply(builderAction).toString()");
      return paramString1;
      label709:
      localObject1 = null;
      break;
      label715:
      localObject1 = ((ApolloBaseInfo)localObject2).getApolloDress(false);
      if (localObject1 != null)
      {
        localObject1 = localObject1[0];
        arrayOfObject = new Object[2];
        if (localObject1 == null) {
          break label850;
        }
      }
      label850:
      for (localObject2 = Integer.valueOf(((ApolloDress)localObject1).jdField_a_of_type_Int);; localObject2 = null)
      {
        arrayOfObject[0] = localObject2;
        if (localObject1 == null) {
          break label876;
        }
        localObject1 = ((ApolloDress)localObject1).a();
        if (localObject1 == null) {
          break label876;
        }
        localObject2 = (Collection)new ArrayList(localObject1.length);
        j = localObject1.length;
        i = 0;
        while (i < j)
        {
          n = localObject1[i];
          ((Collection)localObject2).add(CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction$Companion, anhm.a(1, n)));
          i += 1;
        }
        localObject1 = null;
        break;
      }
      label876:
      for (localObject1 = (List)localObject2;; localObject1 = null)
      {
        localObject2 = arrayOfObject;
        arrayOfObject[1] = localObject1;
        break;
      }
      if ((arrayOfObject != null) && ((arrayOfObject instanceof Integer)))
      {
        i = ((Number)arrayOfObject).intValue();
        break label271;
      }
      i = -1;
      break label271;
    }
  }
  
  private final String e()
  {
    long l1 = System.currentTimeMillis();
    String str1 = f();
    Object localObject = new StringBuilder().append(c()).append('_');
    String str2 = bjkp.a(str1);
    Intrinsics.checkExpressionValueIsNotNull(str2, "MD5.toMD5(actionStr)");
    if (str2 == null) {
      throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
    str2 = str2.toLowerCase();
    Intrinsics.checkExpressionValueIsNotNull(str2, "(this as java.lang.String).toLowerCase()");
    localObject = str2;
    long l2 = System.currentTimeMillis();
    QLog.w("cmshow_scripted_[CMSPlayer]", 1, "genKey key:" + (String)localObject + ", costTime:" + (l2 - l1) + ", detail:" + str1);
    return localObject;
  }
  
  private final String f()
  {
    String str2 = ApolloActionData.getModelString(a().f);
    String str1 = a().jdField_a_of_type_JavaLangString;
    Intrinsics.checkExpressionValueIsNotNull(str1, "spriteTask.mSenderUin");
    Intrinsics.checkExpressionValueIsNotNull(str2, "model");
    String str3 = a(str1, str2, true);
    StringBuilder localStringBuilder1;
    StringBuilder localStringBuilder2;
    if (a().e == 1)
    {
      str1 = a().jdField_b_of_type_JavaLangString;
      Intrinsics.checkExpressionValueIsNotNull(str1, "spriteTask.mRecvUin");
      str1 = a(str1, str2, false);
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("{");
      localStringBuilder1.append(CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction$Companion, str2, "model") + ',');
      localStringBuilder1.append(CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction$Companion, Integer.valueOf(a().f), "actionId") + ',');
      localStringBuilder1.append(CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction$Companion, Integer.valueOf(a().jdField_c_of_type_Int), "actionType") + ',');
      localStringBuilder1.append(CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction$Companion, Integer.valueOf(a().g), "from") + ',');
      localStringBuilder2 = new StringBuilder();
      if (!a().jdField_a_of_type_Boolean) {
        break label550;
      }
    }
    label550:
    for (str2 = CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction$Companion, Integer.valueOf(1), "isSender");; str2 = CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction$Companion, Integer.valueOf(0), "isSender"))
    {
      localStringBuilder1.append(str2 + ',');
      localStringBuilder1.append(CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction$Companion, "sprites") + ":[");
      if (str3 != null) {
        localStringBuilder1.append(str3 + ',');
      }
      if (str1 != null) {
        localStringBuilder1.append(String.valueOf(str1));
      }
      localStringBuilder1.append("],");
      if (!TextUtils.isEmpty((CharSequence)a().d)) {
        localStringBuilder1.append(CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction$Companion, a().d, "extraMsg") + ',');
      }
      localStringBuilder1.append(CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction$Companion, Boolean.valueOf(a().jdField_c_of_type_Boolean), "needRecordFrame") + ',');
      localStringBuilder1.append(String.valueOf(CMSAction.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction$Companion, Float.valueOf(a().jdField_b_of_type_Float), "frameTime")));
      localStringBuilder1.append("}");
      str1 = localStringBuilder1.toString();
      Intrinsics.checkExpressionValueIsNotNull(str1, "StringBuilder().apply(builderAction).toString()");
      return str1;
      str1 = null;
      break;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @NotNull
  public final CMSAction.Companion.MODE a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction$Companion$MODE;
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
  
  public final void a(@NotNull CMSAction.Companion.MODE paramMODE)
  {
    Intrinsics.checkParameterIsNotNull(paramMODE, "<set-?>");
    this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction$Companion$MODE = paramMODE;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int b()
  {
    return this.b;
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
  
  @NotNull
  public final String d()
  {
    return (String)this.jdField_a_of_type_KotlinLazy.getValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.action.CMSAction
 * JD-Core Version:    0.7.0.1
 */