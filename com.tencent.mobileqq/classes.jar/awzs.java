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

public class awzs
{
  public static int a(long paramLong1, long paramLong2)
  {
    if ((paramLong1 > 0L) && (paramLong2 >= 0L)) {
      return awzy.a(paramLong1, paramLong2);
    }
    return 0;
  }
  
  public static int a(afyd paramafyd)
  {
    long l1 = paramafyd.a();
    long l2 = paramafyd.b();
    if (l1 == 17L)
    {
      if (paramafyd.a()) {
        return 999;
      }
      return 0;
    }
    return a(l1, l2);
  }
  
  public static ArrayList<awzu> a(QQAppInterface paramQQAppInterface, String paramString, StringBuilder paramStringBuilder)
  {
    Object localObject = Pattern.compile("#(name|icon)_(\\d+)").matcher(paramStringBuilder);
    ArrayList localArrayList = new ArrayList();
    awzu localawzu;
    int i;
    if (((Matcher)localObject).find())
    {
      localawzu = new awzu();
      localawzu.jdField_a_of_type_JavaLangString = ((Matcher)localObject).group();
      localawzu.jdField_b_of_type_Int = ((Matcher)localObject).start();
      localawzu.jdField_b_of_type_JavaLangString = ((Matcher)localObject).group(2);
      if (localawzu.a()) {}
      for (i = 2;; i = 1)
      {
        localawzu.jdField_a_of_type_Int = i;
        localArrayList.add(localawzu);
        break;
      }
    }
    localObject = Pattern.compile("\\(([^\\(]+?)\\)\\[([^\\)]+?)\\]").matcher(paramStringBuilder);
    while (((Matcher)localObject).find())
    {
      localawzu = new awzu();
      localawzu.jdField_a_of_type_Int = 3;
      localawzu.jdField_a_of_type_JavaLangString = ((Matcher)localObject).group();
      localawzu.jdField_b_of_type_Int = ((Matcher)localObject).start();
      localawzu.jdField_c_of_type_JavaLangString = ((Matcher)localObject).group(1);
      localawzu.jdField_d_of_type_JavaLangString = ((Matcher)localObject).group(2);
      localArrayList.add(localawzu);
    }
    localObject = Pattern.compile("#image_url\\{([^\\)]+?)\\}").matcher(paramStringBuilder);
    while (((Matcher)localObject).find())
    {
      localawzu = new awzu();
      localawzu.jdField_a_of_type_Int = 4;
      localawzu.jdField_a_of_type_JavaLangString = ((Matcher)localObject).group();
      localawzu.jdField_b_of_type_Int = ((Matcher)localObject).start();
      localawzu.jdField_d_of_type_JavaLangString = ((Matcher)localObject).group(1);
      localawzu.jdField_c_of_type_JavaLangString = localawzu.jdField_a_of_type_JavaLangString;
      localArrayList.add(localawzu);
    }
    Collections.sort(localArrayList, new awzt());
    localObject = localArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localawzu = (awzu)((Iterator)localObject).next();
      if (!TextUtils.isEmpty(localawzu.jdField_a_of_type_JavaLangString))
      {
        i = paramStringBuilder.indexOf(localawzu.jdField_a_of_type_JavaLangString);
        int j = localawzu.jdField_a_of_type_JavaLangString.length() + i;
        if ((i >= 0) && (j <= paramStringBuilder.length()))
        {
          switch (localawzu.jdField_a_of_type_Int)
          {
          }
          for (;;)
          {
            if (localawzu.jdField_c_of_type_JavaLangString == null) {
              localawzu.jdField_c_of_type_JavaLangString = localawzu.jdField_a_of_type_JavaLangString;
            }
            localawzu.jdField_c_of_type_Int = i;
            localawzu.jdField_d_of_type_Int = (localawzu.jdField_c_of_type_JavaLangString.length() + i);
            paramStringBuilder.replace(i, j, localawzu.jdField_c_of_type_JavaLangString);
            break;
            localawzu.jdField_c_of_type_JavaLangString = awzn.a(paramQQAppInterface, localawzu.jdField_b_of_type_JavaLangString);
            continue;
            localawzu.jdField_c_of_type_JavaLangString = awzn.a(paramQQAppInterface, paramString, localawzu.jdField_b_of_type_JavaLangString);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Friends paramFriends, ExtensionInfo paramExtensionInfo, afyd paramafyd, aofx paramaofx)
  {
    int i = 2097153;
    afyf localafyf = paramafyd.a();
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkGrayTipsHelper", 2, "checkAndInsertGrayTips grayInfo:" + localafyf + " onlinePush:" + paramaofx.a);
    }
    int k;
    int j;
    if ((localafyf != null) && (localafyf.a()))
    {
      k = -5040;
      j = 0;
      if (TextUtils.isEmpty(localafyf.jdField_b_of_type_JavaLangString)) {
        break label209;
      }
      paramaofx = localafyf.jdField_b_of_type_JavaLangString;
      switch (paramafyd.jdField_a_of_type_Int)
      {
      default: 
        label172:
        i = 2097155;
      }
    }
    for (;;)
    {
      if (a(paramafyd)) {
        k = -5020;
      }
      a(paramQQAppInterface, paramFriends, paramExtensionInfo, paramafyd, localafyf.jdField_a_of_type_JavaLangString, k, i, j, paramaofx);
      return;
      label209:
      paramaofx = paramafyd.jdField_b_of_type_JavaLangString + "_" + paramafyd.jdField_a_of_type_Int + "_" + paramaofx.b + "_" + localafyf.jdField_a_of_type_Long;
      break;
      j = a(paramafyd);
      continue;
      i = 2097154;
      continue;
      if ((paramafyd.jdField_a_of_type_Afyg == null) || (paramafyd.jdField_b_of_type_Afyg == null)) {
        break label172;
      }
      if (paramafyd.jdField_a_of_type_Afyg.a() > paramafyd.jdField_b_of_type_Afyg.a())
      {
        i = 2097154;
      }
      else
      {
        if (paramafyd.jdField_a_of_type_Afyg.a() >= paramafyd.jdField_b_of_type_Afyg.a()) {
          break label172;
        }
        j = a(paramafyd);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Friends paramFriends, ExtensionInfo paramExtensionInfo, afyd paramafyd, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkGrayTipsHelper", 2, "insertGrayTips friendUin:" + paramafyd.jdField_b_of_type_JavaLangString + " grayType:" + paramInt1 + " grayID:" + paramInt2 + " subType:" + paramInt3 + " grayTipKey:" + paramString2 + " _grayTipTemplate:" + paramString1);
    }
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    Object localObject = paramString1;
    if (paramString1.contains("#nick")) {
      localObject = paramString1.replaceAll("#nick", bglf.m(paramQQAppInterface, paramafyd.jdField_b_of_type_JavaLangString));
    }
    localObject = new StringBuilder((String)localObject);
    axaj.a(paramQQAppInterface, paramFriends, paramExtensionInfo, paramafyd, (StringBuilder)localObject);
    paramString1 = a(paramQQAppInterface, paramafyd.jdField_b_of_type_JavaLangString, (StringBuilder)localObject);
    localObject = ((StringBuilder)localObject).toString();
    auxc localauxc = new auxc(paramafyd.jdField_b_of_type_JavaLangString, paramafyd.jdField_b_of_type_JavaLangString, (String)localObject, 0, paramInt1, paramInt2, bbyp.a());
    MessageForUniteGrayTip localMessageForUniteGrayTip = new MessageForUniteGrayTip();
    localMessageForUniteGrayTip.hasRead = 0;
    localMessageForUniteGrayTip.subType = paramInt3;
    localMessageForUniteGrayTip.initGrayTipMsg(paramQQAppInterface, localauxc);
    localMessageForUniteGrayTip.tipParam.jdField_d_of_type_JavaLangString = paramString2;
    if (paramInt3 == 998) {
      localMessageForUniteGrayTip.caidanAnimUrl = paramafyd.a();
    }
    for (;;)
    {
      a(paramQQAppInterface, (String)localObject, localauxc, paramString1);
      localMessageForUniteGrayTip.saveExtInfoToExtStr("mutualmark_id", awzy.a(paramafyd.a(), paramafyd.b()));
      axaj.a(paramQQAppInterface, paramFriends, paramExtensionInfo, paramafyd, (String)localObject, localauxc, paramString1);
      auxd.a(paramQQAppInterface, localMessageForUniteGrayTip);
      awzm.a(paramQQAppInterface, localMessageForUniteGrayTip, localMessageForUniteGrayTip.tipParam.jdField_b_of_type_Int);
      return;
      if (paramInt3 == 999)
      {
        localMessageForUniteGrayTip.caidanAnimUrl = paramafyd.b();
        localMessageForUniteGrayTip.caidanAnimUrlMd5 = paramafyd.c();
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, auxc paramauxc, ArrayList<awzu> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {}
    for (;;)
    {
      return;
      paramQQAppInterface = paramArrayList.iterator();
      while (paramQQAppInterface.hasNext())
      {
        paramString = (awzu)paramQQAppInterface.next();
        if (QLog.isColorLevel()) {
          QLog.d("MutualMarkGrayTipsHelper", 2, "handleHighlightInfo item=" + paramString);
        }
        switch (paramString.jdField_a_of_type_Int)
        {
        default: 
          break;
        case 1: 
          if (!TextUtils.isEmpty(paramString.jdField_c_of_type_JavaLangString))
          {
            paramArrayList = new Bundle();
            paramArrayList.putInt("key_action", 11);
            paramArrayList.putString("key_action_DATA", paramString.jdField_c_of_type_JavaLangString);
            paramauxc.a(paramString.jdField_c_of_type_Int, paramString.jdField_d_of_type_Int, paramArrayList);
          }
          break;
        case 2: 
          if (!TextUtils.isEmpty(paramString.jdField_c_of_type_JavaLangString))
          {
            paramArrayList = new Bundle();
            paramArrayList.putString("image_resource", paramString.jdField_c_of_type_JavaLangString);
            paramauxc.a(paramString.jdField_c_of_type_Int, paramString.jdField_d_of_type_Int, paramArrayList);
          }
          break;
        case 3: 
          if (!TextUtils.isEmpty(paramString.jdField_c_of_type_JavaLangString))
          {
            paramArrayList = new Bundle();
            paramArrayList.putInt("key_action", 1);
            paramArrayList.putString("key_action_DATA", paramString.jdField_d_of_type_JavaLangString);
            paramauxc.a(paramString.jdField_c_of_type_Int, paramString.jdField_d_of_type_Int, paramArrayList);
          }
          break;
        case 4: 
          if (!TextUtils.isEmpty(paramString.jdField_c_of_type_JavaLangString))
          {
            paramArrayList = new Bundle();
            paramArrayList.putString("image_resource", paramString.jdField_c_of_type_JavaLangString);
            paramauxc.a(paramString.jdField_c_of_type_Int, paramString.jdField_d_of_type_Int, paramArrayList);
          }
          break;
        }
      }
    }
  }
  
  public static boolean a(afyd paramafyd)
  {
    long l1 = paramafyd.a();
    long l2 = paramafyd.b();
    return (l1 == 21L) && (l2 == 1L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awzs
 * JD-Core Version:    0.7.0.1
 */