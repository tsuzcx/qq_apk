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

public class aork
  extends aoqc
  implements View.OnClickListener
{
  int jdField_b_of_type_Int = -1;
  LinkedHashMap<String, List<FileInfo>> jdField_b_of_type_JavaUtilLinkedHashMap = null;
  
  public aork(BaseFileAssistantActivity paramBaseFileAssistantActivity, Object paramObject, int paramInt)
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
            localaorl = new aorl(this);
            paramView = paramViewGroup;
            localaorl.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramViewGroup.findViewById(2131367776));
            paramView = paramViewGroup;
            localaorl.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131367793));
            paramView = paramViewGroup;
            localaorl.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131367790));
            paramView = paramViewGroup;
            localaorl.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView = ((EllipsizingTextView)paramViewGroup.findViewById(2131366223));
            paramView = paramViewGroup;
            localaorl.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131366226));
            paramView = paramViewGroup;
            localaorl.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramViewGroup.findViewById(2131364258));
            paramView = paramViewGroup;
            paramViewGroup.setTag(localaorl);
            paramView = paramViewGroup;
            ((FileInfo)localObject).a((String)getGroup(paramInt1));
            paramView = paramViewGroup;
            localaorl.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo = ((FileInfo)localObject);
            paramView = paramViewGroup;
            localaorl.jdField_a_of_type_Int = paramInt2;
            paramView = paramViewGroup;
            localaorl.jdField_b_of_type_Int = paramInt1;
            paramView = paramViewGroup;
            localaorl.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAdjustViewBounds(false);
            paramView = paramViewGroup;
            localaorl.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            paramView = paramViewGroup;
            localaorl.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130846920);
            paramView = paramViewGroup;
            localaorl.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
            paramView = paramViewGroup;
            if (!((FileInfo)localObject).a())
            {
              paramView = paramViewGroup;
              localaorl.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setText(((FileInfo)localObject).d());
              paramView = paramViewGroup;
              localaorl.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setMaxLines(2);
              paramView = paramViewGroup;
              localaorl.jdField_a_of_type_AndroidWidgetTextView.setText(apvb.a(((FileInfo)localObject).a()));
              paramView = paramViewGroup;
              paramViewGroup.setOnClickListener(this);
              paramView = paramViewGroup;
              localaorl.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
              paramView = paramViewGroup;
              localaorl.jdField_a_of_type_AndroidWidgetFrameLayout.setTag(localaorl);
              paramView = paramViewGroup;
              if (this.jdField_a_of_type_Aoqa != null)
              {
                paramView = paramViewGroup;
                str = this.jdField_a_of_type_Aoqa.a((FileInfo)localObject);
                paramView = paramViewGroup;
                if (apvb.b(str))
                {
                  paramView = paramViewGroup;
                  localaorl.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncImage(str);
                }
              }
              paramView = paramViewGroup;
              str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131692496) + ((FileInfo)localObject).d();
              paramView = paramViewGroup;
              localaorl.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
              paramView = paramViewGroup;
              if (!apeh.a((FileInfo)localObject)) {
                continue;
              }
              paramView = paramViewGroup;
              localObject = str + this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131692497);
              paramView = paramViewGroup;
              localaorl.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840205);
              paramView = paramViewGroup;
              paramViewGroup.setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getResources().getColor(2131167134));
              paramView = paramViewGroup;
              localaorl.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
              paramView = paramViewGroup;
              paramViewGroup.setOnLongClickListener(null);
              paramView = paramViewGroup;
              localaorl.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setContentDescription((CharSequence)localObject);
              return paramViewGroup;
              localaorl = (aorl)paramView.getTag();
              paramViewGroup = paramView;
              continue;
            }
            paramView = paramViewGroup;
            localaorl.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setText(null);
            continue;
            paramViewGroup.printStackTrace();
          }
          catch (Exception paramViewGroup) {}
        }
        catch (Exception paramViewGroup)
        {
          aorl localaorl;
          String str;
          continue;
        }
        QLog.e("#######", 1, paramViewGroup.toString());
        return paramView;
        paramView = paramViewGroup;
        localaorl.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
        paramView = paramViewGroup;
        localaorl.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844857);
        localObject = str;
      }
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    super.a(paramView, paramInt);
    aoqb localaoqb = (aoqb)paramView.getTag();
    if (localaoqb != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.g() == 1)
      {
        localaoqb.a.setVisibility(8);
        paramView.setEnabled(false);
      }
    }
    else {
      return;
    }
    paramView.setEnabled(true);
    localaoqb.a.setVisibility(0);
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
      paramView = (aoqb)paramViewGroup.getTag();
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
    Object localObject = (aorl)paramView.getTag();
    switch (i)
    {
    default: 
      if (this.jdField_a_of_type_Aoqa == null) {
        return;
      }
      break;
    case 2131364258: 
      if (apeh.a(((aorl)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo))
      {
        apeh.b(((aorl)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo);
        ((aorl)localObject).jdField_a_of_type_AndroidWidgetImageView.setSelected(false);
        ((aorl)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844857);
        ((aorl)localObject).jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
        if (this.jdField_a_of_type_Aoqa != null) {
          this.jdField_a_of_type_Aoqa.a(((aorl)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo, false);
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.l();
        return;
        apeh.a(((aorl)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo);
        ((aorl)localObject).jdField_a_of_type_AndroidWidgetImageView.setSelected(true);
        ((aorl)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840205);
        ((aorl)localObject).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        if (this.jdField_a_of_type_Aoqa != null) {
          this.jdField_a_of_type_Aoqa.a(((aorl)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo, true);
        }
      }
    }
    FileManagerEntity localFileManagerEntity = apue.a(((aorl)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo);
    localFileManagerEntity.nFileType = this.jdField_b_of_type_Int;
    localFileManagerEntity.setFilePath(this.jdField_a_of_type_Aoqa.a(((aorl)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo));
    localObject = new apoe(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app, this.jdField_a_of_type_AndroidContentContext, localFileManagerEntity, 10000);
    localObject = new apog(this.jdField_a_of_type_AndroidContentContext, (apoj)localObject);
    ((apog)localObject).a(8);
    ((apog)localObject).a(xpx.a(paramView));
    ((apog)localObject).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aork
 * JD-Core Version:    0.7.0.1
 */