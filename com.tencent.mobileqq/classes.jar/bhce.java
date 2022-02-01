import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.AntiFraudConfigFileUtil.1;
import com.tencent.mobileqq.utils.AntiFraudConfigFileUtil.2;
import com.tencent.mobileqq.utils.AntiFraudConfigFileUtil.4;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import mqq.os.MqqHandler;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class bhce
{
  private int jdField_a_of_type_Int = -1;
  private Bundle jdField_a_of_type_AndroidOsBundle = new Bundle();
  private aodj jdField_a_of_type_Aodj = new bhcf(this);
  private Bundle b = new Bundle();
  
  public static bhce a()
  {
    return bhcg.a;
  }
  
  private void a(Bundle paramBundle, String paramString, Element paramElement)
  {
    try
    {
      i = Integer.parseInt(paramString);
      if ((i == 1) || (i == 2))
      {
        localObject1 = paramElement.getElementsByTagName("TailWording");
        if (((NodeList)localObject1).getLength() > 0)
        {
          localObject2 = new Bundle();
          i = 0;
          while (i < ((NodeList)localObject1).getLength())
          {
            localObject3 = (Element)((NodeList)localObject1).item(i);
            str = ((Element)localObject3).getAttribute("Status");
            paramString = str;
            if (TextUtils.isEmpty(str)) {
              paramString = "0";
            }
            ((Bundle)localObject2).putString(paramString, ((Element)localObject3).getTextContent());
            i += 1;
          }
        }
      }
    }
    catch (Exception paramString)
    {
      int i;
      Object localObject1;
      Object localObject2;
      Object localObject3;
      String str;
      for (;;)
      {
        paramString.printStackTrace();
        i = 0;
      }
      paramBundle.putBundle("TailWording", (Bundle)localObject2);
      paramString = paramElement.getElementsByTagName("Action");
      if (paramString.getLength() > 0)
      {
        paramElement = new Bundle();
        i = 0;
        while (i < paramString.getLength())
        {
          localObject2 = (Element)paramString.item(i);
          str = ((Element)localObject2).getAttribute("PlaceHolder");
          if (TextUtils.isEmpty(str))
          {
            i += 1;
          }
          else
          {
            localObject1 = new Bundle();
            localObject3 = ((Element)localObject2).getAttribute("Type");
            ((Bundle)localObject1).putString("Type", (String)localObject3);
            ((Bundle)localObject1).putString("Name", ((Element)localObject2).getAttribute("Name"));
            if (((String)localObject3).equalsIgnoreCase("openURL")) {
              a((Bundle)localObject1, (Element)localObject2);
            }
            for (;;)
            {
              paramElement.putBundle(str, (Bundle)localObject1);
              break;
              localObject3 = ((Element)localObject2).getElementsByTagName("AlertTitle");
              if (((NodeList)localObject3).getLength() > 0) {
                a((Bundle)localObject1, (Element)((NodeList)localObject3).item(0));
              }
              localObject3 = ((Element)localObject2).getElementsByTagName("AlertText");
              if (((NodeList)localObject3).getLength() > 0) {
                a((Bundle)localObject1, (Element)((NodeList)localObject3).item(0));
              }
              localObject3 = ((Element)localObject2).getElementsByTagName("AlertOtherBtnText");
              if (((NodeList)localObject3).getLength() > 0) {
                a((Bundle)localObject1, (Element)((NodeList)localObject3).item(0));
              }
              localObject2 = ((Element)localObject2).getElementsByTagName("AlertCancelBtnText");
              if (((NodeList)localObject2).getLength() > 0) {
                a((Bundle)localObject1, (Element)((NodeList)localObject2).item(0));
              }
            }
          }
        }
        paramBundle.putBundle("Action", paramElement);
      }
    }
    for (;;)
    {
      return;
      for (paramString = paramElement.getFirstChild(); paramString != null; paramString = paramString.getNextSibling()) {
        if ((paramString instanceof Element))
        {
          paramElement = new Bundle();
          a(paramElement, (Element)paramString);
          paramBundle.putBundle(paramString.getNodeName(), paramElement);
        }
      }
    }
  }
  
  private void a(Bundle paramBundle, Element paramElement)
  {
    String str = paramElement.getNodeName();
    paramElement = paramElement.getFirstChild();
    Object localObject2;
    for (Object localObject1 = ""; paramElement != null; localObject1 = localObject2)
    {
      localObject2 = localObject1;
      if ((paramElement instanceof Text)) {
        localObject2 = (String)localObject1 + paramElement.getNodeValue();
      }
      paramElement = paramElement.getNextSibling();
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      paramBundle.putString(str, (String)localObject1);
    }
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UinSafety.WordingConfigFileUtil", 2, "parse config file:" + paramString);
    }
    paramString = a(paramString);
    if (paramString != null) {
      b(paramString);
    }
  }
  
  /* Error */
  private void b(String paramString)
  {
    // Byte code:
    //   0: invokestatic 183	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   3: astore 5
    //   5: new 185	java/io/File
    //   8: dup
    //   9: aload_1
    //   10: invokespecial 187	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore 7
    //   15: aload 7
    //   17: invokevirtual 190	java/io/File:getName	()Ljava/lang/String;
    //   20: astore 6
    //   22: aload 6
    //   24: iconst_0
    //   25: aload 6
    //   27: ldc 192
    //   29: invokevirtual 195	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   32: invokevirtual 199	java/lang/String:substring	(II)Ljava/lang/String;
    //   35: astore 6
    //   37: aload 5
    //   39: invokevirtual 203	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   42: aload 7
    //   44: invokevirtual 209	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/File;)Lorg/w3c/dom/Document;
    //   47: invokeinterface 215 1 0
    //   52: astore 8
    //   54: aload_0
    //   55: getfield 29	bhce:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   58: aload 6
    //   60: invokevirtual 219	android/os/Bundle:getBundle	(Ljava/lang/String;)Landroid/os/Bundle;
    //   63: astore 5
    //   65: aload 5
    //   67: ifnull +418 -> 485
    //   70: aload 5
    //   72: ldc 221
    //   74: invokevirtual 224	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   77: astore 5
    //   79: aload 5
    //   81: invokestatic 79	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   84: istore 4
    //   86: iload 4
    //   88: ifne +397 -> 485
    //   91: aload 5
    //   93: invokestatic 49	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   96: istore_2
    //   97: aload 8
    //   99: ldc 221
    //   101: invokeinterface 73 2 0
    //   106: astore 5
    //   108: aload 5
    //   110: invokestatic 49	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   113: istore_3
    //   114: iload_3
    //   115: iload_2
    //   116: if_icmpge +58 -> 174
    //   119: invokestatic 163	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   122: ifeq +362 -> 484
    //   125: ldc 165
    //   127: iconst_2
    //   128: new 142	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   135: aload 6
    //   137: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: ldc 226
    //   142: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokestatic 171	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   151: return
    //   152: astore 5
    //   154: aload 5
    //   156: invokevirtual 92	java/lang/Exception:printStackTrace	()V
    //   159: goto +326 -> 485
    //   162: astore 7
    //   164: aload 7
    //   166: invokevirtual 227	java/lang/Throwable:printStackTrace	()V
    //   169: iconst_0
    //   170: istore_3
    //   171: goto -57 -> 114
    //   174: invokestatic 232	com/tencent/mqp/app/sec/ScConfigManager:a	()Lcom/tencent/mqp/app/sec/ScConfigManager;
    //   177: aload_1
    //   178: invokevirtual 234	com/tencent/mqp/app/sec/ScConfigManager:a	(Ljava/lang/String;)Z
    //   181: ifne +303 -> 484
    //   184: new 17	android/os/Bundle
    //   187: dup
    //   188: invokespecial 18	android/os/Bundle:<init>	()V
    //   191: astore 7
    //   193: aload 5
    //   195: astore_1
    //   196: aload 5
    //   198: invokestatic 79	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   201: ifeq +8 -> 209
    //   204: iconst_0
    //   205: invokestatic 237	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   208: astore_1
    //   209: aload 7
    //   211: ldc 221
    //   213: aload_1
    //   214: invokevirtual 89	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   217: aload_0
    //   218: iload_3
    //   219: putfield 15	bhce:jdField_a_of_type_Int	I
    //   222: aload 8
    //   224: ldc 239
    //   226: invokeinterface 57 2 0
    //   231: astore_1
    //   232: iconst_0
    //   233: istore_2
    //   234: iload_2
    //   235: aload_1
    //   236: invokeinterface 63 1 0
    //   241: if_icmpge +192 -> 433
    //   244: aload_1
    //   245: iload_2
    //   246: invokeinterface 67 2 0
    //   251: checkcast 53	org/w3c/dom/Element
    //   254: astore 9
    //   256: aload 9
    //   258: ldc 102
    //   260: invokeinterface 73 2 0
    //   265: astore 5
    //   267: new 17	android/os/Bundle
    //   270: dup
    //   271: invokespecial 18	android/os/Bundle:<init>	()V
    //   274: astore 8
    //   276: aload 9
    //   278: ldc 241
    //   280: invokeinterface 57 2 0
    //   285: astore 10
    //   287: iconst_0
    //   288: istore_3
    //   289: iload_3
    //   290: aload 10
    //   292: invokeinterface 63 1 0
    //   297: if_icmpge +58 -> 355
    //   300: aload 10
    //   302: iload_3
    //   303: invokeinterface 67 2 0
    //   308: checkcast 53	org/w3c/dom/Element
    //   311: astore 11
    //   313: new 17	android/os/Bundle
    //   316: dup
    //   317: invokespecial 18	android/os/Bundle:<init>	()V
    //   320: astore 12
    //   322: aload_0
    //   323: aload 12
    //   325: aload 5
    //   327: aload 11
    //   329: invokespecial 243	bhce:a	(Landroid/os/Bundle;Ljava/lang/String;Lorg/w3c/dom/Element;)V
    //   332: aload 8
    //   334: aload 11
    //   336: ldc 245
    //   338: invokeinterface 73 2 0
    //   343: aload 12
    //   345: invokevirtual 96	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   348: iload_3
    //   349: iconst_1
    //   350: iadd
    //   351: istore_3
    //   352: goto -63 -> 289
    //   355: aload 9
    //   357: ldc 247
    //   359: invokeinterface 57 2 0
    //   364: astore 9
    //   366: aload 9
    //   368: invokeinterface 63 1 0
    //   373: ifle +44 -> 417
    //   376: aload 9
    //   378: iconst_0
    //   379: invokeinterface 67 2 0
    //   384: checkcast 53	org/w3c/dom/Element
    //   387: astore 9
    //   389: new 17	android/os/Bundle
    //   392: dup
    //   393: invokespecial 18	android/os/Bundle:<init>	()V
    //   396: astore 10
    //   398: aload_0
    //   399: aload 10
    //   401: aload 5
    //   403: aload 9
    //   405: invokespecial 243	bhce:a	(Landroid/os/Bundle;Ljava/lang/String;Lorg/w3c/dom/Element;)V
    //   408: aload 8
    //   410: ldc 247
    //   412: aload 10
    //   414: invokevirtual 96	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   417: aload 7
    //   419: aload 5
    //   421: aload 8
    //   423: invokevirtual 96	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   426: iload_2
    //   427: iconst_1
    //   428: iadd
    //   429: istore_2
    //   430: goto -196 -> 234
    //   433: aload_0
    //   434: getfield 29	bhce:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   437: aload 6
    //   439: aload 7
    //   441: invokevirtual 96	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   444: return
    //   445: astore_1
    //   446: invokestatic 163	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   449: ifeq +31 -> 480
    //   452: ldc 165
    //   454: iconst_2
    //   455: new 142	java/lang/StringBuilder
    //   458: dup
    //   459: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   462: ldc 249
    //   464: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: aload_1
    //   468: invokevirtual 252	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   471: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   477: invokestatic 171	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   480: aload_1
    //   481: invokevirtual 92	java/lang/Exception:printStackTrace	()V
    //   484: return
    //   485: iconst_0
    //   486: istore_2
    //   487: goto -390 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	490	0	this	bhce
    //   0	490	1	paramString	String
    //   96	391	2	i	int
    //   113	239	3	j	int
    //   84	3	4	bool	boolean
    //   3	106	5	localObject1	Object
    //   152	45	5	localException	Exception
    //   265	155	5	str1	String
    //   20	418	6	str2	String
    //   13	30	7	localFile	File
    //   162	3	7	localThrowable	Throwable
    //   191	249	7	localBundle1	Bundle
    //   52	370	8	localObject2	Object
    //   254	150	9	localObject3	Object
    //   285	128	10	localObject4	Object
    //   311	24	11	localElement	Element
    //   320	24	12	localBundle2	Bundle
    // Exception table:
    //   from	to	target	type
    //   91	97	152	java/lang/Exception
    //   108	114	162	java/lang/Throwable
    //   5	65	445	java/lang/Exception
    //   70	86	445	java/lang/Exception
    //   97	108	445	java/lang/Exception
    //   108	114	445	java/lang/Exception
    //   119	151	445	java/lang/Exception
    //   154	159	445	java/lang/Exception
    //   164	169	445	java/lang/Exception
    //   174	193	445	java/lang/Exception
    //   196	209	445	java/lang/Exception
    //   209	232	445	java/lang/Exception
    //   234	287	445	java/lang/Exception
    //   289	348	445	java/lang/Exception
    //   355	417	445	java/lang/Exception
    //   417	426	445	java/lang/Exception
    //   433	444	445	java/lang/Exception
  }
  
  public int a(String paramString)
  {
    DocumentBuilderFactory localDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
    try
    {
      paramString = new File(paramString);
      String str = paramString.getName();
      str.substring(0, str.lastIndexOf("."));
      paramString = localDocumentBuilderFactory.newDocumentBuilder().parse(paramString).getDocumentElement().getAttribute("Version");
      try
      {
        int i = Integer.parseInt(paramString);
        return i;
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
        return -1;
      }
      return -1;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UinSafety.WordingConfigFileUtil", 2, "exception occurred." + paramString.getMessage());
      }
      paramString.printStackTrace();
    }
  }
  
  public long a(String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).getLong(paramString + "_" + "LastModifiedTime", 0L);
  }
  
  public Object a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    ThreadManager.getFileThreadHandler().post(new AntiFraudConfigFileUtil.2(this, paramString1));
    Bundle localBundle1 = null;
    Bundle localBundle2 = this.jdField_a_of_type_AndroidOsBundle.getBundle(paramString1);
    paramString1 = localBundle1;
    if (localBundle2 != null)
    {
      localBundle2 = localBundle2.getBundle(Integer.toString(paramInt1));
      paramString1 = localBundle1;
      if (localBundle2 != null)
      {
        Bundle localBundle3 = localBundle2.getBundle(Integer.toString(paramInt2));
        paramString1 = localBundle1;
        if (localBundle3 != null)
        {
          localBundle1 = localBundle3.getBundle(paramString2);
          paramString1 = localBundle1;
          if (localBundle1 == null)
          {
            localBundle2 = localBundle2.getBundle("PublicElement");
            paramString1 = localBundle1;
            if (localBundle2 != null) {
              paramString1 = localBundle2.getBundle(paramString2);
            }
          }
        }
      }
    }
    return paramString1;
  }
  
  public String a(String paramString)
  {
    return BaseApplication.getContext().getFilesDir().getPath() + "/" + paramString + ".xml";
  }
  
  public String a(String paramString1, String paramString2)
  {
    Object localObject = paramString1;
    if (!TextUtils.isEmpty(paramString1))
    {
      localObject = paramString1;
      if (TextUtils.equals("SenstiveMessageTipsCfg", paramString1)) {
        localObject = "SensMsgTipsCfg";
      }
    }
    ThreadManager.getFileThreadHandler().post(new AntiFraudConfigFileUtil.1(this, (String)localObject));
    paramString1 = null;
    localObject = this.jdField_a_of_type_AndroidOsBundle.getBundle((String)localObject);
    if (localObject != null) {
      paramString1 = ((Bundle)localObject).getString(paramString2);
    }
    return paramString1;
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {}
    long l1;
    long l2;
    do
    {
      return;
      paramQQAppInterface.addObserver(this.jdField_a_of_type_Aodj);
      l1 = a(paramString);
      l2 = b(paramString);
    } while (System.currentTimeMillis() - l1 < l2 * 1000L);
    aodi localaodi = (aodi)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SEC_SVC_HANDLER);
    paramQQAppInterface = paramString;
    if (TextUtils.equals(paramString, "SensMsgTipsCfg")) {
      paramQQAppInterface = "SenstiveMessageTipsCfg";
    }
    localaodi.a(paramQQAppInterface);
  }
  
  /* Error */
  public void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 13
    //   3: aconst_null
    //   4: astore 14
    //   6: aload_1
    //   7: ifnull +11 -> 18
    //   10: aload_1
    //   11: aload_0
    //   12: getfield 27	bhce:jdField_a_of_type_Aodj	Laodj;
    //   15: invokevirtual 322	com/tencent/mobileqq/app/QQAppInterface:addObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   18: aload_2
    //   19: invokestatic 79	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   22: ifeq +4 -> 26
    //   25: return
    //   26: aload_2
    //   27: ldc_w 351
    //   30: invokevirtual 112	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   33: ifeq +52 -> 85
    //   36: aload_0
    //   37: aload_2
    //   38: invokevirtual 324	bhce:a	(Ljava/lang/String;)J
    //   41: lstore 6
    //   43: aload_0
    //   44: aload_2
    //   45: invokevirtual 326	bhce:b	(Ljava/lang/String;)J
    //   48: lstore 8
    //   50: aload_1
    //   51: ifnull -26 -> 25
    //   54: invokestatic 332	java/lang/System:currentTimeMillis	()J
    //   57: lload 6
    //   59: lsub
    //   60: lload 8
    //   62: ldc2_w 333
    //   65: lmul
    //   66: lcmp
    //   67: iflt -42 -> 25
    //   70: aload_1
    //   71: getstatic 339	com/tencent/mobileqq/app/BusinessHandlerFactory:SEC_SVC_HANDLER	I
    //   74: invokevirtual 343	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   77: checkcast 345	aodi
    //   80: aload_2
    //   81: invokevirtual 346	aodi:a	(Ljava/lang/String;)V
    //   84: return
    //   85: aload_2
    //   86: ldc_w 312
    //   89: invokevirtual 112	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   92: ifeq -67 -> 25
    //   95: aload_0
    //   96: aload_2
    //   97: invokevirtual 353	bhce:b	(Ljava/lang/String;)Ljava/lang/String;
    //   100: astore 12
    //   102: aload_0
    //   103: ldc_w 312
    //   106: invokevirtual 173	bhce:a	(Ljava/lang/String;)Ljava/lang/String;
    //   109: astore 15
    //   111: aload 12
    //   113: invokestatic 79	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   116: istore 10
    //   118: aload_0
    //   119: getfield 15	bhce:jdField_a_of_type_Int	I
    //   122: iconst_m1
    //   123: if_icmpne +21 -> 144
    //   126: aload 12
    //   128: invokestatic 79	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   131: ifne +13 -> 144
    //   134: aload_0
    //   135: aload_0
    //   136: aload 15
    //   138: invokevirtual 355	bhce:a	(Ljava/lang/String;)I
    //   141: putfield 15	bhce:jdField_a_of_type_Int	I
    //   144: aload_0
    //   145: getfield 15	bhce:jdField_a_of_type_Int	I
    //   148: iconst_2
    //   149: if_icmpge +6 -> 155
    //   152: iconst_1
    //   153: istore 10
    //   155: aload 12
    //   157: astore_1
    //   158: iload 10
    //   160: ifeq +124 -> 284
    //   163: invokestatic 259	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   166: invokevirtual 359	com/tencent/qphone/base/util/BaseApplication:getAssets	()Landroid/content/res/AssetManager;
    //   169: ldc_w 361
    //   172: invokevirtual 367	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   175: astore_1
    //   176: new 369	java/io/FileOutputStream
    //   179: dup
    //   180: aload 15
    //   182: invokespecial 370	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   185: astore 11
    //   187: sipush 4096
    //   190: newarray byte
    //   192: astore_2
    //   193: aload_1
    //   194: aload_2
    //   195: invokevirtual 376	java/io/InputStream:read	([B)I
    //   198: istore 5
    //   200: iload 5
    //   202: ifle +109 -> 311
    //   205: aload 11
    //   207: aload_2
    //   208: iconst_0
    //   209: iload 5
    //   211: invokevirtual 382	java/io/OutputStream:write	([BII)V
    //   214: goto -21 -> 193
    //   217: astore 13
    //   219: aload_1
    //   220: astore_2
    //   221: aload 11
    //   223: astore_1
    //   224: aload 13
    //   226: astore 11
    //   228: aload 11
    //   230: invokevirtual 92	java/lang/Exception:printStackTrace	()V
    //   233: aload_2
    //   234: ifnull +7 -> 241
    //   237: aload_2
    //   238: invokevirtual 385	java/io/InputStream:close	()V
    //   241: aload_1
    //   242: ifnull +7 -> 249
    //   245: aload_1
    //   246: invokevirtual 386	java/io/OutputStream:close	()V
    //   249: aload 12
    //   251: astore_1
    //   252: aload 15
    //   254: invokestatic 391	com/tencent/mobileqq/filemanager/util/FileUtil:isFileExists	(Ljava/lang/String;)Z
    //   257: ifeq +27 -> 284
    //   260: aload 15
    //   262: invokestatic 396	com/tencent/mobileqq/utils/SecUtil:getFileMd5	(Ljava/lang/String;)Ljava/lang/String;
    //   265: astore_1
    //   266: aload_0
    //   267: ldc_w 312
    //   270: aload_1
    //   271: invokevirtual 398	bhce:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   274: aload_0
    //   275: aload_0
    //   276: aload 15
    //   278: invokevirtual 355	bhce:a	(Ljava/lang/String;)I
    //   281: putfield 15	bhce:jdField_a_of_type_Int	I
    //   284: aload_1
    //   285: aload 4
    //   287: invokestatic 310	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   290: ifne -265 -> 25
    //   293: aload_3
    //   294: invokestatic 79	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   297: ifne -272 -> 25
    //   300: aload_0
    //   301: ldc_w 312
    //   304: aload 4
    //   306: aload_3
    //   307: invokevirtual 401	bhce:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   310: return
    //   311: aload_1
    //   312: ifnull +7 -> 319
    //   315: aload_1
    //   316: invokevirtual 385	java/io/InputStream:close	()V
    //   319: aload 11
    //   321: ifnull -72 -> 249
    //   324: aload 11
    //   326: invokevirtual 386	java/io/OutputStream:close	()V
    //   329: goto -80 -> 249
    //   332: astore_1
    //   333: aload_1
    //   334: invokevirtual 402	java/io/IOException:printStackTrace	()V
    //   337: goto -88 -> 249
    //   340: astore_1
    //   341: aload_1
    //   342: invokevirtual 402	java/io/IOException:printStackTrace	()V
    //   345: goto -96 -> 249
    //   348: astore_2
    //   349: aconst_null
    //   350: astore_1
    //   351: aload 13
    //   353: astore_3
    //   354: aload_1
    //   355: ifnull +7 -> 362
    //   358: aload_1
    //   359: invokevirtual 385	java/io/InputStream:close	()V
    //   362: aload_3
    //   363: ifnull +7 -> 370
    //   366: aload_3
    //   367: invokevirtual 386	java/io/OutputStream:close	()V
    //   370: aload_2
    //   371: athrow
    //   372: astore_1
    //   373: aload_1
    //   374: invokevirtual 402	java/io/IOException:printStackTrace	()V
    //   377: goto -7 -> 370
    //   380: astore_2
    //   381: aload 13
    //   383: astore_3
    //   384: goto -30 -> 354
    //   387: astore_2
    //   388: aload 11
    //   390: astore_3
    //   391: goto -37 -> 354
    //   394: astore_3
    //   395: aload_2
    //   396: astore 4
    //   398: aload_3
    //   399: astore_2
    //   400: aload_1
    //   401: astore_3
    //   402: aload 4
    //   404: astore_1
    //   405: goto -51 -> 354
    //   408: astore 11
    //   410: aconst_null
    //   411: astore_1
    //   412: aload 14
    //   414: astore_2
    //   415: goto -187 -> 228
    //   418: astore 11
    //   420: aconst_null
    //   421: astore 13
    //   423: aload_1
    //   424: astore_2
    //   425: aload 13
    //   427: astore_1
    //   428: goto -200 -> 228
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	431	0	this	bhce
    //   0	431	1	paramQQAppInterface	QQAppInterface
    //   0	431	2	paramString1	String
    //   0	431	3	paramString2	String
    //   0	431	4	paramString3	String
    //   198	12	5	i	int
    //   41	17	6	l1	long
    //   48	13	8	l2	long
    //   116	43	10	bool	boolean
    //   185	204	11	localObject1	Object
    //   408	1	11	localException1	Exception
    //   418	1	11	localException2	Exception
    //   100	150	12	str1	String
    //   1	1	13	localObject2	Object
    //   217	165	13	localException3	Exception
    //   421	5	13	localObject3	Object
    //   4	409	14	localObject4	Object
    //   109	168	15	str2	String
    // Exception table:
    //   from	to	target	type
    //   187	193	217	java/lang/Exception
    //   193	200	217	java/lang/Exception
    //   205	214	217	java/lang/Exception
    //   315	319	332	java/io/IOException
    //   324	329	332	java/io/IOException
    //   237	241	340	java/io/IOException
    //   245	249	340	java/io/IOException
    //   163	176	348	finally
    //   358	362	372	java/io/IOException
    //   366	370	372	java/io/IOException
    //   176	187	380	finally
    //   187	193	387	finally
    //   193	200	387	finally
    //   205	214	387	finally
    //   228	233	394	finally
    //   163	176	408	java/lang/Exception
    //   176	187	418	java/lang/Exception
  }
  
  public void a(String paramString, long paramLong)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit();
    localEditor.putLong(paramString + "_" + "LastModifiedTime", paramLong);
    localEditor.commit();
  }
  
  public void a(String paramString1, String paramString2)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit();
    localEditor.putString(paramString1 + "_" + "MD5", paramString2);
    localEditor.commit();
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    int i = this.b.getInt(paramString2, 0);
    if ((i == 1) || (i == 3)) {
      return;
    }
    try
    {
      this.b.putInt(paramString2, 1);
      ThreadManager.post(new AntiFraudConfigFileUtil.4(this, paramString1, paramString3, paramString2), 5, null, false);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public long b(String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).getLong(paramString + "_" + "EffectTime", 0L);
  }
  
  public String b(String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).getString(paramString + "_" + "MD5", null);
  }
  
  public void b(String paramString, long paramLong)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit();
    localEditor.putLong(paramString + "_" + "EffectTime", paramLong);
    localEditor.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhce
 * JD-Core Version:    0.7.0.1
 */