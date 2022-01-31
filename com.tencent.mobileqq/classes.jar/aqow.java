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

public class aqow
  extends aqno
  implements View.OnClickListener
{
  int jdField_b_of_type_Int = -1;
  LinkedHashMap<String, List<FileInfo>> jdField_b_of_type_JavaUtilLinkedHashMap = null;
  
  public aqow(BaseFileAssistantActivity paramBaseFileAssistantActivity, Object paramObject, int paramInt)
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
          paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560659, null);
          paramView = paramViewGroup;
          try
          {
            localaqox = new aqox(this);
            paramView = paramViewGroup;
            localaqox.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramViewGroup.findViewById(2131367921));
            paramView = paramViewGroup;
            localaqox.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131367938));
            paramView = paramViewGroup;
            localaqox.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131367935));
            paramView = paramViewGroup;
            localaqox.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView = ((EllipsizingTextView)paramViewGroup.findViewById(2131366313));
            paramView = paramViewGroup;
            localaqox.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131366316));
            paramView = paramViewGroup;
            localaqox.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramViewGroup.findViewById(2131364326));
            paramView = paramViewGroup;
            paramViewGroup.setTag(localaqox);
            paramView = paramViewGroup;
            ((FileInfo)localObject).a((String)getGroup(paramInt1));
            paramView = paramViewGroup;
            localaqox.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo = ((FileInfo)localObject);
            paramView = paramViewGroup;
            localaqox.jdField_a_of_type_Int = paramInt2;
            paramView = paramViewGroup;
            localaqox.jdField_b_of_type_Int = paramInt1;
            paramView = paramViewGroup;
            localaqox.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAdjustViewBounds(false);
            paramView = paramViewGroup;
            localaqox.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            paramView = paramViewGroup;
            localaqox.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130847367);
            paramView = paramViewGroup;
            localaqox.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
            paramView = paramViewGroup;
            if (!((FileInfo)localObject).a())
            {
              paramView = paramViewGroup;
              localaqox.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setText(((FileInfo)localObject).d());
              paramView = paramViewGroup;
              localaqox.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setMaxLines(2);
              paramView = paramViewGroup;
              localaqox.jdField_a_of_type_AndroidWidgetTextView.setText(arso.a(((FileInfo)localObject).a()));
              paramView = paramViewGroup;
              paramViewGroup.setOnClickListener(this);
              paramView = paramViewGroup;
              localaqox.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
              paramView = paramViewGroup;
              localaqox.jdField_a_of_type_AndroidWidgetFrameLayout.setTag(localaqox);
              paramView = paramViewGroup;
              if (this.jdField_a_of_type_Aqnm != null)
              {
                paramView = paramViewGroup;
                str = this.jdField_a_of_type_Aqnm.a((FileInfo)localObject);
                paramView = paramViewGroup;
                if (arso.b(str))
                {
                  paramView = paramViewGroup;
                  localaqox.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncImage(str);
                }
              }
              paramView = paramViewGroup;
              str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131692574) + ((FileInfo)localObject).d();
              paramView = paramViewGroup;
              localaqox.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
              paramView = paramViewGroup;
              if (!arbs.a((FileInfo)localObject)) {
                continue;
              }
              paramView = paramViewGroup;
              localObject = str + this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131692575);
              paramView = paramViewGroup;
              localaqox.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840306);
              paramView = paramViewGroup;
              paramViewGroup.setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getResources().getColor(2131167194));
              paramView = paramViewGroup;
              localaqox.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
              paramView = paramViewGroup;
              paramViewGroup.setOnLongClickListener(null);
              paramView = paramViewGroup;
              localaqox.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setContentDescription((CharSequence)localObject);
              return paramViewGroup;
              localaqox = (aqox)paramView.getTag();
              paramViewGroup = paramView;
              continue;
            }
            paramView = paramViewGroup;
            localaqox.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setText(null);
            continue;
            paramViewGroup.printStackTrace();
          }
          catch (Exception paramViewGroup) {}
        }
        catch (Exception paramViewGroup)
        {
          aqox localaqox;
          String str;
          continue;
        }
        QLog.e("#######", 1, paramViewGroup.toString());
        return paramView;
        paramView = paramViewGroup;
        localaqox.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
        paramView = paramViewGroup;
        localaqox.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845294);
        localObject = str;
      }
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    super.a(paramView, paramInt);
    aqnn localaqnn = (aqnn)paramView.getTag();
    if (localaqnn != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.g() == 1)
      {
        localaqnn.a.setVisibility(8);
        paramView.setEnabled(false);
      }
    }
    else {
      return;
    }
    paramView.setEnabled(true);
    localaqnn.a.setVisibility(0);
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
      paramView = (aqnn)paramViewGroup.getTag();
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
    Object localObject = (aqox)paramView.getTag();
    switch (i)
    {
    default: 
      if (this.jdField_a_of_type_Aqnm == null) {
        return;
      }
      break;
    case 2131364326: 
      if (arbs.a(((aqox)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo))
      {
        arbs.b(((aqox)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo);
        ((aqox)localObject).jdField_a_of_type_AndroidWidgetImageView.setSelected(false);
        ((aqox)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845294);
        ((aqox)localObject).jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
        if (this.jdField_a_of_type_Aqnm != null) {
          this.jdField_a_of_type_Aqnm.a(((aqox)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo, false);
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.l();
        return;
        arbs.a(((aqox)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo);
        ((aqox)localObject).jdField_a_of_type_AndroidWidgetImageView.setSelected(true);
        ((aqox)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840306);
        ((aqox)localObject).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        if (this.jdField_a_of_type_Aqnm != null) {
          this.jdField_a_of_type_Aqnm.a(((aqox)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo, true);
        }
      }
    }
    FileManagerEntity localFileManagerEntity = arrr.a(((aqox)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo);
    localFileManagerEntity.nFileType = this.jdField_b_of_type_Int;
    localFileManagerEntity.setFilePath(this.jdField_a_of_type_Aqnm.a(((aqox)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo));
    localObject = new arlq(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app, this.jdField_b_of_type_AndroidContentContext, localFileManagerEntity, 10000);
    localObject = new arls(this.jdField_b_of_type_AndroidContentContext, (arlv)localObject);
    ((arls)localObject).a(8);
    ((arls)localObject).a(zjc.a(paramView));
    ((arls)localObject).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqow
 * JD-Core Version:    0.7.0.1
 */