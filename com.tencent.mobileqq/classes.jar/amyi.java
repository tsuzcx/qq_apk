import android.app.Activity;
import android.content.Context;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.apollo.process.chanel.GeneralEventHandler.1;
import com.tencent.mobileqq.apollo.process.chanel.GeneralEventHandler.2;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class amyi
  implements amxt, Handler.Callback
{
  private static long jdField_a_of_type_Long;
  private int jdField_a_of_type_Int;
  protected bkys a;
  public WeakReference<Activity> a;
  private WeakReference<QQAppInterface> b;
  
  public amyi(Activity paramActivity, QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.jdField_a_of_type_Bkys = new bkys(Looper.getMainLooper(), this);
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
  
  public amqr a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (this.b == null) {
      return null;
    }
    if (this.jdField_a_of_type_Int != paramInt2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("apollochannel_GeneralEventHandler", 2, new Object[] { "not the same gameId, self:", Integer.valueOf(this.jdField_a_of_type_Int), "cmd gameId:", Integer.valueOf(paramInt2), ",cmd:", paramString1 });
      }
      return new amqr();
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
      ankm.a(localQQAppInterface, paramString1, paramString2, paramInt1);
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
    if ("cs.save_recommend_ip.local".equals(paramString1))
    {
      ankm.a(localQQAppInterface, paramString2);
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
        paramInt2 = -1;
        String str = "";
        paramString1 = str;
        paramInt1 = paramInt2;
        if (localQQMessageFacade != null)
        {
          paramString1 = str;
          paramInt1 = paramInt2;
          if (localQQMessageFacade.isChatting())
          {
            paramString1 = str;
            paramInt1 = paramInt2;
            if (!TextUtils.isEmpty(localQQMessageFacade.getCurrChatUin()))
            {
              paramString1 = localQQMessageFacade.getCurrChatUin();
              paramInt1 = localQQMessageFacade.getCurrChatType();
            }
          }
        }
        return anck.a(paramString2, localQQAppInterface, paramInt1, paramString1);
      }
      if (!"cs.send_game_msg.local".equals(paramString1)) {
        break label403;
      }
      ankm.a(localQQAppInterface, paramString2, (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get());
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
        paramString1 = (amme)localQQAppInterface.getManager(QQManagerFactory.APOLLO_MANAGER);
        if (paramString1 != null) {
          paramString1.a().h(paramString2);
        }
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bkys.removeCallbacksAndMessages(null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amyi
 * JD-Core Version:    0.7.0.1
 */