import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class bahy
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private bahz jdField_a_of_type_Bahz;
  private List<bahx> jdField_a_of_type_JavaUtilList;
  
  public bahy(Context paramContext, List<bahx> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  public bahx a(int paramInt)
  {
    bahx localbahx;
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramInt < 0))
    {
      localbahx = null;
      return localbahx;
    }
    int j = -1;
    int i = 0;
    for (;;)
    {
      if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
        break label89;
      }
      localbahx = (bahx)this.jdField_a_of_type_JavaUtilList.get(i);
      int k = j;
      if (localbahx != null)
      {
        k = j;
        if (localbahx.d == 0) {
          k = j + 1;
        }
      }
      if (k == paramInt) {
        break;
      }
      i += 1;
      j = k;
    }
    label89:
    return null;
  }
  
  protected bahz a(Context paramContext)
  {
    return new bahz(paramContext);
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      bahx localbahx = (bahx)localIterator.next();
      if ((localbahx == null) || (localbahx.d != 0)) {
        break label60;
      }
      i += 1;
    }
    label60:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = 0;
    if (this.jdField_a_of_type_AndroidContentResResources == null) {
      this.jdField_a_of_type_AndroidContentResResources = paramViewGroup.getContext().getResources();
    }
    if (this.jdField_a_of_type_Int == 0) {
      this.jdField_a_of_type_Int = ((int)this.jdField_a_of_type_AndroidContentResResources.getDimension(2131165597));
    }
    if (this.jdField_a_of_type_Bahz == null) {
      this.jdField_a_of_type_Bahz = a(paramViewGroup.getContext());
    }
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131493268, paramViewGroup, false);
      paramViewGroup = new baia();
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131310239));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131310240));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_Bahx = a(paramInt);
      if (paramViewGroup.jdField_a_of_type_Bahx != null) {
        break;
      }
      QLog.e("ShareActionSheetBuilder", 2, "ShareActionSheetBuilder.ActionSheetItemAdapter.getView() getItem(" + paramInt + ") == null !!!");
      return paramView;
      paramViewGroup = (baia)paramView.getTag();
    }
    paramView.setId(paramViewGroup.jdField_a_of_type_Bahx.jdField_a_of_type_Int);
    float f = this.jdField_a_of_type_AndroidContentResResources.getDimension(2131165597);
    Object localObject1 = paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.getPaint();
    ((TextPaint)localObject1).setTextSize(this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131167717));
    Object localObject2 = paramViewGroup.jdField_a_of_type_AndroidWidgetTextView;
    String str = paramViewGroup.jdField_a_of_type_Bahx.jdField_a_of_type_JavaLangString;
    if (paramViewGroup.jdField_a_of_type_Bahx.e > 0)
    {
      paramInt = paramViewGroup.jdField_a_of_type_Bahx.e;
      ((TextView)localObject2).setText(bahv.a((TextPaint)localObject1, f, str, paramInt));
      paramInt = -8947849;
      localObject1 = paramViewGroup.jdField_a_of_type_AndroidWidgetTextView;
      if (!paramViewGroup.jdField_a_of_type_Bahx.c) {
        break label457;
      }
      label288:
      ((TextView)localObject1).setTextColor(paramInt);
      if (!paramViewGroup.jdField_a_of_type_Bahx.jdField_b_of_type_Boolean) {
        break label520;
      }
      if (paramViewGroup.jdField_a_of_type_Bahx.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
        break label463;
      }
      localObject1 = paramViewGroup.jdField_a_of_type_Bahx.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      label323:
      paramInt = ((Drawable)localObject1).getIntrinsicWidth();
      int j = ((Drawable)localObject1).getIntrinsicHeight();
      if (this.jdField_a_of_type_Int <= paramInt) {
        break label482;
      }
      paramInt = (int)((this.jdField_a_of_type_Int - paramInt) / 2.0F);
      label355:
      if (this.jdField_a_of_type_Int > j) {
        i = (int)((this.jdField_a_of_type_Int - j) / 2.0F);
      }
      localObject1 = this.jdField_a_of_type_Bahz.a((Drawable)localObject1, paramInt, i);
      if (!paramViewGroup.jdField_a_of_type_Bahx.c) {
        break label487;
      }
      localObject2 = bahz.a(this.jdField_a_of_type_Bahz, (Drawable)localObject1);
      localObject1 = this.jdField_a_of_type_Bahz.a((Drawable)localObject1, (Drawable)localObject2);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT < 16) {
        break label510;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackground(null);
      return paramView;
      paramInt = 5;
      break;
      label457:
      paramInt = 2138535799;
      break label288;
      label463:
      localObject1 = this.jdField_a_of_type_AndroidContentResResources.getDrawable(paramViewGroup.jdField_a_of_type_Bahx.jdField_b_of_type_Int);
      break label323;
      label482:
      paramInt = 0;
      break label355;
      label487:
      localObject1 = bahz.b(this.jdField_a_of_type_Bahz, (Drawable)localObject1);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
    }
    label510:
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
    return paramView;
    label520:
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837549);
    if (paramViewGroup.jdField_a_of_type_Bahx.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackground(paramViewGroup.jdField_a_of_type_Bahx.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        return paramView;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(paramViewGroup.jdField_a_of_type_Bahx.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      return paramView;
    }
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(paramViewGroup.jdField_a_of_type_Bahx.jdField_b_of_type_Int);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bahy
 * JD-Core Version:    0.7.0.1
 */