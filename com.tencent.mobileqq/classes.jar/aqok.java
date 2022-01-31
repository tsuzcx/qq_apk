import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;

final class aqok
  implements allt
{
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == aqod.a)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("action.now.jump");
      localIntent.putExtra("jump_action", paramInt2);
      BaseApplicationImpl.getContext().sendBroadcast(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aqok
 * JD-Core Version:    0.7.0.1
 */