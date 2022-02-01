import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.tianshu.TianShuAdPosItemData;
import cooperation.vip.tianshu.TianShuManager;
import cooperation.vip.tianshu.TianShuReportData;
import java.util.ArrayList;
import java.util.List;

public class bmkw
{
  public static List<TianShuAdPosItemData> a()
  {
    ArrayList localArrayList = new ArrayList();
    TianShuAdPosItemData localTianShuAdPosItemData = new TianShuAdPosItemData();
    localTianShuAdPosItemData.mNeedCnt = 1;
    localTianShuAdPosItemData.mPosId = 339;
    localArrayList.add(localTianShuAdPosItemData);
    localTianShuAdPosItemData = new TianShuAdPosItemData();
    localTianShuAdPosItemData.mNeedCnt = 1;
    localTianShuAdPosItemData.mPosId = 340;
    localArrayList.add(localTianShuAdPosItemData);
    localTianShuAdPosItemData = new TianShuAdPosItemData();
    localTianShuAdPosItemData.mNeedCnt = 1;
    localTianShuAdPosItemData.mPosId = 341;
    localArrayList.add(localTianShuAdPosItemData);
    return localArrayList;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2)
  {
    TianShuReportData localTianShuReportData = new TianShuReportData();
    long l = System.currentTimeMillis() / 1000L;
    localTianShuReportData.mTraceId = (String.valueOf(paramQQAppInterface.getCurrentAccountUin()) + '_' + l);
    localTianShuReportData.mActionId = paramInt;
    localTianShuReportData.mActionValue = 1;
    localTianShuReportData.mItemId = String.valueOf(paramString1);
    localTianShuReportData.mOperTime = l;
    localTianShuReportData.mTraceNum = 1;
    localTianShuReportData.mAppId = "tianshu.31";
    localTianShuReportData.mModuleId = "";
    localTianShuReportData.mTriggerInfo = paramString2;
    TianShuManager.getInstance().report(localTianShuReportData);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("TianshuAdUtils", 2, "url empty");
    }
    do
    {
      return;
      if (MiniAppLauncher.isMiniAppUrl(paramString))
      {
        MiniAppLauncher.startMiniApp(paramContext, paramString, paramInt, null);
        return;
      }
      if ((!paramString.startsWith("mqqapi://")) || (paramQQAppInterface == null)) {
        break;
      }
      paramQQAppInterface = bhey.a(paramQQAppInterface, paramContext, paramString);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.a();
    return;
    paramQQAppInterface = new Intent(paramContext, QQBrowserActivity.class);
    paramQQAppInterface.putExtra("url", paramString);
    paramContext.startActivity(paramQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmkw
 * JD-Core Version:    0.7.0.1
 */