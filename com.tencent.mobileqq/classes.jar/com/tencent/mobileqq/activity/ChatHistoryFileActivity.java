package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.MsgRevokeListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOFilePicData;
import com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryMsgRevokeMgr;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaInfo;
import com.tencent.mobileqq.activity.chathistory.SeparateForward;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.TencentDocData;
import com.tencent.mobileqq.emotionintegrate.EmotionPreviewData;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.recreate.FileModel;
import com.tencent.mobileqq.filemanager.recreate.IFModel;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.multimsg.save.FileSaveDialog;
import com.tencent.mobileqq.multimsg.save.FileSaveReq;
import com.tencent.mobileqq.multimsg.save.MultiRichMediaSaveManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.weiyun.api.IWeiyunResponseHandler;
import com.tencent.mobileqq.weiyun.api.IWeiyunSaveTipsHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.wifi.FreeWifiHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.weiyun.WeiyunAIOUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class ChatHistoryFileActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, View.OnClickListener, MsgRevokeListener
{
  private boolean A = false;
  private Dialog B;
  private QQCustomDialog C;
  private FMObserver D = null;
  LinearLayout a;
  FrameLayout b;
  boolean c = false;
  ChatHistoryViewBase d = null;
  RelativeLayout e;
  ImageView f;
  ImageView g;
  ImageView h;
  ImageView i;
  List<ChatMessage> j;
  List<FileManagerEntity> k;
  List<AIORichMediaInfo> l;
  List<TencentDocData> m;
  List<EmotionPreviewData> n;
  List<ChatMessage> o;
  String p;
  int q;
  String r;
  ChatHistoryImageView s;
  ChatHistoryStructMsgView t;
  ChatHistoryFileView u;
  ChatHistoryEmotionView v;
  protected final MqqHandler w = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
  QQCustomDialog x;
  private SeparateForward y;
  private int z;
  
  private ChatHistoryViewBase a(int paramInt)
  {
    this.z = paramInt;
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4) {
              return null;
            }
            if (this.v == null)
            {
              this.v = new ChatHistoryEmotionView();
              this.v.a(getIntent(), this.app, this);
            }
            return this.v;
          }
        }
        else
        {
          if (this.t == null)
          {
            this.t = new ChatHistoryStructMsgView();
            this.t.a(getIntent(), this.app, this);
          }
          return this.t;
        }
      }
      if (this.u == null)
      {
        this.u = new ChatHistoryFileView();
        this.u.a(getIntent(), this.app, this);
      }
      this.u.a(paramInt);
      return this.u;
    }
    if (this.s == null)
    {
      this.s = new ChatHistoryImageView();
      this.s.a(getIntent(), this.app, this);
    }
    return this.s;
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, ChatHistoryFileActivity.OnWyDialogClick paramOnWyDialogClick)
  {
    QQCustomDialog localQQCustomDialog = this.C;
    if ((localQQCustomDialog != null) && (localQQCustomDialog.isShowing())) {
      this.C.dismiss();
    }
    localQQCustomDialog = new QQCustomDialog(this, 2131953338);
    localQQCustomDialog.setContentView(2131624611);
    this.C = localQQCustomDialog;
    this.C.setTitle(paramString1);
    this.C.setMessage(paramString2);
    paramString1 = paramString4;
    if (TextUtils.isEmpty(paramString4)) {
      paramString1 = getString(2131887648);
    }
    paramString2 = paramString3;
    if (TextUtils.isEmpty(paramString3)) {
      paramString2 = getString(2131888010);
    }
    this.C.setNegativeButton(paramString1, new ChatHistoryFileActivity.8(this, paramOnWyDialogClick));
    this.C.setPositiveButton(paramString2, new ChatHistoryFileActivity.9(this, paramOnWyDialogClick));
    this.C.setCancelable(true);
    this.C.setCanceledOnTouchOutside(false);
    this.C.show();
  }
  
  private void a(List<ChatMessage> paramList)
  {
    if (paramList.size() == 1) {
      WeiyunAIOUtils.b(this.app, this, getTitleBarHeight(), paramList, this.w);
    } else {
      WeiyunAIOUtils.a(this.app, this, getTitleBarHeight(), paramList, this.w);
    }
    ReportController.b(this.app, "dc00898", "", "", "0X8009DB9", "0X8009DB9", 0, 0, "", "", "", "");
  }
  
  private void a(List<AIORichMediaInfo> paramList, List<EmotionPreviewData> paramList1)
  {
    ChatHistoryImageView localChatHistoryImageView = this.s;
    if ((localChatHistoryImageView != null) && (localChatHistoryImageView.c != null))
    {
      ArrayList localArrayList = new ArrayList();
      if ((paramList != null) && (paramList.size() > 0))
      {
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          AIORichMediaInfo localAIORichMediaInfo = (AIORichMediaInfo)localIterator.next();
          localChatHistoryImageView = null;
          ChatMessage localChatMessage = this.s.c.a(localAIORichMediaInfo.a.L);
          if ((localChatMessage instanceof MessageForPic))
          {
            paramList = FileSaveReq.a((MessageForPic)localChatMessage);
          }
          else if ((localChatMessage instanceof MessageForShortVideo))
          {
            paramList = (MessageForShortVideo)localChatMessage;
            if (paramList.busiType == 0) {
              paramList = FileSaveReq.b(this.app, paramList);
            } else {
              paramList = FileSaveReq.a(this.app, paramList);
            }
          }
          else if ((localChatMessage instanceof MessageForFile))
          {
            if (AIOFilePicData.class.isInstance(localAIORichMediaInfo.a))
            {
              paramList = FileSaveReq.a(this.app, localChatMessage);
              paramList.a = 4;
            }
            else
            {
              paramList = localChatHistoryImageView;
              if (AIOFileVideoData.class.isInstance(localAIORichMediaInfo.a))
              {
                paramList = FileSaveReq.a(this.app, localChatMessage);
                paramList.a = 5;
              }
            }
          }
          else
          {
            paramList = localChatHistoryImageView;
            if ((localChatMessage instanceof MessageForTroopFile)) {
              if (AIOFilePicData.class.isInstance(localAIORichMediaInfo.a))
              {
                paramList = FileSaveReq.a(this.app, localChatMessage);
                paramList.a = 6;
              }
              else
              {
                paramList = localChatHistoryImageView;
                if (AIOFileVideoData.class.isInstance(localAIORichMediaInfo.a))
                {
                  paramList = FileSaveReq.a(this.app, localChatMessage);
                  paramList.a = 7;
                }
              }
            }
          }
          if (paramList != null) {
            localArrayList.add(paramList);
          }
        }
      }
      if ((paramList1 != null) && (!paramList1.isEmpty()))
      {
        paramList = paramList1.iterator();
        while (paramList.hasNext())
        {
          paramList1 = (EmotionPreviewData)paramList.next();
          if ((paramList1.a instanceof MessageForPic)) {
            localArrayList.add(FileSaveReq.a((MessageForPic)paramList1.a));
          }
        }
      }
      paramList = new FileSaveDialog(this);
      paramList1 = (MultiRichMediaSaveManager)this.app.getManager(QQManagerFactory.MULTI_CHOOSE_SAVE_MANAGER);
      paramList1.a(new ChatHistoryFileActivity.10(this, paramList, paramList1, localArrayList));
      paramList1.a(localArrayList, true);
      paramList1.a(localArrayList, 1, 5);
    }
  }
  
  private void d()
  {
    this.f = ((ImageView)findViewById(2131433636));
    this.g = ((ImageView)findViewById(2131432086));
    this.h = ((ImageView)findViewById(2131445244));
    this.i = ((ImageView)findViewById(2131431680));
    StateListDrawable localStateListDrawable = new StateListDrawable();
    Drawable localDrawable = getResources().getDrawable(2130839669);
    localStateListDrawable.addState(new int[] { 16842919 }, localDrawable);
    localDrawable = getResources().getDrawable(2130839670);
    localStateListDrawable.addState(new int[] { 16842910 }, localDrawable);
    localDrawable = getResources().getDrawable(2130839669);
    localStateListDrawable.addState(new int[0], localDrawable);
    this.h.setImageDrawable(localStateListDrawable);
    this.f.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.f.setEnabled(true);
    this.g.setEnabled(true);
    this.h.setEnabled(true);
    this.i.setEnabled(true);
  }
  
  public void a()
  {
    this.c ^= true;
    if (this.c)
    {
      this.a.setVisibility(0);
      this.b.setVisibility(0);
      this.d.g();
      setRightButton(2131887648, this);
      return;
    }
    this.a.setVisibility(8);
    this.b.setVisibility(8);
    this.d.h();
    setRightButton(2131886578, this);
    this.m = null;
    this.l = null;
    this.j = null;
    this.k = null;
    this.o = null;
    Object localObject = this.n;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = this.n.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((EmotionPreviewData)((Iterator)localObject).next()).b = false;
      }
      this.n.clear();
    }
  }
  
  public void a(long paramLong)
  {
    ChatHistoryViewBase localChatHistoryViewBase = this.d;
    if (localChatHistoryViewBase != null) {
      localChatHistoryViewBase.a(paramLong);
    }
  }
  
  public void a(AIORichMediaInfo paramAIORichMediaInfo)
  {
    if (this.l == null) {
      this.l = new ArrayList();
    }
    this.l.add(paramAIORichMediaInfo);
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    if (this.o == null) {
      this.o = new ArrayList();
    }
    this.o.add(paramChatMessage);
    if (QLog.isColorLevel())
    {
      paramChatMessage = new StringBuilder();
      paramChatMessage.append("addweiyunselected, size: ");
      paramChatMessage.append(this.o.size());
      QLog.d("ChatHistoryStruct", 2, paramChatMessage.toString());
    }
  }
  
  public void a(TencentDocData paramTencentDocData)
  {
    if (this.m == null) {
      this.m = new ArrayList();
    }
    this.m.add(paramTencentDocData);
  }
  
  public void a(EmotionPreviewData paramEmotionPreviewData)
  {
    if (this.n == null) {
      this.n = new ArrayList();
    }
    this.n.add(paramEmotionPreviewData);
  }
  
  public void a(FileManagerEntity paramFileManagerEntity)
  {
    if (this.k == null) {
      this.k = new ArrayList();
    }
    this.k.add(paramFileManagerEntity);
  }
  
  public void a(String paramString)
  {
    if (this.x == null)
    {
      this.x = DialogUtil.a(this, 230);
      this.x.setNegativeButton(2131916601, new ChatHistoryFileActivity.12(this));
    }
    if (!this.x.isShowing()) {
      this.x.setMessage(paramString);
    } else {
      this.x.dismiss();
    }
    try
    {
      this.x.show();
      return;
    }
    catch (Throwable paramString) {}
  }
  
  boolean a(int paramInt, List<ChatMessage> paramList, List<FileManagerEntity> paramList1, List<AIORichMediaInfo> paramList2, List<TencentDocData> paramList3)
  {
    boolean bool2 = ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).isCollectionNotEmpty(paramList3);
    int i2;
    int i4;
    int i9;
    if ((paramList1 != null) && (paramList1.size() > 0))
    {
      i2 = paramList1.size() + 0;
      i4 = 1;
      i9 = 1;
    }
    else
    {
      i4 = 0;
      i2 = 0;
      i9 = 0;
    }
    int i3 = i4;
    int i1 = i2;
    if (bool2)
    {
      i3 = i4 + 1;
      i1 = i2 + paramList3.size();
    }
    int i10;
    if ((paramList != null) && (paramList.size() > 0))
    {
      i2 = i3 + 1;
      i3 = i1 + paramList.size();
      i10 = 1;
      i1 = i2;
      i2 = i3;
    }
    else
    {
      i10 = 0;
      i2 = i1;
      i1 = i3;
    }
    Object localObject1 = this.n;
    boolean bool1;
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      if (paramInt == 1)
      {
        localObject1 = this.n.iterator();
        while (((Iterator)localObject1).hasNext()) {
          if ((((EmotionPreviewData)((Iterator)localObject1).next()).a instanceof MessageForMarketFace)) {
            break label220;
          }
        }
        bool1 = false;
      }
      else
      {
        label220:
        bool1 = true;
      }
      i1 += 1;
      i2 += this.n.size();
    }
    else
    {
      bool1 = false;
    }
    int i5;
    if (paramList2 != null)
    {
      localObject1 = paramList2.iterator();
      int i7 = 0;
      int i6 = 0;
      i4 = 0;
      while (((Iterator)localObject1).hasNext())
      {
        int i11 = AIOGalleryUtils.a(((AIORichMediaInfo)((Iterator)localObject1).next()).a);
        i5 = i7;
        int i8 = i1;
        if (i7 == 0)
        {
          i5 = i7;
          i8 = i1;
          if (i11 == 1)
          {
            i8 = i1 + 1;
            i5 = 1;
          }
        }
        i1 = i8;
        i3 = i6;
        if (i6 == 0)
        {
          i1 = i8;
          i3 = i6;
          if (i11 == 2)
          {
            i1 = i8 + 1;
            i3 = 1;
          }
        }
        if ((i4 == 0) && (i11 == 3))
        {
          i1 += 1;
          i4 = 1;
        }
        if ((paramInt != 1) && (i1 >= 2)) {
          break label428;
        }
        i7 = i5;
        i6 = i3;
      }
      i5 = i7;
      i3 = i6;
      label428:
      i2 += paramList2.size();
    }
    else
    {
      i5 = 0;
      i3 = 0;
      i4 = 0;
    }
    if (i2 == 0)
    {
      FMToastUtil.c(2131889423);
      return false;
    }
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return true;
          }
          localObject1 = new ArrayList();
          Iterator localIterator;
          Object localObject2;
          if ((paramList1 != null) && (paramList1.size() > 0))
          {
            localIterator = paramList1.iterator();
            while (localIterator.hasNext())
            {
              localObject2 = (FileManagerEntity)localIterator.next();
              localObject2 = this.app.getMessageFacade().b(((FileManagerEntity)localObject2).peerUin, ((FileManagerEntity)localObject2).peerType, ((FileManagerEntity)localObject2).uniseq);
              if (localObject2 != null) {
                ((List)localObject1).add((ChatMessage)localObject2);
              }
            }
          }
          if (paramList2 != null)
          {
            paramList2 = this.s;
            if (paramList2 != null)
            {
              paramList2 = paramList2.o();
              localIterator = paramList2.iterator();
              while (localIterator.hasNext())
              {
                localObject2 = (ChatMessage)localIterator.next();
                if (((ChatMessage)localObject2).msgtype == -2005)
                {
                  localObject2 = this.app.getFileManagerDataCenter().a(((ChatMessage)localObject2).uniseq, ((ChatMessage)localObject2).frienduin, ((ChatMessage)localObject2).istroop);
                  if (localObject2 != null) {
                    this.app.getFileManagerEngine().c(((FileManagerEntity)localObject2).nSessionId);
                  }
                }
              }
              ((List)localObject1).addAll(paramList2);
            }
          }
          if ((paramList != null) && (paramList.size() > 0)) {
            ((List)localObject1).addAll(paramList);
          }
          paramList = this.n;
          if ((paramList != null) && (!paramList.isEmpty()))
          {
            paramList = this.n.iterator();
            while (paramList.hasNext()) {
              ((List)localObject1).add((ChatMessage)((EmotionPreviewData)paramList.next()).a);
            }
          }
          if ((((List)localObject1).size() == 0) && (paramList1 == null) && (!bool2)) {
            return true;
          }
          if ((((List)localObject1).size() > 0) || (((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).isCollectionNotEmpty(paramList1)) || (bool2))
          {
            ThreadManager.post(new ChatHistoryFileActivity.7(this, (List)localObject1, paramList1, bool2, paramList3), 8, null, true);
            return true;
          }
        }
        else
        {
          if (((paramList2 != null) && (this.o != null)) || ((paramList != null) && (paramList.size() > 0)) || ((paramList1 != null) && (paramList1.size() > 0))) {
            c();
          }
          if (paramList2 != null)
          {
            paramList2 = this.o;
            if (paramList2 != null) {
              a(paramList2);
            }
          }
          if (paramList != null)
          {
            a(paramList);
            return true;
          }
          if ((paramList1 != null) && (paramList1.size() > 0))
          {
            paramList = (FileManagerEntity)paramList1.get(0);
            paramList = this.app.getFileManagerEngine();
            if ((paramList1.size() == 1) && (((FileManagerEntity)paramList1.get(0)).sendCloudUnsuccessful()))
            {
              FMToastUtil.a(2131889439);
              return false;
            }
            paramList2 = paramList1.iterator();
            while (paramList2.hasNext()) {
              if (FileModel.a((FileManagerEntity)paramList2.next()).a(false))
              {
                paramInt = 1;
                break label1069;
              }
            }
            paramInt = 0;
            label1069:
            if (paramInt != 0)
            {
              if (FreeWifiHelper.a(this, 5, new ChatHistoryFileActivity.5(this, paramList1, paramList)))
              {
                FMDialogUtil.a(this, 2131889584, 2131889587, new ChatHistoryFileActivity.6(this, paramList1, paramList));
                return true;
              }
            }
            else
            {
              paramList1 = paramList1.iterator();
              paramInt = 0;
              while (paramList1.hasNext())
              {
                paramList2 = (FileManagerEntity)paramList1.next();
                if (!paramList2.sendCloudUnsuccessful())
                {
                  if (FileUtils.fileExistsAndNotEmpty(paramList2.getFilePath())) {
                    paramList.a(paramList2.getFilePath(), "", this.app.getCurrentAccountUin(), 0, false);
                  } else {
                    paramList.a(paramList2, String.valueOf(paramList2.peerUin));
                  }
                  paramInt = 1;
                }
              }
              if (paramInt != 0)
              {
                FMToastUtil.d(getString(2131889761));
                return true;
              }
              FMToastUtil.a(2131889439);
              paramList = this.w;
              if (paramList != null)
              {
                paramList.sendEmptyMessage(102);
                return true;
              }
            }
          }
        }
      }
      else
      {
        if (((i5 != 0) || (i3 != 0)) && (i9 != 0))
        {
          a(getString(2131889415));
          return false;
        }
        if ((i10 == 0) && (!bool2) && (!bool1))
        {
          if (!CheckPermission.isHasStoragePermission(this))
          {
            CheckPermission.requestStorePermission(this, null);
            return false;
          }
          if (paramList1 != null)
          {
            long l1 = 0L;
            if ((paramList1.size() == 1) && (((FileManagerEntity)paramList1.get(0)).sendCloudUnsuccessful()))
            {
              FMToastUtil.a(2131889437);
              return false;
            }
            paramList = paramList1.iterator();
            while (paramList.hasNext())
            {
              paramList3 = (FileManagerEntity)paramList.next();
              if (FileModel.a(paramList3).a(true)) {
                l1 += paramList3.fileSize;
              }
            }
            paramList = this.app.getFileManagerEngine();
            if ((FileManagerUtil.b()) && (l1 > ((IFMConfig)QRoute.api(IFMConfig.class)).getFlowDialogSize()))
            {
              FileManagerUtil.a(false, this, new ChatHistoryFileActivity.4(this, paramList1, paramList));
            }
            else
            {
              paramList1 = paramList1.iterator();
              while (paramList1.hasNext())
              {
                paramList3 = (FileManagerEntity)paramList1.next();
                if (!paramList3.sendCloudUnsuccessful()) {
                  paramList.h(paramList3);
                }
              }
            }
          }
          if ((paramList2 == null) || (paramList2.size() <= 0))
          {
            if (!bool1)
            {
              paramList = this.n;
              if ((paramList == null) || (paramList.isEmpty())) {}
            }
          }
          else
          {
            a(paramList2, this.n);
            return false;
          }
        }
        else
        {
          a(getString(2131889416));
          return false;
        }
      }
    }
    else
    {
      if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
      {
        QQToast.makeText(this, 2131892157, 1).show(getResources().getDimensionPixelSize(2131299920));
        return false;
      }
      if (i1 > 1)
      {
        a(getString(2131889417));
        return false;
      }
      if (i4 != 0)
      {
        a(getString(2131889398));
        return false;
      }
      if ((i3 != 0) && (paramList2.size() > 1))
      {
        a(getString(2131889419));
        return false;
      }
      if (paramList1 != null)
      {
        if ((paramList1.size() == 1) && (((FileManagerEntity)paramList1.get(0)).sendCloudUnsuccessful()))
        {
          FMToastUtil.a(2131889438);
          return false;
        }
        localObject1 = paramList1.iterator();
        while (((Iterator)localObject1).hasNext()) {
          if (FileModel.a((FileManagerEntity)((Iterator)localObject1).next()).a(false))
          {
            paramInt = 1;
            break label1752;
          }
        }
        paramInt = 0;
        label1752:
        if (paramInt != 0) {
          FMDialogUtil.a(this, 2131889584, 2131889589, new ChatHistoryFileActivity.3(this, paramList1));
        } else {
          FileManagerUtil.a(paramList1, this);
        }
      }
      if ((paramList2 != null) && (paramList2.size() > 0))
      {
        paramList1 = this.s;
        if (paramList1 != null)
        {
          paramList1.l();
          return false;
        }
      }
      paramList1 = new ArrayList();
      if (paramList != null) {
        paramList1.addAll(paramList);
      }
      if (bool2)
      {
        paramList1.addAll(((ITeamWorkUtilsTemp)QRoute.api(ITeamWorkUtilsTemp.class)).createChatMsgListFromTencentDocs(paramList3, this.p, null));
        FileManagerReporter.a("0X8009AA1");
      }
      if (paramList1.size() == 1)
      {
        paramList2 = (MessageForStructing)paramList1.get(0);
        if (paramList2.structingMsg != null)
        {
          paramList = new Bundle();
          if ((paramList2.structingMsg.source_puin != null) && (!"".equals(paramList2.structingMsg.source_puin))) {
            paramList.putString("source_puin", paramList2.structingMsg.source_puin);
          }
          paramList.putInt("forward_type", -3);
          paramList2.structingMsg.mCommentText = null;
          paramList.putInt("structmsg_service_id", paramList2.structingMsg.mMsgServiceID);
          paramList.putByteArray("stuctmsg_bytes", paramList2.structingMsg.getBytes());
          paramList.putLong("structmsg_uniseq", paramList2.uniseq);
          paramList.putInt("accostType", paramList2.structingMsg.sourceAccoutType);
          paramList.putBoolean("forwardDirect", true);
          paramList2 = new Intent();
          paramList2.putExtras(paramList);
          paramList2.putExtra("forwardDirect", true);
          ForwardBaseOption.a(this, paramList2, 3);
        }
      }
      if ((paramList1.size() > 1) || (bool1))
      {
        paramList = new ArrayList();
        paramList.addAll(paramList1);
        if (bool1)
        {
          paramList1 = this.n.iterator();
          while (paramList1.hasNext()) {
            paramList.add((ChatMessage)((EmotionPreviewData)paramList1.next()).a);
          }
        }
        this.A = bool1;
        this.y.a(paramList);
      }
    }
    return true;
  }
  
  public void b(AIORichMediaInfo paramAIORichMediaInfo)
  {
    List localList = this.l;
    if (localList == null) {
      return;
    }
    localList.remove(paramAIORichMediaInfo);
  }
  
  public void b(ChatMessage paramChatMessage)
  {
    if (this.j == null) {
      this.j = new ArrayList();
    }
    this.j.add(paramChatMessage);
    if (QLog.isColorLevel())
    {
      paramChatMessage = new StringBuilder();
      paramChatMessage.append("addselect, size: ");
      paramChatMessage.append(this.j.size());
      QLog.d("ChatHistoryStruct", 2, paramChatMessage.toString());
    }
  }
  
  public void b(EmotionPreviewData paramEmotionPreviewData)
  {
    List localList = this.n;
    if (localList == null) {
      return;
    }
    localList.remove(paramEmotionPreviewData);
  }
  
  public boolean b()
  {
    List localList = this.j;
    boolean bool = false;
    if (localList != null) {
      i2 = localList.size() + 0;
    } else {
      i2 = 0;
    }
    localList = this.k;
    int i1 = i2;
    if (localList != null) {
      i1 = i2 + localList.size();
    }
    localList = this.l;
    int i2 = i1;
    if (localList != null) {
      i2 = i1 + localList.size();
    }
    localList = this.m;
    i1 = i2;
    if (localList != null) {
      i1 = i2 + localList.size();
    }
    localList = this.n;
    i2 = i1;
    if (localList != null) {
      i2 = i1 + localList.size();
    }
    if (i2 >= 20) {
      bool = true;
    }
    if (bool)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistoryFIleActivity", 2, "isOverLimit");
      }
      FMToastUtil.a(2131889426);
    }
    return bool;
  }
  
  public boolean b(TencentDocData paramTencentDocData)
  {
    List localList = this.m;
    return (localList != null) && (localList.contains(paramTencentDocData));
  }
  
  public boolean b(FileManagerEntity paramFileManagerEntity)
  {
    List localList = this.k;
    if (localList == null) {
      return false;
    }
    return localList.contains(paramFileManagerEntity);
  }
  
  void c()
  {
    if (this.B == null)
    {
      this.B = new ReportDialog(getActivity(), 2131953338);
      this.B.setCanceledOnTouchOutside(false);
      this.B.setContentView(2131625585);
    }
    TextView localTextView = (TextView)this.B.findViewById(2131440191);
    localTextView.setText(localTextView.getResources().getString(2131886524));
    if (!this.B.isShowing()) {}
    try
    {
      this.B.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void c(TencentDocData paramTencentDocData)
  {
    List localList = this.m;
    if (localList == null) {
      return;
    }
    localList.remove(paramTencentDocData);
  }
  
  public void c(FileManagerEntity paramFileManagerEntity)
  {
    List localList = this.k;
    if (localList == null) {
      return;
    }
    localList.remove(paramFileManagerEntity);
  }
  
  public boolean c(ChatMessage paramChatMessage)
  {
    List localList = this.j;
    if (localList == null) {
      return false;
    }
    return localList.contains(paramChatMessage);
  }
  
  public void d(ChatMessage paramChatMessage)
  {
    List localList = this.j;
    if (localList == null) {
      return;
    }
    localList.remove(paramChatMessage);
    if (QLog.isColorLevel())
    {
      paramChatMessage = new StringBuilder();
      paramChatMessage.append("removeselect, size: ");
      paramChatMessage.append(this.j.size());
      QLog.d("ChatHistoryStruct", 2, paramChatMessage.toString());
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1)
    {
      Object localObject;
      if (paramInt1 != 1)
      {
        if (paramInt1 != 2)
        {
          if (paramInt1 != 3)
          {
            if (paramInt1 == 98) {
              a();
            }
          }
          else if (!this.A) {
            this.y.a(paramIntent);
          }
        }
        else
        {
          localObject = this.s;
          if (localObject != null) {
            ((ChatHistoryImageView)localObject).a(paramIntent);
          }
        }
      }
      else
      {
        localObject = new Intent(this, SendPhotoActivity.class);
        paramIntent = new Bundle(paramIntent.getExtras());
        if (QLog.isColorLevel()) {
          QLog.d("forward", 2, "AIOListGallerysence startChatAndSendMsg IS_WAIT_DEST_RESULT=true");
        }
        paramIntent.putBoolean("PhotoConst.HANDLE_DEST_RESULT", true);
        paramIntent.putInt("PhotoConst.SEND_BUSINESS_TYPE", 1031);
        ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
        localObject = AIOUtils.a((Intent)localObject, null);
        ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        paramIntent.putBoolean("PicContants.NEED_COMPRESS", false);
        paramIntent.putBoolean("send_in_background", false);
        ((Intent)localObject).putExtras(paramIntent);
        startActivity((Intent)localObject);
      }
    }
    if (paramInt1 == 1) {
      a();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    Object localObject = getIntent();
    this.p = ((Intent)localObject).getStringExtra("uin");
    int i1 = 0;
    this.q = ((Intent)localObject).getIntExtra("uintype", 0);
    this.r = ((Intent)localObject).getStringExtra("uinname");
    setContentView(2131624412);
    setTitle(2131887720);
    if (((Intent)localObject).getStringExtra("leftViewText") == null) {
      setLeftViewName(2131887812);
    } else {
      setLeftViewName((Intent)localObject);
    }
    paramBundle = (TabBarView)findViewById(2131446764);
    paramBundle.a(0, HardCodeUtil.a(2131899874));
    paramBundle.a(1, HardCodeUtil.a(2131899893));
    paramBundle.a(2, HardCodeUtil.a(2131899884));
    paramBundle.a(3, HardCodeUtil.a(2131899823));
    paramBundle.a(4, HardCodeUtil.a(2131899892));
    this.a = ((LinearLayout)findViewById(2131445545));
    this.a.setVisibility(8);
    this.b = ((FrameLayout)findViewById(2131447690));
    this.a.setVisibility(8);
    this.b.setVisibility(8);
    setRightButton(2131886578, this);
    d();
    this.e = ((RelativeLayout)findViewById(2131437901));
    paramBundle.setOnTabChangeListener(new ChatHistoryFileActivity.1(this));
    localObject = ((Intent)localObject).getStringExtra("com.tencent.mobileqq.ChatHistoryFileActivity.initial_tab");
    try
    {
      int i2 = Integer.parseInt((String)localObject);
      i1 = i2;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label277:
      StringBuilder localStringBuilder;
      break label277;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("extra KEY_INITIAL_TAB ");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" is not number");
    QLog.e("ChatHistoryFIleActivity", 1, localStringBuilder.toString());
    paramBundle.setSelectedTab(i1, true);
    this.y = new SeparateForward(this, 3);
    this.y.a();
    AIOGalleryMsgRevokeMgr.a().a(this);
    if (this.D == null) {
      this.D = new ChatHistoryFileActivity.MyFMObserver(this, null);
    }
    this.app.getFileManagerNotifyCenter().addObserver(this.D);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.y.b();
    Object localObject = this.s;
    if (localObject != null) {
      ((ChatHistoryImageView)localObject).f();
    }
    localObject = this.v;
    if (localObject != null) {
      ((ChatHistoryEmotionView)localObject).f();
    }
    if (this.D != null) {
      this.app.getFileManagerNotifyCenter().deleteObserver(this.D);
    }
    AIOGalleryMsgRevokeMgr.a().b(this);
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.c))
    {
      a();
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    ChatHistoryViewBase localChatHistoryViewBase = this.d;
    if (localChatHistoryViewBase != null) {
      localChatHistoryViewBase.e();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    ChatHistoryViewBase localChatHistoryViewBase = this.d;
    if (localChatHistoryViewBase != null)
    {
      localChatHistoryViewBase.a(this.z);
      this.d.d();
    }
  }
  
  public void e(ChatMessage paramChatMessage)
  {
    List localList = this.o;
    if (localList == null) {
      return;
    }
    localList.remove(paramChatMessage);
    if (QLog.isColorLevel())
    {
      paramChatMessage = new StringBuilder();
      paramChatMessage.append("removeweiyunselect, size: ");
      paramChatMessage.append(this.o.size());
      QLog.d("ChatHistoryStruct", 2, paramChatMessage.toString());
    }
  }
  
  public int getTitleBarHeight()
  {
    return getResources().getDimensionPixelSize(2131299920);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1 = paramMessage.what;
    if (i1 != 2)
    {
      switch (i1)
      {
      default: 
        return true;
      case 102: 
        paramMessage = this.B;
        if (paramMessage == null) {
          break;
        }
        paramMessage.dismiss();
        return true;
      case 101: 
        Object localObject = this.B;
        if (localObject != null) {
          ((Dialog)localObject).dismiss();
        }
        i1 = paramMessage.arg1;
        if (!((IWeiyunResponseHandler)QRoute.api(IWeiyunResponseHandler.class)).endSave2Weiyun(i1)) {
          break;
        }
        if (((IWeiyunResponseHandler)QRoute.api(IWeiyunResponseHandler.class)).needShowGrayTips(i1))
        {
          getString(2131892350);
          if (((IWeiyunResponseHandler)QRoute.api(IWeiyunResponseHandler.class)).isSpaceOverErrorCode(i1))
          {
            getString(2131892350);
            paramMessage = getString(2131889036);
          }
          else if (((IWeiyunResponseHandler)QRoute.api(IWeiyunResponseHandler.class)).isFlowOverErrorCode(i1))
          {
            getString(2131892350);
            paramMessage = getString(2131889034);
          }
          else
          {
            paramMessage = "";
          }
          localObject = new ChatHistoryFileActivity.11(this);
          a(getString(2131896694), paramMessage, null, null, (ChatHistoryFileActivity.OnWyDialogClick)localObject);
          return true;
        }
        paramMessage = (String)paramMessage.obj;
        QQToast.makeText(this.app.getApp(), paramMessage, 1).show(getTitleBarHeight());
        return true;
      case 100: 
        paramMessage = this.B;
        if (paramMessage != null) {
          paramMessage.dismiss();
        }
        ((IWeiyunSaveTipsHelper)QRoute.api(IWeiyunSaveTipsHelper.class)).showTopTips(this.app, this, getTitleBarHeight());
        return true;
      }
    }
    else
    {
      paramMessage = this.t;
      if (paramMessage != null) {
        paramMessage.a(this.j);
      }
      paramMessage = this.v;
      if (paramMessage != null) {
        paramMessage.j();
      }
      a();
      a(this.z);
    }
    return true;
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected boolean onBackEvent()
  {
    finish();
    if (getIntent().getBooleanExtra("extra.IS_FROM_CHAT_AIO_GALLERY", false)) {
      overridePendingTransition(0, 2130772481);
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131445244: 
      if (a(2, this.j, this.k, this.l, this.m)) {
        a();
      }
      ReportController.b(this.app, "dc00898", "", "", "0X800712B", "0X800712B", 0, 0, "", "", "", "");
      break;
    case 2131436211: 
      a();
      if (this.c) {
        ReportController.b(this.app, "dc00898", "", "", "0X8007125", "0X8007125", 0, 0, "", "", "", "");
      }
      break;
    case 2131433636: 
      if (a(0, this.j, this.k, this.l, this.m)) {
        a();
      }
      ReportController.b(this.app, "dc00898", "", "", "0X8007129", "0X8007129", 0, 0, "", "", "", "");
      break;
    case 2131432086: 
      if (a(1, this.j, this.k, this.l, this.m)) {
        a();
      }
      ReportController.b(this.app, "dc00898", "", "", "0X800712A", "0X800712A", 0, 0, "", "", "", "");
      break;
    case 2131431680: 
      ReportController.b(this.app, "dc00898", "", "", "0X800712C", "0X800712C", 0, 0, "", "", "", "");
      int i2 = 0;
      Object localObject = this.j;
      if (localObject != null) {
        i2 = 0 + ((List)localObject).size();
      }
      localObject = this.k;
      int i1 = i2;
      if (localObject != null) {
        i1 = i2 + ((List)localObject).size();
      }
      localObject = this.l;
      i2 = i1;
      if (localObject != null) {
        i2 = i1 + ((List)localObject).size();
      }
      localObject = this.m;
      i1 = i2;
      if (localObject != null) {
        i1 = i2 + ((List)localObject).size();
      }
      localObject = this.n;
      i2 = i1;
      if (localObject != null) {
        i2 = i1 + ((List)localObject).size();
      }
      if (i2 == 0)
      {
        FMToastUtil.c(2131889423);
      }
      else
      {
        localObject = (ActionSheet)ActionSheetHelper.b(this, null);
        ((ActionSheet)localObject).setMainTitle(2131893858);
        ((ActionSheet)localObject).addButton(getString(2131889261), 3);
        ((ActionSheet)localObject).addCancelButton(2131887648);
        ((ActionSheet)localObject).setOnButtonClickListener(new ChatHistoryFileActivity.2(this, (ActionSheet)localObject));
        ((ActionSheet)localObject).show();
      }
      break;
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryFileActivity
 * JD-Core Version:    0.7.0.1
 */