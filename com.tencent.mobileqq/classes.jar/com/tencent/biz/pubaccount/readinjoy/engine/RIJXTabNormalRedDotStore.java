package com.tencent.biz.pubaccount.readinjoy.engine;

import android.content.SharedPreferences;
import androidx.annotation.VisibleForTesting;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.RIJXTabConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.RIJXTabConfigHandler.Companion;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.biz.pubaccount.readinjoy.struct.RIJSerializableKtxKt;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/engine/RIJXTabNormalRedDotStore;", "", "()V", "CHANNEL_ID_UNKNOWN", "", "SP_KEY_KANDIAN_TAB_UNREAD", "", "SP_KEY_RED_DOT_INFO", "TAG", "hasKandianTabUnread", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getHasKandianTabUnread", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "hasKandianTabUnread$delegate", "Lkotlin/Lazy;", "redDotInfoMap", "", "Lcom/tencent/biz/pubaccount/readinjoy/engine/RIJXTabRedDotInfo;", "getRedDotInfoMap", "()Ljava/util/Map;", "redDotInfoMap$delegate", "addRedDotMsg", "", "info", "clearAllInvalidateRedDotMsg", "", "getAllRedDotMsg", "", "getJumpPriorityChannelId", "getLatestRedDotInfo", "getRedDotMsg", "channelId", "hasChannelRedDot", "initCache", "isChannelExists", "loadFormSp", "markKanidianTabHasRead", "markRedDotExposed", "removeRedDotMsg", "userAction", "saveToSP", "setRedDotInfo", "infos", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJXTabNormalRedDotStore
{
  public static final RIJXTabNormalRedDotStore a;
  private static final Lazy a;
  private static final Lazy b = LazyKt.lazy((Function0)RIJXTabNormalRedDotStore.hasKandianTabUnread.2.INSTANCE);
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineRIJXTabNormalRedDotStore = new RIJXTabNormalRedDotStore();
    jdField_a_of_type_KotlinLazy = LazyKt.lazy((Function0)RIJXTabNormalRedDotStore.redDotInfoMap.2.INSTANCE);
  }
  
  private final Map<Integer, RIJXTabRedDotInfo> a()
  {
    return (Map)jdField_a_of_type_KotlinLazy.getValue();
  }
  
  private final AtomicBoolean a()
  {
    return (AtomicBoolean)b.getValue();
  }
  
  private final boolean a(int paramInt)
  {
    Iterator localIterator = ((Iterable)RIJXTabConfigHandler.a.a().a()).iterator();
    while (localIterator.hasNext()) {
      if (((TabChannelCoverInfo)localIterator.next()).mChannelCoverId == paramInt) {
        return true;
      }
    }
    return false;
  }
  
  private final void d()
  {
    a().clear();
    SharedPreferences localSharedPreferences = ReadInJoyHelper.a(RIJQQAppInterfaceUtil.a(), true, false);
    Object localObject1 = localSharedPreferences.getStringSet("kandian_x_tab_red_dot", SetsKt.emptySet());
    if (localObject1 != null)
    {
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = PkgTools.hexToBytes((String)((Iterator)localObject1).next());
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "PkgTools.hexToBytes(it)");
        localObject2 = (RIJXTabRedDotInfo)RIJSerializableKtxKt.a((byte[])localObject2);
        if (localObject2 != null) {
          localObject2 = (RIJXTabRedDotInfo)jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineRIJXTabNormalRedDotStore.a().put(Integer.valueOf(((RIJXTabRedDotInfo)localObject2).getChannelId()), localObject2);
        }
      }
      c();
      a().set(localSharedPreferences.getBoolean("kandian_tab_unread", false));
    }
  }
  
  private final void e()
  {
    ThreadManager.getSubThreadHandler().post((Runnable)RIJXTabNormalRedDotStore.saveToSP.1.a);
  }
  
  public final int a()
  {
    RIJXTabRedDotInfo localRIJXTabRedDotInfo = a();
    if (localRIJXTabRedDotInfo != null)
    {
      if (a().containsKey(Integer.valueOf(localRIJXTabRedDotInfo.getPriorityChannelId()))) {
        return localRIJXTabRedDotInfo.getPriorityChannelId();
      }
    }
    else {
      return -1;
    }
    return localRIJXTabRedDotInfo.getChannelId();
  }
  
  @Nullable
  public final RIJXTabRedDotInfo a()
  {
    if (a().isEmpty()) {
      return null;
    }
    return (RIJXTabRedDotInfo)((Map.Entry)CollectionsKt.last(CollectionsKt.sortedWith((Iterable)a().entrySet(), (Comparator)new RIJXTabNormalRedDotStore.getLatestRedDotInfo..inlined.sortedBy.1()))).getValue();
  }
  
  @Nullable
  public final RIJXTabRedDotInfo a(int paramInt)
  {
    return (RIJXTabRedDotInfo)a().get(Integer.valueOf(paramInt));
  }
  
  @Nullable
  public final RIJXTabRedDotInfo a(int paramInt, boolean paramBoolean)
  {
    RIJXTabRedDotInfo localRIJXTabRedDotInfo = (RIJXTabRedDotInfo)a().remove(Integer.valueOf(paramInt));
    QLog.d("RIJXTabNormalRedDotStore", 2, "removeRedDotMsg --> channelId:" + paramInt + ", info:" + localRIJXTabRedDotInfo + ", userAction:" + paramBoolean);
    if (localRIJXTabRedDotInfo != null)
    {
      if (paramBoolean)
      {
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineRIJXTabNormalRedDotStore.a().set(false);
        RIJXTabNormalRedDotReporter.b(localRIJXTabRedDotInfo);
        RIJXTabNormalRedDotReporter.a(localRIJXTabRedDotInfo, 1);
      }
      jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineRIJXTabNormalRedDotStore.e();
    }
    return localRIJXTabRedDotInfo;
  }
  
  @NotNull
  public final List<RIJXTabRedDotInfo> a()
  {
    Object localObject = a();
    Collection localCollection = (Collection)new ArrayList(((Map)localObject).size());
    localObject = ((Map)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext()) {
      localCollection.add((RIJXTabRedDotInfo)((Map.Entry)((Iterator)localObject).next()).getValue());
    }
    return (List)localCollection;
  }
  
  public final void a()
  {
    a().set(false);
    e();
  }
  
  public final void a(int paramInt)
  {
    RIJXTabRedDotInfo localRIJXTabRedDotInfo = (RIJXTabRedDotInfo)a().get(Integer.valueOf(paramInt));
    if (localRIJXTabRedDotInfo != null) {
      localRIJXTabRedDotInfo.setExposureTime(NetConnInfoCenter.getServerTimeMillis());
    }
    e();
  }
  
  public final boolean a()
  {
    return (b()) && (a().get());
  }
  
  public final boolean a(@NotNull RIJXTabRedDotInfo paramRIJXTabRedDotInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramRIJXTabRedDotInfo, "info");
    QLog.d("RIJXTabNormalRedDotStore", 2, "addRedDotMsg() --> " + paramRIJXTabRedDotInfo);
    a().put(Integer.valueOf(paramRIJXTabRedDotInfo.getChannelId()), paramRIJXTabRedDotInfo);
    a().set(true);
    e();
    return true;
  }
  
  public final void b()
  {
    QLog.d("RIJXTabNormalRedDotStore", 2, "initCache()");
    d();
  }
  
  public final boolean b()
  {
    return !a().isEmpty();
  }
  
  @VisibleForTesting
  public final void c()
  {
    QLog.d("RIJXTabNormalRedDotStore", 2, "clearAllExpiredRedDotMsg()");
    int j = RIJXTabConfigHandler.a.a().b();
    long l = NetConnInfoCenter.getServerTimeMillis();
    Object localObject = a();
    Map localMap = (Map)new LinkedHashMap();
    localObject = ((Map)localObject).entrySet().iterator();
    label160:
    label294:
    label297:
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      label108:
      boolean bool1;
      if (l - ((RIJXTabRedDotInfo)localEntry.getValue()).getArrivedTime() < j * 60 * 1000)
      {
        i = 1;
        boolean bool2 = jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineRIJXTabNormalRedDotStore.a(((Number)localEntry.getKey()).intValue());
        if ((i == 0) || (!bool2))
        {
          StringBuilder localStringBuilder = new StringBuilder().append("filter invalid red dot(expired:");
          if (i != 0) {
            break label282;
          }
          bool1 = true;
          localStringBuilder = localStringBuilder.append(bool1).append(", tabNotExists:");
          if (bool2) {
            break label288;
          }
          bool1 = true;
          label183:
          QLog.d("RIJXTabNormalRedDotStore", 2, bool1 + ") --> " + (RIJXTabRedDotInfo)localEntry.getValue());
        }
        if (i == 0) {
          RIJXTabNormalRedDotReporter.a((RIJXTabRedDotInfo)localEntry.getValue(), 2);
        }
        if ((i == 0) || (!bool2)) {
          break label294;
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label297;
        }
        localMap.put(localEntry.getKey(), localEntry.getValue());
        break;
        i = 0;
        break label108;
        bool1 = false;
        break label160;
        bool1 = false;
        break label183;
      }
    }
    label282:
    label288:
    a().clear();
    a().putAll(localMap);
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.RIJXTabNormalRedDotStore
 * JD-Core Version:    0.7.0.1
 */