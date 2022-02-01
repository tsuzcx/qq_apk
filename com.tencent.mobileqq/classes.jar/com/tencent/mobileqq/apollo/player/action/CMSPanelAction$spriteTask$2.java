package com.tencent.mobileqq.apollo.player.action;

import amvp;
import anci;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.data.ApolloActionData;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/mobileqq/apollo/script/SpriteTaskParam;", "invoke"}, k=3, mv={1, 1, 16})
public final class CMSPanelAction$spriteTask$2
  extends Lambda
  implements Function0<SpriteTaskParam>
{
  public CMSPanelAction$spriteTask$2(amvp paramamvp)
  {
    super(0);
  }
  
  @NotNull
  public final SpriteTaskParam invoke()
  {
    SpriteTaskParam localSpriteTaskParam = new SpriteTaskParam();
    localSpriteTaskParam.f = this.this$0.a().actionId;
    localSpriteTaskParam.jdField_c_of_type_Int = this.this$0.a().actionType;
    localSpriteTaskParam.h = 1;
    localSpriteTaskParam.jdField_a_of_type_Boolean = true;
    localSpriteTaskParam.e = this.this$0.a().personNum;
    localSpriteTaskParam.jdField_a_of_type_JavaLangString = this.this$0.e();
    String str;
    if (this.this$0.a().personNum != 0)
    {
      str = this.this$0.f();
      if (str == null) {}
    }
    for (;;)
    {
      localSpriteTaskParam.b = str;
      localSpriteTaskParam.k = 15;
      localSpriteTaskParam.jdField_c_of_type_Boolean = this.this$0.a();
      anci.jdField_a_of_type_Int += 1;
      localSpriteTaskParam.jdField_a_of_type_Int = anci.jdField_a_of_type_Int;
      return localSpriteTaskParam;
      str = "-1";
      continue;
      str = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.action.CMSPanelAction.spriteTask.2
 * JD-Core Version:    0.7.0.1
 */