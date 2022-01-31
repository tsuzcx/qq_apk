import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;

public class auwq
  extends PopupWindow
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new auwr(this);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private auws jdField_a_of_type_Auws;
  private String jdField_a_of_type_JavaLangString;
  
  public auwq(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext);
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_Int = paramInt2;
    setWidth(this.jdField_a_of_type_Int);
    setHeight((int)(this.jdField_a_of_type_Float * 42.0F + 0.5D));
    View localView = LayoutInflater.from(paramContext).inflate(2131559448, null);
    setContentView(localView);
    a(paramContext, localView, paramInt1);
    setOutsideTouchable(true);
  }
  
  private void a(Context paramContext, View paramView, int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379129));
    this.jdField_a_of_type_AndroidWidgetTextView.getTextSize();
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363559));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramView.findViewById(2131368167).getLayoutParams();
    int i = (int)(10.0F * this.jdField_a_of_type_Float + 0.5D);
    if (paramInt <= 0) {
      localLayoutParams.leftMargin = 0;
    }
    for (;;)
    {
      paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      setBackgroundDrawable(paramContext.getResources().getDrawable(2130849999));
      return;
      if (paramInt < (this.jdField_a_of_type_Int - i) / 2)
      {
        localLayoutParams.leftMargin = ((int)((this.jdField_a_of_type_Float * 40.0F - i) / 2.0F) + paramInt);
      }
      else if (paramInt > paramContext.getResources().getDisplayMetrics().widthPixels - (int)(this.jdField_a_of_type_Float * 40.0F + 0.5D) - (this.jdField_a_of_type_Int - i) / 2)
      {
        int j = this.jdField_a_of_type_Int;
        localLayoutParams.leftMargin = ((int)((this.jdField_a_of_type_Float * 40.0F - i) / 2.0F) + (j + paramInt) - paramContext.getResources().getDisplayMetrics().widthPixels);
      }
      else
      {
        localLayoutParams.leftMargin = ((int)((this.jdField_a_of_type_Int - i) / 2 + 0.5D));
      }
    }
  }
  
  public void a(auws paramauws)
  {
    this.jdField_a_of_type_Auws = paramauws;
  }
  
  public void a(InterestTagInfo paramInterestTagInfo)
  {
    if (paramInterestTagInfo == null) {
      return;
    }
    if (!TextUtils.isEmpty(paramInterestTagInfo.tagName))
    {
      this.jdField_a_of_type_JavaLangString = paramInterestTagInfo.tagName;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_Long = paramInterestTagInfo.tagId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auwq
 * JD-Core Version:    0.7.0.1
 */