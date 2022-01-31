import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.widget.VerticalCenterImageSpan;
import java.util.ArrayList;
import java.util.List;

public class aqec
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private List<aqcj> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  public aqec(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private int a(float paramFloat, int paramInt)
  {
    return (Math.min(255, Math.max(0, (int)(255.0F * paramFloat))) << 24) + (0xFFFFFF & paramInt);
  }
  
  private ColorStateList a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return new ColorStateList(new int[][] { { 16842919, 16842910 }, { 16842910, 16842908 }, { 16842910 }, { 16842908 }, { 16842909 }, new int[0] }, new int[] { paramInt2, paramInt3, paramInt1, paramInt3, paramInt4, paramInt1 });
  }
  
  private Drawable a(int paramInt)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    localGradientDrawable.setCornerRadius(25.0F);
    localGradientDrawable.setColor(paramInt);
    if (this.jdField_a_of_type_Boolean) {
      localGradientDrawable.setStroke(1, -1);
    }
    return localGradientDrawable;
  }
  
  private Drawable a(int paramInt1, int paramInt2)
  {
    StateListDrawable localStateListDrawable = new StateListDrawable();
    Drawable localDrawable = a(paramInt1);
    localStateListDrawable.addState(new int[] { 16842919 }, localDrawable);
    localDrawable = a(paramInt1);
    localStateListDrawable.addState(new int[] { 16842908 }, localDrawable);
    localDrawable = a(paramInt1);
    localStateListDrawable.addState(new int[] { 16842913 }, localDrawable);
    localDrawable = a(paramInt2);
    localStateListDrawable.addState(new int[0], localDrawable);
    return localStateListDrawable;
  }
  
  private SpannableString a(Drawable paramDrawable)
  {
    SpannableString localSpannableString = new SpannableString(" ");
    int i = aepi.a(11.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    paramDrawable.setBounds(0, 0, i, i);
    localSpannableString.setSpan(new VerticalCenterImageSpan(paramDrawable, 0), 0, 1, 33);
    return localSpannableString;
  }
  
  public aqcj a(int paramInt)
  {
    return (aqcj)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(List<aqcj> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    aqcj localaqcj;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560946, null, false);
      paramViewGroup = new aqed(this);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378776));
      paramView.setTag(paramViewGroup);
      localaqcj = a(paramInt);
      if (localaqcj != null)
      {
        paramViewGroup.jdField_a_of_type_Int = paramInt;
        SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
        if (localaqcj.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
          localSpannableStringBuilder.append(a(localaqcj.jdField_a_of_type_AndroidGraphicsDrawableDrawable));
        }
        if (!TextUtils.isEmpty(localaqcj.jdField_a_of_type_JavaLangString)) {
          localSpannableStringBuilder.append(localaqcj.jdField_a_of_type_JavaLangString);
        }
        TextView localTextView = paramViewGroup.jdField_a_of_type_AndroidWidgetTextView;
        Object localObject = localSpannableStringBuilder;
        if (TextUtils.isEmpty(localSpannableStringBuilder)) {
          localObject = "";
        }
        localTextView.setText((CharSequence)localObject);
        if (!TextUtils.isEmpty(localaqcj.b)) {
          break label216;
        }
        paramInt = Color.parseColor("#FF80BF");
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(a(a(0.2F, paramInt), a(0.2F, paramInt)));
      }
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a(paramInt, paramInt, paramInt, paramInt));
      return paramView;
      paramViewGroup = (aqed)paramView.getTag();
      break;
      label216:
      paramInt = Color.parseColor(localaqcj.b);
      if (TextUtils.isEmpty(localaqcj.c)) {
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(a(a(0.2F, paramInt), a(0.2F, paramInt)));
      } else {
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(a(Color.parseColor(localaqcj.c), Color.parseColor(localaqcj.c)));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqec
 * JD-Core Version:    0.7.0.1
 */