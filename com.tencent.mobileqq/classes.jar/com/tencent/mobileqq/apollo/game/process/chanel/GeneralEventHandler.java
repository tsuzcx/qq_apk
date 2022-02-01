package com.tencent.mobileqq.apollo.game.process.chanel;

import android.app.Activity;
import android.content.Context;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.apollo.channel.HandleResult;
import com.tencent.mobileqq.apollo.game.utils.ApolloGameBasicEventUtil;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.lang.ref.WeakReference;

public class GeneralEventHandler
  implements Handler.Callback, CmGameCmdChannel.IRequestHandler
{
  protected WeakReferenceHandler a = new WeakReferenceHandler(Looper.getMainLooper(), this);
  WeakReference<Activity> b;
  private WeakReference<QQAppInterface> c;
  private int d;
  
  public GeneralEventHandler(Activity paramActivity, QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.b = new WeakReference(paramActivity);
    this.c = new WeakReference(paramQQAppInterface);
    this.d = paramInt;
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
    paramString = this.a.obtainMessage(255);
    paramString.obj = str;
    paramString.arg1 = i;
    paramString.sendToTarget();
    return localHandleResult;
  }
  
  public HandleResult a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    Object localObject = this.c;
    if (localObject == null) {
      return null;
    }
    if (this.d != paramInt2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("apollochannel_GeneralEventHandler", 2, new Object[] { "not the same gameId, self:", Integer.valueOf(this.d), "cmd gameId:", Integer.valueOf(paramInt2), ",cmd:", paramString1 });
      }
      return new HandleResult();
    }
    localObject = (QQAppInterface)((WeakReference)localObject).get();
    if (localObject == null) {
      return null;
    }
    if ("general_cmd_ui_show_toast".equals(paramString1)) {
      return a(paramString2);
    }
    if ("cs.get_dress_path.local".equals(paramString1))
    {
      ApolloGameBasicEventUtil.a((QQAppInterface)localObject, paramString1, paramString2, paramInt1);
      return new HandleResult();
    }
    if ("cs.report_data_2_backstage.local".equals(paramString1))
    {
      ApolloGameBasicEventUtil.b((QQAppInterface)localObject, paramString2);
      return new HandleResult();
    }
    if ("cs.report_flow_data.local".equals(paramString1)) {
      return new HandleResult();
    }
    if ("cs.save_recommend_ip.local".equals(paramString1))
    {
      ApolloGameBasicEventUtil.a((QQAppInterface)localObject, paramString2);
      return new HandleResult();
    }
    if ("cs.openFloatTransparentView.local".equals(paramString1))
    {
      if (this.b.get() != null)
      {
        ApolloGameBasicEventUtil.a((Context)this.b.get(), paramString2);
        return new HandleResult();
      }
    }
    else if ("cs.openWebView.local".equals(paramString1))
    {
      if (this.b.get() != null)
      {
        ApolloGameBasicEventUtil.b((Context)this.b.get(), paramString2);
        return new HandleResult();
      }
    }
    else if ("cs.script_get_nickname.local".equals(paramString1))
    {
      QQMessageFacade localQQMessageFacade = ((QQAppInterface)localObject).getMessageFacade();
      if ((localQQMessageFacade != null) && (localQQMessageFacade.n()) && (!TextUtils.isEmpty(localQQMessageFacade.l())))
      {
        paramString1 = localQQMessageFacade.l();
        paramInt1 = localQQMessageFacade.m();
      }
      else
      {
        paramString1 = "";
        paramInt1 = -1;
      }
      return SpriteUtil.a(paramString2, (QQAppInterface)localObject, paramInt1, paramString1);
    }
    return null;
  }
  
  public void b()
  {
    this.a.removeCallbacksAndMessages(null);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 255) {
      return false;
    }
    if ((paramMessage.obj instanceof String))
    {
      BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
      CharSequence localCharSequence = (CharSequence)paramMessage.obj;
      int j = paramMessage.arg1;
      int i = 1;
      if (j != 1) {
        i = 0;
      }
      QQToast.makeText(localBaseApplication, localCharSequence, i).show();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.chanel.GeneralEventHandler
 * JD-Core Version:    0.7.0.1
 */