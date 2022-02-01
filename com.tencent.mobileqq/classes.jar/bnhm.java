import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.lang.ref.WeakReference;
import java.util.Collections;

class bnhm
  implements vqp<wen, wgh>
{
  bnhm(bnhh parambnhh, WeakReference paramWeakReference) {}
  
  public void a(@NonNull wen paramwen, @Nullable wgh paramwgh, @NonNull ErrorMessage paramErrorMessage)
  {
    if (paramwgh == null)
    {
      paramwen = (bnhs)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramwen != null) {
        paramwen.a(paramErrorMessage.errorCode, Collections.EMPTY_LIST);
      }
      return;
    }
    paramwen = (bnhs)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramwen != null)
    {
      paramwen.a(0, paramwgh.a);
      return;
    }
    xvv.c("DoodleEmojiManager", "requestPoiFaces callback is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnhm
 * JD-Core Version:    0.7.0.1
 */