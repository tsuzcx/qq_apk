import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import com.tencent.image.URLDrawable;
import com.tencent.image.Utils;
import com.tencent.mobileqq.troop.activity.MediaPreviewActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class bbge
  extends AsyncTask<Void, Void, Bundle>
{
  public bbge(MediaPreviewActivity paramMediaPreviewActivity, URLDrawable paramURLDrawable, String paramString) {}
  
  protected Bundle a(Void... paramVarArgs)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 1);
    paramVarArgs = new File(alof.bY);
    if (!paramVarArgs.exists()) {
      paramVarArgs.mkdirs();
    }
    String str = alof.bY + Utils.Crc64String(this.jdField_a_of_type_ComTencentImageURLDrawable.getURL().toString());
    paramVarArgs = str;
    if (!new File(str).exists()) {}
    try
    {
      paramVarArgs = this.jdField_a_of_type_ComTencentImageURLDrawable.saveTo(str);
      localBundle.putBoolean("forward_urldrawable", true);
      localBundle.putString("forward_urldrawable_thumb_url", this.jdField_a_of_type_JavaLangString);
      localBundle.putString("forward_filepath", paramVarArgs);
      localBundle.putString("forward_urldrawable_big_url", this.jdField_a_of_type_ComTencentImageURLDrawable.getURL().toString());
      localBundle.putString("forward_extra", paramVarArgs);
      return localBundle;
    }
    catch (IOException paramVarArgs)
    {
      QLog.e("foward", 2, "IOException", paramVarArgs);
    }
    return null;
  }
  
  protected void a(Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityMediaPreviewActivity, alud.a(2131706910), 0).b(this.jdField_a_of_type_ComTencentMobileqqTroopActivityMediaPreviewActivity.getTitleBarHeight());
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtras(paramBundle);
    aryv.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityMediaPreviewActivity, localIntent, 21);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbge
 * JD-Core Version:    0.7.0.1
 */