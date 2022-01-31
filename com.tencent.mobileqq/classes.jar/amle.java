import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class amle
{
  private boolean a;
  private boolean b;
  
  public static amle a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs == null) || (paramArrayOfalzs.length <= 0)) {
      return null;
    }
    amle localamle = new amle();
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfalzs.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramArrayOfalzs[i].a);
      i += 1;
    }
    if (localArrayList.size() > 0)
    {
      paramArrayOfalzs = new HashMap();
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
            paramArrayOfalzs.put(localObject[0], localObject[1]);
            if (QLog.isColorLevel()) {
              QLog.i("TencentDocConfigBean", 2, "handleTencentDocsConfigCmd, name=" + localObject[0] + ", val=" + localObject[1]);
            }
          }
        }
      }
      localamle.a = "1".equals(paramArrayOfalzs.get("enable_tencent_docs_assistant"));
      localamle.b = "1".equals(paramArrayOfalzs.get("preload_tool_process"));
      paramArrayOfalzs = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramArrayOfalzs instanceof QQAppInterface))
      {
        paramArrayOfalzs = (QQAppInterface)paramArrayOfalzs;
        axfs.b(paramArrayOfalzs, localamle.b);
        axfs.a(paramArrayOfalzs, localamle.a);
      }
    }
    for (;;)
    {
      return localamle;
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
 * Qualified Name:     amle
 * JD-Core Version:    0.7.0.1
 */