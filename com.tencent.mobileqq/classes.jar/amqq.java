import android.app.Activity;
import android.content.Context;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.ref.WeakReference;

public class amqq
  implements amql, Handler.Callback
{
  protected bkys a;
  WeakReference<Activity> a;
  private WeakReference<QQAppInterface> b;
  
  public amqq(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Bkys = new bkys(Looper.getMainLooper(), this);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    this.b = new WeakReference(paramQQAppInterface);
  }
  
  public int a()
  {
    return 100;
  }
  
  public amqr a(long paramLong, String paramString1, String paramString2)
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
      ankm.a(paramLong, localQQAppInterface, paramString1, paramString2);
      return new amqr();
    }
    if ("cs.report_data_2_compass.local".equals(paramString1))
    {
      ankm.a(localQQAppInterface, paramString2);
      return new amqr();
    }
    if ("cs.report_data_2_backstage.local".equals(paramString1))
    {
      ankm.b(localQQAppInterface, paramString2);
      return new amqr();
    }
    if ("cs.report_flow_data.local".equals(paramString1))
    {
      ankm.c(localQQAppInterface, paramString2);
      return new amqr();
    }
    if ("cs.encrypt_data.local".equals(paramString1))
    {
      ankm.a(paramLong, localQQAppInterface, paramString2);
      return new amqr();
    }
    if ("cs.decrypt_data.local".equals(paramString1))
    {
      ankm.b(paramLong, localQQAppInterface, paramString2);
      return new amqr();
    }
    if ("cs.get_server_ip_port.local".equals(paramString1))
    {
      ankm.b(paramLong, localQQAppInterface, paramString1, paramString2);
      return new amqr();
    }
    if ("cs.save_recommend_ip.local".equals(paramString1))
    {
      ankm.a(localQQAppInterface, paramString2);
      return new amqr();
    }
    if ("cs.apolloGameWebMessage.local".equals(paramString1))
    {
      ankm.a(paramString2);
      return new amqr();
    }
    if ("cs.openFloatTransparentView.local".equals(paramString1))
    {
      if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
      {
        ankm.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), paramString2);
        return new amqr();
      }
    }
    else if ("cs.openWebView.local".equals(paramString1))
    {
      if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
      {
        ankm.b((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), paramString2);
        return new amqr();
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
          if (localQQMessageFacade.isChatting())
          {
            paramString1 = str;
            i = j;
            if (!TextUtils.isEmpty(localQQMessageFacade.getCurrChatUin()))
            {
              paramString1 = localQQMessageFacade.getCurrChatUin();
              i = localQQMessageFacade.getCurrChatType();
            }
          }
        }
        return anck.a(paramString2, localQQAppInterface, i, paramString1);
      }
      if ("cs.script_get_action_data.local".equals(paramString1))
      {
        ApolloGameUtil.a(paramLong, localQQAppInterface, paramString2);
        return null;
      }
    }
    return null;
  }
  
  public amqr a(String paramString)
  {
    amqr localamqr = new amqr();
    String str = ApolloUtil.a(paramString, "tips");
    int i = ApolloUtil.a(paramString, "length");
    if (TextUtils.isEmpty(str)) {
      return localamqr;
    }
    paramString = this.jdField_a_of_type_Bkys.obtainMessage(255);
    paramString.obj = str;
    paramString.arg1 = i;
    paramString.sendToTarget();
    return localamqr;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bkys.removeCallbacksAndMessages(null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amqq
 * JD-Core Version:    0.7.0.1
 */