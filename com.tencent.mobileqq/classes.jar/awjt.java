import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.jubao.JubaoMsgData;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.ArrayList;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

public class awjt
  extends QIPCModule
  implements BusinessObserver
{
  private static awjt jdField_a_of_type_Awjt;
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<ChatMessage> jdField_a_of_type_JavaUtilArrayList;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private ArrayList<JubaoMsgData> jdField_b_of_type_JavaUtilArrayList;
  
  private awjt(String paramString)
  {
    super(paramString);
  }
  
  public static awjt a()
  {
    if (jdField_a_of_type_Awjt == null) {}
    try
    {
      if (jdField_a_of_type_Awjt == null) {
        jdField_a_of_type_Awjt = new awjt("JubaoIPCServer");
      }
      return jdField_a_of_type_Awjt;
    }
    finally {}
  }
  
  private QQAppInterface a()
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      return (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    }
    return null;
  }
  
  public ArrayList<ChatMessage> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    EIPCResult localEIPCResult = new EIPCResult();
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("receive_success", false);
    localEIPCResult.data = localBundle;
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    callbackResult(this.jdField_b_of_type_Int, localEIPCResult);
  }
  
  public void a(String paramString)
  {
    QQAppInterface localQQAppInterface = a();
    NewIntent localNewIntent = new NewIntent(localQQAppInterface.getApplication().getApplicationContext(), awju.class);
    localNewIntent.putExtra("jubao_chat_uin", this.jdField_a_of_type_JavaLangString);
    localNewIntent.putExtra("jubao_group_code", this.jdField_b_of_type_JavaLangString);
    localNewIntent.putExtra("jubao_chat_type", this.jdField_a_of_type_Int);
    localNewIntent.putExtra("jubao_msg_list", this.jdField_b_of_type_JavaUtilArrayList);
    localNewIntent.putExtra("multi_msg_resID", paramString);
    localNewIntent.setObserver(this);
    localQQAppInterface.startServlet(localNewIntent);
  }
  
  public void a(ArrayList<ChatMessage> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramArrayList);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("JubaoIPCServer", 2, "jubaoIpcServer onCall= " + paramString + ",callbackId = " + paramInt);
    }
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("jubao_chat_uin");
    this.jdField_b_of_type_JavaLangString = paramBundle.getString("jubao_group_code");
    this.jdField_a_of_type_Int = paramBundle.getInt("jubao_chat_type");
    this.jdField_b_of_type_JavaUtilArrayList = ((ArrayList)paramBundle.getSerializable("jubao_msg_list"));
    paramString = a();
    paramBundle = new NewIntent(paramString.getApplication().getApplicationContext(), awju.class);
    paramBundle.putExtra("jubao_chat_uin", this.jdField_a_of_type_JavaLangString);
    paramBundle.putExtra("jubao_group_code", this.jdField_b_of_type_JavaLangString);
    paramBundle.putExtra("jubao_chat_type", this.jdField_a_of_type_Int);
    paramBundle.putExtra("jubao_msg_list", this.jdField_b_of_type_JavaUtilArrayList);
    paramBundle.setObserver(this);
    paramString.startServlet(paramBundle);
    return null;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    EIPCResult localEIPCResult = new EIPCResult();
    paramBundle.putBoolean("receive_success", paramBoolean);
    localEIPCResult.data = paramBundle;
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    callbackResult(this.jdField_b_of_type_Int, localEIPCResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awjt
 * JD-Core Version:    0.7.0.1
 */