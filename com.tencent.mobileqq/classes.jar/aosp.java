import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils.TruncateAt;
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
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.widget.CircleFileStateView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class aosp
  extends aopw
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener;
  private BaseFileAssistantActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity;
  private HashMap<Integer, Bitmap> jdField_a_of_type_JavaUtilHashMap;
  private boolean jdField_a_of_type_Boolean;
  private View.OnClickListener b;
  private View.OnClickListener c;
  private View.OnClickListener d;
  
  public aosp(Context paramContext, LinkedHashMap<String, List<FileInfo>> paramLinkedHashMap, BaseFileAssistantActivity paramBaseFileAssistantActivity, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, View.OnLongClickListener paramOnLongClickListener, View.OnClickListener paramOnClickListener3)
  {
    super(paramContext, paramLinkedHashMap);
    if (paramBaseFileAssistantActivity.g() != -1)
    {
      this.jdField_a_of_type_Boolean = true;
      a();
    }
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener1;
    this.b = paramOnClickListener2;
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = paramOnLongClickListener;
    this.c = paramOnClickListener3;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity = paramBaseFileAssistantActivity;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
  }
  
  private String a(FileInfo paramFileInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(apvu.b(paramFileInfo.b()));
    localStringBuilder.append("  ");
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.k()) {
      localStringBuilder.append("来自微信").append("  ");
    }
    localStringBuilder.append(apvb.a(paramFileInfo.a()));
    return localStringBuilder.toString();
  }
  
  private void a()
  {
    if (this.d == null) {
      this.d = new aosq(this);
    }
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, int paramInt3, aosr paramaosr)
  {
    int i = paramString.hashCode();
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(i)) == true)
    {
      paramaosr.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(paramInt2, paramInt3);
      paramaosr.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageBitmap((Bitmap)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i)));
    }
    do
    {
      return;
      switch (paramInt1)
      {
      case 1: 
      case 3: 
      case 4: 
      default: 
        paramaosr.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(paramInt2, paramInt3);
        paramaosr.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageResource(apue.a(paramInt1));
        return;
      case 0: 
        paramaosr.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(paramInt2, paramInt3);
        paramaosr.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130843479);
        paramaosr.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncImage(paramString);
        return;
      case 5: 
        paramaosr.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(paramInt2, paramInt3);
        paramaosr.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130843443);
      }
    } while (!apvb.b(paramString));
    paramaosr.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setApkIconAsyncImage(paramString);
    return;
    paramaosr.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(paramInt2, paramInt3);
    paramaosr.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130843550);
    paramaosr.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncImage(paramString);
  }
  
  public void a(View paramView, int paramInt)
  {
    super.a(paramView, paramInt);
    aoqb localaoqb = (aoqb)paramView.getTag();
    if (localaoqb != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.g() == 1)
      {
        localaoqb.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
        paramView.setEnabled(false);
      }
    }
    else {
      return;
    }
    paramView.setEnabled(true);
    localaoqb.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QfileLocalFileBaseExpandableListAdapter", 4, "groupPosition[" + paramInt1 + "],childPosition[" + paramInt2 + "]");
    }
    if ((paramInt1 == 5) && (paramInt2 == 0) && (QLog.isDevelopLevel())) {
      QLog.d("QfileLocalFileBaseExpandableListAdapter", 4, "ready crash!");
    }
    FileInfo localFileInfo = (FileInfo)getChild(paramInt1, paramInt2);
    if (paramView == null) {}
    try
    {
      aosr localaosr = new aosr(this);
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560450, paramViewGroup, false);
      paramView = paramViewGroup;
      try
      {
        localaosr.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131374866));
        paramView = paramViewGroup;
        localaosr.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.b);
        paramView = paramViewGroup;
        localaosr.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
        paramView = paramViewGroup;
        localaosr.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localaosr);
        paramView = paramViewGroup;
        localaosr.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView = ((CircleFileStateView)paramViewGroup.findViewById(2131361890));
        paramView = paramViewGroup;
        localaosr.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramViewGroup.findViewById(2131366225));
        paramView = paramViewGroup;
        localaosr.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramViewGroup.findViewById(2131366211));
        paramView = paramViewGroup;
        localaosr.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setOnClickListener(this.b);
        paramView = paramViewGroup;
        localaosr.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setTag(localaosr);
        paramView = paramViewGroup;
        localaosr.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131366223));
        paramView = paramViewGroup;
        localaosr.jdField_a_of_type_AndroidWidgetTextView.setGravity(48);
        paramView = paramViewGroup;
        localaosr.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
        paramView = paramViewGroup;
        localaosr.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131366209));
        paramView = paramViewGroup;
        localaosr.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(actn.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), actn.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        paramView = paramViewGroup;
        paramViewGroup.setTag(localaosr);
        while (localFileInfo == null)
        {
          return paramViewGroup;
          localaosr = (aosr)paramView.getTag();
          paramViewGroup = paramView;
        }
        paramView = paramViewGroup;
        localaosr.jdField_b_of_type_Int = paramInt1;
        paramView = paramViewGroup;
        localaosr.jdField_a_of_type_Int = paramInt2;
        paramView = paramViewGroup;
        localFileInfo.a((String)getGroup(paramInt1));
        paramView = paramViewGroup;
        localaosr.jdField_a_of_type_JavaLangObject = localFileInfo;
        paramView = paramViewGroup;
        localaosr.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setOnClickListener(this.c);
        paramView = paramViewGroup;
        localaosr.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setTag(localaosr);
        paramView = paramViewGroup;
        if (this.jdField_a_of_type_Boolean)
        {
          paramView = paramViewGroup;
          localaosr.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setTag(localaosr);
          paramView = paramViewGroup;
          localaosr.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setOnClickListener(this.d);
        }
        paramView = paramViewGroup;
        paramInt1 = localaosr.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.getHeight();
        paramView = paramViewGroup;
        paramInt2 = localaosr.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.getWidth();
        paramView = paramViewGroup;
        Object localObject = localFileInfo.c();
        paramView = paramViewGroup;
        if (this.jdField_a_of_type_Aoqa != null)
        {
          paramView = paramViewGroup;
          localObject = this.jdField_a_of_type_Aoqa.a(localFileInfo);
        }
        paramView = paramViewGroup;
        a((String)localObject, apue.a((String)localObject), paramInt2, paramInt1, localaosr);
        paramView = paramViewGroup;
        localaosr.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        paramView = paramViewGroup;
        localObject = localFileInfo.d();
        paramView = paramViewGroup;
        localaosr.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        paramView = paramViewGroup;
        localaosr.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramView = paramViewGroup;
        localaosr.jdField_b_of_type_AndroidWidgetTextView.setText(a(localFileInfo));
        paramView = paramViewGroup;
        localaosr.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(4);
        paramView = paramViewGroup;
        localaosr.c = 0;
        paramView = paramViewGroup;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f())
        {
          paramView = paramViewGroup;
          localaosr.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
          paramView = paramViewGroup;
          localaosr.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
          paramView = paramViewGroup;
          localaosr.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
          paramView = paramViewGroup;
          localaosr.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(apeh.a(localFileInfo));
        }
        for (;;)
        {
          paramView = paramViewGroup;
          localObject = (LinearLayout.LayoutParams)localaosr.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
          paramView = paramViewGroup;
          ((LinearLayout.LayoutParams)localObject).topMargin = actn.a(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          paramView = paramViewGroup;
          localaosr.jdField_b_of_type_AndroidWidgetTextView.setLineSpacing(TypedValue.applyDimension(1, 0.8F, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics()), 1.0F);
          paramView = paramViewGroup;
          localaosr.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
          paramView = paramViewGroup;
          localaosr.jdField_a_of_type_AndroidWidgetTextView.setLineSpacing(TypedValue.applyDimension(1, 0.25F, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics()), 1.0F);
          return paramViewGroup;
          paramView = paramViewGroup;
          localaosr.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
        }
        paramViewGroup.printStackTrace();
      }
      catch (Exception paramViewGroup) {}
    }
    catch (Exception paramViewGroup)
    {
      label906:
      break label906;
    }
    return paramView;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = super.getGroupView(paramInt, paramBoolean, paramView, paramViewGroup);
    paramView = null;
    if (paramViewGroup != null) {
      paramView = (aoqb)paramViewGroup.getTag();
    }
    if (paramView != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.g() == 1)
      {
        paramView.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
        paramViewGroup.setEnabled(false);
        onGroupExpanded(0);
      }
    }
    else {
      return paramViewGroup;
    }
    paramViewGroup.setEnabled(true);
    paramView.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aosp
 * JD-Core Version:    0.7.0.1
 */