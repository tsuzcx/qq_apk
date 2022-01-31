import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class aosu
{
  private boolean a;
  private boolean b;
  
  public static aosu a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf == null) || (paramArrayOfaogf.length <= 0)) {
      return null;
    }
    aosu localaosu = new aosu();
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfaogf.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramArrayOfaogf[i].a);
      i += 1;
    }
    if (localArrayList.size() > 0)
    {
      paramArrayOfaogf = new HashMap();
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
            paramArrayOfaogf.put(localObject[0], localObject[1]);
            if (QLog.isColorLevel()) {
              QLog.i("TencentDocConfigBean", 2, "handleTencentDocsConfigCmd, name=" + localObject[0] + ", val=" + localObject[1]);
            }
          }
        }
      }
      localaosu.a = "1".equals(paramArrayOfaogf.get("enable_tencent_docs_assistant"));
      localaosu.b = "1".equals(paramArrayOfaogf.get("preload_tool_process"));
      paramArrayOfaogf = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramArrayOfaogf instanceof QQAppInterface))
      {
        paramArrayOfaogf = (QQAppInterface)paramArrayOfaogf;
        badt.b(paramArrayOfaogf, localaosu.b);
        badt.a(paramArrayOfaogf, localaosu.a);
      }
    }
    for (;;)
    {
      return localaosu;
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
 * Qualified Name:     aosu
 * JD-Core Version:    0.7.0.1
 */