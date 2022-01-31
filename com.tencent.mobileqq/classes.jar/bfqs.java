import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;

public class bfqs
{
  public static void a(Context paramContext, TextView paramTextView, int paramInt)
  {
    if ((paramTextView == null) || (paramInt == 0)) {
      return;
    }
    int i = paramContext.getResources().getDimensionPixelSize(2131296979);
    int j = paramContext.getResources().getDimensionPixelSize(2131296977);
    switch (paramInt)
    {
    case 4: 
    case 6: 
    default: 
      paramInt = j;
    }
    for (;;)
    {
      paramContext = (ViewGroup.MarginLayoutParams)paramTextView.getLayoutParams();
      if ((paramContext == null) || ((paramContext.leftMargin == i) && (paramContext.bottomMargin == paramInt))) {
        break;
      }
      paramContext.setMargins(i, 0, 0, paramInt);
      return;
      i = paramContext.getResources().getDimensionPixelSize(2131296979);
      paramInt = paramContext.getResources().getDimensionPixelSize(2131296977);
      paramTextView.measure(0, 0);
      int k = paramTextView.getMeasuredWidth();
      j = paramTextView.getMeasuredHeight();
      k /= 2;
      j /= 2;
      i -= k;
      paramInt -= j;
      continue;
      i = paramContext.getResources().getDimensionPixelSize(2131296979);
      paramInt = paramContext.getResources().getDimensionPixelSize(2131296977);
      paramTextView.measure(0, 0);
      k = paramTextView.getMeasuredWidth();
      j = paramTextView.getMeasuredHeight();
      k /= 2;
      j /= 2;
      i -= k;
      paramInt -= j;
      continue;
      i = paramContext.getResources().getDimensionPixelSize(2131296982);
      paramInt = paramContext.getResources().getDimensionPixelSize(2131296980);
      continue;
      i = paramContext.getResources().getDimensionPixelSize(2131296983);
      paramInt = paramContext.getResources().getDimensionPixelSize(2131296981);
      continue;
      k = paramContext.getResources().getDimensionPixelSize(2131296979);
      j = paramContext.getResources().getDimensionPixelSize(2131296978);
      paramTextView.measure(0, 0);
      paramInt = paramTextView.getMeasuredWidth();
      i = paramTextView.getMeasuredHeight();
      if (paramInt > i) {
        i = paramInt;
      }
      for (;;)
      {
        paramTextView.setWidth(i);
        paramTextView.setHeight(paramInt);
        i /= 2;
        paramInt /= 2;
        i = k - i;
        paramInt = j - paramInt;
        break;
        paramInt = i;
      }
      i = paramContext.getResources().getDimensionPixelSize(2131296982);
      paramInt = paramContext.getResources().getDimensionPixelSize(2131296980);
      continue;
      i = paramContext.getResources().getDimensionPixelSize(2131296982);
      paramInt = paramContext.getResources().getDimensionPixelSize(2131296980);
    }
  }
  
  public static void a(TextView paramTextView, int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramTextView, paramInt1, paramInt2, paramInt3, 99, null);
  }
  
  public static void a(TextView paramTextView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    if (paramTextView == null) {
      return;
    }
    switch (paramInt1)
    {
    default: 
      paramString = "";
      paramInt2 = 0;
      paramInt1 = 0;
      if (paramString == null) {
        paramString = "";
      }
      break;
    }
    for (;;)
    {
      if ((TextUtils.isEmpty(paramString)) && (paramInt1 == 0) && (paramInt2 == 0))
      {
        paramTextView.setVisibility(8);
        return;
        if (paramInt3 > 0)
        {
          paramString = "";
          paramInt1 = paramInt3;
          paramInt2 = 0;
          break;
        }
        paramString = "";
        paramInt1 = 2130849297;
        paramInt2 = 0;
        break;
        if (paramInt3 > 0) {}
        for (paramInt2 = paramInt3;; paramInt2 = 2130849301)
        {
          paramString = "NEW";
          paramInt1 = 0;
          break;
        }
        if (paramInt3 > 0)
        {
          paramString = "";
          paramInt1 = paramInt3;
          paramInt2 = 0;
          break;
        }
        paramString = "";
        paramInt1 = 2130849300;
        paramInt2 = 0;
        break;
        if (paramInt3 > 0) {}
        for (;;)
        {
          if (paramInt2 <= paramInt4) {
            break label219;
          }
          paramString = String.valueOf(paramInt4) + "+";
          paramInt1 = 0;
          paramInt2 = paramInt3;
          break;
          paramInt3 = 2130849301;
        }
        label219:
        paramString = String.valueOf(paramInt2);
        paramInt1 = 0;
        paramInt2 = paramInt3;
        break;
        if (paramInt3 > 0) {}
        for (;;)
        {
          if (paramInt2 <= 99) {
            break label259;
          }
          paramString = "";
          paramInt1 = 0;
          paramInt2 = paramInt3;
          break;
          paramInt3 = 2130849301;
        }
        label259:
        paramString = String.valueOf(paramInt2);
        paramInt1 = 0;
        paramInt2 = paramInt3;
        break;
        if (paramInt3 > 0) {}
        for (;;)
        {
          if (paramInt2 <= paramInt4) {
            break label320;
          }
          paramString = String.valueOf(paramInt4) + "+";
          paramInt1 = 0;
          paramInt2 = paramInt3;
          break;
          paramInt3 = 2130849301;
        }
        label320:
        paramString = String.valueOf(paramInt2);
        paramInt1 = 0;
        paramInt2 = paramInt3;
        break;
        if (paramInt3 > 0) {}
        for (paramInt2 = paramInt3;; paramInt2 = 2130849301)
        {
          if (!TextUtils.isEmpty(paramString)) {
            break label362;
          }
          paramString = "";
          paramInt1 = 0;
          break;
        }
        label362:
        paramInt1 = 0;
        break;
      }
      Object localObject = paramTextView.getTag(2131378655);
      if (((localObject == null) && (paramInt1 == 0)) || (((localObject instanceof Integer)) && (((Integer)localObject).intValue() == paramInt1))) {}
      for (;;)
      {
        paramTextView.setBackgroundResource(paramInt2);
        if (!bbbr.a(paramTextView.getText().toString(), paramString))
        {
          paramTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
          paramTextView.setText(paramString);
        }
        paramTextView.setVisibility(0);
        return;
        paramTextView.setCompoundDrawablesWithIntrinsicBounds(paramInt1, 0, 0, 0);
        paramTextView.setTag(2131378655, Integer.valueOf(paramInt1));
        paramTextView.setText(paramString);
        paramTextView.setPadding(0, 0, 0, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bfqs
 * JD-Core Version:    0.7.0.1
 */