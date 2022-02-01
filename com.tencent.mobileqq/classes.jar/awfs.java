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

public class awfs
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
      return awfy.a(paramLong1, paramLong2);
    }
    return 0;
  }
  
  public static int a(afat paramafat)
  {
    long l1 = paramafat.a();
    long l2 = paramafat.b();
    if (l1 == 17L) {
      if (!paramafat.a()) {}
    }
    while (paramafat.a())
    {
      return 999;
      return 0;
    }
    if (paramafat.b()) {
      return 998;
    }
    return a(l1, l2);
  }
  
  public static ArrayList<awfu> a(QQAppInterface paramQQAppInterface, String paramString, StringBuilder paramStringBuilder)
  {
    Object localObject = Pattern.compile("#(name|icon)_(\\d+)").matcher(paramStringBuilder);
    ArrayList localArrayList = new ArrayList();
    awfu localawfu;
    int i;
    if (((Matcher)localObject).find())
    {
      localawfu = new awfu();
      localawfu.jdField_a_of_type_JavaLangString = ((Matcher)localObject).group();
      localawfu.jdField_b_of_type_Int = ((Matcher)localObject).start();
      localawfu.jdField_b_of_type_JavaLangString = ((Matcher)localObject).group(2);
      if (localawfu.a()) {}
      for (i = 2;; i = 1)
      {
        localawfu.jdField_a_of_type_Int = i;
        localArrayList.add(localawfu);
        break;
      }
    }
    localObject = Pattern.compile("\\(([^\\(]+?)\\)\\[\\]").matcher(paramStringBuilder);
    while (((Matcher)localObject).find())
    {
      localawfu = new awfu();
      localawfu.jdField_a_of_type_Int = 5;
      localawfu.jdField_a_of_type_JavaLangString = ((Matcher)localObject).group();
      localawfu.jdField_b_of_type_Int = ((Matcher)localObject).start();
      localawfu.jdField_c_of_type_JavaLangString = ((Matcher)localObject).group(1);
      localArrayList.add(localawfu);
    }
    localObject = Pattern.compile("\\(([^\\(]+?)\\)\\[([^\\)]+?)\\]").matcher(paramStringBuilder);
    while (((Matcher)localObject).find())
    {
      localawfu = new awfu();
      localawfu.jdField_a_of_type_Int = 3;
      localawfu.jdField_a_of_type_JavaLangString = ((Matcher)localObject).group();
      localawfu.jdField_b_of_type_Int = ((Matcher)localObject).start();
      localawfu.jdField_c_of_type_JavaLangString = ((Matcher)localObject).group(1);
      localawfu.jdField_d_of_type_JavaLangString = awfy.c(((Matcher)localObject).group(2));
      localArrayList.add(localawfu);
    }
    localObject = Pattern.compile("#image_url\\{([^\\)]+?)\\}").matcher(paramStringBuilder);
    while (((Matcher)localObject).find())
    {
      localawfu = new awfu();
      localawfu.jdField_a_of_type_Int = 4;
      localawfu.jdField_a_of_type_JavaLangString = ((Matcher)localObject).group();
      localawfu.jdField_b_of_type_Int = ((Matcher)localObject).start();
      localawfu.jdField_d_of_type_JavaLangString = awfy.c(((Matcher)localObject).group(1));
      localawfu.jdField_d_of_type_JavaLangString = awgj.a(paramQQAppInterface, paramString, localawfu.jdField_d_of_type_JavaLangString);
      localawfu.jdField_c_of_type_JavaLangString = localawfu.jdField_a_of_type_JavaLangString.replace(((Matcher)localObject).group(1), localawfu.jdField_d_of_type_JavaLangString);
      localArrayList.add(localawfu);
    }
    Collections.sort(localArrayList, new awft());
    localObject = localArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localawfu = (awfu)((Iterator)localObject).next();
      if (!TextUtils.isEmpty(localawfu.jdField_a_of_type_JavaLangString))
      {
        i = paramStringBuilder.indexOf(localawfu.jdField_a_of_type_JavaLangString);
        int j = localawfu.jdField_a_of_type_JavaLangString.length() + i;
        if ((i >= 0) && (j <= paramStringBuilder.length()))
        {
          switch (localawfu.jdField_a_of_type_Int)
          {
          }
          for (;;)
          {
            if (localawfu.jdField_c_of_type_JavaLangString == null) {
              localawfu.jdField_c_of_type_JavaLangString = localawfu.jdField_a_of_type_JavaLangString;
            }
            localawfu.jdField_c_of_type_Int = i;
            localawfu.jdField_d_of_type_Int = (localawfu.jdField_c_of_type_JavaLangString.length() + i);
            paramStringBuilder.replace(i, j, localawfu.jdField_c_of_type_JavaLangString);
            break;
            localawfu.jdField_c_of_type_JavaLangString = awfn.a(paramQQAppInterface, localawfu.jdField_b_of_type_JavaLangString);
            continue;
            localawfu.jdField_c_of_type_JavaLangString = awfn.a(paramQQAppInterface, paramString, localawfu.jdField_b_of_type_JavaLangString);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Friends paramFriends, ExtensionInfo paramExtensionInfo, afat paramafat, anlx paramanlx)
  {
    int i = 2097153;
    afav localafav = paramafat.a();
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkGrayTipsHelper", 2, "checkAndInsertGrayTips grayInfo:" + localafav + " onlinePush:" + paramanlx.a);
    }
    int j;
    if ((localafav != null) && (localafav.a()))
    {
      j = 0;
      if (TextUtils.isEmpty(localafav.jdField_b_of_type_JavaLangString)) {
        break label203;
      }
      paramanlx = localafav.jdField_b_of_type_JavaLangString;
      switch (paramafat.jdField_a_of_type_Int)
      {
      default: 
        label168:
        i = 2097155;
      }
    }
    for (;;)
    {
      int k = a(localafav.jdField_a_of_type_Int);
      a(paramQQAppInterface, paramFriends, paramExtensionInfo, paramafat, localafav.jdField_a_of_type_JavaLangString, k, i, j, paramanlx);
      return;
      label203:
      paramanlx = paramafat.jdField_b_of_type_JavaLangString + "_" + paramafat.jdField_a_of_type_Int + "_" + paramanlx.b + "_" + localafav.jdField_a_of_type_Long;
      break;
      j = a(paramafat);
      continue;
      i = 2097154;
      continue;
      if ((paramafat.jdField_a_of_type_Afaw == null) || (paramafat.jdField_b_of_type_Afaw == null)) {
        break label168;
      }
      if (paramafat.jdField_a_of_type_Afaw.a() > paramafat.jdField_b_of_type_Afaw.a())
      {
        i = 2097154;
      }
      else
      {
        if (paramafat.jdField_a_of_type_Afaw.a() >= paramafat.jdField_b_of_type_Afaw.a()) {
          break label168;
        }
        j = a(paramafat);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Friends paramFriends, ExtensionInfo paramExtensionInfo, afat paramafat, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkGrayTipsHelper", 2, "insertGrayTips friendUin:" + paramafat.jdField_b_of_type_JavaLangString + " grayType:" + paramInt1 + " grayID:" + paramInt2 + " subType:" + paramInt3 + " grayTipKey:" + paramString2 + " _grayTipTemplate:" + paramString1);
    }
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    Object localObject = paramString1;
    if (paramString1.contains("#nick")) {
      localObject = paramString1.replaceAll("#nick", ContactUtils.getFriendShowName(paramQQAppInterface, paramafat.jdField_b_of_type_JavaLangString));
    }
    localObject = new StringBuilder((String)localObject);
    awgj.a(paramQQAppInterface, paramFriends, paramExtensionInfo, paramafat, (StringBuilder)localObject);
    paramString1 = a(paramQQAppInterface, paramafat.jdField_b_of_type_JavaLangString, (StringBuilder)localObject);
    localObject = ((StringBuilder)localObject).toString();
    aucf localaucf = new aucf(paramafat.jdField_b_of_type_JavaLangString, paramafat.jdField_b_of_type_JavaLangString, (String)localObject, 0, paramInt1, paramInt2, bbko.a());
    MessageForUniteGrayTip localMessageForUniteGrayTip = new MessageForUniteGrayTip();
    localMessageForUniteGrayTip.hasRead = 0;
    localMessageForUniteGrayTip.subType = paramInt3;
    localMessageForUniteGrayTip.initGrayTipMsg(paramQQAppInterface, localaucf);
    localMessageForUniteGrayTip.tipParam.jdField_d_of_type_JavaLangString = paramString2;
    if (paramInt3 == 998)
    {
      localMessageForUniteGrayTip.caidanAnimUrl = paramafat.a();
      localMessageForUniteGrayTip.caidanAnimUrl = awfy.c(localMessageForUniteGrayTip.caidanAnimUrl);
      localMessageForUniteGrayTip.caidanAnimUrl = awgj.a(paramQQAppInterface, paramafat.jdField_b_of_type_JavaLangString, localMessageForUniteGrayTip.caidanAnimUrl);
    }
    for (;;)
    {
      a(paramQQAppInterface, (String)localObject, localaucf, paramString1);
      localMessageForUniteGrayTip.saveExtInfoToExtStr("mutualmark_id", awfy.a(paramafat.a(), paramafat.b()));
      paramInt1 = paramafat.c();
      if (paramInt1 > 0) {
        localMessageForUniteGrayTip.saveExtInfoToExtStr("sub_level", String.valueOf(paramInt1));
      }
      awgj.a(paramQQAppInterface, paramFriends, paramExtensionInfo, paramafat, (String)localObject, localaucf, paramString1);
      aucg.a(paramQQAppInterface, localMessageForUniteGrayTip);
      awfm.a(paramQQAppInterface, localMessageForUniteGrayTip, localMessageForUniteGrayTip.tipParam.jdField_b_of_type_Int);
      return;
      if (paramInt3 == 999)
      {
        localMessageForUniteGrayTip.caidanAnimUrl = paramafat.b();
        localMessageForUniteGrayTip.caidanAnimUrl = awfy.c(localMessageForUniteGrayTip.caidanAnimUrl);
        localMessageForUniteGrayTip.caidanAnimUrlMd5 = paramafat.c();
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, aucf paramaucf, ArrayList<awfu> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {}
    for (;;)
    {
      return;
      paramQQAppInterface = paramArrayList.iterator();
      while (paramQQAppInterface.hasNext())
      {
        paramString = (awfu)paramQQAppInterface.next();
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
            paramaucf.a(paramString.jdField_c_of_type_Int, paramString.jdField_d_of_type_Int, paramArrayList);
          }
          break;
        case 2: 
        case 4: 
          if (!TextUtils.isEmpty(paramString.jdField_c_of_type_JavaLangString))
          {
            paramArrayList = new Bundle();
            paramArrayList.putString("image_resource", paramString.jdField_c_of_type_JavaLangString);
            paramaucf.a(paramString.jdField_c_of_type_Int, paramString.jdField_d_of_type_Int, paramArrayList);
          }
          break;
        case 3: 
          if ((!TextUtils.isEmpty(paramString.jdField_c_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramString.jdField_d_of_type_JavaLangString)))
          {
            paramArrayList = new Bundle();
            paramArrayList.putInt("key_action", 1);
            paramArrayList.putString("key_action_DATA", paramString.jdField_d_of_type_JavaLangString);
            paramaucf.a(paramString.jdField_c_of_type_Int, paramString.jdField_d_of_type_Int, paramArrayList);
          }
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awfs
 * JD-Core Version:    0.7.0.1
 */