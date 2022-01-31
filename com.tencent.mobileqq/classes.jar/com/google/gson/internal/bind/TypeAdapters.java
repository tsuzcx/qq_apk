package com.google.gson.internal.bind;

import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public final class TypeAdapters
{
  public static final TypeAdapter<AtomicBoolean> ATOMIC_BOOLEAN;
  public static final TypeAdapterFactory ATOMIC_BOOLEAN_FACTORY;
  public static final TypeAdapter<AtomicInteger> ATOMIC_INTEGER;
  public static final TypeAdapter<AtomicIntegerArray> ATOMIC_INTEGER_ARRAY;
  public static final TypeAdapterFactory ATOMIC_INTEGER_ARRAY_FACTORY;
  public static final TypeAdapterFactory ATOMIC_INTEGER_FACTORY;
  public static final TypeAdapter<BigDecimal> BIG_DECIMAL;
  public static final TypeAdapter<BigInteger> BIG_INTEGER;
  public static final TypeAdapter<BitSet> BIT_SET;
  public static final TypeAdapterFactory BIT_SET_FACTORY;
  public static final TypeAdapter<Boolean> BOOLEAN;
  public static final TypeAdapter<Boolean> BOOLEAN_AS_STRING;
  public static final TypeAdapterFactory BOOLEAN_FACTORY;
  public static final TypeAdapter<Number> BYTE;
  public static final TypeAdapterFactory BYTE_FACTORY;
  public static final TypeAdapter<Calendar> CALENDAR;
  public static final TypeAdapterFactory CALENDAR_FACTORY;
  public static final TypeAdapter<Character> CHARACTER;
  public static final TypeAdapterFactory CHARACTER_FACTORY;
  public static final TypeAdapter<Class> CLASS = new TypeAdapters.1().nullSafe();
  public static final TypeAdapterFactory CLASS_FACTORY = newFactory(Class.class, CLASS);
  public static final TypeAdapter<Currency> CURRENCY;
  public static final TypeAdapterFactory CURRENCY_FACTORY;
  public static final TypeAdapter<Number> DOUBLE;
  public static final TypeAdapterFactory ENUM_FACTORY = new TypeAdapters.30();
  public static final TypeAdapter<Number> FLOAT;
  public static final TypeAdapter<InetAddress> INET_ADDRESS;
  public static final TypeAdapterFactory INET_ADDRESS_FACTORY;
  public static final TypeAdapter<Number> INTEGER;
  public static final TypeAdapterFactory INTEGER_FACTORY;
  public static final TypeAdapter<JsonElement> JSON_ELEMENT;
  public static final TypeAdapterFactory JSON_ELEMENT_FACTORY;
  public static final TypeAdapter<Locale> LOCALE;
  public static final TypeAdapterFactory LOCALE_FACTORY;
  public static final TypeAdapter<Number> LONG;
  public static final TypeAdapter<Number> NUMBER;
  public static final TypeAdapterFactory NUMBER_FACTORY;
  public static final TypeAdapter<Number> SHORT;
  public static final TypeAdapterFactory SHORT_FACTORY;
  public static final TypeAdapter<String> STRING;
  public static final TypeAdapter<StringBuffer> STRING_BUFFER;
  public static final TypeAdapterFactory STRING_BUFFER_FACTORY;
  public static final TypeAdapter<StringBuilder> STRING_BUILDER;
  public static final TypeAdapterFactory STRING_BUILDER_FACTORY;
  public static final TypeAdapterFactory STRING_FACTORY;
  public static final TypeAdapterFactory TIMESTAMP_FACTORY;
  public static final TypeAdapter<URI> URI;
  public static final TypeAdapterFactory URI_FACTORY;
  public static final TypeAdapter<URL> URL;
  public static final TypeAdapterFactory URL_FACTORY;
  public static final TypeAdapter<UUID> UUID;
  public static final TypeAdapterFactory UUID_FACTORY;
  
  static
  {
    BIT_SET = new TypeAdapters.2().nullSafe();
    BIT_SET_FACTORY = newFactory(BitSet.class, BIT_SET);
    BOOLEAN = new TypeAdapters.3();
    BOOLEAN_AS_STRING = new TypeAdapters.4();
    BOOLEAN_FACTORY = newFactory(Boolean.TYPE, Boolean.class, BOOLEAN);
    BYTE = new TypeAdapters.5();
    BYTE_FACTORY = newFactory(Byte.TYPE, Byte.class, BYTE);
    SHORT = new TypeAdapters.6();
    SHORT_FACTORY = newFactory(Short.TYPE, Short.class, SHORT);
    INTEGER = new TypeAdapters.7();
    INTEGER_FACTORY = newFactory(Integer.TYPE, Integer.class, INTEGER);
    ATOMIC_INTEGER = new TypeAdapters.8().nullSafe();
    ATOMIC_INTEGER_FACTORY = newFactory(AtomicInteger.class, ATOMIC_INTEGER);
    ATOMIC_BOOLEAN = new TypeAdapters.9().nullSafe();
    ATOMIC_BOOLEAN_FACTORY = newFactory(AtomicBoolean.class, ATOMIC_BOOLEAN);
    ATOMIC_INTEGER_ARRAY = new TypeAdapters.10().nullSafe();
    ATOMIC_INTEGER_ARRAY_FACTORY = newFactory(AtomicIntegerArray.class, ATOMIC_INTEGER_ARRAY);
    LONG = new TypeAdapters.11();
    FLOAT = new TypeAdapters.12();
    DOUBLE = new TypeAdapters.13();
    NUMBER = new TypeAdapters.14();
    NUMBER_FACTORY = newFactory(Number.class, NUMBER);
    CHARACTER = new TypeAdapters.15();
    CHARACTER_FACTORY = newFactory(Character.TYPE, Character.class, CHARACTER);
    STRING = new TypeAdapters.16();
    BIG_DECIMAL = new TypeAdapters.17();
    BIG_INTEGER = new TypeAdapters.18();
    STRING_FACTORY = newFactory(String.class, STRING);
    STRING_BUILDER = new TypeAdapters.19();
    STRING_BUILDER_FACTORY = newFactory(StringBuilder.class, STRING_BUILDER);
    STRING_BUFFER = new TypeAdapters.20();
    STRING_BUFFER_FACTORY = newFactory(StringBuffer.class, STRING_BUFFER);
    URL = new TypeAdapters.21();
    URL_FACTORY = newFactory(URL.class, URL);
    URI = new TypeAdapters.22();
    URI_FACTORY = newFactory(URI.class, URI);
    INET_ADDRESS = new TypeAdapters.23();
    INET_ADDRESS_FACTORY = newTypeHierarchyFactory(InetAddress.class, INET_ADDRESS);
    UUID = new TypeAdapters.24();
    UUID_FACTORY = newFactory(UUID.class, UUID);
    CURRENCY = new TypeAdapters.25().nullSafe();
    CURRENCY_FACTORY = newFactory(Currency.class, CURRENCY);
    TIMESTAMP_FACTORY = new TypeAdapters.26();
    CALENDAR = new TypeAdapters.27();
    CALENDAR_FACTORY = newFactoryForMultipleTypes(Calendar.class, GregorianCalendar.class, CALENDAR);
    LOCALE = new TypeAdapters.28();
    LOCALE_FACTORY = newFactory(Locale.class, LOCALE);
    JSON_ELEMENT = new TypeAdapters.29();
    JSON_ELEMENT_FACTORY = newTypeHierarchyFactory(JsonElement.class, JSON_ELEMENT);
  }
  
  private TypeAdapters()
  {
    throw new UnsupportedOperationException();
  }
  
  public static <TT> TypeAdapterFactory newFactory(TypeToken<TT> paramTypeToken, TypeAdapter<TT> paramTypeAdapter)
  {
    return new TypeAdapters.31(paramTypeToken, paramTypeAdapter);
  }
  
  public static <TT> TypeAdapterFactory newFactory(Class<TT> paramClass, TypeAdapter<TT> paramTypeAdapter)
  {
    return new TypeAdapters.32(paramClass, paramTypeAdapter);
  }
  
  public static <TT> TypeAdapterFactory newFactory(Class<TT> paramClass1, Class<TT> paramClass2, TypeAdapter<? super TT> paramTypeAdapter)
  {
    return new TypeAdapters.33(paramClass1, paramClass2, paramTypeAdapter);
  }
  
  public static <TT> TypeAdapterFactory newFactoryForMultipleTypes(Class<TT> paramClass, Class<? extends TT> paramClass1, TypeAdapter<? super TT> paramTypeAdapter)
  {
    return new TypeAdapters.34(paramClass, paramClass1, paramTypeAdapter);
  }
  
  public static <T1> TypeAdapterFactory newTypeHierarchyFactory(Class<T1> paramClass, TypeAdapter<T1> paramTypeAdapter)
  {
    return new TypeAdapters.35(paramClass, paramTypeAdapter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.google.gson.internal.bind.TypeAdapters
 * JD-Core Version:    0.7.0.1
 */