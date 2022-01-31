import android.os.Bundle;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.redtouch.RedAppInfo;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.manager.Manager;

public class bfml
  implements Manager
{
  @Nullable
  public RedAppInfo a(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("path", paramString);
    paramString = QIPCClientHelper.getInstance().getClient().callServer("ReaderIPCModule", "getSingleRedTouchInfo", localBundle);
    if ((paramString != null) && (paramString.code == 0) && (paramString.data != null))
    {
      paramString = paramString.data;
      paramString.setClassLoader(RedAppInfo.class.getClassLoader());
      return (RedAppInfo)paramString.getParcelable("redTouchInfo");
    }
    return null;
  }
  
  @Nullable
  public Map<String, RedAppInfo> a(ArrayList<String> paramArrayList)
  {
    if (paramArrayList == null) {}
    do
    {
      do
      {
        return null;
        localObject = new Bundle();
        ((Bundle)localObject).putStringArrayList("pathList", paramArrayList);
        paramArrayList = QIPCClientHelper.getInstance().getClient().callServer("ReaderIPCModule", "getRedTouchInfo", (Bundle)localObject);
      } while ((paramArrayList == null) || (paramArrayList.code != 0) || (paramArrayList.data == null));
      paramArrayList = paramArrayList.data;
      paramArrayList.setClassLoader(RedAppInfo.class.getClassLoader());
      localObject = paramArrayList.getParcelableArrayList("redTouchInfoList");
    } while (localObject == null);
    paramArrayList = new HashMap();
    Object localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      RedAppInfo localRedAppInfo = (RedAppInfo)((Iterator)localObject).next();
      paramArrayList.put(localRedAppInfo.b(), localRedAppInfo);
    }
    return paramArrayList;
  }
  
  public void a(String paramString)
  {
    if (a(paramString))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("path", paramString);
      QIPCClientHelper.getInstance().getClient().callServer("ReaderIPCModule", "reportRedTouchClick", localBundle);
    }
  }
  
  public boolean a(String paramString)
  {
    paramString = a(paramString);
    return (paramString != null) && (paramString.b() == 1);
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfml
 * JD-Core Version:    0.7.0.1
 */