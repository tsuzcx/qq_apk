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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class aslj
  extends BaseAdapter
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private BaseFileAssistantActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity;
  private List<asll> jdField_a_of_type_JavaUtilList;
  
  public aslj(BaseFileAssistantActivity paramBaseFileAssistantActivity, List<asll> paramList, View.OnClickListener paramOnClickListener)
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
    if (((asll)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int == 0) {
      return 0;
    }
    if (((asll)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int == 3) {
      return 3;
    }
    if (((asll)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int == 2) {
      return 2;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2 = (asll)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject1;
    if (localObject2 == null)
    {
      localObject1 = null;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject1;
    }
    if (paramView == null)
    {
      localObject1 = new aslk(this);
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(((asll)localObject2).jdField_b_of_type_Int, paramViewGroup, false);
      paramView = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, paramView).c(30).a();
      paramView.setTag(localObject1);
      if ((((asll)localObject2).jdField_a_of_type_Int == 0) || (((asll)localObject2).jdField_a_of_type_Int == 3))
      {
        ((aslk)localObject1).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131364286);
        ((aslk)localObject1).jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        ((aslk)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364285));
        ((aslk)localObject1).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131376183));
        ((aslk)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364287));
        ((aslk)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371967));
        ((aslk)localObject1).c = ((TextView)paramView.findViewById(2131377726));
      }
    }
    label206:
    label863:
    for (;;)
    {
      ((aslk)localObject1).jdField_a_of_type_Int = ((asll)localObject2).e;
      ((aslk)localObject1).jdField_a_of_type_JavaLangString = ((asll)localObject2).jdField_c_of_type_JavaLangString;
      if (((asll)localObject2).jdField_a_of_type_Int == 0) {
        if (((asll)localObject2).jdField_c_of_type_Boolean)
        {
          ((aslk)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          label251:
          if (!((asll)localObject2).jdField_b_of_type_Boolean) {
            break label516;
          }
          ((aslk)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          ((aslk)localObject1).jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(((asll)localObject2).jdField_c_of_type_Int);
          if (TextUtils.isEmpty(((asll)localObject2).jdField_b_of_type_JavaLangString)) {
            break label529;
          }
          ((aslk)localObject1).c.setText(((asll)localObject2).jdField_b_of_type_JavaLangString);
          ((aslk)localObject1).c.setVisibility(0);
          ((aslk)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(((asll)localObject2).jdField_a_of_type_JavaLangString);
          ((aslk)localObject1).jdField_a_of_type_AndroidViewView.setTag(localObject1);
          if (((asll)localObject2).jdField_a_of_type_Boolean) {
            ((aslk)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText("(" + ((asll)localObject2).d + ")");
          }
          switch (((asll)localObject2).f)
          {
          default: 
            ((aslk)localObject1).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839475);
            if (16 != ((asll)localObject2).e) {
              break;
            }
          }
        }
      }
      for (;;)
      {
        localObject1 = paramView;
        break;
        if ((((asll)localObject2).jdField_a_of_type_Int != 1) && (((asll)localObject2).jdField_a_of_type_Int != 4)) {
          break label863;
        }
        ((aslk)localObject1).d = ((TextView)paramView.findViewById(2131365660));
        ((aslk)localObject1).e = ((TextView)paramView.findViewById(2131378381));
        break label206;
        localObject1 = (aslk)paramView.getTag();
        break label206;
        ((aslk)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        break label251;
        ((aslk)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        break label281;
        ((aslk)localObject1).c.setVisibility(8);
        break label314;
        ((aslk)localObject1).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839475);
        break label426;
        ((aslk)localObject1).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839491);
        break label426;
        ((aslk)localObject1).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839482);
        break label426;
        ((aslk)localObject1).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839485);
        break label426;
        if (17 != ((asll)localObject2).e) {
          if (22 == ((asll)localObject2).e)
          {
            localObject2 = ((azvi)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app.getManager(36)).a(String.valueOf("100160.100163"));
            ((RedTouch)paramView).a((BusinessInfoCheckUpdate.AppInfo)localObject2);
            if (((RedTouch)paramView).c()) {
              ((aslk)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
            } else {
              ((aslk)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            }
          }
          else
          {
            ((RedTouch)paramView).d();
            continue;
            if (((asll)localObject2).jdField_a_of_type_Int == 1)
            {
              if (((asll)localObject2).jdField_a_of_type_Boolean) {
                ((aslk)localObject1).e.setText(((asll)localObject2).jdField_a_of_type_JavaLangString);
              } else {
                ((aslk)localObject1).e.setVisibility(4);
              }
            }
            else if (((asll)localObject2).jdField_a_of_type_Int == 4) {
              if (((asll)localObject2).jdField_a_of_type_Boolean)
              {
                ((aslk)localObject1).e.setGravity(17);
                if (!bfyg.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, new String[] { this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131692143) }))
                {
                  localObject2 = aszt.a(((asll)localObject2).jdField_a_of_type_JavaLangString, ((asll)localObject2).jdField_a_of_type_JavaLangString, null);
                  ((aslk)localObject1).e.setClickable(true);
                  ((aslk)localObject1).e.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
                  ((aslk)localObject1).e.setText((CharSequence)localObject2);
                  ((aslk)localObject1).e.setTag(localObject1);
                }
              }
              else
              {
                ((aslk)localObject1).e.setVisibility(4);
              }
            }
          }
        }
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aslj
 * JD-Core Version:    0.7.0.1
 */