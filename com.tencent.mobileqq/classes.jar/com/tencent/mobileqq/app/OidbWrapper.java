package com.tencent.mobileqq.app;

import android.os.Bundle;
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
      if (!bool)
      {
        paramClass = String.format("%s: NA", new Object[] { paramField.getName() });
        paramStringBuilder.append(paramString);
        paramStringBuilder.append(paramClass);
        return false;
      }
      paramStringBuilder.append(paramString);
      paramStringBuilder.append(paramField.getName());
      paramStringBuilder.append(": {\n");
      paramStringBuilder.append(proto2String(paramClass, paramInt + 1, paramBoolean));
      paramStringBuilder.append(paramString);
      paramStringBuilder.append("}");
    }
    return false;
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
      if (bool1) {
        paramClass = Boolean.valueOf(bool2);
      } else {
        paramClass = "NA";
      }
      paramClass = String.format("%s: %s", new Object[] { paramMessageMicro, paramClass });
      if ((paramBoolean) && (!bool1)) {
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
      if (bool) {
        paramClass = "<…bytes…>";
      } else {
        paramClass = "NA";
      }
      paramClass = String.format("%s: %s", new Object[] { paramMessageMicro, paramClass });
      if ((paramBoolean) && (!bool)) {
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
      if (bool) {
        paramClass = Double.valueOf(d);
      } else {
        paramClass = "NA";
      }
      paramClass = String.format("%s: %s", new Object[] { paramMessageMicro, paramClass });
      if ((paramBoolean) && (!bool)) {
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
      if (bool) {
        paramClass = Integer.valueOf(i);
      } else {
        paramClass = "NA";
      }
      paramClass = String.format("%s: %s", new Object[] { paramMessageMicro, paramClass });
      if ((paramBoolean) && (!bool)) {
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
      if (bool) {
        paramClass = Integer.valueOf(i);
      } else {
        paramClass = "NA";
      }
      paramClass = String.format("%s: %s", new Object[] { paramMessageMicro, paramClass });
      if ((paramBoolean) && (!bool)) {
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
      if (bool) {
        paramClass = Long.valueOf(l);
      } else {
        paramClass = "NA";
      }
      paramClass = String.format("%s: %s", new Object[] { paramMessageMicro, paramClass });
      if ((paramBoolean) && (!bool)) {
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
      if (bool) {
        paramClass = Float.valueOf(f);
      } else {
        paramClass = "NA";
      }
      paramClass = String.format("%s: %s", new Object[] { paramMessageMicro, paramClass });
      if ((paramBoolean) && (!bool)) {
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
      if (bool) {
        paramClass = Integer.valueOf(i);
      } else {
        paramClass = "NA";
      }
      paramClass = String.format("%s: %s", new Object[] { paramMessageMicro, paramClass });
      if ((paramBoolean) && (!bool)) {
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
      if (bool) {
        paramClass = Long.valueOf(l);
      } else {
        paramClass = "NA";
      }
      paramClass = String.format("%s: %s", new Object[] { paramMessageMicro, paramClass });
      if ((paramBoolean) && (!bool)) {
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
      if (!bool)
      {
        paramClass = String.format("%s: [NA]", new Object[] { paramField.getName() });
        paramStringBuilder.append(paramString);
        paramStringBuilder.append(paramClass);
        return false;
      }
      paramStringBuilder.append(paramString);
      paramStringBuilder.append(String.format("%s: [\n", new Object[] { paramField.getName() }));
      paramMessageMicro = paramClass.iterator();
      while (paramMessageMicro.hasNext())
      {
        paramField = paramMessageMicro.next();
        paramStringBuilder.append(paramString);
        paramStringBuilder.append("    ");
        paramStringBuilder.append(paramField);
        if (paramField != paramClass.get(paramClass.size() - 1)) {
          paramStringBuilder.append(",");
        }
        paramStringBuilder.append("\n");
      }
      paramStringBuilder.append(paramString);
      paramStringBuilder.append("]");
    }
    return false;
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
      if (!bool)
      {
        paramClass = String.format("%s: [NA]", new Object[] { paramField.getName() });
        paramStringBuilder.append(paramString);
        paramStringBuilder.append(paramClass);
        return false;
      }
      paramStringBuilder.append(paramString);
      paramStringBuilder.append(String.format("%s: [\n", new Object[] { paramField.getName() }));
      paramMessageMicro = paramClass.iterator();
      while (paramMessageMicro.hasNext())
      {
        paramField = (MessageMicro)paramMessageMicro.next();
        paramStringBuilder.append(paramString);
        paramStringBuilder.append("    ");
        paramStringBuilder.append("{\n");
        paramStringBuilder.append(proto2String(paramField, paramInt + 2, paramBoolean));
        paramStringBuilder.append(paramString);
        paramStringBuilder.append("    ");
        paramStringBuilder.append("}");
        if (paramField != paramClass.get(paramClass.size() - 1)) {
          paramStringBuilder.append(",");
        }
        paramStringBuilder.append("\n");
      }
      paramStringBuilder.append(paramString);
      paramStringBuilder.append("]");
    }
    return false;
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
      if (bool) {
        paramClass = Integer.valueOf(i);
      } else {
        paramClass = "NA";
      }
      paramClass = String.format("%s: %s", new Object[] { paramMessageMicro, paramClass });
      if ((paramBoolean) && (!bool)) {
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
      if (bool) {
        paramClass = Long.valueOf(l);
      } else {
        paramClass = "NA";
      }
      paramClass = String.format("%s: %s", new Object[] { paramMessageMicro, paramClass });
      if ((paramBoolean) && (!bool)) {
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
      if (bool) {
        paramClass = Integer.valueOf(i);
      } else {
        paramClass = "NA";
      }
      paramClass = String.format("%s: %s", new Object[] { paramMessageMicro, paramClass });
      if ((paramBoolean) && (!bool)) {
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
      if (bool) {
        paramClass = Long.valueOf(l);
      } else {
        paramClass = "NA";
      }
      paramClass = String.format("%s: %s", new Object[] { paramMessageMicro, paramClass });
      if ((paramBoolean) && (!bool)) {
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
      if (!bool) {
        paramClass = "NA";
      }
      paramClass = String.format("%s: %s", new Object[] { paramMessageMicro, paramClass });
      if ((paramBoolean) && (!bool)) {
        return true;
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
      if (bool) {
        paramClass = Integer.valueOf(i);
      } else {
        paramClass = "NA";
      }
      paramClass = String.format("%s: %s", new Object[] { paramMessageMicro, paramClass });
      if ((paramBoolean) && (!bool)) {
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
      if (bool) {
        paramClass = Long.valueOf(l);
      } else {
        paramClass = "NA";
      }
      paramClass = String.format("%s: %s", new Object[] { paramMessageMicro, paramClass });
      if ((paramBoolean) && (!bool)) {
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
  
  public static int parseOIDBPkg(FromServiceMsg paramFromServiceMsg, Object paramObject, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg, MessageMicro paramMessageMicro)
  {
    int i = paramFromServiceMsg.getResultCode();
    StringBuilder localStringBuilder;
    if (QLog.isDevelopLevel()) {
      localStringBuilder = new StringBuilder();
    } else {
      localStringBuilder = null;
    }
    label103:
    int j;
    if (i == 1000)
    {
      if (paramObject != null) {
        try
        {
          paramObject = (oidb_sso.OIDBSSOPkg)paramOIDBSSOPkg.mergeFrom((byte[])paramObject);
        }
        catch (Exception paramObject)
        {
          if (localStringBuilder != null)
          {
            localStringBuilder.append("parseOIDBPkg, oidb_sso, parseFrom byte ");
            localStringBuilder.append(paramObject.toString());
          }
          paramObject.printStackTrace();
          break label103;
        }
      } else if (localStringBuilder != null) {
        localStringBuilder.append("parseOIDBPkg, data is null");
      }
      paramObject = paramOIDBSSOPkg;
      if (paramObject != null)
      {
        j = paramObject.uint32_result.get();
        i = j;
        if (j != 0)
        {
          paramOIDBSSOPkg = paramObject.str_error_msg.get();
          paramFromServiceMsg.extraData.putString("str_error_msg", paramOIDBSSOPkg);
          i = j;
          if (localStringBuilder != null)
          {
            localStringBuilder.append("parseOIDBPkg, errMsg: ");
            localStringBuilder.append(paramOIDBSSOPkg);
            i = j;
          }
        }
      }
      j = i;
      if (paramObject != null)
      {
        j = i;
        if (paramObject.bytes_bodybuffer.has())
        {
          j = i;
          if (paramObject.bytes_bodybuffer.get() != null)
          {
            j = i;
            if (paramMessageMicro != null)
            {
              try
              {
                paramMessageMicro.mergeFrom(paramObject.bytes_bodybuffer.get().toByteArray());
                j = i;
              }
              catch (Exception paramFromServiceMsg)
              {
                j = i;
                if (localStringBuilder == null) {
                  break label298;
                }
              }
              localStringBuilder.append(paramFromServiceMsg.toString());
              j = i;
            }
          }
        }
      }
    }
    else
    {
      j = i;
      if (localStringBuilder != null)
      {
        localStringBuilder.append("parseOIDBPkg, sso result: ");
        localStringBuilder.append(i);
        j = i;
      }
    }
    label298:
    if ((localStringBuilder != null) && (localStringBuilder.length() > 0) && (QLog.isDevelopLevel())) {
      QLog.i("BaseBusinessHandler", 4, localStringBuilder.toString());
    }
    return j;
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
    Object localObject1;
    while (i > 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append("    ");
      str = ((StringBuilder)localObject1).toString();
      i -= 1;
    }
    int j;
    Field localField;
    if (paramMessageMicro != null)
    {
      try
      {
        localObject1 = paramMessageMicro.getClass().getFields();
        j = localObject1.length;
        i = 0;
      }
      catch (Throwable paramMessageMicro)
      {
        Object localObject2;
        AtomicBoolean localAtomicBoolean;
        localStringBuilder.append("***ERROR***");
        localStringBuilder.append("\n");
        localStringBuilder.append(paramMessageMicro);
      }
      localField.setAccessible(true);
      localObject2 = localField.getType();
      localAtomicBoolean = new AtomicBoolean(false);
      if (!(dealPBBoolField((Class)localObject2, paramMessageMicro, paramBoolean, localStringBuilder, str, localField, localAtomicBoolean) | false | dealPBBytesField((Class)localObject2, paramMessageMicro, paramBoolean, localStringBuilder, str, localField, localAtomicBoolean) | dealPBDoubleField((Class)localObject2, paramMessageMicro, paramBoolean, localStringBuilder, str, localField, localAtomicBoolean) | dealPBEnumField((Class)localObject2, paramMessageMicro, paramBoolean, localStringBuilder, str, localField, localAtomicBoolean) | dealPBFixed32Field((Class)localObject2, paramMessageMicro, paramBoolean, localStringBuilder, str, localField, localAtomicBoolean) | dealPBFixed64Field((Class)localObject2, paramMessageMicro, paramBoolean, localStringBuilder, str, localField, localAtomicBoolean) | dealPBFloatField((Class)localObject2, paramMessageMicro, paramBoolean, localStringBuilder, str, localField, localAtomicBoolean) | dealPBInt32Field((Class)localObject2, paramMessageMicro, paramBoolean, localStringBuilder, str, localField, localAtomicBoolean) | dealPBInt64Field((Class)localObject2, paramMessageMicro, paramBoolean, localStringBuilder, str, localField, localAtomicBoolean) | dealPBSFixed32Field((Class)localObject2, paramMessageMicro, paramBoolean, localStringBuilder, str, localField, localAtomicBoolean) | dealPBSFixed64Field((Class)localObject2, paramMessageMicro, paramBoolean, localStringBuilder, str, localField, localAtomicBoolean) | dealPBSInt32Field((Class)localObject2, paramMessageMicro, paramBoolean, localStringBuilder, str, localField, localAtomicBoolean) | dealPBSInt64Field((Class)localObject2, paramMessageMicro, paramBoolean, localStringBuilder, str, localField, localAtomicBoolean) | dealPBStringField((Class)localObject2, paramMessageMicro, paramBoolean, localStringBuilder, str, localField, localAtomicBoolean) | dealPBUInt32Field((Class)localObject2, paramMessageMicro, paramBoolean, localStringBuilder, str, localField, localAtomicBoolean) | dealPBUInt64Field((Class)localObject2, paramMessageMicro, paramBoolean, localStringBuilder, str, localField, localAtomicBoolean) | dealPBRepeatField((Class)localObject2, paramMessageMicro, paramBoolean, localStringBuilder, str, localField, localAtomicBoolean) | dealPBRepeatMessageField((Class)localObject2, paramMessageMicro, paramBoolean, localStringBuilder, str, localField, paramInt, localAtomicBoolean) | dealMessageMicro((Class)localObject2, paramMessageMicro, paramBoolean, localStringBuilder, str, localField, paramInt, localAtomicBoolean))) {
        if (!localAtomicBoolean.get())
        {
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("unknown type {");
            ((StringBuilder)localObject2).append(localField.getName());
            ((StringBuilder)localObject2).append("|");
            ((StringBuilder)localObject2).append(localField.getType());
            ((StringBuilder)localObject2).append("}");
            QLog.d("OidbWrapper", 2, ((StringBuilder)localObject2).toString());
          }
        }
        else
        {
          if (localField != localObject1[(localObject1.length - 1)]) {
            localStringBuilder.append(",");
          }
          localStringBuilder.append("\n");
        }
      }
    }
    for (;;)
    {
      i += 1;
      while (i >= j) {
        return localStringBuilder.toString();
      }
      localField = localObject1[i];
      if (localField != null) {
        break;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.OidbWrapper
 * JD-Core Version:    0.7.0.1
 */