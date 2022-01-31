import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.search.model.HotWordSearchSpecialDataModel.TopicItem;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.util.ArrayList;
import java.util.List;

public class awie
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private List<HotWordSearchSpecialDataModel.TopicItem> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public awie(awic paramawic, Context paramContext, LayoutInflater paramLayoutInflater)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramLayoutInflater;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public int a(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().widthPixels;
  }
  
  public List<HotWordSearchSpecialDataModel.TopicItem> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(List<HotWordSearchSpecialDataModel.TopicItem> paramList)
  {
    if (paramList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
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
    HotWordSearchSpecialDataModel.TopicItem localTopicItem;
    awic localawic;
    String str2;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560584, null);
      paramViewGroup = new awif(this.jdField_a_of_type_Awic);
      paramViewGroup.a = ((TextView)paramView.findViewById(2131378378));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131378375));
      paramView.setTag(paramViewGroup);
      localTopicItem = (HotWordSearchSpecialDataModel.TopicItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (!TextUtils.isEmpty(localTopicItem.title)) {
        paramViewGroup.a.setText(localTopicItem.title);
      }
      boolean bool = ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
      str1 = awic.a(this.jdField_a_of_type_Awic, localTopicItem.titleColor, "#262626");
      if (!TextUtils.isEmpty(str1)) {
        paramViewGroup.a.setTextColor(Color.parseColor(str1));
      }
      if ((bool) && (TextUtils.isEmpty(localTopicItem.titleColor))) {
        paramViewGroup.a.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166854));
      }
      localawic = this.jdField_a_of_type_Awic;
      str2 = localTopicItem.configColor;
      if (!bool) {
        break label367;
      }
    }
    label367:
    for (String str1 = "#5F6062";; str1 = "#737373")
    {
      str1 = awic.a(localawic, str2, str1);
      if (!TextUtils.isEmpty(str1)) {
        paramViewGroup.b.setTextColor(Color.parseColor(str1));
      }
      if (TextUtils.isEmpty(localTopicItem.configTime)) {
        break label374;
      }
      float f = awvy.a(paramViewGroup.b, localTopicItem.configTime);
      paramInt = (a(this.jdField_a_of_type_AndroidContentContext) - actn.a(34.0F, this.jdField_a_of_type_AndroidContentContext.getResources())) / 2;
      i = actn.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      int j = actn.a(f / 2.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramViewGroup.a.setMaxWidth(paramInt - i - j);
      paramViewGroup.b.setWidth((int)f);
      paramViewGroup.b.setVisibility(0);
      paramViewGroup.b.setText(localTopicItem.configTime);
      return paramView;
      paramViewGroup = (awif)paramView.getTag();
      break;
    }
    label374:
    paramInt = (a(this.jdField_a_of_type_AndroidContentContext) - actn.a(34.0F, this.jdField_a_of_type_AndroidContentContext.getResources())) / 2;
    int i = actn.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    paramViewGroup.a.setMaxWidth(paramInt - i);
    paramViewGroup.b.setVisibility(8);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awie
 * JD-Core Version:    0.7.0.1
 */