package com.tencent.common.wormhole;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.common.wormhole.action.IClientEngine;
import com.tencent.common.wormhole.action.WormholeDomActionInterceptor;
import com.tencent.common.wormhole.log.ILogAdapter;
import com.tencent.common.wormhole.log.WormholeLogUtils;
import com.tencent.common.wormhole.provider.WormholeAPIProvider;
import com.tencent.common.wormhole.views.HippySessionView;
import com.tencent.common.wormhole.views.HippyWormholeView;
import com.tencent.common.wormhole.views.ITKDWormhole;
import com.tencent.common.wormhole.views.TKDWormholeView;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.mtt.hippy.HippyEngine;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.dom.DomManager;
import com.tencent.mtt.hippy.dom.node.DomActionInterceptor;
import com.tencent.mtt.hippy.uimanager.ControllerManager;
import com.tencent.mtt.hippy.uimanager.HippyViewEvent;
import com.tencent.mtt.hippy.uimanager.RenderManager;
import com.tencent.mtt.hippy.uimanager.RenderNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;

public class WormholeManager
{
  private static final AtomicInteger c = new AtomicInteger(1000);
  private static volatile WormholeManager d;
  public ConcurrentHashMap<String, View> a = new ConcurrentHashMap();
  protected List<HippyAPIProvider> b = new ArrayList();
  private HippyEngine e;
  private ConcurrentHashMap<String, Integer> f = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Integer> g = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Integer> h = new ConcurrentHashMap();
  private ConcurrentHashMap<String, ITKDWormhole> i = new ConcurrentHashMap();
  private ConcurrentHashMap<Integer, HippySessionView> j = new ConcurrentHashMap();
  private ConcurrentHashMap<Integer, WormholeDomActionInterceptor> k = new ConcurrentHashMap();
  private ConcurrentHashMap<String, View> l = new ConcurrentHashMap();
  private ArrayList<Object> m = new ArrayList();
  private ILogAdapter n;
  
  private WormholeManager()
  {
    this.b.add(new WormholeAPIProvider());
  }
  
  private View a(String paramString)
  {
    if ((this.e != null) && (this.g.containsKey(paramString)))
    {
      localObject = this.e.getEngineContext();
      if (localObject == null)
      {
        WormholeLogUtils.b("hippy_wormhole", "findWormholeView engineContext null");
        return null;
      }
      int i1 = ((Integer)this.g.get(paramString)).intValue();
      paramString = ((HippyEngineContext)localObject).getRenderManager().getControllerManager().findView(i1);
      if (paramString == null)
      {
        localObject = ((HippyEngineContext)localObject).getRenderManager().getRenderNode(i1);
        if (localObject != null)
        {
          ((RenderNode)localObject).setLazy(false);
          paramString = ((RenderNode)localObject).createViewRecursive();
          ((RenderNode)localObject).updateViewRecursive();
          return paramString;
        }
        WormholeLogUtils.b("hippy_wormhole", "findWormholeView node null and view null");
      }
      return paramString;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("findWormholeView mWormholeEngine null or containsKey:");
    ((StringBuilder)localObject).append(this.g.containsKey(paramString));
    ((StringBuilder)localObject).append(",wormholeId:");
    ((StringBuilder)localObject).append(paramString);
    WormholeLogUtils.b("hippy_wormhole", ((StringBuilder)localObject).toString());
    return null;
  }
  
  public static WormholeManager a()
  {
    if (d == null) {
      try
      {
        if (d == null) {
          d = new WormholeManager();
        }
      }
      finally {}
    }
    return d;
  }
  
  private void a(View paramView1, View paramView2)
  {
    if (paramView2 != null)
    {
      if (!(paramView2 instanceof ViewGroup)) {
        return;
      }
      ViewGroup localViewGroup = (ViewGroup)paramView1.getParent();
      if (localViewGroup != paramView2)
      {
        if (localViewGroup != null) {
          localViewGroup.removeView(paramView1);
        }
        paramView2 = (ViewGroup)paramView2;
        paramView2.removeAllViews();
        paramView2.addView(paramView1, 0);
      }
    }
  }
  
  private void a(HippyMap paramHippyMap, int paramInt)
  {
    if (this.e == null)
    {
      Log.e("hippy_wormhole", "sendDataReceivedMessageToServer mWormholeEngine null");
      return;
    }
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushInt("rootTag", paramInt);
    HippyArray localHippyArray = new HippyArray();
    paramHippyMap.pushInt("rootTag", paramInt);
    localHippyArray.pushMap(paramHippyMap);
    localHippyMap.pushArray("items", localHippyArray);
    paramHippyMap = new JSONArray();
    paramHippyMap.put(localHippyMap);
    this.e.sendEvent("Wormhole.dataReceived", paramHippyMap);
  }
  
  private void a(String paramString, View paramView)
  {
    if (this.e == null)
    {
      Log.e("hippy_wormhole", "sendBatchCompleteMessageToClient mWormholeEngine null");
      return;
    }
    int i1 = ((Integer)this.g.get(paramString)).intValue();
    paramString = this.e.getEngineContext();
    if (paramString == null) {
      return;
    }
    paramString = paramString.getRenderManager().getRenderNode(i1);
    if (paramString != null)
    {
      float f1 = paramString.getWidth();
      float f2 = paramString.getHeight();
      paramString = new HippyMap();
      paramString.pushDouble("width", PixelUtil.a(f1));
      paramString.pushDouble("height", PixelUtil.a(f2));
      new HippyViewEvent("onServerBatchComplete").send(paramView, paramString);
    }
  }
  
  private void b(View paramView1, View paramView2)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView2.getLayoutParams();
    if ((localLayoutParams != null) && (localLayoutParams.height != paramView1.getHeight()))
    {
      localLayoutParams.height = paramView1.getHeight();
      paramView2.setLayoutParams(localLayoutParams);
    }
  }
  
  private void b(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.e == null) {
        return;
      }
      HippyMap localHippyMap = new HippyMap();
      localHippyMap.pushInt("rootTag", paramInt);
      HippyArray localHippyArray = new HippyArray();
      localHippyArray.pushString(paramString);
      localHippyMap.pushArray("items", localHippyArray);
      this.e.sendEvent("Wormhole.itemDeleted", localHippyMap);
      this.i.remove(paramString);
    }
  }
  
  private void c(int paramInt)
  {
    Iterator localIterator = this.h.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((localEntry != null) && (((Integer)localEntry.getValue()).intValue() == paramInt)) {
        a((String)localEntry.getKey(), paramInt);
      }
    }
  }
  
  public int a(HippyMap paramHippyMap)
  {
    if ((paramHippyMap != null) && (paramHippyMap.containsKey("rootTag"))) {
      return paramHippyMap.getInt("rootTag");
    }
    return -1;
  }
  
  public HippySessionView a(TKDWormholeView paramTKDWormholeView)
  {
    int i1 = paramTKDWormholeView.getRootId();
    return (HippySessionView)this.j.get(Integer.valueOf(i1));
  }
  
  public HippySessionView a(Integer paramInteger)
  {
    return (HippySessionView)this.j.get(paramInteger);
  }
  
  public String a(HippyMap paramHippyMap, Integer paramInteger)
  {
    paramHippyMap = b(paramHippyMap);
    if (!TextUtils.isEmpty(paramHippyMap)) {
      this.g.put(paramHippyMap, paramInteger);
    }
    return paramHippyMap;
  }
  
  public void a(int paramInt)
  {
    Object localObject1 = this.f.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
      if ((localObject2 != null) && (((Integer)((Map.Entry)localObject2).getValue()).intValue() == paramInt))
      {
        localObject1 = (String)((Map.Entry)localObject2).getKey();
        localObject2 = (Integer)this.h.get(localObject1);
        if (localObject2 != null)
        {
          b((String)localObject1, ((Integer)localObject2).intValue());
          this.h.remove(localObject1);
        }
      }
    }
  }
  
  public void a(ILogAdapter paramILogAdapter)
  {
    this.n = paramILogAdapter;
  }
  
  public void a(HippySessionView paramHippySessionView)
  {
    paramHippySessionView = Integer.valueOf(paramHippySessionView.getRootId());
    if (this.j.containsKey(paramHippySessionView))
    {
      c(paramHippySessionView.intValue());
      this.j.remove(paramHippySessionView);
    }
  }
  
  public void a(HippySessionView paramHippySessionView, HippyMap paramHippyMap)
  {
    paramHippyMap = Integer.valueOf(a(paramHippyMap));
    if (paramHippyMap.intValue() == -1) {
      return;
    }
    paramHippySessionView.setRootId(paramHippyMap.intValue());
    this.j.put(paramHippyMap, paramHippySessionView);
  }
  
  public void a(HippyWormholeView paramHippyWormholeView)
  {
    String str = paramHippyWormholeView.getWormholeId();
    View localView;
    if (this.i.containsKey(str))
    {
      localView = ((ITKDWormhole)this.i.get(str)).getView();
      if (localView != null)
      {
        a(paramHippyWormholeView, localView);
        a(str, localView);
        WormholeLogUtils.a("hippy_wormhole", "do onServerBatchComplete for web");
        return;
      }
      WormholeLogUtils.a("hippy_wormhole", "do onServerBatchComplete for web parent null");
      return;
    }
    if (this.l.containsKey(str))
    {
      localView = (View)this.l.get(str);
      if (localView != null)
      {
        a(paramHippyWormholeView, localView);
        b(paramHippyWormholeView, localView);
        a(str, localView);
        WormholeLogUtils.a("hippy_wormhole", "do onServerBatchComplete for native");
        return;
      }
      WormholeLogUtils.a("hippy_wormhole", "do onServerBatchComplete for native parent null");
      return;
    }
    paramHippyWormholeView = new StringBuilder();
    paramHippyWormholeView.append("do onServerBatchComplete donot containsKey:");
    paramHippyWormholeView.append(str);
    WormholeLogUtils.a("hippy_wormhole", paramHippyWormholeView.toString());
  }
  
  public void a(HippyEngine paramHippyEngine)
  {
    this.e = paramHippyEngine;
  }
  
  public void a(HippyMap paramHippyMap, String paramString, Integer paramInteger, int paramInt)
  {
    UIThreadUtils.a(new WormholeManager.1(this, paramString, paramInteger, paramInt, paramHippyMap));
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject != null) && (!this.m.contains(paramObject)))
    {
      this.m.add(paramObject);
      if ((paramObject instanceof HippyEngine))
      {
        paramObject = (HippyEngine)paramObject;
        if (paramObject.getEngineContext() == null)
        {
          WormholeLogUtils.b("hippy_wormhole", "registerClientEngine WormholeDomActionInterceptor error because getEngineContext null");
          return;
        }
        if (paramObject.getEngineContext().getDomManager() == null)
        {
          WormholeLogUtils.b("hippy_wormhole", "registerClientEngine WormholeDomActionInterceptor error because getDomManager null");
          return;
        }
        WormholeDomActionInterceptor localWormholeDomActionInterceptor = new WormholeDomActionInterceptor();
        this.k.put(Integer.valueOf(paramObject.getId()), localWormholeDomActionInterceptor);
        paramObject.getEngineContext().getDomManager().addActionInterceptor(localWormholeDomActionInterceptor);
      }
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if ((!TextUtils.isEmpty(paramString)) && ((this.l.get(paramString) instanceof ViewGroup)))
    {
      Object localObject2 = (ViewGroup)this.l.get(paramString);
      if (((ViewGroup)localObject2).getChildCount() > 0)
      {
        Object localObject1 = ((ViewGroup)localObject2).getChildAt(0);
        if ((localObject1 instanceof HippyWormholeView))
        {
          ((ViewGroup)localObject2).removeView((View)localObject1);
          localObject2 = a(Integer.valueOf(paramInt));
          if ((localObject2 != null) && (this.e != null))
          {
            ((HippySessionView)localObject2).addView((View)localObject1);
            HippyEngineContext localHippyEngineContext = this.e.getEngineContext();
            if (localHippyEngineContext != null)
            {
              localHippyEngineContext.getRenderManager().getControllerManager().deleteChild(((HippySessionView)localObject2).getId(), ((View)localObject1).getId());
              localObject1 = localHippyEngineContext.getRenderManager().getRenderNode(((View)localObject1).getId());
              if (localObject1 != null) {
                ((RenderNode)localObject1).setLazy(true);
              }
            }
          }
        }
      }
      this.l.remove(paramString);
      this.a.remove(paramString);
    }
  }
  
  public void a(String paramString, HippyWormholeView paramHippyWormholeView)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!this.a.containsKey(paramString)) && (this.l.containsKey(paramString))) {
      this.a.put(paramString, paramHippyWormholeView);
    }
    a(paramHippyWormholeView);
  }
  
  public boolean a(ITKDWormhole paramITKDWormhole, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.f.containsKey(paramString)))
    {
      this.i.put(paramString, paramITKDWormhole);
      View localView = a(paramString);
      if (localView != null)
      {
        int i1 = ((Integer)this.f.get(paramString)).intValue();
        if ((paramITKDWormhole.getView() instanceof TKDWormholeView)) {
          paramITKDWormhole.getView().setId(i1);
        }
        a(localView, paramITKDWormhole.getView());
        a(paramString, paramITKDWormhole.getView());
        return true;
      }
      return false;
    }
    paramITKDWormhole = new StringBuilder();
    paramITKDWormhole.append("onCreateTKDWormholeView error for wormholeId:");
    paramITKDWormhole.append(paramString);
    paramITKDWormhole.append(",containsKey:");
    paramITKDWormhole.append(this.f.containsKey(paramString));
    WormholeLogUtils.b("hippy_wormhole", paramITKDWormhole.toString());
    return false;
  }
  
  public boolean a(HippyEngineContext paramHippyEngineContext)
  {
    HippyEngine localHippyEngine = this.e;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localHippyEngine != null)
    {
      if (paramHippyEngineContext == null) {
        return false;
      }
      bool1 = bool2;
      if (localHippyEngine.getEngineContext() == paramHippyEngineContext) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public String b()
  {
    int i1 = c.getAndIncrement();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(i1);
    return localStringBuilder.toString();
  }
  
  public String b(HippyMap paramHippyMap)
  {
    paramHippyMap = paramHippyMap.getMap("params");
    if (paramHippyMap == null) {
      return null;
    }
    return paramHippyMap.getString("wormholeId");
  }
  
  public void b(int paramInt)
  {
    if (this.e == null)
    {
      WormholeLogUtils.b("hippy_wormhole", "sendRootDeleteMessageToClient mWormholeEngine null");
      return;
    }
    HippyArray localHippyArray = new HippyArray();
    localHippyArray.pushInt(paramInt);
    this.e.sendEvent("Wormhole.rootDeleted", localHippyArray);
  }
  
  public void b(TKDWormholeView paramTKDWormholeView)
  {
    if (paramTKDWormholeView.getChildCount() > 0)
    {
      View localView = paramTKDWormholeView.getChildAt(0);
      if ((localView instanceof HippyWormholeView))
      {
        paramTKDWormholeView.removeView(localView);
        paramTKDWormholeView = a(paramTKDWormholeView);
        if ((paramTKDWormholeView != null) && (this.e != null))
        {
          paramTKDWormholeView.addView(localView);
          HippyEngineContext localHippyEngineContext = this.e.getEngineContext();
          if (localHippyEngineContext != null)
          {
            localHippyEngineContext.getRenderManager().getControllerManager().deleteChild(paramTKDWormholeView.getId(), localView.getId());
            paramTKDWormholeView = localHippyEngineContext.getRenderManager().getRenderNode(localView.getId());
            if (paramTKDWormholeView != null) {
              paramTKDWormholeView.setLazy(true);
            }
          }
        }
      }
    }
  }
  
  public void b(Object paramObject)
  {
    if (this.m.contains(paramObject))
    {
      this.m.remove(paramObject);
      if ((paramObject instanceof HippyEngine)) {
        try
        {
          paramObject = (HippyEngine)paramObject;
          localObject = (WormholeDomActionInterceptor)this.k.get(Integer.valueOf(paramObject.getId()));
          paramObject.getEngineContext().getDomManager().removeActionInterceptor((DomActionInterceptor)localObject);
          this.k.remove(Integer.valueOf(paramObject.getId()));
          return;
        }
        catch (Exception paramObject)
        {
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append("unRegisterClientEngine hippy engine  error:");
          ((StringBuilder)localObject).append(paramObject.getMessage());
          WormholeLogUtils.b("hippy_wormhole", ((StringBuilder)localObject).toString());
        }
      }
    }
  }
  
  public ILogAdapter c()
  {
    return this.n;
  }
  
  public void c(HippyMap paramHippyMap)
  {
    HippyEngine localHippyEngine = this.e;
    if ((localHippyEngine != null) && (paramHippyMap != null)) {
      localHippyEngine.sendEvent("onWormholeMessageReceived", paramHippyMap);
    }
  }
  
  public void d(HippyMap paramHippyMap)
  {
    int i1 = 0;
    while (i1 < this.m.size())
    {
      if (this.m.get(i1) != null)
      {
        Object localObject;
        if ((this.m.get(i1) instanceof IClientEngine))
        {
          localObject = (IClientEngine)this.m.get(i1);
          if (((IClientEngine)localObject).getRootId() == paramHippyMap.getInt("rootTag")) {
            ((IClientEngine)localObject).a("onWormholeMessageReceived", paramHippyMap);
          }
        }
        else if ((this.m.get(i1) instanceof HippyEngine))
        {
          localObject = (HippyEngine)this.m.get(i1);
          if ((((HippyEngine)localObject).getEngineContext() != null) && (((HippyEngine)localObject).getEngineContext().getInstance(paramHippyMap.getInt("rootTag")) != null))
          {
            ((HippyEngine)localObject).sendEvent("onWormholeMessageReceived", paramHippyMap);
            return;
          }
        }
      }
      i1 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.wormhole.WormholeManager
 * JD-Core Version:    0.7.0.1
 */