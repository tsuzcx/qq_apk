package com.tencent.mobileqq.activity.activateFriend;

import Wallet.AcsGetMsgRsp;
import aeno;
import aens;
import aent;
import aenu;
import aeoi;
import aeol;
import aeom;
import alud;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.widget.ImmersionBar;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import cooperation.qwallet.plugin.FakeUrl;
import mqq.app.AppRuntime;

public abstract class QQNotifySettingBaseFragment
  extends PublicBaseFragment
  implements aeoi, View.OnClickListener
{
  private static final String b;
  protected int a;
  private aens jdField_a_of_type_Aens;
  private aeom jdField_a_of_type_Aeom;
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  protected View a;
  protected Button a;
  protected TextView a;
  private FakeUrl jdField_a_of_type_CooperationQwalletPluginFakeUrl;
  protected String a;
  protected boolean a;
  protected TextView b;
  private String c;
  private String d;
  private String e;
  
  static
  {
    jdField_b_of_type_JavaLangString = QQNotifySettingBaseFragment.class.getSimpleName();
  }
  
  public QQNotifySettingBaseFragment()
  {
    this.jdField_a_of_type_Int = 9;
    this.jdField_a_of_type_JavaLangString = "user cancel";
  }
  
  private QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  private void b()
  {
    aeol.b(this.c, this.e, new aent(this));
  }
  
  private void c()
  {
    aeol.a(this.c, this.e, new aenu(this));
  }
  
  public abstract View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup);
  
  protected void a(int paramInt, String paramString)
  {
    if (getActivity() != null)
    {
      c(paramInt, paramString);
      getActivity().finish();
    }
  }
  
  public void a(AcsGetMsgRsp paramAcsGetMsgRsp)
  {
    long l;
    if (paramAcsGetMsgRsp != null)
    {
      if (paramAcsGetMsgRsp.ret_code != 0) {
        break label74;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramAcsGetMsgRsp.content);
      l = paramAcsGetMsgRsp.notice_time;
      if (l != 0L) {
        break label54;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(alud.a(2131710967));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      return;
      label54:
      this.jdField_b_of_type_AndroidWidgetTextView.setText(aeno.a(l * 1000L, "yyyy-MM-dd HH:mm:ss"));
    }
    label74:
    a();
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.jdField_a_of_type_Aens = new aens(getActivity());
    this.jdField_a_of_type_Aens.show();
    this.jdField_a_of_type_CooperationQwalletPluginFakeUrl = new FakeUrl(getActivity());
    b();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131363712: 
      do
      {
        return;
        paramView = (String)paramView.getTag();
        if ("0".equals(paramView))
        {
          c();
          return;
        }
      } while (!"1".equals(paramView));
      a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
      return;
    }
    a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    aeol.a(a());
    this.jdField_a_of_type_AndroidViewView = a(paramLayoutInflater, paramViewGroup);
    new ImmersionBar(getActivity(), 0, this.jdField_a_of_type_AndroidViewView.findViewById(2131377007));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378908));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378909));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131363712));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.c = getArguments().getString("key_msgid");
    this.d = getArguments().getString("key_busid");
    this.e = getArguments().getString("key_domain");
    this.jdField_a_of_type_Aeom = new aeom(a());
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if ((this.jdField_a_of_type_Aens != null) && (this.jdField_a_of_type_Aens.isShowing())) {
      this.jdField_a_of_type_Aens.dismiss();
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    aeol.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.QQNotifySettingBaseFragment
 * JD-Core Version:    0.7.0.1
 */