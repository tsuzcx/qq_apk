import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class auwk
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private auwl jdField_a_of_type_Auwl;
  private List<bahx> jdField_a_of_type_JavaUtilList;
  
  public auwk(Context paramContext, List<bahx> paramList)
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
    if (this.jdField_a_of_type_Auwl == null) {
      this.jdField_a_of_type_Auwl = new auwl(paramViewGroup.getContext());
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
      QLog.e("ShareActionSheet", 2, "ShareActionSheet.ActionSheetItemAdapter.getView() getItem(" + paramInt + ") == null !!!");
      return paramView;
      paramViewGroup = (baia)paramView.getTag();
    }
    paramView.setId(paramViewGroup.jdField_a_of_type_Bahx.jdField_a_of_type_Int);
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(auwi.a(paramViewGroup.jdField_a_of_type_Bahx.jdField_a_of_type_JavaLangString, 6));
    paramInt = -8947849;
    Object localObject = paramViewGroup.jdField_a_of_type_AndroidWidgetTextView;
    if (paramViewGroup.jdField_a_of_type_Bahx.c)
    {
      ((TextView)localObject).setTextColor(paramInt);
      if (!paramViewGroup.jdField_a_of_type_Bahx.jdField_b_of_type_Boolean) {
        break label454;
      }
      if (paramViewGroup.jdField_a_of_type_Bahx.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
        break label397;
      }
      localObject = paramViewGroup.jdField_a_of_type_Bahx.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      label262:
      paramInt = ((Drawable)localObject).getIntrinsicWidth();
      int j = ((Drawable)localObject).getIntrinsicHeight();
      if (this.jdField_a_of_type_Int <= paramInt) {
        break label416;
      }
      paramInt = (int)((this.jdField_a_of_type_Int - paramInt) / 2.0F);
      label294:
      if (this.jdField_a_of_type_Int > j) {
        i = (int)((this.jdField_a_of_type_Int - j) / 2.0F);
      }
      localObject = this.jdField_a_of_type_Auwl.a((Drawable)localObject, paramInt, i);
      if (!paramViewGroup.jdField_a_of_type_Bahx.c) {
        break label421;
      }
      Drawable localDrawable = auwl.a(this.jdField_a_of_type_Auwl, (Drawable)localObject);
      localObject = this.jdField_a_of_type_Auwl.a((Drawable)localObject, localDrawable);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT < 16) {
        break label444;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackground(null);
      return paramView;
      paramInt = 2138535799;
      break;
      label397:
      localObject = this.jdField_a_of_type_AndroidContentResResources.getDrawable(paramViewGroup.jdField_a_of_type_Bahx.jdField_b_of_type_Int);
      break label262;
      label416:
      paramInt = 0;
      break label294;
      label421:
      localObject = auwl.b(this.jdField_a_of_type_Auwl, (Drawable)localObject);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    }
    label444:
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
    return paramView;
    label454:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     auwk
 * JD-Core Version:    0.7.0.1
 */