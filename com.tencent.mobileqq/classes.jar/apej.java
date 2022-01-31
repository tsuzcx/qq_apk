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

public class apej
  extends BaseAdapter
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private BaseFileAssistantActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity;
  private List<apel> jdField_a_of_type_JavaUtilList;
  
  public apej(BaseFileAssistantActivity paramBaseFileAssistantActivity, List<apel> paramList, View.OnClickListener paramOnClickListener)
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
    if (((apel)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int == 0) {
      return 0;
    }
    if (((apel)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int == 3) {
      return 3;
    }
    if (((apel)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int == 2) {
      return 2;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    apel localapel = (apel)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject;
    if (localapel == null)
    {
      localObject = null;
      return localObject;
    }
    if (paramView == null)
    {
      localObject = new apek(this);
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(localapel.jdField_b_of_type_Int, paramViewGroup, false);
      paramView = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, paramView).c(30).a();
      paramView.setTag(localObject);
      if ((localapel.jdField_a_of_type_Int == 0) || (localapel.jdField_a_of_type_Int == 3))
      {
        ((apek)localObject).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131363963);
        ((apek)localObject).jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        ((apek)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363962));
        ((apek)localObject).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131375026));
        ((apek)localObject).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363964));
        ((apek)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370992));
        ((apek)localObject).c = ((TextView)paramView.findViewById(2131376444));
        paramViewGroup = (ViewGroup)localObject;
      }
    }
    for (;;)
    {
      label195:
      paramViewGroup.jdField_a_of_type_Int = localapel.e;
      paramViewGroup.jdField_a_of_type_JavaLangString = localapel.jdField_c_of_type_JavaLangString;
      if (localapel.jdField_a_of_type_Int == 0)
      {
        if (localapel.jdField_c_of_type_Boolean)
        {
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          label237:
          if (!localapel.jdField_b_of_type_Boolean) {
            break label570;
          }
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(localapel.jdField_c_of_type_Int);
          label265:
          if (TextUtils.isEmpty(localapel.jdField_b_of_type_JavaLangString)) {
            break label582;
          }
          paramViewGroup.c.setText(localapel.jdField_b_of_type_JavaLangString);
          paramViewGroup.c.setVisibility(0);
          label296:
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(localapel.jdField_a_of_type_JavaLangString);
          paramViewGroup.jdField_a_of_type_AndroidViewView.setTag(paramViewGroup);
          if (localapel.jdField_a_of_type_Boolean) {
            paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText("(" + localapel.d + ")");
          }
          switch (localapel.f)
          {
          default: 
            paramViewGroup.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839169);
          }
        }
        for (;;)
        {
          localObject = paramView;
          if (16 == localapel.e) {
            break;
          }
          localObject = paramView;
          if (17 == localapel.e) {
            break;
          }
          if (22 != localapel.e) {
            break label653;
          }
          localObject = ((avpq)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app.getManager(36)).a(String.valueOf("100160.100163"));
          ((RedTouch)paramView).a((BusinessInfoCheckUpdate.AppInfo)localObject);
          if (!((RedTouch)paramView).a()) {
            break label642;
          }
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
          return paramView;
          if ((localapel.jdField_a_of_type_Int != 1) && (localapel.jdField_a_of_type_Int != 4)) {
            break label825;
          }
          ((apek)localObject).d = ((TextView)paramView.findViewById(2131365264));
          ((apek)localObject).e = ((TextView)paramView.findViewById(2131377043));
          paramViewGroup = (ViewGroup)localObject;
          break label195;
          paramViewGroup = (apek)paramView.getTag();
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
      if (localapel.jdField_a_of_type_Int == 1)
      {
        if (localapel.jdField_a_of_type_Boolean)
        {
          paramViewGroup.e.setText(localapel.jdField_a_of_type_JavaLangString);
          return paramView;
        }
        paramViewGroup.e.setVisibility(4);
        return paramView;
      }
      localObject = paramView;
      if (localapel.jdField_a_of_type_Int != 4) {
        break;
      }
      if (localapel.jdField_a_of_type_Boolean)
      {
        paramViewGroup.e.setGravity(17);
        localObject = paramView;
        if (bbio.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, new String[] { this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131692427) })) {
          break;
        }
        localObject = apue.a(localapel.jdField_a_of_type_JavaLangString, localapel.jdField_a_of_type_JavaLangString, null);
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
 * Qualified Name:     apej
 * JD-Core Version:    0.7.0.1
 */