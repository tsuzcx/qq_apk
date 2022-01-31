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

public class aqqa
  extends aqni
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener;
  private BaseFileAssistantActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity;
  private HashMap<Integer, Bitmap> jdField_a_of_type_JavaUtilHashMap;
  private boolean jdField_a_of_type_Boolean;
  private Context jdField_b_of_type_AndroidContentContext;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener;
  private View.OnClickListener c;
  private View.OnClickListener d;
  
  public aqqa(Context paramContext, LinkedHashMap<String, List<FileInfo>> paramLinkedHashMap, BaseFileAssistantActivity paramBaseFileAssistantActivity, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, View.OnLongClickListener paramOnLongClickListener, View.OnClickListener paramOnClickListener3)
  {
    super(paramContext, paramLinkedHashMap);
    if (paramBaseFileAssistantActivity.g() != -1)
    {
      this.jdField_a_of_type_Boolean = true;
      a();
    }
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener1;
    this.jdField_b_of_type_AndroidViewView$OnClickListener = paramOnClickListener2;
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = paramOnLongClickListener;
    this.c = paramOnClickListener3;
    this.jdField_b_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity = paramBaseFileAssistantActivity;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_b_of_type_AndroidContentContext);
  }
  
  private String a(FileInfo paramFileInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(arth.b(paramFileInfo.b()));
    localStringBuilder.append("  ");
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.k()) {
      localStringBuilder.append("来自微信").append("  ");
    }
    localStringBuilder.append(arso.a(paramFileInfo.a()));
    return localStringBuilder.toString();
  }
  
  private void a()
  {
    if (this.d == null) {
      this.d = new aqqb(this);
    }
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, int paramInt3, aqqc paramaqqc)
  {
    int i = paramString.hashCode();
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(i)) == true)
    {
      paramaqqc.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(paramInt2, paramInt3);
      paramaqqc.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageBitmap((Bitmap)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i)));
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
        paramaqqc.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(paramInt2, paramInt3);
        paramaqqc.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageResource(arrr.a(paramInt1));
        return;
      case 0: 
        paramaqqc.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(paramInt2, paramInt3);
        paramaqqc.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130843911);
        paramaqqc.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncImage(paramString);
        return;
      case 5: 
        paramaqqc.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(paramInt2, paramInt3);
        paramaqqc.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130843875);
      }
    } while (!arso.b(paramString));
    paramaqqc.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setApkIconAsyncImage(paramString);
    return;
    paramaqqc.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(paramInt2, paramInt3);
    paramaqqc.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130843982);
    paramaqqc.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncImage(paramString);
  }
  
  public void a(View paramView, int paramInt)
  {
    super.a(paramView, paramInt);
    aqnn localaqnn = (aqnn)paramView.getTag();
    if (localaqnn != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.g() == 1)
      {
        localaqnn.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
        paramView.setEnabled(false);
      }
    }
    else {
      return;
    }
    paramView.setEnabled(true);
    localaqnn.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
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
      aqqc localaqqc = new aqqc(this);
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560642, paramViewGroup, false);
      paramView = paramViewGroup;
      try
      {
        localaqqc.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131375387));
        paramView = paramViewGroup;
        localaqqc.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        paramView = paramViewGroup;
        localaqqc.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
        paramView = paramViewGroup;
        localaqqc.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localaqqc);
        paramView = paramViewGroup;
        localaqqc.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView = ((CircleFileStateView)paramViewGroup.findViewById(2131361889));
        paramView = paramViewGroup;
        localaqqc.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramViewGroup.findViewById(2131366315));
        paramView = paramViewGroup;
        localaqqc.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramViewGroup.findViewById(2131366301));
        paramView = paramViewGroup;
        localaqqc.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        paramView = paramViewGroup;
        localaqqc.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setTag(localaqqc);
        paramView = paramViewGroup;
        localaqqc.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131366313));
        paramView = paramViewGroup;
        localaqqc.jdField_a_of_type_AndroidWidgetTextView.setGravity(48);
        paramView = paramViewGroup;
        localaqqc.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
        paramView = paramViewGroup;
        localaqqc.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131366299));
        paramView = paramViewGroup;
        localaqqc.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(aepi.a(70.0F, this.jdField_b_of_type_AndroidContentContext.getResources()), aepi.a(70.0F, this.jdField_b_of_type_AndroidContentContext.getResources()));
        paramView = paramViewGroup;
        paramViewGroup.setTag(localaqqc);
        while (localFileInfo == null)
        {
          return paramViewGroup;
          localaqqc = (aqqc)paramView.getTag();
          paramViewGroup = paramView;
        }
        paramView = paramViewGroup;
        localaqqc.jdField_b_of_type_Int = paramInt1;
        paramView = paramViewGroup;
        localaqqc.jdField_a_of_type_Int = paramInt2;
        paramView = paramViewGroup;
        localFileInfo.a((String)getGroup(paramInt1));
        paramView = paramViewGroup;
        localaqqc.jdField_a_of_type_JavaLangObject = localFileInfo;
        paramView = paramViewGroup;
        localaqqc.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setOnClickListener(this.c);
        paramView = paramViewGroup;
        localaqqc.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setTag(localaqqc);
        paramView = paramViewGroup;
        if (this.jdField_a_of_type_Boolean)
        {
          paramView = paramViewGroup;
          localaqqc.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setTag(localaqqc);
          paramView = paramViewGroup;
          localaqqc.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setOnClickListener(this.d);
        }
        paramView = paramViewGroup;
        paramInt1 = localaqqc.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.getHeight();
        paramView = paramViewGroup;
        paramInt2 = localaqqc.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.getWidth();
        paramView = paramViewGroup;
        Object localObject = localFileInfo.c();
        paramView = paramViewGroup;
        if (this.jdField_a_of_type_Aqnm != null)
        {
          paramView = paramViewGroup;
          localObject = this.jdField_a_of_type_Aqnm.a(localFileInfo);
        }
        paramView = paramViewGroup;
        a((String)localObject, arrr.a((String)localObject), paramInt2, paramInt1, localaqqc);
        paramView = paramViewGroup;
        localaqqc.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        paramView = paramViewGroup;
        localObject = localFileInfo.d();
        paramView = paramViewGroup;
        localaqqc.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        paramView = paramViewGroup;
        localaqqc.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramView = paramViewGroup;
        localaqqc.jdField_b_of_type_AndroidWidgetTextView.setText(a(localFileInfo));
        paramView = paramViewGroup;
        localaqqc.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(4);
        paramView = paramViewGroup;
        localaqqc.c = 0;
        paramView = paramViewGroup;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f())
        {
          paramView = paramViewGroup;
          localaqqc.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
          paramView = paramViewGroup;
          localaqqc.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
          paramView = paramViewGroup;
          localaqqc.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
          paramView = paramViewGroup;
          localaqqc.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(arbs.a(localFileInfo));
        }
        for (;;)
        {
          paramView = paramViewGroup;
          localObject = (LinearLayout.LayoutParams)localaqqc.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
          paramView = paramViewGroup;
          ((LinearLayout.LayoutParams)localObject).topMargin = aepi.a(3.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
          paramView = paramViewGroup;
          localaqqc.jdField_b_of_type_AndroidWidgetTextView.setLineSpacing(TypedValue.applyDimension(1, 0.8F, this.jdField_b_of_type_AndroidContentContext.getResources().getDisplayMetrics()), 1.0F);
          paramView = paramViewGroup;
          localaqqc.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
          paramView = paramViewGroup;
          localaqqc.jdField_a_of_type_AndroidWidgetTextView.setLineSpacing(TypedValue.applyDimension(1, 0.25F, this.jdField_b_of_type_AndroidContentContext.getResources().getDisplayMetrics()), 1.0F);
          return paramViewGroup;
          paramView = paramViewGroup;
          localaqqc.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
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
      paramView = (aqnn)paramViewGroup.getTag();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqqa
 * JD-Core Version:    0.7.0.1
 */