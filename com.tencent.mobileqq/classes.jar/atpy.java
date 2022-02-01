import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.qphone.base.util.QLog;

public class atpy
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private atqb jdField_a_of_type_Atqb;
  private Class<?> jdField_a_of_type_JavaLangClass;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  
  public atpy(Context paramContext, atqb paramatqb)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Atqb = paramatqb;
    this.jdField_a_of_type_JavaLangClass = FileBrowserActivity.class;
    this.jdField_b_of_type_Int = -1;
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 5) || (this.jdField_a_of_type_Int == 3);
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_Atqb.d()) && (b())) {}
    do
    {
      return;
      Intent localIntent = this.jdField_a_of_type_Atqb.a();
      if (localIntent == null)
      {
        QLog.i("FileBrowserCreator<FileAssistant>", 1, "openFileBrowser error, intent params is null.");
        return;
      }
      if (this.jdField_b_of_type_Int != -1) {
        localIntent.setFlags(this.jdField_b_of_type_Int);
      }
      localIntent.setClass(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangClass);
      localIntent.putExtra("file_enter_file_browser_type", this.jdField_a_of_type_Int);
      Bundle localBundle = new Bundle();
      localBundle.putInt("file_enter_file_browser_type", this.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_AndroidGraphicsRect != null) {
        localBundle.putParcelable("file_browser_params_thumb_bound", this.jdField_a_of_type_AndroidGraphicsRect);
      }
      this.jdField_a_of_type_Atqb.b(localBundle);
      localIntent.putExtra("file_browser_extra_params", localBundle);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        localIntent.putExtra("selfSet_leftViewText", this.jdField_a_of_type_JavaLangString);
      }
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    } while (!(this.jdField_a_of_type_AndroidContentContext instanceof Activity));
    ((Activity)this.jdField_a_of_type_AndroidContentContext).overridePendingTransition(2130772037, 2130772039);
  }
  
  private boolean b()
  {
    if (!a()) {
      if (QLog.isColorLevel()) {
        QLog.w("FileBrowserCreator<FileAssistant>", 1, "processNewFileVideoBrowser isFromAIO return false, mEntranceType:" + this.jdField_a_of_type_Int);
      }
    }
    ChatMessage localChatMessage;
    SessionInfo localSessionInfo;
    do
    {
      do
      {
        do
        {
          return false;
          localChatMessage = this.jdField_a_of_type_Atqb.a();
          if (localChatMessage != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.w("FileBrowserCreator<FileAssistant>", 1, "processNewFileVideoBrowser getChatMessage return falase");
        return false;
        localSessionInfo = this.jdField_a_of_type_Atqb.a();
        if (localSessionInfo != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.w("FileBrowserCreator<FileAssistant>", 1, "processNewFileVideoBrowser getSessionInfo return falase");
      return false;
      if (this.jdField_a_of_type_Atqb.c())
      {
        if (QLog.isColorLevel()) {
          QLog.w("FileBrowserCreator<FileAssistant>", 1, "processNewFileVideoBrowser set video resume, return true");
        }
        return true;
      }
      if (this.jdField_a_of_type_Atqb.d()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("FileBrowserCreator<FileAssistant>", 1, "processNewFileVideoBrowser canUseNewVideoBrowser is false, don't start new video browser");
    return false;
    atwt.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidGraphicsRect, localChatMessage, localSessionInfo, this.jdField_a_of_type_Atqb.a(), this.jdField_a_of_type_Atqb.e(), this.jdField_a_of_type_Atqb.f(), null);
    return true;
  }
  
  private void c()
  {
    atqa localatqa = new atqa(this);
    String str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131692321);
    String str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131692323);
    atvb.a(this.jdField_a_of_type_AndroidContentContext, str1, str2, localatqa);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Atqb.b()))
    {
      if (atwt.a(this.jdField_a_of_type_AndroidContentContext, false, new atpz(this))) {
        c();
      }
      return;
    }
    b();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(Rect paramRect)
  {
    this.jdField_a_of_type_AndroidGraphicsRect = paramRect;
  }
  
  public void a(Class<?> paramClass)
  {
    this.jdField_a_of_type_JavaLangClass = paramClass;
  }
  
  public void a(String paramString) {}
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atpy
 * JD-Core Version:    0.7.0.1
 */