import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;

final class awcl
  implements aqjj
{
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == awcc.a)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("action.now.jump");
      localIntent.putExtra("jump_action", paramInt2);
      BaseApplicationImpl.getContext().sendBroadcast(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awcl
 * JD-Core Version:    0.7.0.1
 */