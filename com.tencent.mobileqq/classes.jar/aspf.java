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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.widget.VerticalCenterImageSpan;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class aspf
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private List<asnc> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  public aspf(Context paramContext)
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
    int i = AIOUtils.dp2px(11.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    paramDrawable.setBounds(0, 0, i, i);
    localSpannableString.setSpan(new VerticalCenterImageSpan(paramDrawable, 0), 0, 1, 33);
    return localSpannableString;
  }
  
  public asnc a(int paramInt)
  {
    return (asnc)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(List<asnc> paramList)
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
    View localView;
    asnc localasnc;
    Object localObject;
    int i;
    if (paramView == null)
    {
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131561127, null, false);
      paramView = new aspg(this);
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131379911));
      localView.setTag(paramView);
      localasnc = a(paramInt);
      if (localasnc != null)
      {
        paramView.jdField_a_of_type_Int = paramInt;
        SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
        if (localasnc.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
          localSpannableStringBuilder.append(a(localasnc.jdField_a_of_type_AndroidGraphicsDrawableDrawable));
        }
        if (!TextUtils.isEmpty(localasnc.jdField_a_of_type_JavaLangString)) {
          localSpannableStringBuilder.append(localasnc.jdField_a_of_type_JavaLangString);
        }
        TextView localTextView = paramView.jdField_a_of_type_AndroidWidgetTextView;
        localObject = localSpannableStringBuilder;
        if (TextUtils.isEmpty(localSpannableStringBuilder)) {
          localObject = "";
        }
        localTextView.setText((CharSequence)localObject);
        if (!TextUtils.isEmpty(localasnc.b)) {
          break label249;
        }
        i = Color.parseColor("#FF80BF");
        paramView.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(a(a(0.2F, i), a(0.2F, i)));
      }
    }
    for (;;)
    {
      paramView.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a(i, i, i, i));
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (aspg)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label249:
      i = Color.parseColor(localasnc.b);
      if (TextUtils.isEmpty(localasnc.c)) {
        paramView.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(a(a(0.2F, i), a(0.2F, i)));
      } else {
        paramView.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(a(Color.parseColor(localasnc.c), Color.parseColor(localasnc.c)));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aspf
 * JD-Core Version:    0.7.0.1
 */