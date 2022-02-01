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
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.emosm.favroaming.EmoAddedAuthCallback.4;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;
import tencent.im.msg.im_msg_body.RichText;

public class arqx
  implements Handler.Callback, ayyt
{
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  Handler jdField_a_of_type_AndroidOsHandler;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  CustomEmotionData jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData;
  StructMsgForImageShare jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare;
  private WeakReference<arrb> jdField_a_of_type_JavaLangRefWeakReference;
  
  public arqx(QQAppInterface paramQQAppInterface, Context paramContext, CustomEmotionData paramCustomEmotionData, StructMsgForImageShare paramStructMsgForImageShare, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData = paramCustomEmotionData;
    this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare = paramStructMsgForImageShare;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt)
  {
    if (paramInt == 1)
    {
      paramQQAppInterface = new arra(paramQQAppInterface, paramContext);
      if ((paramContext instanceof BaseActivity))
      {
        if (!((BaseActivity)paramContext).isFinishing())
        {
          paramQQAppInterface = bglp.a(paramContext, 0, "温馨提示", paramContext.getString(2131689607), "取消", "立即开通", paramQQAppInterface, paramQQAppInterface);
          if (paramQQAppInterface != null) {
            paramQQAppInterface.show();
          }
        }
        awmr.c("2007", 1);
      }
    }
    while (paramInt != 2) {
      for (;;)
      {
        return;
        QQToast.a(paramContext, paramContext.getString(2131689608), 0).b(2131298998);
      }
    }
    QQToast.a(paramContext, paramContext.getString(2131689608), 0).b(2131298998);
    awmr.c("2007", 1);
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  protected void a()
  {
    ReportDialog localReportDialog = new ReportDialog(this.jdField_a_of_type_AndroidContentContext, 2131755823);
    localReportDialog.setContentView(2131559122);
    Button localButton1 = (Button)localReportDialog.findViewById(2131365439);
    Button localButton2 = (Button)localReportDialog.findViewById(2131365443);
    localButton1.setOnClickListener(new arqy(this, localReportDialog));
    localButton2.setOnClickListener(new arqz(this, localReportDialog));
    if (!((Activity)this.jdField_a_of_type_AndroidContentContext).isFinishing())
    {
      bgsg.x(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), false);
      localReportDialog.show();
    }
  }
  
  protected void a(int paramInt)
  {
    if (400010 == paramInt) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    }
    while (400011 != paramInt) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
  }
  
  public void a(arrb paramarrb)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramarrb);
  }
  
  public void a(ayyu paramayyu) {}
  
  protected void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt)
  {
    b(paramQQAppInterface, paramContext, paramInt);
  }
  
  protected void b()
  {
    if (QLog.isColorLevel()) {
      QLog.e("EmoAddedAuthCallback", 2, "add custom emotion result success");
    }
    Object localObject;
    if (this.jdField_a_of_type_Int == 0)
    {
      if ((!this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.isMarkFace) && (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.md5)))
      {
        localObject = MD5.getFileMd5(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.emoPath);
        this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.md5 = HexUtil.bytes2HexStr((byte[])localObject);
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
        if (localObject != null)
        {
          ((EntityManager)localObject).update(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData);
          ((EntityManager)localObject).close();
        }
      }
      ((arro)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(149)).c(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData);
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare != null) {
        ahth.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare, this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData);
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
      if (localObject != null) {
        ((MqqHandler)localObject).obtainMessage(10).sendToTarget();
      }
    }
    label168:
    do
    {
      do
      {
        do
        {
          break label168;
          do
          {
            return;
          } while (1 == this.jdField_a_of_type_Int);
          if (2 != this.jdField_a_of_type_Int) {
            break;
          }
          ((arro)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(149)).c(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData);
        } while ((2 != this.jdField_a_of_type_Int) || (this.jdField_a_of_type_JavaLangRefWeakReference == null));
        localObject = (arrb)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      } while (localObject == null);
      ((arrb)localObject).a(0, this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.md5);
      return;
    } while (3 != this.jdField_a_of_type_Int);
    ((arro)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(149)).c(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
  }
  
  protected void b(int paramInt)
  {
    arrb localarrb;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      localarrb = (arrb)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localarrb != null)
      {
        if (400010 != paramInt) {
          break label43;
        }
        localarrb.a(2, this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.md5);
      }
    }
    return;
    label43:
    if (400011 == paramInt)
    {
      localarrb.a(3, this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.md5);
      return;
    }
    localarrb.a(paramInt, this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.md5);
  }
  
  public void b(ayyu paramayyu)
  {
    int i = paramayyu.jdField_a_of_type_Int;
    if (i == 0) {
      b();
    }
    do
    {
      do
      {
        return;
      } while (-1 != i);
      i = paramayyu.b;
      c(i);
      if (QLog.isColorLevel()) {
        QLog.e("EmoAddedAuthCallback", 2, "add custom emotion result errCode=" + i);
      }
      if (this.jdField_a_of_type_Int == 0)
      {
        a(i);
        return;
      }
      if (2 == this.jdField_a_of_type_Int)
      {
        b(i);
        return;
      }
    } while (3 != this.jdField_a_of_type_Int);
    a(i);
  }
  
  protected void c(int paramInt)
  {
    if ((400010 == paramInt) || (400011 == paramInt)) {
      ThreadManager.getFileThreadHandler().post(new EmoAddedAuthCallback.4(this));
    }
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
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2, 2131689605, 0).b(2131298998);
      if ((this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData != null) && (this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.isMarkFace)) {
        aijp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).h();
      }
      if ((bgsg.G(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())) && ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) && (this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData != null) && (!this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.isMarkFace) && (this.jdField_a_of_type_Int == 0)) {
        a();
      }
    }
    awmr.c("0", 1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arqx
 * JD-Core Version:    0.7.0.1
 */