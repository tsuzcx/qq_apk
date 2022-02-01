import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.widget.BubblePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/profilecard/bussiness/personalitysign/utils/UiUtils$Companion;", "", "()V", "createContent", "Landroid/widget/TextView;", "ctx", "Landroid/content/Context;", "showProfileSignGuideAsDropDown", "", "view", "Landroid/view/View;", "xoff", "", "yoff", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class babv
{
  private final TextView a(Context paramContext)
  {
    paramContext = new TextView(paramContext);
    int i = ViewUtils.dpToPx(5.0F);
    paramContext.setPadding(i, 0, i, 0);
    paramContext.setTextColor(-1);
    paramContext.setGravity(17);
    paramContext.setText(2131707943);
    return paramContext;
  }
  
  public final void a(@NotNull View paramView, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    BubblePopupWindow localBubblePopupWindow = new BubblePopupWindow(-2, -2);
    babv localbabv = (babv)this;
    Context localContext = paramView.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "view.context");
    localBubblePopupWindow.a((View)localbabv.a(localContext));
    localBubblePopupWindow.a(null);
    localBubblePopupWindow.a((Drawable)new ColorDrawable(0));
    localBubblePopupWindow.c(true);
    localBubblePopupWindow.a(false);
    localBubblePopupWindow.a(paramView, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     babv
 * JD-Core Version:    0.7.0.1
 */