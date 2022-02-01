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
import java.lang.ref.WeakReference;
import java.net.URL;

public class bfic
  extends AsyncTask<Void, Void, Bundle>
{
  protected URLDrawable a;
  protected String a;
  protected WeakReference<TroopAvatarWallPreviewActivity> a;
  protected boolean a;
  protected String b;
  
  public bfic(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity, String paramString1, boolean paramBoolean, URLDrawable paramURLDrawable, String paramString2)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramTroopAvatarWallPreviewActivity);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentImageURLDrawable = paramURLDrawable;
    this.b = paramString2;
  }
  
  protected Bundle a(Void... paramVarArgs)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) || (this.jdField_a_of_type_ComTencentImageURLDrawable == null)) {
      return null;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 1);
    paramVarArgs = new File(antf.cb);
    if (!paramVarArgs.exists()) {
      paramVarArgs.mkdirs();
    }
    String str = antf.cb + this.jdField_a_of_type_JavaLangString + Utils.Crc64String(this.jdField_a_of_type_ComTencentImageURLDrawable.getURL().toString());
    paramVarArgs = str;
    if (!new File(str).exists()) {}
    try
    {
      paramVarArgs = this.jdField_a_of_type_ComTencentImageURLDrawable.saveTo(str);
      localBundle.putBoolean("forward_urldrawable", true);
      localBundle.putString("forward_urldrawable_thumb_url", this.b);
      localBundle.putString("forward_filepath", paramVarArgs);
      localBundle.putString("forward_urldrawable_big_url", this.jdField_a_of_type_ComTencentImageURLDrawable.getURL().toString());
      localBundle.putString("forward_extra", paramVarArgs);
      if (this.jdField_a_of_type_Boolean)
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
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {
      return;
    }
    TroopAvatarWallPreviewActivity localTroopAvatarWallPreviewActivity = (TroopAvatarWallPreviewActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramBundle == null)
    {
      QQToast.a(localTroopAvatarWallPreviewActivity, anzj.a(2131713996), 0).b(localTroopAvatarWallPreviewActivity.getTitleBarHeight());
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtras(paramBundle);
    auxu.a(localTroopAvatarWallPreviewActivity, localIntent, 21);
    TroopAvatarWallPreviewActivity.a(localTroopAvatarWallPreviewActivity, "0X8006A81", "0X8006A95");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfic
 * JD-Core Version:    0.7.0.1
 */