import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.QueryItemVersionCallback;
import java.lang.ref.WeakReference;

public abstract interface bhuj
{
  public abstract void cancelDwonloadItem(long paramLong, String paramString);
  
  public abstract void downloadGatherItem(long paramLong, String paramString1, String[] paramArrayOfString, String paramString2);
  
  public abstract void downloadItem(long paramLong, String paramString1, String paramString2);
  
  public abstract void onDestory();
  
  public abstract void onPbMsgRecv(int paramInt, String paramString1, String paramString2);
  
  public abstract void queryItemVersion(int paramInt, String paramString, boolean paramBoolean, VasQuickUpdateManager.QueryItemVersionCallback paramQueryItemVersionCallback);
  
  public abstract void setWeakHandler(WeakReference<VasExtensionHandler> paramWeakReference);
  
  public abstract void startUpdateAllItem();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhuj
 * JD-Core Version:    0.7.0.1
 */