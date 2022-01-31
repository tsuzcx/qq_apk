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

public class apen
  extends BaseAdapter
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private BaseFileAssistantActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity;
  private List<apep> jdField_a_of_type_JavaUtilList;
  
  public apen(BaseFileAssistantActivity paramBaseFileAssistantActivity, List<apep> paramList, View.OnClickListener paramOnClickListener)
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
    if (((apep)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int == 0) {
      return 0;
    }
    if (((apep)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int == 3) {
      return 3;
    }
    if (((apep)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int == 2) {
      return 2;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    apep localapep = (apep)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject;
    if (localapep == null)
    {
      localObject = null;
      return localObject;
    }
    if (paramView == null)
    {
      localObject = new apeo(this);
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(localapep.jdField_b_of_type_Int, paramViewGroup, false);
      paramView = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, paramView).c(30).a();
      paramView.setTag(localObject);
      if ((localapep.jdField_a_of_type_Int == 0) || (localapep.jdField_a_of_type_Int == 3))
      {
        ((apeo)localObject).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131363962);
        ((apeo)localObject).jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        ((apeo)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363961));
        ((apeo)localObject).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131375028));
        ((apeo)localObject).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363963));
        ((apeo)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370992));
        ((apeo)localObject).c = ((TextView)paramView.findViewById(2131376446));
        paramViewGroup = (ViewGroup)localObject;
      }
    }
    for (;;)
    {
      label195:
      paramViewGroup.jdField_a_of_type_Int = localapep.e;
      paramViewGroup.jdField_a_of_type_JavaLangString = localapep.jdField_c_of_type_JavaLangString;
      if (localapep.jdField_a_of_type_Int == 0)
      {
        if (localapep.jdField_c_of_type_Boolean)
        {
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          label237:
          if (!localapep.jdField_b_of_type_Boolean) {
            break label570;
          }
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(localapep.jdField_c_of_type_Int);
          label265:
          if (TextUtils.isEmpty(localapep.jdField_b_of_type_JavaLangString)) {
            break label582;
          }
          paramViewGroup.c.setText(localapep.jdField_b_of_type_JavaLangString);
          paramViewGroup.c.setVisibility(0);
          label296:
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(localapep.jdField_a_of_type_JavaLangString);
          paramViewGroup.jdField_a_of_type_AndroidViewView.setTag(paramViewGroup);
          if (localapep.jdField_a_of_type_Boolean) {
            paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText("(" + localapep.d + ")");
          }
          switch (localapep.f)
          {
          default: 
            paramViewGroup.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839169);
          }
        }
        for (;;)
        {
          localObject = paramView;
          if (16 == localapep.e) {
            break;
          }
          localObject = paramView;
          if (17 == localapep.e) {
            break;
          }
          if (22 != localapep.e) {
            break label653;
          }
          localObject = ((avps)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app.getManager(36)).a(String.valueOf("100160.100163"));
          ((RedTouch)paramView).a((BusinessInfoCheckUpdate.AppInfo)localObject);
          if (!((RedTouch)paramView).a()) {
            break label642;
          }
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
          return paramView;
          if ((localapep.jdField_a_of_type_Int != 1) && (localapep.jdField_a_of_type_Int != 4)) {
            break label825;
          }
          ((apeo)localObject).d = ((TextView)paramView.findViewById(2131365263));
          ((apeo)localObject).e = ((TextView)paramView.findViewById(2131377045));
          paramViewGroup = (ViewGroup)localObject;
          break label195;
          paramViewGroup = (apeo)paramView.getTag();
          break label195;
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          break label237;
          label570:
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          break label265;
          label582:
          paramViewGroup.c.setVisibility(8);
          break label296;
          paramViewGroup.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839169);
          continue;
          paramViewGroup.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839185);
          continue;
          paramViewGroup.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839176);
          continue;
          paramViewGroup.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839179);
        }
        label642:
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        return paramView;
        label653:
        ((RedTouch)paramView).b();
        return paramView;
      }
      if (localapep.jdField_a_of_type_Int == 1)
      {
        if (localapep.jdField_a_of_type_Boolean)
        {
          paramViewGroup.e.setText(localapep.jdField_a_of_type_JavaLangString);
          return paramView;
        }
        paramViewGroup.e.setVisibility(4);
        return paramView;
      }
      localObject = paramView;
      if (localapep.jdField_a_of_type_Int != 4) {
        break;
      }
      if (localapep.jdField_a_of_type_Boolean)
      {
        paramViewGroup.e.setGravity(17);
        localObject = paramView;
        if (bbjc.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, new String[] { this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131692428) })) {
          break;
        }
        localObject = apug.a(localapep.jdField_a_of_type_JavaLangString, localapep.jdField_a_of_type_JavaLangString, null);
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
 * Qualified Name:     apen
 * JD-Core Version:    0.7.0.1
 */