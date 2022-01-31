package com.tencent.mobileqq.activity.aio.item;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.device.msg.data.DeviceComnFileMsgProcessor;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.TouchDelegate;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.mobileqq.data.MessageForDeviceFile.DeviceFileItemCallback;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import uvt;
import uvu;
import uvv;

public class DeviceFileItemBuilder
  extends BaseBubbleBuilder
  implements BaseBubbleBuilder.TouchDelegate, MessageForDeviceFile.DeviceFileItemCallback
{
  boolean c = false;
  
  public DeviceFileItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  @SuppressLint({"ResourceAsColor"})
  @TargetApi(11)
  private RelativeLayout a(uvv paramuvv)
  {
    int i = AIOUtils.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int j = AIOUtils.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int k = AIOUtils.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    localRelativeLayout.setId(2131361877);
    Object localObject2 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    ((RelativeLayout)localObject2).setId(2131361958);
    ((RelativeLayout)localObject2).setBackgroundResource(2130841600);
    ((RelativeLayout)localObject2).setPadding(AIOUtils.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), i, i, AIOUtils.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    paramuvv.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject2);
    Object localObject1 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(10, 2131361877);
    localRelativeLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    ((RelativeLayout)localObject1).setId(2131361959);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, k);
    localLayoutParams.addRule(10, 2131361958);
    ((RelativeLayout)localObject2).addView((View)localObject1, localLayoutParams);
    localObject2 = new AsyncImageView(this.jdField_a_of_type_AndroidContentContext, k, k);
    ((AsyncImageView)localObject2).setId(2131361960);
    ((AsyncImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
    localLayoutParams = new RelativeLayout.LayoutParams(k, k);
    localLayoutParams.addRule(9, 2131361959);
    localLayoutParams.addRule(15, 2131361959);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramuvv.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)localObject2);
    localObject2 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject2).setId(2131361886);
    ((ImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
    localLayoutParams = new RelativeLayout.LayoutParams(j, j);
    localLayoutParams.addRule(9, 2131361959);
    localLayoutParams.addRule(15, 2131361959);
    localLayoutParams.setMargins(i, 0, 0, 0);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramuvv.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject2);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131361962);
    ((TextView)localObject2).setGravity(16);
    ((TextView)localObject2).setIncludeFontPadding(false);
    ((TextView)localObject2).setMaxLines(2);
    ((TextView)localObject2).setTextSize(1, 14.0F);
    ((TextView)localObject2).setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131494227));
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(1, 2131361960);
    localLayoutParams.addRule(11, 2131361959);
    localLayoutParams.addRule(10, 2131361959);
    localLayoutParams.setMargins(i, 0, 0, 0);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramuvv.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject2);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131361963);
    ((TextView)localObject2).setSingleLine();
    if (VersionUtils.e()) {
      ((TextView)localObject2).setAlpha(0.75F);
    }
    ((TextView)localObject2).setGravity(17);
    ((TextView)localObject2).setTextColor(Color.parseColor("#777777"));
    ((TextView)localObject2).setTextSize(1, 12.0F);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(5, 2131361962);
    localLayoutParams.addRule(6, 2131361964);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramuvv.b = ((TextView)localObject2);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131361964);
    ((TextView)localObject2).setGravity(5);
    ((TextView)localObject2).setTextColor(Color.parseColor("#777777"));
    ((TextView)localObject2).setTextSize(1, 12.0F);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(11, 2131361959);
    localLayoutParams.addRule(12, 2131361959);
    localLayoutParams.addRule(1, 2131361963);
    localLayoutParams.leftMargin = i;
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramuvv.c = ((TextView)localObject2);
    return localRelativeLayout;
  }
  
  private void a(BaseChatItemLayout paramBaseChatItemLayout, MessageForDeviceFile paramMessageForDeviceFile, uvv paramuvv)
  {
    paramuvv.jdField_a_of_type_AndroidWidgetTextView.setText(FileManagerUtil.d(paramMessageForDeviceFile.srcFileName));
    paramuvv.b.setText(FileUtil.a(paramMessageForDeviceFile.fileSize));
    FileManagerUtil.a(paramuvv.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, paramMessageForDeviceFile.filePath, FileManagerUtil.a(paramMessageForDeviceFile.filePath));
    paramuvv.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    if ((paramMessageForDeviceFile.strServiceName != null) && (paramMessageForDeviceFile.strServiceName.compareTo(DeviceMsgHandle.c) == 0)) {
      this.c = true;
    }
    b(paramuvv, paramMessageForDeviceFile);
    a(paramuvv, paramMessageForDeviceFile);
    paramBaseChatItemLayout.setFailedIconVisable(a(paramMessageForDeviceFile), this);
  }
  
  private void a(uvv paramuvv, MessageForDeviceFile paramMessageForDeviceFile)
  {
    if (paramMessageForDeviceFile == null) {
      paramuvv.c.setVisibility(8);
    }
    label193:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                do
                                {
                                  do
                                  {
                                    do
                                    {
                                      do
                                      {
                                        return;
                                        if ((this.c) && (paramMessageForDeviceFile.issend == 0)) {
                                          paramuvv.c.setMaxLines(3);
                                        }
                                        for (;;)
                                        {
                                          switch (paramMessageForDeviceFile.nFileStatus)
                                          {
                                          case 0: 
                                          case 11: 
                                          default: 
                                            return;
                                          case -1: 
                                            if (!paramMessageForDeviceFile.isSend()) {
                                              break label193;
                                            }
                                            paramuvv.c.setVisibility(8);
                                            return;
                                            paramuvv.c.setMaxLines(2);
                                          }
                                        }
                                        paramuvv.c.setVisibility(0);
                                        paramuvv.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131428254));
                                        return;
                                        if (this.c)
                                        {
                                          paramuvv.c.setVisibility(0);
                                          if (paramMessageForDeviceFile.isSend())
                                          {
                                            paramuvv.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131434566));
                                            return;
                                          }
                                          paramuvv.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131437832));
                                          return;
                                        }
                                        paramuvv.c.setVisibility(4);
                                        return;
                                        if (paramMessageForDeviceFile.isSend())
                                        {
                                          paramuvv.c.setVisibility(4);
                                          return;
                                        }
                                        paramuvv.c.setVisibility(0);
                                        paramuvv.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131427589));
                                        return;
                                        paramuvv.c.setVisibility(0);
                                        if (paramMessageForDeviceFile.isSend())
                                        {
                                          paramuvv.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131428257));
                                          return;
                                        }
                                        if (this.c)
                                        {
                                          paramuvv.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131437835));
                                          return;
                                        }
                                        paramuvv.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131428258));
                                        return;
                                        paramuvv.c.setVisibility(0);
                                        if (paramMessageForDeviceFile.isSend())
                                        {
                                          if (this.c)
                                          {
                                            paramuvv.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131437833));
                                            return;
                                          }
                                          paramuvv.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131428253));
                                          return;
                                        }
                                        if (this.c)
                                        {
                                          paramuvv.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131437836));
                                          return;
                                        }
                                        paramuvv.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131428251));
                                        return;
                                        paramuvv.c.setVisibility(0);
                                      } while ((paramMessageForDeviceFile.isSend()) || (!this.c));
                                      paramuvv.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131437840));
                                      return;
                                      paramuvv.c.setVisibility(0);
                                    } while ((paramMessageForDeviceFile.isSend()) || (!this.c));
                                    paramuvv.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131437841));
                                    return;
                                    paramuvv.c.setVisibility(0);
                                  } while ((paramMessageForDeviceFile.isSend()) || (!this.c));
                                  paramuvv.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131437843));
                                  return;
                                  paramuvv.c.setVisibility(0);
                                } while ((paramMessageForDeviceFile.isSend()) || (!this.c));
                                paramuvv.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131437838));
                                return;
                                paramuvv.c.setVisibility(0);
                              } while ((paramMessageForDeviceFile.isSend()) || (!this.c));
                              paramuvv.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131437837) + "（错误01）");
                              return;
                              paramuvv.c.setVisibility(0);
                            } while ((paramMessageForDeviceFile.isSend()) || (!this.c));
                            paramuvv.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131437837) + "（错误02）");
                            return;
                            paramuvv.c.setVisibility(0);
                          } while ((paramMessageForDeviceFile.isSend()) || (!this.c));
                          paramuvv.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131437837) + "（错误03）");
                          return;
                          paramuvv.c.setVisibility(0);
                        } while ((paramMessageForDeviceFile.isSend()) || (!this.c));
                        paramuvv.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131437837) + "（错误04）");
                        return;
                        paramuvv.c.setVisibility(0);
                      } while ((paramMessageForDeviceFile.isSend()) || (!this.c));
                      paramuvv.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131437837) + "（错误05）");
                      return;
                      paramuvv.c.setVisibility(0);
                    } while ((paramMessageForDeviceFile.isSend()) || (!this.c));
                    paramuvv.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131437837) + "（错误06）");
                    return;
                    paramuvv.c.setVisibility(0);
                  } while ((paramMessageForDeviceFile.isSend()) || (!this.c));
                  paramuvv.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131437837) + "（错误07）");
                  return;
                  paramuvv.c.setVisibility(0);
                } while ((paramMessageForDeviceFile.isSend()) || (!this.c));
                paramuvv.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131437837) + "（错误08）");
                return;
                paramuvv.c.setVisibility(0);
              } while ((paramMessageForDeviceFile.isSend()) || (!this.c));
              paramuvv.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131437837) + "（错误09）");
              return;
              paramuvv.c.setVisibility(0);
            } while ((paramMessageForDeviceFile.isSend()) || (!this.c));
            paramuvv.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131437837) + "（错误10）");
            return;
            paramuvv.c.setVisibility(0);
          } while ((paramMessageForDeviceFile.isSend()) || (!this.c));
          paramuvv.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131437837) + "（错误11）");
          return;
          paramuvv.c.setVisibility(0);
        } while ((paramMessageForDeviceFile.isSend()) || (!this.c));
        paramuvv.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131437837) + this.jdField_a_of_type_AndroidContentContext.getString(2131437838));
        return;
        paramuvv.c.setVisibility(0);
      } while ((paramMessageForDeviceFile.isSend()) || (!this.c));
      paramuvv.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131437839));
      return;
      paramuvv.c.setVisibility(0);
    } while (!this.c);
    paramuvv.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131437834));
  }
  
  private boolean a(MessageForDeviceFile paramMessageForDeviceFile)
  {
    if (paramMessageForDeviceFile == null) {
      return false;
    }
    switch (paramMessageForDeviceFile.nFileStatus)
    {
    case 11: 
    default: 
      return false;
    }
    return true;
  }
  
  private void b(uvv paramuvv, MessageForDeviceFile paramMessageForDeviceFile)
  {
    if (paramMessageForDeviceFile != null) {}
    int i;
    switch (paramMessageForDeviceFile.nFileStatus)
    {
    default: 
      i = 0;
      if (i != 0)
      {
        if (paramuvv.jdField_a_of_type_AndroidWidgetProgressBar == null)
        {
          localProgressBar = new ProgressBar(this.jdField_a_of_type_AndroidContentContext, null, 16842872);
          localProgressBar.setId(2131361965);
          localProgressBar.setMax(100);
          localProgressBar.setMinimumHeight(AIOUtils.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          localProgressBar.setProgressDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837587));
          localLayoutParams = new RelativeLayout.LayoutParams(-1, AIOUtils.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          localLayoutParams.addRule(3, 2131361959);
          localLayoutParams.addRule(12, 2131361958);
          localLayoutParams.setMargins(0, AIOUtils.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
          paramuvv.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localProgressBar, localLayoutParams);
          paramuvv.jdField_a_of_type_AndroidWidgetProgressBar = localProgressBar;
        }
        paramuvv.jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(paramMessageForDeviceFile.progress * 100.0F));
        paramuvv.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      }
      break;
    }
    while (paramuvv.jdField_a_of_type_AndroidWidgetProgressBar == null)
    {
      ProgressBar localProgressBar;
      RelativeLayout.LayoutParams localLayoutParams;
      return;
      i = 1;
      break;
    }
    paramuvv.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
  }
  
  private void c(MessageForDeviceFile paramMessageForDeviceFile) {}
  
  private void d(View paramView)
  {
    Object localObject2 = (MessageForDeviceFile)AIOUtils.a(paramView);
    paramView = FileManagerUtil.a((MessageForDeviceFile)localObject2);
    Object localObject1 = new ForwardFileInfo();
    if ((this.c) && (paramView.nFileType != 0)) {
      ((ForwardFileInfo)localObject1).b(10000);
    }
    Intent localIntent;
    for (;;)
    {
      ((ForwardFileInfo)localObject1).d(8);
      ((ForwardFileInfo)localObject1).b(paramView.nSessionId);
      ((ForwardFileInfo)localObject1).d(paramView.fileName);
      ((ForwardFileInfo)localObject1).c(paramView.uniseq);
      ((ForwardFileInfo)localObject1).d(paramView.fileSize);
      ((ForwardFileInfo)localObject1).a(paramView.getFilePath());
      ((ForwardFileInfo)localObject1).b(paramView.Uuid);
      localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, FileBrowserActivity.class);
      localIntent.putExtra("fileinfo", (Parcelable)localObject1);
      localObject1 = new ArrayList();
      if ((paramView.nFileType != 0) && (paramView.nFileType != 1)) {
        break;
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageForDeviceFile)localObject2).frienduin, ((MessageForDeviceFile)localObject2).istroop);
      if ((localObject2 == null) || (((List)localObject2).size() == 0)) {
        break;
      }
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (ChatMessage)((Iterator)localObject2).next();
        if (((ChatMessage)localObject3).msgtype == -4500)
        {
          localObject3 = (MessageForDeviceFile)localObject3;
          if (FileManagerUtil.a(((MessageForDeviceFile)localObject3).filePath) == paramView.nFileType) {
            ((ArrayList)localObject1).add(String.valueOf(FileManagerUtil.a((MessageForDeviceFile)localObject3).nSessionId));
          }
        }
      }
      ((ForwardFileInfo)localObject1).b(10009);
    }
    localIntent.putStringArrayListExtra("Aio_SessionId_ImageList", (ArrayList)localObject1);
    ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(localIntent, 102);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramChatMessage = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
    ((uvv)paramChatMessage.getTag()).jdField_a_of_type_AndroidViewView.getLayoutParams().width = BaseChatItemLayout.d;
    return paramChatMessage;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    uvv localuvv = (uvv)paramViewHolder;
    MessageForDeviceFile localMessageForDeviceFile = (MessageForDeviceFile)paramChatMessage;
    paramChatMessage = paramView;
    if (paramView == null) {
      paramChatMessage = a((uvv)paramViewHolder);
    }
    c(localMessageForDeviceFile);
    a(paramBaseChatItemLayout, localMessageForDeviceFile, localuvv);
    paramChatMessage.setOnLongClickListener(paramOnLongClickAndTouchListener);
    paramChatMessage.setOnTouchListener(paramOnLongClickAndTouchListener);
    paramChatMessage.setOnClickListener(this);
    localuvv.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(paramChatMessage, this);
    return paramChatMessage;
  }
  
  public BaseBubbleBuilder.TouchDelegate a(View paramView)
  {
    return this;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new uvv(this);
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    return "发送了文件";
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForDeviceFile)))
    {
      paramContext = (MessageForDeviceFile)paramChatMessage;
      if (paramInt != 2131375567) {
        break label36;
      }
      ChatActivityFacade.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    }
    label36:
    do
    {
      return;
      if (paramInt == 2131375577)
      {
        super.c(paramChatMessage);
        return;
      }
    } while (paramInt != 2131363517);
    paramChatMessage = new Bundle();
    paramChatMessage.putInt("forward_type", 0);
    paramChatMessage.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    Intent localIntent = new Intent();
    localIntent.putExtra("forward_filepath", paramContext.filePath);
    localIntent.putExtra("BUSI_TYPE", 1009);
    localIntent.putExtra("forward_download_image_org_uin", paramContext.frienduin);
    localIntent.putExtra("forward_download_image_org_uin_type", paramContext.istroop);
    localIntent.putExtra("forward_photo_isSend", paramContext.issend);
    localIntent.putExtras(paramChatMessage);
    ForwardBaseOption.a((Activity)this.jdField_a_of_type_AndroidContentContext, localIntent, 21);
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    if (AIOUtils.a(paramView).isMultiMsg) {}
    do
    {
      return;
      paramView = (MessageForDeviceFile)((uvv)AIOUtils.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (paramView.isSendFromLocal())
      {
        localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
        localActionSheet.a(2131433635, 5);
        localActionSheet.c(2131433015);
        localActionSheet.a(new uvt(this, paramView, localActionSheet));
        localActionSheet.show();
        return;
      }
    } while (this.c);
    ActionSheet localActionSheet = ActionSheet.a(this.jdField_a_of_type_AndroidContentContext);
    localActionSheet.a(2131427799);
    localActionSheet.b(2131427800);
    localActionSheet.c(2131433015);
    localActionSheet.a(new uvu(this, paramView, localActionSheet));
    localActionSheet.show();
  }
  
  public void a(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = (uvv)AIOUtils.a(paramView);
    if (paramView == null) {}
    do
    {
      return;
      paramView = paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.getBackground();
    } while (paramView == null);
    switch (paramMotionEvent.getAction())
    {
    case 2: 
    default: 
      return;
    case 0: 
      paramView.setColorFilter(BaseBubbleBuilder.jdField_a_of_type_AndroidGraphicsColorFilter);
      paramView.invalidateSelf();
      return;
    }
    paramView.setColorFilter(null);
    paramView.invalidateSelf();
  }
  
  public void a(View paramView, MessageForDeviceFile paramMessageForDeviceFile)
  {
    paramView = (uvv)AIOUtils.a(paramView);
    if (paramView == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "error get holder in updateview");
      }
    }
    MessageForDeviceFile localMessageForDeviceFile;
    do
    {
      return;
      localMessageForDeviceFile = (MessageForDeviceFile)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    } while (localMessageForDeviceFile.uniseq != paramMessageForDeviceFile.uniseq);
    localMessageForDeviceFile.msgStatus = paramMessageForDeviceFile.msgStatus;
    localMessageForDeviceFile.nFileStatus = paramMessageForDeviceFile.nFileStatus;
    localMessageForDeviceFile.progress = paramMessageForDeviceFile.progress;
    localMessageForDeviceFile.msg = paramMessageForDeviceFile.msg;
    a(paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, localMessageForDeviceFile, paramView);
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    paramView = (uvv)AIOUtils.a(paramView);
    if (paramView == null) {}
    Drawable localDrawable;
    do
    {
      return;
      localDrawable = paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.getBackground();
    } while (localDrawable == null);
    if (paramBoolean) {}
    for (paramView = null;; paramView = jdField_a_of_type_AndroidGraphicsColorFilter)
    {
      localDrawable.setColorFilter(paramView);
      localDrawable.invalidateSelf();
      return;
    }
  }
  
  public void a(MessageForDeviceFile paramMessageForDeviceFile)
  {
    if (!NetworkUtil.d(this.jdField_a_of_type_AndroidContentContext))
    {
      FMToastUtil.a(2131428327);
      return;
    }
    if (FileUtils.b(paramMessageForDeviceFile.filePath)) {
      ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(paramMessageForDeviceFile.strServiceName, paramMessageForDeviceFile);
    }
    super.b();
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    if (!TextUtils.isEmpty(((MessageForDeviceFile)((uvv)AIOUtils.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage).filePath)) {
      localQQCustomMenu.a(2131363517, this.jdField_a_of_type_AndroidContentContext.getString(2131435083), 2130838313);
    }
    super.b(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext);
    return localQQCustomMenu.a();
  }
  
  public void b(MessageForDeviceFile paramMessageForDeviceFile)
  {
    if (!NetworkUtil.d(this.jdField_a_of_type_AndroidContentContext))
    {
      FMToastUtil.a(2131428327);
      return;
    }
    ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(paramMessageForDeviceFile);
  }
  
  public void onClick(View paramView)
  {
    AIOUtils.m = true;
    if (super.a()) {}
    MessageForDeviceFile localMessageForDeviceFile;
    do
    {
      return;
      localMessageForDeviceFile = (MessageForDeviceFile)AIOUtils.a(paramView);
    } while ((paramView.getId() == 2131361863) && (localMessageForDeviceFile != null) && (localMessageForDeviceFile.uint32_src_uin_type == 1));
    super.onClick(paramView);
    switch (paramView.getId())
    {
    case 2131361862: 
    case 2131361886: 
    default: 
      return;
    }
    d(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.DeviceFileItemBuilder
 * JD-Core Version:    0.7.0.1
 */