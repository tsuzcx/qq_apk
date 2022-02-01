package com.tencent.mobileqq.activity.qwallet.fragment;

import akxk;
import alao;
import alaw;
import albg;
import albh;
import albi;
import albj;
import albk;
import albl;
import alir;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
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
import anzj;
import aoot;
import bhlq;
import bhpc;
import bmrq;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.activity.qwallet.widget.RollNumberView;
import com.tencent.mobileqq.activity.qwallet.widget.RollNumberView.OnRollListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.Collection;
import java.util.Map;
import java.util.Random;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class QzoneHbFragment
  extends BaseHbFragment
  implements alaw, View.OnClickListener, RollNumberView.OnRollListener
{
  private int jdField_a_of_type_Int = 1;
  private long jdField_a_of_type_Long;
  akxk jdField_a_of_type_Akxk = new albi(this);
  private albk jdField_a_of_type_Albk = new albk(this);
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  protected TextWatcher a;
  private View jdField_a_of_type_AndroidViewView;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private RollNumberView jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetRollNumberView;
  private String jdField_a_of_type_JavaLangString;
  private JSONArray jdField_a_of_type_OrgJsonJSONArray = new JSONArray();
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
  
  public QzoneHbFragment()
  {
    this.jdField_a_of_type_AndroidTextTextWatcher = new albg(this);
  }
  
  private String a()
  {
    int k = 0;
    new JSONArray();
    Object localObject3 = "";
    Object localObject1 = localObject3;
    int m;
    Random localRandom;
    int i;
    if (this.jdField_a_of_type_OrgJsonJSONArray != null)
    {
      m = this.jdField_a_of_type_OrgJsonJSONArray.length();
      localObject1 = localObject3;
      if (m > 0)
      {
        localRandom = new Random();
        i = k;
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("hb_key_rand_amount", "");
        i = k;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          i = k;
          localObject1 = new JSONArray((String)localObject1);
          i = k;
          if (((JSONArray)localObject1).length() == this.jdField_a_of_type_OrgJsonJSONArray.length())
          {
            localObject3 = localObject1;
            if (localObject1 == null)
            {
              i = k;
              localObject1 = new JSONArray();
              j = 0;
              localObject3 = localObject1;
              i = k;
              if (j < this.jdField_a_of_type_OrgJsonJSONArray.length())
              {
                i = k;
                ((JSONArray)localObject1).put(j, 0);
                j += 1;
                continue;
              }
            }
            i = k;
            int j = a((JSONArray)localObject3, localRandom.nextInt(m));
            i = j;
            ((JSONArray)localObject3).put(j, 1);
            i = j;
            localObject1 = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
            i = j;
            ((SharedPreferences.Editor)localObject1).putString("hb_key_rand_amount", ((JSONArray)localObject3).toString());
            i = j;
            ((SharedPreferences.Editor)localObject1).commit();
            i = j;
          }
        }
        SharedPreferences.Editor localEditor;
        Object localObject2 = null;
      }
      catch (Exception localException1)
      {
        try
        {
          localObject1 = this.jdField_a_of_type_OrgJsonJSONArray.get(i).toString();
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
      paramHandler.postDelayed(new QzoneHbFragment.8(paramEditText), 100L);
    }
  }
  
  private void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131373768);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131373797));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373769));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131373766));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131373767));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131377327));
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131376935);
    this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(getActivity(), 2130772200);
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131367856);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetRollNumberView = ((RollNumberView)paramView.findViewById(2131373798));
  }
  
  private boolean a()
  {
    this.jdField_a_of_type_Int = ((alao)this.mQApp.getManager(245)).a("grap_hb_verify", 1, new String[] { "videoRedMinValue" });
    return Integer.valueOf(bmrq.a(this.jdField_b_of_type_JavaLangString)).intValue() >= this.jdField_a_of_type_Int;
  }
  
  public static boolean a(@Nullable Object paramObject)
  {
    if (paramObject != null)
    {
      if (!(paramObject instanceof Collection)) {
        break label25;
      }
      if (!((Collection)paramObject).isEmpty()) {
        break label35;
      }
    }
    label25:
    while (paramObject.toString().isEmpty()) {
      return true;
    }
    label35:
    return false;
  }
  
  private boolean b()
  {
    int i = this.jdField_a_of_type_AndroidWidgetEditText.getText().length();
    String str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    if ((i == 0) || (str.startsWith(".")) || (str.endsWith("."))) {}
    for (;;)
    {
      return false;
      if ((!TextUtils.isEmpty(str)) && (str.indexOf('.') != 0)) {
        if ((str.indexOf('.') > 0) && (str.indexOf('.') < str.length() - 3))
        {
          str = getString(2131696119);
          if (str != null)
          {
            this.mActivity.b(str);
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
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetRollNumberView.setLisener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences = getActivity().getPreferences(0);
    try
    {
      this.jdField_a_of_type_OrgJsonJSONArray.put("1.00");
      Bundle localBundle = getArguments();
      if (localBundle != null)
      {
        this.f = localBundle.getString("recv_name");
        this.g = localBundle.getString("feedsid");
        this.d = localBundle.getString("recv_uin");
        this.h = localBundle.getString("recv_type");
        if ((32768 == this.channel) && (!this.h.equals("1"))) {
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
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(aoot.a(this.mQApp, 1, this.d));
      this.jdField_a_of_type_Albk.postDelayed(new QzoneHbFragment.2(this), 10L);
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
  
  private void e()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((isAdded()) && (localFragmentActivity != null)) {
      this.jdField_c_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(new albj(this, localFragmentActivity));
    }
  }
  
  public int a(Context paramContext)
  {
    int i = 0;
    try
    {
      paramContext = paramContext.getResources();
      int j = paramContext.getIdentifier("navigation_bar_height", "dimen", "android");
      if (j > 0) {
        i = paramContext.getDimensionPixelSize(j);
      }
      return i;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return 0;
  }
  
  public int a(JSONArray paramJSONArray, int paramInt)
  {
    int m = 0;
    int k = 0;
    if ((paramJSONArray == null) || (paramJSONArray.length() <= paramInt) || (paramInt < 0)) {
      return 0;
    }
    int i = m;
    for (;;)
    {
      try
      {
        int i1 = paramJSONArray.length();
        j = 0;
        if (j >= i1) {
          break label142;
        }
        int n = (paramInt + j) % i1;
        i = m;
        int i2 = paramJSONArray.optInt(n);
        if (i2 == 0)
        {
          i = n;
          if (j != i1) {
            break label137;
          }
          j = k;
          if (j >= i1) {
            continue;
          }
        }
      }
      catch (Exception paramJSONArray)
      {
        int j;
        paramJSONArray.printStackTrace();
        return i;
      }
      try
      {
        paramJSONArray.put(j, 0);
        j += 1;
      }
      catch (Exception paramJSONArray)
      {
        continue;
      }
      j += 1;
      continue;
      i = paramInt;
      paramJSONArray.put(paramInt, 1);
      return paramInt;
      label137:
      paramInt = i;
      continue;
      label142:
      i = 0;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      if (this.channel == 32768) {}
      for (paramJSONObject = paramJSONObject.optJSONObject("mk_svideo_hb"); paramJSONObject != null; paramJSONObject = paramJSONObject.optJSONObject("mk_qzone_hb")) {
        try
        {
          this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("comment");
          this.jdField_a_of_type_OrgJsonJSONArray = paramJSONObject.optJSONArray("money_array");
          this.jdField_b_of_type_JavaLangString = a();
          if (!a(this.jdField_b_of_type_JavaLangString)) {
            this.jdField_c_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
          }
          paramJSONObject = this.jdField_a_of_type_Albk.obtainMessage();
          paramJSONObject.what = 100;
          this.jdField_a_of_type_Albk.sendMessage(paramJSONObject);
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
    getActivity();
    String str = alir.jdField_c_of_type_JavaLangString + this.e + "/hbThemeConfig.cfg";
    ThreadManager.getFileThreadHandler().post(new QzoneHbFragment.7(this, str));
  }
  
  public void complete()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QzoneHbFragment", 2, "complete---");
    }
    Message localMessage = this.jdField_a_of_type_Albk.obtainMessage();
    localMessage.what = 101;
    this.jdField_a_of_type_Albk.sendMessage(localMessage);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    Object localObject;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (isAdded())
      {
        try
        {
          ((InputMethodManager)getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_b_of_type_AndroidViewView.getWindowToken(), 0);
          this.mActivity.a();
          this.mActivity.finish();
          this.mActivity.overridePendingTransition(0, 0);
          if (this.channel == 32768) {
            continue;
          }
          this.mActivity.a(300, "rewardhongbao.wrap.close", 2);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
        if (!this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_AndroidWidgetButton.setText(anzj.a(2131710789));
          this.jdField_a_of_type_AndroidWidgetEditText.setEnabled(true);
          this.jdField_a_of_type_AndroidWidgetEditText.setFocusable(true);
          this.jdField_a_of_type_AndroidWidgetEditText.setText("");
          if (this.channel != 32768) {
            this.mActivity.a(300, "rewardhongbao.wrap.custom", 2);
          }
          a(this.jdField_a_of_type_Albk, this.jdField_a_of_type_AndroidWidgetEditText);
        }
        else
        {
          this.jdField_a_of_type_Boolean = false;
          this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_c_of_type_JavaLangString);
          this.jdField_a_of_type_AndroidWidgetEditText.setEnabled(false);
          this.jdField_a_of_type_AndroidWidgetButton.setText(anzj.a(2131710787));
          this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
          continue;
          long l = System.currentTimeMillis();
          if ((this.jdField_a_of_type_Long == 0L) || (System.currentTimeMillis() - this.jdField_a_of_type_Long >= 1000L))
          {
            this.jdField_a_of_type_Long = l;
            if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
              this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
            }
            localObject = this.mActivity.a();
            ((Map)localObject).put("total_num", "1");
            ((Map)localObject).put("total_amount", bmrq.a(this.jdField_b_of_type_JavaLangString));
            ((Map)localObject).put("wishing", "");
            ((Map)localObject).put("channel", this.channel + "");
            ((Map)localObject).put("feeds_name", this.f);
            ((Map)localObject).put("feeds_sid", this.g);
            if (this.channel != 32768) {
              break label621;
            }
            if (a()) {
              break;
            }
            localObject = bmrq.a(this.jdField_a_of_type_Int + "", 0, true);
            localObject = anzj.a(2131710790) + (String)localObject + anzj.a(2131710788);
            bhlq.a(getActivity(), 230, null, (CharSequence)localObject, null, getString(2131695657), new albh(this), null).show();
          }
        }
      }
    }
    if (this.h.equals("1"))
    {
      ((Map)localObject).put("channel", String.valueOf(1));
      ((Map)localObject).put("bus_type", "1");
    }
    for (;;)
    {
      ((Map)localObject).put("type", String.valueOf(1));
      label621:
      this.mLogic.a((Map)localObject);
      this.mActivity.overridePendingTransition(0, 0);
      if (this.channel == 32768) {
        break;
      }
      this.mActivity.a(300, "rewardhongbao.wrap.send", 2);
      break;
      ((Map)localObject).put("channel", String.valueOf(1024));
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.mActivity.getWindow().setSoftInputMode(32);
    paramLayoutInflater = paramLayoutInflater.inflate(2131562001, null);
    a(paramLayoutInflater);
    d();
    c();
    b();
    e();
    if (this.channel != 32768) {
      this.mActivity.a(300, "rewardhongbao.wrap.show", 2);
    }
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.QzoneHbFragment
 * JD-Core Version:    0.7.0.1
 */