import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class arnd
{
  private boolean a;
  private boolean b;
  
  public static arnd a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa == null) || (paramArrayOfaqxa.length <= 0)) {
      return null;
    }
    arnd localarnd = new arnd();
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfaqxa.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramArrayOfaqxa[i].a);
      i += 1;
    }
    if (localArrayList.size() > 0)
    {
      paramArrayOfaqxa = new HashMap();
      i = 0;
      if (i < localArrayList.size())
      {
        Object localObject = (String)localArrayList.get(i);
        if (QLog.isColorLevel()) {
          QLog.d("TencentDocConfigBean", 2, "handleTencentDocsConfigCmd receiveAllConfigs |type: 294,content: " + (String)localObject);
        }
        if (TextUtils.isEmpty((CharSequence)localObject)) {}
        for (;;)
        {
          i += 1;
          break;
          localObject = ((String)localObject).split("=");
          if (localObject.length == 2)
          {
            if (!TextUtils.isEmpty(localObject[1])) {
              localObject[1] = localObject[1].trim();
            }
            paramArrayOfaqxa.put(localObject[0], localObject[1]);
            if (QLog.isColorLevel()) {
              QLog.i("TencentDocConfigBean", 2, "handleTencentDocsConfigCmd, name=" + localObject[0] + ", val=" + localObject[1]);
            }
          }
        }
      }
      localarnd.a = "1".equals(paramArrayOfaqxa.get("enable_tencent_docs_assistant"));
      localarnd.b = "1".equals(paramArrayOfaqxa.get("preload_tool_process"));
      paramArrayOfaqxa = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramArrayOfaqxa instanceof QQAppInterface))
      {
        paramArrayOfaqxa = (QQAppInterface)paramArrayOfaqxa;
        becr.b(paramArrayOfaqxa, localarnd.b);
        becr.a(paramArrayOfaqxa, localarnd.a);
      }
    }
    for (;;)
    {
      return localarnd;
      if (QLog.isColorLevel()) {
        QLog.d("TencentDocConfigBean", 2, "handleTencentDocsConfigCmd receiveAllConfigs|type: 294,content_list is empty ");
      }
    }
  }
  
  public boolean a()
  {
    return this.a;
  }
  
  public boolean b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arnd
 * JD-Core Version:    0.7.0.1
 */