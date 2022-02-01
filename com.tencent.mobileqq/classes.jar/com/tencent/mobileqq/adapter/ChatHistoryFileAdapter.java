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
  private final String a = "ChatHistoryFileAdapter";
  private View.OnClickListener b;
  private View.OnClickListener c;
  private List<Object> d;
  private Context e;
  private ChatHistoryViewBase f;
  private LayoutInflater g;
  private ChatHistoryFileAdapter.OnSelectedListener h;
  private boolean i = false;
  
  public ChatHistoryFileAdapter(Context paramContext, List<Object> paramList, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, ChatHistoryViewBase paramChatHistoryViewBase)
  {
    this.e = paramContext;
    this.d = paramList;
    this.b = paramOnClickListener1;
    this.c = paramOnClickListener2;
    this.f = paramChatHistoryViewBase;
    this.g = LayoutInflater.from(this.e);
  }
  
  public void a(ChatHistoryFileAdapter.OnSelectedListener paramOnSelectedListener)
  {
    this.h = paramOnSelectedListener;
  }
  
  public void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    List localList = this.d;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.d.get(paramInt);
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
        paramView = this.g.inflate(2131627036, paramViewGroup, false);
        localObject1 = paramView;
        ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).a = ((RelativeLayout)paramView.findViewById(2131444373));
        localObject1 = paramView;
        ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).a.setOnClickListener(this.b);
        localObject1 = paramView;
        ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).a.setTag(localObject2);
        localObject1 = paramView;
        ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).b = ((CircleFileStateView)paramView.findViewById(2131427503));
        localObject1 = paramView;
        ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).d = ((CheckBox)paramView.findViewById(2131433116));
        localObject1 = paramView;
        ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).e = ((AsyncImageView)paramView.findViewById(2131433103));
        localObject1 = paramView;
        ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).f = ((TextView)paramView.findViewById(2131433114));
        localObject1 = paramView;
        ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).f.setMaxLines(2);
        localObject1 = paramView;
        ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).g = ((TextView)paramView.findViewById(2131433101));
        localObject1 = paramView;
        ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).e.setAsyncClipSize(AIOUtils.b(70.0F, this.e.getResources()), AIOUtils.b(70.0F, this.e.getResources()));
        localObject1 = paramView;
        paramView.setTag(localObject2);
        localObject1 = paramView;
        FileManagerUtil.a(((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).e, localFileManagerEntity);
        localObject1 = paramView;
        ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).a.setVisibility(0);
        localObject1 = paramView;
        ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).h = localFileManagerEntity;
        localObject1 = paramView;
        ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).b.setOnClickListener(this.c);
        localObject1 = paramView;
        ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).b.setTag(localObject2);
        localObject1 = paramView;
        ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).b.setProgress((int)(localFileManagerEntity.fProgress * 100.0F));
        localObject1 = paramView;
        ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).b.setProgressRingWidth(3.0F);
        localObject1 = paramView;
        if (FileManagerUtil.c(localFileManagerEntity.fileName) == 0)
        {
          localObject1 = paramView;
          if (FileUtils.fileExistsAndNotEmpty(localFileManagerEntity.getFilePath()))
          {
            localObject1 = paramView;
            FileManagerUtil.a(((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).e, localFileManagerEntity.getFilePath(), localFileManagerEntity.nFileType);
          }
          else
          {
            localObject1 = paramView;
            if (FileUtils.fileExistsAndNotEmpty(localFileManagerEntity.strThumbPath))
            {
              localObject1 = paramView;
              ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).e.setDefaultImage(2130845680);
              localObject1 = paramView;
              ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).e.setAsyncImage(localFileManagerEntity.strThumbPath);
            }
            else
            {
              localObject1 = paramView;
              FileManagerUtil.a(((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).e, localFileManagerEntity.fileName, localFileManagerEntity.nFileType);
            }
          }
        }
        else
        {
          localObject1 = paramView;
          FileManagerUtil.a(((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).e, localFileManagerEntity);
        }
        localObject1 = paramView;
        ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).f.setText(localFileManagerEntity.fileName);
        localObject1 = paramView;
        if (5 != localFileManagerEntity.cloudType)
        {
          localObject1 = paramView;
          FileManagerUtil.e(localFileManagerEntity);
        }
        localObject1 = paramView;
        int j = localFileManagerEntity.status;
        if (j != 18) {}
        switch (j)
        {
        case 14: 
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).b.setVisibility(8);
          break;
        case 15: 
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).b.setState(2);
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).b.setVisibility(8);
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).c = 2;
          break;
        case 13: 
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).b.setState(2);
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).b.setVisibility(0);
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).c = 1;
          break;
        case 10: 
        case 11: 
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).b.setVisibility(8);
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).c = 0;
          break;
        case 9: 
        case 12: 
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).b.setVisibility(8);
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).c = 0;
          break;
        case 5: 
        case 6: 
        case 7: 
        case 8: 
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).b.setVisibility(8);
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).c = 0;
          break;
        case 4: 
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).b.setState(2);
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).c = 1;
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).b.setVisibility(0);
          break;
        case 3: 
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).b.setState(2);
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).b.setVisibility(0);
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).c = 3;
          break;
        case 1: 
          localObject1 = paramView;
          boolean bool2 = FileUtil.d(localFileManagerEntity.getFilePath());
          localObject1 = paramView;
          if (localFileManagerEntity.getCloudType() != 3)
          {
            localObject1 = paramView;
            if ((localFileManagerEntity.getCloudType() != 5) && (!bool2))
            {
              localObject1 = paramView;
              ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).b.setState(2);
              localObject1 = paramView;
              ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).b.setVisibility(0);
              localObject1 = paramView;
              ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).c = 1;
              continue;
            }
          }
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).b.setVisibility(8);
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).c = 0;
          break;
        case 0: 
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).b.setState(2);
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).b.setVisibility(0);
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).c = 3;
          break;
        case -1: 
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).b.setState(2);
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).b.setVisibility(0);
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).c = 1;
          break;
        case 2: 
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).b.setState(1);
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).b.setVisibility(0);
          localObject1 = paramView;
          ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).c = 2;
          localObject1 = paramView;
          if (this.i)
          {
            localObject1 = paramView;
            ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).b.setVisibility(8);
            localObject1 = paramView;
            ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).d.setVisibility(8);
            localObject1 = paramView;
            ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).d.setVisibility(0);
            localObject1 = paramView;
            if (this.h != null)
            {
              localObject1 = paramView;
              bool1 = this.h.b(localFileManagerEntity);
            }
            localObject1 = paramView;
            ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).d.setChecked(bool1);
          }
          else
          {
            localObject1 = paramView;
            ((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).d.setVisibility(8);
          }
          localObject1 = paramView;
          FileManagerUtil.a(((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject2).g, localFileManagerEntity);
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
          paramView = View.inflate(this.e, 2131627060, null);
          localObject1 = (TextView)paramView.findViewById(2131447089);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.ChatHistoryFileAdapter
 * JD-Core Version:    0.7.0.1
 */