package androidx.lifecycle;

import kotlin.Metadata;
import kotlinx.coroutines.channels.Channel;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "it", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V"}, k=3, mv={1, 1, 15})
final class FlowLiveDataConversions$asFlow$1$observer$1<T>
  implements Observer<T>
{
  FlowLiveDataConversions$asFlow$1$observer$1(Channel paramChannel) {}
  
  public final void onChanged(T paramT)
  {
    this.$channel.offer(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.lifecycle.FlowLiveDataConversions.asFlow.1.observer.1
 * JD-Core Version:    0.7.0.1
 */