import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.lang.ref.WeakReference;
import java.util.Collections;

class bkcd
  implements syq<tmp, toj>
{
  bkcd(bkby parambkby, WeakReference paramWeakReference) {}
  
  public void a(@NonNull tmp paramtmp, @Nullable toj paramtoj, @NonNull ErrorMessage paramErrorMessage)
  {
    if (paramtoj == null)
    {
      paramtmp = (bkcj)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramtmp != null) {
        paramtmp.a(paramErrorMessage.errorCode, Collections.EMPTY_LIST);
      }
      return;
    }
    paramtmp = (bkcj)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramtmp != null)
    {
      paramtmp.a(0, paramtoj.a);
      return;
    }
    ved.c("DoodleEmojiManager", "requestPoiFaces callback is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkcd
 * JD-Core Version:    0.7.0.1
 */