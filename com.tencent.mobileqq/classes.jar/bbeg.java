import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import com.tencent.image.URLDrawable;
import com.tencent.image.Utils;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class bbeg
  extends AsyncTask<Void, Void, Bundle>
{
  public bbeg(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity, URLDrawable paramURLDrawable, String paramString) {}
  
  protected Bundle a(Void... paramVarArgs)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 1);
    paramVarArgs = new File(aljq.bY);
    if (!paramVarArgs.exists()) {
      paramVarArgs.mkdirs();
    }
    String str = aljq.bY + this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.jdField_a_of_type_JavaLangString + Utils.Crc64String(this.jdField_a_of_type_ComTencentImageURLDrawable.getURL().toString());
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
      if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.l)
      {
        localBundle.putString("forward_thumb", paramVarArgs);
        localBundle.putBoolean("key_flag_from_plugin", true);
      }
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
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity, alpo.a(2131715594), 0).b(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.getTitleBarHeight());
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtras(paramBundle);
    arum.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity, localIntent, 21);
    TroopAvatarWallPreviewActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity, "0X8006A81", "0X8006A95");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbeg
 * JD-Core Version:    0.7.0.1
 */