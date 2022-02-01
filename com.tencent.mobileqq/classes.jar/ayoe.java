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
public final class ayoe
{
  private final QQAppInterface a;
  
  public ayoe(@NotNull QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  private final void a(ayog paramayog, Notification paramNotification)
  {
    QQNotificationManager.getInstance().notify("OnlineModulePushReceiver", paramayog.jdField_d_of_type_Int, paramNotification);
    this.a.vibratorAndAudio();
    ((Map)ayof.a()).put(Integer.valueOf(paramayog.jdField_d_of_type_Int), Integer.valueOf(paramayog.jdField_a_of_type_Int));
    bdla.b(null, "dc00898", "", "", "0X800AE73", "0X800AE73", paramayog.jdField_a_of_type_Int, 0, String.valueOf(paramayog.jdField_b_of_type_Int), String.valueOf(paramayog.jdField_c_of_type_Int), "", "");
    paramNotification = ayoh.a;
    String str = this.a.getCurrentUin();
    Intrinsics.checkExpressionValueIsNotNull(str, "app.currentUin");
    paramNotification.a(str, 117, String.valueOf(paramayog.jdField_c_of_type_Int));
  }
  
  private final void b(ayog paramayog)
  {
    Object localObject = ayom.a.a(paramayog).b(paramayog);
    localObject = ayod.a.a((PendingIntent)localObject, paramayog);
    boolean bool = ayof.a(this.a);
    if (ayof.b(this.a)) {
      if (QLog.isColorLevel()) {
        QLog.d("OnlineModulePushReceiver", 2, "sendPush: called. push need shield");
      }
    }
    do
    {
      return;
      if ((paramayog.jdField_d_of_type_Boolean) && (paramayog.jdField_c_of_type_Boolean))
      {
        a(paramayog, (Notification)localObject);
        return;
      }
      if ((paramayog.jdField_d_of_type_Boolean) && (bool))
      {
        a(paramayog, (Notification)localObject);
        return;
      }
      if ((paramayog.jdField_c_of_type_Boolean) && (!bool))
      {
        a(paramayog, (Notification)localObject);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("OnlineModulePushReceiver", 2, new Object[] { "sendPush: called. ", "no need send push. isBackground: " + bool });
  }
  
  private final void c(ayog paramayog)
  {
    QQNotificationManager.getInstance().cancel("OnlineModulePushReceiver", paramayog.jdField_d_of_type_Int);
  }
  
  @NotNull
  public final ayog a(@NotNull ModulePushPb.MsgBody paramMsgBody)
  {
    boolean bool2 = false;
    Intrinsics.checkParameterIsNotNull(paramMsgBody, "msgBody");
    ayog localayog = new ayog();
    String str = paramMsgBody.msg_content.str_title.get();
    Intrinsics.checkExpressionValueIsNotNull(str, "msgBody.msg_content.str_title.get()");
    localayog.jdField_a_of_type_JavaLangString = str;
    str = paramMsgBody.msg_content.msg_image.str_url.get();
    Intrinsics.checkExpressionValueIsNotNull(str, "msgBody.msg_content.msg_image.str_url.get()");
    localayog.jdField_b_of_type_JavaLangString = str;
    str = paramMsgBody.msg_content.str_desc.get();
    Intrinsics.checkExpressionValueIsNotNull(str, "msgBody.msg_content.str_desc.get()");
    localayog.jdField_c_of_type_JavaLangString = str;
    str = paramMsgBody.msg_content.msg_forward.str_url.get();
    Intrinsics.checkExpressionValueIsNotNull(str, "msgBody.msg_content.msg_forward.str_url.get()");
    localayog.jdField_d_of_type_JavaLangString = str;
    label214:
    int i;
    if (paramMsgBody.msg_content.msg_forward.uint32_type.get() == 0)
    {
      bool1 = true;
      localayog.jdField_a_of_type_Boolean = bool1;
      localayog.jdField_a_of_type_Int = paramMsgBody.int32_service_id.get();
      localayog.jdField_b_of_type_Int = paramMsgBody.int32_sub_service_id.get();
      localayog.jdField_d_of_type_Int = paramMsgBody.int32_notify_id.get();
      localayog.jdField_c_of_type_Int = paramMsgBody.int32_push_id.get();
      if (paramMsgBody.int32_recall_flag.get() != 1) {
        break label301;
      }
      bool1 = true;
      localayog.jdField_b_of_type_Boolean = bool1;
      i = paramMsgBody.int32_type.get();
      if ((i != 1) && (i != 2)) {
        break label306;
      }
    }
    label301:
    label306:
    for (boolean bool1 = true;; bool1 = false)
    {
      localayog.jdField_c_of_type_Boolean = bool1;
      if (i != 0)
      {
        bool1 = bool2;
        if (i != 2) {}
      }
      else
      {
        bool1 = true;
      }
      localayog.jdField_d_of_type_Boolean = bool1;
      paramMsgBody = paramMsgBody.msg_content.bytes_ext_data.get().toByteArray();
      Intrinsics.checkExpressionValueIsNotNull(paramMsgBody, "msgBody.msg_content.byte…_data.get().toByteArray()");
      localayog.jdField_a_of_type_ArrayOfByte = paramMsgBody;
      return localayog;
      bool1 = false;
      break;
      bool1 = false;
      break label214;
    }
  }
  
  public final void a(@NotNull ayog paramayog)
  {
    Intrinsics.checkParameterIsNotNull(paramayog, "pushComponent");
    if (QLog.isColorLevel()) {
      QLog.d("OnlineModulePushReceiver", 2, new Object[] { "onPushReceived: called. ", "pushComponent: " + paramayog });
    }
    if (!paramayog.a())
    {
      QLog.d("OnlineModulePushReceiver", 1, new Object[] { "onPushReceived: called. ", "invalid notify id. pushComponent: " + paramayog });
      return;
    }
    if (paramayog.jdField_b_of_type_Boolean)
    {
      c(paramayog);
      return;
    }
    ayof.a((Function0)new OnlineModulePushReceiver.onPushReceived.1(this, paramayog));
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
 * Qualified Name:     ayoe
 * JD-Core Version:    0.7.0.1
 */