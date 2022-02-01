import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class aqjs
{
  private boolean a;
  private boolean b;
  
  public static aqjs a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx == null) || (paramArrayOfaptx.length <= 0)) {
      return null;
    }
    aqjs localaqjs = new aqjs();
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfaptx.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramArrayOfaptx[i].a);
      i += 1;
    }
    if (localArrayList.size() > 0)
    {
      paramArrayOfaptx = new HashMap();
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
            paramArrayOfaptx.put(localObject[0], localObject[1]);
            if (QLog.isColorLevel()) {
              QLog.i("TencentDocConfigBean", 2, "handleTencentDocsConfigCmd, name=" + localObject[0] + ", val=" + localObject[1]);
            }
          }
        }
      }
      localaqjs.a = "1".equals(paramArrayOfaptx.get("enable_tencent_docs_assistant"));
      localaqjs.b = "1".equals(paramArrayOfaptx.get("preload_tool_process"));
      paramArrayOfaptx = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramArrayOfaptx instanceof QQAppInterface))
      {
        paramArrayOfaptx = (QQAppInterface)paramArrayOfaptx;
        bcvs.b(paramArrayOfaptx, localaqjs.b);
        bcvs.a(paramArrayOfaptx, localaqjs.a);
      }
    }
    for (;;)
    {
      return localaqjs;
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
 * Qualified Name:     aqjs
 * JD-Core Version:    0.7.0.1
 */