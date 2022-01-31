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

public class aqlr
  extends aqiz
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
  
  public aqlr(Context paramContext, LinkedHashMap<String, List<FileInfo>> paramLinkedHashMap, BaseFileAssistantActivity paramBaseFileAssistantActivity, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, View.OnLongClickListener paramOnLongClickListener, View.OnClickListener paramOnClickListener3)
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
    localStringBuilder.append(aroy.b(paramFileInfo.b()));
    localStringBuilder.append("  ");
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.k()) {
      localStringBuilder.append("来自微信").append("  ");
    }
    localStringBuilder.append(arof.a(paramFileInfo.a()));
    return localStringBuilder.toString();
  }
  
  private void a()
  {
    if (this.d == null) {
      this.d = new aqls(this);
    }
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, int paramInt3, aqlt paramaqlt)
  {
    int i = paramString.hashCode();
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(i)) == true)
    {
      paramaqlt.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(paramInt2, paramInt3);
      paramaqlt.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageBitmap((Bitmap)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i)));
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
        paramaqlt.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(paramInt2, paramInt3);
        paramaqlt.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageResource(arni.a(paramInt1));
        return;
      case 0: 
        paramaqlt.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(paramInt2, paramInt3);
        paramaqlt.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130843839);
        paramaqlt.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncImage(paramString);
        return;
      case 5: 
        paramaqlt.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(paramInt2, paramInt3);
        paramaqlt.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130843803);
      }
    } while (!arof.b(paramString));
    paramaqlt.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setApkIconAsyncImage(paramString);
    return;
    paramaqlt.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(paramInt2, paramInt3);
    paramaqlt.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130843910);
    paramaqlt.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncImage(paramString);
  }
  
  public void a(View paramView, int paramInt)
  {
    super.a(paramView, paramInt);
    aqje localaqje = (aqje)paramView.getTag();
    if (localaqje != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.g() == 1)
      {
        localaqje.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
        paramView.setEnabled(false);
      }
    }
    else {
      return;
    }
    paramView.setEnabled(true);
    localaqje.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
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
      aqlt localaqlt = new aqlt(this);
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560624, paramViewGroup, false);
      paramView = paramViewGroup;
      try
      {
        localaqlt.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131375336));
        paramView = paramViewGroup;
        localaqlt.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        paramView = paramViewGroup;
        localaqlt.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
        paramView = paramViewGroup;
        localaqlt.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localaqlt);
        paramView = paramViewGroup;
        localaqlt.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView = ((CircleFileStateView)paramViewGroup.findViewById(2131361889));
        paramView = paramViewGroup;
        localaqlt.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramViewGroup.findViewById(2131366313));
        paramView = paramViewGroup;
        localaqlt.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramViewGroup.findViewById(2131366299));
        paramView = paramViewGroup;
        localaqlt.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        paramView = paramViewGroup;
        localaqlt.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setTag(localaqlt);
        paramView = paramViewGroup;
        localaqlt.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131366311));
        paramView = paramViewGroup;
        localaqlt.jdField_a_of_type_AndroidWidgetTextView.setGravity(48);
        paramView = paramViewGroup;
        localaqlt.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
        paramView = paramViewGroup;
        localaqlt.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131366297));
        paramView = paramViewGroup;
        localaqlt.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(aekt.a(70.0F, this.jdField_b_of_type_AndroidContentContext.getResources()), aekt.a(70.0F, this.jdField_b_of_type_AndroidContentContext.getResources()));
        paramView = paramViewGroup;
        paramViewGroup.setTag(localaqlt);
        while (localFileInfo == null)
        {
          return paramViewGroup;
          localaqlt = (aqlt)paramView.getTag();
          paramViewGroup = paramView;
        }
        paramView = paramViewGroup;
        localaqlt.jdField_b_of_type_Int = paramInt1;
        paramView = paramViewGroup;
        localaqlt.jdField_a_of_type_Int = paramInt2;
        paramView = paramViewGroup;
        localFileInfo.a((String)getGroup(paramInt1));
        paramView = paramViewGroup;
        localaqlt.jdField_a_of_type_JavaLangObject = localFileInfo;
        paramView = paramViewGroup;
        localaqlt.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setOnClickListener(this.c);
        paramView = paramViewGroup;
        localaqlt.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setTag(localaqlt);
        paramView = paramViewGroup;
        if (this.jdField_a_of_type_Boolean)
        {
          paramView = paramViewGroup;
          localaqlt.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setTag(localaqlt);
          paramView = paramViewGroup;
          localaqlt.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setOnClickListener(this.d);
        }
        paramView = paramViewGroup;
        paramInt1 = localaqlt.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.getHeight();
        paramView = paramViewGroup;
        paramInt2 = localaqlt.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.getWidth();
        paramView = paramViewGroup;
        Object localObject = localFileInfo.c();
        paramView = paramViewGroup;
        if (this.jdField_a_of_type_Aqjd != null)
        {
          paramView = paramViewGroup;
          localObject = this.jdField_a_of_type_Aqjd.a(localFileInfo);
        }
        paramView = paramViewGroup;
        a((String)localObject, arni.a((String)localObject), paramInt2, paramInt1, localaqlt);
        paramView = paramViewGroup;
        localaqlt.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        paramView = paramViewGroup;
        localObject = localFileInfo.d();
        paramView = paramViewGroup;
        localaqlt.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        paramView = paramViewGroup;
        localaqlt.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramView = paramViewGroup;
        localaqlt.jdField_b_of_type_AndroidWidgetTextView.setText(a(localFileInfo));
        paramView = paramViewGroup;
        localaqlt.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(4);
        paramView = paramViewGroup;
        localaqlt.c = 0;
        paramView = paramViewGroup;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f())
        {
          paramView = paramViewGroup;
          localaqlt.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
          paramView = paramViewGroup;
          localaqlt.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
          paramView = paramViewGroup;
          localaqlt.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
          paramView = paramViewGroup;
          localaqlt.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(aqxj.a(localFileInfo));
        }
        for (;;)
        {
          paramView = paramViewGroup;
          localObject = (LinearLayout.LayoutParams)localaqlt.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
          paramView = paramViewGroup;
          ((LinearLayout.LayoutParams)localObject).topMargin = aekt.a(3.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
          paramView = paramViewGroup;
          localaqlt.jdField_b_of_type_AndroidWidgetTextView.setLineSpacing(TypedValue.applyDimension(1, 0.8F, this.jdField_b_of_type_AndroidContentContext.getResources().getDisplayMetrics()), 1.0F);
          paramView = paramViewGroup;
          localaqlt.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
          paramView = paramViewGroup;
          localaqlt.jdField_a_of_type_AndroidWidgetTextView.setLineSpacing(TypedValue.applyDimension(1, 0.25F, this.jdField_b_of_type_AndroidContentContext.getResources().getDisplayMetrics()), 1.0F);
          return paramViewGroup;
          paramView = paramViewGroup;
          localaqlt.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
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
      paramView = (aqje)paramViewGroup.getTag();
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
 * Qualified Name:     aqlr
 * JD-Core Version:    0.7.0.1
 */