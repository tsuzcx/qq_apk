import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import eipc.EIPCClient;
import eipc.EIPCResult;

public class awkv
{
  private static volatile awkv a;
  
  public static awkv a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new awkv();
      }
      return a;
    }
    finally {}
  }
  
  public Bundle a(String paramString, Bundle paramBundle)
  {
    Object localObject2 = null;
    Object localObject1;
    if ("CMD_GET_NICK_NAME_BY_UIN".equals(paramString))
    {
      paramString = QIPCClientHelper.getInstance().getClient().callServer("Module_VideoPlayIPCServer", "CMD_GET_NICK_NAME_BY_UIN", paramBundle);
      localObject1 = localObject2;
      if (paramString != null)
      {
        localObject1 = localObject2;
        if (paramString.isSuccess()) {
          localObject1 = paramString.data;
        }
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          return localObject1;
                          if (!"CMD_GET_CURRENT_NICK_NAME".equals(paramString)) {
                            break;
                          }
                          paramString = QIPCClientHelper.getInstance().getClient().callServer("Module_VideoPlayIPCServer", "CMD_GET_CURRENT_NICK_NAME", paramBundle);
                          localObject1 = localObject2;
                        } while (paramString == null);
                        localObject1 = localObject2;
                      } while (!paramString.isSuccess());
                      return paramString.data;
                      if (!"CMD_UPDATE_MSG_FOR_VIDEO_REDBAG_STAT".equals(paramString)) {
                        break;
                      }
                      paramString = QIPCClientHelper.getInstance().getClient().callServer("Module_VideoPlayIPCServer", "CMD_UPDATE_MSG_FOR_VIDEO_REDBAG_STAT", paramBundle);
                      localObject1 = localObject2;
                    } while (paramString == null);
                    localObject1 = localObject2;
                  } while (!paramString.isSuccess());
                  return paramString.data;
                  if (!"CMD_QUERY_VIDEO_REDBAG_STAT".equals(paramString)) {
                    break;
                  }
                  paramString = QIPCClientHelper.getInstance().getClient().callServer("Module_VideoPlayIPCServer", "CMD_QUERY_VIDEO_REDBAG_STAT", paramBundle);
                  localObject1 = localObject2;
                } while (paramString == null);
                localObject1 = localObject2;
              } while (!paramString.isSuccess());
              return paramString.data;
              if (!"CMD_GET_CURRENT_USER_HEAD".equals(paramString)) {
                break;
              }
              paramString = QIPCClientHelper.getInstance().getClient().callServer("Module_VideoPlayIPCServer", "CMD_GET_CURRENT_USER_HEAD", paramBundle);
              localObject1 = localObject2;
            } while (paramString == null);
            localObject1 = localObject2;
          } while (!paramString.isSuccess());
          return paramString.data;
          localObject1 = localObject2;
        } while (!"CMD_DOWNLOAD_PTU_RES".equals(paramString));
        paramString = QIPCClientHelper.getInstance().getClient().callServer("Module_VideoPlayIPCServer", "CMD_DOWNLOAD_PTU_RES", paramBundle);
        localObject1 = localObject2;
      } while (paramString == null);
      localObject1 = localObject2;
    } while (!paramString.isSuccess());
    return paramString.data;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awkv
 * JD-Core Version:    0.7.0.1
 */