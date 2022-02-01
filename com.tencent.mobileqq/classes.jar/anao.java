import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class anao
  extends BaseAdapter
{
  public Context a;
  private List<ApolloGameData> a;
  private List<String> b = new ArrayList();
  
  public anao(anan paramanan, Context paramContext)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    if (paramanan != null)
    {
      this.jdField_a_of_type_JavaUtilList = paramanan.b;
      this.b = paramanan.c;
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    Object localObject1;
    if (paramView == null)
    {
      paramView = new anap(this);
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558894, null);
      localView.setPadding(0, 0, 0, 0);
      paramView.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)localView.findViewById(2131369217));
      paramView.b = ((CornerImageView)localView.findViewById(2131369218));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131379840));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131369219));
      float f = mvd.a(this.jdField_a_of_type_AndroidContentContext, 5.0F);
      paramView.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setRadius(f);
      paramView.b.setRadius(new float[] { 0.0F, 0.0F, 0.0F, 0.0F, f, f, f, f });
      localView.setTag(paramView);
      Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = ((int)mvd.a(this.jdField_a_of_type_AndroidContentContext, 103.0F));
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = ((int)mvd.a(this.jdField_a_of_type_AndroidContentContext, 58.0F));
      localObject1 = (ApolloGameData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      localObject2 = URLDrawable.getDrawable(((ApolloGameData)localObject1).listCoverUrl, (URLDrawable.URLDrawableOptions)localObject2);
      paramView.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageDrawable((Drawable)localObject2);
      paramView.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setTag(Integer.valueOf(((ApolloGameData)localObject1).gameId));
      if (!((ApolloGameData)localObject1).isGameApp) {
        break label363;
      }
      paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838496);
    }
    for (;;)
    {
      localObject1 = (String)this.b.get(paramInt);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        paramView.b.setVisibility(0);
        paramView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramView.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      }
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject1 = (anap)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject1;
      break;
      label363:
      paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anao
 * JD-Core Version:    0.7.0.1
 */