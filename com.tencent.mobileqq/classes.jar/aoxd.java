import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class aoxd
{
  private boolean a;
  private boolean b;
  
  public static aoxd a(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko == null) || (paramArrayOfaoko.length <= 0)) {
      return null;
    }
    aoxd localaoxd = new aoxd();
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfaoko.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramArrayOfaoko[i].a);
      i += 1;
    }
    if (localArrayList.size() > 0)
    {
      paramArrayOfaoko = new HashMap();
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
            paramArrayOfaoko.put(localObject[0], localObject[1]);
            if (QLog.isColorLevel()) {
              QLog.i("TencentDocConfigBean", 2, "handleTencentDocsConfigCmd, name=" + localObject[0] + ", val=" + localObject[1]);
            }
          }
        }
      }
      localaoxd.a = "1".equals(paramArrayOfaoko.get("enable_tencent_docs_assistant"));
      localaoxd.b = "1".equals(paramArrayOfaoko.get("preload_tool_process"));
      paramArrayOfaoko = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramArrayOfaoko instanceof QQAppInterface))
      {
        paramArrayOfaoko = (QQAppInterface)paramArrayOfaoko;
        baic.b(paramArrayOfaoko, localaoxd.b);
        baic.a(paramArrayOfaoko, localaoxd.a);
      }
    }
    for (;;)
    {
      return localaoxd;
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
 * Qualified Name:     aoxd
 * JD-Core Version:    0.7.0.1
 */