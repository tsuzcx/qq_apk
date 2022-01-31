import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class anbi
{
  private boolean a;
  private boolean b;
  
  public static anbi a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi == null) || (paramArrayOfampi.length <= 0)) {
      return null;
    }
    anbi localanbi = new anbi();
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfampi.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramArrayOfampi[i].a);
      i += 1;
    }
    if (localArrayList.size() > 0)
    {
      paramArrayOfampi = new HashMap();
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
            paramArrayOfampi.put(localObject[0], localObject[1]);
            if (QLog.isColorLevel()) {
              QLog.i("TencentDocConfigBean", 2, "handleTencentDocsConfigCmd, name=" + localObject[0] + ", val=" + localObject[1]);
            }
          }
        }
      }
      localanbi.a = "1".equals(paramArrayOfampi.get("enable_tencent_docs_assistant"));
      localanbi.b = "1".equals(paramArrayOfampi.get("preload_tool_process"));
      paramArrayOfampi = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramArrayOfampi instanceof QQAppInterface))
      {
        paramArrayOfampi = (QQAppInterface)paramArrayOfampi;
        ayfv.b(paramArrayOfampi, localanbi.b);
        ayfv.a(paramArrayOfampi, localanbi.a);
      }
    }
    for (;;)
    {
      return localanbi;
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
 * Qualified Name:     anbi
 * JD-Core Version:    0.7.0.1
 */