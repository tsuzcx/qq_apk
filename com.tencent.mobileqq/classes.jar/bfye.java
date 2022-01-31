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
import com.tencent.qidian.PhotoWallViewForQiDianProfile;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.List;

public class bfye
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  List<bfzs> jdField_a_of_type_JavaUtilList;
  
  public bfye(PhotoWallViewForQiDianProfile paramPhotoWallViewForQiDianProfile, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public void a(List<bfzs> paramList)
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
        paramViewGroup = ((bfzs)this.jdField_a_of_type_JavaUtilList.get(paramInt)).c;
        ViewGroup localViewGroup;
        Resources localResources;
        int i;
        int j;
        if (!QLog.isColorLevel()) {
          break label337;
        }
      }
      catch (Exception localException1)
      {
        try
        {
          localObject2 = ((bfzs)this.jdField_a_of_type_JavaUtilList.get(paramInt)).a;
          localViewGroup = paramViewGroup;
          paramViewGroup = (ViewGroup)localObject2;
          if (paramView != null) {
            break label354;
          }
          localObject2 = new bfyf(this);
          paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559439, null);
          paramView.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_ComTencentQidianPhotoWallViewForQiDianProfile.a, this.jdField_a_of_type_ComTencentQidianPhotoWallViewForQiDianProfile.b));
          ((bfyf)localObject2).jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131371920));
          ((bfyf)localObject2).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370098));
          ((bfyf)localObject2).jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
          ((bfyf)localObject2).jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
          ((bfyf)localObject2).jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 14.0F);
          ((bfyf)localObject2).jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
          localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
          ((bfyf)localObject2).jdField_a_of_type_AndroidWidgetTextView.setLineSpacing(aepi.a(2.5F, localResources), 1.0F);
          ((bfyf)localObject2).jdField_a_of_type_AndroidWidgetTextView.setGravity(80);
          ((bfyf)localObject2).jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
          ((bfyf)localObject2).jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130841315);
          i = aepi.a(11.0F, localResources);
          j = aepi.a(14.0F, localResources);
          ((bfyf)localObject2).jdField_a_of_type_AndroidWidgetTextView.setPadding(j, 0, j, i);
          paramView.setTag(localObject2);
          ((bfyf)localObject2).jdField_a_of_type_ComTencentImageURLImageView.setTag(new awor(25, Integer.valueOf(paramInt)));
          if (!TextUtils.isEmpty(localViewGroup)) {
            break label366;
          }
          ((bfyf)localObject2).jdField_a_of_type_ComTencentImageURLImageView.setImageResource(2130849859);
          if (!TextUtils.isEmpty(paramViewGroup))
          {
            ((bfyf)localObject2).jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
            ((bfyf)localObject2).jdField_a_of_type_AndroidWidgetTextView.setText(paramViewGroup);
          }
          return paramView;
        }
        catch (Exception localException2)
        {
          Object localObject2;
          Object localObject1;
          break label323;
        }
        localException1 = localException1;
        paramViewGroup = null;
      }
      label323:
      QLog.d("PhotoWallViewForQiDianProfile", 2, "getView url error!");
      label337:
      localException1.printStackTrace();
      localObject2 = null;
      localObject1 = paramViewGroup;
      paramViewGroup = (ViewGroup)localObject2;
      continue;
      label354:
      localObject2 = (bfyf)paramView.getTag();
      continue;
      label366:
      localObject1 = URLDrawable.getDrawable((String)localObject1);
      ((bfyf)localObject2).jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfye
 * JD-Core Version:    0.7.0.1
 */