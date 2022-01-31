import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.List;

public class avrr
  extends BaseAdapter
{
  public int a;
  private Context jdField_a_of_type_AndroidContentContext;
  public String a;
  List<avsp> jdField_a_of_type_JavaUtilList;
  
  public avrr(Context paramContext)
  {
    this.jdField_a_of_type_JavaLangString = "SubtitleProviderGridAdapter";
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(avsp paramavsp, View paramView)
  {
    if ((paramavsp == null) || (paramView == null)) {}
    do
    {
      return;
      paramView = (ImageView)paramView.findViewById(2131364779);
    } while (paramView == null);
    if ((paramavsp != null) && (paramavsp.jdField_a_of_type_Avsq != null) && (paramavsp.jdField_a_of_type_Avsq.d != 2) && (!paramavsp.jdField_b_of_type_Boolean))
    {
      paramView.setImageResource(2130845164);
      paramView.setVisibility(0);
      return;
    }
    paramView.setVisibility(8);
  }
  
  public void a(List<avsp> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    if ((paramList != null) && (QLog.isColorLevel())) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "SubtitleProviderGridAdapter setData size = " + paramList.size());
    }
  }
  
  public void b(avsp paramavsp, View paramView)
  {
    if ((paramavsp == null) || (paramView == null)) {}
    do
    {
      return;
      CircleProgress localCircleProgress = (CircleProgress)paramView.findViewById(2131376706);
      paramView = (ImageView)paramView.findViewById(2131368057);
      if (paramavsp.jdField_b_of_type_Boolean)
      {
        localCircleProgress.setVisibility(0);
        if (paramavsp.jdField_a_of_type_Avsq != null) {
          localCircleProgress.setProgress(paramavsp.jdField_a_of_type_Avsq.e);
        }
        paramView.setVisibility(8);
        return;
      }
      localCircleProgress.setVisibility(8);
    } while (this.jdField_a_of_type_Int != paramavsp.jdField_a_of_type_Int);
    paramView.setVisibility(0);
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
    View localView = paramView;
    if (paramView == null) {
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560685, paramViewGroup, false);
    }
    paramView = (TextView)localView.findViewById(2131366265);
    Object localObject2 = (ImageView)localView.findViewById(2131368057);
    paramViewGroup = (ImageView)localView.findViewById(2131367679);
    ImageView localImageView = (ImageView)localView.findViewById(2131364779);
    RelativeLayout localRelativeLayout = (RelativeLayout)localView.findViewById(2131368329);
    Object localObject1 = (CircleProgress)localView.findViewById(2131376706);
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166854);
    int j = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165297);
    ((CircleProgress)localObject1).setStrokeWidth(2.0F);
    ((CircleProgress)localObject1).setBgAndProgressColor(30, i, 100, j);
    localObject1 = (avsp)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (this.jdField_a_of_type_Int == ((avsp)localObject1).jdField_a_of_type_Int)
    {
      paramInt = 1;
      localView.setTag(localObject1);
      if ((AbsListView.LayoutParams)localView.getLayoutParams() == null) {
        localView.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
      }
      if (!((avsp)localObject1).a()) {
        break label290;
      }
      ((ImageView)localObject2).setVisibility(8);
      if (paramInt == 0) {
        break label271;
      }
      paramViewGroup.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845099));
    }
    for (;;)
    {
      paramViewGroup.setContentDescription(ajya.a(2131714684));
      localImageView.setVisibility(8);
      paramView.setVisibility(0);
      paramView.setText("");
      return localView;
      paramInt = 0;
      break;
      label271:
      paramViewGroup.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845100));
    }
    label290:
    if (paramInt != 0)
    {
      ((ImageView)localObject2).setVisibility(0);
      paramView.setShadowLayer(0.0F, 0.0F, 0.0F, this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166807));
      localRelativeLayout.setVisibility(8);
    }
    for (;;)
    {
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845092);
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845092);
      b((avsp)localObject1, localView);
      localObject2 = URLDrawable.getDrawable(((avsp)localObject1).jdField_a_of_type_JavaLangString, URLDrawable.URLDrawableOptions.obtain());
      ((URLDrawable)localObject2).startDownload();
      paramViewGroup.setImageDrawable((Drawable)localObject2);
      paramViewGroup.setContentDescription(((avsp)localObject1).jdField_b_of_type_JavaLangString);
      paramView.setText(((avsp)localObject1).jdField_b_of_type_JavaLangString);
      paramView.setVisibility(8);
      a((avsp)localObject1, localView);
      return localView;
      ((ImageView)localObject2).setVisibility(8);
      paramView.setShadowLayer(3.0F, 0.0F, 0.0F, this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166807));
      localRelativeLayout.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avrr
 * JD-Core Version:    0.7.0.1
 */