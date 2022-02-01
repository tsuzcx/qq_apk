import android.text.TextUtils;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class amhf
  implements amxk
{
  amhf(amhd paramamhd) {}
  
  public void onDownLoadFinish(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (paramBoolean) {
      if ((paramInt1 > 0) && (!ApolloUtil.d(paramInt1))) {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, "role rsc NOT complete.");
        }
      }
    }
    label96:
    do
    {
      VasExtensionHandler localVasExtensionHandler;
      do
      {
        return;
        if (paramArrayOfInt != null)
        {
          paramInt1 = 0;
          for (;;)
          {
            if (paramInt1 >= paramArrayOfInt.length) {
              break label96;
            }
            if (!ApolloUtil.c(paramArrayOfInt[paramInt1]))
            {
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("ApolloManager", 2, "dress rsc NOT complete, id:" + paramArrayOfInt[paramInt1]);
              return;
            }
            paramInt1 += 1;
          }
        }
        paramArrayOfInt = new ArrayList(1);
        paramArrayOfInt.add(paramString);
        localVasExtensionHandler = (VasExtensionHandler)this.a.a.a(71);
        localVasExtensionHandler.notifyUI(2, true, paramArrayOfInt);
        ampb.a().a(paramArrayOfInt);
        localVasExtensionHandler.a(paramString, null);
      } while (!QLog.isColorLevel());
      QLog.d("ApolloManager", 2, "apollo dress download ok notifyUI uin: " + ApolloUtil.d(paramString));
      return;
      if (!TextUtils.isEmpty(paramString))
      {
        paramArrayOfInt = new ArrayList(1);
        paramArrayOfInt.add(paramString);
        localVasExtensionHandler = (VasExtensionHandler)this.a.a.a(71);
        localVasExtensionHandler.notifyUI(2, false, paramArrayOfInt);
        localVasExtensionHandler.a(paramString, null);
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloManager", 2, "apollo dress download failed " + ApolloUtil.d(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amhf
 * JD-Core Version:    0.7.0.1
 */