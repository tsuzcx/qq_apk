import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qidian.QidianProfileCardActivity;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

public class bimb
  extends amsu
{
  public bimb(QidianProfileCardActivity paramQidianProfileCardActivity) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    super.onUpdateCustomHead(paramBoolean, paramString);
    if (paramBoolean)
    {
      if (!paramString.equals(this.a.jdField_a_of_type_Aymg.a.jdField_a_of_type_JavaLangString)) {
        break label86;
      }
      if (!bbyp.b()) {
        break label64;
      }
      this.a.jdField_a_of_type_AndroidGraphicsBitmap = this.a.app.getFaceBitmap(paramString, (byte)2, false);
      this.a.c();
    }
    label64:
    label86:
    do
    {
      return;
      this.a.jdField_a_of_type_AndroidGraphicsBitmap = this.a.app.getFaceBitmap(paramString, false);
      break;
      paramString = (bimw)this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    } while (paramString == null);
    this.a.a(paramString.jdField_a_of_type_Int, (URLImageView)paramString.jdField_a_of_type_JavaLangRefWeakReference.get(), paramString.jdField_a_of_type_JavaLangString, true);
  }
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_Aymg.a.jdField_a_of_type_JavaLangString.equals(String.valueOf(paramObject)))) {
      this.a.b();
    }
  }
  
  protected void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2) && (this.a.jdField_a_of_type_Aymg.a.jdField_a_of_type_JavaLangString != null) && (!ProfileActivity.AllInOne.b(this.a.jdField_a_of_type_Aymg.a)) && (this.a.jdField_a_of_type_Amsw != null) && (this.a.jdField_a_of_type_Amsw.b(this.a.jdField_a_of_type_Aymg.a.jdField_a_of_type_JavaLangString)) && (!this.a.jdField_a_of_type_Aymg.a.jdField_a_of_type_JavaLangString.equals(this.a.app.getCurrentAccountUin())))
    {
      this.a.jdField_a_of_type_Aymg.a.jdField_a_of_type_Int = 1;
      QidianProfileCardActivity.b(this.a, this.a.jdField_a_of_type_Aymg.a.jdField_a_of_type_JavaLangString);
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bimb
 * JD-Core Version:    0.7.0.1
 */