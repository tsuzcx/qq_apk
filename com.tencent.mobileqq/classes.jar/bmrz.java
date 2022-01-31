import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.lang.ref.WeakReference;
import java.util.Collections;

class bmrz
  implements urr<vfq, vhk>
{
  bmrz(bmru parambmru, WeakReference paramWeakReference) {}
  
  public void a(@NonNull vfq paramvfq, @Nullable vhk paramvhk, @NonNull ErrorMessage paramErrorMessage)
  {
    if (paramvhk == null)
    {
      paramvfq = (bmsf)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramvfq != null) {
        paramvfq.a(paramErrorMessage.errorCode, Collections.EMPTY_LIST);
      }
      return;
    }
    paramvfq = (bmsf)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramvfq != null)
    {
      paramvfq.a(0, paramvhk.a);
      return;
    }
    wxe.c("DoodleEmojiManager", "requestPoiFaces callback is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmrz
 * JD-Core Version:    0.7.0.1
 */