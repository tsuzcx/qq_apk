import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundManager;
import java.util.HashMap;
import java.util.List;

class amkt
  implements amjs
{
  amkt(amkr paramamkr, String paramString) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      Object localObject = "key_special_sound_list" + this.jdField_a_of_type_Amkr.mRuntime.a().getCurrentAccountUin();
      localObject = (List)QvipSpecialSoundManager.a.get(localObject);
      amkr.a(this.jdField_a_of_type_Amkr, this.jdField_a_of_type_JavaLangString, (List)localObject);
      return;
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
      try
      {
        amkr.a(this.jdField_a_of_type_Amkr, this.jdField_a_of_type_JavaLangString, null);
        return;
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
      }
    }
    amkr.a(this.jdField_a_of_type_Amkr, this.jdField_a_of_type_JavaLangString, null);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amkt
 * JD-Core Version:    0.7.0.1
 */