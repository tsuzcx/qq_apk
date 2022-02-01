import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import com.tencent.mobileqq.nearby.profilecard.LabelContainer;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class ayjw
{
  public static final int[] a;
  public static final String[] a;
  public static final int[] b;
  public static final String[] b;
  public static final String[] c = { anzj.a(2131704877), anzj.a(2131704879), anzj.a(2131704873), anzj.a(2131704878), anzj.a(2131704876), anzj.a(2131704874), anzj.a(2131704875) };
  public static final String[] d = { "0X800554B", "0X800554C", "0X800554D", "0X800554E", "0X800554F", "0X8005550", "0X8005551" };
  protected Context a;
  protected LayoutInflater a;
  protected LinearLayout a;
  protected ayaw a;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 5, 6, 7, 1, 2, 3, 4, 8 };
    jdField_b_of_type_ArrayOfInt = new int[] { 2130841357, 2130841366, 2130841352, 2130841360, 2130841348, 2130841342, 2130841365 };
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "#F1F1F5", "#F1F1F5", "#F1F1F5", "#F1F1F5", "#F1F1F5", "#F1F1F5", "#F1F1F5", "#DCEBFF" };
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { "#777777", "#777777", "#777777", "#777777", "#777777", "#777777", "#777777", "#4B83D3" };
  }
  
  public static int a(int paramInt)
  {
    int i = 0;
    while (i < jdField_a_of_type_ArrayOfInt.length)
    {
      if (paramInt == jdField_a_of_type_ArrayOfInt[i]) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  protected abstract int a();
  
  protected View a(int paramInt1, ayaw paramayaw, int paramInt2)
  {
    View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(a(), this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
    a(paramInt1, a(localView, paramInt1, paramayaw, paramInt2), paramayaw.jdField_a_of_type_JavaUtilArrayList);
    return localView;
  }
  
  protected abstract LabelContainer a(View paramView, int paramInt1, ayaw paramayaw, int paramInt2);
  
  protected void a(int paramInt, LabelContainer paramLabelContainer, ArrayList<InterestTagInfo> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    for (;;)
    {
      return;
      int j = zft.b(this.jdField_a_of_type_AndroidContentContext, 10.0F);
      int k = zft.b(this.jdField_a_of_type_AndroidContentContext, 5.0F);
      int m = zft.b(this.jdField_a_of_type_AndroidContentContext, 2.0F);
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        InterestTagInfo localInterestTagInfo = (InterestTagInfo)paramArrayList.next();
        TextView localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
        localTextView.setIncludeFontPadding(false);
        localTextView.setTextSize(1, 14.0F);
        localTextView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        GradientDrawable localGradientDrawable = new GradientDrawable();
        localGradientDrawable.setColor(Color.parseColor(jdField_a_of_type_ArrayOfJavaLangString[paramInt]));
        localGradientDrawable.setCornerRadius(m);
        localTextView.setBackgroundDrawable(localGradientDrawable);
        localTextView.setTextColor(Color.parseColor(jdField_b_of_type_ArrayOfJavaLangString[paramInt]));
        if (this.jdField_a_of_type_Ayaw != null)
        {
          int i = 0;
          while (i < this.jdField_a_of_type_Ayaw.jdField_a_of_type_JavaUtilArrayList.size())
          {
            if (((InterestTagInfo)this.jdField_a_of_type_Ayaw.jdField_a_of_type_JavaUtilArrayList.get(i)).tagName.equals(localInterestTagInfo.tagName))
            {
              localTextView.setTextColor(Color.parseColor(jdField_b_of_type_ArrayOfJavaLangString[7]));
              localTextView.setBackgroundColor(Color.parseColor(jdField_a_of_type_ArrayOfJavaLangString[7]));
              this.jdField_a_of_type_Ayaw.jdField_a_of_type_JavaUtilArrayList.remove(i);
            }
            i += 1;
          }
        }
        if (localInterestTagInfo.tagName != null)
        {
          localInterestTagInfo.tagName = localInterestTagInfo.tagName.replaceAll("\005", "");
          localInterestTagInfo.tagName = localInterestTagInfo.tagName.replaceAll("\006", "");
        }
        localTextView.setText(localInterestTagInfo.tagName);
        localTextView.setPadding(j, k, j, k);
        localTextView.setGravity(17);
        paramLabelContainer.addView(localTextView);
      }
    }
  }
  
  public void a(Context paramContext, LinearLayout paramLinearLayout)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = paramLinearLayout;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  public void a(ayaw paramayaw)
  {
    this.jdField_a_of_type_Ayaw = paramayaw;
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public boolean a(ayaw[] paramArrayOfayaw)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    boolean bool2;
    if ((paramArrayOfayaw == null) || (paramArrayOfayaw.length == 0)) {
      bool2 = false;
    }
    int i;
    boolean bool1;
    do
    {
      return bool2;
      i = 0;
      bool1 = false;
      bool2 = bool1;
    } while (i >= jdField_a_of_type_ArrayOfInt.length);
    int j = 0;
    for (;;)
    {
      bool2 = bool1;
      if (j < paramArrayOfayaw.length)
      {
        if ((jdField_a_of_type_ArrayOfInt[i] == paramArrayOfayaw[j].jdField_a_of_type_Int) && ((a()) || ((paramArrayOfayaw[j].jdField_a_of_type_JavaUtilArrayList != null) && (paramArrayOfayaw[j].jdField_a_of_type_JavaUtilArrayList.size() > 0))))
        {
          View localView = a(i, paramArrayOfayaw[j], paramArrayOfayaw.length);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
          bool2 = true;
        }
      }
      else
      {
        i += 1;
        bool1 = bool2;
        break;
      }
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayjw
 * JD-Core Version:    0.7.0.1
 */