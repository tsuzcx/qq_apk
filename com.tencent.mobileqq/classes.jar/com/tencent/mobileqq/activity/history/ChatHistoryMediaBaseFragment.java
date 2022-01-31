package com.tencent.mobileqq.activity.history;

import acje;
import acjr;
import agdf;
import agdh;
import agem;
import agfi;
import agfq;
import ahtz;
import ahvw;
import ahvx;
import ahvy;
import ahwa;
import ahwb;
import ahwc;
import ahwd;
import android.app.Dialog;
import android.content.res.Resources;
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
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqnl;
import aqse;
import armz;
import arni;
import aulk;
import aulo;
import ault;
import azmj;
import bdcd;
import bdee;
import bdfq;
import bhoe;
import bhpy;
import bhql;
import bkev;
import bkfg;
import bkfr;
import com.tencent.mobileqq.activity.ChatHistoryImageView;
import com.tencent.mobileqq.activity.aio.photo.AIOFilePicData;
import com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class ChatHistoryMediaBaseFragment
  extends ChatHistoryBaseFragment
  implements acjr, agdh, Handler.Callback, View.OnClickListener
{
  private Button jdField_a_of_type_AndroidWidgetButton;
  private aqnl jdField_a_of_type_Aqnl;
  public ChatHistoryImageView a;
  public ArrayList<agfq> a;
  List<ChatMessage> jdField_a_of_type_JavaUtilList;
  public final MqqHandler a;
  private View jdField_b_of_type_AndroidViewView;
  bdfq jdField_b_of_type_Bdfq;
  private Dialog c;
  protected bdfq c;
  
  public ChatHistoryMediaBaseFragment()
  {
    this.jdField_a_of_type_MqqOsMqqHandler = new bhoe(Looper.getMainLooper(), this, true);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, acje paramacje)
  {
    if ((this.jdField_c_of_type_Bdfq != null) && (this.jdField_c_of_type_Bdfq.isShowing())) {
      this.jdField_c_of_type_Bdfq.dismiss();
    }
    bdfq localbdfq = new bdfq(getActivity(), 2131755801);
    localbdfq.setContentView(2131558943);
    this.jdField_c_of_type_Bdfq = localbdfq;
    this.jdField_c_of_type_Bdfq.setTitle(paramString1);
    this.jdField_c_of_type_Bdfq.setMessage(paramString2);
    paramString1 = paramString4;
    if (TextUtils.isEmpty(paramString4)) {
      paramString1 = getString(2131690648);
    }
    paramString2 = paramString3;
    if (TextUtils.isEmpty(paramString3)) {
      paramString2 = getString(2131691088);
    }
    this.jdField_c_of_type_Bdfq.setNegativeButton(paramString1, new ahwb(this, paramacje));
    this.jdField_c_of_type_Bdfq.setPositiveButton(paramString2, new ahwc(this, paramacje));
    this.jdField_c_of_type_Bdfq.setCancelable(true);
    this.jdField_c_of_type_Bdfq.setCanceledOnTouchOutside(false);
    this.jdField_c_of_type_Bdfq.show();
  }
  
  private void a(List<agfq> paramList)
  {
    ArrayList localArrayList;
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService != null))
    {
      localArrayList = new ArrayList();
      if ((paramList != null) && (paramList.size() > 0)) {
        localObject = paramList.iterator();
      }
    }
    label361:
    for (;;)
    {
      ChatMessage localChatMessage;
      if (((Iterator)localObject).hasNext())
      {
        paramList = (agfq)((Iterator)localObject).next();
        localChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(paramList.a.f);
        if ((localChatMessage instanceof MessageForPic)) {
          paramList = aulo.a((MessageForPic)localChatMessage);
        }
      }
      for (;;)
      {
        if (paramList == null) {
          break label361;
        }
        localArrayList.add(paramList);
        break;
        if ((localChatMessage instanceof MessageForShortVideo))
        {
          paramList = (MessageForShortVideo)localChatMessage;
          if (paramList.busiType == 0) {
            paramList = aulo.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramList);
          } else {
            paramList = aulo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramList);
          }
        }
        else
        {
          if ((localChatMessage instanceof MessageForFile))
          {
            if (AIOFilePicData.class.isInstance(paramList.a))
            {
              paramList = aulo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localChatMessage);
              paramList.a = 4;
              continue;
            }
            if (AIOFileVideoData.class.isInstance(paramList.a))
            {
              paramList = aulo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localChatMessage);
              paramList.a = 5;
            }
          }
          else if ((localChatMessage instanceof MessageForTroopFile))
          {
            int i = arni.a(((MessageForTroopFile)localChatMessage).fileName);
            if (i == 0)
            {
              paramList = aulo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localChatMessage);
              paramList.a = 6;
              continue;
            }
            if (i == 2)
            {
              paramList = aulo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localChatMessage);
              paramList.a = 7;
              continue;
              paramList = new aulk(getActivity());
              localObject = (ault)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(324);
              ((ault)localObject).a(new ahvy(this, paramList, (ault)localObject, localArrayList));
              ((ault)localObject).a(localArrayList, true);
              ((ault)localObject).a(localArrayList, 1, 5);
              return;
            }
          }
          paramList = null;
        }
      }
    }
  }
  
  private void b(List<ChatMessage> paramList)
  {
    if (paramList.size() == 1) {
      bkfg.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), e(), paramList, this.jdField_a_of_type_MqqOsMqqHandler);
    }
    for (;;)
    {
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009DB9", "0X8009DB9", 0, 0, "", "", "", "");
      return;
      bkfg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), e(), paramList, this.jdField_a_of_type_MqqOsMqqHandler);
    }
  }
  
  private boolean b()
  {
    return ((getActivity() instanceof ChatHistoryActivity)) && (((ChatHistoryActivity)getActivity()).c);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.jdField_a_of_type_Agfi != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.jdField_a_of_type_Agfi.getCount() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistoryMediaBaseFragment", 2, "onMediaLoaded, mImageView.mAdapter is null");
      }
      this.jdField_a_of_type_Ahtz.a(false);
      return;
    }
    this.jdField_a_of_type_Ahtz.a(true);
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.a(paramLong);
    }
  }
  
  public void a(agfq paramagfq)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.remove(paramagfq);
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramChatMessage);
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryStruct", 2, "addweiyunselected, size: " + this.jdField_a_of_type_JavaUtilList.size());
    }
  }
  
  void a(ArrayList<agfq> paramArrayList) {}
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.a())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.a();
    }
  }
  
  public boolean a()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {}
    for (int i = this.jdField_a_of_type_JavaUtilArrayList.size() + 0;; i = 0)
    {
      if (i >= 20) {
        bool = true;
      }
      if (bool)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatHistoryMediaBaseFragment", 2, "isOverLimit");
        }
        armz.a(2131692639);
      }
      return bool;
    }
  }
  
  public boolean a(agfq paramagfq)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    if (b())
    {
      int i = agem.a(paramagfq.a);
      if ((i == 2) || (i == 3))
      {
        c(getString(2131692655));
        return false;
      }
      if (AIOImageData.class.isInstance(paramagfq.a))
      {
        AIOImageData localAIOImageData = (AIOImageData)paramagfq.a;
        if ((localAIOImageData.e == null) || (localAIOImageData.e.length() == 0))
        {
          c(getString(2131692654));
          return false;
        }
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(paramagfq);
    return true;
  }
  
  protected void b() {}
  
  public void b(ChatMessage paramChatMessage)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    do
    {
      return;
      this.jdField_a_of_type_JavaUtilList.remove(paramChatMessage);
    } while (!QLog.isColorLevel());
    QLog.d("ChatHistoryStruct", 2, "removeweiyunselect, size: " + this.jdField_a_of_type_JavaUtilList.size());
  }
  
  void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      u();
      s();
      return;
    }
    v();
  }
  
  protected int c()
  {
    return 1602;
  }
  
  protected void c() {}
  
  public void c(String paramString)
  {
    if (this.jdField_b_of_type_Bdfq == null)
    {
      this.jdField_b_of_type_Bdfq = bdcd.a(getActivity(), 230);
      this.jdField_b_of_type_Bdfq.setNegativeButton(2131720083, new ahvx(this));
    }
    if (!this.jdField_b_of_type_Bdfq.isShowing()) {
      this.jdField_b_of_type_Bdfq.setMessage(paramString);
    }
    for (;;)
    {
      try
      {
        this.jdField_b_of_type_Bdfq.show();
        return;
      }
      catch (Throwable paramString) {}
      this.jdField_b_of_type_Bdfq.dismiss();
    }
  }
  
  public int d()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
      return 0;
    }
    AIORichMediaData localAIORichMediaData = ((agfq)this.jdField_a_of_type_JavaUtilArrayList.get(0)).a;
    if ((AIOImageData.class.isInstance(localAIORichMediaData)) || (AIOFilePicData.class.isInstance(localAIORichMediaData))) {
      return 1;
    }
    if (AIOShortVideoData.class.isInstance(localAIORichMediaData)) {
      return 2;
    }
    return 0;
  }
  
  public int e()
  {
    return getResources().getDimensionPixelSize(2131298914);
  }
  
  public void e()
  {
    super.e();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView != null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService == null) || (!AIOImageProviderService.a.containsValue(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService))) {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.g();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.b();
    }
    v();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.jdField_a_of_type_Agfi != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.jdField_a_of_type_Agfi.getCount() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistoryMediaBaseFragment", 2, "doOnResume, mImageView.mAdapter is null");
      }
      if (this.jdField_a_of_type_Ahtz != null) {
        this.jdField_a_of_type_Ahtz.a(false);
      }
    }
    while (this.jdField_a_of_type_Ahtz == null) {
      return;
    }
    this.jdField_a_of_type_Ahtz.a(true);
  }
  
  public void f()
  {
    super.f();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.c();
    }
  }
  
  public void g()
  {
    super.g();
    agdf.a().b(this);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.d();
    }
    if (this.jdField_a_of_type_Aqnl != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_Aqnl);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    int i;
    do
    {
      return true;
      v();
      q();
      return true;
      if (this.jdField_c_of_type_AndroidAppDialog != null) {
        this.jdField_c_of_type_AndroidAppDialog.dismiss();
      }
      v();
      return true;
      if (this.jdField_c_of_type_AndroidAppDialog != null) {
        this.jdField_c_of_type_AndroidAppDialog.dismiss();
      }
      bkfr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), e());
      v();
      return true;
      if (this.jdField_c_of_type_AndroidAppDialog != null) {
        this.jdField_c_of_type_AndroidAppDialog.dismiss();
      }
      v();
      i = paramMessage.arg1;
    } while (!bkev.a(i));
    if (bkev.d(i))
    {
      getString(2131695079);
      paramMessage = "";
      if (bkev.b(i))
      {
        getString(2131695079);
        paramMessage = getString(2131692266);
      }
      for (;;)
      {
        ahwa localahwa = new ahwa(this);
        a(getString(2131699049), paramMessage, null, null, localahwa);
        return true;
        if (bkev.c(i))
        {
          getString(2131695079);
          paramMessage = getString(2131692264);
        }
      }
    }
    paramMessage = (String)paramMessage.obj;
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), paramMessage, 1).b(e());
    return true;
  }
  
  public void i()
  {
    if (this.jdField_c_of_type_AndroidAppDialog == null)
    {
      this.jdField_c_of_type_AndroidAppDialog = new Dialog(getActivity(), 2131755801);
      this.jdField_c_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
      this.jdField_c_of_type_AndroidAppDialog.setContentView(2131559438);
    }
    TextView localTextView = (TextView)this.jdField_c_of_type_AndroidAppDialog.findViewById(2131371874);
    localTextView.setText(localTextView.getResources().getString(2131689979));
    if (!this.jdField_c_of_type_AndroidAppDialog.isShowing()) {}
    try
    {
      this.jdField_c_of_type_AndroidAppDialog.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  protected void k()
  {
    if (!CheckPermission.isHasStoragePermission(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
    {
      CheckPermission.requestStorePermission(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null);
      return;
    }
    if (!bdee.d(BaseApplication.getContext()))
    {
      QQToast.a(getActivity(), 2131694829, 1).b(getResources().getDimensionPixelSize(2131298914));
      return;
    }
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      a(this.jdField_a_of_type_JavaUtilArrayList);
      r();
      return;
    }
    armz.c(2131692636);
  }
  
  protected void l()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      i();
      b(this.jdField_a_of_type_JavaUtilList);
      t();
      return;
    }
    armz.c(2131692636);
  }
  
  protected void m()
  {
    int i = 0;
    int j;
    int k;
    int m;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      j = 0;
      i = 0;
      k = 0;
      int n = 0;
      while (localIterator.hasNext())
      {
        int i2 = agem.a(((agfq)localIterator.next()).a);
        if ((n != 0) || (i2 != 1)) {
          break label264;
        }
        j += 1;
        n = 1;
        m = j;
        int i1 = k;
        if (k == 0)
        {
          m = j;
          i1 = k;
          if (i2 == 2)
          {
            m = j + 1;
            i1 = 1;
          }
        }
        if ((i != 0) || (i2 != 3)) {
          break label261;
        }
        m += 1;
        i = 1;
        label121:
        j = m;
        k = i1;
      }
      n = 0 + this.jdField_a_of_type_JavaUtilArrayList.size();
      m = k;
      k = i;
      i = n;
    }
    for (;;)
    {
      if (i == 0)
      {
        armz.c(2131692636);
        return;
      }
      if (!bdee.d(BaseApplication.getContext()))
      {
        QQToast.a(getActivity(), 2131694829, 1).b(getResources().getDimensionPixelSize(2131298914));
        return;
      }
      if (j > 1)
      {
        c(getString(2131692630));
        return;
      }
      if (k != 0)
      {
        c(getString(2131692611));
        return;
      }
      if ((m != 0) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 1))
      {
        c(getString(2131692632));
        return;
      }
      p();
      return;
      label261:
      break label121;
      label264:
      break;
      j = 0;
      k = 0;
      m = 0;
    }
  }
  
  protected void n()
  {
    int i = 0;
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      i = 0 + this.jdField_a_of_type_JavaUtilArrayList.size();
    }
    if (i == 0)
    {
      armz.c(2131692636);
      return;
    }
    bhpy localbhpy = (bhpy)bhql.a(getActivity(), null);
    localbhpy.a(2131696568);
    localbhpy.a(getActivity().getString(2131692485), 3);
    localbhpy.c(2131690648);
    localbhpy.a(new ahvw(this, localbhpy));
    localbhpy.show();
  }
  
  public void onClick(View paramView)
  {
    if (paramView != null) {}
    switch (paramView.getId())
    {
    default: 
      return;
    }
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0))
    {
      armz.c(2131692636);
      return;
    }
    paramView = (ArrayList)this.jdField_a_of_type_JavaUtilArrayList.clone();
    Iterator localIterator = paramView.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      i = agem.a(((agfq)localIterator.next()).a);
    } while ((i != 2) && (i != 3));
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        c(getString(2131692655));
      }
      for (;;)
      {
        getActivity().finish();
        return;
        a(paramView);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    agdf.a().a(this);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView = new ChatHistoryImageView();
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.a(getActivity().getIntent(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity());
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.a(true);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.jdField_a_of_type_Acjr = this;
    }
    if ((b()) && ((this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.a() instanceof RelativeLayout)))
    {
      paramViewGroup = (RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.a();
      this.jdField_b_of_type_AndroidViewView = paramLayoutInflater.inflate(2131558757, null);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_b_of_type_AndroidViewView.findViewById(2131379326));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      paramLayoutInflater = new RelativeLayout.LayoutParams(-1, -2);
      paramLayoutInflater.addRule(12, -1);
      paramLayoutInflater.addRule(14, -1);
      paramViewGroup.addView(this.jdField_b_of_type_AndroidViewView, paramLayoutInflater);
      return paramViewGroup;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      if (this.jdField_a_of_type_Aqnl == null) {
        this.jdField_a_of_type_Aqnl = new ahwd(this, null);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_Aqnl);
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.a();
  }
  
  protected void p() {}
  
  void q() {}
  
  void r() {}
  
  void s() {}
  
  void t() {}
  
  protected void u()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.e();
    }
    if (this.jdField_a_of_type_AndroidWidgetButton != null) {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    }
  }
  
  public void v()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.f();
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList = null;
    }
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList = null;
    }
    if (this.jdField_a_of_type_AndroidWidgetButton != null) {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    }
    h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryMediaBaseFragment
 * JD-Core Version:    0.7.0.1
 */