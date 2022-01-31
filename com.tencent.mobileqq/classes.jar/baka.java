import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.teamworkforgroup.GroupPadTemplateInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class baka
  extends BaseAdapter
  implements View.OnClickListener
{
  public static int a;
  public static int b;
  Context jdField_a_of_type_AndroidContentContext;
  protected View.OnClickListener a;
  final List<GroupPadTemplateInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private Set<String> b;
  
  static
  {
    jdField_a_of_type_Int = 1;
    jdField_b_of_type_Int = 2;
  }
  
  public baka(Context paramContext, View.OnClickListener paramOnClickListener)
  {
    this.jdField_b_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(AsyncImageView paramAsyncImageView, GroupPadTemplateInfo paramGroupPadTemplateInfo)
  {
    if (paramGroupPadTemplateInfo != null)
    {
      Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840072);
      if (!bhsz.a(paramGroupPadTemplateInfo.mobThumbUrl)) {
        paramAsyncImageView.setImageDrawable(localDrawable);
      }
      for (;;)
      {
        return;
        String str = paramGroupPadTemplateInfo.mobThumbUrl;
        paramGroupPadTemplateInfo = URLDrawable.URLDrawableOptions.obtain();
        paramGroupPadTemplateInfo.mLoadingDrawable = localDrawable;
        paramGroupPadTemplateInfo.mFailedDrawable = localDrawable;
        Object localObject = null;
        try
        {
          paramGroupPadTemplateInfo = URLDrawable.getDrawable(str, paramGroupPadTemplateInfo);
          if (paramGroupPadTemplateInfo != null)
          {
            if ((paramGroupPadTemplateInfo.getStatus() == 2) && (this.jdField_b_of_type_JavaUtilSet.remove(str))) {
              paramGroupPadTemplateInfo.restartDownload();
            }
            paramGroupPadTemplateInfo.setDownloadListener(new bakb(this, str));
            paramAsyncImageView.setImageDrawable(paramGroupPadTemplateInfo);
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("GroupPadTemplateAdapter", 2, "loadThumbImage is ok. url: " + str);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            paramGroupPadTemplateInfo = localObject;
            if (QLog.isColorLevel())
            {
              QLog.e("GroupPadTemplateAdapter", 2, localException, new Object[] { "loadThumbImage failed" });
              paramGroupPadTemplateInfo = localObject;
            }
          }
          paramAsyncImageView.setImageDrawable(localDrawable);
          return;
        }
      }
    }
    paramAsyncImageView.setImageResource(2130840072);
  }
  
  public GroupPadTemplateInfo a()
  {
    GroupPadTemplateInfo localGroupPadTemplateInfo = new GroupPadTemplateInfo();
    localGroupPadTemplateInfo.docOrSheetType = 1;
    localGroupPadTemplateInfo.templateName = this.jdField_a_of_type_AndroidContentContext.getString(2131693316);
    return localGroupPadTemplateInfo;
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(List<GroupPadTemplateInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        GroupPadTemplateInfo localGroupPadTemplateInfo = (GroupPadTemplateInfo)paramList.next();
        if ((localGroupPadTemplateInfo != null) && (localGroupPadTemplateInfo.templateID >= 0)) {
          this.jdField_a_of_type_JavaUtilList.add(localGroupPadTemplateInfo);
        }
      }
      paramList = a();
      this.jdField_a_of_type_JavaUtilList.add(paramList);
    }
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    GroupPadTemplateInfo localGroupPadTemplateInfo = (GroupPadTemplateInfo)getItem(paramInt);
    if (localGroupPadTemplateInfo != null) {
      return localGroupPadTemplateInfo.templateID;
    }
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    GroupPadTemplateInfo localGroupPadTemplateInfo = (GroupPadTemplateInfo)getItem(paramInt);
    if (getCount() == paramInt + 1)
    {
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559167, null);
      paramView = new bakc(this);
      paramView.jdField_a_of_type_Int = jdField_b_of_type_Int;
      paramView.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramViewGroup.findViewById(2131367362));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131367358));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131367356));
      paramView.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupPadTemplateInfo = localGroupPadTemplateInfo;
      paramViewGroup.setTag(paramView);
      paramViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      if (paramView.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupPadTemplateInfo == null) {
        break label287;
      }
      if (paramView.jdField_a_of_type_Int != jdField_a_of_type_Int) {
        break label264;
      }
      a(paramView.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localGroupPadTemplateInfo);
      label135:
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(localGroupPadTemplateInfo.templateName);
    }
    for (;;)
    {
      if (AppSetting.c)
      {
        if (localGroupPadTemplateInfo == null) {
          break label309;
        }
        paramViewGroup.setContentDescription(localGroupPadTemplateInfo.templateName);
      }
      return paramViewGroup;
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559166, null);
      paramView = new bakc(this);
      paramView.jdField_a_of_type_Int = jdField_a_of_type_Int;
      paramView.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramViewGroup.findViewById(2131367361));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131367360));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131367355));
      paramView.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupPadTemplateInfo = localGroupPadTemplateInfo;
      paramViewGroup.setTag(paramView);
      paramViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      break;
      label264:
      if (paramView.jdField_a_of_type_Int != jdField_b_of_type_Int) {
        break label135;
      }
      paramView.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageResource(2130840074);
      break label135;
      label287:
      paramView.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageResource(2130840072);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText("");
    }
    label309:
    paramViewGroup.setContentDescription("");
    return paramViewGroup;
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baka
 * JD-Core Version:    0.7.0.1
 */