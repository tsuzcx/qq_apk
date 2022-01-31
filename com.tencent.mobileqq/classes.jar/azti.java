import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.troop.filemanager.data.TroopMemberListRefresher.1.1;
import java.util.List;

public class azti
  extends akil
{
  azti(azth paramazth) {}
  
  protected void a(String paramString, boolean paramBoolean, List<TroopMemberInfo> paramList, int paramInt1, long paramLong, int paramInt2)
  {
    if ((!TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString)) && (!this.a.jdField_a_of_type_JavaLangString.equals(paramString))) {}
    while ((!paramBoolean) || (this.a.jdField_a_of_type_AndroidOsHandler == null)) {
      return;
    }
    ThreadManager.post(new TroopMemberListRefresher.1.1(this), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azti
 * JD-Core Version:    0.7.0.1
 */