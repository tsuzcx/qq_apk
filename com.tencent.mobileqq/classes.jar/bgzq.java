import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.subscribe.event.PublishBoxStatusEvent;
import com.tencent.biz.subscribe.event.SubscribeFeedsEvent;
import com.tencent.biz.subscribe.event.SubscribePublishFeedsEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.mini.entry.MiniAppPrePullManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.startup.step.UpdateAvSo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.event.ExoticEvent;
import cooperation.qzone.event.ExoticEventPool;
import cooperation.qzone.feed.CertifiedFakeFeed;
import eipc.EIPCResult;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bgzq
  extends QIPCModule
{
  private static bgzq jdField_a_of_type_Bgzq;
  private final AtomicReference<bgzt> jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference = new AtomicReference();
  
  public bgzq(String paramString)
  {
    super(paramString);
  }
  
  public static bgzq a()
  {
    if (jdField_a_of_type_Bgzq == null) {}
    try
    {
      if (jdField_a_of_type_Bgzq == null) {
        jdField_a_of_type_Bgzq = new bgzq("QzoneIPCModule");
      }
      return jdField_a_of_type_Bgzq;
    }
    finally {}
  }
  
  private static List<aewx> a(String paramString1, String paramString2, int paramInt)
  {
    LinkedList localLinkedList = new LinkedList();
    JSONArray localJSONArray;
    int i;
    try
    {
      paramString1 = new JSONObject(paramString1);
      if (paramString1 == null) {
        return localLinkedList;
      }
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        QLog.w("QzoneIPCModule", 2, "parseJson2Sticker: failed to parse json", paramString1);
        paramString1 = null;
      }
      localJSONArray = paramString1.optJSONArray("data");
      if ((localJSONArray == null) || (localJSONArray.length() == 0))
      {
        paramString2 = new StringBuilder().append("parseJson2Sticker: empty data ");
        if (localJSONArray == null) {}
        for (paramString1 = "null";; paramString1 = "0")
        {
          QLog.i("QzoneIPCModule", 2, paramString1);
          return localLinkedList;
        }
      }
      i = 0;
    }
    for (;;)
    {
      if ((i >= localJSONArray.length()) || (i > paramInt)) {
        return localLinkedList;
      }
      paramString1 = localJSONArray.optJSONObject(i);
      String str = paramString1.optString("url");
      paramString1 = paramString1.optString("md5");
      aewx localaewx = new aewx();
      localaewx.b(str);
      localaewx.d(paramString1);
      paramString1 = paramString2;
      if (paramString2 != null)
      {
        paramString1 = paramString2;
        if (paramString2.equals(str))
        {
          localaewx.b(true);
          paramString1 = null;
        }
      }
      localLinkedList.add(localaewx);
      i += 1;
      paramString2 = paramString1;
    }
  }
  
  public static JSONObject a(List<aewh> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      localObject1 = new StringBuilder().append("parseSticker2Json: empty img list ");
      if (paramList == null) {}
      for (paramList = "null";; paramList = Integer.valueOf(paramList.size()))
      {
        QLog.i("QzoneIPCModule", 2, paramList);
        return null;
      }
    }
    Object localObject1 = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject2 = (aewh)paramList.next();
      if ((localObject2 != null) && ((localObject2 instanceof aewx)))
      {
        localObject2 = (aewx)localObject2;
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("url", ((aewx)localObject2).a()).put("thumbUrl", ((aewx)localObject2).e()).put("md5", ((aewx)localObject2).b());
          localJSONArray.put(localJSONObject);
        }
        catch (JSONException localJSONException)
        {
          QLog.w("QzoneIPCModule", 2, "parseSticker2Json: failed to create data json", localJSONException);
        }
      }
    }
    try
    {
      ((JSONObject)localObject1).put("data", localJSONArray);
      return localObject1;
    }
    catch (JSONException paramList)
    {
      QLog.w("QzoneIPCModule", 2, "parseSticker2Json: failed to put data json", paramList);
    }
    return null;
  }
  
  public void a()
  {
    QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:qzone", "QzoneIPCModule", "cooperation.qzone.ACTION_PUBLIC_ACCOUNT_GET_TASK_LIST", null, new bgzs(this));
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    bgzt localbgzt;
    do
    {
      return;
      QLog.i("QzoneIPCModule", 1, "onGetStickerRecResp: " + paramString1 + " " + paramString2);
      localbgzt = (bgzt)this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get();
    } while ((localbgzt == null) || (!paramString1.equals(bgzt.b(localbgzt))) || (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.compareAndSet(localbgzt, null)));
    bgzt.a(localbgzt, paramString2);
    bgzt.b(localbgzt, paramString3);
    bgzt.a(localbgzt).countDown();
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    paramInt = 0;
    if (QLog.isColorLevel()) {
      QLog.d("QzoneIPCModule", 2, "action = " + paramString);
    }
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if (!(localObject1 instanceof QQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QzoneIPCModule", 2, "onRemoteInvoke cannot get QQAppInterface");
      }
      return null;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)localObject1;
    if ("getHostInfo".equals(paramString)) {
      try
      {
        paramString = ((ajxn)localQQAppInterface.getManager(51)).c(localQQAppInterface.getCurrentAccountUin());
        paramBundle = new Bundle();
        paramBundle.putLong("age", paramString.age);
        paramBundle.putLong("gender", paramString.shGender);
        paramBundle.putLong("constellation", paramString.constellation);
        paramBundle.putString("country", paramString.strCountry);
        paramBundle.putString("province", paramString.strProvince);
        paramBundle.putString("city", paramString.strCity);
        paramString = EIPCResult.createResult(0, paramBundle);
        return paramString;
      }
      catch (Exception paramString)
      {
        QLog.e("QzoneIPCModule", 1, paramString, new Object[0]);
        return null;
      }
    }
    boolean bool;
    if ("isFriend".equals(paramString))
    {
      long l = 0L;
      if (paramBundle != null) {}
      try
      {
        l = paramBundle.getLong("uin");
        bool = ((ajxn)localQQAppInterface.getManager(51)).b(String.valueOf(l));
        paramString = new Bundle();
        paramString.putBoolean("isFriend", bool);
        paramString = EIPCResult.createResult(0, paramString);
        return paramString;
      }
      catch (Exception paramString)
      {
        QLog.e("QzoneIPCModule", 1, paramString, new Object[0]);
        return null;
      }
    }
    if ("startDownloadVoicechangeSo".equals(paramString)) {
      for (;;)
      {
        try
        {
          paramInt = lmb.f();
          if (paramInt > 2) {
            continue;
          }
        }
        catch (Exception paramString)
        {
          QLog.e("QzoneIPCModule", 1, paramString, new Object[0]);
          continue;
          UpdateAvSo.b(BaseApplicationImpl.sApplication, "traeimp-armeabi-v7a", true);
          continue;
        }
        try
        {
          paramString = ((anox)localQQAppInterface.getManager(77)).a(anpw.e());
          if (paramString == null) {
            continue;
          }
          paramString.a(false);
        }
        catch (Exception paramString)
        {
          QLog.e("QzoneIPCModule", 1, "voiceChang checkVcSo Exception:" + paramString.getMessage());
          continue;
        }
        return EIPCResult.createResult(0, new Bundle());
        QLog.e("QzoneIPCModule", 1, "voiceChang checkVcSo null == earlyHandler:");
      }
    }
    if ("action_qzone_pic_pre_send".equals(paramString)) {
      try
      {
        aunf.a(localQQAppInterface, paramBundle);
        paramString = new Bundle();
        paramString.putBoolean("qzone_pre_send_result", true);
        paramString = EIPCResult.createResult(0, paramString);
        return paramString;
      }
      catch (Exception paramString)
      {
        QLog.e("QzoneIPCModule", 1, "action QzonePic preSend exception: ", paramString);
        return null;
      }
    }
    if ("action_qzone_get_sticker_rec_gif".equals(paramString))
    {
      if (paramBundle == null) {
        break label1905;
      }
      paramString = paramBundle.getString("analyze_text");
      localObject1 = paramBundle.getString("toUin");
      paramBundle = paramString;
      paramString = (String)localObject1;
    }
    for (;;)
    {
      if ((TextUtils.isEmpty(paramBundle)) || (TextUtils.isEmpty(paramString)))
      {
        QLog.w("QzoneIPCModule", 1, "empty text or unit " + paramBundle + " , " + paramString);
        return null;
      }
      Object localObject2 = aexd.a(localQQAppInterface);
      ((aexd)localObject2).a();
      if (!((aexd)localObject2).b())
      {
        QLog.i("QzoneIPCModule", 1, "emo rec is not open");
        return null;
      }
      localObject1 = new bgzt(paramBundle, null);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.set(localObject1);
      if (!((aexd)localObject2).a(paramBundle, 0, paramString, true))
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.compareAndSet(localObject1, null);
        return null;
      }
      try
      {
        bgzt.a((bgzt)localObject1).await(2L, TimeUnit.SECONDS);
        if (TextUtils.isEmpty(bgzt.a((bgzt)localObject1)))
        {
          QLog.i("QzoneIPCModule", 1, "empty sticker rec resp list");
          return EIPCResult.createResult(-102, null);
        }
      }
      catch (InterruptedException paramString)
      {
        for (;;)
        {
          QLog.w("QzoneIPCModule", 1, "waiting req interrupted ", paramString);
        }
        paramString = new Bundle();
        paramString.putString("analyze_text", bgzt.b((bgzt)localObject1));
        paramString.putString("resp_data", bgzt.a((bgzt)localObject1));
        paramString.putString("resp_pass", bgzt.c((bgzt)localObject1));
        return EIPCResult.createSuccessResult(paramString);
      }
      String str;
      Object localObject3;
      if ("action_qzone_report_sticker_gif".equals(paramString))
      {
        if (paramBundle == null) {
          break label1889;
        }
        str = paramBundle.getString("rpt_data");
        localObject2 = paramBundle.getString("rpt_click");
        paramString = paramBundle.getString("toUin");
        localObject1 = paramBundle.getString("rpt_pass");
        localObject3 = paramBundle.getString("analyze_text");
        paramInt = paramBundle.getInt("rpt_expose_cnt", 0);
        paramBundle = (Bundle)localObject3;
      }
      for (;;)
      {
        for (;;)
        {
          if ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(paramBundle)) || (paramInt < 1)) {
            break label1903;
          }
          localObject3 = new aexj();
          ((aexj)localObject3).jdField_a_of_type_JavaLangString = paramBundle;
          ((aexj)localObject3).b = ((String)localObject1);
          ((aexj)localObject3).jdField_a_of_type_JavaUtilList = a(str, (String)localObject2, paramInt);
          paramBundle = aexd.a(localQQAppInterface);
          paramBundle.a();
          paramBundle.a(Collections.singletonList(localObject3), true, 11000, paramString);
          return EIPCResult.createSuccessResult(null);
          if ("action_save_customenotion".equals(paramString))
          {
            if (paramBundle == null) {
              break;
            }
            paramString = paramBundle.getString("pic_path");
            if (TextUtils.isEmpty(paramString)) {
              break;
            }
            paramInt = aehy.a(localQQAppInterface, paramString);
            paramString = new Bundle();
            paramString.putInt("resultCode", paramInt);
            return EIPCResult.createSuccessResult(paramString);
          }
          if ("action_pre_pull_mini_app".equals(paramString))
          {
            if (paramBundle == null) {
              break;
            }
            QLog.d("QzoneIPCModule", 4, "ACTION_PRE_PULL_MINI_APP change to qq_process by QzoneIPCModule");
            paramString = paramBundle.getString("miniapp_preload_link");
            paramInt = paramBundle.getInt("miniapp_preload_link_type");
            MiniAppPrePullManager.getInstance().prePullAppinfoByLink(paramString, paramInt, new bgzr(this));
            return null;
          }
          if ("cooperation.qzone.ACTION_PUBLIC_ACCOUNT_FAKE_FEED_CREATE".equalsIgnoreCase(paramString))
          {
            QLog.d("QzoneIPCModule", 4, "ACTION_PUBLIC_ACCOUNT_FAKE_FEED_CREATE to qq_process by QzoneIPCModule");
            paramBundle.setClassLoader(CertifiedFakeFeed.class.getClassLoader());
            paramString = paramBundle.getParcelable("KEY_CERTIFIED_FAKE_FEED");
            if (!(paramString instanceof CertifiedFakeFeed)) {
              break;
            }
            paramString = (CertifiedFakeFeed)paramString;
            wpw.a().a(new SubscribeFeedsEvent(paramString, 1));
            return null;
          }
          if ("cooperation.qzone.ACTION_PUBLIC_ACCOUNT_FAKE_FEED_UPDATE".equalsIgnoreCase(paramString))
          {
            QLog.d("QzoneIPCModule", 4, "ACTION_PUBLIC_ACCOUNT_FAKE_FEED_UPDATE to qq_process by QzoneIPCModule");
            paramBundle.setClassLoader(CertifiedFakeFeed.class.getClassLoader());
            paramString = paramBundle.getParcelable("KEY_CERTIFIED_FAKE_FEED");
            if (!(paramString instanceof CertifiedFakeFeed)) {
              break;
            }
            paramString = (CertifiedFakeFeed)paramString;
            wpw.a().a(new SubscribeFeedsEvent(paramString, 2));
            return null;
          }
          if ("cooperation.qzone.ACTION_PUBLIC_ACCOUNT_FAKE_FEED_DELETE".equalsIgnoreCase(paramString))
          {
            QLog.d("QzoneIPCModule", 4, "ACTION_PUBLIC_ACCOUNT_FAKE_FEED_DELETE to qq_process by QzoneIPCModule");
            paramBundle.setClassLoader(CertifiedFakeFeed.class.getClassLoader());
            paramString = paramBundle.getParcelable("KEY_CERTIFIED_FAKE_FEED");
            if (!(paramString instanceof CertifiedFakeFeed)) {
              break;
            }
            paramString = (CertifiedFakeFeed)paramString;
            wpw.a().a(new SubscribeFeedsEvent(paramString, 3));
            return null;
          }
          if ("cooperation.qzone.ACTION_PUBLIC_ACCOUNT_QUEUE_CHANGED".equalsIgnoreCase(paramString))
          {
            QLog.d("QzoneIPCModule", 4, "ACTION_PUBLIC_ACCOUNT_QUEUE_CHANGED to qq_process by QzoneIPCModule");
            wpw.a().a(new PublishBoxStatusEvent(paramBundle));
            wpw.a().a(new SubscribeFeedsEvent(4));
            return null;
          }
          if ("action_qzone_get_themeid".equalsIgnoreCase(paramString)) {
            try
            {
              paramString = new Bundle();
              paramString.putString("themeId", ThemeUtil.getCurrentThemeId());
              paramString = EIPCResult.createResult(0, paramString);
              return paramString;
            }
            catch (Exception paramString)
            {
              QLog.e("QzoneIPCModule", 1, "action getThemeId exception: ", paramString);
              return null;
            }
          }
          if ("cooperation.qzone.ACTION_PUBLIC_ACCOUNT_UNFOLLOW".equalsIgnoreCase(paramString))
          {
            if (paramBundle == null) {
              break;
            }
            paramString = paramBundle.getString("uin", null);
            if (paramString == null) {
              break;
            }
            sgj.a(localQQAppInterface, localQQAppInterface.getApp().getApplicationContext(), paramString, false, null, true);
            bhox.a(localQQAppInterface.getApp().getApplicationContext(), paramString, 0);
            return null;
          }
          if ("action_qzone_main_process_prop_set".equalsIgnoreCase(paramString))
          {
            if (paramBundle == null) {
              break;
            }
            paramString = paramBundle.getString("key", null);
            if (paramString == null) {
              break;
            }
            bool = paramBundle.getBoolean("value");
            localQQAppInterface.getApp().getSharedPreferences("QZ_main_setting", 0).edit().putBoolean(paramString, bool).apply();
            return EIPCResult.createSuccessResult(null);
          }
          if ("action_qzone_main_process_prop_get".equalsIgnoreCase(paramString))
          {
            if (paramBundle == null) {
              break;
            }
            paramString = paramBundle.getString("key", null);
            if (paramString == null) {
              break;
            }
            bool = localQQAppInterface.getApp().getSharedPreferences("QZ_main_setting", 0).getBoolean(paramString, false);
            paramString = new Bundle();
            paramString.putBoolean("value", bool);
            return EIPCResult.createSuccessResult(paramString);
          }
          if ("action_qzone_send_event".equalsIgnoreCase(paramString))
          {
            if (bhbh.c()) {
              return EIPCResult.createResult(-1, null);
            }
            if (paramBundle != null)
            {
              paramBundle.setClassLoader(ExoticEvent.getLoader());
              paramString = (ExoticEvent)paramBundle.getParcelable("event");
              if (paramString != null)
              {
                bool = ExoticEventPool.getInstance().onEventReceived(paramString);
                paramString = new Bundle();
                paramString.putBoolean("re", bool);
                return EIPCResult.createSuccessResult(paramString);
              }
            }
            return EIPCResult.createResult(-1, null);
          }
          if ("cooperation.qzone.ACTION_PUBLIC_ACCOUNT_FEED_PUBLISH".equalsIgnoreCase(paramString))
          {
            QLog.d("QzoneIPCModule", 4, "ACTION_PUBLIC_ACCOUNT_FEED_PUBLISH to qq_process by QzoneIPCModule");
            try
            {
              paramString = paramBundle.getByteArray("bundle_key_feed_byte_array");
              paramBundle = new CertifiedAccountMeta.StFeed();
              if (paramString == null) {
                break;
              }
              paramString = (CertifiedAccountMeta.StFeed)paramBundle.mergeFrom(paramString);
              QLog.d("QzoneIPCModule", 4, "ACTION_PUBLIC_ACCOUNT_FEED_PUBLISH publishFeed" + paramString.id.get());
              wpw.a().a(new SubscribePublishFeedsEvent(paramString, 1));
              return null;
            }
            catch (Exception paramString)
            {
              paramString.printStackTrace();
              QLog.e("QzoneIPCModule", 4, "ACTION_PUBLIC_ACCOUNT_FEED_PUBLISH error" + paramString);
              return null;
            }
          }
        }
        if ("action_qzone_show_push_setting_banner".equalsIgnoreCase(paramString))
        {
          paramString = new Bundle();
          paramBundle = amgg.a(localQQAppInterface);
          if (paramBundle == null)
          {
            QLog.d("QzoneIPCModule", 1, "ACTION_SHOW_PUSH_SETTING_BANNER null mgr");
            return EIPCResult.createResult(-102, null);
          }
          bool = paramBundle.b();
          paramString.putBoolean("visible", bool);
          if (bool)
          {
            localObject1 = amtl.a();
            if (localObject1 == null) {
              break label1832;
            }
            paramBundle = ((amtk)localObject1).a();
            localObject1 = ((amtk)localObject1).b();
            paramString.putString("msg", paramBundle);
            paramString.putString("setting", (String)localObject1);
          }
          for (;;)
          {
            return EIPCResult.createSuccessResult(paramString);
            label1832:
            QLog.d("QzoneIPCModule", 1, "ACTION_SHOW_PUSH_SETTING_BANNER null conf bean");
          }
        }
        if (!"action_qzone_close_push_setting_banner".equalsIgnoreCase(paramString)) {
          break;
        }
        paramString = amgg.a(localQQAppInterface);
        if (paramString == null)
        {
          QLog.d("QzoneIPCModule", 1, "ACTION_CLOSE_PUSH_SETTING_BANNER null mgr");
          return EIPCResult.createResult(-102, null);
        }
        paramString.a();
        return EIPCResult.createSuccessResult(null);
        label1889:
        paramBundle = null;
        localObject1 = null;
        localObject2 = null;
        str = null;
        paramString = null;
      }
      label1903:
      break;
      label1905:
      paramString = null;
      paramBundle = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgzq
 * JD-Core Version:    0.7.0.1
 */