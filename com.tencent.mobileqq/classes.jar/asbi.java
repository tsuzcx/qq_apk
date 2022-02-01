import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.data.IPSiteModel.Goods;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.List;

public class asbi
  extends BaseAdapter
{
  private static int jdField_a_of_type_Int = 6;
  private Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private URLDrawable.URLDrawableListener jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener;
  private String jdField_a_of_type_JavaLangString;
  private List<Object> jdField_a_of_type_JavaUtilList;
  private String b;
  private String c;
  
  public asbi(Context paramContext, List<Object> paramList, URLDrawable.URLDrawableListener paramURLDrawableListener, Drawable paramDrawable, String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener = paramURLDrawableListener;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.c = paramString3;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      int i = this.jdField_a_of_type_JavaUtilList.size();
      if (i > jdField_a_of_type_Int) {
        return jdField_a_of_type_Int + 1;
      }
      return i + 1;
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject3;
    Object localObject1;
    Object localObject2;
    if (paramInt < getCount() - 1)
    {
      localObject3 = (IPSiteModel.Goods)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (paramView == null)
      {
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559130, null, false);
        localObject1 = new asbl(this, null);
        ((asbl)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView);
        ((asbl)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131362384));
        ((asbl)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362385));
        ((asbl)localObject1).b = ((TextView)paramView.findViewById(2131362383));
        paramView.setTag(localObject1);
        localObject2 = paramView;
        if (localObject3 != null)
        {
          ((asbl)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(bgtl.a(((IPSiteModel.Goods)localObject3).cover, this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable));
          ((asbl)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(((IPSiteModel.Goods)localObject3).name);
          localObject2 = "0";
          if (!TextUtils.isEmpty(((IPSiteModel.Goods)localObject3).saleNum)) {
            localObject2 = ((IPSiteModel.Goods)localObject3).saleNum;
          }
          ((asbl)localObject1).b.setText((String)localObject2 + anni.a(2131704631));
          ((asbl)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new asbj(this, (IPSiteModel.Goods)localObject3));
          localObject2 = paramView;
        }
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject2, paramViewGroup, getItemId(paramInt));
      return localObject2;
      localObject1 = (asbl)paramView.getTag();
      break;
      paramView = (IPSiteModel.Goods)this.jdField_a_of_type_JavaUtilList.get(0);
      localObject2 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      ((RelativeLayout)localObject2).setBackgroundColor(Color.parseColor("#fafafa"));
      localObject1 = new AbsListView.LayoutParams(afur.a(75.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), afur.a(75.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((RelativeLayout)localObject2).setMinimumWidth(afur.a(75.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((RelativeLayout)localObject2).setMinimumHeight(afur.a(75.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((RelativeLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(15);
      ((RelativeLayout.LayoutParams)localObject3).addRule(14);
      ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject3);
      localObject3 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject3).setId(2131362393);
      ((TextView)localObject3).setTextSize(12.0F);
      ((TextView)localObject3).setTextColor(Color.parseColor("#777777"));
      ((TextView)localObject3).setText(anni.a(2131704632));
      ((TextView)localObject3).setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
      ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      localImageView.setImageResource(2130847100);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(1, 2131362393);
      localLayoutParams.addRule(15);
      localLayoutParams.leftMargin = afur.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localImageView.setLayoutParams(localLayoutParams);
      ((RelativeLayout)localObject1).addView((View)localObject3);
      ((RelativeLayout)localObject1).addView(localImageView);
      ((RelativeLayout)localObject2).addView((View)localObject1);
      ((RelativeLayout)localObject2).setOnClickListener(new asbk(this, paramView));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asbi
 * JD-Core Version:    0.7.0.1
 */