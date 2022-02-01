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
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  public ApolloRoleInfo a;
  private SpriteRscBuilder jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder;
  private ICMShowEngine jdField_a_of_type_ComTencentMobileqqCmshowEngineICMShowEngine;
  public String a;
  public WeakReference<BaseChatPie> a;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public boolean a;
  public int b;
  public String b;
  public WeakReference<QQAppInterface> b;
  private AtomicBoolean b;
  public boolean b;
  public int c;
  private WeakReference<ISpriteDrawerInfoCallback> jdField_c_of_type_JavaLangRefWeakReference;
  private AtomicBoolean jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public boolean c;
  public int d;
  private AtomicBoolean jdField_d_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  private boolean jdField_d_of_type_Boolean = false;
  private int e = -1;
  private int f;
  
  public SpriteContext(QQAppInterface paramQQAppInterface)
  {
    this.jdField_c_of_type_Int = -1;
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_d_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    if (paramQQAppInterface == null)
    {
      QLog.e("[cmshow][scripted]SpriteContext", 1, "[SpriteContext], app is null.");
      return;
    }
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_b_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
    a();
    this.jdField_a_of_type_AndroidContentSharedPreferences = SharedPreferencesProxyManager.getInstance().getProxy("apollo_sp", 0);
    b();
  }
  
  public int a()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public BaseChatPie a()
  {
    WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localWeakReference == null) {
      return null;
    }
    return (BaseChatPie)localWeakReference.get();
  }
  
  public SpriteRscBuilder a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder;
  }
  
  public ISpriteDrawerInfoCallback a()
  {
    WeakReference localWeakReference = this.jdField_c_of_type_JavaLangRefWeakReference;
    if (localWeakReference == null) {
      return null;
    }
    return (ISpriteDrawerInfoCallback)localWeakReference.get();
  }
  
  public QQAppInterface a()
  {
    return (QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get();
  }
  
  public ICMShowEngine a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqCmshowEngineICMShowEngine;
  }
  
  public IResourceService a()
  {
    ICMShowEngine localICMShowEngine = a();
    if (localICMShowEngine == null) {
      return null;
    }
    return localICMShowEngine.a();
  }
  
  public IScriptService a()
  {
    ICMShowEngine localICMShowEngine = a();
    if (localICMShowEngine == null) {
      return null;
    }
    return localICMShowEngine.a();
  }
  
  @Nullable
  public InitSpriteTask a(String paramString)
  {
    Object localObject = a();
    if (localObject == null)
    {
      QLog.w("[cmshow][scripted]SpriteContext", 1, "getInitSpriteTask but scriptService null");
      return null;
    }
    localObject = (InitSpriteTask)((IScriptService)localObject).a().a(ScriptTaskType.INIT_SPRITE);
    ((InitSpriteTask)localObject).a(this.jdField_a_of_type_Int).a(this.jdField_a_of_type_JavaLangString).b(this.jdField_b_of_type_JavaLangString).a(this.jdField_c_of_type_Boolean);
    ((InitSpriteTask)localObject).b(d()).b(this.jdField_d_of_type_Int);
    if (this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloRoleInfo != null)
    {
      AbsScriptTask.RoleInfo localRoleInfo = new AbsScriptTask.RoleInfo();
      localRoleInfo.a = this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloRoleInfo.scale;
      localRoleInfo.b = this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloRoleInfo.xPos;
      localRoleInfo.c = this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloRoleInfo.yPos;
      ((InitSpriteTask)localObject).a(localRoleInfo);
    }
    ((InitSpriteTask)localObject).a(paramString);
    return localObject;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void a()
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface != null)
    {
      this.jdField_b_of_type_Int = ((IApolloManagerService)localQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getApolloUserStatus();
      return;
    }
    this.jdField_b_of_type_Int = 0;
  }
  
  public void a(int paramInt)
  {
    if (a() != null) {
      a().a().a(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_d_of_type_Int = paramInt2;
    if (this.jdField_d_of_type_Int == 0) {
      if (CmShowAioMatcherImpl.judgeSupported(paramInt1, 2)) {
        this.jdField_c_of_type_Int = 1;
      } else if (CmShowAioMatcherImpl.judgeSupported(paramInt1, 1)) {
        this.jdField_c_of_type_Int = 0;
      }
    }
    a(this.jdField_c_of_type_Int);
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseChatPie);
  }
  
  public void a(ApolloRoleInfo paramApolloRoleInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloRoleInfo = paramApolloRoleInfo;
  }
  
  public void a(SpriteRscBuilder paramSpriteRscBuilder)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder = paramSpriteRscBuilder;
  }
  
  public void a(ISpriteDrawerInfoCallback paramISpriteDrawerInfoCallback)
  {
    this.jdField_c_of_type_JavaLangRefWeakReference = new WeakReference(paramISpriteDrawerInfoCallback);
  }
  
  public void a(ICMShowEngine paramICMShowEngine)
  {
    this.jdField_a_of_type_ComTencentMobileqqCmshowEngineICMShowEngine = paramICMShowEngine;
  }
  
  public void a(Script paramScript)
  {
    ICMShowEngine localICMShowEngine = a();
    if (localICMShowEngine == null)
    {
      QLog.w("[cmshow][scripted]SpriteContext", 1, "[execScriptInRenderThread], error, none renderView of cmshowEngine");
      return;
    }
    localICMShowEngine.a().a(paramScript);
  }
  
  public void a(String paramString)
  {
    a(new Script(paramString));
  }
  
  public void a(String paramString1, String paramString2)
  {
    Object localObject = a();
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
      this.jdField_a_of_type_JavaUtilSet.add(paramString);
      break label31;
      this.jdField_a_of_type_JavaUtilSet.remove(paramString);
      label31:
      return;
    }
    finally {}
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_AndroidContentSharedPreferences;
    if (localSharedPreferences != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sprite_hide_key");
      localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
      this.e = localSharedPreferences.getInt(localStringBuilder.toString(), -1);
    }
    return this.e == 1;
  }
  
  public boolean a(String paramString)
  {
    try
    {
      boolean bool = this.jdField_a_of_type_JavaUtilSet.contains(paramString);
      return bool;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void b()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_AndroidContentSharedPreferences;
    if (localSharedPreferences != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sprite_hide_key");
      localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
      this.e = localSharedPreferences.getInt(localStringBuilder.toString(), -1);
    }
  }
  
  public void b(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
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
        TraceReportUtil.a(this.f, 10, 104, new Object[] { "cmshow should hide from:", str });
      }
      int i = this.jdField_a_of_type_JavaUtilSet.size();
      if (i > 0) {
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
  
  public int c()
  {
    return this.f;
  }
  
  public void c()
  {
    QLog.w("[cmshow][scripted]SpriteContext", 1, "clear");
    f(false);
    g(false);
    h(false);
    a(null);
    QQAppInterface localQQAppInterface = a();
    Object localObject = this.jdField_a_of_type_AndroidContentSharedPreferences;
    if ((localObject != null) && (localQQAppInterface != null))
    {
      localObject = ((SharedPreferences)localObject).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("is_add_new_game");
      localStringBuilder.append(localQQAppInterface.getCurrentAccountUin());
      ((SharedPreferences.Editor)localObject).remove(localStringBuilder.toString()).commit();
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilSet.clear();
    this.jdField_d_of_type_Boolean = false;
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean d()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public void e(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public boolean e()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void f(boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(paramBoolean);
  }
  
  public boolean f()
  {
    return this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public void g(boolean paramBoolean)
  {
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(paramBoolean);
  }
  
  public boolean g()
  {
    if (!h()) {
      return true;
    }
    return this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public void h(boolean paramBoolean)
  {
    this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(paramBoolean);
  }
  
  public boolean h()
  {
    if (this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicBoolean == null)
    {
      boolean bool = false;
      this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
      QQAppInterface localQQAppInterface = a();
      if (localQQAppInterface != null) {
        bool = ((ApolloManagerServiceImpl)localQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).isApolloBackgroundActionSwitchOpen();
      }
      this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(bool);
    }
    return this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public boolean i()
  {
    return this.jdField_b_of_type_Int != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteContext
 * JD-Core Version:    0.7.0.1
 */