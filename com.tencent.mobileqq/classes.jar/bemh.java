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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;

public class bemh
  extends BaseAdapter
{
  Context jdField_a_of_type_AndroidContentContext;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  ArrayList<bekf> jdField_a_of_type_JavaUtilArrayList = new ArrayList(4);
  ArrayList<bemj> b = new ArrayList();
  
  public bemh(Context paramContext, View.OnClickListener paramOnClickListener)
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
      bemj localbemj = (bemj)localIterator.next();
      if (localbemj != null) {
        localbemj.b();
      }
    }
  }
  
  public void a(ArrayList<bekf> paramArrayList)
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
      bemj localbemj = (bemj)localIterator.next();
      if (localbemj != null) {
        localbemj.a();
      }
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      bemj localbemj = (bemj)localIterator.next();
      if (localbemj != null) {
        localbemj.c();
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
    bemk localbemk;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561413, paramViewGroup, false);
      localbemk = new bemk();
      localbemk.jdField_a_of_type_ComTencentMobileqqTogetherUiRoundRectView = ((RoundRectView)paramView.findViewById(2131363248));
      localbemk.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368993));
      localbemk.b = ((TextView)paramView.findViewById(2131378163));
      localbemk.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131368913));
      localbemk.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131367933));
      localbemk.jdField_a_of_type_Belx = new belx();
      if (localbemk.jdField_a_of_type_Belx.a() != null)
      {
        localbemk.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
        localbemk.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localbemk.jdField_a_of_type_Belx.a());
      }
      this.b.add(new bemi(this, localbemk));
      paramView.setTag(localbemk);
      localbemk.jdField_a_of_type_ComTencentMobileqqTogetherUiRoundRectView.setAllRadius(bhtq.b(16.0F));
      localbemk.jdField_a_of_type_ComTencentMobileqqTogetherUiRoundRectView.setBgColor(((bekf)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).d);
      localbemk.jdField_a_of_type_ComTencentMobileqqTogetherUiRoundRectView.setTag(this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
      localbemk.jdField_a_of_type_ComTencentMobileqqTogetherUiRoundRectView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      if (AppSetting.c) {
        localbemk.jdField_a_of_type_ComTencentMobileqqTogetherUiRoundRectView.setContentDescription(((bekf)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString);
      }
      localbemk.jdField_a_of_type_AndroidWidgetTextView.setText(((bekf)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString);
      ((bekf)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a(bejx.a(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app).a(((bekf)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).b));
      if (!((bekf)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Boolean) {
        break label523;
      }
      localbemk.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      localbemk.jdField_a_of_type_Belx.a(((bekf)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaUtilArrayList);
      label371:
      localbemk.b.setText(((bekf)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a());
      if (TextUtils.isEmpty(((bekf)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).c)) {
        break label536;
      }
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = bekf.a(this.jdField_a_of_type_AndroidContentContext, (bekf)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = bekf.a(this.jdField_a_of_type_AndroidContentContext, (bekf)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
      localObject = URLDrawable.getDrawable(((bekf)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).c, (URLDrawable.URLDrawableOptions)localObject);
      localbemk.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localbemk = (bemk)paramView.getTag();
      break;
      label523:
      localbemk.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      break label371;
      label536:
      localbemk.jdField_a_of_type_ComTencentImageURLImageView.setImageResource(((bekf)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).e);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bemh
 * JD-Core Version:    0.7.0.1
 */