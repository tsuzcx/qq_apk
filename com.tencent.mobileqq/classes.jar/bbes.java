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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.List;

public class bbes
  extends BaseAdapter
{
  public int a;
  private Context jdField_a_of_type_AndroidContentContext;
  public String a;
  List<bbfq> jdField_a_of_type_JavaUtilList;
  
  public bbes(Context paramContext)
  {
    this.jdField_a_of_type_JavaLangString = "SubtitleProviderGridAdapter";
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(bbfq parambbfq, View paramView)
  {
    if ((parambbfq == null) || (paramView == null)) {}
    do
    {
      return;
      paramView = (ImageView)paramView.findViewById(2131365141);
    } while (paramView == null);
    if ((parambbfq != null) && (parambbfq.jdField_a_of_type_Bbfr != null) && (parambbfq.jdField_a_of_type_Bbfr.d != 2) && (!parambbfq.jdField_b_of_type_Boolean))
    {
      paramView.setImageResource(2130846014);
      paramView.setVisibility(0);
      return;
    }
    paramView.setVisibility(8);
  }
  
  public void a(List<bbfq> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    if ((paramList != null) && (QLog.isColorLevel())) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "SubtitleProviderGridAdapter setData size = " + paramList.size());
    }
  }
  
  public void b(bbfq parambbfq, View paramView)
  {
    if ((parambbfq == null) || (paramView == null)) {}
    do
    {
      return;
      CircleProgress localCircleProgress = (CircleProgress)paramView.findViewById(2131378238);
      paramView = (ImageView)paramView.findViewById(2131368606);
      if (parambbfq.jdField_b_of_type_Boolean)
      {
        localCircleProgress.setVisibility(0);
        if (parambbfq.jdField_a_of_type_Bbfr != null) {
          localCircleProgress.setProgress(parambbfq.jdField_a_of_type_Bbfr.e);
        }
        paramView.setVisibility(8);
        return;
      }
      localCircleProgress.setVisibility(8);
    } while (this.jdField_a_of_type_Int != parambbfq.jdField_a_of_type_Int);
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
    if (paramView == null) {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561121, paramViewGroup, false);
    }
    for (;;)
    {
      TextView localTextView = (TextView)paramView.findViewById(2131366659);
      Object localObject2 = (ImageView)paramView.findViewById(2131368606);
      ImageView localImageView1 = (ImageView)paramView.findViewById(2131368212);
      ImageView localImageView2 = (ImageView)paramView.findViewById(2131365141);
      RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(2131368871);
      Object localObject1 = (CircleProgress)paramView.findViewById(2131378238);
      int i = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166990);
      int j = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165367);
      ((CircleProgress)localObject1).setStrokeWidth(2.0F);
      ((CircleProgress)localObject1).setBgAndProgressColor(30, i, 100, j);
      localObject1 = (bbfq)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (this.jdField_a_of_type_Int == ((bbfq)localObject1).jdField_a_of_type_Int)
      {
        i = 1;
        paramView.setTag(localObject1);
        if ((AbsListView.LayoutParams)paramView.getLayoutParams() == null) {
          paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        }
        if (!((bbfq)localObject1).a()) {
          break label300;
        }
        ((ImageView)localObject2).setVisibility(8);
        if (i == 0) {
          break label280;
        }
        localImageView1.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845949));
      }
      for (;;)
      {
        localImageView1.setContentDescription(anzj.a(2131713478));
        localImageView2.setVisibility(8);
        localTextView.setVisibility(0);
        localTextView.setText("");
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        i = 0;
        break;
        label280:
        localImageView1.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845950));
      }
      label300:
      if (i != 0)
      {
        ((ImageView)localObject2).setVisibility(0);
        localTextView.setShadowLayer(0.0F, 0.0F, 0.0F, this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166942));
        localRelativeLayout.setVisibility(8);
      }
      for (;;)
      {
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845942);
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845942);
        b((bbfq)localObject1, paramView);
        localObject2 = URLDrawable.getDrawable(((bbfq)localObject1).jdField_a_of_type_JavaLangString, URLDrawable.URLDrawableOptions.obtain());
        ((URLDrawable)localObject2).startDownload();
        localImageView1.setImageDrawable((Drawable)localObject2);
        localImageView1.setContentDescription(((bbfq)localObject1).jdField_b_of_type_JavaLangString);
        localTextView.setText(((bbfq)localObject1).jdField_b_of_type_JavaLangString);
        localTextView.setVisibility(8);
        a((bbfq)localObject1, paramView);
        break;
        ((ImageView)localObject2).setVisibility(8);
        localTextView.setShadowLayer(3.0F, 0.0F, 0.0F, this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166942));
        localRelativeLayout.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbes
 * JD-Core Version:    0.7.0.1
 */