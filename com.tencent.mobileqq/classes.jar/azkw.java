import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.transfile.HttpDownloader;
import com.tencent.mobileqq.transfile.HttpDownloaderParams;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class azkw
{
  public static int a;
  public static String a;
  public static boolean a;
  public static boolean b;
  
  static
  {
    jdField_a_of_type_Boolean = true;
    jdField_a_of_type_JavaLangString = "struct_msg_pic_pre";
  }
  
  public static int a()
  {
    if (BaseApplicationImpl.sProcessId == 1)
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      return BaseApplicationImpl.getApplication().getSharedPreferences(localQQAppInterface.getCurrentAccountUin() + "_" + jdField_a_of_type_JavaLangString, 0).getInt("mStructMsgPicSwitch", 0);
    }
    return 0;
  }
  
  public static void a(int paramInt)
  {
    if (BaseApplicationImpl.sProcessId == 1)
    {
      jdField_a_of_type_Int = paramInt;
      b = true;
      Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localObject = BaseApplicationImpl.getApplication().getSharedPreferences(((QQAppInterface)localObject).getCurrentAccountUin() + "_" + jdField_a_of_type_JavaLangString, 0).edit();
      ((SharedPreferences.Editor)localObject).putInt("mStructMsgPicSwitch", paramInt);
      ((SharedPreferences.Editor)localObject).commit();
    }
  }
  
  public static void a(bdnu parambdnu, List<String> paramList)
  {
    if ((parambdnu != null) && ((parambdnu instanceof bdnv)))
    {
      parambdnu = ((bdnv)parambdnu).a;
      if ((parambdnu != null) && (parambdnu.size() > 0)) {
        parambdnu = parambdnu.iterator();
      }
    }
    else
    {
      while (parambdnu.hasNext())
      {
        a((bdnu)parambdnu.next(), paramList);
        continue;
        if ((parambdnu != null) && ((parambdnu instanceof bdpx)))
        {
          parambdnu = ((bdpx)parambdnu).ac;
          if ((TextUtils.isEmpty(parambdnu)) || (!parambdnu.startsWith("http"))) {
            break;
          }
        }
      }
    }
    try
    {
      if (a(new URL(parambdnu).getHost())) {
        paramList.add(parambdnu);
      }
      return;
    }
    catch (MalformedURLException parambdnu)
    {
      parambdnu.printStackTrace();
    }
  }
  
  public static void a(MessageForStructing paramMessageForStructing, QQAppInterface paramQQAppInterface)
  {
    int i = azkc.a();
    if (!b)
    {
      jdField_a_of_type_Int = a();
      b = true;
    }
    if ((i != 0) && (jdField_a_of_type_Int == 0)) {
      if (QLog.isColorLevel()) {
        QLog.i("StructMsgPicPreDelegate", 2, "not wifi not pre download");
      }
    }
    for (;;)
    {
      return;
      if (paramMessageForStructing != null)
      {
        paramQQAppInterface = paramMessageForStructing.structingMsg;
        ArrayList localArrayList = new ArrayList();
        if ((paramQQAppInterface != null) && ((paramQQAppInterface instanceof AbsShareMsg)))
        {
          localObject = ((AbsShareMsg)paramQQAppInterface).getStructMsgItemLists();
          if ((localObject != null) && (((List)localObject).size() > 0))
          {
            localObject = ((List)localObject).iterator();
            while (((Iterator)localObject).hasNext()) {
              a((bdnu)((Iterator)localObject).next(), localArrayList);
            }
          }
        }
        if (localArrayList.size() <= 0) {
          break;
        }
        Object localObject = new HttpDownloaderParams();
        ((HttpDownloaderParams)localObject).param1 = paramQQAppInterface.mMsgServiceID;
        ((HttpDownloaderParams)localObject).param2 = paramQQAppInterface.mMsgTemplateID;
        ((HttpDownloaderParams)localObject).param3 = String.valueOf(paramMessageForStructing.istroop);
        ((HttpDownloaderParams)localObject).isPreDownload = true;
        paramMessageForStructing = localArrayList.iterator();
        while (paramMessageForStructing.hasNext()) {
          a((String)paramMessageForStructing.next(), (HttpDownloaderParams)localObject);
        }
      }
    }
  }
  
  public static void a(String paramString, HttpDownloaderParams paramHttpDownloaderParams)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("http"))) {
      HttpDownloader.downloadImageByHttpEngine(paramString, paramHttpDownloaderParams, null, 1);
    }
  }
  
  public static boolean a(String paramString)
  {
    boolean bool = Pattern.compile("((\\.|^)(qq\\.com|soso\\.com|gtimg\\.cn|url\\.cn|qpic\\.cn|qlogo\\.cn|idqqimg\\.com)$)").matcher(paramString).find();
    if (QLog.isDevelopLevel()) {
      QLog.d("StructMsgPicPreDelegate", 4, " host = " + paramString + " ,isTencentDomain = " + bool);
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azkw
 * JD-Core Version:    0.7.0.1
 */