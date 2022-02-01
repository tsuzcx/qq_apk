import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.widget.ProfileCardFavorItemDetailView;

public class bhgv
  extends TextView
{
  public bhgv(ProfileCardFavorItemDetailView paramProfileCardFavorItemDetailView, Context paramContext, Drawable paramDrawable, String paramString, int paramInt)
  {
    super(paramContext);
    setTextSize(1, 11.0F);
    setTextColor(-1);
    if (paramDrawable != null)
    {
      paramProfileCardFavorItemDetailView = "[icon] " + paramString;
      int i = (int)(AIOUtils.dp2px(11.0F, getResources()) * 0.8D + 0.5D);
      paramDrawable.setBounds(0, 0, i, i);
      paramProfileCardFavorItemDetailView = new SpannableString(paramProfileCardFavorItemDetailView);
      paramProfileCardFavorItemDetailView.setSpan(new ImageSpan(paramDrawable, 1), 0, 6, 17);
    }
    for (;;)
    {
      setText(paramProfileCardFavorItemDetailView);
      paramProfileCardFavorItemDetailView = new GradientDrawable();
      paramProfileCardFavorItemDetailView.setColor(paramInt);
      paramProfileCardFavorItemDetailView.setCornerRadius(8.0F);
      setBackgroundDrawable(paramProfileCardFavorItemDetailView);
      setPadding(AIOUtils.dp2px(4.0F, getResources()), 0, AIOUtils.dp2px(4.0F, getResources()), 0);
      setLayoutParams(new ViewGroup.LayoutParams(-2, AIOUtils.dp2px(15.0F, getResources())));
      return;
      paramProfileCardFavorItemDetailView = new SpannableString(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhgv
 * JD-Core Version:    0.7.0.1
 */