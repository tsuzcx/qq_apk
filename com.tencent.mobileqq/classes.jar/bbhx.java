import android.content.Intent;
import android.os.AsyncTask;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.MimeTypeMap;
import java.io.File;
import java.io.IOException;

public class bbhx
  extends AsyncTask<Void, Void, String>
{
  public bbhx(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity, URLDrawable paramURLDrawable, String paramString) {}
  
  protected String a(Void... paramVarArgs)
  {
    try
    {
      str1 = this.jdField_a_of_type_ComTencentImageURLDrawable.saveTo(this.jdField_a_of_type_JavaLangString);
      if (str1 != null)
      {
        paramVarArgs = null;
        try
        {
          String str2 = MimeTypeMap.getFileExtensionFromUrl(str1);
          if (str2 != null) {
            paramVarArgs = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str2);
          }
          if ((paramVarArgs != null) && (paramVarArgs.startsWith("image/"))) {
            bdhj.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity, new File(str1));
          }
        }
        catch (IllegalArgumentException paramVarArgs)
        {
          for (;;)
          {
            QLog.e("TroopAvatarWallPreviewActivity", 2, new Object[] { "savePic2SystemMedia illegalArgumentException ex", paramVarArgs.getMessage() });
          }
        }
        bdhj.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity, str1);
        if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.getIntent().getBooleanExtra("from_photo_wall", false)) {
          return alud.a(2131715607);
        }
      }
    }
    catch (IOException paramVarArgs)
    {
      String str1;
      return this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.getString(2131695350);
      return this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.getString(2131695351) + " " + str1;
      paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.getString(2131695350);
      return paramVarArgs;
    }
    catch (OutOfMemoryError paramVarArgs) {}
    return this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.getString(2131695350);
  }
  
  protected void a(String paramString)
  {
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity, paramString, 0).b(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbhx
 * JD-Core Version:    0.7.0.1
 */