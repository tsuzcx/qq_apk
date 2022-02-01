package com.tencent.luggage.wxa.fq;

import android.os.Build.VERSION;
import com.tencent.luggage.wxa.qz.o;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.joor.Reflect;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxaapi/internal/ReflectHelper;", "", "()V", "TAG", "", "field0", "Ljava/lang/reflect/Field;", "clazz", "Ljava/lang/Class;", "name", "setFieldValue", "", "object", "fieldName", "value", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class e
{
  public static final e a = new e();
  
  private final Field a(Class<?> paramClass, String paramString)
  {
    if (paramClass == null) {}
    label32:
    label209:
    do
    {
      try
      {
        Intrinsics.throwNpe();
        localObject1 = Reflect.accessible((AccessibleObject)paramClass.getField(paramString));
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "Reflect.accessible(t!!.getField(name))");
        localObject1 = (Field)localObject1;
        return localObject1;
      }
      catch (NoSuchFieldException localNoSuchFieldException1)
      {
        Object localObject1;
        StringBuilder localStringBuilder;
        Object localObject2;
        Class localClass;
        break label32;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("class info, name: ");
      if (paramClass == null) {
        Intrinsics.throwNpe();
      }
      localStringBuilder.append(paramClass.getName());
      localStringBuilder.append(", classLoader: ");
      localStringBuilder.append(paramClass.getClassLoader());
      localStringBuilder.append(", classLoader parent: ");
      localObject1 = paramClass.getClassLoader();
      localObject2 = null;
      if (localObject1 != null) {
        localObject1 = ((ClassLoader)localObject1).getParent();
      } else {
        localObject1 = null;
      }
      localStringBuilder.append(localObject1);
      localStringBuilder.append(", superClass:");
      localStringBuilder.append(paramClass.getSuperclass());
      localStringBuilder.append(", superClass classLoader:");
      localClass = paramClass.getSuperclass();
      localObject1 = localObject2;
      if (localClass != null) {
        localObject1 = localClass.getClassLoader();
      }
      localStringBuilder.append(localObject1);
      o.d("Luggage.ReflectHelper", localStringBuilder.toString());
      try
      {
        localObject1 = Reflect.accessible((AccessibleObject)paramClass.getDeclaredField(paramString));
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "Reflect.accessible(t.getDeclaredField(name))");
        localObject1 = (Field)localObject1;
        return localObject1;
      }
      catch (NoSuchFieldException localNoSuchFieldException2)
      {
        break label209;
      }
      paramClass = paramClass.getSuperclass();
    } while (paramClass != null);
    paramClass = (Throwable)new NoSuchFieldException();
    for (;;)
    {
      throw paramClass;
    }
  }
  
  public final void a(@NotNull Object paramObject1, @NotNull String paramString, @NotNull Object paramObject2)
  {
    Intrinsics.checkParameterIsNotNull(paramObject1, "object");
    Intrinsics.checkParameterIsNotNull(paramString, "fieldName");
    Intrinsics.checkParameterIsNotNull(paramObject2, "value");
    paramString = a(paramObject1.getClass(), paramString);
    if ((paramString.getModifiers() & 0x10) == 16) {}
    try
    {
      localField = Field.class.getDeclaredField("modifiers");
      Intrinsics.checkExpressionValueIsNotNull(localField, "modifiersField");
      localField.setAccessible(true);
      localField.setInt(paramString, paramString.getModifiers() & 0xFFFFFFEF);
    }
    catch (Exception localException)
    {
      Field localField;
      label78:
      break label78;
    }
    if (Build.VERSION.SDK_INT > 22) {
      try
      {
        localField = Field.class.getDeclaredField("accessFlags");
        Intrinsics.checkExpressionValueIsNotNull(localField, "accessFlagsField");
        localField.setAccessible(true);
        localField.setInt(paramString, paramString.getModifiers() & 0xFFFFFFEF);
      }
      catch (Exception paramObject1)
      {
        throw ((Throwable)new Exception((Throwable)paramObject1));
      }
    }
    paramString.set(paramObject1, paramObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fq.e
 * JD-Core Version:    0.7.0.1
 */