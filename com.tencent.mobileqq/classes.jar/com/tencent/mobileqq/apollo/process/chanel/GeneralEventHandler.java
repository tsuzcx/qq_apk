package com.tencent.mobileqq.apollo.process.chanel;

import android.app.Activity;
import android.content.Context;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.apollo.aioChannel.HandleResult;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.apollo.lightGame.CmGameTempSessionHandler;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.utils.ApolloGameBasicEventUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.lang.ref.WeakReference;

public class GeneralEventHandler
  implements Handler.Callback, CmGameCmdChannel.IRequestHandler
{
  private static long jdField_a_of_type_Long = 0L;
  private int jdField_a_of_type_Int;
  protected WeakReferenceHandler a;
  WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  private WeakReference<QQAppInterface> b;
  
  public GeneralEventHandler(Activity paramActivity, QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    this.b = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("apollochannel_GeneralEventHandler", 2, "startNewGame reqData:" + paramString);
    }
    long l = System.currentTimeMillis();
    if (l - jdField_a_of_type_Long < 1000L) {
      QLog.e("apollochannel_GeneralEventHandler", 1, "[startNewGame] current - sLastLaunchGameTime < 1000");
    }
    do
    {
      return;
      jdField_a_of_type_Long = l;
    } while (TextUtils.isEmpty(paramString));
    ThreadManagerV2.excute(new GeneralEventHandler.2(this, paramString), 16, null, false);
  }
  
  public int a()
  {
    return 100;
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
  
  public HandleResult a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (this.b == null) {
      return null;
    }
    if (this.jdField_a_of_type_Int != paramInt2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("apollochannel_GeneralEventHandler", 2, new Object[] { "not the same gameId, self:", Integer.valueOf(this.jdField_a_of_type_Int), "cmd gameId:", Integer.valueOf(paramInt2), ",cmd:", paramString1 });
      }
      return new HandleResult();
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
      ApolloGameBasicEventUtil.a(localQQAppInterface, paramString1, paramString2, paramInt1);
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
    if ("cs.save_recommend_ip.local".equals(paramString1))
    {
      ApolloGameBasicEventUtil.a(localQQAppInterface, paramString2);
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
        paramInt2 = -1;
        String str = "";
        paramString1 = str;
        paramInt1 = paramInt2;
        if (localQQMessageFacade != null)
        {
          paramString1 = str;
          paramInt1 = paramInt2;
          if (localQQMessageFacade.a())
          {
            paramString1 = str;
            paramInt1 = paramInt2;
            if (!TextUtils.isEmpty(localQQMessageFacade.a()))
            {
              paramString1 = localQQMessageFacade.a();
              paramInt1 = localQQMessageFacade.a();
            }
          }
        }
        return SpriteUtil.a(paramString2, localQQAppInterface, paramInt1, paramString1);
      }
      if (!"cs.send_game_msg.local".equals(paramString1)) {
        break label403;
      }
      ApolloGameBasicEventUtil.a(localQQAppInterface, paramString2, (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    }
    for (;;)
    {
      return null;
      label403:
      if ("cs.create_xy.local".equals(paramString1))
      {
        b(paramString2);
      }
      else if ("cs.open_cm_aio.local".equals(paramString1))
      {
        a(paramString2);
      }
      else if ("cs.show_one_more_page.local".equals(paramString1))
      {
        paramString1 = (ApolloManagerServiceImpl)localQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
        if (paramString1 != null) {
          paramString1.getGameTempMsgHandler().h(paramString2);
        }
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacksAndMessages(null);
  }
  
  void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("apollochannel_GeneralEventHandler", 2, "openCmAIO reqData:" + paramString);
    }
    if (!TextUtils.isEmpty(paramString)) {
      ThreadManagerV2.excute(new GeneralEventHandler.1(this, paramString), 16, null, false);
    }
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
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.GeneralEventHandler
 * JD-Core Version:    0.7.0.1
 */