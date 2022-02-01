import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class atpp
  extends BaseAdapter
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private BaseFileAssistantActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity;
  private List<atpr> jdField_a_of_type_JavaUtilList;
  
  public atpp(BaseFileAssistantActivity paramBaseFileAssistantActivity, List<atpr> paramList, View.OnClickListener paramOnClickListener)
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
    if (((atpr)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int == 0) {
      return 0;
    }
    if (((atpr)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int == 3) {
      return 3;
    }
    if (((atpr)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int == 2) {
      return 2;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2 = (atpr)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject1;
    if (localObject2 == null)
    {
      localObject1 = null;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject1;
    }
    if (paramView == null)
    {
      localObject1 = new atpq(this);
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(((atpr)localObject2).jdField_b_of_type_Int, paramViewGroup, false);
      paramView = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, paramView).d(30).a();
      paramView.setTag(localObject1);
      if ((((atpr)localObject2).jdField_a_of_type_Int == 0) || (((atpr)localObject2).jdField_a_of_type_Int == 3))
      {
        ((atpq)localObject1).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131364364);
        ((atpq)localObject1).jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        ((atpq)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364363));
        ((atpq)localObject1).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131376432));
        ((atpq)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364365));
        ((atpq)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372158));
        ((atpq)localObject1).c = ((TextView)paramView.findViewById(2131378007));
      }
    }
    label206:
    label864:
    for (;;)
    {
      ((atpq)localObject1).jdField_a_of_type_Int = ((atpr)localObject2).e;
      ((atpq)localObject1).jdField_a_of_type_JavaLangString = ((atpr)localObject2).jdField_c_of_type_JavaLangString;
      if (((atpr)localObject2).jdField_a_of_type_Int == 0) {
        if (((atpr)localObject2).jdField_c_of_type_Boolean)
        {
          ((atpq)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          label251:
          if (!((atpr)localObject2).jdField_b_of_type_Boolean) {
            break label516;
          }
          ((atpq)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          ((atpq)localObject1).jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(((atpr)localObject2).jdField_c_of_type_Int);
          if (TextUtils.isEmpty(((atpr)localObject2).jdField_b_of_type_JavaLangString)) {
            break label529;
          }
          ((atpq)localObject1).c.setText(((atpr)localObject2).jdField_b_of_type_JavaLangString);
          ((atpq)localObject1).c.setVisibility(0);
          ((atpq)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(((atpr)localObject2).jdField_a_of_type_JavaLangString);
          ((atpq)localObject1).jdField_a_of_type_AndroidViewView.setTag(localObject1);
          if (((atpr)localObject2).jdField_a_of_type_Boolean) {
            ((atpq)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText("(" + ((atpr)localObject2).d + ")");
          }
          switch (((atpr)localObject2).f)
          {
          default: 
            ((atpq)localObject1).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839496);
            if (16 != ((atpr)localObject2).e) {
              break;
            }
          }
        }
      }
      for (;;)
      {
        localObject1 = paramView;
        break;
        if ((((atpr)localObject2).jdField_a_of_type_Int != 1) && (((atpr)localObject2).jdField_a_of_type_Int != 4)) {
          break label864;
        }
        ((atpq)localObject1).d = ((TextView)paramView.findViewById(2131365754));
        ((atpq)localObject1).e = ((TextView)paramView.findViewById(2131378672));
        break label206;
        localObject1 = (atpq)paramView.getTag();
        break label206;
        ((atpq)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        break label251;
        ((atpq)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        break label281;
        ((atpq)localObject1).c.setVisibility(8);
        break label314;
        ((atpq)localObject1).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839496);
        break label426;
        ((atpq)localObject1).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839512);
        break label426;
        ((atpq)localObject1).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839503);
        break label426;
        ((atpq)localObject1).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839506);
        break label426;
        if (17 != ((atpr)localObject2).e) {
          if (22 == ((atpr)localObject2).e)
          {
            localObject2 = ((bbbq)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app.getManager(QQManagerFactory.MGR_RED_TOUCH)).a(String.valueOf("100160.100163"));
            ((RedTouch)paramView).a((BusinessInfoCheckUpdate.AppInfo)localObject2);
            if (((RedTouch)paramView).c()) {
              ((atpq)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
            } else {
              ((atpq)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            }
          }
          else
          {
            ((RedTouch)paramView).d();
            continue;
            if (((atpr)localObject2).jdField_a_of_type_Int == 1)
            {
              if (((atpr)localObject2).jdField_a_of_type_Boolean) {
                ((atpq)localObject1).e.setText(((atpr)localObject2).jdField_a_of_type_JavaLangString);
              } else {
                ((atpq)localObject1).e.setVisibility(4);
              }
            }
            else if (((atpr)localObject2).jdField_a_of_type_Int == 4) {
              if (((atpr)localObject2).jdField_a_of_type_Boolean)
              {
                ((atpq)localObject1).e.setGravity(17);
                if (!bhgy.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, new String[] { this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131692233) }))
                {
                  localObject2 = auea.a(((atpr)localObject2).jdField_a_of_type_JavaLangString, ((atpr)localObject2).jdField_a_of_type_JavaLangString, null);
                  ((atpq)localObject1).e.setClickable(true);
                  ((atpq)localObject1).e.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
                  ((atpq)localObject1).e.setText((CharSequence)localObject2);
                  ((atpq)localObject1).e.setTag(localObject1);
                }
              }
              else
              {
                ((atpq)localObject1).e.setVisibility(4);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atpp
 * JD-Core Version:    0.7.0.1
 */