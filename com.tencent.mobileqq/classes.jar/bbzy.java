import android.app.Activity;
import android.content.Context;
import android.view.Window;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class bbzy
{
  private int jdField_a_of_type_Int;
  private aogg jdField_a_of_type_Aogg;
  private aogh jdField_a_of_type_Aogh = new bbzz(this);
  private bisl jdField_a_of_type_Bisl;
  private ChatMessage jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<QQAppInterface> jdField_a_of_type_MqqUtilWeakReference;
  private long[] jdField_a_of_type_ArrayOfLong = { 1001L, 1002L, 8001L };
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString = "";
  private WeakReference<Context> jdField_b_of_type_MqqUtilWeakReference;
  private String c;
  private String d;
  
  public bbzy(String paramString)
  {
    this.d = paramString;
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 0: 
      return 1;
    case 1: 
      return 2;
    case 3000: 
      return 3;
    }
    return 4;
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
      localQQAppInterface.removeObserver(this.jdField_a_of_type_Aogh);
    }
    if (this.jdField_a_of_type_Bisl != null) {
      this.jdField_a_of_type_Bisl = null;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, ChatMessage paramChatMessage)
  {
    if (this.jdField_a_of_type_Bisl != null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("UinSearcher", 2, "searching, skip");
      }
      return;
    }
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_b_of_type_MqqUtilWeakReference = new WeakReference(paramContext);
    if (this.jdField_a_of_type_Aogg == null) {
      this.jdField_a_of_type_Aogg = ((aogg)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.UNIFY_SEARCH_UNITE_HANDLER));
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
    paramString = paramChatMessage.selfuin;
    if ((!paramChatMessage.isSend()) && (!paramChatMessage.senderuin.equals(paramQQAppInterface.getCurrentAccountUin()))) {}
    for (this.c = paramChatMessage.senderuin;; this.c = paramChatMessage.frienduin)
    {
      this.jdField_a_of_type_Int = paramChatMessage.istroop;
      this.jdField_b_of_type_JavaLangString = (System.currentTimeMillis() + "");
      paramQQAppInterface.addObserver(this.jdField_a_of_type_Aogh);
      paramQQAppInterface = (anri)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.a(paramString, this.c, 1, 0L, (byte)1, 0L, 0L, null, "", 8192L, 10004, null, (byte)0);
      }
      try
      {
        this.jdField_a_of_type_Bisl = new bisl(paramContext);
        this.jdField_a_of_type_Bisl.e(17);
        this.jdField_a_of_type_Bisl.a(null);
        this.jdField_a_of_type_Bisl.f(2130839470);
        if (this.jdField_a_of_type_Bisl.getWindow() != null) {
          this.jdField_a_of_type_Bisl.getWindow().setDimAmount(0.0F);
        }
        this.jdField_a_of_type_Bisl.setOnDismissListener(new bcac(this));
        if (((paramContext instanceof Activity)) && (!((Activity)paramContext).isFinishing())) {
          this.jdField_a_of_type_Bisl.show();
        }
      }
      catch (RuntimeException paramQQAppInterface)
      {
        for (;;)
        {
          QLog.e("UinSearcher", 1, paramQQAppInterface, new Object[0]);
        }
      }
      this.jdField_a_of_type_Aogg.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, 20, bbzq.a(this.jdField_a_of_type_ArrayOfLong), null, null, 0, 0.0D, 0.0D, null, "{ \"search_by_id_only\": 1 }");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbzy
 * JD-Core Version:    0.7.0.1
 */