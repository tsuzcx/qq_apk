package com.tencent.biz.pubaccount.readinjoy.viola.videonew.barrage;

import android.content.Context;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.viola.annotation.JSMethod;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
import com.tencent.viola.ui.dom.Attr;
import com.tencent.viola.ui.dom.DomObject;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import tnd;
import tne;
import tnm;
import toa;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/viola/videonew/barrage/VBarrage;", "Lcom/tencent/viola/ui/baseComponent/VComponentContainer;", "Lcom/tencent/biz/pubaccount/readinjoy/viola/videonew/barrage/VBarrageView;", "Lcom/tencent/biz/pubaccount/readinjoy/viola/videonew/barrage/IBarrageControl;", "Lcom/tencent/biz/pubaccount/readinjoy/viola/videonew/barrage/BarrageCallback;", "instance", "Lcom/tencent/viola/core/ViolaInstance;", "node", "Lcom/tencent/viola/ui/dom/DomObject;", "parent", "(Lcom/tencent/viola/core/ViolaInstance;Lcom/tencent/viola/ui/dom/DomObject;Lcom/tencent/viola/ui/baseComponent/VComponentContainer;)V", "barrageConfig", "Lcom/tencent/biz/pubaccount/readinjoy/viola/videonew/barrage/BarrageConfig;", "barrageController", "Lcom/tencent/biz/pubaccount/readinjoy/viola/videonew/barrage/BarrageController;", "destroy", "", "doWhenCompDestroy", "fetchBarrageList", "articleId", "", "rowKey", "", "puin", "fetchBarrageListFromServer", "initComponentHostView", "context", "Landroid/content/Context;", "onActivityDestroy", "onEventBarrageDidAppear", "onEventBarrageOnClick", "commentId", "parseBarrageConfig", "pause", "play", "removedByDiff", "removedByJs", "stop", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VBarrage
  extends VComponentContainer<VBarrageView>
  implements tnd
{
  public static final toa Companion = new toa(null);
  @NotNull
  public static final String EVENT_BARRAGE_DIDAPPEAR = "barrageDidAppear";
  @NotNull
  public static final String EVENT_BARRAGE_ONCLICK = "barrageOnClick";
  private final BarrageConfig barrageConfig = parseBarrageConfig();
  private tne barrageController;
  
  public VBarrage(@NotNull ViolaInstance paramViolaInstance, @NotNull DomObject paramDomObject, @NotNull VComponentContainer<?> paramVComponentContainer)
  {
    super(paramViolaInstance, paramDomObject, paramVComponentContainer);
    int i = this.barrageConfig.a();
    int j = DisplayUtil.dip2px((Context)BaseApplicationImpl.getContext(), 24 + this.barrageConfig.b());
    paramViolaInstance = getDomObject();
    if ((paramViolaInstance instanceof tnm)) {
      ((tnm)paramViolaInstance).a(i * j);
    }
  }
  
  private final void doWhenCompDestroy()
  {
    tne localtne = this.barrageController;
    if (localtne != null) {
      localtne.c();
    }
    localtne = this.barrageController;
    if (localtne != null) {
      localtne.d();
    }
  }
  
  private final void fetchBarrageListFromServer()
  {
    String str = "";
    long l1 = 0L;
    Object localObject2 = "";
    Object localObject5 = localObject2;
    Object localObject4 = str;
    long l3 = l1;
    Object localObject3;
    long l2;
    try
    {
      Object localObject7 = getDomObject();
      localObject5 = localObject2;
      localObject4 = str;
      l3 = l1;
      Intrinsics.checkExpressionValueIsNotNull(localObject7, "domObject");
      localObject5 = localObject2;
      localObject4 = str;
      l3 = l1;
      localObject3 = localObject2;
      localObject6 = str;
      l2 = l1;
      if (((DomObject)localObject7).getAttributes() != null)
      {
        localObject5 = localObject2;
        localObject4 = str;
        l3 = l1;
        localObject3 = getDomObject();
        localObject5 = localObject2;
        localObject4 = str;
        l3 = l1;
        Intrinsics.checkExpressionValueIsNotNull(localObject3, "domObject");
        localObject5 = localObject2;
        localObject4 = str;
        l3 = l1;
        localObject7 = ((DomObject)localObject3).getAttributes().entrySet().iterator();
        localObject5 = localObject2;
        localObject4 = str;
        l3 = l1;
        localObject3 = localObject2;
        localObject6 = str;
        l2 = l1;
        if (((Iterator)localObject7).hasNext())
        {
          localObject5 = localObject2;
          localObject4 = str;
          l3 = l1;
          localObject3 = ((Iterator)localObject7).next();
          if (localObject3 != null) {
            break label264;
          }
          localObject5 = localObject2;
          localObject4 = str;
          l3 = l1;
          throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map.Entry<kotlin.String, kotlin.Any>");
        }
      }
    }
    catch (Exception localException)
    {
      QLog.e("VComponent", 1, "fetchBarrageListFromServer exception:" + localException.getLocalizedMessage());
      l2 = l3;
      localObject6 = localObject4;
      localObject3 = localObject5;
      fetchBarrageList(l2, (String)localObject6, (String)localObject3);
      return;
    }
    label264:
    localObject5 = localObject2;
    localObject4 = localException;
    l3 = l1;
    Map.Entry localEntry = (Map.Entry)localObject3;
    localObject5 = localObject2;
    localObject4 = localException;
    l3 = l1;
    Object localObject6 = localException;
    long l4 = l1;
    Object localObject1;
    if (Intrinsics.areEqual("src", (String)localEntry.getKey()))
    {
      localObject5 = localObject2;
      localObject4 = localException;
      l3 = l1;
      localObject6 = localEntry.getValue();
      if (localObject6 == null)
      {
        localObject5 = localObject2;
        localObject4 = localException;
        l3 = l1;
        throw new TypeCastException("null cannot be cast to non-null type org.json.JSONObject");
      }
      localObject5 = localObject2;
      localObject4 = localException;
      l3 = l1;
      localObject3 = localException;
      if (((JSONObject)localObject6).has("rowkey"))
      {
        localObject5 = localObject2;
        localObject4 = localException;
        l3 = l1;
        localObject3 = localEntry.getValue();
        if (localObject3 == null)
        {
          localObject5 = localObject2;
          localObject4 = localException;
          l3 = l1;
          throw new TypeCastException("null cannot be cast to non-null type org.json.JSONObject");
        }
        localObject5 = localObject2;
        localObject4 = localException;
        l3 = l1;
        localObject3 = ((JSONObject)localObject3).getString("rowkey");
        localObject5 = localObject2;
        localObject4 = localException;
        l3 = l1;
        Intrinsics.checkExpressionValueIsNotNull(localObject3, "(entry.value as JSONObject).getString(\"rowkey\")");
      }
      localObject5 = localObject2;
      localObject4 = localObject3;
      l3 = l1;
      localObject1 = localEntry.getValue();
      if (localObject1 == null)
      {
        localObject5 = localObject2;
        localObject4 = localObject3;
        l3 = l1;
        throw new TypeCastException("null cannot be cast to non-null type org.json.JSONObject");
      }
      localObject5 = localObject2;
      localObject4 = localObject3;
      l3 = l1;
      l2 = l1;
      if (((JSONObject)localObject1).has("article_id"))
      {
        localObject5 = localObject2;
        localObject4 = localObject3;
        l3 = l1;
        localObject1 = localEntry.getValue();
        if (localObject1 == null)
        {
          localObject5 = localObject2;
          localObject4 = localObject3;
          l3 = l1;
          throw new TypeCastException("null cannot be cast to non-null type org.json.JSONObject");
        }
        localObject5 = localObject2;
        localObject4 = localObject3;
        l3 = l1;
        l2 = ((JSONObject)localObject1).getLong("article_id");
      }
      localObject5 = localObject2;
      localObject4 = localObject3;
      l3 = l2;
      localObject1 = localEntry.getValue();
      if (localObject1 == null)
      {
        localObject5 = localObject2;
        localObject4 = localObject3;
        l3 = l2;
        throw new TypeCastException("null cannot be cast to non-null type org.json.JSONObject");
      }
      localObject5 = localObject2;
      localObject4 = localObject3;
      l3 = l2;
      localObject6 = localObject3;
      l4 = l2;
      if (((JSONObject)localObject1).has("puin"))
      {
        localObject5 = localObject2;
        localObject4 = localObject3;
        l3 = l2;
        localObject1 = localEntry.getValue();
        if (localObject1 == null)
        {
          localObject5 = localObject2;
          localObject4 = localObject3;
          l3 = l2;
          throw new TypeCastException("null cannot be cast to non-null type org.json.JSONObject");
        }
        localObject5 = localObject2;
        localObject4 = localObject3;
        l3 = l2;
        localObject6 = ((JSONObject)localObject1).getString("puin");
        localObject5 = localObject2;
        localObject4 = localObject3;
        l3 = l2;
        Intrinsics.checkExpressionValueIsNotNull(localObject6, "(entry.value as JSONObject).getString(\"puin\")");
        localObject1 = localObject3;
        l1 = l2;
        localObject2 = localObject6;
      }
    }
    for (;;)
    {
      break;
      localObject1 = localObject6;
      l1 = l4;
    }
  }
  
  private final BarrageConfig parseBarrageConfig()
  {
    BarrageConfig localBarrageConfig = new BarrageConfig();
    Object localObject2;
    label124:
    do
    {
      try
      {
        Object localObject1 = getDomObject();
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "domObject");
        if (((DomObject)localObject1).getAttributes() != null)
        {
          localObject1 = getDomObject();
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "domObject");
          localObject1 = ((DomObject)localObject1).getAttributes().entrySet().iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = ((Iterator)localObject1).next();
            if (localObject2 != null) {
              break label124;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map.Entry<kotlin.String, kotlin.Any>");
          }
        }
      }
      catch (Exception localException)
      {
        QLog.e("VComponent", 1, "parseBarrageConfig exception:" + localException.getLocalizedMessage());
      }
      return localBarrageConfig;
      localObject2 = (Map.Entry)localObject2;
    } while (!Intrinsics.areEqual("barrageConfig", (String)((Map.Entry)localObject2).getKey()));
    Object localObject3 = ((Map.Entry)localObject2).getValue();
    if (localObject3 == null) {
      throw new TypeCastException("null cannot be cast to non-null type org.json.JSONObject");
    }
    if (((JSONObject)localObject3).has("lineCount"))
    {
      localObject3 = ((Map.Entry)localObject2).getValue();
      if (localObject3 == null) {
        throw new TypeCastException("null cannot be cast to non-null type org.json.JSONObject");
      }
      localBarrageConfig.a(((JSONObject)localObject3).getInt("lineCount"));
    }
    localObject3 = ((Map.Entry)localObject2).getValue();
    if (localObject3 == null) {
      throw new TypeCastException("null cannot be cast to non-null type org.json.JSONObject");
    }
    if (((JSONObject)localObject3).has("barrageSpace"))
    {
      localObject3 = ((Map.Entry)localObject2).getValue();
      if (localObject3 == null) {
        throw new TypeCastException("null cannot be cast to non-null type org.json.JSONObject");
      }
      localBarrageConfig.b(((JSONObject)localObject3).getInt("barrageSpace"));
    }
    localObject3 = ((Map.Entry)localObject2).getValue();
    if (localObject3 == null) {
      throw new TypeCastException("null cannot be cast to non-null type org.json.JSONObject");
    }
    if (((JSONObject)localObject3).has("orderOfAscending"))
    {
      localObject3 = ((Map.Entry)localObject2).getValue();
      if (localObject3 == null) {
        throw new TypeCastException("null cannot be cast to non-null type org.json.JSONObject");
      }
      int i = ((JSONObject)localObject3).getInt("orderOfAscending");
      localBarrageConfig.a(BarrageConfig.AscendingOrder.values()[i]);
    }
    localObject3 = ((Map.Entry)localObject2).getValue();
    if (localObject3 == null) {
      throw new TypeCastException("null cannot be cast to non-null type org.json.JSONObject");
    }
    if (((JSONObject)localObject3).has("slideDuration"))
    {
      localObject3 = ((Map.Entry)localObject2).getValue();
      if (localObject3 == null) {
        throw new TypeCastException("null cannot be cast to non-null type org.json.JSONObject");
      }
      localBarrageConfig.a((float)((JSONObject)localObject3).getDouble("slideDuration"));
    }
    localObject3 = ((Map.Entry)localObject2).getValue();
    if (localObject3 == null) {
      throw new TypeCastException("null cannot be cast to non-null type org.json.JSONObject");
    }
    if (((JSONObject)localObject3).has("loop"))
    {
      localObject3 = ((Map.Entry)localObject2).getValue();
      if (localObject3 == null) {
        throw new TypeCastException("null cannot be cast to non-null type org.json.JSONObject");
      }
      if (((JSONObject)localObject3).getInt("loop") != 1) {
        break label629;
      }
    }
    label629:
    for (boolean bool = true;; bool = false)
    {
      localBarrageConfig.a(bool);
      localObject3 = ((Map.Entry)localObject2).getValue();
      if (localObject3 == null) {
        throw new TypeCastException("null cannot be cast to non-null type org.json.JSONObject");
      }
      if (!((JSONObject)localObject3).has("transparent")) {
        break;
      }
      localObject2 = ((Map.Entry)localObject2).getValue();
      if (localObject2 == null) {
        throw new TypeCastException("null cannot be cast to non-null type org.json.JSONObject");
      }
      localBarrageConfig.b((float)((JSONObject)localObject2).getDouble("transparent"));
      break;
    }
  }
  
  public void destroy()
  {
    super.destroy();
    doWhenCompDestroy();
  }
  
  public void fetchBarrageList(long paramLong, @NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "rowKey");
    Intrinsics.checkParameterIsNotNull(paramString2, "puin");
    tne localtne = this.barrageController;
    if (localtne != null) {
      localtne.a(paramLong, paramString1, paramString2);
    }
  }
  
  @NotNull
  protected VBarrageView initComponentHostView(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    paramContext = new VBarrageView(paramContext, null, 0, 6, null);
    this.barrageController = new tne((BarrageView)paramContext, this.barrageConfig);
    tne localtne = this.barrageController;
    if (localtne != null) {
      localtne.a((tnd)this);
    }
    fetchBarrageListFromServer();
    return paramContext;
  }
  
  public void onActivityDestroy()
  {
    super.onActivityDestroy();
    doWhenCompDestroy();
  }
  
  public void onEventBarrageDidAppear()
  {
    fireEvent("barrageDidAppear", null);
  }
  
  public void onEventBarrageOnClick(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "commentId");
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("commentId", paramString);
    fireEvent("barrageOnClick", localJSONObject);
  }
  
  @JSMethod
  public void pause()
  {
    tne localtne = this.barrageController;
    if (localtne != null) {
      localtne.b();
    }
  }
  
  @JSMethod
  public void play()
  {
    tne localtne = this.barrageController;
    if (localtne != null) {
      localtne.a();
    }
  }
  
  public void removedByDiff()
  {
    super.removedByDiff();
    doWhenCompDestroy();
  }
  
  public void removedByJs()
  {
    super.removedByJs();
    doWhenCompDestroy();
  }
  
  @JSMethod
  public void stop()
  {
    tne localtne = this.barrageController;
    if (localtne != null) {
      localtne.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.videonew.barrage.VBarrage
 * JD-Core Version:    0.7.0.1
 */