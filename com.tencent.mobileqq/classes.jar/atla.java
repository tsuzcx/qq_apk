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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.LinkedHashMap;
import java.util.List;

public class atla
  extends atjs
  implements View.OnClickListener
{
  int jdField_b_of_type_Int = -1;
  LinkedHashMap<String, List<FileInfo>> jdField_b_of_type_JavaUtilLinkedHashMap = null;
  
  public atla(BaseFileAssistantActivity paramBaseFileAssistantActivity, Object paramObject, int paramInt)
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
          paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560890, null);
          paramView = paramViewGroup;
          try
          {
            localatlb = new atlb(this);
            paramView = paramViewGroup;
            localatlb.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramViewGroup.findViewById(2131368320));
            paramView = paramViewGroup;
            localatlb.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131368337));
            paramView = paramViewGroup;
            localatlb.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131368334));
            paramView = paramViewGroup;
            localatlb.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView = ((EllipsizingTextView)paramViewGroup.findViewById(2131366615));
            paramView = paramViewGroup;
            localatlb.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131366618));
            paramView = paramViewGroup;
            localatlb.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramViewGroup.findViewById(2131364583));
            paramView = paramViewGroup;
            paramViewGroup.setTag(localatlb);
            paramView = paramViewGroup;
            ((FileInfo)localObject).a((String)getGroup(paramInt1));
            paramView = paramViewGroup;
            localatlb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo = ((FileInfo)localObject);
            paramView = paramViewGroup;
            localatlb.jdField_a_of_type_Int = paramInt2;
            paramView = paramViewGroup;
            localatlb.jdField_b_of_type_Int = paramInt1;
            paramView = paramViewGroup;
            localatlb.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAdjustViewBounds(false);
            paramView = paramViewGroup;
            localatlb.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            paramView = paramViewGroup;
            localatlb.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130847845);
            paramView = paramViewGroup;
            localatlb.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
            paramView = paramViewGroup;
            if (!((FileInfo)localObject).a())
            {
              paramView = paramViewGroup;
              localatlb.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setText(((FileInfo)localObject).d());
              paramView = paramViewGroup;
              localatlb.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setMaxLines(2);
              paramView = paramViewGroup;
              localatlb.jdField_a_of_type_AndroidWidgetTextView.setText(auog.a(((FileInfo)localObject).a()));
              paramView = paramViewGroup;
              paramViewGroup.setOnClickListener(this);
              paramView = paramViewGroup;
              localatlb.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
              paramView = paramViewGroup;
              localatlb.jdField_a_of_type_AndroidWidgetFrameLayout.setTag(localatlb);
              paramView = paramViewGroup;
              if (this.jdField_a_of_type_Atjq != null)
              {
                paramView = paramViewGroup;
                str = this.jdField_a_of_type_Atjq.a((FileInfo)localObject);
                paramView = paramViewGroup;
                if (auog.b(str))
                {
                  paramView = paramViewGroup;
                  localatlb.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncImage(str);
                }
              }
              paramView = paramViewGroup;
              str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131692166) + ((FileInfo)localObject).d();
              paramView = paramViewGroup;
              localatlb.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
              paramView = paramViewGroup;
              if (!atyw.a((FileInfo)localObject)) {
                continue;
              }
              paramView = paramViewGroup;
              localObject = str + this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131692167);
              paramView = paramViewGroup;
              localatlb.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840495);
              paramView = paramViewGroup;
              paramViewGroup.setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getResources().getColor(2131167302));
              paramView = paramViewGroup;
              localatlb.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
              paramView = paramViewGroup;
              paramViewGroup.setOnLongClickListener(null);
              paramView = paramViewGroup;
              localatlb.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setContentDescription((CharSequence)localObject);
              return paramViewGroup;
              localatlb = (atlb)paramView.getTag();
              paramViewGroup = paramView;
              continue;
            }
            paramView = paramViewGroup;
            localatlb.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setText(null);
            continue;
            paramViewGroup.printStackTrace();
          }
          catch (Exception paramViewGroup) {}
        }
        catch (Exception paramViewGroup)
        {
          atlb localatlb;
          String str;
          continue;
        }
        QLog.e("#######", 1, paramViewGroup.toString());
        return paramView;
        paramView = paramViewGroup;
        localatlb.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
        paramView = paramViewGroup;
        localatlb.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845705);
        localObject = str;
      }
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    super.a(paramView, paramInt);
    atjr localatjr = (atjr)paramView.getTag();
    if (localatjr != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.g() == 1)
      {
        localatjr.a.setVisibility(8);
        paramView.setEnabled(false);
      }
    }
    else {
      return;
    }
    paramView.setEnabled(true);
    localatjr.a.setVisibility(0);
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
      paramView = (atjr)paramViewGroup.getTag();
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
    Object localObject = (atlb)paramView.getTag();
    switch (i)
    {
    default: 
      if (this.jdField_a_of_type_Atjq != null) {
        break;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (atyw.a(((atlb)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo))
      {
        atyw.b(((atlb)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo);
        ((atlb)localObject).jdField_a_of_type_AndroidWidgetImageView.setSelected(false);
        ((atlb)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845705);
        ((atlb)localObject).jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
        if (this.jdField_a_of_type_Atjq != null) {
          this.jdField_a_of_type_Atjq.a(((atlb)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo, false);
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.l();
        break;
        atyw.a(((atlb)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo);
        ((atlb)localObject).jdField_a_of_type_AndroidWidgetImageView.setSelected(true);
        ((atlb)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840495);
        ((atlb)localObject).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        if (this.jdField_a_of_type_Atjq != null) {
          this.jdField_a_of_type_Atjq.a(((atlb)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo, true);
        }
      }
      FileManagerEntity localFileManagerEntity = aunj.a(((atlb)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo);
      localFileManagerEntity.nFileType = this.jdField_b_of_type_Int;
      localFileManagerEntity.setFilePath(this.jdField_a_of_type_Atjq.a(((atlb)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo));
      localObject = new auhr(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app, this.jdField_a_of_type_AndroidContentContext, localFileManagerEntity, 10000);
      localObject = new auht(this.jdField_a_of_type_AndroidContentContext, (auhw)localObject);
      ((auht)localObject).a(8);
      ((auht)localObject).a(abke.a(paramView));
      ((auht)localObject).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atla
 * JD-Core Version:    0.7.0.1
 */