package com.tencent.mobileqq.activity.history;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.chathistory.SeparateForward;
import com.tencent.mobileqq.activity.history.helper.ChatHistoryItemSelectHelper;
import com.tencent.mobileqq.activity.history.tendoc.TencentDocItem;
import com.tencent.mobileqq.activity.history.widget.ChatHistorySelectBottomBar;
import com.tencent.mobileqq.activity.messagesearch.TenDocMessageSearchDialog;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.tendoc.TencentDocHistoryTabToastBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocHistoryTabToastProcessor;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TencentDocData;
import com.tencent.mobileqq.filemanager.data.FMConstants;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.QfileTimeUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.teamwork.TeamWorkHandlerUtils;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.XListView;
import cooperation.qqfav.QfavBuilder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class ChatHistoryBaseTenDocFragment
  extends ChatHistoryBaseFragment
  implements Handler.Callback
{
  private static final int[] s = { -2011, -5008, -1000 };
  private List<Object> A = new ArrayList();
  private long B = 9223372036854775807L;
  private long C = 9223372036854775807L;
  private long D = 9223372036854775807L;
  private int E = 3;
  private boolean F = false;
  private boolean G = true;
  private SeparateForward H;
  private MqqHandler I = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
  private SessionInfo J;
  private int K = 1;
  private int t;
  private Context u;
  private XListView v;
  private TextView w;
  private ChatHistoryBaseTenDocAdapter x;
  private View.OnClickListener y;
  private ChatHistoryBaseTenDocAdapter.SelectCheckCallback z;
  
  private String a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return "";
    }
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    Object localObject;
    if (UinTypeUtil.h(this.t))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(QfileTimeUtils.b(paramMessageRecord.time * 1000L));
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(localBaseApplicationImpl.getString(2131889294));
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(ContactUtils.a(this.a, paramMessageRecord.senderuin, this.e, 1, 0));
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(localBaseApplicationImpl.getString(2131889286));
      return ((StringBuilder)localObject).toString();
    }
    if (paramMessageRecord.isSend())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(localBaseApplicationImpl.getString(2131889329));
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(ContactUtils.a(this.a, paramMessageRecord.frienduin));
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(localBaseApplicationImpl.getString(2131889294));
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(ContactUtils.a(this.a, paramMessageRecord.senderuin));
      localObject = ((StringBuilder)localObject).toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(QfileTimeUtils.b(paramMessageRecord.time * 1000L));
    localStringBuilder.append(" ");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" ");
    localStringBuilder.append(localBaseApplicationImpl.getString(2131889286));
    return localStringBuilder.toString();
  }
  
  private String a(String paramString, MessageRecord paramMessageRecord)
  {
    if (UinTypeUtil.h(this.t))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append('\n');
      if (paramMessageRecord == null) {
        return localStringBuilder.toString();
      }
      paramString = ContactUtils.a(this.a, paramMessageRecord.senderuin, this.e, 1, 0);
      localStringBuilder.append(paramMessageRecord.senderuin);
      localStringBuilder.append('\n');
      localStringBuilder.append(paramString);
      localStringBuilder.append('\n');
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append('\n');
    if (paramMessageRecord == null) {
      return localStringBuilder.toString();
    }
    if (paramMessageRecord.isSend()) {
      paramString = paramMessageRecord.frienduin;
    } else {
      paramString = paramMessageRecord.senderuin;
    }
    paramMessageRecord = ContactUtils.a(this.a, paramString);
    localStringBuilder.append(paramString);
    localStringBuilder.append('\n');
    localStringBuilder.append(paramMessageRecord);
    localStringBuilder.append('\n');
    return localStringBuilder.toString();
  }
  
  private void a()
  {
    TenDocMessageSearchDialog localTenDocMessageSearchDialog = new TenDocMessageSearchDialog(getBaseActivity(), this.a, this.J, this.K);
    localTenDocMessageSearchDialog.a(this.A);
    localTenDocMessageSearchDialog.show();
  }
  
  private void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    paramView = (RelativeLayout)paramView.findViewById(2131445390);
    TextView localTextView = (TextView)paramView.findViewById(2131448724);
    EditText localEditText = (EditText)paramView.findViewById(2131432634);
    localTextView.setText(getString(2131887746));
    paramView.findViewById(2131429816).setVisibility(8);
    localEditText.setFocusableInTouchMode(false);
    localEditText.setCursorVisible(false);
    localEditText.setOnClickListener(this.y);
    paramView.setLayerType(0, null);
    this.J = new SessionInfo();
    this.J.b = this.e;
    paramView = this.J;
    paramView.a = this.t;
    paramView.H = new ChatBackground();
    this.J.r = ChatTextSizeSettingActivity.a(getBaseActivity());
  }
  
  private void a(TencentDocItem paramTencentDocItem, MessageRecord paramMessageRecord)
  {
    if (paramTencentDocItem != null)
    {
      if (paramMessageRecord == null) {
        return;
      }
      paramMessageRecord.saveExtInfoToExtStr("ten_doc_title", paramTencentDocItem.mTitle);
      paramMessageRecord.saveExtInfoToExtStr("ten_doc_icon", paramTencentDocItem.mIcon);
      paramMessageRecord.saveExtInfoToExtStr("ten_doc_url", paramTencentDocItem.mUrl);
    }
  }
  
  private void a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if (paramMessageRecord == null) {
      return;
    }
    paramMessageRecord.saveExtInfoToExtStr("ten_doc_is_ten_doc", String.valueOf(paramBoolean));
  }
  
  private void a(List<TencentDocItem> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      this.A.removeAll(paramList);
      if (!this.A.isEmpty())
      {
        this.A.add("");
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = this.A.iterator();
        Object localObject;
        for (paramList = null;; paramList = localObject)
        {
          if (!localIterator.hasNext()) {
            break label120;
          }
          localObject = localIterator.next();
          localArrayList.add(localObject);
          if (!(localObject instanceof String)) {
            break;
          }
          if (paramList != null) {
            localArrayList.remove(paramList);
          }
        }
        label120:
        if (!localArrayList.isEmpty()) {
          localArrayList.remove(localArrayList.size() - 1);
        }
        this.A.clear();
        this.A.addAll(localArrayList);
      }
      FMToastUtil.b(2131888446);
      this.x.notifyDataSetChanged();
      w();
    }
  }
  
  private void a(Map<String, List<TencentDocItem>> paramMap)
  {
    if (this.A != null)
    {
      if (paramMap == null) {
        return;
      }
      if (this.G) {
        this.G = false;
      }
      this.A.clear();
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        this.A.add(localObject);
        localObject = (List)paramMap.get(localObject);
        if (localObject != null) {
          this.A.addAll((Collection)localObject);
        }
      }
      w();
    }
  }
  
  private TencentDocItem b(MessageRecord paramMessageRecord)
  {
    Object localObject2 = null;
    if (paramMessageRecord == null) {
      return null;
    }
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      paramMessageRecord = (MessageForStructing)paramMessageRecord;
      if (paramMessageRecord.structingMsg != null)
      {
        if (TextUtils.isEmpty(paramMessageRecord.structingMsg.mMsgUrl)) {
          return null;
        }
        if (!FMConstants.a(paramMessageRecord.structingMsg.mMsgUrl)) {
          return null;
        }
        return c(paramMessageRecord.structingMsg.mMsgUrl);
      }
      return null;
    }
    Object localObject1;
    if ((paramMessageRecord instanceof MessageForArkApp))
    {
      paramMessageRecord = (MessageForArkApp)paramMessageRecord;
      localObject1 = paramMessageRecord.ark_app_message.metaList;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        return null;
      }
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        if (!((JSONObject)localObject1).has(paramMessageRecord.ark_app_message.appView)) {
          return null;
        }
        localObject1 = new JSONObject(((JSONObject)localObject1).getString(paramMessageRecord.ark_app_message.appView));
        String str = ((JSONObject)localObject1).optString("appid");
        paramMessageRecord = ((JSONObject)localObject1).optString("qqdocurl");
        if ((!TextUtils.isEmpty(str)) && (str.equals(String.valueOf(101458937L)))) {
          return c(((JSONObject)localObject1).getString("jumpUrl").replace("\\", ""));
        }
        localObject1 = localObject2;
        if (TextUtils.isEmpty(paramMessageRecord)) {
          return localObject1;
        }
        localObject1 = localObject2;
        if (!FMConstants.a(paramMessageRecord)) {
          return localObject1;
        }
        paramMessageRecord = c(paramMessageRecord);
        return paramMessageRecord;
      }
      catch (JSONException paramMessageRecord)
      {
        localObject1 = localObject2;
        if (!QLog.isColorLevel()) {
          return localObject1;
        }
      }
      QLog.e("ChatHistoryBaseTenDocFragment", 2, paramMessageRecord.getMessage());
      return null;
    }
    else
    {
      localObject1 = localObject2;
      if ((paramMessageRecord instanceof MessageForText))
      {
        paramMessageRecord = (MessageForText)paramMessageRecord;
        if (!FMConstants.a(paramMessageRecord.msg)) {
          return null;
        }
        localObject1 = c(paramMessageRecord.msg);
      }
    }
    return localObject1;
  }
  
  private void b()
  {
    TencentDocHistoryTabToastBean localTencentDocHistoryTabToastBean = TencentDocHistoryTabToastProcessor.a();
    if (localTencentDocHistoryTabToastBean.b())
    {
      QQToast.makeText(this.u, 2131917071, 1).show();
      return;
    }
    int i = this.a.getPreferences().getInt("key_tencent_doc_history_tab_tips_count", 0);
    if (i < localTencentDocHistoryTabToastBean.a())
    {
      QQToast.makeText(this.u, 2131917071, 1).show();
      this.a.getPreferences().edit().putInt("key_tencent_doc_history_tab_tips_count", i + 1).apply();
    }
  }
  
  private int c(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return -2;
    }
    paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("ten_doc_is_ten_doc");
    if (TextUtils.isEmpty(paramMessageRecord)) {
      return -1;
    }
    return Boolean.parseBoolean(paramMessageRecord) ^ true;
  }
  
  private TencentDocItem c(String paramString)
  {
    try
    {
      Object localObject1 = Uri.parse(paramString).buildUpon().clearQuery().build().toString();
      Object localObject2 = TeamWorkHandlerUtils.a((String)localObject1, this.e);
      if (((JSONObject)localObject2).getInt("retcode") != 0) {
        return null;
      }
      TencentDocData localTencentDocData = new TencentDocData();
      TencentDocData.obtainFromJsonObject((JSONObject)localObject2, null, localTencentDocData);
      if (QLog.isDevelopLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append(" ");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" fetch info: ");
        ((StringBuilder)localObject2).append(localTencentDocData.docIcon);
        ((StringBuilder)localObject2).append(" ");
        ((StringBuilder)localObject2).append(localTencentDocData.title);
        QLog.d("ChatHistoryBaseTenDocFragment", 4, ((StringBuilder)localObject2).toString());
      }
      if (TextUtils.isEmpty(localTencentDocData.title)) {
        return null;
      }
      localObject1 = new TencentDocItem();
      ((TencentDocItem)localObject1).mIcon = ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).getTDDocFileThumbUrl(paramString);
      ((TencentDocItem)localObject1).mTitle = localTencentDocData.title;
      ((TencentDocItem)localObject1).mUrl = paramString;
      return localObject1;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ChatHistoryBaseTenDocFragment", 2, paramString, new Object[0]);
      }
    }
    return null;
  }
  
  private Map<String, List<TencentDocItem>> c(boolean paramBoolean)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    List localList;
    if (paramBoolean)
    {
      localList = this.a.getMessageFacade().a(this.e, this.t, s, 2147483647);
    }
    else if (UinTypeUtil.h(this.t))
    {
      this.C -= 1L;
      localList = this.a.getMessageFacade().a(this.e, this.t, this.B, this.E, this.C, s, 2147483647);
    }
    else
    {
      localList = this.a.getMessageFacade().a(this.e, this.t, this.B, this.E, this.D, s, 2147483647);
    }
    if (localList != null)
    {
      if (localList.isEmpty()) {
        return localLinkedHashMap;
      }
      if (localList.size() < 2147483647) {
        this.F = true;
      }
      int j = localList.size() - 1;
      while (j >= 0)
      {
        Object localObject3 = (MessageRecord)localList.get(j);
        int i = c((MessageRecord)localObject3);
        Object localObject1 = null;
        Object localObject2;
        if (i != -1)
        {
          if (i != 0) {}
          do
          {
            i = 0;
            k = 0;
            break;
            localObject2 = d((MessageRecord)localObject3);
            localObject1 = localObject2;
          } while (localObject2 != null);
          localObject1 = b((MessageRecord)localObject3);
          i = 0;
        }
        else
        {
          localObject1 = b((MessageRecord)localObject3);
          i = 1;
        }
        int k = 1;
        if (localObject1 == null)
        {
          if ((i != 0) && (localObject3 != null)) {
            a((MessageRecord)localObject3, false);
          }
        }
        else
        {
          if (((MessageRecord)localObject3).shmsgseq < this.C) {
            this.C = ((MessageRecord)localObject3).shmsgseq;
          }
          if (((MessageRecord)localObject3).versionCode < this.E) {
            this.E = ((MessageRecord)localObject3).versionCode;
          }
          if ((((MessageRecord)localObject3).getId() > 0L) && (((MessageRecord)localObject3).getId() < this.B)) {
            this.B = ((MessageRecord)localObject3).getId();
          }
          if (((MessageRecord)localObject3).time < this.D) {
            this.D = ((MessageRecord)localObject3).time;
          }
          ((TencentDocItem)localObject1).mDescription = a((MessageRecord)localObject3);
          ((TencentDocItem)localObject1).mRecord = ((MessageRecord)localObject3);
          ((TencentDocItem)localObject1).mSearchWords = a(((TencentDocItem)localObject1).mTitle, (MessageRecord)localObject3);
          if (i != 0) {
            a((MessageRecord)localObject3, true);
          }
          if (k != 0) {
            a((TencentDocItem)localObject1, (MessageRecord)localObject3);
          }
          String str = QfileTimeUtils.a(((MessageRecord)localObject3).time * 1000L);
          localObject3 = (List)localLinkedHashMap.get(str);
          localObject2 = localObject3;
          if (localObject3 == null)
          {
            localObject2 = new ArrayList();
            localLinkedHashMap.put(str, localObject2);
          }
          ((List)localObject2).add(localObject1);
        }
        j -= 1;
      }
    }
    return localLinkedHashMap;
  }
  
  private TencentDocItem d(MessageRecord paramMessageRecord)
  {
    Object localObject = null;
    if (paramMessageRecord == null) {
      return null;
    }
    String str1 = paramMessageRecord.getExtInfoFromExtStr("ten_doc_title");
    String str2 = paramMessageRecord.getExtInfoFromExtStr("ten_doc_icon");
    String str3 = paramMessageRecord.getExtInfoFromExtStr("ten_doc_url");
    paramMessageRecord = localObject;
    if (!TextUtils.isEmpty(str1))
    {
      paramMessageRecord = localObject;
      if (!TextUtils.isEmpty(str2))
      {
        if (TextUtils.isEmpty(str3)) {
          return null;
        }
        paramMessageRecord = new TencentDocItem();
        paramMessageRecord.mUrl = str3;
        paramMessageRecord.mIcon = str2;
        paramMessageRecord.mTitle = str1;
      }
    }
    return paramMessageRecord;
  }
  
  private void v()
  {
    if (this.y == null) {
      this.y = new ChatHistoryBaseTenDocFragment.2(this);
    }
    if (this.z == null) {
      this.z = new ChatHistoryBaseTenDocFragment.3(this);
    }
    ((ITeamWorkUtilsTemp)QRoute.api(ITeamWorkUtilsTemp.class)).configHistoryTabEmptyTips(this.w, new ChatHistoryBaseTenDocFragment.4(this));
  }
  
  private void w()
  {
    boolean bool2 = this.A.isEmpty();
    boolean bool1 = false;
    if (bool2)
    {
      if (this.v.getVisibility() != 8) {
        ReportController.b(this.a, "dc00898", "", "", "0X800A169", "0X800A169", this.K, 0, "", "", "s_qq_history_tab", "");
      }
      this.v.setVisibility(8);
      this.w.setVisibility(0);
    }
    else
    {
      this.v.setVisibility(0);
      this.w.setVisibility(8);
    }
    if (this.x != null)
    {
      ChatHistoryBaseViewController localChatHistoryBaseViewController = this.g;
      if (this.x.getCount() != 0) {
        bool1 = true;
      }
      localChatHistoryBaseViewController.a(this, bool1);
    }
  }
  
  private void x()
  {
    ThreadManager.excute(new ChatHistoryBaseTenDocFragment.5(this), 128, null, false);
  }
  
  private List<TencentDocItem> y()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.j.b();
    if (localObject1 == null) {
      return localArrayList;
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if ((localObject2 instanceof TencentDocItem)) {
        localArrayList.add((TencentDocItem)localObject2);
      }
    }
    return localArrayList;
  }
  
  void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1121) {
      b();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (paramBoolean) {
      ReportController.b(this.a, "dc00898", "", "", "0X800A168", "0X800A168", this.K, 0, "", "", "s_qq_history_tab", "");
    }
  }
  
  void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    ChatHistoryBaseTenDocAdapter localChatHistoryBaseTenDocAdapter = this.x;
    if (localChatHistoryBaseTenDocAdapter != null) {
      localChatHistoryBaseTenDocAdapter.a(paramBoolean);
    }
  }
  
  protected void c() {}
  
  protected void d() {}
  
  protected void h()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(2));
    localArrayList.add(Integer.valueOf(5));
    localArrayList.add(Integer.valueOf(4));
    this.h.a(localArrayList);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1234)
    {
      if (i == 5678)
      {
        if ((paramMessage.obj instanceof List)) {
          a((List)paramMessage.obj);
        }
        ReportController.b(this.a, "dc00898", "", "", "0X800A172", "0X800A172", this.K, 0, "", "", "s_qq_history_tab", "");
      }
    }
    else if ((paramMessage.obj instanceof Map)) {
      a((Map)paramMessage.obj);
    }
    return true;
  }
  
  public void i()
  {
    super.i();
    w();
  }
  
  public void j()
  {
    super.j();
    m();
    ChatHistoryBaseTenDocAdapter localChatHistoryBaseTenDocAdapter = this.x;
    if (localChatHistoryBaseTenDocAdapter != null) {
      localChatHistoryBaseTenDocAdapter.notifyDataSetChanged();
    }
  }
  
  protected int l()
  {
    return 1602;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.u = getBaseActivity();
    paramBundle = getBaseActivity().getIntent().getExtras();
    if (paramBundle != null) {
      this.t = paramBundle.getInt("uintype");
    } else {
      this.t = 1;
    }
    if (UinTypeUtil.h(this.t)) {
      this.K = 2;
    } else {
      this.K = 1;
    }
    paramLayoutInflater = (RelativeLayout)paramLayoutInflater.inflate(2131624475, paramViewGroup, false);
    this.w = ((TextView)paramLayoutInflater.findViewById(2131448546));
    this.v = ((XListView)paramLayoutInflater.findViewById(2131446442));
    this.w.setVisibility(0);
    this.v.setCacheColorHint(0);
    this.H = new SeparateForward(getBaseActivity(), 9101);
    this.H.a();
    v();
    this.x = new ChatHistoryBaseTenDocAdapter(this.u);
    this.x.a(this.A);
    this.x.a(this.y);
    this.x.a(this.z);
    this.v.setAdapter(this.x);
    a(paramLayoutInflater);
    w();
    x();
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    ReportController.b(this.a, "dc00898", "", "", "0X800A167", "0X800A167", this.K, 0, "", "", "s_qq_history_tab", "");
  }
  
  protected void r()
  {
    super.r();
    Object localObject = y();
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      ArrayList localArrayList = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MessageRecord localMessageRecord = ((TencentDocItem)((Iterator)localObject).next()).mRecord;
        if ((localMessageRecord instanceof ChatMessage)) {
          localArrayList.add((ChatMessage)localMessageRecord);
        }
      }
      this.H.a(localArrayList);
      m();
      ReportController.b(this.a, "dc00898", "", "", "0X800A173", "0X800A173", this.K, 0, "", "", "s_qq_history_tab", "");
      return;
    }
    FMToastUtil.c(2131887735);
  }
  
  protected void s()
  {
    super.s();
    if (y().isEmpty())
    {
      FMToastUtil.c(2131887735);
      return;
    }
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(getBaseActivity(), null);
    localActionSheet.setMainTitle(2131893858);
    localActionSheet.addButton(getString(2131889261), 3);
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnButtonClickListener(new ChatHistoryBaseTenDocFragment.1(this, localActionSheet));
    localActionSheet.show();
  }
  
  protected void t()
  {
    super.t();
    Object localObject = y();
    if (localObject != null)
    {
      if (((List)localObject).size() == 0) {
        return;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        TencentDocItem localTencentDocItem = (TencentDocItem)((Iterator)localObject).next();
        String str = this.a.getAccount();
        QfavBuilder.a(localTencentDocItem.mUrl).c(str).a(this.d, str);
      }
      m();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryBaseTenDocFragment
 * JD-Core Version:    0.7.0.1
 */