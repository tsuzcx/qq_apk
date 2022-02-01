import com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity.7.1;
import com.tencent.mobileqq.filemanager.widget.QfileTabBarView;

public class aryu
  extends asbj
{
  public aryu(FileAssistantActivity paramFileAssistantActivity) {}
  
  protected void onFileCome(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    super.onFileCome(paramLong1, paramLong2, paramString, paramInt);
    this.a.a.a();
  }
  
  protected void onNeedVerifyPwdFailed(int paramInt, String paramString)
  {
    if (!FileAssistantActivity.a(this.a)) {
      aszk.a(paramString);
    }
  }
  
  protected void onNeedVerifyPwdSuccess(boolean paramBoolean)
  {
    if (FileAssistantActivity.a(this.a)) {
      return;
    }
    this.a.runOnUiThread(new FileAssistantActivity.7.1(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aryu
 * JD-Core Version:    0.7.0.1
 */