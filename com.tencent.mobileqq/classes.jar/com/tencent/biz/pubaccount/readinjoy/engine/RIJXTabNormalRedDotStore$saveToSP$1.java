package com.tencent.biz.pubaccount.readinjoy.engine;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.biz.pubaccount.readinjoy.struct.RIJSerializableKtxKt;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import cooperation.readinjoy.ReadInJoyHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class RIJXTabNormalRedDotStore$saveToSP$1
  implements Runnable
{
  public static final 1 a = new 1();
  
  public final void run()
  {
    SharedPreferences.Editor localEditor = ReadInJoyHelper.a(RIJQQAppInterfaceUtil.a(), true, false).edit();
    Object localObject = RIJXTabNormalRedDotStore.a(RIJXTabNormalRedDotStore.a);
    Collection localCollection = (Collection)new ArrayList(((Map)localObject).size());
    localObject = ((Map)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext()) {
      localCollection.add(PkgTools.toHexStr(RIJSerializableKtxKt.a((Serializable)((Map.Entry)((Iterator)localObject).next()).getValue())));
    }
    localEditor.putStringSet("kandian_x_tab_red_dot", CollectionsKt.toSet((Iterable)localCollection)).putBoolean("kandian_tab_unread", RIJXTabNormalRedDotStore.a(RIJXTabNormalRedDotStore.a).get());
    ReadInJoyHelper.a(localEditor, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.RIJXTabNormalRedDotStore.saveToSP.1
 * JD-Core Version:    0.7.0.1
 */