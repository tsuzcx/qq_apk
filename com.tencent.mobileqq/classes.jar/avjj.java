import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class avjj
{
  private int jdField_a_of_type_Int;
  private ajuo jdField_a_of_type_Ajuo;
  private ajup jdField_a_of_type_Ajup = new avjk(this);
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private avnl jdField_a_of_type_Avnl;
  private ChatMessage jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<QQAppInterface> jdField_a_of_type_MqqUtilWeakReference;
  private long[] jdField_a_of_type_ArrayOfLong = { 1001L, 1002L };
  private int jdField_b_of_type_Int;
  private avnl jdField_b_of_type_Avnl;
  private String jdField_b_of_type_JavaLangString = "";
  private WeakReference<Context> jdField_b_of_type_MqqUtilWeakReference;
  private String c;
  private String d;
  
  public avjj(String paramString)
  {
    this.d = paramString;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    if (ChatActivityUtils.a(paramQQAppInterface, paramInt, paramString)) {
      return 5;
    }
    if (ChatActivityUtils.a(paramInt)) {
      return 3;
    }
    switch (paramInt)
    {
    default: 
      return -1;
    case 3000: 
      return 4;
    case 1: 
      return 2;
    }
    return 1;
  }
  
  private void a()
  {
    this.jdField_b_of_type_JavaLangString = "0";
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localQQAppInterface != null) {
      localQQAppInterface.removeObserver(this.jdField_a_of_type_Ajup);
    }
    if (this.jdField_a_of_type_AndroidAppDialog != null) {
      this.jdField_a_of_type_AndroidAppDialog = null;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, ChatMessage paramChatMessage)
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("UinSearcher", 2, "searching, skip");
      }
      return;
    }
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_b_of_type_MqqUtilWeakReference = new WeakReference(paramContext);
    if (this.jdField_a_of_type_Ajuo == null) {
      this.jdField_a_of_type_Ajuo = ((ajuo)paramQQAppInterface.a(152));
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
    paramString = paramChatMessage.selfuin;
    if ((!paramChatMessage.isSend()) && (!paramChatMessage.senderuin.equals(paramQQAppInterface.getCurrentAccountUin()))) {
      this.c = paramChatMessage.senderuin;
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = paramChatMessage.istroop;
      this.jdField_b_of_type_JavaLangString = (System.currentTimeMillis() + "");
      paramQQAppInterface.addObserver(this.jdField_a_of_type_Ajup);
      paramQQAppInterface = (ajfi)paramQQAppInterface.a(2);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.a(paramString, this.c, 1, 0L, (byte)1, 0L, 0L, null, "", 8192L, 10004, null, (byte)0);
      }
      try
      {
        this.jdField_a_of_type_AndroidAppDialog = new bbms(paramContext);
        this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new avjn(this));
        if (((paramContext instanceof Activity)) && (!((Activity)paramContext).isFinishing())) {
          this.jdField_a_of_type_AndroidAppDialog.show();
        }
        this.jdField_a_of_type_Ajuo.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, 20, avjb.a(this.jdField_a_of_type_ArrayOfLong), null, null, 0, 0.0D, 0.0D, null, "{ \"search_by_id_only\": 1 }");
        return;
        this.c = paramChatMessage.frienduin;
      }
      catch (RuntimeException paramQQAppInterface)
      {
        for (;;)
        {
          QLog.e("UinSearcher", 1, paramQQAppInterface, new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avjj
 * JD-Core Version:    0.7.0.1
 */