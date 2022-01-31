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

public class aqxl
  extends BaseAdapter
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private BaseFileAssistantActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity;
  private List<aqxn> jdField_a_of_type_JavaUtilList;
  
  public aqxl(BaseFileAssistantActivity paramBaseFileAssistantActivity, List<aqxn> paramList, View.OnClickListener paramOnClickListener)
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
    if (((aqxn)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int == 0) {
      return 0;
    }
    if (((aqxn)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int == 3) {
      return 3;
    }
    if (((aqxn)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int == 2) {
      return 2;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    aqxn localaqxn = (aqxn)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject;
    if (localaqxn == null)
    {
      localObject = null;
      return localObject;
    }
    if (paramView == null)
    {
      localObject = new aqxm(this);
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(localaqxn.jdField_b_of_type_Int, paramViewGroup, false);
      paramView = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, paramView).c(30).a();
      paramView.setTag(localObject);
      if ((localaqxn.jdField_a_of_type_Int == 0) || (localaqxn.jdField_a_of_type_Int == 3))
      {
        ((aqxm)localObject).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131364020);
        ((aqxm)localObject).jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        ((aqxm)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364019));
        ((aqxm)localObject).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131375498));
        ((aqxm)localObject).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364021));
        ((aqxm)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371304));
        ((aqxm)localObject).c = ((TextView)paramView.findViewById(2131376946));
        paramViewGroup = (ViewGroup)localObject;
      }
    }
    for (;;)
    {
      label195:
      paramViewGroup.jdField_a_of_type_Int = localaqxn.e;
      paramViewGroup.jdField_a_of_type_JavaLangString = localaqxn.jdField_c_of_type_JavaLangString;
      if (localaqxn.jdField_a_of_type_Int == 0)
      {
        if (localaqxn.jdField_c_of_type_Boolean)
        {
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          label237:
          if (!localaqxn.jdField_b_of_type_Boolean) {
            break label570;
          }
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(localaqxn.jdField_c_of_type_Int);
          label265:
          if (TextUtils.isEmpty(localaqxn.jdField_b_of_type_JavaLangString)) {
            break label582;
          }
          paramViewGroup.c.setText(localaqxn.jdField_b_of_type_JavaLangString);
          paramViewGroup.c.setVisibility(0);
          label296:
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(localaqxn.jdField_a_of_type_JavaLangString);
          paramViewGroup.jdField_a_of_type_AndroidViewView.setTag(paramViewGroup);
          if (localaqxn.jdField_a_of_type_Boolean) {
            paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText("(" + localaqxn.d + ")");
          }
          switch (localaqxn.f)
          {
          default: 
            paramViewGroup.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839253);
          }
        }
        for (;;)
        {
          localObject = paramView;
          if (16 == localaqxn.e) {
            break;
          }
          localObject = paramView;
          if (17 == localaqxn.e) {
            break;
          }
          if (22 != localaqxn.e) {
            break label653;
          }
          localObject = ((axho)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app.getManager(36)).a(String.valueOf("100160.100163"));
          ((RedTouch)paramView).a((BusinessInfoCheckUpdate.AppInfo)localObject);
          if (!((RedTouch)paramView).b()) {
            break label642;
          }
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
          return paramView;
          if ((localaqxn.jdField_a_of_type_Int != 1) && (localaqxn.jdField_a_of_type_Int != 4)) {
            break label825;
          }
          ((aqxm)localObject).d = ((TextView)paramView.findViewById(2131365348));
          ((aqxm)localObject).e = ((TextView)paramView.findViewById(2131377566));
          paramViewGroup = (ViewGroup)localObject;
          break label195;
          paramViewGroup = (aqxm)paramView.getTag();
          break label195;
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          break label237;
          label570:
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          break label265;
          label582:
          paramViewGroup.c.setVisibility(8);
          break label296;
          paramViewGroup.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839253);
          continue;
          paramViewGroup.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839269);
          continue;
          paramViewGroup.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839260);
          continue;
          paramViewGroup.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839263);
        }
        label642:
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        return paramView;
        label653:
        ((RedTouch)paramView).d();
        return paramView;
      }
      if (localaqxn.jdField_a_of_type_Int == 1)
      {
        if (localaqxn.jdField_a_of_type_Boolean)
        {
          paramViewGroup.e.setText(localaqxn.jdField_a_of_type_JavaLangString);
          return paramView;
        }
        paramViewGroup.e.setVisibility(4);
        return paramView;
      }
      localObject = paramView;
      if (localaqxn.jdField_a_of_type_Int != 4) {
        break;
      }
      if (localaqxn.jdField_a_of_type_Boolean)
      {
        paramViewGroup.e.setGravity(17);
        localObject = paramView;
        if (bdhy.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, new String[] { this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131692504) })) {
          break;
        }
        localObject = arni.a(localaqxn.jdField_a_of_type_JavaLangString, localaqxn.jdField_a_of_type_JavaLangString, null);
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
 * Qualified Name:     aqxl
 * JD-Core Version:    0.7.0.1
 */