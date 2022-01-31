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

public class ausm
{
  public static int a(long paramLong1, long paramLong2)
  {
    if ((paramLong1 > 0L) && (paramLong2 >= 0L)) {
      return auss.a(paramLong1, paramLong2);
    }
    return 0;
  }
  
  public static int a(aers paramaers)
  {
    long l1 = paramaers.a();
    long l2 = paramaers.b();
    if (l1 == 17L)
    {
      if (paramaers.a()) {
        return 999;
      }
      return 0;
    }
    return a(l1, l2);
  }
  
  public static ArrayList<auso> a(QQAppInterface paramQQAppInterface, String paramString, StringBuilder paramStringBuilder)
  {
    Object localObject = Pattern.compile("#(name|icon)_(\\d+)").matcher(paramStringBuilder);
    ArrayList localArrayList = new ArrayList();
    auso localauso;
    int i;
    if (((Matcher)localObject).find())
    {
      localauso = new auso();
      localauso.jdField_a_of_type_JavaLangString = ((Matcher)localObject).group();
      localauso.jdField_b_of_type_Int = ((Matcher)localObject).start();
      localauso.jdField_b_of_type_JavaLangString = ((Matcher)localObject).group(2);
      if (localauso.a()) {}
      for (i = 2;; i = 1)
      {
        localauso.jdField_a_of_type_Int = i;
        localArrayList.add(localauso);
        break;
      }
    }
    localObject = Pattern.compile("\\(([^\\(]+?)\\)\\[([^\\)]+?)\\]").matcher(paramStringBuilder);
    while (((Matcher)localObject).find())
    {
      localauso = new auso();
      localauso.jdField_a_of_type_Int = 3;
      localauso.jdField_a_of_type_JavaLangString = ((Matcher)localObject).group();
      localauso.jdField_b_of_type_Int = ((Matcher)localObject).start();
      localauso.jdField_c_of_type_JavaLangString = ((Matcher)localObject).group(1);
      localauso.jdField_d_of_type_JavaLangString = ((Matcher)localObject).group(2);
      localArrayList.add(localauso);
    }
    localObject = Pattern.compile("#image_url\\{([^\\)]+?)\\}").matcher(paramStringBuilder);
    while (((Matcher)localObject).find())
    {
      localauso = new auso();
      localauso.jdField_a_of_type_Int = 4;
      localauso.jdField_a_of_type_JavaLangString = ((Matcher)localObject).group();
      localauso.jdField_b_of_type_Int = ((Matcher)localObject).start();
      localauso.jdField_d_of_type_JavaLangString = ((Matcher)localObject).group(1);
      localauso.jdField_c_of_type_JavaLangString = localauso.jdField_a_of_type_JavaLangString;
      localArrayList.add(localauso);
    }
    Collections.sort(localArrayList, new ausn());
    localObject = localArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localauso = (auso)((Iterator)localObject).next();
      if (!TextUtils.isEmpty(localauso.jdField_a_of_type_JavaLangString))
      {
        i = paramStringBuilder.indexOf(localauso.jdField_a_of_type_JavaLangString);
        int j = localauso.jdField_a_of_type_JavaLangString.length() + i;
        if ((i >= 0) && (j <= paramStringBuilder.length()))
        {
          switch (localauso.jdField_a_of_type_Int)
          {
          }
          for (;;)
          {
            if (localauso.jdField_c_of_type_JavaLangString == null) {
              localauso.jdField_c_of_type_JavaLangString = localauso.jdField_a_of_type_JavaLangString;
            }
            localauso.jdField_c_of_type_Int = i;
            localauso.jdField_d_of_type_Int = (localauso.jdField_c_of_type_JavaLangString.length() + i);
            paramStringBuilder.replace(i, j, localauso.jdField_c_of_type_JavaLangString);
            break;
            localauso.jdField_c_of_type_JavaLangString = aush.a(paramQQAppInterface, localauso.jdField_b_of_type_JavaLangString);
            continue;
            localauso.jdField_c_of_type_JavaLangString = aush.a(paramQQAppInterface, paramString, localauso.jdField_b_of_type_JavaLangString);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Friends paramFriends, ExtensionInfo paramExtensionInfo, aers paramaers, amlj paramamlj)
  {
    int i = 2097153;
    aeru localaeru = paramaers.a();
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkGrayTipsHelper", 2, "checkAndInsertGrayTips grayInfo:" + localaeru + " onlinePush:" + paramamlj.a);
    }
    int j;
    if ((localaeru != null) && (localaeru.a()))
    {
      j = 0;
      paramamlj = paramaers.jdField_b_of_type_JavaLangString + "_" + paramaers.jdField_a_of_type_Int + "_" + paramamlj.b + "_" + localaeru.jdField_a_of_type_Long;
      switch (paramaers.jdField_a_of_type_Int)
      {
      default: 
        i = 2097155;
      }
    }
    for (;;)
    {
      a(paramQQAppInterface, paramFriends, paramExtensionInfo, paramaers, localaeru.jdField_a_of_type_JavaLangString, -5040, i, j, paramamlj);
      return;
      j = a(paramaers);
      continue;
      i = 2097154;
      continue;
      if ((paramaers.jdField_a_of_type_Aerv == null) || (paramaers.jdField_b_of_type_Aerv == null)) {
        break;
      }
      if (paramaers.jdField_a_of_type_Aerv.a() > paramaers.jdField_b_of_type_Aerv.a())
      {
        i = 2097154;
      }
      else
      {
        if (paramaers.jdField_a_of_type_Aerv.a() >= paramaers.jdField_b_of_type_Aerv.a()) {
          break;
        }
        j = a(paramaers);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Friends paramFriends, ExtensionInfo paramExtensionInfo, aers paramaers, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkGrayTipsHelper", 2, "insertGrayTips friendUin:" + paramaers.jdField_b_of_type_JavaLangString + " grayType:" + paramInt1 + " grayID:" + paramInt2 + " subType:" + paramInt3 + " grayTipKey:" + paramString2 + " _grayTipTemplate:" + paramString1);
    }
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    Object localObject = paramString1;
    if (paramString1.contains("#nick")) {
      localObject = paramString1.replaceAll("#nick", bdgc.m(paramQQAppInterface, paramaers.jdField_b_of_type_JavaLangString));
    }
    localObject = new StringBuilder((String)localObject);
    autd.a(paramQQAppInterface, paramFriends, paramExtensionInfo, paramaers, (StringBuilder)localObject);
    paramString1 = a(paramQQAppInterface, paramaers.jdField_b_of_type_JavaLangString, (StringBuilder)localObject);
    localObject = ((StringBuilder)localObject).toString();
    aspy localaspy = new aspy(paramaers.jdField_b_of_type_JavaLangString, paramaers.jdField_b_of_type_JavaLangString, (String)localObject, 0, paramInt1, paramInt2, ayzl.a());
    MessageForUniteGrayTip localMessageForUniteGrayTip = new MessageForUniteGrayTip();
    localMessageForUniteGrayTip.hasRead = 0;
    localMessageForUniteGrayTip.subType = paramInt3;
    localMessageForUniteGrayTip.initGrayTipMsg(paramQQAppInterface, localaspy);
    localMessageForUniteGrayTip.tipParam.jdField_d_of_type_JavaLangString = paramString2;
    if (paramInt3 == 998) {
      localMessageForUniteGrayTip.caidanAnimUrl = paramaers.a();
    }
    for (;;)
    {
      a(paramQQAppInterface, (String)localObject, localaspy, paramString1);
      localMessageForUniteGrayTip.saveExtInfoToExtStr("mutualmark_id", auss.a(paramaers.a(), paramaers.b()));
      autd.a(paramQQAppInterface, paramFriends, paramExtensionInfo, paramaers, (String)localObject, localaspy, paramString1);
      aspz.a(paramQQAppInterface, localMessageForUniteGrayTip);
      ausg.a(paramQQAppInterface, localMessageForUniteGrayTip, localMessageForUniteGrayTip.tipParam.jdField_b_of_type_Int);
      return;
      if (paramInt3 == 999)
      {
        localMessageForUniteGrayTip.caidanAnimUrl = paramaers.b();
        localMessageForUniteGrayTip.caidanAnimUrlMd5 = paramaers.c();
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, aspy paramaspy, ArrayList<auso> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {}
    for (;;)
    {
      return;
      paramQQAppInterface = paramArrayList.iterator();
      while (paramQQAppInterface.hasNext())
      {
        paramString = (auso)paramQQAppInterface.next();
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
            paramaspy.a(paramString.jdField_c_of_type_Int, paramString.jdField_d_of_type_Int, paramArrayList);
          }
          break;
        case 2: 
          if (!TextUtils.isEmpty(paramString.jdField_c_of_type_JavaLangString))
          {
            paramArrayList = new Bundle();
            paramArrayList.putString("image_resource", paramString.jdField_c_of_type_JavaLangString);
            paramaspy.a(paramString.jdField_c_of_type_Int, paramString.jdField_d_of_type_Int, paramArrayList);
          }
          break;
        case 3: 
          if (!TextUtils.isEmpty(paramString.jdField_c_of_type_JavaLangString))
          {
            paramArrayList = new Bundle();
            paramArrayList.putInt("key_action", 1);
            paramArrayList.putString("key_action_DATA", paramString.jdField_d_of_type_JavaLangString);
            paramaspy.a(paramString.jdField_c_of_type_Int, paramString.jdField_d_of_type_Int, paramArrayList);
          }
          break;
        case 4: 
          if (!TextUtils.isEmpty(paramString.jdField_c_of_type_JavaLangString))
          {
            paramArrayList = new Bundle();
            paramArrayList.putString("image_resource", paramString.jdField_c_of_type_JavaLangString);
            paramaspy.a(paramString.jdField_c_of_type_Int, paramString.jdField_d_of_type_Int, paramArrayList);
          }
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ausm
 * JD-Core Version:    0.7.0.1
 */