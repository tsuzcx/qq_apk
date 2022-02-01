package com.tencent.mobileqq.activity.history;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.MsgRevokeListener;
import com.tencent.mobileqq.activity.ChatHistoryEmotionView;
import com.tencent.mobileqq.activity.ChatHistoryEmotionView.OperateCallBack;
import com.tencent.mobileqq.activity.ChatHistoryFileActivity.OnWyDialogClick;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryMsgRevokeMgr;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.chathistory.SeparateForward;
import com.tencent.mobileqq.activity.history.widget.ChatHistorySelectBottomBar;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.EmoticonObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.emosm.api.IEmoBatchAddedHandlerApi;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emosm.favroaming.IEmoBatchAddedCallback;
import com.tencent.mobileqq.emosm.favroaming.IEmoBatchAddedHandler;
import com.tencent.mobileqq.emoticon.EmoticonOperateReport;
import com.tencent.mobileqq.emoticon.IChatHistoryEmotionBaseFragment;
import com.tencent.mobileqq.emoticon.IEmojiListenerManager;
import com.tencent.mobileqq.emoticon.api.EmojiManagerServiceConstant;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.emotionintegrate.ChatHistoryEmotionAdapter;
import com.tencent.mobileqq.emotionintegrate.EmotionDataManager;
import com.tencent.mobileqq.emotionintegrate.EmotionPreviewData;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.multimsg.save.FileSaveDialog;
import com.tencent.mobileqq.multimsg.save.FileSaveReq;
import com.tencent.mobileqq.multimsg.save.MultiRichMediaSaveManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.weiyun.api.IWeiyunResponseHandler;
import com.tencent.mobileqq.weiyun.api.IWeiyunSaveTipsHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class ChatHistoryEmotionBaseFragment
  extends ChatHistoryBaseFragment
  implements Handler.Callback, MsgRevokeListener, ChatHistoryEmotionView.OperateCallBack, IChatHistoryEmotionBaseFragment
{
  ChatHistoryEmotionView s;
  protected final MqqHandler t = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
  private List<EmotionPreviewData> u;
  private QQCustomDialog v;
  private SeparateForward w;
  private List<URLDrawable> x = new ArrayList();
  private IEmoBatchAddedHandler y;
  private EmoticonObserver z = new ChatHistoryEmotionBaseFragment.4(this);
  
  private static void a(IPicEmoticonInfo paramIPicEmoticonInfo, Emoticon paramEmoticon, QQAppInterface paramQQAppInterface, IEmoBatchAddedCallback paramIEmoBatchAddedCallback)
  {
    ChatHistoryEmotionBaseFragment.EmoticonDetailJsonDownloader localEmoticonDetailJsonDownloader = new ChatHistoryEmotionBaseFragment.EmoticonDetailJsonDownloader(null);
    if ((paramIPicEmoticonInfo != null) && (paramEmoticon != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoBatchAdded", 1, "startDownloadEmoticonJson");
      }
      localEmoticonDetailJsonDownloader.a(paramQQAppInterface, paramIPicEmoticonInfo, paramIEmoBatchAddedCallback);
      paramIPicEmoticonInfo = (IEmojiManagerService)paramQQAppInterface.getRuntimeService(IEmojiManagerService.class);
      paramIPicEmoticonInfo.getEmojiListenerManager().addEmotionJsonDownloadListener(localEmoticonDetailJsonDownloader);
      paramIPicEmoticonInfo.startDownloadEmosmJson(paramEmoticon.epId, EmojiManagerServiceConstant.JSON_EMOSM_MALL);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoBatchAdded", 1, "error in json downloading");
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, ChatHistoryFileActivity.OnWyDialogClick paramOnWyDialogClick)
  {
    QQCustomDialog localQQCustomDialog = this.v;
    if ((localQQCustomDialog != null) && (localQQCustomDialog.isShowing())) {
      this.v.dismiss();
    }
    localQQCustomDialog = new QQCustomDialog(getBaseActivity(), 2131953338);
    localQQCustomDialog.setContentView(2131624611);
    this.v = localQQCustomDialog;
    this.v.setTitle(paramString1);
    this.v.setMessage(paramString2);
    paramString1 = paramString4;
    if (TextUtils.isEmpty(paramString4)) {
      paramString1 = getString(2131887648);
    }
    paramString2 = paramString3;
    if (TextUtils.isEmpty(paramString3)) {
      paramString2 = getString(2131888010);
    }
    this.v.setNegativeButton(paramString1, new ChatHistoryEmotionBaseFragment.6(this, paramOnWyDialogClick));
    this.v.setPositiveButton(paramString2, new ChatHistoryEmotionBaseFragment.7(this, paramOnWyDialogClick));
    this.v.setCancelable(true);
    this.v.setCanceledOnTouchOutside(false);
    this.v.show();
  }
  
  private static void a(List<EmotionPreviewData> paramList, QQAppInterface paramQQAppInterface, List<URLDrawable> paramList1, IEmoBatchAddedHandler paramIEmoBatchAddedHandler)
  {
    ThreadManagerV2.executeOnSubThread(new ChatHistoryEmotionBaseFragment.3(paramList, paramIEmoBatchAddedHandler, paramQQAppInterface, paramList1));
  }
  
  private static void b(QQAppInterface paramQQAppInterface, IEmoBatchAddedHandler paramIEmoBatchAddedHandler, EmotionPreviewData paramEmotionPreviewData, int paramInt, IEmoBatchAddedCallback paramIEmoBatchAddedCallback)
  {
    paramEmotionPreviewData = EmotionDataManager.a((MessageForMarketFace)paramEmotionPreviewData.a);
    if (paramEmotionPreviewData == null)
    {
      paramIEmoBatchAddedHandler.b(3);
      return;
    }
    Emoticon localEmoticon = paramEmotionPreviewData.getEmoticon();
    if (localEmoticon == null)
    {
      paramIEmoBatchAddedHandler.b(3);
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(localEmoticon.epId);
    ((StringBuilder)localObject).append(localEmoticon.eId);
    localObject = ((StringBuilder)localObject).toString();
    if (paramIEmoBatchAddedHandler.a((String)localObject))
    {
      paramIEmoBatchAddedHandler.b(2);
      return;
    }
    paramIEmoBatchAddedHandler.a((String)localObject, Integer.valueOf(paramInt));
    paramIEmoBatchAddedHandler = ((IEmoticonManagerService)paramQQAppInterface.getRuntimeService(IEmoticonManagerService.class)).syncFindEmoticonPackageById(localEmoticon.epId, 0);
    if ((paramIEmoBatchAddedHandler != null) && (paramIEmoBatchAddedHandler.name != null) && ((paramIEmoBatchAddedHandler.mobileFeetype != 0) || (paramIEmoBatchAddedHandler.downloadCount != 0)))
    {
      paramInt = paramQQAppInterface.getPreferences().getInt("emosm_json_last_download_timestamp", 0);
      int i = (int)(System.currentTimeMillis() / 1000L);
      if ((i - paramInt <= 86400) && (i >= paramInt)) {
        MarketFaceItemBuilder.a(paramQQAppInterface, paramIEmoBatchAddedHandler, paramEmotionPreviewData, paramIEmoBatchAddedCallback);
      } else {
        a(paramEmotionPreviewData, localEmoticon, paramQQAppInterface, paramIEmoBatchAddedCallback);
      }
    }
    else
    {
      a(paramEmotionPreviewData, localEmoticon, paramQQAppInterface, paramIEmoBatchAddedCallback);
    }
    EmoticonOperateReport.reportFavAddEmotionEvent(paramQQAppInterface, 2, null, localEmoticon.eId);
  }
  
  private static void b(QQAppInterface paramQQAppInterface, IEmoBatchAddedHandler paramIEmoBatchAddedHandler, EmotionPreviewData paramEmotionPreviewData, int paramInt, IEmoBatchAddedCallback paramIEmoBatchAddedCallback, List<URLDrawable> paramList)
  {
    Object localObject = URLDrawableHelper.getURL((MessageForPic)paramEmotionPreviewData.a, 1);
    if (paramIEmoBatchAddedHandler.a(((URL)localObject).toString()))
    {
      paramIEmoBatchAddedHandler.b(2);
      return;
    }
    paramIEmoBatchAddedHandler.a(((URL)localObject).toString(), Integer.valueOf(paramInt));
    localObject = URLDrawableHelper.getDrawable((URL)localObject, -1, -1, null, null, false);
    ((URLDrawable)localObject).setTag(paramEmotionPreviewData.a);
    paramList.add(localObject);
    paramInt = paramIEmoBatchAddedHandler.a(Integer.valueOf(paramInt));
    paramInt = AIOGalleryUtils.a(paramQQAppInterface, (URLDrawable)localObject, ((MessageForPic)paramEmotionPreviewData.a).picExtraData, paramIEmoBatchAddedCallback, paramInt);
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return;
        }
        paramIEmoBatchAddedHandler.b(2);
        return;
      }
      paramIEmoBatchAddedHandler.b(3);
      return;
    }
    paramIEmoBatchAddedHandler.b(4);
  }
  
  public int A()
  {
    return getResources().getDimensionPixelSize(2131299920);
  }
  
  public void a(long paramLong)
  {
    ChatHistoryEmotionView localChatHistoryEmotionView = this.s;
    if (localChatHistoryEmotionView != null) {
      localChatHistoryEmotionView.a(paramLong);
    }
  }
  
  public void a(EmotionPreviewData paramEmotionPreviewData)
  {
    if (this.u == null) {
      this.u = new ArrayList();
    }
    this.u.add(paramEmotionPreviewData);
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (this.b)
    {
      ChatHistoryEmotionView localChatHistoryEmotionView = this.s;
      if ((localChatHistoryEmotionView != null) && (localChatHistoryEmotionView.c())) {
        this.s.b();
      }
    }
  }
  
  public boolean a()
  {
    List localList = this.u;
    boolean bool = false;
    int i;
    if (localList != null) {
      i = localList.size() + 0;
    } else {
      i = 0;
    }
    if (i >= 20) {
      bool = true;
    }
    if (bool)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.BaseFragment", 2, "isOverLimit");
      }
      FMToastUtil.a(2131889426);
    }
    return bool;
  }
  
  public void b()
  {
    ChatHistoryEmotionView localChatHistoryEmotionView = this.s;
    if ((localChatHistoryEmotionView != null) && (localChatHistoryEmotionView.a != null) && (this.s.a.getCount() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.BaseFragment", 2, "onEmotionLoaded, mEmotionView.mAdapter is null");
      }
      this.g.a(this, false);
      return;
    }
    this.g.a(this, true);
  }
  
  public void b(EmotionPreviewData paramEmotionPreviewData)
  {
    List localList = this.u;
    if (localList == null) {
      return;
    }
    localList.remove(paramEmotionPreviewData);
  }
  
  void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      z();
      ReportController.b(null, "dc00898", "", "", "0X800B720", "0X800B720", 0, 0, "", "", "", "");
      y();
      return;
    }
    changeToUnSelected();
  }
  
  protected void c() {}
  
  public void changeToUnSelected()
  {
    Object localObject = this.s;
    if (localObject != null) {
      ((ChatHistoryEmotionView)localObject).h();
    }
    localObject = this.u;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = this.u.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((EmotionPreviewData)((Iterator)localObject).next()).b = false;
      }
      this.u.clear();
    }
    m();
  }
  
  protected void d() {}
  
  protected void h()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(1));
    localArrayList.add(Integer.valueOf(2));
    localArrayList.add(Integer.valueOf(4));
    localArrayList.add(Integer.valueOf(5));
    this.h.a(localArrayList);
  }
  
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
        if (this.l != null) {
          this.l.dismiss();
        }
        changeToUnSelected();
        return true;
      case 101: 
        if (this.l != null) {
          this.l.dismiss();
        }
        changeToUnSelected();
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
          ChatHistoryEmotionBaseFragment.5 local5 = new ChatHistoryEmotionBaseFragment.5(this);
          a(getString(2131896694), paramMessage, null, null, local5);
          return true;
        }
        paramMessage = (String)paramMessage.obj;
        QQToast.makeText(this.a.getApp(), paramMessage, 1).show(A());
        return true;
      case 100: 
        if (this.l != null) {
          this.l.dismiss();
        }
        ((IWeiyunSaveTipsHelper)QRoute.api(IWeiyunSaveTipsHelper.class)).showTopTips(this.a, getBaseActivity(), A());
        changeToUnSelected();
        return true;
      }
    }
    else
    {
      paramMessage = this.s;
      if (paramMessage != null) {
        paramMessage.j();
      }
      changeToUnSelected();
      v();
    }
    return true;
  }
  
  public void i()
  {
    if (this.g == null) {
      return;
    }
    super.i();
    changeToUnSelected();
    ChatHistoryEmotionView localChatHistoryEmotionView = this.s;
    if (localChatHistoryEmotionView != null) {
      localChatHistoryEmotionView.d();
    }
    localChatHistoryEmotionView = this.s;
    if ((localChatHistoryEmotionView != null) && (localChatHistoryEmotionView.a != null) && (this.s.a.getCount() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.BaseFragment", 2, "doOnResume, mEmotionView.mAdapter is null");
      }
      this.g.a(this, false);
      return;
    }
    this.g.a(this, true);
  }
  
  public void k()
  {
    super.k();
    AIOGalleryMsgRevokeMgr.a().b(this);
    Object localObject = this.s;
    if (localObject != null) {
      ((ChatHistoryEmotionView)localObject).f();
    }
    localObject = this.w;
    if (localObject != null) {
      ((SeparateForward)localObject).b();
    }
    this.a.removeObserver(this.z);
    if (!this.x.isEmpty())
    {
      localObject = this.x.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((URLDrawable)((Iterator)localObject).next()).setTag(null);
      }
    }
  }
  
  protected int l()
  {
    return 1602;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    AIOGalleryMsgRevokeMgr.a().a(this);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if ((this.s == null) && (this.d != null))
    {
      this.s = new ChatHistoryEmotionView();
      this.s.a(this.d.getIntent(), this.a, this.d);
      this.s.b = this;
    }
    if (this.a != null) {
      this.a.addObserver(this.z);
    }
    this.y = ((IEmoBatchAddedHandlerApi)QRoute.api(IEmoBatchAddedHandlerApi.class)).createEmoBatchAddedHandler(this, this.a);
    paramLayoutInflater = this.s.a();
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onPause()
  {
    super.onPause();
    ChatHistoryEmotionView localChatHistoryEmotionView = this.s;
    if (localChatHistoryEmotionView != null) {
      localChatHistoryEmotionView.e();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    ChatHistoryEmotionView localChatHistoryEmotionView = this.s;
    if (localChatHistoryEmotionView != null) {
      localChatHistoryEmotionView.d();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.h.a(2130839437);
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
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.u;
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      localObject1 = this.u.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (EmotionPreviewData)((Iterator)localObject1).next();
        if ((((EmotionPreviewData)localObject2).a instanceof MessageForPic)) {
          localArrayList.add(FileSaveReq.a((MessageForPic)((EmotionPreviewData)localObject2).a));
        }
      }
      ReportController.b(null, "dc00898", "", "", "0X800B722", "0X800B722", this.u.size(), 0, "", "", "", "");
      localObject1 = new FileSaveDialog(getBaseActivity());
      Object localObject2 = (MultiRichMediaSaveManager)this.a.getManager(QQManagerFactory.MULTI_CHOOSE_SAVE_MANAGER);
      ((MultiRichMediaSaveManager)localObject2).a(new ChatHistoryEmotionBaseFragment.1(this, (FileSaveDialog)localObject1, (MultiRichMediaSaveManager)localObject2, localArrayList));
      ((MultiRichMediaSaveManager)localObject2).a(localArrayList, true);
      ((MultiRichMediaSaveManager)localObject2).a(localArrayList, 1, 5);
      x();
      return;
    }
    FMToastUtil.c(2131889423);
  }
  
  protected void r()
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      QQToast.makeText(getBaseActivity(), 2131892157, 1).show(getResources().getDimensionPixelSize(2131299920));
      return;
    }
    Object localObject = this.u;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      ReportController.b(null, "dc00898", "", "", "0X800B721", "0X800B721", this.u.size(), 0, "", "", "", "");
      localObject = new ArrayList();
      Iterator localIterator = this.u.iterator();
      while (localIterator.hasNext()) {
        ((List)localObject).add((ChatMessage)((EmotionPreviewData)localIterator.next()).a);
      }
      if (this.w == null)
      {
        this.w = new SeparateForward(getBaseActivity(), 3);
        this.w.a();
      }
      this.w.a((List)localObject);
      w();
      return;
    }
    FMToastUtil.c(2131889423);
  }
  
  protected void s()
  {
    Object localObject = this.u;
    int i;
    if (localObject != null) {
      i = 0 + ((List)localObject).size();
    } else {
      i = 0;
    }
    if (i == 0)
    {
      FMToastUtil.c(2131889423);
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X800B723", "0X800B723", i, 0, "", "", "", "");
    localObject = (ActionSheet)ActionSheetHelper.b(getBaseActivity(), null);
    ((ActionSheet)localObject).setMainTitle(2131893858);
    ((ActionSheet)localObject).addButton(getBaseActivity().getString(2131889261), 3);
    ((ActionSheet)localObject).addCancelButton(2131887648);
    ((ActionSheet)localObject).setOnButtonClickListener(new ChatHistoryEmotionBaseFragment.2(this, (ActionSheet)localObject));
    ((ActionSheet)localObject).show();
  }
  
  protected void t()
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      QQToast.makeText(getBaseActivity(), 2131892157, 1).show(getResources().getDimensionPixelSize(2131299920));
      return;
    }
    a(this.u, this.a, this.x, this.y);
  }
  
  void v() {}
  
  void w() {}
  
  void x() {}
  
  void y() {}
  
  protected void z()
  {
    ChatHistoryEmotionView localChatHistoryEmotionView = this.s;
    if (localChatHistoryEmotionView != null) {
      localChatHistoryEmotionView.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryEmotionBaseFragment
 * JD-Core Version:    0.7.0.1
 */