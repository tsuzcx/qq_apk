import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class arpu
{
  private boolean a;
  private boolean b;
  
  public static arpu a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj == null) || (paramArrayOfaraj.length <= 0)) {
      return null;
    }
    arpu localarpu = new arpu();
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfaraj.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramArrayOfaraj[i].a);
      i += 1;
    }
    if (localArrayList.size() > 0)
    {
      paramArrayOfaraj = new HashMap();
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
            paramArrayOfaraj.put(localObject[0], localObject[1]);
            if (QLog.isColorLevel()) {
              QLog.i("TencentDocConfigBean", 2, "handleTencentDocsConfigCmd, name=" + localObject[0] + ", val=" + localObject[1]);
            }
          }
        }
      }
      localarpu.a = "1".equals(paramArrayOfaraj.get("enable_tencent_docs_assistant"));
      localarpu.b = "1".equals(paramArrayOfaraj.get("preload_tool_process"));
      paramArrayOfaraj = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramArrayOfaraj instanceof QQAppInterface))
      {
        paramArrayOfaraj = (QQAppInterface)paramArrayOfaraj;
        becb.b(paramArrayOfaraj, localarpu.b);
        becb.a(paramArrayOfaraj, localarpu.a);
      }
    }
    for (;;)
    {
      return localarpu;
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
 * Qualified Name:     arpu
 * JD-Core Version:    0.7.0.1
 */