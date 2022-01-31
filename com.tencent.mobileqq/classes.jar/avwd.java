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

class avwd
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private avwe jdField_a_of_type_Avwe;
  private List<bbjs> jdField_a_of_type_JavaUtilList;
  
  public avwd(Context paramContext, List<bbjs> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  public bbjs a(int paramInt)
  {
    bbjs localbbjs;
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramInt < 0))
    {
      localbbjs = null;
      return localbbjs;
    }
    int j = -1;
    int i = 0;
    for (;;)
    {
      if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
        break label89;
      }
      localbbjs = (bbjs)this.jdField_a_of_type_JavaUtilList.get(i);
      int k = j;
      if (localbbjs != null)
      {
        k = j;
        if (localbbjs.d == 0) {
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
      bbjs localbbjs = (bbjs)localIterator.next();
      if ((localbbjs == null) || (localbbjs.d != 0)) {
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
      this.jdField_a_of_type_Int = ((int)this.jdField_a_of_type_AndroidContentResResources.getDimension(2131296669));
    }
    if (this.jdField_a_of_type_Avwe == null) {
      this.jdField_a_of_type_Avwe = new avwe(paramViewGroup.getContext());
    }
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558827, paramViewGroup, false);
      paramViewGroup = new bbjv();
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131376008));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376009));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_Bbjs = a(paramInt);
      if (paramViewGroup.jdField_a_of_type_Bbjs != null) {
        break;
      }
      QLog.e("ShareActionSheet", 2, "ShareActionSheet.ActionSheetItemAdapter.getView() getItem(" + paramInt + ") == null !!!");
      return paramView;
      paramViewGroup = (bbjv)paramView.getTag();
    }
    paramView.setId(paramViewGroup.jdField_a_of_type_Bbjs.jdField_a_of_type_Int);
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(avwb.a(paramViewGroup.jdField_a_of_type_Bbjs.jdField_a_of_type_JavaLangString, 6));
    paramInt = -8947849;
    Object localObject = paramViewGroup.jdField_a_of_type_AndroidWidgetTextView;
    if (paramViewGroup.jdField_a_of_type_Bbjs.c)
    {
      ((TextView)localObject).setTextColor(paramInt);
      if (!paramViewGroup.jdField_a_of_type_Bbjs.jdField_b_of_type_Boolean) {
        break label454;
      }
      if (paramViewGroup.jdField_a_of_type_Bbjs.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
        break label397;
      }
      localObject = paramViewGroup.jdField_a_of_type_Bbjs.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
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
      localObject = this.jdField_a_of_type_Avwe.a((Drawable)localObject, paramInt, i);
      if (!paramViewGroup.jdField_a_of_type_Bbjs.c) {
        break label421;
      }
      Drawable localDrawable = avwe.a(this.jdField_a_of_type_Avwe, (Drawable)localObject);
      localObject = this.jdField_a_of_type_Avwe.a((Drawable)localObject, localDrawable);
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
      localObject = this.jdField_a_of_type_AndroidContentResResources.getDrawable(paramViewGroup.jdField_a_of_type_Bbjs.jdField_b_of_type_Int);
      break label262;
      label416:
      paramInt = 0;
      break label294;
      label421:
      localObject = avwe.b(this.jdField_a_of_type_Avwe, (Drawable)localObject);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    }
    label444:
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
    return paramView;
    label454:
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837550);
    if (paramViewGroup.jdField_a_of_type_Bbjs.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackground(paramViewGroup.jdField_a_of_type_Bbjs.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        return paramView;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(paramViewGroup.jdField_a_of_type_Bbjs.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      return paramView;
    }
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(paramViewGroup.jdField_a_of_type_Bbjs.jdField_b_of_type_Int);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avwd
 * JD-Core Version:    0.7.0.1
 */