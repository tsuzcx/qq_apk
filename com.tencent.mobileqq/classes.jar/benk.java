import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ActionMode.Callback;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.together.writetogether.data.OpenDocParam;
import com.tencent.mobileqq.togetherui.writetogether.WriteTogetherEditorFragment;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;

public class benk
  implements agin, agja
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ActionMode.Callback jdField_a_of_type_AndroidViewActionMode$Callback;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public benk(agih paramagih, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.app;
    this.jdField_a_of_type_AndroidContentContext = paramBaseChatPie.mContext;
    paramagih.a(this);
  }
  
  private String a()
  {
    String str2 = "";
    String str1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) {
      str1 = str2;
    }
    for (;;)
    {
      if (TextUtils.isEmpty(str1)) {}
      return str1;
      str1 = str2;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo != null)
      {
        str1 = str2;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin != null) {
          str1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin;
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, BaseChatPie paramBaseChatPie, String paramString1, String paramString2, int paramInt)
  {
    if (!a(paramContext)) {}
    while (TextUtils.isEmpty(paramString1)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("WriteTogetherHelper", 2, "[Launch Editor] - Click WT message. docId: " + paramString1);
    }
    paramQQAppInterface = new Bundle();
    paramQQAppInterface.putString("KEY_CANCEL_OR_BACK", "VALUE_BACK");
    OpenDocParam localOpenDocParam = new OpenDocParam();
    localOpenDocParam.jdField_f_of_type_Int = paramInt;
    localOpenDocParam.k = paramString2;
    localOpenDocParam.jdField_f_of_type_JavaLangString = paramString1;
    localOpenDocParam.g = 0;
    paramQQAppInterface.putParcelable("KEY_LAUNCH_EDITOR_PARAM", localOpenDocParam);
    if ((paramContext instanceof Activity))
    {
      WriteTogetherEditorFragment.a((Activity)paramContext, WriteTogetherEditorFragment.class, paramQQAppInterface, 18005);
      return;
    }
    if ((paramBaseChatPie != null) && ((paramBaseChatPie.mActivity instanceof Activity)))
    {
      WriteTogetherEditorFragment.a(paramBaseChatPie.mActivity, WriteTogetherEditorFragment.class, paramQQAppInterface, 18005);
      return;
    }
    WriteTogetherEditorFragment.a(paramContext, WriteTogetherEditorFragment.class, paramQQAppInterface);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    a(paramQQAppInterface, paramContext, null, paramString1, paramString2, paramInt);
  }
  
  private static boolean a(Context paramContext)
  {
    boolean bool = NetworkUtil.isNetworkAvailable(paramContext);
    if (!bool) {
      QQToast.a(paramContext, 2131720169, 0).a();
    }
    return bool;
  }
  
  private static boolean a(Context paramContext, String paramString)
  {
    boolean bool = nty.a().a(paramString);
    if (bool) {
      QQToast.a(paramContext, 2131720150, 0).a();
    }
    return bool;
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    boolean bool = a(paramQQAppInterface, paramString);
    if (bool) {
      QQToast.a(paramContext, 2131720160, 0).a();
    }
    return bool;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    return ((bgkf)paramQQAppInterface.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).a(paramString, true).a;
  }
  
  private boolean b()
  {
    Object localObject = a();
    localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).a((String)localObject, true);
    return (localObject != null) && (((TroopInfo)localObject).exitTroopReason == 0);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_AndroidViewActionMode$Callback != null) {}
    while (Build.VERSION.SDK_INT < 23) {
      return;
    }
    this.jdField_a_of_type_AndroidViewActionMode$Callback = new benl(this);
  }
  
  private void d()
  {
    ChatXListView localChatXListView = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.listView;
    localChatXListView.setSelectionFromBottom(localChatXListView.getCount() - 1, 0);
  }
  
  public ActionMode.Callback a()
  {
    c();
    return this.jdField_a_of_type_AndroidViewActionMode$Callback;
  }
  
  public void a()
  {
    c();
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0) {
      a();
    }
    while (paramInt != 14) {
      return;
    }
    b();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != 18005) {}
    do
    {
      return;
      if ((paramInt2 & 0x1) == 0) {
        break;
      }
      if ((paramInt2 & 0x2) != 0) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.setText("");
      }
      if ((paramInt2 & 0x4) != 0)
      {
        paramIntent = (aght)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getHelper(24);
        if (paramIntent != null) {
          paramIntent.a(true);
        }
      }
    } while ((paramInt2 & 0x8) == 0);
    d();
    return;
    QLog.e("WriteTogetherHelper", 1, "[onActivityResult] failed code: " + paramInt2);
  }
  
  public void a(String paramString, int paramInt)
  {
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, paramString, a(), paramInt);
  }
  
  public boolean a()
  {
    boolean bool = true;
    if (!arhn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      return false;
    }
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo;
    if ((localSessionInfo != null) && (localSessionInfo.curType == 1) && (b())) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public int[] a()
  {
    return new int[] { 0, 14 };
  }
  
  public void b() {}
  
  public void b(String paramString, int paramInt)
  {
    int i = 1;
    if (!a(this.jdField_a_of_type_AndroidContentContext)) {}
    Object localObject;
    do
    {
      return;
      localObject = a();
    } while ((a(this.jdField_a_of_type_AndroidContentContext, (String)localObject)) || (a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (String)localObject)));
    if (!benq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131720152, 0).a();
      return;
    }
    String str1 = paramString;
    if (paramString == null) {
      str1 = "";
    }
    int j;
    if (QLog.isColorLevel())
    {
      if (paramInt == 1)
      {
        paramString = "input box";
        QLog.d("WriteTogetherHelper", 2, "[Launch Editor] - " + paramString);
      }
    }
    else
    {
      paramString = new Bundle();
      String str2 = benq.a(str1);
      paramString.putString("leftViewText", anvx.a(2131720121));
      paramString.putString("KEY_CANCEL_OR_BACK", "VALUE_CANCEL");
      OpenDocParam localOpenDocParam = new OpenDocParam();
      localOpenDocParam.a = str2;
      localOpenDocParam.jdField_f_of_type_Int = paramInt;
      localOpenDocParam.k = ((String)localObject);
      if ((paramInt == 5) || (paramInt == 6)) {
        localOpenDocParam.g = 0;
      }
      paramString.putParcelable("KEY_LAUNCH_EDITOR_PARAM", localOpenDocParam);
      WriteTogetherEditorFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mActivity, WriteTogetherEditorFragment.class, paramString, 18005);
      j = benq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject);
      paramString = "" + benq.a(paramInt);
      localObject = new StringBuilder().append("");
      if (!TextUtils.isEmpty(str1)) {
        break label346;
      }
    }
    label346:
    for (paramInt = i;; paramInt = 2)
    {
      bdla.b(null, "dc00898", "", "", "0X800AF2F", "0X800AF2F", j, 0, paramString, paramInt, "", "");
      return;
      if (paramInt == 2)
      {
        paramString = "full screen";
        break;
      }
      paramString = "unknown";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     benk
 * JD-Core Version:    0.7.0.1
 */