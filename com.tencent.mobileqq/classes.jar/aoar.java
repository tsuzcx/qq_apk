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

public class aoar
  extends anzj
  implements View.OnClickListener
{
  int jdField_b_of_type_Int = -1;
  LinkedHashMap<String, List<FileInfo>> jdField_b_of_type_JavaUtilLinkedHashMap = null;
  
  public aoar(BaseFileAssistantActivity paramBaseFileAssistantActivity, Object paramObject, int paramInt)
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
          paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131494894, null);
          paramView = paramViewGroup;
          try
          {
            localaoas = new aoas(this);
            paramView = paramViewGroup;
            localaoas.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramViewGroup.findViewById(2131302158));
            paramView = paramViewGroup;
            localaoas.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131302175));
            paramView = paramViewGroup;
            localaoas.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131302172));
            paramView = paramViewGroup;
            localaoas.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView = ((EllipsizingTextView)paramViewGroup.findViewById(2131300621));
            paramView = paramViewGroup;
            localaoas.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131300624));
            paramView = paramViewGroup;
            localaoas.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramViewGroup.findViewById(2131298700));
            paramView = paramViewGroup;
            paramViewGroup.setTag(localaoas);
            paramView = paramViewGroup;
            ((FileInfo)localObject).a((String)getGroup(paramInt1));
            paramView = paramViewGroup;
            localaoas.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo = ((FileInfo)localObject);
            paramView = paramViewGroup;
            localaoas.jdField_a_of_type_Int = paramInt2;
            paramView = paramViewGroup;
            localaoas.jdField_b_of_type_Int = paramInt1;
            paramView = paramViewGroup;
            localaoas.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAdjustViewBounds(false);
            paramView = paramViewGroup;
            localaoas.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            paramView = paramViewGroup;
            localaoas.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130846730);
            paramView = paramViewGroup;
            localaoas.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
            paramView = paramViewGroup;
            if (!((FileInfo)localObject).a())
            {
              paramView = paramViewGroup;
              localaoas.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setText(((FileInfo)localObject).d());
              paramView = paramViewGroup;
              localaoas.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setMaxLines(2);
              paramView = paramViewGroup;
              localaoas.jdField_a_of_type_AndroidWidgetTextView.setText(apdh.a(((FileInfo)localObject).a()));
              paramView = paramViewGroup;
              paramViewGroup.setOnClickListener(this);
              paramView = paramViewGroup;
              localaoas.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
              paramView = paramViewGroup;
              localaoas.jdField_a_of_type_AndroidWidgetFrameLayout.setTag(localaoas);
              paramView = paramViewGroup;
              if (this.jdField_a_of_type_Anzh != null)
              {
                paramView = paramViewGroup;
                str = this.jdField_a_of_type_Anzh.a((FileInfo)localObject);
                paramView = paramViewGroup;
                if (apdh.b(str))
                {
                  paramView = paramViewGroup;
                  localaoas.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncImage(str);
                }
              }
              paramView = paramViewGroup;
              str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131626883) + ((FileInfo)localObject).d();
              paramView = paramViewGroup;
              localaoas.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
              paramView = paramViewGroup;
              if (!aonm.a((FileInfo)localObject)) {
                continue;
              }
              paramView = paramViewGroup;
              localObject = str + this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131626884);
              paramView = paramViewGroup;
              localaoas.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840158);
              paramView = paramViewGroup;
              paramViewGroup.setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getResources().getColor(2131101537));
              paramView = paramViewGroup;
              localaoas.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
              paramView = paramViewGroup;
              paramViewGroup.setOnLongClickListener(null);
              paramView = paramViewGroup;
              localaoas.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setContentDescription((CharSequence)localObject);
              return paramViewGroup;
              localaoas = (aoas)paramView.getTag();
              paramViewGroup = paramView;
              continue;
            }
            paramView = paramViewGroup;
            localaoas.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setText(null);
            continue;
            paramViewGroup.printStackTrace();
          }
          catch (Exception paramViewGroup) {}
        }
        catch (Exception paramViewGroup)
        {
          aoas localaoas;
          String str;
          continue;
        }
        QLog.e("#######", 1, paramViewGroup.toString());
        return paramView;
        paramView = paramViewGroup;
        localaoas.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
        paramView = paramViewGroup;
        localaoas.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844777);
        localObject = str;
      }
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    super.a(paramView, paramInt);
    anzi localanzi = (anzi)paramView.getTag();
    if (localanzi != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.g() == 1)
      {
        localanzi.a.setVisibility(8);
        paramView.setEnabled(false);
      }
    }
    else {
      return;
    }
    paramView.setEnabled(true);
    localanzi.a.setVisibility(0);
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
      paramView = (anzi)paramViewGroup.getTag();
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
    Object localObject = (aoas)paramView.getTag();
    switch (i)
    {
    default: 
      if (this.jdField_a_of_type_Anzh == null) {
        return;
      }
      break;
    case 2131298700: 
      if (aonm.a(((aoas)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo))
      {
        aonm.b(((aoas)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo);
        ((aoas)localObject).jdField_a_of_type_AndroidWidgetImageView.setSelected(false);
        ((aoas)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844777);
        ((aoas)localObject).jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
        if (this.jdField_a_of_type_Anzh != null) {
          this.jdField_a_of_type_Anzh.a(((aoas)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo, false);
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.l();
        return;
        aonm.a(((aoas)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo);
        ((aoas)localObject).jdField_a_of_type_AndroidWidgetImageView.setSelected(true);
        ((aoas)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840158);
        ((aoas)localObject).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        if (this.jdField_a_of_type_Anzh != null) {
          this.jdField_a_of_type_Anzh.a(((aoas)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo, true);
        }
      }
    }
    FileManagerEntity localFileManagerEntity = apck.a(((aoas)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo);
    localFileManagerEntity.nFileType = this.jdField_b_of_type_Int;
    localFileManagerEntity.setFilePath(this.jdField_a_of_type_Anzh.a(((aoas)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo));
    localObject = new aowq(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app, this.jdField_a_of_type_AndroidContentContext, localFileManagerEntity, 10000);
    localObject = new aows(this.jdField_a_of_type_AndroidContentContext, (aowv)localObject);
    ((aows)localObject).a(8);
    ((aows)localObject).a(xgx.a(paramView));
    ((aows)localObject).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoar
 * JD-Core Version:    0.7.0.1
 */