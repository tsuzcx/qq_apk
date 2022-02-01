import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Hashtable;

public class bhne
  extends anyu
{
  private final bhmr b;
  
  public bhne(bhmr parambhmr1, bhmr parambhmr2)
  {
    this.b = parambhmr2;
  }
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((!paramBoolean) || (this.a.jdField_a_of_type_JavaUtilHashtable == null) || (!this.a.jdField_a_of_type_JavaUtilHashtable.containsKey(paramString))) {}
    do
    {
      return;
      this.a.jdField_a_of_type_JavaUtilHashtable.remove(paramString);
      if (this.a.jdField_a_of_type_JavaUtilHashtable.size() == 0) {
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.a.jdField_a_of_type_Bhne);
      }
      Object localObject = Uri.parse(bhmr.a(this.a) + "&uin=" + paramString);
      localObject = new Intent((String)this.a.jdField_a_of_type_JavaUtilHashMap.get("callback_name"), (Uri)localObject);
      this.a.jdField_a_of_type_AndroidContentContext.sendBroadcast((Intent)localObject, "com.tencent.msg.permission.pushnotify");
    } while (!QLog.isColorLevel());
    QLog.i("JumpAction", 2, "download head " + paramString + " success. Send broadcast to " + (String)this.a.jdField_a_of_type_JavaUtilHashMap.get("callback_name"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bhne
 * JD-Core Version:    0.7.0.1
 */