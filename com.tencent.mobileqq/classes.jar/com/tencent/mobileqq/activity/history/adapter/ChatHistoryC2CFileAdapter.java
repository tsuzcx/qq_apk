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
      if (FileUtils.b(paramFileManagerEntity.getFilePath()))
      {
        FileManagerUtil.a(paramFileItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, paramFileManagerEntity.getFilePath(), paramFileManagerEntity.nFileType);
        return;
      }
      if (FileUtils.b(paramFileManagerEntity.strThumbPath))
      {
        paramFileItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130844458);
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
    boolean bool = false;
    if (this.jdField_a_of_type_Boolean)
    {
      paramFileItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
      paramFileItemHolder.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
      paramFileItemHolder.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryAdapterChatHistoryC2CFileAdapter$OnSelectedListener != null)
      {
        bool = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryAdapterChatHistoryC2CFileAdapter$OnSelectedListener.a(paramFileManagerEntity);
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
    switch (paramFileManagerEntity.status)
    {
    case 16: 
    case 17: 
    default: 
      paramFileItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
      return;
    case 2: 
    case 18: 
      paramFileItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(1);
      paramFileItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
      paramFileItemHolder.jdField_a_of_type_Int = 2;
      return;
    case 0: 
    case 3: 
      paramFileItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
      paramFileItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
      paramFileItemHolder.jdField_a_of_type_Int = 3;
      return;
    case 1: 
      boolean bool = FileUtil.a(paramFileManagerEntity.getFilePath());
      if ((paramFileManagerEntity.getCloudType() == 3) || (paramFileManagerEntity.getCloudType() == 5) || (bool))
      {
        paramFileItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
        paramFileItemHolder.jdField_a_of_type_Int = 0;
        return;
      }
      paramFileItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
      paramFileItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
      paramFileItemHolder.jdField_a_of_type_Int = 1;
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
    case -1: 
    case 13: 
      paramFileItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
      paramFileItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
      paramFileItemHolder.jdField_a_of_type_Int = 1;
      return;
    }
    paramFileItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
    paramFileItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
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
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)getChild(paramInt1, paramInt2);
    if ((paramView != null) && ((paramView.getTag() instanceof ChatHistoryC2CFileAdapter.FileItemHolder)))
    {
      ChatHistoryC2CFileAdapter.FileItemHolder localFileItemHolder = (ChatHistoryC2CFileAdapter.FileItemHolder)paramView.getTag();
      paramViewGroup = paramView;
      paramView = localFileItemHolder;
    }
    for (;;)
    {
      FileManagerUtil.a(paramView.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileManagerEntity);
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      paramView.jdField_a_of_type_JavaLangObject = localFileManagerEntity;
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setTag(paramView);
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setProgress((int)(localFileManagerEntity.fProgress * 100.0F));
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setProgressRingWidth(3.0F);
      b(paramView, localFileManagerEntity);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(localFileManagerEntity.fileName);
      if (5 != localFileManagerEntity.cloudType) {
        FileManagerUtil.b(localFileManagerEntity);
      }
      a(paramView, localFileManagerEntity);
      c(paramView, localFileManagerEntity);
      FileManagerUtil.a(paramView.b, localFileManagerEntity);
      return paramViewGroup;
      paramView = new ChatHistoryC2CFileAdapter.FileItemHolder(this);
      paramViewGroup = LayoutInflater.from(this.jdField_b_of_type_AndroidContentContext).inflate(2131560904, paramViewGroup, false);
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131376663));
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(paramView);
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView = ((CircleFileStateView)paramViewGroup.findViewById(2131361943));
      paramView.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramViewGroup.findViewById(2131366932));
      paramView.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramViewGroup.findViewById(2131366919));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131366930));
      paramView.jdField_a_of_type_AndroidWidgetTextView.setGravity(48);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
      paramView.b = ((TextView)paramViewGroup.findViewById(2131366917));
      paramView.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(AIOUtils.a(70.0F, this.jdField_b_of_type_AndroidContentContext.getResources()), AIOUtils.a(70.0F, this.jdField_b_of_type_AndroidContentContext.getResources()));
      paramViewGroup.setTag(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.adapter.ChatHistoryC2CFileAdapter
 * JD-Core Version:    0.7.0.1
 */