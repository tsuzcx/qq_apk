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

public class athf
  extends BaseAdapter
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private BaseFileAssistantActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity;
  private List<athh> jdField_a_of_type_JavaUtilList;
  
  public athf(BaseFileAssistantActivity paramBaseFileAssistantActivity, List<athh> paramList, View.OnClickListener paramOnClickListener)
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
    if (((athh)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int == 0) {
      return 0;
    }
    if (((athh)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int == 3) {
      return 3;
    }
    if (((athh)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int == 2) {
      return 2;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2 = (athh)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject1;
    if (localObject2 == null)
    {
      localObject1 = null;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject1;
    }
    if (paramView == null)
    {
      localObject1 = new athg(this);
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(((athh)localObject2).jdField_b_of_type_Int, paramViewGroup, false);
      paramView = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, paramView).c(30).a();
      paramView.setTag(localObject1);
      if ((((athh)localObject2).jdField_a_of_type_Int == 0) || (((athh)localObject2).jdField_a_of_type_Int == 3))
      {
        ((athg)localObject1).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131364223);
        ((athg)localObject1).jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        ((athg)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364222));
        ((athg)localObject1).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131376275));
        ((athg)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364224));
        ((athg)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371889));
        ((athg)localObject1).c = ((TextView)paramView.findViewById(2131377804));
      }
    }
    label206:
    label863:
    for (;;)
    {
      ((athg)localObject1).jdField_a_of_type_Int = ((athh)localObject2).e;
      ((athg)localObject1).jdField_a_of_type_JavaLangString = ((athh)localObject2).jdField_c_of_type_JavaLangString;
      if (((athh)localObject2).jdField_a_of_type_Int == 0) {
        if (((athh)localObject2).jdField_c_of_type_Boolean)
        {
          ((athg)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          label251:
          if (!((athh)localObject2).jdField_b_of_type_Boolean) {
            break label516;
          }
          ((athg)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          ((athg)localObject1).jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(((athh)localObject2).jdField_c_of_type_Int);
          if (TextUtils.isEmpty(((athh)localObject2).jdField_b_of_type_JavaLangString)) {
            break label529;
          }
          ((athg)localObject1).c.setText(((athh)localObject2).jdField_b_of_type_JavaLangString);
          ((athg)localObject1).c.setVisibility(0);
          ((athg)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(((athh)localObject2).jdField_a_of_type_JavaLangString);
          ((athg)localObject1).jdField_a_of_type_AndroidViewView.setTag(localObject1);
          if (((athh)localObject2).jdField_a_of_type_Boolean) {
            ((athg)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText("(" + ((athh)localObject2).d + ")");
          }
          switch (((athh)localObject2).f)
          {
          default: 
            ((athg)localObject1).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839432);
            if (16 != ((athh)localObject2).e) {
              break;
            }
          }
        }
      }
      for (;;)
      {
        localObject1 = paramView;
        break;
        if ((((athh)localObject2).jdField_a_of_type_Int != 1) && (((athh)localObject2).jdField_a_of_type_Int != 4)) {
          break label863;
        }
        ((athg)localObject1).d = ((TextView)paramView.findViewById(2131365585));
        ((athg)localObject1).e = ((TextView)paramView.findViewById(2131378459));
        break label206;
        localObject1 = (athg)paramView.getTag();
        break label206;
        ((athg)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        break label251;
        ((athg)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        break label281;
        ((athg)localObject1).c.setVisibility(8);
        break label314;
        ((athg)localObject1).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839432);
        break label426;
        ((athg)localObject1).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839448);
        break label426;
        ((athg)localObject1).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839439);
        break label426;
        ((athg)localObject1).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839442);
        break label426;
        if (17 != ((athh)localObject2).e) {
          if (22 == ((athh)localObject2).e)
          {
            localObject2 = ((baif)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app.getManager(36)).a(String.valueOf("100160.100163"));
            ((RedTouch)paramView).a((BusinessInfoCheckUpdate.AppInfo)localObject2);
            if (((RedTouch)paramView).b()) {
              ((athg)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
            } else {
              ((athg)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            }
          }
          else
          {
            ((RedTouch)paramView).d();
            continue;
            if (((athh)localObject2).jdField_a_of_type_Int == 1)
            {
              if (((athh)localObject2).jdField_a_of_type_Boolean) {
                ((athg)localObject1).e.setText(((athh)localObject2).jdField_a_of_type_JavaLangString);
              } else {
                ((athg)localObject1).e.setVisibility(4);
              }
            }
            else if (((athh)localObject2).jdField_a_of_type_Int == 4) {
              if (((athh)localObject2).jdField_a_of_type_Boolean)
              {
                ((athg)localObject1).e.setGravity(17);
                if (!bgrj.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, new String[] { this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131692090) }))
                {
                  localObject2 = atvo.a(((athh)localObject2).jdField_a_of_type_JavaLangString, ((athh)localObject2).jdField_a_of_type_JavaLangString, null);
                  ((athg)localObject1).e.setClickable(true);
                  ((athg)localObject1).e.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
                  ((athg)localObject1).e.setText((CharSequence)localObject2);
                  ((athg)localObject1).e.setTag(localObject1);
                }
              }
              else
              {
                ((athg)localObject1).e.setVisibility(4);
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
 * Qualified Name:     athf
 * JD-Core Version:    0.7.0.1
 */