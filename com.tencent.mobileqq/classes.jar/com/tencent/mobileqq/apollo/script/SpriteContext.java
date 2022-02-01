package com.tencent.mobileqq.apollo.script;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.aio.api.impl.CmShowAioMatcherImpl;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.model.ApolloRoleInfo;
import com.tencent.mobileqq.apollo.script.callback.ISpriteDrawerInfoCallback;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.cmshow.engine.ICMShowEngine;
import com.tencent.mobileqq.cmshow.engine.model.BusinessConfig;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager;
import com.tencent.mobileqq.cmshow.engine.resource.IResourceService;
import com.tencent.mobileqq.cmshow.engine.script.IScriptService;
import com.tencent.mobileqq.cmshow.engine.script.Script;
import com.tencent.mobileqq.cmshow.engine.script.task.AbsScriptTask;
import com.tencent.mobileqq.cmshow.engine.script.task.AbsScriptTask.RoleInfo;
import com.tencent.mobileqq.cmshow.engine.script.task.IScriptTaskBuilder;
import com.tencent.mobileqq.cmshow.engine.script.task.InitSpriteTask;
import com.tencent.mobileqq.cmshow.engine.script.task.ScriptTaskType;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class SpriteContext
  implements ISpriteContext
{
  public int a;
  public String b;
  public String c;
  public int d;
  public int e = -1;
  public boolean f;
  public WeakReference<BaseChatPie> g;
  public WeakReference<QQAppInterface> h;
  public int i = 0;
  public boolean j = false;
  public ApolloRoleInfo k;
  public boolean l = false;
  private ICMShowEngine m;
  private AtomicBoolean n = new AtomicBoolean(false);
  private AtomicBoolean o = new AtomicBoolean(false);
  private AtomicBoolean p = new AtomicBoolean(false);
  private AtomicBoolean q;
  private int r = -1;
  private Set<String> s = new HashSet();
  private SharedPreferences t;
  private WeakReference<ISpriteDrawerInfoCallback> u;
  private SpriteRscBuilder v;
  private int w;
  private boolean x = false;
  
  public SpriteContext(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null)
    {
      QLog.e("[cmshow][scripted]SpriteContext", 1, "[SpriteContext], app is null.");
      return;
    }
    this.h = new WeakReference(paramQQAppInterface);
    this.c = paramQQAppInterface.getCurrentAccountUin();
    j();
    this.t = SharedPreferencesProxyManager.getInstance().getProxy("apollo_sp", 0);
    k();
  }
  
  public void a(int paramInt)
  {
    if (n() != null) {
      n().j().a(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.i = paramInt2;
    if (this.i == 0) {
      if (CmShowAioMatcherImpl.judgeSupported(paramInt1, 2)) {
        this.e = 1;
      } else if (CmShowAioMatcherImpl.judgeSupported(paramInt1, 1)) {
        this.e = 0;
      }
    }
    a(this.e);
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    this.g = new WeakReference(paramBaseChatPie);
  }
  
  public void a(ApolloRoleInfo paramApolloRoleInfo)
  {
    this.k = paramApolloRoleInfo;
  }
  
  public void a(SpriteRscBuilder paramSpriteRscBuilder)
  {
    this.v = paramSpriteRscBuilder;
  }
  
  public void a(ISpriteDrawerInfoCallback paramISpriteDrawerInfoCallback)
  {
    this.u = new WeakReference(paramISpriteDrawerInfoCallback);
  }
  
  public void a(ICMShowEngine paramICMShowEngine)
  {
    this.m = paramICMShowEngine;
  }
  
  public void a(Script paramScript)
  {
    ICMShowEngine localICMShowEngine = n();
    if (localICMShowEngine == null)
    {
      QLog.w("[cmshow][scripted]SpriteContext", 1, "[execScriptInRenderThread], error, none renderView of cmshowEngine");
      return;
    }
    localICMShowEngine.e().a(paramScript);
  }
  
  public void a(String paramString1, String paramString2)
  {
    Object localObject = o();
    if (localObject != null)
    {
      ((IScriptService)localObject).a(paramString1, paramString2);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onNativeEvent error!! scriptService null, cmd:");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(", respData:");
    ((StringBuilder)localObject).append(paramString2);
    QLog.e("[cmshow][scripted]SpriteContext", 1, ((StringBuilder)localObject).toString());
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      this.s.add(paramString);
      break label31;
      this.s.remove(paramString);
      label31:
      return;
    }
    finally {}
  }
  
  public void a(boolean paramBoolean)
  {
    this.x = paramBoolean;
  }
  
  public boolean a()
  {
    SharedPreferences localSharedPreferences = this.t;
    if (localSharedPreferences != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sprite_hide_key");
      localStringBuilder.append(this.c);
      this.r = localSharedPreferences.getInt(localStringBuilder.toString(), -1);
    }
    return this.r == 1;
  }
  
  public boolean a(String paramString)
  {
    try
    {
      boolean bool = this.s.contains(paramString);
      return bool;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void b(int paramInt)
  {
    this.w = paramInt;
  }
  
  public void b(String paramString)
  {
    a(new Script(paramString));
  }
  
  public void b(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public boolean b()
  {
    try
    {
      Iterator localIterator = this.s.iterator();
      boolean bool1;
      for (;;)
      {
        boolean bool2 = localIterator.hasNext();
        bool1 = false;
        if (!bool2) {
          break;
        }
        String str = (String)localIterator.next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("cmshow should hide from:");
        localStringBuilder.append(str);
        QLog.i("[cmshow][scripted]SpriteContext", 1, localStringBuilder.toString());
        TraceReportUtil.a(this.w, 10, 104, new Object[] { "cmshow should hide from:", str });
      }
      int i1 = this.s.size();
      if (i1 > 0) {
        bool1 = true;
      }
      return bool1;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void c(String paramString)
  {
    this.c = paramString;
  }
  
  public void c(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public boolean c()
  {
    return this.n.get();
  }
  
  @Nullable
  public InitSpriteTask d(String paramString)
  {
    Object localObject = o();
    if (localObject == null)
    {
      QLog.w("[cmshow][scripted]SpriteContext", 1, "getInitSpriteTask but scriptService null");
      return null;
    }
    localObject = (InitSpriteTask)((IScriptService)localObject).b().a(ScriptTaskType.INIT_SPRITE);
    ((InitSpriteTask)localObject).a(this.a).a(this.b).b(this.c).a(this.l);
    ((InitSpriteTask)localObject).b(d()).b(this.i);
    if (this.k != null)
    {
      AbsScriptTask.RoleInfo localRoleInfo = new AbsScriptTask.RoleInfo();
      localRoleInfo.a = this.k.scale;
      localRoleInfo.b = this.k.xPos;
      localRoleInfo.c = this.k.yPos;
      ((InitSpriteTask)localObject).a(localRoleInfo);
    }
    ((InitSpriteTask)localObject).c(paramString);
    return localObject;
  }
  
  public void d(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public boolean d()
  {
    return this.x;
  }
  
  public int e()
  {
    return this.i;
  }
  
  public void e(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void f(boolean paramBoolean)
  {
    this.n.set(paramBoolean);
  }
  
  public boolean f()
  {
    return this.l;
  }
  
  public String g()
  {
    return this.c;
  }
  
  public void g(boolean paramBoolean)
  {
    this.o.set(paramBoolean);
  }
  
  public String h()
  {
    return this.b;
  }
  
  public void h(boolean paramBoolean)
  {
    this.p.set(paramBoolean);
  }
  
  public int i()
  {
    return this.a;
  }
  
  public void j()
  {
    QQAppInterface localQQAppInterface = l();
    if (localQQAppInterface != null)
    {
      this.d = ((IApolloManagerService)localQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getApolloUserStatus();
      return;
    }
    this.d = 0;
  }
  
  public void k()
  {
    SharedPreferences localSharedPreferences = this.t;
    if (localSharedPreferences != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sprite_hide_key");
      localStringBuilder.append(this.c);
      this.r = localSharedPreferences.getInt(localStringBuilder.toString(), -1);
    }
  }
  
  public QQAppInterface l()
  {
    return (QQAppInterface)this.h.get();
  }
  
  public BaseChatPie m()
  {
    WeakReference localWeakReference = this.g;
    if (localWeakReference == null) {
      return null;
    }
    return (BaseChatPie)localWeakReference.get();
  }
  
  public ICMShowEngine n()
  {
    return this.m;
  }
  
  public IScriptService o()
  {
    ICMShowEngine localICMShowEngine = n();
    if (localICMShowEngine == null) {
      return null;
    }
    return localICMShowEngine.e();
  }
  
  public IResourceService p()
  {
    ICMShowEngine localICMShowEngine = n();
    if (localICMShowEngine == null) {
      return null;
    }
    return localICMShowEngine.g();
  }
  
  public IApolloResManager q()
  {
    IResourceService localIResourceService = p();
    if (localIResourceService == null) {
      return null;
    }
    return localIResourceService.a();
  }
  
  public boolean r()
  {
    return this.o.get();
  }
  
  public boolean s()
  {
    if (!t()) {
      return true;
    }
    return this.p.get();
  }
  
  public boolean t()
  {
    if (this.q == null)
    {
      boolean bool = false;
      this.q = new AtomicBoolean(false);
      QQAppInterface localQQAppInterface = l();
      if (localQQAppInterface != null) {
        bool = ((ApolloManagerServiceImpl)localQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).isApolloBackgroundActionSwitchOpen();
      }
      this.q.set(bool);
    }
    return this.q.get();
  }
  
  public ISpriteDrawerInfoCallback u()
  {
    WeakReference localWeakReference = this.u;
    if (localWeakReference == null) {
      return null;
    }
    return (ISpriteDrawerInfoCallback)localWeakReference.get();
  }
  
  public SpriteRscBuilder v()
  {
    return this.v;
  }
  
  public int w()
  {
    return this.w;
  }
  
  public boolean x()
  {
    return this.d != 0;
  }
  
  public void y()
  {
    QLog.w("[cmshow][scripted]SpriteContext", 1, "clear");
    f(false);
    g(false);
    h(false);
    a(null);
    QQAppInterface localQQAppInterface = l();
    Object localObject = this.t;
    if ((localObject != null) && (localQQAppInterface != null))
    {
      localObject = ((SharedPreferences)localObject).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("is_add_new_game");
      localStringBuilder.append(localQQAppInterface.getCurrentAccountUin());
      ((SharedPreferences.Editor)localObject).remove(localStringBuilder.toString()).commit();
    }
    this.f = false;
    this.a = -1;
    this.e = -1;
    this.s.clear();
    this.x = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteContext
 * JD-Core Version:    0.7.0.1
 */