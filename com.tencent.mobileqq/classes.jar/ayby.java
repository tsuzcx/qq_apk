import android.app.Notification;
import android.app.PendingIntent;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.notification.modularize.OnlineModulePushReceiver.onPushReceived.1;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tencent.im.s2c.msgtype0x210.submsgtype0x135.ModulePushPb.Content;
import tencent.im.s2c.msgtype0x210.submsgtype0x135.ModulePushPb.Forward;
import tencent.im.s2c.msgtype0x210.submsgtype0x135.ModulePushPb.Image;
import tencent.im.s2c.msgtype0x210.submsgtype0x135.ModulePushPb.MsgBody;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/notification/modularize/OnlineModulePushReceiver;", "", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "(Lcom/tencent/mobileqq/app/QQAppInterface;)V", "convertPacket", "Lcom/tencent/mobileqq/notification/modularize/PushComponent;", "msgBody", "Ltencent/im/s2c/msgtype0x210/submsgtype0x135/ModulePushPb$MsgBody;", "createSystemNotification", "", "pushComponent", "notification", "Landroid/app/Notification;", "handleMsgBytes", "vProtobuf", "", "onPushReceived", "revokePush", "sendPush", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ayby
{
  private final QQAppInterface a;
  
  public ayby(@NotNull QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  private final void a(ayca paramayca, Notification paramNotification)
  {
    QQNotificationManager.getInstance().notify("OnlineModulePushReceiver", paramayca.jdField_d_of_type_Int, paramNotification);
    this.a.t();
    ((Map)aybz.a()).put(Integer.valueOf(paramayca.jdField_d_of_type_Int), Integer.valueOf(paramayca.jdField_a_of_type_Int));
    bcst.b(null, "dc00898", "", "", "0X800AE73", "0X800AE73", paramayca.jdField_a_of_type_Int, 0, String.valueOf(paramayca.jdField_b_of_type_Int), String.valueOf(paramayca.jdField_c_of_type_Int), "", "");
  }
  
  private final void b(ayca paramayca)
  {
    Object localObject = aycg.a.a(paramayca).b(paramayca);
    localObject = aybx.a.a((PendingIntent)localObject, paramayca);
    boolean bool = aybz.a(this.a);
    if (aybz.b(this.a)) {
      if (QLog.isColorLevel()) {
        QLog.d("OnlineModulePushReceiver", 2, "sendPush: called. push need shield");
      }
    }
    do
    {
      return;
      if ((paramayca.jdField_d_of_type_Boolean) && (paramayca.jdField_c_of_type_Boolean))
      {
        a(paramayca, (Notification)localObject);
        return;
      }
      if ((paramayca.jdField_d_of_type_Boolean) && (bool))
      {
        a(paramayca, (Notification)localObject);
        return;
      }
      if ((paramayca.jdField_c_of_type_Boolean) && (!bool))
      {
        a(paramayca, (Notification)localObject);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("OnlineModulePushReceiver", 2, new Object[] { "sendPush: called. ", "no need send push. isBackground: " + bool });
  }
  
  private final void c(ayca paramayca)
  {
    QQNotificationManager.getInstance().cancel("OnlineModulePushReceiver", paramayca.jdField_d_of_type_Int);
  }
  
  @NotNull
  public final ayca a(@NotNull ModulePushPb.MsgBody paramMsgBody)
  {
    boolean bool2 = false;
    Intrinsics.checkParameterIsNotNull(paramMsgBody, "msgBody");
    ayca localayca = new ayca();
    String str = paramMsgBody.msg_content.str_title.get();
    Intrinsics.checkExpressionValueIsNotNull(str, "msgBody.msg_content.str_title.get()");
    localayca.jdField_a_of_type_JavaLangString = str;
    str = paramMsgBody.msg_content.msg_image.str_url.get();
    Intrinsics.checkExpressionValueIsNotNull(str, "msgBody.msg_content.msg_image.str_url.get()");
    localayca.jdField_b_of_type_JavaLangString = str;
    str = paramMsgBody.msg_content.str_desc.get();
    Intrinsics.checkExpressionValueIsNotNull(str, "msgBody.msg_content.str_desc.get()");
    localayca.jdField_c_of_type_JavaLangString = str;
    str = paramMsgBody.msg_content.msg_forward.str_url.get();
    Intrinsics.checkExpressionValueIsNotNull(str, "msgBody.msg_content.msg_forward.str_url.get()");
    localayca.jdField_d_of_type_JavaLangString = str;
    label213:
    int i;
    if (paramMsgBody.msg_content.msg_forward.uint32_type.get() == 0)
    {
      bool1 = true;
      localayca.jdField_a_of_type_Boolean = bool1;
      localayca.jdField_a_of_type_Int = paramMsgBody.int32_service_id.get();
      localayca.jdField_b_of_type_Int = paramMsgBody.int32_sub_service_id.get();
      localayca.jdField_d_of_type_Int = paramMsgBody.int32_notify_id.get();
      localayca.jdField_c_of_type_Int = paramMsgBody.int32_push_id.get();
      if (paramMsgBody.int32_recall_flag.get() != 1) {
        break label300;
      }
      bool1 = true;
      localayca.jdField_b_of_type_Boolean = bool1;
      i = paramMsgBody.int32_type.get();
      if ((i != 1) && (i != 2)) {
        break label305;
      }
    }
    label300:
    label305:
    for (boolean bool1 = true;; bool1 = false)
    {
      localayca.jdField_c_of_type_Boolean = bool1;
      if (i != 0)
      {
        bool1 = bool2;
        if (i != 2) {}
      }
      else
      {
        bool1 = true;
      }
      localayca.jdField_d_of_type_Boolean = bool1;
      paramMsgBody = paramMsgBody.msg_content.bytes_ext_data.get().toByteArray();
      Intrinsics.checkExpressionValueIsNotNull(paramMsgBody, "msgBody.msg_content.byte…_data.get().toByteArray()");
      localayca.jdField_a_of_type_ArrayOfByte = paramMsgBody;
      return localayca;
      bool1 = false;
      break;
      bool1 = false;
      break label213;
    }
  }
  
  public final void a(@NotNull ayca paramayca)
  {
    Intrinsics.checkParameterIsNotNull(paramayca, "pushComponent");
    if (QLog.isColorLevel()) {
      QLog.d("OnlineModulePushReceiver", 2, new Object[] { "onPushReceived: called. ", "pushComponent: " + paramayca });
    }
    if (!paramayca.a())
    {
      QLog.d("OnlineModulePushReceiver", 1, new Object[] { "onPushReceived: called. ", "invalid notify id. pushComponent: " + paramayca });
      return;
    }
    if (paramayca.jdField_b_of_type_Boolean)
    {
      c(paramayca);
      return;
    }
    aybz.a((Function0)new OnlineModulePushReceiver.onPushReceived.1(this, paramayca));
  }
  
  public final void a(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "vProtobuf");
    ModulePushPb.MsgBody localMsgBody = new ModulePushPb.MsgBody();
    try
    {
      localMsgBody.mergeFrom(paramArrayOfByte);
      a(a(localMsgBody));
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("OnlineModulePushReceiver", 2, "handleMsgBytes: failed. ", (Throwable)paramArrayOfByte);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayby
 * JD-Core Version:    0.7.0.1
 */