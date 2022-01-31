import android.app.Activity;
import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
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

public class apvx
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
  public static String m = alof.cu + "[epId]" + File.separator;
  public static String n = alof.bS + "[epId]" + File.separator;
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
  
  public static aufn a()
  {
    try
    {
      AppInterface localAppInterface = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localAppInterface != null) {
        return (aufn)localAppInterface.getManager(14);
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
  
  public static List<apwv> a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = new ArrayList();
    paramQQAppInterface.add(new apwv(7, 7, null));
    paramQQAppInterface.add(new apwv(4, 4, null));
    paramQQAppInterface.add(new apwv(11, 4, null));
    return paramQQAppInterface;
  }
  
  public static List<apwv> a(QQAppInterface paramQQAppInterface, int paramInt, boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    List localList2 = Collections.synchronizedList(new ArrayList());
    Object localObject = (aufn)paramQQAppInterface.getManager(14);
    List localList1 = ((aufn)localObject).a(paramInt);
    localList2.add(new apwv(7, 7, null));
    if (paramInt == 0)
    {
      localList2.add(new apwv(4, 4, null));
      paramQQAppInterface = (apno)paramQQAppInterface.getManager(334);
      if ((paramQQAppInterface != null) && (paramQQAppInterface.c())) {
        localList2.add(new apwv(11, 4, null));
      }
    }
    paramQQAppInterface = ((aufn)localObject).a(false, paramInt, paramBoolean);
    if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0)) {
      localList2.add(new apwv(8, 3, null));
    }
    if (localList1 != null)
    {
      localObject = localList1.iterator();
      paramInt = 0;
      if (((Iterator)localObject).hasNext())
      {
        EmoticonPackage localEmoticonPackage = (EmoticonPackage)((Iterator)localObject).next();
        label260:
        int i1;
        if ((localEmoticonPackage.type != 1) && (3 != localEmoticonPackage.jobType) && (1 != localEmoticonPackage.jobType) && (5 != localEmoticonPackage.jobType))
        {
          localList1 = null;
          if (localEmoticonPackage.jobType == 4)
          {
            paramQQAppInterface = new apwv(10, 7, localEmoticonPackage);
            i1 = paramInt;
            if (paramQQAppInterface != null)
            {
              localList2.add(paramQQAppInterface);
              i1 = paramInt;
            }
            label277:
            paramQQAppInterface = localEmoticonPackage.epId;
            if (localEmoticonPackage.status != 2) {
              break label392;
            }
          }
        }
        label392:
        for (boolean bool = true;; bool = false)
        {
          apvu.a(paramQQAppInterface, bool);
          paramInt = i1;
          break;
          paramQQAppInterface = localList1;
          if (localEmoticonPackage.jobType != 0) {
            break label260;
          }
          paramQQAppInterface = localList1;
          if (paramBoolean) {
            break label260;
          }
          paramQQAppInterface = new apwv(6, 4, localEmoticonPackage);
          break label260;
          if (3 != localEmoticonPackage.jobType)
          {
            i1 = paramInt;
            if (5 != localEmoticonPackage.jobType) {
              break label277;
            }
          }
          i1 = paramInt;
          if (paramInt != 0) {
            break label277;
          }
          localList2.add(new apwv(9, 4, localEmoticonPackage));
          i1 = 1;
          break label277;
        }
      }
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonUtils", 2, "prepare data cost time:" + (l2 - l1));
    }
    return localList2;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    if ((paramQQAppInterface != null) && (paramEmoticonPackage != null))
    {
      paramQQAppInterface = (apro)paramQQAppInterface.getManager(43);
      if ((paramQQAppInterface.a(paramEmoticonPackage.epId) < 0.0F) && (b()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonUtils", 2, "downloadNormalEmotion wifi auto download emotion , epid = " + paramEmoticonPackage.epId);
        }
        paramQQAppInterface.a(paramEmoticonPackage, false, false, paramInt);
      }
    }
  }
  
  public static void a(bamw[] paramArrayOfbamw, float paramFloat1, float paramFloat2, boolean paramBoolean1, int paramInt1, int paramInt2, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, Activity paramActivity, boolean paramBoolean2)
  {
    if ((paramArrayOfbamw == null) || (paramQQAppInterface == null) || (paramSessionInfo == null) || (paramActivity == null)) {}
    Object localObject1;
    int i2;
    do
    {
      return;
      localObject1 = new TreeSet();
      int i1 = 0;
      i2 = paramInt1;
      paramInt1 = i1;
      while (paramInt1 < paramArrayOfbamw.length)
      {
        Object localObject2 = paramArrayOfbamw[paramInt1];
        boolean bool = paramBoolean1;
        int i3 = i2;
        i1 = paramInt2;
        if ((localObject2 instanceof bamy))
        {
          localObject2 = (bamy)localObject2;
          float f1 = ((bamy)localObject2).a;
          float f2 = ((bamy)localObject2).b;
          float f3 = ((bamy)localObject2).c;
          float f4 = ((bamy)localObject2).d;
          int i4 = ((bamy)localObject2).e;
          int i5 = ((bamy)localObject2).f;
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
      ((aufn)paramQQAppInterface.getManager(14)).b(String.valueOf(i2), 0, new apvy(paramSessionInfo, paramQQAppInterface, i2, paramActivity));
      return;
    }
    paramSessionInfo = ((TreeSet)localObject1).iterator();
    for (paramArrayOfbamw = ""; paramSessionInfo.hasNext(); paramArrayOfbamw = paramArrayOfbamw + localObject1 + ",") {
      localObject1 = (Integer)paramSessionInfo.next();
    }
    paramSessionInfo = paramArrayOfbamw;
    if (!paramArrayOfbamw.equals("")) {
      paramSessionInfo = paramArrayOfbamw.substring(0, paramArrayOfbamw.length() - 1);
    }
    EmojiHomeUiPlugin.openSmallEmojiListPage(paramActivity, paramQQAppInterface.getAccount(), 11, paramSessionInfo);
    azqs.b(paramQQAppInterface, "CliOper", "", "", "ep_mall", "0X8007000", 0, 0, String.valueOf(i2), String.valueOf(paramInt2), "", "");
  }
  
  public static boolean a()
  {
    int i1 = bdin.a(BaseApplication.getContext());
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
  
  public static List<apwv> b(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = new ArrayList();
    paramQQAppInterface.add(new apwv(7, 7, null));
    return paramQQAppInterface;
  }
  
  public static boolean b()
  {
    return bdin.a(BaseApplication.getContext()) == 1;
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt & 0x2) == 2;
  }
  
  public static boolean c()
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    int i1 = bdin.a(localBaseApplication);
    boolean bool = SettingCloneUtil.readValue(localBaseApplication, null, localBaseApplication.getString(2131695482), "qqsetting_auto_receive_magic_face_key", true);
    return ((i1 == 3) || (i1 == 4)) && (!bool);
  }
  
  public static boolean c(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1) || (paramInt == 3000) || (paramInt == 99999);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apvx
 * JD-Core Version:    0.7.0.1
 */