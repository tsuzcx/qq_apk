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

public class auod
{
  public static int a(long paramLong1, long paramLong2)
  {
    if ((paramLong1 > 0L) && (paramLong2 >= 0L)) {
      return auoj.a(paramLong1, paramLong2);
    }
    return 0;
  }
  
  public static int a(aend paramaend)
  {
    long l1 = paramaend.a();
    long l2 = paramaend.b();
    if (l1 == 17L)
    {
      if (paramaend.a()) {
        return 999;
      }
      return 0;
    }
    return a(l1, l2);
  }
  
  public static ArrayList<auof> a(QQAppInterface paramQQAppInterface, String paramString, StringBuilder paramStringBuilder)
  {
    Object localObject = Pattern.compile("#(name|icon)_(\\d+)").matcher(paramStringBuilder);
    ArrayList localArrayList = new ArrayList();
    auof localauof;
    int i;
    if (((Matcher)localObject).find())
    {
      localauof = new auof();
      localauof.jdField_a_of_type_JavaLangString = ((Matcher)localObject).group();
      localauof.jdField_b_of_type_Int = ((Matcher)localObject).start();
      localauof.jdField_b_of_type_JavaLangString = ((Matcher)localObject).group(2);
      if (localauof.a()) {}
      for (i = 2;; i = 1)
      {
        localauof.jdField_a_of_type_Int = i;
        localArrayList.add(localauof);
        break;
      }
    }
    localObject = Pattern.compile("\\(([^\\(]+?)\\)\\[([^\\)]+?)\\]").matcher(paramStringBuilder);
    while (((Matcher)localObject).find())
    {
      localauof = new auof();
      localauof.jdField_a_of_type_Int = 3;
      localauof.jdField_a_of_type_JavaLangString = ((Matcher)localObject).group();
      localauof.jdField_b_of_type_Int = ((Matcher)localObject).start();
      localauof.jdField_c_of_type_JavaLangString = ((Matcher)localObject).group(1);
      localauof.jdField_d_of_type_JavaLangString = ((Matcher)localObject).group(2);
      localArrayList.add(localauof);
    }
    localObject = Pattern.compile("#image_url\\{([^\\)]+?)\\}").matcher(paramStringBuilder);
    while (((Matcher)localObject).find())
    {
      localauof = new auof();
      localauof.jdField_a_of_type_Int = 4;
      localauof.jdField_a_of_type_JavaLangString = ((Matcher)localObject).group();
      localauof.jdField_b_of_type_Int = ((Matcher)localObject).start();
      localauof.jdField_d_of_type_JavaLangString = ((Matcher)localObject).group(1);
      localauof.jdField_c_of_type_JavaLangString = localauof.jdField_a_of_type_JavaLangString;
      localArrayList.add(localauof);
    }
    Collections.sort(localArrayList, new auoe());
    localObject = localArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localauof = (auof)((Iterator)localObject).next();
      if (!TextUtils.isEmpty(localauof.jdField_a_of_type_JavaLangString))
      {
        i = paramStringBuilder.indexOf(localauof.jdField_a_of_type_JavaLangString);
        int j = localauof.jdField_a_of_type_JavaLangString.length() + i;
        if ((i >= 0) && (j <= paramStringBuilder.length()))
        {
          switch (localauof.jdField_a_of_type_Int)
          {
          }
          for (;;)
          {
            if (localauof.jdField_c_of_type_JavaLangString == null) {
              localauof.jdField_c_of_type_JavaLangString = localauof.jdField_a_of_type_JavaLangString;
            }
            localauof.jdField_c_of_type_Int = i;
            localauof.jdField_d_of_type_Int = (localauof.jdField_c_of_type_JavaLangString.length() + i);
            paramStringBuilder.replace(i, j, localauof.jdField_c_of_type_JavaLangString);
            break;
            localauof.jdField_c_of_type_JavaLangString = auny.a(paramQQAppInterface, localauof.jdField_b_of_type_JavaLangString);
            continue;
            localauof.jdField_c_of_type_JavaLangString = auny.a(paramQQAppInterface, paramString, localauof.jdField_b_of_type_JavaLangString);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Friends paramFriends, ExtensionInfo paramExtensionInfo, aend paramaend, amgu paramamgu)
  {
    int i = 2097153;
    aenf localaenf = paramaend.a();
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkGrayTipsHelper", 2, "checkAndInsertGrayTips grayInfo:" + localaenf + " onlinePush:" + paramamgu.a);
    }
    int j;
    if ((localaenf != null) && (localaenf.a()))
    {
      j = 0;
      paramamgu = paramaend.jdField_b_of_type_JavaLangString + "_" + paramaend.jdField_a_of_type_Int + "_" + paramamgu.b + "_" + localaenf.jdField_a_of_type_Long;
      switch (paramaend.jdField_a_of_type_Int)
      {
      default: 
        i = 2097155;
      }
    }
    for (;;)
    {
      a(paramQQAppInterface, paramFriends, paramExtensionInfo, paramaend, localaenf.jdField_a_of_type_JavaLangString, -5040, i, j, paramamgu);
      return;
      j = a(paramaend);
      continue;
      i = 2097154;
      continue;
      if ((paramaend.jdField_a_of_type_Aeng == null) || (paramaend.jdField_b_of_type_Aeng == null)) {
        break;
      }
      if (paramaend.jdField_a_of_type_Aeng.a() > paramaend.jdField_b_of_type_Aeng.a())
      {
        i = 2097154;
      }
      else
      {
        if (paramaend.jdField_a_of_type_Aeng.a() >= paramaend.jdField_b_of_type_Aeng.a()) {
          break;
        }
        j = a(paramaend);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Friends paramFriends, ExtensionInfo paramExtensionInfo, aend paramaend, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkGrayTipsHelper", 2, "insertGrayTips friendUin:" + paramaend.jdField_b_of_type_JavaLangString + " grayType:" + paramInt1 + " grayID:" + paramInt2 + " subType:" + paramInt3 + " grayTipKey:" + paramString2 + " _grayTipTemplate:" + paramString1);
    }
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    Object localObject = paramString1;
    if (paramString1.contains("#nick")) {
      localObject = paramString1.replaceAll("#nick", bdbt.m(paramQQAppInterface, paramaend.jdField_b_of_type_JavaLangString));
    }
    localObject = new StringBuilder((String)localObject);
    auou.a(paramQQAppInterface, paramFriends, paramExtensionInfo, paramaend, (StringBuilder)localObject);
    paramString1 = a(paramQQAppInterface, paramaend.jdField_b_of_type_JavaLangString, (StringBuilder)localObject);
    localObject = ((StringBuilder)localObject).toString();
    aslp localaslp = new aslp(paramaend.jdField_b_of_type_JavaLangString, paramaend.jdField_b_of_type_JavaLangString, (String)localObject, 0, paramInt1, paramInt2, ayvc.a());
    MessageForUniteGrayTip localMessageForUniteGrayTip = new MessageForUniteGrayTip();
    localMessageForUniteGrayTip.hasRead = 0;
    localMessageForUniteGrayTip.subType = paramInt3;
    localMessageForUniteGrayTip.initGrayTipMsg(paramQQAppInterface, localaslp);
    localMessageForUniteGrayTip.tipParam.jdField_d_of_type_JavaLangString = paramString2;
    if (paramInt3 == 998) {
      localMessageForUniteGrayTip.caidanAnimUrl = paramaend.a();
    }
    for (;;)
    {
      a(paramQQAppInterface, (String)localObject, localaslp, paramString1);
      localMessageForUniteGrayTip.saveExtInfoToExtStr("mutualmark_id", auoj.a(paramaend.a(), paramaend.b()));
      auou.a(paramQQAppInterface, paramFriends, paramExtensionInfo, paramaend, (String)localObject, localaslp, paramString1);
      aslq.a(paramQQAppInterface, localMessageForUniteGrayTip);
      aunx.a(paramQQAppInterface, localMessageForUniteGrayTip, localMessageForUniteGrayTip.tipParam.jdField_b_of_type_Int);
      return;
      if (paramInt3 == 999)
      {
        localMessageForUniteGrayTip.caidanAnimUrl = paramaend.b();
        localMessageForUniteGrayTip.caidanAnimUrlMd5 = paramaend.c();
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, aslp paramaslp, ArrayList<auof> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {}
    for (;;)
    {
      return;
      paramQQAppInterface = paramArrayList.iterator();
      while (paramQQAppInterface.hasNext())
      {
        paramString = (auof)paramQQAppInterface.next();
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
            paramaslp.a(paramString.jdField_c_of_type_Int, paramString.jdField_d_of_type_Int, paramArrayList);
          }
          break;
        case 2: 
          if (!TextUtils.isEmpty(paramString.jdField_c_of_type_JavaLangString))
          {
            paramArrayList = new Bundle();
            paramArrayList.putString("image_resource", paramString.jdField_c_of_type_JavaLangString);
            paramaslp.a(paramString.jdField_c_of_type_Int, paramString.jdField_d_of_type_Int, paramArrayList);
          }
          break;
        case 3: 
          if (!TextUtils.isEmpty(paramString.jdField_c_of_type_JavaLangString))
          {
            paramArrayList = new Bundle();
            paramArrayList.putInt("key_action", 1);
            paramArrayList.putString("key_action_DATA", paramString.jdField_d_of_type_JavaLangString);
            paramaslp.a(paramString.jdField_c_of_type_Int, paramString.jdField_d_of_type_Int, paramArrayList);
          }
          break;
        case 4: 
          if (!TextUtils.isEmpty(paramString.jdField_c_of_type_JavaLangString))
          {
            paramArrayList = new Bundle();
            paramArrayList.putString("image_resource", paramString.jdField_c_of_type_JavaLangString);
            paramaslp.a(paramString.jdField_c_of_type_Int, paramString.jdField_d_of_type_Int, paramArrayList);
          }
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auod
 * JD-Core Version:    0.7.0.1
 */