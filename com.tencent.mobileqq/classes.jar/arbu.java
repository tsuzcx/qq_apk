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

public class arbu
  extends BaseAdapter
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private BaseFileAssistantActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity;
  private List<arbw> jdField_a_of_type_JavaUtilList;
  
  public arbu(BaseFileAssistantActivity paramBaseFileAssistantActivity, List<arbw> paramList, View.OnClickListener paramOnClickListener)
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
    if (((arbw)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int == 0) {
      return 0;
    }
    if (((arbw)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int == 3) {
      return 3;
    }
    if (((arbw)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int == 2) {
      return 2;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    arbw localarbw = (arbw)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject;
    if (localarbw == null)
    {
      localObject = null;
      return localObject;
    }
    if (paramView == null)
    {
      localObject = new arbv(this);
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(localarbw.jdField_b_of_type_Int, paramViewGroup, false);
      paramView = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, paramView).c(30).a();
      paramView.setTag(localObject);
      if ((localarbw.jdField_a_of_type_Int == 0) || (localarbw.jdField_a_of_type_Int == 3))
      {
        ((arbv)localObject).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131364022);
        ((arbv)localObject).jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        ((arbv)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364021));
        ((arbv)localObject).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131375549));
        ((arbv)localObject).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364023));
        ((arbv)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371323));
        ((arbv)localObject).c = ((TextView)paramView.findViewById(2131377000));
        paramViewGroup = (ViewGroup)localObject;
      }
    }
    for (;;)
    {
      label195:
      paramViewGroup.jdField_a_of_type_Int = localarbw.e;
      paramViewGroup.jdField_a_of_type_JavaLangString = localarbw.jdField_c_of_type_JavaLangString;
      if (localarbw.jdField_a_of_type_Int == 0)
      {
        if (localarbw.jdField_c_of_type_Boolean)
        {
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          label237:
          if (!localarbw.jdField_b_of_type_Boolean) {
            break label570;
          }
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(localarbw.jdField_c_of_type_Int);
          label265:
          if (TextUtils.isEmpty(localarbw.jdField_b_of_type_JavaLangString)) {
            break label582;
          }
          paramViewGroup.c.setText(localarbw.jdField_b_of_type_JavaLangString);
          paramViewGroup.c.setVisibility(0);
          label296:
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(localarbw.jdField_a_of_type_JavaLangString);
          paramViewGroup.jdField_a_of_type_AndroidViewView.setTag(paramViewGroup);
          if (localarbw.jdField_a_of_type_Boolean) {
            paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText("(" + localarbw.d + ")");
          }
          switch (localarbw.f)
          {
          default: 
            paramViewGroup.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839254);
          }
        }
        for (;;)
        {
          localObject = paramView;
          if (16 == localarbw.e) {
            break;
          }
          localObject = paramView;
          if (17 == localarbw.e) {
            break;
          }
          if (22 != localarbw.e) {
            break label653;
          }
          localObject = ((axlx)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app.getManager(36)).a(String.valueOf("100160.100163"));
          ((RedTouch)paramView).a((BusinessInfoCheckUpdate.AppInfo)localObject);
          if (!((RedTouch)paramView).b()) {
            break label642;
          }
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
          return paramView;
          if ((localarbw.jdField_a_of_type_Int != 1) && (localarbw.jdField_a_of_type_Int != 4)) {
            break label825;
          }
          ((arbv)localObject).d = ((TextView)paramView.findViewById(2131365350));
          ((arbv)localObject).e = ((TextView)paramView.findViewById(2131377620));
          paramViewGroup = (ViewGroup)localObject;
          break label195;
          paramViewGroup = (arbv)paramView.getTag();
          break label195;
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          break label237;
          label570:
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          break label265;
          label582:
          paramViewGroup.c.setVisibility(8);
          break label296;
          paramViewGroup.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839254);
          continue;
          paramViewGroup.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839270);
          continue;
          paramViewGroup.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839261);
          continue;
          paramViewGroup.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839264);
        }
        label642:
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        return paramView;
        label653:
        ((RedTouch)paramView).d();
        return paramView;
      }
      if (localarbw.jdField_a_of_type_Int == 1)
      {
        if (localarbw.jdField_a_of_type_Boolean)
        {
          paramViewGroup.e.setText(localarbw.jdField_a_of_type_JavaLangString);
          return paramView;
        }
        paramViewGroup.e.setVisibility(4);
        return paramView;
      }
      localObject = paramView;
      if (localarbw.jdField_a_of_type_Int != 4) {
        break;
      }
      if (localarbw.jdField_a_of_type_Boolean)
      {
        paramViewGroup.e.setGravity(17);
        localObject = paramView;
        if (bdmh.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, new String[] { this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131692505) })) {
          break;
        }
        localObject = arrr.a(localarbw.jdField_a_of_type_JavaLangString, localarbw.jdField_a_of_type_JavaLangString, null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arbu
 * JD-Core Version:    0.7.0.1
 */