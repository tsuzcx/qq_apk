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

public class bdsb
  extends BaseAdapter
{
  Context jdField_a_of_type_AndroidContentContext;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  ArrayList<bdrj> jdField_a_of_type_JavaUtilArrayList = new ArrayList(4);
  ArrayList<bdsd> b = new ArrayList();
  
  public bdsb(Context paramContext, View.OnClickListener paramOnClickListener)
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
      bdsd localbdsd = (bdsd)localIterator.next();
      if (localbdsd != null) {
        localbdsd.b();
      }
    }
  }
  
  public void a(ArrayList<bdrj> paramArrayList)
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
      bdsd localbdsd = (bdsd)localIterator.next();
      if (localbdsd != null) {
        localbdsd.a();
      }
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      bdsd localbdsd = (bdsd)localIterator.next();
      if (localbdsd != null) {
        localbdsd.c();
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
    bdse localbdse;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561372, paramViewGroup, false);
      localbdse = new bdse();
      localbdse.jdField_a_of_type_ComTencentMobileqqTogetherUiRoundRectView = ((RoundRectView)paramView.findViewById(2131363224));
      localbdse.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368900));
      localbdse.b = ((TextView)paramView.findViewById(2131378008));
      localbdse.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131368826));
      localbdse.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131367865));
      localbdse.jdField_a_of_type_Bdrr = new bdrr();
      if (localbdse.jdField_a_of_type_Bdrr.a() != null)
      {
        localbdse.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
        localbdse.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localbdse.jdField_a_of_type_Bdrr.a());
      }
      this.b.add(new bdsc(this, localbdse));
      paramView.setTag(localbdse);
      localbdse.jdField_a_of_type_ComTencentMobileqqTogetherUiRoundRectView.setAllRadius(bgtn.b(16.0F));
      localbdse.jdField_a_of_type_ComTencentMobileqqTogetherUiRoundRectView.setBgColor(((bdrj)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).d);
      localbdse.jdField_a_of_type_ComTencentMobileqqTogetherUiRoundRectView.setTag(this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
      localbdse.jdField_a_of_type_ComTencentMobileqqTogetherUiRoundRectView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      if (AppSetting.c) {
        localbdse.jdField_a_of_type_ComTencentMobileqqTogetherUiRoundRectView.setContentDescription(((bdrj)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString);
      }
      localbdse.jdField_a_of_type_AndroidWidgetTextView.setText(((bdrj)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString);
      ((bdrj)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a(bdrb.a(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app).a(((bdrj)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).b));
      if (!((bdrj)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Boolean) {
        break label523;
      }
      localbdse.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      localbdse.jdField_a_of_type_Bdrr.a(((bdrj)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaUtilArrayList);
      label371:
      localbdse.b.setText(((bdrj)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a());
      if (TextUtils.isEmpty(((bdrj)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).c)) {
        break label536;
      }
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = bdrj.a(this.jdField_a_of_type_AndroidContentContext, (bdrj)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = bdrj.a(this.jdField_a_of_type_AndroidContentContext, (bdrj)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
      localObject = URLDrawable.getDrawable(((bdrj)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).c, (URLDrawable.URLDrawableOptions)localObject);
      localbdse.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localbdse = (bdse)paramView.getTag();
      break;
      label523:
      localbdse.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      break label371;
      label536:
      localbdse.jdField_a_of_type_ComTencentImageURLImageView.setImageResource(((bdrj)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).e);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdsb
 * JD-Core Version:    0.7.0.1
 */