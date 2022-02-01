import android.content.res.ColorStateList;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.profile.view.ClickPreventableTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;

public class bbwq
  extends ClickableSpan
  implements bbwr
{
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  private bbws jdField_a_of_type_Bbws;
  private Object jdField_a_of_type_JavaLangObject;
  private boolean jdField_a_of_type_Boolean;
  private ColorStateList jdField_b_of_type_AndroidContentResColorStateList;
  private boolean jdField_b_of_type_Boolean;
  
  public bbwq(bbws parambbws, ColorStateList paramColorStateList1, ColorStateList paramColorStateList2, Object paramObject)
  {
    this.jdField_a_of_type_Bbws = parambbws;
    this.jdField_a_of_type_AndroidContentResColorStateList = paramColorStateList1;
    this.jdField_b_of_type_AndroidContentResColorStateList = paramColorStateList2;
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public bbwq(bbws parambbws, ColorStateList paramColorStateList, Object paramObject)
  {
    this(parambbws, paramColorStateList, null, paramObject);
  }
  
  public Object a()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ClickColorTopicSpan", 2, String.format("setPressed %b", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    if (this.jdField_a_of_type_Boolean != paramBoolean)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      paramView.invalidate();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean != paramBoolean) {
      this.jdField_b_of_type_Boolean = paramBoolean;
    }
  }
  
  public void onClick(View paramView)
  {
    if ((paramView instanceof ClickPreventableTextView)) {
      if (!((ClickPreventableTextView)paramView).a()) {}
    }
    while (this.jdField_a_of_type_Bbws == null)
    {
      return;
      ((ClickPreventableTextView)paramView).a();
    }
    this.jdField_a_of_type_Bbws.a(this, paramView);
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((this.jdField_a_of_type_JavaLangObject instanceof Pair))
    {
      Pair localPair = (Pair)this.jdField_a_of_type_JavaLangObject;
      localStringBuilder.append("id=").append(localPair.first).append(",");
      localStringBuilder.append("topic=").append((String)localPair.second).append(",");
    }
    return localStringBuilder.toString();
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    paramTextPaint.setUnderlineText(false);
    if (this.jdField_a_of_type_AndroidContentResColorStateList != null) {
      if (this.jdField_a_of_type_Boolean)
      {
        i = this.jdField_a_of_type_AndroidContentResColorStateList.getColorForState(new int[] { 16842919 }, 0);
        paramTextPaint.setColor(i);
        label54:
        if (this.jdField_b_of_type_AndroidContentResColorStateList == null) {
          break label130;
        }
        if (!this.jdField_a_of_type_Boolean) {
          break label115;
        }
      }
    }
    label115:
    for (int i = this.jdField_b_of_type_AndroidContentResColorStateList.getColorForState(new int[] { 16842919 }, 0);; i = this.jdField_b_of_type_AndroidContentResColorStateList.getColorForState(new int[0], 0))
    {
      paramTextPaint.bgColor = i;
      return;
      i = this.jdField_a_of_type_AndroidContentResColorStateList.getColorForState(new int[0], 0);
      break;
      paramTextPaint.setColor(-16777216);
      break label54;
    }
    label130:
    paramTextPaint.bgColor = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbwq
 * JD-Core Version:    0.7.0.1
 */