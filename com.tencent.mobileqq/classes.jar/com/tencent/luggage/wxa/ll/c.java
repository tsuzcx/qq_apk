package com.tencent.luggage.wxa.ll;

import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.util.Base64;
import com.tencent.luggage.wxa.pd.p;
import com.tencent.luggage.wxa.qz.o;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Pair<+Ljava.util.Map<Ljava.lang.String;+Ljava.lang.Object;>;+Ljava.nio.ByteBuffer;>;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/NdefMessageConverter;", "", "()V", "MAP_KEY_MESSAGES", "", "MAP_KEY_RECORDS", "NDEF_RECORD_FIELD_ID", "NDEF_RECORD_FIELD_PAYLOAD", "NDEF_RECORD_FIELD_TNF", "NDEF_RECORD_FIELD_TYPE", "PARAM_LANGUAGE", "PARAM_TEXT", "TAG", "map2Message", "Landroid/nfc/NdefMessage;", "messageMap", "", "message2MessageMap", "Lkotlin/Pair;", "", "Ljava/nio/ByteBuffer;", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/MessageMap;", "message", "messages2Map", "messages", "record2RecordMap", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/RecordMap;", "record", "Landroid/nfc/NdefRecord;", "recordMap2Record", "recordMap", "texts2Message", "textAndLanguages", "uris2Message", "uris", "luggage-commons-jsapi-nfc-ext_release"}, k=1, mv={1, 1, 16})
public final class c
{
  public static final c a = new c();
  
  private final NdefRecord a(Pair<? extends Map<String, ? extends Object>, ? extends ByteBuffer> paramPair)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("recordMap2Record, recordMap: ");
    ((StringBuilder)localObject1).append(paramPair);
    o.e("MicroMsg.AppBrand.NdefMessageConverter", ((StringBuilder)localObject1).toString());
    Object localObject2 = (Map)paramPair.component1();
    ByteBuffer localByteBuffer = (ByteBuffer)paramPair.component2();
    localObject1 = ((Map)localObject2).get("tnf");
    paramPair = (Pair<? extends Map<String, ? extends Object>, ? extends ByteBuffer>)localObject1;
    if (!(localObject1 instanceof Integer)) {
      paramPair = null;
    }
    paramPair = (Integer)paramPair;
    if (paramPair != null)
    {
      int i = paramPair.intValue();
      localObject1 = ((Map)localObject2).get("type");
      paramPair = (Pair<? extends Map<String, ? extends Object>, ? extends ByteBuffer>)localObject1;
      if (!(localObject1 instanceof String)) {
        paramPair = null;
      }
      paramPair = (String)paramPair;
      if (paramPair != null) {
        paramPair = Base64.decode(paramPair, 2);
      } else {
        paramPair = null;
      }
      localObject2 = ((Map)localObject2).get("id");
      localObject1 = localObject2;
      if (!(localObject2 instanceof String)) {
        localObject1 = null;
      }
      localObject1 = (String)localObject1;
      if (localObject1 != null) {
        localObject1 = Base64.decode((String)localObject1, 2);
      } else {
        localObject1 = null;
      }
      try
      {
        paramPair = new NdefRecord((short)i, paramPair, (byte[])localObject1, com.tencent.luggage.wxa.pc.c.a(localByteBuffer));
        return paramPair;
      }
      catch (Exception paramPair)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("recordMap2Record failed since ");
        ((StringBuilder)localObject1).append(paramPair);
        o.c("MicroMsg.AppBrand.NdefMessageConverter", ((StringBuilder)localObject1).toString());
      }
    }
    return null;
  }
  
  private final Pair<List<Map<String, Object>>, List<ByteBuffer>> a(NdefMessage paramNdefMessage)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("message2MessageMap, message: ");
    ((StringBuilder)localObject1).append(paramNdefMessage);
    o.e("MicroMsg.AppBrand.NdefMessageConverter", ((StringBuilder)localObject1).toString());
    paramNdefMessage = paramNdefMessage.getRecords();
    Intrinsics.checkExpressionValueIsNotNull(paramNdefMessage, "message.records");
    localObject1 = (Collection)new ArrayList(paramNdefMessage.length);
    int j = paramNdefMessage.length;
    int i = 0;
    while (i < j)
    {
      localObject2 = paramNdefMessage[i];
      c localc = a;
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "it");
      ((Collection)localObject1).add(localc.a((NdefRecord)localObject2));
      i += 1;
    }
    paramNdefMessage = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault(paramNdefMessage, 10));
    Object localObject2 = paramNdefMessage.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add((Map)((Pair)((Iterator)localObject2).next()).getFirst());
    }
    localObject1 = (List)localObject1;
    localObject2 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault(paramNdefMessage, 10));
    paramNdefMessage = paramNdefMessage.iterator();
    while (paramNdefMessage.hasNext()) {
      ((Collection)localObject2).add((ByteBuffer)((Pair)paramNdefMessage.next()).getSecond());
    }
    paramNdefMessage = TuplesKt.to(localObject1, (List)localObject2);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("message2MessageMap, messageMap: ");
    ((StringBuilder)localObject1).append(paramNdefMessage);
    o.e("MicroMsg.AppBrand.NdefMessageConverter", ((StringBuilder)localObject1).toString());
    return paramNdefMessage;
  }
  
  private final Pair<Map<String, Object>, ByteBuffer> a(NdefRecord paramNdefRecord)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("record2RecordMap, record: ");
    ((StringBuilder)localObject1).append(paramNdefRecord);
    o.e("MicroMsg.AppBrand.NdefMessageConverter", ((StringBuilder)localObject1).toString());
    localObject1 = TuplesKt.to("tnf", Short.valueOf(paramNdefRecord.getTnf()));
    Object localObject2 = Base64.encode(paramNdefRecord.getType(), 2);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "Base64.encode(record.type, Base64.NO_WRAP)");
    Object localObject3 = StandardCharsets.UTF_8;
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "StandardCharsets.UTF_8");
    localObject2 = TuplesKt.to("type", new String((byte[])localObject2, (Charset)localObject3));
    localObject3 = Base64.encode(paramNdefRecord.getId(), 2);
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "Base64.encode(record.id, Base64.NO_WRAP)");
    Charset localCharset = StandardCharsets.UTF_8;
    Intrinsics.checkExpressionValueIsNotNull(localCharset, "StandardCharsets.UTF_8");
    localObject1 = MapsKt.mapOf(new Pair[] { localObject1, localObject2, TuplesKt.to("id", new String((byte[])localObject3, localCharset)) });
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("record2RecordMap, map: ");
    ((StringBuilder)localObject2).append(localObject1);
    o.e("MicroMsg.AppBrand.NdefMessageConverter", ((StringBuilder)localObject2).toString());
    return TuplesKt.to(localObject1, p.a(paramNdefRecord.getPayload()));
  }
  
  @Nullable
  public final NdefMessage a(@NotNull Map<String, ? extends Object> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "messageMap");
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("map2Message, messageMap: ");
    ((StringBuilder)localObject1).append(paramMap);
    o.e("MicroMsg.AppBrand.NdefMessageConverter", ((StringBuilder)localObject1).toString());
    Object localObject2 = paramMap.get("records");
    localObject1 = localObject2;
    if (!(localObject2 instanceof List)) {
      localObject1 = null;
    }
    localObject1 = (List)localObject1;
    if (localObject1 != null)
    {
      localObject1 = (Iterable)localObject1;
      Collection localCollection = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject1, 10));
      Iterator localIterator = ((Iterable)localObject1).iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        localObject1 = localIterator.next();
        if (i < 0) {
          CollectionsKt.throwIndexOverflow();
        }
        Map localMap = (Map)localObject1;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("map2Message, index: ");
        ((StringBuilder)localObject1).append(i);
        ((StringBuilder)localObject1).append(", map: ");
        ((StringBuilder)localObject1).append(localMap);
        o.e("MicroMsg.AppBrand.NdefMessageConverter", ((StringBuilder)localObject1).toString());
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("payload-");
        ((StringBuilder)localObject1).append(i);
        localObject2 = paramMap.get(((StringBuilder)localObject1).toString());
        localObject1 = localObject2;
        if (!(localObject2 instanceof ByteBuffer)) {
          localObject1 = null;
        }
        localObject1 = (ByteBuffer)localObject1;
        if (localObject1 != null)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("map2Message, byteBuffer: ");
          ((StringBuilder)localObject2).append(localObject1);
          o.e("MicroMsg.AppBrand.NdefMessageConverter", ((StringBuilder)localObject2).toString());
          localCollection.add(a.a(TuplesKt.to(localMap, localObject1)));
          i += 1;
        }
        else
        {
          return null;
        }
      }
      paramMap = (List)localCollection;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("map2Message, records: ");
      ((StringBuilder)localObject1).append(paramMap);
      o.e("MicroMsg.AppBrand.NdefMessageConverter", ((StringBuilder)localObject1).toString());
      try
      {
        paramMap = ((Collection)paramMap).toArray(new NdefRecord[0]);
        if (paramMap != null) {
          return new NdefMessage((NdefRecord[])paramMap);
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
      }
      catch (Exception paramMap)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("create NdefMessage failed since ");
        ((StringBuilder)localObject1).append(paramMap);
        o.c("MicroMsg.AppBrand.NdefMessageConverter", ((StringBuilder)localObject1).toString());
        return null;
      }
    }
    return null;
  }
  
  @NotNull
  public final Map<String, Object> a(@NotNull List<NdefMessage> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "messages");
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("messages2Map, messages: ");
    ((StringBuilder)localObject1).append(paramList);
    o.e("MicroMsg.AppBrand.NdefMessageConverter", ((StringBuilder)localObject1).toString());
    localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (NdefMessage)((Iterator)localObject1).next();
      paramList.add(a.a((NdefMessage)localObject2));
    }
    localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject1, 10));
    Object localObject2 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject2).hasNext()) {
      paramList.add((List)((Pair)((Iterator)localObject2).next()).getFirst());
    }
    paramList = MapsKt.mutableMapOf(new Pair[] { TuplesKt.to("messages", (List)paramList) });
    localObject1 = ((Iterable)localObject1).iterator();
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        CollectionsKt.throwIndexOverflow();
      }
      localObject2 = ((Iterable)((Pair)localObject2).getSecond()).iterator();
      int j = 0;
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        if (j < 0) {
          CollectionsKt.throwIndexOverflow();
        }
        localObject3 = (ByteBuffer)localObject3;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("payload-");
        localStringBuilder.append(i);
        localStringBuilder.append('-');
        localStringBuilder.append(j);
        paramList.put(localStringBuilder.toString(), localObject3);
        j += 1;
      }
      i += 1;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("messages2Map, map: ");
    ((StringBuilder)localObject1).append(paramList);
    o.e("MicroMsg.AppBrand.NdefMessageConverter", ((StringBuilder)localObject1).toString());
    return paramList;
  }
  
  @Nullable
  public final NdefMessage b(@NotNull List<String> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "uris");
    Object localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (String)((Iterator)localObject1).next();
      try
      {
        localObject2 = NdefRecord.createUri((String)localObject2);
        paramList.add(localObject2);
      }
      catch (Exception paramList)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("createUri failed since ");
        ((StringBuilder)localObject1).append(paramList);
        o.c("MicroMsg.AppBrand.NdefMessageConverter", ((StringBuilder)localObject1).toString());
        return null;
      }
    }
    paramList = ((Collection)paramList).toArray(new NdefRecord[0]);
    if (paramList != null)
    {
      paramList = (NdefRecord[])paramList;
      try
      {
        paramList = new NdefMessage(paramList);
        return paramList;
      }
      catch (Exception paramList)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("create NdefMessage failed since ");
        ((StringBuilder)localObject1).append(paramList);
        o.c("MicroMsg.AppBrand.NdefMessageConverter", ((StringBuilder)localObject1).toString());
        return null;
      }
    }
    paramList = new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    for (;;)
    {
      throw paramList;
    }
  }
  
  @Nullable
  public final NdefMessage c(@NotNull List<? extends Map<String, String>> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "textAndLanguages");
    Object localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext()) {
        break label146;
      }
      Object localObject3 = (Map)((Iterator)localObject1).next();
      Object localObject2 = (String)((Map)localObject3).get("text");
      if (localObject2 != null)
      {
        localObject3 = (String)((Map)localObject3).get("language");
        if (localObject3 != null) {
          try
          {
            localObject2 = NdefRecord.createTextRecord((String)localObject3, (String)localObject2);
            paramList.add(localObject2);
          }
          catch (Exception paramList)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("createTextRecord failed since ");
            ((StringBuilder)localObject1).append(paramList);
            o.c("MicroMsg.AppBrand.NdefMessageConverter", ((StringBuilder)localObject1).toString());
          }
        }
      }
    }
    return null;
    label146:
    paramList = ((Collection)paramList).toArray(new NdefRecord[0]);
    if (paramList != null)
    {
      paramList = (NdefRecord[])paramList;
      try
      {
        paramList = new NdefMessage(paramList);
        return paramList;
      }
      catch (Exception paramList)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("create NdefMessage failed since ");
        ((StringBuilder)localObject1).append(paramList);
        o.c("MicroMsg.AppBrand.NdefMessageConverter", ((StringBuilder)localObject1).toString());
        return null;
      }
    }
    paramList = new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    for (;;)
    {
      throw paramList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ll.c
 * JD-Core Version:    0.7.0.1
 */