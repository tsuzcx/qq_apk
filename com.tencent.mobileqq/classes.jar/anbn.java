import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class anbn
{
  private boolean a;
  private boolean b;
  
  public static anbn a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph == null) || (paramArrayOfamph.length <= 0)) {
      return null;
    }
    anbn localanbn = new anbn();
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfamph.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramArrayOfamph[i].a);
      i += 1;
    }
    if (localArrayList.size() > 0)
    {
      paramArrayOfamph = new HashMap();
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
            paramArrayOfamph.put(localObject[0], localObject[1]);
            if (QLog.isColorLevel()) {
              QLog.i("TencentDocConfigBean", 2, "handleTencentDocsConfigCmd, name=" + localObject[0] + ", val=" + localObject[1]);
            }
          }
        }
      }
      localanbn.a = "1".equals(paramArrayOfamph.get("enable_tencent_docs_assistant"));
      localanbn.b = "1".equals(paramArrayOfamph.get("preload_tool_process"));
      paramArrayOfamph = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramArrayOfamph instanceof QQAppInterface))
      {
        paramArrayOfamph = (QQAppInterface)paramArrayOfamph;
        ayfx.b(paramArrayOfamph, localanbn.b);
        ayfx.a(paramArrayOfamph, localanbn.a);
      }
    }
    for (;;)
    {
      return localanbn;
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
 * Qualified Name:     anbn
 * JD-Core Version:    0.7.0.1
 */