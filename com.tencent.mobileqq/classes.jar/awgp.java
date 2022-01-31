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
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.screendetect.ScreenShotFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import java.util.Iterator;
import java.util.List;

public class awgp
  extends BaseAdapter
  implements bfpt
{
  private int jdField_a_of_type_Int;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private awgq jdField_a_of_type_Awgq;
  private List<bbjs> jdField_a_of_type_JavaUtilList;
  
  public awgp(Context paramContext, List<bbjs> paramList)
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
    if (this.jdField_a_of_type_Awgq == null) {
      this.jdField_a_of_type_Awgq = new awgq(paramViewGroup.getContext());
    }
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558827, paramViewGroup, false);
      paramViewGroup = new awgr();
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131376008));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376009));
      paramView.setTag(paramViewGroup);
      paramView.setFocusable(true);
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_Bbjs = a(paramInt);
      if (paramViewGroup.jdField_a_of_type_Bbjs != null) {
        break;
      }
      QLog.e("ScreenShotFragment", 2, "ShareActionSheetBuilder.ActionSheetItemAdapter.getView() getItem(" + paramInt + ") == null !!!");
      return paramView;
      paramViewGroup = (awgr)paramView.getTag();
    }
    paramView.setId(paramViewGroup.jdField_a_of_type_Bbjs.jdField_a_of_type_Int);
    Object localObject1 = paramViewGroup.jdField_a_of_type_AndroidWidgetTextView;
    Object localObject2 = paramViewGroup.jdField_a_of_type_Bbjs.jdField_a_of_type_JavaLangString;
    if (paramViewGroup.jdField_a_of_type_Bbjs.e > 0)
    {
      paramInt = paramViewGroup.jdField_a_of_type_Bbjs.e;
      label227:
      ((TextView)localObject1).setText(ScreenShotFragment.a((String)localObject2, paramInt));
      paramInt = -8947849;
      localObject1 = paramViewGroup.jdField_a_of_type_AndroidWidgetTextView;
      if (!paramViewGroup.jdField_a_of_type_Bbjs.c) {
        break label456;
      }
      label257:
      ((TextView)localObject1).setTextColor(paramInt);
      if (!paramViewGroup.jdField_a_of_type_Bbjs.jdField_b_of_type_Boolean) {
        break label520;
      }
      if (paramViewGroup.jdField_a_of_type_Bbjs.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
        break label462;
      }
      localObject1 = paramViewGroup.jdField_a_of_type_Bbjs.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      label292:
      paramInt = ((Drawable)localObject1).getIntrinsicWidth();
      int j = ((Drawable)localObject1).getIntrinsicHeight();
      if (this.jdField_a_of_type_Int <= paramInt) {
        break label481;
      }
      paramInt = (int)((this.jdField_a_of_type_Int - paramInt) / 2.0F);
      label324:
      if (this.jdField_a_of_type_Int > j) {
        i = (int)((this.jdField_a_of_type_Int - j) / 2.0F);
      }
      localObject1 = this.jdField_a_of_type_Awgq.a((Drawable)localObject1, paramInt, i);
      if (!paramViewGroup.jdField_a_of_type_Bbjs.c) {
        break label486;
      }
      localObject2 = awgq.a(this.jdField_a_of_type_Awgq, (Drawable)localObject1);
      localObject1 = this.jdField_a_of_type_Awgq.a((Drawable)localObject1, (Drawable)localObject2);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      label403:
      if (Build.VERSION.SDK_INT < 16) {
        break label509;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackground(null);
      label419:
      if (!AppSetting.d) {
        break label596;
      }
      if (paramViewGroup.jdField_a_of_type_Bbjs.jdField_a_of_type_JavaLangString == null) {
        break label598;
      }
    }
    label456:
    label462:
    label596:
    label598:
    for (paramViewGroup = paramViewGroup.jdField_a_of_type_Bbjs.jdField_a_of_type_JavaLangString;; paramViewGroup = "")
    {
      paramView.setContentDescription(paramViewGroup);
      return paramView;
      paramInt = 6;
      break label227;
      paramInt = 2138535799;
      break label257;
      localObject1 = this.jdField_a_of_type_AndroidContentResResources.getDrawable(paramViewGroup.jdField_a_of_type_Bbjs.jdField_b_of_type_Int);
      break label292;
      label481:
      paramInt = 0;
      break label324;
      label486:
      localObject1 = awgq.b(this.jdField_a_of_type_Awgq, (Drawable)localObject1);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      break label403;
      label509:
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
      break label419;
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837550);
      if (paramViewGroup.jdField_a_of_type_Bbjs.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
      {
        if (Build.VERSION.SDK_INT >= 16)
        {
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackground(paramViewGroup.jdField_a_of_type_Bbjs.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          break label419;
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(paramViewGroup.jdField_a_of_type_Bbjs.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        break label419;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(paramViewGroup.jdField_a_of_type_Bbjs.jdField_b_of_type_Int);
      break label419;
      break;
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     awgp
 * JD-Core Version:    0.7.0.1
 */