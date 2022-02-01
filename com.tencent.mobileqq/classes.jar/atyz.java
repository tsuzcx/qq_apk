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

public class atyz
  extends BaseAdapter
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private BaseFileAssistantActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity;
  private List<atzb> jdField_a_of_type_JavaUtilList;
  
  public atyz(BaseFileAssistantActivity paramBaseFileAssistantActivity, List<atzb> paramList, View.OnClickListener paramOnClickListener)
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
    if (((atzb)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int == 0) {
      return 0;
    }
    if (((atzb)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int == 3) {
      return 3;
    }
    if (((atzb)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int == 2) {
      return 2;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2 = (atzb)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject1;
    if (localObject2 == null)
    {
      localObject1 = null;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject1;
    }
    if (paramView == null)
    {
      localObject1 = new atza(this);
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(((atzb)localObject2).jdField_b_of_type_Int, paramViewGroup, false);
      paramView = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, paramView).c(30).a();
      paramView.setTag(localObject1);
      if ((((atzb)localObject2).jdField_a_of_type_Int == 0) || (((atzb)localObject2).jdField_a_of_type_Int == 3))
      {
        ((atza)localObject1).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131364268);
        ((atza)localObject1).jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        ((atza)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364267));
        ((atza)localObject1).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131376415));
        ((atza)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364269));
        ((atza)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372002));
        ((atza)localObject1).c = ((TextView)paramView.findViewById(2131377957));
      }
    }
    label206:
    label863:
    for (;;)
    {
      ((atza)localObject1).jdField_a_of_type_Int = ((atzb)localObject2).e;
      ((atza)localObject1).jdField_a_of_type_JavaLangString = ((atzb)localObject2).jdField_c_of_type_JavaLangString;
      if (((atzb)localObject2).jdField_a_of_type_Int == 0) {
        if (((atzb)localObject2).jdField_c_of_type_Boolean)
        {
          ((atza)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          label251:
          if (!((atzb)localObject2).jdField_b_of_type_Boolean) {
            break label516;
          }
          ((atza)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          ((atza)localObject1).jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(((atzb)localObject2).jdField_c_of_type_Int);
          if (TextUtils.isEmpty(((atzb)localObject2).jdField_b_of_type_JavaLangString)) {
            break label529;
          }
          ((atza)localObject1).c.setText(((atzb)localObject2).jdField_b_of_type_JavaLangString);
          ((atza)localObject1).c.setVisibility(0);
          ((atza)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(((atzb)localObject2).jdField_a_of_type_JavaLangString);
          ((atza)localObject1).jdField_a_of_type_AndroidViewView.setTag(localObject1);
          if (((atzb)localObject2).jdField_a_of_type_Boolean) {
            ((atza)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText("(" + ((atzb)localObject2).d + ")");
          }
          switch (((atzb)localObject2).f)
          {
          default: 
            ((atza)localObject1).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839440);
            if (16 != ((atzb)localObject2).e) {
              break;
            }
          }
        }
      }
      for (;;)
      {
        localObject1 = paramView;
        break;
        if ((((atzb)localObject2).jdField_a_of_type_Int != 1) && (((atzb)localObject2).jdField_a_of_type_Int != 4)) {
          break label863;
        }
        ((atza)localObject1).d = ((TextView)paramView.findViewById(2131365627));
        ((atza)localObject1).e = ((TextView)paramView.findViewById(2131378617));
        break label206;
        localObject1 = (atza)paramView.getTag();
        break label206;
        ((atza)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        break label251;
        ((atza)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        break label281;
        ((atza)localObject1).c.setVisibility(8);
        break label314;
        ((atza)localObject1).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839440);
        break label426;
        ((atza)localObject1).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839456);
        break label426;
        ((atza)localObject1).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839447);
        break label426;
        ((atza)localObject1).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839450);
        break label426;
        if (17 != ((atzb)localObject2).e) {
          if (22 == ((atzb)localObject2).e)
          {
            localObject2 = ((bbav)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app.getManager(36)).a(String.valueOf("100160.100163"));
            ((RedTouch)paramView).a((BusinessInfoCheckUpdate.AppInfo)localObject2);
            if (((RedTouch)paramView).b()) {
              ((atza)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
            } else {
              ((atza)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            }
          }
          else
          {
            ((RedTouch)paramView).d();
            continue;
            if (((atzb)localObject2).jdField_a_of_type_Int == 1)
            {
              if (((atzb)localObject2).jdField_a_of_type_Boolean) {
                ((atza)localObject1).e.setText(((atzb)localObject2).jdField_a_of_type_JavaLangString);
              } else {
                ((atza)localObject1).e.setVisibility(4);
              }
            }
            else if (((atzb)localObject2).jdField_a_of_type_Int == 4) {
              if (((atzb)localObject2).jdField_a_of_type_Boolean)
              {
                ((atza)localObject1).e.setGravity(17);
                if (!bhrl.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, new String[] { this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131692095) }))
                {
                  localObject2 = aunj.a(((atzb)localObject2).jdField_a_of_type_JavaLangString, ((atzb)localObject2).jdField_a_of_type_JavaLangString, null);
                  ((atza)localObject1).e.setClickable(true);
                  ((atza)localObject1).e.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
                  ((atza)localObject1).e.setText((CharSequence)localObject2);
                  ((atza)localObject1).e.setTag(localObject1);
                }
              }
              else
              {
                ((atza)localObject1).e.setVisibility(4);
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
 * Qualified Name:     atyz
 * JD-Core Version:    0.7.0.1
 */