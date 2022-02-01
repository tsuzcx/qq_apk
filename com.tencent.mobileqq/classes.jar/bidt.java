import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.VasQuickUpdateEngine.TagItemInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.business.BaseUpdateBusiness;
import com.tencent.vas.update.entity.BusinessItemInfo;
import com.tencent.vas.update.entity.BusinessUpdateParams;
import com.tencent.vas.update.entity.UpdateListenerParams;

public class bidt
  extends BaseUpdateBusiness
{
  private QQAppInterface a()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject != null) {}
    for (localObject = ((BaseApplicationImpl)localObject).getRuntime();; localObject = null) {
      return (QQAppInterface)localObject;
    }
  }
  
  private void a(@NonNull UpdateListenerParams paramUpdateListenerParams)
  {
    Object localObject = paramUpdateListenerParams.mBusinessUpdateParams;
    if (localObject == null) {}
    long l;
    String str;
    int i;
    int j;
    do
    {
      return;
      l = ((BusinessUpdateParams)localObject).mBid;
      str = ((BusinessUpdateParams)localObject).mScid;
      localObject = ((BusinessUpdateParams)localObject).mFrom;
      i = paramUpdateListenerParams.mErrorCode;
      j = paramUpdateListenerParams.mHttpCode;
      paramUpdateListenerParams = paramUpdateListenerParams.mErrorMessage;
      QLog.d("VasUpdate_NativeUpdateBusiness", 1, "onCompleted bid = " + l + " scid = " + str + " from = " + (String)localObject + " message = " + paramUpdateListenerParams + " errorCode = " + i + " httpCode = " + j);
      paramUpdateListenerParams = bics.a(l);
    } while (paramUpdateListenerParams == null);
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null) {
      QLog.e("VasUpdate_NativeUpdateBusiness", 1, "onCompleted: get null app " + str);
    }
    paramUpdateListenerParams.onCompleted(localQQAppInterface, l, str, "", (String)localObject, i, j);
  }
  
  public void deleteFile(@NonNull BusinessUpdateParams paramBusinessUpdateParams, BusinessItemInfo paramBusinessItemInfo)
  {
    long l = paramBusinessUpdateParams.mBid;
    paramBusinessUpdateParams = paramBusinessUpdateParams.mScid;
    if (QLog.isColorLevel()) {
      QLog.d("VasUpdate_NativeUpdateBusiness", 2, "deleteFiles bid = " + l + " scid = " + paramBusinessUpdateParams);
    }
    paramBusinessItemInfo = bics.a(l);
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null) {
      QLog.e("VasUpdate_NativeUpdateBusiness", 1, "deleteFiles: get null app " + paramBusinessUpdateParams);
    }
    if (paramBusinessItemInfo != null) {
      paramBusinessItemInfo.deleteFiles(localQQAppInterface, l, paramBusinessUpdateParams);
    }
  }
  
  public long getBid()
  {
    return 0L;
  }
  
  public BusinessItemInfo getBusinessItemInfo(long paramLong, String paramString)
  {
    Object localObject = bics.a(paramLong);
    if (localObject == null) {
      return null;
    }
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null) {
      QLog.e("VasUpdate_NativeUpdateBusiness", 1, "canUpdate: get null app " + paramString);
    }
    BusinessItemInfo localBusinessItemInfo = new BusinessItemInfo();
    localBusinessItemInfo.mIsCanUpdate = ((bhyw)localObject).canUpdate(localQQAppInterface, paramLong, paramString, "");
    if (QLog.isColorLevel()) {
      QLog.d("VasUpdate_NativeUpdateBusiness", 2, "canUpdate bid = " + paramLong + " scid = " + paramString + " mIsCanUpdate = " + localBusinessItemInfo.mIsCanUpdate);
    }
    localObject = ((bhyw)localObject).getItemInfo(localQQAppInterface, paramLong, paramString);
    if (localObject != null)
    {
      localBusinessItemInfo.mSavePath = ((VasQuickUpdateEngine.TagItemInfo)localObject).strSavePath;
      localBusinessItemInfo.mSaveInDir = ((VasQuickUpdateEngine.TagItemInfo)localObject).bSaveInDir;
      if (TextUtils.isEmpty(localBusinessItemInfo.mSavePath))
      {
        QLog.e("VasUpdate_NativeUpdateBusiness", 1, "getBusinessItemInfo doesn't set savePath , bid = " + paramLong + " , scid = " + paramString);
        return null;
      }
      return localBusinessItemInfo;
    }
    return null;
  }
  
  public String getFrom()
  {
    return "NativeUpdateBusiness";
  }
  
  public boolean isFileExist(@NonNull BusinessUpdateParams paramBusinessUpdateParams, BusinessItemInfo paramBusinessItemInfo)
  {
    long l = paramBusinessUpdateParams.mBid;
    paramBusinessUpdateParams = paramBusinessUpdateParams.mScid;
    if (QLog.isColorLevel()) {
      QLog.d("VasUpdate_NativeUpdateBusiness", 2, "isFileExists bid = " + l + " scid = " + paramBusinessUpdateParams);
    }
    paramBusinessItemInfo = bics.a(l);
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null) {
      QLog.e("VasUpdate_NativeUpdateBusiness", 1, "isFileExists: get null app " + paramBusinessUpdateParams);
    }
    return (paramBusinessItemInfo != null) && (paramBusinessItemInfo.isFileExists(localQQAppInterface, l, paramBusinessUpdateParams));
  }
  
  public void onLoadFail(@NonNull UpdateListenerParams paramUpdateListenerParams)
  {
    super.onLoadFail(paramUpdateListenerParams);
    a(paramUpdateListenerParams);
  }
  
  public void onLoadSuccess(@NonNull UpdateListenerParams paramUpdateListenerParams)
  {
    super.onLoadSuccess(paramUpdateListenerParams);
    a(paramUpdateListenerParams);
  }
  
  public void onProgress(@NonNull UpdateListenerParams paramUpdateListenerParams)
  {
    super.onProgress(paramUpdateListenerParams);
    Object localObject = paramUpdateListenerParams.mBusinessUpdateParams;
    if (localObject == null) {}
    long l1;
    long l2;
    long l3;
    do
    {
      return;
      l1 = ((BusinessUpdateParams)localObject).mBid;
      localObject = ((BusinessUpdateParams)localObject).mScid;
      l2 = paramUpdateListenerParams.mProgress;
      l3 = paramUpdateListenerParams.mProgressMax;
      if (QLog.isColorLevel()) {
        QLog.d("VasUpdate_NativeUpdateBusiness", 2, "onProgress bid = " + l1 + " scid = " + (String)localObject + " dwProgress = " + l2 + " dwProgressMax = " + l3);
      }
      paramUpdateListenerParams = bics.a(l1);
    } while (paramUpdateListenerParams == null);
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null) {
      QLog.e("VasUpdate_NativeUpdateBusiness", 1, "onProgress: get null app " + (String)localObject);
    }
    paramUpdateListenerParams.onProgress(localQQAppInterface, l1, (String)localObject, "", l2, l3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bidt
 * JD-Core Version:    0.7.0.1
 */