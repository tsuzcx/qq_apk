import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class avqm
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private avqo jdField_a_of_type_Avqo;
  private List<avse> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public void a(avqo paramavqo)
  {
    this.jdField_a_of_type_Avqo = paramavqo;
  }
  
  public void a(List<avse> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = 0;
    TextView localTextView = (TextView)LayoutInflater.from(paramViewGroup.getContext()).inflate(2131561094, paramViewGroup, false);
    avse localavse = (avse)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject = localavse.a;
    paramView = (View)localObject;
    if (localObject != null)
    {
      paramView = (View)localObject;
      if (((String)localObject).length() > 9) {
        paramView = ((String)localObject).substring(0, 8) + "...";
      }
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramView);
    localSpannableStringBuilder.setSpan(new StyleSpan(1), 0, localSpannableStringBuilder.length(), 33);
    localObject = localavse.b;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localSpannableStringBuilder.append(" 回复 ");
      paramView = (View)localObject;
      if (((String)localObject).length() > 9) {
        paramView = ((String)localObject).substring(0, 8) + "...";
      }
      localSpannableStringBuilder.append(paramView);
      localSpannableStringBuilder.setSpan(new StyleSpan(1), localSpannableStringBuilder.length() - paramView.length(), localSpannableStringBuilder.length(), 33);
    }
    localSpannableStringBuilder.append("：").append(localavse.c);
    paramView = localTextView.getPaint();
    localObject = new ArrayList();
    if (this.jdField_a_of_type_Int == 0) {
      this.jdField_a_of_type_Int = (xsm.a(localTextView.getContext()) - xsm.a(localTextView.getContext(), 85.0F));
    }
    paramInt = 0;
    while (paramInt < localSpannableStringBuilder.length())
    {
      int j = i;
      if (paramView.measureText(localSpannableStringBuilder.subSequence(i, paramInt).toString()) > this.jdField_a_of_type_Int)
      {
        ((List)localObject).add(Integer.valueOf(paramInt - 1));
        j = paramInt;
      }
      paramInt += 1;
      i = j;
    }
    paramView = ((List)localObject).iterator();
    while (paramView.hasNext())
    {
      localObject = (Integer)paramView.next();
      if (((Integer)localObject).intValue() < localSpannableStringBuilder.length() - 1) {
        localSpannableStringBuilder.insert(((Integer)localObject).intValue(), "\n");
      }
    }
    localTextView.setText(localSpannableStringBuilder);
    localTextView.setMovementMethod(LinkMovementMethod.getInstance());
    localTextView.setOnClickListener(new avqn(this, paramViewGroup));
    return localTextView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avqm
 * JD-Core Version:    0.7.0.1
 */