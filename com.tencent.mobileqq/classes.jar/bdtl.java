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

public class bdtl
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  List<bduz> jdField_a_of_type_JavaUtilList;
  
  public bdtl(PhotoWallViewForQiDianProfile paramPhotoWallViewForQiDianProfile, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public void a(List<bduz> paramList)
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
        paramViewGroup = ((bduz)this.jdField_a_of_type_JavaUtilList.get(paramInt)).c;
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
          localObject2 = ((bduz)this.jdField_a_of_type_JavaUtilList.get(paramInt)).a;
          localViewGroup = paramViewGroup;
          paramViewGroup = (ViewGroup)localObject2;
          if (paramView != null) {
            break label354;
          }
          localObject2 = new bdtm(this);
          paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559388, null);
          paramView.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_ComTencentQidianPhotoWallViewForQiDianProfile.a, this.jdField_a_of_type_ComTencentQidianPhotoWallViewForQiDianProfile.b));
          ((bdtm)localObject2).jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131371583));
          ((bdtm)localObject2).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369816));
          ((bdtm)localObject2).jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
          ((bdtm)localObject2).jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
          ((bdtm)localObject2).jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 14.0F);
          ((bdtm)localObject2).jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
          localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
          ((bdtm)localObject2).jdField_a_of_type_AndroidWidgetTextView.setLineSpacing(actn.a(2.5F, localResources), 1.0F);
          ((bdtm)localObject2).jdField_a_of_type_AndroidWidgetTextView.setGravity(80);
          ((bdtm)localObject2).jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
          ((bdtm)localObject2).jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130841197);
          i = actn.a(11.0F, localResources);
          j = actn.a(14.0F, localResources);
          ((bdtm)localObject2).jdField_a_of_type_AndroidWidgetTextView.setPadding(j, 0, j, i);
          paramView.setTag(localObject2);
          ((bdtm)localObject2).jdField_a_of_type_ComTencentImageURLImageView.setTag(new ausu(25, Integer.valueOf(paramInt)));
          if (!TextUtils.isEmpty(localViewGroup)) {
            break label366;
          }
          ((bdtm)localObject2).jdField_a_of_type_ComTencentImageURLImageView.setImageResource(2130849344);
          if (!TextUtils.isEmpty(paramViewGroup))
          {
            ((bdtm)localObject2).jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
            ((bdtm)localObject2).jdField_a_of_type_AndroidWidgetTextView.setText(paramViewGroup);
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
      localObject2 = (bdtm)paramView.getTag();
      continue;
      label366:
      localObject1 = URLDrawable.getDrawable((String)localObject1);
      ((bdtm)localObject2).jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bdtl
 * JD-Core Version:    0.7.0.1
 */