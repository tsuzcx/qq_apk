package com.tencent.biz.authorize;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.flatbuffers.FbArray;
import com.tencent.biz.flatbuffers.FbTable;
import com.tencent.biz.flatbuffers.FlatBuffersParser;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class FlatBuffersConfig
  extends AbstractConfig
{
  public static HashMap<String, Integer> a;
  public volatile long a;
  public JsonConfig a;
  public FbTable a;
  public FlatBuffersParser a;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilHashMap.put("skey", Integer.valueOf(6));
    jdField_a_of_type_JavaUtilHashMap.put("pskey", Integer.valueOf(7));
    jdField_a_of_type_JavaUtilHashMap.put("a1", Integer.valueOf(8));
    jdField_a_of_type_JavaUtilHashMap.put("a2", Integer.valueOf(9));
    jdField_a_of_type_JavaUtilHashMap.put("ptlogin2", Integer.valueOf(10));
    jdField_a_of_type_JavaUtilHashMap.put("pt4_token", Integer.valueOf(11));
  }
  
  public FlatBuffersConfig(SharedPreferences paramSharedPreferences)
  {
    super(paramSharedPreferences, null);
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_ComTencentBizFlatbuffersFlatBuffersParser = new FlatBuffersParser();
  }
  
  public static int a(FbArray paramFbArray, int paramInt1, int paramInt2, String paramString)
  {
    int j = paramString.length();
    int i = 0;
    while ((i < j) && (paramInt1 < paramInt2))
    {
      int k = paramFbArray.a(paramInt1);
      if (k < 0) {
        return -1;
      }
      if (k != paramString.charAt(i)) {
        return 1;
      }
      i += 1;
      paramInt1 += 1;
    }
    if (paramInt1 == paramInt2) {
      return 0;
    }
    return 1;
  }
  
  public static void a(OutputStream paramOutputStream, ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer.hasArray())
    {
      paramOutputStream.write(paramByteBuffer.array(), paramByteBuffer.arrayOffset() + paramByteBuffer.position(), paramByteBuffer.capacity() - paramByteBuffer.position());
      return;
    }
    paramByteBuffer = paramByteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
    byte[] arrayOfByte = new byte[paramByteBuffer.capacity() - paramByteBuffer.position()];
    paramByteBuffer.get(arrayOfByte);
    paramOutputStream.write(arrayOfByte, 0, arrayOfByte.length);
  }
  
  private void a(String paramString, StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append("\"");
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      char c = paramString.charAt(i);
      if (c != '\f')
      {
        if (c != '\r')
        {
          if ((c != '"') && (c != '/') && (c != '\\')) {}
          switch (c)
          {
          default: 
            if (c <= '\037') {
              paramStringBuilder.append(String.format("\\u%04x", new Object[] { Integer.valueOf(c) }));
            } else {
              paramStringBuilder.append(c);
            }
            break;
          case '\n': 
            paramStringBuilder.append("\\n");
            break;
          case '\t': 
            paramStringBuilder.append("\\t");
            break;
          case '\b': 
            paramStringBuilder.append("\\b");
            break;
            paramStringBuilder.append('\\');
            paramStringBuilder.append(c);
            break;
          }
        }
        else
        {
          paramStringBuilder.append("\\r");
        }
      }
      else {
        paramStringBuilder.append("\\f");
      }
      i += 1;
    }
    paramStringBuilder.append("\"");
  }
  
  private void a(StringBuilder paramStringBuilder, String paramString1, String paramString2, boolean paramBoolean)
  {
    paramString1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString(paramString1, null);
    if (paramString1 != null)
    {
      paramStringBuilder.append(",");
      paramStringBuilder.append(paramString2);
      paramStringBuilder.append(":");
      if (!paramBoolean)
      {
        paramStringBuilder.append(paramString1);
        return;
      }
      a(paramString1, paramStringBuilder);
    }
  }
  
  public static boolean a(FbArray paramFbArray, String paramString)
  {
    int i = paramFbArray.a();
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    if (i != 0)
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      i = paramFbArray.a();
      if ((i == 1) && (paramFbArray.a(0) == 42)) {
        return true;
      }
      if ((i == 3) && (a(paramFbArray, 0, i, "*.*") == 0))
      {
        bool1 = bool2;
        if (paramString.indexOf('.') != -1) {
          bool1 = true;
        }
        return bool1;
      }
      if (paramFbArray.a(0) == 42)
      {
        i = b(paramFbArray, 1, i, paramString);
      }
      else
      {
        int j = i - 1;
        if (paramFbArray.a(j) == 42) {
          i = a(paramFbArray, 0, j, paramString);
        } else {
          try
          {
            if (paramString.length() == i) {
              i = a(paramFbArray, 0, i, paramString);
            } else {
              i = -101;
            }
          }
          catch (Throwable localThrowable)
          {
            QLog.e("AuthorizeConfig", 1, "isDomainMatch error ", localThrowable);
            i = -102;
          }
        }
      }
      if (i < 0) {
        return AuthorizeConfig.b(paramFbArray.a(), paramString);
      }
      bool1 = bool3;
      if (i == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static int b(FbArray paramFbArray, int paramInt1, int paramInt2, String paramString)
  {
    int i = paramString.length();
    int j = 1;
    i -= 1;
    while ((i >= 0) && (paramInt1 < paramInt2))
    {
      int k = paramFbArray.a(paramInt2 - 1);
      if (k < 0) {
        return -1;
      }
      if (k != paramString.charAt(i)) {
        return 1;
      }
      i -= 1;
      paramInt2 -= 1;
    }
    i = j;
    if (paramInt1 == paramInt2) {
      i = 0;
    }
    return i;
  }
  
  public int a(String paramString1, String paramString2)
  {
    Object localObject = a();
    if (localObject == null) {
      return a(false, true);
    }
    localObject = ((FbTable)localObject).a(0);
    if ((localObject != null) && (((FbArray)localObject).a() != 0))
    {
      FbTable localFbTable = new FbTable();
      FbArray localFbArray1 = new FbArray();
      FbArray localFbArray2 = new FbArray();
      FbArray localFbArray3 = new FbArray();
      int m = ((FbArray)localObject).a();
      int i = 0;
      while (i < m)
      {
        ((FbArray)localObject).a(i, localFbTable);
        localFbTable.a(0, localFbArray1);
        int n = localFbArray1.a();
        int j = 0;
        while (j < n)
        {
          localFbArray1.a(j, localFbArray3);
          if (a(localFbArray3, paramString1)) {
            for (;;)
            {
              localFbTable.a(1, localFbArray2);
              int i1 = localFbArray2.a();
              int k = 0;
              while (k < i1)
              {
                localFbArray2.a(k, localFbArray3);
                if (a(localFbArray3, paramString2)) {
                  return a(true, false);
                }
                k += 1;
              }
            }
          }
          j += 1;
        }
        i += 1;
      }
      return a(false, false);
    }
    return a(false, true);
  }
  
  public FbTable a()
  {
    if (!FlatBuffersParser.a()) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentBizFlatbuffersFbTable;
  }
  
  public File a()
  {
    File localFile = new File(FlatBuffersParser.a());
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return new File(localFile, "flatbuffers_authorize.bin");
  }
  
  public String a()
  {
    FbTable localFbTable = a();
    if (localFbTable == null) {
      return null;
    }
    return localFbTable.a(1);
  }
  
  public String a(SharedPreferences.Editor paramEditor, String paramString)
  {
    try
    {
      String str = a(this.jdField_a_of_type_ComTencentBizFlatbuffersFlatBuffersParser.a(paramString, "namespace com.tencent.biz.flatbuffers;\n\nattribute \"qq_map\";\n\ntable JsApi {\n\tmatch:[string];\n\tapi:[string];\n}\n\ntable Extra (qq_map) {\n}\n\ntable Schema {\n\tmatch:[string];\n\tscheme:[string];\n}\n\ntable AuthorizeTable {\n  allow:[JsApi];\n  offline:Extra;\n  ext:Extra;\n  jump:Extra;\n  schemes:[Schema];\n  publishSeq:long;\n  \n  skey:[string];\n  pskey:[string];\n  a1:[string];\n  a2:[string];\n  ptlogin2:[string];\n  pt4_token:[string];\n  schemes_map:string;\n}\n\nroot_type AuthorizeTable;\n"), true);
      if (this.jdField_a_of_type_ComTencentBizFlatbuffersFbTable == null)
      {
        QLog.i("AuthorizeConfig", 1, "flatbuffers commitConfig failed ");
        a().delete();
        paramEditor = this.jdField_a_of_type_ComTencentBizAuthorizeJsonConfig.a(paramEditor, paramString);
        return paramEditor;
      }
      long l = this.jdField_a_of_type_ComTencentBizFlatbuffersFbTable.a(5, -1L);
      paramString = new StringBuilder();
      paramString.append("flatbuffers commitConfig success with publishSeq: ");
      paramString.append(l);
      QLog.i("AuthorizeConfig", 1, paramString.toString());
      paramEditor.putLong("publishSeq", l);
      this.jdField_a_of_type_ComTencentBizAuthorizeJsonConfig.a();
      return str;
    }
    finally {}
  }
  
  public String a(ByteBuffer paramByteBuffer, boolean paramBoolean)
  {
    if (paramByteBuffer == null) {
      return null;
    }
    Object localObject3 = "";
    boolean bool = false;
    Object localObject1 = localObject3;
    for (;;)
    {
      try
      {
        try
        {
          FbTable localFbTable = FbTable.a(paramByteBuffer);
          Object localObject2;
          if (localFbTable == null)
          {
            localObject1 = localObject3;
            localObject2 = new StringBuilder();
            localObject1 = localObject3;
            ((StringBuilder)localObject2).append("");
            localObject1 = localObject3;
            ((StringBuilder)localObject2).append("error root");
            localObject1 = localObject3;
            localObject2 = ((StringBuilder)localObject2).toString();
          }
          else
          {
            localObject1 = localObject3;
            FbArray localFbArray2 = new FbArray();
            localObject1 = localObject3;
            if (localFbTable.a(0, localFbArray2) == null)
            {
              localObject1 = localObject3;
              localObject2 = new StringBuilder();
              localObject1 = localObject3;
              ((StringBuilder)localObject2).append("");
              localObject1 = localObject3;
              ((StringBuilder)localObject2).append("allow");
              localObject1 = localObject3;
              localObject2 = ((StringBuilder)localObject2).toString();
            }
            else
            {
              localObject1 = localObject3;
              if (localFbArray2.a() <= 0) {
                break label1318;
              }
              localObject1 = localObject3;
              localObject2 = localFbArray2.a(0);
              if (localObject2 == null) {
                break label1324;
              }
              localObject1 = localObject3;
              localFbArray1 = ((FbTable)localObject2).a(0);
              localObject2 = localObject3;
              if (localFbArray1 != null)
              {
                localObject2 = localObject3;
                localObject1 = localObject3;
                if (localFbArray1.a() > 0)
                {
                  localObject1 = localObject3;
                  localObject2 = new StringBuilder();
                  localObject1 = localObject3;
                  ((StringBuilder)localObject2).append("authTable first string : ");
                  localObject1 = localObject3;
                  ((StringBuilder)localObject2).append(localFbArray1.a(0));
                  localObject1 = localObject3;
                  QLog.i("AuthorizeConfig", 1, ((StringBuilder)localObject2).toString());
                  localObject2 = localObject3;
                }
              }
            }
            localObject3 = localObject2;
            localObject1 = localObject2;
            if (localFbTable.a(1) == null)
            {
              localObject1 = localObject2;
              localObject3 = new StringBuilder();
              localObject1 = localObject2;
              ((StringBuilder)localObject3).append((String)localObject2);
              localObject1 = localObject2;
              ((StringBuilder)localObject3).append("|offline");
              localObject1 = localObject2;
              localObject3 = ((StringBuilder)localObject3).toString();
            }
            localObject2 = localObject3;
            localObject1 = localObject3;
            if (localFbTable.a(2) == null)
            {
              localObject1 = localObject3;
              localObject2 = new StringBuilder();
              localObject1 = localObject3;
              ((StringBuilder)localObject2).append((String)localObject3);
              localObject1 = localObject3;
              ((StringBuilder)localObject2).append("|ext");
              localObject1 = localObject3;
              localObject2 = ((StringBuilder)localObject2).toString();
            }
            localObject3 = localObject2;
            localObject1 = localObject2;
            if (localFbTable.a(3) == null)
            {
              localObject1 = localObject2;
              localObject3 = new StringBuilder();
              localObject1 = localObject2;
              ((StringBuilder)localObject3).append((String)localObject2);
              localObject1 = localObject2;
              ((StringBuilder)localObject3).append("|jump");
              localObject1 = localObject2;
              localObject3 = ((StringBuilder)localObject3).toString();
            }
            localObject2 = localObject3;
            localObject1 = localObject3;
            if (localFbTable.a(4, localFbArray2) == null)
            {
              localObject2 = localObject3;
              localObject1 = localObject3;
              if (localFbTable.a(12) == null)
              {
                localObject1 = localObject3;
                localObject2 = new StringBuilder();
                localObject1 = localObject3;
                ((StringBuilder)localObject2).append((String)localObject3);
                localObject1 = localObject3;
                ((StringBuilder)localObject2).append("|schemes");
                localObject1 = localObject3;
                localObject2 = ((StringBuilder)localObject2).toString();
              }
            }
            localObject3 = localObject2;
            localObject1 = localObject2;
            if (localFbTable.a(6, localFbArray2) == null)
            {
              localObject1 = localObject2;
              localObject3 = new StringBuilder();
              localObject1 = localObject2;
              ((StringBuilder)localObject3).append((String)localObject2);
              localObject1 = localObject2;
              ((StringBuilder)localObject3).append("|skey");
              localObject1 = localObject2;
              localObject3 = ((StringBuilder)localObject3).toString();
            }
            localObject2 = localObject3;
            localObject1 = localObject3;
            if (localFbTable.a(7, localFbArray2) == null)
            {
              localObject1 = localObject3;
              localObject2 = new StringBuilder();
              localObject1 = localObject3;
              ((StringBuilder)localObject2).append((String)localObject3);
              localObject1 = localObject3;
              ((StringBuilder)localObject2).append("|pskey");
              localObject1 = localObject3;
              localObject2 = ((StringBuilder)localObject2).toString();
            }
            localObject3 = localObject2;
            localObject1 = localObject2;
            if (localFbTable.a(8, localFbArray2) == null)
            {
              localObject1 = localObject2;
              localObject3 = new StringBuilder();
              localObject1 = localObject2;
              ((StringBuilder)localObject3).append((String)localObject2);
              localObject1 = localObject2;
              ((StringBuilder)localObject3).append("|a1");
              localObject1 = localObject2;
              localObject3 = ((StringBuilder)localObject3).toString();
            }
            localObject2 = localObject3;
            localObject1 = localObject3;
            if (localFbTable.a(9, localFbArray2) == null)
            {
              localObject1 = localObject3;
              localObject2 = new StringBuilder();
              localObject1 = localObject3;
              ((StringBuilder)localObject2).append((String)localObject3);
              localObject1 = localObject3;
              ((StringBuilder)localObject2).append("|a2");
              localObject1 = localObject3;
              localObject2 = ((StringBuilder)localObject2).toString();
            }
            localObject3 = localObject2;
            localObject1 = localObject2;
            if (localFbTable.a(10, localFbArray2) == null)
            {
              localObject1 = localObject2;
              localObject3 = new StringBuilder();
              localObject1 = localObject2;
              ((StringBuilder)localObject3).append((String)localObject2);
              localObject1 = localObject2;
              ((StringBuilder)localObject3).append("|ptlogin2");
              localObject1 = localObject2;
              localObject3 = ((StringBuilder)localObject3).toString();
            }
            localObject2 = localObject3;
            localObject1 = localObject3;
            if (localFbTable.a(11, localFbArray2) == null)
            {
              localObject1 = localObject3;
              localObject2 = new StringBuilder();
              localObject1 = localObject3;
              ((StringBuilder)localObject2).append((String)localObject3);
              localObject1 = localObject3;
              ((StringBuilder)localObject2).append("|pt4_token");
              localObject1 = localObject3;
              localObject2 = ((StringBuilder)localObject2).toString();
            }
            localObject1 = localObject2;
            this.jdField_a_of_type_ComTencentBizFlatbuffersFbTable = localFbTable;
            localObject1 = localObject2;
            long l = localFbTable.a(5, -1L);
            localObject1 = localObject2;
            localObject3 = new StringBuilder();
            localObject1 = localObject2;
            ((StringBuilder)localObject3).append("flatbuffers is correct with length: ");
            localObject1 = localObject2;
            ((StringBuilder)localObject3).append(paramByteBuffer.capacity());
            localObject1 = localObject2;
            ((StringBuilder)localObject3).append(" publishSeq ");
            localObject1 = localObject2;
            ((StringBuilder)localObject3).append(l);
            localObject1 = localObject2;
            QLog.i("AuthorizeConfig", 1, ((StringBuilder)localObject3).toString());
          }
        }
        catch (Throwable localThrowable)
        {
          QLog.e("AuthorizeConfig", 1, "flatbuffers", localThrowable);
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append((String)localObject1);
          ((StringBuilder)localObject3).append(localThrowable.getMessage());
          str = ((StringBuilder)localObject3).toString();
        }
        if ((TextUtils.isEmpty(str)) && (this.jdField_a_of_type_ComTencentBizFlatbuffersFbTable != null))
        {
          if (!paramBoolean) {
            break label1330;
          }
          localObject1 = a();
          paramBoolean = true;
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("flatbuffers has failedList: ");
          ((StringBuilder)localObject1).append(str);
          QLog.e("AuthorizeConfig", 1, ((StringBuilder)localObject1).toString());
          FlatBuffersParser.b(true);
          localObject1 = b();
          if (paramBoolean) {
            break label1338;
          }
          paramBoolean = a().delete();
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("authFile is broken, delete return : ");
          ((StringBuilder)localObject3).append(paramBoolean);
          QLog.e("AuthorizeConfig", 1, ((StringBuilder)localObject3).toString());
          break label1338;
        }
        if (localObject1 != null) {
          ThreadManager.post(new FlatBuffersConfig.2(this, paramByteBuffer, (File)localObject1, paramBoolean), 8, null, true);
        }
        return str;
      }
      finally {}
      label1318:
      String str = null;
      continue;
      label1324:
      FbArray localFbArray1 = null;
      continue;
      label1330:
      localObject1 = null;
      paramBoolean = bool;
      continue;
      label1338:
      paramBoolean = bool;
    }
  }
  
  public JSONArray a(String paramString)
  {
    Object localObject = a();
    if (localObject == null) {
      return null;
    }
    paramString = ((FbTable)localObject).a(((Integer)jdField_a_of_type_JavaUtilHashMap.get(paramString)).intValue());
    if (paramString == null) {
      return null;
    }
    localObject = new JSONArray();
    int i = 0;
    int j = paramString.a();
    while (i < j)
    {
      String str = paramString.a(i);
      if (str != null) {
        ((JSONArray)localObject).put(str);
      }
      i += 1;
    }
    return localObject;
  }
  
  public JSONObject a()
  {
    Object localObject1 = a();
    if (localObject1 == null) {
      return null;
    }
    Object localObject2 = ((FbTable)localObject1).a(12);
    if (localObject2 != null) {
      return new JSONObject((String)localObject2);
    }
    localObject1 = ((FbTable)localObject1).a(4);
    if (localObject1 == null) {
      return null;
    }
    localObject2 = new JSONObject();
    FbTable localFbTable = new FbTable();
    FbArray localFbArray1 = new FbArray();
    FbArray localFbArray2 = new FbArray();
    int k = ((FbArray)localObject1).a();
    int i = 0;
    while (i < k)
    {
      ((FbArray)localObject1).a(i, localFbTable);
      localFbTable.a(0, localFbArray1);
      localFbTable.a(1, localFbArray2);
      JSONArray localJSONArray = new JSONArray();
      int m = localFbArray2.a();
      int j = 0;
      String str;
      while (j < m)
      {
        str = localFbArray2.a(j);
        if (str != null) {
          localJSONArray.put(str);
        }
        j += 1;
      }
      m = localFbArray1.a();
      j = 0;
      while (j < m)
      {
        str = localFbArray1.a(j);
        if (str != null) {
          ((JSONObject)localObject2).put(str, localJSONArray);
        }
        j += 1;
      }
      i += 1;
    }
    return localObject2;
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 227	com/tencent/biz/flatbuffers/FlatBuffersParser:a	()Z
    //   5: istore_2
    //   6: iload_2
    //   7: ifne +6 -> 13
    //   10: aload_0
    //   11: monitorexit
    //   12: return
    //   13: aload_0
    //   14: invokevirtual 267	com/tencent/biz/authorize/FlatBuffersConfig:a	()Ljava/io/File;
    //   17: astore 11
    //   19: aload 11
    //   21: invokevirtual 239	java/io/File:exists	()Z
    //   24: ifeq +383 -> 407
    //   27: aload 11
    //   29: invokevirtual 396	java/io/File:length	()J
    //   32: lconst_0
    //   33: lcmp
    //   34: ifne +6 -> 40
    //   37: goto +370 -> 407
    //   40: aload 11
    //   42: invokevirtual 399	java/io/File:lastModified	()J
    //   45: lstore_3
    //   46: new 121	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   53: astore 7
    //   55: aload 7
    //   57: ldc_w 401
    //   60: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload 7
    //   66: aload_0
    //   67: getfield 51	com/tencent/biz/authorize/FlatBuffersConfig:jdField_a_of_type_Long	J
    //   70: invokevirtual 285	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload 7
    //   76: ldc_w 403
    //   79: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: aload 7
    //   85: lload_3
    //   86: invokevirtual 285	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: ldc 186
    //   92: iconst_1
    //   93: aload 7
    //   95: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokestatic 265	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   101: aload_0
    //   102: getfield 229	com/tencent/biz/authorize/FlatBuffersConfig:jdField_a_of_type_ComTencentBizFlatbuffersFbTable	Lcom/tencent/biz/flatbuffers/FbTable;
    //   105: ifnull +19 -> 124
    //   108: aload_0
    //   109: getfield 51	com/tencent/biz/authorize/FlatBuffersConfig:jdField_a_of_type_Long	J
    //   112: lstore 5
    //   114: lload 5
    //   116: lload_3
    //   117: lcmp
    //   118: ifne +6 -> 124
    //   121: aload_0
    //   122: monitorexit
    //   123: return
    //   124: aload_0
    //   125: lload_3
    //   126: putfield 51	com/tencent/biz/authorize/FlatBuffersConfig:jdField_a_of_type_Long	J
    //   129: aconst_null
    //   130: astore 9
    //   132: aconst_null
    //   133: astore 8
    //   135: aload 8
    //   137: astore 7
    //   139: aload 11
    //   141: invokevirtual 396	java/io/File:length	()J
    //   144: l2i
    //   145: newarray byte
    //   147: astore 10
    //   149: aload 8
    //   151: astore 7
    //   153: new 405	java/io/FileInputStream
    //   156: dup
    //   157: aload 11
    //   159: invokespecial 408	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   162: astore 8
    //   164: aload 8
    //   166: aload 10
    //   168: invokevirtual 412	java/io/FileInputStream:read	([B)I
    //   171: istore_1
    //   172: iload_1
    //   173: aload 10
    //   175: arraylength
    //   176: if_icmpeq +81 -> 257
    //   179: new 121	java/lang/StringBuilder
    //   182: dup
    //   183: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   186: astore 7
    //   188: aload 7
    //   190: ldc_w 414
    //   193: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: aload 7
    //   199: iload_1
    //   200: invokevirtual 338	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: aload 7
    //   206: ldc_w 416
    //   209: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: pop
    //   213: aload 7
    //   215: aload 10
    //   217: arraylength
    //   218: invokevirtual 338	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   221: pop
    //   222: ldc 186
    //   224: iconst_1
    //   225: aload 7
    //   227: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: invokestatic 349	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   233: aload 8
    //   235: invokevirtual 419	java/io/FileInputStream:close	()V
    //   238: goto +16 -> 254
    //   241: astore 7
    //   243: ldc 186
    //   245: iconst_1
    //   246: ldc_w 342
    //   249: aload 7
    //   251: invokestatic 194	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   254: aload_0
    //   255: monitorexit
    //   256: return
    //   257: aload 8
    //   259: invokevirtual 419	java/io/FileInputStream:close	()V
    //   262: goto +16 -> 278
    //   265: astore 7
    //   267: ldc 186
    //   269: iconst_1
    //   270: ldc_w 342
    //   273: aload 7
    //   275: invokestatic 194	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   278: aload_0
    //   279: aload 10
    //   281: invokestatic 422	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   284: iconst_0
    //   285: invokevirtual 259	com/tencent/biz/authorize/FlatBuffersConfig:a	(Ljava/nio/ByteBuffer;Z)Ljava/lang/String;
    //   288: pop
    //   289: ldc 186
    //   291: iconst_1
    //   292: ldc_w 424
    //   295: invokestatic 265	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   298: aload_0
    //   299: monitorexit
    //   300: return
    //   301: astore 7
    //   303: goto +75 -> 378
    //   306: astore 9
    //   308: goto +26 -> 334
    //   311: astore 9
    //   313: aload 7
    //   315: astore 8
    //   317: aload 9
    //   319: astore 7
    //   321: goto +57 -> 378
    //   324: astore 7
    //   326: aload 9
    //   328: astore 8
    //   330: aload 7
    //   332: astore 9
    //   334: aload 8
    //   336: astore 7
    //   338: ldc 186
    //   340: iconst_1
    //   341: ldc_w 342
    //   344: aload 9
    //   346: invokestatic 194	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   349: aload 8
    //   351: ifnull +24 -> 375
    //   354: aload 8
    //   356: invokevirtual 419	java/io/FileInputStream:close	()V
    //   359: goto +16 -> 375
    //   362: astore 7
    //   364: ldc 186
    //   366: iconst_1
    //   367: ldc_w 342
    //   370: aload 7
    //   372: invokestatic 194	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   375: aload_0
    //   376: monitorexit
    //   377: return
    //   378: aload 8
    //   380: ifnull +24 -> 404
    //   383: aload 8
    //   385: invokevirtual 419	java/io/FileInputStream:close	()V
    //   388: goto +16 -> 404
    //   391: astore 8
    //   393: ldc 186
    //   395: iconst_1
    //   396: ldc_w 342
    //   399: aload 8
    //   401: invokestatic 194	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   404: aload 7
    //   406: athrow
    //   407: aload_0
    //   408: monitorexit
    //   409: return
    //   410: astore 7
    //   412: aload_0
    //   413: monitorexit
    //   414: aload 7
    //   416: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	417	0	this	FlatBuffersConfig
    //   171	29	1	i	int
    //   5	2	2	bool	boolean
    //   45	81	3	l1	long
    //   112	3	5	l2	long
    //   53	173	7	localObject1	Object
    //   241	9	7	localIOException1	java.io.IOException
    //   265	9	7	localIOException2	java.io.IOException
    //   301	13	7	localObject2	Object
    //   319	1	7	localObject3	Object
    //   324	7	7	localThrowable1	Throwable
    //   336	1	7	localObject4	Object
    //   362	43	7	localIOException3	java.io.IOException
    //   410	5	7	localObject5	Object
    //   133	251	8	localObject6	Object
    //   391	9	8	localIOException4	java.io.IOException
    //   130	1	9	localObject7	Object
    //   306	1	9	localThrowable2	Throwable
    //   311	16	9	localObject8	Object
    //   332	13	9	localThrowable3	Throwable
    //   147	133	10	arrayOfByte	byte[]
    //   17	141	11	localFile	File
    // Exception table:
    //   from	to	target	type
    //   233	238	241	java/io/IOException
    //   257	262	265	java/io/IOException
    //   164	233	301	finally
    //   164	233	306	java/lang/Throwable
    //   139	149	311	finally
    //   153	164	311	finally
    //   338	349	311	finally
    //   139	149	324	java/lang/Throwable
    //   153	164	324	java/lang/Throwable
    //   354	359	362	java/io/IOException
    //   383	388	391	java/io/IOException
    //   2	6	410	finally
    //   13	37	410	finally
    //   40	114	410	finally
    //   124	129	410	finally
    //   233	238	410	finally
    //   243	254	410	finally
    //   257	262	410	finally
    //   267	278	410	finally
    //   278	298	410	finally
    //   354	359	410	finally
    //   364	375	410	finally
    //   383	388	410	finally
    //   393	404	410	finally
    //   404	407	410	finally
  }
  
  public void a(JsonConfig paramJsonConfig)
  {
    this.jdField_a_of_type_ComTencentBizAuthorizeJsonConfig = paramJsonConfig;
  }
  
  public boolean a()
  {
    return (FlatBuffersParser.a()) && (this.jdField_a_of_type_ComTencentBizFlatbuffersFbTable != null);
  }
  
  /* Error */
  public boolean a(ByteBuffer paramByteBuffer, File paramFile, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 121	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   7: astore 5
    //   9: aload 5
    //   11: aload_2
    //   12: invokevirtual 429	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   15: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: pop
    //   19: aload 5
    //   21: invokestatic 434	java/lang/System:nanoTime	()J
    //   24: invokevirtual 285	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: new 232	java/io/File
    //   31: dup
    //   32: aload 5
    //   34: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokespecial 236	java/io/File:<init>	(Ljava/lang/String;)V
    //   40: astore 8
    //   42: aconst_null
    //   43: astore 7
    //   45: aconst_null
    //   46: astore 6
    //   48: aload 6
    //   50: astore 5
    //   52: aload 8
    //   54: invokevirtual 437	java/io/File:createNewFile	()Z
    //   57: ifne +69 -> 126
    //   60: aload 6
    //   62: astore 5
    //   64: new 121	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   71: astore_1
    //   72: aload 6
    //   74: astore 5
    //   76: aload_1
    //   77: ldc_w 439
    //   80: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload 6
    //   86: astore 5
    //   88: aload_1
    //   89: aload 8
    //   91: invokevirtual 429	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   94: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: pop
    //   98: aload 6
    //   100: astore 5
    //   102: aload_1
    //   103: ldc_w 441
    //   106: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload 6
    //   112: astore 5
    //   114: ldc 186
    //   116: iconst_1
    //   117: aload_1
    //   118: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: invokestatic 349	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   124: iconst_0
    //   125: ireturn
    //   126: aload 6
    //   128: astore 5
    //   130: new 121	java/lang/StringBuilder
    //   133: dup
    //   134: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   137: astore 9
    //   139: aload 6
    //   141: astore 5
    //   143: aload 9
    //   145: ldc_w 443
    //   148: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: aload 6
    //   154: astore 5
    //   156: aload 9
    //   158: aload_2
    //   159: invokevirtual 446	java/io/File:getName	()Ljava/lang/String;
    //   162: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: pop
    //   166: aload 6
    //   168: astore 5
    //   170: ldc 186
    //   172: iconst_1
    //   173: aload 9
    //   175: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokestatic 265	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   181: aload 6
    //   183: astore 5
    //   185: new 448	java/io/FileOutputStream
    //   188: dup
    //   189: aload 8
    //   191: invokespecial 449	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   194: astore 6
    //   196: aload 6
    //   198: aload_1
    //   199: invokestatic 451	com/tencent/biz/authorize/FlatBuffersConfig:a	(Ljava/io/OutputStream;Ljava/nio/ByteBuffer;)V
    //   202: ldc 186
    //   204: iconst_1
    //   205: ldc_w 453
    //   208: invokestatic 265	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   211: aload 6
    //   213: invokevirtual 454	java/io/FileOutputStream:close	()V
    //   216: goto +14 -> 230
    //   219: astore_1
    //   220: ldc 186
    //   222: iconst_1
    //   223: ldc_w 456
    //   226: aload_1
    //   227: invokestatic 194	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   230: aload_2
    //   231: invokevirtual 239	java/io/File:exists	()Z
    //   234: ifeq +45 -> 279
    //   237: aload_2
    //   238: invokevirtual 270	java/io/File:delete	()Z
    //   241: istore 4
    //   243: new 121	java/lang/StringBuilder
    //   246: dup
    //   247: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   250: astore_1
    //   251: aload_1
    //   252: ldc_w 458
    //   255: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: pop
    //   259: aload_1
    //   260: iload 4
    //   262: invokevirtual 359	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   265: pop
    //   266: ldc 186
    //   268: iconst_1
    //   269: aload_1
    //   270: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   273: invokestatic 265	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   276: goto +6 -> 282
    //   279: iconst_1
    //   280: istore 4
    //   282: iload 4
    //   284: ifeq +142 -> 426
    //   287: aload 8
    //   289: aload_2
    //   290: invokevirtual 462	java/io/File:renameTo	(Ljava/io/File;)Z
    //   293: istore 4
    //   295: new 121	java/lang/StringBuilder
    //   298: dup
    //   299: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   302: astore_1
    //   303: aload_1
    //   304: ldc_w 464
    //   307: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: pop
    //   311: aload_1
    //   312: iload 4
    //   314: invokevirtual 359	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   317: pop
    //   318: ldc 186
    //   320: iconst_1
    //   321: aload_1
    //   322: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   325: invokestatic 265	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   328: iload 4
    //   330: ifeq +93 -> 423
    //   333: iload_3
    //   334: ifeq +89 -> 423
    //   337: aload_0
    //   338: aload_2
    //   339: invokevirtual 399	java/io/File:lastModified	()J
    //   342: putfield 51	com/tencent/biz/authorize/FlatBuffersConfig:jdField_a_of_type_Long	J
    //   345: new 121	java/lang/StringBuilder
    //   348: dup
    //   349: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   352: astore_1
    //   353: aload_1
    //   354: ldc_w 401
    //   357: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: pop
    //   361: aload_1
    //   362: aload_0
    //   363: getfield 51	com/tencent/biz/authorize/FlatBuffersConfig:jdField_a_of_type_Long	J
    //   366: invokevirtual 285	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   369: pop
    //   370: ldc 186
    //   372: iconst_1
    //   373: aload_1
    //   374: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   377: invokestatic 265	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   380: aload_0
    //   381: getfield 150	com/tencent/biz/authorize/FlatBuffersConfig:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   384: invokeinterface 468 1 0
    //   389: astore_1
    //   390: aload_1
    //   391: ldc_w 470
    //   394: ldc_w 300
    //   397: invokeinterface 474 3 0
    //   402: pop
    //   403: aload_1
    //   404: ldc_w 476
    //   407: ldc_w 300
    //   410: invokeinterface 474 3 0
    //   415: pop
    //   416: aload_1
    //   417: invokeinterface 479 1 0
    //   422: pop
    //   423: iload 4
    //   425: ireturn
    //   426: aload 8
    //   428: invokevirtual 270	java/io/File:delete	()Z
    //   431: pop
    //   432: iconst_0
    //   433: ireturn
    //   434: astore_1
    //   435: aload 6
    //   437: astore 5
    //   439: goto +61 -> 500
    //   442: astore_2
    //   443: aload 6
    //   445: astore_1
    //   446: goto +11 -> 457
    //   449: astore_1
    //   450: goto +50 -> 500
    //   453: astore_2
    //   454: aload 7
    //   456: astore_1
    //   457: aload_1
    //   458: astore 5
    //   460: ldc 186
    //   462: iconst_1
    //   463: ldc_w 481
    //   466: aload_2
    //   467: invokestatic 194	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   470: aload_1
    //   471: ifnull +21 -> 492
    //   474: aload_1
    //   475: invokevirtual 454	java/io/FileOutputStream:close	()V
    //   478: goto +14 -> 492
    //   481: astore_1
    //   482: ldc 186
    //   484: iconst_1
    //   485: ldc_w 456
    //   488: aload_1
    //   489: invokestatic 194	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   492: aload 8
    //   494: invokevirtual 270	java/io/File:delete	()Z
    //   497: pop
    //   498: iconst_0
    //   499: ireturn
    //   500: aload 5
    //   502: ifnull +22 -> 524
    //   505: aload 5
    //   507: invokevirtual 454	java/io/FileOutputStream:close	()V
    //   510: goto +14 -> 524
    //   513: astore_2
    //   514: ldc 186
    //   516: iconst_1
    //   517: ldc_w 456
    //   520: aload_2
    //   521: invokestatic 194	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   524: aload_1
    //   525: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	526	0	this	FlatBuffersConfig
    //   0	526	1	paramByteBuffer	ByteBuffer
    //   0	526	2	paramFile	File
    //   0	526	3	paramBoolean	boolean
    //   241	183	4	bool	boolean
    //   7	499	5	localObject1	Object
    //   46	398	6	localFileOutputStream	java.io.FileOutputStream
    //   43	412	7	localObject2	Object
    //   40	453	8	localFile	File
    //   137	37	9	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   211	216	219	java/io/IOException
    //   196	211	434	finally
    //   196	211	442	java/io/IOException
    //   52	60	449	finally
    //   64	72	449	finally
    //   76	84	449	finally
    //   88	98	449	finally
    //   102	110	449	finally
    //   114	124	449	finally
    //   130	139	449	finally
    //   143	152	449	finally
    //   156	166	449	finally
    //   170	181	449	finally
    //   185	196	449	finally
    //   460	470	449	finally
    //   52	60	453	java/io/IOException
    //   64	72	453	java/io/IOException
    //   76	84	453	java/io/IOException
    //   88	98	453	java/io/IOException
    //   102	110	453	java/io/IOException
    //   114	124	453	java/io/IOException
    //   130	139	453	java/io/IOException
    //   143	152	453	java/io/IOException
    //   156	166	453	java/io/IOException
    //   170	181	453	java/io/IOException
    //   185	196	453	java/io/IOException
    //   474	478	481	java/io/IOException
    //   505	510	513	java/io/IOException
  }
  
  public File b()
  {
    File localFile = new File(FlatBuffersParser.a());
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return new File(localFile, "err_authorize.bin");
  }
  
  public String b()
  {
    FbTable localFbTable = a();
    if (localFbTable == null) {
      return null;
    }
    return localFbTable.a(2);
  }
  
  public void b()
  {
    if (FlatBuffersParser.a())
    {
      if (this.jdField_a_of_type_ComTencentBizFlatbuffersFbTable != null) {
        return;
      }
      ThreadManager.post(new FlatBuffersConfig.1(this), 8, null, true);
    }
  }
  
  public String c()
  {
    FbTable localFbTable = a();
    if (localFbTable == null) {
      return null;
    }
    return localFbTable.a(3);
  }
  
  public void c()
  {
    try
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentBizFlatbuffersFbTable;
      if (localObject1 != null) {
        return;
      }
      Object localObject3 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("cmd_config_new", null);
      if (localObject3 == null) {
        return;
      }
      try
      {
        localObject1 = new StringBuilder(((String)localObject3).length() + 10240);
        ((StringBuilder)localObject1).append("{");
        ((StringBuilder)localObject1).append("allow:");
        ((StringBuilder)localObject1).append((String)localObject3);
        a((StringBuilder)localObject1, "offlineHtml", "offline", false);
        a((StringBuilder)localObject1, "extra", "ext", false);
        a((StringBuilder)localObject1, "jump", "jump", false);
        a((StringBuilder)localObject1, "schemes", "schemes_map", true);
        localObject3 = AuthorizeConfig.a;
        int j = localObject3.length;
        int i = 0;
        while (i < j)
        {
          String str = localObject3[i];
          a((StringBuilder)localObject1, str, str, false);
          i += 1;
        }
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(",publishSeq:");
        ((StringBuilder)localObject3).append(this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("publishSeq", -1L));
        ((StringBuilder)localObject1).append(((StringBuilder)localObject3).toString());
        ((StringBuilder)localObject1).append("}");
        a(this.jdField_a_of_type_ComTencentBizFlatbuffersFlatBuffersParser.a(((StringBuilder)localObject1).toString(), "namespace com.tencent.biz.flatbuffers;\n\nattribute \"qq_map\";\n\ntable JsApi {\n\tmatch:[string];\n\tapi:[string];\n}\n\ntable Extra (qq_map) {\n}\n\ntable Schema {\n\tmatch:[string];\n\tscheme:[string];\n}\n\ntable AuthorizeTable {\n  allow:[JsApi];\n  offline:Extra;\n  ext:Extra;\n  jump:Extra;\n  schemes:[Schema];\n  publishSeq:long;\n  \n  skey:[string];\n  pskey:[string];\n  a1:[string];\n  a2:[string];\n  ptlogin2:[string];\n  pt4_token:[string];\n  schemes_map:string;\n}\n\nroot_type AuthorizeTable;\n"), true);
        if (this.jdField_a_of_type_ComTencentBizFlatbuffersFbTable != null)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("flatbuffers convertJson2FlatBuffers success with publishSeq: ");
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("publishSeq", -1L));
          QLog.i("AuthorizeConfig", 1, ((StringBuilder)localObject1).toString());
          this.jdField_a_of_type_ComTencentBizAuthorizeJsonConfig.a();
        }
        else
        {
          QLog.i("AuthorizeConfig", 1, "flatbuffers convertJson2FlatBuffers failed");
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("AuthorizeConfig", 1, "convertJson2FlatBuffers error!", localThrowable);
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.authorize.FlatBuffersConfig
 * JD-Core Version:    0.7.0.1
 */