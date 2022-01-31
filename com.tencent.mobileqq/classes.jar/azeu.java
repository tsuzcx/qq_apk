import android.os.AsyncTask;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallEditActivity;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

public class azeu
  extends AsyncTask<Void, Void, String>
{
  public azeu(TroopAvatarWallEditActivity paramTroopAvatarWallEditActivity, URLDrawable paramURLDrawable, String paramString) {}
  
  protected String a(Void... paramVarArgs)
  {
    try
    {
      String str2 = this.jdField_a_of_type_ComTencentImageURLDrawable.saveTo(this.jdField_a_of_type_JavaLangString);
      if (str2 != null)
      {
        bbef.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity, str2);
        String str1 = this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity.getString(2131695191) + " " + str2;
        paramVarArgs = str1;
        if (QLog.isColorLevel())
        {
          QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, "savePhoto:" + str2);
          return str1;
        }
      }
      else
      {
        paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity.getString(2131695190);
        return paramVarArgs;
      }
    }
    catch (IOException paramVarArgs)
    {
      return this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity.getString(2131695190);
    }
    catch (OutOfMemoryError paramVarArgs)
    {
      paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity.getString(2131695190);
    }
    return paramVarArgs;
  }
  
  protected void a(String paramString)
  {
    bcql.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity, paramString, 0).b(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azeu
 * JD-Core Version:    0.7.0.1
 */