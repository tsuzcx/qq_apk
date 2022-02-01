import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public final class bmrk
  extends ReportDialog
{
  private long jdField_a_of_type_Long;
  private final View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private final boolean jdField_a_of_type_Boolean;
  private final View.OnClickListener b;
  
  private bmrk(bmrn parambmrn)
  {
    super(bmrn.a(parambmrn), 2131755326);
    Object localObject3 = new LinearLayout(bmrn.a(parambmrn));
    ((LinearLayout)localObject3).setOrientation(1);
    ((LinearLayout)localObject3).setBackgroundColor(-1);
    ((LinearLayout)localObject3).setBackgroundDrawable(bmrb.a(-1, bhgr.a(bmrn.a(parambmrn), 4.0F)));
    int i = bhgr.a(bmrn.a(parambmrn), 25.0F);
    ((LinearLayout)localObject3).setPadding(i, i, i, i);
    Object localObject4 = new LinearLayout.LayoutParams(-1, -2);
    ((LinearLayout.LayoutParams)localObject4).gravity = 17;
    ((LinearLayout.LayoutParams)localObject4).setMargins(bhgr.a(bmrn.a(parambmrn), 30.0F), 0, bhgr.a(bmrn.a(parambmrn), 30.0F), 0);
    TextView localTextView = new TextView(bmrn.a(parambmrn));
    Object localObject1 = new LinearLayout.LayoutParams(-2, -2);
    localTextView.setTextColor(-16777216);
    localTextView.setTextSize(2, 16.0F);
    localTextView.setTypeface(Typeface.DEFAULT_BOLD);
    ((LinearLayout)localObject3).addView(localTextView, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new TextView(bmrn.a(parambmrn));
    Object localObject2 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject2).setMargins(bhgr.a(bmrn.a(parambmrn), 16.5F), 0, 0, bhgr.a(bmrn.a(parambmrn), 18.5F));
    ((TextView)localObject1).setTextColor(-16777216);
    ((LinearLayout)localObject3).addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    Object localObject5 = new LinearLayout(bmrn.a(parambmrn));
    ((LinearLayout)localObject5).setOrientation(0);
    ((LinearLayout)localObject5).setGravity(17);
    Object localObject6 = new LinearLayout.LayoutParams(-1, -2);
    ((LinearLayout.LayoutParams)localObject6).setMargins(bhgr.a(bmrn.a(parambmrn), -5.0F), 0, bhgr.a(bmrn.a(parambmrn), -5.0F), 0);
    localObject2 = new Button(bmrn.a(parambmrn));
    ((Button)localObject2).setBackgroundDrawable(bmrb.a(-13544, bhgr.a(bmrn.a(parambmrn), 3.0F)));
    i = bhgr.a(bmrn.a(parambmrn), 9.0F);
    ((Button)localObject2).setPadding(0, i, 0, i);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -2, 1.0F);
    localLayoutParams.setMargins(bhgr.a(bmrn.a(parambmrn), 5.0F), 0, bhgr.a(bmrn.a(parambmrn), 5.0F), 0);
    ((Button)localObject2).setGravity(17);
    ((Button)localObject2).setTextColor(-16777216);
    ((Button)localObject2).setTextSize(2, 14.0F);
    ((Button)localObject2).setTypeface(Typeface.DEFAULT_BOLD);
    ((LinearLayout)localObject5).addView((View)localObject2, localLayoutParams);
    Button localButton = new Button(bmrn.a(parambmrn));
    localButton.setBackgroundDrawable(bmrb.a(-1121584, bhgr.a(bmrn.a(parambmrn), 3.0F)));
    localButton.setPadding(0, i, 0, i);
    localButton.setGravity(17);
    localButton.setTextColor(-16777216);
    localButton.setTextSize(2, 14.0F);
    localButton.setTypeface(Typeface.DEFAULT_BOLD);
    ((LinearLayout)localObject5).addView(localButton, localLayoutParams);
    ((LinearLayout)localObject3).addView((View)localObject5, (ViewGroup.LayoutParams)localObject6);
    addContentView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
    this.jdField_a_of_type_Boolean = bmrn.a(parambmrn);
    localObject3 = bmrn.a(parambmrn);
    localObject4 = bmrn.b(parambmrn);
    localObject5 = bmrn.c(parambmrn);
    localObject6 = bmrn.d(parambmrn);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = bmrn.a(parambmrn);
    this.b = bmrn.b(parambmrn);
    boolean bool1 = bmrn.b(parambmrn);
    boolean bool2 = bmrn.c(parambmrn);
    if (!TextUtils.isEmpty((CharSequence)localObject3))
    {
      localTextView.setVisibility(0);
      localTextView.setText((CharSequence)localObject3);
      if (TextUtils.isEmpty((CharSequence)localObject4)) {
        break label721;
      }
      ((TextView)localObject1).setVisibility(0);
      ((TextView)localObject1).setText((CharSequence)localObject4);
      label631:
      if (TextUtils.isEmpty((CharSequence)localObject5)) {
        break label731;
      }
      ((Button)localObject2).setVisibility(0);
      ((Button)localObject2).setText((CharSequence)localObject5);
      ((Button)localObject2).setOnClickListener(new bmrl(this));
      label665:
      if (TextUtils.isEmpty((CharSequence)localObject6)) {
        break label741;
      }
      localButton.setVisibility(0);
      localButton.setText((CharSequence)localObject6);
      localButton.setOnClickListener(new bmrm(this));
    }
    for (;;)
    {
      setCancelable(bool1);
      setCanceledOnTouchOutside(bool2);
      return;
      localTextView.setVisibility(8);
      break;
      label721:
      ((TextView)localObject1).setVisibility(8);
      break label631;
      label731:
      ((Button)localObject2).setVisibility(8);
      break label665;
      label741:
      localButton.setVisibility(8);
    }
  }
  
  private boolean a()
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long < 500L) {
      return false;
    }
    this.jdField_a_of_type_Long = l;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmrk
 * JD-Core Version:    0.7.0.1
 */