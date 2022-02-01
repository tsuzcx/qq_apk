package com.tencent.mobileqq.apollo.aioChannel;

import android.app.Activity;
import android.content.Context;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.apollo.api.channel.IRequestHandler;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.utils.ApolloGameBasicEventUtil;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.WeakReferenceHandler;
import java.lang.ref.WeakReference;

public class GeneralEventHandler
  implements Handler.Callback, IRequestHandler
{
  protected WeakReferenceHandler a;
  WeakReference<Activity> a;
  private WeakReference<QQAppInterface> b;
  
  public GeneralEventHandler(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    this.b = new WeakReference(paramQQAppInterface);
  }
  
  public int a()
  {
    return 100;
  }
  
  public HandleResult a(long paramLong, String paramString1, String paramString2)
  {
    if (this.b == null) {
      return null;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.b.get();
    if (localQQAppInterface == null) {
      return null;
    }
    if ("general_cmd_ui_show_toast".equals(paramString1)) {
      return a(paramString2);
    }
    if ("cs.get_dress_path.local".equals(paramString1))
    {
      ApolloGameBasicEventUtil.a(paramLong, localQQAppInterface, paramString1, paramString2);
      return new HandleResult();
    }
    if ("cs.report_data_2_compass.local".equals(paramString1))
    {
      ApolloGameBasicEventUtil.a(localQQAppInterface, paramString2);
      return new HandleResult();
    }
    if ("cs.report_data_2_backstage.local".equals(paramString1))
    {
      ApolloGameBasicEventUtil.b(localQQAppInterface, paramString2);
      return new HandleResult();
    }
    if ("cs.report_flow_data.local".equals(paramString1))
    {
      ApolloGameBasicEventUtil.c(localQQAppInterface, paramString2);
      return new HandleResult();
    }
    if ("cs.encrypt_data.local".equals(paramString1))
    {
      ApolloGameBasicEventUtil.a(paramLong, localQQAppInterface, paramString2);
      return new HandleResult();
    }
    if ("cs.decrypt_data.local".equals(paramString1))
    {
      ApolloGameBasicEventUtil.b(paramLong, localQQAppInterface, paramString2);
      return new HandleResult();
    }
    if ("cs.get_server_ip_port.local".equals(paramString1))
    {
      ApolloGameBasicEventUtil.b(paramLong, localQQAppInterface, paramString1, paramString2);
      return new HandleResult();
    }
    if ("cs.save_recommend_ip.local".equals(paramString1))
    {
      ApolloGameBasicEventUtil.a(localQQAppInterface, paramString2);
      return new HandleResult();
    }
    if ("cs.apolloGameWebMessage.local".equals(paramString1))
    {
      ApolloGameBasicEventUtil.a(paramString2);
      return new HandleResult();
    }
    if ("cs.openFloatTransparentView.local".equals(paramString1))
    {
      if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
      {
        ApolloGameBasicEventUtil.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), paramString2);
        return new HandleResult();
      }
    }
    else if ("cs.openWebView.local".equals(paramString1))
    {
      if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
      {
        ApolloGameBasicEventUtil.b((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), paramString2);
        return new HandleResult();
      }
    }
    else
    {
      if ("cs.script_get_nickname.local".equals(paramString1))
      {
        QQMessageFacade localQQMessageFacade = localQQAppInterface.getMessageFacade();
        int j = -1;
        String str = "";
        paramString1 = str;
        int i = j;
        if (localQQMessageFacade != null)
        {
          paramString1 = str;
          i = j;
          if (localQQMessageFacade.a())
          {
            paramString1 = str;
            i = j;
            if (!TextUtils.isEmpty(localQQMessageFacade.a()))
            {
              paramString1 = localQQMessageFacade.a();
              i = localQQMessageFacade.a();
            }
          }
        }
        return SpriteUtil.a(paramString2, localQQAppInterface, i, paramString1);
      }
      if ("cs.script_get_action_data.local".equals(paramString1))
      {
        ApolloGameUtil.a(paramLong, localQQAppInterface, paramString2);
        return null;
      }
    }
    return null;
  }
  
  public HandleResult a(String paramString)
  {
    HandleResult localHandleResult = new HandleResult();
    String str = ApolloUtilImpl.getJsonStrValue(paramString, "tips");
    int i = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getJsonIntValue(paramString, "length");
    if (TextUtils.isEmpty(str)) {
      return localHandleResult;
    }
    paramString = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(255);
    paramString.obj = str;
    paramString.arg1 = i;
    paramString.sendToTarget();
    return localHandleResult;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacksAndMessages(null);
  }
  
  public boolean a(Activity paramActivity)
  {
    return true;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = 1;
    switch (paramMessage.what)
    {
    }
    do
    {
      return false;
    } while (!(paramMessage.obj instanceof String));
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    CharSequence localCharSequence = (CharSequence)paramMessage.obj;
    if (paramMessage.arg1 == 1) {}
    for (;;)
    {
      QQToast.a(localBaseApplication, localCharSequence, i).a();
      return false;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aioChannel.GeneralEventHandler
 * JD-Core Version:    0.7.0.1
 */