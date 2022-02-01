package com.tencent.luggage.wxa.ef;

import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/sdk/wxa_ktx/WxaMmkvProperty$Companion;", "", "()V", "TAG", "", "allSuperclasses", "", "Ljava/lang/Class;", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
final class h$a
{
  private final Collection<Class<?>> a(@NotNull Class<?> paramClass)
  {
    paramClass = paramClass.getSuperclass();
    ArrayList localArrayList = new ArrayList();
    while (paramClass != null)
    {
      localArrayList.add(paramClass);
      paramClass = paramClass.getSuperclass();
    }
    return (Collection)localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ef.h.a
 * JD-Core Version:    0.7.0.1
 */