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

public class asba
{
  public static int a(long paramLong1, long paramLong2)
  {
    if ((paramLong1 > 0L) && (paramLong2 >= 0L)) {
      return asbg.a(paramLong1, paramLong2);
    }
    return 0;
  }
  
  public static int a(acle paramacle)
  {
    long l1 = paramacle.a();
    long l2 = paramacle.b();
    if (l1 == 17L)
    {
      if (paramacle.a()) {
        return 999;
      }
      return 0;
    }
    return a(l1, l2);
  }
  
  public static ArrayList<asbc> a(QQAppInterface paramQQAppInterface, String paramString, StringBuilder paramStringBuilder)
  {
    Object localObject = Pattern.compile("#(name|icon)_(\\d+)").matcher(paramStringBuilder);
    ArrayList localArrayList = new ArrayList();
    asbc localasbc;
    int i;
    if (((Matcher)localObject).find())
    {
      localasbc = new asbc();
      localasbc.jdField_a_of_type_JavaLangString = ((Matcher)localObject).group();
      localasbc.jdField_b_of_type_Int = ((Matcher)localObject).start();
      localasbc.jdField_b_of_type_JavaLangString = ((Matcher)localObject).group(2);
      if (localasbc.a()) {}
      for (i = 2;; i = 1)
      {
        localasbc.jdField_a_of_type_Int = i;
        localArrayList.add(localasbc);
        break;
      }
    }
    localObject = Pattern.compile("\\((.+?)\\)\\[([^\\)]+?)\\]").matcher(paramStringBuilder);
    while (((Matcher)localObject).find())
    {
      localasbc = new asbc();
      localasbc.jdField_a_of_type_Int = 3;
      localasbc.jdField_a_of_type_JavaLangString = ((Matcher)localObject).group();
      localasbc.jdField_b_of_type_Int = ((Matcher)localObject).start();
      localasbc.jdField_c_of_type_JavaLangString = ((Matcher)localObject).group(1);
      localasbc.jdField_d_of_type_JavaLangString = ((Matcher)localObject).group(2);
      localArrayList.add(localasbc);
    }
    localObject = Pattern.compile("#image_url\\{([^\\)]+?)\\}").matcher(paramStringBuilder);
    while (((Matcher)localObject).find())
    {
      localasbc = new asbc();
      localasbc.jdField_a_of_type_Int = 4;
      localasbc.jdField_a_of_type_JavaLangString = ((Matcher)localObject).group();
      localasbc.jdField_b_of_type_Int = ((Matcher)localObject).start();
      localasbc.jdField_d_of_type_JavaLangString = ((Matcher)localObject).group(1);
      localasbc.jdField_c_of_type_JavaLangString = localasbc.jdField_a_of_type_JavaLangString;
      localArrayList.add(localasbc);
    }
    Collections.sort(localArrayList, new asbb());
    localObject = localArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localasbc = (asbc)((Iterator)localObject).next();
      if (!TextUtils.isEmpty(localasbc.jdField_a_of_type_JavaLangString))
      {
        i = paramStringBuilder.indexOf(localasbc.jdField_a_of_type_JavaLangString);
        int j = localasbc.jdField_a_of_type_JavaLangString.length() + i;
        if ((i >= 0) && (j <= paramStringBuilder.length()))
        {
          switch (localasbc.jdField_a_of_type_Int)
          {
          }
          for (;;)
          {
            if (localasbc.jdField_c_of_type_JavaLangString == null) {
              localasbc.jdField_c_of_type_JavaLangString = localasbc.jdField_a_of_type_JavaLangString;
            }
            localasbc.jdField_c_of_type_Int = i;
            localasbc.jdField_d_of_type_Int = (localasbc.jdField_c_of_type_JavaLangString.length() + i);
            paramStringBuilder.replace(i, j, localasbc.jdField_c_of_type_JavaLangString);
            break;
            localasbc.jdField_c_of_type_JavaLangString = asav.a(paramQQAppInterface, localasbc.jdField_b_of_type_JavaLangString);
            continue;
            localasbc.jdField_c_of_type_JavaLangString = asav.a(paramQQAppInterface, paramString, localasbc.jdField_b_of_type_JavaLangString);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Friends paramFriends, ExtensionInfo paramExtensionInfo, acle paramacle, akcb paramakcb)
  {
    int i = 2097153;
    aclg localaclg = paramacle.a();
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkGrayTipsHelper", 2, "checkAndInsertGrayTips grayInfo:" + localaclg + " onlinePush:" + paramakcb.a);
    }
    int j;
    if ((localaclg != null) && (localaclg.a()))
    {
      j = 0;
      paramakcb = paramacle.jdField_b_of_type_JavaLangString + "_" + paramacle.jdField_a_of_type_Int + "_" + paramakcb.b + "_" + localaclg.jdField_a_of_type_Long;
      switch (paramacle.jdField_a_of_type_Int)
      {
      default: 
        i = 2097155;
      }
    }
    for (;;)
    {
      a(paramQQAppInterface, paramFriends, paramExtensionInfo, paramacle, localaclg.jdField_a_of_type_JavaLangString, -5040, i, j, paramakcb);
      return;
      j = a(paramacle);
      continue;
      i = 2097154;
      continue;
      if ((paramacle.jdField_a_of_type_Aclh == null) || (paramacle.jdField_b_of_type_Aclh == null)) {
        break;
      }
      if (paramacle.jdField_a_of_type_Aclh.a() > paramacle.jdField_b_of_type_Aclh.a())
      {
        i = 2097154;
      }
      else
      {
        if (paramacle.jdField_a_of_type_Aclh.a() >= paramacle.jdField_b_of_type_Aclh.a()) {
          break;
        }
        j = a(paramacle);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Friends paramFriends, ExtensionInfo paramExtensionInfo, acle paramacle, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkGrayTipsHelper", 2, "insertGrayTips friendUin:" + paramacle.jdField_b_of_type_JavaLangString + " grayType:" + paramInt1 + " grayID:" + paramInt2 + " subType:" + paramInt3 + " grayTipKey:" + paramString2 + " _grayTipTemplate:" + paramString1);
    }
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    Object localObject = paramString1;
    if (paramString1.contains("#nick")) {
      localObject = paramString1.replaceAll("#nick", babh.m(paramQQAppInterface, paramacle.jdField_b_of_type_JavaLangString));
    }
    localObject = new StringBuilder((String)localObject);
    asbr.a(paramQQAppInterface, paramFriends, paramExtensionInfo, paramacle, (StringBuilder)localObject);
    paramString1 = a(paramQQAppInterface, paramacle.jdField_b_of_type_JavaLangString, (StringBuilder)localObject);
    localObject = ((StringBuilder)localObject).toString();
    aqax localaqax = new aqax(paramacle.jdField_b_of_type_JavaLangString, paramacle.jdField_b_of_type_JavaLangString, (String)localObject, 0, paramInt1, paramInt2, awao.a());
    MessageForUniteGrayTip localMessageForUniteGrayTip = new MessageForUniteGrayTip();
    localMessageForUniteGrayTip.hasRead = 0;
    localMessageForUniteGrayTip.subType = paramInt3;
    localMessageForUniteGrayTip.initGrayTipMsg(paramQQAppInterface, localaqax);
    localMessageForUniteGrayTip.tipParam.jdField_d_of_type_JavaLangString = paramString2;
    if (paramInt3 == 998) {
      localMessageForUniteGrayTip.caidanAnimUrl = paramacle.a();
    }
    for (;;)
    {
      a(paramQQAppInterface, (String)localObject, localaqax, paramString1);
      localMessageForUniteGrayTip.saveExtInfoToExtStr("mutualmark_id", asbg.a(paramacle.a(), paramacle.b()));
      asbr.a(paramQQAppInterface, paramFriends, paramExtensionInfo, paramacle, (String)localObject, localaqax, paramString1);
      aqay.a(paramQQAppInterface, localMessageForUniteGrayTip);
      asau.a(paramQQAppInterface, localMessageForUniteGrayTip, localMessageForUniteGrayTip.tipParam.jdField_b_of_type_Int);
      return;
      if (paramInt3 == 999)
      {
        localMessageForUniteGrayTip.caidanAnimUrl = paramacle.b();
        localMessageForUniteGrayTip.caidanAnimUrlMd5 = paramacle.c();
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, aqax paramaqax, ArrayList<asbc> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {}
    for (;;)
    {
      return;
      paramQQAppInterface = paramArrayList.iterator();
      while (paramQQAppInterface.hasNext())
      {
        paramString = (asbc)paramQQAppInterface.next();
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
            paramaqax.a(paramString.jdField_c_of_type_Int, paramString.jdField_d_of_type_Int, paramArrayList);
          }
          break;
        case 2: 
          if (!TextUtils.isEmpty(paramString.jdField_c_of_type_JavaLangString))
          {
            paramArrayList = new Bundle();
            paramArrayList.putString("image_resource", paramString.jdField_c_of_type_JavaLangString);
            paramaqax.a(paramString.jdField_c_of_type_Int, paramString.jdField_d_of_type_Int, paramArrayList);
          }
          break;
        case 3: 
          if (!TextUtils.isEmpty(paramString.jdField_c_of_type_JavaLangString))
          {
            paramArrayList = new Bundle();
            paramArrayList.putInt("key_action", 1);
            paramArrayList.putString("key_action_DATA", paramString.jdField_d_of_type_JavaLangString);
            paramaqax.a(paramString.jdField_c_of_type_Int, paramString.jdField_d_of_type_Int, paramArrayList);
          }
          break;
        case 4: 
          if (!TextUtils.isEmpty(paramString.jdField_c_of_type_JavaLangString))
          {
            paramArrayList = new Bundle();
            paramArrayList.putString("image_resource", paramString.jdField_c_of_type_JavaLangString);
            paramaqax.a(paramString.jdField_c_of_type_Int, paramString.jdField_d_of_type_Int, paramArrayList);
          }
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asba
 * JD-Core Version:    0.7.0.1
 */