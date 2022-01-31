import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.lang.ref.WeakReference;
import java.util.Collections;

class bikr
  implements slx<szw, tbq>
{
  bikr(bikm parambikm, WeakReference paramWeakReference) {}
  
  public void a(@NonNull szw paramszw, @Nullable tbq paramtbq, @NonNull ErrorMessage paramErrorMessage)
  {
    if (paramtbq == null)
    {
      paramszw = (bikx)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramszw != null) {
        paramszw.a(paramErrorMessage.errorCode, Collections.EMPTY_LIST);
      }
      return;
    }
    paramszw = (bikx)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramszw != null)
    {
      paramszw.a(0, paramtbq.a);
      return;
    }
    urk.c("DoodleEmojiManager", "requestPoiFaces callback is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bikr
 * JD-Core Version:    0.7.0.1
 */