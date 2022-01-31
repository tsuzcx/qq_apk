import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

public class axyu
{
  public static View a(Context paramContext, View paramView, acxn paramacxn, Bundle paramBundle)
  {
    paramacxn = paramContext.getResources();
    int i;
    label37:
    Object localObject;
    if (paramBundle.getInt("longMsgHolderType", -1) == 1)
    {
      i = 1;
      if ((paramView == null) || (!(paramView instanceof RelativeLayout))) {
        break label237;
      }
      ((RelativeLayout)paramView).removeAllViews();
      paramView = (RelativeLayout)paramView;
      paramView.setLayoutParams(new RelativeLayout.LayoutParams(-1, actn.a(75.0F, paramacxn)));
      paramBundle = new RelativeLayout(paramContext);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(13);
      paramView.addView(paramBundle, (ViewGroup.LayoutParams)localObject);
      localObject = new ImageView(paramContext);
      paramContext = new TextView(paramContext);
      if (i == 0) {
        break label249;
      }
      ((ImageView)localObject).setImageResource(2130841236);
      paramContext.setText(paramacxn.getString(2131696724));
    }
    for (;;)
    {
      ((ImageView)localObject).setId(2131376575);
      ((ImageView)localObject).setLayoutParams(new RelativeLayout.LayoutParams(actn.a(23.5F, paramacxn), actn.a(22.5F, paramacxn)));
      paramBundle.addView((View)localObject);
      paramContext.setTextSize(2, 14.0F);
      paramContext.setTextColor(Color.parseColor("#777777"));
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(1, 2131376575);
      ((RelativeLayout.LayoutParams)localObject).leftMargin = actn.a(7.5F, paramacxn);
      paramBundle.addView(paramContext, (ViewGroup.LayoutParams)localObject);
      return paramView;
      i = 0;
      break;
      label237:
      paramView = new RelativeLayout(paramContext);
      break label37;
      label249:
      ((ImageView)localObject).setImageResource(2130841235);
      paramContext.setText(paramacxn.getString(2131696723));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axyu
 * JD-Core Version:    0.7.0.1
 */