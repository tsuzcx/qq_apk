import android.arch.lifecycle.Observer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "it", "onChanged", "(Ljava/lang/Object;)V"}, k=3, mv={1, 1, 16})
final class axtw<T>
  implements Observer<T>
{
  axtw(Function1 paramFunction1) {}
  
  public final void onChanged(@Nullable T paramT)
  {
    if (paramT != null) {
      this.a.invoke(paramT);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axtw
 * JD-Core Version:    0.7.0.1
 */