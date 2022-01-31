package com.tencent.av;

import android.text.TextUtils;
import com.tencent.av.app.SessionInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class SessionMgr
{
  static volatile SessionMgr jdField_a_of_type_ComTencentAvSessionMgr;
  public static String a;
  SessionInfo jdField_a_of_type_ComTencentAvAppSessionInfo = new SessionInfo();
  Map jdField_a_of_type_JavaUtilMap = new HashMap();
  
  static
  {
    jdField_a_of_type_JavaLangString = "AvSessionMgr";
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    case 1011: 
    default: 
      return 3;
    case 3000: 
      return 2;
    }
    return 1;
  }
  
  public static SessionMgr a()
  {
    if (jdField_a_of_type_ComTencentAvSessionMgr == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentAvSessionMgr == null) {
        jdField_a_of_type_ComTencentAvSessionMgr = new SessionMgr();
      }
      return jdField_a_of_type_ComTencentAvSessionMgr;
    }
    finally {}
  }
  
  public static String a(int paramInt, String paramString, int... paramVarArgs)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if (paramString.startsWith("+")) {
        str = paramString.substring(1);
      }
    }
    str = String.valueOf(paramInt) + "-" + str;
    paramString = str;
    if (paramInt == 1)
    {
      paramString = str;
      if (paramVarArgs != null)
      {
        paramString = str;
        if (paramVarArgs.length == 1) {
          paramString = str + "-" + paramVarArgs[0];
        }
      }
    }
    return paramString;
  }
  
  private SessionInfo b()
  {
    if (this.jdField_a_of_type_JavaUtilMap.size() == 1)
    {
      Object localObject = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
      if (((Iterator)localObject).hasNext())
      {
        localObject = (String)((Iterator)localObject).next();
        return (SessionInfo)this.jdField_a_of_type_JavaUtilMap.get(localObject);
      }
    }
    return null;
  }
  
  public int a()
  {
    int j = 0;
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        SessionInfo localSessionInfo = (SessionInfo)this.jdField_a_of_type_JavaUtilMap.get(str);
        int i = j;
        if (!localSessionInfo.a())
        {
          j += 1;
          i = j;
          if (QLog.isColorLevel())
          {
            QLog.w(jdField_a_of_type_JavaLangString, 1, "getAliveSessionCount, count[" + j + "], key[" + str + "], session[" + localSessionInfo + "]");
            i = j;
          }
        }
        j = i;
      }
      return j;
    }
    finally {}
  }
  
  public SessionInfo a()
  {
    try
    {
      SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvAppSessionInfo;
      return localSessionInfo;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public SessionInfo a(String paramString)
  {
    try
    {
      if ((!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) && (QLog.isColorLevel())) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "getSession not exist sessionId : " + paramString);
      }
      paramString = (SessionInfo)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      return paramString;
    }
    finally {}
  }
  
  public SessionInfo a(String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      SessionInfo localSessionInfo;
      try
      {
        if (TextUtils.isEmpty(paramString))
        {
          if (QLog.isColorLevel()) {
            QLog.e(jdField_a_of_type_JavaLangString, 2, "createSession with null sessionId ");
          }
          localSessionInfo = null;
          return localSessionInfo;
        }
        if (this.jdField_a_of_type_JavaUtilMap.get(paramString) != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "createSession already exist sessionId : " + paramString);
          }
          localSessionInfo = (SessionInfo)this.jdField_a_of_type_JavaUtilMap.get(paramString);
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "createSession sessionId : " + paramString);
        }
        if (this.jdField_a_of_type_JavaUtilMap.isEmpty())
        {
          localSessionInfo = this.jdField_a_of_type_ComTencentAvAppSessionInfo;
          this.jdField_a_of_type_JavaUtilMap.put(paramString, localSessionInfo);
          localSessionInfo.b = paramString;
          if ((this.jdField_a_of_type_JavaUtilMap.size() != 1) && (!paramBoolean)) {
            break label257;
          }
          a(paramString, 2);
          continue;
        }
        if (b() == null) {
          break label229;
        }
      }
      finally {}
      if (b().c == 3)
      {
        a(b().b, paramString);
        localSessionInfo = a(paramString);
      }
      else
      {
        label229:
        localSessionInfo = new SessionInfo();
        this.jdField_a_of_type_JavaUtilMap.put(paramString, localSessionInfo);
        localSessionInfo.b = paramString;
        continue;
        label257:
        a(paramString, 1);
      }
    }
  }
  
  public void a()
  {
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
      while (localIterator.hasNext()) {
        ((SessionInfo)localIterator.next()).c();
      }
    }
    finally {}
  }
  
  /* Error */
  public void a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +38 -> 43
    //   8: getstatic 15	com/tencent/av/SessionMgr:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   11: iconst_2
    //   12: new 55	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   19: ldc 179
    //   21: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_1
    //   25: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc 181
    //   30: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: iload_2
    //   34: invokevirtual 72	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   37: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokestatic 144	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   43: aload_0
    //   44: getfield 29	com/tencent/av/SessionMgr:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   47: aload_1
    //   48: invokeinterface 131 2 0
    //   53: ifne +47 -> 100
    //   56: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   59: ifeq +38 -> 97
    //   62: getstatic 15	com/tencent/av/SessionMgr:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   65: iconst_2
    //   66: new 55	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   73: ldc 183
    //   75: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: aload_1
    //   79: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: ldc 185
    //   84: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: iload_2
    //   88: invokevirtual 72	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   91: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: invokestatic 144	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   97: aload_0
    //   98: monitorexit
    //   99: return
    //   100: aload_0
    //   101: getfield 29	com/tencent/av/SessionMgr:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   104: aload_1
    //   105: invokeinterface 104 2 0
    //   110: checkcast 21	com/tencent/av/app/SessionInfo
    //   113: astore_1
    //   114: aload_1
    //   115: ifnull -18 -> 97
    //   118: aload_1
    //   119: getfield 163	com/tencent/av/app/SessionInfo:c	I
    //   122: iload_2
    //   123: if_icmpeq -26 -> 97
    //   126: iload_2
    //   127: iconst_2
    //   128: if_icmpne +8 -> 136
    //   131: aload_0
    //   132: aload_1
    //   133: putfield 24	com/tencent/av/SessionMgr:jdField_a_of_type_ComTencentAvAppSessionInfo	Lcom/tencent/av/app/SessionInfo;
    //   136: aload_1
    //   137: iload_2
    //   138: putfield 163	com/tencent/av/app/SessionInfo:c	I
    //   141: goto -44 -> 97
    //   144: astore_1
    //   145: aload_0
    //   146: monitorexit
    //   147: aload_1
    //   148: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	this	SessionMgr
    //   0	149	1	paramString	String
    //   0	149	2	paramInt	int
    // Exception table:
    //   from	to	target	type
    //   2	43	144	finally
    //   43	97	144	finally
    //   100	114	144	finally
    //   118	126	144	finally
    //   131	136	144	finally
    //   136	141	144	finally
  }
  
  /* Error */
  public boolean a()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: invokevirtual 187	com/tencent/av/SessionMgr:a	()I
    //   8: istore_1
    //   9: iload_1
    //   10: iconst_1
    //   11: if_icmple +7 -> 18
    //   14: aload_0
    //   15: monitorexit
    //   16: iload_2
    //   17: ireturn
    //   18: iconst_0
    //   19: istore_2
    //   20: goto -6 -> 14
    //   23: astore_3
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_3
    //   27: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	28	0	this	SessionMgr
    //   8	4	1	i	int
    //   1	19	2	bool	boolean
    //   23	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	9	23	finally
  }
  
  public boolean a(String paramString)
  {
    try
    {
      boolean bool = this.jdField_a_of_type_JavaUtilMap.containsKey(paramString);
      return bool;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +38 -> 43
    //   8: getstatic 15	com/tencent/av/SessionMgr:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   11: iconst_2
    //   12: new 55	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   19: ldc 189
    //   21: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_1
    //   25: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc 191
    //   30: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_2
    //   34: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokestatic 144	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   43: aload_0
    //   44: getfield 29	com/tencent/av/SessionMgr:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   47: aload_1
    //   48: invokeinterface 131 2 0
    //   53: ifne +24 -> 77
    //   56: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   59: ifeq +12 -> 71
    //   62: getstatic 15	com/tencent/av/SessionMgr:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   65: iconst_2
    //   66: ldc 193
    //   68: invokestatic 144	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   71: iconst_0
    //   72: istore_3
    //   73: aload_0
    //   74: monitorexit
    //   75: iload_3
    //   76: ireturn
    //   77: aload_0
    //   78: getfield 29	com/tencent/av/SessionMgr:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   81: aload_1
    //   82: invokeinterface 104 2 0
    //   87: checkcast 21	com/tencent/av/app/SessionInfo
    //   90: astore 4
    //   92: aload 4
    //   94: aload_2
    //   95: putfield 154	com/tencent/av/app/SessionInfo:b	Ljava/lang/String;
    //   98: aload_0
    //   99: getfield 29	com/tencent/av/SessionMgr:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   102: aload_1
    //   103: invokeinterface 196 2 0
    //   108: pop
    //   109: aload_0
    //   110: getfield 29	com/tencent/av/SessionMgr:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   113: aload_2
    //   114: aload 4
    //   116: invokeinterface 152 3 0
    //   121: pop
    //   122: iconst_1
    //   123: istore_3
    //   124: goto -51 -> 73
    //   127: astore_1
    //   128: aload_0
    //   129: monitorexit
    //   130: aload_1
    //   131: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	this	SessionMgr
    //   0	132	1	paramString1	String
    //   0	132	2	paramString2	String
    //   72	52	3	bool	boolean
    //   90	25	4	localSessionInfo	SessionInfo
    // Exception table:
    //   from	to	target	type
    //   2	43	127	finally
    //   43	71	127	finally
    //   77	122	127	finally
  }
  
  /* Error */
  public boolean b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 29	com/tencent/av/SessionMgr:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   6: invokeinterface 84 1 0
    //   11: invokeinterface 90 1 0
    //   16: astore_2
    //   17: aload_2
    //   18: invokeinterface 96 1 0
    //   23: ifeq +40 -> 63
    //   26: aload_2
    //   27: invokeinterface 100 1 0
    //   32: checkcast 45	java/lang/String
    //   35: astore_3
    //   36: aload_0
    //   37: getfield 29	com/tencent/av/SessionMgr:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   40: aload_3
    //   41: invokeinterface 104 2 0
    //   46: checkcast 21	com/tencent/av/app/SessionInfo
    //   49: invokevirtual 106	com/tencent/av/app/SessionInfo:a	()Z
    //   52: istore_1
    //   53: iload_1
    //   54: ifne -37 -> 17
    //   57: iconst_0
    //   58: istore_1
    //   59: aload_0
    //   60: monitorexit
    //   61: iload_1
    //   62: ireturn
    //   63: iconst_1
    //   64: istore_1
    //   65: goto -6 -> 59
    //   68: astore_2
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_2
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	SessionMgr
    //   52	13	1	bool	boolean
    //   16	11	2	localIterator	Iterator
    //   68	4	2	localObject	Object
    //   35	6	3	str	String
    // Exception table:
    //   from	to	target	type
    //   2	17	68	finally
    //   17	53	68	finally
  }
  
  /* Error */
  public boolean b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 29	com/tencent/av/SessionMgr:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface 131 2 0
    //   12: ifeq +15 -> 27
    //   15: aload_0
    //   16: aload_1
    //   17: iconst_2
    //   18: invokevirtual 157	com/tencent/av/SessionMgr:a	(Ljava/lang/String;I)V
    //   21: iconst_1
    //   22: istore_2
    //   23: aload_0
    //   24: monitorexit
    //   25: iload_2
    //   26: ireturn
    //   27: iconst_0
    //   28: istore_2
    //   29: goto -6 -> 23
    //   32: astore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	SessionMgr
    //   0	37	1	paramString	String
    //   22	7	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	21	32	finally
  }
  
  public boolean c(String paramString)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "removeSession sessionId : " + paramString);
        }
        if (this.jdField_a_of_type_JavaUtilMap.size() == 1)
        {
          if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))
          {
            if (QLog.isColorLevel()) {
              QLog.e(jdField_a_of_type_JavaLangString, 2, "removeSession not exist sessionId : " + paramString);
            }
            bool = false;
            return bool;
          }
          ((SessionInfo)this.jdField_a_of_type_JavaUtilMap.get(paramString)).b();
          ((SessionInfo)this.jdField_a_of_type_JavaUtilMap.get(paramString)).f();
          ((SessionInfo)this.jdField_a_of_type_JavaUtilMap.get(paramString)).c = 3;
          a(paramString, "none");
          bool = false;
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "removeSession session size : " + this.jdField_a_of_type_JavaUtilMap.size());
        }
        if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))
        {
          this.jdField_a_of_type_JavaUtilMap.remove(paramString);
          if (this.jdField_a_of_type_JavaUtilMap.size() != 1) {
            break label288;
          }
          paramString = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
          if (!paramString.hasNext()) {
            break label288;
          }
          b((String)paramString.next());
          continue;
        }
        bool = false;
      }
      finally {}
      continue;
      label288:
      boolean bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.SessionMgr
 * JD-Core Version:    0.7.0.1
 */