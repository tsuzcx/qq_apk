package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatHistoryViewBase;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.CircleFileStateView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class ChatHistoryFileAdapter
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private ChatHistoryViewBase jdField_a_of_type_ComTencentMobileqqActivityChatHistoryViewBase;
  private ChatHistoryFileAdapter.OnSelectedListener jdField_a_of_type_ComTencentMobileqqAdapterChatHistoryFileAdapter$OnSelectedListener;
  private final String jdField_a_of_type_JavaLangString = "ChatHistoryFileAdapter";
  private List<Object> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean = false;
  private View.OnClickListener b;
  
  public ChatHistoryFileAdapter(Context paramContext, List<Object> paramList, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, ChatHistoryViewBase paramChatHistoryViewBase)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener1;
    this.b = paramOnClickListener2;
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryViewBase = paramChatHistoryViewBase;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public void a(ChatHistoryFileAdapter.OnSelectedListener paramOnSelectedListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAdapterChatHistoryFileAdapter$OnSelectedListener = paramOnSelectedListener;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList == null) {
      return 0;
    }
    return localList.size();
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
      try
      {
        FileManagerEntity localFileManagerEntity = (FileManagerEntity)localObject2;
        boolean bool1 = false;
        if (paramView != null)
        {
          localObject1 = paramView;
          if ((paramView.getTag() instanceof ChatHistoryFileAdapter.HistoryFileItemHolder))
          {
            localObject1 = paramView;
            localObject2 = (ChatHistoryFileAdapter.HistoryFileItemHolder)paramView.getTag();
            continue;
          }
        }
        localObject1 = paramView;
        localObject2 = new ChatHistoryFileAdapter.HistoryFileItemHolder(this);
        localObject1 = paramView;
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560778, paramViewGroup, false);
        localObject1 = paramView;
        ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131376167));
        localObject1 = paramView;
        ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        localObject1 = paramView;
        ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localObject2);
        localObject1 = paramView;
        ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView = ((CircleFileStateView)paramView.findViewById(2131361949));
        localObject1 = paramView;
        ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131366794));
        localObject1 = paramView;
        ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131366781));
        localObject1 = paramView;
        ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366792));
        localObject1 = paramView;
        ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
        localObject1 = paramView;
        ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).b = ((TextView)paramView.findViewById(2131366779));
        localObject1 = paramView;
        ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(AIOUtils.b(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.b(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        localObject1 = paramView;
        paramView.setTag(localObject2);
        localObject1 = paramView;
        FileManagerUtil.a(((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileManagerEntity);
        localObject1 = paramView;
        ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        localObject1 = paramView;
        ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_JavaLangObject = localFileManagerEntity;
        localObject1 = paramView;
        ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setOnClickListener(this.b);
        localObject1 = paramView;
        ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setTag(localObject2);
        localObject1 = paramView;
        ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setProgress((int)(localFileManagerEntity.fProgress * 100.0F));
        localObject1 = paramView;
        ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setProgressRingWidth(3.0F);
        localObject1 = paramView;
        if (FileManagerUtil.a(localFileManagerEntity.fileName) == 0)
        {
          localObject1 = paramView;
          if (FileUtils.fileExistsAndNotEmpty(localFileManagerEntity.getFilePath()))
          {
            localObject1 = paramView;
            FileManagerUtil.a(((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileManagerEntity.getFilePath(), localFileManagerEntity.nFileType);
          }
          else
          {
            localObject1 = paramView;
            if (FileUtils.fileExistsAndNotEmpty(localFileManagerEntity.strThumbPath))
            {
              localObject1 = paramView;
              ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130844363);
              localObject1 = paramView;
              ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncImage(localFileManagerEntity.strThumbPath);
            }
            else
            {
              localObject1 = paramView;
              FileManagerUtil.a(((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileManagerEntity.fileName, localFileManagerEntity.nFileType);
            }
          }
        }
        else
        {
          localObject1 = paramView;
          FileManagerUtil.a(((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileManagerEntity);
        }
        localObject1 = paramView;
        ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.setText(localFileManagerEntity.fileName);
        localObject1 = paramView;
        if (5 != localFileManagerEntity.cloudType)
        {
          localObject1 = paramView;
          FileManagerUtil.b(localFileManagerEntity);
        }
        localObject1 = paramView;
        int i = localFileManagerEntity.status;
        if (i != 18) {}
        switch (i)
        {
        case 14: 
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
          break;
        case 15: 
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_Int = 2;
          break;
        case 13: 
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_Int = 1;
          break;
        case 10: 
        case 11: 
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_Int = 0;
          break;
        case 9: 
        case 12: 
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_Int = 0;
          break;
        case 5: 
        case 6: 
        case 7: 
        case 8: 
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_Int = 0;
          break;
        case 4: 
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_Int = 1;
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
          break;
        case 3: 
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_Int = 3;
          break;
        case 1: 
          localObject1 = paramView;
          boolean bool2 = FileUtil.b(localFileManagerEntity.getFilePath());
          localObject1 = paramView;
          if (localFileManagerEntity.getCloudType() != 3)
          {
            localObject1 = paramView;
            if ((localFileManagerEntity.getCloudType() != 5) && (!bool2))
            {
              localObject1 = paramView;
              ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
              localObject1 = paramView;
              ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
              localObject1 = paramView;
              ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_Int = 1;
              continue;
            }
          }
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_Int = 0;
          break;
        case 0: 
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_Int = 3;
          break;
        case -1: 
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_Int = 1;
          break;
        case 2: 
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(1);
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_Int = 2;
          localObject1 = paramView;
          if (this.jdField_a_of_type_Boolean)
          {
            localObject1 = paramView;
            ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
            localObject1 = paramView;
            ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
            localObject1 = paramView;
            ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
            localObject1 = paramView;
            if (this.jdField_a_of_type_ComTencentMobileqqAdapterChatHistoryFileAdapter$OnSelectedListener != null)
            {
              localObject1 = paramView;
              bool1 = this.jdField_a_of_type_ComTencentMobileqqAdapterChatHistoryFileAdapter$OnSelectedListener.a(localFileManagerEntity);
            }
            localObject1 = paramView;
            ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool1);
          }
          else
          {
            localObject1 = paramView;
            ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
          }
          localObject1 = paramView;
          FileManagerUtil.a(((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).b, localFileManagerEntity);
          localObject1 = paramView;
        }
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
      }
      localObject1 = paramView;
      if ((localObject2 instanceof String))
      {
        if ((paramView != null) && ((paramView.getTag() instanceof TextView)))
        {
          localObject1 = (TextView)paramView.getTag();
        }
        else
        {
          paramView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131560802, null);
          localObject1 = (TextView)paramView.findViewById(2131378475);
          paramView.setTag(localObject1);
        }
        ((TextView)localObject1).setText((String)localObject2);
        localObject1 = paramView;
      }
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.ChatHistoryFileAdapter
 * JD-Core Version:    0.7.0.1
 */