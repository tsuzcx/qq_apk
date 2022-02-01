package com.tencent.biz.pubaccount.util.api.impl;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountMessageUtil;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class PublicAccountMessageUtilImpl
  implements IPublicAccountMessageUtil
{
  public static final String ITEM_ACTION_DATA = "actionData";
  public static final String ITEM_ANDROID_URL_NAME = "androidurl";
  public static final String ITEM_APPID = "appid";
  public static final String ITEM_A_ACTION_DATA = "a_actionData";
  private static final String ITEM_A_RANK_LIST_URL = "aru";
  public static final String ITEM_COVER_NAME = "cover";
  public static final String ITEM_DIGEST_NAME = "digest";
  public static final String ITEM_FLAG_NAME = "flag";
  public static final String ITEM_GRAY_TIPS = "grayTips";
  private static final String ITEM_ICONS = "icons";
  public static final String ITEM_ICON_NAME = "icon";
  public static final String ITEM_IOS_URL_NAME = "iosurl";
  public static final String ITEM_I_ACTION_DATA = "i_actionData";
  private static final String ITEM_I_RANK_LIST_URL = "iru";
  public static final String ITEM_LIST_ROOT_NAME = "appmsg";
  private static final String ITEM_MORE_TEXT = "more";
  private static final String ITEM_NATIVE_JUMP_STRING = "nativejump";
  public static final String ITEM_NEED_LOGIN = "needlogin";
  private static final String ITEM_NEW_TIME_NAME = "new_time";
  private static final String ITEM_RANK_LIST_DESC = "desc";
  private static final String ITEM_RANK_LIST_DOWNLOAD = "ard";
  private static final String ITEM_RANK_LIST_NAME = "rna";
  private static final String ITEM_RANK_LIST_SCHEMA = "irs";
  public static final String ITEM_SENDER_EMAIL_NAME = "email";
  public static final String ITEM_SENDER_NAME_NAME = "name";
  public static final String ITEM_SENDER_ROOT_NAME = "sender";
  public static final String ITEM_SOURCE_NAME = "icon";
  public static final String ITEM_STRUCT_FIRST_LEVEL_NAME = "item";
  public static final String ITEM_STRUCT_LIST_ROOT_NAME = "msg";
  public static final String ITEM_TIME_NAME = "time";
  public static final String ITEM_TITLE_NAME = "title";
  public static final String ITEM_URL_ACTION_NAME = "action";
  public static final String ITEM_URL_NAME = "url";
  private static final String ITEM_VIDEO_FLAG = "rflag";
  private static final String ITEM_WEATHER = "wea";
  private static final String ITEM_WEA_AREA = "area";
  private static final String ITEM_WEA_EURL = "e_url";
  private static final String ITEM_WEA_JURL = "j_url";
  private static final String ITEM_WEA_NWEA = "n_wea";
  private static final String ITEM_WEA_OWEA = "o_wea";
  private static final String ITEM_WEA_REAL_AD = "b_ad";
  private static final String ITEM_WEA_TEMPER = "temper";
  private static final String ITEM_WEA_TWEA = "t_wea";
  private static final String ITEM_WEA_TYPE = "t";
  public static final int MAIL_FLAG_HAS_ATTACHMENT = 1;
  public static final int MAIL_FLAG_NO_ATTACHMENT = 0;
  public static final String META_NAME = "meta";
  public static final String ROOT_NAME = "msg";
  public static final String TYPE_NAME = "type";
  public static final int TYPE_PA_APP_SHARE = 3;
  public static final int TYPE_PA_IMAGE_TEXT = 1;
  public static final int TYPE_PA_TEXT_TEXT = 2;
  
  /* Error */
  private static com.tencent.mobileqq.data.PAMessage fromStructXML(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: ifnonnull +8 -> 12
    //   7: aload 4
    //   9: astore_3
    //   10: aload_3
    //   11: areturn
    //   12: invokestatic 173	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   15: invokevirtual 177	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   18: astore 5
    //   20: aload 4
    //   22: astore_3
    //   23: aload 5
    //   25: ifnull -15 -> 10
    //   28: new 179	java/io/ByteArrayInputStream
    //   31: dup
    //   32: aload_0
    //   33: invokevirtual 185	java/lang/String:getBytes	()[B
    //   36: invokespecial 188	java/io/ByteArrayInputStream:<init>	([B)V
    //   39: astore_0
    //   40: aload 5
    //   42: aload_0
    //   43: invokevirtual 194	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   46: astore_0
    //   47: aload 4
    //   49: astore_3
    //   50: aload_0
    //   51: ifnull -41 -> 10
    //   54: aload_0
    //   55: invokeinterface 200 1 0
    //   60: astore 5
    //   62: aload 4
    //   64: astore_3
    //   65: aload 5
    //   67: invokeinterface 206 1 0
    //   72: ldc 92
    //   74: invokevirtual 210	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   77: ifeq -67 -> 10
    //   80: new 212	com/tencent/mobileqq/data/PAMessage
    //   83: dup
    //   84: invokespecial 213	com/tencent/mobileqq/data/PAMessage:<init>	()V
    //   87: astore_0
    //   88: aload_0
    //   89: new 215	java/util/ArrayList
    //   92: dup
    //   93: invokespecial 216	java/util/ArrayList:<init>	()V
    //   96: putfield 220	com/tencent/mobileqq/data/PAMessage:items	Ljava/util/ArrayList;
    //   99: aload 5
    //   101: invokeinterface 224 1 0
    //   106: astore 4
    //   108: iconst_0
    //   109: istore_1
    //   110: aload 4
    //   112: invokeinterface 230 1 0
    //   117: istore_2
    //   118: aload_0
    //   119: astore_3
    //   120: iload_1
    //   121: iload_2
    //   122: if_icmpge -112 -> 10
    //   125: aload 4
    //   127: iload_1
    //   128: invokeinterface 233 2 0
    //   133: astore_3
    //   134: aload_3
    //   135: invokestatic 237	com/tencent/biz/pubaccount/util/api/impl/PublicAccountMessageUtilImpl:getTextContent	(Lorg/w3c/dom/Node;)Ljava/lang/String;
    //   138: astore 5
    //   140: aload_3
    //   141: invokeinterface 206 1 0
    //   146: ldc 149
    //   148: invokevirtual 210	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   151: ifeq +43 -> 194
    //   154: aload_0
    //   155: aload 5
    //   157: invokestatic 243	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   160: invokevirtual 246	java/lang/Integer:intValue	()I
    //   163: putfield 248	com/tencent/mobileqq/data/PAMessage:type	I
    //   166: iload_1
    //   167: iconst_1
    //   168: iadd
    //   169: istore_1
    //   170: goto -52 -> 118
    //   173: astore_0
    //   174: aload_0
    //   175: invokevirtual 251	javax/xml/parsers/ParserConfigurationException:printStackTrace	()V
    //   178: aconst_null
    //   179: areturn
    //   180: astore_0
    //   181: aload_0
    //   182: invokevirtual 252	org/xml/sax/SAXException:printStackTrace	()V
    //   185: aconst_null
    //   186: areturn
    //   187: astore_0
    //   188: aload_0
    //   189: invokevirtual 253	java/io/IOException:printStackTrace	()V
    //   192: aconst_null
    //   193: areturn
    //   194: aload_3
    //   195: invokeinterface 206 1 0
    //   200: ldc 89
    //   202: invokevirtual 210	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   205: ifeq -39 -> 166
    //   208: aload_3
    //   209: invokestatic 257	com/tencent/biz/pubaccount/util/api/impl/PublicAccountMessageUtilImpl:parseItem	(Lorg/w3c/dom/Node;)Lcom/tencent/mobileqq/data/PAMessage$Item;
    //   212: astore_3
    //   213: aload_0
    //   214: getfield 220	com/tencent/mobileqq/data/PAMessage:items	Ljava/util/ArrayList;
    //   217: aload_3
    //   218: invokevirtual 260	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   221: pop
    //   222: goto -56 -> 166
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	225	0	paramString	String
    //   109	61	1	i	int
    //   117	6	2	j	int
    //   9	209	3	localObject1	Object
    //   1	125	4	localNodeList	NodeList
    //   18	138	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	20	173	javax/xml/parsers/ParserConfigurationException
    //   40	47	180	org/xml/sax/SAXException
    //   40	47	187	java/io/IOException
  }
  
  private static String getNodeJson(Node paramNode)
  {
    if (paramNode == null) {}
    do
    {
      return null;
      paramNode = paramNode.getChildNodes();
    } while (paramNode == null);
    JSONObject localJSONObject = new JSONObject();
    int i = 0;
    for (;;)
    {
      if (i < paramNode.getLength())
      {
        Node localNode = paramNode.item(i);
        try
        {
          localJSONObject.put(localNode.getNodeName(), getTextContent(localNode));
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
    }
    return localJSONObject.toString();
  }
  
  private static String getTextContent(Node paramNode)
  {
    if (paramNode.getNodeType() == 3) {}
    Object localObject;
    for (paramNode = paramNode.getNodeValue();; paramNode = ((StringBuilder)localObject).toString())
    {
      localObject = paramNode;
      if (paramNode == null) {
        localObject = "";
      }
      return localObject;
      localObject = new StringBuilder();
      paramNode = paramNode.getChildNodes();
      int j = paramNode.getLength();
      int i = 0;
      while (i < j)
      {
        Node localNode = paramNode.item(i);
        if (localNode.getNodeType() == 3) {
          ((StringBuilder)localObject).append(localNode.getNodeValue());
        }
        i += 1;
      }
    }
  }
  
  private static PAMessage.Item parseItem(Node paramNode)
  {
    PAMessage.Item localItem = new PAMessage.Item();
    paramNode = paramNode.getChildNodes();
    int k = paramNode.getLength();
    int i = 0;
    if (i < k)
    {
      Object localObject2 = paramNode.item(i);
      Object localObject1 = getTextContent((Node)localObject2);
      Object localObject3 = ((Node)localObject2).getNodeName();
      if (((String)localObject3).equals("cover")) {
        localItem.cover = ((String)localObject1);
      }
      for (;;)
      {
        i += 1;
        break;
        if (((String)localObject3).equals("digest"))
        {
          if (localItem.digestList == null) {
            localItem.digestList = new ArrayList();
          }
          localItem.digestList.add(localObject1);
        }
        else if (((String)localObject3).equals("title"))
        {
          localItem.title = ((String)localObject1);
          localObject1 = ((Node)localObject2).getAttributes();
          localItem.mVideoFlag = 0;
          if ((localObject1 != null) && (((NamedNodeMap)localObject1).getLength() > 0))
          {
            localObject1 = ((NamedNodeMap)localObject1).getNamedItem("rflag");
            if (localObject1 != null) {
              try
              {
                localItem.mVideoFlag = Integer.parseInt(((Node)localObject1).getNodeValue());
              }
              catch (NumberFormatException localNumberFormatException) {}
            }
          }
        }
        else if (((String)localObject3).equals("url"))
        {
          localObject2 = ((Node)localObject2).getAttributes();
          long l2;
          long l1;
          if ((localObject2 != null) && (((NamedNodeMap)localObject2).getLength() > 0))
          {
            localObject3 = ((NamedNodeMap)localObject2).getNamedItem("action");
            if (localObject3 != null) {
              localItem.actionUrl = ((Node)localObject3).getNodeValue();
            }
            localObject3 = ((NamedNodeMap)localObject2).getNamedItem("actionData");
            Node localNode2 = ((NamedNodeMap)localObject2).getNamedItem("a_actionData");
            Node localNode3 = ((NamedNodeMap)localObject2).getNamedItem("i_actionData");
            localObject2 = ((NamedNodeMap)localObject2).getNamedItem("appid");
            if (localObject3 != null) {
              localItem.actionData = ((Node)localObject3).getNodeValue();
            }
            if (localNode2 != null) {
              localItem.a_actionData = localNode2.getNodeValue();
            }
            if (localNode3 != null) {
              localItem.i_actionData = localNode3.getNodeValue();
            }
            l2 = 0L;
            l1 = l2;
            if (localObject2 != null) {
              l1 = l2;
            }
          }
          try
          {
            if (!TextUtils.isEmpty(((Node)localObject2).getNodeValue())) {
              l1 = Long.parseLong(((Node)localObject2).getNodeValue());
            }
            localItem.appId = l1;
            localItem.url = localNumberFormatException;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              l1 = l2;
              if (QLog.isColorLevel())
              {
                QLog.d(PublicAccountMessageUtilImpl.class.getSimpleName(), 2, localException.getMessage(), localException);
                l1 = l2;
              }
            }
          }
        }
        else if (((String)localObject3).equals("flag"))
        {
          localItem.flag = Integer.parseInt(localNumberFormatException);
        }
        else if (((String)localObject3).equals("icon"))
        {
          localItem.icon = localNumberFormatException;
        }
        else if (((String)localObject3).equals("icon"))
        {
          localItem.source = localNumberFormatException;
        }
        else if (((String)localObject3).equals("time"))
        {
          localItem.time = Long.valueOf(localNumberFormatException).longValue();
        }
        else
        {
          NodeList localNodeList;
          label581:
          Node localNode1;
          if (((String)localObject3).equals("sender"))
          {
            localNodeList = localException.getChildNodes();
            int m = localNodeList.getLength();
            int j = 0;
            if (j < m)
            {
              localNode1 = localNodeList.item(j);
              localObject3 = localNode1.getNodeName();
              if (!((String)localObject3).equals("email")) {
                break label635;
              }
              localItem.senderEmail = localNode1.getNodeValue();
            }
            for (;;)
            {
              j += 1;
              break label581;
              break;
              label635:
              if (((String)localObject3).equals("name")) {
                localItem.senderName = localNode1.getNodeValue();
              }
            }
          }
          if (((String)localObject3).equals("androidurl")) {
            localItem.androidUrl = localNodeList;
          } else if (((String)localObject3).equals("iosurl")) {
            localItem.iosUrl = localNodeList;
          } else if (((String)localObject3).equals("needlogin"))
          {
            if (Integer.valueOf(localNodeList).intValue() == 1) {
              localItem.needLogin = true;
            }
          }
          else if (((String)localObject3).equals("nativejump")) {
            localItem.nativeJumpString = localNodeList;
          } else if (((String)localObject3).equals("icons")) {
            localItem.iconsString = localNodeList;
          } else if (((String)localObject3).equals("rna")) {
            localItem.rankListName = localNodeList;
          } else if (((String)localObject3).equals("aru")) {
            localItem.a_rankListUrl = getNodeJson(localNode1);
          } else if (((String)localObject3).equals("iru")) {
            localItem.i_rankListUrl = localNodeList;
          } else if (((String)localObject3).equals("ard")) {
            localItem.rankListDownload = getNodeJson(localNode1);
          } else if (((String)localObject3).equals("irs")) {
            localItem.rankListSchema = localNodeList;
          } else if (((String)localObject3).equals("desc")) {
            localItem.desc = localNodeList;
          } else if (((String)localObject3).equals("area")) {
            localItem.weaArea = localNodeList;
          } else if (((String)localObject3).equals("temper")) {
            localItem.weaTemper = localNodeList;
          } else if (((String)localObject3).equals("wea")) {
            localItem.weather = localNodeList;
          } else if (((String)localObject3).equals("o_wea")) {
            localItem.oneWeather = localNodeList;
          } else if (((String)localObject3).equals("t_wea")) {
            localItem.twoWeather = localNodeList;
          } else if (((String)localObject3).equals("j_url")) {
            localItem.weaJumpUrl = localNodeList;
          } else if (((String)localObject3).equals("e_url")) {
            localItem.weaExposeUrl = localNodeList;
          } else if (((String)localObject3).equals("t")) {
            localItem.type = localNodeList;
          } else if (((String)localObject3).equals("new_time")) {
            localItem.time = Long.valueOf(localNodeList).longValue();
          } else if (((String)localObject3).equals("b_ad")) {
            localItem.isAd = localNodeList;
          } else if (((String)localObject3).equals("n_wea")) {
            localItem.nowTime = localNodeList;
          }
        }
      }
    }
    return localItem;
  }
  
  /* Error */
  public com.tencent.mobileqq.data.PAMessage fromByteArray(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 179	java/io/ByteArrayInputStream
    //   9: dup
    //   10: aload_1
    //   11: invokespecial 188	java/io/ByteArrayInputStream:<init>	([B)V
    //   14: astore 4
    //   16: new 464	java/io/ObjectInputStream
    //   19: dup
    //   20: aload 4
    //   22: invokespecial 467	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   25: astore_2
    //   26: aload_2
    //   27: astore_1
    //   28: aload_2
    //   29: invokevirtual 471	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   32: checkcast 212	com/tencent/mobileqq/data/PAMessage
    //   35: astore_3
    //   36: aload_2
    //   37: ifnull +7 -> 44
    //   40: aload_2
    //   41: invokevirtual 474	java/io/ObjectInputStream:close	()V
    //   44: aload 4
    //   46: invokevirtual 475	java/io/ByteArrayInputStream:close	()V
    //   49: aload_3
    //   50: astore_1
    //   51: aload_1
    //   52: areturn
    //   53: astore_1
    //   54: aload_1
    //   55: invokevirtual 253	java/io/IOException:printStackTrace	()V
    //   58: aload_3
    //   59: astore_1
    //   60: goto -9 -> 51
    //   63: astore_1
    //   64: aconst_null
    //   65: astore_1
    //   66: aload_1
    //   67: ifnull +7 -> 74
    //   70: aload_1
    //   71: invokevirtual 474	java/io/ObjectInputStream:close	()V
    //   74: aload 4
    //   76: invokevirtual 475	java/io/ByteArrayInputStream:close	()V
    //   79: aconst_null
    //   80: astore_1
    //   81: goto -30 -> 51
    //   84: astore_1
    //   85: aload_1
    //   86: invokevirtual 253	java/io/IOException:printStackTrace	()V
    //   89: aconst_null
    //   90: astore_1
    //   91: goto -40 -> 51
    //   94: astore_3
    //   95: aconst_null
    //   96: astore_2
    //   97: aload_2
    //   98: astore_1
    //   99: aload_3
    //   100: invokevirtual 476	java/lang/ClassNotFoundException:printStackTrace	()V
    //   103: aload_2
    //   104: ifnull +7 -> 111
    //   107: aload_2
    //   108: invokevirtual 474	java/io/ObjectInputStream:close	()V
    //   111: aload 4
    //   113: invokevirtual 475	java/io/ByteArrayInputStream:close	()V
    //   116: aconst_null
    //   117: astore_1
    //   118: goto -67 -> 51
    //   121: astore_1
    //   122: aload_1
    //   123: invokevirtual 253	java/io/IOException:printStackTrace	()V
    //   126: aconst_null
    //   127: astore_1
    //   128: goto -77 -> 51
    //   131: astore_3
    //   132: aconst_null
    //   133: astore_2
    //   134: aload_2
    //   135: astore_1
    //   136: aload_3
    //   137: invokevirtual 477	java/lang/OutOfMemoryError:printStackTrace	()V
    //   140: aload_2
    //   141: ifnull +7 -> 148
    //   144: aload_2
    //   145: invokevirtual 474	java/io/ObjectInputStream:close	()V
    //   148: aload 4
    //   150: invokevirtual 475	java/io/ByteArrayInputStream:close	()V
    //   153: aconst_null
    //   154: astore_1
    //   155: goto -104 -> 51
    //   158: astore_1
    //   159: aload_1
    //   160: invokevirtual 253	java/io/IOException:printStackTrace	()V
    //   163: aconst_null
    //   164: astore_1
    //   165: goto -114 -> 51
    //   168: astore_3
    //   169: aconst_null
    //   170: astore_2
    //   171: aload_2
    //   172: astore_1
    //   173: aload_3
    //   174: invokevirtual 271	java/lang/Exception:printStackTrace	()V
    //   177: aload_2
    //   178: ifnull +7 -> 185
    //   181: aload_2
    //   182: invokevirtual 474	java/io/ObjectInputStream:close	()V
    //   185: aload 4
    //   187: invokevirtual 475	java/io/ByteArrayInputStream:close	()V
    //   190: aconst_null
    //   191: astore_1
    //   192: goto -141 -> 51
    //   195: astore_1
    //   196: aload_1
    //   197: invokevirtual 253	java/io/IOException:printStackTrace	()V
    //   200: aconst_null
    //   201: astore_1
    //   202: goto -151 -> 51
    //   205: astore_2
    //   206: aconst_null
    //   207: astore_1
    //   208: aload_1
    //   209: ifnull +7 -> 216
    //   212: aload_1
    //   213: invokevirtual 474	java/io/ObjectInputStream:close	()V
    //   216: aload 4
    //   218: invokevirtual 475	java/io/ByteArrayInputStream:close	()V
    //   221: aload_2
    //   222: athrow
    //   223: astore_1
    //   224: aload_1
    //   225: invokevirtual 253	java/io/IOException:printStackTrace	()V
    //   228: goto -7 -> 221
    //   231: astore_2
    //   232: goto -24 -> 208
    //   235: astore_3
    //   236: goto -65 -> 171
    //   239: astore_3
    //   240: goto -106 -> 134
    //   243: astore_3
    //   244: goto -147 -> 97
    //   247: astore_1
    //   248: aload_2
    //   249: astore_1
    //   250: goto -184 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	253	0	this	PublicAccountMessageUtilImpl
    //   0	253	1	paramArrayOfByte	byte[]
    //   25	157	2	localObjectInputStream	java.io.ObjectInputStream
    //   205	17	2	localObject1	Object
    //   231	18	2	localObject2	Object
    //   35	24	3	localPAMessage	com.tencent.mobileqq.data.PAMessage
    //   94	6	3	localClassNotFoundException1	java.lang.ClassNotFoundException
    //   131	6	3	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   168	6	3	localException1	Exception
    //   235	1	3	localException2	Exception
    //   239	1	3	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   243	1	3	localClassNotFoundException2	java.lang.ClassNotFoundException
    //   14	203	4	localByteArrayInputStream	java.io.ByteArrayInputStream
    // Exception table:
    //   from	to	target	type
    //   40	44	53	java/io/IOException
    //   44	49	53	java/io/IOException
    //   16	26	63	java/io/IOException
    //   70	74	84	java/io/IOException
    //   74	79	84	java/io/IOException
    //   16	26	94	java/lang/ClassNotFoundException
    //   107	111	121	java/io/IOException
    //   111	116	121	java/io/IOException
    //   16	26	131	java/lang/OutOfMemoryError
    //   144	148	158	java/io/IOException
    //   148	153	158	java/io/IOException
    //   16	26	168	java/lang/Exception
    //   181	185	195	java/io/IOException
    //   185	190	195	java/io/IOException
    //   16	26	205	finally
    //   212	216	223	java/io/IOException
    //   216	221	223	java/io/IOException
    //   28	36	231	finally
    //   99	103	231	finally
    //   136	140	231	finally
    //   173	177	231	finally
    //   28	36	235	java/lang/Exception
    //   28	36	239	java/lang/OutOfMemoryError
    //   28	36	243	java/lang/ClassNotFoundException
    //   28	36	247	java/io/IOException
  }
  
  /* Error */
  public com.tencent.mobileqq.data.PAMessage fromXML(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aload_1
    //   4: ifnonnull +10 -> 14
    //   7: aload 7
    //   9: astore 6
    //   11: aload 6
    //   13: areturn
    //   14: invokestatic 173	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   17: invokevirtual 177	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   20: astore 8
    //   22: aload 7
    //   24: astore 6
    //   26: aload 8
    //   28: ifnull -17 -> 11
    //   31: new 179	java/io/ByteArrayInputStream
    //   34: dup
    //   35: aload_1
    //   36: invokevirtual 185	java/lang/String:getBytes	()[B
    //   39: invokespecial 188	java/io/ByteArrayInputStream:<init>	([B)V
    //   42: astore_1
    //   43: aload 8
    //   45: aload_1
    //   46: invokevirtual 194	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   49: astore_1
    //   50: aload 7
    //   52: astore 6
    //   54: aload_1
    //   55: ifnull -44 -> 11
    //   58: aload_1
    //   59: invokeinterface 200 1 0
    //   64: astore 6
    //   66: new 212	com/tencent/mobileqq/data/PAMessage
    //   69: dup
    //   70: invokespecial 213	com/tencent/mobileqq/data/PAMessage:<init>	()V
    //   73: astore_1
    //   74: aload_1
    //   75: new 215	java/util/ArrayList
    //   78: dup
    //   79: invokespecial 216	java/util/ArrayList:<init>	()V
    //   82: putfield 220	com/tencent/mobileqq/data/PAMessage:items	Ljava/util/ArrayList;
    //   85: aload 6
    //   87: invokeinterface 224 1 0
    //   92: astore 7
    //   94: aload 7
    //   96: invokeinterface 230 1 0
    //   101: istore 4
    //   103: iconst_0
    //   104: istore_2
    //   105: aload_1
    //   106: astore 6
    //   108: iload_2
    //   109: iload 4
    //   111: if_icmpge -100 -> 11
    //   114: aload 7
    //   116: iload_2
    //   117: invokeinterface 233 2 0
    //   122: astore 6
    //   124: aload 6
    //   126: invokestatic 237	com/tencent/biz/pubaccount/util/api/impl/PublicAccountMessageUtilImpl:getTextContent	(Lorg/w3c/dom/Node;)Ljava/lang/String;
    //   129: astore 8
    //   131: aload 6
    //   133: invokeinterface 206 1 0
    //   138: ldc 149
    //   140: invokevirtual 210	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   143: ifeq +43 -> 186
    //   146: aload_1
    //   147: aload 8
    //   149: invokestatic 243	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   152: invokevirtual 246	java/lang/Integer:intValue	()I
    //   155: putfield 248	com/tencent/mobileqq/data/PAMessage:type	I
    //   158: iload_2
    //   159: iconst_1
    //   160: iadd
    //   161: istore_2
    //   162: goto -57 -> 105
    //   165: astore_1
    //   166: aload_1
    //   167: invokevirtual 251	javax/xml/parsers/ParserConfigurationException:printStackTrace	()V
    //   170: aconst_null
    //   171: areturn
    //   172: astore_1
    //   173: aload_1
    //   174: invokevirtual 252	org/xml/sax/SAXException:printStackTrace	()V
    //   177: aconst_null
    //   178: areturn
    //   179: astore_1
    //   180: aload_1
    //   181: invokevirtual 253	java/io/IOException:printStackTrace	()V
    //   184: aconst_null
    //   185: areturn
    //   186: aload 6
    //   188: invokeinterface 206 1 0
    //   193: ldc 52
    //   195: invokevirtual 210	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   198: ifeq +74 -> 272
    //   201: aload 6
    //   203: invokeinterface 224 1 0
    //   208: astore 6
    //   210: aload 6
    //   212: invokeinterface 230 1 0
    //   217: istore 5
    //   219: iconst_0
    //   220: istore_3
    //   221: iload_3
    //   222: iload 5
    //   224: if_icmpge -66 -> 158
    //   227: aload 6
    //   229: iload_3
    //   230: invokeinterface 233 2 0
    //   235: astore 8
    //   237: aload 8
    //   239: invokeinterface 278 1 0
    //   244: iconst_1
    //   245: if_icmpne +20 -> 265
    //   248: aload 8
    //   250: invokestatic 257	com/tencent/biz/pubaccount/util/api/impl/PublicAccountMessageUtilImpl:parseItem	(Lorg/w3c/dom/Node;)Lcom/tencent/mobileqq/data/PAMessage$Item;
    //   253: astore 8
    //   255: aload_1
    //   256: getfield 220	com/tencent/mobileqq/data/PAMessage:items	Ljava/util/ArrayList;
    //   259: aload 8
    //   261: invokevirtual 260	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   264: pop
    //   265: iload_3
    //   266: iconst_1
    //   267: iadd
    //   268: istore_3
    //   269: goto -48 -> 221
    //   272: aload 6
    //   274: invokeinterface 206 1 0
    //   279: ldc 145
    //   281: invokevirtual 210	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   284: ifeq -126 -> 158
    //   287: aload 6
    //   289: invokeinterface 224 1 0
    //   294: astore 6
    //   296: aload 6
    //   298: invokeinterface 230 1 0
    //   303: istore 5
    //   305: iconst_0
    //   306: istore_3
    //   307: iload_3
    //   308: iload 5
    //   310: if_icmpge -152 -> 158
    //   313: aload 6
    //   315: iload_3
    //   316: invokeinterface 233 2 0
    //   321: astore 9
    //   323: aload 9
    //   325: invokestatic 237	com/tencent/biz/pubaccount/util/api/impl/PublicAccountMessageUtilImpl:getTextContent	(Lorg/w3c/dom/Node;)Ljava/lang/String;
    //   328: astore 8
    //   330: aload 9
    //   332: invokeinterface 206 1 0
    //   337: astore 9
    //   339: aload 9
    //   341: ldc 95
    //   343: invokevirtual 482	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   346: ifeq +22 -> 368
    //   349: aload_1
    //   350: aload 8
    //   352: invokestatic 380	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   355: invokevirtual 384	java/lang/Long:longValue	()J
    //   358: putfield 485	com/tencent/mobileqq/data/PAMessage:sendTime	J
    //   361: iload_3
    //   362: iconst_1
    //   363: iadd
    //   364: istore_3
    //   365: goto -58 -> 307
    //   368: aload 9
    //   370: ldc 55
    //   372: invokevirtual 482	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   375: ifeq +12 -> 387
    //   378: aload_1
    //   379: aload 8
    //   381: putfield 488	com/tencent/mobileqq/data/PAMessage:moreText	Ljava/lang/String;
    //   384: goto -23 -> 361
    //   387: aload 9
    //   389: ldc 34
    //   391: invokevirtual 482	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   394: ifeq -33 -> 361
    //   397: aload_1
    //   398: aload 8
    //   400: putfield 490	com/tencent/mobileqq/data/PAMessage:grayTips	Ljava/lang/String;
    //   403: goto -42 -> 361
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	406	0	this	PublicAccountMessageUtilImpl
    //   0	406	1	paramString	String
    //   104	58	2	i	int
    //   220	145	3	j	int
    //   101	11	4	k	int
    //   217	94	5	m	int
    //   9	305	6	localObject1	Object
    //   1	114	7	localNodeList	NodeList
    //   20	379	8	localObject2	Object
    //   321	67	9	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   14	22	165	javax/xml/parsers/ParserConfigurationException
    //   43	50	172	org/xml/sax/SAXException
    //   43	50	179	java/io/IOException
  }
  
  public boolean jumpNative(String paramString, Context paramContext)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    new Bundle();
    Uri.parse(paramString).getPath();
    return false;
  }
  
  /* Error */
  public byte[] toByteArray(com.tencent.mobileqq.data.PAMessage paramPAMessage)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 507	java/io/ByteArrayOutputStream
    //   9: dup
    //   10: invokespecial 508	java/io/ByteArrayOutputStream:<init>	()V
    //   13: astore 4
    //   15: new 510	java/io/ObjectOutputStream
    //   18: dup
    //   19: aload 4
    //   21: invokespecial 513	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   24: astore_3
    //   25: aload_3
    //   26: astore_2
    //   27: aload_3
    //   28: aload_1
    //   29: invokevirtual 517	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   32: aload_3
    //   33: astore_2
    //   34: aload 4
    //   36: invokevirtual 519	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   39: astore_1
    //   40: aload_3
    //   41: ifnull +7 -> 48
    //   44: aload_3
    //   45: invokevirtual 520	java/io/ObjectOutputStream:close	()V
    //   48: aload 4
    //   50: invokevirtual 521	java/io/ByteArrayOutputStream:close	()V
    //   53: aload_1
    //   54: areturn
    //   55: astore_2
    //   56: aload_2
    //   57: invokevirtual 253	java/io/IOException:printStackTrace	()V
    //   60: aload_1
    //   61: areturn
    //   62: astore_1
    //   63: aconst_null
    //   64: astore_3
    //   65: aload_3
    //   66: astore_2
    //   67: aload_1
    //   68: invokevirtual 477	java/lang/OutOfMemoryError:printStackTrace	()V
    //   71: aload_3
    //   72: ifnull +7 -> 79
    //   75: aload_3
    //   76: invokevirtual 520	java/io/ObjectOutputStream:close	()V
    //   79: aload 4
    //   81: invokevirtual 521	java/io/ByteArrayOutputStream:close	()V
    //   84: aconst_null
    //   85: areturn
    //   86: astore_1
    //   87: aload_1
    //   88: invokevirtual 253	java/io/IOException:printStackTrace	()V
    //   91: aconst_null
    //   92: areturn
    //   93: astore_1
    //   94: aconst_null
    //   95: astore_3
    //   96: aload_3
    //   97: astore_2
    //   98: aload_1
    //   99: invokevirtual 253	java/io/IOException:printStackTrace	()V
    //   102: aload_3
    //   103: ifnull +7 -> 110
    //   106: aload_3
    //   107: invokevirtual 520	java/io/ObjectOutputStream:close	()V
    //   110: aload 4
    //   112: invokevirtual 521	java/io/ByteArrayOutputStream:close	()V
    //   115: aconst_null
    //   116: areturn
    //   117: astore_1
    //   118: aload_1
    //   119: invokevirtual 253	java/io/IOException:printStackTrace	()V
    //   122: aconst_null
    //   123: areturn
    //   124: astore_1
    //   125: aconst_null
    //   126: astore_2
    //   127: aload_2
    //   128: ifnull +7 -> 135
    //   131: aload_2
    //   132: invokevirtual 520	java/io/ObjectOutputStream:close	()V
    //   135: aload 4
    //   137: invokevirtual 521	java/io/ByteArrayOutputStream:close	()V
    //   140: aload_1
    //   141: athrow
    //   142: astore_2
    //   143: aload_2
    //   144: invokevirtual 253	java/io/IOException:printStackTrace	()V
    //   147: goto -7 -> 140
    //   150: astore_1
    //   151: goto -24 -> 127
    //   154: astore_1
    //   155: goto -59 -> 96
    //   158: astore_1
    //   159: goto -94 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	162	0	this	PublicAccountMessageUtilImpl
    //   0	162	1	paramPAMessage	com.tencent.mobileqq.data.PAMessage
    //   26	8	2	localObjectOutputStream1	java.io.ObjectOutputStream
    //   55	2	2	localIOException1	java.io.IOException
    //   66	66	2	localObjectOutputStream2	java.io.ObjectOutputStream
    //   142	2	2	localIOException2	java.io.IOException
    //   24	83	3	localObjectOutputStream3	java.io.ObjectOutputStream
    //   13	123	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   44	48	55	java/io/IOException
    //   48	53	55	java/io/IOException
    //   15	25	62	java/lang/OutOfMemoryError
    //   75	79	86	java/io/IOException
    //   79	84	86	java/io/IOException
    //   15	25	93	java/io/IOException
    //   106	110	117	java/io/IOException
    //   110	115	117	java/io/IOException
    //   15	25	124	finally
    //   131	135	142	java/io/IOException
    //   135	140	142	java/io/IOException
    //   27	32	150	finally
    //   34	40	150	finally
    //   67	71	150	finally
    //   98	102	150	finally
    //   27	32	154	java/io/IOException
    //   34	40	154	java/io/IOException
    //   27	32	158	java/lang/OutOfMemoryError
    //   34	40	158	java/lang/OutOfMemoryError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl
 * JD-Core Version:    0.7.0.1
 */