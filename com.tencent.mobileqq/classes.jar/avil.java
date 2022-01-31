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

public class avil
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private List<HotWordSearchSpecialDataModel.TopicItem> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public avil(avij paramavij, Context paramContext, LayoutInflater paramLayoutInflater)
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
    avij localavij;
    String str2;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131495010, null);
      paramViewGroup = new avim(this.jdField_a_of_type_Avij);
      paramViewGroup.a = ((TextView)paramView.findViewById(2131312553));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131312550));
      paramView.setTag(paramViewGroup);
      localTopicItem = (HotWordSearchSpecialDataModel.TopicItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (!TextUtils.isEmpty(localTopicItem.title)) {
        paramViewGroup.a.setText(localTopicItem.title);
      }
      boolean bool = ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
      str1 = avij.a(this.jdField_a_of_type_Avij, localTopicItem.titleColor, "#262626");
      if (!TextUtils.isEmpty(str1)) {
        paramViewGroup.a.setTextColor(Color.parseColor(str1));
      }
      if ((bool) && (TextUtils.isEmpty(localTopicItem.titleColor))) {
        paramViewGroup.a.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131101260));
      }
      localavij = this.jdField_a_of_type_Avij;
      str2 = localTopicItem.configColor;
      if (!bool) {
        break label367;
      }
    }
    label367:
    for (String str1 = "#5F6062";; str1 = "#737373")
    {
      str1 = avij.a(localavij, str2, str1);
      if (!TextUtils.isEmpty(str1)) {
        paramViewGroup.b.setTextColor(Color.parseColor(str1));
      }
      if (TextUtils.isEmpty(localTopicItem.configTime)) {
        break label374;
      }
      float f = avwf.a(paramViewGroup.b, localTopicItem.configTime);
      paramInt = (a(this.jdField_a_of_type_AndroidContentContext) - aciy.a(34.0F, this.jdField_a_of_type_AndroidContentContext.getResources())) / 2;
      i = aciy.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      int j = aciy.a(f / 2.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramViewGroup.a.setMaxWidth(paramInt - i - j);
      paramViewGroup.b.setWidth((int)f);
      paramViewGroup.b.setVisibility(0);
      paramViewGroup.b.setText(localTopicItem.configTime);
      return paramView;
      paramViewGroup = (avim)paramView.getTag();
      break;
    }
    label374:
    paramInt = (a(this.jdField_a_of_type_AndroidContentContext) - aciy.a(34.0F, this.jdField_a_of_type_AndroidContentContext.getResources())) / 2;
    int i = aciy.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    paramViewGroup.a.setMaxWidth(paramInt - i);
    paramViewGroup.b.setVisibility(8);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avil
 * JD-Core Version:    0.7.0.1
 */