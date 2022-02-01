package com.tencent.mobileqq.adapter;

import android.view.View.OnClickListener;

class RobotAdapter$2
  implements View.OnClickListener
{
  RobotAdapter$2(RobotAdapter paramRobotAdapter) {}
  
  /* Error */
  public void onClick(android.view.View paramView)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore 4
    //   3: aload_0
    //   4: getfield 12	com/tencent/mobileqq/adapter/RobotAdapter$2:a	Lcom/tencent/mobileqq/adapter/RobotAdapter;
    //   7: invokestatic 25	com/tencent/mobileqq/adapter/RobotAdapter:a	(Lcom/tencent/mobileqq/adapter/RobotAdapter;)Z
    //   10: ifne +43 -> 53
    //   13: aload_0
    //   14: getfield 12	com/tencent/mobileqq/adapter/RobotAdapter$2:a	Lcom/tencent/mobileqq/adapter/RobotAdapter;
    //   17: invokestatic 28	com/tencent/mobileqq/adapter/RobotAdapter:a	(Lcom/tencent/mobileqq/adapter/RobotAdapter;)Landroid/support/v4/app/FragmentActivity;
    //   20: sipush 230
    //   23: ldc 30
    //   25: ldc 31
    //   27: invokestatic 36	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   30: new 38	com/tencent/mobileqq/adapter/RobotAdapter$2$1
    //   33: dup
    //   34: aload_0
    //   35: invokespecial 41	com/tencent/mobileqq/adapter/RobotAdapter$2$1:<init>	(Lcom/tencent/mobileqq/adapter/RobotAdapter$2;)V
    //   38: aconst_null
    //   39: invokestatic 46	com/tencent/mobileqq/utils/DialogUtil:a	(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;Landroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   42: invokevirtual 51	com/tencent/mobileqq/utils/QQCustomDialog:show	()V
    //   45: invokestatic 57	com/tencent/qqlive/module/videoreport/collect/EventCollector:getInstance	()Lcom/tencent/qqlive/module/videoreport/collect/EventCollector;
    //   48: aload_1
    //   49: invokevirtual 60	com/tencent/qqlive/module/videoreport/collect/EventCollector:onViewClicked	(Landroid/view/View;)V
    //   52: return
    //   53: aload_1
    //   54: invokevirtual 66	android/view/View:getTag	()Ljava/lang/Object;
    //   57: astore 8
    //   59: aload 8
    //   61: ifnull -16 -> 45
    //   64: aload 8
    //   66: instanceof 68
    //   69: ifeq -24 -> 45
    //   72: aload_1
    //   73: instanceof 70
    //   76: ifeq +20 -> 96
    //   79: aload_1
    //   80: checkcast 70	android/widget/Button
    //   83: astore 9
    //   85: aload 9
    //   87: ifnull +9 -> 96
    //   90: aload 9
    //   92: iconst_0
    //   93: invokevirtual 74	android/widget/Button:setEnabled	(Z)V
    //   96: aload 8
    //   98: checkcast 68	java/lang/String
    //   101: astore 9
    //   103: aload_0
    //   104: getfield 12	com/tencent/mobileqq/adapter/RobotAdapter$2:a	Lcom/tencent/mobileqq/adapter/RobotAdapter;
    //   107: invokestatic 77	com/tencent/mobileqq/adapter/RobotAdapter:a	(Lcom/tencent/mobileqq/adapter/RobotAdapter;)Ljava/lang/String;
    //   110: invokestatic 83	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   113: lstore_2
    //   114: aload 9
    //   116: invokestatic 83	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   119: lstore 6
    //   121: lload 6
    //   123: lstore 4
    //   125: aload_0
    //   126: getfield 12	com/tencent/mobileqq/adapter/RobotAdapter$2:a	Lcom/tencent/mobileqq/adapter/RobotAdapter;
    //   129: invokestatic 86	com/tencent/mobileqq/adapter/RobotAdapter:a	(Lcom/tencent/mobileqq/adapter/RobotAdapter;)Ljava/util/ArrayList;
    //   132: aload 9
    //   134: invokevirtual 92	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   137: pop
    //   138: aload_0
    //   139: getfield 12	com/tencent/mobileqq/adapter/RobotAdapter$2:a	Lcom/tencent/mobileqq/adapter/RobotAdapter;
    //   142: invokestatic 95	com/tencent/mobileqq/adapter/RobotAdapter:a	(Lcom/tencent/mobileqq/adapter/RobotAdapter;)Lcom/tencent/mobileqq/app/QQAppInterface;
    //   145: getstatic 101	com/tencent/mobileqq/app/BusinessHandlerFactory:TROOP_HANDLER	Ljava/lang/String;
    //   148: invokevirtual 107	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   151: checkcast 109	com/tencent/mobileqq/app/TroopHandler
    //   154: lload_2
    //   155: lload 4
    //   157: invokevirtual 113	com/tencent/mobileqq/app/TroopHandler:b	(JJ)V
    //   160: aload_0
    //   161: getfield 12	com/tencent/mobileqq/adapter/RobotAdapter$2:a	Lcom/tencent/mobileqq/adapter/RobotAdapter;
    //   164: invokestatic 28	com/tencent/mobileqq/adapter/RobotAdapter:a	(Lcom/tencent/mobileqq/adapter/RobotAdapter;)Landroid/support/v4/app/FragmentActivity;
    //   167: ifnull -122 -> 45
    //   170: aload_0
    //   171: getfield 12	com/tencent/mobileqq/adapter/RobotAdapter$2:a	Lcom/tencent/mobileqq/adapter/RobotAdapter;
    //   174: invokestatic 28	com/tencent/mobileqq/adapter/RobotAdapter:a	(Lcom/tencent/mobileqq/adapter/RobotAdapter;)Landroid/support/v4/app/FragmentActivity;
    //   177: getfield 119	android/support/v4/app/FragmentActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   180: ldc 121
    //   182: ldc 30
    //   184: ldc 30
    //   186: ldc 30
    //   188: ldc 123
    //   190: iconst_0
    //   191: iconst_0
    //   192: aload 9
    //   194: ldc 30
    //   196: ldc 30
    //   198: ldc 30
    //   200: invokestatic 128	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   203: goto -158 -> 45
    //   206: astore 8
    //   208: lconst_0
    //   209: lstore_2
    //   210: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   213: ifeq +13 -> 226
    //   216: ldc 136
    //   218: iconst_2
    //   219: ldc 138
    //   221: aload 8
    //   223: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   226: goto -101 -> 125
    //   229: astore 8
    //   231: goto -21 -> 210
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	234	0	this	2
    //   0	234	1	paramView	android.view.View
    //   113	97	2	l1	long
    //   1	155	4	l2	long
    //   119	3	6	l3	long
    //   57	40	8	localObject1	Object
    //   206	16	8	localException1	java.lang.Exception
    //   229	1	8	localException2	java.lang.Exception
    //   83	110	9	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   103	114	206	java/lang/Exception
    //   114	121	229	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.RobotAdapter.2
 * JD-Core Version:    0.7.0.1
 */