import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.flatbuffers.FlatBuffersParser;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.VasQuickUpdateEngine;
import com.tencent.mobileqq.vas.VasQuickUpdateEngine.TagItemInfo;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

public abstract class bbtc
  implements bbql, bbqp
{
  private static final int ERROR_NULL_APP = 10087;
  private static final int ERROR_WRONG_APP = 10088;
  private static final int ERROR_X86 = 10086;
  private static final String TAG = "BaseUpdateCallback";
  private static bbte<bbqp> listeners = new bbte();
  private static bbte<WeakReference<bbqp>> weakListeners = new bbte();
  
  private static String getKey(long paramLong, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return paramLong + "_" + paramString1;
    }
    return paramLong + "_" + paramString2;
  }
  
  private boolean isDefaultSc(String paramString)
  {
    String str = getScidPrefix();
    return (!TextUtils.isEmpty(str)) && (paramString.startsWith(str));
  }
  
  protected void _onCompleted(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if ((paramQQAppInterface != null) && (isZip_KeepZip()) && (paramInt1 == 0) && (isDefaultSc(paramString1)))
    {
      paramString2 = getDir(paramQQAppInterface.getApp(), paramString1);
      paramQQAppInterface = getSavePath(paramQQAppInterface.getApp(), paramString1);
    }
    try
    {
      bbdx.a(paramQQAppInterface, paramString2, false);
      return;
    }
    catch (IOException paramQQAppInterface)
    {
      QLog.e("BaseUpdateCallback", 1, "_onCompleted: ", paramQQAppInterface);
    }
  }
  
  protected void _onProgress(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3) {}
  
  public boolean canUpdate(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2)
  {
    return true;
  }
  
  public void cleanCache(Context paramContext)
  {
    if (!TextUtils.isEmpty(getRootDir())) {
      VasQuickUpdateEngine.safeDeleteFile(new File(paramContext.getFilesDir() + File.separator + getRootDir()));
    }
  }
  
  public boolean deleteFiles(QQAppInterface paramQQAppInterface, long paramLong, String paramString)
  {
    if ((paramQQAppInterface != null) && (isDefaultSc(paramString))) {
      return VasQuickUpdateEngine.safeDeleteFile(new File(getDir(paramQQAppInterface.getApp(), paramString)));
    }
    return false;
  }
  
  public void download(QQAppInterface paramQQAppInterface, int paramInt, bbqp parambbqp, boolean paramBoolean)
  {
    download(paramQQAppInterface, getScid(paramInt), parambbqp, paramBoolean);
  }
  
  public void download(QQAppInterface paramQQAppInterface, long paramLong, String paramString, bbqp parambbqp, boolean paramBoolean)
  {
    if (FlatBuffersParser.c())
    {
      QLog.e("BaseUpdateCallback", 1, "x86 not support");
      if (parambbqp != null) {
        parambbqp.onCompleted(paramQQAppInterface, paramLong, paramString, "", "BaseUpdateCallback", 10086, 0);
      }
    }
    do
    {
      return;
      if (paramQQAppInterface != null) {
        break label272;
      }
      localObject = BaseApplicationImpl.getApplication();
      if (localObject != null) {
        break;
      }
      QLog.e("BaseUpdateCallback", 1, "null app");
    } while (parambbqp == null);
    parambbqp.onCompleted(paramQQAppInterface, paramLong, paramString, "", "BaseUpdateCallback", 10087, 0);
    return;
    Object localObject = ((BaseApplicationImpl)localObject).getRuntime();
    if ((localObject instanceof QQAppInterface)) {
      paramQQAppInterface = (QQAppInterface)localObject;
    }
    label259:
    label272:
    for (;;)
    {
      if (parambbqp != null)
      {
        localObject = getKey(paramLong, paramString, "");
        if (!paramBoolean) {
          break label259;
        }
        weakListeners.a((String)localObject, new WeakReference(parambbqp));
      }
      for (;;)
      {
        QLog.e("BaseUpdateCallback", 1, "download: " + paramLong + "_" + paramString + ", " + parambbqp);
        ((VasQuickUpdateManager)paramQQAppInterface.getManager(184)).downloadItem(paramLong, paramString, "BaseUpdateCallback");
        return;
        QLog.e("BaseUpdateCallback", 1, "wrong app:" + localObject);
        if (parambbqp == null) {
          break;
        }
        parambbqp.onCompleted(paramQQAppInterface, paramLong, paramString, "", "BaseUpdateCallback", 10088, 0);
        return;
        listeners.a((String)localObject, parambbqp);
      }
    }
  }
  
  public void download(QQAppInterface paramQQAppInterface, String paramString)
  {
    download(paramQQAppInterface, paramString, null, false);
  }
  
  public void download(QQAppInterface paramQQAppInterface, String paramString, bbqp parambbqp, boolean paramBoolean)
  {
    download(paramQQAppInterface, getBID(), paramString, parambbqp, paramBoolean);
  }
  
  public abstract long getBID();
  
  public String getDir(Context paramContext, String paramString)
  {
    return new File(paramContext.getFilesDir() + File.separator + getRootDir(), paramString).getAbsolutePath();
  }
  
  public int getId(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString.substring(getScidPrefix().length()));
      return i;
    }
    catch (Exception localException)
    {
      QLog.e("BaseUpdateCallback", 1, "getId error scid: " + paramString, localException);
    }
    return 0;
  }
  
  public VasQuickUpdateEngine.TagItemInfo getItemInfo(QQAppInterface paramQQAppInterface, long paramLong, String paramString)
  {
    if ((paramQQAppInterface != null) && (isDefaultSc(paramString)))
    {
      VasQuickUpdateEngine.TagItemInfo localTagItemInfo = new VasQuickUpdateEngine.TagItemInfo();
      localTagItemInfo.bPreConfig = false;
      localTagItemInfo.bSaveInDir = false;
      localTagItemInfo.strSavePath = getSavePath(paramQQAppInterface.getApp(), paramString);
      return localTagItemInfo;
    }
    return null;
  }
  
  protected String getRootDir()
  {
    return "";
  }
  
  public String getSavePath(Context paramContext, String paramString)
  {
    String str = getDir(paramContext, paramString);
    paramContext = str;
    if (isZip_KeepZip()) {
      paramContext = str + File.separator + paramString + ".zip";
    }
    return paramContext;
  }
  
  public String getScid(int paramInt)
  {
    return getScidPrefix() + paramInt;
  }
  
  protected String getScidPrefix()
  {
    return "";
  }
  
  public boolean isFileExists(QQAppInterface paramQQAppInterface, long paramLong, String paramString)
  {
    if ((paramQQAppInterface != null) && (isDefaultSc(paramString))) {
      return new File(getSavePath(paramQQAppInterface.getApp(), paramString)).exists();
    }
    return false;
  }
  
  protected boolean isZip_KeepZip()
  {
    return true;
  }
  
  public final void onCompleted(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    _onCompleted(paramQQAppInterface, paramLong, paramString1, paramString2, paramString3, paramInt1, paramInt2);
    Object localObject1 = getItemInfo(paramQQAppInterface, paramLong, paramString1);
    if (localObject1 == null) {
      QLog.e("BaseUpdateCallback", 1, "onComplete getItemInfo failed: " + paramLong + "_" + paramString1);
    }
    boolean bool;
    int i;
    label88:
    Object localObject2;
    if (localObject1 == null)
    {
      bool = false;
      if ((bool) && (paramInt1 == 0)) {
        break label172;
      }
      i = 1;
      localObject2 = getKey(paramLong, paramString1, paramString2);
      if (i == 0) {
        break label178;
      }
    }
    label172:
    label178:
    for (localObject1 = listeners.b((String)localObject2);; localObject1 = listeners.a((String)localObject2))
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((bbqp)((Iterator)localObject1).next()).onCompleted(paramQQAppInterface, paramLong, paramString1, paramString2, paramString3, paramInt1, paramInt2);
      }
      bool = ((VasQuickUpdateEngine.TagItemInfo)localObject1).bPreConfig;
      break;
      i = 0;
      break label88;
    }
    if (i != 0) {}
    for (localObject1 = weakListeners.b((String)localObject2);; localObject1 = weakListeners.a((String)localObject2))
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (bbqp)((WeakReference)((Iterator)localObject1).next()).get();
        if (localObject2 != null) {
          ((bbqp)localObject2).onCompleted(paramQQAppInterface, paramLong, paramString1, paramString2, paramString3, paramInt1, paramInt2);
        }
      }
    }
  }
  
  public final void onProgress(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3)
  {
    Object localObject1 = getItemInfo(paramQQAppInterface, paramLong1, paramString1);
    if (localObject1 == null) {
      QLog.e("BaseUpdateCallback", 1, "onProgress getItemInfo failed: " + paramLong1 + "_" + paramString1);
    }
    if (localObject1 == null) {}
    Object localObject2;
    for (boolean bool = false;; bool = ((VasQuickUpdateEngine.TagItemInfo)localObject1).bPreConfig)
    {
      localObject1 = getKey(paramLong1, paramString1, paramString2);
      if (bool) {
        return;
      }
      _onProgress(paramQQAppInterface, paramLong1, paramString1, paramString2, paramLong2, paramLong3);
      localObject2 = listeners.a((String)localObject1).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((bbqp)((Iterator)localObject2).next()).onProgress(paramQQAppInterface, paramLong1, paramString1, paramString2, paramLong2, paramLong3);
      }
    }
    localObject1 = weakListeners.a((String)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (bbqp)((WeakReference)((Iterator)localObject1).next()).get();
      if (localObject2 != null) {
        ((bbqp)localObject2).onProgress(paramQQAppInterface, paramLong1, paramString1, paramString2, paramLong2, paramLong3);
      }
    }
  }
  
  public void removeListener(long paramLong, String paramString, bbqp parambbqp)
  {
    paramString = getKey(paramLong, paramString, "");
    listeners.a(paramString, parambbqp, false);
    weakListeners.a(paramString, parambbqp, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bbtc
 * JD-Core Version:    0.7.0.1
 */