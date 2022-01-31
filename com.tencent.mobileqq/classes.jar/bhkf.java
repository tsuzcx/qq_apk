import android.os.Bundle;
import android.util.Pair;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class bhkf
{
  private int jdField_a_of_type_Int = 1;
  private List<bhkg> jdField_a_of_type_JavaUtilList;
  
  public bhkf()
  {
    Pair localPair = a(a(), 1);
    if (localPair != null)
    {
      this.jdField_a_of_type_Int = ((Integer)localPair.first).intValue();
      this.jdField_a_of_type_JavaUtilList = ((List)localPair.second);
    }
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new LinkedList();
    }
  }
  
  private int a(Element paramElement)
  {
    for (;;)
    {
      int i;
      try
      {
        paramElement = paramElement.getAttributes();
        if (paramElement != null) {
          break label76;
        }
        return 0;
      }
      catch (Exception paramElement)
      {
        Node localNode;
        String str;
        paramElement.printStackTrace();
      }
      if (i < paramElement.getLength())
      {
        localNode = paramElement.item(i);
        str = localNode.getNodeName();
        if ((str != null) && (str.equalsIgnoreCase("version")))
        {
          i = Integer.parseInt(localNode.getNodeValue());
          return i;
        }
      }
      else
      {
        return 0;
        label76:
        i = 0;
        continue;
      }
      i += 1;
    }
  }
  
  private Bundle a(Node paramNode)
  {
    for (;;)
    {
      int i;
      try
      {
        Bundle localBundle = new Bundle();
        NodeList localNodeList = paramNode.getChildNodes();
        int j = localNodeList.getLength();
        i = 0;
        paramNode = localBundle;
        if (i < j)
        {
          paramNode = localNodeList.item(i);
          if (paramNode.getNodeType() != 1) {
            break label166;
          }
          Object localObject = paramNode.getAttributes();
          if (localObject == null) {
            break label166;
          }
          paramNode = ((NamedNodeMap)localObject).getNamedItem("name");
          if ((paramNode == null) || (paramNode.getNodeType() != 2)) {
            break label166;
          }
          paramNode = paramNode.getNodeValue();
          if (paramNode == null) {
            break label166;
          }
          localObject = ((NamedNodeMap)localObject).getNamedItem("value");
          if ((localObject == null) || (((Node)localObject).getNodeType() != 2)) {
            break label166;
          }
          localObject = ((Node)localObject).getNodeValue();
          if (localObject == null) {
            break label166;
          }
          localBundle.putString(paramNode, (String)localObject);
        }
      }
      catch (Exception paramNode)
      {
        paramNode.printStackTrace();
        paramNode = null;
      }
      return paramNode;
      label166:
      i += 1;
    }
  }
  
  private Pair<Integer, List<bhkg>> a(String paramString, int paramInt)
  {
    Object localObject = null;
    byte[] arrayOfByte = new bhla().a(paramString, null, 1);
    paramString = localObject;
    if (arrayOfByte != null) {
      paramString = a(arrayOfByte, paramInt);
    }
    return paramString;
  }
  
  /* Error */
  private Pair<Integer, List<bhkg>> a(byte[] paramArrayOfByte, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 132	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   3: astore 5
    //   5: aload 5
    //   7: invokevirtual 136	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   10: astore 6
    //   12: new 138	java/io/ByteArrayInputStream
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 141	java/io/ByteArrayInputStream:<init>	([B)V
    //   20: astore 5
    //   22: aload 5
    //   24: astore_1
    //   25: aload 6
    //   27: aload 5
    //   29: invokevirtual 147	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   32: invokeinterface 153 1 0
    //   37: astore 7
    //   39: aload 5
    //   41: astore_1
    //   42: aload_0
    //   43: aload 7
    //   45: invokespecial 155	bhkf:a	(Lorg/w3c/dom/Element;)I
    //   48: istore_3
    //   49: iload_3
    //   50: ifeq +8 -> 58
    //   53: iload_3
    //   54: iload_2
    //   55: if_icmple +46 -> 101
    //   58: aload 5
    //   60: astore_1
    //   61: new 22	android/util/Pair
    //   64: dup
    //   65: iload_3
    //   66: invokestatic 159	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   69: aconst_null
    //   70: invokespecial 162	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   73: astore 6
    //   75: aload 6
    //   77: astore_1
    //   78: aload 5
    //   80: ifnull +11 -> 91
    //   83: aload 5
    //   85: invokevirtual 165	java/io/ByteArrayInputStream:close	()V
    //   88: aload 6
    //   90: astore_1
    //   91: aload_1
    //   92: areturn
    //   93: astore_1
    //   94: aload_1
    //   95: invokevirtual 166	java/io/IOException:printStackTrace	()V
    //   98: aload 6
    //   100: areturn
    //   101: aload 5
    //   103: astore_1
    //   104: new 41	java/util/LinkedList
    //   107: dup
    //   108: invokespecial 42	java/util/LinkedList:<init>	()V
    //   111: astore 6
    //   113: aload 5
    //   115: astore_1
    //   116: aload 7
    //   118: invokeinterface 167 1 0
    //   123: astore 7
    //   125: aload 5
    //   127: astore_1
    //   128: aload 7
    //   130: invokeinterface 95 1 0
    //   135: istore 4
    //   137: iconst_0
    //   138: istore_2
    //   139: iload_2
    //   140: iload 4
    //   142: if_icmpge +117 -> 259
    //   145: aload 5
    //   147: astore_1
    //   148: aload 7
    //   150: iload_2
    //   151: invokeinterface 96 2 0
    //   156: astore 8
    //   158: aload 5
    //   160: astore_1
    //   161: aload 8
    //   163: invokeinterface 100 1 0
    //   168: iconst_1
    //   169: if_icmpeq +6 -> 175
    //   172: goto +173 -> 345
    //   175: aload 5
    //   177: astore_1
    //   178: aload 8
    //   180: invokeinterface 66 1 0
    //   185: astore 9
    //   187: aload 9
    //   189: ifnull +156 -> 345
    //   192: aload 5
    //   194: astore_1
    //   195: aload 9
    //   197: ldc 169
    //   199: invokevirtual 74	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   202: ifeq +143 -> 345
    //   205: aload 5
    //   207: astore_1
    //   208: aload_0
    //   209: aload 8
    //   211: invokespecial 172	bhkf:a	(Lorg/w3c/dom/Node;)Lbhkg;
    //   214: astore 8
    //   216: aload 8
    //   218: ifnull +127 -> 345
    //   221: aload 5
    //   223: astore_1
    //   224: aload 6
    //   226: aload 8
    //   228: invokeinterface 176 2 0
    //   233: pop
    //   234: goto +111 -> 345
    //   237: astore 6
    //   239: aload 5
    //   241: astore_1
    //   242: aload 6
    //   244: invokevirtual 84	java/lang/Exception:printStackTrace	()V
    //   247: aload 5
    //   249: ifnull +8 -> 257
    //   252: aload 5
    //   254: invokevirtual 165	java/io/ByteArrayInputStream:close	()V
    //   257: aconst_null
    //   258: areturn
    //   259: aload 5
    //   261: astore_1
    //   262: new 22	android/util/Pair
    //   265: dup
    //   266: iload_3
    //   267: invokestatic 159	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   270: aload 6
    //   272: invokespecial 162	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   275: astore 6
    //   277: aload 6
    //   279: astore_1
    //   280: aload 5
    //   282: ifnull -191 -> 91
    //   285: aload 5
    //   287: invokevirtual 165	java/io/ByteArrayInputStream:close	()V
    //   290: aload 6
    //   292: areturn
    //   293: astore_1
    //   294: aload_1
    //   295: invokevirtual 166	java/io/IOException:printStackTrace	()V
    //   298: aload 6
    //   300: areturn
    //   301: astore_1
    //   302: aload_1
    //   303: invokevirtual 166	java/io/IOException:printStackTrace	()V
    //   306: goto -49 -> 257
    //   309: astore 5
    //   311: aconst_null
    //   312: astore_1
    //   313: aload_1
    //   314: ifnull +7 -> 321
    //   317: aload_1
    //   318: invokevirtual 165	java/io/ByteArrayInputStream:close	()V
    //   321: aload 5
    //   323: athrow
    //   324: astore_1
    //   325: aload_1
    //   326: invokevirtual 166	java/io/IOException:printStackTrace	()V
    //   329: goto -8 -> 321
    //   332: astore 5
    //   334: goto -21 -> 313
    //   337: astore 6
    //   339: aconst_null
    //   340: astore 5
    //   342: goto -103 -> 239
    //   345: iload_2
    //   346: iconst_1
    //   347: iadd
    //   348: istore_2
    //   349: goto -210 -> 139
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	352	0	this	bhkf
    //   0	352	1	paramArrayOfByte	byte[]
    //   0	352	2	paramInt	int
    //   48	219	3	i	int
    //   135	8	4	j	int
    //   3	283	5	localObject1	Object
    //   309	13	5	localObject2	Object
    //   332	1	5	localObject3	Object
    //   340	1	5	localObject4	Object
    //   10	215	6	localObject5	Object
    //   237	34	6	localException1	Exception
    //   275	24	6	localPair	Pair
    //   337	1	6	localException2	Exception
    //   37	112	7	localObject6	Object
    //   156	71	8	localObject7	Object
    //   185	11	9	str	String
    // Exception table:
    //   from	to	target	type
    //   83	88	93	java/io/IOException
    //   25	39	237	java/lang/Exception
    //   42	49	237	java/lang/Exception
    //   61	75	237	java/lang/Exception
    //   104	113	237	java/lang/Exception
    //   116	125	237	java/lang/Exception
    //   128	137	237	java/lang/Exception
    //   148	158	237	java/lang/Exception
    //   161	172	237	java/lang/Exception
    //   178	187	237	java/lang/Exception
    //   195	205	237	java/lang/Exception
    //   208	216	237	java/lang/Exception
    //   224	234	237	java/lang/Exception
    //   262	277	237	java/lang/Exception
    //   285	290	293	java/io/IOException
    //   252	257	301	java/io/IOException
    //   5	22	309	finally
    //   317	321	324	java/io/IOException
    //   25	39	332	finally
    //   42	49	332	finally
    //   61	75	332	finally
    //   104	113	332	finally
    //   116	125	332	finally
    //   128	137	332	finally
    //   148	158	332	finally
    //   161	172	332	finally
    //   178	187	332	finally
    //   195	205	332	finally
    //   208	216	332	finally
    //   224	234	332	finally
    //   242	247	332	finally
    //   262	277	332	finally
    //   5	22	337	java/lang/Exception
  }
  
  private bhkg a(Node paramNode)
  {
    int k = 0;
    do
    {
      for (;;)
      {
        int j;
        int i;
        try
        {
          NamedNodeMap localNamedNodeMap = paramNode.getAttributes();
          if (localNamedNodeMap == null) {
            return null;
          }
          localbhkg = new bhkg();
          int m = localNamedNodeMap.getLength();
          j = 0;
          if (j >= m) {
            break;
          }
          Object localObject = localNamedNodeMap.item(j);
          if (((Node)localObject).getNodeType() != 2)
          {
            i = k;
          }
          else
          {
            String str = ((Node)localObject).getNodeName();
            localObject = ((Node)localObject).getNodeValue();
            i = k;
            if (str != null)
            {
              i = k;
              if (localObject != null) {
                if (str.equalsIgnoreCase("id"))
                {
                  localbhkg.jdField_a_of_type_Int = Integer.parseInt((String)localObject);
                  i = k + 1;
                }
                else if (str.equalsIgnoreCase("type"))
                {
                  localbhkg.jdField_b_of_type_Int = Integer.parseInt((String)localObject);
                  i = k + 1;
                }
                else if (str.equalsIgnoreCase("flags"))
                {
                  localbhkg.c = Integer.parseInt((String)localObject);
                  i = k + 1;
                }
                else if (str.equalsIgnoreCase("path"))
                {
                  localbhkg.jdField_b_of_type_JavaLangString = ((String)localObject);
                  i = k + 1;
                }
                else
                {
                  i = k;
                  if (str.equalsIgnoreCase("ver"))
                  {
                    localbhkg.jdField_a_of_type_JavaLangString = ((String)localObject);
                    i = k + 1;
                  }
                }
              }
            }
          }
        }
        catch (Exception paramNode)
        {
          bhkg localbhkg;
          paramNode.printStackTrace();
          return null;
        }
        localbhkg.jdField_a_of_type_AndroidOsBundle = a(paramNode);
        return localbhkg;
        j += 1;
        k = i;
      }
    } while (k == 5);
    return null;
  }
  
  private String a()
  {
    return bhil.a() + File.separator + "QSec.dat";
  }
  
  private boolean a(int paramInt)
  {
    return b(paramInt) != null;
  }
  
  private boolean a(String paramString, int paramInt, List<bhkg> paramList)
  {
    paramList = a(paramInt, paramList);
    if (paramList == null) {
      return false;
    }
    return new bhla().a(paramString, paramList, null, 1);
  }
  
  /* Error */
  private byte[] a(int paramInt, List<bhkg> paramList)
  {
    // Byte code:
    //   0: invokestatic 245	android/util/Xml:newSerializer	()Lorg/xmlpull/v1/XmlSerializer;
    //   3: astore 5
    //   5: new 247	java/io/ByteArrayOutputStream
    //   8: dup
    //   9: invokespecial 248	java/io/ByteArrayOutputStream:<init>	()V
    //   12: astore 4
    //   14: aload 4
    //   16: astore_3
    //   17: aload 5
    //   19: aload 4
    //   21: ldc 250
    //   23: invokeinterface 256 3 0
    //   28: aload 4
    //   30: astore_3
    //   31: aload 5
    //   33: aconst_null
    //   34: iconst_1
    //   35: invokestatic 261	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   38: invokeinterface 265 3 0
    //   43: aload 4
    //   45: astore_3
    //   46: aload 5
    //   48: aconst_null
    //   49: ldc_w 267
    //   52: invokeinterface 271 3 0
    //   57: pop
    //   58: aload 4
    //   60: astore_3
    //   61: aload 5
    //   63: aconst_null
    //   64: ldc 68
    //   66: iload_1
    //   67: invokestatic 274	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   70: invokeinterface 278 4 0
    //   75: pop
    //   76: aload 4
    //   78: astore_3
    //   79: aload_2
    //   80: invokeinterface 282 1 0
    //   85: astore_2
    //   86: aload 4
    //   88: astore_3
    //   89: aload_2
    //   90: invokeinterface 288 1 0
    //   95: ifeq +178 -> 273
    //   98: aload 4
    //   100: astore_3
    //   101: aload_2
    //   102: invokeinterface 292 1 0
    //   107: checkcast 179	bhkg
    //   110: astore 6
    //   112: aload 4
    //   114: astore_3
    //   115: aload 5
    //   117: aconst_null
    //   118: ldc 169
    //   120: invokeinterface 271 3 0
    //   125: pop
    //   126: aload 4
    //   128: astore_3
    //   129: aload 5
    //   131: aconst_null
    //   132: ldc 182
    //   134: aload 6
    //   136: getfield 183	bhkg:jdField_a_of_type_Int	I
    //   139: invokestatic 274	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   142: invokeinterface 278 4 0
    //   147: pop
    //   148: aload 4
    //   150: astore_3
    //   151: aload 5
    //   153: aconst_null
    //   154: ldc 185
    //   156: aload 6
    //   158: getfield 188	bhkg:jdField_b_of_type_Int	I
    //   161: invokestatic 274	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   164: invokeinterface 278 4 0
    //   169: pop
    //   170: aload 4
    //   172: astore_3
    //   173: aload 5
    //   175: aconst_null
    //   176: ldc 190
    //   178: aload 6
    //   180: getfield 193	bhkg:c	I
    //   183: invokestatic 274	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   186: invokeinterface 278 4 0
    //   191: pop
    //   192: aload 4
    //   194: astore_3
    //   195: aload 5
    //   197: aconst_null
    //   198: ldc 200
    //   200: aload 6
    //   202: getfield 202	bhkg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   205: invokeinterface 278 4 0
    //   210: pop
    //   211: aload 4
    //   213: astore_3
    //   214: aload 5
    //   216: aconst_null
    //   217: ldc 195
    //   219: aload 6
    //   221: getfield 198	bhkg:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   224: invokeinterface 278 4 0
    //   229: pop
    //   230: aload 4
    //   232: astore_3
    //   233: aload 5
    //   235: aconst_null
    //   236: ldc 169
    //   238: invokeinterface 295 3 0
    //   243: pop
    //   244: goto -158 -> 86
    //   247: astore_3
    //   248: aload 4
    //   250: astore_2
    //   251: aload_3
    //   252: astore 4
    //   254: aload_2
    //   255: astore_3
    //   256: aload 4
    //   258: invokevirtual 84	java/lang/Exception:printStackTrace	()V
    //   261: aload_2
    //   262: ifnull +7 -> 269
    //   265: aload_2
    //   266: invokevirtual 296	java/io/ByteArrayOutputStream:close	()V
    //   269: aconst_null
    //   270: astore_3
    //   271: aload_3
    //   272: areturn
    //   273: aload 4
    //   275: astore_3
    //   276: aload 5
    //   278: aconst_null
    //   279: ldc_w 267
    //   282: invokeinterface 295 3 0
    //   287: pop
    //   288: aload 4
    //   290: astore_3
    //   291: aload 5
    //   293: invokeinterface 299 1 0
    //   298: aload 4
    //   300: astore_3
    //   301: aload 4
    //   303: invokevirtual 303	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   306: astore_2
    //   307: aload_2
    //   308: astore_3
    //   309: aload 4
    //   311: ifnull -40 -> 271
    //   314: aload 4
    //   316: invokevirtual 296	java/io/ByteArrayOutputStream:close	()V
    //   319: aload_2
    //   320: areturn
    //   321: astore_3
    //   322: aload_3
    //   323: invokevirtual 166	java/io/IOException:printStackTrace	()V
    //   326: aload_2
    //   327: areturn
    //   328: astore_2
    //   329: aload_2
    //   330: invokevirtual 166	java/io/IOException:printStackTrace	()V
    //   333: goto -64 -> 269
    //   336: astore_2
    //   337: aconst_null
    //   338: astore_3
    //   339: aload_3
    //   340: ifnull +7 -> 347
    //   343: aload_3
    //   344: invokevirtual 296	java/io/ByteArrayOutputStream:close	()V
    //   347: aload_2
    //   348: athrow
    //   349: astore_3
    //   350: aload_3
    //   351: invokevirtual 166	java/io/IOException:printStackTrace	()V
    //   354: goto -7 -> 347
    //   357: astore_2
    //   358: goto -19 -> 339
    //   361: astore 4
    //   363: aconst_null
    //   364: astore_2
    //   365: goto -111 -> 254
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	368	0	this	bhkf
    //   0	368	1	paramInt	int
    //   0	368	2	paramList	List<bhkg>
    //   16	217	3	localObject1	Object
    //   247	5	3	localException1	Exception
    //   255	54	3	localObject2	Object
    //   321	2	3	localIOException1	java.io.IOException
    //   338	6	3	localObject3	Object
    //   349	2	3	localIOException2	java.io.IOException
    //   12	303	4	localObject4	Object
    //   361	1	4	localException2	Exception
    //   3	289	5	localXmlSerializer	org.xmlpull.v1.XmlSerializer
    //   110	110	6	localbhkg	bhkg
    // Exception table:
    //   from	to	target	type
    //   17	28	247	java/lang/Exception
    //   31	43	247	java/lang/Exception
    //   46	58	247	java/lang/Exception
    //   61	76	247	java/lang/Exception
    //   79	86	247	java/lang/Exception
    //   89	98	247	java/lang/Exception
    //   101	112	247	java/lang/Exception
    //   115	126	247	java/lang/Exception
    //   129	148	247	java/lang/Exception
    //   151	170	247	java/lang/Exception
    //   173	192	247	java/lang/Exception
    //   195	211	247	java/lang/Exception
    //   214	230	247	java/lang/Exception
    //   233	244	247	java/lang/Exception
    //   276	288	247	java/lang/Exception
    //   291	298	247	java/lang/Exception
    //   301	307	247	java/lang/Exception
    //   314	319	321	java/io/IOException
    //   265	269	328	java/io/IOException
    //   0	14	336	finally
    //   343	347	349	java/io/IOException
    //   17	28	357	finally
    //   31	43	357	finally
    //   46	58	357	finally
    //   61	76	357	finally
    //   79	86	357	finally
    //   89	98	357	finally
    //   101	112	357	finally
    //   115	126	357	finally
    //   129	148	357	finally
    //   151	170	357	finally
    //   173	192	357	finally
    //   195	211	357	finally
    //   214	230	357	finally
    //   233	244	357	finally
    //   256	261	357	finally
    //   276	288	357	finally
    //   291	298	357	finally
    //   301	307	357	finally
    //   0	14	361	java/lang/Exception
  }
  
  private bhkg b(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      bhkg localbhkg = (bhkg)localIterator.next();
      if (localbhkg.jdField_a_of_type_Int == paramInt) {
        return localbhkg;
      }
    }
    return null;
  }
  
  public bhkg a(int paramInt)
  {
    return b(paramInt);
  }
  
  public List<bhkg> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    bhkg localbhkg = b(paramInt);
    if (localbhkg == null) {}
    do
    {
      return;
      this.jdField_a_of_type_JavaUtilList.remove(localbhkg);
    } while (!paramBoolean);
    a(a(), this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaUtilList);
  }
  
  public boolean a()
  {
    return a(a(), this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaUtilList);
  }
  
  public boolean a(bhkg parambhkg, boolean paramBoolean)
  {
    if (a(parambhkg.jdField_a_of_type_Int)) {
      return false;
    }
    this.jdField_a_of_type_JavaUtilList.add(parambhkg);
    if (paramBoolean) {
      return a();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhkf
 * JD-Core Version:    0.7.0.1
 */