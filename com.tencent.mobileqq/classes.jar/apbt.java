import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.msgcache.MsgLruCache;
import com.tencent.mobileqq.database.corrupt.DBFixConfigActivity;
import mqq.app.AppRuntime;

public class apbt
  implements View.OnClickListener
{
  public apbt(DBFixConfigActivity paramDBFixConfigActivity, AppRuntime paramAppRuntime) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_MqqAppAppRuntime instanceof QQAppInterface)) {
      ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).a(0).a().a().printMsgLruCache();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apbt
 * JD-Core Version:    0.7.0.1
 */