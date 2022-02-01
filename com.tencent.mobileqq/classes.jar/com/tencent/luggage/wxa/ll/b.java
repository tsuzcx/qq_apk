package com.tencent.luggage.wxa.ll;

import android.nfc.tech.IsoDep;
import android.nfc.tech.MifareClassic;
import android.nfc.tech.MifareUltralight;
import android.nfc.tech.Ndef;
import android.nfc.tech.NfcA;
import android.nfc.tech.NfcB;
import android.nfc.tech.NfcF;
import android.nfc.tech.NfcV;
import android.util.ArrayMap;
import com.tencent.luggage.wxa.lk.a;
import com.tencent.luggage.wxa.lk.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/NFCTech;", "", "techName", "", "techClassName", "techLogic", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/INFCTechLogic;", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/INFCTechLogic;)V", "hasMethodCache", "Landroid/util/ArrayMap;", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/NFCTech$MethodSignature;", "", "getTechClassName", "()Ljava/lang/String;", "getTechLogic", "()Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/INFCTechLogic;", "getTechName", "hasMethod", "name", "parameterTypes", "", "Ljava/lang/Class;", "", "(Ljava/lang/String;[Ljava/lang/Class;)Z", "NFC_A", "NFC_B", "ISO_DEP", "NFC_F", "NFC_V", "MIFARE_CLASSIC", "MIFARE_ULTRALIGHT", "NDEF", "Companion", "MethodSignature", "luggage-commons-jsapi-nfc-ext_release"}, k=1, mv={1, 1, 16})
public enum b
{
  public static final b.a i;
  @NotNull
  private static final Map<String, b> o;
  @NotNull
  private static final Map<String, String> p;
  private final ArrayMap<b.b, Boolean> k;
  @NotNull
  private final String l;
  @NotNull
  private final String m;
  @Nullable
  private final a n;
  
  static
  {
    Object localObject1 = NfcA.class.getName();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "NfcA::class.java.name");
    localObject1 = new b("NFC_A", 0, "NFC-A", (String)localObject1, (a)f.a);
    a = (b)localObject1;
    int i2 = 0;
    Object localObject2 = NfcB.class.getName();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "NfcB::class.java.name");
    localObject2 = new b("NFC_B", 1, "NFC-B", (String)localObject2, null);
    b = (b)localObject2;
    Object localObject3 = IsoDep.class.getName();
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "IsoDep::class.java.name");
    localObject3 = new b("ISO_DEP", 2, "ISO-DEP", (String)localObject3, (a)com.tencent.luggage.wxa.lk.b.a);
    c = (b)localObject3;
    Object localObject4 = NfcF.class.getName();
    Intrinsics.checkExpressionValueIsNotNull(localObject4, "NfcF::class.java.name");
    localObject4 = new b("NFC_F", 3, "NFC-F", (String)localObject4, null);
    d = (b)localObject4;
    Object localObject5 = NfcV.class.getName();
    Intrinsics.checkExpressionValueIsNotNull(localObject5, "NfcV::class.java.name");
    localObject5 = new b("NFC_V", 4, "NFC-V", (String)localObject5, null);
    e = (b)localObject5;
    Object localObject6 = MifareClassic.class.getName();
    Intrinsics.checkExpressionValueIsNotNull(localObject6, "MifareClassic::class.java.name");
    localObject6 = new b("MIFARE_CLASSIC", 5, "MIFARE Classic", (String)localObject6, null);
    f = (b)localObject6;
    Object localObject7 = MifareUltralight.class.getName();
    Intrinsics.checkExpressionValueIsNotNull(localObject7, "MifareUltralight::class.java.name");
    localObject7 = new b("MIFARE_ULTRALIGHT", 6, "MIFARE Ultralight", (String)localObject7, null);
    g = (b)localObject7;
    Object localObject8 = Ndef.class.getName();
    Intrinsics.checkExpressionValueIsNotNull(localObject8, "Ndef::class.java.name");
    localObject8 = new b("NDEF", 7, "NDEF", (String)localObject8, null);
    h = (b)localObject8;
    j = new b[] { localObject1, localObject2, localObject3, localObject4, localObject5, localObject6, localObject7, localObject8 };
    i = new b.a(null);
    localObject1 = values();
    localObject2 = (Collection)new ArrayList(localObject1.length);
    int i3 = localObject1.length;
    int i1 = 0;
    while (i1 < i3)
    {
      localObject3 = localObject1[i1];
      ((Collection)localObject2).add(TuplesKt.to(((b)localObject3).l, localObject3));
      i1 += 1;
    }
    o = MapsKt.toMap((Iterable)localObject2);
    localObject1 = values();
    localObject2 = (Collection)new ArrayList(localObject1.length);
    i3 = localObject1.length;
    i1 = i2;
    while (i1 < i3)
    {
      localObject3 = localObject1[i1];
      ((Collection)localObject2).add(TuplesKt.to(((b)localObject3).m, ((b)localObject3).l));
      i1 += 1;
    }
    p = MapsKt.toMap((Iterable)localObject2);
  }
  
  private b(String paramString1, String paramString2, a parama)
  {
    this.l = paramString1;
    this.m = paramString2;
    this.n = parama;
    this.k = new ArrayMap();
  }
  
  @NotNull
  public final String a()
  {
    return this.l;
  }
  
  public final boolean a(@NotNull String paramString, @NotNull Class<? extends Object>... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "parameterTypes");
    b.b localb = new b.b(paramString, paramVarArgs);
    Boolean localBoolean = (Boolean)this.k.get(localb);
    if (localBoolean != null) {
      paramString = localBoolean;
    } else {
      paramString = (Boolean)((Function0)new b.c(localb, this, paramString, paramVarArgs)).invoke();
    }
    Intrinsics.checkExpressionValueIsNotNull(paramString, "MethodSignature(name, pa…            }()\n        }");
    return paramString.booleanValue();
  }
  
  @NotNull
  public final String b()
  {
    return this.m;
  }
  
  @Nullable
  public final a c()
  {
    return this.n;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ll.b
 * JD-Core Version:    0.7.0.1
 */