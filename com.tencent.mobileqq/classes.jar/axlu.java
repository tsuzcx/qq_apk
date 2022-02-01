import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class axlu
{
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -5040;
    case 1: 
      return -5020;
    case 2: 
      return -5023;
    }
    return -5022;
  }
  
  public static int a(long paramLong1, long paramLong2)
  {
    if ((paramLong1 > 0L) && (paramLong2 >= 0L)) {
      return axma.a(paramLong1, paramLong2);
    }
    return 0;
  }
  
  public static int a(afsf paramafsf)
  {
    long l1 = paramafsf.a();
    long l2 = paramafsf.b();
    if (l1 == 17L) {
      if (!paramafsf.a()) {}
    }
    while (paramafsf.a())
    {
      return 999;
      return 0;
    }
    if (paramafsf.b()) {
      return 998;
    }
    return a(l1, l2);
  }
  
  public static ArrayList<axlw> a(QQAppInterface paramQQAppInterface, String paramString, StringBuilder paramStringBuilder)
  {
    Object localObject = Pattern.compile("#(name|icon)_(\\d+)").matcher(paramStringBuilder);
    ArrayList localArrayList = new ArrayList();
    axlw localaxlw;
    int i;
    if (((Matcher)localObject).find())
    {
      localaxlw = new axlw();
      localaxlw.jdField_a_of_type_JavaLangString = ((Matcher)localObject).group();
      localaxlw.jdField_b_of_type_Int = ((Matcher)localObject).start();
      localaxlw.jdField_b_of_type_JavaLangString = ((Matcher)localObject).group(2);
      if (localaxlw.a()) {}
      for (i = 2;; i = 1)
      {
        localaxlw.jdField_a_of_type_Int = i;
        localArrayList.add(localaxlw);
        break;
      }
    }
    localObject = Pattern.compile("\\(([^\\(]+?)\\)\\[\\]").matcher(paramStringBuilder);
    while (((Matcher)localObject).find())
    {
      localaxlw = new axlw();
      localaxlw.jdField_a_of_type_Int = 5;
      localaxlw.jdField_a_of_type_JavaLangString = ((Matcher)localObject).group();
      localaxlw.jdField_b_of_type_Int = ((Matcher)localObject).start();
      localaxlw.jdField_c_of_type_JavaLangString = ((Matcher)localObject).group(1);
      localArrayList.add(localaxlw);
    }
    localObject = Pattern.compile("\\(([^\\(]+?)\\)\\[([^\\)]+?)\\]").matcher(paramStringBuilder);
    while (((Matcher)localObject).find())
    {
      localaxlw = new axlw();
      localaxlw.jdField_a_of_type_Int = 3;
      localaxlw.jdField_a_of_type_JavaLangString = ((Matcher)localObject).group();
      localaxlw.jdField_b_of_type_Int = ((Matcher)localObject).start();
      localaxlw.jdField_c_of_type_JavaLangString = ((Matcher)localObject).group(1);
      localaxlw.jdField_d_of_type_JavaLangString = axma.c(((Matcher)localObject).group(2));
      localArrayList.add(localaxlw);
    }
    localObject = Pattern.compile("#image_url\\{([^\\)]+?)\\}").matcher(paramStringBuilder);
    while (((Matcher)localObject).find())
    {
      localaxlw = new axlw();
      localaxlw.jdField_a_of_type_Int = 4;
      localaxlw.jdField_a_of_type_JavaLangString = ((Matcher)localObject).group();
      localaxlw.jdField_b_of_type_Int = ((Matcher)localObject).start();
      localaxlw.jdField_d_of_type_JavaLangString = axma.c(((Matcher)localObject).group(1));
      localaxlw.jdField_d_of_type_JavaLangString = axml.a(paramQQAppInterface, paramString, localaxlw.jdField_d_of_type_JavaLangString);
      localaxlw.jdField_c_of_type_JavaLangString = localaxlw.jdField_a_of_type_JavaLangString.replace(((Matcher)localObject).group(1), localaxlw.jdField_d_of_type_JavaLangString);
      localArrayList.add(localaxlw);
    }
    Collections.sort(localArrayList, new axlv());
    localObject = localArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localaxlw = (axlw)((Iterator)localObject).next();
      if (!TextUtils.isEmpty(localaxlw.jdField_a_of_type_JavaLangString))
      {
        i = paramStringBuilder.indexOf(localaxlw.jdField_a_of_type_JavaLangString);
        int j = localaxlw.jdField_a_of_type_JavaLangString.length() + i;
        if ((i >= 0) && (j <= paramStringBuilder.length()))
        {
          switch (localaxlw.jdField_a_of_type_Int)
          {
          }
          for (;;)
          {
            if (localaxlw.jdField_c_of_type_JavaLangString == null) {
              localaxlw.jdField_c_of_type_JavaLangString = localaxlw.jdField_a_of_type_JavaLangString;
            }
            localaxlw.jdField_c_of_type_Int = i;
            localaxlw.jdField_d_of_type_Int = (localaxlw.jdField_c_of_type_JavaLangString.length() + i);
            paramStringBuilder.replace(i, j, localaxlw.jdField_c_of_type_JavaLangString);
            break;
            localaxlw.jdField_c_of_type_JavaLangString = axlp.a(paramQQAppInterface, localaxlw.jdField_b_of_type_JavaLangString);
            continue;
            localaxlw.jdField_c_of_type_JavaLangString = axlp.a(paramQQAppInterface, paramString, localaxlw.jdField_b_of_type_JavaLangString);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Friends paramFriends, ExtensionInfo paramExtensionInfo, afsf paramafsf, aooq paramaooq)
  {
    int i = 2097153;
    afsh localafsh = paramafsf.a();
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkGrayTipsHelper", 2, "checkAndInsertGrayTips grayInfo:" + localafsh + " onlinePush:" + paramaooq.a);
    }
    int j;
    if ((localafsh != null) && (localafsh.a()))
    {
      j = 0;
      if (TextUtils.isEmpty(localafsh.jdField_b_of_type_JavaLangString)) {
        break label203;
      }
      paramaooq = localafsh.jdField_b_of_type_JavaLangString;
      switch (paramafsf.jdField_a_of_type_Int)
      {
      default: 
        label168:
        i = 2097155;
      }
    }
    for (;;)
    {
      int k = a(localafsh.jdField_a_of_type_Int);
      a(paramQQAppInterface, paramFriends, paramExtensionInfo, paramafsf, localafsh.jdField_a_of_type_JavaLangString, k, i, j, paramaooq);
      return;
      label203:
      paramaooq = paramafsf.jdField_b_of_type_JavaLangString + "_" + paramafsf.jdField_a_of_type_Int + "_" + paramaooq.b + "_" + localafsh.jdField_a_of_type_Long;
      break;
      j = a(paramafsf);
      continue;
      i = 2097154;
      continue;
      if ((paramafsf.jdField_a_of_type_Afsi == null) || (paramafsf.jdField_b_of_type_Afsi == null)) {
        break label168;
      }
      if (paramafsf.jdField_a_of_type_Afsi.a() > paramafsf.jdField_b_of_type_Afsi.a())
      {
        i = 2097154;
      }
      else
      {
        if (paramafsf.jdField_a_of_type_Afsi.a() >= paramafsf.jdField_b_of_type_Afsi.a()) {
          break label168;
        }
        j = a(paramafsf);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Friends paramFriends, ExtensionInfo paramExtensionInfo, afsf paramafsf, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkGrayTipsHelper", 2, "insertGrayTips friendUin:" + paramafsf.jdField_b_of_type_JavaLangString + " grayType:" + paramInt1 + " grayID:" + paramInt2 + " subType:" + paramInt3 + " grayTipKey:" + paramString2 + " _grayTipTemplate:" + paramString1);
    }
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    Object localObject = paramString1;
    if (paramString1.contains("#nick")) {
      localObject = paramString1.replaceAll("#nick", ContactUtils.getFriendShowName(paramQQAppInterface, paramafsf.jdField_b_of_type_JavaLangString));
    }
    localObject = new StringBuilder((String)localObject);
    axml.a(paramQQAppInterface, paramFriends, paramExtensionInfo, paramafsf, (StringBuilder)localObject);
    paramString1 = a(paramQQAppInterface, paramafsf.jdField_b_of_type_JavaLangString, (StringBuilder)localObject);
    localObject = ((StringBuilder)localObject).toString();
    avhz localavhz = new avhz(paramafsf.jdField_b_of_type_JavaLangString, paramafsf.jdField_b_of_type_JavaLangString, (String)localObject, 0, paramInt1, paramInt2, bcrg.a());
    MessageForUniteGrayTip localMessageForUniteGrayTip = new MessageForUniteGrayTip();
    localMessageForUniteGrayTip.hasRead = 0;
    localMessageForUniteGrayTip.subType = paramInt3;
    localMessageForUniteGrayTip.initGrayTipMsg(paramQQAppInterface, localavhz);
    localMessageForUniteGrayTip.tipParam.jdField_d_of_type_JavaLangString = paramString2;
    if (paramInt3 == 998)
    {
      localMessageForUniteGrayTip.caidanAnimUrl = paramafsf.a();
      localMessageForUniteGrayTip.caidanAnimUrl = axma.c(localMessageForUniteGrayTip.caidanAnimUrl);
      localMessageForUniteGrayTip.caidanAnimUrl = axml.a(paramQQAppInterface, paramafsf.jdField_b_of_type_JavaLangString, localMessageForUniteGrayTip.caidanAnimUrl);
    }
    for (;;)
    {
      a(paramQQAppInterface, (String)localObject, localavhz, paramString1);
      localMessageForUniteGrayTip.saveExtInfoToExtStr("mutualmark_id", axma.a(paramafsf.a(), paramafsf.b()));
      paramInt1 = paramafsf.c();
      if (paramInt1 > 0) {
        localMessageForUniteGrayTip.saveExtInfoToExtStr("sub_level", String.valueOf(paramInt1));
      }
      axml.a(paramQQAppInterface, paramFriends, paramExtensionInfo, paramafsf, (String)localObject, localavhz, paramString1);
      avia.a(paramQQAppInterface, localMessageForUniteGrayTip);
      axlo.a(paramQQAppInterface, localMessageForUniteGrayTip, localMessageForUniteGrayTip.tipParam.jdField_b_of_type_Int);
      return;
      if (paramInt3 == 999)
      {
        localMessageForUniteGrayTip.caidanAnimUrl = paramafsf.b();
        localMessageForUniteGrayTip.caidanAnimUrl = axma.c(localMessageForUniteGrayTip.caidanAnimUrl);
        localMessageForUniteGrayTip.caidanAnimUrlMd5 = paramafsf.c();
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, avhz paramavhz, ArrayList<axlw> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {}
    for (;;)
    {
      return;
      paramQQAppInterface = paramArrayList.iterator();
      while (paramQQAppInterface.hasNext())
      {
        paramString = (axlw)paramQQAppInterface.next();
        if (QLog.isColorLevel()) {
          QLog.d("MutualMarkGrayTipsHelper", 2, "handleHighlightInfo item=" + paramString);
        }
        switch (paramString.jdField_a_of_type_Int)
        {
        default: 
          break;
        case 1: 
        case 5: 
          if (!TextUtils.isEmpty(paramString.jdField_c_of_type_JavaLangString))
          {
            paramArrayList = new Bundle();
            paramArrayList.putInt("key_action", 11);
            paramArrayList.putString("key_action_DATA", paramString.jdField_c_of_type_JavaLangString);
            paramavhz.a(paramString.jdField_c_of_type_Int, paramString.jdField_d_of_type_Int, paramArrayList);
          }
          break;
        case 2: 
        case 4: 
          if (!TextUtils.isEmpty(paramString.jdField_c_of_type_JavaLangString))
          {
            paramArrayList = new Bundle();
            paramArrayList.putString("image_resource", paramString.jdField_c_of_type_JavaLangString);
            paramavhz.a(paramString.jdField_c_of_type_Int, paramString.jdField_d_of_type_Int, paramArrayList);
          }
          break;
        case 3: 
          if ((!TextUtils.isEmpty(paramString.jdField_c_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramString.jdField_d_of_type_JavaLangString)))
          {
            paramArrayList = new Bundle();
            paramArrayList.putInt("key_action", 1);
            paramArrayList.putString("key_action_DATA", paramString.jdField_d_of_type_JavaLangString);
            paramavhz.a(paramString.jdField_c_of_type_Int, paramString.jdField_d_of_type_Int, paramArrayList);
          }
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axlu
 * JD-Core Version:    0.7.0.1
 */