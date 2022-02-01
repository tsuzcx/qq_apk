package com.tencent.biz.pubaccount.util.api.impl;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountMessageUtil;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

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
  
  private static PAMessage fromStructXML(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      Object localObject1 = DocumentBuilderFactory.newInstance().newDocumentBuilder();
      if (localObject1 == null) {
        return null;
      }
      paramString = new ByteArrayInputStream(paramString.getBytes());
      try
      {
        paramString = ((DocumentBuilder)localObject1).parse(paramString);
        if (paramString == null) {
          return null;
        }
        localObject1 = paramString.getFirstChild();
        if (!((Node)localObject1).getNodeName().equals("msg")) {
          return null;
        }
        paramString = new PAMessage();
        paramString.items = new ArrayList();
        localObject1 = ((Node)localObject1).getChildNodes();
        int i = 0;
        int j = ((NodeList)localObject1).getLength();
        while (i < j)
        {
          Object localObject2 = ((NodeList)localObject1).item(i);
          String str = getTextContent((Node)localObject2);
          if (((Node)localObject2).getNodeName().equals("type"))
          {
            paramString.type = Integer.valueOf(str).intValue();
          }
          else if (((Node)localObject2).getNodeName().equals("item"))
          {
            localObject2 = parseItem((Node)localObject2);
            paramString.items.add(localObject2);
          }
          i += 1;
        }
        return paramString;
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      catch (SAXException paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      return null;
    }
    catch (ParserConfigurationException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private static String getNodeJson(Node paramNode)
  {
    if (paramNode == null) {
      return null;
    }
    paramNode = paramNode.getChildNodes();
    if (paramNode == null) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    int i = 0;
    while (i < paramNode.getLength())
    {
      Node localNode = paramNode.item(i);
      try
      {
        localJSONObject.put(localNode.getNodeName(), getTextContent(localNode));
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      i += 1;
    }
    return localJSONObject.toString();
  }
  
  private static String getTextContent(Node paramNode)
  {
    if (paramNode.getNodeType() == 3)
    {
      paramNode = paramNode.getNodeValue();
    }
    else
    {
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
      paramNode = ((StringBuilder)localObject).toString();
    }
    Object localObject = paramNode;
    if (paramNode == null) {
      localObject = "";
    }
    return localObject;
  }
  
  private static PAMessage.Item parseItem(Node paramNode)
  {
    PAMessage.Item localItem = new PAMessage.Item();
    paramNode = paramNode.getChildNodes();
    int k = paramNode.getLength();
    int i = 0;
    while (i < k)
    {
      Object localObject2 = paramNode.item(i);
      Object localObject1 = getTextContent((Node)localObject2);
      Object localObject3 = ((Node)localObject2).getNodeName();
      if (((String)localObject3).equals("cover"))
      {
        localItem.cover = ((String)localObject1);
      }
      else if (((String)localObject3).equals("digest"))
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
        if ((localObject1 == null) || (((NamedNodeMap)localObject1).getLength() <= 0)) {
          break label1111;
        }
        localObject1 = ((NamedNodeMap)localObject1).getNamedItem("rflag");
        if (localObject1 == null) {
          break label1111;
        }
      }
      try
      {
        localItem.mVideoFlag = Integer.parseInt(((Node)localObject1).getNodeValue());
      }
      catch (NumberFormatException localNumberFormatException)
      {
        Node localNode2;
        Node localNode3;
        long l2;
        long l1;
        int m;
        int j;
        Node localNode1;
        break label1111;
      }
      if (((String)localObject3).equals("url"))
      {
        localObject2 = ((Node)localObject2).getAttributes();
        if ((localObject2 != null) && (((NamedNodeMap)localObject2).getLength() > 0))
        {
          localObject3 = ((NamedNodeMap)localObject2).getNamedItem("action");
          if (localObject3 != null) {
            localItem.actionUrl = ((Node)localObject3).getNodeValue();
          }
          localObject3 = ((NamedNodeMap)localObject2).getNamedItem("actionData");
          localNode2 = ((NamedNodeMap)localObject2).getNamedItem("a_actionData");
          localNode3 = ((NamedNodeMap)localObject2).getNamedItem("i_actionData");
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
          if (localObject2 != null)
          {
            l1 = l2;
            try
            {
              if (!TextUtils.isEmpty(((Node)localObject2).getNodeValue())) {
                l1 = Long.parseLong(((Node)localObject2).getNodeValue());
              }
            }
            catch (Exception localException)
            {
              l1 = l2;
              if (QLog.isColorLevel())
              {
                QLog.d(PublicAccountMessageUtilImpl.class.getSimpleName(), 2, localException.getMessage(), localException);
                l1 = l2;
              }
            }
          }
          localItem.appId = l1;
        }
        localItem.url = ((String)localObject1);
      }
      else if (((String)localObject3).equals("flag"))
      {
        localItem.flag = Integer.parseInt((String)localObject1);
      }
      else if (((String)localObject3).equals("icon"))
      {
        localItem.icon = ((String)localObject1);
      }
      else if (((String)localObject3).equals("icon"))
      {
        localItem.source = ((String)localObject1);
      }
      else if (((String)localObject3).equals("time"))
      {
        localItem.time = Long.valueOf((String)localObject1).longValue();
      }
      else
      {
        if (((String)localObject3).equals("sender"))
        {
          localObject1 = localException.getChildNodes();
          m = ((NodeList)localObject1).getLength();
          j = 0;
          while (j < m)
          {
            localNode1 = ((NodeList)localObject1).item(j);
            localObject3 = localNode1.getNodeName();
            if (((String)localObject3).equals("email")) {
              localItem.senderEmail = localNode1.getNodeValue();
            } else if (((String)localObject3).equals("name")) {
              localItem.senderName = localNode1.getNodeValue();
            }
            j += 1;
          }
        }
        if (((String)localObject3).equals("androidurl")) {
          localItem.androidUrl = ((String)localObject1);
        } else if (((String)localObject3).equals("iosurl")) {
          localItem.iosUrl = ((String)localObject1);
        } else if (((String)localObject3).equals("needlogin"))
        {
          if (Integer.valueOf((String)localObject1).intValue() == 1) {
            localItem.needLogin = true;
          }
        }
        else if (((String)localObject3).equals("nativejump")) {
          localItem.nativeJumpString = ((String)localObject1);
        } else if (((String)localObject3).equals("icons")) {
          localItem.iconsString = ((String)localObject1);
        } else if (((String)localObject3).equals("rna")) {
          localItem.rankListName = ((String)localObject1);
        } else if (((String)localObject3).equals("aru")) {
          localItem.a_rankListUrl = getNodeJson(localNode1);
        } else if (((String)localObject3).equals("iru")) {
          localItem.i_rankListUrl = ((String)localObject1);
        } else if (((String)localObject3).equals("ard")) {
          localItem.rankListDownload = getNodeJson(localNode1);
        } else if (((String)localObject3).equals("irs")) {
          localItem.rankListSchema = ((String)localObject1);
        } else if (((String)localObject3).equals("desc")) {
          localItem.desc = ((String)localObject1);
        } else if (((String)localObject3).equals("area")) {
          localItem.weaArea = ((String)localObject1);
        } else if (((String)localObject3).equals("temper")) {
          localItem.weaTemper = ((String)localObject1);
        } else if (((String)localObject3).equals("wea")) {
          localItem.weather = ((String)localObject1);
        } else if (((String)localObject3).equals("o_wea")) {
          localItem.oneWeather = ((String)localObject1);
        } else if (((String)localObject3).equals("t_wea")) {
          localItem.twoWeather = ((String)localObject1);
        } else if (((String)localObject3).equals("j_url")) {
          localItem.weaJumpUrl = ((String)localObject1);
        } else if (((String)localObject3).equals("e_url")) {
          localItem.weaExposeUrl = ((String)localObject1);
        } else if (((String)localObject3).equals("t")) {
          localItem.type = ((String)localObject1);
        } else if (((String)localObject3).equals("new_time")) {
          localItem.time = Long.valueOf((String)localObject1).longValue();
        } else if (((String)localObject3).equals("b_ad")) {
          localItem.isAd = ((String)localObject1);
        } else if (((String)localObject3).equals("n_wea")) {
          localItem.nowTime = ((String)localObject1);
        }
      }
      label1111:
      i += 1;
    }
    return localItem;
  }
  
  /* Error */
  public Object fromByteArray(byte[] paramArrayOfByte)
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
    //   25: astore_1
    //   26: aload_1
    //   27: astore_2
    //   28: aload_1
    //   29: invokevirtual 471	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   32: checkcast 212	com/tencent/mobileqq/data/PAMessage
    //   35: astore_3
    //   36: aload_1
    //   37: invokevirtual 474	java/io/ObjectInputStream:close	()V
    //   40: aload 4
    //   42: invokevirtual 475	java/io/ByteArrayInputStream:close	()V
    //   45: goto +8 -> 53
    //   48: astore_1
    //   49: aload_1
    //   50: invokevirtual 258	java/io/IOException:printStackTrace	()V
    //   53: aload_3
    //   54: areturn
    //   55: astore_3
    //   56: goto +20 -> 76
    //   59: astore_3
    //   60: goto +40 -> 100
    //   63: astore_3
    //   64: goto +60 -> 124
    //   67: astore_1
    //   68: aconst_null
    //   69: astore_2
    //   70: goto +76 -> 146
    //   73: astore_3
    //   74: aconst_null
    //   75: astore_1
    //   76: aload_1
    //   77: astore_2
    //   78: aload_3
    //   79: invokevirtual 271	java/lang/Exception:printStackTrace	()V
    //   82: aload_1
    //   83: ifnull +7 -> 90
    //   86: aload_1
    //   87: invokevirtual 474	java/io/ObjectInputStream:close	()V
    //   90: aload 4
    //   92: invokevirtual 475	java/io/ByteArrayInputStream:close	()V
    //   95: aconst_null
    //   96: areturn
    //   97: astore_3
    //   98: aconst_null
    //   99: astore_1
    //   100: aload_1
    //   101: astore_2
    //   102: aload_3
    //   103: invokevirtual 476	java/lang/OutOfMemoryError:printStackTrace	()V
    //   106: aload_1
    //   107: ifnull +7 -> 114
    //   110: aload_1
    //   111: invokevirtual 474	java/io/ObjectInputStream:close	()V
    //   114: aload 4
    //   116: invokevirtual 475	java/io/ByteArrayInputStream:close	()V
    //   119: aconst_null
    //   120: areturn
    //   121: astore_3
    //   122: aconst_null
    //   123: astore_1
    //   124: aload_1
    //   125: astore_2
    //   126: aload_3
    //   127: invokevirtual 477	java/lang/ClassNotFoundException:printStackTrace	()V
    //   130: aload_1
    //   131: ifnull +7 -> 138
    //   134: aload_1
    //   135: invokevirtual 474	java/io/ObjectInputStream:close	()V
    //   138: aload 4
    //   140: invokevirtual 475	java/io/ByteArrayInputStream:close	()V
    //   143: aconst_null
    //   144: areturn
    //   145: astore_1
    //   146: aload_2
    //   147: ifnull +7 -> 154
    //   150: aload_2
    //   151: invokevirtual 474	java/io/ObjectInputStream:close	()V
    //   154: aload 4
    //   156: invokevirtual 475	java/io/ByteArrayInputStream:close	()V
    //   159: goto +8 -> 167
    //   162: astore_2
    //   163: aload_2
    //   164: invokevirtual 258	java/io/IOException:printStackTrace	()V
    //   167: aload_1
    //   168: athrow
    //   169: aconst_null
    //   170: astore_1
    //   171: aload_1
    //   172: ifnull +7 -> 179
    //   175: aload_1
    //   176: invokevirtual 474	java/io/ObjectInputStream:close	()V
    //   179: aload 4
    //   181: invokevirtual 475	java/io/ByteArrayInputStream:close	()V
    //   184: aconst_null
    //   185: areturn
    //   186: astore_1
    //   187: aload_1
    //   188: invokevirtual 258	java/io/IOException:printStackTrace	()V
    //   191: aconst_null
    //   192: areturn
    //   193: astore_1
    //   194: goto -25 -> 169
    //   197: astore_2
    //   198: goto -27 -> 171
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	201	0	this	PublicAccountMessageUtilImpl
    //   0	201	1	paramArrayOfByte	byte[]
    //   27	124	2	arrayOfByte	byte[]
    //   162	2	2	localIOException1	IOException
    //   197	1	2	localIOException2	IOException
    //   35	19	3	localPAMessage	PAMessage
    //   55	1	3	localException1	Exception
    //   59	1	3	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   63	1	3	localClassNotFoundException1	java.lang.ClassNotFoundException
    //   73	6	3	localException2	Exception
    //   97	6	3	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   121	6	3	localClassNotFoundException2	java.lang.ClassNotFoundException
    //   14	166	4	localByteArrayInputStream	ByteArrayInputStream
    // Exception table:
    //   from	to	target	type
    //   36	45	48	java/io/IOException
    //   28	36	55	java/lang/Exception
    //   28	36	59	java/lang/OutOfMemoryError
    //   28	36	63	java/lang/ClassNotFoundException
    //   16	26	67	finally
    //   16	26	73	java/lang/Exception
    //   16	26	97	java/lang/OutOfMemoryError
    //   16	26	121	java/lang/ClassNotFoundException
    //   28	36	145	finally
    //   78	82	145	finally
    //   102	106	145	finally
    //   126	130	145	finally
    //   150	154	162	java/io/IOException
    //   154	159	162	java/io/IOException
    //   86	90	186	java/io/IOException
    //   90	95	186	java/io/IOException
    //   110	114	186	java/io/IOException
    //   114	119	186	java/io/IOException
    //   134	138	186	java/io/IOException
    //   138	143	186	java/io/IOException
    //   175	179	186	java/io/IOException
    //   179	184	186	java/io/IOException
    //   16	26	193	java/io/IOException
    //   28	36	197	java/io/IOException
  }
  
  public Object fromXML(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      Object localObject1 = DocumentBuilderFactory.newInstance().newDocumentBuilder();
      if (localObject1 == null) {
        return null;
      }
      paramString = new ByteArrayInputStream(paramString.getBytes());
      try
      {
        paramString = ((DocumentBuilder)localObject1).parse(paramString);
        if (paramString == null) {
          return null;
        }
        localObject1 = paramString.getFirstChild();
        paramString = new PAMessage();
        paramString.items = new ArrayList();
        localObject1 = ((Node)localObject1).getChildNodes();
        int k = ((NodeList)localObject1).getLength();
        int i = 0;
        while (i < k)
        {
          Object localObject2 = ((NodeList)localObject1).item(i);
          Object localObject3 = getTextContent((Node)localObject2);
          if (((Node)localObject2).getNodeName().equals("type"))
          {
            paramString.type = Integer.valueOf((String)localObject3).intValue();
          }
          else
          {
            int m;
            int j;
            if (((Node)localObject2).getNodeName().equals("appmsg"))
            {
              localObject2 = ((Node)localObject2).getChildNodes();
              m = ((NodeList)localObject2).getLength();
              j = 0;
              while (j < m)
              {
                localObject3 = ((NodeList)localObject2).item(j);
                if (((Node)localObject3).getNodeType() == 1)
                {
                  localObject3 = parseItem((Node)localObject3);
                  paramString.items.add(localObject3);
                }
                j += 1;
              }
            }
            if (((Node)localObject2).getNodeName().equals("meta"))
            {
              localObject2 = ((Node)localObject2).getChildNodes();
              m = ((NodeList)localObject2).getLength();
              j = 0;
              while (j < m)
              {
                Object localObject4 = ((NodeList)localObject2).item(j);
                localObject3 = getTextContent((Node)localObject4);
                localObject4 = ((Node)localObject4).getNodeName();
                if (((String)localObject4).equalsIgnoreCase("time")) {
                  paramString.sendTime = Long.valueOf((String)localObject3).longValue();
                } else if (((String)localObject4).equalsIgnoreCase("more")) {
                  paramString.moreText = ((String)localObject3);
                } else if (((String)localObject4).equalsIgnoreCase("grayTips")) {
                  paramString.grayTips = ((String)localObject3);
                }
                j += 1;
              }
            }
          }
          i += 1;
        }
        return paramString;
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      catch (SAXException paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      return null;
    }
    catch (ParserConfigurationException paramString)
    {
      paramString.printStackTrace();
    }
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
  public byte[] toByteArray(Object paramObject)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_1
    //   4: ifnonnull +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 508	java/io/ByteArrayOutputStream
    //   12: dup
    //   13: invokespecial 509	java/io/ByteArrayOutputStream:<init>	()V
    //   16: astore 6
    //   18: new 511	java/io/ObjectOutputStream
    //   21: dup
    //   22: aload 6
    //   24: invokespecial 514	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   27: astore_3
    //   28: aload_3
    //   29: astore_2
    //   30: aload_3
    //   31: aload_1
    //   32: invokevirtual 518	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   35: aload_3
    //   36: astore_2
    //   37: aload 6
    //   39: invokevirtual 520	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   42: astore 5
    //   44: aload 5
    //   46: astore_1
    //   47: aload_3
    //   48: invokevirtual 521	java/io/ObjectOutputStream:close	()V
    //   51: aload 5
    //   53: astore_1
    //   54: aload 6
    //   56: invokevirtual 522	java/io/ByteArrayOutputStream:close	()V
    //   59: aload 5
    //   61: areturn
    //   62: astore_2
    //   63: aload_2
    //   64: invokevirtual 258	java/io/IOException:printStackTrace	()V
    //   67: aload_1
    //   68: areturn
    //   69: astore_1
    //   70: goto +16 -> 86
    //   73: astore_1
    //   74: goto +42 -> 116
    //   77: astore_1
    //   78: aconst_null
    //   79: astore_2
    //   80: goto +64 -> 144
    //   83: astore_1
    //   84: aconst_null
    //   85: astore_3
    //   86: aload_3
    //   87: astore_2
    //   88: aload_1
    //   89: invokevirtual 258	java/io/IOException:printStackTrace	()V
    //   92: aload_3
    //   93: ifnull +10 -> 103
    //   96: aload 4
    //   98: astore_1
    //   99: aload_3
    //   100: invokevirtual 521	java/io/ObjectOutputStream:close	()V
    //   103: aload 4
    //   105: astore_1
    //   106: aload 6
    //   108: invokevirtual 522	java/io/ByteArrayOutputStream:close	()V
    //   111: aconst_null
    //   112: areturn
    //   113: astore_1
    //   114: aconst_null
    //   115: astore_3
    //   116: aload_3
    //   117: astore_2
    //   118: aload_1
    //   119: invokevirtual 476	java/lang/OutOfMemoryError:printStackTrace	()V
    //   122: aload_3
    //   123: ifnull +10 -> 133
    //   126: aload 4
    //   128: astore_1
    //   129: aload_3
    //   130: invokevirtual 521	java/io/ObjectOutputStream:close	()V
    //   133: aload 4
    //   135: astore_1
    //   136: aload 6
    //   138: invokevirtual 522	java/io/ByteArrayOutputStream:close	()V
    //   141: aconst_null
    //   142: areturn
    //   143: astore_1
    //   144: aload_2
    //   145: ifnull +7 -> 152
    //   148: aload_2
    //   149: invokevirtual 521	java/io/ObjectOutputStream:close	()V
    //   152: aload 6
    //   154: invokevirtual 522	java/io/ByteArrayOutputStream:close	()V
    //   157: goto +8 -> 165
    //   160: astore_2
    //   161: aload_2
    //   162: invokevirtual 258	java/io/IOException:printStackTrace	()V
    //   165: aload_1
    //   166: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	167	0	this	PublicAccountMessageUtilImpl
    //   0	167	1	paramObject	Object
    //   29	8	2	localObjectOutputStream1	java.io.ObjectOutputStream
    //   62	2	2	localIOException1	IOException
    //   79	70	2	localObjectOutputStream2	java.io.ObjectOutputStream
    //   160	2	2	localIOException2	IOException
    //   27	103	3	localObjectOutputStream3	java.io.ObjectOutputStream
    //   1	133	4	localObject	Object
    //   42	18	5	arrayOfByte	byte[]
    //   16	137	6	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   47	51	62	java/io/IOException
    //   54	59	62	java/io/IOException
    //   99	103	62	java/io/IOException
    //   106	111	62	java/io/IOException
    //   129	133	62	java/io/IOException
    //   136	141	62	java/io/IOException
    //   30	35	69	java/io/IOException
    //   37	44	69	java/io/IOException
    //   30	35	73	java/lang/OutOfMemoryError
    //   37	44	73	java/lang/OutOfMemoryError
    //   18	28	77	finally
    //   18	28	83	java/io/IOException
    //   18	28	113	java/lang/OutOfMemoryError
    //   30	35	143	finally
    //   37	44	143	finally
    //   88	92	143	finally
    //   118	122	143	finally
    //   148	152	160	java/io/IOException
    //   152	157	160	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl
 * JD-Core Version:    0.7.0.1
 */