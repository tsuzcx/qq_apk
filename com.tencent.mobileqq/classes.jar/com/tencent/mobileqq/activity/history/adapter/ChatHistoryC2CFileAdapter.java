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
  private boolean a = false;
  private ChatHistoryC2CFileAdapter.OnSelectedListener b;
  private View.OnClickListener c;
  private View.OnClickListener d;
  
  public ChatHistoryC2CFileAdapter(Context paramContext, Object paramObject)
  {
    super(paramContext, paramObject);
  }
  
  private void b(ChatHistoryC2CFileAdapter.FileItemHolder paramFileItemHolder, FileManagerEntity paramFileManagerEntity)
  {
    if (FileManagerUtil.c(paramFileManagerEntity.fileName) == 0)
    {
      if (FileUtils.fileExistsAndNotEmpty(paramFileManagerEntity.getFilePath()))
      {
        FileManagerUtil.a(paramFileItemHolder.e, paramFileManagerEntity.getFilePath(), paramFileManagerEntity.nFileType);
        return;
      }
      if (FileUtils.fileExistsAndNotEmpty(paramFileManagerEntity.strThumbPath))
      {
        paramFileItemHolder.e.setDefaultImage(2130845680);
        paramFileItemHolder.e.setAsyncImage(paramFileManagerEntity.strThumbPath);
        return;
      }
      FileManagerUtil.a(paramFileItemHolder.e, paramFileManagerEntity.fileName, paramFileManagerEntity.nFileType);
      return;
    }
    FileManagerUtil.a(paramFileItemHolder.e, paramFileManagerEntity);
  }
  
  private void c(ChatHistoryC2CFileAdapter.FileItemHolder paramFileItemHolder, FileManagerEntity paramFileManagerEntity)
  {
    if (this.a)
    {
      paramFileItemHolder.b.setVisibility(8);
      paramFileItemHolder.d.setVisibility(8);
      Object localObject = paramFileItemHolder.d;
      boolean bool = false;
      ((CheckBox)localObject).setVisibility(0);
      localObject = this.b;
      if (localObject != null)
      {
        bool = ((ChatHistoryC2CFileAdapter.OnSelectedListener)localObject).f(paramFileManagerEntity);
        this.b.g(paramFileManagerEntity);
      }
      paramFileItemHolder.d.setChecked(bool);
      return;
    }
    paramFileItemHolder.d.setVisibility(8);
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.d = paramOnClickListener;
  }
  
  protected void a(ChatHistoryC2CFileAdapter.FileItemHolder paramFileItemHolder, FileManagerEntity paramFileManagerEntity)
  {
    int i = paramFileManagerEntity.status;
    if (i != 18) {
      switch (i)
      {
      default: 
        paramFileItemHolder.b.setVisibility(8);
        return;
      case 14: 
      case 15: 
        paramFileItemHolder.b.setState(2);
        paramFileItemHolder.b.setVisibility(8);
        paramFileItemHolder.c = 2;
        return;
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      case 9: 
      case 10: 
      case 11: 
      case 12: 
        paramFileItemHolder.b.setVisibility(8);
        paramFileItemHolder.c = 0;
        return;
      case 4: 
        paramFileItemHolder.b.setState(2);
        paramFileItemHolder.c = 1;
        paramFileItemHolder.b.setVisibility(0);
        return;
      case 1: 
        boolean bool = FileUtil.d(paramFileManagerEntity.getFilePath());
        if ((paramFileManagerEntity.getCloudType() != 3) && (paramFileManagerEntity.getCloudType() != 5) && (!bool))
        {
          paramFileItemHolder.b.setState(2);
          paramFileItemHolder.b.setVisibility(0);
          paramFileItemHolder.c = 1;
          return;
        }
        paramFileItemHolder.b.setVisibility(8);
        paramFileItemHolder.c = 0;
        return;
      case 0: 
      case 3: 
        paramFileItemHolder.b.setState(2);
        paramFileItemHolder.b.setVisibility(0);
        paramFileItemHolder.c = 3;
        return;
      case -1: 
      case 13: 
        paramFileItemHolder.b.setState(2);
        paramFileItemHolder.b.setVisibility(0);
        paramFileItemHolder.c = 1;
        return;
      }
    }
    paramFileItemHolder.b.setState(1);
    paramFileItemHolder.b.setVisibility(0);
    paramFileItemHolder.c = 2;
  }
  
  public void a(ChatHistoryC2CFileAdapter.OnSelectedListener paramOnSelectedListener)
  {
    this.b = paramOnSelectedListener;
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
    notifyDataSetChanged();
  }
  
  public void b(View.OnClickListener paramOnClickListener)
  {
    this.c = paramOnClickListener;
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
      paramView = LayoutInflater.from(this.e).inflate(2131627036, paramViewGroup, false);
      ((ChatHistoryC2CFileAdapter.FileItemHolder)localObject).a = ((RelativeLayout)paramView.findViewById(2131444373));
      ((ChatHistoryC2CFileAdapter.FileItemHolder)localObject).a.setOnClickListener(this.c);
      ((ChatHistoryC2CFileAdapter.FileItemHolder)localObject).a.setTag(localObject);
      ((ChatHistoryC2CFileAdapter.FileItemHolder)localObject).b = ((CircleFileStateView)paramView.findViewById(2131427503));
      ((ChatHistoryC2CFileAdapter.FileItemHolder)localObject).d = ((CheckBox)paramView.findViewById(2131433116));
      ((ChatHistoryC2CFileAdapter.FileItemHolder)localObject).e = ((AsyncImageView)paramView.findViewById(2131433103));
      ((ChatHistoryC2CFileAdapter.FileItemHolder)localObject).f = ((TextView)paramView.findViewById(2131433114));
      ((ChatHistoryC2CFileAdapter.FileItemHolder)localObject).f.setGravity(48);
      ((ChatHistoryC2CFileAdapter.FileItemHolder)localObject).f.setMaxLines(2);
      ((ChatHistoryC2CFileAdapter.FileItemHolder)localObject).g = ((TextView)paramView.findViewById(2131433101));
      ((ChatHistoryC2CFileAdapter.FileItemHolder)localObject).e.setAsyncClipSize(AIOUtils.b(70.0F, this.e.getResources()), AIOUtils.b(70.0F, this.e.getResources()));
      paramView.setTag(localObject);
      paramViewGroup = (ViewGroup)localObject;
    }
    Object localObject = (FileManagerEntity)getChild(paramInt1, paramInt2);
    if (localObject == null) {
      return paramView;
    }
    FileManagerUtil.a(paramViewGroup.e, (FileManagerEntity)localObject);
    paramViewGroup.a.setVisibility(0);
    paramViewGroup.h = localObject;
    paramViewGroup.b.setOnClickListener(this.d);
    paramViewGroup.b.setTag(paramViewGroup);
    paramViewGroup.b.setProgress((int)(((FileManagerEntity)localObject).fProgress * 100.0F));
    paramViewGroup.b.setProgressRingWidth(3.0F);
    b(paramViewGroup, (FileManagerEntity)localObject);
    paramViewGroup.f.setText(((FileManagerEntity)localObject).fileName);
    if (5 != ((FileManagerEntity)localObject).cloudType) {
      FileManagerUtil.e((FileManagerEntity)localObject);
    }
    a(paramViewGroup, (FileManagerEntity)localObject);
    c(paramViewGroup, (FileManagerEntity)localObject);
    FileManagerUtil.a(paramViewGroup.g, (FileManagerEntity)localObject);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.adapter.ChatHistoryC2CFileAdapter
 * JD-Core Version:    0.7.0.1
 */