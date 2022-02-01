import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class azrc
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
  
  public static void a(bdol parambdol, List<String> paramList)
  {
    if ((parambdol != null) && ((parambdol instanceof bdom)))
    {
      parambdol = ((bdom)parambdol).a;
      if ((parambdol != null) && (parambdol.size() > 0)) {
        parambdol = parambdol.iterator();
      }
    }
    else
    {
      while (parambdol.hasNext())
      {
        a((bdol)parambdol.next(), paramList);
        continue;
        if ((parambdol != null) && ((parambdol instanceof bdqo)))
        {
          parambdol = ((bdqo)parambdol).ac;
          if ((TextUtils.isEmpty(parambdol)) || (!parambdol.startsWith("http"))) {
            break;
          }
        }
      }
    }
    try
    {
      if (a(new URL(parambdol).getHost())) {
        paramList.add(parambdol);
      }
      return;
    }
    catch (MalformedURLException parambdol)
    {
      parambdol.printStackTrace();
    }
  }
  
  public static void a(MessageForStructing paramMessageForStructing, QQAppInterface paramQQAppInterface)
  {
    int i = azqi.a();
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
              a((bdol)((Iterator)localObject).next(), localArrayList);
            }
          }
        }
        if (localArrayList.size() <= 0) {
          break;
        }
        Object localObject = new beui();
        ((beui)localObject).b = paramQQAppInterface.mMsgServiceID;
        ((beui)localObject).c = paramQQAppInterface.mMsgTemplateID;
        ((beui)localObject).jdField_a_of_type_JavaLangString = String.valueOf(paramMessageForStructing.istroop);
        ((beui)localObject).jdField_a_of_type_Boolean = true;
        paramMessageForStructing = localArrayList.iterator();
        while (paramMessageForStructing.hasNext()) {
          a((String)paramMessageForStructing.next(), (beui)localObject);
        }
      }
    }
  }
  
  public static void a(String paramString, beui parambeui)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("http"))) {
      beuf.a(paramString, parambeui, null, 1);
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
 * Qualified Name:     azrc
 * JD-Core Version:    0.7.0.1
 */