package com.tencent.mobileqq.apollo.script;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.IApolloRenderView;
import com.tencent.mobileqq.apollo.data.ApolloRoleInfo;
import com.tencent.mobileqq.apollo.script.callback.ISpriteDrawerInfoCallback;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class SpriteContext
{
  public int a;
  public SharedPreferences a;
  public ApolloRoleInfo a;
  private SpriteRscBuilder a;
  public String a;
  public WeakReference a;
  public Set a;
  public AtomicBoolean a;
  public boolean a;
  public int b;
  public String b;
  public WeakReference b;
  private AtomicBoolean b;
  public int c;
  public WeakReference c;
  private AtomicBoolean c;
  public int d;
  private WeakReference d;
  
  public SpriteContext(QQAppInterface paramQQAppInterface)
  {
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_d_of_type_Int = 0;
    if (paramQQAppInterface == null)
    {
      QLog.e("cmshow_scripted_SpriteContext", 1, "[SpriteContext], app is null.");
      return;
    }
    a(paramQQAppInterface);
    this.jdField_b_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
    this.jdField_a_of_type_AndroidContentSharedPreferences = SharedPreferencesProxyManager.getInstance().getProxy("apollo_sp", 0);
    a();
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
    if (this.jdField_b_of_type_JavaLangRefWeakReference == null) {
      return null;
    }
    return (QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidContentSharedPreferences != null) {
      this.jdField_c_of_type_Int = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("sprite_hide_key" + this.jdField_b_of_type_JavaLangString, -1);
    }
  }
  
  public void a(int paramInt)
  {
    IApolloRenderView localIApolloRenderView = a();
    if (localIApolloRenderView != null) {
      localIApolloRenderView.setBubbleType(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_d_of_type_Int = paramInt2;
    if (this.jdField_d_of_type_Int == 0)
    {
      if ((1 != paramInt1) && (3000 != paramInt1)) {
        break label43;
      }
      this.jdField_b_of_type_Int = 1;
    }
    for (;;)
    {
      a(this.jdField_b_of_type_Int);
      return;
      label43:
      if (paramInt1 == 0) {
        this.jdField_b_of_type_Int = 0;
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
    this.jdField_a_of_type_ComTencentMobileqqApolloDataApolloRoleInfo = paramApolloRoleInfo;
  }
  
  public void a(SpriteRscBuilder paramSpriteRscBuilder)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder = paramSpriteRscBuilder;
  }
  
  public void a(ISpriteDrawerInfoCallback paramISpriteDrawerInfoCallback)
  {
    this.jdField_d_of_type_JavaLangRefWeakReference = new WeakReference(paramISpriteDrawerInfoCallback);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
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
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.jdField_c_of_type_Int = i;
      if (this.jdField_a_of_type_AndroidContentSharedPreferences != null) {
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("sprite_hide_key" + this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_Int).commit();
      }
      return;
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 3000);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean != null) {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    }
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean != null) {
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilSet.clear();
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean != null) {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(paramBoolean);
    }
  }
  
  protected boolean b()
  {
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        QLog.i("cmshow_scripted_SpriteContext", 1, "cmshow should hide from:" + str);
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
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean != null) {
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(paramBoolean);
    }
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean == null) {
      return false;
    }
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public boolean d()
  {
    if (!e()) {
      return true;
    }
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean == null) {
      return false;
    }
    return this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public boolean e()
  {
    if (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean == null)
    {
      this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
      this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(ApolloManager.e());
    }
    return this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteContext
 * JD-Core Version:    0.7.0.1
 */