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
    Object localObject1 = (JsonAdapter)paramField.getAnnotation(JsonAdapter.class);
    if (localObject1 != null) {
      localObject1 = this.jsonAdapterFactory.getTypeAdapter(this.constructorConstructor, paramGson, paramTypeToken, (JsonAdapter)localObject1);
    } else {
      localObject1 = null;
    }
    boolean bool1;
    if (localObject1 != null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = paramGson.getAdapter(paramTypeToken);
    }
    return new ReflectiveTypeAdapterFactory.1(this, paramString, paramBoolean1, paramBoolean2, paramField, bool1, (TypeAdapter)localObject2, paramGson, paramTypeToken, bool2);
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
    Object localObject1 = paramTypeToken;
    while (paramClass != Object.class)
    {
      Field[] arrayOfField = paramClass.getDeclaredFields();
      int m = arrayOfField.length;
      int i = 0;
      while (i < m)
      {
        Field localField = arrayOfField[i];
        boolean bool1 = excludeField(localField, true);
        boolean bool2 = excludeField(localField, false);
        if ((bool1) || (bool2))
        {
          localField.setAccessible(true);
          Type localType2 = .Gson.Types.resolve(((TypeToken)localObject1).getType(), paramClass, localField.getGenericType());
          List localList = getFieldNames(localField);
          int j = localList.size();
          paramTypeToken = null;
          int k = 0;
          while (k < j)
          {
            Object localObject2 = (String)localList.get(k);
            if (k != 0) {
              bool1 = false;
            }
            localObject2 = (ReflectiveTypeAdapterFactory.BoundField)localLinkedHashMap.put(localObject2, createBoundField(paramGson, localField, (String)localObject2, TypeToken.get(localType2), bool1, bool2));
            if (paramTypeToken == null) {
              paramTypeToken = (TypeToken<?>)localObject2;
            }
            k += 1;
          }
          if (paramTypeToken != null) {}
        }
        else
        {
          i += 1;
          continue;
        }
        paramGson = new StringBuilder();
        paramGson.append(localType1);
        paramGson.append(" declares multiple JSON fields named ");
        paramGson.append(paramTypeToken.name);
        throw new IllegalArgumentException(paramGson.toString());
      }
      localObject1 = TypeToken.get(.Gson.Types.resolve(((TypeToken)localObject1).getType(), paramClass, paramClass.getGenericSuperclass()));
      paramClass = ((TypeToken)localObject1).getRawType();
    }
    return localLinkedHashMap;
  }
  
  private List<String> getFieldNames(Field paramField)
  {
    Object localObject = (SerializedName)paramField.getAnnotation(SerializedName.class);
    if (localObject == null) {
      return Collections.singletonList(this.fieldNamingPolicy.translateName(paramField));
    }
    paramField = ((SerializedName)localObject).value();
    localObject = ((SerializedName)localObject).alternate();
    if (localObject.length == 0) {
      return Collections.singletonList(paramField);
    }
    ArrayList localArrayList = new ArrayList(localObject.length + 1);
    localArrayList.add(paramField);
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(localObject[i]);
      i += 1;
    }
    return localArrayList;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.gson.internal.bind.ReflectiveTypeAdapterFactory
 * JD-Core Version:    0.7.0.1
 */