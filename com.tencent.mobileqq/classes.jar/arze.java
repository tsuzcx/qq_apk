import android.app.Activity;
import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class arze
{
  public static String a = "https://i.gtimg.cn/qqshow/admindata/comdata/vipSmallEmoji_item_[epId]/[eId].gif";
  public static String b = "https://i.gtimg.cn/qqshow/admindata/comdata/vipSmallEmoji_item_[epId]/[eId]_apng.png";
  public static String c = "https://i.gtimg.cn/qqshow/admindata/comdata/vipSmallEmoji_item_[epId]/xydata.json";
  public static String d = "https://i.gtimg.cn/qqshow/admindata/comdata/vipSmallEmoji_item_[epId]/[eId].png";
  public static String e = "https://i.gtimg.cn/club/item/parcel/item/[eIdSub]/[eId]/ring.amr";
  public static String f = "https://i.gtimg.cn/club/item/parcel/item/[eIdSub]/[eId]/pngframe.zip";
  public static String g = "https://i.gtimg.cn/club/item/parcel/item/[eIdSub]/[eId]/126x126.png";
  public static String h = "https://i.gtimg.cn/club/item/parcel/item/[eIdSub]/[eId]/[width]_[height]";
  public static String i = "https://i.gtimg.cn/club/item/parcel/item/[eIdSub]/[eId]/[width]_[height]_apng";
  public static String j = "https://i.gtimg.cn/club/item/parcel/item/[eIdSub]/[eId]/[width]x[height].png";
  public static String k = "https://gxh.vip.qq.com/club/item/parcel/img/parcel/[mod]/[epId]/200x200.png";
  public static String l = "https://gxh.vip.qq.com/qqshow/admindata/comdata/vipSmallEmoji_item_[epId]/200x200.png";
  public static String m = anhk.cx + "[epId]" + File.separator;
  public static String n = anhk.bV + "[epId]" + File.separator;
  public static String o = n + "[eId].amr";
  public static String p = n + "[eId]_thu.png";
  public static String q = n + "[eId]_aio.png";
  public static String r = n + "[epId].jtmp";
  public static String s = n + "[eId]";
  public static String t = n + "[eId]_apng";
  public static String u = n + "h5_json.zip";
  public static String v = n + "h5magic" + File.separator;
  public static String w = v + "index.html";
  public static String x = v + "fileList";
  public static String y = n + "[epId].zip";
  public static String z = n + "pngframe/";
  
  public static int a(int paramInt)
  {
    if (paramInt != -1) {}
    switch (Integer.valueOf(ChatActivityUtils.b(paramInt)).intValue())
    {
    default: 
      return 0;
    case 0: 
      return 2;
    case 3: 
      return 1;
    case 1: 
      return 3;
    }
    return 4;
  }
  
  public static awmr a()
  {
    try
    {
      AppInterface localAppInterface = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localAppInterface != null) {
        return (awmr)localAppInterface.getManager(14);
      }
    }
    catch (ClassCastException localClassCastException)
    {
      for (;;)
      {
        localClassCastException.printStackTrace();
        Object localObject = null;
      }
    }
    return null;
  }
  
  public static String a(MessageForPic paramMessageForPic)
  {
    if (paramMessageForPic == null) {
      return "";
    }
    if ((paramMessageForPic.picExtraData == null) && (!paramMessageForPic.checkGif())) {
      return "";
    }
    PicMessageExtraData localPicMessageExtraData = paramMessageForPic.picExtraData;
    if (localPicMessageExtraData != null)
    {
      if (localPicMessageExtraData.isCustomFace()) {
        return "2";
      }
      if (localPicMessageExtraData.isSelfieFace()) {
        return "3";
      }
      if (localPicMessageExtraData.isHotPics()) {
        return "6";
      }
      if ((localPicMessageExtraData.isDoutu()) || (localPicMessageExtraData.isDiyDouTu())) {
        return "7";
      }
      if (localPicMessageExtraData.isZhitu()) {
        return "8";
      }
      if ((localPicMessageExtraData.isStickerPics()) || (localPicMessageExtraData.isStickerAdPic())) {
        return "5";
      }
      if (localPicMessageExtraData.isRelatedEmo()) {
        return "10";
      }
      if (paramMessageForPic.checkGif()) {
        return "9";
      }
    }
    else if (paramMessageForPic.checkGif())
    {
      return "9";
    }
    return "";
  }
  
  public static List<asaf> a(QQAppInterface paramQQAppInterface)
  {
    ArrayList localArrayList1 = new ArrayList();
    aqoo localaqoo = aqon.a();
    if ((localaqoo != null) && (!localaqoo.b.isEmpty()))
    {
      ArrayList localArrayList2 = new ArrayList();
      localArrayList2.add("sysface");
      localArrayList2.add("favorite");
      localArrayList2.add("hotpic");
      localArrayList2.add("camera");
      localArrayList1.addAll(a(paramQQAppInterface, localaqoo.b, localArrayList2, 0, false));
      return localArrayList1;
    }
    localArrayList1.add(new asaf(7, 7, null));
    localArrayList1.add(new asaf(4, 4, null));
    localArrayList1.add(new asaf(12, 4, null));
    localArrayList1.add(new asaf(11, 4, null));
    return localArrayList1;
  }
  
  public static List<asaf> a(QQAppInterface paramQQAppInterface, int paramInt, boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    List localList2 = Collections.synchronizedList(new ArrayList());
    List localList1 = ((awmr)paramQQAppInterface.getManager(14)).a(paramInt);
    Object localObject = aqon.a();
    label91:
    EmoticonPackage localEmoticonPackage;
    label175:
    int i1;
    if ((localObject != null) && (!((aqoo)localObject).b.isEmpty()))
    {
      localList2.addAll(a(paramQQAppInterface, ((aqoo)localObject).b, null, paramInt, paramBoolean));
      if (localList1 == null) {
        break label397;
      }
      localObject = localList1.iterator();
      paramInt = 0;
      if (!((Iterator)localObject).hasNext()) {
        break label397;
      }
      localEmoticonPackage = (EmoticonPackage)((Iterator)localObject).next();
      if ((localEmoticonPackage.type == 1) || (3 == localEmoticonPackage.jobType) || (1 == localEmoticonPackage.jobType) || (5 == localEmoticonPackage.jobType)) {
        break label340;
      }
      localList1 = null;
      if (localEmoticonPackage.jobType != 4) {
        break label306;
      }
      paramQQAppInterface = new asaf(10, 7, localEmoticonPackage);
      i1 = paramInt;
      if (paramQQAppInterface != null)
      {
        localList2.add(paramQQAppInterface);
        i1 = paramInt;
      }
      label192:
      paramQQAppInterface = localEmoticonPackage.epId;
      if (localEmoticonPackage.status != 2) {
        break label391;
      }
    }
    label391:
    for (boolean bool = true;; bool = false)
    {
      arzb.a(paramQQAppInterface, bool);
      paramInt = i1;
      break label91;
      localObject = new ArrayList();
      ((List)localObject).add("sysface");
      ((List)localObject).add("favorite");
      ((List)localObject).add("hotpic");
      ((List)localObject).add("camera");
      ((List)localObject).add("recommend");
      localList2.addAll(a(paramQQAppInterface, (List)localObject, null, paramInt, paramBoolean));
      break;
      label306:
      paramQQAppInterface = localList1;
      if (localEmoticonPackage.jobType != 0) {
        break label175;
      }
      paramQQAppInterface = localList1;
      if (paramBoolean) {
        break label175;
      }
      paramQQAppInterface = new asaf(6, 4, localEmoticonPackage);
      break label175;
      label340:
      if (3 != localEmoticonPackage.jobType)
      {
        i1 = paramInt;
        if (5 != localEmoticonPackage.jobType) {
          break label192;
        }
      }
      i1 = paramInt;
      if (paramInt != 0) {
        break label192;
      }
      localList2.add(new asaf(9, 4, localEmoticonPackage));
      i1 = 1;
      break label192;
    }
    label397:
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonUtils", 2, "prepare data cost time:" + (l2 - l1));
    }
    return localList2;
  }
  
  public static List<asaf> a(QQAppInterface paramQQAppInterface, List<String> paramList1, List<String> paramList2, int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList1 == null) {
      return localArrayList;
    }
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      Object localObject = (String)paramList1.next();
      if ((paramList2 == null) || (paramList2.contains(localObject))) {
        if ("sysface".equals(localObject))
        {
          localArrayList.add(new asaf(7, 7, null));
        }
        else if ("favorite".equals(localObject))
        {
          if (paramInt == 0) {
            localArrayList.add(new asaf(4, 4, null));
          }
        }
        else if ("hotpic".equals(localObject))
        {
          if (paramInt == 0) {
            localArrayList.add(new asaf(12, 4, null));
          }
        }
        else if ("camera".equals(localObject))
        {
          localObject = (arqk)paramQQAppInterface.getManager(334);
          if ((localObject != null) && (((arqk)localObject).c())) {
            localArrayList.add(new asaf(11, 4, null));
          }
        }
        else if ("recommend".equals(localObject))
        {
          localObject = ((awmr)paramQQAppInterface.getManager(14)).a(false, paramInt, paramBoolean);
          if ((localObject != null) && (((List)localObject).size() > 0)) {
            localArrayList.add(new asaf(8, 3, null));
          }
        }
      }
    }
    return localArrayList;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      paramString1 = "";
    }
    for (;;)
    {
      if (paramString2 == null) {
        paramString2 = "";
      }
      for (;;)
      {
        bcst.b(paramQQAppInterface, "dc00898", "", "", "0X800AEE5", "0X800AEE5", paramInt, 0, "", "", paramString1, paramString2);
        return;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    if ((paramQQAppInterface != null) && (paramEmoticonPackage != null))
    {
      paramQQAppInterface = (arup)paramQQAppInterface.getManager(43);
      if ((paramQQAppInterface.a(paramEmoticonPackage.epId) < 0.0F) && (b()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonUtils", 2, "downloadNormalEmotion wifi auto download emotion , epid = " + paramEmoticonPackage.epId);
        }
        paramQQAppInterface.a(paramEmoticonPackage, false, false, paramInt);
      }
    }
  }
  
  public static void a(String paramString, int paramInt)
  {
    a(paramString, paramString, paramInt);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt)
  {
    bcst.b(null, "dc00898", "", "", paramString1, paramString2, paramInt, 0, "", "0", "0", "");
  }
  
  public static void a(bdoa[] paramArrayOfbdoa, float paramFloat1, float paramFloat2, boolean paramBoolean1, int paramInt1, int paramInt2, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, Activity paramActivity, boolean paramBoolean2)
  {
    if ((paramArrayOfbdoa == null) || (paramQQAppInterface == null) || (paramSessionInfo == null) || (paramActivity == null)) {}
    Object localObject1;
    int i2;
    do
    {
      return;
      localObject1 = new TreeSet();
      int i1 = 0;
      i2 = paramInt1;
      paramInt1 = i1;
      while (paramInt1 < paramArrayOfbdoa.length)
      {
        Object localObject2 = paramArrayOfbdoa[paramInt1];
        boolean bool = paramBoolean1;
        int i3 = i2;
        i1 = paramInt2;
        if ((localObject2 instanceof bdoc))
        {
          localObject2 = (bdoc)localObject2;
          float f1 = ((bdoc)localObject2).a;
          float f2 = ((bdoc)localObject2).b;
          float f3 = ((bdoc)localObject2).c;
          float f4 = ((bdoc)localObject2).d;
          int i4 = ((bdoc)localObject2).e;
          int i5 = ((bdoc)localObject2).f;
          ((TreeSet)localObject1).add(Integer.valueOf(i4));
          bool = paramBoolean1;
          i3 = i2;
          i1 = paramInt2;
          if (!paramBoolean2)
          {
            bool = paramBoolean1;
            i3 = i2;
            i1 = paramInt2;
            if (paramFloat1 >= f1)
            {
              bool = paramBoolean1;
              i3 = i2;
              i1 = paramInt2;
              if (paramFloat1 <= f3)
              {
                bool = paramBoolean1;
                i3 = i2;
                i1 = paramInt2;
                if (paramFloat2 >= f2)
                {
                  bool = paramBoolean1;
                  i3 = i2;
                  i1 = paramInt2;
                  if (paramFloat2 <= f4)
                  {
                    bool = paramBoolean1;
                    i3 = i2;
                    i1 = paramInt2;
                    if (!paramBoolean1)
                    {
                      bool = true;
                      i1 = i5;
                      i3 = i4;
                    }
                  }
                }
              }
            }
          }
        }
        paramInt1 += 1;
        paramBoolean1 = bool;
        i2 = i3;
        paramInt2 = i1;
      }
    } while (!paramBoolean1);
    if (((TreeSet)localObject1).size() == 1)
    {
      ((awmr)paramQQAppInterface.getManager(14)).b(String.valueOf(i2), 0, new arzf(paramSessionInfo, paramQQAppInterface, i2, paramActivity));
      return;
    }
    paramSessionInfo = ((TreeSet)localObject1).iterator();
    for (paramArrayOfbdoa = ""; paramSessionInfo.hasNext(); paramArrayOfbdoa = paramArrayOfbdoa + localObject1 + ",") {
      localObject1 = (Integer)paramSessionInfo.next();
    }
    paramSessionInfo = paramArrayOfbdoa;
    if (!paramArrayOfbdoa.equals("")) {
      paramSessionInfo = paramArrayOfbdoa.substring(0, paramArrayOfbdoa.length() - 1);
    }
    EmojiHomeUiPlugin.openSmallEmojiListPage(paramActivity, paramQQAppInterface.getAccount(), 11, paramSessionInfo);
    bcst.b(paramQQAppInterface, "CliOper", "", "", "ep_mall", "0X8007000", 0, 0, String.valueOf(i2), String.valueOf(paramInt2), "", "");
  }
  
  public static boolean a()
  {
    int i1 = bgnt.a(BaseApplication.getContext());
    return (i1 == 1) || (i1 == 3) || (i1 == 4);
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt & 0x1) == 1;
  }
  
  public static boolean a(EmoticonPackage paramEmoticonPackage)
  {
    return (paramEmoticonPackage != null) && (paramEmoticonPackage.status == 2) && ((paramEmoticonPackage.updateFlag & 0x1) == 1);
  }
  
  public static byte[] a(String paramString)
  {
    int i2 = paramString.length() / 2;
    byte[] arrayOfByte = new byte[i2];
    int i1 = 0;
    while (i1 < i2)
    {
      arrayOfByte[i1] = Integer.valueOf(paramString.substring(i1 * 2, i1 * 2 + 2), 16).byteValue();
      i1 += 1;
    }
    return arrayOfByte;
  }
  
  public static int b(int paramInt)
  {
    if (paramInt != -1) {}
    switch (Integer.valueOf(ChatActivityUtils.b(paramInt)).intValue())
    {
    case 1: 
    default: 
      return 4;
    case 0: 
      return 1;
    case 3: 
      return 2;
    }
    return 3;
  }
  
  public static String b(MessageForPic paramMessageForPic)
  {
    if (paramMessageForPic.isSend()) {
      return "";
    }
    int i1 = paramMessageForPic.istroop;
    if (paramMessageForPic.rawMsgUrl != null) {
      paramMessageForPic = paramMessageForPic.rawMsgUrl;
    }
    while ((i1 == 1) || (i1 == 3000))
    {
      return "http://gchat.qpic.cn" + paramMessageForPic;
      if (paramMessageForPic.bigMsgUrl != null) {
        paramMessageForPic = paramMessageForPic.bigMsgUrl;
      } else if (paramMessageForPic.thumbMsgUrl != null) {
        paramMessageForPic = paramMessageForPic.thumbMsgUrl;
      } else {
        return "";
      }
    }
    return "http://c2cpicdw.qpic.cn" + paramMessageForPic;
  }
  
  public static List<asaf> b(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = new ArrayList();
    paramQQAppInterface.add(new asaf(7, 7, null));
    return paramQQAppInterface;
  }
  
  public static boolean b()
  {
    return bgnt.a(BaseApplication.getContext()) == 1;
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt & 0x2) == 2;
  }
  
  public static boolean c()
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    int i1 = bgnt.a(localBaseApplication);
    boolean bool = SettingCloneUtil.readValue(localBaseApplication, null, localBaseApplication.getString(2131694401), "qqsetting_auto_receive_magic_face_key", true);
    return ((i1 == 3) || (i1 == 4)) && (!bool);
  }
  
  public static boolean c(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1) || (paramInt == 3000) || (paramInt == 99999);
  }
  
  public static boolean d(int paramInt)
  {
    if (paramInt != -1) {}
    switch (Integer.valueOf(ChatActivityUtils.b(paramInt)).intValue())
    {
    default: 
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arze
 * JD-Core Version:    0.7.0.1
 */