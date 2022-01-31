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

public class ansf
  implements Handler.Callback, auoq
{
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  Handler jdField_a_of_type_AndroidOsHandler;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  CustomEmotionData jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData;
  StructMsgForImageShare jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare;
  private WeakReference<ansj> jdField_a_of_type_JavaLangRefWeakReference;
  
  public ansf(QQAppInterface paramQQAppInterface, Context paramContext, CustomEmotionData paramCustomEmotionData, StructMsgForImageShare paramStructMsgForImageShare, int paramInt)
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
      paramQQAppInterface = new ansi(paramQQAppInterface, paramContext);
      if ((paramContext instanceof BaseActivity))
      {
        if (!((BaseActivity)paramContext).isFinishing())
        {
          paramQQAppInterface = bbdj.a(paramContext, 0, "温馨提示", paramContext.getString(2131689688), "取消", "立即开通", paramQQAppInterface, paramQQAppInterface);
          if (paramQQAppInterface != null) {
            paramQQAppInterface.show();
          }
        }
        askf.c("2007", 1);
      }
    }
    while (paramInt != 2) {
      for (;;)
      {
        return;
        bcql.a(paramContext, paramContext.getString(2131689689), 0).b(2131298865);
      }
    }
    bcql.a(paramContext, paramContext.getString(2131689689), 0).b(2131298865);
    askf.c("2007", 1);
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(ansj paramansj)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramansj);
  }
  
  public void a(auor paramauor) {}
  
  public void b(auor paramauor)
  {
    int i = paramauor.jdField_a_of_type_Int;
    if (i == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("EmoAddedAuthCallback", 2, "add custom emotion result success");
      }
      if (this.jdField_a_of_type_Int == 0)
      {
        if ((!this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.isMarkFace) && (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.md5)))
        {
          paramauor = MD5.getFileMd5(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.emoPath);
          this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.md5 = HexUtil.bytes2HexStr(paramauor);
          paramauor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
          if (paramauor != null)
          {
            paramauor.a(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData);
            paramauor.a();
          }
        }
        ((answ)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(149)).c(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData);
        if (this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare != null) {
          aehw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare, this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData);
        }
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
        paramauor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
        if (paramauor != null) {
          paramauor.obtainMessage(10).sendToTarget();
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
                      ((answ)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(149)).c(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData);
                    } while ((2 != this.jdField_a_of_type_Int) || (this.jdField_a_of_type_JavaLangRefWeakReference == null));
                    paramauor = (ansj)this.jdField_a_of_type_JavaLangRefWeakReference.get();
                  } while (paramauor == null);
                  paramauor.a(0, this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.md5);
                  return;
                } while (3 != this.jdField_a_of_type_Int);
                ((answ)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(149)).c(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData);
                this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
                return;
              } while (-1 != i);
              i = paramauor.b;
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
          paramauor = (ansj)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        } while (paramauor == null);
        if (400010 == i)
        {
          paramauor.a(2, this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.md5);
          return;
        }
        if (400011 == i)
        {
          paramauor.a(3, this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.md5);
          return;
        }
        paramauor.a(i, this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.md5);
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
      bcql.a(this.jdField_a_of_type_AndroidContentContext, 2131689686, 0).b(2131298865);
      if ((this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData != null) && (this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.isMarkFace)) {
        aexb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).h();
      }
      if ((bbkb.F(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())) && ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) && (this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData != null) && (!this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.isMarkFace) && (this.jdField_a_of_type_Int == 0))
      {
        paramMessage = new Dialog(this.jdField_a_of_type_AndroidContentContext, 2131755791);
        paramMessage.setContentView(2131559017);
        Button localButton1 = (Button)paramMessage.findViewById(2131365110);
        Button localButton2 = (Button)paramMessage.findViewById(2131365114);
        localButton1.setOnClickListener(new ansg(this, paramMessage));
        localButton2.setOnClickListener(new ansh(this, paramMessage));
        if (!((Activity)this.jdField_a_of_type_AndroidContentContext).isFinishing())
        {
          bbkb.w(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), false);
          paramMessage.show();
        }
      }
    }
    askf.c("0", 1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ansf
 * JD-Core Version:    0.7.0.1
 */