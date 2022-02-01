import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class axsl
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
      return axsr.a(paramLong1, paramLong2);
    }
    return 0;
  }
  
  public static int a(aghx paramaghx)
  {
    long l1 = paramaghx.a();
    long l2 = paramaghx.b();
    if (l1 == 17L) {
      if (!paramaghx.a()) {}
    }
    while (paramaghx.a())
    {
      return 999;
      return 0;
    }
    if (paramaghx.b()) {
      return 998;
    }
    return a(l1, l2);
  }
  
  public static ArrayList<axsn> a(QQAppInterface paramQQAppInterface, String paramString, StringBuilder paramStringBuilder)
  {
    Object localObject = Pattern.compile("#(name|icon)_(\\d+)").matcher(paramStringBuilder);
    ArrayList localArrayList = new ArrayList();
    axsn localaxsn;
    int i;
    if (((Matcher)localObject).find())
    {
      localaxsn = new axsn();
      localaxsn.jdField_a_of_type_JavaLangString = ((Matcher)localObject).group();
      localaxsn.jdField_b_of_type_Int = ((Matcher)localObject).start();
      localaxsn.jdField_b_of_type_JavaLangString = ((Matcher)localObject).group(2);
      if (localaxsn.a()) {}
      for (i = 2;; i = 1)
      {
        localaxsn.jdField_a_of_type_Int = i;
        localArrayList.add(localaxsn);
        break;
      }
    }
    localObject = Pattern.compile("\\(([^\\(]+?)\\)\\[\\]").matcher(paramStringBuilder);
    while (((Matcher)localObject).find())
    {
      localaxsn = new axsn();
      localaxsn.jdField_a_of_type_Int = 5;
      localaxsn.jdField_a_of_type_JavaLangString = ((Matcher)localObject).group();
      localaxsn.jdField_b_of_type_Int = ((Matcher)localObject).start();
      localaxsn.jdField_c_of_type_JavaLangString = ((Matcher)localObject).group(1);
      localArrayList.add(localaxsn);
    }
    localObject = Pattern.compile("\\(([^\\(]+?)\\)\\[([^\\)]+?)\\]").matcher(paramStringBuilder);
    while (((Matcher)localObject).find())
    {
      localaxsn = new axsn();
      localaxsn.jdField_a_of_type_Int = 3;
      localaxsn.jdField_a_of_type_JavaLangString = ((Matcher)localObject).group();
      localaxsn.jdField_b_of_type_Int = ((Matcher)localObject).start();
      localaxsn.jdField_c_of_type_JavaLangString = ((Matcher)localObject).group(1);
      localaxsn.jdField_d_of_type_JavaLangString = axsr.c(((Matcher)localObject).group(2));
      localArrayList.add(localaxsn);
    }
    localObject = Pattern.compile("#image_url\\{([^\\)]+?)\\}").matcher(paramStringBuilder);
    while (((Matcher)localObject).find())
    {
      localaxsn = new axsn();
      localaxsn.jdField_a_of_type_Int = 4;
      localaxsn.jdField_a_of_type_JavaLangString = ((Matcher)localObject).group();
      localaxsn.jdField_b_of_type_Int = ((Matcher)localObject).start();
      localaxsn.jdField_d_of_type_JavaLangString = axsr.c(((Matcher)localObject).group(1));
      localaxsn.jdField_d_of_type_JavaLangString = axtc.a(paramQQAppInterface, paramString, localaxsn.jdField_d_of_type_JavaLangString);
      localaxsn.jdField_c_of_type_JavaLangString = localaxsn.jdField_a_of_type_JavaLangString.replace(((Matcher)localObject).group(1), localaxsn.jdField_d_of_type_JavaLangString);
      localArrayList.add(localaxsn);
    }
    Collections.sort(localArrayList, new axsm());
    localObject = localArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localaxsn = (axsn)((Iterator)localObject).next();
      if (!TextUtils.isEmpty(localaxsn.jdField_a_of_type_JavaLangString))
      {
        i = paramStringBuilder.indexOf(localaxsn.jdField_a_of_type_JavaLangString);
        int j = localaxsn.jdField_a_of_type_JavaLangString.length() + i;
        if ((i >= 0) && (j <= paramStringBuilder.length()))
        {
          switch (localaxsn.jdField_a_of_type_Int)
          {
          }
          for (;;)
          {
            if (localaxsn.jdField_c_of_type_JavaLangString == null) {
              localaxsn.jdField_c_of_type_JavaLangString = localaxsn.jdField_a_of_type_JavaLangString;
            }
            localaxsn.jdField_c_of_type_Int = i;
            localaxsn.jdField_d_of_type_Int = (localaxsn.jdField_c_of_type_JavaLangString.length() + i);
            paramStringBuilder.replace(i, j, localaxsn.jdField_c_of_type_JavaLangString);
            break;
            localaxsn.jdField_c_of_type_JavaLangString = axsg.a(paramQQAppInterface, localaxsn.jdField_b_of_type_JavaLangString);
            continue;
            localaxsn.jdField_c_of_type_JavaLangString = axsg.a(paramQQAppInterface, paramString, localaxsn.jdField_b_of_type_JavaLangString);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Friends paramFriends, ExtensionInfo paramExtensionInfo, aghx paramaghx, aotc paramaotc)
  {
    int i = 2097153;
    aghz localaghz = paramaghx.a();
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkGrayTipsHelper", 2, "checkAndInsertGrayTips grayInfo:" + localaghz + " onlinePush:" + paramaotc.a);
    }
    int j;
    if ((localaghz != null) && (localaghz.a()))
    {
      j = 0;
      if (TextUtils.isEmpty(localaghz.jdField_b_of_type_JavaLangString)) {
        break label203;
      }
      paramaotc = localaghz.jdField_b_of_type_JavaLangString;
      switch (paramaghx.jdField_a_of_type_Int)
      {
      default: 
        label168:
        i = 2097155;
      }
    }
    for (;;)
    {
      int k = a(localaghz.jdField_a_of_type_Int);
      a(paramQQAppInterface, paramFriends, paramExtensionInfo, paramaghx, localaghz.jdField_a_of_type_JavaLangString, k, i, j, paramaotc);
      return;
      label203:
      paramaotc = paramaghx.jdField_b_of_type_JavaLangString + "_" + paramaghx.jdField_a_of_type_Int + "_" + paramaotc.b + "_" + localaghz.jdField_a_of_type_Long;
      break;
      j = a(paramaghx);
      continue;
      i = 2097154;
      continue;
      if ((paramaghx.jdField_a_of_type_Agia == null) || (paramaghx.jdField_b_of_type_Agia == null)) {
        break label168;
      }
      if (paramaghx.jdField_a_of_type_Agia.a() > paramaghx.jdField_b_of_type_Agia.a())
      {
        i = 2097154;
      }
      else
      {
        if (paramaghx.jdField_a_of_type_Agia.a() >= paramaghx.jdField_b_of_type_Agia.a()) {
          break label168;
        }
        j = a(paramaghx);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Friends paramFriends, ExtensionInfo paramExtensionInfo, aghx paramaghx, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkGrayTipsHelper", 2, "insertGrayTips friendUin:" + paramaghx.jdField_b_of_type_JavaLangString + " grayType:" + paramInt1 + " grayID:" + paramInt2 + " subType:" + paramInt3 + " grayTipKey:" + paramString2 + " _grayTipTemplate:" + paramString1);
    }
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    Object localObject = paramString1;
    if (paramString1.contains("#nick")) {
      localObject = paramString1.replaceAll("#nick", bhlg.m(paramQQAppInterface, paramaghx.jdField_b_of_type_JavaLangString));
    }
    localObject = new StringBuilder((String)localObject);
    axtc.a(paramQQAppInterface, paramFriends, paramExtensionInfo, paramaghx, (StringBuilder)localObject);
    paramString1 = a(paramQQAppInterface, paramaghx.jdField_b_of_type_JavaLangString, (StringBuilder)localObject);
    localObject = ((StringBuilder)localObject).toString();
    avpd localavpd = new avpd(paramaghx.jdField_b_of_type_JavaLangString, paramaghx.jdField_b_of_type_JavaLangString, (String)localObject, 0, paramInt1, paramInt2, bcrg.a());
    MessageForUniteGrayTip localMessageForUniteGrayTip = new MessageForUniteGrayTip();
    localMessageForUniteGrayTip.hasRead = 0;
    localMessageForUniteGrayTip.subType = paramInt3;
    localMessageForUniteGrayTip.initGrayTipMsg(paramQQAppInterface, localavpd);
    localMessageForUniteGrayTip.tipParam.jdField_d_of_type_JavaLangString = paramString2;
    if (paramInt3 == 998)
    {
      localMessageForUniteGrayTip.caidanAnimUrl = paramaghx.a();
      localMessageForUniteGrayTip.caidanAnimUrl = axsr.c(localMessageForUniteGrayTip.caidanAnimUrl);
      localMessageForUniteGrayTip.caidanAnimUrl = axtc.a(paramQQAppInterface, paramaghx.jdField_b_of_type_JavaLangString, localMessageForUniteGrayTip.caidanAnimUrl);
    }
    for (;;)
    {
      a(paramQQAppInterface, (String)localObject, localavpd, paramString1);
      localMessageForUniteGrayTip.saveExtInfoToExtStr("mutualmark_id", axsr.a(paramaghx.a(), paramaghx.b()));
      paramInt1 = paramaghx.c();
      if (paramInt1 > 0) {
        localMessageForUniteGrayTip.saveExtInfoToExtStr("sub_level", String.valueOf(paramInt1));
      }
      axtc.a(paramQQAppInterface, paramFriends, paramExtensionInfo, paramaghx, (String)localObject, localavpd, paramString1);
      avpe.a(paramQQAppInterface, localMessageForUniteGrayTip);
      axsf.a(paramQQAppInterface, localMessageForUniteGrayTip, localMessageForUniteGrayTip.tipParam.jdField_b_of_type_Int);
      return;
      if (paramInt3 == 999)
      {
        localMessageForUniteGrayTip.caidanAnimUrl = paramaghx.b();
        localMessageForUniteGrayTip.caidanAnimUrl = axsr.c(localMessageForUniteGrayTip.caidanAnimUrl);
        localMessageForUniteGrayTip.caidanAnimUrlMd5 = paramaghx.c();
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, avpd paramavpd, ArrayList<axsn> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {}
    for (;;)
    {
      return;
      paramQQAppInterface = paramArrayList.iterator();
      while (paramQQAppInterface.hasNext())
      {
        paramString = (axsn)paramQQAppInterface.next();
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
            paramavpd.a(paramString.jdField_c_of_type_Int, paramString.jdField_d_of_type_Int, paramArrayList);
          }
          break;
        case 2: 
        case 4: 
          if (!TextUtils.isEmpty(paramString.jdField_c_of_type_JavaLangString))
          {
            paramArrayList = new Bundle();
            paramArrayList.putString("image_resource", paramString.jdField_c_of_type_JavaLangString);
            paramavpd.a(paramString.jdField_c_of_type_Int, paramString.jdField_d_of_type_Int, paramArrayList);
          }
          break;
        case 3: 
          if (!TextUtils.isEmpty(paramString.jdField_c_of_type_JavaLangString))
          {
            paramArrayList = new Bundle();
            paramArrayList.putInt("key_action", 1);
            paramArrayList.putString("key_action_DATA", paramString.jdField_d_of_type_JavaLangString);
            paramavpd.a(paramString.jdField_c_of_type_Int, paramString.jdField_d_of_type_Int, paramArrayList);
          }
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axsl
 * JD-Core Version:    0.7.0.1
 */