import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qidian.PhotoWallViewForQiDianProfile;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.List;

public class bilv
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  List<binj> jdField_a_of_type_JavaUtilList;
  
  public bilv(PhotoWallViewForQiDianProfile paramPhotoWallViewForQiDianProfile, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public void a(List<binj> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  @TargetApi(16)
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    for (;;)
    {
      try
      {
        localObject1 = ((binj)this.jdField_a_of_type_JavaUtilList.get(paramInt)).c;
        Object localObject2;
        int i;
        int j;
        if (!QLog.isColorLevel()) {
          break label347;
        }
      }
      catch (Exception localException1)
      {
        try
        {
          localObject4 = ((binj)this.jdField_a_of_type_JavaUtilList.get(paramInt)).a;
          localObject2 = localObject1;
          localObject1 = localObject4;
          if (paramView != null) {
            break label366;
          }
          paramView = new bilw(this);
          localObject4 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559576, null);
          ((View)localObject4).setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_ComTencentQidianPhotoWallViewForQiDianProfile.a, this.jdField_a_of_type_ComTencentQidianPhotoWallViewForQiDianProfile.b));
          paramView.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)((View)localObject4).findViewById(2131372572));
          paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject4).findViewById(2131370612));
          paramView.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
          paramView.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
          paramView.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 14.0F);
          paramView.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
          localObject5 = this.jdField_a_of_type_AndroidContentContext.getResources();
          paramView.jdField_a_of_type_AndroidWidgetTextView.setLineSpacing(AIOUtils.dp2px(2.5F, (Resources)localObject5), 1.0F);
          paramView.jdField_a_of_type_AndroidWidgetTextView.setGravity(80);
          paramView.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
          paramView.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130841665);
          i = AIOUtils.dp2px(11.0F, (Resources)localObject5);
          j = AIOUtils.dp2px(14.0F, (Resources)localObject5);
          paramView.jdField_a_of_type_AndroidWidgetTextView.setPadding(j, 0, j, i);
          ((View)localObject4).setTag(paramView);
          paramView.jdField_a_of_type_ComTencentImageURLImageView.setTag(new aykg(25, Integer.valueOf(paramInt)));
          if (!TextUtils.isEmpty(localObject2)) {
            break label384;
          }
          paramView.jdField_a_of_type_ComTencentImageURLImageView.setImageResource(2130850385);
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            paramView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
            paramView.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
          }
          EventCollector.getInstance().onListGetView(paramInt, (View)localObject4, paramViewGroup, getItemId(paramInt));
          return localObject4;
        }
        catch (Exception localException2)
        {
          Object localObject1;
          Object localObject4;
          Object localObject5;
          Object localObject3;
          break label333;
        }
        localException1 = localException1;
        localObject1 = null;
      }
      label333:
      QLog.d("PhotoWallViewForQiDianProfile", 2, "getView url error!");
      label347:
      localException1.printStackTrace();
      localObject4 = null;
      localObject3 = localObject1;
      localObject1 = localObject4;
      continue;
      label366:
      localObject5 = (bilw)paramView.getTag();
      localObject4 = paramView;
      paramView = (View)localObject5;
      continue;
      label384:
      localObject3 = URLDrawable.getDrawable((String)localObject3);
      paramView.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bilv
 * JD-Core Version:    0.7.0.1
 */