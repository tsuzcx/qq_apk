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

public class aqkn
  extends aqjf
  implements View.OnClickListener
{
  int jdField_b_of_type_Int = -1;
  LinkedHashMap<String, List<FileInfo>> jdField_b_of_type_JavaUtilLinkedHashMap = null;
  
  public aqkn(BaseFileAssistantActivity paramBaseFileAssistantActivity, Object paramObject, int paramInt)
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
          paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560641, null);
          paramView = paramViewGroup;
          try
          {
            localaqko = new aqko(this);
            paramView = paramViewGroup;
            localaqko.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramViewGroup.findViewById(2131367910));
            paramView = paramViewGroup;
            localaqko.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131367927));
            paramView = paramViewGroup;
            localaqko.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131367924));
            paramView = paramViewGroup;
            localaqko.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView = ((EllipsizingTextView)paramViewGroup.findViewById(2131366311));
            paramView = paramViewGroup;
            localaqko.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131366314));
            paramView = paramViewGroup;
            localaqko.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramViewGroup.findViewById(2131364324));
            paramView = paramViewGroup;
            paramViewGroup.setTag(localaqko);
            paramView = paramViewGroup;
            ((FileInfo)localObject).a((String)getGroup(paramInt1));
            paramView = paramViewGroup;
            localaqko.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo = ((FileInfo)localObject);
            paramView = paramViewGroup;
            localaqko.jdField_a_of_type_Int = paramInt2;
            paramView = paramViewGroup;
            localaqko.jdField_b_of_type_Int = paramInt1;
            paramView = paramViewGroup;
            localaqko.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAdjustViewBounds(false);
            paramView = paramViewGroup;
            localaqko.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            paramView = paramViewGroup;
            localaqko.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130847294);
            paramView = paramViewGroup;
            localaqko.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
            paramView = paramViewGroup;
            if (!((FileInfo)localObject).a())
            {
              paramView = paramViewGroup;
              localaqko.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setText(((FileInfo)localObject).d());
              paramView = paramViewGroup;
              localaqko.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setMaxLines(2);
              paramView = paramViewGroup;
              localaqko.jdField_a_of_type_AndroidWidgetTextView.setText(arof.a(((FileInfo)localObject).a()));
              paramView = paramViewGroup;
              paramViewGroup.setOnClickListener(this);
              paramView = paramViewGroup;
              localaqko.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
              paramView = paramViewGroup;
              localaqko.jdField_a_of_type_AndroidWidgetFrameLayout.setTag(localaqko);
              paramView = paramViewGroup;
              if (this.jdField_a_of_type_Aqjd != null)
              {
                paramView = paramViewGroup;
                str = this.jdField_a_of_type_Aqjd.a((FileInfo)localObject);
                paramView = paramViewGroup;
                if (arof.b(str))
                {
                  paramView = paramViewGroup;
                  localaqko.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncImage(str);
                }
              }
              paramView = paramViewGroup;
              str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131692573) + ((FileInfo)localObject).d();
              paramView = paramViewGroup;
              localaqko.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
              paramView = paramViewGroup;
              if (!aqxj.a((FileInfo)localObject)) {
                continue;
              }
              paramView = paramViewGroup;
              localObject = str + this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131692574);
              paramView = paramViewGroup;
              localaqko.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840305);
              paramView = paramViewGroup;
              paramViewGroup.setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getResources().getColor(2131167192));
              paramView = paramViewGroup;
              localaqko.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
              paramView = paramViewGroup;
              paramViewGroup.setOnLongClickListener(null);
              paramView = paramViewGroup;
              localaqko.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setContentDescription((CharSequence)localObject);
              return paramViewGroup;
              localaqko = (aqko)paramView.getTag();
              paramViewGroup = paramView;
              continue;
            }
            paramView = paramViewGroup;
            localaqko.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setText(null);
            continue;
            paramViewGroup.printStackTrace();
          }
          catch (Exception paramViewGroup) {}
        }
        catch (Exception paramViewGroup)
        {
          aqko localaqko;
          String str;
          continue;
        }
        QLog.e("#######", 1, paramViewGroup.toString());
        return paramView;
        paramView = paramViewGroup;
        localaqko.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
        paramView = paramViewGroup;
        localaqko.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845222);
        localObject = str;
      }
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    super.a(paramView, paramInt);
    aqje localaqje = (aqje)paramView.getTag();
    if (localaqje != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.g() == 1)
      {
        localaqje.a.setVisibility(8);
        paramView.setEnabled(false);
      }
    }
    else {
      return;
    }
    paramView.setEnabled(true);
    localaqje.a.setVisibility(0);
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
      paramView = (aqje)paramViewGroup.getTag();
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
    Object localObject = (aqko)paramView.getTag();
    switch (i)
    {
    default: 
      if (this.jdField_a_of_type_Aqjd == null) {
        return;
      }
      break;
    case 2131364324: 
      if (aqxj.a(((aqko)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo))
      {
        aqxj.b(((aqko)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo);
        ((aqko)localObject).jdField_a_of_type_AndroidWidgetImageView.setSelected(false);
        ((aqko)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845222);
        ((aqko)localObject).jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
        if (this.jdField_a_of_type_Aqjd != null) {
          this.jdField_a_of_type_Aqjd.a(((aqko)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo, false);
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.l();
        return;
        aqxj.a(((aqko)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo);
        ((aqko)localObject).jdField_a_of_type_AndroidWidgetImageView.setSelected(true);
        ((aqko)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840305);
        ((aqko)localObject).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        if (this.jdField_a_of_type_Aqjd != null) {
          this.jdField_a_of_type_Aqjd.a(((aqko)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo, true);
        }
      }
    }
    FileManagerEntity localFileManagerEntity = arni.a(((aqko)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo);
    localFileManagerEntity.nFileType = this.jdField_b_of_type_Int;
    localFileManagerEntity.setFilePath(this.jdField_a_of_type_Aqjd.a(((aqko)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo));
    localObject = new arhh(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app, this.jdField_b_of_type_AndroidContentContext, localFileManagerEntity, 10000);
    localObject = new arhj(this.jdField_b_of_type_AndroidContentContext, (arhm)localObject);
    ((arhj)localObject).a(8);
    ((arhj)localObject).a(zen.a(paramView));
    ((arhj)localObject).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqkn
 * JD-Core Version:    0.7.0.1
 */