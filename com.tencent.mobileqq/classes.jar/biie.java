import android.content.Context;
import android.text.TextUtils;
import com.tencent.ims.intchk.AppInfo;
import com.tencent.ims.intchk.CheckItem;
import com.tencent.ims.intchk.CheckResult;
import com.tencent.ims.intchk.FetchCheckConfigReq;
import com.tencent.ims.intchk.FetchCheckConfigRsp;
import com.tencent.ims.intchk.ReportCheckResultReq;
import com.tencent.ims.intchk.ReportCheckResultRsp;
import com.tencent.ims.intchk.ReportStrikeResultReq;
import com.tencent.ims.intchk.ReqBody;
import com.tencent.ims.intchk.RspBody;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mqp.app.sec.MQPSecUtil;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class biie
  implements biia, biic
{
  private static int jdField_a_of_type_Int = 1;
  private biib jdField_a_of_type_Biib;
  private String jdField_a_of_type_JavaLangString;
  private Map<Integer, biif> jdField_a_of_type_JavaUtilMap;
  private int b;
  private int c = 65535;
  private int d = 0;
  
  public biie(biib parambiib)
  {
    bihy localbihy = parambiib.jdField_a_of_type_Bihy;
    if (localbihy != null) {
      localbihy.setNetTransportEventListener("intchk", this);
    }
    this.jdField_a_of_type_Biib = parambiib;
  }
  
  private intchk.AppInfo a()
  {
    intchk.AppInfo localAppInfo = new intchk.AppInfo();
    localAppInfo.uint32_platform_type.set(1);
    String str = this.jdField_a_of_type_Biib.jdField_a_of_type_AndroidContentContext.getPackageName();
    localAppInfo.bytes_package_name.set(ByteStringMicro.copyFromUtf8(str));
    int i;
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      str = "1.0";
      localAppInfo.bytes_app_version.set(ByteStringMicro.copyFromUtf8(str));
      localAppInfo.uint32_intchk_module_version.set(jdField_a_of_type_Int);
      switch (biii.a(this.jdField_a_of_type_Biib.jdField_a_of_type_AndroidContentContext))
      {
      default: 
        i = 5;
      }
    }
    for (;;)
    {
      str = biii.a(this.jdField_a_of_type_Biib.jdField_a_of_type_AndroidContentContext);
      int j = i;
      if (str != null)
      {
        j = i;
        if (str.contains("wap")) {
          j = 4;
        }
      }
      localAppInfo.uint32_net_type.set(j);
      return localAppInfo;
      str = this.jdField_a_of_type_JavaLangString;
      break;
      i = 3;
      continue;
      i = 5;
      continue;
      i = 6;
      continue;
      i = 7;
    }
  }
  
  private void a(intchk.RspBody paramRspBody)
  {
    if (paramRspBody.uint32_result.has()) {}
    for (int i = paramRspBody.uint32_result.get();; i = 2)
    {
      if (i != 1) {
        break label23;
      }
      for (;;)
      {
        label23:
        return;
        label417:
        label430:
        if (paramRspBody.msg_check_config_rsp.has())
        {
          paramRspBody = (intchk.FetchCheckConfigRsp)paramRspBody.msg_check_config_rsp.get();
          if (paramRspBody.uint32_need_intchk.has()) {}
          for (i = paramRspBody.uint32_need_intchk.get();; i = 2)
          {
            if ((i != 1) || (!paramRspBody.rpt_msg_check_item.has())) {
              break label430;
            }
            if (paramRspBody.uint32_intchk_id.has()) {}
            for (i = paramRspBody.uint32_intchk_id.get();; i = 0)
            {
              Object localObject2 = new intchk.ReportCheckResultReq();
              ((intchk.ReportCheckResultReq)localObject2).uint32_intchk_id.set(i);
              Object localObject3 = paramRspBody.rpt_msg_check_item.get();
              i = 0;
              if (i < ((List)localObject3).size())
              {
                paramRspBody = (intchk.CheckItem)((List)localObject3).get(i);
                if (!paramRspBody.uint32_check_item_id.has()) {
                  break label417;
                }
              }
              for (int j = paramRspBody.uint32_check_item_id.get();; j = 0)
              {
                if (paramRspBody.uint32_check_type.has()) {}
                for (int k = paramRspBody.uint32_check_type.get();; k = 1)
                {
                  intchk.CheckResult localCheckResult = new intchk.CheckResult();
                  localCheckResult.uint32_check_item_id.set(j);
                  localCheckResult.uint32_check_type.set(k);
                  switch (k)
                  {
                  }
                  for (;;)
                  {
                    ((intchk.ReportCheckResultReq)localObject2).rpt_msg_check_result.add(localCheckResult);
                    i += 1;
                    break;
                    if (a(paramRspBody)) {}
                    for (j = 1;; j = 2)
                    {
                      localCheckResult.uint32_memchk_result.set(j);
                      break;
                    }
                    localObject1 = bgmj.a(a(paramRspBody));
                    paramRspBody = (intchk.RspBody)localObject1;
                    if (localObject1 == null) {
                      paramRspBody = "";
                    }
                    localCheckResult.bytes_memreport_result.set(ByteStringMicro.copyFromUtf8(paramRspBody));
                  }
                  paramRspBody = new intchk.ReqBody();
                  paramRspBody.uint32_subcmd.set(2);
                  paramRspBody.msg_app_info.set(a());
                  paramRspBody.msg_report_check_result_req.set((MessageMicro)localObject2);
                  localObject2 = this.jdField_a_of_type_Biib.jdField_a_of_type_Bihy;
                  if (localObject2 == null) {
                    break;
                  }
                  Object localObject1 = paramRspBody.toByteArray();
                  localObject3 = ((bihy)localObject2).getCodec("intchk");
                  paramRspBody = (intchk.RspBody)localObject1;
                  if (localObject3 != null) {
                    paramRspBody = ((bihz)localObject3).encode(localObject1);
                  }
                  ((bihy)localObject2).send(paramRspBody);
                  return;
                }
              }
            }
          }
        }
      }
    }
  }
  
  private boolean a(intchk.CheckItem paramCheckItem)
  {
    if (paramCheckItem.uint32_start_offset.has()) {}
    for (int i = paramCheckItem.uint32_start_offset.get();; i = 0)
    {
      if (paramCheckItem.uint32_end_offset.has()) {}
      for (int j = paramCheckItem.uint32_end_offset.get();; j = 0)
      {
        if (j <= i) {}
        String str1;
        String str2;
        do
        {
          do
          {
            return false;
            str1 = "";
            if (paramCheckItem.bytes_module_name.has()) {
              str1 = paramCheckItem.bytes_module_name.get().toStringUtf8();
            }
          } while (TextUtils.isEmpty(str1.trim()));
          str2 = "";
          if (paramCheckItem.bytes_match_pattern.has()) {
            str2 = paramCheckItem.bytes_match_pattern.get().toStringUtf8();
          }
        } while (TextUtils.isEmpty(str2.trim()));
        try
        {
          boolean bool = MQPSecUtil.memchk(str1, i, j, bgmj.a(str2));
          return bool;
        }
        catch (Throwable paramCheckItem)
        {
          paramCheckItem.printStackTrace();
          return false;
        }
      }
    }
  }
  
  private byte[] a(intchk.CheckItem paramCheckItem)
  {
    if (paramCheckItem.uint32_start_offset.has()) {}
    for (int i = paramCheckItem.uint32_start_offset.get();; i = 0)
    {
      if (paramCheckItem.uint32_end_offset.has()) {}
      for (int j = paramCheckItem.uint32_end_offset.get();; j = 0)
      {
        if (j <= i) {}
        String str;
        do
        {
          return null;
          str = "";
          if (paramCheckItem.bytes_module_name.has()) {
            str = paramCheckItem.bytes_module_name.get().toStringUtf8();
          }
        } while (TextUtils.isEmpty(str.trim()));
        try
        {
          paramCheckItem = MQPSecUtil.memreport(str, i, j);
          return paramCheckItem;
        }
        catch (Throwable paramCheckItem)
        {
          for (;;)
          {
            paramCheckItem.printStackTrace();
            paramCheckItem = null;
          }
        }
      }
    }
  }
  
  private void b(intchk.RspBody paramRspBody)
  {
    int j = 2;
    if (paramRspBody.uint32_result.has()) {}
    for (int i = paramRspBody.uint32_result.get();; i = 2)
    {
      if (i != 1) {}
      do
      {
        do
        {
          return;
        } while (!paramRspBody.msg_report_check_result_rsp.has());
        paramRspBody = (intchk.ReportCheckResultRsp)paramRspBody.msg_report_check_result_rsp.get();
        i = j;
        if (paramRspBody.uint32_need_strike.has()) {
          i = paramRspBody.uint32_need_strike.get();
        }
      } while ((i != 1) || (!paramRspBody.bytes_strike_config.has()));
      if (paramRspBody.uint32_intchk_id.has()) {
        this.b = paramRspBody.uint32_intchk_id.get();
      }
      c(paramRspBody.bytes_strike_config.get().toStringUtf8());
      return;
    }
  }
  
  /* Error */
  private void c(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_1
    //   3: invokevirtual 267	java/lang/String:trim	()Ljava/lang/String;
    //   6: invokestatic 92	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifeq +4 -> 13
    //   12: return
    //   13: invokestatic 314	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   16: astore_3
    //   17: aload_3
    //   18: invokevirtual 318	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   21: new 320	java/io/ByteArrayInputStream
    //   24: dup
    //   25: aload_1
    //   26: invokevirtual 323	java/lang/String:getBytes	()[B
    //   29: invokespecial 326	java/io/ByteArrayInputStream:<init>	([B)V
    //   32: invokevirtual 332	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   35: invokeinterface 338 1 0
    //   40: astore_3
    //   41: aload_0
    //   42: iconst_0
    //   43: putfield 29	biie:c	I
    //   46: aload_3
    //   47: ldc_w 340
    //   50: invokeinterface 346 2 0
    //   55: astore_1
    //   56: aload_1
    //   57: invokevirtual 267	java/lang/String:trim	()Ljava/lang/String;
    //   60: invokevirtual 349	java/lang/String:length	()I
    //   63: ifle +11 -> 74
    //   66: aload_0
    //   67: aload_1
    //   68: invokestatic 355	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   71: putfield 29	biie:c	I
    //   74: aload_0
    //   75: getfield 29	biie:c	I
    //   78: tableswitch	default:+345 -> 423, 1:+26->104, 2:+161->239, 3:+216->294
    //   105: getfield 357	biie:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   108: ifnull -96 -> 12
    //   111: aload_0
    //   112: getfield 357	biie:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   115: iconst_1
    //   116: invokestatic 361	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   119: invokeinterface 367 2 0
    //   124: ifeq +294 -> 418
    //   127: aload_0
    //   128: getfield 357	biie:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   131: iconst_1
    //   132: invokestatic 361	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   135: invokeinterface 369 2 0
    //   140: checkcast 371	biif
    //   143: astore_1
    //   144: aload_1
    //   145: ifnull -133 -> 12
    //   148: new 373	javax/xml/transform/dom/DOMSource
    //   151: dup
    //   152: aload_3
    //   153: invokespecial 376	javax/xml/transform/dom/DOMSource:<init>	(Lorg/w3c/dom/Node;)V
    //   156: astore_3
    //   157: new 378	java/io/StringWriter
    //   160: dup
    //   161: invokespecial 379	java/io/StringWriter:<init>	()V
    //   164: astore_2
    //   165: new 381	javax/xml/transform/stream/StreamResult
    //   168: dup
    //   169: aload_2
    //   170: invokespecial 384	javax/xml/transform/stream/StreamResult:<init>	(Ljava/io/Writer;)V
    //   173: astore 4
    //   175: invokestatic 389	javax/xml/transform/TransformerFactory:newInstance	()Ljavax/xml/transform/TransformerFactory;
    //   178: invokevirtual 393	javax/xml/transform/TransformerFactory:newTransformer	()Ljavax/xml/transform/Transformer;
    //   181: aload_3
    //   182: aload 4
    //   184: invokevirtual 399	javax/xml/transform/Transformer:transform	(Ljavax/xml/transform/Source;Ljavax/xml/transform/Result;)V
    //   187: new 401	org/json/JSONObject
    //   190: dup
    //   191: invokespecial 402	org/json/JSONObject:<init>	()V
    //   194: astore_3
    //   195: aload_3
    //   196: ldc_w 404
    //   199: aload_2
    //   200: invokevirtual 407	java/io/StringWriter:toString	()Ljava/lang/String;
    //   203: invokevirtual 411	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   206: pop
    //   207: aload_1
    //   208: aload_3
    //   209: invokevirtual 412	org/json/JSONObject:toString	()Ljava/lang/String;
    //   212: aload_0
    //   213: invokeinterface 416 3 0
    //   218: return
    //   219: astore_1
    //   220: aload_1
    //   221: invokevirtual 417	java/lang/Exception:printStackTrace	()V
    //   224: return
    //   225: astore_1
    //   226: aload_1
    //   227: invokevirtual 417	java/lang/Exception:printStackTrace	()V
    //   230: return
    //   231: astore_2
    //   232: aload_2
    //   233: invokevirtual 417	java/lang/Exception:printStackTrace	()V
    //   236: goto -29 -> 207
    //   239: aload_0
    //   240: getfield 357	biie:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   243: ifnull -231 -> 12
    //   246: aload_2
    //   247: astore_1
    //   248: aload_0
    //   249: getfield 357	biie:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   252: iconst_2
    //   253: invokestatic 361	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   256: invokeinterface 367 2 0
    //   261: ifeq +20 -> 281
    //   264: aload_0
    //   265: getfield 357	biie:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   268: iconst_2
    //   269: invokestatic 361	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   272: invokeinterface 369 2 0
    //   277: checkcast 371	biif
    //   280: astore_1
    //   281: aload_1
    //   282: ifnull -270 -> 12
    //   285: aload_1
    //   286: aconst_null
    //   287: aload_0
    //   288: invokeinterface 416 3 0
    //   293: return
    //   294: aload_0
    //   295: getfield 357	biie:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   298: ifnull -286 -> 12
    //   301: aload_0
    //   302: getfield 357	biie:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   305: iconst_3
    //   306: invokestatic 361	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   309: invokeinterface 367 2 0
    //   314: ifeq +99 -> 413
    //   317: aload_0
    //   318: getfield 357	biie:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   321: iconst_3
    //   322: invokestatic 361	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   325: invokeinterface 369 2 0
    //   330: checkcast 371	biif
    //   333: astore_1
    //   334: aload_1
    //   335: ifnull -323 -> 12
    //   338: aload_3
    //   339: ldc_w 419
    //   342: invokeinterface 423 2 0
    //   347: astore_2
    //   348: aload_2
    //   349: invokeinterface 428 1 0
    //   354: ifeq -342 -> 12
    //   357: aload_2
    //   358: iconst_0
    //   359: invokeinterface 432 2 0
    //   364: checkcast 342	org/w3c/dom/Element
    //   367: ldc_w 434
    //   370: invokeinterface 346 2 0
    //   375: astore_3
    //   376: new 401	org/json/JSONObject
    //   379: dup
    //   380: invokespecial 402	org/json/JSONObject:<init>	()V
    //   383: astore_2
    //   384: aload_2
    //   385: ldc_w 436
    //   388: aload_3
    //   389: invokevirtual 411	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   392: pop
    //   393: aload_1
    //   394: aload_2
    //   395: invokevirtual 412	org/json/JSONObject:toString	()Ljava/lang/String;
    //   398: aload_0
    //   399: invokeinterface 416 3 0
    //   404: return
    //   405: astore_3
    //   406: aload_3
    //   407: invokevirtual 417	java/lang/Exception:printStackTrace	()V
    //   410: goto -17 -> 393
    //   413: aconst_null
    //   414: astore_1
    //   415: goto -81 -> 334
    //   418: aconst_null
    //   419: astore_1
    //   420: goto -276 -> 144
    //   423: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	424	0	this	biie
    //   0	424	1	paramString	String
    //   1	199	2	localStringWriter	java.io.StringWriter
    //   231	16	2	localException1	Exception
    //   347	48	2	localObject1	Object
    //   16	373	3	localObject2	Object
    //   405	2	3	localException2	Exception
    //   173	10	4	localStreamResult	javax.xml.transform.stream.StreamResult
    // Exception table:
    //   from	to	target	type
    //   148	195	219	java/lang/Exception
    //   207	218	219	java/lang/Exception
    //   232	236	219	java/lang/Exception
    //   17	74	225	java/lang/Exception
    //   74	104	225	java/lang/Exception
    //   104	144	225	java/lang/Exception
    //   220	224	225	java/lang/Exception
    //   239	246	225	java/lang/Exception
    //   248	281	225	java/lang/Exception
    //   285	293	225	java/lang/Exception
    //   294	334	225	java/lang/Exception
    //   338	384	225	java/lang/Exception
    //   393	404	225	java/lang/Exception
    //   406	410	225	java/lang/Exception
    //   195	207	231	java/lang/Exception
    //   384	393	405	java/lang/Exception
  }
  
  public void a(int paramInt, biif parambiif)
  {
    if (parambiif == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilMap == null) {
      this.jdField_a_of_type_JavaUtilMap = new LinkedHashMap();
    }
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), parambiif);
  }
  
  public void a(Object paramObject1, Object paramObject2)
  {
    if (this.jdField_a_of_type_Biib != null)
    {
      Object localObject = this.jdField_a_of_type_Biib.jdField_a_of_type_Bihy;
      if (localObject != null)
      {
        paramObject1 = null;
        localObject = ((bihy)localObject).getCodec("intchk");
        if (localObject != null) {
          paramObject1 = (byte[])((bihz)localObject).decode(paramObject2);
        }
        if (paramObject1 != null) {
          break label59;
        }
      }
    }
    return;
    label59:
    paramObject2 = new intchk.RspBody();
    int i;
    try
    {
      paramObject2.mergeFrom(paramObject1);
      i = 0;
      if (!paramObject2.uint32_subcmd.has()) {
        break label114;
      }
      i = paramObject2.uint32_subcmd.get();
    }
    catch (InvalidProtocolBufferMicroException paramObject1)
    {
      paramObject1.printStackTrace();
      return;
    }
    a(paramObject2);
    return;
    b(paramObject2);
    return;
    label114:
    switch (i)
    {
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.has("strike_result"))
        {
          this.d = paramString.getInt("strike_result");
          Object localObject = new intchk.ReportStrikeResultReq();
          ((intchk.ReportStrikeResultReq)localObject).uint32_intchk_id.set(this.b);
          ((intchk.ReportStrikeResultReq)localObject).uint32_strike_type.set(this.c);
          ((intchk.ReportStrikeResultReq)localObject).uint32_strike_result.set(this.d);
          paramString = new intchk.ReqBody();
          paramString.uint32_subcmd.set(3);
          paramString.msg_app_info.set(a());
          paramString.msg_report_strike_result_req.set((MessageMicro)localObject);
          if (this.jdField_a_of_type_Biib != null)
          {
            bihy localbihy = this.jdField_a_of_type_Biib.jdField_a_of_type_Bihy;
            if (localbihy != null)
            {
              localObject = paramString.toByteArray();
              bihz localbihz = localbihy.getCodec("intchk");
              paramString = (String)localObject;
              if (localbihz != null) {
                paramString = localbihz.encode(localObject);
              }
              localbihy.send(paramString);
              return;
            }
          }
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    Object localObject = new intchk.FetchCheckConfigReq();
    ((intchk.FetchCheckConfigReq)localObject).uint32_reserved.set(0);
    paramString = new intchk.ReqBody();
    paramString.uint32_subcmd.set(1);
    paramString.msg_app_info.set(a());
    paramString.msg_check_config_req.set((MessageMicro)localObject);
    bihy localbihy = this.jdField_a_of_type_Biib.jdField_a_of_type_Bihy;
    if (localbihy == null) {
      return;
    }
    localObject = paramString.toByteArray();
    bihz localbihz = localbihy.getCodec("intchk");
    paramString = (String)localObject;
    if (localbihz != null) {
      paramString = localbihz.encode(localObject);
    }
    localbihy.send(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biie
 * JD-Core Version:    0.7.0.1
 */