import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Button;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emosm.favroaming.EmoAddedAuthCallback.4;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;
import tencent.im.msg.im_msg_body.RichText;

public class apnw
  implements Handler.Callback, awkh
{
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  Handler jdField_a_of_type_AndroidOsHandler;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  CustomEmotionData jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData;
  StructMsgForImageShare jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare;
  private WeakReference<apoa> jdField_a_of_type_JavaLangRefWeakReference;
  
  public apnw(QQAppInterface paramQQAppInterface, Context paramContext, CustomEmotionData paramCustomEmotionData, StructMsgForImageShare paramStructMsgForImageShare, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData = paramCustomEmotionData;
    this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare = paramStructMsgForImageShare;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt)
  {
    if (paramInt == 1)
    {
      paramQQAppInterface = new apnz(paramQQAppInterface, paramContext);
      if ((paramContext instanceof BaseActivity))
      {
        if (!((BaseActivity)paramContext).isFinishing())
        {
          paramQQAppInterface = bdgm.a(paramContext, 0, "温馨提示", paramContext.getString(2131689689), "取消", "立即开通", paramQQAppInterface, paramQQAppInterface);
          if (paramQQAppInterface != null) {
            paramQQAppInterface.show();
          }
        }
        aufn.c("2007", 1);
      }
    }
    while (paramInt != 2) {
      for (;;)
      {
        return;
        QQToast.a(paramContext, paramContext.getString(2131689690), 0).b(2131298914);
      }
    }
    QQToast.a(paramContext, paramContext.getString(2131689690), 0).b(2131298914);
    aufn.c("2007", 1);
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(apoa paramapoa)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramapoa);
  }
  
  public void a(awki paramawki) {}
  
  public void b(awki paramawki)
  {
    int i = paramawki.jdField_a_of_type_Int;
    if (i == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("EmoAddedAuthCallback", 2, "add custom emotion result success");
      }
      if (this.jdField_a_of_type_Int == 0)
      {
        if ((!this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.isMarkFace) && (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.md5)))
        {
          paramawki = MD5.getFileMd5(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.emoPath);
          this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.md5 = HexUtil.bytes2HexStr(paramawki);
          paramawki = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
          if (paramawki != null)
          {
            paramawki.a(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData);
            paramawki.a();
          }
        }
        ((apon)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(149)).c(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData);
        if (this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare != null) {
          agjb.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare, this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData);
        }
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
        paramawki = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
        if (paramawki != null) {
          paramawki.obtainMessage(10).sendToTarget();
        }
      }
    }
    label177:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      break label177;
                      break label177;
                      break label177;
                      break label177;
                      break label177;
                      break label177;
                      break label177;
                      do
                      {
                        return;
                      } while (1 == this.jdField_a_of_type_Int);
                      if (2 != this.jdField_a_of_type_Int) {
                        break;
                      }
                      ((apon)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(149)).c(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData);
                    } while ((2 != this.jdField_a_of_type_Int) || (this.jdField_a_of_type_JavaLangRefWeakReference == null));
                    paramawki = (apoa)this.jdField_a_of_type_JavaLangRefWeakReference.get();
                  } while (paramawki == null);
                  paramawki.a(0, this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.md5);
                  return;
                } while (3 != this.jdField_a_of_type_Int);
                ((apon)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(149)).c(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData);
                this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
                return;
              } while (-1 != i);
              i = paramawki.b;
              if ((400010 == i) || (400011 == i)) {
                ThreadManager.getFileThreadHandler().post(new EmoAddedAuthCallback.4(this));
              }
              if (QLog.isColorLevel()) {
                QLog.e("EmoAddedAuthCallback", 2, "add custom emotion result errCode=" + i);
              }
              if (this.jdField_a_of_type_Int != 0) {
                break;
              }
              if (400010 == i)
              {
                this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
                return;
              }
            } while (400011 != i);
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
            return;
            if (2 != this.jdField_a_of_type_Int) {
              break;
            }
          } while (this.jdField_a_of_type_JavaLangRefWeakReference == null);
          paramawki = (apoa)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        } while (paramawki == null);
        if (400010 == i)
        {
          paramawki.a(2, this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.md5);
          return;
        }
        if (400011 == i)
        {
          paramawki.a(3, this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.md5);
          return;
        }
        paramawki.a(i, this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.md5);
        return;
      } while (3 != this.jdField_a_of_type_Int);
      if (400010 == i)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
        return;
      }
    } while (400011 != i);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 1: 
    case 2: 
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramMessage.what);
      return true;
    }
    if (this.jdField_a_of_type_AndroidContentContext != null)
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131689687, 0).b(2131298914);
      if ((this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData != null) && (this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.isMarkFace)) {
        agyv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).h();
      }
      if ((bdne.G(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())) && ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) && (this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData != null) && (!this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.isMarkFace) && (this.jdField_a_of_type_Int == 0))
      {
        paramMessage = new Dialog(this.jdField_a_of_type_AndroidContentContext, 2131755801);
        paramMessage.setContentView(2131559055);
        Button localButton1 = (Button)paramMessage.findViewById(2131365197);
        Button localButton2 = (Button)paramMessage.findViewById(2131365201);
        localButton1.setOnClickListener(new apnx(this, paramMessage));
        localButton2.setOnClickListener(new apny(this, paramMessage));
        if (!((Activity)this.jdField_a_of_type_AndroidContentContext).isFinishing())
        {
          bdne.x(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), false);
          paramMessage.show();
        }
      }
    }
    aufn.c("0", 1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apnw
 * JD-Core Version:    0.7.0.1
 */