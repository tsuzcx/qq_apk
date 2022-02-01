import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyLockScreenJumpDelegate;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianDailyManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/notification/modularize/business/KanDianJumpScheme;", "Lcom/tencent/mobileqq/notification/modularize/BaseJumpScheme;", "()V", "customJumpIntent", "Landroid/app/PendingIntent;", "pushComponent", "Lcom/tencent/mobileqq/notification/modularize/PushComponent;", "generatePendingIntent", "Landroid/content/Intent;", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "messageRecord", "Lcom/tencent/mobileqq/data/MessageRecord;", "context", "Landroid/content/Context;", "nativeJumpIntent", "needCustomJump", "", "processMsg0x210Sub0x135ExtData", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class aych
  extends aybw
{
  public static final ayci a = new ayci(null);
  
  private final Intent a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, Context paramContext, ayca paramayca)
  {
    if (pha.c(paramMessageRecord))
    {
      paramQQAppInterface = paramQQAppInterface.getManager(296);
      if (paramQQAppInterface == null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoy.engine.KandianDailyManager");
      }
      paramQQAppInterface = ReadInJoyLockScreenJumpDelegate.a(paramContext, 6, ((KandianDailyManager)paramQQAppInterface).b());
      Intrinsics.checkExpressionValueIsNotNull(paramQQAppInterface, "ReadInJoyLockScreenJumpD…moveLockScreenRedDodInfo)");
    }
    for (;;)
    {
      paramQQAppInterface.putExtra("is_from_push_component", true);
      paramQQAppInterface.putExtra("push_main_business_id", paramayca.jdField_a_of_type_Int);
      paramQQAppInterface.putExtra("push_sub_business_id", paramayca.b);
      paramQQAppInterface.putExtra("push_id", paramayca.c);
      paramQQAppInterface.addFlags(268435456);
      return paramQQAppInterface;
      paramQQAppInterface = ohp.a(paramContext, 6);
      Intrinsics.checkExpressionValueIsNotNull(paramQQAppInterface, "ReadInJoyActivityHelper.…tent(context, launchFrom)");
    }
  }
  
  private final MessageRecord a(QQAppInterface paramQQAppInterface, ayca paramayca)
  {
    paramQQAppInterface = paramQQAppInterface.getManager(162);
    if (paramQQAppInterface == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager");
    }
    paramQQAppInterface = ((KandianMergeManager)paramQQAppInterface).a(paramayca.jdField_a_of_type_ArrayOfByte, paramayca.jdField_a_of_type_JavaLangString);
    Intrinsics.checkExpressionValueIsNotNull(paramQQAppInterface, "km.createFakeMsgFrom0x13…ata, pushComponent.title)");
    return paramQQAppInterface;
  }
  
  private final PendingIntent e(ayca paramayca)
  {
    Object localObject = (Intent)null;
    BaseApplication localBaseApplication = BaseApplication.context;
    if (paramayca.b == 1)
    {
      QLog.d("KanDianJumpScheme", 1, "nativeJumpIntent bytesExtData: " + new String(paramayca.jdField_a_of_type_ArrayOfByte, Charsets.UTF_8));
      localObject = BaseApplicationImpl.getApplication();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplicationImpl.getApplication()");
      localObject = ((BaseApplicationImpl)localObject).getRuntime();
      if (localObject == null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
      }
      QQAppInterface localQQAppInterface = (QQAppInterface)localObject;
      MessageRecord localMessageRecord = a(localQQAppInterface, paramayca);
      Intrinsics.checkExpressionValueIsNotNull(localBaseApplication, "context");
      localObject = a(localQQAppInterface, localMessageRecord, (Context)localBaseApplication, paramayca);
      pha.a(localQQAppInterface.a(), localMessageRecord, (Intent)localObject);
    }
    for (;;)
    {
      paramayca = PendingIntent.getActivity((Context)localBaseApplication, paramayca.d, (Intent)localObject, 134217728);
      Intrinsics.checkExpressionValueIsNotNull(paramayca, "PendingIntent.getActivit…tent.FLAG_UPDATE_CURRENT)");
      return paramayca;
      QLog.d("KanDianJumpScheme", 1, new Object[] { "nativeJumpIntent: called. ", "invalid subBusinessId. pushComponent: " + paramayca });
    }
  }
  
  @NotNull
  protected PendingIntent a(@NotNull ayca paramayca)
  {
    Intrinsics.checkParameterIsNotNull(paramayca, "pushComponent");
    return e(paramayca);
  }
  
  protected boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aych
 * JD-Core Version:    0.7.0.1
 */