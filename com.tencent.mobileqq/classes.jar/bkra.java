import NS_MOBILE_PHOTO.get_albumlist_num_rsp;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

class bkra
  extends avvd
{
  bkra(bkqz parambkqz) {}
  
  protected void c(boolean paramBoolean, Bundle paramBundle)
  {
    paramBundle = paramBundle.getSerializable("data");
    if ((paramBoolean) && ((paramBundle instanceof get_albumlist_num_rsp)))
    {
      long l = ((get_albumlist_num_rsp)paramBundle).album_num;
      this.a.jdField_a_of_type_Aiqy.a = l;
      paramBundle = this.a.a();
      if (paramBundle != null)
      {
        paramBundle.a(this.a.jdField_a_of_type_Aiqy.a);
        paramBundle.b();
      }
    }
    BaseApplicationImpl.getApplication().getRuntime().unRegistObserver(this.a.jdField_a_of_type_Aiqp.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkra
 * JD-Core Version:    0.7.0.1
 */