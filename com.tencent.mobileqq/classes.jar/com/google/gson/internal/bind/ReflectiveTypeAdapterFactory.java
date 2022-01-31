package com.google.gson.internal.bind;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal..Gson.Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.Primitives;
import com.google.gson.reflect.TypeToken;
import com.google.gson.reflect.TypeToken<*>;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class ReflectiveTypeAdapterFactory
  implements TypeAdapterFactory
{
  private final ConstructorConstructor constructorConstructor;
  private final Excluder excluder;
  private final FieldNamingStrategy fieldNamingPolicy;
  private final JsonAdapterAnnotationTypeAdapterFactory jsonAdapterFactory;
  
  public ReflectiveTypeAdapterFactory(ConstructorConstructor paramConstructorConstructor, FieldNamingStrategy paramFieldNamingStrategy, Excluder paramExcluder, JsonAdapterAnnotationTypeAdapterFactory paramJsonAdapterAnnotationTypeAdapterFactory)
  {
    this.constructorConstructor = paramConstructorConstructor;
    this.fieldNamingPolicy = paramFieldNamingStrategy;
    this.excluder = paramExcluder;
    this.jsonAdapterFactory = paramJsonAdapterAnnotationTypeAdapterFactory;
  }
  
  private ReflectiveTypeAdapterFactory.BoundField createBoundField(Gson paramGson, Field paramField, String paramString, TypeToken<?> paramTypeToken, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = Primitives.isPrimitive(paramTypeToken.getRawType());
    Object localObject = (JsonAdapter)paramField.getAnnotation(JsonAdapter.class);
    TypeAdapter localTypeAdapter = null;
    if (localObject != null) {
      localTypeAdapter = this.jsonAdapterFactory.getTypeAdapter(this.constructorConstructor, paramGson, paramTypeToken, (JsonAdapter)localObject);
    }
    if (localTypeAdapter != null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      localObject = localTypeAdapter;
      if (localTypeAdapter == null) {
        localObject = paramGson.getAdapter(paramTypeToken);
      }
      return new ReflectiveTypeAdapterFactory.1(this, paramString, paramBoolean1, paramBoolean2, paramField, bool1, (TypeAdapter)localObject, paramGson, paramTypeToken, bool2);
    }
  }
  
  static boolean excludeField(Field paramField, boolean paramBoolean, Excluder paramExcluder)
  {
    return (!paramExcluder.excludeClass(paramField.getType(), paramBoolean)) && (!paramExcluder.excludeField(paramField, paramBoolean));
  }
  
  private Map<String, ReflectiveTypeAdapterFactory.BoundField> getBoundFields(Gson paramGson, TypeToken<?> paramTypeToken, Class<?> paramClass)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    if (paramClass.isInterface()) {
      return localLinkedHashMap;
    }
    Type localType1 = paramTypeToken.getType();
    Object localObject1 = paramClass;
    paramClass = paramTypeToken;
    label94:
    int j;
    if (localObject1 != Object.class)
    {
      Field[] arrayOfField = ((Class)localObject1).getDeclaredFields();
      int k = arrayOfField.length;
      int i = 0;
      for (;;)
      {
        if (i < k)
        {
          Field localField = arrayOfField[i];
          boolean bool1 = excludeField(localField, true);
          boolean bool2 = excludeField(localField, false);
          if ((!bool1) && (!bool2))
          {
            i += 1;
          }
          else
          {
            localField.setAccessible(true);
            Type localType2 = .Gson.Types.resolve(paramClass.getType(), (Class)localObject1, localField.getGenericType());
            List localList = getFieldNames(localField);
            paramTypeToken = null;
            int m = localList.size();
            j = 0;
            label147:
            if (j < m)
            {
              Object localObject2 = (String)localList.get(j);
              if (j != 0) {
                bool1 = false;
              }
              localObject2 = (ReflectiveTypeAdapterFactory.BoundField)localLinkedHashMap.put(localObject2, createBoundField(paramGson, localField, (String)localObject2, TypeToken.get(localType2), bool1, bool2));
              if (paramTypeToken != null) {
                break label293;
              }
              paramTypeToken = (TypeToken<?>)localObject2;
            }
          }
        }
      }
    }
    label293:
    for (;;)
    {
      j += 1;
      break label147;
      if (paramTypeToken == null) {
        break label94;
      }
      throw new IllegalArgumentException(localType1 + " declares multiple JSON fields named " + paramTypeToken.name);
      paramClass = TypeToken.get(.Gson.Types.resolve(paramClass.getType(), (Class)localObject1, ((Class)localObject1).getGenericSuperclass()));
      localObject1 = paramClass.getRawType();
      break;
      return localLinkedHashMap;
    }
  }
  
  private List<String> getFieldNames(Field paramField)
  {
    Object localObject = (SerializedName)paramField.getAnnotation(SerializedName.class);
    if (localObject == null)
    {
      paramField = Collections.singletonList(this.fieldNamingPolicy.translateName(paramField));
      return paramField;
    }
    paramField = ((SerializedName)localObject).value();
    String[] arrayOfString = ((SerializedName)localObject).alternate();
    if (arrayOfString.length == 0) {
      return Collections.singletonList(paramField);
    }
    localObject = new ArrayList(arrayOfString.length + 1);
    ((List)localObject).add(paramField);
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      paramField = (Field)localObject;
      if (i >= j) {
        break;
      }
      ((List)localObject).add(arrayOfString[i]);
      i += 1;
    }
  }
  
  public <T> TypeAdapter<T> create(Gson paramGson, TypeToken<T> paramTypeToken)
  {
    Class localClass = paramTypeToken.getRawType();
    if (!Object.class.isAssignableFrom(localClass)) {
      return null;
    }
    return new ReflectiveTypeAdapterFactory.Adapter(this.constructorConstructor.get(paramTypeToken), getBoundFields(paramGson, paramTypeToken, localClass));
  }
  
  public boolean excludeField(Field paramField, boolean paramBoolean)
  {
    return excludeField(paramField, paramBoolean, this.excluder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.google.gson.internal.bind.ReflectiveTypeAdapterFactory
 * JD-Core Version:    0.7.0.1
 */