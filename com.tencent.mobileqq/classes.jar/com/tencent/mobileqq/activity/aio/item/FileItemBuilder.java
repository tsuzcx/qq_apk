package com.tencent.mobileqq.activity.aio.item;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qrcode.CustomAccessibilityDelegate;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.TransFileInfo;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.TroopFileDetailBrowserActivity;
import com.tencent.mobileqq.filemanager.recreate.FileModel;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardFileOption;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.TestStructMsg;
import com.tencent.mobileqq.teamwork.TeamWorkConvertUtils;
import com.tencent.mobileqq.teamwork.TeamWorkUtils;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qqfav.QfavBuilder;
import java.io.File;
import vbi;
import vbj;
import vbk;
import vbl;
import vbm;
import vbo;
import vbp;
import vbq;
import vbr;
import vbs;

public class FileItemBuilder
  extends BaseBubbleBuilder
{
  FileManagerEntity a;
  public Handler b = new Handler();
  private boolean c;
  private boolean d = true;
  private boolean e;
  
  public FileItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = null;
  }
  
  private int a(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong4, paramString1, paramInt, -1L);
    if (i != -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("chaosli", 2, "getFileTransStatus processor.getFileStatus() " + i);
      }
      return i;
    }
    paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong4, paramString1, paramInt);
    if (paramString2 != null)
    {
      if ((paramString2.cloudType == 1) && (FileManagerUtil.a(paramString2))) {
        paramString2.status = 16;
      }
      return paramString2.status;
    }
    paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    paramString1 = (TransFileInfo)paramString2.a(TransFileInfo.class, new String[] { String.valueOf(paramLong3), String.valueOf(paramLong2), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString1 });
    paramString2.a();
    if (paramString1 == null) {
      return 0;
    }
    paramString1.status = FileManagerUtil.b(paramString1.status);
    if (paramString1.status == 2) {
      paramString1.status = 0;
    }
    return paramString1.status;
  }
  
  private long a(long paramLong1, long paramLong2, String paramString1, String paramString2)
  {
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    paramString2 = (TransFileInfo)paramString1.a(TransFileInfo.class, new String[] { String.valueOf(paramLong2), String.valueOf(paramLong1), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString2 });
    paramString1.a();
    if (paramString2 != null) {
      return paramString2.transferedSize;
    }
    return 0L;
  }
  
  @SuppressLint({"ResourceAsColor"})
  @TargetApi(11)
  private RelativeLayout a(vbs paramvbs)
  {
    int i = AIOUtils.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int j = AIOUtils.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int k = AIOUtils.a(90.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    localRelativeLayout.setId(2131361877);
    Object localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources();
    localRelativeLayout.setPadding(((Resources)localObject1).getDimensionPixelSize(2131558601), ((Resources)localObject1).getDimensionPixelSize(2131558599), ((Resources)localObject1).getDimensionPixelSize(2131558602), ((Resources)localObject1).getDimensionPixelSize(2131558600));
    localRelativeLayout.setBackgroundResource(2130837588);
    Object localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    int m = ((Resources)localObject1).getDimensionPixelSize(2131558652);
    ((RelativeLayout.LayoutParams)localObject2).setMargins(m, 0, m, 0);
    ((RelativeLayout.LayoutParams)localObject2).addRule(1, 2131362724);
    localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    ((RelativeLayout)localObject1).setId(2131361959);
    localObject2 = new RelativeLayout.LayoutParams(-1, k);
    ((RelativeLayout)localObject1).setPadding(i, i, i, i);
    ((RelativeLayout.LayoutParams)localObject2).addRule(10, 2131361877);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new AsyncImageView(this.jdField_a_of_type_AndroidContentContext, j, j);
    ((AsyncImageView)localObject2).setId(2131361960);
    ((AsyncImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
    Object localObject3 = new RelativeLayout.LayoutParams(j, j);
    ((RelativeLayout.LayoutParams)localObject3).addRule(9, 2131361959);
    ((RelativeLayout.LayoutParams)localObject3).addRule(15, 2131361959);
    ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    paramvbs.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)localObject2);
    localObject2 = new EllipsizingTextView(this.jdField_a_of_type_AndroidContentContext, null);
    ((TextView)localObject2).setId(2131361962);
    ((TextView)localObject2).setGravity(48);
    ((TextView)localObject2).setIncludeFontPadding(false);
    ((TextView)localObject2).setLineSpacing(0.0F, 1.0F);
    ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.MIDDLE);
    ((TextView)localObject2).setTextSize(1, 14.0F);
    ((TextView)localObject2).setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131494233));
    localObject3 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(1, 2131361960);
    ((RelativeLayout.LayoutParams)localObject3).addRule(11, 2131361959);
    ((RelativeLayout.LayoutParams)localObject3).addRule(10, 2131361959);
    ((RelativeLayout.LayoutParams)localObject3).setMargins(i, 0, 0, 0);
    ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    paramvbs.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject2);
    localObject3 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject3).setId(2131361964);
    ((TextView)localObject3).setSingleLine();
    ((TextView)localObject3).setGravity(5);
    ((TextView)localObject3).setTextColor(Color.parseColor("#777777"));
    ((TextView)localObject3).setTextSize(1, 12.0F);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(11, 2131361959);
    localLayoutParams.addRule(12, 2131361959);
    ((RelativeLayout)localObject1).addView((View)localObject3, localLayoutParams);
    paramvbs.c = ((TextView)localObject3);
    localObject3 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject3).setId(2131361963);
    ((TextView)localObject3).setSingleLine();
    if (VersionUtils.e()) {
      ((TextView)localObject3).setAlpha(0.75F);
    }
    ((TextView)localObject3).setGravity(17);
    ((TextView)localObject3).setTextColor(Color.parseColor("#777777"));
    ((TextView)localObject3).setTextSize(1, 12.0F);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    DisplayMetrics localDisplayMetrics = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics();
    if ((FontSettingManager.a() > 17.0F) || (localDisplayMetrics.widthPixels <= 500))
    {
      localLayoutParams.addRule(11, 2131361959);
      localLayoutParams.addRule(2, 2131361964);
      ((TextView)localObject2).setMaxLines(2);
    }
    for (this.c = true;; this.c = false)
    {
      ((RelativeLayout)localObject1).addView((View)localObject3, localLayoutParams);
      paramvbs.b = ((TextView)localObject3);
      return localRelativeLayout;
      localLayoutParams.addRule(5, 2131361962);
      localLayoutParams.addRule(12, 2131361959);
      ((TextView)localObject2).setMaxLines(3);
    }
  }
  
  private String a(long paramLong1, long paramLong2, String paramString)
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    paramString = (TransFileInfo)localEntityManager.a(TransFileInfo.class, new String[] { String.valueOf(paramLong2), String.valueOf(paramLong1), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString });
    localEntityManager.a();
    if (paramString != null) {
      return paramString.fileName;
    }
    return "";
  }
  
  private String a(long paramLong1, long paramLong2, String paramString1, String paramString2)
  {
    int i;
    if ((paramString1 == null) && (paramString2 != null))
    {
      paramString2 = a(paramLong1, paramLong2, paramString2);
      if (paramString2 != null)
      {
        i = paramString2.lastIndexOf(".");
        if (i >= 0) {}
      }
    }
    do
    {
      return paramString2;
      return paramString2.substring(0, i);
      if (paramString1 == null) {
        return null;
      }
      i = paramString1.lastIndexOf(File.separator);
      paramString2 = paramString1;
    } while (i < 0);
    String str = "";
    paramString2 = str;
    if (i > 0)
    {
      paramString2 = str;
      if (i + 1 < paramString1.length()) {
        paramString2 = paramString1.substring(i + 1);
      }
    }
    return paramString2;
  }
  
  private String a(String paramString)
  {
    int i = paramString.lastIndexOf(File.separator);
    int j = paramString.lastIndexOf(".");
    String str2 = "";
    String str1 = str2;
    if (i > 0)
    {
      str1 = str2;
      if (j > 0)
      {
        str1 = str2;
        if (j > i)
        {
          str1 = str2;
          if (j + 1 < paramString.length()) {
            str1 = paramString.substring(j + 1);
          }
        }
      }
    }
    return str1;
  }
  
  private void a(MessageForFile paramMessageForFile)
  {
    long l2 = 0L;
    for (;;)
    {
      try
      {
        if ((paramMessageForFile.tempMsg == null) || (paramMessageForFile.tempMsg.length <= 0)) {
          continue;
        }
        localObject1 = paramMessageForFile.tempMsg[0].substring(1);
        paramMessageForFile.url = ((String)localObject1);
        if (paramMessageForFile.url.length() == 0)
        {
          paramMessageForFile.url = a(paramMessageForFile.msgseq, paramMessageForFile.time, paramMessageForFile.frienduin);
          if ((paramMessageForFile.tempMsg != null) && (paramMessageForFile.tempMsg.length > 1)) {
            paramMessageForFile.tempMsg[1] = String.valueOf(a(paramMessageForFile.msgseq, paramMessageForFile.time, "", paramMessageForFile.frienduin));
          }
        }
        paramMessageForFile.fileName = a(paramMessageForFile.msgseq, paramMessageForFile.time, paramMessageForFile.url, paramMessageForFile.frienduin);
        paramMessageForFile.fileType = a(paramMessageForFile.url);
        if ((paramMessageForFile.tempMsg == null) || (paramMessageForFile.tempMsg.length <= 1) || (paramMessageForFile.tempMsg[1] == null) || (Long.valueOf(paramMessageForFile.tempMsg[1]).longValue() <= 0L)) {
          continue;
        }
        paramMessageForFile.fileSize = Long.valueOf(paramMessageForFile.tempMsg[1]).longValue();
      }
      catch (Exception localException)
      {
        Object localObject1;
        QLog.e("FileItemBuilder<FileAssistant>", 1, localException.toString());
        continue;
        long l1 = 0L;
        continue;
        if (paramMessageForFile.tempMsg == null) {
          continue;
        }
        if (paramMessageForFile.tempMsg.length <= 1) {
          continue;
        }
        l1 = Long.valueOf(paramMessageForFile.tempMsg[1]).longValue();
        paramMessageForFile.fileSize = l1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FileItemBuilder<FileAssistant>", 2, "--------->>bindView 2 filePath:" + paramMessageForFile.url + "fileMsgLength:" + paramMessageForFile.tempMsg.length + ", fileSize:" + paramMessageForFile.fileSize);
        continue;
        l1 = 0L;
        continue;
        Object localObject2 = null;
        continue;
      }
      paramMessageForFile.fileSizeString = FileUtil.a(paramMessageForFile.fileSize);
      if (paramMessageForFile.tempMsg != null)
      {
        if (paramMessageForFile.tempMsg.length <= 4) {
          continue;
        }
        localObject1 = paramMessageForFile.tempMsg[4];
        paramMessageForFile.urlAtServer = ((String)localObject1);
      }
      paramMessageForFile.status = a(paramMessageForFile.frienduin, paramMessageForFile.url, paramMessageForFile.isSendFromLocal(), paramMessageForFile.fileSize, paramMessageForFile.msgseq, paramMessageForFile.time, paramMessageForFile.uniseq, paramMessageForFile.istroop);
      return;
      localObject1 = "";
      continue;
      if (!paramMessageForFile.isSendFromLocal()) {
        continue;
      }
      localObject1 = new File(paramMessageForFile.url);
      if (!((File)localObject1).exists()) {
        continue;
      }
      l1 = ((File)localObject1).length();
      paramMessageForFile.fileSize = l1;
      if (QLog.isColorLevel()) {
        QLog.d("FileItemBuilder<FileAssistant>", 2, "--------->>bindView 1 filePath:" + paramMessageForFile.url + ",fileExists:" + ((File)localObject1).exists() + ", fileSize:" + ((File)localObject1).length());
      }
      if ((paramMessageForFile.fileSize == 0L) && (paramMessageForFile.tempMsg != null))
      {
        l1 = l2;
        if (paramMessageForFile.tempMsg.length > 1) {
          l1 = Long.valueOf(paramMessageForFile.tempMsg[1]).longValue();
        }
        paramMessageForFile.fileSize = l1;
      }
    }
  }
  
  private void a(vbs paramvbs, MessageForFile paramMessageForFile, FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {
      paramvbs.c.setVisibility(8);
    }
    String str;
    do
    {
      return;
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131428143);
      switch (paramFileManagerEntity.status)
      {
      case 2: 
      case 14: 
      case 15: 
      default: 
        paramvbs.c.setVisibility(4);
        return;
      case 0: 
        paramvbs.c.setVisibility(0);
        if (paramMessageForFile.isSend())
        {
          if ((paramFileManagerEntity.nOpType == 8) || (paramFileManagerEntity.nOpType == 1) || (paramFileManagerEntity.nOpType == 5))
          {
            paramvbs.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131428253));
            return;
          }
          paramvbs.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131428257));
          return;
        }
        paramvbs.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131428258));
        return;
      case 16: 
        paramvbs.c.setVisibility(0);
        paramvbs.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131428255));
        return;
      case -1: 
        paramvbs.c.setVisibility(0);
        if (paramMessageForFile.isSend())
        {
          paramvbs.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131428253));
          return;
        }
        paramvbs.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131428254));
        return;
      case 1: 
        paramvbs.c.setVisibility(0);
        if (paramMessageForFile.isSend()) {
          paramvbs.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131428253));
        }
        while ((AppSetting.b) && (paramvbs.e >= 0))
        {
          QQAppInterface.f("进度,百分之百");
          paramvbs.e = -1;
          return;
          if (paramFileManagerEntity.getCloudType() == 0) {
            paramvbs.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131428266));
          } else {
            paramvbs.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131428251));
          }
        }
      case 3: 
        paramvbs.c.setVisibility(0);
        if (!paramMessageForFile.isSend()) {
          break label674;
        }
        if ((paramFileManagerEntity.nOpType == 8) || (paramFileManagerEntity.nOpType == 5))
        {
          paramvbs.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131428253));
          return;
        }
        break;
      }
    } while (3 != paramFileManagerEntity.getCloudType());
    paramvbs.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131428252));
    return;
    label674:
    paramvbs.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131428252));
    return;
    paramvbs.c.setVisibility(0);
    paramvbs.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131428254));
    return;
    paramvbs.c.setVisibility(0);
    paramvbs.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131428255));
    return;
    paramvbs.c.setVisibility(0);
    paramvbs.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131428254));
    return;
    paramvbs.c.setVisibility(0);
    paramvbs.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131428255));
    return;
    paramvbs.c.setVisibility(0);
    paramvbs.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131428255));
    return;
    paramvbs.c.setVisibility(0);
    paramvbs.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131428254));
  }
  
  private void a(vbs paramvbs, FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity != null) {}
    int i;
    switch (paramFileManagerEntity.status)
    {
    default: 
      i = 0;
      label46:
      if (i != 0)
      {
        if (paramvbs.jdField_a_of_type_AndroidWidgetProgressBar == null)
        {
          localObject = new ProgressBar(this.jdField_a_of_type_AndroidContentContext, null, 16842872);
          ((ProgressBar)localObject).setPadding(AIOUtils.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          ((ProgressBar)localObject).setId(2131361965);
          ((ProgressBar)localObject).setMax(100);
          ((ProgressBar)localObject).setMinimumHeight(AIOUtils.a(11.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          ((ProgressBar)localObject).setProgressDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837586));
          localLayoutParams = new RelativeLayout.LayoutParams(-1, AIOUtils.a(11.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          localLayoutParams.addRule(3, 2131361959);
          localLayoutParams.addRule(12, 2131361877);
          ((RelativeLayout)paramvbs.jdField_a_of_type_AndroidViewView).addView((View)localObject, localLayoutParams);
          paramvbs.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localObject);
          if (AppSetting.b)
          {
            localObject = new CustomAccessibilityDelegate(paramvbs.jdField_a_of_type_AndroidViewView, new vbr(this, paramvbs));
            paramvbs.jdField_a_of_type_AndroidViewView.setAccessibilityDelegate((View.AccessibilityDelegate)localObject);
          }
        }
        i = (int)(paramFileManagerEntity.fProgress * 100.0F);
        paramvbs.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(i);
        paramvbs.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        if ((paramvbs.e >= 0) && (i - paramvbs.e > 1))
        {
          paramvbs.e = i;
          QQAppInterface.f("进度,百分之" + i);
        }
        paramvbs.jdField_a_of_type_AndroidWidgetProgressBar.setContentDescription("进度,百分之" + i);
      }
      break;
    }
    while (paramvbs.jdField_a_of_type_AndroidWidgetProgressBar == null)
    {
      Object localObject;
      RelativeLayout.LayoutParams localLayoutParams;
      return;
      i = 1;
      break label46;
      if (9 != paramFileManagerEntity.nOpType) {
        break;
      }
      i = 1;
      break label46;
    }
    paramvbs.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
  }
  
  private boolean b(FileManagerEntity paramFileManagerEntity)
  {
    boolean bool = true;
    if (paramFileManagerEntity == null) {
      return false;
    }
    switch (paramFileManagerEntity.status)
    {
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 9: 
    case 12: 
    case 13: 
    case 15: 
    default: 
      bool = false;
    }
    for (;;)
    {
      return bool;
      if ((paramFileManagerEntity.status != 0) || (paramFileManagerEntity.isSend() != true) || (paramFileManagerEntity.bOnceSuccess)) {
        break;
      }
      continue;
      if (13 != paramFileManagerEntity.nOpType) {
        break;
      }
      bool = false;
      continue;
      if (10 == paramFileManagerEntity.nOpType)
      {
        bool = false;
      }
      else
      {
        bool = false;
        continue;
        if (13 != paramFileManagerEntity.nOpType) {
          break;
        }
        bool = false;
        continue;
        if ((!paramFileManagerEntity.isSend()) || (paramFileManagerEntity.bOnceSuccess)) {
          break;
        }
      }
    }
  }
  
  private void d(View paramView)
  {
    paramView = (MessageForFile)AIOUtils.a(paramView);
    if (QLog.isColorLevel()) {
      QLog.d("FileItemBuilder<FileAssistant>", 2, "TransfileUtile.TYPE_FILE uniseq " + paramView.uniseq + " itemStatus" + paramView.status);
    }
    Object localObject = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
    if (!QFileUtils.a((FileManagerEntity)localObject))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FileItemBuilder<FileAssistant>", 1, "onItemClick: file is forwarding or forward failed, can not open file browser.");
      }
      return;
    }
    paramView = new FileManagerReporter.fileAssistantReportData();
    paramView.b = "file_viewer_in";
    paramView.jdField_a_of_type_Int = 9;
    paramView.c = FileUtil.a(((FileManagerEntity)localObject).fileName);
    paramView.d = FileManagerUtil.a(((FileManagerEntity)localObject).getCloudType(), ((FileManagerEntity)localObject).peerType);
    FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramView);
    FileManagerReporter.a("0X8004AE3");
    if ((((FileManagerEntity)localObject).TroopUin != 0L) && (!TextUtils.isEmpty(((FileManagerEntity)localObject).strTroopFileID)) && (!TextUtils.isEmpty(((FileManagerEntity)localObject).strTroopFilePath)))
    {
      paramView = new ForwardFileInfo();
      paramView.b(((FileManagerEntity)localObject).nSessionId);
      paramView.d(4);
      paramView.b(10006);
      paramView.a(((FileManagerEntity)localObject).getFilePath());
      paramView.d(((FileManagerEntity)localObject).fileName);
      paramView.d(((FileManagerEntity)localObject).fileSize);
      paramView.a(((FileManagerEntity)localObject).TroopUin);
      localObject = (Activity)this.jdField_a_of_type_AndroidContentContext;
      Intent localIntent = new Intent((Context)localObject, TroopFileDetailBrowserActivity.class);
      localIntent.putExtra("fileinfo", paramView);
      localIntent.putExtra("removemementity", true);
      localIntent.putExtra("forward_from_troop_file", true);
      localIntent.putExtra("not_forward", true);
      ((Activity)localObject).startActivityForResult(localIntent, 102);
      return;
    }
    FileModel.a((FileManagerEntity)localObject).a((Activity)this.jdField_a_of_type_AndroidContentContext);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramChatMessage = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
    ((vbs)paramChatMessage.getTag()).jdField_a_of_type_AndroidViewView.getLayoutParams().width = BaseChatItemLayout.d;
    return paramChatMessage;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    vbs localvbs = (vbs)paramViewHolder;
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramViewHolder = a(localvbs);
      localvbs.jdField_a_of_type_AndroidViewView = paramViewHolder;
    }
    paramChatMessage = (MessageForFile)paramChatMessage;
    a(paramChatMessage);
    a(paramBaseChatItemLayout, paramChatMessage, localvbs, paramChatMessage.status);
    paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
    paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
    paramViewHolder.setOnClickListener(this);
    return paramViewHolder;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new vbs(this);
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    if (MsgUtils.a(paramChatMessage.issend)) {
      return "发出文件";
    }
    return "发来文件";
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    MessageForFile localMessageForFile = (MessageForFile)paramChatMessage;
    Object localObject = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForFile);
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = null;
      return;
      long l1 = MessageCache.a();
      long l2 = paramChatMessage.time;
      if ((paramChatMessage.msgtype == -2005) && (paramChatMessage.istroop == 3000) && (l1 - l2 > 604800L))
      {
        FMToastUtil.a("该文件发送超过7天，撤回失败。");
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80056B1", "0X80056B1", 0, 0, "6", "", "", "");
        return;
      }
      a(paramChatMessage);
      FileManagerReporter.a("0X8005E4B");
      continue;
      ChatActivityFacade.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((FileManagerEntity)localObject);
      continue;
      super.c(paramChatMessage);
      continue;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800644C", "0X800644C", 0, 0, "6", "", "", "");
      if (FileModel.a(localMessageForFile).a(false))
      {
        FMDialogUtil.a(paramContext, 2131428241, 2131428238, new vbi(this, localMessageForFile, paramContext));
      }
      else
      {
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForFile, paramContext);
        continue;
        paramContext = new FileManagerReporter.fileAssistantReportData();
        paramContext.b = "file_forward";
        paramContext.jdField_a_of_type_Int = 9;
        paramContext.jdField_a_of_type_Long = ((FileManagerEntity)localObject).fileSize;
        paramContext.c = FileUtil.a(((FileManagerEntity)localObject).fileName);
        paramContext.d = FileManagerUtil.a(((FileManagerEntity)localObject).getCloudType(), ((FileManagerEntity)localObject).peerType);
        FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramContext);
        paramContext = new Bundle();
        paramContext.putInt("forward_type", 0);
        paramContext.putBoolean("not_forward", true);
        paramContext.putParcelable("fileinfo", ForwardFileOption.a((FileManagerEntity)localObject, paramChatMessage));
        paramChatMessage = new Intent();
        paramChatMessage.putExtras(paramContext);
        paramChatMessage.putExtra("forward_text", "已选择" + FileManagerUtil.d(((FileManagerEntity)localObject).fileName) + "，大小" + FileUtil.a(((FileManagerEntity)localObject).fileSize) + "。");
        paramChatMessage.putExtra("direct_send_if_dataline_forward", true);
        paramChatMessage.putExtra("forward _key_nojump", true);
        paramChatMessage.putExtra("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        if (!NetworkUtil.d(BaseApplication.getContext())) {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131434629, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
        }
        for (;;)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "6", "", "", "");
          break;
          ForwardBaseOption.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramChatMessage, 21);
        }
        if (!NetworkUtil.d(BaseApplication.getContext()))
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131434629, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
        }
        else
        {
          FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForFile, paramContext);
          continue;
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800644D", "0X800644D", 0, 0, "6", "", "", "");
          FileManagerReporter.a("0X8005080");
          FileModel.a((FileManagerEntity)localObject).a(false, paramContext, new vbj(this, (FileManagerEntity)localObject));
          this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
          continue;
          FileManagerReporter.a("0X8005081");
          if (((FileManagerEntity)localObject).getCloudType() == 0)
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((FileManagerEntity)localObject).nSessionId);
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((FileManagerEntity)localObject).nSessionId);
            this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
            continue;
            FileManagerReporter.a("0X8005082");
            boolean bool = ((FileManagerEntity)localObject).isSend();
            FileModel.a((FileManagerEntity)localObject).a(bool, paramContext, new vbk(this, (FileManagerEntity)localObject));
            this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
            continue;
            new QfavBuilder(3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, (FileManagerEntity)localObject, paramChatMessage, false);
            continue;
            TeamWorkConvertUtils.a((FileManagerEntity)localObject, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009061", "0X8009061", 0, 0, "", "", "", "");
            continue;
            try
            {
              paramContext = TestStructMsg.a(TestStructMsg.a(((FileManagerEntity)localObject).strFilePath));
              if (paramContext == null) {
                continue;
              }
              localObject = new SessionInfo();
              ((SessionInfo)localObject).jdField_a_of_type_JavaLangString = paramChatMessage.frienduin;
              ((SessionInfo)localObject).jdField_a_of_type_Int = paramChatMessage.istroop;
              ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (SessionInfo)localObject, paramContext);
            }
            catch (Exception paramContext)
            {
              QQToast.a(this.jdField_a_of_type_AndroidContentContext, "请先下载。。。。。。", 1).a();
            }
            continue;
            ApolloUtil.a(((FileManagerEntity)localObject).fileName, ((FileManagerEntity)localObject).strFilePath, new vbl(this, (FileManagerEntity)localObject));
          }
        }
      }
    }
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    vbs localvbs = (vbs)AIOUtils.a(paramView);
    MessageForFile localMessageForFile = (MessageForFile)localvbs.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    BaseChatItemLayout localBaseChatItemLayout = localvbs.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
    paramView = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForFile);
    if (paramView.getCloudType() == 5)
    {
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramView);
      return;
    }
    this.jdField_a_of_type_AndroidContentContext.getString(2131433649);
    this.jdField_a_of_type_AndroidContentContext.getString(2131433650);
    String str;
    switch (paramView.nOpType)
    {
    case 6: 
    case 7: 
    default: 
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131428109);
    }
    for (paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131428107); localMessageForFile.isSendFromLocal(); paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131428108))
    {
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
      localActionSheet.c(str);
      localActionSheet.d(this.jdField_a_of_type_AndroidContentContext.getString(2131433029));
      localActionSheet.a(paramView);
      localActionSheet.a(new vbm(this, localMessageForFile, localActionSheet, localBaseChatItemLayout, localvbs));
      localActionSheet.show();
      return;
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131428110);
    }
    paramView = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
    paramView.c(this.jdField_a_of_type_AndroidContentContext.getString(2131428110));
    paramView.d(this.jdField_a_of_type_AndroidContentContext.getString(2131433029));
    paramView.a(this.jdField_a_of_type_AndroidContentContext.getString(2131428108));
    paramView.a(new vbo(this, localMessageForFile, paramView, localBaseChatItemLayout, localvbs));
    paramView.show();
  }
  
  public void a(BaseChatItemLayout paramBaseChatItemLayout, MessageForFile paramMessageForFile, vbs paramvbs, int paramInt)
  {
    int i = 2;
    FileManagerEntity localFileManagerEntity = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForFile);
    FileManagerUtil.b(localFileManagerEntity);
    paramMessageForFile.fileName = localFileManagerEntity.fileName;
    paramMessageForFile.fileSize = localFileManagerEntity.fileSize;
    paramMessageForFile.status = localFileManagerEntity.status;
    paramMessageForFile.urlAtServer = localFileManagerEntity.strServerPath;
    paramMessageForFile.url = localFileManagerEntity.getFilePath();
    paramMessageForFile.fileSizeString = FileUtil.a(localFileManagerEntity.fileSize);
    if ((localFileManagerEntity.getCloudType() == 3) || (localFileManagerEntity.getCloudType() == 5)) {
      if (paramvbs.jdField_a_of_type_AndroidWidgetTextView.getMeasuredWidth() == 0)
      {
        paramvbs.jdField_a_of_type_AndroidWidgetTextView.post(new vbp(this, paramvbs, localFileManagerEntity));
        if ((localFileManagerEntity == null) || (15 != localFileManagerEntity.status) || (9 != localFileManagerEntity.nOpType)) {
          break label348;
        }
        paramvbs.b.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131428221));
      }
    }
    for (;;)
    {
      if (5 != localFileManagerEntity.getCloudType()) {
        break label378;
      }
      return;
      TextView localTextView = paramvbs.jdField_a_of_type_AndroidWidgetTextView;
      String str = localFileManagerEntity.fileName;
      boolean bool = this.c;
      int j = paramvbs.jdField_a_of_type_AndroidWidgetTextView.getMeasuredWidth();
      TextPaint localTextPaint = paramvbs.jdField_a_of_type_AndroidWidgetTextView.getPaint();
      if (this.c) {}
      for (;;)
      {
        localTextView.setText(FileManagerUtil.a(str, bool, j, localTextPaint, i));
        break;
        i = 3;
      }
      if (paramvbs.jdField_a_of_type_AndroidWidgetTextView.getMeasuredWidth() == 0)
      {
        paramvbs.jdField_a_of_type_AndroidWidgetTextView.post(new vbq(this, paramvbs, localFileManagerEntity));
        break;
      }
      localTextView = paramvbs.jdField_a_of_type_AndroidWidgetTextView;
      str = localFileManagerEntity.strSrcName;
      bool = this.c;
      j = paramvbs.jdField_a_of_type_AndroidWidgetTextView.getMeasuredWidth();
      localTextPaint = paramvbs.jdField_a_of_type_AndroidWidgetTextView.getPaint();
      if (this.c) {}
      for (;;)
      {
        localTextView.setText(FileManagerUtil.a(str, bool, j, localTextPaint, i));
        break;
        i = 3;
      }
      label348:
      paramvbs.b.setText(FileUtil.a(paramMessageForFile.fileSize, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().densityDpi));
    }
    label378:
    a(paramvbs, localFileManagerEntity);
    a(paramvbs, paramMessageForFile, localFileManagerEntity);
    paramBaseChatItemLayout.setFailedIconVisable(b(localFileManagerEntity), this);
    paramMessageForFile.status = paramInt;
    if (localFileManagerEntity == null)
    {
      FileManagerUtil.a(paramvbs.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, paramMessageForFile.fileName);
      return;
    }
    FileManagerUtil.a(paramvbs.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileManagerEntity);
  }
  
  protected void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramViewHolder, paramInt1, paramInt2);
    if (paramChatMessage.isSend())
    {
      paramViewHolder.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130845870);
      return;
    }
    paramViewHolder.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130845706);
  }
  
  public boolean a(FileManagerEntity paramFileManagerEntity)
  {
    return (paramFileManagerEntity != null) && ((paramFileManagerEntity.nOpType == 24) || (paramFileManagerEntity.nOpType == 25)) && ((paramFileManagerEntity.status == 2) || (paramFileManagerEntity.status == 0));
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = (MessageForFile)AIOUtils.a(paramView);
    FileManagerEntity localFileManagerEntity = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    int j;
    int i;
    if (16 != localFileManagerEntity.status)
    {
      if ((localFileManagerEntity.nOpType == -1) && (localFileManagerEntity.status == -1)) {
        localQQCustomMenu.a(2131375657, this.jdField_a_of_type_AndroidContentContext.getString(2131428320), 2130838315);
      }
      if (((localFileManagerEntity.nOpType == 0) || (localFileManagerEntity.nOpType == 11)) && (localFileManagerEntity.getCloudType() == 1) && (localFileManagerEntity.status == 1)) {
        localQQCustomMenu.a(2131375657, this.jdField_a_of_type_AndroidContentContext.getString(2131428320), 2130838315);
      }
      if ((localFileManagerEntity.nOpType == 11) && (localFileManagerEntity.getCloudType() == 1) && (localFileManagerEntity.status == 13)) {
        localQQCustomMenu.a(2131375657, this.jdField_a_of_type_AndroidContentContext.getString(2131428320), 2130838315);
      }
      if (((localFileManagerEntity.nOpType == 7) || (localFileManagerEntity.nOpType == 28) || (localFileManagerEntity.nOpType == 21) || (localFileManagerEntity.nOpType == 22) || (localFileManagerEntity.nOpType == 3) || (localFileManagerEntity.nOpType == 24) || (localFileManagerEntity.nOpType == 25)) && ((localFileManagerEntity.status == 1) || (localFileManagerEntity.status == -1))) {
        localQQCustomMenu.a(2131375657, this.jdField_a_of_type_AndroidContentContext.getString(2131428320), 2130838315);
      }
      if (localFileManagerEntity.nOpType == 1) {}
      switch (localFileManagerEntity.status)
      {
      default: 
        a(paramView, localQQCustomMenu);
        if ((localFileManagerEntity.getCloudType() != 0) && (!a(localFileManagerEntity)))
        {
          if (!localFileManagerEntity.sendCloudUnsuccessful()) {
            localQQCustomMenu.a(2131375654, this.jdField_a_of_type_AndroidContentContext.getString(2131428121), 2130838318);
          }
          if (this.d)
          {
            this.e = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("tim_convert_teamwork_pre_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 4).getBoolean("tim_convert_teamwork_show_aio_menu", false);
            this.d = false;
          }
          if ((this.e) && (localFileManagerEntity != null) && (TeamWorkUtils.a(localFileManagerEntity.strFilePath, localFileManagerEntity.fileName)))
          {
            j = 0;
            if (localFileManagerEntity.status == 16) {
              break label812;
            }
            i = 1;
          }
        }
        break;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        localQQCustomMenu.a(2131375679, this.jdField_a_of_type_AndroidContentContext.getString(2131439163), 2130838327);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009060", "0X8009060", 0, 0, "", "", "", "");
      }
      if (AIOUtils.a(5) == 1) {
        localQQCustomMenu.a(2131366774, this.jdField_a_of_type_AndroidContentContext.getString(2131428123), 2130838317);
      }
      ApolloUtil.a(localQQCustomMenu, localFileManagerEntity.fileName);
      if (QLog.isColorLevel()) {
        QLog.i("msgrevoke", 2, "FileMenuitem entity.status:" + localFileManagerEntity.status);
      }
      if ((localFileManagerEntity.status == 1) || (localFileManagerEntity.status == -1) || ((localFileManagerEntity.status == 3) && (localFileManagerEntity.nOpType == 1))) {
        a(localQQCustomMenu, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView);
      }
      ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      super.b(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext);
      return localQQCustomMenu.a();
      localQQCustomMenu.a(2131375657, this.jdField_a_of_type_AndroidContentContext.getString(2131428320), 2130838315);
      break;
      localQQCustomMenu.a(2131375658, this.jdField_a_of_type_AndroidContentContext.getString(2131428318), 2130838320);
      break;
      localQQCustomMenu.a(2131375659, this.jdField_a_of_type_AndroidContentContext.getString(2131428176), 2130838322);
      break;
      label812:
      i = j;
      if (!TextUtils.isEmpty(localFileManagerEntity.strFilePath))
      {
        File localFile = new File(localFileManagerEntity.strFilePath);
        i = j;
        if (localFile != null)
        {
          i = j;
          if (localFile.exists()) {
            i = 1;
          }
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    AIOUtils.m = true;
    if (super.a()) {
      return;
    }
    super.onClick(paramView);
    switch (paramView.getId())
    {
    case 2131361862: 
    default: 
      return;
    }
    d(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.FileItemBuilder
 * JD-Core Version:    0.7.0.1
 */