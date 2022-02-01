package com.tencent.mobileqq.apollo.player.action;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.api.ISpriteScriptManager;
import com.tencent.mobileqq.apollo.script.ISpriteTaskHandler;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/mobileqq/apollo/script/SpriteTaskParam;", "invoke"}, k=3, mv={1, 1, 16})
final class CMSCommonAction$spriteTask$2
  extends Lambda
  implements Function0<SpriteTaskParam>
{
  CMSCommonAction$spriteTask$2(CMSCommonAction paramCMSCommonAction)
  {
    super(0);
  }
  
  @NotNull
  public final SpriteTaskParam invoke()
  {
    Object localObject = QRoute.api(IApolloUtil.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "QRoute.api(IApolloUtil::class.java)");
    localObject = ((IApolloUtil)localObject).getAppInterface();
    SpriteTaskParam localSpriteTaskParam = new SpriteTaskParam();
    localSpriteTaskParam.f = CMSCommonAction.a(this.this$0);
    localSpriteTaskParam.jdField_c_of_type_Int = CMSCommonAction.b(this.this$0);
    localSpriteTaskParam.h = 1;
    localSpriteTaskParam.jdField_a_of_type_Boolean = true;
    localSpriteTaskParam.e = (true ^ TextUtils.isEmpty((CharSequence)CMSCommonAction.a(this.this$0)));
    localSpriteTaskParam.jdField_a_of_type_JavaLangString = CMSCommonAction.b(this.this$0);
    localSpriteTaskParam.b = CMSCommonAction.a(this.this$0);
    localSpriteTaskParam.d = CMSCommonAction.c(this.this$0);
    localSpriteTaskParam.jdField_c_of_type_Boolean = this.this$0.a();
    localSpriteTaskParam.jdField_a_of_type_Int = ((ISpriteScriptManager)((AppRuntime)localObject).getRuntimeService(ISpriteScriptManager.class, "all")).getTaskHandler().b();
    return localSpriteTaskParam;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.action.CMSCommonAction.spriteTask.2
 * JD-Core Version:    0.7.0.1
 */