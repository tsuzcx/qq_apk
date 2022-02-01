package com.tencent.mobileqq.apollo.player.action;

import amvo;
import anci;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/mobileqq/apollo/script/SpriteTaskParam;", "invoke"}, k=3, mv={1, 1, 16})
public final class CMSCommonAction$spriteTask$2
  extends Lambda
  implements Function0<SpriteTaskParam>
{
  public CMSCommonAction$spriteTask$2(amvo paramamvo)
  {
    super(0);
  }
  
  @NotNull
  public final SpriteTaskParam invoke()
  {
    int i = 1;
    SpriteTaskParam localSpriteTaskParam = new SpriteTaskParam();
    localSpriteTaskParam.f = amvo.a(this.this$0);
    localSpriteTaskParam.jdField_c_of_type_Int = amvo.b(this.this$0);
    localSpriteTaskParam.h = 1;
    localSpriteTaskParam.jdField_a_of_type_Boolean = true;
    if (amvo.a(this.this$0) != null) {}
    for (;;)
    {
      localSpriteTaskParam.e = i;
      localSpriteTaskParam.jdField_a_of_type_JavaLangString = amvo.b(this.this$0);
      localSpriteTaskParam.b = amvo.a(this.this$0);
      localSpriteTaskParam.d = amvo.c(this.this$0);
      localSpriteTaskParam.jdField_c_of_type_Boolean = this.this$0.a();
      anci.jdField_a_of_type_Int += 1;
      localSpriteTaskParam.jdField_a_of_type_Int = anci.jdField_a_of_type_Int;
      return localSpriteTaskParam;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.action.CMSCommonAction.spriteTask.2
 * JD-Core Version:    0.7.0.1
 */