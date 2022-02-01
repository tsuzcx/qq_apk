import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class amlk
{
  private static amlk a;
  
  public static amlk a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new amlk();
      }
      return a;
    }
    finally {}
  }
  
  private boolean a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      QLog.i("WeatherDCReportHelper", 1, "isLastWeatherMessageNew app == null");
    }
    do
    {
      return false;
      paramQQAppInterface = paramQQAppInterface.a();
      if (paramQQAppInterface == null)
      {
        QLog.i("WeatherDCReportHelper", 1, "isLastWeatherMessageNew qqMessageFacade == null");
        return false;
      }
      paramQQAppInterface = paramQQAppInterface.a("2658655094", 1008);
    } while ((paramQQAppInterface == null) || (paramQQAppInterface.size() <= 0));
    return ammh.a((ChatMessage)paramQQAppInterface.get(paramQQAppInterface.size() - 1));
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    int i;
    if ((amme.a.a()) && (a(paramQQAppInterface)))
    {
      i = 1;
      if (i == 0) {
        break label38;
      }
    }
    label38:
    for (String str = "new_folder_weather_expose";; str = "folder_weather_expose")
    {
      a(paramQQAppInterface, str);
      return;
      i = 0;
      break;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForArkApp))
    {
      amlv.a(1, "");
      if (!ammh.a(paramMessageRecord)) {
        break label30;
      }
    }
    label30:
    for (paramMessageRecord = "new_folder_weather_arrive";; paramMessageRecord = "folder_weather_arrive")
    {
      a(paramQQAppInterface, paramMessageRecord);
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    a(paramQQAppInterface, paramString, null);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, Object paramObject)
  {
    String str2 = "";
    String str1 = str2;
    if (paramObject != null)
    {
      str1 = str2;
      if (!TextUtils.isEmpty(String.valueOf(paramObject))) {
        str1 = "|" + paramObject;
      }
    }
    paramString = System.currentTimeMillis() + "|" + "QQWeather" + "|" + "QQWeather_native" + "|" + paramString + "|" + "android" + str1;
    bdkl.a(paramQQAppInterface, "dc04698", paramString);
    if (QLog.isColorLevel()) {
      QLog.d("WeatherDCReportHelper", 2, "reportWeather : " + paramString);
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    int i;
    if ((amme.a.a()) && (a(paramQQAppInterface)))
    {
      i = 1;
      if (i == 0) {
        break label38;
      }
    }
    label38:
    for (String str = "new_folder_weather_click";; str = "folder_weather_click")
    {
      a(paramQQAppInterface, str);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amlk
 * JD-Core Version:    0.7.0.1
 */