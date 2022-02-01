package com.tencent.mobileqq.activity.history;

import adps;
import adqf;
import ahrf;
import ahrh;
import ahsl;
import ahte;
import ahtm;
import ajra;
import ajsx;
import ajsy;
import ajsz;
import ajtb;
import ajtc;
import ajtd;
import ajte;
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
import atfq;
import atlh;
import audr;
import auea;
import axjb;
import axjf;
import axjk;
import bdla;
import bhdj;
import bkyc;
import bkzi;
import bkzz;
import bmqx;
import bmri;
import bmrr;
import com.tencent.mobileqq.activity.ChatHistoryImageView;
import com.tencent.mobileqq.activity.aio.photo.AIOFilePicData;
import com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class ChatHistoryMediaBaseFragment
  extends ChatHistoryBaseFragment
  implements adqf, ahrh, Handler.Callback, View.OnClickListener
{
  private Button jdField_a_of_type_AndroidWidgetButton;
  private atfq jdField_a_of_type_Atfq;
  public ChatHistoryImageView a;
  public ArrayList<ahtm> a;
  List<ChatMessage> jdField_a_of_type_JavaUtilList;
  public final MqqHandler a;
  private View jdField_b_of_type_AndroidViewView;
  QQCustomDialog jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private Dialog c;
  protected QQCustomDialog c;
  
  public ChatHistoryMediaBaseFragment()
  {
    this.jdField_a_of_type_MqqOsMqqHandler = new bkyc(Looper.getMainLooper(), this, true);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, adps paramadps)
  {
    if ((this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    QQCustomDialog localQQCustomDialog = new QQCustomDialog(getActivity(), 2131755829);
    localQQCustomDialog.setContentView(2131559043);
    this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog = localQQCustomDialog;
    this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(paramString1);
    this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(paramString2);
    paramString1 = paramString4;
    if (TextUtils.isEmpty(paramString4)) {
      paramString1 = getString(2131690697);
    }
    paramString2 = paramString3;
    if (TextUtils.isEmpty(paramString3)) {
      paramString2 = getString(2131691037);
    }
    this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(paramString1, new ajtc(this, paramadps));
    this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(paramString2, new ajtd(this, paramadps));
    this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(true);
    this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCanceledOnTouchOutside(false);
    this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  private void a(List<ahtm> paramList)
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
        paramList = (ahtm)((Iterator)localObject).next();
        localChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(paramList.a.f);
        if ((localChatMessage instanceof MessageForPic)) {
          paramList = axjf.a((MessageForPic)localChatMessage);
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
            paramList = axjf.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramList);
          } else {
            paramList = axjf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramList);
          }
        }
        else
        {
          if ((localChatMessage instanceof MessageForFile))
          {
            if (AIOFilePicData.class.isInstance(paramList.a))
            {
              paramList = axjf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localChatMessage);
              paramList.a = 4;
              continue;
            }
            if (AIOFileVideoData.class.isInstance(paramList.a))
            {
              paramList = axjf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localChatMessage);
              paramList.a = 5;
            }
          }
          else if ((localChatMessage instanceof MessageForTroopFile))
          {
            int i = auea.a(((MessageForTroopFile)localChatMessage).fileName);
            if (i == 0)
            {
              paramList = axjf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localChatMessage);
              paramList.a = 6;
              continue;
            }
            if (i == 2)
            {
              paramList = axjf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localChatMessage);
              paramList.a = 7;
              continue;
              paramList = new axjb(getActivity());
              localObject = (axjk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MULTI_CHOOSE_SAVE_MANAGER);
              ((axjk)localObject).a(new ajsz(this, paramList, (axjk)localObject, localArrayList));
              ((axjk)localObject).a(localArrayList, true);
              ((axjk)localObject).a(localArrayList, 1, 5);
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
      bmri.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), e(), paramList, this.jdField_a_of_type_MqqOsMqqHandler);
    }
    for (;;)
    {
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009DB9", "0X8009DB9", 0, 0, "", "", "", "");
      return;
      bmri.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), e(), paramList, this.jdField_a_of_type_MqqOsMqqHandler);
    }
  }
  
  private boolean b()
  {
    return ((getActivity() instanceof ChatHistoryActivity)) && (((ChatHistoryActivity)getActivity()).c);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.jdField_a_of_type_Ahte != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.jdField_a_of_type_Ahte.getCount() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistoryMediaBaseFragment", 2, "onMediaLoaded, mImageView.mAdapter is null");
      }
      this.jdField_a_of_type_Ajra.a(false);
      return;
    }
    this.jdField_a_of_type_Ajra.a(true);
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.a(paramLong);
    }
  }
  
  public void a(ahtm paramahtm)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.remove(paramahtm);
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
  
  void a(ArrayList<ahtm> paramArrayList) {}
  
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
        audr.a(2131692370);
      }
      return bool;
    }
  }
  
  public boolean a(ahtm paramahtm)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    if (b())
    {
      int i = ahsl.a(paramahtm.a);
      if ((i == 2) || (i == 3))
      {
        c(getString(2131692386));
        return false;
      }
      if (AIOImageData.class.isInstance(paramahtm.a))
      {
        AIOImageData localAIOImageData = (AIOImageData)paramahtm.a;
        if ((localAIOImageData.e == null) || (localAIOImageData.e.length() == 0))
        {
          c(getString(2131692385));
          return false;
        }
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(paramahtm);
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
      v();
      t();
      return;
    }
    w();
  }
  
  protected int c()
  {
    return 1602;
  }
  
  protected void c() {}
  
  public void c(String paramString)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog == null)
    {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = bhdj.a(getActivity(), 230);
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131718822, new ajsy(this));
    }
    if (!this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(paramString);
    }
    for (;;)
    {
      try
      {
        this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
        return;
      }
      catch (Throwable paramString) {}
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
  }
  
  public int d()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
      return 0;
    }
    AIORichMediaData localAIORichMediaData = ((ahtm)this.jdField_a_of_type_JavaUtilArrayList.get(0)).a;
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
    return getResources().getDimensionPixelSize(2131299080);
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Ajra == null) {}
    do
    {
      return;
      super.e();
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView == null);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService == null) || (!AIOImageProviderService.a.containsValue(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService))) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.g();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.b();
    w();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.jdField_a_of_type_Ahte != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.jdField_a_of_type_Ahte.getCount() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistoryMediaBaseFragment", 2, "doOnResume, mImageView.mAdapter is null");
      }
      this.jdField_a_of_type_Ajra.a(false);
      return;
    }
    this.jdField_a_of_type_Ajra.a(true);
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
    ahrf.a().b(this);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.d();
    }
    if (this.jdField_a_of_type_Atfq != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().deleteObserver(this.jdField_a_of_type_Atfq);
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
      w();
      r();
      return true;
      if (this.jdField_c_of_type_AndroidAppDialog != null) {
        this.jdField_c_of_type_AndroidAppDialog.dismiss();
      }
      w();
      return true;
      if (this.jdField_c_of_type_AndroidAppDialog != null) {
        this.jdField_c_of_type_AndroidAppDialog.dismiss();
      }
      bmrr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), e());
      w();
      return true;
      if (this.jdField_c_of_type_AndroidAppDialog != null) {
        this.jdField_c_of_type_AndroidAppDialog.dismiss();
      }
      w();
      i = paramMessage.arg1;
    } while (!bmqx.a(i));
    if (bmqx.d(i))
    {
      getString(2131694472);
      paramMessage = "";
      if (bmqx.b(i))
      {
        getString(2131694472);
        paramMessage = getString(2131692021);
      }
      for (;;)
      {
        ajtb localajtb = new ajtb(this);
        a(getString(2131698387), paramMessage, null, null, localajtb);
        return true;
        if (bmqx.c(i))
        {
          getString(2131694472);
          paramMessage = getString(2131692019);
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
      this.jdField_c_of_type_AndroidAppDialog = new ReportDialog(getActivity(), 2131755829);
      this.jdField_c_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
      this.jdField_c_of_type_AndroidAppDialog.setContentView(2131559607);
    }
    TextView localTextView = (TextView)this.jdField_c_of_type_AndroidAppDialog.findViewById(2131372740);
    localTextView.setText(localTextView.getResources().getString(2131689926));
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
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      QQToast.a(getActivity(), 2131694305, 1).b(getResources().getDimensionPixelSize(2131299080));
      return;
    }
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      a(this.jdField_a_of_type_JavaUtilArrayList);
      s();
      return;
    }
    audr.c(2131692367);
  }
  
  protected void l()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      i();
      b(this.jdField_a_of_type_JavaUtilList);
      u();
      return;
    }
    audr.c(2131692367);
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
        int i2 = ahsl.a(((ahtm)localIterator.next()).a);
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
        audr.c(2131692367);
        return;
      }
      if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
      {
        QQToast.a(getActivity(), 2131694305, 1).b(getResources().getDimensionPixelSize(2131299080));
        return;
      }
      if (j > 1)
      {
        c(getString(2131692361));
        return;
      }
      if (k != 0)
      {
        c(getString(2131692342));
        return;
      }
      if ((m != 0) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 1))
      {
        c(getString(2131692363));
        return;
      }
      q();
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
      audr.c(2131692367);
      return;
    }
    bkzi localbkzi = (bkzi)bkzz.a(getActivity(), null);
    localbkzi.a(2131695830);
    localbkzi.a(getActivity().getString(2131692213), 3);
    localbkzi.c(2131690697);
    localbkzi.a(new ajsx(this, localbkzi));
    localbkzi.show();
  }
  
  public void onClick(View paramView)
  {
    if (paramView != null) {
      switch (paramView.getId())
      {
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() != 0)) {
        break;
      }
      audr.c(2131692367);
    }
    ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_JavaUtilArrayList.clone();
    Iterator localIterator = localArrayList.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      i = ahsl.a(((ahtm)localIterator.next()).a);
    } while ((i != 2) && (i != 3));
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        c(getString(2131692386));
      }
      for (;;)
      {
        getActivity().finish();
        break;
        a(localArrayList);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ahrf.a().a(this);
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
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.jdField_a_of_type_Adqf = this;
    }
    if ((b()) && ((this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.a() instanceof RelativeLayout)))
    {
      paramViewGroup = (RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.a();
      this.jdField_b_of_type_AndroidViewView = paramLayoutInflater.inflate(2131558853, null);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_b_of_type_AndroidViewView.findViewById(2131380555));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      paramLayoutInflater = new RelativeLayout.LayoutParams(-1, -2);
      paramLayoutInflater.addRule(12, -1);
      paramLayoutInflater.addRule(14, -1);
      paramViewGroup.addView(this.jdField_b_of_type_AndroidViewView, paramLayoutInflater);
    }
    for (paramLayoutInflater = paramViewGroup;; paramLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.a())
    {
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        if (this.jdField_a_of_type_Atfq == null) {
          this.jdField_a_of_type_Atfq = new ajte(this, null);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().addObserver(this.jdField_a_of_type_Atfq);
      }
    }
  }
  
  protected void q() {}
  
  void r() {}
  
  void s() {}
  
  void t() {}
  
  void u() {}
  
  protected void v()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.e();
    }
    if (this.jdField_a_of_type_AndroidWidgetButton != null) {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    }
  }
  
  public void w()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryMediaBaseFragment
 * JD-Core Version:    0.7.0.1
 */