import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.data.FullPopData;
import com.tencent.mobileqq.gamecenter.util.QQGameHelper.2;
import com.tencent.mobileqq.gamecenter.web.QQGameMsgInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class asjd
{
  public static aivw a;
  public static String a;
  
  static
  {
    jdField_a_of_type_Aivw = new asje();
    jdField_a_of_type_JavaLangString = "https://i.gtimg.cn/channel/imglib/201909/upload_368e2679238424e3f9df9be7353e26f8.zip";
  }
  
  public static int a(RecyclerView paramRecyclerView)
  {
    if (paramRecyclerView == null) {
      return -1;
    }
    int i = ((LinearLayoutManager)paramRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
    paramRecyclerView = paramRecyclerView.getLayoutManager().findViewByPosition(i);
    if (paramRecyclerView != null) {
      return i * paramRecyclerView.getHeight() - paramRecyclerView.getTop();
    }
    return -1;
  }
  
  public static long a()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    return localBaseApplicationImpl.getSharedPreferences("game_center_sp", 0).getLong(localBaseApplicationImpl.getRuntime().getAccount() + "fullpop_time", 0L);
  }
  
  public static FullPopData a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return null;
    }
    try
    {
      if (((!(paramMessageRecord instanceof MessageForArkApp)) && (!(paramMessageRecord instanceof MessageForPubAccount)) && (!(paramMessageRecord instanceof MessageForStructing))) || (TextUtils.isEmpty(paramMessageRecord.extStr))) {
        break label147;
      }
      paramMessageRecord = new JSONObject(paramMessageRecord.extStr).optString("report_key_bytes_oac_msg_extend", "");
      if (TextUtils.isEmpty(paramMessageRecord)) {
        break label147;
      }
      paramMessageRecord = new JSONObject(paramMessageRecord).optString("game_extra", "");
      if (TextUtils.isEmpty(paramMessageRecord)) {
        break label147;
      }
      paramMessageRecord = new JSONObject(paramMessageRecord).optJSONObject("full_pop");
      paramMessageRecord = new FullPopData(paramMessageRecord.optString("url"), paramMessageRecord.optString("jump_url"), paramMessageRecord.optLong("begin_time"), paramMessageRecord.optLong("end_time"), paramMessageRecord.optString("id", ""));
    }
    catch (Throwable paramMessageRecord)
    {
      for (;;)
      {
        paramMessageRecord.printStackTrace();
        paramMessageRecord = null;
      }
    }
    return paramMessageRecord;
  }
  
  public static String a()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    return localBaseApplicationImpl.getSharedPreferences("game_center_sp", 0).getString(localBaseApplicationImpl.getRuntime().getAccount() + "fullpop_id", "");
  }
  
  public static void a()
  {
    ThreadManagerV2.executeOnSubThread(new QQGameHelper.2());
  }
  
  public static void a(int paramInt1, QQGameMsgInfo paramQQGameMsgInfo, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGameHelper", 1, new Object[] { "publicAccountTianshuReport---> action=" + paramInt1, "   position=" + paramInt2 });
    }
    if (paramQQGameMsgInfo == null) {}
    String str;
    do
    {
      return;
      if (paramInt1 == 117) {
        amnk.a(paramQQGameMsgInfo.frienduin, paramQQGameMsgInfo.uniseq);
      }
      str = "";
      if (!TextUtils.isEmpty(paramQQGameMsgInfo.advId)) {
        str = paramQQGameMsgInfo.advId;
      }
    } while (TextUtils.isEmpty(str));
    amnk.a(paramInt1, paramInt2, str);
  }
  
  public static void a(long paramLong)
  {
    Object localObject = BaseApplicationImpl.getApplication();
    SharedPreferences localSharedPreferences = ((BaseApplicationImpl)localObject).getSharedPreferences("game_center_sp", 0);
    localObject = ((BaseApplicationImpl)localObject).getRuntime().getAccount() + "fullpop_time";
    localSharedPreferences.edit().putLong((String)localObject, paramLong).commit();
  }
  
  public static void a(AppInterface paramAppInterface, String paramString, aivw paramaivw, boolean paramBoolean)
  {
    int i = bdee.a(paramAppInterface.getApplication());
    if (((i == 1) || (i == 4)) && (!TextUtils.isEmpty(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQGameHelper", 1, "---->dowloadFullPopRes");
      }
      paramAppInterface = new DownloadParam();
      paramAppInterface.url = paramString;
      paramAppInterface.isPreDownload = paramBoolean;
      PreloadManager.a().a(paramAppInterface, paramaivw);
    }
  }
  
  public static void a(String paramString)
  {
    Object localObject = BaseApplicationImpl.getApplication();
    SharedPreferences localSharedPreferences = ((BaseApplicationImpl)localObject).getSharedPreferences("game_center_sp", 0);
    localObject = ((BaseApplicationImpl)localObject).getRuntime().getAccount() + "fullpop_id";
    localSharedPreferences.edit().putString((String)localObject, paramString).commit();
  }
  
  public static void a(List<MessageRecord> paramList)
  {
    if (paramList != null) {}
    ArrayList localArrayList;
    do
    {
      for (;;)
      {
        try
        {
          if (paramList.size() > 0)
          {
            localArrayList = new ArrayList();
            paramList = paramList.iterator();
            if (!paramList.hasNext()) {
              break;
            }
            localObject = (MessageRecord)paramList.next();
            if (!"2747277822".equals(((MessageRecord)localObject).frienduin)) {
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.d("QQGameHelper", 1, "enter qqgame message handle");
            }
            localObject = QQGameMsgInfo.parseMessageRecord((MessageRecord)localObject);
            if (localObject != null)
            {
              localArrayList.add(localObject);
              continue;
            }
          }
          else
          {
            return;
          }
        }
        catch (Throwable paramList)
        {
          paramList.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.d("QQGameHelper", 1, "send qqgame message fail by:" + paramList.getMessage());
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQGameHelper", 1, "parse qqgame message fail");
        }
      }
    } while (localArrayList.size() <= 0);
    paramList = new Intent("action_qgame_tool_messgae");
    paramList.setPackage(BaseApplicationImpl.getApplication().getPackageName());
    Object localObject = new Bundle();
    ((Bundle)localObject).putSerializable("key_get_msg", localArrayList);
    paramList.putExtras((Bundle)localObject);
    BaseApplicationImpl.getApplication().sendBroadcast(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asjd
 * JD-Core Version:    0.7.0.1
 */