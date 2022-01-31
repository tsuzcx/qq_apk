import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;

final class aszf
  implements anrf
{
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == asyy.a)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("action.now.jump");
      localIntent.putExtra("jump_action", paramInt2);
      BaseApplicationImpl.getContext().sendBroadcast(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aszf
 * JD-Core Version:    0.7.0.1
 */