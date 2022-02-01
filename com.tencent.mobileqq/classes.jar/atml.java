import com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity.7.1;
import com.tencent.mobileqq.filemanager.widget.QfileTabBarView;

public class atml
  extends atpa
{
  public atml(FileAssistantActivity paramFileAssistantActivity) {}
  
  protected void a(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    super.a(paramLong1, paramLong2, paramString, paramInt);
    this.a.a.a();
  }
  
  protected void a(boolean paramBoolean)
  {
    if (FileAssistantActivity.a(this.a)) {
      return;
    }
    this.a.runOnUiThread(new FileAssistantActivity.7.1(this, paramBoolean));
  }
  
  protected void b(int paramInt, String paramString)
  {
    if (!FileAssistantActivity.a(this.a)) {
      auna.a(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atml
 * JD-Core Version:    0.7.0.1
 */