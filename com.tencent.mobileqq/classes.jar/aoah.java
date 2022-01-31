import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.widget.CircleFileStateView;
import java.util.LinkedHashMap;
import java.util.List;

public class aoah
  extends anzd
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener;
  private BaseFileAssistantActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity;
  private View.OnClickListener b;
  private View.OnClickListener c;
  
  public aoah(Context paramContext, LinkedHashMap<String, List<WeiYunFileInfo>> paramLinkedHashMap, BaseFileAssistantActivity paramBaseFileAssistantActivity, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, View.OnLongClickListener paramOnLongClickListener, View.OnClickListener paramOnClickListener3)
  {
    super(paramContext, paramLinkedHashMap);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener1;
    this.b = paramOnClickListener2;
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = paramOnLongClickListener;
    this.c = paramOnClickListener3;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity = paramBaseFileAssistantActivity;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
  }
  
  private String a(WeiYunFileInfo paramWeiYunFileInfo)
  {
    return apdh.a(paramWeiYunFileInfo.jdField_a_of_type_Long);
  }
  
  private String a(String paramString1, String paramString2)
  {
    if ((paramString2 == null) || (paramString2.equalsIgnoreCase(""))) {
      return "";
    }
    return paramString1 + paramString2;
  }
  
  private void a(AsyncImageView paramAsyncImageView, String paramString)
  {
    paramAsyncImageView.setDefaultImage(2130843395);
    paramAsyncImageView.setAsyncImage(paramString);
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    WeiYunFileInfo localWeiYunFileInfo = (WeiYunFileInfo)getChild(paramInt1, paramInt2);
    if (localWeiYunFileInfo == null) {
      return paramView;
    }
    if (paramView == null) {
      localObject1 = paramView;
    }
    for (;;)
    {
      try
      {
        localObject2 = new aoai(this);
        localObject1 = paramView;
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131494879, paramViewGroup, false);
        localObject1 = paramView;
        ((aoai)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131309122));
        localObject1 = paramView;
        ((aoai)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.b);
        localObject1 = paramView;
        ((aoai)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
        localObject1 = paramView;
        ((aoai)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localObject2);
        localObject1 = paramView;
        ((aoai)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView = ((CircleFileStateView)paramView.findViewById(2131296354));
        localObject1 = paramView;
        ((aoai)localObject2).jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131300623));
        localObject1 = paramView;
        ((aoai)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131300609));
        localObject1 = paramView;
        ((aoai)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setOnClickListener(this.b);
        localObject1 = paramView;
        ((aoai)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setTag(localObject2);
        localObject1 = paramView;
        ((aoai)localObject2).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131300621));
        localObject1 = paramView;
        ((aoai)localObject2).jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
        localObject1 = paramView;
        ((aoai)localObject2).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131300607));
        localObject1 = paramView;
        ((aoai)localObject2).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131303219));
        localObject1 = paramView;
        ((aoai)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(aciy.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), aciy.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        localObject1 = paramView;
        paramView.setTag(localObject2);
        paramViewGroup = (ViewGroup)localObject2;
      }
      catch (Exception paramViewGroup)
      {
        Object localObject2;
        int i;
        paramView = (View)localObject1;
        continue;
        continue;
      }
      try
      {
        i = apck.a(localWeiYunFileInfo.c);
        apck.a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localWeiYunFileInfo.h, i);
        paramViewGroup.jdField_b_of_type_Int = paramInt1;
        paramViewGroup.jdField_a_of_type_Int = paramInt2;
        paramViewGroup.jdField_a_of_type_JavaLangObject = localWeiYunFileInfo;
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setOnClickListener(this.c);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setTag(paramViewGroup);
        paramViewGroup.jdField_c_of_type_Int = 1;
        if ((apck.a(localWeiYunFileInfo.c) == 0) && (bace.b(localWeiYunFileInfo.h))) {
          a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localWeiYunFileInfo.h);
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localWeiYunFileInfo.c);
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(a(localWeiYunFileInfo));
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131626885);
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131626862);
        localObject1 = apea.b(localWeiYunFileInfo.b) + a((String)localObject2, (String)localObject1);
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app.a().a(localWeiYunFileInfo.jdField_a_of_type_JavaLangString);
        if (localObject2 == null) {
          continue;
        }
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(1);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setProgress((int)(((FileManagerEntity)localObject2).fProgress * 100.0F));
        paramViewGroup.jdField_c_of_type_Int = 2;
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.a(true);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app.a().c(localWeiYunFileInfo.jdField_a_of_type_JavaLangString);
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            localObject1 = localObject2;
            if (!apdh.b(((FileManagerEntity)localObject2).getFilePath()))
            {
              ((FileManagerEntity)localObject2).setCloudType(2);
              if (((FileManagerEntity)localObject2).getId() > 0L) {
                ((FileManagerEntity)localObject2).nOpType = 5;
              }
              localObject1 = localObject2;
              if (((FileManagerEntity)localObject2).status != 1)
              {
                paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setProgress((int)(((FileManagerEntity)localObject2).fProgress * 100.0F));
                paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.a(true);
                localObject1 = localObject2;
              }
            }
          }
        }
        if (localObject1 != null) {
          switch (((FileManagerEntity)localObject1).status)
          {
          }
        }
      }
      catch (Exception paramViewGroup)
      {
        paramViewGroup.printStackTrace();
        continue;
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
        paramViewGroup.jdField_c_of_type_Int = 3;
        continue;
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(4);
        paramViewGroup.jdField_c_of_type_Int = 0;
        continue;
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
        paramViewGroup.jdField_c_of_type_Int = 1;
        continue;
        paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
        continue;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f()) {
        continue;
      }
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(aonm.a(localWeiYunFileInfo));
      localObject1 = (LinearLayout.LayoutParams)paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject1).topMargin = aciy.a(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setLineSpacing(TypedValue.applyDimension(1, 0.8F, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics()), 1.0F);
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setLineSpacing(TypedValue.applyDimension(1, 0.25F, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics()), 1.0F);
      return paramView;
      localObject1 = paramView;
      paramViewGroup = (aoai)paramView.getTag();
      continue;
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoah
 * JD-Core Version:    0.7.0.1
 */