package com.tencent.mobileqq.apollo.script;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.IApolloRenderView;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.model.ApolloRoleInfo;
import com.tencent.mobileqq.apollo.api.script.ISpriteContext;
import com.tencent.mobileqq.apollo.script.callback.ISpriteDrawerInfoCallback;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
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
  public SharedPreferences a;
  public ApolloRoleInfo a;
  private SpriteRscBuilder jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder;
  public String a;
  public WeakReference<BaseChatPie> a;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  public AtomicBoolean a;
  public boolean a;
  public int b;
  public String b;
  public WeakReference<QQAppInterface> b;
  public AtomicBoolean b;
  public boolean b;
  public int c;
  public WeakReference<IApolloRenderView> c;
  private AtomicBoolean c;
  public boolean c;
  public int d;
  private WeakReference<ISpriteDrawerInfoCallback> jdField_d_of_type_JavaLangRefWeakReference;
  private AtomicBoolean jdField_d_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  private boolean jdField_d_of_type_Boolean = false;
  public int e = 0;
  private int f;
  
  public SpriteContext(QQAppInterface paramQQAppInterface)
  {
    this.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_d_of_type_Int = -1;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    if (paramQQAppInterface == null)
    {
      QLog.e("cmshow_scripted_SpriteContext", 1, "[SpriteContext], app is null.");
      return;
    }
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_b_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
    b();
    this.jdField_a_of_type_AndroidContentSharedPreferences = SharedPreferencesProxyManager.getInstance().getProxy("apollo_sp", 0);
    a();
  }
  
  public int a()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public BaseChatPie a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      return null;
    }
    return (BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public IApolloRenderView a()
  {
    if (this.jdField_c_of_type_JavaLangRefWeakReference == null) {
      return null;
    }
    return (IApolloRenderView)this.jdField_c_of_type_JavaLangRefWeakReference.get();
  }
  
  public SpriteRscBuilder a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder;
  }
  
  public ISpriteDrawerInfoCallback a()
  {
    if (this.jdField_d_of_type_JavaLangRefWeakReference == null) {
      return null;
    }
    return (ISpriteDrawerInfoCallback)this.jdField_d_of_type_JavaLangRefWeakReference.get();
  }
  
  public QQAppInterface a()
  {
    return (QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get();
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidContentSharedPreferences != null) {
      this.jdField_d_of_type_Int = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("sprite_hide_key" + this.jdField_b_of_type_JavaLangString, -1);
    }
  }
  
  public void a(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.e = paramInt2;
    if (this.e == 0)
    {
      if ((1 != paramInt1) && (3000 != paramInt1)) {
        break label54;
      }
      this.jdField_c_of_type_Int = 1;
    }
    for (;;)
    {
      IApolloRenderView localIApolloRenderView = a();
      if (localIApolloRenderView != null) {
        localIApolloRenderView.setBubbleType(this.jdField_c_of_type_Int);
      }
      return;
      label54:
      if (paramInt1 == 0) {
        this.jdField_c_of_type_Int = 0;
      }
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseChatPie);
  }
  
  public void a(IApolloRenderView paramIApolloRenderView)
  {
    this.jdField_c_of_type_JavaLangRefWeakReference = new WeakReference(paramIApolloRenderView);
  }
  
  public void a(ApolloRoleInfo paramApolloRoleInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloRoleInfo = paramApolloRoleInfo;
  }
  
  public void a(SpriteRscBuilder paramSpriteRscBuilder)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder = paramSpriteRscBuilder;
  }
  
  public void a(ISpriteDrawerInfoCallback paramISpriteDrawerInfoCallback)
  {
    this.jdField_d_of_type_JavaLangRefWeakReference = new WeakReference(paramISpriteDrawerInfoCallback);
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_JavaUtilSet.add(paramString);
        return;
      }
      finally {}
      this.jdField_a_of_type_JavaUtilSet.remove(paramString);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_d_of_type_Int == 1;
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
    return this.e;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void b()
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface != null)
    {
      this.jdField_b_of_type_Int = ((IApolloManagerService)localQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getApolloUserStatus(localQQAppInterface);
      return;
    }
    this.jdField_b_of_type_Int = 0;
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
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        QLog.i("cmshow_scripted_SpriteContext", 1, "cmshow should hide from:" + str);
        TraceReportUtil.a(this.f, 10, 104, new Object[] { "cmshow should hide from:", str });
      }
      i = this.jdField_a_of_type_JavaUtilSet.size();
    }
    finally {}
    int i;
    if (i > 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean != null) {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    }
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean != null) {
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    }
    if (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean != null) {
      this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_JavaLangRefWeakReference = null;
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
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean == null) {
      return false;
    }
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public int d()
  {
    return this.f;
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
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.jdField_d_of_type_Int = i;
      if (this.jdField_a_of_type_AndroidContentSharedPreferences != null) {
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("sprite_hide_key" + this.jdField_b_of_type_JavaLangString, this.jdField_d_of_type_Int).commit();
      }
      return;
    }
  }
  
  public boolean e()
  {
    return (this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 3000);
  }
  
  public void f(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean != null) {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(paramBoolean);
    }
  }
  
  public boolean f()
  {
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean == null) {
      return false;
    }
    return this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public void g(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean != null) {
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(paramBoolean);
    }
  }
  
  public boolean g()
  {
    if (!h()) {
      return true;
    }
    if (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean == null) {
      return false;
    }
    return this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public void h(boolean paramBoolean)
  {
    if (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean != null) {
      this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(paramBoolean);
    }
  }
  
  public boolean h()
  {
    boolean bool = false;
    if (this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicBoolean == null)
    {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteContext
 * JD-Core Version:    0.7.0.1
 */