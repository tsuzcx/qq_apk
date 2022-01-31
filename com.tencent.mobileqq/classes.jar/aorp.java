import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import java.util.List;

public class aorp
  extends aoqh
  implements View.OnClickListener
{
  int jdField_b_of_type_Int = -1;
  LinkedHashMap<String, List<FileInfo>> jdField_b_of_type_JavaUtilLinkedHashMap = null;
  
  public aorp(BaseFileAssistantActivity paramBaseFileAssistantActivity, Object paramObject, int paramInt)
  {
    super(paramBaseFileAssistantActivity, paramObject, null, null, null, null, null);
    this.jdField_b_of_type_JavaUtilLinkedHashMap = ((LinkedHashMap)paramObject);
    this.jdField_b_of_type_Int = paramInt;
  }
  
  protected View a(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = getChild(paramInt1, paramInt2);
    if (paramViewGroup != null) {}
    for (Object localObject = (FileInfo)paramViewGroup;; localObject = null)
    {
      if (localObject == null) {
        return null;
      }
      if (paramView == null) {}
      for (;;)
      {
        try
        {
          paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560465, null);
          paramView = paramViewGroup;
          try
          {
            localaorq = new aorq(this);
            paramView = paramViewGroup;
            localaorq.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramViewGroup.findViewById(2131367776));
            paramView = paramViewGroup;
            localaorq.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131367793));
            paramView = paramViewGroup;
            localaorq.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131367790));
            paramView = paramViewGroup;
            localaorq.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView = ((EllipsizingTextView)paramViewGroup.findViewById(2131366223));
            paramView = paramViewGroup;
            localaorq.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131366226));
            paramView = paramViewGroup;
            localaorq.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramViewGroup.findViewById(2131364257));
            paramView = paramViewGroup;
            paramViewGroup.setTag(localaorq);
            paramView = paramViewGroup;
            ((FileInfo)localObject).a((String)getGroup(paramInt1));
            paramView = paramViewGroup;
            localaorq.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo = ((FileInfo)localObject);
            paramView = paramViewGroup;
            localaorq.jdField_a_of_type_Int = paramInt2;
            paramView = paramViewGroup;
            localaorq.jdField_b_of_type_Int = paramInt1;
            paramView = paramViewGroup;
            localaorq.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAdjustViewBounds(false);
            paramView = paramViewGroup;
            localaorq.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            paramView = paramViewGroup;
            localaorq.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130846926);
            paramView = paramViewGroup;
            localaorq.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
            paramView = paramViewGroup;
            if (!((FileInfo)localObject).a())
            {
              paramView = paramViewGroup;
              localaorq.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setText(((FileInfo)localObject).d());
              paramView = paramViewGroup;
              localaorq.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setMaxLines(2);
              paramView = paramViewGroup;
              localaorq.jdField_a_of_type_AndroidWidgetTextView.setText(apvd.a(((FileInfo)localObject).a()));
              paramView = paramViewGroup;
              paramViewGroup.setOnClickListener(this);
              paramView = paramViewGroup;
              localaorq.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
              paramView = paramViewGroup;
              localaorq.jdField_a_of_type_AndroidWidgetFrameLayout.setTag(localaorq);
              paramView = paramViewGroup;
              if (this.jdField_a_of_type_Aoqf != null)
              {
                paramView = paramViewGroup;
                str = this.jdField_a_of_type_Aoqf.a((FileInfo)localObject);
                paramView = paramViewGroup;
                if (apvd.b(str))
                {
                  paramView = paramViewGroup;
                  localaorq.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncImage(str);
                }
              }
              paramView = paramViewGroup;
              str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131692497) + ((FileInfo)localObject).d();
              paramView = paramViewGroup;
              localaorq.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
              paramView = paramViewGroup;
              if (!apel.a((FileInfo)localObject)) {
                continue;
              }
              paramView = paramViewGroup;
              localObject = str + this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131692498);
              paramView = paramViewGroup;
              localaorq.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840202);
              paramView = paramViewGroup;
              paramViewGroup.setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getResources().getColor(2131167134));
              paramView = paramViewGroup;
              localaorq.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
              paramView = paramViewGroup;
              paramViewGroup.setOnLongClickListener(null);
              paramView = paramViewGroup;
              localaorq.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setContentDescription((CharSequence)localObject);
              return paramViewGroup;
              localaorq = (aorq)paramView.getTag();
              paramViewGroup = paramView;
              continue;
            }
            paramView = paramViewGroup;
            localaorq.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setText(null);
            continue;
            paramViewGroup.printStackTrace();
          }
          catch (Exception paramViewGroup) {}
        }
        catch (Exception paramViewGroup)
        {
          aorq localaorq;
          String str;
          continue;
        }
        QLog.e("#######", 1, paramViewGroup.toString());
        return paramView;
        paramView = paramViewGroup;
        localaorq.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
        paramView = paramViewGroup;
        localaorq.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844858);
        localObject = str;
      }
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    super.a(paramView, paramInt);
    aoqg localaoqg = (aoqg)paramView.getTag();
    if (localaoqg != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.g() == 1)
      {
        localaoqg.a.setVisibility(8);
        paramView.setEnabled(false);
      }
    }
    else {
      return;
    }
    paramView.setEnabled(true);
    localaoqg.a.setVisibility(0);
  }
  
  protected int b()
  {
    return 4;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = super.getGroupView(paramInt, paramBoolean, paramView, paramViewGroup);
    paramView = null;
    if (paramViewGroup != null) {
      paramView = (aoqg)paramViewGroup.getTag();
    }
    if (paramView != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.g() == 1)
      {
        paramView.a.setVisibility(8);
        paramViewGroup.setEnabled(false);
        onGroupExpanded(0);
      }
    }
    else {
      return paramViewGroup;
    }
    paramViewGroup.setEnabled(true);
    paramView.a.setVisibility(0);
    return paramViewGroup;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject = (aorq)paramView.getTag();
    switch (i)
    {
    default: 
      if (this.jdField_a_of_type_Aoqf == null) {
        return;
      }
      break;
    case 2131364257: 
      if (apel.a(((aorq)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo))
      {
        apel.b(((aorq)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo);
        ((aorq)localObject).jdField_a_of_type_AndroidWidgetImageView.setSelected(false);
        ((aorq)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844858);
        ((aorq)localObject).jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
        if (this.jdField_a_of_type_Aoqf != null) {
          this.jdField_a_of_type_Aoqf.a(((aorq)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo, false);
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.l();
        return;
        apel.a(((aorq)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo);
        ((aorq)localObject).jdField_a_of_type_AndroidWidgetImageView.setSelected(true);
        ((aorq)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840202);
        ((aorq)localObject).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        if (this.jdField_a_of_type_Aoqf != null) {
          this.jdField_a_of_type_Aoqf.a(((aorq)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo, true);
        }
      }
    }
    FileManagerEntity localFileManagerEntity = apug.a(((aorq)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo);
    localFileManagerEntity.nFileType = this.jdField_b_of_type_Int;
    localFileManagerEntity.setFilePath(this.jdField_a_of_type_Aoqf.a(((aorq)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo));
    localObject = new apoi(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app, this.jdField_a_of_type_AndroidContentContext, localFileManagerEntity, 10000);
    localObject = new apok(this.jdField_a_of_type_AndroidContentContext, (apon)localObject);
    ((apok)localObject).a(8);
    ((apok)localObject).a(xpu.a(paramView));
    ((apok)localObject).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aorp
 * JD-Core Version:    0.7.0.1
 */