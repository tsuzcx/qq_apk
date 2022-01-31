package com.tencent.mobileqq.apollo.game;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;
import yly;

public class ApolloFragmentManager
{
  public static ApolloFragmentManager a;
  public static Stack a;
  public static AtomicInteger a;
  public static Stack b;
  private int jdField_a_of_type_Int;
  private Fragment jdField_a_of_type_AndroidSupportV4AppFragment;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private FragmentManager jdField_a_of_type_AndroidSupportV4AppFragmentManager;
  
  static
  {
    jdField_a_of_type_JavaUtilStack = new Stack();
    b = new Stack();
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  }
  
  public static ApolloFragmentManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqApolloGameApolloFragmentManager == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqApolloGameApolloFragmentManager == null) {
        jdField_a_of_type_ComTencentMobileqqApolloGameApolloFragmentManager = new ApolloFragmentManager();
      }
      return jdField_a_of_type_ComTencentMobileqqApolloGameApolloFragmentManager;
    }
    finally {}
  }
  
  private void b(Stack paramStack)
  {
    if ((paramStack != null) && (paramStack.size() > 0) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentManager != null))
    {
      FragmentTransaction localFragmentTransaction = this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.beginTransaction();
      paramStack = paramStack.iterator();
      while (paramStack.hasNext())
      {
        Fragment localFragment = (Fragment)paramStack.next();
        if ((localFragment != null) && (localFragment.isAdded()) && ((this.jdField_a_of_type_AndroidSupportV4AppFragment == null) || (!localFragment.equals(this.jdField_a_of_type_AndroidSupportV4AppFragment)))) {
          localFragmentTransaction.hide(localFragment);
        }
      }
      localFragmentTransaction.commitAllowingStateLoss();
    }
  }
  
  public int a()
  {
    if (jdField_a_of_type_JavaUtilStack == null) {
      return 0;
    }
    return jdField_a_of_type_JavaUtilStack.size();
  }
  
  public ApolloFragment a()
  {
    return (ApolloFragment)jdField_a_of_type_JavaUtilStack.peek();
  }
  
  public void a()
  {
    a(jdField_a_of_type_JavaUtilStack);
    a(b);
    jdField_a_of_type_JavaUtilStack.clear();
    b.clear();
    ApolloGameResManager.a().a();
  }
  
  public void a(Intent paramIntent)
  {
    if (jdField_a_of_type_JavaUtilStack.size() > 1)
    {
      localApolloFragment = (ApolloFragment)jdField_a_of_type_JavaUtilStack.pop();
      if (localApolloFragment != null)
      {
        localApolloFragment.a(null);
        b.push(localApolloFragment);
      }
      localApolloFragment = (ApolloFragment)jdField_a_of_type_JavaUtilStack.peek();
      if (localApolloFragment != null)
      {
        localBundle = new Bundle();
        if (paramIntent != null)
        {
          localBundle.putParcelable("intent", paramIntent);
          localApolloFragment.b(paramIntent.getExtras());
        }
      }
      b();
    }
    while (!QLog.isColorLevel())
    {
      ApolloFragment localApolloFragment;
      Bundle localBundle;
      return;
    }
    QLog.d("ApolloFragmentManager", 2, "[back] reach bottom");
  }
  
  /* Error */
  public void a(Intent paramIntent, java.lang.Class paramClass)
  {
    // Byte code:
    //   0: getstatic 24	com/tencent/mobileqq/apollo/game/ApolloFragmentManager:b	Ljava/util/Stack;
    //   3: invokevirtual 154	java/util/Stack:empty	()Z
    //   6: ifeq +34 -> 40
    //   9: aconst_null
    //   10: astore_3
    //   11: aload_3
    //   12: ifnull +41 -> 53
    //   15: getstatic 22	com/tencent/mobileqq/apollo/game/ApolloFragmentManager:jdField_a_of_type_JavaUtilStack	Ljava/util/Stack;
    //   18: aload_3
    //   19: invokevirtual 116	java/util/Stack:push	(Ljava/lang/Object;)Ljava/lang/Object;
    //   22: pop
    //   23: aload_1
    //   24: ifnull +11 -> 35
    //   27: aload_3
    //   28: aload_1
    //   29: invokevirtual 131	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   32: invokevirtual 133	com/tencent/mobileqq/apollo/game/ApolloFragment:b	(Landroid/os/Bundle;)V
    //   35: aload_0
    //   36: invokevirtual 135	com/tencent/mobileqq/apollo/game/ApolloFragmentManager:b	()V
    //   39: return
    //   40: getstatic 24	com/tencent/mobileqq/apollo/game/ApolloFragmentManager:b	Ljava/util/Stack;
    //   43: invokevirtual 109	java/util/Stack:pop	()Ljava/lang/Object;
    //   46: checkcast 93	com/tencent/mobileqq/apollo/game/ApolloFragment
    //   49: astore_3
    //   50: goto -39 -> 11
    //   53: ldc 2
    //   55: monitorenter
    //   56: new 118	android/os/Bundle
    //   59: dup
    //   60: invokespecial 119	android/os/Bundle:<init>	()V
    //   63: astore_3
    //   64: aload_1
    //   65: ifnull +90 -> 155
    //   68: aload_1
    //   69: ldc 156
    //   71: iconst_1
    //   72: invokevirtual 160	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   75: pop
    //   76: aload_3
    //   77: ldc 121
    //   79: aload_1
    //   80: invokevirtual 125	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   83: aload_2
    //   84: invokevirtual 165	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   87: checkcast 93	com/tencent/mobileqq/apollo/game/ApolloFragment
    //   90: astore_2
    //   91: aload_1
    //   92: ldc 167
    //   94: getstatic 31	com/tencent/mobileqq/apollo/game/ApolloFragmentManager:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   97: invokevirtual 170	java/util/concurrent/atomic/AtomicInteger:getAndIncrement	()I
    //   100: invokevirtual 173	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   103: pop
    //   104: aload_2
    //   105: aload_3
    //   106: invokevirtual 176	com/tencent/mobileqq/apollo/game/ApolloFragment:setArguments	(Landroid/os/Bundle;)V
    //   109: getstatic 22	com/tencent/mobileqq/apollo/game/ApolloFragmentManager:jdField_a_of_type_JavaUtilStack	Ljava/util/Stack;
    //   112: aload_2
    //   113: invokevirtual 116	java/util/Stack:push	(Ljava/lang/Object;)Ljava/lang/Object;
    //   116: pop
    //   117: aload_0
    //   118: getfield 36	com/tencent/mobileqq/apollo/game/ApolloFragmentManager:jdField_a_of_type_AndroidSupportV4AppFragmentActivity	Landroid/support/v4/app/FragmentActivity;
    //   121: invokevirtual 182	android/support/v4/app/FragmentActivity:getIntent	()Landroid/content/Intent;
    //   124: astore_3
    //   125: aload_3
    //   126: aload_1
    //   127: invokevirtual 186	android/content/Intent:putExtras	(Landroid/content/Intent;)Landroid/content/Intent;
    //   130: pop
    //   131: aload_2
    //   132: aload_1
    //   133: invokevirtual 131	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   136: invokevirtual 133	com/tencent/mobileqq/apollo/game/ApolloFragment:b	(Landroid/os/Bundle;)V
    //   139: aload_2
    //   140: aload_1
    //   141: invokevirtual 131	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   144: invokevirtual 189	com/tencent/mobileqq/apollo/game/ApolloFragment:c	(Landroid/os/Bundle;)V
    //   147: aload_0
    //   148: getfield 36	com/tencent/mobileqq/apollo/game/ApolloFragmentManager:jdField_a_of_type_AndroidSupportV4AppFragmentActivity	Landroid/support/v4/app/FragmentActivity;
    //   151: aload_3
    //   152: invokevirtual 192	android/support/v4/app/FragmentActivity:setIntent	(Landroid/content/Intent;)V
    //   155: ldc 2
    //   157: monitorexit
    //   158: goto -123 -> 35
    //   161: astore_1
    //   162: ldc 2
    //   164: monitorexit
    //   165: aload_1
    //   166: athrow
    //   167: astore_1
    //   168: ldc 142
    //   170: iconst_1
    //   171: aload_1
    //   172: iconst_0
    //   173: anewarray 4	java/lang/Object
    //   176: invokestatic 196	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   179: goto -24 -> 155
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	this	ApolloFragmentManager
    //   0	182	1	paramIntent	Intent
    //   0	182	2	paramClass	java.lang.Class
    //   10	142	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   56	64	161	finally
    //   68	83	161	finally
    //   83	155	161	finally
    //   155	158	161	finally
    //   162	165	161	finally
    //   168	179	161	finally
    //   83	155	167	java/lang/Throwable
  }
  
  public void a(FragmentActivity paramFragmentActivity, int paramInt)
  {
    if (paramFragmentActivity != null)
    {
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramFragmentActivity;
      this.jdField_a_of_type_AndroidSupportV4AppFragmentManager = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSupportFragmentManager();
      return;
    }
    QLog.e("ApolloFragmentManager", 1, "[init] activity null");
  }
  
  public void a(Stack paramStack)
  {
    if ((paramStack != null) && (paramStack.size() > 0))
    {
      paramStack = paramStack.iterator();
      while (paramStack.hasNext())
      {
        ApolloFragment localApolloFragment = (ApolloFragment)paramStack.next();
        if ((localApolloFragment.isAdded()) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentManager != null)) {
          this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.beginTransaction().remove(localApolloFragment).commit();
        }
      }
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentManager != null)
    {
      ApolloFragment localApolloFragment = (ApolloFragment)jdField_a_of_type_JavaUtilStack.peek();
      if (localApolloFragment != null)
      {
        QLog.e("ApolloFragmentManager", 1, "[notifyViewChange] " + localApolloFragment.b() + " " + localApolloFragment.a());
        if (!localApolloFragment.isAdded()) {
          this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.beginTransaction().add(this.jdField_a_of_type_Int, localApolloFragment).commit();
        }
        this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.beginTransaction().show(localApolloFragment).setCustomAnimations(2131034175, 2131034176).commit();
        this.jdField_a_of_type_AndroidSupportV4AppFragment = localApolloFragment;
        b(b);
        b(jdField_a_of_type_JavaUtilStack);
        if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()) && ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof ApolloGameActivity))) {
          this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new yly(this, localApolloFragment));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloFragmentManager
 * JD-Core Version:    0.7.0.1
 */