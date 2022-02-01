import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.data.RecentItemImaxADData;
import com.tencent.mobileqq.activity.recent.data.RecentItemPublicAccountADFolderData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.imaxad.ImaxAdPresenter.1;
import com.tencent.mobileqq.imaxad.ImaxAdPresenter.2;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import tencent.im.c2s.imax.IMaxService.ExposureMsg;
import tencent.im.c2s.imax.IMaxService.IgnoreADMsg;
import tencent.im.c2s.imax.IMaxService.ReqBody;

public class avxv
  implements Handler.Callback
{
  private static final avxv jdField_a_of_type_Avxv = new avxv();
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  
  public static avxv a()
  {
    return jdField_a_of_type_Avxv;
  }
  
  private void a(int paramInt, String paramString)
  {
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool1 = false;
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    String str = paramString;
    if (paramInt == 1)
    {
      str = paramString;
      if (paramString.contains("__OS__")) {
        str = paramString.replace("__OS__", "0");
      }
      paramString = str;
      if (str.contains("__IMEI__"))
      {
        localObject1 = bhlo.a();
        paramString = "";
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          paramString = bjtz.b((String)localObject1);
        }
        paramString = str.replace("__IMEI__", paramString);
      }
      str = paramString;
      if (paramString.contains("__APP__")) {
        str = paramString.replace("__APP__", bjtz.b("android_qq"));
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementRecentUserManager", 2, "exporsure type :" + paramInt + "exporsure url :" + str.toString());
    }
    int i = -1;
    paramString = "";
    int j = i;
    boolean bool2 = bool4;
    int k = i;
    boolean bool3 = bool5;
    Object localObject1 = paramString;
    label672:
    HashMap localHashMap;
    try
    {
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(str).openConnection();
      j = i;
      bool2 = bool4;
      k = i;
      bool3 = bool5;
      localObject1 = paramString;
      localHttpURLConnection.setRequestMethod("GET");
      j = i;
      bool2 = bool4;
      k = i;
      bool3 = bool5;
      localObject1 = paramString;
      localHttpURLConnection.setConnectTimeout(30000);
      j = i;
      bool2 = bool4;
      k = i;
      bool3 = bool5;
      localObject1 = paramString;
      localHttpURLConnection.setReadTimeout(30000);
      j = i;
      bool2 = bool4;
      k = i;
      bool3 = bool5;
      localObject1 = paramString;
      localHttpURLConnection.setUseCaches(false);
      j = i;
      bool2 = bool4;
      k = i;
      bool3 = bool5;
      localObject1 = paramString;
      localHttpURLConnection.connect();
      j = i;
      bool2 = bool4;
      k = i;
      bool3 = bool5;
      localObject1 = paramString;
      int m = localHttpURLConnection.getResponseCode();
      i = m;
      if (m == 200)
      {
        i = 0;
        bool1 = true;
      }
      j = i;
      bool2 = bool1;
      k = i;
      bool3 = bool1;
      localObject1 = paramString;
      if (QLog.isColorLevel())
      {
        j = i;
        bool2 = bool1;
        k = i;
        bool3 = bool1;
        localObject1 = paramString;
        QLog.i("AdvertisementRecentUserManager", 1, "exporsure rspCode " + i + "， request thirdparty" + bool1);
      }
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("mResult", i + "");
      ((HashMap)localObject1).put("mErrDesc", "");
      ((HashMap)localObject1).put("Url", str);
      if (paramInt == 1) {}
      for (paramString = "imaxExporsureSucessRate";; paramString = "imaxClickExporsureSucessRate")
      {
        bdmc.a(BaseApplicationImpl.getContext()).a(null, paramString, bool1, 0L, 0L, (HashMap)localObject1, "");
        return;
      }
      paramString = "imaxExporsureSucessRate";
    }
    catch (Throwable localThrowable)
    {
      if (localThrowable == null)
      {
        paramString = "e is null";
        k = j;
        bool3 = bool2;
        localObject1 = paramString;
        if (QLog.isColorLevel())
        {
          k = j;
          bool3 = bool2;
          localObject1 = paramString;
          QLog.w("AdvertisementRecentUserManager", 2, paramString);
        }
        localObject1 = new HashMap();
        ((HashMap)localObject1).put("mResult", j + "");
        ((HashMap)localObject1).put("mErrDesc", paramString);
        ((HashMap)localObject1).put("Url", str);
        if (paramInt != 1) {
          break label672;
        }
      }
      for (paramString = "imaxExporsureSucessRate";; paramString = "imaxClickExporsureSucessRate")
      {
        bdmc.a(BaseApplicationImpl.getContext()).a(null, paramString, bool2, 0L, 0L, (HashMap)localObject1, "");
        return;
        k = j;
        bool3 = bool2;
        localObject1 = paramString;
        paramString = localThrowable.toString();
        break;
      }
    }
    finally
    {
      localHashMap = new HashMap();
      localHashMap.put("mResult", k + "");
      localHashMap.put("mErrDesc", localObject1);
      localHashMap.put("Url", str);
      if (paramInt != 1) {}
    }
    for (;;)
    {
      bdmc.a(BaseApplicationImpl.getContext()).a(null, paramString, bool3, 0L, 0L, localHashMap, "");
      throw localObject2;
      paramString = "imaxClickExporsureSucessRate";
    }
  }
  
  public void a(Message paramMessage)
  {
    paramMessage.setTarget(this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramMessage, 1000L);
  }
  
  public void a(BaseActivity paramBaseActivity)
  {
    alof.a(paramBaseActivity, 0L, 4096L, 1);
  }
  
  void a(QQAppInterface paramQQAppInterface, alms paramalms, AbsListView paramAbsListView, String paramString)
  {
    int i;
    if ((paramAbsListView != null) && (paramalms != null) && (paramQQAppInterface != null))
    {
      i = paramAbsListView.getFirstVisiblePosition();
      if (i <= 0) {
        break label137;
      }
      i -= 1;
    }
    label137:
    for (;;)
    {
      int k = paramAbsListView.getLastVisiblePosition();
      int j = i;
      while (j < k + 1)
      {
        Object localObject = paramalms.getItem(j);
        View localView = paramAbsListView.getChildAt(j - i);
        if ((localView != null) && (localObject != null) && ((localObject instanceof RecentItemImaxADData)))
        {
          localObject = (RecentItemImaxADData)localObject;
          localView.setTag(Integer.valueOf(j));
          b(paramQQAppInterface, ((RecentItemImaxADData)localObject).mUser.uin, ((RecentItemImaxADData)localObject).mUser.getType(), localView, paramString);
        }
        j += 1;
      }
      return;
    }
  }
  
  void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, View paramView, String paramString2)
  {
    nwo localnwo = nwo.a();
    nwf localnwf = localnwo.a(paramString1);
    if ((localnwf != null) && (avxz.a(paramView)) && (paramString2.equals(localnwf.c)))
    {
      paramString2 = paramQQAppInterface.a();
      if (paramString2 != null)
      {
        paramString1 = paramString2.b(paramString1, paramInt);
        if ((paramString1 != null) && (paramString1.size() > 0))
        {
          paramString1 = (MessageRecord)paramString1.get(paramString1.size() - 1);
          if ("false".equals(paramString1.getExtInfoFromExtStr("recent_list_advertisement_message_first_report")))
          {
            paramString1.saveExtInfoToExtStr("recent_list_advertisement_message_first_report", "true");
            ThreadManager.post(new ImaxAdPresenter.1(this, paramQQAppInterface, paramString1), 5, null, false);
            if ((localnwf != null) && (localnwf.jdField_a_of_type_Nwh != null))
            {
              bdll.a(paramQQAppInterface, "dc00898", "", localnwf.jdField_a_of_type_Nwh.jdField_a_of_type_JavaLangString, "0X8008F5D", "0X8008F5D", 0, 0, localnwf.jdField_a_of_type_Nwh.c, String.valueOf(((Integer)paramView.getTag()).intValue() + 1), nwy.a(), localnwf.jdField_a_of_type_Nwh.b);
              bdll.a(paramQQAppInterface, "dc00898", "", localnwf.jdField_a_of_type_Nwh.jdField_a_of_type_JavaLangString, "0X8008F5C", "0X8008F5C", 0, 0, localnwf.jdField_a_of_type_Nwh.c, "", nwy.a(), localnwf.jdField_a_of_type_Nwh.b);
            }
          }
        }
      }
      if ((localnwf != null) && (!localnwf.jdField_a_of_type_Boolean))
      {
        localnwf.jdField_a_of_type_Boolean = true;
        if (QLog.isColorLevel()) {
          QLog.d("AdvertisementRecentUserManager", 2, "do exposure Report");
        }
        a(localnwf);
        localnwo.a(paramQQAppInterface, 1, localnwf);
        if ((localnwf != null) && (localnwf.jdField_a_of_type_Nwh != null)) {
          bdll.a(paramQQAppInterface, "dc00898", "", localnwf.jdField_a_of_type_Nwh.jdField_a_of_type_JavaLangString, "0X8008F5F", "0X8008F5F", 0, 0, localnwf.jdField_a_of_type_Nwh.c, "", "", localnwf.jdField_a_of_type_Nwh.b);
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, nwf paramnwf)
  {
    if (paramnwf != null) {
      bdll.a(paramQQAppInterface, "dc00898", "", paramnwf.jdField_a_of_type_Nwh.jdField_a_of_type_JavaLangString, "0X8009102", "0X8009102", 0, 0, paramnwf.jdField_a_of_type_Nwh.c, "", nwy.a(), paramnwf.jdField_a_of_type_Nwh.b);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ImaxAdNetPresenter", 2, "do doDel Report fail");
  }
  
  public void a(nwf paramnwf)
  {
    if ((paramnwf == null) || (paramnwf.jdField_a_of_type_Nwh == null)) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 3;
    localMessage.obj = paramnwf.jdField_a_of_type_Nwh.e;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void a(nwf paramnwf, Activity paramActivity, AppInterface paramAppInterface)
  {
    boolean bool;
    if ((paramActivity == null) || (paramnwf == null)) {
      if (QLog.isColorLevel())
      {
        paramAppInterface = new StringBuilder().append("activity is null : ");
        if (paramActivity != null) {
          break label72;
        }
        bool = true;
        paramActivity = paramAppInterface.append(bool).append(", item is null : ");
        if (paramnwf != null) {
          break label78;
        }
        bool = true;
        label55:
        QLog.e("ImaxAdNetPresenter", 2, bool);
      }
    }
    label72:
    label78:
    label355:
    for (;;)
    {
      return;
      bool = false;
      break;
      bool = false;
      break label55;
      int i = 0;
      switch (paramnwf.jdField_a_of_type_Nwh.d)
      {
      }
      for (;;)
      {
        if ((i == 0) || (!(paramActivity instanceof PublicAccountAdvertisementActivity))) {
          break label355;
        }
        ((PublicAccountAdvertisementActivity)paramActivity).c();
        return;
        if ((paramActivity instanceof BaseActivity))
        {
          bdll.b(null, "dc00898", "", paramnwf.jdField_a_of_type_Nwh.jdField_a_of_type_JavaLangString, "0X80090FE", "0X80090FE", 0, 0, paramnwf.jdField_a_of_type_Nwh.c, "", nwy.a(), paramnwf.jdField_a_of_type_Nwh.b);
          a((BaseActivity)paramActivity);
          i = 1;
          continue;
          bdll.b(null, "dc00898", "", paramnwf.jdField_a_of_type_Nwh.jdField_a_of_type_JavaLangString, "0X8009101", "0X8009101", 0, 0, paramnwf.jdField_a_of_type_Nwh.c, "", nwy.a(), paramnwf.jdField_a_of_type_Nwh.b);
          bdll.b(null, "dc00898", "", paramnwf.jdField_a_of_type_Nwh.jdField_a_of_type_JavaLangString, "0X8009100", "0X8009100", 0, 0, paramnwf.jdField_a_of_type_Nwh.c, "", nwy.a(), paramnwf.jdField_a_of_type_Nwh.b);
          if (paramAppInterface == null)
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            paramnwf = new StringBuilder().append("app is null : ");
            if (paramAppInterface == null) {}
            for (bool = true;; bool = false)
            {
              QLog.e("ImaxAdNetPresenter", 2, bool);
              return;
            }
          }
          b(paramnwf, paramActivity, paramAppInterface);
          i = 1;
        }
      }
    }
  }
  
  public void a(nwf paramnwf, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    if ((paramnwf == null) || (paramnwf.jdField_a_of_type_Nwh == null)) {
      QLog.e("ImaxAdNetPresenter", 1, "doIMaxServiceRequest error " + paramnwf);
    }
    AppRuntime localAppRuntime;
    IMaxService.ReqBody localReqBody;
    long l;
    do
    {
      do
      {
        return;
        localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      } while (localAppRuntime == null);
      localReqBody = new IMaxService.ReqBody();
      localObject = paramnwf.jdField_a_of_type_Nwh.c;
      l = Long.parseLong(localAppRuntime.getAccount());
      if (paramInt2 == 2)
      {
        paramnwf = new IMaxService.IgnoreADMsg();
        paramnwf.uint64_uin.set(l);
        paramnwf.str_ad_id.set((String)localObject);
        localReqBody.msg_ignoreAD.set(paramnwf);
        localReqBody.int32_type.set(2);
        paramnwf = new NewIntent(BaseApplicationImpl.getApplication(), nkl.class);
        paramQQAppInterface = new avxw(this, paramInt1);
        paramQQAppInterface.b = 2;
        paramnwf.putExtra("cmd", "iMaxServiceSvc.IgnoreADMsg");
        paramnwf.putExtra("data", localReqBody.toByteArray());
        paramnwf.putExtra("isResend", false);
        paramnwf.setObserver(paramQQAppInterface);
        localAppRuntime.startServlet(paramnwf);
        return;
      }
    } while (paramInt2 != 1);
    IMaxService.ExposureMsg localExposureMsg = new IMaxService.ExposureMsg();
    localExposureMsg.str_ad_id.set((String)localObject);
    localExposureMsg.uint64_uin.set(l);
    localExposureMsg.uint32_action_type.set(1);
    localReqBody.msg_exposure.set(localExposureMsg);
    localReqBody.int32_type.set(1);
    Object localObject = new NewIntent(BaseApplicationImpl.getApplication(), nkl.class);
    paramnwf = new avxw(this, paramnwf, paramQQAppInterface);
    paramnwf.b = 2;
    ((NewIntent)localObject).putExtra("cmd", "iMaxServiceSvc.ExposureADMsg");
    ((NewIntent)localObject).putExtra("data", localReqBody.toByteArray());
    ((NewIntent)localObject).putExtra("isResend", false);
    ((NewIntent)localObject).setObserver(paramnwf);
    localAppRuntime.startServlet((NewIntent)localObject);
  }
  
  void b(QQAppInterface paramQQAppInterface, alms paramalms, AbsListView paramAbsListView, String paramString)
  {
    int i;
    if ((paramAbsListView != null) && (paramalms != null) && (paramQQAppInterface != null))
    {
      i = paramAbsListView.getFirstVisiblePosition();
      if (i <= 0) {
        break label130;
      }
      i -= 1;
    }
    label130:
    for (;;)
    {
      int k = paramAbsListView.getLastVisiblePosition();
      int j = i;
      while (j < k + 1)
      {
        Object localObject = paramalms.getItem(j);
        if ((localObject != null) && ((localObject instanceof RecentItemPublicAccountADFolderData)))
        {
          localObject = (RecentItemPublicAccountADFolderData)localObject;
          View localView = paramAbsListView.getChildAt(j - i);
          if (avxz.a(localView)) {
            a(paramQQAppInterface, ((RecentItemPublicAccountADFolderData)localObject).mUser.uin, ((RecentItemPublicAccountADFolderData)localObject).mUser.getType(), localView, paramString);
          }
        }
        j += 1;
      }
      return;
    }
  }
  
  void b(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, View paramView, String paramString2)
  {
    nwf localnwf2 = avxx.a().b(paramString1);
    nwf localnwf1 = localnwf2;
    if (localnwf2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImaxAdNetPresenter", 2, "isShowImaxAdItem item recreated " + paramString1);
      }
      localnwf1 = nwf.a(avxz.b(paramQQAppInterface.c(), paramString1));
      if (localnwf1 == null) {
        if (QLog.isColorLevel()) {
          QLog.d("ImaxAdNetPresenter", 2, "isShowImaxAdItem item false " + paramString1);
        }
      }
    }
    do
    {
      do
      {
        return;
        avxx.a().a(localnwf1);
      } while ((localnwf1 == null) || (!avxz.a(paramView)) || (!paramString2.equals(localnwf1.c)));
      paramString2 = paramQQAppInterface.a();
      if (paramString2 != null)
      {
        paramString1 = paramString2.b(paramString1, paramInt);
        if ((paramString1 != null) && (paramString1.size() > 0))
        {
          paramString1 = (MessageRecord)paramString1.get(paramString1.size() - 1);
          if ("false".equals(paramString1.getExtInfoFromExtStr("recent_list_advertisement_message_first_report")))
          {
            paramString1.saveExtInfoToExtStr("recent_list_advertisement_message_first_report", "true");
            ThreadManager.post(new ImaxAdPresenter.2(this, paramQQAppInterface, paramString1), 5, null, false);
            if ((localnwf1 != null) && (localnwf1.jdField_a_of_type_Nwh != null)) {
              bdll.a(paramQQAppInterface, "dc00898", "", localnwf1.jdField_a_of_type_Nwh.jdField_a_of_type_JavaLangString, "0X8008F5D", "0X8008F5D", 0, 0, localnwf1.jdField_a_of_type_Nwh.c, String.valueOf(((Integer)paramView.getTag()).intValue() + 1), nwy.a(), localnwf1.jdField_a_of_type_Nwh.b);
            }
          }
        }
      }
    } while ((localnwf1 == null) || (localnwf1.jdField_a_of_type_Boolean) || (localnwf1.jdField_a_of_type_Nwh == null));
    if (localnwf1.a())
    {
      a(localnwf1, paramQQAppInterface, -1, 1);
      avxz.b(paramQQAppInterface.c(), localnwf1.jdField_a_of_type_JavaLangString, localnwf1.a());
    }
    bdll.a(paramQQAppInterface, "dc00898", "", localnwf1.jdField_a_of_type_Nwh.jdField_a_of_type_JavaLangString, "0X8008F5F", "0X8008F5F", 0, 0, localnwf1.jdField_a_of_type_Nwh.c, "", "", localnwf1.jdField_a_of_type_Nwh.b);
  }
  
  public void b(nwf paramnwf)
  {
    if ((paramnwf == null) || (paramnwf.jdField_a_of_type_Nwh == null)) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 4;
    localMessage.obj = paramnwf.jdField_a_of_type_Nwh.r;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void b(nwf paramnwf, Activity paramActivity, AppInterface paramAppInterface)
  {
    if ((!TextUtils.isEmpty(paramnwf.jdField_a_of_type_Nwh.q)) && (paramnwf.jdField_a_of_type_Nwh.f != -1)) {
      bdeq.a(paramAppInterface, paramActivity, "1", "1", "1", "1", "1", "1", paramnwf.jdField_a_of_type_Nwh.q, "" + paramnwf.jdField_a_of_type_Nwh.f, "1", "1", "", "", "1", "1", "", "", "", "", "", "", "", null);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return true;
            localObject = paramMessage.getData();
          } while (localObject == null);
          localObject = ((Bundle)localObject).getString("key_ad_id");
          paramMessage = (HashMap)paramMessage.obj;
          b((QQAppInterface)((WeakReference)paramMessage.get("key_app")).get(), (alms)((WeakReference)paramMessage.get("key_adapter")).get(), (AbsListView)((WeakReference)paramMessage.get("key_listview")).get(), (String)localObject);
          return true;
          localObject = paramMessage.getData();
        } while (localObject == null);
        Object localObject = ((Bundle)localObject).getString("key_ad_id");
        paramMessage = (HashMap)paramMessage.obj;
        a((QQAppInterface)((WeakReference)paramMessage.get("key_app")).get(), (alms)((WeakReference)paramMessage.get("key_adapter")).get(), (AbsListView)((WeakReference)paramMessage.get("key_listview")).get(), (String)localObject);
        return true;
        paramMessage = (String)paramMessage.obj;
      } while (TextUtils.isEmpty(paramMessage));
      a(1, paramMessage);
      return true;
      paramMessage = (String)paramMessage.obj;
    } while (TextUtils.isEmpty(paramMessage));
    a(2, paramMessage);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avxv
 * JD-Core Version:    0.7.0.1
 */