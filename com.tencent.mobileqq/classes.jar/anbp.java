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
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;
import tencent.im.msg.im_msg_body.RichText;

public class anbp
  implements Handler.Callback, atqq
{
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  Handler jdField_a_of_type_AndroidOsHandler;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  CustomEmotionData jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData;
  StructMsgForImageShare jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare;
  private WeakReference<anbt> jdField_a_of_type_JavaLangRefWeakReference;
  
  public anbp(QQAppInterface paramQQAppInterface, Context paramContext, CustomEmotionData paramCustomEmotionData, StructMsgForImageShare paramStructMsgForImageShare, int paramInt)
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
      paramQQAppInterface = new anbs(paramQQAppInterface, paramContext);
      if ((paramContext instanceof BaseActivity))
      {
        if (!((BaseActivity)paramContext).isFinishing())
        {
          paramQQAppInterface = babr.a(paramContext, 0, "温馨提示", paramContext.getString(2131624148), "取消", "立即开通", paramQQAppInterface, paramQQAppInterface);
          if (paramQQAppInterface != null) {
            paramQQAppInterface.show();
          }
        }
        arnz.c("2007", 1);
      }
    }
    while (paramInt != 2) {
      for (;;)
      {
        return;
        bbmy.a(paramContext, paramContext.getString(2131624149), 0).b(2131167766);
      }
    }
    bbmy.a(paramContext, paramContext.getString(2131624149), 0).b(2131167766);
    arnz.c("2007", 1);
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(anbt paramanbt)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramanbt);
  }
  
  public void a(atqr paramatqr) {}
  
  public void b(atqr paramatqr)
  {
    int i = paramatqr.jdField_a_of_type_Int;
    if (i == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("EmoAddedAuthCallback", 2, "add custom emotion result success");
      }
      if (this.jdField_a_of_type_Int == 0)
      {
        if ((!this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.isMarkFace) && (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.md5)))
        {
          paramatqr = MD5.getFileMd5(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.emoPath);
          this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.md5 = HexUtil.bytes2HexStr(paramatqr);
          paramatqr = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
          if (paramatqr != null)
          {
            paramatqr.a(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData);
            paramatqr.a();
          }
        }
        ((ancg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(149)).c(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData);
        if (this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare != null) {
          adwz.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare, this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData);
        }
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
        paramatqr = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
        if (paramatqr != null) {
          paramatqr.obtainMessage(10).sendToTarget();
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
                      ((ancg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(149)).c(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData);
                    } while ((2 != this.jdField_a_of_type_Int) || (this.jdField_a_of_type_JavaLangRefWeakReference == null));
                    paramatqr = (anbt)this.jdField_a_of_type_JavaLangRefWeakReference.get();
                  } while (paramatqr == null);
                  paramatqr.a(0, this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.md5);
                  return;
                } while (3 != this.jdField_a_of_type_Int);
                ((ancg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(149)).c(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData);
                this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
                return;
              } while (-1 != i);
              i = paramatqr.b;
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
          paramatqr = (anbt)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        } while (paramatqr == null);
        if (400010 == i)
        {
          paramatqr.a(2, this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.md5);
          return;
        }
        if (400011 == i)
        {
          paramatqr.a(3, this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.md5);
          return;
        }
        paramatqr.a(i, this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.md5);
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
      bbmy.a(this.jdField_a_of_type_AndroidContentContext, 2131624146, 0).b(2131167766);
      if ((this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData != null) && (this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.isMarkFace)) {
        aemi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).h();
      }
      if ((baig.F(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())) && ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) && (this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData != null) && (!this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.isMarkFace) && (this.jdField_a_of_type_Int == 0))
      {
        paramMessage = new Dialog(this.jdField_a_of_type_AndroidContentContext, 2131690181);
        paramMessage.setContentView(2131493454);
        Button localButton1 = (Button)paramMessage.findViewById(2131299543);
        Button localButton2 = (Button)paramMessage.findViewById(2131299547);
        localButton1.setOnClickListener(new anbq(this, paramMessage));
        localButton2.setOnClickListener(new anbr(this, paramMessage));
        if (!((Activity)this.jdField_a_of_type_AndroidContentContext).isFinishing())
        {
          baig.w(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), false);
          paramMessage.show();
        }
      }
    }
    arnz.c("0", 1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anbp
 * JD-Core Version:    0.7.0.1
 */