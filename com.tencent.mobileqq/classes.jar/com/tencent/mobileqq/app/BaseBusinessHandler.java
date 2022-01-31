package com.tencent.mobileqq.app;

import android.os.Bundle;
import android.os.Looper;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.os.MqqHandler;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import yxk;

public abstract class BaseBusinessHandler
{
  private static int jdField_a_of_type_Int;
  private static final String jdField_a_of_type_JavaLangString = BaseBusinessHandler.class.getName();
  private static MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper());
  private static int jdField_b_of_type_Int = -1;
  private static MqqHandler jdField_b_of_type_MqqOsMqqHandler = ThreadManager.getSubThreadHandler();
  private long jdField_a_of_type_Long;
  private Map jdField_a_of_type_JavaUtilMap = new HashMap();
  private Map jdField_b_of_type_JavaUtilMap = new HashMap();
  public Set b;
  
  /* Error */
  public static int a(FromServiceMsg paramFromServiceMsg, Object paramObject, com.tencent.mobileqq.pb.MessageMicro paramMessageMicro)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_0
    //   4: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   7: istore_3
    //   8: invokestatic 72	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   11: ifeq +293 -> 304
    //   14: new 74	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   21: astore 5
    //   23: iload_3
    //   24: sipush 1000
    //   27: if_icmpne +246 -> 273
    //   30: aload_1
    //   31: ifnull +201 -> 232
    //   34: new 77	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   37: dup
    //   38: invokespecial 78	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   41: astore 7
    //   43: aload 7
    //   45: aload_1
    //   46: checkcast 80	[B
    //   49: checkcast 80	[B
    //   52: invokevirtual 84	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   55: checkcast 77	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   58: astore_1
    //   59: aload_1
    //   60: ifnull +241 -> 301
    //   63: aload_1
    //   64: getfield 88	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   67: invokevirtual 93	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   70: istore 4
    //   72: iload 4
    //   74: istore_3
    //   75: iload 4
    //   77: ifeq +47 -> 124
    //   80: aload_1
    //   81: getfield 97	tencent/im/oidb/oidb_sso$OIDBSSOPkg:str_error_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   84: invokevirtual 101	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   87: astore 6
    //   89: aload_0
    //   90: getfield 105	com/tencent/qphone/base/remote/FromServiceMsg:extraData	Landroid/os/Bundle;
    //   93: ldc 106
    //   95: aload 6
    //   97: invokevirtual 112	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   100: iload 4
    //   102: istore_3
    //   103: aload 5
    //   105: ifnull +19 -> 124
    //   108: aload 5
    //   110: ldc 114
    //   112: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: aload 6
    //   117: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: iload 4
    //   123: istore_3
    //   124: aload_1
    //   125: ifnull +42 -> 167
    //   128: aload_1
    //   129: getfield 122	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   132: invokevirtual 127	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   135: ifeq +32 -> 167
    //   138: aload_1
    //   139: getfield 122	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   142: invokevirtual 130	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   145: ifnull +22 -> 167
    //   148: aload_2
    //   149: ifnull +18 -> 167
    //   152: aload_2
    //   153: aload_1
    //   154: getfield 122	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   157: invokevirtual 130	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   160: invokevirtual 136	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   163: invokevirtual 139	com/tencent/mobileqq/pb/MessageMicro:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   166: pop
    //   167: aload 5
    //   169: ifnull +28 -> 197
    //   172: aload 5
    //   174: invokevirtual 142	java/lang/StringBuilder:length	()I
    //   177: ifle +20 -> 197
    //   180: invokestatic 72	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   183: ifeq +14 -> 197
    //   186: ldc 144
    //   188: iconst_4
    //   189: aload 5
    //   191: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: invokestatic 151	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   197: iload_3
    //   198: ireturn
    //   199: astore 6
    //   201: aconst_null
    //   202: astore_1
    //   203: aload 5
    //   205: ifnull +19 -> 224
    //   208: aload 5
    //   210: ldc 153
    //   212: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: aload 6
    //   217: invokevirtual 154	java/lang/Exception:toString	()Ljava/lang/String;
    //   220: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload 6
    //   226: invokevirtual 157	java/lang/Exception:printStackTrace	()V
    //   229: goto -170 -> 59
    //   232: aload 6
    //   234: astore_1
    //   235: aload 5
    //   237: ifnull -178 -> 59
    //   240: aload 5
    //   242: ldc 159
    //   244: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: pop
    //   248: aload 6
    //   250: astore_1
    //   251: goto -192 -> 59
    //   254: astore_0
    //   255: aload 5
    //   257: ifnull -90 -> 167
    //   260: aload 5
    //   262: aload_0
    //   263: invokevirtual 154	java/lang/Exception:toString	()Ljava/lang/String;
    //   266: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: pop
    //   270: goto -103 -> 167
    //   273: aload 5
    //   275: ifnull +15 -> 290
    //   278: aload 5
    //   280: ldc 161
    //   282: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: iload_3
    //   286: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   289: pop
    //   290: goto -123 -> 167
    //   293: astore 6
    //   295: aload 7
    //   297: astore_1
    //   298: goto -95 -> 203
    //   301: goto -177 -> 124
    //   304: aconst_null
    //   305: astore 5
    //   307: goto -284 -> 23
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	310	0	paramFromServiceMsg	FromServiceMsg
    //   0	310	1	paramObject	Object
    //   0	310	2	paramMessageMicro	com.tencent.mobileqq.pb.MessageMicro
    //   7	279	3	i	int
    //   70	52	4	j	int
    //   21	285	5	localStringBuilder	java.lang.StringBuilder
    //   1	115	6	str	String
    //   199	50	6	localException1	Exception
    //   293	1	6	localException2	Exception
    //   41	255	7	localOIDBSSOPkg	oidb_sso.OIDBSSOPkg
    // Exception table:
    //   from	to	target	type
    //   34	43	199	java/lang/Exception
    //   152	167	254	java/lang/Exception
    //   43	59	293	java/lang/Exception
  }
  
  private void a(int paramInt, boolean paramBoolean1, Object paramObject, boolean paramBoolean2, BusinessObserver paramBusinessObserver, MqqHandler paramMqqHandler)
  {
    paramObject = new yxk(this, paramBusinessObserver, paramInt, paramMqqHandler, paramBoolean1, paramObject);
    if (paramBoolean2)
    {
      paramMqqHandler.postAtFrontOfQueue(paramObject);
      return;
    }
    paramMqqHandler.post(paramObject);
  }
  
  protected MessageObserver a(ToServiceMsg paramToServiceMsg)
  {
    if ((paramToServiceMsg == null) || (!paramToServiceMsg.extraData.containsKey(jdField_a_of_type_JavaLangString))) {
      return null;
    }
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      long l = paramToServiceMsg.extraData.getLong(jdField_a_of_type_JavaLangString);
      if (MessageObserver.class.isInstance((BusinessObserver)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(l))))
      {
        paramToServiceMsg = (MessageObserver)this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(l));
        return paramToServiceMsg;
      }
    }
    return null;
  }
  
  public ToServiceMsg a(String paramString)
  {
    return new ToServiceMsg("mobileqq.service", c(), paramString);
  }
  
  public ToServiceMsg a(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    return a(paramString, paramInt1, paramInt2, paramArrayOfByte, 30000L);
  }
  
  public ToServiceMsg a(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte, long paramLong)
  {
    return a(paramString, paramInt1, paramInt2, paramArrayOfByte, paramLong, null, false);
  }
  
  public ToServiceMsg a(String arg1, int paramInt1, int paramInt2, byte[] paramArrayOfByte, long paramLong, BusinessObserver paramBusinessObserver, boolean paramBoolean)
  {
    Object localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(paramInt1);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(paramInt2);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject).str_client_version.set(AppSetting.c());
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    paramArrayOfByte = a(???);
    paramArrayOfByte.putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject).toByteArray());
    paramArrayOfByte.setTimeout(paramLong);
    if ((paramBusinessObserver == null) || (paramBoolean)) {}
    synchronized (this.jdField_b_of_type_JavaUtilMap)
    {
      ???.put(Long.valueOf(this.jdField_a_of_type_Long), paramBusinessObserver);
      paramBusinessObserver = paramArrayOfByte.extraData;
      localObject = jdField_a_of_type_JavaLangString;
      paramLong = this.jdField_a_of_type_Long;
      this.jdField_a_of_type_Long = (1L + paramLong);
      paramBusinessObserver.putLong((String)localObject, paramLong);
      return paramArrayOfByte;
      ??? = this.jdField_a_of_type_JavaUtilMap;
    }
  }
  
  public ToServiceMsg a(String paramString, BusinessObserver paramBusinessObserver)
  {
    return a(paramString, paramBusinessObserver, false);
  }
  
  ToServiceMsg a(String arg1, BusinessObserver paramBusinessObserver, boolean paramBoolean)
  {
    ToServiceMsg localToServiceMsg = a(???);
    if ((paramBusinessObserver == null) || (paramBoolean)) {}
    synchronized (this.jdField_b_of_type_JavaUtilMap)
    {
      ???.put(Long.valueOf(this.jdField_a_of_type_Long), paramBusinessObserver);
      paramBusinessObserver = localToServiceMsg.extraData;
      String str = jdField_a_of_type_JavaLangString;
      long l = this.jdField_a_of_type_Long;
      this.jdField_a_of_type_Long = (1L + l);
      paramBusinessObserver.putLong(str, l);
      return localToServiceMsg;
      ??? = this.jdField_a_of_type_JavaUtilMap;
    }
  }
  
  public abstract Class a();
  
  public final Object a(byte[] paramArrayOfByte, String paramString, Object paramObject)
  {
    UniPacket localUniPacket = new UniPacket(true);
    try
    {
      localUniPacket.setEncodeName("utf-8");
      localUniPacket.decode(paramArrayOfByte);
      return localUniPacket.getByClass(paramString, paramObject);
    }
    catch (Exception paramArrayOfByte) {}
    return null;
  }
  
  public abstract List a(int paramInt);
  
  public void a() {}
  
  public final void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    a(paramInt, paramBoolean, paramObject, false);
  }
  
  public final void a(int paramInt, boolean paramBoolean1, Object paramObject, boolean paramBoolean2)
  {
    List localList = a(0);
    Iterator localIterator;
    Object localObject;
    if ((localList != null) && (localList.size() > 0)) {
      try
      {
        localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          localObject = (BusinessObserver)localIterator.next();
          if ((a() != null) && (a().isAssignableFrom(localObject.getClass())))
          {
            long l = System.currentTimeMillis();
            ((BusinessObserver)localObject).onUpdate(paramInt, paramBoolean1, paramObject);
            l = System.currentTimeMillis() - l;
            if ((l > 100L) && (QLog.isColorLevel()))
            {
              localObject = new Exception("run too long!");
              QLog.d("BaseBusinessHandler.notifyUI", 2, "defaultObserver onUpdate cost:" + l, (Throwable)localObject);
            }
          }
        }
      }
      finally {}
    }
    localList = a(1);
    if ((localList != null) && (localList.size() > 0)) {
      try
      {
        localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          localObject = (BusinessObserver)localIterator.next();
          if ((a() != null) && (a().isAssignableFrom(localObject.getClass()))) {
            a(paramInt, paramBoolean1, paramObject, paramBoolean2, (BusinessObserver)localObject, jdField_a_of_type_MqqOsMqqHandler);
          }
        }
      }
      finally {}
    }
    localList = a(2);
    if ((localList != null) && (localList.size() > 0)) {
      try
      {
        localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          localObject = (BusinessObserver)localIterator.next();
          if ((a() != null) && (a().isAssignableFrom(localObject.getClass()))) {
            a(paramInt, paramBoolean1, paramObject, paramBoolean2, (BusinessObserver)localObject, jdField_b_of_type_MqqOsMqqHandler);
          }
        }
      }
      finally {}
    }
  }
  
  public final void a(ToServiceMsg paramToServiceMsg, int paramInt, boolean paramBoolean, Object paramObject)
  {
    long l;
    MqqHandler localMqqHandler;
    if (paramToServiceMsg.extraData.containsKey(jdField_a_of_type_JavaLangString))
    {
      l = paramToServiceMsg.extraData.getLong(jdField_a_of_type_JavaLangString);
      synchronized (this.jdField_a_of_type_JavaUtilMap)
      {
        paramToServiceMsg = (BusinessObserver)this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(l));
        localMqqHandler = jdField_a_of_type_MqqOsMqqHandler;
        if (paramToServiceMsg != null) {}
      }
    }
    for (;;)
    {
      synchronized (this.jdField_b_of_type_JavaUtilMap)
      {
        paramToServiceMsg = (BusinessObserver)this.jdField_b_of_type_JavaUtilMap.remove(Long.valueOf(l));
        localMqqHandler = jdField_b_of_type_MqqOsMqqHandler;
        if (paramToServiceMsg != null)
        {
          a(paramInt, paramBoolean, paramObject, false, paramToServiceMsg, localMqqHandler);
          return;
          paramToServiceMsg = finally;
          throw paramToServiceMsg;
        }
      }
      a(paramInt, paramBoolean, paramObject);
      return;
    }
  }
  
  public abstract void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject);
  
  public boolean a(String paramString)
  {
    return false;
  }
  
  public abstract String c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.BaseBusinessHandler
 * JD-Core Version:    0.7.0.1
 */