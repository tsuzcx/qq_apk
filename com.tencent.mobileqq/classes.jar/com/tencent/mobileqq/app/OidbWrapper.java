package com.tencent.mobileqq.app;

import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBFixed64Field;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBSFixed32Field;
import com.tencent.mobileqq.pb.PBSFixed64Field;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBSInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public abstract class OidbWrapper
{
  private static final String TAG = "OidbWrapper";
  
  private static boolean dealMessageMicro(Class<?> paramClass, MessageMicro paramMessageMicro, boolean paramBoolean, StringBuilder paramStringBuilder, String paramString, Field paramField, int paramInt, AtomicBoolean paramAtomicBoolean)
  {
    if (paramAtomicBoolean.get()) {
      return false;
    }
    if (MessageMicro.class.isAssignableFrom(paramClass))
    {
      paramAtomicBoolean.set(true);
      paramClass = (MessageMicro)paramField.get(paramMessageMicro);
      if (paramClass == null) {
        return true;
      }
      boolean bool = paramClass.has();
      paramClass = paramClass.get();
      if ((paramBoolean) && (!bool)) {
        return true;
      }
      if (bool) {
        break label101;
      }
      paramClass = String.format("%s: NA", new Object[] { paramField.getName() });
      paramStringBuilder.append(paramString);
      paramStringBuilder.append(paramClass);
    }
    for (;;)
    {
      return false;
      label101:
      paramStringBuilder.append(paramString).append(paramField.getName()).append(": {\n");
      paramStringBuilder.append(proto2String(paramClass, paramInt + 1, paramBoolean));
      paramStringBuilder.append(paramString).append("}");
    }
  }
  
  private static boolean dealPBBoolField(Class<?> paramClass, MessageMicro paramMessageMicro, boolean paramBoolean, StringBuilder paramStringBuilder, String paramString, Field paramField, AtomicBoolean paramAtomicBoolean)
  {
    if (paramAtomicBoolean.get()) {
      return false;
    }
    if (PBBoolField.class.isAssignableFrom(paramClass))
    {
      paramAtomicBoolean.set(true);
      paramClass = (PBBoolField)paramField.get(paramMessageMicro);
      if (paramClass == null) {
        return true;
      }
      boolean bool1 = paramClass.has();
      boolean bool2 = paramClass.get();
      paramMessageMicro = paramField.getName();
      if (bool1) {}
      for (paramClass = Boolean.valueOf(bool2);; paramClass = "NA")
      {
        paramClass = String.format("%s: %s", new Object[] { paramMessageMicro, paramClass });
        if ((!paramBoolean) || (bool1)) {
          break;
        }
        return true;
      }
      paramStringBuilder.append(paramString);
      paramStringBuilder.append(paramClass);
    }
    return false;
  }
  
  private static boolean dealPBBytesField(Class<?> paramClass, MessageMicro paramMessageMicro, boolean paramBoolean, StringBuilder paramStringBuilder, String paramString, Field paramField, AtomicBoolean paramAtomicBoolean)
  {
    if (paramAtomicBoolean.get()) {
      return false;
    }
    if (PBBytesField.class.isAssignableFrom(paramClass))
    {
      paramAtomicBoolean.set(true);
      paramClass = (PBBytesField)paramField.get(paramMessageMicro);
      if (paramClass == null) {
        return true;
      }
      boolean bool = paramClass.has();
      paramMessageMicro = paramField.getName();
      if (bool) {}
      for (paramClass = "<…bytes…>";; paramClass = "NA")
      {
        paramClass = String.format("%s: %s", new Object[] { paramMessageMicro, paramClass });
        if ((!paramBoolean) || (bool)) {
          break;
        }
        return true;
      }
      paramStringBuilder.append(paramString);
      paramStringBuilder.append(paramClass);
    }
    return false;
  }
  
  private static boolean dealPBDoubleField(Class<?> paramClass, MessageMicro paramMessageMicro, boolean paramBoolean, StringBuilder paramStringBuilder, String paramString, Field paramField, AtomicBoolean paramAtomicBoolean)
  {
    if (paramAtomicBoolean.get()) {
      return false;
    }
    if (PBDoubleField.class.isAssignableFrom(paramClass))
    {
      paramAtomicBoolean.set(true);
      paramClass = (PBDoubleField)paramField.get(paramMessageMicro);
      if (paramClass == null) {
        return true;
      }
      boolean bool = paramClass.has();
      double d = paramClass.get();
      paramMessageMicro = paramField.getName();
      if (bool) {}
      for (paramClass = Double.valueOf(d);; paramClass = "NA")
      {
        paramClass = String.format("%s: %s", new Object[] { paramMessageMicro, paramClass });
        if ((!paramBoolean) || (bool)) {
          break;
        }
        return true;
      }
      paramStringBuilder.append(paramString);
      paramStringBuilder.append(paramClass);
    }
    return false;
  }
  
  private static boolean dealPBEnumField(Class<?> paramClass, MessageMicro paramMessageMicro, boolean paramBoolean, StringBuilder paramStringBuilder, String paramString, Field paramField, AtomicBoolean paramAtomicBoolean)
  {
    if (paramAtomicBoolean.get()) {
      return false;
    }
    if (PBEnumField.class.isAssignableFrom(paramClass))
    {
      paramAtomicBoolean.set(true);
      paramClass = (PBEnumField)paramField.get(paramMessageMicro);
      if (paramClass == null) {
        return true;
      }
      boolean bool = paramClass.has();
      int i = paramClass.get();
      paramMessageMicro = paramField.getName();
      if (bool) {}
      for (paramClass = Integer.valueOf(i);; paramClass = "NA")
      {
        paramClass = String.format("%s: %s", new Object[] { paramMessageMicro, paramClass });
        if ((!paramBoolean) || (bool)) {
          break;
        }
        return true;
      }
      paramStringBuilder.append(paramString);
      paramStringBuilder.append(paramClass);
    }
    return false;
  }
  
  private static boolean dealPBFixed32Field(Class<?> paramClass, MessageMicro paramMessageMicro, boolean paramBoolean, StringBuilder paramStringBuilder, String paramString, Field paramField, AtomicBoolean paramAtomicBoolean)
  {
    if (paramAtomicBoolean.get()) {
      return false;
    }
    if (PBFixed32Field.class.isAssignableFrom(paramClass))
    {
      paramAtomicBoolean.set(true);
      paramClass = (PBFixed32Field)paramField.get(paramMessageMicro);
      boolean bool = paramClass.has();
      int i = paramClass.get();
      paramMessageMicro = paramField.getName();
      if (bool) {}
      for (paramClass = Integer.valueOf(i);; paramClass = "NA")
      {
        paramClass = String.format("%s: %s", new Object[] { paramMessageMicro, paramClass });
        if ((!paramBoolean) || (bool)) {
          break;
        }
        return true;
      }
      paramStringBuilder.append(paramString);
      paramStringBuilder.append(paramClass);
    }
    return false;
  }
  
  private static boolean dealPBFixed64Field(Class<?> paramClass, MessageMicro paramMessageMicro, boolean paramBoolean, StringBuilder paramStringBuilder, String paramString, Field paramField, AtomicBoolean paramAtomicBoolean)
  {
    if (paramAtomicBoolean.get()) {
      return false;
    }
    if (PBFixed64Field.class.isAssignableFrom(paramClass))
    {
      paramAtomicBoolean.set(true);
      paramClass = (PBFixed64Field)paramField.get(paramMessageMicro);
      if (paramClass == null) {
        return true;
      }
      boolean bool = paramClass.has();
      long l = paramClass.get();
      paramMessageMicro = paramField.getName();
      if (bool) {}
      for (paramClass = Long.valueOf(l);; paramClass = "NA")
      {
        paramClass = String.format("%s: %s", new Object[] { paramMessageMicro, paramClass });
        if ((!paramBoolean) || (bool)) {
          break;
        }
        return true;
      }
      paramStringBuilder.append(paramString);
      paramStringBuilder.append(paramClass);
    }
    return false;
  }
  
  private static boolean dealPBFloatField(Class<?> paramClass, MessageMicro paramMessageMicro, boolean paramBoolean, StringBuilder paramStringBuilder, String paramString, Field paramField, AtomicBoolean paramAtomicBoolean)
  {
    if (paramAtomicBoolean.get()) {
      return false;
    }
    if (PBFloatField.class.isAssignableFrom(paramClass))
    {
      paramAtomicBoolean.set(true);
      paramClass = (PBFloatField)paramField.get(paramMessageMicro);
      if (paramClass == null) {
        return true;
      }
      boolean bool = paramClass.has();
      float f = paramClass.get();
      paramMessageMicro = paramField.getName();
      if (bool) {}
      for (paramClass = Float.valueOf(f);; paramClass = "NA")
      {
        paramClass = String.format("%s: %s", new Object[] { paramMessageMicro, paramClass });
        if ((!paramBoolean) || (bool)) {
          break;
        }
        return true;
      }
      paramStringBuilder.append(paramString);
      paramStringBuilder.append(paramClass);
    }
    return false;
  }
  
  private static boolean dealPBInt32Field(Class<?> paramClass, MessageMicro paramMessageMicro, boolean paramBoolean, StringBuilder paramStringBuilder, String paramString, Field paramField, AtomicBoolean paramAtomicBoolean)
  {
    if (paramAtomicBoolean.get()) {
      return false;
    }
    if (PBInt32Field.class.isAssignableFrom(paramClass))
    {
      paramAtomicBoolean.set(true);
      paramClass = (PBInt32Field)paramField.get(paramMessageMicro);
      if (paramClass == null) {
        return true;
      }
      boolean bool = paramClass.has();
      int i = paramClass.get();
      paramMessageMicro = paramField.getName();
      if (bool) {}
      for (paramClass = Integer.valueOf(i);; paramClass = "NA")
      {
        paramClass = String.format("%s: %s", new Object[] { paramMessageMicro, paramClass });
        if ((!paramBoolean) || (bool)) {
          break;
        }
        return true;
      }
      paramStringBuilder.append(paramString);
      paramStringBuilder.append(paramClass);
    }
    return false;
  }
  
  private static boolean dealPBInt64Field(Class<?> paramClass, MessageMicro paramMessageMicro, boolean paramBoolean, StringBuilder paramStringBuilder, String paramString, Field paramField, AtomicBoolean paramAtomicBoolean)
  {
    if (paramAtomicBoolean.get()) {
      return false;
    }
    if (PBInt64Field.class.isAssignableFrom(paramClass))
    {
      paramAtomicBoolean.set(true);
      paramClass = (PBInt64Field)paramField.get(paramMessageMicro);
      if (paramClass == null) {
        return true;
      }
      boolean bool = paramClass.has();
      long l = paramClass.get();
      paramMessageMicro = paramField.getName();
      if (bool) {}
      for (paramClass = Long.valueOf(l);; paramClass = "NA")
      {
        paramClass = String.format("%s: %s", new Object[] { paramMessageMicro, paramClass });
        if ((!paramBoolean) || (bool)) {
          break;
        }
        return true;
      }
      paramStringBuilder.append(paramString);
      paramStringBuilder.append(paramClass);
    }
    return false;
  }
  
  private static boolean dealPBRepeatField(Class<?> paramClass, MessageMicro paramMessageMicro, boolean paramBoolean, StringBuilder paramStringBuilder, String paramString, Field paramField, AtomicBoolean paramAtomicBoolean)
  {
    if (paramAtomicBoolean.get()) {
      return false;
    }
    if (PBRepeatField.class.isAssignableFrom(paramClass))
    {
      paramAtomicBoolean.set(true);
      paramClass = (PBRepeatField)paramField.get(paramMessageMicro);
      if (paramClass == null) {
        return true;
      }
      boolean bool = paramClass.has();
      paramClass = paramClass.get();
      if ((paramBoolean) && ((!bool) || (paramClass.isEmpty()))) {
        return true;
      }
      if (bool) {
        break label110;
      }
      paramClass = String.format("%s: [NA]", new Object[] { paramField.getName() });
      paramStringBuilder.append(paramString);
      paramStringBuilder.append(paramClass);
    }
    for (;;)
    {
      return false;
      label110:
      paramStringBuilder.append(paramString).append(String.format("%s: [\n", new Object[] { paramField.getName() }));
      paramMessageMicro = paramClass.iterator();
      while (paramMessageMicro.hasNext())
      {
        paramField = paramMessageMicro.next();
        paramStringBuilder.append(paramString).append("    ").append(paramField);
        if (paramField != paramClass.get(paramClass.size() - 1)) {
          paramStringBuilder.append(",");
        }
        paramStringBuilder.append("\n");
      }
      paramStringBuilder.append(paramString).append("]");
    }
  }
  
  private static boolean dealPBRepeatMessageField(Class<?> paramClass, MessageMicro paramMessageMicro, boolean paramBoolean, StringBuilder paramStringBuilder, String paramString, Field paramField, int paramInt, AtomicBoolean paramAtomicBoolean)
  {
    if (paramAtomicBoolean.get()) {
      return false;
    }
    if (PBRepeatMessageField.class.isAssignableFrom(paramClass))
    {
      paramAtomicBoolean.set(true);
      paramClass = (PBRepeatMessageField)paramField.get(paramMessageMicro);
      if (paramClass == null) {
        return true;
      }
      boolean bool = paramClass.has();
      paramClass = paramClass.get();
      if ((paramBoolean) && ((!bool) || (paramClass.isEmpty()))) {
        return true;
      }
      if (bool) {
        break label110;
      }
      paramClass = String.format("%s: [NA]", new Object[] { paramField.getName() });
      paramStringBuilder.append(paramString);
      paramStringBuilder.append(paramClass);
    }
    for (;;)
    {
      return false;
      label110:
      paramStringBuilder.append(paramString).append(String.format("%s: [\n", new Object[] { paramField.getName() }));
      paramMessageMicro = paramClass.iterator();
      while (paramMessageMicro.hasNext())
      {
        paramField = (MessageMicro)paramMessageMicro.next();
        paramStringBuilder.append(paramString).append("    ").append("{\n");
        paramStringBuilder.append(proto2String(paramField, paramInt + 2, paramBoolean));
        paramStringBuilder.append(paramString).append("    ").append("}");
        if (paramField != paramClass.get(paramClass.size() - 1)) {
          paramStringBuilder.append(",");
        }
        paramStringBuilder.append("\n");
      }
      paramStringBuilder.append(paramString).append("]");
    }
  }
  
  private static boolean dealPBSFixed32Field(Class<?> paramClass, MessageMicro paramMessageMicro, boolean paramBoolean, StringBuilder paramStringBuilder, String paramString, Field paramField, AtomicBoolean paramAtomicBoolean)
  {
    if (paramAtomicBoolean.get()) {
      return false;
    }
    if (PBSFixed32Field.class.isAssignableFrom(paramClass))
    {
      paramAtomicBoolean.set(true);
      paramClass = (PBSFixed32Field)paramField.get(paramMessageMicro);
      if (paramClass == null) {
        return true;
      }
      boolean bool = paramClass.has();
      int i = paramClass.get();
      paramMessageMicro = paramField.getName();
      if (bool) {}
      for (paramClass = Integer.valueOf(i);; paramClass = "NA")
      {
        paramClass = String.format("%s: %s", new Object[] { paramMessageMicro, paramClass });
        if ((!paramBoolean) || (bool)) {
          break;
        }
        return true;
      }
      paramStringBuilder.append(paramString);
      paramStringBuilder.append(paramClass);
    }
    return false;
  }
  
  private static boolean dealPBSFixed64Field(Class<?> paramClass, MessageMicro paramMessageMicro, boolean paramBoolean, StringBuilder paramStringBuilder, String paramString, Field paramField, AtomicBoolean paramAtomicBoolean)
  {
    if (paramAtomicBoolean.get()) {
      return false;
    }
    if (PBSFixed64Field.class.isAssignableFrom(paramClass))
    {
      paramAtomicBoolean.set(true);
      paramClass = (PBSFixed64Field)paramField.get(paramMessageMicro);
      if (paramClass == null) {
        return true;
      }
      boolean bool = paramClass.has();
      long l = paramClass.get();
      paramMessageMicro = paramField.getName();
      if (bool) {}
      for (paramClass = Long.valueOf(l);; paramClass = "NA")
      {
        paramClass = String.format("%s: %s", new Object[] { paramMessageMicro, paramClass });
        if ((!paramBoolean) || (bool)) {
          break;
        }
        return true;
      }
      paramStringBuilder.append(paramString);
      paramStringBuilder.append(paramClass);
    }
    return false;
  }
  
  private static boolean dealPBSInt32Field(Class<?> paramClass, MessageMicro paramMessageMicro, boolean paramBoolean, StringBuilder paramStringBuilder, String paramString, Field paramField, AtomicBoolean paramAtomicBoolean)
  {
    if (paramAtomicBoolean.get()) {
      return Boolean.TRUE.booleanValue();
    }
    if (PBSInt32Field.class.isAssignableFrom(paramClass))
    {
      paramAtomicBoolean.set(true);
      paramClass = (PBSInt32Field)paramField.get(paramMessageMicro);
      if (paramClass == null) {
        return true;
      }
      boolean bool = paramClass.has();
      int i = paramClass.get();
      paramMessageMicro = paramField.getName();
      if (bool) {}
      for (paramClass = Integer.valueOf(i);; paramClass = "NA")
      {
        paramClass = String.format("%s: %s", new Object[] { paramMessageMicro, paramClass });
        if ((!paramBoolean) || (bool)) {
          break;
        }
        return true;
      }
      paramStringBuilder.append(paramString);
      paramStringBuilder.append(paramClass);
    }
    return false;
  }
  
  private static boolean dealPBSInt64Field(Class<?> paramClass, MessageMicro paramMessageMicro, boolean paramBoolean, StringBuilder paramStringBuilder, String paramString, Field paramField, AtomicBoolean paramAtomicBoolean)
  {
    if (paramAtomicBoolean.get()) {
      return Boolean.TRUE.booleanValue();
    }
    if (PBSInt64Field.class.isAssignableFrom(paramClass))
    {
      paramAtomicBoolean.set(true);
      paramClass = (PBSInt64Field)paramField.get(paramMessageMicro);
      if (paramClass == null) {
        return true;
      }
      boolean bool = paramClass.has();
      long l = paramClass.get();
      paramMessageMicro = paramField.getName();
      if (bool) {}
      for (paramClass = Long.valueOf(l);; paramClass = "NA")
      {
        paramClass = String.format("%s: %s", new Object[] { paramMessageMicro, paramClass });
        if ((!paramBoolean) || (bool)) {
          break;
        }
        return true;
      }
      paramStringBuilder.append(paramString);
      paramStringBuilder.append(paramClass);
    }
    return false;
  }
  
  private static boolean dealPBStringField(Class<?> paramClass, MessageMicro paramMessageMicro, boolean paramBoolean, StringBuilder paramStringBuilder, String paramString, Field paramField, AtomicBoolean paramAtomicBoolean)
  {
    if (paramAtomicBoolean.get()) {
      return Boolean.TRUE.booleanValue();
    }
    if (PBStringField.class.isAssignableFrom(paramClass))
    {
      paramAtomicBoolean.set(true);
      paramClass = (PBStringField)paramField.get(paramMessageMicro);
      if (paramClass == null) {
        return true;
      }
      boolean bool = paramClass.has();
      paramClass = paramClass.get();
      paramMessageMicro = paramField.getName();
      if (bool) {}
      for (;;)
      {
        paramClass = String.format("%s: %s", new Object[] { paramMessageMicro, paramClass });
        if ((!paramBoolean) || (bool)) {
          break;
        }
        return true;
        paramClass = "NA";
      }
      paramStringBuilder.append(paramString);
      paramStringBuilder.append(paramClass);
    }
    return false;
  }
  
  private static boolean dealPBUInt32Field(Class<?> paramClass, MessageMicro paramMessageMicro, boolean paramBoolean, StringBuilder paramStringBuilder, String paramString, Field paramField, AtomicBoolean paramAtomicBoolean)
  {
    if (paramAtomicBoolean.get()) {
      return Boolean.TRUE.booleanValue();
    }
    if (PBUInt32Field.class.isAssignableFrom(paramClass))
    {
      paramAtomicBoolean.set(true);
      paramClass = (PBUInt32Field)paramField.get(paramMessageMicro);
      if (paramClass == null) {
        return true;
      }
      boolean bool = paramClass.has();
      int i = paramClass.get();
      paramMessageMicro = paramField.getName();
      if (bool) {}
      for (paramClass = Integer.valueOf(i);; paramClass = "NA")
      {
        paramClass = String.format("%s: %s", new Object[] { paramMessageMicro, paramClass });
        if ((!paramBoolean) || (bool)) {
          break;
        }
        return true;
      }
      paramStringBuilder.append(paramString);
      paramStringBuilder.append(paramClass);
    }
    return false;
  }
  
  private static boolean dealPBUInt64Field(Class<?> paramClass, MessageMicro paramMessageMicro, boolean paramBoolean, StringBuilder paramStringBuilder, String paramString, Field paramField, AtomicBoolean paramAtomicBoolean)
  {
    if (paramAtomicBoolean.get()) {
      return Boolean.TRUE.booleanValue();
    }
    if (PBUInt64Field.class.isAssignableFrom(paramClass))
    {
      paramAtomicBoolean.set(true);
      paramClass = (PBUInt64Field)paramField.get(paramMessageMicro);
      if (paramClass == null) {
        return true;
      }
      boolean bool = paramClass.has();
      long l = paramClass.get();
      paramMessageMicro = paramField.getName();
      if (bool) {}
      for (paramClass = Long.valueOf(l);; paramClass = "NA")
      {
        paramClass = String.format("%s: %s", new Object[] { paramMessageMicro, paramClass });
        if ((!paramBoolean) || (bool)) {
          break;
        }
        return true;
      }
      paramStringBuilder.append(paramString);
      paramStringBuilder.append(paramClass);
    }
    return false;
  }
  
  public static int parseOIDBPkg(FromServiceMsg paramFromServiceMsg, Object paramObject, MessageMicro paramMessageMicro)
  {
    return parseOIDBPkg(paramFromServiceMsg, paramObject, new oidb_sso.OIDBSSOPkg(), paramMessageMicro);
  }
  
  /* Error */
  public static int parseOIDBPkg(FromServiceMsg paramFromServiceMsg, Object paramObject, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg, MessageMicro paramMessageMicro)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 269	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   4: istore 4
    //   6: invokestatic 274	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   9: ifeq +304 -> 313
    //   12: new 58	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 275	java/lang/StringBuilder:<init>	()V
    //   19: astore 6
    //   21: iload 4
    //   23: sipush 1000
    //   26: if_icmpne +253 -> 279
    //   29: aload_1
    //   30: ifnull +209 -> 239
    //   33: aload_2
    //   34: aload_1
    //   35: checkcast 277	[B
    //   38: checkcast 277	[B
    //   41: invokevirtual 281	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   44: checkcast 258	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   47: astore_1
    //   48: aload_1
    //   49: ifnull +66 -> 115
    //   52: aload_1
    //   53: getfield 285	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   56: invokevirtual 249	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   59: istore 5
    //   61: iload 5
    //   63: istore 4
    //   65: iload 5
    //   67: ifeq +48 -> 115
    //   70: aload_1
    //   71: getfield 289	tencent/im/oidb/oidb_sso$OIDBSSOPkg:str_error_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   74: invokevirtual 244	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   77: astore_2
    //   78: aload_0
    //   79: getfield 293	com/tencent/qphone/base/remote/FromServiceMsg:extraData	Landroid/os/Bundle;
    //   82: ldc_w 294
    //   85: aload_2
    //   86: invokevirtual 300	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: iload 5
    //   91: istore 4
    //   93: aload 6
    //   95: ifnull +20 -> 115
    //   98: aload 6
    //   100: ldc_w 302
    //   103: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: aload_2
    //   107: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: iload 5
    //   113: istore 4
    //   115: iload 4
    //   117: istore 5
    //   119: aload_1
    //   120: ifnull +186 -> 306
    //   123: iload 4
    //   125: istore 5
    //   127: aload_1
    //   128: getfield 306	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   131: invokevirtual 93	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   134: ifeq +172 -> 306
    //   137: iload 4
    //   139: istore 5
    //   141: aload_1
    //   142: getfield 306	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   145: invokevirtual 309	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   148: ifnull +158 -> 306
    //   151: iload 4
    //   153: istore 5
    //   155: aload_3
    //   156: ifnull +150 -> 306
    //   159: aload_3
    //   160: aload_1
    //   161: getfield 306	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   164: invokevirtual 309	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   167: invokevirtual 315	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   170: invokevirtual 316	com/tencent/mobileqq/pb/MessageMicro:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   173: pop
    //   174: aload 6
    //   176: ifnull +29 -> 205
    //   179: aload 6
    //   181: invokevirtual 319	java/lang/StringBuilder:length	()I
    //   184: ifle +21 -> 205
    //   187: invokestatic 274	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   190: ifeq +15 -> 205
    //   193: ldc_w 321
    //   196: iconst_4
    //   197: aload 6
    //   199: invokevirtual 324	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   202: invokestatic 328	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   205: iload 4
    //   207: ireturn
    //   208: astore_1
    //   209: aload 6
    //   211: ifnull +19 -> 230
    //   214: aload 6
    //   216: ldc_w 330
    //   219: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: aload_1
    //   223: invokevirtual 331	java/lang/Exception:toString	()Ljava/lang/String;
    //   226: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: pop
    //   230: aload_1
    //   231: invokevirtual 334	java/lang/Exception:printStackTrace	()V
    //   234: aload_2
    //   235: astore_1
    //   236: goto -188 -> 48
    //   239: aload_2
    //   240: astore_1
    //   241: aload 6
    //   243: ifnull -195 -> 48
    //   246: aload 6
    //   248: ldc_w 336
    //   251: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: pop
    //   255: aload_2
    //   256: astore_1
    //   257: goto -209 -> 48
    //   260: astore_0
    //   261: aload 6
    //   263: ifnull +13 -> 276
    //   266: aload 6
    //   268: aload_0
    //   269: invokevirtual 331	java/lang/Exception:toString	()Ljava/lang/String;
    //   272: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: pop
    //   276: goto -102 -> 174
    //   279: iload 4
    //   281: istore 5
    //   283: aload 6
    //   285: ifnull +21 -> 306
    //   288: aload 6
    //   290: ldc_w 338
    //   293: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: iload 4
    //   298: invokevirtual 341	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   301: pop
    //   302: iload 4
    //   304: istore 5
    //   306: iload 5
    //   308: istore 4
    //   310: goto -136 -> 174
    //   313: aconst_null
    //   314: astore 6
    //   316: goto -295 -> 21
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	319	0	paramFromServiceMsg	FromServiceMsg
    //   0	319	1	paramObject	Object
    //   0	319	2	paramOIDBSSOPkg	oidb_sso.OIDBSSOPkg
    //   0	319	3	paramMessageMicro	MessageMicro
    //   4	305	4	i	int
    //   59	248	5	j	int
    //   19	296	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   33	48	208	java/lang/Exception
    //   159	174	260	java/lang/Exception
  }
  
  public static String proto2String(MessageMicro paramMessageMicro)
  {
    return proto2String(paramMessageMicro, true);
  }
  
  public static String proto2String(MessageMicro paramMessageMicro, int paramInt, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str = "";
    int i = paramInt;
    while (i > 0)
    {
      str = str + "    ";
      i -= 1;
    }
    Field[] arrayOfField;
    int j;
    Field localField;
    if (paramMessageMicro != null)
    {
      try
      {
        arrayOfField = paramMessageMicro.getClass().getFields();
        j = arrayOfField.length;
        i = 0;
      }
      catch (Throwable paramMessageMicro)
      {
        Class localClass;
        AtomicBoolean localAtomicBoolean;
        boolean bool1;
        boolean bool2;
        boolean bool3;
        boolean bool4;
        boolean bool5;
        boolean bool6;
        boolean bool7;
        boolean bool8;
        boolean bool9;
        boolean bool10;
        boolean bool11;
        boolean bool12;
        boolean bool13;
        boolean bool14;
        boolean bool15;
        boolean bool16;
        boolean bool17;
        boolean bool18;
        localStringBuilder.append("***ERROR***").append("\n").append(paramMessageMicro);
      }
      localField.setAccessible(true);
      localClass = localField.getType();
      localAtomicBoolean = new AtomicBoolean(false);
      bool1 = dealPBBoolField(localClass, paramMessageMicro, paramBoolean, localStringBuilder, str, localField, localAtomicBoolean);
      bool2 = dealPBBytesField(localClass, paramMessageMicro, paramBoolean, localStringBuilder, str, localField, localAtomicBoolean);
      bool3 = dealPBDoubleField(localClass, paramMessageMicro, paramBoolean, localStringBuilder, str, localField, localAtomicBoolean);
      bool4 = dealPBEnumField(localClass, paramMessageMicro, paramBoolean, localStringBuilder, str, localField, localAtomicBoolean);
      bool5 = dealPBFixed32Field(localClass, paramMessageMicro, paramBoolean, localStringBuilder, str, localField, localAtomicBoolean);
      bool6 = dealPBFixed64Field(localClass, paramMessageMicro, paramBoolean, localStringBuilder, str, localField, localAtomicBoolean);
      bool7 = dealPBFloatField(localClass, paramMessageMicro, paramBoolean, localStringBuilder, str, localField, localAtomicBoolean);
      bool8 = dealPBInt32Field(localClass, paramMessageMicro, paramBoolean, localStringBuilder, str, localField, localAtomicBoolean);
      bool9 = dealPBInt64Field(localClass, paramMessageMicro, paramBoolean, localStringBuilder, str, localField, localAtomicBoolean);
      bool10 = dealPBSFixed32Field(localClass, paramMessageMicro, paramBoolean, localStringBuilder, str, localField, localAtomicBoolean);
      bool11 = dealPBSFixed64Field(localClass, paramMessageMicro, paramBoolean, localStringBuilder, str, localField, localAtomicBoolean);
      bool12 = dealPBSInt32Field(localClass, paramMessageMicro, paramBoolean, localStringBuilder, str, localField, localAtomicBoolean);
      bool13 = dealPBSInt64Field(localClass, paramMessageMicro, paramBoolean, localStringBuilder, str, localField, localAtomicBoolean);
      bool14 = dealPBStringField(localClass, paramMessageMicro, paramBoolean, localStringBuilder, str, localField, localAtomicBoolean);
      bool15 = dealPBUInt32Field(localClass, paramMessageMicro, paramBoolean, localStringBuilder, str, localField, localAtomicBoolean);
      bool16 = dealPBUInt64Field(localClass, paramMessageMicro, paramBoolean, localStringBuilder, str, localField, localAtomicBoolean);
      bool17 = dealPBRepeatField(localClass, paramMessageMicro, paramBoolean, localStringBuilder, str, localField, localAtomicBoolean);
      bool18 = dealPBRepeatMessageField(localClass, paramMessageMicro, paramBoolean, localStringBuilder, str, localField, paramInt, localAtomicBoolean);
      if ((dealMessageMicro(localClass, paramMessageMicro, paramBoolean, localStringBuilder, str, localField, paramInt, localAtomicBoolean) | bool17 | false | bool1 | bool2 | bool3 | bool4 | bool5 | bool6 | bool7 | bool8 | bool9 | bool10 | bool11 | bool12 | bool13 | bool14 | bool15 | bool16 | bool18)) {
        break label617;
      }
      if (localAtomicBoolean.get()) {
        break label568;
      }
      if (!QLog.isColorLevel()) {
        break label617;
      }
      QLog.d("OidbWrapper", 2, "unknown type {" + localField.getName() + "|" + localField.getType() + "}");
      break label617;
    }
    label568:
    label617:
    label622:
    for (;;)
    {
      return localStringBuilder.toString();
      if (localField != arrayOfField[(arrayOfField.length - 1)]) {
        localStringBuilder.append(",");
      }
      localStringBuilder.append("\n");
      for (;;)
      {
        if (i >= j) {
          break label622;
        }
        localField = arrayOfField[i];
        if (localField != null) {
          break;
        }
        i += 1;
      }
    }
  }
  
  public static String proto2String(MessageMicro paramMessageMicro, boolean paramBoolean)
  {
    return proto2String(paramMessageMicro, 0, paramBoolean);
  }
  
  protected abstract void addBusinessObserver(ToServiceMsg paramToServiceMsg, BusinessObserver paramBusinessObserver, boolean paramBoolean);
  
  public abstract ToServiceMsg createToServiceMsg(String paramString);
  
  public ToServiceMsg makeOIDBPkg(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    return makeOIDBPkg(paramString, paramInt1, paramInt2, paramArrayOfByte, 30000L);
  }
  
  public ToServiceMsg makeOIDBPkg(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte, long paramLong)
  {
    return makeOIDBPkg(paramString, paramInt1, paramInt2, paramArrayOfByte, paramLong, null, false);
  }
  
  public ToServiceMsg makeOIDBPkg(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte, long paramLong, BusinessObserver paramBusinessObserver, boolean paramBoolean)
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(paramInt1);
    localOIDBSSOPkg.uint32_service_type.set(paramInt2);
    localOIDBSSOPkg.uint32_result.set(0);
    localOIDBSSOPkg.str_client_version.set(AppSetting.f());
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    paramString = createToServiceMsg(paramString);
    paramString.putWupBuffer(localOIDBSSOPkg.toByteArray());
    paramString.setTimeout(paramLong);
    addBusinessObserver(paramString, paramBusinessObserver, paramBoolean);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.OidbWrapper
 * JD-Core Version:    0.7.0.1
 */