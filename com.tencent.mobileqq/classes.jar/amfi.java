import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class amfi
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public amfi(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private amfk a(String paramString, Context paramContext)
  {
    int i = 0;
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "seed";
    }
    paramString = new amfk(null);
    String[] arrayOfString = paramContext.getResources().getStringArray(2130968660);
    paramContext = paramContext.getResources().getStringArray(2130968659);
    if (TextUtils.isEmpty(str)) {}
    for (;;)
    {
      paramString.a = arrayOfString[(i % arrayOfString.length)];
      paramString.b = paramContext[(i % paramContext.length)];
      return paramString;
      i = str.charAt(0);
    }
  }
  
  private ColorStateList a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int[] arrayOfInt1 = { 16842910 };
    int[] arrayOfInt2 = new int[0];
    return new ColorStateList(new int[][] { { 16842919, 16842910 }, { 16842910, 16842908 }, arrayOfInt1, { 16842908 }, { 16842909 }, arrayOfInt2 }, new int[] { paramInt2, paramInt3, paramInt1, paramInt3, paramInt4, paramInt1 });
  }
  
  private Drawable a(int paramInt)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    localGradientDrawable.setCornerRadius(25.0F);
    localGradientDrawable.setColor(paramInt);
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
  
  public String a(int paramInt)
  {
    return (String)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
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
    if (paramView == null)
    {
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131561127, null, false);
      paramView = new amfl();
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131379911));
      localView.setTag(paramView);
    }
    for (;;)
    {
      Object localObject = a(paramInt);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        paramView.jdField_a_of_type_Int = paramInt;
        paramView.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        localObject = a((String)localObject, this.jdField_a_of_type_AndroidContentContext);
        int i = Color.parseColor(((amfk)localObject).a);
        int j = Color.parseColor(((amfk)localObject).b);
        paramView.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
        paramView.jdField_a_of_type_AndroidWidgetTextView.setFocusable(false);
        paramView.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(a(j, j));
        paramView.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a(i, i, i, i));
      }
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (amfl)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amfi
 * JD-Core Version:    0.7.0.1
 */