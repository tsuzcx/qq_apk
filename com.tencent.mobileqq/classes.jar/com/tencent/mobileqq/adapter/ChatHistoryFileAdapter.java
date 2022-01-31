package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatHistoryFileActivity;
import com.tencent.mobileqq.activity.ChatHistoryViewBase;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.utils.FileUtils;
import java.util.List;

public class ChatHistoryFileAdapter
  extends BaseAdapter
{
  Context jdField_a_of_type_AndroidContentContext;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  ChatHistoryViewBase jdField_a_of_type_ComTencentMobileqqActivityChatHistoryViewBase;
  List jdField_a_of_type_JavaUtilList;
  View.OnClickListener b;
  
  public ChatHistoryFileAdapter(Context paramContext, List paramList, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, ChatHistoryViewBase paramChatHistoryViewBase)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener1;
    this.b = paramOnClickListener2;
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryViewBase = paramChatHistoryViewBase;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
  }
  
  private String a(FileManagerEntity paramFileManagerEntity)
  {
    String str1 = null;
    Object localObject;
    String str2;
    switch (paramFileManagerEntity.getCloudType())
    {
    case 4: 
    default: 
      localObject = null;
      String str3 = this.jdField_a_of_type_AndroidContentContext.getString(2131428143);
      str2 = FileUtil.a(paramFileManagerEntity.fileSize) + a(str3, (String)localObject) + a(str3, str1);
      localObject = FileUtil.a(paramFileManagerEntity.fileSize) + a(str3, str1);
      if ((paramFileManagerEntity.getCloudType() == 2) && (3 == paramFileManagerEntity.nOpType)) {
        localObject = str2;
      }
      break;
    }
    do
    {
      return localObject;
      localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131428100);
      str1 = FileManagerUtil.a(paramFileManagerEntity.srvTime, paramFileManagerEntity.peerType, false);
      str1 = str1 + this.jdField_a_of_type_AndroidContentContext.getString(2131428138);
      break;
      localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131428101);
      break;
      localObject = null;
      break;
      localObject = null;
      break;
      localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131431804);
      break;
      if (paramFileManagerEntity.getCloudType() == 5) {
        return str2;
      }
    } while (paramFileManagerEntity.TroopUin == 0L);
    return str2;
  }
  
  private String a(String paramString1, String paramString2)
  {
    if ((paramString2 == null) || (paramString2.equalsIgnoreCase(""))) {
      return "";
    }
    return paramString1 + paramString2;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2 = getItem(paramInt);
    Object localObject1;
    if ((localObject2 instanceof FileManagerEntity)) {
      localObject1 = paramView;
    }
    for (;;)
    {
      FileManagerEntity localFileManagerEntity;
      try
      {
        localFileManagerEntity = (FileManagerEntity)localObject2;
        if (paramView != null)
        {
          localObject1 = paramView;
          if ((paramView.getTag() instanceof ChatHistoryFileAdapter.HistoryFileItemHolder))
          {
            localObject1 = paramView;
            paramViewGroup = (ChatHistoryFileAdapter.HistoryFileItemHolder)paramView.getTag();
            localObject1 = paramView;
            FileManagerUtil.a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileManagerEntity);
            localObject1 = paramView;
            paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
            localObject1 = paramView;
            paramViewGroup.jdField_a_of_type_JavaLangObject = localFileManagerEntity;
            localObject1 = paramView;
            paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.b);
            localObject1 = paramView;
            paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setTag(paramViewGroup);
            localObject1 = paramView;
            if (FileManagerUtil.a(localFileManagerEntity.fileName) != 0) {
              break label837;
            }
            localObject1 = paramView;
            if (!FileUtils.b(localFileManagerEntity.getFilePath())) {
              continue;
            }
            localObject1 = paramView;
            FileManagerUtil.a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileManagerEntity.getFilePath(), localFileManagerEntity.nFileType);
            localObject1 = paramView;
            paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(FileManagerUtil.d(localFileManagerEntity.fileName));
            localObject1 = paramView;
            paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(a(localFileManagerEntity));
            localObject1 = paramView;
            paramViewGroup.c.setVisibility(0);
            localObject1 = paramView;
            paramViewGroup.c.setText(FileManagerUtil.a(localFileManagerEntity));
            localObject1 = paramView;
            paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
            localObject1 = paramView;
            if (5 != localFileManagerEntity.cloudType)
            {
              localObject1 = paramView;
              FileManagerUtil.c(localFileManagerEntity);
            }
            localObject1 = paramView;
          }
        }
        switch (localFileManagerEntity.status)
        {
        case 16: 
        case 17: 
          localObject1 = paramView;
          paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          localObject1 = paramView;
          paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          localObject1 = paramView;
          if (!this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryViewBase.a()) {
            break label1503;
          }
          localObject1 = paramView;
          paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          localObject1 = paramView;
          paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
          localObject1 = paramView;
          paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          localObject1 = paramView;
          paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838591);
          localObject1 = paramView;
          paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
          localObject1 = paramView;
          paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryViewBase.a.a(localFileManagerEntity));
          return paramView;
          localObject1 = paramView;
          localObject2 = new ChatHistoryFileAdapter.HistoryFileItemHolder(this);
          localObject1 = paramView;
          paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130970021, paramViewGroup, false);
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131368769));
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localObject2);
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131368774));
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131368770));
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131368772));
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368773));
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368732));
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131364142));
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368776));
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).c = ((TextView)paramView.findViewById(2131363205));
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_b_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131362747));
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(AIOUtils.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          localObject1 = paramView;
          paramView.setTag(localObject2);
          paramViewGroup = (ViewGroup)localObject2;
          continue;
          localObject1 = paramView;
          if (FileUtils.b(localFileManagerEntity.strThumbPath))
          {
            localObject1 = paramView;
            paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130841666);
            localObject1 = paramView;
            paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncImage(localFileManagerEntity.strThumbPath);
            continue;
          }
          localObject1 = paramView;
        }
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        return localObject1;
      }
      FileManagerUtil.a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileManagerEntity.fileName, localFileManagerEntity.nFileType);
      continue;
      label837:
      localObject1 = paramView;
      FileManagerUtil.a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileManagerEntity);
      continue;
      localObject1 = paramView;
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131428318);
      localObject1 = paramView;
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      localObject1 = paramView;
      paramViewGroup.jdField_a_of_type_Int = 2;
      localObject1 = paramView;
      paramViewGroup.c.setVisibility(4);
      localObject1 = paramView;
      paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      localObject1 = paramView;
      paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(localFileManagerEntity.fProgress * 100.0F));
      continue;
      localObject1 = paramView;
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131428319);
      localObject1 = paramView;
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      localObject1 = paramView;
      paramViewGroup.jdField_a_of_type_Int = 3;
      localObject1 = paramView;
      paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      continue;
      localObject1 = paramView;
      boolean bool = FileUtil.a(localFileManagerEntity.getFilePath());
      localObject1 = paramView;
      if (localFileManagerEntity.getCloudType() != 3)
      {
        localObject1 = paramView;
        if ((localFileManagerEntity.getCloudType() != 5) && (!bool)) {}
      }
      else
      {
        localObject1 = paramView;
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131428316);
        localObject1 = paramView;
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        localObject1 = paramView;
      }
      for (paramViewGroup.jdField_a_of_type_Int = 0;; paramViewGroup.jdField_a_of_type_Int = 1)
      {
        localObject1 = paramView;
        paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
        break;
        localObject1 = paramView;
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131428320);
        localObject1 = paramView;
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        localObject1 = paramView;
      }
      localObject1 = paramView;
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131428319);
      localObject1 = paramView;
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      localObject1 = paramView;
      paramViewGroup.jdField_a_of_type_Int = 3;
      localObject1 = paramView;
      paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      continue;
      localObject1 = paramView;
      paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      localObject1 = paramView;
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131428316);
      localObject1 = paramView;
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      localObject1 = paramView;
      paramViewGroup.jdField_a_of_type_Int = 0;
      continue;
      localObject1 = paramView;
      paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      localObject1 = paramView;
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131428320);
      localObject1 = paramView;
      paramViewGroup.jdField_a_of_type_Int = 1;
      localObject1 = paramView;
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      continue;
      localObject1 = paramView;
      paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      localObject1 = paramView;
      paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      localObject1 = paramView;
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131428316);
      localObject1 = paramView;
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      localObject1 = paramView;
      paramViewGroup.jdField_a_of_type_Int = 0;
      continue;
      localObject1 = paramView;
      paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      localObject1 = paramView;
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131428316);
      localObject1 = paramView;
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      localObject1 = paramView;
      paramViewGroup.jdField_a_of_type_Int = 0;
      continue;
      localObject1 = paramView;
      paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      localObject1 = paramView;
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131428320);
      localObject1 = paramView;
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      localObject1 = paramView;
      paramViewGroup.jdField_a_of_type_Int = 1;
      continue;
      localObject1 = paramView;
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131428316);
      localObject1 = paramView;
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      localObject1 = paramView;
      paramViewGroup.jdField_a_of_type_Int = 2;
      localObject1 = paramView;
      paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      localObject1 = paramView;
      paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(localFileManagerEntity.fProgress * 100.0F));
      continue;
      localObject1 = paramView;
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131428320);
      localObject1 = paramView;
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      localObject1 = paramView;
      paramViewGroup.jdField_a_of_type_Int = 1;
      localObject1 = paramView;
      paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      continue;
      label1503:
      localObject1 = paramView;
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
      return paramView;
      if (!(localObject2 instanceof String)) {
        break;
      }
      if ((paramView != null) && ((paramView.getTag() instanceof TextView)))
      {
        localObject1 = (TextView)paramView.getTag();
        paramViewGroup = paramView;
        paramView = (View)localObject1;
      }
      for (;;)
      {
        paramView.setText((String)localObject2);
        return paramViewGroup;
        paramViewGroup = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2130970041, null);
        paramView = (TextView)paramViewGroup.findViewById(2131365558);
        paramViewGroup.setTag(paramView);
      }
    }
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.ChatHistoryFileAdapter
 * JD-Core Version:    0.7.0.1
 */