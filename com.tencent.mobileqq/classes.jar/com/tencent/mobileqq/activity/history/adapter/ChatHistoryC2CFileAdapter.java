package com.tencent.mobileqq.activity.history.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.CircleFileStateView;

public class ChatHistoryC2CFileAdapter
  extends QfileBaseExpandableListAdapter
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private ChatHistoryC2CFileAdapter.OnSelectedListener jdField_a_of_type_ComTencentMobileqqActivityHistoryAdapterChatHistoryC2CFileAdapter$OnSelectedListener;
  private boolean jdField_a_of_type_Boolean = false;
  private View.OnClickListener b;
  
  public ChatHistoryC2CFileAdapter(Context paramContext, Object paramObject)
  {
    super(paramContext, paramObject);
  }
  
  private void b(ChatHistoryC2CFileAdapter.FileItemHolder paramFileItemHolder, FileManagerEntity paramFileManagerEntity)
  {
    if (FileManagerUtil.a(paramFileManagerEntity.fileName) == 0)
    {
      if (FileUtils.fileExistsAndNotEmpty(paramFileManagerEntity.getFilePath()))
      {
        FileManagerUtil.a(paramFileItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, paramFileManagerEntity.getFilePath(), paramFileManagerEntity.nFileType);
        return;
      }
      if (FileUtils.fileExistsAndNotEmpty(paramFileManagerEntity.strThumbPath))
      {
        paramFileItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130844363);
        paramFileItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncImage(paramFileManagerEntity.strThumbPath);
        return;
      }
      FileManagerUtil.a(paramFileItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, paramFileManagerEntity.fileName, paramFileManagerEntity.nFileType);
      return;
    }
    FileManagerUtil.a(paramFileItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, paramFileManagerEntity);
  }
  
  private void c(ChatHistoryC2CFileAdapter.FileItemHolder paramFileItemHolder, FileManagerEntity paramFileManagerEntity)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      paramFileItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
      paramFileItemHolder.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
      Object localObject = paramFileItemHolder.jdField_a_of_type_AndroidWidgetCheckBox;
      boolean bool = false;
      ((CheckBox)localObject).setVisibility(0);
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryAdapterChatHistoryC2CFileAdapter$OnSelectedListener;
      if (localObject != null)
      {
        bool = ((ChatHistoryC2CFileAdapter.OnSelectedListener)localObject).a(paramFileManagerEntity);
        this.jdField_a_of_type_ComTencentMobileqqActivityHistoryAdapterChatHistoryC2CFileAdapter$OnSelectedListener.f(paramFileManagerEntity);
      }
      paramFileItemHolder.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
      return;
    }
    paramFileItemHolder.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_b_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  protected void a(ChatHistoryC2CFileAdapter.FileItemHolder paramFileItemHolder, FileManagerEntity paramFileManagerEntity)
  {
    int i = paramFileManagerEntity.status;
    if (i != 18) {
      switch (i)
      {
      default: 
        paramFileItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
        return;
      case 14: 
      case 15: 
        paramFileItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
        paramFileItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
        paramFileItemHolder.jdField_a_of_type_Int = 2;
        return;
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      case 9: 
      case 10: 
      case 11: 
      case 12: 
        paramFileItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
        paramFileItemHolder.jdField_a_of_type_Int = 0;
        return;
      case 4: 
        paramFileItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
        paramFileItemHolder.jdField_a_of_type_Int = 1;
        paramFileItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
        return;
      case 1: 
        boolean bool = FileUtil.b(paramFileManagerEntity.getFilePath());
        if ((paramFileManagerEntity.getCloudType() != 3) && (paramFileManagerEntity.getCloudType() != 5) && (!bool))
        {
          paramFileItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
          paramFileItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
          paramFileItemHolder.jdField_a_of_type_Int = 1;
          return;
        }
        paramFileItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
        paramFileItemHolder.jdField_a_of_type_Int = 0;
        return;
      case 0: 
      case 3: 
        paramFileItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
        paramFileItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
        paramFileItemHolder.jdField_a_of_type_Int = 3;
        return;
      case -1: 
      case 13: 
        paramFileItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
        paramFileItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
        paramFileItemHolder.jdField_a_of_type_Int = 1;
        return;
      }
    }
    paramFileItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(1);
    paramFileItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
    paramFileItemHolder.jdField_a_of_type_Int = 2;
  }
  
  public void a(ChatHistoryC2CFileAdapter.OnSelectedListener paramOnSelectedListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryAdapterChatHistoryC2CFileAdapter$OnSelectedListener = paramOnSelectedListener;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    notifyDataSetChanged();
  }
  
  public void b(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView != null) && ((paramView.getTag() instanceof ChatHistoryC2CFileAdapter.FileItemHolder)))
    {
      paramViewGroup = (ChatHistoryC2CFileAdapter.FileItemHolder)paramView.getTag();
    }
    else
    {
      localObject = new ChatHistoryC2CFileAdapter.FileItemHolder(this);
      paramView = LayoutInflater.from(this.jdField_b_of_type_AndroidContentContext).inflate(2131560778, paramViewGroup, false);
      ((ChatHistoryC2CFileAdapter.FileItemHolder)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131376167));
      ((ChatHistoryC2CFileAdapter.FileItemHolder)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      ((ChatHistoryC2CFileAdapter.FileItemHolder)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localObject);
      ((ChatHistoryC2CFileAdapter.FileItemHolder)localObject).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView = ((CircleFileStateView)paramView.findViewById(2131361949));
      ((ChatHistoryC2CFileAdapter.FileItemHolder)localObject).jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131366794));
      ((ChatHistoryC2CFileAdapter.FileItemHolder)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131366781));
      ((ChatHistoryC2CFileAdapter.FileItemHolder)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366792));
      ((ChatHistoryC2CFileAdapter.FileItemHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.setGravity(48);
      ((ChatHistoryC2CFileAdapter.FileItemHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
      ((ChatHistoryC2CFileAdapter.FileItemHolder)localObject).b = ((TextView)paramView.findViewById(2131366779));
      ((ChatHistoryC2CFileAdapter.FileItemHolder)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(AIOUtils.b(70.0F, this.jdField_b_of_type_AndroidContentContext.getResources()), AIOUtils.b(70.0F, this.jdField_b_of_type_AndroidContentContext.getResources()));
      paramView.setTag(localObject);
      paramViewGroup = (ViewGroup)localObject;
    }
    Object localObject = (FileManagerEntity)getChild(paramInt1, paramInt2);
    if (localObject == null) {
      return paramView;
    }
    FileManagerUtil.a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, (FileManagerEntity)localObject);
    paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    paramViewGroup.jdField_a_of_type_JavaLangObject = localObject;
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setTag(paramViewGroup);
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setProgress((int)(((FileManagerEntity)localObject).fProgress * 100.0F));
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setProgressRingWidth(3.0F);
    b(paramViewGroup, (FileManagerEntity)localObject);
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((FileManagerEntity)localObject).fileName);
    if (5 != ((FileManagerEntity)localObject).cloudType) {
      FileManagerUtil.b((FileManagerEntity)localObject);
    }
    a(paramViewGroup, (FileManagerEntity)localObject);
    c(paramViewGroup, (FileManagerEntity)localObject);
    FileManagerUtil.a(paramViewGroup.b, (FileManagerEntity)localObject);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.adapter.ChatHistoryC2CFileAdapter
 * JD-Core Version:    0.7.0.1
 */