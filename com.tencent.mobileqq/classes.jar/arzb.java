import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.debug.VasAdvDebugFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "isChecked", "", "onCheckedChanged", "com/tencent/mobileqq/debug/VasAdvDebugFragment$initView$1$1"}, k=3, mv={1, 1, 16})
public final class arzb
  implements CompoundButton.OnCheckedChangeListener
{
  public arzb(VasAdvDebugFragment paramVasAdvDebugFragment) {}
  
  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    VasAdvDebugFragment.a(this.a, paramBoolean);
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arzb
 * JD-Core Version:    0.7.0.1
 */