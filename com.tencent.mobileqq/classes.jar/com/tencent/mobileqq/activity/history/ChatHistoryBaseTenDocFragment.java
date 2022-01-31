package com.tencent.mobileqq.activity.history;

import acuv;
import afck;
import afwa;
import afwc;
import afwd;
import afwe;
import afwf;
import afwg;
import afwh;
import agbf;
import agbs;
import agfg;
import akpv;
import anby;
import anbz;
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
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import apef;
import aptv;
import apvu;
import axqw;
import ayfe;
import ayfv;
import bbcl;
import bcpw;
import bfmt;
import bfol;
import bfoy;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.history.tendoc.TencentDocItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TencentDocData;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
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
  private static final int[] jdField_a_of_type_ArrayOfInt = { -2011, -5008, -1000 };
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 9223372036854775807L;
  private afck jdField_a_of_type_Afck;
  private afwa jdField_a_of_type_Afwa;
  private afwc jdField_a_of_type_Afwc;
  private Context jdField_a_of_type_AndroidContentContext;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private List<Object> jdField_a_of_type_JavaUtilList = new ArrayList();
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new bfmt(Looper.getMainLooper(), this, true);
  private int jdField_b_of_type_Int = 3;
  private long jdField_b_of_type_Long = 9223372036854775807L;
  private int jdField_c_of_type_Int = 1;
  private long jdField_c_of_type_Long = 9223372036854775807L;
  private boolean d;
  private boolean e = true;
  
  private int a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return -2;
    }
    paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("ten_doc_is_ten_doc");
    if (TextUtils.isEmpty(paramMessageRecord)) {
      return -1;
    }
    if (Boolean.parseBoolean(paramMessageRecord)) {
      return 0;
    }
    return 1;
  }
  
  private TencentDocItem a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    label225:
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return null;
            if ((paramMessageRecord instanceof MessageForStructing))
            {
              paramMessageRecord = (MessageForStructing)paramMessageRecord;
              if ((paramMessageRecord.structingMsg != null) && (!TextUtils.isEmpty(paramMessageRecord.structingMsg.mMsgUrl)) && (apef.a(paramMessageRecord.structingMsg.mMsgUrl))) {
                return a(paramMessageRecord.structingMsg.mMsgUrl);
              }
            }
            else
            {
              if (!(paramMessageRecord instanceof MessageForArkApp)) {
                break label225;
              }
              paramMessageRecord = (MessageForArkApp)paramMessageRecord;
              Object localObject = paramMessageRecord.ark_app_message.metaList;
              if (!TextUtils.isEmpty((CharSequence)localObject)) {
                try
                {
                  localObject = new JSONObject((String)localObject);
                  if (((JSONObject)localObject).has(paramMessageRecord.ark_app_message.appView))
                  {
                    paramMessageRecord = new JSONObject(((JSONObject)localObject).getString(paramMessageRecord.ark_app_message.appView));
                    localObject = paramMessageRecord.optString("appid");
                    String str = paramMessageRecord.optString("qqdocurl");
                    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals(String.valueOf(ayfv.jdField_a_of_type_Long)))) {
                      return a(paramMessageRecord.getString("jumpUrl").replace("\\", ""));
                    }
                    if ((!TextUtils.isEmpty(str)) && (apef.a(str)))
                    {
                      paramMessageRecord = a(str);
                      return paramMessageRecord;
                    }
                  }
                }
                catch (JSONException paramMessageRecord) {}
              }
            }
          }
        } while (!QLog.isColorLevel());
        QLog.e("ChatHistoryBaseTenDocFragment", 2, paramMessageRecord.getMessage());
        return null;
      } while (!(paramMessageRecord instanceof MessageForText));
      paramMessageRecord = (MessageForText)paramMessageRecord;
    } while (!apef.a(paramMessageRecord.msg));
    return a(paramMessageRecord.msg);
  }
  
  private TencentDocItem a(String paramString)
  {
    try
    {
      Object localObject = Uri.parse(paramString).buildUpon().clearQuery().build().toString();
      JSONObject localJSONObject = ayfe.a((String)localObject, this.jdField_a_of_type_JavaLangString);
      if (localJSONObject.getInt("retcode") != 0) {
        return null;
      }
      TencentDocData localTencentDocData = new TencentDocData();
      TencentDocData.obtainFromJsonObject(localJSONObject, null, localTencentDocData);
      if (QLog.isDevelopLevel()) {
        QLog.d("ChatHistoryBaseTenDocFragment", 4, paramString + " " + (String)localObject + " fetch info: " + localTencentDocData.docIcon + " " + localTencentDocData.title);
      }
      if (!TextUtils.isEmpty(localTencentDocData.title))
      {
        localObject = new TencentDocItem();
        ((TencentDocItem)localObject).mIcon = ayfv.f(paramString);
        ((TencentDocItem)localObject).mTitle = localTencentDocData.title;
        ((TencentDocItem)localObject).mUrl = paramString;
        return localObject;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ChatHistoryBaseTenDocFragment", 2, paramString, new Object[0]);
      }
    }
    return null;
  }
  
  private String a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return "";
    }
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (akpv.a(this.jdField_a_of_type_Int)) {
      return apvu.b(paramMessageRecord.time * 1000L) + " " + localBaseApplicationImpl.getString(2131692441) + " " + bbcl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord.senderuin, this.jdField_a_of_type_JavaLangString, 1, 0) + " " + localBaseApplicationImpl.getString(2131692432);
    }
    if (paramMessageRecord.isSend()) {}
    for (String str = localBaseApplicationImpl.getString(2131692474) + " " + bbcl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord.frienduin);; str = localBaseApplicationImpl.getString(2131692441) + " " + bbcl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord.senderuin)) {
      return apvu.b(paramMessageRecord.time * 1000L) + " " + str + " " + localBaseApplicationImpl.getString(2131692432);
    }
  }
  
  private String a(String paramString, MessageRecord paramMessageRecord)
  {
    if (akpv.a(this.jdField_a_of_type_Int))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString).append('\n');
      if (paramMessageRecord == null) {
        return localStringBuilder.toString();
      }
      paramString = bbcl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord.senderuin, this.jdField_a_of_type_JavaLangString, 1, 0);
      localStringBuilder.append(paramMessageRecord.senderuin).append('\n');
      localStringBuilder.append(paramString).append('\n');
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString).append('\n');
    if (paramMessageRecord == null) {
      return localStringBuilder.toString();
    }
    if (paramMessageRecord.isSend()) {}
    for (paramString = paramMessageRecord.frienduin;; paramString = paramMessageRecord.senderuin)
    {
      paramMessageRecord = bbcl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
      localStringBuilder.append(paramString).append('\n');
      localStringBuilder.append(paramMessageRecord).append('\n');
      return localStringBuilder.toString();
    }
  }
  
  private List<TencentDocItem> a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.jdField_a_of_type_Agbf.a();
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
  
  private Map<String, List<TencentDocItem>> a(boolean paramBoolean)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    List localList1;
    if (paramBoolean) {
      localList1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, jdField_a_of_type_ArrayOfInt, 2147483647);
    }
    while ((localList1 == null) || (localList1.isEmpty()))
    {
      return localLinkedHashMap;
      if (akpv.a(this.jdField_a_of_type_Int))
      {
        this.jdField_b_of_type_Long -= 1L;
        localList1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long, this.jdField_b_of_type_Int, this.jdField_b_of_type_Long, jdField_a_of_type_ArrayOfInt, 2147483647);
      }
      else
      {
        localList1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long, this.jdField_b_of_type_Int, this.jdField_c_of_type_Long, jdField_a_of_type_ArrayOfInt, 2147483647);
      }
    }
    if (localList1.size() < 2147483647) {
      this.d = true;
    }
    int k = localList1.size() - 1;
    Object localObject;
    int j;
    TencentDocItem localTencentDocItem;
    int i;
    if (k >= 0)
    {
      localObject = (MessageRecord)localList1.get(k);
      switch (a((MessageRecord)localObject))
      {
      default: 
        j = 0;
        localTencentDocItem = null;
        i = 0;
      }
    }
    for (;;)
    {
      label243:
      if (localTencentDocItem == null) {
        if ((i != 0) && (localObject != null)) {
          a((MessageRecord)localObject, false);
        }
      }
      for (;;)
      {
        k -= 1;
        break;
        localTencentDocItem = a((MessageRecord)localObject);
        j = 1;
        i = 1;
        break label243;
        localTencentDocItem = b((MessageRecord)localObject);
        if (localTencentDocItem != null) {
          break label544;
        }
        localTencentDocItem = a((MessageRecord)localObject);
        j = 1;
        i = 0;
        break label243;
        if (((MessageRecord)localObject).shmsgseq < this.jdField_b_of_type_Long) {
          this.jdField_b_of_type_Long = ((MessageRecord)localObject).shmsgseq;
        }
        if (((MessageRecord)localObject).versionCode < this.jdField_b_of_type_Int) {
          this.jdField_b_of_type_Int = ((MessageRecord)localObject).versionCode;
        }
        if ((((MessageRecord)localObject).getId() > 0L) && (((MessageRecord)localObject).getId() < this.jdField_a_of_type_Long)) {
          this.jdField_a_of_type_Long = ((MessageRecord)localObject).getId();
        }
        if (((MessageRecord)localObject).time < this.jdField_c_of_type_Long) {
          this.jdField_c_of_type_Long = ((MessageRecord)localObject).time;
        }
        localTencentDocItem.mDescription = a((MessageRecord)localObject);
        localTencentDocItem.mRecord = ((MessageRecord)localObject);
        localTencentDocItem.mSearchWords = a(localTencentDocItem.mTitle, (MessageRecord)localObject);
        if (i != 0) {
          a((MessageRecord)localObject, true);
        }
        if (j != 0) {
          a(localTencentDocItem, (MessageRecord)localObject);
        }
        String str = apvu.a(((MessageRecord)localObject).time * 1000L);
        List localList2 = (List)localLinkedHashMap.get(str);
        localObject = localList2;
        if (localList2 == null)
        {
          localObject = new ArrayList();
          localLinkedHashMap.put(str, localObject);
        }
        ((List)localObject).add(localTencentDocItem);
      }
      return localLinkedHashMap;
      label544:
      j = 0;
      i = 0;
    }
  }
  
  private void a()
  {
    agfg localagfg = new agfg(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_c_of_type_Int);
    localagfg.a(this.jdField_a_of_type_JavaUtilList);
    localagfg.show();
  }
  
  private void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    paramView = (RelativeLayout)paramView.findViewById(2131375676);
    TextView localTextView = (TextView)paramView.findViewById(2131378334);
    EditText localEditText = (EditText)paramView.findViewById(2131365764);
    localTextView.setText(getString(2131690738));
    paramView.findViewById(2131363480).setVisibility(8);
    localEditText.setFocusableInTouchMode(false);
    localEditText.setCursorVisible(false);
    localEditText.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    paramView.setLayerType(0, null);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Acuv = new acuv();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int = ChatTextSizeSettingActivity.a(getActivity());
  }
  
  private void a(TencentDocItem paramTencentDocItem, MessageRecord paramMessageRecord)
  {
    if ((paramTencentDocItem == null) || (paramMessageRecord == null)) {
      return;
    }
    paramMessageRecord.saveExtInfoToExtStr("ten_doc_title", paramTencentDocItem.mTitle);
    paramMessageRecord.saveExtInfoToExtStr("ten_doc_icon", paramTencentDocItem.mIcon);
    paramMessageRecord.saveExtInfoToExtStr("ten_doc_url", paramTencentDocItem.mUrl);
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
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.removeAll(paramList);
    if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      this.jdField_a_of_type_JavaUtilList.add("");
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      Object localObject1 = null;
      if (localIterator.hasNext())
      {
        Object localObject2 = localIterator.next();
        localArrayList.add(localObject2);
        if ((localObject2 instanceof String))
        {
          paramList = localObject2;
          if (localObject1 != null) {
            localArrayList.remove(localObject1);
          }
        }
        for (paramList = localObject2;; paramList = null)
        {
          localObject1 = paramList;
          break;
        }
      }
      if (!localArrayList.isEmpty()) {
        localArrayList.remove(localArrayList.size() - 1);
      }
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(localArrayList);
    }
    aptv.b(2131691514);
    this.jdField_a_of_type_Afwa.notifyDataSetChanged();
    r();
  }
  
  private void a(Map<String, List<TencentDocItem>> paramMap)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramMap == null)) {
      return;
    }
    if (this.e) {
      this.e = false;
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      this.jdField_a_of_type_JavaUtilList.add(localObject);
      localObject = (List)paramMap.get(localObject);
      if (localObject != null) {
        this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject);
      }
    }
    r();
  }
  
  private TencentDocItem b(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    String str1;
    String str2;
    do
    {
      return null;
      str1 = paramMessageRecord.getExtInfoFromExtStr("ten_doc_title");
      str2 = paramMessageRecord.getExtInfoFromExtStr("ten_doc_icon");
      paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("ten_doc_url");
    } while ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(paramMessageRecord)));
    TencentDocItem localTencentDocItem = new TencentDocItem();
    localTencentDocItem.mUrl = paramMessageRecord;
    localTencentDocItem.mIcon = str2;
    localTencentDocItem.mTitle = str1;
    return localTencentDocItem;
  }
  
  private void p()
  {
    anby localanby = anbz.a();
    if (localanby.a()) {
      bcpw.a(this.jdField_a_of_type_AndroidContentContext, 2131720096, 1).a();
    }
    int i;
    do
    {
      return;
      i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getInt("key_tencent_doc_history_tab_tips_count", 0);
    } while (i >= localanby.a());
    bcpw.a(this.jdField_a_of_type_AndroidContentContext, 2131720096, 1).a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putInt("key_tencent_doc_history_tab_tips_count", i + 1).apply();
  }
  
  private void q()
  {
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener == null) {
      this.jdField_a_of_type_AndroidViewView$OnClickListener = new afwe(this);
    }
    if (this.jdField_a_of_type_Afwc == null) {
      this.jdField_a_of_type_Afwc = new afwf(this);
    }
    ayfv.a(this.jdField_a_of_type_AndroidWidgetTextView, new afwg(this));
  }
  
  private void r()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      if (this.jdField_a_of_type_ComTencentWidgetXListView.getVisibility() != 8) {
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A169", "0X800A169", this.jdField_c_of_type_Int, 0, "", "", "s_qq_history_tab", "");
      }
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Afwa != null)
      {
        afwh localafwh = this.jdField_a_of_type_Afwh;
        if (this.jdField_a_of_type_Afwa.getCount() != 0) {
          bool = true;
        }
        localafwh.a(bool);
      }
      return;
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  private void s()
  {
    ThreadManager.excute(new ChatHistoryBaseTenDocFragment.5(this), 128, null, false);
  }
  
  void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1121) {
      p();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (paramBoolean) {
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A168", "0X800A168", this.jdField_c_of_type_Int, 0, "", "", "s_qq_history_tab", "");
    }
  }
  
  protected void b() {}
  
  void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    if (this.jdField_a_of_type_Afwa != null) {
      this.jdField_a_of_type_Afwa.a(paramBoolean);
    }
  }
  
  protected int c()
  {
    return 1602;
  }
  
  protected void c() {}
  
  protected void d()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(2));
    localArrayList.add(Integer.valueOf(4));
    this.jdField_a_of_type_Agbs.a(localArrayList);
  }
  
  public void e()
  {
    super.e();
    r();
  }
  
  public void f()
  {
    super.f();
    h();
    if (this.jdField_a_of_type_Afwa != null) {
      this.jdField_a_of_type_Afwa.notifyDataSetChanged();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if ((paramMessage.obj instanceof Map))
      {
        a((Map)paramMessage.obj);
        continue;
        if ((paramMessage.obj instanceof List)) {
          a((List)paramMessage.obj);
        }
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A172", "0X800A172", this.jdField_c_of_type_Int, 0, "", "", "s_qq_history_tab", "");
      }
    }
  }
  
  protected void m()
  {
    super.m();
    Object localObject = a();
    if ((localObject == null) || (((List)localObject).size() == 0))
    {
      aptv.c(2131690728);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      MessageRecord localMessageRecord = ((TencentDocItem)((Iterator)localObject).next()).mRecord;
      if ((localMessageRecord instanceof ChatMessage)) {
        localArrayList.add((ChatMessage)localMessageRecord);
      }
    }
    this.jdField_a_of_type_Afck.a(localArrayList);
    h();
    axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A173", "0X800A173", this.jdField_c_of_type_Int, 0, "", "", "s_qq_history_tab", "");
  }
  
  protected void n()
  {
    super.n();
    if (a().isEmpty())
    {
      aptv.c(2131690728);
      return;
    }
    bfol localbfol = (bfol)bfoy.a(getActivity(), null);
    localbfol.a(2131696395);
    localbfol.a(getString(2131692409), 3);
    localbfol.c(2131690596);
    localbfol.a(new afwd(this, localbfol));
    localbfol.show();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidContentContext = getActivity();
    paramBundle = getActivity().getIntent().getExtras();
    if (paramBundle != null)
    {
      this.jdField_a_of_type_Int = paramBundle.getInt("uintype");
      if (!akpv.a(this.jdField_a_of_type_Int)) {
        break label217;
      }
    }
    label217:
    for (this.jdField_c_of_type_Int = 2;; this.jdField_c_of_type_Int = 1)
    {
      paramLayoutInflater = (RelativeLayout)paramLayoutInflater.inflate(2131558775, paramViewGroup, false);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131378228));
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)paramLayoutInflater.findViewById(2131376554));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetXListView.setCacheColorHint(0);
      this.jdField_a_of_type_Afck = new afck(getActivity(), 9101);
      this.jdField_a_of_type_Afck.a();
      q();
      this.jdField_a_of_type_Afwa = new afwa(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_Afwa.a(this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_Afwa.a(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_Afwa.a(this.jdField_a_of_type_Afwc);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Afwa);
      a(paramLayoutInflater);
      r();
      s();
      return paramLayoutInflater;
      this.jdField_a_of_type_Int = 1;
      break;
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A167", "0X800A167", this.jdField_c_of_type_Int, 0, "", "", "s_qq_history_tab", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryBaseTenDocFragment
 * JD-Core Version:    0.7.0.1
 */