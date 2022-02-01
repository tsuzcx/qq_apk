import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class arad
{
  private boolean a;
  private boolean b;
  
  public static arad a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg == null) || (paramArrayOfaqlg.length <= 0)) {
      return null;
    }
    arad localarad = new arad();
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfaqlg.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramArrayOfaqlg[i].a);
      i += 1;
    }
    if (localArrayList.size() > 0)
    {
      paramArrayOfaqlg = new HashMap();
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
            paramArrayOfaqlg.put(localObject[0], localObject[1]);
            if (QLog.isColorLevel()) {
              QLog.i("TencentDocConfigBean", 2, "handleTencentDocsConfigCmd, name=" + localObject[0] + ", val=" + localObject[1]);
            }
          }
        }
      }
      localarad.a = "1".equals(paramArrayOfaqlg.get("enable_tencent_docs_assistant"));
      localarad.b = "1".equals(paramArrayOfaqlg.get("preload_tool_process"));
      paramArrayOfaqlg = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramArrayOfaqlg instanceof QQAppInterface))
      {
        paramArrayOfaqlg = (QQAppInterface)paramArrayOfaqlg;
        bdjg.b(paramArrayOfaqlg, localarad.b);
        bdjg.a(paramArrayOfaqlg, localarad.a);
      }
    }
    for (;;)
    {
      return localarad;
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
 * Qualified Name:     arad
 * JD-Core Version:    0.7.0.1
 */