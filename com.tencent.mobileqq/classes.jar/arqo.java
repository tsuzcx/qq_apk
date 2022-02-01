import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class arqo
  implements Manager
{
  private ClipboardManager jdField_a_of_type_AndroidContentClipboardManager;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public arqo(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private ClipboardManager a()
  {
    if (this.jdField_a_of_type_AndroidContentClipboardManager == null) {
      this.jdField_a_of_type_AndroidContentClipboardManager = ((ClipboardManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getSystemService("clipboard"));
    }
    return this.jdField_a_of_type_AndroidContentClipboardManager;
  }
  
  private SharedPreferences a()
  {
    if (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      this.jdField_a_of_type_AndroidContentSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
    }
    return this.jdField_a_of_type_AndroidContentSharedPreferences;
  }
  
  public String a()
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      long l1 = a().getLong("KEY_LAST_COPY_TIME", 0L);
      Object localObject = a().getPrimaryClipDescription();
      if (localObject != null)
      {
        long l2 = ((ClipDescription)localObject).getTimestamp();
        long l3 = System.currentTimeMillis();
        if ((l2 != l1) && (l3 - l2 < 180000L))
        {
          a().edit().putLong("KEY_LAST_COPY_TIME", l2).apply();
          if (a().hasPrimaryClip())
          {
            localObject = a().getPrimaryClip();
            if ((localObject != null) && (((ClipData)localObject).getItemCount() > 0))
            {
              localObject = ((ClipData)localObject).getItemAt(0);
              if (QLog.isColorLevel()) {
                QLog.d("CopyPromptManager", 2, "origin copy data : " + localObject);
              }
              if (localObject != null)
              {
                localObject = ((ClipData.Item)localObject).getText();
                if ((localObject != null) && (!TextUtils.isEmpty((CharSequence)localObject))) {
                  return String.valueOf(localObject);
                }
              }
            }
          }
        }
      }
    }
    return "";
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arqo
 * JD-Core Version:    0.7.0.1
 */