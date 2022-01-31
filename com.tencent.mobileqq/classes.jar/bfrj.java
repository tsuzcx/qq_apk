import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.subscribe.event.PublishBoxStatusEvent;
import com.tencent.biz.subscribe.event.SubscribeFeedsEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.mini.entry.MiniAppPrePullManager;
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

public class bfrj
  extends QIPCModule
{
  private static bfrj jdField_a_of_type_Bfrj;
  private final AtomicReference<bfrm> jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference = new AtomicReference();
  
  public bfrj(String paramString)
  {
    super(paramString);
  }
  
  public static bfrj a()
  {
    if (jdField_a_of_type_Bfrj == null) {}
    try
    {
      if (jdField_a_of_type_Bfrj == null) {
        jdField_a_of_type_Bfrj = new bfrj("QzoneIPCModule");
      }
      return jdField_a_of_type_Bfrj;
    }
    finally {}
  }
  
  private static List<aemc> a(String paramString1, String paramString2, int paramInt)
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
      aemc localaemc = new aemc();
      localaemc.b(str);
      localaemc.d(paramString1);
      paramString1 = paramString2;
      if (paramString2 != null)
      {
        paramString1 = paramString2;
        if (paramString2.equals(str))
        {
          localaemc.b(true);
          paramString1 = null;
        }
      }
      localLinkedList.add(localaemc);
      i += 1;
      paramString2 = paramString1;
    }
  }
  
  public static JSONObject a(List<aelm> paramList)
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
      Object localObject2 = (aelm)paramList.next();
      if ((localObject2 != null) && ((localObject2 instanceof aemc)))
      {
        localObject2 = (aemc)localObject2;
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("url", ((aemc)localObject2).a()).put("thumbUrl", ((aemc)localObject2).e()).put("md5", ((aemc)localObject2).b());
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
    QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:qzone", "QzoneIPCModule", "cooperation.qzone.ACTION_PUBLIC_ACCOUNT_GET_TASK_LIST", null, new bfrl(this));
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    bfrm localbfrm;
    do
    {
      return;
      QLog.i("QzoneIPCModule", 1, "onGetStickerRecResp: " + paramString1 + " " + paramString2);
      localbfrm = (bfrm)this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get();
    } while ((localbfrm == null) || (!paramString1.equals(bfrm.b(localbfrm))) || (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.compareAndSet(localbfrm, null)));
    bfrm.a(localbfrm, paramString2);
    bfrm.b(localbfrm, paramString3);
    bfrm.a(localbfrm).countDown();
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
        paramString = ((ajjj)localQQAppInterface.getManager(51)).c(localQQAppInterface.getCurrentAccountUin());
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
        bool = ((ajjj)localQQAppInterface.getManager(51)).b(String.valueOf(l));
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
          paramInt = lbk.f();
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
          paramString = ((amyp)localQQAppInterface.getManager(77)).a(amzo.e());
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
        atph.a(localQQAppInterface, paramBundle);
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
        break label1609;
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
      Object localObject2 = aemi.a(localQQAppInterface);
      ((aemi)localObject2).a();
      if (!((aemi)localObject2).b())
      {
        QLog.i("QzoneIPCModule", 1, "emo rec is not open");
        return null;
      }
      localObject1 = new bfrm(paramBundle, null);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.set(localObject1);
      if (!((aemi)localObject2).a(paramBundle, 0, paramString, true))
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.compareAndSet(localObject1, null);
        return null;
      }
      try
      {
        bfrm.a((bfrm)localObject1).await(2L, TimeUnit.SECONDS);
        if (TextUtils.isEmpty(bfrm.a((bfrm)localObject1)))
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
        paramString.putString("analyze_text", bfrm.b((bfrm)localObject1));
        paramString.putString("resp_data", bfrm.a((bfrm)localObject1));
        paramString.putString("resp_pass", bfrm.c((bfrm)localObject1));
        return EIPCResult.createSuccessResult(paramString);
      }
      String str;
      Object localObject3;
      if ("action_qzone_report_sticker_gif".equals(paramString))
      {
        if (paramBundle == null) {
          break label1593;
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
        if ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(paramBundle)) || (paramInt < 1)) {
          break label1607;
        }
        localObject3 = new aemo();
        ((aemo)localObject3).jdField_a_of_type_JavaLangString = paramBundle;
        ((aemo)localObject3).b = ((String)localObject1);
        ((aemo)localObject3).jdField_a_of_type_JavaUtilList = a(str, (String)localObject2, paramInt);
        paramBundle = aemi.a(localQQAppInterface);
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
          paramInt = adwz.a(localQQAppInterface, paramString);
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
          MiniAppPrePullManager.getInstance().prePullAppinfoByLink(paramString, paramInt, new bfrk(this));
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
          wcj.a().a(new SubscribeFeedsEvent(paramString, 1));
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
          wcj.a().a(new SubscribeFeedsEvent(paramString, 2));
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
          wcj.a().a(new SubscribeFeedsEvent(paramString, 3));
          return null;
        }
        if ("cooperation.qzone.ACTION_PUBLIC_ACCOUNT_QUEUE_CHANGED".equalsIgnoreCase(paramString))
        {
          QLog.d("QzoneIPCModule", 4, "ACTION_PUBLIC_ACCOUNT_QUEUE_CHANGED to qq_process by QzoneIPCModule");
          wcj.a().a(new PublishBoxStatusEvent(paramBundle));
          wcj.a().a(new SubscribeFeedsEvent(4));
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
          rtr.a(localQQAppInterface, localQQAppInterface.getApp().getApplicationContext(), paramString, false, null, true);
          bggd.a(localQQAppInterface.getApp().getApplicationContext(), paramString, 0);
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
        if (!"action_qzone_send_event".equalsIgnoreCase(paramString)) {
          break;
        }
        if (bfsz.b()) {
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
        label1593:
        paramBundle = null;
        localObject1 = null;
        localObject2 = null;
        str = null;
        paramString = null;
      }
      label1607:
      break;
      label1609:
      paramString = null;
      paramBundle = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bfrj
 * JD-Core Version:    0.7.0.1
 */