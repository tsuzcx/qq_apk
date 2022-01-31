import android.text.TextUtils;
import android.widget.TextView;

public class bgot
{
  public static void a(TextView paramTextView, int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramTextView, paramInt1, paramInt2, paramInt3, 99, null);
  }
  
  public static void a(TextView paramTextView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    if (paramTextView == null) {
      return;
    }
    paramString = "";
    switch (paramInt1)
    {
    default: 
      paramInt1 = 0;
      if (paramString == null) {
        paramString = "";
      }
      break;
    }
    for (;;)
    {
      if ((TextUtils.isEmpty(paramString)) && (paramInt1 == 0))
      {
        paramTextView.setVisibility(8);
        return;
        if (paramInt3 > 0) {}
        for (paramInt1 = paramInt3;; paramInt1 = 2130840947)
        {
          if (paramInt2 <= paramInt4) {
            break label104;
          }
          paramString = String.valueOf(paramInt4) + "+";
          break;
        }
        label104:
        paramString = String.valueOf(paramInt2);
        break;
      }
      Object localObject = paramTextView.getTag(2131370613);
      if (localObject == null) {}
      for (;;)
      {
        paramTextView.setBackgroundResource(paramInt1);
        if (!a(paramTextView.getText().toString(), paramString))
        {
          paramTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
          paramTextView.setText(paramString);
        }
        paramTextView.setVisibility(0);
        return;
        if ((!(localObject instanceof Integer)) || (((Integer)localObject).intValue() != 0))
        {
          paramTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
          paramTextView.setTag(2131370613, Integer.valueOf(0));
          paramTextView.setText(paramString);
          paramTextView.setPadding(0, 0, 0, 0);
        }
      }
    }
  }
  
  public static boolean a(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgot
 * JD-Core Version:    0.7.0.1
 */