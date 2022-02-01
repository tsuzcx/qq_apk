package com.tencent.mobileqq.apollo.meme.action;

import com.tencent.mobileqq.cmshow.engine.action.ActionStatus;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ObservableProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class MemeAction$$special$$inlined$observable$1
  extends ObservableProperty<ActionStatus>
{
  public MemeAction$$special$$inlined$observable$1(Object paramObject1, Object paramObject2, MemeAction paramMemeAction)
  {
    super(paramObject2);
  }
  
  protected void afterChange(@NotNull KProperty<?> paramKProperty, ActionStatus paramActionStatus1, ActionStatus paramActionStatus2)
  {
    Intrinsics.checkParameterIsNotNull(paramKProperty, "property");
    paramKProperty = (ActionStatus)paramActionStatus2;
    paramActionStatus1 = (ActionStatus)paramActionStatus1;
    if ((Intrinsics.areEqual(paramKProperty, paramActionStatus1) ^ true))
    {
      paramActionStatus2 = new StringBuilder();
      paramActionStatus2.append(this.b.h());
      paramActionStatus2.append(" actionStatus change from:");
      paramActionStatus2.append(paramActionStatus1);
      paramActionStatus2.append(" to:");
      paramActionStatus2.append(paramKProperty);
      QLog.i("[cmshow][MemePlayer-Action]", 1, paramActionStatus2.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.meme.action.MemeAction..special..inlined.observable.1
 * JD-Core Version:    0.7.0.1
 */