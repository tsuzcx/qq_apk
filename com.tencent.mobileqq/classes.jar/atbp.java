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
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.LinkedHashMap;
import java.util.List;

public class atbp
  extends atah
  implements View.OnClickListener
{
  int jdField_b_of_type_Int = -1;
  LinkedHashMap<String, List<FileInfo>> jdField_b_of_type_JavaUtilLinkedHashMap = null;
  
  public atbp(BaseFileAssistantActivity paramBaseFileAssistantActivity, Object paramObject, int paramInt)
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
          paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560830, null);
          paramView = paramViewGroup;
          try
          {
            localatbq = new atbq(this);
            paramView = paramViewGroup;
            localatbq.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramViewGroup.findViewById(2131368501));
            paramView = paramViewGroup;
            localatbq.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131368518));
            paramView = paramViewGroup;
            localatbq.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131368515));
            paramView = paramViewGroup;
            localatbq.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView = ((EllipsizingTextView)paramViewGroup.findViewById(2131366753));
            paramView = paramViewGroup;
            localatbq.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131366756));
            paramView = paramViewGroup;
            localatbq.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramViewGroup.findViewById(2131364688));
            paramView = paramViewGroup;
            paramViewGroup.setTag(localatbq);
            paramView = paramViewGroup;
            ((FileInfo)localObject).a((String)getGroup(paramInt1));
            paramView = paramViewGroup;
            localatbq.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo = ((FileInfo)localObject);
            paramView = paramViewGroup;
            localatbq.jdField_a_of_type_Int = paramInt2;
            paramView = paramViewGroup;
            localatbq.jdField_b_of_type_Int = paramInt1;
            paramView = paramViewGroup;
            localatbq.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAdjustViewBounds(false);
            paramView = paramViewGroup;
            localatbq.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            paramView = paramViewGroup;
            localatbq.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130847846);
            paramView = paramViewGroup;
            localatbq.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
            paramView = paramViewGroup;
            if (!((FileInfo)localObject).a())
            {
              paramView = paramViewGroup;
              localatbq.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setText(((FileInfo)localObject).d());
              paramView = paramViewGroup;
              localatbq.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setMaxLines(2);
              paramView = paramViewGroup;
              localatbq.jdField_a_of_type_AndroidWidgetTextView.setText(FileUtil.filesizeToString(((FileInfo)localObject).a()));
              paramView = paramViewGroup;
              paramViewGroup.setOnClickListener(this);
              paramView = paramViewGroup;
              localatbq.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
              paramView = paramViewGroup;
              localatbq.jdField_a_of_type_AndroidWidgetFrameLayout.setTag(localatbq);
              paramView = paramViewGroup;
              if (this.jdField_a_of_type_Ataf != null)
              {
                paramView = paramViewGroup;
                str = this.jdField_a_of_type_Ataf.a((FileInfo)localObject);
                paramView = paramViewGroup;
                if (FileUtil.fileExistsAndNotEmpty(str))
                {
                  paramView = paramViewGroup;
                  localatbq.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncImage(str);
                }
              }
              paramView = paramViewGroup;
              str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131692304) + ((FileInfo)localObject).d();
              paramView = paramViewGroup;
              localatbq.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
              paramView = paramViewGroup;
              if (!atpm.a((FileInfo)localObject)) {
                continue;
              }
              paramView = paramViewGroup;
              localObject = str + this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131692305);
              paramView = paramViewGroup;
              localatbq.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840569);
              paramView = paramViewGroup;
              paramViewGroup.setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getResources().getColor(2131167363));
              paramView = paramViewGroup;
              localatbq.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
              paramView = paramViewGroup;
              paramViewGroup.setOnLongClickListener(null);
              paramView = paramViewGroup;
              localatbq.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setContentDescription((CharSequence)localObject);
              return paramViewGroup;
              localatbq = (atbq)paramView.getTag();
              paramViewGroup = paramView;
              continue;
            }
            paramView = paramViewGroup;
            localatbq.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setText(null);
            continue;
            paramViewGroup.printStackTrace();
          }
          catch (Exception paramViewGroup) {}
        }
        catch (Exception paramViewGroup)
        {
          atbq localatbq;
          String str;
          continue;
        }
        QLog.e("#######", 1, paramViewGroup.toString());
        return paramView;
        paramView = paramViewGroup;
        localatbq.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
        paramView = paramViewGroup;
        localatbq.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845669);
        localObject = str;
      }
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    super.a(paramView, paramInt);
    atag localatag = (atag)paramView.getTag();
    if (localatag != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.g() == 1)
      {
        localatag.a.setVisibility(8);
        paramView.setEnabled(false);
      }
    }
    else {
      return;
    }
    paramView.setEnabled(true);
    localatag.a.setVisibility(0);
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
      paramView = (atag)paramViewGroup.getTag();
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
    Object localObject = (atbq)paramView.getTag();
    switch (i)
    {
    default: 
      if (this.jdField_a_of_type_Ataf != null) {
        break;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (atpm.a(((atbq)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo))
      {
        atpm.b(((atbq)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo);
        ((atbq)localObject).jdField_a_of_type_AndroidWidgetImageView.setSelected(false);
        ((atbq)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845669);
        ((atbq)localObject).jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
        if (this.jdField_a_of_type_Ataf != null) {
          this.jdField_a_of_type_Ataf.a(((atbq)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo, false);
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.l();
        break;
        atpm.a(((atbq)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo);
        ((atbq)localObject).jdField_a_of_type_AndroidWidgetImageView.setSelected(true);
        ((atbq)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840569);
        ((atbq)localObject).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        if (this.jdField_a_of_type_Ataf != null) {
          this.jdField_a_of_type_Ataf.a(((atbq)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo, true);
        }
      }
      FileManagerEntity localFileManagerEntity = auea.a(((atbq)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo);
      localFileManagerEntity.nFileType = this.jdField_b_of_type_Int;
      localFileManagerEntity.setFilePath(this.jdField_a_of_type_Ataf.a(((atbq)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo));
      localObject = new atyi(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app, this.jdField_a_of_type_AndroidContentContext, localFileManagerEntity, 10000);
      localObject = new atyk(this.jdField_a_of_type_AndroidContentContext, (atyn)localObject);
      ((atyk)localObject).a(8);
      ((atyk)localObject).a(aavz.a(paramView));
      ((atyk)localObject).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atbp
 * JD-Core Version:    0.7.0.1
 */