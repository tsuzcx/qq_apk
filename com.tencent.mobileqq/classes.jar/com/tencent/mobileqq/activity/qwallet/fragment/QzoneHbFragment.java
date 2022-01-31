package com.tencent.mobileqq.activity.qwallet.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.qwallet.PreloadImgManager.OnSingleDownloadCallback;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.activity.qwallet.config.QWalletConfigManager;
import com.tencent.mobileqq.activity.qwallet.widget.RollNumberView;
import com.tencent.mobileqq.activity.qwallet.widget.RollNumberView.OnRollListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.ptvfilter.utils.Utils;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Map;
import java.util.Random;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;
import xdq;
import xdr;
import xds;
import xdt;
import xdu;
import xdv;
import xdw;
import xdx;

public class QzoneHbFragment
  extends BaseHbFragment
  implements View.OnClickListener, FragmentInterface, RollNumberView.OnRollListener
{
  private int jdField_a_of_type_Int = 1;
  private long jdField_a_of_type_Long;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  protected TextWatcher a;
  private View jdField_a_of_type_AndroidViewView;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  PreloadImgManager.OnSingleDownloadCallback jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadImgManager$OnSingleDownloadCallback = new xdt(this);
  private RollNumberView jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetRollNumberView;
  private String jdField_a_of_type_JavaLangString;
  private JSONArray jdField_a_of_type_OrgJsonJSONArray = new JSONArray();
  private xdx jdField_a_of_type_Xdx = new xdx(this);
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private View jdField_c_of_type_AndroidViewView;
  private String jdField_c_of_type_JavaLangString = "1.00";
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  
  public QzoneHbFragment()
  {
    this.jdField_a_of_type_AndroidTextTextWatcher = new xdq(this);
  }
  
  private String a()
  {
    int m = 0;
    new JSONArray();
    Object localObject3 = "";
    Object localObject1 = localObject3;
    int n;
    Random localRandom;
    int j;
    if (this.jdField_a_of_type_OrgJsonJSONArray != null)
    {
      n = this.jdField_a_of_type_OrgJsonJSONArray.length();
      localObject1 = localObject3;
      if (n > 0)
      {
        localRandom = new Random();
        j = m;
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("hb_key_rand_amount", "");
        j = m;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          j = m;
          localObject1 = new JSONArray((String)localObject1);
          j = m;
          if (((JSONArray)localObject1).length() == this.jdField_a_of_type_OrgJsonJSONArray.length())
          {
            localObject3 = localObject1;
            if (localObject1 == null)
            {
              j = m;
              localObject1 = new JSONArray();
              k = 0;
              localObject3 = localObject1;
              j = m;
              if (k < this.jdField_a_of_type_OrgJsonJSONArray.length())
              {
                j = m;
                ((JSONArray)localObject1).put(k, 0);
                k += 1;
                continue;
              }
            }
            j = m;
            int k = a((JSONArray)localObject3, localRandom.nextInt(n));
            j = k;
            ((JSONArray)localObject3).put(k, 1);
            j = k;
            localObject1 = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
            j = k;
            ((SharedPreferences.Editor)localObject1).putString("hb_key_rand_amount", ((JSONArray)localObject3).toString());
            j = k;
            ((SharedPreferences.Editor)localObject1).commit();
            j = k;
          }
        }
        SharedPreferences.Editor localEditor;
        Object localObject2 = null;
      }
      catch (Exception localException1)
      {
        try
        {
          localObject1 = this.jdField_a_of_type_OrgJsonJSONArray.get(j).toString();
          return localObject1;
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
          return "";
        }
        localException1 = localException1;
        localException1.printStackTrace();
        localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
        localEditor.remove("hb_key_rand_amount");
        localEditor.commit();
      }
    }
  }
  
  public static void a(Handler paramHandler, EditText paramEditText)
  {
    if ((paramHandler != null) && (paramEditText != null)) {
      paramHandler.postDelayed(new xdw(paramEditText), 100L);
    }
  }
  
  private void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131367947);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367946));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367948));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131367950));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131367953));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131367954));
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131365636);
    this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(getActivity(), 2131034291);
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131367945);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetRollNumberView = ((RollNumberView)paramView.findViewById(2131367951));
  }
  
  private boolean a()
  {
    this.jdField_a_of_type_Int = ((QWalletConfigManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(244)).a("grap_hb_verify", 1, new String[] { "videoRedMinValue" });
    return Integer.valueOf(SendHbLogic.a(this.jdField_b_of_type_JavaLangString)).intValue() >= this.jdField_a_of_type_Int;
  }
  
  private boolean b()
  {
    int j = this.jdField_a_of_type_AndroidWidgetEditText.getText().length();
    String str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    if ((j == 0) || (str.startsWith(".")) || (str.endsWith("."))) {}
    for (;;)
    {
      return false;
      if ((!TextUtils.isEmpty(str)) && (str.indexOf('.') != 0)) {
        if ((str.indexOf('.') > 0) && (str.indexOf('.') < str.length() - 3))
        {
          str = getString(2131431360);
          if (str != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity.b(str);
            return false;
          }
        }
        else
        {
          try
          {
            double d1 = Double.valueOf(str).doubleValue();
            if (d1 > 0.0D) {
              return true;
            }
          }
          catch (Exception localException) {}
        }
      }
    }
    return false;
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetRollNumberView.setLisener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences = getActivity().getPreferences(0);
    try
    {
      this.jdField_a_of_type_OrgJsonJSONArray.put("1.00");
      Bundle localBundle = getArguments();
      if (localBundle != null)
      {
        localBundle.getString("send_name");
        this.f = localBundle.getString("recv_name");
        this.g = localBundle.getString("feedsid");
        this.d = localBundle.getString("recv_uin");
        this.h = localBundle.getString("channel");
        this.i = localBundle.getString("recv_type");
        if ((this.h.equals("32768")) && (!this.i.equals("1"))) {
          this.d = localBundle.getString("grab_uin_list");
        }
        this.e = localBundle.getString("send_uin");
        if (!TextUtils.isEmpty(this.f))
        {
          if (this.f.length() > 8) {
            this.f = (this.f.substring(0, 7) + "...");
          }
          this.jdField_a_of_type_AndroidWidgetTextView.setText(this.f);
        }
        this.jdField_b_of_type_JavaLangString = "1.00";
        this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_b_of_type_JavaLangString);
      }
      this.jdField_a_of_type_AndroidWidgetEditText.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, this.d));
      this.jdField_a_of_type_Xdx.postDelayed(new xdr(this), 10L);
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetRollNumberView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(0);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void f()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((isAdded()) && (localFragmentActivity != null)) {
      this.jdField_c_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(new xdu(this, localFragmentActivity));
    }
  }
  
  public int a(Context paramContext)
  {
    int j = 0;
    try
    {
      paramContext = paramContext.getResources();
      int k = paramContext.getIdentifier("navigation_bar_height", "dimen", "android");
      if (k > 0) {
        j = paramContext.getDimensionPixelSize(k);
      }
      return j;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return 0;
  }
  
  public int a(JSONArray paramJSONArray, int paramInt)
  {
    int n = 0;
    int m = 0;
    if ((paramJSONArray == null) || (paramJSONArray.length() <= paramInt) || (paramInt < 0)) {
      return 0;
    }
    int j = n;
    for (;;)
    {
      try
      {
        int i2 = paramJSONArray.length();
        k = 0;
        if (k >= i2) {
          break label142;
        }
        int i1 = (paramInt + k) % i2;
        j = n;
        int i3 = paramJSONArray.optInt(i1);
        if (i3 == 0)
        {
          j = i1;
          if (k != i2) {
            break label137;
          }
          k = m;
          if (k >= i2) {
            continue;
          }
        }
      }
      catch (Exception paramJSONArray)
      {
        int k;
        paramJSONArray.printStackTrace();
        return j;
      }
      try
      {
        paramJSONArray.put(k, 0);
        k += 1;
      }
      catch (Exception paramJSONArray)
      {
        continue;
      }
      k += 1;
      continue;
      j = paramInt;
      paramJSONArray.put(paramInt, 1);
      return paramInt;
      label137:
      paramInt = j;
      continue;
      label142:
      j = 0;
    }
  }
  
  public void a()
  {
    if (isAdded()) {
      getActivity().finish();
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      if (this.h.equals("32768")) {}
      for (paramJSONObject = paramJSONObject.optJSONObject("mk_svideo_hb"); paramJSONObject != null; paramJSONObject = paramJSONObject.optJSONObject("mk_qzone_hb")) {
        try
        {
          this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("comment");
          this.jdField_a_of_type_OrgJsonJSONArray = paramJSONObject.optJSONArray("money_array");
          this.jdField_b_of_type_JavaLangString = a();
          if (!Utils.a(this.jdField_b_of_type_JavaLangString)) {
            this.jdField_c_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
          }
          paramJSONObject = this.jdField_a_of_type_Xdx.obtainMessage();
          paramJSONObject.what = 100;
          this.jdField_a_of_type_Xdx.sendMessage(paramJSONObject);
          return;
        }
        catch (Exception paramJSONObject)
        {
          paramJSONObject.printStackTrace();
          return;
        }
      }
    }
  }
  
  public void b()
  {
    if (!isAdded()) {
      return;
    }
    Object localObject = getActivity();
    localObject = ((Context)localObject).getFilesDir().getPath() + "/QWallet/" + this.e + "/hbThemeConfig.cfg";
    ThreadManager.getFileThreadHandler().post(new xdv(this, (String)localObject));
  }
  
  public void c()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void complete()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QzoneHbFragment", 2, "complete---");
    }
    Message localMessage = this.jdField_a_of_type_Xdx.obtainMessage();
    localMessage.what = 101;
    this.jdField_a_of_type_Xdx.sendMessage(localMessage);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    long l;
    do
    {
      for (;;)
      {
        return;
        if (isAdded()) {
          try
          {
            ((InputMethodManager)getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_b_of_type_AndroidViewView.getWindowToken(), 0);
            getActivity().finish();
            getActivity().overridePendingTransition(0, 0);
            if (!this.h.equals("32768"))
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity.a(300, "rewardhongbao.wrap.close", 2);
              return;
            }
          }
          catch (Exception paramView)
          {
            for (;;)
            {
              paramView.printStackTrace();
            }
          }
        }
      }
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_AndroidWidgetButton.setText("取消");
        this.jdField_a_of_type_AndroidWidgetEditText.setEnabled(true);
        this.jdField_a_of_type_AndroidWidgetEditText.setFocusable(true);
        this.jdField_a_of_type_AndroidWidgetEditText.setText("");
        if (!this.h.equals("32768")) {
          this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity.a(300, "rewardhongbao.wrap.custom", 2);
        }
        a(this.jdField_a_of_type_Xdx, this.jdField_a_of_type_AndroidWidgetEditText);
        return;
      }
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidWidgetEditText.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetButton.setText("修改金额");
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
      return;
      l = System.currentTimeMillis();
    } while ((this.jdField_a_of_type_Long != 0L) && (System.currentTimeMillis() - this.jdField_a_of_type_Long < 1000L));
    this.jdField_a_of_type_Long = l;
    if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity.d = this.jdField_b_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity.e = "1";
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity.a();
    paramView.put("total_num", "1");
    paramView.put("total_amount", SendHbLogic.a(this.jdField_b_of_type_JavaLangString));
    paramView.put("wishing", "");
    paramView.put("channel", this.h);
    paramView.put("feeds_name", this.f);
    paramView.put("feeds_sid", this.g);
    if (this.h.equals("32768"))
    {
      if (!a())
      {
        paramView = SendHbLogic.a(this.jdField_a_of_type_Int + "", 0, true);
        paramView = "打赏金额不得低于" + paramView + "元噢，给好友赏个大红包吧。";
        DialogUtil.a(getActivity(), 230, null, paramView, null, getString(2131431401), new xds(this), null).show();
        return;
      }
      if (!this.i.equals("1")) {
        break label626;
      }
      paramView.put("channel", "1");
      paramView.put("bus_type", "1");
    }
    for (;;)
    {
      paramView.put("type", "1");
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentSendHbLogic.a(paramView);
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity.overridePendingTransition(0, 0);
      if (this.h.equals("32768")) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity.a(300, "rewardhongbao.wrap.send", 2);
      return;
      label626:
      paramView.put("channel", "1024");
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity.getWindow().setSoftInputMode(32);
    paramLayoutInflater = paramLayoutInflater.inflate(2130969787, null);
    a(paramLayoutInflater);
    e();
    d();
    b();
    f();
    if (!this.h.equals("32768")) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity.a(300, "rewardhongbao.wrap.show", 2);
    }
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    if ((this.jdField_a_of_type_AndroidWidgetEditText != null) && (this.jdField_a_of_type_AndroidTextTextWatcher != null))
    {
      this.jdField_a_of_type_AndroidWidgetEditText.removeTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
      this.jdField_a_of_type_AndroidTextTextWatcher = null;
    }
    super.onDestroyView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.QzoneHbFragment
 * JD-Core Version:    0.7.0.1
 */