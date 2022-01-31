import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.together.ui.RoundRectView;
import java.util.ArrayList;
import java.util.Iterator;

public class ayoc
  extends BaseAdapter
{
  Context jdField_a_of_type_AndroidContentContext;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  ArrayList<aynk> jdField_a_of_type_JavaUtilArrayList = new ArrayList(4);
  ArrayList<ayoe> b = new ArrayList();
  
  public ayoc(Context paramContext, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      ayoe localayoe = (ayoe)localIterator.next();
      if (localayoe != null) {
        localayoe.b();
      }
    }
  }
  
  public void a(ArrayList<aynk> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    notifyDataSetChanged();
  }
  
  public void b()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      ayoe localayoe = (ayoe)localIterator.next();
      if (localayoe != null) {
        localayoe.a();
      }
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      ayoe localayoe = (ayoe)localIterator.next();
      if (localayoe != null) {
        localayoe.c();
      }
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560960, paramViewGroup, false);
      paramViewGroup = new ayof();
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqTogetherUiRoundRectView = ((RoundRectView)paramView.findViewById(2131363004));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368383));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131376633));
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131368335));
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131367414));
      paramViewGroup.jdField_a_of_type_Ayns = new ayns();
      if (paramViewGroup.jdField_a_of_type_Ayns.a() != null)
      {
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramViewGroup.jdField_a_of_type_Ayns.a());
      }
      this.b.add(new ayod(this, paramViewGroup));
      paramView.setTag(paramViewGroup);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqTogetherUiRoundRectView.setAllRadius(bbll.b(16.0F));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqTogetherUiRoundRectView.setBgColor(((aynk)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).d);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqTogetherUiRoundRectView.setTag(this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqTogetherUiRoundRectView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      if (AppSetting.d) {
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqTogetherUiRoundRectView.setContentDescription(((aynk)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString);
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((aynk)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString);
      ((aynk)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a(aync.a(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app).a(((aynk)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).b));
      if (!((aynk)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Boolean) {
        break label485;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      paramViewGroup.jdField_a_of_type_Ayns.a(((aynk)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaUtilArrayList);
    }
    for (;;)
    {
      paramViewGroup.b.setText(((aynk)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a());
      if (TextUtils.isEmpty(((aynk)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).c)) {
        break label497;
      }
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = aynk.a(this.jdField_a_of_type_AndroidContentContext, (aynk)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = aynk.a(this.jdField_a_of_type_AndroidContentContext, (aynk)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
      localObject = URLDrawable.getDrawable(((aynk)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).c, (URLDrawable.URLDrawableOptions)localObject);
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      return paramView;
      paramViewGroup = (ayof)paramView.getTag();
      break;
      label485:
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    label497:
    paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setImageResource(((aynk)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).e);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ayoc
 * JD-Core Version:    0.7.0.1
 */