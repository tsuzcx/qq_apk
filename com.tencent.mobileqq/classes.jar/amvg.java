import android.content.Context;
import android.widget.FrameLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.player.CMSPlayer.getFrameImage.1;
import com.tencent.mobileqq.apollo.player.CMSPlayer.recordAction.1;
import com.tencent.mobileqq.apollo.player.action.CMSAction;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/player/CMSPlayer;", "", "width", "", "height", "(II)V", "containerView", "Landroid/widget/FrameLayout;", "currentAction", "Lcom/tencent/mobileqq/apollo/player/action/CMSAction;", "density", "", "offScreenHeight", "destroy", "", "getFrameImage", "action", "timeOffset", "callback", "Lcom/tencent/mobileqq/apollo/player/GetFrameCallback;", "getRecordByKey", "", "recordKey", "getView", "Landroid/view/View;", "pause", "playAction", "listener", "Lcom/tencent/mobileqq/apollo/player/ICMSPlayerListener;", "recordAction", "resume", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public class amvg
{
  public static final amvh a;
  private final float jdField_a_of_type_Float = DeviceInfoUtil.getDesity();
  private final int jdField_a_of_type_Int;
  private final FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout((Context)BaseApplicationImpl.getApplication());
  private final float jdField_b_of_type_Float;
  private final int jdField_b_of_type_Int;
  
  static
  {
    jdField_a_of_type_Amvh = new amvh(null);
  }
  
  public amvg(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = amvh.a(jdField_a_of_type_Amvh, paramInt1, this.jdField_a_of_type_Float);
    this.jdField_b_of_type_Int = amvh.a(jdField_a_of_type_Amvh, paramInt2, this.jdField_a_of_type_Float);
    this.jdField_b_of_type_Float = anmk.a();
  }
  
  public final void a(@NotNull CMSAction paramCMSAction, float paramFloat, @NotNull amvj paramamvj)
  {
    Intrinsics.checkParameterIsNotNull(paramCMSAction, "action");
    Intrinsics.checkParameterIsNotNull(paramamvj, "callback");
    amve.a.b((Function0)new CMSPlayer.getFrameImage.1(this, paramCMSAction, paramFloat, paramamvj));
  }
  
  public final void a(@Nullable String paramString, @NotNull CMSAction paramCMSAction, @Nullable amvk paramamvk)
  {
    Intrinsics.checkParameterIsNotNull(paramCMSAction, "action");
    amve.a.b((Function0)new CMSPlayer.recordAction.1(this, paramCMSAction, paramString, paramamvk));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amvg
 * JD-Core Version:    0.7.0.1
 */