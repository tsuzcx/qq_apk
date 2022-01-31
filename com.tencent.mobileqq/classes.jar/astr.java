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

public class astr
  implements Handler.Callback
{
  private static final astr jdField_a_of_type_Astr = new astr();
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  
  public static astr a()
  {
    return jdField_a_of_type_Astr;
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
        localObject1 = bdcb.a();
        paramString = "";
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          paramString = bfhi.b((String)localObject1);
        }
        paramString = str.replace("__IMEI__", paramString);
      }
      str = paramString;
      if (paramString.contains("__APP__")) {
        str = paramString.replace("__APP__", bfhi.b("android_qq"));
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
        azmz.a(BaseApplicationImpl.getContext()).a(null, paramString, bool1, 0L, 0L, (HashMap)localObject1, "");
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
        azmz.a(BaseApplicationImpl.getContext()).a(null, paramString, bool2, 0L, 0L, (HashMap)localObject1, "");
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
      azmz.a(BaseApplicationImpl.getContext()).a(null, paramString, bool3, 0L, 0L, localHashMap, "");
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
    ajfr.a(paramBaseActivity, 0L, 4096L, 1);
  }
  
  void a(QQAppInterface paramQQAppInterface, ajee paramajee, AbsListView paramAbsListView, String paramString)
  {
    int i;
    if ((paramAbsListView != null) && (paramajee != null) && (paramQQAppInterface != null))
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
        Object localObject = paramajee.getItem(j);
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
    nlx localnlx = nlx.a();
    nlo localnlo = localnlx.a(paramString1);
    if ((localnlo != null) && (astv.a(paramView)) && (paramString2.equals(localnlo.c)))
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
            if ((localnlo != null) && (localnlo.jdField_a_of_type_Nlq != null))
            {
              azmj.a(paramQQAppInterface, "dc00898", "", localnlo.jdField_a_of_type_Nlq.jdField_a_of_type_JavaLangString, "0X8008F5D", "0X8008F5D", 0, 0, localnlo.jdField_a_of_type_Nlq.c, String.valueOf(((Integer)paramView.getTag()).intValue() + 1), nmh.a(), localnlo.jdField_a_of_type_Nlq.b);
              azmj.a(paramQQAppInterface, "dc00898", "", localnlo.jdField_a_of_type_Nlq.jdField_a_of_type_JavaLangString, "0X8008F5C", "0X8008F5C", 0, 0, localnlo.jdField_a_of_type_Nlq.c, "", nmh.a(), localnlo.jdField_a_of_type_Nlq.b);
            }
          }
        }
      }
      if ((localnlo != null) && (!localnlo.jdField_a_of_type_Boolean))
      {
        localnlo.jdField_a_of_type_Boolean = true;
        if (QLog.isColorLevel()) {
          QLog.d("AdvertisementRecentUserManager", 2, "do exposure Report");
        }
        a(localnlo);
        localnlx.a(paramQQAppInterface, 1, localnlo);
        if ((localnlo != null) && (localnlo.jdField_a_of_type_Nlq != null)) {
          azmj.a(paramQQAppInterface, "dc00898", "", localnlo.jdField_a_of_type_Nlq.jdField_a_of_type_JavaLangString, "0X8008F5F", "0X8008F5F", 0, 0, localnlo.jdField_a_of_type_Nlq.c, "", "", localnlo.jdField_a_of_type_Nlq.b);
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, nlo paramnlo)
  {
    if (paramnlo != null) {
      azmj.a(paramQQAppInterface, "dc00898", "", paramnlo.jdField_a_of_type_Nlq.jdField_a_of_type_JavaLangString, "0X8009102", "0X8009102", 0, 0, paramnlo.jdField_a_of_type_Nlq.c, "", nmh.a(), paramnlo.jdField_a_of_type_Nlq.b);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ImaxAdNetPresenter", 2, "do doDel Report fail");
  }
  
  public void a(nlo paramnlo)
  {
    if ((paramnlo == null) || (paramnlo.jdField_a_of_type_Nlq == null)) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 3;
    localMessage.obj = paramnlo.jdField_a_of_type_Nlq.e;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void a(nlo paramnlo, Activity paramActivity, AppInterface paramAppInterface)
  {
    boolean bool;
    if ((paramActivity == null) || (paramnlo == null)) {
      if (QLog.isColorLevel())
      {
        paramAppInterface = new StringBuilder().append("activity is null : ");
        if (paramActivity != null) {
          break label72;
        }
        bool = true;
        paramActivity = paramAppInterface.append(bool).append(", item is null : ");
        if (paramnlo != null) {
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
      switch (paramnlo.jdField_a_of_type_Nlq.d)
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
          azmj.b(null, "dc00898", "", paramnlo.jdField_a_of_type_Nlq.jdField_a_of_type_JavaLangString, "0X80090FE", "0X80090FE", 0, 0, paramnlo.jdField_a_of_type_Nlq.c, "", nmh.a(), paramnlo.jdField_a_of_type_Nlq.b);
          a((BaseActivity)paramActivity);
          i = 1;
          continue;
          azmj.b(null, "dc00898", "", paramnlo.jdField_a_of_type_Nlq.jdField_a_of_type_JavaLangString, "0X8009101", "0X8009101", 0, 0, paramnlo.jdField_a_of_type_Nlq.c, "", nmh.a(), paramnlo.jdField_a_of_type_Nlq.b);
          azmj.b(null, "dc00898", "", paramnlo.jdField_a_of_type_Nlq.jdField_a_of_type_JavaLangString, "0X8009100", "0X8009100", 0, 0, paramnlo.jdField_a_of_type_Nlq.c, "", nmh.a(), paramnlo.jdField_a_of_type_Nlq.b);
          if (paramAppInterface == null)
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            paramnlo = new StringBuilder().append("app is null : ");
            if (paramAppInterface == null) {}
            for (bool = true;; bool = false)
            {
              QLog.e("ImaxAdNetPresenter", 2, bool);
              return;
            }
          }
          b(paramnlo, paramActivity, paramAppInterface);
          i = 1;
        }
      }
    }
  }
  
  public void a(nlo paramnlo, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    if ((paramnlo == null) || (paramnlo.jdField_a_of_type_Nlq == null)) {
      QLog.e("ImaxAdNetPresenter", 1, "doIMaxServiceRequest error " + paramnlo);
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
      localObject = paramnlo.jdField_a_of_type_Nlq.c;
      l = Long.parseLong(localAppRuntime.getAccount());
      if (paramInt2 == 2)
      {
        paramnlo = new IMaxService.IgnoreADMsg();
        paramnlo.uint64_uin.set(l);
        paramnlo.str_ad_id.set((String)localObject);
        localReqBody.msg_ignoreAD.set(paramnlo);
        localReqBody.int32_type.set(2);
        paramnlo = new NewIntent(BaseApplicationImpl.getApplication(), mzx.class);
        paramQQAppInterface = new asts(this, paramInt1);
        paramQQAppInterface.b = 2;
        paramnlo.putExtra("cmd", "iMaxServiceSvc.IgnoreADMsg");
        paramnlo.putExtra("data", localReqBody.toByteArray());
        paramnlo.putExtra("isResend", false);
        paramnlo.setObserver(paramQQAppInterface);
        localAppRuntime.startServlet(paramnlo);
        return;
      }
    } while (paramInt2 != 1);
    IMaxService.ExposureMsg localExposureMsg = new IMaxService.ExposureMsg();
    localExposureMsg.str_ad_id.set((String)localObject);
    localExposureMsg.uint64_uin.set(l);
    localExposureMsg.uint32_action_type.set(1);
    localReqBody.msg_exposure.set(localExposureMsg);
    localReqBody.int32_type.set(1);
    Object localObject = new NewIntent(BaseApplicationImpl.getApplication(), mzx.class);
    paramnlo = new asts(this, paramnlo, paramQQAppInterface);
    paramnlo.b = 2;
    ((NewIntent)localObject).putExtra("cmd", "iMaxServiceSvc.ExposureADMsg");
    ((NewIntent)localObject).putExtra("data", localReqBody.toByteArray());
    ((NewIntent)localObject).putExtra("isResend", false);
    ((NewIntent)localObject).setObserver(paramnlo);
    localAppRuntime.startServlet((NewIntent)localObject);
  }
  
  void b(QQAppInterface paramQQAppInterface, ajee paramajee, AbsListView paramAbsListView, String paramString)
  {
    int i;
    if ((paramAbsListView != null) && (paramajee != null) && (paramQQAppInterface != null))
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
        Object localObject = paramajee.getItem(j);
        if ((localObject != null) && ((localObject instanceof RecentItemPublicAccountADFolderData)))
        {
          localObject = (RecentItemPublicAccountADFolderData)localObject;
          View localView = paramAbsListView.getChildAt(j - i);
          if (astv.a(localView)) {
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
    nlo localnlo2 = astt.a().b(paramString1);
    nlo localnlo1 = localnlo2;
    if (localnlo2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImaxAdNetPresenter", 2, "isShowImaxAdItem item recreated " + paramString1);
      }
      localnlo1 = nlo.a(astv.b(paramQQAppInterface.c(), paramString1));
      if (localnlo1 == null) {
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
        astt.a().a(localnlo1);
      } while ((localnlo1 == null) || (!astv.a(paramView)) || (!paramString2.equals(localnlo1.c)));
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
            if ((localnlo1 != null) && (localnlo1.jdField_a_of_type_Nlq != null)) {
              azmj.a(paramQQAppInterface, "dc00898", "", localnlo1.jdField_a_of_type_Nlq.jdField_a_of_type_JavaLangString, "0X8008F5D", "0X8008F5D", 0, 0, localnlo1.jdField_a_of_type_Nlq.c, String.valueOf(((Integer)paramView.getTag()).intValue() + 1), nmh.a(), localnlo1.jdField_a_of_type_Nlq.b);
            }
          }
        }
      }
    } while ((localnlo1 == null) || (localnlo1.jdField_a_of_type_Boolean) || (localnlo1.jdField_a_of_type_Nlq == null));
    if (localnlo1.a())
    {
      a(localnlo1, paramQQAppInterface, -1, 1);
      astv.b(paramQQAppInterface.c(), localnlo1.jdField_a_of_type_JavaLangString, localnlo1.a());
    }
    azmj.a(paramQQAppInterface, "dc00898", "", localnlo1.jdField_a_of_type_Nlq.jdField_a_of_type_JavaLangString, "0X8008F5F", "0X8008F5F", 0, 0, localnlo1.jdField_a_of_type_Nlq.c, "", "", localnlo1.jdField_a_of_type_Nlq.b);
  }
  
  public void b(nlo paramnlo)
  {
    if ((paramnlo == null) || (paramnlo.jdField_a_of_type_Nlq == null)) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 4;
    localMessage.obj = paramnlo.jdField_a_of_type_Nlq.r;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void b(nlo paramnlo, Activity paramActivity, AppInterface paramAppInterface)
  {
    if ((!TextUtils.isEmpty(paramnlo.jdField_a_of_type_Nlq.q)) && (paramnlo.jdField_a_of_type_Nlq.f != -1)) {
      azgr.a(paramAppInterface, paramActivity, "1", "1", "1", "1", "1", "1", paramnlo.jdField_a_of_type_Nlq.q, "" + paramnlo.jdField_a_of_type_Nlq.f, "1", "1", "", "", "1", "1", "", "", "", "", "", "", "", null);
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
          b((QQAppInterface)((WeakReference)paramMessage.get("key_app")).get(), (ajee)((WeakReference)paramMessage.get("key_adapter")).get(), (AbsListView)((WeakReference)paramMessage.get("key_listview")).get(), (String)localObject);
          return true;
          localObject = paramMessage.getData();
        } while (localObject == null);
        Object localObject = ((Bundle)localObject).getString("key_ad_id");
        paramMessage = (HashMap)paramMessage.obj;
        a((QQAppInterface)((WeakReference)paramMessage.get("key_app")).get(), (ajee)((WeakReference)paramMessage.get("key_adapter")).get(), (AbsListView)((WeakReference)paramMessage.get("key_listview")).get(), (String)localObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     astr
 * JD-Core Version:    0.7.0.1
 */