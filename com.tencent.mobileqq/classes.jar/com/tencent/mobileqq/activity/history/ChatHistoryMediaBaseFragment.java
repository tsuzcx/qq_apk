package com.tencent.mobileqq.activity.history;

import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.MsgRevokeListener;
import com.tencent.mobileqq.activity.ChatHistoryFileActivity.OnWyDialogClick;
import com.tencent.mobileqq.activity.ChatHistoryImageView;
import com.tencent.mobileqq.activity.ChatHistoryImageView.OperCallBack;
import com.tencent.mobileqq.activity.aio.photo.AIOFilePicData;
import com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryMsgRevokeMgr;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.aio.photo.AIOPhotoListAdapter;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaInfo;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.multimsg.save.FileSaveDialog;
import com.tencent.mobileqq.multimsg.save.FileSaveReq;
import com.tencent.mobileqq.multimsg.save.MultiRichMediaSaveManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.weiyun.api.IWeiyunResponseHandler;
import com.tencent.mobileqq.weiyun.api.IWeiyunSaveTipsHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.weiyun.WeiyunAIOUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.activity.aio.photo.AIORichMediaInfo;>;
import mqq.os.MqqHandler;

public class ChatHistoryMediaBaseFragment
  extends ChatHistoryBaseFragment
  implements Handler.Callback, View.OnClickListener, MsgRevokeListener, ChatHistoryImageView.OperCallBack
{
  private Button A;
  private FMObserver B = null;
  ChatHistoryImageView s;
  public ArrayList<AIORichMediaInfo> t;
  List<ChatMessage> u;
  QQCustomDialog v;
  protected final MqqHandler w = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
  protected QQCustomDialog x;
  private Dialog y;
  private View z;
  
  private boolean E()
  {
    return ((getBaseActivity() instanceof ChatHistoryActivity)) && (((ChatHistoryActivity)getBaseActivity()).e);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, ChatHistoryFileActivity.OnWyDialogClick paramOnWyDialogClick)
  {
    QQCustomDialog localQQCustomDialog = this.x;
    if ((localQQCustomDialog != null) && (localQQCustomDialog.isShowing())) {
      this.x.dismiss();
    }
    localQQCustomDialog = new QQCustomDialog(getBaseActivity(), 2131953338);
    localQQCustomDialog.setContentView(2131624611);
    this.x = localQQCustomDialog;
    this.x.setTitle(paramString1);
    this.x.setMessage(paramString2);
    paramString1 = paramString4;
    if (TextUtils.isEmpty(paramString4)) {
      paramString1 = getString(2131887648);
    }
    paramString2 = paramString3;
    if (TextUtils.isEmpty(paramString3)) {
      paramString2 = getString(2131888010);
    }
    this.x.setNegativeButton(paramString1, new ChatHistoryMediaBaseFragment.5(this, paramOnWyDialogClick));
    this.x.setPositiveButton(paramString2, new ChatHistoryMediaBaseFragment.6(this, paramOnWyDialogClick));
    this.x.setCancelable(true);
    this.x.setCanceledOnTouchOutside(false);
    this.x.show();
  }
  
  private void a(List<AIORichMediaInfo> paramList)
  {
    Object localObject = this.s;
    if ((localObject != null) && (((ChatHistoryImageView)localObject).c != null))
    {
      ArrayList localArrayList = new ArrayList();
      if ((paramList != null) && (paramList.size() > 0))
      {
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          AIORichMediaInfo localAIORichMediaInfo = (AIORichMediaInfo)localIterator.next();
          localObject = null;
          ChatMessage localChatMessage = this.s.c.a(localAIORichMediaInfo.a.L);
          if ((localChatMessage instanceof MessageForPic))
          {
            paramList = FileSaveReq.a((MessageForPic)localChatMessage);
          }
          else if ((localChatMessage instanceof MessageForShortVideo))
          {
            paramList = (MessageForShortVideo)localChatMessage;
            if (paramList.busiType == 0) {
              paramList = FileSaveReq.b(this.a, paramList);
            } else {
              paramList = FileSaveReq.a(this.a, paramList);
            }
          }
          else if ((localChatMessage instanceof MessageForFile))
          {
            if (AIOFilePicData.class.isInstance(localAIORichMediaInfo.a))
            {
              paramList = FileSaveReq.a(this.a, localChatMessage);
              paramList.a = 4;
            }
            else
            {
              paramList = (List<AIORichMediaInfo>)localObject;
              if (AIOFileVideoData.class.isInstance(localAIORichMediaInfo.a))
              {
                paramList = FileSaveReq.a(this.a, localChatMessage);
                paramList.a = 5;
              }
            }
          }
          else
          {
            paramList = (List<AIORichMediaInfo>)localObject;
            if ((localChatMessage instanceof MessageForTroopFile))
            {
              int i = FileManagerUtil.c(((MessageForTroopFile)localChatMessage).fileName);
              if (i == 0)
              {
                paramList = FileSaveReq.a(this.a, localChatMessage);
                paramList.a = 6;
              }
              else
              {
                paramList = (List<AIORichMediaInfo>)localObject;
                if (i == 2)
                {
                  paramList = FileSaveReq.a(this.a, localChatMessage);
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
      paramList = new FileSaveDialog(getBaseActivity());
      localObject = (MultiRichMediaSaveManager)this.a.getManager(QQManagerFactory.MULTI_CHOOSE_SAVE_MANAGER);
      ((MultiRichMediaSaveManager)localObject).a(new ChatHistoryMediaBaseFragment.3(this, paramList, (MultiRichMediaSaveManager)localObject, localArrayList));
      ((MultiRichMediaSaveManager)localObject).a(localArrayList, true);
      ((MultiRichMediaSaveManager)localObject).a(localArrayList, 1, 5);
    }
  }
  
  private void b(List<ChatMessage> paramList)
  {
    if (paramList.size() == 1) {
      WeiyunAIOUtils.b(this.a, getBaseActivity(), D(), paramList, this.w);
    } else {
      WeiyunAIOUtils.a(this.a, getBaseActivity(), D(), paramList, this.w);
    }
    ReportController.b(this.a, "dc00898", "", "", "0X8009DB9", "0X8009DB9", 0, 0, "", "", "", "");
  }
  
  protected void A()
  {
    Object localObject = this.s;
    if (localObject != null) {
      ((ChatHistoryImageView)localObject).g();
    }
    localObject = this.A;
    if (localObject != null) {
      ((Button)localObject).setEnabled(true);
    }
  }
  
  protected void B()
  {
    Object localObject = this.s;
    if (localObject != null) {
      ((ChatHistoryImageView)localObject).h();
    }
    localObject = this.t;
    if (localObject != null)
    {
      ((ArrayList)localObject).clear();
      this.t = null;
    }
    localObject = this.u;
    if (localObject != null)
    {
      ((List)localObject).clear();
      this.u = null;
    }
    localObject = this.A;
    if (localObject != null) {
      ((Button)localObject).setEnabled(false);
    }
    m();
  }
  
  public int C()
  {
    Object localObject = this.t;
    if (localObject != null)
    {
      if (((ArrayList)localObject).isEmpty()) {
        return 0;
      }
      localObject = ((AIORichMediaInfo)this.t.get(0)).a;
      if ((!AIOImageData.class.isInstance(localObject)) && (!AIOFilePicData.class.isInstance(localObject)))
      {
        if (AIOShortVideoData.class.isInstance(localObject)) {
          return 2;
        }
        return 0;
      }
      return 1;
    }
    return 0;
  }
  
  public int D()
  {
    return getResources().getDimensionPixelSize(2131299920);
  }
  
  public void a(long paramLong)
  {
    ChatHistoryImageView localChatHistoryImageView = this.s;
    if (localChatHistoryImageView != null) {
      localChatHistoryImageView.a(paramLong);
    }
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    if (this.u == null) {
      this.u = new ArrayList();
    }
    this.u.add(paramChatMessage);
    if (QLog.isColorLevel())
    {
      paramChatMessage = new StringBuilder();
      paramChatMessage.append("addweiyunselected, size: ");
      paramChatMessage.append(this.u.size());
      QLog.d("ChatHistoryStruct", 2, paramChatMessage.toString());
    }
  }
  
  void a(ArrayList<AIORichMediaInfo> paramArrayList) {}
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (this.b)
    {
      ChatHistoryImageView localChatHistoryImageView = this.s;
      if ((localChatHistoryImageView != null) && (localChatHistoryImageView.c())) {
        this.s.b();
      }
    }
  }
  
  public boolean a()
  {
    ArrayList localArrayList = this.t;
    boolean bool = false;
    int i;
    if (localArrayList != null) {
      i = localArrayList.size() + 0;
    } else {
      i = 0;
    }
    if (i >= 20) {
      bool = true;
    }
    if (bool)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistoryMediaBaseFragment", 2, "isOverLimit");
      }
      FMToastUtil.a(2131889426);
    }
    return bool;
  }
  
  public boolean a(AIORichMediaInfo paramAIORichMediaInfo)
  {
    if (this.t == null) {
      this.t = new ArrayList();
    }
    if (E())
    {
      int i = AIOGalleryUtils.a(paramAIORichMediaInfo.a);
      if ((i != 2) && (i != 3))
      {
        if (AIOImageData.class.isInstance(paramAIORichMediaInfo.a))
        {
          AIOImageData localAIOImageData = (AIOImageData)paramAIORichMediaInfo.a;
          if ((localAIOImageData.n == null) || (localAIOImageData.n.length() == 0))
          {
            b(getString(2131889443));
            return false;
          }
        }
      }
      else
      {
        b(getString(2131889444));
        return false;
      }
    }
    this.t.add(paramAIORichMediaInfo);
    return true;
  }
  
  public void b()
  {
    ChatHistoryImageView localChatHistoryImageView = this.s;
    if ((localChatHistoryImageView != null) && (localChatHistoryImageView.l != null) && (this.s.l.getCount() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistoryMediaBaseFragment", 2, "onMediaLoaded, mImageView.mAdapter is null");
      }
      this.g.a(this, false);
      return;
    }
    this.g.a(this, true);
  }
  
  public void b(AIORichMediaInfo paramAIORichMediaInfo)
  {
    ArrayList localArrayList = this.t;
    if (localArrayList == null) {
      return;
    }
    localArrayList.remove(paramAIORichMediaInfo);
  }
  
  public void b(ChatMessage paramChatMessage)
  {
    List localList = this.u;
    if (localList == null) {
      return;
    }
    localList.remove(paramChatMessage);
    if (QLog.isColorLevel())
    {
      paramChatMessage = new StringBuilder();
      paramChatMessage.append("removeweiyunselect, size: ");
      paramChatMessage.append(this.u.size());
      QLog.d("ChatHistoryStruct", 2, paramChatMessage.toString());
    }
  }
  
  public void b(String paramString)
  {
    if (this.v == null)
    {
      this.v = DialogUtil.a(getBaseActivity(), 230);
      this.v.setNegativeButton(2131916601, new ChatHistoryMediaBaseFragment.2(this));
    }
    if (!this.v.isShowing()) {
      this.v.setMessage(paramString);
    } else {
      this.v.dismiss();
    }
    try
    {
      this.v.show();
      return;
    }
    catch (Throwable paramString) {}
  }
  
  void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      A();
      y();
      return;
    }
    B();
  }
  
  protected void c() {}
  
  protected void d() {}
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 2)
    {
      switch (i)
      {
      default: 
        return true;
      case 102: 
        paramMessage = this.y;
        if (paramMessage != null) {
          paramMessage.dismiss();
        }
        B();
        return true;
      case 101: 
        Object localObject = this.y;
        if (localObject != null) {
          ((Dialog)localObject).dismiss();
        }
        B();
        i = paramMessage.arg1;
        if (!((IWeiyunResponseHandler)QRoute.api(IWeiyunResponseHandler.class)).endSave2Weiyun(i)) {
          break;
        }
        if (((IWeiyunResponseHandler)QRoute.api(IWeiyunResponseHandler.class)).needShowGrayTips(i))
        {
          getString(2131892350);
          if (((IWeiyunResponseHandler)QRoute.api(IWeiyunResponseHandler.class)).isSpaceOverErrorCode(i))
          {
            getString(2131892350);
            paramMessage = getString(2131889036);
          }
          else if (((IWeiyunResponseHandler)QRoute.api(IWeiyunResponseHandler.class)).isFlowOverErrorCode(i))
          {
            getString(2131892350);
            paramMessage = getString(2131889034);
          }
          else
          {
            paramMessage = "";
          }
          localObject = new ChatHistoryMediaBaseFragment.4(this);
          a(getString(2131896694), paramMessage, null, null, (ChatHistoryFileActivity.OnWyDialogClick)localObject);
          return true;
        }
        paramMessage = (String)paramMessage.obj;
        QQToast.makeText(this.a.getApp(), paramMessage, 1).show(D());
        return true;
      case 100: 
        paramMessage = this.y;
        if (paramMessage != null) {
          paramMessage.dismiss();
        }
        ((IWeiyunSaveTipsHelper)QRoute.api(IWeiyunSaveTipsHelper.class)).showTopTips(this.a, getBaseActivity(), D());
        B();
        return true;
      }
    }
    else
    {
      B();
      w();
    }
    return true;
  }
  
  public void i()
  {
    if (this.g == null) {
      return;
    }
    super.i();
    ChatHistoryImageView localChatHistoryImageView = this.s;
    if (localChatHistoryImageView == null) {
      return;
    }
    if ((localChatHistoryImageView.c == null) || (!AIOImageProviderService.r.containsValue(this.s.c))) {
      this.s.j();
    }
    this.s.d();
    B();
    if ((this.s.l != null) && (this.s.l.getCount() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistoryMediaBaseFragment", 2, "doOnResume, mImageView.mAdapter is null");
      }
      this.g.a(this, false);
      return;
    }
    this.g.a(this, true);
  }
  
  public void j()
  {
    super.j();
    ChatHistoryImageView localChatHistoryImageView = this.s;
    if (localChatHistoryImageView != null) {
      localChatHistoryImageView.e();
    }
  }
  
  public void k()
  {
    super.k();
    AIOGalleryMsgRevokeMgr.a().b(this);
    ChatHistoryImageView localChatHistoryImageView = this.s;
    if (localChatHistoryImageView != null) {
      localChatHistoryImageView.f();
    }
    if (this.B != null) {
      this.a.getFileManagerNotifyCenter().deleteObserver(this.B);
    }
  }
  
  protected int l()
  {
    return 1602;
  }
  
  public void n()
  {
    if (this.y == null)
    {
      this.y = new ReportDialog(getBaseActivity(), 2131953338);
      this.y.setCanceledOnTouchOutside(false);
      this.y.setContentView(2131625585);
    }
    TextView localTextView = (TextView)this.y.findViewById(2131440191);
    localTextView.setText(localTextView.getResources().getString(2131886524));
    if (!this.y.isShowing()) {}
    try
    {
      this.y.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void onClick(View paramView)
  {
    if ((paramView != null) && (paramView.getId() == 2131449184))
    {
      ArrayList localArrayList = this.t;
      if ((localArrayList != null) && (localArrayList.size() != 0))
      {
        localArrayList = (ArrayList)this.t.clone();
        int j = 0;
        Iterator localIterator = localArrayList.iterator();
        do
        {
          i = j;
          if (!localIterator.hasNext()) {
            break;
          }
          i = AIOGalleryUtils.a(((AIORichMediaInfo)localIterator.next()).a);
        } while ((i != 2) && (i != 3));
        int i = 1;
        if (i != 0) {
          b(getString(2131889444));
        } else {
          a(localArrayList);
        }
        getBaseActivity().finish();
      }
      else
      {
        FMToastUtil.c(2131889423);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    AIOGalleryMsgRevokeMgr.a().a(this);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.s == null)
    {
      this.s = new ChatHistoryImageView();
      if (this.a != null)
      {
        this.s.a(getBaseActivity().getIntent(), this.a, getBaseActivity());
        this.s.a(true);
      }
      this.s.B = this;
    }
    if ((E()) && ((this.s.a() instanceof RelativeLayout)))
    {
      paramViewGroup = (RelativeLayout)this.s.a();
      this.z = paramLayoutInflater.inflate(2131624411, null);
      this.A = ((Button)this.z.findViewById(2131449184));
      this.A.setOnClickListener(this);
      this.A.setEnabled(false);
      paramLayoutInflater = new RelativeLayout.LayoutParams(-1, -2);
      paramLayoutInflater.addRule(12, -1);
      paramLayoutInflater.addRule(14, -1);
      paramViewGroup.addView(this.z, paramLayoutInflater);
      paramLayoutInflater = paramViewGroup;
    }
    else
    {
      if (this.a != null)
      {
        if (this.B == null) {
          this.B = new ChatHistoryMediaBaseFragment.MyFMObserver(this, null);
        }
        this.a.getFileManagerNotifyCenter().addObserver(this.B);
      }
      paramLayoutInflater = this.s.a();
    }
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  protected void p()
  {
    if (!CheckPermission.isHasStoragePermission(this.d))
    {
      CheckPermission.requestStorePermission(this.d, null);
      return;
    }
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      QQToast.makeText(getBaseActivity(), 2131892157, 1).show(getResources().getDimensionPixelSize(2131299920));
      return;
    }
    ArrayList localArrayList = this.t;
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      a(this.t);
      x();
      return;
    }
    FMToastUtil.c(2131889423);
  }
  
  protected void q()
  {
    List localList = this.u;
    if ((localList != null) && (localList.size() > 0))
    {
      n();
      b(this.u);
      z();
      return;
    }
    FMToastUtil.c(2131889423);
  }
  
  protected void r()
  {
    Object localObject = this.t;
    int m = 0;
    int i;
    int j;
    int k;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      i = 0;
      int i3 = 0;
      j = 0;
      k = 0;
      while (((Iterator)localObject).hasNext())
      {
        int i4 = AIOGalleryUtils.a(((AIORichMediaInfo)((Iterator)localObject).next()).a);
        m = i;
        int i1 = i3;
        if (i3 == 0)
        {
          m = i;
          i1 = i3;
          if (i4 == 1)
          {
            m = i + 1;
            i1 = 1;
          }
        }
        int n = m;
        int i2 = k;
        if (k == 0)
        {
          n = m;
          i2 = k;
          if (i4 == 2)
          {
            n = m + 1;
            i2 = 1;
          }
        }
        i = n;
        i3 = i1;
        k = i2;
        if (j == 0)
        {
          i = n;
          i3 = i1;
          k = i2;
          if (i4 == 3)
          {
            i = n + 1;
            j = 1;
            i3 = i1;
            k = i2;
          }
        }
      }
      m = 0 + this.t.size();
    }
    else
    {
      i = 0;
      j = 0;
      k = 0;
    }
    if (m == 0)
    {
      FMToastUtil.c(2131889423);
      return;
    }
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      QQToast.makeText(getBaseActivity(), 2131892157, 1).show(getResources().getDimensionPixelSize(2131299920));
      return;
    }
    if (i > 1)
    {
      b(getString(2131889417));
      return;
    }
    if (j != 0)
    {
      b(getString(2131889398));
      return;
    }
    if ((k != 0) && (this.t.size() > 1))
    {
      b(getString(2131889419));
      return;
    }
    v();
  }
  
  protected void s()
  {
    Object localObject = this.t;
    int i = 0;
    if (localObject != null) {
      i = 0 + ((ArrayList)localObject).size();
    }
    if (i == 0)
    {
      FMToastUtil.c(2131889423);
      return;
    }
    localObject = (ActionSheet)ActionSheetHelper.b(getBaseActivity(), null);
    ((ActionSheet)localObject).setMainTitle(2131893858);
    ((ActionSheet)localObject).addButton(getBaseActivity().getString(2131889261), 3);
    ((ActionSheet)localObject).addCancelButton(2131887648);
    ((ActionSheet)localObject).setOnButtonClickListener(new ChatHistoryMediaBaseFragment.1(this, (ActionSheet)localObject));
    ((ActionSheet)localObject).show();
  }
  
  protected void v() {}
  
  void w() {}
  
  void x() {}
  
  void y() {}
  
  void z() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryMediaBaseFragment
 * JD-Core Version:    0.7.0.1
 */