import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.DrawerPushItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class amtl
  implements amtj
{
  private int jdField_a_of_type_Int;
  private DrawerPushItem jdField_a_of_type_ComTencentMobileqqDrawerPushItem;
  public boolean a;
  public boolean b;
  private boolean c;
  private boolean d;
  private boolean e;
  
  private amtl(amsx paramamsx)
  {
    b();
    SharedPreferences localSharedPreferences = paramamsx.a.getApp().getSharedPreferences("apollo_sp" + paramamsx.a.c(), 0);
    if (localSharedPreferences.getInt("key_panel_meet_3d_action", 0) == 1)
    {
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      if (localSharedPreferences.getInt("key_panel_shown_guide_for_action", 0) != 1) {
        break label134;
      }
      bool1 = true;
      label90:
      this.c = bool1;
      if (localSharedPreferences.getInt("key_panel_shown_guide_for_json", 0) != 1) {
        break label139;
      }
    }
    label134:
    label139:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.d = bool1;
      paramamsx.a(this);
      anlo.a(paramamsx.a);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label90;
    }
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem = new DrawerPushItem();
    this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.is_reddot = 0;
    this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.msg_type = 10;
    this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.msg_id = "aio_panel_bubble_guide3d_action";
    this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.priority = 1000;
    this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.start_ts = ((int)NetConnInfoCenter.getServerTime() - 1000);
    this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.end_ts = (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.start_ts + 172800000);
    this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.send_time = this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.start_ts;
    this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.content = anzj.a(2131699378);
    this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.show_counts = 1;
    this.jdField_a_of_type_Amsx.c(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem);
    a(true);
  }
  
  /* Error */
  private void a(java.util.Map<java.lang.String, java.lang.String> paramMap, int paramInt, java.lang.String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 152	amtk:jdField_a_of_type_Boolean	Z
    //   5: ifne +30 -> 35
    //   8: ldc 154
    //   10: iconst_1
    //   11: iconst_2
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: ldc 156
    //   19: aastore
    //   20: dup
    //   21: iconst_1
    //   22: getstatic 152	amtk:jdField_a_of_type_Boolean	Z
    //   25: invokestatic 162	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   28: aastore
    //   29: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   32: aload_0
    //   33: monitorexit
    //   34: return
    //   35: aload_0
    //   36: getfield 19	amtl:jdField_a_of_type_Amsx	Lamsx;
    //   39: getfield 29	amsx:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   42: invokevirtual 35	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   45: new 37	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   52: ldc 40
    //   54: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: aload_0
    //   58: getfield 19	amtl:jdField_a_of_type_Amsx	Lamsx;
    //   61: getfield 29	amsx:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   64: invokevirtual 47	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   67: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: iconst_0
    //   74: invokevirtual 56	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   77: astore 6
    //   79: aload 6
    //   81: ldc 169
    //   83: iconst_0
    //   84: invokeinterface 64 3 0
    //   89: istore 4
    //   91: ldc 154
    //   93: iconst_1
    //   94: iconst_4
    //   95: anewarray 4	java/lang/Object
    //   98: dup
    //   99: iconst_0
    //   100: ldc 171
    //   102: aastore
    //   103: dup
    //   104: iconst_1
    //   105: iload 4
    //   107: invokestatic 176	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   110: aastore
    //   111: dup
    //   112: iconst_2
    //   113: ldc 178
    //   115: aastore
    //   116: dup
    //   117: iconst_3
    //   118: iload_2
    //   119: invokestatic 176	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   122: aastore
    //   123: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   126: iload_2
    //   127: iload 4
    //   129: if_icmpeq -97 -> 32
    //   132: new 88	com/tencent/mobileqq/DrawerPushItem
    //   135: dup
    //   136: invokespecial 89	com/tencent/mobileqq/DrawerPushItem:<init>	()V
    //   139: astore 7
    //   141: aload 7
    //   143: iconst_0
    //   144: putfield 94	com/tencent/mobileqq/DrawerPushItem:is_reddot	I
    //   147: aload 7
    //   149: ldc 180
    //   151: putfield 103	com/tencent/mobileqq/DrawerPushItem:msg_id	Ljava/lang/String;
    //   154: aload 7
    //   156: bipush 10
    //   158: putfield 97	com/tencent/mobileqq/DrawerPushItem:msg_type	I
    //   161: aload 7
    //   163: sipush 900
    //   166: putfield 106	com/tencent/mobileqq/DrawerPushItem:priority	I
    //   169: aload_1
    //   170: ldc 182
    //   172: invokeinterface 188 2 0
    //   177: checkcast 190	java/lang/String
    //   180: invokestatic 196	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   183: l2i
    //   184: sipush 1000
    //   187: idiv
    //   188: istore 4
    //   190: aload 7
    //   192: iload 4
    //   194: putfield 115	com/tencent/mobileqq/DrawerPushItem:start_ts	I
    //   197: invokestatic 112	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTime	()J
    //   200: l2i
    //   201: istore 5
    //   203: aload 7
    //   205: aload_1
    //   206: ldc 198
    //   208: invokeinterface 188 2 0
    //   213: checkcast 190	java/lang/String
    //   216: invokestatic 196	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   219: l2i
    //   220: sipush 1000
    //   223: idiv
    //   224: iload 4
    //   226: isub
    //   227: iload 5
    //   229: iadd
    //   230: putfield 119	com/tencent/mobileqq/DrawerPushItem:end_ts	I
    //   233: aload 7
    //   235: iload 4
    //   237: putfield 122	com/tencent/mobileqq/DrawerPushItem:send_time	I
    //   240: aload 7
    //   242: aload_1
    //   243: ldc 200
    //   245: invokeinterface 188 2 0
    //   250: checkcast 190	java/lang/String
    //   253: putfield 131	com/tencent/mobileqq/DrawerPushItem:content	Ljava/lang/String;
    //   256: aload 7
    //   258: iload_2
    //   259: putfield 203	com/tencent/mobileqq/DrawerPushItem:tianshuAdId	I
    //   262: aload 7
    //   264: aload_3
    //   265: putfield 206	com/tencent/mobileqq/DrawerPushItem:tianshuTraceInfo	Ljava/lang/String;
    //   268: aload 7
    //   270: aload_1
    //   271: ldc 208
    //   273: invokeinterface 188 2 0
    //   278: checkcast 190	java/lang/String
    //   281: invokestatic 212	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   284: putfield 134	com/tencent/mobileqq/DrawerPushItem:show_counts	I
    //   287: aload 7
    //   289: getfield 134	com/tencent/mobileqq/DrawerPushItem:show_counts	I
    //   292: ifne +9 -> 301
    //   295: aload 7
    //   297: iconst_1
    //   298: putfield 134	com/tencent/mobileqq/DrawerPushItem:show_counts	I
    //   301: aload_1
    //   302: ldc 214
    //   304: invokeinterface 188 2 0
    //   309: checkcast 190	java/lang/String
    //   312: invokestatic 212	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   315: istore 4
    //   317: aload_0
    //   318: getfield 19	amtl:jdField_a_of_type_Amsx	Lamsx;
    //   321: aload 7
    //   323: invokevirtual 137	amsx:c	(Lcom/tencent/mobileqq/DrawerPushItem;)V
    //   326: aload 6
    //   328: invokeinterface 218 1 0
    //   333: ldc 169
    //   335: iload_2
    //   336: invokeinterface 224 3 0
    //   341: invokeinterface 228 1 0
    //   346: pop
    //   347: aload_0
    //   348: iconst_1
    //   349: invokevirtual 230	amtl:b	(Z)V
    //   352: aload_0
    //   353: getfield 232	amtl:e	Z
    //   356: ifeq +32 -> 388
    //   359: aload_0
    //   360: getfield 19	amtl:jdField_a_of_type_Amsx	Lamsx;
    //   363: getfield 29	amsx:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   366: sipush 211
    //   369: invokevirtual 236	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   372: checkcast 238	amst
    //   375: getfield 241	amst:a	Lanlm;
    //   378: aload_0
    //   379: getfield 19	amtl:jdField_a_of_type_Amsx	Lamsx;
    //   382: getfield 29	amsx:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   385: invokevirtual 244	anlm:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   388: ldc 154
    //   390: iconst_1
    //   391: iconst_4
    //   392: anewarray 4	java/lang/Object
    //   395: dup
    //   396: iconst_0
    //   397: ldc 246
    //   399: aastore
    //   400: dup
    //   401: iconst_1
    //   402: aload 7
    //   404: invokevirtual 247	com/tencent/mobileqq/DrawerPushItem:toString	()Ljava/lang/String;
    //   407: aastore
    //   408: dup
    //   409: iconst_2
    //   410: ldc 249
    //   412: aastore
    //   413: dup
    //   414: iconst_3
    //   415: iload 4
    //   417: invokestatic 176	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   420: aastore
    //   421: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   424: goto -392 -> 32
    //   427: astore_1
    //   428: ldc 154
    //   430: iconst_1
    //   431: ldc 251
    //   433: aload_1
    //   434: invokestatic 254	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   437: goto -405 -> 32
    //   440: astore_1
    //   441: aload_0
    //   442: monitorexit
    //   443: aload_1
    //   444: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	445	0	this	amtl
    //   0	445	1	paramMap	java.util.Map<java.lang.String, java.lang.String>
    //   0	445	2	paramInt	int
    //   0	445	3	paramString	java.lang.String
    //   89	327	4	i	int
    //   201	29	5	j	int
    //   77	250	6	localSharedPreferences	SharedPreferences
    //   139	264	7	localDrawerPushItem	DrawerPushItem
    // Exception table:
    //   from	to	target	type
    //   35	126	427	java/lang/Exception
    //   132	301	427	java/lang/Exception
    //   301	388	427	java/lang/Exception
    //   388	424	427	java/lang/Exception
    //   2	32	440	finally
    //   35	126	440	finally
    //   132	301	440	finally
    //   301	388	440	finally
    //   388	424	440	finally
    //   428	437	440	finally
  }
  
  private void b()
  {
    this.b = amsx.a(this.jdField_a_of_type_Amsx.a);
    this.jdField_a_of_type_Int = amsx.a(this.jdField_a_of_type_Amsx.a);
  }
  
  /* Error */
  private void c(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_1
    //   4: putfield 232	amtl:e	Z
    //   7: iload_1
    //   8: ifeq +10 -> 18
    //   11: aload_0
    //   12: invokespecial 24	amtl:b	()V
    //   15: aload_0
    //   16: monitorexit
    //   17: return
    //   18: aload_0
    //   19: getfield 91	amtl:jdField_a_of_type_ComTencentMobileqqDrawerPushItem	Lcom/tencent/mobileqq/DrawerPushItem;
    //   22: ifnull -7 -> 15
    //   25: aload_0
    //   26: getfield 19	amtl:jdField_a_of_type_Amsx	Lamsx;
    //   29: aload_0
    //   30: getfield 91	amtl:jdField_a_of_type_ComTencentMobileqqDrawerPushItem	Lcom/tencent/mobileqq/DrawerPushItem;
    //   33: invokevirtual 268	amsx:a	(Lcom/tencent/mobileqq/DrawerPushItem;)V
    //   36: aload_0
    //   37: aconst_null
    //   38: putfield 91	amtl:jdField_a_of_type_ComTencentMobileqqDrawerPushItem	Lcom/tencent/mobileqq/DrawerPushItem;
    //   41: goto -26 -> 15
    //   44: astore_2
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_2
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	amtl
    //   0	49	1	paramBoolean	boolean
    //   44	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	44	finally
    //   11	15	44	finally
    //   18	41	44	finally
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    try
    {
      b();
      return;
    }
    finally {}
  }
  
  public void a(boolean paramBoolean)
  {
    int i = 0;
    try
    {
      this.c = paramBoolean;
      SharedPreferences.Editor localEditor = this.jdField_a_of_type_Amsx.a.getApp().getSharedPreferences("apollo_sp" + this.jdField_a_of_type_Amsx.a.c(), 0).edit();
      if (paramBoolean) {
        i = 1;
      }
      localEditor.putInt("key_panel_shown_guide_for_action", i).commit();
      return;
    }
    finally {}
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = this.c;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean a(MessageForApollo paramMessageForApollo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (amtk.jdField_a_of_type_Boolean)
      {
        bool1 = bool2;
        if (!this.jdField_a_of_type_Boolean)
        {
          bool1 = bool2;
          if (this.b)
          {
            bool1 = bool2;
            if (this.jdField_a_of_type_Int == 1)
            {
              bool1 = bool2;
              if (!anlo.jdField_a_of_type_Boolean)
              {
                bool1 = bool2;
                if (!paramMessageForApollo.isSend())
                {
                  bool1 = bool2;
                  if (paramMessageForApollo.is3dAction())
                  {
                    this.jdField_a_of_type_Boolean = true;
                    this.jdField_a_of_type_Amsx.a.getApp().getSharedPreferences("apollo_sp" + this.jdField_a_of_type_Amsx.a.c(), 0).edit().putInt("key_panel_meet_3d_action", 1).commit();
                    a();
                    ((amst)this.jdField_a_of_type_Amsx.a.getManager(211)).a.a(this.jdField_a_of_type_Amsx.a);
                    QLog.d("ApolloManager", 2, "accept bubble for first 3D action");
                    bool1 = true;
                  }
                }
              }
            }
          }
        }
      }
      return bool1;
    }
    finally {}
  }
  
  public void b(boolean paramBoolean)
  {
    int i = 0;
    try
    {
      this.d = paramBoolean;
      SharedPreferences.Editor localEditor = this.jdField_a_of_type_Amsx.a.getApp().getSharedPreferences("apollo_sp" + this.jdField_a_of_type_Amsx.a.c(), 0).edit();
      if (paramBoolean) {
        i = 1;
      }
      localEditor.putInt("key_panel_shown_guide_for_json", i).commit();
      return;
    }
    finally {}
  }
  
  /* Error */
  public boolean b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 74	amtl:d	Z
    //   6: ifeq +17 -> 23
    //   9: getstatic 271	anlo:jdField_a_of_type_Boolean	Z
    //   12: istore_1
    //   13: iload_1
    //   14: ifne +9 -> 23
    //   17: iconst_1
    //   18: istore_1
    //   19: aload_0
    //   20: monitorexit
    //   21: iload_1
    //   22: ireturn
    //   23: iconst_0
    //   24: istore_1
    //   25: goto -6 -> 19
    //   28: astore_2
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_2
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	amtl
    //   12	13	1	bool	boolean
    //   28	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	13	28	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amtl
 * JD-Core Version:    0.7.0.1
 */