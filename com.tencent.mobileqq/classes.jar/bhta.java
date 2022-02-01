import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.config.business.qvip.QVipFeatureSwitchConfig;
import com.tencent.mobileqq.vas.troopnick.TroopNickResDrawable;
import com.tencent.mobileqq.widget.ColorClearableEditText;
import com.tencent.mobileqq.widget.ColorNickTextView;
import mqq.app.AppRuntime;

public class bhta
{
  private static void a(TextView paramTextView)
  {
    if ((paramTextView instanceof ColorNickTextView)) {
      ((ColorNickTextView)paramTextView).b();
    }
    while (!(paramTextView instanceof ColorClearableEditText)) {
      return;
    }
    ((ColorClearableEditText)paramTextView).b();
  }
  
  private static void a(TextView paramTextView, int paramInt1, int paramInt2)
  {
    Object localObject = bhsz.a(paramInt1, paramInt2);
    if (localObject != null)
    {
      paramTextView.setTypeface((Typeface)localObject);
      return;
    }
    localObject = BaseApplicationImpl.getApplication().getRuntime();
    bhpm localbhpm = new bhpm((AppRuntime)localObject, paramInt1);
    localbhpm.a(new bhsz(paramTextView, localbhpm, (AppRuntime)localObject, paramInt2));
  }
  
  public static void a(TextView paramTextView, Context paramContext, int paramInt, boolean paramBoolean)
  {
    if (paramTextView == null) {
      return;
    }
    if ((arkg.a() != null) && (!arkg.a().isTroopNickEnable()))
    {
      b(paramTextView);
      return;
    }
    if ((paramInt <= 0) || (paramContext == null))
    {
      b(paramTextView);
      return;
    }
    Object localObject = paramTextView.getBackground();
    if (((localObject instanceof TroopNickResDrawable)) && (((TroopNickResDrawable)localObject).a() == paramInt)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        paramContext = new TroopNickResDrawable(paramContext, paramInt);
        localObject = new bhsx(paramContext);
        if (paramBoolean) {
          ((bhsx)localObject).a(true);
        }
        paramContext.a((bhpt)localObject);
        paramTextView.setBackgroundDrawable(paramContext);
        paramContext.a(new bhtb(paramTextView));
        a(paramTextView, ((bhsx)localObject).a, ((bhsx)localObject).b);
      }
      a(paramTextView);
      return;
    }
  }
  
  private static void b(TextView paramTextView)
  {
    paramTextView.setTypeface(Typeface.DEFAULT);
    paramTextView.setBackgroundDrawable(null);
    paramTextView.setPadding(0, 0, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhta
 * JD-Core Version:    0.7.0.1
 */