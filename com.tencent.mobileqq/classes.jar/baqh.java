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

public class baqh
  extends BaseAdapter
{
  Context jdField_a_of_type_AndroidContentContext;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  ArrayList<bapp> jdField_a_of_type_JavaUtilArrayList = new ArrayList(4);
  ArrayList<baqj> b = new ArrayList();
  
  public baqh(Context paramContext, View.OnClickListener paramOnClickListener)
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
      baqj localbaqj = (baqj)localIterator.next();
      if (localbaqj != null) {
        localbaqj.b();
      }
    }
  }
  
  public void a(ArrayList<bapp> paramArrayList)
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
      baqj localbaqj = (baqj)localIterator.next();
      if (localbaqj != null) {
        localbaqj.a();
      }
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      baqj localbaqj = (baqj)localIterator.next();
      if (localbaqj != null) {
        localbaqj.c();
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
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561161, paramViewGroup, false);
      paramViewGroup = new baqk();
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqTogetherUiRoundRectView = ((RoundRectView)paramView.findViewById(2131363040));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368577));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131377197));
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131368518));
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131367553));
      paramViewGroup.jdField_a_of_type_Bapx = new bapx();
      if (paramViewGroup.jdField_a_of_type_Bapx.a() != null)
      {
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramViewGroup.jdField_a_of_type_Bapx.a());
      }
      this.b.add(new baqi(this, paramViewGroup));
      paramView.setTag(paramViewGroup);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqTogetherUiRoundRectView.setAllRadius(bdoo.b(16.0F));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqTogetherUiRoundRectView.setBgColor(((bapp)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).d);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqTogetherUiRoundRectView.setTag(this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqTogetherUiRoundRectView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      if (AppSetting.c) {
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqTogetherUiRoundRectView.setContentDescription(((bapp)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString);
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((bapp)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString);
      ((bapp)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a(baph.a(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app).a(((bapp)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).b));
      if (!((bapp)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Boolean) {
        break label485;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      paramViewGroup.jdField_a_of_type_Bapx.a(((bapp)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaUtilArrayList);
    }
    for (;;)
    {
      paramViewGroup.b.setText(((bapp)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a());
      if (TextUtils.isEmpty(((bapp)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).c)) {
        break label497;
      }
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = bapp.a(this.jdField_a_of_type_AndroidContentContext, (bapp)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = bapp.a(this.jdField_a_of_type_AndroidContentContext, (bapp)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
      localObject = URLDrawable.getDrawable(((bapp)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).c, (URLDrawable.URLDrawableOptions)localObject);
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      return paramView;
      paramViewGroup = (baqk)paramView.getTag();
      break;
      label485:
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    label497:
    paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setImageResource(((bapp)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).e);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baqh
 * JD-Core Version:    0.7.0.1
 */