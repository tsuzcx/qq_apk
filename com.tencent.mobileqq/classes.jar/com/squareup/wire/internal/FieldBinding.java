package com.squareup.wire.internal;

import TB;;
import com.squareup.wire.Message;
import com.squareup.wire.Message.Builder;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoAdapter.Companion;
import com.squareup.wire.WireField;
import com.squareup.wire.WireField.Label;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/squareup/wire/internal/FieldBinding;", "M", "Lcom/squareup/wire/Message;", "B", "Lcom/squareup/wire/Message$Builder;", "", "wireField", "Lcom/squareup/wire/WireField;", "messageField", "Ljava/lang/reflect/Field;", "builderType", "Ljava/lang/Class;", "(Lcom/squareup/wire/WireField;Ljava/lang/reflect/Field;Ljava/lang/Class;)V", "adapter", "Lcom/squareup/wire/ProtoAdapter;", "adapterString", "", "builderField", "builderMethod", "Ljava/lang/reflect/Method;", "declaredName", "getDeclaredName", "()Ljava/lang/String;", "isMap", "", "()Z", "jsonName", "getJsonName", "keyAdapter", "keyAdapterString", "label", "Lcom/squareup/wire/WireField$Label;", "getLabel", "()Lcom/squareup/wire/WireField$Label;", "name", "getName", "redacted", "getRedacted", "singleAdapter", "tag", "", "getTag", "()I", "adapter$wire_runtime", "get", "message", "(Lcom/squareup/wire/Message;)Ljava/lang/Object;", "getBuilderField", "getBuilderMethod", "type", "getFromBuilder", "builder", "getFromBuilder$wire_runtime", "(Lcom/squareup/wire/Message$Builder;)Ljava/lang/Object;", "set", "", "value", "(Lcom/squareup/wire/Message$Builder;Ljava/lang/Object;)V", "value$wire_runtime", "wire-runtime"}, k=1, mv={1, 1, 16})
public final class FieldBinding<M extends Message<M, B>, B extends Message.Builder<M, B>>
{
  private ProtoAdapter<Object> adapter;
  private final String adapterString;
  private final Field builderField;
  private final Method builderMethod;
  @NotNull
  private final String declaredName;
  @NotNull
  private final String jsonName;
  private ProtoAdapter<?> keyAdapter;
  private final String keyAdapterString;
  @NotNull
  private final WireField.Label label;
  private final Field messageField;
  @NotNull
  private final String name;
  private final boolean redacted;
  private ProtoAdapter<?> singleAdapter;
  private final int tag;
  
  public FieldBinding(@NotNull WireField paramWireField, @NotNull Field paramField, @NotNull Class<B> paramClass)
  {
    this.messageField = paramField;
    this.label = paramWireField.label();
    paramField = this.messageField.getName();
    Intrinsics.checkExpressionValueIsNotNull(paramField, "messageField.name");
    this.name = paramField;
    int i = ((CharSequence)paramWireField.declaredName()).length();
    int j = 1;
    if (i == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      paramField = this.messageField.getName();
      Intrinsics.checkExpressionValueIsNotNull(paramField, "messageField.name");
    }
    else
    {
      paramField = paramWireField.declaredName();
    }
    this.declaredName = paramField;
    if (((CharSequence)paramWireField.jsonName()).length() == 0) {
      i = j;
    } else {
      i = 0;
    }
    if (i != 0) {
      paramField = this.declaredName;
    } else {
      paramField = paramWireField.jsonName();
    }
    this.jsonName = paramField;
    this.tag = paramWireField.tag();
    this.keyAdapterString = paramWireField.keyAdapter();
    this.adapterString = paramWireField.adapter();
    this.redacted = paramWireField.redacted();
    this.builderField = getBuilderField(paramClass, this.name);
    paramWireField = this.name;
    paramField = this.messageField.getType();
    Intrinsics.checkExpressionValueIsNotNull(paramField, "messageField.type");
    this.builderMethod = getBuilderMethod(paramClass, paramWireField, paramField);
  }
  
  private final Field getBuilderField(Class<?> paramClass, String paramString)
  {
    try
    {
      localObject = paramClass.getField(paramString);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "builderType.getField(name)");
      return localObject;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      Object localObject;
      label14:
      break label14;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("No builder field ");
    ((StringBuilder)localObject).append(paramClass.getName());
    ((StringBuilder)localObject).append('.');
    ((StringBuilder)localObject).append(paramString);
    throw ((Throwable)new AssertionError(((StringBuilder)localObject).toString()));
  }
  
  private final Method getBuilderMethod(Class<?> paramClass1, String paramString, Class<?> paramClass2)
  {
    try
    {
      localObject = paramClass1.getMethod(paramString, new Class[] { paramClass2 });
      Intrinsics.checkExpressionValueIsNotNull(localObject, "builderType.getMethod(name, type)");
      return localObject;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      Object localObject;
      label25:
      break label25;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("No builder method ");
    ((StringBuilder)localObject).append(paramClass1.getName());
    ((StringBuilder)localObject).append('.');
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append('(');
    ((StringBuilder)localObject).append(paramClass2.getName());
    ((StringBuilder)localObject).append(')');
    throw ((Throwable)new AssertionError(((StringBuilder)localObject).toString()));
  }
  
  @NotNull
  public final ProtoAdapter<Object> adapter$wire_runtime()
  {
    ProtoAdapter localProtoAdapter1 = this.adapter;
    if (localProtoAdapter1 != null) {
      return localProtoAdapter1;
    }
    if (isMap())
    {
      localProtoAdapter1 = keyAdapter();
      if (localProtoAdapter1 != null)
      {
        ProtoAdapter localProtoAdapter2 = singleAdapter();
        if (localProtoAdapter2 != null)
        {
          localProtoAdapter1 = ProtoAdapter.Companion.newMapAdapter(localProtoAdapter1, localProtoAdapter2);
          if (localProtoAdapter1 != null)
          {
            this.adapter = localProtoAdapter1;
            return localProtoAdapter1;
          }
          throw new TypeCastException("null cannot be cast to non-null type com.squareup.wire.ProtoAdapter<kotlin.Any>");
        }
        throw new TypeCastException("null cannot be cast to non-null type com.squareup.wire.ProtoAdapter<kotlin.Any>");
      }
      throw new TypeCastException("null cannot be cast to non-null type com.squareup.wire.ProtoAdapter<kotlin.Any>");
    }
    localProtoAdapter1 = singleAdapter().withLabel$wire_runtime(this.label);
    if (localProtoAdapter1 != null)
    {
      this.adapter = localProtoAdapter1;
      return localProtoAdapter1;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.squareup.wire.ProtoAdapter<kotlin.Any>");
  }
  
  @Nullable
  public final Object get(@NotNull M paramM)
  {
    Intrinsics.checkParameterIsNotNull(paramM, "message");
    return this.messageField.get(paramM);
  }
  
  @NotNull
  public final String getDeclaredName()
  {
    return this.declaredName;
  }
  
  @Nullable
  public final Object getFromBuilder$wire_runtime(@NotNull B paramB)
  {
    Intrinsics.checkParameterIsNotNull(paramB, "builder");
    return this.builderField.get(paramB);
  }
  
  @NotNull
  public final String getJsonName()
  {
    return this.jsonName;
  }
  
  @NotNull
  public final WireField.Label getLabel()
  {
    return this.label;
  }
  
  @NotNull
  public final String getName()
  {
    return this.name;
  }
  
  public final boolean getRedacted()
  {
    return this.redacted;
  }
  
  public final int getTag()
  {
    return this.tag;
  }
  
  public final boolean isMap()
  {
    return ((CharSequence)this.keyAdapterString).length() > 0;
  }
  
  @NotNull
  public final ProtoAdapter<?> keyAdapter()
  {
    ProtoAdapter localProtoAdapter = this.keyAdapter;
    if (localProtoAdapter != null) {
      return localProtoAdapter;
    }
    localProtoAdapter = ProtoAdapter.Companion.get(this.keyAdapterString);
    this.keyAdapter = localProtoAdapter;
    return localProtoAdapter;
  }
  
  public final void set(@NotNull B paramB, @Nullable Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramB, "builder");
    if (this.label.isOneOf())
    {
      this.builderMethod.invoke(paramB, new Object[] { paramObject });
      return;
    }
    this.builderField.set(paramB, paramObject);
  }
  
  @NotNull
  public final ProtoAdapter<?> singleAdapter()
  {
    ProtoAdapter localProtoAdapter = this.singleAdapter;
    if (localProtoAdapter != null) {
      return localProtoAdapter;
    }
    localProtoAdapter = ProtoAdapter.Companion.get(this.adapterString);
    this.singleAdapter = localProtoAdapter;
    return localProtoAdapter;
  }
  
  public final void value$wire_runtime(@NotNull B paramB, @NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramB, "builder");
    Intrinsics.checkParameterIsNotNull(paramObject, "value");
    boolean bool = this.label.isRepeated();
    Object localObject2 = null;
    Object localObject1 = null;
    if (bool)
    {
      localObject2 = getFromBuilder$wire_runtime(paramB);
      if (TypeIntrinsics.isMutableList(localObject2))
      {
        if (localObject2 != null)
        {
          TypeIntrinsics.asMutableList(localObject2).add(paramObject);
          return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableList<kotlin.Any>");
      }
      if ((localObject2 instanceof List))
      {
        localObject1 = CollectionsKt.toMutableList((Collection)localObject2);
        ((List)localObject1).add(paramObject);
        set(paramB, localObject1);
        return;
      }
      paramB = (TB)localObject1;
      if (localObject2 != null) {
        paramB = localObject2.getClass();
      }
      paramObject = new StringBuilder();
      paramObject.append("Expected a list type, got ");
      paramObject.append(paramB);
      paramObject.append('.');
      throw ((Throwable)new ClassCastException(paramObject.toString()));
    }
    int i;
    if (((CharSequence)this.keyAdapterString).length() > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      localObject1 = getFromBuilder$wire_runtime(paramB);
      if (TypeIntrinsics.isMutableMap(localObject1))
      {
        ((Map)localObject1).putAll((Map)paramObject);
        return;
      }
      if ((localObject1 instanceof Map))
      {
        localObject1 = MapsKt.toMutableMap((Map)localObject1);
        ((Map)localObject1).putAll((Map)paramObject);
        set(paramB, localObject1);
        return;
      }
      paramB = localObject2;
      if (localObject1 != null) {
        paramB = localObject1.getClass();
      }
      paramObject = new StringBuilder();
      paramObject.append("Expected a map type, got ");
      paramObject.append(paramB);
      paramObject.append('.');
      throw ((Throwable)new ClassCastException(paramObject.toString()));
    }
    set(paramB, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.squareup.wire.internal.FieldBinding
 * JD-Core Version:    0.7.0.1
 */