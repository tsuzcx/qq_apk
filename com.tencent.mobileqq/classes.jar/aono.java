import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import java.util.List;

public class aono
  extends BaseAdapter
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private BaseFileAssistantActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity;
  private List<aonq> jdField_a_of_type_JavaUtilList;
  
  public aono(BaseFileAssistantActivity paramBaseFileAssistantActivity, List<aonq> paramList, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity = paramBaseFileAssistantActivity;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
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
  
  public int getItemViewType(int paramInt)
  {
    if (((aonq)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int == 0) {
      return 0;
    }
    if (((aonq)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int == 3) {
      return 3;
    }
    if (((aonq)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int == 2) {
      return 2;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    aonq localaonq = (aonq)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject;
    if (localaonq == null)
    {
      localObject = null;
      return localObject;
    }
    if (paramView == null)
    {
      localObject = new aonp(this);
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(localaonq.jdField_b_of_type_Int, paramViewGroup, false);
      paramView = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, paramView).c(30).a();
      paramView.setTag(localObject);
      if ((localaonq.jdField_a_of_type_Int == 0) || (localaonq.jdField_a_of_type_Int == 3))
      {
        ((aonp)localObject).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131298407);
        ((aonp)localObject).jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        ((aonp)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131298406));
        ((aonp)localObject).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131309282));
        ((aonp)localObject).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131298408));
        ((aonp)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131305317));
        ((aonp)localObject).c = ((TextView)paramView.findViewById(2131310651));
        paramViewGroup = (ViewGroup)localObject;
      }
    }
    for (;;)
    {
      label195:
      paramViewGroup.jdField_a_of_type_Int = localaonq.e;
      paramViewGroup.jdField_a_of_type_JavaLangString = localaonq.jdField_c_of_type_JavaLangString;
      if (localaonq.jdField_a_of_type_Int == 0)
      {
        if (localaonq.jdField_c_of_type_Boolean)
        {
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          label237:
          if (!localaonq.jdField_b_of_type_Boolean) {
            break label570;
          }
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(localaonq.jdField_c_of_type_Int);
          label265:
          if (TextUtils.isEmpty(localaonq.jdField_b_of_type_JavaLangString)) {
            break label582;
          }
          paramViewGroup.c.setText(localaonq.jdField_b_of_type_JavaLangString);
          paramViewGroup.c.setVisibility(0);
          label296:
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(localaonq.jdField_a_of_type_JavaLangString);
          paramViewGroup.jdField_a_of_type_AndroidViewView.setTag(paramViewGroup);
          if (localaonq.jdField_a_of_type_Boolean) {
            paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText("(" + localaonq.d + ")");
          }
          switch (localaonq.f)
          {
          default: 
            paramViewGroup.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839144);
          }
        }
        for (;;)
        {
          localObject = paramView;
          if (16 == localaonq.e) {
            break;
          }
          localObject = paramView;
          if (17 == localaonq.e) {
            break;
          }
          if (22 != localaonq.e) {
            break label653;
          }
          localObject = ((auqh)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app.getManager(36)).a(String.valueOf("100160.100163"));
          ((RedTouch)paramView).a((BusinessInfoCheckUpdate.AppInfo)localObject);
          if (!((RedTouch)paramView).a()) {
            break label642;
          }
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
          return paramView;
          if ((localaonq.jdField_a_of_type_Int != 1) && (localaonq.jdField_a_of_type_Int != 4)) {
            break label825;
          }
          ((aonp)localObject).d = ((TextView)paramView.findViewById(2131299696));
          ((aonp)localObject).e = ((TextView)paramView.findViewById(2131311233));
          paramViewGroup = (ViewGroup)localObject;
          break label195;
          paramViewGroup = (aonp)paramView.getTag();
          break label195;
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          break label237;
          label570:
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          break label265;
          label582:
          paramViewGroup.c.setVisibility(8);
          break label296;
          paramViewGroup.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839144);
          continue;
          paramViewGroup.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839160);
          continue;
          paramViewGroup.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839151);
          continue;
          paramViewGroup.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839154);
        }
        label642:
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        return paramView;
        label653:
        ((RedTouch)paramView).b();
        return paramView;
      }
      if (localaonq.jdField_a_of_type_Int == 1)
      {
        if (localaonq.jdField_a_of_type_Boolean)
        {
          paramViewGroup.e.setText(localaonq.jdField_a_of_type_JavaLangString);
          return paramView;
        }
        paramViewGroup.e.setVisibility(4);
        return paramView;
      }
      localObject = paramView;
      if (localaonq.jdField_a_of_type_Int != 4) {
        break;
      }
      if (localaonq.jdField_a_of_type_Boolean)
      {
        paramViewGroup.e.setGravity(17);
        localObject = paramView;
        if (bahj.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, new String[] { this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131626826) })) {
          break;
        }
        localObject = apck.a(localaonq.jdField_a_of_type_JavaLangString, localaonq.jdField_a_of_type_JavaLangString, null);
        paramViewGroup.e.setClickable(true);
        paramViewGroup.e.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramViewGroup.e.setText((CharSequence)localObject);
        paramViewGroup.e.setTag(paramViewGroup);
        return paramView;
      }
      paramViewGroup.e.setVisibility(4);
      return paramView;
      label825:
      paramViewGroup = (ViewGroup)localObject;
    }
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aono
 * JD-Core Version:    0.7.0.1
 */