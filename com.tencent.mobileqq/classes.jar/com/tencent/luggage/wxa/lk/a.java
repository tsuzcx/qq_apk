package com.tencent.luggage.wxa.lk;

import android.nfc.Tag;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/INFCTechLogic;", "", "exec", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "tag", "Landroid/nfc/Tag;", "function", "", "params", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/INFCTechExecParams;", "execAsync", "", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteCallback;", "luggage-commons-jsapi-nfc-ext_release"}, k=1, mv={1, 1, 16})
public abstract interface a
{
  public abstract void a(@NotNull Tag paramTag, @NotNull String paramString, @Nullable com.tencent.luggage.wxa.ll.a parama, @NotNull Function1<? super e<Object>, Unit> paramFunction1);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lk.a
 * JD-Core Version:    0.7.0.1
 */