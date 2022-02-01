package com.tencent.biz.pubaccount.readinjoy.proteus.utils;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.CustomMethodsRegister.CustomMethodInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.service.message.EmotionCodecUtils;
import com.tencent.mobileqq.text.QQText;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/proteus/utils/RIJProteusCustomMethod;", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/utils/CustomMethodsRegister$CustomMethodInterface;", "()V", "cmd", "", "data", "", "", "getData", "()[Ljava/lang/Object;", "setData", "([Ljava/lang/Object;)V", "[Ljava/lang/Object;", "methodsMap", "", "Lkotlin/Function0;", "decodeEmotion", "", "getFirstItem", "hyperLinkJump", "", "invoke", "c", "d", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;", "registerMethod", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJProteusCustomMethod
  implements CustomMethodsRegister.CustomMethodInterface
{
  public static final RIJProteusCustomMethod a;
  private static String jdField_a_of_type_JavaLangString;
  private static final Map<String, Function0<Object>> jdField_a_of_type_JavaUtilMap;
  @Nullable
  private static Object[] jdField_a_of_type_ArrayOfJavaLangObject;
  
  static
  {
    RIJProteusCustomMethod localRIJProteusCustomMethod = new RIJProteusCustomMethod();
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusUtilsRIJProteusCustomMethod = localRIJProteusCustomMethod;
    jdField_a_of_type_JavaUtilMap = (Map)new LinkedHashMap();
    localRIJProteusCustomMethod.a();
  }
  
  private final CharSequence a()
  {
    Object localObject = a();
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
    }
    return (CharSequence)new QQText((CharSequence)localObject, 3, 16);
  }
  
  private final Object a()
  {
    Object localObject1 = null;
    Object localObject2 = null;
    Object[] arrayOfObject = jdField_a_of_type_ArrayOfJavaLangObject;
    if (arrayOfObject != null)
    {
      localObject1 = localObject2;
      if (arrayOfObject.length >= 1) {
        localObject1 = EmotionCodecUtils.b(arrayOfObject[0].toString());
      }
    }
    return localObject1;
  }
  
  private final void a()
  {
    jdField_a_of_type_JavaUtilMap.put("decodeEmotion", RIJProteusCustomMethod.registerMethod.1.INSTANCE);
    jdField_a_of_type_JavaUtilMap.put("HyperLinkClick", RIJProteusCustomMethod.registerMethod.2.INSTANCE);
  }
  
  private final void b()
  {
    Object localObject = a();
    Context localContext = (Context)BaseApplicationImpl.getContext();
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
    }
    RIJJumpUtils.a(localContext, (String)localObject);
  }
  
  @NotNull
  public Object invoke(@Nullable String paramString, @NotNull Object... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "d");
    jdField_a_of_type_JavaLangString = paramString;
    jdField_a_of_type_ArrayOfJavaLangObject = new Object[] { paramVarArgs };
    paramString = (Function0)jdField_a_of_type_JavaUtilMap.get(jdField_a_of_type_JavaLangString);
    if (paramString != null)
    {
      paramString = paramString.invoke();
      if (paramString != null) {
        return paramString;
      }
    }
    return new Object();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.utils.RIJProteusCustomMethod
 * JD-Core Version:    0.7.0.1
 */