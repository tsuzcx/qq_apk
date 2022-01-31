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

public class asxe
{
  public static int a(long paramLong1, long paramLong2)
  {
    if ((paramLong1 > 0L) && (paramLong2 >= 0L)) {
      return asxk.a(paramLong1, paramLong2);
    }
    return 0;
  }
  
  public static int a(acvx paramacvx)
  {
    long l1 = paramacvx.a();
    long l2 = paramacvx.b();
    if (l1 == 17L)
    {
      if (paramacvx.a()) {
        return 999;
      }
      return 0;
    }
    return a(l1, l2);
  }
  
  public static ArrayList<asxg> a(QQAppInterface paramQQAppInterface, String paramString, StringBuilder paramStringBuilder)
  {
    Object localObject = Pattern.compile("#(name|icon)_(\\d+)").matcher(paramStringBuilder);
    ArrayList localArrayList = new ArrayList();
    asxg localasxg;
    int i;
    if (((Matcher)localObject).find())
    {
      localasxg = new asxg();
      localasxg.jdField_a_of_type_JavaLangString = ((Matcher)localObject).group();
      localasxg.jdField_b_of_type_Int = ((Matcher)localObject).start();
      localasxg.jdField_b_of_type_JavaLangString = ((Matcher)localObject).group(2);
      if (localasxg.a()) {}
      for (i = 2;; i = 1)
      {
        localasxg.jdField_a_of_type_Int = i;
        localArrayList.add(localasxg);
        break;
      }
    }
    localObject = Pattern.compile("\\((.+?)\\)\\[([^\\)]+?)\\]").matcher(paramStringBuilder);
    while (((Matcher)localObject).find())
    {
      localasxg = new asxg();
      localasxg.jdField_a_of_type_Int = 3;
      localasxg.jdField_a_of_type_JavaLangString = ((Matcher)localObject).group();
      localasxg.jdField_b_of_type_Int = ((Matcher)localObject).start();
      localasxg.jdField_c_of_type_JavaLangString = ((Matcher)localObject).group(1);
      localasxg.jdField_d_of_type_JavaLangString = ((Matcher)localObject).group(2);
      localArrayList.add(localasxg);
    }
    localObject = Pattern.compile("#image_url\\{([^\\)]+?)\\}").matcher(paramStringBuilder);
    while (((Matcher)localObject).find())
    {
      localasxg = new asxg();
      localasxg.jdField_a_of_type_Int = 4;
      localasxg.jdField_a_of_type_JavaLangString = ((Matcher)localObject).group();
      localasxg.jdField_b_of_type_Int = ((Matcher)localObject).start();
      localasxg.jdField_d_of_type_JavaLangString = ((Matcher)localObject).group(1);
      localasxg.jdField_c_of_type_JavaLangString = localasxg.jdField_a_of_type_JavaLangString;
      localArrayList.add(localasxg);
    }
    Collections.sort(localArrayList, new asxf());
    localObject = localArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localasxg = (asxg)((Iterator)localObject).next();
      if (!TextUtils.isEmpty(localasxg.jdField_a_of_type_JavaLangString))
      {
        i = paramStringBuilder.indexOf(localasxg.jdField_a_of_type_JavaLangString);
        int j = localasxg.jdField_a_of_type_JavaLangString.length() + i;
        if ((i >= 0) && (j <= paramStringBuilder.length()))
        {
          switch (localasxg.jdField_a_of_type_Int)
          {
          }
          for (;;)
          {
            if (localasxg.jdField_c_of_type_JavaLangString == null) {
              localasxg.jdField_c_of_type_JavaLangString = localasxg.jdField_a_of_type_JavaLangString;
            }
            localasxg.jdField_c_of_type_Int = i;
            localasxg.jdField_d_of_type_Int = (localasxg.jdField_c_of_type_JavaLangString.length() + i);
            paramStringBuilder.replace(i, j, localasxg.jdField_c_of_type_JavaLangString);
            break;
            localasxg.jdField_c_of_type_JavaLangString = aswz.a(paramQQAppInterface, localasxg.jdField_b_of_type_JavaLangString);
            continue;
            localasxg.jdField_c_of_type_JavaLangString = aswz.a(paramQQAppInterface, paramString, localasxg.jdField_b_of_type_JavaLangString);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Friends paramFriends, ExtensionInfo paramExtensionInfo, acvx paramacvx, akqn paramakqn)
  {
    int i = 2097153;
    acvz localacvz = paramacvx.a();
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkGrayTipsHelper", 2, "checkAndInsertGrayTips grayInfo:" + localacvz + " onlinePush:" + paramakqn.a);
    }
    int j;
    if ((localacvz != null) && (localacvz.a()))
    {
      j = 0;
      paramakqn = paramacvx.jdField_b_of_type_JavaLangString + "_" + paramacvx.jdField_a_of_type_Int + "_" + paramakqn.b + "_" + localacvz.jdField_a_of_type_Long;
      switch (paramacvx.jdField_a_of_type_Int)
      {
      default: 
        i = 2097155;
      }
    }
    for (;;)
    {
      a(paramQQAppInterface, paramFriends, paramExtensionInfo, paramacvx, localacvz.jdField_a_of_type_JavaLangString, -5040, i, j, paramakqn);
      return;
      j = a(paramacvx);
      continue;
      i = 2097154;
      continue;
      if ((paramacvx.jdField_a_of_type_Acwa == null) || (paramacvx.jdField_b_of_type_Acwa == null)) {
        break;
      }
      if (paramacvx.jdField_a_of_type_Acwa.a() > paramacvx.jdField_b_of_type_Acwa.a())
      {
        i = 2097154;
      }
      else
      {
        if (paramacvx.jdField_a_of_type_Acwa.a() >= paramacvx.jdField_b_of_type_Acwa.a()) {
          break;
        }
        j = a(paramacvx);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Friends paramFriends, ExtensionInfo paramExtensionInfo, acvx paramacvx, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkGrayTipsHelper", 2, "insertGrayTips friendUin:" + paramacvx.jdField_b_of_type_JavaLangString + " grayType:" + paramInt1 + " grayID:" + paramInt2 + " subType:" + paramInt3 + " grayTipKey:" + paramString2 + " _grayTipTemplate:" + paramString1);
    }
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    Object localObject = paramString1;
    if (paramString1.contains("#nick")) {
      localObject = paramString1.replaceAll("#nick", bbcl.m(paramQQAppInterface, paramacvx.jdField_b_of_type_JavaLangString));
    }
    localObject = new StringBuilder((String)localObject);
    asxv.a(paramQQAppInterface, paramFriends, paramExtensionInfo, paramacvx, (StringBuilder)localObject);
    paramString1 = a(paramQQAppInterface, paramacvx.jdField_b_of_type_JavaLangString, (StringBuilder)localObject);
    localObject = ((StringBuilder)localObject).toString();
    aquz localaquz = new aquz(paramacvx.jdField_b_of_type_JavaLangString, paramacvx.jdField_b_of_type_JavaLangString, (String)localObject, 0, paramInt1, paramInt2, awzw.a());
    MessageForUniteGrayTip localMessageForUniteGrayTip = new MessageForUniteGrayTip();
    localMessageForUniteGrayTip.hasRead = 0;
    localMessageForUniteGrayTip.subType = paramInt3;
    localMessageForUniteGrayTip.initGrayTipMsg(paramQQAppInterface, localaquz);
    localMessageForUniteGrayTip.tipParam.jdField_d_of_type_JavaLangString = paramString2;
    if (paramInt3 == 998) {
      localMessageForUniteGrayTip.caidanAnimUrl = paramacvx.a();
    }
    for (;;)
    {
      a(paramQQAppInterface, (String)localObject, localaquz, paramString1);
      localMessageForUniteGrayTip.saveExtInfoToExtStr("mutualmark_id", asxk.a(paramacvx.a(), paramacvx.b()));
      asxv.a(paramQQAppInterface, paramFriends, paramExtensionInfo, paramacvx, (String)localObject, localaquz, paramString1);
      aqva.a(paramQQAppInterface, localMessageForUniteGrayTip);
      aswy.a(paramQQAppInterface, localMessageForUniteGrayTip, localMessageForUniteGrayTip.tipParam.jdField_b_of_type_Int);
      return;
      if (paramInt3 == 999)
      {
        localMessageForUniteGrayTip.caidanAnimUrl = paramacvx.b();
        localMessageForUniteGrayTip.caidanAnimUrlMd5 = paramacvx.c();
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, aquz paramaquz, ArrayList<asxg> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {}
    for (;;)
    {
      return;
      paramQQAppInterface = paramArrayList.iterator();
      while (paramQQAppInterface.hasNext())
      {
        paramString = (asxg)paramQQAppInterface.next();
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
            paramaquz.a(paramString.jdField_c_of_type_Int, paramString.jdField_d_of_type_Int, paramArrayList);
          }
          break;
        case 2: 
          if (!TextUtils.isEmpty(paramString.jdField_c_of_type_JavaLangString))
          {
            paramArrayList = new Bundle();
            paramArrayList.putString("image_resource", paramString.jdField_c_of_type_JavaLangString);
            paramaquz.a(paramString.jdField_c_of_type_Int, paramString.jdField_d_of_type_Int, paramArrayList);
          }
          break;
        case 3: 
          if (!TextUtils.isEmpty(paramString.jdField_c_of_type_JavaLangString))
          {
            paramArrayList = new Bundle();
            paramArrayList.putInt("key_action", 1);
            paramArrayList.putString("key_action_DATA", paramString.jdField_d_of_type_JavaLangString);
            paramaquz.a(paramString.jdField_c_of_type_Int, paramString.jdField_d_of_type_Int, paramArrayList);
          }
          break;
        case 4: 
          if (!TextUtils.isEmpty(paramString.jdField_c_of_type_JavaLangString))
          {
            paramArrayList = new Bundle();
            paramArrayList.putString("image_resource", paramString.jdField_c_of_type_JavaLangString);
            paramaquz.a(paramString.jdField_c_of_type_Int, paramString.jdField_d_of_type_Int, paramArrayList);
          }
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asxe
 * JD-Core Version:    0.7.0.1
 */